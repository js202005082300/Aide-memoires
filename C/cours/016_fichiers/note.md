# [16. Fichiers](https://www.youtube.com/watch?v=j1lHUmwnmA0)

Bonjour à tous et bienvenue pour votre 16e séance et la dernière sur les notions du langage c avant d'attaquer d'autres choses comme les structures de données, la 2d et des choses comme le réseau, la programmation système.

Ce sont vraiment les dernières notions d'accord pour les bases du langage à connaître.

Tout ce que nous verrons par la suite, ce sont des choses en plus qui vont utiliser toutes les notions que vous avez vu du langage.

C'est vraiment la dernière séance au niveau des notions à apprendre.

On va parler des fichiers.

Voir comment gérer des fichiers, la lecture, l'écriture dans des fichiers, enregistrer des données, les lire, etc.

On va voir comment faire tout ça avec pas mal de fonctions, je vous le dis par avance la vidéo va être un peu longue, il va y avoir beaucoup beaucoup de fonctions mais je ne vais pas toutes les montrer et parce qu'il y en a énormément mais je vais montrer celle que vous pouvez rencontrer, celles que vous pourriez avoir besoin selon les cas et on va regarder ça tous ensemble.

Vous allez voir que c'est assez simple à mettre en place, je pense pas que ce soit encore une fois une vidéo compliqué mais il y a beaucoup de choses, vraiment beaucoup beaucoup de fonctions à connaître et à apprendre.

On y va.

```c
#include <stdio.h>

/*

*/

int main(void)
{

    return 0;
}
```

On va gérer des fichiers en mode texte. Le mode texte sont des fichiers que vous pouvez ouvrir avec un éditeur de texte tout simplement et vous avez également des fichiers qui peuvent être ouverts en mode binaire.

Alors si vous voulez lire et écrire dans des fichiers binaires, j'ai fait un tutoriel dans la playlist tutoriel sur le langage c sur la chaîne, vous pouvez retrouvez donc tous les tutoriels et les vidéos en annexe, dedans vous avez une vidéo sur tout ce qui est fichier binaire avec des fonctions qui sont dédiées à cela.

Ici on parle vraiment que de modes formatés donc le mode texte pour être plus simple dans cette séance numéro 16.

On va déjà voir comment ouvrir un fichier et de quelle manière on peut le faire.

Alors on va en créer un déjà, on crée un petit fichier texte très simplement mais l'extension vous mettez ce que vous voulez. Vous pouvez mettre .data, .don, .truc, .bidule

Vous pouvez mettre ce que vous voulez ça n'a absolument rien avoir en fait voilà avec vraiment le vrai format du fichier, ça restera un fichier texte quoi qu'il arrive donc vous mettez un petit peu l'extension que vous voulez.

Moi je vais laisser .txt pour ne pas compliqué et on ne va pas changer si ça marche très bien comme ça et on va mettre par exemple *sauvegarde.txt*.

Admettons que j'ai sauvegardé des données sur un profil par exemple on peut imaginer et je vais mettre des choses dedans.

Alors je vais mettre par exemple mon prénom, je met par exemple mon âge. Qu'est ce que je peux mettre aussi, je peux par exemple mettre le nombre d'abonnés de la chaîne et on a dépassé le cap des 10.000 abonnés au moment où je fais cette vidéo donc voilà on va mettre ça.

+ sauvegarde.txt
```txt
Jason 26 10000
```

Alors on va rester sur ces données voilà je mets des lignes comme ça et on peut imaginer par exemple si on avait fait une liste d'autres Youtuber ou d'autres personnes comme ça, on aurait mis un autre prénom, un autre age et cetera.

Voilà on va déjà lire une ligne, on va déjà voir comment que ça se passe à ce niveau. On rajoutera d'autres choses par la suite voilà alors on va voir déjà comment ouvrir ce fameux fichier d'accord.

Au niveau de mon programme, comment je vais pouvoir ouvrir ce fichier *sauvegarde.txt* ? 

## fopen

On va utiliser pour cela la fonction qui s'appelle fopen() d'accord. fopen() va tout simplement prendre le fichier et elle va prendre un mode d'ouverture, ça je vais en parler.

```c
#include <stdio.h>

/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)
*/

int main(void)
{

    return 0;
}
```

Le mode d'ouverture d'accord ça va être plusieurs modes, je vous les écrits rapidement ça va être un peu répétitif mais vous verrez un peu leur utilité.

On a le mode *r* qui est pour la lecture seule donc un fichier en lecture seule qui doit être créé et qui doit exister.

Voilà on a ensuite le mode *w* d'accord donc là c'est écriture seul, le fichier est créé alors je ne vais pas mettre qu'il doit être créé d'accord je vais juste mettre écriture seul, on va rester comme ça.

On en ensuite *a* donc c'est ajouts en fin de fichier d'accord donc si je ne mets pas que le fichier doit exister ça veut dire que si le fichier n'existe pas c'est le programme en fait qui va créer le fameux fichier d'accord sur lequel on va travailler.

Puis *r+* c'est lecture et écriture, et sachez que le fichier doit exister.

Alors je vais très vite sur les modes puisqu'on aura l'occasion d'en parler un peu, c'est surtout pour qu'après vous ayez vos notes si nécessaire.

Là *w+*, on va voir lecture/écriture d'accord donc ça c'est encore un autre mode possible qui lui va supprimer le contenu d'accord et c'est tout donc le fichier sera bien évidemment créé.

Et on a ensuite *a+* qui est l'ajout pour de la lecture/écriture et en fin de fichiers bien sûr et c'est tout. Le fichier sera bien évidemment créé voilà.

Alors je suis allé très très vite sur ces modes d'accord c'est des modes voilà qu'on utilisera en fonction.

Selon comment vous allez vouloir ouvrir votre fichier ? il faudra choisir le mode.

Si vous voulez simplement lire le fichier d'accord et que le fichier existe déjà vous utiliserez le mode *r*.

Si vous voulez seulement écrire dedans dans un fichier que vous avez déjà créé, vous utiliserez *w*.

Voyez en fonction de ce que vous voulez faire par rapport à ce que j'ai mis là vous ouvrirez le fichier d'une certaine manière, à vous de choisir.

On ne va pas utiliser tous les modes pendant cette vidéo, ça ferait trop long mais sachez que tous les modes qui existent sont les suivants d'accord.

Alors qui dit ouverture des fichiers, dit fermeture.

## fclose

On va voir, on va mettre tout ça en pratique, ne vous en faites pas.

Alors je vous montre déjà ici `fclose(<fichier>)` est une fonction qui va permettre de fermer un fichier d'accord.

Rappelez-vous pour malloc(), on utilisait la fonction free() qui permettait de libérer la mémoire quand on allouait mais là c'est pareil, on a deux fonctions qui fonctionne ensemble.

On a une fonction pour ouvrir le fichier et tout fichier qui a été ouvert doit être fermé une fois qu'on a plus besoin, c'est obligatoire sinon vous allez avoir également des fuites mémoire et cetera donc fermer un fichier ouvert voilà ça c'est obligatoire.

```c
#include <stdio.h>

/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert
*/

int main(void)
{

    return 0;
}
```

Donc on y va. 

Alors pour déclarer un fichier, on va déclarer en fait un pointeur d'accord vers un flux donc c'est le type FILE et je pense que ça vous dit quelque chose, ça c'est une structure, c'est un type de données spéciales d'accord qui est créé par le langage c donc c'est mis en majuscules en général au niveau des structures donc c'est une sorte de `struct FILE` tout simplement on va faire un pointeur que je vais l'appeler fic `FILE *fic` et directement je vais l'ouvrir ici à la déclaration, je vais donc utiliser fopen() d'accord qui est la fonction pour ouvrir, `fopen("");`.


Alors le nom du fichier c'est tout ça, `"sauvegarde.txt"` où il faut mettre l'extension c'est important, si vous l'oubliez cela ne marchera pas, c'est pour ça que vous pouvez mettre l'extension que vous voulez en fait ça va l'ouvrir puisque le temps de trouver le fichier il s'en fiche, et là on va faire de la simple lecture pour commencer donc on va mettre le mode *r* d'accord c'est lecture seule et le fichier bien sûr doit exister, s'il n'existe pas il y aura une erreur d'ouverture.

```c
#include <stdio.h>

/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert
*/

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");



    fclose(fic);

    return 0;
}
```

Voilà et on n'oublie pas bien sûr de fermer le fichier à la fin et ici on va faire des choses entre. Faites ça dès le début comme ça vous êtes sûr de ne pas oublier le fclose() quand vous faites un fopen().

Comme pour toute chose, comme on essaye d'ouvrir un fichier, on n'est pas sûr que ça fonctionne donc faut vérifier donc si `fic==NULL` d'accord si le pointeur est de base NULL parce que si on n'a pas réussi à ouvrir le fichier hé bien on quitte le programme donc on fait comme la dernière fois `exit(1);` et pour ça on va rajouter `#include <stdlib.h>`.

```c
#include <stdio.h>
#include <stdlib.h>

/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert
*/

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");

    if(fic == NULL)
        exit(1);

    fclose(fic);

    return 0;
}
```

`exit(1);` pour quitter le programme ainsi si on peut pas ouvrir le fichier, on ne peut pas utiliser le programme donc on quitte tout de suite le programme, on ne s'embête pas et si jamais ça marche, on pourra accéder à des fonctions donc on va passer de la lecture, et il y aura de l'écriture après mais ça je vais en parler un petit peu après.

## LECTURE

### fgetc

Voilà donc une première fonction que nous allons voir d'accord c'est la fonction fgetc() qui permet de lire un caractère d'accord on va commencer par celle ci.

Pour lire un caractère, vous pouvez utiliser une petite variable pour faire ça, vous pouvez faire une variable de type char par rapport au tableau sur les types de variables, un caractère tient sur des tout-petits nombres d'accords par rapport à la table Ascii mais moi je vais mettre de type entier, je vais rester comme ça `int lettre = 0;`. Par défaut, je met 0 pour initialiser à quelque chose.

```c
#include <stdio.h>
#include <stdlib.h>

/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert

    [LECTURE]
    fgetc(<fichier>) : lire un charactère

    [ECRITURE]
*/

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");
    int lettre = 0;

    if(fic == NULL)
        exit(1);

    fclose(fic);

    return 0;
}
```

On va faire la lecture d'accord c'est à dire si je fais `lettre = fgetc();` par exemple d'être égal à fgetc() d'accord donc ça va lire dans le fichier donc un fichier fic tout simplement je met l'adresse parce que rappelez-vous que c'est un pointeur `lettre = fgetc(fic);` et ainsi cette fonction va lire un caractère du fichier d'accord et après écoutz on va l'afficher tout simplement et donc printf() pour afficher le caractère tout simplement, la fameuse lettre qu'on a récupéré `printf("%c\n", lettre);`.

+ main.C
```c
#include <stdio.h>
#include <stdlib.h>

/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert

    [LECTURE]
    fgetc(<fichier>) : lire un charactère

    [ECRITURE]
*/

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");
    int lettre = 0;

    if(fic == NULL)
        exit(1);

    lettre = fgetc(fic);
    printf("%c\n", lettre);

    fclose(fic);

    return 0;
}
```
+ sauvegarde.txt
```txt
Jason 26 10000
```
```powershell
gcc *.c -o prog
.\prog.exe     
J
```

On teste et voyez qu'il a récupéré le *J* d'accord le tout premier caractère ok.

Si je refais ces deux lignes, hé bien il va récupérer le suivant.

+ main.C
```c
#include <stdio.h>
#include <stdlib.h>

/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert

    [LECTURE]
    fgetc(<fichier>) : lire un charactère

    [ECRITURE]
*/

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");
    int lettre = 0;

    if(fic == NULL)
        exit(1);

    lettre = fgetc(fic);
    printf("%c\n", lettre);

    lettre = fgetc(fic);
    printf("%c\n", lettre);

    fclose(fic);

    return 0;
}
```
+ sauvegarde.txt
```txt
Jason 26 10000
```
```powershell
gcc *.c -o prog
.\prog.exe     
J
a
```

Voilà je fait de la répétition d'accord il peut tout répéter comme ça donc on va faire une petite boucle d'accord de lecture comme ça qu'on utilisera pour toutes les autres fonctions qu'on va voir.

C'est pour ça que j'avais dit que c'était une vidéo un petit peu longue parce qu'il y a pas mal de choses à voir donc en général la méthode la plus simple que je vous recommande et il y en a plein d'accord on peut utiliser le retour de la fonction fgetc() par exemple c'est une possibilité c'est-à-dire que cette fonction va retourner une constante qui s'appelle EOF si jamais on arrive à la fin du fichier ou si jamais elle n'a pas réussi à lire donc vous pouvez faire une boucle while() par exemple qui dit que tant que lettre n'est pas égal à End Of File tout simplement donc qui est en fait une constante aussi en cas d'erreur, on continue de le lire, on peut faire comme ça.

```txt
lettre = fgetc(fic);//EOF
printf("%c\n", lettre);
```

## feof

Ou alors il y a une autre fonction très pratique qui est feof() qui va tester en fait la fin d'un fichier tout simplement d'accord donc si c'est vrai ou si c'est faux mais par contre on doit l'utiliser automatiquement après une première lecture ou une première écriture tout simplement parce qu'il peut y avoir un échec au moment d'une première lecture, première écriture donc faut toujours essayer de lire un caractère comme on l'a fait par exemple ici `lettre = fgetc(fic);` d'accord et après on fait une petite boucle pour dire voilà bah tant que la `feof(fic)` feof() du fichier donc c'est à dire tant que c'est vrai, qu'on arrive pas à la fin du fichier on continue de lire.

```c
/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert
    feof(<fichier>) : lire un caractère

    [LECTURE]
    fgetc(<fichier>) : lire un charactère

    [ECRITURE]
*/
```

Voilà donc je vous recommande de faire même carrément de faire une boucle infinie et on va le faire éventuellement.

On prend cet exemple de `while(1)` donc c'est une boucle infinie c'esst-à-dire que c'est une boucle qui ne va jamais s'arrêter sauf que nous on va lui mettre une condition d'arrêt bien évidemment donc on va lire notre premier caractère `lettre = fgetc(fic);` donc on va faire notre première lecture d'accord ça c'est obligatoire.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");
    int lettre = 0;

    if(fic == NULL)
        exit(1);

    while(1)
    {
        lettre = fgetc(fic);
    }

    fclose(fic);

    return 0;
}
```

De toute façon parce qu'on fait une boucle sur un 1, toujours vrai, donc on est sûr que ce sera fait voilà on fait ça `lettre = fgetc(fic);` et on lui dit que si jamais donc `if(feof(fic))` d'accord qui va renvoyer vrai si on à la fin du fichier ou faux d'accord donc si `feof(fic)` est vrai tu quittes la boucle infini parce qu'il faut une condition d'arrêt donc je fais par exemple un `break`.

Et sinon tu continue de lire chaque caractère donc tu l'affiche pourquoi pas peut faire ça `printf("%c", lettre);` alors c'est pas forcément plus propre mais c'est une solution possible d'accord je vous montre.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");
    int lettre = 0;

    if(fic == NULL)
        exit(1);

    while(1)
    {
        lettre = fgetc(fic);

        if(feof(fic))
            break;
        
        printf("%c", lettre);
    }

    fclose(fic);

    return 0;
}
```
```powershell
gcc *.c -o prog
.\prog.exe     
Jason 26 10000
```

Voyez qu'il affiche toute la ligne du fichier puisqu'il lit chaque caractère un à un jusqu'à la fin du fichier.

C'est une possibilité.

On peut également par rapport à fgetc(), on peut dire que tant que `while((lettre = fgetc(fic)) != EOF)` voilà tant que la lettre est différente de EOF, on lit c'est à dire tout simplement ça `printf("%c", lettre);`.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");
    int lettre = 0;

    if(fic == NULL)
        exit(1);

    while((lettre = fgetc(fic)) != EOF)
    {
        printf("%c", lettre);
    }

    fclose(fic);

    return 0;
}
```
```powershell
gcc *.c -o prog
.\prog.exe     
Jason 26 10000
```

Ok c'est la même boucle.

```txt
while(1)
{
    lettre = fgetc(fic);

    if(feof(fic))
        break;
    
    printf("%c", lettre);
}

// OU

while((lettre = fgetc(fic)) != EOF)
{
    printf("%c", lettre);
}
```

C'est la même chose, voyez au niveau des boucles, moi je ne vous impose pas de méthode, vous faites comme vous voulez.

Simplement faites utiliser les retours des fonctions que je vous montre.

Encore une fois voilà vous voyez ça affiche aussi puisqu'il va lire jusqu'à temps qu'on arrive à la fin de fichier ou qu'il n'arrive plus à lire donc on utilise en fait le retour de la fonction fgetc() c'est possible.

fgetc(), sachez qu'elle retourne EOF donc End Of File en cas d'erreur de lecture ou en cas de fin de fichiers d'accord on peut utiliser ça dans la boucle sans problème donc c'est une possibilité.

Voilà voilà pour fgetc() mais maintenant on va faire la même chose, on va en rester-là pour fgetc() pour le moment. On va avoir une autre fonction c'est fgets().

### fgets

Cette fonction est très utile, elle est sécurisé en plus, un peu plus que ce qu'on peut retrouver ailleurs donc elle est très intéressante à ce niveau là.

fgets() au lieu d'avoir *c* comme *character*, on a un *s* comme *string* donc elle va lire carrément un texte d'accord elle va lire vraiment tout donc on a pour paramètres : la <chaine>, on a la taille <taille> alors la taille de la chaîne, ensuite on a le flux, normalement c'est le flux mais nous on va mettre le fichier parce qu'on parle de fichier d'accord <fichier> on va rester comme ça. Et donc **fgets(<chaine, <taille_chaine>, <fichier>)** lit une ligne tout simplement.

```c
/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert
    feof(<fichier>) : lire un caractère

    [LECTURE]
    fgetc(<fichier>)                            : lire un charactère
    fgets(<chaine, <taille_chaine>, <fichier>)  : lit une ligne

    [ECRITURE]
*/
```

Comment on va faire ça ? eh bien on va tout simplement faire un fgets() donc là on ne fait pas de retour d'accord on s'en fiche du retour pour le coup ici puisque on lit qu'une ligne nous dans ce cas là donc on ne va pas s'embêter.

On fait fgets() et on fait ça dans quelle chaîne ? hé bien on va voir donc on va faire une chaîne spéciale pour ça donc on va faire `signed char texte[256];` et on met 256 puisqu'on va se dire que c'est suffisant, ok donc on va lire là dedans *fgets(texte, 256)* avec 256 pour être sûr de ne jamais dépasser.

Ok je peut même d'ailleurs mettre 255 puisqu'il y a le caractère de fin *fgets(texte, 255)*, on peut mettre ça à la rigueur. Ainsi fgets() a une sécurité voyez il va lire que jusque 255 caractères maximum, elle n'en lira pas plus donc on est sûr que ça va rentrer ici dans notre variable texte et ça va jamais dépasser, et sur quoi ? hé bien sur le fichier `fgets(texte, 256, fic);` voilà et du coup un petit printf() cette fois-ci, on affiche le texte par le `%s`. Voyez ce ne sont plus des caractères qu'on affiche un par un mais c'est un texte complet.

+ sauvegarde.txt
```
Jason 26 10000
```
+ main.c
```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");
    signed char texte[256];

    if(fic == NULL)
        exit(1);

    fgets(texte, 255, fic);
    printf("%s\n", texte);

    fclose(fic);

    return 0;
}
```
```powershell
gcc *.c -o prog
.\prog.exe     
Jason 26 10000
```

Voilà un texte complet voilà ça va fonctionner aussi alors qu'est-ce qui se passe si j'ai plusieurs lignes ? d'accord admettons que dans mon fichier, j'ai également *Bernard 43 253000* c'est-à-dire un Youtubeur avec 253.000 abonnés et il a 43 ans ainsi c'est un fou fou voilà donc si je rééxécute le programme évidemment vous verez que je n'ai qu'une seule ligne puisque je n'ai fait qu'un seul fgets().

+ sauvegarde.txt
```
Jason 26 10000
Bernard 43 253000
```
+ main.c
```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");
    signed char texte[256];

    if(fic == NULL)
        exit(1);

    fgets(texte, 255, fic);
    printf("%s\n", texte);

    fclose(fic);

    return 0;
}
```
```powershell
gcc *.c -o prog
.\prog.exe     
Jason 26 10000

```

Voyez que là j'ai qu'une seule ligne parce que j'ai fait qu'un seul fgets() donc il faudrait éventuellement que je double la ligne fgets() pour lire les deux parce qu'encore une fois ça lit ligne par ligne.

+ sauvegarde.txt
```
Jason 26 10000
Bernard 43 253000
```
+ main.c
```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");
    signed char texte[256];

    if(fic == NULL)
        exit(1);

    fgets(texte, 255, fic);
    printf("%s\n", texte);

    fgets(texte, 255, fic);
    printf("%s\n", texte);

    fclose(fic);

    return 0;
}
```
```powershell
gcc *.c -o prog
.\prog.exe     
Jason 26 10000

Bernard 43 253000
```

On peu pareil faire une fonction fgets() pour laquelle il faut savoir que la fonction ne renvoie pas EOF mais elle renvoie NULL d'accord si en fait on arrive à la fin du fichier  donc on peut faire while() de fgets() texte limité à 255 caractères sur le fichier *fic*, et on teste tout ça tant que c'est différent de NULL `while(fgets(texte, 255, fic) != NULL)` d'accord tant que fgets() de tout ça est différent de NULL donc tant qu'à priori on n'a pas d'erreurs de lecture ou qu'on n'est pas à la fin du fichier, et bien on le fait parce que voyez que le retour est fait et on affiche justement notre texte (pas besoin des accolades pour le coup).

+ sauvegarde.txt
```
Jason 26 10000
Bernard 43 253000
```
+ main.c
```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");
    signed char texte[256];

    if(fic == NULL)
        exit(1);

    while(fgets(texte, 255, fic) != NULL)
        printf("%s\n", texte);

    fclose(fic);

    return 0;
}
```
```powershell
gcc *.c -o prog
.\prog.exe     
Jason 26 10000   

Bernard 43 253000
```

Voyez que là, on arrive à tout lire d'un coup avec une boucle parce que c'est plus propre et on évite de répéter du code inutilement donc avec une petite boucle comme ça donc un petit while(), un do while si voulez même, vous pouvez comme ça lire tout votre texte et je peux avoir autant de lignes que je veux ça marcherait d'accord on peut faire ça sans problème.

Voilà pour cette possibilité.

### fscanf

On a également une troisième fonction intéressante, et ça vous connaissez un peu son utilité en fait quelques part, c'est pas tellement nouveau en fait pour nous parce que fscanf() prend un <fichier> puis un <format> et cetera (...) dont 3 petits points c'est comme pour scanf() en fait sauf que là il y a un *f* devant pour file d'accord donc elle va lire lire du texte formaté.

```c
/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert
    feof(<fichier>) : lire un caractère

    [LECTURE]
    fgetc(<fichier>)                            : lire un charactère
    fgets(<chaine, <taille_chaine>, <fichier>)  : lit une ligne
    fscanf(<fichier>, <format>, ...)            : lit du texte formaté

    [ECRITURE]
*/
```

Qu'est ce que ça veut dire formaté ? vous connaissez c'est quand on met `%s`, `%c`, `%d`, `%f` ça c'est du texte formaté, ça va fonctionner comme pour scanf() mais simplement qu'on va préciser le nom du fichier en premier paramètre avant donc on va faire la même chose et fscanf() retourne 0, je crois, si je ne me trompe pas parce que avec toutes ces fonctions, des fois je confonds et je crois que quand elle n'arrive plus à lire, elle retourne 0 il me semble donc normalement si on fait ça `while(fscanf(fic, ) != 0)` je pense qu'on peut tout lire, je crois.

Mais avant on va le faire sans boucle au début et on verra après.

Alors comment elle fonctionne ? eh bien on va garder le texte donc on va faire `int age = 0;` et on va faire `int nombre_abonnes;` voyez que là je crée plusieurs variables ok c'est du texte formaté c'est-à-dire que fscanf(), on va tout simplement faire ceci *fscanf(fic, "...")* c'est-à-dire qu'on lit sur un fichier *fic* d'accord et on prend des choses formaté, vous avez vu que mon texte il se compose d'un texte un espace un entier un espace un entier.

+ sauvegarde.txt
```
Jason 26 10000
Bernard 43 253000
```

Donc je vais reproduire ici les bons drapeau donc vous savez les % quelque chose dans cet ordre là *Jason 26 10000* d'accord donc je vais dire qu'au début, il ya 1 `%s` un espace puis un premier nombre entier `%d` un espace et un autre  nombre entier `%d` et à ça, je vais dire à quoi correspondent chacun de ces % quelque chose comme on le fait en fait avec printf(), scanf(). Alors le premier va correspondre à du texte d'accord on va le stocker dans le `texte`, le deuxième on va le stocker dans `age` et enfin `nombre_abonnes` d'accord comme pour scanf() sauf qu'on met le nom du fichier et que devant le nom du fichier il y a un *f* c'est tout `fscanf(fic, "%s %d %d", texte, age, nombre_abonnes);`.

+ sauvegarde.txt
```
Jason 26 10000
Bernard 43 253000
```
+ main.c
```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "r");
    signed char texte[256];
    int age = 0;
    int nombre_abonnes = 0;

    if(fic == NULL)
        exit(1);

    fscanf(fic, "%s %d %d", texte, &age, &nombre_abonnes);

    printf("Nom : %s\n", texte);
    printf("Abonnes : %d\n", nombre_abonnes);

    fclose(fic);

    return 0;
}
```
```powershell
gcc *.c -o prog
.\prog.exe     
Nom : Jason
Abonnes : 10000
```

C'est bon simplement comme un scanf() alors il ne faut pas oublier le & commerciale pour tout ce qui n'est pas un pointeur, il faut indiquer son adresse, toujours pareil comme pour le scanf() donc forcément ça risque de planter.

Voilà tout simplement donc la même lecture et là bas au lieu d'avoir carrément tout dans un seul buffer en fait tout simplement, dans une seule chaîne de caractères, on peut voyez récupérer ça du coup dans des variables entière, des `int` et cetera, on peut travailler avec, faire des calculs, tout ça. C'est un avantage des fois, on est obligé de récupérer ça `int nombre_abonnes` pour récupérer les valeurs parce que là j'ai le nombre d'abonnés d'un côté tout seul, je  peux faire des choses dessus. Avec l'âge, je peux faire des tests sur l'âge, ça m'évite d'avoir tout dans un texte.

Ok donc c'est intéressant à ce niveau là.

Voilà pour la lecture, on va passer à l'écriture, je vais essayer d'accélérer un tout petit peu.

## ECRITURE

### fputc

L'écriture vous avez les trois mêmes fonctions mais pour écrire d'accord donc vous avez fputc() qui va écrire un caractère dans un fichier d'accord.

Vous avez fputs(), c'est la même chose mais cette fois-ci pour écrire une chaîne, vous avez le fichier et donc pas besoin de mettre la taille de lecture parce qu'on écrit tout ce qu'il y a à écrire, on ne s'embête pas, c'est la lecture qui peut ne pas être sécurisée donc là on écrit une chaîne, une ligne de texte. 

Et on va avoir fprintf() qui fonctionne comme un printf() simplement qu'au début, on a le fichier ensuite on a les fameux format d'accord et puis les 3 petits points c'est le nombre de variables qui peuvent être liés à ça donc là un écrit du texte formaté.

```c
/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert
    feof(<fichier>) : lire un caractère

    [LECTURE]
    fgetc(<fichier>)                            : lire un charactère
    fgets(<chaine, <taille_chaine>, <fichier>)  : lit une ligne
    fscanf(<fichier>, <format>, ...)            : lit du texte formaté

    [ECRITURE]
    fputc(<caractère>, <fichier>)               : écrit un caractère
    fputs(<chaîne>, <fichier>)                  : écrit une ligne de texte
    fprintf(<fichier>, <format>, ...)           : écrit du texte formaté
*/
```

Ok je vais pas les tester rapidement, je vais aller très vite puisque c'est comme pour la lecture sauf que c'est de l'écriture donc là on va changer l'ouverture et on va passer en écriture seule d'accord sur un fichier qui existe déjà.

```txt
FILE *fic = fopen("sauvegarde.txt", "r");

... passe en lecture seule :

FILE *fic = fopen("sauvegarde.txt", "w");
```

Alors on reprend tout depuis 0 et on va faire une écriture, on efface même le contenu *sauvegarde.txt* hop et on va faire une écriture donc on va alléger notre code, et on y va donc on a ouvert un fichier en écriture, je vais faire un fputc() et je vais dire tu marque *J* dans fic, puis on exécute tout ça.

+ sauvegarde.txt
```

```
+ main.c
```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "w");

    if(fic == NULL)
        exit(1);

    fputc('J', fic);

    fclose(fic);

    return 0;
}
```
```powershell
gcc *.c -o prog
.\prog.exe     
```
+ sauvegarde.txt
```
J
```

Ok on exécute tout ça alors regardez donc le fichier je rappelle que avant exécution il est vide ok ensuite on exécute hop, on va aller voir notre fichier, on va l'ouvrir et cette fois ça il a bien ajouté le *J*  d'accord.

Si je fais la même chose pour ajouter autre chose `fputc('a', fic);`, il va m'ajouter les deux caractères à la suite d'accord.

+ sauvegarde.txt
```
J
```
+ main.c
```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("sauvegarde.txt", "w");

    if(fic == NULL)
        exit(1);

    fputc('J', fic);
    fputc('a', fic);

    fclose(fic);

    return 0;
}
```
```powershell
gcc *.c -o prog
.\prog.exe     
```
+ sauvegarde.txt
```
Ja
```

Donc on peut écrire comme ça dans un fichier, on peut faire une espèce de mini éditeur, on peut s'amuser à faire ça tout à fait possible avec une boucle infinie qui dirais qu'il y a quelque chose à lire.

Ainsi une fois que vous avez fini de marquer votre texte, ça ferme le fichier et vous avez fait un mini éditeur de texte tout simplement, ça peut se faire tout à fait.

Voilà donc ça c'est fputc() d'accord très simple, on peut faire une boucle si on veut écrire plusieurs choses, vous avez compris ce système.

## fputs

```c
/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert
    feof(<fichier>) : lire un caractère

    [LECTURE]
    fgetc(<fichier>)                            : lire un charactère
    fgets(<chaine, <taille_chaine>, <fichier>)  : lit une ligne
    fscanf(<fichier>, <format>, ...)            : lit du texte formaté

    [ECRITURE]
    fputc(<caractère>, <fichier>)               : écrit un caractère
    fputs(<chaîne>, <fichier>)                  : écrit une ligne de texte
    fprintf(<fichier>, <format>, ...)           : écrit du texte formaté
*/
```

Pour fputs(), on va carrément supprimer le fichier *sauvegarde.txt* et on créer un *profil.save* par exemple, et on va le faire comment ? Alors on va le faire en écrire et en écriture, il crée le fichier si jamais il n'existe pas donc il n'y a pas besoin que le fichier existe déjà donc on va faire un fputs() donc fputs(), il prend quoi ? il prend au début la chaîne donc la chaîne ça peut être le contenu d'une variable  par exemple `mot[]`, on pourrais très bien faire ça.

```txt
char mot[] = "Bonjour";

fputs(mot, fic);
```

+ main.c
```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("profil.save", "w");
    char mot[] = "Bonjour";

    if(fic == NULL)
        exit(1);

    fputs(mot, fic);

    fclose(fic);

    return 0;
}
```
```powershell
gcc *.c -o prog
.\prog.exe     
```
+ profil.save
```
Bonjour
```

Voyez il me crée un fichier *profil.save* d'accord voyé avec la bonne extension comme je voulais et si je j'ouvre mon fichier avec mon éditeur de texte puisque c'est un fichier en mode formaté donc en mode texte, j'ai bien le contenu à l'intérieur comme je voulais voilà je vais re supprimer tout ça.

```txt
    c.
    |_ main.c
    |_ profil.save
    |_ prog.exe
```

## fprintf

```c
/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert
    feof(<fichier>) : lire un caractère

    [LECTURE]
    fgetc(<fichier>)                            : lire un charactère
    fgets(<chaine, <taille_chaine>, <fichier>)  : lit une ligne
    fscanf(<fichier>, <format>, ...)            : lit du texte formaté

    [ECRITURE]
    fputc(<caractère>, <fichier>)               : écrit un caractère
    fputs(<chaîne>, <fichier>)                  : écrit une ligne de texte
    fprintf(<fichier>, <format>, ...)           : écrit du texte formaté
*/
```

Voilà rien de plus et on termine avec fprint(), c'est pour ça que j'allais un peu plus vite ici.

Admettons qu'on sauvegarde ceci : `char pseudo[] = "Naoki";`, `int age = 26;` et `int abonnes = 10000;`. Ainsi comme tout à l'heure, on a le fichier au début *fprintf(fic,...)* et alors je veux stocker au début l'âge ensuite le prénom et enfin le nombre d'abonnés donc ça `fprintf(fic, "%d %s %d", &age, pseudo, &abonnes);`. Voyez je peux choisir le formatage, la mise en forme de mon texte.

+ profil.save
```

```
+ main.c
```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("profil.save", "w");
    char pseudo[] = "Naoki";
    int age = 26;
    int abonnes = 10000;

    if(fic == NULL)
        exit(1);

    fprintf(fic, "%d %s %d", age, pseudo, abonnes);

    fclose(fic);

    return 0;
}
```
```powershell
gcc *.c -o prog
.\prog.exe     
```
+ profil.save
```
26 Naoki 10000
```

J'exécute, ça m'a créé le fichier qui s'est bien mis dans le format que je voulais voilà donc très simple pour l'utilisation de ces 3 fonctions, c'est la même chose puis pour l'écriture c'est plus simple puisqu'il n'y a pas forcément besoin de faire de boucles et on n'a pas besoin mais en fait si on peut s'assurer que c'est bien écrit, c'est toujours mieux mais je veux dire qu'il n'y a pas besoin par exemple de sécuriser non plus parce que l'écriture écrit tout ce que vous lui donnez donc la donnée existe déjà de toute manière, ce n'est pas comme s'il récupérait quelque chose dans une variable qui est vide, là il écrit avec une variable qui contient déjà des informations donc là l'écriture se fait plus simplement qu'une lecture.

Voilà pour cette partie-là, la lecture et l'écriture, vous savez comment ça fonctionne donc j'espère que j'ai pas été trop trop long mais j'ai pris le temps de vous expliquer ça parce qu'il y a déjà beaucoup de fonctions donc déjà 6 fonctions juste pour la lecture et l'écriture, ça fait fopen(), fclose() et feof() ici que je vous avais expliqué qu'on peut utiliser donc ça fait pas mal de choses mine de rien donc voilà.

+ [fopen](note.md#fopen)
+ [fclose](note.md#fclose)
+ [feof](note.md#feof)

+ [LECTURE](note.md#LECTURE)
    + [fgetc](note.md#fgetc)
    + [fgets](note.md#fgets)
    + [fscanf](note.md#fscanf)

+ [ECRITURE](note.md#ECRITURE)
    + [fputc](note.md#fputc)
    + [fputs](note.md#fputs)
    + [fprintf](note.md#fprintf)

## POSITIONNEMENT

```c
/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert
    feof(<fichier>) : lire un caractère

    [LECTURE]
    fgetc(<fichier>)                            : lire un charactère
    fgets(<chaine, <taille_chaine>, <fichier>)  : lit une ligne
    fscanf(<fichier>, <format>, ...)            : lit du texte formaté

    [ECRITURE]
    fputc(<caractère>, <fichier>)               : écrit un caractère
    fputs(<chaîne>, <fichier>)                  : écrit une ligne de texte
    fprintf(<fichier>, <format>, ...)           : écrit du texte formaté

    [POSITIONNEMENT]
    ftell(<fichier>) : retourne position curseur dans fichier

    fseek(<fichier>, <deplacement>, <origine>) : déplace le curseur

        -> <origine> :  SEEK_SET (début fichier)
                        SEEK_CUR (position courante)
                        SEEK_END (fin fichier)
    
    rewind(<fichier>) : réinitialise la position du curseur
*/
```

On peut terminer sur quelques petites fonctions pour le positionnement de textes notamment et des fonctions diverses à leur positionnement, on va en rajouter ici. Je termine avec ça d'accord on va avoir trois petites fonctions dont ftell() qui tout simplement retourne la position du curseur dans le fichier, vous allez  comprendre.
~
+ ftell()
```txt
ftell(<fichier>) : retourne position curseur dans fichier
```

+ fseek()
On fseek() qui prend le fichier <fichier> et qui prend ensuite le <deplacement> et qui prend ensuite une constante qu'on va appeler <origine> qui déplace le curseur.

```txt
fseek(<fichier>, <deplacement>, <origine>) : déplace le curseur

    -> <origine> :  SEEK_SET (début fichier)
                    SEEK_CUR (position courante)
                    SEEK_END (fin fichier)
```

Alors <origine> de fseek(), on a SEEK_SET pour le début fichier, puis on a ensuite SEEK_CUR pour la position courante donc celle actuelle, et on a SEEK_END qui est la fin du fichier.

+ rewind()
Voilà et on a ensuite rewind(<fichier>) qui réinitialise tout simplement la position du curseur.

```txt
rewind(<fichier>) : réinitialise la position du curseur
```

Ok donc ça c'est les trois dernières choses et on verra deux petites fonctions à la fin sur les traitements de fichiers, très rapide pour voir ça.

Alors je vais aller assez vite encore une fois parce que vous n'allez pas forcément utiliser ce genre de fonction tout de suite, il faut les connaître d'accord faut savoir voilà qu'il y a fonction comme ça pour travailler sur la position du curseur.

Faut imaginez tout simplement que c'est comme un petit comme lorsqu'on déplace un curseur dans un fichier, voyez là, il est à 0.

```txt
|26 Naoki 10000
```

Là, il est à 1.

```txt
2|6 Naoki 10000
```

Là, il est à 2.

```txt
26| Naoki 10000
```

### ftell

Et cetera, ça permet des fois de se positionner à certain endroit pour modifier, retirer du texte et cetera couper et cetera, de faire des choses dessus par exemple si par défaut je fais alors je fait `int position_curseur = -1;` donc jusque là on ouvre un fichier en mode *r* d'accord et je vais lui dire de m'afficher la position `printf("Position : %d\n", ftell(fic));` où il fait tout simplement un ftell() pour me retourner la position dans fic.

On y va.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("profil.save", "r");
    int position_curseur = -1;

    printf("Position : %d\n", ftell(fic));

    fclose(fic);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe        
Position : 0
```

Voilà la position est 0 d'accord je peux déplacer ce curseur en imaginant en fait que le curseur est ici.

```txt
|26 Naoki 10000
```

Le curseur ici peut être déplacé donc vous n'allez pas le voir en temps réel d'accord il faudrait que je fasse un affichage mais ça ferait quelque chose de très très gros pour rien.

### fseek

On va le déplacer donc on va faire tout simplement un *fseek(fic, 5, ...);* donc je vais dire que dans le fichier je me déplace de 5 donc un déplacement vers la droite par exemple à partir d'où ? donc l'origine donc à partir du début du fichier c'est-à-dire SEEK_SET par exemple `fseek(fic, 5, SEEK_SET);` et ensuite tu me réaffiche la position `printf("Position : %d\n", ftell(fic));`.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("profil.save", "r");
    int position_curseur = -1;

    printf("Position : %d\n", ftell(fic));

    fseek(fic, 5, SEEK_SET);
    printf("Position : %d\n", ftell(fic));

    fclose(fic);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe        
Position : 0
Position : 5
```

### rewind

Au début c'est à 0 puis ça passe à 5, ça a fonctionné et finalement, je vais remettre la position du curseur au début sur fic, `rewind(fic);`. Je vais très vite parce que ce sont des fonctions simples à utilisées.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("profil.save", "r");
    int position_curseur = -1;

    printf("Position : %d\n", ftell(fic));

    fseek(fic, 5, SEEK_SET);
    printf("Position : %d\n", ftell(fic));

    rewind(fic);
    printf("Position : %d\n", ftell(fic));

    fclose(fic);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe        
Position : 0
Position : 5
Position : 0
```

Voilà la position revient bien à 0, très bien d'accord donc ça c'est utile voyez sur le déplacement, on peut partir du début du fichier, de la position courante ou la fin du fichier, ça peut être utile dans certains cas pourquoi pas donc c'est bien à savoir.

Voilà pour les fonctions de positionnement, je suis allé assez vite.

Si encore une fois, si jamais vous avez besoin de les utiliser et que vous voulez en savoir plus, entraînez vous avec puis posez des questions dans les commentaires, je vous aiderai sans souci.

Je vais très vite parce que je vous apprends à manipuler et le plus important c'était la lecture et l'écriture, j'ai bien pris du temps pour le positionnement puisque là ce que je vais vous montrer là pour la fin c'est vraiment des petits bonus en fait.

Du coup on termine avec des choses diverses, on va mettre divers.

## DIVERS

Là on va avoir deux petites fonctions toutes bêtes, on va avoir la fonction rename() qui va permettre de changer le nom d'un fichier, elle prend un <ancien_nom> et un <nouveau_nom>. Ensuite, on a remove() du <fichier> et il faudra faire attention à celle-là.

```c
/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert
    feof(<fichier>) : lire un caractère

    [LECTURE]
    fgetc(<fichier>)                            : lire un charactère
    fgets(<chaine, <taille_chaine>, <fichier>)  : lit une ligne
    fscanf(<fichier>, <format>, ...)            : lit du texte formaté

    [ECRITURE]
    fputc(<caractère>, <fichier>)               : écrit un caractère
    fputs(<chaîne>, <fichier>)                  : écrit une ligne de texte
    fprintf(<fichier>, <format>, ...)           : écrit du texte formaté

    [POSITIONNEMENT]
    ftell(<fichier>) : retourne position curseur dans fichier

    fseek(<fichier>, <deplacement>, <origine>) : déplace le curseur

        -> <origine> :  SEEK_SET (début fichier)
                        SEEK_CUR (position courante)
                        SEEK_END (fin fichier)
    
    rewind(<fichier>) : réinitialise la position du curseur

    [DIVERS]
    rename(<ancien_nom>, <nouveau_nom>)
    remove(<fichier>)
*/
```

Alors il faut le faire sur un fichier qui est fermé, ça paraît logique on ne peut pas renommer le nom d'un fichier qui est ouvert d'accord donc là j'ai fermé le fichier déjà de mon côté, on va virer notre exécutale et ce qui est inutile.

```txt
    c.
    |_ main.c
    |_ profil.save
```

### rename

```txt
[DIVERS]
rename(<ancien_nom>, <nouveau_nom>)
remove(<fichier>)
```

On va chercher à ne pas avoir *profil.save* ouvert sinon on va être embêté.

Alors on va faire `rename("profil.save", "data.save");` et on y va mais attention, ne pas essayer de le faire sur un fichier ouvert sinon pas de changement.
```txt
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic = fopen("profil.save", "r");
    
    rename("profil.save", "data.save");

    fclose(fic);

    return 0;
}
```

On y va.

```txt
    c.
    |_ main.c
    |_ profil.save
```
```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{   
    rename("profil.save", "data.save");

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe        
Position : 0
Position : 5
Position : 0
```
```txt
    c.
    |_ main.c
    |_ data.save
```

Voilà *data.save* au lieu de *sauvegarde.save* donc c'est important, il ne faut pas le faire sur un fichier que vous avez ouvert dans votre code, ça se fait tout seul rename() pour vraiment modifier quelque chose.

### remove

```txt
[DIVERS]
rename(<ancien_nom>, <nouveau_nom>)
remove(<fichier>)
```

Pour remove() c'est la même chose, c'est *remove(<fichier>)*.

Alors attention parce que c'est comme pour certaines commandes système ça ne pas passer par la corbeille de votre windows, Linux ou autre. Si vous faites un remove() c'est supprimer directement, il ne va pas vous le mettre dans votre corbeille pour pouvoir le récupérer donc là le fichier va tout simplement disparaître.

Il ne faut pas faire ça n'importe comment, à la va-vite, il faut faire attention et là on y va.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{   
    remove("data.save");

    return 0;
}
```
```powershell
dir /b
    data.save
    main.c
    prog.exe
    sauvegarde.txt
gcc main.c -o prog
prog.exe
dir /b
    main.c
    prog.exe
    sauvegarde.txt
```

Alors si vous faites un remove(), c'est supprimé directement, il ne va pas les mettre dans votre corbeille pour pouvoir le récupérer donc là le fichier va tout simplement disparaître donc il faut être sûr de vous, il ne faut pas faire ça n'importe comment comme ça à la vite, il faut faire attention et là boum, plus de fichier, terminé et ne cherchez pas dans la corbeille de toute façon il n'y est pas donc de toute façon c'est pas récupérable en tout cas sauf via des logiciels mais on ne peut pas le récupérer depuis la corbeille en tout cas.

Voilà vous avez vu tout ce que je voulais vous montrer au niveau des fichiers surtout la partie lecture/écriture qui est importante ça c'était vraiment bien à connaître.

Pour le reste, le positionnement je suis allé très vite, si vous en avez vraiment besoin, n'hésitez pas à me demander dans les commentaires pour que je vous explique mieux, plus en détails en tout cas l'utilisation de ces fonctions là si vraiment vous en avez besoin.

Celle-là remove() est très simple, je pense que l'utilisation est assez rapide et assez simple et puis vous avez vu tout ce qu'il fallait voir.

Voilà vous avez terminé avec les notions du langage c, vous connaissez toutes les notions de ce langage d'accord tout ce qui va venir s'ajouter maintenant, les structures de données, la programmation système, le réseau, la 2d avec la bibliothèque sdl, tout ça c'est des ajouts, c'est des choses qui utilise toutes les notions c'est-à-dire les pointeur, les tableaux, les chaînes, les fichiers, les variables, les boucles, les structures, etc, etc.

Vous avez toutes les notions maintenant en main pour pouvoir vous perfectionner, vous entraîner, faire des vrais projets pourquoi pas amusez à faire de vrais projets pour vous entraînez, pour vous confronter à des difficultés, pour corriger certaines choses et puis pour vous améliorer et puis je vous dis que moi je suis là dans tous les cas si vous avez des questions, si vous avez besoin d'aide pour quoi que ce soit n'hésitez  pas je serai présent pour vous.

Voilà on va s'arrêtez-là, on se retrouvera du coup pour une prochaine vidéo avec plein de bonnes choses puisqu'on va attaquer les structures de données c'est une manière en fait d'organiser les données avec des avantages, des inconvénients, vous verrez un peu tout ça donc on va démarrer avec ces structures de données puis par la suite on continuera avec de la 2d et puis le réseau, etc.

Enfin voilà il y a pas mal de choses encore qui vous attendent mais en tout cas vous pouvez considérer qu'à partir de cette vidéo, vous avez vu toutes les notions de langage c.

Voilà vous avez absolument tout ce qu'il faut savoir pour étudier n'importe quelle bibliothèque du langage quelqu'un qui aurait développé une bibliothèque de je ne sais pas quoi vous pouvez travailler dessus sans problème, vous avez tout ce qu'il faut pour comprendre ou en tout cas presque tout ce qu'il faut pour comprendre parce que après il y a quelques petites exceptions mais vous avez tout ce qu'il faut voilà.

A très bientôt, on se retrouvera la prochaine fois pour la séance numéro 17 si je me trompe pas.

En attendant portez vous bien, entraînez-vous, revoyez un petit peu tout ça.

N'hésitez pas à revoir les anciennes vidéos puisque c'est toutes les notions qui vont vous servir et on se voit la prochaine fois pour parler des structures de données.

A bientôt tout le monde