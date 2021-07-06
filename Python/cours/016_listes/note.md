# [16. Listes](https://www.youtube.com/watch?v=AFRdL2hge0o)

+ [01 - Créer une liste (vide)](#01---Créer-une-liste)
    + [Choisir un nom de variable car tout objet doit être stocker dans une variable](#Choisir-un-nom-de-variable-car-tout-objet-doit-être-stocker-dans-une-variable)
    + [Faire un type() au niveau du code pour vérifier la liste créé](#Faire-un-type-au-niveau-du-code-pour-vérifier-la-liste-créé)
    + [Créer une liste vide (syntaxe à prévilégier)](#Créer-une-liste-vide)
    + [Créer une liste non-vide](#Créer-une-liste-non-vide)
        + [Liste avec des éléments du même type](#Liste-avec-des-éléments-du-même-type)
        + [Liste avec des éléments de type différent](#Liste-avec-des-éléments-de-type-différent)
    + [Initialiser une liste avec un nombre d'éléments identiques](#Initialiser-une-liste-avec-un-nombre-d-éléments-identiques)
    + [Initialiser une liste avec des valeurs croissantes](#Initialiser-une-liste-avec-des-valeurs-croissantes)
+ [02 - Afficher une liste avec une boucle](#02---Afficher-une-liste-avec-une-boucle)
    + [1er méthode WHILE](#1er-méthode-WHILE)
    + [2ème méthode FOR](#2ème-méthode-FOR)
+ [03 - Accéder à un élément de notre liste](#03---Accéder-à-un-élément-de-notre-liste)
    + [Afficher l'élément qui a un indice 1](#Afficher-l-élément-qui-a-un-indice-1)
    + [Afficher la totalité de la liste](#Afficher-la-totalité-de-la-liste)
    + [Afficher les deux premiers élément de la liste](#Afficher-les-deux-premiers-élément-de-la-liste)
    + [Afficher en retirant les deux premiers élément de la liste](#Afficher-en-retirant-les-deux-premiers-élément-de-la-liste)
    + [Afficher l'élément d'indice en partant de la fin](#Afficher-l-élément-d-indice-en-partant-de-la-fin)
    + [Afficher les éléments compris entre deux bornes](#Afficher-les-éléments-compris-entre-deux-bornes)
+ [04 - Modifier élément-s de notre liste](#04---Modifier-élément-s-de-notre-liste)
    + [Affichage après la modification d'un élement](#Affichage-après-la-modification-d-un-élement)
    + [Modification multiple d'un élément](#Modification-multiple-d-un-élément)
    + [Modification multiple avec calcul sur les valeurs d'affectation](#Modification-multiple-avec-calcul-sur-les-valeurs-d-affectation)
    + [Modification de tous les éléments de la liste](#Modification-de-tous-les-éléments-de-la-liste)
    + [Modification d'éléments entre deux bornes](#Modification-d-éléments-entre-deux-bornes)
+ [05 - Faire une recherche de notre liste](#05---Faire-une-recherche-de-notre-liste)
    + [Rechercher une chaine (voir Resume pour un entier)](#Rechercher-une-chaine)
+ [06 - Ajouter élément-s](#06---Ajouter-élément-s)
    + [Ajouter plusieurs éléments (append)](#Ajouter-plusieurs-éléments)
    + [Insérer un élément où l'on veux (insert)](#Insérer-un-élément-où-l-on-veux)
+ [07 - Retirer un élément](#07---Retirer-un-élément)
    + [1er méthode de suppression (remove)](#1er-méthode-de-suppression)
    + [2ème méthode de suppression (del)](#2ème-méthode-de-suppression)
+ [08 - Retourner un indice et supprimer l élément (index)](#08---Retourner-un-indice-et-supprimer-l-élément)
+ [09 - Trier une liste par ordre croissant (sort) | décoissant (sort + reverse)](#09---Trier-une-liste-par-ordre-croissant)
+ [10 - Inverser les valeurs d'une liste (reverse)](#10---Inverser-les-valeurs-d-une-liste)
+ [11 - Compter le nombre d éléments d une liste (count)](#11---Compter-le-nombre-d-éléments-d-une-liste)
+ [12 - Effacer tous les éléments de la liste (clear)](#12---Effacer-tous-les-éléments-de-la-liste)
    + [Affecter une nouvelle liste vide](#Affecter-une-nouvelle-liste-vide)
+ [14 - Demander de l'aide pour les méthodes de list (help)](#14---Demander-de-l-aide-pour-les-méthodes-de-list)
+ [15 - Passer d'une chaine à une liste](#15---Passer-d-une-chaine-à-une-liste)
+ [16 - Passer d'une liste à une chaine](#16---Passer-d-une-liste-à-une-chaine)
+ [Bonus : ON NE TRAVAILLE PAS SUR DES COPIES](#Bonus---ON-NE-TRAVAILLE-PAS-SUR-DES-COPIES)
    + [Si on veut néanmoins créer une copie de liste (deepcopy)](#Si-on-veut-néanmoins-créer-une-copie-de-liste)
+ [17 - Concatener deux listes (extend)](#17---Concatener-deux-listes)
    + [Autre méthode : La somme (+)](#La-somme)
+ [Conclusion](#Conclusion)
    + [La méthode enumerate() pour la prochaine séance](#enumerate)
    + [La méthode len() vu dans cette séance](#len)
+ [Resume](#Resume)

>

Bonjour à tous, bienvenue pour votre séance numéro 16 sur le langage python. 

Aujourd'hui nous allons parler des listes c'est-à-dire une espèce de structure nouvelle dans ce langage, pour votre information il n'existe pas de tableau dans en python. 

On peut faire des tableaux, si on veut on peut fonctionner avec un système de tableau mais il faut savoir que c'est vraiment peu utilisé. 

On peut tout faire de toute manière avec les listes, on peut sans problème fonctionner comme avec un tableau puisqu'une liste est un système de séquence, ça va permettre d'avoir une séquence d'informations qui vont se suivre où chaque élément est à sa place. 

Après on peut avoir des éléments rangés, qui sont triés, non trié et des éléments de plusieurs types mais je vais vous en parler par la suite. 

Alors première chose à savoir au niveau de cette fameuse liste par rapport à la chaîne de caractères, notamment ce que vous avez vu dans la vidéo précédente, c'est que tout ce que nous allons faire sur la liste va se passer directement dessus c'est-à-dire qu'on va directement travailler sur les listes telles qu'elles sont en mémoire. 

On ne va pas travailler sur des copies comme je vous l'avais expliqué dans la vidéo précédente avec les chaînes de caractères donc vous allez voir que ça peut amener à certaines erreurs par la suite notamment quand on va vouloir faire de la copie de liste mais je vais vous montrer tout ça de toute manière par la suite. 

Alors les listes c'est très simple, en python, elles ont un gros avantage, c'est qu'elles sont très flexibles c'est-à-dire que nous allons pouvoir contenir tout un tas d'objets différent.

Vous n'êtes pas obligé comme par exemple dans les tableaux dans d'autres langages de programmation, de faire une liste d'entiers, une liste de chaînes ou une liste de personnes, ce genre de chose. 

Vous pouvez avoir une liste qui mélange des entiers, des personnes, des animaux, des voitures, n'importe quel type d'objet parce que je vous rappelle également que les entiers, les chaînes ce sont justement des objets en python. 

C'est vraiment cet avantage-là, cette flexibilité, de pouvoir y mettre un petit peu de tout et n'importe quoi, et on a beaucoup de méthode, beaucoup de possibilités, beaucoup de systèmes pour pouvoir les manipuler, y accéder très simplement. 

Cette vidéo sera assez longue, il y a beaucoup de choses à vous montrer. C'est beaucoup de nouvelle syntaxe, beaucoup de choses à retenir donc n'hésitez pas à prendre note si nécessaire. Je ne vais pas forcément moi les faire, vous savez que moi d'habitude je mettais des notes comme ça en début de code mais comme il y a beaucoup de choses, je ne voudrais pas faire quelque chose en rallonge. 

N'hésitez pas à mettre sur pause la vidéo, à regarder comme ça au fur et à mesure si vous le voulez. 

Alors une liste, tout simplement, nous allons voir comment en créer une, comment créer une liste ?

## 01 - Créer une liste

Nous allons faire la création, je vais le noter ici.
```py
    #coding:utf-8

    #Création d'une liste
```
Je vais commenter un petit peu ce que je fais au fur et à mesure mais je ne laisserais pas forcément tout le code parce que sinon on va se retrouver avec quelque chose d'assez conséquent. 

On peut créer une liste de plusieurs façons, moi je vais essayer de vous montrer différentes manières qui ne sont pas forcément propre liste mais c'est surtout différentes manières pour obtenir une liste à la fin, d'accord. 

### Choisir un nom de variable car tout objet doit être stocker dans une variable

Alors on va déjà faire un truc, ce qu'on affichera notre liste. On va faire un inventaire, on va lui choisir un nom de variables parce que tout objet va être stocké dans une variable, ça je ne vous apprends rien. Et la première méthode à connaître, c'est d'instancier tout simplement une liste, list(). Un inventaire, c'est une liste.
```py
    #coding:utf-8

    #Création d'une liste
    inventaire = list()

    print(inventaire)
```

### Faire un type au niveau du code pour vérifier la liste créé

Je peux d'ailleurs vous faire un type() de inventaire pour vous montrer au niveau du code. 
```py
#coding:utf-8

#Création d'une liste
inventaire = list()

print(type(inventaire))
```
```powershell
    >python main.py
    <class 'list'>
```
Vous voyez qu'il vaut mais que c'est bien de classe list donc on a créé une liste vide qui porte le nom d'inventaire.

À partir de là, on peut tester bêtement si on fait un print() d'inventaire pour voir un petit peu le résultat que vous, vous obtenez ceci. 
```py
#coding:utf-8

#Création d'une liste
inventaire = list()

print(inventaire)
```
```powershell
    >python main.py
    []
```
Il vous met des crochets, le crochet permet de distinguer justement les éléments d'une liste en fait en python.

Et là vous voyez qu'elle est vide. 

### Créer une liste vide

On peut du coup sans problème créer une liste vide de cette manière c'est-à-dire en mettant justement des crochets vide. Et on peut tester.
```py
#coding:utf-8

#Création d'une liste
inventaire = []

print(inventaire)
```
```powershell
    >python main.py
    []
```
Vous voyez, vous avez exactement la même chose. C'est pareil, c'est une syntaxe un peu plus courte. Moi j'utilise en général celle là quand je fais des listes vides, j'utilise très très rarement voir même jamais le mot clé list directement même si à la rigueur c'est plus explicite mais ça on sait qu'en python, il n'y a pas de souci. En python, il n'y a pas de souci, on crée une liste vide de cette manière. On ne peut pas se tromper.

### Créer une liste non-vide

On a également d'autres possibilités parce que vous pouvez sans problème créer une liste avec déjà des éléments, d'accord. 

#### Liste avec des éléments du même type

Donc si vous voulez créer des éléments déjà disponible dans la liste, vous pouvez faire comme ceci, `inventaire = [1, 6, 15]`, tout simplement.
```py
#coding:utf-8

#Création d'une liste
inventaire = [1, 6, 15]

print(inventaire)
```
```powershell
    >python main.py
    [1, 6, 15]
```

#### Liste avec des éléments de type différent

Alors là j'ai mis des éléments qui sont du même type, ce sont des entiers mais je peux sans problème mettre des chaînes de caractères avec.
```py
#coding:utf-8

#Création d'une liste
inventaire = [1, 6, 15, "voiture"]

print(inventaire)
```
```powershell
    >python main.py
    [1, 6, 15, 'voiture']
```
OK ça fonctionne très très bien de ce que tu es là, pas de souci.

Voilà, ça c'est grosso modo pour voir comment vous pouvez faire. Il y a certaine personne parmi vous qui auront peut être besoin d'initialiser une liste avec un certain nombre d'éléments pareil. 

### Initialiser une liste avec un nombre d éléments identiques

Admettons que vous pourriez faire une liste avec seulement des 0, un certain nombre de fois et si vous faites ça. 
```py
#coding:utf-8

#Création d'une liste
inventaire = [0]

print(inventaire)
```
```powershell
    >python main.py
    [0]
```
Vous allez avoir évidemment un seul 0, ce n'est pas comme les tableaux en langage c ou autre, là vous allez avoir qu'un seul 0 dans la liste. 

Là admettons, moi je veux créer une liste qui a déjà dix 0 de base, et bien on peut s'amuser à faire des petites manipulations directement à la création. 

Vous mettez ce que vous avez mis ici, [0], et vous faites tout simplement multiplier par 10, [5] * 10.
```py
#coding:utf-8

#Création d'une liste
inventaire = [0] * 10

print(inventaire)
```
```powershell
    >python main.py
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
```
Et là vous allez avoir 10 éléments dans la liste qui sont des 0 et ça fonctionne avec n'importe quel autre élément, attention là on travaille sur autre chose, un "arc" par exemple, ça va fonctionner évidemment aussi. 

Donc c'est très pratique, je vous recommande vraiment de bien connaître ça parce que ça peut faire gagner beaucoup beaucoup de temps quand on veut initialiser une liste comme ça par défaut avec un certain nombre d'éléments. 
```py
#coding:utf-8

#Création d'une liste
inventaire = ["arc"] * 10

print(inventaire)
```
```powershell
    >python main.py
    ['arc', 'arc', 'arc', 'arc', 'arc', 'arc', 'arc', 'arc', 'arc', 'arc']
```
Mieux encore, je peux vous proposer quelque chose d'encore mieux c'est de faire une liste avec un certain nombre de valeur croissante, ça ça peut arriver quand on fait des calculs statistiques, des programmes mathématiques oui donc ça peut être très intéressant de faire ça. 

### Initialiser une liste avec des valeurs croissantes

On va utiliser pour ça une fonction, c'est pas forcément lié aux listes, c'est une fonction qui s'appelle range() qui va permettre de choisir un certain nombre d'éléments donc on va faire tout simplement range() et on veut lui dire par exemple 20 éléments c'est-à-dire qu'elle va insérer de 0 à 19 dans une liste que l'on va avoir. 
```py
#coding:utf-8

#Création d'une liste
inventaire = range(20)

print(inventaire)
```
```powershell
    >python main.py
    range(0, 20)
```
Alors si j'essaye de l'afficher tel quel, vous allez voir qu'il me met range(0, 20).

C'est-à-dire que vous ne voyez pas les éléments puisque le simple fait d'afficher comme ça un inventaire ne va pas forcément afficher tous les éléments donc là il met simplement quel était égal à range(0, 20) qui est effectivement ce que l'on a mis.

## 02 - Afficher une liste avec une boucle

### Afficher la totalité de la liste

Donc on va voir très rapidement comment afficher une liste autrement et vous avez une manière très simple c'est-à-dire que vous mettez inventaire[:] qui permet d'afficher la totalité de la liste, d'accord. 
```py
#coding:utf-8

#Création d'une liste
inventaire = range(20)

print(inventaire[:])
```
```powershell
    >python main.py
    range(0, 20)
```
Alors là évidemment ça ne changera pas parce que je suis sur du range() donc ça ne changera pas. 

On ne va pas reprendre range(), ce n'est pas grave, on va faire un parcours même si on regardera un peu après. 

Je vais vous montrer tout de suite comment afficher la liste comme ça voilà on pourra revenir sur le range() plutôt que de passer à côté. 

Vous avez plusieurs possibilités, vous avez déjà vu dans la vidéo sur les boucles, si vous vous souvenez j'avais fait une petite boucle for et j'avais dit que ça permettait de parcourir les séquences, qu'on avait la boucle while tu faisait tout un système d'instructions, un certain nombre de fois. Et la boucle for était en général réservé pour parcourir une séquence et ça tombe bien parce que la liste est une séquence. 

### 1er méthode WHILE

Donc première méthode possible, on va faire une petite variable de compteur, i = 0, et on va dire ensuite while i < que la taille et pour ça on va utiliser une fonction qui s'appelle len(), la taille de notre liste, d'accord. Et alors tu affiche inventaire de i donc c'est à dire l'élément numéro i entre crochet.
```py
    #coding:utf-8

    #Création d'une liste
    inventaire = range(20)
    i = 0

    while i < len(inventaire):
```
Donc ceux qui ont des tableaux en C par exemple savent que ça fonctionne comme ça pour afficher un indice, et bien évidemment, on incrémente le i.
```py
#coding:utf-8

#Création d'une liste
inventaire = range(20)
i = 0

while i < len(inventaire):
   print(inventaire[i])
   i += 1
```
```powershell
    >python main.py
    0
    1
    2
    3
    4
    5
    6
    7
    8
    9
    10
    11
    12
    13
    14
    15
    16
    17
    18
    19
```
Et là regardez, ça vous met bien tous les éléments donc là on arrive mieux à se rendre compte ce qu'on a fait avec range() donc il affiche bien 0 à 19 c'est-à-dire 20 éléments, le premier 0, le dernier 19. 

Alors ça c'est pas forcément ce qu'il y a de plus pratique pour les listes. 
```py
    while i < len(inventaire):
        print(inventaire[i])
        i += 1
```
Alors ce n'est pas ce qu'on fait le plus, en général on fait une boucle for qui va permettre de faire un parcours. 

### 2ème méthode FOR

On lui dit for et on va mettre par exemple "valeur in inventaire", pour chaque valeur de la liste inventaire donc là séquence inventaire, tu affiche la valeur et vous allez voir que c'est exactement la même chose au niveau de l'affichage. 
```py
#coding:utf-8

#Création d'une liste
inventaire = range(20)
i = 0

for valeur in inventaire:
   print(valeur)
```
```powershell
    >python main.py
    0
    1
    2 
    3
    4
    5
    6
    7
    8
    9
    10
    11
    12
    13
    14
    15
    16
    17
    18
    19
```
C'est exactement la même chose au niveau de l'affichage meilleur beaucoup plus rapide c'est bien, qu'est-ce que ça veut dire ? voilà ça veut dire qu'il va prendre le premier élément de notre séquence donc l'inventaire et il va le stocker dans la variable valeur et du coup vous voyez quand je l'affiche. 

Ensuite il incrémente, c'est comme un curseur qui se déplace, il va se déplacer au 2e élément, il va stocker le 2e élément dans valeur et on pourra l'afficher et ainsi de suite. 

Voyez comme ça, on peut directement parcourir toute une liste très facilement donc ça c'est une possibilité. Voilà c'est à savoir, c'est une manière comme ça de parcourir un petit peu notre liste. 

On a une autre manière de le faire et ça, ça peut être utile quand on a besoin d'avoir l'indice car par exemple ici le 0, il est à l'indice 0 de notre liste pour le premier élément. Le 2e élément est l'indice un parce qu'on commence tout à 0.

On va refaire une liste un peu différente parce que si ça mélange plein de nombres, voilà ça va pas forcément être le plus clair pour vous. On va mettre un inventaire comme ceci.
```py
#coding:utf-8

#Création d'une liste
inventaire = ["Arc", "épée", "bouclier"]

for valeur in inventaire:
   print(valeur)
```
```powershell
    >python main.py
    Arc
    épée
    bouclier
```
À partir de l'élément d'indice 0 parce qu'une liste commence toujours à l'élément 0, on a "Arc".  L'élément d'indice 1 donc le 2e élément de la liste, c'est "épée" et l'éléments d'indice 2 donc le 3e, c'est "bouclier", voilà. 

Il faut savoir que l'indice c'est toujours le énième moins un élément d'accord. 

Par exemple, on a "Arc", il a l'indice 0 mais c'est le premier élément. On a ensuite "épée", c'est l'indice 1 mais en fait c'est déjà le 2e élément, d'accord on décale en fait à chaque fois par rapport à l'indice, l'élément c'est le énième plus 1 par rapport à son indice donc comme "Arc" commence à 0, c'est le premier élément et cetera.

Voilà, donc ça on verra un petit peu après mais moi je voulais déjà vous montrer ici au niveau de la création. 

Donc retenez bien qu'on peut créer en faisant une liste, list(), on peut créer en mettant des crochets vides, on peut créer avec des éléments déjà dedans et si on veut avoir la même chose plusieurs fois, on fait comme tout à l'heure lorsqu'on a mis le 0 multiplier par 5 et on peut aussi utiliser cette petite fonction range() qui permet carrément d'avoir une liste de valeurs, donc ça c'est pratique. Si par exemple on veut mettre 100 nombres à la suite, en fait range() de 100 et ça va nous mettre 0 à 99 dans une liste. Ça va très vite du coup, pas besoin de faire ça à la main avec une boucle, c'est bien pratique. 

## 03 - Accéder à un élément de notre liste

Voilà voilà pour tout ce qui est création donc on vient de voir les accès rapidement avec un parcours quoi mais comment est-ce que je peux accéder à un certain élément en particulier ? 

Eh bien vous avez plusieurs méthodes, je vais vous montrer plein de choses donc là c'est le moment aussi de prendre des notes parce qu'il va y avoir plusieurs possibilités pour accéder à un élément. 

Donc je vous avais parler qu'ils avaient chacun un indice donc si vous mettez entre crochets l'indice de l'élément, par exemple ici, inventaire[1]. On va afficher l'élément d'indice 1 donc le 2e c'est-à-dire ici l'épée. Ca c'est un moyen très simple d'y accéder.

Si vous mettez les : comme j'avais fait tout à l'heure, c'est pour afficher absolument tout après ça vous affiche carrément une liste avec des crochets et cetera donc c'est pas forcément un parcours. Ici on ne fait pas un parcours, on dit simplement d'afficher la totalité des éléments, c'est pas pareil.
```py
#coding:utf-8

#Création d'une liste
inventaire = ["Arc", "épée", "bouclier"]

print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'épée', 'bouclier']
```
Un parcours c'est-à-dire qu'on va parcourir chaque élément un par un et ici on affiche tout d'un coup.

Donc avec les deux points vous afficher tout.

### Afficher les deux premiers élément de la liste

En mettant un indice à l'intérieur par exemple 1, 2, 3 et cetera, c'est pour dire quel indice vous affichez, quel élément de quel indice.

On a aussi d'autres petites manipulations très sympas notamment en utilisant des points, si je fais par exemple : je vous mets deux-points comme ceci d'accord et je mets 2.
```py
#coding:utf-8

#Création d'une liste
inventaire = ["Arc", "épée", "bouclier"]

print(inventaire[:2])
```
Je dis d'afficher les 2 premiers éléments de la liste, c'est pour ça qu'on met les deux points avant.

Les deux points avant permet de savoir que c'est les premiers. Je vous montre à l'affichage.
```powershell
    >python main.py
    ['Arc', 'épée']
```
Voyez, il affiche arc et épée mais il n'affichera pas bouclier en revanche si les 2 point, je les mets à la fin … c'est ça que j'ai dit que ça allait aller un petit peu vite à ce moment-là de la vidéo … 

### Afficher en retirant les deux premiers élément de la liste

On va demander d'afficher les 2 dernier, d'accord.
```py
#coding:utf-8

#Création d'une liste
inventaire = ["Arc", "épée", "bouclier"]

print(inventaire[2:])
```
```powershell
>python main.py
['bouclier']
```
Mais là ici alors pourquoi il m'affiche bouclier vraiment m'affiche les autres pour le dernier élément. Il m'affiche le dernier élément ici.

On va rajouter plus de choses parce que ma liste n'est pas forcément très grandes.
```py
#coding:utf-8

#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]

print(inventaire[3:])
```
```powershell
    >python main.py
    ['potion', 'flèches', 'tunique']
```
Voilà c'est parce que je n'avais pas forcément une liste assez grande.

Donc là il m'affiche les 3 derniers éléments d'accord "potion", "flèche" et la "tunique" OK.

On peut aussi choisir certains éléments partant du début parce ce que vous avez vu, quand je fais ça par exemple [3], je lui dit d'afficher celui qui a un indice 3 mais en partant du début, en partant de 0 c'est-à-dire à 0, 1, 2, 3 (il faut que j'enregistre mon fichier avec contrôle+S).
```py
#coding:utf-8

#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]

print(inventaire[3])
```
```powershell
    >python main.py
    potion
```
Donc il affiche la potion.

### Afficher l élément d indice en partant de la fin

Je peux partir à l'envers, si je mets [-3], ça veut dire que tu m'affiche l'élément d'indice 3 mais en partant de la fin, d'accord, donc là c'est l'inverse.
```py
#coding:utf-8

#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]

print(inventaire[-3])
```
```powershell
    >python main.py
    potion
```
Il affiche du coup potion parce que ça fait du coup le premier élément "tunique", le 2e "flèches" et le 3e "potion" en partant de la fin, d'accord, donc ça c'est important de savoir en fait. C'est au niveau de la position, si vous partez du début ou de la fin donc vous mettez un moins ou vous n'en mettez pas selon où vous voulez partir donc c'est bien à savoir.

Donc par exemple si je veux afficher le dernier élément, qu'est-ce qu'on va faire ? hé bien on va mettre moins 1.

-1, ça veut dire t'affiche le premier élément en partant de la fin donc forcément le dernier ça paraît logique voilà.
```py
#coding:utf-8

#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]

print(inventaire[-1])
```
```powershell
    >python main.py
    tunique
```

### Afficher l élément qui a un indice 1

Donc ça peut être un moyen simple par contre attention si vous mettez 1 tout court, ça ne veut pas dire d'afficher le premier élément en partant du début, ça veut dire d'afficher celui d'indice 1 et là voyez, ce n'est plus le-même, c'est "épée" et non "arc".
```py
#coding:utf-8

#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]

print(inventaire[1])
```
```powershell
    >python main.py
    épée
```
Pour afficher arc il faudra évidemment commencer par 0, ça c'est la petite distinction d'accord, à ne pas vous tromper. Si vous étiez en nombre positif, on compte l'indice. Si c'est un nombre avec un moins devant, c'est pour dire le énième élément en partant de la fin.

Par exemple moins 0 d'ailleurs vous allez voir qu'il n'y en a pas, il n'y a pas de 0 ième et cetera d'accord ça va tout ça tout simplement vous afficher "arc" mais ça fera absolument aucune distinction. Il ne va même pas faire la différence.
```py
#coding:utf-8

#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]

print(inventaire[-0])
```
```powershell
    >python main.py
    Arc
```  
Et on peut afficher le 4e en partant de la fin.

Voilà 4e c'est bien 1, 2, 3, 4 donc bouclier est bien le 4e élément de la liste en partant de la fin donc ça c'est plusieurs méthodes d'accès, d'accord, si je devais vous les noter rapidement.

je vais vous les noter quand même celles-là, vous avez :
```py
    """
    liste[X] = Affiche élément d'indice X
    liste[-X] = Affiche Xième élément en partant de la fin
    
    liste[:] = affiche tous les éléments
    liste[:X] = Affiche les X premiers éléments
    liste[X:] = Affiche les X derniers éléments 
    """
```
Et voilà là on a fait grosso modo le tour de tout ce qu'il y a à connaître au niveau accès donc tout ça c'est pour ce qui est de l'accès, manipulation au niveau des listes, ça fonctionne pour l'affichage mais pas seulement, maintenant vous savez comment on accède à chacun des éléments de la liste.

Vous allez voir également qu'il y a d'autres choses possibles d'accord, on peut vraiment faire d'autres choses.

### Afficher les éléments compris entre deux bornes

Par exemple regardez, si je fais alors.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments 
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]

print(inventaire[2:4])
```
```powershell
    >python main.py
    ['bouclier', 'potion']
```

Vous voyez ici quand je mets  2, deux points, 4  donc il affiche l'élément d'indice 2 jusqu'à l'élément d'indice 4 donc c'est-à-dire 0 "Arc", 1  "épée", 2 "bouclier", 3 "potion" et il n'affichera évidemment pas le 4 "flèches" d'accord, c'est exclu donc il va afficher du 2 au 4 mais le dernier élément que vous avez-là est exclu donc ça je vais vous le noter parce que c'est pas forcément clair, on va mettre ici A, B ce sera plus simple.

    liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)

Donc ça, c'est fait pour prendre une fourchette de valeurs en fait d'accord, il prend une fourchette de 2 donc ici en réalité de l'indice 2 à l'indice 3 qui prend du coup que 2 éléments.

Si je fais 5, il va en prendre 3 OK.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]

print(inventaire[2:5])
```
```powershell
    >python main.py
    ['bouclier', 'potion', 'flèches']
```
Voilà si vous faites 5 moins 2 d'accord ici pour le retenir, si vous avez peur de ne pas le retenir.

Vous faites par exemple ici 5 moins 2 ça fait 3 donc vous savez que ceci va afficher 3 éléments d'accord, tout à l'heure on faisait 4 moins 2 donc ça faisait 2 donc on avait effectivement 2 éléments "bouclier" et "potion", c'est un moyen mémo-technique de le retrouver, vous faites B moins A, vous serez comme ça combien d'éléments ça va afficher parce qu'il y a toujours le dernier qui exclut. Voilà donc ça, c'est à connaître donc ça c'est plusieurs manipulations possibles d'accord donc retenez bien ces systèmes de notation avec en normal, avec le point tout seul, le point avant après, le point au milieu, c'est vraiment important ça permet d'accéder à plein d'éléments de la liste donc ça fait gagner énormément de temps.

## Modifier élément-s de notre liste

Alors maintenant que vous savez comment créer une liste, vous savez comment accéder à ces éléments de n'importe quelle manière du début de la fin, dans une fourchette, les premiers, les derniers et cetera.

On va voir nous comment on peut en modifier d'accord. Je rappelle que la liste, on travaille directement sur la liste elle-même donc on va vraiment modifier la vraie liste, comment on fait, et bien on fait de la même manière c'est-à-dire que si je fais.

On va faire un affichage normal, affichage après la création. On fera un affichage après la modification d'un élément.

### Affichage après la modification d un élement

On peut tout simplement faire inventaire[2], là il va me modifier le 3e élément "bouclier" par "bouclier d'acier" par exemple. Modification très simple.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]
print(inventaire[:])

inventaire[2] = "bouclier d'acier"
print(inventaire[:])
```
Voilà affichage après la création, on fera l'affichage après modification.
```py
    >python main.py
    ['Arc', 'épée', 'bouclier', 'potion', 'flèches', 'tunique']
    ['Arc', 'épée', "bouclier d'acier", 'potion', 'flèches', 'tunique']
```
Je vais supprimer des éléments pour que vous ayez un affichage un peu plus correct.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion"]
print(inventaire[:])

inventaire[2] = "bouclier d'acier"
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'épée', 'bouclier', 'potion']
    ['Arc', 'épée', "bouclier d'acier", 'potion']
```
Voilà donc il a bien changé l'éléments d'indice 2 d'accord, tout simplement.

Alors ça si vous faites du langage C notamment, du C++ et cetera, vous connaissez cette notation de tableau, inventaire[2].

Sauf que là, on travaille sur une liste, ce n'est pas un tableau, c'est vraiment une liste.

### Modification multiple d un élément

On peut faire tout ce qu'on a vu ici, d'accord. Vous pouvez sans problème dire bah voilà, regardez je met deux points, alors là c'est un peu bizarre d'accord.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion"]
print(inventaire[:])

inventaire[:] = "bouclier d'acier"
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'épée', 'bouclier', 'potion']
    ['b', 'o', 'u', 'c', 'l', 'i', 'e', 'r', ' ', 'd', "'", 'a', 'c', 'i', 'e', 'r']
```
D'accord, on a modifié ça, inventaire[:] = "bouclier d'acier".

Ici il nous met quelque chose de bizarre parce qu'il nous met chaque élément ici, de "bouclier d'acier".

Alors vous allez me dire pourquoi il fait ça, puisque normalement vous devriez ici, inclure le nombre de fois où vous modifier l'élément. Je vais vous montrer pourquoi.

Si je mets juste ça, regardez ce qu'il se passe.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion"]
print(inventaire[:])

inventaire[:2] = "bouclier d'acier"
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'épée', 'bouclier', 'potion']
    ['b', 'o', 'u', 'c', 'l', 'i', 'e', 'r', ' ', 'd', "'", 'a', 'c', 'i', 'e', 'r', 'bouclier', 'potion']
```
Donc là il a fait des modifications bizarres, vous n'avez pas du tout ce que vous vouliez.

Ça veut dire qu'il faut le préciser 2 fois.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion"]
print(inventaire[:])

inventaire[:2] = ["bouclier d'acier", "bouclier d'acier"]
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'épée', 'bouclier', 'potion']
    ["bouclier d'acier", "bouclier d'acier", 'bouclier', 'potion']
```

Et là effectivement, il a bien modifié "bouclier d'acier", "bouclier d'acier". Comme vous demandez à modifier les 2 premiers, vous êtes obligé ici après l'affectation d'indiquer les 2 premiers, d'accord.

## Modification multiple avec calcul sur les valeurs d affectation

Alors là comme c'est la même valeur, on peut faire ce qu'on a fait tout à l'heure avec le calcul à la création. Vous savez quand on avait fait ceci, inventaire = ["Arc"] * 5, pour dire tu crée une liste qui contient 5 fois l'élément "Arc" et bien c'est la même chose. Les calculs comme ça on peut les faire directement à n'importe quel type d'affectation donc là je fais ça et je fais fois 2.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion"]
print(inventaire[:])

inventaire[:2] = ["bouclier d'acier"] * 2
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'épée', 'bouclier', 'potion']
    ["bouclier d'acier", "bouclier d'acier", 'bouclier', 'potion']
```

On obtient exactement le même résultat voilà.

### Modification de tous les éléments de la liste

Donc si je fais ça [:] (au lieu de [:2]), eh bien on devrait dire, fois le nombre d'éléments qu'il y a dans la liste donc là, il y en a 4 donc on devrait faire fois 4.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion"]
print(inventaire[:])

inventaire[:] = ["bouclier d'acier"] * 4
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'épée', 'bouclier', 'potion']
    ["bouclier d'acier", "bouclier d'acier", "bouclier d'acier", "bouclier d'acier"]
```
Et là, on a modifié tous les éléments de la liste par bouclier d'acier.

Voir carrément faire `len(inventaire)` qui est la fonction qui calcule la taille.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion"]
print(inventaire[:])

inventaire[:] = ["bouclier d'acier"] * 4
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'épée', 'bouclier', 'potion']
    ["bouclier d'acier", "bouclier d'acier", "bouclier d'acier", "bouclier d'acier"]
```

Avec la fonction qui calcul la taille, ça fonctionne aussi, voilà puisque c'est du calcul donc ça me paraît tout à fait évident donc vous voyez avec cette fonction qui donne la taille de la liste, on peut du coup faire pareil donc ça va retourner 4 donc ça va bien faire le calcul comme il faut, voilà.

Donc ça c'est bien à savoir, d'accord, qu'on peut vraiment modifier comme ça n'importe quel élément soit juste avec un seul indice ou soit on peut en modifier plusieurs.

### Modification d éléments entre deux bornes

On peut également dire tu modifie de l'élément en 2e d'indice 2 jusqu'à l'élément d'indice 3 en faisant comme ça, inventaire[2:4] = ["bouclier d'acier"].

Et pareil, là 4 moins 2, ça fait 2 donc ça veut dire qu'il va y avoir 2 éléments à modifier comme je l'ai expliqué tout à l'heure donc on fait fois 2 et voilà, inventaire[2:4] = ["bouclier d'acier"] * 2.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion"]
print(inventaire[:])

inventaire[2:4] = ["bouclier d'acier"] * 2
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'épée', 'bouclier', 'potion']
    ['Arc', 'épée', "bouclier d'acier", "bouclier d'acier"]
```

Et voilà, les 2 derniers éléments ont bien été modifié, l'élément d'indice 2 et l'élément d'indice 3, pas de souci.

Voilà ça c'est pour l'accès d'accord et notamment la modification alors ça peut paraître un peu complexe comme notation mais vous aurez quand même assez rarement à utiliser ce genre de notation. Celle que vous allez avoir le plus besoin de faire c'est voilà modifier l'éléments par exemple d'indice 4, qu'est-ce que je mets à la place, d'accord ?
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion"]
print(inventaire[:])

inventaire[2] = "manteau"
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'épée', 'bouclier', 'potion']
    ['Arc', 'épée', 'manteau', 'potion']
```

Donc ça c'est quelque chose que vous aurez l'habitude de faire assez souvent au niveau des listes pour le reste je voulais vous montrer parce que c'est bien que vous sachiez le faire et si un jour vous en avez besoin, vous saurez qu'il faut revoir cette vidéo comme ça, vous pourrez vous pouvez revérifier, réviser un petit peu les notations que je vous ai appris.

Tout ça c'est pour l'accès … il y a beaucoup de choses dans cette vidéo, elle sera vraiment un peu plus longue que les autres vidéos parce que je veux vraiment tout vous montrer, vous montrer un maximum de choses pour que vous soyez tranquille avec les listes pour la suite.

## 05 - Faire une recherche de notre liste

On peut maintenant … donc maintenant que vous savez faire un petit peu toutes ces modifications sans problème, on va pouvoir faire des petites choses également … vous avez vu qu'on avait fait du parcours, on a fait de l'affichage mais on pourrait faire des petites recherches dans la liste. Ça ne va pas utiliser de fonction de méthode ou autre, c'est simplement une syntaxe et on l'avait vu un petit peu avant aussi.

Par exemple donc j'ai ma petite liste ici, d'accord.
```py
    inventaire = ["Arc", "épée", "bouclier", "potion"]
```

### Rechercher une chaine

Je veux vérifier par exemple que ma liste … il y a un élément bouclier. Je peux tout simplement faire ceci. if "bouclier" est dans (in) inventaire et s'il y est, je peux dire que je possède un bouclier sinon je n'en ai pas.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion"]

if "bouclier" in inventaire:
   print("Je possède un bouclier.")
else:
   print("Je n'ai pas de bouclier")
```
```powershell
    >python main.py
    Je possède un bouclier.
```
Donc ça c'est tout à fait possible donc ne cherchez pas une méthode d'accord ou une fonction ou je ne sais quoi pour faire de la recherche, dans une liste, d'un élément … vous le  faites de cette manière, d'accord, vous faites un IF simplement de la valeur, est-ce qu'elle existe cette valeur-là ? est-ce que ça existe dans l'inventaire ? 

Si par exemple, on avait comme ça un entier.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "épée", "bouclier", "potion", 16]

if "bouclier" in inventaire:
   print("Je possède un bouclier.")
else:
   print("Je n'ai pas de bouclier")
```
```powershell
    >python main.py
    Je possède un bouclier.
```

Donc ça va fonctionner évidemment.

On peut faire comme ça de la recherche très simplement dans les listes.

Voilà donc ça c'est tout ce que je voulais vous montrer au niveau syntaxe, manipulation, au niveau de tout ça, de tout ce qu'on pouvait faire sur les listes.

## 06 - Ajouter élément-s

Maintenant comme vous savez que la liste est une classe de python, on a évidemment des méthodes et on verra également des fonctions c'est-à-dire qui ne sont pas forcément liés à la classe list mais qui peuvent servir sur des listes donc je vais vous les montrer également.

On va passer un petit peu à ces méthodes et notamment à une première qui peut être intéressante qui va permettre d'ajouter des éléments d'accord. Moi je vais faire par exemple une liste au début vide alors allons-y. On va l'afficher comme ceci.
```py
    #Création d'une liste
    inventaire = []
    print(inventaire[:])
```
On ne va pas s'embêter à faire un parcours pour l'afficher d'accord, je vais afficher tout bêtement comme ça, ce sera plus formaté comme affichage, ça prendra moins de place.

Et on va simplement faire un inventaire et on va utiliser la méthode sur l'objet append() et du coup on peut ajouter le fameux éléments qui nous manque, voilà, inventaire.append("Arc").
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = []
print(inventaire[:])

inventaire.append("Arc")
print(inventaire[:])
```
```powershell
    >python main.py
    []
    ['Arc']
```
On test et vous voyez qu'il est venu s'ajouter.

### Ajouter plusieurs éléments

On peut également hop.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = []
print(inventaire[:])

inventaire.append("Arc").append("Bouclier")
print(inventaire[:])
```
Ceci ne fonctionnera pas, d'accord.
```powershell
    >python main.py
    []
    Traceback (most recent call last):
      File "main.py", line 929, in <module>
        inventaire.append("Arc").append("Bouclier")
    AttributeError: 'NoneType' object has no attribute 'append'
```
Mais vous verrez que certaines méthodes pourront comme ça se faire à la suite, pourquoi ?puisque ici on va travailler directement alors là … voilà il cherche un attribut append qu'il n'y a pas évidemment mais dans certaines méthodes, vous verrez qu'on pourra comme ça en faire à la suite, plusieurs méthodes, puisque le résultat va renvoyer en fait l'objet lui-même et on pourra du coup utiliser une méthode par la suite.

Donc ici le append(), vous n'en faites qu'un seul, d'accord. Vous faites qu'un seul append(). Si vous voulez rajouter un objet bah vous le refaites une autrefois … je voulais vous montrer parce que dans certains langages, on peut comme ça cumuler les méthodes à la suite d'une autre méthode mais ça ne fonctionne pas dans tous les cas et là on ajoute bien tous les objets en fin de liste, d'accord.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = []
print(inventaire[:])

inventaire.append("Arc")
print(inventaire[:])

inventaire.append("Bouclier")
print(inventaire[:])
```
```powershell
    >python main.py
    []
    ['Arc']
    ['Arc', 'Bouclier']
```
append() s'ajoute bien en fin de liste donc ça ne va pas chercher à trier les éléments, ça les mets à la fin.

On peut également … là ça peut être utile, je vais déjà repartir d'accord sur quelque chose comme ça.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "Bouclier", "Manteau de cuir"]
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'Bouclier', 'Manteau de cuir']
```
Ce genre de chose voilà donc on affiche la liste. On va reprendre une liste de base … j'essaie de ne pas aller trop vite parce que il y a beaucoup d'éléments mais je ne veux pas non plus aller trop trop vite sur les explications pour que ce soit bien clair pour vous.

## Insérer un élément où l on veux

Donc on a une liste comme ça, moi je veux par exemple pouvoir insérer un objet en indice 1 c'est-à-dire à la place de bouclier et vous allez voir ce qui va se passer quand je vais le faire.

Je vais tout simplement faire un inventaire.insert() à l'indice 2 et je vais insérer potion de mana par exemple voilà je prend toujours des exemples comme ça on reste sur du RPG et ensuite print(inventaire[:]), on va l'afficher complétement [:] et vous allez voir la différence voilà.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "Bouclier", "Manteau de cuir"]
print(inventaire[:])

inventaire.insert(1, "Potion de mana")
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'Bouclier', 'Manteau de cuir']
    ['Arc', 'Potion de mana', 'Bouclier', 'Manteau de cuir']
```
Je mets 1 parce que moi je veux modifier le 2e élément voilà donc là vous voyez il a mis Potion de mana au premier indice d'accord l'indice 1 donc le 2e élément et automatiquement bah comme il a pris la place du bouclier, Bouclier s'est décalé d'un indice sur la droite et Manteau pareil.

Manteau était d'indice 2 maintenant il est d'indice 3 d'accord.

Arc n'a pas bougé forcément et c'est Potion de mana qui a pris l'indice 1 et Bouclier du coup qui est devenu indice 2 donc ça permet vraiment d'insérer à un endroit particulier, d'accord.

Vous choisissez ici l'indice et on insère vraiment à l'endroit qu'on veut donc ça c'est à savoir, c'est vraiment important de pouvoir comme ça insérer, ajouter en tout cas des éléments à votre liste soit en fin, soit vraiment à un endroit que vous voulez, d'accord, donc par rapport à un indice en particulier.

Maintenant que vous savez ajouter des éléments, on peut voir … ça me paraît logique … comment les supprimer.

## 07 - Retirer un élément

### 1er méthode de suppression

Pour supprimer des éléments, vous avez soit une méthode, d'accord c'est-à-dire qu'on va faire tout simplement un inventaire.remove(), c'est une méthode des listes, d'accord, et elle a besoin en paramètres de l'élément que vous voulez supprimer, moi par exemple, je veux retirer le Bouclier.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "Bouclier", "Manteau de cuir"]
print(inventaire[:])

inventaire.remove("Bouclier")
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'Bouclier', 'Manteau de cuir']
    ['Arc', 'Manteau de cuir']
```
Vous voyez je ne mets pas d'indice ou autre, je mets vraiment la valeur dans la liste et là il aura supprimer le Bouclier, d'accord, directement grâce à cette méthode remove().

### 2ème méthode de suppression

Je peux sinon j'ai vraiment besoin d'accéder à l'indice, je vais utiliser une instruction que vous avez déjà vu qui est l'instruction del, c'est pas une fonction, c'est pas une méthode de la classe list, c'est vraiment une petite instruction que vous pouvez utiliser directement en Python, voyez d'ailleurs que c'est un mot réservé (coloration syntaxique) et vous mettez inventaire[] avec l'indice que vous voulez donc si je veux supprimer le Bouclier bah c'est l'indice 1 donc je peux faire exactement la même chose, d'accord.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "Bouclier", "Manteau de cuir"]
print(inventaire[:])

del inventaire[1]
print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'Bouclier', 'Manteau de cuir']
    ['Arc', 'Manteau de cuir']
```
Ça fait la même chose d'une manière ou d'une autre, soit on travaille avec la méthode de liste, soit au travail avec l'instruction del et on aura bien la suppression qui va se faire voilà.

Donc ça c'est important de savoir, on a fait tout à l'heure de la recherche d'accord. On avait fait des petites méthodes, des petites recherches avec le IN.

## 08 - Retourner un indice et supprimer l élément

On peut également chercher par contre, retourner l'indice d'un élément d'une liste c'est-à-dire que je peux faire … print() de "Indice : " et ensuite je vais afficher inventaire.index() c'est-à-dire que je veux qu'il me retourne l'index() en fait de l'objet Bouclier donc si vous en avez plusieurs dans la liste, il va le retourner évidemment la première fois qu'il le rencontre.

Et là si je test, il nous met l'indice c'est 1 parce qu'effectivement l'indice de bouclier c'est 1.

A quoi ça peut servir de faire ce genre de chose ? bah quand vous ne pouvez pas connaître l'indice d'un objet, vous pouvez très bien faire objet_a_supprimer et vous faites ça.
```py
    objet_a_supprimer = inventaire.index("Bouclier")
```
Vous demandé de chercher l'index du bouclier et ensuite du coup vous n'avez plus qu'a faire 
```py
    del inventaire[objet_a_supprimer]
```
ça va du coup marcher d'accord.

```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "Bouclier", "Manteau de cuir"]
print(inventaire[:])

objet_a_supprimer = inventaire.index("Bouclier")
del inventaire[objet_a_supprimer]

print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'Bouclier', 'Manteau de cuir']
    ['Arc', 'Manteau de cuir']
```
Donc très pratique parce que voilà on ne sait pas forcément toujours à l'avance l'index d'accord ou en tout cas l'indice que l'on veut donc là on peut faire une recherche sur l'indice par rapport à l'objet quand on sait le nom de l'objet. On peut retrouver son indice et du coup à partir de l'indice, on peut le supprimer après si vraiment de toute manière on a son nom, vous savez qu'avec le remove on peut aller plus vite.

Remove(), on fait juste inventaire.remove("Bouclier") et là justement on supprime donc c'est beaucoup plus rapide cette méthode là, ça c'est sûr.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Arc", "Bouclier", "Manteau de cuir"]
print(inventaire[:])

inventaire.remove("Bouclier")

print(inventaire[:])
```
```powershell
    >python main.py
    ['Arc', 'Bouclier', 'Manteau de cuir']
    ['Arc', 'Manteau de cuir']
```
C'est l'avantage comme ça de python, c'est qu'on peut supprimer un élément directement en ayant sa valeur mais c'est bien de savoir aussi la méthode index qui peut je pense être très intéressante et très utile dans ce genre de cas.

Qu'est-ce que je peux vous montrer d'autres également parce ce que je voulais vous montrer pas mal de choses sur ces listes. Il ne reste plus grand chose que je voulais vous montrer mais quand même.

Par exemple quand vous avez … On va ajouter des objets ici.
```py
    inventaire = ["Potion de mana", "Arc", "Bouclier", "Manteau de cuir", "Arbalète"]
```
C'est un peu beaucoup de chose bizarre mais ce n'est pas grave voilà.
```py
    inventaire = ["Potion de mana", "Arc", "Bouclier", "Manteau de cuir", "Arbalète"]
    print(inventaire[:])
```

## 09 - Trier une liste par ordre croissant

Je vais l'afficher par défaut et ici je vais trier en fait ma liste parce que oui vous vous doutez bien que il est déjà possible de trier une liste sans que vous ayez besoin de faire votre propre fonction.

Alors il ne faut pas l'utiliser directement dans le print(), vous faites simplement inventaire.sort() de manière basique et il faut évidemment, ça me paraît logique aussi, que les éléments de votre liste soit du même type c'est-à-dire que si vous essayer de trier des patates avec des nombres, ça ne va pas marcher évidemment donc là j'ai que des chaînes de caractères donc il va pouvoir les trier par ordre alphabétique.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["Potion de mana", "Arc", "Bouclier", "Manteau de cuir", "Arbalète"]
print(inventaire[:])

inventaire.sort()
print(inventaire[:])
```
```powershell
    >python main.py
    ['Potion de mana', 'Arc', 'Bouclier', 'Manteau de cuir', 'Arbalète']
    ['Arbalète', 'Arc', 'Bouclier', 'Manteau de cuir', 'Potion de mana']
```
Donc à priori si les choses sont bien faites, voilà vous voyez qu'il a mis arbalète au début, Arc, Bouclier, Manteau et la Potion est en fin puisque c'est un P donc ça vient après le M.

On peut faire ça évidemment je pense que c'est ça paraît logique avec des nombres d'accord. voilà j'en mets plusieurs et ça va être exactement la même chose.
```py
##coding:utf-8
#"""
#liste[X] = Affiche élément d'indice X
#liste[-X] = Affiche Xième élément en partant de la fin
#
#liste[:] = affiche tous les éléments
#liste[:X] = Affiche les X premiers éléments
#liste[X:] = Affiche les X derniers éléments
#
#liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
#"""
##Création d'une liste
#inventaire = [5, 128, -7, 3, 124, 7, 178, 2, -8]
#print(inventaire[:])
#
#inventaire.sort()
#print(inventaire[:])
```
```powershell
    >python main.py
    [5, 128, -7, 3, 124, 7, 178, 2, -8]
    [-8, -7, 2, 3, 5, 7, 124, 128, 178]
```
Ah oui c'est bon voilà donc au début ils sont dans le désordre et on fait un petit sort() sur la liste et il va nous les trier par ordre croissant OK.

## 10 - Inverser les valeurs d une liste

On peut également faire une inversion de valeurs c'est-à-dire qu'on peut tout mettre à l'envers en fait les éléments d'une liste donc là je peux faire reverse() c'est un autre une autre méthode qui va tout intervertir c'est-à-dire que le moins 8, il va finir en premier ensuite ça va être 2, 178, 124, 3, moins 7, 128 et on va finir avec le 5 donc on inverse toutes les valeurs en fait.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = [5, 128, -7, 3, 124, 7, 178, 2, -8]
print(inventaire[:])

inventaire.reverse()
print(inventaire[:])
```
```powershell
    >python main.py
    [5, 128, -7, 3, 124, 7, 178, 2, -8]
    [-8, 2, 178, 7, 124, 3, -7, 128, 5]
```
Donc on n'inverse toutes les valeurs en fait voilà avec reverse() donc rien ne vous empêche si vous voulez par exemple avoir une liste en décroissant de faire un tri normal et ensuite pourquoi pas utiliser le reverse() dessus d'accord même si on peut faire directement en décroissant, ça serait plus rapide mais c'est une possibilité.

Vous pouvez faire en sort(), ensuite faire un reverse() comme ça vous avez une liste triée de manière croissante et ensuite qui est inversé donc qui devient décroissante, c'est une possibilité.

Voilà pour ces méthodes pour faire un peu de tri.

## 11 - Compter le nombre d éléments d une liste

On a également une autre méthode par rapport à l'index, vous pouvez par exemple, je fait cette liste.

inventaire = ["potion", "arc", "potion", "potion", "manteau"]

Moi je voudrais sur cette liste pouvoir compter le nombre de potions que j'ai tout simplement fait dans mon inventaire donc je vais faire simplement, print("Nombre de potions :", inventaire.count("potion"))

```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["potion", "arc", "potion", "potion", "manteau"]
print(inventaire[:])

print("Nombre de potions :", inventaire.count("potion"))
```
```powershell
    >python main.py
    ['potion', 'arc', 'potion', 'potion', 'manteau']
    Nombre de potions : 3
```

Voilà donc ça nous met 3 tout simplement, ça à compter le nombre d'occurrences d'accord de ce terme là, "potion", donc très pratique aussi, ça permet de vérifier les choses le plus simplement du monde.

## 14 - Demander de l aide pour les méthodes de list

Donc voyez beaucoup de méthodes, vraiment beaucoup beaucoup de méthode pour les listes très intéressant append(), insert(), on a remove(), on a index(), on a sort(), reverse(), count() et on en a plein d'autres aussi mais c'était quelque petites choses comme ça que je voulais vous montrer mais je pense qu'on en restera là au niveau des méthodes vraiment standard pour les listes. Il y en a d'autres encore une fois si vous voulez les voir, c'est comme pour tout, vous faites simplement, help(list).
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["potion", "arc", "potion", "potion", "manteau"]
print(inventaire[:])

help(list)
```
help(list) comme je vous l'ai montré pour les chaînes de caractères et vous aurez accès comme ça à la doc d'accord qui vous propose beaucoup d'attributs, de méthodes.

Vous voyez ici clear(), count et cetera. On trouve pas mal de chose.

On trouve pas mal de choses … bah tiens justement comme ça montre que clear()…

## 12 - Effacer tous les éléments de la liste

clear(), c'est pour effacer la liste c'est-à-dire que si vous faites un inventaire.clear() et ensuite vous l'affichez, ça permet d'effacer tous les éléments de la liste.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["potion", "arc", "potion", "potion", "manteau"]
print(inventaire[:])

inventaire.clear()
print(inventaire[:])
```
```powershell
    >python main.py
    ['potion', 'arc', 'potion', 'potion', 'manteau']
    []
```
Vous avez une autre manière de le faire aussi et je pense que vous savez pour certains, si vous avez vu un petit peu ça (liste[X], liste [-X], …) vous avez peut-être compris comment on peut le faire.

### Affecter une nouvelle liste vide

On peut accéder un petit peu aux éléments qu'on veut notamment ceci, liste[:], on peut accéder à tous les éléments de la liste c'est-à-dire la liste complète donc si on fait inventaire[:] avec les : et que je dis maintenant, je t'affecte ça, [].
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#Création d'une liste
inventaire = ["potion", "arc", "potion", "potion", "manteau"]
print(inventaire[:])

inventaire[:] = []
print(inventaire[:])
```
```powershell
    >python main.py
    ['potion', 'arc', 'potion', 'potion', 'manteau']
    []
```
Eh bien on en fait également une nouvelle ligne donc une liste vide voilà donc c'est exactement la même chose d'accord. Comme on travaille sur la liste elle-même, on a vidé la liste. C'est simplement qu'ils ont fait une méthode pour faire ça plus rapidement donc vous avez 2 possibilités pour effacer toute une liste soit de faire ça, soit d'utiliser la méthode clear(). Voilà c'est vraiment au choix c'est vous qui voyez.

## 15 - Passer d'une chaine à une liste

On peut terminer sur quelques autres petites manipulations parce que comme vous avez vu les chaînes de caractères précédemment, c'est utile de voir comment on peut travailler avec des listes aussi.

Vous avez vu un dans les chaînes de caractères dans la précédente vidéo, comment on pouvait par exemple couper une chaîne en plusieurs bouts et vous avez vu qu'on obtenait une liste. Je vous avais de toute façon qu'on verrait ça par la suite dans la prochaine vidéo.

Eh bien justement … je vais vous remontrer cet exemple qu'on avait fait c'est-à-dire qu'on avait fait ceci. On crée une chaîne et là je demande par exemple de couper au niveau des espaces, d'accord, et ensuite on fait print(chaine).
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
chaine = "Bonjour à tous"
chaine = chaine.split(" ")

print(chaine)
```
```powershell
    >python main.py
    ['Bonjour', 'à', 'tous']
```
Par contre, il va me l'afficher sous forme de liste forcément. Voilà et vous voyez qu'on avait directement une liste donc on avait l'élément à l'indice 0 c'était 'Bonjour', l'élément d'indice 1 c'était 'à', éléments d'indice 2 c'était 'tous' et bien on peut faire évidemment l'inverse d'accord. 

## 16 - Passer d une liste à une chaine

Vous pouvez passer d'une liste à une chaîne ça paraît un petit peu logique c'est-à-dire que quand vous avez votre liste d'objets, des objets ou autre chose d'ailleurs…
```py
    inventaire = []
```
Par esemple si je reprend l'exemple de tout à l'heure, on avait ça.
```py
    inventaire = ["Bonjour", "à", "tous"]
```
Pour revenir à la valeur de départ, il suffit de faire.
```py
    inventaire = ["Bonjour", "à", "tous"]
    
    inventaire.join()
```
Et là vous mettez ici quel élément va joindre l'inventaire donc moi je vais mettre des espaces tous simplement pour faire une phrase. Et on termine avec un print(inventaire).

Alors une fois que vous avez votre chaîne
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
inventaire = ["Bonjour", "à", "tous"]

inventaire.join(" ")
print(inventaire)
```
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 1411, in <module>
        inventaire.join(" ")
    AttributeError: 'list' object has no attribute 'join'
```
Ah oui, c'est l'inverse, je l'ai noter à l'envers.
Alors regardez, on va faire ça.
phrase ... une fois que vous avez votre liste, vous dites que dans votre chaîne, c'est tout ça en fait c'est-à-dire que le séparateur, c'est un espace.
```py
    phrase = " "
```
Et je joint, avant et après chaque espace, ma liste  donc inventaire.
```py
    phrase = " ".join(inventaire)
```
Donc inventaire ... je l'avais mis à l'envers.
Et là du coup je peux afficher ça, print(phrase).
Je ne sais pas pourquoi, j'avais confondu avec les deux.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
inventaire = ["Bonjour", "à", "tous"]
phrase = " ".join(inventaire)
print(phrase)
```
```powershell
    >python main.py
    Bonjour à tous
```
Si je met ça "_", vous allez avoir ça bien évidemment.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
inventaire = ["Bonjour", "à", "tous"]
phrase = "_".join(inventaire)
print(phrase)
```
```powershell
    >python main.py
    Bonjour_à_tous
```
Donc on met en fait la chaîne avec le séparateur que l'on veut, cette fois çi pour joindre, puis la méthode join() et on fait ça.

Donc join() est bien lié … d'accord vous voyez c'est une méthode des chaînes d'accord. C'est pas une méthode des listes mais simplement que comme on partait d'une liste, je voulais vous le réserver pour cette vidéo-là.

Donc join(), on le fais sur une chaîne et pas sur la liste sinon évidemment ça ne marcherait pas et elle prend en paramètre un conteneur donc ici notre liste justement ici l'inventaire, ça permet comme ça d'afficher les choses proprement.

Voilà si j'avais fait quelque chose comme ça.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
inventaire = [14, 8, 7]
phrase = " ".join(inventaire)
print(phrase)
```
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 1472, in <module>
        phrase = " ".join(inventaire)
    TypeError: sequence item 0: expected str instance, int found
```

Et oui il me le prend comme une chaîne, il ne va pas vouloir, voilà "sequence item 0" donc là, vous voyez par contre ici ça ne va pas fonctionner puisque il va chercher automatiquement lui à avoir une chaîne donc vous allez travailler véritablement sur une chaîne de caractères donc des choses qui sont du texte et pas forcément des nombres, d'accord.

Donc il vous dit par exemple qu'il a trouvé un integer, "int found" donc il faudrait que pour chaque élément en fait je fasse un cast en String enfin voilà pour que ce soit considéré comme une chaîne et là bon nous c'était pour montrer pour l'exemple, retenez simplement surtout ce qui a de plus important, vous pouvez partir de quelque chose comme ça ["Bonjour", "à", "tous"]

Vous pouvez partir de quelque chose comme ça, vous pouvez faire un join() et ça va directement fonctionner, ça permet de joindre comme ça différents éléments d'une liste dans une chaîne, voilà.

## Bonus - ON NE TRAVAILLE PAS SUR DES COPIES

Dernier petit bonus pour cette vidéo qui est important et qui serait … voilà pour éviter que vous fassiez des erreurs par la suite et que vous ne comprenez pas d'où ça vient euh surtout par rapport à ce que j'avais dit dès le début, je vous avais expliqué que la liste, on travaillait directement sur elle-même, pas comme une chaîne de caractères où on fait des copies et c'est quelque chose qui peut induire en erreur dans cette possibilité-là, je vais vous montrer.

Par exemple si vous faites liste1 où j'ai ce genre de choses.
```py
    Liste1 = ["Arc", "Bouclier", "Tunique"]
```
On reprend toujours nos éléments okay et je me dis que je fais une liste2 et j'aimerais que ce soit une copie donc on serait tenté de faire ça, d'accord.
```py
    Liste1 = ["Arc", "Bouclier", "Tunique"]
    Liste2 = liste1
```
Pour dire que la liste2, c'est en fait … on lui affecte la liste1 d'accord.

Donc si je fais un print() de liste1. On va l'afficher de cette manière.
```py
    #coding:utf-8
    """
    liste[X] = Affiche élément d'indice X
    liste[-X] = Affiche Xième élément en partant de la fin

    liste[:] = affiche tous les éléments
    liste[:X] = Affiche les X premiers éléments
    liste[X:] = Affiche les X derniers éléments

    liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
    """
    liste1 = ["Arc", "Bouclier", "Tunique"]
    liste2 = liste1

    print("Liste 1", liste1[:])
    print("Liste 2", liste2[:])

    print("Liste 1", liste1[:])
    print("Liste 2", liste2[:])
```
Moi je vais faire ceci c'est-à-dire que la liste2, je vais lui ajouter un élément OK.
```py
    liste2.append("Potion de mana")
```
Je lui ajoute autre chose te normalement si on a fait les choses comme il faut la copie, on devrait avoir une liste2 plus grande que la liste1 c'est-à-dire que la liste2 devrait avoir ["Arc", "Bouclier", "Tunique"] et ensuite potion en plus.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
liste1 = ["Arc", "Bouclier", "Tunique"]
liste2 = liste1

print("Liste 1", liste1[:])
print("Liste 2", liste2[:])

liste2.append("Potion de mana")

print("Liste 1", liste1[:])
print("Liste 2", liste2[:])
```
```powershell
    >python main.py
    Bonjour_à_tous
    Liste 1 ['Arc', 'Bouclier', 'Tunique']
    Liste 2 ['Arc', 'Bouclier', 'Tunique']
    Liste 1 ['Arc', 'Bouclier', 'Tunique', 'Potion de mana']
    Liste 2 ['Arc', 'Bouclier', 'Tunique', 'Potion de mana']
```
Regardez si je teste le code ça va modifier les 2 listes tout simplement parce que je vous avais expliqué qu'on ne travaille pas sur des copies quand vous faites cette ligne là, cette affectation.
```py
    Liste2 = liste1
```

Vous dites simplement en fait que la liste2 ça va être une référence donc ce n'est pas une copie en fait c'est elle-même, elle va avoir un lien directement avec liste1 donc elle sera en fait un clone vraiment un clone de liste1.

Ce qui fait qu'en modifiant la liste2 ça va exactement modifier la liste1 de la même manière d'accord vous allez avoir une modification à l'identique comme si c'était 2 listes clonées, vraiment des clones mais qui sont ensemble d'accord, pas qui fonctionne de manière indépendante.

### Si on veut néanmoins créer une copie de liste

Alors si vraiment vous tenez à faire une copie de liste d'accord que c'est vraiment important pour vous par rapport à un programme, je vous propose une petite astuce, on va utiliser un module très particulier. Un module que je ne vous ai jamais présenté et là je vais vous en parler juste pour ça, c'est le module de copie donc vous faites un "import copy" c'est tout donc c'est très simple à l'appel d'accord.
```py
	import copy
```
Et ici au lieu de faire cette ligne-là, d'accord, liste2 = liste1 donc ne faites pas de copie d'accord ceci.
```py
	# Ne fais pas de copie -> liste2 = liste1
```
Vous allez tout simplement faire liste2, on appelle le module copy.
```py
	liste2 = copy
```
Et on utilise sa fonction deepcopy tout simplement.
```py
	liste2 = copy.deepcopy()
```
Donc c'est une fonction qui va permettre de faire une copie à l'identique d'un élément pour un autre et ils seront vraiment indépendants donc on va copier quoi ? la liste1 voilà.
```py
	liste2 = copy.deepcopy(liste1)
```
Et si je teste cette fois-ci par rapport à tout à l'heure.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
import copy

liste1 = ["Arc", "Bouclier", "Tunique"]
# Ne fais pas de copie -> liste2 = liste1
liste2 = copy.deepcopy(liste1)

print("Liste 1", liste1[:])
print("Liste 2", liste2[:])

liste2.append("Potion de mana")

print("Liste 1", liste1[:])
print("Liste 2", liste2[:])
```
```powershell
    >python main.py
    Bonjour_à_tous
    Liste 1 ['Arc', 'Bouclier', 'Tunique']
    Liste 2 ['Arc', 'Bouclier', 'Tunique']
    Liste 1 ['Arc', 'Bouclier', 'Tunique']
    Liste 2 ['Arc', 'Bouclier', 'Tunique', 'Potion de mana']
```

Quand j'ajoute un élément à la liste2 vous voyez qu'il n'a pas été ajouté à la liste1 donc cette fois-ci votre liste2 est bien autre chose que la liste1, elle n'ont plus rien avoir ensemble, et vous allez comme ça pouvoir travailler sur les 2 listes différemment voilà donc ça c'était la petite chose, le petit détail que je voulais ajouter pour cette vidéo-là.

## 17 - Concatener deux listes

Et comme on parlait de copie, on pourrait parler également ajouter une liste à une autre, comment on peut faire ce genre de choses ? notamment la concaténation, vous avez vu la concaténation dans les chaînes de caractères d'accord, on peut ajouter une chaîne à la suite d'une autre comme ça on peut les assembler. On peut faire pareil pour une liste, si j'ai par exemple liste2 qui va contenir notre fameuse…  ["Potion", "Parchemin"], je ne sais pas quoi et cetera bref.

    liste2 = ["Potion", "Parchemin"]

Vous pouvez sans problème assembler donc concaténer les 2 listes. Vous avez plusieurs manières … on va éviter d'utiliser le mot méthode comme ça n'importe comment … vous avez plusieurs manières, la première c'est d'utiliser la méthode extend().

Donc vous faites liste1 et vous dites je vais l'étendre d'accord, avec la liste2.

    liste1.extend(liste2)

Et là si je vous montre le résultat, voilà.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
import copy

liste1 = ["Arc", "Bouclier", "Tunique"]
liste2 = ["Potion", "Parchemin"]

print("Liste 1", liste1[:])

liste1.extend(liste2)

print("Liste 1", liste1[:])
```
```powershell
    >python main.py
    Bonjour_à_tous
    Liste 1 ['Arc', 'Bouclier', 'Tunique']
    Liste 1 ['Arc', 'Bouclier', 'Tunique', 'Potion', 'Parchemin']
```
Vous voyez qu'on ajouter à la liste tous les autres éléments d'ailleurs je suis pas obligé de mettre ça en fait print("Liste 1", liste1[:]) on s'en fiche, c'est pas tellement utile voilà.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
import copy

liste1 = ["Arc", "Bouclier", "Tunique"]
liste2 = ["Potion", "Parchemin"]

print(liste1[:])

liste1.extend(liste2)

print(liste1[:])
```
```powershell
    >python main.py
    Bonjour_à_tous
    ['Arc', 'Bouclier', 'Tunique']
    ['Arc', 'Bouclier', 'Tunique', 'Potion', 'Parchemin']
```

### La somme

Voilà ça c'est plus lisible pour vous donc là on a directement ajouter les éléments de la liste2, ça ça revient également, cette méthode, ça revient exactement à faire ceci.
```py
    liste1 = liste1 + liste2 
```
Donc oui comme pour les chaînes de caractères, on utilise l'opérateur + pour faire une concaténation c'est-à-dire de fusionner en fait deux listes.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#import copy

liste1 = ["Arc", "Bouclier", "Tunique"]
liste2 = ["Potion", "Parchemin"]

print(liste1[:])

liste1 = liste1 + liste2

print(liste1[:])
```
```powershell
    >python main.py
    Bonjour_à_tous
    ['Arc', 'Bouclier', 'Tunique']
    ['Arc', 'Bouclier', 'Tunique', 'Potion', 'Parchemin']
```
Je re-exécute le code, voyez qu'il y a aucun changement et ça vous savez quand vous voyez cette syntaxe-là, rappelez-vous la fameuse syntaxe donc A = A + B par exemple, on peut trouver son équivalent en faisant A += B, ça je ne vous apprends rien, c'est ce qu'on a vu sur les opérations donc vous pouvez sans problème faire liste1 += liste2.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#import copy

liste1 = ["Arc", "Bouclier", "Tunique"]
liste2 = ["Potion", "Parchemin"]

print(liste1[:])

liste1 += liste2
# A = A + B <=> A += B

print(liste1[:])
```
```powershell
    >python main.py
    Bonjour_à_tous
    ['Arc', 'Bouclier', 'Tunique']
    ['Arc', 'Bouclier', 'Tunique', 'Potion', 'Parchemin']
```
Et même chose, vous aurez bien ajouter chacun des éléments à la suite donc vous aurez fait une fusion des listes voilà et votre liste1 contiendra tout son ancien contenu plus le contenu de la liste numéro 2 par contre la liste numéro 2 n'aura pas bougé d'accord, si je vous fais un affichage vous avez bien compris que ça ne change absolument rien, elle ne disparaît pas parce qu'on l'a fusionné.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#import copy

liste1 = ["Arc", "Bouclier", "Tunique"]
liste2 = ["Potion", "Parchemin"]

print(liste1[:])
print(liste2[:])

liste1 += liste2
# A = A + B <=> A += B

print(liste1[:])
print(liste2[:])
```
```powershell
    >python main.py
    Bonjour_à_tous
    ['Arc', 'Bouclier', 'Tunique']
    ['Potion', 'Parchemin']
    ['Arc', 'Bouclier', 'Tunique', 'Potion', 'Parchemin']
    ['Potion', 'Parchemin']
```
Voilà, vous voyez que la liste2 d'accord c'est pas un souci.
Là effectivement on fait une copie en faisant ça quand on dit qu'on concatène la liste2, on concatène une copie d'accord.
Automatiquement si je fais liste2.append("Guètres")
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
#import copy

liste1 = ["Arc", "Bouclier", "Tunique"]
liste2 = ["Potion", "Parchemin"]

print(liste1[:])
print(liste2[:])

liste1 += liste2
# A = A + B <=> A += B
liste2.append("Guètres")

print(liste1[:])
print(liste2[:])
```
```powershell
    >python main.py
    ['Arc', 'Bouclier', 'Tunique']
    ['Potion', 'Parchemin']
    ['Arc', 'Bouclier', 'Tunique', 'Potion', 'Parchemin']
    ['Potion', 'Parchemin', 'Guètres']
```

Vous voyez que ça a été ajouté simplement à la liste2, la liste1 n'a pas été modifié donc on n'a vraiment pas de références ici, c'est deux listes différentes.

La liste 1 et 2 ici elles sont absolument distinctes l'une de l'autre même si à un moment donné on a ajouté tout le contenu de la liste2 à la liste1 puisque c'est simplement ça qu'on a dit c'est d'ajouter le contenu en fait, on n'a pas dit d'ajouter la liste, on a dit d'ajouter son contenu à la notre liste numéro 1, c'est ce qu'on vient de faire ici.
```py
	liste1 += liste2
```

## Conclusion

Et puis écoutez moi je crois qu'on a fait le tour un peu de tout ce que je voulais vous montrer.

Normalement je vous ai parlé … vous savez créer une liste de plusieurs manières d'ailleurs différentes, vous savez comment accéder à chacun de ces éléments que ce soit pour une lecture ou pour une modification, pour une suppression également puisque vous avez vu les méthodes d'ajout ou les méthodes de suppression, des méthodes de parcours, de recherche, des méthodes pour compter, pour trier, pour inverser les choses.

Bref vous avez pas mal de fonctions, pas mal de méthodes qu'on a vu ensemble et également des transformations de liste, de chaîne et inversement. Maintenant vous savez bien maîtrisées.

Donc ces 2 vidéos là, les vidéos sur les chaînes et la vidéo sur les listes vous aura permis d'en voir pas mal et on verra autre chose également puisque je vous ai pas montré par exemple comment parcourir, si vous voulez, la liste d'accord avec l'indice et la valeur donc on va terminer avec ça pour cette vidéo.

Tout à l'heure je vous ai montré quand on avait fait par exemple.
```py
	inventaire = ["Arc", "Epée", "Bouclier", "Potion"]
```
Ok, ce genre de chose, on avait fait simplement par exemple un for où pour chaque objet dans l'inventaire, tu affiches l'objet sur lequel tu as ton curseur et tu affiche chacun des éléments d'accord.
```py
	for objet in inventaire:
		print(objet)
```
Ça c'est du parcours tout simple au niveau de la liste, je vous avez dit que c'était mieux que le while parce ce que le while, on doit utiliser une variable i et que c'est pas forcément fait pour ça à la base donc très pratique.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
inventaire = ["Arc", "Epée", "Bouclier", "Potion"]

for objet in inventaire:
	print(objet)
```
```powershell
    >python main.py
    Arc
    Epée
    Bouclier
    Potion
```

### enumerate

Si on veut récupérer en même temps l'élément donc si je fais ceci. Je vais utiliser la fonction enumerate().
```py
    for objet in enumerate(inventaire):
        print(objet)
```
Vous allez voir déjà ce qu'il se passe, on va avoir un autre affichage, c'est pour faire la transition avec la suite.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
inventaire = ["Arc", "Epée", "Bouclier", "Potion"]

for objet in enumerate(inventaire):
   print(objet)
```
```powershell
    >python main.py
    (0, 'Arc')
    (1, 'Epée')
    (2, 'Bouclier')
    (3, 'Potion')
```
Vous voyez ça vous met une espèce de couple comme ça avec l'indice et la valeur et ça le met entre parenthèses.

Ce que vous voyez là, ça s'appelle un tuple d'accord.

C'est la prochaine chose que nous allons voir dans la suite de la formation après les listes donc ça fera comme ça la transition alors ici quel intérêt bah rien du tout parce qu'en plus vous ne savez pas ce qu'est un tuple. Vous allez le savoir pour la suite.

Par contre ça peut être utile au niveau de l'indice de le récupérer donc c'est-à-dire qu'on peut faire par exemple, indice_objet.
```py
    for indice_objet in enumerate(inventaire):
        print(objet)
```  
Alors je mets un nom à rallonge mais c'est histoire de bien l'identifier … valeur_objet.
```py
    for indice_objet, valeur_objet in enumerate(inventaire):
        print(objet)
```     
Donc on fait toujours une enumerate() et du coup ici vous pouvez afficher les 2 c'est-à-dire que vous pouvez afficher et on va utiliser une petite méthode format() justement pour ça donc on va avoir print("Element d'indice {} -> {}"), tel élément d'indice est (->) tel chose.
```py
    for indice_objet, valeur_objet in enumerate(inventaire):
        print("Element d'indice {} -> {}")
```    
Et on va faire un format() de l'indice de l'objet et du coup la valeur de l'objet.
```py
    for indice_objet, valeur_objet in enumerate(inventaire):
        print("Element d'indice {} -> {}".format(indice_objet, valeur_objet))
```
Et là l'avantage, c'est qu'avec cette fonction enumerate() quand on fait notre parcours ici avec la boucle for, on va pouvoir obtenir ça.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
inventaire = ["Arc", "Epée", "Bouclier", "Potion"]

for indice_objet, valeur_objet in enumerate(inventaire):
   print("Element d'indice {} -> {}".format(indice_objet, valeur_objet))
```
```powershell
    >python main.py
    Element d'indice 0 -> Arc
    Element d'indice 1 -> Epée
    Element d'indice 2 -> Bouclier
    Element d'indice 3 -> Potion
```

D'accord du coup, on va pouvoir isoler l'indice de l'élément et c'est pratique.

Vous savez que l'indice de l'élément ça peut être utile par exemple pour rechercher directement avec un del, vous savez pour supprimer l'élément en faisant del, le nom de la liste et entre crochets, le nom de la liste. 

Ça peut servir à ça éventuellement pour faire une suppression en particulier par rapport à certains moments en fait du parcours donc ça peut servir à ça ou pour d'autres choses qui seront peut-être utiles pour vous mais en tout cas sachez que c'est possible voilà, vous mettez 2 variables, on les appelle souvent K et V aussi, KEY et VALUE.
```py
#coding:utf-8
"""
liste[X] = Affiche élément d'indice X
liste[-X] = Affiche Xième élément en partant de la fin

liste[:] = affiche tous les éléments
liste[:X] = Affiche les X premiers éléments
liste[X:] = Affiche les X derniers éléments

liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
"""
inventaire = ["Arc", "Epée", "Bouclier", "Potion"]

for k, v in enumerate(inventaire):
   print("Element d'indice {} -> {}".format(k, v))
```
```powershell
    >python main.py
    Element d'indice 0 -> Arc
    Element d'indice 1 -> Epée
    Element d'indice 2 -> Bouclier
    Element d'indice 3 -> Potion
```
On peut très bien faire de cette manière-là voilà d'accord, ça fonctionne évidemment.

C'est le nom de la variable que vous voulez donc cette fonction est très pratique, elle permet d'énumérer de toute manière voilà bah ici ce conteneur, "inventaire", qui est une liste sous forme de tuples mais ça on va en parler juste après pour la prochaine vidéo.

### len

Donc j'espère que vous aurez appris beaucoup de choses encore une fois, il y a plein de notations, il y a plein de syntaxes différentes, il y a plein de choses à savoir, quelques méthodes, quelques fonctions en plus notamment je vais montrer rapidement quand vous faites par exemple len(<list>) d'accord.
```py
    len(<list>) = Retourne la taille (nombre d'éléments)
```
Ça vous retourne la taille donc le nombre d'éléments d'accord voilà ça c'est à savoir parce que pour tout ce qui est structure, vous utilisez cette fonction donc elle n'est pas propre liste. C'est qu'elle fonctionne sur les listes et ça vous retourne le nombre d'éléments donc très pratique à savoir aussi, je tenais à le à noter ici pour ne pas l'oublier.
```py
    """
    liste[X] = Affiche élément d'indice X
    liste[-X] = Affiche Xième élément en partant de la fin

    liste[:] = affiche tous les éléments
    liste[:X] = Affiche les X premiers éléments
    liste[X:] = Affiche les X derniers éléments

    liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus)
    
    len(<list>) = Retourne la taille (nombre d'éléments)
    """
```
Voilà comme ça vous connaissez pas mal de petites choses maintenant à ce niveau, au niveau des listes.

Je pense qu'on a fait le tour de tout, si j'ai oublié quelque chose, de toute manière, c'est pas bien grave. 

Encore une fois, vous pouvez utiliser rappelez vous la fonction help() qui vous permet d'avoir toute la doc sur les list.

Vous aurez encore plein d'autres méthodes, plein d'autres choses qui peuvent peut-être vous être utile pour vous.

Moi je vais en rester là pour bah pour cette formation, pour ce que je vous ai montré, je pense que vous avez déjà beaucoup à faire avec ça.

Et je vous dis à très bientôt puisque on se retrouvera pour parler des tuples.

tchao

## Resume

```py
#coding:utf-8

# Python #16 - listes

#1# Introduction au niveau des listes.
#   ----------------------------------
""" 
Il n'existe pas de tableau en Python. On peux en faire, fonctionner avec un système de tableau mais c'est peu utilisé. On peux tout faire avec les listes et fonctionner comme avec un tableau parce que une liste est un système de séquence, ça va permettre d'avoir une séquence d'informations qui vont se suivrent où chaque élément est à sa place. On peut avoir des éléments rangés qui sont triés, non triés dont on peux avoir des éléments de plusieurs types.

Par rapport à la chaine de caractères, tout ce que l'on va faire dans les listes va se passer directement dessus. C'est à dire que l'on va travailler sur les listes tel qu'elles sont en mémoire.
On ne va pas travailler sur des copies avec les chaînes de caractères (voir vidéo 15). 

Cela peut donc ammener à certaines érreurs par la suite notamment quand on va vouloir faire de la copie de liste. 

Le gros avantage des listes en Python, c'est d'être très flexible. C'est à dire que l'on va pouvoir contenir tout un tas d'objet différents. Dans d'autres langages de programmation, on est obligé de faire des tableaux ou des listes d'entiers, listes de chaines, listes de personnes.

Donc on peut avoir une liste qui mélange des entiers, des personnes, des animaux, des voitures.
Soit n'importe quel type d'objet. Pour rappel, les entiers, les chaines sont des objets en Python. Flexibilité, avantage de pouvoir y mettre tout et n'importe quoi.

On a beaucoup de méthodes, de possibilités, de systèmes pour pouvoir manipuler ces listes très simplement. Cette vidéo contient beaucoup de syntaxes et de choses à retenir.
"""

#2# Créer une liste.
#   ----------------
""" Il existe différente manière pour obtenir une liste à la fin. 
"""
#   -1- Choisir un nom de variable car tout objet doit être stocker dans une variable.
""" La première méthode consiste à instancier une liste. Ainsi l'inventaire est une liste."""
inventaire = list(); # Inventaire qui permettra d'afficher notre liste.
print(inventaire)
""" Il nous affiche des crochets, ils permettent de distinguer une liste (ses éléments) mais pour l'instant, elle est vide. """
#   -1-bis- Faire un type au niveau du code pour vérifier la liste créé.
print(type(inventaire))
""" Il nous affiche que Inventaire est bien de classe liste. On a donc bien créé une liste vide qui porte le nom d'inventaire. """
#   -2- Créer une liste vide.
""" Une autre méthode permet de créer une liste (vide) avec une syntaxe un peu plus courte.
Cette syntaxe est privilégié à l'utilisation du mot clé list même si à la rigueur c'est plus explicite."""
inventaire = []
print(inventaire)
#   -3- Créer une liste non-vide.
""" D'autres possibilités permettent de créer des listes par défaut avec déjà des éléments."""
#   --a-- avec des éléments du même type.
inventaire = [1, 6, 15]
print(inventaire)
#   --b-- avec des éléments de type différent.
""" On peut sans problème mettre des chaînes de caractères."""
inventaire = [1, 6, "voiture"]
print(inventaire)
#   -4- Initialiser une liste avec un nombre d'éléments identiques.
inventaire = [0] # On a qu'un seul zéro dans la liste (la syntaxe est différent du lanagage C).
print(inventaire)
""" Comment créer une liste avec 10 zéro de base ? A la création, il suffit de faire quelques manipulations."""
inventaire = [0] * 10
print(inventaire)
""" On obtient 10 éléments dans la liste qui sont des zéros.
Cela fonctionne avec d'autres types d'éléments."""
inventaire = ["arc"] * 10
print(inventaire)
#   -5- Initialiser une liste avec des valeurs croissantes.
""" Pratique quand on fait des calculs statistiques et des programmes mathématiques.
Pour ce faire on utilise une fonction range() pas forcément lié aux listes.
range() va permettre de choisir un certains nombres d'éléments."""
inventaire = range(20)
""" En faisant range(20), on va lui dire d'insérer de 0 à 19 éléments dans une liste."""
print(inventaire)
"""Mais en l'affichant tel quel, on affiche que range(0, 20). Ainsi on ne voit pas les éléments parce que print(inventaire) ne le permet pas. """

""" En résumé, on peut créer :
   avec list() ;
   en mettant des crochets vides ;
   avec des élément déjà dedans ;
   avec plusieurs fois le même contenu, on multiplie le contenu des crochets ;
   avec la fonction range() qui permet d'avoir une liste de valeurs.
       Si par exemple on veut avoir 100 nombres à la suite, on fait range(100)
       et ça va nous retourner 0 à 99 dans une liste. Ca va très vite, pas besoin
       de faire ça à la main avec une boucle.
"""


#3  Afficher une liste avec une boucle. 
#   -----------------------------------
""" On a plusieurs possibilités pour afficher une liste. Dans la vidéo sur les boucles, on a vu que la boucle FOR permettait de parcourir les séquences et la boucle WHILE faisait un certain nombre d'instruction, un certain nombre de fois. Et ainsi la boucle FOR était générallement reservée pour parcourir une séquence. 

La liste est une séquence. """

#   -1- 1er méthode WHILE.
""" On crée une variable de compteur (i = 0) pour lequel on lui dit while i est inférieur à la taille de notre liste (len(inventaire)) et tu affiche inventaire[i], c'est à dire l'élément numéro i entre crochets. C'est la méthode utilisé en C pour afficher un indice.
Et enfin on incrémente le i. """
inventaire = range(20)
i = 0
while i < len(inventaire):
   print(inventaire[i])
   i += 1
""" On affiche bien 0 à 19 élément. """
""" Cette méthode n'est pas forcément la plus pratique pour les listes. Ce n'est pas ce que l'on fait le plus.
En général pour les listes, on utilise une boucle FOR qui va permettrent de faire un parcours."""

#   -2- 2ème méthode FOR.
""" on lui dit "for valeur in inventaire" soit pour chaque valeur de la liste inventaire (ou la séquence inventaire) tu affiche valeur.  """
inventaire = range(20)
for valeur in inventaire:
   print(valeur)
""" On constate que l'affichage est beaucoup plus rapide.
Il va prendre le premier élément de notre séquence inventaire et il va le stocker dans la variable valeur et ensuite on l'affiche. Ensuite, il l'incrémente c'est comme un curseur qui se déplace. Il se déplace au deuxième élément et il va stocker ce deuxième élément dans valeur et on peux l'afficher. Et ainsi de suite, etc. On peut ainsi parcourir une liste très facillement. """

""" ... une autre manière de faire utile quand on a besoin d'avoir l'indice. 
Pour rappel, le premier élément est l'indice 0 de notre liste et ainsi de suite, etc."""
inventaire = ["Arc", "épée", "bouclier"]
for valeur in inventaire:
   print(valeur)
""" A l'élément qui est d'indice 0 parce qu'une liste commence touours à l'indice 0 est "Arc", l'élément "épée" à l'indice 1 et l'élément "bouclier" à l'indice 2.
L'indice c'est toujours le n-ième - 1 élément. 
L'élement c'est le n-ième + 1 par rapport à son indice.

Par exemple,
Arc : indice 0 (1er élément)
Epee : indice 1 (2e élément)
bouclier : indice 2 (3e élément)"""

#4  Accéder à un élément de notre liste ? 
#   -------------------------------------

""" On vient de voir avec un parcour mais comment accéder à un élément en particulier ?
Pour ce faire il existe plusieurs méthodes. """

#   Afficher l'élément qui a un indice 1.
""" On a vu que chaque élément avait un indice. Donc si on met entre crochet l'indice de l'élément, on va afficher l'indice de cet élément."""
inventaire = ["Arc", "épée", "bouclier"]
print(inventaire[1])
""" On affiche l'élément d'indice 1, c'est à dire le deuxième. Ici, l'épée.
On part du début, de 0 pour atteindre l'élément numéro 1. """

#   Afficher la totalité de la liste.
""" Un autre manière avec des crochets et des points. Le deux points veulent dire qu'on affiche la totalité de la liste."""
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]
print(inventaire[:])
""" Cela nous affiche une liste avec des crochets. Ici, on ne fait pas un parcours, on affiche la totalités des éléments."""

#   Afficher les deux premiers élément de la liste.
""" On veux afficher les deux premiers éléments de la liste. Les ':' avant permettent de spécifier que l'on veux seulement '2' éléments."""
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]
print(inventaire[:2])
""" Il affiche arc et épée, il n'affichera pas bouclier. """

#   Afficher en retirant les deux premiers élément de la liste.
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]
print(inventaire[2:])

#   Afficher l'élément d'indice en partant de la fin.
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]
print(inventaire[-3]) 
""" On part de la fin pour atteindre l'indice 3 depuis la fin. """
print(inventaire[-1]) 
""" on affiche le dernier élément avec l'indice -1. """
print(inventaire[0])
""" ... mais ici on va afficher le premier élément en partant du début. """

""" Si c'est en nombre positif, on compte l'indice. 
Un moins devant, c'est pour dire le n-ième en partant de la fin. """

""" Exemple : afficher le 4e élément en partant de la fin."""
print(inventaire[-4]) 
""" bouclier est donc bien le 4e élément de la liste en partant de la fin."""

#   Afficher les éléments compris entre deux bornes.
inventaire = ["Arc", "épée", "bouclier", "potion", "flèches", "tunique"]
""" Après avoir vu comment on accède à chacun des éléments de la liste. """
print(inventaire[2:4])
""" Afficher l'élément d'indice 2 jusqu'à l'élément d'indice 3. Le 4e élément est exclus. 
On affiche en 4-2 éléments. """
print(inventaire[2:5])
""" On affiche 5-2 éléments."""

#   En résumé, les méthodes d'accès sont :
"""
liste[X] = Affiche élément d'indice X.
liste[-X] = Affixhe le xème élément en partant de la fin.

liste[:] = Affiche tous les éléments.
liste[:X] = Affiche les X premiers éléments.
liste[X:] = Affiche les X derniers éléments.
liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus).

Résumé en ce qui concerne l'accès (modification, affichage) au niveau des listes.
Ca permet d'accéder à pleins d'éléments de la liste. Ca fait gagné pleins de temps.

On a vu comment créer une liste, accéder à ses éléments de n'importe quel manière (du début, de la fin, dans une fourchette, les premiers, les derniers). 

len(<list>) = Retourne la taille (nombre d'élement). 
C'est une fonction pour les structures mais elle n'est pas propre au listes.
Elle retourne le nombre d'élément.
"""

#4  Modifier élément-s de notre liste.
#   -----------------------------------
""" En rappel, on travaille sur la liste en elle-même. On modifie ainsi la vrai liste.
"""

# Affichage après la création.
inventaire = ["Arc", "épée", "bouclier", "potion"]
print(inventaire[:])

# Affichage après la modification d'un élement.
""" En faisant inventaire de 2, on modifie le 3ème élément par "bouclier d'acier". 
Cette syntaxe est déjà présente en C et en C++ pour les tableaux mais ce n'est pas un tableau, c'est une liste. """
inventaire = ["Arc", "épée", "bouclier", "potion"]
inventaire[2] = "bouclier d'acier"
print(inventaire[:])

# Modification multiple d'un élément.
""" On peut sans problème utiliser toutes les méthodes d'accès (X, -X, :, :X, X:, A:B).
Si par exemple, on met [:]. """
inventaire = ["Arc", "épée", "bouclier", "potion"]
inventaire[:] = "bouclier d'acier"
print(inventaire[:])
""" Il nous retourne chaque élément de chaque caractère avec les deux points. Le retour est comme ça car il devrait inclure le nombre de fois où modifier l'élément. 
Si par exemple, on met [:2]. """
inventaire = ["Arc", "épée", "bouclier", "potion"]
inventaire[:2] = "bouclier d'acier"
print(inventaire[:])
""" ... donc en mettant [:2], il nous affiche quelque chose qui ne va pas.
Il faut donc le préciser deux fois pour faire un remplacement multiple. """
inventaire = ["Arc", "épée", "bouclier", "potion"]
inventaire[:2] = ["bouclier d'acier", "bouclier d'acier"]
print(inventaire[:])
""" ... donc ici, il nous a bien modifié les deux premiers éléments. 
Comme on demande à modifier les deux pemiers éléments, on est obligé après l'affectation, d'indiquer les deux nouveaux premiers éléments. """

# Modification multiple avec calcul sur les valeurs d'affectations.
""" Comme c'est la même valeur, on peut refaire un petit calcul à la création.
On crée une liste qui contient 5 fois l'élément Arc."""
inventaire = ["Arc"] * 5
""" Donc on peux faire les calculs à n'importe quel valeur d'affectation."""
inventaire = ["Arc", "épée", "bouclier", "potion"]
inventaire[:2] = ["bouclier d'acier"] * 2
print(inventaire[:])
"""" On obtient ainsi le même résultat."""

# Modification de tous les éléments de la liste.
""" Si on modifie toute la liste, il faut multipler par le nombre d'éléments qu'il y a dans la liste."""
inventaire = ["Arc", "épée", "bouclier", "potion"]
inventaire[:] = ["bouclier d'acier"] * 4 # multiplier par le nombre d'élément dans la liste.
print(inventaire[:])
""" On peut également le faire avec la fonction qui calcul la taille."""
inventaire = ["Arc", "épée", "bouclier", "potion"]
inventaire[:] = ["bouclier d'acier"] * len(inventaire)
print(inventaire[:])
""" Avec la fonction qui donne ici la taille de la liste len(), on peut calculer. """

# Modification d'éléments entre deux bornes.
""" En résumé, on peut modifier n'importe quel élément avec un seul indice ou bien en modifier plusieurs. Autre exemple avec les élément compris entre deux bornes.
"""
inventaire = ["Arc", "épée", "bouclier", "potion"]
inventaire[2:4] = ["bouclier d'acier"] * 2 # 4-2=2 donc 2 éléments à modifier.
print(inventaire[:])
""" Les deux dernier éléments ont ainsi été modifiés, l'élément d'indice 2 et l'élément d'indice 3.
On a rarement besoin d'utiliser cette notation."""

""" On a plus souvent besoin de faire une simple modification d'indice."""
inventaire = ["Arc", "épée", "bouclier", "potion"]
inventaire[2] = "manteau"
print(inventaire[:])

#5  Faire une recherche de notre liste.
#   -----------------------------------

""" On a fait du parcours, on a fait de l'affichage mais on pourrait faire de petites recherches dans la liste sans utilisant de fonctions ou autre mais juste une syntaxe.
"""

# Rechercher une chaine.
""" On veut par exemple vérifier que dans ma liste, il y a un élément "bouclier". """

inventaire = ["Arc", "épée", "bouclier", "potion"]
if "bouclier" in inventaire: # Syntaxe de recherche.
   print("Je possède un bouclier.")
else:
   print("Je n'en ai pas.")

""" Pas besoin d'utiliser de méthode, il suffit de faire un if de cette valeur. 
Est-ce qu'elle existe cette valeur. """

# Rechercher un entier.

""" Dans ce cas ci, il ne faut pas mettre de double quote. """

inventaire = ["Arc", "épée", "bouclier", "potion", 16]
if 16 in inventaire: # Syntaxe de recherche.
   print("Je possède un bouclier.")
else:
   print("Je n'en ai pas.")

#   Methodes de la classe list et fonctions.

#6  Ajouter un élément.
#   -------------------

""" Nous avons vu tout ce que l'on pouvait faire sur les listes.
Maintenant comme la liste est une classe de Python, on a des méthodes, ainsi que des fonctions qui ne sont pas forcément liés à la classe list mais qui peuvent servir sur des listes."""

#   -1- Ajouter des éléments (1ere méthode)
inventaire = [] # Création d'une liste vide.
print(inventaire[:]) # Afficher la liste sans faire un parcours. 
# Ainsi l'affichage sera mieux formater, ça prendra moins de place.
""" On utilise la méthode append() sur l'objet inventaire qui permet d'ajouter des éléments."""
inventaire.append("Arc")
print(inventaire[:])

#   -2- Ajouter plusieurs éléments
""" Certaines méthodes mais pas append() peuvent se faire à la suite, se cumuler l'une à la suite."""
# inventaire.append("Arc").append("Dommage")
""" Ici ca ne va pas ! Il cherche un attribut append() qui n'existe pas.
Pour certaines méthodes, on peut les faire à la suite parce que le résultat va retourner l'objet lui-même et on pourra les faire à la suite."""
# Si on veut en ajouter, on réitère la méthode à la ligne.
inventaire = []
inventaire.append("Arc")
inventaire.append("Arc")
print(inventaire[:])
""" Cette méthode ne trie pas les éléments, ils sont mis à la ajouté à la fin de liste."""

#7  Insérer un élément (où l'on veux).
#   ----------------------------------

#   Ajouter/modifier un élément.
""" Modifier le deuxième élément."""
inventaire = ["arc", "bouclier", "Manteau de cuir"]
inventaire.insert(1, "Potion de mana")
print(inventaire[:])
""" Potion de mana est ajouté au premier indice (le deuxième élément) et automatiquement comme il a prit la place de bouclier, bouclier s'est décalé d'un indice sur la droite et Manteau pareil. 
Manteau était d'indice 2 et maintenant il est d'indice 3.
Arc n'as pas bougé et c'est potion de mana qui a prit la place.
Potion de mana a prit l'indice 1 et bouclier est devenu indice 2."""

""" Ca permet d'insérer à un endroit particulier. Ca permet d'insérer soit en fin soit à un endroit que l'on veut. """

#8  Retirer un élément.
#   -------------------

""" Maintenant qu'on a vu comment ajouter des élément, nous pouvons voir comment les supprimer.
Pour supprimer des éléments on a soit une méthode, soit ..."""

# Méthode de suppression.
inventaire = ["arc", "bouclier", "Manteau de cuir"]
print(inventaire[:])
inventaire.remove("bouclier")
print(inventaire[:])
""" La méthode remove() est une méthode des liste et elle a besoin en paramètres du mot que l'on a besoin de supprimer. Elle n'as pas besoin de la liste mais d'une valeur
dans la liste."""

# Instruction de suppression.
""" Si je veux accéder à l'indice, on utilise l'instruction del, ce n'est pas une méthode de la class list. C'est une instruction utilisable en Python, c'est également un mot réservé."""

inventaire = ["arc", "bouclier", "Manteau de cuir"]
print(inventaire[:])
del inventaire[1]
print(inventaire[:])

""" Soit on travaille avec la méthode de list, soit on travaille avec l'instruction del.
Elle font la même chose. Elle retourne toute deux la suppression d'un élément."""

#9  Retourner un indice et supprimer l'élément.
#   -------------------------------------------

""" Plus haut, on a fait des petite recherche avec le IN mais on peut également retourner l'indice d'un élément d'une liste. """

inventaire = ["arc", "bouclier", "Manteau de cuir"]
print(inventaire[:])
print("Indice :", inventaire.index("bouclier"))
""" Permet de retourner l'index de l'objet pour l'élément bouclier.
Il nous retourne l'indice de la première fois il est rencontré dans la liste."""

""" A quoi cela sert de retourner l'indice d'un objet ? On peut par exemple passer par une variable pour supprimer. """
inventaire = ["arc", "bouclier", "Manteau de cuir"]
objet_a_supprimer = inventaire.index("bouclier")
del inventaire[objet_a_supprimer]
print(inventaire[:])

""" Mais bon on va aussi beaucoup plus vite en faisant :"""
inventaire = ["arc", "bouclier", "Manteau de cuir"]
inventaire.remove("bouclier")
print(inventaire[:])

""" C'est une méthode beaucoup plus rapide. C'est un des avantages de Python, c'est qu'on peut supprimer un élément en ayant juste sa valeur. Mais c'est bien d'avoir la méthode index qui peut être très utile et intéressante dans ce genre de cas."""

#10     Trier une liste par ordre croissant.
#       ------------------------------------

# Trier du texte.
""" Nous allons trier notre liste. Méthode qu'il ne faut pas utiliser directement dans l'inventaire. Pour se faire, il faut que les élément de notre liste soient du même type.
Trier des patates avec des nombres ne va pas fonctionner. """
inventaire = ["Potion de mana", "Arc", "Bouclier", "Manteau de cuir", "Arbalète"]
inventaire.sort()
print(inventaire[:])
""" sort() va permettre de trier par ordre alphabétique."""

# Trier des nombres.
""" On peut également trier avec des nombres."""
inventaire = [5, 128, -7, 3, 124, 7, 178, 2, -8]
inventaire.sort()
print(inventaire[:])

""" Au début, si c'est en désordre, la méthode sort() va permettre de les retrier par ordre croissant. """


#11     Inverser les valeurs d'une liste.
#       ---------------------------------

""" On peut également faire une inversion de valeur. C'est une méthode qui va tout intervertir."""
inventaire = [5, 128, -7, 3, 124, 7, 178, 2, -8]
inventaire.reverse()
print(inventaire[:])
""" le -8 va finir en premier, puis 2, etc. On inverse toutes les valeurs avec reverse()."""

#12     Trier une liste par ordre décroissant.
#       --------------------------------------

inventaire = [5, 128, -7, 3, 124, 7, 178, 2, -8]
inventaire.sort()
inventaire.reverse()
print(inventaire[:])

""" Créer une liste trié dans l'ordre, ensuite inverser cette liste."""

#12     Compter le nombre d'éléments d'une liste.
#       -----------------------------------------

""" Compter le nombre d'élément par rapport à l'index.
On voudrait compter le nombre de potion que l'on a. """

inventaire = ["potion", "arc", "potion", "potion", "manteau"]
print(inventaire[:])
print("Nombre de potions :", inventaire.count("potion"))

""" On retourne 3 parce que cela a compté le nombre d'occurences de potion.
C'est toujours une façon de vérifier les choses le plus simplement possible."""

#13     Effacer tous les éléments de la liste.
#       --------------------------------------

# La méthode clear().

inventaire = ["potion", "arc", "potion", "potion", "manteau"]
print(inventaire[:])
inventaire.clear()
print(inventaire[:])

""" Suivant les outils d'accès à la liste vu liste[X], liste[-X], liste[:], liste[:X], liste[X:], liste[A:B]. On peut accéder à tous les éléments d'une liste, c'est à dire ici toute la liste complète."""

# Affecter une nouvelle liste vide.

""" Comme on travaille sur la liste elle-même, on a vider la liste en réaffectant à la [], une liste vide à toute la liste [:] contenue dans la variable inventaire."""

inventaire[:] = []
print(inventaire[:])


#14     Demander de l'aide pour les méthodes de list.
#       ---------------------------------------------

""" Il y a beaucoup de méthodes très intéressantes pour les listes :
append(), insert(), remove(), index(), sort(), reverse(), count().
Pour voir l'ensemble des méthodes pour les liste, on fait simplement un help(list).
comme pour les chaine de caractères. """

help(list)

#15     Passer d'une chaine à une liste.
#       --------------------------------

chaine = "Bonjour à tous"
chaine = chaine.split(" ")
print(chaine) # Afficher une chaine sous forme de liste.

""" L'élément d'indice 1, c'est "à" et l'élément d'indice 2 est "tous"."""

#16     Passer d'une liste à une chaine.
#       --------------------------------

""" On crée notre liste et on dit que notre chaine (phrase), c'est un espace " " et je joint après chaque espace ma liste."""
inventaire = ["Bonjour", "à", "tous"]
phrase = " ".join(inventaire)
print(phrase)
""" Idem mais on retourne des underscores à la place des espaces."""
inventaire = ["Bonjour", "à", "tous"]
phrase = "_".join(inventaire)
print(phrase)
""" On met la chaine avec le séparateur que l'on veut pour joindre suivi de la méthode join().
join() est méthode des chaines. Ce n'est pas une méthode des listes. 
join() est utilisé sur une chaîne (et non sur une liste) et prend en paramètre, notre liste, notre inventaire dans un conteneur."""

""" Si on prend une suite de nombre "inventaire = [14, 8, 7]", join() ne fonctionnera pas.
On travaille sur des chaînes de caractères et non du texte. Pour que cela fonctionne, il faudrait faire un cast des nombres en string."""

""" Cette méthode permet de joindre les différents éléments d'une liste dans une chaîne."""

#17     Bonus : ON NE TRAVAILLE PAS SUR DES COPIES.
#       -------------------------------------------

""" pour rappel, la liste on travaille directement sur elle-même. 
Ce n'est pas comme une chaîne de caractère où l'on crée des copies.
Ce qui peut induire en erreur.
Par exemple, on crée une liste1 et ensuite une liste2 et on voudrait que ce soit une copie.
On affecte tout simplement la liste1 à la liste2.
On affiche ensuite la liste1 et la liste2.
Ensuite à la liste 2, on va lui ajouter un élément. 
... et normalement si on a fait les choses comme il faut, on devrait avoir une liste2 plus grande que liste1.
... pourtant cela a modifié les deux listes parce que ON NE TRAVAILLE PAS SUR DES COPIES.
Quand on fait la ligne d'affectation "liste2 = liste1", on dit simplement que la liste2 va être une référence, un lien avec la liste1. liste2 deviendra un clone de liste1.
Donc en modifiant la liste2, ca va exactement modifier la liste1 de la même manière."""

liste1 = ["Arc", "Bouclier", "Tunique"]
liste2 = liste1
print("Liste 1", liste1[:])
print("Liste 2", liste2[:])

liste2.append("Potion de mana")

print("Liste 1", liste1[:])
print("Liste 2", liste2[:])

# Si on veut néanmoins créer une copie de liste.

""" Il existe un moyen de créer une copie de liste. C'est le module de copie.
On fait import copy. On appelle le module de copy{} et on utilise sa fonction deepcopy() qui va permettre de faire une copie à l'identique d'un élément pour un autre et là ils seront vraiment indépendant.
Enfin quand j'ajoute un élément à la liste2, il n'est plus ajouté à la liste1."""

import copy

liste1 = ["Arc", "Bouclier", "Tunique"]
# On ne fait pas de copie -> liste2 = liste1
liste2 = copy.deepcopy(liste1)
print("Liste 1", liste1[:])
print("Liste 2", liste2[:])

liste2.append("Potion de mana")

print("Liste 1", liste1[:])
print("Liste 2", liste2[:])

#18     Concatener deux listes.
#       -----------------------

""" Il existe plusieurs moyens. D'abord on va utiliser la méthode extend()"""

# La méthode extend()
liste1 = ["Arc", "Bouclier", "Tunique"]
liste2 = ["Potion", "Parchemin"]
print(liste1[:])
liste1.extend(liste2) # on étend notre liste.
print(liste1[:])
""" On a ajouté à la liste tous les autres éléments.
On a directement ajouté les éléments de la liste2."""

# Une somme
""" La méthode extend() revient exactement à faire la liste1 + la liste2.
"""

liste1 = ["Arc", "Bouclier", "Tunique"]
liste2 = ["Potion", "Parchemin"]
print(liste1[:])
liste1 = liste1 + liste2
print(liste1[:])
""" Comme pour les chaîne de caractères, on utilise l'opérateur + pour faire une concaténation pour dire de fussionner deux listes."""

"""Pour rappel, les deux syntaxes suivantes sont équivalentes.
A = A + B <=> A += B """

liste1 = ["Arc", "Bouclier", "Tunique"]
liste2 = ["Potion", "Parchemin"]
print(liste1[:])
liste1 = liste1 + liste2
print(liste1[:])

""" On ajoute bien les éléments à la suite, et ainsi créé la fusion des listes.
La liste1 contient tous son contenu plus le contenu de la liste2."""

""" Par contre la liste2 n'aura pas bouger : """
print(liste2[:])
""" Quand on fait une concaténation de la liste2, on concatene une copie.
En effet lorsqu'on ajoute un nouvel élément à la liste2, la liste1 ne bouge pas."""
liste2.append("Guêtres")
print(liste2[:])
""" La liste1 et la liste2 sont distinctes, différentes même si on a ajouté tout le contenu de la liste2 à la liste1. 
On a dit d'ajouter le contenu de liste2 à liste1, on a pas dit d'ajouter la liste !
"""

#19     Conclusion.
#       -----------

""" 
On a créé une liste de plusieurs manières différentes ; 
On sait accéder à chacun de ces éléments pour une lecture 
ou pour une modification 
ou pour une suppression également ;
On a vu les méthodes d'ajouts, de suppressions, de parcours, de recherches.
On a vu d'autres méthodes pour compter, trier, pour inverser.
On a vu les transformations de liste à chaîne et inversement.
On a vu la méthode help(list) pour avoir des informations sur les listes.
"""

#20     Dans la prochaine vidéo.
#       ------------------------

""" Nous allons voir comment parcourir la liste et la valeur."""

# Afficher chacun des éléments.
inventaire = ["Arc", "Epée", "Bouclier", "Potion"]
for objet in inventaire:
   print(objet)
""" C'est du parcours tout simple au niveau de la liste. On a vu que for était mieux que while parce qu'il faut utiliser une variable i et que ce n'est pas fait 
pour ça à la base. """

# Récupérer l'élément en même temps.
inventaire = ["Arc", "Epée", "Bouclier", "Potion"]
for objet in enumerate(inventaire):
   print(objet)
""" L'affichage est différent et retourne des couples avec l'indice et la valeur entre parenthèse. Ce sont les Tuples que nous allons voir dans la vidéo 17. """ 

""" Ca peut être intéressant au niveau de l'indice de le récuperer. """
inventaire = ["Arc", "Epée", "Bouclier", "Potion"]
for indice_objet, valeur_objet in enumerate(inventaire):
   print("Element d'indice {} -> {}".format(indice_objet, valeur_objet))
""" Du coup on peut afficher la valeur et son indice avec la méthode format() de l'indice de l'objet et de la valeur de l'objet.

L'avantage est qu'avec la fonction enumerate lorsqu'on fait notre parcours avec la boucle for, on va pouvoir isoler, obtenir l'indice de l'élément. 
L'indice de l'élément, ça peut être utile pour rechercher un élément avec del et ainsi le supprimer directement avec le nom de la liste et entre crochet le nom de l'indice. Ca peut servir à faire une suppression en particulier du parcours."""

""" Cette méthode est souvent utilisée avec deux variables nommées k (key) et V (value)."""

inventaire = ["Arc", "Epée", "Bouclier", "Potion"]
for k, v in enumerate(inventaire):
   print("Element d'indice {} -> {}".format(k, v))

""" La fonction enumerate() est très partique car elle permet d'énumerer un conteneur qui est une liste, sous forme de Tuples (que nous allons voir)."""


#   Rappel sur les méthodes d'accès et la fonction len() :
"""
liste[X] = Affiche élément d'indice X.
liste[-X] = Affixhe le xème élément en partant de la fin.

liste[:] = Affiche tous les éléments.
liste[:X] = Affiche les X premiers éléments.
liste[X:] = Affiche les X derniers éléments.
liste[A:B] = Affiche de l'élément d'indice A à l'élément d'indice B (exclus).

Résumé en ce qui concerne l'accès (modification, affichage) au niveau des listes.
Ca permet d'accéder à pleins d'éléments de la liste. Ca fait gagné pleins de temps.

On a vu comment créer une liste, accéder à ses éléments de n'importe quel manière (du début, de la fin, dans une fourchette, les premiers, les derniers). 

len(<list>) = Retourne la taille (nombre d'élement). 
C'est une fonction pour les structures mais elle n'est pas propre au listes.
Elle retourne le nombre d'élément.
"""
```