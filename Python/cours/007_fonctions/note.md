# [7. Fonctions](https://www.youtube.com/watch?v=7aOeZ0cYc_Y)

+ [Créer une fonction](#Créer-une-fonction)
+ [Appel de fonction](#Appel-de-fonction)
+ [Fonction avec paramètres](#Fonction-avec-paramètres)
+ [Paramètre par défaut](#Paramètre-par-défaut)
+ [Paramètres infinis](#Paramètres-infinis)
+ [Valeurs de retour](#Valeurs-de-retour)
+ [Une fonction de menu (pas de code)](#Une-fonction-de-menu)

Bienvenue pour cette 7e séance. 

Nous allons parler des fonctions, on va voir un petit peu comment on les utilise et comment créer nos propres fonctions à nous.

okay donc on va regarder un petit peu comment faire tout ça, comment ça fonctionne sans plus attendre. Je vais vous montrer rapidement. 

Alors jusqu à présent vous avez déjà utilisé tes fonctions sur les premières séances qu'on a fait. Un petit rappel rapide sur les fonctions qu'on avait déjà vu. 

Donc on avait des fonctions, fonctions vues, on a la fonction print() Que vous connaissez appeler parce que c'est celle qui vous servez à afficher du texte à l'écran ou même des variables. 

```py
coding:utf-8

#Fonctions vues : print()
```
On avait vu la fonction input () qui permet de faire de la saisie d'information auprès d'un utilisateur.

```py
coding:utf-8

#Fonctions vues : print(), input()
```
On a vu la fonction type() qui permet de connaître le type et plus exactement la classe mais on en reparlera quand on fera de la programmation objet en python Pour récupérer en fait le type d'une donnée, d'une variable.

```py
#coding:utf-8

#Fonctions vues : 	print(), input()
#                   type()
```
Et on a vu quelques fonctions de cast comme int(), float(), str() et cetera Que j'avais d'ailleurs commenté de cette manière pour que vous ayez un petit mémento ou un petit rappel qui permettait de transformer, de caster le type d'une variable. 

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#				    type(), int(), float(), str(), bool() 
```
Rappelez-vous par exemple quand vous demandez un âge à un utilisateur, le input() prend automatiquement tout comme une chaîne de caractères donc c'est à vous de faire un cast en int() pour vraiment bien le prendre comme un entier et pas comme un texte, faire une comparaison d'un âge sous forme de texte ça ne sert à rien Donc il faut vraiment ici un nombre. 

Voilà grosso modo ce qu'on avait vu, on a vu également format si vous vous souvenez qui permettait de bien formater l'affichage de variables dans un texte mais je vous avais expliqué en réalité que c'était une méthode de la classe str donc de la classe String qui est pour les chaînes de caractères mais comme on n'a pas encore vu d'objets pour le moment, je ne vais pas rentrer dans les détails à ce niveau-là.

Voilà grosso modo les fonctions qu'on a vu, vous voyez qu'une fonction, on retrouve quelque chose d'assez répétitif, elle a des parenthèses même si j'ai laissé des parenthèses vide mais la plupart du temps, on peut avoir des choses dedans lorsqu'on appelle ce genre de fonction. 

Donc on va reprendre cet exemple là pour utiliser, après tout, des fonctions que l'on connaît bien : 

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

print("Bonjour à tous ! :)")
```
Alors on va faire un petit python main.py
```powershell
>python main.py
Bonjour à tous ! :)
```
Vous voyez que là ça s'affiche bien.
Donc là on voit rapidement, on a le nommage directement de la fonction Et on va avoir entre parenthèses ce qu'on appelle des paramètres.

Donc lors d'un appel, elle va prendre ces informations et elle va ensuite fonctionner par rapport à ce qu'on lui donne, print() va afficher tout simplement tout ce qu'on lui donne ici même si on utilise du format() dedans ou d'autres fonctions à l'intérieur comme vous avez vu où qu'on mettrait des noms de variables, elle va bien savoir se comporter par rapport à tout ce qu'on lui donne et produire un résultat tout simplement. 

Une fonction grosso modo si je dois vous donner une bonne définition, histoire aussi d'avoir des bonnes habitudes de développement, c'est tout simplement une petite boîte qui va prendre un certain nombre de paramètres. Ça pourrait être les ingrédients et elle va suivre une recette donc un algorithme pour produire un résultat donc en général quand on veut être assez rigoureux en informatique c'est une règle que beaucoup de développeurs respectent en tout cas, ils se mettent d'accord là-dessus, c'est qu'une fonction est censée faire qu'une seule chose à la fois.

Par exemple, si je prends l'exemple d'une imprimante en réduisant l'exemple à quelque chose de très simpliste, on va avoir une fonction pour imprimer, une fonction pour vérifier l'encre, une fonction pour vérifier le papier et cetera. 

C'est dans une seule fonction vous avez la vérification de l'encre, la vérification du papier, la vérification s'il n'y a pas de bourrage papier et cetera, ça fait beaucoup trop de choses pour une seule et même fonction Donc il faut vraiment bien répartir, chaque fonction à son rôle comme chaque employé qui aurait un rôle dans son entreprise.

Donc comprenez vraiment qu'une fonction fais un traitement à la fois, n'hésitez pas à créer plusieurs fonctions pour plusieurs traitements plutôt que de tout mettre dans une seule fonction. 

Ça ne sert à rien de faire des fonctions de 150000 lignes, le but c'est qu'elle ne fasse qu'une seule chose vraiment. 

Donc ça c'est la fonction que vous connaissez. Grosso modo vous avez vu que c'était ça.

On avait également qu'il y avait des fonctions qui pouvaient retourner quelque chose, print(), vous voyez qu'on récupère jamais son résultat ou autre. On se contente de l'écrire comme ça. 

```py
print("Bonjour à tous ! :)")
```

On avait vu par exemple pour le même input(), alors je vais le noter ici. On va prendre l'exemple de l'âge et ensuite on fera le input en demandant quel âge as-tu par exemple, voilà. Ensuite on faisait un petit cast de l'âge et on l'affichait simplement avec un petit format() pour faire ça proprement, voilà.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

age = input("Quel âge as-tu ? ")
age = int(age)

print("Tu as {} ans.".format(age))
```
Voilà je vous remontre rapidement.
```powershell
>python main.py
Quel âge as-tu ? 25
Tu as 25 ans.
```
Voilà, d'accord, vous affichez ça directement comme ça.
Vous voyez que la différence, c'est qu'on a effectivement bien l'appel à notre fonction, input(), qu'on a bien des paramètres quel peux prendre donc ça dépend de la fonction qu'on utilise, c'est comment on l'utilise.

input(), va retourner quelque chose puisqu'on va la stocker dans une variable "age". On a ce qu'on appelle un retour de fonction. 

Une fonction C'est d'abord un nom qui permet de l'identifier, elle peut avoir des paramètres, ce n'est pas obligatoire, le input() j'aurais pu très bien ne rien mettre dedans, il n'y aurait pas eu de phrase mais ça aurait fonctionné mais elle peut et ce n'est pas obligatoire, retourner une information. C'est ce qu'on appelle retour de fonction.

Voilà grosso modo comment ça fonctionne.

Alors les fonctions natives du python, C'est des fonctions que vous allez apprendre au cours de votre formation, Que vous allez apprendre à utiliser, savoir quels paramètres elles peuvent prendre ou pas et savoir si elle retourne une valeur, qu'est-ce que vous pouvez en faire. 

Le but c'est de savoir qu'est-ce qu'on en fait de ce résultat.

Maintenant nous allons voir dans cette vidéo, c'est un petit peu la suite, on va voir comment créer nos propres fonctions est-ce que c'est un petit peu le but. On va regarder ça.

## Créer une fonction

Comment créer une fonction ? 

Alors une fonction comme pour les variables déjà il faut lui trouver un nom, donc pas de nom qui commence par un chiffre, pas de nom avec des caractères spéciaux, des espaces et cetera. Il faut suivre les mêmes règles que le nommage d'une variable.

Et on va commencer par le mot clé def pour define Qui va permettre de dire je définis une fonction que je vais inventer.

```py
def
```

Je lui choisi un nom, de préférence un nom qui n'existe pas dans une fonction native. Si vous l'appelez print(), que vous faites ça.

```py
def print()
```
.. la fonction est déjà réservée donc ce n'est pas possible.

On va lui donner n'importe quel nom, on peut mettre par contre de under score c'est tout à fait autorisé et celle-là je veux dire qu'elle ne prend pas de paramètre. Je laisse la parenthèse vide et je mets : comme pour le IF, comme pour la structure, on montre le début de la structure avec les : et automatiquement on n'oublie pas là tabulation pour bien montrer qu'on est dedans, dans la fonction, Comme quand vous êtes dans un IF ou dans une boucle pour bien montrer que vous êtes à l'intérieur. Et ensuite, on met ce que l'on veut donc moi je vais mettre un petit print() avec Bonjour tout le monde.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire_bonjour():
	print("Bonjour tout le monde")
```
Et là comme pour un print(), vous sortez de la fonction Donc on sort de la tabulation Sinon il faisait toujours considéré comme étant dans la fonction donc sans la tabulation vous n'êtes plus dans la fonction, On va mettre en commentaire je ne suis plus dans la fonction. 

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire_bonjour():
	print("Bonjour tout le monde")

# Je ne suis plus dans la fonction
```
## Appel de fonction

Voilà je ne suis plus dans la fonction parce que je n'ai plus de tabulation Et là on peut faire l'appel, l'appel c'est comme vous le savez le faire avec le print(), le imput(), n'importe quoi. Vous nommez votre variable "dire_bonjour" et entre parenthèses vous mettez des paramètres s'il en faut et s'il n'en faut pas vous ne mettez rien, voilà.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire_bonjour():
	print("Bonjour tout le monde ! :)")

# Je ne suis plus dans la fonction
dire_bonjour()
```
Et suivant l'éditeur, la fonction dire_bonjour() change de couleur, se met en rouge parce que l'éditeur différencie les fonctions utilisateurs des fonctions native même si la met en bleu pour la définition "def dire_bonjour():".

Et là évidemment faisant l'exécution du programme, vous voyez que ça fonctionne, il a été capable de lire le contenu de la fonction.
```powershell
>python main.py
Bonjour tout le monde ! :)
```
Donc ça c'est une possibilité.

## Fonction avec paramètres

Maintenant on va voir comment faire une fonction avec des paramètres parce que c'est l'intérêt c'est justement d'utiliser ces fameux paramètres. 

Je ne vais pas utiliser cet exemple de Bonjour, je vais utiliser un autre exemple. On va faire une fonction de dialogue, admettons vous faites un jeu vidéo n'importe quoi, c'est encore une fois très basique, il n'est pas question de faire un jeu vidéo tout de suite, ce serait un petit peu tôt mais on va faire par exemple une fonction dire().

```py
def dire()
```

Voilà un nom qui est très très recherchée comme vous pouvez le constater et on va mettre par exemple "nom", le nom de la personne, on peut d'ailleurs être plus précis et mettre "nom_personne", le nom de la personne et on peut mettre le message "message_personne", on va mettre des noms de variables très explicites comme ça, voilà. Et ensuite on va faire un print(), on va dire du coup qu'une personne dis tel message donc tout bête, on n'a rien fait de compliqué, voilà, tout simplement.
```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire(nom_personne, message_personne):
	print("{} : {}".format(nom_personne, message_personne))
```
Et la pareil, l'avantage c'est qu'au lieu de répéter du code, vous allez pouvoir tout simplement via un appel, dire Bonjour à tous et Tom va dire Salut.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire(nom_personne, message_personne):
	print("{} : {}".format(nom_personne, message_personne))

dire("Jason", "Bonjour à tous")
dire("Tom", "Salut !")
```
Et automatiquement petite exécution, on a, voyez :
```powershell
>python main.py
Jason : Bonjour à tous
Tom : Salut !
```
On a le dialogue qui se fait, c'est très pratique. 

Donc vous avez compris, je pense mais je tiens quand même à le préciser. Une fonction permet notamment de ne pas répéter du code. En informatique c'est super important quand vous avez un code qui est identique parce que là si j'avais voulu faire ce dialogue, il aurait fallu que j'écrive 2 fois cette grande ligne-là de print().

```py
print("{} : {}".format(nom_personne, message_personne))
```

Et encore une fois ici ce n'est qu'une fonction qui n'est qu'une ligne, en général il y en a quand même un peu plus que ça Donc il aurait fallu pour chaque moment où je veux l'utiliser, où je veux faire ce qu'il y a inscrit là-dedans.

```py
print("{} : {}".format(nom_personne, message_personne))
```

Il aurait fallu faire un copier coller de cette phrase donc ça aurait été répétitif, pas propre du tout. 

Donc ça c'est une règle aussi en informatique, à partir du moment où on a un code qui se répète ce qui a priori vous devez le mettre dans une fonction parce que c'est quelque chose qui est répétitif, récurrent dans votre programme, donc faites-en une fonction.

Donc moi ici là récurrence c'était un dialogue, un personnage qui parlait donc j'en ai fait une fonction C'est comme ça un peu plus pratique.

Même si c'est une fonction qui n'a qu'une ligne, il y a parfois des fonctions qui n'ont qu'une seule instruction, C'est tout à fait possible, ça fonctionne tout à fait, il n'y a pas de problème à ce niveau-là. Donc vous pouvez le faire, pas de problème.

## Paramètre par défaut

Voilà donc ça c'est bon, on va voir à ce niveau là (paramètres). Petite précision au niveau des paramètres parce que vous voyez qu'ici les paramètres je les ai mis … on va faire un petit test si par exemple je mets juste ça, si par exemple je ne mets qu'un seul paramètre alors qu'elle en demande deux.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire(nom_personne, message_personne):
	print("{} : {}".format(nom_personne, message_personne))

dire("Jason")
```
Voilà je n'ai qu'un seul paramètre alors qu'elle en demande 2, en toute logique python ne va pas être content. 
```powershell
>python main.py
Traceback (most recent call last):
  File "main.py", line 229, in <module>
    dire("Jason")
TypeError: dire() missing 1 required positional argument: 'message_personne'
```
Voilà l'interpréteur, il va me dire qu'il manque justement " missing 1 required positional argument", il manque un argument au niveau de la fonction. 

Alors bonne nouvelle en python, on peut sans problème avoir des arguments, enfin des paramètres, on peut très bien employer le terme de paramètres optionnels. 

Pour cela, vous pouvez employer ici dans la définition de la fonction, attention pas dans son appel, vous pouvez choisir des valeurs par défaut.

Moi je dis par exemple que si le nom_personne, si je ne le précise pas, ça va être notre fameux "Tom", nom_personne="Tom".

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire(nom_personne="Tom", message_personne):
	print("{} : {}".format(nom_personne, message_personne))

dire("Jason")
```
Donc par défaut on aura toujours "Tom" parce qu'il est très bavard et au niveau du message, ça va être par exemple "Salut !" par défaut.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire(nom_personne="Tom", message_personne="Salut !"):
	print("{} : {}".format(nom_personne, message_personne))

dire("Jason")
```
Et là pour le précédent regardez si je laisse le code que j'avais mis, vous voyez que ça fonctionne.
```powershell
>python main.py
Jason : Salut !
```
Ça fonctionne d'accord parce que par défaut il voit qu'il n'y a pas de 2e paramètres donc il prend la valeur ici, message_personne="Salut !"

Donc Jason je l'avais renseigné, ici donc pas de souci. Et si je ne me rien du tout.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire(nom_personne="Tom", message_personne="Salut !"):
	print("{} : {}".format(nom_personne, message_personne))

dire()
```
Comme les 2 paramètres sont maintenant optionnels, évidemment ça va fonctionner, pas de problème à ce niveau-là.
```powershell
>python main.py
Tom : Salut !
```
Donc ça va fonctionner, pas de problème à ce niveau-là. 

Ça c'est la différence entre paramètres obligatoires et paramètres optionnels. 

Qu'est-ce qu'on pourrait avoir aussi ? Je veux rajouter un autre paramètre, un peu bizarre, on va dire que c'est l'âge. Et ensuite il faudrait qu'on l'affiche sinon ça ne va pas forcément être utile même si c'est complètement inutile je vous le précise. 

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire(nom_personne="Tom", message_personne="Salut !", age_personne=18):
	print("{} ({} ans) : {}".format(nom_personne, age_personne, message_personne))

dire()
```
Et on va tester donc là normalement en toute logique si je test, ça prend les valeurs par défaut. 
```powershell
>python main.py
Tom (18 ans) : Salut !
```
Autre point, dernier point au niveau des paramètres en python qui est très intéressant, c'est qu'on peut les renseigner dans le désordre lors de l'appel. 

En C++ si vous suivez cette formation, Vous verrez que ce n'est pas possible. Si vous suivez cette formation tous dépendent du moment où vous regardez cette vidéo. Alors déjà enregistrer cette vidéo, il n'y avait pas encore sa formation python mais si vous voyez ça dans quelques mois, dans un an, Elle sera peut-être déjà publié. 

Donc au niveau de notre appel, au niveau de dire(), si la personne a oublié comment fonctionne la fonction ce qui peut arriver, il va mettre 25 ans puis il va mettre son prénom, "Roger". dire("Yo !", 25, "Roger") 

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire(nom_personne="Tom", message_personne="Salut !", age_personne=18):
	print("{} ({} ans) : {}".format(nom_personne, age_personne, message_personne))

dire("Yo !", 25, "Roger") 
```
```powershell
>python main.py
Yo ! (Roger ans) : 25
```
Donc si je lance le programme vous voyez que "Yo !" est devenu le prénom, "Roger" c'est devenu l'âge et 25 c'est devenu le message.

Tout ça parce que python va suivre l'ordre des paramètres, c'est embêtant. 

Il y a une chose que sympa en python c'est qu'on peut préciser l'ordre que l'on veut au niveau des paramètres donc je peux très bien dire que j'ai le fameux message en premier, message_personne="Yo !". Ensuite l'âge de la personne, age_personne=25. Et ça du coup, c'est le nom, nom_personne="Roger", voilà.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire(nom_personne="Tom", message_personne="Salut !", age_personne=18):
	print("{} ({} ans) : {}".format(nom_personne, age_personne, message_personne))

dire(message_personne="Yo !", age_personne=25, nom_personne="Roger") 
```
```powershell
>python main.py
Roger (25 ans) : Yo !
```

Et là tout de suite on va se retrouver avec quelque chose de plus propre, voilà donc on peut gérer comme ça au niveau de l'appel, l'ordre dans lequel on présente les arguments. Ça peut être intéressant parce que des fois, un argument qu'on ne veut pas renseigner, par exemple on va en oublier un c'est-à-dire qu'on va juste mettre ça, dire("Jason", 26), ça c'est un cas que j'avais pas montré.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire(nom_personne="Tom", message_personne="Salut !", age_personne=18):
	print("{} ({} ans) : {}".format(nom_personne, age_personne, message_personne))

dire("Jason", 26) 
```

Et bien admettons que le message, je ne veux pas le mettre, et bien le problème c'est qu'il va forcément décaler.

```powershell
>python main.py
Jason (18 ans) : 26
```

Il a décaler parce que pour lui le premier argument c'est le premier ici dire(nom_personne="Tom"... donc le nom et le deuxième, pour lui, c'est le message, ... message_personne="Salut !" ... donc automatiquement le message ça devient 26, voilà.

Et si je précise bien nom_personne="Jason" et il vaut mieux les préciser tous quand c'est comme ça.
Et ensuite, je précise bien age_personne=26. Python, l'interprêteur, va les remettre dans l'ordre comme il faut, il va bien prendre le message par défaut c'est-à-dire "Salut". Il va le gérer sans problème.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def dire(nom_personne="Tom", message_personne="Salut !", age_personne=18):
	print("{} ({} ans) : {}".format(nom_personne, age_personne, message_personne))

dire(nom_personne="Jason", age_personne=26) 
```

Python, l'interprêteur, va les remettre dans l'ordre comme il faut, il va bien prendre le message par défaut c'est-à-dire "Salut". Il va le gérer sans problème.

```powershell
>python main.py
Jason (26 ans) : Salut !
```

Donc ça c'est très pratique, très flexible. 
On peut faire des paramètres obligatoires, la personne est obligée de rentrer tout et dans l'ordre. Après si ce n'est que des paramètres obligatoires, la personne peut les rentrer en mettant bien à l'appel, comme je vous l'ai montré ici, le nom de la variable concernée nom_personne="Jason", ça fonctionnera pareil.

Sinon on peut mettre tous les paramètres optionnels, la personne choisit ce qu'elle veut mettre ou pas, et on peut en mettre quelques uns, on peut mélanger. On peut vraiment tout faire, appeler mettre dans le désordre si on les renseigne bien et l'interpréter va très bien faire le travail et retrouvera toutes les informations qu'il faut.

Donc ça c'est très très intéressant.

## Paramètres infinis

Et je vais terminer sur un dernier point, donc ça c'était on va dire tout ce qui était flexibilité des paramètres et il y a encore un petit plus.

Alors je vais mettre "items", j'espère que ce n'est pas un mot réservé parce qu'il y a des fois dans tous les langages de programmation, on confond les mots réservés donc "items" Et je vais mettre en anglais, ça va changer un petit peu, une fonction qui va montrer l'inventaire d'un personnage.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def show_inventory(*items)
```

Vous avez remarqué dans la formation que je prends beaucoup d'exemples que l'on peut retrouver dans un jeu vidéo ou autre parce que c'est ce qu'il y a de plus parlant. Un jeux vidéo c'est le genre de projet informatique qui répertorié tous les types d'algorithmes un peu compliqué, les problèmes récurrents que l'on peut retrouver en informatique, les histoires de tri, de listing, de parcours, de cherché des chemins, de lecture de fichier, d'écriture et cetera.

Donc je pense, que ce sont de bons exemples quand on enseigne l'informatique parce que ça parle à tout le monde en général quand on parle de personnages et cetera, de se déplacer et cetera. C'est toujours sympa déjà, beaucoup plus parlant que d'aller calculer l'aire d'un rectangle, c'est tout de suite moins intéressant je trouve.

Donc là on va faire ça, on va afficher un inventaire c'est-à-dire que le but par exemple c'est de pouvoir faire ceci.

```py
show_inventory("épée")
```

Puis des moments, j'aimerais qu'on puisse faire ceci Show_inventory(""). Alors vous allez voir, c'est assez spécial.

```py
show_inventory("épée", "arc", "potion de mana", "cape de Dragon rouge")
```

Vous voyez je prends des noms au hasard Et vous voyez il n'y a pas du tout le même nombre d'arguments et ici j'ai un seul paramètre mais avec une étoile. Okay pour ceux qui font du C, ce n'est pas un pointeur. C'est tout simplement pour spécifier que nous avons un nombre infini, en fait, d'arguments possibles. 0 argument serait un peu inutile mais pourquoi pas. ça peut être 3 ou 4 au lycée par exemple on en a 4 ou qu'un seul. 

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def show_inventory(*items):

show_inventory("épée")
show_inventory("épée", "arc", "potion de mana", "cape de Dragon rouge")
```

Alors comment est-ce que je vais faire ça ? Je vais gérer toutes les informations que j'ai, on va faire un fameux parcours. Vous savez le for qu'on avait vu au niveau de la vidéo sur les boucles. J'avais dit que ça pouvait être très utile dans certains cas pour parcourir même si là on avait fait sur une séquence mais comme on n'avait pas encore parlé de tout ce qui est structure où manière de stocker des données, j'avais dit qu'on le verrai par la suite. 

Je vais donc faire "for item in items" mais "items", c'est un peu spécial, je devrais plutôt faire "list_items" pour ne pas se tromper.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def show_inventory(*list_items):
	for item in list_items:

show_inventory("épée")
show_inventory("épée", "arc", "potion de mana", "cape de Dragon rouge")
```

"for item in items" donc pour chaque item de cet ensemble là "list_items", tu vas me l'afficher donc il va m'afficher "item" tout bêtement donc ça on l'avait vu dans la vidéo sur les boucles. Il crée à chaque fois une variable intermédiaire "item", à chaque tour de boucle, il changeait ce qui permettait de parcourir ce qu'on avait ici "list_items", ça pouvait être une séquence, ça pourrait être un tableau, être n'importe quoi, une liste de quelque chose. 

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def show_inventory(*list_items):
	for item in list_items:
		print(item)

show_inventory("épée")
show_inventory("épée", "arc", "potion de mana", "cape de Dragon rouge")
```

Voilà "épée", "arc", "potion de mana", "cape de Dragon rouge", va fonctionner un peu comme une liste.
Et là.

```powershell
>python main.py
épée
épée
arc
potion de mana
cape de Dragon rouge
```

Voilà.

La première fois vous voyez il affiche l'épée donc pas de souci merci et au 2e appel il affiche l'épée, l'arc, la potion et la cape. 

Et là vous voyez que la fonction va fonctionner de la même manière peu importe le nombre de paramètres que l'on a grâce à cette petite étoile.

Vous mettez une petite étoile le nom paramètre que vous voulez, ça ça ne pose aucun problème, vous le nommez comme vous voulez et après selon les paramètres donc en général on fait un parcours puisqu'en général on ne connaît pas le nombre de paramètres à l'avance, il y a forcément une histoire de boucle pour arriver jusqu à tous les paramètres donc on utilise une petite boucle for qui va bien, pourquoi pas, ça marche très bien, Et après on fait le traitement qu'on a envie là-dessus, print(item).

J'avais simplement envie de faire un petit print() pour ne pas compliquer la chose et ne pas rallonger la vidéo pour rien. 

Voilà voilà donc c'est aussi simple que ça, vous avez grosso modo tout ce qu'il faut par rapport à ça. 

On a vu grosso modo le nommage de la fonction comme les variables, vous voyez qu'il y a des paramètres ou pas de paramètre du tout, ça peut être des paramètres obligatoires ou des paramètres optionnels et on peut les mettre dans n'importe quel ordre surtout au niveau de l'appel en précisant bien le nom de la variable concernée, ça c'est très très flexible.

Et on a également cette possibilité-là d'avoir autant de paramètres que l'on veut avec la petite étoile donc rassurez-vous il n'y a pas de pointeur qu'est-ce qu'il s'agit d'un langage haut niveau, la mémoire est donc gérée par l'interpréteur Python. 

Et comme ça vous pouvez gérer un nombre de paramètres infini donc ça c'est quand même très très très intéressant.

## Valeurs de retour

Voilà, on va terminer sur une dernière chose pour finir cette vidéo là avec les valeurs de retour parce que vous savez que le input() pouvait retourner quelque chose.

Comment fait-on une fonction qui retourne tout simplement une donnée, une valeur, n'importe quoi ? on va faire une fonction très basique, vous vous en doutez bien, Pour l'exemple on va faire une fonction qui va calculer la somme de 2 nombres, donc je vais mettre nombre1 et nombre2 parce que j'aime bien mettre des noms de variable qui sont très explicite plutôt que A et B qui sont un petit peu facile, voilà, et on va pouvoir retourner le résultat.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def calculer_somme(nombre1, nombre2):
```

Alors la méthode un peu plus longue pour ceux qui ont du mal à comprendre et cetera quand on est un peu débutant, qu'on a peur de se tromper, qu'est-ce qu'on va faire ? Eh bien on va simplement faire résultat, on crée une variable résultat et on va dire … ça on l'a vu dans les opérateurs, vous savez faire maintenant des opérations en python … nombre1 + nombre2.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def calculer_somme(nombre1, nombre2):
	resultat = nombre1 + nombre2
```

Pas de nouvelles choses normalement là-dessus, vous devriez être totalement à l'aise avec ce genre d'instruction et après on va justement procéder au retour c'est à dire qu'on va retirer le résultat et on va le sortir de la fonction, On va donc faire un return, ça c'est un nouveau mot-clé que j'ai introduit dans cette vidéo, un return de resultat. 

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def calculer_somme(nombre1, nombre2):
	resultat = nombre1 + nombre2
	return resultat
```

Voilà donc ma fonction calculer_somme il va retourner ça, ce qui est stocké dans resultat et vous voyez que c'est la somme de 2.

Donc là si je fais un appel, je vais faire print(), on va afficher directement, donc calculer la somme de 5 et 16 par exemple, voilà.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def calculer_somme(nombre1, nombre2):
	resultat = nombre1 + nombre2
	return resultat

print(calculer_somme(5, 16))
```

On va virer notre petit inventaire (cls), nous avons donc 21.

```powershell
>python main.py
21
```
Il a retourné le résultat.

Alors pour faire plus rapide, on ne s'embête pas à créer une variable intermédiaire quand on veux optimiser les choses.
Vous pouvez sans problème faire ça, return = nombre1 + nombre2.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def calculer_somme(nombre1, nombre2):
	return nombre1 + nombre2

print(calculer_somme(5, 16))
```

On peut directement retourner directement un calcul, c'est pour ça qu'on avait vu, que j'avais fait une vidéo sur les opérateurs parce que je trouve que c'est important de le savoir, de savoir faire des opérations parce que ça peut servir, pas seulement comme ça dans une instruction ou à stocker dans une variable, ça peut servir dans un retour de fonction, c'est super important.

Et le return, ça c'est la règle, vous ne pouvez en mettre qu'un seul, ne vous amusez pas à mettre un return comme ça juste à la suite. 

Alors ça peut se faire mais c'est que dans tous les cas à partir du moment où vous avez un return avant, ici et que l'interpréteur y arrive. Au premier return De toute façon il sort de la fonction.

```py
def calculer_somme(nombre1, nombre2):
	return nombre1 + nombre2
	return
```

Donc c'est terminé tout ce qui va être lu après le return, Vous pouvez mettre un print(), je peux vous montrer. 

```py
def calculer_somme(nombre1, nombre2):
	return nombre1 + nombre2
	print("Je ne serai jamais lu … :(")
```

C'est triste.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def calculer_somme(nombre1, nombre2):
	return nombre1 + nombre2
	print("Je ne serai jamais lu … :(")

print(calculer_somme(5, 16))
```
```powershell
>python main.py
21
```

Vous voyez, j'ai 21, je n'ai pas le print() qui est affiché. On sort automatiquement. Alors j'ai dit on ne peut pas avoir plusieurs return mais si en quelque sorte, je ne me suis pas très bien exprimé mais ça je vais vous montrer un petit peu. 

On peut sans problème faire alors le calculer_somme sera un peu bizarre, on va plutôt dire par exemple comparer_nombres() pour faire la différence, quelque chose comme ça.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def comparer_nombres(nombre1, nombre2):

print(comparer_nombres(5, 16))
```

Et on peut très bien dire si nombre1 > nombre2, on va faire un return de nombre1, admettons il va retourner le plus grand.  

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def comparer_nombres(nombre1, nombre2):
	if nombre1 > nombre2:
		return nombre1

print(comparer_nombres(5, 16))
```

D'ailleurs ça aurait pu être ça le_plus_grand, c'est une fonction qui retourne le plus grand des 2 nombres. Donc là il fait un return de nombre1.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def le_plus_grand(nombre1, nombre2):
	if nombre1 > nombre2:
		return nombre1

print(le_plus_grand(5, 16))
```

Et sinon, vous voyez j'ai un 2e return de nombre2.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def le_plus_grand(nombre1, nombre2):
	if nombre1 > nombre2:
		return nombre1
	else:
		return nombre2

print(le_plus_grand(5, 16))
```

Pourquoi est-ce qu'il y a 2 return et qu'ici ça ne posera pas de problème ? Vous voyez très bien par rapport à la condition, La fonction ne peut passer que par un seul return, Elle ne peut pas passer par les 2, que par un seul des return. Elle ne peut pas passer par les 2 soit le nombre1 est plus grand que nombre2, soit il est plus petit mais alors s'il est égal donc il faut prendre le cas également si c'était égal donc on va rajouter l'exemple parce qu'il faut corriger à chaque fois, on va mettre le cas nombre1 est plus petit que nombre2 et sinon, si il n'y a rien du tout, on va return "EGALITE" parce qu'on peut mélanger les types, voilà.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def le_plus_grand(nombre1, nombre2):
	if nombre1 > nombre2:
		return nombre1
	elif nombre1 < nombre2:
		return nombre2
	else:
		return "EGALITE !"

print(le_plus_grand(5, 16))
```
Et là, on va regarder au niveau de l'exécution.
```powershell
>python main.py
16
```
Et là il me met 16 puisque 16 est évidemment plus grand.

Si je mets autre chose par exemple, 230 et 16, cette fois-ci il va retourner le 230.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def le_plus_grand(nombre1, nombre2):
	if nombre1 > nombre2:
		return nombre1
	elif nombre1 < nombre2:
		return nombre2
	else:
		return "EGALITE !"

print(le_plus_grand(230, 16))
```
```powershell
>python main.py
230
```

Et si jamais bien sûr les 2 mêmes valeurs, il va retourner EGALITE !

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

def le_plus_grand(nombre1, nombre2):
	if nombre1 > nombre2:
		return nombre1
	elif nombre1 < nombre2:
		return nombre2
	else:
		return "EGALITE !"

print(le_plus_grand(230, 230))
```
```powershell
>python main.py
EGALITE !
```

Vous voyez ça fonctionne donc pas de souci donc là vous voyez j'ai 3 return mais parce que c'est lié à une condition Parce qu'on a pas mis de return à la suite parce que de toute manière le 2e ne serait pas lu. Ça ne poserait pas de problème mais il ne serait jamais lu. Donc ça sert à rien c'est du code inutile.

Qu'ici selon le fonctionnement, selon l'appel que l'on va faire, on peut très bien arrivé là if nombre1 > nombre2 ou là elif nombre1 < nombre2 ou else. On en sait rien à l'avance, on gère 3 cas possible donc on a effectivement 3 return, on a 3 retours de fonction possible.

voilà donc je pense que j'ai fait tour, j'ai fait tout ce qu'il fallait savoir au niveau des fonctions, fonction que vous avez déjà utilisé… comment on créer ? aussi bien sur le dommage, tout ce qui est gestion de paramètres, infini et cetera, obligatoire ou facultatif et le retour de fonction. 

Normalement ça ne devrait plus avoir de secret pour vous, ça ne devrait plus être compliqué, vous voyez que c'est très simple à mettre en place, c'est vraiment très facile. 

On peut créer nos propres fonctions à nous et surtout retenez le plus important c'est-à-dire qu'**une fonction ne peut faire qu'une seule chose à la fois et empêcher la répétition de code**.

Si vous voyez dans un programme, vous avez fait votre menu par exemple, hum vous avez fait le menu principal d'un programme et que vous voyez que vous l'avez écrit plusieurs fois dans votre code, Eh bien faites une fonction menu, menu principal, ce que vous voulez. C'est que vous avez répété du code et à partir du moment où il y a répétition de code, il faut factoriser c'est-à-dire plutôt que de l'avoir 3 à 4 fois dans le même programme, le mettre une bonne fois pour toutes dans une fonction. 

En plus ça peut être géré dynamiquement avec des paramètres, ça peut être sympa, vous avez juste à faire un petit appel et c'est l'appel de la fonction que vous allez justement changer. 

Pourquoi c'est un avantage aussi ? Je vais vous montrer, on va finir avec ça.

## Une fonction de menu

Mettons je fais mon menu, très rapide, c'est vraiment histoire de vous montrer avant de nous quitter. Faire une somme, une différence, et cetera. Vous imaginez qu'il y a plusieurs choses comme ça, on va s'arrêter à 3.

```py
#coding:utf-8

#Fonctions vues : 	print(), input(), 
#   				type(), int(), float(), str(), bool() 

print("1. Faire une somme")
print("2. Faire une différence")
print("3. Quitter le programme")
```

Si je dois m'amuser à le répéter tout le temps, tout le temps, ça risque d'être un petit peu embêtant, d'accord.

En plus de ça, admettons que j'ai besoin de mon programme ici, que je fais mon calcul puis un autre moment dans mon programme j'en ai besoin Eh bien je vais être obligé de faire le copier-coller de mon menu.

```py
print("1. Faire une somme")
print("2. Faire une différence")
print("3. Quitter le programme")


print("1. Faire une somme")
print("2. Faire une différence")
print("3. Quitter le programme")
```

Le jour où vous, ou quelqu'un, décidez d'ajouter les multiplications, vous allez faire quoi ? Vous allez faire ça. Ajouter je ne sais pas quoi, un point 4. Faire la multiplication. On le met dans le désordre mais on s'en fiche.

```py
print("1. Faire une somme")
print("2. Faire une différence")
print("4. Faire la multiplication")
print("3. Quitter le programme")


print("1. Faire une somme")
print("2. Faire une différence")
print("4. Faire la multiplication")
print("3. Quitter le programme")
```

Mais comme vous avez copier-coller le menu à plusieurs endroits, il va falloir le changer à tous les endroits où vous avez mis le menu donc je ne sais pas si vous imaginez, imaginez un projet en taille réelle qui a plusieurs milliers de lignes, avec plusieurs centaines de fois le même code, il va falloir modifier plusieurs centaines de fois votre programme.

C'est juste ingérable que là c'est on a tous dans une fonction, On modifie seulement la fonction et ça va se répercuter partout dans le programme parce que la seule chose que vous avez renseigné dans le programme c'est le nom, c'est l'appel de la fonction. 

Après si vous changez le nom de la fonction, Si vous changez ces paramètres, bien sûr il va falloir modifier tout le programme mais là c'est autre chose, ce serait comme supprimer votre fichier et en refaire un nouveau, c'est sûr que là il faut tout recommencer. 

Mais dans le cas où vous voulez modifier juste ce que fait la fonction, Son traitement, vous n'aurez pas modifié ailleurs dans votre programme parce que les appels seront toujours fonctionnels. 

En modifiant seulement la fonction, Vous allez modifier tout sur votre programme, ça aura la conséquence de absolument tout modifier. 

C'est là que c'est carrément pratique, le fait de ne pas répéter le code et le fait d'avoir encore une fois un seul traitement par fonction, Ça ça permet de bien factoriser les choses et de bien les organiser. 

Voilà, on va s'arrêter pour maintenant, on se retrouvera dans une prochaine vidéo, on continuera un petit peu la suite de tout ça.

Et je vous dis à très bientôt. 

N'hésitez pas à liker et à disliké ce que vous voulez, à partager comme d'habitude. 

Si vous avez des commentaires à faire ou à poster par rapport à cette vidéo n'hésitez pas j'y répondrais

## Resume

```py
###############################################
#################### Resume ################### 
###############################################

#coding:utf-8

# Python #7 - fonctions
# https://www.youtube.com/watch?v=7aOeZ0cYc_Y&list=PLrSOXFDHBtfHg8fWBd7sKPxEmahwyVBkC&index=7
# Il est temps pour vous de réaliser des programmes un peu plus complexes, grâce à l'utilisation de fonctions. Vous allez voir comment créer les vôtres, avec une gestion des paramètres très flexible.

"""
Abordés dans cette vidéo : 

Comment créer une fonction ?
?	Le nommage de la fonction comme les variables.
?	Les paramètres sont soit aucun, soit obligatoire, soit optionnel.
?	Les paramètres sont très flexibles : ils peuvent être mis dans n'importe quel ordre 
   surtout au niveau de l'appel en précisant bien le nom de la variable concernée.
?	Un nombre de paramètres illimités avec * (ce n'est pas un pointeur. C'est un langage haut niveau dont la mémoire est gérée par l'interprêteur).
?	Les retour de fonctions.

Règles les plus importantes :
?	Une fonction fait qu'une chose à la fois, ce qui permet de bien les organiser.
?	Une fonction doit empêcher la répétition de code. C'est à dire factoriser le code dés qu'il y a répétition de code.
   En plus ça peut être gérer dynamiquement avec des paramètres, ensuite c'est juste l'appel de la fonction qui doit changer.
   Par exemple, un menu se répète dans le code et en plus on veux ajouter un xème menu sur les multiplication.
   Et si on a copier / coller le menu et qu'il a été modifier, il faudra remplacer le menu à tous les endroit où on l'a mis.
   Si on modifie seulement la fonction, la répercution touchera tout le programme.
   Par contre, si on modifie le nom de la fonction ou le nombre de paramètres, il faudra modifier tous le programme (comme supprimer le fichier et en refaire un nouveau).
   Dans le cadre où ne modifie que le comportement de la fonction, on aura pas à modifier tout le porgramme. 
   L'aspect pratique est de pouvoir modifier ce que fait un programme et que cela se répercute sur tout le programme.
"""
print("1. Faire une somme")
print("2. Faire une différence")
print("3. Quitter le programme")

print("1. Faire une somme")
print("2. Faire une différence")
print("4. Faire une multiplication")
print("3. Quitter le programme")



#1# Qu'es-ce qu'une fonction.

"""
1.  Parmi les fonction vues : 
-----------------------------
print()     permet d'afficher du texte, des variables.
input()     permet de faire de la saisie auprès d'un utilisateur.
type()      permet de récupérer le type (d'une variable en l'occurence) et plus exactement la classe (voir POO en python).
int(), float(), str(), bool()   fonctions de cast qui permettent de transformer/caster le type d'une variable.
Par exemple, quand on demande l'âge à un utilisateur, input() prend tout comme une chaîne de caractères, 
c'est pourquoi il faut faire un cast en int pour bien le prendre comme un entier.
On fait la comparaison d'un âge sous forme d'un entier plutôt que sous forme d'un texte.

format()    permet de bien formater l'affichage de variables dans un texte.
Format est une méthode de la classe str (string) pour les chaînes de caractères (notion POO).

2.  Une fonction possède :
--------------------------
?	possède un nom qui permet de l'identifier.
?	possède des parenthèses vides ou non (peut contenir des paramètres mais ce n'est pas obligaoire).
?	pemet de retourner une information mais ce n'est pas obligatoire et ensuite comment l'utiliser ?

Une fonction, c'est une petite boîte qui va prendre un certain nombre de paramètres (ingrédients) et elle va suivre un algorythme (recette) pour produire un résultat.

3.  Rôle :
----------

En informatique, il est recommandé qu'une fonction ne permettent de faire qu'une chose à la fois.
Par exemple, une imprimante a une fonction pour imprimer, une autre pour vérifier l'encre, une autre pour vérifier le papier, etc.
Une fonction qui imprime, vérifie l'encre et le bourage papier à la fois est trop lourde et ce n'est pas recommandé.
Chaque fonction a son rôle. Il est recommandé d'avoir des fonctions courtes.

Une fonction permet de ne pas répéter de code quand les codes sont identiques.
C'est une règle en informatique. Quand un code se répète, il faut le mettre dans une fonction.
On fait une fonction lorsque ça devient répétitif, récurant dans un programme.

4.  Retour de fonction :
------------------------
L'appel à notre fonction input() avec les paramètres qu'elle peut prendre et cette fonction va 
retourner quelque chose puisqu'on la retourne dans une variable, appelé un retour de fonction.
"""
print("Bonjour à tous ! :)")

age = input("Quel âge as-tu ? ") # Insérer le retour de input() dans une variable ...
age = int(age) # ... faire un cast de age ...
print("Tu as {} ans.".format(age)) # ... afficher l'âge.

#2# Créer et appeler une fonction.
"""
1.  Le nommage : Pas de nom avec un chiffre, avec un caractère spécial. Pas d'espace.
2.  Le mot clé DEF : On commence avec def pour define (définir une fonction qu'on invente).
3.  Choisir un nom qui n'existe pas dans les fonctions natives tel que print() qui est déjà réservée.
4.  Indiquer le début de la structure avec deux points.
5.  Endiquer qu'on encode dans la fonction (dedans) avec une tabulation.
6.  Indiquer qu'on sort de la fonction avec un rabattement.
"""
def dire_bonjour():
   print("Bonjour tout le monde ! :)")
# Je ne suis plus dans la fonction car je n'ai plus la tabulation.

dire_bonjour() # nommer et ajouter des paramètres si nécessaire.

#3# Factoriser en fonction.
# Exemple d'une fonction de dialogue.
# Récurence de personnages qui parle => factoriser en fonction.
def dire(nom_personne, message_personne):
   print("{} : {}".format(nom_personne, message_personne)) # fonction qui permet de ne pas répéter de code (une seule fois, une grande ligne de print). Une fonction avec une seule ligne, une instruction.
dire("Jason", "Bonjour à tous")
dire("Tom", "Salut")

#4# Paramètre obligatoire / optionnel
# Ajouter un seul paramètre alors que la fonction en demande deux.
# L'interprêteur retourne une erreur pour dire qu'il manque un argument au sein de la fonction.
# dire("Jason") # Error car 1 seul argument.
# Il peut y avoir des paramètres optionnels en Python, c'est à dire des paramètres par défaut.
# L'appel de fonction fonctionne même sans paramètres car les deux paramètres sont optionnels.
def dire2(nom_personne="Tom", message_personne="Salut !"):
   print("{} : {}".format(nom_personne, message_personne))

dire2("Jason")
dire2()

#5# Flexibilité des paramètres.
"""
Les paramètres optionnels peuvent être appelés dans le désordre (Ce qui n'est pas possible avec C++).
Avantage de la flexibilité.

Python permet de choisir des paramètres obligatoires qui obligent à rentrer tous les 
paramètres dans l'ordre ou rentrer le nom de la variable concernée pendant l'appel.

Python permet de définir tous les paramètres optionnels et la personne choisit ce qu'elle veut mettre ou pas.

Les paramètres peuvent être mis dans le désordre à la condition qu'ils soient bien renseigné et l'interprêteur
les remettra dans le bon ordre.

"""

def dire3(nom_personne="Tom", message_personne="Salut !", age_personne=18):
   print("{} ({} ans): {}".format(nom_personne, age_personne, message_personne))

dire3("Yo !", 25, "Roger") # Ici Python définis l'ordre par défaut.
dire3(message_personne="Yo !", age_personne=25, nom_personne="Roger") # Ici on gère l'ordre des arguments au moment de l'appel.
dire3("Jason", 26) # Ici le message devient 26 dans l'ordre par défaut.
dire3(nom_personne="Jason", age_personne=26) # Ici on ne veux pas renseigner un des arguments (Dans ce cas, il faut bien renseigner chacun des arguments).

# Par exemple, une fonction qui montre l'inventaire d'un personnage.
# L'avantage des jeux vidéos sont qu'ils répertorient tous les types d'algo compliqués et les problèmes récurant trouvé en informatique (liste, tri, parcours, lecture, écriture fichier).
# choisir un mot 'list_items' (mot non réservé) précédé d'une *.
# *items signifie que l'on a un nombre infini d'arguments possible.
# La fonction fonctionne de la même manière peut importe le nombre de paramètres que l'on a.
# La solution est d'utiliser une boucle for pour parcourir la liste.

def show_inventory(*list_items):
   # Créer une variable intermédiaire à chaque tour de boucle pour parcourir une séquence, un tableau, une liste.
   for item in list_items: # Pour chaque item de l'ensemble list_items ...
       print(item) # ... tu affiche item.

show_inventory("épée")
show_inventory("épée", "arc", "potion de mana", "cape de Dragon rouge")

#6# Les valeurs de retour.
#
# Comment retourner une valeur avec une fonction.
# Par exemple, une fonction qui retourne la somme de deux nombres.
def calculer_somme(nombre1, nombre2):
   resultat = nombre1 + nombre2 # stocker le résultat dans une variable créée ...
   return resultat # ... retirer le résultat et le sortir de la fonction avec le mot clé return.
print(calculer_somme(5, 16))
"""
Mais on peut directement retourner un calcul. On a vu que les expressions peuvent servir
pour être stocker dans une variable, dans une instruction mais aussi dans un retour de fonction.

Attention, au premier return on quitte la fonction.

"""
def calculer_somme(nombre1, nombre2):
   return = nombre1 + nombre2 # retourner directement un calcul.
   print("Je ne serai jamais lu... :(.")
print(calculer_somme(5, 16))
"""
fonction qui retourne le plus grand de deux nombre.
la fonction ne peux passer que par un des trois return (soit nombre 1 est plus grand soit il est plus petit ou bien égal).
3 retours de fonction possibles.
Par rapport à la condition, on lis un des 3 return. Autrement les return suivant ne seraient pas lu.
"""
def le_plus_grand(nombre1, nombre2):
   if nombre1 > nombre2:
       return nombre1
   elif nombre1 < nombre2:
       return nombre2
   else:
       return "Egalité !"

print(le_plus_grand(5, 16))

#7# Les fonctions lambda.
#
# Elle prend des paramètres ou non.
# réalise une seule instruction (fait le retour d'une instruction). 
# lambda est un mot réservé du langage. On peux s'en passer bien sûr.

# On définis une fonction lambda sans paramètre ...
lambda : print("Bonjour") # ... on lui dit ce qu'elle retourne.
# ... qui correspond à ...
"""
def : 
   print("Bonjour") # ... la déclaration d'une fonction sans nom.
"""
# ... cette fonction n'as pas été définie, ni appelée.

# Pour appeler une fonction anonyme, il faut la stocker dans une variable.
coucou = lambda:print("Bonjour")
coucou()

# L'intéret est d'avoir une fonction qui ne fait qu'une seule chose.
# On va l'utiliser pour des calculs récurents.
# Par exemple, on veux calculer une calculer un prix TTC.
ttc  = lambda prixHT : prixHT + (prixHT * 20/100) # On met des parenthèses pour une raison de priorité de calcul. On met 20/100 pour des raison de lisibilité pour les 20% de TVA plutôt que de mettre 0.2
print(ttc(24)) # calculer le prix TTC de 24.

# Par exemple, on veux calculer la somme de deux nombre.
calculer = lambda a, b : a + b # toute la fonction tient sur une ligne. Les paramètres sont séparé par une virgule et l'instruction vaut une ligne.
print(calculer(14, 27))
# employé dans le cas où une seule instruction se répète. 
# On fait simplement une petite instruction lambda que l'on stocke ensuite dans une variable.
```