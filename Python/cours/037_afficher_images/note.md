# [37. Afficher images](https://www.youtube.com/watch?v=55gDorNewiQ)

[test.md](test.md)  

Bonjour à tous bienvenue sur cette vidéo numéro 37 en python où nous allons voir comment afficher des images donc la dernière fois, on avait regardé un petit peu comment dessiner sur notre surface parce que vous avez vu tout ce qui concerne la manipulation de surface, y compris notre fenêtre d'abord et ensuite la possibilité de dessiner à l'écran sur cette surface sur laquelle nous travaillons. 

Nous allons maintenant voir comment manipuler différentes images, alors il faut prendre 2 formats d'image standard .jpeg et .png que vous aurez l'occasion de plus utiliser.

Le format .jpeg d'ailleurs on peut virer le e qui ne sert à rien, .jpg donc ça revient au même jpg ou jpeg peu importe et un format .png pour avoir une image avec de la transparence, on peut prendre un logo pour voir qu'il y a de la transparence sur les côtés par exemple donc on va regarder comment manipuler ces différentes images avec pygame en python.

Alors c'est très très simple on va encore une fois travailler avec des surfaces, je vous avais expliqué qu'il y avait 2 objets très importants sur pygame et qu'on retrouve dans d'autres bibliothèques 2D, à savoir les surfaces et les rectangles et on va beaucoup manipuler ces 2 types d'objets.

On va reprendre notre code.
```py
    #coding:utf-8
    import pygame
    
    pygame.init()
    window_resolution = (640, 480)
    
    pygame.display.set_caption("Python #37")
    window_surface = pygame.display.set_mode(window_resolution)
    
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```

On va le changer aussi un petit peu, vous aviez vu dans la vidéo précédente qu'on s'était amusé à faire des dessins donc dessiner à l'écran en dehors de notre boucle principal, à cet endroit ici.
```py
    #coding:utf-8
    import pygame
    
    pygame.init()
    window_resolution = (640, 480)
    
    pygame.display.set_caption("Python #37")
    window_surface = pygame.display.set_mode(window_resolution)
    
    # <--------
    
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Et maintenant on va faire les choses proprement la c'était juste pour commencer, pour que vous puissiez voir un petit peu les différentes fonctions et méthodes que nous avons abordé précédemment. 

Maintenant on va faire les choses dans le bon ordre et les mettre être exactement là où il faut.

Grosso modo ce qu'il faut retenir, c'est qu'on va charger des données, on va initialiser et configurer des données et tout ceci ne doit être fait qu'une seule fois. 

Par exemple titre de la fenêtre, la mise en place de la résolution simplement la création de la fenêtre qui sera notre surface principale doit être fait qu'une seule fois. 

Par contre ensuite tout ce qui est affichage, tout ce qui est mis à jour ou la gestion des événements comme on le verra plus tard sera fait dans notre boucle ici.
```py
    while launched:
        ...
```
Donc dans cette boucle, dans le while launched.

Dans cette boucle, nous gérons le corps du programme.

et précédemment c'était l'initialisation et le chargement des ressources ou ce genre de choses donc on mettra tout dans le corps de boucle et logiquement on aura tout à la fin, un pygame.display.flip() pour pouvoir mettre à jour absolument tout et update notre interface pour avoir l'affichage voulu. 
```py
    #coding:utf-8
    import pygame
    
    pygame.init()
    window_resolution = (640, 480)
    
    pygame.display.set_caption("Python #37")
    window_surface = pygame.display.set_mode(window_resolution)
    
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
        
        # Corps du programme
        
        pygame.display.flip()
```
Alors pour les images, ça va vraiment être très simple, ce n'est pas plus compliqué que le fait de dessiner à l'écran c'est même encore plus simple parce qu'il n'y a vraiment pas grand chose à retenir et on va manipuler encore une fois des surfaces. 

On va d'abord voir comment charger une image donc une image dimanche je vais commencer à charger d'abord une image avec un chat donc on va créer une variable spécifique pour ça.
```py
    cat_image = # ...
```
Donc on va travailler non plus avec un module comme on a vu avant qui était draw pour dessiner mais le module image qui va permettre de faire ça.
```py
    cat_image = pygame.image 
```
Et load() et on va charger avec le nom de l'image par rapport à l'endroit où se trouve mon fichier, je gère les chemins comme on le fait habituellement. Ça vous connaissait vous savez maintenant gérer des fichiers en python, on l'a déjà vu avant donc je ne reviendrai pas sur la manière de spécifier des chemins relatif, absolu, ce genre de chose. 
```py
    cat_image = pygame.image.load()
```
Donc ici c'est "cat.jpg", on le note pour ainsi charger notre image. 
```py
    cat_image = pygame.image.load("cat.jpg") #Retourne une Surface
```
Et là notre image est chargée mais là maintenant il va falloir l'intégrer c'est à dire qu'ici cat_image va contenir une surface donc cette ligne va retourner une surface. 

À partir du moment où on veut afficher, il n'y a pas d'objet représentant une image avec pygame ou en 2D. 

Une image c'est simplement quelque chose donc un ensemble de pixels qui va être affiché à l'écran donc que ce soit une simple couleur ou que ce soit des pixels de différentes couleurs qui forme pour le coup une image qu'on arrive à reconnaître, c'est toujours la même chose. 

C'est toujours des couleurs sur les pixels donc un ensemble de codes, le RGB comme on a déjà vu avec éventuellement à canal de transparence mais ça on va en reparler un petit peu.

Et tout ceci va se manipuler via des surfaces donc là on va récupérer une surface cat_image et du coup on va pouvoir décider d'afficher celle-ci, cette surface sur la principale. 

N'oubliez pas notre window_surface c'est la surface principale c'est un peu notre tableau noir et pour pouvoir afficher notre image il faudra la calquer la poser sur cette surface là donc on a pour cela quelque chose de très simple à utiliser. 

On va faire window_surface et nous allons utiliser blit(). 
```py
    #coding:utf-8
    import pygame
    
    pygame.init()
    window_resolution = (640, 480)
    
    pygame.display.set_caption("Python #37")
    window_surface = pygame.display.set_mode(window_resolution)
    
    cat_image = pygame.image.load("cat.jpg") #Retourne une Surface
    
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
        
        # Corps du programme
        window_surface.blit()
        pygame.display.flip()
```
Blit() va prendre 2 paramètres en tout cas principaux qui vont nous intéresser, le premier ça va être la surface à appliquer (cat_image) donc nous c'est la surface où nous avons chargé à notre image, et ensuite les coordonnées donc toujours pareil sous forme de tuples ou de liste mais moi encore une fois je vais les mettre sous forme de liste [] parce que les crochets sont différents des parenthèses et du coup ça paraît plus lisible personnellement mais vous faites comme vous voulez. 
```py
    #coding:utf-8
    import pygame
    
    pygame.init()
    window_resolution = (640, 480)
    
    pygame.display.set_caption("Python #37")
    window_surface = pygame.display.set_mode(window_resolution)
    
    cat_image = pygame.image.load("cat.jpg") #Retourne une Surface
    
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
        
        # Corps du programme
        window_surface.blit(cat_image, ...)
        pygame.display.flip()
```
Ensuite je vais reprendre mon logiciel pour faire un petit schéma, alors nous avons notre fenêtre c'est-à-dire la window_surface et donc je rappelle qu'en haut à gauche on est en point 0, 0 et à droite on augmente x et en bas on augmente y chaque fois qu'on descend. Et l'accord donné que nous allons choisir … alors que ça c'est la surface que nous avons avec blit() … c'est tout simplement le.de départ de notre surface qui représente pour le coup l'image donc c'est une surface qui va reprendre automatiquement les dimensions de notre image donc admettons que nous ayons notre image ici.
```txt
        0                                                   X
      0 +-----------------------------------------------+ -->
        |                                               |
        |       +---------------+                       |
        |       |               |                       |
        |       |  Image        |                       |
        |       |               |                       |
        |       +---------------+                       |
        |                                               |
        +-----------------------------------------------+
      Y |
        V
```
Donc nous allons avoir notre image mettons ici et le point que nous allons renseigner c'est tout simplement celui là c'est-à-dire les dimensions du point le plus en haut à gauche de la surface à appliquer sur la surface représentant notre fenêtre d'accord, la surface principale.
```txt
        0                                                   X
      0 +-----------------------------------------------+ -->
        |                                               |
        |   ICI +---------------+                       |
        |       |               |                       |
        |       |  Image        |                       |
        |       |               |                       |
        |       +---------------+                       |
        |                                               |
        +-----------------------------------------------+
      Y |
        V
```
Alors moi comme je n'ai pas grand-chose à afficher ici je ne vais pas m'embêté je vais mettre [10, 10] par exemple et je sais très bien que ce sera bien affiché.

Si on met [0, 0], l'image va s'afficher complètement en haut à gauche de votre écran, ça paraît logique. 

Voilà on a ça qui est prêt, on a fait ceci.
```py
    #coding:utf-8
    import pygame
    
    pygame.init()
    window_resolution = (640, 480)
    
    pygame.display.set_caption("Python #37")
    window_surface = pygame.display.set_mode(window_resolution)
    
    cat_image = pygame.image.load("cat.jpg") #Retourne une Surface
    
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
        
        # Corps du programme
        window_surface.blit(cat_image, [10, 10])
        pygame.display.flip()
```
Alors maintenant il y a une petite chose à savoir qu'on va voir directement comme ça ça vous évitera de prendre de mauvaises habitudes, vous allez voir qu'on peut manipuler plusieurs formats c'est à dire que load() ici peut gérer le format très bien jpeg, le format png, le format gif, le format tga, le format tiff bref des formats assez particulier ou le fameux format bmp que je vous déconseille d'utiliser car il est très lourd et au final le png remplit très bien les fonctions que peut avoir le bmp en ayant une taille bien moindre pour les fichiers. 

Donc pour cela on gère différents formats de fichiers avec ou sans compression, avec un canal de transparence dit canal Alpha ou non, et avec donc un format de pixel différent. 

Si on laisse python gérer tout ces formats différents, on va forcément ralentir le programme et le rendre beaucoup plus lent parce qu'il va falloir qu'il prenne en compte tous les différents formats de pixels et les différents formats d'image. 

Donc pour cela on a la possibilité de convertir quelle que soit la surface sur laquelle nous allons travailler donc on va travailler sur une méthode ici qui va permettre de convertir le format de pixels de l'image pour en faire un format un petit peu similaire quel que soit le format d'image que nous avons à l'origine. 

Et pour ça nous avons 2 méthodes, et la première va concerner tous les fichiers qui n'ont pas besoin de gérer une transparence en tout cas pour laquelle la transparence ne nous intéresse pas. 

On applique sur la surface que nous voulons la méthode convert() donc c'est une méthode ici parce que je rappelle qu'une surface est un objet en python donc ce n'est pas une fonction de méthode.
```py
    #coding:utf-8
    import pygame
    
    pygame.init()
    window_resolution = (640, 480)
    
    pygame.display.set_caption("Python #37")
    window_surface = pygame.display.set_mode(window_resolution)
    
    cat_image = pygame.image.load("cat.jpg") #Retourne une Surface
    cat_image.convert()
    
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
        
        # Corps du programme
        window_surface.blit(cat_image, [10, 10])
        pygame.display.flip()
```
Si des fois dans mon discours vous vous rendez compte que je me trompe de nom, que je parle de fonction alors que c'est une méthode ou inversement, c'est évidemment pas très gênant. Vous savez que si on a un objet c'est une méthode à laquelle on fait appel sinon nous avons des fonctions mais peu importe c'est juste le nom qui diffère. 

Donc en faisant ça on va tout simplement convertir le format de pixel pour avoir quelque chose de beaucoup plus facile beaucoup plus optimisé à manipuler pygame donc à chaque fois que vous voudrez charger une image, vous pouvez utiliser cette méthode là et elle sera convertie dans un format de pixel beaucoup plus optimisé pour pygame pour rendre les affichages beaucoup plus optimisé, plus facile et plus performant. 

Et quand je parle d'optimisation c'est surtout pour blit(). Blit() qui va dire d'appliquer une surface sur une autre. Si vous avez fait la conversion ce sera beaucoup plus efficace. 

/!\ Voilà je ne vous ai pas montré sans l'utilisation de convert() puisqu'il faut vraiment prendre l'habitude dès le départ de vous en servir.

On y va on va exécuter notre programme, et là nous allons avoir l'image qui est affichée.
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (640, 480)

pygame.display.set_caption("Python #37")
window_surface = pygame.display.set_mode(window_resolution)

cat_image = pygame.image.load("cat.jpg") #Retourne une Surface
cat_image.convert() #/!\

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
   
   # Corps du programme
   window_surface.blit(cat_image, [10, 10])
   pygame.display.flip()
```
```powershell   
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

        +-----------------------------------------------+
        | Python #37                             - # x  |
        |       +---------------+                       |
        |       |               |                       |
        |       |  cat.jpg      |                       |
        |       |               |                       |
        |       +---------------+                       |
        |                                               |
        +-----------------------------------------------+
```
Et là nous avons l'image qui est affichée, alors ici comme l'image est assez grande et que j'avais mis une petite résolution donc je met 800 par 600.
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (800, 600)

pygame.display.set_caption("Python #37")
window_surface = pygame.display.set_mode(window_resolution)

cat_image = pygame.image.load("cat.jpg") #Retourne une Surface
cat_image.convert() #/!\

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
   
   # Corps du programme
   window_surface.blit(cat_image, [10, 10])
   pygame.display.flip()
```
```powershell   
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

        +-----------------------------------------------+
        | Python #37                             - # x  |
        |       +---------------+                       |
        |       |               |                       |
        |       |  cat.jpg      |                       |
        |       |               |                       |
        |       +---------------+                       |
        |                                               |
        +-----------------------------------------------+
```
Voilà, on part bien de [10, 10] d'accord c'est la coordonnée du point le plus haut à gauche, et toute l'image, la surface, encore une fois on ne manipule que des surfaces. C'est toujours des surfaces sur des autres qui s'empilent et on obtient ceci donc un écran noir pour la surface de la fenêtre. 

Je vais vous remontrer même si on avait fait dans la vidéo précédente une couleur, là j'ai tout enlevé, j'ai enlevé les couleurs, j'ai enlevé la création de certaines variables pour gérer certaines couleurs donc on a évidemment un écran noir.

Voilà donc pas de souci à ce niveau-là, c'est un exemple très facile à gérer. 

Alors maintenant ce qu'on va faire c'est qu'on va changer un peu la couleur, on va mettre par exemple `blank_color = (255, 255, 255)` parce qu'on va gérer un logo avec une petite ombre portée ce sera mieux pour que vous le voyez.
```py
    blank_color = (255, 255, 255)
```
Ensuite on va faire `window_surface.fill(blank_color)`.
```py
    window_surface.fill(blank_color)
```
Évidemment si je re-exécute le programme, voilà on obtient un écran blanc.
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (800, 600)
blank_color = (255, 255, 255)

pygame.display.set_caption("Python #37")
window_surface = pygame.display.set_mode(window_resolution)

cat_image = pygame.image.load("cat.jpg") #Retourne une Surface
cat_image.convert()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
   
   # Corps du programme
   window_surface.fill(blank_color)
   window_surface.blit(cat_image, [10, 10])
   pygame.display.flip()
```
```powershell   
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

        +-----------------------------------------------+
        | Python #37                             - # x  |
        |       +---------------+                       |
        |       |               |                       |
        |       |  cat.jpg      |                       |
        |       |               |                       |
        |       +---------------+                       |
        |                                               |
        +-----------------------------------------------+
```
Alors pourquoi ce que j'ai mis en blanc ? vous allez voir et maintenant je vais travailler avec l'autre image, on va travailler avec notre logo qui est ici au format png.

Et là il va y avoir une petite différence parce que vous voyez que je vais gérer une certaine transparence, je ne vais pas avoir envie d'avoir la transparence affichée via une couleur alors qu'à la base c'est transparent donc je vais juste changer le nom "cat.jpg" par "logo.png". Juste cette partie là et on va du coup mettre en noir pour que ça se voit black_color = (0, 0, 0)
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (800, 600)
blank_color = (255, 255, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #37")
window_surface = pygame.display.set_mode(window_resolution)

cat_image = pygame.image.load("logo.png") #Retourne une Surface
cat_image.convert()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
   
   # Corps du programme
   window_surface.fill(black_color)
   window_surface.blit(cat_image, [10, 10])
   pygame.display.flip()
```
```powershell   
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

        +-----------------------------------------------+
        | Python #37                             - # x  |
        |       +---------------+                       |
        |       |               |                       |
        |       |  logo.png     |                       |
        |       |               |                       |
        |       +---------------+                       |
        |                                               |
        +-----------------------------------------------+
```
Donc en gros le png puisqu'on peut avoir une certaine transparence à gérer, on va te voir gérer un canal Alpha. Alors là en réalité on ne se rend pas compte parce qu'en réalité la transparence est mise de la même couleur de fond que j'ai ici. 

Donc on ne fera pas la différence de locaux parce qu'il a la même couleur que le fond. 

Admettons par exemple que j'ai mon écran noir, que la surface principale soit en noir, et que je veux chercher mon image ici, au lieu de gérer la transparence autour de l'image il va l'afficher d'une certaine couleur mais donc si c'est la même couleur que le fond on ne va pas s'en rendre compte, on ne va pas voir forcément que la transparence ne s'est pas faite par contre si c'est une couleur différente, et bien notre image elle va être dans un carré d'une autre couleur que celle de la surface. Et donc on n'aura pas là transparence qui sera géré au niveau de l'image. 

Tout simplement pour une raison très simple, c'est que les images comme ça on une autre information à enregistrer. On avait vu qu'il y avait le R pour le taux de rouge, le G pour le taux de vert green et B pour blue donc le taux de bleu mais il y a également possibilité d'avoir un dernier canal qui est dit le canal Alpha qui gère en fait la transparence. 0 c'est invisible et 255 c'est 100% opaque donc de 0 à 255, vous pouvez gérer l'opacité donc en fait la transparence de quelque chose.

La seule différence est que quand vous allez manipuler une image où vous voulez vraiment avoir sa transparence donc là malheureusement ne seront pas pour les résultats mais je n'ai pas envie de faire un programme trop compliqué trop modifié donc on verra avec ça. 

Vous allez juste remplacer la méthode convert() par convert_alpha().
```py
    #coding:utf-8
    import pygame

    pygame.init()
    window_resolution = (800, 600)
    blank_color = (255, 255, 255)
    black_color = (0, 0, 0)

    pygame.display.set_caption("Python #37")
    window_surface = pygame.display.set_mode(window_resolution)

    cat_image = pygame.image.load("logo.png") #Retourne une Surface
    cat_image.convert_alpha()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
        
        # Corps du programme
        window_surface.fill(black_color)
        window_surface.blit(cat_image, [10, 10])
        pygame.display.flip()
```
C'est la seule différence, c'est qu'on a une autre méthode qui va en fait garder la transparence, pourquoi ? tout simplement que la méthode convert(), elle va supprimer tout un tas d'informations de votre image comment elle va convertir, modifier le format de pixel de votre image, encore une fois comme je vous ai dit pour optimiser l'affichage et vous allez voir les différents affichages qu'on pourra faire plus tard si on veut par exemple pouvoir faire de l'animation donc elle va supprimer toutes ces informations, et elle va supprimer également l'information liée au canal Alpha. 

Donc si on veut quand même conserver cette information, utilisera la méthode convert_alpha() avec un underscore entre les 2. Et là pas de problème et nous on ne fera pas la différence parce que la couleur s'est adaptée mais là on est sûr que là transparence bien gérée donc prenez cette habitude si on ne veut pas gérer de transparence convert() mais si on veut gérer la transparence de notre image convert_alpha(), c'est la seule choses à retenir et vous serez sûr que tout fonctionnera exactement comme vous voulez à tous les coups. 

Voilà pour la gestion d'image. 

On est sur quelque chose de très très simple, on est sur quelque chose de très facile à gérer. Il n'y a rien de compliqué normalement ça devrait être suffisamment clair pour tout le monde. 

Donc on n'oublie pas, on charge l'image et ça retourne une surface, très important. On convertit ensuite le format de pixel avec convert() ou convert_alpha() en fonction de l'image que nous avons chargée. Et ensuite dans la boucle principale … parce qu'on veut que ça reste affiché tout le temps par la suite … on rempli avec blit() donc en fait on calque, on impose cette surface via notre image sur notre surface où nous voulons l'afficher. 

Et on n'oublie pas bien sûr tout le temps à la fin au niveau de notre programme, le flip() donc au niveau de l'affichage complet, l'affichage général, pour avoir tout ça de visible à l'écran parce que je rappelle que si vous ne mettez pas le flip(), vous n'aurez qu'un écran noir.
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (800, 600)
blank_color = (255, 255, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #37")
window_surface = pygame.display.set_mode(window_resolution)

cat_image = pygame.image.load("logo.png") #Retourne une Surface
cat_image.convert_alpha()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
   
   # Corps du programme
   window_surface.fill(black_color)
   window_surface.blit(cat_image, [10, 10])
   #pygame.display.flip()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

        +-----------------------------------------------+
        | Python #37                             - # x  |
        |                                               |
        |                                               |
        |           Ecran noir                          |
        |                                               |
        |                                               |
        |                                               |
        +-----------------------------------------------+
```
Voilà vous n'aurez qu'un écran noir donc c'est très important de ne pas l'oublier sinon vous vous demanderez pourquoi rien ne s'affiche à l'écran. 

Voilà pour ça donc il faut vraiment bien penser à gérer tout ça pour que la mise à jour se fasse au niveau de notre affichage. 

Et puis on n'a pas grand-chose d'autre à voir, alors qu'est-ce qu'on pourrait voir également … comment parler de transparence on va terminer sur une petite chose, j'aurais pu vous le garder sur le côté pour un tuto ou autre mais je vais vous en parler là puisqu'on parlait du canal alpha et de la transparence donc autant parler ici.

en réalité au niveau de d'autres formats par exemple le jpeg, on peut éventuellement gérer une couleur de transparence si on le souhaite. 

Si par exemple notre image jpeg ou alors même le logo, si j'avais converti le logo … Ce qu'on peut faire pour l'image jpeg, c'est de choisir une couleur de transparence, admettons comme vous l'avez vu sur l'exemple si j'avais voulu une image en jpeg avec une couleur que je veux transparente par exemple blanc sur la photo du chat. 

D'ailleurs on va l'appliquer sur le chat comme ça on verra quelque chose et au niveau de la couleur on va charger le Black.
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (800, 600)
blank_color = (255, 255, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #37")
window_surface = pygame.display.set_mode(window_resolution)

cat_image = pygame.image.load("cat.jpg") #Retourne une Surface
cat_image.convert()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
   
   # Corps du programme
   window_surface.fill(black_color)
   window_surface.blit(cat_image, [10, 10])
   pygame.display.flip()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

        +-----------------------------------------------+
        | Python #37                             - # x  |
        |                                               |
        |                                               |
        |           Ecran noir                          |
        |                                               |
        |                                               |
        |                                               |
        +-----------------------------------------------+
```
On va rester là dessus mais si on veut choisir une couleur de transparence à notre image, on peut également le faire même si on n'est pas sur un format png qui gère la transparence.

Pour cela nous avons également une méthode très pratique qui va travailler sur notre surface donc sur notre image pour spécifier une couleur que nous voulons transparente sur cette image donc là c'est très important.

Donc on va faire notre image, on va définir par exemple une variable cat_image.set_colorkey() donc tout attaché mais il y a bien un underscore entre set et colorkey. 
```py
    cat_image.set_colorkey()
```
Et à l'intérieur on va spécifier une couleur qui sera transparente pour vous donc moi je dis que sur cette image ici donc sur cette surface parce que maintenant c'est une surface attention. On est bien peut-être sur une méthode de cat_image qui est une surface si on vérifie le type de cet objet là et on rend transparent la couleur qui a les coordonnées, ces valeurs-là *255, 255, 255* donc la couleur blanche.
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (800, 600)
blank_color = (255, 255, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #37")
window_surface = pygame.display.set_mode(window_resolution)

cat_image = pygame.image.load("cat.jpg") #Retourne une Surface
cat_image.convert()
cat_image.set_colorkey(blank_color)

launched = True
while launched:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            launched = False
    
    # Corps du programme
    window_surface.fill(black_color)
    window_surface.blit(cat_image, [10, 10])
    pygame.display.flip()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

        +-----------------------------------------------+
        | Python #37                             - # x  |
        |                                               |
        |                                               |
        |                                               |
        |                                               |
        |                                               |
        |                                               |
        +-----------------------------------------------+
```
Et à l'exécution, la couleur sera automatiquement passée transparente donc on voit que tous les endroits son image où j'ai effectivement ces valeurs là 255, 255, 255 donc attention c'est un blanc parfait en fait, ce n'est pas un blanc approximatif donc évidemment si on a ceci 255, 255, 254 ça ne passera pas. Ce ne sera pas mis en transparence, c'est vraiment exactement ces valeurs là. 

On se rend compte que sur notre image, on a toutes les parties blanches qui ont été effacés. C'est devenu transparent c'est-à-dire qu'on va en fait la couleur de notre surface principale et donc c'est pour ça que c'est noir. Ce n'est pas que ça a été rempli de noir attention, c'est simplement que c'est devenu transparent donc on voit à travers. 

Alors ça peut être pratique du coup quand vous avez besoin par exemple quand vous avez besoin de gérer certaines transparences, ça peut servir. 

Après honnêtement dans un vrai cas quand vous allez travailler sur les personnages c'est que vous allez gérer des ressources pour un jeu vidéo ou autre qui ont besoin de gérer des transparences, vous allez principalement travailler avec des images en png. 

On fait un petit convert_alpha() et c'était bien plus pratique. 

C'est quand même beaucoup plus rare de faire une image jpeg puis de gérer une transparence dessus d'autant que vous voyez que c'est assez limité c'est-à-dire que vous allez gérer une seule couleur de transparence si votre image a des fois à différents tons de blanc ou différents tons de vert ou différents tons de rose, et bien elle va rendre transparent différents tons de couleurs et pas d'autres donc ça ne sera pas forcément très propre au niveau résultats. 

Donc grosso modo, jpeg, on va travailler sur de l'image pleine donc une image en rectangulaire ce genre de chose ou carré. 

Et avec le png, avec convert_alpha, on va travailler sur des images pour gérer la transparence donc grosso modo c'est ce qu'il faut retenir si vous voulez ne pas trop vous prendre la tête. 

Puis voilà écoutez je pense que tout ce que je voulais vous dire sur l'affichage d'image a été dit, je n'ai pas besoin d'en rajouter plus donc attention de bien charger les choses comme il faut. 

Alors le chargement des ressources, comme je n'ai qu'a le faire qu'une seule fois on ne le fait surtout pas dans une boucle.
```py
    pygame.init()
    window_resolution = (800, 600)
    blank_color = (255, 255, 255)
    black_color = (0, 0, 0)

    pygame.display.set_caption("Python #37")
    window_surface = pygame.display.set_mode(window_resolution)

    cat_image = pygame.image.load("cat.jpg") #Retourne une Surface
    cat_image.convert()
    cat_image.set_colorkey(blank_color)
    
    # ... 
    Boucle while # ...
```
En tout cas on le fait certainement pas dans une boucle qui se lance à l'infini sinon vous allez charger cette image à l'infini, ça peut être assez lourd au niveau ressources et je pense que votre ordinateur ne va pas trop apprécier. 

Donc n'hésitez pas, là vous avez quand même l'occasion de voir beaucoup beaucoup de choses pour vous entraîner. Il y aura évidemment parce que ce n'est pas encore le cas au moment que je fais cette vidéo-là, il y aura des exercices qui sont liés à pygame donc je vous demanderai de faire quelques exo's pour mettre en pratique cette bibliothèque qui est vraiment très très rapide à mettre en place et qui permet de faire beaucoup de choses en très peu de lignes de code. 

Et je n'ai plus qu'a vous dire à bientôt, on se retrouvera pour une prochaine séance et on va continuer de découvrir d'autres modules et d'autres petites choses très sympathiques avec pygame en python. 

À bientôt