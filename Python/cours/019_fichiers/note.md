# [19. Fichiers](https://www.youtube.com/watch?v=gVOYPwjd_8c)

Bienvenue à tous vous êtes sur cette vidéo numéro 19 pour votre formation en langage python. 

Et là je vais vous montrer tout simplement comme tout est objet dans ce langage comme vous l'avez vu jusqu à présent avec la programmation orientée objet, le cast() et cetera.
Nous allons ainsi pouvoir travailler sur des fichiers et j'annonce déjà qu'il y aura un tutoriel en annexe sur tout ce qui est gestion de répertoire de dossier, tout ce qui concerne les chemins, vérifier qu'un répertoire est un dossier ou un fichier, un lien symbolique, et cetera, pas mal de petites choses qui viennent en complément et qui sont pour moi en tout cas non obligatoire par rapport à cette formation.

Ici on v a tout simplement … je vais vous montrer en tout cas, comment lire et écrire dans des fichiers.

Voilà c'est simplement ça, on va voir 2 choses différentes avec plusieurs manières parce qu'on va également travailler en fichier texte et en fichier binaire mais je vais revenir dessus par la suite. 

On va directement prendre un petit fichier tout simple, j'ai fait un petit fichier texte en limitant l'extension .txt

On va émettre plusieurs informations comme des noms d'animaux par exemple, je vais mettre des accents exprès puisque python les gère très bien parce qu'on travaille en utf-8. 
```txt
    donnees.txt
    -----------
    Chat
    Chien
    Éléphant
    Orque
    Tigre
    Saumon 
```
Voilà j'en ai pas mis beaucoup, c'est juste histoire de voir un petit peu.

Alors mon fichier texte est au même endroit que mon fichier python, J'aurais pu me mettre dans un sous-dossier mais vous verrez que c'est très très simple si besoin pour pouvoir organiser vos fichiers et directement ici nous allons voir comment ouvrir ce fichier.

Pour cela, nous avons plusieurs modes. Vous avez des modes d'ouverture alors je vais le noter rapidement ici mais vous verrez un petit peu plus tard.
```py
    #coding:utf-8

    """
    Modes d'ouverture : r (lecture seule)
                        w (écriture avec remplacement)
                        a (écriture avec ajout)
                        x (lecture et écriture)
                        r+ (lecture)
    """
```
On a le R qui est très utile parce qu'il permet d'ouvrir un fichier en lecture seule, ça veut dire que vous pouvez simplement lire dedans et c'est tout.

On a ensuite le mode W, qui est pour une écriture avec remplacement c'est-à-dire que ça va rouvrir le fichier en tout début et si il y a déjà du texte dans le fichier, il va tout simplement le remplacer. Ça c'est par exemple quand on ne veut pas garder ce qu'il y a à l'intérieur et qu'on veut le remplacer, on va utiliser ce mode là.

On va également avoir le mode A, qui lui est écriture avec ajout en fin de fichier donc là on ne va pas remplacer ce qu'on a déjà dans le fichier, ce qu'on avait pu noter avant. 

On a le mode X également, lui c'est la lecture et l'écriture, c'est les 2 à la fois, pourquoi pas. 

Et on le mode R+ aussi qui peut lui peut servir pour la lecture et l'écriture dans un même fichier.

Honnêtement, on ne les utilisera pas tous. Les modes les plus intéressants sont r, w et a. On évite en général … en tout cas c'est assez rare d'avoir besoin de lire et d'écrire dans un même fichier, ça peut arriver mais c'est quand même beaucoup plus rare et donc la plupart du temps, vous aurez peut-être juste besoin de lire où d'écrire en fonction de ce que vous faites et éventuellement une écriture pour remplacer ce qui a été fait dans un fichier.  

Voilà pour les modes d'ouvertures.

Pour ouvrir un fichier, c'est très simple, on va avoir besoin du chemin du fichier Donc il faut savoir que tout va partir par rapport à notre fichier c'est à dire de où on le lance et donc on exécute notre programme à partir de là où se situe la base de nos fichiers. 

Donc comme mon fichier donnees.txt est à côté de mon programme, il suffit juste de mettre le nom du fichier par contre si je fais un sous dossier que j'appelle par exemple doc et que dedans jamais ce fichier donnees.txt, il suffira de mettre doc/donnees.txt mais ça on verra ça juste après. 

Alors on va enregistrer le fichier dans une variable que l'on va appeler fic tout simplement et je vais utiliser la petite fonction open("") comme ceci. 
```py
fic = open("")
```
Alors là entre guillemets, je vais mettre le nom du fichier ou en tout cas le chemin qui y mène, c'est très simple, c'est "donnees.txt" et comme je vais l'ouvrir en lecture, on va rester sur "r".
```py
fic = open("donnees.txt", "r")
```
Encore une fois c'est par exemple j'avais fait ceci (création d'un dossier "doc"), on aurait suis le chemin qu'il y a ici.
```py
fic = open("doc/donnees.txt", "r")
```
Encore une fois si vous voulez faire plus de manipulations, sur tout ce qui est répertoires, les dossiers avec les chemins, il y a un tutoriel dans la partie tutoriel de python en complément sur tout ce qui est la partie gestion de répertoire, gestion de fichiers mais je ne mets pas ici parce que ce n'est pas obligé d'agrandir la vidéo parce que ce n'est pas forcément obligatoire donc nous on va le garder dans un sous dossier et voilà. 

On l'ouvre en lecture et là nous avons une variable fic qui contient notre objet donc le fichier en lui-même. 

Au niveau de l'ouverture du fichier, alors attention, comme tout … si par exemple je fais ceci, donneess.
```py
fic = open("docs/donneess.txt", "r")
```
Alors je fais éventuellement un fic.close(), tout fichier qui est ouvert, doit être fermée donc si vous voulez être sûr de ne pas l'oublier, mettez le tout de suite. 
```py
fic = open("docs/donneess.txt", "r")
fic.close()
```
Quand vous ouvrez un fichier, mettez le nom de la variable dans lequel vous avez stocké, un point, et vous mettez la méthode close. 

Rappelez-vous du coup on a manipulé encore une fois des objets donc on utilise des méthodes dessus. 

On met close() sans rien dedans et ça va fermer le fichier. 

Donc je vais vous montrer ça et si je fais un petit test python main.py
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
"""
fic = open("docs/donneess.txt", "r")
fic.close()
```
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 102, in <module>
        fic = open("docs/donneess.txt", "r")
    FileNotFoundError: [Errno 2] No such file or directory: 'docs/donneess.txt'
```
Voilà là ils vous met tout simplement qu'il ne trouve pas, no such file or directory. 

Et il nous fait d'ailleurs une exception, FileNotFoundError.

Donc on va pouvoir traiter les exceptions, ça va être le try/catch … pardon plutôt le try/except  qu'on ne confonde pas les langages, vous allez pouvoir comme ça traiter l'ouverture du fichier donc ici je ne vais pas vous montrer comment gérer les erreurs directement parce que vous allez voir qu'il y a une autre syntaxe qui va permettre de le faire un petit peu à notre place mais sachez que quand on utilise comme ça open()  et close(), il faut bien vérifier évidemment qu'on a bien réussi à ouvrir le fichier avant tout et ensuite vérifier pourquoi pas que le fichier a bien été fermé et tout. 

Pour ça d'ailleurs, pour vérifier ça vous pouvez utiliser une petite propriété. Il suffit de faire ceci. 
```py
if fic.closed:
    print("Fichier fermé")
else:
    print("Fichier ecnore ouvert")
```
Donc là de toute manière comme on n'arrive pas à trouver le fichier, on a une exception. On va faire ça, python main.py
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
"""
fic = open("docs/donnees.txt", "r")
fic.close()

if fic.closed:
   print("Fichier fermé")
else:
   print("Fichier ecnore ouvert")
```
```powershell
    >python main.py
    Fichier fermé
```
Voilà et on va relancer ça, et là fichier donnees.txt a bien été fermé, effectivement, je fais un close() et forcément il n'y a pas eu de problème.

Donc ça c'est un petit attribut, closed, qui est à connaître. C'est un attribut de l'objet fichier pour quand on manipule des fichiers en python qui permet de vérifier s'il a bien été fermé donc n'oubliez pas dès qu'il y a un open(), il y a automatiquement un close()  derrière en tout cas quand on suit cette syntaxe. 

Alors ici je ne vais pas vous mettre des notes sur toutes les méthodes que vous voyez, prenez note de votre côté encore une fois. Je ne vais pas forcément vous le répéter à chaque fois à l'oral comme ça vous l'avez sous les yeux c'est plus pratique pour vous donc ça c'est une possibilité, alors nous on va pas forcément refaire ça à chaque fois. On va partir du principe que l'ouverture et la fermeture se fait bien aussi.

Alors ici maintenant on va lire nos informations parce que c'est un peu le but de notre fichier. On l'a ouvert, le but c'est … comme vous voyez, j'ai utilisez le mode de lecture seule … le but c'est de récupérer des infos.

Et pour ça, il y a une méthode plus simple c'est de récupérer tout l'ensemble du fichier. Pour ça vous pouvez directement faire un print() dans read().
```
print(fic.read())
```
Donc sur le fichier, on utilise la méthode read() qui va tout simplement lire tout le fichier.
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
"""
fic = open("docs/donnees.txt", "r")

print(fic.read())

fic.close()
```
Et si j'execute, vous voyez qu'il prend tout.
```powershell
    >python main.py
    Chat
    Chien
    Ã‰lÃ©phant
    Orque
    Tigre
    Saumon
```
Alors là par contre, on voit qu'il n'a pas géré les accents donc ça c'est bien de voir. 
On va regarder si par hasard ça ne serait pas un soucis d'encodage mais apparemment non donc ce n'est pas bien grave, du coup on va quand même enlever les accents pour que ça fasse plus propre. 
```txt
    donnees.txt
    -----------
    Chat
    Chien
    Elephant
    Orque
    Tigre
    Saumon 
```
Voilà à ce niveau-là.
```powershell
    >python main.py
    Chat
    Chien
    Elephant
    Orque
    Tigre
    Saumon
```
Donc là, on a véritablement tout le fichier.

Alors en général on ne fait pas directement tout dans un print(), on écrit par exemple ceci, content = fic.read(). Et après évidemment on fait un print() de la variable. 
```py
content = fic.read() 
print(content)
```
On fait donc un print() de la variable Comme ça on peut l'utiliser plus facilement c'est facile et donc vous aurez exactement la même chose sauf qu'on va passer par une variable intermédiaire. 
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
"""
fic = open("docs/donnees.txt", "r")

content = fic.read() 
print(content)

fic.close()
```
```powershell
    >python main.py
    Chat
    Chien
    Elephant
    Orque
    Tigre
    Saumon
```
Alors admettons que je veuille récupérer qu'une seule ligne ouais parce que vous voyez qu'on lit absolument tout le fichier, vous pouvez utiliser la méthode readline() , on va mettre par exemple la variable line. Et je vais faire ceci comme ça on va récupérer qu'une seule ligne. 
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
"""
fic = open("docs/donnees.txt", "r")

line = fic.readline() 
print(line)

fic.close()
```
```powershell
    >python main.py
    Chat
```
Et là on récupère qu'une seule ligne et du coup si je refais plusieurs fois ça.
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
"""
fic = open("docs/donnees.txt", "r")

line = fic.readline() 
print(line)

line = fic.readline() 
print(line)

line = fic.readline() 
print(line)

fic.close()
```
```powershell
    >python main.py
    Chat

    Chien

    Elephant
```
Évidemment si j'aurais fait plusieurs fois ça, c'est comme un curseur, il va se déplacer dans le fichier au fur et à mesure parce qu'on n'a pas fermé, le fichier est toujours ouvert et voyez qu'il parcourt chacun des éléments à chaque fois donc voilà ça peut être pratique aussi quand on veut récupérer qu'une seule ligne par ligne. 

Et vous avez une 3e méthode très pratique, là vous voyez par exemple que je l'ai fait 3 fois et si admettons je veux récupérer tout le reste du fichier c'est-à-dire tout ce qui est après le curseur, je peux faire … donc là c'est la même chose en fait, c'est pas readline() mais c'est readlines(), on est un petit s à la fin pour dire de récupérer toutes les autres lignes qu'ils restent. 

Alors évidemment si dés le début du fichier vous faites un readline(), et bien il va récupérer l'intégralité. Ça reviendra simplement à faire un read(). 

Et là comme on a déjà lu quelques lignes avant, vous voyez qu'il va d'abord récupérer au début tout ce qu'on lui a demandé avec readline() Et vous voyez que après il retourne une liste avec les derniers éléments qu'il manque par la méthode readlines().
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
"""
fic = open("docs/donnees.txt", "r")

line = fic.readline() 
print(line)

line = fic.readline() 
print(line)

line = fic.readline() 
print(line)

line = fic.readlines() 
print(line[0])

fic.close()
```
```powershell
    >python main.py
    Chat

    Chien

    Elephant

    ['Orque\n', 'Tigre\n', 'Saumon \n']
```
Readlines(), vous voyez quel vous retourne une liste avec les éléments, et en plus il vous montre qu'il y a des retours à la ligne \n qui sont d'ailleurs assez importants et qu'on peut éventuellement récupérer autrement mais bon ça ne pose pas de soucis par rapport aux éléments qu'on a récupéré. 

Donc là il vous récupère vraiment tout et donc ici "line" n'est pas seulement un texte la suite avec un seul mot, c'est carrément une liste donc je peux faire la line de 0, elle va contenir l'orque, la line de 1, elle va contenir tigre et cetera, comme tout ce que vous avez vu sur la vidéo concernant la liste. 
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
"""
fic = open("docs/donnees.txt", "r")

line = fic.readline() 
print(line)

line = fic.readline() 
print(line)

line = fic.readline() 
print(line)

line = fic.readlines() 
print(line[0])

fic.close()
```
```powersuell
    >python main.py
    Chat

    Chien

    Elephant

    Orque
```
Voilà donc ça ce sont 3 méthodes à savoir :
read() pour l'intégralité du fichier ;
readline() pour récupérer une seule ligne de fichier ;
realines() qui va vraiment récupérer tout le contenu, tout le restant des lignes qui n'ont pas été lues mais sous forme de liste donc ça c'est vraiment important de pouvoir bien différencier les 2. 

Voilà pour cette lecture.

Alors nous on va rester sur quelque chose de très simple, on va mettre comme tout à l'heure "content" comme ça on aura tout lu. 
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
"""
fic = open("docs/donnees.txt", "r")

content = fic.read()
print(content)

fic.close()
```
```powershell
    >python main.py
    Chat
    Chien
    Elephant
    Orque
    Tigre
    Saumon
```
Voilà comme ça on a récupéré tout le contenu du fichier donc ça ce sont vraiment 3 choses à savoir, d'ailleurs je peux vous les noter très rapidement ici.
```py
"""
Modes d'ouverture : r (lecture seule)
                    w (écriture avec remplacement)
                    a (écriture avec ajout)
                    x (lecture et écriture)
                    r+ (lecture)

Lecture           : read(), readline(), readlines()
"""
```
Voilà pour les différentes méthodes de lecture, c'est aussi simple que ça, vous voyez c'est vraiment très très facile mais maintenant petite particularité qu'il faut savoir, c'est que tout ce que récupère read(), readline() et cetera, comme pour la fonction input() que vous connaissez bien, cette méthode-là considère que tout ce qui est lu dans le fichier va être traité comme des chaînes de caractères donc de classe STR. 

D'ailleurs si on fait print(type(content)), vous allez voir.
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
                   
Lecture           : read(), readline(), readlines()
"""
fic = open("docs/donnees.txt", "r")

content = fic.read()
print(type(content))

fic.close()
```
```powershell
    >python main.py
    <class 'str'>
```
Vous voyez qu'elle nous met que c'est de classe STR. 

Donc évidemment si vous voulez faire des calculs, il faudra … admettons que dans mon fichier, j'ai juste ça, 18.
```txt
donnees.txt
------------
18
```
C'est un peu bisare, je vais juste faire read().
```powershell
    >python main.py
    <class 'str'>
```
Vous voyez qu'il considère quand même que c'est une chaîne et donc évidemment je ne pourrais pas faire de calcul. 

Si admettons je fais nombre égal 15 (ceci est important pour la compréhension des choses) et si dans print(), je vais faire le calcul des choses c'est-à-dire le nombre plus ce qu'on a lu dans le contenu, "content", là évidemment il va y avoir une exception puisqu'on essaie de faire le calcul d'un entier, 15, avec le contenu qui lui est une chaîne de caractères. 
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
                   
Lecture           : read(), readline(), readlines()
"""
fic = open("docs/donnees.txt", "r")

nombre = 15

content = fic.read()

print(nombre + content)

fic.close()
```
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 475, in <module>
        print(nombre + content)
    TypeError: unsupported operand type(s) for +: 'int' and 'str'
```
Donc automatiquement, il y a un TypeError parce qu'il vous dit qu'il essaye de faire une addition avec un entier et une chaîne de caractères donc automatiquement parce que content est considéré ici comme une chaîne de caractères, il ne faut pas oublier à ce moment-là de faire un cast() tout simplement.
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
                   
Lecture           : read(), readline(), readlines()
"""
fic = open("docs/donnees.txt", "r")

nombre = 15

content = fic.read()
content = int(content)
print(type(content))

print(nombre + content)

fic.close()
```
```powershell
    >python main.py
    <class 'int'>
    33
```
Vous allez voir que le type devient int et du coup on peut faire le calcul donc ça c'est important, n'oubliez pas, cette fonction là.
```py
    read(), readline(), readlines()
```
Cette fonction là c'est comme pour le input(), tout ce qu'elle récupère cette chaîne de caractères et vous savez quand python pour faire des calculs il faut que ce soit des nombres. On ne peut pas faire des calculs sur du texte, c'est impossible, il faut penser à faire un cast() si éventuellement vous vouliez faire des calculs en récupérant des valeurs sur lequel vous pouvez évidemment faire des calculs.
```py
    #coding:utf-8

    """
    Modes d'ouverture : r (lecture seule)
                        w (écriture avec remplacement)
                        a (écriture avec ajout)
                        x (lecture et écriture)
                        r+ (lecture)
                        
    Lecture           : read(), readline(), readlines()
    """
    fic = open("docs/donnees.txt", "r")

    content = fic.read()
    print(content)

    fic.close()
```
Voilà histoire de re simplifier tel que c'était au début.

Voilà du coup pour la lecture, c'est vraiment des petites choses à savoir où on travail toujours sur des chaînes de caractères tout le temps parce qu'on travaille sur des fichiers donc ça c'est la lecture. 

On va voir également une autre méthode pour ouvrir les fichiers et ça serait en fait que le fichier est bien fermé et cetera, ça va si vous voulez encapsuler tout ce qui est gestion du fichier donc son ouverture, sa fermeture avec une autre syntaxe donc ici au lieu d'avoir toute cette syntaxe-là, vous allez enlever cette variable "fic =" et vous allez utiliser le mot clé "with".
```py
    with open("docs/donnees.txt", "r") ...
```
On va donc dire, avec l'ouverture de ce fameux fichier ici en lecture … et tout ça, on va l'enregistrer comme ceci "as fic:" donc on utilise le mot clé "as" et ensuite le nom de la variable "fic" où l'on stocke le contenu du fichier.
```py
    with open("docs/donnees.txt", "r") as fic:
        ...
```
Donc là comme on est dans une structure, n'oubliez pas de faire des tabulations, voilà, et vous n'avez plus besoin de close. Ça je vais le mettre, il n'y a plus besoin de fermer le fichier avec "with" donc ça c'est important.
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
                   
Lecture           : read(), readline(), readlines()
"""
with open("docs/donnees.txt", "r") as fic:
   content = fic.read()
   print(content)
   #Pas besoin de fermer le fichier avec "with"
```
```powershell
    >python main.py
    Chat
    Chien
    Elephant
    Orque
    Tigre
    Saumon
```
D'ailleurs si je test après, if fic.closed
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
                   
Lecture           : read(), readline(), readlines()
"""
with open("docs/donnees.txt", "r") as fic:
   content = fic.read()
   print(content)
   #Pas besoin de fermer le fichier avec "with"
   
if fic.closed:
   print("Fermé")
```
```powershell
    >python main.py
    Chat
    Chien
    Elephant
    Orque
    Tigre
    Saumon
    Fermé
```
Pour vous mettre le résultat de tout à l'heure, il vous met que le fichier est fermé.

Donc la variable fic existe toujours, il n'y a pas de souci, par contre vous voyez bien que le fichier a été fermé donc ça ça a été fermé automatiquement  c'est-à-dire que à partir du moment où vous quittez la structure "with" quand vous revenez à la ligne inférieure sans la tabulation dans le reste du programme.
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
                   
Lecture           : read(), readline(), readlines()
"""
with open("docs/donnees.txt", "r") as fic:
   content = fic.read()
   print(content)
   #Pas besoin de fermer le fichier avec "with"
   
print("Le reste du programme...")
```
```powershell
    >python main.py
    Chat
    Chien
    Elephant
    Orque
    Tigre
    Saumon
    Le reste du programme...
```
Sans la tabulation, dans le reste du programme, à partir du moment où je me retrouve ici dans mon programme, le fichier a été fermé automatiquement.

Donc tout ce qui va se trouver dans la structure with va garder le fichier ouvert pour pouvoir travailler dessus je suis là, faire de la lecture, de l'écriture, ce que vous voulez et toi cette partie là.
```py
    with open("docs/donnees.txt", "r") as fic:
        <--
```
Une fois qu'on a quitté toute cette partie là, le fichier est fermé donc c'est très pratique, c'est une autre syntaxe plus courte, plus pratique pour ne pas oublier notamment la fermeture de fichiers donc vous pouvez adopter l'une ou l'autre il n'y a pas de problème donc ça c'est pour tous ceux qui aiment lecture un fichier texte. 

On va voir maintenant pour l'écriture, l'écriture c'est très simple aussi. Comme pour la lecture, vous ne pouvez écrire qu'en format texte donc si par exemple … admettons que je fasse nombre égal 15, et ensuite je fais fic, le nom du fichier, c'est toujours pareil enfin la variable où l'on va stocker le fichier. 
```py
    with open("docs/donnees.txt", "r") as fic:
        nombre = 15
        fic...
```
On utilise la méthode write() et ce que l'on veut enregistrer.
```py
    with open("docs/donnees.txt", "r") as fic:
        nombre = 15
        fic.write(nombre)
```
Donc là, ça ne va évidemment pas marché.
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
                   
Lecture           : read(), readline(), readlines()
"""
with open("docs/donnees.txt", "r") as fic:
   nombre = 15
   fic.write(nombre)
```
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 675, in <module>
        fic.write(nombre)
    TypeError: write() argument must be str, not int
```
Donc là ça n'a évidemment pas marché, TypeError, donc c'est la même chose, il vous dit que l'argument de write() doit être une chaîne de caractères et pas en entier.

Donc ça n'a évidemment pas fonctionné, donc pour le faire, il faudrait donc caster en str() le nombre éventuellment.
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
                   
Lecture           : read(), readline(), readlines()
"""
with open("docs/donnees.txt", "r") as fic:
   nombre = 15
   fic.write(str(nombre))
```
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 700, in <module>
        fic.write(str(nombre))
    io.UnsupportedOperation: not writable
```
/!\ attention, je lui demande d'écrire dans un document où je suis en lecture "r", on va changer de mode "w". 
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
                   
Lecture           : read(), readline(), readlines()
"""
with open("docs/donnees.txt", "w") as fic:
   nombre = 15
   fic.write(str(nombre))
```
```powershell
    >python main.py
    
    donnees.txt
    -----------
    15
```
Voilà et si je vais ouvrir mon fichier donnees.txt, le nombre 15 a bien été inclus.

On peut très bien après faire  d'autres fic.write().
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
                   
Lecture           : read(), readline(), readlines()
"""
with open("docs/donnees.txt", "w") as fic:
   nombre = 15
   fic.write(str(nombre))
   fic.write("Bonjour, je suis une phrase")
   fic.write("Et une autre...")
```
Voilà, on ferme le fichier et on va peut être tester, n'oubliez pas avec "w" j'écrase tout ce qui a été mis dans le fichier avant parce que je fais vraiment un remplacement.
```powershell
    >python main.py
    
    donnees.txt
    -----------
    15Bonjour, je suis une phraseEt une autre...
```
Voilà je fais vraiment un placement et là vous voyez que ça ne passe pas la ligne parce que lui, le curseur, s'arrête à l'endroit où vous avez demandé d'écrire. Au début vous avez demandé d'écrire 15, ainsi le curseur après l'écriture se trouve à cet endroit là.
```
    15<--
```
Et après on demande d'écrire autre chose donc on a mit ça.
```
    15Bonjour, je suis une phrase<--
```
Si on veut effectivement avoir des passages dans la ligne, on met des antislash n, \n qui consiste en des retour à la ligne.
```py
#coding:utf-8

"""
Modes d'ouverture : r (lecture seule)
                   w (écriture avec remplacement)
                   a (écriture avec ajout)
                   x (lecture et écriture)
                   r+ (lecture)
                   
Lecture           : read(), readline(), readlines()
"""
with open("docs/donnees.txt", "w") as fic:
   nombre = 15
   fic.write(str(nombre))
   fic.write("\nBonjour, je suis une phrase\n")
   fic.write("Et une autre...\n")
```
Et donc là on fait ça.
```powershell
    >python main.py

    donnees.txt
    15
    Bonjour, je suis une phrase
    Et une autre...
```
Et donc automatiquement donnees a changé et là on est bien passé à la ligne.

On voit même d'ailleurs qu'à la fin, on est bien passé à la ligne.
```
    1.  15
    2.  Bonjour, je suis une phrase
    3.  Et une autre...
    4.  
```
Donc là on voit bien que le curseur s'est bien mis à la fin, attention quand vous écrivez, il écrit purement ce que vous lui donnez donc c'est à vous de spécifier les retours à la ligne avec les tabulations avec des \t. Vous faites comme vous voulez mais tout est vraiment précis à ce niveau-là. 

Voilà pour l'écriture, c'est vraiment très simple. L'écriture c'est tout simplement write(), voilà on ne s'embête pas. 
```py
"""
Modes d'ouverture : r (lecture seule)
                    w (écriture avec remplacement)
                    a (écriture avec ajout)
                    x (lecture et écriture)
                    r+ (lecture)
                    
Lecture         : read(), readline(), readlines()
Ecriture        : write()
"""
```
write(), ça prend vraiment tout comme chaîne de caractères parce que vous lui mettez également en paramètre le retour à la ligne, les tabulations, les retours chariot et cetera et cetera. 

Après comme on a utilisé ici la syntaxe avec with, le fichier est bien fermé à la fin et on a écrit dedans. 

Donc ça c'était la première partie de cette vidéo, voilà je pense que c'est très très simple à manipuler comme ça la lecture et l'écriture de fichier en python.  

Vous utilisez simplement un mode pour ouvrir votre fichier, vous avez 2 syntaxes disponibles et après vous pouvez lire de 3 manières différentes et écrire avec la méthode write() qui est très pratique, vous pouvez mettre toutes les informations que vous voulez. 

Maintenant petite particularité, admettons et on va partir du coup … ça va allonger encore une fois un peu la vidéo mais c'est purement nécessaire … nous allons créer un objet, Player. 
```py
    #coding:utf-8

    class Player:
```
On crée un objet, j'aime bien Player c'est toujours quelque chose que je prends comme exemple, voilà, qu'est-ce qu'on peut mettre aussi ? name et level.
```py
    #coding:utf-8

    class Player:
        def __init__(self, name, level):
            self.name = name
            self.level = level
```
Donc là on a tout simplement créé une classe de joueurs et après on va pouvoir du coup créer un nouveau joueur tout simplement et l'enregistrer aussi parce que vous vous doutez bien, si vous voulez enregistrer votre joueur, ici on a plusieurs attributs donc ça va même s'il y en a que 2 donc ça va mais si on voulait tout enregistrer, on pourrait effectivement s'amuser à mettre tout dans des variables et enregistrer chaque variable une par une. 

Alors là par exemple on aurait un fichier avec par ligne, chaque information du personnage mais nous ce qu'on aimerait pouvoir faire c'est carrément enregistrer l'objet en lui-même, c'est-à-dire qu'on enregistre tout l'objet peu importe le nombre d'informations, de propriété et cetera, on enregistre tout. Imaginez un jeu vidéo, vous enregistrez tout l'état de votre personnage principal. En effet vous n'avez pas envie de perdre votre niveau, votre XP, perdre vos objets et cetera mais là c'est exactement ça, on va donc utiliser le mode binaire c'est-à-dire qu'on va enregistrer avec des 0 et des 1 comme le fonctionnement du langage machine, et on va carrément enregistrer l'objet comme ça on pourra le récupérer après mais c'est un tout petit peu plus compliqué que ce qu'on a déjà fait en mode texte. On va y regarder. 

Donc on va créer tout simplement notre Player qu'on va appeler Jason.
```py
    #coding:utf-8

    class Player:
        def __init__(self, name, level):
            self.name = name
            self.level = level
            
    p1 = Player("Jason", "10")
```
Alors par contre, on va peut être faire whoami() et on va utiliser la méthode format() sans oublier les parenthèses.
```py
    #coding:utf-8

    class Player:
        def __init__(self, name, level):
            self.name = name
            self.level = level
            
        def whoami(self):
            print("{} ({})".format(self.name, self.level))
            
    p1 = Player("Jason", "10")
```
C'est simplement pour avoir un petit format, ensuite p1 n'a plus qu'à faire du coup p1.whoami() et on va déjà voir que ce bout de code fonctionne.
```py
#coding:utf-8

class Player:
   def __init__(self, name, level):
       self.name = name
       self.level = level
       
   def whoami(self):
       print("{} ({})".format(self.name, self.level))
       
p1 = Player("Jason", "10")
p1.whoami()
```
```powershell
    >python main.py
    Jason (10)
```
Ok, ça fonctionne donc pas de soucis.

Donc j'ai fait une classe avec 2 attributs pour cette classe et une petite méthode qui permet de dire voilà qui suis-je et donc il donne son nom et son niveau entre parenthèses, c'est tout.

Moi ce personnage-là, j'ai envie de l'enregistrer même s'il n'a pas beaucoup d'informations mais imaginez qu'on aurait quelque chose de beaucoup plus étoffé, je veux pouvoir l'enregistrer dans un fichier. 

La méthode la plus simple serait d'utiliser un mode texte comme je disais et d'avoir une variable name, ensuite de faire un write() de la variable name c'est-à-dire de faire un write() en str parce que le niveau est un entier. Et ensuite pour les récupérer, il faudra avoir 2 variables. 

Et du coup au lieu de manipuler un objet, on manipule des variables qu'on va ensuite restituer dans un objet, ça fait un petit peu lourd comme syntaxe alors que grâce au mode binaire, on va pouvoir enregistrer carrément cette instance de l'objet et ensuite de la récupérer. 

Donc on va faire ça et pour ça on va devoir utiliser un module très particulier qui sert justement à ça aussi pour pouvoir sauvegarder nos objets, il s'appelle pickel(). 

On va devoir importer pickle écrit tout en minuscule, d'accord et comme ça on aura pas de soucis.
```py
    #coding:utf-8

    import pickle

    class Player:
        def __init__(self, name, level):
            self.name = name
            self.level = level
            
        def whoami(self):
            print("{} ({})".format(self.name, self.level))
            
    p1 = Player("Jason", "10")
    p1.whoami()
```
Alors mon personnage est créé, je vais donc ouvrir mon fichier et on va utiliser la syntaxe with qui marche très très bien.

On va enregistrer les données du Player qu'on va enregistrer directement ici dans un fichier Player.data. On va le mettre en "w" parce que c'est écriture et pour le mode binaire, il faut spécifier en rajoutant un b, "wb".

Nb pour le mode texte, on peut mettre un t mais comme en général c'est en mode texte, c'est rare qu'on utilise la lettre t pour spécifier le mode texte par contre pour le mode binaire, vous rajoutez un b à la suite du mode d'ouverture et vous aurez comme ça le mode binaire au niveau de votre fichier et là on va mettre fic.
```py
with open("Player.data", "wb") as fic:
```
Alors toujours pareil, mettez toujours des noms de variables explicites, là mon fic, ça ne veut rien dire, on ne sait pas c'est un fichier de quoi, on ne sait même pas si c'est un fichier tout court parce qu'en plus c'est un diminutif du mot fichier qui est français alors que j'ai des noms en anglais. Là je mets des noms très courts pour ne pas alourdir, allongé parce que je n'ai pas une grande largeur n'hésitez pas à mettre des noms très explicite dans vos noms de fichiers, encore une fois il faut vraiment toujours que ce soit lisible et après normalement ça votre dispense de pas mal de commentaires si déjà votre code en lui-même est déjà explicite. 

Alors une fois que j'ai fait ça, mon fichier est ouvert et je vais créer tout simplement mon enregistrement que je vais appeler record tout simplement pour l'enregistrement et je vais utiliser le module du module pickle c'est-à-dire Pickler() avec un p majuscule. Alors ne me demandez pas pourquoi cette syntaxe et qui la inventé mais voilà ça fait partie du module, c'est comme ça que ça s'écrit, il y a une majuscule donc il faut faire comme ça.
```py      
    with open("player.data", "wb") as fic:
        record = pickle.Pickler()
```  
À partir de là, je spécifie où est-ce que je vais enregistrer, comment je vais enregistrer donc moi je vais tout simplement lui spécifier mon fichier. Je lui dis que c'est la dessus que c'est sur ce fichier là qu'on va procéder à l'enregistrement.
```py
    with open("player.data", "wb") as fic:
        record = pickle.Pickler(fic).
```   
Et à partir de là, on va pouvoir enregistrer toute l'information que l'on veut. À partir de record et non plus du fichier, je vais faire record et sur l'objet record d'enregistrement (c'est sûr lui que je vais travailler), je vais faire un dump() c'est à dire une copie de mon objet (signification d'un dump).

Et mon objet moi ici, c'est p1 (Désolé je l'avais enlevé mais je le remets). 
```py
#coding:utf-8

import pickle

class Player:
   def __init__(self, name, level):
       self.name = name
       self.level = level
       
   def whoami(self):
       print("{} ({})".format(self.name, self.level))
       
p1 = Player("Jason", 10)
       
with open("player.data", "wb") as fic:
   record = pickle.Pickler(fic)
   record.dump(p1)
```
Et du coup mon objet c'est p1 donc je fait un dump() de p1. 

Tout simplement, c'est absolument juste ça, vous ouvrez votre fichier en mode binaire, ensuite vous créez ici une variable qui va servir pour l'enregistrement et c'est sur celle-ci qu'on va utiliser la méthode qui va permettre de faire une copie de votre objet et là en exécutant le tout, il ne se passe rien évidemment mais on va vérifier que tout à bien fonctionner et on va l'ouvrir.

    voir Player.data
    
Et là vous allez me dire que c'est tout bizarre ? Eh bien oui c'est en hexadécimal et si j'avais ici un éditeur binaire, ça nous afficherait que des 0 et 1 mais là comme c'est un éditeur de texte (sublime text), il vous l'affiche comme il peut le lire et comme il n'est pas capable de l'afficher en mode binaire, il faut l'afficher ici en hexadécimal donc ça c'est du binaire, ce fichier n'est pas lisible mais il est en binaire. 

Player.data Donc ici j'ai bien sauvegarder mon joueur et pour vérifier que ça fonctionne, on va récupérer l'information.
Là maintenant on l'a enregistrer donc on enlève ça `p1 = Player("Jason", 10)`
```py
    #coding:utf-8

    import pickle

    class Player:
        def __init__(self, name, level):
            self.name = name
            self.level = level
            
        def whoami(self):
            print("{} ({})".format(self.name, self.level))
            
    with open("player.data", "wb") as fic:
        record = pickle.Pickler(fic)
        record.dump(p1)
```
Automatiquement si on enlève ce fichier, on devrait pouvoir vérifier si effectivement on a bien récupérer l'information que l'on veut comme ça on pourra utiliser cette méthode là et voir si ça fonctionne. 

Donc avec cette même syntaxe, on va cette fois-ci passer en lecture seule et binaire donc on va faire "rb", on lit le fichier de sauvegarde, Player.data, pas de changement.
```py
    with open("player.data", "rb") as fic:
```
Seulement ce qui va changer c'est au niveau de la récupération donc moi je vais l'appeler get_record pour récupérer l'enregistrement tout simplement. C'est toujours pickle mais au lieu d'être Pickler(), ça va être Unpickler().
```py
    with open("player.data", "rb") as fic:
        get_record = pickle.Unpickler(fic)
```
Donc c'est l'inverse, cette fois c'est le U qui est en majuscule toujours sur le même fichier "fic" et là à partir du get_record, on n'utilise pas la méthode dump() mais load().

Et bien évidemment load() ça ne prend rien puisqu'on va récupérer ça de cette manière.
```py
    with open("player.data", "rb") as fic:
        get_record = pickle.Unpickler(fic)
        player_one = get_record.load()
```
On utilise la méthode load() qui va du coup lire dans le fichier et récupérer la copie.

et à partir de là si les choses ont bien été faites, en faisant player_one.whoami(), Je devrais pouvoir récupérer mes 2 informations qui sont ici, player.data
```py
#coding:utf-8

import pickle

class Player:
    def __init__(self, name, level):
        self.name = name
        self.level = level
        
    def whoami(self):
        print("{} ({})".format(self.name, self.level))
        
with open("player.data", "rb") as fic:
    get_record = pickle.Unpickler(fic)
    player_one = get_record.load()
    
player_one.whoami()
```
Et on va voir ça tout de suite, moment de suspense. 
```powershell
    >python main.py
    Jason (10)
```
Et nous avons récupéré toutes les informations de notre personnage donc depuis le fichier, on a récupéré l'objet donc vous auriez pu avoir encore plus d'attributs, d'information peu importe la comme on a fait une copie conforme  de l'objet quand on le récupère il est bien conforme également donc ça c'est bien pratique et là vous pouvez voir que le fichier fait 69 octets, ça correspond bien évidemment par rapport aux informations que l'on a donc la chaîne de caractères et le niveau, 10. 

Et donc on a pu récupérer cette information comme on voulait et du coup travailler sur notre objet. 

Du coup je pense que l'on va s'arrêter là, on a fait le tour en ce qui concerne la lecture et l'écriture des fichiers, je ne pense pas que ce soit très compliqué. 

Encore une fois, c'est beaucoup de la syntaxe, on utilise un nouveau module, le fameux module pickle donc il est très utile pour ça avec Pickler() et Unpickler(), vous allez pouvoir sauvegarder et récupérer des objets donc c'est à dire travailler sur des fichiers en binaire. 

Et en fichier texte vous avez 3 méthodes : read(), readline() et readlines(). Et la méthode write() pour pouvoir écrire. 

Et vous avez éventuellement à retenir quelques modes d'ouverture tel que le "r", le "w" et éventuellement le "a" et le fameux mode avec le "b" pour pouvoir travailler sur des fichiers binaires. 

Voilà c'est tout ce qu'il y a à retenir grosso modo et vous aurez déjà tout ce qu'il vous faut pour pouvoir écrire et lire dans tes fichiers. 

Je vous dis encore une fois il y a un tutoriel qui est disponible où sera disponible pour voir tout ce qui est gestion un peu plus avancé au sujet de dossier, répertoire, fichiers et cetera mais ça c'est en complément pour ceux que ça intéresse. 

Ici on s'est intéressé à tout ce qui est lecture et écriture, on se retrouve la prochaine fois pour du coup la séance numéro 20, en attendant moi je vous dis à très bientôt.

Entraînez-vous bien et si vous avez des questions comme toujours n'hésitez pas à commenter, aimer partager comme ça ça peut profiter à un maximum de personnes. 

Je ne le dis pas toujours dans mes vidéos mais là j'en profite un petit peu donc n'hésitez pas à ce que ça profite un maximum de gens, à un maximum d'internet je vous dis si vous avez le moindre problème le moindre question par ça, venez me voir en commentaire il n'y aura pas de souci je vais répondre. 

À très bientôt tout le monde et à la prochaine pour la nouvelle séance