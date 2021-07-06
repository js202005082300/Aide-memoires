# [26. Gestion temps](https://www.youtube.com/watch?v=C0LmHQkJUs4)

Bonjour et merci d'être présent sur cette formation au langage python.

On poursuit avec la séance 26.

Alors on va sortir de tkinter avec tout ce qu'on a vu sur les interfaces graphiques.

je vous ai personnellement montrer tout ce que j'avais à vous montrer au niveau de ce module et évidemment si vous voulez en savoir un peu plus, aller beaucoup plus loin, vous pourrez consulter la documentation officielle pour apporter un peu plus de détails là-dessus, utiliser des widgets que je n'ai pas forcément présenté dans la vidéo.

Donc là on va sortir de tout ça, on va revenir à des choses un peu plus standard on va dire, et un cas que j'ai voulu directement intégré dans le cours, alors c'est une partie que j'aurais pu directement mettre en annexe dans un tutoriel mais comme le système de temps parce que c'est ce que nous allons voir, Est quelque chose que vous allez retrouver partout que vous fassiez de l'applicatif, que vous créez un jeu vidéo même si vous allez faire un site web, Vous serez forcément confronté à une histoire de temps ou de date mais ça on le verra dans les séances suivantes.

Pour cette séance là j'aimerais qu'on parle un petit peu du temps donc on va utiliser un module particulier de python qui permet de gérer ça.

On va voir quelques petites fonctions très faciles à utiliser par rapport à cette section-là, et dans la vidéo prochaine on parlera des dates.

Voilà travailler un petit peu plus dans le vif du sujet on travaillera avec des dates parce qu'il y a pas mal de choses à savoir aussi là dessus et ça vous servira pour la suite dans tout ce que vous verrez en python que ce soit la création de site web ou même si vous créez un jeu vidéo pour manipuler tout simplement le temps dans un jeu, ça peut être tout à fait utile.

On va revenir sur un code de base n'a rien du tout. 
```py
    #coding:utf-8
```
On va importer le module adéquat, c'est tout simplement time, voilà le nom est très simple à retenir et on va l'utiliser très simplement pour pas mal de petit traitement.
```py
    #coding:utf-8
    import time
``` 
Je vais vous montrer une pomme première fonction que vous avez peut-être déjà eu l'occasion de me voir utiliser parce que je ne vous avais pas donné de détails dessus qui est une fonction qui va tout simplement mettre en pause un programme je vais vous expliquer un peu plus en détail en quoi elle consiste.

Par défaut quand vous lancez un programme c'est mono-threadé c'est à dire que vous avez un processus qui va se lancer.

En fait vous avez un thread donc ça fonctionne au niveau de vos processeur d'accord.

Au niveau des cœur de votre processeur, vous n'allez avoir qu'un seul processus qui va démarrer votre programme.

Par la suite on apprendra à gérer des programmes multi-threadé, avec plusieurs processus en parallèle pour pouvoir justement faire de l'exécution en parallèle et vous verrez les avantages que ça va avoir, surtout que dans certains cas ce sera même indispensable pour certains traitements en particulier. 

Donc en réalité quand on a exécuté notre programme on va toujours faire comme ceci, par exemple on affichait ceci et je vais mettre 2 print tout simplement. 
```py
#coding:utf-8
import time

print("Le premier texte")
print("Le second texte")
```
```powershell
    >python main.py
    Le premier texte
    Le second texte 
```
On va juste afficher ça avec une exécution standard, on aurait une exécution séquentielle comme l'interpréteur python va interpréter c'est-à-dire lire notre fichier, il va traiter les choses une par une. 

Il voit que au début on va importer le module time, ce qu'il va faire, donc il va apporter toutes les classes éventuelles, toutes les fonctions, les propriétés qu'il faut concernant le module time, et ensuite il va partir chacune des instructions et les exécuter une par une.

Donc là il a un premier print il va faire l'affichage, il interprète le 2e print, il fait le 2e affichage et ainsi de suite. 

Tout cela se passe au sein du même processus et va se faire à la suite des autres. 

Vous n'aurez jamais par exemple le 2nd texte qui va s'afficher avant le premier print. 

Alors ce processus là on peut justement le suspendre pendant quelque temps grâce à la fonction sleep() et la fonction sleep() est utilisé justement via ce module time.

Donc on peut justement faire ça, time.sleep() et elle prend en paramètre justement le nombre de secondes où il faut interrompre le processus, d'accord et nous on va mettre par exemple 5 secondes.

Et on va ré exécuter le programme.
```py
#coding:utf-8
import time

print("Le premier texte")

time.sleep(5)

print("Le second texte")
```
```powershell
    >python main.py
    Le premier texte
    ...
    Le second texte
```
Donc là vous voyez qu'il est affiché le premier texte, on a une attente donc on est bloqué, et là au bout de 5 secondes parce que c'est ce que j'ai indiqué, on a le 2nd texte qui s'affiche donc on a véritablement le processus qui s'est mis en pause, qui a été interrompu un certain nombre de secondes tel qu'on l'a spécifié. 

Donc voilà ça c'est une fonction basique bien évidemment mais qui sera utile dans pas mal de cas lorsque par exemple vous voulez simuler un traitement ou même dans certains cas avoir besoin de mettre en pause un processus, ça peut se montrer utile. 

C'est pas mal d'utiliser ce type de fonction, vous pourriez par exemple en avoir besoin lorsque vous traiteriez de client-serveur, que vous ferez du réseau, ça peut être très utile dans ce cas-là. 

Donc je voulais vous la montrer parce que c'est quelque chose vraiment à savoir qui est vraiment incontournable au niveau de la gestion du temps et maintenant vous serez l'utiliser et vous en servir et à quoi elle sert. 

C'est ça qu'il faut bien comprendre, n'oubliez pas que vous êtes en mono-threadé encore une fois d'accord. 

Un thread c'est simplement le processus qui va être exécuté et comme là on a qu'un seul thread, et bien on a une seule exécution possible. 

Donc on peut interrompre en fait ce processus quand on veut et bien évidemment il le reprendra par la suite. 

Voilà ça c'est à retenir cette petite fonction sleep() qui est bien pratique lorsque vous verrez par la suite sur des choses encore plus avancées de ce langage même d'autres langages d'ailleurs parce qu'on peut retrouver cela sur tous les langages de programmation. 

On va maintenant aborder un autre cas donc vraiment aborder du temps parce qu'il y a des choses à savoir par rapport à ça, et là je vais sortir du cadre python parce que ça pourrait concerner d'autres langages de programmation mais ça reste quand même ici lié parce qu'on va utiliser un module 2 pitons et pas d'autre chose, c'est comment est géré le temps. 

Vous vous doutez bien que le temps ça remonte à très très loin, ça remonte à une époque, où l'on serait incapable de trouver l'origine exacte du temps, du démarrage en fait du temps. 

Donc vous vous doutez bien qu'en informatique on s'est basé sur une date de départ parce qu'on ne pouvait pas par exemple se dire que le départ du temps aurait démarrer il y a un million d'années et cetera, ce serait des nombres beaucoup trop long à manipuler et vous savez qu'en informatique on est limité par ça. 

On est limité par l'apport à la taille d'un nombre que peut stocker votre ordinateur, une  machine, le 32 bits,  le 64 bits ou la taille d'un entier comme vous avez pu le voir avec les integer ce genre de choses. 

Donc il a fallu faire un choix, et il a été choisi ce qu'on appelle "Epoch" qui s'écrit comme ça d'accord, c'est lié à l'Unix mais je n'en parle pas parce que ça concerne notamment GNU Linux donc tout  l'univers Unix qui sont notamment les familles de distribution Linux, un autre os comme vous avez d'ailleurs en formation sur la chaîne. 

Mais grosso modo par rapport à ce qu'il y a à retenir et ce qu'il y a à comprendre par rapport au temps, c'est qu'il a été choisi une date de départ, on a choisi du coup le premier janvier 1970. 
```py
    #coding:utf-8
    import time
    
    # 1er Janvier 1970
```
1er Janvier 1970, C'est-à-dire que cette date on a estimé que l'informatique allez connaître un essor, ça allait vraiment se populariser au sein des familles au sein des maisons et cetera donc on a pris cette date comme date de départ. 

Qu'est-ce que ça veut dire ? Ça veut dire qu à partir de cette date, on a commencé à compter le nombre de secondes qui s'écoulait et on a pris cette date de référence. 

Alors bien évidemment à minuit, on est parti de 0h 0. 
```py
    #coding:utf-8
    import time
    
    # 1er Janvier 1970 00h00
```
Et à partir de là on a mis en place un timestamp, un timestamp en fait que depuis cette date là, toutes les secondes qui se sont passées jusqu à présent, au moment où je vous parle, on été comptés.

Et pour récupérer le nombre de secondes qui se sont écoulées depuis le 1/1/1970, Eh bien tous les langages de programmation et en tout cas les créateurs, ce sont accordés à intégrer dans leur langage des manières de pouvoir récupérer ce timestamp. 

Et en python c'est évidemment très simple puisqu'il suffit juste d'afficher d'accord, donc on part du module time et on utilise time.
```py
#coding:utf-8
import time

# 1er Janvier 1970 00h00

print(time.time())
```
```powershell
    >python main.py
    1602420130.8335307
```
time.time() tout simplement et là regardez, on voit qu'il s'est écoulé tout ceci.

Donc on voit qu'il s'est écoulé tout ceci et ça fait évidemment beaucoup, ça fait plus d'un milliard 500 millions et cetera et on a même de décimale parce que les valeurs sont quand même un peu plus précises. 

Alors ce n'est pas une valeur extrêmement précise d'accord, si on voulait avoir quelque chose de très précis vraiment au décimale près, ce ne serait pas vraiment utile d'avoir ça mais on a quand même une petite précision qui est tout de même de 7 chiffres après la virgule donc il n'est pas non plus négligeable, d'accord c'est à prendre en compte. 

Donc là on voit que depuis tout ce temps, il s'est passé ce nombre de secondes. 

D'ailleurs si je relance le programme vous verrez que le nombre a changé.
```powershell
    >python main.py
    1602420411.7926369
```
Alors parce que entre le temps où je vous ai parlé, il se sera passé quelques secondes également donc vous voyez que ça a changé, on est passé ici de 30 à 11, et même au niveau décimal ça a changé.

Ça c'est si vous voulez de manière générale d'accord, si vous faites du c plus plus ou du Java ou n'importe quel langage de programmation il y a des fonctions qui permettent de récupérer ce timestamp, et timestamp est récupéré via le système C'est à dire que depuis le 1/1/1970, on compte le nombre de secondes qui se sont écoulées.

Et c'est une référence en informatique qui pourrait continuer d'exister pendant un petit moment, je crois que c'est jusqu'en 2038 pour tout ce qui est architecture 32 bits parce que après on ne pourra pas stocker un nombre plus grand parce qu'on peut on va arriver à un nombre entier qui ne pourra plus être stocké dans les machines 32 bits, et après les machines 64 bits ça peut aller beaucoup plus loin, ça peut aller en milliers de milliards, enfin c'est un nombre qui est extrêmement grand.

Voilà pour la 64 bits c'est un nombre extrêmement grand je ne l'ai pas forcément en tête mais je pense qu'on sera tranquille pendant un moment, et le jour où vraiment on aura atteint la limite des systèmes 64 bits, on aura peut-être des systèmes plus grand ou alors on décidera peut-être d'une nouvelle date de commencement pour reprendre à 0 mais ça risque de pas mal chambouler l'informatique quand cela changera. 

Donc jusqu à présent et en tout cas jusqu à ce que ce soit un point de fin où on ne puisse plus continuer de stocker un nombre, on se base sur cette date là qui n'est pas trop ancienne, ça permet donc de manipuler des normes qui ne sont pas forcément extrêmement grand non plus.

On est tout juste sur du milliard donc ça va, ce n'est pas non plus des centaines de milliards qui serait compliqué à manipuler donc ça va.

Voilà c'est vraiment la date de référence à retenir, dites-vous que le time stamp est basé sur le nombre de secondes écoulées depuis le 1/1/1970 à minuit, et vous pouvez récupérer cela en python avec la fonction time(), donc c'est très pratique. 

Alors à quoi ça peut servir, un exemple tout bête, c'est un peu l'exemple d'application que l'on peut donner à tout le monde pour n'importe quel langage aussi. Vous allez faire begin = time.time() d'accord.
```py
    #coding:utf-8
    import time
    
    begin = time.time()
```
Vous allez avoir print("Début").
```py
    #coding:utf-8
    import time
    
    begin = time.time()
    print("Début")
```
Ensuite on va faire un time.sleep(5) mais ça vous allez voir je vais vous montrer ce qu'il va se passer.
```py
    #coding:utf-8
    import time
    
    begin = time.time()
    print("Début")
    
    time.sleep(5)
```
`end = time.time()`, je récupère dans une variable begin, dans une variable end, chaque fois le nouveau time.
```py
    #coding:utf-8
    import time
    
    begin = time.time()
    print("Début")
    
    time.sleep(5)
    
    end = time.time()
```
Et `print("Fin")` ce genre de chose.
```py
#coding:utf-8
import time

begin = time.time()
print("Début")

time.sleep(5)

end = time.time()
print("Fin")
```
Là on va exécuter.
```powershell
    >python main.py
    Début
    ...
    Fin
```
Donc on laisse tourner, on laisse tourner 5 secondes et FIN voilà ce qu'on obtient donc là pour le moment on n'a rien vu.

Nous ce qui nous intéressait de pouvoir récupérer ça par la suite, print() du temps exécuté qui veut tout simplement end - begin, d'accord, en 2nde parce qu'on imagine bien parce que je ne vais pas attendre pendant 15 ans à faire tourner le programme. Toute façon il va tourner 5 secondes.
```py
#coding:utf-8
import time

begin = time.time()
print("Début")

time.sleep(5)

end = time.time()
print("Fin")

print(f"Temps exécuté : {end - begin}s")
```
```powershell
    >python main.py
    Début
    Fin
    Temps exécuté : 5.005932569503784s
```
Donc début toujours pareil, au bout de 5 secondes s'est exécutée et mon a une valeur précise c'est-à-dire qu'on se rend compte qu'en faisant un sleep() de 5 secondes, en réalité il s'écoule un peu plus de 5 secondes pour être exact parce que vous vous doutez bien qu'il faut déjà bien le temps que l'interpréteur sache qu'il doit s'arrêter. 

Donc mine de rien en terme informatique, le temps où il lit cette instruction et que réellement il l'exécute, Il se passe quand même plusieurs micro secondes en réalité, on n'est pas sur une valeur pile de 5 secondes mais c'est à ça que ça correspond donc vous vous rendez compte qu'on peut manipuler ça facilement en informatique, il suffit juste de pouvoir récupérer 2 time et ensuite enfin une petite soustraction de rien du tout et on arrive à savoir le temps qu'il s'est écoulé. 

Donc ça ça peut être utile quand vous avez des programmes que vous trouvez un peu long à l'exécution, les programmes de recherche, de tri et cetera, et que vous voulez vous faire une idée … elle ne sera pas hyper précises bien évidemment mais pour voir à peu près le temps que ça prend à l'exécution donc ça peut être pratique pour faire un début de profiling c'est-à-dire le fait de surveiller les exécution de programmes, les processus, le temps d'exécution pour contrôler est optimiser simplement le code, Les algorithmes pour que ce soit plus rapide et pour que ce soit bien évidemment plus efficace donc ça peut être assez utile dans ce sens là.

donc voilà l'utilité que ça peut avoir mais je resterais sur ce genre d'exemple parce que après on peut faire des choses beaucoup plus avancées mais pour ce que j'ai à vous montrer ici ce sera bien suffisant alors ce n'est pas au niveau utilisation où l'on rejoint un certain nombre de secondes. 

Là ce qu'il peut être aussi utile à manipuler mais ce sera surtout intéressant lorsqu'on verra la gestion de la date qui sera un petit peu plus précise que ça et un petit peu plus humaine parce que là c'est pratique à manipuler pour une machine ou un humain, c'est beaucoup moins pratique de manipuler ce genre de nombre, boule concevrez bien. 

Donc on va du coup avoir un autre que là qui est simplement la fonction locale time qui va fonctionner un peu différemment donc on peut faire par exemple en laissant par défaut, je veux juste faire un print() de time.localtime.
```py
    #coding:utf-8
    import time

    print(time.localtime())
```
Alors cette fonction peut prendre un nombre de secondes et si on ne précise rien, comme on ne lui donne pas d'arguments précis, elle va tout simplement se baser sur ce qu'on a vu tout à l'heure c'est-à-dire time.time() donc la fonction time() donc nous comme on précise rien elle va partir de ce principe là. 
```py
#coding:utf-8
import time

print(time.localtime())
```
```powershell
    >python main.py
    time.struct_time(tm_year=2020, tm_mon=10, tm_mday=11, tm_hour=19, tm_min=14, tm_sec=28, tm_wday=6, tm_yday=285, tm_isdst=1)
```
Puis du coup elle prend le temps écoulé depuis 1970, et elle nous prend la date actuelle donc on voit qu'on obtient une espèce de structure time.struct_time() donc c'est simplement la structure de temps qui est géré ici en python, attention c'est propre ici au langage mais pas à tous. 

Il y a des langages vous n'aurez pas forcément cette structure là même pas du tout, et vous avez différentes paramètres avec des valeurs précises donc tm_year c'est l'année, tm_mon c'est le mois, tm_mday c'est le jour, tm_hour c'est l'heure, tm_sec pour les seccondes, tm_wday et le numéro de la semaine alors vous allez peut-être vous demander pourquoi c'est 6 parce que par défaut lundi correspond à 0 comme pour le tableau comme pour pas mal de choses en informatique où les index démarre à 0 et a 1 mais pour les jours de la semaine c'est pareil.

0 c'est le premier jour de la semaine donc 1 c'est le 2e. tm_yday ça c'est le jour de l'année, et ça tm_isdst c'est pour tout ce qui est décalage horaire, c'est un 0, 1. Si on est en heure d'hiver, on ne décale pas d'une heure donc c'est à 0.

Donc ça ça assez pratique à manipuler par la suite parce que vous voyez qu'on peut accéder tu as des valeurs très particulière, vous pouvez par exemple juste récupérer ça, le tm_year. Vous pouvez simplement récupérer les secondes tm_sec mais je ne reviens pas dessus parce que vous savez manipuler des listes, des tuples, vous savez manipuler des dictionnaires parce que tout ça on l'a déjà vu, ce sont des choses tout à fait simples qu'on peut utiliser. 

Mais sachez qu'en réalité quand vous avez grosso modo un time donc time c'est le timestamp, je vais faire ici un petit schéma rapide. Avec localtime peut obtenir une structure, la structure de temps en python, ça c'est une chose.
```py
    """
                    localtime()
    (TIMESTAMP) ------------------> structure de temps
    """
```
Donc ça c'est une chose par contre vous allez pouvoir faire le chemin inverse mais cette fois non pas avec localtime() mais avec mktime() tout simplement. 

Donc en faisant mktime() vous allez revenir tout simplement à l'envers. 
```py
    """
                    localtime()
    (TIMESTAMP) ------------------> structure de temps
                <------------------
                    mktime()
    """
```
Si je fait tps = time.localtime() d'accord et du coup je vais l'afficher, print(tps) et puis print(tps.mktime()).
```py
#coding:utf-8
import time

"""
               localtime()
(TIMESTAMP) ------------------> structure de temps
           <------------------
               mktime()
"""

tps = time.localtime()
print(tps)
print(time.mktime())
```
```powershell
    >python main.py
    time.struct_time(tm_year=2020, tm_mon=10, tm_mday=11, tm_hour=21, tm_min=40, tm_sec=54, tm_wday=6, tm_yday=285, tm_isdst=1)
    Traceback (most recent call last):
      File "main.py", line 313, in <module>
        print(time.mktime())
    TypeError: mktime() takes exactly one argument (0 given)
```
Voilà par contre il me dit qu'il n'y a pas d'attribut mktime sans oublier l'argument tps.
```py
#coding:utf-8
import time

"""
               localtime()
(TIMESTAMP) ------------------> structure de temps
           <------------------
               mktime()
"""

tps = time.localtime()
print(tps)

tps = time.mktime(tps)
print(tps)
```
```powershell
    >python main.py
    time.struct_time(tm_year=2020, tm_mon=10, tm_mday=11, tm_hour=21, tm_min=56, tm_sec=9, tm_wday=6, tm_yday=285, tm_isdst=1)
    1602446169.0
```
Voilà il faut évidemment l'argument tps sinon on ne peut pas faire la conversion donc vous voyez que localtime() en partant du timestamp parce que là il va partir de time.time, il va vous obtenir la structure donc tout ça.
```py
    time.struct_time(tm_year=2020, tm_mon=10, tm_mday=11, tm_hour=21, tm_min=56, tm_sec=9, tm_wday=6, tm_yday=285, tm_isdst=1)
```
D'accord donc on voit d'ailleurs qu'elle a un petit peu changé les secondes et les minutes ne sont plus les mêmes que tout à l'heure et quand vous allez la re convertir avec mktime donc si vous reconvertisse la structure en fait via mktime() vous allez revenir sur le timestamp. 

Ça permet comme ça de faire un chemin ou l'autre, de venir d'un côté ou de l'autre, c'est pour ça que j'ai mis ce petit schéma qui est pratique à retenir par rapport à ça. 

Un temps (a time) vous pouvez le reconvertir en localtime pour avoir la structure, et la structure vous pouvez la convertir avec mktime() pour revenir au timestamp. 

On peut comme ça intervertir l'un ou l'autre. 

Alors je vais m'arrêter là sur les exemples parce que encore une fois ce sera utile surtout comme application, c'est bien de le savoir parce que c'est indispensable pour la suite parce que vous vous en servirez pour la programmation python mais au niveau explication c'est simple à présenter parce que là vous avez déjà la base de ce qu'il faut. 

Il y a bien évidemment d'autres fonctions, d'autres utilités, il y a d'autres petites choses à savoir par rapport à ça mais je ne rentrerai pas dans les détails parce qu'il y a de fortes chances que pour la majorité ça ne vous serve jamais voir très très peu. 

Évidemment le jour où vous aurez besoin d'une gestion du temps très particulière, vous pouvez vous référer à la documentation et voir à ce moment-là mais déjà avec ça vous avez déjà un bon début de choses qui sont utile. 

Alors qu'est-ce que je vais pouvoir vous montrer de plus ? On niveau du temps on va terminer sur autre chose parce que là on a manipuler beaucoup de nombres et tout ça, et ce n'est pas forcément pratique. Moi je vais vous proposer de manipuler des dates un peu plus humaine, qui sont plus simple pour nous à la lecture, plus simple pour nous à la compréhension. 

Donc je vais vous présenter pour cela une 3e fonction comme ça on aura fait pas mal de petites choses, et même une 5e parce qu'on a vu sleep(), on a vu time(), localtime(), mktime() et là je vais vous en montrer du coup une dernière. 

Je vais vous montrer tout simplement comment avoir une chaîne parce que ça c'est quand même vachement pratique d'avoir une chaîne pour manipuler du temps, et ça ce sera quand même bien mieux. 

Alors je vous montre un exemple tout bête, je vais faire my_time et on va mettre tout simplement = time.str, c'est str donc string puis f et time, time.strftime(). 
```py
    #coding:utf-8
    import time
    
    my_time = time.strftime()
```
Et elle va prendre ta format de date, on pourrait même lui ajouter un temps en paramètre mais c'est optionnel mais nous ce qui nous intéressé ici c'est surtout de manipuler un format donc le format je vais en montrer un par défaut parce que c'est quand même ça qui est pour le coup utile qui va nous permettre de manipuler des cas particulier. 

Donc le strftime(), vous allez avoir un ensemble de format qui est à connaître. Je vais vous les noter aussi parce que évidemment ce sont des choses qui vont vous servir, vous allez pouvoir manipuler un ensemble de formats via des jokers. Des jokers ce sont simplement des valeurs qui sont identifiées par pourcent suivi de quelque chose qui suit pour dire à quoi ça correspond.
```py
    """
    %
    """
```
Alors le %d, c'est pour le jour. Le jour ça va être de 01 à 31 parce qu'il y a maximum 31 jours dans un mois.
```py
    """
    %d : jour (01 à 31)
    """
```
On va avoir le %m qui est le mois c'est 01 (attention ce n'est pas 1) à 12.
```py
    """
    %d : jour (01 à 31)
    %m : mois (01 à 12)
    """
```
On va avoir ensuite le Y majuscule donc l'année donc par exemple l'année de maintenant ce serait 2018. Et vous avez également le petit %y même si on utilise plus souvent le grand mais le petit ce serra de 00 à 99 donc pareil c'est l'année donc si c'est 2018, ça vous mettra 18, c'est pour ça qu'en général, on préferera utiliser ce type-là quand on veut avoir une date lisible parce que 18 on pourrait se demander si c'est 1918, enfin c'est quoi ... donc c'est bien d'avoir les deux cas possible.
```py
    """
    %d : jour (01 à 31)
    %m : mois (01 à 12)
    %Y année (ex : 2018) - %y (00 à 99)
    """
```
On a bien évidemment parce que là je vous ai mit le jour, le mois et l'année, on peut évidemment manipuler les heures, les minutes et les secondes donc grand H donc ça c'est les heures, je ne vous apprend rien non plus donc c'est 00 à 23 parce que une fois que vous arrivez à 24, vous revenez à 0 en fait.
```py
    """
    %d : jour (01 à 31)
    %m : mois (01 à 12)
    %Y année (ex : 2018) - %y (00 à 99)
    %H : heure (00 à 23)
    """
```
On va avoir le grand I donc ça c'est les minutes donc de 00 à 59.
```py
    """
    %d : jour (01 à 31)
    %m : mois (01 à 12)
    %Y année (ex : 2018) - %y (00 à 99)
    %H : heure (00 à 23)
    %I : minutes (00 à 59)
    """
```
Et on va avoir bien sûr grand S donc là ce sont les secondes, et là pareil de 00 à 59. Des fois on retrouve 61 parce que les secondes ne sont pas exacte à 100% tel qu'on l'a vu avec le Timestamp. Il y a une estimation qui est faites mais ce n'est pas exacte à 100% parce que on ne peut pas voir les mili mili secondes qui se sont écoulées, ce n'est pas possible humainnement. Ce serait compliqué d'avoir quelque chose d'ultra précis...
```py
    """
    %d : jour (01 à 31)
    %m : mois (01 à 12)
    %Y année (ex : 2018) - %y (00 à 99)
    %H : heure (00 à 23)
    %I : minutes (00 à 59)
    %S : secondes (00 à 59)
    """
```
Voilà le jour le mois les années lundi. On pourra avoir qu'une seule année mais on peut bien sûr avoir plusieurs heures minutes et secondes bien évidemment alors pour l'heure il y a également le %p qui est pratique pour pouvoir gérer AM/PM donc ça c'est pratique pour les heures américaines et anglaises si on est le matin ou dans l'après-midi.
```py
    """
    %d : jour (01 à 31)
    %m : mois (01 à 12)
    %Y année (ex : 2018) - %y (00 à 99)
    %H : heure (00 à 23)
    %I : minutes (00 à 59)
    %S : secondes (00 à 59)
    %p : AM/PM
    """
```
Et après on a des cas un peu à part mais qui sont quand même à connaître. Il y a le grand A pour les jours de la semaine si je ne dis pas de bêtises. Le petite a c'est pour les jours abregé.
```py
    """
    %d : jour (01 à 31)
    %m : mois (01 à 12)
    %Y année (ex : 2018) - %y (00 à 99)
    %H : heure (00 à 23)
    %I : minutes (00 à 59)
    %S : secondes (00 à 59)
    %p : AM/PM
    
    %A : jour semaine / %a (jour abrégé)
    """
```
Et vous allez avoir le B majuscule qui lui est le mois, donc le mois de l'année c'est le nom du mois en fait, et le petit b et le moi abrégé grosso modo donc ça ce sont des choses à savoir.
```py
    """
    %d : jour (01 à 31)
    %m : mois (01 à 12)
    %Y année (ex : 2018) - %y (00 à 99)
    %H : heure (00 à 23)
    %I : minutes (00 à 59)
    %S : secondes (00 à 59)
    %p : AM/PM
    
    %A : jour semaine / %a (jour abrégé)
    %B : mois / %b (mois abrégé)
    """
```
Du coup on va directement faire un print() en fait te grand A.
```py
#coding:utf-8
import time

"""
%d : jour (01 à 31)
%m : mois (01 à 12)
%Y année (ex : 2018) - %y (00 à 99)
%H : heure (00 à 23)
%I : minutes (00 à 59)
%S : secondes (00 à 59)
%p : AM/PM

%A : jour semaine / %a (jour abrégé)
%B : mois / %b (mois abrégé)
"""

print(time.strftime("%A"))
```
```powershell
    >python main.py
    Sunday
```
Vous voyez qu'il met Sunday, c'est en anglais bien sûr parce que vous savez qu'en informatique c'est en anglais, après bien sûr avec ce que vous avez déjà appris, vous pourriez sans problème manipuler ça pour gérer, faire des transformations pour gérer ça en français … de toute façon vous avez les connaissances nécessaires pour passer ça en français si c'est nécessaire. 

Automatiquement ça vous fera un entraînement si vous voulez ou alors vous pouvez traiter ça différemment ou bien laisser comme ça si vous voulez. 

Donc en général si on va avoir une date bien française, on se fait une petite fonction qui manipule une date en particulier, et à partir de là qui affiche le bon texte comme ça ça peut gérer les noms en français de manière plus pratique, plus flexible. 

Donc on procède comme ça, c'est bien mieux que de devoir travailler avec date en anglais. 

Donc on peut également faire sans problème ceci, je peux sans problème mettre %d/%m/%Y.
```py
#coding:utf-8
import time

"""
%d : jour (01 à 31)
%m : mois (01 à 12)
%Y année (ex : 2018) - %y (00 à 99)
%H : heure (00 à 23)
%I : minutes (00 à 59)
%S : secondes (00 à 59)
%p : AM/PM

%A : jour semaine / %a (jour abrégé)
%B : mois / %b (mois abrégé)
"""

print(time.strftime("%d/%m/%Y"))
```
Et vous pouvez constater que l'éditeur ne va pas colorier comme il faut … ce n'est pas qu'il y a une erreur au niveau du code mais c'est que l'éditeur a du mal parce que ce caractère % est utilisé par pas mal de chose en python notamment quand on veut faire des remplacements de variables particulier comme ça se faisait à l'époque quand on faisait comme ceci.

À l'époque on tapait d'abord un texte, une valeur et après on mettait comme ceci, print "ddee {}" %..., Et voilà on mettait le pour 100 et on mettait la variable juste après donc voilà c'était une petite c'est une petite syntaxe qui existait, et donc l'éditeur n'aime pas trop qu'on utilise ce genre de caractère …
```powershell
    >python main.py
    11/10/2020
```
L'éditeur n'aime pas trop qu'on utilise ce genre de caractère mais pourtant il devra bien parce que vous voyez que ça fonctionne et que c'est comme ça de toute façon que ça fonctionne. 

Alors là évidemment c'est plus lisible 11/10/2020, on arrive mieux à lire quand tu utilises ce type de format donc vous pouvez comme ça formater des dates de plusieurs manières différentes, c'est vachement pratique. 

Voilà c'est vraiment pratique, si on veut faire une version américaine qu'on retrouve parfois en informatique, Eh bien ça va s'écrire surtout comme ceci : %Y-%m-%d donc c'est avec des tirets et c'est toujours l'année qui est en premier donc on peut faire ce format là il n'y a pas de problème.
```py
#coding:utf-8
import time

"""
%d : jour (01 à 31)
%m : mois (01 à 12)
%Y année (ex : 2018) - %y (00 à 99)
%H : heure (00 à 23)
%I : minutes (00 à 59)
%S : secondes (00 à 59)
%p : AM/PM

%A : jour semaine / %a (jour abrégé)
%B : mois / %b (mois abrégé)
"""
print(time.strftime("%Y-%m-%d"))
```
```powershell
    >python main.py
    2020-10-11
```
Il n'y a pas de problème, c'est très bien géré à ce niveau-là, il n'y a pas de problème d'utilisation sur ce système là. 

Alors ce qui peut être pas mal aussi, c'est un petit plus aussi il s'agit d'un Z majuscule qui est pour tous qui la timezone donc c'est pour ce qui est le fuseau horaire.
```py
#coding:utf-8
import time

"""
%d : jour (01 à 31)
%m : mois (01 à 12)
%Y année (ex : 2018) - %y (00 à 99)
%H : heure (00 à 23)
%I : minutes (00 à 59)
%S : secondes (00 à 59)
%p : AM/PM

%A : jour semaine / %a (jour abrégé)
%B : mois / %b (mois abrégé)

%Z : fuseau horaire (timezone)
"""

print(time.strftime("%Z"))
```
```powershell
    >python main.py
    Paris, Madrid (heure d’été)
```
Paris et Madrid parce que évidemment par rapport au fuseau horaire où je me trouve, c'est le fuseau horaire qui correspond. Par rapport à Greenwich et cetera il permet de récupérer des valeurs différentes donc c'est intéressant aussi parce que ça peut être intéressant de récupérer ça aussi dans certains programmes ou autre, ça a quand même son utilité. 

Par exemple sur un site web vous avez un certain forum, vous avez des articles et vous voulez par exemple mettre la date de publications, tout ça, c'est évidemment très utile à avoir c'est pour ça que je voulais inclure encore une fois tout ce qui est gestion de date et d'heure donc la gestion de temps au sein du cours directement et pas à part dans un tutoriel parce que je pense que c'est indispensable. On ne peut pas se passer de ça et considérer que c'est facultatif à l'apprentissage du langage python. 

Voilà pour ce module time, là on a utilisé qu'un seul module mais il y a beaucoup de choses à voir donc je récapitule un petit peu les choses qu'on a vu. 

On a vu :
```py
    """
    time.sleep() pour mettre en pause le processus.
        .time()
        .localtime()
        .mktime() qui permet rappelez vous d'intervertir de l'un à l'autre.
        .strftime()
    """
```
Donc ça fait pas grand chose mais déjà vous savez quoi faire avec ça et au moins vous serez manipuler, gérer du temps au niveau de vos programmes, au niveau de l'exécution de ces derniers. Vous aurez pas mal de choses à voir avec ces choses-là donc n'hésitez pas surtout avec celle-là strftime(), à manipuler des lettres un peu plus précise par exemple de voir comment récupérer %Z, de faire des formatage en particulier, de faire des transformations mais pourquoi pas comme entraînement créez votre propre fonction pour manipuler par exemple les dates, et après retourne une chaîne de caractères en français. 

Admettons quelque chose qui vous affiche à la fin ce genre de chose "Mardi 27 février 2018, il est 15h03" qui sera évidemment plus agréable à l'affichage plutôt que d'avoir quelque chose comme "Tuesday" ou je ne sais pas quoi avec des noms en anglais si vous voulez par exemple faire un programme avec du texte en français.
```py
#coding:utf-8
import time

"""
time.sleep()
    .time()
    .localtime()
    .mktime()
    .strftime()
"""

print("Mardi 27 février 2018, il est 15h03")
```
```powershell
    >python main.py
    Mardi 27 février 2018, il est 15h03
```
Par exemple si vous voulez faire un programme avec du texte en français donc ça ça peut être un bon entraînement d'accord pour ce type de cours donc si vous voulez vous exercer n'hésitez pas à le faire, à vous faire une petite fonction par rapport à ça, utiliser un maximum de chose que vous avez déjà vu. Vous pouvez même carrément faire une classe pourquoi pas, te faire une classe que vous pourrez instancier. 

Même si dans la vidéo suivante, on travaillera sur les dates et on utilisera justement des classes en particulier parce que vous vous doutais bien qu'il n'y a pas seulement juste des petites fonctions dans un module. Il n'y a bien évidemment des classes pour manipuler des dates et vous savez bien que les dates sont intimement lié à tout ce qui est temps, dates et cetera. 

Donc on verra tout ça pour la séance suivante, je vous dis à bientôt et je vous laisse avec ça, n'hésitez pas si vous avez des commentaires et des questions par rapport à cette séance là. 

Je vous dis la prochaine fois on parlera des dates d'accord en python. 

À bientôt tout le monde