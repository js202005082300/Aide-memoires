# [35. Chaînes de caractères](https://www.youtube.com/watch?v=f9KWIVczXdI)

Bonjour bienvenue sur la vidéo numéro 35 de ce cours gnu linux.

Comme promis je vous ai fait une petite séance où nous allons aborder ensemble les manipulations sur les chaînes de caractères.

Il y avait beaucoup de choses à voir là dessus et on va en première partie faire quelques rappels sur ce qu'on a déjà vues jusqu'à présent, des choses qu'il faut connaître et ensuite vous allez voir quelques notations, quelques fonctionnalités très importantes et très intéressantes pour manipuler vos chaînes de caractères en Bash.

On y va, on passe directement sur notre éditeur, on va revenir déjà sur quelques rappels puisque à ce stade du cours bien évidemment il y a des choses que vous devez absolument connaître et avec lequel vous devez être à l'aise sinon il faudra penser à revenir sur les vidéos en question pour voir et revoir les différentes notions et on va dire ne plus avoir tellement de problèmes de confusion ou deux erreurs avec ces différentes notation vu précédemment.

Rappelez vous on avait vu trois manières par exemple d'affecter une chaîne de caractères à une variable.

La première c'est de traiter effectivement l'information comme un texte brut, `str='Hello World`, et ici on va afficher bêtement notre texte d'accord.

```bash
#!/bin/bash

str='Hello World'

echo $str
```
```
sam@sam:~$ chmod u+x main.bash
sam@sam:~$ ./main.bash
Hello World
```

Voilà ça c'était la première notation qu'on avait vu.

Maintenant si je veux pouvoir interpréter la valeur d'une autre variable au sein même d'un texte, on avait vu que cette notation ne suffisait pas.

Admettons que je fasse ceci.

```bash
#!/bin/bash

name='World'
str='Hello $name'

echo $str
```
```
sam@sam:~$ ./main.bash
Hello $name
```

Alors je mets World dans une variable et que je demande d'afficher non pas le texte mais le contenu de cette variable name avec la notation qu'on connaît bien.

Avec ce type d'affichage, on voit que l'information encore une fois est traitée comme du texte brut et évidemment c'est le cas et donc on n'obtient pas le résultat que l'on veut.

A partir de là plutôt que des simples quotes, des simple guillemets on va devoir et il est donc utiliser les guillemets double donc les doubles quotes ici et là automatiquement nous allons interpréter à l'information et faire le remplacement nécessaires si nous rencontrons des variables d'accord si au niveau de la chaîne nous en avons.

```bash
#!/bin/bash

name='World'
str="Hello $name"

echo $str
```
```
sam@sam:~$ ./main.bash
Hello World
```

On a donc le remplacement qui est fait pas de problème, ça c'était la deuxième notation qu'on avait vus et on avait terminé enfin avec une notation qui permet l'exécution donc on va ici interpréter une commande, l'exécuter, récupérer le retour de cette commande est l'affecter à une variable.

Je vais reprendre l'exemple avec des anti-quotes par exemple en faisant un petit `` `ls -a` ``.

```bash
#!/bin/bash

str=`ls -a`

echo $str
```
```
sam@sam:~$ ./main.bash
. .. .bash_history .bash_logout .bashrc Bureau .cache .config Documents .gitconfig .gnupg Images .local main.bash Modèles .mozilla Musique Partage .pki .profile Public .selected_editor snap .sudo_as_admin_successful Téléchargements .vboxclient-clipboard.pid .vboxclient-display-svga-x11.pid .vboxclient-draganddrop.pid .vboxclient-seamless.pid Vidéos .vscode .wget-hsts
sam@sam:~$ 
```

Dés que la commande est exécutée, son retour est affecté à $str et ici on peut afficher le contenu donc on récupère toute l'information.

Voilà ce sont trois syntaxes qu'on avait vues, très importante pour finalement la manière d'indiquer une chaîne de caractères mais vous voyez qu'il ne se comporte pas de la même manière soit du texte brut soit interprétation d'éventuels variables ou alors carrément exécution d'une commande en Bash très important.

On avait vu ça mais je vous avais dit qu'on ferait une vidéo dédiée aux chaînes de caractères parce qu'on va pouvoir faire beaucoup plus de choses que ça.

Autant avec des chiffres, des nombres on peut faire donc des opérations on peut éventuellement après plus tard faire des opérations mathématiques avec des fonctions mathématiques, racines, puissance, etc.

Pas de problème mais pour les chaînes de caractères bien sûr c'est un autre type de données et donc d'autres manipulations que nous allons pouvoir effectuer sur ces derniers.

Alors si vous êtes habitués d'autres langages de programmation vous savez que généralement vous passez par des fonctions, vous passez par des méthodes bref vous passez par tout un tas d'outils pour effectuer des manipulations sur vos chaînes et ici en Bash l'avantage c'est que nous allons simplement appliquer des notations particulières pour le faire.

Alors comme vous l'avez vu jusqu'à présent Bash est un langage qui est très riche au niveau syntaxique, niveau notation, etc.

On ne peut pas par exemple faire évaluer une expression avec la commande `expr` que je n'ai pas trop trop montrer puisque c'est quand même pour des cas assez particulier et de toute façon je ne peux pas vous montrer toutes les manières de noter disponibles ça ne serait pas forcément utile et ce serait plus confus qu'autre chose.

Donc ici on va se concentrer sur une notation particulière qu'on a déjà vu mine de rien et on va l'utiliser de manière un peu plus étoffé pour faire nos manipulation sur nos chaînes.

Vous vous souvenez très probablement alors on va repasser sur un Hello World ici.

```bash
#!/bin/bash

str='Hello World'

echo ${str}
```

Voilà cette notation `${str}` qu'on avait déjà vu précédemment.

Alors à ce stade si je fais l'exécution de mon programme, on voit qu'on n'observe pas de changement.

```
sam@sam:~$ ./main.bash
Hello World
```

J'aurais mis les accolades ou pas, il n'y aurait pas eu de différence à ce stade.

Evidemment cette notation existe pour pouvoir utiliser d'autres notations différentes, on va pouvoir ajouter certaines choses pour effectuer des opérations bien précise.

## la longueur de chaîne

Au niveau de notre chaîne de caractères, une première information qu'on a souvent besoin de récupérer en programmation c'est la longueur d'une chaîne c'est-à-dire le nombre de caractères qu'elle contient.

Ici pas besoin de faire appel précisément à une fonction ou autre d'autant qu'à ce stade on n'a pas encore abordé les fonctions en Bash mais ici avec simple ajout `${#str}` alors visuellement on voit que c'est un croisillon, le croisillon du langage c# ou le caractère dièse avec alt gr et la touche 3 que vous ajoutez au début ici du nom de vote variable et on va pouvoir non pas avoir le contenu de la variable mais à l'exécution la longueur de la chaîne.

```bash
#!/bin/bash

str='Hello World'

echo ${#str}
```
```
sam@sam:~$ ./main.bash
11
```

Si je rajoute des caractères et je rappelle que les espaces sont considérés comme des caractères en informatique donc il les compte aussi voilà j'ajoute une espace et un point d'exclamation et on tombe bien sur 13 d'accords très importants.

```bash
#!/bin/bash

str='Hello World !'

echo ${#str}
```
```
sam@sam:~$ ./main.bash
13
```

Alors là normalement vous l'avez compris à ce stade aussi mais je fais un petit rappel ça ne fait jamais de mal, je n'ai fait que manipuler la chaîne au moment de son affichage d'accord c'est à dire que si je refais ici un `echo` de $str on va retomber sur la chaîne de départ d'accord on n'a absolument pas modifié cette variable.

```bash
#!/bin/bash

str='Hello World !'

echo ${#str}
echo $str
```
```
sam@sam:~$ ./main.bash
13
Hello World !
```

Le moyen qu'on aurait pour la modifier c'est de faire ceci.

```bash
#!/bin/bash

str='Hello World !'
str=${#str}

echo $str
```
```
sam@sam:~$ ./main.bash
13
```

A partir de là effectivement je fais une exécution et là oui on a bien modifié le contenu.

Ce n'est d'ailleurs plus une chaîne de caractères à ce stade, c'est un nombre ici donc le nombre 13 d'accord on a carrément changé le type de la données.

Voilà donc ça très important mais normalement à ce stade vous savez comment ça fonctionne, si on ne fait que de l'affichage on ne fait aucun changement d'accord il n'y a pas de modifications qui sont faites mais c'est juste de l'affichage.

Si on veut faire des modifications, il va falloir à un moment donné faire une réaffectation quelques part dans notre code.

Voilà comment on procède au niveau de nos opérations donc ça c'est le cas très simple un petit dièse et vous récupérez la longueur de votre chaîne, très pratique.

## En minuscule

D'autres choses qui sont pas mal intéressante c'est au niveau de la casse du texte, rappelez-vous la casse c'est le fait d'avoir une chaîne en minuscule, en majuscules et d'ailleurs ça fonctionnera aussi pour un caractère d'accord.

On va pouvoir opérer et faire des manipulations à ce niveau là, par exemple si je veux passer tout mon texte alors si je veux passer le premier caractère rencontré en minuscule vous allez pouvoir ajouter ici une petite virgule après le nom de la variable.

```bash
#!/bin/bash

str='Hello World !'

echo ${str,}
```
```
sam@sam:~$ ./main.bash
hello World !
```

Et là vous voyez que le 'H' qui était en majuscule est bien passé en minuscule d'accord si je veux pouvoir travailler et faire la manipulation sur l'ensemble de ma chaîne, je vais simplement et ça vous allez retrouver très très souvent au niveau de la notation doubler le caractère en question.

Là on double la virgule et on opère sur la totalité de la chaîne d'accord.

```bash
#!/bin/bash

str='Hello World !'

echo ${str,,}
```
```
sam@sam:~$ ./main.bash
hello world !
```

On peut également localiser cette modification par exemple alors on va laisser tel quel et on va dire en fait sur quels motifs, on va appliquer le passage en minuscule, `${str,,[]}`.

On peut dire par exemple toutes les fois où on rencontre un `[W]` d'accord toutes les fois où je vais rencontrer un W ici je vais modifier et la voyez que le w est bien passé en minuscule mais pas le reste.

```bash
#!/bin/bash

str='Hello World !'

echo ${str,,[W]}
```
```
sam@sam:~$ ./main.bash
Hello world !
```

Voilà ça permet comme ça de cibler précisément quels motifs nous voulons passer en minuscule d'accord donc ici n'oubliez pas les doubles virgules puisqu'on va évidemment vouloir faire une recherche sur toute la chaîne mais c'est le motif `[W]` qui nous permet de dire quoi précisément d'accord.

## En majuscule

A l'inverse alors je vais enlever cette partie là si on veut tout passer en majuscules, on n'utilisera pas la virgule met l'accent circonflexe, `${str^}`.

Pareil un seul s'est pour le premier caractère rencontré et si vous le doublez c'est pour la totalité de votre chaîne.

```bash
#!/bin/bash

str='Hello World !'

echo ${str^^}
```
```
sam@sam:~$ ./main.bash
HELLO WORLD !
```

D'accord c'est vraiment la même chose, je ne vais pas perdre de temps là-dessus c'est le même principe vous remplacez et vous obtenez l'inverse c'est à dire non pas un passage en minuscules mais en majuscules.

Si je veux le faire pour le caractère `[l]` et bien je fais ça.

```bash
#!/bin/bash

str='Hello World !'

echo ${str^^[l]}
```
```
sam@sam:~$ ./main.bash
HeLLo WorLd !
```

Une fois que j'aurai modifié on voit que tous les `l` ont été placées en majuscules d'accord voilà très facile à utiliser.

Rien de compliqué ici au niveau de la syntaxe, vous voyez pas de fonction, pas de méthode que j'appelle directement d'accord c'est implicite ce sont des fonctions internes ici du langage Bash.

Ainsi avec un simple changement au niveau de la notation, dans l'écriture au niveau du code, automatiquement on va avoir des fonctions qui vont être exécutées sur notre chaîne et donc on va avoir notre chaîne qui est manipulée et même au niveau de l'affichage.

On peut parfaitement le faire à ce stade donc c'est quand même vachement pratique.

## Extraction

On va voir évidemment d'autres cas bien particuliers donc on a vu pour la longueur, on a vu pour le passage en minuscules, pour le passage en majuscules et on va pouvoir également le faire et ça on le retrouve très très souvent bien sûr dans ce genre de cas, de l'extraction d'accord.

Alors l'extraction ça consiste en gros quand on a ici une chaîne par exemple de se dire qu'on veut récupérer une partie d'accord de notre chaîne, non pas la totalité mais simplement une partie ok.

Pour faire cette extraction alors on va directement ici `'Hello World !'` avoir en fait notre système d'indices.

Dans la quasi-totalité d'accord des langages en programmation, quand on travaille par indice, le premier commence par zéro.

Alors pas pour tous, encore une fois il y a des exceptions mais généralement ça commence à 0.

Pour Bash c'est la même chose.

Qu'est ce que j'entends par indice et bien j'entends simplement un nombre, un chiffre qui va permettre de définir la position d'un caractère dans une chaîne.

Ici le `H` qui est le premier caractère notre chaîne et donc en première position et la première position dans le langage Bash c'est l'indice 0 d'accord.

Si je passe à `e` c'est le deuxième il est à l'indice 1 etc etc jusqu'à la fin d'accord.

Pourquoi c'est important de savoir et comprendre ce principe d'indice parce que c'est avec ça que nous allons travailler pour pouvoir faire une extraction de sous-chaîne.

Extraction ça veut dire qu'on ne garde qu'une partie voulue d'accord on dit tu gardes tel partie et donc le reste on l'ignore.

Moi par exemple je veux garder que cette partie là `World !` ici donc à partir de W majuscule jusqu'à la fin.

Pour faire cela vous allez indiquer le nom de votre variable, ça ça ne change pas puis vous mettez un deux point et là vous indiquez l'indice à partir du quel vous voulez faire une extraction donc si on compte : 'H' `:0`, 'e' `:1`, 'l' `:2`, 'l' `:3`, 'o' `:4`, ' ' `:5`, 'W' `:6`, 'o' `:7`, 'r' `:8`, 'l' `:9`, 'd' `:10`, ' ' `:11`, '!' `:12`,

Maintenant on a le W majuscule qui tombe à partir de l'indice 6 donc vous écrivez le 6 ici, `${str:6}` et là j'exécute notre programme.

```bash
#!/bin/bash

str='Hello World !'

echo ${str:6}
```
```
sam@sam:~$ ./main.bash
World !
```

Voilà on a bien extrait la sous-chaîne d'accord on a extrait donc la sous-chaîne 'World !' d'accord.

Si on veut maintenant, autre possibilité vous allez faire une extraction d'une position précise mais un certain nombre de caractères donc ce certain nombre de caractères bas ce sera tout simplement la longueur de cette chaîne extraite, on peut le faire aussi.

Par exemple si ici je veut capturer 'Hello' c'est à dire commencer de l'indice 0 et extraire cinq caractères puisque c'est le nombre de caractères donc la longueur de cette chaîne Hello, je peux l'indiquer aussi.

Je met :0 c'est de là où je commence et le nombre de caractères que je veux extraire c'est à dire 5, `${str:0:5}`.

```bash
#!/bin/bash

str='Hello World !'

echo ${str:0:5}
```
```
sam@sam:~$ ./main.bash
Hello
```

Si je faisais donc dièse # de la nouvelle chaîne extraite ce serait égal à 5, c'est sa longue et là on récupère bien Hello d'accord attention il n'y a pas l'espace.

Si je veux récupérer l'espace qu'on ne verra pas visuellement il faudrait que je fasse `${str:0:6}` donc là vous ne voyez pas de différence mais là en fait on a une espace juste après.

```bash
#!/bin/bash

str='Hello World !'

echo ${str:0:6}
```
```
sam@sam:~$ ./main.bash
Hello
```

Et si je fais ${str:0:7} on récupère l'espace et le W d'accord comprenez un peu le principe.

Voilà comment on peut faire à ce stade là donc ça c'est très pratique d'accord voyez longueur, passage en minuscule passage en majuscules et extractions de chaîne donc c'est quand même pas mal pratique à ce stade.

Alors il y a encore pas mal de petites opérations comme ça que je vais vous montrer et qui sont quand même très pratique.

On va pouvoir également procéder finalement à l'inverse de notre extraction c'est à dire qu'on va pouvoir faire carrément de la suppression mais on le verra après parce qu'il faut peut-être que je vois tout ce qui est remplacement puisque ça reprend un peu la syntaxe d'un remplacement de on va dire motifs par un autre et on partira de cette syntaxe pour faire carrément une suppression finalement dans notre chaîne.

## Remplacement

Passons donc à la suite maintenant qu'on a vu ça par le remplacement dans une chaîne de caractère, qu'est ce que ça veut dire ? très simplement, on va identifier un motif par exemple de dire je remplace par exemple les lettres l minuscule ici 'Hello World !' d'accord, je veux les remplacer par un autre caractère d'accord on remplace donc un motif qu'on va chercher dans notre chaîne par un autre.

La syntaxe de départ c'est `${str/l/k}` où on recherche le motif `l` qu'on veut remplacer par `k`.

Quand j'exécute voilà ce qu'on obtient.

```bash
#!/bin/bash

str='Hello World !'

echo ${str/l/k}
```
```
sam@sam:~$ ./main.bash
Heklo World !
```

On a donc remplacé si vous regardez visuellement la première occurrence rencontrée et on ne l'a pas fait pour les autres.

Même principe que pour le passage en minuscule en  majuscules et maintenant vous commencez à le comprendre sûrement, il suffit de doubler ici un caractère quelque part dans notre notation donc là on double le premier slash `${str//l/k}` pour dire donc dans notre chaîne ici la variable str, que toutes les occurrences (pour ça qu'il y a un double slash) de l minuscule vont être remplacées par un k minuscule.

Là si je rééxécute le programme on a bien changé toutes les valeurs d'accord donc c'est pas mal pratique à ce niveau là.

```bash
#!/bin/bash

str='Hello World !'

echo ${str//l/k}
```
```
sam@sam:~$ ./main.bash
Hekko Workd !
```

On peut affiner encore un peu plus la recherche.

On n'est pas obligé de chercher dans la totalité de notre chaîne.

Alors comme il n'y qu'une seule occurrence donc on ne va pas mettre le slash.

Par exemple faire une recherche précisément au début de notre chaîne ou à la fin de la chaîne.

Alors là bon j'ai pris un cas qui va fonctionner ici mais par exemple je peux dire je veux en fait remplacer que un H majuscule en début de chaîne donc je vais remettre à nouveau le symbole # ici, et le remplacer par exemple un V, `${str/#H/V}`.

```bash
#!/bin/bash

str='Hello World !'

echo ${str/#H/V}
```
```
sam@sam:~$ ./main.bash
Vello World !
```

Là comme la chaîne commence par un H, ça fonctionne.

Si j'essaye de remplacer un l par un v comme la chaîne ne commence pas par un l minuscule, ça ne marche pas.

```bash
#!/bin/bash

str='Hello World !'

echo ${str/#l/V}
```
```
sam@sam:~$ ./main.bash
Hello World !
```

On a eu aucun remplacement qui a été fait, c'est logique.

Maintenant on voit que ma chaine termine par un point d'exclamation ben moi j'ai envie de remplacer ce point d'exclamation par exemple par un underscore par exemple tout bête et bien là on à l'inverse, on va mettre un % donc c'est l'inverse du dièse # ici pour dire début ou fin du motif et le point d'exclamation et on le remplace par underscore.

```bash
#!/bin/bash

str='Hello World !'

echo ${str/%!/_}
```
```
sam@sam:~$ ./main.bash
Hello World _
```

Voilà voyez un petit peu la syntaxe, je réexécute le programme et voilà voyez qu'au niveau de l'affichage ici on a bien remplacé le point d'exclamation par underscore.

C'est donc très pratique, on peut faire comme ça des modifications ou en tout cas du remplacement dans notre chaîne donc ça c'est quand même très important.

## Suppression

Est-ce qu'on peut aborder une autre partie ? oui maintenant on va voir la suppression.

Je voulais revenir tout à l'heure sur la suppression notamment pour enlever en fait une partie d'une sous-chaîne.

Maintenant on peut le voir parce qu'en fait ça fait partie d'un petit peu de cette notation par exemple `${str//l/}` et je vais vous montrer un petit peu ce qui se passe parce que ce sera plus simple visuellement si vous voyez un peu le principe.

```bash
#!/bin/bash

str='Hello World !'

echo ${str//l/}
```
```
sam@sam:~$ ./main.bash
Heo Word !
```

En gros, j'ai donc doublé le slash // c'est important parce qu'on va travailler sur l'ensemble d'accord et j'ai dit en fait on cherche un l et ici comme ne fait pas de remplacement ben je ne met rien derrière parce que si je fais ça `${str//l/m}` je rappelle là ça va remplacer par des m mais si vous ne mettez rien ici `${str//l/} au niveau du motif de remplacement ben en fait il y a quelque chose ça veut simplement dire qu'il n'y a rien en fait d'accord c'est même pas qu'on a une espace non, on n'a rien.

Comme on n'a rien bah ça revient simplement à remplacer par une chaîne vide d'accord donc on  remplace pas rien du tout et ça supprime le caractère.

Voyez donc là on a enlevé en fait toutes les lettres l minuscule donc c'est pas mal pratique.

Si on va opérer bien sûr sur la première occurrence d'accord.

```bash
#!/bin/bash

str='Hello World !'

echo ${str/l/}
```
```
sam@sam:~$ ./main.bash
Helo World !
```

Là on a enlevé en fait un premier l seulement et pas le reste, toujours pareil quand vous travaillez sur le premier motif rencontré, généralement vous avez qu'un seul caractère dans la notation et dès que vous doublez c'est pour traiter sur la totalité.

Rappelez vous quand on a vu pour des virgules, pour le passage en minuscule et cetera et cetera, on a toujours un peu le même principe de doubler le caractère // pour travailler sur l'ensemble en fait de notre chaînep, pour manipuler l'ensemble.

Voilà donc une notation qui est ma foi très particulière ici que vous allez pouvoir pas mal utilisé.

Ce qu'on va pouvoir aussi faire à ce stade alors qu'est-ce qu'on peut faire ...  on va faire pareil dans la suppression mais de la suppression par rapport un intervalle si vous voulez de valeur d'accord.

Par exemple de se dire alors au départ la partie finalement la plus basique dans str ici je veux enlever donc déjà mettre un dièse sur le qu'elle, on va travailler et je vais enlever le H jusqu'au caractère o minuscule en mettant un astérisque *, `${str#H*o}`.

```bash
#!/bin/bash

str='Hello World !'

echo ${str#H*o}
```
```
sam@sam:~$ ./main.bash
World !
```

Voilà ce qu'on obtient donc il a bien rencontré le H majuscule, il est allé voir jusqu'où il rencontrait un 'o' et hop cette partie voyez il l'enlève d'accord et ensuite il affiche le reste.

Voilà on a fait donc une suppression d'un intervalle finalement de valeur d'accord qu'on a ici.

Si on veut aller beaucoup plus loin càd qu'il a pris si vous voyez la chaîne la plus courte possible.

Si on regarde bien on voit que o minuscule, on en a un plus loin càd qu'on pourrait si on dit par exemple d'aller de H majuscule à o minuscule, effectivement ce motif fonctionne "Hello" et on voit aussi que ce motif fonctionnerait tout à fait d'accord "Hello Wo" on va bien de H majuscule à o.

Le problème c'est que ça fonctionne comme ça, avec le dièse il s'arrête en fait au motif le plus court d'accord à la sous-chaîne la plus courte qu'il a trouvé.

Pareil si vous voulez travailler sur la plus longue et bien vous encore une fois vous doublez le caractère au niveau de notation et là automatiquement on a ça.

```bash
#!/bin/bash

str='Hello World !'

echo ${str##H*o}
```
```
sam@sam:~$ ./main.bash
rld !
```

Voilà on a "rld !" puisque là on vient de retirer "Hello Wo", c'est bien ce qu'on avait indiqué.

Voilà très pratique comme notation, on peut faire pas mal de choses avec ça donc vous avez déjà un ensemble, il en existe pas mal d'autres et encore une fois on aurait pu utiliser la commande `expr` pour faire pas mal de choses avec mais ça revient en fait à faire pour beaucoup la même chose mais avec une notation différente donc aucun intérêt de vous énumérer toutes les notations.

Moi je voulais vous montrer celle ci `${str##H*o}` parce que je trouve qu'elle est quand même pas mal lisible et on la comprend bien aussi.

Je trouve que c'est assez simple à utiliser à ce stade et comme c'est un syntaxe que vous avez déjà rencontré de toute façon précédemment avec les accolades.

Au moins ici vous arriverez facilement à vous en servir par rapport à ce qu'on a vu.

## Remplacement et indice

Avec cet exemple-là on a pas avec cette notation parce qu'on a on a notamment la commande `set???` éventuellement qui est une commande assez complète, on peut faire plein de choses avec un `set???` c'est assez riche que je n'ai pas forcément montré là et qui permet de faire ça mais sans la commande `set???` en gros de se dire on va remplacer un caractère a une position bien précises par un autre.

Par exemple le caractère qui est à l'indice ici `hello` d'accord donc ce serait 0 1 2 3 et 4 voilà celui qui est à l'indice 4, je le remplace par autre chose.

```bash
#!/bin/bash

str='Hello World !'
```

Comment on pourrait faire ça d'accord du style tu le remplace par un i voilà vous remplacez ce caractère là par un i.

Dans certains langages, on peut très facilement le faire d'accord suivant les langages de programmation on aurait une fonction toute faite, une méthode genre setCharAt(4) par exemple pour faire ce remplacement ici.

Là avec la notation qu'on a, on n'a pas vraiment d'outils direct pour le faire.

Par contre ce qu'il faut comprendre c'est que vous pouvez parfaitement cumuler ces manipulations de chaînes d'accord qu'on fait d'accord on peut parfaitement le faire.

Par exemple je peux faire ça `${}` puis ça ferra un rappel sur les doubles guillemets. Voilà, je peut très bien faire `${str:0:5}` et ensuite je fait ça `${str:0:5}${#str}`.

```bash
#!/bin/bash

str='Hello World !'

echo ${str:0:5}${#str}
```

Si vous avez bien compris, `${str:0:5}` permet d'extraire la sous-chaîne depuis l'indice 0, 5 caractères et `${#str}` c'est pour la longueur de la chaîne.

Si j'affiche à l'exécution on obtient ça.

```
sam@sam:~$ ./main.bash
Hello13
```

Admettons que la formatage ne nous plaît pas, on veut séparer, on n'aurait pour reflexe de faire ça `${str:0:5} ${#str}` d'accord.

```bash
#!/bin/bash

str='Hello World !'

echo ${str:0:5} ${#str}
```
```
sam@sam:~$ ./main.bash
Hello 13
```

On voit que ça fonctionne mais maintenant si je fais ça `${str:0:5}          ${#str}` on voit que ça ne fonctionne pas.

```bash
#!/bin/bash

str='Hello World !'

echo ${str:0:5}          ${#str}
```
```
sam@sam:~$ ./main.bash
Hello 13
```

Voilà ça ne fonctionne pas, on traite qu'une seul espace au niveau du formatage.

C'est là aussi, petit rappel, avec l'usage des doubles guillemets puisque on sait qu'elle interprète le contenu parce que ${str:0:5} et ${#str} sont comme des variables en fait on traite, interprête une expression ici tous les caractères sont pris en compte, très important.

```bash
#!/bin/bash

str='Hello World !'

echo "${str:0:5}          ${#str}"
```
```
sam@sam:~$ ./main.bash
Hello          13
```

Voilà tout les catactères sont pris d'où le fait donc ça c'est plus pour rappel d'utiliser ces symboles.

C'est quand même toujours plus pratiques d'accord de gérer ça en fait avec des guillemets comme ça voilà on a en fait un formatage bien précis qui est bien respecté.

Voilà ça c'était plus pour le petit rappel alors pourquoi je vous indique ça, tout simplement vous avez vu dans une seule commande j'ai utilisé plusieurs fois cette syntaxe `${}`.

Qu'est-ce que ça veut dire de remplacer ce caractère à l'indice finalement 4 d'accord par par exemple la lettre i, le caractère plutôt i et bien en fait ça veux simplement dire finalement d'extraire la partie qu'on veut donc c'est à dire ça "hell" d'accord c'est de l'indice 0 avec 4 caractères donc c'est `${str:0:4}` et je cumule avec autre chose.

```bash
#!/bin/bash

str='Hello World !'

echo ${str:0:4}
```

Ici le 'o' on n'en veut plus, on a dit qu'on veut le remplacer par un 'i' pas de problème, je le met là `${str:0:4}i`. Je vous rappelle que `echo` affiche en fait tout ce qu'on lui donne là, pas de problème à la rigueur sans même être précis on peut mettre des guillemet si vous avez peur de vous tromper.

```bash
#!/bin/bash

str='Hello World !'

echo "${str:0:4}i"
```

Voilà comme ça vous ça vous fait la coloration dans votre éditeur et vous verrez que c'est bien quelque chose qu'on va afficher donc ça on est d'accord on l'a vu précédemment ça va bien nous afficher ça, "hell".

Là on affiche le i après donc on aura bien "helli" donc on va bien voir fait le changement qu'on veut et on veut récupérer la suite donc la suite on la connaît aussi il suffit de partir d'un indice jusqu'à la fin donc si vous voulez vous arrêter à l'indice **n** et bien la suite c'est l'indice **n+1** d'accord c'est toujours 1 de plus puisqu'on a ici remplacer un seul caractère et si c'était deux bon évidemment ça changerait.

```bash
#!/bin/bash

str='Hello World !'

echo "${str:0:4}i${str:5}"
```
```
sam@sam:~$ ./main.bash
Helli World !
```
Voilà j'ai fait mon remplacement donc ça c'est une petite astuce que vous pouvez faire qui fonctionne ou bah quand vous n'avez pas forcément de notation précise pour dire qu'à tel indice tu remplaces par autre chose d'accord on ne peut pas s'amuser à dire par exemple `${str/str[4]/i}` pour remplacer par i, non ça ne marche pas.

De toute façon, on va voir après on va aborder d'autres choses sur ce cours.

`"${str:str[4]:}i${str:5}"` voilà en fait on reconstruit si vous voulez une nouvelle chaîne, on prend une extraction `${str:str[4]:}`, on met le caractère qu'on veut remplacer 'i' et on met le reste, terminé.

Voilà on est obligé de faire deux parties parce que là ici notre 'i' tombe au milieu de la chaîne donc il ne tombe pas au tout début ou à la toute fin, forcément on est obligé d'avoir l'extraction pour prendre le début de notre chaîne d'accord la partie qu'on veut avant, le caractère de remplacement et la partie qui vient après le caractère qu'on a remplacé.

On peut donc parfaitement composer tout ça et ça fonctionne aussi d'accord et je rappelle bien sûr si je fais ça dans une nouvelle chaîne du newstr d'accord ça va fonctionner et là en plus on aura vraiment modifier notre variable.

```bash
#!/bin/bash

str='Hello World !'
newstr="${str:str[4]:}i${str:5}"
echo $newstr
```
```
sam@sam:~$ ./main.bash
i World !
```

On change l'information très important d'accord c'est à dire que là on ne fait pas qu'un affichage mais on a modifié en fait cette partie et donc on a plus la même
information c'est dire que là en fait on a perdu ça `${str:str[4]:}` et automatiquement on ne la plus.

Très important bien sûr entre le changement `newstr=` et l'affichage `echo`.

L'affichage je rappel on manipule mais on ne va pas modifier, là le problème c'est comme on a deux opérations qui sont faites donc ça tombe bien que je vous montre ça et bien automatiquement on va changer en fait ce qu'on a d'accord donc ça il faut le savoir aussi.

## printf

Voilà je pense que pour cette deuxième partie on a eu pas mal de choses ça vous fait un plein de petit outil pour manipuler vos chaînes donc il n'y en a pas mal mine de rien.

Voilà on va terminer et ça j'en parle pour ceux qui programment notamment en langage c par une petite fonction très pratique que vous utilisez en langage c pour faire de l'affichage, que vous allez pouvoir utiliser également en Bash d'accord parce que c'est intimement liés mais la syntaxe va légèrement changer mais honnêtement ce ne sera pas compliqué d'accord.

Alors principe tout simple et c'est ce qu'on nous allons voir, alors on va mettre ceci.

```bash
#!/bin/bash

animal='chat'

echo "Bonjour le ${animal}"
```
```
sam@sam:~$ ./main.bash
Bonjour le chat
```

D'accord ça c'est la notation qu'on avait vu précédemment sur le cours avec les variables tout ça ok ça fera un remplacement directement et vous n'êtes pas obligé d'utiliser `echo`.

Dans certains cas, vous allez peut-être vouloir faire du formatage de texte donc là on n'est plus vraiment dans la manipulation de chaînes de caractères mais plus dans du formatage puisque c'est une vidéo sur les chaînes de caractères que je vous propose ici et bien vous allez pouvoir utiliser la fonction `printf` que vous utilisez en langage c si bien sûr vous programmé
dans ce langage.

```bash
#!/bin/bash

animal='chat'

printf "Bonjour le ${animal}"
```
```
sam@sam:~$ ./main.bash
Bonjour le chatsam@sam:~$ 
```

Attention donc là il n'y a pas de parenthèse d'accord on n'est pas en langage c directement, vous avez vu qu'en Bash on ne fait pas de parenthèse ici on a directement le texte et c'est comme ça que ça fonctionne.

Déjà si je fais ça vous voyez qu'on n'a pas le forcément le retour à la ligne, on doit faire ça comme ça ok donc là ça va être bon.

```bash
#!/bin/bash

animal='chat'

printf "Bonjour le ${animal}\n"
```
```
sam@sam:~$ ./main.bash
Bonjour le chat
```

Voilà on peut utiliser les caractères spéciaux **les méta caractères** \n, \t pour une tabulation, \r pour un retour chariot, etc, etc, ça fonctionne mais le principe c'est de vouloir formater, c'est surtout ça qui est intéressant au niveau de `printf` parce que si on fait ça autant utiliser un `echo` c'est la même chose.

Alors si vous utilisez déjà `printf` dans d'autres langages vous saurez le faire donc je ne vais pas vous apprendre grand grand chose de nouveau mais comme le but c'est de considérer que les gens n'ont jamais forcément programmés ailleurs, sachez que vous allez avoir en fait des caractères de remplacement d'accord des symboles en fait de remplacement.

Pour ça je vais vous indiquer en tant de commentaires, on va en retrouver 4 parce que c'est les principaux vous avez manipuler. Vous allez avoir le %c qui correspond à un caractère, vous allez avoir le %s qu'on
connaît bien c'est une chaîne de caractères, on va avoir le %d pour un nombre entier et on va voir le %f pour un flottant donc un nombre flottant.

```bash
#!/bin/bash

# %c : caractère
# %s : chaîne de caractères
# %d : nombre entier
# %f : nombre flottant
```

Je vais vous montrer ces quatres là, ci-après vous voulez en voir d'autres tel que afficher en valeur hexadécimal ou autre bien sûr vous pourrez vous pourrez vous référer à un manuel ou à une doc qui concerne cette fonction `printf` et vous verrez qu'au niveau de son fonctionnement c'est la même chose que la fonction printf en c, il n'y a pas de différence à ce stade là et on va pouvoir manipuler ça comme ça.

Alors comment ça ça se traduit en fait à ce niveau là et bien au niveau de mon texte plutôt que d'afficher directement le contenu j'indique par ce caractère ce que je veux. On sait que animal ici c'est une chaîne donc je vais utiliser cet ensemble là d'accord pour indiquer bonjour le %s, `printf "Bonjour le %s\n"`.

Et ici on va devoir remplacer càd qu'au moment de l'interprétation de `printf` il va falloir qu'il puisse remplacer ça par quelque chose d'accord.

Voilà donc là c'est là que ça a son intérêt soit vous mettez ceci.

```bash
#!/bin/bash

animal='chat'
printf "Bonjour le %s\n" animal
```
```
sam@sam:~$ ./main.bash
Bonjour le animal
```

Voyez que j'ai mon texte qui est là entre double guillemets, j'ai une espace et ensuite vous mettez le nom de la variable, on peut éventuellement les cumuler avec des virgules s'il y en a eu plusieurs.

Au mieux on peut passer par cette notation, `${animal}` qui est pas mal pratique.

```bash
#!/bin/bash

animal='chat'
printf "Bonjour le %s\n" ${animal}
```
```
sam@sam:~$ ./main.bash
Bonjour le chat
```

Voilà il va voir ça, il va donc chercher dans la liste ici des variables que vous lui passé et qui correspond, il va le remplacer dans le même ordre
d'accord car si je met admettons.

```bash
#!/bin/bash

animal='chat'
age=5
printf "Bonjour le %s de %d ans\n" ${animal} ${age}
```
```
sam@sam:~$ ./main.bash
Bonjour le chat de 5 ans
```

Voilà il affiche le texte, il rencontre ici un caractère spécial %s d'accord qui doit remplacer donc il va chercher la première variable que vous lui indiquez, la chaîne donc c'est celle là qu'il remplace son contenu donc c'est chat et il continue là %d il attend un nombre entier et il a cherché une variable  pour capturer ça donc là on a bien un formatage d'accord en fonction du type de données que nous voulons.

Voilà si vous aviez donc fait de la programmation en langage c sachez que vous pouvez utiliser cette fonction pas mal pratique à ce stade et je voulais terminer de toute façon cette petite séance avec l'usage des `printf` parce que je pense que ça pourra vous servir de temps en temps même si vous pouvez déjà utiliser `echo` ça fonctionne très bien aussi.

C'est à vous de voir au cas par cas dans quels cas vous allez plutôt utiliser telles commandes, telles fonctions ou plutôt une autre.

A vous de voir bien sûr à l'usage ce que vous préférez et qu'est-ce qui est le plus pratique pour vous.

Voilà on va s'arrêter, là je pense qu'on a fait le tour pour ce qui me semble essentiel en tout cas au niveau de la manipulation de chaînes de caractères en Bash.

Comme d'habitude là vous avez plein plein d'outils pour pouvoir vous entraîner, c'est très pratique vous pouvez faire plein de scripts, faire tout un tas de manipulation sur plusieurs exemples de chaînes différentes dans votre code comme ça vous verrez un petit peu comment fonctionnent ces notations parce que voyez qu'il y a des dièses, il y a des %, il y a des virgules, il y a des des accents circonflexes, des slash.

Vous pouvez également travailler, je n'ai pas montré au niveau du remplacement mais si vous regardez cette vidéo vous suivez un peu mon ordre de publication de vidéos sur youtube, j'en ai pas parlé mais bon je peux vous le dire aussi à ce stade de toute façon c'est qu'au niveau du motif bien sûr vous pouvez le remplacer par une expression rationnelle.

Voilà ça on peut capturer une expression rationnelle et faire un remplacement par autre chose ça fonctionnerait tout à fait d'accord donc j'ai publié une vidéo sur les expressions rationnelles sur la chaîne si vous ne savez pas ce que c'est, vous pouvez vous en servir aussi et bien évidemment après c'est quelque chose qui est applicable et utilisable partout dans les langages de programmation donc n'hésitez pas ça fonctionne très bien avec Bash aussi quand on veut capturer un motif très particulier sans forcément capturer un mot bien précis.

Voilà on peut faire comme ça des captures de remplacement bien précis avec les expressions rationnelles.

Je vous dis à bientôt pour la suite de ce cours.

La prochaine fois on verra un autre concept très importants qui sont les tableaux en Bash c'est quelque chose qu'on trouve beaucoup en programmation aussi.

Bash ne fais pas vraiment exception à ce stade là, à ce niveau là en tout cas donc on verra ça pour la prochaine séance.

Je vous dis à bientôt, n'hésitez pas à vous entraîner.

Bon codage et on se retrouve pour la suite en tout cas sur ce cours.

A bientôt tout le monde