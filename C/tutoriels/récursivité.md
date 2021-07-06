# [Récursivité](https://www.youtube.com/watch?v=3XyKY9BKVN0)

La récurcivité est un problème algorythmique, ce n'est pas lié à un langage.

Ainsi on peut faire de la récursivité dans pratiquement tout les langages de prorammation.

Du coup ce n'est pas obligatoire, on peut très bien développer sans faire de la récursivité sans soucis.

Alors quand on n'a pas de récursivité, on parle d'itératif donc on peut avoir une fonction en itératif et on peu avoir son équivalent en récursif. On peut passer de l'un à l'autre sans problème.

Allons y, première exemple de fonction récursive.

```c
#include <stdio.h>

void fonctionRecursive(void)
{
    printf("Je suis une fonction recursive.\n");
    fonctionRecursive();
}

int main(void)
{
    fonctionRecursive();
    return 0;
}
```
```powershell
gcc recursivite.c -o prog
.\prog.exe
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
#etc.
```

On appelle la fonction dans elle-même mais on doit couper avec ctrl+c parce qu'on a une boucle infinie.

Alors il n'y a pas des while, il n'y a pas de do while, il n'y a pas de for et pourtant il a fait une boucle infinie parce que la fonction se rappelle.

On définit la récursivité comme une fonction qui va se rappeler elle-même, c'est ce qu'il faut savoir en premier pour avoir une fonction récursive.

Le 1e problème rencontré est qu'une fonction récursive va s'appeler à l'infinie parce qu'elle pas de point d'arrêt. Il n'y a pas de condition ou autre qui dit de s'arrêter.

On peut améliorer la fonction en mettant un point d'arrêt.

```c
#include <stdio.h>

void fonctionRecursive(int i)
{
    if(i == 10)
        return;
    
    printf("Je suis une fonction recursive.\n");
    fonctionRecursive(i+1);
}

int main(void)
{
    fonctionRecursive(0);
    return 0;
}
```
```powershell
gcc recursivite.c -o prog
.\prog.exe
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
Je suis une fonction recursive.
```

Voilà on affiche 10 fois la phrase, on a un point d'arrêt `i == 10` qui fait que même quand la fonction va se rappeler elle-même avec la fonction qui se souvient de la valeur de i comme arguement.

Vous savez que quand on quitte une fonction toutes les variables déclarées en local sont perdues mais là comme on fait un appel à elle-même, elle n'a pas perdue l'information et voyez que du coup elle la récupère et elle va s'arrêter au bon moment.

C'est la base d'une fonction récursive dans laquel, il faut bien fixer un point d'arrêt sinon on va avoir quelque chose qui va tourner en boucle.

Globalement une fonction comme ça ne sert à rien mais il faut savoir qu'on fait appel à un **système de pile**.

Vous connaissez ce type de structure de données donc qui permet d'empiler des informations par le dessus comme une tour, et quand on va retirer les éléments, on va retirer l'élément qui est le plus en haut comme une pile d'assiètes.

La récursivité s'est pareil qu'une pile, on empile la 1e valeur de i, et quand la fonction va se rappeler elle-même on va du coup ravoir des valeurs onc on va empiler une 2e fois, une 3e, une 4e, etc.

On va empiler 10 fois parce qu'on s'arrête à i == 10, et ensuite on va remonter toute la pile donc on va remonter du bas de la pile.

C'est le printf() qu'on empile, ça va être plus parlant avec cet exemple-là.

```c
#include <stdio.h>

void fonctionRecursive(int i)
{
    if(i == 10)
        return;
    
    printf("(%d) Je suis une fonction recursive.\n", i);
    fonctionRecursive(i+1);
}

int main(void)
{
    fonctionRecursive(0);
    return 0;
}
```
```powershell
gcc recursivite.c -o prog
.\prog.exe
(0) Je suis une fonction recursive.
(1) Je suis une fonction recursive.
(2) Je suis une fonction recursive.
(3) Je suis une fonction recursive.
(4) Je suis une fonction recursive.
(5) Je suis une fonction recursive.
(6) Je suis une fonction recursive.
(7) Je suis une fonction recursive.
(8) Je suis une fonction recursive.
(9) Je suis une fonction recursive.
```

Voyez il est bien incrémenté, on peut également commencer par 1, `printf("(%d) Je suis une fonction recursive.\n", i);`.

Ainsi il va prendre tout à l'envers, remonter toute la pile, toutes les récursions qu'il y a eu.

Il y a une différence entre récursion et la récursivité qui est le principe de faire une fonction qui va s'appeler elle-même donc c'est l'explication, la théorie tandis que la récursion c'est ce qui se passe dans le programme.

La récursion c'est ce qui se passe dans le programme c'est-à-dire qu'à partir du moment où je fait cet appel `fonctionRecursive(i+1);` je fait une récursion.

Ainsi là j'ai 10 récursions dans ma fonction récursive.

Récursion/récursivité c'est un peu la même chose mais pour que ce soit plus clair pensez récursivité comme le principe de faire de la récursivité et quelque chose de récursif tandis que la récursion c'est le moment dans la fonction récursive où on fait justement l'appel à elle-même.

On va avoir une pile qu'on remonte depuis le bas et afficher les résultats et cetera.

Par exemple si on avait un calcul à faire, on aurait le 1e résultat en bas, ensuite le 2e au-dessus et cetera. Du coup on remonterais la châine de pile qui terminerais par le résultat final de notre fonction récursive.

Grosso modo voilà comment ça fonctionne, un appel à elle-même et on établi un point d'arrêt donc c'est vraiment la règle pour ne pas avoir de boucle infinie.

Petite parenthèse, l'exemple de la structure de données comme la pile, la liste et cetera sont des bons exemples d'utilisation puisque dans la pile je veux afficher tout les éléments qui sont rattaché (on imagine d élément).

```c
// d-d-d-d-d-d
```

Une liste d'élément tous rattachés par un tiret.

On prend automatiquement le 1e élément de la pile en faisant un printf en utilisant des pointeurs lorsqu'on se fixait sur le 1e élémént du coup il affichait le 1e d.

Ensuite on lui disait de rappeler la fonction d'affichage mais cette fois-ci sur la pile flèche next `pile->next;` c'est-à-dire tout ce qui suit *...-d-d-d-d-d*.

Donc il faisait pareil, il rappelait la fonction mais comme il devait faire un printf() sur le 1e élément et bien du coup sur *d* (%s) qu'il affichait. Ensuite il refaisait un appel flèche next donc il prenait le sous-ensemble *...-d-d-d-d-d* dont il affichait le 1e élément et cetera. Voilà *->next* et donc c'est juste qu'à chaque appel on travaille avec un ensemble beaucoup plus petit c'est-dire on part de tout ça *d-d-d-d-d-d* puis au 2e appel c'était ça *d-d-d-d-d*, le 3e appel *d-d-d-d*, le 4e appel *d-d-d*, le 5e appel *d-d*, le 6e appel *d*, et au 7e comme on est arrivé à NULL hé bien on disait que si c'était égal à NULL, on s'arrête.

C'est comme ça qu'on faisait du parcours tout simplement.

Alors je n'avais peut être pas plus détaillé et j'avais resté assez sommaire sur la récusivité et donc je vous avais dit qu'on aurais l'occasion de la voir dans une annexe.

Ainsi du coup c'est comme ça que ça fonctionnait c'est-à-dire que la fonction s'appelait elle-même jusqu'à avoir un point d'arrêt qui signifiais que la suite de la pile était NULL c'est-à-dire qu'on arrivait à la fin de la pile tout simplement.

Voilà comment ça fonctionne donc voilà un cas utile où il est intéressant de faire une récursivité c'est à dire de pouvoir afficher comme ça des éléments ou faire un parcours sur une liste, un arbre, etc. C'est là tout l'intérêt que ça peut avoir.

Encore une fois ce n'est pas obligatoire donc grosso modo c'est pas toujours vrai car il y a des exceptions mais une fonction itérative au niveau du nombre de ligne elle n'a plus aucune fonction récursive.

```c
void fonctionRecursive(int i)
{
    if(i == 10)
        return;
    
    printf("(%d) Je suis une fonction recursive.\n", i);
    fonctionRecursive(i+1);
}
```

Là par exemple celle-là si j'avais voulu faire quelque chose il en fallu faire un while() et cetera alors elle n'aurais pas spécialement été plus longue pour le coup c'est un cas particulier mais une fonction itérative en général est plus longues à écrire qu'une fonction récursive donc une fonction récursive est forcément plus lisible parce qu'on a moins de code par contre dans la majorité des cas mais c'est pas tous encore une fois, une fonction récursive sera plus gourmande mais elle n'est pas forcément plus longue.

Une foncyion récursive va être plus gourmande en ressource qu'une fonction itérative, pourquoi ? puisque une fonction itérative va être appelée qu'une seule fois donc au niveau de la pile puisque la pile d'appels ça fonctionne actuellement avec pratiquement tout les langages quand vous appelez en fait une fonction il va stocker l'adresse de la fonction dans une pile d'appels, c'est une pile qu'utilise votre compilateur, utilisé par votre programme en fait mais c'est même le système d'exploitation qui exécute le programme.

Le système d'exploitation qui exécute le programme, il va avoir une pile d'appels et il va stocker ici fonctionRecursive(). Voilà il va faire tout ce qu'il a à faire dedans et c'est tout.

Dans le cas d'une fonction cursive comme on fait plusieurs appels ben là par exemple il en fait 10, il va donc stocker 10 fois l'adresse de fonctionRecursive() dans la pile donc vous voyez qu'au niveau place que ça va prendre sur la pile d'appels ça va être beaucoup plus gros et forcément beaucoup plus gourmand en ressources, on va prendre plus de place en mémoire mais ça c'est important à savoir.

Ainsi c'est pas forcément que ça va être plus long au niveau de l'exécution ou autre ou moins performants comme on pourrais des fois l'entendre c'est pas une question de ça on ne peut pas vraiment parler de fonction récursive plus ou moins performante qu'une fonction itérative, c'est pas vraiment vrai du tout donc je n'employerais pas ce terme-là par contre  effectivement on a une différence au niveau utilisation des ressources.

**Une fonction récursive va être forcément plus gourmande en ressource qu'une fonction itérative, c'est logique.**

Du coup il faut vraiment utiliser une fonction récursive dans un cas où ça s'y prête absolument ou alors parce que ça simplifie énormément énormément le code.

Voyez par exemple pour l'exemple de la pile, moi ça me paraissait tout simplement logique de faire comme ça, c'était beaucoup plus simple, j'aurais écrit beaucoup plus de lignes si j'avais fait en ittératif et ça aurait été moins clair.

Là tout de suite il n'y a pas d'erreur possible vous pouvez faire ça en récursif sans problème donc ça me paraissait plus logique donc vraiment je vous dis c'est pas obligatoire si vous voulez programmer toute votre vie sans faire de récursivité c'est tout à fait possible vos programmes ne seront pas plus mauvais ou autre, ça n'a absolument rien avoir.

Pour vous dire la vérité dans les programmes professionnels, les jeux vidéo, etc, il est quand même assez rare de voir des fonctions récursives.

Souvent on fait des fonctions récursives quand on veut coder quelque chose vite parce qu'on veut tester rapidement en fait une fonctionnalité on va le faire en récursif parce que ça vient tout de suite comme ça à l'esprit et après comme on veut optimiser le code on veut  l'améliorer on repart sur de l'itératif bien souvent, c'est encore une fois des exceptions mais dans la globalité, dans des gros projets c'est quand même assez rare de voir sur des programmes ou des jeux en version final et cetera, beaucoup de fonctions récursive c'est quand même assez rare donc comme quoi c'est pas quelque chose d'obligatoire, faut pas vous dire bah tiens maintenant je connais la récursivité donc je vais en faire partout ... surtout pas ça c'est un très très mauvais très mauvais réflexes et serait une très mauvaise habitude.

Faites de la récursivité quand vraiment c'est évident, quand ça peut vraiment simplifier votre code puisque l'important encore une fois en programmation avant tout c'est aussi la simplification du code.

Faites ce qui est au plus simple plutôt que de vouloir faire compliquer parce que je ne sais pas ça fait mieux parce que dans les copains on ne fait pas ça fera mieux au niveau du code ou je ne ne sais quoi, on s'en fout.

Vraiment il faut que ce soit simple et que ça fasse ce que vous vouliez, ce que ça devait faire tout simplement c'est-à-dire que si vous voulez résoudre un problème faut que le programme le résolve.

Après que le code soit complexe, simplifié, ce sera quand même plus agréable si le code est simple donc ça après c'est vous qui voyez.

Voilà pour tout ce qui est récursivité, les différences pour récursivité, itérativité bref enfin tout ce qui est ittératif, récursif, cette histoire voilà c'est plus long, c'est plus cours à l'exécution, etc.

C'est plus une question de taille en place au niveau de la pile d'appels, une fonction récursive prendra plus de place qu'une fonction itérative donc ça c'est purement logique on ne peut pas revenir là-dessus c'est comme ça que ça fonctionne.

Alors petite parenthèse, on peut avoir des fois des **fonctions récursives terminales**.

Une fonction récursive terminale remercier terminale ça veut tout simplement dire que celle là va avoir donc un fonctionnement un petit peu différent en fait puisqu'on ne va pas  remonter dans la pile d'appels, je vous avais expliqué qu'au début on empilais comme ça les différents appels avec chaque fois la fonction, avec les différents résultats quand on en avait et à la fin on remontait comme ça toute la pile pour que faire des calculs ou faire des affichages ce genre de choses et terminé.

Une fonction récursive terminale, on va avoir effectivement l'empilage comme ça mais on n'aura pas de remonté c'est à dire qu'à la fin de l'empilage, on aura bien notre résultat alors je ne vais pas vous donner d'exemples particulier puisqu'il faudrait partir sur de la factoriel et cetera.

J'aime pas trop spécialement l'exemple de la factorielle mais c'est vrai que c'est quand un des plus courts donc je vais vous montrer, on reprendra après l'exemple de fibonacci, pas forcément en récursivité terminal mais je prendrai des exemples.

Je vous parlerais de Fibonacci juste après par un autre exemple.

On va prendre un exemple donc de la factorielle, la factorielle en mathématiques je vais vous expliquer ce que c'est ne vous en faites pas.

On fait une factorielle avec une récursivité normal donc qu'on peut retrouver et je vais vous expliquer un petit peu après.

```c
#include <stdio.h>
#include <stdlib.h>

unsigned long factorielle(int n)
{
    if(n < 0)
        exit(EXIT_FAILURE);
    
    if(n == 0 || n == 1)
        return 1;

    return n * factorielle(n - 1);
}

int main(void)
{
    factorielle(0);
    return 0;
}
```

Voilà c'est un exemple de la factorielle en mathématiques qu'est ce que c'est ? tout simplement je vais vous montrer, c'est très rapide à vous expliquer par exemple si je dis de me donner la factorielle de 3 ou de 5 ça va être tout simplement `n * n-1 * n-2` donc ça fait ceci.

```c
/*
    Factorielle de  3 : 3 * 2 * 1 = 6
                    5 : 5 * 4 * 3 * 2 * 1 = 120
*/
```

La factorielle vous voyez, plus le nombre que vous allez prendre au départ est grand plus vous allez avoir de multiplication et avoir un produit qui est conséquent donc c'est pour ça que j'ai prit deux exemples c'est-à-dire qu'à un moment donné si vous dépassez ici la taille des entiers voire même des octales, vous allez avoir soit un débordement de type de variables ou alors un débordement de la pile puisque vous allez empiller tellement tellement de valeurs que vous allez dépasser la pile, c'est ce qu'on appelle un stack overflow.

Donc enfin c'est pas un débordement tempon, c'est pas comme pour les chaînes de caractères c'est vraiment un débordement de piles et dans ce cas le programme va tout simplement planter.

C'est pour ça que je n'aime pas du tout cet exemple-là, la factorielle qui est repris tout le temps tout le temps parce qu'au final on ne peut pas vraiment l'utiliser la récursivité on va dire à plein potentiel puisqu'à un moment donné où on risque de faire planter le programme bêtement.

Eh ben on va le prendre parce que c'est un des plus parlants, c'est un des plus utilisés donc c'est quand même bien de le citer aussi que vous puissiez le connaître.

Donc voilà la factorielle en mathématiques, la factorielle d'un nombre n c'est `n * n-1 * n-2 ...` et cetera jusqu'on arrive à 1.

En effet le dernier de la multiplication c'est `*1` donc là on s'arrête ici.

Ainsi je dit que si `n < 0`, je quitte parce qu'il ne peut pas être plus petit que 0.

Si c'est plus petit que 0, on n'en veux pas parce que vous voyez ici que je vais retourner un nombre non signé c'est à dire qui est vraiment positif donc si c'est plus petit que 0 je n'en veux pas. Je ne veux pas un nombre négatif, on vérifie ça.

C'est important dans un calcul récursif de bien gérer les cas d'erreur aussi pas seulement le point d'arrêt mais il faut gérer les cas d'erreur.

Si c'est égal 0 ou 1 voilà on retourne 1.

Sinon je fais un return de `n * Factorielle(n-1);` soit la fonction elle-même Factorielle() et sauf que là elle va prendre le sous-ensemble donc *n-1* donc elle va s'appeler et à chaque fois le n va changer donc on va avoir la pile qui va se changer donc on va avoir tous les calculs c'est-à-dire que le premier n qui va être empilé, ça va être par exemple factorielle de 5 par exemple où on va voir le premier truc qui va être 5, ensuite le deuxième ça va être 4, 3, 2, 1 et cetera.

Ensuite le calcul va remonter la pile donc ça va faire `5 * Factorielle(n-1);` avec ça *Factorielle(n-1)* la partie qui va s'empiler en fait et ça *5 * Factorielle(n-1);* la partie qui va se faire en remontant la pile. La multiplication va se faire en remontant la pile donc on va faire le 5 x 4 x 3 x 2 x 1 et en obtiendra le résultat à la fin voilà tout
simplement.

D'ailleurs si je fais `factorielle(5);`.

```c
#include <stdio.h>
#include <stdlib.h>

unsigned long factorielle(int n)
{
    if(n < 0)
        exit(EXIT_FAILURE);
    
    if(n == 0 || n == 1)
        return 1;

    return n * factorielle(n - 1);
}

int main(void)
{
    printf("%d\n", factorielle(5));
    return 0;
}
```
```powershell
gcc recursivite.c -o prog
.\prog.exe
120
```

Factorielle de 5, évidemment avec un printf, on fait prog et ça nous donne 120 donc voyez que ça peut grandir très vite.

Alors si je mets 25 déjà voyez le nombre qu'on a.

```powershell
gcc recursivite.c -o prog
.\prog.exe
2076180480
```

Alors donc là je ne vais pas aller plus loin sinon je vais déborder au niveau de l'entier bien que ce soit du type `long`.

D'ailleurs il faudrait que je mette L majuscule là `return 1L;` pour être sûr qu'il prenne bien un long alors que là `factorielle(int n)` j'ai un entier donc il faut faire attention à ne pas avoir un **débordement type** voir un **débordement de pile**.

Si on tente 50.

```powershell
gcc recursivite.c -o prog
.\prog.exe
0
```

Si je met 50 voyez déjà que j'ai un débordement type donc j'ai un résultat inattendu donc le programme ne s'est pas comporté comme il était prévu donc il plante.

Très vite on va dépasser un entier d'accord c'est super important mais voyez que l'exemple ici à une certaine limite puisque du coup la factorielle finit par dépasser.

Ce code est une récursivité standard d'accord.

```c
unsigned long factorielle(int n)
{
    if(n < 0)
        exit(EXIT_FAILURE);
    
    if(n == 0 || n == 1)
        return 1;

    return n * factorielle(n - 1);
}
```

On est déjà sur une grosse parenthèse par rapport à la récursivité terminale, c'est quand on n'a pas besoin de remonter comme ça la chaîne de la pile donc l'appeler comme ça par le bas je vais vous prendre le même exemple sans devoir faire ça donc le `n < 0` on le garde et on va toujours quitter parce que ici plus petit que 0 on va toujours quitter puisque nous on n'en veut pas sinon je vais faire par contre si `n == 0` je vais dire `return 1;`.

```c
unsigned long factorielle(int n)
{
    if(n < 0)
        exit(EXIT_FAILURE);
    
    if(n == 0)
        return 1;

    return n * factorielle(n - 1);
}
```

Toujours pareil si `n == 1` je vais lui dire tu me retourne `res` le résultat et sinon il va faire factorielle de n-1 et n*res, `factorielle(n-1, n*res)`

```c
unsigned long factorielle(int n, long res)
{
    if(n < 0)
        exit(EXIT_FAILURE);
    
    if(n == 0)
        return 1;
    
    if(n == 1)
        return res;
    
    return factorielle(n - 1, n * res);
}
```

Ainsi là on a bien le n-1 donc le nombre d'avant et là n*res on fait la multiplication donc là voyez que je n'ai pas besoin de remonter parce que je vais déjà avoir le résultat *res* ici `factorielle(int n, long res)` c'est-à-dire qu'au bout d'un moment comme n va finir par être égal à 1 puisqu'il va toujours faire -1, -1, etc. on va retourner voyez le résultat donc on n'aura pas besoin de remonter la pile.

Ainsi là on obtient une récursivité terminale tout simplement.

```c
#include <stdio.h>
#include <stdlib.h>

unsigned long factorielle(int n, long res)
{
    if(n < 0)
        exit(EXIT_FAILURE);
    
    if(n == 0)
        return 1;
    
    if(n == 1)
        return res;
    
    return factorielle(n - 1, n * res);
}

int main(void)
{
    printf("%d\n", factorielle(20, 20));
    return 0;
}
```
```powershell
gcc recursivite.c -o prog
.\prog.exe
907018240
```

Alors évidemment, on va avoir des noms très long au bout d'un moment mais peu importe tout ça pour vous dire en fait de faire attention avec la factorielle parce qu'on a très très vite dépassé le type et on peut avoir des problèmes au niveau ... mais pas de problème au niveau de la pile puisque c'est une récursivité terminale mais comme on a en fait le résultat en deuxième argument automatiquement on n'a pas besoin de remonter la pile donc on ne va pas l'utiliser.

On n'a pas besoin de remonter la pile, on va faire en fait qu'un seul appel comme on va avoir qu'un seul appel celui-là `factorielle(n - 1, n * res);` et on va avoir directement le résultat donc ça va être automatiquement tout simplement un moyen d'économiser du temps puisqu'on n'a pas besoin de parcourir la pile comme ça en montant les résultats pour obtenir ce que l'on voulait à la fin par contre ça reste une récursive donc ça reste évidemment plus gourmands en espace qu'une fonction itérative ça ne change pas à ce niveau là puisqu'on a quand même les appels qui sont fait à chaque fois, à chaque recursion donc on empile bien à chaque fois ça ça ne change pas. C'est juste au niveau résultat comment on l'obtient à la fin qui va être plus rapide.

Par contre troisième possibilité on a ensuite les fonctions qui sont dans un cas particulier en fait au niveau la récursivité, elles ces fonctions-là vont être aussi performantes que les fonctions ittératives donc au niveau exécution, etc, on aura aucune différence en réalité par rapport à une fonction itérative. Je ne vais pas donner d'exemple, je ne vais pas en parler plus que ça parce que ça va beaucoup dépendre du langage de programmation là pour le cas.
 
Par exemple pour le c il faudrait appliquer des optimisations au niveau de la compilation et cetera pour que ce soit effectivement pris en compte et que ça puisse fonctionner c'est pas comme pour la récursivité terminale d'ailleurs c'est-à-dire qu'il y a certains trucs qu'il faut activer.

Par exemple en php, la récursivité terminale, il me semble que ça n'existe pas.

J'en ai jamais fait en PHP puisque ça j'en ai jamais eu besoin donc je ne peux pas vous dire mais il me semble que php ne gère pas la récursivité terminale en tout cas maintenant après il y a PHP7 maintenant donc peut-être que ça a changé mais aux dernières nouvelles ce n'était pas le cas donc voilà c'est pas forcément disponibles partout donc rester sur de la récursivité standard dans tous les cas.

Voilà l'exemple que j'avais avant par exemple était très bien. J'avais ça en fait.

```c
#include <stdio.h>
#include <stdlib.h>

/*
    Factorielle de  3 : 3 * 2 * 1 = 6
                    5 : 5 * 4 * 3 * 2 * 1 = 120
*/

unsigned long factorielle(int n)
{
    if(n < 0)
        exit(EXIT_FAILURE);
    
    if(n == 0 || n == 1)
        return 1L;
    
    return n * factorielle(n - 1);
}

int main(void)
{
    printf("%d\n", factorielle(30));
    return 0;
}
```
Voilà l'exemple de base, on avait quelque chose qui fonctionne très bien où effectivement pour la récursivité que ce soit itératif ou non, ça n'a pas beaucoup changé parce qu'en itératif ou non, si vous prenez un grand nom ça va planter aussi donc ce n'est pas forcément parce que c'est récursif, c'est juste que c'est quelque chose un niveau mathématique qui va augmenter énormément.

Voyer si je fait la factorielle de 30, on va avoir un nombre très très très très grand très
rapidement.

Il faut faire attention à ça parce que ça peut jouer des tours un petit peu au niveau des calculs à faire donc ça c'est le risque quand on fait de la récursivité c'est d'avoir comme ça à un moment un résultat qui est inattendu, qui peut poser des problèmes soit au niveau des types de variables utilisées, les types de données ou alors au niveau de la pile d'appel qui peut du coup saturer et donc on aurait un stack overflow.

Faites attention à ce niveau-là, vraiment la récursivité utilisez-là que si vraiment vous savez ce que vous faites et si ça a vraiment un intérêt.

Moi je vous dis que je l'utilise très peu, pas que je ne serai pas spécialement le faire tout le temps mais parfois il y a des moments où ça n'a absolument aucun intérêt à part de gagner quelques lignes de code et faire quelque chose qui est un petit peu plus avancé c'est tout ce que ça apporte mais franchement rien de plus donc voilà.

Pour le moment moi je l'utilise pour les structures de données voilà faire des parcours dans un arbre et cetera, c'est super pratique mais c'est tout en général je me contente de la récursivité là dessus.

## Fibonacci

Du coup je vais terminer cette vidéo puisque je ne vais pas en parler pendant des heures et des heures, ça reste une petite annexe comme ça pour les plus d'entre vous qui voudraient connaître la récursivité en plus du reste de la formation et je prends un dernier exemple avec la suite de fibonacci.

La suite de fibonacci c'est une suite mathématiques très connue, je vous invite à faire des recherches si vous ne la connaissez pas si vous ne l'avez pas encore vu à l'école ou autre parce qu'elle est très très intéressante, on la retrouve dans pas mal de films, dans beaucoup d'oeuvres littéraires, dans les peintures, etc, c'est associé au nombre d'or, etc, à tout ça donc si vous connaissez le davinci code, etc. C'est sûrement des choses qui vous parle et la suite de fibonacci vous dit peut-être quelque chose donc renseignez vous si vous ne connaissez pas, ce sera toujours intéressant et c'est une suite mathématiques qui va fonctionner avec ces termes-là.

```c
/*
    Suite de Fibonacci
    ------------------
    1 1 2 3 5 8 13 21 ...
*/
```

Alors comment elle fonctionne ? donc les deux premiers termes c'est 1 1 puis 2 et à partir de là en fait si vous voyez le résultat est la somme des deux termes précédents donc on a le premier terme qui est 0 comme avec les tableaux, on commence toujours avec le terme 0 sur une suite mathématiques donc c'est 1, le terme n°1 c'est 1, le terme n°2 c'est 2, le terme n°3 c'est 3, le terme n°4 c'est 5 et cetera.

Ainsi 1 + 1 ça fait bien 2, ensuite on fait un 1 + 2 ça fait 3, 2 + 3 = 5, 3 + 5 = 8 et cetera.

Voilà comme ça on a une suite qui peut du coup aller à l'infini qui s'appelle la suite de Fibonacci, ça avait même été utilisé où il avait en fait utilisé la suite de Fibonacci pour l'étude sur la reproduction des lapins en fait donc pareil, il faut regarder un petit peu il y a pas mal de choses là dessus, ça peut être utilisé dans beaucoup d'études.

C'est très très utilisé dans le domaine scientifique et c'est très intéressant franchement de la connaître et de se renseigner dessus donc moi je vais vous proposer parce que vous voyez que là ça paraît évident, qu'on a comme ça une récursivité *1 1 2 3 5 8 13 21 ...* qui est évidente au niveau de cette suite.

On va faire une petite fonction récursive de Fibonacci.

```c
#include <stdio.h>
#include <stdlib.h>

/*
    Suite de Fibonacci
    ------------------
    1 1 2 3 5 8 13 21 ...
*/

int fibonacci(int n)
{
    if(n < 2)
        return 1;
    
    return(fibonacci(n - 1) + fibonacci(n - 2));
}

int main(void)
{
    printf("%d\n", fibonacci(5));
    return 0;
}
```

Si vous avez compris ça reprend les deux termes précédents pour former une sommes qui va donner le terme actuel.

On vérifie ça.

```powershell
gcc recursivite.c -o prog
.\prog.exe
8
```

Voilà en tout cas ça s'affiche vite parce que je n'ai pas quelque chose de très grand.

```c
#include <stdio.h>
#include <stdlib.h>

/*
    Suite de Fibonacci
    ------------------
    1 1 2 3 5 8 13 21 ...
*/

int fibonacci(int n)
{
    if(n < 2)
        return 1;
    
    return(fibonacci(n - 1) + fibonacci(n - 2));
}

int main(void)
{
    printf("%d\n", fibonacci(5));
    printf("%d\n", fibonacci(20));
    printf("%d\n", fibonacci(30));
    printf("%d\n", fibonacci(35));
    printf("%d\n", fibonacci(40));
    return 0;
}
```
```powershell
gcc recursivite.c -o prog
.\prog.exe
8
10946
1346269
14930352
165580141
```

On cherche la valeur de Fibonacci pour laquelle l'exécution devient longue sans faire planter le programme.

Regardez le petit temps d'attentes quand j'exécute le résultat de `fibonacci(40)`

Voyez c'est assez lent quand même, pour pas grand chose *42* au lieu de *40* voyez le temps que ça prends.

```c
#include <stdio.h>
#include <stdlib.h>

/*
    Suite de Fibonacci
    ------------------
    1 1 2 3 5 8 13 21 ...
*/

int fibonacci(int n)
{
    if(n < 2)
        return 1;
    
    return(fibonacci(n - 1) + fibonacci(n - 2));
}

int main(void)
{
    printf("%d\n", fibonacci(42));
    return 0;
}
```
```powershell
gcc recursivite.c -o prog
.\prog.exe
433494437
```

Voyez comme il change énormément alors que je rajoute que deux nombres mais c'est déjà beaucoup.

Je fait donc juste un printf() pour afficher le résultat d'une fonction ensuite j'appuie sur Entrer, j'attends j'attends et seulement maintenant j'ai le résultat donc ça c'est une fonction recurcive de Fibonacci dont il manque certaines informations puisqu'on rallonge le temps d'exécution pour rien surtout qu'on fait une récursivité multiple `return(fibonacci(n - 1) + fibonacci(n - 2));` parce que oui on peut appeler plusieurs fois la fonction dans le même programme, ça ne pose pas de souci dans la fonction elle-même je l'appelle 2 fois comme ça dans un return forcément c'est très très long donc ça ce n'est évidemment pas la bonne méthode.

Bien sûr cette méthode est très courte, trois lignes même si en c on peut très bien mettre deux lignes.

```c
int fibonacci(int n)
{
    if(n < 2) return 1;
    return(fibonacci(n - 1) + fibonacci(n - 2));
}
```

Voyez je peux très bien faire une fonction récursive de Fibonacci qui fonctionne mais qui va être très lente.

Moi je vais choisir la méthode un peu plus longue mais qui du coup va être beaucoup plus rapide et vous allez voir la différence là vous avez vu un petit peu le temps qu'il fallait et si on compte ça prend 3 secondes.

```powershell
gcc recursivite.c -o prog
.\prog.exe
433494437
```

Voilà donc il faut grosso modo trois secondes pratiquement pour afficher le résultat donc moi je vais faire `n < 2` on retourne 1 ça ça ne change pas. Ensuite j'ai créé des variables que je laisse en début de fonction même si dans e cas `n < 2`, elle ne serait pas utilisée et on fait comme ça.

```c
int fibonacci(int n)
{
    int i = 1, terme0 = 1, terme1 = 1, tmp;

    if(n < 2) 
        return 1;
    //etc.
}
```

Hé voilà si `n < 2` on retourne 1, là vous voyez que j'ai stocké i qui part de 1, on a les deux premiers termes ici de la suite `1 1 2 3 5 8 13 21 ...` parce que je n'ai pas besoin de les calculer, ils ne sont en fait régit par la règle qui prend les deux termes précédents voilà donc on met ça en variables.

Ainsi je crée des variables en plus certes mais ça va carrément accélérer l'exécution du programme et là je fais une boucle while() donc c'est ça qui servira à faire mon point d'arrêt tant que i est plus petit que n `i < n` voilà ça c'est la règle.

```c
int fibonacci(int n)
{
    int i = 1, terme0 = 1, terme1 = 1, tmp;

    if(n < 2) 
        return 1;

    while(i < n)
    {
        //etc.
    }
}
```

Je vais donc faire usage de ma variable temporaire parce que c'est pour ça qu'elle sert avec le terme0 et le terme1 donc là je fais la somme des deux termes précédents, vous vous souvenez que ça fait partie de la suite de fibonacci.

```c
int fibonacci(int n)
{
    int i = 1, terme0 = 1, terme1 = 1, tmp;

    if(n < 2) 
        return 1;

    while(i < n)
    {
        tmp = terme0 + terme1;
        //etc.
    }
}
```

Ensuite je vais dire que le terme0 maintenant c'est le terme1 donc on décale tout simplement, et du coup terme1 c'est égal à la variable temporaire donc ça permet comme ça de les changer. Voilà ça permet de les changer en fait, grooso modo je fait une petite somme et après je les change où je met terme1 dans terme0 et terme1 ça devient la somme des 2. Enfin je fait un return du terme1. Et on n'oublie pas d'incrémenter le i pour éviter la boucle infinie.

```c
#include <stdio.h>
#include <stdlib.h>

/*
    Suite de Fibonacci
    ------------------
    1 1 2 3 5 8 13 21 ...
*/

int fibonacci(int n)
{
    int i = 1, terme0 = 1, terme1 = 1, tmp;

    if(n < 2) 
        return 1;

    while(i < n)
    {
        tmp = terme0 + terme1;
        terme0 = terme1;
        terme1 = tmp;
        i++;
    }

    return(terme1);
}

int main(void)
{
    printf("%d\n", fibonacci(42));
    return 0;
}
```
```powershell
gcc recursivite.c -o prog
.\prog.exe
433494437
```

Là je fait un appel récursif même si je n'ai pas mis le nom de la fonction puisque je passe par tmp et on y va.

```powershell
gcc recursivite.c -o prog
.\prog.exe
433494437
```

Là vous voyez le temps d'excution , c'est instantanée.

Grosse différence par rapport à ce qu'on avu tout à l'heure donc vraiment il y a plus de lignes de code mais par contre cette fonction récursive de Fibunacci est beaucoup plus performante à l'exécution que celle qui faisait deux lignes donc attention c'est pas toujours parce que c'est court que ça va être plus rapide donc ça c'est évidemment une mauvaise habitude aussi de penser que parce que vous n'avez pas beaucoup de lignes de code, ça va être rapide à l'exécution.

Cette fonction est beaucoup plus longue on crée en plus des variables, etc. Par contre elle va être beaucoup plus performante à l'exécution puisqu'on n'a pas de récursivité multiples tout simplement.

Donc très bon exemple ici que je préfère au lieu de la factorielle et qui change un petit peu et qui pour le coup est plus intéressant parce que faire des recherches sur la suite Fibonacci est je pense plus plus intéressant que les factorielles même si les factorielles sont utilisés, je veux dire qu'on utilise ça beaucoup aussi dans les probabilités et tout ça  donc c'est loin d'être non inutilisé loin de là mais ça change un peu avec Fibonacci que de tout le temps prendre l'exemple des factorielles qui je vous dis est prit tout le temps tout le temps comme exemple quand on parle de récursivité.

Voila voila je vais rester avec ça je ne vais pas vous donner plus d'exemples soit après la récursivité faut pratiquer.

Alors ce qu'il faut retenir c'est que c'est une fonction qui s'appelle elle-même et il ne faut pas oublier de mettre un point d'arrêt pour qu'elle s'arrête au bout d'un moment et qu'il n'y ait pas de boucle infinie et dans le cas vous voyez ici pour la suite d'évaluer éventuellement des points où je ne suis pas obligé de faire l'appel càd s'il y a des conditions dans lesquelles je peux directement retourner une valeur comme ici par exemple pour `n < 2` hé bien je le fait, ça ne sert à rien de commencer à faire tout calcul et des appels inutiles.

Donc faites attention à ça et si vraiment vraiment vous tombez sur une fonction ittérative où la question de la récursivité est évidante vous pouvez la transformer cette fonction, rappelez vous qu'on peut passer d'une fonction d'un type à l'autre et vice versa.

Toute fonction itérative peut avoir son équivalent en récursif et inversement.

Mais si ce n'est pas évident, restez avec de l'itératif ce sera très bien et je vous dis que c'est pas quelque chose d'obligatoire faut vraiment en avoir un intérêt donc voilà si ce que vous avez vu là vous pensez que c'est utile pour vous et bien très bien vous aura appris quelque chose, si ce n'est pas utile hé bien au moins vous saurez ce que c'est la récursivité et vous pourrez continuer de programmer comme vous faites d'habitude sans faire de  récursivité de votre vie peu importe ça ne vous posera aucun souci, vraiment vous ne serez pas en handicap par rapport aux autres développeurs donc pas de problème à ce niveau là au moins vous aurez vu ce que c'est.

Je vous dis à bientôt on se retrouvera donc pour une prochaine vidéo de la formation.

A très bientôt