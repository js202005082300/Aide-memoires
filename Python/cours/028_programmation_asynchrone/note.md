# [28. Programmation asynchrone](https://www.youtube.com/watch?v=vdjZvxAI5d4)

Bonjour à tous bienvenue pour la séance 28 en python avec ce nouveau cours concernant la programmation asynchrone.

Si c'est quelque chose qui ne vous dit rien de tout ça tombe bien, je vais pouvoir tout vous expliquer en détail ici, et vous allez voir un petit peu l'importance et l'intérêt que ça a au niveau de la programmation. 

Alors on va se resservir de la gestion du temps, ce qu'on avait fait avec le module time. 

Il y a des petites choses qui vont vous resservir par rapport à cette vidéo d'accord pour des petits cas exemple que j'aimerais vous montrer dans cette vidéo aujourd hui. 

Alors par défaut, vous avez appris à programmer de manière générale avec une programmation dite impérative, une programmation objet éventuellement mais en tout cas qui a une utilisation séquentielle. 

Qu'est-ce que ça veut dire? Ça veut dire qu'elle va réaliser notamment aussi dans le cas pythons, l'exécution de notre programme de haut en bas, du début à la fin. 

On va prendre un exemple très simple, on va créer 2 fonctions, je vais par exemple créer une fonction process_one() et je vais en faire un 2e, process_two().
```py
    #coding:utf-8

    def process_one():

    def process_two():
```
Imaginez 2 fonctions qui vont réaliser 2 tâches différentes mais pour moi elles seront similaires parce que pour l'exemple ça va être beaucoup plus pratique pour vous mais vous pourriez aussi imaginer de fonctions complètement différentes. 

Donc on va juste faire ça, une boucle tant que i plus petit que 3, tu fait un print() de ce genre de chose "oooooooooo".
```py
    #coding:utf-8

    def process_one():
        i = 0
        while i < 3:
            print("oooooooooo")

    def process_two():
```
Ensuite on va faire un time, voilà on va être peut utiliser la gestion du temps donc on importe time et on va faire un sleep() de 0.3 secondes. Et là, on n'oublie pas d'incrémenter i += 1.
```py
    #coding:utf-8
    import time

    def process_one():
        i = 0
        while i < 3:
            print("oooooooooo")
            time.sleep(0.3)
            i += 1

    def process_two():
```
Je reprend encore une fois le même code parce que encore une fois pour simplifier la vidéo, on va partir sur des fonctions qui sont les mêmes mais qui en revanche n'affiche pas la même chose.
```py
    #coding:utf-8
    import time

    def process_one():
        i = 0
        while i < 3:
            print("oooooooooo")
            time.sleep(0.3)
            i += 1

    def process_two():
        i = 0
        while i < 3:
            print("xxxxxxxxxx")
            time.sleep(0.3)
            i += 1
```
Et ensuite, on les exécute comme on a toujours apris à le faire en appelant les fonctions.
```py
#coding:utf-8
import time

def process_one():
   i = 0
   while i < 3:
       print("oooooooooo")
       time.sleep(0.3)
       i += 1

def process_two():
   i = 0
   while i < 3:
       print("xxxxxxxxxx")
       time.sleep(0.3)
       i += 1
       
process_one()
process_two()
```  
Voilà je suis allé un petit peu vite dans les explications mais normalement ce sont des choses que vous connaissez bien. 

Donc 2 petites fonctions qui exécute un certain traitement mais moi je m'en fichais quelque chose de différent histoire d'avoir un visuel pour pouvoir comparer et on appelle ces 2 fonctions dans un ordre choisi, la une ensuite la 2. 

Et on va tester à l'exécution.
```powershell
    >python main.py
    oooooooooo
    oooooooooo
    oooooooooo
    xxxxxxxxxx
    xxxxxxxxxx
    xxxxxxxxxx
```
On y va et voilà ce que ça nous donne au niveau résultat donc on se rend bien compte que nous avons d'abord le processus numéro un qui s'exécute et ensuite le numéro 2, ce qui est logique parce que c'est ce qu'on appelle de la programmation séquentielle c'est-à-dire que l'interpréteur python va lire l'exécution du fichier de manière séquentielle. 

Il va commencer par importer le module, il va ensuite définir 2 fonctions et ensuite on lui demande d'exécuter process_one() et ensuite il termine avec process_two(). 

Si jamais je veux afficher les croix avant les ronds, je serai obligé d'inverser l'appel des 2 fonctions. 

Ça c'est la base au niveau de la programmation, et là évidemment en faisant ça on a des choses qui sont inversés.
```py
#coding:utf-8
import time

def process_one():
   i = 0
   while i < 3:
       print("oooooooooo")
       time.sleep(0.3)
       i += 1

def process_two():
   i = 0
   while i < 3:
       print("xxxxxxxxxx")
       time.sleep(0.3)
       i += 1

process_two()   
process_one()
```
```powershell 
    >python main.py
    xxxxxxxxxx
    xxxxxxxxxx
    xxxxxxxxxx
    oooooooooo
    oooooooooo
    oooooooooo
```
Donc là on a les choses qui sont inversées. 

C'est de la programmation séquentielle, c'est ce que vous avez appris à faire jusqu à maintenant. 

Admettons que maintenant j'aimerais pouvoir exécuter, là ça peut être effectivement un cas, rien ne m'empêcherais d'exécuter ces 2 fonctions en même temps, de manière dite parallèle. 

C'est-à-dire que process_one() ne fait qu'afficher des ronds mais l'autre ne fait qu afficher des croix sans aucune gêne. Il n'y en a pas un qui va empêcher l'autre donc pourquoi il ne fonctionnerait pas de manière parallèle et pour cela nous allons justement utiliser les thread. 

Les threads justement la programmation parallèle avec le module threading de python pour pouvoir créer des threads que nous allons ensuite fixer à chacune de nos fonctions. 

Chaque fonction sera ensuite liée à un thread qui pourra du coup exécuter et faire le travail qui lui était demandé donc on y va et on importe ce module, import threading, et on va pouvoir créer notre aide à ce niveau là.
```py
    import threading
```
Et on va pouvoir créer nos threads à ce niveau là, donc la création et vous savez que python est très simple à ce niveau là c'est-à-dire pour mettre en place tout un tas de choses même lorsqu'elles sont très complexe derrière, c'est bien sûr qu'on va pouvoir faire ça en quelques secondes à peine.

On crée un premier thread, et on va ici instancier un objet de classe thread.

Dans ce module threading, nous avons une classe thread tout simplement ton qu'on fait threading et enfin un instant c'est l'objet, th1 = threading.Thread()
```py
    #coding:utf-8
    import time
    import threading

    def process_one():
        i = 0
        while i < 3:
            print("oooooooooo")
            time.sleep(0.3)
            i += 1

    def process_two():
        i = 0
        while i < 3:
            print("xxxxxxxxxx")
            time.sleep(0.3)
            i += 1

    th1 = threading.Thread()
```
Voilà je préfère avoir cette syntaxe là parce que je préfère avoir tout le visuel pour savoir que thread appartient bien à threading et pas autre chose. 

Mais si vous voulez masquer threading vous pouvez toujours faire ceci.
```py
    from threading import Thread
```
Et du coup vous n'aurez plus qu'a faire ça.
```py
    th1 = Thread()
```
Donc ça c'est vous qui voyez il n'y a pas une méthode qui est mieux qu'une autre, c'est vous qui voyez selon vos préférences et vos habitudes de programmation.

Alors cette classe Thread() donc le constructeur en l'occurrence, il prend tout un tas de paramètres. Alors il prend un groupe de Threads mais nous ça nous intéresse pas donc je ne vais pas en parler, il va prendre la cible d'exécution c'est-à-dire sur quoi il va se lier donc nous ça tombe bien parce que notre cible, ce sont quoi ? Ce sont des fonctions. Donc je vais le passer avec des arguments nommés donc target= et je vais mettre target=process_one pour celui là.
```py
    #coding:utf-8
    import time
    import threading

    def process_one():
        i = 0
        while i < 3:
            print("oooooooooo")
            time.sleep(0.3)
            i += 1

    def process_two():
        i = 0
        while i < 3:
            print("xxxxxxxxxx")
            time.sleep(0.3)
            i += 1

    th1 = threading.Thread(target=process_one)
```
Je vais faire un copier-coller pour créer un second thread donc on ne se trompe pas, on met bien th2 et c'est process_two.
```py
    #coding:utf-8
    import time
    import threading

    def process_one():
        i = 0
        while i < 3:
            print("oooooooooo")
            time.sleep(0.3)
            i += 1

    def process_two():
        i = 0
        while i < 3:
            print("xxxxxxxxxx")
            time.sleep(0.3)
            i += 1

    th1 = threading.Thread(target=process_one)
    th2 = threading.Thread(target=process_two)
```
On a d'autres valeurs que l'on peut mettre, on peut donner un nom aux threads avec l'argument name= sinon le nom sera Thread un tiret est un numéro de thread.

Donc là il mettrait thread-1, thread-2 et cetera jusqu à autant de thread que vous pourriez faire mais vous pourriez mettre un nom si vous avez besoin de les nommer pour les retrouver plus facilement.

Ça peut prendre l'air sur plein d'arguments, les args qui est un tuple, et kwargs qui est un dictionnaire donc ça c'est quelque chose si vous avez vu la vidéo sur les fonctions, vous devez savoir comment ça fonctionne.

Donc évidemment, cette classe prend ce type d'argument si vous le voulez donc n'hésitez pas à vous en servir éventuellement si besoin mais pour nous dans cette vidéo ici pour ne pas surcharger ce serait suffisant en tout cas. 

Voilà au niveau de la cible. 

À partir de là maintenant que nos objets sont instancier, on va pouvoir démarrer les threads donc pour le faire, il suffit d'utiliser la méthode start(). Vous pouvez mettre dans l'ordre que vous voulez, vous pouvez mettre th2.start() avant le th1 peu importe de toute façon ils vont s'exécuter en parallèle.
```py
    #coding:utf-8
    import time
    import threading

    def process_one():
        i = 0
        while i < 3:
            print("oooooooooo")
            time.sleep(0.3)
            i += 1

    def process_two():
        i = 0
        while i < 3:
            print("xxxxxxxxxx")
            time.sleep(0.3)
            i += 1

    th1 = threading.Thread(target=process_one)
    th2 = threading.Thread(target=process_two)
    
    th1.start()
    th2.start()
```
Alors ça ce n'est pas suffisant, les threads ont besoin également de bloquer l'exécution séquentiel du programme c'est à dire que si je fais un print() de "Fin du programme".
```py
    #coding:utf-8
    import time
    import threading                   

    def process_one():
        i = 0
        while i < 3:
            print("oooooooooo")
            time.sleep(0.3)
            i += 1

    def process_two():
        i = 0
        while i < 3:
            print("xxxxxxxxxx")
            time.sleep(0.3)
            i += 1

    th1 = threading.Thread(target=process_one)
    th2 = threading.Thread(target=process_two)
    
    th1.start()
    th2.start()
    
    print("Fin du programme")
```
Voilà je veux que ce print() s'affiche une fois que les threads aient terminés leur travail donc il va falloir bloquer l'exécution séquentielle pour que les threads fasse en parallèle leur traitement avant de poursuivre l'exécution séquentielle de notre programme donc pour ça on fait toujours un join() pour chacun des threads donc ils vont s'attendre chacun l'un de l'autre.
```py
#coding:utf-8
import time
import threading

def process_one():
   i = 0
   while i < 3:
       print("oooooooooo")
       time.sleep(0.3)
       i += 1

def process_two():
   i = 0
   while i < 3:
       print("xxxxxxxxxx")
       time.sleep(0.3)
       i += 1

th1 = threading.Thread(target=process_one)
th2 = threading.Thread(target=process_two)

th1.start()
th2.start()

th1.join()
th2.join()

print("Fin du programme")
```
Ils vont attendre que tous les 2 soient terminés, que les 2 threads aient fini leur travail avant de poursuivre l'exécution de notre programme donc ça c'est super important. 

Vous voyez c'est très simple en terme de code. 

On crée des threads, on les démarre et on les fait attendre l'un et l'autre, c'est vraiment aussi simple, en 6 lignes vous avez fait la chose donc c'est vraiment très facile. 

Et à partir de là on y va et voici l'exécution qu'il se passe.
```powershell
    >python main.py
    oooooooooo
    xxxxxxxxxx
    xxxxxxxxxx
    oooooooooo
    oooooooooo
    xxxxxxxxxx
    Fin du programme
```
Donc on va bien 0, X, X, 0, 0, X et si je ré exécute 0, X, 0, X, X, O.
```powershell
    >python main.py
    oooooooooo
    xxxxxxxxxx
    oooooooooo
    xxxxxxxxxx
    xxxxxxxxxx
    oooooooooo
    Fin du programme
```
Vous voyez que l'ordre d'apparition changent parce que évidemment les threads vont travailler de manière parallèle, ils ne vont pas se gêner où se bloquer l'un et l'autre, ils font leur petit travail chacun dans leur coin en même temps. 

Et pourquoi voyez-vous que l'ordre diffère ? tout simplement et ça je vous en avais parlé que la gestion du temps n'est pas exacte à 100%. Quand par exemple vous demander une pause de une seconde, en réalité elle fait plus ou moins une seconde donc peut être ici que le sleep() de 0.3 seconde (pour 000000…) a été plus petit que celui des xxxxxx… ou inversement, ce qui explique du coup ce changement d'ordre aussi. 

N'oubliez pas que le temps de processeur, les temps d'exécution ne sont pas exacts à 100%, quand vous demander une seconde ça ne fera pas pile une seconde, ça ne fera pas pile une seconde atomique à une petite marge d'erreur près une seconde. 

On a du coup un ordre différent.

Donc là vous voyez qu'effectivement on n'a pas eu besoin d'attendre l'un et l'autre, il s'exécute effectivement en parallèle donc ça c'est plutôt sympa. 

On voit bien que les processus se font chacun dans leur coin et en même temps on a bien cette programmation dite asynchrone donc ça c'est pratique si par exemple on a 2 traitements qui peuvent fonctionner tous les 2 ensemble parce qu'ils font tout simplement de tailles différentes. 

On peut imaginer un programme où vous avez une fonction qui va trier des données et une autre qui va enregistrer des données triées, plutôt que d'attendre que tout soit trié avant de les enregistrer, vous pouvez commencer déjà à enregistrer ce qui est déjà trier au fur et à mesure donc vous voyez ça se fait à la volée. 

On enregistre à la volée ce qui est trié. 

Et du coup on pourrait faire un Thread pour chacune de ces fonctions et avoir cela qui se fait de manière parallèle. 

Dans un jeu vidéo pourrait imaginer par exemple un thread qui s'occuperait de déplacer donc faire l'animation d'un personnage et un Thread qui s'occuperait de gérer la musique. Vous n'allez pas attendre que votre personnage bouge avant de démarrer la musique ou inversement, vous n'allez pas attendre que la musique de votre jeu soit terminée avant de faire déplacer votre personnage. Ce serait d'ailleurs très problématique en terme de jeu vidéo donc on va jouer la musique en même temps, en parallèle de gérer l'animation de notre personnage. Donc c'est là que les threads ont effectivement tout leur intérêt. 

Voilà comment ça fonctionne, vous voyez que c'était vraiment très simple à mettre en place et comme on a un petit peu de temps parce qu'il n'y a pas vraiment énormément de choses à vous montrer dans cette vidéo, on va améliorer un petit peu cela. On va revenir réviser quelques petites notions d'avant notamment l'héritage et là surcharge de méthode donc si vous avez des petits oublis là-dessus, n'hésitez pas à mettre en pause la vidéo et à revenir sur la séance concernant l'héritage pour les classes avant de revenir ici pour que ce soit plus clair. 

Voilà comment nous allons procéder, on va d'abord créer une petite classe que j'appelle MyProcess pour lequel je suis très inspirant en terme de nom et on va mettre la classe mère threading.Thread.
```py
    #coding:utf-8
    import time
    import threading
    
    class MyProcess(threading.Thread):

    def process_one():
        i = 0
        while i < 3:
            print("oooooooooo")
            time.sleep(0.3)
            i += 1

    def process_two():
        i = 0
        while i < 3:
            print("xxxxxxxxxx")
            time.sleep(0.3)
            i += 1

    th1 = threading.Thread(target=process_one)
    th2 = threading.Thread(target=process_two)

    th1.start()
    th2.start()

    th1.join()
    th2.join()

    print("Fin du programme")
```
Donc moi aussi j'aimais bien le nom du module threading et donc la class mère MyProcess c'est bien threading.Thread donc on a bien ici une classe fille. 

On va surcharger le constructeur évidemment donc on fait juste ça 
```py
    class MyProcess(threading.Thread):
        def __init__(self):
```  
On lui passe d'abord donc il va falloir d'abord initialiser le constructeur de la classe mère donc on y va, threading.Thread.__init__
```py
    class MyProcess(threading.Thread):
        def __init__(self):
            threading.Thread.__init__(self)
```   
Donc évitez d'utiliser un super parce que ça peut ne pas fonctionner d'accord si vous utilisez cette syntaxe-là, super(). Et en plus comme moi ici je nomme directement le module ça pourrait poser des soucis donc noter directement threading.Thread.__init__(). Moi aussi comme je ne lui passe rien parce que je veux rien mettre dans cette classe parce que je ne veux pas compliquer les choses, on va rester comme ça.

Et voilà pour le constructeur. 

Il a par défaut la classe thread a une méthode qui s'appelle run(), c'est une méthode qui va faire en fait le traitement de ce thread donc on va la surcharger aussi en re définissant ici une méthode run() qui va remplacer simplement la méthode de la classe mère, on fait une surcharge de méthode comme je vous en avais parlé, comme je vous l'ai appris dans les vidéos précédentes sur cette formation. 
```py
    def run(self):
```
On va juste lui passer l'instance donc self de la classe, et on va pouvoir y faire le traitement donc ce genre de choses là.
```py
    class MyProcess(threading.Thread):
        def __init__(self):
            threading.Thread.__init__(self)

        def run(self):
            i = 0
            while i < 3:
                print("oooooooooo")
                time.sleep(0.3)
                i += 1
```
Je vais ranger tout le reste et au lieu de ce qu'on avait dans le print(), on va lui passer l'information du thread donc on va faire print(threading.current_thread()).

Current_thread() donc ça c'est une fonction du module qui renvoie les informations du thread donc on verra si c'est le 1 ou le 2 qui s'exécute en fait à ce moment-là. Et ensuite évidemment une petite pause c'est c'est bon, time.sleep(0.3)
```py
    def run(self):
        i = 0
        while i < 3:
            print(threading.current_thread())
            time.sleep(0.3)
            i += 1
```
Et ici bien évidemment on n'a plus qu'a passer pas tout ça parce qu'évidemment passe par notre classe, on lui passe MyProcess() donc on va créer des instances de notre classe ici qui héritent elle-même de thread.
```py
    th1 = threading.Thread(target=process_one)
    th2 = threading.Thread(target=process_two)
    #-->
    th1 = MyProcess()
    th2 = MyProcess()
```
Et le reste ne change pas et en effet comme ça hérite Eh bien effectivement pour cette classe fille MyProcess(), start() et join() existent aussi. C'est juste que je ne les ai pas surchargées parce qu'elle fonctionne très bien au niveau de la classe mère donc pourquoi les changer puisque ici j'en ai pas besoin, et donc là j'y vais et je retente l'exécution. 
```py
#coding:utf-8
import time
import threading

class MyProcess(threading.Thread):
   def __init__(self):
       threading.Thread.__init__(self)

   def run(self):
       i = 0
       while i < 3:
           print(threading.current_thread())
           time.sleep(0.3)
           i += 1

th1 = MyProcess()
th2 = MyProcess()

th1.start()
th2.start()

th1.join()
th2.join()

print("Fin du programme")
```
```powershell
    >python main.py
    <MyProcess(Thread-1, started 12880)>
    <MyProcess(Thread-2, started 13984)>
    <MyProcess(Thread-1, started 12880)>
    <MyProcess(Thread-2, started 13984)>
    <MyProcess(Thread-2, started 13984)>
    <MyProcess(Thread-1, started 12880)>
    Fin du programme
```
Et là on voit comment ça se passe, vous voyez du coup le nom du thread "Thread-1" comme je vous avais dit tout à l'heure, il met Thread un tiret et le numéro du Thread en fonction de l'ordre que vous voulez créer donc on a "-1", "-2", "-1", "-2", "-2", "-1".

Et si je re exécute on aura à priori en ordre différent.
```powershell
    >python main.py
    <MyProcess(Thread-1, started 2388)>
    <MyProcess(Thread-2, started 3528)>
    <MyProcess(Thread-1, started 2388)>
    <MyProcess(Thread-2, started 3528)>
    <MyProcess(Thread-1, started 2388)>
    <MyProcess(Thread-2, started 3528)>
    Fin du programme
```
Et comme vous vous rendez compte je ne l'ai pas dit mais ça coule de source, vous voyez que la ligne "Fin de programme" se fait bien à la fin tout le temps parce que je rappelle que la méthode join() est bloquante. Les threads attendent d'avoir fini leur traitement avant de rendre la main au reste du programme et donc à la suite de la lecture séquentielle donc le dernier print() sera toujours toujours fait à la fin après que les threads aient terminé leur traitement. Cela l'avantage de pouvoir utiliser ces méthodes là justement. 

Voilà pour cette utilisation donc on a fait quelque chose d'un peu plus propre d'un peu plus avancé en utilisant une classe, ça vous a fait réviser un petit peu l'héritage et également la surcharge de méthode donc ce n'est pas plus mal à ce niveau-là. 

Donc écoutez pour la partie Thread, c'est tout ce qu'il y a à voir, c'est vraiment le plus important donc la création thread, le fait de les lier à quelque chose, de les exécuter et qu'ils attendent chacun. Il n'y a pas besoin de voir plus de choses, vous avez vraiment tout le principal ici. 

Ce que je peux vous proposer un petit bonus c'est tout ce qui concerne justement les processus bloquants c'est-à-dire que ici je vous avais dit que join() justement bloquait la suite de l'exécution du programme pour empêcher justement que d'autres choses viennent se mélanger et qu'il se passe tout un tas de choses bizarres qui rentrent en conflit alors que les threads sont en train de travailler. 

On peut créer pour cela ce qu'on appelle un verrou, il y en a peut être qui connaissent le terme mutex, vous connaissez aussi peut être le fameux sémaphore, ce genre de notions là qui permettent de verrouiller l'exécution d'une partie d'un traitement pour empêcher que les choses se mélangent. 

Imaginer par exemple une entreprise où vous avez plusieurs employés qui utilisent la même imprimante souvent c'est une imprimante branchée en réseau et vous avez par exemple employé A qui va lancer une impression et l'employé B qui va lancer une autre impression. L'avantage comme 7 en parallèle, ils peuvent lancer leur impression n'importe quand. Ça ne va pas rentrer en conflit l'un et l'autre parce qu'ils peuvent demander au même moment si ils veulent de lancer une impression par contre au niveau de l'imprimante, il est quand même plus pratique, plus optimal quel imprime d'abord par exemple toutes les feuilles de l'employé A admettons avant d'imprimer les feuilles de l'employé B parce que si elle fait tout n'importe comment dans le désordre, qu'est-ce qui va se passer ? Eh bien l'imprimante va imprimer la première feuille du document de l'employé A et la première feuille du document de l'employé B puis la 2e feuille du document de l'employé A, la 3e et à nouveau la 2e de l'employé B et cetera. 

Et à la fin ils vont se retrouver avec un paquet de feuille mélangé entre les 2 et si on multiplie ça par le nombre d'employés dans une entreprise, vous pouvez un petit peu imaginer le bazar que ça serait en terme de gestion des papiers, ce serait assez compliqué. 

Pour ça on peut du coup dire de mettre un verrou c'est-à-dire que l'exécution sera effectivement parallèle par contre au moment où on a un passage qui a dit critique, quand on a une zone critique dans un programme, dans un traitement, on lui dit à ce moment-là qu'on met un verrou c'est-à-dire que si je prends enfaite possession du traitement, il va falloir que les autres attendent que mon traitement à moi soit terminé avant de pouvoir prendre la main sur la machine. 

Donc entre guillemets si les gens veulent recevoir leurs feuilles imprimées ils vont devoir attendre que mon document soit imprimé complètement d'accord. 

Pourtant ils auraient pu demander une impression en parallèle, c'est ça qu'il faut bien comprendre, je sais que c'est de la programmation en parallèle mais que en même temps on peut mettre un verrou pour dire chacun son tour, il faut que les documents soient faits chacun leur tour sinon ça va être là pagaille et tout sera mélangé. 

Alors je n'ai pas forcément d'exemple suffisamment parlant, je ne peux pas vous mettre un exemple d'impression qui soit suffisamment explicite au niveau code donc on va faire quelque chose d'un peu plus simple à ce niveau là. 

Donc au niveau du run() on va déjà créer notre verrou donc le verrou c'est la classe RLock mais on verra s'il y a un problème au niveau de l'exécution si c'est bien ça donc je vais le créer ici et je vais mettre my_lock parce que je n'ai pas forcément de nom très explicite non plus, et attention ça vient du module threading aussi, ce n'est pas un autre module c'est toujours le même. On va faire comme ça.
```py
    #coding:utf-8
    import time
    import threading
    
    my_lock = threading.RLock()

    class MyProcess(threading.Thread):
        def __init__(self):
            threading.Thread.__init__(self)

        def run(self):
            i = 0
            while i < 3:
                print(threading.current_thread())
                time.sleep(0.3)
                i += 1

    th1 = MyProcess()
    th2 = MyProcess()

    th1.start()
    th2.start()

    th1.join()
    th2.join()

    print("Fin du programme")
```
my_lock = threading.RLock(), là j'ai créé un verrou parce que je vais en avoir besoin, j'aurais pu le créer dans MyProcess ou autre mais je vais le créer ici histoire que ce soit plus simple, accessible partout. 

Et là maintenant on va pouvoir travailler sur la partie run() donc je fais mon initialisation i=0, je prépare ma boucle while i < 3. Et bien ensuite à quel endroit, je vais pouvoir bloquer l'opération ? ça va être à ce niveau là time.sleep(). Alors on va changer le code à l'intérieur de la boucle et on va mettre ceci letters = "ABC" … je ne sais pas si encore une fois on va voir la différence parce que c'est pas évident de mettre un exemple suffisamment parlant mais on verra bien ce que ça donne … et on va faire "for lt in letters" qui va afficher une lettre tout simplement, `print(lt)`.
```py
        def run(self):
            i = 0
            while i < 3:
                letters = "ABC"
                for lt in letters:
                    print(lt)
                i += 1
```
Tout simplement, je pense que les apprécier suffisamment clair et ensuite on va faire un petit `time.sleep(0.3)`.
```py
        def run(self):
            i = 0
            while i < 3:
                letters = "ABC"
                for lt in letters:
                    print(lt)
                    time.sleep(0.3)
                i += 1
```
Voilà je pense que au niveau de l'exemple on est bien donc on a bien fait le incrémentation si il faut pas que on l'oublie parce que si il n'y a pas de points d'arrêt ça va être embêtant. 

on va d'abord regarder ce que ça fait sans verrou on va d'ailleurs le mettre en commentaire pour dire que ça n'intervient pas donc on va montrer l'exécution comme ceci. 
```py
#coding:utf-8
import time
import threading

#my_lock = threading.RLock()

class MyProcess(threading.Thread):
   def __init__(self):
       threading.Thread.__init__(self)

   def run(self):
       i = 0
       while i < 3:
           letters = "ABC"
           for lt in letters:
               print(lt)
               time.sleep(0.3)
           i += 1

th1 = MyProcess()
th2 = MyProcess()

th1.start()
th2.start()

th1.join()
th2.join()

print("Fin du programme")
```
```powershell
    >python main.py
    A
    A
    B
    B
    C
    C
    A
    A
    B
    B
    C
    C
    A
    A
    B
    B
    C
    C
    Fin du programme
```
Voilà ce qu'il se passe  mais moi je voudrais qu'il m'affiche ABC dans l'ordre mais comme ici tout travail en parallèle, Eh bien vous voyez que chaque thread fais les choses n'importe quand donc là vous pouvez voir qu'il y a des répétitions de A, B et C.

On voit pas trop de changement ici, ils sont à peu près d'accord chacun et pourquoi est-ce qu'ils sont d'accord ? Eh bien encore une fois parce que ici mon temps est le même pour les 2 threads donc il faudrait que je fasse une attente aléatoire pour que ce soit un peu plus réaliste. Imaginer que sur un programme les attentes ne sont pas toutes les mêmes pour les threads, elles sont aléatoires donc effectivement chaque chose travail de manière quand il a le temps, quand le système lui donne le moment à lui pour pouvoir le faire pendant quelques fragments de seconde avant de repasser la main à un autre processus. 

Donc là comme on l'a programmé à 0.3, il est possible qu'il se cale sur le même temps donc ce n'est pas forcément réaliste à 100% mais peu importe. 

Dans tous les cas on se rend bien compte qu'on n'a jamais ABC ici à la suite et ça c'est un petit peu embêtant par rapport à ce que l'on veut faire. 

Donc pour cela on va utiliser un verrou et là vous allez voir un petit peu la différence pour le coup et tant mieux parce que au final ce sera suffisamment explicite, on va le mettre à ce niveau là c'est-à-dire sur la partie qui est critique c'est-à-dire la partie où on ne veut pas qu'un thread soit dérangé par un autre, on va pouvoir la verrouiller donc je met tout dans un with donc toute la partie à vérouiller. 
```py
    while i < 3:
        with my_lock:
            letters = "ABC"
            for lt in letters:
                print(lt)
                time.sleep(0.3)
            i += 1
```
Alors là `i += 1`, je ne suis pas sûr qu'il ait besoin d'être verrouillé donc je vais le laisser ici en dehors du verrou pour pouvoir laisser l'implémentation se faire au niveau du "while" et là si je re exécute… 
```py
#coding:utf-8
import time
import threading

my_lock = threading.RLock()

class MyProcess(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)

    def run(self):
        i = 0
        while i < 3:
            with my_lock:
                letters = "ABC"
                for lt in letters:
                    print(lt)
                    time.sleep(0.3)
            i += 1

th1 = MyProcess()
th2 = MyProcess()

th1.start()
th2.start()

th1.join()
th2.join()

print("Fin du programme")
```
```powershell
    >python main.py
    A
    B
    C
    A
    B
    C
    A
    B
    C
    A
    B
    C
    A
    B
    C
    A
    B
    C
    Fin du programme
```
Et là vous voyez qu'on a bien ABC qui se fait à chaque fois dans l'ordre. 

Alors les threads se font peut être dans n'importe quel ordre, peut-être que le premier ABC c'est le Thread-1 et ensuite c'est Thread-2 encore Thread-2 et ensuite c'est encore Thread-1 et cetera. 

Peu importe quel Thread exécute la ligne, en attendant au moment où ils font leur travail, ils le font du début à la fin sans être interrompu par le Thread. 

Voilà c'est un petit peu ce que je vous parlais tout à l'heure avec l'imprimante c'est à dire que c'est le premier entre guillemets où il a été décidé que l'on allait s'occuper de sa tâche en premier; le premier Thread qui démarre, c'est lui qui fait sa tâche du début à la fin et ensuite l'autre peut directement le faire pendant que le premier Thread qui avait fait sa tâche va attendre à son tour que le 2nd ait fais ce qu'il a à faire et cetera. 

Ils se font comme ça de manière parallèle mais quand ils ont pris la main sur l'opération, elle est faite jusqu'au bout sans qu'elle se coupe en plein milieu d'accord. 

Sinon c'est un petit peu comme si vous imprimez une page et puis que en plein milieu l'imprimante arrête l'impression pour aller imprimer le papier d'un autre du coup vous n'aurez que la moitié de votre page imprimée parce qu'il doit démarrer l'impression d'un autre document de quelqu'un d'autre alors imaginez un petit peu le bazar que ce serait également. 

Voilà pour cette partie bonus concernant les verrous au niveau de la gestion asynchrone parce que ça peut fonctionner comme ça.

J'espère que ça a été suffisamment clair, malheureusement dans ce genre de cas c'est vachement parlant quand on utilise sur des cas très poussée mais peut être quand on fera du web et du réseau, on aura l'occasion d'utiliser les threads de manière un peu plus concrète. 

Donc avec les sockets, on va pouvoir faire quelque chose d'un peu plus intéressant. 

Dans tous les cas, j'essaie de vous faire un exemple assez basique pour que vous voyez un petit peu la différence avec ou sans verrou et donc j'espère que ce sera suffisamment explicite. 

Dans tous les cas ce qu'il faut retenir, c'est le fonctionnement des threads, le fait de pouvoir fixer quelque chose au niveau des traitements pour pouvoir les gérer de manière parallèle, de manière asynchrone sans que ça vienne se faire de manière séquentielle en faisant un traitement que le 2e et cetera.

Donc là je pense que vous avez appris pas mal de choses, n'hésitez pas à mettre ça en place dans les petits programmes de test pour vous familiariser avec l'utilisation des threads et on se retrouvera du coup pour les prochaines vidéos. 

Donc maintenant qu'on a vu toutes ces petites choses là parce que ça allait être utile, on va pouvoir attaquer un bon chapitre sur la partie web et réseaux sur cette formation en python j'espère que ça vous plaira en tout cas pour ce qui vous attend avec la suite de ce cours. 

À bientôt tout le monde avec le langage python. 

Ciao