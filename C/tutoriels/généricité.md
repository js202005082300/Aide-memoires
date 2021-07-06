# [Généricité](https://www.youtube.com/watch?v=v19K2jHXsQk)

+ [Pointeur générique](#Pointeur-générique)
+ [Pointeur de fonction](#Pointeur-de-fonction)
+ [Exemple de fonction qui retourne un pointeur de fonction](#Exemple-de-fonction-qui-retourne-un-pointeur-de-fonction)

Bonjour à tous et bienvenue pour un nouveau tutoriel en langage c. 

Aujourd'hui je vais vous parler d'une notion appelle plus complexe que celles que vous avez eu l'habitude d'aborder dans son langage et notamment dans les vidéos que je vous ai proposées.

Pour commencer j'aimerais bien vous dire que ce n'est pas une notion qui est indispensable dans le sens ou vous pouvez sans problème programmer dans le langage c, sans connaître cette notion que nous allons aborder qui est la généricité.

Alors la généricité c'est un terme un peu global tout simplement pour désigner la possibilité de manipuler des données de tout type.

Vous savez quand c comme on a pu le voir dans d'autres vidéos par exemple depuis les variables, depuis les structures et les fonctions, nous avons toujours manipulé des données d'un certain type.

Je vous avais dit que le langage était typé c'est à dire que quand on va créer une variable on lui donne tout simplement un type, ça peut être un entier, ça peut être un char, ça peut être un float, ça peut être un double, ça peut être également être une structure que vous allez vous même créer comme la structure de piles que nous avons pu voir dans les vidéos sur les structures de données.

Bref c'est toujours un type qui est toujours explicite et qui est renseigné au niveau de la donnée donc on peut pas faire n'importe quoi.

Pour cette vidéo par rapport à ce qui est important avant de l'aborder, il faut bien avoir en vue la vidéo sur les pointeurs parce qu'on va en parler évidemment, c'est parfaitement le sujet de cette vidéo donc il faut maîtriser les pointeurs.

Si ce n'est pas encore clair pour vous, et que vous ne les avez encore jamais vu, n'hésitez pas à aller voir la séance à ce sujet avant d'aborder cette vidéo qui va faire usage des pointeurs et pour aller un petit peu plus loin justement sur son utilisation.

Alors là généricité pour rester sur le sujet par rapport à ce que je vais vous dire, c'est une manière de pouvoir manipuler des données dont on ne sait pas encore quel type nous allons avoir donc pour tous types possibles.

Rappelez vous que quand je parle de types de données ça peut être un type de variable ou ça peut être un type défini par une structure voilà ça c'est important à savoir.

Pour cela on va retrouver quelque chose, alors d'abord vous allez pouvoir créer un pointeur qui servira à pointer sur un entier en faisant par exemple `int *pointeurSurEntier = NULL;` que l'on peut même déclarer et initialiser à nul et après on peut l'utiliser en mettant dedans l'adresse d'une autre variable.

```txt
#include <stdio.h>

int main(void)
{
    int *pointeurSurEntier = NULL;

    return 0;
}
```

Alors on pourra utiliser ce pointeur en mettant dedans, en stockant l'adresse d'une autre variable par exemple lorsqu'on faisait `int nombre = 5 ;` et il suffisait du coup de faire `pointeurSurEntier = &nombre;` donc avec l'adresse du nombre, et on pouvait tout simplement l'afficher de cette manière en mettant la petite étoile `printf("%d\n", *pointeurSurEntier);` pour indiquer la valeur de la variable qui est pointé ici par mon programme.

```c
#include <stdio.h>

int main(void)
{
    int *pointeurSurEntier = NULL;
    int nombre = 5 ;

    pointeurSurEntier = &nombre;

    printf("%d\n", *pointeurSurEntier);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
5
```

Alors ça normalement ce sont des choses que vous savez faire.

Si déjà là pour vous ce n'est pas clair ou que déjà là vous êtes largué, c'est qu'il y a encore des choses que vous n'avez pas compris sur cette notion de pointeur donc n'hésitez pas à revoir la vidéo là-dessus avant de continuer un petit peu plus loin.

## Pointeur générique

Au niveau de cette généricité, on va faire intervenir un nouveau type de pointeur même si ce n'est pas forcément exact qui est ce qu'on appelle un pointeur générique c'est pour ça qu'on parle de généricité, et pour cela on va tout simplement utiliser la notation `void *`.

```txt
#include <stdio.h>

int main(void)
{
    void *

    return 0;
}
```

Alors ça n'a absolument rien à voir avec le type void, void d'ailleurs ça veut tout simplement dire que nous n'avons rien.

Quand le type de retour d'une fonction est void, ça veut dire qu'elle va retourner absolument rien ainsi c'est un indicatif pour dire qu'il n'y a absolument rien à retourner.

Si on a dans les paramètres un void comme pour la fonction main() ça veut dire qu'elle ne prend aucun paramètre. Ensuite je rappelle que pour respecter les normes et respecter les standards, on n'avait pas la fonction main() comme ceci `int main()` ça c’est en c++ que vous pouvez le faire et dans d'anciennes normes mais pour être vraiment rigoureux on n'oublie pas de mettre le void ìnt main(void)` pour indiquer spécifiquement que nous ne prenons aucun paramètre étant donné que vous savez dans un autre tutoriel qu'on a fait sur la chaîne que vous pouvez utiliser des arguments donc des paramètres pour la fonction main() lors de l'exécution de notre programme.

Pour ceux que ça intéresse c'est dans les tutoriels de la chaîne dans la même playlist.

Alors je reviens du coup sur les pointeurs génériques, cette vidéo va être un petit peu longue d'accord parce que c'est une notion qui est assez complexe, il y a beaucoup de choses et je ne vais d'ailleurs pas vous parler de tout.

Si ça vous intéresse vous pouvez aller faire des recherches pour trouver les documentations officielles qui en parlent sur les références, les manuels et cetera.

Voilà on pourrait en parler pendant des heures et des heures mais vous savez forcément que je n'aime pas faire 15000 vidéos sur la même chose mais je préfère faire une vidéo avec une notion expliqué dedans quitte à ce que la vidéo soit un petit peu plus longue.

Vous pouvez de toute manière mettre sur pause et gérer les vidéos que vous visionnez de la manière que vous voulez et ça permet comme ça d'être beaucoup plus clair dans les explications pour ne pas couper les choses c'est surtout pour vous d'avoir une vidéo avec une seule notion.

C'est plus facile après pour s'y retrouver, pour revoir les vidéos et cetera.

Alors ce printemps générique on voit simplement le déclarer avec ce fameux type, même si c'est pas forcément un type, le fameux `void *` donc ça va être un moyen en tout cas de l'indiquer.

Alors si c'est un `void` tout court, ce n'est pas possible, on veut vraiment `void *` et enfin du coup créé pareil le nom de notre pointeur générique et on va l’initialisé à null comme on a fait tout à l'heure.

```txt
#include <stdio.h>

int main(void)
{
    void *pointeurGenerique = NULL;

    return 0;
}
```

Voilà là nous avons déclaré et initialisé un pointeur générique.

C'est la seule différence `void*`.

Je rappelle rapidement, l'étoile vous pouvez faire comme ça `void *pointeurGenerique`, `void * pointeurGenerique`, `void* pointeurGenerique` voilà vous pouvez également la coller au type.

Alors ça ça dépend des gens qui ont parfois des notations différentes, moi en général je l'ai collé au nom du pointeur même si des fois ça peut être collé au type mais le plus souvent j'utilise cette notation là `void *pointeurGenerique`.

En tout cas essayez d'utiliser toujours la même notation au sein d'un même programme tel qu'on a pu le répéter dans certaines vidéo histoire de garder un code cohérent, et ne pas avoir de mélange de syntaxe et ou de convention de codage.

Donc on a notre pointeur générique, on va du coup avoir notre variable `int nombre = 5 ;` voilà on fait comme tout à l'heure on prend un nombre et là vous voyez que c'est un entier. D'ailleurs je peux également en créer un autre nombre double `double autreNombre = 3.14 ;`.

```txt
#include <stdio.h>

int main(void)
{
    void *pointeurGenerique = NULL;
    int nombre = 5;
    double autreNombre = 3.14;

    return 0;
}
```

Voilà on a ce genre de chose.

Comment est ce que je vais du coup affecter ma variable à ce pointeur générique? Alors on va faire comme on a fait jusqu à présent donc je vais tout simplement faire mon pointeur générique auquel je vais spécifier l'adresse de la variable que je veux `pointeurGenerique = &nombre;` voilà.

```txt
#include <stdio.h>

int main(void)
{
    void *pointeurGenerique = NULL;
    int nombre = 5;
    double autreNombre = 3.14;

    pointeurGenerique = &nombre;

    return 0;
}
```

Et ici pointeurGenerique devient un pointeur qui pointe sur une variable entière donc de type int.

À partir de là je peux faire un petit printf() comme ceci.

```c
#include <stdio.h>

int main(void)
{
    void *pointeurGenerique = NULL;
    int nombre = 5;
    double autreNombre = 3.14;

    pointeurGenerique = &nombre;

    printf("%d\n", *pointeurGenerique);

    return 0;
}
```
```powershell
gcc main.c -o prog
main.c: In function 'main':
main.c:11:20: warning: dereferencing 'void *' pointer
   11 |     printf("%d\n", *pointeurGenerique);
      |                    ^~~~~~~~~~~~~~~~~~
main.c:11:20: error: invalid use of void expression
```

OK alors là on voit qu'il y a une erreur, ici on voit qu'il y a une différence parce que normalement on affiche un pointeur standard de cette manière en mettant l’étoile mais là on voit qu'il y a un petit problème.

Alors ça c'est une différence c'est à dire qu'il y a une distinction avec un simple pointeur.

Alors pour le pointeur générique et Notez bien ici qu'il ne va pas respecter la syntaxe qu'on appelle l'**arithmétique des pointeurs standard** ainsi quand on met une étoile `*pointeurGenerique` on dit qu'on *déférence* le pointeur.

C'est le terme utilisé c'est à dire que si vous recherchez *déférencement de pointeur* c'est comme ça qu'on fait.

`printf("%d\n", *pointeurGenerique);` Ici on déréférence le pointeur pour pouvoir du coup afficher la valeur de la variable pointée mais ici comme nous avons un pointeur générique c'est un petit peu différent, on ne peut pas, il est impossible de déréférencer un pointeur générique.

Alors on peut se demander pourquoi ? Parce que il est vrai que il est quand même pratique de pouvoir faire ça pour afficher la valeur mais tout simplement parce qu'un pointeur générique comme je vous rappelle, **un pointeur généré il va pouvoir pointer sur n'importe quel type de donnée**.

Alors si vous vous souvenez du tableau sur la vidéo au sujet des variables, je vous avais montré un espèce de tableau ou je vous avais montré un petit peu la taille en mémoire qu'occupe chacune des variables selon le type qu'elle va avoir : un entier, c’est 4 ou 8 octets, puis d’autres c'est 2 ou 4 octets donc voilà selon les types de variables vous allez avoir un octet, 4, 8 et cetera qui vont occuper en mémoire.

![types_variables.png](schémas/types_variables.png)

Alors là c'est facile, quand je crée cette variable ici `int nombre = 5 ;` le programme va pouvoir demander au système d'exploitation de réserver tout à fait la taille d'un entier sur mon PC. Automatiquement mon PC sait ce que ça vaut donc quand on va manipuler un nombre on sera ce qu'on manipule.

Quand on fait un pointeur sur un entier donc un pointeur de type `int *`, c'est facile également il va réserver exactement le même emplacement enfin il va réserver un octet voilà les pointeurs prennent moins de place en mémoire mais il va pouvoir pointer sur une donnée qui fait la taille d'un entier donc c'est également facile à maîtriser.

`void *pointeurGenerique` Ici mon pointeur générique pourrait stocker n'importe quel type de données et c'est bien là le problème car quand c'est un entier ça fait une certaine taille et quand c'est un double, ça fait une autre taille. Si admettons c'est une structure de personnage de jeu vidéo, ça va encore être une autre taille donc en bref il est impossible au système de deviner la taille, l'espace occupé par la donnée que nous stockons dans notre pointeur générique.

Du coup nous ne pouvons pas faire de déférencement de cette manière `*pointeurGenerique`.

Alors si on essaie de faire sans l'étoile, est ce que j'obtiens quelque chose de mieux ?

```c
#include <stdio.h>

int main(void)
{
    void *pointeurGenerique = NULL;
    int nombre = 5;
    double autreNombre = 3.14;

    pointeurGenerique = &nombre;

    printf("%d\n", pointeurGenerique);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
-1281361188
```

Voyez là on obtient une valeur bizarre puisque effectivement nous avons une adresse.

On peut d'ailleurs remplacer le `%d` par un `%p`.

```c
#include <stdio.h>

int main(void)
{
    void *pointeurGenerique = NULL;
    int nombre = 5;
    double autreNombre = 3.14;

    pointeurGenerique = &nombre;

    printf("%p\n", pointeurGenerique);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
0000007f089ff83c
```

Voilà on a une adresse hexadécimale donc on peut évidemment avoir l'adresse de pointer pas de souci par contre on ne va pas pouvoir afficher comme ça la valeur que l'on veut d'accord on ne pourra pas faire de déférencement au niveau de notre pointeur.

En tout cas à quoi servent ces pointeurs génériques, quel intérêt parce que au final on ne fait pas grand-chose ? alors vous vous doutez bien pour ce que je viens de faire ici on va plutôt utiliser un pointeur standard car ça n'a aucun intérêt mais pourtant on pourrait s'amuser à dire par exemple que `pointeurGenerique = &autreNombre;` ainsi notre pointeur générique pointerait sur l'autre nombre mais comme vous pouvez le constater ce n'est pas le même type.

Voilà au début on avait un entier maintenant on passe à un double.

```txt
#include <stdio.h>

int main(void)
{
    void *pointeurGenerique = NULL;
    int nombre = 5;
    double autreNombre = 3.14;

    pointeurGenerique = &nombre;
    printf("%p\n", pointeurGenerique);

    pointeurGenerique = &autreNombre;
    printf("%p\n", pointeurGenerique);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
0000004f595ff904
0000004f595ff8f8
```

Voyez l'adresse a changé donc automatiquement le pointeur a pu s'adapter à la nouvelle donné qu'il a stockée, on lui dit que cette fois-ci tu vas pointer sur un double, une variable de type de double, qui prend pas du tout le même espace en mémoire donc beaucoup plus d'espace qu’un simple entier et ça ne lui a pas posé de problème puisque il est de type `void *` il va accepter de manière générique, d'où le terme de généricité, la nouvelle donnée.

Voilà ça c'est la base.

Ce que je vous ai montré là avec le pointeur générique ça n'a absolument aucune utilité, honnêtement ça ne va pas vous servir à grand-chose mais en tout cas ça n'a pas vraiment d'intérêt de l'utiliser comme ça mais on va s'en servir justement dans d'autres cas d'utilisation.

Alors ce pointeur généré comme il peut pointer un petit peu sur n'importe quoi, vous savez peut être que **les fonctions comme tout dans un programme en c possède une signature c'est à dire qu'elle possède une adresse car elles sont forcément stockées en mémoire quelque part**.

Et bien les fonctions c'est la même chose, une fonction elle va avoir une adresse en mémoire puisqu'il faut bien qu à un moment donné le programme puisse l'appeler et comme il peut y avoir des fonctions style main(), calculer() et cetera pour lui ça ne veut rien dire car il ne connaît pas du tout les noms dans votre langue car il ne manipule que des adresses.

Même pour les adresses quand on créé une variable qui s'appelle `int nombre = 5;` nombre sera remplacé par l'adresse en mémoire donc pour lui il ne manipule que des adresses.

Pour les fonctions c'est la même chose, il n'y a pas d'exception, une fonction a une adresse et d'ailleurs quand on met un nom de fonction, on peut le remplacer par son adresse, et **le pointeur générique va servir à ça c'est-à-dire qu'il va permettre de produire des pointeurs de fonction**, et c'est là tout l'intérêt de cette vidéo.

Alors on va rentrer dans le vif du sujet maintenant.

Qu'est-ce qu'un pointeur de fonction ? c'est tout simplement un pointeur qui va stocker l'adresse d'une fonction, c'est vraiment aussi simple que ça. Il va également servir pour remplacer les structures conditionnelles par exemple si on a un if(), si on a des switch() et cetera ainsi plutôt que de faire tout un tas de conditions imbriquées puis de faire quelque chose en suivant, on va pouvoir également utiliser un pointeur de fonction.

Vous verrez comment il y a moyen de raccourcir comme ça du code, pas forcément de le rendre plus simple car ça va le complexifier au contraire mais ça va rentre le code beaucoup plus pratique.

Alors on peut également s'en servir pour faire des fonctions de rappel mais moi je ne m'attarderais pas trop dessus c'est ce qu'on appelle en général des fonctions de callback qu'on retrouvera aussi dans pas mal d'autres vidéos que l'on fera notamment quand on fera de la programmation sur console portable, vous verrez qu'on aura des fonctions callback à ce moment-là donc on aura l'occasion d'en reparler et en plus ce sera en langage c.

On aura tout le loisir de voir tout ça.

Alors dans cette vidéo je ne peux pas parler de tout, on parlera exclusivement de ce qui nous semble plus essentiel, le plus important à savoir mais après on pourra voir encore tout un tas de choses notamment sur les variables statiques, les fonctions membres, il y a plein plein de termes tout autour de cette notion de générosité mais moi je vais montrer justement l'essentiel.

## Pointeur de fonction

> *Test d'une fonction utilisant un pointeur de fonction pour remplacer tout un tas de conditions.*

Alors nous allons commencer par voir comment fonctionne notre pointeur de fonction, alors comment déjà va se définir un pointeur de fonction ?

Un pointeur de fonction va se définir de la manière suivante, c'est comme tout à l'heure lorsque nous avons fait un pointeur générique sauf que nous devons lui spécifier un type de retour et des types de paramètres.

En fait il va falloir lui appliquer la même signature qu’une fonction que l'on a fait tout en mettant le nom du pointeur.

Alors jusqu'ici c'est pas forcément clair mais on va regarder ça après.

On va d'abord faire ceci, on prépare quelques fonctions.

```c
#include <stdio.h>

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

int main(void)
{
    return 0;
}
```

Voilà nous avons nos 2 fonctions addition et soustraction plus la fonction main. Alors pour le moment je m'amuse pas forcément à faire des fonctions avec des types et des paramètres différents mais c'est pour vous montrer que les exemples que je vous montre sont assez simple.

Voyons maintenant comment nous allons déclarer notre pointeur de fonction.

Mon pointeur je vais devoir l'utiliser sur des fonctions qui sont de type `int` donc des fonctions qui ont en plus 2 paramètres `int` et un type de retour `int` voilà donc je vais écrire mon pointeur exactement de la même manière.

Je commence par mettre un `int` pour le type de retour ensuite on commence par ouvrir des parenthèses avec une étoile `int (*)` si vous vous souvenez des vidéos précédentes notamment sur les variables, l'étoile est un opérateur qui n'a pas une grosse priorité donc il faut mettre des parenthèses pour lui donner plus de priorité pourquoi il les considère vraiment comme un pointeur et qu'il n'en fasse pas une multiplication par exemple ou je ne sais quoi donc pour vraiment montrer qu'il s'agit d'un pointeur et lui donner la priorité on met des parenthèses. 

À partir de là on va lui choisir un nom `int (*pointeurFonction)` pour rester sur un nom suffisamment clair, et après on ouvre directement les parenthèses pour lui mettre un paramètre et comme vous l'avez vu avant on a un entier et un autre entier donc ceci `int (*pointeurFonction)(int, int);` et on n'oublie pas le ;

```c
#include <stdio.h>

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

int main(void)
{
    int (*pointeurFonction)(int, int);
    
    return 0;
}
```

Alors là on vient d'utiliser cette syntaxe qui permet de déclarer un pointeur de fonction  `int (*pointeurFonction)(int, int);`.

On vient de déclarer un pointeur de fonction c'est à dire que c'est un pointeur qui peut pointer une fonction qui prend 2 entiers en paramètre et qui retourne un entier également.

Alors oui c'est un pointeur juste pour ça alors ce pointeur `int (*pointeurFonction)(int, int);` ne peut pas être utilisé sur une fonction qui aurait un char ou en double ou ce genre de chose, il faut vraiment un pointeur sur une fonction par rapport au schéma qu'on a ici.

Très simple au niveau de syntaxe, vous avez compris que c'est vraiment la même chose, on peut presque faire un copier coller avec nos prototypes de fonction.

```txt
int addition(int nb1, int nb2);
int soustraction(int nb1, int nb2);

int (*pointeurFonction)(int, int);
```

Voilà on pourrait presque copier coller nos paramètres `(int, int)` mais des noms de variables on n'en met pas et on met bien entre parenthèses le nom du pointeur avec les étoiles, ça c'est super important.

Mettez des noms explicites sur votre pointeur et sur vos variables toujours des noms explicites, pas de nom tel que `a`, `b`, `c` qui ne veulent rien dire et vous allez en plus vous compliquer les choses donc mettez des noms explicites quitte à ce que ce soit aussi simple que ça `*pointeurFonction` et au moins vous serez ce que vous faites en même temps.

Là on va définir notre pointeur de fonction tout simplement, de cette manière on va pouvoir faire pas mal de petites choses avec.

Alors je vais vous montrer un exemple, si par exemple on faisait une espèce de petite calculatrice, on pourrait faire la demande à l'utilisateur pour savoir quel calcul il a envie de faire admettons par exemple s'il fait 1 ça fera l'addition, puis s'il tape 2 ça ferait la soustraction et cetera.

Donc on ferai un espèce de if() d'accord un ensemble de conditions voir un switch() quand on a plusieurs conditions pour pouvoir gérer en fait le choix qui a été fait sur le menu.

Alors ça ce serait une possibilité.

```c
#include <stdio.h>

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

int main(void)
{
    int (*pointeurFonction)(int, int);
    int a = 14;
    int b = 28;

    if(choix == 1)
        addition(a, b);
    else if(choix == 2)
        soustraction(a, b);
    
    return 0;
}
```

Voilà on peut avoir un enfant comme ça d'imbrications, un switch et cetera bref on pourrait avoir comme ça un code à rallonge assez répétitif d'ailleurs sur beaucoup de choses.

Pourtant vous voyez que au final les fonctions sont un petit peu fait de la même manière c'est-à-dire avec les mêmes types de paramètres et le même titre de retour.

Donc nous plutôt que s'amuser à se retaper tout ça

```txt
if(choix == 1)
    addition(a, b);
else if(choix == 2)
    soustraction(a, b);
```

Au final on va passer par notre petit pointeur de fonction `int (*pointeurFonction)(int, int) ;` et comment allons-nous faire ça ? nous allons faire ça d'une manière très très simple.

On peut mais en général je passe éventuellement par une fonction en plus par exemple ça peut être `int calculer(int nombre1, int nombre2)` voilà alors que va prendre cette fonction en paramètre,  elle va tout simplement prendre nos deux nombres donc ça pas de surprise. Alors elle va prendre un 3e paramètre ça c'est la petite surprise parce que ça va être en fait notre pointeur générique donc c'est là la petite nouveauté c'est le pointeur générique que nous allons utiliser pour ça donc du coup on va reprendre exactement notre syntaxe `int (*pointeurFonction)(int, int);` pour la mettre en paramètre.

```c
#include <stdio.h>

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

int calculer(int nombre1, int nombre2, int (*pointeurFonction)(int, int))
{

}

int main(void)
{
    int (*pointeurFonction)(int, int);
    int a = 14;
    int b = 28;

    
    return 0;
}
```

Okay donc nous reprenons directement cette syntaxe que nous mettons là ce qui perturbe un peu parce qu'il y a des parenthèses dans des parenthèses et cetera donc du coup ça va assez compliquer les choses donc c'est pour ça que je vous dis que vidéo sera un petit peu longue mais ce n'est pas grave parce qu'il faut prendre le temps d'expliquer les choses surtout concept assez complexe.

On n'est pas là pour se presser l'informatique ça prend du temps à s’apprendre, pour bien comprendre les choses donc moi ça ne me gêne pas s'il faut prendre du temps pour vous expliquer tout ça et puis plus tard répondre à vos commentaires.

Voilà du coup on a défini notre petit pointeur de fonction `int (*pointeurFonction)(int, int))` et dans cette petite fonction calculer(), on va faire tout simplement `pointeurFonction(nombre1, nombre2)` c'est à dire de nombre1 et de nombre2 voilà tout simplement.

```c
#include <stdio.h>

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

int calculer(int nombre1, int nombre2, int (*pointeurFonction)(int, int))
{
    pointeurFonction(nombre1, nombre2);
}

int main(void)
{
    int (*pointeurFonction)(int, int);
    int a = 14;
    int b = 28;

    
    return 0;
}
```

Alors ça c'est une possibilité mais quel est la différence du coup ? L'avantage ici c'est que vous allez pouvoir gérer très facilement le type de calcul à faire puisque au niveau de l'appel de notre fonction, vous n'allez plus devoir faire à chaque fois addition(), soustraction() et cetera mais vous allez pouvoir faire tout simplement pouvoir faire ce genre de choses.

```c
#include <stdio.h>

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

int calculer(int nombre1, int nombre2, int (*pointeurFonction)(int, int))
{
    pointeurFonction(nombre1, nombre2);
}

int main(void)
{
    int (*pointeurFonction)(int, int);
    int a = 14;
    int b = 28;

    int res = calculer(a, b, &addition);
    printf("%d\n", res);

    
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
42
```

Alors on peut enlever `int (*pointeurFonction)(int, int);` et bien sûr on récupère le résultat dans une variable.

Comme ne 3e paramètre, c'est un pointeur de fonction donc un pointeur de fonction qui peut prendre une fonction avec deux paramètres int et un retour int donc ça tombe j'en ai eu deux aux choix : addition(), soustraction() donc si je fait une soustraction je n'ai qu'à passer l'adresse de l'addition `calculer(a, b, &addition);` tout simplement.

Voilà c'est vraiment aussi simple que ça donc comme raccourci et normalement les choses du coup parce qu'on va passer comme ça par un pointeur de fonction qui est de toute façon d'une certaine manière un peu générique pour pouvoir réaliser nos calculs.

Voyez comme obtient bien 42 (14+28).

Ceci étant fait nous avons du coup un programme utilisant un pointeur de fonction qui j'ai envie de dire fonctionne.

Alors ici l'exemple n'est pas forcément très parlant donc on pourrait se demander à quoi sert ces pointeurs de fonction.

Je vous dis que au début c'est assez complexe à assimiler et à comprendre l'utilité et si vous ne voyez pas à quoi ça sert c'est que vous n'en aurez probablement pas besoin tout de suite.

Peut être que vous ne l'utiliserai peut être jamais au cours de vos projets donc il ne faut pas vous en faire ce n'est pas un souci.

*Alors voilà ça c'était un exemple tout simple comme on a pu le montrer en remplaçant ici tout un tas de conditions en passant ici par une petite fonction qui va du coup utiliser un pointeur de fonction donc c'est très pratique dans ce cas là.*

Alors là je suis passé par une fonction intermédiaire mais je n'étais pas obligé.

Honnêtement j'aurais pu faire autrement mais là comme je voulais utiliser ce petit pointeur de fonction `int (*pointeurFonction)(int, int)` mais bon je me suis dit que c'était pas mal de procéder de cette manière là.

Ça c'était une chose mais vous avez vu maintenant comment définir, comment on crée notre petit pointeur de fonction, on a vu également comment on pouvait l'utiliser ici ce qui est plutôt pratique pour pouvoir remplacer des conditions.

D'ailleurs si j'avais fait un switch() ça aurait été pareil, on aurait pu le remplacer exactement de la même manière.

Alors nous allons voir comment fonctionne tout ça.

Alors je reviens sur la définition des pointeurs de fonction qu'il faut obligatoirement que toutes les fonctions et ça je pense que vous l'avez compris qu'on veut utiliser ici en paramètre de la fonction calculer() doivent avoir la même signature que notre 3e paramètre `int (*pointeurFonction)(int, int)` c'est-à-dire 2 paramètres int et une valeur de retour int.

Si vous avez encore une fois du double ça ne pourra pas être utilisé.

Admettons une fonction `double multiplication(double nb1, double nb2)`.

Voilà admettons qu'on ait ce genre de fonction bien sûr ça ne fonctionnera pas.

```c
#include <stdio.h>

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

double multiplication(double nb1, double nb2)
{
    return nb1 * nb2;
}

int calculer(int nombre1, int nombre2, int (*pointeurFonction)(int, int))
{
    pointeurFonction(nombre1, nombre2);
}

int main(void)
{
    int (*pointeurFonction)(int, int);
    int a = 14;
    int b = 28;

    int res = calculer(a, b, &multiplication);
    printf("%d\n", res);

    
    return 0;
}
```
```powershell
gcc main.c -o prog
main.c: In function 'main':
main.c:29:30: warning: passing argument 3 of 'calculer' from incompatible pointer type [-Wincompatible-pointer-types]
   29 |     int res = calculer(a, b, &multiplication);
      |                              ^~~~~~~~~~~~~~~
      |                              |
      |                              double (*)(double,  double)
main.c:18:46: note: expected 'int (*)(int,  int)' but argument is of type 'double (*)(double,  double)'
   18 | int calculer(int nombre1, int nombre2, int (*pointeurFonction)(int, int))
      |                                        ~~~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~
```

Alors ça ne marche évidemment pas d'ailleurs le compilateur est déjà suffisamment explicite elle vous montre que les arguments attendus ne sont pas les bons donc au lieu de proposer 2 doubles en paramètre, on a 2 ints donc voilà il attend des entiers par rapport à ce qu'on a défini là.

Alors ça c'est la règle au niveau de la définition d'un pointeur de fonction, il faut que les fonctions que vous utilisiez aient exactement les mêmes types de paramètres et le même type de retour En bref la même signature, la signature de la fonction tout simplement.

Voilà déjà une chose à retenir.

Alors chose que je ne vous ai pas dit tout à l'heure c'est qu'il y a plusieurs syntaxes, alors j'ai utilisé mon pointeur de fonction d'une certaine manière ici `int calculer(int nombre1, int nombre2, int (*pointeurFonction)(int, int)` mais on peut directement assigner une fonction à un pointeur de fonction, ce qui est logique comme par exemple ce que l'on faisait avant ici.

```c
int main(void)
{
    int *ptr = NULL;
    int a = 15;
    ptr = &a;

    return 0;
}
```

on crée un pointeur `ptr` pour pointer vers la variable `a`, eh bien on va pouvoir faire la même chose pour les fonctions.

Voilà on peut faire exactement la même chose pour les fonctions c'est à dire que je crée mon petit pointeur de tout à l'heure `int (*pointeurFonction)(int, int);` voilà la même syntaxe que tout à l'heure et après mon petit pointeur de fonction `pointeurFonction = addition;` auquel j’assigne directement une fonction et je dis par exemple que tu stock dedans addition.

```c
#include <stdio.h>

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

double multiplication(double nb1, double nb2)
{
    return nb1 * nb2;
}

int calculer(int nombre1, int nombre2, int (*pointeurFonction)(int, int))
{
    pointeurFonction(nombre1, nombre2);
}

int main(void)
{
    int (*pointeurFonction)(int, int);
    
    pointeurFonction = addition;//ou &addition
    
    return 0;
}
```

Voilà on stock addition dans notre pointeur de fonction mais on aurait pu aussi stocker l'addition sous cette forme là `&addition`. On utilise ainsi le commercial mais il n'est pas obligatoire, ça fonctionne parce que par défaut au niveau de la syntaxe du code quand vous marquez `addition` nous avons déjà l'adresse de la fonction, c'est comme ça que ça fonctionne.

`&addition` ça c'est bien la rigueur si on veut mieux le voir si vraiment vous voulez être sûr de ne pas vous tromper et de bien voir les choses. Avec le esperluette on voit très bien que c'est l'adresse de la fonction qu'on veut parce que vous savez que ce caractère esperluette signifie que l'on veut une adresse d'accord on l'a après comme ça message en tout cas que vous allez aussi le retrouver directement marqué comme ceci `addition` mais bon à simple addition comme ça alors qu'on voit bien que c'est pas un nombre, que ce n'est pas une chaîne donc on voit bien que c'est une fonction à priori donc c'est vrai qu'utiliser un esperluette permet d'éviter la confusion et le doute.

À partir de là on peut utiliser notre pointeur de fonction sans problème voilà donc le et commercial est facultatif mais vous pouvez l'utiliser c'est tout à fait possible.

Du coup comment fait on un appel à partir de notre pointeur de fonction ? Écouter c'est vraiment très simple donc on va commencer par faire `int res = 0` et là je paramètre tout ce qui est pointeur de fonction comme ceci.

```txt
int res = 0;

int (*pointeurFonction)(int, int);
pointeurFonction = addition;//ou &addition
```

Et ensuite je vais l'utiliser donc je commence par faire *res = ...* et j'appelle mon pointeur de fonction de la manière la plus simple c'est à dire que je fais `res = pointeurFonction();` et je vous rappelle que *pointeurFonction* est une adresse donc ça fonctionne.

```c
#include <stdio.h>

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

double multiplication(double nb1, double nb2)
{
    return nb1 * nb2;
}

int calculer(int nombre1, int nombre2, int (*pointeurFonction)(int, int))
{
    pointeurFonction(nombre1, nombre2);
}

int main(void)
{
    int res = 0;
    
    int (*pointeurFonction)(int, int);
    pointeurFonction = addition;

    res = pointeurFonction();
    
    return 0;
}
```

Alors je vous rappelle que `pointeurFonction` est une adresse donc ça fonctionne et c'est comme si j'appelais la fonction addition() ici `res = pointeurFonction();` sur lequel je pointe avec pointeurFonction directement sur addition `pointeurFonction = addition ;`.

Voilà on change de nom pour la fonction addition() qui devient pointeurFonction() et on gère les paramètres de la même manière donc par exemple on va mettre 15 et 5 et après je fais un petit printf().

```c
#include <stdio.h>

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

double multiplication(double nb1, double nb2)
{
    return nb1 * nb2;
}

int calculer(int nombre1, int nombre2, int (*pointeurFonction)(int, int))
{
    pointeurFonction(nombre1, nombre2);
}

int main(void)
{
    int res = 0;
    
    int (*pointeurFonction)(int, int);
    pointeurFonction = addition;

    res = pointeurFonction(15, 5);
    printf("Res : %d\n", res);
    
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Res : 20
```

Voilà c'est très simple ça fonctionne il suffit juste de faire un appel de fonction, ainsi `res` récupère le retour de la fonction pointeurFonction() sauf que pointeurFonction n'est pas répertorié dans mes fonctions qui ont été faites mais c'est un pointeur déclaré voilà donc pointeur de fonction qui du coup va pointer vers addition `pointeurFonction = addition;` tout simplement.

Alors attention on ne peut pas utiliser le est commercial *res = &pointeurFonction(15, 5) ;* par contre ça revient au même que de faire un déférencement c'est à dire qu'on peut déférencer le pointeur à l'appel comme ceci `res = (*pointeurFonction)(15, 5) ;`.

Alors oui on peut déférencer le pointeur à l'appel mais ça ne simplifie pas les choses au niveau de la syntaxe, en plus des fois ça peut changer la coloration donc à la rigueur évitez cette syntaxe là mais vous faites encore une fois comme vous voulez ainsi si vous voulez l'appeler comme ceci sachez que ça fonctionne voilà.

```c
#include <stdio.h>

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

double multiplication(double nb1, double nb2)
{
    return nb1 * nb2;
}

int calculer(int nombre1, int nombre2, int (*pointeurFonction)(int, int))
{
    pointeurFonction(nombre1, nombre2);
}

int main(void)
{
    int res = 0;
    
    int (*pointeurFonction)(int, int);
    pointeurFonction = addition;

    res = (*pointeurFonction)(15, 5);
    printf("Res : %d\n", res);
    
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Res : 20
```

Voilà sachez que ça fonctionne donc c'est soit l'une ou l'autre et donc sachez que vous pouvez directement marquer le nom du pointeur de fonction et vous gérez les paramètres de la même manière comme vous l'avez marqué ici à la déclaration `(int, int)`.

C'est vraiment simplissime donc ça c'est quelque chose au niveau de la syntaxe qui est relativement simple.

Au niveau de la généricité le plus compliqué ce n'est pas tellement la manière d'écrire les choses mais c'est plus la manière dont on va comprendre à quoi ça peut servir et dans quelqu'un on va utiliser ça, évidemment dans quel cas ça ne servirait pas.

Là ici comme je montre des choses assez basiques, on ne va pas forcément voir l'utilité des pointeurs de fonction parce que je ne vais pas vous faire un programme qui est très long avec tout un tas de choses complète dedans, avec des fonctions de rappel et cetera bref des choses très compliquées.

Bref ça n'aurait aucun intérêt et vous n'aurez pas compris l'essentiel de la notion, et vous seriez perdu dans le code alors qu'ici ce n'est pas tellement ce qui nous intéresse mais plus à virtuellement ce qu'il y a derrière et cetera.

Retenez simplement que pour les pointeurs générique ça permet de manipuler plusieurs types de données, tandis que notre pointeur de fonction va nous permettre d'utiliser une fonction par le biais d'un pointeur donc vous verrez plus tard quel usage quel intérêt ça peut avoir à utiliser des pointeurs de fonction plutôt que d'appeler directement les fonctions elles-mêmes.

Ainsi pour ceux qui ont bien compris la notion de pointeur en elle-même et quel intérêt il y a à utiliser un pointeur vers une variable plutôt que là variable directement, là vous aurez compris certainement qu'il y a un intérêt identique à utiliser un pointeur de fonction plutôt que la fonction à elle-même.

À ce niveau je pense que certains auront déjà compris l'intérêt à utiliser ce genre de notion.

Ça c'était tout ce qui était appel de fonction.

Alors on va pouvoir également l'utiliser dans une fonction Parce qu'on l'avait utilisé dans la fonction en tant que paramètres, argument c'est pareil. Tout à l'heure quand j'avais fait la fonction calculer, j'avais mis en paramètre de la fonction ceci `int (*pointeurFonction)(int, int);` tout simplement j'avais fait un copié collé de ceci et après directement à partir de là je pouvais l'utiliser dans la fonction.

```c
int calculer(int nombre1, int nombre2, int (*pointeurFonction)(int, int))
{
    pointeurFonction(nombre1, nombre2);
}
```

Alors ça c'est une manière de passer une fonction en argument, c'est ce qu'on appelle une fonction de **callback** donc une fonction de rappel.

Alors je ne vais pas m'éterniser là-dessus, rentrer plusieurs détails parce que c'est une notion assez complexe, on arrive sur des choses très compliquées quand on commence à parler de fonction de rappel, voir de fonctions de coroutine pour revenir sur des choses encore plus compliquées mais sachez que quand on a ce genre de fonction `int maFonction(int a, int b, int (*pointeurFonction)(int, int));` retenez que ceci `int (*pointeurFonction)(int, int);` est une fonction de rappel donc une fonction callback tout simplement.

`int (*pointeurFonction)(int, int);` est une fonction de rappel donc une fonction callback tout simplement parce qu'on l'appelle comme ça dans le jargon informatique c'est tout ce qu'il y a à savoir.

Des fois il y a la fonction qsort() qui est une fonction de tri du langage c qui va utiliser `int (*pointeurFonction)(int, int);` c'est à dire qu'elle va faire entrer sur certains types de données et un argument comme ça qui est une fonction callback qui va permettre de faire la comparaison entre chaque élément de notre tableau donc ce genre de chose, ce qui permet dans la fonction d'utiliser le résultat d'une autre fonction d'où le terme de fonction de rappel.

On se sert donc d'une fonction comme argument à une autre fonction donc on va avoir une fonction A qui va servir d'argument et de fonction B, et c'est là toute la complexité.

Encore une fois je ne rentrerai pas dans les détails des fonctions callback parce que ça n'aurait aucun intérêt de faire une fonction de rappel au niveau que vous avez même déjà pour ceux qui ont déjà un niveau plus avancé, c'est vraiment pour les cas très spécifiques les fonctions de callback donc vous n'en allez pas utiliser tous les jours croyez-moi. 

Donc je peux sans problème passer là-dessus, on les revera dans le détail le jour on aura décidé de le faire dans une vidéo donc ne vous en faites pas je vous donnerais tous les détails là-dessus, et on en fera partout, pas de souci avec ça.

Maintenant vous serez comment manipuler les fonctions de rappel, maintenant en tout cas vous savez les identifier, vous savez les trouver et vous savez même à la rigueur les utiliser dans une fonction.

Du coup comme vous avez vu qu’on les utilisaient dans une fonction, vous vous dites pourquoi pas ne pas retourner un pointeur de fonction ? ça peut être sympa on a une fonction qui retourne un pointeur de fonction.

Alors dans quel cas est-ce que ça peut servir ? Et bien ça peut notamment servir pour gérer un espèce de tableau qui va posséder un petit peu toutes les fonctions que vous allez avoir comme par exemple ici dans notre exemple on a l'addition(), la soustraction() et cetera.

Alors bien sûr je pourrais avoir beaucoup plus de fonctions et même en rajouter.

Du coup je vais faire un exemple très simple et ça terminera la vidéo donc on terminera avec cette histoire de retour de fonction en retournant justement un pointeur de fonction.

## Exemple de fonction qui retourne un pointeur de fonction

Pour notre exemple on va d'abord commencer par définir un type donc on va faire un `typedef` et le type qu'on va définir c'est ce qu'on avait tout à l'heure.

```c
#include <stdio.h>

typedef int (*pointeurFonction)(int, int);

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

int main(void)
{
    
    return 0;
}
```

Voilà nous venons de définir le pointeur de fonction, on va s'en servir plus tard sans problème.

Alors maintenant dans ma fonction main(), ce que je vais pouvoir faire et c'est super pratique, je vais me faire un petit tableau donc je vais utiliser le type `pointeurFonction` et je veux l'appeler pour que ce soit clair tableauFonctionsCalcul[] un super nom à rallonge et pour le moment on dit que j'en ai que 2 `pointeurFonction tableauFonctionsCalcul[2];`. 

```c
#include <stdio.h>

typedef int (*pointeurFonction)(int, int);

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

int main(void)
{
    pointeurFonction tableauFonctionsCalcul[2];

    return 0;
}
```

Alors dans notre tableau on va pouvoir y stocker les différentes fonctions, donc je vais prendre `tableauFonctionsCalcul[0] = &addition;` donc dans cette première case on va y stocker addition mais au choix on peut utiliser le et commercial ou non. Et pour le deuxième élément, je vais mettre la soustraction.

```c
#include <stdio.h>

typedef int (*pointeurFonction)(int, int);

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

int main(void)
{
    pointeurFonction tableauFonctionsCalcul[2];

    tableauFonctionsCalcul[0] = &addition;
    tableauFonctionsCalcul[1] = &soustraction;

    return 0;
}
```

Voilà nous avons mis nos 2 fonctions addition() et soustraction().

Encore une fois s'il y a quelque chose qui n'est pas clair, qui n'est pas compris, laisser un petit commentaire.

Autrement vous pouvez revenir sur cette vidéo plus tard quand vous aurez un meilleur niveau, pas de souci, alors cette vidéo n'est pas indispensable même si ces notions sont utilisées dans le langage c où par exemple on peut retrouver des pointeurs génériques par exemple d'aller fonction d'allocation. Ou encore comme je vous ai dit on peut retrouver des pointeurs de fonction dans la fonction qsort() par exemple.

Alors si vous vous deviez l'utiliser dans ce langage est ce que vous en auriez tout le temps l'utilité ? Personnellement je ne crois pas.

Vraiment si ce n'est pas toujours clair ce n'est pas bien grave, c'est peut être que vous n'avez pas encore vu à cette chose ou que vous n'avez pas encore eu assez de recul sur ce que vous avez appris pour que ça rentre vraiment comme ça de manière logique mais de toute manière ça rentrera comme tout le monde y'a pas de problème à ce niveau-là.

Voyez donc on a finalement stocké dans notre tableau les différentes adresses de mes fonctions.

Alors comme ici on a effectivement un **tableau de pointeurs de fonction** donc quelque chose d'un peu générique même si ce n'est pas vraiment générique parce qu'on a défini ici par une signature `typedef int (*pointeurFonction)(int, int);` on peut donc stocker toutes les fonctions qui correspondent à cette signature et ça c'est important.

Alors on a mis les 2 fonctions de calcul qu'on a mis mais on aurait pu en mettre d'autres bien sûr, on aurait pu par exemple mettre le calcul de modulo mais pour l'exemple on va en utiliser que 2.

À partir de là comment est ce que je vais faire mon appel ? Alors on va utiliser une petite variable comme on a utilisé tout à l'heure `int res = 0;` histoire de ne pas trop changer les choses sinon ça peut très vite devenir compliqué et on va faire comme tout à l'heure *res = …* sauf que cette fois-ci on va passer par le tableau.

Donc voilà on sait comment manipuler les tableaux donc on ne va pas commencer par écrire *res = addition* comme on a fait tout à l'heure ou bien en utilisant le pointeur de fonction *res = pointeurFonction* et puis en dernier argument on mettait la soustraction, l'addition et cetera.

Ici il suffit tout simplement de mettre le nom du tableau avec le nombre qui correspond au calcul `tableauFonctionsCalcul[1](126, 34);` voilà et entre parenthèses sont mais les paramètres de la fonction c'est aussi simple que ça.

```c
#include <stdio.h>

typedef int (*pointeurFonction)(int, int);

int addition(int nb1, int nb2)
{
    return nb1 + nb2;
}

int soustraction(int nb1, int nb2)
{
    return nb1 - nb2;
}

int main(void)
{
    int res = 0;
    pointeurFonction tableauFonctionsCalcul[2];

    tableauFonctionsCalcul[0] = &addition;
    tableauFonctionsCalcul[1] = &soustraction;

    res = tableauFonctionsCalcul[1](126, 34);

    printf("RES = %d\n", res);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
RES = 92
```

Et voilà 92.

J'ai simplement utilisé mon tableau pour pouvoir gérer mes différentes fonctions de calculs grâce à la définition de mon pointeur de fonction.

Voilà c'est la fin de cette vidéo, je n'ai pas besoin de m'éterniser un petit peu plus là-dessus, je suis sûr qu'il y en a 2/3 qui n'ont pas vu l'utilité du tout du tout du tout du tout des pointeurs génériques, ni des pointeurs de fonction. Encore une fois c'est parfaitement normal, pour ma part je suis allé beaucoup plus loin sur le langage donc c'est normal que j'ai un petit peu plus d'expérience et automatiquement j'en ai eu besoin à un moment donné parce que je n'avais pas d'autres solutions ou alors c'était beaucoup plus logique, beaucoup plus évident mais dans votre cas je comprends que c'est pas forcément logique.

Alors quand j'ai appris le langage c'est à l'époque, je n'ai pas utilisé les pointeurs de fonction tout de suite donc vraiment si ce n'est pas clair pour vous vous pouvez revoir la vidéo mais sinon vous pouvez laisser et revenir dessus plus tard.

Poser des questions si nécessaire, allez voir sur le discord, rencontrer les abonnés si les choses ne sont pas claires et vous pouvez vous faire des idées entre abonnés mais en tout cas il y a tout ce qu'il faut pour essayer de comprendre les choses et prendre le temps de les assimiler.

Peut être qu'un jour vous aurez vraiment besoin de ça dans un programme et à ce moment-là vous comprendrez toute l'utilité d'utiliser ces pointeurs de fonction voir ces pointeurs génériques donc ça viendra tout seul, là dessus je ne me fais pas de souci.

Je vais vous laisser avec ça, tout dépend de ce que vous allez visionner par la suite, moi je vous dis à très bientôt j'espère que ça était suffisamment clair.

Maintenant vous me connaissez vous savez que j'aime bien prendre le temps de bien expliquer les choses, j'estime que c'est important c'est comme si vous passiez 4h à l'université à écouter un prof mais moi ici je prends le temps de vous expliquer les choses parce que c'est nécessaire et qu'il faut prendre le temps surtout quand on parle de choses assez complexes comme ici.

À très bientôt tout le monde et entraînez-vous bien, revoyez tout ça et faites quelques exemples de programmes s'il faut mais encore une fois ne perdez pas trop de temps sur cette vidéo là parce que c'est vraiment un petit plus.

Elle a été faite sur base d'une minorité qui la demandait mais autrement je l'aurais peut être jamais fait donc c'est un petit bonus c'est un cadeau c'est gratuit et ça ne mange pas de pain.

À bientôt manteau se retrouve pour une nouvelle vidéo
