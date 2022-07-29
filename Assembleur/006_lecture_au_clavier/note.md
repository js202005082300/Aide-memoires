# [6. Lecture au clavier](https://www.youtube.com/watch?v=Pq1kWf2lUpk)

+ [Introduction](#Introduction)
+ [Lecture de données (Windows)](#Lecture-de-données---Windows)
+ [Lecture de données (GNU/Linux)](#Lecture-de-données---Linux)
+ [Conclusion](#Conclusion)

## Introduction

Sur Windows et Linux, architecture en 64 bits.

```asm
extern GetStdHandle
extern WriteConsoleA
extern ExitProcess

STD_OUTPUT_HANDLE: equ -11
SHADOWSPACE_SIZE: equ 32 + 8

section .data

section .bss

section .text
    global main
    main:
        ;---------------------------------------------------------------------
        sub rsp, SHADOWSPACE_SIZE
        ;---------------------------------------------------------------------

        ; code...

        ;---------------------------------------------------------------------
        add rsp, SHADOWSPACE_SIZE
        ;---------------------------------------------------------------------

        xor rcx, rcx
        call ExitProcess
```

Pour le code, pas grand chose à part `SHADOWSPACE_SIZE` pour la gestion au niveau de la pile.

## Lecture de données - Windows

Pour Windows, on utilise la fonction `ReadConsoleA` et une constance à -10 pour la lecture `STD_INPUT_HANDLE: equ -10`.

On affiche un petit message : `message: db "Quel est ton nom ? "` `MESSAGE_LENGTH: equ $-message`

Puis l'appel de written alors que dans la vidéo précédente, on avait un Q-Word un quatruple mot `resq` alors que ça a juste besoin d'un mot en 32 bits `resd` donc pas besoin d'autant : `written: resd 1`

Ensuite on fait de l'écriture `mov rcx, STD_OUTPUT_HANDLE` en lui passant une constante puis `call GetStdHandle`qui permet de récupérer le gestionnaire que l'on veut sur le bon flux, ici le flux de sortie.

Même principe pour la lecture et l'affichage avec `mov` et `call` où on copie pour gérer le passage en écriture puis en lecture avec les constantes **STD_OUTPUT_HANDLE** et **STD_INPUT_HANDLE** pour la gestion des flux.

+ Demande de saisie

Pour l'écriture (OUTPUT soit la demande de saisie) On fait un `mov rcx, rax` avec `rax` qui récupère le retour de la fonction `GetStdHandle` d'après les conventions d'appels.

Après on peut mettre le message, on peut mettre le message dans `rdx` avec r8 qui prend une constante, r9 qui prend l'espace réservé written et au niveau de la pile `qword` avec le **SHADOWSPACE_SIZE** réservé que l'on met à 0 pour passer null.
```
        mov rcx, rax
        mov rdx, message
        mov r8, MESSAGE_LENGTH
        mov r9, written
        mov qword [rsp + SHADOWSPACE_SIZE], 0
        call WriteConsoleA
```

On peut lui passer 0 mais on peut également créer une constante `NULL: equ 0` comme on utilise pas mal cette valeur :
```
        NULL: equ 0

        ;...


        mov rcx, rax
        mov rdx, message
        mov r8, MESSAGE_LENGTH
        mov r9, written
        mov qword [rsp + SHADOWSPACE_SIZE], NULL
        call WriteConsoleA
```

Et on termine par l'appel à `call WriteConsoleA`.

```asm
bits 64

extern GetStdHandle
extern WriteConsoleA
extern ReadConsoleA
extern ExitProcess

STD_OUTPUT_HANDLE: equ -11
STD_INPUT_HANDLE: equ -10
SHADOWSPACE_SIZE: equ 32 + 8
NULL: equ 0

section .data
    message: db "Quel est ton nom ? "
    MESSAGE_LENGTH: equ $-message

section .bss
    written: resd 1

section .text
    global main
    main:
        ;---------------------------------------------------------------------
        sub rsp, SHADOWSPACE_SIZE
        ;---------------------------------------------------------------------

        ; Demande saisie
        mov rcx, STD_OUTPUT_HANDLE
        call GetStdHandle

        mov rcx, rax
        mov rdx, message
        mov r8, MESSAGE_LENGTH
        mov r9, written
        mov qword [rsp + SHADOWSPACE_SIZE], NULL
        call WriteConsoleA

        ; Lecture au clavier
        mov rcx, STD_INPUT_HANDLE
        call GetStdHandle

        ; Affichage de la saisie
        mov rcx, STD_OUTPUT_HANDLE
        call GetStdHandle

        ;---------------------------------------------------------------------
        add rsp, SHADOWSPACE_SIZE
        ;---------------------------------------------------------------------

        xor rcx, rcx
        call ExitProcess
```

+ Lecture au clavier

L'affichage du résultat sera pratiquement le copier-coller de l'appel à `WriteConsoleA`. 

Au niveau de cette fonction, on retrouve les mêmes paramètres.

Je rapelle qu'on récupère du gestionnaire `GetStdHandle` dans `rax` en flux de lecture.

```
        ; Lecture au clavier
        mov rcx, STD_INPUT_HANDLE
        call GetStdHandle

        mov rcx, rax
```

On passe sur `rdx` un mot résurvé `username: resb` et pour rester sur des octets (1 caractère = 1 octet) avec `resb` donc on part sur une constante `USERNAME_MAX_LENGTH` (ici on verra la différence entre Windows et Linux) donc ici je vais prendre en compte 10 caractères au clavier mais en prenant en compte les retours à la ligne. Sur Windows, les retours à la ligne est prit par 2 caractères `\n\r` donc une taille de buffer de 12 pour lire 10 caractères max en comptant le fait d'appuyer sur la touche entré à la fin.

On l'utilise dan r8 `mov r8, USERNAME_MAX_LENGTH`. On l'utilise dans `username: resb USERNAME_MAX_LENGTH` pour réservé 12 octets et prendre en compte le retour à la ligne.

```
section .data
    ;...
    USERNAME_MAX_LENGTH: equ 12

section .bss
    ;...
    username: resb USERNAME_MAX_LENGTH

;...
        ; Lecture au clavier
        mov rcx, STD_INPUT_HANDLE
        call GetStdHandle

        mov rcx, rax
        mov rdx, username
        mov r8, USERNAME_MAX_LENGTH
```

On retrouve le même schéma avec `rdx` qui sert de buffer puis la taille de ce qu'on veut lire `r8` et ensuite ce que nous avons éffectivement lu `r9`. Ensuite comme on a fait une variable *written*, je fait une variable *read* et je réserve 1.

```
section .bss
    written: resd 1
    read: resd 1
;...
        ; Lecture au clavier
        mov rcx, STD_INPUT_HANDLE
        call GetStdHandle

        mov rcx, rax
        mov rdx, username
        mov r8, USERNAME_MAX_LENGTH
        mov r9, read
        mov qword [rsp + SHADOWSPACE_SIZE], NULL
        call ReadConsoleA
```

Puis on termine par la même chose (qword ... ReadConsoleA).

```asm
bits 64

extern GetStdHandle
extern WriteConsoleA
extern ReadConsoleA
extern ExitProcess

STD_OUTPUT_HANDLE: equ -11
STD_INPUT_HANDLE: equ -10
SHADOWSPACE_SIZE: equ 32 + 8
NULL: equ 0

section .data
    message: db "Quel est ton nom ? "
    MESSAGE_LENGTH: equ $-message
    USERNAME_MAX_LENGTH: equ 12

section .bss
    written: resd 1
    read: resd 1
    username: resb USERNAME_MAX_LENGTH

section .text
    global main
    main:
        ;---------------------------------------------------------------------
        sub rsp, SHADOWSPACE_SIZE
        ;---------------------------------------------------------------------

        ; Demande saisie
        mov rcx, STD_OUTPUT_HANDLE
        call GetStdHandle

        mov rcx, rax
        mov rdx, message
        mov r8, MESSAGE_LENGTH
        mov r9, written
        mov qword [rsp + SHADOWSPACE_SIZE], NULL
        call WriteConsoleA

        ; Lecture au clavier
        mov rcx, STD_INPUT_HANDLE
        call GetStdHandle

        mov rcx, rax
        mov rdx, username
        mov r8, USERNAME_MAX_LENGTH
        mov r9, read
        mov qword [rsp + SHADOWSPACE_SIZE], NULL
        call ReadConsoleA

        ; Affichage de la saisie
        mov rcx, STD_OUTPUT_HANDLE
        call GetStdHandle

        ;---------------------------------------------------------------------
        add rsp, SHADOWSPACE_SIZE
        ;---------------------------------------------------------------------

        xor rcx, rcx
        call ExitProcess
```

+ Affichage de la saisie

C'est comme la Demande de la saisie sauf qu'on veut afficher ce qu'on a écrit *username* au lieu de *message* et limiter l'affichage à *USERNAME_MAX_LENGTH* au lieu de *MESSAGE_LENGTH*. On est toujours sur written et le reste ne change pas.

```
        mov rcx, rax
        mov rdx, username ;mov rdx, message
        mov r8, USERNAME_MAX_LENGTH ;mov r8, MESSAGE_LENGTH
        mov r9, written
        mov qword [rsp + SHADOWSPACE_SIZE], NULL
        call WriteConsoleA
```

On test :

```asm
bits 64

extern GetStdHandle
extern WriteConsoleA
extern ReadConsoleA
extern ExitProcess

STD_OUTPUT_HANDLE: equ -11
STD_INPUT_HANDLE: equ -10
SHADOWSPACE_SIZE: equ 32 + 8
NULL: equ 0

section .data
    message: db "Quel est ton nom ? "
    MESSAGE_LENGTH: equ $-message
    USERNAME_MAX_LENGTH: equ 12

section .bss
    written: resd 1
    read: resd 1
    username: resb USERNAME_MAX_LENGTH

section .text
    global main
    main:
        ;---------------------------------------------------------------------
        sub rsp, SHADOWSPACE_SIZE
        ;---------------------------------------------------------------------

        ; Demande saisie
        mov rcx, STD_OUTPUT_HANDLE
        call GetStdHandle

        mov rcx, rax
        mov rdx, message
        mov r8, MESSAGE_LENGTH
        mov r9, written
        mov qword [rsp + SHADOWSPACE_SIZE], NULL
        call WriteConsoleA

        ; Lecture au clavier
        mov rcx, STD_INPUT_HANDLE
        call GetStdHandle

        mov rcx, rax
        mov rdx, username
        mov r8, USERNAME_MAX_LENGTH
        mov r9, read
        mov qword [rsp + SHADOWSPACE_SIZE], NULL
        call ReadConsoleA

        ; Affichage de la saisie
        mov rcx, STD_OUTPUT_HANDLE
        call GetStdHandle

        mov rcx, rax
        mov rdx, username
        mov r8, USERNAME_MAX_LENGTH
        mov r9, written
        mov qword [rsp + SHADOWSPACE_SIZE], NULL
        call WriteConsoleA

        ;---------------------------------------------------------------------
        add rsp, SHADOWSPACE_SIZE
        ;---------------------------------------------------------------------

        xor rcx, rcx
        call ExitProcess
```
```ps1
nasm -f win64 main.asm -o main.obj
.\GoLink.exe main.obj /entry main /console kernel32.dll
.\main.exe

Quel est ton nom ? Samuel
Samuel

> .\main.exe
Quel est ton nom ? AZERTYUIOP
AZERTYUIOP
>

> .\main.exe
Quel est ton nom ? AZERTYUIOPQ
>
```

Voilà si on prend 11 caractères, ça n'affiche rien car besoin de 2 caractères sur les 12 pour le caractère de retour à la ligne.

Nous n'avons pas encore vu les structures conditionnelles donc on est assez limité pour les vérifications.

Voilà pour Windows, on récupère une chaîne en lisant des octets `username: resb USERNAME_MAX_LENGTH` (resb).

Pour faire des opérations arithmétiques, on vera comment cela fonctionne.

## Lecture de données - Linux

A contrario de Windows `\n\r`, un seul caractère `\n` pour le retour à la ligne sous Linux donc 11 permet de lire 10 caractères.

```asm
bits 64

STDOUT: equ 1
STDIN: equ 0

section .data
    message: db "Quel est ton nom ? "
    MESSAGE_LENGTH: equ $-message
    USERNAME_MAX_LENGTH: equ 11

section .bss
    username: resb USERNAME_MAX_LENGTH

section .text
    global _start
    _start:
        ; Demande de saisie
        mov rax, 1
        mov rdi, STDOUT
        mov rsi, message
        mov rdx, MESSAGE_LENGTH
        syscall

        ; Lecture au clavier
        mov rax, 0
        mov rdi, STDIN
        mov rsi, username
        mov rdx, USERNAME_MAX_LENGTH
        syscall

        ; Affichage de la saisie
        mov rax, 1
        mov rdi, STDOUT
        mov rsi, username
        mov rdx, USERNAME_MAX_LENGTH
        syscall

        ; Quitte le programme
        mov rax, 60
        xor rdi, rdi
        syscall
```
```bash
$ nasm -f elf64 main.asm -o main.o
$ ld main.o -o prog
$ ./prog
Quel est ton nom ? Samuel
Samuel

$ ./prog
Quel est ton nom ? AZERTYUIOP
AZERTYUIOP

$ ./prog
Quel est ton nom ? AZERTYUIOPQ
AZERTYUIOPQsam@sam-VirtualBox:~/Desktop/ASM$ 

$ ./prog
Quel est ton nom ? AZERTYUIOPQSDFGHJKLM
AZERTYUIOPQsam@sam-VirtualBox:~/Desktop/ASM$ SDFGHJKLM
SDFGHJKLM: command not found
```

Voilà le comportement avec 11 caractères, il va interrompre la lecture par contre il laisse les caractères restant dans le flux d'ailleurs il va même considérer que tout ce qui dépasse est une commande.

Par la suite on verra les structures conditionnelles.

## Conclusion

On a vu précédemment comment utiliser les variables dont on se sert dans cette vidéo avec en plus la lecture au clavier.

Bye bye
