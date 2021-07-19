# [4. Moteur de stockage](https://www.youtube.com/watch?v=jwd2a8qaA4g)
17-12-2020

Bonjour à tous et bienvenue pour la 4e séance en langage SQL. 

Nous allons parler des moteurs de stockage. 

En général quand on apprend le langage SQL ou qu'on travaille sur des bases de données, les gens ont pour habitude de ne pas apprendre, de ne pas se renseigner sur ce principe des moteurs de stockage qui est vraiment très important. 

Moi je profite des premières vidéos de cette formation pour vous l'enseigner parce que c'est quelque chose qu'il faut connaître dès le départ. 

Il est mieux de connaître sa pour commencer et de travailler ensuite avec le bon moteur de stockage pour la suite plutôt que d'attendre d'avoir une base de données qui contient plusieurs gigas ou plusieurs téraoctets, de devoir changer en cours de route et là c'est assez compliqué. 

Prenez dès le départ l'habitude de produire en fait les bons outils, de voir tout le bon environnement pour vos bases de données plutôt que de devoir faire les changements une fois que vous aurez alimenté tout ça avec plein plein de données, des millions de données qui peuvent prendre énormément de place et dans ce cas-là c'est assez compliqué d'effectuer le changement. 

Alors on va déjà se connecter pour commencer.

+ serveur
```powershell
	>mysqld --console
	
	2020-12-17T18:57:51.931343Z 0 [System] [MY-010116] [Server] C:\MyWAMP\mysql\bin\mysqld.exe (mysqld 8.0.22) starting as process 6416
	2020-12-17T18:57:51.959912Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
	2020-12-17T18:57:53.290245Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
	2020-12-17T18:57:53.578694Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060
	2020-12-17T18:57:53.704707Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
	2020-12-17T18:57:53.705452Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
	2020-12-17T18:57:53.789619Z 0 [System] [MY-010931] [Server] C:\MyWAMP\mysql\bin\mysqld.exe: ready for connections. Version: '8.0.22'  socket: ''  port: 3306  MySQL Community Server - GPL.
```
+ client
```powershell
	> mysql -u root -p
	
	Enter password:
	Welcome to the MySQL monitor.  Commands end with ; or \g.
	Your MySQL connection id is 8
	Server version: 8.0.22 MySQL Community Server - GPL

	Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

	Oracle is a registered trademark of Oracle Corporation and/or its
	affiliates. Other names may be trademarks of their respective
	owners.

	Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

	mysql>
```
Voilà je le fais pour la première vidéo mais plus tard je me connecterais avant d'enregistrer la vidéo  mais comme c'est les premières je répète les opérations à chaque fois pour les gens qui auraient des petits oublis. 

Alors on va se connecter avec mysql et ici il n'y a pas de mot de passe. 

La dernière fois on faisait simplement show databases; pour voir par exemple les bases de données.
```sql
	> show databases;
	+--------------------+
	| Database           |
	+--------------------+
	| information_schema |
	| mysql              |
	| performance_schema |
	| sys                |
	+--------------------+
	4 rows in set (0.02 sec)
```
On avait également vu tout ce qui était en codage des données. 

Je vous avais dit que l'informatique au travail principalement avec de l'utf 8 parce que c'est beaucoup plus efficace donc on verra tout ça. 

Alors on va déjà commencer par vous expliquer un petit peu quel est l'intérêt de cette vidéo et qu'est-ce qu'on entend par moteur de stockage. 

Le moteur de stockage c'est ce qui va définir différents algorithmes pour le stockage et c'est pour ça qu'on appelle ça un moteur de stockage et surtout la manière d'accéder aux données avec le système de requêtes telles qu'on la prendra dans les vidéos prochaines. 

Alors il existe plusieurs types de moteurs différents. 

Il y a des moteurs qui sont bien évidemment gérés par défaut selon le type de base, selon la version de mysql que vous utilisez ou tout simplement le type de SGBD que vous utilisez si par exemple vous étiez sur Oracle, Sql server, SQLite et cetera ça peut utiliser des moteurs différents. 

Pourquoi c'est important de se poser cette question là sur l'utilisation d'un moteur de stockage ou d'un autre ? parce qu'ils ont chacun leurs avantages et leurs inconvénients. 

On a des moteurs qui sont dits transactionnels c'est à dire qu'ils vont posséder des systèmes de sécurité. 

Admettons que sur ma base de données, que j'ai une base de données pour des clients et je veux enregistrer 50 clients alors ce n'est pas beaucoup. Encore sur une vraie base de données on aurait beaucoup plus que ça mais déjà sur 50 clients. 

Au moment où je fais cette requête de 50 clients qui vas quand même nécessiter quelques secondes pour se faire ou peut être moins si on a fait vraiment une requête optimisée. Imaginez qu'on ait une interruption de la roquette en cours ou alors par exemple une panne d'électricité, une panne sur un serveur ou autre pendant que la requête se fait, on va obtenir des données corrompues c'est-à-dire qu'elles sont peut être à moitié enregistrer, on aura des données qui seront à moitié tronquée enfin bref on n'aura pas les données complètement enregistrées ce qui va amener à pas mal d'erreur. 

L'avantage des moteurs de stockage dit transactionnel c'est qu'ils vont utiliser des transactions c'est-à-dire qu à partir du moment où on va dire `fais ceci;`
```
	fais ceci;
```
Peu importe le temps que va prendre la requête, on va attendre qu'elle aille jusqu'au bout et vérifier que tout s'est bien passé. 

Jamais il y a eu un accident en cours de route c'est-à-dire qu'il y a eu encore une fois une coupure d'électricité ou de courant voilà une interruption quelles qu'elles soient au niveau de la roquette, on pourra revenir en arrière faire ce qu'on appelle un rollback c'est-à-dire revenir à l'état de la base de données telle qu'elle était avant d'exécuter notre fameuse requête qui pour le coup n'a pas fonctionné. 

Ça c'est très important. 

Comprenez du coup qu'un moteur qui est dit du coup transactionnel sera forcément moins performant et moins rapide puisque chaque fois que vous allez faire une requête, il va y avoir des sécurités qui vont s'appliquer, il va y avoir toute une surcouche qui va protéger en fait l'état des requêtes et surtout l'état de vos bases de données pour être sûr de ne pas les corrompre, pour ne pas les abîmer, pour ne pas avoir besoin de les réparer ou autre.

Voilà donc c'est un système qui a cet avantage là et qui assure que les requêtes qui sont effectuées seront faites de manière fiable d'accord du début à la fin. 

Si il y a un problème ou si il y a un accident, on pourra effectuer un rollback c'est à dire mettre la base de données à l'état telle qu'elle était avant que le problème survienne. 

En face nous avons les moteurs dit non transactionnel tout simplement et qui sont, et c'est parfaitement logique, plus performant et plus rapide parce qu'ils n'ont pas de système de sécurité c'est-à-dire que vous allez faire une requête par exemple quand je fais ça.
```sql
	show databases; 
```
Une requête toute simple alors là évidemment je ne risque pas d'avoir de problème parce qu'on n'enregistre pas de données, rien du tout, on ne lit rien mais s'il y avait par exemple une coupure en plein milieu de ma requête, il n'y a aucune sécurité qui assure que les données auront bien été affectées si j'affecte les données. 

Si jamais ça a planté en plein milieu de la requête, et bien tant pis il n'y aura que la moitié de la requête qui aura été effectif sur les bases de données et le reste non. 

Ça amènera peut-être des corruptions et des erreurs et cetera. 

Du fait qu'il n'y ait pas de sécurité, les roquettes et cetera seront évidemment plus rapides. 

Qui n'était pas de système de sécurité, pas de perte de performance. 

Ça prendra évidemment moins d'espace disque et se sera moins gourmand en ressources parce qu'évidemment le système transactionnel encore une fois comme il fait tout un tas de sécurité, il y a vraiment une surcouche sur l'aspect sécurité et transactions et donc tout ça prend plus de place sur le disque, ça utilise un peu plus de mémoire, de ressources de votre serveur, de votre ordinateur peu importe et évidemment c'est moins rapide parce qu'il y a cette sécurité qui se met en place.

Alors pourquoi est-ce que je parle des 2 ? Parce que je vois beaucoup chez les débutants ou les gens qui vont manipuler un SGBD de manière quotidienne ce qu'ils vont privilégier un ou l'autre des outils on vous disant qu'il faut utiliser un moteur transactionnel parce que c'est top il y a la sécurité et cetera et au moins on est sûr qu'il n'y a jamais de problème … et puis il y en a d'autres qui vont vous dire que non il faut utiliser des systèmes non transactionnels, ils sont très rapides et les bases de données tout ce qu'on veut lorsqu'on manipule des bases on veut que ce soit rapide. 

Imaginez un site web si la personne veut accéder à un forum et lister les message d'un forum, on n'a pas envie qu'il attende 20 secondes pour que ça s'affiche ce qui est parfaitement louable. 

Voilà le problème c'est que ces 2 personnes ont tort parce que vous ne pouvez pas privilégier absolument l'un et absolument l'autre. 

Et c'est pour ça que je fais, c'est le sujet de cette vidéo et c'est pour ça qu'il n'y a pas mal de blabla pour commencer cette vidéo puisqu'il est intéressant pour vous de prendre les bonnes habitudes dès le départ et de savoir qu'on utilisait tel ou tel moteur. 

C'est-à-dire que vous pouvez avoir une base de données avec lequel vous auriez à l'intérieur plusieurs tables, on en parlera dans une vidéo prochaine qui est justement dédiée aux tables sql. 

Et vous verrez que vous pouvez très bien créer des tables avec tel type de moteur de stockage et d'autres tables avec un autre moteur de stockage en fonction de ce que vous voulez faire donc ça c'est super super important. 

On n'est pas encore sur la vidéo sur tout ce qui concerne la gestion des tables donc on verra ça plus tard. 

On verra par exemple comment spécifier le moteur que l'on veut sur les tables en question, sur lesquels on va travailler. 

Il y a 2 types de moteurs principaux, il y en a plein évidemment il y a plein plein de moteur qui sont utilisables, même des moteurs qui peuvent dépendre d'un certain SGBD mais on a des moteurs on va dire générique c'est-à-dire qu'ils fonctionneront un peu partout. 

Et il y en a 2 à connaître que je note ici que vous avez peut-être déjà entendu parler si vous avez déjà fait un petit peu de sql et des moteurs que vous allez revoir souvent. 

Nous avons l'historique MyISAM qui est essentiellement ISAM tout simplement mais qui a changé par la suite et nous avons InnoDB.
```txt
	MyISAM
	InnoDB
```
MyISAM c'est la référence du moteur de stockage dis non transactionnel. 
```txt
	MyISAM (non transactionnel)
	InnoDB
```
C'est lui qui sera très rapide, c'est lui qui prendra pas beaucoup d'espace sur le disque, qui ne sera pas très gourmand en ressources et cetera. 

InnoDB c'est le transactionnel donc la référence du moteur transactionnel.
```txt
	MyISAM (non transactionnel)
	InnoDB (transactionnel)
```
C'est lui qui assure la sécurité, l'intégrité, la cohérence enfin bref tout ce qui est question d'intégrité de données c'est à dire qu'on s'assure qu'elles ne soient pas corrompues parce que la cohérence des données c'est encore autre chose et ça n'a rien à voir avec l'intégrité. 

L'intégrité c'est de s'assurer que les données ne sont pas corrompues, qu'elles ne sont pas abîmées, tronquées. 

Alors que là cohérence c'est un s'assurer que les données ont des relations correctes entre elles donc cohérente. 

Voilà les 2 moteurs avec lequel vous allez travailler pratiquement tout le temps. 

Il y a aussi un moteur memory qui lui va directement travailler sur la mémoire vive, c'est juste ça, c'est Memory.
```txt
	MyISAM (non transactionnel)
	InnoDB (transactionnel)
	Memory
```
Son avantage en lui et j'en parle parce qu'il est intéressant à connaître ce qui va permettre de travailler sur des données temporaires volatile puisque tout s'enregistre en mémoire vive donc pas d'espace disque.
```txt
	MyISAM (non transactionnel)
	InnoDB (transactionnel)
	Memory (pas de place sur l'espace disque, tout en RAM)
```
Alors à quoi ça peut servir, ça va servir par exemple quand on aura besoin de manipuler des données qu'on va utiliser pendant un petit moment et que après on n'en a plus besoin. 

Pour avoir quelque chose d'ultra-rapide plutôt que de travailler sur disque dur, on travaillera du coup sur SSD puisque ça peut être n'importe lequel, on va travailler directement en mémoire vive. 

Par contre évidemment en cas de panne de courant ou n'importe quoi, vous vous doutez bien s'il y a une panne et comme la mémoire vive est une mémoire volatile donc ce qui est enregistré dessus va s'effacer, ce sera perdu. 

Voilà j'en parle parce que peut-être qu'un jour dans votre métier ou autre, vous aurez peut-être besoin de travailler avec des données temporaires et des données ultra rapides. 

Dans ce cas-là le moteur Memory sera tout à fait le bienvenu. 

Alors il y en a plein d'autres il y a CSV, Federated, enfin il y a vraiment plein plein d'autres moteurs et il y en a plein que je ne connais pas parce que je ne les ai jamais utilisé.

Moi j'ai juste dans mon cas personnellement utilisé ces 2 là MyISAM et InnoDB et dans certains cas précis utilisez Memory mais plus par curiosité parce que je voulais voir comment ça fonctionnait et quel rapidité ça pouvait avoir mais je n'ai pas forcément eu besoin de contexte particulier qui justifierait l'emploi de celui-là. 

Par contre les 2 premiers oui parce que encore une fois MyISAM va être utile dans certains cas et InnoDB utile dans d'autres. 

Si je veux manipuler des données qui ont absolument besoin de garder leur intégrité et de sécuriser, je vais travailler avec InnoDB. 

Si en revanche je veux privilégier absolument la performance au risque d'avoir des problèmes avec les données, je vais privilégier MyISAM. 

N'écoutais pas et surtout ne fonctionnait pas dans le principe de j'utilise tout le temps MyISAM par exemple si je prends les 2 en référence ou j'utilise tout le temps InnoDB. 

C'est ridicule et ça ne veut rien dire et dans tous les cas vous aurez une base de données qui sera performante à 50%, pourquoi ? Si dans certains cas, vous ne travaillez que sur MyISAM et bien ce sera bien, ils ont d'autres cas ce ne sera pas du tout le bon moteur et vous allez réduire drastiquement les performances de vos bases de données. 

Et même chose pour InnoDB si vous utilisez absolument que celui-là. 

Alors au niveau de MySQL puisque c'est le SGBD que nous utilisons pour cette formation, il faut savoir que sur des versions antérieures à la 5.5 si je ne dis pas de bêtises, le moteur utilisé par défaut était MyISAM et depuis la 5.5, ils sont passés encore une fois par défaut à InnoDB simplement parce qu'il faut bien choisir un moteur par défaut et on ne peut pas en choisir plusieurs à la fois donc ils ont fait ce choix là et c'est un choix arbitraire que vous pouvez évidemment modifier. 

On va voir de toutes façons cela par la suite. 

Alors comment modifier ce moteur par défaut si vous le voulez, qu'est-ce que ça veut dire ? Dès que par exemple vous allez vouloir créer une nouvelle table plutôt que de devoir le renseigner à chaque fois, ça utilisera le moteur par défaut défini par votre système et vous allez pouvoir le modifier le changer. 

Donc pour cela nous avons 2 possibilités, soit on le fait directement sur le client mysql (terminal 2) en faisant la requête SET storage_engine où ici c'est des underscores pour les commandes de configuration, égal = le moteur que vous voulez par exemple InnoDB.
```sql
	SET default_storage_engine = InnoDB;
```
Voilà ce genre de chose et je ne vais pas l'enregistrer maintenant parce que ce que je vais faire avant c'est ça, la commande ici.
```sql
	> SHOW ENGINES;
	+--------------------+---------+--------------+--------------+------+------------+
	| Engine             | Support | Comment      | Transactions | XA   | Savepoints |
	+--------------------+---------+--------------+--------------+------+------------+
	| MEMORY             | YES     | Hash base... | NO           | NO   | NO         |
	| MRG_MYISAM         | YES     | Collectio... | NO           | NO   | NO         |
	| CSV                | YES     | CSV stora... | NO           | NO   | NO         |
	| FEDERATED          | NO      | Federated... | NULL         | NULL | NULL       |
	| PERFORMANCE_SCHEMA | YES     | Performan... | NO           | NO   | NO         |
	| MyISAM             | YES     | MyISAM st... | NO           | NO   | NO         |
	| InnoDB             | DEFAULT | Supports ... | YES          | YES  | YES        |
	| BLACKHOLE          | YES     | /dev/null... | NO           | NO   | NO         |
	| ARCHIVE            | YES     | Archive s... | NO           | NO   | NO         |
	+--------------------+---------+--------------+--------------+------+------------+
	9 rows in set (0.00 sec)
```
La commande SHOW ENGINES; comme pour SHOW DATABASES; permet simplement d'afficher le type de moteur disponible dans ma version MySQL donc ici moi sur Windows la version 8 la dernière alors que sur Linux que je vous avais montré dans une vidéo précédente, on avait installé la version 5.7. 

Ici vous pouvez voir les moteurs disponibles, ceux qui sont supportés ou non par défaut et cetera. Vous avez ensuite une petite description, ensuite ceux qui gèrent les transactions et voilà les sauvegardes et cetera. 

Voyez que InnoDB vraiment aspect sécurité, il est vraiment orienté sécurité alors que les autres sont plus orientés performance. 

On retrouve ceux dont je vous ai parlé Memory, CSV, MyISAM, InnoDB évidemment donc on voit qu'ils sont évidemment gérés et comme ici je suis sur la version MySQL 8 je vous avais dit que à partir de la 5.5 encore une fois si je ne me trompe pas InnoDB est le moteur par défaut. 

Si on veut changer ça, on peut faire SET storage_engine égal MyISAM avec un M majuscule et ISAM tout en majuscules et le y en minuscule. 

Je fait ça et.. 
```sql
	> SET storage_engine = MyISAM;
	
	ERROR 1193 (HY000): Unknown system variable 'storage_engine'
```
Alors je me suis gouré sur la commande, j'avais oublié ça donc c'est SET default_storage_engine. Voilà j'avais un petit trou de mémoire mais c'est pas grave. 
```sql
	> SET default_storage_engine = MyISAM;
	
	Query OK, 0 rows affected (0.00 sec)
```
Ensuite je vais faire à nouveau `SHOW ENGINES;` et normalement ça a dû changer, il a dû mettre le default sur MyISAM.
```sql
	> SHOW ENGINES;
	+--------------------+---------+-------------+--------------+------+------------+
	| Engine             | Support | Comment ... | Transactions | XA   | Savepoints |
	+--------------------+---------+-------------+--------------+------+------------+
	| MEMORY             | YES     | Hash bas... | NO           | NO   | NO         |
	| MRG_MYISAM         | YES     | Collecti... | NO           | NO   | NO         |
	| CSV                | YES     | CSV stor... | NO           | NO   | NO         |
	| FEDERATED          | NO      | Federate... | NULL         | NULL | NULL       |
	| PERFORMANCE_SCHEMA | YES     | Performa... | NO           | NO   | NO         |
	| MyISAM             | DEFAULT | MyISAM s... | NO           | NO   | NO         |
	| InnoDB             | YES     | Supports... | YES          | YES  | YES        |
	| BLACKHOLE          | YES     | /dev/nul... | NO           | NO   | NO         |
	| ARCHIVE            | YES     | Archive ... | NO           | NO   | NO         |
	+--------------------+---------+-------------+--------------+------+------------+
	9 rows in set (0.00 sec)
```
Voilà vous pouvez voir que MyISAM est devenu le moteur par défaut. 

Chaque fois que je vais créer une table ou autre, il va créer par défaut la table avec le moteur MyISAM. 

Et si je vais remettre les choses telles qu'elles étaient, je vais laisser tel que c'est.
```sql
	> SET default_storage_engine = InnoDB;
	
	Query OK, 0 rows affected (0.00 sec)
```
Voilà OK pour ça okay pour ça et normalement je vous ai dit tout ce qu'il fallait à ce sujet. 

Si par contre on va modifier cette configuration de manière définitive, on peut le faire dans le fichier de configuration donc le fameux my.ini ou le mysql.cnf comme ce que vous avez sur Linux. 

Tout ce que je vous ai montré précédemment donc maintenant vous savez modifier. 

Vous voyez l'intérêt de toutes les vidéos précédentes c'est que tout ce qu'on a vu avant va vous servir pour la suite. 

Si un jour vous avez besoin de modifier la configuration du serveur, du client ou de mysql, Eh bien vous serez où le faire parce qu'on a vu tout ça avant. 

Vous savez quel fichier éditer, vous n'êtes pas perdu en utilisant un outil que vous ne connaissez pas ce qui serait quand même assez problématique en étant informaticien. 

Alors sur quoi est-ce qu'on va l'appliquer ? On va l'appliquer sur [mysqld] puisqu'il s'agit du serveur et le serveur on peut lui ajouter l'information donc c'est default-storage-engine avec des tirets et attention ce ne sont pas des underscores. Les underscores c'est sur le client généralement dans le fichier de configuration c'est tout le temps des tirets et vous mettez égal ce que vous voulez = on peut mettre InnoDB, on peut mettre MyISAM bref celui que l'on veut si vous voulez vous assurer de l'avoir par défaut.

+ my.ini
```ini
	[mysqld]
	basedir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql
	datadir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql/data
	character-set-server = utf8mb4
	collation-server = utf8mb4_unicode_ci
>	default-storage-engine = InnoDB

	[mysql]
	default-character-set = utf8mb4

	[client]
	default-character-set = utf8mb4
```
Alors moi je sais que par défaut ma version de MySQL gère par défaut InnoDB donc je ne vais pas le mettre et ça ne servira à rien. 

Je vous montre que c'est possible d'appliquer une configuration définitive à l'environnement de cette manière par rapport au fichier de configuration que nous avons. 

Sur Linux n'oubliez pas de recharger la configuration en faisant un reload comme je voulais montrer c'est important et aussi de bien quitter le service à chaque fois de MySQL avant de modifier la configuration sinon ça ne sera pas pris en compte. 

Alors voilà je vous ai présenté tout ce qu'il fallait, je vous expliquer un petit peu ce qu'il en était. Je vous ai décrit les différents types de moteur transactionnel et non transactionnel. 

Alors dans quel cas utilisez l'un et dans quel cas utiliser l'autre ? je pense qu'on peut terminer là dessus sinon c'est une question que je dois avoir au commentaire tout le temps, on va me dire tu me conseilles quoi ? MyISAM, InnoDB pour telle ou telle situation. 

Encore une fois la meilleure décision appartient à vous, je vous le dis clairement, je ne suis pas placé pour vous dire utilise plutôt celui-là ou celui-là mais si vous avez besoin de savoir il y a quelque chose de très simple. 

Il y a quelques petits éléments que je peux vous donner qui ne sont pas exhaustifs c'est-à-dire qu'il y en a sûrement d'autres mais ce sont des éléments en tout cas qui permettent de très vite identifié le type de moteur entre les 2. 

On va le noter ici, MyISAM je l'utiliser je vais vous dire pourquoi. L'avantage de MyISAM c'est qu'il est rapide en écriture donc voilà on va dire qu'il est efficace en écriture mais surtout il est très rapide en lecture. C'est vraiment le genre de moteur qui est fait pour de la lecture puisque voilà il est vraiment conçu pour ça comme il n'a pas de sécurité dès que vous allez vouloir sélectionnez des données, il va aller très très vite très très vite.
```txt
	MyISAM (non transactionnel)
	InnoDB (transactionnel)
	
	MyISAM
	> rapide en écriture, très rapide en lecture
```
C'est par exemple vous avez une base de données sur laquelle vous allez lire beaucoup de données plus que faire de l'écriture, de la suppression ou de la modification, il est intéressant d'utiliser MyISAM par contre si vous avez une base de données ou une table sur laquelle vous écrivez énormément, que vous faites des INSERT, des UPDATE comme on le verra plus tard et là je m'adresse à ceux qui ont déjà fait un petit peu du SQL mais tout ça on le verra par la suite. 

Considérer l'écriture c'est-à-dire d'enregistrer des données ou de les modifier ou de les supprimer. 

Et la lecture c'est juste récupérer les données de la base pour les lire.

MyISAM est vraiment conçu lorsqu'on a beaucoup de lecture, plus de lecture que d'écriture. 

Si ce n'est pas le cas il est peut-être préférable de travailler avec InnoDB parce que c'est la lecture qu'on a besoin d'avoir un accès rapidement. 

Si par exemple vous créez un nouvel article, que vous enregistrer un message sur le forum, si ça prend un peu de temps ce n'est pas grave parce que avec InnoDB, on sera sûr que là donnée est bien enregistré. 

Il y a rien de plus embêtant pour un utilisateur, un utilisateur va préférer attendre 2 secondes qu'un message sur un forum soit posté qu'il soit vraiment posté plutôt que ça prenne 0,3 secondes et qu'a la fin il y a une erreur, pas de bol avec son message est tout effacer puis qu'il doit tout recommencer. 

Essayez toujours de peser le contre en vous mettant à la place de l'utilisateur et vous demander qu'est-ce qu'ils préféreraient, dans quel cas. 

Si l'écriture n'est pas très rapide, ce n'est pas gênant. 

Travailler avec InnoDB pour assurer la sécurité des écritures, des modifications ce n'est pas grave parce que l'utilisateur va préférer que la donnée soit bien modifiée plutôt que tout soit perdu et qu'ils doivent tout recommencer. 

Par contre pour la lecture on veut que ce soit toujours rapide, il n'y a rien de plus désagréable que de charger un site de news et de devoir attendre 15 secondes pour avoir le listing de ces news c'est-à-dire une simple requête qui va lire les données de la base. 

Si on a donc beaucoup de lecture à faire, plus que les écritures, on va utiliser MyISAM et ça c'est à vous de voir sur votre projet, sur votre site web. 

Si sur votre site web, vous lisez plus de données que vous en écrivez, utiliser MyISAM pour la table en question. 

Attention c'est la table comme on le verra plus tard, ce n'est pas toute la base de données, c'est seulement certaines tables par exemple la table qui va accueillir les news. 

Si vous avez souvent besoin de récupérer les news sur votre site, Hé bien la table qui stockera vos news utilisera le moteur MyISAM de manière optimale. C'est vraiment conçu pour ça.

Là où MyISAM est utile, c'est pour la recherche. 
```txt
	MyISAM (non transactionnel)
	InnoDB (transactionnel)
	
	MyISAM
	> rapide en écriture, très rapide en lecture
	> efficace pour la recherche
```
Quelqu'un qui voudrait par exemple faire un moteur de recherche un peu comme Google, un peu comme Yahoo, Bing, Qwant, Duck duck go, tout ce que vous voulez. Si on voulait se faire nos propres petits moteurs de recherche, MyISAM sera également plus efficace pour les raisons énumérées tout à l'heure parce que comme ce n'est pas un système transactionnel, Eh bien il va être très rapide dans les lectures parce que la recherche c'est de la lecture. 

On recherche des choses dans les chaînes de caractères, des mots, des termes, voilà c'est de la lecture et MyISAM vraiment très très puissant avec ça. 

Si vous avez besoin sur une table en particulier de faire beaucoup de recherches d'accord en utilisant par exemple Qwant ou d'autres fonctions qu'on aura l'occasion de voir, utiliser ce moteur là. 

Utiliser InnoDB sur une table ou vous avez besoin de faire de la recherche, ce ne serait pas du tout efficace donc c'est le conseil que je peux vous donner. 

Là où ça peut être utile avec MyISAM et c'est ce qui explique aussi le fait qu'il est très rapide en lecture mais quand même moi en écriture, c'est que MyISAM lorsque vous allez écrire par exemple avec une table de news qui va enregistrer nos news et qu'on veut en enregistrer une nouvelle, il va verrouiller toute la table c'est-à-dire que la table des news va être complètement verrouillée il faudra qu'on attende que la requête actuelle soit terminée pour qu'un autre utilisateur puisse par exemple accéder à une donnée, écrire et cetera. 

Bien sûr en terme informatique ce n'est pas des attentes plusieurs secondes ou minutes, ça peut être des milli secondes ou des demi seconde et cetera mais il faut savoir parce que quand on a par exemple des grosses requêtes, et bien quelqu'un qui voudrait par exemple accéder à notre forum pendant qu'il y a un utilisateur qui est en train d'écrire des messages dessus il faudra attendre que la personne ait fini d'enregistrer son message sur le forum avant que l'autre utilisateur puisse accéder au forum. 

Voyez ça peut entraîner des ralentissements sur la navigation d'un site web donc attention MyISAM bloque la table complète quand il va travailler dessus. 

Si on veut faire un enregistrement sur une table, c'est toute la table qui est verrouillée, qui est bloquée en attendant que la requête soit finie avant de redonner la main aux utilisateurs donc ça c'est vraiment des points essentiels pour MyISAM. 

C'est ce qui fait la force de MyISAM. 

Si vous avez besoin de faire plus de lecture, et même beaucoup de lecture, plus que des écritures et de la recherche à faire, il faut utiliser MyISAM c'est vraiment le conseil que je vous donne.
```txt
	MyISAM (non transactionnel)
	InnoDB (transactionnel)
	
	MyISAM
	> beaucoup de lectures
	> efficace pour la recherche
```
InnoDB est utile lorsqu'on a beaucoup d'écriture mais quand je parle d'écriture ce sont des modifications, c'est INSERT, UPDATE comme on le verra plus tard. Il va être utile pour encore une fois conserver encore une fois l'intégrité ce qui veut dire sécuriser les données si on veut s'assurer de bien enregistrer les choses.
```txt
	MyISAM (non transactionnel)
	InnoDB (transactionnel)
	
	MyISAM
	> beaucoup de lectures
	> efficace pour la recherche
	
	InnoDB
	> beaucoup d'écritures
	> sécuriser les données
```
Il assure également la cohérence, alors ici je vais mettre les données mais entendons par là les tables et comme les tables c'est quelque chose qu'on n'a pas encore étudié sur cette formation et on reviendra dessus mais on aura l'occasion d'en reparler. 
```txt
	MyISAM (non transactionnel)
	InnoDB (transactionnel)
	
	MyISAM
	> beaucoup de lectures
	> efficace pour la recherche
	
	InnoDB
	> beaucoup d'écritures
	> sécuriser les données
	> cohérence entre les données (tables)
```
Alors pourquoi va-t-il assurer cette cohérence ? qu'est-ce que je peux vous dire par exemple sans rentrer trop dans le détail, admettons qu'on ait 2 tables, que notre client est une ville mais que les villes ce soit une autre table d'accord un autre ensemble de quelque chose. Si par exemple dans la liste de vos villes vous avez Paris mais que vous n'avez plus aucun client dans la ville est Paris Eh bien la ville de Paris dans l'autre table sera supprimée, c'est ce qu'on appelle en fait une suppression en cascade. 

Cela veut dire simplement qu'on ne va pas laisser des données par exemple si rien ne les utilisent. 

Si il n'y a aucune raison de garder Paris dans la base de données parce que plus personne est à Paris, on va supprimer l'information de la base de données donc on assure comme ça une cohérence des données mais on aura l'occasion d'en reparler, tout ce qui est suppression, insertion en cascade et cetera. 

On n'en a pas du tout parlé, on l'a même pas encore apporté donc c'est des choses dont on parlera plus tard. 

Si vous avez vraiment besoin d'une cohérence entre les données, de sécuriser vos données, d'être sûr que les requêtes se font bien et d'avoir beaucoup d'écriture à faire, on utilisera InnoDB. 

Si vous avez beaucoup de lecture à faire ou de recherche, on utilisera MyISAM. 

Alors ça je vous dis des points essentiels il y en a sûrement d'autres, je pourrais certainement rajouter beaucoup d'autres avantages ou beaucoup d'autres spécificités pour l'un et pour l'autre mais je pense que déjà avec ces quelques points dans pratiquement tous les cas vous arriverez à choisir le moteur qu'il vous faut. 

Quand vous aurez une table vous vous direz je travaille avec telle table, j'étais le temps qui doit manipuler telle donnée, est-ce que j'ai besoin de faire ci où ça dessus ? et en fonction de ce que vous aurez besoin de faire sur cette table, vous aurez tout ce qu'il faut normalement en main pour choisir le bon moteur. 

Dernier conseil pour terminer cette vidéo, quand vous allez avoir des tables qui vont travailler ensemble par exemple par rapport à ce que j'ai dit tout à l'heure … imaginez qu'une table c'est une sorte de boîte.

Imaginez qu'on a une petite base qui stockent tous vos clients et une autre qui va stocker toutes les villes, et les clients vivent évidemment dans une ville qui fait partie de votre autre base, celle des villes. 

Eh bien ces données sont ensemble, vous voyez qu'elles sont liées. 

Eh bien si un jour vous deviez travailler avec ces 2 tables, donc avec des liaisons, Il faut éviter de mélanger les types de moteur c'est-à-dire que si par exemple ma table de client est écrite avec InnoDB, le moteur innodb et que ma table des villes est en MyISAM mais que j'ai souvent besoin de faire des liens entre les 2 ce ne sera pas efficace. 

On évite dans la mesure de possible de mélanger, notamment via des liaisons, des tables non transactionnelles avec des tables transactionnelles.

Voyez donc déjà mine de rien alors qu'on n'a même pas encore commencé à faire de la pratique c'est-à-dire à créer des tables, des bases, à inscrire des données, il y a déjà beaucoup de questions à se poser quand on fait de la base de données. 

C'est vraiment un domaine et je vous le dis qui est très simple à prendre c'est-à-dire tout ce qui est syntaxe, comment écrire les requêtes ?

C'est vraiment un jeu d'enfant, clairement parce qu'on n'est pas dans du langage de programmation, il n'y a pas d'objet, il n'y a pas de tout ça donc SQL c'est un langage qui est très simple à apprendre, très simple à comprendre. 

Par contre la réflexion qu'il faut derrière quand on veut manipuler des données, de la manière dont on veut les manipuler, les bons outils à utiliser, le bon moteur, le bon encodage, là il y a tout un côté qui est ultra complexe. 

C'est pour ça que c'est facile d'apprendre SQL par contre c'est très compliqué de faire du bon SQL d'avoir en tout cas des requêtes optimisées. 

C'est ça qui pose vraiment problème aux gens qui apprennent ce langage là et qui apprennent à manipuler des SGBD donc très important. 

Alors j'avais également oublié de dire pour InnoDB sachez que quand vous utilisez MyISAM et que vous faites une requête sur une table, ça verrouille la table complète mais pour InnoDB ça verrouille simplement la ligne. 

Admettons que vous voulez modifier la ville d'un des clients de la table des clients, Eh bien ça va juste verrouiller ce client là, l'enregistrement qui concerne ce client. 

Ça ne va pas verrouiller le reste de la table donc si quelqu'un d'autre veut lister les autres clients, il pourra les récupérer sans problème. 

Voyez c'est la petite différence. 

InnoDB ne verrouille que l'environnement sur lequel on travaille au niveau de notre requête. 

MyISAM verrouille en revanche toute la table. 

Encore une fois selon les cas, vous allez préférer utiliser l'un ou l'autre mais je ne pourrais pas choisir à votre place. 

C'est à vous selon le projet sur lequel vous bosser, le site web, l'infrastructure de votre base de données tel qu'on le verra dans les vidéos prochaines, c'est vous qui pourrez dire dans mon cas, dans ma situation spécifique (celle-là personnel) il faut utiliser MyISAM parce que c'est mieux ou alors il faut plutôt utiliser InnoDB. 

Il n'y en a pas un qui est mieux que l'autre tout dépend du contexte de la situation. 

Si vous avez compris ça dès le départ, par la suite vous ferez des tables et des bases de données cohérentes, des bases de données qui utilisent le plein potentiel de ce qu'elles peuvent utiliser parce que vous aurez les bons moteurs à chaque fois, les bons types de données et cetera et vous aurez appris de bonnes choses. 

Et à côté vous aurez des gens qui continuent d'utiliser 100% du InnoDB parce qu'on leur a dit que c'était mieux ou 100% de MyISAM parce que c'est plus rapide mais le problème c'est que quand ils auront besoin de faire beaucoup d'écriture …

Alors faire beaucoup d'écriture avec le moteur MyISAM, ce n'est pas du tout du tout performant. 

Retenez bien tout ça, tout ce que je vous ai dit là. 

Ce n'était pas forcément la vidéo la plus intéressante parce que j'ai beaucoup parlé et je n'ai pas montré grand grand chose à l'écran mais vraiment c'est une des plus importantes. 

L'encodage et ça ce sont 2 essentiels en base de données. 

Si vous avez bien pigé tout ça, il ne pourra rien vous arriver pour la suite !

Vous aurez en tout cas pris de très bonnes habitudes dès le départ et ça vous invitera bien des problèmes par la suite parce que quand vous allez manipuler des bases de données de plusieurs gigas octets et que du jour au lendemain on nous demande de passer une table de plusieurs gigas de MyISAM, InnoDB, vous aurez énormément de soucis. 

C'est générateur d'erreurs bref ça peut amener plein de problèmes donc n'hésitez pas à vraiment bien prends ton compte tout ce que je vous ai dit. 

Alors quand on parlera des tables on verra comment appliquer un moteur sur notre table. 

On verra également comment modifier le moteur d'une table parce qu'on peut le faire. 

Plus tard on crée une table qui utilise InnoDB et puis d'un coup on se dit qu'on veux qu'elle utilise maintenant MyISAM, alors sachez que c'est juste un moteur, ce sont juste des algorithmes qui vont gérer le stockage et l'accès des données de manière différente donc on peut évidemment en terme informatique modifier cela. 

C'est une info qu'on peut changer quand on veut, ce n'est pas irréversible, ce n'est pas définitif. 

Et j'ai envie de dire heureusement sinon il y aurait quand même de sacrés problèmes. 

Alors je pense avoir tout dit et j'ai beaucoup beaucoup beaucoup parlé sur cette vidéo mais j'avais plein de choses à dire parce que c'était super important. 

On reviendra sur ces moteurs et on aura l'occasion d'en parler sur la vidéo concernant les tables, la création de table parce qu'on verra ça dans une autre vidéo dédiée. 

On reviendra donc sur ces moteurs mais maintenant qu'on l'a déjà vu, il y aura juste à faire des rappels pour les prochaines vidéos. 

Et il n'y aura pas besoin de vous apprendre tout ça. 

Si vous avez des questions comme d'habitude n'hésitez pas à les poser, je suis là pour ça et en attendant je vous dis à bientôt pour une vidéo SQL. 

Ciao tout le monde