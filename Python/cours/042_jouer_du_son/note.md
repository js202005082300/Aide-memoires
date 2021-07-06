# [42. Jouer du son](https://www.youtube.com/watch?v=qq8W5tMYb4w)
*Celtic: ffmpeg -i Aislinn_-_Moorlough_shore.mp3 celtic.ogg*  
*Son: ffmpeg -i parrot.wav song.ogg*

Bonjour on se retrouve sur la 42e vidéo sur python pour voir comment jouer des sons. 

C'est la dernière vidéo du cours parce que la vidéo 43 sera la vidéo de conclusion donc j'ai pas mal de petites choses à vous montrer voilà. 

Je ne vous montrerai pas tout évidemment mais on va avoir quand même pas mal de fonctions et de méthodes avec 2 modules qui permet justement de jouer nos fichiers audio avec pygame. 

Alors le premier module que nous allons voir, est le module principal qui est le module mixer qui va permettre de charger nos fichiers audio pour pouvoir jouer nos sons. 

Pour pouvoir jouer nos sons, on va faire le plus simple possible avec ce système là, le premier est d'utiliser une variable. 

Moi j'ai quelques fichiers dans mon dossier et je vais charger celtic.ogg. Je vais passer par celtic_song = et je vais passer par le module pygame.mixer, et on va appeler le constructeur Sound avec S en majuscule pour avoir un objet de classe Sound() à qui on passe le nom du fichier "celtic.ogg" directement.
```py
    #coding:utf-8
    import pygame
    
    window_resolution = (640, 480)
    launched = True
    
    pygame.init()
    pygame.display.set_caption("Python #42 - jouer du son")
    window_surface = pygame.display.set_mode(window_resolution)
    
>   celtic_song = pygame.mixer.Sound("celtic.ogg")
    
    pygame.display.flip()
    
    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
```
Je vous recommande quand vous travaillez sur des fichiers audio pour n'importe quel langage de programmation d'ailleurs en espérant qu'il n'y ait pas des problèmes de lecture ou des soucis suivant les pays parce qu'il y a certains formats de fichiers audio qui sont brevetés ou en tout cas qui ne sont pas autorisés, que certains gens ne peuvent pas utiliser dans leur pays. 

Si vous ne voulez aucun problème et que vous voulez travailler sur des fichiers audio non compressés dit qualité CD ou qualité studio, on va travailler sur du format WAV. 

Et si on veut du format compressé comme le MP3 par exemple on travaillera plutôt sur le format OGG. 

Donc si vous avez des fichiers MP3 seulement ou autre et que vous voulez les convertir, vous pouvez utiliser un convertisseur pour le faire. 

D'ailleurs j'ai publié une vidéo d'aide dans ma playlist général sur la conversion de fichiers audio et vidéo avec l'outil FFmpeg si ça vous interesse donc vous pouvez toujours faire ces conversion-là.

Je résume, on va passer par le module mixer, on appelle le constructeur Sound() en chargeant notre fichier OGG qu'on va stocker du coup dans une variable, et après on n'a plus qu à utiliser des méthodes de cet objet de classe Sound. 

Le son ici celtic_song, on a une première méthode très simplement qui est la méthode play().
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
launched = True

pygame.init()
pygame.display.set_caption("Python #42 - jouer du son")
window_surface = pygame.display.set_mode(window_resolution)

celtic_song = pygame.mixer.Sound("celtic.ogg")
celtic_song.play()

pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
Donc ça c'est la méthode la plus simple et la plus rapide pour jouer un son avec pygame via le module mixer. 

Alors il y a 2 particularités, on va voir qu'il y a aussi déjà pas mal d'autres méthodes aussi que vous allez pouvoir utiliser propre à un son, par exemple celtic_song. 

D'ailleurs je vais vous les noter ici comme ça vous les aurez sous la main donc on travaille toujours sur un `<sound>`, quelque chose qui est de classe `<sound>.play()` et on a donc la méthode play() qui prend des paramètres que l'on n'a pas utilisé parce qu'elle a des paramètres par défaut. Le premier paramètre qui peut vous servir, c'est le paramètre de répétition de la musique (loop) qui par défaut est à 0 c'est à dire que si vous ne mettez pas c'est à 0 c'est à dire qu'il n'y aura aucune répétition de la musique. La musique sera donc jouée une seule fois et c'est tout, si vous voulez que la musique se répète au moins une fois, il faudra mettre par exemple 1, play(1).
```py
    """
    <Sound>.play(loop = 0, ...)
    """
```
Si vous mettez 1, la musique sera jouée 2 fois. Une première fois et une répétition, c'est pour ça qu'on peut mettre 1 ici comme argument. 

Si vous mettez 2, la musique sera joué 3 fois puisqu'elle va être joué qu'une seule fois et répété 2 fois donc attention à l'usage de ce paramètre là. 

Ensuite on va avoir le temps qui va être le paramètre pour définir le temps maximum jusqu ou le son va être joué donc en milli secondes, vous allez pouvoir dire tout simplement est-ce que je dois lire une seule minute de mon son ou est-ce que j'en lis que 2, ce genre de chose, et du coup vous pourrez travailler sur ce paramètre là si vous voulez aussi. Ça peut servir pour ça. Par défaut, le time est à 0. 
```py
    """
    <Sound>.play(loop = 0, time = 0, ...)
    """
```
On a ensuite le fadein et ça c'est très important qui est à 0 aussi par défaut qui est tout simplement un effet de fondu d'ouverture. 

Un fondu d'ouverture si vous ne savez pas ce que c'est, vous savez peut-être que c'est mais vous ne connaissez pas le terme plus technique, c'est tout simplement la gestion du volume à l'ouverture d'un fichier son c'est-à-dire que le nombre de secondes et ici ce sont des milli secondes plus exactement que le fichier va prendre pour passer d'un volume de 0% vers un volume de 100%. 
```py
    """
    <Sound>.play(loop = 0, time = 0, fadein = 2000)
    """
```
Donc si vous mettez 2000, le son passera de 0 à 100% en 2 secondes au moment où le fichier se charge donc on peut faire ce genre de chose. 

Admettons je peux faire ce genre de chose, alors une lecture par défaut ça va faire ça où on entend que le son est déjà 100 pourcent au démarrage de la musique. Et si je fais par exemple play(0, 0, 5000).  
```py
#coding:utf-8
"""
<Sound>.play(loop = 0, time = 0, fadein = 2000)
"""
import pygame

window_resolution = (640, 480)
launched = True

pygame.init()
pygame.display.set_caption("Python #42 - jouer du son")
window_surface = pygame.display.set_mode(window_resolution)

celtic_song = pygame.mixer.Sound("celtic.ogg")
celtic_song.play(0, 0, 5000)

pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
Vous allez voir qu'il vous faut 5 secondes pour que le volume de la musique Celtic passe à 100%. 

Voyez que la musique démarre et petit à petit en 5 secondes, le volume augmente à 100%.

Voilà c'est ce qu'on appelle un fondu d'ouverture donc ce qu'on appelle en général le fadein c'est le terme qu'on emploie partout, fadein et fadeout qui est l'inverse la c'est un fondu de fermeture. 

fadeout, vous connaissez bien en musique, c'est par exemple quand vous avez une chanson où le volume se réduit à la fin de la musique. 

Vous vous avez certainement des chansons que vous écoutez, où il y a justement cet effet de fadeout donc de fondu en fermeture de musique. 

Voilà pour les 3 paramètres qui sont optionnels, ils ont tous des valeurs par défaut donc on peut très bien lire par défaut le son qui n'aura donc aucune répétition, il sera lu entièrement et il n'y aura aucun effet de fondu d'ouverture au moment de sa lecture donc ça c'est une chose à savoir. 

Il y a bien sûr d'autres méthodes que vous allez pouvoir utiliser, si on peut lire notre fichier on va pouvoir évidemment le stopper d'accord, on peut stopper notre fichier il n'y a pas de problème là-dessus. 
```py
    """
    <Sound>.play(loop = 0, time = 0, fadein = 2000)
           .stop()
    """
```
Je peux vous montrer aussi qu'on peut régler le fadeout() justement avec une méthode donc pareil c'est une valeur en milli secondes d'accord pour le fadeout() ici. 
```py
    """
    <Sound>.play(loop = 0, time = 0, fadein = 2000)
           .stop()
           .fadeout(ms)
    """
```
Voilà ça ça peut être utile de l'avoir. 

Et on a la gestion du volume, par exemple si vous voulez modifier le volume vous-même, vous allez pouvoir mettre une valeur entre 0.0 donc c'est un son de 0% jusqu'à 1.0 qui correspond à 100% d'accord.
```py
    """
    <Sound>.play(loop = 0, time = 0, fadein = 2000)
           .stop()
           .fadeout(ms)
           .set_volume(0.0 -> 1.0)
    """
```
Donc si vous voulez un son à 50%, vous mettrez 0.5. 

On peut bien sûr récupérer le volume, évidemment s'il y a un set_volume(), il y a alors un get_volume() pour pouvoir récupérer ça.
```py
    """
    <Sound>.play(loop = 0, time = 0, fadein = 2000)
           .stop()
           .fadeout(ms)
           .set_volume(0.0 -> 1.0)
           .get_volume()
    """
```
Et on peut éventuellement et ça je vous le donne rapidement parce que c'est bien à savoir, la longueur donc la durée de la musique en secondes.
```py
    """
    <Sound>.play(loop = 0, time = 0, fadein = 2000)
           .stop()
           .fadeout(ms)
           .set_volume(0.0 -> 1.0)
           .get_volume()
           .get_length()
    """
```
Si par exemple vous avez une musique qui dure 1 minute 20 donc vous aurez 80 secondes pour la durée de la musique voilà.

Donc ça ce sont quelques méthodes, il en existe d'autres aussi mais je ne vous montre que celle-ci pour gérer notre son à part. 

Alors on peut très bien lire et charger plusieurs fichiers en même temps, ce serait un peu bizarre mais on peut le faire, par exemple ici je vais prendre un son.ogg donc on va juste faire ça.
```py
#coding:utf-8
"""
<Sound>.play(loop = 0, time = 0, fadein = 2000)
      .stop()
      .fadeout(ms)
      .set_volume(0.0 -> 1.0)
      .get_volume()
      .get_length()
"""
import pygame

window_resolution = (640, 480)
launched = True

pygame.init()
pygame.display.set_caption("Python #42 - jouer du son")
window_surface = pygame.display.set_mode(window_resolution)

celtic = pygame.mixer.Sound("celtic.ogg")
song = pygame.mixer.Sound("song.ogg")
celtic.play()
song.play()

pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
Donc si je démarre mon programme, les 2 musique se démarre en même temps donc ce n'est pas très agréable bien sûr parce que tout se lit en même temps mais ça fonctionne. 

Le truc c'est que au niveau de mixer, on va pouvoir gérer chaque flux un par un d'accord donc mixer gère chaque flux un par un donc pour certaines commandes … vous voyez qu'on a stocké notre fichier son dans des variables donc on peut sans problème démarrer comme on va pouvoir stopper une chanson en particulier. 

D'ailleurs si je gère ça par rapport à des évènements, on va réviser nos évènements pour le coup, on va faire un elif event.type == pygame.KEYDOWN suivi d'un if event.key == pygame.K_SPACE. Je vais par exemple dire que le son que j'ai joué ici song.play() c'est-à-dire mon 2e son, lui je vais le stopper.
```py
#coding:utf-8
"""
<Sound>.play(loop = 0, time = 0, fadein = 2000)
      .stop()
      .fadeout(ms)
      .set_volume(0.0 -> 1.0)
      .get_volume()
      .get_length()
"""
import pygame

window_resolution = (640, 480)
launched = True

pygame.init()
pygame.display.set_caption("Python #42 - jouer du son")
window_surface = pygame.display.set_mode(window_resolution)

celtic = pygame.mixer.Sound("celtic.ogg")
song = pygame.mixer.Sound("song.ogg")
celtic.play()
song.play()

pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
       elif event.type == pygame.KEYDOWN:
           if event.key == pygame.K_SPACE:
               song.stop()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
Si j'appuie sur la barre d'espace, je stop la 2e musique mais la première continue donc vous voyez que chaque flux est géré individuellement.

Mixer va traiter un son un à la fois, quand on utilise ces commandes là en tout cas directement sur un objet de type Sound, de classe Sound. 

Voilà une possibilité. 

On peut utiliser toutes ces méthodes là mais admettons que je veux mettre en pause ce qui est lu. Là pour le coup, on ne va pas distinguer les différents sons qui sont joués, tout va être géré par le module mixer. 

Et le module mixer possède quelques fonctions sur lequel nous allons pouvoir travailler notamment une fonction pour stopper tout. 

On peut très bien faire stopper toutes les chansons qui passent donc en faisant un pygame.mixer.stop() et là vous voyez qu'on n'utilise pas sur une variable qui est de classe Sound mais on l'utiliser directement sur tout le module mixer. 

Donc là on va pas pouvoir dire par exemple, je veux stopper celle-là où celle-là. 

Si on veut stopper qu'un seul de son on fera comme on a fait tout à l'heure mais si on veut tout stopper, tout ce que mixer est entrain de lire, on va faire comme ça.
```py
#coding:utf-8
"""
<Sound>.play(loop = 0, time = 0, fadein = 2000)
      .stop()
      .fadeout(ms)
      .set_volume(0.0 -> 1.0)
      .get_volume()
      .get_length()
"""
import pygame

window_resolution = (640, 480)
launched = True

pygame.init()
pygame.display.set_caption("Python #42 - jouer du son")
window_surface = pygame.display.set_mode(window_resolution)

celtic = pygame.mixer.Sound("celtic.ogg")
song = pygame.mixer.Sound("song.ogg")
celtic.play()
song.play()

pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
       elif event.type == pygame.KEYDOWN:
           if event.key == pygame.K_SPACE:
               pygame.mixer.stop()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
Si je cherche mon programme, tout se lit. J'active l'espace, la barre d'espace et là tout se stop. 

On peut par contre mettre par ce système là tout mettre en pause, c'est la même chose mais avec pause() simplement et si on veut redémarrer on va mettre par exemple elif event.key == pygame.K_p: dans lequel on va mettre la touche p parce que je n'ai pas forcément d'autres idées. Et si on rentre dans la conviction on fait pygame.mixer et l'inverse de la mise en pause donc la reprise de la musique là où elle s'était arrêtée c'est unpause() voilà.
```py
#coding:utf-8
"""
<Sound>.play(loop = 0, time = 0, fadein = 2000)
      .stop()
      .fadeout(ms)
      .set_volume(0.0 -> 1.0)
      .get_volume()
      .get_length()
"""
import pygame

window_resolution = (640, 480)
launched = True

pygame.init()
pygame.display.set_caption("Python #42 - jouer du son")
window_surface = pygame.display.set_mode(window_resolution)

celtic = pygame.mixer.Sound("celtic.ogg")
song = pygame.mixer.Sound("song.ogg")
celtic.play()
song.play()

pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
       elif event.type == pygame.KEYDOWN:
           if event.key == pygame.K_SPACE:
               pygame.mixer.pause()
           elif event.key == pygame.K_p:
               pygame.mixer.unpause()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
Voilà je recharge, les 2 musiques sont chargées, elles sont lues. J'appuie sur la barre d'espace la tout est mis en pause, et ensuite j'appuie sur la touche p et tout reprend où ça a été laissé en pause en fait. 

Voilà c'est vraiment une mise en pause et une relecture, une reprise en fait de la lecture. 

Donc ça ça va véritablement se faire sur l'ensemble d'accord je ne pourrais pas dire de mettre en pause que celtic ou song. 

On est obligé de gérer la mise en pause ou la reprise des sons sur la totalité sur tout ce qui est lu, en tout cas tout ce qui est géré par le module mixer. 

Alors il y a d'autres choses, on peut gérer également le fondu de fermeture complet de tous les sons. Il y a une fonction fadeout() qu'on peut utiliser sur le module mixer si vous voulez. 

Voilà pour ça stop(), pause(), unpause(), il n'y a pas grand grand chose mais en tout cas pas mal de quoi faire donc ça c'est vraiment pour pouvoir gérer vos sons à part et pour gérer surtout les sons un à un donc on va gérer un seul flux à la fois, c'est comme ça que fonctionne le mixer. 

Nous avons également un autre module qui est en fait un sous-module de mixer c'est-à-dire qu'il est à l'intérieur du module mixer, qui est le module music. 

Et music va fonctionner comme du streaming, par exemple lorsque vous regardez cette vidéo sur youtube, votre navigateur n'a pas eu besoin de charger la totalité de la vidéo avant même de pouvoir la lire d'accord il a juste besoin de commencer à télécharger la vidéo pour que vous puissiez déjà la visionner donc ça s'appelle du streaming. 

Et on va retrouver exactement la même chose en audio c'est-à-dire qu'on ne va pas attendre que tout le fichier audio soit chargé avant de le lire. L'avantage c'est que vous allez pouvoir gérer de gros fichiers audio de cette manière. 

Si vous avez de petits fichiers audio, à gérer un à un, vous pourrez utiliser le module mixer qui suffira largement pour pouvoir faire ça par contre si vous voulez gérer des playlists ou que vous voulez gérer des gros fichiers audio et de ne pas devoir attendre de les charger complètement avant de les lire, vous allez plutôt utiliser le sous-module Sound que je vais vous montrer. 

Alors le sous-module Sound, on ne va pas du tout passer par ce genre de fonctionnement donc on va virer tout cette partie de code qui ne sert à rien et elif … pass comme ça on mettra autre chose à l'intérieur.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    launched = True

    pygame.init()
    pygame.display.set_caption("Python #42 - jouer du son")
    window_surface = pygame.display.set_mode(window_resolution)

    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
            elif event.type == pygame.KEYDOWN:
                pass
```
Et là directement via le sous-module, on fait pygame.mixer, c'est toujors le module mixer mais le sous-module music et là on charge dans le programme load() c'est-à-dire la file de lecture, la liste de lecture, la playlist, le fichier qu'on veux.

Moi par exemple, je vais mettre comme tout à l'heure "celtic.ogg".
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    launched = True

    pygame.init()
    pygame.display.set_caption("Python #42 - jouer du son")
    window_surface = pygame.display.set_mode(window_resolution)

>   pygame.mixer.music.load("celtic.ogg")

    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
            elif event.type == pygame.KEYDOWN:
                pass
```
Et comme c'est un sous-module également, pour lire on va faire pareil, play().
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
launched = True

pygame.init()
pygame.display.set_caption("Python #42 - jouer du son")
window_surface = pygame.display.set_mode(window_resolution)

pygame.mixer.music.load("celtic.ogg")
pygame.mixer.music.play()

pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
       elif event.type == pygame.KEYDOWN:
           pass
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
Et là on est sur du streaming d'accord il n'y a pas de fichier à part c'est tout simplement une liste de lecture sur lequel nous chargeons notre fichier tout simplement. 

On a du coup plein de choses, on peut évidemment charger un fichier load(), on peut le lire play(), on peut faire également pause().
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
launched = True

pygame.init()
pygame.display.set_caption("Python #42 - jouer du son")
window_surface = pygame.display.set_mode(window_resolution)

pygame.mixer.music.load("celtic.ogg")
pygame.mixer.music.play()

pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
       elif event.type == pygame.KEYDOWN:
           pygame.mixer.music.pause()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
On charge le fichier, on utilise la barre d'espace et ça met en pause, pas de problème. 

On a unpause() si on veut reprendre la lecture, et on a plein d'autres fonctions disponibles comme ça d'accord vraiment plein de choses. 

On a rewind() qui permet de revenir au début de la lecture.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
launched = True

pygame.init()
pygame.display.set_caption("Python #42 - jouer du son")
window_surface = pygame.display.set_mode(window_resolution)

pygame.mixer.music.load("celtic.ogg")
pygame.mixer.music.play()

pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
       elif event.type == pygame.KEYDOWN:
           pygame.mixer.music.rewind()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
Il permet de revenir au début de la lecture. Admettons on charge un peu le fichier on le lit, on rappuie et hop le fichier redémarre au début. J'appuie sur la barre d'espace et ça redémarre au début. 

Voilà ça c'est pareil c'est à connaître et c'est encore une fois sur le sous-module music c'est important.

Donc là il n'y a pas d'histoire d'un fichier son qu'on cherche quelque part, un autre fichier son qu'on charge ailleurs … c'est un fait load() sur le module music et tout est géré dans une liste de lecture, et donc si on charge une autre musique ça se mettra dans la liste. 

Et on peut du coup gérer des playlists comme de cette manière donc c'est 2 usage différent c'est-à-dire qu'on ne travaille pas là sur un flux à la fois si on a tout qui est chargé dans une seule liste de lecture avec ce module music. 

Alors il y a plein d'autres choses, on peut également récupérer la position c'est-à-dire l'endroit où on est en train de lire, à quel moment on en est dans une musique. On peut également changer l'endroit où on est entrain de lire, ça c'est pratique imaginé sur un lecteur audio où vous avez un curseur et vous voulez vous déplacer dans la musique comme on se déplacerait dans une vidéo. 

Eh bien on peut utiliser sa méthode ses fonctions là si on veut donc c'est get_post(), set_post(). Vous en avez pas mal c'est okay par rapport justement modèle music. 

Donc ce qu'on pourra gérer, c'est les positions des fichiers alors le module music a l'avantage qu'il pourra lire le MP3 contrairement à mixer qui prenait que le OGG et le WAV. 

Par contre comme je vous l'ai dit dans certains pays, le format MP3 n'est pas pris en charge parce qu'il y a des brevets et cetera où il n'auront pas forcément l'autorisation de lire ce format de fichier et des fois sur certains systèmes, les greffons permettant de lire le format MP3 ne sont pas installés où ne sont pas disponibles donc si quelqu'un essaie de charger un fichier MP3 et qu'il ne peut pas, votre programme plantera. 

Donc c'est vraiment encore une fois si un jour vous faites un jeu vidéo et que vous faites n'importe quoi et que vous voulez le partager avec un maximum de monde sans avoir aucun souci, vous mettez tous vos fichiers audios compressés donc vous ne voulez pas qu'ils prennent beaucoup de taille en OGG d'accord ce format là. 

Et si vous voulez du format non compressé pour garder la meilleure qualité possible pour vos sons, vous prenez le format WAV.

Et là vous prenez le format WAV, vous n'aurez aucun problème ce sera lisible partout et pour tout le monde et peu importe le module que vous utiliserez ou même le langage de programmation que vous utiliserez d'ailleurs ce sera toujours compatible donc voilà. 

Voyez le sous-module de mixer est très simple à utiliser, c'est juste qu'on passe par music et du coup on gère ça différemment, ça permet de streamer les flux audio donc de ne pas attendre qu'il soit complètement chargé avant de les lire, et là on n'a pas de fichier qui est géré un à un ou chacun à pas mais une liste de lecture avec nos fichiers qui sont chargés donc il n'y a pas mal de choses comme ça à voir. 

On peut également gérer le fadeout encore une fois on peut le faire sur music comme ceci.
```py
    #coding:utf-8
    import pygame

    window_resolution = (640, 480)
    launched = True

    pygame.init()
    pygame.display.set_caption("Python #42 - jouer du son")
    window_surface = pygame.display.set_mode(window_resolution)

    pygame.mixer.music.load("celtic.ogg")
>   pygame.mixer.music.fadeout()

    pygame.display.flip()

    while launched:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                launched = False
            elif event.type == pygame.KEYDOWN:
                pygame.mixer.music.rewind()
```         
Voilà vous pouvez le gérer aussi, comme pour mixer c'est toujours toujours la même utilisation donc c'est des choses comme ça à connaître. 

On peut également gérer le volume, on a également set_volume(), get_volume() donc c'est comme pour mixer donc je passe très rapidement dessus parce que c'est vraiment le même fonctionnement, c'est vraiment 2 modules similaires c'est juste qu'ils ont un cas d'utilisation différents encore une fois. 

Voilà si vous avez utilisé l'un pour certaines choses et l'autre dans un autre cas comme je vous l'ai expliqué par rapport à l'histoire du chargement de fichier ou le fait de lire comme un flux de Stream, ou également si c'est un fichier volumineux vous allez préférer utiliser module music plutôt que d'utiliser mixer qui sera peut être un peu bloquant à ce niveau-là. 

Voilà n'hésitez pas à mettre en pratique ces 2 modules là, il n'y a pas mal de choses à voir. On aura d'ailleurs pas joué tous les sons mais ce n'est pas grave donc on peut comme ça j'irai pas mal de choses et du coup ça peut avoir une utilité. 

Alors ce qui est bon aussi à savoir, admettons si je fais ça mon fichier va être lu ouais d'accord.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
launched = True

pygame.init()
pygame.display.set_caption("Python #42 - jouer du son")
window_surface = pygame.display.set_mode(window_resolution)

pygame.mixer.music.load("celtic.ogg")
pygame.mixer.music.play()

pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
       elif event.type == pygame.KEYDOWN:
           pygame.mixer.music.rewind()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
Donc si je fais ça mon fichier va être lu. 

Essaye par contre je refais directement ça ça.
```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
launched = True

pygame.init()
pygame.display.set_caption("Python #42 - jouer du son")
window_surface = pygame.display.set_mode(window_resolution)

pygame.mixer.music.load("celtic.ogg")
pygame.mixer.music.load("song.ogg")
pygame.mixer.music.play()

pygame.display.flip()

while launched:
   for event in pygame.event.get():
       if event.type == pygame.QUIT:
           launched = False
       elif event.type == pygame.KEYDOWN:
           pygame.mixer.music.rewind()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
Vous voyez que le 2e chargement est venu écraser le premier. 

Du coup on est obligé de faire ça de recharger comme ça.

```py
#coding:utf-8
import pygame

window_resolution = (640, 480)
launched = True

pygame.init()
pygame.display.set_caption("Python #42 - jouer du son")
window_surface = pygame.display.set_mode(window_resolution)

pygame.mixer.music.load("celtic.ogg")
pygame.mixer.music.play()
pygame.mixer.music.load("song.ogg")
pygame.mixer.music.play()

pygame.display.flip()

while launched:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            launched = False
        elif event.type == pygame.KEYDOWN:
            pygame.mixer.music.rewind()
```
```powershell
    >python main.py
    pygame 2.0.0 (SDL 2.0.12, python 3.8.5)
    Hello from the pygame community. https://www.pygame.org/contribute.html
```
Ici l'ancien chargement va être écrasé donc ça en fait quand vous écrivez ce code là …
```py
    pygame.mixer.music.load("celtic.ogg")
    pygame.mixer.music.play()
    pygame.mixer.music.load("song.ogg")
    pygame.mixer.music.play()
```
Cette partie est ignorée tout simplement.
```py
    pygame.mixer.music.load("celtic.ogg")
    pygame.mixer.music.play()
```
Puisqu'on essaye de charger ça load("celtic.ogg"), là on essaye de lire un fichier play() mais comme on a directement fait un chargement-là load("song.ogg") c'est lui qui est chargé donc "celtic.ogg" ne serra de toute façon pas lue et quand on fait le dernier play(), on écoute le dernier qui a été chargé donc "song.ogg". Attention comment vous utilisez le chargement pour le fichier.

Voilà donc plein d'autres utilisations, il y a plein d'autres fonctions, plein d'autres méthodes mais je ne peux encore une fois pas tout montrer dans la totalité de ce qu'il est possible de faire car il y a tellement tellement de choses mais vous avez quand même la majorité, et pour tout ce que vous avez vu sur pygame qui se termine enfin, vous avez de quoi faire de vraies applications graphiques, de faire des jeux vidéo avec énormément de choses.

Pour les petites choses que je n'ai pas vraiment abordée dans le cours et qui peuvent être intéressantes, on le verra de toute façon et on aura l'occasion de les voir dans la playlist des tutoriels de python justement où j'apporte certaines choses que je n'ai pas forcément vu en vidéo parce que ce sont des compléments ou des suppléments, ce ne sont pas des choses obligatoires. 

Elles ne font pas partie des notions mais plus des choses que vous pouvez mettre en application et comment vous pouvez utiliser pygame avec certains module pour faire telle ou telle chose précisément. 

Et bien évidemment il ne faudra pas hésiter à utiliser les exercices pour vous familiariser un petit peu avec tout ça et voir comment on peut utiliser ces différents modules mais encore une fois il faut vraiment pas vous priver de faire des petits programmes, faire des petits projets. 

Il y a plein de choses à faire et ce qui est intéressant avec cette bibliothèque pygame, c'est que c'est du graphique, c'est du 2D, il y a du son, il y a de l'image, il y a de l'animation donc vous avez vraiment la possibilité de faire plein de choses. 

J'essaie quand même de voir pas mal de notions et de faire un petit peu le tour de tout même si on ne peut pas être exhaustif à 100%, c'est juste impossible mais j'essaie de vous présenter un maximum de choses et de faire des cours suffisamment détaillée pour que vous puissiez véritablement à bien exploiter cette bibliothèque et vous amuser avec. 

Donc n'hésitez pas et comme toujours si vous avez des questions, vous avez des commentaires sur la vidéo pour poser vos questions et faire vos remarques et ainsi je pourrais répondre à vos différentes questions je n'ai plus qu'a vous laisser parce qu'on a tout simplement terminé avec cette petite vidéo et on se retrouvera pour le coup pour la dernière vidéo de cette formation, la petite vidéo de conclusion justement histoire de faire un petit bref résumé de tout ce qu'on a vu et qu'est-ce que du coup vous pouvez faire maintenant avec tout ce que vous avez appris sur ce cours en python. 

Je vous dis à bientôt pour la prochaine vidéo et j'espère en tout cas que ça vous aura plu, et que ça vous aura permis de voir énormément de choses et d'aborder beaucoup de notions. 

On se retrouve du coup pour la prochaine et dernière séance de cette formation.

Ciao