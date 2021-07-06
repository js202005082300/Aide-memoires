# [18. Dictionnaires](https://www.youtube.com/watch?v=BYDJRsE-N5Y)

+ [Création de dictionnaire](#Création-de-dictionnaire)
+ [Accéder à un élément](#Accéder-à-un-élément)
+ [Ajout et modification](#Ajout-et-modification)
+ [Suppression](#Suppression)
+ [help](#help)

Bonjour à tous, vous êtes sur la séance numéro 18, on va continuer un petit peu avec les conteneurs et nous allons parler aujourd'hui des dictionnaires, d'accord, un autre type qui n'est pas séquentiel. Il ne s'agit pas comme ça d'une séquence qui va avoir un ordre précis mais complètement autre chose. 

Pour résumer rapidement, un dictionnaire en python c'est un peu comme une liste sauf que au lieu de fonctionner avec des indices dont notamment les index, comme on a vu avec des numéros de 0 jusqu à atteindre la fin de la liste. 

On va travailler directement avec des clés alors ceux qui font un peu de langages comme PHP, ce genre de chose, vous avez ce que l'on appelle les **tableaux associatifs**. 

Alors si vous connaissez ce langage là, vous connaissez les tableaux associatifs, Eh bien le dictionnaire c'est ça. En python ça ressemble un petit peu à ça, à ce fonctionnement là, de systèmes de clé et de valeurs qui sont associées. 

Donc on va regarder comme ça directement dans le code, voir ce que cela donne avec la pratique. Je vais vous montrer très rapidement parce que c'est encore une nouvelle syntaxe, vous savez que pour la liste, on avait les crochets, pour les tuples on avait les parenthèses et bien pour les dictionnaires, nous allons avoir les accolades. 

Voilà c'est une manière comme ça de bien les différencier tous les 3.

## Création de dictionnaire

La création d'un dictionnaire va se faire très simplement, alors on va l'appeler dico, je vais garder ce nom là parce que c'est assez clair. 
```py
    #coding:utf-8
    dico =
```
Et on va pouvoir créer un dictionnaire vide, en mettant des accolades de cette manière. 
```py
    #coding:utf-8
    dico = {}
```
Voilà, là on crée tout simplement un dictionnaire vide, alors je vais comme d'habitude vous mettre quelques petites notes. 
```py
    #coding:utf-8
    """
    Création de dictionnaire : dict
    """
    dico = {}
```
Alors la classe, c'est un objet de type ignorer dict. La classe c'est dict pour dictionary donc vous avez comme ça dictionnaire en python. 

Alors on peut tout simplement, je vais mettre ceci, dico = {} donc là il est vide. 
```py
    #coding:utf-8
    """
    Création de dictionnaire : dico = {} #Vide
    """
    dico = {}
```
Alors on va pouvoir remettre bien évidemment des valeurs donc moi je vais par exemple en mettre une seule et ça va se différencier d'une certaine manière c'est-à-dire que vous allez avoir la clé, vous allez mettre : et vous allez mettre la valeur. 

Si vous voulez en mettre plusieurs il faudra les séparer par des virgules. 

Bon à savoir aussi au niveau du dictionnaire, c'est que vous pouvez accepter absolument tous les types, ça peut être des chaînes de caractères, des entiers, d'autres types d'objets mais peu importe. 

Donc par exemple là je peux faire, la clé 1 : qui contient la valeur 145. Et ensuite je peux très bien mettre une virgule en disant que par exemple la clé prénom … alors ça n'a aucune logique, c'est complètement bizarre … on met ensuite : et contiendrait un prénom. 
```py
    #coding:utf-8
    """
    Création de dictionnaire : dico = {} #Vide
    """
    dico = {1:145, "prenom":"Jason"}
```
Oui, ce genre de chose, voilà ça c'était un exemple de dictionnaire qui n'est pas du tout … il n'y a pas de logique dedans mais c'est pour comprendre le système … vous avez des clés, vous avez des valeurs et donc à chaque clé sa valeur. 

C'est comme ça qu'on va fonctionner, vous allez voir tout du long, au niveau des accès, de la suppression, au niveau de tout ça. 

Donc vous pouvez ranger comme ça des informations alors il n'y a pas d'ordre, vous voyez qu'il n'y a pas une histoire où chaque chose est à sa place comme dans une liste, de l'indice 0 à 1, auquel on peut ajouter des éléments de la liste ou supprimer un élément en particulier. 

Là c'est vraiment tout un tas de trucs comme ça que l'on peut mettre avec cette association de clés : valeur donc ça c'est vraiment important à savoir. 

On va rester sur quelque chose comme ça tout simplement et je vais vous montrer comment ça peut fonctionner à ce niveau-là. 
```py
#coding:utf-8
"""
Création de dictionnaire : dico = {} #Vide
"""
dico = {1:145, "prenom":"Jason"}
```
Donc très simple, on peut faire une création de quelque chose de vide, on peut faire une création avec des éléments dedans donc je vais vous faire le commentaire ici.
```py
#coding:utf-8
"""
Création de dictionnaire : 	dico = {} #Vide
				dico = {<cle>:<valeur>, <cle2>:<valeur>}
"""
dico = {1:145, "prenom":"Jason"}
```
`dico = {<cle>:<valeur>, <cle>:<valeur>}` … Voilà ici on met une autre clé avec une autre valeur. Il n'y a vraiment pas un ordre spécifique dans les dictionnaires c'est pas parce que ici on l'a mis en début de dictionnaire que c'est avant, d'accord, ça n'a absolument rien à voir par rapport à ça. 

Il n'y a pas d'ordre, on va pouvoir accéder à n'importe quel élément d'où on veut en fait. 

Ça c'est pour la création.

## Accéder à un élément

Bien sûr si vous faites un parcours, il y a un début de dictionnaire et une fin de dictionnaire, c'est logique, mais voilà il n'y a pas forcément d'ordre à respecter à ce niveau là. 

Donc pour la création je vous ai montré comment ça fonctionnait, on va voir maintenant au niveau de l'accès, on va voir un peu comment ça se passe au niveau de l'accès. Comment est-ce qu'on va pouvoir accéder à un élément ? On va tout simplement faire un print() et vous allez mettre le nom du dictionnaire et entre crochets, vous allez mettre le nom de la clé. 

Si c'est comme ici une chaîne de caractères, il faudra mettre avec les doubles quotes, c'est important. On va tester.
```py
#coding:utf-8
"""
Création de dictionnaire : 	dico = {} #Vide
				dico = {<cle>:<valeur>, <cle2>:<valeur>}
"""
dico = {1:145, "prenom":"Jason"}

print(dico["prenom"])
```
```powershell
    >python main.py
    Jason
```
Vous voyez qu'il met bien la valeur automatiquement. 

Si j'avais eu parce que c'est tout à fait possible ça, 1:"Jason", on ne met pas les doubles quotes.
```py
#coding:utf-8
"""
Création de dictionnaire : 	dico = {} #Vide
				dico = {<cle>:<valeur>, <cle2>:<valeur>}
"""
dico = {1:"Jason"}

print(dico[1])
```
```powershell
    >python main.py
    Jason
```
On ne met pas les doubles quotes, c'est vraiment juste la clé donc ça c'est super important. 

On pourrait penser que toutes les clés se mettent avec des doubles quotes ou alors sans, non non c'est en fonction du type d'objet. N'oubliez pas qu'en python tout est objet. Une chaîne de caractères est un objet donc les doubles guillemets font partie de l'objet. 

Si vous mettez par exemple le mot sans les doubles guillemets, ce n'est plus une chaîne de caractères donc l'objet n'est plus pareil donc là c'est vraiment important de savoir ça. 

On peut accéder du coût de cette manière-là. 

Donc ici ça ne veut pas dire que j'accède à l'élément d'indice, ça veut dire que je accède à l'élément du dictionnaire qui porte la clé qui s'appelle 1. 

J'aurais pu mettre ceci, peu importe, on met ce que l'on veut.
```py
#coding:utf-8
"""
Création de dictionnaire : 	dico = {} #Vide
				dico = {<cle>:<valeur>, <cle2>:<valeur>}
"""
dico = {"name":"Jason"}

print(dico["name"])
```
```powershell
    >python main.py
    Jason
```
Peu importe évidemment c'est la même chose.

Donc ça c'est l'accès tout simplement au niveau d'un dictionnaire. Vous mettez ici, dico[--> <--], la clé dont vous voulez la valeur et donc ça va vous retourner la valeur puisque c'est l'intérêt surtout que c'est à partir d'une clé qu'on peut obtenir la valeur c'est pour ça qu'on parle dans d'autres langages de tableau associatif. 

Ici en python ils appellent cela, des dictionnaires, ça permet comme ça de retrouver des choses. 

On pourrait par exemple mettre ce genre de choses 
```py
#coding:utf-8
"""
Création de dictionnaire : 	dico = {} #Vide
				dico = {<cle>:<valeur>, <cle2>:<valeur>}
"""
dico = {"chat":"C'est un félin"}

print(dico["chat"])
```
```powershell
    >python main.py
    C'est un félin
```
Alors c'est un peu bisare "C'est un Félin" et voilà, c'est pour ça qu'on appelle cela un dictionnaire puisque ça rejoint tout à fait ça.

On aurait un mot par exemple et en cherchant le mot vous aurez sa définition. C'est pour ça qu'ils ont gardé ce terme là de dictionary pour ce type de conteneur. 

Donc ça au niveau de l'accès, vous voyez que c'est très facile, on met la clé et vous y accéder sans problème. 

Alors là par contre, on n'est pas comme dans les tuples, on ne peut rien ajouter et cetera, ce n'est pas du tout un conteneur immuable bien évidemment c'est comme pour les listes, on va pouvoir rajouter des choses, on va pouvoir changer des choses et également les supprimer. 

Pour faire de l'ajout, on va le noter ici.  
```py
    """
    Création de dictionnaire    : 	dico = {} #Vide
                                    dico = {<cle>:<valeur>, <cle2>:<valeur>}

    Accès à une valeur          :   dico[<cle>]
    """
```
Pour l'accès à une valeur, on fait dico[<cle>] et donc rappelez-vous quand je mets comme ça des petits chevrons, c'est pour dire qu'il faut le remplacer par quelque chose. C'est sûrement pas qu'il faut l'écrire de cette manière, <cle>.  C'est pour vos notes après vous en faites ce que vous voulez, voilà.

## Ajout et modification

Après on va avoir l'ajout au dictionnaire. 
```py
    """
    Création de dictionnaire    : 	dico = {} #Vide
                                    dico = {<cle>:<valeur>, <cle2>:<valeur>}

    Accès à une valeur          :   dico[<cle>]
    
    Ajout au dictionnaire       :
    """
```
Pour ajouter quelques c'est très simple vous avez 2 possibilités. 

Par exemple ici j'ai chat donc pas de soucis, alors on va faire `dico["chien"]` et on dit d'ajouter la clé chien, d'accord. 
```py
    dico["chien"]
```
Et là vous faites comme une affectation pour une variable, d'accord, vous dites dans le dictionnaire à la clef chien, tu vas mettre c'est un mammifère, le meilleur ami de l'homme parce que c'est une expression qui est souvent reprise, et là comme ça vous allez pouvoir l'ajouter. 
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]

Ajout au dictionnaire       :
"""

dico = {"chat":"C'est un félin"}

dico["chien"] = "C'est un mammifère, le meilleur ami de l'Homme"

print(dico)
```
Et là comme ça vous allez pouvoir l'ajouter, et là 2 possibilités, soit la clé chien existe déjà dans le dictionnaire et il va se passer une modification, logique d'accord. On va modifier la valeur dans le dictionnaire où le contenu à la clé chien et si il n'y a pas elle va tout simplement être ajoutée. 
```powershell
    >python main.py
    {'chat': "C'est un félin", 'chien': "C'est un mammifère, le meilleur ami de l'Homme"}
```
Et là il n'a pas bronché, voilà. 

Là vous voyez qu'il a bien ajouté chacun des éléments, l'un à la suite de l'autre, voyez un petit peu comme il l'a fait, tel qu'on avait représenté la création. Il a bien mis `<cle>: <valeur> , <cle>:<valeur>` même si dans une phrase, il y a une virgule dedans, il a bien mis les doubles guillemets pour le différencier. Ici là, fait partie de la chaîne de caractère.

Comme ça ici on peut directement gérer les éléments en ajout ou bien en modification  parce que très vite par la suite, je peux sans problème refaire ceci et je enlève le texte pour mettre autre chose, "ddd"
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]

Ajout au dictionnaire       :
"""

dico = {"chat":"C'est un félin"}

dico["chien"] = "C'est un mammifère, le meilleur ami de l'Homme"
print(dico)

dico["chien"] = "ddd"
print(dico)
```
```powershell
    >python main.py
    C'est un félin
    {'chat': "C'est un félin", 'chien': "C'est un mammifère, le meilleur ami de l'Homme"}
    {'chat': "C'est un félin", 'chien': 'ddd'}
```
Et là évidemment le texte aura changé.

C'est de l'ajout mais de la modification si l'élément existe donc ça c'est important à savoir.

Voilà on va mettre, `dico[<cle>] = <valeur>`.
```py
    """
    Création de dictionnaire    : 	dico = {} #Vide
                                    dico = {<cle>:<valeur>, <cle2>:<valeur>}

    Accès à une valeur          :   dico[<cle>]

    Ajout au dictionnaire       :   dico[<cle>] = <valeur>
    """
```
Voilà, ça ça me paraît suffisamment clair à ce niveau-là par rapport aux exemples que je vous ai donné. On va maintenant enlever tout ça pour rendre le code un peu plus lisible.
```py
    #coding:utf-8

    """
    Création de dictionnaire    : 	dico = {} #Vide
                                    dico = {<cle>:<valeur>, <cle2>:<valeur>}

    Accès à une valeur          :   dico[<cle>]

    Ajout au dictionnaire       :   dico[<cle>] = <valeur>
    """

    dico = {"chat":"C'est un félin"}
```
Voilà, comme ça vous avez tout ce qu'il faut à ce niveau-là. 

Très simple, vous avez vu l'ajout et la modification, très facile à ce niveau-là. Je peux vous montrer la suppression tant qu'a faire, on a qu'a voir les opérations un petit peu basique. d'ailleurs ici je devrais mettre "Ajout et modification" pour être exacte.
```py
    #coding:utf-8

    """
    Création de dictionnaire    : 	dico = {} #Vide
                                    dico = {<cle>:<valeur>, <cle2>:<valeur>}

    Accès à une valeur          :   dico[<cle>]

    Ajout et modification       :   dico[<cle>] = <valeur>
    """

    dico = {"chat":"C'est un félin"}
```

## Suppression

Et là on va faire du coup "Suppression" tout court parce que ça va supprimer de toute façon tout. Quand vous allez faire la suppression, vous allez avoir plusieurs possibilités que je vais vous mettre ici. 
```py
    #coding:utf-8

    """
    Création de dictionnaire    : 	dico = {} #Vide
                                    dico = {<cle>:<valeur>, <cle2>:<valeur>}

    Accès à une valeur          :   dico[<cle>]

    Ajout et modification       :   dico[<cle>] = <valeur>
    
    Suppression                 :
    """

    dico = {"chat":"C'est un félin"}
```
Pour la suppression je vous propose d'ailleurs 2 choses, je vous propose d'abord une méthode des dictionnaires qui est très utile. Je rappelle comme tout objet, pour toute classe python, vous pouvez utiliser la petite commande help(dict) de dict si vous vérifiez le type avec la fonction type(), vous verrez qu'il va vous le donner.
```powershell
    >python
    Python 3.8.5 (tags/v3.8.5:580fbb0, Jul 20 2020, 15:57:54) [MSC v.1924 64 bit (AMD64)] on win32
    Type "help", "copyright", "credits" or "license" for more information.
    >>> help(dict)
```
Et là automatiquement vous voyez qu'on a un petit peu de tout, vous voyez clear(), copy(), enfin on retrouve un petit peu pas mal de choses notamment qu'on a pu voir avec les listes donc je ne vais pas tous vous les représenter encore une fois. On ne va pas tout refaire à chaque fois parce qu'il y a quand même pas mal de conteneurs sinon vous allez toujours avoir la même chose dans les vidéos mais on va en avoir quelques-uns quand même, quelques méthodes de toute manière puisqu'il y en a qui vont être effectivement utiles. 

Donc au niveau de cette suppression, moi je vous propose soit par méthode d'accord, et si je vais rajouter autre chose à mon dictionnaire dico sinon ça ne va pas faire beaucoup en ajoutant simplement ce qu'on avait tout à l'heure, et on va l'afficher, faire un premier affichage. 
```py
    #coding:utf-8

    """
    Création de dictionnaire    : 	dico = {} #Vide
                                    dico = {<cle>:<valeur>, <cle2>:<valeur>}

    Accès à une valeur          :   dico[<cle>]

    Ajout et modification       :   dico[<cle>] = <valeur>
    
    Suppression                 :
    """

    dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}
    
    print(dico)
    
    
    
    print(dico)
```
Et ensuite on va faire un 2e affichage à la suite.

Et là on va tout simplement faire dico.pop(), donc on utilise la méthode pop() et elle prend en paramètre bien évidemment la clé donc ici c'est une chaîne de caractères donc je mets bien des doubles guillemets et voilà. 
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]

Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}
print(dico)

dico.pop("chien")
print(dico)
```
```powershell
    >python main.py
    {'chat': "C'est un félin", 'chien': "Le meilleur ami de l'Homme"}
    {'chat': "C'est un félin"}
```
D'accord, vous voyez que l'élément a bien été supprimé complètement du dictionnaire.

Alors petite information intéressant au niveau de pop(), c'est que vous pouvez récupérer la valeur supprimée par exemple donc on fait. 
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]

Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}
print(dico)

valeur_supprimee = dico.pop("chien")
print(valeur_supprimee)
```
```powershell
    >python main.py
    {'chat': "C'est un félin", 'chien': "Le meilleur ami de l'Homme"}
    Le meilleur ami de l'Homme
```
Ça peut être pratique lorsqu'on fait des manipulations et vous voyez qu'il récupère la valeur que vous avez sous la main. Il ne récupère pas la clé évidemment, vous ne récupérez que la valeur. 

Donc la méthode pop() retourner en fait la valeur de ce que vous avez retiré du dictionnaire  donc c'est important à savoir, ça peut être utile dans certains cas donc je voulais vous en parler ici comme ça au moins vous le saurez donc ça c'est la première possibilité. 

Vous faites `dico.pop(<cle>)` et là vous aurez la première possibilité.
```py
    """
    Création de dictionnaire    : 	dico = {} #Vide
                                    dico = {<cle>:<valeur>, <cle2>:<valeur>}

    Accès à une valeur          :   dico[<cle>]

    Ajout et modification       :   dico[<cle>] = <valeur>

    Suppression                 :   dico.pop(<cle>)
    """
``` 
Et là vous devez donc mettre la clé, voilà, la clé pour la valeur à supprimer bien évidemment sinon l'autre possibilité que l'on connaît bien c'est d'utiliser `del dico[<cle>]` et là vous mettez la clé comme ceci. 
```py
    """
    Création de dictionnaire    : 	dico = {} #Vide
                                    dico = {<cle>:<valeur>, <cle2>:<valeur>}

    Accès à une valeur          :   dico[<cle>]

    Ajout et modification       :   dico[<cle>] = <valeur>

    Suppression                 :   dico.pop(<cle>)
                                    del dico[<cle>]
    """
```
del, vous vous rappelez, del, c'est un terme de Python, c'est une expression de Python, d'accord. C'est une expression de python qui fonctionne partout qui permet tout simplement de supprimer. 

Donc au lieu de faire dico.pop(), on va faire del dico["chat"] et entre crochets, on va mettre que l'on va supprimer le chat. 
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]

Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}
print(dico)

del dico["chat"]
print(dico)
```
```powershell
    >python main.py
    {'chat': "C'est un félin", 'chien': "Le meilleur ami de l'Homme"}
    {'chien': "Le meilleur ami de l'Homme"}
```
Voilà automatiquement on a bien enlevé l'élément chat du dictionnaire, c'est bon pas de problème aussi. 

Donc c'est une autre syntaxe, vous pouvez employer celle-là même si moi en général j'utilise plutôt les méthodes pop() puisqu'elles sont là, autant s'en servir mais c'est vrai que vous avez vu l'instruction del, elle fonctionne dans pas mal de choses. On peut vraiment l'utiliser même pour des attributs de classe, c'est quand même assez pratique  donc c'est à savoir, c'est vraiment à connaître cette expression puisqu'elle est utile vraiment dans de nombreux cas. 

Voilà pour la suppression, voilà surtout pour les opérations de base, tout ce qui est création, ajout, modification, suppression, voilà c'est la base de tout conteneur. 

Voilà ce que je voulais vous montrer, comme ça on va pouvoir passer à la suite par rapport aux petites notes que j'ai à vous montrer. 

On peut avoir la possibilité de vérifier si une clé existe, l'existence d'une clé dans un dictionnaire donc moi ici je vais le mettre dans un print(), ça va afficher True ou False si il ne la trouve pas. 

Et on peut faire `dico.has_key()` c'est à dire la méthode has_key() si je ne me trompe pas … je pense qu'il y a un underscore il me semble … et ensuite vous cherchez, est-ce qu'il existe la clé chien dans votre dictionnaire. 
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]

Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}
print(dico.has_key("chien"))
```
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 493, in <module>
        print(dico.has_key("chien"))
    AttributeError: 'dict' object has no attribute 'has_key'
```
(!) Voilà l'alternative `if <clé> in dico:`.

Voilà en tout cas, il y avait une méthode has_key() qui permettait de retourner à bouléen pour dire éventuellement si ça existait mais à la rigueur maintenant si je voulais vérifier que ça existe. Moi ce que je ferais `if "chien"` … ouais le problème c'est qu'il va chercher la valeur … `in dico: print("Oui"), else: print(non "Non")` pour dire est-ce que le chien se trouve dans le dictionnaire et apparemment il va le trouver.
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]

Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}

if "chien" in dico:
   print("Oui")
else:
   print("Non")
```
```powershell
    >python main.py
    Oui
```
Bon écoutez, il le trouve donc ça fonctionne donc vous pouvez vérifier comme ça. C'est peut-être pour ça qu'ils ont enlevé la méthode, ils ont vu que c'était pas nécessaire avec python 3 parce que de toute manière on peut le faire comme ça avec un simple in, la vérification, comme vous avez vu pour les listes, pour les séquences, ça fonctionne. 

Donc vous faites simplement ça donc ne faites pas attention à ce que je vous ai dit pour le has_key(), voilà je vous dis que j'avais un petit trou de mémoire c'est assez rare mais ça arrive, ça arrive à tout le monde. 

Donc voilà il n'y a plus de méthode, vous faites simplement ça, une petite condition pour vérifier si la clé existe dans le dictionnaire et ça vous permet de vérifier l'existence d'une clé ou non okay donc ça c'est très très pratique du coup, c'est bien à savoir.

Donc il n'y a plus de méthode, on le fait directement dans un IF, ça permet d'éviter d'avoir des méthodes entre guillemets, qui ne sont pas forcément utiles puisqu'on peut le faire dans une simple condition alors que ce genre de méthode on les utilise généralement dans une simple condition aussi donc voilà ils ont vraiment raccourci les possibilités. 

Par contre ça c'est sûr que ça existe encore bien évidemment, on peut faire du parcours c'est à dire qu'on va pouvoir parcourir tout ce que l'on va retrouver, okay. 

Notamment un parcours sur les clés, un parcours sur les valeurs, un parcours sur pas mal de choses. Vous avez par exemple votre dico ici et on peut ensuite utiliser la boucle for que vous connaissez bien et on va faire tout simplement `for key in dico:`. Et là vous allez afficher la clé, `print(key)`. 
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]

Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}

for key in dico:
   print(key)
```
```powershell
    >python main.py
    chat
    chien
```
Voilà on va afficher la clé et là donc ça vous affiche toutes les clés. 

Ensuite il me semble qu'il existe encore une méthode keys() si ça ne vient pas du python 2. Cette méthode keys() qui permettait de retourner les clés, logiquement c'est la même chose.
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]

Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}

for key in dico.keys():
   print(key)
```
```powershell
    >python main.py
    chat
    chien
```
Voilà, éffectivement c'es la même chose.

## help

En plus, je l'avais vu tout à l'heure dans le help() donc ça me semblait être ça.

Peut être qu'un jour, il enleveront cette méthode parce que voyez qu'en mettant juste le nom du dictionnaire, ça retourne les clés par défaut.

Par contre ce qui est intéressant, c'est qu'on peut ... alors je change le nom ici, key devient truc, je peut appeler ça truc, c'est exactement la même chose ... ainsi, je ne voudrait pas que les gens s'embrouille ... et là, on peut également retourner les valeurs en mettant la méthode values() même si ça ne valait pas la peine de changer le nom de la variable en fait.
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]
Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}

for truc in dico.values():
   print(truc)
```
```powershell
    >python main.py
    C'est un félin
    Le meilleur ami de l'Homme
```
Et là on a un parcours sur toutes les valeurs du dictionnaire donc là effectivement l'ordre est important ... enfin oui, non parce que vous voyez qu'il parcours dans l'ordre du dictionnaire, du premier élément jusqu'au dernier.

Pour dire qu'il n'y a pas forcément une place, il n'y a pas forcément besoin de trier. On ne va pas trier un dictionnaire d'accord, ça se ne fait pas du tout. On va trier une liste mais un dictionnaire n'est pas fait pour être trier. Un dictionnaire, si on a besoin d'un élément, on renseigne la clé et il va nous donner sa valeur. On ne va pas s'amuser à trier par ordre alphabétique un dictionnaire, ça n'a absolument ici aucun intéret même si le terme dictionnaire, voilà suivant le terme en lui-même, on sait que c'est rangé par ordre alphabétique dans un livre. Voilà c'est un peu particulier donc là, on ne cherche pas forcement à avoir un ordre précis.

On peut donc utiliser le mot values() mais on peut aussi bien sûr avoir les deux valeurs, k et v, rappelez vous comme on avait fait avec le enumerate() comme pour les listes où là il faut utiliser la méthode items().
```py
    dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}

    for k,v in dico.items():
        print(...)
```
Et on peut du coup print() ceci, on va utiliser format().
```py
    print("Clé {} - Valeur {}".format(k, v))
```
Et voilà.
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]
Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}

for k,v in dico.items():
   print("Clé : {} - Valeur : {}".format(k, v))
```
```powershell
    >python main.py
    Clé : chat - Valeur : C'est un félin
    Clé : chien - Valeur : Le meilleur ami de l'Homme
```
Voilà on peut comme ça avoir séparemment la clé et la valeur donc très pratique, voilà, même si en général en faisant simplement un parcours des clés, vous pouvez du coup avoir les valeurs, ce qui est logique mais c'est bien de savoir qu'il y a cette petite méthode items() qui permet du coup de récupérer à la fois les clés et les valeurs dans un variable.

D'ailleurs je rappelle que ça, (k, v), pour ceux qui se poserait la question, c'est un tuple.
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]
Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}

for (k,v) in dico.items():
   print("Clé : {} - Valeur : {}".format(k, v))
```
```powershell
    >python main.py
    Clé : chat - Valeur : C'est un félin
    Clé : chien - Valeur : Le meilleur ami de l'Homme
```
Par rapport à ce qu'on a vu précedemment, c'est un tuple.

C'est pour ça que je ne met pas les parenthèses, c'est une question d'habitude mais c'est vrai que je vous recommande de les mettre si possible.

Voyez que générallement des variables comme ça séparé par une virgule, c'est que à priori c'est un tuple donc au pire vous tester, vous mettez des parenthèses et si vous que ça plante, c'est que ce n'est pas un tuple et si ça marche c'est que s'en est un.
```
    (k, v)
```
Voilà, pas de problème à ce niveau-là.

Je vais les enlever parce que c'est assez rare qu'on les mettent dans une boucle for.
```py
    dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}

    for k,v in dico.items():
        print("Clé : {} - Valeur : {}".format(k, v))
```
C'est selon les habitudes de chacuns, chacuns fait comme il veut mais voilà vous êtes de programmer, d'ecrire votre syntaxe comme vous voulez du moment que ça fonctionne. C'est que là-dessus, vous faite vraiment comme vous voulez. Je ne vais pas vous dire qu'ne méthode est mieux qu'une autre.

Chacun fait comme il le sent, question de confort, question d'habitude.

Donc ça c'était au niveau des vérifications, au niveau parcours.

On peut évidement ... parce que j'aime bien parler de la gestion des erreurs, on levé IndexError pour les listes, on peut avoir éventuellement des erreurs pour les tuples. Et pour les dictionnaires, on peut avoir une erreur de clé, on peut avoir une KeyError par exemple s'il ne trouve pas quelque chose.

Notamment si on fait print() de dico[] de "ok", genre quelque chose qui aurait la clé OK, print(dico["ok"]).
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]
Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}

print(dico["ok"])
```
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 728, in <module>
        print(dico["ok"])
    KeyError: 'ok'
```
Donc là vous voyez qu'il me met une KeyError donc pareil en faisant un petit try et en faisant un except sur KeyError, vous pouvez gérer du coup l'érreur à ce moment là.

Toujours pareil, ne partez pas du principe que si vous voulez afficher la valeur du dictionnaire, elle existe forcément. Il y a toujours un risque qu'elle n'existe pas donc faite cela dans un blok try/except et donc comme ça vous êtes transquille donc ça c'était la petite parenthèse "gestion des erreurs" qui est quand même importante en informatique.

Donc voilà j'ai quand même fait pas mal le tour, on a vu toutes les opérations de bases, on vu tout ce qui est parcours donc on a vu du coup pour vérifier si une clé existe même si effectivement il n'y a plus de méthode avec Python 3 et les versions ultérieurs.

Et je peux vous montrer également de petites fonctions rapides, on va voir notamment tout ce qui est copie surtout au niveau des fonctions pour passer des dictionnaires c'est-à-dire des paramètres nommés dans les fonctions, ça je vais vous en parler un petit peu aussi et on terminera là-dessus.

Donc petite chose déjà à savoir, pareil je vous l'ai dit tout à l'heure, on niveau des clé quand je dit que je peut avoir un petit peu tout est n'importe quoi, c'est vraiment tout est n'importe quoi, vous pouvez même mettre un tuple.

Voilà la clé d'un dictionnaire peut être un tuple, c'est éffectivement fonctionnel, on peut avoir sans problème dico[(2, 3)], ce genre de truc, avec quelque chose. C'est complétement inutile.
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]
Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}

dico[(2, 3)] = "ok"
print(dico)
```
```powershell
    >python main.py
    {'chat': "C'est un félin", 'chien': "Le meilleur ami de l'Homme", (2, 3): 'ok'}
```
Voilà ça fonctionne bien que inutile, c'est indispensable.
C'est bien à savoir quand je dit que c'est n'importe quel objet.
N'importe quel objet, le tuple est un objet en Python, la liste est un objet en Python, vous pouvez mettre une liste comme clé au niveau d'un dictionnaire aussi.
On peut vraiment s'amuser avec un peu tout et n'importe quoi.

Pour la copie de dictionnaire, vous savez que je vous avais expliqué comme ça quand par exemple vous dites que vous affectez la valeur d'une variable, il va y avoir une copie de la valeur qui va être faite donc ça va fonctionner par contre vous ne pouvez pas faire dico2 = dico.
```
    dico2 = dico
```
On ne peut pas faire ça, si je fait admettons dico["ok"] = "ok"
```
    dico["ok"] = "ok"
```
Donc je vais afficher les deux dictionnaires, normallement on voudrait que dico2 soit une copie c'est à dire qu'il a exactement les mêmes éléments et après du coup, on a deux dictionnaires indépendants c'est à dire que ici, dico[(2, 3)] = "ok", j'ajoute dans le premier cette clé, cette valeur donc logiquement nous on ne veut pas qu'il ajoute dans le deuxième...
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]
Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}
dico2 = dico

print(dico)
print(dico2)

dico[(2, 3)] = "ok"

print(dico)
print(dico2)
```
```powershell
    >python main.py
    {'chat': "C'est un félin", 'chien': "Le meilleur ami de l'Homme"}
    {'chat': "C'est un félin", 'chien': "Le meilleur ami de l'Homme"}
    {'chat': "C'est un félin", 'chien': "Le meilleur ami de l'Homme", (2, 3): 'ok'}
    {'chat': "C'est un félin", 'chien': "Le meilleur ami de l'Homme", (2, 3): 'ok'}
```
Le problème c'est qu'ici, il la ajouté dans les deux dictionnaires parce qu'encore une fois comme je l'avais expliquer pour d'autres conteneurs, ici dico2 = dico, il ne crée pas une copie, en fait il fait une référence au premier dictionnaire et d'ailleurs, on parlera de la référence un peu plus tard dans cette formation. Là je vous dis juste le terme mais on va en parler un peu plus tard dans cette formation.

Il y a une référence c'est à dire qu'en fait c'est le dictionnaire numéro 2 qui est véritablement le dictionnaire numéro 1, c'est juste qu'en fait il y a deux noms pour pouvoir y accéder, dico ou dico2.

Vous avez du coup deux variables qui permettent d'accéder à la même chose donc forcément lorsque vous ajouté à dico, c'est comme si vous aviez fait la même chose à dico2 donc automatiquement vous navez pas deux dictionnaires en fait, vous n'en avez qu'un seul.

Là dans mon programme, je n'ai qu'un seul dictionnaire, on pourrait penser que j'en ai deux mais non je n'en je n'en ai qu'un seul.

Si par contre je veux vraiement obtenir une copie, il faut tout simplement utiliser la méthode copie c'est à dire qu'ici vous faites:
```
    dico2 = dico.copy()
```
Et je crois que ça ne prend pas de paramètre et pas besoin de faire un petit import, il le prend comme ça.
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]
Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}
dico2 = dico.copy()

print(dico)
print(dico2)

dico[(2, 3)] = "ok"

print(dico)
print(dico2)
```
```powershell
    >python main.py
    {'chat': "C'est un félin", 'chien': "Le meilleur ami de l'Homme"}
    {'chat': "C'est un félin", 'chien': "Le meilleur ami de l'Homme"}
    {'chat': "C'est un félin", 'chien': "Le meilleur ami de l'Homme", (2, 3): 'ok'}
    {'chat': "C'est un félin", 'chien': "Le meilleur ami de l'Homme"}
```
Ca va il le prend comme ça, c'est pour deepcopy() qu'il faut faire un import, qui faut des fois importer un module mais ça, vous voyez automatiquement que ça a bien ajouté au dictionnaire 1 (dico) par contre le 2, on ne l'a pas ajouté.

Donc à partir de là, on a véritablement une copie qui est faites du premier dictionnaire et là j'ai bien deux dictionnaire dans mon programme à ce moment-là.
```py
    dico = {"chat":"C'est un félin", "chien":"Le meilleur ami de l'Homme"}
    dico2 = dico.copy()
```
Donc ça c'est important, vraiment à retenir, ici c'est pas comme une variable, on peut pas dire dico2 = dico sinon vous faites une référence en fait et vous travailler sur le même dico et non pas sur un nouveau dictionnaire en fait qui est la copie du premier.

Donc ça c'est à retenir, voilà pour la copie, ça c'était important.

Donc je peux encore une fois, vite fait de le noter mais encore une fois ça parait simple.
```py
    """
    Création de dictionnaire    : 	dico = {} #Vide
                                    dico = {<cle>:<valeur>, <cle2>:<valeur>}

    Accès à une valeur          :   dico[<cle>]
    Ajout et modification       :   dico[<cle>] = <valeur>

    Suppression                 :   dico.pop(<cle>)
                                    del dico[<cle>]
                                    
    Copie de dictionnaire       :   dico1 = {1:11, 2:22}
    """
```
`dico1 = {1:11, 2:22}` et après on va avoir carrément dico2 = dico1.copy(), voilà donc ça c'est important.
```py
    """
    Création de dictionnaire    : 	dico = {} #Vide
                                    dico = {<cle>:<valeur>, <cle2>:<valeur>}

    Accès à une valeur          :   dico[<cle>]
    Ajout et modification       :   dico[<cle>] = <valeur>

    Suppression                 :   dico.pop(<cle>)
                                    del dico[<cle>]
                                    
    Copie de dictionnaire       :   dico1 = {1:11, 2:22}
                                    dico2 = dico1.copy()
    """
```
`dico2 = dico1.copy()`, voilà ça c'est important pour avoir la copie et on va terminer cette petite séance avec les paramètres nommées dans une fonction. Vous avez déjà vu quand on parlé des fonctions, je vous avait montré par exemple.
```py
    def mafonction(nom, age):
        pass
```
C'est très recherché comme nom de fonction avec nom, age, ce genre de chose et je met pass.

Ainsi on pouvait faire un appel en passant ce genre de chose en disant que tu passe age=14 et puis tu passe nom="Toto", voilà ce genre de chose.
```py
    def mafonction(nom, age):
        pass
        
    maFonction(age=14, nom="Toto")
```
Donc ça ce sont des paramètres nommé, étonnament ça rappelle assez bien les dictionnaires, voyez que là, age=14, on a pas les deux points, on a le symbole = mais ça rappelle un peu cette histoire de clé/valeur. La clé ce serait âge et la valeur 14, la clé nom et la valeur Toto.

Donc automatiquement, on va pouvoir passer des paramètres nommés à une fonction par contre il va y avoir une petite particularité, on va pas s'amuser à mettre pleins de variables en paramètres.
```py
    nom, age
```
On va en mettre qu'une seule, tout simplement, on va mettre qu'un seul paramètre donc je vais faire.
```py
    def maFonctionBizarre(**)
```
Et donc on a mis deux étoiles **, rappelez vous, une étoile * c'était pour un nom de variable en paramètre et si vous en mettez deux **, c'est simplement pour des paramètres nommés.

Par exemple, on mettre **parametres.
```py
    def maFonctionBizarre(**parametres):
```
Et puis là, bien évidemment, on pourrait les afficher, on pourrait faire un print() de paramètres.
```py
    def maFonctionBizarre(**parametres):
        print(parametres)
``` 
Et pour l'appel, vous allez faire simplement maFonctionBizarre() et vous allez lui mettre tout et n'importe quoi.
```py
    def maFonctionBizarre(**parametres):
        print(parametres)   

    maFonctionBizarre()
```
On va mettre 1=154, on peut faire "ok" = "blabla" ce genre de chose.
```py
##coding:utf-8
#
#"""
#Création de dictionnaire    : 	dico = {} #Vide
#                                dico = {<cle>:<valeur>, <cle2>:<valeur>}
#
#Accès à une valeur          :   dico[<cle>]
#Ajout et modification       :   dico[<cle>] = <valeur>
#
#Suppression                 :   dico.pop(<cle>)
#                                del dico[<cle>]
#"""
#
#def maFonctionBizarre(**parametres):
#    print(parametres)   
#
#maFonctionBizarre(1=154, "ok" = "blabla")
```
```powershell
    >python main.py
      File "main.py", line 960
        maFonctionBizarre(1=154, "ok" = "blabla")
                          ^
    SyntaxError: expression cannot contain assignment, perhaps you meant "=="?
```
Alors pourquoi es qu'il ne veux pas le prendre ? Attendez, on va mettre des noms, c'est parce qu'il veut des noms.
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]
Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

def maFonctionBizarre(**parametres):
   print(parametres)   

maFonctionBizarre(p=154, nom = "blabla")
```
```powershell
    >python main.py
    {'p': 154, 'nom': 'blabla'}
```
p=154, nom = "blabla", il ne veut pas non plus n'importe quoi non plus parce qu'on est pas non plus dans un dictionnaire, on passer des paramètres à une fonction, voilà.

Vous devez mettre des noms voilà j'avais confondu.

Donc il faut passer des noms comme des noms de variables en respectant les règles, pas de chiffres ou de truc bizarre. Vous mettez en valeur un peu n'importe quoi et automatiquement, voyez il vous produit un dictionnaire.

Les paramètres ici sont un dictionnaire automatiquement avec les éléments que vous avez mis donc c'est pratique ça permet de faire pas mal de petite chose.

Et après quand c'est un dictionnaire vous pouvez faire tous les traitements qu'on connaît dessus, de la copie, de la recherche, de la vérification de clé, de la modification, de la suppression, bref tout un tas de choses sympas donc ça c'était vraiment à connaître au niveau des paramètres nommés.

def maFonctionBizarre(**parametres) .. Donc ça c'est une fonction, pour le terme avec paramètre nommé. On la reconnaît avec les 2 étoiles ** juste avant le nom du paramètre. 

Si vous voyez une étoile *paramètres, c'est des paramètres variables, une quantité de paramètres qui peut être variable, on peut en avoir 1 ou 10 peu importe et quand vous avez 2 étoiles **, c'est que les paramètres doivent être obligatoirement nommé c'est-à-dire que si je fais 154, "ok" comme ceci.
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]
Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

def maFonctionBizarre(**parametres):
   print(parametres)   

maFonctionBizarre(154, "ok")
```
```powershell
    >python main.py
    {'p': 154, 'nom': 'blabla'}
    Traceback (most recent call last):
      File "main.py", line 1022, in <module>
        maFonctionBizarre(154, "ok")
    TypeError: maFonctionBizarre() takes 0 positional arguments but 2 were given
```
Là évidemment il ne va pas être content. Il ne trouve aucun paramètre nommé puisque vous avez rien nommé du tout ici lors de l'appel.
```py
    maFonctionBizarre(154, "ok")
```
À partir du moment où je vais faire ça p=154, "ok".
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                               dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]
Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                               del dico[<cle>]
"""

def maFonctionBizarre(**parametres):
   print(parametres)   

maFonctionBizarre(p=154, "ok")
```
```powershell
    >python main.py
      File "main.py", line 1054
        maFonctionBizarre(p=154, "ok")
                                 ^
    SyntaxError: positional argument follows keyword argument
```
Ici c'est la même chose, vous voyez que le premier il a trouvé et le 2e, ça pose problème parce qu'il y a un truc tout seul il peut pas faire grand chose. Et automatiquement voilà, on enlève et on en met un autre p=154.
```py
#coding:utf-8

"""
Création de dictionnaire    : 	dico = {} #Vide
                                dico = {<cle>:<valeur>, <cle2>:<valeur>}

Accès à une valeur          :   dico[<cle>]
Ajout et modification       :   dico[<cle>] = <valeur>

Suppression                 :   dico.pop(<cle>)
                                del dico[<cle>]
"""

def maFonctionBizarre(**parametres):
    print(parametres)   

maFonctionBizarre(p=154)
```
```powershell
    >python main.py
    {'p': 154}
```
Alors là on a un dictionnaire qui n'a qu'un seul élément mais ça reste un dictionnaire quand même et donc voilà je pense qu'on a fait le tour. 

Alors ce qu'il faut retenir, c'est un petit peu ce que je vous ai mis là alors oublié encore une fois la méthode ascii qui n'existe plus sur les nouvelles versions python. Si vous travaillez avec python 2 et cetera, vous l'avez donc c'est différent et comme je vous ai conseillé de travailler en python 3 pour cette formation et plus pour être à jour à ce niveau là, vous faites un effet ça fonctionne. 

Petite précision aussi en bonus mais ça je pense que vous l'aviez compris, au niveau d'un tableau, les clés sont uniques, vous ne pouvez pas avoir un dictionnaire avec des clés identiques. C'est ce qui permet de retrouver les choses parce que si vous avez 2 clés pareil et que dès que vous allez vouloir accéder à un élément, l'interpréteur python ne sera pas quel élément affiché par contre les valeurs et ça paraît logique, vous pouvez avoir plusieurs fois les mêmes valeurs. Ça pose aucun souci. 

Les clés sont vraiment uniques, c'est comme pour un dictionnaire, vous n'allez pas avoir 2 fois le même mot dans le dictionnaire, ça n'aurait absolument aucun intérêt. Donc les clés sont vraiment uniques, après les valeurs, on peut avoir les mêmes valeurs il n'y a aucun souci. 

Voilà j'ai fait un peu le tour de tout, en tout cas tout ce qui était important à savoir, encore une fois la petite fonction help() peut aider à trouver d'autres méthodes si vous voulez vous renseigner sur la méthode clear() et cetera si ça peut vous servir. 

Dans tous les cas, c'est sympa à utiliser, je pense qu'on a fait pas mal de petites choses. 

On continuera la prochaine fois pour de nouvelles aventures avec ce langage python j'espère que vous apprenez beaucoup beaucoup de choses et que maintenant vous commencez à voir des choses avancées, on a largement passé l'étape des basiques dans un langage et là on rentre dans des notions un peu plus avancées. 

N'hésitez pas si vous avez des commentaires parce que je sais que des fois je vais un petit peu vite et que les vidéos sont un peu longues, on va néanmoins beaucoup de choses mine de rien même sur des vidéos un peu longue donc si vous avez des questions et des choses qui ne sont pas forcément très claires, des programmes qui ne marchent pas comme toujours, vous passez par le site pastebin.

https://pastebin.com/

Vous faites un copier coller de votre code, vous me le montrer en commentaire et puis moi je peux vous aiguiller, vous aider pour corriger, pour voir ce qui ne va pas et comme ça vous avancez tranquillement, et ça vous permet aussi de progresser de pas rester sur des difficultés. 

À très bientôt tout le monde on se retrouvera du coup pour la séance numéro 19. 

À bientôt