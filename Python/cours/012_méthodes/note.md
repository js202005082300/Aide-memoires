# [12. Méthodes](https://www.youtube.com/watch?v=B-OlnwpVBN4)

+ [Définir une classe](#Définir-une-classe)
    + [Définir le constructeur](#Définir-le-constructeur)
    + [Définir des attributs](#Définir-des-attributs)
    + [Créer une instance de classe](#Créer-une-instance-de-classe)
+ [Définir une méthode simple - méthode d'instance](#Définir-une-méthode-simple---méthode-instance)
    + [Récupérer le retour de fonction dans une variable](#Récupérer-le-retour-de-fonction-dans-une-variable)
+ [Définir une méthode de classe](#Définir-une-méthode-de-classe)
+ [Définir une méthode statique](#Définir-une-méthode-statique)
+ [Resume](#Resume)

Bonjour à tous et bienvenue pour votre séance numéro 12, vous êtes sur la formation en langage python.

La dernière fois, nous avions vu les classes et attributs. Vous avez appris à créer votre première classe, à la définir et ensuite l'instancier, ce qu'on appelle simplement une instance de classe c'est-à-dire un objet.

Ce sont les choses que nous avions vu précédemment. On s'était arrêté là et je vous avait dit que nous allions poursuivre pour la suite des vidéos.

Aujourd'hui, nous allons parler de méthodes donc cette vidéo sera quand même assez courte puisque je préfère comme ça parler de plusieurs catégories différentes par vidéo plutôt que d'en faire trop dans une seule, histoire que ce soit bien clair pour vous, que vous puissiez avancer correctement.

Alors là, on va revenir sur des petites choses qu'on avait expliqué en introduction. Vous vous souvenez dans la vidéo d'introduction, la séance 10, je m'étais amusé en fait à vous donner plusieurs termes, à vous donner une petite définition très brève encore une fois où ça vous permettrait comme ça de voir un peu ce qui allez vous attendre pour la suite, en tout cas, de la formation surtout ce qui est programmation orienté objet.

Aujourd'hui nous parlons que des méthodes, si vous vous souvenez un petit peu dans les notes précédentes, j'avais grosso modo repris ces 3 termes-là, pas forcément avec les mêmes définitions. J'ai pas fait du copier-coller, je vous ai repris un petit peu les choses.

```py
    """
    Méthode             : fonction sur une instance (objet)
    Méthode de classe   : fonction sur une classe
    Méthode statique    : fonction indépendante mais "lié" à une classe
    """
```

Je vous avez parlé de méthode, c'est ce que nous allons parler, c'est tout simplement une fonction qui va être liée à une instance de classe donc un objet. Vous verez comment on va apprendre à en créer, à en utiliser.

On parlera ensuite de méthodes de classe qui elles sont vraiment des fonctions qui vont agir sur la classe elle-même, pas forcément une instance d'un objet en particulier et on aura les méthodes statiques donc une méthode statique, elle va être décrite dans une classe en particulier mais elle en sera indépendante. Ca vous pourrez l'utiliser, en fait, n'importe quand.

Par contre, il faudra bien évidemment renseigner la classe dans laquelle vous l'avez écrites donc c'est pour ça que j'ai mis que c'est lié entre entre guillemets à une classe puisqu'elle doit évidemment être définie dans une classe sinon Ben vous ne pouvez pas l'utiliser tout simplement.

Et on va du coup, créer une petite classe pour l'exemple et on va montrer comment on peut justement définir des méthodes.

Alors on va faire simplement "class". Je cherche un petit exemple, en fait, qui pourrait être un peu différent de ce qu'on a l'habitude de voir.

En général, je prends l'exemple des jeux vidéo, après je prends l'exemple des animaux tout ça.

On va reprendre l'exemple des humains. C'était bien clair l'autrefois.

Donc on va définir une classe Humain, d'accord.

## Définir une classe

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
```

Ca on en avait parlé l'autre fois et on avait fait ensuite un petit docstring, *Classe qui définit un humain*. 

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
```

### Définir le constructeur

Ca c'est utile quand on utilise la fonction d'aide et ensuite on avait fait notre constructeur, donc rappelez-vous, avec cette syntaxe-là, __init__(). Et on lui passe le mot clé self, __init__(self). Je vous rappelle que self, c'est l'objet de lui-même, d'accord. On l'appelle lui-même.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self)
```

### Définir des attributs

Et après ici, vous pouvez définir des paramètres avec pas mal de petites choses, un nom par exemple, un âge et cetera. On avait plein d'autres termes, on va rester nous sur ça, très simplement.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
```

Et on va lui, définir des attributs de classe enfin des attributs tout court, interne en fait pour l'objet donc des attributs d'instance plutôt. Donc self.nom égal nom et self.age égal l'âge.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
```

Voilà ça c'est tout ce que nous avions vu avant.

### Créer une instance de classe

Je vous rappelle qu'ici, on est dans le programme principal, d'accord, on a quitté en fait la définition de la classe.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age

#Programme principal
h1 = Humain()
```

Et il suffisait par exemple de faire h1 égal Humain, d'accord.

Et là (self, nom, age), comme les deux paramètres sont obligatoires, vous pouvez lui renseigner un prénom, vous pouvez lui renseigner un âge par exemple, d'accord, ce genre de chose, voilà.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age

#Programme principal
h1 = Humain("Jason", 26)
```

A partir de là, on pouvait éventuellement afficher ces attributs en affichant self.nom, self.age, bref je vous avais parlé un petit peu de tout ça, c'est des choses qu'on a vu.

On c'était arrêté-là et le but c'est maintenant de voir qu'est-ce qu'on pouvait ajouter à ça parce que là notre Humain, il peut rien faire en fait tout simplement, il y a quelques attributs, ici un nom, un âge mais il peut pas faire grand-chose, il n'a pas vraiment de particularité, en tout cas, de choses qu'il peut faire.

Pour cela, on va créer des méthodes. Une méthode, comme je l'ai expliqué, c'est une fonction propre à une instance, d'accord, et comment ça se crée ? 

## Définir une méthode simple - méthode instance

Et bien, ça se crée comme une fonction c'est à dire que tout ce que avez vu encore une fois sur la vidéo sur les fonctions, va vous servir ici.

Il suffit simplement d'utiliser le mot clé def comme vous avez appris et de choisir un nom donc selon les mêmes règles de nommage que pour les fonctions. Vous choisissez un nom de méthode.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def

#Programme principal
h1 = Humain("Jason", 26)
```

Alors n'utilisez pas évidemment les double underscore comme ça "__init__", c'est réservé notamment pour les méthodes spéciales du langage python dont on aura l'occasion de parler dans des vidéos plus tard.

Et là, vous choisissez un nom tout bête, ça peut être vraiment n'importe quoi, ça peut être parler. On peut mettre ce genre de choses, d'accord, donc on remet le mot-clé self bien sûr, on met le message puis on pourrait faire un print().

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print()
    
#Programme principal
h1 = Humain("Jason", 26)
```

Alors complètement inutile comme type d'utilisation bien sûr mais c'est histoire de vous montrer un petit peu.

Et là, on peut dire par exemple, je ne sais pas moi, on va reprendre la méthode format() parce que maintenant vous savez comment ... on la montré dans la vidéo précédente et maintenant que vous connaissez l'objet, vous savez comment ça fonctionne.

On va mettre ceci donc "a dit" par exemple, ce genre de choses. Je veux qu'au début ça m'affiche le nom, d'accord. Vous voyez, on peut faire directement un accès au nom "self.nom", à l'attribut et ensuite c'est le message, voilà, ce genre de chose.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))

#Programme principal
h1 = Humain("Jason", 26)
```

Et du coup, notre petit Humain, on va pouvoir le faire parler donc on va lui faire tout simplement, comme c'est une fonction propre à une instance, d'accord, rappelez-vous.

```txt
    Méthode             : fonction sur une instance (objet)
```

rappelez-vous, elle est sur l'instance donc il va falloir le faire sur l'instance donc l'instance, ici, moi c'est quoi ? l'objet c'est h1 donc je vais faire h1 et vous mettez un point c'est-à-dire que h1, il va utilisez ... le point, c'est pour dire entre guillemets, utilise ... Voilà l'objet h1 fait appel à la méthode parler, h1.parler() comme ceci.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))

#Programme principal
h1 = Humain("Jason", 26)
    
    h1.parler()
```

Et comme pour une fonction, vous rentrer les paramètres qu'il faut donc, moi il n'y en a qu'un seul, c'est le message. D'accord, on va mettre ce genre de chose. 

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
   """Classe qui définit un humain"""
   
   def __init__(self, nom, age):
       self.nom = nom
       self.age = age
       
   def parler(self, message):
       print("{} a dit : {}".format(self.nom, message))

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
```
Et on y va, on va directement tester.
```powershell
>python main.py
Jason a dit : Bonjour à tous ! :)
```
D'accord donc il prend bien le nom et il affiche le texte que j'ai mis là et il affiche un petit message.

Donc du coup très pratique puisque comme pour les fonctions qu'on a vu précédemment, on faire parler du coup le personnage très facilement comme ceci.
```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
   """Classe qui définit un humain"""
   
   def __init__(self, nom, age):
       self.nom = nom
       self.age = age
       
   def parler(self, message):
       print("{} a dit : {}".format(self.nom, message))

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```
Et là, rien de nouveau, c'est vraiment la même chose que ce que vous avez vu avec les fonctions, je ne vous apprends rien du tout.
```powershell
>python main.py
Jason a dit : Bonjour à tous ! :)
Jason a dit : Comment allez-vous ?
```

Du coup très pratique très simple à faire, d'accord, des méthodes, je ne vais pas vous en dire plus que de toute façon les règles au  niveau des paramètre obligatoire facultatif qu'on peut mettre dans l'ordre que l'on veut, c'est comme pour les fonctions donc si il y a un truc qui n'est pas encore clair, vous revoyez la vidéo sur les fonctions et vous saurez utiliser tout ce que vous avez appris pour les fonctions mais pour les méthodes.

Les méthodes c'est vraiment un nom différent, c'est pour bien savoir qu'on parle de fonction propre donc par rapport à de l'objet alors que quand on parle juste de fonction toute simple, c'est une fonction type procédurale.

C'est pour ça qu'on distingue les mots : méthode, procédure, fonction. Ce sont 3 mots différents en fait qui veulent dire la même chose.

C'est tout simplement un groupe de d'instructions qu'on va rassembler ensemble, tout simplement.

voilà pour la création d'une méthode simple.

### Récupérer le retour de fonction dans une variable

Voilà je vous dis, je ne vais pas donné plus de détails. On peut faire bien évidemment un return, on peut retourner quelque chose à une méthode. Il n'y a pas de souci bref on pourrait très bien par exemple mettre une autre variable ... je ne sais pas moi ... une variable resultat qui récupérerait par exemple le retour d'une méthode.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
resultat = h1.parler("Comment allez-vous ?")
```

Et puis là par exemple, on ferais ... je ne sais pas moi ... on ferrait un return de message. Ce qui ne servira à rien mais c'est également tout à fait possible, d'accord.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))
        return message

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
resultat = h1.parler("Comment allez-vous ?")
```

C'est tout à fait possible, une méthode peut retourner quelque chose. Elle est absolument comme une fonction, c'est vraiment la même chose.

C'est juste qu'elle est propre ici à une classe parce qu'on la créée dans une classe et c'est une instance donc un objet qui peut l'utiliser, qui peut s'en servir.

Maintenant on peut avoir une petite distinction parce que, rappelez-vous, il y avait 2 autres méthodes, il y avait la méthode de classe. Qu'est-ce qu'une méthode de classe ? Parce que ça.

```py
        def parler(self, message):
            print("{} a dit : {}".format(self.nom, message))
```

Parce que ça, on pourrait se dire que c'est déjà une méthode de classe puisqu'elle est propre à l'Humain mais pas tout à fait parce les termes sont un peu compliqués. C'est vrai qu'on va dire que ceux qui ont inventé les langages, qui ont inventé un petit peu le vocabulaire comme ça en informatique, ils n'ont pas toujours été très clair là dessus parce ce que c'est vrai qu'une méthode, par exemple ici, parler(), pour moi, ça pourrait très bien être appeler une méthode de classe puisque elle appartient à Humain.

Mais pas tout à fait, ce n'est pas ça parce ça agit sur self c'est-à-dire une instance, c'est-à-dire l'objet h1.

```py
        def parler(self, message):
```

S'il n'y a pas d'objets créés, vous ne pouvez pas utiliser la méthode parler() c'est ça qu'il faut comprendre, en faite.

C'est qu'une méthode standard vous pouvez appeler ça instance si vous voulez. Si vous voulez leur donner un terme, on peut l'appeler méthode d'instance à la rigueur, voilà.

```py
    """
    Méthode d'instance  : fonction sur une instance (objet)
    Méthode de classe   : fonction sur une classe
    Méthode statique    : fonction indépendante mais "lié" à une classe
    """
```

Une méthode d'instance, elle fonctionne que sur un objet ou méthode d'objets, on peut appelez ça comme on veut au final.

Donc il faut créer un objet avant. Je ne pourrais pas par exemple directement faire ceci, ça ne marcherait pas parce que h1 n'existe pas.

```txt
    #coding:utf-8

    """
    Méthode d'instance  : fonction sur une instance (objet)
    Méthode de classe   : fonction sur une classe
    Méthode statique    : fonction indépendante mais "lié" à une classe
    """

    class Humain:
        """Classe qui définit un humain"""
        
        def __init__(self, nom, age):
            self.nom = nom
            self.age = age
            
        def parler(self, message):
            print("{} a dit : {}".format(self.nom, message))

    #Programme principal
--> #h1 = Humain("Jason", 26)

    h1.parler("Bonjour à tous ! :)")
    h1.parler("Comment allez-vous ?")
```

Et si on fait ça en mettant par exemple le nom de la classe, vous verrez que c'est autre chose donc non plus pas possible.

```py
    Humain.parler("Bonjour à tous ! :)")
    h1.parler("Comment allez-vous ?")
```

On est vraiment obligé, dans tous les cas, de créer une instance avant tout.

```py
#coding:utf-8

"""
Méthode d'instance  : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```

On est vraiment obligé de créer une instance avant tout. 

Donc ça, c'est la méthode standard bon je vais garder quand même le nom comme ça. En général, on l'appelle juste méthode tout bêtement pour faire cette cette méthode-là. 

```py
    """
    Méthode             : fonction sur une instance (objet)
    Méthode de classe   : fonction sur une classe
    Méthode statique    : fonction indépendante mais "lié" à une classe
    """
```

## Définir une méthode de classe

On va parler maintenant des méthodes de classe.

La méthode de classe à la différence de la méthode ici standard, c'est qu'elle va fonctionner sur la classe en elle-même c'est-à-dire qu'elle ne va pas fonctionner forcément ici sur h1 qui ne marcherait pas si je peux avoir je faisais un objet h2 mais sur la classe Humain directement, en faite, ça va vraiment directement avoir un impact là-dessus. 

Donc qu'est-ce qui va changer ? Et bien c'est ce qu'on va passer en paramètre.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))
        
    def

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```

Alors qu'est-ce que je peux mettre dessus (def) ? j'en sais rien moi. Admettons, je sais que, c'est complètement débile, on a qu'a dire par exemple qu'on veut que tous les humains, dès le départ, on puissent tous leur donner l'âge de 50 ans, d'accord.

Alors juste pour je ne sais qu'elle raison, c'est parce qu'il faut bien que je vous donne un exemple et surtout un exemple simple pour que se soit compréhensible. On a qu'à faire, par exemple je ne sais pas moi, initialiser l'âge, "def initialiser_age".

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))
        
    def initialiser_age

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```

En partant du principe que nous on pourrait initialiser l'âge à 50 ans, d'accord. 

On va donc agir sur la classe c'est-à-dire cls.

    def initialiser_age(cls)

Erreur, moi je ne peux pas faire ça parce que là ... je dis n'importe quoi en plus ... parce que là je vais travailler sur une instance.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))
        
    def 

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```

Donc excusez-moi ce n'est pas un bon exemple du tout que je vous donne parce que ce n'est pas sur une instance.

Donc pour les méthodes de classe, on va directement travailler sur la classe.

Alors si j'avais un attribut de classe, rappelez vous, ce qu'on a vu précédemment quand on mettait un attribut ici.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
        
        
    #    <--
        
        
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))
        
    def 

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```

Quand on mettait un attribut ici. On pourrait se servir de méthodes de classe pour le modifier, d'accord.

Par exemple, ça peut être, je sais pas moi, et bien tiens je sais, on peut faire lieu_habitation égal la "Terre" par défaut, voilà. 

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
        
        
    lieu_habitation = "Terre"
        
        
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))
        
    def 

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```

Et on pourrait dire par exemple def changer_planete().

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
        
        
    lieu_habitation = "Terre"
        
        
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete()

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```

Alors c'est vraiment un exemple bizarre, d'accord, que je vous donne mais c'est pas grave donc ça " lieu_habitation ", rappelez-vous, pareil, c'est dans la vidéo précédente qu'on l'a vu. C'était un attribut de classe, c'est-à-dire qu'il n'est pas liée à une instance. Il n'y a pas de self. C'est pour chaque objet et on y accéder, souvenez-vous, en faisant ceci : Le nom de la classe, un point, le nom de l'attribut, d'accord.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete()

#Programme principal
h1 = Humain("Jason", 26)

Humain.lieu_habitation

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```

C'était la différence alors que là pour accéder à un attribut d'objets, il suffit de mettre " h1.age " par exemple comme on a fait un petit peu ici " format(self.nom " sauf qu'ici, on a mit self.

    print("{} a dit : {}".format(self.nom, message))

Donc c'était la différence.

Et bien c'est un peu pareil c'est-à-dire que ça " lieu_habitation " comme c'est lié, non pas à une instance, mais que c'est lié à toute la classe. C'est-à-dire que pour n'importe quel humain, on aura lieu_habitation qui est la terre. Je peux très bien faire une méthode qui va travailler sur des choses qui sont liées à une classe donc on va lui passer le mot clé cls pour classe tout simplement.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message):
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls)

#Programme principal
h1 = Humain("Jason", 26)

Humain.lieu_habitation

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```

Donc vous voyez ce n'est pas self, on met cls, c'est là toute la différence.

Quand vous voyez le mot self, c'est une méthode. Je vais mettre ici 
#self = méthode standard. Quand vous voyez cls, c'est une méthode de classe.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
        
        
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls): #cls = méthode de classe

#Programme principal
h1 = Humain("Jason", 26)

Humain.lieu_habitation

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```

Je met les deux points " def changer_planete(cls): " et on verra après pour le méthode statique juste à la fin, ici.

Et là du coup, on peut modifier quelque chose. Par exemple si je change de planète, je fais ça et je vais mette nouvelle_planete, pourquoi pas.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```

Et là, dans changer_planete(), je vais tout simplement dire que le lieu d'habitation alors Humain.lieu_habitation est égale à nouvelle planète.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete

#Programme principal
h1 = Humain("Jason", 26)

h1.parler("Bonjour à tous ! :)")
h1.parler("Comment allez-vous ?")
```

Donc on va arrêter de faire parler le bonhomme.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete

#Programme principal
h1 = Humain("Jason", 26)
```

On va tester deux bases, regardez ce qu'on va faire. On va faire un print(), on va lui dire "Planète actuelle : ", on va mettre avec format() et donc c'est format(Humain.Lieu_habitation), d'accord.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete

#Programme principal
h1 = Humain("Jason", 26)

print("Planète actuelle : {}".format(Humain.lieu_habitation))
```

ça c'est une syntaxe que normalement vous comprenez. Tout ça on l'a vu précédemment, format(), un attribut de classe, Humain.lieu_habitation, tout ça c'est vu précédemment.

Donc pourquoi faire ça. 

    print("Planète actuelle : {}".format(Humain.lieu_habitation))

On va le faire une 2e fois après le résultat et entre 2 on va utiliser changer_planete(), d'accord.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete

#Programme principal
h1 = Humain("Jason", 26)

print("Planète actuelle : {}".format(Humain.lieu_habitation))

##<--

print("Planète actuelle : {}".format(Humain.lieu_habitation))
```

Bon bah écoutez, la méthode de classe, on va directement l'appeler par rapport à ça. Je vais faire tout simplement un changement au niveau de cette fonction, changer_planete(), par contre ce n'est pas suffisant, là si je mets que ceci, ça ne marchera pas.

        def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
            Humain.lieu_habitation = nouvelle_planete

Ca ne marchera pas parce qu'en fait pour python, pour lui là, ce n'est pas une méthode de classe, d'accord, c'est pas suffisant. Pour lui ça va être une méthode standard, ici, parce que je n'ai rien qui a permis de dire tiens considère ça comme une méthode de classe.

On va pour cela utiliser un terme différent.

Alors ça se met ici d'accord, dans la classe, ça se met pas au niveau de la fonction. Vous voyez, je me mets au même niveau que les DEF partout et que l'attribut de classe. Et donc ici, je vais tout simplement créer une sorte de variables, d'accord.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete
        
#   <--

#Programme principal
h1 = Humain("Jason", 26)

print("Planète actuelle : {}".format(Humain.lieu_habitation))

print("Planète actuelle : {}".format(Humain.lieu_habitation))
```

Et je vais tout simplement créer une sorte de variable et je vais dire par exemple donc je vais lui mette le même nom. Je peux mettre par exemple changer_planete. En général on fait ça. On ne s'embête pas.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete
        
    changer_planete

#Programme principal
h1 = Humain("Jason", 26)

print("Planète actuelle : {}".format(Humain.lieu_habitation))

print("Planète actuelle : {}".format(Humain.lieu_habitation))
```

Et je lui dis que changer_planete, d'accord, ça va être en fait une méthode de classe donc je vais utiliser le terme " classmethod ", d'accord, donc en anglais et entre parenthèses, quel méthode va devenir une méthode de classe ? donc celle-là changer_planete(). Vous voyez, je ne m'embête pas, je vais mettre le même nom. => changer_planete = classmethod(changer_planete)

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
        
        
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete
        
    changer_planete = classmethod(changer_planete)

#Programme principal
h1 = Humain("Jason", 26)

print("Planète actuelle : {}".format(Humain.lieu_habitation))

print("Planète actuelle : {}".format(Humain.lieu_habitation))
```

Vous voyez, je ne m'embête pas comme ça, je ne m'embête pas. Okay, comme ça, je ne m'embête pas.

Et là du coup à partir d'ici, vous voyez comme pour l'attribut " lieu_habitation " de classe, on a défini une méthode de classe et donc en faisant Humain, point, changer_planete donc je vous rappelle que changer_planete que je vous mets ici, c'est ça en fait.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete
        
    changer_planete = classmethod(changer_planete) # <---

#Programme principal
h1 = Humain("Jason", 26)

print("Planète actuelle : {}".format(Humain.lieu_habitation))
    
Humain.changer_planete() # <---
    
print("Planète actuelle : {}".format(Humain.lieu_habitation))
```

Donc là par exemple si je l'appelais CH, il faudrait mettre CH.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    
    lieu_habitation = "Terre"
    
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete
            
    CH = classmethod(changer_planete) # <---

#Programme principal
h1 = Humain("Jason", 26)
    
print("Planète actuelle : {}".format(Humain.lieu_habitation))
    
Humain.CH() # <---
    
print("Planète actuelle : {}".format(Humain.lieu_habitation))
```

Pourtant la méthode vous voyez que c'est changer_planete, OK donc histoire de ne pas vous tromper.

Donc je vais mettre comme c'était, changer_planete et bien sûr, je vais mettre le paramètre qu'elle attends " mars ".

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
   """Classe qui définit un humain"""
   
   lieu_habitation = "Terre"
   
   def __init__(self, nom, age):
       self.nom = nom
       self.age = age
       
   def parler(self, message): #self = méthode standard
       print("{} a dit : {}".format(self.nom, message))
       
   def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
       Humain.lieu_habitation = nouvelle_planete
       
   changer_planete = classmethod(changer_planete)

#Programme principal
h1 = Humain("Jason", 26)

print("Planète actuelle : {}".format(Humain.lieu_habitation))

Humain.changer_planete("Mars")

print("Planète actuelle : {}".format(Humain.lieu_habitation))
```
Et là, si je n'ai pas fait de bêtises, vous voyez que ça fonctionne.
```powershell
>python main.py
Planète actuelle : Terre
Planète actuelle : Mars
```

J'ai changé la planète des êtres humains.

Donc tous les objets qu'on va créer Humain, ils seront tous sur la planète Mars à partir du moment où je vais changer ici " Humain.changer_planete("Mars") " puisque j'ai modifié un attribut de classe, d'accord.

C'était pas lié à l'objet h1, voyez on n'a jamais une seule fois parler de cet humain là.

    h1 = Humain("Jason", 26)

On a fait carrément un changement sur la classe en elle-même, on a jamais une seule fois fait intervenir l'objet que j'avais créé donc c'est ça la différence avec une méthode de classe.

Le mot clé cls en premier paramètre de la méthode et ensuite vous mettez cette petite ligne, très importante.

    changer_planete = classmethod(changer_planete)

Donc vous la mettez après par exemple la définition de la méthode comme ça voilà, vous êtes sûr que c'est ensemble.

Vous pouvez le mettre comme ça si vous voulez.

    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete 
    changer_planete = classmethod(changer_planete)

Mais attention pas dans la méthode, c'est vraiment en dehors puisque c'est une méthode de classe donc c'est défini dans la classe, voilà.

    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete 
        changer_planete = classmethod(changer_planete)

Et on terminera cette vidéo avec une dernière chose, les méthodes statiques.

## Définir une méthode statique

La méthode statique c'est lié à une classe mais elle est indépendance c'est-à-dire qu'en fait c'est un peu une classe qui peut être utilitaire, une classe qui va permettre de faire certaines choses mais qu'on peut appeler un petit peu n'importe comment encore une fois sans avoir d'objet instancié et sans forcément travailler sur la classe elle-même. 

C'est-à-dire qu'on n'est pas obligé de travailler sur la classe. On peut juste par exemple afficher un message ou je ne sais quoi, en fait, on peut faire tellement plein de choses. Après vous en verrez peut-être l'utilité à certains moment et d'autres pas du tout. Je vous montre quand même évidemment que ça existe et comment en faire faire.

Donc même chose, on va faire un DEF, qu'est-ce qu'on peut faire ? je ne sais pas moi, qu'est-ce qu'on peut mettre ? 

Bien tiens par exemple définition, d'accord, on va mettre ceci.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    lieu_habitation = "Terre"
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete
        
    changer_planete = classmethod(changer_planete)
    
    def definition()

#Programme principal
h1 = Humain("Jason", 26)

print("Planète actuelle : {}".format(Humain.lieu_habitation))

Humain.changer_planete("Mars")

print("Planète actuelle : {}".format(Humain.lieu_habitation))
```

Je ne met rien comme paramètre et voilà elle fera quelque chose de très simple, par exemple je ne sais pas moi, "L'Humain est classé comme étant le plus haut être-vivant de la chaîne alimentaire...." blablabla, on s'en fiche mais c'était pour montré.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    lieu_habitation = "Terre"
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete
        
    changer_planete = classmethod(changer_planete)
    
    def definition():
        print("L'Humain est classé comme étant le plus haut être-vivant de la chaîne alimentaire....")

#Programme principal
h1 = Humain("Jason", 26)

print("Planète actuelle : {}".format(Humain.lieu_habitation))

Humain.changer_planete("Mars")

print("Planète actuelle : {}".format(Humain.lieu_habitation))
```

Voilà, j'ai fait la petite méthode, en fait, "definition" donc en fait c'est une méthode donc qui est un peu lié à la classe parce que je parle des humains mais j'aurais pu parler de la pluie et du beau temps ce serait la même chose.

Elle est définie dans la classe humain effectivement et c'est bien dans le corps de la classe Humain que je l'ai créé et même chose, on va mettre pareil "definition" et non pas la classmethod() comme je l'ai fait ici, mais staticmethod(), ok.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    lieu_habitation = "Terre"
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete
        
    changer_planete = classmethod(changer_planete)
    
    def definition():
        print("L'Humain est classé comme étant le plus haut être-vivant de la chaîne alimentaire....")
        
    definition = staticmethod()

#Programme principal
h1 = Humain("Jason", 26)
print("Planète actuelle : {}".format(Humain.lieu_habitation))
Humain.changer_planete("Mars")
print("Planète actuelle : {}".format(Humain.lieu_habitation))
```

On utilise le mot là staticmethod() et on dit laquelle est une méthode statique en définition.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    lieu_habitation = "Terre"
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete
        
    changer_planete = classmethod(changer_planete)
    
    def definition():
        print("L'Humain est classé comme étant le plus haut être-vivant de la chaîne alimentaire....")
        
    definition = staticmethod(definition)

#Programme principal
h1 = Humain("Jason", 26)
print("Planète actuelle : {}".format(Humain.lieu_habitation))
Humain.changer_planete("Mars")
print("Planète actuelle : {}".format(Humain.lieu_habitation))
```

Et voilà, et comment je l'utiliser ? tout simplement ... j'ai même pas besoin de faire ça, en fait, on peut vraiment tout virer pour montrer que ça fonctionne.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    lieu_habitation = "Terre"
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete
        
    changer_planete = classmethod(changer_planete)
    
    def definition():
        print("L'Humain est classé comme étant le plus haut être-vivant de la chaîne alimentaire....")
        
    definition = staticmethod(definition)

#Programme principal
```

Je dis que dans la classe humain, j'utilise la méthode statique définition, tout simplement.

```py
#coding:utf-8

"""
Méthode             : fonction sur une instance (objet)
Méthode de classe   : fonction sur une classe
Méthode statique    : fonction indépendante mais "lié" à une classe
"""

class Humain:
    """Classe qui définit un humain"""
    
    lieu_habitation = "Terre"
    
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age
        
    def parler(self, message): #self = méthode standard
        print("{} a dit : {}".format(self.nom, message))
        
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete
        
    changer_planete = classmethod(changer_planete)
    
    def definition():
        print("L'Humain est classé comme étant le plus haut être-vivant de la chaîne alimentaire....")
        
    definition = staticmethod(definition)

#Programme principal
Humain.definition()
```
Et là, si je fais mon test, voilà.
```powershell
>python main.py
L'Humain est classé comme étant le plus haut être-vivant de la chaîne alimentaire....
```

Voilà, on peut utiliser donc directement des méthodes de cette manière donc c'est vraiment indépendant, d'accord, ça peut être appeler n'importe quand. C'est pas lier à un objet ou à une instance, on n'est pas forcément obligé de travailler sur une classe, voyez qu'on ne passe pas le mot clé ClS.

Là, on est vraiment complètement indépendant par contre comme je parle des humains bah je l'ai mis dans ma classe Humain parce que ça les concerne.

C'est pour ça que j'ai dit ici que c'était lié quand même une classe.

```py
    """
    Méthode             : fonction sur une instance (objet)
    Méthode de classe   : fonction sur une classe
    Méthode statique    : fonction indépendante mais "lié" à une classe <--
    """
```

Et bien par exemple cette méthode là.

```py
    def definition():
        print("L'Humain est classé comme étant le plus haut être-vivant de la chaîne alimentaire....")
```

Cette méthode là, je ne vais pas la mettre dans une classe animal, ça parle des humains. Ce serait un peu bizarre donc il faut quand même qu'elle soit, on va dire, catégoriser, qu'elle soit rangé quelque part là où il faut.

Par contre elle est vraiment indépendante, aussi bien de l'un des instances qu'on peut créer, que de la classe.

Et on entendra avec ça, je vous avez dis, c'est une petite vidéo courte histoire de faire une petite pause avant la suite.

La prochaine ne devrait pas être trop trop longue normalement mais maintenant vous savez comment faire de méthode donc retenez vraiment ces 3 types là :

La méthode standard où appeler là, la méthode d'instance si vous voulez ou d'objet pour un objet.

Vous avez la méthode de classe, c'est vraiment un terme très utilisé et la méthode statique.

C'est 3 petites choses à savoir. Elles ont chacune leur utilité.

Retenez surtout la méthode standard bien évidemment. 

Ca vous en aurez des fois usage pas toujours mais ça peut être parfois pas mal utile.

```py
    def changer_planete(cls, nouvelle_planete): #cls = méthode de classe
        Humain.lieu_habitation = nouvelle_planete
        
    changer_planete = classmethod(changer_planete)
```

Et méthodes statiques pareil mais là où vous en êtes au stade de cette formation, vous n'en verrez pas l'utilité et c'est parfaitement normal. 

```py
    def definition():
        print("L'Humain est classé comme étant le plus haut être-vivant de la chaîne alimentaire....")
        
    definition = staticmethod(definition)
```

C'est pas que c'est inutile, c'est pas que ... si vous ne voyez pas à quoi ça sert là tout de suite, c'est parfaitement normal. Quand vous aurez un peu plus expérience, quand vous aurez vraiment plus manipuler, fait des programmes en python, vous trouverez certains moments où vous vous direz Ah bah tiens, Ah oui effectivement là, je peux peut-être faire une méthode statique, ça peut être la solution à mon problème.

Donc ne vous en faites pas mais notez-le quelque part, gardez-le de côté et le jour où vous en aurez besoin, vous verez que ça aura son utilité à ce moment-là et pas avant.

Voilà voilà, je vous dis à très bientôt pour la prochaine vidéo donc on se retrouvera pour la séance 13 et nous parlerons cette fois des propriétés donc c'est une autre notion de tout ce qui est programmation objet.

En attendant révisez bien, entraîner-vous, n'hésitez pas à faire plein de programmes, à commenter, poser des questions, liker, partager la vidéo surtout parce que c'est vraiment très important et à très bien je vous dit pour la séance numéro 13

## Resume

```py
###############################################
#################### Resume ################### 
###############################################
#coding:utf-8

# Python #12 - methodes
# https://youtu.be/B-OlnwpVBN4
# 

"""
(abordes dans cette video)
1. Methode standard ou la methode d'instance ou d'objet.
2. Methode de classe.
3. Methode statique.
"""

"""
Dans la video 11, on a vu les classes et attributs. On a creer et definis notre premiere classe et ensuite l'instancier afin d'obtenir une instance de classe, un objet.
"""
#1# Definitions.
"""
Une methode est une fonction va etre liee a une instance de classe, un objet.
Une methode de classe est une fonction qui va agir sur la classe elle-meme, pas forcement une instance d'un objet en particulier.
Une methode statique va etre decrite dans une classe en particulier mais elle en sera independante. On peut l'utiliser n'importe quand par contre il faudra renseigner la classe dans laquelle, on l'a ecrite. Elle est reliee a une classe parcequ'elle doit etre definie dans une classe sinon on peut pas l'utiliser.
"""
#2# Creer une classe et definir des methodes.
class Humain:
	""" Classe qui definit un humain. """
	def __init__(self, nom, age): # On lui passe le mot cle self qui est l'objet lui meme. Et on definit d'autres parametres.
		""" Definir des attributs d'instances, des attributs interne pour les objets."""
		self.nom = nom
		self.age = age
# Programme principale.
"""
On quitte la definition de classe pour le programme principale.
On cree H1 au quel on renseigne les parrametres obligatoires.
"""
H1 = Humain("Jason",26)

"""
Ici H1 n'as pas de particularites, il ne peut rien faire. il a juste quelques attributs (nom, age). C'est pourquoi on cree des methodes.
"""

#2# Definir une methode simple (methode d'instance).
""" Une methode est une fonction propre a une instance. 
Comment la creer ? Ca se cree comme une fonction. Il suffit de choisir le mot cle def (video sur les fonctions) et de choisir un nom selon les memes regles de nommage. Il ne faut pas choisir les doubles undercores car c'est reserve pour les methodes speciales du langage Python... """
class Humain:
	def __init__(self, nom, age): 
		self.nom = nom
		self.age = age
		""" on choisi le nom parler avec le mot cle self bien sur et le message (methode inutile, juste pour l'exemple). On prend la methode format() pour specifier que tel invidu a dit tel chose. On cree un acces directement au nom et l'attribut et ensuite c'est le message et du coup on va pouvoir faire parler notre humain. Comme c'est une fonction propre a une instance, il faut la faire sur l'instance... """
	def parler(self, message):
		print("{} a dit {}".format(self.nom, message))
H1 = Humain("Jason",26)
""" ... on met H1 et un point. Le point c'est pour dire "il utilise". L'objet H1 fait appel a la methode parler. Et comme pour une fonctuon, on rentre les parametres qu'il faut. Le nom est bien prit et le message est affiche (idem aux fonctions)..."""
H1.parler("Bonjour")
H1.parler("Bonjour a tous ! :)")
""" Ensuite s'il faut definir des parametres obligatoire/facultatif,c'est comme pour les fonctions..."""
""" ... ce qui a ete vu pour les fonctions s'appliquent ici. Les methodes sont un monde different. On parle de fonction propre par rapport a de l'objet et quand on parle de fonction simple, il s'agit de fonction type procedurale. C'est pourquoi, on distingue les mots methode, procedure et fonction qui sont des mots differents qui veulent dire la meme chose. C'est simplenent un groupe d'instruction que l'on va rassembler. """
""" On peut egalement faire un return a une methode, retourner quelque chose a une methode, en mettant une autre variable nommee resultat par exemple qui recupererait le retour d'une methode."""
resultat = H1.parler("Bonjour a tous ! :)")

#3# Return.
class Humain:
	def __init__(self, nom, age): 
		self.nom = nom
		self.age = age
	def parler(self, message):
		print("{} a dit {}".format(self.nom, message))
		return message
H1 = Humain("Jason",26)
H1.parler("Bonjour")
H1.parler("Bonjour a tous ! :)")
""" On peut egalement faire un return a une methode, retourner quelque chose a une methode, en mettant une autre variable nommee resultat par exemple qui recupererait le retour d'une methode dont on aurait un return de message dans notre methode."""
resultat = H1.parler("Bonjour a tous ! :)")
""" Une methode peut retourner quelque chose comme une fonction..."""

#4# Methode de classe.
""" La methode est ainsi propre a une classe et c'est une instance, un objet qui peut l'utiliser. Maintenant il peut y avoir une petite distinction avec la methode de classe."""
""" La methode parler n'est pas tout a fait une methode de classe bien qu'elle soit propre a Humain. Les personnes qui ont inventes les langages et leurs vocabulaires n'ont pas ete tres clair car c'est vrai qu'une methode parler pourrait s'appeler une methode de classe qui appartient a Humain mais pas tout a fait car pour eux ca agit sur self, c'est a dire une instance c'est a dire l'objet H1. Si il n'y a pas d'objet cree, on ne pourra pas utiliser la methode parler."""
""" La methode standard ou methode d'instance ne fonctionne que sur un objet. Il faut creer un objet, une instance avant.
La methode de classe va fonctionner sur la classe en elle-meme, sur la classe Humain.
Qu'est-ce qui va changer ? C'est ce que l'on va passer en parametres ..."""
""" Pour les methodes de classe, on travaille directement sur la classe et non sur une instance. On peut se servir de methode de classe pour modifier des attributs de classe..."""
class Humain:
	""" ...on definis un lieu d'habitation par defaut sur Terre. C'est un attribut de classe, il n'y a pas de self. lieux_habitation est liee a toute la classe et non a une instance. Pour n'importe quel humain on aura le lieux d'habitation qui est la terre... """
	lieu_habitation = "Terre"
	def __init__(self, nom, age): 
		self.nom = nom
		self.age = age
	def parler(self, message):
		print("{} a dit {}".format(self.nom, message)) # self = methode standard.
	"""...on definis une methode. On peux faire une methode qui va travailler sur des choses liees a une classe. On lui passe le mot cle cls pour classe (ce n'est pas self). Et pour changer de planete, on passe entre parametre "nouvelle_planete" """
	""" """
	def changer_planete(cls, nouvelle_planete): # cls = methode de classe.
		Humain.lieu_habitation = nouvelle_planete
	""" ... pour Python ce n'est pas suffisant car je ne rien mit pourvque Python considere changer_methode comme une methode de classe. Pour cela il faut utiliser un terme different mis dans la classe au meme niveau que les fonctions, les def et l'attribut de classe. On cree simplement une sorte de variable. En general on la nomme comme la methode, ici changer_planete qui va etre une methode de classe "classmethod()" et entre parenthese, on precise quel methode va devenir une methode de classe. On peut donc revenir a notre programme pour modifier la planete "Humain.changer_planete" """
	var_changer_planete = classmethod(changer_planete) # ceci est une methode de classe definie dans la classe (dans une sorte de variable) en dehors de la methode ci-dessus. Attention a l'indentation.
H1 = Humain("Jason",26)
"""... alors que pour acceder a un attribut d'objet, il suffit de mettre H1. (un peu comme dans la classe quand on a mis self.) """
H1.parler("Bonjour")
H1.parler("Bonjour a tous ! :)")

#-1- Acceder a un attribut de classe (rappel)
""" Voila comment acceder a notre attribut de classe :"""
Humain.lieu_habitation

#-2- Modifier la planete actuel.
""" Afficher la planete actuel avant et apres l'appel de la methode de classe. """
print("Planete actuelle : {}".format(Humain.lieu_habitation))
""" var_changer_planete ci dessous est bien notre sorte de variable cree sous la methode et on ajoute le parametre attendu "Mars". Ainsi tous les humains qu'on va creer seront sur la planete mars a partir du moment ou j'ai changer un attribut de classe. """
Humain.var_changer_planete("Mars")
""" A aucun moment, on a fait intervenir l'objet H1 cree. On a fait un changement sur la classe en elle-meme. C'est ca qui difere avec la methode classe, on met cls en parametre de la methode et apres on cree cette sorte de variable tres importante var_changer_planete. """

print("Planete actuelle : {}".format(Humain.lieu_habitation))

#4# Methode statique
"""
Methode reliee a une classe mais independante. c'est donc une classe qui peut etre utilitaire qui va permettre de faire certaines choses mais que l'on appeler n'importe comment sans avoir besoin d'avoir d'objet instancier et sans forcement travailler sur la classe elle meme. On est pas obliger de travailler sur la classe, on peut afficher un message par exemple.
"""
class Humain:
	lieu_habitation = "Terre"
	def __init__(self, nom, age): 
		self.nom = nom
		self.age = age
	def parler(self, message):
		print("{} a dit {}".format(self.nom, message)) # self = methode standard.
	def changer_planete(cls, nouvelle_planete): # cls = methode de classe.
		Humain.lieu_habitation = nouvelle_planete
	var_changer_planete = classmethod(changer_planete)
	""" On fait une methode definition qui est un peu liee a la classe puisqu'on parle des humains et on la cree dans la classe humain. """
	def definition(): # definition d'une classe statique.
		print("L'humain est classe comme etant le plus haut etre-vivant de la chaine alimentaire...")
	""" On cree notre sorte de variable a qui on specifie quel est la methode statique en parametre de la methode static."""
	var_definition = staticmethod(definition)
# Programme principale.
""" On l'utilise en disant que dans la classe humain, j'utilise la methode statique definition() """
Humain.definition()
""" La methode statique peut etre appelee a n'importe quel monent. Ce n'est pas liee a un objet ou a une instance. On n'est pas oblige de travailler sur unr classe, on ne passe pas le mot cle cls. On est completement independant mais comme on parle des humains, on l'a mise dans la classe Humain parce que ca les concernent. C'est un peu liee a une classe car cette methode la ne va pas etre definie dans une classe animale. En effet, il faut quand meme qu'elle soit categorisee, rangee la ou il faut. Par contre elle est vraiment independante aussi bien des instances que l'on peut creer que de la classe. """
```