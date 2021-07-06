# [15. Chaînes de caractères](https://www.youtube.com/watch?v=9oibVKWzXOM)

+ [Documentation avec la fonction help](#Documentation-avec-la-fonction-help)
+ [Initialiser une chaîne de caractères](#Initialiser-une-chaîne-de-caractères)
+ [La méthode upper](#La-méthode-upper)
+ [La méthode lower](#La-méthode-lower)
+ [La méthode capitalize](#La-méthode-capitalize)
+ [La méthode title](#La-méthode-title)
+ [Une méthode de chaîne travaille sur une copie et pas sur la chaîne elle-même](#Une-méthode-de-chaîne-travaille-sur-une-copie-et-pas-sur-la-chaîne-elle-même)
+ [La méthode center](#La-méthode-center)
+ [La méthode find et index](#La-méthode-find-et-index)
+ [La méthode strip](#La-méthode-strip)
+ [La méthode replace](#La-méthode-replace)
+ [La méthode split](#La-méthode-split)
+ [Les méthodes isalpha - isdigit - isdecimal - isnumeric - isalphanum](#Les-méthodes-isalpha---isdigit---isdecimal---isnumeric---isalphanum)
+ [Les méthodes isidentifier - iskeyword](#Les-méthodes-isidentifier---iskeyword)
+ [Les méthodes isalpha - isdigit - isdecimal - isnumeric - isalphanum](#Les-méthodes-isalpha---isdigit---isdecimal---isnumeric---isalphanum)
+ [Trouver une sous-chaîne avec IF](#Trouver-une-sous-chaîne-avec-IF)
+ [Resume](#Resume)

Hello tout le monde, bienvenue pour votre séance numéro 15.

On est sur la formation en langage Python et maintenant vous avez un petit peu acquis pas mal de notions sur la programmation objet. On a parlé des classes, on a parlé des attributs, on a parlé des méthodes mais alors on aura un autre chapitre sur les méthodes spéciales, on en parle plus tard mais sachez qu'il y a ça qui vous attend pour la suite. 

On a également parlé de la notion d'héritage qui est très très importante en programmation objet qu'on aura sans doute l'occasion aussi de mettre en pratique dans des exercices, dans des projets, dans pas mal de petites choses.

Et pour faire une petite pause avec tout ça parce que ça fait beaucoup de nouvelles notions que vous avez dû apprendre. On va revenir sur des objets que vous manipulez depuis le début parce que je rappelle pour ceux qui auraient loupé quelques épisodes, que tout en python et objet. Le moindre petit truc que vous utilisez est un objet quand vous faites un nombre, vous mettez dans une variable, c'est un objet de classe int donc un entier. Quand vous écrivez un texte, c'est une chaîne de caractères donc un String donc STR, c'est un objet également, enfin c'est une classe de python pardon donc vous créer des objets de classe STR et cetera et cetera.

Hé justement comme je parlais des chaînes de caractère, je propose dans cette vidéo de revenir un petit peu là dessus, sur la chaîne de caractères, pour voir qu'est-ce qu'on peut y trouver, qu'est-ce qu'y peut être intéressant puisqu'il a évidemment beaucoup de choses à savoir.

Alors première chose à vous dire surtout à partir de ce moment de la formation maintenant qu'on a pas mal évolué, qu'on a été pas mal loin, il faut savoir que vous allez avoir des objets de plus en plus complet avec de plus en plus de choses, je ne pourrai évidemment moi pas passer tout mon temps dans une vidéo à vous montrer toutes les méthodes associé à des attribut et cetera ou alors il faudrait faire 5, 6 vidéos de chaque classe mais honnêtement ça ne servirait un petit peu à rien surtout que il y a des choses que vous n'utiliserez jamais.

Donc la première chose et c'est un petit rappel aussi que je fais, à savoir que c'est la petite fonction d'aide qui s'appelle help, qui lorsque vous mettez quelque chose entre parenthèses, vous permet de vous afficher la doc.

## Documentation avec la fonction help

Vous avez déjà la documentation officielle de n'importe quel langage ou autre sur internet mais si en plus vous voulez directement accéder à la doc ici, vous faites help() par exemple ici d'une classe donc on va appeler la classe STR.
```py
    #coding:utf-8

    help(str)
```
Je rappelle que ... je vais le mettre ici hein ... la classe STR, c'est la classe pour String c'est-à-dire les chaînes de caractères, on verra par la suite. 
```py
#coding:utf-8

# Class str : string (chaînes de caractères)

help(str)
```
Donc si je fais ça.
```powershell
>python main.py
Help on class str in module builtins:

...
```
il m'affiche tout un tas de choses avec ici voyez pas mal de pas mal ... classe str(object), class str qui hérite de la classe objet, tous les objets héritent de la classe objet qui est classe mère, très très haute en fait, tous les objets en héritent.

Maintenant que vous savez ce qu'est l'héritage, que vous comprenez bien ce que je vous dis et on a beaucoup de petites choses. Voilà, nous ce qui nous intéresse c'est à partir des méthodes qui n'ont pas dans de underscore, en capital et cetera.
```powershell
    ...

     |  capitalize(self, /)
     |      Return a capitalized version of the string.
     |
     |      More specifically, make the first character have upper case and the rest lower
     |      case.
     |
     |  casefold(self, /)
     |      Return a version of the string suitable for caseless comparisons.
     |
     |  center(self, width, fillchar=' ', /)
     |      Return a centered string of length width.
     
    ...
```
Et on va en voir plusieurs donc je vous recommande vraiment d'aller vous renseigner là dessus d'accord, d'avoir la curiosité d'aller regarder un petit peu ce que vous voyez parce que là, il y en a beaucoup beaucoup quand même, mine de rien.

Et tout ça, ce sont les méthodes de la classe STR, voilà, donc il y en a beaucoup, d'accord il y a vraiment toute une liste donc évidemment je ne vais pas vous montrer tout ça, d'accord, moi je vais vous en montrer quelques-unes qui peuvent être assez intéressantes à voir par rapport à ça et vous vous pourrez en voir d'autres. Pour la suite, vous pourrez comme ça vous familiarisez avec d'autres méthodes donc n'hésitez pas vraiment parce que je ne pourrais vraiment pas tout vous montrer.

On va avoir tellement tellement de classes comme ça qui auront plein de méthodes, pleins d'attributs que je ne pourrais pas tout vous montrer, ce sera vraiment pas possible pour moi de vous montrer un petit peu tout ce qu'on retrouve donc je vais vous montrer ce qui est le plus utilisé, ce qui va vraiment beaucoup vous servir.

Et on est parti du coup avec cette fameuse classe.
```py
    #coding:utf-8

    # Class str : string (chaînes de caractères)

    help(str)
```

## Initialiser une chaîne de caractères

Alors la chaîne de caractères, vous savez comment ça fonctionne. C'est comme par exemple quand je fait une chaîne comme ceci, du texte à l'intérieur.
```py
    #coding:utf-8

    # Class str : string (chaînes de caractères)

    ma_chaine = "Bonjour tout le monde"
```
A partir de là, l'interpréteur python va le définir comme étant une chaîne parce que j'ai mis des doubles quotes donc pour lui voilà il n'y a pas de souci en plus c'est des lettres, aucun problème, il va traiter ça comme une chaîne de caractères.

## La méthode upper

On a donc plusieurs méthodes très intéressante à ce niveau-là, alors moi je vais faire simplement print() de ma chaîne d'accord, enfin faire print() à la fin pour travailler directement là-dessus.

Première petite méthode que je peux vous montrer, des méthodes qui vont permettre de formater le texte c'est-à-dire de le modifier. On a une méthode très simple qui va être donc vous utilisez l'objet donc l'objet ici c'est "ma_chaine", un point pour choisir d'utiliser une méthode dessus et vous avez une méthode qui est upper(), elle ne prends rien, vous ne mettez rien en paramètres.
```py
#coding:utf-8

# Class str : string (chaînes de caractères)

ma_chaine = "Bonjour tout le monde"

ma_chaine = ma_chaine.upper()

print(ma_chaine)
```
Et vous allez voir un petit peu le résultat, je pense que vous l'avez un petit peu deviné, ça va tout simplement tout vous mettre en majuscule d'accord donc ça c'est très intéressant à ce niveau là pour pouvoir faire ces modifications ici.
```powershell
>python main.py
BONJOUR TOUT LE MONDE
```
On peut également avoir son l'inverse.

## La méthode lower

Alors je peux éventuellement peut-être vous en notez quelques unes. Je vous note juste les noms d'accord alors à la rigueur ici.
```py
#coding:utf-8

"""
str.upper(), str.lower()
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "Bonjour tout le monde"

ma_chaine = ma_chaine.lower()

print(ma_chaine)
```
str pour String, je ne vous apprends rien et cetera. Et si je met point lower(), je vais tout passer en minuscule donc là c'est l'inverse d'accord tout passe en minuscule, voyez, même le petit B ici majuscule que j'avais, il repasse en minuscule, pas de souci.
```powershell
    >python main.py
    bonjour tout le monde
```

## La méthode capitalize

On peut également mais là ça va être utile à la rigueur si je met "bonjour tout le monde". Une méthode capitalize() avec un seul p, voilà cette méthode ici qui elle va mettre en majuscule le début de chaque mot de votre chaîne.
```py
#coding:utf-8

"""
str.upper(), str.lower(), str.capitalize()
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "bonjour tout le monde"

ma_chaine = ma_chaine.capitalize()

print(ma_chaine)
```
```powershell
    >python main.py
    Bonjour tout le monde
```
Comme je l'avais par défaut, vous voyez le p, il l'a mit en majuscule alors qu'ici j'ai tout en minuscule.

## La méthode title

Et on a également str.title() donc je vais un peu vite parce que c'est bon je ne vais pas faire tout un commentaire de 15 minutes par méthode et là ça va mettre une majuscule à chaque début de mot, voilà donc ça c'est une petite transformation sympa, je pense qu'elles vous serviront pour vérifier comme ça un petit peu différentes choses au niveau des chaînes.
```py
#coding:utf-8

"""
str.upper(), str.lower(), str.capitalize(), str.title()
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "bonjour tout le monde"

ma_chaine = ma_chaine.title()

print(ma_chaine)
```
```powershell
    >python main.py
    Bonjour Tout Le Monde
```
Alors comme on à ces différentes méthodes là, c'est vraiment des méthodes ici de transformation d'accord, on pourra modifier directement la chaîne que l'on a.

## Une méthode de chaîne travaille sur une copie et pas sur la chaîne elle-même

Alors petite distinction, petites choses à savoir au niveau des chaînes de caractères, ça c'est vraiment la chose la plus importante, je vais même d'ailleurs la noté ici, d'accord.
```py
    """
    Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

    str.upper(), str.lower(), str.capitalize(), str.title()
    """
```
C'est-à-dire qu'une chaîne, une méthode de chaîne travaille sur une copie et pas sur la chaîne elle-même, ça c'est a bien comprendre c'est-à-dire ici d'accord quand je fais ça en fait ceci.
```py
    ma_chaine = ma_chaine.title()
```
ma_chaine.title(), ceci ça a fait une copie de ma_chaine, ça la mise comme ça avec des majuscules partout et ça réaffecté tout ça à cette variable, ma_chaine, donc c'est pas la même chaîne OK, on effectue vraiment une copie, ça c'est vraiment important à savoir parce que vous verrez que dans la prochaine vidéo où on va parler des listes, ce sera l'inverse c'est-à-dire que sur les listes, on travail directement sur elle-même et non pas sur des copies donc c'est bien savoir que au niveau des chaînes, c'est vraiment la chose la plus importante à retenir, on travail tout le temps avec les méthodes de chaîne sur une copie, d'accord.

Vous renverrez toujours une copie de la chaîne et non pas elle-même donc ça c'est important à savoir.

Du coup quand on va avoir ce genre de choses, ma_chaine = ma_chaine.title(), on va retourner une copie qui aura été modifiée d'accord, au moment je la remet dans la même variable, je ne m'embête pas mais c'est exactement ça.

Comment on peut vérifier que c'est une copie également ? on peut faire une petite vérification, on va faire ch1 égal "bonjour", on va mettre ch2 et je vais dire par exemple ch2, c'est égal à ch1 donc en fait c'est comme ci je disais le contenu de ch2, c'est ch1.
```py
    #coding:utf-8

    """
    Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

    str.upper(), str.lower(), str.capitalize(), str.title()
    """

    # Classe str : string (chaînes de caractères)

    ch1 = "bonjour"
    ch2 = ch1
```
Maintenant je vais faire ch1 égal ch1.upper() et je vais afficher ch1 et en dessous ch2, d'accord.
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title()
"""

# Classe str : string (chaînes de caractères)

ch1 = "bonjour"
ch2 = ch1

print(ch1)
print(ch2)

ch1 = ch1.upper()

print(ch1)
print(ch2)
```
Donc vous êtes d'accord qu'au début, on doit avoir la même chose parce que vous voyez, je dit que ch2 a le même contenu que ch1 et après je fais ça.
```powershell
    >python main.py
    bonjour
    bonjour
    BONJOUR
    bonjour
```
On va le voir tout de suite parce que regardez ici, vous voyez qu'il a bien modifié que ch1 c'est-à-dire que si ça avait été vraiment la même chaîne, en faisant ça en fait et bien les 2 chaînes ch1 et ch2 aurait été identique c'est-à-dire qu'elles auraient été au même emplacement mémoire donc en modifiant ici ch1, ch1 = ch1.upper(), il m'aurait modifier ch2. Là vous voyez que ça n'a pas été le cas par rapport au résultat donc effectivement, on a bien la méthode qui travaille sur une copie, ça c'est vraiment important, ça c'est vraiment à retenir.

S'il y a une chose importante dans cette vidéo à retenir, c'est ça. C'est que **les chaînes de caractères, on travaille toujours sur des copies et non pas sur la chaîne elle-même** et vous verez que ce n'est pas cas de tous les autres objets de Python et notamment les listes, voilà.

Donc je vais revenir maintenant sur mes petites méthodes. On va rester sur ce qu'on avait, on va tout éffacer-là, voilà.
```py
    #coding:utf-8

    """
    Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

    str.upper(), str.lower(), str.capitalize(), str.title()
    """

    # Classe str : string (chaînes de caractères)

    ma_chaine = "bonjour tout le monde"

    ma_chaine = ma_chaine.title()

    print(ma_chaine)
```
Voilà ici, c'était pas mal donc toutes ces petites méthodes là sont intéressantes à savoir et permettre bien évidemment de travailler sur des copies, voilà.

    str.upper(), str.lower(), str.capitalize(), str.title()

Qu'est-ce que je peux vous montrer d'autres ? je vais vous en montrer une maintenant qui peut être utile pour notamment changer un petit peu l'affichage, str.center(), je vous la mets ici.
```py
    #coding:utf-8

    """
    Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

    str.upper(), str.lower(), str.capitalize(), str.title(), str.center()
    """

    # Classe str : string (chaînes de caractères)

    ma_chaine = "bonjour tout le monde"

    ma_chaine = ma_chaine.title()

    print(ma_chaine)
```
Voyez que je ne mets pas à chaque fois, notamment ici, je ne vais pas vous mettre toujours les différents arguments d'accord donc je ne vais pas vous voulez les mettre toutes parce qu'il y a vraiment beaucoup.

## La méthode center

str.center(), elle va prendre une largeur d'accord et éventuellement, ça c'est pas obligatoire, un caractère remplissage.
```py
        str.center(<largeur>, <caractere_remplissage>)
```
Normalement, il faudra mettre des crochets pour montrer que c'est obligatoire mais ça va faire une syntaxe très très moche donc je préfère rester comme ça.

Alors au niveau de ça, je vais dire par exemple "MonSuperProgramme", ce genre de chose et je vais l'afficher comme ça par défaut.
```py
    #coding:utf-8

    """
    Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

    str.upper(), str.lower(), str.capitalize(), str.title(), 
    str.center(<largeur>, <caractere_remplissage>)
    """

    # Classe str : string (chaînes de caractères)

    ma_chaine = "MonSuperProgramme"
    print(ma_chaine)

    ma_chaine = ma_chaine.center()
    print(ma_chaine)
```
Ensuite qu'est-ce qu'il se passe une fois que je fais center ? Admettons que je fais :
```py
    ma_chaine = ma_chaine.center(20)
```
Alors ça veut dire en fait qu'il va compter 20 caractères de largeur pour la chaîne donc en déduisant cela, "MonSuperProgramme", c'est-à-dire que ça va être 20 moins cela, "MonSuperProgramme", donc si "MonSuperProgramme" fait pile 20, vous n'allez voir aucune différence.

En revanche là, "MonSuperProgramme", s'il n'y a pas 20 caractères et bien ça va compléter avec des espaces avant et après.
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "MonSuperProgramme"
print(ma_chaine)

ma_chaine = ma_chaine.center(20)
print(ma_chaine)
```
Donc on test et là vous voyez que ça a complété un petit peu.
```powershell
    >python main.py
    MonSuperProgramme
     MonSuperProgramme
```
Alors je vais en rajouter un peu plus parce que ça ne fait pas beaucoup, on ne voit pas trop la différence sinon, voilà.
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "MonSuperProgramme"
print(ma_chaine)

ma_chaine = ma_chaine.center(50)
print(ma_chaine)
```
```powershell
    >python main.py
    MonSuperProgramme
                    MonSuperProgramme
```
D'accord donc là on voit que ici en fait jusque là-bas sûrement un peu près, on a 50 caractères d'accord donc il y a les caractères de MonSuperProgramme qui sont inclus.
```txt
 -->                MonSuperProgramme                 <--
```
Et si je veux en plus les remplir avec quelque chose, avec un seul caractère, je peux faire comme ça avec un 2e paramètre. Je mets par exemple un petit - (tiret).
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "MonSuperProgramme"
print(ma_chaine)

ma_chaine = ma_chaine.center(50, "-")
print(ma_chaine)
```
```powershell
    >python main.py
    MonSuperProgramme
    ----------------MonSuperProgramme-----------------
```
Et là regardez, voilà on a un petit affichage formater euh un peu plus proprement en tout cas que si on le faisait à la main.

Voilà donc tout ça.
```txt
    ----------------MonSuperProgramme-----------------
```
On a bien 50 d'accord, on va avoir 50 ici de là à là et tout ce qui ne fait pas partie de la chaîne que l'on a, ça va être rempli par le caractère qu'on a passé en 2nd paramètre donc il n'est pas obligatoire mais vous pouvez le faire. C'est tout à fait possible, c'est pas obligatoire mais il peut être utilisé éventuellement. On peut mettre des underscores, on peut mettre ce que l'on veut mais c'est un seul caractère, attention. Pas plusieurs, c'est vraiment sur un seul et là comme ça vous pouvez travailler de cette manière, ça peut être sympa pour changer un peu le formatage, voilà pour cette petite méthode.

## La méthode find et index

Qu'est-ce que je peux vous montrer d'autres également ? Après on verra des méthodes un peu plus poussée si vous voulez mais pour le moment, je voulais rester là-dessus. On peut avoir des méthodes pour faire de la vérification, de la recherche, ça peut être pas mal. On va regarder ça un petit peu.

On a str.find() donc `str.find(<chaine>, <début>, <fin>)`, il va chercher une chaîne. Il peut éventuellement chercher vers un début et une fin et on va voir `str.index(<chaine>, <début>, <fin>)` mais on verra si c'est bien ça à l'exécution. 
```py
    #coding:utf-8

    """
    Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

    str.upper(), str.lower(), str.capitalize(), str.title(), 
    str.center(<largeur>, <caractere_remplissage>)

    str.find(<chaine>, <début>, <fin>)
    str.index(<chaine>, <début>, <fin>)
    """

    # Classe str : string (chaînes de caractères)
```
Alors ces 2 méthodes vont permettent de faire de la recherche en fait de quelque chose c'est-à-dire que dans "MonSuperProgramme" ici d'accord, je peux vérifier alors on va un print() directement.
```py
    #coding:utf-8

    """
    Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

    str.upper(), str.lower(), str.capitalize(), str.title(), 
    str.center(<largeur>, <caractere_remplissage>)

    str.find(<chaine>, <début>, <fin>)
    str.index(<chaine>, <début>, <fin>)
    """

    # Classe str : string (chaînes de caractères)

    ma_chaine = "MonSuperProgramme"
    
    print(ma_chaine)
```
Je veux vérifier est-ce que dans ma chaîne je peux trouver le terme super d'accord comme ceci, on va tester.
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)

str.find(<chaine>, <début>, <fin>)
str.index(<chaine>, <début>, <fin>)
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "MonSuperProgramme"

print(ma_chaine.find("super"))
```
```powershell
    >python main.py
    -1
```
Alors là, il vous met -1 puisqu'il ne le trouvera pas tout simplement puisque c'est pas la même casse d'accord.

Il faut vraiment respecter la casse, ici il vous met 3 alors pourquoi il met 3 à votre avis ? 3 en fait ça va être l'indice à partir de la chaîne.

Vous savez par exemple qu'une chaîne, on pourrait sans problème faire ceci print(ma_chaine[2]).
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)

str.find(<chaine>, <début>, <fin>)
str.index(<chaine>, <début>, <fin>)
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "MonSuperProgramme"

print(ma_chaine[2])

print(ma_chaine.find("Super"))
```
```powershell
    >python main.py
    n
    3
```
Voyez en faisant 2, je lui dis tu m'affiche le caractère qui est l'indice 2. Le caractère en premier, c'est toujours l'indice 0, ensuite on a 1, ensuite on a 2 donc il affiche bien le n.

Donc là, c'est pareil, il vous dit à quel moment de la chaîne en fait il trouve le mot super donc il ne le trouve pas à partir du l'indice 0, ni à partir de l'indice 1, ni à partir de l'indice 2 mais à partir de l'indice 3 et effectivement il y a le mot super donc c'est à ça que ça sert.

On a l'équivalent avec index() ... alors je vais un peu vite encore une fois parce que c'est la même chose ... index() va retourner la même chose par contre vous avez vu tout à l'heure que ça à mis -1 quand ça n'avait pas fonctionné.
```txt
    ma_chaine = "MonSuperProgramme"
    print(ma_chaine[2])
    print(ma_chaine.find("super"))

    >python main.py
    n
    -1
```
Pour index(), si le mot, "super", il ne le trouve pas d'accord, il ne va pas retourner une valeur genre -1, il va lever une exception ValueError en mettant sa subtring not found pour dire qu'il n'a pas trouvé la sous-chaîne.
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)

str.find(<chaine>, <début>, <fin>)
str.index(<chaine>, <début>, <fin>)
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "MonSuperProgramme"

print(ma_chaine.index("super"))
```
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 521, in <module>
        print(ma_chaine.index("super"))
    ValueError: substring not found
```

L'avantage c'est que vous pouvez faire une petite vérification propre en faisant comme ça par exemple, en disant voilà "Je n'ai pas trouvé cette chaîne" pour pouvoir gérer l'exception, d'accord. 
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)

str.find(<chaine>, <début>, <fin>)
str.index(<chaine>, <début>, <fin>)
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "MonSuperProgramme"

try:
   print(ma_chaine.index("super"))
except ValueError:
   print("Je n'ai pas trouvé cette chaîne")
```
```powershell
    >python main.py
    Je n'ai pas trouvé cette chaîne
```
Voilà pour gérer l'exception donc très pratique donc c'est une différence voilà si vous avez besoin de gérer les exceptions, utiliser plutôt index() à la place de find(), ça peut être utile donc ça va vous rendre tout simplement l'indice à partir du moment où la première fois dans la chaîne où ce mot-là a été trouvé donc ça a tout un intérêt, c'est vraiment bien à savoir.

## La méthode strip

Je vous ai montré pas mal de petites choses, qu'est-ce qu'on peut voir également ? ça je vais mettre ici, str.strip(), agit sur les chaînes et qui va enlever tous les espaces, d'accord.
```txt
    str.index(<chaine>, <début>, <fin>)
```
Si par exemple, voyez, je mets plein d'espaces bizarres, d'accord.
```txt
    ma_chaine = "       MonSuperProgramme       "
```
Si je fais un print() normal, on va avoir ça, print(ma_chaine). Si en revanche, je fais un print() de ma_chaine.strip(), il va enlever tous les espaces avant et après c'est important donc là voyez plus d'espace.
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)
str.strip()

str.find(<chaine>, <début>, <fin>)
str.index(<chaine>, <début>, <fin>)
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "       MonSuperProgramme       "

print(ma_chaine)
print(ma_chaine.strip())
```
```powershell
    >python main.py
           MonSuperProgramme
    MonSuperProgramme
```
Donc là, vous voyez, plus d'espaces, on est tranquille, il n'y a pas de soucis.

D'ailleurs on aurait pu faire des choses comme ça, ça vous aurait mieux indiqué, ça se verra mieux en visuel, voilà.
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)
str.strip()

str.find(<chaine>, <début>, <fin>)
str.index(<chaine>, <début>, <fin>)
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "[       MonSuperProgramme       ]"

print(ma_chaine)
print(ma_chaine.strip())
```
```powershell
    >python main.py
    [       MonSuperProgramme       ]
    [       MonSuperProgramme       ]
```
Donc là, il n'enlève rien parce qu'il n'y a pas d'espace avant et après tout seul, d'accord ça c'est important à savoir, c'est pour ça que je voulais vous montrer.

Quand vous mettez un symbole, [], pour lui l'espace fait partie de l'affichage que vous voulez, ce ne sont pas des espaces blancs.

Un espace blanc, on appelle ça comme ça quand c'est un espace qui est avant ou après un mot c'est-à-dire un espace qui ne sert à rien en fait. S'il n'y a rien entre 2, c'est pas la peine. 

Donc si vous mettez une phrase avec plusieurs mots, il ne va pas enlever les espaces entre les mots par contre il enlèvera les espaces avant le tout premier mot et après le dernier donc ça c'est important à savoir, voilà pour strip(), voilà pour center, on a vu tout ça.

## La méthode replace

Qu'est-ce que je peux vous montrer d'autres parce que, je vous dis, il y en a vraiment beaucoup de méthode. J'ai pas forcément l'intérêt de toutes les montrer parce qu'il y en a plein que vous n'utiliserez jamais donc c'est pas forcément utile mais on peut en voir quand même quelques-unes comme on avait fait de la recherche ici, on peut faire aussi également du remplacement, ça je peux vous la montrer parce qu'elle est quand même utile. 
```
    str.replace(<ancienne>, <nouvelle>)
```
Elle prend l'ancienne chaîne, la nouvelle et on peut même éventuellement choisir dans les paramètres non obligatoire ... comme ici où pour début et fin, je n'ai pas forcément montré, vous pouvez dire entre quel moment et quel endroit de la chaîne, vous faites la recherche, d'accords.
```
    str.find(<chaine>, <début>, <fin>)
    str.index(<chaine>, <début>, <fin>)
```
<début> par exemple si vous mettez 0 c'est-à-dire qu'il cherche à partir du premier caractère. Si on met 3 c'est-à-dire qu'il cherche jusqu'au caractère d'indice 3.

Et là on va avoir pareil pour replace(), c'est pas obligatoire d'ailleurs, ça va être par exemple le nombre occurrence, voilà.
```py
    """
    Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

    str.upper(), str.lower(), str.capitalize(), str.title(), 
    str.center(<largeur>, <caractere_remplissage>)
    str.strip()

    str.find(<chaine>, <début>, <fin>)
    str.index(<chaine>, <début>, <fin>)
    str.replace(<ancienne>, <nouvelle>, <occurences>)
    """
```
Donc là, on va simplement faire "ababababa" ce genre de choses tout simplement.
```py
    ma_chaine = "ababababa"
```
Vous faites ensuite.
```py
    ma_chaine = ma_chaine.replace("a", "z")
```
Vous dites de remplacer toutes les lettres "a" en minuscule bien sûr par des lettres z et j'affiche avant et après pour voir mes résultats, voilà.
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)
str.strip()

str.find(<chaine>, <début>, <fin>)
str.index(<chaine>, <début>, <fin>)
str.replace(<ancienne>, <nouvelle>, <occurences>)
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "ababababa"
print(ma_chaine)

ma_chaine = ma_chaine.replace("a", "z")
print(ma_chaine)
```
```powershell
    >python main.py
    ababababa
    zbzbzbzbz
```
Donc on peut faire comme ça du remplacement. Si je ne veux pas faire des remplacements sur tout, je peux le préciser ici ma_chaine.replace("a", "z", 2) par exemple je mets 2.
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)
str.strip()

str.find(<chaine>, <début>, <fin>)
str.index(<chaine>, <début>, <fin>)
str.replace(<ancienne>, <nouvelle>, <occurences>)
"""

# Classe str : string (chaînes de caractères)

ma_chaine = "ababababa"
print(ma_chaine)

ma_chaine = ma_chaine.replace("a", "z", 2)
print(ma_chaine)
```
```powershell
    >python main.py
    ababababa
    zbzbababa
```
Donc là regarder ce qu'il se passe, voyez qu'il a modifié que les 2 premières occurrence et après il ne modifie plus d'accord, il laisse.

Donc ça c'est assez intéressant à savoir parce que c'est permet comme ça de faire des remplacements sur une certaine partie de votre chaêne donc c'est bien à savoir et c'est un paramètre ici, <occurences>, qui est optionnel d'accord, il n'est pas obligatoire donc c'est 2 là, <ancienne> et <nouvelle>,sont obligatoires mais celui-là <occurences> n'est pas obligatoire.

Pareil pour find() et index(), ces 2 paramètres, <début> et <fin>, ne sont pas obligatoires. Vous avez vu quand je les utilisaient, je ne les ai pas mis.

Donc ça permet de travailler en fait sur une toute petite partie de la chaîne, ces 2 paramètres-là donc moi, je ne les ai pas mis donc il a travaillé surtout pour faire de la recherche comme ça de sous-chaîne.

Voilà donc vous avez vu comme ça maintenant, pas mal de transformation, de formatage, vous avez vu comment faire de la recherche, comment faire du remplacement. Je pense que c'est pas mal de petites choses sur ces chaînes-là, je pense qu'on a fait un peu le tour de tout ce qui pouvait être intéressant.

## La méthode split

Qu'est-ce que je pourrais vous montrer également ? euh oui, comme on va parler des listes la prochaine fois, c'est bien que je vous montre justement comment faire une coupure de chaîne pour la transformer en liste.

Alors vous ne savez pas ce que c'est une liste, vous le verez la prochaine fois de toute manière, ne vous en faites pas mais par exemple si vous faites ceci. 

phrase égal ... je vais faire une espèce de protocole, par exemple, je mets un magicien, admettons un jeu des cartes ou n'importe quoi, j'ai donc le nom de la carte par exemple, je mets ensuite une barre verticale et je mets ces points d'attaque, ensuite je met une barre verticale et je met ses points en défense, admettons, ce genre de choses.

phrase = "Magicien|10|5"

Eh bien, je peux faire tout simplement un print() de phrase.split() et je choisi le séparateur qui va me permettre de couper donc c'est-à-dire ici la barre verticale, d'accord.
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)
str.strip()

str.find(<chaine>, <début>, <fin>)
str.index(<chaine>, <début>, <fin>)
str.replace(<ancienne>, <nouvelle>, <occurences>)
"""

# Classe str : string (chaînes de caractères)

phrase = "Magicien|10|5"

print(phrase.split("|"))
```
```powershell
    >python main.py
    ['Magicien', '10', '5']
```
Et là automatiquement vous avez vu comment il fait l'affichage.

Il vient d'afficher quelque chose entre crochets comme ça avec plein de virgules, vous ne savez pas ce que c'est cette notation un peu bizarre...
```py
    ['Magicien', '10', '5']
```
Mais c'est tout simplement une liste, d'accord, c'est ce que nous allons voir dans la vidéo prochaine dans la séance numéro 16 donc ça permettra comme ça de faire un peu la transition.

On verra d'ailleurs comment faire l'effet inverse c'est-à-dire de rassembler les choses voilà mais il y a une méthode join() pour les chaînes mais je ne peux pas l'utiliser pour le moment puisque vous n'êtes pas censé connaître les listes donc je ne vais pas l'utiliser pour tout de suite. On verra ça la prochaine fois donc ça, ça peut être utile à savoir, d'accord, le split() comme ça pour obtenir une liste et ça vous parlera surtout dans la prochaine vidéo.

## Les méthodes isalpha - isdigit - isdecimal - isnumeric - isalphanum

On va terminer du coup avec quelques petites méthodes assez intéressantes, je pense au niveau des chaîne tout simplement.

Je vais vous en montrer plein parce qu'il y en a vraiment beaucoup.
```py
    str.isalpha(), str.isdigit(), str.isdecimal(), str.isnumeric(), str.isalphanum()
```
Et c'est déjà pas mal, voilà. 
```py
    str.islower(), str.isupper()
    str.isidentifier(), str.iskeyword()
```
Après, on a bien évidemment str.islower() pour vérifier qu'une chaîne est écrite en minuscule. str.isupper() pour vérifier qu'une chaîne est écrite en majuscule et on va avoir par exemple str.isidentifier() et str.iskeyword(). Je ne vais pas toutes les montrer encore une fois notamment quand on a un mot réservé donc je vais en tester quelques-unes là-dedans, d'accord.

Donc par exemple quand vous faites ch, une chaîne comme ça, que vous mettez "Bonjour". Si vous vérifiez ça, if ch.islower().
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)
str.strip()

str.find(<chaine>, <début>, <fin>)
str.index(<chaine>, <début>, <fin>)
str.replace(<ancienne>, <nouvelle>, <occurences>)

str.isalpha(), str.isdigit(), str.isdecimal(), str.isnumeric(), str.isalphanum()

str.islower(), str.isupper()

str.isidentifier(), str.iskeyword()
"""

# Classe str : string (chaînes de caractères)

ch = "Bonjour"

if ch.islower():
   print("Minuscule")
else:
   print("La chaîne contient des majuscules") 
```
```powershell
    >python main.py
    La chaîne contient des majuscules
```
OK, donc ça permet de faire des petites vérifications dans des IF parce que ça retourne vrai ou faux ce genre de de fonction, de méthode. Soit c'est effectivement le cas et ça retourne True, soit ce n'est pas le cas et ça retourne False donc un booléen, tout simplement.

Le retour de la méthode est un booléen.

## Les méthodes isidentifier - iskeyword

Vous pouvez également avoir des mots-clés, vous savez par exemple le mot classe est réservé parce que pour créer une classe en python, je le fais ce genre de chose, class Animal, et cetera.
```py
    class Animal:
        def __init__
```
D'ailleurs le def est également un mot réservé, ce genre de chose et puis on peut vérifier ça avec isidentifier(), voilà.
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)
str.strip()

str.find(<chaine>, <début>, <fin>)
str.index(<chaine>, <début>, <fin>)
str.replace(<ancienne>, <nouvelle>, <occurences>)

str.isalpha(), str.isdigit(), str.isdecimal(), str.isnumeric(), str.isalphanum()

str.islower(), str.isupper()

str.isidentifier(), str.iskeyword()
"""

# Classe str : string (chaînes de caractères)

ch = "class"

if ch.isidentifier():
   print("Réservé")
else:
   print("Libre") 
```
```powershell
    >python main.py
    Réservé
```
La chaîne c'est "class" et je vérifie si c'est un identifiant et il vous met réservé effectivement.

Le mot class est un mot réservés du langage python donc quelques petites méthodes comme ça qu'on peut vérifier.

## Les méthodes isalpha - isdigit - isdecimal - isnumeric - isalphanum

Et ça.

str.isalpha(), str.isdigit(), str.isdecimal(), str.isnumeric(), str.isalphanum()

C'est pour les nombres d'accord, si c'est juste des caractères alphabétiques, des caractères numériques ou décimaux et cetera et des caractères alphanumériques, voilà, ça permet comme ça de faire des tests, des vérifications sur le type de données que vous avez dans une chaîne donc ça peut être intéressant voilà voilà.

Si par exemple dans votre chaîne, vous mettez ceci.
```py
    ch = "1B"
```
Voilà après ça permettra de voir comme ça si on peut vérifier le fait d'avoir un caractère numérique par exemple donc c'est intéressant je pense. Je voulais vous montrer donc n'hésitez pas à aller prendre note pour ceux qui ça intéresse.

De toute manière, il y en aura beaucoup d'autres à voir, vous aurez peut être besoin de certaines méthodes en particulier, là c'était vraiment histoire de vous montrer des méthodes assez pratique qu'on va avoir l'usage assez souvent donc c'est bien de le savoir mais vous n'êtes pas obligé de tout retenir.

## Trouver une sous-chaîne avec IF

On peut faire également une recherche de sous-chaine, par exemple vous voulez chercher si une chaîne appartient à une autre très rapidement dans un IF, il y a une méthode très simple aussi directement dans le code. Par exemple si je fait ça, ch = "La langage Python", hé bien je peux faire rechercher de cette manière-là, je peux dire si "langage" est dans la chaîne d'accord et bien du coup, on a trouvé le mot et sinon on met non trouvé.
```py
#coding:utf-8

"""
Une méthode de chaîne travaille sur une copie, et pas sur la chaîne elle-même.

str.upper(), str.lower(), str.capitalize(), str.title(), 
str.center(<largeur>, <caractere_remplissage>)
str.strip()

str.find(<chaine>, <début>, <fin>)
str.index(<chaine>, <début>, <fin>)
str.replace(<ancienne>, <nouvelle>, <occurences>)

str.isalpha(), str.isdigit(), str.isdecimal(), str.isnumeric(), str.isalphanum()

str.islower(), str.isupper()

str.isidentifier(), str.iskeyword()
"""

# Classe str : string (chaînes de caractères)

ch = "Le langage Python"

if "langage" in ch:
    print("Trouvé")
else:
    print("Non trouvé") 
```
Pas besoin d'avoir une méthode, vous faites juste ça, une petite syntaxe dans un IF avec la chaîne que vous chercher dans (in) une autre chaîne et ça, ça fonctionne aussi.
```powershell
    >python main.py
    Trouvé
```
Donc très pratique, pas besoin d'utiliser la méthode find() où je ne sais quoi, bref pour retourner des index(). Là vous faites juste ça, ça permet de vérifier une sous-chaîne dans une autre donc ça c'est vraiment bien pour de la recherche, très rapide, en une ligne, on fait notre recherche directement, ça peut être vraiment pas mal.

On peut également chercher un mot par exemple dans une phrase, ça peut être très pratique par cette manière-là.

Ecoutez normalement j'ai fais un peu le tour de tout ce qui pouvait vraiment vous être utile même des choses qui ne seront pas forcément utile au début parce qu'il y a plein de méthodes que vous n'utiliserez probablement jamais ou alors en tout cas pas tout de suite mais en tout cas, vous en avez beaucoup.

N'oubliez pas dans la documentation ou en utilisant la fonction help(), vous pouvez voir toute la liste des méthodes disponibles, des attributs et cetera sur les chaînes, comme ça, on pourra trouver peut-être quelque chose en particulier avant de l'inventer s'il existe déjà notamment en natif mais-là, vous avez pas mal de choses utiles pour les chaînes de caractères donc voyez, c'est un objet très sympa, d'accord, on manipule cet objet depuis le début, dès qu'on utilisait justement des chaînes, on était en train de faire des objets de Classe STR en Python et vous voyez que comme c'est un objet donc de classe STR, on a plusieurs méthodes disponibles que l'on peut utiliser évidemment pour faire certaines transformation, certaines modifications, des vérifications aussi, des changements, des remplacements, des recherches, bref pas mal de petites possibilités avec cette classe.

Donc je voulais vous faire une vidéo du coup dessus, c'est pour ça qu'il y a eu cette séance 15 sur les chaînes de caractères.

Pour la prochaine vidéo, nous parlerons des listes donc en attendant, n'hésitez pas à laisser des commentaires, à partager la vidéo comme d'habitude, toujours à laisser des like, des dislike selon si la vidéo vous a appris quelque chose, vous a intéressé et on se trouvera pour la suite.

Si vraiment, il y a des choses pas claires, ça peut arriver, n'hésitez pas à parce qu'on commence à arriver sur des choses assez complexes même si on lâche un petit peu les notions propre à l'objet, on va quand même revoir pas mal de nouveaux types, de nouvelle classe du langage python donc ça va faire pas mal de syntaxe en plus donc si des choses ne sont pas très claires, si vous avez des questions comme d'habitude, je réponds à tous les commentaires sur youtube donc n'hésitez pas, c'est là que je passe en priorité quand les gens ont besoin d'aide, voilà.

N'hésitez pas dans tous les cas, je fait un petit rappel aussi, vous savez qu'il y a un discorde qui est en place donc vous avez la petite icône pour rejoindre le discord directement sur l'illustration de la chaîne sinon si vous ne savez pas trop comment ça fonctionne ou que vous ne savez pas trop comment y accéder, vous me laissez un petit commentaire pour me demander, je vous fournirai le discours donc c'est un serveur vocal pour ceux qui ne connaissent pas.

Un petit serveur vocal ou des petits salons textuel pour pouvoir parler entre abonnés et vous aidés entre vous voilà donc c'est très utile donc temps en temps, je le rappelle comme ça dans quelques vidéos, c'est bien de le savoir.

A très bientôt tout le monde, entraînez vous bien bonne programmation bon apprentissage sur le langage python et bon courage à tous 

## Resume

```py
#coding:utf-8

# Python #15 - chaînes de caractères
# https://www.youtube.com/watch?v=9oibVKWzXOM
# Retour sur la chaîne de caractères, qui est un des objets du langage Python, sur lequel vous allez pouvoir utiliser un certain nombre de méthodes.

import os
os.system("cls")

"""
(Vu jusqu'a maintenant)
On a parlé des classes, des attributs, des méthodes.
On a parlé de la notion d'héritage qui est très importante en programmation objet.

(Dans cette vidéo)
Retour sur quelques objet vus car "Tout en Python est objet".
Quand on fait un nombre que l'on met dans une variable, il devient un objet de class int.
Quand on écrit un texte, c'est une chaîne de caractères donc un string. str est une classe également de Python.
On crée des objets de classe str, etc.
On a des objets de plus en plus complet avec de plus en plus de choses pour les quelles, on ne pourrait pas voir
toutes les méthodes, associer les attributs, etc. Autrement il faudrait faire 5-6 vidéos de chaque classe
avec beaucoup de notions qui ne serviront jamais. 

(Méthodes vues dans cette vidéo)

str.upper(), str.lower(), str.capitalize(), str.title()
str.center(<largeur>, <caractere_remplissage>)
str.strip()

str.find(<chaine>, <debut>, <fin>)
str.index(<chaine>, <debut>, <fin>)
str.replace(<ancienne>, <nouvelle>, <occurences>)

Une méthode de chaine travaille sur une copie, et pas sur la chaine elle-même.

str.isalpha(), str.isdigit(), str.isdecimal(), str.isnumeric(), str.isalphanum()

str.islower() : verifier qu'une chaine est ecrite en minuscule.
str.isupper() : verifier qu'une chaine est ecrite en majuscule.

str.isidentifier(), str.iskeyword() pour quand on a notamment un mot reserve.

"""

#1# HELP() : fonction d'aide pour afficher la Doc
#   ---------------------------------------------
#

""" On a la documentation officiel de n'importe quel langage sur Internet mais si en plus 
on veux accéder à la Doc ici, faites help() d'une classe. Par exemple la classe str. 

Classe str : c'est la classe pour string (chaines de caractère). """

#help(str)

""" Dans l'affichage, on voit que la class str hérite de la classe objet. Objet qui est une classe
Mère. Tous les objets héritent de la classe objet qui est une classe Mère, une classe très très haute.

On s'intéresse aux méthodes qui n'ont pas de underscores.

Il y a ainsi tellement de classe avec tellement de méthodes et d'attributs qu'on ne serrait tout voir.
"""
#2# Comment fonctionne la chaine de caractères.
#   -------------------------------------------
#

ma_chaine = "Bonjour tout le monde. "

""" 
L'interprêteur Python va définir ceci comme une chaine car on a mit des doubles quotes.
A partir de là, on a plusieurs méthodes intéressantes. 
"""
#-1-    UPPER()
#       Méthode qui va permettre de formater une chaine, de la modifier.
#
""" La méthode consiste à utiliser l'objet, qui est ma chaine.
On met un point pour choisir d'utiliser une méthode dessus. 
Elle ne prend rien en paramètres.
Elle permet de tout mettre en majuscule.""" 
ma_chaine = "Bonjour tout le monde. "
ma_chaine = ma_chaine.upper()
print(ma_chaine)

#-2-    LOWER()
#       Méthode qui permet de tout passer en minuscule.
#
ma_chaine = "Bonjour tout le monde. "
ma_chaine = ma_chaine.lower()
print(ma_chaine)

#-3-    CAPITALIZE()
#       Méthode qui met en majuscule le début de chaque mot.
#
ma_chaine = "Bonjour tout le monde. "
ma_chaine = ma_chaine.capitalize()
print(ma_chaine)

#-4-    TITLE()
#       Méthode qui met une majuscule à chaque début de mot.
#
ma_chaine = "Bonjour tout le monde. "
ma_chaine = ma_chaine.title()
print(ma_chaine)

"""
Quelques petites transformations sympa pour vérifier différentes choses au niveau des chaînes.
Ce sont des méthodes de transformations pour modifier directement la chaine que l'on a.

Une méthode de chaine travaille sur une copie, et pas sur la chaine elle-même.
Quand je fait "ma_chaine.title()", ça a fait une copie de ma chaine qui a ensuite été réaffecté à
ma variable "ma_chaine = ma_chaine.title()". Ce n'est pas la même chaîne car on effectue une copie.
Quand on va parler des liste (Vidéo 16), ce sera l'inverse. Sur les liste, on travaille directement
sur elle-même et pas sur des copies. 

Au niveau des chaînes, c'est vraiment la chose, la plus importante à retenir. On travaille tout 
le temps sur les méthodes de chaines avec une copie. On retourne toujours une copie de la chaine et pas elle-même.
"""

#3# Comment vérifier qu'il s'agit d'une copie ?
#   -------------------------------------------
#
"""
Quand on a "ma_chaine.title()", on va retourner une copie que l'on peut stocker dans une variable.
Comment vérifier qu'il s'agit d'une copie ?
"""
ch1 = "bonjour"
ch2 = ch1 # le contenu de ch2, c'est ch1.
print(ch1)
print(ch2)
ch1 = ch1.upper()
print(ch1)
print(ch2)
""" On constate qu'il a bien modifié que ch1. Si ca avait été la même chaîne,
en faisant "ch2 = ch1", les deux chaines auraient été identique. Elles auraient été 
au même emplacement mémoire. Donc on a bien la méthode qui travaille sur une copie.

Les chaines de caractères, on travaille toujours sur des copies. Par contre ce n'est
pas le cas de toutes les autres classes et objets de Python, notamment pour les listes.
"""

#4# Comment fonctionne la chaine de caractères (suite).
#   ---------------------------------------------------
#

#-5-    CENTER(<largeur>, <caractere_remplissage>)
#       Méthode qui permet de changer l'affichage, le formatage.
#
ma_chaine = "MonSuperProgramme."
print(ma_chaine)
""" Si je met le 1er paramètre à 20, il va compter 29 caractères de largeur pour la chaine.
en déduisant 20 moins "MonSuperProgramme.". Ca veut dire que si "MonSuperProgramme." fait pile
20 caractères, on ne verra aucune différence. Et si "MonSuperProgramme." contient moins de 20 caractères, 
ça va compléter avec avec des espaces avant et après... """
#ma_chaine = ma_chaine.center(50)
#print(ma_chaine)
""" ... un deuxieme paramètre pour formater l'affichage avec un caractère choisi pour remplacer les espaces vides. """
ma_chaine2 = ma_chaine.center(50, "-")
print(ma_chaine2)
""" Le total de caractères est de 50 (1er paramètre) et tout ce qui ne fait pas partie de notre chaine
va être rempli par le caractère qu'on a passé en second paramètre. 

On peut mettre ce que l'on veux comme caractere de remplacement mais qu'un seul caractère, pas plusieurs.

"""
#5# Méthode pour faire de la recherche.
#   -----------------------------------
#

#-6-    FIND(<chaine>, <debut>, <fin>)
#       Méthode qui va chercher une chaine, vers un début et vers une fin. 
#
""" Vérifier si dans ma chaine, je peux trouver le terme super."""
ma_chaine = "MonSuperProgramme."
print(ma_chaine.find("super"))
""" Il nous met -1 parce qu'il nous le trouvera pas marce que ce n'est pas la même case."""
print(ma_chaine.find("Super"))
""" Il nous met 3 parce que c'est l'indice, le nombre de caractères qui précède le mot."""
print(ma_chaine[2])
""" Idem mais on retourne en plus le caractère qui a l'indice 2.
ça nous permettrais de savoir à quel endroit il trouve le mot "Super".
Il le trouve à partir de l'indice 3 (ni 0, ni 1, ni 2)."""

#-7-    INDEX(<chaine>, <debut>, <fin>)
#       Méthode équivalente à find() sauf que si il ne trouve pas, il ne va pas
#       afficher -1 mais lever une exception.
#
ma_chaine = "MonSuperProgramme."
print(ma_chaine.index("Super"))
#print(ma_chaine.index("super"))
""" Il nous lève une exception si il ne trouve pas "ValueError : substring not found".
Il n'arrive pas à trouver la sous-chaine. """

# On peut procéder à une vérification try/except :
""" De la manière suivante, on peut gérer l'exception."""

try:
   print(ma_chaine.index("super"))
except ValueError:
   print("Je n'ai pas trouvé cette chaine")

""" Il est recommandé d'utiliser index() à la place de find().

L'intéret est de rendre l'indice à partir du moment ou la première fois
dans la chaine, la sous-chaine a été trouvée."""


#-8-    STRIP()
#       Méthode qui va enlever tout les espaces avant et après la chaine.
#
ma_chaine = "              MonSuperProgramme.               "
print(ma_chaine)
print(ma_chaine.strip())
""" Les espaces sont retirés."""
ma_chaine = "[              MonSuperProgramme.               ]"
print(ma_chaine)
print(ma_chaine.strip())
""" Dans ce cas, il n'enlève rien parce qu'il n'y a pas d'espace tout seul avant et après.
En effet, ce ne sont pas des espaces blanc. Un espace blanc est un espace avant ou après un mot.
c'est à dire un espace qui ne sert à rien. Il n'enlevera pas l'espace entre les mots dans un texte.
Il enlevera les espaces avant le premier mot et après le dernier mot.
"""

#-9-    REPLACE(<ancienne>, <nouvelle>, <occurences>)
#       Méthode qui permet de remplacer une ancienne chaine par une nouvelle
#
""" C'est pareil (<debut> et <fin> non obligatoire) pour FIND() et INDEX(), on peux choisir entre quel moment et 
quel autre moment de la chaine, je fait de la recherche. Si on met 0, c'est qu'il va chercher à partir du 
premier caractère et si on met 3 en fin, ca signifie qu'il cherche jausqu'au caractère d'indice 3.

C'est pareil pour REPLACE(), parmi les paramètre non obligatoire, on a le nombre d'occurence. """

ma_chaine = "ababababa"
print(ma_chaine)
ma_chaine = ma_chaine.replace("a","z") # Remplace toutes les lettres "a" en minuscule par des lettres "z".
print(ma_chaine)

# Remplacement sur une partie.
# 

""" Ceci est une méthode pour faire du remplacement. Si on ne veux pas faire de remplacement sur tout, 
on peut le préciser avec le troisième argument. """

ma_chaine = "ababababa"
print(ma_chaine)
ma_chaine = ma_chaine.replace("a","z", 2)
print(ma_chaine)

""" Ainsi, il ne modifie que les deux première occurences et ensuite, il ne modifie plus. 
Ca permet ainsi de faire des remplacement sur une certaine partie de notre chaine.
Ce paramètre d'occurence est optionnel, il n'est pas obligatoire. 
<ancienne> et <nouvelle> sont obligatoires.

Pareil pour Find() et Index(), les paramètres <debut> et <fin> ne sont pas obligatoire.
D'ailleurs on ne les a pas utilisés. Ils permettent de travailler sur une petite partie de la chaine. 
On s'en est servi pour faire de la recherhe de sous-chaine.
"""

#6# SPLIT(<separateur>).
#   --------------------
#   Méthode pour obtenir une liste à partir d'une chaine et d'un séparateur.
#

""" Comment faire une coupure de chaine pour la transformer en liste ? """

phrase = "Magicien|10|5" # Nom de la carte | Points d'attaques | Points de défenses.
print(phrase.split("|")) # On choisit le séparateur qui va permettre de couper.

""" Il affiche des élements entre crochets et avec des virgules. Cette notation représente 
une liste (voir dans la séance 16). Comment faire l'effet inverse ? C'est à dire rassembler
les éléments avec la méthode JOIN() pour les chaines mais on serait pas l'utiliser sans avoir
vu les listes. """

""" Le SPLIT() est une méthode ainsi intéressante pour obtenir une liste."""

#7# Autres méthodes.
#   ----------------
#   Méthodes pratiques au niveau des chaines.
#

#   str.islower() 
#   verifier qu'une chaine est ecrite en minuscule.
# 

ch = "Bonjour"
if ch.islower():
   print("Minuscule")
else:
   print("La chaine contient des majuscules")

""" Cela permet de faire des vérification dans des if d'où l'intéret parce que ca retourne 
vrai ou faux ce genre de méthode. Si c'est le cas, ça retourne True et si c'est pas le cas,
ça retourne False. Ca retourne tout simplement un booléen. Cette méthode est un booléen."""

#   str.isidentifier()
#   Vérifier que c'est un mot réservé.
#

""" On peut également tester si un mot clé est reservé comme class ou def."""
ch = "class"

""" Rappel sur la manière dont on crée une classe."""
class Animal:
   def __init__(self):
       pass
pass

"""------------------------------------------------"""

""" La chaine, c'est class et on vérifie si c'est un identifiant
avec isidentifier()."""
if ch.isidentifier():
   print("Réservé")
else:
   print("Libre")

""" On constate  que le mot class est un mot réservé du langage Python. """

#   str.isalpha(), str.isdigit(), str.isdecimal(), str.isnumeric(), str.isalphanum()
#
""" Ici on peut vérifier si on a des caractères numériques, alphabétiques, décimaux et 
des caractères alphanumérique. Ca permet de faire des tests de vérification sur le type
de données dans une chaine."""

#   Exemple : tester une chaine pour savoir si on a un caractère numérique.

ch = "18"
if ch.isnumeric():
   print("Numéric")
else:
   print("Pas numéric")

#8# Bonus.
#   ------
#   Sans méthode.
#

""" Faire une recherche de sous chaine. Savoir très rapidement si chaine appartient à une autre
avec un if. De cette manière, on peut dire que si (if) "langage" est dans (in) la chaine, 
alors on a trouvé le mot."""
ch = "Le langage Python"
if "langage" in ch:
   print("Mot trouvé")
else:
   print("Mot non trouvé")

""" Pas besoin d'avoir une méthode, on fait une petite syntaxe dans un if, la chaine que 
l'on cherche dans (in) une autre chaine. Pas besoin d'utiliser de méthodes FIND() ou INDEX().
L'intéret est de vérifier une sous-chaine dans une autre très rapidement. très utile pour la 
recherche avec une ligne. très pratique pour rechercher un mot dans une phrase."""

#8# Conclusion.
#   -----------
#

""" Dans la documentation ou avec la fonction help(), on peux voir toute la liste des méthodes et 
des attributs sur les chaines. Cela permet de retrouver ce dont on a besoin en natif avant meme de 
l'inventer."""

""" C'est un objet que l'on manipule déjà dés le début lorsqu'on se servait de chaine lorsqu'on etait
en train de faire des objets de classe str en Python. Et comme c'est un objet de classe str, on a plusieurs
méthodes de classes str que l'on peut utiliser pour faire des transformations, modifications, des vérifications,
des remplacements, des recherches.

Bref, beaucoup de ptites possibilités avec cette classe. D'où la séance 15 sur les chaines de caractères."""

""" Dans la prochaine vidéo, on aborde les listes."""
```