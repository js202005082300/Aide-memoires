# [37. Fonctions](https://www.youtube.com/watch?v=Bye1ez_7K4E)

Bonjour tout le monde on se retrouve pour cette séance 37 pour parler des fonctions c'était ce qui était prévu pour la suite de cette formation.

La dernière fois on avait abordé ensemble les tableaux qu'était une autre forme pour mémoriser plusieurs informations et non pas qu'une seule comme on peut le faire avec une variable.

Ici on va voir comment créer des fonctions et vous verrez ensuite que vos fonctions vont se comporter comme n'importe quelle commande que vous utilisez nativement issus de Bash ou d'autres Shell éventuellement et vous allez pouvoir créer comme ça vos propres fonctions, les utiliser dans d'autres programmes et on va regarder comment tout cela s'articule en termes de syntaxe évidemment et on va à nouveau revenir sur certaines syntaxes que vous connaissez déjà.

C'est un petit peu le principe et tout ce que vous avez encore une fois vu précédemment va vous reservir maintenant pour cette séance.

On va repasser repartir en tout cas sur un script basique avec rien dedans.

```bash
#!/bin/bash

```

## Déclaration

On va regarder ensemble comment définir, comment déclarer, on va déclarer, on va créer une fonction.

On a deux syntaxe principal pour pouvoir le faire.

Une syntaxe un peu plus anciennes qui est `function` et ensuite on va choisir un nom à cette fonction d'accords par exemple `function say_hello{}`, on va utiliser les accolades d'accord pour pouvoir indiquer toutes les informations mais nous on va faire usage d'une syntaxe un peu plus moderne qui se rapproche notamment du langage c càd que vous allez avoir directement le nom de votre fonction et en plus on a pu voir ici indiquer plus tard on verra des paramètres, `say_hello(){}`.

```bash
#!/bin/bash

say_hello()
{

}
```

C'est plus pratique à utiliser comme je vous l'expliquais la dernière fois pour les tableaux, moins de choses à marquer donc moins on va dire d'erreur possible à ce niveau là.

Voilà le format basique d'accord pour ce genre de fonction.

Alors cette fonction, on va dire Hello, je pourrais mettre les doubles quotes voilà comme ceci.

```bash
#!/bin/bash

say_hello()
{
    echo "Hello !"
}
```

Si j'avais bien sûr sur toute une seule et même ligne plusieurs instructions, je vous rappelle qu'il faut utiliser le point virgule d'accord quand on veut mettre plusieurs instructions, plusieurs commandes sur une seule ligne comme on le fait par exemple pour une condition, une boucle.

```
say_hello()
{
    echo "Hello !";
}
```

Quand vous ne voulez pas forcément passer à la ligne, n'oubliez pas que le point virgule le permet et ça fonctionnera bien évidemment ici au niveau des fonctions.

## Appel

Voici une fonction définie et maintenant au niveau de son appel, c'est tout simplement par son nom.

```bash
#!/bin/bash

say_hello()
{
    echo "Hello !"
}

say_hello
```

Rappelez-vous c'est ce que vous faisiez avec n'importe quelle commande interne au niveau de Bash, vous utilisez son nom et éventuellement vous pouvez après indiquer ses arguments d'accord les arguments ce sont en fait les paramètres que peut éventuellement attendre cette fonction.

`say_hello` n'a aucun argument à passer et en faisant juste son appel tel quel on va pouvoir tout  simplement l'exécuter.

```
$ ./main.bash
Hello !
```

Voilà cette fonction qui dit Hello ! tout simplement.

Vous voyez c'est assez simple, pas de problématique à ce niveau là.

## Local

Une petite règle et quelques petits détails à savoir qui sont très importants parce que ça va vous éviter beaucoup beaucoup d'erreurs.

Première chose je peux effectuer l'appelle ici à cette fonction say_hello parce qu'elle est connue d'accord au niveau de l'exécution de mon programme elle est parfaitement connue c'est à dire que sa définition est faite donc elle est placée au niveau du code avant usage, utilisation de cette fonction.

Si je procède de cette manière, ça ne fonctionnera pas d'accord.

```
say_hello

say_hello()
{
    echo "Hello !"
}
```

Il faut obligatoirement que la définition d'une fonction soit fait avant son appel puisqu'elle est censée être connue au moment de son appel.

Par contre contrairement à certaines vieilles conventions dans d'autres langages de programmation, il n'y a pas obligation de tout mettre en début de code.

Vous n'êtes pas obligé de mettre toutes vos fonctions définies au tout début du code sauf si vous le faites volontairement parce que vous voulez apporter un côté lisibles ou organisez votre fichier de telle façon.

Après c'est vous que ça regarde mais il n'y a pas d'obligation d'accord pour le faire.

Simplement qu'à partir du moment où vous voulez faire appel à une fonction que vous avez créé, il faut forcément que sa création ait été faites avant son appel.

Alors ça c'est une première règle très importante.

Maintenant autre information utile au niveau des variables puisqu'on a déjà jusqu'à présent manipulé des variables, on a même vu comment créer des tableaux mais on avait ici le corps de notre fichier donc de notre fonction principale, notre contexte principal au niveau de l'exécution de notre script.

Comment cela se passe au niveau des fonctions ?

Déjà petit rappel très important par défaut en Bash les variables sont toutes **globales** d'accord c'est à dire que si je crée une variable ici `data=4` d'accord ou mieux que je fais un `declare -i data=4` pour avoir ici une variable qui va mémoriser un entier d'accord.

```bash
#!/bin/bash

declare -i data=4
```

Je peux l'appeler, l'utiliser partout d'accord elle est globale par défaut.

Si vous voulez éventuellement dans une fonction avoir des variables qui sont locales à notre fonction.

Locale ça veut dire qu'une variable que je vais créer dans la fonction say_hello ne pourra pas par exemple être accessible en dehors de cette fonction.

Nous allons pour cela pouvoir utiliser une autre commande interne donc on connait très bien une autre commande interne `declare` tel qu'on l'a fait pour les tableaux, on l'a fait pour définir un certain type de variables, hé bien ici on a un autre mot, une autre commande qui fonctionne d'ailleurs avec les mêmes arguments qui s'appelle `local` d'accord.

`local` pour créer une information locale et on peut par exemple créer une valeur entière de cette manière là.

```bash
#!/bin/bash

say_hello()
{
    local -i data=14
    
    echo "$data"
}

say_hello
```
```
$ ./main.bash
14
```

La fonction ne dit plus vraiment bonjour mais peu importe, c'est pour montrer un petit peu le principe au niveau de la portée des variables et on a bien le résultat ici.

Si maintenant j'essaye de faire l'appel et puis un echo.

```bash
#!/bin/bash

say_hello()
{
    local -i data=14
    
    echo "$data"
}

say_hello
echo "$data"
```
```
$ ./main.bash
14

```

On voit que `"$data"` n'est pas accessible.

Par contre ce qu'il faut également savoir parce que ça ça peut être aussi source d'erreur et en fonction des langages de programmation, la portée des variables n'est pas la même d'accord ça ne suit pas les mêmes règles partout.

Si je viens à faire appel à une autre fonction other_func() admettons avec d'autres informations, argument dans une fonction par exemple qui ferait la somme de deux nombres voilà 12+26.

```
say_hello()
{
    local -i data=14

    other_func 12 26
    
    echo "$data"
}
```

Voilà cette fonction other_func() qui serait définie ailleurs aura accès aux variables qui sont indiqués locales ici.

En fait ça veut dire qu'elle est locale au contexte de cette fonction donc tout ce qui est finalement écrit d'accord tout ce qui est en fait à l'intérieur de cette fonction.

Comme l'appel à other_func() est fait à l'intérieur de say_hello() alors elle aura accès à data.

Voilà ça c'est important de savoir parce qu'on a l'impression que ça va être accessible seulement dans say_hello mais pas dans une fonction où l'on fait un appel et pourtant c'est le cas avec cette commande interne.

Alors ça il faut le savoir pour ne pas se tromper, pour éviter bien des fois de s'amuser a déclarer tout en global, pour ne pas s'embêter.

Il y a des moments si on veut être un peu plus précis, un peu plus rigoureux on va dire dans ses scripts c'est des fois plus intéressant de créer des données locales qui n'ont pas forcément besoin d'être appelées en dehors parce qu'on n'a pas envie de cela.

Ainsi on peut préciser un petit peu plus les choses au niveau des définitions de cette manière.

Voilà pour en tout cas un premier élément qu'il fallait connaître, très important pour la portée des variables il y a pas mal d'informations comme ça à connaître.

Alors je rappelle bien sûr comme j'avais dit que `local` fonctionnait au niveau des arguments comme `declare` et si on veut créer par exemple un tableau rappelez-vous voilà ça fonctionne exactement pareil d'accord c'est comme si on remplacait declare par local et on peut utiliser un peu les mêmes arguments pour créer des données précises.

```
say_hello()
{
    local -a arr=(1 2 3)

    other_func 12 26
    
    echo "$data"
}
```

C'est simplement que `declare` va faire une déclaration tel quel donc en fonction de l'endroit où on l'a fait et bien ce sera pris en compte comme étant global puisque je vous ai dis que par défaut c'est globale et avec `local` c'est pour préciser que c'est bien locale, voilà donc c'est dans cette fonction et pas en dehors.

Voilà pour ces informations en tout cas.

Alors une fonction si vous comprenez, vous l'avez vu de toute façon avec tout ce que vous avez fait en Bash ça nous permet d'utiliser plusieurs fonctionnalités sans devoir les refaire nous mêmes c'est à dire qu'à tout moment quand je veux afficher un texte par exemple en console là juste à faire ça `echo "Bonjour"` d'accord.

J'ai pas besoin de créer une fonction pour pouvoir afficher ce texte.

D'accord une fonction va permettre de rassembler certaines instructions qu'on aurait éventuellement besoin de répéter au sein d'une même boîte, pour que vous voyez visuellement, et à partir de là on aura accès à cette dernière par appel en tout cas comme une simple commande ici `echo` et éventuellement par des arguments "Bonjour". 

C'est pour ça qu'on peut faire plein de choses.

`declare` c'est également une commande interne d'accord derrière il y a des fonctions et ainsi de suite.

Voilà ça me permet d'utiliser beaucoup beaucoup de choses.

Généralement quand on a de la répétition de code, quand on veut pouvoir réutiliser certaines instructions même éventuellement dans d'autres scripts, on va créer une fonction une fois pour toutes et après on a plus qu'à appeler cette dernière comme une simple commande pour pouvoir réaliser des opérations bien précise.

Voilà l'utilité en tout cas des fonctions et quand vous vous amuserez à faire des scripts un petit peu plus conséquent, très vite vous comprendrez l'intérêt de l'usage justement de fonction.

Plutôt que de répéter du code un certain nombre de fois, vous avez une des fonctions qui sépare bien les tâches.

Après la règle d'usage et les recommandations qu'on peut donner à ça, faites des fonctions assez courtes d'accord.

Généralement une fonction se contente de remplir une tâche d'accord.

On ne va pas faire une fonction qui va faire trois, quatre, cinq choses à la fois d'accord.

Une fonction pour une tâche et c'est mieux d'avoir plusieurs fonctions où chacune a une responsabilité qui lui est propre plutôt que d'accorder plusieurs responsabilités à une seule et même fonction et de l'agrandir et que ce soit beaucoup plus compliqué pour la maintenance, pour la corriger, la mettre à jour, etc, etc.

Voilà pour ces quelques petites informations.

## Paramètres

Jusqu'à présent nous avions vu une fonction très simple qui ne faisait qu'un simple affichage.

```bash
#!/bin/bash

say_hello()
{
    echo "Hello !"
}

say_hello
```

C'est pas mal d'avoir aussi une fonction qui prend des arguments donc une fonction pour qui on a défini des paramètres d'accord.

```bash
#!/bin/bash

print_number()
{
    echo "Hello !"
}

print_number 5
```

Au niveau de Bash quand on fait appel avec des éléments par exemple à la suite on l'a vu précédemment, `./main.bash 15 64`, on va avoir une liste d'arguments qui sont donnés ici à notre fonction.

Ces derniers vont se représenter comme précédemment de cette manière avec `$*` vous allez avoir l'ensemble des arguments passé et
ensuite avec par exemple `$1` `$2`, vous allez avoir l'ensemble des arguments d'accord à la suite.

```bash
#!/bin/bash

# $* $1 $2 $3
```

On peut appliquer les mêmes opérations, on avait vu la dernière fois par exemple qu'on pouvait faire du décalage d'ailleurs ça quand on arrive après $9 on peut décaler.


Voilà tout ce qu'on avait vu avec la commande `shift` notamment peut parfaitement s'appliquer ici d'accord donc là on a un seul argument que l'on passe donc moi je vais faire `$1` directement.

```bash
#!/bin/bash

print_number()
{
    echo "$1"
}

print_number 5
```
```
$ ./main.bash
5
```

Voilà on a l'affichage de 5 très simplement.

Si je veut afficher une autre valeur admettons un `$2`, elle va attendre un autre argument.

```bash
#!/bin/bash

print_number()
{
    echo "$1 $2"
}

print_number 5
print_number 5 233
```
```
$ ./main.bash
5 
5 233
```

Alors automatiquement, on a l'affichage qui se fait d'accord.

Ils se mettent toujours à la suite.

Je vais passer très vite là dessus puisque on l'a déjà expliqué dans une autre vidéo alors pas concernant les fonctions mais concernant les arguments lors de l'appel d'un script mais c'est exactement la même chose.

N'oubliez pas non plus que le `$0`, c'est le nom du script d'accord l'exécutable en tout cas du programme que vous avez appelé ici.

```bash
#!/bin/bash

print_number()
{
    echo "$0"
}

print_number 5 233
```
```
$ ./main.bash
./main.bash
```

Voilà donc on retrouve exactement les mêmes règles pas compliqué et à partir de là, on peut parfaitement en fait récupérer toutes les informations tels qu'on les a déjà vus.

Par exemple si vous voulez faire des calculs par exemple faire la  somme de deux nombres eh bien vous passez les deux nombres à l'appel et vous faites la somme de `$1` et `$2`.

Maintenant autre point on a vu pour définir une fonction, pas de problème, définir une fonction et utiliser éventuellement des arguments ici `print_number 5 233` qui seront donc traitées comme des paramètres dans cette fonction, pas de problème.

## Return

Il y a aussi une chose qui est très importante et très intéressante au niveau des fonctions, c'est la possibilité de pouvoir retourner une information d'accord.

Jusqu'à présent je vous avais expliqué que nos commandes qui finalement sont des fonctions vont retourner un code.

Ce code peut prendre la valeur 0 à 255, ça c'est important de le savoir.

```bash
#!/bin/bash

# 0 à 255
```

Et ce code permet en fait de savoir comment s'est passé le déroulement de cette fonction c'est à dire dans la manière où a été définis une fonction le développeur aura choisi de dire si il s'est passé telle chose alors généralement on choisi 0 dans le cas où il n'y a pas de problème d'accord pour dire que voilà ça a fonctionné avec succès pas de souci.

Si admettons par contre qu'on a une fonction qui veut ouvrir un fichier, je prends un exemple tout bête et la personne peut décider bon je vérifie que le fichier existe et s'il n'existe pas eh bien je renvoie un code d'erreur par exemple le code 13.

Le code 13, on décide que c'est ce code qui indique que le fichier n'existe pas d'accord.

Eh bien on va pouvoir récupérer cette information ce numéro 13 et éventuellement pouvoir comme ça agir en conséquence au niveau de notre script.

On a besoin d'avoir parce qu'on ne peut pas en fait s'assurer qu'une fonction fera ce qu'on lui demande correctement, est ce qu'elle a pu le faire parce que dans le cas par exemple d'ouverture d'un fichier on comprend que c'est pas un scénario qui va fonctionner et qui sera va dire fonctionnelle à 100% parce que si le fichier en question n'existe pas, vous ne pourrez pas ouvrir un fichier qui n'existe pas.

Ainsi automatiquement on ne peut pas assurer qu'une opération se fera avec succès donc on peut se servir de ces codes d'erreurs  éventuellement pour indiquer voilà un problème bien précis.

Au niveau des fonctions dans le cas où vous ne faites aucun retour, c'est un peu d'ailleurs ce qu'on a avec notre fonction d'accord nous allons récupérer le code de retour de la dernière commande exécutée.

Moi donc en l'occurrence si je fais ça avec notre exemple de hello().

```bash
#!/bin/bash

# 0 à 255

hello()
{
    echo "Hello !"
}

hello
```
```
$ ./main.bash
Hello !
```

On affiche le texte pas de problème.

Si maintenant je fais un `echo` de `$?`.

```bash
#!/bin/bash

# 0 à 255

hello()
{
    echo "Hello !"
}

hello
echo $?
```
```
$ ./main.bash
Hello !
0
```

Voilà le zéro qu'on récupère ici c'est tout simplement le code de retour de la dernière commande qui a été exécutée donc ici on a eu `echo` d'accords qu'est la commande exécuté.

Maintenant on a peut-être envie de retourner nous-même un code càd que par défaut ça retourne le code de la dernière commande exécuté.

Nous on aura peut-être envie manuellement alors là on considère que la fonction fait son `echo` et après il va donc considérer que tout s'est bien passé donc je vais manuellement choisir de retourner une valeur.

Alors je ne vais pas faire un return de zéro sinon on  ne verra pas la différence, je vais choisir volontairement de retourner par exemple 8 d'accord.

On utilise pour cela une commande interne qui s'appelle `return` tout simplement qui va permettre de stopper la fonction d'accord on va stopper l'exécution c'est à dire que si je remets autre chose derrière ici ça ne sera pas exécuté.

```bash
#!/bin/bash

# 0 à 255

hello()
{
    echo "Hello !"
    return 8
    echo "bla bla"
}

hello
echo $?
```
```
$ ./main.bash
Hello !
8
```

"bla bla" ne serra pas exécuté puisque à partir du moment où il y a un `return` qui est rencontré on sort de la fonction et on revient ici à l'endroit où on était en fait au niveau de l'exécution  d'accord.

Automatiquement on voit que le code de retour change d'accord donc `$?` c'est une variable spéciale comme `$#`, `$*`, etc voilà c'est un cas spécial et à chaque fois qu'on a un code de retour qui est récupèré, il est mémorisé dans cette variable spéciale ok.

Voilà pourquoi le `return` implicitement va stocker cette valeur 8 dans cette variable.

On n'a pas besoin de le faire manuellement d'accord c'est la commande interne `return` ici qui le fait toute seule de manière automatique donc ça c'est très pratique pour pouvoir vérifier encore une fois le fonctionnement d'un traitement d'opérations, d'instructions ou simplement quand on manipule simplement et qu'on fait appel à des commandes interne de vérifier qu'elles ont bien  marchées.

Voilà dans un cas d'erreur spécifique vous allez avoir un code de retour différent et on peut gérer ça en fonction d'accord.

On peut donc parfaitement par exemple comme on savait le faire je ne vais pas le noter en terme de code mais plus en terme d'algorythme de dire qu'on a ici une fonction qui est censé faire quelque chose d'accord some_function().

```bash
#!/bin/bash

# 0 à 255

some_function()
{
    # Si condition A pas remplie
        return 2
    # fin si

    # Si condition F pas remplie
        return 13
    # fin si

    return 0
}

some_function
echo $?
```

Voilà dans cette fonction on aurait la condition si A n'est pas validé, on fait un `return 2` puis on faire d'autres vérifications admettons que F n'est pas rempli voilà on rencontre un autre cas d'erreur où cette fois ci on ferra un `return 13`.

etc, etc.

En fonction, à l'affichage de `$?` on sera capable de savoir par exemple ici à quel moment cette fonction est quittée càd que s'il n'y a pas eu de problèmes éventuellement on pourra dire à la toute fin on `return 0` d'accord.

Automatiquement avec un simple affichage de `$?` je saurai où la fonction s'est arrêté.

Si je récupère un 0 c'est que tout s'est bien passé par contre si je récupère 2 voyez il n'y a pas besoin de chercher où est-ce que ça a planté, où est ce qu'il y a un problème puisque normalement tel que j'ai conçu mon code, je saurai à quel moment et dans quel cas, sous quel condition je retourne ce code là.

Voilà donc ça permet d'avoir une certaine nomenclature par exemple dans une fonction, c'est très pratique et c'est ce qu'on fait notamment pour les langages de programmation qui n'ont pas de  système d'exception.

Vous savez qu'un système d'exception si vous programmez dans d'autres langages ça permet d'interrompre l'exécution d'un programme d'accord en envoyant un type d'exception que l'on peut ensuite traiter.

A l'époque ou en tout cas dans les programmes qui n'ont pas cette fonctionnalité-là, on utilisait le principe des codes de retour c'est à dire qu'on définit une fonction et on lui permet de retourner dans tous les cas quelque chose même si tout s'est bien passé, on retourne forcément quelque chose d'accord et ça nous permet ensuite quand on fait l'appel de cette fonction de vérifier ce retour, le retour de la fonction et de savoir si elle a bien fait des choses ou pas.

Si la fonction l'a bien fait très bien on continue de faire l'exécution et sinon en fonction de l'erreur, on voit si on peut continuer l'exécution du programme ou on adapte cette exécution sinon on stoppe le programme parce qu'on considère que l'erreur qui a été engendrée par l'appel de notre fonction précédemment ne permet plus d'exécuter la suite du code parce qu'on aurait peut-être un plantage de la machine ou autres et forcément on ne veut pas de ce genre de scénario voilà.

Voilà ça permet d'avoir une nomenclature et de mieux gérer un petit peu tout ça donc sachez que vous pouvez avoir plusieurs instructions `return` d'accord plusieurs commandes `return` dans une seule fonction mais il y en aura forcément qu'une seule qui sera appelée parce que dès lors qu'une seule de ces commandes est exécutée, on sort de la fonction donc là on ne pourra pas exécuter à la fois `return 2`, `return 13` et puis après `return 0`.

Ce sera forcément qu'un seul des trois donc ça c'est important de savoir pour éviter pas mal de confusion pour la suite ok.

Ecoutez au niveau des fonctions il n'y a pas tellement d'autres choses à savoir, après on peut faire quelques petits outils sympathique, on va revenir sur la commande `declare` puisqu'on a vu on a vu beaucoup de choses avec elle, beaucoup d'arguments et on va pouvoir compléter nos informations.

## Source

On peut parler un peu d'introspection mais avant on pourrait avoir envie de faire plusieurs fichiers d'accord de répartir un programme en plusieurs fichier, on n'est pas forcément obligé de tout mettre dans un seul et si vous voulez faire ça vous pouvez aussi inclure un fichier dans un autre c'est à dire pouvoir utiliser le code d'un autre fichier d'accord dans celui-ci.

Pour le faire très simplement et la manière la plus simple c'est d'utilisez le mot `source` et vous indiquer tout simplement votre fichier.

Alors ici vous avez vu que les fichiers en question n'ont pas d'extension donc ça peut être par exemple.

```bash
#!/bin/bash

source otherfile

some_function
echo$?
```

Par exemple `source otherfile` et ainsi que tout ce que j'aurais fait dans ce fichier-là si admettons j'ai une autre fonction qui existe dans celui-là et hop je peux appeler la fonction some_function() qui serait alors définie dans ce fichier.

Voilà on peut faire ce genre de choses c'est pas mal pratique ça permet de travailler avec plusieurs fichiers donc pourquoi pas.

## Declare f

Je vais terminer en fait cette petite séance en revenant notamment sur des commandes qu'on a vu précédemment, sur quelques petits outils assez intéressant qui peuvent servir.

Alors je vais créer quelques fonctions très simplement.

```bash
#!/bin/bash

some_func()
{
    echo "Hello !"
}

other_func()
{
    echo "Bonjour !"
}

last_func()
{
    echo "Konnichi wa !"
}

declare -f
```

Voilà on a 3 fonctions définies, je vais pouvoir indiquer avec `declare` notamment le listing de ces fonctions c'est à dire qu'avec cette commande là on a vu plein d'arguments rappelez-vous ça me permet de créer des tableaux, on peut l'utiliser également pour créer différents types de données.

Créer diffèrents type de données en fait il n'y a pas d'autre d'autres cas après on a `local` rappelez-vous si on veut ne pas avoir des données globales, éventuellement.

On va pouvoir se servir de `declare` pour faire un petit peu
d'introspection par exemple au niveau de mon programme, de pouvoir récupérer la liste des fonctions c'est à dire que je peux sans problème faire ceci `declare -f`.

```
$ ./main.bash
last_func () 
{ 
    echo "Konnichi wa !"
}
other_func ()
{
    echo "Bonjour !"
}
some_func ()
{
    echo "Hello !"
}
```

Voilà ce que nous avons d'accord on récupère les différentes informations donc là on va récupérer le nom des fonctions définies et en plus on va récupérer le corps de ces fonctions c'est à dire leur définition.

Si on veut récupérer que leur nom vous mettez un petit f majuscule d'accord `declare -F`.

```bash
#!/bin/bash

some_func()
{
    echo "Hello !"
}

other_func()
{
    echo "Bonjour !"
}

last_func()
{
    echo "Konnichi wa !"
}

declare -F
```
```
$ ./main.bash
declare -f last_func
declare -f other_func
declare -f some_func
```

Voilà ça vous indique un petit peu tout ce qui a été fait ici.

Alors pourquoi ça vous met toutes ses lignes simplement parce qu'il indique en fait tout ce qu'il a fait c'est à dire que normalement je pourrais très bien par exemple faire ça `declare -f last_func` et d'avoir qu'une seul retour.

```bash
#!/bin/bash

some_func()
{
    echo "Hello !"
}

other_func()
{
    echo "Bonjour !"
}

last_func()
{
    echo "Konnichi wa !"
}

declare -f last_func
```
```
$ ./main.bash
last_func () 
{ 
    echo "Konnichi wa !"
}
```

Voilà on peut parfaitement passer en deuxième argument le nom de la fonction en question donc si vous avez besoin de demander dans un script de savoir qu'est-ce qui est présent en fait on peut faire ce genre de choses-là.

On peut d'ailleurs le faire par rapport à un fichier mais là au niveau de ça, on peut avoir comme ça une liste d'accords des fonctions qu'on a dans notre programme.

Voilà donc ça peut servir si à un moment donné, vous voulez faire un menu d'aide pour l'utilisation d'un de vos programmes, de vos scripts puisque c'est sûrement l'application que vous aurez le plus au niveau de Bash, c'est la création de scripts.

Vous aurez donc peut-être besoin de faire un petit manuel pour expliquer comment l'utiliser ça peut être pas mal utile d'avoir ce genre de chose-là.

Ce qui peut servir aussi éventuellement c'est des cas plus rares mais c'est bien de savoir puisque c'est aussi des choses qu'on a déjà vu mais c'est histoire de vous montrer qu'encore une fois ça peut s'appliquer à plein d'autres choses, c'est la commande `unset`.

Rappelez-vous la commande `unset` nous permettait de supprimer donc de détruire en fait une variable, de supprimer un tableau d'accord on peut également s'en servir pour une fonction à condition bien sûr d'indiquer l'arguments f minuscule, `unset -f`.

```bash
#!/bin/bash

some_func()
{
    echo "Hello !"
}

other_func()
{
    echo "Bonjour !"
}

last_func()
{
    echo "Konnichi wa !"
}

declare -F
unset -f last_func
echo ---
declare -F
```
```
$ ./main.bash
declare -f last_func
declare -f other_func
declare -f some_func
---
declare -f other_func
declare -f some_func
```

Au début on en a 3 et ensuite il n'y a plus que 2 donc on a bien last_func() qui n'existe plus, qui a été détruite par cette commande `unset` donc ça fonctionne aussi et ça encore une fois n'hésitez pas à le faire en Bash, à manipuler un peu toutes les commandes que vous avez pu voir parce que vous allez voir que ça peut fonctionnant dans pas mal de choses.

Alors pareil au niveau du cours je ne vous aurais pas montré 100% des arguments qu'on peut utiliser d'accord pour chacune des commandes qui existent que ce soit nativement en Bash.

Il y a des commandes qui ont été ajoutées par les versions ultérieures et les extensions voire même d'autres Shells que Bash parce que peut-être qu'un jour vous utiliserez un autre que Bash et qui proposera d'autres fonctionnalités.

Voilà donc n'hésitez pas bien sûr à vous intéresser un peu à tout ça, à avoir cette curiosité-là parce que vous trouverez pas mal pas mal de commandes qui peuvent être utilisés un peu à droite à gauche et c'est aussi le principal, l'usage justement de ces différentes  commandes.

Je pense qu'on va pouvoir s'arrêter-là.

Voilà on a tout ce qu'il faut au niveau des fonctions pour en faire usage pour en créer, pour faire vos propres commandes.

Après de toute façon, on peut toujours bricoler plein d'autres choses.

Je pourrai montrer tout un tas d'autres petites subtilités syntaxiques et vous aurez sûrement l'occasion de les découvrir aussi et on ne peut pas tout aborder de toute manière c'est toujours pareil.

Malheureusement on ne peut pas tout aborder ce serait beaucoup beaucoup trop long et surtout pas utile ça ne sert à rien d'énumérer tout ce qu'on peut faire, aucun intérêt c'est bien de le découvrir par soi même quand on en a besoin.

Voila voila je vous dis à très bientôt pour la suite et fin de ce cours puisque c'était la dernière vidéo d'apprentissage.

Maintenant place prochainement à la vidéo de conclusion en tout cas pour terminer gentillement cette petite formation.

J'espère que ça vous aura plu et que ça vous aurez appris beaucoup beaucoup de choses.

N'hésitez pas bien sûr encore une fois à consulter un peu tout ce qui se fait sur la chaîne par rapport à ce cours ou à d'autres.

Je vous dis à bientôt pour de nouveaux contenus et voilà prenez soin de vous et n'hésitez pas à vous exercez à tout ça.

Vous avez largement de quoi faire maintenant pour réaliser vos petit script et pourquoi pas les partager, le Discord est là aussi pour ça.

A bientôt tout le monde.

Bye bye