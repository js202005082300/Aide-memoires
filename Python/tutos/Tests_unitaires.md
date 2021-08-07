# [Tests unitaires](https://www.youtube.com/watch?v=apgReCCAQr4)

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

1.12