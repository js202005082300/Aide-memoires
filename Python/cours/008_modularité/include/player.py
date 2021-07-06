##coding:utf-8
#
## Module pour le joueur
#def parler(personnage, message):
#    print("{} : {}".format(personnage, message))
#
#def au_revoir():
#    print("Au revoir :) !")
#
#if __name__ == "__main__": # Si la variable __name__ réservé est égale à __main__ ...
#    print("Phase de test de player.py")
#    """
#    On teste si l'interprêteur Python exécute notre programme à partir de ce fichier. 
#    On regarde si il commence par le fichier player au lieu de commencer par le fichier main.
#    On va juste tester player s'il se lance par ce programme alors que ce n'est pas par lui qu'il devrait démarrer.
#    On ne va pas tester main et les autres fichiers qu'on pourrait avoir.
#    On teste l'appel des deux fonctions (il n'y a pas grand chose dans ce module).
#    """
#    parler("Jason", "Bonjour tout le monde")
#    au_revoir()
#    """
#    On va volontairement lire le fichier player en premier.
#    Tout ce qui est dans le if sert pour faire nos tests. 
#    Ce n'est pas du test unitaire, cela reste basique mais permet de vérifier que tout fonctionne.
#    De manière plus élaboré, on pourrait tester qu'il n'y a pas de caractères non autorisé dans "message" et "personnage".
#    On peut éxécuter notre programme depuis le main et laisser les fonction test dans le module.
#    
#    Voilà on s'est assuré que le module fonctionne indépendamment donc maintenant on peut passer par tout le
#    programme principale, ça ne devrait pas bugger.
#
#    C'est donc une vérification intéressante de passer par cette petite condition que l'on met dans tous les modules
#    juste après les définitions de fonctions pour ainsi éffectuer quelques tests basiques.
#
#    Il s'agit de tests isolés mais pas très très poussés. Cela reste sommaire sur le test modulaire.
#    """
