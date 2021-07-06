# [AIDE - créer un installateur (Inno Setup)](https://www.youtube.com/watch?v=ormsdIk_Uhw)
@https://github.com/jasonchampagne/FormationVideo/tree/master/Ressources/Aide

Plusieurs types d'installateur : payant, open source, gratuit, etc.

Inno setup : gratuit, écrit en pascal si on s'interesse au script.

Télécharger ici.

    https://www.jrsoftware.org/isinfo.php

Récupérer l'exe : Downloads -> Stable Release -> Random site.

Note : passer un png dans un convertisseur .ico en ligne.

Démarrer Inno Setup Compiler :

1. Cocher "Create a new script file using the Script Wizard" -> Next

1. Welcome … -> Next

1. Remplisser 
    1. "Application Name" : …

    1. "Application Version" (suivant notre système de version) : 1.0

    1. "Application Publisher" (nom d'entreprise) : …

    1. "Application Website" (info sur le jeu, contact, …) : https://... -> Next

1. Laisser par défaut : "Application destination base folder" et laissé cocher "Allow user to change the application folder" et éventuellement adapter "Application folder name" -> Next.

1. Spécifier le chemin de notre exécutable : "Application main executable file" et spécifier tous les fichiers du répertoire : "Add file(s)…" (par exemple, le fichier lu avec fopen) -> Next.

1. Spécifier les raccourcis : "Application Shortcuts" > "Create an Internet Shortcut in the start menu folder" si on a renseigné un site au début de la configuration OU "Create an Uninstall Shortcut in the start menu folder" si on veut créer un désinstalleur dans le menu démarrer -> Next.

Note : éviter d'abuser des raccourcis bureau.

1. Application documentation, c'est comment on veut distribuer notre programme (payant, gratuit, open source, etc.) :

    1. S'il y a une licence (retrouver les fichiers texte en ligne à incorporer par exemple le fichier de licence GPL trouvé sur les sites dédiés).

    1. Ajouter des informations (épileptiques, daltoniens, etc.) .txt : "Information file shown before installation".
    
    1. Idem après l'installation (configurations, utilisations, etc.) : " Information file shown after installation". -> Next.

1. Setup Install Mode : Laisser le mode administrateur : "Administrative Install Mode (Install for all users)".

1. Setup Languages : Sélectionner les langues pour les utilisateurs : "Deselct all" et sélectionner ce dont a besoin -> Next.

1. Compiler Settings :

    1. "Custom Compiler output folder" = emplacement de notre exécutable à la fin.

    1. "Compiler Output base filename" = nom de l'installateur (ex : installation).

    1. "Custom setup icon file" = fichier .ico.

    1. "Setup password" : Non nécessaire. L'installation décompresse les fichiers dans program files et modifie notre base des registres. On installe rarement un mot de passe -> Next.

    1. Inno setup Preprocesseur : Next.

    1. Finish.

    1. Inno Setup Compiler : générer l'exécutable avec le langage Pascal (script d'installation) -> Non.

