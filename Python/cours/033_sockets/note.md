# [33. Sockets](https://www.youtube.com/watch?v=5FqzL9LJkXA)

+ [server.py](server.py)
+ [client.py](client.py)

Bonjour à tous, bienvenue sur la vidéo 33 en python. 

On termine notre chapitre sur la section web réseau avec les sockets.

Les sockets, ça va être une notion assez compliquée au départ pour quelques personnes mais elle est simple, elle est simple au final une fois qu'on l'a comprise à l'utiliser. Vous allez voir. 

Je vais vous expliquer, vous détailler en tout cas tout ça comme je le fais habituellement pour que ce soit le plus clair possible et que vous sachiez bien les utiliser. 

Alors on va partir sur 2 fichiers, vous voyez que je vais créer ici un fichier server.py et un fichier client.py. Je vais vous expliquer un petit peu après pourquoi et de toute façon je vais vous faire le détail. 

On va commencer déjà parce que je pense que c'est la base et c'est nécessaire par expliquer ce qu'est un socket. 

Un socket c'est tout simplement … alors il faut déjà distinguer pour être plus exact, un socket dit logiciel, du socket dit matériel, je ne parle pas du socket du matériel qui sont des éléments concernant les cartes mères et donc ça ne concerne évidemment pas cette vidéo mais moi je parle vraiment des sockets dit logiciel qui sont apparus sur une distribution de la famille Unix … Barclays, je crois … qui était une distribution qui manipulait tout simplement ça, qui a permis d'introduire ce fameux socket logiciel.

Socket logiciel qui se charge en fait de permettre la communication d'accord donc soit au sein d'une même machine ou alors entre 2 machines distantes ou bien encore entre éventuellement plusieurs maintenant sans en fait se soucier de la manière dont est géré le réseau.

C'est-à-dire que avant quand il n'y avait pas de sockets, on était obligé si on voulait faire un minimum de réseau (faire communiquer des programmes) et bien gérer nous-mêmes la manière dont le réseau se comporte et la manière dont le réseau fonctionne. 

Évidemment ça pouvait changer d'une machine à l'autre, d'un système à l'autre, d'une infrastructure à l'autre, d'une architecture à l'autre donc c'était juste absolument trop contraignant, trop compliqué et ça changeait à chaque fois. 

Grâce à ça, on a un système en surcouche qui vient en surcouche donc une espèce d'interface de connexion d'accord. Le socket c'est un peu comme une interface de connexion qui vient par-dessus tout ça et qui va fonctionner de la même manière, de manière uniforme, quelle que soit la façon dont est géré le réseau. 

Vous n'avez pas à vous occuper de ça, vous vous occupez juste via les sockets, d'envoyer des données, de les recevoir et de faire communiquer comme ça plusieurs processus au sein d'un même programme par exemple sur des machines distantes.

Et voilà Comment ça va fonctionner. 

Voilà à quoi sert un socket. 

Ce que l'on peut imaginer, en fait c'est tout simplement comme si vous aviez 2 personnes, on peut prendre 2 entités d'accord 2 personnes. 

Vous en avez un qui va ouvrir une trappe pour pouvoir envoyer des données, et puis le destinataire peut lui-même ouvrir une trappe pour récupérer ces fameuses données. Ils peuvent comme ça communiquer l'un et l'autre. 

Ça ressemble tout à fait à une communication qu'on aurait entre 2 êtres humains par exemple, avec bien sûr différents modes mais je ne vais pas trop rentrer dans les détails mais on a 2 modes à connaître qui sont vraiment les modes standard même s'il en existe pas mal d'autres qui sont TCP et UDP. 

On en a un qui est un mode connecté et l'autre non. 

Pour faire simple parce que de toute façon on n'a pas besoin non plus de rentrer trop dans les détails pour cette vidéo, le mode TCP qui est un mode connecté est un mode qui va établir une connexion une bonne fois pour toute avec quelqu'un. 

Imaginez vous en train de vous connecter avec une autre personne, et à partir de là une fois que vous êtes connecté vous pouvez communiquer. Ça peut être par exemple un appel téléphonique, ça peut être quelque chose qui vous met en contact. 

Et comme vous savez avec quelle personne vous allez communiquer, vous envoyer des infos, elle vous en envoie aussi. Vous pouvez les recevoir chacun et les informations sont vérifiées. On s'assure que vous recevez bien toute l'information jusqu à coupe donc clore la connexion. 

En revanche UDP qui est un mode non connecté, il sera déjà plus rapide mais il ne va pas faire de vérification du tout donc à chaque fois que vous allez vouloir communiquer, il faudra donner les informations de la personne donc en l'occurrence la machine ou l'adresse à qui envoyer les données à chaque fois et on ne va pas s'assurer quel sont bien reçue. 

Le mode UDP c'est souvent ce qu'on utilise dans les jeux vidéo en ligne puisqu'on a par exemple besoin d'envoyer tout un tas de parquets par exemple les coordonnées d'un joueur, les coordonnées de l'environnement dans lequel vous évoluez. 

Et si on devait à chaque fois se connecter et vérifier que toutes les données ont bien été envoyées, ce serait archi lourd et ce serait injouable donc pour les jeux en ligne en général, on utilise beaucoup UDP qui lui va envoyer toutes les données quitte à ce qu'il y ait parfois des données qui se perdent, les fameux paquets perdus. 

Les fameux paquets perdus, vous connaissez peut-être s'il y a des gens par exemple parmi vous qui font du streaming ou même simplement que vous jouez, vous avez peut-être déjà entendu parler de paquets perdus où d'informations comme ça qui sont perdue. 

Ou même des fois, on a des petites latences, des petits lags, des petits décalages, des petits rollback bref des choses qui se passe sur les jeux en ligne ou sur des jeux en réseau. C'est ce genre d'information que nous avons là, c'est axée par rapport à ça. 

C'est parce que UDP ne vérifie absolument rien mais au moins les choses sont rapides, l'information est donnée directement et on ne s'occupe pas de vérifier si elle a bien été reçue à la fin. On continue comme ça de l'envoyer tout à la suite. 

Donc nous on ne va pas trop s'occuper de TCP, UDP d'accord ici. 

On va juste s'occuper de communiquer tout simplement avec nos programmes au sein du réseau local. 

Donc il faut savoir parce que ça c'est l'erreur que beaucoup de gens font, les gens pensent que pour pouvoir faire un programme en réseau, il faut obligatoirement le faire sur des machines distantes sauf qu'il faut que vous sachiez que votre ordinateur quel qu'il soit est à lui-même tout seul déjà un réseau d'accord. 

C'est le fameux réseau local. 

Donc vous pouvez vous-même héberger à la fois le serveur donc démarrer un serveur sur votre machine et connecter un client sur votre serveur et tout ça depuis la même machine. 

L'avantage c'est que vous allez du coup pouvoir programmer des clients serveur donc des programmes en multi ou des programmes en réseau sur une même machine, et par la suite éventuellement les déployer en ligne, les déployer sur un site distant, sur une machine distante donc c'est l'avantage. 

L'avantage que si ça fonctionne en local, c'est que ça fonctionnera logiquement, normalement et sans problème à distance. Il n'y a pas de raison. 

La seule chose qui changera c'est éventuellement l'adresse mais on va en parler un petit peu après. 

Donc pour pouvoir faire tout ça en python parce que là je viens de vous faire une petite introduction mais on va commencer le codage et voir comment mettre ça en place. 

On va utiliser le module socket pour travailler avec les sockets. 

C'est vraiment rien de plus, on va travailler avec ça, et on reviendra sur d'autres petites choses avec notamment tout ce qui est programmation asynchrone donc tout ce qui est thread, ce qu'on a pu évidemment abordé dans une vidéo précédente et qui va pour le coup nous servir à la fin de celle-ci. 

Donc on y va on fait un import socket.

+ server.py
```py    
    #coding:utf-8
    import socket
```
Je vais l'ajouter également ici.

+ client.py
```py
    #coding:utf-8
    import socket
```

Alors pourquoi j'ai 2 fichiers ? Parce que il y en a un qui va jouer le rôle comme l'indique son nom de serveur, le serveur il va être là pour démarrer et écouter tout ce qu'il se passe sur un port. Et je vais en parler un petit peu après.

Un port imaginez c'est un endroit réservé pour communiquer, et le client va se connecter au serveur. 

Et ainsi une fois qu'ils seront connectés tous les 2, mis en relation, on pourra les faire communiquer, l'un pour envoyer des données et cetera. 

Nous ce que l'on fera, c'est envoyer des données avec le client, et le serveur va pouvoir les réceptionner donc on va faire ce petit genre de choses pour voir que ça fonctionne. 

Voilà comment ça fonctionne alors ça c'est le cas minimal quand vous avez 2 acteurs, on va en avoir un qui va jouer le rôle de serveur et l'autre qui va jouer le rôle et l'autre qui va jouer le rôle de client. 

Si on fait le parallèle avec un jeu vidéo, Eh bien vous avez peut-être déjà vu si vous jouez. Vous pouvez créer une partie, un serveur en local, donc vous allez jouer le rôle de serveur. Vous allez héberger la partie et votre ami qui viendra jouer avec vous, il va rejoindre votre parti, il va se connecter, il fera office de client. 

Et vous, vous êtes le serveur, il n'y a pas besoin que vous soyez tous les 2 des clients. Il y en a qui peut jouer le rôle du serveur et l'autre du client, ou inversement. 

En revanche dans un gros jeu en ligne, si on fait encore une fois le parallèle, le serveur est tout simplement tenu par les développeurs donc c'est quelque chose qui a démarré sur des serveurs physiques. 

On démarre un programme sur des serveurs physiques qui sont alimentés h24, jour et nuit, tout le temps tout le temps pour rester ouvert. 

Et du fait que le serveur est démarré h24, tous les joueurs peuvent se connecter dessus en tant que client sur le serveur, et même s'ils veulent communiquer entre eux. Si par exemple un client à veux communiquer avec un client B, ça passera toujours comme intermédiaire par le serveur. 

Admettons que le client A envoie un message au client B, Hé bien le message va être réceptionné par le serveur, et c'est le serveur qui va s'occuper ensuite de le faire transiter, de le transmettre au client B et cetera. 

On ne peut pas communiquer directement 2 clients entre eux, ça passe forcément par le serveur parce que le serveur écoute les communications et s'occupe ensuite de faire toute la transmission. 

Les clients sont juste là pour se connecter et ensuite ils peuvent communiquer une fois que la connexion est établie. 

Voilà pour les petits détails mais on va revenir de toute façon sur pas mal de choses. 

Donc on y va et la première chose à faire c'est de créer donc on va d'abord s'occuper du serveur qui va être ensuite chargé d'écouter en créant notre socket. 

Donc on va faire le socket que je vais appeler socket la variable, on va choisir un nom très très simple. Et on part du module socket et on va instancier et avec socket. 

+ server.py
```py
    #coding:utf-8
    import socket
    
    socket = socket.socket()
```
Ça prend 2 arguments principaux, il y en a d'autres mais en tout cas 2 arguments obligatoires. 

Le premier ça va être la famille d'utilisation donc par rapport au protocole donc là je ne vais pas rentrer dans les détails parce que vous n'avez pas forcément le niveau pour le comprendre et ceux qui sont vraiment curieux pourront aller voir dans la documentation, voir même dans les normes au niveau réseau, au niveau protocole pour vous renseigner et nous allons donc utiliser des constantes qui sont définies dans le module socket ici.

+ server.py
```py
    #coding:utf-8
    import socket
    
    socket = socket.socket(socket.AF_INET, )
```
La première c'est AF_INET pour la famille que nous allons utiliser, et ensuite on va passer le type de socket, et le type le plus standard c'est SOCK_STREAM.

+ server.py
```py
    #coding:utf-8
    import socket
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
```
Avec ces 2 constantes, vous allez pouvoir normalement tout faire. 

C'est vraiment ce qu'on utilise le plus même si évidemment le module ici socket() propose d'autres familles et d'autres types de socket, vous pouvez toujours aller vous renseigner mais vous verrez que ça vous servira que dans des cadres très très très très spécifiques et très rare donc là c'est vraiment les cas généraux et le cas les plus classique dans pratiquement toutes les situations. 

Donc on va travailler directement avec ça AF_INET et SOCK_STREAM. 

Là notre socket est créée.

À partir de ce moment-là, nous allons avoir besoin d'associer donc le socket pour fonctionnaire doit se lier ou en tout cas démarrer avec une adresse et un port. 

L'adresse c'est tout simplement une adresse IP, même si vous mettez une adresse http, www. quelque chose et cetera, c'est une adresse IP derrière qui se cache, d'accord derrière le nom de domaine. J'en avais déjà parlé sur la vidéo précédente. 

Et le port de communication c'est tout simplement un nombre qui permet de dire je communique sur tel port. Alors il y en a plusieurs, il n'y a plus de 40000 ports et même beaucoup plus qui existe en tout cas, qui sont disponibles. 

Par contre, attention certains ports sont réservés. Par exemple, le port 21 est réservé pour FTP, le port 22 est réservé pour SSH, le port 23 pour telnet, on a un port pour SNTP c'est à dire le 25. On doit avoir le port 80 pour http et cetera. 

Donc il ne faut pas évidement sélectionner dans l'idéal de port qui sont déjà réservé pour éviter tout les conflits donc vous pouvez utiliser un port à 4 chiffres en vérifiant qu'il n'est déjà réservé par une autre application.

Du coup ce qu'on va faire, on va partir de socket avec la méthode bind().

+ server.py
```py
    #coding:utf-8
    import socket
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind()
```
Alors le socket a une adresse pour se connecter. Bind() Va prendre comme paramètre un tuple, elle va prendre un tuples qui possède l'adresse et le port. 

Donc en général par habitude je les passe avant, comme ça le jour où j'ai besoin de le modifier c'est quand même beaucoup plus pratique de le faire ici (au début du code) a un seul endroit donc on y va host, port = et on va passer ça sous forme de tuple.

+ server.py
```py
    #coding:utf-8
    import socket
    
    host, port = ()
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind()
```
Le serveur comme il n'a pas besoin de se connecter, il doit juste démarrer et écouter, on doit juste lui passer une adresse donc on va laisser le premier champ à vide '' et le port on va mettre par exemple 5566.

+ server.py
```py
    #coding:utf-8
    import socket
    
    host, port = ('', 5566)
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind()
```
Ce port là à priori ne doit pas être utilisé donc ça ne devrait pas poser de problème à ce niveau-là.

Donc on a ici tout qui est fait et on n'a plus qu'a passer le tuple dans bind() donc attention on a les parenthèses avec les parenthèses du tuple à l'intérieur en tant que paramètre d'appel de la fonction donc la méthode en l'occurrence.

+ server.py
```py
    #coding:utf-8
    import socket
    
    host, port = ('', 5566)
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
```
Voilà pour l'adresse et le port.

Donc là on associé avec la méthode bind(), le tout au socket donc le socket est bien associé à (host, port). Il n'est associé à aucune adresse mais ici en l'occurrence avec le port d'écoute, à écouter sur le port 5566. Ça c'est important. 

Alors on peut le faire éventuellement, après on peut dire que le serveur est démarré.

+ server.py
```py
    #coding:utf-8
    import socket
    
    host, port = ('', 5566)
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré")
```
Alors il n'écoute pas encore parce qu'on ne l'a pas encore fait écouter au niveau du port mais en tout cas, on va pouvoir le démarrer, on l'a associé.

Et là, je vais mettre ça dans une boucle infinie. Pas mal de procédés comme ça, vous faites un while True: et on va faire écouter cette fois-ci, le serveur sur le port en question. Alors le message vous pouvez le mettre ici si vous voulez.

+ server.py
```py
    #coding:utf-8
    import socket
    
    host, port = ('', 5566)
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré")
    
    while True:
    #   <----------------
```

Voilà vous mettez le message où vous voulez, moi je le mets ici avant la boucle infinie pour éviter qu'il se répète plusieurs fois par la suite et on peut se mettre en écoute. 

Donc pour se mettre en écoute on fait socket.listen(), et listen() va écouter sur ce qui a été renseigné là bind((host, port)).

On peut lui passer en paramètre le nombre de connexion qui peuvent échouer avant de les refuser, si par exemple vous mettez 5, ça va autoriser 5 échecs de connexion avant que le serveur refuse d'autres connexions supplémentaires mais maintenant depuis python 3.4 ou 3.5 et si on est en python 3.6 donc ça fonctionne. Ce paramètre n'est pas obligatoire.

+ server.py
```py
    #coding:utf-8
    import socket
    
    host, port = ('', 5566)
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré")
    
    while True:
        socket.listen(5)
```
Donc à vous de voir, si vous êtes en python 3.2, vous serez obligé de mettre une valeur 5 ou 10 par exemple, c'est on va dire une valeur raisonnable. 

Si vous êtes comme moi en python 3.5 ou 3.4, vous ne pouvez pas mettre cette valeur et c'est python qui choisiras une valeur raisonnable par rapport à ça donc moi je ne vais pas lui en passer, ou bien je vais te remettre une parce que si y en a qui n'ont pas tous bien écouté et qui sont pas en python 3.5, vous risquez de me demander pourquoi voilà. 

Donc on va faire ça comme ça, on va mettre 5 c'est suffisant par rapport à ça.

Donc là on est sur l'écoute, le serveur écoute sur le port 5566 et est démarré à partir de là. 

Ensuite il faut qu'on accepte les connexions, c'est important donc pour accepter les connexions il faut évidemment en initialiser donc on va faire 2 variables donc en général par rapport au python on appelle ça "conn" pour connexion et ensuite on va avoir l'adresse "address" et là on va pouvoir passer = socket.accept(). 

+ server.py
```py
    #coding:utf-8
    import socket
    
    host, port = ('', 5566)
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré...")
    
    while True:
        socket.listen(5)
        conn, address = socket.accept()
```
Voilà ça va être stocké sous 2 formes, et dans l'adresse on aura éventuellement l'adresse IP et le port. Ça c'est la connexion et en fait l'adresse ce sera comment tableau vous allez avoir la valeur d'indice 0 qui serra bippé donc en l'occurence l'adresse.

Et vous allez avoir la valeur qui est en indice 1 qui sera le port par rapport à ça. 

Donc vous faites la connexion, vous faites l'adresse ici.
```py
    conn, address = socket.accept()
```
On oublie pas et ça on va le faire tout de suite de bien fermer tout ce qu'il faut c'est-à-dire que le socket à partir du moment où il est créé, il faut aussi le fermer une fois qu'on n'en a plus besoin donc on n'oublie pas de faire aussi socket.close() très important.

+ server.py
```py
    #coding:utf-8
    import socket
    
    host, port = ('', 5566)
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré...")
    
    while True:
        socket.listen(5)
        conn, address = socket.accept()
        
    socket.close()
```
Et la connexion ici qui a été initialisée d'accord …
```py
    conn, address = socket.accept()
```
… on n'oublie pas également aussi de la clore à la fin.

+ server.py
```py
    #coding:utf-8
    import socket
    
    host, port = ('', 5566)
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré...")
    
    while True:
        socket.listen(5)
        conn, address = socket.accept()
    
    conn.close()
    socket.close()
```
On ferme évidemment la connexion avant le socket, ça paraît logique.

Donc moi je l'ai fait ici en dehors de la boucle pour être sûr que c'est déconnecté. 

Voilà pour ça. 

À partir de là, notre serveur est en route, alors ici le serveur est démarré et là on va pouvoir mettre si vous voulez en écoute si vous voulez mettre des petits messages pour voir. 

+ server.py
```py
    #coding:utf-8
    import socket
    
    host, port = ('', 5566)
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ")
    
    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("En écoute...")
    
    conn.close()
    socket.close()
```
Alors je met ici le serveur est démarré ...
```py
        print("Le serveur est démarré ! ")
``` 
... même s'il est pas tout à fait démarré à cet endroit-là mais bon c'est pour éviter de répéter le message en écoute et on va pouvoir gérer ça.

Et à partir de là, le serveur va attendre, on est dans une boucle infinie donc il va attendre.

Quand on va démarrer le programme, on va le faire dans un terminal, il faudra couper le terminal pour que ça ferme le serveur d'accord, c'est un peu comme je vous rappelle le serveur http ou même avec Apache, tant que vous ne fermiez pas le terminal il continuait de tourner. 

Et bien là c'est exactement pareil sauf qu'on a un serveur qui attend d'accord.

Il attend mais il écoute en revanche des informations, il est en attente d'informations qui pourrait arriver via le port ici.
```py
    host, port = ('', 5566)
```
Via le port 5566 par exemple en communication avec un éventuel client donc on verra tout ça. 

On ne va pas s'occuper de la réception de données pour le moment, on va s'occuper du client tout de suite et on reviendra sur le serveur après sachant que pour le moment il ne fait que écouter donc il ne va rien réceptionner là. 

Là le serveur en état, il est incapable de réceptionner quoi que ce soit.

+ server.py
```py
#coding:utf-8
import socket

host, port = ('', 5566)

socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
socket.bind((host, port))
print("Le serveur est démarré ! ")

while True:
   socket.listen(5)
   conn, address = socket.accept()
   print("En écoute...")

conn.close()
socket.close()
```
Là le serveur est juste démarré, initialisé et il est en écoute sur un port, et c'est tout. Il ne fait rien d'autre donc il ne peut rien réceptionné, rien traité comme donnée. 

Au niveau du client et c'est là que ça va être intéressant, on va lui passer des informations. 

Le client se connecte donc je rappelle qu'il a besoin qui a besoin d'avoir les informations nécessaires, il a besoin d'avoir une adresse et lui pour le coup il va falloir la renseigner et bien évidemment il y a aussi un port. 

Donc on va faire comme tout à l'heure :

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('', 5566)
```
Comme pour le serveur on va lui passer un tuple avec l'adresse et le port donc le porc il faut que ce soit le même parce que si vous ne mettez pas le même ça ne va pas communiquer ensemble donc ça attention. Et ici comme on est en local, vous mettez soit localhost c'est le nom du serveur local, et si vous voulez renseigner exactement l'adresse IP c'est 127.0.0.1.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
```
Ou,

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('127.0.0.1', 5566)
```
Voilà, l'un ou l'autre.

C'est la même chose, c'est ça pour tout le monde, c'est l'adresse du serveur local ou le fameux localhost. 

Donc vous mettez sous forme d'adresse IP ou sous forme de domaine. 

Et ici on est bon. 

À partir de là on va pouvoir créer le socket donc comme tout à l'heure je ne veux pas m'embêter je vais le copier depuis server.py parce que c'est exactement la même manière de faire. On crée un socket ici.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
```
Ici chacun doit avoir un socket, on crée un socket pour le serveur, on crée un socket pour le client et ensuite chacun communique ensemble. 

C'est un peu comme si vous créez votre téléphone, le socket est comme un téléphone donc l'appareil téléphonique et forcément il faut que vous ayez chacun téléphone pour pouvoir communiquer. 

Avec un seul téléphone on ne peut pas faire communiquer 2 personnes, c'est un peu compliqué, donc là chacun a son socket pour pouvoir communiquer. 

À partir d'ici on va pouvoir le démarrer. 

On a créé le socket dans le client.py, et on va connecter notre client à notre serveur.

Et pour le connecter c'est très simple, il suffit de faire socket.connect() et on lui passe une forme de tuple, 2 informations host et port.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.connect((host, port))
```
L'hôte et le port, ça paraît logique à ce niveau-là. 

Alors ça c'est la manière on va dire naïve. 

On va mettre que le client est quand même connecté.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.connect((host, port))
    print("Client connecté")

Sauf qu'il peut y avoir des exceptions et des erreurs survenues par rapport à ça donc moi je recommande de procéder à une gestion d'erreur tout de suite on va le faire maintenant plutôt que d'attendre la fin donc on fait ça.

+ client.py

    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    
    try:    
        socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        socket.connect((host, port))
        print("Client connecté")
```
On peut tout mettre dans le try: de toute façon. 

En cas d'exception, on peut mettre une exception générale ou bien viser une exception précise, il y avait normalement une ConnetionRefusedError il me semble dans lequel par exemple vous essayez de connecter le client alors que le serveur n'est pas démarré. Vous pourrez éventuellement le récupérer comme ça en faisant ça.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    
    try:    
        socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        socket.connect((host, port))
        print("Client connecté")
    except ConnectionRefusedError:
```
À priori s'il me le met en jaune en tant que coloration syntaxique c'est que ça ne doit pas être faux donc il faudra voir un petit peu mais normalement ConnectionRefusedError, c'est le genre d'exception qui est le fait dans le cas où vous connectez votre client mais vous n'avez pas démarrer votre serveur donc il essaie de se connecter à un serveur qui n'est pas démarré et donc évidemment ça ne marche pas. 

Donc vous pouvez procéder comme ça et faire des choses plus affiné. D'ailleurs vous pouvez faire ça il a cumulé les except comme je vous avais déjà montré en terminant avec un finally voilà.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    
    try:    
        socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        socket.connect((host, port))
        print("Client connecté")
    except ConnectionRefusedError:
    
    except:
    
    finally:
```
Dans le cas où c'est une ConnectionRefusedError, on traite certaines choses si c'est un autre type d'exception on le traite ici except: mais moi je vais le faire de manière générale pour ne pas alourdir le code mais vous pouvez bien sûr faire ça de manière beaucoup plus optimale.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    
    try:    
        socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        socket.connect((host, port))
        print("Client connecté")    
    except:
    
    finally:
```
Donc là je vais mettre connection en serveur échoué ! et je finally c'est quoi ? c'est dans tous les cas qu'on ait réussi à se connecter ou pas, on n'oublie pas de fermer le socket.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    
    try:    
        socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        socket.connect((host, port))
        print("Client connecté")    
    except:
        print("Connexion au serveur échoué !")
    finally:
        socket.close()
```
D'ailleurs au final le socket je peux le faire avant je ne suis pas obligé de le faire là.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    
    try:    
        socket.connect((host, port))
        print("Client connecté !")    
    except:
        print("Connexion au serveur échoué !")
    finally:
        socket.close()
```  
C'est un détail ce n'est pas non plus très très important détails mais vous pouvez très bien créer le socket avant, c'est juste une variable et elle ne va pas générer d exception de toute façon.

Comme ça vous êtes sûr que dans tous les cas vous allez fermer le socket même si ça échoué au niveau de la connexion ici. 
```py
    socket.connect((host, port))
```
Ce n'est pas parce que la connexion a échoué que le socket n'a pas été créé, au contraire le socket a bien été créé donc il faut qu'il soit fermé ici.
```py
    socket.close()
```
Voilà pour cette partie là. 

Donc à partir de ce moment le client est connecté, il se connecter à un serveur, le serveur est démarré et il écoute par contre ils ne font rien. 

Donc ils vont être connectés entre eux, je pense même que là on peut les utiliser, ils vont bien se connecter mais il ne va rien se passer. 

Alors on va démarrer 2 terminaux, un terminal pour le serveur et un terminal pour le client. 

Donc c'est important d'en avoir 2, on y va.
```powershell
    >python server.py
    Le serveur est démarré !
    
    >python client.py
    Client connecté !
    
    >python server.py
    Le serveur est démarré !
    En écoute...
```
On démarre le serveur et on voit qu'il attend effectivement.

tant qu'il ne se passe rien, le serveur évidemment ne va pas écouter d'accord il va écouter à partir du moment où il voit quelqu'un se connecter donc là il reste comme ça. 

Ensuite on y va et on démarre le client. 

Et vous avez vu qu à partir du moment où le client s'est connecté, le serveur s'est mis en écoute et maintenant on a un prompt qui indique bien que le serveur est en écoute …
```powershell
    >python server.py
    Le serveur est démarré !
```
Voilà à partir du moment où le client s'est connecté, le serveur s'est mis en écoute et on a un prompt qui indique bien que le serveur tourne en boucle, on est dans une boucle infinie je rappelle donc il écoute continuellement. 

En revanche le client comment rien faire, envoyer que le programme s'est terminé. D'ailleurs dès que je vais redémarrer client, le serveur va le faire savoir.
```powershell
    >python client.py
    Client connecté !

    >python server.py
    Le serveur est démarré !
    En écoute...
    
    -----------------------
    
    >python client.py
    Client connecté !

    >python server.py
    Le serveur est démarré !
    En écoute...
    En écoute...
    
    -----------------------
    
    >python client.py
    Client connecté !

    >python server.py
    Le serveur est démarré !
    En écoute...
    En écoute...
    En écoute...
```
Le serveur va le faire savoir, on écoute … on écoute … on écoute. 

On pourrait d'ailleurs mettre un autre message, on pourrait mettre un client vient de se connecter pour être plus exact Mais du coup il faut re démarrer le serveur. 

server.py
```py
#coding:utf-8
import socket

host, port = ('', 5566)

socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
socket.bind((host, port))
print("Le serveur est démarré ! ")

while True:
   socket.listen(5)
   conn, address = socket.accept()
   print("Un client vient de se connecter...")

conn.close()
socket.close()
```
D'ailleurs on va faire un test.

Voyez que j'ai que le client ouvert, je n'ai pas de serveur, on va tester de connecter le client à un serveur qui n'est pas ouvert.
```powershell
    >python client.py
    Connexion au serveur échoué !
```
Donc là on voit une petite attente, et la connexion au serveur est échoué. 

Et je vais vérifier parce que je n'étais pas sûr mais on va vérifier ça plutôt que de vous dire des bêtises, est-ce que c'est une ConnetionRefusedError.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    try:    
        socket.connect((host, port))
        print("Client connecté !")    
    except ConnectionRefusedError:
        print("Connexion au serveur échoué !")
    finally:
        socket.close()
```
J'ai un doute, je ne suis pas sûr que c'est ça donc je préfère le vérifier avec vous en vidéo.

Est-ce que c'est bien ça qu'il capte quand il n'y a pas de serveur ?
```powershell
    >python client.py
    Connexion au serveur échoué !
```
Oui c'est bien ça, ConnectionRefusedError, qu'il capte quand il n'y a pas de serveur. 

Donc c'est bien ConnectionRefusedError qui est levé dans le cas où il n'arrive pas à se connecter pour le coup ici au serveur parce que je rappelle que le serveur n'est pas démarré donc forcément c'est embêtant pour lui. 

On y va, on démarre ce serveur. 
```powershell
    >python server.py
    Le serveur est démarré !
```
Voilà le serveur est démarré.

Et cette fois çi, évidemment ça va fonctionner.
```powershell
    >python client.py
    Client connecté !
    
    >python server.py
    Le serveur est démarré !
    Un client vient de se connecter...
```
Voilà un client vient de se connecter, et à chaque fois que je relance mon programme client, il se reconnecte à chaque fois.
```powershell
    >python client.py
    Client connecté !
    
    >python server.py
    Le serveur est démarré !
    Un client vient de se connecter...
    Un client vient de se connecter...
```
Maintenant que les 2 communiquent, vous le voyez, vous vous en rendez compte, ça fonctionne. On va pouvoir leur faire balancer des informations donc nous on va rester sur un exemple simple parce que sinon on risque d'avoir une vidéo très très longue donc on va juste envoyer une information de clients, le serveur va la réceptionner et l'afficher pour lui montrer qu'il a bien reçu tout ce qu'il fallait. 

Et à partir de là vous pourrez bien sûr, plus tard dans de vrais programmes, faire communiquer les 2 entre eux où chacun peut envoyer donner à l'autre et les recevoir, et ainsi de suite. 

Donc ça va se passer ici, là où on va passer les données.

Maintenant que les 2 communiquent, vous le voyez, vous vous en rendez compte, ça fonctionne. On va pouvoir leur faire balancer des informations donc nous on va rester sur un exemple simple parce que sinon on risque d'avoir une vidéo très très longue donc on va juste envoyer une information de clients, le serveur va la réceptionner et l'afficher pour lui montrer qu'il a bien reçu tout ce qu'il fallait. 

Et à partir de là vous pourrez bien sûr, plus tard dans de vrais programmes, faire communiquer les 2 entre eux où chacun peut envoyer donner à l'autre et les recevoir, et ainsi de suite. 

Donc ça va se passer ici, là où on va passer les données.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    try:    
        socket.connect((host, port))
        print("Client connecté !")
        
    #<-----------------
    
    except ConnectionRefusedError:
        print("Connexion au serveur échoué !")
    finally:
        socket.close()
```
Alors le mieux puisqu'on travaille tout le temps en utf-8, ça va être de toujours travailler avec un encodage en utf-8 pour les données comme ça vous êtes sûr que vous pouvez envoyer des accents, vous pouvez envoyer des caractères spéciaux, vous pouvez envoyer n'importe quoi et vous n'aurez pas de problème à ce niveau-là. 

Donc on fera toujours un encodage en utf 8 avant d'envoyer les données et on fera un décodage des données en utf 8 une fois qu'elles ont été reçues donc gardez bien ça à l'esprit, on encode avant l'envoi et on décode après réception comme ça vous êtes sûr de ne rien oublier. 

Par rapport à ça, on y va, on va faire par exemple un data pour utiliser un nom générique, on va lui passer "Bonjour à toi, je suis le client ! :)". Vous voyez que je mets des petits accents, des : et cetera pour voir. 

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    try:    
        socket.connect((host, port))
        print("Client connecté !")
        
        data = "Bonjour à toi, je suis le client ! :)"
    
    except ConnectionRefusedError:
        print("Connexion au serveur échoué !")
    finally:
        socket.close()
``` 
Et ça data, on va l'encoder ça se fait comme ça tout simplement, data.encode() donc sur une chaîne de caractères en l'occurrence, vous utilisez la méthode encode() et voulu passer en paramètre le type d'encodage alors "utf8" ça s'écrit tout attaché. Il n'y a pas de petits tirets entre utf et le 8 contrairement à #coding:utf-8 donc faites attention.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    try:    
        socket.connect((host, port))
        print("Client connecté !")
        
        data = "Bonjour à toi, je suis le client ! :)"
        data = data.encode("utf8")
    
    except ConnectionRefusedError:
        print("Connexion au serveur échoué !")
    finally:
        socket.close()
```  
Attention, peut être que le - ça fonctionne mais moi j'ai toujours écrit comme ça "utf8" donc à priori je pense que ce n'est que comme ça que ça doit s'écrire. 

Voilà pour l'encodage. 

Et ensuite une fois que c'est encodé, on peut envoyer la donnée donc pour la donnée on utilise le socket pour lequel vous avez la méthode send() qui va envoyer la donnée mais on n'est pas sûr que tout va être envoyé donc attention à ça. 

Et si vous voulez vous assurer que tout a bien été envoyé, toutes les informations, vous pouvez même utiliser sendall() donc moi en général j'utilise sendall() pour ce cas là. 

Et on lui envoie data.

+ client.py
```py
    #coding:utf-8
    import socket

    host, port = ('localhost', 5566)
    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    try:    
        socket.connect((host, port))
        print("Client connecté !")
        
        data = "Bonjour à toi, je suis le client ! :)"
        data = data.encode("utf8")
        socket.sendall(data)
    
    except ConnectionRefusedError:
        print("Connexion au serveur échoué !")
    finally:
        socket.close()
```
data, ce qui va se passer, le client va balancer ce texte là en utf 8 sur le port 5566 via le réseau et il attend éventuellement que quelqu'un le récupère. 

Donc le serveur si il ne le récupère pas, l'information sera perdue, on envoie quelque chose que jamais personne ne va récupérer donc le serveur va devoir évidemment récupérer tout ça. 

On y va, on va faire data = socket.recv() pour receved d'accord et ici on va choisir sous forme de … c'est un peu le paquet donc le buffer, la taille de buffer pour la réception de données. La taille de buffer, c'est basé via l'informatique donc ça fonctionne en tant que valeur binaire donc en multiple de 2 donc vous pouvez mettre une taille que vous voulez. Vous pouvez très bien travailler en buffer de 256 par exemple qu'on connait assez souvent, vous pouvez mettre 1024, 2048, ce que vous voulez mais c'est toujours des multiples de 2.

+ server.py
```py
    #coding:utf-8
    import socket

    host, port = ('', 5566)

    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ")

    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("Un client vient de se connecter...")
        
        data = socket.recv(256)

    conn.close()
    socket.close()
```
Vous savez les valeurs en informatique un peu comme vos barrettes de mémoire, on a du 128 méga, on a 256, ensuite on a 512, ensuite on a 1024, 2048, 4096, 8192 et cetera et cetera.

on peut travailler sur du 1024, ce sera suffisant.

+ server.py
```py
    #coding:utf-8
    import socket

    host, port = ('', 5566)

    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ")

    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("Un client vient de se connecter...")
        
        data = socket.recv(1024)

    conn.close()
    socket.close()
```
Après réception comme j'ai dit, on décode la donnée donc data.decode(), et c'est comme tout à l'heure on passe utf8 tout attaché en paramètres. Et ensuite vous pouvez afficher ce que vous avez reçu.

server.py
```py
#coding:utf-8
import socket

host, port = ('', 5566)

socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
socket.bind((host, port))
print("Le serveur est démarré ! ") 

while True:
   socket.listen(5)
   conn, address = socket.accept()
   print("Un client vient de se connecter...")
   
   data = socket.recv(1024)
   data = data.decode("utf8")
   print(data)

conn.close()
socket.close()
```
Donc logiquement le client, il a une donnée, data, il encode() et il l'envoie sendall().

Le serveur récupère la donnée, recv(), il la décode, decode(), et il l'affiche avec print(). 

Alors si tout a bien été fait les 2 vont pouvoir communiquer correctement. 

On démarre un serveur obligatoirement, et quand le serveur est démarré on va lancer le client et on va voir si la donnée a bien été réceptionné. 
```powershell
    >python server.py
    Le serveur est démarré !

    >python client.py
    Client connecté !

    >python server.py
    Le serveur est démarré !
    Un client vient de se connecter...
    Traceback (most recent call last):
      File "server.py", line 954, in <module>
        data = socket.recv(1024)
    OSError: [WinError 10057] Une requête d’envoi ou de réception de données n’a pas été autorisée car le socket n’est pas connecté et (lors de l’envoi sur un socket datagramme en utilisant un appel sendto) aucune adresse n’a été fournie
```
Ah il y a un problème le socket n'est pas connecté alors qu'est-ce que j'ai fait comme erreur ? j'ai fait une bêtise, ce n'est pas le socket qui reçoit recv() mais c'est la connexion.
```txt
data = socket.recv(1024) > data = conn.recv(1024)
```
+ server.py
```py
#coding:utf-8
import socket

host, port = ('', 5566)

socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
socket.bind((host, port))
print("Le serveur est démarré ! ") 

while True:
   socket.listen(5)
   conn, address = socket.accept()
   print("Un client vient de se connecter...")
   
   data = conn.recv(1024)
   data = data.decode("utf8")
   print(data)

conn.close()
socket.close()
```

C'est juste ça, une petite faute de frappe d'accord c'est la connexion parce que tout se passe par là, le socket, on l'a déjà initialisé dans la connexion.
```py
    Conn, address = socket.accept()
```
donc c'est la connexion qui récupère la donnée, du coup on est reparti, on relance le serveur et du coup on n'a pas même pas besoin de recréer un terminal et on y va.   
```powershell
    >python server.py
    Le serveur est démarré !
    
    >python client.py
    Client connecté !
    
    >python server.py
    Le serveur est démarré !
    Un client vient de se connecter...
    Bonjour à toi, je suis le client ! :)
    
    >python client.py
    Client connecté !
    
    >python server.py
    Le serveur est démarré !
    Un client vient de se connecter...
    Bonjour à toi, je suis le client ! :)
    Un client vient de se connecter...
    Bonjour à toi, je suis le client ! :)
```
Et voilà, un client vient de se connecter  "Bonjour à toi, je suis le client ! :)" et on a bien tout qui a été réceptionné, les caractères accentués, les caractères spéciaux sans problème. 

Et le client c'est déconnecté évidemment (Le terminal ne travaille pas !), donc tout a été coupé puisqu'on n'a pas fait de boucle infinie, on n'a pas fait quelque chose qui tournerait. Mais vous pouvez très bien faire un input() où faire une boucle infinie comme ça vous pourriez envoyer tout un tas de données jusqu à envoyer par exemple un mot qui indiquera au serveur que vous quittez la communication pour pouvoir terminé. 

Donc ça c'est à vous de le faire, et moi je ne montre pas ça dans la vidéo parce qu'on n'est pas là pour faire un tuto, ou là pour faire un vrai programme, je suis là pour vous apprendre l'utilisation des sockets. 

En tout cas voilà comment ça fonctionne, en tout cas comme je l'ai dit l'aspect théorique est un petit peu compliqué au départ parce qu'on ne sait pas trop à quoi servent les sockets, on ne comprend pas trop l'idée comment est-ce qu'on peut communiquer en réseau sans être à distance donc il y a beaucoup de gens qui ont du mal avec cette notion là c'est-à-dire qu'une machine toute seule est déjà en réseau elle-même donc ce n'est pas forcément évident pour certaines personnes.

Par contre à partir du moment où vous avez compris l'aspect théorique, la pratique est surtout en python parce que c'est un langage encore une fois beaucoup plus haut niveau que le c plus plus par exemple, et qui est très facile à mettre en place. 

L'utilisation des sockets est vraiment très très simple. 

Alors on va terminer sur la fin de cette vidéo avec un petit bonus notamment sur les threads comme j'en avais parlé puisque de base tel que le système a été conçu, le serveur va pouvoir gérer une seule connexion à la fois donc imaginez un jeu vidéo qui doivent gérer plusieurs personnes c'est-à-dire qu'il doit faire déplacer tous les joueurs ensemble puisqu'ils sont sensés jouer sur le même environnement. 

Si chaque joueur est géré un par un, ça veut dire que pendant qu'on s'occupe d'un joueur, les autres sont figés. D'accord ça veut dire qu'on va attendre, les autres n'auront pas l'information donc entre guillemets, ça va être tout simplement injouable donc impossible à gérer. 

Pour ça quand on a des connexions multiples, il faut évidemment passer par des threads, et chaque client sera lié à un thread pour pouvoir fonctionner, communiquer en parallèle, chacun avec le serveur. 

Alors pour mettre ça en place, il faut revenir sur tout ce que vous avez vu avec les threads dans la vidéo, la séance sur les threads que j'ai proposé sur le cours, et on va mettre ça en place. 

Alors qu'il va devoir mettre en place les threads ? OK ce n'est pas le client. Le client tout ce qu'il fait c'est se connecter à un serveur, c'est tout donc il n'a pas besoin de gérer plusieurs connexions. 

C'est le serveur, c'est celui qui doit gérer les connexions multiples, qui doit intégrer les threads. 

Donc le client vous n'avez pas besoin de modifier son code. 

Là où vous avez besoin de modifier le code c'est pour le serveur, ça c'est important. 

Alors dans ce cas là je peux pas vraiment vous montrer en pratique en termes de code parce que je ne vais pas commencer à vous montrer 15000 clients, ce ne serait pas forcément très explicite mais on va quand même mettre au niveau programmation, un code qui fonctionne pour gérer en tout cas l'aspect thread.

On va créer cette classe. Vous avez vu une classe dans la vidéo précédente, une classe spéciale pour gérer les threads donc on peut le faire éventuellement. 

Alors on va mettre une classe qu'on va appeler ThreadForClient() Avec le module threading.Thread donc on n'oublie pas du coup de l'importer.

+ server.py
```py
    #coding:utf-8
    import socket
    import threading

    class ThreadForClient(threading.Thread):

    host, port = ('', 5566)

    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ") 

    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("Un client vient de se connecter...")
        
        data = conn.recv(1024)
        data = data.decode("utf8")
        print(data)

    conn.close()
    socket.close()
```
Et on va créer notre petite classe ici, rappelez-vous dans la vidéo sur les threads, on pouvait juste passer par une fonction et associer le thread à une simple fonction mais si vous voulez faire ça un peu plus professionnel, vous pouvez carrément faire une classe spéciale, spécifique de Thread pour vos clients et gérer ça là-dedans.

+ server.py
```py
    #coding:utf-8
    import socket
    import threading

    class ThreadForClient(threading.Thread):
        def __init__()

    host, port = ('', 5566)

    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ") 

    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("Un client vient de se connecter...")
        
        data = conn.recv(1024)
        data = data.decode("utf8")
        print(data)

    conn.close()
    socket.close()
``` 
Je vais aller assez vite parce que tout ça on l'a déjà vu précédemment dans la vidéo sur les Threads si ce n'est pas clair pour vous n'hésitez pas à le voir autrement, et on va pouvoir passer pas mal d'informations. Et on va se contenter de self, conn.

+ server.py
```py
    #coding:utf-8
    import socket
    import threading

    class ThreadForClient(threading.Thread):
        def __init__(self, conn):

    host, port = ('', 5566)

    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ") 

    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("Un client vient de se connecter...")
        
        data = conn.recv(1024)
        data = data.decode("utf8")
        print(data)

    conn.close()
    socket.close()
```
On appelle évidemment le constructeur threading.Thread.__init__() pour notre classe mère self parce que je rappelle que ça hérite de la classe Thread du module threading.

+ server.py
```py
    #coding:utf-8
    import socket
    import threading

    class ThreadForClient(threading.Thread):
        def __init__(self, conn):
            threading.Thread.__init__(self)

    host, port = ('', 5566)

    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ") 

    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("Un client vient de se connecter...")
        
        data = conn.recv(1024)
        data = data.decode("utf8")
        print(data)

    conn.close()
    socket.close()
```
On en hérite et ensuite on peut enregistrer le client pourquoi pas, dans notre classe. Comme ça on aura le client (conn), en l'occurrence celui sur lequel on travaille.  

+ server.py
```py
    #coding:utf-8
    import socket
    import threading

    class ThreadForClient(threading.Thread):
        def __init__(self, conn):
            threading.Thread.__init__(self)
            self.conn = conn

    host, port = ('', 5566)

    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ") 

    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("Un client vient de se connecter...")
        
        data = conn.recv(1024)
        data = data.decode("utf8")
        print(data)

    conn.close()
    socket.close()
```
On fait notre fameuse méthode run(), rappelez-vous c'est la méthode qui permet lors du lancement du Thread, de pouvoir faire un certain nombre de choses. 

+ server.py
```py
    #coding:utf-8
    import socket
    import threading

    class ThreadForClient(threading.Thread):
        def __init__(self, conn):
            threading.Thread.__init__(self)
            self.conn = conn
            
        def run(self):

    host, port = ('', 5566)

    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ") 

    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("Un client vient de se connecter...")
        
        data = conn.recv(1024)
        data = data.decode("utf8")
        print(data)

    conn.close()
    socket.close()
```
Et ici on va pouvoir le mettre la réception d'accord, on va faire la réception de l'information et éventuellement de l'affichage. On va peut être me faire l'affichage et donc on va reprendre ce qu'on a mis là … on va faire ça, self.conn.recv(1024). C'est exactement le même code que là. Je peux même faire un copier coller si on veut.

+ server.py
```py
    #coding:utf-8
    import socket
    import threading

    class ThreadForClient(threading.Thread):
        def __init__(self, conn):
            threading.Thread.__init__(self)
            self.conn = conn
            
        def run(self):
            data = self.conn.recv(1024)        #         <------------------
            data = data.decode("utf8")
            print(data)
 
    host, port = ('', 5566)

    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ") 

    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("Un client vient de se connecter...")
        
        data = conn.recv(1024)                #          <------------------
        data = data.decode("utf8")
        print(data)

    conn.close()
    socket.close()
```
Donc du coup cette partie-là, on enlève.

+ server.py
```py
    #coding:utf-8
    import socket
    import threading

    class ThreadForClient(threading.Thread):
        def __init__(self, conn):
            threading.Thread.__init__(self)
            self.conn = conn
            
        def run(self):
            data = self.conn.recv(1024)
            data = data.decode("utf8")
            print(data)
 
    host, port = ('', 5566)

    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ") 

    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("Un client vient de se connecter...")

    conn.close()
    socket.close()
```
Et on va pouvoir du coup gérer notre Thread, on va mettre du coup my_thread = ThreadForClient() Et on va lui passer du coup la connexion.

Voilà c'est tout.

+ server.py
```py
    #coding:utf-8
    import socket
    import threading

    class ThreadForClient(threading.Thread):
        def __init__(self, conn):
            threading.Thread.__init__(self)
            self.conn = conn
            
        def run(self):
            data = self.conn.recv(1024)
            data = data.decode("utf8")
            print(data)
 
    host, port = ('', 5566)

    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ") 

    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("Un client vient de se connecter...")
        
        my_thread = ThreadForClient(conn)

    conn.close()
    socket.close()
```
Alors quand on enregistre une vidéo on a vite fait de faire n'importe quoi donc je fais attention de ne rien oublier et de ne pas aller trop vite. 

Donc ça c'est la classe je vais la séparer avec des petits tirets, histoire de ne pas tout mélanger.

+ server.py
```py
    #coding:utf-8
    import socket
    import threading

    class ThreadForClient(threading.Thread):
        def __init__(self, conn):
            threading.Thread.__init__(self)
            self.conn = conn
            
        def run(self):
            data = self.conn.recv(1024)
            data = data.decode("utf8")
            print(data)
    
    #-----------------------------------------------------------
    host, port = ('', 5566)

    socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    socket.bind((host, port))
    print("Le serveur est démarré ! ") 

    while True:
        socket.listen(5)
        conn, address = socket.accept()
        print("Un client vient de se connecter...")
        
        my_thread = ThreadForClient(conn)

    conn.close()
    socket.close()
```
Donc on a la classe à part, le __init__ et cetera. 

Elle hérite bien : `threading.Thread.__init__(self)`

J'initialise ici la mère : self.conn = conn

Je fais un attribut pour la connexion : data

Et c'est sur la connexion que je réceptionne les données : data = self.conn.recv(1024)

Je décode : data = data.decode("utf8")

Et j'affiche : print(data)

Ok.

À partir de là `#---------------------------------`

Je prépare mon Thread : my_thread = ThreadForClient(conn) donc je viens l'instancier et pour le démarrer.

Et pour qu'il me charge la méthode run(), il faut évidemment faire ce qu'on a vu précédemment sur la vidéo sur les Threads, un petit start().

+ server.py
```py
#coding:utf-8
import socket
import threading

class ThreadForClient(threading.Thread):
    def __init__(self, conn):
        threading.Thread.__init__(self)
        self.conn = conn
        
    def run(self):
        data = self.conn.recv(1024)
        data = data.decode("utf8")
        print(data)

#-----------------------------------------------------------
host, port = ('', 5566)

socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
socket.bind((host, port))
print("Le serveur est démarré ! ") 

while True:
    socket.listen(5)
    conn, address = socket.accept()
    print("Un client vient de se connecter...")
    
    my_thread = ThreadForClient(conn)
    my_thread.start()

conn.close()
socket.close()
```
Et logiquement tout y est, je n'ai rien dû oublier. 

Alors vous n'allez pas avoir beaucoup de différence à l'utilisation dans le terminal puisque je n'ai qu'un seul client pour le coup mais ce n'est pas bien grave. 

On démarre le serveur et on y va pour le client, on teste et on re test.
```powershell
    >python server.py
    Le serveur est démarré !

    >python client.py
    Client connecté !
    
    >python server.py
    Le serveur est démarré !
    Un client vient de se connecter...
    Bonjour à toi, je suis le client ! :)
    
    >python client.py
    Client connecté !
    
    >python server.py
    Le serveur est démarré !
    Un client vient de se connecter...
    Bonjour à toi, je suis le client ! :)
    Un client vient de se connecter...
    Bonjour à toi, je suis le client ! :)
```
Déjà à priori ça fonctionne donc ça devrait être bon, alors le meilleur moyen de tester pour si vous voulez vraiment voir que les Threads fonctionnent. Evidemment ce serait de faire plusieurs clients, vous prenez par exemple une petite variable pour que chaque client ait un numéro ou quelque chose de précis, et comme ça vous verrez qu'il pourra traiter les clients en parallèle, et non plus un par un. 

Un peu comme les mêmes petits programmes qu'on a fait sur la vidéo sur les Threads avec les fameux timer où rappelez-vous avec les petites attentes pour afficher une variable qui s'incrémentait. 

Vous pouvez vous amuser à tester ça mais au lieu que ce soit juste en local, ça va être testé entre client et un serveur donc c'est vraiment la seule différence. 

En tout cas voilà comment ça se met en place, j'ai juste modifié le serveur mais le client lui ne va pas changer, c'est vraiment la partie la plus simple à faire, il n'y a pas beaucoup de code. C'est surtout le serveur qui s'occupe de tout, qui fait tout le travail et qui s'occupe de tout gérer, et de s'arranger pour que l'information arrive à tout le monde, et de gérer toutes les connexions simultanées qui se passe. 

Donc je rappelle que j'ai juste créé ma petite class de Thread ThreadForClient().
```py
    class ThreadForClient(threading.Thread):
        def __init__(self, conn):
            threading.Thread.__init__(self)
            self.conn = conn
            
        def run(self):
            data = self.conn.recv(1024)
            data = data.decode("utf8")
            print(data)
```
Cette petite classe de Thread qui hérite depuis le module Threading, de Thread.

Je fais bien évidemment mon constructeur :
```py
        def __init__(self, conn):
            threading.Thread.__init__(self)
            self.conn = conn
```
... dans lequel j'instancie la classe mère, très important :
```py
            threading.Thread.__init__(self)
```
J'utilise la connection comme un attribut :
```py
            self.conn = conn 
```    
... je le stocke en tant qu'attribut pour pouvoir travailler avec.

Et dans le run(), je fait simplement la réception recv(), le décodage decode() et l'affichage de la donnée.

Et ici, il y a juste a instancier notre classe :
```py
    my_thread = ThreadForClient(conn)
    my_thread.start()
```
... rien de nouveau, et on utilise la méthode start() pour qu'il appelle automatiquement run() d'accord au niveau du Thread. Et ça du coup ce serra passé en parallèle, et si un autre client se connecte que vous faites un autre client, il vont chacun avoir leur Thread dédié et donc pourrons communiquer en parralèle indépendamment avec le serveur, et le serveur pourra gérer tout le monde. 

Voilà comment ça se passe. 

J'espère que ça vous a plu, si vous avez des questions par rapport à ça, des interrogations des choses pas forcément très claires puisque je suis obligé de donner beaucoup beaucoup d'info, de montrer pas mal de code aussi et de ne pas perdre trop de temps non plus mais voilà comment vous expliqué tout dans le détail. 

Donc s'il y a des choses pas suffisamment clair il ne faut pas hésiter à demander surtout là où vous en êtes, maintenant que vous êtes un niveau avancé en python donc c'est le moment. 

C'est la vidéo qui clôture tout le chapitre sur la partie web réseau donc il y aura bien sûr d'autres vidéos, d'autres choses à vous apprendre en annexe dans les tutos mais qui ne sont pas des choses que je estime en tout cas essentiel où indispensable en python. 

Donc là vous avez vraiment le classique ou en tout cas l'essentiel par rapport au langage donc vous pourrez toujours surveiller dans les tutos pour voir s'il n'y a pas d'autre choses qui viennent compléter ces connaissances et ses compétences là. 

Et on va attaquer le dernier chapitre de la formation python, à partir de la vidéo prochaine, qui concerne notamment la 2D avec pygame donc on va utiliser une bibliothèque qui est ici pour le coup, qui est externe. Elle n'est pas native de python, c'est la petite exception mais je trouve vraiment intéressant de faire au moins un minimum, utiliser au moins une bibliothèque 2D en python quand on apprend ce langage. 

Je trouverais cela dommage de passer à côté donc on terminera avec ça. 

On va faire du pygame donc de la 2D, donc jeu vidéo et cetera, tout ce qui est graphique, c'est vraiment du graphique 2D parce qu'on a vu tout ce qui était interface avec tkinter déjà. 

Donc ici on parle vraiment de 2D et de graphique, on va voir ça avec pygame et ça terminera, une fois que pygame aurait été vu, en tout cas pour l'essentiel parce qu'il y aura peut-être aussi d'autres choses dans les tutos, on aura terminé cette formation au langage python. 

D'accord on pourra clôturer cette formation là, elle sera terminée et vous aurez vu toutes les choses en tout cas important à savoir au niveau de python, et vous pourrez compléter encore une fois avec les tutoriels de la playlist, et mettre en pratique et vous entraîner avec les exercices qui vont bien évidemment être publiés progressivement, au fur et à mesure sur la playlist python exercice. 

Voilà je vous dis à bientôt, j'espère que ça vous a plu, j'espère que ça va vous permettre de faire encore plus de choses avec ce langage qui est quand même très facile à mettre en place, très facile à utiliser et beaucoup plus rapide en tout cas que d'autres langages plus bas niveau donc n'hésitez pas. 

Si vous avez des questions c'est toujours pareil, aussi n'hésitez pas à les poser c'est important. 

Je réponds de toute façon comme d'habitude à tous les commentaires, et je vous dis à la prochaine pour la partie sur pygame