# [AIDE - écrire un Makefile](https://www.youtube.com/watch?v=-riHEHGP2DU&list=PLrSOXFDHBtfEwFMZ1YIXgUqOFODGyo7tB&index=11)
24-01-21

Un Makefile est simplement un fichier que nous allons écrire et qui servira pour ceux qui utilisent des langages compilés comme le C ou le C++ afin de faciliter le développement sur des projets conséquents.
C'est le cas sur des projets où l'on organise tout sur plusieurs fichiers lorsqu'on fait de la programmation modulaire.

## INSTALLATION

### Linux

Pour pouvoir utiliser ce fichier, il faut télécharger l'outil Make. Normalement l'outil Make est intégré par défaut sur le système d'exploitation, il est en natif. Tant qu'on n'a pas de message pour dire que la commande Make est introuvable ou inconnu, c'est qu'à priori Make est installé.

Sinon on peut vérifier son installation via des distribution comme Ubuntu, Debian, Linux Mint, etc. en faisant un apt-get install ou utiliser le gestionnaire de paquet si on est sur Fedora ou Arch Linux, et on installe le paquet Make :

> apt-get install make

Pour les distributions comme ubuntu, Debian, Linux Mint, etc. on peut installer le méta-paquet build-essential qui installera plusieurs programmes dont l'outil Make.

> apt-get install build-essential

Ça c'est pour ceux qui sont sur GNU-Linux et MacOS.

### Installation Windows

Pour Windows, c'est différent, il n'est pas installé en natif, il n'existe pas.

Il faut l'installer.

* Pour cela il faut se rendre ici:

    gnuwin32.sourceforge.net/packages/make.htm

Cela pour partir sur la bonne source parce qu'il y a plusieurs moyens d'avoir l'outil Make sur Windows pour éviter les problèmes à l'installation est à l'utilisation.

On commence par rechercher le setup qui va nous rediriger vers le site de Sourceforge qui va nous proposer le téléchargement de l'exécutable Make.

    Download
    If you download the Setup program of the package

Au moment où je suis la vidéo, il me propose la version 3.81.

* Ensuite on l'installe. 

On accepte les conditions. On voit où sera présent l'outil C:\Program Files (x86)\GnuWin32

On laisse tout par défaut. A la fin si c'est déjà installé, il va proposer de le désinstaller. 

On fait install est c'est terminé. C'est vraiment très simple.

* Modifier les variables d'environnement

C'est comme pour l'installation de MinGW pour le compilateur gcc ou d'autres compilateurs sur Windows.

Pour pouvoir permettre de taper Make dans un terminal et de trouver le programme.exe du répertoire bin qui est dans le répertoire gnuwin32 qui est lui-même dans le Program Files, etc sans devoir à chaque fois taper le lien complet. Ce qui serrait à chaque fois beaucoup trop long pour simplement utiliser l'outil Make.

Pour ce faire, Ouvrir les "paramètres" sur Windows, taper "variables" et sélectionner "Modifier les variables d'environnement système".

Une fenêtre avec les "Propriétés systèmes" s'ouvre et ensuite on clic sur les "Variables d'environnement…".

On identifie la variable d'environnement "Path" dans les Variables système.

On clique sur "Modifier…"

On clique sur "Nouveau"

Sur Windows 7, on a qu'un champ de saisie donc il faut les mettre à la suite et les séparé par des points-virgules.

Pour Windows 10, c'est un peu mieux présenter car on fait une ligne par chemin.

Il suffit alors d'ajouter le chemin C:\Program Files (x86)\GnuWin32\bin et de vérifier que c'est bien sûr le bon. C'est le chemin vers le répertoire des binaires séparé par des anti-slashs par rapport à ce que l'on vient d'installer. C'est dans ce répertoire qu'il y a le Make.exe

On valide le tout avec Ok.

* Vérifier l'installation

Normalement, si on tape Make sur l'invité de commandes Windows, on devrait obtenir le message :

    C:\Program Files (x86)\GnuWin32\bin>make
    make: *** Pas de cibles spécifiées et aucun makefile n'a été trouvé. Arrêt.

Ça permet de savoir si tout est bien installé.

Finalement, il attend une cible, un fichier Makefile à interpréter.

## Créer un Makefile

Le but de cette vidéo est d'apprendre à écrire un Makefile.

On commence d'abord par créer un fichier Makefile. On crée un fichier texte et on vire tout, y compris l'extension.

On le nomme Makefile avec un M majuscule et on crée ce fichier sans extension.

On glisse-dépose ce fichier dans l'éditeur de texte qui devrait reconnaître le type de fichier comme un Makefile.

Nous sommes prêts à écrire notre fichier Makefile.

Le Makefile est un fichier qui va se charger de la génération du ou des exécutables et également pour tout ce qui est de la compilation. 

Remarque : voir la séance 3 de la formation hacking ou l'on parle de toutes étapes de compilation avec le langage C, c'est ou à fait similaire au langage C++.

La création d'un Makefile n'est pas compliquée, c'est quelque chose de très logique.

Le principe tel qu'on a pu le voir dans le langage C ou en C++, nous avons deux fichiers sources et un fichier d'en-tête sur lequel on va utiliser le Makefile.

Sans Makefile, pour tester ce programme, nous devons faire :

    cd ...
    gcc *.c -o prog
    prog

Cela permet d'obtenir un exécutable et prog permet de lancer le programme.

Si néanmoins je modifie le fichier main.c, je vais devoir recompiler le projet. 

En langage compilé, il faut recompiler à chaque fois la totalité. Lorsqu'on a deux fichiers sources, cela va relativement vite mais pour un projet concret ou l'on peut avoir des centaines fichiers avec plusieurs dizaines de milliers de lignes, on peut être contraint de recompiler tout le projet lorsqu'on apporte une modification.

Ici on a remis à jour qu'un seul fichier (on sauvegarde qu'un seul fichier) mais le compilateur a dû regénérer tout le projet. 

Si ça avait été un projet très conséquent de plusieurs méga octets de code, ce serait vraiment très long au niveau compilation.

L'avantage du Makefile, c'est que l'on va pouvoir indiquer toutes les étapes de compilation étape par étape dans le détail et ainsi de gérer les dépendances.

C’est-à-dire que le Makefile serait capable de regénérer les fichiers qui ont été mis à jour. Ce qui a été édité, il va être regénérer pour appliquer les changements et ensuite l'exécutable finalement. 

On gagne énormément de temps au niveau compilation, au niveau des étapes intermédiaires de la compilation, la transformation en fichier objet, l'édition de lien, etc (Voir la séance 3 en Hacking).

Quand on fait un Makefile, on ne s'amuse plus à créer des commandes de compilation dans le terminal, on va passer par un fichier que nous allons écrire. C'est lui qui va aller compiler tout à notre place à l'aide d'une seule commande à taper.

On aura créé nous-même notre fichier Makefile. C'est un peu un fichier de recette qui va tout simplement faire les choses à sa manière.

Comment cela se schématise ? On a d'abord la cible du fichier qui va dépendre de dépendance. C’est-à-dire que pour obtenir cette cible, on va devoir satisfaire des dépendances.

Une fois que les dépendances seront satisfaites, validés, on va pouvoir créer la cible. Pour obtenir la cible, à partir de dépendances, on va à la ligne, on fait une tabulation et on écrit la commande qui permet de faire cette transformation.

    <cible> : <dependances>
        <commande>

On aura plein de cibles différentes avec des dépendances qui leurs correspondent et une commande qui est relié à tout ça, qui fait la transformation de l'un envers l'autre, qui utilisent les dépendances pour obtenir la cible.

    <cible> : <dependances>
        <commande>
    <cible> : <dependances>
        <commande>

* Création d'une cible (main.o)

On a vu dans les étapes de compilation (Séance 3 en Hacking) que l'on va créer des fichiers objets, avec des extensions o, à partir de fichiers sources.

Pour commencer, on va obtenir un fichier objet à partir du fichier main.c. Quel est la cible ? c'est le fichier objet main.o. A partir de quoi obtenons nous cette cible ? Elle dépend de main.c, le fichier source.

Pour partir de main.c pour obtenir main.o, on fait tout simplement gcc -o pour compléter le nom de la sortie qui va être main.o et -c pour dire la source main.c et après on peux mettre tous les "flags" -W, -Wall, etc.

    main.o : main.c
        gcc -o main.o -c main.c

Pour créer main.o, il a besoin de la dépendance main.c donc il faut qu'un fichier main.c existe. Et à partir de main.c, il va transformer cela en fichier objet main.o

* Obtenir player.o

On fait ensuite la même chose pour player. 
player.o, sa dépendance c'est player.c et la commande pour faire le tout c'est gcc -o player.o -c player.c
player.o : player.c

    gcc -o player.o -c player.c

* Obtenir le résultat (prog)

Par habitude on le met au-dessus du fichier. Ce que l'on veut obtenir à la fin, c'est le prog.exe sur Windows ou prog sur Linux ou Mac. 

Notre cible, c'est l'exécutable prog et cette cible donc l'exécutable final, qu'est-ce que c'est ? Ce sont nos fichiers objets. Qu'est-ce que nos fichiers objets ? 

C'est main.o et player.o. Ca se sont les dépendances et comment on obtient ça ? Comment de tout les fichiers objet, on obtient un exécutable final ? 

Quand on a utilisé la commande gcc *.c -o prog dans le terminal. Toutes les étapes intermédiaires ne se sont pas faites. Du fichier source, il a directement produit un exécutable sans produire de manière intermédiaire les fichiers objets. Ça c'est tout fait dans la foulée sans créer les étapes intermédiaires de compilation. 

Donc après "prog : main.o player.o", on fait gcc -o prog suivi de l'ensemble des fichiers objets main.o et player.o. Donc il prend tout les fichiers objets que l'on a et il forme un exécutable qui s'appellera prog. 

    prog : main.o player.o
        gcc -o prog main.o player.o

    main.o : main.c
        gcc -o main.o -c main.c

    player.o : player.c
        gcc -o player.o -c player.c

## Lecture du Makefile

Comment va se passer la lecture du Makefile ?

Déjà comment interprète-t-on un Makefile ?

C'est très simple parce que ça change de gcc à taper toutes les étapes de compilation. Il faut aller à l'endroit où le Makefile est présent et on va juste taper "make" et "make" va chercher un fichier Makefile et il va faire ce que l'on lui demande. 

On fait la commande et là, trois lignes vont apparaître.

    >make
    gcc -o main.o -c main.c
    gcc -o player.o -c player.c
    gcc -o prog main.o player.o

C'est terminé, je peux faire "prog" et mon programme se lance. 

Dans le répertoire, on constate qu'il y a l'exécutable et en plus de cela, on voit les fichiers objets, qu'on a avait pas lorsqu'on faisait la commande gcc directement qui masquait cette étape. Ca ne gardait pas ces fichiers objet. Et c'est là que tout est important. 

Qu'est-ce qui s'est passé au niveau du Makefile ? 

    prog : main.o player.o
        gcc -o prog main.o player.o

L'outil make, l'exécutable du programme Make, le fichier Makefile arrive au début du fichier et dit qu'il veut obtenir un exécutable qui s'appelle "prog" mais pour cela il a besoin de dépendances.

Il dit j'ai besoin d'un fichier main.o et player.o (fichiers qui n'existe pas à la base) donc il ne peut pas exécuter la commande gcc -o prog main.o player.o pour le moment donc il passe à la suite du fichier Makefile …

    main.o : main.c
        gcc -o main.o -c main.c

Donc on veut créer un main.o, la dépendance est à main.c. Il cherche un fichier comme ça et du coup il y en a un puisque le fichier source, il y a en un. Et donc il peut exécuter la commande, l'instruction pour faire gcc -o main.o -c main.c et c'est pourquoi on retrouve exactement la commande du Makefile en première ligne dans l'invité de commandes : 

    >make
    gcc -o main.o -c main.c		--> c'est la première commande exécutée.
    gcc -o player.o -c player.c
    gcc -o prog main.o player.o

Ensuite il continue …

Il pourrait revenir au début et voir main.o, ok je l'ai mais player.o, je ne l'ai pas. Je ne peux toujours pas exécuter cette commande gcc -o prog main.o player.o

    player.o : player.c
        gcc -o player.o -c player.c

Donc main.o, on en a un. On veut créer un player.o. De quoi ai-je besoin ? player.c, ok j'en ai un, ensuite j'exécute la commande gcc -o player.o -c player.c et l'on constate que c'est bien la deuxième commande qui est faite dans le terminal.

    >make
    gcc -o main.o -c main.c		
    gcc -o player.o -c player.c		--> c'est la deuxième commande exécutée.
    gcc -o prog main.o player.o

A la fin, on veut créer pour cible un exécutable. Les dépendances pour l'exécutable, c'est "main.o player.o".

Cette fois ci, les fichiers.o ont bien été créés donc on peut faire la commande finale qui est la troisième dans mon terminal :

    >make
    gcc -o main.o -c main.c		
    gcc -o player.o -c player.c
    gcc -o prog main.o player.o		--> c'est la troisième commande exécutée.

Et finalement, ça nous produit notre exécutable et on est capable d'exécuter le programme.

C'est clair et logique, le prog ne pourra pas être fait tout de suite tant qu'il n'aura pas les fichiers adéquats.

Ce qui est intéressant, c'est que dans le cas où l'on aurait fait la commande gcc *.c -o prog directement et qu'on modifie un seul fichier, on va tout recompiler.

La commande va recréer les fichiers objets pour main et pour player et elle va refaire l'édition des liens et elle va reproduire l'exécutable.

Elle va reproduire l'ensemble du projet, ce qui va être lourd, beaucoup plus lent qui fait gaspiller des ressources.

## Mais si on change le code source ?

Par exemple si on change le code source de main.c et qu'on réexécute la commande make, on n'a plus que deux lignes. 

    >make
    gcc -o main.o -c main.c
    gcc -o prog main.o player.o 

Comme on n'as pas touché au fichier source de player, le fichier objet de player n'a pas été recréé. La source n'a pas été modifiée, éditée. Une fois que main.o a été regénérée, il peut refaire l'exécutable.

Qu'est-ce que c'est que refaire l'exécutable ? c'est fusionner tous les fichiers objets en un exécutable qui va évidemment dépendre de notre OS, un point exe sur Windows et pas d'extension sur Linux et MacOS.

L'importance de ce Makefile, c'est que ça va recompiler, regénérer ce qui a été modifié et tout le reste va rester tel quel dans le cas où ça n'a pas été édité.

Jusqu'ici nous avons vu la base en Makefile (18.42).

C'est le minimum à savoir sur le Makefile si l'on crée plusieurs fichiers et que l'on fait de la programmation modulaire. 

## Règles spéciales

Créer un Makefile, c'est préciser un ensemble de règles. Une règle dans un Makefile se décompose en 3 parties : une <cible> dont il y a des <dépendances> et si ces <dépendances> sont satisfaites, on peut exécuter une <commande>.

* Règle all

Au niveau du Makefile, il existe des règles un peu spéciales qui sont facilement réutilisables au niveau du fichier. Une règle permet de faire l'ensemble pour créer notre exécutable qui est l'objectif final de notre programme.

On peut utiliser une cible spéciale qui s'appelle "all".

Comment faire all ? On a juste besoin de lui dire de quoi il dépend.

Nous ce que l'on veut, c'est l'exécutable que l'on veut. Donc on dit que pour créer all, on fait prog.

    makefile
    --------
    all : prog

    prog : main.o player.o
        gcc -o prog main.o player.o

    main.o : main.c
        gcc -o main.o -c main.c

    player.o : player.c
        gcc -o player.o -c player.c

Qu'est-ce qu'il va se passer ? "all : prog" va faire référence à "prog : main.o player.o" et il va se repasser exactement la même chose.

C'est un peu comme si all était une référence, un pointeur (même si le terme est archi faux dans ce cas) vers "prog : main.o player.o". Et prog a ses propres dépendances (main.o player.o). Et main.o a ses propres dépendances (main.c) et ainsi de suite. C'est en cascade, c'est de manière récursive.

L'ordre n'est plus important. On peut mettre "prog : main.o player.o" en début ou à la fin, dans n'importe quel ordre parce que "all : prog" est en début de fichier. On a plus qu'à faire un make all.

"make all" va appeler la cible prog qui fera tout le travail. Et si on a pas rééditer les fichiers main.c et player.c, ça a prit les deux fichiers .o et regénérer l'exécutable. Cela va très vite parce que c'est juste de la fusion de fichiers. C'est beaucoup plus rapide que de créer des fichiers objets à partir de fichiers sources, c'est cette étape qui est gourmande, ainsi que l'édition des liens qui prend vraiment du temps en compilation. La fusion pour former l'exécutable n'est pas le plus long dans toutes les étapes de compilation.

Remarque : Si maintenant on ajoute un commentaire à player.c, on fait un make all et on constate que les commentaires sont même pris en compte. Le fichier a quand même été édité même si les commentaires ne sont pas pris en compte pour le programme final parce que ce n'est qu'un commentaire, utile pour le développeur, mais qui nécessite de recréer le fichier objet pour que le commentaire soit pris en compte de toute manière.

Si on retire le commentaire, on va de toute façon recréer le fichier objet pour player, etc, etc.

Cette règle "all" est plutôt pratique parce qu'elle permet de ne pas trop se soucier de l'ordre dans lequel on exécute les commandes parce que dans certains cas, ça peut poser un problème.

Il est recommandé de mettre toujours un "all" au départ et de mettre la cible que l'on veut. La cible finale, c'est notre exécutable.

* Règle clean

Cette règle se met plutôt vers la fin.

clean va permettre de nettoyer l'ensemble des fichiers objet de notre projet.

Si par exemple, on veut partager le code source de notre code à quelqu'un, il ne faudra pas lui donner l'exécutable, ça ne sert à rien. Et on ne va lui donner les fichiers objets non plus. En plus, ça risque de prendre beaucoup de place : main.c (150 octets) et main.o (950 octets). Il y a quand même une différence de taille alors que main.c ne compte qu'une dizaine de lignes mais sur un fichier de plusieurs milliers de lignes, c'est encore pire. On peut ainsi avoir des fichiers objets qui sont très lourds qu'il ne faudra pas partager.

Pour ça, on met une règle clean auquel on ne met aucunes dépendances car elle ne dépend rien.

Ainsi quand on utilise la commande clean, on va utiliser une commande particulière. Mais quelle commande particulière ? La commande de notre terminal Windows ou le shell Linux ou MacOS qui permet de supprimer tous les fichiers objets. 

Sur Linux, ce serait :

    clean :
        rm -rf *.o

Pour exécuter cette commande, on utilisera la "make clean".

Sur Windows, ce sera avec des slashs. Il suffira d'adapter en fonction de l'OS pour avoir une commande de nettoyage.

* Règle mrproper

Par habitude, on peut avoir également mrproper.

C'est la règle qui va vraiment tout enlever.

Elle va dépendre de clean. Qu'est-ce que cela veut dire ? mrproper avant d'exécuter sa propre commande, elle va créer la cible clean déjà éditer, qui va faire notre commande "rm -rf *.o".

    mrproper : clean

Après la commande clean, c'est au tour de la commande mrproper.

Pour Linux, c'est toujours pareil mais du coup ici ce serait prog.

    mrproper : clean
        rm -rf prog

Et là, il suffira de faire "make mrproper".

* Règle zip

On peut également créer une commande zip si on veut se créer une archive. 

On tape la commande liée à l'archivage zip au niveau de notre terminal qui permet de créer une archive zip de tous nos fichiers sources (.c et .h) qu'on aurait plus qu'à partager à quelqu'un pour montrer le code source de notre programme.

On peut ainsi créer pleins de commandes pour nos divers projets.

Ce sont des noms habituels que l'on peut nommer autrement que clean, mrproper et zip. Ça peut être n'importe quel nom comme cleanall si l'on veut. On choisit ici les noms pour les cibles.

On crée ainsi nos propres arguments pour le programme make. C'est make suivi du nom de la cible que l'on a choisi.

    makefile
    --------
    all : prog

    prog : main.o player.o
        gcc -o prog main.o player.o

    main.o : main.c
        gcc -o main.o -c main.c

    player.o : player.c
        gcc -o player.o -c player.c

    clean :
        rm -rf *.o

    mrproper : clean
        rm -rf prog

    zip :

## Créer une variable en Makefile

On a vu la ma base mais comme on a pu le faire, on note toujours les choses en dur (main.c, player.c, main.o, player.o). Dans un projet avec 500 fichiers, on se voit mal noter 500 noms de fichiers objets.

Ce qui aurait dû faire gagner du temps avec un Makefile, ne le fait pas vraiment.

On a donc la possibilité d'utiliser des variables. C'est très facile, on met un nom égale une valeur.

    NOM = VALEUR

On écrit le nom en majuscule sans caractère accentué, sans caractères spéciaux. Et la valeur dépend de ce que l'on a mettre.

Les variables permettent de manipuler des données au cours de l'exécution. Ca permet aussi de manipuler des informations en dur.

Par exemple, c'est le cas lorsque je dois répéter le nom du compilateur gcc. C'est pourquoi, on peut le stocker dans une variable.

Note : utiliser un # pour faire un commentaire en Makefile.

Par habitude quand on veut spécifier une variable pour le compilateur en langage C, on a l'habitude d'utiliser une variable qui s'appelle CC. Pour le C++, on a une variable qui s'appelle CXX. 

Pour les flags ( -W, -Wall, etc), on utilise une variable qui s'appelle CFLAGS en langage C. En C++, c'est CXXFLAGS. 

Ensuite, on peut avoir LDFLAGS pour les éditions de liens.

Et d'autres variables, LIB, SRC et OBJ pour les fichiers objets.

Ces noms ne sont pas obligatoires mais ce sont des noms d'usage. Parmi les Makefile sur internet, il y a de forte chance de retrouver ces noms de variable.

Il ne faut pas obligatoire mettre CC pour le compilateur mais on le met par convention mais on peut mettre compilateur si ça nous chante. 

Pour les exécutables, on les appelle EXEC. 

On note : 

    CC = gcc

Pas besoin de doubles quottes.

## Utiliser une variable dans un Makefile

*	La variable CC

On met un dollar, des parenthèses dans lequel on met le nom de la variable.

$(CC), cette syntaxe va remplacer gcc à chaque fois que je veux faire référence à mon compilateur.

    makefile
    --------
    CC = gcc

    all : prog

    prog : main.o player.o
        $(CC) -o prog main.o player.o

    main.o : main.c
        $(CC) -o main.o -c main.c

    player.o : player.c
        $(CC) -o player.o -c player.c

Le jour où je veux changer de compilateur, je n'ai qu'à changer de nom de compilateur : "CC = autre_compilateur".

Ça permet de gagner beaucoup de temps. C'est mieux d'utiliser des variables pour obtenir quelque chose de plus dynamique. 

* La variable EXEC

On fait pareil avec notre exécutable. 
A chaque fois que l'on fait référence au nom de l'exécutable on utilisera la notation : $(EXEC).
On fait le remplacement pour toutes les cibles et les commandes.

Voilà comment on peut rendre les choses plus dynamiques.

    makefile
    --------
    CC = gcc
    EXEC = prog

    all : $(EXEC)

    $(EXEC) : main.o player.o
        $(CC) -o $(EXEC) main.o player.o

    main.o : main.c
        $(CC) -o main.o -c main.c

    player.o : player.c
        $(CC) -o player.o -c player.c

## Le manuel

On peut utiliser le manuel du Makefile.

    https://www.gnu.org/software/make/manual/

L'outil Make est un outil très puissant et offre tout un tas de possibilités.

## Les variables spéciales

C'est beaucoup moins explicite qu'un nom de variable et pas facile à utiliser. 

Par exemple EXECUTABLE est un nom plus explicite que EXEC. Les variables spéciales n'ont pas des noms explicites. 

* La variable $@

C'est une variable qui représente le nom de la cible. Elle fait référence à la cible.

    EXEC = prog
    …
    $(EXEC) : main.o player.o
        $(CC) -o $@ main.o player.o

Ici elle représente la cible par rapport à la commande associée. La cible $@ fait référence à $(EXEC) qui lui-même fait référence à prog. Quand on relit, c'est moins logique d'avoir @ qui fait référence à un exécutable. Si ça ne parait pas super lisible comme écriture, on n'est pas obligé d'utiliser les variables spéciales. C'est bien de les connaître si on récupère un Makefile sur internet par exemple pour un programme, un jeu, etc.

@ est le nom de la cible.

* La variable $<

C'est le nom de la première dépendance.

* La variable $^

C'est la liste des dépendances. Plusieurs dépendances.

* La variable $?

C'est la liste des dépendances mais plus récentes que la cible.

* La variable $*

C'est le nom du fichier, sans son extension.

## Généralisation du Makefile

On essaye de rendre notre Makefile plus dynamique, c’est-à-dire ne pas avoir des noms marqués en dur comme main ou player.

On peut ainsi avoir plusieurs Makefile a utilisé sur plusieurs projets différents avec des noms de projets différents. On veut quelque chose le plus générique possible.

En gros, que faisons-nous ? Pour obtenir un fichier en .o, on part de la dépendance en .c

On constate ensuite que la commande, c'est toujours la même.

    $(CC) -o main.o -c main.c
    $(CC) -o player.o -c player.c

Ainsi au lieu d'écrire ces deux lignes là, on aimerait en écrire une seule. Au lieu de ces deux lignes, on va utiliser des règles particulières avec le symbole %.

    %.o : %.c

"%.o : %.c" signifie que toutes les cibles .o, je vais les écrire à partir de toutes les dépendances sources .c, avec l'extension c. Et de là on pourrait créer nos différents objets mais là ça ne va pas encore, il faut aussi créer une variable …

* La variable SRC

On va utiliser une variable SRC et utiliser un cas particulier en sachant que pour le Makefile pour dire tout, on utilise le joker % donc pour retrouver l'étoile de Windows ou Linux quand on faisait par exemple "gcc *.c", on est obligé d'utiliser un mot clé spéciale du Makefile qui est willcard, à l'intérieur de $() parce que c'est une variable particulière.

    SRC = $(willcard *.c)

$(willcard *.c) signifie qu'on va prendre tous les fichiers qui ont l'extension .c qui sera stockée dans notre variable SRC.

Donc ici, on fait quelque chose de très générique même si de base on aurait pu donner à SRC, tous les fichiers avec l'extension c.

    makefile
    --------
    CC = gcc
    EXEC = prog
    SRC = main.c player.c
    OBJ = main.o player.o

    all : $(EXEC)

    $(EXEC) : main.o player.o
        $(CC) -o $(EXEC) main.o player.o

    %.o : %.c
        $(CC) -o $(OBJ) -c $(SRC)

"$(CC) -o $(OBJ) -c $(SRC)" représente une commande totalement générique, on a plus aucun nom en dure.

Donc pour éviter d'ajouter à chaque fois tous les noms des fichiers sources dans une variable et leurs équivalents objets dans une autre variable. Si on en a 500, on aura une variable qui tiendra sur 30 lignes. 

Donc pour la variable des fichiers sources, on fait "SRC = $(wildcard *.c)" pour que notre code soit très générique et fonctionne dans pratiquement tous les projets. Cette variable va prendre tous les codes sources.

* La variable OBJ

Pour les objets, on dit que nous prenons notre variable SRC sauf que l'on met deux points car c'est la syntaxe au niveau du Makefile et tout les fichiers en .c, ils n'ont pas cette extension, à la place ils ont l'extension en .o

C'est comme ce qui est mit dans la variable SRC = $(wildcard *.c) sauf qu'on remplace le .c par le .o
On fait un remplacement et du coup ça nous permet d'écrire les choses plus rapidement.

Et maintenant, on peut faire cette commande sans problème :
    %.o : %.c
        $(CC) -o $(OBJ) -c $(SRC)

    makefile
    --------
    CC = gcc
    EXEC = prog
    SRC = $(wildcard *.c)
    OBJ = $(SRC:.c=.o)

    all : $(EXEC)

    $(EXEC) : main.o player.o
        $(CC) -o $(EXEC) main.o player.o

    %.o : %.c
        $(CC) -o $(OBJ) -c $(SRC)

Mais maintenant comment allons-nous remplir la partie en jaune fluo, "main.o player.o". Cette partie rassemble la liste de nos fichiers objets représentées par la variable OBJ.

$(OBJ) va permettre de lister l'ensemble de nos fichiers objets à partir de nos fichiers sources, lister par $(wildcard *.c) qui nous fera gagner du temps avec les objets.

    ! Erreur : ne pas tenir compte
    ! ----------------------------
    ! CC = gcc
    ! EXEC = prog
    ! SRC = $(wildcard *.c)
    ! OBJ = $(SRC:.c=.o)
    ! 
    ! all : $(EXEC)
    ! 
    ! $(EXEC) : $(OBJ)
    !     $(CC) -o $(EXEC) $(OBJ)
    ! 
    ! %.o : %.c
    !     $(CC) -o $(OBJ) -c $(SRC)

Erreur de compilation, il avait peut être besoin de player pour utiliser main mais il n'avait pas encore le fichier objet de player et donc il ne pouvait pas faire la suite. C'est toujours une question d'ordre.

On a des fichiers qui dépandent d'autres si il utilise main avant player, ca ne fonctionnera pas. Alors que le but du Makefile, c'est de ne pas se poser de questions sur l'ordre dans lequel il faut compiler.

C'est pourquoi, on recommande d'utiliser les petites variables spéciales pour être sûr. 

## Utilisation des variables spéciales

On voit que l'on a un problème à la compilation, on décide donc d'utiliser les variables spéciales.

    makefile
    --------
    CC = gcc
    EXEC = prog
    SRC = $(wildcard *.c)
    OBJ = $(SRC:.c=.o)

    all : $(EXEC)

    %.o : %.c
        $(CC) -o $(OBJ) -c $(SRC)

    $(EXEC) : $(OBJ)
        $(CC) -o $(EXEC) $(OBJ)

$(OBJ) est notre cible et nous allons la remplacer par $@.

    +-------------------------------+---------------------------+
    |%.o : %.c                      | %.o : %.c                 |
    |   $(CC) -o $(OBJ) -c $(SRC)   |   $(CC) -o $@ -c $(SRC)   |
    +-------------------------------+---------------------------+

$(SRC) est la première dépendance donc la source en fonction. Donc si on a main.o, on va pas essayer de le créer avec player.c. Ca risque d'être problématique, on va le créer avec la variable de même nom, main.c, avec une autre extension. On met à la place $<. Ça permettra de gérer au mieux la priorité de la création des fichiers objets.

    +-------------------------------+---------------------------+
    |%.o : %.c                      | %.o : %.c                 |
    |   $(CC) -o $@ -c $(SRC)       |   $(CC) -o $@ -c $<       |
    +-------------------------------+---------------------------+

Au niveau de l'exécutable, comme les $(EXEC) sont identique, on peut remplacer la cible de la commande par $@.

    +-------------------------------+---------------------------+
    |$(EXEC) : $(OBJ)               | $(EXEC) : $(OBJ)          |
    |   $(CC) -o $(EXEC) $(OBJ)     |   $(CC) -o $@ $(OBJ)      |
    +-------------------------------+---------------------------+

Pour la liste des objets (main.o, player.o, etc), ce n'est plus dollar inférieur à mais dollar accent circonflexe $^. C'est la liste des dépendances.

    +-------------------------------+---------------------------+
    |$(EXEC) : $(OBJ)               | $(EXEC) : $(OBJ)          |
    |   $(CC) -o $@ $(OBJ)          |   $(CC) -o $@ $^          |
    +-------------------------------+---------------------------+

Cela nous donne :

    makefile
    --------
    CC = gcc
    EXEC = prog
    SRC = $(wildcard *.c)
    OBJ = $(SRC:.c=.o)

    all : $(EXEC)

    %.o : %.c
        $(CC) -o $@ -c $<

    $(EXEC) : $(OBJ)
        $(CC) -o $@ $^

Voilà donc la syntaxe la plus générique que l'on puisse faire.

Tout à l'heure, on a vu la syntaxe avec $(OBJ) qui ne fonctionnait pas. C'est pourquoi les variables spéciales peuvent donc avoir un intérêt pour ne pas se soucier de la priorité.

Sinon il faudrait mettre par exemple la condition que le fichier main.o, on le crée que si player.h

    main.o : player.h 

"main.o : player.h" signifie que si je recrée le fichier player.h, il va créer automatiquement main.o.

Cette syntaxe est permise, on n'est pas obligé de mettre une commande. 
Ca permet juste de gérer des dépendances.

En effet, à partir du moment où l'on va éditer player.h, le Makefile va recréer main.o.

Mais grâce aux variables spéciales, nous n'avons même plus besoin de s'embêter avec ça.

Cette syntaxe très générique va permettre de lancer l'éxécution avec la commande "make" ou "make all".

## Conditions

Ca ne fonctionne pas vraiment comme dans un langage de programmation.
Par exemple, une variable SYSTEME, WINDOWS ou LINUX.

    WINDOWS = yes

On choisit une variable WINDOWS et on lui attribue la valeur yes. Et on va pouvoir faire des conditions au niveau de notre code.

    ifeq ($(WINDOWS), yes)
        EXEC = prog.exe
    else
        EXEC = prog

On met ifeq (eq pour equal) et on dira que si ma variable WINDOWS vaut yes, on va faire une autre variable EXEC = prog.exe et donc si on est sur Windows, l'exécutable serait prog.exe.

Et sinon le EXEC serait simplement prog. Ce qui fait que EXEC prendra une valeur différente en fonction.

    makefile
    --------
    CC = gcc
    SRC = $(wildcard *.c)
    OBJ = $(SRC:.c=.o)

    WINDOWS = yes

    ifeq ($(WINDOWS), yes)
        EXEC = prog.exe
    else
        EXEC = prog

    all : $(EXEC)

    %.o : %.c
        $(CC) -o $@ -c $<

    $(EXEC) : $(OBJ)
        $(CC) -o $@ $^

On pourrait faire beaucoup de chose par rapport à ça.

Ça peut servir par exemple pour des commandes, pour la suppression de fichiers.

On peut également utiliser ifdef pour dire que quelque chose est défini pour gérer des conditions.

Il faut faire attention à ne pas trop en abuser autrement ça risque de compliquer notre Makefile. Surtout si on mélange les conditions, les variables spéciales, etc. Il faut avoir quelque chose de très simple et utilisable.

## Conclusion 

On a vu le code de base.
On a vu les variables spéciales.
On a vu les commandes précises (all, clean, etc.).
On a vu les conditions.

Le programme Makefile est très dense, il y a beaucoup à voir.