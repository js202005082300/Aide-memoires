# [Différences 2.X et 3.X](https://www.youtube.com/watch?v=LU7FSqzVrdc)

Vidéos sur les distinctions, différences majeures entre les deux versions en Python. Voilà il y a eu un changement majeur au niveau syntaxe, au niveau notation, au niveau des modules également entre les 2 versions.

N'hésitez pas à voir sur le site officiel pour voir l'intégralité des changements qu'il y a pu y avoir mais cette vidéo va vous servir si vous avez des logiciels qui utilisent une vieille version l'interpréteur python ça peut par exemple arriver sur certaines version de Blender ou autre, où vous avez un interpréteur de python 2.6 ou 2.7 alors que vous avez suivi la formation sur le langage python avec 3.5 et cetera.

## print

Le premier changements qui ont été opérés concerne surtout l'affichage avec la fonction print().

Dans la version 2, on écrivait dans ce format.

+ Python 2.x
```py
import sys

maVariable = 14
x = 186
y = 223

#Python 2.x
print "Bonjour"
print maVariable
print "maVariable =", maVariable

## retour à la ligne
print "Sans retour à la ligne",
print

## coordonnées
print ":".join([x, y]) #Par exemple pour le sépareteur de coordonnées, n'utilisé plus de join() en python 3.

## afficher sur la  sortie d'erreur standard (import sys)
print >> sys.stderr, "message..."
```
+ Python 3.x
```py
import sys

maVariable = 14
x = 186
y = 223

#Python 3.x
print("Bonjour")
print(maVariable)
print("maVariable =", maVariable)

## retour à la ligne
print("Sans retour à la ligne", end="")
print()

## coordonnées
print(x, y, sep=":")

## afficher sur la  sortie d'erreur standard (import sys)
print("message...", file=sys.stderr)
```
```powershell
> python main.py
Bonjour
14
maVariable = 14
Sans retour à la ligne
186:223
message...
```

## input

Il y a également des changements au niveau de la saisie parce qu'avant au niveau de python séparer bien tout ce qui était saisie de chaînes de caractères par rapport à ce qui était les nombres donc les entiers ce genre de chose.

Admettons par exemple qu'on voudrait faire saisir un nombre, on faisait comme ceci.

En python 2,
```py
donnee = input("Entrez un nombre : ")
chaine = raw_input("Entrez du texte : ")
```

En python 3, c'est tout dans le input et pour récupérer un entier, il suffit de caster parce que la donnée entrée est une chaîne de caractères et bien évidement avec un try/except nous allons pouvoir contrôler, vérifier l'information qui a été saisie puis encore une fois vous nêtes pas sûr de ce que l'utilisateur va vouloir entrer.

```py
donnee = input("Entrez un nombre :")
donne = int(donnee)
```

Très pratique, plus qu'une seule fonction.

## Encodage utf-8

Alors j'en avais parlé dès le début des premières vidéos en vous disant que python 3 était pratique au niveau du l'encodage c'est-à-dire qu'avant en python il fallait selon les types de chaîne quand vous les utilisez avec les accents de la langue française, il fallait spécifier des préfixes, préfixe U, préfixe L avec L qui était pour tout ce qui était nombre et le préfixe U pour tout ce qui était unicode, chaîne d'encodage pour gérer les accents, ou les différentes langues donc c'est assez compliqué donc l'encodage avec python 2.X était vraiment casse-pieds.

Ensuite python 3 est passé en full unicode tout simplement c'est pour ça qu'on mettait cette ligne au début du fichier `#coding:utf-8` pour s'assurer que c'est toujours en utf 8 mais automatiquement python 3 est de base en utf 8 mais en revanche quand on travaillait avec python 2.x, il fallait vraiment le spécifier volaille fallait faire des changements particuliers au niveau des chaînes de caractères donc nous c'est très simple en python 3 si je veux une chaîne, je peux écrire absolument ce que je veux et ça va gérer les accents sans problème.

```py
chaîne = "Cétait l'été, et il faisait chaud"
```

Je peux écrire des idéogrammes chinois, des caractères en arabe, ce sera géré sans problème parce que l'unicode c'est universel. C'est l'encodage universel qui va gérer toutes les langues du monde, tous les caractères quel qu'il soit.

Voilà peut importe travailler toujours en utf-8 et ça fonctionnera partout.

C'est une très bonne avancée au niveau de python 3 de prendre nativement en charge l'encodage utf 8, c'était quelque chose de très attendu et surtout maintenant on se embête plus.

## Opérateurs

Nouveautéen Python 3.

```py
x = 123.0
y = 14.6

print(x/y)
```
```powershell
> python main.py
8.424657534246576
```

Si on veut un nombre entier, il suffit de mettre un double slash.

```py
x = 123.0
y = 14.6

print(x//y)
```
```powershell
> python main.py
8.0
```

Voilà ça c'est un petit changement avec python 3, c'est le double slash pour pouvoir tronquer une valeur enfin la valeur décimal d'un an pour pouvoir afficher un nombre entier.

## symbole de différence

En python 2,
```py
x = 128.0
y = 14.6

if x <> y:
```

En python 3,
```py
x = 128.0
y = 14.6

if x != y:
```

`!=` est le symbole qu'on retrouve déjà en c, c++, csharp, java, et cetera.

## Les entiers

Alors avant les entiers c'était de type `long` tout simplement, on avait d'ailleurs pour pouvoir caster dans ce type là la fonction long() mais maintenant ça n'existe plus, on a le type `int` la fonction associée int() qui permet de caster en entier.

En python 2,
```py
long
long()
```

En python 3,
```py
int
int()
```

Pareil il n'y a plus de long, juste int.

## Les métaclasses

Par exemple ceux qui voulaient avoir faire des méta classes, on fait comme ceci `class MaClasse:` et là j'utilisais le format `__metaclass__` que je faisais égalé au nom de la méta classe `__metaclass__ = MaMetaClasse`.

```py
#Python 2.X
class MaClasse:
    __metaclass__ = MaMetaClasse
```

Alors on utilisait cet attribut réservé `__metaclass__` pour pouvoir le préciser.

Ça c'était en python 2.x et maintenant on crée `class MaClasse()` et entre parenthèses la valeur associée à metaclass.

```py
#Python 3.X
class MaClasse(metaclass = MaMetaClasse):
```

Voilà on gagne du temps en mettant tout sur une seule ligne ce qui est beaucoup plus clair donc pour tout ce qui est gestion de méta classes on procède de cette manière-là et pas de la manière python 2.X sinon vous aurez évidemment un problème à l'exécution de votre fichier.

## Lever une exception

```py
#Python 2.X
raise "message erreur"
raise TypeError, "message"
```

```py
#Python 3.X
raise Exception("Message erreur")
raise TypeError("message")
```

C'est pareil à print() lorsqu'on avait ajouté des parenthèses et donc on met des messages entre les parenthèses et entre les guillemets.

Si on avait un type particulier genre `TypeError`, c'est pareil on ne se embête plus on écrit le type d'erreur et entre parenthèses le message.

Voilà ça change beaucoup au niveau de la syntaxe et c'est beaucoup plus logique de mettre les parenthèses.

## Changement de noms

Par exemple il y a la fonction xrange() qui permettait la gestion de nombres aléatoires est devenu simplement range(). Ensuite la fonction long() qui est devenue int() qui est notre fonction pour le cast d'un entier. On a la fonction basestring() pour ce qui était des chaînes de caractères et qui est devenu str() et cetera. urlparse qui est devenu urllib.parse parce que c'était lié à un module.

```py
# Python 2.X    Python 3.X
xrange() -> range()
long() -> int()
basestring() -> str()
urlparse -> urllib.parse
```

On a eu également toutes les fonctions de taking terre pour ce qui est des programmes fenêtrés, il y a eu beaucoup de changements à ce niveau-là mais je ne vais pas tous les énumérer et cetera. Pour socket pareil il y a pas mal de choses aussi pour le réseau.

Avec python 3, ils ont rassemblé plusieurs modules dans des packages et donc au lieu d'avoir plein de modules complètement mélangés, on a des package plutôt généraux qui contiennent pas mal de choses comme le package `html`, on aura également le package `http` donc c'est des choses qu'on a vu ou qu'on verra sur les vidéos qu'on propose sur la chaîne. On a donc aussi le package `tkinter` que l'on connaît bien parce qu'avant tkinter était un ensemble de plusieurs modules et maintenant c'est tout un package comme ça on peut tout utiliser plus facilement. Et on a le fameux `urllib` pareil qui est un package avec plusieurs fonctions disponibles tout simplement.

```txt
html
http
tkinter
urllib
```

Alors au niveau des changements de nom il y avait `cPickle` qui permettait de faire de la copie en binaire dans des fichiers et maintenant ça devenu simplement `pickle` pour faire de la c'est sérialisation ou de la dé-sérialisation tout simplement. On a également `Tkinter` qui est maintenant a écrit tout le temps minuscule `tkinter` parce que je vous rappelle que la casse minuscule majuscule est très importante donc faites très attention quand vous écrivez vos codes. On a `thread`qui a changé avec un petit underscore devant `_thread` et cetera.

```txt
cPickle -> pickle
Tkinter -> tkinter
thread -> _thread
Queue -> queue
repr -> reprlib
```

Alors il y a des articles officiels sur le site de python.org qui vous précise tout le détail des changements qu'il y a pu y avoir que ce soit au niveau de la syntaxe et des fonctions, des modules, aussi sur les dictionnaires, les listes et tout ça dont on n'a pas beaucoup parlé ici.

Ce qui est important à retenir c'est que python 3 est également un peu plus rapide que python 2 au niveau de l'exécution qui est de l'ordre de 10 à 20% d'après les tests benchmark qui ont été faites.

Évidemment il y a eu une simplification de la syntaxe parce qu'il est beaucoup plus logique d'avoir des parenthèses, ce qui est plus logique que d'avoir des virgules partout et de ne pas savoir où on en est, et puis des simplifications surtout au niveau de l'encodage c'est à dire que maintenant tout est automatiquement en utf 8 et ça ça aide quand même énormément dans les développements puisqu'on peut écrire du français, de l'anglais, du japonais, de l'arabe et tout ce qu'on veut.

Voilà on recommande toujours travailler en python 3, Et s'il y a des vieux programmes qui utilisent encore python 2 et qui ne peuvent pas être mis un jour, vous n'aurez pas trop le choix mais maintenant vous savez comment produire du code en python 2 si vous êtes obligé de passer par là.

Si on commence en python alors il est recommandé de partir dès le début sur python 3 voir la version la plus récente et au moment de la vidéo c'est la 3.6 donc ne pas hésiter pour avoir les dernières fonctionnalités.

Ciao