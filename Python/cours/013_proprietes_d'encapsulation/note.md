# [13. Propriétés d'encapsulation](https://www.youtube.com/watch?v=Fs6XsN6masA)

+ [Les attributs](#Les-attributs)
+ [Les propriétés](#Les-propriétés)
    + [Définir une propriété avec différentes manière de manipuler-contrôler des attributs](#Définir-une-propriété-avec-différentes-manière-de-manipuler-contrôler-des-attributs)
        + [getter](#getter)
        + [setter](#setter)
        + [deleter](#deleter)
        + [helper](#helper)
+ [Suite des explications sur l'encapsulation et la manière de contrôler des attributs](#Suite-des-explications-sur-Encapsulation-et-la-manière-de-contrôler-des-attributs)
+ [Bonus - Eviter de faire des fautes en orthographes dans un programme](#Bonus---Eviter-de-faire-des-fautes-en-orthographes-dans-un-programme)
+ [Resume](#Resume)

Salut à tous et bienvenue pour cette 13e vidéo en programmation python. 

Aujourd'hui, je vais vous proposez tout simplement de parler de propriété et on va voir très rapidement en quoi ça consiste.

On en avait parlé très rapidement dans la vidéo d'introduction avec une petite définition que je vous avez donnez.

Je vous avez expliqué que dans beaucoup de langages comme le C++, CSharp, d'autres langages que vous avez pu avoir l'occasion ou vous aurez l'occasion de voir sur ma chaîne. Encore une fois, tout dépend de quand est-ce que vous regardez cette vidéo.

En général, on ne distingue pas forcément les propriétés et les attributs, c'est un peu la même chose tout ce qui est variable d'une classe, dans beaucoup d'autres langages, on appelle ça une propriété, un attribut, on ne s'embête pas trop avec les différents termes.

En python, c'est assez différent puisque l'attribut c'est si vous voulez  là donnée ... c'est un peu l'appel à variable en fait d'une classe.

## Les attributs

Par exemple, pour notre Humain que je vais d'ailleurs recréer, on avait fait le nom et l'âge dans la vidéo précédente notamment donc je vais faire le constructeur là pour vous montrer. nom, age, les paramètres voilà. Et on avait du coup fait self.nom et self.age.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age

#Programme principale
```

Nos deux attributs self.nom et self.age donc ici, nous avons des attributs qui sont propres à la classe Humain et à chaque fois qu'on va créer une instance donc un objet de classe Humain, on pourra lui donner un nom et un âge, d'accord, ça c'est des choses que l'on a vu depuis le début, pas de souci à ce niveau-là. Je vais créer h1 comme avant ici. Je vais peut être même l'indiquer ici, "Création d'un Humain...".

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:
   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self.age = age

#Programme principale
h1 = Humain("Jason", 26)
```
Je vais faire python ... et voilà.
```powershell
>python main.py
Création d'un Humain...
```

Et voilà, ça fonctionne, pas de problème au niveau des attributs.

## Les propriétés

La propriété, elle va permettre en fait de si vous voulez ... contrôler vraiment manipuler nos attributs c'est-à-dire un peu les encapsuler alors on parle de principe d'encapsulation, ça on le retrouve surtout dans beaucoup d'autres langages comme le C++ ou le CSharp qui sont des langages qui ont une philosophie un petit peu plus strict à ce niveau là c'est-à-dire qu'on part du principe que tout ce qui est attributs par exemple ici (self.age et self.nom) lié à une classe donc pour un objet ne peut pas soit être lu, ou soit être modifier, donc être écrit en fait, écraser depuis l'extérieur de la classe c'est-à-dire par exemple dans le programme principal, d'accord.

Par exemple ici en python, vous avez vu que si je voulais accéder ici à l'âge, je peux juste faire h1.age et je vais pouvoir y accéder.

```py
#Programme principale
h1 = Humain("Jason", 26)
    
print(h1.age)
```

On peut même le modifier.

```py
#Programme principale
h1 = Humain("Jason", 26)
    
print(h1.age)
h1.age = 14
```

Et je peux mettre print(h1.age) et ça aura modifier la valeur.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:
   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self.age = age

#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)
h1.age = 14
print(h1.age)
```
On va regarder d'ailleurs.
```powershell
>python main.py
Création d'un Humain...
26
14
```

Vous voyez qu'il crée un Humain donc pas de soucis, au début l'âge est égal à 26 effectivement, en modifiant en 14, ça a changé.

Ca dans notre langage, on n'a pas le droit, on ne tolère pas ce genre de possibilité c'est-à-dire d'accéder comme ici " print(h1.age) " ou de modifier carrément la valeur d'un attribut sur un objet ou propre à une classe ou directement en dehors de la classe, d'accord. On n'autorise pas.

On utilise pour cela ce qu'on appelle des accesseurs et en python et bien ce sont justement ... ce n'est pas forcément des accesseurs même si on peut employer ce terme-là mais c'est ce qui englobe justement les propriétés.

Les propriétés c'est, imaginez, une sorte de petite boîte en fait qui dés que vous allez vouloir lire donc accéder à une un attribut où écrire un attribut donc le modifier où vous allez vouloir le supprimer ou alors lire carrément, on va dire, la documentation associé à un attribut donc un petit peu ça son aide, en fait, un petit message d'aide, ce genre de chose.

Vous pourrez utiliser, ça va passer par la propriété qui va faire tout le travail à votre place, on va déléguer en fait tout le contrôle, en fait, via une propriété.

Donc par défaut ce genre de comportement, je n'en veux pas donc on va créer une propriété, déjà quand on veut rendre un attribut non accessible et non, comment dire, si vous voulez voilà qu'on ne puisse pas, comme ça, manipuler en dehors.

Pour que les développeurs puissent les repérer facilement, ils ont pris l'habitude par convention en langage python, de mettre un underscore devant donc c'est ce qu'on va faire pour l'âge. Attention, ça n'aura absolument aucun changement sur le reste parce que par exemple, il suffirait de faire ceci.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:
   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age

#Programme principale
h1 = Humain("Jason", 26)

print(h1._age)
h1._age = 14
print(h1._age)
```
```powershell
>python main.py
Création d'un Humain...
26
14
```

hop je viens de prendre en compte la modification de la variable et j'ai pu le modifier sans problème, d'accord.

C'est juste une aide visuelle pour le développeur. Un développeur qui va voir un underscore donc le petit tiret _ comme ça souligné devant un nom d'attribut, comprendra que cet attribut-là, on ne veut pas y accéder de l'extérieur donc on va, en fait, ... on a une propriété qui encapsule, si vous voulez, cette attribut et c'est ce que nous allons faire, nous allons donc définir un nom, donc voyez comme ça, je le met en dehors comme ça du constructeur. C'est vraiment que dans la classe.

### Définir une propriété avec différentes manière de manipuler-contrôler des attributs

Je vais définir une propriété donc je vais lui mettre le même nom que l'attribut, ce qu'elle va englober donc pas de underscore, d'accord, vous pouvez mettre sans le underscore,  vous pouvez garder le même nom, vraiment le même nom mais sans le underscore.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:
    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
            
    age = property()

#Programme principale
h1 = Humain("Jason", 26)

print(h1._age)
h1._age = 14
print(h1._age)
```

`age = property()`, voilà, on créer une property() avec cette petite méthode qui va permettre d'en faire une.

property(), elle peut prendre plusieurs valeurs c'est-à-dire que property() elle peut prendre ce qu'on appelle un getter, un setter, on aurait éventuellement une deleter même si le terme est un peu bizarre et on aurait ce qui est propre à de la documentation donc je vais mettre un helper, par exemple, ce genre de chose, d'accord, voilà.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:
    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    age = property(<getter>, <setter>, <deleter>, <helper>)

#Programme principale
h1 = Humain("Jason", 26)

print(h1._age)
h1._age = 14
print(h1._age)
```

`<getter>, <setter>, <deleter>, <helper>`, voilà, 4 possibilités. Ces paramètres ne sont pas obligatoires, on peut très bien avoir un property() vide comme ça, ça n'aurait absolument aucune utilité. Si c'est pour faire quelque chose de vide, vous n'en mettez pas du tout bien évidemment mais on peut se contenter du premier c'est-à-dire le getter.

#### getter

Le getter de get qui est de l'anglais pour dire obtenir, ça veut simplement dire bah obtenir l'attribut, moi je veux par exemple avoir l'âge.

Si je veux lire l'âge comme ici `print(h1.age)`, je vais utiliser le fameux getter. 

Vous voyez qu'ici, je vais laisser âge alors vous allez me dire j'ai pas mis le underscore. 

```py
age = property()
```

Non, on ne met pas le underscore, on va travailler sur la propriété.

Or dans l'extérieur de votre classe, vous allez toujours passer par la propriété, d'accord, pour qu'elle puisse être utilisée.

`age = property("ici")` ... et là on va définir une méthode donc en premier paramètre, je lui dis qu'il y a une méthode. Je met un underscore aussi pour bien montrer que cette méthode ne sera pas utilisée en dehors de la classe, ce qui va s'appeler par exemple _getage, ok, voilà.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:
    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage)

#Programme principale
h1 = Humain("Jason", 26)

print(h1._age)
h1._age = 14
print(h1._age)
```

Et là je la crée comme une fonction ou comme une méthode standard, _getage avec un petit underscore avant pour bien la reconnaître et puis self en paramètre.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage)

#Programme principale
h1 = Humain("Jason", 26)

print(h1._age)
h1._age = 14
print(h1._age)
```

_getage(self), self, et elle va permettre de récupérer l'âge donc le plus simplement du monde, si je veux revenir au même fonctionnement que tout à l'heure sans avoir les propriétés, c'est ceci en fait, self._age, rappelez-vous que l'attribut, lui, il a un underscore.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       return self._age
       
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage)

#Programme principale
h1 = Humain("Jason", 26)

print(h1._age)
```
Par contre on va virer ça, par contre.
```powershell
h1._age = 14
print(h1._age)
```
Et là, à l'utilisation, absolument aucune différence.
```powershell
>python main.py
Création d'un Humain...
26
```

Alors vous allez me dire quelle utilité de créer, d'avoir créé une propriété, d'avoir du coup rajouter une méthode en plus ? Au final ça fait la même chose qu'avant, ça fait plus de code pour rien.

```py
def _getage(self):
    return self._age
```

Bien évidemment, si vous ne faites qu'un return comme ça, ça n'a absolument aucune utilité, c'est pour ça qu'il est recommandé d'ailleurs d'utiliser des propriétés que sur les attributs sur lesquels vous voulez avoir un contrôle précis.

Si vous n'avez absolument rien, si par exemple vous êtes en train de faire un getter et puis vous vous rendez compte que le seul truc que vous mettez dans dans la méthode get.. quelque chose, c'est le return de l'attribut, c'est que le getter ne sert à rien donc à ce moment-là, il n'a même pas de raison d'être. 

Donc si c'est juste pour ça, ça ne sert à rien. Par contre, moi je peux très bien mettre d'autres choses avant. Si par exemple je peux mettre d'autres choses avant, si je refuse par exemple de pouvoir récupérer l'âge depuis l'extérieur de la classe, je peux très bien dire par exemple "Récupération interdite", un truc comme ça, on peux imaginer autre chose,  un usage un petit peu plus vulgarisé.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       print("Récupération interdite")
       
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage)

#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)
```
Et regardez-là, dés que j'essaie de récupérer, ça ne fonctionne.
```py
>python main.py
Création d'un Humain...
Récupération interdite
None
```

ça ne fonctionne pas puisqu'il n'est pas passé par directement par l'accès à l'a mttribut mais par la propriété.

Vous voyez la propriété property(), elle encapsule du coup h1 donc c'est là que c'est vraiment super pratique parce qu'ici.

```py
#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)
```

On a aucune modification du code au niveau programme principal, juste dans la classe en définissant une propriété...

```py
# property(<getter>, <setter>, <deleter>, <helper>)
age = property(_getage)
```
... et les méthodes qui sont utilisées dans la propriété...
```py
def _getage(self):
    print("Récupération interdite")
```

On peut contrôler ça donc c'est là que c'est intéressant. On verra plus tard ce qu'on fera avec le _getage, pour le moment, on va se contenter de faire quelque chose de base c'est-à-dire le fameux self._age.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        return self._age
        
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage)

#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)
```

`return self._age`, même si ça n'a pas utilité mais c'est pas grave. On va en faire un 2e maintenant. Les 2 plus utilisés c'est ceux-là, `<getter>, <setter>`. 

Vous allez voir ceux-là, `<deleter>, <helper>`, vous ne les utiliserez peut-être jamais, voir pas beaucoup. On verra qu'il y a d'autres méthodes notamment pour travailler avec ce genre de choses.

#### setter

Moi je vais définir le setter, j'aimerais pouvoir modifier.
Alors on va mettre ça " print(h1.age) ", regardez parce que ça fonctionne bien. Et je vais pouvoir modifier en faisant " h1.age = 20 ". Encore une fois, vous voyez que je prends la propriété, d'accord. Je ne prends pas l'attribut "_age" directement sinon la propriété ne servirais à rien.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        return self._age
        
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage)

#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)

h1.age = 20
    
print(h1.age)
```

Et la même chose, je vais créer ... c'est le 2e paramètre `<setter>` une méthode `_setage` comme ceci.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        return self._age
        
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage, _setage)

#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)

h1.age = 20
    
print(h1.age)
```

Une méthode _setage, et je peux la faire : def _setage(self), on prend le nouvel âge, bien sûr : def _setage(self, nouvel_age) et du coup, on fait self._age égal le nouveau. 

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       return self._age
   
   def _setage(self, nouvel_age):
       self._age = nouvel_age
       
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage, _setage)

#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)

h1.age = 20

print(h1.age)
```
Si je test ce code.
```powershell
>python main.py
Création d'un Humain...
26
20
```

C'est toujours pareil, on obtient la même chose que tout à l'heure, encore une fois, un setter, si vous n'avez que ça comme ligne dedans, ça ne sert à rien.

```py
def _setage(self, nouvel_age):
    self._age = nouvel_age
```

Si en plus votre getter, vous n'avez que ça.

```py
def _getage(self):
    return self._age
```

Si vous n'avez que ça, ça veut dire que vous pouvez en fait supprimer en fait tout ça.

```py
def _getage(self):
    return self._age

def _setage(self, nouvel_age):
    self._age = nouvel_age
        
# property(<getter>, <setter>, <deleter>, <helper>)
age = property(_getage, _setage)
```

Voilà ça veut dire que la propriété ne sert à rien, vous pourez enlever le underscore et modifier simplement directement l'attribut si vous ne voulez effectuer aucun contrôle.

Moi par contre ici, je vais éffectuer un petit contrôle très simple.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        return self._age
    
    def _setage(self, nouvel_age):
                                           ## <--
        self._age = nouvel_age
            
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage, _setage)

#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)

h1.age = 20

print(h1.age)
```

Moi par contre ici, je vais éffectuer un petit contrôle très simple en disant par exemple que if nouvel_age est plus petit que zéro, admettons.

Alors je ne vais pas afficher de message ou autre, je vais simplement dire que l'âge, je le met automatiquement à 0. C'est pas forcément utile mais bon et sinon, du coup, tu modifiés par nouvel_age.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       return self._age
   
   def _setage(self, nouvel_age):
       if nouvel_age < 0:
           self._age = 0
       else:
           self._age = nouvel_age
       
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage, _setage)

#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)

h1.age = 20

print(h1.age)
```
Vous voyez, je peux exercer un petit contrôle donc là si je teste normalement pas de souci.
```powershell
>python main.py
Création d'un Humain...
26
20
```

Mais si j'essaie de mettre une valeur, n'importe quoi, par exemple -5.
```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       return self._age
   
   def _setage(self, nouvel_age):
       if nouvel_age < 0:
           self._age = 0
       else:
           self._age = nouvel_age
       
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage, _setage)

#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)

h1.age = -5

print(h1.age)
```
```powershell
>python main.py
Création d'un Humain...
26
0
```

Automatiquement, voyez il contrôle ce que j'ai voulu faire sur l'attribut et il empêche de faire n'importe quoi, en fait.

C'est vraiment ... ça permet de contrôler, donc de manipuler les attributs d'une manière correcte grâce aux propriétés.

Voilà l'utilité que cela a et voilà l'importance de cette notion, en python, de pouvoir encapsuler comme ça des attributs pour vraiment contrôler leur fonctionnement, d'accord, que vous ayez des informations correctes.

    property(<getter>, <setter>, <deleter>, <helper>)

Alors ça, ça peut servir plus tard par exemple si vous faites un site web avec du python comme par exemple quand vous remplissez un formulaire. Vous vérifier qu'une adresse mail est valide, vérifier que la personne qui a rentré un code postal, ne s'est pas amusé à mettre son prénom par exemple dans le code postal sinon il y aurait des problèmes, il y a des lettres à la place de chiffres.

Ce genre de chose-là ou la longueur d'une chaîne par exemple, voyez. 

Ou je ne sait pas ... voyez, sur un jeu vidéo, vous voulez un une taille de pseudo maximum de 25 caractères et bah si ça dépasse 25 caractères, vous redemander à l'utilisateur de rentrer un pseudo valide, ce genre de choses en affichant un message d'erreur. Voilà l'utilité que peut avoir les propriétés avec le langage python. Cela a cette utilité-là.

On va finir avec les 2 derniers même s'ils ne sont pas spécialement très utilisé ici, voir des fois même pas du tout et on verra plus tard ce qu'on appelle les méthodes des méthodes spéciales qui serviront à faire ce genre de choses, notamment quand on va supprimer un attribut. Par exemple, comment je vais faire ça ? 

#### deleter

Et bien je vais simplement faire une nouvelle méthode _delage et ensuite def _delage(self): et à l'intérieur de vais utiliser un mot clé "del" pour delete : del self._age.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        return self._age
    
    def _setage(self, nouvel_age):
        if nouvel_age < 0:
            self._age = 0
        else:
            self._age = nouvel_age
            
        def _delage(self):
            del self._age
            
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage, _setage, _delage)

#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)

    ## <--

print(h1.age)
```

Ensuite, vous voyez qu'au début (du programme principale), j'essaye de lire l'âge.

```py
print(h1.age)
```

Ensuite qu'est-ce que je vais faire et bien je vais mettre la même chose sauf que je vais mettre del h1.age, encore une fois je travaille sur la propriété.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       return self._age
   
   def _setage(self, nouvel_age):
       if nouvel_age < 0:
           self._age = 0
       else:
           self._age = nouvel_age
           
   def _delage(self):
       del self._age
       
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage, _setage, _delage)
   
#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)

del h1.age

print(h1.age)
```
Donc je lui dit tu me supprimes h1.age. "del", c'est une commande en fait, "del", elle sert à ça en python, c'est un mot réservé, c'est pour ça qu'il se met en violet, qui permet de venir modifier l'attribut d'une instance donc ici voilà de l'humain que je viens de faire.

On va vérifier ce que ça donne.
```powershell
>python main.py
Création d'un Humain...
26
Traceback (most recent call last):
  File "main.py", line 742, in <module>
    print(h1.age)
  File "main.py", line 721, in _getage
    return self._age
AttributeError: 'Humain' object has no attribute '_age'
```

Vous voyez que la première fois, il affiche 26 et la 2e fois il me dit qu'il y a une exception qui est lever, AttributeError, et il dit que l'objet humain n'a pas d'attribut _age effectivement puisqu'ici on vient de le détruire, del h1.age

Donc là, ça peut être super intéressant parce que là vous voyez qu'il y a une ce genre d exception qui est lever.

Donc là, mon `_getage(self)`, il va être un peu plus intéressant, un peu plus étoffé.

Je peux faire ce genre de chose par exemple ... qu'est-ce que je peux faire, j'sais pas moi ... il faut plutôt faire ça, on va faire un try/except comme on avait vu avant avec la gestion des erreurs.

On va faire du try c'est-à-dire qu'il essaye de retourner self.age.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        try:
            return self._age
    
    def _setage(self, nouvel_age):
        if nouvel_age < 0:
            self._age = 0
        else:
            self._age = nouvel_age
            
    def _delage(self):
        del self._age
            
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage, _setage, _delage)
    
#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)

del h1.age

print(h1.age)
```

Si ça lève une exception, ça ne va forcément pas marcher. Dans le cas où il y a une exception de type "AttributeError" et c'est effectivement le cas ici, Eh bien je vais afficher que l'âge n'existe pas par exemple ce genre de chose.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       try:
           return self._age
       except AttributeError:
           print("L'âge n'existe pas !")   
   
   def _setage(self, nouvel_age):
       if nouvel_age < 0:
           self._age = 0
       else:
           self._age = nouvel_age
           
   def _delage(self):
       del self._age
       
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage, _setage, _delage)
   
#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)

del h1.age

print(h1.age)
```
```powershell
>python main.py
Création d'un Humain...
26
L'âge n'existe pas !
None
```

Et là voilà, on a caché forcément l'exception parce qu'on l'a capturé avec le except et on affiche un message d'erreur et "L'âge n'existe pas !" donc là tout de suite, vous voyez que le _getage, il est super pratique. Si on n'avait pas utilisé ici de propriété et bien à chaque fois qu'on aurait voulu lire l'âge, on aurait dû faire un if, que l'âge existe et sinon afficher un message d'erreur.

Là on le fait qu'une seule fois.

```py
def _getage(self):
    try:
        return self._age
    except AttributeError:
        print("L'âge n'existe pas !")  
```

On encapsule l'attribut et ça nous permet de contrôler vraiment l'accès à eux ou leur modification ou éventuellement ici, _delage(), comme vous l'avez vu leur suppression, voilà à quoi ça sert.

#### helper

Et pour le helper, vous aller me dire à quoi ça sert ? le helper, regardez, ça se met comme ça en fait. Vous mettez un petit mot ... je crois qu'il n'aime pas les accents ... "Je suis l'âge d'un Humain".

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        try:
            return self._age
        except AttributeError:
            print("L'âge n'existe pas !")   
    
    def _setage(self, nouvel_age):
        if nouvel_age < 0:
            self._age = 0
        else:
            self._age = nouvel_age
            
    def _delage(self):
        del self._age
        
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage, _setage, _delage, "Je suis l'âge d'un Humain")
        
#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)

del h1.age

print(h1.age)
```

Et vous savez qu'il y a l'espèce de fonction help() qui est très utile quand on veut par exemple faire un peu de débogage ou simplement vérifier l'aide en fait au niveau des fonctions qu'on a.

Vous avez dû voir et ça je l'avais expliqué qu'on pouvait faire une docstring c'est-à-dire en faisant ceci par exemple.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:
    """Cette classe représente un Humain"""

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        try:
            return self._age
        except AttributeError:
            print("L'âge n'existe pas !")   
    
    def _setage(self, nouvel_age):
        if nouvel_age < 0:
            self._age = 0
        else:
            self._age = nouvel_age
            
    def _delage(self):
        del self._age
        
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage, _setage, _delage, "Je suis l'âge d'un Humain")
        
#Programme principale
h1 = Humain("Jason", 26)

print(h1.age)

del h1.age

print(h1.age)
```

Je vous avait expliqué qu'on pouvais faire une docstring c'est-à-dire en faisant ceci, je peux mettre par exemple, """Cette classe représente un Humain""".

Si par exemple, j'utilise la fonction help() de Humain.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:
   """Cette classe représente un Humain"""

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       try:
           return self._age
       except AttributeError:
           print("L'âge n'existe pas !")   
   
   def _setage(self, nouvel_age):
       if nouvel_age < 0:
           self._age = 0
       else:
           self._age = nouvel_age
           
   def _delage(self):
       del self._age
       
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage, _setage, _delage, "Je suis l'age d'un Humain")
   
#Programme principale
help(Humain)
```
Si par exemple, j'utilise la fonction help() de Humain.
On va terminer la vidéo avec ça, regardez.
```powershell
>python main.py
Help on class Humain in module __main__:

class Humain(builtins.object)
 |  Humain(nom, age)
 |
 |  Cette classe reprÚsente un Humain
 |
 |  Methods defined here:
 |
 |  __init__(self, nom, age)
 |      Initialize self.  See help(type(self)) for accurate signature.
 |
 |  ----------------------------------------------------------------------
 |  Data descriptors defined here:
 |
 |  __dict__
 |      dictionary for instance variables (if defined)
 |
 |  __weakref__
 |      list of weak references to the object (if defined)
 |
 |  age
 |      Je suis l'age d'un Humain
```

Voilà, regardez, c'eat vrai il n'aime pas les accents effectivement, voilà.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:
   """Cette classe represente un Humain"""

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       try:
           return self._age
       except AttributeError:
           print("L'âge n'existe pas !")   
   
   def _setage(self, nouvel_age):
       if nouvel_age < 0:
           self._age = 0
       else:
           self._age = nouvel_age
           
   def _delage(self):
       del self._age
       
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage, _setage, _delage, "Je suis l'age d'un Humain")
   
#Programme principale
help(Humain)
```
J'ai viré les accents, et maintenant regardez.
```powershell
>python main.py
Help on class Humain in module __main__:

class Humain(builtins.object)
 |  Humain(nom, age)
 |
 |  Cette classe represente un Humain
 |
 |  Methods defined here:
 |
 |  __init__(self, nom, age)
 |      Initialize self.  See help(type(self)) for accurate signature.
 |
 |  ----------------------------------------------------------------------
 |  Data descriptors defined here:
 |
 |  __dict__
 |      dictionary for instance variables (if defined)
 |
 |  __weakref__
 |      list of weak references to the object (if defined)
 |
 |  age
 |      Je suis l'age d'un Humain
```

Hop voilà, il vous met alors que cette classe représente un Humain. Il vous affiche toute la classe, il met ces méthodes, il vous mets les descriptors mais on n'en a pas encore parlé, ça viendra par la suite, ne vous en faites pas.

Et regardez, pour l'âge, il vous met "Je suis l'age d'un Humain". Vous voyez ça sert directement, en fait, on peut récupérer, comme ça, un peu ces petits messages d'aide. C'est un peu de la documentation, en fait tout simplement. 

Après, on peu d'ailleurs s'amuser à faire même carrément `Humain.age`.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:
   """Cette classe represente un Humain"""

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       try:
           return self._age
       except AttributeError:
           print("L'âge n'existe pas !")   
   
   def _setage(self, nouvel_age):
       if nouvel_age < 0:
           self._age = 0
       else:
           self._age = nouvel_age
           
   def _delage(self):
       del self._age
       
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage, _setage, _delage, "Je suis l'age d'un Humain")
   
#Programme principale
help(Humain.age)
```
help(Humain.age), il le prend et voilà.
```powershell
>python main.py
Help on property:

    Je suis l'age d'un Humain
```

Voilà, vous voyez il met "Help on property", "Je suis l'age d'un Humain" donc c'est à ça que ça peut servir en fait, c'est un petit message d'aide tout simplement donc il n'est pas obligatoire encore une fois d'ailleurs dans la majorité des cas vous n'aurez que ces deux-là `<getter>, <setter>`.

## Suite des explications sur Encapsulation et la manière de contrôler des attributs

La majorité des cas vous n'aurez que ces deux-là `<getter>, <setter>`

Vous aurez une propriété comme ça, définie comme ceci et c'est tout.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:
    """Cette classe represente un Humain"""

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        try:
            return self._age
        except AttributeError:
            print("L'âge n'existe pas !")   
    
    def _setage(self, nouvel_age):
        if nouvel_age < 0:
            self._age = 0
        else:
            self._age = nouvel_age
                           
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage, _setage)
        
#Programme principale
```

La plupart du temps, vous aurez une propriété définie comme ça et c'est tout. La plupart du temps, vous ferez des choses dans le getter, dans le setter et terminé et vous manipulerez les objets comme ça de cette manière.

C'est vraiment tout ce que vous ferez, c'est assez rare quand utilise les 2 autres mais c'est quand même bien de savoir que ça existe et que ça fonctionne d'accord.

On peut faire les choses de cette manière, il n'y a pas de souci.

Plus tard, on verra de toute façon des méthodes spéciales, on parlera des descripteurs, on verra qu'il y a d'autres possibilités pour supprimer un attribut de classe, pour faire de l'aide, ce genre de choses.

Donc je voulais quand même vous le montrer puisqu'il faut le savoir. Il faut savoir que property() prend effectivement 4 paramètres, pas seulement ces 2 là, `<getter>, <setter>`. On peut en retrouver d'autres, ça peut éventuellement servir pour certaines cas très très précis. Je voulais que vous sachiez en tout cas comment ça fonctionne, comment le faire, voilà.

Et puis écoutez Ben là, on a fait un peu globalement le tour, je pense que j'ai dit tout ce que j'avais à vous dire sur les propriétés, en tout cas, pour maintenant parce qu'il y a pas mal d'autres choses qui vont venir s'ajouter.

Donc vraiment ce qu'il y a retenir dans cette vidéo c'est surtout que vous pouvez encapsuler, d'accord, des attributs en permettant du coup de les contrôler comme il faut.

Par convention et c'est juste visuellement, quand on a un attribut qu'on va vouloir encapsuler, on met un petit underscore devant, ça permet de vous quand vous allez relire votre code de savoir que l'âge ici "self._age", ça va être une propriété quelque part. On descend un peu dans le code et effectivement on a fait une propriété.

```py
age = property(_getage, _setage, _delage, "Je suis l'age d'un Humain")
```

Comme ça, on peut vérifier comment on permet de lire un attribut.

```py
    def _getage(self):
        try:
            return self._age
        except AttributeError:
            print("L'âge n'existe pas !") 
```
Et comment on permet de le modifier.
```py
    def _setage(self, nouvel_age):
        if nouvel_age < 0:
            self._age = 0
        else:
            self._age = nouvel_age
```

De le modifier en effectuant quelques vérifications avec des conditions ou des boucles où je ne sais quoi et puis dans le _getage() de voir, voilà, dans quel cas on retourne et qu'est-ce qu'on retourne surtout, d'accord.

Parce que par exemple, regardez ça peut être utile le get. On va terminer là dessus. Tout bête, je vais vous montrer un truc très très simple.

On va virer tout ça, voilà.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:
    """Cette classe represente un Humain"""

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        try:
            return self._age
        except AttributeError:
            print("L'âge n'existe pas !")   
        
        
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage)
    
#Programme principale
```

Si vous prenez l'habitude par exemple de retourner l'âge souvent et vous voulez retourner par exemple une une phrase ou alors simplement quelque chose d'assez ... comment dire bah mettons un truc multi language, vous voudrez retourner l'âge d'une certaine manière. On peut faire ça, par exemple, regardez.

Si je fais un nouveau Humain. Et ensuite, "J'ai {} ans.", ce genre de chose, point et format().

```py
h1 = Humain("Robert", 16)
print("J'ai {} ans.".format(h1.age))
```

Décidemment Robert est pas mal célèbre aussi, voilà.
```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:
   """Cette classe represente un Humain"""

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       return self._age    
   
   
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage)
   
#Programme principale
h1 = Humain("Robert", 16)

print("J'ai {} ans.".format(h1.age))
```
```powershell
>python main.py
Création d'un Humain...
J'ai 16 ans.
```

Voyez, création d'un Humain.

Voilà, on peut mettre d'ailleurs, pourquoi pas, ce genre chose.
```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:
   """Cette classe represente un Humain"""

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       return self._age   
   
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage)
   
#Programme principale
h1 = Humain("Robert", 16)

print("{} a {} ans.".format(h1.nom, h1.age))
```
Et là regardez comme ça, ce genre de chose.
```powershell
>python main.py
Création d'un Humain...
Robert a 16 ans.
```

Et là comme ça, pas différent. Comme pour nom, je n'ai pas fait d'encapsulation, vous allez voir qu'on va y accéder sans problème.

Pour montrer, voyez que ce n'est pas utile, je pars du principe ici que je ne veux faire aucun contrôle dessus donc du coup j'y accède comme avant, d'accord, comme ce que vous avez vu avant. 

```py
def _getage(self):
    return self._age  
```

Par contre pour l'âge, je suis un peu plus pointilleux dans mon cas. J'essaye quand même de contrôler la lecture, seulement la lecture et du coup voilà.

Donc là, j'affiche Robert à 16 ans mais imaginons que Robert, il a que un an. Vous savez normalement que dans la française, c'est vraiment un pur exemple, on n'affiche pas un S au mot "an".

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:
   """Cette classe represente un Humain"""

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       return self._age   
   
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage)
   
#Programme principale
h1 = Humain("Robert", 1)

print("{} a {} ans.".format(h1.nom, h1.age))
```
Regardez ici, il met Robert a 1 ans avec un S.
```powershell
>python main.py
Création d'un Humain...
Robert a 1 ans.
```

C'est pas propre quand on fait des interfaces plus tard, des interfaces graphiques, des vrais présentations, on évite de faire des fautes d'orthographes dans un programme donc c'est pas propre.

Du coup, je peux sans problème faire ceci, donc dire par exemple que si self._age si est plus petit ou égal à 1 parce qu'on peut dire à la rigueur que 0, on considère qu'il vient de naître, admettons, ce genre de choses.

## Bonus - Eviter de faire des fautes en orthographes dans un programme

On va faire un return de self._age par exemple en fait et vous pourrez mettre une suite de texte. Donc vous pourrez mettre, je ne sais pas moi, vous pourrez mettre le "an" en fait tout simplement avec le "an", ce genre de chose.

```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:
    """Cette classe represente un Humain"""

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        if self._age <= 1:
            return
        return self._age   
        
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage)
        
#Programme principale
h1 = Humain("Robert", 1)

print("{} a {} ans.".format(h1.nom, h1.age))
```

Dans le cas où vous allez avoir en fait un âge qui plus grand que 1, vous pourrez par exemple retourner l'âge avec une concaténation par exemple avec le mot ans. Ce qui fait que ici, vous n'aurez plus qu'à faire ça, en fait d'accord tout simplement.

```txt
    print("{} a {} ans.".format(h1.nom, h1.age))
                    |
                    V
    print("{} a {}".format(h1.nom, h1.age))
```

Et au 2e, vous aurez du coup la bonne chose qui faut alors on peut faire, j'sais pas moi, return self._age,"an"
```py
        def _getage(self):
            if self._age <= 1:
                return self._age,"an"
```
ce genre de chose, alors, sinon.
```py
        def _getage(self):
            if self._age <= 1:
                return self._age,"an"
            else:
                return self._age,"ans"
```            
Je confond toujours les systèmes de concaténation. On va faire ça, j'aime bien format(), c'est bien pratique.
```py
        def _getage(self):
            if self._age <= 1:
                return "{} {}".format(self._age, "an")
            else:
                return "{} {}".format(self._age, "ans")
```
Je préfère à la rigueur ...
```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:
   """Cette classe represente un Humain"""

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       if self._age <= 1:
           return "{} {}".format(self._age, "an")
       else:
           return "{} {}".format(self._age, "ans")
   
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage)
   
#Programme principale
h1 = Humain("Robert", 1)

print("{} a {}".format(h1.nom, h1.age))
```
```powershell
>python main.py
Création d'un Humain...
Robert a 1 an
```
**!!! J'étais fatigué ^-^. Pour concatener, faîtes simplement --> return str(self._age)+'ans'. Pour que l'âge soit prit comme une chaîne et pas comme un chiffre.**

```py
        def _getage(self):
            if self._age <= 1:
                return str(self._age)+'an'
            else:
                return str(self._age)+'ans'
```

Voilà,
```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
           principe d'encapsulation !
"""

class Humain:
   """Cette classe represente un Humain"""

   def __init__(self, nom, age):
       print("Création d'un Humain...")
       self.nom = nom
       self._age = age
       
   def _getage(self):
       if self._age <= 1:
           return str(self._age)+' an'
       else:
           return str(self._age)+' ans'
   
   # property(<getter>, <setter>, <deleter>, <helper>)
   age = property(_getage)
   
#Programme principale
h1 = Humain("Robert", 1)

print("{} a {}".format(h1.nom, h1.age))
```
```powershell
>python main.py
Création d'un Humain...
Robert a 1 an
```

Voilà et comme ça dans le cas où il a 1 an, on n'a pas de s et on met un âge plus grand, il va mettre le s.
```py
#coding:utf-8

"""
Propriété : manière de manipuler/contrôler des attributs
            principe d'encapsulation !
"""

class Humain:
    """Cette classe represente un Humain"""

    def __init__(self, nom, age):
        print("Création d'un Humain...")
        self.nom = nom
        self._age = age
        
    def _getage(self):
        if self._age <= 1:
            return str(self._age)+' an'
        else:
            return str(self._age)+' ans'
    
    # property(<getter>, <setter>, <deleter>, <helper>)
    age = property(_getage)
    
#Programme principale
h1 = Humain("Robert", 45)

print("{} a {}".format(h1.nom, h1.age))
```
```powershell
>python main.py
Création d'un Humain...
Robert a 45 ans
```

Si on met un âge plus grand, il va mettre le s, donc c'est un exemple, tout bête, de possibilité, comme ça de pouvoir vraiment contrôler les lectures.

C'est pas parce qu'on fait juste la lecture d'un attribut qu'on ne peut pas rendre autre chose que l'attribut, on peut très bien, vous voyez ici, rendre un mot derrière ou même carrément toute cette phrase.

```py
print("{} a {}".format(h1.nom, h1.age))
```

Si vous voulez par exemple toujours dire la même phrase. Vous pouvez après en général quand on fait un getter, on retourne vraiment que la valeur de l'attribut, on s'amuse pas forcément à afficher le texte dérrière mais ça peut ... on peut le faire, je veux dire, c'est pas interdit. On peut très bien le faire, il y a des cas où ça s'y prêterait tout à fait donc n'hésitez pas, vous voyez que ça peut avoir effectivement une utilité, d'accord.

Voilà voilà pour ces petites propriétés, il n'y a pas grand chose encore une fois dans cette vidéo mais c'était vraiment à retenir.

Ce qu'il faut ne pas oublier, c'est le fonctionnement de la propriété pour encapsuler un attribut, très important et de pouvoir surtout manipuler correctement avec des getters, des setters donc on appelle ça des accesseurs, d'accord.

Le getter, le setter ou le mutateur, si on veux employer un terme un peu plus français.

`<getter>, <setter>`, et ces 2 choses-là sont les accèsseurs, ils permettent d'accéder tout simplement à l'attribut.

`<deleter>, <helper>`, voilà et ça je vous le dis, si vous ne retenez pas, ce n'est pas bien grave puisque de toute façon, ce n'est pas forcément comme ça qu'on le supprime et qu'on utilise l'aide, un petit peu des doctstring donc c'est-à-dire ce qui est entouré comme ça de 3 doubles cotes. On a plusieurs d'autres méthodes mais si vous le savez, c'est bien, si vous le retenez tant mieux pour vous, si vous l'oubliez c'est pas grave du tout. Vous n'en n'aurez peut-être jamais besoin donc c'est pas vraiment un souci.

On se retrouve maintenant pour la prochaine vidéo, j'espère que vous avez appris encore pas mal de petites choses. Vraiment n'hésitez pas à vous exercer, à créer comme ça des petits programmes. On peut faire des choses sympa maintenant, vous pouvez créer des classes comme ça, vous amuser à faire des personnages, les faire interagir ensemble avec des méthodes, ce genre de choses, ça peut être quand même très très sympathique.

On va voir de toute manière beaucoup de choses par la suite qui vont compléter un petit peu l'utilisation comme ça de nos objets parce que il y a des choses qui vont bloquer, par exemple, je peux faire un petit petite présentation rapide avant.

Si on devait par exemple comparer des humains. Comment comparer ... comparer 2 chiffres ? c'est facile, il y en a un qui est plus petit ou plus grand que l'autre. 

Comparer des nombres flottants c'est pareil mais comment va t-on comparer des humains ? si on devait faire par exemple, je ne sais pas moi, un exemple tout bête, d'accord.

```py
    #Programme principale
    h1 = Humain("Robert", 45)
    h2 = Humain("Luc", 12)
```

Ce genre de chose, histoire de faire un petit tease de ce qui arrivera pour la prochaine fois, voilà. 

Est-ce qu'on pourrait faire ce genre de choses par exemple ?

```py
    #Programme principale
    h1 = Humain("Robert", 45)
    h2 = Humain("Luc", 12)
    
    if h1 < h2:
```

Je montre ce genre de choses, automatiquement vous allez dire bah attends il y a un problème puisque c'est quoi du coup h1, qu'est-ce qu'il va comparer ? il va comparer le nom, il va comparer l'âge, il va comparer tout ... vous voyez, là il y a un problème qui se pose donc ça c'est quelque chose que vous ne pouvez pas encore faire avec des objets c'est-à-dire de faire des comparaisons, d'utiliser des opérateurs précisément de comparaison par exemple et ça on verra d'accord plus tard. Non pas forcément la prochaine fois mais plus tard.

On verra comment surchargé donc c'est ce qu'on appelle la surcharge d'opérateur pour pouvoir faire des manipulations comme ça sur des objets comme si c'était des simples nombre, des petites choses comme ça pour voir, voilà sur quoi on comparerait un humain au niveau de notre classe.

Voilà c'était histoire de vous annoncer un petit peu ce qui vous attend pour la suite des vidéos au niveau de l'objet pour identifier un petit problème que vous allez peut-être rencontrer dans vos exercices, un petit peu dans ce que vous allez faire.

Moi je vous retrouve pour la prochaine vidéo en tout cas.

Entraînez-vous bien encore une fois, c'est vraiment quelque chose que si vous ne comprenez pas, n'hésitez pas à me laisser des commentaires, je répondrai, je vous aiderai comme d'habitude vous savez comment ça fonctionne et je vous dis, en tout cas, à très bientôt.

Ciao 

## Resume

```py
###############################################
#################### Resume ################### 
###############################################
#coding:utf-8

# Python #13 - proprietes d'encapsulation.
# https://youtu.be/Fs6XsN6masA
# Les propriétés permettent d'encapsuler, c'est-à-dire de contrôler le fonctionnement (accès/modification/suppression) des attributs de vos classes en Python.

"""
(Vu dans cette vidéo)

On peut encapsuler des attributs en permettant de les contrôler comme il faut.
Par convention, et c'est juste visuelement, quand on a un attribut qu'on va vouloir 
encapsuler on met un petit undescore devant. Ca nous permet lorsqu'on relis le code
de ce dire que l'age ici "_age" va être une propriété quelque part pour constater plus loin 
qu'une propriété a éffectivement été faite "age = property(_getage)". Comme ça on peux vérifier
comment on permet de lire un attribut et comment on permet de le modifier en effectuant
quelques modifications avec des conditions, des boucles, etc puis dans le get voir dans quel cas 
on retourne, ect, qu'est-ce qu'on retourne surtout.

Il ne faut pas oublier le fonctionnement de la propriété pour encapsuler un attribut et de pouvoir
manipuler correctement avec des getters, des setters (un mutateur en français), ce qu'on appelent 
des accesseurs qui permettent d'accéder à un attribut.

Le deleter et le helper ne sont pas forcément à retenir parce que ce n'est pas comme ça qu'on
supprime et qu'on utilise l'aide des DocString qui est entouré de trois double quotes. 

Dés cette vidéo, on peux créer des classes, des personnages et les faire intérragir ensemble
avec des méthodes. Dans les vidéos prochaines, on va voir des méthodes qui vont compléter l'utilisation
de nos objets parce que certaines choses vont bloquer. En effet, comparer deux chiffres c'est facile (un
est plus petit que l'autre, etc) mais comment comparer des humains ? 

h1 = Humain("Robert", 45)
h2 = Humain("Luc", 12)

if h1 < h2: # Qu'est-ce qu'on compare ? l'âge ? Tout ?. 

Un problème se pose ? On peux pas faire de comparaison avec des objets en utilisant des comparateurs.
On verra comment surcharger ? (Ce que l'on appelle la surcharge d'opérateurs)
On verra comment faire de la manipulation sur des objets ? comme si c'était de simple nombre, etc.
Ainsi comment comment comparer un humain au niveau de notre classe.

"""

import os
os.system("cls")

"""
Proprietes
----------
Dans beaucoup d'autres langages Java, C++, C#, etc on ne distingue pas les proprietes des atrributs en general. Tout ce qui est variable d'une classe est appele propriete/attribut dans les autres langages. En Python, c'est different. En effet, l'attribut c'est l'appel a variable d'une classe. Voir exemple de la classe Humain pour lequel on recree son constructeur avec 2 attributs qui sont propre a la classe Humain. A chaque fois que l'on cree une instance, un objet de classe Humain. On pourra lui donner un nom et un age. """

""" La propriete va permettre de controler/manipuler nos attributs. C'est a dire les encapsuler. On parle de principe d'encapsulation dans d'autres langages comme le C++ et le C# qui sont des langages avec une philosophie plus stricte a ce niveau la. C'est a dire que tout ce qui est attribut liee a une classe pour un objet, ne peut pas soit etre lu, soir etre modifie (etre ecrit/ecrase en fait) depuis l'exterieur de la classe dans le programme principal. 
En Python si je veux juste acceder a l'age, je peux faire h1.age et je pourrais y acceder et le modifier h1.age = 14. Dans d'autres langages cette possibilite n'est pas permise, c'est a dire d'acceder ou de modifier carrement la valeur d'un attribut sur un objet propre a une classe, directement en dehors de la classe. On utilise pour cela des accesseurs et en Python, on peut employer ce terme d'accesseur qui englobe les proprietes. Les proprietes sont comme de petites boites qui des qu'on va vouloir lire et y acceder a un attribut ou ecrire/modifier un attribut (vouloir le sypprimer) ou alors lire carrement la documentation associe a un attribut (lire son petit message d'aide). On pourra passer par une propriete qui va faire tout le travail. On va deleguer tout ce control via une propriete. Par defaut ce genre de comportement, on n'en veux pas, on va creer une propriete.
Quand on veux rendre un attribut non accesible (qu'on ne puisse pas manipuler en dehors. Pour que les developpeurs puissent les reperer facilement, ils ont prit l'habitude par convention en langage Python de mettre un underscore devant. C'est ce que nous faisont ici avec _age. C'est juste visuel, un developpeur qui voit un underscore devant un nom d'attribut comprendra que cet attribut la, on ne peux pas y acceder depuis l'exterieur. Un propriete est donc presente et encapsule cet attribut. C'est ce que nous allons faire ..."""

class Humain:
	def __init__(self, nom, age):
		print("Creation d'un humain")
		self.nom = nom
		self._age = age
# Programme pribcipale.
h1 = Humain("Jason",26)

print(h1._age)
h1._age = 14
print(h1._age)

#2# Definir une propriete d'encapsulation d'un attribut.
"""... on commence par definir un nom en dehors du constructeur, dans la classe. Ainsi on definit une propriete du meme nom que l'attribut qu'elle va englober..."""
class Humain:
	def __init__(self, nom, age):
		print("Creation d'un humain")
		self.nom = nom
		self._age = age
	""" ...on peut le nommer sans underscore dans la classe. On cree cette propriete avec la methode property().
	Methode qui peut prendre 4 parametres:Property(<getter>, <setter>, <deleter>, <helper>). Ces parametres ne sont pas obligatoire. Un property() vide n'aurait aucune utilite. On peut se contenter du premier, le getter.
	Getter signifie "obtenir l'attribut". Le getter permet de lire l'age. On ne met pas de underscore a "age=property()" car on va travailler sur la propriete. En dehors de la classe, on va toujours passer par la propriete pour qu'elle puisse etre utilisee. Ici on definit une methode, en premier parametre on lui dit qu'il y a une methode et on met bien un underscore pour dire que cette methode ne sera pas utilisee en dehors de la classe qui va s'appeler _getage. """
	""" On cree _getage comme une methode standard. Elle prend self en parametre et va permettre de recuperer l'age et retourner self._age (l'attribut a un underscore) le plus simplement du monde sans avoir les proprietes. """
	def _getage(self):
		return self._age # l'attribut _age possede un underscore.
	age = property(_getage) # Property(<getter>, <setter>, <deleter>, <helper>). Le helper represente la doc... 1 seul parametre suffit mais il en faut au moins un, ici le getter pour recuperer un attribut.
	""" Quel utilite d'avoir cree un propriete "age = property(_getage)" et d'avoir ajoute une methode en plus "def _getage(self)", au final ca fait plus de code qu'avant (le return n'as aucune utilite) ? C'est pourquoi il est recommande d'utiliser des proprietes que sur les attributs sur lequel on veux avoir un controle precis. Si on a absolument rien, par exemple, on est en train de faire un getter et que la seul instruction presente dans la methode _getage est un return de l'attribut signifie que le getter ne sert a rien. Si c'est juste pour ca, ca ne sert a rien. """
# Programme principal.
h1 = Humain("Jason",26)
print(h1._age)

#3# GETTER - Definir une propriete d'encapsulation d'un attribut (suite).
""" """
class Humain:
	def __init__(self, nom, age):
		print("Creation d'un humain")
		self.nom = nom
		self._age = age
	""" On disait donc que definir une methode _getage avec juste un return ne sert a rien. Neanmois on peut mettre d'autres choses avant le return. Par exemple si je refuse de pouvoir recuperer l'age depuis l'exterieur de la classe, on peut ecrire "recuperation non autorisee" """
	def _getage(self):
		print("Recuperation non autorisee")
		#return self._age
	age = property(_getage) # Property(<getter>, <setter>, <deleter>, <helper>).
# Programme principal.
h1 = Humain("Jason",26)
print(h1._age)
print(h1.age)
""" print(h1.age) ne fonctionne pas parceque on ne passe pas par l'acces a l'attribut (h1._age) mais par la propriete. Ainsi la propriete encapsule h1. Avec aucune modification de code au niveau programme principal (h1.age ne change pas) mais juste dans la classe en definissant une propriete et les methodes utilisees dans la propriete on peut controler ca.  """

#4# SETTER - Definir une propriete d'encapsulation d'un attribut (suite).
""" """
class Humain:
	def __init__(self, nom, age):
		print("Creation d'un humain")
		self.nom = nom
		self._age = age
	def _getage(self):
		#print("Recuperation non autorisee")
		return self._age
	""" On cree la seconde propriete _setage qui va prendre un nouvel age. Encore une fois si on a qu'une ligne (self._age = nouvel_age) a l'interieur ca ne sert a rien. En effet, si on veux effectuer aucun control, il suffit de passer par l'attribut pour le modifier. On peut neanmois effectuer un petit control et mettre l'attribut a zero si nouvel_age < 0 sinon tu modifie par le nouvel_age. Ce n'est pas forcement utile mais ca permet d'effectuer un petit controle. Le _setage controle ce que l'on veux faire sur l'attribut. Les proprietes permettent de controler les attributs de maniere correcte. L'interet en Python est de pouvoir encapsuler les attributs pouvoir controler leur fonctionement.
	Cela peut servir si un jour, on fait un site web avec du Python dans le cas d'un formulaire pour verifier qu'une adresse mail est valide, qu'un utilisateur n'entre pas son prenom a la place d'un code postal (des lettres a la place de chiffres). On peut verifier la longueur d'une chaine. Par exemple sur un jeu video, on veux taille maximum de pseudo de 25 caracteres et si ca depasse les 25 caracteres, on demande a l'utilisateur de rentrer un pseudo valide en affichant un message d'erreur. Voila l'utilite que peut avoir les proprietes en langage Python. 
	"""
	def _setage(self, nouvel_age):
		if nouvel_age < 0:
			self._age = 0
		else:
			self._age = nouvel_age
	age = property(_getage, _setage) # Property(<getter>, <setter>, <deleter>, <helper>).
# Programme principal.
h1 = Humain("Jason",26)
print(h1._age) # Attribut.
""" Encore une fois, on prend la propriete pour effectuer la modification. Je ne prend pas l'attribut directement sinon la propriete ne servirait a rien. Creons maintenant la seconde propriete _setage..."""
print(h1.age) # Propriete.
h1.age = -5
print(h1.age) # Propriete.

#5# DELETER - Definir une propriete d'encapsulation d'un attribut (suite).
""" Le deleter et le helper sont tres peu utilise, voir pas du tout. Il existe des methodes speciales quand par exemple, on va supprimer un attribut..."""
class Humain:
	def __init__(self, nom, age):
		print("Creation d'un humain")
		self.nom = nom
		self._age = age
	def _getage(self):
		#print("Recuperation non autorisee")
		return self._age
	def _setage(self, nouvel_age):
		if nouvel_age < 0:
			self._age = 0
		else:
			self._age = nouvel_age
	""" ... creation d'une nouvelle methode _delage(self). Dans la methode, on utilise un mot cle del pour delete..."""
	def _delage(self):
		del self._age
	age = property(_getage, _setage, _delage) # Property(<getter>, <setter>, <deleter>, <helper>).
# Programme principal.
h1 = Humain("Jason",26)
print(h1._age) # Attribut.
""" ... on essaye de lire l'age. On met ensuite del h1.age. Encore une fois, on travaille sur la propriete. del est une commande de Python, un mot reserve qui permet de venir modifier un attribut d'une instance. On compile et une exception est levee pour attributeError en nous disant que l'objet Humain n'as pas d'attribut age et effectivement puisqu'on vient de le detruire... """
print(h1.age) # Propriete.
#del h1.age #-> leve une exception AttributeError.
print(h1.age) # Propriete.

#5# DELETER (suite) : try/except .
""" del est une commande qui permet de modifier un attribut d'une instance de l'Humain que l'on vient de faire. En faisant del h1.age, une exception est levee, attributeError pour dire que l'objet Humain n'as pas d'attribut age et effectivement puisqu'on vient de le detruire. Grace a cette exception levee, on va pouvoir completer notre _getage... => utilisation de try/except."""
class Humain:
	def __init__(self, nom, age):
		print("Creation d'un humain")
		self.nom = nom
		self._age = age
	""" ... On essaye de retourner self._age et si ca leve une exception de type AttributeError, on va afficher que l'age n'existe pas. """
	def _getage(self):
		try:
			return self._age
		except AttributeError:
			print("L'age n'existe pas !")
	""" Lorsqu'on utilise le Deleter, on constate que le _getage est super pratique. Si on n'avait pas utilise de propriete, cjaque fois qu'on aurait voulu lire l'age, on aurait du faire un if pour voir si l'age existe et sinon afficher un message d'erreur. Ici on ne le fait qu'une seule fois, on encapsule l'attribut et ca nous permet de controler leur acces et/ou leur modification et/ou eventuellement (comme ici) leur suppression. """
	def _setage(self, nouvel_age):
		if nouvel_age < 0:
			self._age = 0
		else:
			self._age = nouvel_age
	def _delage(self):
		del self._age
	age = property(_getage, _setage, _delage) # Property(<getter>, <setter>, <deleter>, <helper>).
# Programme principal.
h1 = Humain("Jason",26)
print(h1._age) # Attribut.
print(h1.age) # Propriete.
del h1.age
print(h1.age) # Propriete.

#6# HELPER - Definir une propriete d'encapsulation d'un attribut (Suite).
""" A quoi sert le helper ? Elle permet d'ajouter un petit mot => age = property(_getage, _setage, _delage, "Je suis l'age d'un humain"). A cote, la fonction help est tres utile quand on veux faire du debogage et verifier l'aide au niveau des fonctions qu'on a. On a vu precedemment qu'on pouvais faire une docString. Et si ensuite, on utilise la fonction help de Humain, ce qui permet d'afficher toute la classe, ses methodes et les descripteur (qu'on verra plus tard) et pour l'age, il nous affiche, "Je suis l'age d'un humain". C'est simplement de la documentation ..."""
class Humain:
	""" DocString : Cette classe represente un humain."""
	def __init__(self, nom, age):
		print("Creation d'un humain2")
		self.nom = nom
		self._age = age
	""" """
	def _getage(self):
		try:
			return self._age
		except AttributeError:
			print("L'age n'existe pas !")
	""" """
	def _setage(self, nouvel_age):
		if nouvel_age < 0:
			self._age = 0
		else:
			self._age = nouvel_age
	def _delage(self):
		del self._age
	age = property(_getage, _setage, _delage, "Je suis l'age d'un humain") # Property(<getter>, <setter>, <deleter>, <helper>).
# Programme principal.
h1 = Humain("Jason",26)
help(Humain)
""" ... On peut également afficher simplement le petit message d'aide..."""
help(Humain.age)
""" ...voilà le helper n'est pas obligatoire. D'ailleurs dans la majorité des cas, nous aurons une propriété définie avec juste un getter et un setter dans lequel on écrit quelques instructions et finalement manipuler l'objet de cette manière. 
C'est assez rare qu'on manipule le deleter et le helper. On verra également des méthodes spéciales comme le descripteur, pour supprimer un attribut de classe, etc. """


#7# Bonus - Eviter de faire des fautes d'orthographes dans un programme.
""" Si on prend l'habitude de retourner souvent l'age. On affiche ainsi que Robert a 16 ans 
mais si il a 1 an. Dans la langue française, on affiche pas un s au mot an. 
Ce n'est pas propre, on évite de faire des fautes d'orthographe. """
class Humain:
	def __init__(self, nom, age):
		print("Creation d'un humain2")
		self.nom = nom
		self._age = age
	""" Retourner une suite de texte dans le cas où l'âge est de 1 an.
	Si l'age est plus grand que 1, on pourra retourner l'age avec une concaténation
	avec le mot "ans" ... """
	def _getage(self):
		if self._age <= 1:
			""" Pour concatener, il faut utiliser simplement str() + 'texte' pour que l'age soit pris comme une chaîne et pas comme un chiffre."""
			return str(self._age) + ' an'
			#return "{} {}".format(self._age, "an")
		else:
			return str(self._age) + ' ans'
			#return "{} {}".format(self._age, "ans")
		""" Ce n'est pas parce qu'on fait la lecture d'un attribut, qu'on ne peux pas rendre autre chose qu'un attribut.
		On peux retourner toute la phrase si l'on veux "print("{} a {}.".format(h1.nom, h1.age))".
		En général quand on fait un getter, on retourne que la valeur de l'attribut mais on peux
		retourner plus de texte pour éviter les répétition par exemple. """

	age = property(_getage) # Property(<getter>, <setter>, <deleter>, <helper>).
# Programme principal.
h1 = Humain("Robert", 16)
"""  """
#print("{} a {} ans.".format(h1.nom, h1.age))
""" Retourner un age avec le pluriel ou non de an concaténé."""
print("{} a {}.".format(h1.nom, h1.age))
```