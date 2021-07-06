# [41. Mesurer le temps](https://www.youtube.com/watch?v=04Unwn9stCM)

Bonjour à tous bienvenue sur la formation python pour la séance numéro 41 où nous allons voir comment mesurer le temps. 

Alors sur la formation vous avez déjà vu une vidéo dédié au module time de python donc le module natif qui permet justement de gérer un petit peu le temps mais là il s'agit d'un module time qui appartient bien à pygame donc qui est utilisable par pygame et qui n'a rien à voir avec le module de temps que l'on retrouve directement avec python. 

On va faire un petit peu le tour de quelques utilisations que l'on peut avoir de ce module-là qui est très important pygame parce que vous verrez très très vite dans votre développement 2D, vous aurez besoin justement de mesurer ce temps pour pouvoir gérer le taux de rafraîchissement de vos sprites donc de vos images tout simplement que vous allez afficher pour ne pas avoir de décalage ou des différences enfaite de vitesse pour vos animations par exemple et tous les affichages que vous voudrez gérer pour vos applications. 

On va regarder un petit peu tout ça, il y a beaucoup de choses à voir sur cette vidéo quand même donc je ne ferai évidemment pas le tour de tout ce qu'il y a mais au moins de tout ce qui me paraît essentiel, à connaître pour ce module là. 

Alors pour commencer je vous ai fait un petit code que vous êtes absolument capable de comprendre par rapport à tout ce qu'on a vu précédemment. 
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
blue_color = (132, 180, 255)
launched = True

pygame.init()
pygame.display.set_caption("Python #41 - mesurer le temps")
window_surface = pygame.display.set_mode(window_resolution)
arial_font = pygame.font.SysFont("arial", 36)
text = arial_font.render("Bonjour les abonnés !", True, blue_color)

window_surface.blit(text, [50, 50])
pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type ==pygame.QUIT:
           launched = False
```
Je me charge juste d'avoir un ensemble de variables pour la résolution de l'écran (640, 480), pour une couleur bleu (132, 180, 255). 

J initialise ma fenêtre sans problème avec set_mode().

Je fais simplement un chargement d'une police de caractères avec SysFont() propre au système. 

Je prépare un rendu de texte render() et j'affiche ce texte avec blit(text, [50, 50]) avant évidemment de faire l'affichage complet pour afficher la fenêtre et ensuite le texte par-dessus et cetera. 

Voilà pour tout ce qu'on a vu jusqu à présent ce qui n'est pas très compliqué. 

Alors voilà ce que ça donne au niveau affichage.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #41 - mesurer le temps         - # x   |
    |                                               |
    |   Bonjour les abonnés !                       |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
Voilà donc ça c'est purement de la révision par rapport à tout ce qu'on a vu précédemment, et donc si vous êtes perdu par rapport au code que vous avez ici n'hésitez pas à revenir sur les vidéos précédentes avant de regarder celle-ci, c'est qu'il y a encore des petites choses à voir avant de poursuivre la suite du cours en python. 

Donc on va fermer notre fenêtre et on va passer du coup à cette gestion du temps. 

Alors on a le module au niveau de python qui s'appelle time quand on fait un import time comme on l'avait déjà vu dans une vidéo dédiée à ça mais là on a un module qui est propre à pygame pour manipuler le temps. 

Alors la fonction, la méthode la plus simple pour manipuler tout ça, c'est de savoir le temps qui s'est écoulé depuis l'initialisation ici de pygame c'est à dire que quand on fait un pygame.init(), on initialise pygame et on peut éventuellement récupérer le temps qui s'est écoulé en fait depuis cette initialisation d'accord. 

Et pour récupérer ce temps-là, d'ailleurs on va le faire ici une seule fois … d'ailleurs je ne sais pas si on aura un rendu de quelque chose … on va faire par exemple un print() et on va demander d'afficher pygame.time à partir du module time, et on affichera get_ticks() comme ceci. 

get_ticks() va retourner un nombre en milli secondes du temps qui s'est écoulé.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
blue_color = (132, 180, 255)
launched = True

pygame.init()
pygame.display.set_caption("Python #41 - mesurer le temps")
window_surface = pygame.display.set_mode(window_resolution)
arial_font = pygame.font.SysFont("arial", 36)
text = arial_font.render("Bonjour les abonnés !", True, blue_color)

print(pygame.time.get_ticks())

window_surface.blit(text, [50, 50])
pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type ==pygame.QUIT:
           launched = False
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    517
```
Alors là si j'affiche au niveau de ma fenêtre, on va se rendre compte de la valeur retournée. Ici il nous retourne 419 millisecondes depuis l'initialisation de pygame donc c'est bien une valeur en millisecondes d'accord depuis ici le pygame.init(). 

Alors ça va pouvoir éventuellement changer en fonction parce que mon ordinateur ne va pas pouvoir gérer l'affichage exactement à la même vitesse tout le temps.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    561
```
Eh bien du coup on peut voir qu'en fonction de votre machine ça peut être plus ou moins lent donc ça peut dépendre. 

Sachant qu'ici c'est le nombre de millisecondes et avec 416 millisecondes on n'a même pas une seconde. 

Alors une seconde je rappelle fais 1000 millisecondes donc là en fait on n'a même pas une demi-seconde pour afficher le rendu de la fenêtre ici. 

Voilà pour cette partie qui est à connaître, le get_ticks() d'accord qu'on va éventuellement réutiliser un petit peu plus tard et je vous l'ai montré rapidement donc cette petite partie là à connaître qui est le temps écoulé depuis l'initialisation de pygame, et ça c'est très important. 

Alors on va voir comment l'afficher par la suite, on va travailler un petit peu là dessus parce que ça nous servira. 

Alors un autre point essentiel et ça on l'avait déjà vu avec le module propre à python, c'est de mettre en fait en pause notre programme et pour cela il y a 2 possibilités avec pygame. 

La première possibilité est en fait d'interrompre le processus c'est-à-dire avec votre système d'exploitation. Ce n'est pas propre un langage de programmation mais propre système au système Windows, GNU Linux ou Mac OS et cetera, Android ou autre, fonctionnent sur une base de processus. 

Pour tous vos programmes ils peuvent générer tout un tas de processus pour pouvoir fonctionner, et c'est au système de d'exploitation de gérer la priorité de ces processus, l'ordre dans lequel il va leur accorder de la mémoire pour fonctionner et c'est un petit peu comme une file d'attente c'est-à-dire qu'on a énormément de processus sur le système et il va gérer un ordonnancement en fait pour dire que pendant quelque petite millisecondes je fais tourner tel processus et ensuite je passe à un autre, ensuite je passe à un autre et cetera et cetera. 

Ça va évidemment très très vite pour nous parce que je trouve la question de millisecondes et cetera, et ça passe d'un processus à l'autre, et ça peut être des processus liés avec votre programme ici pygame comme ça peut être un processus lié à votre système Windows, votre système Linux, le fait que vous avez un navigateur web ouvert, votre éditeur de code ou je ne sais quoi c'est-à-dire n'importe quel programme qui tourne en tâche de fond sur votre système donc voilà comment ça fonctionne. 

Alors la première possibilité, c'est le processus qui concerne ici notre programme pygame de l'interrompre c'est-à-dire de le mettre en pause, de le faire dormir donc on parle en fait de faire dormir le processus en question. 

L'avantage de cette technique c'est qu'elle n'est absolument pas gourmandes en ressources, on va simplement mettre le processus en pause jusqu à le réveiller pour prendre la main sur notre programme, et pour faire ça avec le module time de pygame, on a évidemment une petite fonction pour ça. 

Alors comment est-ce que je peux l'utiliser pour que ce soit intéressant pour vous montrer ? Par exemple ici on a un texte en bleu "Bonjour les abonnés !" et on va endormir pendant un petit moment, donc on va faire un pygame.time.wait() qu'on va utiliser et wait() prend une valeur en milli secondes d'accord c'est très important ça travaille toujours en milli secondes donc si on veut une seconde on mettra 1000 mais nous on va mettre 2000 pour avoir 2 secondes. 
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    blue_color = (132, 180, 255)
    launched = True

    pygame.init()
    pygame.display.set_caption("Python #41 - mesurer le temps")
    window_surface = pygame.display.set_mode(window_resolution)
    arial_font = pygame.font.SysFont("arial", 36)
    text = arial_font.render("Bonjour les abonnés !", True, blue_color)

    pygame.time.wait(2000)

    window_surface.blit(text, [50, 50])
    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type ==pygame.QUIT:
                launched = False
```
Alors ce qu'on va faire, je vais faire un rendu avant de endormir le programme et un rendu après avoir endormi le programme. On va faire ça comme ça par contre le 2e rendu on va le mettre en rouge, on va faire red_color = (255,0, 0) donc ce que je vais dire en fait c'est qu'on affiche notre texte en bleu, on va attendre donc on va mettre en pause le processus pendant 2 secondes. 
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
blue_color = (132, 180, 255)
red_color = (255,0, 0)
launched = True

pygame.init()
pygame.display.set_caption("Python #41 - mesurer le temps")
window_surface = pygame.display.set_mode(window_resolution)
arial_font = pygame.font.SysFont("arial", 36)
text = arial_font.render("Bonjour les abonnés !", True, blue_color)
window_surface.blit(text, [50, 50])
pygame.display.flip()

pygame.time.wait(2000)

text = arial_font.render("Bonjour les abonnés !", True, red_color)
window_surface.blit(text, [50, 50])
pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type ==pygame.QUIT:
           launched = False
```
Juste pendant 2 secondes on n'aura plus la main sur le programme, on verra directement avec le curseur, et au bout de 2 secondes on verra directement le rendu de notre texte qui aura changé après avoir remis à jour l'affichage. Et cette fois-ci le rendu aura changé parce qu'on sera passé à une couleur rouge, on n'aura pas changé la position où ce genre de chose. 

Donc on y va et on exécute.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #41 - mesurer le temps         - # x   |
    |                                               |
    |   Bonjour les abonnés ! (bleu)                |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
    
    2 secondes...
    
    +-----------------------------------------------+
    | Python #41 - mesurer le temps         - # x   |
    |                                               |
    |   Bonjour les abonnés ! (rouge)               |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
Alors si on regarde, j'ai le petit sablier qui s'affiche sur ma fenêtre, et au bout de 2 secondes on a effectivement le rendu qui a changé.

Et au moment où le processus s'est endormi, je n'ai plus enfaite accès directement au programme. Voyez que je ne peux même pas fermer le programme tout de suite alors des fois le sablier va se mettre des fois il ne se met pas ce qui est un petit peu dommage mais ça c'est propre système. 

Voyez que je n'ai pas forcément la main dessus lorsque le processus est endormi, et au bout de 2 secondes ou 5 secondes je peux récupérer la main sur mon programme. 

Voilà comment ça fonctionne donc ça c'est la méthode la moins gourmandes, elle n'est pas forcément très très efficace parce qu'évidemment elle consomme que très peu de ressources mais dans beaucoup de cas elle sera largement suffisante. 

Si vous voulez juste endormir le processus, vous pourrez utiliser wait() pour faire cela mais maintenant si vous voulez quelque chose d'un peu plus puissant, plus précis, vous pourrez utiliser la puissance de votre processeur. 

Plutôt que ce soit un endormissement du processus, on peut demander au processeur de votre ordinateur de mettre véritablement le programme en pause et là ce sera beaucoup plus précis, beaucoup plus efficace mais du coup beaucoup plus gourmand en ressources évidemment, et pour cela vous avez juste à remplacer le wait() par un delay() donc ils ont fait ça très simplement avec pygame c'est-à-dire que c'est simplement un nom qui change mais la fonction, la méthode fonctionne de la même manière avec une valeur en milli secondes pour le temps d'endormissements. 

Et là si je fait delay().
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
blue_color = (132, 180, 255)
red_color = (255,0, 0)
launched = True

pygame.init()
pygame.display.set_caption("Python #41 - mesurer le temps")
window_surface = pygame.display.set_mode(window_resolution)
arial_font = pygame.font.SysFont("arial", 36)
text = arial_font.render("Bonjour les abonnés !", True, blue_color)
window_surface.blit(text, [50, 50])
pygame.display.flip()

pygame.time.delay(5000)

text = arial_font.render("Bonjour les abonnés !", True, red_color)
window_surface.blit(text, [50, 50])
pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type ==pygame.QUIT:
           launched = False
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #41 - mesurer le temps         - # x   |
    |                                               |
    |   Bonjour les abonnés ! (bleu)                |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
    
    5 secondes...
    
    +-----------------------------------------------+
    | Python #41 - mesurer le temps         - # x   |
    |                                               |
    |   Bonjour les abonnés ! (rouge)               |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
La méthode fonctionne de la même manière avec une valeur en millisecondes pour le temps d'endormissement et quand on compile c'est la même chose sauf que c'est le processeur qui a mis le programme en pause d'accord donc ce n'est pas la même efficacité en fait. 

Alors là pour l'exemple que je vous montre, on ne voit pas trop la différence parce que c'est juste un changement de couleur d'un texte donc ce n'est pas quelque chose de très gourmand en soi même pour de la 2D mais quand vous aurez véritablement à développer toute une application graphique, un jeu vidéo et gérer des animations, vous vous rendrez compte de la différence à ce moment-là sur un cas beaucoup plus concret. 

En tout cas sachez qu'il existe ces 2 choses-là wait() et delay() pour gérer en fait une pause directement dans notre programme de 2 manières différentes soit la manière qui va interrompre le processus c'est-à-dire qu'il va l'endormir simplement comme un sleep() en fait, comme si on faisait un time.sleep() avec le module natif de python. 

Et si vous utilisez delay() en fait vous allez véritablement utiliser le processeur pour faire en fait cette mise en pause de notre programme jusqu à récupérer la main dessus donc en fait reprendre les commandes de votre programme. 

Voilà comment ça se passe et c'était la première chose que je voulais vous montrer donc on a vu get_ticks() d'accord qui permet d'avoir le temps écoulé depuis l'initialisation de pygame.

Je vous avais dit en début de vidéo qu'il y allait y avoir pas mal de choses sur cette séance donc vous voyez qu'on a wait() et delay() qui vont permettre de interrompre, mettre en pause le code de notre programme jusqu à récupérer la main sur ce programme. 

Voilà comment ça fonctionne, alors ça c'était pour un petit peu à introduire cette vidéo et maintenant on va passer à une partie beaucoup plus importante et beaucoup plus intéressante. 

Notamment comment mesurer le temps parce que c'est un petit peu le titre de cette vidéo, alors comment va-t-on véritablement mesurer le temps ? Comment va-t-on travailler là-dessus ? 

Eh bien il y a un objet de horloge, un objet de temps que l'on va pouvoir manipuler avec pygame qui s'appelle clock d'accord c'est une classe clock qui va permettre de travailler sur un objet précis pour ça. 

Et pour l'utiliser … on va peut être un peu toute cette partie là et on va aller ici.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    blue_color = (132, 180, 255)
    red_color = (255,0, 0)
    launched = True

    pygame.init()
>
    pygame.display.set_caption("Python #41 - mesurer le temps")
    window_surface = pygame.display.set_mode(window_resolution)
    arial_font = pygame.font.SysFont("arial", 36)
    text = arial_font.render("Bonjour les abonnés !", True, blue_color)
    window_surface.blit(text, [50, 50])
    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type ==pygame.QUIT:
                launched = False
```
Une fois que j'ai initialisé pygame, je vais récupérer en fait dans une variable que je vais appeler clock où je vais récupérer un objet de temps donc spécial pour pygame. 

On va faire pygame.time.Clock() avec un C majuscule puisqu'il s'agit d'un constructeur. On appelle en fait le constructeur de Clock d'accord.

Et ça, ça va retourner dans clock un objet time par rapport à pygame. On est bien sur du pygame ici dans cette variable clock.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    blue_color = (132, 180, 255)
    red_color = (255,0, 0)
    launched = True

    pygame.init()
    
>   clock = pygame.time.Clock()
    
    pygame.display.set_caption("Python #41 - mesurer le temps")
    window_surface = pygame.display.set_mode(window_resolution)
    arial_font = pygame.font.SysFont("arial", 36)
    text = arial_font.render("Bonjour les abonnés !", True, blue_color)
    window_surface.blit(text, [50, 50])
    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type ==pygame.QUIT:
                launched = False
```
Et cet appel ici sera en fait à faire au début parce que c'est un petit peu pour initialiser pour dire qu'on veut un objet de temps qu'on va pouvoir manipuler, et ensuite par rapport à ce qui va se passer au cours de notre programme donc ça va être surtout dans la boucle principale, on va pouvoir faire des choses avec cet objet clock qui servira à quelque chose. 

Vous l'appelez comme vous voulez clock, clock_timer, vous mettez n'importe quoi encore une fois c'est une variable donc vous lui mettez le nom que vous voulez à partir du moment où il est suffisamment explicite quand vous relisez votre code. 

À partir de là, sur clock, on va pouvoir faire tout un tas de choses intéressantes pour le coup. 

Est-ce qu'il va être pour nous intéressant, c'est tout simplement de récupérer dans la boucle principale ici dans notre programme, et bien de dire qu'on va mettre à jour ce temps-là c'est à dire que là on a récupéré une première fois le temps.
```py
	pygame.time.Clock()
```
C'est-à-dire le temps qui s'était écoulé par rapport à l'initialisation de pygame, et au moment où on va appeler une méthode sur cet objet "clock", Eh bien on va mettre à jour l'horloge, mettre à jour cette valeur du temps qui s'est déroulée donc on parle bien de mesurer le temps ici. 

Et pour le faire on va le faire dans la boucle principale.
```py
    while launched:
        for event in pygame.event.get():
            if event.type ==pygame.QUIT:
                launched = False
```
Alors ça comme je l'ai dit précédemment c'est une boucle infinie qui va s'exécuter à l'infini jusqu à ce qu'on quitte le programme qui mettra fin à cette boucle donc à chaque tour de boucle on a effectivement du temps qui se passe d'accord. 

On va avoir un moment donné quand on va vouloir afficher des suites d'images pour faire des animation ou pour faire bouger un personnage ou des décors ou même simplement gérer du temps dans un jeu vidéo pour gérer par exemple des cycles jour nuit où ce genre de choses. 

Et bien de savoir exactement le temps qui passe pour le mesurer, de savoir le temps qui s'est passé entre un événement A et un événement B, ce genre de chose. 

Donc ici on va faire, pour se mettre dans la boucle principale directement dans lequel je vais reprendre mon objet clock et dire de mettre à jour avec la méthode tick().
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    blue_color = (132, 180, 255)
    red_color = (255,0, 0)
    launched = True

    pygame.init()
    
>   clock = pygame.time.Clock()
    
    pygame.display.set_caption("Python #41 - mesurer le temps")
    window_surface = pygame.display.set_mode(window_resolution)
    arial_font = pygame.font.SysFont("arial", 36)
    text = arial_font.render("Bonjour les abonnés !", True, blue_color)
    window_surface.blit(text, [50, 50])
    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type ==pygame.QUIT:
                launched = False

>       clock.tick()
```
La méthode tick() par rapport au temps qui s'est passé, je vais faire ce genre de chose. 

Et là où c'est intéressant, c'est que entre parenthèses par rapport à cette méthode, vous allez pouvoir passer un nombre de frames qu'on appelle tout simplement un taux de rafraîchissement et ce taux de rafraîchissement pour ceux qui font du jeu vidéo ça va vous parler, c'est tout simplement le nombre d'images que nous allons pouvoir avoir par seconde. 

Alors pourquoi ce taux est très important, par exemple quand vous allez commencer à gérer de l'animation ou autre, et si vous avez déjà commencé à le faire par rapport aux vidéos que je vous ai montré que vous ayez déjà fait vos petits programmes de votre côté, essayez d'afficher de petites images, de les animer et tout ça … il y en a peut-être parmi vous qui en essayant de déplacer des choses, des fois on avait des vitesse pas possible, des objets qui se déplacer à des vitesses énormissime et on arrivait pas trop à contrôler ça. 

Et surtout autre chose que vous avez peut-être remarqué, c'est que vous allez exécuter votre programme sur un ordinateur avec une certaine vitesse d'exécution, et puis vous allez le faire tourner sur un ordinateur très puissant et là alors la vitesse va complètement s'envoler. 

Ça risque de décoller votre programme va aller à une vitesse pas possible, ce sera évidemment ingérable. 

Imaginé dans un jeu vidéo parce que je ne vais pas vous faire l'exemple ce sera beaucoup trop long, je ne sais pas par exemple on pourrait imaginer qu'on tire sur un monstre dans un jeu et que le monstre se déplace de manière aléatoire, et bien sûr sur un PC assez moderne le monstre va se déplacer très rapidement donc on pourra facilement le suivre pour essayer de le viser et de tirer dessus. 

Et puis quelqu'un qui va se retrouver avec un PC beaucoup plus puissant, va se retrouver avec le monstre qui va se déplacer tellement tellement vite qui sera impossible de le toucher donc ce sera absolument injouable. 

Et quelqu'un à l'inverse, qui aura un ordinateur vraiment très très faible en puissance, on va avoir un monstre qui va se déplacer tellement tellement lentement qu'on aura l'impression que le jour est au ralenti. 

En bref tout ça pour vous dire qu'on va avoir des différences de frame rate ce qu'on appelle des taux de rafraîchissement.

Et c'est d'ailleurs c'est un problème pour ceux qui font du jeu vidéo parmi vous, c'est quelque chose que vous devez souvent rencontré dans certains jeux quand vous avez par exemple des chutes de FPS.

Parce que pour avoir un jeu un fluide, on demande un minimum du 30 FPS et maintenant on est même plutôt sur du 60 FPS parce qu'on a des résolutions d'écran beaucoup plus grandes et qui ont du coup besoin de beaucoup plus de fluidité pour qu'à l'œil nu, on ne se rendent pas compte que ça lag entre les différentes images des animations. 

Et donc ça peut arriver que des fois vous ayez des chutes de FPS à 20, à 10 et cetera et là alors à l'œil nu on s'en rend compte et du coup ce n'est pas agréable du tout. 

Et à l'inverse si on avait du 2000 FPS, 5000 FPS, on aurait tellement fait de fluidité que ça deviendrait absolument injouable, tout se déplacerait à une vitesse impossible donc éventuellement ça vous donnerait la nausée tellement que c'est n'importe quoi. 

Donc il faut gérer ce taux de rafraîchissement en fait sur vos animations donc là pour chaque tour de boucle parce que notre boucle … s'est bien passé exécuté à l'infini plusieurs fois mais la vitesse à laquelle les tours de boucles vont se faire dépend de la puissance de votre ordinateur. 

Moi ça va s'exécuter à une certaine vitesse sur mon ordinateur mais vous ce sera différente sur le vôtre, et si vous passez votre programme à un ami ou autre, lui il n'aura pas la même vitesse non plus donc on va avoir besoin de dire que tu vas mettre à jour ce timer "clock" mais selon un certain taux de rafraîchissement.

Tu ne vas pas non plus le mettre à jour s'il doit se mettre 1000 fois à jour dans la seonde ; tu ne vas pas le mettre 1000 fois à jour dans une seule seconde et puis 20 fois chez quelqu'un d'autre et puis encore un autre 500 fois. Ce serait vraiment n'importe quoi. 

Donc ici on va mettre le taux de rafraîchissement que l'on veut, et quand on veut quelque chose qui est un minimum fluides à l'œil nu, on mettra 30.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    blue_color = (132, 180, 255)
    red_color = (255,0, 0)
    launched = True

    pygame.init()
    
>   clock = pygame.time.Clock()
    
    pygame.display.set_caption("Python #41 - mesurer le temps")
    window_surface = pygame.display.set_mode(window_resolution)
    arial_font = pygame.font.SysFont("arial", 36)
    text = arial_font.render("Bonjour les abonnés !", True, blue_color)
    window_surface.blit(text, [50, 50])
    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type ==pygame.QUIT:
                launched = False

>       clock.tick(30)#30 images par secondes (30 fps)
```
Et ça c'est pour dire qu'on aura un taux de rafraîchissement de 30 images par secondes où ce qu'on appelle FPS (Frame Per Second). 

C'est vraiment un tour de rafraîchissement donc un frame rate si on veut employer le terme anglais. 

Et si on veut quelque chose d encore un peu plus fluide que l'on retrouve beaucoup dans les jeux vidéo actuels, et bien c'est du 60 FPS.
```py
    clock.tick(60)
```
Voilà donc on peut mettre ça comme ça. 

Voilà donc on va mettre cette information aussi et ce qui peut être utile aussi, c'est dépassé par une autre méthode de notre timer qui va permettre justement de récupérer le nombre de FPS donc c'est à dire que si on ne met pas un nombre dès le départ 30 ou 60, et admettons que je fais juste clock.tick() dans ma boucle principale qu'on va laisser en commentaire pour vous montrer on va faire print() dans lequel je vais écrire en f string comme ça.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    blue_color = (132, 180, 255)
    red_color = (255,0, 0)
    launched = True

    pygame.init()
    
>   clock = pygame.time.Clock()
    
    pygame.display.set_caption("Python #41 - mesurer le temps")
    window_surface = pygame.display.set_mode(window_resolution)
    arial_font = pygame.font.SysFont("arial", 36)
    text = arial_font.render("Bonjour les abonnés !", True, blue_color)
    window_surface.blit(text, [50, 50])
    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type ==pygame.QUIT:
                launched = False

>       #clock.tick(60)
>       print(f"")
```
OK donc ça f string c'est à partir de python 3.6 ou 3.7 donc si vous voyez que ça ne marche pas avec cette syntaxe vous utilisez la méthode format que vous connaissez déjà pour le texte. Je ne vous apprends rien normalement, vous savez le faire. 

Donc on fait ça print(f"") et vous mettez la valeur en FPS print(f"{} FPS").

Et la valeur qu'on va vouloir en FPS donc récupérer effectivement le taux de Frame par seconde, ça va être mon objet clock et dessus on va pouvoir utiliser une méthode qui s'appelle tout simplement get_fps(), on peut pas faire plus simple comme nom. 
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
blue_color = (132, 180, 255)
red_color = (255,0, 0)
launched = True

pygame.init()

clock = pygame.time.Clock()

pygame.display.set_caption("Python #41 - mesurer le temps")
window_surface = pygame.display.set_mode(window_resolution)
arial_font = pygame.font.SysFont("arial", 36)
text = arial_font.render("Bonjour les abonnés !", True, blue_color)
window_surface.blit(text, [50, 50])
pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type ==pygame.QUIT:
           launched = False

   #clock.tick(60)
   print(f"{clock.get_fps()} FPS")
```
Voilà ça va récupérer le taux de rafraîchissement par seconde, le nombre de frame donc le nombre d'images que nous avons chaque seconde. 

Donc on va faire ça et exécuter notre programme.

Par ailleurs on affichera avec du texte éventuellement ce sera mieux plutôt que de l'afficher dans un terminal mais peu importe.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    0.0 FPS
    0.0 FPS
    0.0 FPS
    0.0 FPS
    ...
```
Et là voilà, on ne voit que 0.0 FPS parce qu'il n'y a pas d'informations précises et on ne va pas mettre d'arguments par défaut à tick().

On recompile et voilà.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
blue_color = (132, 180, 255)
red_color = (255,0, 0)
launched = True

pygame.init()

clock = pygame.time.Clock()

pygame.display.set_caption("Python #41 - mesurer le temps")
window_surface = pygame.display.set_mode(window_resolution)
arial_font = pygame.font.SysFont("arial", 36)
text = arial_font.render("Bonjour les abonnés !", True, blue_color)
window_surface.blit(text, [50, 50])
pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type ==pygame.QUIT:
           launched = False

   clock.tick()
   print(f"{clock.get_fps()} FPS")
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    
    0.0 FPS
    10000.0 FPS
    5000.0 FPS
    1250.0 FPS
    285.71429443359375 FPS
    ...
```
Changement de réponse voilà vous voyez qu'on est carrément sur du 10000 FPS, nombre qui est absolument astronomique, énormissime qui est absolument ingérable donc vous vous n'aurez pas forcément la même chose selon l'ordinateur et cetera donc là vous voyez qu'on a un gros gros souci on n'a pas quelque chose de fix ou en tout cas stable. 

Donc on va préférer gérer un 60 FPS par exemple, et là du coup on va pouvoir contrôler ce qu'on a.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
blue_color = (132, 180, 255)
red_color = (255,0, 0)
launched = True

pygame.init()

clock = pygame.time.Clock()

pygame.display.set_caption("Python #41 - mesurer le temps")
window_surface = pygame.display.set_mode(window_resolution)
arial_font = pygame.font.SysFont("arial", 36)
text = arial_font.render("Bonjour les abonnés !", True, blue_color)
window_surface.blit(text, [50, 50])
pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type ==pygame.QUIT:
           launched = False

   clock.tick(60)
   print(f"{clock.get_fps()} FPS")
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
    0.0 FPS
    0.0 FPS
    0.0 FPS
    0.0 FPS
    0.0 FPS
    0.0 FPS
    0.0 FPS
    0.0 FPS
    0.0 FPS
    0.0 FPS
    61.349693298339844 FPS
    61.349693298339844 FPS
    61.349693298339844 FPS
    61.349693298339844 FPS
    61.349693298339844 FPS
    ...
    59.52381134033203 FPS
    59.52381134033203 FPS
    59.52381134033203 FPS
    59.52381134033203 FPS
    59.52381134033203 FPS
    59.52381134033203 FPS
    59.52381134033203 FPS
```
Voilà et comme vous le remarquez ce n'est pas pile à 60 d'accord, on va aller et on va limiter le nombre d'images à 60 frames par secondes donc si des fois vous avez par exemple trop de choses qui tournent sur votre système, automatiquement ça va réduire, c'est pour ça que des fois vous avez des ralentissements sur un jeu vidéo. 

En même temps que vous jouez à votre jeu vidéo, vous avez 15000 logiciels qui tournent en même temps, de la vidéo sur Internet ou autre, ou par exemple un téléchargement en route, il y a des chances que ça ralentisse ce nombre de rafraîchissement donc ça ça vous dit que ça ne va jamais dépasser sauf à quelques petits écarts près mais ça va fixer le nombre de frames à 60 donc on sera logiquement tout le temps un petit peu au dessus ou alors pile 60 ou bien légèrement au-dessus mais on ne va pas atteindre comme tout à l'heure 10000 FPS. 

Donc voyez comme pour le nombre 60, je n'ai pas précisé quelque chose de précis et bien du coup on va avoir 60 tours qui vont se passer toutes les secondes donc ce qui est déjà pas mal. 

Alors comment travailler avec du texte ici, on va le faire sur du texte C'est pourquoi je vous avais mis ça parce que je voulais l'afficher directement avec du texte. 

Alors je vais remettre dans ma boucle fini ma variable text ainsi que ma surface window_surface sans oublier de remettre un écran noir avec la méthode fill(). Et on va refaire black_color.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    black_color = (0, 0, 0)
    blue_color = (132, 180, 255)
    red_color = (255,0, 0)
    launched = True

    pygame.init()
    clock = pygame.time.Clock()

    pygame.display.set_caption("Python #41 - mesurer le temps")
    window_surface = pygame.display.set_mode(window_resolution)
    arial_font = pygame.font.SysFont("arial", 36)
    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type ==pygame.QUIT:
                launched = False

        clock.tick(60)
>       window_surface.fill(black_color)
>       text = arial_font.render("Bonjour les abonnés !", True, blue_color)
>       window_surface.blit(text, [50, 50])
        print(f"{clock.get_fps()} FPS")
```
On va refaire le rendu que je veux avec f string et donc on a plus besoin de print() mais par contre on aura besoin d'un flip() à la place donc à chaque tout et cetera et cetera.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    black_color = (0, 0, 0)
    blue_color = (132, 180, 255)
    red_color = (255,0, 0)
    launched = True

    pygame.init()
    clock = pygame.time.Clock()

    pygame.display.set_caption("Python #41 - mesurer le temps")
    window_surface = pygame.display.set_mode(window_resolution)
    arial_font = pygame.font.SysFont("arial", 36)
    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type ==pygame.QUIT:
                launched = False

        clock.tick(60)
        
>       window_surface.fill(black_color)
>       text = arial_font.render(f"{clock.get_fps()} FPS", True, blue_color)
>       window_surface.blit(text, [50, 50])
>       pygame.display.flip()
```
Normalement ça doit être bon, on est reparti et on charge voilà.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
black_color = (0, 0, 0)
blue_color = (132, 180, 255)
red_color = (255,0, 0)
launched = True

pygame.init()
clock = pygame.time.Clock()

pygame.display.set_caption("Python #41 - mesurer le temps")
window_surface = pygame.display.set_mode(window_resolution)
arial_font = pygame.font.SysFont("arial", 36)
pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type ==pygame.QUIT:
           launched = False

   clock.tick(60)
   
   window_surface.fill(black_color)
   text = arial_font.render(f"{clock.get_fps()} FPS", True, blue_color)
   window_surface.blit(text, [50, 50])
   pygame.display.flip()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #41 - mesurer le temps         - # x   |
    |                                               |
    |   61.349693298339844 FPS                      |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
Voilà on voit la valeur qui change, le changement est plutôt rapide et encore j'ai limité le nombre mais on pourrait avoir un taux de rafraîchissement qui changerait et varierait beaucoup plus. 

On voit que notre variable s'actualise très très très souvent donc ce n'est pas forcément très pratique mais on va pouvoir changer ça et améliorer. On terminera notre vidéo avec ça par rapport à un événement et par ailleurs ça nous permettra de revenir un petit peu sur les événements et donc rajouter une couche. 

Là je résume très rapidement, on a vu combien de temps s'était écoulé depuis qu'on avait initialisé pygame. On a vu également comment mettre en pause notre programme donc le processus en question soit via la méthode la moins gourmande soit directement via le processeur. Et on a regardé ensuite comment manipuler notre objet de timer "clock" pour pouvoir manipuler et contrôler le temps mais surtout de contrôler le nombre de rafraîchissement qui se produisent ici.
```py
    clock.tick(60)
```
Donc à quoi ça sert ? C'est que votre programme peu importe sur quel ordinateur vous êtes en train de l'exécuter, il tournera à la même vitesse donc les gens qui auront un gros PC n'aurons donc pas une vitesse astronomique et du coup un truc injouable et les gens qui auront un petit PC ne se retrouveront pas avec quelque chose de hyper lent donc tout le monde aura en fait la même vitesse d'exécution ou de rafraîchissement ou d'animation de tout ce qui se passe graphiquement sur votre programme. 

Alors ce qu'on va faire ici pour changer un petit peu ça et avoir quelque chose d'un peu plus propre. 

Alors ceux qui ment bête c'est qu'on a 15000 décimales alors que j'en ai peut-être pas besoin d'autant donc on va déjà passer à 2. 

Alors ça je ne sais pas si j'en avais parlé dans mes vidéos mais j'en profite surtout pour les f string, quand vous voulez pour les f string changer le nombre de décimales pour un nombre vous devez simplement utiliser la syntaxe ":.2f".
```py
    text = arial_font.render(f"{clock.get_fps()} FPS", True, blue_color)
    ---> text = arial_font.render(f"{clock.get_fps():.2f} FPS", True, blue_color)
```
Ceux qui font d'ailleurs du langage de programmation comme le c ou le c++, Java et cetera, vous connaissez bien cette notation là. 
```txt
    :.2f
```
D'ailleurs l'équivalent avec le print(), vous allez faire comme ça. Ensuite on mettait un pourcent suivi du nombre en question.
```py
    # print("%.2" % clock.get_fps())
```
Ce genre de chose.

Vous avez soit cette syntaxe là, soit vous avez ... si on veux être précis ... avec les f string et là on met juste ":.2f".
```py
    print("%.2" % clock.get_fps())
    print(f"{clock.get_fps():.2f}")
```
On met ":.2f" pour dire en fait qu'on a un float donc sur un nombre flottant, on a 2 chiffres après la virgule donc le petit point c'est pour dire ce qui est décimal juste après la virgule donc vous mettez cette notation et ça revient au même que de faire un print() avec un %, une notation un peu plus ancienne de python qui est toujours valide d'ailleurs. 

Alors à la base cette notation...
```py
    print("%.2" % clock.get_fps())
```
... j'en profite aussi en faisant une petite parenthèse, ça devait être rendu obsolète, cette notation devait être invalidée avec la mise à jour de python mais finalement ils ont décidé de la garder et même de la mettre sur certains modules qui sont beaucoup plus récents donc ça je vais en profiter pour le dire. 

Vous pouvez donc toujours utiliser cette notation même si j'avais prévu avec python 3 de la retirer et donc de la rendre obsolète mais vous pouvez continuer de l'utiliser si vous voulez même si je trouve que ce n'est pas forcément la plus pratique. 

Donc on va faire ça comme ça et normalement si je n'ai pas dit de bêtises on devrait être à 2 chiffres après la virgule.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
black_color = (0, 0, 0)
blue_color = (132, 180, 255)
red_color = (255,0, 0)
launched = True

pygame.init()
clock = pygame.time.Clock()

pygame.display.set_caption("Python #41 - mesurer le temps")
window_surface = pygame.display.set_mode(window_resolution)
arial_font = pygame.font.SysFont("arial", 36)
pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type ==pygame.QUIT:
           launched = False

   clock.tick(60)
   
   window_surface.fill(black_color)
   text = arial_font.render(f"{clock.get_fps():.2f} FPS", True, blue_color)
   window_surface.blit(text, [50, 50])
   pygame.display.flip()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #41 - mesurer le temps         - # x   |
    |                                               |
    |   61.35 FPS                                   |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
On passe quand même à 2 chiffres après la virgule et c'est quand même bien mieux d'ailleurs on aurait pu même directement caster en integer pour n'avoir que les unités, le décimal n'était pas forcément intéressant. 

Quand vous regardez dans les jeux qu'on affiche le nombre de FPS, on vous montre toujours une valeur entière, on ne vous montre jamais de décimales sauf certains jeux assez spécifiques mais bien souvent c'est juste la valeur entière donc vous faites comme vous voulez en tout cas. 

Et après comme je n'ai pas forcément envie que ça se mette à jour plusieurs fois, en plus ça va dépendre également de votre machine, ça peut être mis à jour plus rapidement aussi mais ce n'est pas forcément utile, Eh bien je peux limiter ça. 

Et pour limiter ça on va repartir du coup sur un type d'évènement que je n'avais pas forcément montré en vidéo mais là ça va être l'occasion, c'est l'événement ici. 
```txt
    USEREVENT       code
```
Voilà vous avez le USEREVENT, c'est simplement pour dire que quand on va avoir un événement particulier qu'on va pouvoir nous gérer, on va pouvoir faire un certain nombre de choses d'accord. 

Et moi ce que je veux en fait c'est tout simplement de dire quand j'ai eu en fait 2 secondes qui se sont passées, je vais pouvoir mettre à jour mon affichage d'accord ça ne va pas forcément le faire n'importe quand et ça ça peut être assez utile donc ce qu'on va faire et je pense que ça va être une partie qui va être intéressante. 

Déjà on va définir un timer qu'on met également après l'initialisation, on va mettre pygame.time.set_timer() et ça c'est important si vous ne le mettez pas ça ne marchera pas évidemment.
```py
    pygame.time.set_timer()
```
Le timer je vais le mettre sur ce type d'évènement là, alors c'est pygame.USEREVENT parce que je rappelle que je n'importe pas les locals parce que je préfère afficher à chaque fois le nom du module, question de préférence mais vous faites comme vous voulez.
```py
    pygame.time.set_timer(pygame.USEREVENT, ...)
```
Donc ça c'est bon et on précise ensuite combien y a-t-il de millisecondes. Moi je veux par exemple que le timer se déclenche toutes les 2 secondes parce que je voudrais pouvoir gérer l'actualisation du nombre de FPS que toutes les 2 secondes.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    black_color = (0, 0, 0)
    blue_color = (132, 180, 255)
    red_color = (255,0, 0)
    launched = True

    pygame.init()
    clock = pygame.time.Clock()
    
>   pygame.time.set_timer(pygame.USEREVENT, 2000)

    pygame.display.set_caption("Python #41 - mesurer le temps")
    window_surface = pygame.display.set_mode(window_resolution)
    arial_font = pygame.font.SysFont("arial", 36)
    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type ==pygame.QUIT:
                launched = False

        clock.tick(60)
        
        window_surface.fill(black_color)
        text = arial_font.render(f"{clock.get_fps():.2f} FPS", True, blue_color)
        window_surface.blit(text, [50, 50])
        pygame.display.flip()
```
Donc je mets un timer et je dis que voilà sur USEREVENT donc il va déclencher un USEREVENT toutes les 2 secondes, c'est ça que ça veut dire pour être précis. 

set_timer() c'est toutes les 2000 millisecondes donc toutes les 2 secondes tu déclenche, tu dis hop et t'envoie un USEREVENT donc ce n'est pas un événement clavier ou souris ou manette de jeu et cetera, c'est tout simplement un USEREVENT d'accord donc c'est juste un événement qui s'est produit grâce à ça. 

Et du coup je vais pouvoir le récupérer ici dans ma boucle.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    black_color = (0, 0, 0)
    blue_color = (132, 180, 255)
    red_color = (255,0, 0)
    launched = True

    pygame.init()
    clock = pygame.time.Clock()
    
>   pygame.time.set_timer(pygame.USEREVENT, 2000)

    pygame.display.set_caption("Python #41 - mesurer le temps")
    window_surface = pygame.display.set_mode(window_resolution)
    arial_font = pygame.font.SysFont("arial", 36)
    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type ==pygame.QUIT:
                launched = False
>           elif event.type == pygame.USEREVENT:

        clock.tick(60)
        
        window_surface.fill(black_color)
        text = arial_font.render(f"{clock.get_fps():.2f} FPS", True, blue_color)
        window_surface.blit(text, [50, 50])
        pygame.display.flip()
```
Je serai alors que 2 secondes ceci écoulé à partir du moment où j'arrive dans cette condition "elif" et ça c'est bien pour moi parce que du coup, je vais pouvoir gérer ici mon affichage donc je n'ai plus qu'a déplacer mon affichage dans elif.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
black_color = (0, 0, 0)
blue_color = (132, 180, 255)
red_color = (255,0, 0)
launched = True

pygame.init()
clock = pygame.time.Clock()

pygame.time.set_timer(pygame.USEREVENT, 2000)

pygame.display.set_caption("Python #41 - mesurer le temps")
window_surface = pygame.display.set_mode(window_resolution)
arial_font = pygame.font.SysFont("arial", 36)
pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type ==pygame.QUIT:
           launched = False
       elif event.type == pygame.USEREVENT:
           window_surface.fill(black_color)
           text = arial_font.render(f"{clock.get_fps():.2f} FPS", True, blue_color)
           window_surface.blit(text, [50, 50])
           pygame.display.flip()
   
   clock.tick(60)
```
Comme ça je fais mes mises à jour de mon affichage que toutes les 2 secondes donc je n'ai pas envie que ça se fasse 3 fois en une seconde ou autre de manière un peu aléatoire mais là ça va se faire que toutes les 2 secondes. 

Alors ça ce n'est vraiment pas obligatoire c'est vraiment un petit bonus que je vous donne dans cette petite vidéo comme on arrive quand même à la fin du cours python, je vous donne ainsi des petits bonus pour terminer ça, c'est vraiment du plus. 

Alors dans l'idéal on devrait faire un premier affichage et ensuite on met à jour donc là ça veut dire que ça va s'afficher au bout de 2 secondes mais ce n'est pas grave, et vous allez voir quoi toutes les 2 secondes on a la mise à jour qui se fait.
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #41 - mesurer le temps         - # x   |
    |                                               |
    |   61.35 FPS                                   |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
    
    2 secondes...
    
    +-----------------------------------------------+
    | Python #41 - mesurer le temps         - # x   |
    |                                               |
    |   59.35 FPS                                   |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
Toutes les 2 secondes on a la mise à jour qui se fait donc ça c'est vous qui gérez en fonction, c'est plus pratique et ça évite forcément d'avoir quelque chose qui se met à jour tout le temps donc ça c'était vraiment un bonus ce n'était pas du tout prévu dans la vidéo à la base mais je me suis dit après tout pourquoi pas, ça vous permet de revoir après tout la manipulation de temps et de voir en plus une autre possibilité avec USEREVENT que je n'avais pas forcément montré en vidéo comme ça on a un cas d'utilisation qui est plutôt pratique.

On fait comme ça, alors USEREVENT ça aurait pu être un autre type d'évènement, on peut faire ça sur n'importe quel événement puisqu'en fait quand on fait ça…
```py
    for event in pygame.event.get():
```
… on récupère en fait tous les événements qui surviennent, comme je vous l'avais dit c'est une file d'attente donc une file de évènement, et on récupère tout. Ce n'est pas qu'on récupère les événements toutes les 2 secondes, non c'est que dès qu'il y a un événement qui arrive, qui survient, qui se produit, on récupère. 

Et là ça permet de dire que quand on veut un événement en particulier, on ne le récupère pas n'importe quand sinon ce serait un petit peu casse-pied, celui là on le veut que toutes les 2 secondes et du coup ici on va rentrer dans ce elif toute les 2 secondes.
```py
        elif event.type == pygame.USEREVENT:
```
On va rentrer dans ce elif que toutes les 2 secondes donc cet affichage là.
```py
        #...
            window_surface.fill(black_color)
            text = arial_font.render(f"{clock.get_fps():.2f} FPS", True, blue_color)
            window_surface.blit(text, [50, 50])
            pygame.display.flip()
        #...
```
Cette mise à jour de l'affichage ne se ferra que toutes les deux secondes.

Et ça c'est bien en lien avec ce que nous voulions faire au départ.

Évidemment si vous mettez 15 FPS, on aura un changement pour beaucoup de choses.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
black_color = (0, 0, 0)
blue_color = (132, 180, 255)
red_color = (255,0, 0)
launched = True

pygame.init()
clock = pygame.time.Clock()

pygame.time.set_timer(pygame.USEREVENT, 2000)

pygame.display.set_caption("Python #41 - mesurer le temps")
window_surface = pygame.display.set_mode(window_resolution)
arial_font = pygame.font.SysFont("arial", 36)
pygame.display.flip()

while launched:
    for event in pygame.event.get():
        if event.type ==pygame.QUIT:
            launched = False
        elif event.type == pygame.USEREVENT:
            window_surface.fill(black_color)
            text = arial_font.render(f"{clock.get_fps():.2f} FPS", True, blue_color)
            window_surface.blit(text, [50, 50])
            pygame.display.flip()
    
    clock.tick(15)
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html

    +-----------------------------------------------+
    | Python #41 - mesurer le temps         - # x   |
    |                                               |
    |   14.97 FPS                                   |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
    
    2 secondes...
    
    +-----------------------------------------------+
    | Python #41 - mesurer le temps         - # x   |
    |                                               |
    |   15.06 FPS                                   |
    |                                               |
    |                                               |
    |                                               |
    +-----------------------------------------------+
```
Voilà alors si vous voulez tester ça, je ne voulais pas le faire dans cette vidéo sinon ça aurait fait quelque chose de beaucoup trop long et je trouve que la vidéo est déjà suffisamment longue. 

N'hésitez pas à faire un déplacement d'une forme, d'un Rect, une image ou l'autre et de tester justement avec la gestion des FPS, de voir ce qui se passe avec les déplacements lorsque vous ne limitez pas le nombre de FPS et ensuite quand vous le limiter en fonction de la valeur que vous mettez, il faut rentrer très vite de ce que ça importe au niveau de l'utilisation et pourquoi c'est important de savoir faire ça sur un programme en 2D. 

C'est absolument obligatoire d'avoir ce genre de chose sinon en fonction de la machine sur lequel vous allez exécuter votre programme, il n'aura pas du tout le même comportement, et ça ce n'est absolument pas tolérable quand on fait de la 2D. 

Voilà pour cette partie, je pense que j'ai fait le tour de ce que je voulais vous montrer. 

De toute façon on n'a vu beaucoup beaucoup de choses pour la manière de mesurer le temps avec pygame. 

Pour moi ça me semble suffisamment complet et puis je veux dire que l'événement USEREVENT n'était pas forcément prévu mais du coup ce n'est pas plus mal comme ça, comme ça vous aurez un petit truc en plus et ce sera vu. 

D'ailleurs si vous voulez le noter, noter ce petit usage ou reprendre le code tel que je l'ai mis ici pour vous faire un petit peu une idée. 

Si par exemple un jour vous voulez faire un jeu et vérifier le nombre de FPS pour voir si le jeu est fluide parce que si vous mettez par exemple un jeu à 60 FPS, et que d'un coup en chargeant une map ou un personnage, sa chute à 15 FPS, là vous pourrez vous dire que votre code n'est pas optimisé et qu'il y a un problème.

Ça permet aussi de voir au niveau de votre 2D, si vos affichages sont optimisés ou non. 

Si vous avez mis du 60 FPS et que ça chute à 15, c'est qu'il y a un problème et par ailleurs ça permet quand même de faire un petit peu de débogage sur tout ce qui est graphique. 

Et je vais vous laisser du coup avec ça, on va se retrouver pour une prochaine vidéo et on va s'arrêter là. 

La prochaine vidéo ce sera la dernière du cours avant la petite vidéo de conclusion habituelle et on verra comment jouer du son voilà. 

Je vais terminer le chapitre pygame et toute l'information sur python avec tout simplement une bonne vidéo donc elle sera assez longue aussi sur comment on peut jouer du son, on jouera des petite musique et tout ça pour voir comment manipuler ça avec pygame. 

C'est très simple aussi à prendre en main mais il y a quand même pas mal à voir donc la vidéo sera pas mal longue mais au moins on terminera le chapitre avec ça. 

J'espère que ça vous a plu, si vous avez des questions des remarques ou des petites choses que vous n'avez pas forcément comprisent, qui sont un petit peu compliqué à assimiler, et bien n'hésitez pas à le faire savoir dans les commentaires et je viendrais vous répondre. 

Du coup on va se retrouver très très bientôt de toute façon pour la prochaine séance sur comment jouer des sons avec pygame voilà. 

À bientôt tout le monde et on se retrouve du coup pour une prochaine vidéo sur cette formation.

Ciao