#coding:utf-8

# [7. Famille bouftou](https://www.youtube.com/watch?v=gUXFoGzCzLE)

"""
EXERCICE PYTHON #7
[Révision : héritage]

> Créer une hiérarchie de Bouftous (race animale issue du célèbre jeu Dofus d'Ankama) :
    - une classe Bouftout qui possède quelques attributs (PV, PA, PM) et quelques méthodes (une par sort).
    - des classes qui héritent du Bouftou : BouftouNoir & BouftouRoyal.

> Donner vie à ces petites boules de laine :
    - créez 3 bouftous, 2 bouftous noirs et un bouftou royal.
    - utilisez un sort (de votre choix) pour chaque animal.

> Indications :
    - vous pouvez vérifiez les attributs d'une classe avec une méthode supplémentaire
    - vous générerez un nombre aléatoire pour les PV (dans la fourchette correspondent à chaque entité)
    - pas de code à implémenter dans les sorts (mettez juste l'instruction "pass")
    - https://www.dofus.com/fr/mmorpg/encyclopedie/monstres?text=bouftou (pour les infos générales)
    - http://wiki-dofus.eu/w/cr%C3%A9atures_des_champs#Bouftous (pour les sorts)
"""
import random
# Générer un nomre entre 1 et 10 (inclus)
# random.randint(1, 10)

class Bouftou:
    def __init__(self, PV = random.randint(170, 280), PA = 5, PM = 4):
        self.PV = PV
        self.PA = PA
        self.PM = PM
        print("PV : {} | PA : {} | PM : {}.".format(self.PV, self.PA, self.PM))

    def morsure_du_bouftou(self):
        print("Je mords !")

class BouftouNoir(Bouftou):
    def __init__(self):
        super().__init__(random.randint(50, 250), 5, 4) # super() va dans la classe parente.

    def crachouille(self):
        print("Crachouille...")

    #redéfinission/spécialisation de méthode, voir principe du polymorphisme au niveau de l'héritage.
    def morsure_du_bouftou(self):
        print("Je mords doucement")
    
    def mordillement(self):
        print("Mordillement...")

class BouftouRoyal(Bouftou):
    def __init__(self):
        super().__init__(random.randint(610, 900), 7, 5)

    def guerison_bouftou(self):
        print("Guérison !")

    def abolissement(self):
        print("Abolissement")

b1 = Bouftou()
b2 = Bouftou()
b3 = Bouftou()
bn1 = BouftouNoir()
bn2 = BouftouNoir()
br = BouftouRoyal()

b1.morsure_du_bouftou()
b2.morsure_du_bouftou()
b3.morsure_du_bouftou()

bn1.crachouille()
bn2.mordillement()

br.guerison_bouftou()