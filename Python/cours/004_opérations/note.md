# [4. Opérations](https://www.youtube.com/watch?v=w-r8SpjhmPQ)

Bienvenu sur notre formation langage Python

Maintenant que nous avons fait nos 3 premières séances, que vous avez bien vu comment fonctionnaient les variables, on va pouvoir parler des opérateurs et de comment faire des opérations dans ce langage là.

Maintenant vous savez, vous savez afficher du texte, vous savez lire des informations au clavier de l'utilisateur, vous savez comment stocker ces informations là dans des variables, on va pouvoir les utiliser tout au long de notre formation et je vais vous montrer maintenant qu'on ne va pas se contenter simplement d'enregistrer une information de l'utilisateur et de l'afficher, on va des fois avoir besoin de la modifier, de faire des calculs dessus, même faire des tests.

Par la suite, dans la prochaine vidéo, on verra comment faire des conditions, des boucles, surtout ce genre de choses et cetera et cetera.

On va partir sur un exemple de quelques variables et notamment, on va déjà présenté les premiers opérateurs, qu'est-ce que j'entends par opérateur ? Ne vous inquiétez pas, il n'y a pas besoin d'avoir de connaissances en mathématique très poussé, c'est vraiment très sommaire.

Il y a peut-être un nouvel opérateur que vous allez découvrir pour la plupart mais je vais bien vous l'expliquer, il est très très simple à comprendre et très très simple à apprendre surtout.

On va mettre sous forme de commentaires comme d'habitude pour vous donner un exemple des opérateurs."""

```py
#coding:utf-8
"""
    Opérateurs en Python :  + (addition)
                            - (soustraction)
                            * (multiplication)
                            / (division)
    
"""
```

Je met les opérateurs en python mais je les retrouve dans les autres langages de programmation donc, on a l'addition, la soustraction donc l'addition set met avec un plus. La soustraction c'est le tiret du 6, évidemment. La multiplication, ça se fait avec une étoile, très important, ça va comme ça en informatique, on ne met pas de X et on met une barre oblique, un slash pour la division.

Ca se sont les 4 opérateurs, des opérations mathématiques basiques que vous avez vu à l'école, que vous avez vu durant vos études, que vous voyez peut-être au travail encore, parce que vous êtes passioné de mathématique et cetera.

Donc tout ça normalement, vous connaissez bien, vous savez manipuler.

Et on termine avec un dernier opérateur qui est le pourcent qui va être utilisé pour le modulo. Le modulo, il s'agit du reste d'une division alors Euclidiènne si on veut être précis pour les puristes au niveau mathématique.

Voilà grosso modo comment ça se passe. Le modulo, ça veut tout simplement dire, j'en parle maintenant au niveau de ce type d'opérateur, si je prends le calcul 5 divisé par 2, d'accord vous allez avoir comme résultat si on compte un entier, 2. Parce que 2 fois 2 égal 4, au niveau entier, on va le mettre ici entre parenthèse (int).

```py
#coding:utf-8
"""
    Opérateurs en Python :  + (addition)
                            - (soustraction)
                            * (multiplication)
                            / (division)
                            % (modulo) -> reste d'une division Euclidiènne
    
"""
#(int) 5 / 2 = 2
```
Ce n'est pas du code ce que je vous note là pour le moment, je le note simplement comme texte.

Donc si on considère des entiers, si je fais 5 divisé par 2, je vais obtenir 2 donc là on va passer par contre par du code. 

```py
calcul = 5 / 2
```

calcul on va faire 5 divisé par 2, ensuite on va faire "calcul =", on va s'assurer qu'il y a bien un cast "calcul = int(calcul)", une bonne conversion et on va afficher, print("Résultat =", calcul).

```py
calcul = 5 / 2
calcul = int(calcul)
print("Résultat =", calcul)
```
```powershell
>python main.py
Résultat = 2
```

Il met donc que le résultat est égal à 2 effectivement, si on prend que les entiers c'est-à-dire pas de nombre à virgule, 5 divisé par 2 ça fait bien égal 2.

Donc vous voyez, c'est comme pour le l'affectation qu'on a vu tout à l'heure, qu'on a vu dans la vidéo précédente pour les variables, vous mettez votre variable, vous mettez le égal pour lui affecté quelque chose et vous faites votre calcul donc voilà des opérations toute bête, simplement qu'ici, au lieu de mettre un symbole comme vous pourriez le faire en mathématique, on met une barre oblique automatiquement. c'est comme ça que ça fonctionne.

Alors vous pouvez coller, ça ne pose pas de problème au niveau des espaces.

calcul = 5 / 2
calcul = 5/2

Moi par habitude, je sépare bien chaque chose, c'est une habitude que j'ai dans beaucoup de langage parce que je trouve ça plus lisible après c'est libre à vous c'est comme là "5 / 2", par exemple, je mets des espaces et cetera mais encore une fois c'est pas obligatoire, c'est vous qui voyez, vous faites comme vous voulez.

Donc là on a du coup l'affichage de 2.

Si je fais maintenant un float, je fais juste un affichage, théoriquement il va vous mettre 2,5 puisque là "float()", il attend un nombre flottant donc pour lui, il est capable de garder un nombre à virgule donc il va vous afficher, vous voyez, ce qui a été perdu.

```py
calcul = 5 / 2
calcul = float(calcul)
print("Résultat =", calcul)
```
```powershell
>python main.py
Résultat = 2.5
```

Je peux d'ailleurs m'amuser à faire ça si je veux pour être plus précis, pourquoi, parce que comme ça on sait vraiment directement qu'on manipule des float.

```py
calcul = 5.0 / 2.0
calcul = float(calcul)
print("Résultat =", calcul)
```
```powershell
>python main.py
Résultat = 2.5
```

Et à la rigueur, il y a même plus besoin de faire ça, float().

```py
calcul = 5.0 / 2.0
print("Résultat =", calcul)
```
Voilà, vous voyez, que ça fait la même chose puisque là j'ai bien précisé que c'était ça "5.0 et 2.0".

```py
calcul = 5 / 2
print("Résultat =", calcul)
```

En revanche comme tout à l'heure, si je reste tout simplement comme ça, il vous met effectivement que c'est ça puisqu'il a pris comme un flotant.

```powershell
>python main.py
Résultat = 2.5
```

Voilà par défaut, donc apparemment, ici, 5 divisé par 2, il le prend par défaut comme un flottant donc il nous le fait proprement mais si jamais, il l'avait pris comme un entier, on aurait eu des soucis donc vraiment penser toujours à faire un cast pour être sûr. Toujours c'est mieux de le faire de trop plutôt que de ne pas le faire du tout et de temps en temps, avoir un résultat inattendu. C'est toujours mieux de procéder comme ça.

```py
calcul = 5 / 2
calcul = float(calcul)
print("Résultat =", calcul)
```

Voilà comment ça fonctionne par contre voyez qu'il y a un reste c'est-à-dire que 5 divisé par 2 ça fait effectivement 2 quand j'ai un entier mais il reste un.

```py
calcul = 5 / 2
calcul = int(calcul)
print("Résultat =", calcul)
```

Mais ce reste de la division, c'est le modulo tout simplement donc si je fais "calcul2 = 5 % 2". Du coup calcul2, je fait un petit cast également, voilà.

Et là, je mettre "reste" pour mettre le reste, en fait, de la division. 

```py
calcul = 5 / 2
calcul = int(calcul)
calcul2 = 5 % 2
calcul2 = int(calcul2)
print("Résultat =", calcul, "reste", calcul2)
```
```powershell
>python main.py
Résultat = 2 reste 1
```

Ok résultat égal 2 reste 1, c'est effectivement le cas.

Si je fais, je sais pas moi, 14.

```py
calcul = 14 / 2
calcul = int(calcul)
calcul2 = 5 % 2
calcul2 = int(calcul2)
print("Résultat =", calcul, "reste", calcul2)
```
```powershell
>python main.py
Résultat = 7 reste 1
```

Il vous met que le résultat est de 7, 7 fois 2 égal 14. Il reste un pour arriver à 15 donc voilà ce nouvel opérateur de modulo donc très simple, vraiment vous voyez c'est assez simple.

A quoi sert le modulo ? il sert donc à récupérer le reste d'une division. Il peut servir aussi, par exemple, quand on veut savoir qu'un nombre est pair où impair, de base attention de manière basique c'est-à-dire qu'on va faire "nombre = 14" tout simplement.

```py
nombre = 14
```

Alors je ne vais pas voir les conditions parce qu'on n'en est pas encore là mais je pourrais très bien vérifier que par exemple en faisant modulo 2. Si le résultat, ici de nombre est égal à 0, c'est un nombre pair.

```py
nombre = 14 % 2
```

S'il est divisible par 2, c'est qu'il est pair, s'il n'est pas divisible par 2, il est un impair donc on peut faire comme ça des petits tests rapide, on verra d'ailleurs par la suite, avec cet opérateur.

% servira dans certains car, ne pensez pas qu'il ne servira pas. Il y a beaucoup de cas, donc le programme, beaucoup d'applications ou le modulo est vraiment très utile donc on ne peut pas passer à côté, il faut vraiment le connaître et vraiment le voir.

Sinon c'est tout ce qui à savoir, niveau des opérateurs, il y a vraiment rien à savoir de plus.

Au niveau des calculs puisque les opérateurs permettent de faire des calculs, on va mettre, je ne sais pas moi, "calcul", on va faire un print à la fin du calcul tout simplement.

```py
calcul
print(calcul)
```
ça fonctionne comme pour les mathématiques c'est-à-dire que si je fais ce calcul là de base avec le résultat qui va être de 26 puisqu'il fait 3 fois 7, 21 plus 5.

```py
calcul = 5 + 3 * 7
print(calcul)
```
```powershell
>python main.py
26
```

N'oubliez pas que la multiplication et la division et, en l'occurrence, le modulo au niveau de l'informatique sont prioritaires par rapport à l'addition et là soustraction donc il fera toujours ces calculs avant. 

```py
calcul = (5 + 3) * 7
print(calcul)
```
```powershell
>python main.py
56
```

Si je voulais qu'il fasse 5 plus 3 en premier, vous l'avez vu en mathématiques, il suffit de mettre des parenthèses parce qu'elles sont prioritaires par rapport à tous les opérateurs donc en informatique, c'est la même chose et là du coup le résultat est complètement différent parce qu'on fait 5 plus 3, 8 et on fait 8 fois 7, 56.

Donc là, on a vraiment une différence donc ça même chose les parenthèses vous pouvez les utiliser dans vos opérations, aussi bien qu'avec les opérateurs et ça fonctionnera et donc la priorité des opérateurs, avec des parenthèses, fonctionnera de la même manière qu'en mathématiques donc c'est à retenir.

Ca c'était au niveau de calcul et je voulais vous montrer une dernière petite chose qui est un petit peu ce qui va compléter et terminer cette vidéo, elle est assez courte parce ce que je vous avais dit qu'il n'y avait vraiment pas grand grand chose à voir à ce niveau-là. 

C'est au niveau des modifications de certaines valeurs, par exemple, je vais prendre beaucoup l'exemple de jeu vidéo encore une fois, je me répète beaucoup mais je trouve que les jeux vidéo, ils font appel à énormément de types de données, de type de structure, d'organisation de hiérarchie et cetera.

Ils permettre de mettre beaucoup de choses en œuvre et du coup de voir pas mal de cas différents donc ce sont de très bon exemple, en fait, de partir d'un jeu vidéo pour illustrer des propos et pour faire apprendre en fait la programmation. 

Je prends par exemple le niveau d'un personnage dans un jeu, d'accord, qui est de 14.

```py
niveauPersonnage = 14
```

De 14 admettons, de base, ou alors il est de 1 tout simplement alors voilà, je vais l'afficher, tout simplement.

```py
niveauPersonnage = 1
print("Niveau du personnage ", niveauPersonnage)
```

Et à un moment donné, le niveau de ce personnage pour je ne sais qu'elle action, on s'en fiche, ce n'est pas le sujet ici, il va évoluer.

```py
niveauPersonnage = 1
print("Niveau du personnage ", niveauPersonnage)
niveauPersonnage = 2
print("Niveau du personnage ", niveauPersonnage)
```

Donc on penserait, on dirait bah tiens au niveau suivant, il est égal à 2, voilà, de manière naïve, on ferait comme ceci. On voit effectivement que le niveau du personnage a augmenté.

D'ailleurs je pourrais même faire "Combat réussi...", voilà.

```py
niveauPersonnage = 1
print("Niveau du personnage ", niveauPersonnage)
print("Combat réussi, tu gagnes un niveau !")

niveauPersonnage = 2
print("Niveau du personnage ", niveauPersonnage)
```
```powershell
>python main.py
Niveau du personnage  1
Combat réussi, tu gagnes un niveau !
Niveau du personnage  2
```
Voilà même ça c'est plus clair d'accord, on gagne bien un niveau, il passe bien à 2.

Maintenant, si je veux faire, je ne sais pas moi, tu gagne 2 niveaux. Je dois faire mon comptage moi-même donc un plus 2 donc du coup, je fait 3.

```py
niveauPersonnage = 1
print("Niveau du personnage ", niveauPersonnage)
print("Combat réussi, tu gagnes deux niveaux !")

niveauPersonnage = 3
print("Niveau du personnage ", niveauPersonnage)
```
Encore une fois, vous voyez que je modifie toujours tout en dur, c'est-à-dire au niveau du code, je modifie cette information-là "niveauPersonnage = 3" et ce n'est pas fait de manière dynamique.

Vous imaginez bien dans un vrai jeu, un vrai programme, on ne ferait pas comme ceci.

Du coup comment je peux faire pour dire bah tiens j'ajoute 1 à ma variable, en fait, alors que bah je ne sais pas forcément ici qu'est-ce que j'aurai comme valeur "niveauPersonnage = 1" notamment ceci :

```py
niveauPersonnage = input("Niveau de départ ? ")
niveauPersonnage = int(niveauPersonnage)
```
Et du coup, on va dire tu gagnes un niveau.
```py
niveauPersonnage = input("Niveau de départ ? ")
niveauPersonnage = int(niveauPersonnage)
print("Niveau du personnage ", niveauPersonnage)
print("Combat réussi, tu gagnes un niveau !")

niveauPersonnage = 3
print("Niveau du personnage ", niveauPersonnage)
```
Et la tout de suite, vous imaginez, le programme , tout de suite, tombe à l'eau.
```powershell
>python main.py
Niveau de départ ? 15
Niveau du personnage  15
Combat réussi, tu gagnes un niveau !
Niveau du personnage  3
```

Voilà niveau des départ, mettons 15 et bon bah niveau de personnes, il est de 15. T'as réussi un combat, tu gagnes un niveau et là, le niveau du personnage est à 30, ça va pas du tout puisque bah oui, j'ai noté ici une valeur comme ça "niveauPersonnage = 3".

Mon programme n'est pas du tout évolutif, il n'est pas dynamique, ça va pas du tout.

Je ne peux pas faire comme ça. Il y en a plein qui pourrait se dire et bien tiens comme t'es parti de 15, tu met 16 mais encore une fois ça dépend de ce que la personne va rentrer. C'est pas possible de procéder comme ça. Dans tous les cas, on va toujours avoir une valeur qui ne sera pas bonne.

Pour ça vous pouvez très bien faire des calculs sur vos variables, n'oubliez pas niveauPersonnage contient un entier donc rien vous empêche de faire ceci, de dire que niveauPersonnage maintenant c'est égal à niveauPersonnage, ce que vous aviez déjà avant de stocker dedans plus un.

*niveauPersonnage = niveauPersonnage + 1*

```py
niveauPersonnage = input("Niveau de départ ? ")
niveauPersonnage = int(niveauPersonnage)
print("Niveau du personnage ", niveauPersonnage)
print("Combat réussi, tu gagnes un niveau !")

niveauPersonnage = niveauPersonnage + 1
print("Niveau du personnage ", niveauPersonnage)
```
```powershell
>python main.py
Niveau de départ ? 15
Niveau du personnage  15
Combat réussi, tu gagnes un niveau !
Niveau du personnage  16
```
```powershell
>python main.py
Niveau de départ ? 34
Niveau du personnage  34
Combat réussi, tu gagnes un niveau !
Niveau du personnage  35
```

Et là miracle évidemment, peu importe le niveau départ, ça va fonctionner, voilà.

Ca peut sembler logique pour beaucoup. Ils y en a plein qui ont dit bah tiens je l'avais vu déjà, qu'il fallait faire comme ça. Il y en a beaucoup qui n'auraient pas forcément remarqué donc je voulais quand même le préciser parce que c'est pas logique pour tout le monde donc c'est bien de faire un rappel ou en tout cas, de montrer que vous pouvez sans problème faire des opérations avec des variables, ça ne pose aucun soucis puisque niveauPersonnage, c'est égal dans notre cas là 15 et puis à 34 donc il fait bien + 1 à chaque fois.

Alors quand on fait ce genre de chose là, par exemple, bah une variable donc ce schéma là ... je vais le noter ici. Quand on fait "A = A + X". X c'est un nombre entier et A c'est une variable. """

```py
"""
    Opérateurs en Python :  + (addition)
                            - (soustraction)
                            * (multiplication)
                            / (division)
                            % (modulo) -> reste d'une division Euclidiènne
    
    A = A + X
    
"""
```
Ou alors, je vais mettre "variable = variable + x".
```py
"""
    Opérateurs en Python :  + (addition)
                            - (soustraction)
                            * (multiplication)
                            / (division)
                            % (modulo) -> reste d'une division Euclidiènne
    
    variable = variable + x   
"""
```

Je fait "variable = variable + x". Quand on fait ce genre de chose, on peut raccourcir en faisant variable plus égale x.

```py
"""
    variable = variable + x
    variable += x
"""
```
ça va être exactement la même chose. Si je veux faire variable égal variable moi x pareil je peux faire variable moins égal x et cetera.
```py
"""
    variable = variable + x
    variable += x
    
    variable = variable - x
    variable -= x
"""
```
ça va fonctionner pour tous les opérateurs, variable fois x, je peux faire variable fois égal x.
```py
"""
    variable = variable + x
    variable += x
    
    variable = variable - x
    variable -= x
    
    variable = variable * x
    variable *= x
"""
```
Donc ça c'est un autre opérateur (+=) enfin c'est plutôt un opérateur d'affectation ici, un peu différent, qui permet de dire bah tu ici tu ajoutes à lui-même donc à la variable elle-même ce qu'il y a à droite donc ici le X.

(-=), là tu soustraits au contenu de la variable elle-même x.
(*=), là tu me multiplies au contenu de la variable elle-même x et cetera et cetera pareil pour la division, le modulo.

Donc à retenir, ce sera très utile dans certains cas pour aller beaucoup plus vite, du coup, x bah  n'importe ça peut être n'importe quoi, ça peut être 3, 4, 5, 15 comme vous voulez et vous pouvez comme ça raccourcir votre ligne.

```py
niveauPersonnage = input("Niveau de départ ? ")
niveauPersonnage = int(niveauPersonnage)
print("Niveau du personnage ", niveauPersonnage)
print("Combat réussi, tu gagnes un niveau !")

niveauPersonnage += 1
print("Niveau du personnage ", niveauPersonnage)
```py
```powershell
>python main.py
Niveau de départ ? 34
Niveau du personnage  34
Combat réussi, tu gagnes un niveau !
Niveau du personnage  35
```
Donc là, je pouvais très bien faire le niveauPersonnage += 1, évidemment on obtient exactement la même chose au niveau du résultat.

ça c'est à retenir, petit opérateur comme ça, des opérateurs d'affectation qui sont des raccourcis, qui seront bien utiles pour beaucoup de choses.

C'est tout pour cette vidéo là, on s'arrêtera ici. Vous avez vu les opérateurs que vous utilisez en mathématiques, nouvel opérateur modulo %, on a vu comment modifier de manière dynamique l'affichage d'une variable donc son contenu, pouvoir modifier ces valeurs et comment utiliser des petits raccourcis comme ça pour affecter en fait des nouvelles valeurs à vos données.

On se retrouve dans une prochaine vidéo, on aura l'occasion de parler un petit peu des structures conditionnelles, des boucles. On va voir des choses assez intéressantes, on va pouvoir faire des tests et des boucles donc afficher les traitements répétitifs sur nos programme et moi je vous dis à très bientôt dans une prochaine vidéo

## Resume

```py
###############################################
#################### Resume ################### 
###############################################

#coding:utf-8

#   Python #4 - opérations
#   https://www.youtube.com/watch?v=w-r8SpjhmPQ&list=PLrSOXFDHBtfHg8fWBd7sKPxEmahwyVBkC&index=4
#   Après les variables, vous voilà en mesure d'effectuer des calculs mathématiques très simples, et même de découvrir ce que l'on nomme le "modulo" d'un nombre, soit le reste d'une division.

"""
Operateurs en Python.
 		+ addition
		- soustraction
		* multiplication
		/ division
		% modulo -> reste division Euclidienne.
"""
#1# Division entre entiers.
# (int) 5 / 2 = 2 -> on considere ici des entiers contrairement au modulo.
calcul = 5 / 2 # Espacer pour plus de lisibilité.
calcul = int (calcul) # Faire un cast.
print("Résultat =", calcul) # afficher le resultat si on prend que les entiers.

#2# Division entre floatants.

calcul = 5 / 2 # floatant par défaut (sans CAST).
print("Résultat =", calcul)

calcul = 5.0 / 2.0
calcul = float (calcul) # Toujours faire un cast malgre le cast par defaut pour eviter resultat inattendu.
print("Résultat =", calcul)

#3# Différence entre / et %.

calcul = 5 / 2
calcul = int (calcul)
calcul2 = 5 % 2 # Modulo : 
# % permet de récupérer le reste d'une division.
# % permet de savoir si un nombre est pair ou impair.
calcul2 = int (calcul2)
print("Résultat =", calcul, "reste =", calcul2)

#4# Calcul.

calcul = 5 + 3 * 7 # Les priorités des opérateurs sont les mêmes qu'en mathématique. 
print(calcul)

calcul = (5 + 3) * 7 # Les parantheses sont prioritaires par rapport a tous les operateurs.
print(calcul)

#5# Opération, opérateurs d'affectations et application dynamique.

#-1- Application statique, en dur (non dynamique).
niveauPersonnage = 1
print("Niveau du personnage", niveauPersonnage)
print("Combat réussi, tu gagnes deux niveaux !")
niveauPersonnage = 3 # Application statique.
print("Niveau du personnage", niveauPersonnage)

#-2- Application dynamique.
niveauPersonnage = input("Niveau de départ ? ")
niveauPersonnage = int(niveauPersonnage)
print("Niveau du personnage", niveauPersonnage)
print("Combat réussi, tu gagnes deux niveaux !")
niveauPersonnage = niveauPersonnage + 1 # Application dynamique : faire des calculs sur nos entiers; peu importe le niveau de depart, notre application monte le niveau. On fait donc une operation sur une variable, on l'incremente.
print("Niveau du personnage", niveauPersonnage)

"""
Raccourcis en Python :
	variable = variable + X
	variable += X

	variable = variable - X
	variable -= X
	
	variable = variable * X
	variable *= X # multiplier la variable elle-meme par x.

+=, -=, *= sont des operateurs d'affectations plus rapide.
"""

niveauPersonnage = input("Niveau de départ ? ")
niveauPersonnage = int(niveauPersonnage)
print("Niveau du personnage", niveauPersonnage)
print("Combat réussi, tu gagnes deux niveaux !")
niveauPersonnage += 1 # Application dynamique.
print("Niveau du personnage", niveauPersonnage)
```