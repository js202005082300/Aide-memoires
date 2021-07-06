# [29. Serveur HTTP et page web](https://www.youtube.com/watch?v=5PZ03AO-bmA)

+ [http-server.py](http-server.py)
+ [index.py](index.py)

Bonjour à tous, bienvenue sur la séance 29 en python. 

On attaque comme promis un nouveau chapitre du langage avec la création pour le coup d'un serveur http donc on attaque la partie web et réseaux de cette formation au langage python et je vais vous proposer ce petit serveur à mettre en place en python. 

En quoi ça consiste, nous allons vouloir créer des pages web donc des pages en HTML avec éventuellement du CSS. 

D'ailleurs pour ceux que ça intéresse j'ai une formation HTML/CSS disponible sur la chaîne donc n'hésitez pas à les voir sur les playlists et nous allons faire fonctionner ça. 

Pour ceux qui ont suivi mes cours en PHP, vous avez vu qu'on peut mettre en place un serveur donc il faut utiliser un langage côté serveur, et donc sur la formation PHP, on utilise un Apache pour établir un serveur http et on se sert du langage PHP comme langage dit de back end c'est-à-dire que c'est le langage qui va s'occuper de la partie réseau. Ensuite côté client, on va utiliser le fameux langage HTML/CSS pour faire nos pages web, le design et cetera. 

Donc là on va se charger de faire la même chose sauf que au lieu d'utiliser un langage comme PHP côté serveur, on va utiliser le langage python et on ne va même pas se servir d'apache ou d'un autre logiciel tiers. 

On va juste se baser sur les fonctionnalités natives du langage, on va mettre cela en place et vous allez voir que ça se fait très rapidement. 

On va donc recréer notre petit fichier que je vais appeler http-serveur.py

Voilà on va rester comme ça, on ouvre un petit terminal et on ouvre notre fichier. 

On commence d'abord par mettre notre petit encodage comme on fait tout le temps. 

+ http-serveur.py
```py
    #coding:utf-8
```
Et à partir de là comment est-ce que ça va fonctionner, nous allons utiliser quelques modules évidemment parce que je vous avais dit que c'était natif au langage pour pouvoir établir ce serveur http. 

Le http c'est simplement le protocole que nous allons utiliser, c'est tout ce qui concerne les pages web quand vous visitez un site web, ça utilise en fait la partie HTTP. 

D'ailleurs vous avez remarqué que les adresses commencent par http ou https donc ce n'est pas pour rien. 

Donc on va utiliser le module et je rappelle qu'on travaille toujours en python 3 donc il n'est pas question de faire du python 2 dans notre cas, on importe http.server

+ http-serveur.py
```py
    #coding:utf-8
    import http.server
```
Et on va utiliser un autre module donc je ne vais pas m'interdire énormément dessus parce qu'on aura des vidéos concernant cette autre notion qui concerne les socket qui est baptisé quand même le module socketserver, vous allez voir que ça va vous servir pour le coup.

+ http-serveur.py
```py
    #coding:utf-8
    import http.server
    import socketserver
```
Pour les sockets je reviendrais sur le détail plus tard sur ce que c'est parce qu'on aura l'occasion d'en parler. 

Pour faire simple imaginez simplement un petit moyens de communication, c'est pour faire communiquer 2 applications via un réseau tout simplement. 

Je te fais imaginer comme si par exemple vous aviez 2 postes c'est-à-dire un expéditeur et un destinataire c'est-à-dire une source et une destination la source peut communiquer à la destination et inversement donc c'est justement l'intérêt de pouvoir faire des choses en réseau via ces sockets-là qui vont créer le lien entre l'un et l'autre donc c'est simplement ce fonctionnement. 

Nous on reviendra de toute façon là dessus prochainement plus en détail. 

Ici nous allons d'abord initialiser un port donc le port c'est le port de communication, il va falloir que notre système communique et écoute sur le port en particulier. 

Le port http est initialisé par défaut à 80 donc c'est simplement un numéro qui a été choisi comme ça, ce n'est pas inventé, il a été choisi comme ça de la sorte pour dire que le port http communique sur le port 80. 

Donc nous on ne va pas utiliser un port différent, on va rester sur le port 80. On pourrait éventuellement communiquer sur un autre port, je vous montrerai éventuellement comment faire pour que vous sachiez au moins comment ça fonctionne. Il peut y avoir par exemple certaines fois des conflits si certains parmi vous utilise Skype ou d'autres logiciels comme ça et donc il y a parfois des logiciels comme ça qui rentre en conflit.

+ http-serveur.py
```py
    #coding:utf-8
    import http.server
    import socketserver
    
    port = 80
```
D'ailleurs pour cette vidéo si vous avez Skype d'ouvert sur votre PC ou un autre logiciel qui utilise le port 80, coupez le complètement avant de faire cette vidéo là sinon vous aurez des petits problèmes à l'exécution parce que vous aurez des programmes qui rentre en conflit.

À partir de là on va définir une adresse donc l'adresse c'est simplement une variable qui va prendre ici un tuple. Elle va prendre l'endroit où elle va se connecter et donc comment va se connecter en local, on ne va rien mettre du tout "".

+ http-serveur.py
```py
    #coding:utf-8
    import http.server
    import socketserver
    
    port = 80
    address = ("", )
```
Mais comme on va se connecter en local, elle n'a pas besoin de mettre quelque chose, pas besoin de mettre localhost ou quoi que ce soit, et le porc on a passé juste avant donc on va l'enregistrer ici.

+ http-serveur.py
```py
    #coding:utf-8
    import http.server
    import socketserver
    
    port = 80
    address = ("", port)
```
Voilà ça ce sont les 2 informations qui vont nous servir pour se connecter c'est-à-dire le port et l'adresse de connexion qui utilise le port elle aussi donc le host et le port.

À partir de là, nous allons mettre en place un gestionnaire donc gestionnaire c'est lui qui va gérer tout simplement les requêtes http qui va pouvoir ensuite les traiter et fonctionner de cette manière. 

On va appeler handler, je fais des noms qui sont suffisamment explicites pas besoin de faire des noms très poussé parce que moi ici dans mon exemple le code est tout petit et j'aurais pu par exemple mettre autre chose que port tout court mais là pour l'exemple ce sera suffisant. 

+ http-serveur.py
```py
    #coding:utf-8
    import http.server
    import socketserver
    
    port = 80
    address = ("", port)
    
    handler =
```
Et là on utilise depuis http.server … Alors là si je fais des erreurs parce qu'il y a beaucoup de majuscules et de minuscules dans les noms parce que ils aiment bien en python en mettre de tous les côtés et là normalement on a … http.server.SimpleHTTPRequestHandler Voilà normalement c'est comme ça.

+ http-serveur.py
```py
    #coding:utf-8
    import http.server
    import socketserver
    
    port = 80
    address = ("", port)
    
    handler = http.server.SimpleHTTPRequestHandler
```
Donc on demande en fait à mettre simplement le gestionnaire en place donc là on met simplement un gestionnaire de requêtes http standard d'accord. 

C'est le plus simple qu'il y a d'où le nom : http.server.SimpleHTTPRequestHandler au niveau du gestionnaire. 

Et là on va mettre en place notre httpd donc c'est le nom utilisé et on va appeler la variable de la même façon pour s'y retrouver et préparer notre serveur, on va utiliser le module socketserver pour faire ça. 

+ http-serveur.py
```py
    #coding:utf-8
    import http.server
    import socketserver
    
    port = 80
    address = ("", port)
    
    handler = http.server.SimpleHTTPRequestHandler
    httpd = socketserver...
```
Et là nous allons établir une connexion et pour les types de connexion il y a plusieurs protocoles, il y a notamment TCP et UDP pareil je reviendrais dessus un peu plus tard. 

Dites-vous qu'il y en a simplement un qui demande la connexion et qui vérifie par exemple que les données ont bien été reçues donc c'est forcément un peu plus lent. 

Et il y en a un c'est que vous pouvez envoyer plein de données donc il peut y avoir des pertes de paquets durant l'envoi mais par contre c'est plus rapide mais je ne vais pas vous détailler pour le moment parce qu'il n'y a pas besoin plus que ça pour la vidéo mais comprenez simplement qu'il y a 2 protocoles comme ça dont on aura l'occasion de reparler un petit peu par la suite. 

Donc nous on va utiliser TCP ici parce que ce sera très bien par rapport à ce que l'on veut faire ici donc on va mettre comme ceci TCPServer parce que TCP doit être à priori en majuscule … je pense qu'ils ont dû faire ça comme ça … et on lui passe l'adresse c'est pour ça que j'ai enregistrer ça dans un tuple parce que le jour où je veux pouvoir modifier quoi que ce soit je n'ai plus qu'a modifier ces 2 lignes là ("", port) ce qui est beaucoup plus pratique à la configuration et le gestionnaire comme 2e paramètre (ici on ne passe pas le port parce que je l'ai déjà passé au niveau de address.  

+ http-serveur.py
```py
    #coding:utf-8
    import http.server
    import socketserver
    
    port = 80
    address = ("", port)
    
    handler = http.server.SimpleHTTPRequestHandler
    httpd = socketserver.TCPServer(address, handler)
```
Voilà tout est déjà ici et on passe le gestionnaire handler parce qu'il faut bien qu'on travaille avec celui-là. 

Et là nous avons terminé d'accord au niveau de cette partie là donc on peut afficher parce que c'est quand même plus propre un petit message pour dire que le serveur a démarré sur le port un tel que je vais écrire en f String mais si vous voulez vous pouvez utiliser la syntaxe avec le format(), la méthode format que vous avez déjà appris. 

Je ne reviendrais pas sur cette méthode et on va lui mettre le numéro de port {port}. 

+ http-serveur.py
```py
    #coding:utf-8
    import http.server
    import socketserver
    
    port = 80
    address = ("", port)
    
    handler = http.server.SimpleHTTPRequestHandler
    httpd = socketserver.TCPServer(address, handler)
    
    print(f"Serveur démarré sur le PORT {port}")
```
Et là on n'oublie pas parce qu'on a commencé à créer le serveur mais il faut évidemment le desservir de manière continuelle donc c'est un petit peu comme une boucle infinie, le serveur va démarrer et va tourner en boucle jusqu à ce que vous quittiez ce dernier pour le coupe. 

Donc c'est httpd depuis notre variable et c'est normalement serve_forever() comme ceci et si j'ai fait une erreur de syntaxe on le verra de toute façon à l'exécution mais normalement ça m'a l'air bon donc on verra.

+ http-serveur.py
```py
#coding:utf-8
import http.server
import socketserver

port = 80
address = ("", port)

handler = http.server.SimpleHTTPRequestHandler
httpd = socketserver.TCPServer(address, handler)

print(f"Serveur démarré sur le PORT {port}")

httpd.serve_forever()
```
On verra l'exécution mais normalement ça m'a l'air bon. 

Une fois que cela est fait normalement le serveur est en place. 

On peut le démarrer donc comment démarrer un serveur pour n'importe quelle application que ce soit pour un jeu, que ce soit pour une application communiquante, un site web ce que vous voulez, vous prévoyez un terminal mais le mieux c'est de vous en faire un directement mais ne pas prendre ta terminal intégré à votre éditeur qu'est-ce que c'est parce que sinon quand vous allez vouloir quitter le serveur, il faudra couper l'éditeur complet ce qui est un petit peu embêtant. 

C'est pour ça que nous ouvrons un terminal à part et à l'intérieur nous allons pouvoir le charger. 
```powershell
    >python http-server.py
    Serveur démarré sur le PORT 80
```
Et donc à partir d'ici, il me dit qu'il démarre donc ça a l'air d'être bon. 

Le serveur est démarré sur le port 80, on a évidemment un prompte dans la même fenêtre qui ne bouge pas tout simplement parce que le serveur est en route donc tant que cette fenêtre là va rester ouverte mon serveur sera en route. Un peu à la même manière pour ceux qui ont suivi la formation sur PHP avec le démarrage d'apache. Ça fait exactement pareil.

Voilà on n'a pas utilisé d'apache, on n'a pas utilisé d'autres langages, juste avec python et les modules qu'il peut utiliser, on a mis au point un serveur http. C'est ça qui était super important. 

Comment ça va fonctionner à partir de là ? Eh bien on n'a plus qu'a créer notre petite page HTML, et oui on va faire directement du HTML. 

Donc nous, à l'endroit de notre répertoire python, il considère que c'est le répertoire public donc la racine de mon site web en l'occurrence donc on a plus qu'a créer notre petite page HTML que l'on va appeler index.html, on va rester sur des noms logique. 

+ index.html
```html
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>
    </head>
    <body>

    </body>
    </html>
```
On va enlever une partie parce qu'on s'affiche.
```html
    <!DOCTYPE html>
    <html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>Une page web avec Python et HTML !</title>
    </head>
    <body>

    </body>
    </html>
```
On écrit alors en titre "une page web avec python et HTML !", on met un titre h1 et un paragraphe.
```html
    <!DOCTYPE html>
    <html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>Une page web avec Python et HTML !</title>
    </head>
    <body>
        <h1>Bienvenue</h1>
        <p>Je suis en Python, avec une page web HTML</p>
    </body>
    </html>
```
Et c'est tout et maintenant on va aller ici et démarrer un Firefox. on ne va pas démarrer la page web sinon au risque de faire n'importe quoi il démarrer juste en statique mais ce n'est pas grave. 

On va faire un simple localhost et on y va dans Firefox
```txt
    http://localhost/
    
    Bienvenue

    Je suis en Python, avec une page web HTML
```
Et là vous voyez que c'est bien exécuté directement par le serveur. 

On a bien localhost donc ça je vous rappelle que c'est le serveur local évidemment et donc c'est chargé sans problème au niveau de la page, on a bien le code source qui est affiché au niveau de la page HTML. 

Donc on peut à partir de là comme vous l'avez appris en web, on peut évidemment mettre du CSS ou autre, utiliser d'autres pages web en HTML pour communiquer chacune avec l'autre. 

Alors ça c'était une première étape. 

L'étape suivante, certains vont se demander s'ils doivent communiquer avec des formulaires, comment vont-ils faire ? Alors oui justement pour les formulaires il faudra faire autre chose et si on veut même carrément communiquer tout court parce que python va servir un petit peu de remplacement un peu comme on le ferait avec le PHP c'est-à-dire que au lieu d'avoir du PHP on a du python donc logiquement python étendu côté serveur c'est lui qui va nous permettre de programmer la partie dynamique du site. 

Là le problème c'est que avec ce que j'ai mis en place, on ne pourra faire que du HTML donc ce n'est que du statique on ne pourra pas faire autre chose mais alors comment faire maintenant si je veux avoir plusieurs fichiers python qui communique à l'intérieur avec pas mal de choses? 

Eh bien il va falloir utiliser un autre système, moi aussi je vous ai montré le système basique c'est-à-dire pour faire un serveur http fonctionnelle avec du HTML parce que HTML vous savez que c'est la base pour tout ce qui concerne le web. 

Maintenant si on veut pouvoir programmer directement pour faire une application web donc programmer, il faut utiliser un langage de programmation et donc il va falloir pour voir exécuter un script. 

Par défaut le serveur http … comme vous le voyez c'est pour ça que HTML fonctionne sans problème … Il télécharge le contenu des fichiers, en fait il télécharge vos fichiers à chaque fois et du coup il lit leur contenu. 

Et bien l'avantage c'est que HTML a besoin d'être téléchargé et d'être lu crotte pour être interprétée et du coup afficher des choses donc c'est pour ça que ça fonctionne pour lui. 

En revanche si j'essaye de faire un fichier python et de le faire lire, il va falloir me le télécharger c'est-à-dire télécharger le contenu du fichier et non pas l'exécuter. 

Non ce que l'on veut c'est qu'il exécute le programme c'est donc ici en l'occurrence un programme python et ensuite affiche le résultat de ce programme.

C'est ce qu'on attend, c'est ce qu'on veut faire avec python. Pour ça il faudra procéder autrement donc il va falloir modifier notre serveur c'est-à-dire ne pas faire un simple serveur http mais utiliser ce qu'on appelle les interfaces CGI. 

Alors il y en a peut-être qui savent déjà ce que c'est tant mieux pour vous vous gagnerez du temps mais pour ceux qui ne connaissent pas je vais vous donner une explication très brève. 

Le système de CGI c'est simplement une interface toute bête qui a permis Eh bien au lieu d'avoir ce souci du serveur qui télécharge le contenu de mon fichier, en réalité il va exécuter le fichier. 

Donc si le fichier est un script, ça peut être un script PHP, ça peut être du coup un script en python et ça tombe bien parce que c'est ce qu'on veut faire. Ça pourrait être un script en C pour ceux qui programment en langage c, ça fonctionnerait aussi, CGI est vraiment indépendant du langage utilisé … On peut faire avec Java, on peut faire avec Perl, d'ailleurs Perl et un petit peu le langage historique qui était utilisé pour le script CGI et cetera et cetera. 

Donc c'est vraiment indépendant du langage, donc lui c'est juste une interface qui est vraiment haut niveau qui va se charger d'exécuter le programme et de retourner le résultat. 

Et ça tombe bien parce que c'est ce qu'on aurait par exemple avec PHP donc nous c'est ce qu'on va vouloir faire ici avec python. 

Par contre là il va falloir changer le petit serveur parce que ce serveur ne fonctionne pas en mode CGI donc on va modifier en conséquence pour que ça fonctionne.

+ http-server.py
```py
    #coding:utf-8
    import http.server
    import socketserver

    port = 80
    address = ("", port)

    handler = http.server.SimpleHTTPRequestHandler
    httpd = socketserver.TCPServer(address, handler)

    print(f"Serveur démarré sur le PORT {port}")

    httpd.serve_forever()
```
Donc on va virer scketserver, j'en ai pas besoin pour le coup ici, on va garder port, vous allez voir que la modification n'est pas très longue … on va garder l'adresse parce que je pense que ça peut le faire aussi, on va démarrer le serveur ici.

+ http-server.py
```py
    #coding:utf-8
    import http.server

    port = 80
    address = ("", port)
    
    server = 
```
On laissera quand même les autres lignes. Serveur est égal à http.server.HTTPServer

+ http-server.py
```py
    #coding:utf-8
    import http.server

    port = 80
    address = ("", port)
    
    server = http.server.HTTPServer
```
Et j'espère ne pas me gourer mais on verra aussi. 

Le gestionnaire handler, Eh bien ce n'est plus un SimpleHTTPRequestHandler et cetera mais c'est cette fois çi un CGIHTTPRequestHandler.

+ http-server.py
```py
    #coding:utf-8
    import http.server

    port = 80
    address = ("", port)
    
    server = http.server.HTTPServer
    
    handler = http.server.CGIHTTPRequestHandler
```
Voilà ça c'est un gestionnaire pour le http mais fonctionnement avec l'interface de script CGI donc c'est super important. 

Là handler je vais le modifier un petit peu du coup … par contre httpd je vais les enlever parce que ça va changer.

On peut définir parce que comme il va exécuter des scripts, il ne sait pas où les exécuter par défaut. 

Donc on peut utiliser sur handler, on peut utiliser cgi_directories qui prend du coup une liste de répertoire où il va devoir chercher vos scripts donc nous comme on va rester dans notre dossier on va pas se compliquer la vie du coup on va mettre directement un slash ["/"] pour dire que c'est dans notre dossier la racine et que ce sera toujours comme avant à cet endroit là.

+ http-server.py
```py
    #coding:utf-8
    import http.server

    port = 80
    address = ("", port)
    
    server = http.server.HTTPServer
    
    handler = http.server.CGIHTTPRequestHandler
    handler.cgi_directories = ["/"]
```
Et à partir de là on peut créer le serveur en mettant server() à qui on va passer l'adresse et le gestionnaire handler mais attention ce n'est pas le port.

+ http-server.py
```py
    #coding:utf-8
    import http.server

    port = 80
    address = ("", port)
    
    server = http.server.HTTPServer
    
    handler = http.server.CGIHTTPRequestHandler
    handler.cgi_directories = ["/"]
    
    httpd = server(address, handler)
```
Donc l'adresse et le gestionnaire et après on passe éventuellement le message et à la fin on met toujours server_forever() ça ça ne change pas, c'est toujours le même fonctionnement.
>
+ http-server.py (final)
>
```py
#coding:utf-8
import http.server

port = 80
address = ("", port)

server = http.server.HTTPServer

handler = http.server.CGIHTTPRequestHandler
handler.cgi_directories = ["/"]

httpd = server(address, handler)

print(f"Serveur démarré sur le PORT {port}")
httpd.serve_forever()
```
>
>
>

Alors je vais fermer l'ancien serveur mais ça je ne voulais pas montrer. 

Vous pouvez voir ici que ça a bien été affiché côté serveur et là évidemment il nous dit not found parce que je suis en train de tout changer. 
```powershell
    >python http-server.py
    Serveur démarré sur le PORT 80
    127.0.0.1 - - [21/Oct/2020 08:49:02] "GET / HTTP/1.1" 304 -
    127.0.0.1 - - [21/Oct/2020 08:49:02] CODE 404, message File not found
    ...
```
Et là évidemment il nous a mis not found parce que je suis en train de tout changer et ça ne lui va pas et du coup j'ai tout refermé pour le serveur.  

Donc on ré-ouvre une nouvelle fenêtre dans notre dossier, et je ré exécute … alors j'aurais pu mettre cgi-server.py comme nom mais dans tous les cas ça reste un serveur http. 
```powershell
    >python http-server.py
    Serveur démarré sur le PORT 80
```
Alors en reprenant tout mon code, on est bien sur le port 80. Alors l'adresse et le tuple, c'est comme ça que je veux fonctionner parce que c'est plus pratique. Server = http.server.HTTPServer ça c'est bon et le gestionnaire c'est bon aussi…

Et voilà à priori le serveur est démarré et j'espère qu'il n'y a pas de problème, et là directement on ne travaille plus avec de la page HTML puisqu'on n'est plus en statique, on va utiliser le langage python pour créer nos pages web. 

Donc on va utiliser du HTML au sein des fichiers en python donc on y va, je retirer mon fichier index.html et on va créer un fichier index.py alors pourquoi est-ce qu'on l'appelle index parce que c'est plus pratique de l'appeler comme ça mais vous pouvez l'appeler comme vous voulez tant qu'il a l'extension python, tout va bien. 

#coding:utf-8 alors ça je le mets tout le temps même si par défaut on sait que python 3 gère automatiquement le utf 8 mais je préfère toujours le mettre pour être sûr  et ensuite on va importer le module cgi c'est super important et si vous ne la portez pas vous aurez des problèmes au niveau de vos pages.

+ index.py
```py
    #coding:utf-8
    import cgi
```
Et à partir de là vous allez voir que c'est très très très très simple. 

Première chose maintenant vous voyez qu'on travaille avec les scripts donc il faut bien réfléchir, là notre script quand il va exécuter il ne sait pas ce qu'il va devoir exécuter comme langage donc nous ce que l'on veut, c'est qu'il utilise du HTML parce qu'on veut quand même travailler en acheter ml pour les pages, c'est un petit peu nécessaire voire même indispensable. 

En effet faire un site web sans HTML et CSS, ce serait un petit peu compliqué où en tout cas on n'aurait pas grand chose niveau fonctionnalité, on n'aurait pas de liste ou tout ça bref ce ne serait pas propre du tout donc on va devoir l'avertir. 

Comme c'est un script rappelez-vous, il exécute le programme et il retourne ce qui a été produit, d'accord il va retourner le résultat donc tout ce qu'on va demander à afficher dans ce script sera produit dans le résultat donc ça tombe bien pour ceux qui connaissent au niveau du HTML, vous savez qu'il y a une entête à définir pour dire que nous sommes sur un document HTML. 

Quand on crée un document HTML en faisant simplement le Doctype HTML comme je l'ai fait sur le fichier tout à l'heure, évidemment là toutes les informations étaient disponibles, on avait les balises méta, il y avait la balise Head, bref il y avait tout. 

Là vous pouvez voir qu'il n'y a rien donc lui il ne sait pas qu'il va devoir exécuter du HTML ici, il pourrait très bien d'ailleurs ne pas le faire du tout. 

Je pourrais très bien par exemple faire juste un "ok".

+ index.py
```py
    #coding:utf-8
    import cgi
    
    print("ok")
```
    ... ctrl + F5
```txt
    http://localhost/

    Error response

    Error code: 403

    Message: CGI script is not a plain file ('//').

    Error code explanation: HTTPStatus.FORBIDDEN - Request forbidden -- authorization will not help.
```
Donc là évidemment il nous met qu'il n'y a rien parce que je ne lui ai pas précisé de format parce qu'il faudrait que je mette format plein texte. 

Mais vous voyez il ne trouve pas ce qu'il a besoin d'exécuter parce que il ne sait pas ce qu'il doit exactement exécuter donc nous on va lui donner ce format là, on va lui envoyer un en-tête pour dire qu'on va travailler en HTML donc on va simplement mettre Content-type … et ça c'est assez bizarre parce que c'est des choses qu'on faisait en HTML 4 à l'époque mais c'est vrai que depuis HTML 5, ils nous ont quand même facilité les choses et on n'a plus besoin de mettre ça. 

+ index.py
```py
    #coding:utf-8
    import cgi
    
    print("Content-type: text/html;")
```
Alors on disait qu'on mettait "Content-type: text/html;" Alors ici on met un ; et avant cela on définit le type de contenu donc on a mis un texte plein, on a vraiment mis du HTML et ensuite on peut définir l'encodage parce que ce n'est pas plus mal de leur remettre voilà, charset=utf-8.

+ index.py
```py
    #coding:utf-8
    import cgi
    
    print("Content-type: text/html; charset=utf-8")
```
Alors si je ré-actualise, il ne me dit rien de plus :
```txt
    Error response

    Error code: 403

    Message: CGI script is not a plain file ('//').

    Error code explanation: HTTPStatus.FORBIDDEN - Request forbidden -- authorization will not help.
```
Ce n'est pas grave. 

Donc on définit le type de fichier, je vais également mettre un petit retour à la ligne ce ne serait pas mal \n voilà.

+ index.py
```py
    #coding:utf-8
    import cgi
    
    print("Content-type: text/html; charset=utf-8\n")
```
Là on a défini l'en-tête pour dire que là maintenant on travaille à partir de là sur un affichage dit HTML. 

Donc tout ce qui va être affiché par la suite sera du HTML, on pourra bien évidemment l'associer avec de python si on veut et donc mélanger les 2 mais ce n'est pas le sujet de la vidéo Carnot on travaille avec du HTML ici mais sous forme de script. 

Donc vous pouvez souhaiter afficher directement, on peut très bien faire … et d'ailleurs ce serait assez bizarre ça ne serait pas propre du tout … et je ne sais même pas d'ailleurs s'il va le prendre en compte. Ça c'est la surprise je ne sais pas s'il va l'accepter ? 

+ index.py
```py
    #coding:utf-8
    import cgi
    
    print("Content-type: text/html; charset=utf-8\n")
    
    print("<h1>Bonjour</h1>")
```
Et si je ré-actualise ctrl+F5.
```txt
    http://localhost/index.py

    Bonjour
```
Et donc en fait il a accepté, voilà parce que tant qu'il y a de la valise qu'il rencontre et donc si je fais afficher le code source de la page.
```html
    <h1>Bonjour</h1>
```
Voyez là c'est vraiment pas valide d'un point de vue je sais HTML mais effectivement il affiche bien ici le HTML. 

Donc le mieux parce qu'effectivement vous allez avoir pas mal de balises à écrire, c'est de passer par une variable. 

Donc vous faites par exemple ceci et vous remettez comme tout à l'heure tout votre code HTML et attention on respecte bien les espaces et les tabulations, on est vraiment en Python donc c'est important aussi.

+ index.py
```py
    #coding:utf-8
    import cgi
    
    print("Content-type: text/html; charset=utf-8\n")
    
    html = """<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <title>Ma page web</title>
    </head>
    <body>
        <h1>Bonjour !</h1>
        <p>bla bla bla</p>
    </body>
    </html>
    """
    
    print(html)
```
Et on termine avec nos 3 doubles quotes histoire de faire comme ça sur plusieurs lignes, c'est beaucoup plus lisible au niveau HTML. 

Le seul problème c'est qu'en faisant comme ça, vous voyez qu'il n'y a pas de coloration syntaxique qui se fait, tout se met comme un texte donc évidemment ce n'est pas forcément très pratique donc c'est comme ça qu'on programme en tout cas pour les scripts en CGI.

Et là j'actualise.
```txt
    http://localhost/index.py

    Bonjour !

    bla bla bla
```
Alors c'est comme ça qu'on programme pour les scripts CGI. 

Et en vérifiant le code source nous voyons qu'il a bien géré ça on niveau HTML.
```html
    <html><head>
        <meta charset="utf-8">
        <title>Ma page web</title>
    </head>
    <body>
        <h1>Bonjour !</h1>
        <p>bla bla bla</p>



    </body></html>
```
D'ailleurs si j'active la page du Shell, vous voyez qu'il me met bien CGI script exited donc chaque fois il est quitté et ensuite on le relance toujours via le système GET mais ça on verra plus tard comment transmettre des données via le formulaire et ensuite vous voyez qu'il passe bien par l'interpréteur COMMAND et qu'il exécute ainsi notre fichier.
```powershell
    127.0.0.1 - - [21/Oct/2020 21:42:05] CGI script exited OK
    127.0.0.1 - - [21/Oct/2020 21:56:16] "GET /index.py HTTP/1.1" 200 -
    127.0.0.1 - - [21/Oct/2020 21:56:16] command: C:\Users\js201\OneDrive\Formations\ProgrammesPortable\python\python.exe -u C:\Users\js201\OneDrive\Formations\FormationVideo\Ressources\Python\029_serveur_HTTP_et_page_web\index.py ""
    127.0.0.1 - - [21/Oct/2020 21:56:16] CGI script exited OK
```
Voilà c'est la petite différence donc si vous vouliez faire juste du HTML, vous pouvez vous contenter simplement d'un simple serveur http tout bête, tout standard. 

Et si vous voulez faire des choses un petit peu plus poussé donc de la programmation vraiment … et ça vous aurez de toute façon si vous voulez faire un site ou une vraie application, vous aurez besoin d'utiliser CGI pour exécuter sous forme de script et que à ce moment-là ce soit évidemment plus pratique. 

Alors quelles sont les limitations de CGI parce que je sais qu'il y a des gens qui connaissent et qui vont certainement me poser la question mais je vous devance en tout cas parce que certains vont certainement dire que CGI c'est bien et pas bien parce que le problème de CGI pour ceux qui connaissent en tout cas, ce qu'il va exécuter donc il va démarrer une requête à chaque fois que vous allez faire une actualisation c'est à dire que à chaque fois que j'ai fait une actualisation pour l'afficher, il a démarré un nouveau processus pour exécuter la requête. 

Donc ce qui fait que sur des grosses applications, on peut imaginer que ce n'est pas très très optimisé donc ce n'est pas vraiment le top qui a été fait. 

C'est pour ça qu'ils ont inventé il n'y a pas si longtemps en tout cas ils ont inventé par la suite ce qu'on appelle le FAST CGI. 

FAST CGI, c'est tout simplement un système d'interfaces comme CGI sauf que au lieu d'exécuter à chaque fois un nouveau processus, il ne exécute qu'une seule fois et il sauvegarde en mémoire et comme ça chaque fois que vous avez besoin de faire une nouvelle requête, il récupère ce qu'il y avait déjà en mémoire donc il est un petit peu plus intelligent comme système et ça fonctionne de manière plus pratique. 

Il me semble je ne serais pas étonné du cas on peut utiliser FAST CGI en python même si personnellement je n'ai jamais utilisé FAST CGI en python donc vous pouvez toujours aller voir, je suis sûr qu'il y a un module ou une bibliothèque qui a été conçue pour ça parce qu'on trouve vraiment tout en python donc ça doit forcément exister. 

Mais sinon si vous voulez vraiment faire plus tard un site web beaucoup plus complexe beaucoup plus poussé, il est clair que ce sera peut être pas ça qui vous sera conseillé. 

Moi je vous ai montré qu'en python on peut le faire parce que ici votre intérêt ce n'est pas d'apprendre à créer un site web, c'est d'apprendre le langage python donc je vous montre ici qu'avec Python, vous pouvez faire ceci. 

Vous pouvez faire un serveur et vous pouvez exécuter des scripts CGI. 

D'ailleurs ça aurait pu être fait avec un autre langage si on veut. 

Donc si vous voulez plus tard travailler sur un gros site web avec une grosse application, le mieux sera d'utiliser un FAST CGI, ce sera évidemment plus pratique ou alors de l'utiliser sous forme de modules notamment avec Apache. 

Le fameux Apache qu'on a utilisé sur la formation PHP, vous pouvez l'utiliser également avec python. 

Alors je pense que ça n'a pas encore été encore fait au moment où j'enregistre cette vidéo mais je pense de toute façon faire un tutoriel en annexe sur l'utilisation du module de python pour Apache pour pouvoir simplement charger les scripts de manière plus optimisé au niveau de votre programmation. 

Donc je pense qu'on fera ça, on se mettra en place comme ça, le serveur Apache pour ceux qui ont suivi la formation PHP on déjà Apache installé sur le PC. 

Mais sinon de toute façon on reviendra là-dessus pour remettre en place Apache, charger les bons modules pour avoir comme ça nos scripts python qui s'exécute de manière beaucoup plus optimisée que le système que je vous ai montré là. 

En attendant j'espère que cette vidéo vous a plu, ça vous aura montré en tout cas qu'avec python on peut faire de tout. 

Il n'y a pas besoin d'utiliser un Framework ou une bibliothèque ou autre pour faire du web, ça c'est souvent ce qu'on entend mais ça c'est peut être des gens qui n'ont pas suffisamment cherché pour voir que python avant de faire des frameworks ou des bibliothèques, et bien ces choses-là se base sur le langage propre donc qui utilisent les fonctionnalités du langage pour avoir ensuite un framework en place. 

Pour ceux qui font du Django par exemple ce genre de chose ou d'autres frameworks, sachez qu'ils utilisent les fonctionnalités du langage. 

Django n'est pas né comme ça d'un coup, Django est arrivé grâce à l'utilisation du langage et a permis comme ça de faciliter le développement mais on peut tout à fait faire du web en python sans utiliser de framework. 

C'est tout à fait possible. 

Comme on peut programmer un site en PHP sans utiliser symfony on n'importe quel autre Framework ou à WorkPress donc un CMS ou autre. 

Vous pouvez très bien programmer un site de 0 avec le langage PHP. 

En python c'est pareil, vous pouvez faire du web en partant de 0 juste en utilisant du python sans utiliser de framework ou d'outil déjà fait par quelqu'un d'autre. 

Voilà je pense que j'ai fait le tour de pas mal de choses donc vous avez appris beaucoup de choses dans sa vidéo. 

Vous avez appris à créer un serveur http en python, vous avez appris à créer un serveur http avec gestion de scripts CGI, ce qui est plutôt pas mal. 

Et je vous ai annoncé l'arrivée parce que je pense le faire en tout cas, c'est sûr même, d'un petit tuto qui abordera le module Apache pour faire le serveur http via Apache, et programmer en python. Ce qui sera bien assuré beaucoup plus optimum que ce que je vous ai montré ici mais au moins comme ça vous savez comment fonctionnent les choses. 

Donc vous avez au moins 2 possibilités pour pouvoir mettre en place tout ça. 

Pour les prochaines vidéos nous verrons pas mal d'autres choses concernant le web, on va voir la transmission de données via formulaire, on parlera peut être des sessions et des cookies mais rien de sûr parce que je ne sais pas toujours à l'avance tout ce que je veux aborder parce qu'il y a tellement de choses à aborder que je suis obligé de faire un petit peu le tri et sélectionner les choses intéressantes vraiment et garder les choses secondaires pour les tutos. 

Et on verra, on parlera un peu de client-serveur, on reviendra sur les sockets, on reviendra sur les TCP-UDP tout ça, les protocoles de communication via le réseau et vous aurez comme ça pas mal d'autres petites choses que vous pourrez mettre en application et que vous aurez bien évidemment appris à faire en python. 

Je vous dis à bientôt pour le prochain contenu sur formation vidéo. 

Ciao tout le monde