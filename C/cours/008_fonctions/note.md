# [8. Fonctions](https://www.youtube.com/watch?v=TT2RbNKr4aU)

Bonjour, nous allons parler des fonctions. Je vous avais prévenu dans la vidéo précédente de bien préparer, de bien revoir tout ce que vous aviez vu sur ces 7 premières séances avant d'attaquer la 8e peu sereinement.

Nous allons voir comment ça fonctionne et cette notion est une des plus importantes, comme les variables, c'est une des plus importantes des langages parce qu'elle existe dans à peu près tous les langages de programmation.

Sachez que l'ancêtre de la fonction est la procédure, que les fonctions les plus récentes ce sont les méthodes de classe quand on fait de l'objet. Voilà grosso modo ça reste la même chose et vous allez voir comment cela fonctionne et s'agence au niveau du code et comment on les utilise et travaille avec tout ça.

On va directement passer au code et voir comment les utiliser.

```c
#include <stdio.h>

int main(void)
{

    return 0;
}
```

Voilà je vais vous faire un petit rappel très rapidement pour vous montrer un petit peu les fonctions que vous connaissez jusqu à présent. Alors vous avez vu des fonctions très simples, vous avez vu printf(), vous avez vu scanf() et d'autres ce sont des fonctions que vous avez eu l'occasion d'utiliser.

```c
#include <stdio.h>

int main(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */

    return 0;
}
```

Alors les fonctions, vous avez appris à les appeler. On appelle ça un appel de fonction. Vous avez appris à mettre des choses dans les parenthèses c'est à dire des paramètres et puis la valeur de retour donc par exemple printf() affiche dans notre terminal, scanf() demande une information donc elle va permettre de saisir une information au clavier.

Chacune des fonctions leur utilité donc vous avez du coup remarqué qu'une fonction ne faisait qu'une seule chose.

Voyez il y a vraiment une règle comme ça où on part du principe, c'est une règle, une convention, qu'on essaye en général d'adopter. On part du principe qu'une fonction est amenée à faire une seule chose, printf() par exemple ne va pas s'amuser à afficher du texte, imprimer ou je ne sais quoi, enregistrer dans un fichier bref elle ne va pas faire 15000 choses à la fois sinon elle perdrait tout son sens.

Printf() si on regarde dans les manuels, c'est une fonction qui sert à afficher sur la sortie standard quelque chose comme une donnée formatée c'est à dire le fameux drapeaux %d, %f, et cetera comme on a vu précédemment alors ça c'était son utilisation.

Pour le scanf(), c'est la même utilisation c'est à dire que c'est du formaté mais ici c'est de la saisie formatée tout simplement, c'est même pour ça que par défaut la fonction n'est pas sécurisée et on verra dans un tutoriel comment faire de la saisie de données de manière sécurisée avec scanf() qu'on peut quand même utiliser de manière sécurisée c'est juste que voilà de base elle ne l'est pas.

En général quand on veut faire quelque chose de très sécurisé on évite d'utiliser scanf() mais on peut quand même s'en servir en faisant attention.

Alors ça ce sont les fonctions que vous connaissez, je ne vais pas revenir dessus, vous savez comment appeler une fonction grosso modo c'est à dire qu'on rentre le nom de la fonction, on lui donne les paramètres quelle demande, elle suit certains paramètres, certaines règles dont elle a besoin, elle fait son boulot comme il faut et on obtient donc un résultat.

Nous on va voir directement comment est-ce qu'on crée une fonction pour l'utiliser parce que vous allez pouvoir créer vos fonctions.

## Créer une fonction

Admettons qu'on soit sur un jeu avec une espèce de balle, on va dire que la balle coordonnées X et Y qui sont les coordonnées de la balle sur notre écran, sur notre jeu vidéo, et on aimerait pouvoir initialiser la balle à chaque fois à une position pour le jeu.

Alors vous imaginez bien que à chaque fois qu'on fait une partie pour le jeu, vous allez devoir initialiser la balle, si vous faites une nouvelle partie, il faudra réinitialiser la balle et si vous quittez le jeu et que vous revenez il faudra recommencer voilà il y aura beaucoup de réinitialisation de position Ball faites en fait sur toute l'exécution du programme donc il peut y en avoir des dizaines voire même des centaines si vous faites une partie pendant 4h, ça peut être très très long de devoir relancer les parties à chaque fois.

En temps normal je devrais toute initialiser à 0 parce qu'en général par exemple on met toujours la balance au centre donc on fera un petit calcul pour que la balle soit centrée mais nous on va se contenter de 0 et 0.

```txt
balleX = 0;
balleY = 0;
```

Voilà on dira qu'une partie est en train de se faire, hop le joueur a perdu ou a gagné, et ensuite on recommence (position X et Y à 0).

```c
#include <stdio.h>

int main(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */
    int balleX;
    int balleY;

    balleX = 0;
    balleY = 0;

    //Une partie de jeu se fait...

    balleX = 0;
    balleY = 0;

    return 0;
}
```

Voilà mais imaginez qu'entre-temps la balle elle aurait changé, comme la balle s'est déplacée on pourrait admettre par exemple ceci voilà admettons que la position de la balle aurait changé.

```c
#include <stdio.h>

int main(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */
    int balleX;
    int balleY;

    balleX = 0;
    balleY = 0;

    //Une partie de jeu se fait...
    balleX = 175;
    balleY = 80;

    balleX = 0;
    balleY = 0;

    return 0;
}
```

Voilà c'est un exemple mais du coup vous voyez qu'on va avoir besoin de réinitialiser à chaque fois c'est à dire qu'on fait de la **répétition de code** et ça on ne veut pas te faire de la répétition de code.

À partir du moment ou vous voyez qu'il y a du code qui se répète, il faut tout de suite que vous ayez le réflexe de vous dire ça qu'il faut le mettre dans une fonction, ainsi une fonction permet de factoriser c'est-à-dire d'englober un bout de code que vous allez écrire à plusieurs reprises dans un programme pour qu'il ne soit que dans cette fonction une bonne fois pour toute.

Vous voyez l'utilité que ça peut avoir.

Maintenant on va créer notre fonction mais je vais vous expliquer pourquoi c'est aussi intéressant.

Admettons que vous travaillez pour quelqu'un dans une boîte de jeux vidéo, dans cette boîte de jeu qui est fabriqué un jeu avec une balle en mousse qui saute partout. On a décidé que l'initialisation de la balle se ferait à (0,0) de coordonnées mais imaginons qu'à un moment donné et ça arrive souvent s'il y a des gens qui écoutent ça et qui bossent dans le jeu vidéo, qui passerait par ça, il arrive très souvent surtout quand vous bosser pour un client ou un chef de projet pour lequel les choses bougent beaucoup, c'est possible que si vous arrivez le lendemain on vous dise ça ne va pas du tout et que via le chef il a été décidé que la balle soit initialisée aux coordonnées (150, 85) par exemple donc nous entends développeur on va devoir faire ceci.

```c
#include <stdio.h>

int main(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */
    int balleX;
    int balleY;

    balleX = 150;
    balleY = 85;

    //Une partie de jeu se fait...
    balleX = 175;
    balleY = 80;

    balleX = 150;
    balleY = 85;

    return 0;
}
```

Et cetera mais là vous voyez que je ne les que 2 fois, ça se fait assez vite mais imaginez sur un programme de plusieurs dizaines de milliers de lignes de code, on aurait dû faire ça je ne sais pas combien de fois mais c'est une perte de temps.

Voilà c'est une perte de temps et de performance, ça ne va pas du tout.

Nous pour éviter de faire ce genre de choses, on va créer une fonction et pour ça on va déjà la mettre ici. 

Pour créer une fonction va avoir un schéma déjà très simple, une fonction porte un nom comme pour les variables ce sont les mêmes règles c'est à dire qu'il ne faut pas qu'elle commence par un chiffre, il ne faut pas qu'il n'y ait de caractères spéciaux, il ne faut pas qu'il y ait d'espace par contre vous pouvez utiliser le tiret du bas c'est à dire le underscore qui fonctionne aussi.

Alors voilà ce sont les mêmes règles de nommage que pour les variables donc si vous voulez voir comment est-ce qu'on nomme une fonction correctement, revoyez la vidéo sur les variables comme ça vous aurez toutes les explications.

Il faut qu'elle ait un nom, il faut ensuite qu'elle entre parenthèses les paramètres qu'elle prend en compte donc le type du paramètre et le nom de la variable, vous verrez pourquoi, et elle aura éventuellement (ce n'est pas obligatoire) une valeur de retour donc un type, qu'est-ce qu'elle retourne comme valeur ? Est ce qu'elle retourne un entier donc un int ? Est ce qu'elle retourne une chaîne de caractères ? Est ce que le retournera un float ? 

D'ailleurs si vous Regardez la fonction main(), qui est la fonction obligatoire c'est à dire ne faites jamais de programme en langage c sans mettre cette fonction. Elle est obligatoire.

Le compilateur ici dans notre environnement de développement, il va chercher une fonction qui s'appelle main() qui est sous ce format là.

Si vous n'avez pas de fonction mail c'est à dire par exemple si vous mettez ça `int debut(void)` ça ne marchera pas.

```c
#include <stdio.h>

int debut(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */
    int balleX;
    int balleY;

    balleX = 150;
    balleY = 85;

    //Une partie de jeu se fait...
    balleX = 175;
    balleY = 80;

    balleX = 150;
    balleY = 85;

    return 0;
}
```
```powershell
gcc main.c -o prog
c:/users/sam/onedrive/programmes/mingw64/bin/../lib/gcc/x86_64-w64-mingw32/10.2.0/../../../../x86_64-w64-mingw32/bin/ld.exe: c:/users/sam/onedrive/programmes/mingw64/bin/../lib/gcc/x86_64-w64-mingw32/10.2.0/../../../../x86_64-w64-mingw32/lib/../lib/libmingw32.a(lib64_libmingw32_a-crt0_c.o):crt0_c.c:(.text+0x46): undefined reference to `WinMain'
collect2.exe: error: ld returned 1 exit status
```

Voyez `undefined reference to WinMain` donc il cherche une fonction main qui n'existe pas donc des fois vous pouvez obtenir aussi cette erreur quand votre fichier n'est pas encodé en utf 8. J'en profite pour le rappeler ça n'oubliez pas, pour tout ce qui est programmation vos fichiers doivent être en utf 8 par exemple sur sublimetext c'est dans File>Save with Encoding>UTF-8 mais attention c'est UTF-8 sans le BOM. BOM C'est par rapport à certaines instructions de retour selon l'os (Windows, Linux et cetera) donc vous vous avez juste à mettre en UTF-8.

Donc si vous avez un *WinMain* c'est que soit vous avez pas votre fichier en utf 8 ou alors c'est que vous n'avez pas de fonction main.

Vous voyez `int main(void)` possède un nom, elle a des parenthèses avec des paramètres donc quand elle n'a pas de paramètre la convention veut que l'on mette le mot-clé void mais par exemple en c++ il n'y a pas besoin de le mettre donc on peut faire comme ceci `int main()` en c++. Vous pouvez essayer de faire comme ceci en c ça marchera mais essayer de le faire le moins possible et dès que vous n'avez pas de paramètre, mettez le mot clé void pour bien indiquer que ce n'est pas un oubli ou une erreur mais vraiment pour dire qu'il n'y a rien du tout.

Alors on verra à quoi sert le mot-clé void parce que il a une certaine utilité dans certains cas pour la suite.

Alors `int main(void)` a également une valeur de retour qui est un int, il retourne un entier.

D'ailleurs vous pouvez voir dans la fonction qu'on retourne 0.

Tout ça je vous l'avais expliqué dans la vidéo précédente et on a eu l'occasion d'en parler dans cette vidéo.

On y va pour notre fonction on va choisir un nom init_ball(), auquel je vais prendre les 2 valeurs de coordonnées.

```c
init_ball(posX, posY);
```

Voyez elle a 2 variables, et est ce qu'elle retourne quelque chose ? alors oui on va dire qu'elle retourne quelque chose mais comme on n'a pas encore vu les pointeurs on va dire qu'elle ne va retourner que la coordonnée x, voilà le soucis ne pourra pas être résolu sans avoir vu les pointeurs donc nous qu'est-ce qu'on veut retourner ? simplement la fameuse coordonnée X donc comme c'est un int, on veut retourner un int.

```c
#include <stdio.h>

int init_ball(posX);

int main(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */
    int balleX;

    balleX = 150;

    //Une partie de jeu se fait...

    balleX = 150;

    return 0;
}
```

Ainsi voici le schéma `int init_ball(int posX);` plus tard on parlera de prototype.

On continue cette fonction en mettant cette fois-ci des accolades pour l'implémenter, et on met le code que l'on veut par exemple ici je vais choisir une valeur pour la position de X et on va retourner la valeur en faisant un `return posX;` alors j'entame directement sur ce qui est valeur de retour mais si vous avez quelque chose à retourner on utilise le mot clé return.

Par fonction il ne peut y avoir qu'un seul return.

C'est à dire qu'une fois que vous avez fait un return, vous quittez la fonction c'est-à-dire que vous n'allez plus jamais revenir dedans donc par exemple si vous faites ceci ça ne sert à rien.

```c
int init_ball(int posX)
{
    posX = 150;
    return posX;
    return posX + 1;
}
```

Voilà ça ne sert à rien parce que cette ligne `return posX + 1;` ne sera jamais exécutée parce que partir de ce return `return posX;` comme il n'est pas dans une condition ou autre, il sera forcément exécuté, il sera forcément suivi donc à partir de ce moment-là vous allez quitter la fonction donc le return derrière ne sera jamais exécuté.

Voilà on va garder ceci sauf que au lieu de faire `balleX = 150;`, je vais dire à la place que ça devient `balleX = init_ball(balleX);`.

```c
#include <stdio.h>

int init_ball(int posX)
{
    posX = 150;

    return posX;
}

int main(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */
    int balleX;

    balleX = init_ball(balleX);

    //Une partie de jeu se fait...

    balleX = init_ball(balleX);

    return 0;
}
```

Voyez je n'ai donc qu'a faire ça et ici je ne vais pas compiler parce que les explications suffisent pour le moment ainsi l'initialisation va se faire de cette manière à 150.

Admettons maintenant que notre chef de projet ou que notre client n'est pas content encore une fois, il vous dès maintenant que la position x devra être à 20, Eh bien vous n'aurez plus besoin de modifier chacune des lignes il faudra juste modifier dans la fonction donc là par exemple on va mettre 20.

```c
#include <stdio.h>

int init_ball(int posX)
{
    posX = 20;

    return posX;
}

int main(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */
    int balleX;

    balleX = init_ball(balleX);

    //Une partie de jeu se fait...

    balleX = init_ball(balleX);

    return 0;
}
```

Voilà à partir de là dès qu'on va mettre une autre valeur dans notre fonction on va modifier tout le programme, ça modifie absolument tout le programme, il y a une conséquence sur tout donc ça c'était important de le voir.

On va afficher maintenant le résultat avec un petit printf().

```c
#include <stdio.h>

int init_ball(int posX)
{
    posX = 20;

    return posX;
}

int main(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */
    int balleX;

    balleX = init_ball(balleX);
    printf("Avant la partie : %d\n", balleX);

    //Une partie de jeu se fait...

    balleX = init_ball(balleX);
    printf("Avant la partie : %d\n", balleX);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Avant la partie : 20
Avant la partie : 20
```

Voilà donc ici là bien mais 20 on peut même encore changer une fois la valeur et mettre à 100 cette fois-ci.

```c
#include <stdio.h>

int init_ball(int posX)
{
    posX = 100;

    return posX;
}

int main(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */
    int balleX;

    balleX = init_ball(balleX);
    printf("Avant la partie : %d\n", balleX);

    //Une partie de jeu se fait...

    balleX = init_ball(balleX);
    printf("Avant la partie : %d\n", balleX);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Avant la partie : 100
Avant la partie : 100
```

Voilà **ça s'est répercuté à chaque fois partout** donc ça c'est super important, on a fait de la factorisation pour faire une fonction.

## Prototype de fonction

Maintenant si vous voulez avoir la fonction init_ball() après votre fonction main() parce qu'on n'a pas encore vu comment programmer dans plusieurs fichiers, ce sera justement le thème de la prochaine vidéo, vous le mettez après la fonction et maintenant si vous essayez de compiler votre programme vous risquez dans certains cas d'avoir des problèmes.

```c
#include <stdio.h>

int main(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */
    int balleX;

    balleX = init_ball(balleX);
    printf("Avant la partie : %d\n", balleX);

    //Une partie de jeu se fait...

    balleX = init_ball(balleX);
    printf("Avant la partie : %d\n", balleX);

    return 0;
}

int init_ball(int posX)
{
    posX = 100;

    return posX;
}
```
```powershell
gcc main.c -o prog
main.c: In function 'main':
main.c:13:14: warning: implicit declaration of function 'init_ball' [-Wimplicit-function-declaration]
   13 |     balleX = init_ball(balleX);
      |              ^~~~~~~~~

```

Le problème c'est que là puisqu'on arrive directement dans la fonction mail au début du fichier, la fonction init_ball() n'est pas connue puisqu'elle arrive après donc ici votre compilateur n'est pas censé la connaître c'est à dire qu'il est mieux de faire ceci en début de programme `int init_ball(int posX);` sans oublier le point-virgule.

Ceci `int init_ball(int posX);` est un prototype donc le prototype de la fonction c'est un petit peu un indicateur qui va servir à notre compilateur pour dire attention qu'il y a une fonction qui s'appelle init_ball() qui prend un entier en paramètre et qui retourne en entier. 

Alors pourquoi est-ce que je parle des valeurs `int` et pas simplement du nom parce que en fait j'aurais pu simplement faire ça `int init_ball(int);` sans utiliser le nom posX de notre paramètre parce que le nom est en fait facultatif voilà on s'en fout du nom de la variable.

Tout ce qui est intéressant pour les prototype c'est le type de la variable par contre à l'intérieur de la fonction vous êtes obligé d'utiliser un nom sinon vous ne pourriez pas utiliser la variable, si vous ne mettez pas non vous pourrez pas l'utiliser dans la fonction.

Voilà pour le prototype, il doit juste savoir qu'il y a une fonction init_ball() qui prend un entier, et qui renvoie un entier.

```c
int init_ball(int);
```

Mais bon pour être plus clair nous pouvons laisser le nom, pas de problème, ça fonctionne aussi et c'est plus clair.

```c
#include <stdio.h>

int init_ball(int posX);

int main(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */
    int balleX;

    balleX = init_ball(balleX);
    printf("Avant la partie : %d\n", balleX);

    //Une partie de jeu se fait...

    balleX = init_ball(balleX);
    printf("Avant la partie : %d\n", balleX);

    return 0;
}

int init_ball(int posX)
{
    posX = 100;

    return posX;
}
```
```powershell
gcc main.c -o prog
prog.exe
Avant la partie : 100
Avant la partie : 100
```

Voilà ici ça a marché mais dans d'autres cas pensez si vous voulez mettre les fonctions après le main(), penser à mettre les prototypes au début.

Voilà ça c'est important pour ne pas avoir de mauvaises surprises et des erreurs à la compilation ou carrément à l'exécution.

Voilà ça c'était à savoir au niveau de la création de fonction.

## Portée des variables

Alors petite indication au niveau de la compréhension au niveau de nos fonctions parce que ça c'est pas toujours clair pour tout le monde, vous voyez que dans ma fonction init_ball() j'ai une variable `posX` alors que dans la fonction main() c'était `balleX` alors ce ne sont pas les mêmes variables.

Ce qu'il faut savoir et on en parlera dans la séance suivante également, on parlera de **la portée des variables** c'est-à-dire de l'endroit ou elles sont accessibles. 

Ici là variable balleX n'existe que dans la fonction main() d'accord parce qu'elle a été créée et déclarée donc cette fonction. Et posX n'existe que dans la fonction init_ball() parce qu'elle est simplement ici `int init_ball(int posX)` parce qu'elle a été quelque part déclaré et c'est dans la fonction tout simplement donc elle n'est utilisable que dans cette fonction elle ne sera pas utilisable dans main().

Autre point, toutes ces variables déclarées localement donc de cette manière comme vous avez fait au début de chaque fonction en mettant le type de la variable, le nom est le ; ou bien l'initialisation c'est à dire directement le initialisé à une valeur ou autre.

Toutes les **variables locales** sont détruites à la fin donc une fois qu'on arrive à l'accolade fermante, la variable posX de init_ball() est détruite. Pareil dès qu'on arrive à l'accolade fermante de la fonction main(), dès qu'on arrive au `return 0;` la variable balleX est détruite.

Voilà ça c'est une règle à savoir, vous comprendrez ça un peu mieux dans les vidéos suivantes on ne va pas brûler les étapes non plus. On aura l'occasion d'en reparler la prochaine fois mais c'est à savoir.

Voilà lorsqu'on parle de portée de variable ce sont pas les mêmes choses, c'est pour ça que j'ai utilisé un nom différent dans les 2 fonctions : balleX et posX mais j'aurais pu très bien utiliser les mêmes noms et dire que j'appelle toutes ces variables balleX mais je ne le fais pas parce que ça risquerait d'induire en erreur d'ailleurs quand on développe on évite de le mettre pour ne pas se mélanger les pinceaux.

```c
#include <stdio.h>

int init_ball(int posX);

int main(void)
{
    /*
        Exemples de fonctions :

            - printf()
            - scanf()
    */
    int balleX;

    balleX = init_ball(balleX);
    printf("Avant la partie : %d\n", balleX);

    //Une partie de jeu se fait...

    balleX = init_ball(balleX);
    printf("Avant la partie : %d\n", balleX);

    return 0;
}

int init_ball(int balleX)
{
    balleX = 100;

    return balleX;
}
```
```powershell
gcc main.c -o prog
prog.exe
Avant la partie : 100
Avant la partie : 100
```

Alors voilà ici la variable balleX de la fonction init_ball() est une autre variable que La variable balle X de la fonction main().

Dans votre mémoire celle de votre PC, vous allez avoir une case mémoire donc une adresse en mémoire ou va être stocké cette variable là `int balleX;` (main) et une case mémoire complètement différente où va être stocké celle-ci `balleX = 100:` (init_all) d'accord ça c'est important de savoir, et c'est seulement en faisant le fameux `return balleX;` qu'on va affecter à balleX le retour de la fonction `balleX = init_ball(balleX);`.

D'accord donc dans ce cas-ci on copie la valeur dans balleX donc du coup les 2 variables balleX ont les mêmes valeurs mais comme en faisant `return balleX;`, la variable balleX de la fonction init_ball() est détruite donc elle est détruite de la mémoire elle n'existe plus, elle est libérée en fait de la mémoire et dans notre cas il n'y a que balleX de la fonction main() qui continue d'exister.

Ainsi si on suit la durée de vie des variables dans ce programme, qu'est-ce qui se passe dans notre mémoire ? Imaginez que la mémoire vive de votre programme, imaginez qu'il n'y a rien du tout dedans même si ce n'est pas vrai parce que vous avez votre système d'exploitation qui tourne déjà donc on imagine qu'il n'y a rien dedans et que c'est vide. Ensuite on déclare une variable entière `int balleX` (main) donc votre programme va demander au système de réserver une place de 4 ou 8 octets selon les cas par rapport à la taille des entiers comme on avait vu dans la vidéo sur les variables pour pouvoir y stocker une variable mais bon pour le moment cette variable n'a pas de valeur, elle a juste une adresse à laquelle on peut la trouver et par la suite on lui dit qu'elle prendra la valeur du retour de la fonction init_ball() `balleX = init_ball(balleX);`.

On appelle donc cette fonction init_ball(), on va à cette fonction et on demande la création d'une nouvelle variable `int balleX` donc on va créer une variable en mémoire donc on a une 2e variable qui est créée donc on va l'initialiser à 100 ensuite on fait un `return balleX;` paf la 2e variable créée elle t'a enlevé dans la mémoire, elle est détruite.

Et donc, la valeur de cette variable est affectée à la première variable qui avait été créée `balleX = init_ball(ballX);`.

Ensuite voilà on affiche sa valeur avec un printf() et cetera bref on fait la même chose que tout à l'heure puis on recommence l'opération en réaffectant à nouveau un cette fonction un autre variable, à notre toute première variable dans lequel on retourne la valeur.

Finalement quand on arrive à `return 0;` la variable balleX de la fonction main() est détruite.

D'accord vous voyez un petit peu les étapes comme ça, je viens de vous les expliquer rapidement donc vous comprenez que c'est purement logique donc là variable locale existe tant que la fonction est en exécution.

Une fois que la fonction est terminée, on parle de contexte donc la fonction est considérée comme un contexte voilà donc une variable locale est propre à son contexte d'exécution donc dans ce cas-ci c'est une fonction.

Ainsi quand le contexte d'exécution se termine, les variables locales sont détruites.

Tout simplement, j'ai insisté pas mal sur la fin parce que c'est vraiment une étape très importante qui des fois pose beaucoup de soucis aux gens qui apprennent la programmation alors que c'est très simple, c'est vraiment très simple.

Voilà je pense avoir fait le tour un peu de tout ça, vous savez créer une fonction donc vous avez créé une fonction, vous savez comment les appeler on l'a vérifié d'ailleurs avec printf().

## Une fonction sans valeur de retour

On peut également finir avec une petite fonction qui ne retourne rien, par exemple ceci.

```c
#include <stdio.h>

void bonjour(void)
{
    printf("Bonjour :) !\n");
}

int main(void)
{
    bonjour();

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Bonjour :) !
```

Voilà c'est très simple un petit appel de fonction qui ne renvoie rien donc ici même pas besoin de stocker quoi que ce soit dans une variable, on appelle simplement la fonction comme quand on fait un printf() ou quand on fait un scanf().

Ainsi quand il n'y a pas de valeur de retour, on ne fait pas un `return` voyez donc qui suffit simplement de l'appeler.

Comprenez simplement que le return va retourner une valeur dans la fonction que vous avez appelé par exemple si je fais un `return 1;` je vais devoir mettre un `int` parce que je retourne une valeur entière et dans ce cas-là je peux le stocker dans quelque chose par exemple une variable dans la fonction main() comme ceci.

```c
#include <stdio.h>

int bonjour(void)
{
    printf("Bonjour :) !\n");

    return 1;
}

int main(void)
{
    int retour_fonction;

    retour_fonction = bonjour();

    printf("Retour : %d\n", retour_fonction);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Bonjour :) !
Retour : 1
```

Voilà il affiche le Bonjour et après il dit de récupérer la valeur ici `retour_fonction = bonjour();` et ensuite on a une espèce de pont parce qu'on passe à `return 1;` voilà parce que c'est un petit peu comme si j'avais dit d'afficher le printf() puis on plus après tu fais le `return 1;` pour remplacer la fonction bonjour() dont l'expression `retour_fonction = bonjour();` parce que ici bonjour() c'est un peu comme si bonjour() était remplacé par tout ce code là.

+ bonjour()
```c
int bonjour(void)
{
    printf("Bonjour :) !\n");

    return 1;
}
```

Alors bien sûr on ne va pas stocker non plus le printf() dont la variable retour_fonction parce que ce que l'on stock c'est simplement l'instruction `return` donc on stock ce qui vient après `return` c'est à dire le 1.

Par contre si j'avais fait `return printf("Bonjour :) !\n");`.

```c
#include <stdio.h>

int bonjour(void)
{
    return printf("Bonjour :) !\n");
}

int main(void)
{
    int retour_fonction;

    retour_fonction = bonjour();

    printf("Retour : %d\n", retour_fonction);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Bonjour :) !
Retour : 13
```

Voilà donc là il nous met en retour de 13, pourquoi ? Tout simplement parce qu'il a casté automatiquement c'est à dire qu'il a essayé de convertir un peu le texte en caractère entier donc il vous retourne 13.

Voilà ici vous avez vu tout ce qu'il y avait à savoir c'est à dire comment appeler une fonction par rapport à ça, comment est-ce qu'on crée une fonction donc rappelez vous qu'il y a un nom des paramètres ou pas si par exemple on peut mettre un void ou pas et enfin il peut y avoir une valeur de retour ou non avec le mot-clé return très important ça permet de faire la liaison comme ça.

Enfin n'oubliez pas la portée des variables pour les fonctions, toute variable locale créé dans une fonction est détruite à la fin ça c'est à savoir c'est une règle d'or qui va vous suivre partout partout partout.

On en terminera ici pour cette petite séance 8, je vous dis à bientôt se retrouvera la prochaine fois pour parler de modularité donc on va voir comment créer des mini bibliothèques, comment on va pouvoir organiser notre code dans plusieurs fichiers, comment on va pouvoir faire des inclusions de fichiers et c'était rare pour pouvoir les utiliser de plusieurs manières différentes.

Maintenant que vous savez comment créer des fonctions va pouvoir pousser un peu plus loin le développement et découvrir des choses un peu plus complexes.

Donc là vous avez vu tout ce qui était basique, c'est ce que j'appelle les bases en informatique en langage et c'est à dire tout ce qui est jusqu'au fonction.

À partir de maintenant donc la séance prochaine, on va rentrer dans la programmation un petit peu intermédiaire je ne parle pas vraiment de programmation avancée parce que ça concernerait plus les structures.

Là vous allez rentrer dans la programmation intermédiaire avec toutes les choses que l'on va voir par la suite.

Ainsi entraînez-vous et n'hésitez pas à voir toute une série de petits codes, posez des questions s'il y avait quelque chose que vous ne comprenez pas, qui ne sont pas assez clairs parce que je dis énormément de choses parfois je peux même des fois oublier des petits détails parce qu'il y a beaucoup de choses qui me paraissent évidentes donc je peux oublier des choses donc n'hésitez pas si vous avez besoin de plus d'éclaircissement ou de détails.

Même si les vidéos sont déjà assez longue et que vous ayez besoin de savoir beaucoup plus, demandez moi en commentaire et je vous répondrai volontiers.

On se retrouve la prochaine fois pour la séance 9, et on parlera comme je vous dis de modularité.

À bientôt tout le monde