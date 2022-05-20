# [4. Conventions d'appel](https://www.youtube.com/watch?v=ZpeMivhWuic)

+ [Introduction](#Introduction)
	+ [Sur Windows](#Sur-Windows)
	+ [Conventions d'appel](#Conventions-d-appel)
	+ [Sur Linux](#Sur-Linux)
+ [64 bits sur Windows](#64-bits-sur-Windows)
	+ [Convention Windows](#Convention-Windows)
	+ [GetStdHandle function](#GetStdHandle-function)
	+ [WriteConsoleA function](#WriteConsoleA-function)
	+ [ExitProcess](#ExitProcess)
+ [32 bits sur Windows](#32-bits-sur-Windows)
+ [64 bits sur Linux](#64-bits-sur-Linux)
	+ [Petit rappel sur les conventions utilisées](#Petit-rappel-sur-les-conventions-utilisées)
	+ [Les arguments](#Les-arguments)
	+ [Recherche des codes fonctions](#Recherche-des-codes-fonctions)
	+ [Write](#Write)
	+ [Exit](#Exit)
+ [32 bits sur Linux](#32-bits-sur-Linux)
+ [Clonclusion](#Clonclusion)

> ---

## Introduction

Prérequis : [Architecture](https://github.com/js202005082300/Aide-memoires/blob/main/Architecture/README.md)
    - Être capable de passer d'une base à l'autre (**convention de base numérique**)
    - Comprendre les différents segments lorsqu'un programme est exécuté (**mémoire virtuelle**)
    - Fonctionnement du processeur en introduction aux registres (**processeur**)
    - Registres indispensables pour le langage assembleur (**registres**)

### Sur Windows

Code minimal avec Hello World.

a64.asm
```asm
bits 64

extern GetStdHandle
extern WriteConsoleA
extern ExitProcess

section .data
	message db 'Hello World !', 10

section .bss
	written resq 1

section .text
	global main
	main:
		mov rcx, -11
		call GetStdHandle
		
		sub rsp, 32
		sub rsp, 8
		
		mov rcx, rax
		mov rdx, message
		mov r8, 13
		mov r9,	written
		mov qword [rsp+32], 0
		call WriteConsoleA
		
		add rsp, 32+8
		
		xor ecx, ecx
		call ExitProcess
```
c32.asm
```asm
bits 32

extern _GetStdHandle@4
extern _WriteConsoleA@20
extern _ExitProcess@4

section .data
	message db 'Hello World !', 10
	
section .bss
	written resd 1

section .text
	global main
	main:
		push -11
		call _GetStdHandle@4
		
		push 0
		push written
		push 13
		push message
		push eax
		call _WriteConsoleA@20
		
		push 0
		call _ExitProcess@4
```

On a parlé des différents segments `section` en relation avec le principe de mémoire virtuelle (=mémoire fournie aux différents programmes exécutés).

Les registres abordés en architecture : `rcx`, `rsp`, `rdx`, `r8`, `r9` et cetera.

Les variables seront vues plus tard : `message`, `written` et cetera.

On va voir les fonctions et on va parler de convetions d'appel.

### Conventions d appel

Une convetion d'appel fait partie de ce qu'on appelle **application binary interface (ABI)**.

Au niveau du système, pour une architecture donné et un compilateur donné (un compilateur peux fixer ses propres règles) on a des conventions pour l'appel des différentes fonctions.

Les fonctions appelées sur Windows : `GetStdHandle`, `WriteConsoleA`, `ExitProcess` avec `WriteConsoleA` qui permet d'écrire directment sur la console avec la version ANSI qui permet d'afficher de la chaîne de caractères. Et `ExitProcess` pour quitter le programme proprement.

Pareil avec les versions 32 bits : `_GetStdHandle@4`, `_WriteConsoleA@20` et `_ExitProcess@4`.

### Sur Linux

On a l'appel à right `mov rax, 1 ... syscall` puis l'appel à exit `mov rax, 60 ... syscall`. Pareil en 32.

c64.asm
```asm
bits 64

section .data
    message db 'Hello World !', 10

section .text
    global _start
    _start:
        mov rax, 1
        mov rdi, 1
        mov rsi, message
        mov rdx, 13+1
        syscall

        mov rax, 60
        mov rdi, 0
        syscall
```
c32.asm
```asm
bits 32

section .data
    message db 'Hello World !', 10

section .text
    global _start
    _start:
        mov eax, 4
        mov ebx, 1
        mov ecx, message
        mov edx, 13+1
        int 0x80

        mov eax, 1
        mov ebx, 0
        int 0x80
```

En plus de définir des conventions, on va indiquer l'ordre des arguments lors de l'appel à une fonction. Comment transmettre les arguments pour qu'ils arrivent au niveau des paramètres des différentes fonctions ?

En fonction des conventions utilisés, certains registres vont conserver leurs valeurs (**registre non-volatile**) et dans certaines conventions, il peut perdre sa valeur dans certaines conventions au moment ou on se sert du contenu dedans(**registre volatile**). On peut avoir dans certains cas le besoin de conserver le contenu de nos registres. Tout ceci est à prendre en compte au niveau des conventions d'appels.

Ici 4 architectures abordés sur Linux/Windows et on mettra de coté l'architecture 32 bits pour se concentrer sur le 64 bits.

## 64 bits sur Windows

a64.asm
```asm
bits 64

extern GetStdHandle
extern WriteConsoleA
extern ExitProcess

section .data
	message db 'Hello World !', 10

section .bss
	written resq 1

section .text
	global main
	main:
		mov rcx, -11
		call GetStdHandle
		
		sub rsp, 32
		sub rsp, 8
		
		mov rcx, rax
		mov rdx, message
		mov r8, 13
		mov r9,	written
		mov qword [rsp+32], 0
		call WriteConsoleA
		
		add rsp, 32+8
		
		xor ecx, ecx
		call ExitProcess
```

Au niveau des conventions, on a aussi la responsabilité de restaurer l'état de la pile.

On vera aussi la responsabilité de l'état de pile appartient à l'appelant. L'appelant est la partie du programme qui va faire l'appel aux fonctions.

La fonction appelée peut avoir dans certains cas la responsabilité de la restauration de la pile.

Par exemple, quelques instructions ici p/r à la pile suivi de la restauration :

```asm
sub rsp, 32
sub rsp, 8

...

add rsp, 32+8
```

Pour résumé, les conventions d'appels c'est pour avoir l'*ordre* et la *transmission* des différents arguments pour les paramètres d'une fonction. La *conservation* des registres, savoir s'ils sont volatiles ou non-volatiles. Et il faut avoir une idée de l'état, la préparation de la pile.

3 points essentiels suivant la convention **application binary interface (ABI)**, l'interface binaire-programme (=qui fait la liaison entre les deux) : 
    + Ordre et transmissions
    + Conservation des registres
    + État de la Pile

C'est une convention qui permet de lier le langage de programmation et le compilateur. L'architecture, le langage et le compilateur vont fonctionner ensemble.

Attention suivant le compilateur, les conventions d'appels ne sont pas forcément les mêmes.

Avec l'expérience, on devra utiliser les conventions d'appels en relations avec nos propres outils.

### Convention Windows

Différentes conventions pour Windows : au début la Microsoft64 puis utiliser pour produire une extension appelé **Vectorcall**.

**Vectorcall** est une convention utilisé avec Visual c++, utilisé avec les compilateurs Visual, avec GCC, les compilateurs Intel et le jeux de compilateurs CLion (ce dernier le plus fonctionnel sur un maximum de support).

Pour cette convention, lorsqu'il y a des entiers, on va suivre cette ordre-là : `rcx` comme 1e registre/argument pour la fonction `GetStdHandle` qui n'as besoin que d'un seul argument puis `rcx`/`rdx`/`r8`/`r9` pour la fonction `WriteConsoleA` lorsqu'il s'agit d'entier.

a64.asm
```asm
bits 64

extern GetStdHandle
extern WriteConsoleA
extern ExitProcess

section .data
	message db 'Hello World !', 10

section .bss
	written resq 1

section .text
	global main
	main:
		mov rcx, -11
		call GetStdHandle
		
		sub rsp, 32
		sub rsp, 8
		
		mov rcx, rax
		mov rdx, message
		mov r8, 13
		mov r9,	written
		mov qword [rsp+32], 0
		call WriteConsoleA
		
		add rsp, 32+8
		
		xor ecx, ecx
		call ExitProcess
```

Si on a besoin de travailler avec des flottants, on passe par les registres flottants présentés dans les vidéos d'[Architecture](https://github.com/js202005082300/Aide-memoires/blob/main/Architecture/README.md) notament XM0 jusqu'à XM3 suivant le nombre d'arguments et le type de données à passer.

4 arguments `rcx`/`rdx`/`r8`/`r9` pour la fonction `WriteConsoleA` avec un argument supplémentaire `qword` (5e argument pour notre fonction), et ces arguments sont passés sur la Pile dans un ordre bien précis car ils doivent être écrit de droite à gauche.

```asm
; name(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8)
mov rcx, rax
mov rdx, message
mov r8, 13
mov r9,	written
mov qword [rsp+32], 0
call WriteConsoleA
```

Si on suit la convention Vectorcall (anciennement Microsoft64), les 4 premiers arguments entiers doivent passer par les registres `rcx`/`rdx`/`r8`/`r9` sinon `xm0`/`xm1`/`xm2`/`xm3` si c'est des flottants ou alors un mélange des deux. Tous les arguments supplémentaires `arg5, arg6, arg7, arg8` doivent être passé sur la Pile de droite à gauche càd que le prochain argument à pousser sur la Pile sera l'argument n°8, ensuite le n°7 puis le n°6 et le n°5 pcq c'est le dernier élément à être placé sur la Pile qui est retiré lorsqu'on dépile.

Voilà le retour de la fonction est placé dans le registre `rax` si c'est un entier, c'est notre accumulateur. L'accumulateur sert comme curseur pour choisir une fonction particulière ou comme un retour. Le retour est placé dans `xm0` si c'est un flottant.

On verra pourquoi on le place dans `rcx`, `mov rcx, rax` ...

### [GetStdHandle function](https://docs.microsoft.com/en-us/windows/console/getstdhandle?msclkid=549e18a5cfd411ec9270cae67f96c128)

Le prototype.

```asm
HANDLE WINAPI GetStdHandle(
  _In_ DWORD nStdHandle
);
```

nStdHandle est un identifiant, un paramètre. `STD_INPUT_HANDLE ` est une constante représenté par la valeur `((DWORD)-10)`. `STD_OUTPUT_HANDLE` pour la sortie standard et `STD_ERROR_HANDLE` pour la sortie d'erreur standard.

`HANDLE` est le type de retour.

`DWORD` est le type. C'est un double word, un mot de 32 bits. `QWORD` est de 64 bits. Le mot tout seul c'est 16.

On se place sur le flux de sortie standard : `STD_OUTPUT_HANDLE` `((DWORD)-11)`. Le 1e argument doit être `rcx` p/r la convention d'appel grâce à l'instruction `mov` et ensuite l'appel à GetStdHandle qui fait partie de l'API de Windows avec les directive indiquées au début.

a64.asm
```asm
bits 64

extern GetStdHandle
extern WriteConsoleA
extern ExitProcess

section .data
	message db 'Hello World !', 10

section .bss
	written resq 1

section .text
	global main
	main:
		mov rcx, -11
		call GetStdHandle
		
		sub rsp, 32
		sub rsp, 8
		
		mov rcx, rax
		mov rdx, message
		mov r8, 13
		mov r9,	written
		mov qword [rsp+32], 0
		call WriteConsoleA
		
		add rsp, 32+8
		
		xor ecx, ecx
		call ExitProcess
```

:warning: ici ce ne sont pas des fonctions système comme on aurais sur Linux, on est sur une API qui viens en surccouche.

### [WriteConsoleA function](https://docs.microsoft.com/en-us/windows/console/writeconsole)

*A* à la fin pour la version ANSI et *W* (WriteConsoleW) si on veut travailler avec de l'unicode et cetera.

Plus de paramètres ici :
```asm
BOOL WINAPI WriteConsole(
  _In_             HANDLE  hConsoleOutput,
  _In_       const VOID    *lpBuffer,
  _In_             DWORD   nNumberOfCharsToWrite,
  _Out_opt_        LPDWORD lpNumberOfCharsWritten,
  _Reserved_       LPVOID  lpReserved
);
```

On nous dit qu'il faut passer par un gestionnaire qu'on prépare ici :
```asm
mov rcx, -11
call GetStdHandle
```
Le contenu est stocké dans `rcx` de l'appel à `GetStdHandle` qu'on place pour le prochain appel en premier argument de l'appel à fonction dans `rax`.
```asm
mov rcx, rax
mov rdx, message
mov r8, 13
mov r9,	written
mov qword [rsp+32], 0
call WriteConsoleA
```

Pour la convention d'appel, on a :
```asm
; rcx, rdw, r8, r9, pile (droite à gauche)
```
Par convention `rcx` était le premier et qui renvoie notre gestionnaire.


```asm
  _In_       const VOID    *lpBuffer,
```
Pointeur vers notre chaîne de caractère.

```asm
  _In_             DWORD   nNumberOfCharsToWrite,
```
Nombre de caractères que l'on veut écrire. Un `DWORD` de 32 bits maximum au niveau du codage de cette valeur.

Pour avoir une vérification du nombre de caractères éffectivement écrit.

```asm
  _Out_opt_        LPDWORD lpNumberOfCharsWritten,
```

On lui a passé une donnée qui n'était pas initialisée.

```asm
section .bss
	written resq 1
```

Le dernier argument qui est obligatoire, cette fonction a besoin d'un espace réservé.

```asm
  _Reserved_       LPVOID  lpReserved
```
```asm
mov qword [rsp+32], 0
```

C'est un espace fantôme. Besoin d'**alouer un espace fantôme de 32 octets sur la pile** avant d'appeler notre fonction.

On décale sur la pile l'espace d'allocation. C'est surtout pour faciliter le débogage pcq on a une information complète de ce qu'il se passe, pour une question de traçabilité et cela doit être respecté par convention.

C'est `qword` donc 64 bits et on rempli par des 0 car on veux juste allouer un espace vide et on se place sur la pile (`rsp` c'est le registre pour la pile) et on se décale à 32 pcq on ne doit rien écrire sur cet espace, c'est le fameux **espace fantome**. Simple petite addition pour se décaler de 32 octets.

On précise également dans la doc qu'il doit être à NULL.

:warning: il est de la responsabilité de l'appelant de réstaurer l'état de la pile.

```asm
add rsp, 32+8
```

On enlève l'espace alloué.

### ExitProcess

Une dernier cas permet de rendre une instruction plus rapide.

```asm
xor ecx, ecx
call ExitProcess
```

C'est-à-dire qu'au lieu de fixer un registre à 0, `mov <registre>, 0` qui est une opération un peu plus couteuse, on peut faire à la place `xor` (un ou exclusif) du registre sur le registre qui va fixer le registre à 0. Cela ne prend qu'un cycle CPU, c'est plus rapide.

Petite obtimisation sympa à faire.

Noté qu'on pouvait faire `xor ecx, ecx` (registre 32 bits) ou bien `xor rcx, rcx` (registre 64 bits). Ici on considère que pour mettre un registre à 0, le registre 32 bits suffit.

Voilà pour montrer qu'on peut mélanger des registres 32 bits avec des registres 64 bits.

Et bien sûr l'appel à `ExitProcess`.

Voilà beaucoup de chose à dire au niveau de cette convention.

Tout dépend de l'utilisation mais oté que certains registres sont volatiles ou pas càd `rax`, `rdx`, `r8` et `r9` sont forcément volatiles puisqu'on s'en sert et que les résultats peuvent changer notament pour l'accumulateur avec la valeur retour.

Pour la volatilité des registres, se renseigner sur la convention d'appels mais on ne va pas s'attarder sur un seul système d'exploitation.

Admetons que l'on doit travailler sur des données plus grande que 64 bits (128 et cetera), on peut travailler avec d'autres arguments tel que `xmm`, les `ymm`, les `zmm` si on est sur du 256 ou 512 bits si on travaille sur des très grosses valeurs (abordé dans la vidéo sur les Processeurs).

Noté également que les structures et unions sont considérées comme des entiers donc pas de distinction à ce niveau, sinon on remplacera par des pointeurs sans problème.

## 32 bits sur Windows

c32.asm
```asm
bits 32

extern _GetStdHandle@4
extern _WriteConsoleA@20
extern _ExitProcess@4

section .data
	message db 'Hello World !', 10
	
section .bss
	written resd 1

section .text
	global main
	main:
		push -11
		call _GetStdHandle@4
		
		push 0
		push written
		push 13
		push message
		push eax
		call _WriteConsoleA@20
		
		push 0
		call _ExitProcess@4
```

La convention est beaucoup plus simple càd qu'on travaille directement avec la Pile.

On place les éléments sur la Pile de droite à gauche avec `push`.

Ensuite on appelle la fonction qui va se charger elle-même de néttoyer la Pile et ensuite le retour de la fonction arrive bien dans l'accumulateur, cela ne change pas p/r à la version 64.

On utilise bien l'instruction `push` qui met sur la Pile et `pop` qui la retire.

`push 0` pour la veleur qui doit être à null et ensuite la valeur qui doit être éffectivement écrite `push written`, ensuite la taille `push 13` puis le message et ensuite `eax` pour avoir simplement le retour.

Ainsi donc tout est fait de droite à gauche, tout est fait à l'envers ainsi `eax` est le retour de `_WriteConsoleA@20` donc ses arguments sont :
+ le 1e est `push eax`
+ le 2e est `push message`
+ le 3e est `push 13`
+ le 4e est `push written`
+ le 5e est `push 0`

La deuxième fonction a la responsabilité de néttoyer la Pile :

```asm
push 0
call _ExitProcess@4
```

On commence par placer la valeur 0 sur la Pile pour dire que c'est la valeur de retour puis l'appel à `_ExitProcess`.

Cette convention d'appel est plus simple car on travail qu'avec la Pile essentiellement.

Si on travail sur des conventions plus compliqué, c'est parcequ'il y a nécessité de le faire et pcq on ne peut pas tout faire avec la Pile.

Cette convention d'appel fonctionne très bien avec GCC, on a vu avec vectorcall comment se passe la convention.

## 64 bits sur Linux

c64.asm
```asm
bits 64

section .data
    message db 'Hello World !', 10

section .text
    global _start
    _start:
        mov rax, 1
        mov rdi, 1
        mov rsi, message
        mov rdx, 13+1
        syscall

        mov rax, 60
        mov rdi, 0
        syscall
```

On est sur la convention systemV (amd64).

### Petit rappel sur les conventions utilisées

Pour rappel, Windows64 a donné vectorcall et pour le 32 bits, on utilise **stdcall** (standard call) qui est propre à GCC et fonctionne très bien.

```asm
; Windows x64 -> vectorcall
; stdcall
```

Alors que sur Linux, on utilise System V.

```asm
; System V AMD64
```

:warning: ce n'est parce que c'est marqué AMD que cela fonctionne que sur les processeur AMD et par sur les processeurs Intel. Ce sont juste des notations historiques sans problème de compatilibité.

Pour un jeux d'instructions spécifiques, tout est évidemment compatible.

### Les arguments

Ce système fonctionne avec tout les compilateur *GCC*, *CLion*, les compilateurs Intel et cetera.

On commence par gérer les premiers arguments `rdi`, `rsi` et `rdx` ensuite `r8`, `r9` et cetera.

```asm
; rdi, rsi, rdx, rcx, r8, r9
```

`rdi` est la destination index.
`rsi` est la source index.
`rdx` pour les données.
`rcx` si on a besoin d'un compteur.
`r8` et `r9` si besoin de plus.

Ce sont pour les 6 premiers arguments qui seraient des entiers.

On pourrais avoir `r10` si besoin d'un **pointeur de chaîne statique** mais on ne l'a pas encore abordé.

Si on a besoin de valeurs flottantes, on utilisera tout les registres prévus pour ça `XMM0` à `XMM7` ou éventuellement `YMM` si on est sur du 256 ou `ZMM` sur du 512 bits.

Tout les arguments supplémentaires vont être empilés de droite à gauche.

```asm
; rdi, rsi, rdx, rcx, r8, r9, pile (droite à gauche)
```

Voilà pour Linux, on a un peu plus de registres disponibles.

Le retour se fera dans l'accumulateur, pas de changement.

```asm
; retour dans rax (64 bits) ou rax + rdx (128 bits)
```

Si on a besoin d'un retour plus grand `rdx` peut servir conjointement avec l'accumulateur si on a besoin d'un retour fonction.

Voilà ne pas oublier que les retours des flottant c'est `XMM0` et `XMM1` (ou `YMM0` et `YMM1` ou `ZMM0` et `ZMM1` en fonction de la taille que l'on veut).

La gestion de la Pile est à gérée avec l'appelant donc c'est l'appelant qui va se charger du néttoyage de la Pile si besoin de la remettre en état càd retirer de la Pile ce qui a été mis dessus.

Maintenant il faut comprendre comment fonctionne les appels systèmes, on a donc un appel à Write :

```asm
mov rax, 1
mov rdi, 1
mov rsi, message
mov rdx, 13+1
syscall
```

Puis un appel à Exit :

```asm
mov rax, 60
mov rdi, 0
syscall
```

Les appels système en recherchant Syscall puis sur la doc depuis les distributions Linux, dans certains fichiers sources.

Par exemple, on va rechercher un site avec *Syscall write* au pif.

> Par exemple, [Syscall write assembly](#https://www.tutorialspoint.com/unix_system_calls/write.htm)

Le prototype est :

```asm
ssize_t write(int fd, const void *buf, size_t count); 
```

Pour les appels systems, quels fonctions appelées car sur Windows, on a des fonctions propres à une API ci-dessous:

a64.asm
```asm
bits 64

extern GetStdHandle
extern WriteConsoleA
extern ExitProcess
```

Tandis que sur Linux, on n'écrit pas `_GetStdHandle` ou `_WriteConsoleA` ou `_ExitProcess` càd qu'on utilise l'instruction `syscall` en 64 bits et en 32 bits, on passe par une interruption en hexadécimale `ìnt 0x80` qui permet de faire un appel système en fonction des registres précédents qui permettrons de savoir quel fonction doit être appelée.

```asm
mov rax, 1
mov rdi, 1
mov rsi, message
mov rdx, 13+1
syscall
```

Pour cela, on se sert de l'accumulateur càd qu'à chaque fois au début j'ai `rax` (64 bits) et `eax` (32 bits).

En fonction de la valeur de l'entier, le numéro que l'on met dedans, c'est le numéro de la fonction en question :

```asm
mov rax, 1
; ...

mov rax, 60
; ...
```

### Recherche des codes fonctions

On doit retrouver normalement le numéro propre aux appels systèmes ici :

```shell
linux@linux:~$ whereis unistd.h
unistd: /usr/include/unistd.h
linux@linux:~$ cat /usr/include/unistd.h
linux@linux:~$ code /usr/include/unistd.h
```

On y voit notamment les descripteurs :
```h
#define STDIN_FILEND 0 	/* Standard input. */
#define STDOUT_FILEND 1 /* Standard output. */
#define STDERR_FILEND 2 /* Standard error output. */
```

On y retrouve également la signature :
```h
extern ssize_t pwrite (int __fd, const void *__buf, size_t __n, __off_t __offset) __wur;
```

Apparement on n'y retrouve pas les code.

On va voir plutôt ici : [Linux System Call Table for x86 64](http://blog.rchapman.org/posts/Linux_System_Call_Table_for_x86_64/)

![](img/table_01.png)

Voilà où sont définis les numéro avec l'appel à write qui est défini avec 1.

Ce sont les codes d'identifications de fonctions.

Le numéro 60 pour Exit.

![](img/table_02.png)

On commence donc par fixer sur l'accumulateur `mov rax, 1`, le numéro de fonction que je veux utiliser.

### [Write](https://man7.org/linux/man-pages/man2/write.2.html)

En recherchant *Write 2 man* dans Google on retrouve le description de la fonction :

```
ssize_t write(int fd, const void *buf, size_t count);
```

Le 1e paramètre `int fd` c'est le descripteur de fichier, si on est en sortie, en erreur, en entrée. C'est le code 1 pour utiliser la sortie d'erreur standard.

Le 2e argument (rdi) `mov rdi, 1` pour l'appel à notre fonction.

Puis le pointeur (rsi) vers le tampon du message que l'on veut afficher, `const void *buf`.

Puis la longueur de la chaîne (rdx) qui va être écrire soit 13+1 pour le caractère de fin.

Puis l'appel système (syscall) qui va lancer l'interruption pour faire l'appel proprement à write qui a été définis plus haut.
```asm
mov rax, 1
mov rdi, 1
mov rsi, message
mov rdx, 13+1
```

c64.asm
```asm
bits 64

section .data
    message db 'Hello World !', 10

section .text
    global _start
    _start:
		; rdi, rsi, rdx, rcx, r8, r9, pile (droite -> gauche)
		; retour dans rax
        mov rax, 1
        mov rdi, 1
        mov rsi, message
        mov rdx, 13+1
        syscall

        mov rax, 60
        mov rdi, 0
        syscall
```

### Exit

On place dans l'accumulateur, l'identifiant de exit càd le code 60 et ensuite comme on fait un `exit 0` et bien on place 0 dans rdi.

c64.asm
```asm
mov rax, 60
mov rdi, 0 ; xor rdi, rdi
syscall
```

Pour rappel, on aurait pû optimiser en faisant `xor rdi, rdi` pour aller plus vite.

Enfin on fait un petit appel système `syscall` pour utiliser la commande Exit.

Sur Linux, on a beaucoup de code à écrire et donc les conventions qui sont rattachées à Microsoft, comme on passe par une API cela rajoute pas mal de chose aussi.

Voilà pour x64 sur Linux.

## 32 bits sur Linux

c32.asm
```asm
bits 32

section .data
    message db 'Hello World !', 10

section .text
    global _start
    _start:
		; ebx, ecx, edx, esi, edi, ebp
        mov eax, 4
        mov ebx, 1
        mov ecx, message
        mov edx, 13+1
        int 0x80

        mov eax, 1
        mov ebx, 0
        int 0x80
```

Par convention, on va retrouver pour Write : `ebx`, `ecx`, `edx`, `esi`, `edi`, `edp`. Voilà on travaillera principalement dans cet ordre et avec les 4 premiers. C'est un peu pareil au niveau des registres et l'interruption en 32 bits `int 0x80` pour provoquer l'appel système.

Le code de Write en 32 bits, c'est 4. On utilisait 1 en 64 bits.

Ensuite pour l'appel à Exit, on passe le code 1, on place 0 pour le premier argument `mov ebx, 0` pour dire qu'on fait un `Exit 0`. Et on termine via un appel système par l'intérruption `int 0x80`.

## Clonclusion

Nous n'avons pas tout aborder, on aurait pu parler de fastcall, syscall, cdicl, hotline et cetera. Il y a en a plus propre à un système aussi.

La convention vue fait l'objet d'une interface binaire programme qui définit la convention pour lier l'architecture (64, 32 et cetera) à un langage de programmation et un compilateur donc il existe une multitude de conventions/compilateurs.

On a vu des conventions appliqués aux 4 architectures vues et après on travaillera sur d'autres conventions si on aborde du ARM, du MIPS et cetera.

Alors on vera comment lire de la donnée et cetera.

Ciao