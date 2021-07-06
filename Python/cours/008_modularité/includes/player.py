#coding:utf-8

#Module pour le joueur

def parler(personnage, message):
	print("{} : {}".format(personnage, message))

def au_revoir():
	print("Au revoir :) !")


if __name__ == "__main__":
	print("PHASE DE TEST DE PLAYER.PY")

	parler("Jason", "Bonjour tout le monde")
	au_revoir()
