# [[ARCHIVE] Tutoriel C - installer MinGW](https://www.youtube.com/watch?v=kG1c8ZOb6rM&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=27)
 
Séance de tutoriel dédié à l'installation de GCC sur Windows.

Nous installons les outils qui vont permettre de programmer en langage C.

Cela concerne surtout les personnes qui ne veulent pas utiliser d'environnement de développement (Visual Studio, Codeblocks, etc.). Il est recommandé d'installer les outils de manière séparées, ce qui permet de ne pas être dépendant d'un logiciel.

Mais pour cela, il faut avoir un éditeur de code, on ne va pas utiliser le bloc note, un editeur par défaut. Il faut au moins un éditeur avec une coloration syntaxique. Il en existe plusieurs (Sublime text, Visual Studio Code, notepadplusplus, Atom, Brackets) qui sont gratuit et open-source.

Une fois qu'on a un éditeur de code, il faut un compilateur qui va permettre de transformer le code source en exécutable, en binaire pouvoir être lancé sur notre système Windows.

## Editeur

Installer un éditeur, Visual Studio : https://code.visualstudio.com/Download

## Afficher les extensions

Panneau de configuration > Apparence et personnalisation > Options de l’explorateur de fichiers > décocher Masquer les extensions des fichiers dont le type est connu > Appliquer

## Compilateur

MinGW

* Installer & télécharger mingw-get-setup.exe

Se rendre sur http://mingw.org/ dans la partie Download.

    https://osdn.net/projects/mingw/releases/

Activer l’exécutable mingw-get-setup.exe

Laisser le répertoire d’installation : C:\MinGW et décocher on the desktop

* Marquer pour installation :

Commencer par développer MinGW Installation Manager > All Packages > MinGW Base System > clic droit et Mark for installation les deux éléments suivants : 
    
    mingw32-gcc-bin
    mingw32-gdb-bin

Rem. Tant qu'on y est on va installer G++ notamment : 

    mingw32-g++-bin
    mingw32-g++-man
    mingw32-gcc-man

* Appliquer les changements :

Pour appliquer les changements, développer Installation > Apply changes > Schedule of Pending Actions (fenêtre) > Apply

* Modifier les variables d’environnement :

Développer Panneau de configuration > Système et sécurité > Système > Paramètres système avancés > Propriété système >(fenêtre) > Paramètres système avancés (onglet) > Variables d’environnement > modifier Path (variable) > activer Nouveau et écrire C:\MinGW\bin > ok > ok

* Tester

Tester la commande gcc et la commande gdb dans un terminal