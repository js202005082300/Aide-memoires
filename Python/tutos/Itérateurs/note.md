# [Itérateurs](https://www.youtube.com/watch?v=H9FIOc-bIHU)

En informatique, on a la notion d'itérateur.

En python, on fait la distinction entre le terme itérateur et le terme itérable.

Un itérateur c'est tout simplement un objet donc une donnée qui va représenter un flux.

À côté on a l’itérable qui va permettre de renvoyer les différents éléments de ce flux de données, qui va nous permettre via une boucle de parcourir les différents éléments d'une structure et de pouvoir les récupérer.

Alors en général on retrouve les itérateurs avec les boucles.

```py
# Tutoriel Python : itérateurs

word = "Hello"

for letter in word:
        print(letter)
```
```powershell
> python .\main.py
H
e
l
l
o
```

Voilà nous obtenons ceci sur une chaîne de caractères qui est un type séquentiel à partir de cette boucle de parcours for(). Ainsi les éléments de notre chaîne de caractère, de notre séquence, sont tout simplement des caractères.

La boucle for est capable de renvoyer les éléments un par un donc la chaîne de caractères est un itérable qui peut nous renvoyer les différents éléments.

Pour ce faire il y a un itérateur qui est créé c'est à dire que dès qu'on va utiliser la boucle for() cet itérateur est appelé implicitement, que l'on ne voit pas parce qu'on ne va pas le faire nous-mêmes et qui s'appelle iter().

iter() est une fonction que nous avons dans ce langage et qui permet de créer cet itérateur. On a également la fonction next() qui permet de parcourir les éléments.

```py
# Tutoriel Python : itérateurs

word = "Hello"

for letter in word: ## iter() / next()
        print(letter)
```

Voilà c'est ce couple de fonction `iter() / next()` qui vont nous servir au niveau de l'itération de nos itérateurs.

Quand on fait une boucle fort on peut parcourir des éléments c'est le cas pour les éléments séquentielles d'une chaîne de caractères mais également tous les autres types séquentiels comme une liste, un dictionnaire, un tuple et cetera. Par exemple une liste…

```py
# Tutoriel Python : itérateurs

li = [1, 2, 3, 4, 5]

for value in li:
        print(value)
```
```powershell
> python .\main.py
1
2
3
4
5
```

La liste est un objet itérable au sens de python, ainsi on peut parcourir ces différents éléments via cette littérature que nous venons de créer.

Admettons maintenant qu'on crée notre itérateur et on va appeler notre fonction iter() sur l'élément a été itérer donc qui est itérable c'est à dire ici la liste.

```py
# Tutoriel Python : itérateurs

li = [1, 2, 3, 4, 5] # list est iterable
iterator = iter(li)

print(next(iterator))
```
```powershell
> python .\main.py
1
```

Voilà comme ça on parcourt les éléments un à un et un moment donné quand on a fini de parcourir et qu'il n'y a pas d'autres éléments à la suite dans l'objet itérable, on obtient une exception qui est lever qui est `StopIteration`

```py
# Tutoriel Python : itérateurs

li = [1, 2, 3, 4, 5] # list est iterable
iterator = iter(li)

print(next(iterator))
print(next(iterator))
print(next(iterator))
print(next(iterator))
print(next(iterator))
print(next(iterator))
print(next(iterator))
```
```powershell
> python .\main.py
1
2
3
4
5
Traceback (most recent call last):
  File "C:\Users\sam\OneDrive\Bureau\Mementos\Python\tutos\Itérateurs\main.py", line 11, in <module>
    print(next(iterator))
StopIteration
```

Alors quand on fait une boucle for(), on n'a pas ce jour d'exception qui a levé sinon il faudrait la traiter avec un bloc try except tout simplement parce que le for() traite ce type d'exception et finit par arrêter ce type de parcours, l'itération au niveau de notre structure.

Pour ce faire il faudrait faire en try except.

```py
# Tutoriel Python : itérateurs

li = [1, 2, 3, 4, 5] # list est iterable
iterator = iter(li)

while True:
    try:
        print(next(iterator))
    except StopIteration:
        break
```
```powershell
> python .\main.py
1
2
3
4
5
```

Bien sûr ce n'est pas nécessaire de capturer l'exception lorsqu'on utilise la boucle for() avec les 2 mots-clés `for` et `in`.

Voilà ils permettent tous les 2 de parcourir la structure.

Alors ce principe de itérateurs agit comme une surcouche c'est à dire qu'on va pouvoir travailler sur une liste ou une chaîne de caractères, c'est le même comportement c'est à dire que ça vient s'ajouter comme une couche d'abstraction pour parcourir, itérer sur des éléments itérable.

L'avantage c'est que toute donnée qui est dite itérable en python même si plus tard on crée une autre type d'objets et qu'on le rend itérable, on pourra utiliser les fonctionnalités des itérateurs pour pouvoir parcourir tout cela.

On va voir quelques exemples bien que ce principe de itérateurs ne sois pas essentiel au cours et qu'il n'est pas évident de s'illustrer ce principe de l’ittérateurs parce que en général c'est utilisé de manière implicite donc ce n'est pas essentiel par le langage.

## Redéfinir les méthodes spéciales de l'itérateur

Maintenant nous allons voir comment on obtient notre itérateur, on va retrouver 2 méthodes spéciales (je vous recommande d'aller voir la vidéo sur les méthodes spéciales dans la playlist des tutoriels avec les méthodes qui sont sous ce format `__method__()` tel que `__init__()`).

Voilà ici nous avons 2 méthodes spéciales `__iter__()` et `__next__` ce qui est logique parce que après nous avons les 2 méthodes natives du langage qui sont iter() et next().

```py
__iter__() -> iter()
__next__() -> next()
```

On comprend facilement que python fait beaucoup appel à des appels implicites, à des méthodes spéciales et par la suite on peut facilement les réécrire et les définir, les surcharger dans nos classes pour pouvoir changer un petit peu le comportement qu'elles ont par rapport au type de données que nous créons et que nous manipulons.

On va revenir sur un cas assez intéressant sur les itérations qui est `range` donc si on fait un intervalle, on peut obtenir par exemple un ensemble de valeurs. On va recréer un petit peu ce type de données parce que c'est un type d'objet en python pour créer le nôtre en mettant en place à différents concepts que l'on retrouve pour les itérateurs.

*Nb. On pourrait avoir dans un autre tutoriel un autre concept qui sont les générateurs qui sont intimement associés aux itérateurs, voilà on retrouve souvent les 2 ensemble mais ça fera l'objet d'une autre vidéo.*

Voilà pour obtenir quelque chose qui est itérable, il va falloir ré implémenter, redéfinir ces 2 méthodes spéciales quand je vous ai montré qui sont iter() et next(). Ainsi on va recréer notre classe `range` pour comprendre un peu le principe à partir de notre classe que l'on nomme arbitrairement `R`.

```py
class R:
    def __init__(self, end):
        if end <= 0:
            raise ValueError("Point d'arrêt de l'intervalle invalide")
        self.current = 0
        self.end = end
```

Voilà on initialise notre objet `__init__(self,…)` et on va lui passer un élément final `end` direct pour le moment on s'arrête au niveau de l'intervalle. On fait une petite sécurité simple si on veut une valeur positive `if end <= 0` et si c'est pas le cas on retourne une erreur histoire de ne pas accepter n'importe quoi comme erreur même si on pourrait compléter cette classe avec d'autant plus de vérification à ce niveau là. Ensuite on a notre valeur courante, notre valeur de départ `self.current = 0` c'est celle qu'on va en fait itéré mais on pourrait choisir autre chose c'est à dire qu'on pourrait choisir par exemple un système d'intervalle en partant d'un minimum et d'un maximum spécifié mais nous encore une fois on va rester sur un exemple un peu plus court avec un point de départ qui part toujours de 0 et un point d'arrêt qui sera exclu donc c'est un intervalle au 0 est inclus et ce qu'on aura dans `end` sera exclue comme c'est souvent le cas d'ailleurs en mathématique et qu’on travaillera du coup avec ce choix là. Tandis que pour `end` on reste avec ce choix de lui définir une valeur donnée par l'utilisateur.

On redéfinit nos méthodes spéciales.

```py
class R:
    def __init__(self, end):
        if end <= 0:
            raise ValueError("Point d'arrêt de l'intervalle invalide")
        self.current = 0
        self.end = end

    def __iter__(self):
        return self
    
    def __next__(self):


```

On réécrit une méthode spéciale et donc la première c'est `__iter__()` qui va faire office de littérateur c'est à dire qu'on va rendre `R` comme un itérateur et donc on va pouvoir se permettre de le retourner lui-même `return self` parce que littérateur a besoin d'implémenter sa méthode `__iter__()` aussi et on peut le retourner lui-même d'accord donc on retourne l'instance elle-même et comme ça on ne se prend pas la tête.

Ensuite on fait l'implémentation de la méthode spéciale `__next__()` et qui va nous permettre de parcourir cet élément tel que j'aimerais pouvoir parcourir les éléments ici.

```py
ran = R(5)

for v in ran:
    print(v)
```

Alors ça on peut très bien le faire avec un objet qui est déjà itérable, conçu par les développeurs de python `for … in …` mais si nous admettons on veut créer une classe forcément elle ne peut pas être itérable par défaut donc elle ne peut pas se comporter de manière à profiter les avantages des itérateurs donc on va rendre cela possible en implémentant cette méthode spéciale `__next__()` donc on va incrémenter `current` avec 1 pour parcourir chacune des valeurs et après on va simplement dire que c'est la valeur actuelle est plus grande que la valeur finale `self.end` donc notre point d'arrêt, et si c'est le cas on enlève la fameuse erreur `StopIteration` sinon on retourne simplement `self.current - 1` avec `-1` parce que je veux toujours prendre la valeur 0 à inclus parce que vu qu'on fait une incrémentation de un au début il va toujours commencer à retourner 1 alors que moi je veux qu'il commence à retourner 0.

```py
class R:
    def __init__(self, end):
        if end <= 0:
            raise ValueError("Point d'arrêt de l'intervalle invalide")
        self.current = 0
        self.end = end

    def __iter__(self):
        return self
    
    def __next__(self):
        self.current += 1

        if self.current > self.end:
            raise StopIteration
        
        return self.current - 1

ran = R(5)

for v in ran:
    print(v) # v est l'élément itérable
```
```powershell
> python .\main.py
0
1
2
3
4
```

Voilà ici on indique bien qu'on veut un intervalle jusqu à 5 donc c'est à dire de 0 inclus à 5 exclus.

Voilà on peut très bien changer ça par d'autres valeurs en changeant cette classe `Range` qui nous permet de créer ici un intervalle de valeur.

Avec cette réécriture de `__iter__()` et de `__next__()` nous obtenons notre élément itérable et on utilise l’ittérateur avec notre classe `R` qui fait office d’ittérateur c'est pour ça qu'on retourne `self` pour pouvoir ensuite au niveau du for() être utilisé ainsi la conception de cette boucle particulière va gérer ce type d'itération donc on n'a pas besoin de faire un try except de `StopIteration` donc tout est géré par la boucle for().

On peut également traiter le cas où j'ajoute une valeur négative.

```py
class R:
    def __init__(self, end):
        if end <= 0:
            raise ValueError("Point d'arrêt de l'intervalle invalide")
        self.current = 0
        self.end = end

    def __iter__(self):
        return self
    
    def __next__(self):
        self.current += 1

        if self.current > self.end:
            raise StopIteration
        
        return self.current - 1

try:
    ran = R(-10)
except ValueError as e:
    print(e)
else:
    for v in ran:
        print(v)
```
```powershell
> python .\main.py
Point d'arrêt de l'intervalle invalide
```

Voilà on protège et on sécurise ça ce niveau-là ce qui fait qu'ici j'ai voulu ajouter une valeur négative ce qui n'est pas bon et si j'indique 0 c'est la même chose et si j'indique une valeur positive c'est bon.

```py
#...
    ran = R(0)
#...
```
```powershell
> python .\main.py
Point d'arrêt de l'intervalle invalide
```

```py
#...
    ran = R(2)
#...
```
```powershell
> python .\main.py
0
1
```

Voilà on va de 0 à 1 donc 2 exclus.

On se concentre sur ces 2 méthodes spéciales pour tout ce qui est itérable.

Voilà pour le premier exemple.

Dans le cadre d'un jeu vidéo lorsqu'on a besoin d'avoir une structure qui existe déjà c'est à dire lorsqu'on part d'un type qui existe déjà en python et qui va intégrer une classe que l'on va écrire, pour ensuite ajouter notre surcouche pour l'itération sur ce type là c'est à dire qu'on va utiliser une liste plutôt que de devoir parcourir directement à la liste, nous on va la faire parcourir notre classe et en parcourant notre classe ça va itérer sur les éléments de la liste incorporé à la classe.

Admettons une classe qui va représenter un inventaire dans un jeu vidéo.

On part du principe que notre inventaire sera constitué de chaînes de caractères et ce sont les chaînes de caractères qui représenteront les objets.

```py
class Inventory:
    def __init__(self, name):
        self.name = name
        self.content = []
```

Voilà donc ceci `self.content = []` est une liste qui est un type itérable en python donc nous pour éviter de travailler directement avec ça, on va mettre une surcouche pour pouvoir finalement itérer sur `class Inventory` c'est à dire que moi je ne vais pas m'amuser à parcourir `self.content` qui n'a pas beaucoup de sens dit comme ça mais je veux pouvoir en l'occurrence parcourir le contenu de mon inventaire `Inventory` d'accord de cette classe ce qui est déjà beaucoup plus parlant donc on va réécrire les différentes méthodes dont on a besoin pour avoir cette surcouche d'abstraction ce qui va rendre les choses faciles par la suite.

On commence déjà par créer notre méthode pour ajouter un objet tel qu'on a vu la méthode append() pour les listes et donc on utilise ce qui existe déjà.

```py
class Inventory:
    def __init__(self, name):
        self.name = name
        self.content = []
    
    def add(self, item):
        self.content.append(item)
```

Voilà on peut donc le définir avec un nom `name`, par défaut c'est un inventaire vide `[]` pour rester simple, et on peut ajouter différents éléments mais encore une fois on n'a pas dit qu'est ce que c'était comme type donc nous ce seront des chaînes de caractères.

Ici on peut créer notre inventaire que l'on va appeler large malle et on ajoute nos différents éléments classique tel que le retrouve dans un RPG.

```py
class Inventory:
    def __init__(self, name):
        self.name = name
        self.content = []
    
    def add(self, item):
        self.content.append(item)

chest = Inventory("Large malle")

chest.add("Épée en bois")
chest.add("Potion de soins mineurs")
chest.add("Masque d'honneur")
```

Encore une fois si on veut faire un parcours de l'inventaire, on serait obligé de passer par `self.content = []` c'est à dire qu'on sera obligé de passer par une surcouche et de faire un `for item in chest.content` et parcourir chaque élément de la liste en utilisant son littérateur à elle `self.content = []` parce qu'ici on a un objet itérable mais nous on veut encore une fois parcourir directement l'inventaire `Inventory()` puisque évidemment on pourrait avoir d'autres éléments et tout ce qui est d'érable au niveau de notre inventeur actuellement ça va être `self.content = []` qui appartient à son contenu parce que c'est ça qui représente notre inventaire donc pour rendre tout cela possible parce que si j'essaye de faire un `for item in chest :` donc en gros pour chaque objet de l'inventaire ça ne marchera pas ! Parce que `Inventory("Large malle")` n’est pas un élément itérable.

```py
class Inventory:
    def __init__(self, name):
        self.name = name
        self.content = []
    
    def add(self, item):
        self.content.append(item)

chest = Inventory("Large malle")

chest.add("Épée en bois")
chest.add("Potion de soins mineurs")
chest.add("Masque d'honneur")

for item in chest:
    print(item)
```
```powershell
> python .\main.py
Traceback (most recent call last):
  File "C:\Users\sam\OneDrive\Bureau\Mementos\Python\tutos\Itérateurs\main.py", line 15, in <module>
    for item in chest:
TypeError: 'Inventory' object is not iterable
```

Voilà il nous dit que `Inventory` object is not iterable donc ce n'est pas un objet itérable et on obtient donc une `TypeError` et c'est normal d'avoir ce comportement là.

Maintenant on va rendre tout cela possible en réécrivant nos méthodes spéciales avec d'abord `__iter__(self)` qui va retourner notre inventaire et qui va faire office d’ittérateurs mais bien évidemment ça pourrait être une autre classe si on veut par exemple faire une classe à part qui l itérateur de notre inventaire, on aurait pu ainsi par exemple créer une classe `class InventoryIterator`.

```py
class InveoryIterator:
    pass

class Inventory:
    #...
```

Moi encore une fois on va rester sur quelque chose de très simple, on va utiliser les fonctionnalités de notre liste parce que c'est déjà un type qui existe dans python donc je vais créer mon itérateur sur un élément déjà itérable en python à savoir la liste `return iter(self.content)` comme ça j'utilise les fonctionnalités du langage et encore une fois on ne réinvente pas les choses. 

```py
class Inventory:
    def __init__(self, name):
        self.name = name
        self.content = []

    def __iter__(self):
        return iter(self.content)
    
    def add(self, item):
        self.content.append(item)

chest = Inventory("Large malle")

chest.add("Épée en bois")
chest.add("Potion de soins mineurs")
chest.add("Masque d'honneur")

for item in chest:
    print(item)
```

Maintenant si j'avais créé mon propre système de liste, il aurait fallu retourner ici `return iter(…ici…)` une instance de la classe qui représente une liste à moi mais comme python en a déjà pourquoi j'irai en réinventer d'autres.

Ensuite pareil on va faire appel à `__next__()` sur notre liste `return next(self.content)` puisque je sais que ma liste en python implémente ces 2 méthodes spéciales `__iter__()` et `__next__()` donc il n'y aura pas de problème à ce niveau-là donc ici je vais rendre itérable mon objet au complet.

```py
class Inventory: # class List
    def __init__(self, name):
        self.name = name
        self.content = []

    def __iter__(self):
        return iter(self.content)

    def __next__(self):
        return next(self.content)
    
    def add(self, item):
        self.content.append(item)

chest = Inventory("Large malle")

chest.add("Épée en bois")
chest.add("Potion de soins mineurs")
chest.add("Masque d'honneur")

for item in chest:
    print(item)
```
```powershell
> python .\main.py
Épée en bois
Potion de soins mineurs
Masque d'honneur
```

Voilà on peut parcourir les différents éléments comme si `Inventory` étais une liste, comme s'il était devenu de type `class List` alors qu'on voit bien que non parce que c'est de classe `class Inventory`.

Voilà on a rendu notre classe `Inventory` itérable comme une liste, comme un dictionnaire, comme un tuple et à la manière de n'importe quel autre type natif de python, on appeler mentent encore une fois les 2 méthodes adéquates `__iter__()` et `__next__()`.

Sachez qu’en Python, il y a toute une série d'outils d’itérateurs beaucoup plus avancé, beaucoup plus complexe et qui répondent des fois des besoins bien spécifiques donc je vous laisse bien sûr vous intéresser à ça si ça peut vous servir mais en tout cas maintenant vous savez ce qu'est précisément un littérateur, ce qui est un objet itérable et si vous avez besoin de mettre en œuvre ces différentes fonctionnalités au sein d'une classe d'un type d'objet que vous avez créé, vous savez comment faire et il vous suffit de vous entraîner maintenant avec quelques petits programmes pour pouvoir mettre ça en place dont on a vu 2 exemples qui peuvent vous servir de base avec un qui travaille sur l'itération d’entiers, un qui travaille sur l'itération de chaîne de caractères mais qui pourrait être une itération sur d'autres types donc à vous de voir. On pourrait très bien changer la liste par un dictionnaire, on pourrait également changer la liste par un type de données à vous donc à nous de voir.

À bientôt