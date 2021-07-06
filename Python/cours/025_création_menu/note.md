# [25. Création menu](https://www.youtube.com/watch?v=jGnGnro2vsk)

Bonjour à tous bienvenue sur la formation python.

On continue un petit peu tout ce qu'on a vu sur tkinter.

Dans cette vidéo 25, je vous propose de mettre au point un petit menu pour vos interfaces.

On a vu pas mal de widgets.

On a vu même comment utiliser des variables pour exploiter les données et j'aimerais vous montrer après tout ça ... il y a eu également le positionnement d'ailleurs parce qu'on a vu comment positionner nos éléments.

Comment vous allez pouvoir créer un menu puisque c'est un petit peu ce qu'on retrouve dans tout les logiciels, vous avez qu'à regarder sur les logiciels habituels que vous utilisez, vous avez toujours un menu principal composé en plus en général de menu assez similaires d'accord.

Vous avez le fameux menu fichier, menu Edition, affichage et cetera.

On retrouve quand même des choses assez semblables d'un logiciel à un autre pour que ce soit tout simplement plus ergonomique et que l'utilisateur ne perde pas ses habitudes au cours de l'utilisation du logiciel.

Donc on va mettre au point ce type de menu, vous allez voir que c'est très simple à mettre en place en python encore une fois.

Il y a un widget évidemment pour ça d'accord parce que tout est composé de widgets pour tkinter à ce moment-là donc on va utiliser le widget menu justement donc le widget de menu qui va permettre de mettre ça en place au niveau de notre interface.
```py
    #coding:utf-8
    import tkinter

    # Création de la fenêtre + paramètrage
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Création de menu")

    # Widgets...

    # Boucle principale
    app.mainloop()
```
Alors comme d'habitude j'ai simplement donc créé la fenêtre, mis une résolution par défaut, un titre, la boucle principale comme on fait d'habitude et on va tout créé à ce niveau là et vous verrez qu'on aura des petites choses au niveau de la partie principale la fenêtre principale a configuré pour tout simplement accrocher le menu à cette fenêtre d'accord ça sera important à faire il ne faudra pas qu'on oublié à la fin.

Donc on va déjà s'occuper de la partie ici.
```py
    # Widgets...
```
Alors le menu va se composé de 2 manières c'est-à-dire que vous allez avoir si vous voulez la barre de menu d'accord grosso modo ça va être un menu en lui-même d'accord un widget et à l'intérieur on va pouvoir y accrocher d'autres menu, ok.

Je sais pas si vous comprenez, vous avez la barre de menu. Vous allez par exemple avoir le menu fichier qui serait donc le menu 1 ... on aurait un 2e menu par exemple le menu Edition et chacun de ces menus différents auront bien évidemment des valeurs en dessous.

Vous savez c'est une espèce de menu déroulant avec des sous menus des différents commandes qui vous permettront de faire plusieurs choses par la suite.

Donc là le but c'est pas de faire des sous menus avec des des commandes qui fonctionnent ou des choses qui font certains traitements en fonction de ce que vous vous sélectionnez mais simplement déjà de voir au niveau visuel ce que ça donne.

De toute manière vous savez comment faire des commandes vous savez comment utiliser maintenant des observeurs vous savez comment vous servir de variable tkinter pour contrôler les traitements, voilà tout ça c'est des choses que vous avez appris à faire dans les vidéos précédentes.

Alors on va commencer maintenant, on va faire un premier menu alors je ne vais pas forcément faire le menu fichier Edition et cetera parce que ce sera un peu long et ce que je vais vous montrer là vous allez pouvoir l'appliquer pour un type de menu standard.

Nous on va juste faire sous forme d'exemples simples faciles à comprendre pour que ce soit clair pour tout le monde.

Donc le premier déjà, je fais tout simplement créer la barre de menu donc si vous voulez c'est le menu de la partie principale d'accord.

Donc je vais mettre "mainmenu" je vais l'appeler comme ça, ça part donc de tkinter toujours pareil. C'est le Menu donc avec un M majuscule d'accord.
```py
    mainmenu = tkinter.Menu(...)
```
Et ici vous avez a spécifier tout simplement comme d'habitude la fenêtre parente donc nous c'est toujours "app" on n'a pas changé à ce niveau là.
```py
    #coding:utf-8
    import tkinter

    # Création de la fenêtre + paramètrage
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Création de menu")

    # Widgets...
    mainmenu = tkinter.Menu(app)

    # Boucle principale
    app.mainloop()
```
Donc ça c'est la base d'accord ça, ça va constituer notre barre de menu en fait donc c'est super important.

Comme c'est ça qui va contenir tous les menus qu'on aura par la suite il va falloir l'attacher au niveau de notre fenêtre parce que là on l'a juste créé donc ça c'est bien en disant qu'elle avait une fenêtre parente mais on ne l'a pas forcément accroché à celle-ci.

Donc on va le faire avant la boucle principale via une configuration donc on utilise la méthode config() ou configure(), vous utilisé la syntaxe que vous voulez.
```py
    # Boucle principale
    app.config(...)
    app.mainloop()
```
Et là on va spécifier l'option menu.
```py
    # Boucle principale
    app.config(menu)
    app.mainloop()
```
Voyez il y a une option particulière pour lui dire que tel fenêtre en fait, elle a un menu qui lui est associée donc nous, c'est notre mainmenu voilà.
```py
    # Boucle principale
    app.config(menu=mainmenu)
    app.mainloop()
```
Donc en le faisant le départ vous êtes sûr de pas l'oublier par la suite et tout sera OK à ce niveau là.

Voilà maintenant on va pouvoir constituer ce menu, on va créer donc la première partie d'accord donc je vais par exemple mettre first_menu d'accord je vais l'appeler comme ça et on va faire tout simplement tkinter.Menu().
```py
    #coding:utf-8
    import tkinter

    # Création de la fenêtre + paramètrage
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Création de menu")

    # Widgets...
    mainmenu = tkinter.Menu(app)
    
    first_menu = tkinter.Menu()

    # Boucle principale
    app.config(menu=mainmenu)
    app.mainloop()
```
Sauf que là évidemment, comme je vous avez dit que ça...
```py
    mainmenu = tkinter.Menu(app)
```
... que c'était plus ou moins la barre de menu, il faudra le ratacher à ça donc le widget parent ça va être le mainmenu okay c'est cette partie là, "first_menu = tkinter.Menu(mainmenu)".
```py
    #coding:utf-8
    import tkinter

    # Création de la fenêtre + paramètrage
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Création de menu")

    # Widgets...
    mainmenu = tkinter.Menu(app)
    
    first_menu = tkinter.Menu(mainmenu)

    # Boucle principale
    app.config(menu=mainmenu)
    app.mainloop()
```
On va laisser comme ça et ensuite on va pouvoir y ajouter un ensemble de commandes donc ça c'est le premier menu, first_menu OK.

On va faire le menu suivant, second_menu.
```py
    second_menu = tkinter.Menu(mainmenu)
```
Donc c'est second_menu qui est rattaché à ça, mainmenu.

Voilà là on a fait les 2 choses.
```py
    #coding:utf-8
    import tkinter

    # Création de la fenêtre + paramètrage
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Création de menu")

    # Widgets...
    mainmenu = tkinter.Menu(app)
    
    first_menu = tkinter.Menu(mainmenu)
    
    second_menu = tkinter.Menu(mainmenu)

    # Boucle principale
    app.config(menu=mainmenu)
    app.mainloop()
```
Ensuite vous pouvez ajouter ces menus au niveau de la barre pour avoir une valeur parce que là c'est bien mais on ne sait pas quelle valeur ils auraient ces menus-là donc ça sera un petit peu bizarre d'accord donc ça on verra par la suite.

Pour chacun de ces menus-là, on va leur mettre des valeurs qu'on va pouvoir parcourir OK donc pour ça au niveau des menus que vous créez vous allez tout simplement ajouter un nombre de commandes d'accord. Il y a une méthode s'appelle "add_command()" qui permet de le faire donc il suffit de spécifier le menu en question donc ici.
```py
    first_menu
```
Ensuite d'appeler la méthode add_command() tout simplement.
```py
    first_menu.add_command()
```
Et ici de mettre une option label d'accord donc vous mettez l'option label dans l'ordre que vous voulez dans l'appel des méthodes mais nous on va commencer par ça.
```py
    first_menu.add_command(label="")
```
Et on va lui donner un nom d'accord tout simplement donc ça peut être par exemple, moi je vais mettre option alors je mets des noms comme ça qu'ils ne veulent pas forcément dire quelque chose mais voilà ce sera suffisamment clair, option1.
```py
    first_menu.add_command(label="Option1")
```
On peut répéter la même chose par exemple pour un 2e, un 3e.
```py
    #coding:utf-8
    import tkinter

    # Création de la fenêtre + paramètrage
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Création de menu")

    # Widgets...
    mainmenu = tkinter.Menu(app)
    
    first_menu = tkinter.Menu(mainmenu)
    first_menu.add_command(label="Option1")
    first_menu.add_command(label="Option2")
    first_menu.add_command(label="Option3")
    
    second_menu = tkinter.Menu(mainmenu)

    # Boucle principale
    app.config(menu=mainmenu)
    app.mainloop()
```
On va faire ça option1, 2, 3 voilà.

Donc là on va imaginer on aura un premier menu déroulant d'accord sauf que vous voyez il n'y a pas de valeur par défaut. Vous savez le titre qui s'affiche au menu "fichier", "Edition", "affichage", "aide" ce genre de choses qu'on va donc ça on va le faire par la suite.

ici, second_menu, on va faire la même chose.
```py
    second_menu.add_command()
```
Par contre je vais mettre autre chose comme nom, je vais par exemple mettre command1 voilà, histoire de différencier un peu les noms d'accord, ne pas se tromper et je vais en mettre que 2.
```py
    #coding:utf-8
    import tkinter

    # Création de la fenêtre + paramètrage
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Création de menu")

    # Widgets...
    mainmenu = tkinter.Menu(app)
    
    first_menu = tkinter.Menu(mainmenu)
    first_menu.add_command(label="Option1")
    first_menu.add_command(label="Option2")
    first_menu.add_command(label="Option3")
    
    second_menu = tkinter.Menu(mainmenu)
    second_menu.add_command(label="Commande1")
    second_menu.add_command(label="Commande2")
    
    # Boucle principale
    app.config(menu=mainmenu)
    app.mainloop()
```
Commande1, Commande2 voilà et on va s'arrêter là donc c'est vraiment très simple, c'est une vidéo assez courte c'est pas compliqué à mettre en place.

Donc on a le premier menu.
```py
    first_menu = tkinter.Menu(mainmenu)
    first_menu.add_command(label="Option1")
    first_menu.add_command(label="Option2")
    first_menu.add_command(label="Option3")
```
Le 2e maintenant.
```py
    second_menu = tkinter.Menu(mainmenu)
    second_menu.add_command(label="Commande1")
    second_menu.add_command(label="Commande2")
```
Maintenant il faut indiquer que ce sont des menus déroulants avec une base donc qui aura évidemment une valeur d'accord, un label aussi.

Donc pour ça, on va les mettre à part, moi je vais le mettre juste à la suite.

On va tout simplement faire mainmenu où donc là on travaille sur la barre de menu d'accord, la partie principale puisque c'est à lui, on va lui ajouter un menu en cascade donc on va faire add_cascade comme ceci.
```py
    mainmenu.add_cascade()
```
En spécifiant un label, label c'est le titre qu'il y aura d'afficher par défaut d'accord avant qu'on déroule le menu.
```py
    mainmenu.add_cascade(label="")
```
Donc ici moi par exemple je vais mettre "Premier" tout simplement.
```py
    mainmenu.add_cascade(label="Premier")
```
Et ici on spécifie le menu associé donc nous c'est le first_menu par rapport à ce que j'ai fait au début.
```py
    mainmenu.add_cascade(label="Premier", menu=first_menu)
```
Et on fait la même chose pour l'autres, limite on peut faire un copier-coller, label, je vais mettre une 2nde. Il associé au second_menu voilà tout simplement.
```py
    mainmenu.add_cascade(label="Premier", menu=first_menu)
    mainmenu.add_cascade(label="Second", menu=second_menu)
```
On a configuré rappelez-vous le menu principal ici.
```py
    #coding:utf-8
    import tkinter

    # Création de la fenêtre + paramètrage
    app = tkinter.Tk()
    app.geometry("640x480")
    app.title("Création de menu")

    # Widgets...
    mainmenu = tkinter.Menu(app)
    
    first_menu = tkinter.Menu(mainmenu)
    first_menu.add_command(label="Option1")
    first_menu.add_command(label="Option2")
    first_menu.add_command(label="Option3")
    
    second_menu = tkinter.Menu(mainmenu)
    second_menu.add_command(label="Commande1")
    second_menu.add_command(label="Commande2")
    
    mainmenu.add_cascade(label="Premier", menu=first_menu)
    mainmenu.add_cascade(label="Second", menu=second_menu)
    
    # Boucle principale
    app.config(menu=mainmenu)  #  <=================
    app.mainloop()
```
Donc celui-là, mainmenu, maintenant contient à la fois first_menu et second_menu et en plus possède des labels par défaut.
```py
    mainmenu.add_cascade(label="Premier", menu=first_menu)
    mainmenu.add_cascade(label="Second", menu=second_menu)
```
Donc on va pouvoir le charger et vérifier l'affichage ce que ça nous donne.
```py
#coding:utf-8
import tkinter

# Création de la fenêtre + paramètrage
app = tkinter.Tk()
app.geometry("640x480")
app.title("Création de menu")

# Widgets...
mainmenu = tkinter.Menu(app)

first_menu = tkinter.Menu(mainmenu)
first_menu.add_command(label="Option1")
first_menu.add_command(label="Option2")
first_menu.add_command(label="Option3")

second_menu = tkinter.Menu(mainmenu)
second_menu.add_command(label="Commande1")
second_menu.add_command(label="Commande2")

mainmenu.add_cascade(label="Premier", menu=first_menu)
mainmenu.add_cascade(label="Second", menu=second_menu)

# Boucle principale
app.config(menu=mainmenu)
app.mainloop()
```
```powershell
    >python main.py
    Premier     Second
        Option1     Commande1
        Option2     Commande2
        Option3
```
Donc voilà le résultat final au niveau de ce menu donc voyez qu'on a un menu ici affiché comme n'importe quel logiciel et en cliquant sur premier on obtient notre fameuse Option1, 2, 3  comme on les a spécifié et en cliquant sur Premier, on obtient notre Première Option.

Et à coté on a logiquement Command1, 2. Vous voyez qu'on peut se balader comme n'importe quel logiciel.

Bien évidemment si je clique dessus, il ne se passe rien puisque je n'ai rien spécifié si vous voulez va produire où déclencher quelque chose il suffira de faire comme vous l'avez toujours fait c'est-à-dire de faire ceci, command=hello par exemple.
```py
    first_menu = tkinter.Menu(mainmenu)
    first_menu.add_command(label="Option1", command=hello)
    ...
```
Et de spécifier en mettant une fonction.
```py
    def hello():
        print("Coucou !")
```     
Coucou, ça va le dire dans le terminal parce qu'on fait ça avec print() je rappelle voilà donc on va relancer.
```py
#coding:utf-8
import tkinter

def hello():
   print("Coucou !")

# Création de la fenêtre + paramètrage
app = tkinter.Tk()
app.geometry("640x480")
app.title("Création de menu")

# Widgets...
mainmenu = tkinter.Menu(app)

first_menu = tkinter.Menu(mainmenu)
first_menu.add_command(label="Option1", command=hello)
first_menu.add_command(label="Option2")
first_menu.add_command(label="Option3")

second_menu = tkinter.Menu(mainmenu)
second_menu.add_command(label="Commande1")
second_menu.add_command(label="Commande2")

mainmenu.add_cascade(label="Premier", menu=first_menu)
mainmenu.add_cascade(label="Second", menu=second_menu)

# Boucle principale
app.config(menu=mainmenu)
app.mainloop()
```
```py
    >python main.py
    Premier     Second
        Option1     Commande1
        Option2     Commande2
        Option3
        
    Option1
        Coucou !
```
Donc vérifier le terminal, vous allez voir. On va faire ça option1 et voilà ça affiche le message à chaque fois donc ça c'est des choses qu'on a déjà vu donc logiquement ça devrait pas vous être étranger à ce niveau là donc je vais l'enlever pour le moment. On va rester là par rapport à cette partie et comme ça votre menu est tout simplement généré.
```py
    first_menu.add_command(label="Option1", command=hello)
    > first_menu.add_command(label="Option1")
```
Donc c'est très simple à mettre en place, c'est vraiment très simple.

Il faut juste procéder de cette manière pour avoir ce type de menu.

Alors là vous avez déjà remarqué qu'il y avait une petite barre comme ça qui s'affichait sur chaque petit menu.
```txt
    Premier     Second
        -------     ---------
        Option1     Commande1
        Option2     Commande2
        Option3
```
Si jamais ça vous dérange vous ne voulez pas ça "---------" puisque pareil les menus fonctionneront avec un système d'index d'accord un petit peu comme une liste c'est-à-dire que ça "---------" sera le premier élément mais d'indice 0 et cetera.

En fait d'accord ça va être géré en fait via des index.

Si vous ne voulez pas cet élément ici qui est juste en fait une espèce de séparateurs vous pouvez l'enlever tout simplement au niveau de votre menu là.
```py
    first_menu = tkinter.Menu(mainmenu)
```
Donc quand vous créez chaque petit menu, vous utiliser l'option tearoff=0 voilà pour dire simplement que vous n'aurez pas cette espèce de trait en fait qui se met.
```py
#coding:utf-8
import tkinter

# Création de la fenêtre + paramètrage
app = tkinter.Tk()
app.geometry("640x480")
app.title("Création de menu")

# Widgets...
mainmenu = tkinter.Menu(app)

first_menu = tkinter.Menu(mainmenu, tearoff=0)
first_menu.add_command(label="Option1")
first_menu.add_command(label="Option2")
first_menu.add_command(label="Option3")

second_menu = tkinter.Menu(mainmenu, tearoff=0)
second_menu.add_command(label="Commande1")
second_menu.add_command(label="Commande2")

mainmenu.add_cascade(label="Premier", menu=first_menu)
mainmenu.add_cascade(label="Second", menu=second_menu)

# Boucle principale
app.config(menu=mainmenu)
app.mainloop()
```
```powershell
    >python main.py
    Premier     Second
        Option1     Commande1
        Option2     Commande2
        Option3
```

Voilà et là vous l'aurez simplement pas ce petit séparateur.

Peut être certains préfèrent avoir un menu comme ceci, c'est au choix également.

On peut très bien faire par exemple "Quitter", command=app.quit, ce genre de chose.
```py
#coding:utf-8
import tkinter

# Création de la fenêtre + paramètrage
app = tkinter.Tk()
app.geometry("640x480")
app.title("Création de menu")

# Widgets...
mainmenu = tkinter.Menu(app)

first_menu = tkinter.Menu(mainmenu, tearoff=0)
first_menu.add_command(label="Option1")
first_menu.add_command(label="Option2")
first_menu.add_command(label="Quitter", command=app.quit)

second_menu = tkinter.Menu(mainmenu, tearoff=0)
second_menu.add_command(label="Commande1")
second_menu.add_command(label="Commande2")

mainmenu.add_cascade(label="Premier", menu=first_menu)
mainmenu.add_cascade(label="Second", menu=second_menu)

# Boucle principale
app.config(menu=mainmenu)
app.mainloop()
```
```powershell
    >python main.py
    Premier     Second
        Option1     Commande1
        Option2     Commande2
        Quitter
```
Quitter, ce genre de chose comme ça vous avez une petite fenêtre de lancer, vous faites Quitter et ça quitte l'application d'accord.

Je vous rappelle que toute façon c'est une méthode qui fonctionne en fait directement sur une fenêtre donc en mettant simplement cette commande là, command=app.quit.
```py
    first_menu.add_command(label="Quitter", command=app.quit)
```
Même si vous n'avez pas créez une fonction comme vous le voyez, ça va quitter l'application donc ça peut servir voilà.

Très pratique si vous voulez faire une option comme ça une commande pour quitter le programme. Vous faites juste ça tout simplement.

Alors par la suite vous pourrez très bien aussi par exemple ouvrir des sous fenêtres, ça vous avez vu au niveau de la formation, on n'a pas vu comment par exemple avoir une 2nde fenêtre où une autre donc ça c'est des choses également que vous pouvez faire.

Je vais vous montrer rapidement donc ce sera le petit bonus de cette vidéo parce qu'elle était quand même suffisamment courte par rapport à ce que je veux vous montrer et il va s'agir du widget Toplevel d'accord.

top_level c'est un widget qui sert à faire des fenêtres supplémentaires, vous pouvez en faire évidemment autant que vous voulez parce que vous avez une fenêtre principale qui est ici et ça va être assez pratique à gérer.

Donc comment je peux faire ça, et bien admettons ici que j'ai une commande "A propos" d'accord ce genre de chose d'accord ici, et bien je vais pouvoir le gérer donc là, je vais faire commande show_about.
```py
    second_menu = tkinter.Menu(mainmenu, tearoff=0)
    second_menu.add_command(label="Commande1")
    second_menu.add_command(label="A propos", command=show_about)
```
Par exemple qui serait genre show_about_window en bref.
```py
    def show_about():
```
On va mettre `def show_about()` et là je vais tout simplement créer la fenêtre.
```py
    def show_about():
        about_window
```
Et donc je vais faire about_window ici égal tkinter mais au lieu d'être Tk() comme pour la création d'accord, on va faire Toplevel d'accord.
```py
    def show_about():
        about_window = tkinter.Toplevel(...)
```
Donc il y a un T majuscule seulement et vous allez créer votre fenêtre ici.
```py
    def show_about():
        about_window = tkinter.Toplevel(ici)
```
Donc ça c'est super important du coup de le gérer et là par contre il faut lui mettre un élément parent qui est app, d'accord pour dire que c'est une sous fenêtre en fait de la fenêtre principale.
```py
    def show_about():
        about_window = tkinter.Toplevel(app)
```
Après on peut modifier plein de choses comme d'habitude on peut modifier le titre comme ça c'est mieux sinon il va vous laisser le titre par défaut qui Tk.
```py
    def show_about():
        about_window = tkinter.Toplevel(app)
        about_window.title("A propos")
```
Voilà etc, la taille enfin bref vous pouvez modifier un petit peu ce que vous voulez et mettre des choses dedans d'accord on peut très bien y mettre n'importe quoi.

On peut faire lb.
```py
    def show_about():
        about_window = tkinter.Toplevel(app)
        about_window.title("A propos")
        lb = tkinter.Label(about_window, text="Bonjour !")
```
Bonjour, c'est un peu bizarre de mettre un Bonjour dans un à propos mais c'est histoire de voir en tout cas pour vous et après vous faites le fameux lb.pack() comme on a toujours fait, ce genre de chose.
```py
    def show_about():
        about_window = tkinter.Toplevel(app)
        about_window.title("A propos")
        lb = tkinter.Label(about_window, text="Bonjour !")
        lb.pack()
```
```py
#coding:utf-8
import tkinter

def show_about():
   about_window = tkinter.Toplevel(app)
   about_window.title("A propos")
   lb = tkinter.Label(about_window, text="Bonjour !")
   lb.pack()

# Création de la fenêtre + paramètrage
app = tkinter.Tk()
app.geometry("640x480")
app.title("Création de menu")

# Widgets...
mainmenu = tkinter.Menu(app)

first_menu = tkinter.Menu(mainmenu, tearoff=0)
first_menu.add_command(label="Option1")
first_menu.add_command(label="Option2")
first_menu.add_command(label="Quitter", command=app.quit)

second_menu = tkinter.Menu(mainmenu, tearoff=0)
second_menu.add_command(label="Commande1")
second_menu.add_command(label="A propos", command=show_about)

mainmenu.add_cascade(label="Premier", menu=first_menu)
mainmenu.add_cascade(label="Second", menu=second_menu)

# Boucle principale
app.config(menu=mainmenu)
app.mainloop()
```
```powershell
    >python main.py
    Premier     Second
        Option1     Commande1
        Option2     A propos
        Quitter
```
Quitter pour fermer la fenêtre et vous allez pouvoir directement ici afficher une sous fenêtre voilà, avec A propos.

Pareil vous pouvez gérer la taille qu'elle fait, vous pouvez choisir où est-ce qu'elle va s'afficher parce que là voyez qu'elle s'affiche un peu en décalé.

Tout ça ça se gère via des options, je ne l'ai pas forcément montré en vidéo parce que c'est très simple à gérer d'accord il y a beaucoup d'options que vous pouvez utiliser sur beaucoup de widgets pour tout ce qui est redimension, est-ce qu'on interdit le dimensionnement d'une fenêtre, ce genre de choses ou la taille maximum qu'elle peut prendre, la taille minimale et cetera donc n'hésitez pas à vous renseigner pour voir pour gérer cette partie là.

Donc là on a une sous fenêtre et comme elle est rattachée en fait à notre application donc c'est vraiment une sous fenêtre ici de la fenêtre APP d'accord donc notre fenêtre principal mais contrairement à par exemple les messages qu'on avait vu ... vous savez les messages d'erreur ou d'info ou tout ça, ce n'est pas une fenêtre modal c'est-à-dire qu'elle n'a pas la main d'accord.

La fenêtre A propos n'a pas la main en fait complète sur le programme, vous pouvez très bien repasser sur la fenêtre principale.

Et on peut ouvrir d'ailleurs une 2e fenêtre à propos d'accord.
```txt
    +------------------+
    | Création de Menu |
    |                  |    +----------+    +----------+
    +------------------+    | A propos |    | A propos |
                            +----------+    +----------+
```
C'est tout à fait possible de faire ce genre de choses donc ça c'est la petite différents d'accord c'est pas une message box ici c'est vraiment Toplevel donc une autre fenêtre d'accord une sous fenêtre qui du coup va être reliée à notre fenêtre principale.

Donc ça permet comme ça de faire des programmes un petit peu plus poussé.

Ca je l'avais pas montré ce que je voulais vous le gardez la, on a vu suffisamment de choses dans les vidéos précédentes donc je voulais attendre d'arriver au menu pour montrer ce genre de fonctionnalités parce que c'est évidemment très utile et ça va être très utilisé donc Toplevel c'est vraiment un widget à connaître pour créer ce type de fenêtre là.

Donc n'hésitez pas à vous en servir parce que ça vous servira quand même pas mal.

J'ai fait le tour de ce que je voulais vous montrer, on s'arrêtera avec ça parce qu'il y a pas mal de choses.

Je peux vous montrer rapidement éventuellement aussi la possibilité d'utiliser autre chose que des simples commandes donc là pareil, vous pouvez vous renseigner au niveau des menus pour voir qu'il y a plusieurs types de méthodes mais vous avez également une méthode alors je ne la montrerai pas en démonstration parce que c'est pareil on a déjà vu ça dans d'autres vidéos mais vous avez une méthode pour ajouter un checkbutton() donc c'est simplement add_checkbutton().
```py
    # add_checkbutton()
```
Donc elle va prendre les options comme pour un checkbutton() comme on l'a vu avant.

Vous allez avoir add_radiobutton() pareil d'accord.
```py
    # add_checkbutton()
    # add_radiobutton()
```
Ca aussi on l'a déjà vu et vous avez une méthode aussi mais ça ça paraît logique c'est le add_separator() tout simplement.
```py
    # add_checkbutton()
    # add_radiobutton()
    # add_separator()
```
Et ça va c'est très simple à utiliser par exemple si vous voulez séparer ici les options, vous faites comme ceci add_separator() et voilà vous mettez rien dedans d'accord tout simplement et là quand vous allez appeler votre programme dans le menu ça va vous mettre un petit séparateur.
```py
#coding:utf-8
import tkinter

# add_checkbutton()
# add_radiobutton()
# add_separator()

def show_about():
    about_window = tkinter.Toplevel(app)
    about_window.title("A propos")
    lb = tkinter.Label(about_window, text="Bonjour !")
    lb.pack()

# Création de la fenêtre + paramètrage
app = tkinter.Tk()
app.geometry("640x480")
app.title("Création de menu")

# Widgets...
mainmenu = tkinter.Menu(app)

first_menu = tkinter.Menu(mainmenu, tearoff=0)
first_menu.add_command(label="Option1")
first_menu.add_command(label="Option2")
first_menu.add_separator()
first_menu.add_command(label="Quitter", command=app.quit)

second_menu = tkinter.Menu(mainmenu, tearoff=0)
second_menu.add_command(label="Commande1")
second_menu.add_command(label="A propos", command=show_about)

mainmenu.add_cascade(label="Premier", menu=first_menu)
mainmenu.add_cascade(label="Second", menu=second_menu)

# Boucle principale
app.config(menu=mainmenu)
app.mainloop()
```
```powershell
    >python main.py
    Premier     Second
        Option1     Commande1
        Option2     A propos
        _______
        Quitter
```

Un petit séparateur, ça vous l'avez déjà vu dans pas mal de logiciels que vous utilisez aussi donc c'est très simple à faire tout simplement voilà.

checkbutton(), radiobutton(), on l'a déjà expliqué comment ça fonctionnait donc je ne reviens pas dessus pour ne pas voilà sortir du sujet de cette vidéo.

J'espère que ça vous a plu, que ça vous aura permis d'aller encore un peu plus loin sur les interfaces.

A priori ça devrait être la dernière vidéo enfin grosso modo en tout cas dans le cours sur tkinter d'accord.

On va passer maintenant à la suite, voilà d'autres petites choses pour la suite.

Là vous avez tout ce qu'il faut on va dire essentiel pour développer des interfaces graphiques en python.

Vous retrouverez bien évidemment des exercices sur tkinter pour pouvoir faire des choses concrête et mettre en pratique tout ce que vous avez vu.

Egalement des tutoriels d'accord, je ferai des tutoriels par exemple avec des petites choses complémentaires c'est-à-dire que je n'estime pas forcément obligatoire mais qui peuvent vous apporter un plus et sûrement vous intéresser au niveau de la création d'interfaces graphiques avec tkinter justement.

Je vous dis à bientôt, entraînez vous bien et n'hésitez pas à laisser des like, des commentaires et partager surtout les vidéos à chaque fois.

N'hésitez pas à le partager autour de vous, il y a sûrement d'autres personnes qui sont intéressées par ce type de formation.

Donc à bientôt merci encore de votre fidélité, merci d'être abonner à la chaîne et on se retrouve pour la 26e séance donc avec quelque chose d'un peu nouveau.

On continuer sur cette formation Python.

Ciao tout le monde