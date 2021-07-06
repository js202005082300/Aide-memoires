# [38. L'objet Rect](https://www.youtube.com/watch?v=fHL12YbCY-k)

Bonjour et bienvenue sur votre formation au langage python, on continue avec pygame et ici on fait une petite parenthèse sur un point essentiel que je n'avais pas forcément prévu à la base d'en faire une vidéo dédiée mais nous allons parler de l'objet Rect.

Jusqu'à présent par rapport aux codes qu'on avait fait et notamment sur la vidéo où je vous avais montré comment dessiner sur une surface, je vous avais expliqué que l'on dessine des lignes, des rectangles, des polygones et cetera, ces fonctions un peu particulière retournaient un Rect donc un objet spécifique à pygame qui va énormément servir. 

Du coup je me suis dit que ce serait intéressant de faire une vidéo rien que sur ça parce qu'il y a beaucoup à dire quand même, et que ça va vous permettre de faire pas mal de manipulations aussi. 

Alors on va déjà reprendre tout simplement un code minimal.
```py
#coding:utf-8
import pygame

pygame.init()
window_resolution = (640, 480)

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)
pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
Alors je vais redétailler très rapidement pour qu'on soit tous au même point. 

Je rappelle qu'on importe le pygame, on n'oublie pas. 

On initialise : `pygame.init()`

On prépare une petite variable qui prend une valeur donc un tuple pour la résolution que je veux pour ma fenêtre : `window_resolution = (640, 480)`

Je modifie le titre de cette fenêtre : `pygame.display.set_caption("Python #38 - l'objet Rect")`

On fait tout simplement la création de la fenêtre avec le changement ici : `window_surface = pygame.display.set_mode(window_resolution)`

Et le petit flip() qui va prendre en compte tous les changements pour mettre à jour donc ce sera utile surtout lorsqu'on va avoir d'autres choses dessiner : `pygame.display.flip()`

Alors volontairement je l'ai mis en dehors de la boucle principale et là je fais une toute petite très courte parenthèse pour ceux qui se poseraient la question que si normalement, nous manipulons d'autres bibliothèques 2D ou que vous avez suivi d'autres vidéos d'une autre playlist, vous aviez vu qu'un affichage ça se fait sur une fraction de seconde c'est à dire qu'on affiche et c'est terminé. 

Donc logiquement on pourrait s'attendre ici à ce que le programme fasse l'affichage de la fenêtre et tout de suite ferme la fenêtre parce que après tout s'est fait en dehors d'une boucle infinie donc ça ne devrait pas s'exécuter en boucle et du coup la fenêtre ne devrait pas rester affichée en boucle. 

Donc automatiquement si je fais une exécution de programme minimal ici, on teste et on se rend compte que la fenêtre arrive bien à rester ouverte.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
La fenêtre arrive presque à rester ouverte, alors est-ce que c'est spécifique à python ? est-ce que c'est pygame qui a été conçu pour garder les fenêtres ouvertes malgré tout contrairement à d'autres langages comme le c ou Java ou je ne sais quoi ? non ce n'est absolument pas spécifique au langage, c'est tout simplement parce que ici nous avons justement notre boucle infinie qui va attendre. 

Cette boucle s'exécute sans arrêt sans arrêt et ne s'arrête que le moment où nous quittons le programme. Et le fait de quitter le programme en cliquant sur la croix, c'est détecté par un événement particulier, ici QUIT qu'on aura l'occasion de détailler un peu plus dans une vidéo dédiée. 

Il y aura évidemment une vidéo prévue sur ce cours sur les événements avec pygame donc c'est grâce à cela que la fenêtre reste ouverte. si j'enlève toute cette partie là.
```py
    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```       
Retrouver un fonctionnement naturel donc en fonctionnement d'origine d'un affichage c'est-à-dire qu'un affichage il va se faire qu'une seule fois, ce n'est pas quelque chose qui va se produire à l'infini. Il y a un affichage et en une fraction de seconde, ça s'enlève et du coup ce n'est presque pas visible à l'œil nu.
```py
##coding:utf-8
#import pygame
#
#pygame.init()
#window_resolution = (640, 480)
#
#pygame.display.set_caption("Python #38 - l'objet Rect")
#window_surface = pygame.display.set_mode(window_resolution)
#pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
C'est à peine la fenêtre s'ouvre et se referme directement donc ce n'est pas parce que c'est différent ou autre, c'est tout pareil pour n'importe quel langage n'importe quelle bibliothèque, c'est simplement que grâce à cette boucle infinie même si ce code là n'est pas dans la boucle infinie.
```py
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Comme ici on a chargé la fenêtre, elle reste évidemment ouverte grâce à ça et du coup l'affichage reste, l'affichage reste constant. C'est ça qui permet d'avoir notre exécution. 

Je le dis parce que vous avez vu que dans certaines vidéos on avait mis du code en dehors de la boucle principale, et ensuite on l'a mis dans la boucle principale. 

Grosso modo on charge les données, on initialise et on configure toutes les données toutes les sources à charger en dehors, et après ce qui va avoir éventuellement besoin de changer … donc il va avoir besoin d'être mis à jour, on va voir les changements au niveau de l'affichage sera mis dans la boucle ici donc le while launched qui est ma boucle infinie, la boucle principale comment on dit du jeu ou de l'application graphique voilà. 

Donc là pour certaines choses que je vais vous montrer, on fait ça en dehors parce que ce sera très bien pour une bonne partie. On n'aura pas besoin de le faire dans la boucle infinie. 

Alors cet objet Rect, à quoi il consiste ? 

C'est objet Rect, on en a déjà parlé et je vous avais dit que c'était un élément très important, pas seulement sur pygame en python mais sur toute la 2D en général en programmation tout simplement parce que rectangle c'est l'élément le plus simple à manipuler si on parle en 2D et c'est également celui qui permet de faire les calculs les plus pratiques. 

Si on travaille avec des triangles ce serait source d'erreur parce que les valeurs ne sont pas forcément dite ronde, ce n'est pas forcément des valeurs qui tombent juste. Ça peut être des valeurs dite arrondi, des valeurs flottantes. 

Bref on n'aurait pas forcément des choses très pratique à manipuler et quand on fait des calculs très précis au pixel, si on commence à avoir des valeurs flottantes, ça ne peut pas bien se passer. 

L'avantage des rectangles, c'est que c'est très facile à manipuler. 

Très rapidement un petit schéma histoire d'avoir une illustration pour vous aider rapidement, on va tracer un petit rectangle très très simple c'est histoire d'avoir quelque chose sous les yeux. Et ce rectangle possède plusieurs éléments importants. On a je rappelle la position du point le plus en haut à gauche d'une forme qui a évidemment des coordonnées X et Y.
```txt
       (X, Y)
       >+-----------------------------------+
        |                                   |
        |                                   |
        |                                   |
        |                                   |
        |                                   |
        +-----------------------------------+
```
Ça ça ne change pas, c'est toujours important à savoir. 

Ensuite nous avons quelque chose qui va spécifier la largeur, quelque chose qui va prendre en compte la hauteur. 

Alors ces valeurs elles prennent pour terme donc width pour la largeur, et pour la hauteur on va retrouver ceci height.
```txt
                    width
        <-----------------------------------> 

       (X, Y)
       >+-----------------------------------+       ^
        |                                   |       |
        |                                   |       |
        |                                   |       | height
        |                                   |       |
        |                                   |       |
        +-----------------------------------+       v
```
Mais on a également d'autres informations pour le rectangle ici de pygame c'est-à-dire que c'est un objet, un objet python donc pour pygame qui possède plusieurs attributs donc ça c'est un attribut le X et le Y, width, height et il y en a plein d'autres aussi.

On a un attribut qui la prend en compte, et là je vais les mettre comme ceci. On a un attribut qui va prendre toute la partie en haut donc le top en fait, le côté du haut. On aura bottom qui prendra le côté du bas. Puis left, right. On va avoir mid-top, mid_left donc il prend vraiment le milieu gauche puis le milieu droit et cetera. 

On aura également bottom-left, bottom-right, top-right, top-left, bref beaucoup beaucoup d'attributs en fait différents que nous allons pouvoir manipuler soit pour accéder aux différents éléments soit pour les modifier. 

Et si je vous en parle c'est parce que nous allons en utiliser quelques-uns, nous allons également modifier quelques-uns pour créer des petites animations dans cette vidéo donc ça c'était la petite parenthèse très rapidement pour savoir de quoi on parle. 

Alors un rectangle en tout cas Rect dans pygame possède plusieurs constructeurs possible et nous on va s'intéresser qu'à un d'entre eux, qui est très pratique et qui nous suffit par rapport à ce qu'on veut faire donc on va avoir par exemple.
```py
    """
    pygame.Rect()
    """
```
Et le constructeur que nous voulons … ce qui est suffisant par rapport à ce qu'on veut faire … c'est celui qui prend les paramètres suivant le x, le y donc les coordonnées du point en haut à gauche je rappelle du rectangle. W pour représenter le width et height.
```py
    """
    pygame.Rect(x, y, width, height)
    """
```
Avec ces 4 valeurs mathématiquement parlant on peut tracer un rectangle. 

Une fois qu'on a les coordonnées du point en haut à gauche, qu'on a la largeur et la hauteur, on a toutes les infos nécessaires pour pouvoir obtenir notre rectangle parce que je rappelle que le rectangle a ses côtés opposés de même longueur donc logiquement si vous avez fait des maths élémentaires en primaire et que vous avez très bien compris ça, il n'y a pas besoin de plus. 

Il n'y a pas besoin d'être un expert en maths pour comprendre ça et savoir le faire. 

Donc ça, pygame.Rect(x, y, width, height), c'est le constructeur que nous allons utiliser et qui est surtout très important à connaître pour le rectangle en python et qui va vous servir dans beaucoup de choses en 2D. 

Si vous comprenez ce principe là en python, vous le comprendrez en c, en c++, en Java, en c#, dans n'importe quel langage de programmation pour manipuler de la 2D, faire du graphisme 2D. 

Alors nous allons créer ce rectangle et nous allons le dessiner, on sait dessiner des rectangles et d'ailleurs on l'avait vu dans une vidéo précédente donc on y va. 

Ici avant le flip(), nous allons déjà créer notre rectangle alors moi je vais mettre `myrect =` comme ceci.
```py
    myrect = 
```
On va faire pygame.Rec donc avec un R majuscule c'est très important. Ça je le dis toujours dans mes vidéos mais quand vous voyez que je mets des majuscules et des minuscules sur des noms de fonction, des méthodes ou autre. C'est pas pour faire joli, ce n'est pas parce que j'ai choisi, ce qu'il faut vraiment l'écrire comme ça, il faut bien respecter la case et donc j'insiste là-dessus.
```py
    myrect = pygame.Rect()
```
On fait ça, on passe toutes les valeurs même si à priori on n'est pas obligé de lui passer toutes les valeurs, on va quand même lui passer toutes les valeurs 10, 10, 250, 80.
```py
    myrect = pygame.Rect(10, 10, 250, 80)
```
Ensuite nous allons dessiner ce rectangle avec quelque chose que nous avons déjà fait précédemment c'est à dire avec le module draw donc pygame.draw.rect() avec rect() cette fois c'est tout en minuscule pour qu'on ne se trompe pas dans le module draw, on utilise la fonction rect() et ça prend plusieurs paramètres qu'on avait déjà vu c'est-à-dire la surface sur laquelle on va le dessiner donc nous c'est notre fenêtre donc window_surface. Ensuite ça prend une couleur et ça on va le voir par la suite mais par exemple on va le faire en rouge ce rectangle (red). Et ensuite on va avoir tout simplement le rectangle à passer donc nous c'est myrect, comme ça on a toutes les informations qui sont données ici.
```py
    myrect = pygame.Rect(10, 10, 250, 80)
    pygame.draw.rect(window_surface, red, myrect)
```
Alors la couleur, on va la donner ici avec la variable `red = (255, 0, 0)`.
```py
#coding:utf-8
import pygame

"""
pygame.Rect(x, y, width, height)
"""

pygame.init()
window_resolution = (640, 480)
red = (255, 0, 0)

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)

myrect = pygame.Rect(10, 10, 250, 80)
pygame.draw.rect(window_surface, red, myrect)

pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
On va juste mettre ça comme ça. 

Okay nous avons dessiné le rectangle, on a pris tout en compte donc pas de soucis donc ça a pas de problème, on va faire notre programme et hop le rectangle dessiné.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    | +---------------------+                           |
    | |                     |                           |
    | |       Rouge         |                           |
    | |                     |                           |
    | +---------------------+                           |
    |                                                   |
    +---------------------------------------------------+
```
Le rectangle s'affiche, on a bien fait le flip() et tout, tout va bien.

Encore une fois, je rappelle grâce à ma boucle ici qui gère au niveau des événements, la fenêtre reste ouverte sans problème sinon si il n'y avait pas ça mais que la fenêtre serait dans une boucle infinie mais pas le reste, qu'il n'y aurait pas de boucle infinie pour le reste. Eh bien le restaurant le rouge se serait affiché et il aurait disparu directement, limite on aurait peut être même pas vu s'afficher à l'écran comme s'il n'avait jamais existé. 

C'est juste qu'il se serait affiché tellement rapidement, qu'à l'euil nu on ne l'aurait pas vu voilà. 

Donc voilà pas de problème, on a notre petit rectangle. 

Donc une fois qu'on a notre objet, encore une fois on va pouvoir modifier ses attributs et manipuler ces attributs. 

Alors quand on n'a pas encore vu les événements, comment utiliser le clavier où ce genre de chose, modifier travailler avec cet événement là pour modifier des choses dans notre programme, on va faire le déplacement ou en tout cas les changements de propriété directement dans le code. 

Alors on va utiliser le module time de python, plus tard vous verrez qu'on a un modèle pour gérer le temps via pygame mais on verra ça plus tard mais pour le moment faire ce qu'on a déjà vu c'est-à-dire qu'on a vu une vidéo sur la gestion du temps dans le cours donc logiquement je pars du principe que vous savez manipuler car on avait vu ça déjà depuis un moment voilà donc on va importer time et on va l'utiliser.

Alors ce qu'on va faire, c'est qu'on va se créer une variable i que je vais mettre ici, qui va servir le compteur et que je mets à 0.
```py
    #coding:utf-8
    import pygame
    import time

    """
    pygame.Rect(x, y, width, height)
    """

    pygame.init()
    window_resolution = (640, 480)
    red = (255, 0, 0)
    i = 0

    pygame.display.set_caption("Python #38 - l'objet Rect")
    window_surface = pygame.display.set_mode(window_resolution)

    myrect = pygame.Rect(10, 10, 250, 80)
    pygame.draw.rect(window_surface, red, myrect)
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
i va servir de compteur et on le met donc à 0, on fait ça comme ça. 

Alors on garde ça comme premier affichage et ensuite on crée une nouvelle boucle while, pas besoin de le faire dans la boucle infinie.
```py
    myrect = pygame.Rect(10, 10, 250, 80)
    pygame.draw.rect(window_surface, red, myrect)
    pygame.display.flip()
```
On crée notre boucle `while i < 10`, qu'est-ce qu'on va faire tant que i < 10 ? Alors déjà on ne va pas oublier d'incrémenter à chaque fois de 1 sinon on aura une boucle infinie et donc on ne veut pas ça pour le coup.
```py
    #coding:utf-8
    import pygame
    import time

    """
    pygame.Rect(x, y, width, height)
    """

    pygame.init()
    window_resolution = (640, 480)
    red = (255, 0, 0)
    i = 0

    pygame.display.set_caption("Python #38 - l'objet Rect")
    window_surface = pygame.display.set_mode(window_resolution)

    myrect = pygame.Rect(10, 10, 250, 80)
    pygame.draw.rect(window_surface, red, myrect)
    pygame.display.flip()
    
    while i < 10:
        i += 1

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
On va faire time.sleep() qu'on a déjà vu et je ne vais pas attendre en seconde …  je tiens à rappeler que ça prend un argument, une valeur en seconde … nous on va attendre des mili secondes sinon on va attendre très longtemps donc on va mettre .050. 50 millisecondes ce n'est pas mal.
```py
    #coding:utf-8
    import pygame
    import time

    """
    pygame.Rect(x, y, width, height)
    """

    pygame.init()
    window_resolution = (640, 480)
    red = (255, 0, 0)
    i = 0

    pygame.display.set_caption("Python #38 - l'objet Rect")
    window_surface = pygame.display.set_mode(window_resolution)

    myrect = pygame.Rect(10, 10, 250, 80)
    pygame.draw.rect(window_surface, red, myrect)
    pygame.display.flip()
    
    while i < 10:
        time.sleep(.050)
        i += 1

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Donc si vous voulez faire des mini secondes, vous mettez un point et ensuite la valeur en millisecondes donc moi je vais mettre 50 millisecondes et ce sera très bien.

Alors qu'est-ce qu'on va faire par rapport à ça ? déjà nous allons effacer l'écran, je rappelle que pour effacer l'écran, il n'y a pas de fonction ou de méthode qui le font. 

Effacer l'écran en réalité, ça revient en fait à le mettre dans l'état donc de d'afficher tel qu'il était au départ. 

Au départ c'est quoi mon écran, en tout cas ma fenêtre, avant d'afficher le rectangle rouge ? Eh bien c'est un écran noir, je n'ai pas spécifier ici de couleur pour la fenêtre. On n'a pas fait un fill() d'une couleur, on a laissé par défaut et par défaut c'est en noir donc j'ai juste à refaire pareil. Je vais faire tout simplement window_surface.fill(black) et très bien sûr la couleur black sinon on ne l'aura pas (0, 0, 0), voilà.
```py
    #coding:utf-8
    import pygame
    import time

    """
    pygame.Rect(x, y, width, height)
    """

    pygame.init()
    window_resolution = (640, 480)
    black = (0, 0, 0)
    red = (255, 0, 0)
    i = 0

    pygame.display.set_caption("Python #38 - l'objet Rect")
    window_surface = pygame.display.set_mode(window_resolution)

    myrect = pygame.Rect(10, 10, 250, 80)
    pygame.draw.rect(window_surface, red, myrect)
    pygame.display.flip()
    
    while i < 10:
        time.sleep(.050)
        window_surface.fill(black)
        i += 1

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```            
Donc qu'est-ce qu'on dit ici ?
```py
    while i < 10:
        time.sleep(.050)
        window_surface.fill(black)
        i += 1
```
Tant que i < 10, on attend 50 milliseconde. On met ensuite un écran noir mais qu'est-ce que ça veut dire de mettre un écran noir ? ça veut dire que tu fais disparaître le rectangle rouge qu'on a dessiné tout à l'heure. Tu va changer … Regardez ce qu'on va faire sur ce rectangle, on fait myrect. et on accède à un de ces attributs … Je rappelle que c'est un objet auquel on peut accéder à ces attributs donc moi je veux accéder par exemple au X et je vais l'augmenter de 10.
```py
    while i < 10:
        time.sleep(.050)
        window_surface.fill(black)
        myrect.x += 10
        i += 1
```        
Et je vais faire pareil pour le Y donc en fait on va décaler en diagonale le rectangle. 
```py
    while i < 10:
        time.sleep(.050)
        window_surface.fill(black)
        myrect.x += 10
        myrect.y += 10
        i += 1
```
Et ensuite je redessine mon rectangle avec pygame.draw.rect()
```py
    while i < 10:
        time.sleep(.050)
        window_surface.fill(black)
        myrect.x += 10
        myrect.y += 10
        pygame.draw.rect(window_surface, red, myrect)
        ...
        i += 1
```
Vous voyez que je repasse le rectangle donc on va bien récupérer le X et Y, et notre rectangle qu'on redessine en rouge sans problème et je n'oublie pas de faire un flip() sinon mes changements ne sont pas pris en compte.
```py
#coding:utf-8
import pygame
import time

"""
pygame.Rect(x, y, width, height)
"""

pygame.init()
window_resolution = (640, 480)
black = (0, 0, 0)
red = (255, 0, 0)
i = 0

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)

myrect = pygame.Rect(10, 10, 250, 80)
pygame.draw.rect(window_surface, red, myrect)
pygame.display.flip()

while i < 10:
   time.sleep(.050)
   window_surface.fill(black)
   myrect.x += 10
   myrect.y += 10
   pygame.draw.rect(window_surface, red, myrect)
   pygame.display.flip()
   i += 1

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```            
Donc normalement si je n'ai pas fait de bêtise parce que oui des fois quand on s'enregistre, on oublie la moitié des choses, ça peut arriver de faire des erreurs d'inattention dans les vidéos mais on verra de toute façon très vite si on a oublié quelque chose. 

On actualise et voilà ce qu'il se passe. 
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    | +---------------------+                           |
    | |                     |                           |
    | |       Rouge         |                           |
    | |                     |                           |
    | +---------------------+                           |
    |                                                   |
    +---------------------------------------------------+
    
    Le rectangle bouge ...

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |           
    |                                                   |
    |           +---------------------+                 |
    |           |                     |                 |
    |           |       Rouge         |                 |
    |           |                     |                 |
    |           +---------------------+                 |
    |                                                   |
    +---------------------------------------------------+
```
Alors ça va peut-être un peu vite pour le coup, on va mettre 800 millisecondes ce qui fera presque une seconde.
```py
#coding:utf-8
import pygame
import time

"""
pygame.Rect(x, y, width, height)
"""

pygame.init()
window_resolution = (640, 480)
black = (0, 0, 0)
red = (255, 0, 0)
i = 0

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)

myrect = pygame.Rect(10, 10, 250, 80)
pygame.draw.rect(window_surface, red, myrect)
pygame.display.flip()

while i < 10:
   time.sleep(.800)
   window_surface.fill(black)
   myrect.x += 10
   myrect.y += 10
   pygame.draw.rect(window_surface, red, myrect)
   pygame.display.flip()
   i += 1

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

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    | +---------------------+                           |
    | |                     |                           |
    | |       Rouge         |                           |
    | |                     |                           |
    | +---------------------+                           |
    |                                                   |
    +---------------------------------------------------+
    
    Le rectangle bouge plus lentement (800 millisec)...

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |           
    |                                                   |
    |           +---------------------+                 |
    |           |                     |                 |
    |           |       Rouge         |                 |
    |           |                     |                 |
    |           +---------------------+                 |
    |                                                   |
    +---------------------------------------------------+
```
Voilà ça fait presque une seconde d'attente entre les 2, donc il va faire jusqu à ce que i arrive à 10 et une fois que i arrive à 10 (notre petit compteur), le programme arrête l'affichage. 

Voilà on a l'impression que le rectangle se déplace alors qu'en réalité pas du tout. 

En réalité, c'est un petit peu le côté de l'informatique, peut être que vous étiez en train de penser qu'on déplace véritablement la forme mais en fait non, on efface et on afficha une nouvelle position. 

Évidemment comme tout cela en informatique se passe très vite, on a véritablement l'impression que l'objet se déplace donc voilà pour ça. 

D'ailleurs si je voulais que ça se déplace plus doucement donc de faire une animation un peu plus fluide, on déplacerait de 1 pixel pour rendre la chose un peu plus fluide.
```py
#coding:utf-8
import pygame
import time

"""
pygame.Rect(x, y, width, height)
"""

pygame.init()
window_resolution = (640, 480)
black = (0, 0, 0)
red = (255, 0, 0)
i = 0

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)

myrect = pygame.Rect(10, 10, 250, 80)
pygame.draw.rect(window_surface, red, myrect)
pygame.display.flip()

while i < 10:
   time.sleep(.800)
   window_surface.fill(black)
   myrect.x += 1 # 1 pixel
   myrect.y += 1 # 1 pixel
   pygame.draw.rect(window_surface, red, myrect)
   pygame.display.flip()
   i += 1

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

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    | +---------------------+                           |
    | |                     |                           |
    | |       Rouge         |                           |
    | |                     |                           |
    | +---------------------+                           |
    |                                                   |
    +---------------------------------------------------+
    
    Le rectangle bouge avec plus de fluidité ...

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |           
    |                                                   |
    |           +---------------------+                 |
    |           |                     |                 |
    |           |       Rouge         |                 |
    |           |                     |                 |
    |           +---------------------+                 |
    |                                                   |
    +---------------------------------------------------+
```
Donc là on voit bien le décalage qui se fait parce qu'il y a une petite attente assez longue de 10.

Alors ce qu'on peut encore faire ? on va mettre la boucle i jusqu à 100 et ce sera 0.050
```py
#coding:utf-8
import pygame
import time

"""
pygame.Rect(x, y, width, height)
"""

pygame.init()
window_resolution = (640, 480)
black = (0, 0, 0)
red = (255, 0, 0)
i = 0

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)

myrect = pygame.Rect(10, 10, 250, 80)
pygame.draw.rect(window_surface, red, myrect)
pygame.display.flip()

while i < 100:
   time.sleep(.050)
   window_surface.fill(black)
   myrect.x += 1 # 1 pixel
   myrect.y += 1 # 1 pixel
   pygame.draw.rect(window_surface, red, myrect)
   pygame.display.flip()
   i += 1

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

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    | +---------------------+                           |
    | |                     |                           |
    | |       Rouge         |                           |
    | |                     |                           |
    | +---------------------+                           |
    |                                                   |
    +---------------------------------------------------+
    
    Le rectangle bouge avec plus de fluidité ...

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |           
    |                                                   |
    |           +---------------------+                 |
    |           |                     |                 |
    |           |       Rouge         |                 |
    |           |                     |                 |
    |           +---------------------+                 |
    |                                                   |
    +---------------------------------------------------+
```
Voilà ça se fait assez vite donc on peut obtenir quelque chose de fluide parce que c'est un peu le but d'avoir justement de la fluidité. 

En fonction de comment on se déplace et à quelle vitesse on se déplace, qu'on rend évidemment le mouvement fluide. 

Voilà maintenant comment créer un rectangle, vous savez le dessiner mais ça on l'avait déjà vu avant et vous savez comment maintenant agir sur ses propriétés pour par exemple opérer des changements sur ce rectangle donc on peut du coup le déplacer, avoir cette impression de déplacement. 

Alors il existe quelques méthodes pour l'objet Rect mais évidemment je ne vais pas forcément toutes vous les détailler et vous le montrer parce que ça fait un peu la même chose c'est-à-dire que plutôt que de passer obligatoirement tout le temps des propriétés, vous avez différentes méthodes. Je vais vous donner les noms ici comme ça vous pourrez voir un petit peu ce que vous pouvez faire. 

Vous avez copy() qui permet tout simplement de créer une copie à partir d'un autre rectangle donc c'est bien à connaître. Ça retournera évidemment un objet Rect donc si vous faites une copie ça va copier dans un nouveau rectangle. 

Par exemple vous ne pouvez pas faire ça, admettons vous avez mynewrect = myrect.copy() car ça va faire une copie dans le nouveau, dans cette nouvelle variable donc vous pouvez faire ça. Je vais vous le donner c'est Rect.copy().
```py
    """
    Rect.copy()
    """
```
Alors on a beaucoup de méthodes moi je vous donne les noms à retenir ceux qui vont être utiles pour vous, on a move() qui va permettre de déplacer le rectangle mais attention pas forcément le déplacer lui-même donc de faire un déplacement avec copy() mais si vous voulez véritablement faire un déplacement réel, il faudra utiliser move in place qui s'écrit comme ceci move_ip() donc ça c'est à connaître aussi voilà.
```py
    """
    Rect.copy()
    Rect.move() | Rect.move_ip()
    """
```
Donc ça c'est à connaître aussi, ça revient un petit peu à modifier comme on le faisait avec myrect.x += 1 c'est-à-dire pour le X et pour le Y donc il faudra redessiner c'est-à-dire qu'on va utiliser move_ip() et ensuite on va redessiner le rectangle pygame.draw.rect(window_surface, red, myrect) c'est très important avec le rectangle qui a été déplacé "myrect" donc c'est ça qu'il ne faut pas oublier que move() et move_ip() ne vont pas redessiner, ce n'est pas une méthode qui est faites pour redessiner. Elle déplace dans le sens où elle va changer des coordonnées.

Et une fois que les coordonnées ont été changées ça évite de faire ce genre de chose par exemple.
```py
    myrect.x += 1
    myrect.y += 1
```
On redessine donc n'oubliez pas de pas confondre, de ne pas vous tromper, de ne pas penser que le fait de déplacer ça va également dessiner. 

Rappelez-vous ce que je vous ai dit en programmation, en général une fonction une méthode, on s'arrange pour qu'elle ne fasse qu'une seule chose donc move() ça ne veut pas dire je redessine mais ça veut simplement dire je change ce qui permet de créer un déplacement donc les coordonnées donc c'est ça en fait qui fait que la forme bouge, c'est tout simplement le fait de modifier les coordonnées pour prévoir un nouvel affichage donc ce sera à vous de redessiner à chaque fois le rectangle comme on l'a vu et de refaire un flip() bien évidemment. 

On a aussi très pratique inflate().
```py
    """
    Rect.copy()
    Rect.move() | Rect.move_ip()
    Rect.inflate()
    """
```
inflate() ça va tout simplement faire agrandir, grossir le rectangle donc d'agrandir sa largeur et sa hauteur, ou à l'inverse lorsqu'on passe des valeurs négatives on va le rétrécir donc le contracter donc soit on va dilater où contracter le rectangle. 

Ça c'est à connaître ça c'est bien mais on peut avoir également mais on va en parler un peu plus tard. Ça je vous montrerais parce que je pense que c'était intéressant à voir en vidéo, c'est colliderect().
```py
    """
    Rect.copy()
    Rect.move() | Rect.move_ip()
    Rect.inflate()
    Rect.colliderect()
    """
```
colliderect() qui va permettre de détecter des collisions, et je vais vous expliquer très rapidement qu'est-ce que sont les collisions parce que quand on fait justement de la 2D, quand on fait de jeu vidéo ce genre de chose. C'est évidemment une notion nécessaire et essentiel à connaître donc ça pour le coup je je vais vous montrer dans la vidéo parce qu'il faut le connaître. 

Copy(), move(), move_ip(), inflate() sur ça je vais passer très rapidement dessus parce que je n'ai pas envie de faire trop long sur cette vidéo donc honnêtement c'est à vous de tester, je vous ai montré de toute façon comment déplacer. Vous pouvez utiliser move(), vous pouvez utiliser copy() et cetera.

Voilà ce sont des choses très simples, copier un rectangle, ça va faire un autre rectangle mais exactement le même et je pense qu'il n'y a pas besoin de vous faire un exemple là-dessus voilà. 

Donc moi ce que je voulais vous montrer c'était ça, on a vu grosso modo comment créer un rectangle, comment il était composé et quels attributs, il possède. Tout ça on l'a vu. On a vu comment modifier les attributs de notre rectangle parce que je vous ai parlé également de quelques méthodes utiles. On a vu comment le déplacer et ça c'est ce que nous allons faire, et pour terminer cette vidéo parce que c'est le dernier élément que je voulais vous montrer et qui a toute son importance. C'est tout simplement de gérer le principe de collision. 

Alors en quoi consistent ces collisions ?

Nous allons créer un autre rectangle qui va nous servir d'obstacle c'est-à-dire qu'on va imaginer notre rectangle rouge même si pour le moment on ne le déplace pas nous-mêmes, c'est notre petit personnage d'ailleurs on peut faire un petit rectangle pas très grand du genre 25 sur 25.
```py
#coding:utf-8
import pygame
import time

"""
Rect.copy()
Rect.move() | Rect.move_ip()
Rect.inflate()
Rect.colliderect()
"""

pygame.init()
window_resolution = (640, 480)
black = (0, 0, 0)
red = (255, 0, 0)
i = 0

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)

myrect = pygame.Rect(10, 10, 25, 25)
pygame.draw.rect(window_surface, red, myrect)
pygame.display.flip()

while i < 100:
   time.sleep(.050)
   window_surface.fill(black)
   myrect.x += 1 # 1 pixel
   myrect.y += 1 # 1 pixel
   pygame.draw.rect(window_surface, red, myrect)
   pygame.display.flip()
   i += 1

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```py
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    | +---------+                                       |
    | |         |                                       |
    | |  Rouge  |                                       |
    | |         |                                       |
    | +---------+                                       |
    |                                                   |
    +---------------------------------------------------+
    
    Le rectangle bouge avec plus de fluidité ...

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |                                                   |
    |                                                   |
    |           +---------+                             |
    |           |         |                             |
    |           |  Rouge  |                             |
    |           |         |                             |
    |           +---------+                             |
    |                                                   |
    +---------------------------------------------------+
```
Voilà la taille me plaît bien, avant de fermer la fenêtre on va attendre qu'il ait fini de se déplacer. 

Alors maintenant on va enlever notre boucle while, on gardera juste la boucle infinie. Et maintenant on va créer un autre rectangle.
```py
    #coding:utf-8
    import pygame
    import time

    """
    Rect.copy()
    Rect.move() | Rect.move_ip()
    Rect.inflate()
    Rect.colliderect()
    """

    pygame.init()
    window_resolution = (640, 480)
    black = (0, 0, 0)
    red = (255, 0, 0)
    i = 0

    pygame.display.set_caption("Python #38 - l'objet Rect")
    window_surface = pygame.display.set_mode(window_resolution)

    myrect = pygame.Rect(10, 10, 25, 25)
    pygame.draw.rect(window_surface, red, myrect)
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Donc je vais en faire un autre myblock et on va mettre pygame.Rect() donc lui je vais le mettre à la position à 600 sachant que ma fenêtre fait 640 par 480 donc il sera vraiment vers la droite. Ensuite on va le mettre à 50 au niveau des Y et on va lui mettre une largeur de 20 qui sera déjà bien et une hauteur de 300 sachant qu'on est à 480 donc comme ça ce sera pas mal.
```py
    #coding:utf-8
    import pygame
    import time

    """
    Rect.copy()
    Rect.move() | Rect.move_ip()
    Rect.inflate()
    Rect.colliderect()
    """

    pygame.init()
    window_resolution = (640, 480)
    black = (0, 0, 0)
    red = (255, 0, 0)
    i = 0

    pygame.display.set_caption("Python #38 - l'objet Rect")
    window_surface = pygame.display.set_mode(window_resolution)

    myrect = pygame.Rect(10, 10, 25, 25)
    pygame.draw.rect(window_surface, red, myrect)
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Et ensuite on va le dessiner, je fais du copier coller de rect() parce que c'est exactement la même chose sauf qu'ici on va lui passer un petit blue = (0, 75, 255). Voilà comme ceci, ce serra un bleu un petit peu moins fort normalement.
```py
#coding:utf-8
import pygame
import time

"""
Rect.copy()
Rect.move() | Rect.move_ip()
Rect.inflate()
Rect.colliderect()
"""

pygame.init()
window_resolution = (640, 480)
black = (0, 0, 0)
red = (255, 0, 0)
blue = (0, 75, 255)
i = 0

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)

myrect = pygame.Rect(10, 10, 25, 25)
myblock = pygame.Rect(600, 50, 20, 300)
pygame.draw.rect(window_surface, red, myrect)
pygame.draw.rect(window_surface, blue, myblock)
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

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    | +---------+                                  +--+ |
    | |         |                                  |  | |
    | |  Rouge  |                                  |  | |
    | |         |                                  |bl| |
    | +---------+                                  |  | |
    |                                              |  | |
    |                                              +--+ |
    +---------------------------------------------------+
```
Voyons un petit peu on a notre carré rouge qui va servir de personnage et notre rectangle bleu qui va servir d'obstacle. Le but ça va être de déplacer ce petit carré rouge de 25 pixels par 25 pixels c'est donc bien un carré rouge et un carré et un rectangle particulier, et on va le déplacer jusqu à droite jusqu à ce qu'il rentre en collision avec notre obstacle bleu, et on ne veut pas évidemment qui le traverse. 

Le rectangle bleu pour signifier un mur dans un jeu vidéo, ou par exemple si on fait un jeu de plateforme sur lequel on pourrait sauter sur des murs ou ce genre de chose, ce serait bien de pouvoir atterrir dessus et de ne pas passer au travers sinon c'est un petit peu embêtant à moins de vouloir le faire exprès. 

Alors pour partir sur un point de départ avec les 2 rectangles alignés.
```py
    myrect = pygame.Rect(10, 10, 25, 25)
    ---> myrect = pygame.Rect(10, 100, 25, 25)
```
```py
#coding:utf-8
import pygame
import time

"""
Rect.copy()
Rect.move() | Rect.move_ip()
Rect.inflate()
Rect.colliderect()
"""

pygame.init()
window_resolution = (640, 480)
black = (0, 0, 0)
red = (255, 0, 0)
blue = (0, 75, 255)
i = 0

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)

myrect = pygame.Rect(10, 100, 25, 25)
myblock = pygame.Rect(600, 50, 20, 300)
pygame.draw.rect(window_surface, red, myrect)
pygame.draw.rect(window_surface, blue, myblock)
pygame.display.flip()

#<---------------

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

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |                                              +--+ |
    |                                              |  | |
    | +---------+                                  |  | |
    | |         |                                  |  | |
    | |  Rouge  |                                  |  | |
    | |         |                                  |bl| |
    | +---------+                                  |  | |
    |                                              |  | |
    |                                              +--+ |
    +---------------------------------------------------+
```
Alors on va faire ce déplacement, déjà un test simple donc ce que l'on peut faire … on va faire une boucle infinie while True.
```py
    while True:
```
Et on va mettre un petit temps d'arrêt sinon ce serait bizarre de 10 millisecondes donc ça va être très rapide pour le coup.
```py
    while True:
        time.sleep(.010)
```  
On a pas besoin de faire i += 1 dans une boucle infinie.

Bien que le programme ne va pas aimer faire une boucle infinie mais ce n'est pas grave on le quittera en forçant mais ce n'est pas gênant d'accord. 

Ensuite on va colorer toute la fenêtre en noir comme tout à l'heure.
```py
    while True:
        time.sleep(.010)
        window_surface.fill(black)
```
On va changer la position de X c'est à dire que le X. On ne bouge pas le Y, on ne peut pas le changer en hauteur on va juste le déplacer sur la droite donc pour qu'il se déplace vers la droite. Si on suit le schéma, les X augmente sur l'horizontale et les Y augmente sur la verticale … du coup on va augmenter que X pour que le carré se déplace de gauche à droite.
```py
    while True:
        time.sleep(.010)
        window_surface.fill(black)
        myrect.x += 1
```
On le redessine. myrect qu'on ne se trompe pas dans les noms que je ne mélange pas les noms sinons on va avoir des déplacements assez bisarre. 
```py
    while True:
        time.sleep(.010)
        window_surface.fill(black)
        myrect.x += 1
        pygame.draw.rect(window_surface, red, myrect)
```  
Et on oublie pas de faire un petit flip pour mettre à jour tout ça.
```py
    while True:
        time.sleep(.010)
        window_surface.fill(black)
        myrect.x += 1
        pygame.draw.rect(window_surface, red, myrect)
        pygame.display.flip()
```
Mais attention, on n'oublie pas bien sûr de redessiner le rectangle bleu.
```py
    while True:
        time.sleep(.010)
        window_surface.fill(black)
        myrect.x += 1
        pygame.draw.rect(window_surface, red, myrect)
        pygame.draw.rect(window_surface, blue, myblock)
        pygame.display.flip()
```
Vous voyez, il faut le faire parce que sinon à partir du moment où je fait ça, que je rempli tout de noir window_surface.fill(black), je fait tout disparaître, l'écran redevient noir donc on n'oublie de redessinner à chaque fois cette partie myblock.

```py
#coding:utf-8
import pygame
import time

"""
Rect.copy()
Rect.move() | Rect.move_ip()
Rect.inflate()
Rect.colliderect()
"""

pygame.init()
window_resolution = (640, 480)
black = (0, 0, 0)
red = (255, 0, 0)
blue = (0, 75, 255)
i = 0

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)

myrect = pygame.Rect(10, 100, 25, 25)
myblock = pygame.Rect(600, 50, 20, 300)
pygame.draw.rect(window_surface, red, myrect)
pygame.draw.rect(window_surface, blue, myblock)
pygame.display.flip()

while True:
   time.sleep(.010)
   window_surface.fill(black)
   myrect.x += 1
   pygame.draw.rect(window_surface, red, myrect)
   pygame.draw.rect(window_surface, blue, myblock)
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

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |                                              +--+ |
    |                                              |  | |
    | +---------+                                  |  | |
    | |         |                                  |  | |
    | |  Rouge  |  -->                             |  | |
    | |         |                                  |bl| |
    | +---------+                                  |  | |
    |                                              |  | |
    |                                              +--+ |
    +---------------------------------------------------+

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |                                              +--+ |
    |                                              |  | |
    |                       +---------+            |  | |
    |                       |         |            |  | |
    |                       |  Rouge  |  -->       |  | |
    |                       |         |            |bl| |
    |                       +---------+            |  | |
    |                                              |  | |
    |                                              +--+ |
    +---------------------------------------------------+
```
Alors ça je me dis encore une fois, la boucle while True dans un vrai programme, on le fera dans la boucle principale donc on va le faire d'accord on va dire au départ qu'on part de ça qui est le point de départ de notre programme. Et ensuite on est dans l'exécution et donc on copier notre boucle while dans la boucle principale histoire de faire les choses un peu plus proprement.
```py
#coding:utf-8
import pygame
import time

"""
Rect.copy()
Rect.move() | Rect.move_ip()
Rect.inflate()
Rect.colliderect()
"""

pygame.init()
window_resolution = (640, 480)
black = (0, 0, 0)
red = (255, 0, 0)
blue = (0, 75, 255)
i = 0

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)

myrect = pygame.Rect(10, 100, 25, 25)
myblock = pygame.Rect(600, 50, 20, 300)
pygame.draw.rect(window_surface, red, myrect)
pygame.draw.rect(window_surface, blue, myblock)
pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False

   while True:
       time.sleep(.010)
       window_surface.fill(black)
       myrect.x += 1
       pygame.draw.rect(window_surface, red, myrect)
       pygame.draw.rect(window_surface, blue, myblock)
       pygame.display.flip()
```
On y va, on test et on laisse tourner et il va tourner à l'infini parce que je n'ai pas fait de point d'aarêt pour ma boucle. Ce n'est par bien mais c'est juste pour montrer.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |                                              +--+ |
    |                                              |  | |
    | +---------+                                  |  | |
    | |         |                                  |  | |
    | |  Rouge  |  -->                             |  | |
    | |         |                                  |bl| |
    | +---------+                                  |  | |
    |                                              |  | |
    |                                              +--+ |
    +---------------------------------------------------+

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |                                              +--+ |
    |                                              |  | |
    |                       +---------+            |  | |
    |                       |         |            |  | |
    |                       |  Rouge  |  -->       |  | |
    |                       |         |            |bl| |
    |                       +---------+            |  | |
    |                                              |  | |
    |                                              +--+ |
    +---------------------------------------------------+
```
On se rend compte que ça passe évidemment par en-dessous, pourquoi par en-dessous je pense que vous l'avez deviné ? on dessine le rectangle rouge avant le bleu donc automatiquement il y a une histoire comme ça de surcouche qui se mettent les unes par-dessus les autres donc évidemment mon programme ne s'arrêtera jamais je n'ai pas du tout là collision que j'attendais donc pour faire ça on va faire un exemple tout simple et on va utiliser la fameuse méthode colliderect(). 

colliderect() est très simple, elle se fait sur le rectangle que vous voulez et prend en paramètre un autre rectangle. Et elle va dire quand il y a collision entre 2 rectangles, quand ils se chevauchent, elle retourne True sinon elle retourne False donc c'est une méthode qui va retourner un booléen en fonction de ce qui se passe. 

Donc moi ce que je peux faire, je peux dire que tant que myrect.colliderect(myblock) is False ... is not True bref on peut faire ce que l'on veut.
```py
    while True:
    --> while myrect.colliderect(myblock) is False:
```
Donc c'est comme si je faisait ça en fait. Petit rappel, moi je met is parce que c'est mieux, je trouve que c'est plus lisible.
```py
        while myrect.colliderect(myblock) == False:
```
Et bien je vais faire effectivement le déplacement.
```py
    #coding:utf-8
    import pygame
    import time

    """
    Rect.copy()
    Rect.move() | Rect.move_ip()
    Rect.inflate()
    Rect.colliderect()
    """

    pygame.init()
    window_resolution = (640, 480)
    black = (0, 0, 0)
    red = (255, 0, 0)
    blue = (0, 75, 255)
    i = 0

    pygame.display.set_caption("Python #38 - l'objet Rect")
    window_surface = pygame.display.set_mode(window_resolution)

    myrect = pygame.Rect(10, 100, 25, 25)
    myblock = pygame.Rect(600, 50, 20, 300)
    pygame.draw.rect(window_surface, red, myrect)
    pygame.draw.rect(window_surface, blue, myblock)
    pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False

        while myrect.colliderect(myblock) is False:
            time.sleep(.010)
            window_surface.fill(black)
            myrect.x += 1
            pygame.draw.rect(window_surface, red, myrect)
            pygame.draw.rect(window_surface, blue, myblock)
            pygame.display.flip()
```
Petite erreur, on compile et le carré rouge ne bouge pas.

Alors comme on a mit une partie (modules draw) dans le programme principale, autant que je mette le reste aussi.
```py
    #coding:utf-8
    import pygame
    import time

    """
    Rect.copy()
    Rect.move() | Rect.move_ip()
    Rect.inflate()
    Rect.colliderect()
    """

    pygame.init()
    window_resolution = (640, 480)
    black = (0, 0, 0)
    red = (255, 0, 0)
    blue = (0, 75, 255)
    i = 0

    pygame.display.set_caption("Python #38 - l'objet Rect")
    window_surface = pygame.display.set_mode(window_resolution)

    myrect = pygame.Rect(10, 100, 25, 25)
    myblock = pygame.Rect(600, 50, 20, 300)

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False

        pygame.draw.rect(window_surface, red, myrect)
        pygame.draw.rect(window_surface, blue, myblock)
        pygame.display.flip()

        while myrect.colliderect(myblock) is False:
            time.sleep(.010)
            window_surface.fill(black)
            myrect.x += 1
            pygame.draw.rect(window_surface, red, myrect)
            pygame.draw.rect(window_surface, blue, myblock)
            pygame.display.flip()
```
Et là le carré rouge ne veut toujours pas bouger.

Alors bravo ! Qu'est-ce qu'il y a qui ne va pas ? Alors je vais voir si le problème ne viient pas d'ailleurs...
```py
    #coding:utf-8
    import pygame
    import time

    """
    Rect.copy()
    Rect.move() | Rect.move_ip()
    Rect.inflate()
    Rect.colliderect()
    """

    pygame.init()
    window_resolution = (640, 480)
    black = (0, 0, 0)
    red = (255, 0, 0)
    blue = (0, 75, 255)
    i = 0

    pygame.display.set_caption("Python #38 - l'objet Rect")
    window_surface = pygame.display.set_mode(window_resolution)

    myrect = pygame.Rect(10, 100, 25, 25)
    myblock = pygame.Rect(600, 50, 20, 300)
    pygame.draw.rect(window_surface, red, myrect)
    pygame.draw.rect(window_surface, blue, myblock)
    pygame.display.flip()

    while myrect.colliderect(myblock) is False:
        time.sleep(.010)
        window_surface.fill(black)
        myrect.x += 1
        pygame.draw.rect(window_surface, red, myrect)
        pygame.draw.rect(window_surface, blue, myblock)
        pygame.display.flip()

    launched = True
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Alors hop, ça n'a rien à voir avec ça ! C'est que j'ai une erreur dans mon while.

On va remettre la boucle dans la partie qu'il faut et reprendre mon code depuis le début comme j'ai modifié une mauvaise partie. Et du coup on va tout re vérifier. 

Ok pour la boucle principale.

is devient ==.

On redesine les deux rectangles. Le bleu ne bouge pas et le rouge bouge.

Je n'ai plus besoin du i.
```py
#coding:utf-8
import pygame
import time

pygame.init()
window_resolution = (640, 480)
black = (0, 0, 0)
red = (255, 0, 0)
blue = (0, 75, 255)

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)

myrect = pygame.Rect(10, 100, 25, 25)
myblock = pygame.Rect(600, 50, 20, 300)
pygame.draw.rect(window_surface, red, myrect)
pygame.draw.rect(window_surface, blue, myblock)
pygame.display.flip()

launched = True
while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False

   while myrect.colliderect(myblock) == False:
       time.sleep(.010)
       window_surface.fill(black)
       myrect.x += 1
       pygame.draw.rect(window_surface, red, myrect)
       pygame.draw.rect(window_surface, blue, myblock)
       pygame.display.flip()            
```py
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |                                              +--+ |
    |                                              |  | |
    | +---------+                                  |  | |
    | |         |                                  |  | |
    | |  Rouge  |  -->                             |  | |
    | |         |                                  |bl| |
    | +---------+                                  |  | |
    |                                              |  | |
    |                                              +--+ |
    +---------------------------------------------------+

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |                                              +--+ |
    |                                              |  | |
    |                                   +---------+|  | |
    |                                   |         ||  | |
    |                                   |  Rouge  ||  | |
    |                                   |         ||bl| |
    |                                   +---------+|  | |
    |                                              |  | |
    |                                              +--+ |
    +---------------------------------------------------+
```
Voilà ça va mais tout à l'heure ce n'était pas is qu'il fallait faire mais c'est surtout ça qu'il faut faire : while not.
```py
    while myrect.colliderect(myblock) == False:
    ---> while not myrect.colliderect(myblock):
```
Si on fait ça ...
```py
    while myrect.colliderect(myblock):
```
... ça sous-entend que cette vérification retourne True, et si je veux l'inverse de True donc False, je vais mettre simplement le not.
```py
    while not myrect.colliderect(myblock):
```
Je n'avais pas fait ma condition comme il fallait en fait !
```py
#coding:utf-8
import pygame
import time

pygame.init()
window_resolution = (640, 480)
black = (0, 0, 0)
red = (255, 0, 0)
blue = (0, 75, 255)

pygame.display.set_caption("Python #38 - l'objet Rect")
window_surface = pygame.display.set_mode(window_resolution)

myrect = pygame.Rect(10, 100, 25, 25)
myblock = pygame.Rect(600, 50, 20, 300)
pygame.draw.rect(window_surface, red, myrect)
pygame.draw.rect(window_surface, blue, myblock)
pygame.display.flip()

launched = True
while launched:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            launched = False

    while not myrect.colliderect(myblock):
        time.sleep(.010)
        window_surface.fill(black)
        myrect.x += 1
        pygame.draw.rect(window_surface, red, myrect)
        pygame.draw.rect(window_surface, blue, myblock)
        pygame.display.flip()            
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |                                              +--+ |
    |                                              |  | |
    | +---------+                                  |  | |
    | |         |                                  |  | |
    | |  Rouge  |  -->                             |  | |
    | |         |                                  |bl| |
    | +---------+                                  |  | |
    |                                              |  | |
    |                                              +--+ |
    +---------------------------------------------------+

    +---------------------------------------------------+
    | Python #38 - l'objet Rect                 - # x   |
    |                                              +--+ |
    |                                              |  | |
    |                                   +---------+|  | |
    |                                   |         ||  | |
    |                                   |  Rouge  ||  | |
    |                                   |         ||bl| |
    |                                   +---------+|  | |
    |                                              |  | |
    |                                              +--+ |
    +---------------------------------------------------+
```
Donc là je refais le test, on a effectivement le petit cube qui se déplace et une fois qu'il rentre en collision, les 2 se chevauchent et ça s'arrête. 

Du coup, on a bien un obstacle qui a été mis. 

Voilà c'est simplement ce que je voulais vous montrer. 

Il y en a d'autres, il y a des méthodes qui permettent de tester des collisions sur des listes de rectangles. 

On peut même manipuler des dictionnaires si on veut quand on a beaucoup de données mais moi je vous montre au moins celle là parce que c'est vraiment celle à connaître, c'est l'essentiel. 

Évidemment si vous voulez aller encore plus loin avec l'objet Rect, n'hésitez pas à aller voir toutes les méthodes qui sont disponibles et tous les attributs oui que vous pouvez manipuler parce qu'il y en a vraiment beaucoup. 

Donc c'est pour ça que je voulais vous faire une vidéo, je pense que c'était utile de vous faire une vidéo là-dessus parce qu'en plus ça vous permet de créer vos petits programmes, trop petit projet pour vous entraîner mais plutôt que de commencer à travailler avec de vraies ressources si vous voulez simuler un personnage, simuler des maisons, des murs, des portes où je-ne-sais-quoi. 

Eh bien vous pourrez le faire parce que vous pouvez en fait tout schématiser, tout représenter par des rectangles, il n'y a absolument aucun problème même un cercle en réalité vous pouvez le mettre dans un rectangle parce qu'on peut entourer un cercle dans un rectangle, on peut entourer un triangle d'un rectangle, on peut entourer un vaisseau spatial dans un rectangle … tout n'importe quel objet en fait, vous pouvez en fait l'entourer dans un rectangle quel qu'il soit. 

N'importe quel objet, ça peut fonctionner comme ça et du coup à partir de là vous voyez que manipuler des rectangles ça se fait très simplement.
```txt
    +---------------------------------------------------+
    |                                                   |
    |                                              +--+ |
    |                                              |  | |
    |                                   +---------+|  | |
    |                                   |         ||  | |
    |                                   |  Rouge  ||  | |
    |                                   |         ||bl| |
    |                                   +---------+|  | |
    |                                              |  | |
    |                                              +--+ |
    +---------------------------------------------------+
```
Et de toute façon, à partir du moment où vous allez manipuler même des images, que vous allez manipuler véritablement des ressources, vous travaillerez avec des rectangles donc en tout cas avec des polygones.

Que ce soit l'un ou l'autre, vous travaillerez forcément avec des formes comme ça parce que c'est évidemment plus facile pour calculer dans un jeu vidéo. 

On va dire que c'est beaucoup plus pratique, et que ça consomme beaucoup moins de ressources aussi de travailler avec des rectangles que si on travailler par exemple avec des formes très quelconque, très complexe qui demanderait des puissances de calcul assez importante, je rappelle que python a pas mal de limites très vite à ce niveau là. 

Python n'est pas non plus un langage compilé donc on ne peut pas non plus le pousser en termes de performances qu'un langage compilé donc là vous voyez un petit peu les aperçus de ce qu'on peut faire et comment manipuler ça. 

Donc je vous ai montré encore une fois pas mal de méthode aussi donc ça c'est à connaître colliderect() pour véritablement tester la collision donc le chevauchement d'un rectangle avec un autre, et n'oubliez pas qu'il y a aussi pas mal de choses qui se mettent dans un rectangle. 

Quand on fait un draw de circle, quand on fait un draw de rect ou de polygon ou autre … tout se met dans un rectangle. 
```py
    pygame.draw.rect(window_surface, red, myrect)   -> Rect
```
Ca ça retourne un Rect, pareil quand on faisait un draw.line() dans la vidéo sur le fait de dessiner sur une Surface.

draw.line() renvoyait également une Rect parce que une ligne, on peut la mettre un rectangle.

C'est toujours des pixels donc tout peut toujours se mettre dans un rectangle.

Voilà et je pense que j'ai fait le tour de tout ce que je voulais vous montrer, je ne pense pas avoir d'autre truc. Je ne vais pas vous montrer autre chose mais je pense qu'il y a déjà pas mal pour le rectangle on a tout ce qu'il faut. 

Du coup ça m'a permis de vous montrer une petite animation … et ça va faire la transition pour ce que vous verrez dans la suite parce que là vous avez vu qu'on fait le déplacement directement dans le code et peut-être que plus tard vous aurez envie de déplacer ce petit carré rouge avec le clavier, pourquoi pas, plutôt que de le déplacer comme ça en brut dans le code. 

Donc ça on verra évidemment pour la suite de ce cours pygame avec l'utilisation des événements mais peut être pas forcément la séance prochaine mais en tout cas dans les prochaines séances concernant pygame dans la dernière vidéo de ce cours. 

Dans la dernière vidéo de ce cours nous allons avoir une vidéo dédiée spécialement pour les événements parce qu'il y a énormément de choses à faire avec les événements. 

Et bien écoutez, j'espère que ça vous a plu et s'il y a des questions n'hésitez pas parce que vous voyez qu'on commence à avoir pas mal de d'autres nouvelles choses. 

Je ne pense pas que c'est compliqué à comprendre et à mettre en œuvre après si vous avez encore un petit peu de mal avec ça et que vous confondez, que vous n'avez pas encore compris le principe avec les surfaces voilà qu'on manipule des surfaces et qu'ensuite on dessine dessus, et qu'ensuite il faut forcer cet affichage en actualisant tout simplement la mémoire tampon pour pouvoir avoir véritablement l'affichage sous les yeux et que après dès qu'on veut faire disparaître les choses, on redessine par-dessus …

Encore une fois c'est comme un tableau ou comme une toile avec de la peinture, si par exemple vous avez plein de dessins sur une toile et que vous voulez en fait tout effacer, on ne peut pas véritablement tout effacer mais il faudra tout recouvrir de blanc ou de noir donc on fait le fameux.
```py
    window_surface.fill(black)
```
Fill() qui permet de te couvrir de blanc ou de noir, c'est comme si on avait tout effacé, c'est juste qu'on recouvre par-dessus pour cacher ce qui avait été fait avant et en actualisant bien évidemment on a fait disparaître ce qu'il y avait donc c'est comme ça qu'on manipule en 2D. 

Pour n'importe quelle bibliothèque, vous verrez que les principes que vous allez apprendre pour un langage, vous serviront pour n'importe quel autre donc c'est ça l'avantage.

C'est qu'une fois que vous avez manipulé une bibliothèque 2D dans un langage, vous verrez que les notions derrière sont exactement les mêmes pour n'importe quel langage parce que ce n'est pas lié au langage en lui-même, c'est lié tout simplement à l'infographie, au système d'exploitation, à tout ce qui est fonction de mémoire tampon, tout ce genre de choses là, vos affichages tout ça, vos écrans, ce n'est évidemment pas propre langage en question mais à des choses beaucoup plus indépendantes, qui ne sont pas forcément dépendante de ce langage de programmation. 

Je vous dis à bientôt pour la suite de ce cours, j'espère que ça vous a plu et encore une fois n'hésitez pas à faire vos petits code de votre côté donc là vous avez évidemment de quoi faire pour faire de petites animations et de petits trucs qui bougent, ce sera du coup un peu plus sympa que ce qu'on a vu jusqu à présent donc amusez-vous avec pygame. 

Amusez-vous avec pygame, vous allez pouvoir faire beaucoup beaucoup de choses et vous pouvez déjà faire un petit jeu il y a déjà de quoi faire même si vous avez pas de quoi gérer les événements mais vous pouvez déjà simuler déjà pas mal de petites choses pour bien assimiler bien comprendre le fonctionnement des surfaces, des différentes formes qu'on peut manipuler, de tout ce qu'on peut dessiner et pourquoi pas charger des images. 

Là on a déplacé un rectangle mais on peut très bien déplacer une image parce que je rappelle que l'image se met dans un rectangle donc ça revient exactement au même. 

À bientôt pour la suite de cette séance et je vous dis que s'il y a des problèmes pour quoi que ce soit, n'hésitez pas à laisser des commentaires