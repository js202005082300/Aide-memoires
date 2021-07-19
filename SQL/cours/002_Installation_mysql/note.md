# [2. Installation mysql](https://www.youtube.com/watch?v=9azCzs322NU)
14-12-20

Bonjour à tous et bienvenue sur cette 2e séance sur la formation SQL. 

Dans l'introduction précédente je vous avais dit que nous allions travailler sur MySQL donc il fallait choisir une des solutions possibles pour manipuler du SQL parce que le langage tout seul ne permettrait pas de faire grand-chose donc on avait vu plusieurs systèmes de gestion comme Oracle, on avait parlé de SQL Server, SQLite et cetera. 

Et le choix s'est porté sur MySQL pour toutes les raisons que je vous ai énumérées précédemment. 

Alors on va s'occuper de faire l'installation manuelle à la fois sur Windows et GNU Linux. 

Désolé encore une fois, je ne peux pas aider et je ne peux pas vous montrer en vidéo une installation pour Mac os parce que j'en ai tout simplement pas donc ce sera un petit peu embêtant de vous montrer l'installation de quelque chose que je ne possède pas moi même et que je ne peux pas vous montrer en vidéo. 

On se chargera donc de ces 2 là et pour ceux qui sont sur Mac OS, je pense que vous pouvez vous débrouiller puisque c'est assez similaire à Linux. Je pense que vous arriverez à vous dépatouiller au niveau de l'installation par rapport aux explications que je vais donner là et qui vous serviront dans tous les cas. 

Alors pourquoi une installation manuelle, comme pour beaucoup de choses, au moins vous savez ce que vous utilisez, vous savez ce que vous allez installer et comment vous allez le configurer. 

Vous savez que j'ai toujours privilégié ce type d'installation plutôt que de passer par un installeur puisque nous avons pour Windows un installeur automatique pour MySQL afin de tout faire à notre place. 

Alors moi je privilégie tout le temps le système Manuel même si c'est le plus long, même si c'est un petit peu plus barbant pour certains mais au moins vous savez comment le faire. 

Alors s'il suffisait juste d'installer un logiciel, il n'y aurait même pas besoin de faire une vidéo. 

Vous auriez juste à télécharger MySQL installer, vous cliquez sur suivant suivant et vous cochez les choses que vous voulez. Vous l'installer terminé on n'en parle plus donc ça n'aurait absolument aucun intérêt. 

Et il y a fort à parier que via ce procédé là, j'ai envie de dire que 90% d'entre vous ne serait pas ce qu'ils ont installé et en quoi ça consiste. 

Ainsi pour MySQL nous allons installer un serveur et nous allons pouvoir ensuite se connecter à ce serveur via un client. 

Ça c'est des choses que vous allez pouvoir comprendre et réussir à installer parce que vous allez le faire vous-même, vous n'allez pas le faire via un logiciel. 

Pour cela vous allez vous rendre sur la page de MySQL donc mysql.com tout simplement, vous allez pouvoir aller dans la section download et choisir que parce qu'il y a beaucoup de choses à télécharger pour MySQL ou les autres d'ailleurs, il n'y a pas mal pas mal de choses. 

*https://www.mysql.com/fr/downloads/*

Normalement vous devez avoir une section pour MySQL community Edition puisqu'il y a plusieurs licences pour MySQL donc autant prendre celle-là plutôt qu'une version commerciale. 

Alors on va prendre la version sous licence GPL et nous ce qui nous intéressé c'est le serveur : 

*MySQL Community Downloads
MySQL Community Server (GPL)
https://dev.mysql.com/downloads/mysql/*

Ce qui nous intéressé c'est le serveur donc le Community Server (GPL), on ne veut pas Cluster, Router, ça par exemple ce sont des choses que vous pouvez installer qui sont proposées avec l'installateur automatique. 

Nous au moins on sait ce qu'on installent, on va le paramétrer nous-mêmes à la main donc on saura exactement la configuration et ce que nous avons mis sur notre ordinateur. 

Alors vous avez au bas de la page, l'accès selon le système d'exploitation. Si vous voulez les versions 32 bits du logiciel vous pouvez aller sur cette page : https://dev.mysql.com/downloads/windows/installer/8.0.html

Alors si vous n'êtes pas assuré que vous ne savez pas sur quel architecture vous êtes, prenez l'archive 32 bits, elle fonctionnera dans tous les cas et si vous êtes sûr d'être sur du 64, prenez du 64 bits évidemment. 

Alors nous nous allons sélectionner pour Windows.

*https://dev.mysql.com/downloads/mysql/
Select Operating System : Microsoft Windows*

Alors pour les gens qui sont sur Mac OS justement. 

*https://dev.mysql.com/downloads/mysql/
Select Operating System : macOS*

Vous pouvez voir que vous avez un exécutable macOS > DMG Archive.

Un exécutable pour Mac donc à priori vous avez la possibilité de l'installer et je pense que ça va être fait comme Linux c'est-à-dire que l'installation va faire pas mal de paramétrage et de configuration toute seule. 

Vous allez voir que sur Linux ça va aller beaucoup plus vite l'installation puisque la configuration va se faire toute seule en réalité. 

Comme je vais vous le montrer pour Windows, vous saurez quand même manipuler les choses si nécessaire. 

*https://dev.mysql.com/downloads/mysql/
Select Operating System : Ubuntu Linux*

Alors pour Linux vous pourriez éventuellement passer par là c'est à dire récupérer le fichier DEB Bundle qui est un fichier d'installation pour Ubuntu en l'occurrence et apparemment on peut pas récupérer un zip. 

Apparemment ils n'ont que ça c'est que du Ubuntu et il n'y a pas pour les autres Linux ici mais peu importe de toute façon on verra durant l'installation sur Linux par nous-mêmes et on verra que c'est très simple à faire. 

Donc nous on va prendre pour Windows.

*https://dev.mysql.com/downloads/mysql/
Select Operating System : Microsoft Windows*

Et on va prendre l'archive zip, vous voyez que c'est une archive zip et moi je vais télécharger cette archive là.	

*Windows (x86, 64-bit), ZIP Archive*

Au moment où je fais cette vidéo c'est la version 8.0.11-winx64.zip.

Alors j'ai évidemment récupérer tout ça pour gagner du temps que j'ai récupéré ici cette version là. 
```txt
	C:\MyWAMP\mysql-8.0.22-winx64.zip
```
Alors pour gagner du temps je l'ai récupéré ici, cette version là, et on va pouvoir la décompresser donc on va récupérer le dossier. Alors ici il n'y a pas d'installateur, c'est à nous de faire et on va pouvoir placer les choses là où on veut et c'est là que c'est intéressant justement. 

Rappelez vous pour ceux qui ont vu la formation PHP, vous avez vu qu'on a procédé également à une installation aussi bien du serveur Apache, que de PHP de manière manuelle avec la configuration des fichiers fait à la main du coup on sait ce qu'on utilise et ce qu'on a installé. 

Donc ça.
```txt
C.
|__ MyWAMP
	|__ apache
	|__ mysql
	|	|__ bin
	|	|__ docs
	|	|__ include
	|	|__ lib
	|	|__ share
	|__ php
```
Ça va être mon répertoire, normalement à l'intérieur vous avez tout ça répertoire bin, docs et cetera. 

Alors ici je vais le renommer mysql et ce répertoire je vais pouvoir le placer où je veux donc vous pouvez faire un répertoire dans program files, vous pouvez le mettre dans disque local c ou dans vos documents, peu importe, c'est là qu'il y aura l'installation de MySQL. 

Alors pour ceux qui ont suivi ma formation PHP, vous savez que j'avais fait un répertoire sur le disque local c pour mon installation d'apache et l'installation de PHP.

Alors comment aura certainement besoin de faire de la base de données sur la formation PHP parce que je ne l'ai pas fait au moment où je fais cette vidéo, Eh bien je vais en toute logique mettre ça dans mon répertoire c'est-à-dire dans MyWAMP tout simplement.

Donc ici j'ai Apache, j'ai PHP et maintenant je vais ajouter mysql.
```txt
C.
|__ MyWAMP
	|__ apache
	|__ mysql
	|	|__ bin
	|	|__ docs
	|	|__ include
	|	|__ lib
	|	|__ share
	|__ php
```
Voilà tout a été installé en Manuel jusqu à présent donc pour MySQL ça va être la même chose ça c'est la première étape.

Pour Windows donc téléchargement de l'archive, vous faites une extraction et vous la mettez où vous voulez et à partir de là nous allons pouvoir configurer cette installation Parce qu'il suffit pas de se dire qu'on va juste faire ça et lancer MySQL et que ça va fonctionner. 

Il faut évidemment que tout soit configuré. 

À l'intérieur de MySQL, je vais faire un fichier de configuration, je vais le faire ici.
```txt
C.
|__ MyWAMP
	|__ apache
	|__ mysql
	|	|__ bin
	|	|__ docs
	|	|__ include
	|	|__ lib
	|	|__ share
>	|	|__ ???
	|__ php
```
Je vais le faire ici parce que ce sera le fichier de configuration de MySQL. Je pourrais le faire n'importe où sur mon PC si je le voulais mais ce ne serait pas forcément logique. 

Je vais donc le faire là, vous allez créer un fichier que vous allez appeler my.ini et pour Windows on va lui mettre par habitude l'extension .ini tout simplement. 

Attention donc à bien avoir les extensions affichées sur votre système Pour Windows et ça je l'ai déjà dit plein de fois.

Alors on va ouvrir ce fichier et ce fichier de configuration va nous permettre d'indiquer les chemins tout simplement pour la configuration donc on va indiquer [mysqld] alors il y a un d pour le driver c'est-à-dire que c'est le serveur de MySQL donc il y a toujours un d à la fin donc attention ce n'est pas une faute de frappe. Il est bien ici.

+ my.ini
```ini
	[mysqld]
```
Et ensuite nous allons renseigner plusieurs chemins donc plusieurs variables, basedir qui est le répertoire de base donc pour MySQL, suivi d'un = et ensuite on met un chemin.

+ my.ini
```ini
	[mysqld]
	basedir=/
```
Alors même si vous êtes sur Windows, je vous recommande de toujours mettre des slashs parce que je sais que sur Windows ce sont des antislash alors que sur Linux et Mac, ce sont des slashs. 

Pour simplifier les choses vous pouvez mettre des slashs également et ce sera lisible sans problème. 

Alors que veut `basedir=`, il veut le répertoire de MySQL à l'origine donc moi c'est celui-là.
```txt
	C:\MyWAMP\mysql
```
C'est là qu'il y a bin, docs, et cetera. 

Donc je copie le chemin, copier coller et a je remplace par des slash mais si vous voulez vraiment mettre des antislash, il faudra en mettre 2 mais c'est pour ça que je trouve que c'est mieux de mettre des slashs ce qui est beaucoup plus pratique ici.

+ my.ini
```ini
	[mysqld]
	basedir=C:/MyWAMP/mysql
```
Voilà tout est mis là donc ça c'est pour basedir. 

Et ensuite on va avoir besoin d'un répertoire pour les données, qu'est-ce que sont les données ?

alors ce sont notamment votre base de données, les logs ce genre de chose, là où seront enregistrées votre base de données. 

Des fois des gens vont le mettre à part, c'est-à-dire qu'ils peuvent le mettre sur un autre dir, sur un autre endroit mais moi je veux simplement que mon dossier data se trouve dans mysql. Voilà parce que je n'ai pas de contrainte particulière et je n'ai pas envie de faire autrement, je veux rester sur une installation très simple donc je vais juste faire ça.
```ini
	[mysqld]
	basedir=C:/MyWAMP/mysql
	datadir=C:/MyWAMP/mysql/data
```
Je prends juste mon chemin auquel j'ajoute un répertoire data. 

Par défaut c'est-à-dire quand je fais une installation automatique, le répertoire data est déjà présent parce que toute la configuration se fait à votre place mais nous on va voir pour le générer parce que vous voyez qu'ici je n'ai pas de répertoire data. 
```txt
C.
|__ MyWAMP
	|__ apache
	|__ mysql
>	|	|__ bin
>	|	|__ docs
>	|	|__ include
>	|	|__ lib
>	|	|__ share
	|__ php
```

On va donc voir pour le générer parce qu'ici je n'ai pas de répertoire data donc on va devoir générer nos bases de données, générer notre installation par rapport à la configuration d'où la nécessité de faire ce fichier ce qui permet d'avoir les bons chemins. 

Alors ensuite je peux fermer ce fichier là et on va sur un invite de commande, un PowerShell peu importe c'est comme vous voulez nous allons procéder à l'initialisation de ce fameux répertoire data on se servant de notre fichier de configuration. C'est là tout l'intérêt donc on va procéder à ça. 

On va utiliser mysqld dans le répertoire des binaires donc vous allez dans le répertoire MyWAMP/mysql/bin/ est sur Windows si vous voulez avoir le chemin vous n'avez qu'a cliquer dans l'explorateur de fichiers et hop ça vous met tout le chemin complet. On a plus qu'a faire cd et on colle. 
```powershell
	cd C:/MyWAMP/mysql/bin
	.\mysqld...
```
On a plein d'outils très pratique qui vont nous servir et le premier, on va s'occuper pour le serveur avec mysqld et attention parce que si vous faites  mysql ça existe toi aussi donc il faut bien un d ici tout simplement. 

Et on va lui passer l'initialisation, d'abord je veux les fichiers alors c'est –defaults-file je pense qu'il y a un s à default si je ne goure pas et ensuite je vais lui passer le chemin vers mon fichier de configuration donc là pas la peine de vous embêter à le taper à la main il est ici dans mon répertoire et à partir de là vous pouvez laisser les slash ou les antislash, vous pouvez laisser les antislash parce que je rappelle qu'on est sur le terminal Windows donc il comprend bien les antislashs et là on mets ceci.
```ini
	cd C:/MyWAMP/mysql/bin
	.\mysqld.exe --defaults-file=C:/MyWAMP/mysql/my.ini...
```
Ce fichier de configuration peut être un peu n'importe où si vous voulez parce qu'il suffit d'indiquer son chemin donc c'est à partir de ce chemin là tant que vous indiquez le bon, lui tant qu'il retrouve le fichier peu importe où vous mettez sur votre PC, sur n'importe quel disque ça ne lui posera pas de problème mais dans l'idéal faites comme moi j'ai fait c'est beaucoup plus pratique et beaucoup plus simple par la suite. 

On a donc ça ensuite on va passer l'option –initialize donc là on va initialiser le répertoire de données et je crois que c'est tout, on n'a pas besoin de préciser autre chose.
```ini
	cd C:/MyWAMP/mysql/bin
	.\mysqld.exe --defaults-file=C:/MyWAMP/mysql/my.ini --initialize
```
Des fois pour Linux, on aurait pu préciser des utilisateurs mais vous allez voir que pour Linux l'installation se fera de manière automatique donc on n'a même pas besoin de se embêter avec ça. 

Au pire ce n'est pas obligatoire on peut ajouter `--user=mysql` en spécifiant l'utilisateur MySQL mais c'est vraiment utile pour Linux pour gérer les utilisateurs et groupe comme vous l'avez vu pour ceux qui suivent ma formation GNU Linux notamment donc pour Windows on n'a même pas besoin de se embêter avec ça. 

On fait entrer et normalement là il va me créer un répertoire.

```txt
C.
|__ MyWAMP
	|__ apache
	|__ mysql
	|	|__ bin
	|	|__ docs
	|	|__ include
	|	|__ lib
	|	|__ share
>	|	|__ data
	|__ php
```
Voilà, logiquement il doit me créer un répertoire. 

Vous allez voir qu'il va se remplir, un petit répertoire data donc ça c'est important. 

Si vous voyez qu'il ne se crée pas c'est que vous vous êtes trompé quelque part. 

Voilà à priori il a terminé donc nous avons notre répertoire data initialisé. 

Vous voyez ici vous faites toutes les étapes donc vous savez exactement ce que vous faites, c'est là tout l'intérêt de faire une installation manuelle même si c'est plus long mais vous savez absolument tout ce que vous avez fait et pourquoi vous l'avez fait. 

On n'a pas fait les choses au hasard, on n'a pas laissé faire un logiciel à notre place sans comprendre. 

Vous êtes des développeurs là où vous allez faire du SQL et la moindre des choses à mon sens c'est de connaître les outils que vous manipulez. 

C'est bien d'utiliser plein de petits mais quand on ne les connaît pas et qu'on ne sait pas à quoi ils correspondent, je trouve ça encore une fois personnellement un peu dommage. 

Au moins comme ça vous savez ce que vous utilisez. 

Alors un petit point ici c'est que par défaut on a un utilisateur root qui est le super utilisateur et qui va vous permettre de vous connecter via MySQL mais cet utilisateur a eu un mot de passe qui était défini par défaut. 

Alors je sais que c'est quelque chose qui peuvent poser beaucoup de soucis à certaines personnes  qui s'attaque à MySQL ou même à SQL de manière générale alors que ce mot de passe est simplement donnée dans les logs c'est à dire qu'on va avoir notre mot de passe récupéré dans les logs.

Alors ce qu'on peut faire déjà, est-ce qu'on peut démarrer le serveur ? 

On va démarrer notre serveur MySQL et je pense qu'on peut le faire parce qu'on a tout fait donc on va faire .\mysqld.exe qui est notre exécutable et attention c'est bien avec un d parce que si on l'oublie c'est embêtant et l'option –console.
```sql
	>.\mysqld.exe --console
	
	2020-12-15T19:33:10.825508Z 0 [System] [MY-010116] [Server] C:\MyWAMP\mysql\bin\mysqld.exe (mysqld 8.0.22) starting as process 11080
	2020-12-15T19:33:10.872265Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
	2020-12-15T19:33:14.608810Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
	2020-12-15T19:33:15.081194Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060
	2020-12-15T19:33:15.172242Z 0 [System] [MY-010229] [Server] Starting XA crash recovery...
	2020-12-15T19:33:15.181006Z 0 [System] [MY-010232] [Server] XA crash recovery finished.
	2020-12-15T19:33:15.318549Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
	2020-12-15T19:33:15.319057Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
	2020-12-15T19:33:15.445472Z 0 [System] [MY-010931] [Server] C:\MyWAMP\mysql\bin\mysqld.exe: ready for connections. Version: '8.0.22'  socket: ''  port: 3306  MySQL Community Server - GPL.
```
Voilà si tout va bien MySQL démarre et logiquement il vous met cette fenêtre là donc c'est comme pour un serveur web n'importe quoi comme Apache, vous avez une fenêtre ici qui est notre serveur MySQL d'accord. 

Tant que cette fenêtre sera ouverte et tant que ce sera exécuté ici, le serveur tournera. 

C'est pour ça que j'ai bien dit qu'il s'agit d'un serveur MySQL, c'est pas juste un petit programme qui tourne comme ça, c'est réellement un serveur qui utilise des connexions. 

Il y a des sockets, TCP et cetera donc on est vraiment sur du serveur. 

C'est du réseau en fait carrément. 

Ça vous le laisser, vous pouvez laisser la fenêtre réduite il ne faut surtout pas le fermer, il ne faut pas l'enlever. 

Ensuite on ouvre un autre terminal qui va nous permettre de se connecter en tant que client au serveur MySQL et donc d'accéder à nos base de données c'est-à-dire que là dans data :

```txt
C.
|__ MyWAMP
	|__ apache
	|__ mysql
	|	|__ bin
	|	|__ docs
	|	|__ include
	|	|__ lib
	|	|__ share
>	|	|__ data
	|__ php
```
On aura nos bases de données qui vont être disponibles et toutes les informations de nos bases de données. 

On a data/mysql/…, on a ici data/performance_schema/… donc ça ce sont des bases de données par défaut vous allez voir. data/sys/… et cetera. 

```txt
C.
|__ MyWAMP
	|__ apache
	|__ mysql
	|	|__ bin
	|	|__ docs
	|	|__ include
	|	|__ lib
	|	|__ share
>	|	|__ data
>	|		|__ mysql
>	|		|__ performance_schema
>	|		|__ sys
	|__ php
```
Alors on a un fichier qui est très important qui s'appelle avec le nom de l'ordinateur, le nom hostname c'est à dire le nom réseau de votre ordinateur avec l'extension .err donc .error, c'est un fichier de log. 

Ce fichier de log, vous allez pouvoir l'ouvrir, on va l'ouvrir dans un éditeur et Regardez ce que vous avez normalement donc il vous met ça.

+ DESKTOP-SAM.err
```err
	2020-12-14T23:47:41.011823Z 0 [System] [MY-013169] [Server] C:\MyWAMP\mysql\bin\mysqld.exe (mysqld 8.0.22) initializing of server in progress as process 8752
	2020-12-14T23:47:41.035847Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
	2020-12-14T23:47:43.901114Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
>	2020-12-14T23:47:46.945198Z 6 [Note] [MY-010454] [Server] A temporary password 	is generated for root@localhost: ,pkv4kxv04fD
	2020-12-15T19:32:41.402433Z 0 [System] [MY-013169] [Server] C:\MyWAMP\mysql\bin\mysqld.exe (mysqld 8.0.22) initializing of server in progress as process 11224
	2020-12-15T19:32:41.435147Z 0 [ERROR] [MY-010457] [Server] --initialize specified but the data directory has files in it. Aborting.
	2020-12-15T19:32:41.449672Z 0 [ERROR] [MY-013236] [Server] The designated data directory C:\MyWAMP\mysql\data\ is unusable. You can remove all files that the server added to it.
	2020-12-15T19:32:41.461124Z 0 [ERROR] [MY-010119] [Server] Aborting
	2020-12-15T19:32:41.463551Z 0 [System] [MY-010910] [Server] C:\MyWAMP\mysql\bin\mysqld.exe: Shutdown complete (mysqld 8.0.22)  MySQL Community Server - GPL.
```
Il vous met ça : *A temporary password is generated for root@localhost: ,pkv4kxv04fD*

Voilà donc l'utilisateur root qu'on utilisera parce qu'on est en local on ne va pas se embêter à créer des utilisateurs mais vous verrez comment on fait ça en SQL, vous allez l'apprendre. 

Et là on a un mot de passe qui a été généré par défaut donc il est là le mot de passe root par défaut. 

Nous allons donc copier ce mot de passe parce qu'il va nous servir et on va se connecter au serveur MySQL. 

Alors je rappelle que le serveur est toujours lancé ici.
	
+ invite 1
```sql
	>.\mysqld.exe --console
	2020-12-15T19:33:10.825508Z 0 [System] [MY-010116] [Server] C:\MyWAMP\mysql\bin\mysqld.exe (mysqld 8.0.22) starting as process 11080
	2020-12-15T19:33:10.872265Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
	2020-12-15T19:33:14.608810Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
	2020-12-15T19:33:15.081194Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060
	2020-12-15T19:33:15.172242Z 0 [System] [MY-010229] [Server] Starting XA crash recovery...
	2020-12-15T19:33:15.181006Z 0 [System] [MY-010232] [Server] XA crash recovery finished.
	2020-12-15T19:33:15.318549Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
	2020-12-15T19:33:15.319057Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
	2020-12-15T19:33:15.445472Z 0 [System] [MY-010931] [Server] C:\MyWAMP\mysql\bin\mysqld.exe: ready for connections. Version: '8.0.22'  socket: ''  port: 3306  MySQL Community Server - GPL.
```
Voilà je peux le masquer on s'en fout et on va le laisser là. 

Et pour se connecter au serveur, on va d'abord utiliser cd pour avoir accès aux exécutables de MySQL.

+ invite 2
```sql	
	cd C:\MyWAMP\mysql\bin
```
Ça c'est pour rappeler vous avoir accès au exécutable de MySQL. 

Alors petite parenthèse, je ne vais pas le montrer dans la vidéo parce que j'évite de le faire pour ne pas surcharger les variables mais vous avez les possibilités comme pour MinGW pour ceux par exemple qui ont installé tous les outils pour faire de la compilation en langage c sur Windows, je vous avais dit que vous pouviez ajouter le chemin de MinGW\bin à la variable d'environnement PATH donc ça évidemment ça fonctionne pour tout. 

La variable d'environnement PATH est une variable qui va être consultée par votre terminal quand vous allez taper une commande donc là c'est par exemple je fais >mysql dans le terminal, pour lui il va chercher un chemin où il trouve un exécutable qui s'appelle mysql. 

Alors si vous ne touchez à rien ça ne fonctionnera pas, il va vous mettre tout simplement que la commande n'est pas reconnue.
```sql
	>mysql
	'mysql' n’est pas reconnu en tant que commande interne
	ou externe, un programme exécutable ou un fichier de commandes.
```
Par contre si vous ajoutez ce chemin là c'est à dire le chemin vers les binaires de mysql, et bien en tapant mysql, il va voir que dans la variable d'environnement PATH, il y avait ce chemin là donc il va s'y rendre et si dans ce répertoire bin de mysql il trouve un exécutable qui s'appelle mysql.exe Eh bien il pourra l'exécuter. 

Ça je ne vais donc pas revenir dessus, je ne vais pas l'ajouter moi perso pour la vidéo mais vous pouvez le faire. 

Si vous voulez le faire vous allez dans vos variables d'environnement système et vous ajoutez le chemin vers le dossier bin donc ça doit aller jusqu'au dossier bin de mysql à vos variables l'environnement PATH. 

Comme ça vous n'aurez plus besoin de faire comme moi c'est à dire à chaque fois de vous mettre sur le chemin, vous aurez juste à taper mysql et ça va fonctionner directement et vous gagnerez un petit peu de temps. 

Sinon maintenant que je suis dans le terminal dans le bon répertoire Eh bien je vais faire .\mysql.exe -u pour le user à utiliser root et -p parce que nous avons un mot de passe. 

+ invite 2
```sql
	mysql.exe -u root -p
	Enter password:,pkv4kxv04fD
	
	Welcome to the MySQL monitor.  Commands end with ; or \g.
	Your MySQL connection id is 11
	Server version: 8.0.22

	Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
	
	Oracle is a registered trademark of Oracle Corporation and/or its
	affiliates. Other names may be trademarks of their respective
	owners.

	Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.
```
Là il vous demande un mot de passe et ça tombe bien donc c'est celui-là. 

Vous le copier et hop coller et c'est normal que vous ayez des étoiles ********* parce que le mot de passe est masqué par défaut. 

Vous faites 'entrer' et si tout va bien nous avons pu nous connecter et nous avons un prompt avec marqué `mysql>` donc la connexion est effective sur le serveur. 

Par rapport à ça on voit que le serveur n'a pas réagi (serveur). On va quand même laisser le serveur ouvert ici parce que vous allez voir que dans certains cas il va avoir certains comportements par rapport à ce que l'on veut faire. 

On vous indique aussi que vous pouvez taper la commande 'help;' ou '\h' et cetera pour avoir de l'aide si vous voulez. Éventuellement il vous dit que vous pouvez faire '\c' pour effacer les choses via la commande clear selon la commande actuelle quand vous voulez par exemple revenir sur quelque chose enfin bref il y a pas mal de choses. 

Nous ce qui va nous intéresser c'est qu'on a pu effectivement accéder à nos bases donc on va utiliser une première requête Sql que vous allez apprendre et on reviendra dessus bien évidemment, c'est la requête Sql qui permet d'afficher, de lister les bases de données d'accord. 

Il ne s'agira pas des tables de la base comme on va apprendre plus tard mais les bases de données. 

Il suffit de faire show databases avec un s à la fin et on termine chaque requête Sql avec un ; et si vous ne le faites pas il va aller à la ligne pour attendre une suite parce qu'on peut écrire une requête sur plusieurs lignes jusqu à ce que vous mettiez un `;` pour dire que c'est la fin de la requête.
```sql
	> show databases
		-> ;
	ERROR 1820 (HY000): You must reset your password using ALTER USER statement before executing this statement.
```
Alors oui ça il me dit et c'est logique, il faut changer le mot de passe de root avant de pouvoir exécuter ça c'est à dire que c'est une petite sécurité et qu'il va vous forcer à changer le mot de passe par défaut par quelque chose d'autre donc on va le faire. 

On va s'en occuper maintenant. 

On va rester sur mysql (client) alors on est bien connecter, on est bien sûr le prompt mysql et on va utiliser une autre commande. 

Ce n'est pas la peine de l'apprendre par cœur, on reviendra dessus de toute façon sur la formation mais c'est la commande à faire. 

Pareil les commandes vous pouvez les noter, les mots comme ça à la show databases; c'est à dire tous les mots des requêtes précis pour sql. Vous pouvez les noter en majuscule d'ailleurs c'est plus souvent une habitude de le faire en majuscule c'est à vous de voir soit vous mettez en minuscules soit en majuscules. 

Moi ici pour aller vite je tape en minuscule par contre quand je vais écrire des scripts sql, je vais plutôt le faire en majuscules parce que je trouve que c'est plus pratique. 

Là on va faire tout simplement faire alter table qui veut dire modifier la table et moi je veux qu'il modifie user parce qu'on a une table spécifique pour ça suivi de l'utilisateur 'root' avec @ sur 'localhost' donc on est sur un serveur local je rappelle. On le fait suivre par identified by '', identifié par un mot de passe. Et le mot de passe on peut en mettre en et vous mettez ce que vous voulez. Vous pouvez ne pas en mettre du tout ou en mettre un mais moi je ne vais pas en mettre parce qu'en général sur les serveurs locaux par exemple pour ceux qui installent mysql via XAMPP ou WAMP server, vous avez déjà remarqué par défaut souvent root n'a pas de mot de passe donc si vous travaillez qu'en local ce n'est pas un site qui va être auto hébergé et qui va être disponible à l'utilisateur pas besoin de me passe mais bien évidemment si vous travaillez sur un vrai site disponible auprès des gens, il faut évidemment sécuriser ça. Là je n'ai pas du tout un compte sécurisé mais comme c'est accessible qu'en local ça ne risque absolument rien donc voilà.
```sql
	> alter table user 'root'@'localhost' identified by '';
	
	ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ''root'@'localhost' identified by ''' at line 1
```
J'ai fait une erreur quelque part alors oui il n'y a pas de table et c'est user directement parce que j'ai voulu dire en fait alter la table au lieu d'y mettre le nom de la table j'ai écrit le mot table donc c'est alter suivi du nom de la table que vous voulez altérer, modifier et moi c'est user et tout ce que j'ai mis à la suite et à la fin entre petites quotes le mot de passe que vous voulez ou alors vous mettez vide si vous ne voulez pas de mot de passe.
```sql
	> alter user 'root'@'localhost' identified by '';
	
	Query OK, 0 rows affected (0.01 sec)
```
Voilà là il vous met Query OK donc ça a fonctionné à priori et nous allons du coup pouvoir refaire ça. 

Je vais quitter (client). 
```sql
	> exit
	Bye
```
Je quitte et je vais me reconnecter avec le nouveau mot de passe pour voir si ça fonctionne. 
```powershell
	> mysql.exe -u root -p
	Enter password:
```
Il me demande un mot de passe et je fais directement entrer et voilà il s'est connecté donc il a bien pris en compte le changement. 

On refait la commande de tout à l'heure et vous pouvez la noter comme j'ai dit en majuscule.
```sql
	> SHOW DATABASES;
	+--------------------+
	| Database           |
	+--------------------+
	| information_schema |
	| mysql              |
	| performance_schema |
	| sys                |
	+--------------------+
	4 rows in set (0.01 sec)
```
Et si tout a bien fonctionné, vous devez avoir ces bases de données là. 

Alors ce sont les bases de données par défaut, il ne faut pas y toucher, il ne faut pas les supprimer. 

Vous laissez, c'est les bases qui sont gérées pour la plupart d'ailleurs par mysql donc normalement vous avez ces 4 là en tout cas si vous avez ma version de majuscule dessus c'est-à-dire :
```txt
	* information_schema
	* mysql
	* performance_schema
	* sys
```
Et sys pour système donc à priori c'est bon de ce côté là. 

Tout est donc fait pour cette partie là. 

On a téléchargé l'archive et on l'a placé là où on voulait. 

On a fait notre fichier de configuration et on a initialisé les données via notre fichier de configuration pour avoir évidemment tous les chemins qui correspondent. 

On a démarré notre serveur mysql d'accord. 

On s'est connecté via le client au serveur. 

On a modifié le mot de passe root. 

Et là on vient de faire une première requête sql qui nous affiche les bases de données, `SHOW DATABASES;` tout simplement. 

Logiquement je vous ai donc montré tout ce qu'il fallait. 

Maintenant une fois que vous avez fini votre travail sur Windows ici, que vous avez fini ce que vous aviez à faire. Il est mieux, c'est beaucoup plus propre de quitter le serveur c'est à dire de fermer le serveur et si vous ne le faites pas et que vous faites juste fermer la fenêtre, ça va fonctionner bien sûr mais ce n'est pas très propre, ce n'est pas forcément une bonne solution. 

Vous avez une commande pour le faire très rapidement ici donc ce qu'on va faire c'est quitter le client.

+ client
```sql	
	> exit
	Bye
```
Alors ce n'est pas le client qui le fait c'est-à-dire que vous passez sur un autre terminal quel qu'il soit et là je crois que vous avez .\mysqladmin.exe voilà donc l'outil mysqladmin.exe du coup ensuite voulu passer l'utilisateur -u root suivi d'un -p et puis shutdown et comme il n'y a pas de mot de passe je fais directement entré et regardez au niveau du serveur, la fenêtre du serveur voilà il va vous mettre Normal shutdown, vous voyez Shutdown complete.

+ client
```sql
	> mysqladmin.exe -u root -p shutdown
	Enter password:
```

+ server
```sql
	2020-12-15T22:07:48.512720Z 13 [System] [MY-013172] [Server] Received SHUTDOWN from user root. Shutting down mysqld (Version: 8.0.22).
	2020-12-15T22:07:48.512955Z 0 [System] [MY-013105] [Server] C:\MyWAMP\mysql\bin\mysqld.exe: Normal shutdown.
	2020-12-15T22:07:49.066343Z 0 [System] [MY-010910] [Server] C:\MyWAMP\mysql\bin\mysqld.exe: Shutdown complete (mysqld 8.0.22)  MySQL Community Server - GPL.
```
Comme ça on est sûr qu'on a quitté le serveur proprement maintenant je peux fermer ce terminal (server), je peux fermer le terminal qui avait démarré le serveur et terminé. 

Logiquement à partir de là tout est installé mais si j'ai fait un oubli mais qu'à la suite des vidéos on se rend compte qu'on a oublié de configurer quelque chose.

Qu'il y a quelque chose qui ne fonctionne pas par rapport à ce que j'ai proposé ici, on reviendra dessus évidemment mais à priori je ne pense pas avoir oublié quelque chose. 

Ça fait quand même longtemps que je n'ai pas installé de mysql parce que moi je l'avais déjà donc ça fait quand même très longtemps que je n'avais plus fait de installation manuelle de mysql et des fois ça peut changer avec les versions mais logiquement là j'ai dû faire le tour de tout. 

Et comme à priori les requêtes fonctionnaient, c'est que ça ne devrait pas poser de soucis par rapport à ça. 

Ça c'était pour Windows et on va passer maintenant aux gens qui sont sur Linux et vous voyez que c'était quand même relativement rapide même si ça nécessité une installation manuelle. 

Pour Linux ça va aller beaucoup plus vite parce que Linux c'est pratiquement de l'automatique aussi donc vous allez gagner beaucoup de temps. 

Alors nous allons ouvrir un terminal, plus rapide et pour les installations je vous recommandent ça. Vous ouvrez votre terminal ici et vous allez faire un.. mais sachez qu'on est sur un système Debian, Linux Mint, Elementary, ce genre de chose. 

Si vous êtes sur une distribution basée sur Debian ou Ubuntu, vous aurez ce système là. 

Si vous avez encore une fois du Fedora, Arch Linux et cetera, il faudra procéder autrement pour l'installation mais à priori si vous êtes sur ce genre de distribution encore une fois c'est que vous savez un minimum ce que vous faites parce que c'est un petit peu plus compliqué à l'usage que les distributions basées sur Debian. 

On va sur le terminal et on va taper, on va faire un `sudo apt-get update` pour mettre à jour les dépôts.
```bash
	sudo apt-get update
```
Moi j'ai dû le faire parce que j'ai mis à jour le système juste avant de faire la vidéo comme je n'ouvre pas très souvent ce système virtualisé, il avait plein de paquets à mettre à jour donc okay. 

Ensuite on va installer tout simplement apt-get install  mysql-server et ça c'est le nom du paquet que vous avez vu tout à l'heure sur le Deb, c'était marqué sur le site de mysql donc c'est mysql-server mais présent dans les dépôts de Canonical pour Ubuntu.
```bash
	sudo apt-get install mysql-server
```
```txt
	+-------------------------------------------------------+
	| Configuration de mysql-server-5.7						|
	|														|
	| Nouveau mot de passe du superutilisateur de MySQL :	|
	| ****													|
	|						<Ok>							|
	+-------------------------------------------------------+
```
Et lui voyait que au niveau de la configuration, il vous propose donc il va installer ici pour Windows mysql 8 donc c'était une version très récente et là vous voyez quand même que la version est un peu plus ancienne (5.7) parce que ce sont des paquets beaucoup plus stables donc ils prennent des versions plus anciennes mais ça posera pas de problème à priori parce qu'on va faire vraiment du pûre sql. 

On va éviter de travailler avec des choses propre mysql, pourquoi ? Pour que cette formation SQL et Je l'ai appelé comme ça je ne l'ai pas appelé formation MySQL mais Je l'ai appelé SQL cours parce que ça doit pouvoir vous servir dans n'importe quel type de système de gestion. 

Ci-après vous passez sur un système Oracle, il faut que ce que vous ayez appris la plus vous servir donc on évitera au maximum et on le verra peut-être dans une petite annexe, un petit tuto, de faire des choses qui sont propres à MySQL par exemple et qui ne fonctionnerait pas sur Oracle et inversement. 

Si je veux faire des choses propres à un système de gestion qui n'existe que sur le système en particulier, Eh bien je ferais ça sous forme d'annexe dans un tutoriel genre par exemple dans le SQL tutoriel et je ferai des vidéos de ce genre sur cette playlist là. 

Pour la playlist du cours, on se contentera de SQL pûr c'est-à-dire de commander de requêtes qui fonctionneront surtout le SGBD Histoire que ce soit fonctionnel pour tout le monde. 

Alors ici il nous demande un mot de passe du super utilisateur et le problème je vois que si je laisse vide, il ne va pas changer le mot de passe donc là je ne vais pas mettre sans mot de passe parce que je n'ai pas le choix sinon il va me laisser le mot de passe par défaut donc je vais mettre simplement un autre passe bidon 'passe' tout simplement.
```txt
	+-----------------------------------------------------------+
	| Configuration de mysql-server-5.7							|
	|															|
	| Confirmation mot de passe du superutilisateur de MySQL :	|
	| ****														|
	|						<Ok>								|
	+-----------------------------------------------------------+
```
On confirme. 

Voilà donc lui il vous demande directement le mot de passe donc vous n'avez pas besoin d'aller récupérer le mot de passe dans un fichier ou de faire la modification vous-même. 

C'est pour ça que je vous avais dit que ça allait beaucoup plus vite. 

On attend l'installation et ensuite on va démarrer le serveur. 

Les serveurs sur ce système là vont démarrer comme un service c'est-à-dire qu'il va tourner en tâche de fond comme le service Windows vous devrez quitter le service, stopper le service quand vous n'en aurez plus besoin. 

Vous pourriez aussi faire ça sur Windows mais ce n'est pas le sujet de cette vidéo. 

Créer un service sur Windows quelque chose de général propre système donc si vous voulez que votre MySQL tourne en tant que service c'est-à-dire au démarrage de votre PC et qui s'éteigne quand vous éteignez votre PC, faites le. 

Moi c'est pareil j'évite beaucoup ça pour éviter d'avoir 15000 choses qui tournent en arrière-plan sur mon PC. 

Ce n'est pas parce que je démarre mon PC que je vais faire du mysql donc j'aime pas les systèmes qui vont vous démarrez 15000 services au démarrage alors que vous allez peut-être en utiliser que la moitié donc je préfère démarrer les choses quand j'en ai besoin et les quitter quand j'en ai plus besoin. 

Ça c'est mon mode de fonctionnement personnel et après si vous vous procédez autrement, vous pouvez paramétrer mysql sur Windows comme étant un service. 

Il y a aucun problème si vous voulez, vous renseigner sur internet tout ça, ça se fait très facilement. 

Une fois que c'est fait donc pour démarrer le service, donc le serveur mysql donc là on n'aura pas besoin de laisser un terminal ouvert. 

Il suffit avec sudo donc avec les droits, super utilisateur, de faire sudo service donc le service à sélectionné suivi de mysql et la commande start. 
```bash
	sudo service mysql start
```
Voilà entrer et si vous revenez sur le prompt c'est qu'à priori c'est démarrer.

Vous avez donc la commande start pour le démarrer. 

Vous pouvez redémarrer avec restart.
```bash
	sudo service mysql restart
```
Et pour le stopper il suffira de faire stop comme ceci.
```bash
	sudo service mysql stop
```
Pour stopper le système. 

On a également si on a besoin un jour de modifier la configuration de mysql et notamment le fichier my.ini qu'on a vu tout à l'heure sur Windows. 

Vous pouvez enfaite forcer la régénération de la configuration en faisant reload.
```bash
	sudo service mysql reload
```
Si un jour on a des problèmes, on peut aussi avoir force-reload qui permet en fait de forcer le rechargement de la configuration si jamais il y avait des soucis et que ça ne voulait pas fonctionner. 

De toute façon on va le faire on va le tester.
```bash
	sudo service mysql force-reload
```
Alors la commande doit exister parce qu'il n'y a pas eu d'erreur comme quoi c'était une commande incorrecte ou une option incorrecte donc voilà. 

Ce sont des commandes à connaître.
```bash
	sudo service mysql start
	sudo service mysql restart
	sudo service mysql stop
	sudo service mysql reload
	sudo service mysql force-reload
```
C'est la base pour le service de gestion de mysql. 

Alors est-ce qu'il est démarrer ? Un petit restart pour être sûr. 

Alors voilà une fois que le serveur est démarré en tant que service, je ne vais pas vous montrer via le système du processus de Linux mais je dois avoir un service MySQL qui tourne en tâche de fond. 

Je peux fermer ce terminal sans problème d'accord. 

Ce service là tournera tout le temps tout le temps évidemment il sera arrêtée à l'extinction du système. 

Ensuite je vais n'importe quand sur un terminal et on va se connecter en tant que client comme tout à l'heure comme pour Windows mais un peu d'une autre manière, on va pouvoir tout simplement quel version est installée et faire ceci déjà.
```bash
	mysqld --version
```
Voilà il faut bien mettre mysqld parce que rappelez vous c'est pour le driver donc c'est bien la version 5.7. 

Sur Linux vous aurez normalement une version pour Ubuntu plus ancienne que si vous l'installez manuellement sur Windows. 

Sur Windows vous aurez la version 8 donc c'est la plus à jour noise et puis voilà ça c'est bon. 

Alors qu'est-ce que je peux vous dire de plus, avant de démarrer tout on peut peut être regarder où sont les fichiers de config car vous aurez peut-être besoin de voir ça et ça pourra peut-être vous aider on va directement le montrer ici en graphique donc dans etc et ça on en avait parler ainsi vous ne savez pas à quoi ça correspond, je vous invite à aller voir la formation sur GNU Linux qui est dans ma liste de playlist sur formation vidéo et j'explique un petit peu toute l'arborescence de ce système. 

On va voir là dedans je pense qu'ils ont fait un répertoire mysql qu'ils ont dû mettre dans etc parce que etc c'est tout ce qui est configuration de logiciel. 

Et voilà on a:
```txt
	/etc/mysql/mysql.conf.d/mysqld.cnf
```
Tout simplement c'est une re direction

Donc lui vous voyez ce n'est pas .ini mais ce .cnf et logiquement on doit avoir des configurations à l'intérieur. 

Voyez que les fichiers de configuration sont auto-généré et ont déjà été généré pour vous.

On a lui aussi /etc/mysql/my.cnf

Voilà donc c'est ça dans ce fichier /etc/mysql/my.cnf
```txt
	/etc/mysql/conf.d/
	/etc/mysql/mysql.conf.d/
```
Il y a ces 2 répertoires là mais voilà il y a pas mal de choses qui ont changé avec MySQL dans les fichiers et la manière dont tout est configuré. 

Tout est là pas besoin de le configurer mais si vous recherchez un jour le fichier de configuration, ils sont écrit dans /etc/mysql/mysql.cnf aussi.

 Tout est là, tout ce qui est .cnf, tout ce qui est dans /etc/mysql vous avez le nécessaire ici. 

Il y a même /etc/mysql/debian.cnf aussi.

Voilà donc nous on s'en fiche pour ça pas besoin de travailler avec mais ce qui va nous intéresser c'est de pouvoir exécuter les commandes. 

On fait `mysql -u root -p` comme pour Windows.
```bash
	mysql -u root -p
	
	Enter password:
```
Alors le mot de passe est ce que j'ai mis par défaut et ensuite super on se connecte.

On peut faire la même commande.
```sql
	> show databases;
```
Voilà impeccable on a tout. 

Envoyer après les commandes et les requêtes SQL, c'est pareil il n'y aura aucune différence que ce soit sur Windows, sur GNU Linux ou sur Mac OS. 

Ce sera exactement pareil parce que vous avez le même outil derrière, après vous n'aurez pas forcément les mêmes versions. 

Là on est sur la version 5.7. 

Sur Windows, vous aurez une version plus à jour. 

Sur Mac OS, je ne sais pas ça dépend peut-être si vous prenez le exécutable. Je n'ai pas fait gaffe sur le site tout à l'heure de MySQL si c'était la version 8 ou antérieur qu'il y avait mais peu importe de toute façon travaillera avec des choses fonctionnel pour tous parce qu'on travaillera avec dur pûre SQL. 

On va donc quitter.
```sql
	> exit
	Bye
```
On va stopper le service tout simplement pour éviter de le faire tourner pour rien.
```bash
	sudo service mysql stop
```
On peut quitter le système ici, arrêter. 

Voilà je vous ai montré tout ce qu'il fallait donc logiquement à partir de là tout est OK. 

Vous avez tout ce qu'il faut pour l'installation de MySQL que ce soit sur Windows, sur Linux. 

Pour Mac os normalement ça doit être assez similaire à Linux. 

Si vraiment vous avez des problèmes vous pouvez toujours vous renseigner sur internet mais moi je pourrais malheureusement pas beaucoup vous aider concernant Mac OS parce que n'en ayant pas sous la main il n'est pas évident d'aider des gens sur un système qu'on ne peut pas manipuler nous-mêmes ce n'est pas forcément pratique. 

Essayez de vous renseigner parce que je pense qu'il y a tout ce qu'il faut sur internet en cherchant MySQL Pour Mac os, vous devez certainement trouver tout ce qu'il faut et à priori on a fait tout ce qu'il faut pour l'installation et le paramétrage. 

C'est ce que je voulais vous proposer pour cette vidéo. 

À partir de la séance suivante, on va commencer à découvrir ce langage SQL maintenant que tout est prêt et tout est installé. 

Assurez vous que tout est fonctionnel parce que sinon vous ne pourrez pas suivre la suite des vidéos ce serait un peu dommage. 

S'il y a eu le moindre problème pour l'installation et la configuration de quelque chose, ou bien une partie de la vidéo que vous n'avez pas comprise n'hésitez pas à demander dans les commentaires de cette vidéo youtube. 

Évidemment je viendrais vous aider par rapport à ça. 

Je vous dis à très bientôt pour la séance 3. 

J'espère que cette formation va vous plaire parce qu'il y a vraiment beaucoup de choses à voir et ça vous servira encore une fois dans pas mal d'autres cours de web que je propose sur la chaîne. 

À bientôt tout le monde pour la prochaine vidéo