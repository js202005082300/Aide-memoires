# [GCC - compilation en C/C++](https://www.youtube.com/watch?v=gr44z0Fyx_Y)

Bonjour à tous dans cette vidéo, nous allons parler de gcc ou de GNU Compiler Collection qui comme son nom l'indique regroupe un ensemble d'outils qui vont permettre de faire de la compilation.

Faut savoir qu'au départ, on parlais véritablement de compilation pour un programme écrit avec le langage c et par la suite d'autres langages ont été supportés avec des ajouts, des améliorations et des extensions et maintenant le projet forme véritablement une collection de tout un tas d'outils de compilation pour plusieurs langages différents.

Pour des raisons évidentes et puisque vous avez vous avez travaillez, vous avez abordé, vous avez utilisé cet outil sur la chaîne nous nous contenterons bien sûr des langages c et c++ pour ce que j'ai à vous montrer dans cette vidéo.

Pour cela nous allons reprendre tout simplement un petit code en c, **main.c**

+ main.c
```c
#include "other.h"
#include <stdio.h>

#define TAB_SIZE 5

int main(void)
{
    Point surface[TAB_SIZE] = {0};
    Point a = {14, 8};
    Point b = {127, 36};

    draw(surface, a);
    draw(surface, b);

    printf("Rendu termine !\n");

    return 0;
}
```

Il n'y a pas besoin de faire l'équivalent en c++ puisque l'outil va fonctionner de la même manière par rapport à ce que je vous explique ici donc très rapidement, évidemment si vous ne comprenez pas ce code même si ce n'est pas tellement problématique pour ce que j'ai à vous expliquer vous avez bien sûr le cours en c pour aborder toutes les choses qui sont montrées ici.

On a le fichier principal avec la fameuse fonction `main` qui est le point d'entrée de notre programme, **other.c**

+ other.c
```c
#include "other.h"
#include <stdio.h>

/**
* Dessine un point sur la surface
* @param p le point à dessiner
*/
void draw(Point surface[], Point p)
{
    // "Simule" dessin d'un point...
    printf("Point en position (%d/%d)\n", p.x, p.y);
}
```

On a ici un fichier source supplémentaire qui est une implémentation en fait par rapport à ce fichier d'en-tête là, **other.h**.

+ other.h
```c
#if !defined(__OTHER__)
#define __OTHER__

/* Définition d'un point sur une surface 2D */
typedef struct Point
{
    int x;
    int y;
} Point;

/* Fonctions */
void draw(Point surface[], Point p);

#endif
```

Ce fichier contient la définition d'une petite structure et un prototype d'une seule fonction qui a été écrite.

Voilà c'était simplement pour avoir un peu de matière en fait à vous montrer.

Il y a les exemples qui vont suivre, quelque chose d'un peu plus on va dire complet qu'un simple Hello world ! en fait dans la fonction mais on va partir là dessus.

Cette vidéo va être en deux parties d'accord je vais vous parler d'abord de ce qu'on appelle la compilation au sens globalement mais on va rentrer un petit peu plus dans les détails c'est à dire que jusqu'à présent au niveau des vidéos de programmation, des cours de programmation aborder sur la chaîne en c, en c++ notamment je vous fais tout simplement compiler vos programmes d'accord vous exécuter une seule commande et depuis vos codes sources, votre code source vous obtenez un programme qui est exécutable, choses très importantes à relever et vous pouvez ainsi exécuter votre programme sur votre machine d'accord.

En réalité vous allez voir qu'il y a plusieurs étapes qui interviennent derrière tout ça et on va on les détailler ensemble sans trop entrer non plus dans les aspects techniques puisque tout ce qui est vraiment très très technique sur l'architecture, etc vous vous le retrouverez ou vous pouvez le retrouver, ça dépend évidemment du moment où vous regardez cette vidéo sur la playlist d'architecture donc vous pourrez éventuellement aller voir un petit peu ce qui a été publié sur celle ci en fonction de ce qui vous intéresse.

Ici on va vraiment se concentrer sur la compilation d'un programme en c ou en c++ pour voir un petit peu ce qui se passe et il y a une 2e partie en fait qui concerne simplement un usage un petit peu plus important à mon sens du compilateur gcc avec des habitudes que vous devrez prendre dès maintenant et des choses que je ne montre pas forcément dans chaque vidéo parce que j'essaye forcément de gagner aussi du temps et de ne pas forcément revenir toujours et toujours sur les mêmes choses et vous pourrez comme ça à adopter de bonnes habitudes par la suite si vous faites des projets en c ou en c++.

## Partie 1

> Les étapes de compilation

Ok alors on va d'abord détailler par étape ce qui se passe en réalité.

Jusqu'à présent la commande très simple d'accord qui nous permettrait d'exécuter notre programme tel qu'on a pu le voir en faite au préalable, on fait donc gcc puis on précise éventuellement tous les fichiers sources mais on peut éventuellement utiliser le symbole * pour dire tous les fichiers portant l'extension point c `gcc *.c` et ensuite on précise un fichier de sortie que j'appelle par exemple prog d'accord et ensuite tu peux l'exécuter etc, etc.

```
C:\Users\sam\Desktop\c>gcc *.c -o prog
C:\Users\sam\Desktop\c>prog
Point en position (14/8)
Point en position (127/36)
Rendu termine !
```

Et voilà !

Petite parenthèse gcc est installé, je vous l'ai fais installer via le projet mingw si vous êtes sur windows.

Pour GNU linux et MacOS il est généralement présents par défaut sur votre système puisque votre système l'utilise notamment pour la compilation de certains paquets.

Au niveau de cette compilation c'est à dire que généralement vous avez peut-être suivi le cours en c, le cours en c++, vous avez à appris à faire cette commande `gcc *.c -o prog`.

Voilà je ne vous ai pas spécialement donné de détails là dessus comprenez que la compilation c'est encore tout un autre domaine que la programmation voilà d'autres choses supplémentaires.

On va entrer un peu plus dans les détails cette fois-ci pour voir en fait qu'on peut aller un peu plus loin.

En réalité quand on parle ici de compilation, on parle bien de compiler dans ce cas précis un programme écrit en langage c d'accord et vous allez voir que pour passer de ce code source à un programme exécutable d'accord qui a été créé à la base en langage c on va passer par quatre étapes successives.

### 1e preprocessing

La première étape très importante c'est le **preprocessing** (terme anglais, pas toujours d'équivalent en français). C'est en fait simplement un prétraitement d'accord un traitement initial va permettre une première étape au niveau de vos codes.

Alors on va l'exécuter notamment et on va en fait décomposer un petit peu certaines commandes avec gcc pour en fait arrêter c'est à dire que si on reprend la commande ici `gcc *.c -o prog` il va exécuter en fait les quatre étapes à la suite et même il va faire appel à d'autres programmes c'est à dire qu'en cours de route il va faire appel à d'autres programmes et pas seulement à lui même d'accord il n'y a pas seulement gcc en réalité qui entre en compte quand on fait ce genre de code mais vous avez vu jusqu'à présent vous ne le voyez pas c'était transparent et ça ne vous empêchait pas de toutes façons de compiler vos programmes et de faire de la programmation donc c'est ça aussi l'intérêt derrière.

Voilà on n'est pas forcément obligé de tout comprendre non plus pour que ça fonctionne.

A partir de là on va nous simplement utiliser des commandes pour décomposer c'est à dire de dire d'arrêter en fait les manipulations à partir de telle étape donc on va par exemple se contenter de n'exécuter que la première étape notamment l'étape de *prétraitement* d'accord.

Pour cela avec l'outil gcc vous allez ajouter un autre argument qui est tiret grand E comme ceci **-E** et on va le faire sur other.h parce qu'il a un fichier d'en-tête qui est joint ce sera plus intéressant pour montrer visuellement ce que ça donne `gcc -E other.c -o other.i` avec tiret o parce que sinon tout va être affiché dans la console et c'est parce que je veux que ce soit enregistrés dans un fichier en sortie je vais l'appeler avec le même nom et l'extension i. 

```powershell
gcc -E other.c -o other.i # l'option -E décompose les étapes de prétraitement et l'option -o pour enregistrer le résultat dans un fichier de sortie.
```

Voilà normalement ça m'a créé un nouveau fichier et nous allons l'ouvrir, voilà ce que ça nous donne càd qu'on passe d'un fichier qui faisait 12 lignes et on se retrouve avec un fichier qui en fait un peu plus de 900 ligne d'accord que s'est il passé au niveau de cette première étape, le preprocessing ?

On remarque que cette première étape (on abordera plus en détail en architecture) va *supprimer les commentaires* d'accord les commentaires je rappelle c'est simplement utiles pour le développeur ça vous aide pour la lisibilité de votre code, pour le documenter donc ça n'a absolument aucun intérêt par la suite pour les outils informatiques qui vont faire de la compilation et du traitement dessus, qui vont de toute façon ne pas analyser vos commentaires.

Voilà ils seront simplement ignoré donc cette étape supprime les commentaires donc on ne trouve donc plus de commentaire par rapport à ce que j'ai marqué tout à l'heure d'accord.

Autre point important ensuite nous avons et vous je pense que là c'est finalement visible l'ajout de tout un tas de choses ce qui a été ajouté ici en l'occurrence ce sont *les fichiers d'en-tête ajoutés* par rapport à ce qui est utilisé.

Alors si j'ai pris cet exemple-là, c'est parce qu'ici nous avons un premier fichier d'en-tête qui est local ici, other.h et ce fichier voyez ce code puisqu'on fait ici un include il a tout simplement été ajouté donc il en fait partie.

On retrouve sans les commentaires (c'est ça que j'ai mis des commentaires un peu partout), on retrouve la définition de nos structures.

```c
typedef struct Point
{
    int x;
    int y;
} Point;
```

On a ensuite le prototype de la fonction draw().

```c
void draw(Point surface[], Point p);
```

Si je descends parce que pour le moment tout le reste entre ne nous intéresse pas spécialement on retrouve l'implémentation source de la fonction draw().

```c
# 8 "other.c"
void draw(Point surface[], Point p)
{

    printf("Point en position (%d/%d)\n", p.x, p.y);
}
```

Voilà alors on ne retrouve pas le contenu de main parce qu'encore une fois je n'ai pas utilisé ça sur le fichier main.c

Il faudrait bien sûr le faire par fichier source donc si je fais la même chose sur le fichier main.c je vais retrouver évidemment là dessus dans un autre fichier que celui ci.

Ensuite dans main.i on retrouve simplement les fichiers d'en-têtes.

```c
__attribute__ ((__dllimport__)) int __attribute__((__cdecl__)) _wprintf_s_l(const wchar_t *_Format,_locale_t _Locale,...);
__attribute__ ((__dllimport__)) int __attribute__((__cdecl__)) _vwprintf_s_l(const wchar_t *_Format,_locale_t _Locale,va_list _ArgList);
__attribute__ ((__dllimport__)) int __attribute__((__cdecl__)) _fwprintf_s_l(FILE *_File,const wchar_t *_Format,_locale_t _Locale,...);
__attribute__ ((__dllimport__)) int __attribute__((__cdecl__)) _vfwprintf_s_l(FILE *_File,const wchar_t *_Format,_locale_t _Locale,va_list _ArgList);
__attribute__ ((__dllimport__)) int __attribute__((__cdecl__)) _swprintf_s_l(wchar_t *_DstBuf,size_t _DstSize,const wchar_t *_Format,_locale_t _Locale,...);
__attribute__ ((__dllimport__)) int __attribute__((__cdecl__)) _vswprintf_s_l(wchar_t *_DstBuf,size_t _DstSize,const wchar_t *_Format,_locale_t _Locale,va_list _ArgList);
```

Ce sont simplement les fichiers d'en-tête de la bibliothèque standard qui sont ajoutés par rapport à ce qui est utilisé.

Par exemple, on peut voir qu'ici on a un usage de la fonction printf qui n'évidemment pas une fonction que j'ai écrite moi même et qui appartient à la bibliothèque c et donc cette fonction forcément doit être ajouté.

Il faut les fichiers d'en-têtes nécessaires pour qu'elle puisse être utilisée donc cette étape de preprocessing va tout simplement supprimer les commentaires du code ainsi si on résume ce qui va ajouter en fait tout tout le code des fichiers d'en-tête d'accord je rappelle que ça `#include "other.h"` c'est une simple  directives pour inclure en fait le contenu de ce fichier ni plus ni moins et va ensuite traiter ça c'est important les directives de préprocesseur `#define TAB_SIZE 5`.

Rappelez vous dans le cours sur le langage c, je vous ai parlé des directives de preprocesseur qui sont facilement identifiables par ici un croisillon devant `#`.

D'ailleurs la commande, directive `include` est aussi des directives de preprocesseur très important à savoir.

Voilà donc une fois qu'on a fait tout ce tout ce mélange là ces quelques manipulations, on se retrouve avec ce fichier donc ça c'est la première étape qui se passe en réalité tout simplement.

Alors je prends bien le temps de tout vous expliquer, de ne pas aller trop vite.

### 2e compiling

Deuxième étape la **compilation** alors certains penserons simplement que la compilation c'était qu'au départ de mon code source, j'utilise la commande `gcc` qui me produit mon exécutable, mon programme exécutable. 

On ne parle pas de compilation de code écrit en langage c, on parle en réalité de compilation en langage assembleur c'est différent.

Voilà donc nous allons faire `gcc -S main.c` tiret S majuscule très important sur ce fichier histoire de changer un peu et je n'ai pas besoin de mettre autre chose puisque ça va choisir soi-même une extension point s.

```powershell
gcc -S main.c # compilation en langage assembleur vers un fichier point s.
```

Voilà nous obtenons ce fichier là en langage d'assembleur.

+ main.s
```asm
	.file	"main.c"
	.text
	.def	printf;	.scl	3;	.type	32;	.endef
	.seh_proc	printf
printf:
	pushq	%rbp
	.seh_pushreg	%rbp
	pushq	%rbx
	.seh_pushreg	%rbx
	subq	$56, %rsp
	.seh_stackalloc	56
	leaq	128(%rsp), %rbp
	.seh_setframe	%rbp, 128
	.seh_endprologue
	movq	%rcx, -48(%rbp)
	movq	%rdx, -40(%rbp)
	movq	%r8, -32(%rbp)
	movq	%r9, -24(%rbp)
	leaq	-40(%rbp), %rax
	movq	%rax, -96(%rbp)
	movq	-96(%rbp), %rbx
	movl	$1, %ecx
	movq	__imp___acrt_iob_func(%rip), %rax
	call	*%rax
	movq	%rbx, %r8
	movq	-48(%rbp), %rdx
	movq	%rax, %rcx
	call	__mingw_vfprintf
	movl	%eax, -84(%rbp)
	movl	-84(%rbp), %eax
	addq	$56, %rsp
	popq	%rbx
	popq	%rbp
	ret
	.seh_endproc
	.def	__main;	.scl	2;	.type	32;	.endef
	.section .rdata,"dr"
.LC0:
	.ascii "Rendu termine !\12\0"
	.text
	.globl	main
	.def	main;	.scl	2;	.type	32;	.endef
	.seh_proc	main
main:
	pushq	%rbp
	.seh_pushreg	%rbp
	movq	%rsp, %rbp
	.seh_setframe	%rbp, 0
	subq	$96, %rsp
	.seh_stackalloc	96
	.seh_endprologue
	call	__main
	movq	$0, -48(%rbp)
	movq	$0, -40(%rbp)
	movq	$0, -32(%rbp)
	movq	$0, -24(%rbp)
	movq	$0, -16(%rbp)
	movl	$14, -56(%rbp)
	movl	$8, -52(%rbp)
	movl	$127, -64(%rbp)
	movl	$36, -60(%rbp)
	movq	-56(%rbp), %rdx
	leaq	-48(%rbp), %rax
	movq	%rax, %rcx
	call	draw
	movq	-64(%rbp), %rdx
	leaq	-48(%rbp), %rax
	movq	%rax, %rcx
	call	draw
	leaq	.LC0(%rip), %rcx
	call	printf
	movl	$0, %eax
	addq	$96, %rsp
	popq	%rbp
	ret
	.seh_endproc
	.ident	"GCC: (MinGW-W64 x86_64-posix-seh, built by Brecht Sanders) 10.2.0"
	.def	__mingw_vfprintf;	.scl	2;	.type	32;	.endef
	.def	draw;	.scl	2;	.type	32;	.endef
```

Evidemment si vous ne connaissez pas le langage assembleur, vous ne comprendrez rien puis ce n'est pas encore une fois le sujet de cette vidéo et si vous voulez apprendre à programmer en langage assembleur vous avez aussi le cours sur la chaîne youtube pour ça donc on trouve tout un tas de choses évidemment toutes les instructions machine, le code pour pouvoir effectuer tout ce qu'il faut avec les registres bref je ne vais pas commenter davantage là dessus donc ça c'est la deuxième étape c'est à dire qu'en faisant cette commande là `gcc -S main.c` on dit en fait de s'arrêter à deuxième étape.

Alors ça a viré toutes les informations, il a viré les commentaires, etc et ensuite il compile en langage assembleur mais il s'arrête là il ne va pas plus loin au niveau des étapes en fait pour la compilation de notre programme écrit ici en langage c, c'est comme ça qu'il faut comprendre.

### 3e assembling

Troisième étape on peut le faire arrêter à la troisième c'est à dire l'**assemblage** d'accord ce qu'on appelle *assembly* ou *assembling* pour l'assemblage ou simplement le fait d'assembler qui a permis de s'arrêter à la troisième donc on aura le preprocessing, on aura la compilation en langage assembleur et on va ensuite assembler ce dernier.

Pour cela on va faire tiret c et je vais le faire sur main.c, `gcc -c main.c`.

```powershell
gcc -c main.c # assemblage des étapes 1 et 2 en fichier point o.
```

Voilà cette étape à réaliser évidemment les autres étapes avant d'accord ça a réalisé l'étape de preprocessing, l'étape compiling donc l'étape de compilation pour pouvoir enfin assembler tout ça et on obtient finalement un fichier en point o, *main.o*

*main.o* est un fichier codé en binaire donc je ne pourrais pas l'ouvrir parce qu'évidemment VScode est un éditeur de texte, non pas un éditeur binaire donc pas l'intérêt de voir des valeurs en hexadécimal voilà généralement c'est écrit en hexadécimal puisque ça compacte l'écriture.

Ainsi donc ici pas d'intérêt mais voilà le fichier objet que nous avons à la fin d'accord c'est un fichier objet.

```
C:.
    main.c
    main.o
    main.s
    other.c
    other.h
    other.i
```

Comme ça et on va en avoir autant qu'il y a de fichiers source.

Généralement ici pour le programme, on va devoir le faire autant qu'il y a de fichiers donc on aurait normalement un fichier objet également pour `other.c`.

```powershell
gcc -c other.c
```

Rappelez-vous en faisant ça `gcc -c other.c` il va faire le preprocessing donc c'est à dire qu'il va bien ajouté tout son contenus là parce que sinon comment le compilateur va savoir à quoi fait référence un *Point* ? qu'est ce que c'est que cette structure-là *Point*, ce type de variable qu'il ne connaît pas ?

Voyez toutes les informations qu'on a au niveau du prototype tout ça donc tout ça il va l'ajouter il va supprimer les commentaires, évidemment traiter d'éventuels directives mais là on en a pas plus que celles-ci à ce niveau, faire la compilation en langage assembleur et assembler le tout.

```powershell
gcc -c main.c
gcc -c other.c
```

Voilà on fait ça et on obtient également le fichier objet voilà c'était la troisième étape.

```
C:.
    main.c
    main.o
    main.s
    other.c
    other.h
    other.i
    other.o
```

Enfin alors je reviendrai après sur ce qui ce cache derrière cette troisième étape et notamment pour la 4e qu'on va voir maintenant, je vais revenir dessus.

### 4e linking

La quatrième étape c'est le **linking** donc ce qu'on appelle l'édition de liens c'est à dire la possibilité déjà de fusionner tous les fichiers objets que nous avons pour produire un programme final d'accord un programme qu'on va bien sûr rendre exécutable, c'est le but ici.

S'il n'est pas exécutable ça sous-entend que l'on va donc avoir notre programme pour éventuellement le faire exécuter ou simplement l'utiliser ailleurs d'accord parce que n'oubliez pas qu'un programme n'est pas forcément exécutable.

On peut avoir des programmes exécutables mais ici évidemment dans votre cas quand vous faites du c ou du c++, c'est la finalité d'accord à laquelle vous vous arrivez donc là il va faire fusion de *main.o*, *other.o* et éventuellement ajouter d'autres fichiers d'en-tête qu'on pourrait par exemple ici avoir en local et éventuellement d'autres fichiers sur lesquelles je ne détaillerai pas plus parce que c'est des choses que vous allez voir et que vous avez qu'on a abordé dans d'autres vidéos mais qui ne concerne pas forcément celle ci.

On va donc faire en faire un rassemblement pour rester simple donc un rassemblement en l'occurrence ici de *main.o*, *other.o* et il va éventuellement s'il n'a pas trouvé des bibliothèques tierces que vous avez pu vouloir ajouter et après c'est le système standard en fait qui va ajouter tout ce qui fait partie en fait la bibliothèque standard d'accord qui n'est pas par exemple de vous, une bibliothèque que vous avez récupérée d'internet et que vous utilisez dans votre programme.

Voilà ça peut être tout à fait le cas.

Par exemple si vous faites de la sdl, on l'a vu en langage c on a une étape ici au niveau de la ligne de compilation on rajoute des choses en fait pour pouvoir travailler avec la bibliothèque de la sdl et toute façon, on va le voir juste après dans l'autre partie de la vidéo ne vous en faites pas.

A partir de là on exécute tout, on fait `gcc main.o other.o -o prog`.

```powershell
C:\Users\sam\Desktop\c>gcc -c main.c
C:\Users\sam\Desktop\c>gcc -c other.c
C:\Users\sam\Desktop\c>gcc main.o other.o -o prog # fusionner les fichiers objets.
C:\Users\sam\Desktop\c>prog
Point en position (14/8)
Point en position (127/36)
Rendu termine !
```

Voyez je fait un `prog.exe` et ici je retombe exactement sur le résultat de tout à l'heure, je suis revenu au même point c'est simplement que là j'ai fait en fait les étapes de manière on va dire un peu plus intermédiaire mais vous voyez qu'on obtient la même chose, pas de problème donc on a l'édition des liens qui s'est faite et forcément pour que l'édition de lien et pu se faire ici il a fallu qu'on ait nos fichiers objets et pour avoir nos fichiers objets, on a dû passer par les trois étapes d'avants preprocessing, compiling, assembling tout simplement.

Qu'est-ce qui se passe précisément sans que je rentre dans les détailles parce que c'est l'affaire d'autres vidéos également.

Au niveau de l'étape 3 d'accord pour tout ce qui est assemblage, on a en fait tout simplement un assembleur qui est l'assembleur du projet GNU, comme pour gcc d'ailleurs, qui va s'occuper de  l'assemblage d'accord qui va donc être appelé par gcc.

Ce n'est pas gcc d'accord qui fait office d'assembleur, il fait en fait appel à **gas* (assembleur GNU).

C'est l'assembleur du projet GNU qui va tout simplement faire l'assemblage de notre code, du code écrit en langage d'assembleur.

```powershell
C:\Users\sam\Desktop\c>as --version
GNU assembler (Binutils for MinGW-W64 x86_64, built by Brecht Sanders) 2.36.1
Copyright (C) 2021 Free Software Foundation, Inc.
This program is free software; you may redistribute it under the terms of
the GNU General Public License version 3 or later.
This program has absolutely no warranty.
This assembler was configured for a target of `x86_64-w64-mingw32'.
```

Voilà le programme existe bien, il est notamment dans un paquet qui s'appelle binutils et on retrouve ça.

Pour l'édition de liens, le programme qui peut être utilisé est `ld`.

```
C:\Users\sam\Desktop\c>ld --version
GNU ld (Binutils for MinGW-W64 x86_64, built by Brecht Sanders) 2.36.1
Copyright (C) 2021 Free Software Foundation, Inc.
This program is free software; you may redistribute it under the terms of
the GNU General Public License version 3 or (at your option) a later version.
This program has absolutely no warranty.
```

Pareil on trouve bien `ld` pareil il fait partie d'un paquet qui englobe plein de programmes et on retrouve ces outils là voilà.

Voilà vous avez tout ici au niveau de ces étapes, je pense qu'on ne va pas aller plus loin à ce niveau là parce que je voulais que vous sachiez en tout cas à ce stade, c'est que maintenant que vous soyez capable de comprendre qu'en réalité quand vous compilez ici un programme écrit en c ou en c++, il y a tout un tas d'étape qui se passe.

Et pour faire tout d'un seul coup, on revient bien sûr à l'étape classique soit si on l'écrit de manière développé on met tout les fichiers sources comme ceci, `gcc main.c other.c -o` éventuellement on précise le nom du fichier de sortie ça permet comme ça de nommer nous même sinon il va nommer avec la lettre a par défaut en faisant ça, `gcc main.c other.c -o prog` d'accord.

```
C:\Users\sam\Desktop\c>gcc main.c other.c -o prog
C:\Users\sam\Desktop\c>prog.exe
Point en position (14/8)
Point en position (127/36)
Rendu termine !
```

Là, pas de problème !

Si on veut éviter de se taper tout le nom des fichiers sources encore une fois on fait comme ce que je vous ai montré d'accord.

```
C:\Users\sam\Desktop\c>gcc *.c -o prog
C:\Users\sam\Desktop\c>prog.exe
Point en position (14/8)
Point en position (127/36)
Rendu termine !
```

Et après bien sûr en décomposant, on va arrêter à certaines étapes mais en réalité il se passe ici les fameuses quatre étapes que j'ai développé un petit peu avant.

Voilà pour cette première partie de la vidéo et tout ce que je voulais aborder avec vous.

## Partie 2

> Les bonnes habitudes à prendre !

Maintenant que vous savez ce qui se cache réellement en fait derrière gcc avec les différentes étapes qui sont faites, je vais vous apprendre à utiliser des arguments qui vont vous êtes très utile.

Encore une fois vous ne verrez pas forcément le faire dans toutes les vidéos, ça va dépendre des vidéos dans le cours, dans les exos, dans les tutos.

Encore une fois parce que je ne vais pas forcément tout aborder parce que des fois ça rajoute énormément d'éléments et de choses dans une seule séance mais vous bien sûr prenez l'habitude de le faire et surtout bien sûr quand vous travaillerez après sur des vrais projets.

Si vous êtes en train d'apprendre bon si vous ne compilez pas avec les bons arguments c'est pas non plus gravissime par contre après quand vous travaillerez sur des vrais projets, des vrais programmes bien sûr il faudra toujours prendre l'habitude de compiler avec les arguments qui vont bien et vous allez très vite comprendre pourquoi.

Voilà on reprend notre dossier de base.

```powershell
C:.
│   main.c
│   other.c
│   other.h
│
└───doc
```

Ok allons-y au niveau de gcc avec tout un tas de commandes en plus.

Pour gcc vous allez pouvoir utiliser un certain nombre d'arguments qui vont être très utile, par défaut alors on ne va plus faire la décomposition des différentes étapes mais on va faire ça.

```powershell
gcc main.c other.c -o prog
```

Encore une fois si je fais ça d'accord j'ai tout, c'est une compilation sans argument ici précisément il y a des choses qui sont activés ou faites par défaut mais on ne les voit pas parce qu'on ne l'a pas écrit manuellement donc forcément si vous n'allez pas vous renseigner auprès de la documentation, vous ne pouvez pas deviner un peu ce qui se fait derrière.

Nous on va utiliser des options qui sont très importantes qui sont utilisés systématiquement càd qu'encore une fois si vous faites après un programme avant avec de la compilation avec ce compilateur là prenez l'habitude dès maintenant d'utiliser un maximum d'options, un maximum d'arguments par rapport à ce que vous faites.

Histoire d'avoir le programme le plus corrects possibles même si évidemment on peut pas obtenir un truc à 100% correct mais on peut en tout cas déjà limiter un peu les dégâts.

### Wall

Premier argument qui est important c'est un argument qui va permettre d'*activer des avertissements* c'est à dire que là voyez que mon programme, on se dit ça compile et si je l'exécute ça marche.

```powershell
C:\Users\sam\Desktop\c>gcc *.c -o prog
C:\Users\sam\Desktop\c>prog.exe
Point en position (14/8)
Point en position (127/36)
Rendu termine !
```

Pas de souci on pourrait se dire et c'est souvent la conclusion des gens qui débutent et même des fois de gens qui ne débutent pas forcément d'ailleurs de se dire c'est bon ça compile, ça s'exécute et en plus ça fait ce que j'ai demandé.

En tout cas par rapport à ce que j'ai écrit au niveau de mon code.

Pour moi c'est bon, on peut dire ça marche c'est ok et en fait pas vraiment !

Déjà on va rajouter un seul argument pardon qui est tiret W majuscule all `-W all`, on attache tout car on n'est pas obligé de faire ça comme ça `-Wall` mais c'est mieux de faire tout attachés.

```powershell
C:\Users\sam\Desktop\c>gcc -Wall *.c -o prog # l'option -Wall active les avertissements.
C:\Users\sam\Desktop\c>prog.exe
Point en position (14/8)
Point en position (127/36)
Rendu termine !
```

On fait ça et là aucun soucis.

Ici aucun souci c'est à dire que là en fait j'active simplement les avertissements alors il faut distinguer deux choses: un  avertissement c'est en fait une information qui vous indique qu'il y a un problème quelque part mais sans pour autant que ça fasse échouer le traitement que vous êtes en train de faire.

Comprendre ici un avertissement ne va pas empêcher la compilation et donc ne va pas empêcher la production de votre programme exécutable finale mais pour nous c'est ne pas suffisant.

On va utiliser un autre argument.

Alors donc `-Wall` permet d'activer simplement les avertissements liés à pas mal de choses vous allez très vite comprendre aussi pourquoi par la suite.

### Wextra

On va ajouter un argument supplémentaire pour commencer qui va ajouter en fait l'*activation d'avertissement supplémentaires* c'est à dire qu'en fait il va faire des analyses supplémentaires au niveau du codes d'ailleurs c'est `-Wextra`.

```powershell
PS C:\Users\sam\Desktop\c> gcc -Wall -Wextra *.c -o prog # l'option -Wextra active des avertissements supplémentaires.
other.c: In function 'draw':
other.c:8:17: warning: unused parameter 'surface' [-Wunused-parameter]
    8 | void draw(Point surface[], Point p)
```

Voyez déjà on ne se retrouve plus avec la même chose alors attention ça ne va pas dire que mon programme c'est pas compilés mais c'est juste un avertissement, ça ne veut pas dire voilà erreur de compilation donc je ne compile pas.

Voilà c'est un avertissement mais ça a en tout cas le mérite d'être important et vous avez notamment l'avertissement précis qui a été activée parce qu'en fait quand vous utilisez ces arguments là `-Wall -Wextra`.

En fait ce sont des raccourcis d'accord de plein d'autres arguments que vous pouvez utiliser avec gcc càd que gcc a énormément d'arguments mais pour éviter de tous les écrire à la main sauf si on veut précisément contrôler lesquels avertissements en fait on veut vérifier et quelle autre on ne veut ne pas déclencher.

On peut parfaitement le faire et ça éventuellement si vous voulez vous irez voir dans la doc quels arguments inscrire en fonction de ce que vous voulez checker ou pas, c'est à vous de voir.

Par défaut c'est ce que je conseille pour les débutants de ne pas forcément faire un tri, c'est de chercher en fait a *afficher un maximum d'avertissement*.

Plus vous allez afficher en fait d'avertissement, plus vous allez encore une fois vous rapprocher d'un code le plus correct possible en tout cas avec le maximum de choses seront identifiés par votre compilateur et ça c'est important.

On a donc notamment ici un avertissement `[-Wunused-parameter]` qui a été en fait trouvé ici et c'est bien sûr volontaire parce que c'est ce que je voulais vous montrer pour la vidéo.

On vous indique que vous n'utilisez jamais en fait cette variable `Point surface[]`.

Voilà on peut vérifier d'accord ici pourtant voyer qu'au départ le programme a fonctionné c'est à dire que j'ai ici une fonction de draw() qui apparemment écrit sur une surface et on a une implémentation dans other.c et c'est vrai qu'on ne l'utilise jamais.

```c
void draw(Point surface[], Point p)
{
    // "Simule" dessin d'un point...
    printf("Point en position (%d/%d)\n", p.x, p.y);
}
```

Jamais on n'utilise ça.

Dans main.c pareil, on déclare une surface dont on ne sert pas.

```c
int main(void)
{
    Point surface[TAB_SIZE] = {0};
    //etc.
}
```

On ne s'en sert ici comme argument pour faire l'appel à la fonction mais c'est tout.

```c
draw(surface, a);
draw(surface, b);
//etc.
```

Même si ça n'empêchera pas le programme de fonctionner d'accord ce système là permets de vous dire attention au final tu as écris ici une variable, tu a défini une variable mais tu ne l'utilise jamais donc en gros pas pourquoi tu mets ça en fait si tu ne l'utilise pas ça ne sert à rien ou alors faut l'utiliser, faut en faire quelque chose.

### Werror

Ce n'est pas que tout à fait suffisant rajoutons une troisième étape et on va dire que c'est pour moi le strict minimum quand on compile en c ou en c++ d'accord même si on reviendra sur d'autres choses un peu après c'est de rajouter une autre commande donc `-Werror`.

```powershell
PS C:\Users\sam\Desktop\c> gcc -Wall -Wextra -Werror *.c -o prog # l'option Werror transforme tous les avertissements en erreur.
other.c: In function 'draw':
other.c:8:17: error: unused parameter 'surface' [-Werror=unused-parameter]
    8 | void draw(Point surface[], Point p)
      |           ~~~~~~^~~~~~~~~
cc1.exe: all warnings being treated as errors
```

Alors on va faire Werreur alors Werror c'est très punitif vous avez remarqué puisqu'en fait il va *transformer tous les avertissements en erreur* donc en gros si un avertissement survient ça déclenche une erreur de compilation et donc ça ne complique pas donc il va vous empêcher de compiler votre programme si un seul avertissement est trouvé.

Là on a une erreur complètement donc on retrouve la même chose `unused parameter 'surface'` toujours pareil d'accord même problème et voyez que je n'ai pas d'exécuteur qui a été produit.

Pas de compilation.

A la différence si j'avais virer Werror l'avertissement n'empêche pas comme je vous l'ai dit.

Alors `-Wall -Wextra -Werror` ça c'est très important et c'est le strict minimum d'accord.

Maintenant à partir de là si vous voulez compiler vos programmes et encore une fois si vous voyez que dans des vidéos je ne les ai pas fait, faites-le parce que dans certaines vidéos que j'ai pu faire il y a peut être des avertissements qui ne se sont pas déclenchés forcément parce que j'ai pas utiliser forcément des arguments par rapport à ce que je vous montré en vidéo mais vous essayez justement de prendre l'habitude de le faire parce qu'encore une fois voilà c'est important.

Voilà ça c'est vraiment le strict minimum, on active les avertissements `-Wall`, on ajoute également donc avec l'activation `-Wextra` des avertissements supplémentaires donc ça va rajouter en fait plein d'autres arguments de ce style là `[-Werror=unused-parameter]` qui sont très très long qui sont plein plein plein de choses importantes et ici `-Werror` ça va tous traiter comme des erreurs, tout avertissement devient une erreur en fait de compilation tout simplement.

C'est vraiment le minimum pour programmer en c ou c++, je dis bien le minimum donc là automatiquement ok il y a quelque chose que je n'utilise pas donc je vais l'enlever.

+ main.c
```c
#include "other.h"
#include <stdio.h>

#define TAB_SIZE 5

int main(void)
{
    //Point surface[TAB_SIZE] = {0};
    Point a = {14, 8};
    Point b = {127, 36};

    draw(a);
    draw(b);

    printf("Rendu termine !\n");

    return 0;
}
```
+ other.c
```c
#include "other.h"
#include <stdio.h>

/**
* Dessine un point sur la surface
* @param p le point à dessiner
*/
void draw(Point p)
{
    // "Simule" dessin d'un point...
    printf("Point en position (%d/%d)\n", p.x, p.y);
}
```
+ other.h
```h
#if !defined(__OTHER__)
#define __OTHER__

/* Définition d'un point sur une surface 2D */
typedef struct Point
{
    int x;
    int y;
} Point;

/* Fonctions */
void draw(Point p);

#endif
```
```powershell
PS C:\Users\sam\Desktop\c> gcc -Wall -Wextra -Werror *.c -o prog
PS C:\Users\sam\Desktop\c> ./prog.exe
Point en position (14/8)
Point en position (127/36)
Rendu termine !
```

Voilà normalement je fais ceci et là plus de problèmes, on a bien notre programme.

Voilà ça marche et ça permettra dans certains cas surtout si vous transformez vos avertissements en erreur et bien des erreurs que vous n'auriez pas vu vous même parce que sans ces arguments votre programme, va compiler, va s'exécuter, peut tout à fait être fonctionnel par rapport à ce que vous attendiez et vous allez donc vous dire que mon code est correct, 100% correct sans problème alors que ce n'est pas forcément le cas en réalité.

Après encore une fois des avertissements sont des avertissements parce que ce ne sont pas des points jugés critiques dans le sens où attention c'est dangereux ou attention c'est un gros problème de sécurité, etc.

Ce sont des avertissements c'est à dire que ce n'est pas non plus ce qu'il y a de plus critique dans un programme mais si on veut être essayé d'être le plus rigoureux possible, le fait de traiter les avertissements comme des erreurs est plutôt une bonne habitude à prendre.

Voilà pour le minimum, on va aller un petit peu plus loin et on va accélérer un petit peu la cadence pour la suite.

## Normes

Voyez le principe et on va ajouter autre chose.

J'en ai parlé sur le cours en c++ notamment au niveau des normes et des standards c'est à dire vous savez dans le monde de manière générale sans que je fasse un cours complet dessus nous avons en fait des organismes de normalisation d'accord notamment l'organisme iso qui est en fait la norme internationale d'accord qui fait un peu office de référence absolue mais enfin voilà c'est vraiment la norme internationale qui régit un petit peu tout et après bien sûr chaque pays a en fait des normes à lui donc propres à chaque pays et qui peuvent aussi avoir leur représentation dans la norme **ISO** notamment par exemple pour l'Amérique avec la norme **ANSI**.

Voilà **ANSI** qui est en fait la représentation américaine de la norme **ISO**.

Au début de la conception, de la normalisation par exemple du langage c, tout tournait et tout était en fait écrit et normalisé sous cette forme ANSI la norme américaine et par la suite bien sûr avec l'extension du langage au niveau international on a finalement très vite réécrit et indiqué en fait en parlant de normes ISO.

On parle par exemple de norme **ISO c** et on parle de normes **ISO c++**.

On peut comprendre que c'est pas tout à fait la même chose mais ANSI est inclus dans ISO ok c'est une partie mais en fait qui concerne l'amérique.

Pour la france je crois que nous avons **AFNOR** si je ne dis pas de bêtises, l'AFNOR c'est une un système de normalisation pour la france, on a le **JIS** pour le japon par exemple.

Voilà il y a des normes industrielles, il y a des normes pour pas mal de domaines différents en informatique et ça permet de dire un système de normes c'est à dire d'avoir un ensemble de règles à définir et sur lesquels les systèmes, les infrastructures doivent se conformer tout simplement.

Pourquoi c'est important de vous dire ça, parce qu'évidemment on peut rendre encore les choses un peu plus strictes au niveau du programme c'est à dire qu'en plus de compiler ça de cette manière.

```
gcc -Wall -Wextra -Werror *.c -o prog
```

Alors on peut rajouter autre chose, par exemple en ajoutant cet argument `-ansi`, on va simplement s'assurer que notre programme est conforme à la norme ANSI.

Alors la norme ANSI va revenir à écrire un autre argument qu'on va revoir plus tard.

On va mettre en commentaire....

```txt
Normalisation : ISO (international)
ANSI : représentation américaine dans la norme ISO

c89 (ANSI)
c90
C99 (ISO C)
c11
c18

c++98 (ANSI)
c++11
c++17
```

Voilà ISO c'est international, ANSI c'est le répresentante américaine dans la norme ISO, etc.

Au niveau des normes pour le langage c et c++ parce que c'est ce dont on parle, on a par exemple vu la norme **c89** qui est ce qu'on appelle cette fameuse norme ANSI.

Par racourcis quand on parle de ANSI, on parle de cette norme c89, ce standard-là pour le langage c d'accord.

Après on a le **c90** c'est resté de l'ANSI.

Ensuite à partir de **c99**, on a commencé à parler de la norme ISO C et ensuite **c11**, **c18** la dernière en date au moment où je fait cette vidéo.

Pour c++ on a la **c++98** donc celle-ci c'est l'ANSI et après on a eu toutes les autres **c++11**, **c++17**, etc. et après on a **c++2a** qui d'ailleurs sont très souvent renommé parce qu'il y a sûrement des noms temporaire et après c'est renomé, c'est changé bref donc vous verrez par la suite.

On va se contenter celles-ci c++98, c++11, c++17.

Tout ça est important c'est à dire que c89 est vraiment la remière nomme au niveau du c, on prend cette norme parce que mon code est écrit en c.

Evidemment les normes suivantes, les standards suivants ont ajouté des fonctionnalités, ont ajouté des extensions, des améliorations, des nouvelles fonctionnalités, etc. mais dans certains cas on n'a pas spécialement envie par exemple d'utiliser les standards plus modernes d'accord pour des raisons x ou y par rapport en fait à une conformité peut-être la plus originale ici au niveau du c.

Alors le c++ ce serait une autre paire de manches parce que programmer et du c en norme 98 c'est peut-être a évité mais pour le c voilà on peut des fois avoir besoin de se plier à cette norme-là et dans ce cas là on va utiliser justement ANSI ce qui correspond en fait à utiliser une autre option qui est `-std=c89` qui revient à mettre `-ansi`, idem pour le c++.

```txt
Normalisation : ISO (international)
ANSI : représentation américaine dans la norme ISO

c89 (ANSI) -> -std=c89 (-ansi)
c90
C99 (ISO C)
c11
c18

c++98 (ANSI) -> -std=c++98 (-ansi)
c++11
c++17
```

```powershell
gcc -Wall -Wextra -Werror -ansi *.c -o prog
```

Ok donc dés que vous allé marquer `-ansi` vous demandez en fait à utiliser la norme alors pour le c ça peut être important dans certains cas, c++ ça l'est beaucoup moins on l'expliquera aussi.

On peut utiliser cette option pour être sûr d'être le plus conforme avec la norme tel quel à ce niveau-là.

### std

Maintenant parlons de *std* donc c'est un autre argument c'est à dire que si je fait égal quelque chose `std=x` ça va permettre d'indiquer clairement sous quel standard je compile mon programme.

Le standard doit être pris en compte pour l'analyse en fait du code et la compilation au total avec tout un les étapes qu'on a vu en première partie de la vidéo tout simplement donc en gros si vous faites `-std=c89` ça correspond en fait à cet argument `-ansi` d'accord pour c++ c'est celui-là `-std=c++98` et vous pouvez choisir en fonction des noms.

Alors ça si vous voulez les noms exacts pour le c et le c++ comme ils sont assez changeant notamment les derniers allez toujours voir bien sûr sur la documentation officielle pour retrouver les noms au moment où ils sont valides par rapport aux changements qui peuvent être faits parce que je peux vous donner les noms aujourd'hui mais ils vont peut-être changé entre-temps mais vérifiez toujours à ce niveau là pour être sûr d'accord.

Vous mettez donc *std*.

Pour le c, généralement c'est un c suivi de l'année par rapport à la norme donc si vous voulez compiler avec la norme c11 et bien vous faites ceci sur votre programme en c, `-std=c11`.

Voilà et si vous compilez d'ailleurs je pense qu'on va avoir une erreur parce que je crois que j'utilisais des commentaires en c++ donc il ne va pas être content.

```powershell
PS C:\Users\sam\Desktop\c> gcc -Wall -Wextra -Werror -ansi *.c -o prog
main.c: In function 'main':
main.c:8:5: error: C++ style comments are not allowed in ISO C90
    8 |     //Point surface[TAB_SIZE] = {0};
      |     ^
main.c:8:5: note: (this will be reported only once per input file)
other.c: In function 'draw':
other.c:10:5: error: C++ style comments are not allowed in ISO C90
   10 |     // "Simule" dessin d'un point...
      |     ^
other.c:10:5: note: (this will be reported only once per input file)
```

Voilà déjà avec ANSI, il n'est pas content parce qu'évidemment à l'époque de la norme ANSI est valide pour les deux langues c89 et c90 et s'est passé ensuite à ISO C.

Ici il nous dit en fait lors de cette norme ce n'est pas valide donc c'est bien une erreur parce qu on transforme tout en erreur mais en fait ce style de commentaire sur une seule ligne dans la base du c++ à l'époque mais en fait c'est pas valides donc vous voyez ça permet vraiment de rajouter en fait un point plus strict au niveau de la compilation pour dire bah non ça ne va pas donc en gros comprendre que maintenant il faut remplacer `//` par `/* */`.

+ main.c
```c
#include "other.h"
#include <stdio.h>

#define TAB_SIZE 5

int main(void)
{
    /*Point surface[TAB_SIZE] = {0};*/
    Point a = {14, 8};
    Point b = {127, 36};

    draw(a);
    draw(b);

    printf("Rendu termine !\n");

    return 0;
}
```
+ other.c
```c
#include "other.h"
#include <stdio.h>

/**
* Dessine un point sur la surface
* @param p le point à dessiner
*/
void draw(Point p)
{
    /* "Simule" dessin d'un point...*/
    printf("Point en position (%d/%d)\n", p.x, p.y);
}
```
+ other.h
```h
#if !defined(__OTHER__)
#define __OTHER__

/* Définition d'un point sur une surface 2D */
typedef struct Point
{
    int x;
    int y;
} Point;

/* Fonctions */
void draw(Point p);

#endif
```
```powershell
gcc -Wall -Wextra -Werror -ansi *.c -o prog
```

Changer les commentaires en conformité avec la norme ANSI donc là vous voyez ça fonctionne.

Voilà ça passe la norme c'est 89, c'est 90 par défaut pas de problème.

Maintenant pareil en fonction si je veux la norme c11, je fait comme ceci.

```powershell
gcc -Wall -Wextra -Werror -std=c11 *.c -o prog
```

Voilà je pourrais traités en fonction si par exemple vous avez besoin d'utiliser une fonctionnalité qui est apparue avec ce standard là évidemment il faudra compiler avec le bon argument parce que par défaut il va choisir un standard par défaut quand vous ne précisez rien.

```powershell
gcc -Wall -Wextra -Werror *.c -o prog # standard par défaut.
```

Par défaut, ce serrait bien c90 !

```
C:\Users\sam\Desktop\c> gcc --version
gcc.exe (MinGW-W64 x86_64-posix-seh, built by Brecht Sanders) 10.2.0
Copyright (C) 2020 Free Software Foundation, Inc.
This is free software; see the source for copying conditions.  There is NO
warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
```
Peu importe mais en gros comprenez si vous voulez utiliser un standard bien particulier ... pour être sûr au moins l'avantage de l'écrire manuellement c'est que vous êtes sûr d'avoir le bon standard.

Ensuite si vous êtes en c++ où vous utilisez des fonctionnalités apparues à partir de c++17, prises en charge à partir de ce standard-là pour être sûr que vous compilez au minimum d'accord sur ce standard et pas un standard plus ancien puisque ce serait quand même très embêtant càd qu'en 2021 compiler avec la norme, le standard c++98 voilà il ne faut pas faire ça.

Ou alors vous êtes en train de faire de la maintenance d'un code qui a été écrites avec ce standard-là et vous ne pouvez pas le faire évoluez dans un standard plus récents donc évidemment là vous avez des contraintes qui font que ... c'est pour ça que ce genre d'argument existe donc des fois on a besoin de maintenir du très très vieux code mais sinon vous mettez ça `-std=c++17` et comme ça votre code c++ vous êtes sûr que le compilateur prend en charge en fait va traiter avec ce standard-là.

Voilà comment ça fonctionne donc très simple mais il faut le savoir.

Maintenant quand vous compilez vos programmes si vous voulez vérifier en fonction des standards, vous pourrez choisir manuellement lequel est concernée par rapport à ce que vous faites.

Pour finir avec tous ces histoires de normes, de standards on a encore une autre partie d'accord càd si on veut en fait traiter encore d'autres conformité notamment avec les ISO c'est à dire que si on veut éviter tout ce qui est usage d'extension notamment apporté par les compilateurs.

## pedantic

Alors là on parle de gcc mais il faut savoir que les compilateurs propose par exemple des extensions de tout un tas de choses, tout un tas de fonctionnalités qui ne sont pas encore une fois standard à comprendre qu'elles ne sont pas forcement portable d'un système à l'autre d'une architecture à l'autre et simplement qu'il faut éviter leur pratique au maximum dans la mesure du possible, il faut vraiment l'éviter et si vous voulez vous assurer que vous ne faites pas justement usage d'un code qui ne serait pas portable et qui utilise par exemple des fonctionnalités issues d'extensions on peut rajouter `-pedantic` et on va dire qu'on est en c11.

```powershell
gcc -Wall -Wextra -Werror -std=c11 -pedantic *.c -o prog # l'option pedantic crée des avertissements lié à une norme et qui empêche des fonctionnalités issues d'extensions.
```

Voilà je met `-pedantic` et là je serai avec tout ce qu'il faut au niveau de la norme ISO et si vous en voulez une dernière couche, vous pouvez à la place de mettre simplement pedantic vous mettez `-pedantic-errors`.

```powershell
gcc -Wall -Wextra -Werror -std=c11 -pedantic-errors *.c -o prog
```

Voilà ça va faire comme avec `-Wall` et avec `-Werror` qui transforme tous les avertissements en erreur c'est simplement tout ce qui est relatif à `-pedantic` va être traité non pas comme des avertissements parce que `-pedantic` traite avec des avertissement mais avec `-pedantic-errors` ce sera traité comme des erreurs et là on a déjà franchement pas mal de choses.

Alors si vous voulez voir du côté des documentations notamment vous pouvez regarder un petit peu ce qu'il y a en fait comme argument d'accord qui sont en fait compactés dans ces arguments `-Wall` et dans `-Wextra`, dans `-pedantic-errors` etc. et vous verrez qu'il y a énormément de choses donc en faisant ça même si la ligne est déjà pas mal longue en fait vous utilisez, vous faites une compilation avec une vingtaine, une trentaine, quarantaine d'arguments en réalité qui sont compactés dans tout ça.

```powershell
gcc -Wall -Wextra -Werror -std=c11 -pedantic-errors *.c -o prog
```

Voilà avec cette ligne là vous êtes pas mal avec ça et que vous voyez que ça compile sans problème et que en l'exécutant tout est bon, vous êtes déjà un petit peu plus rassurés on va dire quant à la qualité de votre code.

Encore une fois ça ne garantit pas à 100% qu'il est correct et fiable etc mais ce sera déjà bien mieux, largement mieux que de compiler simplement comme ça, `gcc *.c -o prog` et je pense que maintenant à ce stade de la vidéo vous avez compris pourquoi et si c'est pas le cas c'est embêtant parce que j'aurais mal fait mon travail.

## w

Autre petite parenthèse mais je vais aller très vite parce que je ne voudrais pas que des petits filous sur la vidéo s'amuse avec ça, il y a des fois, des cas où on a des avertissements mais on ne veut pas que ces avertissements en fait soit actif d'accord càd qu'on veut en fait qui souhaitent simplement supprimées, qu'ils soient ignorées donc il faut avoir bien sûr des raisons précises, spécifiques de le faire et vous pouvez utiliser l'argument tiré w minuscule d'accord, `-w`.

```txt
Normalisation : ISO (international)
ANSI : représentation américaine dans la norme ISO

-w

c89 (ANSI) -> -std=c89 (-ansi)
c90
C99 (ISO C)
c11
c18

c++98 (ANSI) -> -std=c++98 (-ansi)
c++11
c++17

-std=c++17
```

Dans certains cas vous devez supprimer les avertissements mais attention à utiliser vraiment pour des cas spécifiques si vous savez pourquoi vous le faites sinon j'en parle très vite, je ne vais pas le montrer parce que ça pourrait donner le mauvais exemple à certains, ne l'utilisez pas ou en tout cas pas sans raison.

## Optimisation

Terminons avec un petit point sur l'optimisation et après on finira sur quelques petites options rapides qu'on avait déjà vu notamment pour ceux qui ont suivi le cours en c par rapport à la **SDL** des petites choses qu'on a déjà vu comme ça on ne ferra pas trop long au niveau de cette vidéo même si je voulais bien entrer dans les détails puisque quel est intérêt de parler de la compilation avec gcc pour ne pas entrer dans les détail ça n'aurait aucun intérêt.

On va parler d'optimisation et par exemple en utilisant ceci `gcc -O *.c -o prog` alors ici c'est trompeur parce qu'on utilise un argument O majuscule attention ce n'est pas un zéro.

C'est argument **-O** ne va pas véritablement faire de l'optimisation au sens où on va l'entendre au niveau de la compilation mais plus en fait au niveau de la taille du code d'accord il va en fait essayer de réduire la taille du code donc en faisant en fait des raccourcis d'écriture notamment parce que le compilateur est capable de le faire, il a été programmé pour ça et vas essayer en fait de réduire les temps d'exécution donc c'est vraiment voilà pas mal mais c'est pas non plus le truc incroyable mais quand même, on peut des fois gagner pas mal de temps parce que forcément vous allez écrire votre code et vous allez rajouter des saut de lignes et tout un tas de fonctions écrites d'une certaine manière ainsi le compilateur comme c'est un programme il est capable de pouvoir analyser votre code de la même manière mais écrit autrement donc il va essayer de faire des petites transformations, pas de la compression au sens algorithmique mais des petites réorganisation au niveau de l'écriture du code pour s'aider éventuellement des mots d'optimisation par la suite d'accord.

```powershell
gcc -O *.c -o prog # optimise la taille du code.
```

On peut également faire le **-O1** pour avoir une réduction de la taille du code et ainsi diminuer le temps d'exécution c'est quand même ce qu'on aimerait à ce niveau-là.

```powershell
gcc -O1 *.c -o prog
```

Ainsi pas d'optimisation au sens spécifique tel qu'on va le voir juste après.

Après on a d'autres modes et je rentrerai pas non plus en détails parce que c'est des choses qui vous parlerais absolument pas càd que si je veux perdre tout le monde sur la vidéo, quasiment tout le monde, je pourrais vous détailler ça mais ça n'a pas intérêt.

On a en fait différent niveau d'optimisation donc **-O2** et **-O3** d'accord on a **-O0** avec zéro mais pas d'intérêt ici par rapport à ce que je vous montre et on le verra éventuellement parce que aux -O0 c'est ce qui est exécuté par défaut.

Voilà donc comme c'est fait par défaut, pas tellement d'intérêt de le mettre ici donc -O2 fait plus optimisation d'accord et -O3 en fait encore d'avantage, tout un tas de choses donc ça peut être au niveau des fonctions online, ça peut être au niveau des variables, pour tout ce qui est accès au niveau du registre, etc.

Voilà il y a vraiment plein plein d'optimisation sûrement des choses peut-être trop compliquées pour une très grande majorité d'entre vous.

```powershell
gcc -O3 *.c -o prog
```

Pas la peine de développer là dessus mais ça peut servir dans certains cas.

Par contre comme il s'agit de faire des optimisations, ça va aussi rallonger le temps de compilation pareil logique puisque le compilateur va avoir un petit peu plus de travail à faire.

### Os

Au niveau d'un autre point qui peut être intéressant, pour l'optimisation de la taille du code notamment on peut faire ceci tiret os **-Os** qui va exécuter une optimisation de niveau 2 *-O2* et ça va essayer de faire une réduction de la taille du code, c'est toujours bon à prendre ça peut être un bon compromis encore de faire ce genre de choses pourquoi pas.

```powershell
gcc -O2 *.c -o prog
```

Voilà une légère différence on ne le verra forcément parce c'est quand même un programme vraiment très très petit pour se rendre compte de la différence au niveau optimisation.

Voici donc pour les arguments au niveau de l'optimisation pour la compilation de vos programmes.

Encore une fois ce que je vous ai montré ici avec du c est valable pour le c++, là on parle d'arguments pour l'outil gcc donc ça ne concerne pas directement le c ou le c++ et peut être utilisé bien sûr pour les deux.

## I

On termine avec quelques petits arguments très rapide parce que je les ai déjà montré en pratique dans le cours mais c'est plus pour ceux qui viendraient sur cette vidéo qui ne programmerais pas forcément en c et qui n'ont pas vu mon chapitre sur la SDL avec tiret grand I, **-I**.

```txt
Normalisation : ISO (international)
ANSI : représentation américaine dans la norme ISO

-w

c89 (ANSI) -> -std=c89 (-ansi)
c90
C99 (ISO C)
c11
c18

c++98 (ANSI) -> -std=c++98 (-ansi)
c++11
c++17

-std=c++17

-I <include>
```

Je prend des notes parce que j'ai rien a éxécuter pour vous montrer et si vous voulez un exemple réel et bien aller voir directement sur le cours en c, la partie SDL et vous verrez en temps réel ce que ça donne.

Ici c'est tout simplement de faire un include donc en gros on met un tiret I et un chemin vers un répertoire pour faire de l'inclusion, ça permet tout simplement d'inclure des fichier d'en-tête non pas des fichiers d'en-tête par exemple qui sont issus des standards d'accord de la bibliothèque standard mais des choses par exemple que vous voulez utiliser au niveau de votre projet.

> l'option -I permet d'inclure des fichiers d'en-tête mais qui ne sont pas issus de la biblio standard.

Par exemple quelqu'un a développer en fait un programme d'une application peu importe une API que vous voulez utiliser,  généralement quand c'est bien organisé vous allez retrouver un répertoire include.

```powershell
C:.
├───include
├───lib
└───src
```

Généralement les gens font ça comme ça avec peut-être d'autres répertoires à l'intérieur et bien au moment de la compilation vous allez indiquer donc cet argument-là **-I** et le chemin vers le répertoire pour ajouter ces en-têtes supplémentaires.

Qu'est ce qui va se passer au niveau de la compilation puisqu'on l'a vu, rappelez-vous il y a cette histoire au niveau du preprocessing où on va ajouter notamment des fichiers d'en-tête par exemple pour pouvoir accéder aux fonctions comme printf eh bien il va d'abord en fait ajouter les fichiers d'en-tête que vous avez indiqué au niveau local (terminal), au niveau de la commande gcc et après c'est le système standard qui va aller ajouter tout ce qu'il faut au niveau de la bibliothèque standard d'accord parce que encore une fois printf() par exemple, vous ne l'avez pas écrites vous-même et donc il faut bien qu'il puisse trouver le code pour être capable en fait de l'utiliser sinon ça ne marchera pas.

Voilà pour cette partie très rapidement.

## l

Pour le tiret l **-l** alors je vais marqué ça et <library> je rappel que ça veut dire bibliothèque en français pour l'information très important et non pas librairie c'est l'endroit où on vend des livres éventuellement.

```txt
Normalisation : ISO (international)
ANSI : représentation américaine dans la norme ISO

-w

c89 (ANSI) -> -std=c89 (-ansi)
c90
C99 (ISO C)
c11
c18

c++98 (ANSI) -> -std=c++98 (-ansi)
c++11
c++17

-std=c++17

-I <include>
-l <library>
```

Ceci permet tout simplement d'inclure des bibliothèques donc généralement ce sont des fichiers qui porteront l'extension points a *.a* donc pareil en sdl je vous ai montré un peu comment ça marchait en pratique donc si à un moment donné, vous utilisez une bibliothèque que vous avez trouvée sur internet, que quelqu'un a développée et que vous voulez utiliser dans votre programme, vous aurez peut-être un répertoire avec des fichiers portant cette extension et il faudra les ajouter comme ceci `-l` et après généralement on rajoute un nom comme ceci `-lSDL2main` par exemple et ça retrouvait en fait ce qui correspondait d'accord par rapport en fait à l'utilisation de cette bibliothèque-là.

> l'option l permet d'inclure des bibliothèques qui portent l'extension point a (ex: -lSDL2main).

Voilà donc qu'est-ce que ça permet de faire ? ça permet d'inclure en fait du code tiers d'accord à un programme que vous avez écrit et c'est comme ça qu'on fait de la programmation de toute façon on n'invente pas forcément tout, on ne refait pas forcément tout.

Alors vous avez remarqué que par exemple pour le code de la bibliothèque standard ne le fait pas, vous n'avez pas besoin par exemple de préciser où est-ce qu'il doit trouver printf() d'ailleurs je suis sûr que quasiment tout le monde, toutes les personnes qui regardent cette vidéo ne savent absolument pas où se trouvent les fichiers d'en-têtes ou éventuellement des bibliothèques pour pouvoir en fait retrouver toutes les fonctions de la bibliothèque et à la rigueur ce n'est pas important vous n'avez pas besoin de le savoir et pas besoin de le faire manuellement pour programmer en c ou en c++, c'est le compilateur qui sait le retrouver puisque en installant votre compilateur tout est déjà présent dans ce qu'on appelle son système standard il va de lui-même rechercher à ce niveau-là donc il sait où trouver des éléments c'est pour ça que vous avez vu ça marche très simplement sans devoir rajouter toutes ces options **-I** et **-l** pour essayer de trouver ces choses même si vous pourriez le faire manuellement mais encore une fois aucun intérêt de toute façon, il le fera à votre place.

## o

Voilà on peut terminer avec quoi ? Est-ce que j'ai besoin de dire que **-o** c'est pour rediriger vers un fichier de sortie.

Vous savez quand on fait `gcc file.c -o monjoliprog` avec l'argument tiret o pour choisir en fait le nom du fichier de sortie, en fait simplement un fichier de sortie avec un nom choisi du style monjoliprog. 

On peut même s'amuser à mettre un point exe sur Windows.

```powershell
gcc file.c -o monjoliprog # l'option o permet de rediriger vers un fichier de sortie.
gcc file.c -o monjoliprog.exe
```

## g

Voilà on peut faire ce genre de chose et dernier argument mais que je ne vais pas détailler parce que c'est pour une autre vidéo mais l'argument tiret g **-g** qui concerne et le débogage mais je vous donne juste voilà le nom c'est tiret g mais je ne le détaillerai pas là parce qu'on va l'utiliser bien en détail sur une autre vidéo.

C'est ce que vous pouvez voir sur la vidéo concernant le débogage avec notamment le programme gdb qui lui aussi fait partie du projet GNU donc on a tout ici.

Je pense qu'on a fait le tour largement, on est à presque 50 minutes de vidéo, je peux vous dire que là si vous n'avez pas eu suffisamment de détails à ce niveau là et bien vous pouvez toujours en trouver d'avantage encore et encore si on a tout épluché mais on a fait le tour j'espère que j'ai rien oublié.

J'espère en tout cas que ça vous a plu, si vous avez des questions n'hésitez pas surtout c'est le genre de vidéo qui n'est pas forcément très très simple on va dire dans les aspects quel aborde même si j'essaie de vous l'expliquer de la manière la plus accessible possible mais tout ce qu'il y a derrière est loin de l'être donc n'hésitez pas en cas de question et si le conseil que je peux donner pour cette fin de vidéo, maintenant que vous programmez, que vous programmez en c et en c++ prenez l'habitude d'utiliser des bons arguments à la compilation et comme ça vous éviterez déjà pas mal de soucis pour la suite.

Je vous dis à bientôt pour une prochaine vidéo et pour la suite des aventures sur la chaîne.

Ciao tout le monde