# [24. Positionnement widgets](https://www.youtube.com/watch?v=YGeRTVaBPoc)

Bonjour tout le monde bienvenue sur la formation au langage python. 

Sur cette vidéo numéro 24, je vais vous proposer de vous montrer comment vous allez pouvoir positionner vous éléments et notamment vos widgets au niveau de votre interface histoire d'avoir quelque chose de plus présentable, de plus ergonomique par la suite. 

C'est aussi pour avoir plus de cohérence et de logique au niveau de l'organisation des différents widgets, et de l'organisation de ces différents éléments pour votre interface. 

Alors je vais vous montrer un widget assez particulier que je ne vais pas aborder avant parce que je voulais parce que je voulais attendre d'aborder avec vous le positionnement des éléments  pour le voir. 

C'est le budget qui va permettre de créer des cadres. 

Alors le widget de cadre qui est le Bridget frame va tout simplement servir à contenir d'autres widgets, c'est vraiment son rôle principal. Il peut bien évidemment car le cadre est un widget en lui-même donc il pourra en contenir d'autres. 

Donc vous pouvez mettre un cadre dans un autre cadre, et un cadre pourra contenir plusieurs widgets, des boutons, pourra contenir une SpinBox ou je ne sais quoi, bref tout un tas de widgets différents concernant tkinter. 

Alors nous allons créer notre petit cadre directement on va lui mettre un nom mainframe égal (=), et on va l'appeler tkinter.Frame(), c'est la classe qu'il va falloir utiliser pour instancier ça. On le met sur notre widget de parents qui est notre fenêtre donc app ici.
```py
    #coding:utf-8
    import tkinter

    # Création et paramètrage de la fenêtre
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Positionnement widgets")

    # Widgets...
    mainframe = tkinter.Frame(app, ...

    # Boucle principale
    app.mainloop()
```
Alors ici Frame(app, … et on peut lui mettre un certain nombre d'éléments, on peut lui mettre une largeur, une hauteur si ça vous dit, vous pouvez toujours faire ça pour spécifier quelque chose. On va les mettre comme ça ça permettra déjà de voir, et puis d'avoir quelque chose de beaucoup plus précis. Par exemple width=300 et pour la hauteur, height=200, voilà ce genre de chose.
```py
    #coding:utf-8
    import tkinter

    # Création et paramètrage de la fenêtre
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Positionnement widgets")

    # Widgets...
    mainframe = tkinter.Frame(app, ...

    # Boucle principale
    app.mainloop()
```
On va ensuite gérer notre Frame donc je vais mettre pack() pour le moment et ça devrait être bon.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
mainframe = tkinter.Frame(app, width=300, height=200)
mainframe.pack()

# Boucle principale
app.mainloop()
```
Donc on fait python main.py et là forcément vous n'allez rien avoir parce qu'on n'a pas forcément montré d'éléments mais bon je vais peut être ajouter un borderwidth=1, on pourra peut être mieux la voir.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
mainframe = tkinter.Frame(app, width=300, height=200, borderwidth=1)
mainframe.pack()

# Boucle principale
app.mainloop()
```
Non apparemment on ne voit pas mieux mais on verra tout à l'heure lorsqu'on aura des éléments, ce n'est pas bien grave. 

Donc au niveau de ça on va pouvoir travailler directement avec notre cadre et placer des éléments dedans. L'intérêt des Frame justement c'est de gérer vos widgets par groupe d'accord, ça peut être sympa de gérer ça par groupe, vous allez donc stocker cela dans des cadres. 

Donc vos widgets ne seront plus liés à la fenêtre donc qui serait l'élément parent mais l'élément parent deviendra ici "mainframe". Je le montrerai de toute façon après. 

Et après ce sera plus facile de repositionner des groupes d'éléments parce que une fois que les éléments eux-mêmes sont biens, en déplaçant des groupes c'est beaucoup plus optimal pour tout ce qui est positionnement est organisé comme ça vos différents widgets. 

Donc on va créer un bouton, on va faire btn = tkinter.Button(app, text="BIENVENUE") On va rester sur des choses simples. On va faire un gros bouton de bienvenue. 
```py
    #coding:utf-8
    import tkinter

    # Création et paramètrage de la fenêtre
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Positionnement widgets")

    # Widgets...
    mainframe = tkinter.Frame(app, width=300, height=200, borderwidth=1)
    mainframe.pack()
    
    btn = tkinter.Button(app, text="BIENVENUE")

    # Boucle principale
    app.mainloop()
```
Sauf que là, `tkinter.Button(app <--`, il ne faut pas app comme je l'ai dit parce que ça va vous faire tout simplement … alors je vais l'afficher ce serait pas mal, btn.pack().
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
mainframe = tkinter.Frame(app, width=300, height=200, borderwidth=1)
mainframe.pack()

btn = tkinter.Button(app, text="BIENVENUE")
btn.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
    +---------------------+
    |                     |
    |   +-------------+   |
    |   | BIENVENUE   |   |
    |   +-------------+   |
    |                     |
    +---------------------+
```
Alors les éléments comme vous le voyez ne vont pas être reliés ensemble, vous voyez que le bouton de bienvenue se met là parce que notre frame se met en arrière-plan, on ne la voit pas mais elle est là donc ça c'est important de voir quel a été mise … ici je suis étonné que ma petite bordure ne se met pas, borderwidth.

Ce n'est pas grave c'est ma petite bordure ne se voit pas, on va garder borderwidth à la valeur 1 mais on verra après. 

Donc on va placer on va placer le bouton non pas sur la fenêtre principale directement mais dans le cadre que nous avons créé ici, app > mainframe. 
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
mainframe = tkinter.Frame(app, width=300, height=200, borderwidth=1)
mainframe.pack()

btn = tkinter.Button(mainframe, text="BIENVENUE")
btn.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
    +---------------------+
    |   +-------------+   |
    |   | BIENVENUE   |   |
    |   +-------------+   |
    |                     |
    |                     |
    +---------------------+
```
Et là évidemment tout va changer parce que vous voyez que le groupe est présent ici au-dessus donc c'est beaucoup plus pratique. Après j'aurais pu mettre une couleur de fond si je voulais pour la différencier mais je ne vais pas forcément m'embêter avec ça. Les couleurs on ne va pas s'amuser à mettre du rouge partout ou je ne sais pas quoi donc on va mettre des choses assez simples ici au niveau des cadres. 

Vous pouvez encore une fois en mettre plusieurs gérer ça de différentes manières. 

Alors je m'arrêterai là pour tout ce qui concerne les cadres parce que ce sont des choses à faire à un niveau un peu plus avancé mais il va falloir que vous vous entraîniez. De toute façon encore une fois il n'y a pas de secret, il faudra que vous testiez ça, comment vous pouvez organiser vos éléments, créer des groupes et après comprendre un petit peu comment ça se passe au niveau des positionnements. 

Mais il faut connaître ce type de frame parce qu'il a tout son intérêt.

Un petit bonus qui va également vous servir ce que vous allez pouvoir nommer votre cadre, ça peut se retrouver dans pas mal d'interface si par exemple vous voulez mettre un titre dans votre cadre plutôt que de devoir créer un label pour pouvoir le faire … même si ça peut se faire on peut très bien procéder comme ça, mettre le label et par-dessous mettre le cadre qui fonctionne mais ça ferait du coup 2 éléments différents … vous pourrez créer ce qu'on appelle à cadre nommé. 

Pour créer un cadre nommé, c'est simple suffit de remplacer Frame par LabelFrame d'accord, c'est ça le nom de la classe. Et l'élément par contre qui va changer, c'est que nous avons un titre qui est contenu dans l'option text="".
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
mainframe = tkinter.LabelFrame(app, text="Titre du cadre", width=300, height=200, borderwidth=1)
mainframe.pack()

btn = tkinter.Button(mainframe, text="BIENVENUE")
btn.pack()

# Boucle principale
app.mainloop()
```
"Titre du cadre", vous mettrez ce que vous voulez et là vous allez voir que vous allez avoir un titre.
```py
    >python main.py
    
    +---Titre du cadre----+
    |   +-------------+   |
    |   | BIENVENUE   |   |
    |   +-------------+   |
    +---------------------+
```
Alors là on voit un petit peu ce qui se passe avec le bouton qui est effectivement dedans.

Alors par contre ce que je peux faire c'est qu'on vire le btn du "mainframe" vers le "app". 
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
mainframe = tkinter.LabelFrame(app, text="Titre du cadre", width=300, height=200, borderwidth=1)
mainframe.pack()

btn = tkinter.Button(app, text="BIENVENUE")
btn.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
    +---Titre du cadre----+
    |                     |
    |                     |
    |                     |
    +---------------------+
        +-------------+
        | BIENVENUE   |
        +-------------+
```
Voilà donc du coup on sent rend bien compte puisque c'est un une un cadre nommé vous voyez qu'il met une espèce d'entourage donc du coup on se rend bien compte de là où il est.

Donc vous voyez comme ça les mesure et vous voyez que le bouton se met vraiment pile en dessous.

Ca peut être pratique du coup, on peut gérer ça de plusieurs manières.

L'avantage aussi c'est que quand vous allez vouloir positionner vos éléments et ça on le verra, et bien au lieu par exemple de faire des étirements ou des modifications en temps réel des interfaces notamment par exemple quand vous allez vouloir changer la taille comme ça de vos interfaces (étirer la fenêtre) plutôt que ça ne se gère que sur la fenêtre principale, ce qui ne serait pas forcément pratique. 

Imaginer je sais pas moi 15 widgets à gérer sur une seule fenêtre, un seul panneau, donc un seul cadre, ce serait juste la galère.

Voilà du coup vous allez pouvoir gérer indépendamment vos widget par exemple dans ce cadre-là, du cadre principal et d'autres cadres que vous aurez éventuellement ce sera du coup pour vous-même beaucoup plus pratique et vous pourrez gérer comme ça l'état et les dimensions, les redimensions automatiques pour prévoir par exemple le faites ou quelqu'un viendrait maximiser l'interface puis après la réduire où changer sa taille, ça ne l'oublier pas, il faut le prévoir.

Et le seul moyen d'apprendre pour ça c'est de tester, encore une fois il n'y a pas de Secret.

Inspirez vous également des logiciels que vous utilisez habituellement d'accord, utilisez votre navigateur internet, un logiciel peu importe lequel en fait et regardez comment il redimensionne les éléments, comment il gère en fait le redimensionnement, le fait de maximiser une fenêtre tout ça.

C'est en vous inspirant de ce qui se fait déjà donc que vous saurez comment procéder et quels sont les bonnes méthodes à avoir au niveau justement de la gestion des options de vos widgets.

Voilà pour tout ce qui est cadre, je vais rester là dessus pour le moment.

On va changer donc je dis ça, je passe pour le moment. De toute façon c'était pas non plus le sujet de la vidéo mais c'est important de savoir car c'est ce qui va servir au positionnement donc pour le moment on passera à côté mais ça nous servira pour plus tard.

Concernant le positionnement jusqu'à présent on faisait toujours la même chose ... je vais remettre le petit bouton dans mainframe.
```py
    #coding:utf-8
    import tkinter

    # Création et paramètrage de la fenêtre
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Positionnement widgets")

    # Widgets...
    mainframe = tkinter.LabelFrame(app, text="Titre du cadre", width=300, height=200, borderwidth=1)
    mainframe.pack()

    btn = tkinter.Button(mainframe, text="BIENVENUE")
    btn.pack()

    # Boucle principale
    app.mainloop()
```
Voilà du coup height, width et borderwidth plus besoin puisque c'est géré sur un autre type donc il va prendre automatiquement les dimensions du bouton, voilà.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
mainframe = tkinter.LabelFrame(app, text="Titre du cadre")
mainframe.pack()

btn = tkinter.Button(mainframe, text="BIENVENUE")
btn.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
    +---Titre du cadre----+
    |   +-------------+   |
    |   | BIENVENUE   |   |
    |   +-------------+   |
    +---------------------+
```
Voilà vous voyez, ça prend les dimensions du bouton.

Si je veux encore une fois changer le bouton, on peut s'amuser à le faire, histoire d'avoir quelque chose de plus clair voilà.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
mainframe = tkinter.LabelFrame(app, text="Titre du cadre")
mainframe.pack()

btn = tkinter.Button(mainframe, text="BIENVENUE", width=200, height=100)
btn.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
    +---Titre du cadre----+
    |   +-------------+   |
    |   | BIENVENUE   |   |
    |   +-------------+   |
    +---------------------+
```
Là c'est du petit bricolage, ça n'a rien d'obligatoire, voilà.

Comme ça vous voyez là que le bouton est très très gros puisqu'il occupé évidemment toute la partie-là.

Donc nous, on ne va pas forcément s'occuper de ça voilà. On va rester sur un exemple comme ça.
```py
    #coding:utf-8
    import tkinter

    # Création et paramètrage de la fenêtre
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Positionnement widgets")

    # Widgets...
    mainframe = tkinter.LabelFrame(app, text="Titre du cadre")
    mainframe.pack()

    btn = tkinter.Button(mainframe, text="BIENVENUE")
    btn.pack()

    # Boucle principale
    app.mainloop()
```
Donc là nous avions un bouton et le problème c'est que nous avons toujours jusqu'à présent utilisé ce genre de méthodes puisque vous voyez on faisait simplement ça, on utilisait la méthode pack() sur le widget pour le positionner sans forcément comprendre à quoi ça servait.

Jusqu'à présent je ne vous pas forcément expliqué. Je vous avez dit qu'on reviendrait dessus par la suite et je vous en ai pas dit plus en fait tout simplement.

Je ne vous vraiment rien dit de plus là dessus concernant ce type de fonctionnement.

Alors on va reprendre notre exemple mais sans les valeurs en pixels. On va rester sur un truc sympa et pas trop compliqué pour le moment. Donc onn va rester sur un bouton standard d'accord comme ceci parce que ça va rajouter du code inutillement.
```py
    #coding:utf-8
    import tkinter

    # Création et paramètrage de la fenêtre
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Positionnement widgets")

    # Widgets...
    btn = tkinter.Button(app, text="BIENVENUE")
    btn.pack()

    # Boucle principale
    app.mainloop()
```
Et on va positionner ça de manière différente.

Vous avez 3 cas possibles, très simple.

Le cas qu'on connaît et qu'on a vu jusqu'à présent c'est la méthode pack().

La méthode pack(), elle va permettre de placer les éléments .. alors plus facilement c'est la plus simple je trouve en tout cas à utiliser mais qui sera forcément un peu plus limité dans les possibilités d'accord.

Vous allez pouvoir déjà d'une principale manière gérer les tirages d'un widget ou les tirages des éléments donc ça ça peut être pas mal à gérer.

Alors nous on va mettre plusieurs éléments parce que ça va être quand même mieux d'en avoir plusieurs voilà (label, ent).

label et ent, je mets vraiment des trucs comme ça au pif c'est tout.

On reste comme ça et pour ne pas oublier, je rappelle qu'il faut à chaque fois une utilisation par type pack() et là vous allez voir ce qu'il va se passer.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

btn.pack()
ent.pack()
label.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
        +-------------+
        | BIENVENUE   |
        +-------------+
    +-----------------------+
    |                       |
    +-----------------------+
            Un label
```
Regardez bien voilà comment ça se passe.

Alors on peut voir que j'ai créé en premier lieu Label que j'ai créé ensuite le champ de texte donc champ de saisi et après j'ai créé le bouton.

Pourtant on voit que l'affichage le label est arrivé en dernier et le bouton est passé en premier.

Simplement parce qu'au niveau des méthodes ici pour pack().
```py
    btn.pack()
    ent.pack()
    label.pack()
```
C'est le bouton que j'ai appelé en premier d'accord, ensuite la saisie et ensuite le Label.

Donc pour avoir ce que j'ai fait à la construction, il faut les mettre évidemment dans le même ordre tout simplement parce que c'est là que va se passer l'affichage d'accord.

C'est là qu'on va faire le positionnement de nos éléments et donc ça va du coup se mettre au niveau de l'interface graphique. C'est là que ça évidemment toute son importance.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack()
ent.pack()
btn.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
           Un label
    +-----------------------+
    |                       |
    +-----------------------+
        +-------------+
        | BIENVENUE   |
        +-------------+
```
Donc on a bien le label ici, le champ de saisis, le petit bouton de bienvenue tout va bien dans le meilleur des monde.

Par défaut du coup vous vous rendez compte que là dans la méthode pack(), je n'ai passé aucun argument, aucune option et par défaut vous constatez par vous-même, je n'ai pas forcément besoin d'en faire des explications pendant des heures que les éléments se mettent les uns en dessous des autres d'accord.

Donc ils se mettent les uns à la suite des autres en fait de cette manière.

Alors on n'est pas obligé de faire ça d'accord, on pourrait procéder autrement d'accord il y a vraiment plusieurs manières de procéder.

Ce système permet donc de mettre les éléments d'une certaine manière avec un argument, en réalité quand vous mettez pack() comme ça sans rien c'est comme si vous faisiez ceci.
```py
    label.pack(side="top")
```
Je peux vous montrer de toute façon donc c'est bien de voir avec des exemples et vous voyez que ça procède à la même chose.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack(side="top")
ent.pack(side="top")
btn.pack(side="top")

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
           Un label
    +-----------------------+
    |                       |
    +-----------------------+
        +-------------+
        | BIENVENUE   |
        +-------------+
```
Et vous voyez que ça procède à la même chose donc ça c'est par défaut.

Le comportement par défaut de la méthode pack(), si vous ne lui spécifié rien c'est qu'elle va considérer que vous lui demandez ça, de mettre side="top" c'est-à-dire vous mettez le premier élément qui était donné en haut, l'autre vous le mettez le plus haut possible et comme là on avait déjà un label et bien la saisie va se mettre le plus en haut juste après l'élément qui a déjà été placée.

Et maintenant on veut placer le bouton le plus en haut sauf qu'il y a déjà 2 espaces qui sont occupés donc on va le mettre par dessus c'est pour ça que les éléments vont se mettre comme ça de haut en bas.

On peut faire évidemment l'inverse sans problème, ça c'est important.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack(side="bottom")
ent.pack(side="bottom")
btn.pack(side="bottom")

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
           Un label
    +-----------------------+
    |                       |
    +-----------------------+
        +-------------+
        | BIENVENUE   |
        +-------------+
```
voilà vous voyez du coup Label se met le plus en bas, c'est le premier qu'on a dit de mettre en bas.

Ensuite la saisie et ensuite le bouton et cetera.

Vous avez également "right" pour droite.

Vous avez "left" pour gauche.

Donc ça c'est pareil, je passe très vite puisque c'est juste le nom qui change mais c'est exactement le même fonctionnement.

Donc ça c'est l'utilisation de l'option side qui est du coup pratique, vous voyez vous pouvez positionner un élément en haut à gauche en bas à droite et cetera très rapidement soit par défaut, sans rien mettre ça va se passer en haut sinon vous pouvez spécifier une valeur particulière qui va du coup placer les éléments là où vous voulez donc c'est du coup très rapide.

On a également et ça c'est important une autre option ... donc je vais laisser comme ça par défaut ce que ça m'allait très bien qui est "expand=" 

"expand" c'est un booléen donc ça prend la valeur 0 ou 1 d'accord suivant que le widget est étendue ou non.

Je vais mettre un expand=1.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack()
ent.pack()
btn.pack(expand=1)

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
           Un label
    +-----------------------+
    |                       |
    +-----------------------+
            ...
            ...
        +-------------+
        | BIENVENUE   |
        +-------------+
```
Et là vous voyez que il est complètement étendue.

Qu'est-ce que ça veut dire expand ? donc ça ne veut pas dire que le widget en lui-même, il est agrandi, genre le bouton est énorme. Non ça veut simplement dire que le widget occupe un espace de tout ce qu'il reste c'est-à-dire que eux deux ont été placés (label et entry) et mon dernier widget occupe l'espace restant, complet de toute l'interface.

Je peux coupler son problème encore une fois rappelez vous ce sont des options dont vous pouvez les mettre dans l'ordre que vous voulez avec cet argument là par exemple d'accord.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack()
ent.pack()
btn.pack(expand=1, side="left")

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
           Un label
    +-----------------------+
    |                       |
    +-----------------------+
            ...
            ...
        +-------------+
        | BIENVENUE   |
        +-------------+
```
Alors là on ne voit pas de différence parce que par défaut l'expansion se fait sur tout l'espace donc si on veut vraiment pouvoir placer les éléments comme il faut, c'est là que ça pourrait être intéressant d'utiliser un cadre justement d'accord.

Donc ça c'est à voir aussi, vous verrez que ce sont certains éléments qu'en vous faites comme ça un expand, expand considère justement qu'il occupe tout l'espace donc il faudra souvent utiliser par exemple un cadre pour pouvoir par exemple déplacer l'élément à gauche d'accord mais ça n'a aucun intérêt de dire tu occupe tout l'espace mais par contre tu te met à gauche d'accord, c'est des choses qui se contredisent un petit peu.

Donc attention aussi au niveau des options mais vous pouvez de toute façon coupler des options qui fonctionnent ensemble et qui sont compatibles.

Alors ce qui peut être pas mal aussi utile c'est l'option fill alors je vais la mettre "y".
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack()
ent.pack()
btn.pack(side="left", fill="y")

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
                  Un label
                +-----------+
    +------+    |           |    
    |      |    +-----------+
    |      |
    |Bienv.|
    |      |
    |      |
    +------+
```

Au niveau résultat ça ne va pas être forcément très joli voilà ça va être très moche et là on comprend que fill c'est simplement pour dire de remplir donc remplir par Y.

Ben rappelez vous y pour ceux qui ont compris le système de coordonnées en informatique de manière générale.

Les X c'est l'abscisse donc c'est tout ce qui est horizontal, les Y c'est l'ordonnée c'est tout ce qui est vertical donc de dire tu remplis tout sur la coordonnée Y, ça veut dire du coup tu remplis de là (à gauche).

Et vous voyez que Label et Entry respectent bien le positionnement des éléments précédents, il n'a pas écrasé dessus.

Il s'est mis à gauche à partir du moment où lui commence donc en fait l'espace pour boutons c'est toute la fenêtre mais là on lui a dit par contre tu te mets que à gauche grâce au side="left".

Si je veux vraiment occupé un espace complet, on peut très bien faire ça fill="y" mais ça va être un peu bizarre aussi vous vous en doutez bien, on aura ça.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack()
ent.pack()
btn.pack(fill="y")

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
           Un label
    +-----------------------+
    |                       |
    +-----------------------+
        +-------------+
        | BIENVENUE   |
        +-------------+
```
Et là du coup pareil fill="y" ça ne va pas parce qu'on lui a pas préciser d'endroit particulier s'étaller d'accord par rapport à ça.

On peut par contre utiliser "both", ça peut être pas mal aussi ce genre d'arguments qui lui par contre va occuper l'élément.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack()
ent.pack()
btn.pack(fill="both")

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
           Un label
        +--------------+
        |              |    
        +--------------+
+----------------------------------+
|           BIENVENUE              |
+----------------------------------+
```
"both" en fait il va par rapport à son espace occupé tous l'espace qu'il y a.

Voyez que le bouton se met dans toute la largeur.

Voilà on peut gérer comme ça différents types, on a "none" mais là c'est vraiment pour ne pas affecter par défaut.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack()
ent.pack()
btn.pack(fill="none")

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
           Un label
    +-----------------------+
    |                       |
    +-----------------------+
        +-------------+
        | BIENVENUE   |
        +-------------+
```
Ce genre de choses donc en fait fill="" va fonctionner sur l'absysse, l'ordonnée donc X et Y où carrément sur tout l'ensemble disponible donc ici "both" ça c'est intéressant.

"expand" c'est ce qu'on avait vu pour l'espace donc ce n'est pas pour forcément le widget, c'est l'espace.

Si vous voulez agrandir le widget, il faut modifier sa largeur, sa hauteur souvenez vous.

Et après vous avez également pour tout ce qui est bordure, si vous voulez gérer des bordures et ça pour ceux qui font du web notamment avec du CSS serons de quoi je parle, vous allez pouvoir gérer les marges intérieures et les marges extérieur de vos widgets.

Pour cela donc toujours dans pack() d'accord ça peut se faire dans pack().

Vous allez pouvoir par exemple gérer avec padx=10 et pady=5 donc on n'est pas obligé de mettre les 2, on peut mettre un seul ou aucun ou les 2 c'est toujours des options.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack()
ent.pack()
btn.pack(padx=10, pady=5)

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
           Un label
    +-----------------------+
    |                       |
    +-----------------------+
        +-------------+
        | BIENVENUE   |
        +-------------+
```
Et vous allez pouvoir gérer comme ça, ici alors padx c'est pour les marges extérieures d'accord c'est-à-dire ce qui va être en dehors du bouton, on va avoir une marge.

Alors là on se rend pas compte sur les côtés parce que on a beaucoup beaucoup d'espace, j'ai fait une interface très très grande.

D'ailleurs on pourrait peut-être éviter de faire ça pour le coup exceptionnellement.
```py
    app.geometry("640x480")
```
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack()
ent.pack()
btn.pack(padx=100, pady=5)

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    +------------------------------+
    |           Un label           |
    |       +---------------+      |
    |       |               |      |    
    |       +---------------+      |
    |          +----------+        |
    |          |BIENVENUE |        |
    |          +----------+        |
    +------------------------------+
```
Voilà on se rendra mieux compte. Vous voyez comment ça se passe. Les éléments là ont gardé leur place par contre on lui a dit ici tu mets des marges de 100 pixels donc en X à l'horizontale à l'extérieur du widget donc 100 pixels à droite du bouton et 100 pixels à gauche.

Et là tu met une marge de 5 pixels en y donc du coup au-dessus de toi à l'extérieur et en dessous de toi à l'extérieur aussi.

Si on veut faire des marges internes, il suffit de rajouter un i pour internal d'accord c'est des marges internes.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack()
ent.pack()
btn.pack(ipadx=100, ipady=5)

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    +------------------------------+
    |           Un label           |
    |       +---------------+      |
    |       |               |      |
    |-------+---------------+------|
    |                              |
    |           BIENVENUE          |
    |                              |
    +------------------------------+
```
Des marges internes et là il se passe ceci d'accord.

Donc là c'est le bouton que vous allez agrandir puisque c'est les marges internes donc c'est vraiment à l'intérieur, c'est le widget du coup qu'on étire grâce à ça.

Donc c'est vraiment pratique aussi si vous voulez une interface assez particulière.

Ici je remets ce que j'avais tout à l'heure c'est-à-dire geometry et ipadx=100 et ipady=5.

Et là on va avoir un bouton forcémen plus grand que tout à l'heure.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.pack()
ent.pack()
btn.pack(ipadx=100, ipady=50)

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py

               Un label           
           +---------------+      
           |               |
           +---------------+
    
    +------------------------------+
    |                              |
    |           BIENVENUE          |
    |                              |
    +------------------------------+
```

Un bouton beaucoup plus gros que tout à l'heure voilà. Le bouton il est énorme.

Donc on peut gérer comme ça les tailles aussi avec ce genre de chose mais là c'est une bordure d'accord c'est pas que notre bouton, il fait réellement fait cette taille là, cette dimension là, c'est vraiment qu'on lui a dit tu applique des marges mais ici des marges intérieures en x et en y.

C'est des choses à savoir manipuler également avec le pack().

Voilà grosso modo tout ce qu'il y à retenir, il y a fill, il y a tout ce qui est marge et tout ce qui est side. 

C'est très simple à utiliser mais forcément plus limité, vous ne pouvez pas placer les éléments exactement où vous voulez donc ça c'est un petit cas un peu particulier.

Si vous voulez maintenant faire des choses un peu plus précis, on va pouvoir également organiser nos éléments sous forme de gris, imaginez un tableau à 2 dimensions d'accord avec des lignes, des colonnes, vous allez pouvoir spécifier et organiser vos éléments de cette manière donc ça le système c'est pareil, le seul moyen de bien tout comprendre d'avoir compris toutes les spécificités c'est de pratiquer parce que je pourrais pas tout vous expliquer en vidéo sinon j'en ai pour des heures et des heures mais il va falloir donc gérer toute cette partie là avec un système d'éléments.

Partez du principe que vous avez donc des lignes, des colonnes et que par défaut la première colonne que vous aurez par exemple dans un tableau sera à 0 et la première ligne sera 0.

Donc au lieu d'utilisé comme on a fait ici pack(), on va utiliser grid().

/!\ Alors petite note, n'utilisez pas, évitez en tout cas d'utiliser grid en même temps que pack(). Par exemple si vous faites ça.
```py
    label.grid()
    ent.pack()
    btn.pack()
```
Et puis que dérrière vous faites des pack(), vous allez avoir des gros soucis.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.grid()
ent.pack()
btn.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 998, in <module>
        ent.pack()
      File "C:...", line 2387, in pack_configure
        self.tk.call(
    _tkinter.TclError: cannot use geometry manager pack inside . which already has slaves managed by grid
```
De gros soucis, tout simplement parce que là l'interpréteur il ne va pas savoir comment positionner éléments, je lui ai demandez des grilles, des packs et cetera et même s'il arrive à charger au final votre programme ça peut tourner très très longtemps parce qu'il n'arrivera pas à s'organiser parce qu'il y a des choses qui entrent en conflit, qui se contredisent donc ça n'ira pas donc éviter de mélanger comme ça les choses.

Par contre on va pouvoir travailler avec grid.

grid, je vais lui dire par exemple tu prends ça.
```py
    label.grid(row=0)
```
Alors par défaut ligne est à 0 donc on pourrait même le laisser comme ça.
```py
    label.grid()
```
Mais moi, j'ai toujours l'habitude de spécifier les éléments même par défaut comme ça on peut les lire, comme ça on les comprend, on sait là et pas qu'il n'existe pas, ce genre de chose.
```py
    label.grid(row=0, column=0)
    ent.grid()
    btn.grid()
```
grid(), grid(), grid() et ... 
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.grid(row=0, column=0)
ent.grid()
btn.grid()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    +------------------------------+
    |  Un label                    |
    |+---------------+             |
    ||               |             |    
    |+---------------+             |
    |+----------+                  |
    ||BIENVENUE |                  |    
    |+----------+                  |
    +------------------------------+
```
Donc là ça s'affiche donc ça se met tout à 0.

Donc là imaginez un tableau qui a un élément, ça c'est la case (0,0) d'accord.
```txt
     0
    +-+-+-+
   0| | | |
    +-+-+-+
    | | | |
    +-+-+-+
```
ligne 0, colonne 0 donc tout a été mis dedans parce que ça je vous rappel que par défaut c'est comme si j'avais mis ça, d'accord.
```py
    label.grid(row=0, column=0)
    ent.grid(row=0, column=0)
    btn.grid(row=0, column=0)
```
Après je peux faire la même chose mais on changeant ça va être intéressant donc là c'est toujours la même ligne mais je mets en colonne 2.
```py
    ent.grid(row=0, column=1)
```
Toujours la même ligne je mets en colonne 3.
```py
    btn.grid(row=0, column=2)
```
Et bien oui c'est décalé c'est comme pour les tableaux en programmation, la première case du tableau c'est l'indice 0 et pas 1, et là on a les élément qui se mettent côte à côte.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.grid(row=0, column=0)
ent.grid(row=0, column=1)
btn.grid(row=0, column=2)

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    +------------------------------+
    |Un label +------+ +--------+  |
    |         |      | |Bienven.|  |
    |         +------+ +--------+  |
    +------------------------------+
```
Et là on a les éléments qui se mettent côte à côte c'est logique, on voit que ça n'occupe pas tout la largeur de l'interface qui fait 640 pixels fois 480 et c'est pas non plus centré.

Ca c'est pareil, c'est des choses à gérer l'alignement, les tirages, c'est des choses qu'on a vu, que vous avez vu même dans cette vidéo donc n'hésitez pas encore une fois à mêler un peu toutes les options, là j'ai mis très peu d'options au niveau de ça, au niveau de Label, j'ai rien mit pratiquement en fait juste du texte donc n'hésitez pas à tester d'autres options pour avoir quelque chose d'un peu plus grand, un peu plus propre mais du coup vous pouvez gérer ça comme un tableau et c'est du coup beaucoup plus pratique au niveau de l'organisation de vos éléments.

C'est plus précis en fait, vous allez pouvoir gérer vraiment ça case par case, de manière précise.

On peut même récupérer un élément sur plusieurs colonnes, plusieurs lignes, pareil comme on retrouve par exemple en HTML (colspan) pour ceux qui font du web, parmi vous, vous pouvez gérer ça avec les options "columnspam" par exemple.

Donc attention de ne pas vous trompé entre les différents langages de programmation, langage de présentation et cetera donc faites attention à ce niveau là.

Et columnspam, admettons qu'il démarre à la colonne 0 mais il va prendre l'équivalent de 2 colonnes.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.grid(row=0, column=0, columnspan=2)
ent.grid(row=0, column=2)
btn.grid(row=0, column=3)

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    +------------------------------+
    |+------+ +--------+           |
    ||      | |Bienven.|           |
    |+------+ +--------+           |
    +------------------------------+
```
Et là, on va avoir un petit changement voilà.

Donc là vous ne voyez pas de différence pour vous parce que évidemment, on a pas spécifié des tailles précises pour les cellules du tableau mais en fait, on a le Label qui occupe 2 cases donc la colonne 0 et 1.

On va avoir ici la saisie qui occupe la 3e case donc le 3e colonne et le bouton qui occupe la dernière voilà donc on peut gérer ça de cette manière.

Avec columnspam, vous vous doutez bien qu'il y a aussi le "rowspan", d'accord, je peux très bien faire ça.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.grid(row=0, column=0, columnspan=2, rowspan=3)
ent.grid(row=0, column=2)
btn.grid(row=0, column=3)

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    +------------------------------+
    |+------+ +--------+           |
    ||      | |Bienven.|           |
    |+------+ +--------+           |
    +------------------------------+
```
Pareil columnspan, rowspan c'est des choses à connaître, ça peut vous servir aussi.

Par défaut c'est évidemment égal à 1 parce que ça occupera qu'une seule cellule.

On peut également gérer les marges, on peut faire padx=15 et pady=50 par exemple, ça évidemment ça fonctionne d'accord.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.grid(padx=15, pady=50)
ent.grid()
btn.grid()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
    
        Un label
        
           
    +-----------------+
    |                 |    
    +-----------------+
        +----------+
        |BIENVENUE |
        +----------+
```
Donc là, ça se met différemment donc ça peut être géré comme ça.

Donc là on gère ça d'une certaine manière donc ça je rappelle tout ça est en fait dans la même cellule.

Voyez ici, tout est dans la cellule (0,0) et simplement qu'ici comme j'ai mis des marges extérieures et bien du coup autour du Label, on a une espèce de carré comme ça qui se forme.
```txt
    +-----------------------+
    |                       |                     
    |                       |                       
    |        Label          |                 
    |                       |
    |                       |
    +-----------------------+
```
Voilà ça c'est quelque chose à savoir aussi, ça peut être utile et un dernier élément aussi qui peux être intéressant comme option c'est l'option sticky.

sticky, elle va permettre de jouer en fait sur les orientations, c'est-à-dire que vous allez pouvoir placer par exemple l'élément vers le haut donc en utilisant notamment des coordonnées donc ça va être là coordonnées Nord donc attention comme c'est des versions anglaises, pas française. Je vais vous le noter ici.
```py
    """
    n = nord
    s = sud
    e = est
    w = ouest
    """
```
Evidemment n pour nord, s pour sud je pense que nous apprend rien d'accord et le W par contre c'est l'ouest donc attention à ce niveau-là.

Pour ceux qui ne sauraient pas l'Est c'est à droite et l'ouest c'est à gauche OK, nord-sud haut-bas pas de souci à ce niveau-là.

Donc là pareil, vous pouvez placer éventuellement les éléments en faisant, j'en sais rien, nord-est par exemple.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
label = tkinter.Label(app, text="Un label")
ent = tkinter.Entry(app)
btn = tkinter.Button(app, text="BIENVENUE")

label.grid(sticky="ne")
ent.grid()
btn.grid()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
    
                Un label <-- ne
    +-----------------+
    |                 |    
    +-----------------+
        +----------+
        |BIENVENUE |
        +----------+
```
Et du coup voyez par rapport à la cellule où on est et bien il a été placé ici au nord-est donc en haut à droite OK.

Label, il pourrait être placé également au sud-est et là ce serait bizarre de toute façon, comme il vient après les autres voilà on ne verra pas de différence ce qui est normal puisqu'il est avant les autres champs.

Mais imaginez voilà des cellules où vous aurez de grosses marges, vous pouvez vraiment positionné comme ça les choses dans les coins des cellules, sur les côtés parce que vous pouvez simplement mettre ça.
```py
    sticky="w"
```
"w" pour dire tu te mets juste à gauche et "e" à droite et cetera d'accord donc sticky est plutôt sympa comme option au niveau des grilles donc ça peut servir à faire des choses assez évolué.

Là donc ça c'était pour les grilles dons ne vous en faites pas si c'est pas assez clair parce qu'il y a beaucoup de choses.

On fera des exercices. Il y aura des exercices là-dessus pour tout ce qui est tkinter, positionnement d'éléments pour faire des interfaces un peu plus sophistiqué donc on le verra donc ne vous en faites pas vous aurez l'occasion de pratiquer plus en détail de manière plus concrète.

Je vais terminer donc ce petit bonus même si on l'utilise beaucoup moins souvent mais ça peut être utile dans très très très petit, un placement vraiment on va dire millimètre par millimètre donc c'est limite au pixel pour vos widget qui est notamment la méthode place().

place() donc je peux utiliser cette méthode alors je vais juste le faire avec un seul élément pour terminer cette vidéo parce que je ne voudrais pas qu'elle soit trop long non plus voilà comme ceci et on va utiliser la méthode place().
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
btn = tkinter.Button(app, text="BIENVENUE")
btn.place()

# Boucle principale
app.mainloop()
```
place(), ça veut dire simplement de placer, placer un élément mais là c'est pas le placer au nord, au sud, machin, comme ça. On peut vraiment préciser des valeurs exactes.
```powershell
    >python main.py
```
Par défaut donc si je vous mets place(), vous voyez qu'il n'y a rien, on peut donc préciser x=10, y=10 pourquoi pas.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
btn = tkinter.Button(app, text="BIENVENUE")
btn.place(x=10, y=10)

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    (0,0)
        +----------+
        |BIENVENUE |
        +----------+
```
Voilà donc le point d'indice 0, 0 en fait au niveau de l'interface est celui tout en haut à gauche de la fenêtre donc ici "x" qu'est-ce qu'il fait ? x égale 10 ça veut dire que tu t'éclate de 10 pixels vers la droite puisque je rappelle que "x" c'est l'horizontal et "y" égal 10 c'est-à-dire que tu décalé de 10 pixels vers le bas donc du coup ça devient le point ici en haut à gauche du widget qui est le point de coordonnées à prendre en compte d'accord.
```txt
        |
        v
     -->+----------+
        |BIENVENUE |
        +----------+
```
C'est toujours là que ça commence pour un label ce serait pareil, ce serait le point en haut à gauche du widget Label. Pour n'importe quel widget toute façon ça fonctionnerait comme ça.

Donc là admettons que je veux le laisser à la même hauteur mais que je veux le décalé comme ça bien à droite ... et bien je dois agrandir ici "x" donc au lieu de mettre juste 10 je peux mettre par exemple 500.
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("640x480")
app.title("Positionnement widgets")

# Widgets...
btn = tkinter.Button(app, text="BIENVENUE")
btn.place(x=500, y=10)

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    (0,0)
                                        +----------+
                                        |BIENVENUE |
                                        +----------+
```
Là vous voyez l'élément est carrément décalé sur la droite parce que là on a en fait 500 pixels ici sur cette partie là.
```txt
    >python main.py
    (0,0)
                    500 pixels          +----------+
    <---------------------------------->|BIENVENUE |
                                        +----------+
```
On peut plus ou moins dire que ça fonctionne comme des marges extérieures d'une certaine manière mais en fait c'est surtout qu'on place à l'élément à des coordonnées précises.

Là l'élément le bouton il est placé en coordonée 500 et 10 d'accord 500 pour x et 10 pour y donc c'est précis.

On peut faire bien sûr des coordonnées relatives mais ça, j'en parle pas plus que ça voilà c'est par rapport à d'autres éléments donc vous ne verrez pas il résultat de toute façon dont vous avez réel comme ceci relx et rely d'accord pour tout ce qui est coordonné relative mais je m'attarde pas dessus non plus.
```py
    btn.place(elx, rely)
```
Vous n'utiliserait pas beaucoup place(), vous n'en n'aurais pas forcément besoin. J'en parle parce qu'il faut le connaître parce qu'il y a 3 principaux qui sont vraiment à connaître :
```py
    pack(), place() et grid() 
```
Voilà c'est à savoir en tout cas, savoir qu'ils existent, que vous pouvez l'utiliser mais privilégié en tout cas tout ce qui est pack().

pack() quand vous voulez faire un placement facile et assez simple.

Et si vous voyez que c'est trop limité, ben vous utilisez grid() mais n'utilisez qu'un seul des 2 d'accord ne mélangez pas tout.

Essayez d'utiliser un petit peu le même type pour pas avoir de soucis et privilégiez l'utilisation de cadres évidemment ce sera plus facile de manipuler des groupes comme ça vous aurez quelque chose de propre voilà voilà.

Je pense avoir tout dit au niveau de cette vidéo donc moi je vais vous laisser avec ça, encore une fois si vous avez des questions n'hésitez pas à les poser parce que c'est pas forcément évident.

Je peux comprendre que l'on en attaque des choses un peu plus compliqué que tout ce qu'on a vu précédemment parce qu'on utilise toutes les notions que vous avez vu en python jusqu aujourd'hui et en plus voilà on attaque l'interface graphique avec d'autres méthodes on découvre plein de trucs des paramètres tout ça et ça peut faire beaucoup.

Ca fait beaucoup beaucoup d'informations à assimiler d'un coup donc si vous avez des questions par rapport à ça ou des choses que vous ne comprenez pas, n'ésitez pas à me demander en commentaire et je vous répondrai avec plaisir.

A bientôt tout le monde pour la prochaine vidéo sur le langage python