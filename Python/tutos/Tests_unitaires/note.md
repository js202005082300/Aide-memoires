# [Tests unitaires](https://www.youtube.com/watch?v=apgReCCAQr4)

> Tests unitaires
+ [Préparation Tests unitaires](#Préparation-Tests-unitaires) (Importation de la bibliothèque `import unittest`)
+ [setUp](#setUp)
+ [tearDown](#tearDown)

> Tests sur DocStrings
+ [testmod](#testmod)
+ [testfile](#testfile)

Dans ce tutoriel nous allons voir comment effectuer des tests sur nos programmes.

Dans une première partie nous verrons comment faire des tests unitaires, nous allons voir ce que c'est et nous verrons que c'est très simple à comprendre.

En 2e partie nous allons voir comment nous servir des DocStrings qui sont les fameux commentaires avec 3 fois des doubles quotes `""" … """` pour pouvoir utiliser dans sa portion de commentaire les DocStrings et donc effectuer certains tests au niveau de nos programmes donc on verra ça en 2 parties avec 2 modules de python que vous pouvez utiliser nativement qui vont vous permettre de faire un petit peu tout ça.

Voici les gens programme, un code de départ pour gagner un peu de temps.

+ main.py
```py
#coding:utf-8
from src.panda import Panda

p = Panda("Kiko", 15)
print(p)
```
+ src/panda.py
```py
#coding:utf-8

class Panda:
    def __init__(self, name, age):
        assert name.isalnum(), "Attribut 'name' : doit être alphanumérique (a-z, A-Z et 0-9)"
        assert len(name) > 3 and len(name) <= 25, "Attribut 'name' : nombre de caractères > 3 et <= 25"
        assert isinstance(age, int), "Attribut 'age' : doit être un entier (instance de 'int')"
        assert age > 0 and age <= 100, "Attribut 'age' : nombre > 0 et <= 100"
        self.name = name
        self.age = age
        self.hunger = 50

    def __str__(self):
        return f"[Nom : {self.name} / Age : {self.age} / Faim : {self.hunger}/100]"

    def eat(self, food_points):
        if self.hunger >= 100:
            print(f"{self.name} a déjà bien mangé (faim : {self.hunger})")
        else:
            self.hunger += food_points
            if self.hunger > 100:
                print("Quel festin !")
                self.hunger = 100
            
            print(f"{self.name} vient de mangé (faim : {self.hunger})")

    def talk(self):
        print("Nioww !")

    def sleep(self):
        print("ZzzzZzzZzz")
```

Un fichier main.py qui est le fichier de lancement avec un répertoire src qui contient les différentes classes au niveau de notre projet.

On a une classe Panda qui représente un panda, au niveau du constructeur on fait certaines vérifications `assert …` notamment pour s'assurer que le nom Eh bien alphanumérique `name.isalnum()`. Ensuite il doit contenir entre 3 et 25 caractères `assert len(name) > 3 and len(name) <= 25`. Ensuite on vérifie que l'âge est bien un entier `assert isinstance(age, int)` et enfin que l'âge est bien compris entre 0 et 100 `assert age > 0 and age <= 100`.

Je rappelle que les assertions `assert` est une notion que l'on a vu dans la vidéo sur la gestion des erreurs dans le cours, ça sert aux développeurs pour être sûr de ne pas noter n'importe quoi au niveau du code et par exemple ici créer un panda qui aurait -1 an.

Voilà ça sert à ce genre de chose.

Ensuite on a notre différents attributs dans le constructeur toujours, un attribut pour le nom `self.name`, un attribut pour l'âge `self.age` est un attribut pour le niveau de faim `self.hunger`.

```py
    def __str__(self):
        return f"[Nom : {self.name} / Age : {self.age} / Faim : {self.hunger}/100]"
```

On a une redéfinition ici de la méthode `__str__(self)`, la méthode spéciale simplement pour pouvoir afficher les informations du panda.

Ensuite on a une méthode pour faire manger le panda, eat() qui tout simplement on va vérifier si le niveau de faim est supérieur ou égal à 100 , c'est à dire qu'ici notre maximum qui ont choisi arbitrairement pour le programme donc on indique simplement si le panda a suffisamment mangé et si c'est le cas on ne le fait pas manger en plus sinon on a crémant tout simplement par le nombre de points `food_points` qu'on a donné à la faim et si cette jauge de faim est supérieure à 100, on la réaffecte à 100 si jamais ça a dépassé cette valeur. Puis on termine par afficher quelques informations bien évidemment.

Enfin on a une petite méthode pour le faire parler, talk() et une petite méthode pour le faire dormir sleep().

Maintenant au niveau de notre fichier main.py

+ main.py
```py
#coding:utf-8
from src.panda import Panda

p = Panda("Kiko", 15)
print(p)
```

On apporte notre classe Panda, en crée une instance de cette classe et on affiche avec un `print(p)` Pour rappel en faisant ce print print() cela appelle la méthode spéciale `__str__(self)` que nous avons en l'occurrence redéfinie ce qui nous affichera les informations qu'on a écrit en plus.

On test.

```powershell
> python main.py
[Nom : Kiko / Age : 15 / Faim : 50/100]
```

Voilà on obtient bien toutes les informations.

## Préparation Tests unitaires

Alors comment vont se passer ces différents tests unitaires ? Quand on parle de test unitaire, on parle de test isolé c'est à dire qu'on va tester une portion de notre code donc ça peut être par exemple la vérification de la valeur d'un attribut, l'instance de l'attribut en question par rapport à quelle instance il appartient où ça peut être tout simplement le bon fonctionnement d'une fonction, de vérifier lorsqu'on fait appel à une fonction et qu'on le passe des arguments en entrée, vérifier qu'on retourne bien le résultat attendu ainsi quand on n'a pas de comportement inattendu ça va nous permettre la non-régression du code.

Alors quand on parle de non-régression, qu'est-ce que ça veut dire ? Il faut comprendre que à certains stades du code, vous allez écrire du code et vous allez effectuer des vérifications, des tests de fonctionnement et vérifier que le code fait ce qui était convenu sans problème et par la suite vous allez ajouter du contenu, implémenter de nouvelles choses et là pas de bol en implémentant de nouvelles fonctionnalités, on se retrouve à casser du code qui fonctionnait avant et vous perdez en fonctionnalités, en fonctionnement c'est à dire que vous avez de la régression de code c'est-à-dire avec des choses qui fonctionnaient au départ et puis qu'il ne fonctionne plus après la modification où l'ajout d'implémentation dans notre projet, ce qui serait très dommageable et assez lourd de conséquences quant au travail sur un projet conséquent.

Voilà on veut éviter au maximum ce genre de situation, et on se sert des tests pour cela, alors comment allons-nous effectuer des tests très simples, la méthode qui me semble la plus pratique est de séparer ces différents fichiers.

```txt
C.
|_ src
|   |_ panda.py
|_ main.py
```

Admettons qu'on veut distribuer le programme final à un utilisateur, on lui distribuerait ces fichiers-là ainsi les tests ne vont servir qu'au développeur parce que ce n'est pas à l'utilisateur final ou le joueur qui va tester le code c'est à dire que lui il s'en fiche du code, ce n'est pas son travail et ce n'est pas son job donc il est là pour tester le programme et jouer avec, le exécuter mais pas vérifier si le code a été correct ou pas, correctement développé.

Ainsi on va créer un dossier séparé que l'on va appeler test tout simplement, et on crée testpanda.py

```txt
C.
|_ src
|   |_ panda.py
|_ tests
|   |_ testpanda.py
|_ main.py
```

On apporte la bibliothèque `unittest` avec 2 T, ancrer notre classe `TestPanda` pourquoi ça correspond bien au nom de fichier et que ce soit bien explicite, et cette classe va hériter de la classe TestCase qui va nous permettre de tester des 4 figures donc des scénarios bien précis par rapport à ce que nous voulons faire.

+ test/testpanda.py
```py
#coding:utf-8
import unittest

class TestPanda(unittest.TestCase):
```

À partir de là nous allons définir, autant de méthodes que de test que vous voulez faire de manière isolée mais le test le plus simple que l'on puisse faire ce serait par exemple de dire que je vais être sûr d'avoir bien créé un panda lorsque je créé mon instance `p = Panda("Kiko", 15)` ainsi je veux sûr que j'ai bien un panda qui a été créé et en l'occurrence comme je fais ici pas mal de assertions `assert` au niveau de mon constructeur, logiquement Simon panda a fini par écrire c'est que ces informations d'assertion ont été validées sachant que si il y a une de ces assertions qui n'a pas été validée ça va déclencher une `AssertionError` donc une exception et le programme va s'arrêter donc on n'aura pas la création du panda donc ça peut être pas mal de vérifier ça.

Alors Pour ce faire le module TestCase propose tout un tas de méthodes pour faire ces assertions, toutes ces vérifications alors dans la description de la vidéo il y a un lien vers le github avec tout un tas de méthodes et pareil vous avez la documentation de python qui est déjà très complète si vous voulez récupérer tout le détail des explications et cetera.

[Méthodes pour les tests unitaires](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/Python/methodes-tests-unitaires.md)

Maintenant nous allons vérifier que le panda que nous créons est effectivement une instance de Panda même si ça peut être très simple comme test nous allons vérifier donc ici je vais faire ceci avec le nom de test le plus explicite possible `test_panda_is_instance_of_panda` et on passe `self` parce qu'on a besoin de travailler avec.

+ test/testpanda.py
```py
#coding:utf-8
import unittest

class TestPanda(unittest.TestCase):
    def test_panda_is_instance_of_panda(self):
        p = Panda("Kiko", 15)
        self.assert
```

Alors avec self, nous allons appeler une méthode qui commence par `assert` et après nous avons tout un tas de mettre disponibles en fonction de ce qu'on veut tester. On peut par exemple tester qu'une valeur est égale à True, qu'une valeur est égale à False, qu'une valeur appartient à une séquence, une structure, qu'une valeur est égale à une autre ou qu'elle est différente, plus grand, inférieur et cetera.

Bref nous avons plusieurs tests disponibles que l'on peut retrouver via ce lien.

[Méthodes pour les tests unitaires](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/Python/methodes-tests-unitaires.md)

À partir de là je veux vérifier que `p` est bien une instance de Panda, effectivement qu'on a pu créé cet objet c’est-à-dire quand est fait l'installation ici de notre classe Panda donc la méthode c'est assertIsInstance() donc attention en majuscule à chaque mot et là on va vérifier que `p` est bien une instance de cette classe `Panda`.

+ test/testpanda.py
```py
#coding:utf-8
import unittest

class TestPanda(unittest.TestCase):
    def test_panda_is_instance_of_panda(self):
        p = Panda("Kiko", 15)
        self.assertIsInstance(p, Panda)
```

On peut éventuellement définir d'autres méthodes, ainsi une méthode par test différent et les ajouter comme ça au fur et à mesure par exemple test si l'âge est positif avec la méthode `self.assertGreater(p.age, 0)` où on veut que l'âge soit supérieur à 0.

+ test/testpanda.py
```py
#coding:utf-8
import unittest

class TestPanda(unittest.TestCase):
    def test_panda_is_instance_of_panda(self):
        p = Panda("Kiko", 15)
        self.assertIsInstance(p, Panda)
    
    def test_panda_age_is_positive(self):
        p = Panda("Kiko", 15)
        self.assertGreater(p.age, 0)
```

Pareil on a des méthodes qui sont déjà définies dans le module `TestCase` et on a plus qu'à appeler, faire les différents tests en fonction.

Voilà on fait autant de méthode que l'on veut dans cette classe `TestPanda` et à partir de là on va pouvoir tester chacun d'afficher notamment ce fichier testpanda.py, on va pouvoir l'exécuter de manière isolée sans s'occuper de ce qui a été fait à côté mais déjà on va commencer par importer tout ce qui est panda sinon ça ne marchera pas `import sys` puis on va faire la commande suivante pour importer le répertoire parent `sys.path.append("..")`. Cette commande pour importer le répertoire parent risque d'intéresser les personnes qui sont sur le projet Tomo. 

À partir de là on va pouvoir faire `from src.panda import Panda`.

+ test/testpanda.py
```py
#coding:utf-8
import sys
sys.path.append("..")
from src.panda import Panda

import unittest

class TestPanda(unittest.TestCase):
    def test_panda_is_instance_of_panda(self):
        p = Panda("Kiko", 15)
        self.assertIsInstance(p, Panda)
    
    def test_panda_age_is_positive(self):
        p = Panda("Kiko", 15)
        self.assertGreater(p.age, 0)
```

Maintenant comment on est en train d'exécuter depuis ce fichier-là depuis la console on va utiliser cette ligne de code `if __name__ == `__main__`:` et on va appeler la méthode main `unittest.main()` qui va tout simplement exécuter tous les tests un à un et qui va vous présenter le résultat de ces tests, ce qui est très pratique.

+ test/testpanda.py
```py
#coding:utf-8
import sys
sys.path.append("..")
from src.panda import Panda

import unittest

class TestPanda(unittest.TestCase):
    def test_panda_is_instance_of_panda(self):
        p = Panda("Kiko", 15)
        self.assertIsInstance(p, Panda)
    
    def test_panda_age_is_positive(self):
        p = Panda("Kiko", 15)
        self.assertGreater(p.age, 0)

if __name__ == '__main__':
    unittest.main()
```

Alors c'est très pratique même si ça rajoute un petit peu de travail et donc évidemment si vous avez moins de test, vous aurez moins de travail.

À partir de là comment allons-nous tester cela ? On va dans notre répertoire de test, et on peut exécuter directement le test.

```powershell
> cd tests      
> python .\testpanda.py
..
----------------------------------------------------------------------
Ran 2 tests in 0.001s

OK
```

Alors on va `..`, ces 2 petits caractères nous indiquent qu'il y a 2 tests qui ont été faits avec un certain nombre de temps, et on n'a pas beaucoup d'infos c'est à dire qu'on a juste le message `OK` ce qui signifie ce qu'il n'y a pas eu d'erreur à ce niveau-là.

Si on veut plus d'informations il faut utiliser l'argument `-v` ce qui permet le mode verbeux c'est à dire un mode un peu plus détaillé.

```powershell
> python .\testpanda.py -v
test_panda_age_is_positive (__main__.TestPanda) ... ok
test_panda_is_instance_of_panda (__main__.TestPanda) ... ok

----------------------------------------------------------------------
Ran 2 tests in 0.001s

OK
```

Voilà avec le mot verbe c'est un petit peu plus détaillé et donc on voit tous les tests qui ont été passés, ils sont tous les 2 okay ainsi on constate bien que quand on fait ce qu'on a fait on obtient via un panda par rapport à la création.

Maintenant admettons que développeur vient instancier un objet de la classe panda en mettant une information qui ne conviens pas automatiquement ça ne marchera pas, alors par exemple on peut le vérifier en mettant un flottant `15.64` à la place du nom `"Kiko"`.

+ test/testpanda.py
```py
#coding:utf-8
import sys
sys.path.append("..")
from src.panda import Panda
import unittest

class TestPanda(unittest.TestCase):
    def test_panda_is_instance_of_panda(self):
        p = Panda(15.64, 15)
        self.assertIsInstance(p, Panda)
    
    def test_panda_age_is_positive(self):
        p = Panda("Kiko", 15)
        self.assertGreater(p.age, 0)

if __name__ == '__main__':
    unittest.main()
```
```powershell
> python .\testpanda.py -v    
test_panda_age_is_positive (__main__.TestPanda) ... ok
test_panda_is_instance_of_panda (__main__.TestPanda) ... ERROR

======================================================================
ERROR: test_panda_is_instance_of_panda (__main__.TestPanda)
----------------------------------------------------------------------
Traceback (most recent call last):
  File "C:\Users\sam\OneDrive\Aide-mémoires\Python\tutos\demo_tests_unitaires\tests\testpanda.py", line 9, in test_panda_is_instance_of_panda
    p = Panda(15.64, 15)
  File "C:\Users\sam\OneDrive\Aide-mémoires\Python\tutos\demo_tests_unitaires\tests\..\src\panda.py", line 5, in __init__
    assert name.isalnum(), "Attribut 'name' : doit être alphanumérique (a-z, A-Z et 0-9)"
AttributeError: 'float' object has no attribute 'isalnum'

----------------------------------------------------------------------
Ran 2 tests in 0.002s

FAILED (errors=1)
```

Voilà on voit qu'elle y a eu un FAILED donc une erreur qui a été indiquée donc ça vous indique l'erreur avec toutes les informations avec l'assertion testée `name.isalnum()` qui teste si c'est un ne éléments alphanumériques effectivement ici ça ne l'est plus et ça c'est dû au fait qu'on a essayé d'utiliser isalnum() sur une information qui est un float donc là ce n'est pas bon.

Le message nous indique bien que c'est ce test test_panda_is_instance_of_panda() qui n'a pas marché c'est-à-dire qu'on a effectivement pas pu créer un panda puisque l'information n'était pas bonne à cause de cette assertion donc très pratique pour vérifier tout un tas d'informations.

Après bien sûr si vous voulez faire d'autres tests voulez ajouter au fur et à mesure où il suffit de faire d'autres méthodes les ajouter.

```py
class TestPanda(unittest.TestCase):
    def#...
    def#...
    def#...
    def#...
```

Maintenant peut être que certains d'entre vous auront remarqué a un problème par rapport à cette écriture, notamment qu'à chaque méthode, on a dû recréer un panda `p = Panda("Kiko", 15)` donc en regardant mon code ça fait de la répétition ce qui veut dire aussi qu à chaque test on va devoir recréer un nouveau panda ainsi on va devoir recréer à chaque fois tout un tas de données pour faire des tests mais maintenant est ce qu'il n'y a pas moyen de factoriser ça, évidemment si on se pose la question ici c'est que tout à fait possible.

## setUp

Merci maintenant on va préparer des données avant chacun des tests c'est-à-dire qu'avant chaque appel de test, donc chaque appelle à ces différentes méthodes, on va faire appel à des méthodes spéciales c'est-à-dire qu'en tout cas le module `unittest` va chercher des méthodes bien spécifiques pour préparer les données alors attention ces données sont appelées pour tous les tests.

Cette méthode porte le nom de setUp() et là on va lui indiquer toutes les choses que l'on veut préparer et comme ça va appartenir à cette classe `TestPanda`, il est très important de faire des attributs à cette classe donc en l'occurrence on va faire par exemple `self.p = Panda()` et là dans notre méthode de test unitaire `assertGreater(self.p.age, 0)`, on lui passe `self.p.age` au lieu de `p.age`.

+ test/testpanda.py
```py
#coding:utf-8
import sys
sys.path.append("..")
from src.panda import Panda
import unittest

class TestPanda(unittest.TestCase):
    def setUp(self):
        self.p = Panda("Kiko", 15)

    def test_panda_is_instance_of_panda(self):
        #p = Panda(15.64, 15)
        #self.assertIsInstance(p, Panda)
        self.assertIsInstance(self.p, Panda)
    
    def test_panda_age_is_positive(self):
        #p = Panda("Kiko", 15)
        #self.assertGreater(p.age, 0)
        self.assertGreater(self.p.age, 0)

if __name__ == '__main__':
    unittest.main()
```

Alors maintenant qu'est ce qui va se passer ? On va vouloir faire le premier test test_panda_is_instance_of_panda() ce qu'il va faire setUp() pour préparer les données et en utilisant ces données nous allons pouvoir tester cette assertion et pareil pour l'autre méthode.

On test.

```powershell
> python .\testpanda.py -v    
test_panda_age_is_positive (__main__.TestPanda) ... ok
test_panda_is_instance_of_panda (__main__.TestPanda) ... ok

----------------------------------------------------------------------
Ran 2 tests in 0.001s

OK
```

Voilà les tests sont validés sans problème.

Voilà ça a bien pris en compte le panda qu'on a passé, d'ailleurs il suffit de vérifier en mettant une valeur d'âge qui est supérieure à 100 et là vous allez voir que le test ne passe plus.

+ test/testpanda.py
```py
#coding:utf-8
import sys
sys.path.append("..")
from src.panda import Panda
import unittest

class TestPanda(unittest.TestCase):
    def setUp(self):
        self.p = Panda("Kiko", 150)

    def test_panda_is_instance_of_panda(self):
        #p = Panda(15.64, 15)
        #self.assertIsInstance(p, Panda)
        self.assertIsInstance(self.p, Panda)
    
    def test_panda_age_is_positive(self):
        #p = Panda("Kiko", 15)
        #self.assertGreater(p.age, 0)
        self.assertGreater(self.p.age, 0)

if __name__ == '__main__':
    unittest.main()
```
```powershell
> cd .\tests\
> python .\testpanda.py
FF
======================================================================
FAIL: test_panda_age_is_positive (__main__.TestPanda)
----------------------------------------------------------------------
Traceback (most recent call last):
  File "C:\Users\sam\OneDrive\Aide-mémoires\Python\tutos\demo_tests_unitaires\tests\testpanda.py", line 9, in setUp
    self.p = Panda("Kiko", 150)
  File "C:\Users\sam\OneDrive\Aide-mémoires\Python\tutos\demo_tests_unitaires\tests\..\src\panda.py", line 8, in __init__
    assert age > 0 and age <= 100, "Attribut 'age' : nombre > 0 et <= 100"
AssertionError: Attribut 'age' : nombre > 0 et <= 100

======================================================================
FAIL: test_panda_is_instance_of_panda (__main__.TestPanda)
----------------------------------------------------------------------
Traceback (most recent call last):
  File "C:\Users\sam\OneDrive\Aide-mémoires\Python\tutos\demo_tests_unitaires\tests\testpanda.py", line 9, in setUp
    self.p = Panda("Kiko", 150)
  File "C:\Users\sam\OneDrive\Aide-mémoires\Python\tutos\demo_tests_unitaires\tests\..\src\panda.py", line 8, in __init__
    assert age > 0 and age <= 100, "Attribut 'age' : nombre > 0 et <= 100"
AssertionError: Attribut 'age' : nombre > 0 et <= 100

----------------------------------------------------------------------
Ran 2 tests in 0.001s

FAILED (failures=2)
```

Voilà ici on obtient 2 erreurs c'est à dire plus d'erreur que prévu ce qui est normal à cause des assertions `assert` que l'on fait dans notre constructeur. Il y a plus d'erreurs que prévu parce que les tests unitaires prennent en compte les assertions `assert` que nous avions fait dans notre constructeur donc ça prend quand des erreurs en plus. Ainsi pas de problème à ce niveau-là parce que c'est exactement ce qu'on attendait.

Du fait qu'on n'a pas pu valider l'âge (150 ans), on n'a pas pu créer notre instance de panda et du coup le 2e test n'a pas été validé non plus.

## tearDown

Alors il existe une autre méthode si on veut pouvoir nettoyer les données après chaque test, on peut utiliser une autre méthode qui est tearDown() qui permet comme ça de changer certaines informations.

Voilà cette méthode va nous permettre de pouvoir changer les informations, les remettre à 0, on peut par exemple faire ça `self.p.age(1564)`.

```py
def tearDown(self):
```
+ test/testpanda.py
```py
#coding:utf-8
import sys
sys.path.append("..")
from src.panda import Panda
import unittest

class TestPanda(unittest.TestCase):
    def setUp(self):
        self.p = Panda("Kiko", 150)

    def tearDown(self):
        self.p.age(1564)

    def test_panda_is_instance_of_panda(self):
        self.assertIsInstance(self.p, Panda)
    
    def test_panda_age_is_positive(self):
        self.assertGreater(self.p.age, 0)

if __name__ == '__main__':
    unittest.main()
```

À l'exécution ne va pas trop forcément la différence, ensuite le tearDown() c'est ce qui va être fait après sachant que setUp() est ce qui va préparer les données quand on va lancer un test, ensuite on va lancer les tests assertIsInstance() et assertGreater() et enfin, on utilisera tearDown() qui va permettre de faire un nettoyage de données vous appliquez d'autres informations pour ensuite effectuer d'autres tests. Ainsi si vous en avez besoin vous pouvez utiliser cette méthode là qui sera appelée automatiquement au niveau de vos tests.

Pour rappel la méthode setUp(), est très pratique surtout si vous avez des tests répétitifs notamment dans la création de structures et cetera, ne vous amusez pas à les faire dans chacune des méthodes à chaque fois donc utiliser cette méthode setUp() dans lequel vous définissez tout comme attributs de la classe via le mot-clé `self` et à partir de là vous travaillez directement là-dessus.

Alors au niveau des tests unitaires nous allons nous arrêter là.

Voilà c'est déjà pas mal bien sûr on peut faire beaucoup plus de choses, on peut faire de la découverte de test, on peut passer par des packages pour ne pas avoir ça que dans un seul fichier mais dans plusieurs fichiers répartis dans plusieurs répertoires. Voilà vous vous doutez bien qu'il y a tout un tas de façons de procéder mais voilà ici on a vu la solution la plus facile à mettre en place qui est suffisamment efficace et qui fait très bien le travail à ce niveau-là et au moins comme ça on peut gérer au cas un à un donc pas de soucis à ce niveau-là.

Si plus tard on a une autre classe voir même un autre module avec par exemple un module où il y aurait que des fonctions et on peut imaginer comme ça un fichier qui va tester toutes les fonctions de notre module comme ça on a limite une méthode par fonction à tester qui ferait simplement appel à la fonction en question et vérifiez via un `assert` qu'on a bien résultat attendu.

Voilà à vous de voir et d'adapter à votre usage pour que ces tests soient efficaces par rapport au vérification que vous voulez faire de votre programme.

## testmod

La 2nde partie de ce tutoriel va concerner les DocStrings c'est à dire qu'ici on ne va plus utiliser les tests mais les DocStrings qu'on peut utiliser pareil en même temps mais ce n'est pas la même chose, on peut donc parfaitement utiliser les 2.

Les DocStrings sont quelque chose de pas mal pratique et du coup on va l'aborder dans cette vidéo et pour cela on va utiliser un module qui s'appelle `doctest` pour dire qu'on veut tester les textes que l'on a mis dans les DocStrings de ce fichier panda.py

```py
#coding:utf-8

class Panda:
    def __init__(self, name, age):
        assert name.isalnum(), "Attribut 'name' : doit être alphanumérique (a-z, A-Z et 0-9)"
        assert len(name) > 3 and len(name) <= 25, "Attribut 'name' : nombre de caractères > 3 et <= 25"
        assert isinstance(age, int), "Attribut 'age' : doit être un entier (instance de 'int')"
        assert age > 0 and age <= 100, "Attribut 'age' : nombre > 0 et <= 100"
        self.name = name
        self.age = age
        self.hunger = 50

    def __str__(self):
        return f"[Nom : {self.name} / Age : {self.age} / Faim : {self.hunger}/100]"

    def eat(self, food_points):
        if self.hunger >= 100:
            print(f"{self.name} a déjà bien mangé (faim : {self.hunger})")
        else:
            self.hunger += food_points
            if self.hunger > 100:
                print("Quel festin !")
                self.hunger = 100
            
            print(f"{self.name} vient de mangé (faim : {self.hunger})")

    def talk(self):
        print("Nioww !")

    def sleep(self):
        print("ZzzzZzzZzz")

if __name__ == '__main__':
    import doctest
    doctest.testmod()
```

Alors on va directement exécuter ce fichier panda.py et dire que si on exécute ce fichier, on importe `doctest` et on utilise la méthode testmod() que l'on va importer tout simplement pour tester le module parce que Pour rappel les modules ce sont les fichiers tout simplement.

Alors que va vérifier cette méthode testmod() ? Elle va vérifier encore une fois toutes les DocStrings.

```py
if __name__ == '__main__':
    import doctest
    doctest.testmod()
```

Ensuite on va virer toutes les assertions pour ne pas s'embrouiller.

```py
#coding:utf-8

class Panda:
    def __init__(self, name, age):
        self.name = name
        self.age = age
        self.hunger = 50

    def __str__(self):
        return f"[Nom : {self.name} / Age : {self.age} / Faim : {self.hunger}/100]"

    def eat(self, food_points):
        if self.hunger >= 100:
            print(f"{self.name} a déjà bien mangé (faim : {self.hunger})")
        else:
            self.hunger += food_points
            if self.hunger > 100:
                print("Quel festin !")
                self.hunger = 100
            
            print(f"{self.name} vient de mangé (faim : {self.hunger})")

    def talk(self):
        print("Nioww !")

    def sleep(self):
        print("ZzzzZzzZzz")

if __name__ == '__main__':
    import doctest
    doctest.testmod()
```

Ici on va illustrer avec quelques exemples mais si on doit employer ce genre d'outils, il faudra l'utiliser dans un cas bien créer et correctement, c'est à dire dans un cas concret et utile parce que ce n'est pas bien sûr fait pour ajouter du code inutilement.

La première chose que l'on pourrait vérifier c'est de vérifier si Panda est une instance donc on va faire une instance.

Par exemple je vais mettre directement au niveau de la classe une DocString, admettons qu'on mette une description "Classe qui représente un panda" et on va vouloir effectuer des tests et pour indiquer un test à vérifier on va utiliser ce symbole `>>>` c'est à dire 3 chevrons comme ça, et on aura une méthode python `>>> isinstance()` pour le module python c'est à dire qu'ici on n'est pas dans le module unit test donc attention à ne pas là confondre avec la méthode de tout à l'heure donc ça c'est tout simplement une fonction intégrée de python comme on en a déjà vu plein qui permet de vérifier si une donnée est d'une instance bien précise donc moi je vais vérifier que `Panda("Kinou", 15)` est bien de l'instance `Panda`.

```py
"""
Classe qui représente un Panda
>>> isinstance(Panda("Kinou", 15), Panda)
True
"""
```

```py
#coding:utf-8

"""
Classe qui représente un Panda
>>> isinstance(Panda("Kinou", 15), Panda)
True
"""
class Panda:
    def __init__(self, name, age):
        self.name = name
        self.age = age
        self.hunger = 50

    def __str__(self):
        return f"[Nom : {self.name} / Age : {self.age} / Faim : {self.hunger}/100]"

    def eat(self, food_points):
        if self.hunger >= 100:
            print(f"{self.name} a déjà bien mangé (faim : {self.hunger})")
        else:
            self.hunger += food_points
            if self.hunger > 100:
                print("Quel festin !")
                self.hunger = 100
            
            print(f"{self.name} vient de mangé (faim : {self.hunger})")

    def talk(self):
        print("Nioww !")

    def sleep(self):
        print("ZzzzZzzZzz")

if __name__ == '__main__':
    import doctest
    doctest.testmod()
```

Alors maintenant le résultat qui est attendu c'est à dire que quand on prend `isinstance(Panda("Kinou", 15), Panda)` si on veut un fonctionnement correct de notre programme, cette fonction isinstance() si je la testais dans mon programme et que logiquement tout est bien fait, s'il n'y a pas d'erreur dans mon programme, ça doit retourner True.

```py
"""
Classe qui représente un Panda
>>> isinstance(Panda("Kinou", 15), Panda)
True
"""
```

Vous voyez vous mettez comme ça le test après 3 chevrons `>>>` et à la ligne vous mettez directement le résultat qui est attendu donc ici je n'ai mis qu'un seul test, et on va déjà tester avec ça.

```powershell
> python panda.py
```

Voilà si ça s'affiche c'est qu'il n'y a pas eu d'erreur et que le test s'est bien passé, encore une fois si on veut que ce soit en mode verbeux on utilise l'argument `-v`.

```powershell
> python panda.py -v  
Trying:
    isinstance(Panda("Kinou", 15), Panda)
Expecting:
    True
ok
6 items had no tests:
    __main__.Panda
    __main__.Panda.__init__
    __main__.Panda.__str__
    __main__.Panda.eat
    __main__.Panda.sleep
    __main__.Panda.talk
1 items passed all tests:
   1 tests in __main__
1 tests in 7 items.
1 passed and 0 failed.
Test passed.
```

Voilà avec l'argument `-v`, on a le détail qui est affiché et on va voir comment ça fonctionne, c'est encore une fois toute utilité de ce genre d'outils.

Il est indiqué qu'on a essayé de faire `isinstance(Panda("Kinou", 15), Panda)` pour voir si ça retourne bien True donc on a le test que l'on fait avec la méthode isinstance() ainsi que le résultat attendu, effectivement si ce résultat a été retourné il sera affiché 'ok' donc alors il peut y avoir toute une série de compléments donc le test a été validé.

Voyez c'est très pratique et ça permet de faire plein de vérifications, des fois c'est même plus rapide que des tests unitaires ainsi dans des cas très basique, on peut utiliser ce genre de chose et après quand on a besoin de cas un peu plus développé, on peut passer par des tests unitaires donc on peut parfaitement gérer les 2 outils en fonction de la façon dont on veut gérer ça.

Alors est ce qu'on veut inclure nos tests là-dedans.

```py
"""
Classe qui représente un Panda
>>> isinstance(Panda("Kinou", 15), Panda)
True
"""
```

.. ou les faire directement dans les tests unitaires.

Alors on peut bien évidemment avoir d'autres test, admettons par exemple qu'on était vérification mathématique à faire ou bien ici dans mon cas on va essayer le test `Panda.get_number_50()`

```py
"""
Classe qui représente un Panda
>>> isinstance(Panda("Kinou", 15), Panda)
True
>>> Panda.get_number_50()
50
"""
```

Voilà on va tester le retour de cette fonction get_number_50() qui doit retourner 50.

```py
def get_number_50(self):
        return 50
```
Voilà comme la méthode n'est pas statique ça ne marche pas avec le mot-clé self, du coup on pourrais mettre un décorateur `@staticmethod` mais le test ne marcherais pas donc on retirera le mot clé self.
```py
@staticmethod
def get_number_50(cls):
        return 50
```
On va définir la méthode comme ceci.
```py
#coding:utf-8

"""
Classe qui représente un Panda
>>> isinstance(Panda("Kinou", 15), Panda)
True
>>> Panda.get_number_50()
50
"""
class Panda:
    def __init__(self, name, age):
        self.name = name
        self.age = age
        self.hunger = 50

    def get_number_50():
            return 50

    def __str__(self):
        return f"[Nom : {self.name} / Age : {self.age} / Faim : {self.hunger}/100]"

    def eat(self, food_points):
        if self.hunger >= 100:
            print(f"{self.name} a déjà bien mangé (faim : {self.hunger})")
        else:
            self.hunger += food_points
            if self.hunger > 100:
                print("Quel festin !")
                self.hunger = 100
            
            print(f"{self.name} vient de mangé (faim : {self.hunger})")

    def talk(self):
        print("Nioww !")

    def sleep(self):
        print("ZzzzZzzZzz")

if __name__ == '__main__':
    import doctest
    doctest.testmod()
```
```powershell
> python panda.py   
> python panda.py -v
Trying:
    isinstance(Panda("Kinou", 15), Panda)
Expecting:
    True
ok
Trying:
    Panda.get_number_50()
Expecting:
    50
ok
7 items had no tests:
    __main__.Panda
    __main__.Panda.__init__
    __main__.Panda.__str__
    __main__.Panda.eat
    __main__.Panda.get_number_50
    __main__.Panda.sleep
    __main__.Panda.talk
1 items passed all tests:
   2 tests in __main__
2 tests in 8 items.
2 passed and 0 failed.
Test passed.
```

Voilà on teste l'appel à cette fonction, dans lequel on attend un retour de la valeur 50 `Expecting: 50`, c'est bien ce qui a été retourné donc c'est okay.

Voilà alors ce n'est pas un exemple très intéressant par rapport au panda mais voilà ça montre en effet tout ce qu'on peut tester, on peut tester via des méthodes, des fonctions et cetera pour vérifier des parties bien précises de notre code ainsi ici j'ai mis des DocStrings au niveau de la classe mais bien sûr ça peut être remis à l'intérieur donc j'aurais pu sans problème faire ceci, tester la méthode au-dessus de celle-ci.

```py
#coding:utf-8

"""
Classe qui représente un Panda
>>> isinstance(Panda("Kinou", 15), Panda)
True
"""
class Panda:
    def __init__(self, name, age):
        self.name = name
        self.age = age
        self.hunger = 50

    """
    >>> Panda.get_number_50()
    50
    """
    def get_number_50():
            return 50

    def __str__(self):
        return f"[Nom : {self.name} / Age : {self.age} / Faim : {self.hunger}/100]"

    def eat(self, food_points):
        if self.hunger >= 100:
            print(f"{self.name} a déjà bien mangé (faim : {self.hunger})")
        else:
            self.hunger += food_points
            if self.hunger > 100:
                print("Quel festin !")
                self.hunger = 100
            
            print(f"{self.name} vient de mangé (faim : {self.hunger})")

    def talk(self):
        print("Nioww !")

    def sleep(self):
        print("ZzzzZzzZzz")

if __name__ == '__main__':
    import doctest
    doctest.testmod()
```
```powershell
> python panda.py -v
Trying:
    isinstance(Panda("Kinou", 15), Panda)
Expecting:
    True
ok
7 items had no tests:
    __main__.Panda
    __main__.Panda.__init__
    __main__.Panda.__str__
    __main__.Panda.eat
    __main__.Panda.get_number_50
    __main__.Panda.sleep
    __main__.Panda.talk
1 items passed all tests:
   1 tests in __main__
1 tests in 8 items.
1 passed and 0 failed.
Test passed.
```

Voilà si on veut organiser un peu notre code correctement on peut faire de cette manière.

On pourra voilà utiliser les DocStrings si on veut par exemple effectuer un test sur une petite méthode comme getNumber() ainsi on pourra faire la vérification à ce niveau-là.

## testfile

Alors aussi on va pouvoir travailler avec un fichier avec la méthode testfile() où vous indiquer les tests que l'on fait dans un simple fichier .txt

```py
if __name__ == '__main__':
    import doctest
    doctest.testfile("tests.txt")
```

et au lieu de passer par testmod() pour tester le module, on créé en fait un fichier qui sera analysé pour pouvoir effectuer les tests depuis un fichier.

Voilà si vous préférez déporter vos tests dans un fichier plutôt que de le mettre directement dans un code source, vous pouvez faire ça également.

N'hésitez pas à voir comment ça fonctionne.

Voilà on va s'arrêter là, alors on utilisera peut être beaucoup moins souvent les DocStrings pour faire des tests mais ça peut être pratique dans certains cas même si on a un exemple qui n'était pas suffisamment parlant.

Alors si vous vous posez la question de savoir quand est-ce qu'on fait les tests au niveau d'un programme ? Généralement c'est au niveau de l'implémentation c'est à dire quand vous implémentez vos différentes fonctions, classes et cetera. Testez au fur et à mesure c'est-à-dire n'attendez pas la fin d'un projet pour faire vos tests, très mauvaise idée, dans certains cas on peut être amené à faire tout l'inverse c'est à dire qu'on va écrire des tests et du coup les tests ne seront pas validés parce qu'il n'y aurait aucun code qui est fait naturellement, et puis certains vont passer par l'implémentation juste après pour permettre la validation des tests, c'est ce qu'on appelle du **développement dirigé par des tests**.

Alors c'est une possibilité aussi mais dans tous les cas éviter d'attendre que tout soit fini, avant de faire vos tests. Tout ce qui est gestion d'erreur ne le fait pas à la fin du projet, on le fait tout au cours de la conception du projet c'est à dire d'avancer au fur et à mesure en vérifiant qu'on a un maximum de chose fonctionnelle surtout quand on commence à avoir un programme assez conséquent.

Ainsi user et abuser de cet outil en plus ils sont natifs, et si on est assez curieux il y a également des bibliothèques et des modules qui sont pas forcément natifs de python mais qui permettent de faire également des tests de manière différente donc il y a des outils qu'on peut trouver de manière plus pratique moins pratique, plus complet ou un peu moins bref il ne faut pas hésiter à se renseigner sur internet pour trouver tout un tas de bibliothèque et de modules pour effectuer des tests et parfois des choses un peu plus poussées que ça.

Si vous avez besoin de tester des milliards de choses n'hésitez pas à vous renseigner et à être curieux.

Ciao tout le monde est bon codage en python