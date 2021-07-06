# [10. Préprocesseur](https://www.youtube.com/watch?v=L8q1wJ8z7Ts)

Bonjour à tous, bienvenue pour votre séance numéro 10 sur une formation en langage c.

Cà ne va pas être forcément la plus intéressante de toute la formation puisque qu'on va parler pas mal théorique, il y aura pas tellement de choses à vous montrer ou à voir au niveau du code mais céder des points essentiels en tout cas pour avancer sur la suite notamment quand on parlera des tableaux et d'autres structures de données, quand on verra les structures et les énumération pourquoi pas.

Les préprocesseur, c'est essentiel qu'il faut connaître en programmation c alors c'est pour pouvoir avancer donc je vous dit ce ne sera pas plus intéressant à vous montrer mais c'est bien de le savoir et ce sera assez rapide quand même puisqu'il y a pas mal de choses que vous avez déjà manipulé et je vous avez dit qu'on n'y reviendrai par la suite.

Alors dans la vidéo précédente sur la programmation modulaire, je vous avais parlé des fameuses directives de préprocesseur puisque c'est le thème de cette vidéo-là.

Je vous avais dit que c'était celles qui débutait par le symbole dièse `#` donc là vous en avez un très bon exemple.

## include

```c
#include <stdio.h>

int main(void)
{

    return 0;
}
```

Un premier exemple qu'on connaît bien qui est le fameux dièse include `#include`, celui-là vous l'utilisez depuis le début de cette formation et je peux vous dire tout simplement, il permet d'inclure des fichiers.

Avant de rentrer un peu plus dans le détail, qu'est ce que le préprocesseur parce qu'on parle de directive, on parle de préprocesseurs ? Le préprocesseurs pour faire très très simple, c'est tout simplement un sous-programme qui va s'exécuter donc en tout premier d'accord il va s'exécuter avant tout de manière prioritaire, il va opérer des changements suivants des directives que vous lui donnez donc les directives c'est les fameux dièse quelque chose `#...` donc là par exemple `#include <stdio.h>` on va lui dire d'inclure un fichier mais on va y revenir après.

Il fait tout un tas de changements, un tas d'inclusions, tout un tas de paramétrage en fait et après seulement, on à l'étape de la compilation, celle qui va créer notre exécutable.

Alors si vous voulez plus de détails, un plus technique parce que là je vous ai pas parlé de quelque chose de très basique, si vous voulez le détail de tout ça, la formation c n'est pas faites pour ça d'accord je reste sur quelque chose d'assez basique, de sommaire pour tous ceux qui voudraient en savoir un peu plus et apprendre à programmer on va dire de manière plus avancés avec ce langage pourront sans problème s'orienter vers la formation hacking qui est disponible sur la chaîne.

Voilà sinon dans tous les cas pour le c, ce que je vais vous dire là est amplement suffisant.

Donc je reviens du coup sur mon fameux include donc include, vous l'avez compris, include permet d'inclure un fichier.

Vous  savez qu'en mettant des chevrons `<...>` on peut inclure un fichier d'en-tête notamment natif donc quelque chose qui est intégré au langage comme la le standard input output `stdio.h` donc tout ce qui est entrée, sortie standard du langage c qui nous permet d'utiliser les fonctions printf(), scanf(), plus tard de gérer des fichiers ce genre de choses, ect.

Sans ce fichier d'en-tête, on ne pourrait pas faire tout cela, ça ne marcherait pas.

Alors `stdio.h` ça c'est une directive que vous connaissez c'est à dire que quand on va nous lancer la compilation, avant donc le préprocesseur va se mettre en route, il va du coup inclure ce fameux fichier d'en-tête à notre programme qui nous permettra du coup d'utiliser les fameuses fonctions printf() et cetera parce qu'on ne les a pas définies nous-même, c'est des fonctions qui son propre langage et après il compile seulement.

Voyez ça se fait comme ça après.

La compilation se fait après l'étape **preprocessing** si on veut prendre le terme un peu anglais.

Donc ça c'est ce que vous connaissez, ce que vous avez déjà l'habitude d'utiliser donc je ne vais pas trop trop m'attarder dessus.

## define

On va découvrir une nouvelle directive qui est la directive `define`, celle-là elle va déjà être plus intéressante.

La directive define comme son nom l'indique va permettre de définir quelque chose et notamment une constante.

Par exemple, je pourrais très bien essayer de définir une constante TVA.

```txt
#include <stdio.h>

#define TVA

int main(void)
{

    return 0;
}
```

TVA défini comme ça, ça ne veut pas dire grand chose, ça veut simplement dire que j'ai créé une constante qui s'appelle TVA et c'est tout.

Donc ça permettrait éventuellement d'avoir plus ou moins des espaces en fait de noms au niveau d'un programme mais là ça a vraiment aucune utilité.

Voilà elle ne fait rien donc en général pour ce genre de constantes, on va lui associer une valeur.

Moi admettons que je veux parler de la tva à 20% et pour rester du coup sur des valeurs simples, je ne prends pas des valeurs avec des nombres à virgules et je prends que des valeurs entières mais on va dire 20.

```txt
#include <stdio.h>

#define TVA 20

int main(void)
{

    return 0;
}
```

Je ne vais pas mettre 20.0 mais on va mettre 20.

Ce qui permettrait admettons par la suite d'avoir un programme qui calculerait un prix toutes taxes comprises donc on aurait pu imaginer un prix hors taxes ici `int prixHT = 15;`. On aurait ensuite un prix ttc `int prixTTC = 0;` d'accord je met 0 et on ferra le calcul après et à un moment donné on cherchera à calculer notre prix ttc `prixTTC = prixHT + (prixHT * 20 / 100);`.

```txt
#include <stdio.h>

#define TVA 20

int main(void)
{
    int prixHT = 15;
    int prixTTC = 0;

    prixTTC = prixHT + (prixHT * 20 / 100);

    return 0;
}
```

Là le problème dans le code présent, c'est que si un jour la TVA je voulais la changer, il faudrait que je modifie tous les endroits où j'ai mis le fameux 20 pour les 20% par autre chose si admettons on était passé à 25, il faudrait tout changer.

Donc là je peux tout simplement utiliser ma fameuse constante que j'ai définie là `#define TVA 20` c'est-à-dire qu'au lieu d'utiliser la valeur, j'utilise le nom de la constante et cetera.

```txt
#include <stdio.h>

#define TVA 20

int main(void)
{
    int prixHT = 15;
    int prixTTC = 0;

    prixTTC = prixHT + (prixHT * TVA / 100);

    return 0;
}
```

Et en plus ça se lit bien `prixHT + (prixHT * TVA / 100)` pour la TVA et si un jour elle passe à 25, j'aurais juste à modifier la ligne du define et c'est tout. 

```txt
#include <stdio.h>

#define TVA 25

int main(void)
{
    int prixHT = 15;
    int prixTTC = 0;

    prixTTC = prixHT + (prixHT * TVA / 100);

    return 0;
}
```

Une seule modification et ça se répercutera sur l'ensemble du code donc voila à quoi ça peut servir.

On s'en servira quand on parlera des tableaux d'accord le define vous verrez à quoi il peut servir aussi.

Là j'ai prit cet exemple-là parce qu'il est très simple.

Je pense que tout le monde peut le comprendre, tout le monde sait calculer des prix toute TVA comprise, vous connaissez un petit peu.

Voilà donc ça c'est parlant pour tout le monde.

On va aborder autre chose, le define vous l'aviez vu notamment dans la séance précédente avec la programmation modulaire quand vous avez créé votre propre fichier d'en-tête .h donc j'en fait un rapidement ici.

+ bibli.h
```h
#ifndef __BILI__H__
#define __BILI__H__

#endif
```


Je vous avais montré ces fameuses lignes, alors on met des doubles underscores parce que les constantes au niveau du langage c commencent par deux underscores et terminent par deux underscores aussi.

C'est simplement une convention en fait ou simplement une habitude, on peut les marquer comme on veut.

J'aurais pu très bien l'appeler define *bib* ou *toto* ou *tructruc*, tout ce que vous voulez ça marche évidemment tant qu'ici ce sont les mêmes.

```txt
#ifndef __BILI__H__
#define __BILI__H__

#endif
```

Je vous avait dit que cela permettait de protéger votre bibliothèque pour ne pas inclure le fichier de manière infinie.

Admettons que vous ayez un fichier A qui veut inclure le fichier B et puis un fichier B qui veut inclure le fichier A vous allez avoir quelque chose qui va tourner en boucle parce que chaque fichier va vouloir inclure l'autre et il faudrait bien qu'il y en ai un qui commence avant l'autre.

Le problème c'est que là vous allez avoir une boucle infinie donc en faisant ça ça permet d'inclure les fichiers dans le bon ordre et surtout en tout cas de voir par exemple ici `#define __BIBLI__H__` s'il voit que le define là, il est déjà passé une fois la constante là va exister dans votre programme donc il saura qu'il n'a pas besoin à nouveau d'inclure ce fichier là parce qu'il l'aura déjà fait.

Ensuite si la constante est **not define** donc `#ifndef __BIBLI__H__` avec la constante ifndef du coup il la définie puis il inclut votre fichier.

**Si c'est non inclus, il inclus notre fichier**

Cela vous permet d'inclure vos fichiers d'en-têtes donc vos bibliothèques.

Alors ça c'est une habitude à prendre quand à chaque fois vous créer un
fichier .h vous mettez ces trois lignes dès le début ici.

```txt
#ifndef __BILI__H__
#define __BILI__H__

#endif
```

Alors je vous dis on peut même l'appeler BIBLI si vous voulez par rapport aux noms que vous avez ici, peu importe.

```txt
#ifndef BILI
#define BILI

#endif
```

Tant que le ifndef et le define sont les mêmes, c'est tout ce qui compte et après on peut avoir tout nos prototypes de fonctions et on peut imaginer plein de choses.

+ bibli.h
```h
#ifndef __BILI__H__
#define __BILI__H__

void bonjour(void);
int get_prix();

#endif
```

Plusieurs fonctions pourront comme ça être utilisées.

Alors define et ifndef est une directive qui permet de faire un test, en fait, un if() et de dire ben tiens si quelque chose n'est pas défini et le *ndif* c'est la fin du if donc rien de compliqué à ce niveau donc je ne vais pas non plus mattarder puisque c'est très très simple à l'utilisation et après les ifndef, les endif vous allez très rarement les utiliser autrement que pour ça et si ça vient à se présenter, eh bien on le fera en temps et en heure mais pour le moment ce n'est pas le sujet.


C'est tout ce qu'il y a retenir, c'est ces trois lignes là quand vous créez un fichier .h

Puis le fameux include que vous connaissez et le define qui permet comme ça d'avoir des valeurs constantes.

Alors le define est un petit peu plus puissant, on n'est pas forcément obligé de mettre une valeur, c'est simplement que le préprocesseur va dire que partout dans ton code où il y a marqué TVA, en fait, je le remplace par 25 c'est-à-dire qu'est-ce qu'il va faire hé bien cette ligne `#define TVA 25` va forcément disparaître puisqu'il va faire son boulot donc il va dire tiens TVA je le remplace par 25 donc il va faire ça.

```txt
prixTTC = prixHT + (prixHT * TVA / 100);
                              |
                              V
prixTTC = prixHT + (prixHT * 25 / 100);
```

Alors quand `#define TVA 25` aura fait son boulot donc il ne reviendra plus pour la compilation. **Alors le define ne sert pas pour la compilation mais il sert que pour l'étape préprocessing**.

Alors quand on écrit `#include <stdio.h>`, **il va inclure tout le code de stdio.h donc on aura tout le code qui serra inclut donc ça à la compilation ce ne serra évidemment pas prit en compte**.

C'est-à-dire qu'à la compilation c'est un peut ça qui va passer à la moulinette.

```txt
#include <stdio.h>

int main(void)
{
    int prixHT = 15;
    int prixTTC = 0;

    prixTTC = prixHT + (prixHT * 25 / 100);

    return 0;
}
```

Vous aurez globalement ça avec bien évidemment d'autres choses en plus mais encore une fois on reste très basique puisque le préprocesseur fait beaucoup beaucoup de choses en fait et des choses assez complexe mais tout ça je l'explique dans la formation hacking.

Là `prixHT + (prixHT * 25 / 100)` il fait tout le remplacement d'ailleurs vous voyez que ce sont des valeurs en dur `25` donc c'est simplement du remplacement, il ne faut pas imaginer qu'il y a des transformations qui sont faites à la compilation mais non c'est avant.

Le compilateur quand il va récupérer, il n'aura pas de constante TVA, elle n'existera pas pour le compilateur. Lui, il aura 25 ou il aura 20 ou il aura ce que vous avez défini dans le code source à la base, c'est là toute la différence donc ça c'est à savoir.

Du coup define peut remplacer tout un ensemble d'instructions, il peut remplacer en fait du code tout simplement.

On va prendre un exemple tout bête, c'est complètement inutile ce que je fais ici d'accord mais vous allez voir c'est histoire de bien comprendre voilà admettons que printf ne nous convient pas comme nom de fonction, on peut dire que afficher correspond à printf simplement.

```txt
#include <stdio.h>

#define afficher printf

int main(void)
{
    printf("Bonjour !\n");

    return 0;
}
```

Alors ça veut simplement dire que partout où il va voir le mot *afficher*, il va le remplacer par *printf* du coup là je peux faire ça `afficher("Bonjour !\n");`.

```c
#include <stdio.h>

#define afficher printf

int main(void)
{
    afficher("Bonjour !\n");

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Bonjour !
```

Automatiquement, je fait prog.exe et voyez que le bonjour fonctionne pourtant afficher n'est pas une fonction standard tout simplement parce qu'en fait le préprocesseur a vu cette directive `#define afficher printf` donc il a fait ça avec le code:

```txt
#include <stdio.h>

int main(void)
{
    printf("Bonjour !\n");

    return 0;
}
```

Le préprocesseur a virer cette directive `#define afficher printf` puisqu'il n'en a plus besoin et pour le compilateur, le compilateur s'est occupé également de voir le fichier d'en-tête bien évidemment `#include <stdio.h>` et du coup a retrouvé un code correct et le printf est bien connu du compilateur qui le connaît bien d'accord c'est vraiment une aide en fait au niveau développement.

C'est assez utile.

**Le compilateur ne lire pas de toute manière les define, tout ce qui est directive du préprocesseur ne seront pas lues de toute manière ce n'est pas pour lui. Le compilateur n'est pas un préprocesseur.**

Voilà c'est tout ce que je voulais vous dire alors on peut aller beaucoup plus loin, on peut carrément s'amuser à faire ça.

```c
#include <stdio.h>

#define Coucou printf("Coucou !\n")

int main(void)
{
    Coucou;

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Coucou !
```

Voilà c'est carrément inutile, je vous le dis tout de suite.

Je ne met pas de de point virgule dans le define à la fin parce que je préfère le mettre à l'appel pour respecter les instructions à point-virgules et voilà c'est la même chose.

C'est complètement ridicule, ça ne sert à rien dans ce cas mais c'est pour montrer que ça fonctionne, c'est des choses qui sont possibles donc des fois ça peut servir notamment quand on a des noms de fonctions qui sont très très longs.

Moi par exemple j'ai déjà programmé sur la playstation portable et on avait des noms pour afficher du texte tout simplement donc à l'écran, on avait une fonction pspDebugScreenPrintf() donc c'était super long et souvent on faisait ça.

```c
#define printf pspDebugScreenPrintf
```

Comme ça à chaque qu'on mettait printf, il le remplacait par le nom de la fonction en fait pour la playstation portable parce que le langage c a ses propres fonctions, ses propres bibliothèques, ses propres fichiers d'en-tête pour la console de jeux.

Voilà donc c'était des petites choses comme ça qui pouvait être intéressante, ça évitait de retaper tout le temps ça `pspDebugScreenPrintf` c'était quand même un petit peu long et voyez il y a pas mal de majuscules à chaque débur de mot donc ça pouvait prêter à pas mal d'erreurs en fait à la longue, après pas mal d'heures de développement.

Voilà pour le define.

Je vous avez parlé de constante avec define voilà ainsi ça pouvait être très utile.

On peut faire des calculs aussi, admetons ceci.

```c
#include <stdio.h>

#define LONGUEUR 15
#define LARGEUR 38
#define AIRE (LONGUEUR * LARGEUR)
```

D'accord on peut très bien faire ceci, ce qui fait que du coup quand vous ferez afficher la constante `AIRE` dans un printf() avec un %d puisque ce sont des entiers, il vous fera le calcul. C'est tout à fait possible puisqu'il va remplacer partout où il y a le truc *AIRE* par *(LONGUEUR * LARGEUR)* donc ça fonctionnera.

Voilà il faut vraiment comprendre ça, le define ne fait que du remplacement pour le préprocesseur d'une valeur en une autre tout simplement donc un contenu dans un autre, c'est juste ça.

Voilà pour le define.

## Constantes prédéfinies du langage c 

Comme je vous ai parlé de constantes, je voulais vous en montrer quelques unes intéressantes.

Je vais juste les présenter très rapidement parce que sinon ça va rallonger encore la vidéo inutilement et qu'en plus on n'en aura pas l'utilité tout de suite en pratique.

Je vais d'ailleurs les mettre ici en notes.

```c
/*
    Constantes prédéfinies du langage c :
        __FILE__    (nom du fichier)
        __LINE__    (ligne du fichier)
        __DATE__    (date de compilation)
        __TIME__    (heure de compilation)
*/
```

Alors vous avez notamment la constante précédée d'un double underscore, c'est pour ça que j'avais dit que c'est un peu une norme, qui est `__FILE__` donc pas besoin de vous dire que c'est le nom du fichier source d'accord.

On a `__LINE__` qui est est la ligne du fichier par laquelle bien sûr où vous êtes en train de d'afficher la constante, logique.

On va avoir `__DATE__` qui est la date de compilation et on va voir le fameux `__TIME__` qui est l'heures de compilation.

ALors, je vais juste mettre un seul exemple, on peut par exemple faire ceci.

```c
#include <stdio.h>

/*
    Constantes prédéfinies du langage C :
        __FILE__    (nom du fichier)
        __LINE__    (ligne du fichier)
        __DATE__    (date de compilation)
        __TIME__    (heure de compilation)
*/

int main(void)
{
    printf("Nom du fichier : %s\n", __FILE__);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Nom du fichier : main.c
```

Voilà `__FILE__` est une constante donc on l'affiche bêtement comme ceci hop.

C'est comme une variable en fait.

Voilà il me dit bien que mon fichier s'appelle *main.c*.

Alors je ne vais pas faire le test pour tous, alors ça peut servir pour du débogage, ce genre de choses notamment, repérer un bug dans des fonctions
de test et voilà, vous voyez comment ça fonctionne c'est très simple et je vous les noté au cas où si vous avez besoin de prendre des notes pour récupérer ça.

Alors c'est bon, il fallait vous parlez du `include` c'était le plus important parce que vous l'utilisiez depuis le début.

Il y avait le fameux `define`, vous avez vous qu'on pouvais le remplacer par des valeurs, remplacer carrément par une fonction, par des calculs et il fallait connaître le fameux `ifndef`, `define` `endif` par rapport au fichier.

Voilà donc on a fait le tour, je ne vais pas vous retenir plus longtemps entre guillemets, et tout ce qu'il avait avant en tout cas au niveau des directives du préprocesseur donc s'il faut vous résumer tout ça, vous le savez.

Vous avez de quoi inclure des fichiers, soit des fichiers natifs soit vos propres bibliothèque.

Vous avez de quoi définir des constantes parce que ça sert en général à ça et vous pouvez protéger notamment, éviter les inclusions infinies ou les problèmes d'inclusions quand vous créez des bibliothèques avec ces trois petites directives.

```h
#ifndef BIBLI
#define BIBLI

void bonjour(void);
int get_prix();

#endif
```

Voilà vous mettez tout vos prototypes entre, et comme ça il n'y aura pas de problèmes et cela va clore du coup notre petite séance 10 pour se retrouver la prochaine fois pour la séance 11 donc on parlera évidemment des pointeurs qui est d'une notion les plus importante, si ce n'est la plus importante du langage.

Alors j'espère que ce sera compréhensible pour vous parce que la plupart du temps elle est très très mal comprise des gens qui l'apprennent.

Alors peut-être mal expliquée ou peut-être que malgré les bonnes explications, elle peut-être compliquée à assimiler, je n''en sais rien.

Moi j'essaierai d'être clair alors ce serait une video assez longue parce qu'il y a beaucoup de choses à raconter et que c'est mieux de prendre le temps pour que ce soit compris plutôt que de bazarder ça en 10 minutes et puis que du coup vous galérez derrière donc la vidéo serra un peu longue mais vous allez apprendre pas mal de choses et vous verrez que les pointeurs font toute la puissance du langage c, voilà voilà.

A très bientôt tout le monde et puis n'hésitez pas à vous entraîner, à poser des questions si vous n'avez pas bien compris.

Normalement cette vidéo est assez simple avec pas mal de théorie mais assez simple en tout cas par rapport à ce qui vous attend pour la suite.

Allez à bientôt