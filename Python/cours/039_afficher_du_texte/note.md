# [39. Afficher du texte](https://www.youtube.com/watch?v=TNiKkU-VJzc)

Bonjour à tous, nous voilà sur la séance 39 en python. 

On avait vu la dernière fois, on avait fait une petite parenthèse en tout cas pour voir comment manipuler l'objet Rect qui était très important et nécessaire à comprendre  quand on manipule des bibliothèques en 2D en programmation. 

Et là nous allons revenir sur la suite du cours de manière normale avec autre chose c'est-à-dire que nous avions vu comment dessiner différentes formes. 

Nous avons vu comment dessiner des lignes, nous avons vu comment afficher des images ou dessiner également, tout simplement imposer des images sur nos surfaces. 

Et il reste une dernière chose très importante que vous savez faire depuis le début en mode console qui concerne l'affichage de texte. 

Alors le texte en 2D, ça va être comme pour les images, c'est tout simplement dessiner. On va dessiner du texte, on va faire un rendu de texte sur des surfaces en particulier avec différentes informations qui vont bien sûr être nécessaire pour manipuler ce texte là.

Alors on va déjà passer par la méthode la plus simple, la plus rapide pour manipuler du texte, et après on verra la méthode la plus intéressante et celle qui est à privilégié surtout si vous comptez partager votre programme à d'autres utilisateurs en tout cas, d'autres personnes qui pourront l'utiliser. 

On commence avec un code minimal.
```py
    #coding:utf-8
    import pygame

    pygame.init()
    window_resolution = (640, 480)

    pygame.display.set_caption("Python #39 - afficher du texte")
    window_surface = pygame.display.set_mode(window_resolution)
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
On a une petite résolution avec un code minimal comme on l'a déjà vu plein de fois voilà je pense que maintenant vous avez l'habitude. 

Première chose à savoir c'est qu'il existe 2 constructeur en particulier, et on va découvrir ces constructeurs là. 

On a déjà un module font qui est téléchargé automatiquement avec init(). Ce n'est pas un module à part, il est charger automatiquement quand on fait une initialisation de pygame donc pas de problème pour l'utiliser comme pour draw, display et cetera. 

Et on a 2 constructeurs très importants, un premier qui va nous permettre de travailler avec les polices de caractère du système et une qui permettra de passer par un fichier. 

Donc celle du système, ça sous-entends que vous devez avoir la police en question sur votre os, alors pourquoi c'est pas une méthode à privilégier quand vous allez vouloir partager le programme ? tout simplement parce qu'il faudra que l'utilisateur et la police de caractère sur son pc donc il faudra qui la place dans le répertoire des polices de caractères de Windows, ou de GNU Linux, de Mac os et cetera. 

Déjà si on veut savoir les polices disponibles sur notre système à nous pour pouvoir les manipuler, on peut utiliser une petite fonction très pratique pour récupérer la liste de ces polices de caractères donc ici sans m'occuper du chargement de quoi que ce soit, je vais juste faire un print() donc ici dans la console et on va faire pygame.font donc le module font de pygame et ça s'appelle get_fonts() avec un S et évidemment aucun paramètre.

+ main.py
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (640, 480)

pygame.display.set_caption("Python #39 - afficher du texte")
window_surface = pygame.display.set_mode(window_resolution)
pygame.display.flip()

print(pygame.font.get_fonts())

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
Donc jeste en faisant ça.

    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    ['arial', 'arialblack', 'bahnschrift', 'calibri', 'cambriacambriamath', 'cambria', 'candara', ...
```
Je peux fermer le programme de toute façon, et là on voit que j'ai la liste des polices de caractères installé sur mon PC, alors pourquoi est-ce que c'est pratique ? parce qu à partir de là on a tous les noms pour nous permettre de charger la police que l'on veut écrite correctement. 

C'est par exemple je veux la police 'arial', je n'aurai qu'à écrire 'arial' en minuscule. 

Si je veux la police 'ubuntu' que j'installe en général et que je trouve bien pratique, que je me sers par exemple lorsque je fais mes PDF. Pareil on voit qu'elle est disponible. 

En fonction des polices, pour ceux qui ne le savent pas vous avez parfois plusieurs styles de polices. Vous allez par exemple avoir une police pour la version normale régulière, vous allez avoir une police pour la version grasse en Bold, la version italique et ce genre de chose ou encore une police plus fine, on va avoir plusieurs versions différentes. 

Nous, on va travailler avec la police 'arial' de Windows et normalement si vous êtes sur Linux ou Mac OS elle n'est pas disponible par défaut. 

Donc on reprend notre code, on vire la partie pour vérifier les noms puisqu'on sait que c'est 'arial' en minuscule. 

Nous allons déjà charger la police en question, que nous voulons donc la première chose à faire, on ne va rien mettre dans la boucle principale on ne va pas s'embêter. 

La première chose c'est de charger la police et comme c'est la police arial que je veux charger, je vais appeler une variable arial_font pour savoir à quoi ça fait référence et ensuite on fait pygame.font (le module) et le constructeur s'est SysFont(). Attention il faut une majuscule au S de Sys et une majuscule au F de Font, très important sinon vous aurez des erreurs. 
```py
    #coding:utf-8
    import pygame

    pygame.init()
    window_resolution = (640, 480)

    pygame.display.set_caption("Python #39 - afficher du texte")
    window_surface = pygame.display.set_mode(window_resolution)
    
    arial_font = pygame.font.SysFont(...)
    
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Ça prend quelques paramètres très simple, le premier c'est le nom de la police de caractère donc c'est ce que nous a retourné tout à l'heure la fonction get_fonts() de tout à l'heure donc moi c'est "arial" en minuscule tout simplement. 
```py
    #coding:utf-8
    import pygame

    pygame.init()
    window_resolution = (640, 480)

    pygame.display.set_caption("Python #39 - afficher du texte")
    window_surface = pygame.display.set_mode(window_resolution)
    
    arial_font = pygame.font.SysFont("arial", ...)
    
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
En 2e argument on va lui renseigner la taille que l'on veut de la police d'accord simplement la dimension de la police, et moi je vais mettre par exemple ici 20 que je pense très bien.
```py
    #coding:utf-8
    import pygame

    pygame.init()
    window_resolution = (640, 480)

    pygame.display.set_caption("Python #39 - afficher du texte")
    window_surface = pygame.display.set_mode(window_resolution)
    
    arial_font = pygame.font.SysFont("arial", 20, ...)
    
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Et ensuite ça peut prendre 2 autres arguments optionnels ils ne sont pas obligatoires donc c'est True ou False donc si vous mettez aucun, vous ne mettez rien du tout.

C'est par exemple vous mettez le premier, vous mettez True et si vous voulez le 2e, vous mettrez False et True. 
```py
    Le 1e,
            arial_font = pygame.font.SysFont("arial", 20, True)
    
    Le 2e,
            arial_font = pygame.font.SysFont("arial", 20, False, True)
```
Voilà on va le faire dans cet ordre là, ça ce sont des révisions de fonction que vous connaissez. 

Donc le premier qui vient après c'est celui-ci on veut la police en gras (1e) et le 2e c'est si on veut la police en italique (2e). 

Alors en gros ça veut dire que si je mets, que si je demande d'avoir la police en gras donc ici je mets True. 
```py
    arial_font = pygame.font.SysFont("arial", 20, True)
```
Si je mets True, il va me charger en fait le fichier système qui correspond à la police Bold donc en gras si bien sûr elle existe. 

Si bien sûr elle n'existe pas, il me chargera une autre police par défaut pour "arial" donc moi je ne vais pas m'embêter avec gras et italique pour le moment, je vais laisser tel quel comme ceci.
```py
    #coding:utf-8
    import pygame

    pygame.init()
    window_resolution = (640, 480)

    pygame.display.set_caption("Python #39 - afficher du texte")
    window_surface = pygame.display.set_mode(window_resolution)
    
    arial_font = pygame.font.SysFont("arial", 20)
    
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Donc ça c'est la première étape à faire, on charge une police. 

Alors là pour le coup SysFont() mais on verra tout à l'heure pour travailler avec des polices issue d'un fichier. 

Pour nous c'est la première étape pour dessiner donc pour faire un rendu de police de caractère donc de texte, on charge la police en question. Ça c'est la première chose à faire. 

La 2e chose à faire c'est de préparer le rendu de cette police donc en fait préparé le rendu du texte que nous voulons, le texte nous allons également l'enregistrer dans une variable donc par exemple moi je vais mettre hello_text = comme ceci et qu'est-ce que je vais faire ? je vais faire arial_font donc évidemment SysFont() retourne une Font donc ça retourne un Font comme ça avec une majuscule pour vous faire une idée. On part donc de ça et on va utiliser la méthode render() pour créer un rend. 
```py
    #coding:utf-8
    import pygame

    pygame.init()
    window_resolution = (640, 480)

    pygame.display.set_caption("Python #39 - afficher du texte")
    window_surface = pygame.display.set_mode(window_resolution)
    
    arial_font = pygame.font.SysFont("arial", 20) -> Font
    hello_text = arial_font.render()
    
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```  
Le rendu va prendre plusieurs paramètres, le premier ça va être le texte à afficher ce qui est logique puisque on aimerait bien avoir un texte donc moi par exemple je vais mettre "Hello World !" donc notre fameux Hello World !

Comme 2e paramètre elle va prendre l'anti aliasing c'est tout simplement pour dire si on lisse la police ou pas bien que je pense que vous savez un petit peu ce que c'est mais je rappelle éventuellement pour ceux qui ne seraient pas. Par défaut vous savez que vos écrans fonctionnent avec des pixels donc si on zoomait … je pense que vous avez déjà fait ça c'est-à-dire d'essayer d'afficher une image sur votre PC et zoomer un maximum avec le logiciel et vous verrez que plus vous zoomez … en tout cas si c'est pas une image vectorielle … et vous allez voir de plus en plus apparaître les pixels même sur les courbes, et bien le texte c'est pareil. 

Vous savez que le texte s'est fait d'arrondi, les O, les A et cetera, il y a des boucles un peu partout même en arabe même en chinois dans n'importe quelle écriture, et si on zoome un maximum qu'on zoome de plus en plus de plus en plus tout va se pixelise parce que les écrans sont composées de pixels tout simplement, et les pixels ce sont des petits carrés. 

Voilà ce sont des représentations géométriques et non pas des choses arrondies donc en activant l'anti aliasing, ça va en fait lisser c'est pixel pour créer des espèce de flou qui vont rendre du coup des choses beaucoup plus agréable à l'œil donc si on veut l'activer on met True et si on veut pas on met False donc nous on va mettre False pour commencer et pour voir un petit peu la différence. 

On va mettre également le texte à 30 pour que nous le voyons assez gros et comme ça on le verra peut-être mieux à l'écran.
```py
    #coding:utf-8
    import pygame

    pygame.init()
    window_resolution = (640, 480)

    pygame.display.set_caption("Python #39 - afficher du texte")
    window_surface = pygame.display.set_mode(window_resolution)
    
    arial_font = pygame.font.SysFont("arial", 30)
    hello_text = arial_font.render("Hello World !", False, ...)
    
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Et ensuite l'autre argument qui vient après c'est la couleur du texte donc moi par exemple je vais mettre un petit bleu "blue" et on va aller créer la variable. On va faire comme dans la précédente vidéo (0, 75, 255) qui faisait un bleu pas trop agressif à l'œil.
```py
    #coding:utf-8
    import pygame

    pygame.init()
    window_resolution = (640, 480)
    blue = (0, 75, 255)

    pygame.display.set_caption("Python #39 - afficher du texte")
    window_surface = pygame.display.set_mode(window_resolution)
    
    arial_font = pygame.font.SysFont("arial", 30)
    hello_text = arial_font.render("Hello World !", False, blue)
    
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```     
Et en dernier paramètre si on veut parce que c'est optionnel, c'est si on veut une couleur de fond donc une couleur de background. Si vous n'en passer pas il n'y en aura pas parce qu'on ne va pas non plus commencer à mettre des paillettes et tout un tas de couleurs pour faire des arcs-en-ciel donc ce sera très bien un texte en bleu. Pas besoin de couleur de fond. 

Ici la création du rendu render() va retourner une Surface mais nous on va récupérer ça dans hello_text donc hello_text sera une surface, je peux même mettre ça hello_text_surface si je veux un terme pour comprendre qu'on a une surface à l'intérieur. 
```py
    #coding:utf-8
    import pygame

    pygame.init()
    window_resolution = (640, 480)
    blue = (0, 75, 255)

    pygame.display.set_caption("Python #39 - afficher du texte")
    window_surface = pygame.display.set_mode(window_resolution)
    
    arial_font = pygame.font.SysFont("arial", 30)
    hello_text_surface = arial_font.render("Hello World !", False, blue)
    
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```    
Une fois qu'on a ça, comme pour tout ce qu'on a fait en fait, tout ce qu'on a manipulés qui étaient soit des surfaces, soit de rectangle donc les images tout ça des surfaces et cetera, il faut les imposer sur une autre. 

En effet une image c'est une surface qu'on va coller sur votre surface, à savoir notre fenêtre window_surface. 

Là c'est pareil, notre texte qui est une surface va devoir être posé, collé c'est comme vous voulez. Vous pouvez utiliser le terme que vous voulez sur la surface qui représente notre fenêtre. 

Et pour cela on avait déjà vu quelque chose qui était très très pratique précédemment, c'est le fait de blitter d'accord de blitter une surface sur une autre et ça on l'avait déjà fait. 

window_surface, on va utiliser une méthode des surfaces parce que ça concerne l'objet surface, la méthode blit() qu'on avait déjà vu.
```py
    #coding:utf-8
    import pygame

    pygame.init()
    window_resolution = (640, 480)
    blue = (0, 75, 255)

    pygame.display.set_caption("Python #39 - afficher du texte")
    window_surface = pygame.display.set_mode(window_resolution)
    
    arial_font = pygame.font.SysFont("arial", 30)
    hello_text_surface = arial_font.render("Hello World !", False, blue)
    
    window_surface.blit()   #                <--------------
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Et blit() qu'est-ce qu'elle prend ? elle dit que sur la surface que l'on va prendre ici window_surface, tu vas y ajouter une autre surface donc nous c'est hello_text_surface et les positions de celles-ci. Rappelez-vous par contre qu'ici je mettais des petits crochets [], ça pouvait prendre un tuple ou une liste mais moi je préfère prendre une liste parce que encore une fois je trouve que c'est plus lisible de mettre des crochets dans une parenthèse plutôt que des parenthèses dans des parenthèses où on pourrait du coup oublier des parenthèses dans le lot. Voilà ça risquerait de faire des petits oublis, du coup je préfère faire ça pour ne pas avoir les mêmes syntaxes. Et donc là c'est la position X et Y du texte donc moi je vais mettre [10, 10].
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (640, 480)
blue = (0, 75, 255)

pygame.display.set_caption("Python #39 - afficher du texte")
window_surface = pygame.display.set_mode(window_resolution)

arial_font = pygame.font.SysFont("arial", 30)
hello_text_surface = arial_font.render("Hello World !", False, blue)

window_surface.blit(hello_text_surface, [10, 10])
pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
Je mets donc [10, 10] pour que mon texte soit affiché à peu près en haut à gauche de l'écran voilà. 

Ensuite le flip() est réalisé donc ça va être mis à jour donc tout le rendu pour préparer l'actualisation pour la mémoire et notre tampon, et du coup l'affichage devrait se faire. 
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #39                            - # x   |
    | Hello World !                                 |
    |                                               |
    |                                               |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
Voilà je fais ça et on a le texte qui s'affiche à l'écran donc là vous venez de dessiner, de faire un rendu, de dessiner du texte. 

Il ne s'agit pas de texte en mode console, on travail avec une vraie police de caractère donc avec 'arial' une police que j'ai sur mon système et on l'affiche directement donc ça c'est pratique. 

Et la bonne nouvelle et ça je pense que ça va faire plaisir à beaucoup de monde parce que c'est toujours là chose qu'on se dit quand on manipule des programmes en console, on essaie des accents, des caractères spéciaux, des caractères accentués, le symbole euro et on se rend compte que ça ne s'affiche pas. 

Et si on essaie d'afficher des caractères dits du coup unicode qui appartiennent en fait à l'utf8 donc l'unicode, des caractères même étrange si vous voulez écrire en arabe, si vous voulez écrire des idéogrammes chinois ou ce genre de chose, ça ne marchera pas en console en tout cas sans devoir faire des manipulations assez hasardeuses et qui de toute façon ne sont pas assez fonctionnel et compatible ou portable. 

Et bien là l'avantage, c'est comme on fait un rendu, ces textes que nous affichons à l'écran, que nous dessinons sont compatibles unicode. 

Ce sont des textes unicode donc bonne nouvelle on va pouvoir évidemment afficher des caractères spéciaux, vous voulez afficher des caractères accentués, le symbole euro, vous voulez mettre des petits chapeaux, vous voulez mettre des dollars, n'importe quoi même des étoiles, vous voulez écrire en japonais, et n importe quoi, ça passera sans problème.
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (640, 480)
blue = (0, 75, 255)

pygame.display.set_caption("Python #39 - afficher du texte")
window_surface = pygame.display.set_mode(window_resolution)

arial_font = pygame.font.SysFont("arial", 30)
hello_text_surface = arial_font.render("é€^$$**", False, blue)

window_surface.blit(hello_text_surface, [10, 10])
pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #39                            - # x   |
    | é€^$$**                                       |
    |                                               |
    |                                               |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
Voilà en japonais en n'importe quoi ça passera sans problème et voici la preuve en images avec ceci, et là vous pouvez enfin écrire avec des caractères spéciaux, des caractères accentués. 

C'est pour ça que je vous dis en console ne vous embêter pas à essayer d'afficher … si vous êtes sur Linux sous Mac OS les terminaux prenant en compte l'unicode donc affiche les accents mais si vous êtes sur Windows et que vous êtes en mode console, ne vous embêtez pas essayez d'afficher des accents. Honnêtement vous allez vous prendre la tête pour rien alors que ce n'est pas fait pour ça. 

La console n'est pas faites pour afficher de toute façon des accents donc sur Windows quand vous voulez écrire un 'é' vous mettez un 'e' normal et ce sera bien.

Si vous voulez mettre un 'ç', vous mettez un 'c' normal et ce sera exactement pareil. 

Donc l'appareil comme il s'agit de rendu, on travail évidemment en utf 8 donc avec de l'unicode et là ça fonctionne il n'y a pas de problème du tout et ça c'est quand même vachement bien. 
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (640, 480)
blank = (255, 255, 255)

pygame.display.set_caption("Python #39 - afficher du texte")
window_surface = pygame.display.set_mode(window_resolution)

arial_font = pygame.font.SysFont("arial", 30)
hello_text_surface = arial_font.render("é€^$$**", False, blank)

window_surface.blit(hello_text_surface, [10, 10])
pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #39                            - # x   |
    | é€^$$**                                       |
    |                                               |
    |                                               |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
Alors on change le nom de la variable et les valeurs pour les couleurs, et là forcément on voit déjà mieux blanc sur noir. Ça va mieux pour lire le texte donc ça c'est très important pour faire le rendu render(). 

La dernière fois à propos du rectangle, si on voulait du coup bouger le rectangle, vous avez vu qu'on devait à chaque fois le redessiner. 

Et bien évidemment le texte c'est à chaque fois on veut le changer, il faudra refaire un rendu du texte donc il faudra re faire un render(). Mais au moins SysFont() ne doit être rechargé qu'une seule fois. 

Voilà n'allez pas charger la police de caractère dans la boucle principale, notre boucle infinie surtout pas. 

Ça SysFont(), on doit toujours le faire en dehors d'une boucle et par contre le rendu render(), oui on va le changer et le blit() également. 

Donc c'est comme si on le réécrivait sur notre surface donc le tableau noir, notre toile comme vous voulez. Vous pouvez employer le terme que vous voulez … à chaque fois que nous voulons écrire autre chose. 

Je souligne également le fait que pour un rendu on n'est pas dans une console, ça ne gère pas les caractères spéciaux. Il n'y a pas de retour à la ligne, de tabulation ou ce genre de chose. Si vous voulez écrire un texte sur 2 lignes, et bien il faudra faire 2 rendu et gérer la position du texte [10, 10].

Vous voyez qu'ici il n'y a pas une histoire de ligne de formatage du texte, on parle de positionnement comme si vous étiez en train de poser un dessin, une image, une forme, ce genre de chose. 

Le texte est ni plus ni moins qu'une certaine forme, c'est simplement une forme d'image ou une surface que nous allons poser sur une autre donc pour un texte sur 2 lignes, il faut faire un 2e rendu et il faut blitter ce 2e rendu avec par exemple ici [x, y], un Y un peu plus grand pour qu'il se mette en dessous d'un autre. 

Après vous avez différentes méthodes pour récupérer la hauteur de votre texte pour éviter par exemple que 2 lignes se touchent mais ça c'est à vous de voir. 

Moi je vais vous donner par contre quelques petites méthodes, alors pas forcément celle qui calcule les hauteurs de textes et tout ça mais vous pourrez encore une fois vous renseigner un peu plus si vous voulez parce que ça ne me semble pas être les plus importantes mais celles que je voulais en tout cas vous donner, très rapidement ici de nom parce qu'on peut encore faire très rapidement les modifications avec SysFont() comme vous l'avez vu. 

Donc on a par exemple la méthode pour changer le style du texte donc on va avoir et c'est à tester bien sûr sur les polices. C'est set_bold().
```py
    """
    arial_font.set_bold()
    """
```
À faire sur une police de caractère par exemple dans notre cas avec arial_font, on va faire ceci.
```py
    arial_font.set_bold()
```
En faisant ceci ça va passer la police en gras. 

Alors si je fais ensuite arial_font.set_italic().
```py
    """
    arial_font.set_bold()
    arial_font.set_italic()
    """
```
Ça va passer en italique.

Et ce qui peut être intéressant, c'est pour passer éventuellement avec un souligné, underligne() pour mettre un trait sous le texte donc là le trait fera une certaine épaisseur et ce n'est pas forcément propre à la police que vous chargez parce que c'est un truc qui se rajoute en plus de la police. 
```py
    """
    arial_font.set_bold()
    arial_font.set_italic()
    arial_font.set_underline()
    """
```
Vous avez vu qu'il n'y avait pas de fichier de police par exemple pour gérer le underline, il y a juste pour le mode gras et le mode italique, et éventuellement un mode fin mais il n'y a pas de mode underline donc ça s'est fait directement par pygame, la bibliothèque en question. 

Voilà donc ça ce sont des petites méthodes à connaître sur Font donc on parle de l'objet Font et pas le module, attention.

Après comme je vous ai dit des fois par abus de langage, je peux des fois dire le mot méthode alors que c'est une fonction et inversement mais bon d'accord vous avez bien compris que quand on parle d'un objet, ce sera toujours une méthode, on fera toujours référence à une méthode. 

Voilà pour ça.
```py
    """
    arial_font.set_bold()
    arial_font.set_italic()
    arial_font.set_underline()
    """
```
Donc ça ce sont des petites méthodes à connaître pour changer un petit peu le style de texte. 

Après vous avez encore pas mal de choses pour récupérer la hauteur d'un texte, par exemple la hauteur de ce texte là "é€^$$**".

Comme ça si on veut en afficher un en dessous, on évite que le texte en dessous se chevauchent pour prévoir ainsi les différentes hauteurs pour gérer ici le Y dans [10, 10]. 

Si on veut ce sont des petites choses qui peuvent éventuellement servir. 

Voilà comment ça se passe pour un texte système. 

Alors ça évidemment lorsqu'on veut partager son programme, ce n'est pas la meilleure solution. 

Si on veut être un peu plus rigoureux et un peu plus efficace on va plutôt passer par un fichier c'est-à-dire que c'est par exemple je fais un jeu vidéo et que je distribue mon jeu. Et bien dans les fichiers, dans les ressources du jeu en plus des images, des musiques et ce genre de choses, je vais passer également les polices de caractères que le programme va utiliser. 

Alors on peut télécharger une police de caractères qui possède plusieurs fichiers avec tout simplement un fichier pour chacun de ces styles.

On a le mode régulier donc la police normal.
```txt
    Roboto-Regular.ttf
```
On a un mode fin.
```txt
    Roboto-Medium.ttf
```
Un peu plus gras, on a un mode gras.
```txt
    Roboto-Bold.ttf
```
On un mode italic.
```txt
    Roboto-Italic.ttf
```
Et cetera, et cetera.

Donc là on en a vraiment plein, il vient même le mode fin italic.
```txt
    Roboto-ThinItalic.ttf
```
Enfin bref il y a vraiment beaucoup beaucoup de styles différents, alors selon la police de caractère vous n'en aurez pas forcément autant ça dépend des polices. 

Si vous voulez télécharger des polices de caractères, vous avez pas mal de site. Cherchez police de caractère et vous en avez un notamment qui est Dafont. 

Dafont, il s'appelle comme ça qui est pas mal connu et pas mal réputé, qui permet notamment de télécharger pas mal de polices de caractères. 

Il y en a sûrement d'autres aussi mais moi je l'utiliser beaucoup quand je cherche une police en particulier. 

Alors vous prenez une police sur n'importe quel site, vous la télécharger, vous récupérez le fichier en question, vous la mettez évidemment dans votre programme c'est-à-dire que vous la gérez au niveau de votre programme et vous n'avez plus qu à charger cette police. 

Alors déjà avant de faire ça, je voulais vous montrer l'anti-aliasing. Je vais agrandir le texte pour que vous voyez.
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (640, 480)
blank = (255, 255, 255)

pygame.display.set_caption("Python #39 - afficher du texte")
window_surface = pygame.display.set_mode(window_resolution)

arial_font = pygame.font.SysFont("arial", 500)
hello_text_surface = arial_font.render("W", False, blank)

window_surface.blit(hello_text_surface, [10, 10])
pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #39                            - # x   |
    | Warning                                       |
    |                                               |
    |                                               |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
Alors oui on le voit un petit peu. Sur le W, vous devez voir un espèce d'escalier et si vous faites un zoom de l'écran de votre navigateur ou autre, vous devriez avoir des espèces dedans, c'est tout dentelé ce n'est pas tout lisse et donc en mettant plus grand vous allez facilement vous en rendre compte.

Et c'est là que je voulais vous montrer qu'en activant l'anti-aliasing et vous verrez que la police est lissée.
```py
    hello_text_surface = arial_font.render("W", False, blank)
    ---> hello_text_surface = arial_font.render("W", True, blank)
```
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (640, 480)
blank = (255, 255, 255)

pygame.display.set_caption("Python #39 - afficher du texte")
window_surface = pygame.display.set_mode(window_resolution)

arial_font = pygame.font.SysFont("arial", 500)
hello_text_surface = arial_font.render("W", True, blank)

window_surface.blit(hello_text_surface, [10, 10])
pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #39                            - # x   |
    | W                                             |
    |                                               |
    |                                               |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
Voilà j'avais oublié d'en parler c'est quand même intéressant, vous activez l'anti aliasing, la police est lissée et vous voyez qu'il y a une espèce de petit flou qui rend les choses beaucoup plus agréable à l'oeil. 

Voilà c'est quand même mieux que ce lissé que quand ça ne l'est pas donc l'anti aliasing c'est mieux de l'utiliser. 

Alors ça c'était la petite parenthèse vite fait parce que je risque de passer à côté mais c'est bien d'en parler quand même. 

Alors notre fichier donc je reviens au fichier que l'on veut et moi je veux charger cette police là.
```txt
    Roboto-Regular.ttf
```
Donc je récupère le mot complet avec l'extension et dans notre code ce n'est pas le constructeur SysFont que nous allons utiliser attention mais Font tout court donc vous enlevez Sys, vous mettez Font et vous mettez cette fois un nom de fichier.
```py
    arial_font = pygame.font.SysFont("arial", 500)
    ---> arial_font = pygame.font.Font("Roboto/Roboto-Regular.ttf", 500)
```
En arguments ça prend évidemment la taille et je pense que vous l'avez compris parce que c'est logique, on n'a plus d'arguments à passer si on veut une police en gras ou en italique, pourquoi ? parce que si vous voulez la police Roboto en italique, et bien il faudra charger le fichier en question.

Au pire vous pouvez le charger dans une autre variable, charger la version italique ou autre et en fonction du texte que vous voudrez, italique ou gras et cetera, il faudra utiliser la bonne variable qui a bien stocké la police que vous voulez (arial_font…).

C'est pour ça que contrairement à l'appel du constructeur système, on n'a pas les autres paramètres à préciser. 

Quand on fait un chargement d'une police système, le système lui-même va choisir de charger le bon fichier en question. Et si on a dit qu'on veut le mode gras, le système va charger le fichier de police qui correspond à la police en gras si bien sûr elle est disponible sinon il prendra une version par défaut. 

Comme ici on passe par des fichiers ce sera à nous de le faire manuellement d'accord. 

Mais l'avantage comme je distribue tout dans mon programme, je suis sûr que l'utilisateur l'aura sur son PC parce que je l'a fourni dans mon programme (dossier Roboto). 

En effet comme je la charge depuis mon code, on est sûr que si l'utilisateur ne l'a pas dans son système, ce n'est pas grave donc aucun problème au niveau du rendu. 

C'est juste ça la différence, au lieu d'avoir SysFont, on utilise Font mais alors par contre il n'y a plus d'arguments pour la police en gras ou bien la police en italique. 

Sinon tout est exactement pareil, on y va.
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (640, 480)
blank = (255, 255, 255)

pygame.display.set_caption("Python #39 - afficher du texte")
window_surface = pygame.display.set_mode(window_resolution)

arial_font = pygame.font.Font("Roboto/Roboto-Regular.ttf", 32)
hello_text_surface = arial_font.render("W", True, blank)

window_surface.blit(hello_text_surface, [10, 10])
pygame.display.flip()

launched = True
while launched:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            launched = False
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #39                            - # x   |
    | W                                             |
    |                                               |
    |                                               |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
Tout est exactement pareil sauf que là on passe encore une fois par notre fichier donc voyez qu'il y a très peu de modifications à faire au niveau du code si on ne veut plus utiliser une police système mais une police depuis un fichier. 

Voilà très sympa à utiliser, très facile et très rapide. 

Là je pense encore une fois que c'était pas une vidéo très compliquée.

J'ai fait une vidéo dédiée là dessus parce que c'était important d'en parler, je n'en avais pas parlé lorsqu'on avait abordé le fait de dessiner sur des surfaces ou les images pour garder une vidéo à part parce que ça nécessitait de faire une vidéo rien que là dessus pour que vous puissiez comprendre comment ça se passe.

C'est assez similaire aux images comme vous le voyez, c'est vraiment comme une image, en charge la police en question que ce soit une police système ou une police depuis un fichier. Ensuite on crée un rendu avec le texte que l'on veut qu'on récupére dans une variable, et après cette variable qui est une surface, et alors elle n'attend plus que d'être affiché sur une surface et ici en l'occurrence la fenêtre window_surface donc on fait le blit(), on indique à quel endroit on veut afficher ce texte [10, 10]. On fait le petit flip() pour mettre à jour tout ça d'accord. Ca s'actualise et évidemment le rendu se fait sans problème et l'affichage aussi.

Voilà je pense qu'on a fait le tour de ce que je voulais vous montrer ici, alors n'hésitez pas encore une fois parce que je peux pas tout vous montrer parce que évidemment comme dans n'importe quelle bibliothèque il y a énormément d'objets, de fonctions, de méthodes et si je devais tout vous montrer, ce ne serait pas intéressant parce qu'il faudrait reprendre chaque chose une par une et du coup ça prendrait des heures et des heures.

Je peux évidemment pas tout vous montrer parce que ça n'aurait pas d'utilité pour tout le monde et ça ne servira à rien tout simplement de tout énumérer mais n'hésitez pas encore une fois aller vers la documentation officielle à chaque fois qu'on travaille sur une bibliothèque ou autre parce qu'il y a plein de choses et peut-être que vous vous direz que ça ça peut vous intéresser pour un programme pour un jeu ou autre et que je n'ai pas forcément montrant ici en vidéo.

Ce n'est pas parce que je ne voulais pas montrer que ça ne peut pas forcément être utile et en même temps j'essaie de vous montrer ce qui me semble être le strict minimum même s'il y a beaucoup de choses et beaucoup de détails que je vous montre dans ma vidéo mais ce qui me semble être l'essentiel.

Pour moi on peut pas vraiment faire du pygame sans connaître ces choses-là, après je vous invite bien sûr à aller voir les documentations qui possèdent 100 pourcent de l'information lié évidemment à une bibliothèque parce que c'est ce qui documente l'ensemble de la bibliothèque avec tous les objets, les méthodes et cetera pour voir un petit peu tout ce que ça permet de faire d'autres.

Vous verrez que pour les polices de caractères, il y a des petites méthodes sympa si vous voulez aller un peu plus loin mais là vous avez déjà tout ce qu'il vous faut pour afficher et pour gérer du texte sans problème. 

Et ça commence à faire beaucoup, on a vu les surfaces, on a vu Rect, on a vu les polices de caractères, les images et tout ça donc on va pouvoir comme ça continuer d'avancer tout simplement sur ce cours, sur ce chapitre pygame dans le cours python.

Encore une fois, j'espère que ce dernier chapitre de ce cours là, vous intéresse vous plaît vraiment parce que c'est quand même quelque chose que je tenais à aborder avec vous pour que vous puissiez comme ça créer des programmes en 2D.

Vous voyez qu'on peut faire énormément de petites choses par rapport à ça et avec tout ce que vous avez vu précédemment, vous allez pouvoir ajouter manipuler d'autres parties, rajoutez en plus de ce que vous avez déjà vu, avec cette bibliothèque pygame.

Je n'ai plus qu'à m'arrêter là, je pense qu'on a vu tout ce qu'il fallait pour les textes.

On regarde vite fait si je ne voulais pas vous montrer quelque chose, on a vu SysFont, Font, on a vu tout ce qu'il fallait. Je vous ai parlé des petites méthodes donc normalement il n'y a pas besoin de faire référence à autre chose et je vous ai expliqué qu'encore une fois il n'y a pas de retour à la ligne possible d'accord c'est à vous d'afficher le texte sur plusieurs lignes donc c'est un texte, a rendu pour un texte sur une seule ligne donc si on voit un texte sur plusieurs lignes on fait deux rendu, c'est important.

Et on gère ensuite le positionnement avec un blit() sur la surface window_surface que l'on veut en question donc ça c'est ce qu'on avait vu avec les images donc logiquement pas de problème. 

À bientôt pour la suite, on se retrouvera du coup pour d'autres choses. 

On n'a pas encore fini avec pygame et il y a encore pas mal de petits éléments à voir, on continue d'avancer mais je ne voulais pas faire un petit peu de vidéo je voulais quand même qu'on voit beaucoup de choses. 

Sachant qu'il y a énormément de choses sur cette bibliothèque donc on a encore pas mal de petits éléments de petites choses à détailler et aborder ensemble sur pygame. 

Après bien sûr on pourra conclure non pas que pygame nos concours toute la formation en python.

Je vous dis à bientôt pour une nouvelle séance sur ce cours de programmation en python. 

Ciao tout le monde