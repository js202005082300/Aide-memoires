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