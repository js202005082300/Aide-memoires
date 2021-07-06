# [36. Dessiner sur une Surface](https://www.youtube.com/watch?v=Bj-SWrrUtS0)

Bonjour bienvenue pour cette séance 36 en python. 

Maintenant qu'on a vu comment créer votre première fenêtre tout simplement, créer notre première surface pour être plus exact avec pygame, on va regarder comment dessiner sur cette surface. 

Comment produire du contenu simplement sur votre écran et je vous avais dit qu'on allait voir plusieurs méthodes, plusieurs manières en fait de dessiner sur cette petite surface que nous avons créé avec pygame. 

On va commencer d'abord par revenir sur cette dernière avec le code qu'on avait précédemment qu'on a légèrement modifié ok au niveau d'une nommage parce qu'ici on parle bien d'une surface qui concerne la fenêtre que nous allons gérer au niveau de notre programme. Et j'ai appelé ici window_resolution pour les coordonnées qui représente la dimension de notre fenêtre tout simplement histoire d'avoir des noms un peu plus explicite et pas des noms quelconques.
```py
    #coding:utf-8
    import pygame
    
    pygame.init()
    
    window_resolution = (640, 480)
    pygame.display.set_caption("Python #36")
    
    window_surface = pygame.display.set_mode(window_resolution)
    
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```       
À partir de là, une fois que nous avons ça, on va déjà regarder parce qu'on a créé une surface … je rappelle que set_mode() va retourner une surface stocké dans la variable window_surface.

Et la surface est un objet donc pygame, ça représentait tout simplement avec un S majuscule d'accord c'est un objet parce que ce n'est pas une simple fonction.
```py
    window_surface = pygame.display.set_mode(window_resolution) #Surface
```
Il s'agit véritablement d'un objet et comme vous l'avez appris, un objet possède des attributs et permet d'utiliser pas mal de méthodes, justement parmi ces méthodes au niveau des surfaces nous avons la possibilité de remplir la surface d'une certaine couleur.

Déjà nous allons voir comment définir une couleur en python, on va passer par une simple variable qui manipulera des tuple comme on avait fait ici pour la résolution, voyez on passe un tuple ici. 
```py
	window_resolution = (640, 480)
```
Je vous avais également dit qu'on peut travailler avec des listes.
```py
	window_resolution = [640, 480]
```
Python est pas mal flexible et pygame prévoit l'usage de l'un de l'autre, vous allez pouvoir faire pareil. 

Alors on va tout simplement créer une couleur, on va l'appeler blue_color = () je vais lui passer 3 valeurs. Une première valeur qui correspondra au taux de rouge (R, ) que vous voulez pour la couleur. On a ensuite le G, green pour le taux de vert (R, G, ) et on aura B pour Blue donc le taux de bleu (R, G, B).
```py
    #coding:utf-8
    import pygame
    
    pygame.init()
    
    window_resolution = (640, 480)
    blue_color = (R, G, B)
    
    pygame.display.set_caption("Python #36")
    
    window_surface = pygame.display.set_mode(window_resolution)
    
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Ça ce sont 3 valeurs super importantes qui vont de 0 à 255. 

Si vous mettez tout à 0, vous obtiendrez la couleur noir d'accord, ça veut dire qu'il n'y a pas de couleur. 

Si vous mettez tout à 255, vous avez à ce moment-là toutes les couleurs primaires au maximum et en obtiendra du blanc. 

Bien évidemment pour vérifier ces choses-là, il n'y a pas forcément besoin de connaître les codes par cœur d'autant qu'il y en a tout un tas de combinaisons possibles. 

Vous pouvez passer par n'importe quel logiciel d'image, de graphisme pour obtenir ces valeurs là donc nous on va tout simplement essayer de prendre un code pour une couleur un peu bleu, bleu clair, ce genre de chose. 

Vous recherchez n'importe quel logiciel pour le graphisme, vous utilisez une palette de couleurs tout simplement qu'elle qu'elle soit et normalement votre logiciel doit vous afficher ces données là. Alors on choisit une couleur, celle que l'on veut. On peut retrouver une couleur en code hexadécimal que les gens qui font du web avec CSS connaissent bien. vous connaissais bien ce principe là de récupérer le code hexadécimal mais le code hexadécimal peut s'écrire si on sépare chacune des parties pour chaque taux donc le taux de rouge soit le R, soit le V pour le vert et le B pour le bleu. Si on retrouve nos valeurs grâce à ce système là on peut les noter et les retranscrire.

Un exemple avec un maximum de bleu, pas mal de vert et on a par contre moins de rouge que le reste. On obtient ainsi un bleu un petit peu clair.
```py
    #coding:utf-8
    import pygame
    
    pygame.init()
    
    window_resolution = (640, 480)
    blue_color = (89, 152, 255)
    
    pygame.display.set_caption("Python #36")
    
    window_surface = pygame.display.set_mode(window_resolution)
    
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Une fois qu'on a ça et qu'on a en tout cas récupérer ce code de couleur, nous allons pouvoir remplir la surface de cette couleur voilà et pour le faire nous allons travailler sur cette dernière window_surface parce que c'est cette surface là. 

On va lui définir un remplissage avec la méthode fill(). La méthode fill() prend comme argument ou en tout cas c'est l'argument qui va nous intéresser, c'est l'argument de la couleur que nous allons lui passer donc on va tout simplement lui passer notre variable blue_color ici.
```py
#coding:utf-8
import pygame

pygame.init()

window_resolution = (640, 480)
blue_color = (89, 152, 255)

pygame.display.set_caption("Python #36")

window_surface = pygame.display.set_mode(window_resolution)
window_surface.fill(blue_color)

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
Alors là on pourrait s'attendre à modifier la couleur de la surface et l'afficher sauf … et on en avait parlé précédemment lorsqu'on a parlé de la mémoire tampon à tout ce genre de choses. Quand nous allons indiquer le set_mode() comme je vous l'avais expliqué on va en réalité créer notre surface, créer notre fenêtre. 

Cette surface comme on l'avait vu précédemment et on peut s'amuser de toutes façons à exécuter le programme, on obtiendra une surface qui est tout en noir par défaut, elle est remplie de noir donc c'est pas forcément ce qu'on attendait parce que nous on voulait … et on a rempli fill() normalement avec une surface en bleu.
```py
    > python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +-----------------------------------+
    |Pygame #36                 - # x   |
    |                                   |
    |           Noir                    |
    |                                   |
    +-----------------------------------+
```
Donc pour opérer ce changement il va falloir mettre à jour, rafraîchir en fait la surface avec les changements qui ont opéré. 

Alors pour le faire, ce n'est pas la surface qui doit être mis à jour mais en réalité c'est l'affichage d'accord on parle de l'affichage. 

Et l'affichage vous savez ce qui le gère maintenant, c'est le module display donc on met pygame.display et nous allons utiliser flip().

Flip() est utilisé lorsque vous voulez mettre à jour, apporter un changement au niveau de l'affichage donc nous on va l'utiliser qu'une seule fois ici parce que nous allons faire toutes les choses que nous voulons. Et à la fin une fois que vous avez modifié, que vous avez mis toutes les configurations, tout le remplissage, les couleurs et cetera qu'on aura dessiné à l'écran, on affiche vraiment en faisant un update flip() rafraîchissement de la surface je suis là. 
```py
#coding:utf-8
import pygame

pygame.init()

window_resolution = (640, 480)
blue_color = (89, 152, 255)

pygame.display.set_caption("Python #36")

window_surface = pygame.display.set_mode(window_resolution)
window_surface.fill(blue_color)

pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    > python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +-----------------------------------+
    |Pygame #36                 - # x   |
    |                                   |
    |           Bleu                    |
    |                                   |
    +-----------------------------------+
```
Si je ré exécute, le changement s'est bien opéré. 

On a bien la surface qui a été remplie, on a vu un remplissage de la surface avec cette couleur bleu. 

Donc plutôt pratique et donc ça c'est une première chose que je voulais vous montrer même si ça ne concerne pas directement le fait de dessiner au niveau de notre surface mais ça concerne le remplissage de la surface elle-même. 

Maintenant que ça c'est vu, on va voir maintenant comment dessiner sur notre surface avec différentes choses. 

La chose la plus simple, la plus sommaire à dessiner, c'est un point. 

On va voir comment dessiner un point, alors on n'a pas de fonction autre méthode qui permet de dessiner un point mais on en a par contre pour créer des lignes. 

Pour créer des lignes, on va travailler avec un autre module, un nouveau module que nous n'avons pas encore vu qui est le module draw pour dessin. 

Et ce module permettant d'utiliser une fonction pour créer des lignes, nous allons à partir de la création d'une ligne, pouvoir créer un point. Alors on n'aurait pas forcément en affichage mais je veux quand même vous montrer comment faire pour éviter comme le demande parce qu'il n'y a pas de fonction toute faite pour faire des points. 

Alors on va garder notre code il garde la surface en bleu après tout, on n'est pas mal comme ça et ici nous allons créer notre partie. Alors on écrit pygame.draw avec draw qui est le module à utiliser. Et on va décider quoi ? non pas une ligne mais un point et on va utiliser line() pour le faire.
```py
    #coding:utf-8
    import pygame

    pygame.init()

    window_resolution = (640, 480)
    blue_color = (89, 152, 255)

    pygame.display.set_caption("Python #36")

    window_surface = pygame.display.set_mode(window_resolution)
    window_surface.fill(blue_color)
    
    pygame.draw.line()#                      <---------------

    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Cette fonction line() prends plusieurs choses en paramètre. Le premier et vous allez voir que ça rejoint beaucoup de cas d'usage de ces différentes fonctions pour dessiner, elle va prendre en premier lieu la surface sur lequel nous voulons desssiner donc nous c'est celle de notre fenêtre donc on met ça.
```py
    #coding:utf-8
    import pygame

    pygame.init()

    window_resolution = (640, 480)
    blue_color = (89, 152, 255)

    pygame.display.set_caption("Python #36")

    window_surface = pygame.display.set_mode(window_resolution)
    window_surface.fill(blue_color)
    
    pygame.draw.line(window_surface, ) #       <---------------

    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Ensuite ça va prendre une couleur, la couleur tout simplement de ce que nous voulons créé ici, alors on va peut-être pas refaire du bleu sinon on verra absolument rien. On va par contre créer une couleur pour le noir dans la variable black_color qui n'est tout simplement pas de couleur donc ce n'est que du 0.
```py
    #coding:utf-8
    import pygame

    pygame.init()

    window_resolution = (640, 480)
    blue_color = (89, 152, 255)
    black_color = (0, 0, 0) #                 <----------------

    pygame.display.set_caption("Python #36")

    window_surface = pygame.display.set_mode(window_resolution)
    window_surface.fill(blue_color)
    
    pygame.draw.line(window_surface, black_color, ) #       <---------------

    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
On met ça comme ça en 2e paramètre c'est donc très simple, vraiment très très simple, et ensuite nous allons avoir si vous voulez la position de départ qui va permettre en fait de prendre différents éléments prend notre ligne c'est-à-dire que si nous travaillons sur une ligne, il va nous falloir les coordonnées du point de départ d'accord et il faudrait les coordonnées du point d'arrivée. 

Je peux résumer ici sur un petit schéma rapidement, imaginons d'accord un tracé. On est d'accord qu'il va nous falloir du coup besoin des coordonnées (x, y) en haut, et on aura besoin des coordonnées (x, y) en bas. 
```txt
    (x, y)
        \
         \
          \
           \
            \
             \
              \
               \
                \
                 \
                  \ 
                  (x, y)
```          
En ayant ces 2 là, le point de départ et le point d'arrivée, le programme va être capable de calculer le tracé entre les 2 et produire une ligne. 

Donc si vous voulez obtenir un seul point, il faudra que le X et le Y du point de départ soit évidemment le même que le point d'arrivée, et dans ce cas-là vous n'aurez que des coordonnées identiques et un point au lieu d'avoir une ligne. 

Donc ça c'est une première chose à voir. 

Alors comment se note ces informations parce qu'on avait dit que pour les couleurs, pour la résolution, elle m'a dit qu'on travaillait avec des tuples ou bien ont travaillait par des listes. Et bien ça tombe bien pour la position de départ et la position de fin, ça fonctionnera de la même manière, on peut utiliser des tuples ou utiliser une liste donc nous on va faire une liste parce que ce sera beaucoup plus lisible dans une fonction. 

Comme la fonction utilise déjà des parenthèses, personnellement mais après c'est vous qui verrez je préfère utiliser des listes représentées par des crochets parce que c'est beaucoup plus facile à lire. 

Donc on a la position de départ [] et la position d'arrivée [].
```py
    #coding:utf-8
    import pygame

    pygame.init()

    window_resolution = (640, 480)
    blue_color = (89, 152, 255)
    black_color = (0, 0, 0) #             <----------------

    pygame.display.set_caption("Python #36")

    window_surface = pygame.display.set_mode(window_resolution)
    window_surface.fill(blue_color)
    
    pygame.draw.line(window_surface, black_color, [], []) #      <---------------

    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Et on s'arrêtera là pour commencer, alors si je veux un point je devrais mettre la même chose donc je vais dire que en x = 10, y = 10. Et pareil pour le point d'arrivée.
```py
    #coding:utf-8
    import pygame

    pygame.init()

    window_resolution = (640, 480)
    blue_color = (89, 152, 255)
    black_color = (0, 0, 0) #                <----------------

    pygame.display.set_caption("Python #36")

    window_surface = pygame.display.set_mode(window_resolution)
    window_surface.fill(blue_color)
    
    pygame.draw.line(window_surface, black_color, [10, 10], [10, 10])       <---------------

    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```          
Alors comment fonctionnent les coordonnées au niveau de la surface ? … je vais faire un petit rappel parce que ça permet de bien voir les choses. Prenons notre surface avec un grand rectangle, vous allez avoir grosso modo le point tout en haut à gauche avec x=0 et y=0. 

Plus vous allez descendre et Y va augmenter d'accord, et plus vous allez passer sur la droite plus le X va augmenter.
```txt
    (x, y)                      (x, y)  ---------------------------------->
        \                       +-------------------------------------------+
         \                   |  |                                           |
          \                  |  |                                           |
           \                 |  |                                           |
            \                |  |                                           |
             \               |  |                                           |
              \              |  |                                           |
               \             |  |                                           |
                \            V  |                                           |
                 \              +-------------------------------------------+
                  \ 
                  (x, y)
```
Donc évidemment le point en bas à droite et le X maximum et le Y maximale c'est notre surface donc c'est ça qu'il faut comprendre.

Donc si je dis en 10 10, on va décaler X de 10 pixels et on va décaler Y de 10 pixels donc on va commencer en réalité en haut à gauche et avoir un point décalé de 10 pixels. 

Voilà coordonnées de départ [10, 10], coordonnées d'arrivée [10, 10] et comme elles sont les mêmes, on aura pas de ligne mais un point malgré l'utilisation de line().

Alors si j'exécute, vous n'allez pas voir grand chose au niveau affichage.
```py
#coding:utf-8
import pygame

pygame.init()

window_resolution = (640, 480)
blue_color = (89, 152, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #36")

window_surface = pygame.display.set_mode(window_resolution)
window_surface.fill(blue_color)

pygame.draw.line(window_surface, black_color, [10, 10], [10, 10])

pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    > python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +-----------------------------------+
    |Pygame #36                 - # x   |
    |  .                                |
    |                                   |
    |                                   |
    +-----------------------------------+
```
Voilà vous ne devez pas avoir grand chose à moins de regarder proche avec une loupe, mais en fait envoie un petit point noir en haut à gauche tout riquiqui, tout petit mais qui est bien affiché. On a bien un point. 

On va directement passer à une ligne, ce sera évidemment beaucoup plus facile pour vous, on va mettre par exemple pour le point d'arrivée [100, 100] et on va exécuter ça.
```py
#coding:utf-8
import pygame

pygame.init()

window_resolution = (640, 480)
blue_color = (89, 152, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #36")

window_surface = pygame.display.set_mode(window_resolution)
window_surface.fill(blue_color)

pygame.draw.line(window_surface, black_color, [10, 10], [100, 100])

pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    > python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +-----------------------------------+
    |Pygame #36                 - # x   |
    |  \                                |
    |   \                               |
    |    \                              |
    +-----------------------------------+
```
Voilà là on s'en rend bien mieux compte, on arrive bien à voir cette ligne. 

Nous avons tracé cette ligne, nous avons commencé à dessiner quelque chose sur notre surface donc c'est très simple, on a les coordonnées de départ, les coordonnées d'arrivée, ce sont des mathématiques très élémentaires. Il n'y a rien de compliqué même si vous avez toujours été très mauvais en maths, ça vous posera aucun souci au niveau compréhension. 

Voilà pour tracer une ligne, très simple, pas compliqué à comprendre. 

Maintenant nous allons passer à une autre forme de tracé quel notamment le tracé d'un rectangle, alors le rectangle en plus d'être une forme que nous pouvons créer avec une fonction via pygame, c'est également un objet qui est très représentatif et qui va servir dans énormément de choses en 2D. 

L'avantage de tout ce que je vous montre ici, l'histoire d'un rectangle de surface ou autre, ce sont des notions qui sont propres à pygame mais qui sont propres à la 2D de manière générale c'est-à-dire que vous verrez si vous faites de la SDL, de la SFML, que vous utilisez lib GDX ou tout un tas d'autres bibliothèques quel que soit le langage pour manipuler du graphisme 2D, vous retrouverez un petit peu toujours la même chose. 

Vous irez manipuler des surfaces des textures voir charger des images, vous allez travailler dans des rectangles essai rectangle via des coordonnées permettront de positionner les choses, de gérer les collisions, de gérer des superpositions d'images pour travailler justement avec ce principe de collision qui est très important en 2D. 

Vous allez au final et ça va être un peu long à apprendre la première fois, et après pour étudier d'autres bibliothèques ou d'autres langages, vous avez forcément aller beaucoup plus vite parce que vous connaîtrez déjà les principes qui se cachent derrière, que ce soit les principes de surface. En fait une surface qui permet après de pouvoir dessiner dessus, de produire quelque chose dessus, et après de l'afficher. 

Alors qu'une surface toute seule ce n'est pas grand-chose, il faut vraiment dessiner dessus, c'est encore une fois l'exemple que je prenais du tableau noir sur lequel nous allons dessiner et faire des affichages, charger des images pour évidemment avoir quelque chose de visible à l'écran. 

Donc on va créer un rectangle. 

On va d'abord vers la line() qui est ici.
```py
    pygame.draw.line(window_surface, black_color, [10, 10], [100, 100])
    --> pygame.draw
```
C'est pygame.draw.rect() tout en minuscule, toujours pareil.

Ainsi on va prendre des paramètres un petit peu particulier comme vous allez le voir, le premier c'est toujours la surface, ça ça ne change pas.
```py
    pygame.draw.rect(window_surface, )
```
On dit simplement sur quoi on peut dessiner donc notre tableau, on aurait pu appeler ça le tableau au lieu de  window_surface. 

Ensuite la couleur, laquelle nous voulons dessiner donc nous on va garder le noir, ce sera comme ça assez visible. 
```py
    pygame.draw.rect(window_surface, black_color, )
```
Et ensuite nous allons pouvoir spécifiez le rectangle d'accord le rectangle de représentation, et ce rectangle ce n'est pas n'importe quoi c'est un objet. 

Nous avons avec pygame, nous avons l'objet Surface mais nous avons aussi un objet Rect. Cet objet Rect va prendre plusieurs informations comme nous allons par exemple ici créer un constructeur comme n'importe quel objet en python et il va prendre plusieurs informations.
```py
    # Surface, Rect
    # Rect()
```
En premier il va prendre une information qui va donner le décalage sur la gauche par rapport au 0 de X et Y comme on l'a vu sur le schéma donc ça revient à donner les coordonnées X et Y du point le plus en haut à gauche de votre rectangle donc si vous voulez dessiner un rectangle quelconque … en fait vous avez votre surface et le décalage left va être présenté comme ça.
```txt
     +-------------------------------------------+
     |       |                                   |
     |       V                                   |
     |------>+---------------+                   |
     |       |               |                   |
     |       |               |                   |
     |       |               |                   |
     |       +---------------+                   |
     |                                           |
     +-------------------------------------------+
```
C'est le décalage que nous avons entre le bord gauche et le coin supérieur gauche de notre rectangle, tandis que le décalage Y c'est ce que nous avons entre le bord supérieur et le coin supérieur gauche de notre rectangle.

Entre ici et ici, donc on va avoir ces 2 informations là à renseigner soit left et top.
```py
    # Surface, Rect
    # Rect(left, top, )
```
Donc le décalage par rapport à la gauche et au haut. Ensuite nous avons la largeur du rectangle et la hauteur du rectangle.
```py
    # Surface, Rect
    # Rect(left, top, width, height)
```
Avec ces 4 informations, on est capable de tracer un rectangle. 

Alors soit vous pouvez et ça c'est vous qui voyez, directement appeler le constructeur du rectangle en faisant pygame.Rect avec une majuscule cette fois donc on crée un objet Rect et vous passez aussi les informations au constructeur dans pygame.Rect().
```py
    pygame.draw.rect(window_surface, black_color, pygame.Rect())
```
Mais comme vous voyez que ça rajoute plein de parenthèses partout et que c'est plein de source d'erreur, vous pouvez aussi vous amuser à le créer avant en mettant par exemple rect_form alors je n'ai pas spécialement beaucoup d'idées pour les noms. 
```py
    rect_form = pygame.Rect()
    pygame.draw.rect(window_surface, black_color, )
```
Alors on va mettre qu'il va être décalé de 10 vers la gauche et décalé de 10 vers le bas, on veut un rectangle qui fait 150 pixels de largeur et qui fait 65 pixels de hauteur admettons et on n'a plus qu'a lui passer le rectangle tout simplement.
```py
    rect_form = pygame.Rect(10, 10, 150, 65)
    pygame.draw.rect(window_surface, black_color, rect_form)
```
```py
#coding:utf-8
import pygame

# Surface, Rect
# Rect(left, top, width, height)

pygame.init()

window_resolution = (640, 480)
blue_color = (89, 152, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #36")

window_surface = pygame.display.set_mode(window_resolution)
window_surface.fill(blue_color)

rect_form = pygame.Rect(10, 10, 150, 65)
pygame.draw.rect(window_surface, black_color, rect_form)

pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
On lui passe le rectangle tout simplement, c'est un objet, on lui passe un objet ici de classe Rect au niveau ici de la fonction pour dessiner un rectangle draw.Rect() ça c'est important. 

Et voilà, là on a les informations on va dire minimum. 

On a un autre argument dans la fonction pour dessiner un rectangle mais on va le voir juste après.

On va déjà voir ici si je n'ai pas fait d'erreur pour exécuter le programme.
```py
    > python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +-----------------------------------+
    |Pygame #36                 - # x   |
    |  +------+                         |
    |  |      |                         |
    |  +------+                         |
    |                                   |
    +-----------------------------------+
```
Donc voilà ne semble qui comme vous le voyez est rempli, automatiquement remplie de la couleur choisie. 

Si on veut simplement un rectangle vide c'est-à-dire un rectangle qui n'a pas de remplissage, vous allez pouvoir passer une épaisseur à ce rectangle au tracé de ce rectangle donc il fera juste l'entourage avec un dernier argument. 

Arguments que nous avions également pour la ligne, line(), je ne l'ai pas montré parce que ça parait bizarre de dire une épaisseur de trait. Si vous allez faire ça vous allez voir que ça va décaler l'épaisseur vers la droite. 

Donc pour line() que nous avons vu tout à l'heure, vous pouvez également rajouter une largeur qui correspondra à l'épaisseur du trait si vous voulez donc là on va passer un 4e argument et on va mettre par exemple 5.
```py
#coding:utf-8
import pygame

# Surface, Rect
# Rect(left, top, width, height)

pygame.init()

window_resolution = (640, 480)
blue_color = (89, 152, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #36")

window_surface = pygame.display.set_mode(window_resolution)
window_surface.fill(blue_color)

rect_form = pygame.Rect(10, 10, 150, 65)
pygame.draw.rect(window_surface, black_color, rect_form, 5)

pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    > python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +-----------------------------------+
    |Pygame #36                 - # x   |
    |  +======+                         |
    |  ||     ||                        |
    |  +======+                         |
    |                                   |
    +-----------------------------------+
```
Une fois qu'on a fait exécuter notre programme voilà ce que nous obtenons donc une bordure de 5 pixels bien que ça ne soit pas vraiment une bordure voilà ça fait partie du rectangle qui fait 5 pixels de épaisseur, et surtout on peut constater que le rectangle n'a pas été rempli. 

Si vous ne passez pas cet élément qui n'est pas obligatoire … pour autant tous les autres paramètres sont obligatoires mais le paramètre de l'épaisseur comme pour line() n'est pas obligatoire, vous avez vu qu'il était optionnel mais si vous ne le pensez pas il y aura un remplissage sinon il n'y en aura pas. 

Voilà ce sont 2 choses à bien distinguer au niveau de cette fonction là. 

Ça c'est à connaître si vous avez compris le principe du rectangle d'accord que nous créons ici une forme rectangulaire avec différentes informations Rect(10, 10, 150, 65), et bien ce rectangle là, cet objet Rect() que l'on retrouve dans pygame va pouvoir être utilisé dans énormément d'autres choses.

C'est vraiment à connaître donc il faut absolument absolument comprendre cet objet Rect(), savoir comment il fonctionne. 

Il faut comprendre l'objet Surface (créer avec set_mode()) parce que c'est lui qui était à la base de tout mais il faut également cet objet Rect parce que c'est lui qui va nous permettre de manipuler tout ce que nous allons dessiner, tout ce que nous allons afficher donc si vous n'avez pas compris ça vous allez galérer pour la suite. Très important. 

Voilà pour la création du rectangle. 

Donc logiquement ce n'est pas très compliqué, une fois vraiment qu'on a compris ce principe là, qu'on voit qu'on peut appeler dans une fonction évidemment en paramètre passer un objet. Je pense que ça vous l'avez bien compris au stade où on en est du cours. Et bien vous n'aurez pas de difficulté pour la suite.

On va continuer, on va avoir d'autres petites fonctions, on ne les verra pas toutes évidemment parce qu'il y a évidemment plein de fonctions différentes, vous n'aurez qu'à aller voir sur la documentation par rapport au module draw pour voir ce que vous pouvez faire. 

Moi aussi je vous montre les principaux, ceux que vous allez utiliser à priori le plus. 

Alors le rectangle Rect, je ne l'ai pas dit mais ça paraît logique comme c'est un objet en python, il possède bien sûr sur pygame pas mal d'attributs. On a des attributs pour les coordonnées, on a des attributs par exemple pour la hauteur mais ça on l'a déjà vu Rect(…heigt) ou pour la largeur. On a également des attributs pour d'autres éléments et par exemple le décalage qu'il y a entre un endroit et un autre donc n'hésitez pas évidemment à voir tous les attributs qu'on peut retrouver pour cette objet Rect. 

Alors on a vu la ligne, on a vu le point aussi parce que ça fonctionne avec, on a vu comment tracer un rectangle mais maintenant est-ce qu'on peut voir un cercle. Est-ce que ça peut être intéressant de voir le cercle ? Je pense que ça pourrait l'être. 

On va passer ça, pygame.draw…

Alors pour le cercle pareil si vous savez comment fonctionne un cercle niveau mathématique donc c'est du niveau collège ce n'est pas vraiment très compliqué, vous n'aurez pas de problème. 

Donc on va le passer ici, pygame.draw.circle() toujours sur un draw. Normalement on n'aura pas besoin de rect_form mais je le garde toujours au cas où.

Donc pour le cercle c'est comme tout à l'heure, on passe la surface … c'est assez simple au niveau du nommage, des paramètres qu'elles prennent donc c'est facile après pour les retenir. 
```py
    pygame.draw.circle(window_surface, ...)
```
Une fois que vous en connaissez une vous savez un peu prêt re trouver les autres parce que les paramètres sont mis dans le même ordre, sont mis de la même manière, c'est très simple c'est naturel la manière dont les choses ont été conçues. Donc on a la surface, la couleur à priori … c'est comme pour les autres de tracé … et en 3e paramètre on va avoir la position. 
```py
    pygame.draw.circle(window_surface, black_color, ...)
```
Donc la position pour un cercle ça paraît logique c'est le centre là.
```txt
        .   .   .
      .           .
    .               .
    .       .       .
    .               .
      .           .
        .   .   .

```
Alors cette position c'est pareil vous pouvez la représenter entre crochets mais vous pouvez également la passer par une variable, c'est vous qui voyez mais nous on va directement la passer ici.
```py
    pygame.draw.circle(window_surface, black_color, [], ...)
```
Alors suivant l'interface 640 par 480, on ne va pas centrer le cercle à l'écran … voilà vous savez de toute façon comment centrer mais nous on va faire [150, 100]. 
```py
    pygame.draw.circle(window_surface, black_color, [150, 100], ...)
```
Voilà on va faire ça comme ça alors cette position là, c'est le 3e paramètre de la fonction pour tracer un cercle c'est tout simplement les coordonnées X et Y du centre du cercle. 

Et ensuite vous allez passer le rayon tout simplement la grandeur qui permettra de calculer un diamètre du cercle, je rappelle qu'un diamètre c'est 2 fois le rayon donc si vous voulez un diamètre de 100, on peut mettre 50 et on aura du coup un cercle de 100 pixels de diamètre.
```py
    pygame.draw.circle(window_surface, black_color, [150, 100], 50)
```
Alors est-ce que c'est bon ? on ne va pas mettre d'épaisseur …
```py
#coding:utf-8
import pygame

pygame.init()

window_resolution = (640, 480)
blue_color = (89, 152, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #36")

window_surface = pygame.display.set_mode(window_resolution)
window_surface.fill(blue_color)

pygame.draw.circle(window_surface, black_color, [150, 100], 50)

pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    > python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +-----------------------------------+
    |Pygame #36                 - # x   |
    |  (.)                              |
    |                                   |
    |                                   |
    +-----------------------------------+
```
Donc on a 150 au niveau du X et 100 par rapport à la position 0 du Y. 

Voilà pour la position de notre centre, et entre le centre et le bord extérieur, on a 50 pixels de rayon donc on a 100 au total pour le diamètre du cercle. 

Alors si on a par exemple 2 en 5e paramètre donc le dernier paramètre. 
```py
#coding:utf-8
import pygame

pygame.init()

window_resolution = (640, 480)
blue_color = (89, 152, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #36")

window_surface = pygame.display.set_mode(window_resolution)
window_surface.fill(blue_color)

pygame.draw.circle(window_surface, black_color, [150, 100], 50, 2)

pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    > python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +-----------------------------------+
    |Pygame #36                 - # x   |
    |  ( )                              |
    |                                   |
    |                                   |
    +-----------------------------------+
```
Voilà on retrouve la même chose qu'avec le rectangle, on a que l'épaisseur du cercle. Et là comme vous avez remarqué dés qu'on indique cette épaisseur, cette largeur, on n'a plus de remplissage qui est fait donc ça c'est très important du coup ça permet de faire les 2, on peut faire quelque chose qui rempli ou soit qu'il n'est pas donc c'est plutôt pratique au niveau des formes

Voilà pour le cercle. 

Ce n'est pas compliqué c'est vraiment très simple, je pense que tout ça comment dessiner un cercle, les informations nécessaires pour tracer un cercle, c'est vraiment des mathématiques encore une fois très basique donc je pense que ça ne posera de problème pour personne et si vraiment vous avez des difficultés avec ça que vous avez oublié ou que vous ne savez pas quelles sont les propriétés d'un cercle ou d'un rectangle ou je ne sais quoi, n'hésitez pas à faire une petite recherche sur internet, vous regardez comment ça fonctionne, quelles sont les informations utiles pour créer un cercle, pour créer un rectangle, tout ça.  

Voilà il y a des choses vraiment très très simple mais honnêtement ça devrait pas vous poser de problème.

Voilà pour le cercle.

alors maintenant on va présenter celui pour les polygones parce que c'est celui qui nous permet de tracer tout un tas de choses et on va terminer avec ça. 

Alors si vous voulez faire une forme quelconque, alors une forme quelconque ça peut également sous-entendre les triangles, ils n'ont pas fait de fonction pour les triangles puisqu'un triangle c'est un polygone enfaite, c'est tout simplement 3 points donc on donne les coordonnées de 3 points et automatiquement en rejoignant ces 3 points on obtient un triangle celon le nombre de côté que vous voulez. 

Donc 3 points vous aurez 3 côtés, donc si vous mettez plus vous pourrez créer des octogone et cetera, tout et n'importe quoi. 

Alors pour faire ça, alors pour créer ce polygone, on va reprendre le même exemple.

    pygame.draw.polygon()

Alors le polygone va se faire sur une surface et je pense que maintenant on est bien habitué à ça. 

    pygame.draw.polygon(window_surface, black_color, ...)

Il va se faire également d'une certaine couleur donc ça il n'y a pas de surprise non plus. 

Et ici il va prendre tout un tas de paramètres, tout un tas d'informations parce qu'un polygone il peut être constitué de plusieurs points c'est-à-dire … je vais vous montrer sur des schémas parce que je pense que c'est bien explicite. 

Alors si je fait ça,
```txt
    *
            
                *
```
... j'ai une ligne.

Si je fait ça,
```txt
    *
            
                *
    
    *
```
... j'ai un polygone.

Si je fait ça,
```txt
    *
        *
                *
    
    *       *
        *    
```
... pareil j'aiun polygone.

J'ai un polygone parce que si je rejoins à tout, j'ai une forme de polygone, je peux donc avoir un polygone particulier qui est un triangle même s'il est très moche. on peut imaginer le triangle des illuminati :)

Voilà ce sera une forme de polygone également. 

Donc pour chacun de ces points qui sont représentés là, nous avons évidemment des coordonnées à renseigner, toujours pareil XY. Pour un triangle on aura 3 paires de coordonnées. 

Mais pour certains polygone on en aura plus que 3, on va devoir effectivement passer énormément si on veut que tout le tracé soit fait, juste en donnant ces informations là, pygame va tout simplement calculer les tracés entre chaque et donc vous tracez la forme. 

Et pareil si on met une épaisseur ça ne sera pas rempli, si on met pas d'épaisseur le remplissage sera fait de la couleur. C'est la même chose que pour le cercle, pour le rectangle et tout ce que nous avons vu. 

Donc on y va on va renseigner ce petit polygone avec toutes les informations que nous voulons donc ces informations on va les passer dans une variable qu'on va appeler coords = [] qui est une liste si on fait au plus simple il prend les coordonnées sous forme de tuples.
```py
    coords = [(), (), ()]
    pygame.draw.polygon(window_surface, black_color, ...)
```
Donc nos coordonnées sous forme de tuples et je peux lui dire par exemple (10, 10).
```py
    coords = [(10, 10), (), ()]
    pygame.draw.polygon(window_surface, black_color, ...)
```
Après si on fait un triangle on va le décaler à 100 par exemple mais on ne va pas changer le Y, et après on peut faire (30, 50), on décale et on va faire un triangle. 
```py
    coords = [(10, 10), (100, 10), (30, 50)]
    pygame.draw.polygon(window_surface, black_color, ...)
```
On va commencer par un triangle, et bien sûr on va lui passer les coordonnées et admettons on va également lui mettre une épaisseur.
```py
    coords = [(10, 10), (100, 10), (30, 50)]
    pygame.draw.polygon(window_surface, black_color, coords, 2)
```
Et on y va.
```py
#coding:utf-8
import pygame

pygame.init()

window_resolution = (640, 480)
blue_color = (89, 152, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #36")

window_surface = pygame.display.set_mode(window_resolution)
window_surface.fill(blue_color)

coords = [(10, 10), (100, 10), (30, 50)]

pygame.draw.polygon(window_surface, black_color, coords, 2)

pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    > python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +-----------------------------------+
    |Pygame #36                 - # x   |
    |   ____                            |
    |   \  /                            |
    |    \/                             |
    +-----------------------------------+
```
Et voilà nous obtenons évidemment un triangle, on a passé encore une fois 3 paires de coordonnées donc 3 points qui sont créés et pygame fais le tracé entre chacun donc on a un triangle qui est créé. 

Si par contre je lui passe plein d'autres choses mais que je ne mette pas n'importe quoi sinon on va se retrouver avec des formes bizarres, alors qu'est-ce qu'on va pouvoir passer ? essayons avec ceci quel temps .
```py
#coding:utf-8
import pygame

pygame.init()

window_resolution = (640, 480)
blue_color = (89, 152, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #36")

window_surface = pygame.display.set_mode(window_resolution)
window_surface.fill(blue_color)

coords = [(10, 10), (100, 10), (30, 50), (40, 60)]

pygame.draw.polygon(window_surface, black_color, coords, 2)

pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    > python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +-----------------------------------+
    |Pygame #36                 - # x   |
    |   ____                            |
    |   \  /                            |
    |    \/                             |
    |    /\                             |
    |    \/                             |
    +-----------------------------------+
```
Voilà et donc évidemment il y a des croisements qui sont faits par rapport à ce qu'on donne donc vous donner autant de points que vous voulez par rapport à une forme précise et pygame fera le reste donc on obtiendra comme ça à polygone quel qu'il soit. 

Et encore une fois si on veut du remplissage, on ne passe pas d'épaisseur.
```py
#coding:utf-8
import pygame

pygame.init()

window_resolution = (640, 480)
blue_color = (89, 152, 255)
black_color = (0, 0, 0)

pygame.display.set_caption("Python #36")

window_surface = pygame.display.set_mode(window_resolution)
window_surface.fill(blue_color)

coords = [(10, 10), (100, 10), (30, 50), (40, 60)]

pygame.draw.polygon(window_surface, black_color, coords)

pygame.display.flip()

launched = True
while launched:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            launched = False
```
```powershell
    > python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    +-----------------------------------+
    |Pygame #36                 - # x   |
    |   ____                            |
    |   \  /                            |
    |    \/                             |
    |    /\                             |
    |    \/                             |
    +-----------------------------------+
```
Et donc voilà on aura un remplissage qui a été effectué vous avez donc très pratique cette petite fonction quand vous voulez vraiment une forme un peu quelconque un peu plus complexe que un simple cercle ou un simple rectangle, utilisez la fonction polygon() qui permettra de le faire.

Et je pense qu'on va s'arrêter là, on a vu là majoritaire en tout cas le principal de ce qui pouvait être intéressant pour dessiner sur notre surface. On garde le reste pour la vidéo suivante. 

Alors comme toujours pour ce qui est de l'essentiel, de ce que je juge vraiment important pour cette bibliothèque sera vu dans le cours. 

Après si je veux vous emmener plus loin sur certains particularités, certaines fonctions ou certains objets, ce sera proposé ne vous inquiétez pas en annexe du cours dans la playlist des tutoriels de python. Vous aurez ça là dessus si j'ai besoin par exemple d'aller plus dans le détail, plus loin sur certaines choses mais là déjà au niveau de ce que vous aurez dans le cours, il n'y aura pas mal à faire. 

Donc j'espère que ça continue à vous plaire, j'espère que ça vous donne envie d'aller encore plus loin parce que vous voyez qu'il y a pas mal de choses intéressantes avec cette petite bibliothèque qui propose tout un tas de modules sur lequel nous pouvons utiliser beaucoup de fonctions en faisant pas mal d'objets, et nous pouvons du coup créer des choses très intéressantes. 

N'hésitez pas à vous entraîner, c'est l'occasion de faire tout un tas de petits programmes, de vous faire des petits projets comme c'est beaucoup de visuel ça va être beaucoup plus intéressant je pense affaire que de simples programmes en console. 

Alors n'hésitez pas à vous lancer sur un petit programme, partir sur un petit projet à créer des formes, n'importe quoi, n'hésitez pas également à l'associer parce que je n'ai pas forcément dit mais avec tkinter c'est-à-dire de travailler avec tkinter qui est utile pour faire des interfaces graphiques avec des widgets. 

Et comme ça dès qu'on va cliquez sur un bouton, ça affiche un triangle de telle forme ou alors vous avez des champs de texte sur lequel on va renseigner des coordonnées, et ces coordonnées là sont récupérées dans des variables et permettront de dessiner un polygone particulier ou ce genre de chose. 

Donc n'hésitez pas à mélanger les 2, tkinter et pygame et voir comment ça peut s'associer et voir évidemment que ça marche très très bien ensemble. 

Donc voilà si vous voulez vraiment vous entraîner parce qu'au moment je fais cette vidéo il n'y a pas encore d'exercices propre à pygame ou à tkinter sur la chaîne, alors n'hésitez pas à devancer en faisant vos propres petits programmes, vos propres petits projets. Vous aurez beaucoup beaucoup de choses pour mettre ça en pratique, vos perfectionner et bien sûr progresser sur cette formation. 

Je vous dis à bientôt pour la prochaine vidéo, je voudrais qu'on se retrouve pour la séance 37 sur pygame. 

À bientôt tout le monde