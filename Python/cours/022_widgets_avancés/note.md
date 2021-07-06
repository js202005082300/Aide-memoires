# [22. Widgets avancés](https://www.youtube.com/watch?v=hfWE9dT6fgU)

Bonjour à tous bienvenue sur la formation python, dans cette vingt-deuxième séance on va poursuivre un petit peu notre apprentissage sur tkinter.

tkinter, c'est une petite bibliothèque qui va nous permettre de créer des interfaces GUI donc des interfaces graphiques avec un ensemble de widgets, et dans la séance précédente, on avait vu les boutons, on avait parlé des Label-s, tout ce qui étaient champ de saisie simple et les messages. 

Donc là on va avoir des widgets un peu plus avancé d'où le titre de cette vidéo et ce seront en tout cas les derniers widgets principaux que nous verrons, donc si vous voulez en voir un peu plus, si vous voulez en apprendre un peu plus sur les options , les méthodes disponibles et tous les nouveaux widgets qui peut y avoir, qui sont proposés avec tkinter donc je vous invite à aller consulter la doc officielle de python pour trouver tous les détails qu'il faudra par rapport à ça.

Donc ce n'est pas forcément le plus marrant à enseigner en ce qui concerne les interfaces graphiques parce que je peux que vous montrer en fait les possibilités donc le budget qui sont disponibles, ceux qui existent avec les options standards qui sont le plus utile au niveau de certains widgets. 

Et là ce sera vraiment intéressant, ce sera de mettre vraiment en pratique tout ça en faisant vos propres programmes, en testant simplement avec des valeurs différentes dans des programmes. 

Et par la suite, consulter la playlist python sur les exercices qui sont proposées sur la chaîne avec pourquoi pas les tutoriels en complément pour mettre en pratique tout ça parce que vous serez amenés dans les exercices à utiliser tkinter pour réaliser de vrais interfaces graphiques qui sont quand même un peu plus poussé que les exemples que je vous montre ici et pour lequel je passe un widget à la fois pour vous montrer grosso modo son fonctionnement.

Donc sur les widgets pour terminer donc sur cette vidéo, sur les widgets que je vais vous montrer. C'est des widgets un petit peu moins forcément utiliser que les premiers de la séance qu'on a vu en séance 21 et je vais vous montrer un petit peu tout ça.

Alors à l'intérieur, on a créé notre application toujours pareil et avant la boucle principale toujours, nous allons créer différents types de widgets.
```py
    #coding:utf-8
    import tkinter

    app = tkinter.Tk()
    
    # <--

    app.mainloop()
```
On va voir un premier widget que vous connaissez beaucoup parce que vous le voyez sur des sites web qui permet notamment de cocher une case voilà c'est le widget qui est optionnel c'est-à-dire qu'on peut cocher la case ou non ce n'est pas obligatoire donc pour ça on va créer, check_widget, d'accord je vais mettre ce nom là parce que là pour le moment, on fait des choses simples pour apprendre leur utilisation et il s'appelle … tkinter toujours pareil … Checkbutton tout simplement pas de B majuscule à button ici.
```py
    #coding:utf-8
    import tkinter

    app = tkinter.Tk()
    
    check_widget = tkinter.Checkbutton()

    app.mainloop()
```
En paramètre comme pour chaque widget de départ vous prenez l'élément parent donc moi c'est app ici et après on peut éventuellement mettre d'autres éléments.
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()

check_widget = tkinter.Checkbutton(app)

app.mainloop()
```
```powershell
    >python main.py
```
Donc par défaut si je test comme ça, vous voyez que ça m'affiche rien du tout d'accord.

On a rien et c'est normal puisque j'ai oublié d'ajouter check_widget.pack(). On a pas encore vu le positionnement des éléments pour le moment donc on se contente juste de pack() pour faire simple, voilà.
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()

check_widget = tkinter.Checkbutton(app)

check_widget.pack()
app.mainloop()
```
```powershell
    >python main.py
    
    []  ->  [v]
```
Voilà, on a notre case à cocher qui évidemment n'est pas forcément coché par défaut c'est facultatif c'est vraiment optionnel comme type de widgets voilà, fonctionnel dans son utilisation, pas optionnel dans le fait de l'apprendre en Python.

On va lui ajouter un texte parce que c'est quand même beaucoup plus clair d'accord, "Publier ?" par exemple, ce genre de chose et là ce sera évidemment un petit peu plus clair ici, voilà.
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()

check_widget = tkinter.Checkbutton(app, text="Publier ?")

check_widget.pack()
app.mainloop()
```
```powershell
    >python main.py
    
    [] Publier ?  ->  [v]
``` 
Voilà grosso modo comment ça marche.

Alors par défaut parce que vous savez que là bon visuellement on voit quelque chose par contre en terme informatique au niveau interne ici, il ne s'est pas passé grand-chose. On n'a rien fait mais par la suite, dans la formation vous apprendrez les variables tkinter donc on en parlera, je ferai une vidéo dédiée là-dessus pour voir tout simplement comment on va j'ai récupéré sous forme de variables les états en fait et les valeurs des différents widgets que l'on veut et ensuite pouvoir les exploiter parce que tout ça l'intérêt c'est de pouvoir être utilisé.

Si c'est juste pour afficher des choses et que ça ne fasse rien entre eux, que ça n'interagissent pas, et bien c'est pas une interface graphique d'accord c'est pas une interface interactive qui fonctionne avec l'utilisateur donc ça n'aurait aucun intérêt.

Donc tout ça on le verra plus tard donc c'est pour ça que la dans ce que je vais vous montrer, il n'y a pas beaucoup d'interactions puisque là c'est vraiment plus du visuel qu'autre chose, on va pas encore manipuler de variable avec tkinter.

Alors ce qu'il faut savoir par défaut, c'est que quand vous n'avez pas de cas admettons donc votre formulaire ou autre, n'importe quoi, et que vous ne cochez pas la case, sa valeur par défaut sera 0 et donc si la case elle est cochée, rappelez vous c'est une option, la valeur par défaut sera à 1.

Si jamais vous avez besoin de changer ces valeurs par défaut il y a 2 options qui sont intéressantes notamment offvalue. offvalue qui est la valeur du coup que vous aurez spécifié lorsque la case n'est pas cochée. Moi par exemple je peux très bien dire … je sais pas moi, pas 0 parce que c'est déjà le cas … par défaut je peux dire 2. Et puis là, onvalue donc ça c'est la valeur si c'est coché et là on pourrais dire par exemple 5.
```py
    #coding:utf-8
    import tkinter

    app = tkinter.Tk()

    check_widget = tkinter.Checkbutton(app, text="Publier ?", offvalue=2, onvalue=5)

    check_widget.pack()
    app.mainloop()
```
Je mets des valeurs purement arbitraire peu importe c'est pour l'exemple donc ça c'est des éléments importants qui sont en tout cas intéressant pour ce type de widget.

On peut également comme une grosse majorité des widgets sur tkinter, on peut changer la hauteur et changer la largeur, ça peut être le nombre de lignes d'affichage et la largeur du widget donc notamment au niveau du texte et cetera donc vous pouvez le faire avec height et vous mettez une valeur là vous voulez d'accord et vous pouvez faire pareil pour width, pour la largeur, pareil vous mettez ce que vous voulez, n'importe quoi.
```py
    #coding:utf-8
    import tkinter

    app = tkinter.Tk()

    check_widget = tkinter.Checkbutton(app, text="Publier ?", offvalue=2, onvalue=5, height=, width=, ...)

    check_widget.pack()
    app.mainloop()
```
Donc ça je ne les remontre pas à chaque fois parce ce qu'on a déjà vu pour les autres widgets.

Donc comme c'est des options qu'on retrouve de manière générique sur un peu l'ensemble des widgets, si vous voulez les utiliser faites des tests de votre côté et vous verrez un petit peu comment ça fonctionne sachant qu'on les a en plus vu dans la séance précédente donc là ce qui est intéressant surtout voilà c'est le "text" évidemment "offvalue" et "onvalue" si éventuellement on veut modifier les valeurs par défaut d'accord donc l'état au niveau du fait que la case ici et cochez ou non donc ça c'est des éléments qui peuvent éventuellement être intéressant.

Après vous pourrez voir également que vous pouvez spécifier le fait par exemple que la case est désactivée par défaut donc le fait qu'elle ne puisse pas être utilisée, ça peut être voilà des options utiles que je ne vous montre pas non plus parce qu'il y a beaucoup.

Encore une fois on peut retrouver tout un tas d'options par widgets donc libre à vous d'aller voir un petit peu leur fonctionnement.

Donc je vais laisser ça comme ça pour le moment.

Je vais écrire maintenant un autre type de widget qui Radio et son fonctionnement est assez similaire donc on va l'appeler … alors je vais même le mettre comme ceci. Et comme paramètres, je vais mettre text="Homme" et je laissez comme ça pour le moment.
```py
    #coding:utf-8
    import tkinter

    app = tkinter.Tk()

    check_widget = tkinter.Checkbutton(app, text="Publier ?", offvalue=2, onvalue=5)
    
    radio_widget = tkinter.Radiobutton(app, text="Homme")

    check_widget.pack()
    app.mainloop()
```
Et puis je vais en faire un autre, tkinter.Radiobutton(app, text="Femme").
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()

check_widget = tkinter.Checkbutton(app, text="Publier ?", offvalue=2, onvalue=5)

radio_widget = tkinter.Radiobutton(app, text="Homme")
radio_widget2 = tkinter.Radiobutton(app, text="Femme")

check_widget.pack()
app.mainloop()
```
```powershell
    >python main.py
```
Ce type de widget vous connaissez aussi c'est pour ça que je l'affiche rapidement mais j'ai encore oublié pack() décidément.

```py
#coding:utf-8
import tkinter

app = tkinter.Tk()

check_widget = tkinter.Checkbutton(app, text="Publier ?", offvalue=2, onvalue=5)

radio_widget = tkinter.Radiobutton(app, text="Homme")
radio_widget2 = tkinter.Radiobutton(app, text="Femme")

check_widget.pack()
radio_widget.pack()
radio_widget2.pack()
app.mainloop()
```
Et donc on est reparti.
```powershell
    >python main.py
    
    [] Publier ?
    (*) Homme
    (*) Femme
```
Voilà c'est mieux, vous avez ce type d'interface donc je rappelle cette case (Publier ?) est toujours optionnel d'accord, on peut la cocher ou non et celles-là (Homme et Femme) donc pour le moment, il se passe rien puisque vous voyez que les valeurs ici, on n'a rien spécifié même ce type de cases à cocher est obligatoire déjà on est forcément obligé de cocher mais on ne peut cocher qu'une seule des 2 d'accord donc vous pouvez très bien faire par exemple … 
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()

check_widget = tkinter.Checkbutton(app, text="Publier ?", offvalue=2, onvalue=5)

radio_widget = tkinter.Radiobutton(app, text="Homme", value = 1)
radio_widget2 = tkinter.Radiobutton(app, text="Femme", value = 1)

check_widget.pack()
radio_widget.pack()
radio_widget2.pack()
app.mainloop()
```
```powershell
    >python main.py
```
Ainsi on va pouvoir sélectionner les cases alors si vous mettez la même valeur, voyez qu'il y aura un petit souci parce qu'elles doivent avoir chacune une valeur unique, qui leur est propre donc vous pouvez par exemple dire que Homme c'est 1 et Femme c'est 0, vous mettez n'importe quel valeur peu importe, le tout c'est qu'elle n'ai pas les même valeurs.
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()

check_widget = tkinter.Checkbutton(app, text="Publier ?", offvalue=2, onvalue=5)

radio_widget = tkinter.Radiobutton(app, text="Homme", value = 1)
radio_widget2 = tkinter.Radiobutton(app, text="Femme", value = 0)

check_widget.pack()
radio_widget.pack()
radio_widget2.pack()
app.mainloop()
```
Du coup, vous pourrez changer les valeurs en fonction.
```powershell
    >python main.py
    
    [] Publier ?
    (*) Homme
    () Femme
```
Et là on pourra en sélectionner qu'une seule donc ça fonctionnera comme ça doit fonctionner.

Ca je rappel, le checkbutton pour Python, c'est une case optionnelle qui n'est pas obligatoire, on peut très bien laissé décoché par contre pour Homme/Femme, il faudra obligatoirement sélectionner une des deux cases. Ca c'est obligatoire, c'est le principe des boutons Radio, des Radiobutton.

Donc ça il faudra penser à cocher une des deux à chaque fois.

Et là encore une fois comme on ne travaille pas directement avec des variables évidemment, on ne récupère rien de manière interne donc là c'est juste visuel ce que l'on fait mais grosso modo visuellement ça marche donc on verra plus tard comment utiliser ça avec des variables pour que ce soit évidemment plus enrichis et plus interractif aussi.

Voilà pour ce type de widget, donc voyez que ça se sont des widgets qui ne sont pas forcément aussi utile que les premiers que l'on avait vu dans la vidéo précédente mais ils sont bien à savoir donc je voulais vous les prsenter là, je vais retirer ça pour faire un peu plus de vides, et on va en voir d'autres.
```py
    #coding:utf-8
    import tkinter

    app = tkinter.Tk()



    app.mainloop()
```
Il y a des widgets également pour tout ce qui est curseur, ça on en trouve beaucoup donc ça peut être pasd mal de vous les présenter également.

Alors on va faire scale_w qu'on va appeler comme ça puis égal à tkinter.Scale().
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()

scale_w = tkinter.Scale(app)

scale_w.pack()
app.mainloop()
```
```powershell
    >python main.py
    
        |#| 0
        | | ...
        | | 100
```
Donc ça donne ce genre de curseur-là qui par défaut démarre de 0 et on peut aller jusqu'à 100. C'est des choses comme ça.

Si vous avez besoin et c'est justement l'intérêt de ce type de curseur c'est-à-dire de changer la fourchette de valeurs.

Il y a également des options intéressantes à ce niveau-là et notamment from_ pour lequel il ne faut pas oublier de mettre un underscore _ parce que ça fonctionne de pair avec la fonction to, from et to, c'est pour ça qu'il ont mit un underscore pour dire que ça fonctionne avec.

On peut par exemple dire que from_=10, commence à 10 et to=100, on peut dire qu'il va jusque 100. On peut très bien faire ce genre de chose. Ca peut être utile de traiter ce type de cas.
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()

scale_w = tkinter.Scale(app, from_=10, to=100)

scale_w.pack()
app.mainloop()
```
```powershell
    >python main.py
    
        |#| 10
        | | ...
        | | 100
```
Et là on change la fourchette de valeur, voilà.

On peut également changer la Step c'est-à-dire l'étape dans laquelle on se déplace. Est-ce qu'on se déplace de 1 en 1 par défaut, de 2 en 2, de 5 en 5 ect. On peut tout changer, on pourrait même afficher des valeurs.

Voilà on peut afficher une espèce de règles gradués à coté du widget pour préciser les différentes étapes un peu prêt.

Donc vous pouvez faire tout ça si ça vous chante.

Alors ça je peux vous montrer pour la règle, tickinterval=25.
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()

scale_w = tkinter.Scale(app, from_=10, to=100, tickinterval=25)

scale_w.pack()
app.mainloop()
```
```powershell
    >python main.py
    
        |#| 10
    35  | |
    60  | | ...
    85  | |
        | | 100
```
Du coup vous pouvez vous déplacer comme ça, on démarre de 10 + 25 = 35, 60, 80 et cetera, comme ça vous pouvez voir grosso modo où est-ce que vous en êtes suivant où vous mettez le curseur donc c'est un indicateur qui peut être utile pour ce genre de cas. 

Voilà pour Scale.

Vous avez la même chose pour tout ce qui est SpinBox qu'on voir ici, spin_w, avec juste une majuscule au S et pour les paramètres c'est pareil app, from_=1, to=10.
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()

scale_w = tkinter.Scale(app, from_=10, to=100)
spin_w = tkinter.Spinbox(app, from_=1, to=10)

scale_w.pack()
spin_w.pack()
app.mainloop()
```
```powershell
    >python main.py
    
        |#| 10
        | | ...
        | | 100
    ----------------^
    1 à 10          #
    ----------------v
```
Et là vous voyez qu'on a un autre genre de widget, en dessous on a carrément un champ dans lequel on peut écrire dedans et donc comme on contrôle rien on peut bien évidemment mettre n'importe quoi comme valeur mais à partir du moment où je met n'importe quoi dès que je clique sur le curseur à droite je reviens au mini et de toute façon je ne peux pas aller plus haut que 10. Et ça c'est toujours réglé pareil. 

Donc là vous voyez qu'il y a une barre horizontale et une barre verticale mais ça on peut changer la barre vertical peut être mis de manière horizontale avec une option "oriente", l'option qui permet de le faire donc n'hésitez pas à aller voir dans la doc si vous avez besoin de le mettre dans une autre orientation, ce sera toujours pratique aussi. 

Je vais rester sur ces options là dans les options standard, évidemment il y en a plein d'autres. 

On peut spécifier plein d'autres options pour ce type de widget et donc c'était vraiment ce que je voulais vous montrer ici. 

Un petit dernier qui est pas mal utile, on le voit pas mal aussi en tout ce qui est web, ce sont les listes. Vous avez une liste d'éléments et il faut en sélectionner un, elle peut même dans certains cas avec des options en sélectionner plusieurs donc la liste box, on va faire lb = tkinter.Listbox(app), avec 1 B minuscule et on va juste faire ça.
```py
    #coding:utf-8
    import tkinter

    app = tkinter.Tk()

    lb = tkinter.Listbox(app)

    lb.pack()
    app.mainloop()
```
Et là c'est comme une liste, comme vous avez pu le voir pendant cette formation donc là on a une liste vide il faut donc ajouter ces éléments donc on va faire lb.insert().

En première position on va faire, "Windows. En valeur 2, je vais mettre "GNU/Linux" et en valeur 3, on va mettre "MacOS", voilà.
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()

lb = tkinter.Listbox(app)
lb.insert(1, "Windows")
lb.insert(2, "GNU/Linux")
lb.insert(3, "MacOS")

lb.pack()
app.mainloop()
```
Pareil, on refait et voilà le type de widget qu'on obtient.
```powershell
    >python main.py

    +-----------+
    |Windows    |
    |GNU/Linux  |
    |MacOS      |
    |           |
    +-----------+
```
Et voilà le type de widget que vous pouvez avoir, on obtient une liste comme ça et vous pouvez sélectionner des éléments. Pareil il y a des options pour pouvoir sélectionner plus d'un élément à la fois, on peut faire pas mal de choses donc n'hésitez pas à aller voir.

On peut déplacer la souris dedans bien évidemment, c'est prévu pour donc pas de souci pour de ce côté-là et pareil les valeurs que vous avez là, c'est des éléments qui pourront être récupérés dans des variables afin d'être exploité un peu plus tard. 

Donc ça valait le coup de vous montrer ce type de widget parce qu'il est pas mal utilisé aussi au niveau des interfaces donc c'était pas mal de vous montrer. 

Donc voilà je crois qu'on va s'arrêter là au niveau du widget avancé mais si vous voulez encore une fois en avoir d'autres, pareil vous avez une documentation avec plein de choses fournies. 

De widget, il peut en avoir plein. Dès demain il peut sortir de nouveau type de widget, de nouvelles choses un peu plus modernes et donc n'hésitez pas, il y a des widgets pour faire des onglets et donc pour faire pas mal de choses. 

Pour gérer différentes zones de fenêtre, vous avez également des widgets pour faire des barres de progression donc vous avez vraiment plein de type de widget.

Donc n'hésitez pas à aller voir, il y a même pour faire des arbres c'est à dire des espèces d'explorateur, faire des menus déroulants, des data list donc aller voir tout ça parce que je ne pourrais pas tout vous montrer et ça n'aurait pas beaucoup d'intérêt pour être honnête, à part peut-être vous montrer comment fonctionnent les options. 

Donc si vous avez vraiment besoin de plus au niveau widget, aller voir tkinter, vous allez voir qu'il y a vraiment beaucoup de widgets, il y en a plus d'une vingtaine facile avec au moins toutes les choses qui sortent donc n'hésitez pas à aller voir tout ça. 

En bonus de cette vidéo parce que en avant de vous quitter je ne vais pas vous laisser qu'avec ça, un autre point intéressant qui pour moi ne devrait pas être facultatif. Je ne vais pas en faire un tuto à part parce que ça me paraît indispensable quand on fait des interfaces de ce genre. C'est tout ce qui est les fenêtres modale. 

Vous savez les fenêtres modale, c'est tout ce qui est message d'erreur, messages d'avertissement, quand on vous demander la confirmation avant la suppression de quelque chose, ou de quitter un programme, en gros ce genre de chose ça. 

Et donc ça on peut vraiment pas passer un côté parce que c'est super important. 

Au niveau de cette utilisation, il va falloir importer un module en particulier donc on va l'apporter ici pour que ce soit clair. On va faire 
```py
    from tkinter import messagebox
```
messagebox, tout en minuscule. Alors attention avant la syntaxe était celle-ci.
```py
    #import tkMessageBox
```
Il fallait faire tkMessageBox, un module à part qui n'était pas forcément logique alors que ça faisait partie de tkinter, on ne comprend pas trop pourquoi qu'il l'avait mis à part même si comme ça fait partie des parties système du système d'exploitation que vous avez en place sur votre PC, et il faut croire qu'ils ont vu que ce n'était pas forcément logique non plus donc ils ont directement intégré dans tkinter sous le nom messagebox donc tout en minuscule. 

Donc attention si un jour vous récupérez un code et que vous voyez cette syntaxe, tkMessageBox, oui elle n'est plus bonne. 

Donc si on est en python 3.6 donc pour les syntaxes maintenant utiliser ce type là avec messagebox comme ceci.
```py
    #coding:utf-8
    import tkinter
    from tkinter import messagebox

    app = tkinter.Tk()

    lb.pack()
    app.mainloop()
```
On va créer une petite fonction, on va faire show_modal_window() et on va utiliser une méthode, par défaut je vais utiliser la méthode showerror().
```py
    #coding:utf-8
    import tkinter
    from tkinter import messagebox
    
    def show_modal_window():
        messagebox.showerror()

    app = tkinter.Tk()

    lb.pack()
    app.mainloop()
```
showerror() va prendre en premier paramètre le nom de la fenêtre et moi je vais l'appeler "ERREUR", nom très recherché, et on va afficher un message qui est très explicite également "Un problème est survenu !", voilà, juste ça.
```py
    #coding:utf-8
    import tkinter
    from tkinter import messagebox
    
    def show_modal_window():
        messagebox.showerror("ERREUR", "Un problème est survenu !")

    app = tkinter.Tk()

    lb.pack()
    app.mainloop()
```
Et là on va pouvoir définir un élément, j'utilise un boutton parce que ça paraît bien pour ce genre de chose, tkinter.Button(app, text="Déclencher une erreur", command=show_modal_window) avec tkinter.Button qui va sur l'élément parent app, on lui met un text et une command. Si vous ne comprenez pas show_modal_window, il faudra revoir les deux séance précédente pour comprendre tout ce que j'ai montré ici puisque c'est des choses vraiment à connaitre qu'on a vu précedemment. Et on oublie d'ajouter le bouton à l'interface, btn.pack().
```py
#coding:utf-8
import tkinter
from tkinter import messagebox

"""
showerror
"""

def show_modal_window():
   messagebox.showerror("ERREUR", "Un problème est survenu !")

app = tkinter.Tk()
btn = tkinter.Button(app, text="Déclencher une erreur", command=show_modal_window)

btn.pack()
app.mainloop()
```
```powershell
    >python main.py

    +-----------------------+
    | Déclencher une erreur |
    +-----------------------+

    (x)
```
On a également d'autres types de boutons, je ne vais pas te le montrer mais il y a des choses à savoir que je vais vous noter en exemple ici pour ceux qui voudraient prendre des notes. On a showerror, on va avoir showinfo et showinfo, je vais vous le montrer très rapidement.

showerror > showinfo, alors je ne change pas le message histoire de gagner du temps sur la vidéo.
```py 
#coding:utf-8
import tkinter
from tkinter import messagebox

"""
showerror
showinfo
"""

def show_modal_window():
   messagebox.showinfo("ERREUR", "Un problème est survenu !")

app = tkinter.Tk()
btn = tkinter.Button(app, text="Déclencher une erreur", command=show_modal_window)

btn.pack()
app.mainloop()
```
```powershell
    >python main.py

    +-----------------------+
    | Déclencher une erreur |
    +-----------------------+
    
    (i)
```
Et donc ici on n'a plus une erreur, même si la fenêtre s'appelle "ERREUR" mais le symbole a changé (un rond bleu avec un !), C'est simplement un message d'information donc sur Windows 10 et ça fait ce son là et ça affiche ce genre d'icône.
```py
    """
    showerror
    showinfo
    """
```
On a également le infowarning avec 2 W.  
```py
    """
    showerror
    showinfo
    showwarning
    """
```
```py 
#coding:utf-8
import tkinter
from tkinter import messagebox

"""
showerror
showinfo
showwarning
"""

def show_modal_window():
   messagebox.showwarning("ERREUR", "Un problème est survenu !")

app = tkinter.Tk()
btn = tkinter.Button(app, text="Déclencher une erreur", command=show_modal_window)

btn.pack()
app.mainloop()
```
```powershell
    >python main.py
    
    +-----------------------+
    | Déclencher une erreur |
    +-----------------------+
    
    /!\
```
Voilà pareil, au niveau du son de Windows 10 ça ne change pas mais voyez quand même que ça change l'icône en fonction donc pour gérer le type précis. 

(Points d'attention)

et vous avez des fenêtres modales qui propose différentes options, on peut faire notamment une askquestion.

On va changer le nom quand même, on va mettre une question "Quel est le muscle ?".
```py 
#coding:utf-8
import tkinter
from tkinter import messagebox

"""
showerror
showinfo
showwarning
askquestion
"""

def show_modal_window():
   messagebox.askquestion("Sondage", "Quel est le muscle ?")

app = tkinter.Tk()
btn = tkinter.Button(app, text="Déclencher une erreur", command=show_modal_window)

btn.pack()
app.mainloop()
```
```powershell
    >python main.py
    
    +-----------------------+
    | Déclencher une erreur |
    +-----------------------+
    
    (?)
    OUI / NON
```
Voyez que je ne déclenche pas une erreur, ça ouvre une petite fenêtre OUI / NON, vous n'avez pas le choix et donc ça va bien avec la question ^^. 

On a également une askokcancel pour le OK annulé donc je tâche de ne pas en oublier mais si j'en oubli ce n'est pas grave parce que de toute façon je vous ai montré les principaux. 
```py 
#coding:utf-8
import tkinter
from tkinter import messagebox

"""
showerror
showinfo
showwarning
askquestion
askokcancel
"""

def show_modal_window():
   messagebox.askokcancel("Sondage", "Quel est le muscle ?")

app = tkinter.Tk()
btn = tkinter.Button(app, text="Déclencher une erreur", command=show_modal_window)

btn.pack()
app.mainloop()
```
```powershell
    >python main.py
    
    +-----------------------+
    | Déclencher une erreur |
    +-----------------------+
    
    (?)
    OK / ANNULER
``` 
Voilà donc on a OK / ANNULER donc pareil il faut que le message soit clair par rapport à ça donc c'est toujours sous forme de questions (?) pareil et maintenant tout ce qu'on va voir et sous forme de questions. 

Je change le text avec "TEST".

Et donc askyesno, il doit y avoir un OUI / NON, déjà par défaut.
```py 
#coding:utf-8
import tkinter
from tkinter import messagebox

"""
showerror
showinfo
showwarning
askquestion
askokcancel
askyesno
"""

def show_modal_window():
   messagebox.askyesno("Sondage", "Quel est le muscle ?")

app = tkinter.Tk()
btn = tkinter.Button(app, text="TEST", command=show_modal_window)

btn.pack()
app.mainloop()
```
```powershell
    >python main.py
    
    +-----------------------+
    | Déclencher une erreur |
    +-----------------------+
    
    (?)
    OUI / NON
```
Vous verrez plus tard qu'on peut changer en fait les valeurs du bouton sur les appels parce que c'était en oui non par défaut mais on pourrait changer ça. 

Et on a ensuite askretrycancel qui est pas mal utilisé aussi, ça fait ce genre de messages RECOMMENCER / ANNULER.
```py 
#coding:utf-8
import tkinter
from tkinter import messagebox

"""
showerror
showinfo
showwarning
askquestion
askokcancel
askyesno
askretrycancel
"""

def show_modal_window():
    messagebox.askretrycancel("Sondage", "Quel est le muscle ?")

app = tkinter.Tk()
btn = tkinter.Button(app, text="TEST", command=show_modal_window)

btn.pack()
app.mainloop()
```
```powershell
    >python main.py
    
    +-----------------------+
    | Déclencher une erreur |
    +-----------------------+
    
    (?)
    RECOMMENCER / ANNULER
```
Donc ça c'est pas mal utilisé aussi, ça fait ce genre de messages quand on lui propose de recommencer une opération quelque chose comme ça qui n'as pas forcément fonctionné du premier coup donc ça en effet ça change, ce n'est plus une question ici, c'est autre chose en fait. 

Vous pouvez annuler, c'est-à-dire le fait de ne pas le faire ou continuer. 

Vous voyez cette fenêtre modèle prend la main sur le reste de l'application donc ça je ne pouvais pas passer à côté, mettre ça dans un tutoriel à part comme si c'était un contenu complémentaire qui n'est pas obligatoire pour la formation. 

Je trouve ça vraiment important de les utiliser donc n'hésitez pas quand vous en avez besoin, il faut que ce soit logique, ne les utiliser pas non plus à toutes les sauces. Essayez de vous inspirer des programmes que vous utilisez habituellement, devoir dans quelques heures ils utilisent ce type de fenêtre et comme ça vous pourrez adapter vos interfaces et faire des choses un peu plus professionnel, un peu plus propre. 

Donc ce sera mieux à ce niveau-là parce que c'est beaucoup plus pratique d'afficher une erreur de cette manière que de mettre un petit message dans le terminal, c'est évidemment plus logique maintenant qu'on travaille dans interface graphique, c'est bien d'afficher les erreurs de manière graphique aussi. 

Voilà pour cette partie là, j'espère que vous avez appris beaucoup de choses alors il y a eu beaucoup d'éléments, pour tech Inter il y a beaucoup de choses à apprendre un coup mais encore une fois, le meilleur moyen de bien assimiler tout ça est de faire vos programmes, créer des interfaces, mettez tout et n'importe quoi dedans, mélanger avec des labels, des boutons et cetera. 

Testez des fenêtres modales, mettez des listbox, je ne sais pas … mettez plein de petites choses et tester tout ça. 

Mettez des fonctions sous forme de commande comme on l'a vu là, ça peut servir dans certain qu pour pourquoi pas déclencher des commandes et de toute façon les vidéos suivantes, on étudiera les variables tkinter. On va les apporter. Vous allez voir que c'est super pratique de récupérer des valeurs et de travailler dessus.

On verra également comment positionner les éléments parce que ça c'est super important de pouvoir dire t'es le bouton tu le mets à droite d'un Label et cetera … histoire que tout ne soit pas mis au pif de manière n'importe comment.

Donc on verra tout ça, on verra également comment créer des menus parce que vous savez que dans les artères face graphique c'est un petit peu obligatoire de cette sorte là. 
```txt
Fichier     |   Edition     |   Recherche   ...
```
De cette sorte là avec fichier, modifier et cetera.

Voilà on apprendra à créer ce type de menu là qui est évidemment indispensable quand on fait des interfaces en GUI.

je vous dis à bientôt, n'hésitez pas à vous entraîner, à bien revoir tout ça et à revoir éventuellement les vidéos précédentes si ce n'est pas assez clair, à poser des questions. 

Si vous avez aimé la vidéo, un petit like comme d'habitude n'hésitez pas à vous abonner si ce n'est pas fait parce que c'est super important parce que j'ai beaucoup de gens qui regardent les vidéos et qui ne sont pas abonnés donc pour ça vérifiez que vous êtes parce que ça m'aide énormément pour faire développer la chaîne et pour faire connaître mon travail à un maximum de personnes. 

Et moi je vous dis bon courage et à bientôt pour la séance 23. 

Ciao tout le monde