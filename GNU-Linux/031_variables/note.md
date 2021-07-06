# [31. Variables](https://www.youtube.com/watch?v=2Nr5RfsiRrQ)

Bonjour et bienvenue sur cette 31ème séance GNU linux, on va continuer suite à l'introduction qu'on a fait à la programmation de scripts bash avec une première notion très importante qu'on retrouve en programmation càd les variables.

Pour faire très simple les variables vont nous permettent de mémoriser des informations durant l'exécution de nos programmes, vous avez vu précédemment quand on faisait par exemple de l'affichage on affichait une donnée brute inscrite directement dans le code ou quand on la tape directement sur la console, sur le terminal mais on n'a rien de mémorisé.

Quand on va avoir un programme, on va avoir un ensemble de commandes, plusieurs commandes à exécuter et on aura besoin par la suite de garder en mémoire en fait des informations tout au long de l'exécution du programme pour faire des calculs, faire d'autres affichage, demander des informations, les extraire de commandes, de fichiers ou de n'importe quoi et restituer ça et travailler avec ces différentes données.

C'est donc le sujet de cette séance, on va regarder tout ça, on ne verra pas non plus toute l'étendue des variables parce que vous allez voir qu'il y a énormément de choses.

Le langage Bash est très flexible, propose pas mal de fonctionnalités, propose différentes syntaxes aussi et différents outils puisque ça regroupe toutes les commandes que vous pouvez utiliser dans la console donc je vais essayer d'aborder pas mal de choses déjà dans cette vidéo.

Il y a des choses qu'on verra dans d'autres séances et une grosse partie également que vous verrez en annexe dans la playlist de tutoriels d'accord vous avez une playlist de tutoriels GNU linux, vous y retrouverez tout un tas de choses, annexe à ce cours, et évidemment des choses annexes à la programmation au niveau des scripts. C'est ce que nous allons voir ici et dans les videos futurs.

On va passer directement sur notre scène et on va faire un fichier classique.

```bash
code main.sh
```

On fait un fichier comme précédemment, on passe par l'éditeur pour que ce soit lisible pour vous.

Voilà je l'enregistre directement, ctrl+S ok.

Et on va remettre la ligne pour utiliser le bon interpréteur à ce niveau là ok, je vais faire un petit `echo` pour voir que le fichier est bon.

```sh
#! /bin/bash

echo OK
```

```bash
sam@sam:~/Documents$ code main.sh
sam@sam:~/Documents$ chmod u+x main.sh
sam@sam:~/Documents$ ./main.sh
OK
```

Parfait c'est bon à ce niveau-là.

Pas de problème, on va regarder comment faire ça alors si vous avez déjà programmé vous savez ce qui est une variable, vous connaissez le concept, qu'est-ce que ça englobe, comment ça fonctionne et cetera ... il n'y a pas de problème.

Evidemment la syntaxe pour Bash va quelque peu changer même beaucoup par rapport à d'autres langages de programmation et pour d'autres vous allez voir que c'est aussi un langage qui propose énormément de syntaxes, de fonctionnalités, qui est très flexible.

On a plusieurs plusieurs types de notation pour faire énormément de choses et je vous rappelle que tout ce que vous avez vu précédemment, les différentes commandes qu'on a vu au niveau de la console sont tout à fait utilisable de manière intégrée dans un script d'accord c'est le même langage donc tout est parfaitement compatible donc il y a énormément énormément de choses mine de rien ne serait ce qu'en termes de possibilités, de fonctionnalités puisque toutes les commandes que vous avez vu font partie de ce langage.

## créer une variable

Première chose que nous allons voir ensemble c'est tout simplement la déclaration de variables, je vous ai expliqué ce que c'était et à quoi ça peut servir et maintenant nous allons voir comment créer une variable au sein de notre code pour mémoriser une information.

Alors on ne va pas mémoriser une information du genre stocker une information dans une variable, ça c'est une manière de dire les choses pour pouvoir l'enseigner, pour que vous puissiez comprendre et bien évidemment tout cela se passe au niveau de la mémoire et je vous passerai le détail de toutes façon à ce niveau-là parce que vous n'avez pas spécialement besoin de savoir ou de comprendre en tout cas cela pour pouvoir utiliser les variables au niveau de la programmation voilà ce n'est pas non plus le but ici.

### nommage

Ce que nous allons faire, première chose à savoir c'est de donner un nom qui va servir d'étiquettes, de label ou tout simplement le nommage pour notre variable.

En plus l'avantage, c'est que ce nom va nous permettre d'identifier éventuellement l'information que l'on y mémorise et ce sera plus facile ensuite pour le manipuler derrière.

Comme pas mal d'autres langages de programmation justement, il y a certaines règles à respecter par exemple de ne pas utiliser bien sûr des espaces dans le nom, je vais mettre par exemple `some data`, je ne peux pas noter par exemple noter une variable de cette manière là, c'est juste pas possible ! 

On peut éventuellement si on a besoin d'écrire plusieurs mots pour le même nom, utiliser le symbole underscore d'accord on peut faire ce genre de choses.

```sh
#!/bin/bash

some_data
```

On ne va pas également utiliser de caractères spéciaux `some_%édata`, des caractères accentués et caractères spéciaux et cetera.

Et on ne mettra pas des chiffres au tout début du nom de la variable d'accord ne serait-ce qu'un chiffre `0some_data` ou des nombres `649some_data`ou n'importe quoi donc on commencera toujours par des caractères c'est à dire des lettres ici d'accord alphabétique.

Petites choses aussi à savoir au niveau du nommage ici c'est ce qu'on appelle en fait la casse au niveau du texte.

Quand on parle en fait ici de sensibilité à la casse et c'est le cas en programmation pout beaucoup c'est tout simplement de distinguer les minuscules par exemple des majuscules.

Ces deux variables si je vous les indiquent comme ceci, sont différentes.

```sh
#!/bin/bash

SOME_DATA
some_data
```

D'accord en programmation, c'est quelque chose qui va être distincts et c'est bien de prendre cette habitude avec l'ensemble des langages de  programmation et c'est aussi une question de visibilité parce que si on avait par exemple la possibilité d'utiliser ces 2 nommages différents finalement pour par exemple indiquer la même chose ou même d'utiliser directement les mêmes ce ne serait pas forcément très pratique pour s'y retrouver en termes de lisibilité donc ceci `SOME_DATA` est différent de ça `some_data` d'accord c'est vraiment deux informations différentes donc attention à ce niveau là je le rappelle parce que dans beaucoup d'autres formations, il y a des gens des fois qui écrivent leurs variables un coup en minuscule, un cou en majuscule et s'étonnent de ne pas retrouver l'information c'est parfaitement normal ce sont deux variables différentes parce que ce ne sont pas les mêmes étiquettes donc on va se contenter de ça ici.

```sh
#!/bin/bash

some_data
```

### initialisation

Voilà on déclare une variable pas de problème et ont va l'initialiser directement avec une valeur.

Pour cela on utilise un opérateur donc un symbole bien précis qui est le égale (=) ici un symbole qu'on retrouve bien sûr dans les mathématiques pas de pas de surprise à ce niveau là et particularités bien sûr **tout doit être attaché**.

```sh
#!/bin/bash

some_data=
```

Là je m'adresse surtout à ceux qui ont déjà programmé dans d'autres langages et qui aurait l'habitude par exemple de mettre le caractère comme ça `some_data = 63` suivi de la valeur affecté par exemple 63 comme ça d'accord ça vous ne pouvez pas le faire au niveau de Bash parce que Bash interprète tout d'accord comme des chaînes qu'il va interpréter c'est à dire que si vous faites ce genre de choses `some_data =63`et bien lui en fait il va penser à une commande d'accord et si vous faites l'inverse `some_data= 63` pareil il va penser à des commandes ou il va penser à des expressions bref dans tous les cas il va l'interpréter de la manière que vous ne voulez pas.

Vous voulez en fait qu'il prennent toute la chaîne au complet d'accord tout ce suit où il considéra en fait une première valeur, un symbole égale, une deuxième valeur.

```sh
#!/bin/bash

some_data=63
```

A partir de là, il saura que là c'est un nom de variable que vous déclarez `some_data` d'accord ensuite ici `=` c'est une affectation et `63` est une valeur que vous affectez à cette variable-là.

Très important j'insiste bien parce que si vous mettez des espaces avant ou après ou les deux vous aurez un petit souci.

## afficher l information

Maintenant nous allons voir très rapidement comment afficher l'information.

On pourrait être tenter de faire ça `echo some_data` comme ça donc ça je crois d'ailleurs que je ne l'avais pas montré dans la séance précédente le fait de ne rien mettre du tout, de mettre juste directement le terme bien sûr ça marche puisque encore une fois je vous ai dit que Bash gère tout comme des Shell c'est à dire qu'il va chercher à interpréter tout ce qu'il trouve et ça automatiquement on s'attendrait à ce qu'il s'adapte et qu'en fait il l'attribue à ça `some_data`.

On va donc faire un affichage pour que voyez un petit peu ce qui se passe, on remarque tel quel qu'il va bêtement afficher le texte comme quelque chose de brut d'accord il le traite tel quel.

```sh
#!/bin/bash

some_data=63

echo some_data
```

```bash
sam@sam:~/Documents$ ./main.sh
some_data
```

En gros ça reviendrait à faire ceci.

```sh
#!/bin/bash

some_data=63

echo 'some_data'
```

Tout simplement donc je peux vous faire à nouveau l'exécution, on obtient la même chose.

```bash
sam@sam:~/Documents$ ./main.sh
some_data
```

Nous le but c'est d'obtenir cette valeur ici `63` d'accor qui est finalement attribuée, assignée à cette variable `some_data` et pour ça nous allons utiliser le symbole dollars qui permet de distinguer `$some_data` et en plus si vous avez un éditeur avec un thème de couleur qui gère un petit peu ce langage et normalement c'est natif sur les éditeurs modernes, vous aurez un changement au niveau de la coloration pour vous indiquer qu'effectivement là on a la données qui va être finalement interprétée différemment.

```sh
#!/bin/bash

some_data=63

echo $some_data
```

```bash
sam@sam:~/Documents$ ./main.sh
63
```

A partir de là avec une nouvelle exécution je récupère bien la valeur.

C'est quand même pas mal pratique donc ça c'est important d'accord.

On a ici je rappelle une déclaration `some_data`, on fait une initialisation `=63` c'est à dire que dès qu'on affecte en fait une valeur au moment de la déclaration, on parle d'initialisation. On lui met une valeur donc là c'est un nombre entier au plus simple `$some_data` et on peut parfaitement  l'afficher de cette manière `echo $some_data`.

On peut également bien sûr afficher un nombre de cette manière d'accord `63.65` ça marche aussi.

```sh
#!/bin/bash

some_data=63.65

echo $some_data
```

```bash
sam@sam:~/Documents$ ./main.sh
63.65
```

Et on pourra bien évidemment afficher un simple caractère.

```sh
#!/bin/bash

some_data='a'

echo $some_data
```

```bash
sam@sam:~/Documents$ ./main.sh
a
```

On peut afficher par exemple notre chaîne de caractères donc ici `Hello World !` il y a plusieurs caractères complète ça fonctionne aussi d'accord.

```sh
#!/bin/bash

some_data='Hello World !'

echo $some_data
```

```bash
sam@sam:~/Documents$ ./main.sh
Hello World !
```

Voilà ça revient à passer sans variable, c'est équivalent tout simplement.

```sh
#!/bin/bash

echo Hello World !
```

Alors généralement c'est plus un conseil que je vous donne d'éviter de noter comme ça du texte de cette manière déjà parce que vous voyez que ce n'est pas très pratique au niveau lisibilité donc on va certainement et très souvent utiliser des caractères précis pour délimiter une chaîne de caractères pour pouvoir s'y retrouver facilement, pourquoi ? 

Parce que vous voyez que quand on utilise des commandes etc et que plus tard on utilisera des fonctions ou autre et bien tout est en fait délimité par des espaces d'accord on a chaque fois une espace ici `echo `, ici `Hello `, ici `World !` et on pourrait penser que `echo` est une commande ou autre et ça rajoute en fait finalement on va dire une complexité au niveau de la syntaxe supplémentaire alors qui n'y pas forcément lieu d'être donc on va plutôt utiliser par exemple `echo 'Hello World !'` ou alors ce que je vous ai déjà montré précédemment `echo "Hello World !"` c'est à dire ce genre de symbole `""` ou `''`.

Par contre vous allez voir que ces symboles, on va dire une différence à l'usage notamment avec l'utilisation de variables, on va aborder ça juste après.

## réaffectation

Je vous ai donc montré comment faire cette déclaration, comment afficher une variable très simplement avec le symbole dollar `$` on va revenir dessus puisque vous aller voir qu'il y a des variables assez particulières qu'on va pouvoir utiliser et on va regarder maintenant simplement comment changer une valeur.

On va reprendre l'exemple de tout à l'heure.

```sh
#!/bin/bash

some_data=63

echo $some_data
```

```bash
sam@sam:~/Documents$ ./main.sh
63
```

Je le réaffiche pour que vous voyez ok on va lui faire une nouvelle affectation c'est-à-dire de modifier la valeur d'une variable c'est quelque chose que vous pouvez faire aussi, vous reprenez tout simplement l'étiquette `some_data` qui vous permet de l'identifier et on réutilise le symbole pour l'affectation et on change voilà la valeur `some_data=144` je peux refaire un écho derrière.

```sh
#!/bin/bash

some_data=63
echo $some_data

some_data=144
echo $some_data
```

```bash
sam@sam:~/Documents$ ./main.sh
63
144
```

On compacte un petit peu tout ça et on va parfaitement changer la valeur ici.

J'aurais même pu faire comme ceci `'hello'` avec ces symboles-là `''` et vous comprendrez un petit peu après pourquoi.

```sh
#!/bin/bash

some_data=63
echo $some_data

some_data='hello'
echo $some_data
```

```bash
sam@sam:~/Documents$ ./main.sh
63
hello
```

Voilà donc on peut passer finalement d'un type de donnée à un autre, pourquoi est-ce que je vous dis ça ? parce que ceux qui font déjà un peu de programmation savent que on va avoir des données sous forme numérique, arithmétique peu importe ça dépend des types.

## quote double quote et anti-quote

Il y a des fois des types un peu plus complexe et on va avoir la chaîne de caractères `'hello'` voir encore une fois le caractère `'h'` d'accord et éventuellement des types encore une fois plus personnalisé qu'on aura l'occasion de voir un petit peu plus tard mais il n'y en pas non plus autant en Bash comme on peut en trouver dans d'autres langages de programmation.

```sh
#!/bin/bash

some_data=63
echo $some_data

some_data='h'
echo $some_data
```

Ici comme on n'indique pas de toute façon le type de l'information d'accord qu'on va mémoriser et bien c'est l'interpréteur qui le déduit.

Voilà si il voit ça `63` il considère que c'est un nombre et si il voit `'h'` il considére que c'est un caractère donc une chaîne même composée ici que d'un seul caractère.

Il fera en sorte à ce niveau là et on peut passer sans problème d'un nombre, même un texte si on veut et voyez que ça ne pose pas de problème il peut l'afficher sans aucun souci à ce niveau voilà donc ça c'est très important et voilà comment vous pouvez modifier la valeur d'une varianble, très simple.

Qu'est ce qu'on peut voir aussi par rapport à ça ? les petites les voilà les différences de syntaxe ici je vais revenir là dessus puisque c'est quelque chose de très très important à partir de maintenant en tout cas d'accord ça l'était peut-être un petit peu moins auparavant mais là ça va être assez important.

Je vais noté `str1=''` comme ça, je vais mettre ceci `str1='Jason'`. Je vais juste mettre mon prénom dans une première variable. Puis une deuxième `str2="Bienvenue !"` et une troisième ``str3=`ls -a` `` pour lequel j'emploi un autre type de quote, les quotes inversées, les anti-quotes dans le quel cette commande qu'on a déjà utilisé dans le terminal donc c'est pas nouveau.

```bash
#!/bin/bash

str1='Jason'
str2="Bienvenue !"
str3=`ls -a`
```

Voilà 3 syntaxe différentes finalement à ce niveau là pourquoi et quel est la différence ? pourquoi on s'embête avec 3 syntaxes différentes alors qu'après tout une seule a priori semble faire la faire.

La première `str1='Jason'` et c'est généralement recommandé pour ça va tout simplement traiter l'information telle qu'elle est c'est-à-dire de manière brute. Pour elle ceci `'` indique le début d'une chaîne d'accord donc d'un texte et ceci `'` marque la fin ok donc tout ce qui est à l'intérieur on le traite comme étant du simple texte d'accord peu importe comment sont présentés les données, je peux même utiliser des symboles par exemple pour indiquer une variable, `ls` soit une commande du Shell, etc `'Jason $data ls -a'` et si je fais un `echo` de str1.

```sh
#!/bin/bash

str1='Jason $data ls -a'
str2="Bienvenue !"
str3=`ls -a`

echo $str1
```

```bash
sam@sam:~/Documents$ ./main.sh
Jason $data ls -a
```

Voilà s'est affichée tel quel d'accord tel que ça a été indiqué pas de nouveauté.

Deuxième particularité pour ce type de quotes `""` donc les doubles quotes donc les guillemets, c'est un cas où on va donc évidemment pouvoir afficher du texte d'ailleurs je peux remplacer les simple quote par des doubles quotes, `"Jason $data ls -a"`.

```sh
#!/bin/bash

str1="Jason $data ls -a"
str2="Bienvenue !"
str3=`ls -a`

echo $str1
```

Voilà par contre là on va avoir un changement.

Vous remarquez que nous allons avoir notre texte et on va voir l'interprétation de nos variable c'est à dire qu'ici il va tout simplement chercher à afficher la valeur de `$data` voyez il va faire référence à l'information donc si je fais ça `'Jason'` puis on cherche à afficher `$str1` comme ça vous verez qu'on peut parfaitement mettre une variable dans la valeur d'une autre, ça fonctionne.

```sh
#!/bin/bash

str1='Jason'
str2="Bienvenue $str1"
str3=`ls -a`

echo $str2
```

On va obtenir ceci.

```bash
sam@sam:~/Documents$ ./main.sh
Bienvenue Jason
```

Voilà ça fonctionne parfaitement bien alors ça affiche le texte sans problème et au moment où il rencontre ce genre de symbole `$` il sait que là il  ne va pas devoir afficher `$str1` d'accord textuellement parlant mais il va chercher une variable qui s'appelle comme ça et afficher sa valeur et c'est exactement ce qui se passe ici.

Troisième cas enfin donc là je fais directement un affichage de `$str3`.

```sh
#!/bin/bash

str1='Jason'
str2="Bienvenue $str1"
str3=`ls -a`

echo $str3
```

On s'attendrait éventuellement a ce qu'il affiche `ls -a` et en réalité voilà ce qu'il affiche.

```bash
sam@sam:~/Documents$ ./main.sh
. .. main.sh
```

Si vous avez compris vous rendez compte qu'il affiche tout simplement le résultat directement de la commande `ls` avec l'argument tiret a tout simplement donc ceci permet d'exécuter en fait d'interpréter directement le résultat d'une commande Bash en l'occurrence et d'infecter son retour à la variable dans laquelle vous avez fait l'affectation, `` str3=`ls -a` ``.

Voilà trois syntaxe diffèrente donc ça pour du texte brut quand on veut être sûr que rien ne doit être interprété donc attention évidemment si vous avez des apostrophes dans votre texte, il faudra éventuellement les échapper comme ça, `str1='Jas\'on'` d'accord par contre voyez que l'éditeur il le gère mal.

```sh
#!/bin/bash

str1='Jas\'on'
str2="Bienvenue $str1"
str3=`ls -a`

echo $str3
```

Ou alors si bien sûr il n'y a pas de variables vous pouvez utiliser bien sûr les doubles quotes comme ceci.

```sh
#!/bin/bash

str1="Jason"
str2="Bienvenue $str1"
str3=`ls -a`

echo $str3
```

Par contre en terme de performances brutes forcément c'est un peu plus lent ce type de syntaxe puisque là `"Jason"` il doit chercher éventuellement s'il n'y a pas des choses à interpréter.

Là `'Jason'` avec ce type de notation il doit tout traiter de manière brute donc il n'y a rien à interpréter, c'est très rapide en tout cas c'est plus rapide que ce type de notation `"Bienvenue $str1"` forcément et là `` `ls -a` `` c'est encore autre chose puisqu'on va carrément exécuter ce qu'il y a à l'intérieur.

3 encore une fois syntaxe importantes qui ont trois usages différents donc attention à l'usage que vous avez.

Attention surtout à ne pas vous attendre à avoir un affichage de texte, d'utiliser ce type de notation `"Bienvenue $str1"` et de vous retrouver avec finalement des variables interprétées ou des valeurs interprétées il faut faire attention à ça.

Voilà pour cette partie alors maintenant que je vous ai montré comment déclarer des variables, infecter des choses et cetera donc ça pas de problème mais maintenant on va prendre tout ça un petit peu plus dynamique c'est-à-dire que jusqu'à présent on a noté les valeurs de manière brute donc en dur dans le code ici mais ça peut être pas mal aussi de gérer ça de manière dynamique.

## saisie au clavier

Le but plus tard au niveau des variables, ce ne sera pas forcément vous en tant que développeur de noter les valeurs dans les variables mais vous pourrez le faire de manière dynamique par exemple de développer des fonctions ce qu'on verra un peu plus tard pour qu'elles permettent de récupérer des résultats et de pouvoir affecter ça dans des variables ou alors de faire des calculs et de récupérer le résultat d'un calcul donc c'est le programme qui va faire le calcul, récupérera le résultat qui sera affecté dans une variable et après ce résultat vous en ferez ce que vous voulez d'accord donc c'est l'intérêt de la programmation.

Si on devait tout faire à la main, la programmation n'aurait plus beaucoup d'intérêt à ce niveau là donc première chose qu'on peut voir ici parce qu'on n'est pas trop trop loin pour le moment dans la programmation de script, on peut commencer par ça, c'est de récupérer une information.

On va lire une information et le plus simple comme on le voit très souvent dans plein d'autres langages de programmation également c'est de lire au clavier on va demander à l'utilisateur de saisir une information et pour cela nous allons utiliser la commande qui est `read` tout simplement.

Au plus simple, vous l'indiquez ici `read `, un espace et vous choisissez la variable dans laquelle vous allez stocker, mémoriser l'information.

Par exemple je mette `name` et ensuite on affichera `$name` ici.

```sh
#!/bin/bash

read name
echo $name
```

C'est vraiment le minimum qu'on puisse faire à ce niveau là, on va l'exécuter.

```bash
sam@sam:~/Documents$ ./main.sh
_
```

Vous voyez que j'ai un curseur qui m'indique apparemment de saisir quelque chose donc il n'y a rien d'autre à indiquer mais vous allez voir c'est volontaire on va aller un peu plus loin après.

Je tape quelque chose donc je tape n'importe quoi et voyez qu'il m'affiche bien le contenu donc ça fonctionne à ce niveau là pas de problème.

```bash
sam@sam:~/Documents$ ./main.sh
ok
ok
```

Evidemment comme c'est une commande, vous avez l'habitude en Bash, on a éventuellement des arguments on peut faire un petit man d'ailleurs sur read, `man read` mais attention parce que vous pourrez tomber sur une autre page de manuel qui vous indiquera une fonction et ce ne sera pas forcément la commande de Bash mais ça on en parlera aussi de toute façon plus tard.

Et à partir de là on peut utiliser quelques arguments.

Très rapidement ce qui me semble la base en tout cas c'est d'indiquer l'argument pour avoir un texte parce que là tout seul, on ne sait pas trop ce qu'on demande mais déjà si on fait ça `"Comment t'appelles-tu ?"` c'est quand même déjà beaucoup plus clair d'accord.

```sh
#!/bin/bash

read -p "Comment t'appelles-tu ?" name
echo $name
```

C'est quand même déjà beaucoup plus clair donc le tiret p alors je vais juste mettre p pour read donc c'est -p pour prompt et qui permet d'ajouter un texte avant la saisie.

```sh
#!/bin/bash

# Commande read :
# p - ajouter un texte avant la saisie

read -p "Comment t'appelles-tu ? " name
echo $name
```

Là si je refait une exécution, on comprend tout de suite ce qu'on demande comme information, je saisis ensuite j'appuie sur la touche entrée et on a bien une information qui est reprise aussi, pas de problème.

```bash
sam@sam:~/Documents$ ./main.sh
Comment t'appelles-tu ? Jason
Jason
```

Alors on a d'autres choses, on peut aussi faire une saisie sécurisée donc là c'est masquer la saisie donc ça quand vous devez par exemple rentrer votre  mot de passe, que vous faites une mise à jour de paquet comme on l'a déjà vu dans le cours précédemment.

Vous avez vu votre mot de passe super utilisateur donc `root` n'était pas affiché sur le terminal c'était normal et bien c'est ce type de lecture là donc je peux le cumuler.

```sh
#!/bin/bash

# Commande read :
# p - ajouter un texte avant la saisie
# s - masquer la saisie

read -p "Comment t'appelles-tu ? " name
echo $name
```

Je peux le cumuler c'est à dire je peux parfaitement faire ça, `read -p "Comment t'appelles-tu ? -s " name` où je peut par exemple je peux mettre le petit tiret s là, juste avant la variable et comme ça je tape le texte donc vous ne voyez pas le texte malgré que je tape bien au clavier et si je fais entrer il  aura afficher l'information voilà.

```sh
#!/bin/bash

# Commande read :
# p - ajouter un texte avant la saisie
# s - masquer la saisie

read -p "Comment t'appelles-tu ? " -s name
echo $name
```

```bash
sam@sam:~/Documents$ ./main.sh
Comment t'appelles-tu ? Jasonzefzlinzef
```

Voilà tout simplement, tout ça on peut le faire, il n'y a pas de problème.

On peut également limiter le nombre de caractères, ça serait pas mal aussi donc limiter à N caractères lus.

```sh
#!/bin/bash

# Commande read :
# p - ajouter un texte avant la saisie
# s - masquer la saisie
# n - limiter à N caractères lus

read -p "Comment t'appelles-tu ? " -n 5 name
echo $name
```

Voilà donc comment que ça se gère ? on écrit sous cette forme-là et là `-n 5` je dis que je veux maximum cinq caractères à lire donc je vais faire ici.

```bash
sam@sam:~/Documents$ ./main.sh
Comment t'appelles-tu ? abcdeabcde
```

On y va 1 (a), 2 (b), 3 (c), 4 (d), 5 (e) et il s'arrête à ce moment-là il m'affiche tout ensemble parce qu'il a collé la saisie avec l'affichage du résultat.

J'aurais pu mettre un anti slash n `\n` mais ce n'est pas grave, je vais mette `"\n Saisie : $name"` comme ça.

```sh
#!/bin/bash

# Commande read :
# p - ajouter un texte avant la saisie
# s - masquer la saisie
# n - limiter à N caractères lus

read -p "Comment t'appelles-tu ? " -n 5 name
echo -e "\n Saisie : $name"
```

```bash
sam@sam:~/Documents$ ./main.sh
Comment t'appelles-tu ? okelf
 Saisie : okelf
```

Je tape n'importe quoi un deux trois quatre cinq et  au bout du 5 tac il s'arrête bien à 5, il arrête la lecture à ce moment là.

On peut également limiter le nombre de secondes avant que le prompt attende c'est à dire l'option t qui autorise la saisie pendant N secondes.

```sh
#!/bin/bash

# Commande read :
# p - ajouter un texte avant la saisie
# s - masquer la saisie
# n - limiter à N caractères lus
# t - autoriser la saisie pendant N secondes

read -p "Comment t'appelles-tu ? " -t 2 name
echo -e "\n Saisie : $name"
```

Voilà donc là vous utiliser l'argument tiret t, vous mettez le nombre de secondes par exemple 2 secondes et voilà vous avez deux secondes pour entrer donc si je ne touche à rien au bout de deux secondes, terminé d'accord.

```bash
sam@sam:~/Documents$ ./main.sh
Comment t'appelles-tu ? 
 Saisie : 
```

Mais si je le fais avant les 2 sec, pas de problème.

```bash
sam@sam:~/Documents$ ./main.sh
Comment t'appelles-tu ? okzfe

 Saisie : okzfe
```

On peut gérer tout ça ok.

Pas mal pratique la commande `read`, vous avez quelques arguments, il y a d'autres petites choses aussi si ça vous intéresse.

```sh
# Commande read :
# p - ajouter un texte avant la saisie
# s - masquer la saisie
# n - limiter à N caractères lus
# t - autoriser la saisie pendant N secondes
```

Pas mal pratique mais déjà avec ça si vous voulez vous entraîner un petit peu à faire quelques petits programmes après pour vous exercez, vous aurez de quoi vous amuser un petit peu plus que de noter directement dans votre code finalement les textes, les valeurs et cetera.

Vous allez pouvoir faire pas mal de choses à ce niveau là.

Voilà alors je ne veux pas essayer d'aller trop loin parce qu'encore une fois il y a énormément énormément de choses donc j'essaie de voir un petit peu qu'est-ce qu'on peut aborder par la suite parce qu'on a du `read`, on a vu comment lire les données, on a vu pour les options et cetera.

On va avoir quelques petites choses à voir sur des variables un petit peu spéciales.

On va aborder quelques variables parce que vous allez pouvoir exécuter votre programme avec des arguments et vous servir de ces arguments, autant finalement que ça serve à quelque chose et d'avoir ces informations-là aussi.

Alors qu'est ce qu'on va pouvoir faire ? est-ce que je vous montre d'autres commandes maintenant et il y en a que je garde pour plus tard notamment tout ce qui est variable sous forme de tableau, on ne va pas faire ça maintenant il y a pas mal de choses à voir.

## readonly

On se gardera ça pour plus tard par contre ce qu'on peut faire c'est pour avoir des données par exemple sous forme de constantes ce qu'on appelle en fait des données en lecture seule.

Lecture seule, c'est un terme qu'on emploie qui veut dire qu'on va avoir en fait une valeur assignée à notre variable et on ne pourra pas la modifier.

Elle ne sera que disponible en lecture, on pourra la lire et cetera mais pas la modifier.

Alors il y a plusieurs manières comme je l'ai dis en Bash on a des fois des syntaxes assez flexible, on a plusieurs syntaxe différentes.

Il faut savoir aussi que le langage a évolué c'est à dire qu'il avait des commandes disponibles au tout début du langage puis il y en a de nouvelles qui ont été ajoutées qui peuvent faire d'autres choses et du coup on se retrouve des fois avec 2/3 commandes qui permettent éventuellement avec certaines options de faire la même chose mais elles n'ont pas que ça comme fonctionnalité.

Le plus simple donc pour faire une donnée finalement en read only c'est tout simplement d'ajouter la  commande `readonly` puis un `echo` de data

```sh
#!/bin/bash

readonly data=14

echo $data
```

```bash
sam@sam:~/Documents$ ./main.sh
14
```

Voilà ok ça s'affiche pas de problème, on ne voit pas la différence par rapport à ça pour le moment.

Maintenant je tente une nouvelle affectation de data et bien sûr un affichage de la nouvelle valeur.

```sh
#!/bin/bash

readonly data=14

echo $data

data=16
echo $data
```

```bash
sam@sam:~/Documents$ ./main.sh
14
./main.sh: ligne 7: data : variable en lecture seule
14
```

Et là on s'attendrait à avoir si on avait pas `readonly` la valeur 16 mais là ça ne marchera pas d'accord ça nous indique que la variable est en lecture seule donc modifications tout simplement impossible.

## declare

On a également une autre commande qui ne va pas servir que pour déclarer finalement une donnée en lecture seule mais qui servira à plein d'autres choses qui est la commande `declare`.

Elle va nous permette de déclarer des variables et nous permettre d'assigner également des attributs particulier d'accord le plus simple si on veut reprendre le principe du `readonly` c'est son argument tiret r `-r` qui permet de faire la même chose.

```sh
#!/bin/bash

declare -r data=26

echo $data

data=16
echo $data
```

```bash
sam@sam:~/Documents$ ./main.sh
26
./main.sh: ligne 7: data : variable en lecture seule
26
```

Je fais ça et on voit pareil que ça ne peut pas
changer d'accord même chose.

Alors on a d'autres choses, on peut également utiliser `declare` et pourquoi pas, je le note vite fait en commentaire.

```sh
#!/bin/bash

# Commande declare :
# r (lecture)
# i (numérique)
# a
# etc.

declare -r data=26

echo $data

data=16
echo $data
```

En gros, on va voir le r pour tout ce qui est lecture seule d'accord et on va pouvoir gérer éventuellement d'autres types aussi.

Alors ce qui peut être intéressant par exemple c'est le i pour traiter l'information comme étant un nombre d'accord une valeur numérique, une valeur arithmétique donc on veut le mette pour quelque chose qui est numérique.

Plus tard on verra également d'autres choses notamment pour les tableaux, on verra un argument qui est a pour pouvoir faire des tableaux mais ça je vous expliquerai plus tard et il y en a d'autres également mais je vous laisse le plaisir aussi d'aller un petit peu voir les manuels de la commande et voir un petit peu ce qu'on peut utiliser.

Il y a donc pas mal comme ça d'outil différent, je vais mettre et cetera parce qu'on peut en retrouver d'autres.

Moi je voulais surtout montrer pour la lecture seule pour le moment.

Le numérique `-i` éventuellement si vous voulez gérer ça sous forme de directement de valeur numérique, on peut faire ça comme ça.

## declare et readonly

D'ailleurs si depuis mon terminal ici je fais juste la commande `declare`.

```bash
sam@sam:~/Documents$ declare
BASH=/usr/bin/bash
#...
```

Voilà on retrouve toutes les informations alors declare ici alors non c'est pas ce que je voulais faire mais `readonly` ce sera plus explicite et nous indique toutes les informations en lecture seule qui sont déclarées sur le système.

```bash
sam@sam:~/Documents$ readonly
declare -r BASHOPTS="checkwinsize:cmdhist:complete_fullquote:expand_aliases:extglob:extquote:force_fignore:globasciiranges:histappend:interactive_comments:progcomp:promptvars:sourcepath"
declare -ar BASH_REMATCH=()
declare -ar BASH_VERSINFO=([0]="5" [1]="0" [2]="17" [3]="1" [4]="release" [5]="x86_64-pc-linux-gnu")
declare -ir EUID="1000"
declare -ir PPID="2783"
declare -r SHELLOPTS="braceexpand:emacs:hashall:histexpand:history:interactive-comments:monitor"
declare -ir UID="1000"
```

Voyez ici on retrouve le fameux `-a` pour les  tableaux on verra ça plus tard mais vous voyez que pour le `-i` dès qu'on a une valeur numérique voilà on trouve pas mal de choses PPID, EUID, etc. `-r` ça c'est de la lecture seul dans tous les cas voilà.

On peut donc parfaitement cumuler encore une fois les arguments c'est pas nouveau, ça vous montre un petit peu à quoi ça ressemble donc encore une fois je peux passer d'une commande écrite dans mon script à une commande écrite dans le terminal.

Je rappelle que tout ça c'est du Bash c'est la même chose, pas de différence c'est jusque que là on passe par un script et là on exécute ça directement à la volée dans notre console dans notre terminal.

Voilà donc ça on reviendra de toute façon dessus, il a plein de choses qu'on va devoir revoir.

On ne peut pas tout voir tout de suite parce qu'on en est à un certain niveau il y a des choses que vous ne savez pas encore faire mais vous saurez faire
par la suite donc pas de problème à ce niveau là.

Qu'est ce qu'on peut voir également ? alors on va voir les variables parce qu'il y a d'autres  commandes mais je ne peux pas vous les montrer maintenant il faut commencer à aborder par des variables assez particulières au niveau de l'exécution de notre script.

Il y à pas mal de variables notamment les variables d'environnement qui existent au niveau de votre système, ça je le garde de toute façon c'est pour un tuto qui sera en annexe d'accord qui est en annexe du cours qui permettra en fait de les aborder parce que c'est pas forcément essentiel au niveau de la programmation pure de scripts en Bash par contre c'est toujours un plus quand on veut manipuler justement ces variables d'environnement donc je le mettrais à part du cours ce sera en annexe mais il y aura cette partie là donc on la garde à part.

## paramètre d appel

Par contre ce que je vais pouvoir vous montrer c'est tout simplement les variables en fait qui seront des paramètres ou des arguments passés lors de l'appel dans l'ordre de l'exécution de votre programme.

Ce que je veux dire c'est simplement de pouvoir faire ça, `./main.sh Jason` par exemple et de passer ici une information d'accord un paramètre en fait un argument que je veux récupérer dans mon programme au moment où je l'exécute et pour cela nous avons justement des caractères bien précis.

Le premier au plus simple ça va être celui-là `$#` qui va vous indiquer tout simplement le nombre de paramètres. Je vous les notes assez rapidement parce que je ne vais pas tous vous les montrer en termes d'exécution mais au moins vous aurez déjà quelques petites notes ici.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
```

`$0` ça c'est l'exécutable donc ici ce serait le `main.sh` d'ailleurs d'ailleurs il mettra le point et le slash avant dans le nom complet et ensuite on va avoir de `$1` à `$9` alors basiquement c'est jusqu'à dollars 9 d'accord mais moi je vais aller plus loin avec vous, je vais vous montrer également finalement on peut avoir dollars grand x `${X}` qui est finalement n'importe quel paramètre c'est à dire je vais vous permettre d'aller plus loin que le paramètre 9.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
# $1 à $9 : paramètres 1 à 9
# ${X} : paramètre X
```

Voilà donc ça par exemple ce n'est pas forcément quelque chose qu'on a vu au tout début du langage Bash c'est-à-dire les notations qui sont arrivés un peu plus tard parce qu'auparavant si on voulait par exemple un dixième paramètres éventuelles, il fallait faire un décalage de paramètres avec notamment une commande qu'on appelle `shift` en choisissant éventuellement le nombre de décalages que l'on fait sinon on fait un décalage complet, peu importe qui permettait comme ça de dire bon le  dixième en fait ça revenait au dollar à 1 `$1` puisqu'on avait fait un décalage des arguments.

Bref c'est assez vite casse tête on va dire quand on n'a pas trop l'habitude donc c'est vrai que maintenant qu'on peut faire ça au niveau des variables ça va être bien plus pratique.

Alors comment ça s'utilise parce que c'est bien beau mais on verra d'ailleurs d'autres exemples je dois aussi vous montrer notamment des choses comme `$$, $#, $* et $@`.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
# $1 à $9 : paramètres 1 à 9
# ${X} : paramètre X
# $$, $#, $* et $@
```

On reviendra en détail aussi bien dans le cours que dans des tutoriels en annexe sur plein de notation d'accord c'est des choses qu'on va revoir donc si on ne l'a pas extrêmement détaillé dans cette vidéo précise, ne vous en faites pas ce sera bien sûr redétaillé ou détaillé comme il faut dans d'autres séances et dans des annexes, dans des tutoriels.

```bash
sam@sam:~/Documents$ ./main.sh Jason
```

Alors cet argument `./main.sh` ici donc ça c'est le fameux dollar à 0 `$0` finalement et ça `Jason` c'est ce qui normalement va être injecté donc  mémorisé dans le dollar 1 `$1` d'accord c'est une variable spéciale le `$1` donc si je fait logiquement ceci `echo $1`, je suis sencé récupèrer mon information.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
# $1 à $9 : paramètres 1 à 9
# ${X} : paramètre X
# $$, $#, $* et $@

echo $1
```

```bash
sam@sam:~/Documents$ ./main.sh Jason
Jason
```

Je fais donc ça et vous voyez que je la récupère directement.

Si je note ça `.main.sh Jason Champagne` et bien j'ai un `$1` et un `$2` que je peux récupérer donc je peux parfaitement faire ça comme ça d'accord.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
# $1 à $9 : paramètres 1 à 9
# ${X} : paramètre X
# $$, $#, $* et $@

echo $1 $2
```

```bash
sam@sam:~/Documents$ ./main.sh Jason Champagne
Jason Champagne
```

Et on peut aussi comme vous l'avez vu encadrer tout ça voilà et puis éventuellement bon des caractères entre pour montrer qu'on peut parfaitement tout cacatener.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
# $1 à $9 : paramètres 1 à 9
# ${X} : paramètre X
# $$, $#, $* et $@

echo "$1---$2"
```

```bash
sam@sam:~/Documents$ ./main.sh Jason Champagne
Jason---Champagne
```

Voilà alors tout ce qui est après manipulation sur les chaînes de caractères précisément pareil c'est pas des choses qu'on verra forcément précisément dans cette vidéo parce que c'est assez riche c'est ce que je vous ai dit rien qu'au niveau de la syntaxe, des notations, on peut faire énormément énormément de choses et il y a eu pas mal de nouvelles fonctionnalités également qui ont a ajouté les différentes versions de Bash au fur et à mesure.

```bash
sam@sam:~/Documents$ bash --version
GNU bash, version 5.0.17(1)-release (x86_64-pc-linux-gnu)
Copyright (C) 2019 Free Software Foundation, Inc.
Licence GPLv3+ : GNU GPL version 3 ou ultérieure <http://gnu.org/licenses/gpl.html>

Ceci est un logiciel libre ; vous être libre de le modifier et de le redistribuer.
AUCUNE GARANTIE n est fournie, dans les limites permises par la loi.
```

Au moment où je fais cette vidéo on est à la version 5 et quelques et forcément c'est à dire qu'il y a eu beaucoup beaucoup de versions avant et donc beaucoup d'ajout de fonctionnalités donc c'est quelque chose qui est maintenue encore à jour aujourd'hui.

C'est quelque chose qui continue d'évoluer, ça continue d'ajouter des choses donc c'est très intéressant.

Alors ça c'est ce que je voulais montrer donc on peut gérer ça on peut éventuellement afficher le nom de l'exécutable.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
# $1 à $9 : paramètres 1 à 9
# ${X} : paramètre X
# $$, $#, $* et $@

echo $0
```

```bash
sam@sam:~/Documents$ ./main.sh
./main.sh
```

Voilà le nom de l'exécutable `./main.sh`.

On peut noter le nombre de paramètres qu'on a envoyé.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
# $1 à $9 : paramètres 1 à 9
# ${X} : paramètre X
# $$, $#, $* et $@

echo $#
```

```bash
sam@sam:~/Documents$ ./main.sh Jason Champagne
2
sam@sam:~/Documents$ ./main.sh Jason
1
sam@sam:~/Documents$ ./main.sh
0
```

Voilà sans paramètre on a 0 ce qui est parfaitement logique à ce niveau là aussi.

Alors `$*` et `$@` sont des cas particuliers, je vous en parlerais assez vite mais on verra après.

On a un autre cas avec `$$` en relation avec la vidéo sur les processus si vous vous souvenez qu'il y avait notamment un identifiant donc si je fais ça `$$` on peut récupérer son identifiant.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
# $1 à $9 : paramètres 1 à 9
# ${X} : paramètre X
# $$, $#, $* et $@

echo $$
```

```bash
sam@sam:~/Documents$ ./main.sh
13218
sam@sam:~/Documents$ ./main.sh
13222
```

Voilà le PID 13218 et là si je relance ça devient un autre PID donc ça passe par un autre PID et donc c'est pas mal pratique à ce niveau là.

Voilà on a l'identifiant ici que l'on peut récupérer, ça je vais très vite mais au moins comme vous avez vu ce que c'était les processus comme on gérait ça avec pleins d'autres commandes.

Sachez qu'on peut récupérer ça dans cette variable, c'est quand même pas mal pratique.

Autre paramètre à vous montrer, je vais faire celui là `$*`, je vais juste faire ça d'abord donc là oui je vais juste faire ça et on ne voit rien.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
# $1 à $9 : paramètres 1 à 9
# ${X} : paramètre X
# $$, $#, $* et $@

echo $*
```

```bash
sam@sam:~/Documents$ ./main.sh

sam@sam:~/Documents$ 
```

Là si je fais ça, on ne voit rien mais si maintenant je fait a b c et dn on voit ça.

```bash
sam@sam:~/Documents$ ./main.sh a b c d
a b c d
sam@sam:~/Documents$ 
```

Voilà et je vais aller assez vite pour terminer et là je mets un @ et je fais ça et on observe la même chose.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
# $1 à $9 : paramètres 1 à 9
# ${X} : paramètre X
# $$, $#, $* et $@

echo $@
```

```bash
sam@sam:~/Documents$ ./main.sh a b c d
a b c d
sam@sam:~/Documents$ 
```

Donc en usage on va dire normal vous allez obtenir la même chose ici d'accord pour ces deux exemples c'est-à-dire qu'ils vont lister l'ensemble des paramètres avec une espace à chaque fois et après ce qui va changer c'est comment on va traiter chaque élément, en fait chacune de ces variables en terme de chaîne d'accord c'est à dire que ce symbole `$*` et j'espère que je n'inverse pas les deux mais au pire on va vite le voir.

`$*` ici normalement ça traite tous sur une seule et unique chaîne d'accord c'est à dire que si on a plusieurs paramètres `a b c d` pour lui tout ça ça va être une seule et unique chaîne, il va mettre comme ça des espaces entre chaque alors que cette variable `$@` va éventuellement gérer autant de chaînes qu'il y a d'indiquer précisément donc si je m'amuse à mettre par exemple des symboles du style `a "b c" d`, il devrait considérer une chaîne particulière `"b c"` bref on verra un exemple un peu plus parlant quand on serra un peut plus avancé dans le cours parce que là je n'ai pas forcément ici un exemple sous la main parce qu'il faut quand même un cas assez particulier.

En gros on va avoir `$*` qui va traiter tout sous forme d'une seule et unique chaîne d'accord donc en fait on va stocker les informations éventuellement dans une seule variable et ici `$@` chaque chaîne s'il y en a bien sûr plusieurs et bien sera bien séparées, bien distinctes. 

On aura cette différence là qui se fera au niveau des nombres d'arguments compte donc ça c'est une chose à savoir.

Alors je ne vous ai pas montré celui-là `${X}` aussi qu'on peut éventuellement utiliser par exemple de faire ça `${11}` genre le 11e paramètres qu'on voit que ça marche quand même parce que c'est bien que vous voyez donc là on va en mettre plein `./main.sh a b c d e f g h i j k l m n`.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
# $1 à $9 : paramètres 1 à 9
# ${X} : paramètre X
# $$, $#, $* et $@

echo ${11}
```

```bash
sam@sam:~/Documents$ ./main.sh a b c d e f g h i j k l m n
k
```

Voilà `k` est bien le 11e paramètre.

Alors avant on ne pouvait pas faire ça, avant il fallait éventuellement faire un shift je crois puis un `echo $1` à cause du décallage.

```sh
#!/bin/bash

# $# : nombres de paramètres
# $0 : exécutable
# $1 à $9 : paramètres 1 à 9
# ${X} : paramètre X
# $$, $#, $* et $@

shift 10
echo $1
```

```bash
sam@sam:~/Documents$ ./main.sh a b c d e f g h i j k l m n
k
```

`shift 10` voilà je fais un décalage de 10 et ensuite du coup on retombe dessus voilà on retombe sur le `k`.

Vous voyez on est obligé de passer par une autre commande qui est le `shift` pour faire un décalage de n (10) parce que avec cette notation $1 à $9, on ne va pas au delà de dollar 9. On ne peut pas noter dollar 13, 14 mais ça s'arrête à 9.

Si on veut noter un nombre et non pas un simple chiffre, on utilise l'accolade {} et vous mettez le nombre cette fois ci entre les accolades ou un chiffre aussi ça marche et vous aurez comme ça la bonne valeur directement.

C'est donc une autre notation qui voilà qui est disponible qui était un peu plus récente et qui permet de récupérer ces informations-là.

Qu'est ce que je peux vous montrer ? On est loin d'avoir tout vu et je ne parle même pas des variables d'environnement, on gardera ça pour plus tard. On n'a pas vu notamment tout ce qui était expression c'est-à-dire des opérations à l'intérieur par exemple des valeurs affectées à des variables ça je garde de toute façon pour une prochaine séance.

## substitution de commande

Par contre ce qu'on peut voir comme autre notation  qui est avec ce type là qui est quand même très intéressant c'est la notation par exemple pour faire une substitution de commandes.

Genre un exemple qui ne servira à rien si vous utilisez la commande pwd qui liste le répertoire courant, je peux la mettre dans mon script et admettons que `pwd` ne vous plaît pas, je crée une variable et j'utilise le $ et je met entre parenthèse la commande à substituer.

```sh
#!/bin/bash

current_directory=$(pwd)
echo $current_directory
```

```bash
sam@sam:~/Documents$ ./main.sh
/home/sam/Documents
```

Je retrouve la même chose qu'avec `pwd`.

Voilà c'est une substitution de commande pas mal pratique.

## évaluer une expression

On verra plus tard, je peux vous montrer rapidement pour évaluer une expression ce genre de chose, je peux vous montrer maintenant parce que c'est très court on va faire ça.

Je commence par faire une addition avec un petit opérateur.

```sh
#!/bin/bash

data=14+6
echo $data
```

```bash
sam@sam:~/Documents$ ./main.sh
14+6
```

On fait ça et on a un petit opérateur d'addition comme ce qu'on retrouve en mathématiques et vous voyez qu'il n'est pas capable en fait d'évaluer l'expression pour lui le `14+6` c'est la valeur.

Je vous avais dit que par défaut tout est traité sous forme de texte.

Alors certes j'ai pas mis `'14+6'`, j'ai pas mis `"14+6"` mais pour lui si on ne met rien même si c'est moins propre, il considère que c'est une chaîne d'accord tout est du caractère et c'est seulement pour ça qu'on est obligé ici `data=14+6` de ne pas mettre d'espaces parce quand il voit un ensemble de texte `data`, un symbole égale `=` et ici plein de choses `14+6` telles que c'est en fait par défaut.

Il comprend que `data` c'est encore une fois une étiquette pour une variable, `=` c'est pour faire une affectation et `14+6` c'est tout ce qu'il y a à affecter donc si on veut que cette expression soit évaluée, on va être obligé alors via la notation des variables un peu spécial ici `$((14+6))` soit d'utiliser un dollar en doublant les parenthèses.

```sh
#!/bin/bash

data=$((14+6))
echo $data
```

```bash
sam@sam:~/Documents$ ./main.sh
20
```

Hop on a l'évaluation de l'expression qui se fait et le calcul est effectué mais des choses qu'on reverra plus tard ou alors on a quelque chose je crois qui est plus récent que cette notation si je ne dis pas de bêtises qui est simplement le `let`, vous précédé le nom de la variable par un la commande `let` et ici pareil ça évalue l'expression.

```sh
#!/bin/bash

let data=14+6
echo $data
```

```bash
sam@sam:~/Documents$ ./main.sh
20
```

C'est une autre possibilité.

C'est pour ça que je vous avez dit que c'est flexible, il y a plusieurs notations différentes pour faire un peu la même chose même s'il n'y a pas que ça comme fonctionnalité donc à vous de voir ce que vous préférez.

Peu importe, l'important c'est qu'il faut que ça marche bien sûr sur votre version de Bash, sur votre programme, tout ça et à partir du moment où ça fonctionne, pas de problème donc à ce niveau là c'est ok on est tranquille.

De toute façon maintenant toutes les distributions GNU Linux maintenant elle sont avec des versions de Bash assez récente c'est minimum du 4.4 ou du 4.6 ou 5 je ne sais plus.

Là je crois qu'ici c'est du 5.

```bash
sam@sam:~/Documents$ bash --version
GNU bash, version 5.0.17(1)-release (x86_64-pc-linux-gnu)
Copyright (C) 2019 Free Software Foundation, Inc.
Licence GPLv3+ : GNU GPL version 3 ou ultérieure <http://gnu.org/licenses/gpl.html>

Ceci est un logiciel libre ; vous être libre de le modifier et de le redistribuer.
AUCUNE GARANTIE n est fournie, dans les limites permises par la loi.
```

Si vous avez au moins du 4.4 déjà vous êtes tranquille et je vois mal en tout cas les distributions connues avoir une version de Bash qui est très ancienne, c'est assez à jour à ce niveau là donc pas d'inquiétude.

Voilà je pense qu'on va s'arrêter là.

## unset

On avait vu la commande qui permet de supprimer ... est l'inverse de définir en fait une variable.

Admettons que je veux supprimer ça `data=14`.

```sh
#!/bin/bash

data=14
echo $data

unset data
echo $data
```

On fait un `echo $data` et je veux supprimer tout simplement ça bah vous pouvez le faire.

Vous faites un `unset` de data et terminé elle n'existera plus.

```bash
sam@sam:~/Documents$ ./main.sh
14

sam@sam:~/Documents$ 
```

Voilà première fois on l'affiche, deuxième fois, elle n'existe plus donc il n'affiche rien c'est le néant ça n'existe plus.

On peut faire ce genre de choses.

## set

Et petit dernier bonus c'est vraiment cadeau même si comme ça vous n'en ferez pas grand chose.

Voilà on peut utiliser aussi une commande `set` puis je fais par exemple ça.

```sh
#!/bin/bash

set A B C D
```

Donc ça c'est comme du texte mais je ne mets pas les quotes pour pas que ça alourdisse la syntaxe et après je peux par exemple afficher le B en faisant ça.

```sh
#!/bin/bash

set A B C D

echo $2
```

```bash
sam@sam:~/Documents$ ./main.sh
B
```

Là je réinjecte dans ce ces valeurs particulières
les valeurs que j'ai ici dans mon set.

Alors choses incroyables les paramètres on s'en fout, c'est le set en fait qui prend l'avantage qui passe en priorité.

```bash
sam@sam:~/Documents$ ./main.sh aaa bbb ccc ddd
B
```

Voilà le set passe en priorité c'est ce qui est défini ici pour les dollar $1, $2, etc.

Voilà par contre pour $0.

```sh
#!/bin/bash

set A B C D

echo $0
```

```bash
sam@sam:~/Documents$ ./main.sh aaa bbb ccc ddd
./main.sh
```

Voilà le $0 comme il n'est pas utilisé pour le set il a dit bon ça on peut le garder dans le programme, il n'y a pas de problème.

Par contre si on commence à faire du $1, etc, tout ce qui est réservé en fait c'est-à-dire qu'en priorité on réserve pour le set donc ça on ne peut plus utiliser pour nos paramètres donc attention je vous l'indique vite fait.

Je suis allez très vite, tout ça pour dire que si un jour vous utilisez ça `SET A B C D` et en même temps vous passez des paramètres à votre programme attention vous pourriez des fois être surpris que ça prenne en fait ces valeurs là d'accord pour les dollars et pas ce que vous avez passé en paramètre donc attention le `set` fonctionne comme ça il sépare bien mais je vais m'arrêter là parce qu'on n'a pas vu tout ce qui est séquence, tableaux, etc.

On verra ça plus tard ça fait déjà beaucoup je pense encore une fois à voir et revoir au niveau de cette séance donc on va s'arrêter là je pense que j'ai fait le tour de tout ce que je voulais vous montrer à ce niveau là.

Voilà donc n'hésitez pas, vous avez vu pas mal de commandes mine de rien donc n'hésitez pas à vous en servir, à travailler dessus, à faire pas mal de choses.

## indirection

Je vais vous montrer une autre bien que vous n'en allez pas en avoir l'utilité mais ça peut être sympa.

Je vais faire ça.

```sh
#!/bin/bash

data=other
other="OK"

echo ${!data}
```

Voilà on fait `${!data}` un peu comme si cette variable `data` est un peu **public** et celle-là `other` on ne veut pas l'afficher dans la notation d'accord c'est l'information un peu dissimulée.

On fait une indirection on appelle `data` en fait qui lui est en fait une référence à `other` et normalement si je fais ça, ça m'affiche ok.

```bash
sam@sam:~/Documents$ ./main.sh aaa bbb ccc ddd
OK
```

Voilà je vais m'arrêter parce qu'après je peux vous montrer tout un tas de trucs, il y a plein d'autres pleins d'astuces, de notations sympa à faire en Bash.

Je peux vous montrer tellement tellement de trucs encore mais on va s'arrêter là.

J'espère en tout cas que ça vous aura plus, qu'on aura vu l'étendue déjà de pas mal de choses.

Voyez en une vidéo on peut faire énormément de syntaxe différentes.

Là c'est vraiment le moment si vous voulez vous exercez, faire plein de petits programmes avec tout ce que vous avez vu et n'oubliez pas toutes les commandes vu précédemment en consoles, vous pouvez les intégrer la dedans.

Rappelez vous on avait parlé de **aptitude** le gestionnaire de paquets, il est fait spécialement pour l'utilisation dans les scripts.

On garde généralement `apt-get` ou `app` tout simplement pour tout ce qui est visuel au niveau de la console par contre `attitude` est vraiment fait pour un usage au niveau des script.

Essayez donc de vous amuser un petit peu encore une fois bon si vous faites des tests un peu bizarres sur certaines commandes, préférez faire ça sur une machine virtuelle.

Si c'est sur votre système Linux hôte et que vous faites une bêtise voilà faites gaffe quand même toujours quand vous faites des tests mais vous aurez comme ça l'occasion de faire pas mal de programmes, tester ces différentes commandes, ces variables, etc.

Par exemple affecter des commandes dans des variables, tester les affichages, des retours de commandes que vous avez déjà utilisez avant et appris à utiliser avant comme ça vous verrez un petit peu comment ça fonctionne et notamment avec toutes les notations que je vous ai montrés pour les variables avec le dollar vous voyez qu'il y a plein de choses et je ne vous ai pas tout montré.

On pourrait voir encore pleins pleins d'autres choses mais prochainement je pense qu'on va parler de tout ce qui est opérateur parce qu'il y a quand même pas mal de symboles à connaître donc il y aura encore beaucoup de choses à apprendre.

On va garder ça pour la prochaine fois et après on va aborder d'autres concepts de la programmation qui s'appliquent également aux Bash et vous aurez comme ça un bon bagage on va dire avec ce langage à la fin bien sûr de cette formation.

Je vous dis à bientôt s'il y a le moindre problème bien évidemment n'hésitez pas dans les commentaires si vous avez des questions, je me tiens à votre disposition et on se retrouve pour la prochaine séance.

A bientôt tout le monde