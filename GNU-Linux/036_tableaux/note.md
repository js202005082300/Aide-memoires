# [36. Tableaux](https://www.youtube.com/watch?v=VgJvbiVLLBA)

Bonjour à tous et bienvenue pour cette 36e séance sur GNU Linux.

Si vous vous rappelez la dernière fois nous avions vu avec les chaînes de caractères beaucoup de notations différentes pour effectuer quelques opérations sur ces dernières.

On va retrouver déjà quelques syntaxe sur la vidéo présente, on va parler de tableau.

Alors les tableaux bien évidemment si vous programmez dans d'autres langages, vous savez déjà ce que c'est.

On a quelques similitudes évidemment avec Bash c'est un peu le même principe mais après en interne on n'a pas forcément le même comportement mais au niveau de la création de scripts tels que vous allez le faire ça ne va pas tellement poser de problème.

## Déclaration et initialisation

Je vais vous montrer un petit peu via la syntaxe de base comment on met en place des tableaux au niveau de nos programmes très simplement.

Ok on va revenir directement sur un code vierge.

```bash
#!/bin/bash

```

On va déjà regarder comment déclarer un tableau et je vais vous présenter deux manières de le faire puisque vous allez pouvoir déclarer un **tableau par indices** et un **tableau associatif**.

Evidemment vous n'avez peut-être jamais programmé encore une fois donc c'est pas mal d'indiquer un peu la différence.

Un tableau avec indice va fonctionner de la manière suivante, on va le déclarer ça pas de problème mais chacun des éléments possédera un indice, index si on utilise le terme anglais sachant que celui-ci commence par l'indice 0 ça c'est très souvent le cas en  informatique, toujours dans quasiment tous les cas le premier indice donc le premier élément notamment ici d'un tableau commencera à l'indice 0.

Si on veut le deuxième élément on aura l'indice 1 etc etc.

```bash
#!/bin/bash

[0] [1]
```

Pour un tableau associatif, on va tout simplement associé une clé d'accord avec une valeur.

```bash
#!/bin/bash

[clé] => [valeur]
```

Il faut le voir comme ça.

Voilà vous allez pouvoir créer donc ces deux types de tableau avec Bash en fonction bien sûr de l'usage que vous voulez en faire au niveau de vos programme.

On va regarder tout ça.

Le meilleur moyen en tout cas le moyen le plus  éfficace, le plus explicite de le faire pour être sûr de bien déclarer des tableaux comme il faut et ne pas avoir d'erreur par la suite c'est d'utiliser la commande `declare`.

`declare` va nous permettre via 2 arguments notamment le premier ici qui est un a minuscule attention, `declare -a` de déclarer justement notre tableau avec un fonctionnement par indice.

On va le faire et je vais l'appeler peut-être index_array comme ceci.

```bash
#!/bin/bash

declare -a index_array
```

D'accord et là on peut très bien laisser comme ça, on a juste déclaré notre tableau ok.

Je vais vous montrer cet exemple là et on va déclarer directement un tableau associatif également et on va voir après, on va compléter au fur et à mesure.

Pour le tableau associatif c'est la même chose simplement que l'option donc l'argument utilisé est un a majuscule `declare -A assoc_array`.

```bash
#!/bin/bash

declare -a index_array
declare -A assoc_array
```

On a déclaré deux tableaux de types différents d'accords et on va pouvoir éventuellement enregistrer des informations dedans alors on peut affecter des informations par la suite comme on le ferait avec une variable et que vous avez déjà vu jusqu'à présent mais on peut bien sûr dès la déclaration initialiser certaines valeurs.

Maintenant on va pouvoir enregistrer un certain nombre d'éléments, à initialiser entre parenthèses alors ces éléments au niveau des valeurs ici je veux mettre des simples nombres comme ceci et je vais les séparer par des espaces.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array
```

Voilà on essaye de varier un peu mais on ne met pas des virgules attention c'est le réflexe de mettre des virgules dans d'autres langages.

Voilà on a quatre valeurs séparées par une espace à chaque fois dans de ce tableau d'indice.

Pour le tableau associatif je vais faire quelque chose de très simple, je vais déclarer des clés très important donc les clés on peut mettre entre simple guillemets, double guillemets mais je ne vais même pas m'embêter avec ça et je vais les mettre les doubles et je vais faire par exemple une identité.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")
```

Voilà on a deux exemples un tableaux d'indices et un tableau associatifs donc voyez comment ça fonctionne.

index_array, là on a directement des valeurs et ici, assoc_array, on va avoir automatiquement une clé associée à une valeur donc on a un nouveau symbole égale à chaque fois.

Voilà ce qu'on peut faire au plus simple pour ces différents cas.

Alors ça `declare` c'est une commande interne que nous avons déjà vu, rappelez-vous on a vu également je vous ai parlé de la commande `readonly` qui permet notamment de déclarer des variables en lecture seule.

On pourrait tout à fait bien sûr pour un tableau, je le montre rapidement, déclarer ce tableau en lecture seule, ça fonctionne également.

```bash
#!/bin/bash

readonly -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")
```

N'oubliez pas encore une fois et c'est très important que tout ce que vous avez vu précédemment en Bash peut-être parfaitement réutilisé, adapté à tout ce que vous voyez par la suite.

Par exemple quand on a abordé la liste des arguments qu'on peut passer en entré pour un programme qu'on exécute en Bash, sachez que toutes ces notations, toutes ces syntaxes pourront être utilisés également pour les tableaux.

N'oubliez jamais tout ce que vous avez vu précédemment et n'hésitez pas justement à associer toutes ces  notions ensemble surtout si vous voulez vous exercez, vous entraînez.

Vous allez voir que tout ce que vous avez vu précédemment peut servir dans des notions qu'on a vu plus tard ensemble d'accord on peut tout à fait faire cela, rien n'est complètement distincts, complètement séparées mais tout fonctionne ensemble.

Voilà donc je vais passer très vite sur cette partie pour qu'on voit un peu la suite.

## Spécifier indice

Alors il y a aussi une chose qu'il faut savoir, c'est  que là au niveau de la partie des indices ... donc au niveau des clés `["prenom"]="Jack" etc` il n'y a pas de problème. On sait que pour Jack la clé qui correspond ces prenom. Pour DURAND la clé qui correspond c'est nom, pas de problème.

Ici on a des valeurs et je vous ai expliquez tout à l'heure pour un tableau d'indice qu'ont fonctionnait justement par indice.

```bash
#!/bin/bash

# [0]
```

On fonctionne par indice c'est à dire notamment le premier élément qui commence par un 0 c'est à dire que celui-là `[142]` implicitement sera l'indice 0, celui-là `[65]` sera l'indice 1, l'indice 2 `[2]` et l'indice 3 `[98]` d'accord.

`declare -a index_array=(142 65 2 98)`

On peut éventuellement même s'il faut bien sûr en avoir un usage, il faut que ce soit volontaire, choisir par exemple de faire un saut au niveau des indices par rapport en tout cas aux valeurs qu'on a explicitement initialisés spécifiques ici.

Admettons que je veux à partir de là que ça commence à partir de l'indice 50, je ne sais pas pourquoi, je veux parfaitement faire ceci.

`declare -a index_array=(142 65 [50]=2 98)`

Voilà donc là on aura 142 qui sera à l'indice 0, 65 qui sera à l'indice 1 et le 2 sera à l'indice 50 et le suivant prendra par incrémentation le prochain c'est à dire l'indice 51.

Toutes les valeurs des indices d'avant seront des chaînes vide d'accord seront des valeurs que vous n'avez pas spécifiées.

Voilà toutes les valeurs des indices d'avant seront présentes bien évidemment au niveau de ce tableau alors ça il faut en avoir un usage bien précis mais je vous le montre parce que peut-être qu'un jour vous serez amené à travailler sur d'autres codes et si vous voyez ce genre de notation ne soyez pas étonnés c'est tout à fait valide c'est simplement qu'on a spécifié un index pour une valeur en particulier `[50]=2`.

Voilà donc on va reprendre sur un code plus simple.parce que ça n'a pas d'intérêt ici.

Au pire vous pourrez encore une fois vous entraîner à la fin de cette vidéo avec des saut d'indice si vous voulez dans vos valeurs initialisées, il n'y a pas de problème mais nous on va se contenter de ça déjà.

## Afficher tableau par indices

Commençons par la base des bases comme on l'a fait pour les variables c'est à dire l'affichage.

On sait afficher une variable très simplement mais comment ça se passe pour un tableau sachant qu'il y a plusieurs valeurs.

Alors on pourrait tout simplement se contenter déjà d'un parcours, c'est la première chose auquel on pourrait penser puisque vous avez vu en tout cas vous avez appris à utiliser des boucles, savoir un peu à quoi elles servaient et ce ne se serait pas bizarre finalement de se dire de parcourir l'ensemble des éléments d'un tableau jusqu'à arriver à la fin de ce tableau.

On imagine parfaitement l'application d'une boucle dans ce genre de cas.

Alors il existe encore une fois plein de boucle que vous avez vu avec plein de notations différentes.

Je ne vais pas toutes les repriser mais rappelez vous qu'on a vu la boucle avec l'ancienne notation càd avec les doubles crochets `[]`.

On a vu la boucle comme en langage c d'accord `for` avec trois éléments c'est à dire l'initialisation, le point d'arrêt et l'opération d'incrémentation qu'on va effectuer et on a vu aussi les fameuses boucles un peu foreach qu'on retrouve dans d'autres langages de programmation.

Alors je ne vais en montrer qu'une des trois parce qu'on les a déjà vus de façon précédemment mais on peut tout à fait faire ce genre de choses-là.

On a le premier élément d'accord je vais le l'ajouter dans une variable temporaire donc par exemple `$number` puis `in` et ici on a besoin d'indiquer finalement ce qu'est notre tableau d'accord.

`for $number in ...`

**Attention**, il ne faut pas le $ parce qu'on ne cherche pas à l'afficher.

`for number in ...`

Alors par défaut on pourrait être tenté de faire ça `$arr` comme ça `for number in $arr` d'accord tel qu'on afficherait une variable c'est-à-dire lui `$index_array` d'accord on pourrait tenter de faire ça `for number in $index_array` ensuite on fait un do, on affiche number et on termine la boucle, done.

```
for number in $index_array
do
    echo $number
done
```

D'accord ça c'est la logique la plus simple qu'on pourrait avoir le problème c'est qu'ici nous n'avons pas une simple variable nous avons effectivement un tableau.

On va donc avoir un comportement particulier.

Pour pouvoir afficher l'ensemble des éléments puisque là on va obtenir que le premier élément d'accord ça revient en fait a indiqué l'indice [0].

On veut l'ensemble des éléments et pour ça on va pouvoir jouer sur l'affichage avec une autre notation c'est à dire utiliser des accolades rappelez-vous sur les chaînes de caractères, on utilisait souvent ces notations aussi et entre crochets de spécifier l'indice que l'on veut.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

for number in ${index_array[0]}
do
    echo $number
done
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142
```

Si je mets ça, je ne vais récupérer que l'indice 0 donc faire un parcours sur un seul élément du coup ce serrait compliqué et comme on a pas une chaîne donc on n'aura pas quelque chose de séquentiel.

On va utiliser un caractère qu'on a déjà vu, qui permet d'indiquer généralement tous les éléments rappelez vous quand on parlait des arguments en entrée de l'exécution d'un script, nous avions vu l'arobase @ et bien vous pouvez réutiliser l'arobase ici pour indiquer tous les éléments du tableau.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

for number in ${index_array[@]}
do
    echo $number
done
```

Alors on a une boucle `for` pour dire que chaque valeur, élément de ce tableau on va le mémoriser temporairement dans une variable qui s'appelle number et qui sera disponible à chacune des itérations mais elle va évidemment changer sa valeur à chacune des itérations puisque dès qu'on va faire une nouvelle itération on va récupérer le 2e élément ainsi que le 3e et ainsi de suite.

Là je vais pouvoir directement afficher ça.

```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142
65
2
98
```

On fait ça et nous avons chacune des valeurs séquentielle.

On fait un parcours bêtement tel ou tel que nous l'avons.

Voilà donc ça c'est une chose que vous pouvez parfaitement appliquer.

`@` ça rappelez vous c'est un caractère que vous avez déjà vu précédemment, les boucles vous les avez déjà vu.

Maintenant vous savez comment est déclarée un tableau.

On associe un peu toutes ces notions que l'on a vu et finalement on peut parfaitement faire ce genre de choses.

Alors sans forcément passer par une boucle en tout cas un autre type de boucle, on a quelques notations à connaître et qui sont déjà des choses que vous avez pu voir et qu'on reconnaît assez bien.

On a deux distinctions à faire et qu'on a vu notamment sur les arguments passé lors d'un programme.

L'étoile * et l'arobase @, je rappelle et ça va servir ici pour les tableaux, l'étoile va tout simplement enregistrer tous les éléments sous une seule chaîne d'accord ça veux dire que tout ça `[142 65 2 98]` va former qu'une seule chaîne si on utilise l'étoile et chaque élément sera séparé par ce qui est contenu dans une variable  spéciale déjà abordé aussi rapidement qui est IFS. IFS par défaut normalement il doit spécifier une espace, ça va être le cas.

```
#!/bin/bash

# *
# @
```

Voilà on peut utiliser ce genre de notation `*` et si on utilise l'arobase `@` en fait ça va bien séparer chacune des valeurs du tableau d'accord comme étant une chaîne a part donc une première chaîne `142`, une deuxième `65`, une troisième `2`, une quatrième `98` donc au plus simple je peux faire pour résumer tout ça.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${index_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142 65 2 98
```

Alors je ne reviens pas sur les différences entre l'astérisque et l'arobase on va dire au niveau de l'affichage, on l'a déjà vu de toutes façons précédemment.

Alors même si visuellement on pourrait penser que c'est qu'une seule chaîne en réalité nous en avons quatre.

Par contre ici `*` on aura un comportement différent d'accord.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${index_array[*]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142 65 2 98
```

Visuellement c'est sûr qu'on a l'impression de voir la même chose mais vous avez compris, on en a déjà parlé la dernière, c'est deux choses différentes.

Dans ce genre de cas là, il va y avoir une distinction après vous verrez que dans d'autres opérations, il n'y aura pas de différence entre les deux symboles c'est pour ça que j'insiste un peu dessus parce que c'est souvent une source d'erreur pour les gens qui font leurs scripts qui mélange un peu les deux et se retrouve avec des choses pas forcément voulu au niveau des scripts donc c'est bien de le savoir et de comprendre un petit peu comment ça fonctionne.

Voilà on a deux possibilités.

Pour notre tableau ici maintenant si on veut afficher un élément en particulier, on peut tout simplement faire ceci `echo $index_array`.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo $index_array
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142
```

Alors on obtient directement le premier élément.

Si on veut explicitement indiqué qu'on veut récupérer le premier élément ça revient à afficher l'élément d'indice 0 c'est à dire celui-ci d'accord.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${index_array[0]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142
```

Je refais et on retrouve exactement la même chose.

Si je fais ça j'affiche le second élément et ainsi de suite.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${index_array[1]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
65
```

On peut également procéder à l'envers, vous pouvez travailler avec des indices négatifs en mettant par exemple `-1`.

`-1` sera tout simplement le dernier élément de votre tableau.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${index_array[-1]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
98
```

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${index_array[-2]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
2
```

Si vous mettez `-2` d'accord donc plus vous augmentez en fait cette valeur dans les négatifs et plus vous redescendez d'accord dans les indices inférieurs donc `-2` c'est l'avant dernier élément de votre tableau et ainsi de suite et ainsi de suite donc ça c'est pareil si vous voulez bien comprendre un petit peu ces notations, n'hésitez pas à vous entraîner avec des petits exercices vous tester sur plein d'indices et vous allez très vite comprendre et assimiler comment ça fonctionne mais je pense qu'honnêtement c'est pas compliqué.

Vous pouvez largement comprendre ces notations là, il n'y aura pas de problème.

Voilà pour tout ce qui est déclaration, initialisation éventuel affichage.

## Afficher tableau associatif

Maintenant pour le tableau associatif normalement vous avez un peu compris le principe, on doit pouvoir de base essayer ça et ça  donne Jack.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${assoc_array[prenom]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
Jack
```

Voilà on indique la clé `[prenom]` donc cette fois ci ce n'est pas forcément un indice sous forme de nombre entier d'accord et on récupère automatiquement la valeur.

Très pratique et on voit que visuellement parlant au niveau du code c'est même beaucoup plus parlant.

On comprend que dans le tableau, on va récupérer le prénom et c'est bien ce qui est associé.

Alors on peut aussi d'ailleurs le récupérer avec des guillemets, `"prenom"`.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${assoc_array["prenom"]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
Jack
```

Alors ça pareil, on en a beaucoup beaucoup parlé au sujet des différences de notations sans rien du tout, avec des doubles quotes, avec des simples quotes, avec des quotes inversées pour les commandes notamment et cetera et cetera, avec l'utilisation justement du dollar $ et des accolades {} par rapport au développement et tel qu'il est fait au niveau de l'exécution pour les commandes.

Bon je ne reviendrai pas là dessus puisque je ne vais pas revenir dessus à chaque fois, j'en ai suffisamment parlé maintenant pour qu'on considère ceci comme assimilé au stade où vous en êtes en tout cas du coup puisqu'on en est quasiment quasiment à la fin.

## Modification

Voilà pour l'affichage on va pouvoir passer maintenant à quelques modifications de valeur parce que là c'est bien mais à moins bien sûr d'avoir déclaré votre tableau `readonly`.

On peut parfaitement changer, modifier des valeurs du tableau donc pareil normalement vous avez compris un petit peu comment accéder à un élément donc là c'est lié à de l'affichage d'accord mais si je veux modifier, je remplace l'élément d'indice 0 par 366 et je ré affiche ce dernier.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${index_array[0]}
index_array[0]=366
echo ${index_array[0]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142
366
```

Voilà nous avons changé la valeur de ce tableau d'accord d'ailleurs si je décide d'afficher tous les éléments `@`, on va voir que ça a bien opéré sur l'ensemble du tableau.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${index_array[0]}
index_array[0]=366
echo ${index_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142
366 65 2 98
```

On a bien changé le 142 par 366 d'accord donc très simplement.

Pas besoin je pense de vous montrer pour le tableau associatif, vous l'avez compris vous mettez la clé ici et vous pouvez changer la valeur et faire une nouvelle une affectation et donc une modification de la valeur de votre tableau par rapport à la clé.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${assoc_array["prenom"]}
assoc_array["prenom"]="blabla"
echo ${assoc_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
Jack
blabla DURAND
```

Soit on indique l'indice ici `index_array` et ici `assoc_array` on indique la clé puisque la clé ici fait office d'indice sauf qu'il n'a pas forcément voyez un suivi de manière incrémentale on va dire des indices d'accord.

Le mot "nom" ne vient pas de l'incrémentation directe de "prenom", là où l'indice 1 est l'incrémentation directe de 0 et ainsi de suite au niveau des nombres entiers, des nombres entiers naturels.

Bien je pense qu'on va pouvoir passer maintenant passer à la suite.

On a vu un petit peu comment afficher tous ces éléments là donc la
liste que je voulais vous montrer.

Alors ce qui peut être intéressant, c'est la liste des indices alors ça on n'en a pas forcément toujours besoin bien que ici ça se justifie quand même déjà moins mais pour les tableaux associatifs je pense notamment aux langages php, c'est une opération qu'on a des fois besoin de faire et d'avoir besoin en tout cas.

Et ça va en plus permettre de réviser quelques notations qu'on a vu avec les chaînes de caractères.

Admettons que je veuille récupérer l'ensemble des clés cette fois-ci de mon tableau associatif et non pas des valeurs, je peux parfaitement le faire aussi toujours avec cette notation.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${assoc_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
Jack DURAND
```

D'accord ça c'est la notation classique donc on connaît.

On note ici l'ensemble des éléments c'est l'arobase `@` si on veut récupérer chaque élément indépendamment les uns des autres.

Maintenant si je veux récupérer les valeurs parce que ça c'est pour récupérer l'ensemble des valeurs mais moi je vais afficher l'ensemble des clés et bien vous allez placer ici comme préfixe un petit point d'exclamation et la magie opère et on récupère l'ensemble des clés.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${!assoc_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
prenom nom
```

Si vous faites la même chose avec le tableau des index ça fonctionne pareil, ça vous retournera les indices d'accord.

## Taille

Autre opération possible et qu'on a souvent besoin aussi comme élément au niveau des tableaux c'est par exemple le nombre d'éléments de notre tableau c'est à dire ce qu'on appelle plus communément la taille du tableau.

Rappelez-vous pour les chaînes de caractères, nous avions un caractère pour ça qui est le croisillon et qu'on retrouve tout naturellement pour ça.

Voyez les syntaxes sont réutilisables selon le type de données qu'on manipule.

Avec les chaînes de caractères on utilise le croisillon et pour le tableau naturellement puisqu'on est sur cette forme de syntaxe dollar `$` avec les accolades `{}`, on peut parfaitement utiliser le croisillon aussi et on compte donc deux éléments à ce tableau.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${#assoc_array[@]}
echo ${#index_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
2
4
```

`index_array` est bien effectivement composé de quatre éléments, tout est correct la vie est belle c'est magnifique.

## Ajouter

Ok qu'est ce qu'on peut faire également d'autres au niveau des opérations ?

Alors on a vu pour l'affichage mais maintenant on va voir pour de l'ajout puisque c'est bien de pouvoir modifier des valeurs d'un tableau mais on a peut-être envie d'ajouter par exemple une  nouvelle valeur.

Alors dans ce genre de tableau ce qui est magique, on va dire un petit peu pour le tableau associatif c'est qu'on peut tout simplement ... alors je vais refaire un affichage telle qu'elle et ensuite j'aurais juste à faire ça, et ici `assoc_array[prenom]` si j'indique un indice qui existe on a vu que ça faisait une modification.

Admettons que maintenant j'indique un indice qui n'existe pas en faisant par exemple ceci, vous allez remarquer directement que nous avons ajouté ce dernier au niveau de notre tableau associatif.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${assoc_array[@]}
assoc_array[age]=26
echo ${assoc_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
Jack DURAND
26 Jack DURAND
```

Voilà donc ça c'est quand même vachement pratique.

Vous remarquerez d'ailleurs que âge a été ajouté au début mais ça au niveau de l'associatif on ne s'embête pas parce qu'on va surtout fonctionné dans un ordre d'accord par rapport aux indices mais surtout par rapport à l'association c'est à dire qu'on veut pouvoir dire à un moment donné si je veux récupèrer l'âge on sait automatiquement que j'aurais juste à faire ça, `echo ${assoc_array[age]}` et là je récupère directement l'âge.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${assoc_array[@]}
assoc_array[age]=26
echo ${assoc_array[age]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
Jack DURAND
26
```

Très pratique à ce niveau là donc c'est très facile de faire ensuite des opérations de ce côté.

Dans le cas éventuellement d'ajouter un autre indice là, on va pouvoir ajouter des éléments.

Pareil par rapport aux syntaxes qu'on a vu sur les chaînes de caractères vous allez pouvoir réutiliser tout ces outils, je vous avez expliqué que Bash était assez riche au niveau syntaxe tout simplement de manière syntaxique et on peut faire énormément d'opérations implicites ne serait ce que par sa syntaxe, dans la manière vous allez en fait faire vos écritures puisqu'elles seront traitées et considérées comme des expressions.

Rien ne vous empêche d'accord de faire ceci alors je ne suis pas forcément obligé de déclarer un nouveau tableau mais on va le faire quand même pour montrer qu'on change, on va considérer par exemple ici qu'on a quelque chose d'immuable, on va mettre par exemple en `readonly` d'accord.

```
readonly -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

declare -a new_index_array()=... etc.
```

`readonly` on va faire comme ça quelque chose de propre, on ne veut pas modifier ce tableau mais à un moment donné je veux quand même récupérer ce tableau `index_array` et ajouter un nouvel élément donc souvent quand vous manipuler des données immuables dans d'autres langages de programmation des fois vous avez l'impression d'avoir une donnée qui est effectivement modifiable puisque vous gardez par exemple le même nom de l'information sauf que ce n'est pas forcément le cas.

En réalité on garde le nom mais la donnée en mémoire a bien changé donc on n'a pas modifié la donnée qu'on avait avant.

Ainsi je déclare un new_index_array() et je vais tout simplement choisir où j'ajoute celui.

Moi ces valeurs là, je veux les ajouter au début donc ce tableau là c'est ça son ensemble d'éléments `${index_array[@]}` et à la suite je vais mettre 55 et ensuite un petit echo.

```bash
#!/bin/bash

readonly -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

declare -a new_index_array=(${index_array[@]} 55)
echo ${new_index_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142 65 2 98 55
```

Voilà j'ai repris les anciennes valeurs du tableau puisqu'on a dit que `${index_array[@]}` correspondait à l'ensemble de ses valeurs et on a ajouté une valeur qui suit `55`.

Voilà donc on peut parfaitement faire ce genre de manipulation.

Si j'avais fait l'inverse d'accord c'est à dire ça `55 ${index_array[@]}` je pense que vous l'avez compris on ajoute tout simplement la valeur de l'autre côté d'accord on fait en fait un changement et la valeur est ajoutée de l'autre côté donc soit on l'ajoute en fin soit on l'ajoute au début en fonction de comment on fait ça.

```bash
#!/bin/bash

readonly -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

declare -a new_index_array=(55 ${index_array[@]})
echo ${new_index_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
55 142 65 2 98
```

## Fusion

On peut parfaitement faire des fusions d'accord je peux tout à fait fusionner un tableau en un autre si j'ai un `index_array2`.

`readonly -a assoc_array2=(23 1 233 7)`

Evidemment je peux sans problème faire alors concatener le premier tableau avec le deuxième ou le deuxième avec le premier si on veut suivre cet ordre.

`declare -a new_index_array=(${index_array[@]} ${index_array2[@]})`

J'affiche mon nouveau tableau et voilà.

```bash
#!/bin/bash

readonly -a index_array=(142 65 2 98)
readonly -a index_array2=(23 1 233 7)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

declare -a new_index_array=(${index_array[@]} ${index_array2[@]})
echo ${new_index_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142 65 2 98 23 1 233 7
```

Voilà le tableau concaténe 8 valeurs des deux précédents donc on a fait une fusion de tableau très simplement juste par la syntaxe.

Voyez on n'a pas utilisé de fonctionnalités comme on va le voir prochainement avec des fonctions d'accord on est passé directement par la syntaxe où ça été traité comme une expression et l'expression ici nous permet de faire une fusion de tableau très simplement.

Voilà on pourrait faire ce genre de choses à sans problème.

On peut comme ça ajouter des éléments, en retirer, il n'y a pas de problème à ce niveau là bien sûr.

Alors est-ce qu'on peut normalement faire par exemple un ajout directement ? càd que je repars du même tableau et on va l'afficher avant encore une fois pour avoir une petite idée.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${index_array[@]}
index_array=(${index_array[@]} 11)
echo ${index_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142 65 2 98
142 65 2 98 11
```

Ce que je vais faire c'est `index_array` et dire en fait qu'il est égale à `${index_array[@]}`, c'est une affectation et non une intialisation et si j'ajoute 11 à la fin.

Voyez je ne crée pas un nouveau tableau en fait j'affecte au nouveau.

Ne pas oublier les parenthèses, `index_array=(${index_array[@]} 11)`.

Alors j'ai un doute mais on pourrait tout à fait déclarer un tableau comme ça d'accord.

`index_array=(142 65 2 98)`

Le problème c'est que là il déclaré de manière implicite et moi je vous ai fait utiliser la bonne méthode pour pouvoir indiquer explicitement que là on a un tableau d'indices `declare -a` et un tableau associatif `declare -A` et je vous recommande d'utiliser cette syntaxe là qui est beaucoup plus propre au niveau de la déclaration de tableau.

`index_array=(${index_array[@]} 11)` là même si on voit que c'est le même nom ce n'est pas dit que nous ayons effectivement le même tableau `index_array=(142 65 2 98)`. Il est possible que ça `index_array=(${index_array[@]} 11)` en fait ce soit un nouveau qui porte le même nom mais qu'en réalité voilà on a créé un nouveau tableau dans la volée donc pas sûr donc je ne confirmerai pas parce que je ne vais aller commencer à regarder si on regarde effectivement la même donnée ou pas c'est pas le but de la vidéo mais en tout cas voilà si vous voulez éviter de créer forcément un autre tableau avec cette syntaxe qui est un peu plus longue `declare -a index_array=(142 65 2 98)` sachez qu'on peut faire ça aussi directement d'accord.

Voilà ça revient au même puisque je vous ai expliqué que c'était traité comme expression mais comme j'avais un petit doute je préférais quand même voilà qu'on le vérifie ensemble pour voir c'était bon ou pas.

Ok donc ça c'est bon pas de problème de ce côté-là.

## Suppression

Maintenant qu'on a vu la déclaration, l'initialisation, on a vu comment accéder à nos éléments et les afficher, etc. On a vu comment les modifier, on a vu comment en ajouter, la logique comme on fait très souvent dans beaucoup d'opérations c'est la suppression de nos éléments et la suppression bon c'est pour le coup ça va être assez simple puisqu'on va soit choisir de supprimer un élément en particulier soit de supprimer l'ensemble du tableau.

On avait vu pour les variables aussi donc sachez encore une fois que c'est réutilisables au niveau des tableaux.

Je veux admettons supprimer l'élément ici d'indice 1 déjà on ré affiche tout pareil et donc je vais faire un `unset` d'accord.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${index_array[@]}
unset index_array[1]
echo ${index_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142 65 2 98
142 2 98
```

Voilà index_array de 1 donc je veux enlever en fait le 65.

Là on a retiré l'élément d'indice 1.

Je pense que j'ai pas besoin de vous dire que si vous voulez retirer sur un tableau associatif un élément en particulier, vous indiquez sa clé d'accord c'est pas nouveau.

Sinon vous pouvez faire ça `unset index_array` et vous supprimez l'ensemble du tableau.

```bash
#!/bin/bash

declare -a index_array=(142 65 2 98)
declare -A assoc_array=(["prenom"]="Jack" ["nom"]="DURAND")

echo ${index_array[@]}
unset index_array
echo ${index_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
142 65 2 98

```

Alors on peut aussi utiliser la syntaxe `unset index_array[*]` ou `unset index_array[@]`, l'astérisque ou l'arobase pour indiquer l'ensemble des éléments mais ici vous avez une syntaxe raccourcie pour le `unset` donc notez juste le nom, l'étiquette que vous avez utilisez pour votre donné et ça va la supprimer complètement, il n'y a pas de problème à ce niveau-là.

Au plus simple ne vous embêtez pas forcément à rajouter des syntaxes ou vous risquez en plus de faire une erreur, de vous tromper en mettant pas de crochets ou en mettant le mauvais caractère pour gagner du temps, vous pouvez mettrele le nom et ça fonctionne très bien aussi.

Voilà ça c'est à vous de voir selon vos préférences mais sachez que les trois fonctionnent en tout cas.

```
unset index_array
unset index_array[*]
unset index_array[@]
```

Voilà je pense qu'on va s'arrêter là pour les tableaux évidemment il y a plein d'autres manipulations qu'on peut faire aussi.

Il y a peut-être quand même quelque chose qu'il faut j'aborde parce qu'on le voit quand même très souvent en programmation et je me doute que des gens vont me poser la question en commentaire donc si on peut le montrer en vidéo ce sera fait.

## Tableau à double dimensions

Le principe qui revient très souvent c'est de créer par exemple un tableau à double dimension, notamment un tableau à deux dimensions.

C'est quelque chose qui est pas mal.

Vous n'avez pas de syntaxe direct pour indiquer par exemple ce tableau je veux qu'il soit en deux dimensions comme on le ferait dans d'autres langages de programmation.

Si il y en a qui font du C et autres tel que Java vous savez comment faire un tableau à deux dimensions même à n dimension c'est assez simple à faire syntaxiquement parlant.

Ici pour un tableau à deux dimensions parce qu'après pour un tableau à n dimensions ça revient faire du bricolage et au pire si vous voulez le faire vous vous amuserez à bricoler ça de votre côté comme exercice et vous verrez que Bash n'est pas forcément fait pour ça non plus mais vous pouvez éventuellement utiliser le système du tableau associatif pour réaliser votre tableau à deux dimensions.

Résumé déjà côté théorique, le tableau à 2 dimensions je rappelle on va travailler sur un ensemble d'indice double c'est à dire qu'on va avoir non pas un seul indice pour les éléments du tableau mais en réalité deux alors on va faire une matrice et indiqué par exemple.

```bash
#!/bin/bash

# 1 2 3
# 4 5 6
```

Voilà ceci est un tableau à deux dimensions donc une matrice, nous avons 2 lignes et nous avons 3 colonnes d'accord "1" c'est le tout premier élément de la matrice et "6" c'est le tout dernier.

Si je veux récupèrer le "1", son indice c'est `[0][0]`.

Pour le 2, c'est `[0][1]` puisqu'on ne change pas la ligne donc c'est la ligne d'indice 0 mais comme c'est la deuxième colonne c'est l'indice 1.

Pour le chiffre 3, c'est `[0][2]`.

Si je veux récupérer le 4 on change de ligne c'est la suivante la deuxième soit l'indice 1 rappelez vous que le premier commence à l'indice 0 c'est pour ça que c'est décalé et ici c'est la première colonne donc indice 0, `[1][0]` et ainsi de suite jusqu'à terminer par `[1][2]` qui est le dernier élément.

Alors ici en Bash, on a pas moyen forcément de spécifier un double indices par contre grâce aux tableaux associatif mais rien ne vous empêche de spécifier des clés un petit peu comme vous voulez donc on peut très bien faire en Bash ce genre de choses-là `[1:2]` au lieu de `[1][2]`.

Ici si je veux déclarer ce tableau là avec ma syntaxe ici de tableaux associatif, on va faire comme ceci pour ce tableau-là.

```bash
#!/bin/bash

# [1:2]

# 1 2
# 4 5

declare -A assoc_array=([0:0]=1 [0:1]=2 [1:0]=4 [1:1]=5)
echo ${!assoc_array[@]}
echo ${assoc_array[@]}
```
```
sam@DESKTOP-7QM88LH MINGW64 ~/Desktop
$ ./main.bash
0:0 0:1 1:1 1:0
1 2 5 4
```

Voilà on a les indices `0:0 0:1 1:1 1:0` mais on peut faire ça comme ça `[0-0]=1 [0-1]=2 [1-0]=4 [1-1]=5`, on fait comme on veux mais c'est juste que si on fait ça `[11]=5` on aurait tendance à penser que c'est l'indice 11 plutôt que la 1ère dimension et la deuxième dimension.

Voilà on peut très bien simuler un tableau à deux dimensions de cette manière-là.

Au final ça revient sans problème à pouvoir éffectuer des manipulation comme vous le feriez sur un tableau à deux dimensions.

Voilà donc ça reste quand même un peu du bricolage d'accord alors on n'a pas de notation native en tout cas pour pouvoir faire un tableau à deux dimensions mais avec le système des clés de notre tableau associatif, on peut parfaitement utiliser des valeurs de clés on va dire suffisamment explicite pour avoir cette simulation de tableau à deux dimensions ou plus si vous voulez vous amuser avec un tableau à n dimensions, allez-y vous pouvez mettre `[0:0:0:0]=1` mais après encore une fois ça devient vite du bricolage et le but quand même c'est d'avoir quelque chose de clair, de fonctionnelle et de facile à comprendre et pas de vous perdre un petit peu dans des syntaxes un peu confuse.

On va pouvoir s'arrêter là, je pense qu'on a fait le tour puisque prochainement nous allons aborder ensemble les fonctions, on va voir beaucoup beaucoup de choses à voir aussi.

On va revenir sur énormément de syntaxe qu'on a vu précédemment.

Une fois qu'on aura terminé la prochaine séance sur les fonctions et bien ce sera la fin du cours voilà une petite vidéo de conclusion comme je le fais habituellement et vous aurez terminé cette formation en tout cas au niveau de la partie cours sur GNU Linux et vous aurez largement de quoi faire vos scripts et après continuer à apprendre d'autres d'autres choses parce qu'il y a évidemment plein d'autres commandes, pleins d'autres fonctions qu'on n'aura pas abordé dans le cours.

Il y a des choses qui seront en annexe bien sûr, dans les tutoriels et bien sûr il y aura quelques petits exercices qui sont proposés pour pouvoir vous exercez éventuellement mais encore une fois n'attendez pas après 1000 exercices ou autre.

N'hésitez pas à vous exercez de votre côté tout ce que vous avez déjà jusqu'à présent comme matières sur lesquelles travailler, il y a largement de quoi faire et c'est assez rapide à mettre en place.

A bientôt pour une prochaine vidéo sur la chaîne et e, attendants n'ésitez pas à vous entraîner et bon codage bien sûr sur GNU Linux.

Ciao 