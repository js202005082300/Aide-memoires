# [17. Tuples](https://www.youtube.com/watch?v=n54Q-IccZEs)

+ [Création de tuple](#Création-de-tuple)
+ [Accès aux valeurs](#Accès-aux-valeurs)
    + [IndexError](#IndexError)
+ [Modification des valeurs (uniquement avec l'affectation multiple car un tuple est immuable)](#Modification-des-valeurs)
+ [Retourner un tuple avec une fonction](#Retourner-un-tuple-avec-une-fonction)

Bonjour tout le monde, bienvenue sur votre formation langage python. On est sur la séance numéro 17 et on va continuer un petit peu avec les conteneurs qu'on a vu dans ce langage, le premier que vous avez vu avec moi, ce sont les listes dans la vidéo précédente et je vous avais fait une petite transition si vous vous souvenez en fin de vidéo concernant les tuples voilà.

Je vous avais parlé des tuples, je vous avez dit que voilà on verrait un petit peu tout ça pour la suite et je vais vous donner quelques explications.

Je vais revenir du coup très rapidement sur l'exemple que je vous avais laissé d'accord, sur la dernière vidéo. La dernière fois d'accord, je vous avais laissé, on avait fait une sorte de liste par exemple en mettant plusieurs choses.
```py
    liste = [1, 2, 3, 4, 5, 6]
```
Et on avait fait ensuite, pour (for) chaque chose dans (in) la liste, enumerate() de la liste, on faisait tout simplement un print() de cette chose.
```py
#coding:utf-8

liste = [1, 2, 3, 4, 5, 6]

for chose in enumerate(liste):
   print(chose)
```
```powershell
    >python main.py
    (0, 1)
    (1, 2)
    (2, 3)
    (3, 4)
    (4, 5)
    (5, 6)
```
Et du coup automatiquement en faisant ceci, vous voyez qu'on avait cette sorte de syntaxe en fait, je vous avez dit que ça s'appelait un tuple d'accord et qu'on pouvait l'identifier comme ça avec des parenthèses et notamment ici, on le voyait bien avec un couple de valeurs et une virgule surtout, c'est surtout ça qui est important, pour séparer ces fameuses valeurs.

Donc ça c'est un nouveau type de conteneur qui est assez particulière, alors c'est un système de séquence parce que la liste, pour résumer en matière de vocabulaire, un conteneur tout simplement c'est une manière d'organiser des données d'accord, de contenir.

Voilà un conteneur, c'est quelque chose qui peut contenir des données et on en a quelques-unes qui sont les séquences. Parmi les les conteneurs type séquence, on a donc la liste, celui que vous avez vu précédemment et on a maintenant les tuples.

Alors qu'elle est la différence parce que s'il y en a deux, c'est bien qu'il y a une différence entre les 2 qui ont chacun leur utilité. La liste, je ne reviens pas dessus c'était la vidéo d'avant.

Pour un tuple, la différence par rapport à la liste, c'est que vous allez pouvoir avoir une séquence donc ça, c'est toujours pareil, qui vas pouvoir contenir des objets.

Par contre les tuples sont **immuables** c'est-à-dire qu'une fois que vous avez créé des tuples, vous allez voir comment on va faire ça, on ne peut pas les modifier.

On ne peut donc rien ajouter dedans, on ne peu certainement pas supprimer puisque je rappelle qu'une suppression est une modification au même titre qu'un ajout au ce genre de choses voilà.

La seule différence c'est ça surtout, c'est qu'un tuple, on peut le créer, pas de problème.

Une fois qu'il est créé, il ne bouge pas donc ça peut servir à notamment définir des constantes. On peut très bien définir des **constantes** avec le système de tuples mais vous voir également deux avantages et de l'utilité surtout de ce système là.

On va déjà regarder comment créer un tuple, d'accord, maintenant que vous voyez un peu la syntaxe que ça peut avoir, alors comment on va créer ça ?

## Création de tuple

Alors en général ... d'ailleurs, vous en avez utiliser quelque part sans forcément connaître les tuples. 

On va créer un tuple, on le crée comme ça.
```py
    #coding:utf-8

    mon_tuple =
```
Un tuple pour que ce soit bien visible, on va le définir avec avec des parenthèses d'accord. Là où on a des crochets pour la liste, pour un tuple, on va avoir des parenthèse.

Alors si je fait ceci, j'ai un tuple vide.
```py
    #coding:utf-8

    mon_tuple = ()
```
D'ailleurs si je fait print() de type() de mon_tuple.
```py
#coding:utf-8

mon_tuple = ()

print(type(mon_tuple))
```
```powershell
    >python main.py
    <class 'tuple'>
```
Voilà, il vous met que ça appartient bien à la classe tuple et je rappelle que tout est objet en python donc là ça ne fait évidemment pas exception à la règle, on avait la classe liste précedemment et là, on a la classe tuple pour les tuples donc la même chose.

On met des parenthèses parce que ça permet de facilement les distinguer.

Un tuple ne peut contenir qu'une seule valeur même si c'est assez rare, je dirais pas forcément utile mais si vous voulez mettre qu'une valeur dans un tuple, vous allez mettre n'importe quoi car je rappel que ça **peut contenir tout type d'objet**, des chaînes de caractères, des nombres, d'autres types d'objet comme un personnage, n'importe quoi.

Nous on va travailler avec des nombres parce que c'est plus rapide mais vous pouvez mettre n'importe quoi, je mettre par exemple 45, ce genre de chose.
```py
    #coding:utf-8

    mon_tuple = (45)

    print(type(mon_tuple))
```
Alors si vous faites-ça, ça peut être l'erreur, vous allez avoir des soucis. Vous pouvez vous dire bah tiens je n'ai qu'une seule valeur, après tout je peux juste mettre ça ? Non, si vous faites ça, vous n'aurez pas un tuple, vous aurez simplement la valeur 45.
```py
    #coding:utf-8

    mon_tuple = 45

    print(type(mon_tuple))
```
Vous allez créer tout simplement un entier d'ailleurs je sais même pas s'il va vraiment le prendre en compte de toute façon. Si je fais ça.
```py
#coding:utf-8

mon_tuple = (45)

print(type(mon_tuple))
```
```powershell
    >python main.py
    <class 'int'>
```
Voyez il vous met que c'est de classe integer donc les parenthèses permettent de ne pas créer d'erreur à l'exécution par contre il va vous dire que ce n'est pas un tuple. 

Pour avoir obligatoirement un tuple, il faut mettre une virgule même si vous n'avez qu'une seule valeur, à partir de là, regardez on a effectivement bien le type tuple.
```py
#coding:utf-8

mon_tuple = (45,)

print(type(mon_tuple))
```
```powershell
    >python main.py
    <class 'tuple'>
```
Donc ça c'est très important même si vous n'avez qu'une seule valeur dans le tuple, vous n'oubliez pas la virgule à la fin.

On peut parce que c'est bien que vous sachiez la syntaxe si par exemple un jour vous lisez le code de quelqu'un d'autre et cetera, vous pouvez avoir un tuple comme ceci (sans parenthèse).
```py
#coding:utf-8

mon_tuple = 45,

print(type(mon_tuple))
```
```powershell
    >python main.py
    <class 'tuple'>
```
C'est également possible, c'est la même chose regardez class 'tuple' ça fonctionne.

Après c'est vrai que c'est moins visible donc en général on met des parenthèses pour pouvoir les indiquer facilement d'accord donc ça c'est une question d'habitude, c'est histoire de bien se repérer donc je vais mettre création de tuples, on a plusieurs façons.
```py
    """
    Création de tuple : nom_tuple = ()
    """
```
On peut faire donc `nom_tuple = ()` comme ceci et donc là il est vide.

```py
#coding:utf-8

"""
Création de tuple : nom_tuple = () #vide
"""

mon_tuple = 45,

print(type(mon_tuple))
```
```powershell
    >python main.py
    <class 'tuple'>
```
On peut faire également avec par exemple je sais pas moi, on va mettre ici 17 donc une seule valeur.
```py
"""
Création de tuple : nom_tuple = () #vide
                    mon_tuple = 17, #Une seule valeur
"""
```
Même chose comme ceci, idem qu'au dessus voilà.
```py
"""
Création de tuple : nom_tuple = () #vide
                    mon_tuple = 17, #Une seule valeur
                    mon_tuple = (17,) #Idem qu'au-dessus
"""
```
Hop et on peut bien évidemment créer, ça me paraît logique, un tuple avec plusieurs valeurs.
```py
"""
Création de tuple : nom_tuple = () #vide
                    mon_tuple = 17, #Une seule valeur
                    mon_tuple = (17,) #Idem qu'au-dessus
                    mon_tuple = (4, 6)
"""
```
Alors ce genre de chose, on peut en mettre 2, on peut en mettre 3 pas de problème ... plusieurs valeurs alors d'ailleurs, je décale un peu les commentaires comme ça c'est clair.
```py
"""
Création de tuple : nom_tuple = ()      #vide
                    mon_tuple = 17,     #Une seule valeur
                    mon_tuple = (17,)   #Idem qu'au-dessus
                    mon_tuple = (4, 6)  #Plusieurs valeurs
"""
```
Donc sans problème, on peut très bien faire ... alors, on pourrait ne pas mettre de parenthèses mais je vous dit c'est mieux de les mettre.
```py
#coding:utf-8

"""
Création de tuple : nom_tuple = ()      #vide
                   mon_tuple = 17,     #Une seule valeur
                   mon_tuple = (17,)   #Idem qu'au-dessus
                   mon_tuple = (4, 6)  #Plusieurs valeurs
"""

mon_tuple = (45, 64)

print(type(mon_tuple))
```
```powershell
    >python main.py
    <class 'tuple'>
```
On peut mettre du coup plusieurs valeurs comme ceci, il n'y a pas de problème. C'est toujours la même chose, vous allez bien avoir le typle tuple donc **mettez des parenthèses**, moi je vous le recommande quand vous faites des tuples, c'est simplement plus lisible.

On a les crochets pour la liste. Au moins en mettant des parenthèses, on sait qu'on a faire à des tuples, il n'y a pas de confusion possible, c'est tout à fait lisible, tout à fait compréhensible pour n'importe quel développeur en python comme ça on ne se trompe pas.

Alors du coup quel intérêt parce que c'est vrai qu'on peut par exemple une fois que j'ai créé ce tuple, je ne vais pas avoir de méthode pour ajouter une autre valeur dedans, je ne vais pas avoir de méthode pour les supprimer, de méthode pour les inverser ou faire du tri ou je ne sais quoi. Les tuples ne servent pas à ça, ils servent avant tout à faire des constantes avec alors pourquoi ? bah je ne sais pas moi ça peut être par exemple des constantes de paramètres pour un programme, un jeu ou n'importe quoi. Vous pouvez définir comme ça avec une suite de valeurs ou d'objets peu importe et on peut évidemment par contre y accéder d'accord.

## Accès aux valeurs

```py
#coding:utf-8

"""
Création de tuple : nom_tuple = ()      #vide
                   mon_tuple = 17,     #Une seule valeur
                   mon_tuple = (17,)   #Idem qu'au-dessus
                   mon_tuple = (4, 6)  #Plusieurs valeurs
"""

mon_tuple = (45, 64)

print(mon_tuple[0])
```
```powershell
    >python main.py
    45
```
Si je veux accéder admettons au premier élément et bien je vais tout simplement faire mon tuple de 0, ça c'est comme pour les listes d'accords, c'est un peu la syntaxe qu'on retrouve dans d'autres langages de programmation avec les tableaux donc vous voyez que l'indice commence à 0 pour le premier élément. 

Voyez si je fait mon tuple de 1, j'aurais évidemment ceci.
```py
#coding:utf-8

"""
Création de tuple : nom_tuple = ()      #vide
                   mon_tuple = 17,     #Une seule valeur
                   mon_tuple = (17,)   #Idem qu'au-dessus
                   mon_tuple = (4, 6)  #Plusieurs valeurs
"""

mon_tuple = (45, 64)

print(mon_tuple[1])
```
```powershell
    >python main.py
    64
```

### IndexError

Bien évidemment si je vais faire mon tuple de 2 c'est-à-dire le 3e élément, je vais avoir une exception IndexError.
```py
#coding:utf-8

"""
Création de tuple : nom_tuple = ()      #vide
                   mon_tuple = 17,     #Une seule valeur
                   mon_tuple = (17,)   #Idem qu'au-dessus
                   mon_tuple = (4, 6)  #Plusieurs valeurs
"""

mon_tuple = (45, 64)

print(mon_tuple[2])
```
J'ai une exception IndexError parce que je dépasse l'index c'est-à-dire que je dépasse tout simplement la zone du tuple, il vous met d'ailleurs l'index out of range pour vous dire qu'on a dépassé.
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 270, in <module>
        print(mon_tuple[2])
    IndexError: tuple index out of range
```
Donc à ce moment-là, on pourrait à la rigueur par exemple vérifier donc souvent d'ailleurs quand vous voulez faire un accès comme ça vous pouvez très bien le faire dans un try puis dans le except de pouvoir traiter éventuellement l'IndexError donc n'hésitez pas, je le dit et je le répète, on l'a vu dans la vidéo sur la gestion des erreurs, essayez d'être le plus rigoureux possible même pour des choses par exemple ici comme ça, mon_tuple[2]

Pour être sûr par exemple qu'un affichage se fait bien dites-vous que toute instruction qui pourrait éventuellement causer une levé d'exception gérer le dans un try except tout le temps, c'est mieux.

C'est mieux qu'il y ait trop de de vérification en matière de gestion avec les exceptions plutôt que passer comme ça, mon_tuple[2], parce que là on pourrait se dire, je peux faire n'importe erreur comme ça d'inattention, si je mets un index qui dépasse, je vais avoir une erreur comme ça ici à l'exécution alors que si automatiquement j'avais fait tout simplement ceci.
```py
    mon_tuple = (45, 64)

    try:
        print(mon_tuple[2])
    except:
```
Alors ça c'est la petite parenthèse dans cette vidéo parce que la vidéo va être assez courte donc comme ça là, j'en profite du coup pour vous donner ce petit Détail.

Bien évidemment on va mettre voilà, j'sais pas moi, "Dépassement du tuple".
```py
#coding:utf-8

"""
Création de tuple : nom_tuple = ()      #vide
                   mon_tuple = 17,     #Une seule valeur
                   mon_tuple = (17,)   #Idem qu'au-dessus
                   mon_tuple = (4, 6)  #Plusieurs valeurs
"""

mon_tuple = (45, 64)

try:
   print(mon_tuple[2])
except:
   print("Dépassement du tuple")
```
```powershell
    >python main.py
    Dépassement du tuple
```
Alors c'est un peu bizarre alors que bien évidemment, on gérerait l'erreur autrement mais du coup on peut évidemment comme ça vous voyez gérer les erreurs un peu plus proprement que d'afficher un bête message comme ça avec la levée d'exceptions tout simplement.

On va rester sur quelque chose par contre de simples ici par rapport à la vidéo mais voilà.

On peut donc accéder à l'élément sans problème donc on peut faire un accès.

Mais quel avantage, quel utilité surtout, à quoi sert un tuple, c'est vrai qu'au final si on ne peut rien modifier est-ce que ça a vraiment une utilité ? est-ce que ça vaut le coup de s'en servir ?

Déjà je vais mettre.
```py
"""
Création de tuple : nom_tuple = ()      #vide
                    mon_tuple = 17,     #Une seule valeur
                    mon_tuple = (17,)   #Idem qu'au-dessus
                    mon_tuple = (4, 6)  #Plusieurs valeurs
                    
Accès aux valeurs : mon_tuple[X]        #Valeur d'indice X
"""
```
Voilà voilà au moins c'est clair pour tout le monde.

Très bien donc de ce côté là pour l'accès.

## Modification des valeurs

Alors deux points d'accord, 2 choses importantes à savoir puisqu'on ne peut rien modifier dans une tuple, comment ça fonctionne ? Première chose qui est intéressante, c'est l'**affectation multiple** d'accord, ça ça peut servir. Admettons je veux affecter 2 valeurs à 2 variables ou 2 objets à 2 variables en fait, peu importe parce que je rappelle que dans les tuples, comme ce sont des conteneurs on peut y mettre absolument tout ce qu'on veut dedans. Je peux très bien faire par exemple, nombre1 et nombre2.
```py
    nombre1 = 14
    nombre2 = 46
```
Et bien je peux tout simplement en réalité faire.
```py
    nombre1, nombre2 = 14, 46 
```
Voilà, ça je ne vais pas le mettre dans les notes parce que c'est vraiment archi simple d'accord, pas besoin de forcément le noter.

De cette manière et là je vais effectivement créer mes 2 variables sans problème, d'ailleurs je peux vous montrer,on va les afficher print de nombre1 et print de nombre2 voilà d'accord.
```py
#coding:utf-8

"""
Création de tuple : nom_tuple = ()      #vide
                   mon_tuple = 17,     #Une seule valeur
                   mon_tuple = (17,)   #Idem qu'au-dessus
                   mon_tuple = (4, 6)  #Plusieurs valeurs

Accès aux valeurs : mon_tuple[X]        #Valeur d'indice X
"""
nombre1, nombre2 = 14, 46 

print(nombre1)
print(nombre2)
```
```powershell
    >python main.py
    14
    46
```
D'accord, on gère sans problème donc pareil c'est pas forcément très lisible parce qu'il n'y a pas de parenthèses donc mettez des parenthèses comme des tuples. Les variables je les considère comme un tuple.
```py
    (nombre1, nombre2) = 14, 46
```
Et ça aussi au niveau des valeurs.
```py
    (nombre1, nombre2) = (14, 46)
```

Et là automatiquement, je peux du coup faire cette affectation multiple tout simplement alors n'oubliez pas il s'agit d'un tuple c'est-à-dire qu'on ne pourra pas modifier la valeur d'accord donc c'est utile dans le cas d'affectation multiple mais pour des constantes bien évidemment, ici `nombre1 nombre2` je ne vais pas pouvoir en faire ce que je veux. Si je fais ce genre de chose. Alors là par contre il va me le prendre comme ça pour l'affectation multiple ça va fonctionner.
```py
#coding:utf-8

"""
Création de tuple : nom_tuple = ()      #vide
                   mon_tuple = 17,     #Une seule valeur
                   mon_tuple = (17,)   #Idem qu'au-dessus
                   mon_tuple = (4, 6)  #Plusieurs valeurs

Accès aux valeurs : mon_tuple[X]        #Valeur d'indice X
"""
(nombre1, nombre2) = (14, 46) 

print(nombre1)
print(nombre2)

nombre1 = 128

print(nombre1)
```
```powershell
    >python main.py
    14
    46
    128
``` 
Voilà d'accord si vous avez votre tuple en temps normal, admettons vous mettez dans une variable, vous mettez vos tuples et cetera, vous ne pourrez pas en modifier la chose par contre dans le cadre de l'affectation multiple là on va pouvoir faire des modifications puisque **le tuple n'est pas géré comme une constante**.

Il va être géré tout simplement comme une affectation multiple d'accord donc ça c'est vraiment à distinguer ça c'est un conteneur immuable d'accord ... d'ailleurs je devrais même le noter ici parce que ça c'est un point important quand même je pense.

## 2 raisons d'utiliser les tuples

Tuple est un conteneur immuable dont on peut modifier les valeurs sauf bien évidemment vous pouvez changer par exemple ... ici comme j'ai plusieurs variables ... vous pouvez changer la valeur d'une variable puisqu'on fait une affectation multiple okay, après évidemment ça pourrait fonctionner, il n'y a pas de souci à ce niveau là.

Donc ça c'est important de savoir, de bien distinguer les deux d'accord, le moment où vous créer simplement un tuple ou bien le moment ou vous faites une affectation multiple donc ça c'est le premier avantage, première utilité des tuples tout simplement, de pouvoir faire une affectation multiple beaucoup plus rapide, beaucoup plus pratique.

Et l'autre avantage très sympa qu'on n'a pas par exemple dans des langages comme le C ou d'autres langages comme ça qui permettent par exemple de faire retourner des valeurs à des fonctions, on va pouvoir faire un retour de fonction avec 2 valeurs par exemple.

On peut retourner un tuple en fait à une fonction plutôt que de retourner qu'une seule valeur alors ça on va le regarder ici.

donc je vais mettre d'ailleurs ici deux raison d'utiliser les tuples, ça ce sont vos petites notes pour vous.
```py
"""
(!) Tuple : conteneur immuable (dont on peut modifier les valeurs)
Création de tuple : nom_tuple = ()      #vide
                    mon_tuple = 17,     #Une seule valeur
                    mon_tuple = (17,)   #Idem qu'au-dessus
                    mon_tuple = (4, 6)  #Plusieurs valeurs

Accès aux valeurs : mon_tuple[X]        #Valeur d'indice X

2 raisons d'utiliser les tuples :   affectation multiple de variable
                                    retour multiple de fonction
"""
```

## Retourner un tuple avec une fonction

Voilà, admettons, qu'est-ce que je peux faire comme fonction bizarre ? Allez on va faire get_player_position(), ça prend rien du tout, je ne vais pas mettre de paramètre du tout.
```py
    def get_player_position():
```
Et elle va faire tout simplement posX ... n'importe quoi d'ailleurs on aurais même pu se servir des tuples pour faire l'affectation multiple mais là, on va en faire un normal, je ne sais pas moi 148 par exemple.
```py
    def get_player_position():
        posX = 148
```
Et puis on aurait posY égal 86.
```py
    def get_player_position():
        posX = 148
        posY = 86
```
Eh bien vous pouvez faire ceci.
```py
    def get_player_position():
        posX = 148
        posY = 86
        
        return posX, posY
```
`return posX, posY`, choses qui seraient impossibles à faire dans des langages comme le langage C pour ceux qui utilisent ce langage ou qui le suivent sur ma chaîne donc ça c'est tout à fait possible.

Vous pouvez d'ailleurs les mettre ... vous retourner un tuple, d'accord, le tuple (posX, posY) qui ici va être immuable parce que vous n'allez pas le changer dans la fonction d'accord. Vous allez récupérer ses valeurs mais dans la fonction, ça ne va pas être changé donc pas de problème.
```py
    def get_player_position():
        posX = 148
        posY = 86
        
        return (posX, posY)
```
Et comment on le récupère et bien là, on est dans le programme principal, ça c'est important.
```py
    def get_player_position():
        posX = 148
        posY = 86
        
        return (posX, posY)

    #Programme principal
```
Voilà on va voir par exemple coordX du joueur, admettons 0, et coordY égal 0.
```py
    def get_player_position():
        posX = 148
        posY = 86
        
        return (posX, posY)

    #Programme principal
    coordX = 0
    coordY = 0
```
On va mettre du coup "Position du joueur" puis je met des valeurs complètement ... c'est des exemples de code assez sommaire mais c'est vraiment pour vous illustré les choses le plus simplement possible. Puis on va faire un petit format() maintenant vous connaissez bien l'utilisation des méthodes des chaînes de caractères, voilà.
```py
    def get_player_position():
        posX = 148
        posY = 86
        
        return (posX, posY)

    #Programme principal
    coordX = 0
    coordY = 0
    
    print("Position du joueur : ({}/{})".format(coordX, coordY))
```
On fera la même chose après et du coup entre les 2, je peux faire ceci coordX, coordY donc je rappelle que c'est comme si je faisais un tuple en fait et là dessus je retourne le résultat de ma fonction d'accord.
```py
#coding:utf-8
"""
(!) Tuple : conteneur immuable (dont on peut modifier les valeurs)
Création de tuple : nom_tuple = ()      #vide
                   mon_tuple = 17,     #Une seule valeur
                   mon_tuple = (17,)   #Idem qu'au-dessus
                   mon_tuple = (4, 6)  #Plusieurs valeurs

Accès aux valeurs : mon_tuple[X]        #Valeur d'indice X

2 raisons d'utiliser les tuples :   affectation multiple de variable
                                   retour multiple de fonction
"""

def get_player_position():
   posX = 148
   posY = 86
   
   return (posX, posY)

#Programme principal
coordX = 0
coordY = 0

print("Position du joueur : ({}/{})".format(coordX, coordY))

coordX, coordY = get_player_position()

print("Position du joueur : ({}/{})".format(coordX, coordY))
```
```powershell
    >python main.py
    Position du joueur : (0/0)
    Position du joueur : (148/86)
```
Là voyez, la position du joueur, c'est bien 0/0 après c'est bien 148/86 d'accord.

Toujours cette espèce de format de tuples.
```py
#coding:utf-8
"""
(!) Tuple : conteneur immuable (dont on peut modifier les valeurs)
Création de tuple : nom_tuple = ()      #vide
                   mon_tuple = 17,     #Une seule valeur
                   mon_tuple = (17,)   #Idem qu'au-dessus
                   mon_tuple = (4, 6)  #Plusieurs valeurs

Accès aux valeurs : mon_tuple[X]        #Valeur d'indice X

2 raisons d'utiliser les tuples :   affectation multiple de variable
                                   retour multiple de fonction
"""

def get_player_position():
   posX = 148
   posY = 86
   
   return (posX, posY)

#Programme principal
coordX = 0
coordY = 0

print("Position du joueur : ({}/{})".format(coordX, coordY))

(coordX, coordY) = get_player_position()

print("Position du joueur : ({}/{})".format(coordX, coordY))
```
```powershell
    >python main.py
    Position du joueur : (0/0)
    Position du joueur : (148/86)
```
Voilà, voyez si je mets les parenthèses absolument aucune différence.

Moi je conseille de les mettre, en général moi quand j'utilise les tuple, quand je programme, je mets toujours les parenthèses quand il faut les mettre.

Voilà même dans le return, je les ai mise donc il est vrai que même les gens ont l'habitude souvent de noter directement les noms des variables séparées par des virgules.

Mettez les parenthèses, vous voyez que n'importe qui, qui va lire le code, qui connaît les tuples, il sait automatiquement qu'ici "return (posX, posY)", on retourne bien un tuple et que là effectivement, "(coordX, coordY)", on récupère bien dans un tuple.

On ne peut pas se tromper, on est sûr de ça voilà.

Alors même choses si je modifie les données.

```py
#coding:utf-8
"""
(!) Tuple : conteneur immuable (dont on peut modifier les valeurs)
Création de tuple : nom_tuple = ()      #vide
                    mon_tuple = 17,     #Une seule valeur
                    mon_tuple = (17,)   #Idem qu'au-dessus
                    mon_tuple = (4, 6)  #Plusieurs valeurs

Accès aux valeurs : mon_tuple[X]        #Valeur d'indice X

2 raisons d'utiliser les tuples :   affectation multiple de variable
                                    retour multiple de fonction
"""

def get_player_position():
    posX = 148
    posY = 86
    
    return (posX, posY)

#Programme principal
coordX = 0
coordY = 0

print("Position du joueur : ({}/{})".format(coordX, coordY))

(coordX, coordY) = get_player_position()
coordX = 150
coordY = 150

print("Position du joueur : ({}/{})".format(coordX, coordY))
```
```powershell
    >python main.py
    Position du joueur : (0/0)
    Position du joueur : (150/150)
```
Voilà, ça se modifie bien évidemment, OK, puisque je vous rappelle que c'est une affectation multiple.

Donc ça c'est important, en cas de encas d'affectation multiple vous pouvez modifier les valeurs, OK.

Par contre si vous créez un tuple, le tuple ne peut pas être modifié pas d'ajout, pas de suppression de valeurs tout simplement.

On peut évidemment pas modifier puisque c'est immuable d'où le terme immuable justement, ce qui ne peut pas subir de modifications. C'est toute la différence avec les listes, voilà, c'est ça la différence entre les différents conteneurs donc c'était le 2e conteneur, je voulais vous montrer notamment de type séquence parce que c'est quand même un des plus importants aussi, il est très utilisé, énormément utilisé aussi mine de rien.

Donc c'était les avantages, enfin les raisons du cadre de son utilisation. Je rappelle l'affectation multiple de variables ou le retour multiples sur une fonction tout simplement.

Donc si c'est pas assez clair pour vous, n'hésitez pas à refaire d'autres petits exemple, ça peut vous servir. Je pense que ce sera utile, je pense que vous en aurez vraiment l'utilité et puis vous n'en avez pas l'utilité de toute manière maintenant vous l'aurez ... vous la trouverez bien évidemment plus tard quand vous aurez un encore un niveau un peu plus grand en Python donc je ne me fais pas de souci pour ça voilà.

Bah écoutez c'était une vidéo assez courte hein, le but c'était pas de faire quelque chose de très très long, c'est beaucoup beaucoup moins long du coup à traiter que le conteneur des listes qui lui avait beaucoup de méthode, beaucoup de choses à voir.

On se retrouvera du coup pour une prochaine vidéo où là je vous parlerai d'un autre conteneur d'accord, on a encore quelques petits conteneurs à voir au niveau de ce langage et voilà entraînez-vous, laissez des commentaires s'il y a besoin.

Normalement ça devrait je pense suffisamment bien assimilé comme séance et à la prochaine

## Resume

```py
#coding:utf-8

#   Python #17 - tuples.

""" Nous continuons avec les conteneurs vu dans ce langage.
Le premier qu'on a vu ce sont les listes et maintenant on
va voir les tuples."""

""" Sur l'exemple vu la dernière fois, on avait fait une sorte de liste.
Ensuite pour chaque chose dans la liste, on affichait cette chose.
"""
liste = [1, 2, 3, 4, 5, 6]
for chose in enumerate(liste):
   print(chose)
"""
On obtenait :
(0, 1)
(1, 2)
(2, 3)
(3, 4)
(4, 5)
(5, 6)
Cette syntaxe identifiée avec des paranthèse est un tuple avec un
couple de valeurs séparés surtout par une virgule.
"""

#1# Définition d'un tuple
"""

Un tuple est un système de séquence, un conteneur une manière
d'organiser des données. Parmi ces conteneur, certains sont des
séquences. La liste et les tuple sont de type séquence.

Quels sont les différences entre liste et tuple ?
Pour les listes voir la vidéo 016.
Pour un tuple, on peut avoir une séquence (pour l'instant pareil à
la liste) qui pourra contenir des objets. Par contre, les tuples
sont immuables c'est à dire qu'une fois que les tuples sont créés,
on ne peut pas les modifier, rien ajouter dedans et certainnement
pas les supprimer parce que une suppression est une modification
est une suppression.

Donc la seul différence, c'est qu'un tuple, on peut le créer, une
fois qu'il est créé, il ne bouge pas. Ca peut par exemple servir
à définir des constantes avec le système de tuples.
"""
#2# Créer un tuple
#   mon_tuple = ()      # Vide.
#   mon_tuple = (17,)   # Une seule valeur.
#   mon_tuple = 17,     # Idem qu'au-dessus.
#   mon_tuple = (4, 6)  # Plusieurs valeurs.


"""
Pour qu'un tuple soit bien visible, il faut le définir avec des
parenthèses. On a des crochets pour la liste, pour un tuple,
on aura des parenthèses. Les parenthèse permettent de
facilement les distinguer. 

En affichant son type, mon_tuple appartient à la classe des
tuples. Tout est objet en Python comme on avait la classe
list, on a maintenant la classe tuple.
"""
# Création d'un tuple vide
mon_tuple=()
print(type(mon_tuple)) # Avec () vide, la classe est un tuple.
"""
Un tuple permet d'obtenir qu'une seule valeur ce qui n'est
pas très utile mais ça peut contenir n'importe quoi,
c'est-à-dire tout type d'objet (string, nombre ou encore
d'autres types d'objets comme un personnage).

Par exemple, on met 45. Par contre si on ne met que ça
mon_tuple=(45), on aura pas un tuple, on aura juste la
valeur 45 : mon_tuple=45. C'est à dire un simple entier.
"""
mon_tuple=(45)
print(type(mon_tuple)) # Avec juste 45, la classe est integer.

# Création d'un tuple avec une seule valeur
"""
Pour avoir obligatoirement un tuple, il faut mettre
obligatoirement une virgule même si on a qu'une seule valeur.

Maintenant, on retrouve bien le type tuple.
"""
mon_tuple=(45,)
print(type(mon_tuple))
""" C'est très important, même si on a qu'une seule valeur dans
le tuple, on oublie pas de mettre une virgule à la fin."""

""" On peut aussi retrouver la syntaxe sans parenthèses.
Mais pour des raisons de lisibilité, il est recommandé de
mettre des parenthèses."""
mon_tuple=45,
print(type(mon_tuple))

# Création d'un tuple avec plusieurs valeurs
""" On aura bien le type tuple."""
mon_tuple = (45, 64)
print(type(mon_tuple))

""" Il est recommandé de mettre des parenthèse pour des raisons
de lisibilité. En mettant des parenthèse, on sait qu'on utilise
des tuples et avec crochets, on utilise des listes."""

"""
Quel est l'intéret des tuples ? Une fois qu'on les a créé, on
n'a pas de méthode pour ajouter des éléments, ou les supprimer,
ou les inverser ou encore les trier. Les tuples ne servent
avant tout tout à faire des constantes avec.

On peut les utiliser pour des paramètres, constante d'un jeu
vidéo avec une suite de valeurs, d'objets.

On peut par contre acceder aux élements de mon tuple."""
#3# Accéder aux valeurs, à un élément de Tuple :
#   mon_tuple[X] # valeur d'indice X
#

""" C'est comme pour les listes. On met l'indice entre crochet.
C'est également la syntaxe que l'on retrouve dans d'autres
langages de programmation avec les tableaux."""
mon_tuple = (45, 64)
print(mon_tuple[0])
""" Si je fait mon tuple de 0, j'affiche le premier élément.
Si je fait mon tuple de 1, j'affiche le sond élément.
Si je fait mon tuple de 2, je vais avoir une exception
IndexError parce que je dépasse l'Index, c'est à dire la
zone du tuple. Il nous met d'ailleurs "Index out of range"
pour nous dire que l'on a dépassé.

... Dans ce cas là, on pourrait à la rigueur vérifier.
On peut très bien faire l'accès dans un TRY puis dans le
EXCEPT, on pourrait traiter IndexError.

Il est recommandé d'être le plus rigoureux possible
(vidéo sur la gestion des erreurs) même pour un simple
affichage print(mon_tuple[0]). Pour être sûr qu'un
affichage se fait bien, toutes instructions qui pourrait
éventuellement causer une levée d'exception, il faut les
gérer dans un TRY/EXCEPT. C'est mieux qu'il y ai trop de
gestion des exceptions.

Peu importe l'erreur d'inattention. Si j'ai un nombre qui
dépasse, je vais lever une erreur."""
try:
   print(mon_tuple[0])
except:
   print("Dépassement du tuple")
""" On peut ainsi gérer les erreurs un peu plus proprement que
de lever un bête message avec la levée d'exception."""

""" On peut faire un accès à un élément."""

#4# Affectation multiple de variable (1er avantage)
#

""" Quel est l'intérêt d'un tuple si au final on ne peut rien
modifier ? Donc deux points puisqu'on ne peut rien modifier
dans un tuple.

La première chose qui est intéressante, c'est l'affectation
multiple.

Admettons que je veux affecter deux valeurs à deux variables,
deux objets. Les tuples étant des conteneurs, on peut mettre
absolument tout ce que l'on veut dedans.

Au lieu de faire : """
nombre1 = 14
nombre2 = 46
""" On peut tout simplement faire : """
nombre1, nombre2 = 14, 46
""" On peut ainsi créer nos variables et les afficher : """
print(nombre1)
print(nombre2)

""" nombre1, nombre2 = 14, 46 est une syntaxe pas très lisible
parcequ'il n'y a pas de parenthèse. Dans ce cas on peut
considérer ces variables comme des tuples en mettant des
parenthèses et également autour des valeurs."""
(nombre1, nombre2) = (14, 46)
""" On peut faire ainsi une affection multiple.

Mais attention il s'agit d'un tuple, nous ne pourront pas
modifier la valeur. Ce qui est utile dans le cas
d'affection multiple mais pour des constantes."""

nombre1 = 128
print(nombre1)

""" Si on a un tuple en temps normal, on ne pourra pas
modifier mais dans le cas de l'affectation multiple, on
pourra faire des modifications car le tuple n'est pas
gérer comme une constante mais il serra gérer comme une
affectation multiple.
"""

#
#   (!) Tuple : conteneur immuable (dont on ne peut modifier les valeurs)
#   Sauf dans le cas d'une affection multiple où l'on peut changer la
#   valeur d'une variable.
#

#5# Retour multiple de fonction (2eme avantage)
#

""" L'affectation multiple est le premier avantage, la premier
utilité des tuples.  """

""" Un autre avantage que l'on ne retrouve pas dans d'autres langage
comme le C qui permettent de faire retourner des valeurs à des
fonctions, c'est de pouvoir faire un retour de fonction avec deux
valeurs. On peut retourner un tuple à une fonction plutôt que
de retourner qu'une valeur."""

#
#   En gros, 2 raisons d'utiliser les tuples :
#       affectation multiple de variable
#       retour multiple de fonction
#

""" Créons une fonction."""
def get_player_position():
   posX = 148
   posY = 86
   return posX, posY
""" On aurait pu faire de l'affectation multiple posX, posY.
return posX, posY est une chose impossible à faire en langage C.
"""

# Retourner un tuple.
""" On peut ainsi retourner un tuple."""
def get_player_position():
   posX = 148
   posY = 86
   return (posX, posY) # paranthèses recommandées.

""" posX et posY sont immuable car ils ne sont pas changés dans la
fonction. On récupère ces valeurs mais qui ne seront pas changé
dans la fonction. """

""" Comment récupérer ces valeurs ?
Retournons dans le programme principal ..."""

# Programme principal
coordX = 0
coordY = 0

print("Position du joueur : ({}/{})".format(coordX, coordY)) # utilisation de méthode des chaines de caractères : format().
coordX, coordY = get_player_position() # Retourner le résultat de la fonction sur coordX, coordY (comme si on faisait un tuple).
print("Position du joueur : ({}/{})".format(coordX, coordY))

""" On travaille toujours avec cet espèce de format de tuple.
Si on met les paranthèse, absolument aucune différence.
Il est recommandé de les mettre."""

(coordX, coordY) = get_player_position() # paranthèses recommandées.
print("Position du joueur : ({}/{})".format(coordX, coordY))

""" En mettant les parenthèses, on comprend bien qu'on retourne un tuple
avec la fonction get_player_position et qu'on récupère bien le résultat
dans un autre tuple (coordX, coordY)."""

coordX = 150
coordY = 150
print("Position du joueur : ({}/{})".format(coordX, coordY))

""" Il y a bien modification. Pour rappel, c'est une affectation
multiple. Dans une affection multiple, on peut modifier les valeurs.
Par contre si on crèe un tuple, il ne pourra pas être modifié.
On ne peut évidemment pas modifier car c'est immuable d'où
l'intérêt qu'il ne peut pas subir de modification. """

#6# Conclusion
#

"""
Les tuples sont des conteneur de type séquence comme les listes.
Nous en avons vu finallement deux. Les tuples sont fréquemment
utilisé pour ses avantages :

   affectation multiple de variable
   retour multiple de fonction
   
Ca aura été plus court que le contener des listes où l'on avait
beaucoup de méthodes à voir.
"""
```