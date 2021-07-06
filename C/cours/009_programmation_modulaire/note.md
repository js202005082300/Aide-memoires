# [9. Programmation modulaire](https://www.youtube.com/watch?v=tXgSx9MkVjs)

Bonjour à tous et bienvenue pour votre formation au langage c.

Dans cette séance numéro 9 nous allons passer aux choses un peu plus intermédiaires comme j'avais dit la dernière fois, vous avez vu maintenant toutes les notions de base à connaître.

On va entrer maintenant dans d'autres petites choses un peu plus compliquées donc il faut maîtriser tout ce que vous avez vu jusqu'à présent c'est à dire jusqu'aux fonctions pour pouvoir attaquer la suite parce que tout ce que vous avez vu avant va vous servir maintenant.

Alors c'est une étape important, nous allons parler de modularité, nous allons voir qu'est-ce que la modularité et en quoi ça consiste grosso modo.

## Définition de la modularité

Si je dois vous résumer avant de commencer à coder, **la modularité d'abord c'est une force de ce langage ou d'autres langages aussi c'est à dire qu'on va utiliser des bibliothèques, des bouts de code qui ont déjà été fait par d'autres personnes voilà c'est un ensemble de fonctions qu'on va intégrer dans notre programme**.

Voilà ce sont des bibliothèques que l'on va pouvoir inclure est utiliser dans nos programmes d'accord imaginer que c'est une espèce de package avec des fonctions toutes faites, et après vous n'avez plus qu'a l'inclure et à l'utiliser.

Alors vous connaissez un petit peu ce principe de programmation modulaire quelque part parce que vous vous le faites un petit peu avec les fonctions standard.

Quand vous utilisez printf(), vous utilisez en réalité le fichier d'en-tête stdio.h, c'est ce qui est inclus au début d'un fichier avec un `include`.

Voilà vous utilisez déjà des bibliothèques standard du langage, je parle bien de bibliothèque, on ne parle pas de librairies qui est un terme anglais et qui se traduit en bibliothèque et non pas en la librairie en français.

Parce que je vois souvent des informaticiens, même certains qui auraient 30 ou 40 ans d'expérience et qui vous dises librairies mais bon ça me pique un peu les yeux mais passons.

Voilà ça ça dit maintenant on va voir comment les choses fonctionnent donc ça c'est vraiment ce que fait la modularité, on récupère des modules puisqu'on entend le mot module dans modularité.

Si je récupère les bibliothèques à droite à gauche, je peux les intégrer, je peux les inclure, je peux les mélanger avec mon propre code, avec mes propres bibliothèques de fonction et cetera et cetera.

Bien sûr ça sous-entend derrière une réorganisation de notre code car on va créer une hiérarchie, on va créer plusieurs fichiers et on va essayer d'organiser tout ça.

**Attention la modularité ça ne signifie pas qu'on va créer plusieurs fichiers, ce n'est pas ça la modularité**.

La modularité c'est créer plusieurs choses, c'est moduler un petit peu un développement mais encore une fois ça oblige un petit peu a présenter le code sur plusieurs fichiers pour que ce soit mieux organisé.

Voilà on va faire ça tout de suite on ne va plus se contenter d'un seul petit fichier source mais on va en faire un petit 2e et pas une dizaine parce que ça ne sert à rien. Ainsi on va déjà un petit peu compliquer les choses à ce niveau-là.

Voilà on va partir sur notre petit explorateur, on crée notre fameux fichier de base donc on crée main.c et on va prendre l'exemple de joueur player.c, player.h

+ main.c
+ player.c
+ player.h

Voilà ça ce sont nos fichiers sources qui portent l'extension .c, et on va créer un fichier d'en-tête qui servira de bibliothèque et moi je veux bibliothèque pour les joueurs donc je vais l'appeler player mais cette fois-ci je vais lui donner l'extension .h pour header qui signifie l'en-tête.

Voilà on va directement démarrer avec cette partie là donc on va devoir commencer par notre fonction mail, c'est là que le programme va démarrer dans lequel je vais aussi inclure le fichier d'en-tête standard stdio.h et la fonction main() c'est-à-dire le code minimal.

+ main.c
```c
#include <stdio.h>

int main(void)
{
    printf("Bonjour :) !\n");

    return 0;
}
```
+ player.c
+ player.h

On test pour s'assurer que tout est en ordre.

```powershell
gcc main.c -o prog
prog.exe
Bonjour :) !
```

Voilà ici ça dit bien Bonjour donc pas de souci.

Là on a fait de la programmation standard comme on a fait jusqu à présent c'est à dire qu'on a compilé un seul fichier et on en a fait un programme, terminé !

On a du coup un exécutable prog.exe qu'on a obtenu en compilant juste main.c c'est à dire qu'on n'a rien fait avec player.c et player.h on aurait pu même les supprimer et recompiler sans.

## Inclure nos bibliothèques

Alors maintenant on va vouloir inclure ces fichiers là dans notre programme pour pouvoir les utiliser parce que moi je veux faire un jeu vidéo admettons et je veux pouvoir créer un joueur donc on va faire quelque chose de très standard et j'ai besoin d'inclure ces fameux fichiers.

Pourquoi y a-t-il un fichier .c et un fichier .h alors le fichier .h c'est un petit peu la fiche de description et c'est toujours associé à un autre fichier source donc en général quand vous avez un espèce de module vous avez un fichier .c qui va être l'implémentation des fonctions qui vont le composer. Le fichier .h c'est ce qui va contenir les prototype c'est à dire que on va juste y mettre le nom de la fonction avec sa valeur de retour et ses paramètres et on termine bien sûr par un ; à la fin ce qui est très important.

Si vous ne mettez pas le ; le compilateur va penser que vous développez la fonction c'est à dire qu'il doit penser que c'est son implémentation donc il faut bien mettre un ; à la fin pour montrer que c'est bien prototype.

En temps normal sans modularité ou plutôt sans l'utilisation de multiple fichiers, il me faudrait faire quelque chose comme ceci comme on a vu dans la vidéo sur les fonctions.

+ main.c
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
+ player.c
+ player.h
```powershell
gcc main.c -o prog
prog.exe
Bonjour :) !
```

Je rappelle si j'exécute c'est la même chose ce sera le même résultat donc pas de souci, je vous avais également expliqué que si vous voulez le mettre autrement pouvez mettre la fonction en dessous de main() et utiliser le prototype de la fonction sans oublier le ; à la fin ce qui est très important.

+ main.c
```c
#include <stdio.h>

void bonjour(void);

int main(void)
{
    bonjour();

    return 0;
}

void bonjour(void)
{
    printf("Bonjour :) !\n");
}
```
+ player.c
+ player.h
```powershell
gcc main.c -o prog
prog.exe
Bonjour :) !
```

Là je peux recompiler et exécuter pour obtenir la même chose, aucune différence on a le même résultat dans tout le cas mais une présentation différente au niveau du code.

Maintenant j'aimerais pouvoir exporter cette fonction bonjour() dans une bibliothèque donc on va commencer par prendre le prototype et le mettre dans le fichier d'en-tête donc le .h

Voilà donc on a mis le prototype dans le fichier .h donc ça c'est la fiche c'est à dire que s'il y a quelqu'un qui regarde ce fichier .h il est ainsi capable de voir ce qu'un player peut faire donc là par exemple je peux voir que mon player peut dire Bonjour. Voilà c'est un peu bizarre comme fonction mais bon passons.

Ensuite l'implémentation c'est à dire le code on va le mettre dans le fichier player.c dans le fichier source associée donc on met généralement le même nom pour les identifier plus facilement. Alors ce n'est pas une obligation ça fonctionnera si je mets un autre nom par exemple si jamais toto.c associé à player.h ça marcherait mais voilà c'est quand même plus pratique de mettre les mêmes noms pour savoir où on en est.

Alors là maintenant petite indication si je teste bonjour(), vous voyez qu'il va me mettre *undefined reference to 'bonjour'.

+ main.c
```c
#include <stdio.h>

int main(void)
{
    bonjour();

    return 0;
}
```
+ player.c
```c
void bonjour(void)
{
    printf("Bonjour :) !\n");
}
```
+ player.h
```h
void bonjour(void);
```
```powershell
gcc main.c -o prog
main.c: In function 'main':
main.c:6:5: warning: implicit declaration of function 'bonjour' [-Wimplicit-function-declaration]
    6 |     bonjour();
      |     ^~~~~~~
c:/users/sam/onedrive/programmes/mingw64/bin/../lib/gcc/x86_64-w64-mingw32/10.2.0/../../../../x86_64-w64-mingw32/bin/ld.exe: C:\Users\sam\AppData\Local\Temp\ccozkrzq.o:main.c:(.text+0xe): undefined reference to `bonjour'
collect2.exe: error: ld returned 1 exit status
```

Voilà on a demandé au compilateur d'inclure le fichier stdio.h mais lui ne contient pas notre fonction bonjour() mais elle n'existe vraiment pas dans ce fichier standard du c donc il va falloir du coup l'indiquer.

De la même manière vous voyez que stdio.h est un fichier .h comme player.h donc on va devoir l'inclure.

Petite distinction comme c'est un fichier à nous c'est à dire qu'il n'est pas intégré directement dans l'environnement donc en général c'est un dossier qui s'appelle include qui contient des fichiers et des bibliothèques et cetera donc un fichier propre à l'environnement de développement que vous utilisez ou si comme moi vous avez installé MinGW, vous aurez dans c:/mingw/lib/ les bibliothèques propres à notre environnement.

Alors là distinction, nous allons utiliser des doubles guillemets `#include player.h" okay (main.c) ça c'est important de le savoir.

Ensuite ici dans l'implémentation (player.c), c'est la même chose `#include player.h" parce que j'ai besoin également du prototype dans player.c

Voilà donc ça `#include "player.h"` doit être mis dans tous les fichiers .c à chaque fois.

Voilà ne mettez pas des `#include "player.h"` dans des fichiers .h Ça ne servirait un petit peu à rien

Ensuite même chose comme j'utilise printf() dans player .c je n'oublie pas d'inclure stdio.h sachant que je pourrais également le mettre dans le fichier .h parce que j'inclus player.h dans les deux fichiers.

+ main.c
```c
#include <stdio.h>
#include "player.h"
```
+ player.c
```c
#include <stdio.h>
#include "player.h"
```
+ player.h
```h
```

ou

+ main.c
```c
#include "player.h"
```
+ player.c
```c
#include "player.h"
```
+ player.h
```h
#include <stdio.h>
```

Voilà je pourrais éventuellement inclure stdio.h dans mon fichier d'en-tête mais en général par convention on ne le fait pas d'accord on le met généralement dans les fichiers sources pour se dire qu à chaque fois qu'un fichier source en a besoin, on le met.

Voilà parce qu'on pourrait très bien avoir un fichier .c qui n'utilise pas par exemple certaines bibliothèques mais si on le met dans le .h la bibliothèque risque d'être intégrée à tous les fichiers alors qu'elle n'est pas forcément utile dans tous les fichiers donc en général on le met propre fichier en question. On fait au cas par cas.

Le player.h est maintenant bien intégré dans main.c, player.c et dans player.h on a juste le prototype.

Alors là je vais compiler mais par contre, on ne va pas compiler que ce fichier mais on va compiler l'ensemble des fichiers en .c donc on va faire `gcc *.c -o prog` avec l'étoile qui signifie tous les fichiers qui porte l'extension .c donc *.c et on écrit le reste comme d'habitude `gcc *.c -o prog`.

+ main.c
```c
#include <stdio.h>
#include "player.h"

int main(void)
{
    bonjour();

    return 0;
}
```
+ player.c
```c
#include <stdio.h>
#include "player.h"

void bonjour(void)
{
    printf("Bonjour :) !\n");
}
```
+ player.h
```h
void bonjour(void);
```
```powershell
gcc main.c player.c -o prog
prog.exe
Bonjour :) !
```

Je compile, j'écris le nom de l'exécutable et ça nous affiche Bonjour miracle.

Voilà le Bonjour qui je rappel a été défini dans un autre fichier (player.c).

Voilà vous venez d'apprendre à organiser un programme en plusieurs fichiers, c'est aussi simple que ça, on commence par faire un fichier d'en-tête dans lequel on y met le prototype. Ensuite on fait un fichier .c, vous y mettez l'inclusion vers ce prototype, vers ce fichier d'en-tête pareil dans le main() et dans les endroits où vous voulez utiliser les fonctions du fameux fichier.

Partout je vais vouloir utiliser Bonjour, je vais devait mettre player.h en début de fichier et ça fonctionne.

Voilà donc ici on a 3 fichiers qui fonctionnent ensemble, aucun souci.

## Directives de préprocesseur

Petite indication, ça c'est surtout quand vous ferez des choses un peu plus compliquées, je vous le dis maintenant parce qu'on aura l'occasion d'en parler plus tard parce qu'on va parler des directives de préprocesseur c'est à dire tout ce qui commence par des dièses mais là je vous en donne déjà une nouvelle à voir, c'est de mettre ceci `#ifndef`

+ player.h
```h
#ifndef

void bonjour(void);
```

`#ifndef` pour if not define et ensuite vous mettez un nom de constante en majuscule par exemple on peut mettre PLAYER_H voilà chacun écrit comme il veut donc si la constante PLAYER_H alors je la définie donc je fais un `#define PLAYER_H`.

+ player.h
```h
#ifndef PLAYER_H
#define PLAYER_H

void bonjour(void);

#endif
```

Pour le moment vous ne comprenez pas à quoi sert tout ça mais ça viendra, on le verra pour la suite donc pour le moment faites-le sans forcément comprendre parce que c'est une petite sécurité au niveau de la programmation.

Enfin vous mettez `#endif` voilà.

C'est simplement pour dire que quand vous allez compiler, Eh bien si le fichier player.h a déjà été inclus d'accord donc si la constante PLAYER_H a déjà été définie parce que autrement vous voyait qu'elle est définie avec `#define PLAYER_H` et bien tu ne vas pas le ré inclure sinon on peut avoir des fois des inclusions infinies de fichier par exemple un fichier A qui veut inclure un fichier B, et puis le fichier B va d'inclure le fichier A.

Forcément comme chacun cherche l'autre, on ne peut jamais réussir à compiler des fois on a des erreurs d'inclusion infinie comme pour les boucles sauf que là on a des inclusions et on en finit jamais, on n'arrive jamais à compiler donc pour éviter ça on met ce genre de petite constante, de directive de préprocesseur pour dire d'inclure qu'une seule et seulement une seule fois le fameux fichier player.h

Voilà c'est une petite sécurité en plus que je ne vous ai pas détaillé mais mettez-le automatiquement et mettez le nom de la constante que vous voulez tant que les 2 correspondent on pourrait même appeler ça juste PLAYER voilà.

Je ne vous donne pas plus d'application parce qu'on verra ça par la suite donc ce n'est pas du tout l'objectif de ce cours ni le sujet de ce qu'on va parler ici donc on aura bien assez à parler donc ça c'est le bon pour le fichier .h

Alors maintenant nous allons faire autre chose nous allons pas forcément utiliser Bonjour, comme on n'a pas encore vu les chaînes de caractères on va pas faire une fonction de ce type-là mais qu'est-ce qu'on peut faire ? Admettons que je veux créer d'autres fonctions pour le Player donc je vais directement dans le fichier .h donc notre fichier d'en-tête et je vais me demander qu'est-ce que je peux faire ? Qu'est-ce que je peux lui ajouter et qu'est-ce que peut faire un joueur ? Par exemple pour avoir la fonction `int get_niveau();` ou bien `int reset_niveau(void);`

+ player.h
```h
#ifndef PLAYER_H
#define PLAYER_H

void bonjour(void);
int reset_niveau(void);

#endif
```

Ensuite une fois qu'on a fait le prototype, on l'implémente dans player.c et on le dit ce qu'on fait, on décide par exemple de créer quelque chose en faisant `int niveau;` puis qu'on initialise à 0 et on retourne en entier.

On affiche le niveau dans main(), le retour de la fonction reset_niveau() qu'on stocke dans `int level = reset_level();` et là on affiche le niveau après reset.

+ main.c
```c
#include <stdio.h>
#include "player.h"

int main(void)
{
    int level = 15;

    printf("Niveau actuel : %d\n", level);

    level = reset_niveau();

    printf("Niveau actuel : %d\n", level);

    return 0;
}
```
+ player.c
```c
#include <stdio.h>
#include "player.h"

void bonjour(void)
{
    printf("Bonjour :) !\n");
}

int reset_niveau(void)
{
    int niveau;

    niveau = 0;

    return niveau;
}
```
+ player.h
```h
#ifndef PLAYER_H
#define PLAYER_H

void bonjour(void);
int reset_niveau(void);

#endif
```
```powershell
gcc *.c -o prog
prog.exe
Niveau actuel : 15
Niveau actuel : 0
```

Voyez donc si le niveau a changé, ça fonctionne on peut donc créer plusieurs fonctions, on en fait au fur et à mesure et on choisit le prototype de la fonction qu'on veut et ensuite on implémente et ensuite on peut l'utiliser partout où on a mis un `#include "player.h"` au début sauf dans le fichier de source associé `player.c` qui contient juste l'implémentation d'ailleurs je ne vois pas l'intérêt d'utiliser la fonction Bonjour dans l'implémentation ça n'a aucune utilité peut être pour faire des tests mais alors dans ce cas là on fera un fichier test voilà c'est aussi simple que ça pour l'utilisation des fichiers.

Voilà c'est tout ce que vous avez à savoir, c'est simplement un fichier d'en-tête player.h, un fichier associé pour l'implémentation et après on n'oublie pas les fichiers d'en-tête standard dans les fichiers d'implémentations les fichiers .c. Et là on met les constantes PLAYER_H dans le fichier d'en-tête, ces directives de préprocesseur pour éviter les inclusions infinies dans certains cas de compilation donc pour éviter les erreurs et que ça ne posera aucun problème pour la suite.

Là je vous ai montré tout ce qu'il y avait à savoir à ce niveau, et vous pourriez vous demander ou est la modularité à ce niveau là mais ça on le verra surtout quand on fera de la SDL, quand on fera de la 2D on utilisera des bibliothèques c'est à dire une bibliothèque développée qui permet de faire de l'imagerie et de la 2D tout simplement donc c'est pas quelque chose que nous avons développé mais qui existe déjà donc du coup on va l'utiliser.

Le fait d'utiliser une bibliothèque et de l'inclure dans notre programme pour faire des choses avec c'est ce qu'on appelle de la modularité, d'accord on va développer de manière modulaire c'est à dire qu'on va utiliser des choses de manière de droite à gauche, peut être nos propres fonctions également en plus donc c'est de la programmation modulaire tout simplement.

## La portée des variables

Nous allons aborder une dernière partie dans cette vidéo au sujet de la portée des variables, nous en avions parlé la dernière fois lorsqu'on a abordé les fonctions, je vous avais dit qu'à la fin d'une fonction une variable est détruite c'est pour ça par exemple ici nous retournons le niveau.

```c
int reset_niveau(void)
{
    int niveau;

    niveau = 0;

    return niveau;
}
```

Voilà je vous avais dit qu à la fin d'une fonction une variable détruite c'est pour ça que là nous avons retourné `niveau` donc je le retourne et de toute façon ici le niveau dans l'environnement de cette fonction aurait été détruit c'est à dire qu'une fois que la fonction est terminée il n'y a plus de variable `niveau`.

En fait il y a une exception c'est à dire qu'on va pouvoir utiliser un mot-clé mais d'abord je vais vous parler de la portée des variables et après on verra, et elle est propre à la fonction elle a été déclarée parce que la fonction est considérée comme un contexte donc là une fois que je quitte la fonction la variable est détruite.

Si je veux faire une variable qui existera tout le temps et partout, je vais faire ce qu'on appelle une variable globale.

Utiliser une variable globale est quelque chose à éviter dans la mesure du possible évitez de le faire parce qu'en général il y a toujours moyen de faire autrement sauf quelques exceptions mais dans ces cas-là il faudra faire une variable globale.

Une variable globale est quelque chose en dehors de toute fonction par exemple je vais la faire dans player.c admettons et donc je vais faire `int TVA = 20;` d'accord je vais l'écrire en majuscule et je vais l'afficher dans main().

+ main.c
```c
#include <stdio.h>
#include "player.h"

int main(void)
{
    int level = 15;

    bonjour();

    printf("Niveau actuel : %d\n", level);

    level = reset_niveau();

    printf("Niveau actuel : %d\n", level);

    printf("TVA = %d\n", TVA);

    return 0;
}
```
+ player.c
```c
#include <stdio.h>
#include "player.h"

int TVA = 20;

void bonjour(void)
{
    printf("Bonjour :) !\n");
    printf("TVA = %d\n", TVA);
}

int reset_niveau(void)
{
    int niveau;

    niveau = 0;

    return niveau;
}
```
+ player.h
```h
#ifndef PLAYER_H
#define PLAYER_H

void bonjour(void);
int reset_niveau(void);

#endif
```
```powershell
gcc *.c -o prog
prog.exe
Bonjour :) !
TVA = 20
Niveau actuel : 15
Niveau actuel : 0
```

Voilà vous voyez qu'il affiche TVA égal à 20% alors que la variable n'était pas liée à la fonction donc elle n'était pas liée au niveau de la durée de vie donc elle va exister partout sans problème donc elle pourra être utilisée comme ça directement partout dans mon fichier. Elle sera utilisée partout, et ne sera pas détruite en fin de fonction parce qu'elle n'a pas été créée ou déclaré ou initialiser dans une fonction mais elle a été fait à l'extérieur donc elle est utilisable directement comme ça.

## La variable static

On peut également utiliser le mot clé static `static int TVA = 20;`, static c'est pour vraiment forcer l'utilisation comme ça uniquement dans ce fichier donc si j'essaye de l'utiliser par exemple dans le main() voyez que ça ne va pas fonctionner.

+ main.c
```c
#include <stdio.h>
#include "player.h"

int main(void)
{
    int level = 15;

    bonjour();

    printf("Niveau actuel : %d\n", level);

    level = reset_niveau();

    printf("Niveau actuel : %d\n", level);

    printf("TVA = %d\n", TVA);

    return 0;
}
```
+ player.c
```c
#include <stdio.h>
#include "player.h"

static int TVA = 20;

void bonjour(void)
{
    printf("Bonjour :) !\n");
}

int reset_niveau(void)
{
    int niveau;

    niveau = 0;

    return niveau;
}
```
+ player.h
```h
#ifndef PLAYER_H
#define PLAYER_H

void bonjour(void);
int reset_niveau(void);

#endif
```
```powershell
gcc *.c -o prog
main.c: In function 'main':
main.c:16:26: error: 'TVA' undeclared (first use in this function)
   16 |     printf("TVA = %d\n", TVA);
      |                          ^~~
main.c:16:26: note: each undeclared identifier is reported only once for each function it appears in

```

On essaye d'utiliser la variable statique TVA dans le main() et il nous met bien évidemment que TVA n'est pas déclaré donc pas de souci à ce niveau là mais ça permet vraiment de forcer l'utilisation uniquement dans le fichier.

Normalement quand on faisait une variable globale dans certains cas, il pouvait même l'utiliser dans d'autres fichiers donc par exemple si j'aurais pu afficher la variable TVA dans le main() comme ça elle aurait été déclarée de manière globale mais là il y a des changements au niveau du compilateur qui ont été fait, que fait que pour éviter une utilisation globale de la variable, le compilateur l'a créé par défaut en statique.

Donc je pense c'est à vérifier qu'en mettant juste ceci `int TVA = 20;` automatiquement le compilateur à créer TVA comme variable statique parce que là on essaye depuis tout à l'heure d'afficher TVA dans le main() et il me dit qu'elle n'est pas déclaré alors qu'elle est globale alors qu'une variable globale est disponible dans tout le programme en fait.

Ce n'est pas grave de toute façon une variable globale on peut toujours s'en passer donc à la rigueur oubliez les variables globales, sachet qui ont maintenant une variable comme ça en dehors du code avec le mot clé *static* elle ne sera disponible que dans le fichier où elle a été déclarée, et là elle ne sera pas détruite à la fin d'une fonction puisqu'elle ne sera pas propre à une fonction.

Ainsi faites ce genre de syntaxe pour être sûr `static int TVA = 20;`, qui peut ainsi être affiché, appelé, utilisé dans reset_niveau(), bonjour() sans problème dans tout le fichier player.c

Alors maintenant qu'est-ce qui se passe si je mets le mot statique dans une variable, dans une fonction par exemple on va mettre ça sur la variable niveau dans augmente_niveau() dont on utilise le retour dans printf() dans la fonction main() parce que oui on peut ajouter le retour de fonction directement dans un printf() plutôt que de passer par une variable.

+ main.c
```c
#include <stdio.h>
#include "player.h"

int main(void)
{
    printf("Niveau : %d\n", augmente_niveau());

    return 0;
}
```
+ player.c
```c
#include <stdio.h>
#include "player.h"

void bonjour(void)
{
    printf("Bonjour :) !\n");
}

int augmente_niveau(void)
{
    int niveau = 0;

    niveau+=2;

    return niveau;
}
```
+ player.h
```h
#ifndef PLAYER_H
#define PLAYER_H

void bonjour(void);
int augmente_niveau(void);

#endif
```
```powershell
gcc *.c -o prog
prog.exe
Niveau : 2
```

Voilà il nous met que niveau égal à 2, pourquoi ? Parce que je lui dis de créer une variable `int niveau = 0;` dans la fonction augmente_niveau() voilà on l'initialise à 0 ensuite tu fais niveau +2 et donc on retourne 2.

D'ailleurs si je ré exécute le code plusieurs fois voilà ce qui se passe.

+ main.c
```c
#include <stdio.h>
#include "player.h"

int main(void)
{
    printf("Niveau : %d\n", augmente_niveau());
    printf("Niveau : %d\n", augmente_niveau());
    printf("Niveau : %d\n", augmente_niveau());

    return 0;
}
```
+ player.c
```c
#include <stdio.h>
#include "player.h"

void bonjour(void)
{
    printf("Bonjour :) !\n");
}

int augmente_niveau(void)
{
    int niveau = 0;

    niveau+=2;

    return niveau;
}
```
+ player.h
```h
#ifndef PLAYER_H
#define PLAYER_H

void bonjour(void);
int augmente_niveau(void);

#endif
```
```powershell
gcc *.c -o prog
prog.exe
Niveau : 2
Niveau : 2
Niveau : 2
```

Voilà le niveau est toujours égal à 2 !

Pourquoi ? parce que si vous vous souvenez de ce que j'ai dit dans la vidéo précédente, comme il y a une portée des variables à chaque fois la variable `niveau` est détruite à la fin de la fonction donc on finit toujours par recréer cette variable niveau comme ceci, c'est toujours la même chose.

Maintenant si je me le mots-clés static `static int niveau = 0;`

+ main.c
```c
#include <stdio.h>
#include "player.h"

int main(void)
{
    printf("Niveau : %d\n", augmente_niveau());
    printf("Niveau : %d\n", augmente_niveau());
    printf("Niveau : %d\n", augmente_niveau());

    return 0;
}
```
+ player.c
```c
#include <stdio.h>
#include "player.h"

void bonjour(void)
{
    printf("Bonjour :) !\n");
}

int augmente_niveau(void)
{
    static int niveau = 0;

    niveau+=2;

    return niveau;
}
```
+ player.h
```h
#ifndef PLAYER_H
#define PLAYER_H

void bonjour(void);
int augmente_niveau(void);

#endif
```
```powershell
gcc *.c -o prog
prog.exe
Niveau : 2
Niveau : 4
Niveau : 6
```

Voilà on utilise une variable statique et le comportement qui s'est passé est assez bizarre parce qu'on avait dit au départ que on initialise la variable à 0 donc il aurait dû refaire comme tout à l'heure c'est-à-dire afficher 2, 2, 2. Eh bien non parce que quand vous utilisez le mot clé static dans une variable de fonction, cela veut simplement dire que cette variable ne doit pas être détruite à la fin.

Donc quand j'ai exécuté et appeler augmente_niveau() pour la 2e fois donc que j'ai fait pour la 2e fois l'appel à la fonction, il n'a pas réinitialisé donc recréer une variable niveau dans la fonction augmente_niveau() donc en fait il a ignoré tout simplement cette ligne là `static int niveau = 0;`.

Voilà il a ignoré cette ligne là `static int niveau = 0;`, en effet comme il a vu qu'il y avait déjà un statique qui avait déjà été exécuté il a directement passer à la ligne suivante `niveau += 2;` donc là variable qui était déjà égal à 2 il lui a rajouté +2 d'où le 4, ensuite pour la 3e utilisation et pour cette variable qui était déjà passé à 4 il a ignorer l'initialisation et il est directement passé à cette ligne là `niveau += 2;` voilà et du coup il lui a rajouté encore 2 et il est passé à 6.

Alors ça c'est important parce que s'il faut déclarer une variable statique dans une fonction, elles ne seront pas détruites à la fin de cette fonction donc c'est vous rappeler la même fonction, cette variable existera toujours jusqu'à ce que le programme se termine.

C'est le seul moment ou une variable statique en fonction est détruite c'est à la fin d'un programme, ce n'est pas la fin de la fonction mais c'est vraiment la fin du programme donc il y a une petite distinction à ce niveau-là importante à savoir en tout cas.

## La fonction static

Alors admettons maintenant que le Bonjour je ne veuille pas l'appeler quand je suis dans le main() mais que je ne veux que pouvoir l'appeler que quand je suis dans le fichier player.c, je peux mettre le mot clé static devant une fonction.

+ player.c
```c
#include <stdio.h>
#include "player.h"

static void bonjour(void)
{
    printf("Bonjour :) !\n");
}

int augmente_niveau(void)
{
    static int niveau = 0;

    niveau+=2;

    return niveau;
}
```

Voilà je peux mettre le mot-clé static devant une fonction, ce qui veut simplement dire que la fonction bonjour() ici ne peut être appelé uniquement que dans le fichier player.c d'ailleurs je peux le faire pour la fonction `static int augmente_niveau(void)`.

+ main.c
```c
#include <stdio.h>
#include "player.h"

int main(void)
{
    printf("Niveau : %d\n", augmente_niveau());
    printf("Niveau : %d\n", augmente_niveau());
    printf("Niveau : %d\n", augmente_niveau());

    return 0;
}
```
+ player.c
```c
#include <stdio.h>
#include "player.h"

void bonjour(void)
{
    printf("Bonjour :) !\n");
}

static int augmente_niveau(void)
{
    static int niveau = 0;

    niveau+=2;

    return niveau;
}
```
+ player.h
```h
#ifndef PLAYER_H
#define PLAYER_H

void bonjour(void);
static int augmente_niveau(void);

#endif
```
```powershell
gcc *.c -o prog
In file included from main.c:2:
player.h:5:12: warning: 'augmente_niveau' used but never defined
    5 | static int augmente_niveau(void);
      |            ^~~~~~~~~~~~~~~
c:/users/sam/onedrive/programmes/mingw64/bin/../lib/gcc/x86_64-w64-mingw32/10.2.0/../../../../x86_64-w64-mingw32/bin/ld.exe: C:\Users\sam\AppData\Local\Temp\cckLHbaH.o:main.c:(.text+0x62): undefined reference to `augmente_niveau'
c:/users/sam/onedrive/programmes/mingw64/bin/../lib/gcc/x86_64-w64-mingw32/10.2.0/../../../../x86_64-w64-mingw32/bin/ld.exe: C:\Users\sam\AppData\Local\Temp\cckLHbaH.o:main.c:(.text+0x75): undefined reference to `augmente_niveau'
c:/users/sam/onedrive/programmes/mingw64/bin/../lib/gcc/x86_64-w64-mingw32/10.2.0/../../../../x86_64-w64-mingw32/bin/ld.exe: C:\Users\sam\AppData\Local\Temp\cckLHbaH.o:main.c:(.text+0x88): undefined reference to `augmente_niveau'
collect2.exe: error: ld returned 1 exit status
```

Voilà `warning: 'augmente_niveau' used but never defined` d'accord on a ce message d'erreur parce que pour le compilateur main() n'a pas le droit de l'utiliser.

La fonction est statique donc on n'autorise que le fichier player.c à l'utiliser donc je peux passer par exemple créer une autre fonction toujours dans le même fichier pour appeler augmente_niveau().

+ main.c
```c
#include <stdio.h>
#include "player.h"

int main(void)
{
    bonjour();

    return 0;
}
```
+ player.c
```c
#include <stdio.h>
#include "player.h"

void bonjour(void)
{
    printf("Bonjour :) !\n");

    printf("Niveau : %d\n", augmente_niveau());
}

static int augmente_niveau(void)
{
    static int niveau = 0;

    niveau+=2;

    return niveau;
}
```
+ player.h
```h
#ifndef PLAYER_H
#define PLAYER_H

void bonjour(void);
static int augmente_niveau(void);

#endif
```
```powershell
gcc *.c -o prog
prog.exe
Bonjour :) !
Niveau : 2
```

Voilà le mot-clé statique va simplement servir à faire cet appel de cette fonction dans un seul fichier.

Pour une variable, le mot-clé static va permettre de ne pas détruire cette variable à la fin d'une fonction alors ça c'est important, et dans le cadre d'une fonction, la fonction ne peut être appelée que dans le fichier où cette fonction est définie, où cette fonction est implémentée.

Voilà donc ça c'est une autre possibilité mais c'est pas vraiment fort utilisé pour les fonctions, généralement l'utilisent surtout pour les variables et ça sert beaucoup moins pour les fonctions.

Voilà c'est bien de le savoir, c'est des petites choses comme ça sur la portée des variables, la portée des données que l'on a au niveau du code.

On aura de toute façon l'occasion d'en voir par la suite avec plein d'exemples la pratique donc pas de souci.

Tout ce qu'il y a besoin de retenir pour cette séance sur la modularité, c'est l'organisation des fichiers, tout ce qu'on a vu dans le fichier .h le fichier d'en-tête pour les prototype et les directives de processeur qu'on verra par la suite. Ensuite son fichier .c qui est associée et qui porte le même nom en général dans lequel on implémente les fameuses fonctions dont on a les prototypes dans le fichier d'en-tête et après dans les autres fichiers nous utilisons simplement le `#include "player.h"`.

Voilà on fait simplement ce include et après on peut s'en servir, comme d'un **module** c'est à dire quelque chose qu'on a ajouté en plus, que l'on intègre au programme et dont on peut se servir comme une recette en se servant de toutes les fonctions.

Ainsi vous pouvez utiliser ces fonctions et ça marche sans problème.

Voilà nous allons nous arrêter là pour la modularité, nous avons vu grosso modo tout ce qu'il y avait à savoir au niveau de la modularité.

Pour la prochaine fois nous parlerons des directives de préprocesseur justement, on parlera de pas mal de petites choses également.

À partir de maintenant on attaque la programmation avancée, on va parler des pointeurs, on va parler des fichiers, on va parler de structure et cetera, et par la suite les structures de données donc là ce sera vraiment de la programmation avancée donc c'est encore à niveau au-dessus par rapport à ce qu'on voit.
J'espère que ce sera compréhensible et que vous arriverez à bien tenir le rythme, et à suivre l'évolution de la formation, l'évolution des vidéos et on se retrouve la prochaine fois pour notre séance 10.

À très bientôt tout le monde, et bonne programmation, bon codage