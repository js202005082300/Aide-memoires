# [40. Événements](https://www.youtube.com/watch?v=Vic8v4MtBNM)

Bonjour et bienvenue pour la 40e séance en python, déjà là 40e on en a vraiment déjà beaucoup. 

On va s'attaquer à une partie très importante et très complète au niveau de pygame c'est-à-dire les événements. 

Donc pour les événements ça va être une vidéo assez longue parce qu'on va avoir pas mal de choses, ne verra pas tout ce qui concerne les événements sur pygame mais en tout cas une bonne partie pour que vous puissiez bien vous amuser pour la suite sur votre petit programme. 

Donc n'hésitez pas comme toujours à faire de petits projets, programmes de votre côté pour mettre tout ça en pratique et bien assimiler tout ce que je vous montre en vidéo. 

Alors déjà qu'est-ce qu'un événement ?

Par ailleurs on va déjà reprendre un code minimal.
```py
    #coding:utf-8
    import pygame
    
    window_resolution = (640, 480)
    
    pygame.init()
    pygame.display.set_caption("Python #40 - événements")
    window_surface = pygame.display.set_mode(window_resolution)
    pygame.display.flip()
    
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```       
Alors qu'est-ce qu'un événement ?

Un événement pour ceux qui n'a encore jamais programmé, pour qui c'est tout nouveau ou bien vous n'avez jamais utilisé de bibliothèque graphique ou d'interface graphique, c'est quelque chose qui va arriver, qui va se produire au niveau de notre interface et que nous allons pouvoir traiter d'accord. 

On va récupérer l'événement en question et en fonction de l'événement qui se sera produit, on pourra réaliser un certain nombre de choses au niveau de notre interface, c'est ça qui nous intéresse. 

Alors grosso modo pygame qui je le rappelle est basée sur la bibliothèque SDL, une autre bibliothèque qu'on retrouve dans d'autres langages, utilis le principe de fil d'événements c'est-à-dire que chaque événement quel qu'il soit par défaut va être récupérée, stocké dans une file d'attente d'accord jusqu à éventuellement être traité ou non. Voilà on n'est pas obligé de traiter les événements mais ils sont quand même enregistrer dans cette fameuse fil d'évènements. 

Alors on peut filtrer les événements, on peut très bien dire qu'on en acceptes certains et qu'on en a refuse d'autres ou encore qu'on en ignore d'autres mais nous on va utiliser le système standard qui suffit largement même pour un projet professionnel et pour un projet concret il n'y a absolument aucun problème donc on ne fera pas le système de filtre par rapport à ça mais on va s'occuper de récupérer tous les événements et de traiter les événements en fonction de ce qu'il se passe. 

Il est en maintenant de revenir sur la partie du code que vous manipulez, que vous avez depuis le début dans vos programmes et qu'on n'avait pas encore abordé dans le détail. 

Donc la partie des évènements c'est ceci:
```py
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```         
C'est la partie qui nous intéresse le plus concernant ces événements là. 

L'événement va d'abord être récupéré c'est-à-dire qu'on a d'abord cette fameuse fil des événements, cette file d'attente, on récupère tous les événements grâce à pygame.event.get() et comme on est dans une boucle, on le récupère dans une variable que nous allons appeler event. 

On aurait pu l'appeler tout à fait autrement mais pour des questions d'habitude et pas trop se perdre, on l'appellant event, on sait à quoi ça fait référence.  

Tout ceci se passe dans une boucle infinie "while launched:" je rappelle, qui va permettre du coup de récupérer tous les événements qui vont survenir au cours de l'exécution de notre programme.

Jusque-là une fois que nous avons ça, notre objet event possède un attribut type, et cet attribut type va permettre de connaître quel est le type de l'événement qui est arrivé, qui est survenu. 

Ces fameux types d'évènements, j'ai été les récupérer pour que vous ayez le visuel sous les yeux sur la documentation officielle. Voilà on les inventes pas, ils sont ici.
```txt
    QUIT            none
    ACTIVEEVENT     gain, state
    KEYDOWN         unicode, key, mod
    KEYUP           key, mod
    MOUSEMOTION     pos, rel, buttons
    MOUSEBUTTONUP   pos, button
    MOUSEBUTTONDOWN pos, button
    JOYAXISMOTION   joy, axis, value
    JOYBALLMOTION   joy, ball, rel
    JOYHATMOTION    joy, hat, value
    JOYBUTTONUP     joy, button
    JOYBUTTONDOWN   joy, button
    VIDEORESIZE     size, w, h
    VIDEOEXPOSE     none
    USEREVENT       code
```
Vous avez donc l'événement de type QUIT qui est un des événements disponibles et on en a beaucoup d'autres. 

Nous nous allons voir les événements liés à la redimension de la fenêtre donc VIDEORESIZE dont on va parler. Dans cette vidéo va même commencer par celui-là puis des événements liés au clavier, puis des événements liés à la souris et vous avez éventuellement JOY, tous les événements liés au joystick donc notamment lié aux manettes de jeu si ça vous intéresse. 

On le verra pas dans les vidéos aussi mais vous pouvez bien sûr vous en servir. 

On a également la possibilité de créer nos propres événements et d'avoir des événements personnalisés qu'on ne verra pas non plus parce que les événements ici en standard sont largement suffisant mais sachez que c'est possible. 

On peut travailler avec des évènements créer nous-mêmes.

Voilà pour cette partie et on va garder ça sur la main parce que ça va nous servir. 

On va donc adapter ce code là histoire de réviser ce qu'on avait précédemment sur l'affichage de texte, on va se resservir de texte ici pour travailler sur ces fameuses dimensions de la fenêtre. 

La première chose à faire par rapport au code qu'on a ici où on a rien mis de nouveau. Alors on va déjà permettre le redimensionnement de la fenêtre parce que par défaut elle ne l'est pas, elle sera par défaut à 640 par 480 sans être redimensionnables donc ici comme 2e argument pour set_mode() donc pour la création de la fenêtre, je vais lui passer pygame.RESIZABLE voilà.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)

pygame.init()
pygame.display.set_caption("Python #40 - événements")
window_surface = pygame.display.set_mode(window_resolution, pygame.RESIZABLE)
pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
Si je fait un python main.py.

    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +---------------------------------------+
    | Python #40 - évenements       - # x   |
    |                                       |
    |                                       |
    |                                       |
    |                                       |
    +---------------------------------------+
```
Voilà à partir de là je peux directement redimensionner ma fenêtre, il n'y a pas de souci donc on va garder ce code là et on va pouvoir travailler à partir de là. 

Donc ce qu'on va faire, on va charger une police de caractère et comme je n'ai pas de fichier de police au niveau de mon programme.

Alors si vous voulez récupérer ces schémas là sous forme d'imageXbox , je vous les ai mis dans un zip disponible dans la description de la vidéo. Si vous voulez les récupérer, on a déjà vu types-événements.png mais on verra plus tard touches-clavier.png pour les touches de clavier. 

Alors comme je n'ai pas de police de caractère, alors on va charger une police système donc moi comme je suis sur Windows, je vais charger la police 'arial' et si évidemment vous êtes sur GNU Linux ou Mac OS ou autre, il faudra utiliser une autre police puisque la police arial n'est pas disponible sur votre système à vous. 

Alors on va charger arial_font, et je vais faire pygame.font donc ça c'est la révision de la vidéo d'avant et ensuite .SysFont("arial", 30) de taille 30.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)

    pygame.init()
    pygame.display.set_caption("Python #40 - événements")
    window_surface = pygame.display.set_mode(window_resolution, pygame.RESIZABLE)
    
    arial_font = pygame.font.SysFont("arial", 30)
    
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Ensuite une fois que la police est chargée, on ne charge qu'une seule fois les ressources. Alors je vais créer ensuite le rendu en mettant dimensions_text = arial_font.render() donc sur arial_font, on utilise la méthode render() donc ça c'est important. 
```py
    arial_font = pygame.font.SysFont("arial", 30)
    dimensions_text = arial_font.render()
```
Alors pour cette méthode render() comment est-ce que je vais afficher ça ? je vais utiliser la méthode format et je vais afficher mon tuple window_resolution voilà. 
```py
    arial_font = pygame.font.SysFont("arial", 30)
    dimensions_text = arial_font.render("{}".format(window_resolution), ...)
```
Alors ensuite je veux un texte lissé donc avec de l'anti aliasing donc je mets True.
```py
    arial_font = pygame.font.SysFont("arial", 30)
    dimensions_text = arial_font.render("{}".format(window_resolution), True, ...)
```
Et enfin je vais lui passer une variable white_color qui sera en fait la couleur de mon texte en blanc en faisant (255, 255, 255).
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    white_color = (255, 255, 255)

    pygame.init()
    pygame.display.set_caption("Python #40 - événements")
    window_surface = pygame.display.set_mode(window_resolution, pygame.RESIZABLE)
    
    arial_font = pygame.font.SysFont("arial", 30)
    dimensions_text = arial_font.render("{}".format(window_resolution), True, white_color)
    
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
255, 255, 255 pour les 3 taux de couleur RGB. 

Voilà pour ça. 

On n'a plus qu'a blitter le tout c'est à dire ajouter le fameux texte qui a été rendu qui a été créé en fait au niveau de notre surface donc on fait.
```py
    window_surface.blit()
```
On passe le fameux texte, dimensions_text.
```py
    window_surface.blit(dimensions_text, ...)
```
Et la position à laquelle on l'affiche, et moi je vais mettre [10, 10] pour l'avoir en haut à gauche de notre fenêtre.
```py
    window_surface.blit(dimensions_text, [10, 10])
```
Voilà, on a plus qu'à afficher cela pour voir s'il n'y a pas d'erreur.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
white_color = (255, 255, 255)

pygame.init()
pygame.display.set_caption("Python #40 - événements")
window_surface = pygame.display.set_mode(window_resolution, pygame.RESIZABLE)

arial_font = pygame.font.SysFont("arial", 30)
dimensions_text = arial_font.render("{}".format(window_resolution), True, white_color)
window_surface.blit(dimensions_text, [10, 10])

pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +---------------------------------------+
    | Python #40 - évenements       - # x   |
    | (640, 480)                            |
    |                                       |
    |                                       |
    |                                       |
    +---------------------------------------+
```
Et c'est bon et donc voilà ce que nous avons (640, 480) qui correspond à ce que nous avons ici au niveau de la résolution donc pas de problème. 

Donc pour le moment si je cherche à redimensionner ma fenêtre.
```txt
    +---------------------------------+
    | Python #40 - évenements - # x   |
    | (640, 480)                      |
    +---------------------------------+
```
Donc pour le moment si je cherche à redimensionner ma fenêtre, on observe aucun changement d'accord absolument rien.

Donc ça on va s'en occuper, alors ici on va récupérer et traiter les événements liés aux re dimensions de la fenêtre qu'on a vu dans notre schéma où nous avons un événement de type VIDEORESIZE d'accord et ça c'est important. 
```txt
    QUIT            none
    ACTIVEEVENT     gain, state
    KEYDOWN         unicode, key, mod
    KEYUP           key, mod
    MOUSEMOTION     pos, rel, buttons
    MOUSEBUTTONUP   pos, button
    MOUSEBUTTONDOWN pos, button
    JOYAXISMOTION   joy, axis, value
    JOYBALLMOTION   joy, ball, rel
    JOYHATMOTION    joy, hat, value
    JOYBUTTONUP     joy, button
    JOYBUTTONDOWN   joy, button
    VIDEORESIZE     size, w, h
    VIDEOEXPOSE     none
    USEREVENT       code
```
Et sur la droite nous avons des attributs c'est-à-dire des variables qui sont liées en fonction de l'événement qui est survenu c'est à dire quand on quitte le programme donc quitté le programme je rappelle l'événement c'est tout simplement quand on utilise les contrôles de la fenêtre donc lié au système Windows Linux Mac OS. 

Quand je clique sur la croix je vais déclencher un événement QUIT de pygame et à ce moment là il se passera ça.
```txt
        ...
            launched = False
```  
En ce moment là il se passera donc ça avec mon booleen qui passera à False, et comme la boucle infinie tiens sur le fait que notre variable booléenne est à True, ça quitte en toute logique le programme. 

Donc on voit que pour VIDEORESIZE, on a notamment 2 variables qui vont nous intéresser qui sont W et H pour la largeur et pour la hauteur de la fenêtre donc ça SIZE la taille on n'en veut pas d'accord donc on veut juste c'est variable ici W et H. 

Donc on y va et on va travailler là-dessus, alors ça on va le laisser on verra certainement pas l'enlever.
```py
        if event.type == pygame.QUIT:
            launched = False
```
Ça on le laisse on l'enlève évidemment pas.  Je le mettrais au tout début pour dire voilà si on veut quitter le programme, on commencera par traiter ça et après je rajoute une condition donc un elif, un if, vous mettez absolument ce que vous voulez.

ensuite je réécris la même chose event.type.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    white_color = (255, 255, 255)

    pygame.init()
    pygame.display.set_caption("Python #40 - événements")
    window_surface = pygame.display.set_mode(window_resolution, pygame.RESIZABLE)

    arial_font = pygame.font.SysFont("arial", 30)
    dimensions_text = arial_font.render("{}".format(window_resolution), True, white_color)
    window_surface.blit(dimensions_text, [10, 10])

    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
            elif event.type == pygame.VIDEORESIZE:
```     
Donc à partir du moment où ce genre d'évènement va arriver, va se produire on rentrera dans cette condition la (elif…) et qu'est-ce qu'on nous allons faire ?

Eh bien nous allons le voir ici. 

Alors petite parenthèse, vous voyez que chaque fois que j'ai une constante QUIT, VIDEORESIZE lié à pygame, je mets toujours pygame. avant mais si vous voulez éviter de faire ça pour vous permettre de pouvoir enlever pygame. (point) et de mettre donc juste le nom de l'attribut, il suffira d'apporter les locales pour ces constantes donc il suffira de faire ça.
```py
    from pygame.locals import *
```
Alors si vous faites ça locals import *, vous n'avez plus indiqué à chaque fois pygame. (point) pour toutes les constantes comme ça lié à pygame. 

Mais bon moi par habitude je ne le mets jamais, je ne l'utiliser jamais, je préfère toujours avoir les noms les plus complet comme ça je sais à quoi ça correspond et personnellement c'est ce que je préfère. 

Après si vous voulez raccourcir les syntaxes, vous pouvez le faire sans problème. 

Donc on va garder ça et dès qu'on arrive ici.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    white_color = (255, 255, 255)

    pygame.init()
    pygame.display.set_caption("Python #40 - événements")
    window_surface = pygame.display.set_mode(window_resolution, pygame.RESIZABLE)

    arial_font = pygame.font.SysFont("arial", 30)
    dimensions_text = arial_font.render("{}".format(window_resolution), True, white_color)
    window_surface.blit(dimensions_text, [10, 10])

    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
            elif event.type == pygame.VIDEORESIZE:
            #    <------------------- ici
```        
Donc on garde ça et dès qu'on arrive ici, qu'est-ce que nous allons changer ? et bien tout simplement le texte qui est ici.
```py
    #...
    dimensions_text = arial_font.render("{}".format(window_resolution), True, white_color)
    window_surface.blit(dimensions_text, [10, 10])

    pygame.display.flip()
    #...
```
On va donc reprendre tout ça c'est quoi la partie qui nous intéresse donc le fait de recréer le rendu donc le nouveau texte (render), de le rebliter sur notre surface et bien sûr de mettre à jour l'écran (flip) sinon on ne verait pas le changement.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    white_color = (255, 255, 255)

    pygame.init()
    pygame.display.set_caption("Python #40 - événements")
    window_surface = pygame.display.set_mode(window_resolution, pygame.RESIZABLE)

    arial_font = pygame.font.SysFont("arial", 30)
    dimensions_text = arial_font.render("{}".format(window_resolution), True, white_color)
    window_surface.blit(dimensions_text, [10, 10])

    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
            elif event.type == pygame.VIDEORESIZE:
>               dimensions_text = arial_font.render("{}".format(window_resolution), True, white_color) 
>               window_surface.blit(dimensions_text, [10, 10])
>               pygame.display.flip()
```
Mais avant ça on va pas oublier d'effacer l'écran donc le meilleur moyen de l'effacer c'est de le remplir de noir et moi par défaut quand l'écran n'affiche rien il est en noir. 

Donc je vais mettre window_surface.fill() et on va lui passer une couleur noire et on va donc initialiser black_color.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    white_color = (255, 255, 255)
>   black_color = (0, 0, 0)                             

    pygame.init()
    pygame.display.set_caption("Python #40 - événements")
    window_surface = pygame.display.set_mode(window_resolution, pygame.RESIZABLE)

    arial_font = pygame.font.SysFont("arial", 30)
    dimensions_text = arial_font.render("{}".format(window_resolution), True, white_color)
    window_surface.blit(dimensions_text, [10, 10])

    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
            elif event.type == pygame.VIDEORESIZE:
>               window_surface.fill(black_color)
                dimensions_text = arial_font.render("{}".format(window_resolution), True, white_color)
                window_surface.blit(dimensions_text, [10, 10])
                pygame.display.flip()
```         
Ensuite je vais remettre le texte.
```py
    dimensions_text = arial_font.render("{}x{}".format(...), True, white_color)
```
Et là comme on l'avait indiqué, comme on le voit ici pour VIDEORESIZE, on a ces variables-là.
```txt
    VIDEORESIZE         size, w, h
```
On va y accéder depuis notre variable event depuis cet objet-là donc on va juste faire event.w pour la largeur et event.h pour avoir la hauteur.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
white_color = (255, 255, 255)
black_color = (0, 0, 0)                             

pygame.init()
pygame.display.set_caption("Python #40 - événements")
window_surface = pygame.display.set_mode(window_resolution, pygame.RESIZABLE)

arial_font = pygame.font.SysFont("arial", 30)
dimensions_text = arial_font.render("{}".format(window_resolution), True, white_color)
window_surface.blit(dimensions_text, [10, 10])

pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
       elif event.type == pygame.VIDEORESIZE:
           window_surface.fill(black_color)
           dimensions_text = arial_font.render("{}x{}".format(event.w, event.h), True, white_color)
           window_surface.blit(dimensions_text, [10, 10])
           pygame.display.flip()
```
On va garder tout pareil, on affiche tout au même endroit blit() et flip() parce qu'on aura effacé grâce au fill() l'affichage qu'on avait au départ et on a mis à jour l'écran flip().

Donc on fait ça et là on va rééxécuter notre programme et voir si ça fonctionne.
```py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +---------------------------------------+
    | Python #40 - évenements       - # x   |
    | (640, 480)                            |
    |                                       |
    |                                       |
    |                                       |
    +---------------------------------------+
```
J'ai l'interface par défaut et si je change les dimensions de ma fenêtre et que l'événement est déclenché, On voit bien que la taille change. 

Si je change la largeur, on voit que la hauteur ne bouge pas, on restera sur du 300 pixels de hauteur. Et si je ne change que la hauteur, on voit que la largeur ne bouge pas donc l'événement a bien été traité. 

On l'a traité par rapport à nos conditions, par rapport à la file d'évènements que nous avions eu donc vous voyez que c'est vraiment que la fenêtre a été redimensionnée, que ça se présente. C'est une fois que j'ai relâché la souris pour redimensionner la fenêtre que là il prend en compte l'évennement, que l'évenement est déclenché, que la valeur de W et H changes.
```py
    +---------------------------------------+
    | Python #40 - évenements       - # x   |
    | (640, 480)                            |
    |                                       |
    |                                       |
    |                                       |
    +---------------------------------------+

    +-------------------------------+
    | Python #40 - évenements - # x |
    | (400, 248)                    |
    |                               |
    |                               |
    |                               |
    +-------------------------------+
```
Voilà pour cette partie là, vous voyez c'est très simple et je voulais vous montrer ça en vidéo parce que c'est le plus simple à utiliser et ça peut être utile d'avoir besoin des dimensions de la fenêtre, ça peut pas mal servir quand on travaille dans le jeu vidéo ou autre. 

C'est bien d'avoir ces informations là sous la main. 

Maintenant on va s'occuper ce d'autres choses très importantes aussi notamment tout ce qui concerne le clavier et on terminera sur la souris donc on verra ces 2 choses-là je pense que ce sera pas mal complet avec tout ce que nous aurons vu sur cette vidéo. 

Donc je vais retirer ce qui n'est pas nécessaire, je ne veux pas travailler avec des polices de caractère enfin du texte en graphique. 

Si vous voulez continuer de travailler avec du texte en graphique pour la suite il n'y a pas de problème, ça vous permettra de réviser tout ça donc n'hésitez pas à le faire mais moi par contre je vais les enlever et on fait pareil avec l'événement (elif) dont on ne veut plus.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    white_color = (255, 255, 255)
    black_color = (0, 0, 0)                             

    pygame.init()
    pygame.display.set_caption("Python #40 - événements")
    window_surface = pygame.display.set_mode(window_resolution)
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Nous allons traiter maintenant l'événement lorsqu'on appuie sur une touche qui est KEYDOWN. KEYUP c'est l'inverse, c'est quand vous relâchez une des touches du clavier.

Donc on va voir ça il attribut qui va nous intéresser par rapport à l'événement KEYDOWN, c'est key qui va nous permettre de savoir sur quelle touche nous avons appuyé, chose qui est évidemment très importante quand on manipule une bibliothèque graphique. 

Donc on y va.
```py
            #...
            elif event.type == pygame.KEYDOWN:
```    
Et là, ce que l'on peut faire du coup, c'est que nous aurons la touche sur laquel nous avons travaillé.

Alors le problème c'est que je ne vais pas gérer tous les cas donc on va avoir besoin d'avoir des constantes, on va retrouver des constantes pour les touches du clavier que nous manipulons. 

Et pour ça, voir notre image qui est fournie dans l'archive touches-clavier.png qui encore une fois est dans la description de la vidéo. 

Vous avez ceci qui est assez long mais je vous ai tout mis.
```txt
    KeyASCII        ASCII       Common Name
    K_BACKSPACE     \b          backspace
    K_TAB           \t          tab
    K_CLEAR                     clear
    K_RETURN        \r          return
    ...
```
Aller constant vient justement aux différentes touches du clavier donc voilà le nom qui nous intéresse c'est le nom qui est ici K_.. tout en majuscules c'est important un K, un underscore et le nom. 

Donc on voit K_TAB pour la touche Tab. K_0 pour le zéro. K_g pour la touche g et cetera et cetera. 

Donc ça c'est vraiment ce qui nous intéresse le plus, et donc tout y est K_UP, K_DOWN, les touches directionnelles. Enfin voilà on retrouve vraiment tout ce qu'il nous faut. Voilà les flèches directionnelles de notre clavier.
```txt
    K_UP
    K_DOWN
    K_RIGHT
    K_LEFT
```
Voilà si ça vous intéresse tout est là donc on va utiliser les flèches directionnelles. 

On va pouvoir du coup récupérer cette touche là donc moi ce que je vais faire la danse à traiter tous les cas, les 4 cas des flèches directionnelles. 

Je vais dire que si event.key parce que je rappelle que parce que nous sommes sur cet événement là, vous voyez KEYDOWN, on a cet objet Key qui va nous intéresser. C'est cette variable qui nous intéresse.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    white_color = (255, 255, 255)
    black_color = (0, 0, 0)                             

    pygame.init()
    pygame.display.set_caption("Python #40 - événements")
    window_surface = pygame.display.set_mode(window_resolution)
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
            elif event.type == pygame.KEYDOWN:
```
On va donc event.key et le comparer ==, voir si on retrouve la constante que nous voulons, et moi ici je vais mettre pygame. parce que je n'ai pas importer les constantes via locals et je vais mettre K_UP donc si j'ai ça je vais afficher d'accord "Haut".
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    white_color = (255, 255, 255)
    black_color = (0, 0, 0)                             

    pygame.init()
    pygame.display.set_caption("Python #40 - événements")
    window_surface = pygame.display.set_mode(window_resolution)
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_UP:
                    print("Haut")
```
Ensuite on va tester si flèche vers le bas et afficher "Bas".
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    white_color = (255, 255, 255)
    black_color = (0, 0, 0)                             

    pygame.init()
    pygame.display.set_caption("Python #40 - événements")
    window_surface = pygame.display.set_mode(window_resolution)
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_UP:
                    print("Haut")
                elif event.key == pygame.K_DOWN:
                    print("Bas")
```
Et on va mettre pour "Gauche" et "Droite" et dans le cas où on a une autre touche.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
white_color = (255, 255, 255)
black_color = (0, 0, 0)                             

pygame.init()
pygame.display.set_caption("Python #40 - événements")
window_surface = pygame.display.set_mode(window_resolution)
pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
       elif event.type == pygame.KEYDOWN:
           if event.key == pygame.K_UP:
               print("Haut")
           elif event.key == pygame.K_DOWN:
               print("Bas")
           elif event.key == pygame.K_LEFT:
               print("Gauche")
           elif event.key == pygame.K_RIGHT:
               print("Droite")
           else:
               print("Autre touche...")
```
Donc là je ne fait qu'afficher dans le terminal la touche sur lequel on a appuyé. 

Sur un programme graphique si vous voulez déplacer une surface, déplacer un cube ou autre, une image comme vous l'avez vu précédemment, vous allez pouvoir adapter ce code sans problème. 

Il suffira ici de gérer le déplacement de votre image ou de votre surface en modifiant ses coordonnées par exemple en augmentant de un à la position X ou en Y en fonction de l'accord donné que vous voulez modifier et du déplacement que vous voulez simuler d'accord c'est exactement comme ça que ça fonctionne. 

Voilà normalement je n'ai rien oublié, on va voir ça.
```py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +---------------------------------------+
    | Python #40 - évenements       - # x   |
    |                                       |
    |                                       |
    |                                       |
    |                                       |
    +---------------------------------------+
```
Donc on va voir si j'ai rien oublié que tout est bon. 

Je suis sur mon interface, j'appuie sur n'importe quelle touche et vous allez voir ce qui se passe sur le terminal.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    Autre touche...
```
Donc il met Autre touche… en admettant par exemple que je fasse azerty, barre espace, shift et cetera.

Et dès que j'appuie sur une flèche directionnelle, je n'ai pas besoin de venir sur quoi j'appuie parce que vous voyez dans le terminal sur quoi j'ai appuyé d'accord.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    Autre touche...
    Haut
    Bas
    Gauche
    Droite
```
Voilà je pense que vous avez compris le principe et c'est évidemment très réactif comme ça va très vite. 

Voilà on peut gérer tout ça.

Voilà ça va très vite et on peut gérer tout ça. 

Okay pour cette partie ici, c'est très simple et c'est toujours pareil, on vérifie le type de l'événement produit donc c'est tout ça.
```txt
    QUIT            none
    ACTIVEEVENT     gain, state
    KEYDOWN         unicode, key, mod
    KEYUP           key, mod
    MOUSEMOTION     pos, rel, buttons
    MOUSEBUTTONUP   pos, button
    MOUSEBUTTONDOWN pos, button
    JOYAXISMOTION   joy, axis, value
    JOYBALLMOTION   joy, ball, rel
    JOYHATMOTION    joy, hat, value
    JOYBUTTONUP     joy, button
    JOYBUTTONDOWN   joy, button
    VIDEORESIZE     size, w, h
    VIDEOEXPOSE     none
    USEREVENT       code
```
Et en fonction du type on a accès à pas mal d'autres variables qui nous permette du coup de vérifier ce qui est utile par rapport à l'événement qui s'est produit et ensuite de faire en fonction tout ce qui vous intéresse. 

Pour VIDEORESIZE, on peut s'intéresser aux dimensions. 

Pour KEYDOWN, par rapport à la touche key, j'appuie où la touche relâchée. 

Et nous allons évidemment terminer avec la souris pour finir cette vidéo là donc l'événement de type MOUSEMOTION non et pourquoi je m'intéresse à celui-là ? C'est tout simplement le déplacement du curseur de la souris que vous voyez à l'écran d'accord ce n'est pas le fait de cliquer sur un des boutons ou bien de relâcher un des boutons donc K_DOWN pour relâcher un des boutons mais MOUSEMOTION c'est vraiment la position du curseur à l'écran. 

En tout cas pas l'écran du PC complet mais rappelez-vous l'écran de votre interface c'est-à-dire l'écran de la fenêtre de votre programme, c'est bien ça qu'il faut retenir 

Donc on va modifier en fonction je pense que là vous avez compris le principe, vous voyez que c'est très facile à prendre en main au niveau de pygame.

On fait MOUSEMOTION :
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    white_color = (255, 255, 255)
    black_color = (0, 0, 0)                             

    pygame.init()
    pygame.display.set_caption("Python #40 - événements")
    window_surface = pygame.display.set_mode(window_resolution)
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
            elif event.type == pygame.MOUSEMOTION:
```
Et à partir de là vous avez compris que ça vous donne accès et que ça à d'autres variables.

nous ce qui nous intéresse ici c'est pos donc pour pos, je ne vais pas me embêter je vais juste faire ceci avec la méthode format pour faire vraiment au plus simple. 
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
white_color = (255, 255, 255)
black_color = (0, 0, 0)                             

pygame.init()
pygame.display.set_caption("Python #40 - événements")
window_surface = pygame.display.set_mode(window_resolution)
pygame.display.flip()

launched = True
while launched:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            launched = False
        elif event.type == pygame.MOUSEMOTION:
            print("{}".format(event.pos))
```             
Je démarre mon programme.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    (276, 405)
    (276, 404)
    (276, 404)
    (274, 403)
    (271, 403)
    (266, 401)
    ...
    
    +---------------------------------------+
    | Python #40 - évenements       - # x   |
    |                                       |
    |                                       |
    |                                       |
    |                                       |
    +---------------------------------------+
```
Je démarre mon programme et là vous voyez au moindre déplacement que je fais sur mon interface. 

Donc si je clique encore une fois ma fenêtre vous voyez qu'il ne se passe rien, normal parce qu'on ne parle pas de la position sur l'écran de votre ordinateur, ça n'a rien à voir, on parle bien de votre programme, et du coup ça change en fonction. 

Voilà ça vous met les coordonnées de la position de votre souris par rapport à votre interface x donc évidemment si je vais au point le plus en haut en gauche de ma fenêtre, j'aurai normalement les coordonnées si on arrive à les atteindre. 
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    (0, 0)
```
C'est bon, j'ai (0, 0) et je vais aller en bas à droite et plus je serai au 640 par 480 qui n'est pas facile à atteindre. le dernier pixel n'est pas facile à atteindre mais peu importe en tout cas vous avez compris le principe. 

Voyez que c'est traité pour le cours en temps réel dès qu'il y a eu un déplacement, dès que je fais ne serait-ce qu'un seul pixel de déplacement de ma souris, ça déclenche un événement pygame de ma souris qui s'appelle MOUSEMOTION et comme on traite cet événement pour afficher les coordonnées du curseur au moment où il y a eu le déplacement Eh bien on récupère ses coordonnées. 

Donc évidemment inutile de vous dire que dans son programme graphique ou dans un jeu vidéo, c'est absolument nécessaire. 

On peut penser par exemple au jeu FPS, au jeu de tire, très bien ça permet de savoir si on a touché une cible ou non donc c'est absolument nécessaire, absolument essentiel de maîtriser ce genre de choses avec une bibliothèque graphique en 2D. 

Voilà je crois qu'on a fait le tour de ce que je voulais vous montrer, évidemment il y a aussi beaucoup d'autres choses, on peut vérifier. Il y a plein de méthodes aussi qu'on peut vérifier, récupérer des nombres, vérifier si on apprécié une touche ou autre mais bon ce n'est pas forcément utile. 

Ici on a déjà vu pas mal je ne vais pas vous montrer tous les évènements ce serait beaucoup trop long mais en tout cas je pense que vous avez compris un petit peu le principe par rapport à tout ça. 

Voilà je pense que vous pouvez commencer à utiliser ces différents traitements d'évènements, envoyer qu'il y a plusieurs choses que vous allez pouvoir faire. 

Alors pour le joystick, si vous voulez vraiment travailler avec le joystick, regarder dans la documentation de pygame. C'est tout aussi simple, c'est vraiment pas plus compliqué, c'est juste qu'il y a un peu plus de choses à voir ton compte pour les joystick par rapport aux coordonnées des sticks analogiques, des touches et ce genre de chose. 

Donc il y a plusieurs valeurs différentes, les AXIS.. tout ça mais ce n'est pas plus compliqué, il y a juste plus de choses, évidemment plus d'informations sur un joystick, une manette de jeu par rapport à une simple souris qui aurait seulement quelques touches ou une des coordonnées. 

Donc au final, voilà c'est vraiment la même manipulation donc n'hésitez pas à voir tout ça un petit peu si vous voulez pour manipuler toutes ces choses ici donc on a les boutons, les sticks analogiques, tout ça donc tout peut être géré via ces différents types d'évènements. 

Et vous pouvez les tester pour voir un petit peu comment ça se déclenche et comment traiter ces différents événements. 

Mais je pense que j'en resterai là je pense que j'aurais, encore une fois dernier rappel au sujet de ces 2 images disponible dans une archive dans la description de la vidéo, ne vous amusez pas à recopier tout à la main et vous pouvez les garder comme ça sous le coude. 

Comme ça lorsque vous allez programmer avec pygame, regarderai ça à côté de vous et dés que vous avez besoin de chercher une touche, pas besoin d'apprendre tous les noms par coeur et moi il y en a plein que je connais évidemment pas. 

Il y en a qui sont très logiques et d'autres non et ce soit en plus les constantes que l'on retrouve avec la SDL même si quand on a l'habitude de manipuler on s'en souvient mais ne vous amusez pas à apprendre tout cela par cœur, ça n'a bien sûr aucun intérêt donc gardez ça sur la main ce sera bien pratique. 

Je vais vous laisser avec ça. 

J'espère que cette vidéo vous a plu, c'était quand même très très attendu, c'était une grosse grosse partie intéressante et maintenant vous savez manipuler des événements donc on va s'en resservir. 

On continue encore un petit peu, il nous reste encore à voir quelques petites choses avec pygame mais plus grand-chose. 

On va regarder comment mesurer le temps parce qu'on va voir que le temps dans une application graphique, c'est quelque chose de très important et qu'il faut également mettre en œuvre. 

Et après je pense qu'on terminera tranquillement avec un petit bonus en vous montrant comment jouer des sons, en vous montrant comment manipuler des sons et des flux audio sur vos programmes. 

Ça peut être sympa de mettre un petit peu de musique ou des petits effets sur vos applications graphiques ou vos jeux vidéo et puis je crois qu'on aura terminé le cours, on terminera avec ça. 

Je ferai également comme pour mes autres formations, une vidéo de conclusion pour résumer un petit peu tout ce que nous avons vu, je vais vous dire un petit peu tout ce que vous pouvez faire maintenant que vous avez fini ce cours et voilà. 

Et voilà je vous dis à bientôt pour la suite des cours pygame parce qu'il nous en reste encore un petit peu et pas des moindres. 

Et puis on se retrouve très bientôt pour la prochaine séance. 

Ciao tout le monde