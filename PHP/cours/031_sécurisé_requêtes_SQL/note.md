# [31. Sécuriser requêtes SQL](https://www.youtube.com/watch?v=Vr6wfvlXPkw)

Bonjour tout le monde c'est la séance trente-et-une en PHP. 

On continu directement avec la suite des requêtes que l'on peut faire via l'interface pdo en PHP pour interroger une base de données SQL notamment pour regarder comment sécuriser tout simplement les requêtes que nous allons effectuer.

On va donc reprendre le code que nous avions précédemment d'accord avec la connexion habituelle et cetera.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
On va se connecter au client MySQL, ce qui permettra après de comparer les données récupérées et aussi pour que ce soit plus visible. 

On va donc faire un use fv_database et un simple select de tous les enregistrements de la table fv_clients.
```powershell
	serveur
	-------
	
	>mysqld --console
	2020-12-22T20:03:31.153492Z 0 [System] [MY-010116] [Server] C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\mysql\bin\mysqld.exe (mysqld 8.0.22) starting as process 7340
	2020-12-22T20:03:31.200232Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
	2020-12-22T20:03:33.235455Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
	2020-12-22T20:03:33.768825Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060
	2020-12-22T20:03:34.044868Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
	2020-12-22T20:03:34.045598Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
	2020-12-22T20:03:34.209197Z 0 [System] [MY-010931] [Server] C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\mysql\bin\mysqld.exe: ready for connections. Version: '8.0.22'  socket: ''  port: 3306  MySQL Community Server - GPL.
	
	client
	------
	
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

	> use fv_database;
	Database changed

	> select * from fv_clients;
	+-----------+------------------+-----------------+-----------------+----------------+
	| id_client | client_firstname | client_lastname | client_birthday | client_loyalty |
	+-----------+------------------+-----------------+-----------------+----------------+
	|         1 | Jason            | CHAMPAGNE       | 1991-02-10      |             15 |
	|         2 | Bamogo           | SAKO            | 1965-09-15      |              3 |
	|         3 | Emmanuel         | MACRON          | 1977-12-21      |            100 |
	|         4 | Coco             | LASTICOT        | 1327-02-28      |              0 |
	|         5 | Tic              | KIT             | 2000-05-16      |              5 |
	|         6 | Tac              | KAT             | 2000-05-16      |              5 |
	+-----------+------------------+-----------------+-----------------+----------------+
	6 rows in set (0.00 sec)
```
Alors OK nous allons garder ça de côté pour le moment et nous allons voir un petit peu comment ça fonctionne.

Alors est-ce que c'est connecté ? au niveau pdo ça a l'air d'être bon. J'actualise.
```txt
	\MyWAMP\apache\bin\httpd.exe

	http://localhost/PHP/cours/031_s%c3%a9curis%c3%a9_requ%c3%aates_SQL/
```
Alors voilà au niveau PDO ça m'a l'air d'être bon, j'ai démarré mon serveur et le serveur MySQL. 

À partir de là donc et en tout cas ce qu'on avait vu précédemment c'était une simple requête donc on faisait par exemple ceci en passant une requête à query().
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
		];

		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
>		$request = $PDO->query('SELECT * FROM fv_clients');
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Voilà on faisait ce genre de chose ensuite on entourait les infos avec la balise `<pre>` qu'on affichait avec un petit print_r() directement de `$request->fetchAll()` et ici pour ne pas avoir les numéros de ligne donc les informations redondantes, on va mettre en fetch associatif, FETCH_ASSOC. 
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$request = $PDO->query('SELECT * FROM fv_clients');

	echo '<pre>';
	print_r($request->fetchAll(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/031_s%c3%a9curis%c3%a9_requ%c3%aates_SQL/
	Array
	(
		[0] => Array
			(
				[id_client] => 1
				[client_firstname] => Jason
				[client_lastname] => CHAMPAGNE
				[client_birthday] => 1991-02-10
				[client_loyalty] => 15
			)

		[1] => Array
			(
				[id_client] => 2
				[client_firstname] => Bamogo
				[client_lastname] => SAKO
				[client_birthday] => 1965-09-15
				[client_loyalty] => 3
			)

		[2] => Array
			(
				[id_client] => 3
				[client_firstname] => Emmanuel
				[client_lastname] => MACRON
				[client_birthday] => 1977-12-21
				[client_loyalty] => 100
			)

		[3] => Array
			(
				[id_client] => 4
				[client_firstname] => Coco
				[client_lastname] => LASTICOT
				[client_birthday] => 1327-02-28
				[client_loyalty] => 0
			)

		[4] => Array
			(
				[id_client] => 5
				[client_firstname] => Tic
				[client_lastname] => KIT
				[client_birthday] => 2000-05-16
				[client_loyalty] => 5
			)

		[5] => Array
			(
				[id_client] => 6
				[client_firstname] => Tac
				[client_lastname] => KAT
				[client_birthday] => 2000-05-16
				[client_loyalty] => 5
			)

	)
```
On actualise et du coup on récupère tous les enregistrements sous forme de tableau associatif de notre table fv_clients, tous les enregistrements qu'elle contient. 

Alors ça c'est ce que je vous avais montré. 

Alors le problème général que ce soit sur PHP ou un autre langage ou même en informatique de manière générale, c'est le côté sécurité c'est à dire qu'on va souvent manipuler des données dites utilisateur donc des données qui peuvent provenir d'un fichier, qui peuvent provenir d'un formulaire le cadre d'un site web ou de données saisies ou en tout cas donné par un utilisateur et le problème de ces données c'est qu'il n'y a rien qui garantit au départ que ces données sont conforme et correct. 

Ça peut être accidentel par exemple on demande à la personne d'entrer une date de naissance et puis elle ne la rentre pas sous le même format, ou alors un numéro de téléphone elle va mettre des espaces, elle ne met pas d'espace, elle met des points et cetera entre les noms. 

Bref on ne peut jamais s'assurer que la personne rentrera bien l'information comme il faut donc on aura du coup une saisie accidentelle et des informations qui sont incorrectes ou alors c'est volontaire, tentative de piratage ou autre par rapport à l'attaque sur un site ou tout simplement concernant une application. 

Dans tous les cas on ne peut pas faire confiance à l'utilisateur et aux données qui ont été transmises entre les données qu'on attend et celles qu'on va vraiment recevoir à la fin, à l'arrivée. 

Pour ça on va devoir sécuriser nos informations. 

Alors je vais bien insister sur cette vidéo par rapport à ça parce que là on n'est pas dans un cadre amateur où on peut se dire qu'on va faire le strict minimum, on s'en fou d'accord. 

L'aspect sécurité de manière générale est très important c'est-à-dire que je vois très souvent des gens qui se disent je développe une application, je fais un site web et après je verrais pour sécuriser. 

Alors que vraiment la démarche à suivre c'est je développe, j'implémente en sécurisant d'accord ça ne doit pas être une partie séparée ou à faire plus tard, c'est une partie intégrante en fait du développement et tout au long de la conception de ce que vous êtes en train de faire. 

Voilà c'est très important. 

C'est d'autant plus important ici dans le cadre de tout ce qui est web où vous êtes propriétaire d'un site web mais vous détenez et vous gérez des données utilisateur. 

Vous avez peut-être des données clients, des données d'utilisateurs quelconques, des adresses mails, des données bancaires, des données confidentielles, adresses et cetera. 

S'il y a diffusion de ces données ou tentative de piratage et que derrière vous n'avez pas de quoi prouver que vous aviez utilisé les méthodes maximales pour sécuriser au mieux vos infrastructures, vos systèmes, vos codes, vos programmes et cetera, vous risquez d'être autant responsable si ce n'est peut-être même plus que par exemple une personne qui aurait tenté ou qui aurait piraté votre système parce que c'est en fait de votre faute, c'est de votre responsabilité si des données ont été volées, ont été divulguées, diffusées et cetera. 

C'est pour ça que je insiste bien parce que c'est très important et le but de cette formation ce n'est pas de vous apprendre les choses de la mauvaise manière en disant qu'on fait le strict minimum en requêtes et après plus tard vous vous débrouillerez pour apprendre à faire de la sécurité ou autre, c'est partie intégrante. 

D'accord même si sur la première vidéo on avait vu le départ c'est juste que je ne voulais pas faire une grosse grosse vidéo avec tout d'un coup donc je séparé en 2 mais c'est vraiment très important de faire partie intégrante de tout l'aspect sécurité dans le développement que vous faites qui plus est encore une fois en web et là on est très très souvent amené à manipuler des données utilisateur. 

J'ai bien insisté là dessus parce que ça a vraiment son importance. 

Du coup, se contentait de ce qu'on a fait là ce n'est juste pas possible et je vais vous expliquer pourquoi. 

Très simplement son non plus rentrer dans les détails liés justement aux attaques éventuelles ou aux vulnérabilités parce qu'on n'est pas sur un cours de hacking mais sur un cours de php mais en gros au niveau de notre quête, je vais l'extraire et passer par une petite variable intermédiaire. 

Je vous annonce que la vidéo sera un peu longue parce qu'il y a beaucoup de choses à vous expliquer mais ça a son importance de toute façon. 
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
		];

		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
>		$sql = 'SELECT * FROM fv_clients';
>		$request = $PDO->query($sql);

		echo '<pre>';
		print_r($request->fetchAll(PDO::FETCH_ASSOC));
		echo '</pre>';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Voilà pour `$sql`. 

On a un cas accidentel c'est-à-dire qu'on peut s'attendre à se dire que cette requête c'est moi le développeur après tout. 

Je l'ai noté dans mon code donc pas de problème je n'ai pas besoin de faire une requête sécurisé après tout voilà noter en dur ça ne vient pas de quelqu'un d'autre, je ne vais pas me pirater moi même je ne vais pas moi-même corrompe la sécurité de mon site. 

Pourtant le problème déjà même si on tente de vous pirater il n'y aura pas de souci de ce côté là mais accidentellement par exemple des caractères de formatage, par exemple ce genre de chose `""` dans la requête select.
```php
>		$sql = 'SELECT * ""FROM fv_clients';
		$request = $PDO->query($sql);
```
Je vais vous montrer rapidement ce que donne le caractère de formatage avec un simple affichage.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * ""FROM fv_clients';
	
	echo $sql;
	exit;
	
	$request = $PDO->query($sql);

	echo '<pre>';
	print_r($request->fetchAll(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/
	SELECT * ""FROM fv_clients
```
Voilà du coup l'état de ma requête donc on a bien les caractères de la roquette telle qu'on s'attend habituellement `SELECT * `… par contre ces informations accidentelles qui ont été mises dans la requête sont parfaitement prise en compte donc parfaitement affiché. 

Et comme vous le savez en informatique pour tout ce qui est bornes d'une chaîne de caractères d'accord le caractère de début ou fin de chaîne, on va retrouver ces fameuses quotes `" "` c'est à dire ces fameux guillemets soit les simples quotes ou les doubles quotes. 

Et ça c'est problématique parce qu'en sql, le problème de ça c'est que dans le cas où c'est vous volontairement ou alors une erreur accidentelle où vous avez placé ce genre de caractères ça va pas faire simplement marcher la roquette, il n'y a qu'a faire juste ça et là automatiquement on va avoir une erreur de syntaxe.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * ""FROM fv_clients';
	
	$request = $PDO->query($sql);

	echo '<pre>';
	print_r($request->fetchAll(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}
```
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/
	ERREUR : SQLSTATE[42000]: Syntax error or access violation: 1064 You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '""FROM fv_clients' at line 1
```
Voilà on voit automatiquement qu'il y a une erreur de syntaxe. 

Ce n'est pas grave en soi parce que c'est volontaire enfin c'est fait par le développeur lui-même mais là où ça peut être beaucoup plus grave c'est dans le cadre justement d'une tentative de piratage où une personne va pouvoir utiliser ce genre de caractère pour casser une chaîne et injecter une autre partie de chaîne. 

Par exemple ce serait s'amuser à faire, par exemple à dire tu me retourne l'intégralité des utilisateurs par exemple des mails, des données bancaires, des mots de passe qu'ils soient chiffrés ou non d'ailleurs mais voilà des données qu'y n'ont normalement pas à sortir de la base de données. 

Et en vérifiant, en tout cas tu me retourne ces données si et seulement si par exemple si 1 est égal à 1 parce que après tout comme la personne peut via ces caractères `""` écrire ce qu'elle veut et donc on peut imaginer un formulaire dans lequel on peut saisir une donnée donc rien n'empêcherait dans un formulaire de saisir une info et puis voilà dans le cas où 1 est égal à 1. 

Et comme cette condition est toujours vrai, Eh bien la personne en sachant que votre formulaire va interroger une base de données pourra récupérer des informations qui de toute façon n'auraient pas dû être récupéré parce que ce n'était absolument pas prévu comme ça. 

Juste parce qu'il y a cette non sécurité sur les requêtes concernant notamment son formatage voilà au niveau des caractères d'échappement ici, `""`. 
```php
	$sql = 'SELECT * ""FROM fv_clients';//1=1
```
Donc ça `//1=1`, c'est un gros gros problème et c'est ce qu'on appelle une attaque par injection sql d'accord on injecte en fait une information dans une requête sql pour changer cette requête justement et le comportement en fait par rapport à ce que l'on veut récupérer comme données. 

On va en fait carrément changer la requête produite et du coup récupérer autre chose que ce qui était prévu, et très souvent des données confidentielles des données privées et ce genre de choses. 

Donc le strict minimum et on va se contenter de beaucoup plus que ça mais je montre parce que ça existe c'est-à-dire que au début pour pallier à ce genre de chose, on avait une méthode par exemple donc pdo et même dans d'autres interfaces à l'époque quand on était dans tes vieilles versions du langage PHP pour échapper un peu ces caractères particuliers. 

C'est en gros de dire on prend tout ce que tu as dans la chaîne qu'on va entourer à nouveau de guillemets pour être sûr qu'elle a bien été prise en compte comme chaîne et on va échapper d'accord on va utiliser des caractères d'échappement pour tous les caractères comme ça qui normalement délimites des chaînes de caractères pour éviter qu'il soit interprété. 

Alors une petite utilisation très simple, on va utiliser `$PDO` donc l'instance de `$PDO->` et ensuite la méthode quote() sur ici ma chaîne `$sql`.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * ""FROM fv_clients';
	echo $PDO->quote($sql);
	exit;
	
	$request = $PDO->query($sql);

	echo '<pre>';
	print_r($request->fetchAll(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/
	'SELECT * \"\"FROM fv_clients'
```
Je fais un exit et voilà ce que ça donne donc tout à l'heure on avait une erreur de syntaxe et là nous avons ça. 

La première différence c'est que toute ma chaîne a été entourée de simples quotes `' … '` donc ça a mis des simples quotes autour de la chaîne qui a bien été entourée et on a échappé tous les caractères justement qui délimitent une chaîne de caractères à la base en informatique `\"\"`. 

Du coup on aura effectivement bien `SELECT * FROM fv_clients` qui sera gardé. 

Du coup la requête sera valide, elle ne permettra plus d'injection sql donc ça c'est une solution. 

Il s'agit de la solution minimale pour éviter justement des attaques par injection sql mais voilà si on est un petit peu malin on peut se débrouiller pour contourner certaines choses et donc ce n'est pas suffisant, je vais vous montrer aussi pourquoi cette méthode n'est pas à privilégier en production ou autre. 

Alors déjà cette méthode quote() ne va pas fonctionner sur tous les pilotes de base de données par exemple c'est ODBC qui est un bon exemple par rapport à ça où cette méthode ne va pas fonctionner. 

Alors je rappelle que le moteur c'est simplement le système de gestion que vous utilisez tel que MySQL, Oracle, Microsoft SQL Server et cetera en fonction. 

Selon les drivers comme certains ont en fait des comportements un peu différents, Eh bien certaines méthodes ne fonctionneront pas parce que ce n'est pas propre à sql mais c'est propre au driver en question donc déjà ce n'est pas génial. 

En plus de ça quand on utilise ce genre de méthode qui échappent et qui gèrent en fait la délimitation de notre chaîne de caractère et comme on travaille sur des chaînes de caractères, il faut s'assurer du bon encodage. 

Alors nous comme je vous ai habitué et c'est très important en informatique de toujours travailler en utf 8 et qu'on a dès le départ penser à mettre cette option au moins on travaille avec le bonheur codage mais si par exemple le développeur oublié de spécifier un bon encodage pareil cette méthode quote() sera complètement inefficaces et niveau sécurité c'est 0.
```php
	$options =
	[
>		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
	];
```
Ça existe et sachez qu'il y a cette méthode quote() qui peut servir à échapper éventuellement des caractères mais ce n'est pas l'idéal. 

Je vous montre parce qu'il faut quand même la connaître, il faut savoir que ça existe mais dans l'idéal et surtout concernant PHP parce que PHP à surtout été conçu pour ça avec son interface PDO, on va pouvoir utiliser un autre type de requête qui va s'assurer de la sécurité des requêtes passées, ça c'est important mais en plus des performances. 

On va pouvoir du coup améliorer la qualité d'exécution en fait de nos requêtes sql qui sont quand même déjà des traitements assez lourds. 

Pour cela nous allons travailler avec des requêtes préparées et je vais vous montrer un petit peu comment ça se passe au niveau syntaxe, c'est très simple à utiliser d'accord il y a quelques petites choses qui s'ajoutent au niveau méthode et cetera mais c'est très simple à l'usage. 

Voilà on va virer toutes ces parties et là.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
		];

		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$sql = 'SELECT * FROM fv_clients';

		echo '<pre>';
		print_r($request->fetchAll(PDO::FETCH_ASSOC));
		echo '</pre>';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Voilà on va rester là dessus. 

Alors la première chose à faire pour l'usage des requêtes préparées c'est l'ajout d'une autre option pour la création de l'instance de PDO très important. 

Option dont il y a certainement pas mal parmi vous qui ne connaissent pas si vous avez déjà utilisé pdo dans le passé. 

Cette option va permettre déjà d'utiliser de vrais requêtes préparées, il faut savoir que par défaut l'interface PDO simule en fait des requêtes préparées. 

Ce ne sont pas des requêtes préparées authentiques mais elles sont simulées. 

Nous on va prendre en considération l'usage de vraies requêtes préparées en passant ce paramètre donc cette constance ATTR_EMULATE_PREPARES et on va passer ce paramètre à false pour dire non tu n'émule pas les requêtes préparées d'accord c'est important.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
>			PDO::ATTR_EMULATE_PREPARES => false
		];

		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);

		echo '<pre>';
		print_r($request->fetchAll(PDO::FETCH_ASSOC));
		echo '</pre>';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
En plus de ça cette option va vraiment gérer tous les cas c'est à dire que là où le driver moi ici en l'occurrence mysql:

+ db-config.php
```php
>	$DB_DSN = 'mysql:host=localhost;dbname=fv_database';
	$DB_USER = 'root';
	$DB_PASS = '';
```
Là ou le driver en l'occurrence mysql fonctionne avec mais que vous avez un driver compatible c'est-à-dire qu'il gère de manière native, qui prend en charge les vraies requêtes préparées parce que ce n'est pas le cas de tous les drivers d'accord de tous les pilotes. 

Ce sont de vraies requêtes préparées. 

Maintenant si par exemple comme ODBC si je ne dis pas de bêtises, qui lui ne gère pas ne prend pas en charge les vrais requêtes préparées et ça ne fonctionne pas et même si vous avez mis cette option `PDO::ATTR_EMULATE_PREPARES`, PDO se débrouillera toujours pourquoi même utiliser les requêtes préparées soit il peut utiliser les vrais à partir du moment où vous avez mis cette option à false si ça ne marche pas il essaiera de les simuler. 

Voilà dans tous les cas vous n'aurez pas d'erreur et ça fonctionnera dans les 2 cas. 

Je vous recommande de mettre cette option ce sont de vraies requêtes pour les drivers pris en charge et ce seront des requêtes simulées, ce qui est de toute façon le cas par défaut pour les drivers pour lequel ce n'est pas natif ou en tout cas pris en charge ou en tout cas pris par défaut. 

Au moins comme ça on s'assure d'utiliser au maximum les performances et d'utiliser de vrais requêtes quand c'est compatible. 

Voilà pour la partie configuration qui était aussi important à voir pour préparer justement ces fameuses requêtes, pour voir en tout cas ce nouveau système de requête. 

Maintenant comment se servir de ces requêtes préparées donc en gros je vais faire une `$request` ici et je vais utiliser la méthode prepare() sur mon interface `$PDO` et je lui passe du coup la requête sans passer par une variable intermédiaire. On pourrait le faire éventuellement mais pas forcément besoin de s'embêter avec ça.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
			PDO::ATTR_EMULATE_PREPARES => false
		];

		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
>		$request = $PDO->prepare('SELECT * FROM fv_clients');

		echo '<pre>';
		print_r($request->fetchAll(PDO::FETCH_ASSOC));
		echo '</pre>';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Donc je lui dis à ma connexion donc à mon instance de `$PDO`, je lui dis de préparer une requête celle que je passe en paramètre. 

Cette requête est prête, elle est stockée dans une variable  donc elle pourra servir pour plus tard. 

Dès que je vais vouloir exécuter donc au plus simple comme là je n'ai rien à faire entre les 2, je vais l'exécuter tout de suite et bien j'ai juste à passer par la variable sur laquelle j'ai stocké cette requête préparé et je l'exécute avec la méthode execute(). 
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_EMULATE_PREPARES => false
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$request = $PDO->prepare('SELECT * FROM fv_clients');
	$request->execute();

	echo '<pre>';
	print_r($request->fetchAll(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
Voilà c'est très simple en terme de nommage et du coup on arrive à se retrouver, et là du coup si j'actualise ça fonctionnera comme tout à l'heure.
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/
	Array
	(
		[0] => Array
			(
				[id_client] => 1
				[client_firstname] => Jason
				[client_lastname] => CHAMPAGNE
				[client_birthday] => 1991-02-10
				[client_loyalty] => 15
			)

		[1] => Array
			(
				[id_client] => 2
				[client_firstname] => Bamogo
				[client_lastname] => SAKO
				[client_birthday] => 1965-09-15
				[client_loyalty] => 3
			)

		[2] => Array
			(
				[id_client] => 3
				[client_firstname] => Emmanuel
				[client_lastname] => MACRON
				[client_birthday] => 1977-12-21
				[client_loyalty] => 100
			)

		[3] => Array
			(
				[id_client] => 4
				[client_firstname] => Coco
				[client_lastname] => LASTICOT
				[client_birthday] => 1327-02-28
				[client_loyalty] => 0
			)

		[4] => Array
			(
				[id_client] => 5
				[client_firstname] => Tic
				[client_lastname] => KIT
				[client_birthday] => 2000-05-16
				[client_loyalty] => 5
			)

		[5] => Array
			(
				[id_client] => 6
				[client_firstname] => Tac
				[client_lastname] => KAT
				[client_birthday] => 2000-05-16
				[client_loyalty] => 5
			)

	)
```
Si j'actualise ça fonctionne bien comme tout à l'heure, on récupère bien toutes les informations de la base de données comme avec le query() de tout à l'heure la différence qu'on utilise une requête préparée, une vraie en plus avec mysql donc c'est beaucoup plus performant, beaucoup plus optimisé en exécution et c'est sécurisé donc pas de risque d'attaques par injection sql avec des requêtes préparées. 

Au moins là il n'y a plus besoin de se soucier de quoi que ce soit par rapport au formatage de la requête et ça pourrait être écrit de n'importe quelle manière. 

Soit là syntaxe de la requête est bonne et dans ce cas là ça passe, soit là syntaxe n'est pas bonne et il y aura une erreur de toute façon donc ça bloquera complètement l'exécution de la requête.

Voilà donc l'usage d'une requête préparée ou en tout cas au minimum. 

Au minimum on prépare la requête et si on n'a rien à faire de particulier derrière, on l'exécute tout de suite. 

Alors ça c'est une requête sql `SELECT * FROM fv_clients` qui est très simple. 

Maintenant quand on a une requête sql parce que c'est là que c'est intéressant pour laquelle on va vouloir passer des paramètres utilisateur ou autre du genre tu vas me retourner la personne qui a pour prénom Coco d'accord cette information là.
```sql
	> select * from fv_clients;
	+-----------+------------------+-----------------+-----------------+----------------+
	| id_client | client_firstname | client_lastname | client_birthday | client_loyalty |
	+-----------+------------------+-----------------+-----------------+----------------+
	|         1 | Jason            | CHAMPAGNE       | 1991-02-10      |             15 |
	|         2 | Bamogo           | SAKO            | 1965-09-15      |              3 |
	|         3 | Emmanuel         | MACRON          | 1977-12-21      |            100 |
>	|         4 | Coco             | LASTICOT        | 1327-02-28      |              0 |
	|         5 | Tic              | KIT             | 2000-05-16      |              5 |
	|         6 | Tac              | KAT             | 2000-05-16      |              5 |
	+-----------+------------------+-----------------+-----------------+----------------+
	6 rows in set (0.00 sec)
```
Sans sécurité si on était sur une simple requête, on ferait par exemple … `WHERE client_firstname = "Coco"` donc ça pas besoin de le faire évidemment parce que nous on veut justement sécuriser ces requêtes et donc on se sert de requêtes préparées.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
			PDO::ATTR_EMULATE_PREPARES => false
		];

		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
>		$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = "Coco"');
		$request->execute();

		echo '<pre>';
		print_r($request->fetchAll(PDO::FETCH_ASSOC));
		echo '</pre>';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Mais ici on va lui dire qu'on attend une information donc on va mettre un ? Et ça c'est la méthode la plus classique la plus simple.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
			PDO::ATTR_EMULATE_PREPARES => false
		];

		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
>		$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');
		$request->execute();

		echo '<pre>';
		print_r($request->fetchAll(PDO::FETCH_ASSOC));
		echo '</pre>';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
On lui dit qu'on a une information ici qu'on va vouloir injecter par la suite donc c'est à nous de le faire par la suite. 

Et du coup avant même l'exécution, on va pouvoir utiliser une autre méthode donc c'est pour ça qu'il n'y a pas mal de méthode à prendre en compte et donc n'hésitez pas à prendre note au cours de la vidéo pour pouvoir injecter cette valeur. 

Là vous voyez qu'il y a vraiment une différence avec le query(), query() c'est l'exécution de la requête directement et donc là il n'y a pas d'étapes intermédiaires tandis que prepare() prépare la requête et elle est en attente stockée dans une variable `$request` et après n'importe quand je peux l'exécuter execute(). 

Je vous montrerai un petit peu cet intérêt parce que ça c'est un autre avantage des requêtes préparées parce qu'en plus des requêtes préparées c'est qu'en plus de la sécurité et des performances, on peut du coup en fait réaliser plusieurs fois l'exécution d'une requête en changeant entre-temps ces paramètres chose qui ne serait pas possible avec un query() à moins de changer la requête en elle-même au complet donc là variable qui la contient ou autre donc ça il faudrait tout modifier et je vais vous montrer ici comment on va faire au niveau des données. 

En gros avec la roquette préparée, on pourra exécuter cette même requête SELECT .. en changeant à chaque fois le prénom qu'on passe ici … ? en changeant le paramètre injecté. 

Pour ce faire nous avons 2 méthodes et on va commencer par voir la première et là on va vouloir passer une valeur directement et moi je veux passer l'information Coco, ce prénom là parce que je veux récupérer en fait que le 4e client de ma table fv_clients. 

Pour faire ça je vais dire à `$request` parce que c'est lui sur lequel on travaille, c'est lui qui a la requête préparée qui est en attente et donc on lui dit bindValue() c'est-à-dire tu vas injecter une valeur donc ça c'est la méthode.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
			PDO::ATTR_EMULATE_PREPARES => false
		];

		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');

>		$request->bindValue();

		$request->execute();

		echo '<pre>';
		print_r($request->fetchAll(PDO::FETCH_ASSOC));
		echo '</pre>';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Le premier paramètre qui est à prendre en compte comme on a un seul ?, on a qu'un seul paramètre donc c'est le premier et on doit lui donner le numéro de l identificateur. C'est le premier et exceptionnellement même si vous savez que la plupart du temps de l'informatique la première valeur de quelque chose, le premier indice commence à 0, et donc ici c'est une exception parce que ça commence bien à 1. 

Donc premier paramètre je lui passe l'identificateur 1
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
			PDO::ATTR_EMULATE_PREPARES => false
		];

		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
			
		$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');

>		$request->bindValue(1);

		$request->execute();

		echo '<pre>';
		print_r($request->fetchAll(PDO::FETCH_ASSOC));
		echo '</pre>';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
C'était le premier paramètre de ma méthode et le 2e, c'est l'information donc ici une valeur à passer donc je vais faire ceci "Coco".
```php
	$request->bindValue(1, "Coco");
```
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_EMULATE_PREPARES => false
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');

	$request->bindValue(1, "Coco");

	$request->execute();

	echo '<pre>';
	print_r($request->fetchAll(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
On va donc résumer parce que je vais essayer de ne pas aller trop vite. 

On commence donc par se connecter à la base de données.
```php
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
```
Je me suis connecté à ma base de données donc pas de souci, je prépare une requête qui a un identificateur qui n'a pas de nom donc c'est juste un ?.
```php
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');
```
Et du coup avant même de faire une exécution, je vais devoir injecter une valeur à cet identificateur inconnu c'est-à-dire ce ? Et comme il n'y en a qu'un seul et qu'il s'agit du premier donc je mets 1 et je passe ici en valeur ce que je veux "Coco" avec la méthode bindVAlue().
```php
	$request->bindValue(1, "Coco");
```
Et du coup cette méthode préparée, à la fin on aura ceci.
```sql
	SELECT * FROM fv_clients WHERE client_firstname = "Coco"
```
D'accord on aura vraiment toute la chaîne au complet. 

Et la requête préparée je rappelle protège bien tout des attaques par injection sql donc on aura plus qu'à exécuter et là si je fais ça.
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/

	Array
	(
		[0] => Array
			(
				[id_client] => 4
				[client_firstname] => Coco
				[client_lastname] => LASTICOT
				[client_birthday] => 1327-02-28
				[client_loyalty] => 0
			)

	)
```
Et si je fais ça on a un seul enregistrement qui est retourné et c'est donc celui qu'on attendait. 

D'ailleurs le fetchAll() n'est plus utile parce qu'on n'a qu'un seul enregistrement.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_EMULATE_PREPARES => false
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');

	$request->bindValue(1, "Coco");

	$request->execute();

	echo '<pre>';
	print_r($request->fetch(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
Voilà donc on récupère tout. 
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/
	Array
	(
		[id_client] => 4
		[client_firstname] => Coco
		[client_lastname] => LASTICOT
		[client_birthday] => 1327-02-28
		[client_loyalty] => 0
	)
```
Parce que je rappelle que fetchAll() et vous avez vu normalement à l'affichage, voyez le comportement un petit peu différent.
```txt
	fetchAll()
	----------
	Array
	(
		[0] => Array
			(
				[id_client] => 4
				[client_firstname] => Coco
				[client_lastname] => LASTICOT
				[client_birthday] => 1327-02-28
				[client_loyalty] => 0
			)

	)

	fetch()
	-------
	Array
	(
		[id_client] => 4
		[client_firstname] => Coco
		[client_lastname] => LASTICOT
		[client_birthday] => 1327-02-28
		[client_loyalty] => 0
	)
```
Vous voyez qu'avec fetchAll() retourne un tableau associatif avec l'indice à 0 qui pointe sur nos données. 

Il sait comment on est sûr qu'il n'y a qu'un seul enregistrement qui doit être retourné, on fait un petit fetch() ce qui va permettre de enlever des étapes en plus par rapport au filtrage. 

Voilà au niveau des informations. 

On prépare une requête, on injecte éventuellement les données qui sont attendues s'il y a évidemment des données injectées (?) et dès qu'on en a besoin on exécute la requête, execute().

Très pratique et très facile à utiliser. 

L'avantage du coup c'est qu à un moment donné je peux m'amuser à faire ça juste après avoir exécuté la requête donc je fais bindValue() à nouveau avec comme paramètre toujours 1 parce qu'il n'y a qu'un seul identificateur ici et on le dit maintenant tu lui passe "Bamogo" par exemple et après tu ré exécute la requête sans oublier de réafficher les résultats.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_EMULATE_PREPARES => false
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');
	$request->bindValue(1, "Coco");
	$request->execute();
	
	echo '<pre>';
	print_r($request->fetch(PDO::FETCH_ASSOC));
	echo '</pre>';
	
	$request->bindValue(1, "Bamogo");
	$request->execute();

	echo '<pre>';
	print_r($request->fetch(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}
```
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/
	Array
	(
		[id_client] => 4
		[client_firstname] => Coco
		[client_lastname] => LASTICOT
		[client_birthday] => 1327-02-28
		[client_loyalty] => 0
	)
	Array
	(
		[id_client] => 2
		[client_firstname] => Bamogo
		[client_lastname] => SAKO
		[client_birthday] => 1965-09-15
		[client_loyalty] => 3
	)
```
Et voilà donc la première requête a retourné le client qui s'appelait Coco et la 2e requête a bien retourné le client qui s'appelait Bamogo donc on a les 2 requêtes qui ont été effectués à la suite et vous voyez que on avait juste besoin de la préparer qu'une seule fois c'est-à-dire une seule préparation de la requête ici. 
```php
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');
```
Une seule préparation de la raquette et ensuite on injecte la donnée en question, on exécute et ça va exécuter suivant ce qui a été injecté. 

À partir du moment où on réinjecte "Bamogo", cette injection de données va évidemment remplacer "Coco" et du coup la nouvelle exécution change ce qu'elle retourne mais sans avoir modifié encore une fois la requête ici.
```php
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');
```
Donc c'est très pratique du coup par rapport à ça.

Voilà comment on utilise cette méthode bindValue() pour faire de l'injection de valeur dans une requête préparée.

Une autre possibilité parce que ça c'était Value() donc il faut comprendre un petit peu la différence, Value() va traiter en fait directement au moment où vous faites l'injection, il va faire le remplacement c'est-à-dire que au moment où vous appelez la méthode bindValue(), il va remplacer ? par "Coco" d'accord c'est quelque chose qui va le faire directement. 

Nous on aimerait par exemple dire que ce remplacement en fait cette évaluation de l'expression parce que c'est l'évaluation de la requête, tu vas le faire que au moment de l'exécution et pour ça nous avons une autre méthode qui elle ne va pas injecter une valeur (bindValue()) mais va injecter un paramètre. 

Donc on a juste à remplacer bindValue() par bindParam() et du coup bindParam() je peux m'amuser à faire `$name` comme ça.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
			PDO::ATTR_EMULATE_PREPARES => false
		];

		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
			
		$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');
>		$request->bindValue(1, $name);
		
		$request->execute();
		
		echo '<pre>';
		print_r($request->fetch(PDO::FETCH_ASSOC));
		echo '</pre>';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Puis à un moment donné, je ne sais pas où dans mon code et avant l'exécution parce que c'est ça qui est important donc on va prendre un nom `$name="Tic"` c'est très recherché comme nom et du coup nous allons pouvoir faire ça.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_EMULATE_PREPARES => false
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');
	$name = "Tic";
	
	$request->bindParam(1, $name);
	$request->execute();
	
	echo '<pre>';
	print_r($request->fetch(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}
```
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/
	
	Array
	(
		[id_client] => 5
		[client_firstname] => Tic
		[client_lastname] => KIT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
```
Voilà j'ai exécuté et j'ai bien récupéré Tic et vous voyez que j'ai mis la variable `$name` mais je peux sans problème mettre `$name` après le bind.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_EMULATE_PREPARES => false
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');
	$request->bindParam(1, $name);
	
	$name = "Tic";
	$request->execute();
	
	echo '<pre>';
	print_r($request->fetch(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/

	Array
	(
		[id_client] => 5
		[client_firstname] => Tic
		[client_lastname] => KIT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
```
Dans la vidéo ça ne fait aucune différence et ça fonctionne aussi tout simplement parce que cette méthode bindParam() va évaluer ma requête au moment de l'exécution.

Tant que ma variable `$name` et bien présente l'appel à execute() ce qui est bien le cas ici avec `$name`, ça ne pose pas de problème il va réussir à trouver cette variable. 

C'est pour ça que l'on différencie un peu ces choses-là, la différence entre les 2 si vous ne savez pas laquelle utiliser en fonction dites-vous que bindValue() va tout de suite évaluer votre requête au moment même où vous l'appeler. 

Alors que bindParam() va évaluer votre requête au moment de son exécution et pas avant. 

Du coup je peux m'amuser à voir ce paramètre là `$name` et puis qu'entre 2 je changes d'avis et que je décide d'avoir "Tic" à la place de "Tac".
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_EMULATE_PREPARES => false
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');
	$request->bindParam(1, $name);
	
	$name = "Tic";
	$name = "Tac";
	$request->execute();
	
	echo '<pre>';
	print_r($request->fetch(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/

	Array
	(
		[id_client] => 6
		[client_firstname] => Tac
		[client_lastname] => KAT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
```
Si je changer d'avis et à la place de Tic, on prend Tac, vous allez voir que ça a bien remplacer la valeur. 

Il aura pris la dernière valeur qu'il y a eu donc ici Tac donc la plus proche avant l'exécution, c'est celle-là qui aura été injectée du coup ce qui est parfaitement logique si on suit un petit peu l'ordre des variables dans le code. 

Voilà un petit peu du coup comment on peut utiliser cette injection là de paramètre. 

Alors là j'ai mis une variable `$name` mais encore une fois bindValue(), bindParam() que ce soit l'une ou l'autre on peut l'utiliser directement avec des données en brut directement en paramètre ou des variables, ça n'a absolument rien à voir. 

De toute façon les gens qui pensent que c'est forcément ça.
```php
	$request->bindValue(1, "Tac");
	$request->bindParam(1, $name);
```
Puis des gens je pense que quand on a bindParam() c'est forcément par une variable alors que pas du tout. 

La seule distinction qui est vraiment importante c'est que Value évalue directement et Param évalue à l'exécution. 

D'accord c'est ça qu'il faut en fait bien prendre en compte. 

En gros quand vous utilisez bindParam(), il va faire une référence de la donnée réservé et quand il exécute il va chercher cette référence d'accord c'est-à-dire la donnée que vous avez voulu injecter, il l'injecte et il exécute la requête en question une fois qu'elle est complétée. 

Voilà un petit peu. 

Dans tous les cas que vous utilisiez bindValue(), bindParam() comme vous êtes sous la forme d'une requête préparée, vous avez encore une fois la sécurité de la requête donc pas besoin de le faire vous-même. 

Vous avez les performances en terme d'exécution c'est bien plus efficace de passer par des requêtes préparées qu'autre chose donc il faut s'en servir dans la majorité des cas même si vous n'avez pas forcément de paramètre un peu spécial pour éviter encore une fois tous les risques d'injection qu'il soit accidentel, volontaire ou qui soit fait par quelqu'un dans une tentative de piratage.

Dans 99% des cas, utiliser des requêtes préparées, elles sont vraiment efficaces, optimisées pour ça via l'utilisation de PHP et vous pouvez vous en servir, PDO est vraiment conçu pour tout ça optimal. 

Vous pouvez vous en servir pour des questions de performance, il n'y a pas de souci. 

Voilà pour ça. 

Est-ce qu'on peut compléter un petit peu tout ce que je vous ai dit parce qu'on a vu pas mal de choses mais je n'ai pas encore parlé des paramètres nommés. 

C'est une autre possibilité, les paramètres nommés. 

D'abord vous pouvez utiliser ces options là avec ? et puis en mettant un 1 en paramètre de bindValue() ou bindParam() et qui fonctionne pareil donc on va revenir sur quelque chose de simple parce que sinon si on a trop de codes on va se perdre.

On va déjà re vérifier que je n'ai pas d'erreur.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_EMULATE_PREPARES => false
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ?');
	$request->bindValue(1, "Tac");
	$request->execute();
	
	echo '<pre>';
	print_r($request->fetch(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}
```
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/
	Array
	(
		[id_client] => 6
		[client_firstname] => Tac
		[client_lastname] => KAT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
```
Voilà OK ça fonctionne donc pas de souci. 

Si ça vous embête d'utiliser des points d'interrogation et que vous trouvez que ce n'est pas très explicite et très lisible, vous pouvez nommer les identificateurs donc en gros là comme dire que j'attends un `:firstname`, je peux très bien dire que j'attends un identificateur comme ceci.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
			PDO::ATTR_EMULATE_PREPARES => false
		];

		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
			
>		$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = :fistname');
		$request->bindValue(1, "Tac");
		$request->execute();
		
		echo '<pre>';
		print_r($request->fetch(PDO::FETCH_ASSOC));
		echo '</pre>';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Et là du coup je nomme mon identificateur `:firstname` en mettant : devant ça c'est important.

Et là seule différence c'est que vous devez le passer tel quel donc en gros ici vous devez passer l'identificateur au lieu de passer un numéro 1, 2, 3, 4, 5 et cetera quand on a plusieurs valeurs, on passe ça.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_EMULATE_PREPARES => false
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = :fistname');
	
	$request->bindValue(":fistname", "Tac");
	$request->execute();
	
	echo '<pre>';
	print_r($request->fetch(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/
	Array
	(
		[id_client] => 6
		[client_firstname] => Tac
		[client_lastname] => KAT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
```
Voyez si j'actualise c'est exactement la même chose. 

Alors quand on avait le ?, je l'ai pas vu mais je pense que vous avez compris et que je fais ça et que je passe un second paramètre. Du coup je me retrouve avec une requête préparée avec deux ? et bien la première valeur serra passée avec un 1 et pour la deuxième il suffit de mettre un deux et donc là client_loyalty est à 5 points de fidélité donc on passe ça.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_EMULATE_PREPARES => false
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = ? AND client_loyalty = ?');
	
	$request->bindValue(1, "Tac");
	$request->bindValue(2, 5);
	$request->execute();
	
	echo '<pre>';
	print_r($request->fetch(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/
	Array
	(
		[id_client] => 6
		[client_firstname] => Tac
		[client_lastname] => KAT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
```
Voilà ça valide tout pareil. 

Ça je ne l'avais pas montré directement mais maintenant c'est fait et voilà comment ça fonctionne avec le ? Sinon nous passons par des identificateurs nommés avec un : et un nom. Et du coup en passant cet identificateur en premier paramètre que ce soit pour bindValue() ou bindParam() encore une fois ça fonctionne pareil pour les 2, elles ont le même fonctionnement.

Et donc ça va bien injecter l'information, aucun souci.

si je met Tic, ça change l'info.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_EMULATE_PREPARES => false
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = :name');
	
	$request->bindValue(':name', "Tic");
	$request->execute();
	
	echo '<pre>';
	print_r($request->fetch(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```
	http://localhost/PHP/cours/031_s%C3%A9curis%C3%A9_requ%C3%AAtes_SQL/
	Array
	(
		[id_client] => 5
		[client_firstname] => Tic
		[client_lastname] => KIT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
```
Voilà pour ça et on va pouvoir terminer rapidement parce que je n'ai pas complété au niveau des méthodes d'injection, au niveau des types de données.

Si on veut encore ajouter un petit plus, on peut également vérifier le type de données à passer. 

Alors ça peut être un petit peu déroutant parce que entre le type de données PHP et le type de données SQL, il n'y a pas forcément toutes les mêmes similitudes mais en gros bindValue(), bindParam() vont gérer vos données par défaut comme étant des chaînes de caractères ce qui en SQL ne pose pas trop de problème parce qu'en gros vous lui passé un âge par exemple qui est sous forme de chaîne de caractères mettons 25 ans comme ça.
```php
	$request->bindValue(':name', "Tic");//"25"
```
Si SQL derrière, son champ, si on regarde le champ de la base de données que je fais ceci.
```sql
	mysql
	-----
	
	> describe fv_clients;
	+------------------+-------------+------+-----+---------+----------------+
	| Field            | Type        | Null | Key | Default | Extra          |
	+------------------+-------------+------+-----+---------+----------------+
	| id_client        | int         | NO   | PRI | NULL    | auto_increment |
	| client_firstname | varchar(65) | NO   |     | NULL    |                |
	| client_lastname  | varchar(65) | NO   |     | NULL    |                |
	| client_birthday  | date        | NO   |     | NULL    |                |
	| client_loyalty   | int         | NO   |     | NULL    |                |
	+------------------+-------------+------+-----+---------+----------------+
	5 rows in set (0.01 sec)
```
Comme ceci et que derrière on voit qu'il y a une information qui attend un int par exemple Hé bien SQL ne va pas broncher il va convertir en fait la chaîne de caractères en int et ça "25" sous forme de chaînes de caractères convertis en int, ça fait ça 25 donc pas de souci le 25 ne posera pas de problème donc encore une fois ça ne va pas générer d'erreur mais si on veut absolument s'assurer des types de données on peut le faire également quand on fait une action via bindValue() ou bindParam() en passant en 3e paramètre. 

Admettons client_loyalty pour quelqu'un qui aurait 100 points, monsieur macron par exemple et enfin passer :pts pour les points.
```php
	$request->bindValue(':pts', 100, ...);
```
`:pts`, quelqu'un qui aurait 100 et admettons que cette valeur, je veux absolument qu'elle soit bien prise comme un entier si par exemple c'est issu d'un formulaire, d'une variable entrée par l'utilisateur et qu'on veut être sûr que ce soit traité comme un entier et pas comme autre chose d'accord admettons.

Et bien pour faire la vérification, je peux passer un autre paramètre en mettant `PDO::` donc c'est une constante lié à PDO puis `PDO::PARAM_` puis le type en question.

Par défaut c'est comme ça.
```php
	$request->bindValue(':pts', 100, PDO::PARAM_STR);
```
Si vous faites ça, ça revient à ne pas le mettre du tout ce paramètre et sinon vous avez pas mal de chose, vous avez le paramètre null qu'on retrouve en sql.
```php
	$request->bindValue(':pts', 100, PDO::PARAM_NULL);
```
On a le paramètre bool pour les booléen.
```php
	$request->bindValue(':pts', 100, PDO::PARAM_BOOL);
```
On a l'entier pour un nombre.
```php
	$request->bindValue(':pts', 100, PDO::PARAM_INT);
```
Donc pour float et cetera, vous mettez en fait un INT et par rapport à ça ce serait pris en compte.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
			PDO::ATTR_EMULATE_PREPARES => false
		];

		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
			
		$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_loyalty = :pts');
		
>		$request->bindValue(':pts', 100, PDO::PARAM_INT);
		$request->execute();
		
		echo '<pre>';
		print_r($request->fetch(PDO::FETCH_ASSOC));
		echo '</pre>';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Généralement ça ne sera pas forcément utile dans la majorité des cas parce qu'en passant sous forme de chaîne SQL ne bronche pas parce que convertir un nombre sous forme de forme de chaîne de caractères en nombre algébrique, il arrive à faire la conversion sans problème.

Il retire simplement les délimiteurs de la chaîne est terminé, il arrive à stocker l'information. 

Généralement il n'y a pas besoin, après s'il y a des cas où ça pourrait être contourné et cassé, ça peut être bien de vérifier le type donc sachez que vous pouvez avoir ce type de paramètre-là. 

Alors je vais quand même vous les noter rapidement et s'est `PDO::` pour tous les paramètres et là vous avez du coup.
```php
	/*
		PDO::PARAM_STR (par défaut)
		PDO::PARAM_NULL
		PDO::PARAM_BOOL
		PDO::PARAM_INT
	*/
```
Alors `PDO::PARAM_STR` c'est par défaut donc si c'est par défaut vous n'avez pas forcément besoin de le spécifier et enfin on a INT pour les nombres.

Voilà ce sont de petits paramètres de données à injecter via bindValue() ou bindParam() qui sont en tout cas intéressant à savoir et à connaître par rapport à ça, que je rappelle en 3e paramètre pour ces 2 méthodes.

Et voilà je pense qu'on a fait le tour, j'avais noté les gros points qu'il faut qu'on voit ensemble, j'avais fait une petite liste.

Je veux parler des méthodes à voir, les requêtes préparées, on a fait le tour et apparemment on a fait le tour de tout. 

Voilà tout ce que nous devions voir ensemble par rapport à nos requêtes. 

Voilà encore une fois pour clore cette séance alors que cela fait une demie heure que je suis en enregistrement donc au moins on aura fait le tour de tout que ce soit l'aspect sécurité et requête préparée donc vous avez tout le nécessaire concernant l'utilisation des requêtes via PDO donc voyez qu'il y a évidemment pas mal d'autres choses en plus parce que PDO n'a pas que ça comme méthode ou autre. 

On peut faire plein d'autres choses mais par rapport à ce que vous pourriez faire normalement avec ça vous avez déjà moyen d'exécuter toutes les requêtes qu'il faut, d'utiliser le pilote en question, d'avoir les bons paramètres et voilà ça collera pour pratiquement tous les scénarios donc il n'y aura pas de problème. 

Si vous avez besoin de faire des choses un peu particulières et que vous voulez en savoir un peu plus sur PDO n'hésitez pas à aller voir sur la doc, il n'y a pas mal d'autres méthodes, pas mal d'autres choses que l'on peut faire avec. 

On n'a pas vu 100 pour 100 de la classe PDO et de tout ce qu'elle propose parce que c'est évidemment quelque chose d'assez conséquent. 

En tout cas tout ce qui concerne la communication avec une base de données, bon je m'arrêterai là parce que la prochaine vidéo à priori sera la conclusion de la formation donc une vidéo qui va faire la fin tout simplement de ce cours PHP qui j'espère vous aura plu donc on verra bien sûr tout ça dans la séance prochaine pour faire un bref résumé comme je fais habituellement sur tout ce qu'on a vu sur cette formation et sur les tutos éventuellement et puis les exercices et tout ça que vous avez en association avec le cours pour pouvoir vous exercer et puis compléter un petit peu toute les notions qu'on a vu sur la formation.

Voilà s'il y a des commentaires ou des questions n'hésitez pas et évidemment privilégier encore une fois, c'est quelque chose que j'ai pas mal répété sur la vidéo mais c'est important, dites-vous que si je répète beaucoup et trop souvent des erreurs faites et concernant des négligences, la sécurité par rapport à du développement web donc c'est très important.

Ce n'est pas une fois qu'il sera arrivé à un vol de données ou autre qu'il faudra se dire que j'y avais pas pensé et j'avais la flemme de sécuriser mon site, et du coup je me retrouve au tribunal parce que je suis responsable du vol de données qu'il y a eu sur mon site web. 

Faites attention à ça, on parle quand même de sujets très sérieux, très important, ne faites pas n'importe quoi avec les données des utilisateurs et prenez dès le départ l'habitude je ne pas séparer la conception par rapport à la sécurité. 

On ne fait pas de la conception en informatique, quel qu'elle soit même dans le jeu vidéo sans faire de sécurité sinon c'est qu'on a un mauvais développeur et dans ce cas-là il faut changer de métier, il faut changer de domaine. 

Je vous dis à bientôt pour la prochaine séance et n'hésitez pas dans les commentaires de la vidéo s'il y a des questions, des remarques. 

Je suis évidemment présent si youtube ne pose pas de problème parce que au moment où je fais cette vidéo vous savez qu'il y a des petits bugs avec les commentaires où je laisse des réponses à vos commentaires puis il y en a certaines qui disparaissent mais ça c'est de la magie d'internet, ce sont peut-être des requêtes pas préparées, on ne sait pas !

Bref je vous fais des bisous à tous et on se reverra pour la prochaine vidéo. 

Ciao et à bientôt