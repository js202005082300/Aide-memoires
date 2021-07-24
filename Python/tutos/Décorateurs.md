# [Décorateurs](https://www.youtube.com/watch?v=LiBsVCXAgXI)

Les décorateurs, sont une notion qu'on a déjà abordée dans les cours en python mais nous allons revenir plus en détail dans ce tutoriel, comment le mettre en place au niveau du code.

## Faire un décorateur

On va voir comment le mettre en place au niveau du code, comment on va pouvoir décorer certaines de nos fonctions.

Par exemple, une petite fonction hello().

```py
#coding:utf-8

def hello():
    print("Hello !")

hello()
```
```powershell
> python main.py
Hello !
```

Un décorateur va venir décorer une fonction ce qui rejoint un peu le principe des design patterns donc aux patrons de conceptions, ce sont en fait des manières de programmer. C'est un principe qui vise à résoudre un problème récurrent en informatique, en programmation pour apporter son lot de fonctionnalités.

Le principe d'un décorateur c'est que ça va permettre d'étendre les fonctionnalités d'une fonction de départ donc de modifier son comportement.

Dans notre exemple, la fonction hello() ne fait que afficher un message mais c'est plus tard je veux pouvoir modifier ce comportement, cette fonction pour l'instant je n'aurais qu'un seul moyen c'est à dire de la modifier moi-même donc par exemple je peux écrire ceci.

```py
#coding:utf-8

def hello():
    print("Hello !")
    print("How are you?")

hello()
```

Maintenant admettons que j'ai plusieurs fonctions hello() et hi() et que je veux pouvoir modifier leur comportement de la même manière, on sera obligé de copier coller ce nouveau comportement `print("---------------")` d'une fonction à l'autre.

```py
#coding:utf-8

def hello():
    print("---------------")
    print("Hello !")

def hi():
    print("---------------")
    print("Hello !")

hello()
```

Voilà on va devoir répéter à chaque fois ce nouveau comportement de fonction en fonction et on tombe sur un problème dont on a souvent évoqué, il s'agit donc de la répétition de code et on aura peut-être édité les fonctions qui feront au final plus qu'une seule chose alors qu à la base on nous avait expliqué qu'une fonction ou une méthode ne faisait qu'une seule chose à la fois même si ici on s'en fout parce que ce n'est que l'affichage.

Voilà donc on va pouvoir décorer cette fonction sans pouvoir y toucher c'est comme si quelqu'un l'avait développé à notre place et qu'on lui avait donné les fonctions avec l'interdiction d'y toucher mais on va pouvoir changer le comportement de ces fonctions en rajoutant quelque chose.

Pour cela on va simplement créer une autre fonction qui va servir de décorateur `def decorator()`.

```py
#coding:utf-8

def decorator()

def hello():
    print("Hello !")

def hi():
    print("Hello !")

hello()
```

Alors un décorateur c'est simplement une fonction qui va prendre en paramètre une autre fonction et qui va retourner une nouvelle fonction en l'occurrence la fonction décorée.

```py
#coding:utf-8

def decorator(func):
    return func

def hello():
    print("Hello !")

def hi():
    print("Hello !")

hello()
```

Voilà ici pour une fonction basique qui va prendre en paramètre notre fonction et qui va retourner cette même fonction mais décorée et dans ce qu'on vient de faire ça ne change rien puisqu'on n'a rien ajouté en plus donc ça revient au même.

Alors au début on va juste rajouter un texte au départ en mettant la fameuse barre que l'on avait tout à l'heure sans toucher aux fonctions à décorer.

```py
#coding:utf-8

def decorator(func):
    print("-------------")
    return func

def hello():
    print("Hello !")

def hi():
    print("Hello !")

hello()
```

La première syntaxe est de dire que comme tout est objet en python y compris une fonction, on peut la manipuler c'est à dire qu'on peut mettre une fonction dans une fonction et on peut s'en servir dans des variables parce que tout cet objet. Une fonction et un objet, une méthode est également un objet en python donc c'est très simple et cette syntaxe va vous rappeler le property() quand on faisait les propriétés où on dit quand passe le décorateur à hello `hello = decorator(hello)` ainsi on passe notre fonction dans notre décorateur donc on se rend bien compte que notre décorateur va englober la fonction hello() c'est pour ça qu'on parle de décorer notre fonction hello().

*Rappel avec property() :* `age = property(_getage, _setage)` ou encore ce genre de chose : `func = classmethod(func)` qui devrait nous parler.

```py
#coding:utf-8

"""
Notation d'un décorateur :

    func = decorator(func)
"""

def decorator(func):
    print("-------------")
    return func

def hello():
    print("Hello !")

hello = decorator(hello)

def hi():
    print("Hello !")

hello()
hi()
```

Voilà ça c'était une première syntaxe `func = decorator(func)`.

Ensuite la seconde syntaxe `@decorator` c'est à dire le nom du décorateur en l'occurrence mais que nous allons mettre avant la définition de la fonction.

Voilà soit cette syntaxe `hello = decorator(hello)` ou alors une autre qu'on avait pas vu dans le cours `@decorator`.

```py
#coding:utf-8

"""
Notation d'un décorateur :

    func = decorator(func)
    @decorator
"""

def decorator(func):
    print("-------------")
    return func

@decorator
def hello():
    print("Hello !")

def hi():
    print("Hello !")

hello()
hi()
```

Voilà on met d'abord simplement un `@`, ensuite le nom de la fonction qui fait office de décorateur avant la définition de la fonction qui doit être décorée donc ici il va décorer la fonction hello() par contre la fonction hi() ne va pas changer.

voilà on va tenter une exécution.

```powershell
> python main.py
-------------
Hello !
Hello !
```

Voilà on voit que pour la fonction hello(), il met bien le contenu du décorateur.

Voilà donc ce principe de base comment mettre un décorateur basique au niveau de notre code.

Voilà ça c'est le code minimal pour un décorateur c'est à dire qu'elle prend une autre fonction en paramètre et elle retourne la fonction décorée donc nous forcément c'est la fonction que nous avons passé en paramètre.

Voilà on ne fait pas un appel c'est à dire qu'on retourne la fonction en tant que objet, c'est grâce aux parenthèses qu'on voit la différence entre eux l'objet et la fonction appelée.

En python, ce type d'objet pour une fonction s'appelle un callable. Le type de ces objets (une fonction, une méthode) s'appelle un callable comme on a le type int pour ce nombre 14 ou bien ce nombre -26, ou encore le type str pour le texte "Bonjour".

```py
# callable (fonction, méthode)
# int (14, -26)
# str ("Bonjour")
```

callable est un type précis en python.

```py
#coding:utf-8

def decorator(func):
    print("-------------")
    return func

@decorator
def hello():
    print("Hello !")

hello()

print(type(hello))
```
```powershell
> python main.py
-------------
Hello !
<class 'function'>
```

On a une classe fonction c'est à dire qu'on peut l'appeler.

Maintenant on va essayer de modifier le comportement de la fonction et pas seulement afficher un simple texte, on va donc rajouter quelque chose.

Admettons par exemple un site web avec un système d'authentification qui permet de se connecter, on a par exemple si une fonction qui indique qu'on accède au profil d'un membre.

```py
#coding:utf-8

def profile():
    print("Le profil membre...")

profile()
```

C'est à dire qu'on va mettre en place quelque chose qui va permettre de vérifier que nous devons être connecté avant d'accéder au profil du site web donc pour ça on va utiliser une petite variable booléenne et par défaut on dira qu'elle est vraie.

```py
#coding:utf-8

user_logged = True

def profile():
    print("Le profil membre...")

profile()
```

En gros ici quand t'es connecté, tu dois pouvoir accéder à cette fonction profile() sinon il faudra indiquer de se connecter c'est-à-dire qu'on pourrais s'amuser à faire ceci.

```py
#coding:utf-8

user_logged = True

def profile():
    if user_logged:
        print("Le profil membre...")

def articles():
    if user_logged:
        print("La page des articles...")

profile()
```

...mais si on doit procéder à la même vérification pour chaque page, on se retrouve avec de la répétition de code donc on va décorer encore une fois tout ça pour ne pas à avoir à modifier la fonction qui accède au profil parce que ce n'est pas à la fonction de faire ce travail, de voir qu'on est connecté, de voir si on est administrateur ou ce genre de chose.

Voilà dans ce cas la fonction ferait plusieurs choses alors qu'elle n'est censée en faire qu'une seule c'est à dire que profile() accède simplement au profil d'un membre, c'est tout, c'est son rôle unique.

Voilà donc nous on va mettre un décorateur mais dans un vrai programme veuillez amener des noms plus explicites que `decorator`.

```py
#coding:utf-8

user_logged = True

def decorator(func):
    def wrapper():
        #nos vérifications...
    return wrapper

@decorator
def profile():
    if user_logged:
        print("Le profil membre...")

profile()
```

Notez qu'ici la petite nouveauté c'est qu'on définit une fonction dans une fonction parce que je rappelle que le décorateur n'est qu'une fonction en fait donc on va définir une nouvelle fonction et la plaie à l'intérieur mais veuillez noter que par habitude on va l'appeler wrapper mais on peut évidemment l'appeler comment vous voulez. Alors la fonction qui fait office de wrapper ne contient aucun paramètre, et à l'intérieur on va pouvoir justement faire la vérification que l'on veut et à la fin on va retourner le wrapper, c'est comme si on faisait ça wrapper() :

```py
#coding:utf-8

user_logged = True

def ...

def ...

wrapper()
profile()
```

Seulement voilà nous jamais on va appeler le décorateur directement, on va appeler la fonction pour le profil profile() ce qui va passer par l'intermédiaire du wrapper() Voilà pourquoi on a cette syntaxe.

On peut être un peu perdu au départ, c'est pour ça qu'il faudra utiliser les décorateurs dans un cas concret même si on les a déjà utilisé sans forcément s'en rendre compte mais là vous allez pouvoir les utiliser de manière beaucoup plus explicite au sein de votre code.

Voilà donc on va pouvoir faire nos **vérifications** directement dans le wrapper().

```py
#coding:utf-8

user_logged = True

def decorator(func):
    def wrapper():
        if user_logged:
            return func()
        else:
            print("Vous devez être connecté.")
    return wrapper

@decorator
def profile():
        print("Le profil membre...")

profile()
```

Par rapport au système qu'on vient de simuler, on est connecté avec user_logged à True.

```powershell
> python main.py
Le profil membre...
```

Voilà on voit qu'on accède au profil, si par contre on met `user_logged = False` alors sur un vrai site ce ne serait pas une variable qui ferait ça bien évidemment donc là on imagine qu'on n'est pas connecté.

```powershell
> python main.py
Vous devez être connecté.
```

Là il nous indique simplement qu'on doit être connecté, et du coup il n'a pas exécuté le contenu de la fonction profile(), on n'y a pas accédé mais surtout Notez qu'on n'a jamais modifié cette fonction profile() parce que ce n'est pas la fonction qui accède au profil profile() de faire la vérification et même si plus tard on rajoute des fonctions, on pourrait y accéder à tout moment si on ne les a pas décorées.

```py
#coding:utf-8

user_logged = False

def decorator(func):
    def wrapper():
        if user_logged:
            return func()
        else:
            print("Vous devez être connecté.")
    return wrapper

@decorator
def profile():
        print("Le profil membre...")

def articles():
    print("Les articles...")


profile()
articles()
```
```powershell
> python main.py
Vous devez être connecté.
Les articles...
```

Le jour où je veux nécessité la connexion du membre pour accéder aux articles, on aura juste à ajouter le décorateur qui vérifie que l'utilisateur est connecté, on va le renommer en `check_user_logged` pour être plus explicite.

```py
#coding:utf-8

user_logged = False

def check_user_logged(func):
    def wrapper():
        if user_logged:
            return func()
        else:
            print("Vous devez être connecté.")
    return wrapper

@check_user_logged
def profile():
        print("Le profil membre...")

@check_user_logged
def articles():
    print("Les articles...")


profile()
articles()
```

Voilà à chaque fois qu'on veut le spécifier sur une méthode, on aura juste qu'a rajouter une seule ligne et ici d'un seul coup on pourra plus accéder aux articles.

```powershell
> python main.py
Vous devez être connecté.
Vous devez être connecté.
```

Pour rappel un décorateur c'est très simple ça permet d'étendre des fonctionnalités, par exemple de récupérer une bibliothèque qui n'est pas nouveau et on veut pouvoir ajouter des fonctionnalités sans modifier la bibliothèque de base parce que vous ne pouvez pas ! Eh bien dans ce cas-là vous faites des décorateurs, et hop vous pouvez étendre les fonctionnalités de quelque chose ou simplement changer le comportement parce que le fait d'étendre des fonctionnalités c'est changer le comportement de départ.

Voilà nous avons vu un exemple un peu plus complexe avec une fonction définie dans une autre donc faites attention à ce genre de syntaxe mais en gros dites-vous que vous avez des traitements. Si on prend un code assez générique tous les traitements que l'on veut faire se trouvent ici.

```py
#coding:utf-8

user_logged = False

def check_user_logged(func):
    def wrapper():
        #Traitements (if user_logged: et cetera)
        return func()
        else:
            print("Vous devez être connecté.")
    return wrapper

@check_user_logged
def profile():
        print("Le profil membre...")

@check_user_logged
def articles():
    print("Les articles...")

profile()
articles()
```

Voilà si on veut on a donc le code minimal :

```py
def check_user_logged(func):
    def wrapper():
        #Traitements
        return func()
    return wrapper
```

Voilà ça c'est le code minimal, je peux faire un print, des conditions, des boucles et cetera vraiment ce que l'on veut parce qu'on a une fonction dans une fonction donc tout ce que vous avez appris jusqu à présent est parfaitement valable. Voilà c'est vraiment une fonction dans une fonction sauf que check_user_logged() agit comme le décorateur donc elle va passer par un intermédiaire donc ça doit vous faire penser encore une fois propriétaire qu'on avait vu avant parce que rappelez vous que quand on faisait les propriétés pour un attribut et que dès qu'on voulait accéder à un attribut ou le modifier, je vous avais dit qu'il y avait un filtre qui se mettait entre les 2 c'est à dire que au lieu que ça accède ou que ça modifie directement l'attribut, on passait par une méthode de la classe (set) qui agissait comme un accesseur qui nous disait si on pouvait accéder à l'élément ou si on pouvait le modifier.

Voilà je vous avais dit que les accesseurs ça permet de filtrer l'accès ou la modification voire de l'interdire, voire de le faire sous certaines conditions.

Par exemple si on veut modifier en pseudo, Eh bien dans un setter c'est-à-dire une méthode qui permet la modification, on pourrait dire que le pseudo ne peut pas faire plus de 25 caractères sinon empêche la modification donc ça permet de faire des filtres et d'étendre les fonctionnalités donc encore une fois modifier le comportement de départ d'une fonction, d'une méthode. Et c'est exactement ce à quoi servent les décorateurs.

Voilà c'est une syntaxe un peu particulière mais c'est ça que sert les décorateurs (modifier le comportement de départ d'une fonction) et en plus de ça on retrouve le retour d'une appel de fonction `return func()` ou bien encore le retour de l'objet `return wrapper` donc c'est peut être un petit peu nouveau si on n'a pas beaucoup de pratique mais avec la pratique on arrivera à bien comprendre cette syntaxe.

## Décorateurs avec paramètres

Maintenant on va passer à un stade au dessus c'est à dire qu'on a vu comment définir des décorateurs standards, mais maintenant nous allons voir comment définir des décorateurs avec des paramètres.

Ici avec des paramètres on va toujours essayer de garder l'exemple avec le site web, encore une fois les exemples ne représente pas un vrai projet dans son ensemble, on ne ferait absolument pas comme ça mais c'est juste qu'il faut pouvoir simuler quelque chose pour avoir un exemple qu'y illustre bien cette notion.

Voilà nous allons partir d'abord sur le nom d'utilisateur de l'administrateur, est ce qu'on va faire ? C'est de pouvoir accéder au profil si on a reconnu le pseudonyme de la personne et donc il faut que par exemple `user_name` soit égal à `"Jason"` et nous allons voir comment passer des paramètres à un décorateur et nous allons avoir une syntaxe un peu particulière c'est à dire qu'on va mettre un décorateur dans un autre c'est à dire qu'on va voir un premier décorateur qui va en définir un autre (le 2e décorateur se sera check_user() et à l'intérieur on aura le wrapper()) donc une fonction dans une fonction dans une fonction donc 3 imbrications, 3 fonctions, 3 parties.

```py
#coding:utf-8

user_name = "Jason"

def check_user(username):
    def decorator(func):
        def wrapper():
            #Traitements...
            return func()

@check_user("Jason")
def profile():
    print("Le profil membre...")

profile()
```

Voilà on retrouve la même chose que tout à l'heure donc avec toute une série de traitements à faire, et au bout d'un moment, on aura à faire un `return func()` ce qu'on avait déjà vu.

Alors ensuite au niveau de la définition du wrapper()<del>, on retourne la fonction qu'on a passé en paramètre du décorateur `decorator(func)`</del>. Et dans l'environnement de la fonction decorator(), on retourne `decorator`.

```py
#coding:utf-8

user_name = "Jason"

def check_user(username):
    def decorator(func):
        def wrapper():
            #Traitements...
            return func()
        return wrapper
    return decorator

@check_user("Jason")
def profile():
    print("Le profil membre...")

profile()
```

Alors ça c'est sujet à de nombreuses erreurs au départ parce que vous mettre des parenthèses quand il n'en faut pas et cetera et du coup vous aurez des erreurs, par exemple on vous retournera que vous essayez d'appeler quelque chose qui n'est pas callable c'est-à-dire qu'il ne peut pas être appelé mais vous arriverez vite à identifier vos erreurs.

Ensuite il nous suffit de faire la vérification qu'on veut en guise de traitement.

```py
#coding:utf-8

user_name = "Jason"

def check_user(username):
    def decorator(func):
        def wrapper():
            if username == user_name:
                return func()
        return wrapper
    return decorator

@check_user("Jason")
def profile():
    print("Le profil membre...")

profile()
```

Donc voilà si `username` qu'on a passé en paramètre de check_user() éteins gale au user_name qui a par exemple pu être enregistré dans un fichier dans le cadre d'un vrai exemple Eh bien à ce moment-là on aura effectivement l'exécution de `return func()` donc on va accéder en fait à profile() sinon laisse un petit message pour faire simple en précisant que l'utilisateur est inconnu.

```py
#coding:utf-8

user_name = "Jason"

def check_user(username):
    def decorator(func):
        def wrapper():
            if username == user_name:
                return func()
            else:
                print("Utilisateur inconnu")
        return wrapper
    return decorator

@check_user("Jason")
def profile():
    print("Le profil membre...")

profile()
```

Voilà ça change ce qu'est une syntaxe que l'on retrouve un petit peu souvent, et c'est très flexible, très générique, on peut l'utiliser partout. Ainsi on a notre fonction de départ check_user() qui prend autant de paramètres que l'on veut (tout ce qu'on a vu dans le cours de Python est parfaitement valable ici, encore une fois il n'y a rien de nouveau) après on définit une autre fonction decorator() qui prend notre fameuse fonction en paramètre et le wrapper() encore à l'intérieur et on fait tout le traitement `if … else …`.

On execute.

```powershell
> python main.py     
Le profil membre...
```

Si on n'a pas fait d'erreur, on a accès au profil mais à partir du moment où on change le nom ici `@check_user("Toto")` la condition ne sera plus satisfaite.

```powershell
> python main.py     
Utilisateur inconnu
```

Notez qu'on a ici la définition de wrapper() qui retourne l'objet wrapper et puis seulement au niveau de la définition du decorator(), on a le retour de l'objet decorator donc voilà il ne faut pas se tromper là-dessus.

Si on a la même variable, okay ça fonctionne `Le profil membre…` et à partir du moment où ici en paramètre on a autre chose `@check_user("toto")` donc il ne valide plus la condition que l'on a écrite et bien on accède plus à la fonction `Utilisateur inconnu` donc c'est très pratique et vous allez pouvoir du coup créer des décorateurs avec plusieurs paramètres.

## Idem avec l'autre syntaxe

Comment utiliser l'autre syntaxe avec ce code

```py
#coding:utf-8

user_name = "Jason"

def check_user(username):
    def decorator(func):
        def wrapper():
            if username == user_name:
                return func()
            else:
                print("Utilisateur inconnu")
        return wrapper
    return decorator

#@check_user("Jason")
def profile():
    print("Le profil membre...")

profile = check_user("Jason")(profile)

profile()
```

`profile = check_user("Jason")(profile)` Voilà on lui passe le paramètre et ensuite on lui passe la fonction, c'est une syntaxe un peu particulière. On a en fait cette partie là `check_user(username)` et comme on a le décorateur qui a défini dans check_user() donc on a le paramètre du décorateur decorator() qui est repris à la suite `(profile)` c'est pour ça qu'on a ces 2 écritures qui se suivent :

`profile = check_user("Jason")` ... `(profile)`

Voilà donc on aura tous les paramètres de check_user(), et ensuite c'est la fameuse fonction que l'on passe voilà ces 2 syntaxes sont équivalentes :

`profile = check_user("Jason")(profile)`
Ou
`@check_user("Jason")`

Peut être que celle-ci `@check_user("Jason")` et moi source d'erreur donc à la rigueur il est peut être mieux d'adopter cette syntaxe là.

Voilà pour cette partie mais maintenant on va faire un petit retour en arrière sur ce qu'on avait vu sur le cours notamment avec les propriétés, les méthodes de classe, et les méthodes statiques pour montrer comment mettre plus en application les décorateurs de manière plus visible au niveau de notre code par rapport à des choses qu'on avait vu avant.

## Décorateur et docstring, help()

Mais avant cela j'aimerais aborder un dernier point avec vous lorsqu'on avait utilisé des docstrings c'est-à-dire des commentaires pour expliquer comment notre méthode fonctionne, utilisez ensuite la fonction help() qui nous permet d'accéder à cette information.

```py
#coding:utf-8

user_name = "Jason"

def check_user(username):
    def decorator(func):
        def wrapper():
            if username == user_name:
                return func()
            else:
                print("Utilisateur inconnu")
        return wrapper
    return decorator

def profile():
    """
    Page d'accès au profil de l'utilisateur
    """
    print("Le profil membre...")

help(profile)
```
```powershell
> python main.py
Help on function profile in module __main__:

profile()
    Page d'accÞs au profil de l'utilisateur
```

help() du nom de la fonction, il me met le fameux texte qu'il y a dans la docstring().

Voilà ce que nous obtenons maintenant quand on décore une fonction.

```py
#coding:utf-8

user_name = "Jason"

def check_user(username):
    def decorator(func):
        def wrapper():
            if username == user_name:
                return func()
            else:
                print("Utilisateur inconnu")
        return wrapper
    return decorator

@check_user("Jason")
def profile():
    """
    Page d'accès au profil de l'utilisateur
    """
    print("Le profil membre...")

help(profile)
```
```powershell
> python main.py
Help on function wrapper in module __main__:

wrapper()
```

Voilà on modifie le comportement de départ de la fonction qui va passer par un intermédiaire et notre intermédiaire c'est le décorateur, il l'a décoré. Et tout ce qui va englober notre fameuse fonction, c'est le wrapper() donc c'est pour ça qu'on obtient ça et comme on n'a pas mis de docstring à l'intérieur, il nous affiche rien mais on pourra en mettre une à l'intérieur.

```py
#coding:utf-8

user_name = "Jason"

def check_user(username):
    def decorator(func):
        def wrapper():
            """
            Le wrapper...
            """
            if username == user_name:
                return func()
            else:
                print("Utilisateur inconnu")
        return wrapper
    return decorator

@check_user("Jason")
def profile():
    """
    Page d'accès au profil de l'utilisateur
    """
    print("Le profil membre...")

help(profile)
```
```powershell
> python main.py
Help on function wrapper in module __main__:

wrapper()
    Le wrapper...
```

Voilà on retourne l'information du wrapper() mais ça peut être très dérangeant quand on fait de la bonne documentation pour notre code et du coup on perd l'information de notre profile() ce qui est très embêtant.

Alors il y a une petite astuce très simple pour pouvoir transférer la docstring de notre fonction directement à notre décorateur c'est-à-dire qu'on va importer à module qui s'appelle `import functools`.

Et nous allons décorer le wrapper(), voyez pour résoudre le problème on va utiliser de la perte d'information du décorateur et on va donc décorer ce fameux wrapper(), juste avant la définition du wrapper() avec une petite ligne `@functools.wraps(func)`

Voilà pourquoi on utilise le mot wrapper, parce que wraps avec un s éteins mots assez similaires donc en général quand on écrit ça dans les codes c'est beaucoup plus propre de l'écrire comme ça est plus explicite donc on a juste à mettre cette ligne `@functools.wraps(func)` en ayant emporté le module `import functools`.

```py
#coding:utf-8
import functools

user_name = "Jason"

def check_user(username):
    def decorator(func):
        @functools.wraps(func)
        def wrapper():
            """
            Le wrapper...
            """
            if username == user_name:
                return func()
            else:
                print("Utilisateur inconnu")
        return wrapper
    return decorator

@check_user("Jason")
def profile():
    """
    Page d'accès au profil de l'utilisateur
    """
    print("Le profil membre...")

help(profile)
```
```powershell
> python main.py
Help on function profile in module __main__:

profile()
    Page d'accÞs au profil de l'utilisateur
```

Voilà on a gardé l'information donc l'information n'a pas été perdue c'est surtout ça qui est le plus important. Nous avons importé le module ensuite nous avons décoré la fonction qui fait office de wrapper comme ça on récupère à chaque fois toutes les informations, les docstrings pour la documentation, les messages d'aide ou ce genre de chose donc c'est vraiment important.

## méthodes particulière en décorateur

J'avais préparé un autre code en avance pour la suite.

```py
class Player:
    def __init__(self, name):
        self._name = name
    
    def get_name(self):
        return self._name
    
    def set_name(self, name):
        if len(name) <= 25:
            self._name = name
        else:
            print("Nom incorrect (25 caractères max.)")
    
    def one_method():
        pass
    
    def another_method():
        pass
    
    name = property(get_name, set_name)
    one_method = staticmethod(one_method)
    another_method = classmethod(another_method)
```

Voilà nous avons le constructeur qui prend comme seul attribut un nom `name` ensuite on en fait un attribut `self._name = name` qui passera par une propriété donc pour lui indiquer, on met un petit underscore `_name`.

Ensuite on a son accesseur, le getter get_name() ensuite le setter set_name() avec une simple vérification si le nom est plus petit ou égal à 25 caractères sinon on dit que le nom est incorrect qu'il faut 25 caractères au maximum.

Enfin j'ai défini 2 méthodes en mettant le mot `pass` parce qu'il faut mettre quelque chose dans une méthode au minimum donc elles ne font rien ici mais c'est juste pour l'exemple.

Enfin j'ai repris les 3 syntaxes qu'il y avait dans la cours c'est-à-dire la syntaxe pour définir une propriété property(), la syntaxe pour définir une méthode statique staticmethod() et la syntaxe pour définir une méthode de classe classmethod() donc on ne va pas revenir sur à quoi elles servent parce que ça a été expliqué dans le cours où on a tout le détail si on veut savoir.

Alors maintenant nous allons voir comment changer la syntaxe parce que maintenant on sait que dans ce tutoriel qu'est ce qu'un décorateur et comment il s'écrit, on sait même en faire nous-mêmes maintenant alors comment est-ce qu'on va transformer ce type de syntaxe en syntaxe de décorateur :

```py
    name = property(get_name, set_name)
    one_method = staticmethod(one_method)
    another_method = classmethod(another_method)
```

Voilà on va transformer ces méthodes là en syntaxe de décorateurs alors pour le classmethod() et le staticmethod() c'est très simple par exemple pour le staticmethod() il suffit de mettre un @ au-dessus de la définition de la méthode. Pareil pour classmethod().

```py
class Player:
    def __init__(self, name):
        self._name = name
    
    def get_name(self):
        return self._name
    
    def set_name(self, name):
        if len(name) <= 25:
            self._name = name
        else:
            print("Nom incorrect (25 caractères max.)")
    
    @classmethod
    def one_method():
        pass
    
    @staticmethod
    def another_method():
        pass
    
    name = property(get_name, set_name)
```

Voilà c'est très simple et on gagne un petit peu de place au niveau du fichier par contre pour property() c'est un petit peu différent parce que vous voyez qu'on peut avoir plusieurs choses différentes avec une fonction qui est pour le getter et une autre fonction pour le getter et Pour rappel on peut avoir deleter et cetera.

Ainsi au niveau de la méthode qui définit le getter, vous mettez simplement `@property` parce que le getter est le principal, parce que c'est celui qui accède à l'élément, qui accède à l'attribut. Par contre pour celui qui le modifie, le setter, vous mettez `@property.setter` et si vous en avez un pour la suppression `@property.deleter`.

```py
class Player:
    def __init__(self, name):
        self._name = name
    
    @property
    def get_name(self):
        return self._name
    
    @property.setter
    def set_name(self, name):
        if len(name) <= 25:
            self._name = name
        else:
            print("Nom incorrect (25 caractères max.)")

    @property.deleter
    def del_name(self):
        pass
    
    @classmethod
    def one_method():
        pass
    
    @staticmethod
    def another_method():
        pass
```

Alors on pourrait faire également autrement pour définir une propriété en faisant comme ceci.

```py
class Player:
    def __init__(self, name):
        self._name = name
    
    def get_name(self):
        return self._name
    
    def set_name(self, name):
        if len(name) <= 25:
            self._name = name
        else:
            print("Nom incorrect (25 caractères max.)")

    
    @classmethod
    def one_method():
        pass
    
    @staticmethod
    def another_method():
        pass
    
    name = property()
    nme.setter(set_name)
```

Voilà on peut très bien faire ça `name = property()` parce que c'est un objet qu'on instancie et après sur name, on peut très bien faire ça `name.setter(set_name)` mais c'est beaucoup plus long sachant que dans le cours je voudrais juste montrer la syntaxe où on mettait juste property() dans lequel on définissait tout dans le constructeur ce qui allait beaucoup plus vite plutôt que de créer l'objet simplement et ensuite de setter ce que l'on veut donc ça c'est quelque chose qu'on aurait pu faire aussi mais nous on a vu que là syntaxe avec le property().

Si vous voulez le code le plus court, minimal, vous mettez juste `@property` pour le getter, et vous mettez `@property.setter` pour le setter et cetera.

```py
class Player:
    def __init__(self, name):
        self._name = name
    
    @property
    def get_name(self):
        return self._name
    
    @property.setter
    def set_name(self, name):
        if len(name) <= 25:
            self._name = name
        else:
            print("Nom incorrect (25 caractères max.)")
```

Voilà du coup on a une syntaxe qui met plus en évidence l'utilisation des décorateurs mais en fait maintenant on sait qu'on en utilise sans son rendre compte parce qu'en faisant simplement l'instanciation avec property(), classmethod() et cetera, on passait en réalité avec des décorateurs parce que là dès qu'on va vouloir accéder à l'attribut `name` ça va passer automatiquement par ces méthodes get_name() donc ça va bien faire comme le décorateur c'est-à-dire qu'il va faire l'intermédiaire entre les 2.

## Plusieurs décorateurs

Maintenant ce qu'on n'a pas vu c'est comment on doit faire lorsqu'il y a plusieurs décorateurs, et comment ça se passe ? par exemple un décorateur qui va tester quand on est connecté et puis un autre décorateur qui va vérifier si on est admin donc on va mettre les décorateurs les uns à la suite des autres.

```py
#coding:utf-8

def user_logged():
    pass

def check_admin():
    pass

@user_logged
@check_admin
def admin_panel():
    print("Le profil membre...")
```

Voilà on peut mettre tous les 2 curateurs que l'on veut avec un décorateur par ligne avec un @ qui sépare à chaque fois, très important.

Alors il y a une autre syntaxe où on met celui qui est le plus en haut, une parenthèse puis celui qui vient en dessous à chaque fois et cetera comme ceci.

```py
#coding:utf-8

def user_logged():
    pass

def check_admin():
    pass

@user_logged
@check_admin
def admin_panel():
    print("Le profil membre...")

admin_panel = user_logged(check_admin(admin_panel))
```

Voilà donc on appréciera beaucoup plus la syntaxe avec le @ au niveau du code parce qu'elle est bien plus lisible, bien plus pratique et moins source d'erreur que celle-ci `admin_panel = user_logged(check_admin(admin_panel))`.

Voilà tout simplement parce que l'ordre dans les parenthèses est très important et il y a un risque d'inverser les éléments dans les parenthèses donc on préférera les @.

Notre fonction qui permet d'accéder à la page d'administration, admin_panel() nécessitent d'être connecter `@user_logged` grâce au nom qui est suffisamment explicite de notre décorateur mais également d'être administrateur `@check_admin` donc très pratique mais pour être plus explicite on peut s'amuser à mettre des noms comme ceci `@is_logged` et `@is_admin` sans aucun souci donc c'est nous qui choisissons le nom mais il faut que ce soit pratique pour nous et surtout au niveau de la relecture.

```py
#coding:utf-8

def user_logged():
    pass

def check_admin():
    pass

@is_logged
@is_admin
def admin_panel():
    pass

admin_panel()
```

Voilà donc l'intérêt des décorateurs, on change le comportement par défaut d'une fonction et on étend des fonctionnalités, ça peut servir également pour faire du débogage aussi par exemple si on veut chercher des bugs dans quelque chose ou par exemple faire du profiling 2 jours par exemple vous avez créé plusieurs méthodes, des méthodes de tri, mais comme on ne va pas mettre des tests de rapidité dans chacune des fonctions on va donc créer un décorateur qui teste la rapidité d'exécution d'une fonction et à chaque fois que l'on veut effectuer ce test sur l'une de nos fonctions on met le décorateur et c'est terminé par exemple imaginons que notre fonction de test s'appelle profiling(). 

```py
#coding:utf-8

def profiling():
    pass

@profiling
def admin_panel():
    pass

admin_panel()
```

Voilà et automatiquement cette fonction fera passer les tests, une fois que c'est fait on n'aura plus qu à enlever le décorateur ce qui me permet de ne pas casser l'intégrité de notre fonction admin_panel() et ce qui a permis de faire nos tests tranquillement avec le décorateur.

Voilà très pratique comme fonctionnalité et encore une fois on peut s'en dispenser, programmer en python sans utiliser de décorateur donc c'est pour ça que c'est dans les tutoriels parce que ce n'est pas obligatoire et essentiel dans la programmation avec le langage python.