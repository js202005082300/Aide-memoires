# [15. Allocation dynamique mémoire](https://www.youtube.com/watch?v=71QV6fFl_bk)

Bonjour à tous, vous êtes sur votre formation en langage c.

On se retrouve aujourd'hui pour une 15ème séance et nous allons parler d'allocation dynamique de mémoire.

Alors ça fait pas mal de termes assez compliqués tout simplement pour décrire le fait que nous allons pouvoir réserver des zones dans la mémoire par rapport à des données sur lesquelles nous allons travailler de manière dynamique, choses qu'on ne pouvait pas faire jusqu'à présent et je l'avais légèrement abordé dans certaines vidéos précédentes et je vous avait dit que nous verrions tout cela justement lorsque nous allions parler d'allocation dynamique donc c'est le sujet de cette vidéo et je vais vous montrer rapidement comment mettre tout ça en place tout simplement, comment on travaille avec l'allocation dynamique.

Alors je prends un exemple très très simple d'accord pour les premières choses-là j'aurai des notes à vous montrer notamment des fonctions à utiliser, à connaître puisque c'est une notion importante du langage c, l'allocation dynamique, on ne peut vraiment pas passer à côté de ça.

Je prends un exemple très simple, vous faites un petit jeu en multijoueur et puis vous ne savez pas combien de joueurs vous aurez à la base ou combien de personnages vous aurez à faire jouer sur n'importe quel truc donc si de base vous le savez c'est assez facile à programmer mais si on ne le sait pas où dans ce genre de cas quand on a des données variables, il faut bien pouvoir faire fonctionner le programme en conséquence.

## stdlib

Du coup, on va utiliser une fonction qui va servir alors déjà on peut inclure l'en-tête qu'on n'avait pas inclus `#include <stdlib.h>` avant mais qui va être utile après et en général c'est un des fichiers d'en-tête qu'on inclut un petit peu tout le temps.

```c
#include <stdio.h>
#include <stdlib.h>
```

Par la suite quand on programme en langage c, on met toujours c'est deux-là d'accord *stdio.h* c'est pour les entrées/sorties et *stdlib.h* c'est la bibliothèque standard, c'est vraiment tout ce qui va servir notamment pour l'allocation dynamique et d'autres petites choses également qu'on n'aura pas forcément l'occasion de voir ici mais qui serviront plus tard donc en général on met toujours ces deux-là.

Il faut donc penser à bien a ajouter ce fichier d'en-tête.

```c
#include <stdlib.h>
```

Alors rappelez vous toujours pareil, mettez bien l'espace entre les deux, *#include* et *<stdio.h>* car si vous faites ça, collé...

```c
#include<stdlib.h>
```

Voyez que ça change la couleur parce que ça ne fonctionnera pas et vous aurez des erreurs donc là l'espace est important ici donc bien respecter la syntaxe.

On ajoute donc ce fichier d'en-tête et on va voir comment on va faire.

On pourrait par exemple faire un tableau de joueurs d'accord ça peut être un exemple alors je vais avoir un nombre entier `int nombreJoueurs = 0;` nombre de joueurs de base où on met 0.

On pourrait demander à l'utilisateur combien on aurait de joueurs, par exemple avec un petit scanf().

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 0;

    printf("Combien de joueurs ? ");
    scanf("%d", &nombreJoueurs);

    return 0;
}
```

Et voilà, et nous en fonction de ça on aimerais qu'on puisse en fait gérer un certain nombre de joueurs pour par exemple créer un tableau c'est-à-dire qu'on aurait ce genre de choses `int liste_joueurs[];` et je vous avais expliqué qu'entre crochets, on ne peut pas mettre une variable par exemple mais on peut faire 4 par exemple `int liste_joueurs[4];` mais on ne peut pas par exemple dire ceci `int liste_joueurs[nombreJoueurs];` d'accord.

```txt
int nombreJoueurs = 0;
//...
int liste_joueurs[];
int liste_joueurs[4];
int liste_joueurs[nombreJoueurs]; //NON
```

Alors depuis la norme 99, on peut faire `int liste_joueurs[nombreJoueurs];` mais je vous avais expliqué qu'il fallait éviter ce genre de chose puisque ça ne fonctionne que pour un certain nombre réduit de personnes et en plus ça peut amener des erreurs.

L'allocation dynamique, l'avantage c'est que ça fonctionnera tout le temps d'accord même dans 10 ans, le langage fonctionnera toujours et ça fonctionne sur toutes les types de système puisque ça existe depuis les débuts du langage c donc c'est une méthode qui est fonctionnel partout à 100% mais qui le sera encore plus tard alors qu'il y aurait d'autres choses qui pourront éventuellement changer.

Ainsi donc ça `int liste_joueurs[nombreJoueurs];` je vous avais dit qu'on évitait en fait comme si ça n'existait pas, comme si on ne pouvait pas surtout que pour la majorité d'entre vous de toute façon ça n'aurait pas marché donc on aimerait avoir un nombre en fait dynamique simplement de dire par exemple si la personne a dit 4 joueurs hé bien tu crée un tableau de 4 joueurs, sinon tu en crée 3, sinon 2 et cetera.

Du coup, c'est un petit peu embêtant d'accord c'est un petit peu embêtant alors que j'ai pris mon terme de joueurs pour simplifier mais on aimerait avoir quelque chose de dynamique d'accord comme on ne sait pas au début on va faire un pointeur simple.

Vous savez qu'un tableau c'est un pointeur vers son premier élément d'accord donc on va faire ça, on va bien l'identifier avec une étoile.

Pour le moment on a une liste de joueurs `int nombreJoueurs = 0;` mais cette liste de joueurs serra considérée comme NULL début voilà on a rien dedans, `int *liste_joueurs = NULL` et en l'initialisant comme ça c'est propre.

Voilà du coup on va pouvoir faire de l'allocation dynamique pour pouvoir gérer cette liste et si on ne l'avait pas fait, ça ne marcherait pas.

Pour cela on va utiliser une fonction très particulière donc là vous voyez quand on a  récupéré le nombre de joueurs `scanf("%d", &nombreJoueurs);`.

## malloc

A partir de là, on va pouvoir du coup utiliser une fonction pour cela, on va avoir sur notre liste de joueurs sur laquelle nous allons effectuer une allocation dynamique c'est-à-dire qu'on va allouer un espace mémoire suffisant.

Alors comment ça fonctionne, on va utiliser simplement la fonction malloc() d'accord que je vais expliquer un petit peu après.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 0;

    printf("Combien de joueurs ? ");
    scanf("%d", &nombreJoueurs);

    liste_joueurs = malloc();

    return 0;
}
```

Alors au niveau des notes, malloc() et qu'est-ce que prend malloc() ? ça prend en une taille en octets, une zone mémoire.

```
/*
    malloc(<taille_en_octets>) : allouer dynamiquement une zone mémoire
*/
```

Alors à quoi correspond la taille en octet ? ça correspond à ça.

![types_variables.png](types_variables.png)

Si vous vous souvenez un petit peu de ce tableau sur les types de variables, on avait l'occupation mémoire selon le type avec un char qui prend 1 octet, un int ça peut prendre 2 ou 4 selon votre ordinateur (moi ça prend 4 sur mon pc puisce que j'ai une architecture 64 bits), puis il y a des 8 pour les long long, voyez ça va jusque 10 octets.

Voilà on a autant d'octets selon les tailles, on a des tailles plus ou moins conséquentes.

Alors est-ce qu'il faut retenir tout ça ? non, ça ne servirait strictement à rien et en plus si vous manipuliez des tableaux de plusieurs plusieurs types de données, voire des structures comme on l'a vu dans la vidéo précédente.

Vous avez vu que dans une structure en fait, on a plusieurs données c'est-à-dire que si faisait en fait la taille de la structure complète il faudrait calculer la taille de toutes ces variables donc ce serait juste ingérable et puis on devrait retenir par coeur des valeurs bref il ne va pas falloir s'embêter avec ça.

## sizeof

On va utiliser pour cela une autre fonction qui n'a pas besoin de *stdlib.h* ou en tout cas qui ne nécissite pas d'inclure autre chose, on va utiliser la fonction sizeof().

```
/*
    sizeof(<donnee>)            : retourne la taille en octets d'une donnée
    malloc(<taille_en_octets>)  : allouer dynamiquement une zone mémoire
*/
```

Elle prend un type de données va tout simplement retourner la taille en octet d'une donnée.

Alors dans malloc() voyez qu'il prend qu'il prend la taille alors je vous simplifie d'accord au niveau d'utilisation mais il prend une taille en octet de l'objet à allouer.

Nous on veut quoi en fait ? alors j'ai dit que *liste_joueurs* était un tableau d'entiers alors j'aurais pu faire éventuellement une structure Player puis j'aurais pu faire ceci `Player *liste_joueurs = NULL;`.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 0;
    int *liste_joueurs = NULL;

    printf("Combien de joueurs ? ");
    scanf("%d", &nombreJoueurs);

    liste_joueurs = malloc();

    return 0;
}
```

Alors j'aurais pu faire une structure Player mais ça va rallonger la vidéo, ça va vous faire plein de variable donc on n'a qu'à imaginer je sais que c'est complètement idiot mais c'est pour l'exemple on n'a qu'à imaginer que nos joueurs sont représentés juste par un nombre ainsi d'accords on n'a pas un nom, un prénom ou je ne sais quoi mais c'est nos joueurs, notre liste de joueurs est une liste de nombre, en fait de numéros.

On peut imaginer des numéros de joueurs donc pour simplifier en fait l'exemple puisque là il est question de parler d'allocation dynamique et pas de structure ou je ne sais quoi donc on va éviter de trop tout mélanger pour ne pas que ça complique inutilement.

Donc on a simplement une liste d'entiers `int *liste_joueurs = NULL;` donc on va utiliser cette fameuse fonction sizeof() donc on va dire que je veux allouer l'emplacement d'un entier donc `sizeof(int);` int vous voyez la donnée c'est `int` donc j'emploi le terme comme ça pas besoin de mettre 4 ou 8 comme on a dans le tableau ici de variables.

![types_variables.png](types_variables.png)
```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 0;
    int *liste_joueurs = NULL;

    printf("Combien de joueurs ? ");
    scanf("%d", &nombreJoueurs);

    liste_joueurs = malloc(sizeof(int));

    return 0;
}
```

Ainsi peu importe votre ordinateur ça prendra bien en compte et là comme on a un nombre de joueurs variable d'accord que l'utilisateur a choisi qui est ici `scanf("%d", &nombreJoueurs);` on peut le multiplier donc on va dire `liste_joueurs = malloc(sizeof(int) * nombreJoueurs);`.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 0;
    int *liste_joueurs = NULL;

    printf("Combien de joueurs ? ");
    scanf("%d", &nombreJoueurs);

    liste_joueurs = malloc(sizeof(int) * nombreJoueurs);

    return 0;
}
```

Voilà on lui dit qu'il doit réserver en fait autant d'entiers qu'il y a de joueurs, et la liste de joueurs si toute l'allocation s'est bien passée va contenir effectivement donc ça va être un tableau qui aura, selon ce que l'utilisateur à entrer, un certain nombre x de joueurs donc si l'utilisateur demande 4, ça va créer 4 emplacements mémoire donc un tableau de 4 cases.

S'il demande 10, ça va créer 10 cases et cetera.

Voyez on va en fait créer un tableau qui aura une taille variable suivant ce que l'utilisateur à rentré, ce qu'on ne pouvait pas faire avant.

Dans les vidéos sur les tableaux, on mettait rappelez-vous entre crochets la taille du tableau c'est-à-dire qu'on choisissait à l'avance la taille qu'on voulait mais ici c'est une taille qu'on ne connaît pas à l'avance donc l'allocation dynamique là est utile, est vraiment nécessaire.

Petite vérification, malloc() retourne notamment l'objet aui a été alloué si tout va bien sinon rend NULL d'accord il va renvoyer NULL si ça n'a pas marché et si ça échoue une allocation quelle qu'elle soit vous quittez le programme.

Si ça échoue, on quitte et on affiche éventuellement un message d'erreur c'est plus propre mais moi je ne vais pas le faire encore une fois pour ne pas alourdir le code mais vous quittez.

Vous ne continuez pas un programme qui n'a pas alloué la mémoire que vous voulez sinon il va essayer d'accéder à des zones mémoire non autorisées et ça veut dire plantage donc on fait simplement ça `if(liste_joueurs == NULL)` donc si l'allocation a échoué, j'affiche un message d'erreur éventuellement où j'affiche mes erreurs de manière plus propre, et on utilise exit() ce qui veut dire qu'elle ne pas retourner la fonction, c'est vraiment qu'elle quitte le programme donc `exit(1);` permet de quitter le programme et dire que ça n'a pas marché.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 0;
    int *liste_joueurs = NULL;
    
    printf("Combien de joueurs ? ");
    scanf("%d", &nombreJoueurs);

    liste_joueurs = malloc(sizeof(int) * nombreJoueurs);

    if(liste_joueurs == NULL)
        exit(1);

    return 0;
}
```

Alors `exit(1);` ou `exit(-1);` ou une constante `exit(EXIT_FAILURE);`, peu importe ça peut être un moyen comme ça de l'indiquer donc moi je mets `exit(1);` et si ça a marché le programme va continuer donc je le met à la suite.

Du coup pour chaque liste des joueurs, on peut mettre des choses dedans d'accord suivant le nom qu'il y aura alors qu'est-ce qu'on fait comme on ne connaît pas le nombre de joueurs qui peut y avoir, on va donc utiliser une boucle d'accord donc on va prendre un compteur voyez ça fait appel à toutes les choses que vous avez vues.

On va commencer par mettre `int i;` parce qu'on va initialiser avec le for() et puis on fait par exemple `for(i = 0 ; i < nombreJoueurs ; i++)` en disant tant que i est plus petit que le nombre de joueurs d'accord et on incrémente. Ok et là on va faire des petites choses mais nous on ne va pas s'embêter, en fait, on va simplement faire `printf("Joueur %d -> numero %d\n", i + 1, i * 3);` avec le numéro du joueur comme c'est le 1 en terme français et bien c'est i+1 parce que i commence à 0, et au pif on met i*3 vraiment comme ça par pur hazard et je vais éffectivement dire que dans la liste de joueur de i donc le premier ce serra 0, je vais éffectivement stocker i * 3, `liste_joueurs[i] = i * 3;`.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 0;
    int *liste_joueurs = NULL;
    int i;

    printf("Combien de joueurs ? ");
    scanf("%d", &nombreJoueurs);

    liste_joueurs = malloc(sizeof(int) * nombreJoueurs);

    if(liste_joueurs == NULL)
        exit(1);
    
    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("Joueur %d -> numero %d\n", i + 1, i * 3);
        liste_joueurs[i] = i * 3;
    }

    return 0;
}
```

Voilà et à la fin, écoutez on pourra afficher la liste des joueurs, ce qui ne sert pas à grand chose mais c'est histoire de voir si ça a fonctionner donc on fait ça.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 0;
    int *liste_joueurs = NULL;
    int i;

    printf("Combien de joueurs ? ");
    scanf("%d", &nombreJoueurs);

    liste_joueurs = malloc(sizeof(int) * nombreJoueurs);

    if(liste_joueurs == NULL)
        exit(1);
    
    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("Joueur %d -> numero %d\n", i + 1, i * 3);
        liste_joueurs[i] = i * 3;
    }

    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("[%d] ", liste_joueurs[i]);
    }

    return 0;
}
```

Voilà encore une fois, j'ai simplifié. Je vous ai dit que j'ai fait une liste de d'entiers pour les listes de joueurs. Si on avait voulu faire quelque chose de propre on aurait fait une structure Player et puis on aura affiché pour chacun leur nom, leur âge éventuellement fin je ne sais pas quoi bref on aurait pu faire tout et n'importe quoi.

## free

Là c'est vraiment pour simplifier car il faut savoir qu'on à pour l'allocation ceci `liste_joueurs = malloc(sizeof(int) * nombreJoueurs);` et on vérifie qu'elle a fonctionné et ensuite, ça c'est important, c'est que comme vous avez allouer dynamiquement de la mémoire, le programme ne va pas la libérer tout seul et si vous compilez, que vous exécuter le programme la partie ici que j'ai allouée, à la fin du programme, elle va rester en fait en tant que résidus dans la mémoire vive donc de l'ordinateur donc ce n'est pas propre d'accord on a des fuites mémoire donc il faut la libérer donc à la fin quand vous n'en avez plus besoin, vous faites un free() de ce que vous avez alloué donc ici liste_joueurs, `free(liste_joueurs);`.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 0;
    int *liste_joueurs = NULL;
    int i;

    printf("Combien de joueurs ? ");
    scanf("%d", &nombreJoueurs);

    liste_joueurs = malloc(sizeof(int) * nombreJoueurs);

    if(liste_joueurs == NULL)
        exit(1);
    
    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("Joueur %d -> numero %d\n", i + 1, i * 3);
        liste_joueurs[i] = i * 3;
    }

    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("[%d] ", liste_joueurs[i]);
    }

    free(liste_joueurs);

    return 0;
}
```

Voilà donc ça c'est important.

```
/*
    sizeof(<donnee>)            : retourne la taille en octets d'une donnée
    malloc(<taille_en_octets>)  : allouer dynamiquement une zone mémoire
    free(<donnee_allouee>)      : libérer la mémoire allouée dynamiquement
*/
```

Par défaut, pour une manière très simple dés que vous avez un malloc() vous avez un free(). Si vous avez trois malloc(), vous aurez trois free(). Si vous en avez 4 et cetera.

Vous avez compris le système donc c'est important, à chaque fois que vous avez un malloc() vous avez un free() derrière automatiquement donc le mieux c'est de le mettre tout de suite.

Moi je l'ai mis à la fin de mon explication mais j'aurais pu directement le mettre au moment où j'ai fait le malloc() mettre directement cette ligne et après mêtre entre les deux ce que je voulais faire comme ça j'étais sûr de ne pas l'oublier.

## 1e compilation et exécution

Cette fois-ci, on va compiler. On va donc faire `gcc main.c -o prog` et on va tester.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 0;
    int *liste_joueurs = NULL;
    int i;

    printf("Combien de joueurs ? ");
    scanf("%d", &nombreJoueurs);

    liste_joueurs = malloc(sizeof(int) * nombreJoueurs);

    if(liste_joueurs == NULL)
        exit(1);
    
    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("Joueur %d -> numero %d\n", i + 1, i * 3);
        liste_joueurs[i] = i * 3;
    }

    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("[%d] ", liste_joueurs[i]);
    }

    free(liste_joueurs);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe
Combien de joueurs ? 1
Joueur 1 -> numero 0
[0]
```

On teste donc si je met 1 joueur, voyez qu'il a créé *Joueur 1* et qu'il a mit *numero 0* effectivement puisqu'il a fait i*3 et il a bien afficher 0 donc son numéro.

Ensuite si on re exécute le programme voyez que je ne modifie rien au programme, je ré exécute absolument le même code mais cette fois-ci je met 5 et vous voyez qu'il me crée les joueurs 1 2 3 4 5 avec des valeurs différentes et à la fin il affiche la liste.

```powershell
gcc main.c -o prog
.\prog.exe
Combien de joueurs ? 5
Joueur 1 -> numero 0
Joueur 2 -> numero 3
Joueur 3 -> numero 6
Joueur 4 -> numero 9
Joueur 5 -> numero 12
[0] [3] [6] [9] [12]
```

D'accord ici, j'affiche que des numéros pour simplifier encore une fois la vidéo mais voyez que ça fonctionne, ainsi je peux comme ça allouer dynamique plein de choses par exemple je peux faire 100 joueurs et il va faire les 100 joueurs d'accord.

```powershell
gcc main.c -o prog
.\prog.exe
Combien de joueurs ? 100
Joueur 1 -> numero 0
Joueur 2 -> numero 3
Joueur 3 -> numero 6
Joueur 4 -> numero 9
Joueur 5 -> numero 12
Joueur 6 -> numero 15
Joueur 7 -> numero 18
Joueur 8 -> numero 21
Joueur 9 -> numero 24
Joueur 10 -> numero 27
Joueur 11 -> numero 30
Joueur 12 -> numero 33
Joueur 13 -> numero 36
Joueur 14 -> numero 39
Joueur 15 -> numero 42
Joueur 16 -> numero 45
Joueur 17 -> numero 48
Joueur 18 -> numero 51
Joueur 19 -> numero 54
Joueur 20 -> numero 57
Joueur 21 -> numero 60
Joueur 22 -> numero 63
Joueur 23 -> numero 66
Joueur 24 -> numero 69
Joueur 25 -> numero 72
Joueur 26 -> numero 75
Joueur 27 -> numero 78
Joueur 28 -> numero 81
Joueur 29 -> numero 84
Joueur 30 -> numero 87
Joueur 31 -> numero 90
Joueur 32 -> numero 93
Joueur 33 -> numero 96
Joueur 34 -> numero 99
Joueur 35 -> numero 102
Joueur 36 -> numero 105
Joueur 37 -> numero 108
Joueur 38 -> numero 111
Joueur 39 -> numero 114
Joueur 40 -> numero 117
Joueur 41 -> numero 120
Joueur 42 -> numero 123
Joueur 43 -> numero 126
Joueur 44 -> numero 129
Joueur 45 -> numero 132
Joueur 46 -> numero 135
Joueur 47 -> numero 138
Joueur 48 -> numero 141
Joueur 49 -> numero 144
Joueur 50 -> numero 147
Joueur 51 -> numero 150
Joueur 52 -> numero 153
Joueur 53 -> numero 156
Joueur 54 -> numero 159
Joueur 55 -> numero 162
Joueur 56 -> numero 165
Joueur 57 -> numero 168
Joueur 58 -> numero 171
Joueur 59 -> numero 174
Joueur 60 -> numero 177
Joueur 61 -> numero 180
Joueur 62 -> numero 183
Joueur 63 -> numero 186
Joueur 64 -> numero 189
Joueur 65 -> numero 192
Joueur 66 -> numero 195
Joueur 67 -> numero 198
Joueur 68 -> numero 201
Joueur 69 -> numero 204
Joueur 70 -> numero 207
Joueur 71 -> numero 210
Joueur 72 -> numero 213
Joueur 73 -> numero 216
Joueur 74 -> numero 219
Joueur 75 -> numero 222
Joueur 76 -> numero 225
Joueur 77 -> numero 228
Joueur 78 -> numero 231
Joueur 79 -> numero 234
Joueur 80 -> numero 237
Joueur 81 -> numero 240
Joueur 82 -> numero 243
Joueur 83 -> numero 246
Joueur 84 -> numero 249
Joueur 85 -> numero 252
Joueur 86 -> numero 255
Joueur 87 -> numero 258
Joueur 88 -> numero 261
Joueur 89 -> numero 264
Joueur 90 -> numero 267
Joueur 91 -> numero 270
Joueur 92 -> numero 273
Joueur 93 -> numero 276
Joueur 94 -> numero 279
Joueur 95 -> numero 282
Joueur 96 -> numero 285
Joueur 97 -> numero 288
Joueur 98 -> numero 291
Joueur 99 -> numero 294
Joueur 100 -> numero 297
[0] [3] [6] [9] [12] [15] [18] [21] [24] [27] [30] [33] [36] [39] [42] [45] [48] [51] [54] [57] [60] [63] [66] [69] [72] [75] [78] [81] [84] [87] [90] [93] [96] [99] [102] [105] [108] [111] [114] [117] [120] [123] [126] [129] [132] [135] [138] [141] [144] [147] [150] [153] [156] [159] [162] [165] [168] [171] [174] [177] [180] [183] [186] [189] [192] [195] [198] [201] [204] [207] [210] [213] [216] [219] [222] [225] [228] [231] [234] [237] [240] [243] [246] [249] [252] [255] [258] [261] [264] [267] [270] [273] [276] [279] [282] [285] [288] [291] [294] [297]
```

Il va faire les 100 joueurs donc c'est très rapide, c'est là que l'allocation dynamique c'est là que vous voyez la puissance de la chose c'est qu'on peut dynamiquement réserver un emplacement mémoire suffisant selon ce que l'utilisateur à entrer, ça peut être utile  notamment pour faire de la saisie d'un nom par exemple si vous voulez un pseudo, vous ne savez pas si l'utilisateur va rentrer 5 caractères ou un pseudo de 20 charactères mais vous n'en savez rien donc vous n'allez pas réserver par exemple 250 emplacements en mémoire pour chaque caractère en fait s'il note un mot de 25 caractères ça ne servira à rien, on aurait du du gaspillage de mémoire donc là on peut gérer vraiment précisément à ce niveau-là.

Ainsi donc ça c'est les deux fonctions à connaître malloc() et free(), et on utilise sizeof() pour calculer la taille de la donnée de la donnée en octet c'est très rapide ok tout simplement.

Alors si je n'avais pas eu de tableaux, admettons que j'avais voulu simplement allouer dynamiquement un `int` ce qui ne servira à rien puisque le `int` vous avez vu qu'on peut faire comme d'habitude, on met `int` la variable et puis on met une valeur et puis c'est tout donc ça le programme va libérer la mémoire tout seul comme un grand mais on aurait pu juste faire ça `malloc(sizeof(int));` mais ça ne sert à rien, on ne fait pas d'allocation dynamique juste pour un entier tout seul ou un char tout seul ou un float ben c'est complètement inutile.

`malloc(sizeof(int) * nombreJoueurs);` là c'est utile parce qu'on a encore une fois une donnée dont on ne sait pas la taille, on veut faire un tableau de joueurs mais on ne sait pas combien on va avoir de joueurs à l'avance donc on fait une allocation dynamique et l'allocation va se faire de manière proportionnelle au nombre de joueurs qui ont été saisis  par l'utilisateur, et là vous voyez sur le code que ça fonctionne très très bien à ce niveau-là.

Donc ça c'est une première partie, on va terminer avec autre chose.

C'est assez rapide cette vidéo, il n'y a pas grand chose à vous dire, il n'y a pas grand chose au niveau syntaxe, c'est une notion assez complexe, assez importante, très importante même mais au niveau du code, au niveau de tout ça, il n'y a pas grand chose à savoir de base.

On va voir une autre petite fonction comme malloc() que je vais mettre ici en commentaire.

## calloc

Une fonction qui sert beaucoup qui s'appelle calloc() ok, qui va prendre la <donnee> et qui va prendre ensuite la <taille en octets> ainsi comme vous voyez elle a deux paramètres cette fonction donc elle alloue et initialise tout à 0.

Fonction qui alloue et initialise tout à 0 c'est-à-dire que si je n'avais pas affecté des valeurs ici ...

```txt
/*
    sizeof(<donnee>)            : retourne la taille en octets d'une donnée

    malloc(<taille_en_octets>)  : allouer dynamiquement une zone mémoire
    free(<donnee_allouee>)      : libérer la mémoire allouée dynamiquement

    calloc(<donne>, <taille_en_octets>) : alloue et initialise tout à 0
*/
```

... pour chaque joueurs, pour chaque nombreJoueurs, bien évidemment le programme aurais mis des valeurs aléatoires d'accord il m'aurait mis tout et n'importe quoi dedans ce qui fait que c'est pas propre tout ça, c'est alors que l'avantage c'est qu'il peut tout initialiser à 0 d'ailleurs je ne vais même pas faire cette partie de code c'est-à-dire que je ne vais même pas modifier les joueurs et au lieu d'utiliser malloc(), ici je vais utiliser un calloc() avec c pour clear memory et puis alloc pour allocation.

```txt
liste_joueurs = malloc(sizeof(int) * nombreJoueurs);
//-->
liste_joueurs = calloc(nombreJoueurs, sizeof(int));
```

Ainsi on fait la même chose sauf que là les choses sont séparés c'est-à-dire qu'on commence par l'information `nombreJoueurs`, la donnée en elle-même et la taille donc `sizeof(int)`.

Voyez cette fois-ci, il n'y a pas qu'un seul paramètre mais il y en a deux c'est la petite différence donc il faut faire attention à ça et là je vais compilé, j'exécute.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 0;
    int *liste_joueurs = NULL;
    int i;

    printf("Combien de joueurs ? ");
    scanf("%d", &nombreJoueurs);

    liste_joueurs = calloc(nombreJoueurs, sizeof(int));

    if(liste_joueurs == NULL)
        exit(1);
    
    /*for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("Joueur %d -> numero %d\n", i + 1, i * 3);
        liste_joueurs[i] = i * 3;
    }*/

    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("[%d] ", liste_joueurs[i]);
    }

    free(liste_joueurs);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe
Combien de joueurs ? 5
[0] [0] [0] [0] [0]
```

Voilà je dis 5 joueurs et pouf tout est à zéro donc calloc() sert juste à ça, elle sert à allouer dynamiquement quand on alloue comme pour malloc() mais au lieu de mettre tout et n'importe quoi dedans, elle vous met des 0 par défaut.

D'ailleurs si j'avais repris l'exemple avec malloc() je vais vous montrer donc là en fait j'ai juste à faire ça puis j'exécute.

```txt
liste_joueurs = calloc(nombreJoueurs, sizeof(int));
// ->
liste_joueurs = malloc(nombreJoueurs * sizeof(int));
```

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 0;
    int *liste_joueurs = NULL;
    int i;

    printf("Combien de joueurs ? ");
    scanf("%d", &nombreJoueurs);

    liste_joueurs = malloc(nombreJoueurs * sizeof(int));

    if(liste_joueurs == NULL)
        exit(1);
    
    /*for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("Joueur %d -> numero %d\n", i + 1, i * 3);
        liste_joueurs[i] = i * 3;
    }*/

    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("[%d] ", liste_joueurs[i]);
    }

    free(liste_joueurs);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe
Combien de joueurs ? 5
[943284192] [544] [943259984] [544] [1546793847]
```

Voyez qu'il peut mettre des 0 mais que des fois, il peut mettre des choses, n'importe quoi. Il nous met des valeurs par défaut parce qu'il a appris des emplacements mémoire qui avait déjà apparemment des valeurs dedans et vous voyez des valeurs toutes bizarres, c'est pas propre donc en général quand on veut comme ça partir sur quelque chose d'initialisé on utilise calloc() au lieu de malloc().

C'est tout.

calloc() sert juste à ça, c'est simplement pour allouer dynamiquement mais en plus elle initialise tout à zéro ce que ne fait pas malloc(), ça c'est pour la deuxième fonction que je voulais que vous voyez.

On va terminer avec une dernière maintenant qui est un moyen de réallouer la mémoire c'est-à-dire que par exemple admettons que l'on veut, on se rend compte par exemple que la taille ici `malloc(nombreJoueurs * sizeof(int))` n'est plus suffisante donc on aimerait finalement ne pas avoir 5 joueurs, on aimerais en avoir 2 de plus par exemple qui rejoignent la partie en cours de route.

On ne va pas forcément libérer la mémoire de ce qu'on alloue avant et puis recréer une nouvelle allocation ce qui va alourdir le code, ça va faire un rappel à malloc() à chaque fois, on risque de faire des erreurs, d'alourdir le code bref ce n'est pas intéressant.

On peut, si on veut, directement réallouer la zone mémoire c'est-à-dire qu'on va utiliser une fonction qui s'appelle realloc() tout simplement.

## realloc

realloc() va permettre de réallouer un espace mémoire donc on a, si vous voulez, la <donnee> d'accord et on a sa <nouvelle_taille> voilà.

```txt
/*
    sizeof(<donnee>)            : retourne la taille en octets d'une donnée

    malloc(<taille_en_octets>)  : allouer dynamiquement une zone mémoire
    free(<donnee_allouee>)      : libérer la mémoire allouée dynamiquement

    calloc(<donne>, <taille_en_octets>) : alloue et initialise tout à 0
    realloc(<donnee>, <nouvelle_taille>) : réalloue un espace mémoire
*/
```

Alors realloc() réalloue un espace mémoire donc elle réinitialise pas à 0, c'est comme pour malloc() sauf qu'elle réalloue.

Alors est-ce que je peux vous faire un petit exemple parce que le code n'est pas super super pour faire un exemple très concret, on peut imaginer qu'à un endroit, dans le code, alors le nombre de joueurs changent donc on aurait d'un seul le nombre de joueurs qui changent donc je vais faire un petit séparateur `/*-----------------*/`.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 2;
    int *liste_joueurs = NULL;
    int i;

    liste_joueurs = malloc(nombreJoueurs * sizeof(int));

    if(liste_joueurs == NULL)
        exit(1);
    
    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("Joueur %d -> numero %d\n", i + 1, i * 3);
        liste_joueurs[i] = i * 3;
    }

    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("[%d] ", liste_joueurs[i]);
    }

    /*---------------------*/

    nombreJoueurs = //...

    /*---------------------*/

    free(liste_joueurs);

    return 0;
}
```

On ne plus demander le `nomreJoueurs` à l'utilisateur en fait mais on va dire que par défaut il y en a deux d'accord je vais virer toute cette partie-là `scanf("%d", &nombreJoueurs);`, toute la partie ou on demande.

Par défaut, on a deux joueurs `int nombreJoueurs = 2;` ok parce qu'on fait un multi voilà un multi de deux joueurs ensembles, on va allouer l'espace d'accord on va allouer deux fois la taille en octets d'un `int` donc il va bien allouer deux `int` ça va me donner une liste de deux joueurs, il va faire un petit for() dessus, il va afficher le joueur 1, le joueur 2 et cetera pas de souci.

```txt
int nombreJoueurs = 2;
int *liste_joueurs = NULL;
int i;

liste_joueurs = malloc(nombreJoueurs * sizeof(int));

if(liste_joueurs == NULL)
    exit(1);
```

Ensuite là d'un coup le nombre de joueurs passe à 5 `nombreJoueurs = 5;` donc on ne va pas faire `free(liste_joueurs);` puis refaire un nouveau malloc() et cetera .. non on va directement faire un realloc() donc on va reprendre la liste de joueurs d'accord et on va faire un realloc() sur la liste de joueurs `nombreJoueurs` qui est la donnée et donc on lui met la nouvelle taille donc c'est cette fois-ci `nombreJoueurs * sizeof(int)` si je ne me trompe pas.

On vérifie bien évidemment que ce n'est pas égale à NULL pareil, le realloc(), même chose, on vérifie que ça fonctionne et sinon on quitte parce qu'on fait une réallocation donc c'est pareil ..`exit(1)`.

```c
/*---------------------*/

nombreJoueurs = 5;

liste_joueurs = realloc(liste_joueurs, nombreJoueurs * sizeof(int));

if(liste_joueurs == NULL)
    exit(1);

/*---------------------*/
```

Ecoutez, je vais ensuite reprendre le même code, je ne m'embête pas même si ça va encore une fois rallongé.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 2;
    int *liste_joueurs = NULL;
    int i;

    liste_joueurs = malloc(nombreJoueurs * sizeof(int));

    if(liste_joueurs == NULL)
        exit(1);
    
    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("Joueur %d -> numero %d\n", i + 1, i * 3);
        liste_joueurs[i] = i * 3;
    }

    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("[%d] ", liste_joueurs[i]);
    }

    printf("\n---------------------\n");

    nombreJoueurs = 5;

    liste_joueurs = realloc(liste_joueurs, nombreJoueurs * sizeof(int));

    if(liste_joueurs == NULL)
        exit(1);

    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("Joueur %d -> numero %d\n", i + 1, i * 3);
        liste_joueurs[i] = i * 3;
    }

    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("[%d] ", liste_joueurs[i]);
    }

    /*---------------------*/

    free(liste_joueurs);

    return 0;
}
```

Vous voyez que je refais la même chose mais cette fois, il ne va pas le faire sur 3 joueurs, il va le faire sur 5.

On va tester voir si j'ai pas fait de bêtise alors `printf("\n---------------------\n");` pour bien séparer ici, bien différencier le code.

Allez hop, on y va.

```powershell
gcc main.c -o prog
.\prog.exe
Joueur 1 -> numero 0
Joueur 2 -> numero 3
[0] [3]
---------------------
Joueur 1 -> numero 0
Joueur 2 -> numero 3
Joueur 3 -> numero 6
Joueur 4 -> numero 9
Joueur 5 -> numero 12
[0] [3] [6] [9] [12]
```

On teste et voilà la différence au début on avait nos deux joueurs vous voyez [0] [3] donc pas de soucis et là d'un coup on a eu besoin de 5 joueurs pour je ne sais quoi eh bien il à réallouer l'emplacement mais cette fois-ci avec 5 et il a fait la modification automatiquement et on n'oublie pas le free() que j'ai quand même fait à la fin d'accord donc le free() en fait il est fait sur realloc() donc si vous voulez le realloc() a repris l'accès mémoire du malloc() c'est-à-dire les données qui étaient allouées donc pas besoin de faire de free() d'accord ainsi s'il y a une réallocation vous prenez le realloc() pas le malloc().

Alors comment ça fonctionne au niveau mémoire donc je ne vais pas vous montrer sur un chemin parce que c'est très simple alors normalement vous savez qu'ici `liste_joueurs = realloc(liste_joueurs, nombreJoueurs * sizeof(int));` avec *liste_joueurs* est une adresse d'accord est un espace qui a été alloué. Vous avez un certain type d'espace, un certain emplacements.

Le realloc() c'est soit en agrandissant un espace (c'est rare quand ça sert pour réduire même si ça peut arriver) donc s'il a là place d'agrandir sans modifier l'adresse et bien l'adresse de liste de joueurs ici `liste_joueurs = realloc(liste_joueurs, nombreJoueurs * sizeof(int));` n'aura pas changé d'accord.

D'ailleurs on peut faire le test, écoutez on va faire un test ici `printf("Adresse de la liste : %p\n", liste_joueurs);` pour avoir l'adresse de la liste au début après le malloc() et après le realloc().

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int nombreJoueurs = 2;
    int *liste_joueurs = NULL;
    int i;

    liste_joueurs = malloc(nombreJoueurs * sizeof(int));

    if(liste_joueurs == NULL)
        exit(1);
    
    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("Joueur %d -> numero %d\n", i + 1, i * 3);
        liste_joueurs[i] = i * 3;
    }

    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("[%d] ", liste_joueurs[i]);
    }

    printf("Adresse de la liste : %p\n", liste_joueurs);

    printf("\n---------------------\n");

    nombreJoueurs = 5;

    liste_joueurs = realloc(liste_joueurs, nombreJoueurs * sizeof(int));

    if(liste_joueurs == NULL)
        exit(1);

    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("Joueur %d -> numero %d\n", i + 1, i * 3);
        liste_joueurs[i] = i * 3;
    }

    for(i = 0 ; i < nombreJoueurs ; i++)
    {
        printf("[%d] ", liste_joueurs[i]);
    }

    printf("Adresse de la liste : %p\n", liste_joueurs);

    /*---------------------*/

    free(liste_joueurs);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe
Joueur 1 -> numero 0
Joueur 2 -> numero 3
[0] [3] Adresse de la liste : 000002117b291480

---------------------
Joueur 1 -> numero 0
Joueur 2 -> numero 3
Joueur 3 -> numero 6
Joueur 4 -> numero 9
Joueur 5 -> numero 12
[0] [3] [6] [9] [12] Adresse de la liste : 000002117b291480
```

Alors à l'exécution est-ce qu'il a changé l'adresse ? alors là vous voyez que pour la première adresse c'est *000002117b291480* et pareil pour la deuxième.

Dans la vidéo de formation, il y a eu un changement *003D1B30* et *003D3CB0*. Là apparement au niveau de ma mémoire vive, sur mon pc directement il n'y avait pas la place en fait si vous voulez pour ajouter les 3 joueurs manquants donc au lieu de garder la même adresse de l'emplacement mémoire, hé bien mon ordinateur donc Windows ici a trouver un autre emplacement.

Voilà il a essayé de chercher un endroit en mémoire où il y avait de quoi mettre un tableau de 5 entiers parce que le tableau au début qu'il avait stocké ne contenait que la place pour 2 et peut-être qu'après la mémoire était déjà occupé par autre chose sur mon système donc il a trouvé un emplacement plus grands qui convenait pour avoir les 5 entiers et c'est pour ça que l'adresse à changée mais des fois, on pourrait très bien ne pas voir de changement.

Ainsi il a changé parce qu'il n'y avait pas la place.

Peut-être que vous en testant ce code par exemple vous verrez que l'adresse n'a pas changée, si jamais il y avait la place du coup il aura conservé la même adresse donc ça peut être sympa comme ça.

Voilà ça peut être assez intéressant d'avoir ça donc c'est l'utilisation de realloc() et normalement, on devrait même le faire un peu plus sécurisé parce qu'il y a des risques de perdre éventuellement les données qui ont été allouées si jamais par exemple le realloc() ne fonctionnait pas mais je ne vais pas vous montrer maintenant parce que ça rallongerait inutilement alors que vous n'en aurez pas l'utilité tout de suite donc voilà actuellement contentez-vous du malloc() et du free(), c'est ce que vous utiliserez le plus pour le moment.

Quand on verra des choses plus avancés, bien évidemment on apprendra à sécuriser tout ce qu'on fait comme les lectures tout ça. Il y a des tutos ou il y aura des tutoriels pour ça donc ne vous en faites pas, il ne manque pas des choses à la vidéo et toutes ces choses-là, on complétera via des annexes, via des vidéos complémentaires, des tutoriels pour que vous puissiez bien programmer vraiment puisqu'on peut toujours améliorer bien évidemment vraiment tous ces tests et toutes ces vérifications.

Voila voila je vous ai dit tout ce que je voulais vous dire, vous avez vu tout ce qu'il fallait c'est-à-dire bah toutes ces fonctions là.

```txt
/*
    sizeof(<donnee>)            : retourne la taille en octets d'une donnée

    malloc(<taille_en_octets>)  : allouer dynamiquement une zone mémoire
    free(<donnee_allouee>)      : libérer la mémoire allouée dynamiquement

    calloc(<donne>, <taille_en_octets>) : alloue et initialise tout à 0
    realloc(<donnee>, <nouvelle_taille>) : réalloue un espace mémoire
*/
```

Toutes ces fonctions-là qui sont un ensemble de certaines fonctions qu'il faut savoir utiliser, il faut savoir à quoi elle servent et vous pouvez comme ça allouer de la mémoire de manière très dynamique.

Alors on fera un tutoriel pour faire de la lecture sécurisée d'accord c'est-à-dire de bien bien lire en fait au clavier d'utilisateur des données sans risquer par exemple un débordement de mémoire, ce genre de choses, on verra tout ça et vous verrez que l'allocation dynamique justement a toute son utilité donc c'est important de le savoir.

Je vais vous laisser avec ça, vous avez déjà tout le nécessaire concernant l'allocation dynamique pour bien commencer.

Si vous avez des questions toujours pareil, vous demandez parce que c'est un passage, il y a pas grand-chose, voyez encore une fois niveau syntaxe mais je peux comprendre que ce soit un peu compliqué à assimiler comme notion, de voir voilà à quoi ça sert et cetera où par exemple je ne comprends pas trop lorsqu'on met des étoiles pourquoi on fait des multiplications, il y a des sizeof() et cetera.

Ainsi s'il y a des choses que vous ne comprenez pas encore très bien, n'hésitez pas à vous entraîner bien évidement et si vous avez des questions je vous aiderais et je vous aiguillerait un petit peu là dessus pour que ce soit un peu plus clair dans votre tête et que vous puissiez bien appréhender en tout cas que ça se passe mieux en fait pour la suite.

La prochaine fois on parlera des fichiers d'accord ce sera encore comme j'avais dit dans la vidéo précédente ce sera l'une des dernières notion à voir en langage c, on apprendre à écrire, à lire des fichiers, ce genre de choses. C'est très utile dans des programmes notamment et puis voilà.

A très bientôt tout le monde et puis on se retrouve pour la prochaine vidéo.

ciao