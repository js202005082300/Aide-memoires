# [Événements tkinter](https://www.youtube.com/watch?v=yZp6958SkVI)

+ [bind](#bind)
+ [bind_class](#bind_class)
+ [bind_all](#bind_all)
+ [Gérer la fermeture d'une fenêtre](#Gérer-la-fermeture-d-une-fenêtre)
    + [Destroy](#Destroy)
    + [Escape](#Escape)
+ [event_add](#event_add)

Tutoriel pour utiliser le module tkinter tel qu'on a pu le faire précédemment avec le module pygame.

Pour ce tutoriel il faut au moins avoir été voir les vidéos du cours concernant les widgets.

Par définition, un événement concerne ce qui va être déclenché lors de l'exécution de notre programme ici de notre application. En gros vous appuyez sur une touche de votre clavier comme cliquez sur votre souris ou déplacer la molette de votre souris même lorsque vous déplacer où redimensionner une fenêtre, c'est un événement qui se déclenche et on va pouvoir le traiter, on va pouvoir exécuter tout un tas d'instructions et cetera.

Commençons d'abord par créer une petite application tkinter toute simple.

+ main.py
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()
app.geometry('320x240')

entry_w = tkinter.Entry(app)

entry_w.pack()
app.mainloop()
```

Voilà ça ouvre une petite fenêtre et il faut noter qu'un événement est en train de se dérouler à chaque fois que je clique dans le champ ou à l'extérieur du champ ou simplement en train de passer sur le champ ou que je prends le focus sur le champ (cliquez dedans) ou quand je saisis un caractère ou quand je déplace la fenêtre et cetera. Ce sont tout seuls à des événements et on va pouvoir en capturer certains et traiter ces différents événements avec notre gestionnaire.

## bind

Moi j'aimerais que quand on appuie sur la touche a, un a minuscule, afficher un petit message pour dire qu'on a appuyé sur la touche en question. Notez que pour cela il y a plusieurs manières et on va en voir 3 durant ce tutoriel pour gérer nos événements, la première c'est de gérer nos événements sur un widget bien précis qu'on a défini au niveau de notre code et qu'on a mémorisé dans une variable donc en l'occurrence `entry_w` dans notre exemple donc je prends ce dernier je vais utiliser une méthode qui s'appelle bind() et qui va prendre 2 arguments le premier étant le symbole tu vas représenter l'événement à capturer `' '`, et en 2e une fonction de rappel, une call back donc une fonction qui va être rappelé une fois que cet événement sera déclenché.

```py
entry_w.bind('', func)
```

On a déjà manipulé ce genre de système quand on manipulait de widget de bouton par défaut avec le widget *button* auquel on rattaché une application avec une valeur qui représentait le texte affiché sur le bouton et ensuite il y avait un argument *command* qui permettait de spécifier une fonction ainsi dés qu'on cliquait sur un bouton ça déclenchait un événement de clic. Et cet événement fait appel à notre fonction et on pouvait par exemple afficher.

On l'avait déjà vu sur le court mais le problème c'était propre et géré par défaut par les boutons mais pas forcément pour les autres types de widgets et pas forcément pour des comportements on va dire plus globaux, et pour des choses bien plus spécifiques donc ici on va appeler une fonction func() qui va prendre ton paramètre un objet `event` qui nous servira éventuellement à récupérer certaines informations de ce qui a déclenché l'événement mais ça on le verra un peu plus tard et on va simplement écrire le message `"La touche [A] a été pressée"`.

+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    print("La touche [A] a été pressée")

app = tkinter.Tk()
app.geometry('320x240')

entry_w = tkinter.Entry(app)
entry_w.bind('', func)

entry_w.pack()
app.mainloop()
```

Alors pour représenter les événements déclenchés nous allons encapsuler ce symbole dans des chevrons `<>` dans la fonction bind(). Alors les évènements vous en avez plein, vous avez des événements pour une touche sur laquelle vous avez appuyé, au moment où nous relâchons une touche de clavier, au moment où on fait une combinaison de touches par exemple si on a appuyez sur 3 touches en même temps ou alors on a appuyé sur 2 touches rapidement en même temps, ou 3 fois peu importe, on clique sur la souris, on déplace une fenêtre.

Pour une simple utilisation de toucher par exemple la touche a minuscule, je vais mettre cette information là `<a>`.

+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    print("La touche [A] a été pressée")

app = tkinter.Tk()
app.geometry('320x240')

entry_w = tkinter.Entry(app)
entry_w.bind('<a>', func)

entry_w.pack()
app.mainloop()
```

Voilà on peut parfaitement capturer le a minuscule ainsi cet événement qui a été déclenché va appeler la fonction func() et on aura effectivement l'appel qui aura été fait.

On peut également spécifier des choses comme *KeyPress* qui permet de bien indiquer qu'on a appuyé sur une touche et donc on met un `<KeyPress-a>` c'est juste que si vous mettez le a tout seul, par défaut le comportement cette touche pressée mais on peut vouloir gérer également le relâchement d'une touche comme événement c'est pour ça que c'est peut être plus intéressant de vouloir passer par ce genre de syntaxe et donc si vous voulez gérer un relâchement de touches c'est mieux de passer par le mot-clé *KeyRelease*.

```py
entry_w.bind('<KeyPress-a>', func)
entry_w.bind('<KeyRelease-a>', func)
```

Alors cet important mais n'oubliez pas qu'en informatique tout ce qui est minuscule et majuscule ont leur importance donc n'oubliez pas de mettre le K et le P et le R en majuscule sinon vous aurez des problèmes à l'exécution et ça ne marchera pas.

Par exemple, l'option `<KeyRelease-a>` signifie que quand on relâche la touche, on vient de faire un a minuscule.

+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    print("La touche [A] a été pressée")

app = tkinter.Tk()
app.geometry('320x240')

entry_w = tkinter.Entry(app)
entry_w.bind('<KeyRelease-a>', func)

entry_w.pack()
app.mainloop()
```
```powershell
> python main.py
La touche [A] a été pressée
La touche [A] a été pressée
La touche [A] a été pressée
```

Dès qu'on a relâché en a minuscule dans la fenêtre tkinter, on affiche notre texte dans le terminal mais si on utilise le A majuscule ça ne marche pas.

Par exemple on peut également gérer le clic gauche de la souris avec l'option `'<Button-1>'`, avec un 2 c'est pour le clic droit `'<Button-2>'`, avec un 3 c'est pour le clic du milieu `'<Button-3>'` notamment celui de la molette.

Pour le pavé numérique on met KP en majuscule, underscore suivi du caractère par exemple suivi du chiffre 8 sur notre pavé numérique `'<KP_8>'`. `'<KP_Minus>'` pour le symbole moins (-). `'<KP_Enter>'` pour la touche entré du clavier également du pavé numérique à la différence de la partie du clavier principale car on a pas forcément de pavé numérique sur notre clavier. Puis la touche échappe `'<Escape>'`, puis la touche d'espace `'<Space>'`, pour les touches contrôle `'<Control>'` donc les ctrl, puis la touche alt `'<Alt>'`, puis la touche shift ou majuscule `'<Shift>'` et cetera.

Voilà on a tout un tas de symboles, de clés qui permettent d'identifier l'événement en particulier que vous voulez traiter.

Maintenant on peut en associer plusieurs par exemple Ctrl+Alt+a donne `'<Control-Alt-a>'`

+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    print("La touche [A] a été pressée")

app = tkinter.Tk()
app.geometry('320x240')

entry_w = tkinter.Entry(app)
entry_w.bind('<Control-Alt-a>', func)

entry_w.pack()
app.mainloop()
```
```powershell
> python main.py
La touche [A] a été pressée
La touche [A] a été pressée
La touche [A] a été pressée
```

Tant que je n'ai pas fait la combinaison de touches Ctrl+Alt+a, je n'aurai pas l'événement qui sera traité. Si maintenant je reste appuyer sur Ctrl+Alt puis que j'appuie sur a en répétition, on aura l'événement qui sera bien traité.

On peut comme ça travailler sur des combinaisons de touches sans problème.

On peut aussi faire ceci `'<Double-a>'` en appuyant 2 fois sur la touche à on déclenche un événement mais à condition que ce soit dans un court laps de temps, on pourrait faire ça par exemple pour un double clic.

+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    print("La touche [A] a été pressée")

app = tkinter.Tk()
app.geometry('320x240')

entry_w = tkinter.Entry(app)
entry_w.bind('<Double-a>', func)

entry_w.pack()
app.mainloop()
```
```powershell
> python main.py
La touche [A] a été pressée
La touche [A] a été pressée
La touche [A] a été pressée
```

Voilà si je clique 2 fois rapidement sur la touche a, on a un double clic mais par contre si je laisse un petit temps entre 2 appuis sur la touche a donc pour lui ce sera un double et ça fonctionnera.

Maintenant on va essayer de jouer sur le double clic gauche en faisant ceci `'<Double-Button-1>'`.

+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    print("OK")

app = tkinter.Tk()
app.geometry('320x240')

entry_w = tkinter.Entry(app)
entry_w.bind('<Double-Button-1>', func)

entry_w.pack()
app.mainloop()
```
```powershell
> python main.py
OK
OK
OK
```

Voilà pour la méthode bind() donc on n'a pas la liste des symboles complets mais il suffit d'aller sur la documentation officielle rattachée aux symboles pour les événements avec Tkinter et notamment en utilisant la fonction help() qu'on utilise déjà en Python qui permet de récupérer pas mal d'informations sur pas mal de modules et plein d'outils que l'on utilisant python.

Une autre manière est que l'on peut spécifier n'importe quel touche en faisant ça `'<Key>'` et `'<Button>'` permet de capturer n'importe quel clic de la souris.

```py
entry_w.bind('<Key>', func)
entry_w.bind('<Button>', func)
```

Voilà on peut faire des choses beaucoup plus génériques plutôt que spécifier une touche en particulier.

On peut également au lieu de faire une capture et une gestion d'évènements sur le budget précis notamment notre champ de texte `tkinter.Entry(app)` mais je peux le faire sur une classe complète c'est à dire un type complet de widget. De dire par exemple que tous les widgets qui sont des champs de saisie, je vais pouvoir faire quelque chose.

Alors il faut noter qu'on peut mettre n'importe quel widget avec la méthode bind() tel que celui de l'application (app), de la fenêtre.

```py
entry_w.bind('', func)
app.bind('', func)
#...
```

## bind_class

Ainsi au lieu d'utiliser un bind(), vous utiliser un bind_class() et on a un premier argument qui change qui est la classe du widget `'Entry'` et il va prendre en compte tout le champ de texte de notre application. Et tout les champs de texte liés à un double clic appelerons cette fonction func().

```py
app.bind_class('Entry', '<Double-Button-1>', func)
```
+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    print("OK")

app = tkinter.Tk()
app.geometry('320x240')

entry_w = tkinter.Entry(app)
app.bind_class('Entry', '<Double-Button-1>', func)

entry_w.pack()
app.mainloop()
```

La fonction func() sera appeler peu importe le champ de texte, ce n'est que pour les champs de texte.

Voilà pour la 2e manière de procéder.

## bind_all

La 3e manière c'est si on veut pouvoir traiter des événements sur l'ensemble de l'application c'est à dire tous les bridges quel qu'il soit peu importe leur type ou peu importe leur classe, et s'appelle bind_all() comme ceci.

```py
app.bind_all('<Double-Button-1>', func)
```
+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    print("OK")

app = tkinter.Tk()
app.geometry('320x240')

entry_w = tkinter.Entry(app)
app.bind_all('<Double-Button-1>', func)

entry_w.pack()
app.mainloop()
```

À partir du moment où on fait un double clic, ça appellera la fonction func(). L'événement sera bien déclenché donc on va avoir cette Call back qui sera exécuté. Ça c'est vraiment pour tous les widgets et dire que pour n'importe quel widget de mon application donc si tel événement se produit je veux qu'il se passe tel traitement.

À vous de voir mais vous avez comme ça 3 méthodes.

bind() pour un widget bien spécifique, bind_class() pour une classe de widget et bind_all() pour tous les widgets de notre application donc 3 manières de procéder.

On va voir un exemple avant de passer à la création de nouveaux événements, en tout cas de nouveau déclencheur.

Alors on va commencer par créer un bouton.

```py
button_w = tkinter.Button(app, text = 'Ouvrir une fenetre', command = openwindow)
```

On retourne le comportement des événements, sachant que `command` est géré par défaut avec Tkinter et bien noté qu'on n'a plus un champ de texte donc on va remplacer notre champ de texte `entry_w.pack()` par un bouton `button_w.pack()`. 

```py
button_w = tkinter.Button(app, text = 'Ouvrir une fenetre', command = openwindow)
#...
button_w.pack()
```

Cette commande liée à notre fonction openwindow() que l'on crée ces dessous et ça on l'a déjà vu dans le cours c'est à dire qu'on va créer une nouvelle fenêtre, on va faire une Toplevel() mais attention ici c'est un l minuscule ici `top = tkinter.Toplevel()` ensuite on crée un label que l'on va rattacher à top et qui aura un texte par exemple 'Bonjour', `label_w = tkinter.Label(top,text = 'Bonjour')`. Et enfin on n'oublie pas de pack() tout ça, `label_w.pack()`.

+ main.py
```py
#coding:utf-8
import tkinter

#def func(event):
#    print("OK")
def openwindow():
    top = tkinter.Toplevel()
    label_w = tkinter.Label(top, text = 'Bonjour')
    label_w.pack()

app = tkinter.Tk()
app.geometry('320x240')

button_w = tkinter.Button(app, text = 'Ouvrir une fenetre', command = openwindow)

button_w.pack()
app.mainloop()
```
```powershell
> python main.py
```

Voilà cela ouvre notre fenêtre Tkinter, avec un bouton Ouvrir une fenêtre qui permet d'ouvrir une nouvelle fenêtre avec un petit message Bonjour.

## Gérer la fermeture d une fenêtre

### Destroy

Maintenant ce qu'on va vouloir faire c'est pouvoir gérer la fermeture de cette nouvelle fenêtre alors on a pour ça 2 manières, la première ça va être de passer par le label `label_w.bind('')` et dire que je veux traiter un événement bien particulier avec cette fonction bind() c'est-à-dire l'événement qu'à la fermeture de la fenêtre donc le fameux `'<Destroy>'` qui est le symbole à utiliser `label_w.bind('<Destroy>')` et pour ça je veux qu'il appelle une fonction `label_w.bind('<Destroy>', func)`.

```py
    def openwindow():
        top = tkinter.Toplevel()
        label_w = tkinter.Label(top, text = 'Bonjour')
>       label_w.bind('<Destroy>', func)
        label_w.pack()
```

Voilà une simple fonction pour gérer l'événement et a indiqué que la fenêtre a été fermée.

```py
def func(event):
    print("La fenêtre a été fermée")
```

Voilà nous allons exécuter cela.

+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    print("La fenêtre a été fermée")

def openwindow():
    top = tkinter.Toplevel()
    label_w = tkinter.Label(top, text = 'Bonjour')
    label_w.bind('<Destroy>', func)
    label_w.pack()

app = tkinter.Tk()
app.geometry('320x240')

button_w = tkinter.Button(app, text = 'Ouvrir une fenetre', command = openwindow)

button_w.pack()
app.mainloop()
```
```powershell
> python main.py
La fenêtre a été fermée
```

Voilà on a notre fenêtre qui s'ouvre avec toujours le bouton Ouvrir une fenêtre, je clique dessus on a une petite fenêtre qui s'ouvre (d'ailleurs on devrait penser à redimensionner parce qu'elle est trop petite.) Et nous avons l'élément qui a bien été indiqué dans le terminal.

Voyez qu'il y a bien l'événement Destroy qui a été déclenché parce que c'est une destruction de fenêtres quand on parle de fermeture de fenêtre et ça bien été traité et géré par notre Call back `def func(event): …` qui a été exécuté.

### Escape

Alors on peut se traiter ça autrement aussi, on peut dire qu'on ne gère pas la destruction directement (tel qu'on l'avait fait ici `'<Destroy>'`) mais cette fois l'événement qui m'intéresse c'est la touche échappe `'<Escape>'` donc quand on va appuyer sur la touche échappe, on va nous-mêmes fermer la fenêtre donc si je fais ça par défaut et que j'utilise la touche échappe ça ne quittera pas le programme bien évidemment.

:warning: attention je veux qu'on applique notre attribut sur la nouvelle fenêtre `top.bind('<Escape>', func)` et la fenêtre principale `label_w.bind('<Escape>', func)` donc sur top au lieu de label_w.

+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    pass

def openwindow():
    top = tkinter.Toplevel()
    label_w = tkinter.Label(top, text = 'Bonjour')
    top.bind('<Escape>', func)
    label_w.pack()

app = tkinter.Tk()
app.geometry('320x240')

button_w = tkinter.Button(app, text = 'Ouvrir une fenetre', command = openwindow)

button_w.pack()
app.mainloop()
```
```powershell
> python main.py
```

Voilà par défaut si je fais échap ça ne quitte pas le programme aussi bien sûr la fenêtre par défaut et pareillement pour la fenêtre qui s'ouvre, une autre fenêtre ouverte, même chose si je fais échap il ne se passe absolument rien, il faut cliquer sur la petite croix pour que ça déclenche un événement Destroy sur la fenêtre.

Maintenant ce que l'on peut faire nous, on va appeler cette petite fonction de rappel callback, func(), et on va pouvoir déclencher quelque chose notamment grâce à cet objet `event` que nous avons passé tout à l'heure et dont on n'avait pas encore fait l'usage.

Cet objet `event` permet d'accéder à pas mal de attributs par exemple les coordonnées XY concernant la souris, on a également des attributs par rapport à la fenêtre d'application donc ça ce sera `x_root` et `y_root`. Voilà je peux vous montrer rapidement les attributs concernés :

```py
"""
    x, y, x_root, y_root
"""
```

On peut également avoir des histoires de largeur et de hauteur `width` et `height` mais on peut également avoir l'état en budget `state` c'est à dire est ce qu'il est activé ou désactivé. Voilà on pourra en énumérer d'autres mais nous allons aller assez vite sur ces informations parce qu'il en existe d'autres très intéressantes.

```py
"""
    x, y, x_root, y_root
    width, height
    state
"""
```

Il y en a aussi qui sont pas mal intéressants qui sont le symbole utilisé `keysym` et notamment le code du symbole rattaché.

```py
"""
    x, y, x_root, y_root
    width, height
    state
    keysym, keycode
"""
```

Alors le symbole utilisé c'est `'<Escape>'` c'est à dire le symbole qu'on utilise à chaque fois mais il faut savoir que pour le symbole il y a aussi un code qui est associé.

Ça ce sont donc tout un tas de d'attributs que l'on peut récupérer.

Alors il existe encore un autre attribut qu'on n'a pas noté ici qui est l'attribut widget, on passe par notre objet event pour pouvoir accéder à son attribut widget `event.widget`.

```py
def func(event):
    event.widget
```

:warning: je veux qu'on traîte ce nouvel évennement sur ma nouvelle fenêtre ouverte `top.bind('<Escape>', func)`

Alors cet attribut widget, une fois que vous y avez accès, on peut appeler n'importe quel méthode de widget.

Quand je vais appuyer sur échappe, on va faire un `event.widget` et sachant qu'on va se retrouver avec notre nouvelle fenêtre (top) on va pouvoir rappeler n'importe quelle méthode de widget `event.widget.` qu'on a déjà vu dans le cours python par exemple detroy(), `event.widget.destroy()` qui va détruire la fenêtre.

Alors on va pouvoir mettre un petit message pour indiquer que c'est bien fermé, Fenêtre fermée.

+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    event.widget.destroy()
    print("Fenêtre fermée")

def openwindow():
    top = tkinter.Toplevel()
    label_w = tkinter.Label(top, text = 'Bonjour')
    top.bind('<Escape>', func)
    label_w.pack()

app = tkinter.Tk()
app.geometry('320x240')

button_w = tkinter.Button(app, text = 'Ouvrir une fenetre', command = openwindow)

button_w.pack()
app.mainloop()
```
```powershell
> python main.py
Fenêtre fermée
```

Voilà si je fais échap sur la fenêtre principale, il ne se passe rien ensuite j'ouvre la fenêtre secondaire je fais échap et le terminal m'indique que la fenêtre s'est fermée.

Voilà c'est pas mal pratique donc n'hésitez pas à utiliser cet objet `event` et donc c'est pour ça qu'on le passe ici en paramètre mais voilà il faut comprendre que comme c'est une callback, on met juste le nom de la fonction ici `top.bind('<Escape>', func)`

Voilà comme c'est une Call back, on met juste le nom de la fonction et donc on a cet élément event qui est très intéressant qu'on peut utiliser qui possède pas mal d'attributs.

Un autre attribut qui peut être intéressant aussi, c'est d'afficher le symbole `event.keysym` et le code correspondant `event.keycode`.

+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    print("{} / {}".format(event.keysym, event.keycode))
    event.widget.destroy()
    print("Fenêtre fermée")

def openwindow():
    top = tkinter.Toplevel()
    label_w = tkinter.Label(top, text = 'Bonjour')
    top.bind('<Escape>', func)
    label_w.pack()

app = tkinter.Tk()
app.geometry('320x240')

button_w = tkinter.Button(app, text = 'Ouvrir une fenetre', command = openwindow)

button_w.pack()
app.mainloop()
```
```powershell
> python main.py
Escape / 27
Fenêtre fermée
```

Voilà on a bien *Escape* qui est affiché et le code qui est associé à la touche échap du clavier est 27 (de toute façon si on appuie sur autre chose que échappe, ça ne marche pas) donc c'est évidemment plus simple de retenir les symboles et ça force à les retenir parce que vous allez en utiliser assez souvent après si vous voulez vous amuser à retenir le nom de code par coeur c'est vous que ça regarde mais personnellement je ne connais pas beaucoup de code et la plupart du temps j'utilise surtout les symboles.

Voilà pour cette partie nous avons vu comment capturer les événements et on a vu également les différents types d'évènements que ce soit sur un widget en particulier ou un ensemble ou par exemple utiliser cet objet `event` car il permet d'avoir accès à pas mal d'attributs donc on pourrait par exemple s'amuser à récupérer la position du curseur de la souris pour ainsi vérifier la position XY ce qui peut être pas mal pour tester sa différentes fonctionnalités.

## event_add
> Définir et créer un nouveau déclencheur 

Pour terminer ce tutoriel nous allons voir comment définir et créer un nouveau déclencheur c'est à dire qu'on aurait par exemple besoin de créer un nouveau cas d'événement, un nouveau symbole pour être plus exact donc on va déjà repartir sur un code plus simple.

+ main.py
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()
app.geometry('320x240')

label = tkinter.Label(app, text = 'Hello World !')

## Créer un nouveau symbole...

label.pack()
app.mainloop()
```

Alors je vais commencer par créer un nouveau symbole en partant de mon application (app), je vais utiliser la méthode event_add() qui a un argument obligatoire qui est le nom du symbole et comme c'est un symbole qui va être personnalisée c'est à dire défini par nous, on va mettre non pas des simples chevrons mais des doubles chevrons et à l'intérieur le nom que l'on va lui donner par exemple *click*, `app.event_add('<<click>>')`.

+ main.py
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()
app.geometry('320x240')

label = tkinter.Label(app, text = 'Hello World !')

app.event_add('<<click>>', )

label.pack()
app.mainloop()
```

Ensuite vous savez qu'en python on peut avoir un nombre de paramètres par variable, des fonctions avec un nombre de paramètres variables, infinis. Ainsi on peut mettre tout un tas de paramètres et cette fonction event_add() prends tout un tas de paramètres donc d'arguments qui est variable aussi autrement dit tout ce que vous allez mettre ici comme symbole, comme événement, qui ont pu être déclenchés produirons ce symbole là `click` que vous allez pouvoir traiter. Ainsi on va dire que je fasse un clic gauche `'<Button-1>'` ou en clic droit `'<Button-2>'` ou en clic du milieu `'<Button-3>'` pour ceux qui auraient une molette sur la souris, je veux que ça englobe un autre type de déclencheur `'<<click>>'`.

+ main.py
```py
#coding:utf-8
import tkinter

app = tkinter.Tk()
app.geometry('320x240')

label = tkinter.Label(app, text = 'Hello World !')

app.event_add('<<click>>', '<Button-1>', '<Button-2>', '<Button-3>')

label.pack()
app.mainloop()
```

Donc dès qu'il y aura un événement `'<Button-1>'` ou `'<Button-2>'` ou `'<Button-3>'`, je veux que ça puisse les englober tout ça dans un `event` que j'appellerais du coup `click` et on va pouvoir du coup traiter cet événement particulier qui est un peu plus personnalisé d'accord ça veut dire que pour ces 3 boutons de la souris, on aura cet événement qui sera géré.

Nb. On a choisi de mettre cet événement au niveau de l'application (app) mais on aurait pu la mettre très bien au niveau du label (label), on reste sur l'application.

Maintenant on peut faire ce qu'on a fait tout à l'heure avec le fameux bind() et de dire que sur toute l'application (app) donc toute la fenêtre, dès que je vais cliquer donc je fais un bind() `app.bind('<<click>>', func)` et là on double les chevrons aussi parce que c'est comme ça que l'interpréteur python arrive à différencier un symbole qu'il connaît c'est-à-dire un symbole qui est géré nativement avec des simples chevrons qu'un symbole qui aurait été défini par un développeur, un utilisateur puis là on mets la fonction en question, func(), et on annonce qu'un clic se produit.

+ main.py
```py
#coding:utf-8
import tkinter

def func(event):
    print("Un clic s'est produit")

app = tkinter.Tk()
app.geometry('320x240')

label = tkinter.Label(app, text = 'Hello World !')

app.event_add('<<click>>', '<Button-1>', '<Button-2>', '<Button-3>')
app.bind('<<click>>', func)

label.pack()
app.mainloop()
```
```powershell
> python main.py
Un clic s'est produit
Un clic s'est produit
Un clic s'est produit
```

Voilà il n'y a pas besoin de mettre un bind() sur le clic gauche `'<Button-1>'` puis de dire qu'on a cliqué, puis un bind() de sur le clic droit `'<Button-1>'` dire que l'on a cliqué et cetera.

Voilà on ne fait pas 3 bind(), on crée juste un nouveau type d'évènement avec event_add() et ensuite on peut connecter celui-là avec bind() pour pouvoir le traiter via notre fonction.

Voilà lorsqu'on compile on connecte notre application et on peut cliquer à gauche à droite au milieu et ça produit exactement la même chose. C'est pas le même type d'évènement qui se produit en réalité mais comme on l'a capturé, on gère ces 3 types d'évènements de la même manière, cet événement clic `'<<clic>>'` ce sera la même fonction func() qui sera appelée et ce sera donc le même traitement qui sera effectué.

Voilà ça c'est une bonne petite fonctionnalité.

Il faut savoir qu'on peut également supprimer un événement qui a été créé ici avec event_add() avec la méthode event_delete() si on ne veut pas le garder pendant l'exécution du programme et ensuite on peut découvrir pas mal d'autres méthodes aussi qui permettent de faire d'autres choses mais là je viens de vous expliquer tout ce qui allait être pas mal et intéressant que vous manipulerait via tkinter pour faire vos interfaces graphiques.

Voilà pour ce petit tutoriel qui vient compléter la gestion des événements.

Ciao tout le monde