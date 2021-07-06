# [35. Première fenêtre](https://www.youtube.com/watch?v=LrcMOeUN1qI)

Bienvenue et bonjour tout le monde, on se retrouve sur cette séance numéro 35 en python. 

On avance maintenant sur ce nouveau chapitre et dernier chapitre du cours concernant le module pygame, la bibliothèque même pygame pour être plus exact qui va nous permettre de manipuler tout un tas de choses graphique en 2D avec le langage python. 

Dans la vidéo précédente, on avait simplement fait une introduction avec un code minimal que je vais reprendre évidemment pour la suite des vidéos.
```py
    #coding:utf-8
    import pygame

    pygame.init()
    screen = pygame.display.set_mode((640,480))

    launched = True

    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Et je vous avais dit qu'on allait expliquer les choses au fur et à mesure, il fallait produire un code minimal pour que vous ayez quelque chose d'afficher et qu'on puisse vérifier également que pygame était bien installé. 

Maintenant que c'est cas, au fur et à mesure des choses que nous allons voir, je vous expliquerai plus en détail le code qu'on a déjà utilisé.

Alors je passerais outre la partie ici.
```py
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Partie qui concerne la boucle principal de notre programme, qui est une boucle infinie jusqu à quitter le programme via les boutons, les contrôles de la fenêtre, la fameuse croix. Quand vous cliquez sur la croix d'une fenêtre pour fermer cette dernière.  

Comme on aura une vidéo dédiée aux événements, on reviendra plusieurs détails là-dessus donc je ne vais pas expliquer cette partie là. 

Nous on va surtout se concentrer sur la partie du début ici.
```py
    #coding:utf-8
    import pygame

    pygame.init()
    screen = pygame.display.set_mode((640,480))
```
Cette partie parce que nous allons voir comment créer notre première fenêtre au niveau de pygame. 

Alors la première chose qu'on avait fait, c'était l'import de la bibliothèque donc pas de problème au niveau de pygame ici. 

Et ensuite on avait utilisé une méthode pour pygame qui s'appelle init(). 

La méthode init() va tout simplement initialiser quelques modules de python, alors pas forcément tous mais les modules principaux pour le charger au niveau du programme donc en général c'est suffisant par rapport à ce que nous allons avoir besoin de faire, et de toute manière quand on verra d'autres modules un petit peu plus exotique sur pygame, on verra pour les charger directement. 

Donc c'est le mieux, c'est le plus efficace à utiliser parce que vous aurez la plupart du temps besoins des modules qu'elle charge donc vous pouvez faire le init() ici mais vous avez également pour chacun des modules différents une méthode init() correspondant. 

Par exemple on voit qu'on a un module display, on va bien sûr en parler, mais j'aurais pu très bien faire bien que avec le pygame.init(), il est déjà chargé. 

On aurait pu très bien faire pygame.display.init() pour juste charger le module display donc il faut comprendre que pour chacun des autres modules de pygame, vous pouvez charger ce dernier explicitement, et le charger uniquement plutôt que de faire un chargement plutôt général avec pygame.init(). 

Donc nous pour avoir quelque chose assez générique et qui va correspondre à une majorité de cas d'applications pour pygame, et on verra éventuellement pour des cas un peu particulier, on fera directement pygame.init() tout simplement pour initialiser notre programme. 

Alors ça c'est très important parce que sans ça on n'a pas les modules qui sont chargés, on peut évidemment pas s'en servir donc on n'aura pas la possibilité de charger une fenêtre, et c'est avec cela qu'on va travailler pour commencer. 

Alors je parle de fenêtre mais en réalité nous allons créer une surface pour être un peu plus détaillé dans les termes. On ne va pas se contenter de charger une fenêtre, la fenêtre c'est le système d'exploitation qui s'en charge qui va charger une fenêtre avec les fameux contrôles réductions, agrandissement et fermeture de la fenêtre mais nous nous allons charger une surface, et même afficher une surface. 

Et cela va se passer de cette manière là avec le module display qui a été chargé dans init() donc on va utiliser une variable … c'est ce que j'avais fait dans la vidéo précédente mais je n'avais pas forcément expliqué dans le détail, on va via le module display c'est-à-dire pygame.display parce que je fais un import de cette manière, utiliser ici set_mode().
```py
    screen = pygame.display.set_mode((640,480))
```
Set_mode(), on pourrait s'imaginer que c'est juste en fait pour pouvoir modifier un mode ou avoir une certaine caractéristique mais en réalité c'est ce qui va nous créer notre fenêtre, d'accord notre fenêtre d'affichage donc ici notre surface. 

Donc le nom peut sembler un peu bizarre mais c'est la fonction utilisée par rapport à ce que nous voulons faire, elle va prendre en paramètre et c'est très important la résolution de notre écran. 

La résolution on avait passé directement ici (640, 480) et normalement vous reconnaissez directement ici ce type de notation. 

D'ailleurs si je fais ça.

Vous devez normalement reconnaître un tuple, `res = (640, 480)`.
```py
#coding:utf-8
import pygame

res = (640, 480)

pygame.init()
screen = pygame.display.set_mode(res)

launched = True

while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
On peut également avoir une liste, on peut très bien avoir une liste de 2 éléments si on veut mais par habitude on travaillera plutôt avec un tuple. 

Donc je peux sans problème passer le tuple dans set_mode(res) pour la résolution. 

On peut aussi passer différentes valeurs ce qu'on appelle des Flags, c'est-à-dire des drapeaux qui pourront prendre différentes valeurs précises pour changer un petit peu le mode de setting donc le mode enfaite d'ouverture, de création de cette fenêtre là, de cette surface parce que vous allez voir en fait qu'on va obtenir une surface. 

Alors ils ne sont pas obligatoires, on peut laisser la chose telle qu'elle est par défaut, et de toute façon on va quand même exécuter le programme parce que c'est ce qu'on nous avait fait dans la vidéo d'introduction pour pygame, et là on va vite se rendre compte que notre fenêtre s'ouvre sans problème.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +---------------------------+
    |pygame window        - # x |
    |                           | 
    |                           |
    |                           |    
    +---------------------------+
```
Une fenêtre s'ouvre sans problème donc en 640 par 480, ce sont effectivement les dimensions que j'ai donnée ici. 

Donc ici on a une fenêtre avec des contrôles - # x et on a également une surface qui a été générée mais ça on l'avait pas dit précédemment parce qu'on n'était pas encore là, on avait juste fait l'introduction de pygame. 

Mais maintenant vous savez qu'en réalité on a screen qui contient un objet qui est une surface d'accord. 

D'ailleurs ce que l'on peut faire, c'est afficher le type() de screen.
```py
#coding:utf-8
import pygame

res = (640, 480)

pygame.init()
screen = pygame.display.set_mode(res)

print(type(screen))

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
On va faire ceci.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    <class 'pygame.Surface'>

    +---------------------------+
    |pygame window        - # x |
    |                           | 
    |                           |
    |                           |    
    +---------------------------+
```
Et vous voyez qu'il me met le nom, vous voyez 'pygame.Surface' donc vous avez le nom grâce à la fonction type() qui vous retourne ici le type d'une donnée donc ici en l'occurrence notre variable, notre objet. 

Et on a bien ici un objet de classe 'pygame.Surface' donc on a une surface ici pygame qui va permettre de gérer tout ça. 

Alors ça c'était la petite chose à connaître qui est très simple pour pouvoir faire ça, les fonctions print() et type() permettre de vérifier un petit peu ce que nous avons et cette surface va être un petit peu comme notre tableau. 

On peut imaginer un petit peu comme un tableau noir sur lequel on va pouvoir écrire, dessiner, afficher des images, gérer des animations puisque les animations sont simplement un enchaînement d'images différentes qui se suivent qui sont en fait successives donc tout va fonctionner de cette manière là. 

On aura notre tableau, notre surface sur lequel nous allons pouvoir régler tout un tas de choses, nous allons pouvoir dessiner, nous allons pouvoir modifier les couleurs, afficher du texte, gérer même du son parce qu'il y a un module spécialement pour le son dans pygame et on aura l'occasion d'en parler. 

Et tout un tas d'autres choses. 

Alors je vais revenir sur les flags, les petits drapeaux dont je parlais justement pour le mode ici, set_mode(), on va les noter très rapidement ici parce qu'il y en a quelques-uns à connaître. 
```py
    """
    """
```
Donc si vous voulez utiliser un de ces flags, il suffit de le passer en 2nd paramètre dans set_mode(res, …) et vous pouvez en passer plusieurs mais ça vous connaissait pour ceux qui ont déjà programmé avec la SDL, la bibliothèque de dès que l'on retrouve dans d'autres langages, et je vous avais dit que pygame était justement basée sur la SDL donc on va retrouver ce même fonctionnement. 

Alors on va avoir, on va préciser pygame est un mode FULLSCREEN qui comme son nom l'indique va afficher en plein écran votre jeu mais moi je ne vais pas le faire. 
```py
    """
    pygame.FULLSCREEN
    """
```
Voilà sachez que ça c'est le plein écran, alors on a un cas DOUBLEBUF qui est le double buffering qui va permettre de gérer une double mémoire tampon. 
```py
    """
    pygame.FULLSCREEN
    pygame.DOUBLEBUF
    """
```
En fait et ça c'est ce qu'il faut voir dans les animations par exemple dans les jeux vidéo ou autre, vous avez encore une fois une succession d'images qui s'affichent pour créer des animations c'est-à-dire que vous avez une image qui est actuellement affichée et il faut que ça passe à une image suivante. 

Le problème c'est qu'avec une seule mise en mémoire tampon, on se rendrait compte d'une cassure entre les 2 ou de scintillement, on verrait qu'on a changé d'image mais donc l'animation serait un peu cassée, on aurait ce qu'on appelle des déchirures à l'écran ou des tearing, le terme tearing en anglais.

Pour éviter ça avec les systèmes plus moderne de maintenant, avec les mémoires qui sont bien plus agrandie bien plus importante, on travaille maintenant en double buffing voir plus, on peut même travailler en multiple mémoire tampon ce qui permet d'éviter à cette fameuse cassure ce fameux déchirement qu'on peut voir sur les images et de faire un passage d'une image à l'autre quasi instantanément. 

Et du coup on ne se rend pas compte au niveau de l'œil, on ne se rend pas compte de cette déchirure, on ne la voit plus à l'écran donc c'est très important et DOUBLEBUF sera utilisé dans certains cas si vous utilisez en fait avec d'autres modes mais je vais revenir dessus. 

Donc le DOUBLEBUF, il va être utilisable si vous vous servez d'autre chose, déjà si vous vous servez de HWSURFACE et ça c'est pour l'accélération matérielle donc pareil je vais donner un petit peu de détails aussi même si j'ai pu le faire dans certaines vidéos.
```py
    """
    pygame.FULLSCREEN
    
    pygame.HWSURFACE
    pygame.DOUBLEBUF
    """
```
De base quand vous cherchez un programme 2D, c'est principalement de l'accélération logicielle c'est-à-dire votre processeur, le CPU ce qu'on appelle la mémoire centrale de votre ordinateur il va s'occuper de faire tous les calculs. 

Le problème c'est lorsqu'on arrive sur des programmes beaucoup plus gourmands avec beaucoup plus de nécessité de ressources et beaucoup plus de demandes de puissance on va dire, le processeur n'arrivait plus à suivre parce qu'il devait gérer à la fois l'exécution du programme, gérer votre système d'exploitation qui continue de tourner et tout un tas de choses derrière, il ne pouvait pas gérer en plus tous ces calculs complexes et nombreux à faire.

Donc au lieu de donner ça en charge au niveau du processeur central, on déléguait ça a autre chose, on parle d'accélération matérielle parce que ça passe vraiment, c'est un débit qui transitent directement par les câbles, des composants qui sont reliés à votre ordinateur donc ça peut être une carte graphique dédiée, ça peut être de l'accélération vidéo, on a de l'accélération audio,  on a de l'accélération pour la 3D bref tout un tas de types d'accélération. 

Donc si vous avez entendu parler de choses comme open GL, comme direct 3D, ce genre de chose, ça concerne justement et ça peut être exploité avec l'accélération matérielle qui dans ce cas-là permettra de déléguer les calculs et donc de soulager un petit peu le processeur pour le laisser s'occuper certaines tâches et déléguer d'autres tâches à d'autres composants qui peuvent effectuer des calculs complexes et conséquent au niveau de votre ordinateur donc en général quand on va utiliser cette accélération matérielle, on appliquera le DOUBLEBUF automatiquement, ça s'optimises pas mal avec ça.

On a également et j'en parle très rapidement, le OPENGL.

Le OPENGL c'est tout simplement comme direct 3D donc directive si on parle aussi pour Windows, OPENGL qui est un équivalent qu'on retrouve un petit peu sur d'autres systèmes qui est du multiplateforme alors que direct 3D appartient à Microsoft en fait c'est sur Windows, ça va nous permettre de gérer le type d'affichage avec ce type de rendu. 

D'accord on va travailler sur du rendu OpenGL, vous pouvez travailler avec cette option là.
```py
    """
    pygame.FULLSCREEN
    
    pygame.OPENGL
    pygame.HWSURFACE
    pygame.DOUBLEBUF
    """
```
Pareil si vous travaillez avec du rendu OpenGL ou l'accélération matérielle ou les 2 à la fois, il est évident et bien conseillé d'utiliser le DOUBLEBUF à ce moment-là, ce sera bien plus pratique par rapport à ces options-là. 

Donc ça ce sont 3 options qu'on va ne va pas utiliser dans la vidéo ici parce que ce n'est pas utile mais il fallait absolument que vous les voyez parce qu'elles sont à connaître. 

Ensuite on en a … ça ça va peut-être plus vous parler, c'est de travailler avec RESIZABLE qui va permettre de gérer une fenêtre qui est redimensionnable. 
```py
    """
    pygame.FULLSCREEN
    pygame.RESIZABLE
    
    pygame.OPENGL
    pygame.HWSURFACE
    pygame.DOUBLEBUF
    """
```
Alors ça c'est peut-être plus intéressant à s'en servir, et ensuite on a le cas où il faut peut-être un cas très spécifique pour s'en servir qui est NOFRAME.
```py
    """
    pygame.FULLSCREEN
    pygame.RESIZABLE
    pygame.NOFRAME
    
    pygame.OPENGL
    pygame.HWSURFACE
    pygame.DOUBLEBUF
    """
```
Si j'utilise cette option là, je peux vous la montrer directement en faisant juste ça, pygame.NOFRAME.
```py
#coding:utf-8
import pygame

"""
pygame.FULLSCREEN
pygame.RESIZABLE
pygame.NOFRAME

pygame.OPENGL
pygame.HWSURFACE
pygame.DOUBLEBUF
"""

res = (640, 480)

pygame.init()
screen = pygame.display.set_mode(res, pygame.NOFRAME)

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

    +---------------------------+
    |                           | 
    |                           |
    |                           |    
    +---------------------------+
```
On se retrouve avec une fenêtre qui n'a plus de contrôle donc on est obligé de le quitter directement par la barre des tâches sur le gestionnaire de fenêtre, ce qui n'est pas très pratique.

Donc ça peut servir dans certains cas spécifiques mais vous je pense que vous vous n'en servirez pas beaucoup. 

Alors si on met RESIZABLE par exemple, pareil on peut remplacer comme ça mais si on veut mettre plusieurs options il faut mettre une barre de schleifer | bref une barre verticale et vous pourrez comme ça rajouter d'autres options. Par exemple, si vous voulez du NOFRAME également vous mettrez ça comme ça.
```py
    screen = pygame.display.set_mode(res, pygame.RESIZABLE | pygame.NOFRAME)
```
Et vous pourrez mettre comme ça tout un tas d'options séparé donc nous on va mettre RESIZABLE.
```py
#coding:utf-8
import pygame

"""
pygame.FULLSCREEN
pygame.RESIZABLE
pygame.NOFRAME
pygame.OPENGL
pygame.HWSURFACE
pygame.DOUBLEBUF
"""

res = (640, 480)

pygame.init()
screen = pygame.display.set_mode(res, pygame.RESIZABLE)

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

    +---------------------------+
    |pygame window        - # x |
    |                           | 
    |                           |
    |                           |    
    +---------------------------+
```
Vous voyez un redimensionnement qui peut être fait au niveau de la fenêtre, chose qui n'était pas possible au départ donc ça c'est à vous de voir si vous en avez pas besoin vous pouvez laisser tel quel set_mode(res). 

Alors ici les différents options, drapeaux, les flags qu'on peut utiliser au niveau de la création ici set_mode() c'est-à-dire la création de la fenêtre donc en l'occurrence la surface, on va travailler sur une surface.
```py
    """
    pygame.FULLSCREEN
    pygame.RESIZABLE
    pygame.NOFRAME
    pygame.OPENGL
    pygame.HWSURFACE
    pygame.DOUBLEBUF
    """
```
D'ailleurs pour faire çà proprement plutôt que d'appeler ça simplement screen, on va appeler ça window_surface comme ça on saura que c'est une surface pour avoir fatalement un terme un peu plus explicite. 
```py
    #coding:utf-8
    import pygame

    res = (640, 480)

    pygame.init()
    window_surface = pygame.display.set_mode(res)

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Alors ça `pygame.display.set_mode(res)`, il faut comprendre que set_mode() c'est vraiment ce qui va permettre la création de votre fenêtre donc c'est à dire que si vous voulez à un moment donné, admettons la passer en FULLSCREEN je ne sais pas quand dans votre programme, il faudra rappeler cette méthode set_mode() dans l'idéal c'est-à-dire que vous allez recréer, que vous allez reprendre éventuellement cette ligne là n'importe dans votre programme.
```py
    #coding:utf-8
    import pygame

    res = (640, 480)

    pygame.init()
    window_surface = pygame.display.set_mode(res)

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
         
        window_surface = pygame.display.set_mode(res)
```
Voilà n'importe où dans votre programme, je le mets ici après la boucle for mais je ne vais pas de toute façon exécuter le programme, et vous pouvez même changer la résolution … alors vous mettez ceci.
```py
    #coding:utf-8
    import pygame

    res = (640, 480)

    pygame.init()
    window_surface = pygame.display.set_mode(res)

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
        res = (500, 500)
        window_surface = pygame.display.set_mode(res)
```
Bien que ce soit pas quelque chose à faire dans votre programme. 

La automatiquement on changerait, automatiquement le mode ici donc cette surface là window_surface comme il ne peut y en avoir qu'une seule à la fois pour pygame, ça va remplacer l'ancienne donc automatiquement on va passer le relais d'une surface à une autre donc vous pouvez faire le changement à ce moment-là dans le cadre d'un changement de résolution, un changement de mode d'ouverture où ce genre de choses. 

Vous rappeler tout simplement set_mode() sur le module display, et ça fera le changement automatiquement. 

Voilà, qu'est-ce que je peux vous dire d'autre par rapport à ça ? oui voilà quelque chose qui va pouvoir pas mal vous servir. 

Comme vous allez tester et que vous êtes surtout là pour apprendre tout un tas d'options, d'ouverture, de création de fenêtre, vous avez peut-être envie de voir que les options et modes que vous avez mise sont correctes donc je vous propose … j'aurais pu très bien m'en passer mais je pense que c'est intéressant de vous le donner, une petite fonction très pratique qui va vous permettre d'afficher les informations liées justement aux modes d'ouverture que vous avez choisies, aux options que vous avez choisies. 

Alors on va le faire dans un prime pour avoir un affichage tout simplement il suffit de mettre pygame.display donc on travaille toujours avec le module display qui je rappelle a été chargé ici avec init() sur pygame, et c'est Info() mais attention parce que c'est un I majuscule bien que je ne sais pas pourquoi est-ce qu'ils ont mis un I majuscule. Il y a sûrement une raison d'accord c'est peut être juste pour différencier, c'est aussi pour différencier les fonctions, méthodes et cetera selon qu'on travaille sur des objets ou non … donc il y a un I majuscule, très important pour ne pas faire l'erreur. 

Et du coup si je charge le programme voilà ce que nous avons.
```py
#coding:utf-8
import pygame

res = (640, 480)

pygame.init()
window_surface = pygame.display.set_mode(res)

print(pygame.display.Info())

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
    <VideoInfo(hw = 0, wm = 1,video_mem = 0
             blit_hw = 0, blit_hw_CC = 0, blit_hw_A = 0,
             blit_sw = 0, blit_sw_CC = 0, blit_sw_A = 0,
             bitsize  = 32, bytesize = 4,
             masks =  (16711680, 65280, 255, 0),
             shifts = (16, 8, 0, 0),
             losses =  (0, 0, 0, 8),
             current_w = 640, current_h = 480
    >
```
Voilà ce que nous avons dans le terminal, on a tout un tas d'informations qui sont affichées donc ça peut être pratique pour voir si on a par exemple l'accélération matérielle qui est ou non en fonction. On a les dimensions ensuite on peut voir pas mal de choses donc vous pourrez comme ça vérifier les informations que vous avez mises, si elles sont correctes qu'elles ont bien été prise en compte. 

Par exemple j'ai mis 640 par 480 mais là je peux vérifier si mon programme à bien chargé la résolution que je voulais, si c'était pas le cas je me dirais qu'il y a un problème au niveau du code de mon programme donc ça permet de faire des petites vérifications. 

C'est à connaître voilà c'est cadeau, vous pouvez prendre Info() qui permet du coup de récupérer tout un tas d'informations liées justement à la surface que vous avez créé donc ici en l'occurrence le programme qu'on a lancé. 

C'est ça qui est intéressant, c'est pour ça qu'on a une seule surface si vous voulez pour l'affichage pour ce fameux tableau noir dont je vous parlais qui va permettre de dessiner ensuite à l'intérieur, d'afficher les images, changer les couleurs où ce genre de choses. 

Voilà pour ça qu'est ce qui peut être utile aussi comme informations à afficher ? Alors oui pygame est basé sur la SDL qui est une bibliothèque graphique 2D que je vous ai appris à manipuler sur l'information en langage c si jamais vous l'avez déjà suivi mais si vous l'avez pas suivi vous aurez l'occasion d'aborder cela. 

Pygame se base là-dessus donc si par curiosité vous voulez voir quelle version de la SDL est utilisé avec votre version de Pygame, vous pouvez également vérifier ça en faisant juste … on peut vérifier ça en mettant dans un print(), et c'est un peu différent ... ce n'est pas pygame.display parce que c'est pygame qui utilise la SQL ... et si je ne dis pas de bêtises ça doit être un get_sld_version() un truc comme ça, normalement c'est ça, et on va recharger.
```py
#coding:utf-8
import pygame

res = (640, 480)

pygame.init()
window_surface = pygame.display.set_mode(res)

print(pygame.get_sdl_version())

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
    (2, 0, 12)
```
Voilà on voit la version de pygame voilà donc moi celle la 1.9.4 logiquement c'est celle que vous aurez si vous avez suivi ma vidéo parce que quand on a fait l'installation vous devriez avoir cette version là ou en tout cas une version plus récente d'accord donc si vous avez une version plus récente tant mieux, et là on voit qu'on travaille avec la version 1.2 de SDL. 

Alors pour ceux qui ont suivi ma formation en langage c, vous avez vu qu'on a travaillé avec la SDL2 parce que je vous avais dit que c'était mieux que c'était plus moderne, que c'était plus puissant, il y avait beaucoup plus de fonctionnalités, que la SDL 1.2 était vraiment à éviter, était obsolète. 

Là vous vous rendez compte que le pygame actuel n'est encore que la version 1.2 donc il faut savoir que pygame est en train et est toujours en cours d'amélioration de développement, en tout cas l'équipe autour de pygame continue de développer ce module donc cette bibliothèque. 

Et pygame 2 donc la version 2 de pygame est sur le moment où je fais de cette vidéo, sur le point d'arriver il sera basé sur la SDL 2 donc ça promettra pour le coup encore plus de performance, de puissance et de possibilités avec cette bibliothèque parce qu'il y a vraiment une sacrée différence à sacré écart entre SDL 2 et SDL 1.2 qui est très très vieille.

SDL 1.2 c'est une très vieille version de la SDL donc là quand on sera sur du pygame 2, et au moment je fais cette vidéo la version pygame 1.9.5 qui va bientôt sortir comme il me semble au moment je fais cette vidéo qui sera toujours sur SDL 1.2 mais en parallèle, il travaille sur la version 2 de pygame qui sera pygame 2 pour SDL 2 donc ça devrait être bien plus performant, et avec beaucoup plus de possibilités au niveau des programmes que vous pourrez faire en python. 

J'ai hâte de voir ce que ça va donner parce que ça va faire un bel écart au niveau performance. 

Voilà c'est pour ça que je voulais vous donner cette petite fonction pratique get_sdl_version() pour que vous sachiez par curiosité, quelle version de SDL se trouve en fait derrière l'utilisation de pygame que vous avez ici. 

Mais maintenant on va la rassurer parce qu'on n'en a plus besoin ici.
```py
    #coding:utf-8
    import pygame

    res = (640, 480)

    pygame.init()
    window_surface = pygame.display.set_mode(res)

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```         
Donc dans cette vidéo il n'y a pas grand chose à vous montrer je voulais quand même prendre le temps de détailler les choses parce que c'est bien de débattre de savoir ce que vous utilisez, et comme vous le savez … vous avez l'habitude avec ma vidéo, que je vous explique toujours tout dans le détail pour que vous sachiez ce que vous faisiez. 

Il n'y a rien de pire en informatique en programmation ou dans n'importe quoi de faire du code, faire utiliser des méthodes, des fonctions et des classes, et cetera sans savoir ce que l'on fait … en disant tout simplement qu'il faut faire ça parce que ça fait ça et puis terminé. 

Voilà moi je vous explique toujours tout dans le détail pour que vous sachiez pourquoi est-ce qu'on mettait le code et tel autre compte, et que ça ne soit pas fait comme ça par l'opération du Saint-Esprit ou je ne sais quoi. 

Alors on a vu la création, je vous expliqué que c'était une surface donc je vous aime bien te montrer. 

Ensuite ça on en parlera pas parce que c'est lié aux événements :
```py
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```          
Donc on verra ça plus tard mais je vais peut-être encore vous montrer quelques petits trucs … alors je vous ai parlé des infos, je vous ai parlé de la SDL, on a fait le tour …

Ou alors un petit détail qui peut être sympa c'est de voir comment on peut modifier le titre de la fenêtre aussi, c'est Bon à savoir et ça peut servir pas mal quand-même. 

Donc juste avant de créer la fenêtre ici on va mettre tout simplement, on va le faire sur l'affichage donc sur le module display, et c'est set_caption() comme pour les tableaux en HTML, le caption c'est lui qui gère le titre et à l'intérieur vous mettez le titre que vous voulez "Mon premier programme PYGAME" et là je compile.
```py
#coding:utf-8
import pygame

res = (640, 480)

pygame.init()

pygame.display.set_caption("Mon premier programme PYGAMME")
window_surface = pygame.display.set_mode(res)

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
    
    +-------------------------------------------+
    |Mon premier programme PYGAMME        - # x |
    |                                           | 
    |                                           |
    |                                           |    
    +-------------------------------------------+
```
Et là du coup, on a modifié le titre de notre fenêtre d'application. 

Alors là vous pouvez changer aussi les icônes et cetera mais ça je n'en parle pas volontairement parce que j'ai beaucoup de gens qui m'avaient demandé comment modifier une icône ?, comment modifier l'icône de l'exécutable ? si on fait un exécutable ce genre de chose mais là c'est différent pour python mais on peut changer ce genre de chose. 

Le problème c'est que tout ce qui est modification des cônes n'est pas forcément très portable, car par exemple sur Linux tout ça, vous n'aurez pas de problème mais Windows refuse parfois les modifications de certaines icônes parce qu'il a tout simplement décidé que voilà il ne fallait pas y toucher. 

Voilà donc je donnerais pas forcément de méthode parce que je ne pourrais pas vous proposer quelque chose qui fonctionnera à 100 pourcent chez tout le monde, et ça va être plus galère, plus casse-pied qu'autre chose donc il faudra vous contenter de ça. 

Mais on cherchera quand même, je vous proposerai peut-être sur le discord tout à côté pour ceux que ça intéresse, quelques méthodes possibles mais voilà je les met pas en vidéo parce qu'il y en a plein qui vont vouloir le faire et ça ne marchera pas chez tout le monde. 

Ça va être la galère et au final vous n'aurez pas quelque chose de complètement fonctionnel d'autant que le changement d'icône demande pas mal d'autres opérations et vous venez tout juste de commencer à aborder pygame donc on va avancer tranquillement sans aller trop vite et risquer de brûler les étapes. 

Voilà donc maintenant vous savez créez votre fenêtre qui est votre surface principale. 

Pour votre programme vous savez modifier le titre de cette fenêtre, vous savez choisir le mode d'ouverture de cette fenêtre … plein écran si on veut travailler dans un contexte openGL, si on veut utiliser l'accélération matérielle et tout ce genre de choses qui sont intéressantes. 

Vous savez également que pour modifier le mode d'ouverture ou recharger une nouvelle surface et cetera, il faut refaire appel à set_mode(), c'est très important. C'est tout simple c'est vraiment juste ça. 

Petite particularité, vous avez remarqué que python est un langage qui gère lui-même sa mémoire, qui fait la libération. 

Vous avez vu que j'ai un pygame.init() et pour ceux qui auraient été curieux et qui auraient été voir la doc, la documentation de pygame ou par habitude de l'utilisation d'autres bibliothèques … vous vous êtes peut-être dit qu'il devait y avoir un pygame.quit() ou un pygame.exit() ? Eh bien non, on sait pas faire tout simplement parce que python s'en charge lui-même. Dès qu'on quitte le programme il va faire lui-même appel à ça. 

Là où ça peut être utile de faire un pygame.quit(), et je vais terminer la vidéo avec ça. Quand vous faites ça pygame.quit(), Ça veut dire que ça va décharger tout ce qui a été chargé avec init(). 
```py
    #coding:utf-8
    import pygame

    res = (640, 480)

    pygame.init()

    pygame.display.set_caption("Mon premier programme PYGAMME")
    window_surface = pygame.display.set_mode(res)

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
                
    pygame.quit()
```
Donc ici avec init(), c'est l'inverse en fait. Pygame.init() Permet de charger les modules standard, et là pygame.quit() permet de télécharger les modules standard. 

Ça si vous voulez refaire une nouvelle initialisation admettons que vous voulez tout décharger de pygame et faire un chargement vous-même en admettons que par exemple je recherche cette fois seulement le module display. 
```py
    #coding:utf-8
    import pygame

    res = (640, 480)

    pygame.init()

    pygame.display.set_caption("Mon premier programme PYGAMME")
    window_surface = pygame.display.set_mode(res)

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
                
    pygame.quit()
    pygame.display.init()
```
Eventuellement, ça peut servir à ça.
```powershell
        pygame.quit()
        pygame.display.init()
```
Attention pygame.quit() ne signifie pas que vous allez quitter le programme, que ça va fermer la fenêtre. C'est juste pour décharger les modules qui ont été chargés avec le init() donc quit() ne veut pas dire que ça va fermer le programme. Ça n'a absolument rien à voir. 

Je le dis sachant que dans la majorité des cas, vous n'en aurez pas besoin, c'est vraiment pour des cas très très spécifiques, c'est peut être pour un pour 1% des cas et encore. 

Contentez vous juste du init() et quand le programme se quitte quand vous fermez le programme avec la croix, python fait toutes les libérations de mémoire comme il faut d'accord c'est parfaitement géré. 

Vous êtes en python, vous êtes sur un langage beaucoup plus haut niveau que le serait le c ou le c++, là on doit gérer un peu plus la mémoire. Pour python ce n'est pas le cas. 

Voilà et je pense qu'on aura fait, on aura vu pas mal de choses et c'est très bien comme ça pour commencer. On ne veut pas aller plus loin que ça parce qu'il y a beaucoup de choses à voir dans cette vidéo. Je voulais déjà vous montrer pour créer pour votre première fenêtre, pour qu'on voit comment créer notre première fenêtre, notre première surface. 

Vous allez voir qu'on va faire d'autres petites choses avec la surface, vous allez voir qu'on va pouvoir changer la couleur d'une surface, on va pouvoir dessiner sur nos surfaces, faire des lignes et faire des cercles et faire tout un tas de choses. 

Et après on pourra travailler avec des images et des polices de caractères il y a tout un tas d'autres possibilités offert par pygame qui offre quand même pas mal de choses intéressantes avec le langage python. 

J'espère que ça vous plaît en tout cas, j'espère de ne pas aller trop vite dans les choses parce que on a quand même mine de rien vite fait le tour au niveau de pygame. 

Il y a pas mal de choses mais au niveau de la partie du noyau brut, du noyau dur de pygame, il n'y a pas énormément de choses à voir, et on peut très très vite commencer à programmer de petits jeux vidéo, de petites applications graphiques. 

C'est pour ça que j'essaie de ne pas aller trop vite quand même pour que vous puissiez quand même voir les choses étape par étape, que les vidéos soit bien séparées et thématique. Et comme ça si vous êtes bloqué sur quelque chose, n'hésitez pas à faire votre petit programme et vos petits tests comme toujours, et en pas de problème vous me contacter dans les commentaires de la vidéo et je viendrais directement vous répondre. 

Voilà je vais vous laisser avec ça, je vais vous dire à très bientôt pour la suite de cette formation au langage python sur pygame. 

J'espère en tout cas que cette vidéo vous plaise. 

Alors j'ai fait un petit peu le compte vite fait et normalement on devrait terminer avec 42 vidéos si on compte la conclusion, au niveau de cette formation mais ça va peut-être changer sur les vidéos prochaines.

Comme j'ai pas mal de gens qui me demande combien de vidéos je compte faire ou encore combien est-ce qu'il en reste ? donc logiquement il devrait y avoir pour ce cours python 42 vidéos à peu près si je ne change pas entre-temps par exemple en divisant la vidéo en 2 ou que je n'en ressemble pas ensemble si je vois qu'il n'y a pas assez de contenu, à faire en une seule vidéo. 

En tout cas on verra mais normalement 42 vidéos ça devrait tenir au niveau du cours en tout cas parce qu'il y aura certainement des tutoriels sur pygame aussi mais en annexe que je ne juge pas essentiel à l'utilisation et la compréhension de pygame. 

À bientôt tout le monde pour la prochaine vidéo, on se retrouvera du coup pour la séance 36