# [23. Variables contrôle](https://www.youtube.com/watch?v=lUDF9bureH4)

Bonjour bienvenue tout le monde pour cette vingt-troisième vidéo, vous êtes sur la formation en langage python et on va continuer un petit peu avec l'utilisation de tkinter pour nos interfaces.

Et on va arriver sur un point très important que vous avez légèrement évoqué dans la vidéo précédente qui concerne notamment les variables que l'on va utiliser au sein de tkinter donc c'est un cas assez particulier. 

Donc c'est très très simple à appréhender, c'est vraiment très très facile à utiliser et pour cela j'ai pris un code minimal que je fais d'habitude où j'ai simplement créé mon objet Tk, et ensuite j'ai spécifié une taille minimale geometry("400x300") Ce qui m'évitera de la redimensionner à chaque fois donc ça ce sont des choses qu'on a vues évidemment dans la première vidéo sur tkinter c'est à dire le changement de titre, title(), et cetera. Et la boucle principale.
```py
    #coding:utf-8
    import tkinter

    # Création et paramètrage de la fenêtre
    app = tkinter.Tk()
    app.geometry("400x300")
    app.title("Variables tkinter")

    # Widgets...

    # Boucle principale
    app.mainloop()
```
Si jamais ce code là, vous ne le comprenez pas, n'hésitez pas à voir les vidéos précédentes concernant tkinter pour être justement au même point que tout le monde et du coup plus apprécié cette vidéo là. 

Et là on va attaquer une autre partie, on va créé pour cela un autre widget très sympa et simplement un Label comme on fait en général.

On va faire label = tkinter.Label(app,...

Je rappelle que le premier élément, app, c'est le widget parent.

Et ensuite les options et je le redit même si je l'ai déjà dit avant mais je préfère le répéter au cas où pour ceux qui aurait loupé, comme il s'agit d'options facultatives, vous savez que vous pouvez les mettre dans l'ordre que vous voulez.

Rappelez le cours sur les fonctions, je vous avait expliqué que quand vous avez des paramètres nommés qui comportait un nom= suivi d'un égal et une valeur, on peut du coup les mettre dans l'ordre qu'on veut.

Et après vous mettez les options dans l'ordre que vous voulez et moi par exemple ici je vais commencer en mettant text="Bonjour ! :)", d'accord, je vais juste mettre ça.
```py
    label = tkinter.Label(app, text="Bonjour ! :)")
```
Voilà comme ceci, on va le placer, label.pack().
```py
#coding:utf-8
import tkinter

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
label = tkinter.Label(app, text="Bonjour ! :)")
label.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
    +---------------------------+
    |       Bonjour ! :)        |
    |                           |
    +---------------------------+
``` 
Et donc voilà, là on affiche le Label tel qui l'est.

Voilà on a cette option mais si je voulais rajouter une autre option par exemple pour changer la largeur, je peux très bien mettre l'option width=20, admettons.
```py
    # Widgets...
    label = tkinter.Label(app, text="Bonjour ! :)", width=20)
    label.pack()
```
Alors je peut très bien mettre cette option avant.
```py
    # Widgets...
    label = tkinter.Label(app, width=20, text="Bonjour ! :)")
    label.pack()
```
Pour ceux qui penseraient qu'il faut respecter un ordre particulière, vous pouvez vraiment mettre dans l'ordre que vous voulez, ce sont des paramètres nommés et si vous avez bien compris la vidéo que j'avais fait sur les fonctions, et notamment celle sur lequel je suis revenu dessus concernant les méthodes pour les classes, je vais expliquer qu'on peut procéder dans l'ordre que l'on veut du moment que l'on nomme bien les paramètres en question. 

Donc ça c'est vous qui voyez, vous mettez les paramètres dont vous avez besoin et dans l'ordre que vous voulez donc c'est chacun fait comme il veut à ce niveau-là. Il n'y a pas de règles particulières à ce niveau-là. 

Donc par défaut, je reviens sur le code, c'est ce qu'on a appris à faire donc l'affichage dans Label tout simplement sans particularité aucune, on exploite rien au niveau interne, on a juste l'affichage d'un texte. 

Comment va-t-on traiter cette chose, de manière interne, c'est à dire informatique. Comment est-ce qu'on va pouvoir exploiter ce texte, est-ce que par exemple on pourra le changer, est-ce qu'on pourra faire certaines choses comme ça suivant des actions d'un programme. 

Je ne veux pas par exemple à avoir à faire moi-même comme on l'avait vu en faisant Label, en modifiant nous-mêmes l'option texte, rappelez vous avec config(), configure() et cetera permettez de modifier les options que vous voulez mais le faire par exemple via programmation. 

En fait pour cela utiliser les variables donc je vais créer une variable en particulier que je vais appeler var_label donc je reste sur un nom simple ici et on va créer un type très particulier donc tkinter. Et on va instancier un objet d'une certaine type de classe donc pour moi le label c'est une chaîne de caractères donc je vais déclarer StringVar() avec un S majuscule et un V majuscule.
```py
    # Widgets...
    var_label = tkinter.StringVar()
    label = tkinter.Label(app, width=20, text="Bonjour ! :)")
    
    label.pack()
```
Voilà ici on a instance et un nouvel objet.
```py
    var_label = tkinter.StringVar()
``` 
Alors pour la petite info, pour avoir de quoi noter si vous voulez, je vous donne les principaux donc ceux qui sont vraiment importants à savoir.
On va avoir StringVar(), ça c'est pour les chiens de caractère. [str], je rappelle. On va avoir IntVar() donc ça c'est un nombre entier et c'est [int] ou integer.

On va avoir DoubleVar() donc ça c'est la petite distinction, on utilise pas le mot float, c'est pour les nombres flottants, en général quand on veut avoir ce type là pour nos variables. 

Et on va voir également BooleanVar() qui concerne évidemment les valeurs booléennes.
```py
    """
    StringVar()     : chaine de caractères [str]
    IntVar()         : nombre entier [int]
    DoubleVar()     : nombre flottant [float]
    BooleanVar()    : booléen [bool]
    """
```
Voilà ça c'est les 4 à connaître pour les 4 types natifs on est fou de python. Ce sont des types primitifs, je dis souvent natif dans le langage mais il y en a plein d'autres types natifs mais on va plutôt appeler cela des types primitifs, Le fait qu'il y ait des entiers, des chaînes de caractères, ça pourrait d'ailleurs fonctionner pour un autre langage de programmation. 

Le type primitif ce sera d'ailleurs plus clair que les types natifs donc à partir de là on va pouvoir traiter ces choses-là.

Voilà à partir de là on va pouvoir traiter ces choses-là. Cette variable var_label, je l'ai juste créé donc je vais en faire quoi ? pour le moment elle ne fait rien du tout mais je vais la connecter.

Pour la connecter, je peux utiliser une autre option alors je ne vais pas utiliser text ici parce que je n'ai pas spécialement envie d'afficher quelque chose en particulier donc on va pouvoir le laisser à vide, text="". On ne mettra rien du tout pour dire que c'est un vide, quel âge je vais utiliser l'option textvariable.

Donc je croyais que le nom ne change pas beaucoup, c'est textvariable avec le mot variable derrière et là vous allez mettre le nom de la variable associée afin de connecter les 2.                 
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_label = tkinter.StringVar
label = tkinter.Label(app, text=""", textvariable=var_label)

label.pack()

# Boucle principale
app.mainloop()
```
Donc là vous avez connecter les 2, et ensuite une petite exécution.
```powershell
    >python main.py
    
    +---------------------------+
    |                           |
    |                           |
    +---------------------------+
```
Et là, nous n'avons plus rien.

On peut éventuellement faire ceci, text="ddd".
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_label = tkinter.StringVar()
label = tkinter.Label(app, text="ddd", textvariable=var_label)

label.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
    +---------------------------+
    |                           |
    |                           |
    +---------------------------+
```
Et vous voyez qu'on a pas d'affichage pour autant.

Donc ce qui est important c'est que tout va se passer à ce niveau-là, en fait cette valeur "ddd" va être stocké et surtout utilisé avec var_label, d'accors c'est ça qui est important.

Alors une variable comme ça, comment l'afficher ? Simplement comme on le fait d'habitude sauf qu'il y a une petite distinction.

Ces types de variables ont quelques méthodes ou en tout cas des choses qui vont vous servir pour travailler avec.

Ces méthodes de variable c'est assez simple, vous allez pouvoir récupérer la valeur actuel avec une méthode get() qu'on va voir...

Et modifier éventuellement la valeur avec une méthode set() ce qu'on appelle en général les accesseurs.

Les accesseurs, choses dont on a eu l'occasion d'évoquer sur les début de la programmation en Python.

Donc on va juste voir ça, on va faire un print("") par exemple et on va faire par exemple Label et on verra la valeur qu'il a, ce genre de chose, avec var_label.get().
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_label = tkinter.StringVar()
label = tkinter.Label(app, text="ddd", textvariable=var_label)

print("Label :", var_label.get())

label.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    Label :
    
    +---------------------------+
    |                           |
    |                           |
    +---------------------------+
```
Donc ici vous voyez que apparemment il n'y a rien du tout. 

Vous voyez que ici dans ma ligne de commande, il n'y a pas de valeur donc par défaut il n'y a pas de valeur. 

Donc attention ces choses-là text="" sont bien distinctes de textvariable=var_label.

C'est super important, C'est pourquoi éventuellement vous auriez pu vous passer de text="" si vous le voulez. 

Maintenant si je tente de modifier la valeur avant, on va faire par exemple var_label.set() et là on défie en mettant par exemple "coucou" et donc qu'est-ce qu'il va se passer ?
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_label = tkinter.StringVar()
label = tkinter.Label(app, text="ddd", textvariable=var_label)

var_label.set("Coucou") ##
print("Label :", var_label.get())

label.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    Label : Coucou

    +---------------------------+
    |         Coucou            |
    |                           |
    +---------------------------+
```
Nous avons ça et donc vous voyez que ça fonctionne, la variable est bien connectée au widget. 

La variable s'affiche bien dans le widget qu'on a ici créé, Label. 

Après plus tard quand vous verrez dans une vidéo prochaine le positionnement des éléments, vous pourrez comme ça influer sur ce que vous affichez donc ça c'est une partie de ce que je vous ai appris, de ce que je vous montre. 

Et là effectivement c'est bien confirmé ici. 
```py
    Label : Coucou
```
C'est ça qui est important, c'est que ça.
```py
    var_label.set("Coucou")
```
Elle va remplacer l'option text par défaut. 

Donc si vous faites juste ça.
```py
    print("Label :", var_label.get())
```
Si vous faites juste ça, tout simplement ça remplace text qui s'affiche bien sur l'interface. 

C'est super important pour la suite, si vous avez compris ça, jusqu à présent vous avez tout comprendre pour la suite parce que c'est vraiment pas plus compliqué que ça. 

C'est aussi simple que ça, pourquoi il n'y a vraiment rien de plus à savoir donc c'est très facile à utiliser.

Donc il faut utiliser textvariable pour notamment ce cas-là, pour le label.

Donc vous verrez qu'il y a une autre option pour certains types particulier mais on va en parler un petit peu après. 

Sinon grosso modo, que ce soit pour les Labels, pour les Emptry, pour les Button, pour les CheckButton et pour les RadioButton, pour ce que je vous ai présenté jusqu à présent. Vous avez également Message et tout ça. Vous avez ensuite textvariable pour ce cas là. 

Après pour CheckButton et RadioButton, vous avez aussi une option équivalente qui est juste "variable".

Il y a 2 options possibles qui fonctionnent pareil donc on peut le voir en fonction textvariable et variable. 

Par contre attention, variable n'est pas disponible ici, il ne fonctionnera pas sur un Label en une Emptry.
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_label = tkinter.StringVar()
label = tkinter.Label(app, text="ddd", variable=var_label)

var_label.set("Coucou") ##
print("Label :", var_label.get())

label.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 340, in <module>
        label = tkinter.Label(app, text="ddd", variable=var_label)
      File "C:\...", line 3143, in __init__
        Widget.__init__(self, master, 'label', cnf, kw)
      File "C:\...", line 2567, in __init__
        self.tk.call(
    _tkinter.TclError: unknown option "-variable"
```
Voyez que là il n'est pas content parce qu'il n'y a pas d'option comme ça qui est connu d'ailleurs il le met ici "unknow option". 

Donc ça c'est important à savoir où il y a des cas particulier comme ça arec "textvariable". 

Alors ça c'est bien beau, on a fait des changements comme ça mais là au final c'est des choses que j'ai encore une fois modifiée dans le code. Est-ce que je peux synchroniser tout ça pour avoir quelque chose qui fonctionne ensemble ? alors je ne vais pas vous montrer les autres types StrIntVar(), IntVar(), DoubleVar(), BooleanVar(). Je pense que si vous avez compris avec la chaîne de caractères, vous saurez faire pareil, je ne m'inquiètes pas avec un IntVar(). 

Vous pouvez très bien créer une SpinBox et puis ensuite la connecter avec une variable de type  int, ça peut être sympa pour récupérer un nombre merci donc ça vous pouvez l'utiliser comme vous voulez. 

Pour le booléen, quand c'est égal à vrai, ça ne vous retournera pas True, vous aurez 1 tout simplement. On aura 1 si c'est True et 0 si c'est False donc ça c'est aussi une petite particularité à savoir. 

Alors on va étoffer un petit peu ce code, et là on va faire quelque chose d'un peu mieux. Vous allez voir qu'on va le connecter en faisant quelque chose de très très simple. On va faire un var_entry = tkinter.Entry() donc on va connecter le champ de saisie au Label et on va utiliser un observeur.
```py
    var_entry = tkinter.Entry(app, ...
```
On va voir ce qu'est un observeur, c'est plein de mot mais finalement très simple.

Donc on le met sur un élément parent, le widget app, toujours pareil comme on a toujours fait et là je vais faire entry plutôt que var_entry.
```py
    entry = tkinter.Entry(app, textvariable=var_entry)
```
texvariable=var_entry permet de se connecter à une variable.
Cette variable var_entry, on va reprendre au dessus et on va la créer et on va faire pareil sauf que là, on va avoir notre type de variable, StringVar().
```py
    # Widgets...
    var_entry = tkinter.StringVar()
    entry = tkinter.Entry(app, textvariable=var_entry)
```
Donc notre type de variable parce que un Label, c'est quand même plus logiquement une chaîne de caractères en général. Et là le champ de saisie même si on met des nombres dedans ce serra quand même une chaîne de caractères.

Imaginez un formulaire d'inscription ou ce genre de chose ou de connexion, on récupérera une chaîne et on va travailler comme ça. 

Alors là je vais avoir 2 choses mais avant je ne vais pas oublier de mettre ceci, entry.pack(), on enlève set() et print() de Coucou et on va tester.
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_entry = tkinter.StringVar()
entry = tkinter.Entry(app, textvariable=var_entry)

var_label = tkinter.StringVar()
label = tkinter.Label(app, textvariable=var_label)

entry.pack()
label.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py

    +---------------------------+
    |          _____            |
    |         |_____|           |
    +---------------------------+
```
Et voilà, on test et voilà ce qu'on obtient c'est-à-dire un petit champ de texte et logiquement devrait avoir le label en-dessous qui par défaut vous le voyez, ne vaut rien. 

Donc si on veut que le label vale quelque chose, on fait comme on a fait tout à l'heure.
```py
    var_label.set("Le label...")
```
alors je vais le laisser parce que c'est vrai que si on ne l'a pas affiché, ce ne sera peut être pas super pour vous au niveau visuel.
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_entry = tkinter.StringVar()
entry = tkinter.Entry(app, textvariable=var_entry)

var_label = tkinter.StringVar()
label = tkinter.Label(app, textvariable=var_label)
var_label.set("Le label...")

entry.pack()
label.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py

    +---------------------------+
    |          _____            |
    |         |_____|           |
    |          Le label...      |
    +---------------------------+
```
Voilà, c'est déjà mieux, vous avez le champ de saisie, le Entry, et le label… très pratique. 

Donc là si je tape quelque chose dans mon champ de saisie "ffffreeee", on voit qu'il n'y a absolument rien, il n'y a aucune interaction, rien du tout, rien n'est connecter.  Aucune réaction, tout ce que l'on fait c'est juste du visuel et là en termes de programmation honnêtement, il ne se passe rien. 

Vous voyez qu'on a interne il ne se passe rien en interne sur le terminal, il ne se passe rien sur l'interface graphique. De toute façon ici le code ne fait rien donc ce n'est pas magique, on ne va pas créer des choses comme ça. 

C'est pas de la magie, c'est de l'informatique. 

On va du coup connecter tout ça. 

Pour connecter ça on va utiliser ce qu'on appelle, un observeur. 

Alors je ne rentrerai pas dans le cas des Design Patern, d'accord, les patrons de conception. Il y aura quelque chose ou il y a déjà des vidéos là-dessus sur la chaîne. 

Mais vous avez en tout cas une partie qu'on appelle un observateur donc un observeur qui va en fait observer l'état d'une partie d'un programme mais je ne rentrerai pas encore une fois dans les détails pour rester simple, et quand l'état de l'objet qui est en fait surveillé changes, et bien il va avertir, il va notifier qu'il a changé. 

Et l'observeur comme ils observent tout, imaginez quelqu'un qui a une caméra qui est braqué sur vous, dès qu'il voit qu'il y a un changement, il va pouvoir se mettre du coup à jour en fonction. 

L'observeur va pouvoir faire quelque chose en fonction de ce qui s'est passé. 

Et donc en python c'est ce que nous allons créer dans cette vidéo, nous allons faire tout simplement une petite fonction qui va agir comme un observer, et après on va le connecter aux différentes variables que l'on voudra mais ça je vais vous l'expliquer. 

Alors on va juste faire parce que le but ce n'est pas de faire quelque chose de très compliqué, je vais mettre update_label(), je vais l'appeler comme ça. C'est un nom que je vais lui donner mais vous pouvez l'appeler comme vous voulez par contre attention quand vous créez un observé c'est bien de lui mettre cet argument là, *args, c'est-à-dire pour accepter tout un tas d'arguments mais ça on en avait déjà parlé je ne reviens pas dessus. 
```py
    def update_label(*args):
```
Si vous ne comprenez pas cette partie là, revoyez la vidéo sur les fonctions où tout est expliqué.

Et là on va juste lui dire que mon champ que j'avais mis du coup pour la modification, on va pouvoir le modifier donc var_label, tu vas le modifier set() en lui mettant la valeur qui est stockée, en ce moment, à un moment précis, dans var_entry point get(), voilà tout ce qu'on fait.
```py
    def update_label(*args):
        var_label.set(var_entry.get())
```
Donc ça, `var_label.set(var_entry.get())` , vous êtes d'accord en temps normal qu'est-ce qu'il se passerait si je mets le Label ? ça va nous mettre quelque chose. La valeur sera changée. 

Alors on peut tester éventuellement comme ça même si de toute façon vous n'allez pas avoir grand-chose.
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

def update_label(*args):
   var_label.set(var_entry.get())

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_entry = tkinter.StringVar()
entry = tkinter.Entry(app, textvariable=var_entry)

var_label = tkinter.StringVar()
label = tkinter.Label(app, textvariable=var_label)
var_label.set("Le label...")

entry.pack()
label.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py

    +---------------------------+
    |          _____            |
    |         |_____|           |
    |          Le label...      |
    +---------------------------+
```
C'est pour montrer les étapes pour ne pas aller trop vite mais vous voyez qu'il n'y a aucun changement, je peux écrire "ffmmmee" ça ne fait rien. 

Ça montre bien que juste créer une fonction comme ça, ne va pas faire les choses de manière magique, il va falloir la connecter. 

Et pour ça nous allons tracer parce que le serveur va enfaite tracer, traquer une variable, c'est comme ça qu'il doit fonctionner donc une variable spécifique de tkinter pour surveiller son comportement surveiller son état et là en l'occurrence son état c'est quoi ? et bien c'est sa valeur. 

Si la valeur change, Eh bien vous voyez on va faire tout ce qu'il y a dans la fonction ici, var_label.set(var_entry.get())
```py
    # Observateur
    def update_label(*args):
        var_label.set(var_entry.get())
```
Donc ça c'est le observeur, je vais l'appeler l'observateur, on va rester sur des termes français, ce sera plus clair pour vous pour beaucoup. 

Donc ça c'est notre observateur cette petite fonction donc elle est très simple, tout ce qu'elle va faire, c'est que à chaque fois qu'elle va voir qu'il y a un changement … vous verrez plus tard ou aura lieu ce changement, on verra en fonction … et là où on va la connecter, elle va modifier la valeur de mon label, var_label parce qu'il a été mis dans le champ de saisie, var_entry.

La connexion se fera tout simplement de la manière suivante, déjà c'est de savoir ce qu'on veut connecter. Moi ce que je veux surveiller, c'est ce qui est entré dans le champ de saisie parce que c'est en fonction de ce qu'il y aura dans le champ de saisie que le label va être modifié. 

Donc il faut bien penser à ça, c'est peut être un souci que vous aurez dès le début, c'est que vous ne serez pas forcément où mettre l'observeur. Est-ce que je dois le mettre sur tel widget ou tel widget?  

Il suffit de dire qu'est-ce que je surveille? Qu'est-ce qui est important ? Qu'est-ce que j'attends ? j'attends que l'utilisateur saisisse quelque chose et en fonction de ce qui est saisi, automatiquement en temps réel, je veux pouvoir modifier le label. 

Je veux que ce soit en temps réel, je ne veux pas que ce soit en différé. 

Donc c'est lui que je vais surveiller, le fameux var_entry et je rappelle que ça se fait sur une variable. 

Il suffit de noter le nom de la variable var_entry et vous utilisez simplement une méthode dessus qui est la méthode trace().
```py
    # Widgets...
    var_entry = tkinter.StringVar()
    var_entry.trace()
    entry = tkinter.Entry(app, textvariable=var_entry)
```
Alors trace(), je crois qu'il y a aussi un alias qui est trace_variable() mais c'est à vérifier aussi mais on peut toujours utiliser trace(), c'est très court à écrire, et on va pouvoir y inscrire des informations. 

La première information, ça va être le mode, et la 2e information ce sera là où on le Connect au niveau de la fonction mais on en parlera après.
```py
    # Widgets...
    var_entry = tkinter.StringVar()
    var_entry.trace("", )
    entry = tkinter.Entry(app, textvariable=var_entry)
```
Le mode c'est très simple aussi vous avez quelques cas possible, où bien vous mettez un "r" et dans ce cas-là l'observateur, l'observeur va être rappelé donc la fonction update_label(), elle va être appelée à chaque fois que la variable ici, var_entry, sera lue donc nous ce n'est pas ce qui nous intéresse parce qu'on a dit que quand on va saisir quelque chose, on veut à ce moment-là appeler l'observateur donc on va utiliser plutôt le mode "w". 

"w" permet d'appeler l'observateur quand la variable est modifiée et ça c'est important. 

On a aussi un mode undifined donc le mode "u" qui servira lorsqu'on va supprimer la variable mais nous maintenant ne va pas faire de suppression. 

On a envie de faire quelque chose en temps réel donc on va pas s'occuper de la suppression pour le moment. 

Donc on va le mettre en mode W, et on dit ensuite quelle est la fonction, quelle est la méthode ou la fonction qui va permettre de faire … parce qu'on appelle la fonction de callback donc c'est une fonction d'appel qui va être en fait notifier quand on va modifier la variable qui est dans le champ de saisie … c'est notre petite fonction update_label tout simplement . 
```py
    # Widgets...
    var_entry = tkinter.StringVar()
    var_entry.trace("w", update_label)
    entry = tkinter.Entry(app, textvariable=var_entry)
```
Et là vous voyez, sur la variable ici var_entry, je surveille cette variable trace() en faisant l'appel de update_label si j'ai fait la modification de var_entry via ce mode là "w". 

J'espère que c'est suffisamment clair et normalement oui avec tout ce que je vous expliqué avant et on va voir au niveau résultats ce que ça donne. 
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Observateur
def update_label(*args):
   var_label.set(var_entry.get())

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_entry = tkinter.StringVar()
var_entry.trace("w", update_label)
entry = tkinter.Entry(app, textvariable=var_entry)

var_label = tkinter.StringVar()
label = tkinter.Label(app, textvariable=var_label)
var_label.set("Le label...")

entry.pack()
label.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py

    +---------------------------+
    |          _______          |
    |         |bonjour|         |
    |          -------          |
    |          bonjour          |
    +---------------------------+
```
Donc là, j'ai d'abord un label qui s'affiche "Le label…" et si je tape un mot "bonjour", je modifie en temps réel ce qu'il se passe au niveau du label tout simplement. 

Donc là par défaut j'avais mis une valeur, var_label.set("Le label..."), mais je ne suis pas obligé. Je peut très bien ne rien mettre du tout.

```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Observateur
def update_label(*args):
   var_label.set(var_entry.get())

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_entry = tkinter.StringVar()
var_entry.trace("w", update_label)
entry = tkinter.Entry(app, textvariable=var_entry)

var_label = tkinter.StringVar()
label = tkinter.Label(app, textvariable=var_label)

entry.pack()
label.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py

    +---------------------------+
    |          _______          |
    |         |bonjour|         |
    |          -------          |
    |          bonjour          |
    +---------------------------+
```
Alors je peux très bien ne rien mettre du tout par défaut parce que je considère qu'il n'y a rien par défaut dans mon label. 

Comme ça par défaut on a un programme et là on va pouvoir taper tout un tas d'informations. 
```powershell
    +-----------------------------------------------+
    |          __________________________________   |
    |         |bonjour tout le monde et bienvenue|  |
    |          ----------------------------------   |
    |          bonjour tout le monde et bienvenue   |
    +-----------------------------------------------+
```
On peut par exemple écrire "Bonjour à tous et bienvenue sur une nouvelle vidéo en Python", tout simplement vous allez pouvoir gérer ça de cette manière, on peut d'ailleurs faire "Bonjour à tous et bienvenue sur une nouvelle vidéo en Python blah blah blah blah blah blah blah blah", et la ligne va sortir de l'affichage de la fenêtre parce qu'on n'a pas gérer le retour à la ligne ou autre.

Bon ça pour le label je vous l'avais déjà dit, il va s'inscrire comme ça sans retour à la ligne mais vous voyez que c'est vraiment géré en temps réel, il n'y a pas de différé ou autre. 

C'est vraiment un observateur. 

L'observateur il réagit directement dès que vous avez fait la moindre modification que ce soit un retrait, un ajout ou n'importe quoi, il appelle automatiquement la fonction update_label() qui agit comme un observateur. 

Et cet observateur Eh bien ça tombe bien, tu me changes la valeur, ce qui est affiché du coup par le label du coup au fur et à mesure que tu changes ce qui est mis dans le champ de saisie. 

Donc ça tombe bien les 2 sont connectés parfaitement et du coup on peut faire ce genre de modifications en temps réel. 

Donc c'est plutôt pratique. 

C'est quelque chose qui vous plaira dans vos développements à venir en tkinter donc n'hésitez pas à mettre ça en pratique dans de petits exercices, dans de petits programmes, ça va certainement beaucoup vous servir. 

Et surtout mettez en pratique dans d'autres modes, mode de lecture, mode avec d'autres types de variables, avec d'autres types de widgets aussi mais moi j'ai pris cet exemple là parce que je trouve que c'est vachement parlant avec un petit champ de saisie. On tape quelque chose et ça affiche le texte, ce qui est relativement simple à expliquer dans cette vidéo et pour vous je pense que ce sera simple également à comprendre. 

Voilà voilà donc ça je pense que c'était la partie relativement importante mais je peux éventuellement vous montrer un autre exemple pourquoi pas. Je peux vous montrer avec les CheckBox et les RadioBox, les CheckButton et les RaioButton pour pas se tromper dans les noms. 

Ça peut être pas mal aussi de travailler là-dessus donc on va faire print("J'ai vu !") dans la méthode pour dire que l'observateur il a vu. Et je vais virer également toute la partie widgets…
```py
    #coding:utf-8
    import tkinter

    """
    StringVar()     : chaine de caractères [str]
    IntVar()         : nombre entier [int]
    DoubleVar()     : nombre flottant [float]
    BooleanVar()    : booléen [bool]
    """

    # Observateur
    def update_label(*args):
        print("J'ai vu !")

    # Création et paramètrage de la fenêtre
    app = tkinter.Tk()
    app.geometry("400x300")
    app.title("Variables tkinter")

    # Widgets...


    # Boucle principale
    app.mainloop()
```
Et ce qu'on va faire c'est radio1 = tkinter … On va mettre un radio parce qu'il est assez casse-pied à comprendre. Check il est très simple si vous avez compris radio, check vous serez l'utiliser facilement. 

Les boutons radio c'est, si vous vous souvenez, c'est on a un choix obligatoire et on ne peut en sélectionner qu'un seul parmi la liste. On ne peut pas en sélectionner plusieurs ou alors aucun.
```py
    radio1 = tkinter.Radiobutton(app, text="Homme")
```
Donc là on va faire Radiobutton et on va mettre un peu de texte, rappelez-vous on avait mis ce genre de choses-là text="Homme" et déjà on va faire ça ce sera déjà pas mal.Ensuite radio2 et value=1 pour l'Homme mais si je met par exemple deux hommes, ça va être problèmatique. Et value=2 pour Femme. Et on termine avec radio1.pack() et radio2.pack().
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Observateur
def update_label(*args):
   print("J'ai vu !")

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
radio1 = tkinter.Radiobutton(app, text="Homme", value=1)
radio2 = tkinter.Radiobutton(app, text="Femme", value=2)

radio1.pack()
radio2.pack()

# Boucle principale
app.mainloop()
```
```powershell 
    >python main.py
    
        (*) Homme
        ( ) Femme
```
Donc là c'est bon je peux bien sélectionné qu'un seul des 2, j'ai le bon petit affichage à côté il n'y a donc pas de problème. 

Alors là pareil, je vous avais expliqué dans la vidéo précédente que en terme informatique il ne se passe rien c'est-à-dire qu'on a affiché c'est joli mais mais on fait rien niveau programmation, on a absolument rien. 

Donc ce qui peut être cool c'est de connecter notre petit observé avec quelque chose donc on va le connecter simplement ici. On va l'appeler var_gender et là c'est important d'avoir la même variable. 
```py
    # Widgets...
    var_gender =
    radio1 = tkinter.Radiobutton(app, text="Homme", value=1)
    radio2 = tkinter.Radiobutton(app, text="Femme", value=2)

    radio1.pack()
    radio2.pack()
```
Alors c'était 1 pour Homme et 0 pour  Femme, je ne vais pas mettre un booléen parce que ça fait bizarre de dire que c'est vrai ou faux, genre la femme c'est faux et l'homme c'est vrai ^^. 

Donc vas-y on va mettre 0 ou 1 mais on va le mettre comme un IntVar(), on va créer ça comme ça tout simplement. 
```py
    # Widgets...
    var_gender = IntVar()
    radio1 = tkinter.Radiobutton(app, text="Homme", value=1)
    radio2 = tkinter.Radiobutton(app, text="Femme", value=2)

    radio1.pack()
    radio2.pack()
```
Nous allons faire tracer ça par un observeur, var_gender.trace(), "w" car c'est une modificiation, et on va l'appeler update_observer pour garder un nom sympa, un nom un peut plus technique.
```py
    #coding:utf-8
    import tkinter

    """
    StringVar()     : chaine de caractères [str]
    IntVar()         : nombre entier [int]
    DoubleVar()     : nombre flottant [float]
    BooleanVar()    : booléen [bool]
    """

    # Observateur
    def update_observer(*args):
        print("J'ai vu !")

    # Création et paramètrage de la fenêtre
    app = tkinter.Tk()
    app.geometry("400x300")
    app.title("Variables tkinter")

    # Widgets...
    var_gender = tkinter.IntVar()
    var_gender.trace("w", update_observer)
    radio1 = tkinter.Radiobutton(app, text="Homme", value=1)
    radio2 = tkinter.Radiobutton(app, text="Femme", value=2)

    radio1.pack()
    radio2.pack()

    # Boucle principale
    app.mainloop()
```
Voilà on va l'appeler comme ça update_observer, et il l'aura vu à chaque fois. 

Et du coup on oublie pas de connecter la variable var_gender donc là variable ici, je l'avais dit pour Radiobutton et Checkbutton, ce n'est pas textvariable mais c'est variable tout court.
```py
    # Widgets...
    var_gender = IntVar()
    var_gender.trace("w", update_observer)
    radio1 = tkinter.Radiobutton(app, text="Homme", value=1, variable=var_gender)
    radio2 = tkinter.Radiobutton(app, text="Femme", value=2, variable=var_gender)

    radio1.pack()
    radio2.pack()
```
`variable=var_gender`, donc attention il faut les connecter à la même variable, tout simplement parce que si vous ne le faites pas, comment allez-vous faire pour surveiller ? 

Vous allez mettre un observeur pour homme et un observer pour femme ce n'est pas logique, autant mettre un observé pour les 2. 

Toute façon vous allez devant sélectionnez que un des 2 donc on est sûr qu'il n'y aura pas les 2 sélectionnés. 

Autant mettre un observé sur une seule variable et cette variable est communiquante si vous voulez avec les 2 types de boutons Radio que vous avez créé.

Et à partir de ce principe là …

/!\ Attention à ne pas oublier tkinter avant IntVar() sinon il faut faire un import un peu plus simplifié mais bon il faut prendre l'habitude de les écrire comme ça. Comme ça je vois que ça vient de tkinter et que IntVar() tu n'appartiens pas à n'importe quoi, il n'est pas tombé du ciel. 
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Observateur
def update_observer(*args):
   print("J'ai vu !")

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_gender = tkinter.IntVar()
var_gender.trace("w", update_observer)
radio1 = tkinter.Radiobutton(app, text="Homme", value=1, variable=var_gender)
radio2 = tkinter.Radiobutton(app, text="Femme", value=0, variable=var_gender)

radio1.pack()
radio2.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    
    (*) Homme
    ( ) Femme
    
        J'ai vu !
    
    ( ) Homme
    (*) Femme
        
        J'ai vu !
```
Et là Regardez ce qu'il se passe dans le terminal quand je change de choix, à chaque fois que je clique, l'observeur a bien vu ce qu'il s'était passé même s'il n'a pas envie de nous le dire ! ^^ 

Il continue de nous communiquer "J'ai vu !", il communique bien pour cette partie là donc ça c'est important.

Alors à ce moment-là qu'est-ce qu'on peut faire ? On va pouvoir afficher la donnée var_gender.get().
```py
    def update_observer(*args):
        print(f"Sexe : {var_gender.get()}")
```
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Observateur
def update_observer(*args):
   print(f"Sexe : {var_gender.get()}")

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_gender = tkinter.IntVar()
var_gender.trace("w", update_observer)
radio1 = tkinter.Radiobutton(app, text="Homme", value=1, variable=var_gender)
radio2 = tkinter.Radiobutton(app, text="Femme", value=0, variable=var_gender)

radio1.pack()
radio2.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    (*) Homme
    ( ) Femme
    
        Sexe : 1
        
    ( ) Homme
    (*) Femme
    
        Sexe : 0
```
var_gender.get(), alors qu'est-ce qu'il va nous donner ? Alors au début ça va faire un petit peu bizarre parce que rappelez-vous que ce sont que des entiers. 

Voyez quand ces Homme c'est 1 et quand ces Femme c'est 0 et cetera.

Donc vous pouvez gérer ça de manière un petit peu plus correct, il suffit tout simplement de faire un IF. On va juste faire if var_gender.get(): sans opérateur parce que de toute façon si c'est True ce sera juste. Si c'est bon on va dire que c'est un homme sinon, et on va faire un affichage très simple, c'est une femme. Et normalement c'est OK.
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Observateur
def update_observer(*args):
   if var_gender.get():
       print("C'est un homme")
   else:
       print("C'est une femme")

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_gender = tkinter.IntVar()
var_gender.trace("w", update_observer)
radio1 = tkinter.Radiobutton(app, text="Homme", value=1, variable=var_gender)
radio2 = tkinter.Radiobutton(app, text="Femme", value=0, variable=var_gender)

radio1.pack()
radio2.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    (*) Homme
    ( ) Femme
    
        C'est un homme
        
    ( ) Homme
    (*) Femme
    
        C'est une femme
```
Et là on le refait voilà on "c'est un homme" "c'est une femme" et cetera. 

Et je pense que vous avez compris le principe de l'observateur, de l'observeur, vous voyez un petit peu son fonctionnement. Il va se connecter … imaginez si à ce stade de la vidéo ce n'est pas suffisamment clair, imaginez une caméra, quelqu'un qui mettrait une caméra sur vous et qui attend qu'il se passe la moindre chose soit que vous êtes en train d'essayer d'agir soit que vous êtes en train de modifier quelque chose, et à partir de là il va procéder à un ensemble de traitement d'instruction. 

Donc il va faire quelque chose justement si il le voit je pense qu'il y a un changement ou alors qu'il y a quelque chose qui se passe. 

Un observeur, c'est une caméra qui surveille et qui va comme ça, suivant un changement de comportement ou autre, une situation particulière, faire un ensemble de choses.

Et nous les choses qu'il fait, c'est ce qu'on met dans cette petite fonction ici, update_observer, qui est connecté grâce à la méthode trace() sur une variable tkinter donc ça c'est important. 

Alors après c'est pareil si on veut aller plus loin et je pense qu'on terminera avec ça. 

On peut très bien créer une StringVar() sans oublier le tkinter au début.
```py
    var_label_gender = tkinter.StringVar()
    label_gender = tkinter.Label(app, textvariable=var_label_gender)
```
Et bien c'est pareil, qu'est-ce qui va se passer ? on a d'abord ce type de variable "var_gender" qui est surveillé, pas de problème. 

Par contre on n'a pas là variable ici "var_label_gender" et ça c'est important aussi. 

On va pouvoir éventuellement modifier notre variable pour l'afficher au niveau de notre code. 

Alors on pourrait tester … admettons je retires IF et ELSE, on n'en veut pas. Mais je le garde quand même et je le modifie.

Et je n'oublie pas label_gender.pack().
```py
#coding:utf-8
import tkinter

"""
StringVar()     : chaine de caractères [str]
IntVar()         : nombre entier [int]
DoubleVar()     : nombre flottant [float]
BooleanVar()    : booléen [bool]
"""

# Observateur
def update_observer(*args):
    if var_gender.get():
        var_label_gender.set("C'est un homme")
    else:
        var_label_gender.set("C'est un femme")

# Création et paramètrage de la fenêtre
app = tkinter.Tk()
app.geometry("400x300")
app.title("Variables tkinter")

# Widgets...
var_gender = tkinter.IntVar()
var_gender.trace("w", update_observer)
radio1 = tkinter.Radiobutton(app, text="Homme", value=1, variable=var_gender)
radio2 = tkinter.Radiobutton(app, text="Femme", value=0, variable=var_gender)

var_label_gender = tkinter.StringVar()
label_gender = tkinter.Label(app, textvariable=var_label_gender)

radio1.pack()
radio2.pack()
label_gender.pack()

# Boucle principale
app.mainloop()
```
```powershell
    >python main.py
    (*) Homme
    ( ) Femme
    C'est un homme
        
    ( ) Homme
    (*) Femme
    C'est un femme
```
Et vous voyez que la connexion se passe tranquillement. 

Comme on a créé ça dans le code principal, c'est toujours une histoire de portée, il n'y a pas de souci. 

Je rappelle que l'observateur c'est juste une fonction comme ça toute seule donc elle peut utiliser ça, elle va pouvoir en fonction interagir avec d'autres choses. 

Donc là je modifie une variable, ici là variable pour le label, var_label_gender, et du coup plutôt que d'avoir un affichage ici en ligne de commande parce qu'on pourrait considérer que dans notre programme on n'en aura pas. Eh bien on peut afficher un changement directement sur l'interface graphique, et c'est du coup quand même plus sympa, voilà. 

Ce qu'on a fait tout à l'heure en console, on vient de le déporter en fait directement sur l'interface graphique, ce qui est quand même plus agréable et plus dans l'air de ce qu'on est en train de voir actuellement en vidéo. 

Je pense que je me arrêterai là, j'ai fait le tour de ce que je voulais vous montrer. 

Après on peut toujours supprimer l'observeur si jamais vous en avez besoin, c'est la méthode vedelete().
Dans le cas où par exemple vous voulez supprimer update_observer(), vous ferez trace_vedelete() et prendra en paramètre donc le mode et le nom de l'observateur pour le supprimer. Le mode par exemple ça peut être utilisé pour n'importe quoi, je mets "u" n'importe quoi on s'en fou et vous mettez le nom de l'observateur. Ce genre de chose, vous pourrez le supprimer.
```py
    # Widgets...
    var_gender = tkinter.IntVar()
    var_gender.trace("w", update_observer)
    radio1 = tkinter.Radiobutton(app, text="Homme", value=1, variable=var_gender)
    radio2 = tkinter.Radiobutton(app, text="Femme", value=0, variable=var_gender)

    var_label_gender = tkinter.StringVar()
    label_gender = tkinter.Label(app, textvariable=var_label_gender)

    trace_vedelete("u", update_observer)

    radio1.pack()
    radio2.pack()
    label_gender.pack()
```
Vous pouvez également afficher des informations sous forme de liste avec trace.veinfo(), c'est parti c'est pareil pour afficher les informations concernant l'observateur et tout ça. À voir ça peut être sympa pour faire des log, ce genre de chose, quand on veut avoir un historique de ce que à observé l'observeur. 

Ça peut servir mais je ne vais pas forcément tout vous montrer parce que c'est juste impossible de toute façon de tout vous montrer, les méthodes, les variables, les fonctions de chaque notion donc je vous laisse toujours un petit peu d'autonomie pour que vous prenez l'habitude et que vous ayez le réflexe d'aller voir par vous-même aussi dans les documentations et tout ça parce que de toute façon vous serez amené à faire ça en informatique sinon vous ne prenez pas l'habitude d'aller voir des méthodes, d'aller vous renseigner sur les sources même, original sur les langages, sur les technos, vous n'arriverez pas vraiment à progresser parce que vous n'arriverez pas à tout retenir par coeur. 

Vous ne pourrez pas savoir tout sur tout. 

Ce n'est pas possible de connaître toute une classe, toutes ces spécificités, ces constantes et tout ça. 

Il y en a forcément que vous n'utilisez pas ou que vous n'utiliserai pas donc automatiquement c'est bien de toujours consulter les documentations quand on a besoin d'un casque spécifique pour dire tiens on peut faire ça en plus avec ce widget ou tiens on peut faire ça en plus avec ce type de classe. 

Voilà voilà pour tout le monde, j'espère que ça a été suffisamment clair parce que ce n'est pas forcément évident à expliquer non plus mais c'est quand même sympa, vous allez pouvoir faire des choses un peu plus intéressante au niveau des interfaces maintenant que vous connaissez un bon ensemble de widgets. 

Vous en avez peut-être appris entre-temps via la documentation comme je vous l'avais conseillé, et que vous savez également manipuler utiliser un observeur pour pouvoir manipuler des variables, à savoir rendre les choses beaucoup plus simple. 

Mais je pense que vous allez pouvoir vous entraîner là-dessus, vous exercez. 

Moi je vous retrouve pour la prochaine fois pour la prochaine vidéo, je pense qu'on abordera le positionnement des éléments, vous savez tout ce qu'on faisait ici avec pack() mais on sait pas trop interné là-dessus. 

Et je vous avais dit en introduction de tkinter, qu'on verrait par la suite.

Je crois que la prochaine vidéo ce sera le moment de voir ça c'est à dire tout ce qui est le positionnement de widget, c'est-à-dire qu'il ne faut pas les mettre n'importe où comme ça au pif, l'un sur l'autre, mais les positionner exactement sur notre interface pour avoir quelque chose qui nous correspond et qui nous plaît. 

À bientôt tout le monde, bon apprentissage sur cette formation et on se retrouve très vite pour la séance 24. 

Ciao