#coding:utf-8

# [6. Jeu de l'étudiant](https://www.youtube.com/watch?v=mvWBlzDPcjQ)

"""
EXERCICE PYTHON #6
[Révision : gestion d'erreurs, classes et attributs, propriétés, méthodes]

> Vous êtes enseignant en programmation Python et un de vos étudiants vient de vous rendre un devoir. Malheureusement, le programme contient quelques erreurs, à vous de les corriger et permettre l'exécution de ce dernier.

> Le programme doit donner comme résultat l'affichage suivant : (voir fichier "out.txt").

> Le but de cet exercice, en plus de faire réviser les notions citées plus haut, est de vous familiariser avec le débogage d'un code qui n'a pas été fait par vous même, et prendre l'habitude de lire les messages d'erreur retournés par l'interpréteur et savoir identifier l'origine des bugs dans le code.
"""

#-----------------------------------------------------------------------------------
# CLASSE OBJET POUR JOUEUR
#-----------------------------------------------------------------------------------
class Weapon:
	def init(self, name, damages, sell_price):
		self.name = name
		self.damages = damages

#-----------------------------------------------------------------------------------
# CLASSE JOUEUR
#-----------------------------------------------------------------------------------
class Player:
	def __init__(self, name, level = 1, golds = 5, HP = 100, MP = 100, EXP = 0, weapon = Weapon("Epee en bois", 32, 1)):
		self._name = name
		self.level = level
		self.golds = golds
		self.HP = HP
		self.maxHP = HP
		self.MP = MP
		self.maxMP = MP
		self.EXP = EXP
		self.next_level_EXP = 100
		self.weapon = weapon

	def get_name(self):
		return self._name

	def set_name(self, name):
		if len(name) == 16:
			raise Exception("Le nom de votre personnage doit comporter 16 caracteres max.")

		self._name = name
		print("Vous changez de nom pour -> {}".format(self.name))

	def to_string(self):
		print("---------------------------------------------")
		print("Nom : {}\nNiveau : {}\nOr : {}\nPV : {}\nPM : {}".format(self.name, self.level, self.golds, self.HP, self.MP))
		print("EXP : {}\nProchain niveau : {} EXP\nObjet equipe : {}\n".format(self.EXP, self.next_level_EXP, self.weapon.name))

	def say(message):
		print("{} : {}".format(self.name, message))

	def equip(self, weapon):
		print("{} a ete vendu(e), vous empochez {} piece(s) d'or.".format(self.weapon.name, self.weapon.sell_price))
		self.golds = self.weapon.sell_price
		self.weapon = weapon
		print("{} equipe(e) !".format(self.weapon.name))

	def attack(self, target):
		print("{} attaque {} avec {} !".format(self.name, target.name, self.weapon.name))
		print("L'attaque inflige {} points de degats !".format(self.weapon.damages))

		target.HP -= self.weapon.damages

		if target.HP == 0:
			target.die()

	def heal(self, value):
		self.HP += value

		print("{} : vous vous soignez et regagnez {} points de vie !".format(self.name, value))

	def level_up(self):
		if self.EXP >= self.next_level_EXP:
			self.next_level_EXP += 100
			print("{} monte au niveau {} !".format(self.name, self.level))
		else:
			return

	def die(self):
		if self._HP < 0:
			self._HP = 0

		print("{} succombe de ses blessures...".format(self.name))
		print("FIN DE LA PARTIE !")

#-----------------------------------------------------------------------------------
# PARTIE PRINCIPALE (NE PAS MODIFIER !)
#-----------------------------------------------------------------------------------

# Création des personnages
hero = Player("Joueur", 5, 3, 200, 70)
monster = Player(name = "Golem de pierre", MP = 0, weapon = Weapon("Massue", 40, 25))

# Affichage des infos des personnages
hero.to_string()
monster.to_string()

# Changement de nom du heros
hero.name = "Unnombientroplongpouretrevalide"
hero.name = "Perceval"

# Conversation entre le heros et le golem
print("\n", end='')
monster.say("Qui ose troubler mon profond sommeil ?")
hero.say("Moi ! Le heros de cette histoire !!")
monster.say("Je vois...")
hero.say("Alors en garde, vil gredin !")

# Attaques du heros contre le monstre...
hero.attack(monster)
hero.attack(monster)

# Mais ce dernier se soigne et contre-attaque
monster.heal(50)
monster.heal(50)
monster.attack(hero)

# Infos des personnages mises a jour
hero.to_string()
monster.to_string()

# Notre heros trebuche sur une bosse, et decouvre a moitie enterre, un arc
# Il decide de l'equiper...
thunder_bow = Weapon("Arc de foudre", 240, 350)
hero.equip(thunder_bow)

# Et balance une nouvelle attaque, devastatrice !
hero.say("Meurs, monstre !")
thunder_bow.attack(monster)

# Le heros remporte le combat et gagne de l'EXP (montée de niveau)
hero.EXP = 131