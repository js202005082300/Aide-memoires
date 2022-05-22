# [5. Variables](https://www.youtube.com/watch?v=CIzKfH8Jtco)

+ [Introduction](#Introduction)
+ [Rappel sur l'alignement de la pile](#Rappel-sur-l-alignement-de-la-pile)
+ [Sections data et bss](#Sections-data-et-bss)
+ [Déclarer une variable (dX et resX)](#Déclarer-une-variable)
+ [Taille de l'information](#Taille-de-l-information)
    + [Réserver une donnée de 64 octet](#Réserver-une-donnée-de-64-octet)
+ [Préfixes et suffixes des bases numériques](#Représentation-données)
    + [Formatage en décimal](#Formatage-en-décimal)
    + [Formatage en octal](#Formatage-en-octal)
    + [Formatage en binaire](#Formatage-en-binaire)
    + [Formatage en hexadécimal](#Formatage-en-hexadécimal)
+ [Formater des caractères (ou une chaîne)](#Formater-des-caractères)
+ [Directive "equ"](#Directive-equ)
    + [Calculer la longueur pour une chaîne](#Calculer-la-longueur-pour-une-chaîne)
    + [Représenter la valeur True](#Représenter-la-valeur-True)
    + [Représenter la sortie standard](#Représenter-la-sortie-standard)
    + [Représenter la taille de l espace fantôme](#Représenter-la-taille-de-l-espace-fantôme)
+ [Préfixe "times"](#Préfixe-times)
+ [Conclusion](#)

## Introduction

```asm
bits 64

extern GetStdHandle
extern WriteConsoleA
extern ExitProcess

section .data
    message: db 'Hello World !', 10

section .bss
    written: resq 1

section .text
    global main
    main:
        mov rcx, -11            ; DWORD nStdHandle
        call GetStdHandle       ; -> HANDLE

        ; ---------------------------------------------------

        sub rsp, 32
        sub rsp, 8
        mov rcx, rax            ; HANDLE hConsoleInput
        mov rdx, message        ; LPVOID LpBuffer
        mov r8, 13              ; DWORD nNumberOfCharsToRead
        mov r9, written         ; LPDORD LpNumberOfCharsRead
        mov qword [rsp+32], 0   ; LPVOID pInputControl
        call WriteConsoleA      ; -> BOOL
        add rsp, 32+8

        ; ---------------------------------------------------

        xor rcx, rcx            ; UINT uExitCode
        call ExitProcess
```

## Rappel sur l alignement de la pile

Rappel sur espace fantome de 32 octets

`sub rsp, 32` définit un espace fantôme de 32 octets mais définit aussi 8 autres octets alloués pour le retour donc ils vont être sur la pile.

Un total de 40 octets mais au niveau des conventions d'appels de Windows, il faut être aligné sur un multiple de 16. 48 octets est le plus proche de cet alignement.

```asm
sub rsp, 32     ; 32 octets d'espace fantôme (+8 octets pour le retour)
```

`sub rsp, 8` définit un nouveau décallage de 8 pour arriver à 48 octets.

`add rsp, 32+8` réinitialise l'état de la pile.

On aurait pû faire ceci mais on la décomposé pour comprendre les étapes.

```asm
sub rsp, 40
; ...
; ...
; ...
add rsp, 40
```

## Sections data et bss

Déclaration variables

Cela se passe dans nos section.

Initialisation de nos données :

```asm
section .data
    message: db 'Hello World !', 10
```

Initialisation de données réservées pour un espace mémoire :

```asm
section .bss
    written: resq 1
```

Pour Windows et non sur Linux, on avait besoin de déclarer une variable `written`, reservé un certain espace pour un des arguments pour la fonction de WriteConsoleA, la version ANSI.

```asm
section .bss
    written: resq 1
```

On a une étiquette `written` et les 2 points ne sont pas obligatoires.

## Déclarer une variable

Ensuite `db` est un petit mot clé.

```asm
section .data
    message: db 'Hello World !', 10
```

On a ce schéma pour les données initialisées un `d` (ex: `dx`) suivi de quelque chose et pour les données réservées, on a un `res` (ex: `resx` avec x qui se ra remplacé par un élément précis).

## Taille de l information

Ce qui suit dépend de la taille à réserver en mémoire.

```asm
; b (byte = 8 bits [1 octets])
; w (word = 16 bits [2 octets])
; d (double-word = 32 bits [3 octets])      -> float
; q (quadruple-word = 64 bits [4 octets])   -> double

; t         -> précision étendue
; o
; y         -> YMM
; z         -> ZMM
```

Avec le suffixe `d`, on travaille avec un équivalent flottant et cetera.

Avec y et z, on travaille avec nos registres `YMM` et `ZMM`.

Pour résumé, pour une donnée sauvé dans la section `.data`, on écrit `d` puis le suffixe en fonction de la taille. `db` est l'unité la plus petite. Attention afficher une chaîne n'est pas aussi simple que afficher un nombre.

```asm
; db <valeur>

; ex: resq, resw et cetera.
```

Initialiser la donnée avec des quotes, double-quotes ou des anti-quotes.

```asm
section .data
    message: db 'Hello World !'
    message: db "Hello World !"
    message: db `Hello World !`
```

Ici on réserve une fois la taille de `resq`, un quadruple mot :

```asm
section .bss
    written: resq 1
```

### Réserver une donnée de 64 octet

```asm
section .data
    message: db 'Hello World !', 10

section .bss
    written: resq 1

    mydata: resb 64
```

On note les valeurs décimales tel que `64`.

## Représentation données

### Formatage en décimal

Pour un décimale, on utilise le `d` ou le `t`.

```asm
; d ou t : décimal ---> 5, 05, 0150d, 0150d, 0d150
```

Précéder une valeur numérique par 5 par exemple mais attention habituellement faire précéder une valeur par 0 correspond à une valeur octale mais là ce n'est pas le cas donc `05` est la valeur 5 décimale.

Par exemple 150 indiqué sous forme de pré-fixe : `0150d`.
Idem sous forme de suffixe : `0d150`.
On utilisera `d` ou `t` selon que ce soit du Pascal, selon les assembleurs mais souvent on essaye de favoriser l'inter-compatibilité dans les langages assembleurs.

### Formatage en octal

Pour un octal, on utilise `q` ou `o` mais attention à ne pas confondre avec q-word pour la taille des caractères.

```asm
; d ou t : décimal  ---> 5, 05, 0150d, 0150d, 0d150
; q ou o : octal    ---> 755q, 0o755, 0q755
```

Par exemple sous la forme d'un système de permission avec un petit q à la fin `755q`. C'est un octale aussi si il est précédé d'un zéro et d'un o miniscule `0o755`. Ou encore `0q755` avec un q minuscule.

### Formatage en binaire

`b` ou `y`.

```asm
; d ou t : décimal  ---> 5, 05, 0150d, 0150d, 0d150
; q ou o : octal    ---> 755q, 0o755, 0q755
; b ou y : binaire  ---> 0b11011101, 0b1101_1101, 1101_1101b
```

Avec les underscore, c'est plus facile à lire.

Le `b` peut être suffixe à la fin.

### Formatage en hexadécimal

`h` ou `x` et bien faire précéder de 0 pour éviter l'ambiguïté avec les lettres.

```asm
; d ou t : décimal      ---> 5, 05, 0150d, 0150d, 0d150
; q ou o : octal        ---> 755q, 0o755, 0q755
; b ou y : binaire      ---> 0b11011101, 0b1101_1101, 1101_1101b
; h ou x : hexadécimal  ---> 0xA5, 0xA5h
```

`0xA5` avec x qui peut être remplacé par h `0hA5`.

## Formater des caractères

```asm
bits 64

extern GetStdHandle
extern WriteConsoleA
extern ExitProcess

section .data
    message: db 'Hello World !', 10

section .bss
    written: resq 1

    mydata: resb 64
```

On affiche notre chaîne de caractères séparée d'un nombre d'octets `message: db 'Hello World !', 10`.

On peut noter les caractères 1 par 1 et la valeur retour c'est la valeur décimal `010d`.

```asm
message: db 'H', 'e', 'l', 'l', 'o', 010d
```

Le code décimal `10` pour le retour à la ligne.

Pour une tabulation, on met `9`.

```asm
message: db 'H', 'e', 'l', 'l', 'o', 9, `!`
message: db 'H', 'e', 'l', 'l', 'o', 09d, `!`
```

Différente représentation des chaînes de caractères.

Noté que le code ascii de `A` est `65` donc on peut le noter des deux façons.

## Directive equ

### Calculer la longueur pour une chaîne

On utilise le symbole d'équivalence `equ`.

C'est évalué 1 seule fois car c'est une constante.

```asm
section .data
    message: db 'Hello World !', 10
    MESSAGE_LENGTH: equ $-message

; ...
    mov r8, MESSAGE_LENGTH      ; DWORD nNumberOfCharsToRead
```

### Représenter la valeur True

On représente la valeur décimal 1 par `01d`.

```asm
section .data
    message: db 'Hello World !', 10
    MESSAGE_LENGTH: equ $-message
    TRUE: equ 01d
```

### Représenter la sortie standard

```asm
section .data
    message: db 'Hello World !', 10
    MESSAGE_LENGTH: equ $-message
    TRUE: equ 01d
    STD_OUTPUT_HANDLE: equ -11

; ...
    mov rcx, STD_OUTPUT_HANDLE      ; DWORD nStdHandle
```

Pour des raisons de lisibilité.

### Représenter la taille de l espace fantôme

```asm
section .data
    message: db 'Hello World !', 10
    MESSAGE_LENGTH: equ $-message
    TRUE: equ 01d
    STD_OUTPUT_HANDLE: equ -11
    SHADOWSPACE_SIZE: equ 32

; ...
    sub rsp, SHADOWSPACE_SIZE
; ...
    mov qword [rsp+SHADOWSPACE_SIZE], 0   ; LPVOID pInputControl
; ...
    add rsp, SHADOWSPACE_SIZE+8
```

On comprend maintenant mieux que c'est par la convention Window qu'il nous faut cette espace de 32 octets.

On a remplacé les valeurs brutes par les valeurs incluses dans des constantes.

## Préfixe times

On désire réserver 25 octets ici `exemple: resb 25`. On réserve 25 fois des octets.

```asm
section .bss
    written: resq 1
    exemple: resb 25
```

On pourrait avec `times` répeter 25 fois l'instruction qui réserve 1 octet.

```asm
section .bss
    written: resq 1
    exemple: times 25 resb 1 ; resb 25
```

L'instruction `resb 25` est plus rapide.

Voilà pour les variables et constantes.

A bientôt