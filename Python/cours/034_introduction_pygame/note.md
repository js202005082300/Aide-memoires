# [34. Introduction pygame](https://www.youtube.com/watch?v=gx4yVcJqBaI)

Bonjour à tous bienvenue pour cette vidéo numéro 34 sur la formation python. 

On attaque le prochain est le dernier chapitre de ce cours de programmation avec l'arrivée d'une bibliothèque graphique 2D qui s'appelle pygame. 

Alors si vous avez suivi ma formation sur le langage c avec la bibliothèque SDL, il faut savoir que pygame se base, est dérivé, dérive de cette bibliothèque SDL, et va permettre, comme pour la SDL, de gérer tout un tas d'affichage donc te permettre de dessiner à l'écran des points, des lignes, de faire des tracés, des animations, d'afficher des images, des sprites ou tout ce genre de choses, de gérer des couleurs, des polices d'écriture et cetera et cetera. 

Alors il faut bien différencier ça c'est très important, bibliothèque graphique 2D comme je viens de vous présenter la par rapport à une bibliothèque d'interface graphique, une bibliothèque de GUI comment on dit. 

Une bibliothèque d'interface graphique GUI, c'est une bibliothèque qui propose des widgets, des boutons, des champs de texte, des labels, ce genre de chose … et qui permettent comme ça d'interagir avec l'utilisateur pour tout un tas de choses. 

Une bibliothèque graphique, c'est vraiment pour dessiner, pour produire quelque chose à l'écran et pas avoir des widgets même si on pourrait très bien se servir d'une bibliothèque 2D pour créer des interfaces graphiques mais ce n'est pas conçu pour ça, attention. 

Si vous voulez utilisez pygame par exemple pour commencer à mettre des widgets de bouton ou autre, ça n'existe pas dans la bibliothèque, il faudra le faire vous-même, créer des images pour simuler des faux bouton. 

Si vous voulez des interfaces graphiques, on l'a déjà vu dans le cours très simplement et de manière native avec tkinter. 

Tkinter qui est une interface graphique.

Là on attaque vraiment de la bibliothèque graphique donc du descend 2D. 

Alors on va déjà s'occuper de l'installation de tout ça, avant toute chose on va ouvrir un terminal. Vous allez l'ouvrir avec des droits d'administrateur ou en root si vous êtes sur Linux, vous passez sur un terminal en root.

Et nous allons utiliser un outil dont j'ai déjà parlé, j'en ai déjà parlé sur mes vidéos qui est l'outil pip pour python qui permet d'installer différents package. 

Si ce n'est pas le cas vous pouvez aller voir ma vidéo tutoriel donc dans la playlist des tutoriels de python, la vidéo pour installer des package avec pip entre parenthèses pour que vous puissiez facilement identifier cette vidéo. 

Donc là on va déjà mettre à jour cet outil parce que je pars du principe qu'il est déjà installé sur votre ordinateur. 

On va déjà s'assurer qu'il est à jour sur votre ordinateur donc on va utiliser la commande `python -m pip install --upgrade pip`
```powershell
    >python -m pip install --upgrade pip
    Collecting pip
      Downloading pip-20.2.4-py2.py3-none-any.whl (1.5 MB)
         |████████████████████████████████| 1.5 MB 1.6 MB/s
    Installing collected packages: pip
      Attempting uninstall: pip
        Found existing installation: pip 20.1.1
        Uninstalling pip-20.1.1:
          Successfully uninstalled pip-20.1.1
    Successfully installed pip-20.2.4
```
```powershell
    >python -m pip install --upgrade pip
    Requirement already up-to-date: pip in ..\onedrive\formations\programmesportable\python\lib\site-packages (20.2.4)
```
On fait ça et normalement il doit le mettre à jour donc moi il est en version 18.1 au moment où je fais cette vidéo. 

Une fois que cela est fait, on va pouvoir maintenant installer pygame via cet installateur de package comme cela tout sera géré mais on pourra facilement le mettre à jour, facilement désinstaller, pas besoin d'aller chercher sur internet, de faire des ajouts de fichiers et cetera. 

Tout sera géré automatiquement par ce gestionnaire de package donc pour cela vous utilisez la commande comme je voulais montrer dans la vidéo sur comment installer des packages donc si vous êtes sur python 3 sur Linux et MacOS, il est même possible que vous ayez besoin de mettre un petit 3 à la suite sinon il va utiliser la version par défaut de python du système qui sera dans beaucoup de cas python 2.7 ou en tout cas une version inférieure à la version 3. 

Donc on fait juste `pip install pygame`.
```powershell
    >pip install pygame
    Collecting pygame
      Downloading pygame-2.0.0-cp38-cp38-win_amd64.whl (5.1 MB)
         |                                | 20 kB 1.3 MB/s eta 0:0     |                                | 30 kB 990 kB/s eta 0:0     |                                | 40 kB 1.3 MB/s eta 0:0     |                                | 51 kB 1.7 MB/s eta 0:0     |▌                               | 61 kB 1.3 MB/s eta 0:0  
         ...
         |████████████████████████████████| 5.1 MB 2.2 MB/s eta 0:     |████████████████████████████████| 5.1 MB 2.2 MB/s eta 0:     |████████████████████████████████| 5.1 MB 2.2 MB/s eta 0:     |████████████████████████████████| 5.1 MB 2.2 MB/s
    Installing collected packages: pygame
    Successfully installed pygame-2.0.0
```
Et à partir de là si ce n'est pas installé, il va vous l'installer. 

Si c'est déjà installé, il faut mettre le chemin vers les différents package.
```powershell
    >pip install pygame
    Requirement already satisfied: pygame in ..\onedrive\formations\programmesportable\python\lib\site-packages (2.0.0)
```
Donc pygame, c'est évidemment un package. On en avait déjà parlé sur le cours python lorsqu'on avait parlé des packages et des modules.

Donc c'est un package qui rassemble plusieurs modules, et ces différents modules vont permettre de gérer tout un tas de choses différentes. 

On aura un module pour tout ce qui est affichage, on aura un module pour les événements, on aura un module pour gérer la souris, on aura un module pour le son et cetera. 

On a vraiment différents modules et bien évidemment on ne verra pas tout parce qu'il n'y a pas besoin de connaître tous les modules de la bibliothèque pour pouvoir par exemple créer un jeu vidéo ou je ne sais pas par exemple un logiciel qui produit des tracés ou un logiciel de géométrie qui manipule des formes, qui fait des trucs mathématiques. 

On n'a pas forcément besoin de te voir d'autant qu'il y a des modules un peu vieux, vieillot par rapport à ce que l'on peut faire aujourd'hui mais en tout cas on verra l'essentiel et le principal, ce qui est le plus utile et qui vous permettra ensuite de créer de véritables programmes donc des jeux vidéo ou autre en python avec pygame.

Une fois que c'est installé, on va faire un petit code très rapide c'est simplement pour voir si tout est installé donc évidemment cette vidéo sera très courte. C'est une petite vidéo d'introduction et c'est tout. 

Je ne vais pas vous expliquer le code après ce que je vais vous montrer la parce qu'on le verra bien en détail sur la prochaine vidéo.

Alors c'est pareil je ne l'ai pas dit c'est juste pour la petite parenthèse, pygame est une bibliothèque qui a été créée en 2000. 

Cette bibliothèque a à l'heure actuelle où je fais cette vie de plus de 18 ans donc vous voyez qu'elle a quand même une certaine ancienneté, elle a été beaucoup beaucoup utilisé, et vous pouvez vous renseigner y aller chercher des jeux pygame et vous trouverez des choses sympas. 

Il y a même des jeux sur Stink qui sont développés avec pygame, des jeux en 2D, il y a même des jeux qui sont faits en 3D avec l'usage d'une autre bibliothèque par exemple pyopengl qui permet d'associer avec pygame de la 2D et de la 3D. 

Bref on peut vraiment faire beaucoup de choses et de manière assez puissante même si vous le verrez surtout gros gros projet, le langage python montre ses limites par rapport à un langage compilé comme le c++, le c# ou ce genre de langage.

Donc évidemment vous ne pourrez pas produire tous les programmes que vous voulez avec pygame en python, des programmes très lourds, très riche au niveau des animations, au niveau du nombre de ressources que vous chargez mais vous pourrez quand même produire déjà des jeux très intéressants d'accord avec des programmes très intéressants aussi. 

Alors au niveau du code, alors je vais importer tout ça, alors je ne vous l'explique pas au niveau du code, on reviendra dessus par la suite de toute façon. Vous avez juste à recopier ce que je vous mets ici à l'écran et sans faire d'erreur donc attention respectez bien les minuscules et les majuscules. C'est important si vous ne voulez pas avoir d'erreurs. Je le dis parce que parfois des fois dans les commentaires que vous me laissez, vous faites parfois des petites sœur d'inattention parce que vous avez mis des mots en majuscules au lieu de minuscule ou inversement. 

Donc on fait ça.
```py
#coding:utf-8
import pygame

pygame.init()
screen = pygame.display.set_mode((640,480))

launched = True

while launched:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            launched = False
```         
Vous en faites pas, tout vous sera expliqué en détail, vous saurez à quoi correspond chacune de ces lignes. Reviendra dessus mais c'est juste pour avoir un code minimal si vous voulez avoir quelque chose d'un minimum propres, pas faire non plus n'importe quoi, pour qu'on puisse voir que tout est bien installé et que ça fonctionne.

On y va.

On exécute notre programme et comme on est sur python il n'y a rien de compliqué.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
Et voilà, vous avez normalement une fenêtre qui s'ouvre c'est-à-dire du 640x480 puisque c'est ce qu'on a spécifié là. On a un logo par défaut, un titre par défaut donc on verra comment changer le titre, ce genre de chose. Un écran noir parce que c'est logique, on a rien affiché de particulier. 

Et la gestion ..
```py
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
La gestion ça je le dis très rapidement, c'est simplement pour que quand on clique sur la crotte de la fenêtre, on puisse tout simplement quitter le programme. C'est pour ça que j'ai mis ça pour faire quelque chose d'un minimum propre et pas non plus de devoir quitter le programme en fermant le terminal, ce qui ne serait pas forcément très esthétique voilà. 

Voilà donc ça a l'air de fonctionner normalement, de toute façon pygame était normalement bien installé, bien avant que je fasse la vidéo donc je savais que ça fonctionnait de toute façon de mon côté. 

Mais vérifier que tout est installé de votre côté, que vous avez bien la version la plus à jour possible donc normalement ça doit être la 1.9.4 si vous suivez la vidéo pas très longtemps après au moment où je l'ai enregistrer. 

Si vous avez une version plus récente d'ici là, ce n'est pas grave du tout mais en tout cas vous saurez que la vidéo sera fait avec cette version là donc la version 1.9.4 mais il ne devrait pas y avoir de problème de compatibilité. 

Voilà je n'ai plus qu'a vous dire à bientôt pour la suite de ces vidéos, je vous dis qu'on va attaquer un bon petit chapitre, on va quand même voir quelques vidéos dessus, et pour terminer ce cours en python, et vous allez comme ça avoir quelque chose de supplémentaire on niveau des compétences et des connaissances que vous avez avec ce langage. 

À bientôt du coup pour la prochaine séance sur cette formation. 

Ciao tout le monde