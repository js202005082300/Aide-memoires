#coding:utf-8

nomPrenom = "Jason" #string (str)
monAge = 26			#entier (int)
nombrePI = 3.14		#flottant (float)
inventaire = ["Arc", "Potion", "Cape", "Casque de guerrier"]

if monAge > 18:
	print("Tu est majeur", end="")
else:
	print("Tu est mineur", end="")
    
def maFonction(message):
	print(message)

#Programme prinxipal
message = "Coucou"
maFonction(message)