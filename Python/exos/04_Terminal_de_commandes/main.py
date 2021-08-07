#coding:utf-8

# [4. Terminal de commandes](https://www.youtube.com/watch?v=-3v4_AoCeKM)

"""
EXERCICE PYTHON #4
[Révision : jusqu'au boucles]

> Développer un mini-terminal tournant en boucle et gérant quelques commandes définies :
    - Votre programme invitera l'utilisateur à saisir une commande (comme la ligne de commande Windows, GNU/Linux, MacOS...)
    - Gérer le cas où une commande n'existe pas
    - Aucun module ne doit être importé

> Quatre commandes à prévoir :
    - run   (affiche 5 fois un point avec une pause entre chaque affichage de 1s)
    - name  (modifie le nom du terminal, s'appellera "Défaut" de base)
    - help  (affiche la liste descommandes + description brève)
    - quit  (termine l'exécution du programme)

> Ce qui devra être affiché :
        [Défaut]>
        [nom_terminal]>
"""
import time
# Mettre en pause1s -> time.sleep(1)

terminal_launched = True
terminal_name = "Défaut"
user_command = ""
cpt = 0

while terminal_launched:
    user_command = input(f"[{terminal_name}]> ")
    
    if user_command == "run":
        while cpt < 5:
            print(".")
            cpt += 1
            time.sleep(1)
        cpt = 0
    elif user_command == "name":
        terminal_name = input("Choisir nouveau nom du terminal : ")
    elif user_command == "help":
        print("\
-------------------------------\n\
LISTE DES COMMANDES DISPONIBLES\n\
-------------------------------\n\
run  : Exécute la boucle 5 fois\n\
name : Modifie le nom du terminal\n\
help : Affiche la liste des commandes\n\
quit : Fermer le terminal\n\
-------------------------------")
    elif user_command == "quit":
        terminal_launched = False
    else:
        print("Commande introuvable...")