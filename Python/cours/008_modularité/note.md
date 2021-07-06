# [8. Modularité](https://www.youtube.com/watch?v=A2aD4eQP0qU)

+ [Fonction lambda](#Fonction-lambda)
+ [Importer un module](#Importer-un-module)
+ [Créer notre module](#Créer-notre-module)
+ [Importer une seule fonction de notre module](#Importer-une-seule-fonction-de-notre-module)
+ [Organisation en sous-dossiers](#Organisation-en-sous-dossiers)
+ [Gérer les erreurs - condition de vérification](#Gérer-les-erreurs---condition-de-vérification)
+ [Resume](#Resume)

Bonjour à tous, vous êtes sur votre formation en langage Python.

On va faire la séance 8 et on va parler de modularité.

C'est un terme pour désigner la partie module, on va parler de modules en python et voir à quoi ça correspond, comment on l'utilise et comment on peut en créer également mais avant toute chose je voudrais pouvoir revenir sur les fonctions qu'on avait vu la dernière fois. 

Je n'avais pas parler de fonction lambda, je voulais simplement ne pas mélanger un petit peu à tout, je voulais garder ça un petit peu pour cette vidéo pour pas vous faire trop sur la vidéo précédente.

Alors les fonctions maintenant vous savez un petit peu ce que c'est, comment ça fonctionne, comment on en crée, comment est-ce qu'on peut gérer tout ce qui est paramètres, valeur de retour, on avait tout ça dans la séance précédente. 

Donc si vous avez encore des questions par rapport à ça, n'hésitez pas à les poser en commentaire dans la vidéo, la séance numéro 7.

Et là on va vraiment parler des fonctions lambda, je vais vous montrer en quoi ça consiste.

## Fonction lambda

Alors une fonction lambda un rôle très très particulier, ce qu'elle permet … elle peut prendre des paramètres ou non. Maintenant vous savez ce que c'est une fonction avec des paramètres ou qui n'en a pas. Et elle va réaliser une seule instruction, Un retour tout simplement d'une instruction. 

Alors on va prendre un exemple tout bête, je vais faire par exemple "lambda", je ne vais pas lui mettre de paramètres donc directement je vais mettre deux-points.

    #coding:utf-8

    lamda:

Et après les : on va tout simplement mettre ce qu'elle retourne, je vais faire Bonjour.

```py
#coding:utf-8

lambda:print("Bonjour") 
```

Donc là je viens de définir une fonction lambda.

Alors évidemment si j'essaie d'exécuter ce fichier, vous voyez qu'il ne se passe rien, tout simplement.

```powershell
>python main.py
```

Vous voyez qu'il ne se passe rien, tout simplement parce que la fonction lambda a juste été défini, c'est comme si on avait fait … pour vous faire une idée, cette ligne là lamda:print("Bonjour"), correspondrais a un def de rien du tout parce que la fonction n'a pas de nom et on aurait par exemple dedans le fameux print("Bonjour"). 

```py
#coding:utf-8

lambda:print("Bonjour") 

def:
    print("bonjour")
```

En fait c'est ça plus ou moins qu'on a fait.
Alors bien évidemment def:…print("Bonjour") ne fonctionne pas, c'est juste pour dire l'équivalent, à quoi ça corresponderait.

Donc cette fonction lamda:print("Bonjour") comme elle est simplement définie mais qu'on ne l'a pas affectée, on ne l'a pas appelée d'ailleurs, ça ne va pas. Alors comment on peut appeler une fonction lamda donc une fonction qui est anonyme puisqu'elle n'a pas de nom ? On va tout simplement se servir d'une variable donc vous aller stocker ça dans une variable, vous lui donner le nom que vous voulez, d'accord.

Moi, je vais l'appeler "coucou" comme ça, on a une super fonction lambda qui dit Bonjour.

```py
#coding:utf-8

coucou = lambda:print("Bonjour")
```

Et après, on a simplement à faire ça "coucou()" et comme on a pas de paramètre comme vous avez vu, je peux mettre des parenthèses vides.

```py
#coding:utf-8

coucou = lambda:print("Bonjour")

coucou()
```

Et là son retour, c'est un print() de Bonjour, tout simplement.

```powershell
>python main.py
Bonjour
```

Alors, à quoi ça sert parce que là tout de suite, ce n'est pas telement parlant comme exemple.

C'est pour avoir simplement une fonction qui ne ferait qu'une seul chose.

Admettons, on voudrait, je ne sais pas moi, simplement ça "prixHT", on va reprendre notre exemple du prix TTC, comme ça.

```py
#coding:utf-8

lambda:prixHT:

coucou()
```

Et on veux par exemple un calcul tout bête de la TVA ou d'un calcul en TTC à partir d'un TVA à 20%. Comme ce serra un calcul qui serra assez récurant, qu'on a pas envie forcément ... c'est qu'une seul chose en fait, on ne va pas forcement s'amuser à faire une fonction qui ne fait que cette instruction là c'est-à-dire calculer le prix TTC et le retourner.

On va donc préférer utiliser une fonction lambda donc là, on aura tout simplement le prixHT, d'accord, plus, alors je met des parenthèses même si elles ne sont pas obligatoires parce que vous vous rappelez que la multiplication et la division, comme on l'a vu avec les opérateurs, sont prioritaire mais quand on veut être sûr que le programme ne confonde pas ou se trompe, on met des parenthèse comme ça, on est sûr.

```py
#coding:utf-8

lambda:prixHT:prixHT + ()

coucou()
```

Donc c'est le PrixHT plus le prixHT fois 20 pour cent, d'accord, parce qu'on veut 20% de TVA. J'aurais pû faire zéro et cetera, j'aurais pû faire une simple multiplication mais là comme ça je détail bien le calcul.

```py
#coding:utf-8

lambda:prixHT:prixHT + (prixHT * 20 / 100)

coucou()
```

Donc ça en vaut lisibilité c'est beaucoup plus clair, voilà en lisant, on voit qu'on parle de la fameuse TVA à 20 pour 100. Je trouve que c'est beaucoup plus clair que de mettre fois 0,2 donc c'est mieux. 

Voilà, prixHT et cetera.

Et on va calculer, et on va mettre TTC. Évitez d'appeler une variable TTC parce que ce n'est pas forcément très très clair. 

```py
#coding:utf-8

ttc = lambda prixHT:prixHT + (prixHT * 20 / 100)

coucou()
```

Mais du coup, là c'est beaucoup plus pratique si je fais un print(ttc(24)), par exemple, il devrait me normalement calculer le prixTTC, voilà, le calcul TVA 20% de 24, 24 quelque chose, je ne sais pas, 24 patates si vous voulez, peu importe.

```py
#coding:utf-8

ttc = lambda prixHT:prixHT + (prixHT * 20 / 100)

print(ttc(24))
```
```powershell
>python main.py
28.8
```

Donc c'est une manière très simple d'avoir une seule instruction, d'accord. Vous voyez c'est l'instruction qui est retournée donc c'est vraiment qu'une seule instruction, pas plus.

On peut aussi avoir quelque chose comme ça. Calculer égal lambda a, b par exemple. On met deux points et on fait du coup a plus b donc c'est une fonction lambda qui va retourné la somme de deux nombre que vous lui passé. Et du coup, on peut, sans problème faire, calculer(14, 27).

```py
#coding:utf-8

calculer = lambda a, b : a + b

print(calculer(14, 27))
```
```powershell
>python main.py
41
```

Et on aura, la somme de 2, d'accord, donc c'est vraiment son utilité alors là tout de suite ce n'est pas forcément indispensable, on peut très bien se passer des fonctions lambda en python, C'est juste que vous voyez que c'était un mot réservé du langage donc si un jour vous tombez sur ce genre de ligne, voilà vous ne vous demanderez pas ce que c'est, vous saurez à quoi ça correspond, qu'est-ce qu'une fonction lambda et à quoi ça peut servir. 

Donc c'est vraiment dans le cas où vous n'auriez qu'une seule instruction Qui se répète. Puisqu'on avait dit dans la séance précédente que dés qu'on a de la répétition de code, il est en tout cas intéressant et surtout intelligent de factoriser et de mettre dans une fonction. 

Le problème c'est que si c'est juste une seule instruction, Ça fait peut-être un peu lourd de faire une fonction avec un nommage et cetera. 

Donc on fait une petite fonction lambda et on peut la stocker dans une variable mais attention comme c'est une variable, je peux sans problème par la suite, changer de nom. Si par exemple, ici, je refais le lambda, puis, je le mettre dans une autre variable, on pourra changer le nom ici de calculer. On peut très bien mettre autre chose arrête, égale cette même ligne là "lambda a, b : a + b" et ça va modifier bien évidemment la variable qui contient cette fonction lambda. 

Donc c'est évidemment possible hum mais ça vous savez parce que vous connaissez le fonctionnement des variables. 

Voilà pour la petite parenthèse au niveau des fonctions lambda, histoire de pouvoir passer maintenant vraiment à la modularité. 

Donc ça c'est vu, donc voyez c'est lambda, le mot clé lambda et ici 0 paramètre ou 1 ou plusieurs, séparé par des virgules (a, b) si vous en avez plusieurs. Les deux points (:), très important, ne pas les oublier. Et ensuite, une seule instruction que la fonction réalise. Une seule, si vous en mettez plus, vous voyez, de toute façon, qu'il n'y a pas de délimiteur ou autre Donc c'est vraiment qu'une seule. 

On met tout sur une ligne et en stock dans une variable (calculer =) pour pouvoir l'appeler sinon on ne peut pas l'appeler. 

Voilà pour les fonctions lambda. 

## Importer un module

Alors, allons maintenant sur la modularité. La modularité va faire intervenir certains modules, alors un module jusqu à présent n'a pas vraiment utilisé ou alors très très rapidement, je vous ai montré quelques utilisations sur vous dire ce que c'était mais on va pouvoir … entendez par module, une histoire de bibliothèque, un petit peu, comment aurait un petit peu dans le langage c, si jamais vous connaissez ce langage, on retrouve des bibliothèques avec des fonctions déjà toutes faites. 

Alors vous avez vu que python avait des fonctions natives comme print(), input(), et cetera. Ce sont des fonctions natives du langage que vous pouvez directement utiliser mais le python n'a pas que ces fonctions-là. 

Si vous faites par exemple des calculs mathématiques, un petit peu plus poussé, comme par exemple calcul d'une racine carrée, vous allez avoir besoin d'un module de mathématique qui est fait exprès pour utiliser les fonctions mathématiques, alors je vous montre un exemple.

Je vais faire résultat, c'est important, on a une fonction sqrt(100), par exemple, la racine carré de 100, admettons. Et je vais afficher resultat.

```py
#coding:utf-8

resultat = sqrt(100)

print(resultat)
```
```powershell
>python main.py
Traceback (most recent call last):
  File "main.py", line 164, in <module>
    resultat = sqrt(100)
NameError: name 'sqrt' is not defined
```

Si là je test, le programme ne va pas fonctionner puisqu'il dit simplement que sqrt() n'est pas définis. C'est simplement que ce n'est pas une fonction, comme vous le voyez, elle se met d'ailleurs en rouge par rapport à mon éditeur, ce n'est pas une fonction native du langage, en tout cas, qui n'est pas intégré comme ça directement.

Il faut importer un module donc une bibliothèque qui est fait exprès pour des fonctions mathématiques. 

Ce module il s'appelle Matt, tout simplement, "math" c'est en anglais. 

On va faire un import math, tout simplement.

```py
#coding:utf-8

import math

resultat = math.sqrt(100)

print(resultat)
```
Et là comme on a mis ça, on va préciser que dans le module de math, on met un point, on utilise la fameuse fonction sqrt() et là vous allez voir si j'utilise, on a cette fois-ci un résultat fonctionnel.
```powershell
>python main.py
10.0
```

Donc voilà la syntaxe pour importer un module. 

Alors comme vous faites syntaxe là c'est-à-dire le mot import et le nom du module, vous voyez que pour utiliser une fonction, On est obligé de préciser le nom du module, un point, le nom de la fonction, d'accord. 

J'aurais pu simplement faire autrement, si je ne veux pas m'amuser à répéter tout le temps "math.", je peux aussi faire dans cet ordre-là.

```py
#coding:utf-8

from math import sqrt

resultat = sqrt(100)

print(resultat)
```
Ça veut dire du module math, tu importe la fonction sqrt() et là, je teste, même chose. On n'a plus besoin de répéter "math.".
```powershell
>python main.py
10.0
```

Et si admettons, vous utilisez pratiquement toutes les fonctions du module, vous pouvez aussi pour éviter de répéter à chaque fois le mot "math.", ici devant, vous mettez une étoile (*), voilà.

```py
#coding:utf-8

from math import *

resultat = sqrt(100)

print(resultat)
```

Je vais mettre un petit rappel. Importer un module donc on a plusieurs façons : import <nom_module>, alors quand je met des chevrons comme ça, c'est pour vous dire de remplacer par le nom de module que vous voulez, d'accord, voilà. Alors ça <nom_module>, vous le remplacer par "math", "os" et cetera. On en verra pleins des modules, de toute façon.
Vous avez également from <nom_module> import <nom_fonction> et vous pouvez avoir from <nom_module> import *, étoile pour importer tout.

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *				

from math import *

resultat = sqrt(100)

print(resultat)
```

Voilà 3 choses qu'on a vu jusqu à présent, 3 manières d'importer un module en python, d'accord. 

Alors moi je préfère quand c'est des cas comme ça faire simplement ça " import math".

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *				

import math

resultat = math.sqrt(100)

print(resultat)
```

Comme ça, je sais au moins où je l'utilise. ça permet aussi, si par exemple un jour, vous allez voir, on va pouvoir créer notre propre module. Si vous avez des noms qui sont identiques, d'éviter les conflits. On sait au moins que là c'est la fonction sqrt(), donc la fonction racine carrée du module qui s'appelle comme ça (math). 

Donc au moins comme ça on arrive à le voir (math.sqrt), en tout cas moi comme ça je préfère toujours en général garder ce genre d'écriture, après c'est un choix personnel, vous verrez, vous, ce que vous préférez bien évidemment. 

Donc voilà comment on va importer un module et comment on va utiliser des fonctions, d'accord. On peut en avoir plein, Après on peut très bien faire, je ne sais pas moi, allez sinus. Et du coup, vous allez faire print(sinus).

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				        from <nom_module> import <nom_fonction>
#				        from <nom_module> import *				

import math

resultat = math.sqrt(100)

print(resultat)

sinus = math.sin(42)

print(sinus)
```
```powershell
>python main.py
10.0
-0.9165215479156338
```

D'accord, vous Obtenez un résultat un peu bizarre, je vous avouerai je ne le connais pas par coeur mais voilà on peut utiliser la fonction sinus là-dedans. 

Si j'avais voulu préciser, il aurait fallu que je fasse la fameuse ligne comme ça.

       from <nom_module> import <nom_fonction>

Pour l'utiliser dans ce programme, il aurait fallu faire ça. 

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *				

from math import sqrt
from math import sin

resultat = math.sqrt(100)

print(resultat)

sinus = math.sin(42)

print(sinus)
```

Voilà il faut vraiment le faire pour chaque (sqrt, sin).
Alors ça <nom_module>, un module qu'est-ce que c'est en réalité au niveau informatique ? Si vous voulez, c'est un fichier, d'accord.

alors plus exactement et vous verrez par la suite, on va avoir des dossiers, on va avoir des fichiers, on va avoir des fonctions, d'accord, ça va permettre comme ça de hiérarchiser et de bien organiser notre code et d'avoir les choses bien rangé correctement, OK. 

Donc le module, ça va être tout simplement un fichier, là en fait "math", c'est un fichier qui porte l'extension py Comme on connaît, et à l'intérieur il y a une fonction qui a été développé, une fonction sqrt(), une fonction sin() et cetera.

Donc voilà, un module c'est un fichier, tout bêtement.

Et les fonctions, ce sont des fonctions à l'intérieur du fichier, d'accord.

Donc ça maintenant, vous savez un petit peu comment ça fonctionne. 

Alors maintenant, vous savez comment on en importe, comment on utilise les modules standards, après il faut regarder la documentation si vous voulez utiliser une fonction Qui existe déjà en python Sur un module du langage, vous Regardez dans la documentation et il vous dira quel module importer, tout simplement. 

On peut retrouver par exemple le, import os.

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *				

import os

os.system("cls")
```

On peut retrouver parfois import os, mais des fois on peut avoir "os.system" c'est-à-dire du module OS, on utilise la fonction system et du coup je peux utiliser une fonction du terminal que ce soit sur Windows ou Linux. Donc là si je fais "cls".

```powershell
C:\>
```

Par contre sur Linux, il faut mettre "clear" et cetera. 

C'est comme si je faisais ça. 

```powershell
C:\>cls
```

Ce que je suis en train de faire ça, le cls dans le terminal, ça correspond exactement à ça. 

```py
os.system("cls")
```

Donc c'est propre au système sur lequel vous êtes, si on était sur Linux ou Mac, ce serait "clear". 

Bref, c'était pour vous montrer comment importer des modules. 

## Créer notre module

Maintenant que vous savez faire ça, on va pouvoir effectivement bien organiser nos programmes et notamment tout afficher pour pouvoir créer notre propre module. C'est ce que nous allons faire justement. 

On va y aller, on passe dans notre dossier ici. 

```powershell
C:\>
```

On va créer un petit module, on va l'appeler player.py, tout simplement.

```powershell
C:\>player.py
```

Je vais remettre l'encodage, je le mets tout le temps pour être sûr même si par défaut, je le rappel, sur python 3, c'est en UTF-8. Je préfère le rajouter histoire de vraiment ne pas avoir de problème. 

+ player.py
```py
#coding:utf-8
```

Donc on a ça, donc là je peux mettre un petit commentaire, on peut faire ce qu'on appelle un doctype, enfin on verra. 

Module pour le joueur, Même si c'est pas très détaillé. Et on va faire un def parler(personnage, messages), Et du coup il fait un print() et on va utiliser la fameuse méthode format() comme on l'avait vu, voilà.

+ player.py
```py
#coding:utf-8

# Module pour le joueur

def parler(personnage, message):
	print("{} : {}".format(personnage, message))
```

Donc le module, c'est player, c'est ce qui correspond au fichier que vous avez créé. Donc le fichier que vous avez créé, certains modèles tout simplement. Vous voyez ce n'est vraiment pas compliqué, ce n'est pas forcément une archive ou un gros truc, c'est ça python.py, ce fichier est un module et à l'intérieur on a une fonction parler(). 

Donc plusieurs possibilités, et on va faire une autre fonction, Histoire de ne pas tout mélanger. Allez, je ne suis pas trop inspirée pour le coup mais ce n'est pas grave, le truc c'est que vous comprenez bien l'exemple donc parler(), donc il peut dire n'importe quoi, et au_revoir(), on dit au revoir et puis c'est tout, voilà.

+ player.py
```py
#coding:utf-8

# Module pour le joueur

def parler(personnage, message):
	print("{} : {}".format(personnage, message))

def au_revoir():
	print("Au revoir :)!")
```

Voilà, alors la méthode par défaut, on va faire import player, d'accord.

+ Main.py
```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

import player
```

A partir de là, on a importé ce fichier-là player.py, on l'a inclus, en fait, tout simplement au programme. 

Donc on peut utiliser n'importe laquelle de ses fonctions.

Donc je peux sans problème faire ça.

+ Main.py
```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

import player

player.au_revoir()
```
+ player.py
```py
#coding:utf-8

# Module pour le joueur

def parler(personnage, message):
	print("{} : {}".format(personnage, message))

def au_revoir():
	print("Au revoir :)!")
```
Alors vous voyez que je ne l'aimais pas dans un print(),tout simplement parce que vous voyez, cette fonction fait déjà un print(). Pour dire d'afficher un print() dans un print(), c'est un petit peu inutile. 
```powershell
>python main.py
Au revoir :) !
```

Et là, la fonction, le programme, l'interpréter exécute bien Comme il faut et dit au revoir.

Je peux faire la même chose player.parler("Jason", "Salut les abonnés !") et même chose.

+ Main.py
```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

import player

player.au_revoir()
player.parler("Jason", "Salut les abonnés !")
```
+ player.py
```py
#coding:utf-8

# Module pour le joueur

def parler(personnage, message):
	print("{} : {}".format(personnage, message))

def au_revoir():
	print("Au revoir :)!")
```
```powershell
>python main.py
Au revoir :) !
Jason : Salut les abonnés !
```

Voilà, ça fonctionne aussi.
Donc ça fonctionne comme un module, simplement que là vous avez créé vous-même votre module (player.py).

ça va permettre comme ça d'organiser vos fichiers, en fait, en différentes catégories pour pouvoir bien ranger un petit peu votre programme, pour ne pas avoir tout votre programme dans un seul fichier. On ne fait pas comme ça, on prépare tes dans plusieurs fichiers, on a inclus tout ce qu'il faut. 

Alors pour les plus attentifs, vous avez remarqué qu'il y a un petit dossier qui s'est ajouté ici, avec des underscores (__pycache__), il y en a 2 au début et 2 à la fin. Pycache, Comme le nom l'indique, c'est un répertoire de cash pour python C'est-à-dire que là, voyez, il a créé un fichier de cache de player, du module. Ce qui fait que les prochaines exécution de votre programme seront beaucoup plus optimisés tout simplement. 

Donc la première fois, il doit créer le cache comme pour un site web, comme pour votre navigateur internet et toutes les autres fois où vous allez exécuter, il a déjà plus ou moins le code qui est optimisé au niveau de vos modules, ce qui va rendre l'exécution beaucoup plus rapide, beaucoup plus optimal lors du lancement de votre programme. 

Donc ça c'est intéressant, alors c'est fait automatiquement. Autant sur des anciennes versions de python, Il fallait le gérer manuellement. Là à partir de python 3, c'est pour ça que c'est que des avantages, tout est géré automatiquement donc il n'y a rien à faire. Pas besoin forcément de modifier quelque chose dedans, il faut laisser les choses comme elles sont. 

Voilà pour ce module (player.py).

## Importer une seule fonction de notre module

Maintenant si j'avais voulu, importer qu'une seule des 2 fonctions, j'aurais fait comme on a vu tout à l'heure. 

+ Main.py
```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

from player import au_revoir

player.au_revoir()
player.parler("Jason", "Salut les abonnés !")
```

Et là automatiquement, à priori cette ligne là "from player import au_revoir", l'interprêteur ne devrait pas être content.

```powershell
>python main.py
Traceback (most recent call last):
  File "main.py", line 486, in <module>
    player.au_revoir()
NameError: name 'player' is not defined
```

Effectivement, voyez, "name 'player' is not defined" alors par contre, il me dit player, alors que ce n'est pas player qui n'est pas défini.

Alors oui, on l'a dit au début de la vidéo, si vous mettez from, vous n'avez plus besoin du nom du module donc vous pouvez directement appeler les fonctions.

Donc on va avoir un fonctionnement comme ça.

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

from player import au_revoir

au_revoir()
parler("Jason", "Salut les abonnés !")
```
```powershell
>python main.py
Au revoir :) !
Traceback (most recent call last):
  File "main.py", line 512, in <module>
    parler("Jason", "Salut les abonnés !")
NameError: name 'parler' is not defined
```

Et là automatiquement si on essaye d'exécuter, il nous met que name "parler", cette fonction-là n'est pas définie parce qu'éffectivement, on a juste importé celle-çi "au_revoir".

Donc on est obligé, si on veux importer les deux de faire ça.

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

from player import au_revoir
from player import parler

au_revoir()
parler("Jason", "Salut les abonnés !")
```
```powershell
>python main.py
Au revoir :) !
Jason : Salut les abonnés !
```

Là évidemment, il va moins broncher, il va faire les choses comme il faut, d'accord, c'est vraiment plusieurs possibilités et sinon si on utilise tout, autant mettre une étoile.

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

from player import *

au_revoir()
parler("Jason", "Salut les abonnés !")
```
Si on ne veut pas s'amuser à mettre le nom du module,ça fonctionnera sans problème.
```powershell
>python main.py
Au revoir :) !
Jason : Salut les abonnés !
```

Voilà comment créer votre propre module.

Donc c'est vraiment très simple, vous faites un fichier à part et le nom du module, c'est le nom du fichier.

## Organisation en sous-dossiers

Alors si on veut être encore plus organisé, on peut faire des sous-dossiers, on peut ranger.

Alors moi, je ne vais pas m'embêter à faire des catégories genre pour l'interface graphique, le coeur du programme, la partie réseaux si par exemple, il y avait plusieurs catégories comme ça, on va juste faire un dossier "includes", on va l'appeler comme ça par exemple.

Et on va mettre player.py dedans, on ne va pas s'embêter. On va l'ouvrir, une fois qu'il est placé là.

Alors comment, on appele ? comment on arrive à ce fichier parce que vous voyez qu'il n'est plus dans le même dossier, hé bien ça, ça fait partie du chemin du module donc vous allez juste faire, au lieu de faire "from player import *", on va faire "import player" et comme il est dans un répertoire, n'oubliez que le fichier main, il part de l'endroit où il est et donc pour accéder à player, il doit passer par includes et ensuite player donc on met includes point player.

Le point, c'est le séparateur du fichier tout simplement, voilà.

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

from player import *

player.au_revoir()
player.parler("Jason", "Salut les abonnés !")
```

Et là, évidemment, il ne faut pas que je me trompe à chaque fois. Là comme je fait juste un import, faut que je remette le nom du module.

Là, il faut faire attention, d'accord. Vous voyez, j'ai pas fait gaffe, j'étais pas attentif au début. 

Quand vous avez le import tout seul, il faut bien mettre le nom du module.

Quand vous avez un from, vous n'êtes plus obligé de mettre le nom du module donc il ne faut pas se gourrer parce qu'on a vite fait de faire l'erreur.

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

import includes.player

player.au_revoir()
player.parler("Jason", "Salut les abonnés !")
```
```powershell
>python main.py
Traceback (most recent call last):
  File "main.py", line 601, in <module>
    au_revoir()
NameError: name 'au_revoir' is not defined
```
Alors j'ai fait une erreur quelque part, c'est toujours l'appel qui bugge.

Alors oui forcément, on a tout ce nom ici "includes.player.au_revoir()" donc l'utilisation doit être faites comme ça.

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

import includes.player

includes.player.au_revoir()
includes.player.parler("Jason", "Salut les abonnés !")
```
Donc l'utilisation doit être faites comme ça.
```powershell
>python main.py
Au revoir :) !
Jason : Salut les abonnés !
```

Vous voyez, tout de suite, ça devient long. On commence à avoir quelque chose d'un petit long.

Donc en général quand on veut simplfier, on va faire "as player", d'accord.

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

import includes.player as player

includes.player.au_revoir()
includes.player.parler("Jason", "Salut les abonnés !")
```
Avec ce petit mot clé, vous dites qu'il remplace "includes.player" par "player", ça permet de simplifier comme ça automatiquement. Je peux revenir à la syntaxe que j'avais au début.

```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

import includes.player as player

player.au_revoir()
player.parler("Jason", "Salut les abonnés !")
```
En mettant juste player, voilà ça fonctionne.
```powershell
>python main.py
Au revoir :) !
Jason : Salut les abonnés !
```

Vous voyez, c'est pas mal de petite chose donc prenez des notes, n'hésitez pas à mettre sur pause et cetera. Après moi je vous fait des résumés en général mais de vraiment bien noter, voilà c'est important.

Parcequ'il n'y a pas de choses à retenir, après ça va être une habitude, vous allez prendre l'habitude et cetera.

Voilà, ça m'est arrivé de me gourré en plein vidéo, à un moment j'avais ouvlié de virer le nom du module, ça arrive, il ne faut pas vous en faire à ce niveau-là, c'est des petites erreurs d'inatation qu'on fait tout le temps.

Grosso modo on arrive à faire quelque chose quand même qui fonctionne, il n'y a pas de souci à ce niveau-là. 

On peut du coup bien organiser son code, d'accord.

On peut avoir vraiment des fichiers bien rangé. Et vous voyez que le __pycache__, il s'est fait ici. 

```powershell
.\includes\__pycache__\player.cpython-38.pyc
```

D'ailleurs celui-là ".\__pycache__\", je peux même les virer puisque le Player, le module est ici ".\includes\__pycache__\".

Voilà il le fait que pour les modules que vous incluez, voilà, cela permet de le ranger automatiquement dans le bon dossier, aussi, il fait part rapport à l'endroit où se trouve le fichier.

Donc c'est très simple, comme ça on peut vraiment créer nos propres modules, on peut les mettre dans ce dossier de sous dossier, vous faites ce que vous voulez ça fonctionne sans problème, il n'y a vraiment aucun souci avec ça. 

Alors je terminerai sur cette petite vidéo avec une dernière chose qui est importante parce que souvent quand on fait un vrai programme puisque je vous avais dit qu'on procède par plusieurs modules, on développent des fichiers différents, on répartit les différentes fonctions, les différentes catégories d'un programme mais mais on a souvent une phase alors vous n'en avez peut-être pas conscience, vous ne savez peut-être pas, vous travaillez peut-être en informatique, vous êtes peut-être à l'université ou autre… mais on a souvent ce qu'on appelle une phase de test, on va tester. 

Alors ça peut être des tests unitaires, ça peut être les DTD, ça peut être plusieurs moyens en fait de tester un programme, les algorithmes et cetera, De voir que le comportement attendu, le fonctionnement, et celui que l'on voulait. 

Mais on peut aussi procéder par des vérifications très simple, avec python, Pour être sûr, en fait, que chaque partie de notre programme RT fais ce que l'on attendait tout simplement. 

Alors comment est-ce qu'on va procéder ? Alors moi mes fonctions, elles ne font pas grand-chose, on ne va pas dire que ce soit très passionnément ou très complexe mais quand même.

On va partir du principe que ça (main.py), vous imaginez, c'est le programme principal, le main.py

Il y a plein de choses, d'accord, je viens de créer un nouveau module player que je vais ajouter au programme, je sais que tout le reste de mon programme est pour le moment OK, qu'il n'y a pas de bug, tout fonctionne, il n'y a pas de souci. 

Forcément si vous incluez un nouveau module, donc un nouveau code, vous vous attendez, on n'arrive pas à prendre le risque entre guillemets de Corrompre tout programme juste à cause d'un module. 

Donc ce qui est bien, C'est de pouvoir être en mesure de tester chaque module indépendamment du programme complet pour être sûr que chaque module tout seul fonctionne correctement parce que si le module tout seul en lui-même est buggé, forcément quand vous allez l'utiliser dans votre programme principal, ça va planter, ça paraît logique. 

Donc nous on va faire ça, on va organiser une petite série de tests très rapides, très très basique, sur le fichier player.

## Gérer les erreurs - condition de vérification

On part du principe que ça tout est bon (player.py) mais comme je n'ai pas envie justement de faire bugger tout mon programme, de le corrompre, je vais m'assurer que player tout seul, sans utiliser… sans démarrer le programme par ici (main.py), lui tout seul (player.py) est capable de fonctionner.

On va utiliser une petite condition pour ça avec une variable réservée à python, On en découvrira plein d'autres par la suite, ne vous en faites pas, je vous en parle comme ça, je ne vous en dis pas plus, je ne vous détails pas pour le moment. Vous pouvez l'utiliser tel quel et de toute façon on reviendra dessus quand on parlera d'objets. 

Vous allez faire un IF, underscore underscore, il en faut 2, c'est important parce que vous voyez que les éditeurs, ils les collent donc on a l'impression qu'il n'y en a qu'un seul mais non il y en a 2, d'accord, il y a 2 caractères. Vous m'avez fait la remarque, je rappelle, sur une vidéo en PHP donc je le dis, voilà. 

Vous mettez name. c'est un moyen de montrer des variables réservés en python, Ils mettent double underscore, vous avez vu ici, comme pour le __pycache__, vous voyez c'est pareil.

```py
if __name__
```

C'est pareil, c'est 2 underscores avant et 2 underscores à la fin.

Et on va mettre que c'est égal à, alors pareil, __main__, voilà.

```py
if __name__ == "__main__":
```

Ca veut dire si la variable __name__ donc réservé est égal à __main__. Qu'est-ce que je fais ? Qu'est-ce que ça veut dire ? ça veut simplement dire que sur cette variable là __name__, vous allez avoir un nom, et le __main__ et ben c'est là où démarre l'exécution du programme donc ça veut tout simplement dire que si l'interpréteur python exécute notre programme à partir de ce fichier. Ça veut dire qu'il commence par ce fichier Player au lieu de commencer, alors je l'ai appelé main pour pouvoir me l'identifier, mais par le fichier player.py

Donc qu'est-ce qui va se passer ? Qu'est-ce que je dois faire mon programme Si il se lance via ce fichier-là player.py ? Alors que ce n'est pas par vu que le programme devrait démarrer bien sûr, d'accord. 

C'est-à-dire qu'on ne va pas du tout tester le main ou les autres fichiers que l'on pourrait avoir, on va juste tester Player. 

Et bien là on peut s'amuser à faire tous les tests qu'on veut c'est pour tester juste ce qu'il y a dans ce fichier player.py

+ player.py
```py
#coding:utf-8

#Module pour le joueur

def parler(personnage, message):
	print("{} : {}".format(personnage, message))

def au_revoir():
	print("Au revoir :) !")


if __name__ == "__main__":
```

Alors moi ici il n'y a pas grand-chose alors qu'est-ce que je vais tester, alors bêtement je vais faire un appel des 2 fonctions, tout bête.

Alors, je ne vais pas le faire de toute manière parce que celle-là, parler(), je ne peux que l'appeler que d'une manière, j'ai deux paramètres obligatoires, pas le choix. Et celle-là, au_revoir(), il n'y a pas de paramètre donc on va dire que je n'ai énormément de tests à faire.

+ player.py
```py
#coding:utf-8

#Module pour le joueur

def parler(personnage, message):
	print("{} : {}".format(personnage, message))

def au_revoir():
	print("Au revoir :) !")


if __name__ == "__main__":
	parler()
```

A part ici, personnage (paramètre de la méthode parler()), je peux mettre des chiffres et cetera, et puis là normalement, à l'intérieur (instructions indentées), j'aurais gérer les erreurs en disant : "Eh bien tiens, le nom que t'as rentré, ce n'est pas un vrai nom, le message n'est pas correct et cetera". 

Et là on n'a pas encore vu comment gérer les erreurs, C'est réservé pour la séance suivante. 

Donc on va tout bêtement faire ça "Jason", "Bonjour tout le monde" et puis, on va tester la fonction au_revoir(), voilà.

+ player.py
```py
#coding:utf-8

#Module pour le joueur

def parler(personnage, message):
	print("{} : {}".format(personnage, message))

def au_revoir():
	print("Au revoir :) !")


if __name__ == "__main__":
	parler("Jason", "Bonjour tout le monde")
	au_revoir()
```

Donc ce fichier, main.py, imaginer qu'il n'existe pas, main.py n'existe plus pourtant c'est là que le programme est censé démarrer. Vous imaginez qu'il y a un gros programme de fait et il commence par ce fichier-là, player.py.

Quand je lance le programme, c'est celui-là, player.py, qui lus en premier mais nous on va exprès, volontairement, on va lire en premier le fichier Player donc je vais faire, tout simplement, un démarrage du fichier Player. 

Donc si je fais : 

```powershell
>cd includes
```

Dans le répertoire includes, je vais faire : 

```powershell
>python player.py 

>python player.py
Jason : Bonjour tout le monde
Au revoir :) !
```

Et là vous voyez, il me fait ce qui se passe ici parce qu'il est rentré dans la condition : 

```py
if __name__ == "__main__":
	parler("Jason", "Bonjour tout le monde")
	au_revoir()
```

Parce qu'il a vu que j'avais démarré le programme depuis Player, effectivement j'ai lancé le programme depuis Player et pas depuis Main comme on fait depuis tout à l'heure donc il exécute ça. 

```py
if __name__ == "__main__":
	parler("Jason", "Bonjour tout le monde")	## <--
	au_revoir()							## <--
```

Et cette partie là, tout ce qui est ici (voir méthodes misent en évidence ci-dessus), tout ce qui est dans le IF, ça peut vous servir pour faire vos tests alors ça restera très basique, ce n'est pas vraiment du test unitaire ou autre, des tests très poussés, mais ça permet quand même de vérifier que tout fonctionne. 

Là je peux constater que mes 2 fonctions, même si là, je n'ai pas fait de vérification.

```py
#def parler(-->personnage<--, -->message<--):
#	print("{} : {}".format(personnage, message))
```

De vérification que c'était bien un texte et qu'il n'y a pas de chiffres et cetera, pas de caractère non autorisé mais peu importe, on va rester sur des choses basiques.

+ main.py
```py
#coding:utf-8

#Importer un module : 	import <nom_module>
#				from <nom_module> import <nom_fonction>
#				from <nom_module> import *

import includes.player as player

player.au_revoir()
player.parler("Jason", "Salut les abonnés !")
```
Je peux considérer qu'effectivement mes 2 fonctions ont le comportement que je veux attends donc à ce moment-là, vous pouvez d'ailleurs laisser les tests, pas de souci. Je peux, cette fois-ci, exécuter mon programme depuis le main, voilà.
```powershell
>cd ..
>python main.py
Au revoir :) !
Jason : Salut les abonnés !
```

Je suis quand même plus assuré que mon programme fonctionne puisque j'ai déjà testé le module tout seul, indépendamment. Je l'ai isolé, en fait, et je l'ai exécuté tout seul, un peu comment sandbox. j'ai vu que tout seul il fonctionnait comme il faut, comme je l'attendais, donc maintenant je peux passer par tout le programme principal, à priori ça ne devrait pas buggé, voilà. 

Donc c'est une vérification intéressante de vraiment passer par cette petite condition.

```py
if __name__ == "__main__":
```

Petite condition, vous le mettez dans tous vos modules à la fin, comme ça, juste après toute votre définition de fonction et vous pouvez alors ici faire tous vos petits tests basiques pour voir si ça fonctionne.

```py
if __name__ == "__main__":
#      						<--
```

On peut très bien dire aussi au début pour identifier, voilà, je ne sais pas moi, "Phase de test". On peut mettre n'importe quoi, on peut mettre un identifiant, histoire de s'y retrouver, de s'organiser, voilà.

+ player.py
```py
#coding:utf-8

#Module pour le joueur

def parler(personnage, message):
	print("{} : {}".format(personnage, message))

def au_revoir():
	print("Au revoir :) !")


if __name__ == "__main__":
	print("PHASE DE TEST DE PLAYER.PY")

	parler("Jason", "Bonjour tout le monde")
	au_revoir()
```
```powershell
>cd includes
>python player.py
PHASE DE TEST DE PLAYER.PY
Jason : Bonjour tout le monde
Au revoir :) !
```

D'accord, comme ça, on fait ce qu'on appelle plus ou moins des tests isolés Pla même si ce n'est Pas non plus quelque chose de très très poussés. 

Voilà, ça reste assez sommaire mais c'est quand même un minimum qui peut être très intéressant à ce niveau-là, et c'est de la modularité parce qu'on gère par rapport au module. 

Voilà, je pense que j'ai fait le tour, je voulais vraiment vous montrer comment … donc qu'est-ce que c'était un module ? Parce que c'était non quand même bien de le savoir Parce qu'on ne peut pas faire du python sans savoir ce que c'était un module. Et puis de voir qu'on pouvait aussi également en créer parce que maintenant vous savez que c'est simplement un ensemble de fichiers qu'on peut organiser dans des dossiers, des sous-dossiers et on peut bien évidemment isoler chaque module que l'on développe pour en faire des petits tests qu'on pourra isoler de manière indépendante avant de l'appliquer à un programme. 

Donc très important, quand vous faites un module appeler, vous gérez une petite phase de test, comme ça, indépendamment. Et une fois que c'est bon vous pouvez l'utiliser dans votre programme principal. 

Comme ça, à priori, vous évitez comme ça beaucoup beaucoup d'erreur par la suite donc ça c'est un point que je trouve assez important.

Écoutez, on va s'arrêter là pour cette petite séance 8. 

On se retrouvera pour la prochaine séance. 

Dans la séance 9, on verra comment gérer les erreurs. Pareil, on ne va pas commencer à voir toutes les possibilités pour gérer les erreurs parce que ça fait appel à toute la partie objet du langage même si python est un langage objet de base, on restera sur les choses vraiment essentielles mais ce sera vraiment de la gestion d'erreur. On ne va pas faire juste des IF, des petits print() … non, on fera vraiment de la gestion d'erreur un peu plus poussée que ce que vous avez vu vite fait jusqu'à présent. 

Et on laissera la partie objet qu'on ne verra pas forcément parce que ça je le réserve pour plus tard quand on parlera des exceptions. 

Donc on va déjà voir comment gérer les erreurs avec le système d'assertion et cetera. Et comment gérer les erreurs notamment en testant les blocs de code et en gérant des cas de figure quand ça plante et quand ça ne plante pas et cetera et cetera. 

Donc on se retrouvera pour la prochaine fois alors pour cette petite séance 9 pour la gestion des erreurs. 

À bientôt 

## Resume
```py
###############################################
#################### Resume ################### 
###############################################
#coding:utf-8

# Python #8 - modularité
# https://www.youtube.com/watch?v=A2aD4eQP0qU&list=PLrSOXFDHBtfHg8fWBd7sKPxEmahwyVBkC&index=8
# Une séance courte et simple pour apprendre à créer ses propres modules et packages (répertoire de modules), utiliser des fonctions lambda et organiser plus correctement l'arborescence de vos programmes.

"""
(Abordés dans cette vidéo)

	Qu'es-ce qu'un module.
	3 manière d'importer un module en Python :
       	import <nom_module>
       	from <nom_module> import <nom_fonction>
       	from <nom_module> import *
	Comment créer un module.
	Comment gérer une phase de test de module.
"""

#1# Qu'es-ce qu'un module.
"""
Un module est un fichier que l'on peut organiser dans des dossiers, sous-dossiers. 
Par exemple, math.py est un fichier avec une extension py.
A l'intérieur, des fonctions développées comme sqrt().
La doc permet de rechercher si une fonction existe déjà sur un module standard qu'il suffira d'importer.
Par exemple, le module os et sa fonction system permettent d'utiliser une fonction du terminal lui-même.
"""
import os
os.system("cls") # c'est la même chose pour Linux. On met clear.
"""
La modularité fait intervenir certains modules.
Un module est comme une bibliothèque.
Un module en C est une bibliothèque avec des fonctions déjà toutes faites.
Python contient des fonctions natives (input(), print(), etc) déjà implémentées qu'on peut utiliser.
Python contient plein d'autres fonctions...

Par exemple, le calcul d'une racine carré dans un module de mathématique.
Certains modules sont prêt pour utiliser des fonctions mathématiques.
sqrt() est une fonction en python pour calculer la racine carré.
"""
#resultat = sqrt(100)
#print(resultat) # Erreur car la fonction n'est pas définie.

"""
sqrt() n'est pas une fonction native du langage.
C'est pourquoi il faut importer un module, une bibliothèques faites pour les fonctions mathématiques.
ce module s'appele math.
"""
#2# Importer un module.
# méthode d'importation recommandé car on vois où on l'utilise avec la syntxe "math." et on évite les conflits en cas de noms identiques.
import math # syntaxe pour importer un module.
resultat = math.sqrt(100) # Préciser le nom du module avec un point et dire on utilise la fonction sqrt.
print(resultat)
sinus = math.sin(42)
print(sinus)

#3# Importer une fonction.
# Pour éviter la syntaxe <nomDeModule>.<fonction()> et donc éviter de répéter tout le temps math et point.
from math import sqrt # signifie : du module math, tu importe la fonction sqrt.
from math import sin # obligation de spécifier un import pour chaque fonction utilisée.
resultat = sqrt(100) # pas besoin de répéter le nom du module.
print(resultat)
sinus = sin(42)
print(sinus)

#4# Importer toutes les fonctions.
from math import *
resultat = sqrt(100)
print(resultat)

#5# Créer un module.
# On crée un fichier (module) appelé player.py (player est le nom du module).
# Utile pour ranger les fichiers en différentes catégories (interface graphique, partie réseau).
# Pour être plus organisé, on crée un sous dossier include pour mettre player.py.

import include.player # le point est le sépareteur de fichier.
include.player.au_revoir()
include.player.parler("Jason", "Salut les abonnés !")

# __pycache__
# pycache est un petit répertoire de cache pour Python créé au moment de la compilation.
# C'est un fichier de cache du module player qui permet d'optimiser l'éxécution du programme.
# Les prochains lancements du programme seront plus rapide, mieux optimisé.
# A partir de Python 3, l'optimisation est automatique.
# Un pycache se fait à coté des modules que l'on incluent. Si on déplace un module, il faut pas hésiter à supprimer le pycache résiduel.

#6# Importer une seule fonction.
from include.player import au_revoir
from include.player import parler
au_revoir() # L'intérêt de from est de pouvoir retirer le nom du module.
parler("Jason", "Salut les abonnés !")

"""
Remarque :  Avec import seul, il faut mettre le chemin, un point et le nom du module.
           Avec un from, pas besoin de mettre le nom du module.
"""

#7# Remplacer le chemin du module par un mot clé.
# Permet de simplifier la syntaxe des fichiers.
import include.player as player # simplifier la syntaxe.
player.au_revoir()
player.parler("Jason", "Salut les abonnés !")

"""
La modularité permet de bien ranger son code.
Les modules peuvent être rangé dans plusieurs sous dossier.
On répartit les différentes fonctions, les différentes catégories d'un programme.
"""

#8# Phase de test sur un module.
"""
Il s'agit de :
	Isoler chaque module que l'on développe pour faire de petits tests avant de les appliquer à un programme.
	Gérer une petite phase de test à un module avant de l'utiliser dans le programme principale pour éviter les erreurs par la suite.

En informatique, on passe par une fase de test (avec test unitaire, une dtd, etc) pour 
tester les algorythmes pour voir que le comportement attendu est celui que l'on voulait.
On peut aussi procéder à des vérification très simple avec Python pour être sûr que
chaque partie du programme fait ce que l'on attendait.

On vient d'ajouter un nouveau module player au programme. Donc on évite de prendre le
risque de corrompre tout le programme avec la possibilité de tester chaque module du 
programme indépendamment du programme complet. Si le module tout seul est bugger, il va
faire planter le programme.

On organise une série de test basique sur le fichier player. On part du principe
que le fichier player.py est bon mais on veux éviter de faire bugger tout le programme
et donc de le corrompre. Ainsi on s'assure que le programme player.py tout seul est capable 
de fonctionner.

On utilise une condition avec une variable réservé à Python.

Maintenant voir <player.py>
"""
```