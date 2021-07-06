# [21. Premiers widgets](https://www.youtube.com/watch?v=JdSqSKrPhSw)

Bonjour à tous, bienvenue sur cette formation en langage python, on est sur la 21e séance donc ça commence à faire pas mal. 

La dernière fois nous avions fait une petite introduction à tkinter. Je vous avais expliqué que c'était un module qui allait nous permettre de faire des interfaces graphiques fenêtré donc ce qu'on appelle des GUI et qu'on pourrait utiliser tout un ensemble d'éléments pour présenter ses fameuses interfaces fenêtrées. 

Alors on va commencer dans cette vidéo à voir quelques éléments qui sont des éléments basiques et je vous montre ça directement avec de la mise en pratique sur notre code. 
```py
#coding:utf-8

import tkinter

app = tkinter 

app = tkinter.Tk()
app.mainloop()
```
Alors j'ai repris évidemment un code minimal comme on avait vu la dernière fois pour tkinter. Je fais toujours ce type d'importation pour bien montrer que les différentes classes que j'utilise au niveau des constructeurs appartient bien à tkinter parce que sinon vous ne l'auriez pas forcément vu et donc ici comme ça pour vous c'est clair. 

Je fais un petit rappel de début donc moi je l'ai appelé "app" parce que c'est application en elle-même et ensuite on fait une boucle infinie pour éviter que la fenêtre se referme. 

Alors on peut déjà commencer à exécuter ça.
```powershell
    >python main.py
```
On va déjà commencer par exécuter ça pour voir si tout est bon. Nous avions obtenu ce genre de chose avec une petite fenêtre comme ça à l'exécution. 

On va donc démarrer avec la découverte du premier widget. Le widget c'est le terme que l'on emploie pour toutes les petites choses que l'on va devoir mettre dans nos fenêtres, ça peut être un affichage de texte, ça peut être un bouton, ça peut être un champ de saisie, ça pourrait être une liste, ça pourrait être un menu, toutes ces choses-là, même une image, vous pourriez les utiliser à l'aide de widgets. 

Et les widgets sont vraiment très très simple à utiliser, ils ont à peu près le même fonctionnement c'est-à-dire qu'ils ont un nom, ils ont chacun un certain nombre d'attributs que l'on va pouvoir utiliser avec donc c'est un petit peu comme les propriétés sur lequel vous allez pouvoir travailler. 

Il n'y a pas mal de chose assez commune à ces différents widgets.

Alors n'hésitez pas allez voir la playlist annexe sur les tutoriels de python, il y a peut être des vidéos annexes et complémentaires sur tkinter et pas mal de petites choses. On en parlera un petit peu plus tard au cours de cette vidéo. 

Donc on a créé notre application et avant la ligne pour la boucle principale, mainloop(), on va pouvoir faire tout un tas de choses. On va découvrir du coup notre premier type de widget qui est vraiment le plus simple dans ce genre de cas. C'est le widget qui va permettre d'afficher quelque chose, c'est ce qu'on appelle un label, c'est donc comme une étiquette, d'accord c'est un affichage tout simplement de texte. On va commencer par exemple par ce genre de choses, on pourrait également utiliser ce genre de widget pour afficher une image mais nous comme on débute vraiment, on va le faire pour afficher du texte. 

Alors le principe il est toujours le même pour un widget, il faut savoir que ça va se présenter de cette manière là. Avant de parler du label, on va montrer un petit peu le format. Vous allez avoir le nom de la variable <nom_variable> qui est égal au nom du widget <nom_widget> qui va prendre entre parenthèse le <widget_parent> c'est-à-dire le widget dans lequel il va être inséré en fait tout simplement et ensuite il prendra tout un nombre de paramètres, il pourra en prendre éventuellement plusieurs, séparés par des virgules à chaque fois.
```py
"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""
```
Donc ça c'est un peu le format qu'on aura pour nos widgets donc on va commencer par faire le premier tout simplement. Je vais l'appeler tout simplement, par exemple vous pouvez mettre le nom de variable que vous voulez bien évidemment mais je vous recommande de mettre des noms explicites. 

Comme on va créer un appel, je ne vais pas m'amuser à l'appeler comme ceci, label.
```py
    #coding:utf-8

    import tkinter

    app = tkinter.Tk()
    
    label

    app.mainloop()
```
label, sinon ne serait pas forcément à quoi ça correspond donc moi par exemple je vais mettre label_welcome.
```py
    #coding:utf-8

    import tkinter

    app = tkinter.Tk()
    
    label_welcome = 

    app.mainloop()
```
Ce genre de chose, je marque ensuite tkinter parce que je travaille sur ce module là par rapport à l'import que j'ai fait comme ça, import tkinter.
```py
    #coding:utf-8

    import tkinter

    app = tkinter.Tk()
    
    label_welcome = tkinter

    app.mainloop()
```
Et ensuite je vais utiliser la classe Label tout simplement.
```py
    #coding:utf-8

    import tkinter

    app = tkinter.Tk()
    
    label_welcome = tkinter.Label

    app.mainloop()
```
tkinter.Label(), ça c'est le widget qu'on va appeler.

Alors le widget parent dans lequel il va être inséré c'est la fenêtre principale, c'est notre petite boîte quand a ouvert tout à l'heure c'est-à-dire notre interface "app" donc je vais mettre app qui sera le widget parent.
```py
    #coding:utf-8

    import tkinter

    app = tkinter.Tk()
    
    label_welcome = tkinter.Label(app, )

    app.mainloop()
```
app, est donc le widget de parents, il faut bien le relier à ça et ensuite à l'intérieur, on va avoir un certain nombre de paramètres. Le paramètre le plus simple qui est vraiment la base pour les Label(), c'est l'attribut text. Vous mettez un = et ensuite vous pouvez mettre l'attribut que vous voulez.
```py
    #coding:utf-8

    import tkinter

    app = tkinter.Tk()
    
    label_welcome = tkinter.Label(app, text="")

    app.mainloop()
```
Donc comme moi c'était un message de Bienvenue pour Welcome, et bien je vais mettre ceci.
```py
#coding:utf-8

import tkinter

app = tkinter.Tk()

label_welcome = tkinter.Label(app, text="Bienvenue à tous !")

app.mainloop()
```  
Là si j'exicute mon programme, on voit que le Label n'est pas affiché.
```powershell
    >python main.py
```
Effectivement, on a créé le label, on a dit qu'il était relié donc c'est-à-dire qu'il faisait partie intégrante de notre application "app" mais par contre on n'a pas précisé comment l'afficher. 

Ici tkinter ou en tout cas python, il ne sait pas comment il va devoir gérer son Label là donc on va utiliser pour cela une certaine manipulation avec notamment le positionnement. 

Alors il y a plusieurs types de positionnement des widgets avec tkinter, on a le positionnement pour faire des divisions si vous voulez de l'espace en 2 à chaque fois donc nous c'est celui-là qu'on va utiliser. 

Et nous, on va par exemple s'occuper de faire ça, label_welcome, On travaille sur notre wiget "label_welcome" Et on va utiliser une méthode qui est pack().
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

label_welcome = tkinter.Label(app, text="Bienvenue à tous !")

label_welcome.pack()
app.mainloop()
```
Donc en fait pack() va séparer l'interface en 2 donc elle va réserver un espace pour elle et ensuite éventuellement si elle a besoin d'un espace libre.

Il a comme il n'y a qu'un seul élément, vous allez voir que l'espace va être complètement pris pour le label, voilà.
```powershell
    >python main.py
```
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

msg = "Bienvenue à tous !"
label_welcome = tkinter.Label(app, text=msg)

label_welcome.pack()
app.mainloop()
```
```powershell
    >python main.py
```
Je peux sans problème faire ce genre de choses. 

Donc ça je ne reviens pas dessus, c'est des choses que vous êtes censé avoir compris et avoir acquis avec tout ce que vous avez vu jusqu à présent avec le langage python, si vous ne l'avez pas encore compris, il faudra peut-être revenir sur les anciennes vidéos, histoire que tout cela soit clair avant de continuer. 

Bien évidemment vous pouvez faire pas mal de manipulations. 

Grosso modo voilà comment ça fonctionne. 

On va revenir sur l'exemple d'avant, voilà. 
```py
    #coding:utf-8

    """
    <nom_variable> = <nom_widget>(<widget_parent>, <params>...)
    """

    import tkinter

    app = tkinter.Tk()

    label_welcome = tkinter.Label(app, text="Bienvenue à tous !")

    label_welcome.pack()
    app.mainloop()
```
Alors il y a des petites choses à savoir, au niveau de manipulation basique sur les widgets, c'est que vous avez un certain nombre de méthodes. C'est pareil, il y aura un tutoriel sur toutes les méthodes communes que vous allez pouvoir retrouver sur tous les widgets c'est-à-dire qu'il fonctionne sur tous et on va en voir quelques-unes parce qu'elles ont vraiment leur intérêt. 

Alors la première c'est vraiment la méthode qui va permettre, pas forcément la méthode mais la manière qui va vous permettre d'accéder aux paramètres d'un widget donc pour le faire je vais l'afficher dans un print(). On peut bien évidemment faire un print() car comme vous le voyez ma ligne de commande est ouverte, ça va pouvoir m'afficher des choses. 

Donc ce que je peux faire déjà, c'est print(label_welcome[""]).
```py
    #coding:utf-8

    """
    <nom_variable> = <nom_widget>(<widget_parent>, <params>...)
    """

    import tkinter

    app = tkinter.Tk()

    label_welcome = tkinter.Label(app, text="Bienvenue à tous !")
    
    print(label_welcome[""])

    label_welcome.pack()
    app.mainloop()
```
Et ici le nom de paramètre, par exemple c'est "text" que je veux, et là je peux faire ça.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

label_welcome = tkinter.Label(app, text="Bienvenue à tous !")

print(label_welcome["text"])

label_welcome.pack()
app.mainloop()
```
```powershell
    >python main.py
    Bienvenue à tous !
```
Vous voyez qu'il m'ouvre bien mon interface, pas de souci. 

Par contre ici, dans le terminal il m'a bien affiché "Bienvenue à tous !"quelque chose , alors il y a une manière plus rapide que de procéder par ça parce que ça vous l'avez déjà vu avant, c'est le système par rapport au dictionnaire qui permettait comme ça d'accéder à un élément parce que c'est un dictionnaire en réalité par rapport à ça,  vous pouvez également utiliser une méthode c'est-à-dire que vous pouvez très bien faire print(label_welcome.cget("text")) avec bien évidemment le nom du paramètre à l'intérieur "text". 
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

label_welcome = tkinter.Label(app, text="Bienvenue à tous !")

print(label_welcome.cget("text"))

label_welcome.pack()
app.mainloop()
```
```powershell
    >python main.py
    Bienvenue à tous !
``` 
Voyez en passant par la méthode ça revient exactement au même ou bien vous utilisez les accès en lecture il exerça comme on le ferais sur un dictionnaire tel qu'on l'a vu dans les séances précédentes. 

Si on veut modifier cet élément `label_walcome.cget("text")`, c'est pareil. On a la méthode par dictionnaire en faisant simplement `label_welcome["text"]` qui est égal au nouveau message `label_welcome["text"] = "Le nouveau message"`. On ne va pas réafficher le texte pour ne pas compliquer la vidéo sachant que c'est le début sur tkinter.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

label_welcome = tkinter.Label(app, text="Bienvenue à tous !")
label_welcome["text"] = "Le nouveau message"

label_welcome.pack()
app.mainloop()
```
Donc en bref, vous pouvez modifier de cette manière là comme on le fait avec des dictionnaire en standard.
```py
    label_welcome["text"] = "Le nouveau message"
```
Ou alors vous pouvez utiliser la méthode qui s'appelle configure() et entre parenthèses, vous mettez "text" et vous allez avoir votre nouvel élément.
```py
    label_welcome.configure("text")
```
Vous pouvez faire ce genre de chose.
```py
    label_welcome.configure(text="Nouveau message")
```
On a également un alias qui est config() mais c'est exactement la même chose.
```py
    label_welcome.config(text="Nouveau message")
```
C'est la même méthode mais c'est simplement que c'est écrit de manière raccourcie donc ça c'est vraiment une autre possibilitée.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

label_welcome = tkinter.Label(app, text="Bienvenue à tous !")

label_welcome.config(text="Nouveau message")

label_welcome.pack()
app.mainloop()
```
```powershell
    >python main.py
``` 
Donc vous voyez qu'il a prit en compte mon nouveau message donc à priori le changement a bien fonctionné.

Donc cget() pour lire une élement ou alors toujours par le système des dictionnaires, ça fonctionne.

config() ou configure() pour modifier un paramètre d'un widget ou alors pareil la méthode par la méthode par dictionnaire pour le faire donc ça ce sont vraiment qu'on pourra faire sur tout les widgets qu'on verra sur cette vidéo et sur les vidéos à venir. Je vous en parle maintenant comme ça vous savez et vous pourrez l'utiliser dans les vidéos suivantes également.

Donc on va rester sur des choses comme ça.
```py
    #coding:utf-8

    """
    <nom_variable> = <nom_widget>(<widget_parent>, <params>...)
    """

    import tkinter

    app = tkinter.Tk()

    label_welcome = tkinter.Label(app, text="Bienvenue à tous !")

    label_welcome.pack()
    app.mainloop()
```
Rester sur quelques choses comme ça histoire de ne pas trop mélanger parce que je ne veux vraiment rien oublier parce que c'est la première vidéo sur les widgets donc je veux faire le tour de tout ce qui est important à savoir pour commencer.

Alors au niveau des méthodes, est-ce que je peux parler d'autres méthodes, je pense que je vais m'arrêter au niveau des méthodes communes pour le moment, pour les autres, on verra ça plus tard mais je résreve cela pour le tutoriel.

Le positionnement c'est pareil, ce serra suffisant pour le moment avec la méthode pack() qui suffit à placer l'élément tel quel.

Et on va voir éventuellement d'autres éléments. 

Alors ce qui peut servir également au niveau du texte, je vous montre un autre paramètre qui est le paramètre justify qui va vous permettre aussi de gérer l'alignement.
```py
    label_welcome = tkinter.Label(app, justify="Bienvenue à tous !")
```
À voir mais comme pack() aligne d'une certaine manière le widget, vous ne le verrai peut-être pas certainement à l'affichage mais sachez qu'il peut y avoir d'autres éléments.

Même je ne vais pas vous montrer tous les attributs parce qu'il y a beaucoup d'attributs qu'on retrouve dans plusieurs types de widget donc pareil, vous avez un tuto ou vous aurez un tuto avec tous ces attribut-là qui sont un petit peu les attributs standard de tous les widgets, surtout ceux qui ont un intérêt ici.
```py
    label_welcome = tkinter.Label(app, -->justify="Bienvenue à tous !")
```
Donc le plus intéressant au niveau label, c'est simplement text.
```py
    label_welcome = tkinter.Label(app, text)
```
On va passer à un autre, vous voyez que les labels c'est assez simple à utiliser. Il s'agit de message. Messages est un petit peu différent du label, il va permettre de gérer un affichage donc pareil ça peut être sur plusieurs lignes. 

Donc en fait il va suffire de faire je vois ça, et il va prendre le paramètre text, et donc je vais juste changer label par message. Donc ici, je vais changer le nom pour une question de lisibilité.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

message_welcome = tkinter.Message(app, text="Bienvenue tout le monde")

message_welcome.pack()
app.mainloop()
```
Et là je vais exécuter, vous voyez que le message se met sur plusieurs lignes.
```powershell
    >python main.py
```
Alors il y a une taille par défaut qui est définie, pareil c'est des chose qu'on peut après modifier mais là vous voyez que du coup même si je n'ai pas fait de retour à la ligne, lui il la fait.

Alors j'en ai pas parler mais encore une fois, vous pouvez mettre évidemment les anti slashs N pour faire des retours à la ligne, tout à fait possible.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

message_welcome = tkinter.Message(app, text="Bienvenue tout \nle monde")

message_welcome.pack()
app.mainloop()
```
```powershell
    >python main.py
```
D'ailleurs si je fais ça, je vois comment qu'il va me couper le texte après le tout, il faudrait peut-être que je mette plutôt là comme ça dépend de la largeur.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

message_welcome = tkinter.Message(app, text="Bonjour\n tout le monde")

message_welcome.pack()
app.mainloop()
```
```powershell
    >python main.py
```
je sais pas s'il va couper 2 fois.

On va mettre un très long message.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

message_welcome = tkinter.Message(app, text="Bonjour tout le monde et bienvenue sur la chaîne FormationVidéo")

message_welcome.pack()
app.mainloop()
```
```powershell
    >python main.py
```
Voyez qu'il me met tout sur plusieurs lignes comme ça donc il fait une espèce de cassure, voyez que ça fait une espèce de petite boîte comme ça, ça fait une espèce de carré.

Par contre si j'avais eu un label donc je change tout pour que ce soit clair au niveau des modifications parce que je vais assez vite.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

label_welcome = tkinter.Label(app, text="Bonjour tout le monde et bienvenue sur la chaîne FormationVidéo")

label_welcome.pack()
app.mainloop()
```
```powershell
    >python main.py
```
Quand je modifie là vous voyez qu'il prend vraiment tout sur une ligne d'accord sauf si vous lui demandiez bien sûr vous-même des retours et donc vraiment une petite différence mais ça j'ai vraiment fait pour encore une fois le contenu sur plusieurs lignes de texte.

En revanche label c'est une étiquette comme ça, afficher tel quel en brut sauf si bien évidemment vous précisez vous-même manuellement des retours à la ligne.

Donc voilà 2 petits pour les widget, très simple à utiliser.

Au niveau du message, il n'y a pas forcément d'attribut particulier parce que c'est un peu comme pour Label(), c'est juste ça un peu différent mais ça fonctionne un peu pareil donc je vais passer assez vite là dessus.

On va en voir un autre, pareil on va voir que la base puisqu'il va servira surtout plus tard quand on pourra par exemple faire de la validation de données ou autre. Vous vous bien que dans cette vidéo, on ne va pas tout voir parce que on commence tout juste à voir le module tkinter donc on attaque vraiment les bases et on va aller sur des choses beaucoup plus compliquées par la suite.

Et là on va du coup voir un autre widget qui est encore une fois le widget pour de la saisie.

Donc on créer une variable entry_name et ensuite je le met dans app et on va avoir un certain nombre d'éléments également. Donc le plus simple à avoir c'est par défaut on laisse comme ça, voilà. 
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

entry_name = tkinter.Entry(app)

entry_name.pack()
app.mainloop()
```
```powershell
    >python main.py
```
Donc là vous avez l'impression qu'il n'y a pas de différence par contre si j'agrandit, on est bien dans un champ de saisie.


Par défaut, il fait une taille de 20 mais en fait c'est le nombre de caractères en réaliser d'accord, ça fait que vous allez pouvoir avoir ça.
```txt
    +----------------------------------+
    |aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa|
    +----------------------------------+
```
Donc c'est en fait le nombre de caractères en réalié qu'il peut accepter, que vous pouvez mettre dedans mais au niveau de l'affichage d'accord, au niveau du rendu visuel ici la largeur fait 20.

Donc voilà à ce niveau là.

On peut évidemment la changer avec cet élément là, width.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

entry_name = tkinter.Entry(app, width=45)

entry_name.pack()
app.mainloop()
```
```powershell
    >python main.py

    +---------------------------------------------------------------+
    |aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa|
    +---------------------------------------------------------------+
```
Je peux mettre 45 par exemple et là évidemment vous voyez que le champ est beaucoup plus grand. Je ne sais pas si vous voyez très bien sur la vidéo parce que comme c'est pas forcément zoomer donc si vous voulez le champ commence ici (au début) donc on voit bien que le curseur change et il s'arrête donc là (après 45 caractères). Il est beaucoup plus grand.

Vous pouvez clairement voir que c'est blanc alors que l'interface ici c'est un peu plus gris.

Donc vraiment vous pouvez du coup modifier cette largeur-là avec l'attribut width.

On peut également ... admettons par exemple plus tard, vous voulez utiliser un champ pour mettre un mot de passe ou un champ qui doit être caché, vous pouvez utiliser l'attribut show="" et choisir par quoi vous remplacez la saisie.
```py
    entry_name = tkinter.Entry(app, show="*")
```
C'est vrai que si c'est un mot de passe, vous utiliserez assez régulièrement des fameuses étoiles donc les astérisques du coup on va faire ça.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

entry_name = tkinter.Entry(app, show="*")

entry_name.pack()
app.mainloop()
```
```powershell
    >python main.py

    +---------------------------------------------------------------+
    |**********************************************************.....|
    +---------------------------------------------------------------+
```
Du texte remplacé par des astérisques d'accord donc ça c'est sympa.

On pourrait le mettre par n'importe quoi honnêtement ça pourrait être par ça "o". C'est vraiment quelque chose qui fonctionne voyez comme ça ... qui va changer ce que vous saisissez donc là je peux appuyer sur n'importe quel touche de mon clavier, il me met que des o.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

entry_name = tkinter.Entry(app, show="o")

entry_name.pack()
app.mainloop()
```
```powershell
    >python main.py

    +---------------------------------------------------------------+
    |oooooooooooooooooooooooooooooooooooooooooooooooooooooooooo.....|
    +---------------------------------------------------------------+
```
Donc c'est vraiment vous qui choisissez avec cet attribut-là. C'est plutôt pratique, c'est quelque chose qui servira surtout quand on verra vraiment de la saisie de données importantes avec vérification tout ça, ça peut avoir son intérêt.

Et un autre élément aussi puisqu'il faut savoir que ce champ peut avoir une petite partie particularité en fait, c'est que quand je fait Bonjour et que je sélectionne 'sans copier', en fait quand je fais ça, on va enregistrer la sélection dans le presse-papier mais si vous voulez désactiver au niveau du programme cette option-là, vous pouvez le faire si vous voulez en utilisant alors je crois que c'est exportselection et je crois que c'est un booléen donc il faut mettre à 0, voilà.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

entry_name = tkinter.Entry(app, exportselection=0)

entry_name.pack()
app.mainloop()
```
```powershell
    >python main.py
```
Et là du coup ici vous empêcherait justement l'enregistrement, le fait que la sélection se mette dans le presse-papiers d'accord au niveau de votre programme donc pour certains cas ça peut éventuellement être utile donc sachez qu'il y a cette attribut qui peut servir voilà.

Grosso modo par défaut vous pouvez mettre comme ceci, ça mais un champ à 20.
```py
    #coding:utf-8

    """
    <nom_variable> = <nom_widget>(<widget_parent>, <params>...)
    """

    import tkinter

    app = tkinter.Tk()

    entry_name = tkinter.Entry(app)

    entry_name.pack()
    app.mainloop()
```
Ben il n'y a pas de problème donc je reviendrai dessus plus tard dans la formation puisque ça servira pas mal de petites choses mais là pour le moment c'était pour savoir que vous pouvez utiliser ce widget-là pour avoir un champ de saisie et notamment après on apprendra à travailler avec des variables là-dedans, entry_name = tkinter.Entry(app), même faire une classe pour nos fenêtres tout ça mais c'est des choses un peu plus compliquées qu'on verra dans les séances suivantes évidemment.

Qu'est-ce que je peux vous montrer comme autre Widget sur cette vidéo parce c'est vraiment la première, et bien je vais vous montrer les boutons, ben oui le widget bouton ... je pense qu'on terminera avec celui-là ... puisque bah ce widget fait partie des choses assez basiques en plus, il y a des choses intéressantes à voir.

Alors le widget de bouton, on va l'appeler button_quit et on va faire un widget button "tkinter.Button()" donc c'est bien le terme anglais, toujours dans app.
```py
    button_name = tkinter.Button(app)
```
Vous voyez les constructeurs sont vraiment construit de la même manière, le widget pareil et ensuite tous les attributs qu'on veut à la suite.
```py
    button_name = tkinter.Button(app, ...)
```
Et ici, il y a attribut évidemment important qui est le texte d'accord donc je peux mettre par exemple le texte que je veux.
```py
    button_name = tkinter.Button(app, text="OK")
```
Alors je n'oublie pas de changer ma variable et on va exécuter tout ça.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

button_name = tkinter.Button(app, text="OK"   )

button_name.pack()
app.mainloop()
```
```powershell
    >python main.py
    
    +----+
    | OK |
    +----+
```
Vous voyez bien que ça affiche un bouton d'accord donc ici bien évidemment ça ne fait rien. Vous verez plus tard on parlera des évènements, comment on peut justement écouter en fait toutes les actions qui peuvent se passer sur une interface pour voir comment réagir en fonction, toutes ces choses-là on verra comment le faire.

Voilà qu'est-ce que je peux vous donner comme attribut aussi intéressant, l'attribut with éventuellement ça peut être pas mal.

L'attribut with, ça peut être un nombre de lettre ou un nombre de pixels c'est vous qui voyez d'accord.

Moi je vais mettre par exemple 25 ce genre de chose.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

app = tkinter.Tk()

button_name = tkinter.Button(app, text="OK", width=25)

button_name.pack()
app.mainloop()
```
```powershell
    >python main.py
```
Exécuté voilà et là le bouton, il est un peu plus gros donc là vous devriez bien voir dans la vidéo parce qu'il y a une petite ombre qui se met comme ça et quand je clique en plus ça change.
```txt
    +------------------------+
    |           OK           |
    +------------------------+
```
Donc là on a bien un bouton différent.

On a évidemment l'attribut pour la hauteur, voilà ça c'est pour le nombre de ligne d'accord donc si je met 5, ça va mettre l'équivalent de 5 lignes de texte.

Voyez qu'on a un gros bouton, bouton cliquable.

Qu'est-ce qui peut être aussi intéressant en attributs de base en tout cas ... on l'attribut de commande, on terminera par celui là de toute manière parce que après les autres c'est des attributs encore une fois qui sont assez commun.

Et l'attribut qui va permettre d'exécuter une petite fonction donc de manière simple c'est-à-dire si je fais une fonction par exemple comme ça.
```py
    def hello():
        print("Hello sur le terminal !")
```
Je vais utiliser commande et là vous mettez simplement le nom de votre petite fonction donc hello, pas parenthèse rien du tout juste le nom de la fonction.
```py
#coding:utf-8

"""
<nom_variable> = <nom_widget>(<widget_parent>, <params>...)
"""

import tkinter

def hello():
    print("Hello sur le terminal !")

app = tkinter.Tk()

button_quit = tkinter.Button(app, text="OK", command=hello)

button_quit.pack()
app.mainloop()
```
```powershell
    >python main.py
    
    +----+
    | OK |      ->      Hello sur le terminal !
    +----+
```
Chaque fois que je fais cliquer regardez ce qui s'affiche dans le terminal ... mon message qui s'affiche donc chaque fois que je clique, ça m'affiche ça donc c'est assez simpliste parce que voyez qu'on a pas mit de paramètres ou autre, on verra bien évidemment des choses beaucoup plus complexe parce qu'on peut faire des choses quand même un peu mieux que ça.

Mais ça déjà c'est une bonne base c'est-à-dire que vous pouvez avoir une petite fonction toute simple qui fait ce genre de chose. On pourrait avoir un enregistrement parce que vous voyez que là on peut évidemment même si vous utilisez une interface ... si vous utilisez en fait l'interface fenetré vous pouvez avoir un terminal également, surtout si la personne lance le programme depuis un terminal pour avoir de logs ou quelque chose comme ça.

C'est souvent utile d'ailleurs dans tous les gros programme quand vous les lancez en fait via le terminal par exemple quand il y a une erreur ou qu'un logiciel crash ce genre de choses, vous pouvez éventuellement des fois retrouvé des log soit dans des fichiers soit directement depuis le terminal.

Donc fait-le, pour ceux qui sont sur gnu Linux ou sur Mac OS, lancé par exemple je sais pas moi je prends l'exemple de Firefox le navigateur au lieu de lancer Firefox depuis votre menu, vous lancer votre terminal et vous tapez Firefox et vous faites entrer, ça va lancer firefox.
Ça va lancer Firefox dans votre navigateur, et vous verrez que le terminal va vous afficher des choses. 

Si vous avez un crash de votre navigateur ou autre, vous allez avoir des messages qui s'affichent. 

Sachez le même sur le travail des fois avec des interfaces graphiques, le terminal peut avoir son utilité. 

Ça peut être utile d'afficher les choses dans le terminal aussi, pour afficher des informations, des logs, des messages, ce genre de chose. 

C'est souvent utilisé même tout le temps, ce n'est pas parce que on est en graphique qu'on ne fait absolument rien du tout en console. 

Il y a beaucoup de gens qui pensent que dès qu'on connaît les interfaces graphiques que plus personne ne fait des programmes en console mais c'est vrai dans les programmes à interface graphique, il y a aussi beaucoup de choses qui sont faites pour être affiché dans la console donc il ne faut pas croire que c'est oublié, que c'est mis de côté à partir du moment où on fait des interfaces fenêtrés.

Les 2 peuvent fonctionner ensemble, ça a vraiment son utilité. 

Voilà on a vu les boutons, je pense que je ne vais pas vous en montrer plus parce qu'il y a bien évidemment d'autres widgets mais on verra un petit peu tout dans cette formation ça c'est une bonne nouvelle. 

Vous aurez en plus la playlist des tutoriels pour compléter un petit peu tout ce que vous allez voir sur ce module tkinter qui est quand même assez complet mine de rien. 

Pour quelque chose de natif dans le langage, c'est vrai qu'on peut déjà faire beaucoup de choses. Vous verrez en plus que c'est très sympa, ça permet d'avoir plein de fonctionnalités très intéressantes qu'on aura l'occasion de voir un peu dans le détail un petit peu plus tard, dans les autres séances et dans les autres vidéos. 

Je crois avoir fait tout ce que je voulais faire, je ne voulais pas vous montrer des choses trop complexes, 2 positionnement tout ça. Il y a d'autres vidéos qui vont être faites sur tkinter, ne vous en faites pas. S'il y a des choses qui n'ont pas été revue ici, c'est qu'a priori prévus dans les vidéos qui vont venir ou alors ça va être prévu dans les annexes en tutos.

Après évidemment si vous avez des questions et des commentaires vous pouvez les laisser dans les commentaires youtube sous la vidéo, il n'y a pas de souci je verrai un petit peu tout ça comme d'habitude. 

Je vous laisse avec ça, je vous dis à bientôt pour la prochaine vidéo donc ce sera la vingt-deuxième donc on avance bien sûr cette formation et en attendant n'hésitez pas à tester tout ça à vous entraîner pour voir un petit peu comment ça s'agence donc revoir un petit peu tout ça, on va avoir du budget un petit peu supplémentaire dans les prochaines vidéos et on verra surtout comment faire des interfaces de plus en plus riches avec effectivement des mises en pratique qui sont un peu plus concrète par rapport à ce que je vous ai montré qui était un petit peu simpliste. 

À bientôt tout le monde pour la prochaine vidéo.