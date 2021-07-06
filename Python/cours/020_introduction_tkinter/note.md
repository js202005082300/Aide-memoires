# [20. Introduction tkinter](https://www.youtube.com/watch?v=H0BFsl2_St4)

Bonjour à tous vous êtes sur la séance 20 en langage python.

Dans ce cours à partir de maintenant, nous allons voir comment on va créer des programmes en fenêtre donc des programmes fenêtrés à l'inverse des programmes qu'on avait l'habitude de faire jusqu'à présent qui était en console c'est-à-dire que vous réalisiez un certain type de programme et on affichait tout dans le terminal c'est à dire dans l'invite de commande c'est-à-dire un programme en mode console.

Je vais vous montrer Comment créer des programmes fenêtrés.

Cette vidéo c'est une introduction à ce type de programmation.

Alors il existe beaucoup de bibliothèques, on a les bibliothèques Cute, on a GTK, on a wxWidget, on n'a pas mal pour faire ce genre de choses mais plutôt que de vous faire installer une bibliothèque externe plutôt que de paramétrer ce genre de chose assez compliqué, il faut savoir que le langage python propose en natif donc directement présent directement dans l'interpréteur, Il comprend un système de fenêtrage qui est tkinter. Et il est prévu des tutoriels sur les autres bibliothèques ce qu'on verra en surface sans entrer dans les détails parce que je ne peux pas évidemment tout traiter tous les types de bibliothèques, tous les types de langage, tous les types de notions sinon évidemment on ne s'en sortirait pas vu le nombre de langage et de choses qu'il y a à savoir. 

Donc là au niveau de cette formation formation, je vais former sur le module présent en natif en python qui est tkinter. 

On va d'abord l'importer pour voir comment l'utiliser et nous allons créer dans cette vidéo notre première fenêtre. 

Le premier type d'importation que vous connaissez, il suffit de faire import tkinter. 
```py
    #coding:utf-8

    import tkinter
```
Voilà ce genre de chose, je rappelle que vous pouvez avoir une différence de syntaxe selon que vous utilisez python 3 au python 2. Nous nous travaillons sur python 3 quelque chose, Si vous voulez les notations en python 2 quelque chose, 2.7, 2.6, vous pouvez ou vous pourrez trouver, tout dépend du moment où je fais cette vidéo, les différences de syntaxe entre les 2 versions de langage comme ça vous pourrez migrer de l'un à l'autre, traduire de l'un à l'autre sans aucun problème. 

Donc ici en python 3, on marque "import tkinter" comme ça, pas de majuscule, c'est tout en minuscule, ça c'est le premier type d'un import et le 2nd que vous connaissait aussi parce qu'on l'avait vu sur la séance sur les modules, vous pouvez faire "from tkinter import …". Et choisir d'importer ce que vous voulez. 
```py
    #coding:utf-8

    import tkinter
    #from tkinter import
```
Vous pouvez par exemple importer tout en mettant une étoile *. Cette syntaxe évite de devoir réécrire à chaque fois ce mot là, tkinter. 
```py
    #coding:utf-8

    import tkinter
    #from tkinter import *
```
import tkinter, là on va devoir écrire à chaque fois "tkinter.quelque_chose" Pour pouvoir utiliser une méthode ou autre alors qu'avec cette construction-là, from tkinter import *, on aurait juste à noter le nom de la méthode ou du constructeur ou ce genre de chose.

Moi je vais garder ce type de import, "import tkinter", comme ça on verra ce qui est propre à tkinter on verra bien et ce qui ne l'est pas forcément. 

À partir de là on va pouvoir créer notre première fois fenêtre et ça va se passer en 2 lignes, c'est vraiment très très rapide. La première évidemment comme pour tout objet, tkinter possède constructeur qui va permettre de créer une fenêtre c'est-à-dire un contexte qui va créer notre programme principal donc la fenêtre principale du coup je vais l'appeler mainapp et si je vais utiliser le constructeur de tkinter ok qui est ici, Tk, avec une majuscule au T. Ensuite j'ouvre les parenthèses et je ne met rien dedans, c'est un constructeur par défaut qui n'a pas forcément besoin de valeurs.  
```py
    #coding:utf-8

    import tkinter
    #from tkinter import

    mainapp = Tk()
```
On pourrais mettre des valeurs mais je ne vois pas l'utilité par rapport à ce que je vous ai montré donc vous pouvez laisser ça comme ça, Tout ce qui est paramétrage et configuration de la fenêtre, on fera de toute manière après d'une autre manière. 

Donc on fait ça, mainapp = Tk(), on construit la fenêtre dans mainapp donc mainapp devient un objet Tk donc tkinter tout simplement, et ensuite on va permettre l'ouverture, l'exécution de la fenêtre et surtout de la garder ouverte parce que comme vous le savez, pour ce genre de programme j'en avais un peu parlé, je l'avais un peu abordé, il va falloir faire une boucle infinie c'est-à-dire de dire que tu affiche la fenêtre sur un temps indéfini donc infini jusqu à ce que l'utilisateur quitte le programme donc pour cela on va utiliser, sur mainapp toujours, on va utiliser mainloop() qui est la méthode pour pouvoir faire une boucle qui tourne tout le temps à l'infini sur la fenêtre.
```py
    #coding:utf-8

    import tkinter
    #from tkinter import

    mainapp = … Tk()
    mainapp.mainloop()
```
Alors si j'avais fait cette import ici, from tkinter import *, Tk() aurait suffit mais là comme j'ai fait cet import là, import tkinter, c'est pour ça que je vous ai montré que c'était différent, on n'oublie pas de rajouter le nom du module et on met un point, tkinter.Tk() pour dire que Tk() appartient au module Tkinter.
```py
#coding:utf-8

import tkinter
#from tkinter import

mainapp = tkinter.Tk()
mainapp.mainloop()
```
Si par contre vous choisissez l'autre type d'import, je pourrais directement faire ça.
```py
    #coding:utf-8

    #import tkinter
    from tkinter import

    mainapp = Tk()
    mainapp.mainloop()
```
Voilà c'est vous qui choisissez, c'est l'un ou l'autre mais moi pour la vidéo je garde celui-là import tkinter mais peut être que plus tard je repasserais sur l'autre type d'import pour simplifier les écritures mais là comme c'est la première vidéo sur tkinter, je resterai comme ça, et là on va pouvoir exécuter notre programme. 
```powershell
    >python main.py
    
    (fenêtre tk)
```
On ouvre une fenêtre qui comme vous le voyez possède une taille par défaut, elle n'a évidemment rien parce que je n'ai rien mis dedans et on peut la redimensionner sans problème voilà par défaut c'est redimensionnable à l'infini, voyez qu'on peut avoir un truc sans rien du tout parce qu'on a évidemment rien dans la fenêtre. 

Alors ceci, la fenêtre que je viens de créer, ça s'appelle un widget tout ce qui est en programmation d'interface fenêtré s'appelle un widget. La fenêtre c'est un widget, quand on va créer des boutons ce seront des widgets, quand on va créer un label, c'est-à-dire un champ d'affichage, ce sera un widget, en champ de texte pour saisir des informations, ce sera un widget et cetera et cetera. 

Tout ce que vous allez pouvoir ajouter dans une fenêtre, qui est elle-même un widget est un widget et ça c'est vraiment à retenir parce que vous allez voir que c'est comme un puzzle. On crée plusieurs petits widgets et ensuite on les met dans notre fenêtre, à l'endroit qu'on veut, à l'emplacement qu'on veut, de la manière qu'on veut et en définissant certaines propriétés. 

Après on gèrera des événements pour pouvoir faire des actions suivant ce que l'on va faire sur notre fenêtre. 

Ici le seul moyen de quitter le programme ici, c'est d'utiliser la croix parce que je n'ai mis aucun événement, aucune méthode pour quitter la fenêtre. 

Pour info et on aura l'occasion de le voir plus tard, la méthode qui va permettre de le quitter si vous voulez le quitter manuellement, ce serait de faire :
```py
    mainapp.quit()
```
c'est cette méthode qui va permettre de quitter la fenêtre, on verra ça plus tard, mais pour l'instant on va quitter avec la croix. On aura plein d'autres méthodes tel que update() Pour gérer vraiment le comportement de la fenêtre. 

Ici, je voulais juste la créer, l'afficher à l'infini jusqu'à temps qu'on la ferme avec la croix.

Donc ici pas de souci, on va pouvoir du coup définir  … Même si on va pas avoir grand grand chose mais quand même quelques petites choses par rapport à la fenêtre … on va pouvoir lui spécifier un titre car vous avez vu que par défaut ça mettait tk et ça met même une icône spéciale, on a vraiment rien de plus donc on va paramétrer nous des choses personnellement par rapport à ça. 

Du coup je vais choisir mainapp donc on travaille toujours là-dessus, on part donc de notre objet, et on va utiliser la méthode title("""). Et dedans vous mettez votre programme, je peux mettre des accents puisqu'on travaille en utf 8 donc il n'y a évidemment aucun problème d'accent ici. 
```py
    mainapp.title("Mon premier programme")
```
Et là si j'exécute le programme. 
```py
#coding:utf-8

import tkinter
#from tkinter import

mainapp = tkinter.Tk()
mainapp.title("Mon premier programme")

mainapp.mainloop()
```
```powershell
    >python main.py
```
Vous allez donc comme ça pouvoir configurer le titre que vous voulez, il n'y a pas de souci à ce niveau là donc ça c'est tard tenir, title(), peut être pratique pour changer le titre de votre fenêtre, ce qui est affiché simplement sur le bandeau. 

On va pouvoir également définir une dimension à cette fenêtre donc moi je vais faire mainapp et on va l'appeler géométrie qui va prendre plusieurs arguments mais pour le moment on va voir les plus simples, elle prend la résolution de X c'est-à-dire la largeur de la fenêtre multiplié (x) par la hauteur de la fenêtre (Y). Non par exemple je vais dire qu'elle fait 800 multiplié par 600.
```py
#coding:utf-8

import tkinter
#from tkinter import

mainapp = tkinter.Tk()
mainapp.title("Mon premier programme")
mainapp.geometry("800x600")

mainapp.mainloop()
```
Donc elle fait 800 pixels de largeur et elle va faire 600 pixels en hauteur et là si je démarre vous voyez qu'elle va faire cette taille là.
```powershell
    >python main.py
```
Elle a toujours dimensionnable, pas de problème, tout est géré, je peux la maximiser, la réduire. 

On reviendra là-dessus sur geometry parce qu'il y a un tout petit peu plus complexe à l'utilisation.

On va pouvoir choisir une taille minimale pour la fenêtre, on a écrit.
```powershell
    mainapp.minsize(""")
```
Evidemment si vous définissez une taille minimale à votre fenêtre, elle va s'ouvrir à cette taille là parce qu'elle ne peut pas être plus petite que ça, moi je vais dire 640 et mon premier argument et la 2e okay c'est 480, la hauteur.
```py
#coding:utf-8

import tkinter
#from tkinter import

mainapp = tkinter.Tk()
mainapp.title("Mon premier programme")
mainapp.minsize(640, 480)

#mainapp.geometry("800x600")

mainapp.mainloop()
```
Là j'exécute le programme, ça fait bien 640x480.
```py
    >python main.py
```
Je ne peut pas réduire un plus petit parce que j'ai vraiment défini des dimensions minimale. Je peux définir des dimensions maximales comme vous vous en doutez avec tout simplement maxsise(), je vais mettre par exemple 1280x720.
```py
#coding:utf-8

import tkinter
#from tkinter import

mainapp = tkinter.Tk()
mainapp.title("Mon premier programme")
mainapp.minsize(640, 480)
mainapp.maxsize(1280, 720)

#mainapp.geometry("800x600")

mainapp.mainloop()
```
Du coup, on exécute.
```powershell
    >python main.py
```
Donc vraiment ça définit des tailles minimales et maximales, peut-être que vous n'en aurez jamais besoin mais sachez que c'est des méthodes qui existent et qu'on peut modifier ces choses-là. Pour le moment je vais les mettre en commentaire.
```py
    #coding:utf-8

    import tkinter
    #from tkinter import

    mainapp = tkinter.Tk()
    mainapp.title("Mon premier programme")
    #mainapp.minsize(640, 480)
    #mainapp.maxsize(1280, 720)

    #mainapp.geometry("800x600")

    mainapp.mainloop()
```
On a vu comment redimensionner ou définir des dimensions spécifiques à notre fenêtre. On peut aussi interdire leur redimensionnement, ça peut être utile, je vous le montre c'est resizable().
```py
    #coding:utf-8

    import tkinter
    #from tkinter import

    mainapp = tkinter.Tk()
    mainapp.title("Mon premier programme")
    #mainapp.minsize(640, 480)
    #mainapp.maxsize(1280, 720)
    #mainapp.geometry("800x600")
    
    mainapp.resizable()

    mainapp.mainloop()
```
resizable() prends 2 paramètres, en premier la largeur et ensuite la hauteur. En premier la largeur, je lui dis de ne pas modifier, width=False, et admettons je mets juste ça.
```py
#coding:utf-8

import tkinter
#from tkinter import

mainapp = tkinter.Tk()
mainapp.title("Mon premier programme")
#mainapp.minsize(640, 480)
#mainapp.maxsize(1280, 720)
#mainapp.geometry("800x600")

mainapp.resizable(width=False)

mainapp.mainloop()
```
```powershell
>python main.py
Traceback (most recent call last):
...
_tkinter.TclError: wrong # args: should be "wm resizable window ?width height?"
```
Il ne veut pas évidemment, il faut mettre aussi la hauteur.
```py
#coding:utf-8

import tkinter
#from tkinter import

mainapp = tkinter.Tk()
mainapp.title("Mon premier programme fenétré")
#mainapp.minsize(640, 480)
#mainapp.maxsize(1280, 720)
#mainapp.geometry("800x600")

mainapp.resizable(width=False, height=True)

mainapp.mainloop()
```
```powershell
    >python main.py
```
Si j'essaie de modifier la largeur, il ne veut pas parce que j'ai mis False, c'est interdit par contre en hauteur ça ne va pas l'embêté.

Si je mets les 2 à False, je ne pourrais rien modifier.
```py
#coding:utf-8

import tkinter
#from tkinter import

mainapp = tkinter.Tk()
mainapp.title("Mon premier programme fenétré")
#mainapp.minsize(640, 480)
#mainapp.maxsize(1280, 720)
#mainapp.geometry("800x600")

mainapp.resizable(width=False, height=False)

mainapp.mainloop()
```
```powershell
    >python main.py
```
On ne peut rien modifier, je n'ai même plus le curseur qui permet de redimensionner la fenêtre, c'est vraiment interdit, on empêche le redimensionnement donc ça c'est à savoir.

donc si vous voulez tout redimensionner, par défaut c'est True et True, si vous voulez du redimensionnement complet, ça ne sert à rien d'utiliser la méthode. C'est vraiment pour interdire arrondissement seulement d'un côté ou de l'autre ou alors les 2 si on veut vraiment tout interdire.

D'ailleurs je vais la mettre ici en commentaire, c'est des petites infos à connaître.
```py
    #coding:utf-8

    import tkinter
    #from tkinter import

    mainapp = tkinter.Tk()
    mainapp.title("Mon premier programme fenétré")
    #mainapp.minsize(640, 480)
    #mainapp.maxsize(1280, 720)
    #mainapp.resizable(width=False, height=False)
    #mainapp.geometry("800x600")

    mainapp.mainloop()
```
Donc ça c'est la petite info à connaître.

On peut également spécifier la position de la fenêtre et pour ça je vais faire ceci, mainapp.positionfrom("""), et là on va dire utilisateur (user) par défaut.
```py
#coding:utf-8

import tkinter
#from tkinter import

mainapp = tkinter.Tk()
mainapp.title("Mon premier programme fenétré")
#mainapp.minsize(640, 480)
#mainapp.maxsize(1280, 720)
#mainapp.resizable(width=False, height=False)
#mainapp.geometry("800x600")
mainapp.positionfrom("user")

mainapp.mainloop()
```
Je vais assez vite sur les méthodes, allez voir dans la documentation si vous voulez voir des choses très spécifique.

mon but ce n'est pas de vous faire un listing avec plein d'exemples d'autant qu'il y en a qui ne vous serviront pas et là vous voyez par défaut, la fenêtre s'ouvre sans souci.

positionfrom(), regardez un petit peu cette méthode comment elle fonctionne pour tout ce qui est spécification de la position de la fenêtre, dailleurs d'où elle est positionnée.

On peut également bien évidemment voir la taille, sizefrom()
```py
#coding:utf-8

import tkinter
#from tkinter import

mainapp = tkinter.Tk()
mainapp.title("Mon premier programme fenétré")
#mainapp.minsize(640, 480)
#mainapp.maxsize(1280, 720)
#mainapp.resizable(width=False, height=False)
#mainapp.geometry("800x600")
mainapp.sizefrom("user")

mainapp.mainloop()
```
sizefrom(), pareil même chose donc selon le cas vous pourrez avoir une dimension qui est déterminée par certains paramètres donc ça pareil à vous de voir.

Moi pour le moment je ne rentre pas plus dans le vif du sujet comme on va voir d'autres vidéos de toute manière sur tkinter, on verra ce genre de choses un peu plus en détail par la suite.

Là je vous montre juste qu'elles existent et on verra ça plus tard voilà.

Et je vais terminer du coup ... je vais revenir sur ce que vous avez présenté au début qui est cette fameuse méthode geométry().

Regardez on la note en commentaire et nous on va revenir sur geometry().
```py
    #coding:utf-8

    import tkinter
    #from tkinter import

    mainapp = tkinter.Tk()
    mainapp.title("Mon premier programme fenétré")
    #mainapp.minsize(640, 480)
    #mainapp.maxsize(1280, 720)
    #mainapp.positionfrom("user")
    #mainapp.sizefrom("user")
    #mainapp.resizable(width=False, height=False)

    mainapp.geometry("800x600")

    mainapp.mainloop()
```
geometry() en réalité elle peut prendre plusieurs choses à l'intérieur ici, ça va s'écrire de cette manière.
```py
    geometry("X")
```
On va écrire en réalité X d'accord c'est-à-dire rappelez-vous la largeur en pixels fois Y ("XxY"). Y ça va être la hauteur en pixels ensuite on a un plus + ou moins moins -- donc vous allez voir pourquoi. C'est par rapport à la position relative de la fenêtre c'est-à-dire que si je met +0 ou rien du tout de toute manière.
```py
    geometry("XxY+0")
```
La fenêtre va faire X foie Y en dimension et son point d'abscisse va démarrer à 0 donc le coin supérieur gauche avec X qui va gauche à droite et Y qui va de haut en bas. 

Donc si je dis 10 et 10 il va faire 10X et 10Y donc ça va démarrer la fenêtre en haut à gauche, décallé du bord donc je met +10+10 et vous allez voir un petit peu.
```py
#coding:utf-8

import tkinter
#from tkinter import

mainapp = tkinter.Tk()
mainapp.title("Mon premier programme fenétré")
#mainapp.minsize(640, 480)
#mainapp.maxsize(1280, 720)
#mainapp.positionfrom("user")
#mainapp.sizefrom("user")
#mainapp.resizable(width=False, height=False)

#geometry("XxY+0+0")
mainapp.geometry("800x600+10+10")

mainapp.mainloop()
```
```py
    >python main.py
```
Voilà vous voyez le petit point ici en haut à gauche de ma fenêtre il est mis à 10 10 de mon écran d'accord.

Imaginer un espèce de quadrillage graphique ou le point il est à 0 (haut-gauche) et qui est à la largeur de mon écran donc 1920 (haut-droite) et que la hauteur donc le point tout en bas à gauche, c'est la hauteur maximum de mon écran c'est-à-dire 1080 parce que je suis en 1920 1080 au niveau de la résolution, voilà, donc ça c'est des petites choses à savoir.

Si je met 50 et par exemple 100.
```py
#coding:utf-8

import tkinter
#from tkinter import

mainapp = tkinter.Tk()
mainapp.title("Mon premier programme fenétré")
#mainapp.minsize(640, 480)
#mainapp.maxsize(1280, 720)
#mainapp.positionfrom("user")
#mainapp.sizefrom("user")
#mainapp.resizable(width=False, height=False)

#geometry("XxY+0+0")
mainapp.geometry("800x600+50+100")

mainapp.mainloop()
```
```powershell
    >python main.py
```
Petit décalage à droite et il va mettre un décalage de 100 pixels vers le bas, c'est ça qu'il faut comprendre voilà.

Vous voyez décalage de 50 pixels vers la droite décalage de 100 pixels vers le bas.

Du coup ça permet comme ça de vraiment configurer un positionnement assez spécifique après on pourra également centrer la fenêtre.

Pour centrer je vous montre parce que ça ne fonctionne pas forcément parfaitement c'est-à-dire que si vous essayez de centrer la fenêtre ça ne va pas allez. Alors je ne sais pas pourquoi il faudra que je me renseigne par rapport à ça au niveau de python mais la fenêtre on a beau vraiment spécifier le centrage de la fenêtre, il n'arrive pas à la centrer donc je ne sais pas de quoi ça vient; il faut que je regarde. J'ai un 2e écran aussi donc ça peut peut-être venir de là. Je regarderais dans tous les cas mais voilà je n'ai jamais pû centré la fenêtre correctement.

Comment on centre une fenêtre sur un écran, comment on fait ça ? bien je vous montre quand même la méthode d'accord même si ça ne fonctionne pas à 100 pour 100, je montre comment on fait puisque c'est un calcul mathématique très simple.

Pour ça il va falloir déterminer la position c'est-à-dire donc la position en X de votre fenêtre et la position en Y d'accord c'est-à-dire en fait la position X, position y c'est ce qu'on va mettre ici, d'accord.
```
    position_X =
    position_Y
```
C'est les informations qu'on va mettre ici.
```py
    geometry("800x600+<ICI position X>+<ICI position Y>")
```
Comment on va aller calculer ça pour centrer notre fenêtre ? et bien le calcul est vraiment très simple.

Déjà pour x il suffit de faire ... ce que je note ici, ce n'est pas des choses au niveau du code, c'est juste que je vous met des noms pour comprendre. Je vais mettre comme ça, ce sont des notes en commentaire.
```py
    """
    position_X = (largeur)
    position_Y
    """
```
La position x donc ce qui va être ici, geometry("XxY+<ICI>+posY"), c'est la largeur de mon écran, d'accord, diviser par 2, on va mettre un double slash.
```py
    """
    position_X = (largeur_ecran // 2)
    position_Y
    """
```
Et il ne faut pas oublier de retirer la surface de la fenêtre parce que la fenêtre, elle fait une certaine taille, c'est pas un seul point donc un pixel donc si vous faites que ça, (largeur_ecran // 2), c'est comme si vous considérez que votre fenêtre elle fait qu'un pixel donc évidemment ce ne serait pas centré donc il faut retirer également la moitié de la largeur de la fenêtre donc largeur_fenetre et qu'on divise également par 2.
```py
    """
    position_X = (largeur_ecran // 2) - (largeur_fenetre // 2)
    position_Y =
    """
```
Si vous faites ce calcul là, position_X ça deviendra vraiment le centre, d'accord, il trouvera la bonne assise et du coup pour position_Y, ce sera la hauteur de l'écran divisé par 2 moins la hauteur de la fenêtre divisé divisé par 2.
```py
    """
    position_X = (largeur_ecran // 2) - (largeur_fenetre // 2)
    position_Y = (hauteur_ecran // 2) - (hauteur_fenetre // 2)
    """
```
Alors comment on peut le faire ? je vais vous montrer évidemment une méthode pour le faire d'accord on va regarder ça rapidement.

On va déjà récupérer la taille de mon écran screen_x et screen_y donc je veux récupérer la largeur, la hauteur de mon écran et ensuite je veux définir moi même une largeur pour ma fenêtre window_x et une hauteur pour ma fenêtre window_y.
```py
    screen_x = 
    screen_y =
    window_x = 
    window_y = 

    """
    position_X = (largeur_ecran // 2) - (largeur_fenetre // 2)
    position_Y = (hauteur_ecran // 2) - (hauteur_fenetre // 2)
    """
```
Je vais mettre 800x600 pour la fenêtre sans soucis.
```py
    screen_x = 
    screen_y =
    window_x = 800
    window_y = 600

    """
    position_X = (largeur_ecran // 2) - (largeur_fenetre // 2)
    position_Y = (hauteur_ecran // 2) - (hauteur_fenetre // 2)
    """
```
Et ensuite on va utliser une propriété, une méthode pour récupérer XY de notre fenêtre donc vous allez mettre mainapp et vous allez faire point winfo_screenwidth() alors ça fait un nom à rallonge c'est pour ça que je le récupère dans une variable parce ce que je n'ai pas envie de taper ça à chaque fois, ça fait vachement long.
```py
    screen_x = mainapp.winfo_screenwidth()
    screen_y =
    window_x = 800
    window_y = 600

    """
    position_X = (largeur_ecran // 2) - (largeur_fenetre // 2)
    position_Y = (hauteur_ecran // 2) - (hauteur_fenetre // 2)
    """
```
Donc ça c'est pour le X, là il va récupérer en fait la résolution de mon écran à moi d'accord c'est pour être sûr d'avoir ma résolution parce que si par exemple vous avez un écran plus petit au plus grand, vous n'aurez pas la même résolution donc c'est bien qu'il récupère sur votre ordinateur aussi et ça pour la hauteur.
```py
    screen_x = mainapp.winfo_screenwidth()
    screen_y = mainapp.winfo_screenheight()
    window_x = 800
    window_y = 600

    """
    position_X = (largeur_ecran // 2) - (largeur_fenetre // 2)
    position_Y = (hauteur_ecran // 2) - (hauteur_fenetre // 2)
    """
```
Du coup on fait tout ça et à partir de ce moment-là pour geometry(), je vais le définir de cette manière-là alorsje passe par un formatage comme ça je suis sûre d'avoir les bonnes valeurs.
```py
    screen_x = mainapp.winfo_screenwidth()
    screen_y = mainapp.winfo_screenheight()
    window_x = 800
    window_y = 600
    geo = "{}x{}+{}+{}".format()

    """
    position_X = (largeur_ecran // 2) - (largeur_fenetre // 2)
    position_Y = (hauteur_ecran // 2) - (hauteur_fenetre // 2)
    """
```
Voilà `.format()` et ensuite on n'oublie pas de faire un entier mais de façon que vous fassiez un entier ou non, là ça tombe pile donc c'est pas un souci. Mais vous pouvez caster() pour être sûr.
```py
    screen_x = int(mainapp.winfo_screenwidth())
    screen_y = int(mainapp.winfo_screenheight())
    window_x = 800
    window_y = 600
    geo = "{}x{}+{}+{}".format()

    """
    position_X = (largeur_ecran // 2) - (largeur_fenetre // 2)
    position_Y = (hauteur_ecran // 2) - (hauteur_fenetre // 2)
    """
```
`geo = "{}x{}+{}+{}".format()`, va prendre en paramètres window_x, window_y, posX, posY et là du coup on va définir posX et posY et les remplacer dans le pseudo code et là, on remplace bien chacune des choses.
```py
    screen_x = int(mainapp.winfo_screenwidth())
    screen_y = int(mainapp.winfo_screenheight())
    window_x = 800
    window_y = 600

    posX = (screen_x // 2) - (window_x // 2)
    posY = (screen_y // 2) - (window_y // 2)

    geo = "{}x{}+{}+{}".format(window_x, window_y, posX, posY)
```
Et là il n'y a plus qu'à faire comme tout à l'heure mainapp.geometry(eo) et là comme je suis passé par une variable intermédiaire, je mets juste GEO d'accord c'était pour être sûr d'avoir le bon formatage que je trouve plus libre d'avoir fait comme ça et là normalement si j'ai pas fait de bêtise je devrais avoir quelque chose de correct.
```py
#coding:utf-8

import tkinter
#from tkinter import *

mainapp = tkinter.Tk()
mainapp.title("Mon premier programme fenêtré")

screen_x = int(mainapp.winfo_screenwidth())
screen_y = int(mainapp.winfo_screenheight())
window_x = 800
window_y = 600

posX = (screen_x // 2) - (window_x // 2)
posY = (screen_y // 2) - (window_y // 2)

geo = "{}x{}+{}+{}".format(window_x, window_y, posX, posY)
mainapp.geometry(geo)

mainapp.mainloop()
```
```powershell
    >python main.py
```
Voilà et voyez si vous regardez bien, la fenêtre n'est pas tout à fait centré parce ce que vous voyez qu'en haut la hauteur est un peu plus grandes qu'en bas et à gauche c'est un tout petit peu plus grand sur la gauche que la droite donc je pense aussi qu'il y a une bordure sur les fenêtres ici et donc que il doit prendre certains pixels comme ça de trop dans certains cas par rapport à la taille comme en haut il doit prendre je pense le bandeau en plus.

Donc je pense qu'en modifiant un peu, en faisant une petite fonction qui recalcule ça proprement, il y aurait moyen de centrer je pense que c'est juste un souci de ça, c'est au niveau de la bordure de la fenêtre qui n'est pas prise forcément bien en compte comme la voyez qu'il y a une bordure quand même suffisamment grandes contrairement à Windows 10 par exemple où vous pouvez avoir des bordures vraiment toutes fines.

Donc je pense que le souci qui fait que du coup ce n'est pas tout à fait centré parce que la fenêtre en fait elle est un petit peu trop décalé à droite et un tout petit peu trop décalé vers le bas donc il y a moyen je pense en bidouillant de trouver quelque chose pour l'avoir mais en tout cas, c'est à peu près centré donc on arrive à voir quelque chose d'assez correct même si ce n'est pas encore une fois 100 pourcent correct ce qui est un peu embêtant parce que ce calcul là.
```py
    posX = (screen_x // 2) - (window_x // 2)
    posY = (screen_y // 2) - (window_y // 2)
```
Mathématiquement parlant, il centre parfaitement normalement une fenêtre sur une surface donc ça ne devrait pas poser de soucis mais vous verez d'ailleurs dans d'autres choses par exemple la SDL si on veux faire des graphismes en 2D ça va parfaitement centrer une surface sur une autre, il y a aucun souci, ce calcul est parfaitement correct.

Donc en tout cas c'est ce que je voulais vous montrer parce que je sais qu'il y en a qui voudront pas centrer leurs fenêtres sur leur écran donc vous savez comment faire, c'est ce calcul mathématiques donc il n'y a pas besoin de faire Math Sup pour savoir le faire c'est vraiment très simple.

Vous divisé par 2 la taille que vous voulez donc votre écran et vous soustrayez évidemment la taille de votre fenêtre divisée par 2 aussi, c'est important parce que si ne vous faites pas cette partie là du calcul vous considérez que votre fenêtre ne fait qu'un pixel, que c'est juste un point et c'est pas une surface qui est un peu embêtant.

Moi je vais vous laisser avec ça, c'était vraiment la vidéo d'intro donc un petit peu longue quand même parce qu'il y a pas mal d'autres choses à vous présenter sur tout cette partie là mais on n'a pas vu grand chose, c'était histoire de créer votre première fenêtre, de la configuration avec des paramètres comme sa taille, le redimensionnement ou spécifier des dimensions par défaut et notamment de positionner par exemple au centre de l'écran.

Et pour la suite on commencera à voir des choses un peu plus intéressantes, on va commencer à utiliser les premiers widgets, faire nos premières actions et on verra tout ça dans la suite des vidéos.

A bientôt tout le monde pour la prochaine séance