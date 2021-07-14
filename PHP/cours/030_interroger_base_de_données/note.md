# [30. Interroger base de données](https://www.youtube.com/watch?v=W1g01wKWVv4)
21-12-2020

Bonjour à tous, on se retrouve pour la 30e séance en PHP. 

On va continuer avec l'utilisation de l'interface PDO qu'on avait configuré et préparé dans la vidéo précédente et on va voir un petit peu dans cette vidéo comment interroger notre base de données. 

Alors rappel très rapide j'ai démarré mon serveur Apache pour le serveur web.
```powershell
	\MyWAMP\apache\bin\httpd.exe
```
J'ai démarré un serveur MySQL aussi parce qu'il va bien falloir que je me connecter à la base de données. 

J'ai gardé un autre terminal pour pouvoir éventuellement me connecter avec le client pour voir ce que j'ai en fait dans la table SQL que nous allons interroger pour tout simplement comparer les données et que vous puissiez visuellement voir qu'on a bien effectivement récupéré les informations que l'on voulait.
```powershell
	\MyWAMP\mysql\bin\mysqld.exe

	>mysqld.exe --console
	2020-12-21T14:52:32.210796Z 0 [System] [MY-010116] [Server] C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\mysql\bin\mysqld.exe (mysqld 8.0.22) starting as process 4176
	2020-12-21T14:52:32.531500Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
	2020-12-21T14:52:33.711158Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
	2020-12-21T14:52:34.113620Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060
	2020-12-21T14:52:34.294047Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
	2020-12-21T14:52:34.294406Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
	2020-12-21T14:52:34.414863Z 0 [System] [MY-010931] [Server] C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\mysql\bin\mysqld.exe: ready for connections. Version: '8.0.22'  socket: ''  port: 3306  MySQL Community Server - GPL.
```
Voilà par rapport à ça. 

On va reprendre le code qu'on avait dans la vidéo précédente.
```php
<?php

require 'db-config.php';

try
{
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS);
	
	echo 'Connexion &eacute;tablie !';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}
```
Vous voyez la connexion à PDO tout ce qu'on avait déjà vu est on en était arrivé justement à une connexion établie.
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	Connexion établie !
```
Une fois que tout était configuré, que le driver était bien récupéré est mis en place dans notre configuration de PHP ce qui était évidemment très important par rapport à ça. 

Une fois que ceci est fait on va déjà commencer par et je ne l'avais pas fait dans la vidéo précédente mais on va le garder du coup pour ici. 

On va commencer par rajouter quelques petites options concernant notamment la création de notre connexion avec PDO qui sont quand même très utiles pour la suite. 

Il y a un paramètre optionnel qu'on doit passer ici au constructeur de PDO() d'accord qui est un paramètre en fait avec des options que nous pouvons lui donner en utilisant des constantes liées à PDO qui vont pouvoir avoir comme ça des valeurs particulières en fonction de ce que l'on veut comme paramètre. 

Nous allons créer une petite variable ici `$options[]` qui est un tableau associatif donc on va faire ça comme ça.
```php
require 'db-config.php';

	try
	{
		$options =
		[
		
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS);
		
		echo 'Connexion &eacute;tablie !';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Voilà notre petite variable ici qui est un tableau associatif et on va lui passer un certain nombre de paramètres. Je vais vous en donner quelques-uns qui me semble indispensable pour ne pas avoir de problème avec ce qu'on va faire ici au niveau de PHP. 

Et certains autres en tout cas qui pourront vous servir éventuellement dans des cas très spécifiques. 

Petite parenthèse je rappelle qu'on travaille toujours en utf 8 en informatique, très important. Vous voyez que je suis en utf 8 depuis mon éditeur.

Pour ceux qui ont suivi et il faut avoir suivi de toutes façons le cours SQL où je vous avais montré comment configurer en fait tout votre encodage au niveau SQL pour avoir des tables en utf8mb4 donc être en encodage utf 8 aussi et là nous allons régler ça pour la configuration de l'interface PDO. 

Pouvoir par exemple manipuler des données toujours en travaillant avec l'encodage utf 8. 

Pour ça nous allons passer cette première option, `PDO::`, très importante qui va permettre en fait avec MySQL de lancer une commande à l'initialisation donc à la création de notre instance de PDO donc on va faire `MYSQL ATTRIBUTE INIT COMMAND` avec tout en majuscule, c'est important et COMMAND sans E parce que c'est le terme anglais.
```php
	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => ''
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS);
		
		echo 'Connexion &eacute;tablie !';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Ensuite nous allons lui passer une requête d'initialisation donc qui va être fait au tout début pour être sûr de travailler avec nos données en utf 8. 

On a juste à faire `SET NAMES utf8`.
```php
	try
	{
		$options =
		[
>			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8'
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS);
		
		echo 'Connexion &eacute;tablie !';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
`SET NAMES utf8`, voilà la première option très importante pour être sûr de travailler toujours avec le bon encodage. 

2e option et pas des moindres, ça va être tout simplement ATTRIBUTE ERRMODE donc le mode d'erreur que nous allons avoir enfaite pour PDO. 
```php
	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
>			PDO::ATTR_ERRMODE =>
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS);
		
		echo 'Connexion &eacute;tablie !';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Ce mode ATTR_ERRMODE prend la valeur ERRMODE_SILENT Donc vous voyez que c'est assez simple à retenir au niveau des constantes, de la manière dont elles sont écrites c'est toujours un petit peu le même principe.
```php
	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
>			PDO::ATTR_ERRMODE => PDO::ERRMODE_SILENT
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS);
		
		echo 'Connexion &eacute;tablie !';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Alors nous avons ceci et ça c'est le mode par défaut pour la gestion des erreurs en gros s'il y a une erreur qui survient avec pdo, comme c'est un mode silencieux, on aura aucun affichage qui est fait. 

Lorsqu'on est en mode débugs ou en tout cas en mode développement, ce n'est quand même pas très pratique mais moi ce que je vous recommandé au minimum c'est de travailler sous forme d'avertissement c'est-à-dire que vos erreurs soient gérées comme des avertissements et c'est le minimum que l'on puisse faire en tout cas par rapport à ça.
```php
	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
>			PDO::ATTR_ERRMODE => PDO::ERRMODE_WARNING
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS);
		
		echo 'Connexion &eacute;tablie !';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Et le mieux c'est que vos erreurs soient gérées comme des exceptions donc on mettra ERRMODE_EXCEPTION comme ceci.
```php
	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
>			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS);
		
		echo 'Connexion &eacute;tablie !';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
On mettra ça comme ceci donc `PDO::` 2 fois 2 points c'est-à-dire l'opérateur de portée terminer par ERRMODE_EXCEPTION avec un underscore entre les 2, `PDO::ERRMODE_EXCEPTION`. 

Voilà donc les 2 options qui me semblent en tout cas indispensable pour manipuler les interfaces PDO, ce qui me semble beaucoup plus pratique comme ça. 

Alors maintenant une petite option facultative pour ceux que ça pourrait intéresser surtout quand vous aurez pris l'habitude de vous en servir et que vous aurez peut-être des projets un peu plus développés que ça. 

Quand vous aurez par exemple besoin d'avoir une connexion persistante c'est-à-dire qu'il reste en place, quel reste démarré par rapport à PDO. Ainsi vous pourrez également ajouter cela dans les options en disant tout simplement ATTRIBUTE ça va être PERSISTENT si je ne me trompe pas dans les termes et il reste un booléen donc il suffit de le passer à true. 
```php
	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
>			PDO::ATTR_PERSISTENT => true
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS);
		
		echo 'Connexion &eacute;tablie !';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Voilà une fois passé à true, votre connexion de PDO sera persistante donc sera conservé. 

Alors par défaut c'est à false donc en fait ça revient à ne pas avoir l'option. 

Alors moi généralement je ne la met pas mais dans les cas où ça peut servir éventuellement, sachez que vous avez une option de PDO qui permet de le faire. 

Voilà en tout cas en ce qui concerne le strict minimum et ainsi nous pouvons passer ces options en dernier paramètre de PDO().
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	echo 'Connexion &eacute;tablie !';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}
```
Sachant que ce paramètre est un paramètre de toute façon optionnel donc on a `$DB_DSN`, `$DB_USER`, `$BD_PASS` et les `$options` qui sont facultatives et qui sont du coup un tableau associatif ici.
```php
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
```
Voilà maintenant que nous avons avec que tout est configuré par rapport à toute la partie options de notre interface pdo, on va pouvoir commencer à découvrir les premières méthodes en tout cas comment réaliser une requête SQL. 

Déjà on va vérifier si on n'a pas fait d'erreur et ça m'a l'air d'être bon.
```php
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	Connexion établie !
```
Alors ça a l'air d'être bon, il nous dit que la connexion a réussi mais on le verra plus tard ainsi si on voit qu'on a des choses bizarres, on saura que l'utf 8 ne pas activé donc on s'en rendra très vite compte des problèmes qu'on pourra rencontrer. 

Au niveau de la préparation pour une requête, on va utiliser une méthode qui s'appelle query qui va nous permettre de faire notre requête avec notre objet pdo que nous avons. 

On va donc écrire ça.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$PDO->query();
		
		//echo 'Connexion &eacute;tablie !';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Et elle va prendre en paramètre notre requête SQL. 

Alors moi je vais déjà là faire sur mon client MySQL pour que l'on voit un petit peu que nous avons bien des données à récupérer parce que si on n'avait rien ce serait un petit peu embêtant. 

Je me connecter sans souci. Ensuite je rappelle que dans ma configuration je demande à être connecté sur la base de données fv_database donc évidemment c'est à vous de modifier si vous n'avez pas le même nom ou autre. Vous savez comment faire.

+ db-config.php
```php
	<?php
	$DB_DSN = 'mysql:host=localhost;dbname=fv_database';
	$DB_USER = 'root';
	$DB_PASS = '';
```
```powershell
	client
	------
	
	> mysql -u root -p
	Enter password:
	Welcome to the MySQL monitor.  Commands end with ; or \g.
	Your MySQL connection id is 10
	Server version: 8.0.22 MySQL Community Server - GPL

	Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

	Oracle is a registered trademark of Oracle Corporation and/or its
	affiliates. Other names may be trademarks of their respective
	owners.

	Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

	mysql>
```
+ Voir script.sql
```sql
	mysql> DROP DATABASE IF EXISTS `fv_database`;
	Query OK, 0 rows affected (0.04 sec)

	mysql> CREATE DATABASE IF NOT EXISTS `fv_database`;
	Query OK, 1 row affected (0.01 sec)

	mysql> USE `fv_database`;
	Database changed
	mysql> CREATE TABLE IF NOT EXISTS `fv_clients`
		-> (
		-> `id_client` INT NOT NULL AUTO_INCREMENT,
		-> `client_firstname` VARCHAR(65) NOT NULL,
		-> `client_lastname` VARCHAR(65) NOT NULL,
		-> `client_birthday` DATE NOT NULL,
		-> `client_loyalty` INT NOT NULL,
		->
		-> PRIMARY KEY(`id_client`)
		-> );
	Query OK, 0 rows affected (0.11 sec)

	mysql> INSERT INTO `fv_clients`(`client_firstname`, `client_lastname`, `client_birthday`, `client_loyalty`)
		-> VALUES
		-> ('Jason', 'CHAMPAGNE', '1991-02-10', 15),
		-> ('Bamogo', 'SAKO', '1965-09-15', 3),
		-> ('Emmanuel', 'MACRON', '1977-12-21', 100),
		-> ('Coco', 'LASTICOT', '1327-02-28', '0'),
		-> ('Tic', 'KIT', '2000-05-16', '5'),
		-> ('Tac', 'KAT', '2000-05-16', '5');
	Query OK, 6 rows affected (0.03 sec)
	Records: 6  Duplicates: 0  Warnings: 0
```
## Reprise cours #30 - interroger base de données
```sql
	mysql> use fv_database;
	Database changed
```
Ensuite je peux vérifier mes tables.
```sql
	mysql> show tables;
	+-----------------------+
	| Tables_in_fv_database |
	+-----------------------+
	| fv_clients            |
	+-----------------------+
	1 row in set (0.03 sec)
```
J'ai une table fv_clients.

Je peux faire un describe de cette table si je veux.
```sql
	mysql> describe fv_clients;
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
On peut voir les différents champs qu'elle a. 

Et nous ce qui nous intéresse, c'est de récupérer toutes les informations éventuellement qu'elle aurait. 
```sql
	mysql> select * from fv_clients;
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
Et on voit qu'elle a 6 enregistrements de clients avec du coup un identifiant, un prénom, un nom, une date de naissance et des points des fidélités donc on va essayer de récupérer en PHP via PDO l'interface. On va récupérer toutes ces informations là.

Voilà donc logiquement avec cette requête `select * from fv_clients` devrait fonctionner en PHP donc je devrais pouvoir faire ceci et récupérer les mêmes informations.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$PDO->query('select * from fv_clients');
		
		//echo 'Connexion &eacute;tablie !';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Alors query() c'est la méthode qui est directement dans le paramètre de query() en fait Mais si vous voulez pour éviter les petites erreurs par exemple les oublis de quotes '', les oublis de virgule dans votre requête, vous pouvez passer par une petite variable intermédiaire aussi.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
>		$sql = 'SELECT * FROM fv_clients';		
>		$PDO->query($sql);
		
		//echo 'Connexion &eacute;tablie !';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Voilà je fais une petite variable $sql, je passe toute ma requête et en plus si je veux ça me permet de passer à la ligne éventuellement pour mieux la présenter dans mon fichier donc ça c'est à vous de voir.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
>		$sql = 'SELECT * 
>				FROM fv_clients';		
		$PDO->query($sql);
		
		//echo 'Connexion &eacute;tablie !';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Comme ça on ne passe le paramètre $sql à query() et ainsi il y a quand même moins de risque d'erreur en termes de lisibilité dans votre code. 

Vous pouvez passer par une variable bien évidemment, il n'y a aucun problème. 

C'est une méthode donc on peut lui passer une variable au lieu de lui passer une valeur en dur. 

À partir de là nous avons fait notre requête. 

On va vérifier du coup qu'est-ce que nous avons récupéré ici et histoire de vérifier ce qu'on a, on va le récupérer dans une variable que l'on va appeler par exemple `$results`.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$sql = 'SELECT * FROM fv_clients';
		
>		$results = $PDO->query($sql);
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Alors on va faire ça histoire de faire un petit rappel avec un print_r() de `$results` pour voir ce que ça nous a retourné cette fameuse requête query().
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	print_r($results);
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}
```
J'actualise.
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	PDOStatement Object ( [queryString] => SELECT * FROM fv_clients )
```
J'actualise et on voit pas mal d'informations, et nous allons pouvoir faire notre petit formatage propre en utilisant la balise `<pre>` qui a du HTML simplement pour avoir un meilleur formatage et que ce soit beaucoup plus lisible pour vous à l'écran et on entourent le print_r().
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	echo '<pre>';
	print_r($results);
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	PDOStatement Object
	(
		[queryString] => SELECT * FROM fv_clients
	)
```
Et du coup ça donne ça ce qui est beaucoup plus lisible. 

La voix donc on a un objet PDOStatement et du coup on a une information [queryString] qui est notre requête sous forme de chaîne de caractères `SELECT * FROM fv_clients`. 

Ça c'est une première info, c'est qu'en ayant ça on peut déjà vérifier que notre requête est bonne ou pas. 

Si on voit ici qu'il y a une erreur dans la syntaxe, on pourra se dire déjà qu'on s'est trompé quelque part mais là ça a l'air correct, il n'y a pas de problème donc on va pouvoir continuer par rapport à ça. 

Avec cette petite méthode query() nous venons de récupérer normalement tous les résultats que va retourner cette requête sql, `SELECT * FROM fv_clients`. 

Le problème c'est qu'ici on ne voit rien du tout parce que tout est dans le PDOStatement ici et à récupérer tous les enregistrements de manière brute donc ces enregistrements comme il y en a plusieurs, il va falloir tous les parcourir pour pouvoir tous les récupérer 1 à 1. 

Le moyen le plus rapide de faire ça, c'est tout simplement de faire un foreach() donc en gros je vais faire une boucle foreach() sur la variable `$results` que l'on va stocker dans une variable temporaire qu'on appellera ici `$re` comme ceci sauf que là comme je passe par une variable intermédiaire `$re`, on change le nom dans le print_r().
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	foreach($results as $re)
	{
		echo '<pre>';
		print_r($re);
		echo '</pre>';
	}
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
En gros c'est juste un parcours, une foreach() comme vous savez le faire aussi en PHP.

J'actualise. 
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	Array
	(
		[id_client] => 1
		[0] => 1
		[client_firstname] => Jason
		[1] => Jason
		[client_lastname] => CHAMPAGNE
		[2] => CHAMPAGNE
		[client_birthday] => 1991-02-10
		[3] => 1991-02-10
		[client_loyalty] => 15
		[4] => 15
	)
	Array
	(
		[id_client] => 2
		[0] => 2
		[client_firstname] => Bamogo
		[1] => Bamogo
		[client_lastname] => SAKO
		[2] => SAKO
		[client_birthday] => 1965-09-15
		[3] => 1965-09-15
		[client_loyalty] => 3
		[4] => 3
	)
	Array
	(
		[id_client] => 3
		[0] => 3
		[client_firstname] => Emmanuel
		[1] => Emmanuel
		[client_lastname] => MACRON
		[2] => MACRON
		[client_birthday] => 1977-12-21
		[3] => 1977-12-21
		[client_loyalty] => 100
		[4] => 100
	)
	Array
	(
		[id_client] => 4
		[0] => 4
		[client_firstname] => Coco
		[1] => Coco
		[client_lastname] => LASTICOT
		[2] => LASTICOT
		[client_birthday] => 1327-02-28
		[3] => 1327-02-28
		[client_loyalty] => 0
		[4] => 0
	)
	Array
	(
		[id_client] => 5
		[0] => 5
		[client_firstname] => Tic
		[1] => Tic
		[client_lastname] => KIT
		[2] => KIT
		[client_birthday] => 2000-05-16
		[3] => 2000-05-16
		[client_loyalty] => 5
		[4] => 5
	)
	Array
	(
		[id_client] => 6
		[0] => 6
		[client_firstname] => Tac
		[1] => Tac
		[client_lastname] => KAT
		[2] => KAT
		[client_birthday] => 2000-05-16
		[3] => 2000-05-16
		[client_loyalty] => 5
		[4] => 5
	)
```
J'actualise et nous avons tous les enregistrements qui sont bien récupéré, je vérifie normalement et on doit bien avoir 6 enregistrements. C'est bien le cas. 

On voit que ce sont des tableaux d'ailleurs. 

Alors les données là sont en brut c'est à dire qu à la base on veut juste récupérer ça l'identifiant, le prénom, le nom, la date de naissance, les points de fidélité, et ça pour les 6 enregistrements. 

Déjà quand on regarde là, on voit qu'avec ces données brutes on a beaucoup plus d'info que ça. 

On a effectivement ici sous forme d'indices [id_client] par exemple, les informations qui sont les champs de la base de données avec leur valeur => 1 donc ça pas de problème.

Par contre on retrouve plein de lignes supplémentaires, `[0] => 1`, `[1] => 2` … qui pour le coup ne me serviront pas d'ailleurs on voit qu'il y a des répétitions dans les informations `[client_lastname] => CHAMPAGNE` et `[2] => CHAMPAGNE`.

Voilà en fait on a l'association c'est-à-dire l'indice qui est en fait le champ de la base de données [id_client] donc de la table en l'occurrence, et nous avons le numéro de ligne [0]. 

Ainsi nous avons des informations de trop et qui du coup rendent un peu les données brutes beaucoup plus importante en quantité et nous c'est du coup pas mal d'informations qui ne servent pas voilà elles sont dupliquées. 

On va donc gérer ça autrement avec d'autres méthodes justement de pdo notamment une méthode fetch() qui va en fait tout simplement retourner une ligne d'accord de tous les résultats qu'on a récupéré ou éventuellement toutes les lignes d'un coup avec fetchAll() comment on verra un peu plus tard qui est une autre méthode.

Et on va pouvoir choisir un petit peu le mode de récupération de ces données pour pouvoir enfaite filtrer un petit peu ce qu'on récupère il ne pas se retrouver comme ça avec des données brutes comme ça en grande quantité. 

On va déjà changer le code ici pour avoir exactement le même résultat mais en passant par un fetch() donc en gros ce qu'on va faire, toujours dans un foreach().

foreach() c'est vraiment le type de boucle en PHP pour parcourir quelque chose donc c'est très pratique pour ça. On va mettre dans `$data` la variable `$results` en passant par un fetch().
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	foreach($data = $results->fetch())
	{
		echo '<pre>';
		print_r($data);
		echo '</pre>';
	}
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
Voilà et comme ça je passerai en paramètre de cette méthode fetch() que je laisse par défaut. 

Voilà nous faisons tout ça dans un foreach() donc c'est une affectation en fait c'est à dire que à chaque tour de boucle, à chaque itération, je vais faire un fetch() sur $results et je vais stocker le résultat de cette méthode, ce qu'elle retourne dans une variable $data. 

D'accord $data qui sera du coup disponible à chaque itération ici pour l'afficher via ce print_r(). 

On actualise.
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
```
Le foreach pose un problème donc on va mettre un while.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	while($data = $results->fetch())
	{
		echo '<pre>';
		print_r($data);
		echo '</pre>';
	}
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	Array
	(
		[id_client] => 1
		[0] => 1
		[client_firstname] => Jason
		[1] => Jason
		[client_lastname] => CHAMPAGNE
		[2] => CHAMPAGNE
		[client_birthday] => 1991-02-10
		[3] => 1991-02-10
		[client_loyalty] => 15
		[4] => 15
	)
	Array
	(
		[id_client] => 2
		[0] => 2
		[client_firstname] => Bamogo
		[1] => Bamogo
		[client_lastname] => SAKO
		[2] => SAKO
		[client_birthday] => 1965-09-15
		[3] => 1965-09-15
		[client_loyalty] => 3
		[4] => 3
	)
	Array
	(
		[id_client] => 3
		[0] => 3
		[client_firstname] => Emmanuel
		[1] => Emmanuel
		[client_lastname] => MACRON
		[2] => MACRON
		[client_birthday] => 1977-12-21
		[3] => 1977-12-21
		[client_loyalty] => 100
		[4] => 100
	)
	Array
	(
		[id_client] => 4
		[0] => 4
		[client_firstname] => Coco
		[1] => Coco
		[client_lastname] => LASTICOT
		[2] => LASTICOT
		[client_birthday] => 1327-02-28
		[3] => 1327-02-28
		[client_loyalty] => 0
		[4] => 0
	)
	Array
	(
		[id_client] => 5
		[0] => 5
		[client_firstname] => Tic
		[1] => Tic
		[client_lastname] => KIT
		[2] => KIT
		[client_birthday] => 2000-05-16
		[3] => 2000-05-16
		[client_loyalty] => 5
		[4] => 5
	)
	Array
	(
		[id_client] => 6
		[0] => 6
		[client_firstname] => Tac
		[1] => Tac
		[client_lastname] => KAT
		[2] => KAT
		[client_birthday] => 2000-05-16
		[3] => 2000-05-16
		[client_loyalty] => 5
		[4] => 5
	)
```
On a mis un while parce que le foreach posant problème parce que je ne lui donne pas de variable intermédiaire donc on va passer par un while ce qui sera plus efficace.

Au moins comme ça on n'aura pas de problème par rapport aux parenthèses (voir message d'erreur). 

Avec le while d'accord pour parcourir ici pour le coup avec le fetch(), on récupère `$data` donc ça ne change pas la manière de récupérer les données ici nous avons toutes les informations comme on l'a vu tout à l'heure avec le foreach. 

Quand on a fait un foreach sans faire de fetch, on avait exactement toutes ces informations-là donc c'est sûr que si vous faites ça, ça ne servira à rien ce que vous avez fait puisque on récupère exactement toutes les données en brut. 

Là où l'intérêt d'utiliser fetch() a son importance c'est qu'on va pouvoir lui passer des paramètres. 

En gros par défaut et je vais vous le noter ici en commentaire, quand on fait un FETCH par défaut on a un mode BOTH qui est appliqué donc ce mode de récupération de données en fait et on le voit justement dans le résultat c'est qu'on récupère à la fois ici les informations de la base de données tel que `[id_client]` et en plus de ça on récupère le numéro de ligne à chaque fois `[0]` c'est pour ça que l'on a des informations qui sont dupliquées à chaque fois.
```php
	/*
		FETCH :
			BOTH (par défaut)
	*/
```
Donc nous on va pouvoir choisir un autre mode plutôt que d'utiliser le mode par défaut.

Si on veut récupérer et c'est ça qui nous intéresse que ces informations-là : `[id_client] => 1` et cetera c'est-à-dire toutes les lignes où on a en indice le champ de la base de données et ensuite sa valeur, c'est en fait un tableau associatif que nous allons utiliser. 

On va donc utiliser le paramètre ASSOC et un tableau associatif vous savez ce que c'est, c'est tout simplement le genre de tableau que j'ai fait avec `$options = […];`
```php
	/*
		FETCH :
			BOTH (par défaut)
			ASSOC (tableau associatif)
	*/
```
Voilà un tableau associatif c'est un tableau qui a une clé => une valeur, une clé => une valeur, et cetera mais on a déjà vu ça dans le cours de toute façon bien avant. 

Alors on va utiliser ce mode-là ASSOC en passant en paramètre de fetch(), une autre constante. 

Comme pour les options de PDO tout à l'heure, on met `PDO::` donc ça c'est important et il ne faut pas se tromper et on met `fetch(PDO::FETCH_ASSOC)` mais sachez que par défaut c'est `fetch(PDO::FETCH_BOTH)` mais nous on veut ça.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	/*
		FETCH :
			BOTH (par défaut)
			ASSOC (tableau associatif)
	*/
	
	while($data = $results->fetch(PDO::FETCH_ASSOC))
	{
		echo '<pre>';
		print_r($data);
		echo '</pre>';
	}
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
Et là j'actualise.
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	Array
	(
		[id_client] => 1
		[client_firstname] => Jason
		[client_lastname] => CHAMPAGNE
		[client_birthday] => 1991-02-10
		[client_loyalty] => 15
	)
	Array
	(
		[id_client] => 2
		[client_firstname] => Bamogo
		[client_lastname] => SAKO
		[client_birthday] => 1965-09-15
		[client_loyalty] => 3
	)
	Array
	(
		[id_client] => 3
		[client_firstname] => Emmanuel
		[client_lastname] => MACRON
		[client_birthday] => 1977-12-21
		[client_loyalty] => 100
	)
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
		[id_client] => 5
		[client_firstname] => Tic
		[client_lastname] => KIT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
	Array
	(
		[id_client] => 6
		[client_firstname] => Tac
		[client_lastname] => KAT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
```
J'actualise et voilà comment on récupère les données, et là c'est déjà beaucoup plus propre et beaucoup mieux filtré. 

On a vraiment que les informations que l'on veut pour chacun des enregistrements. 

Alors ça `PDO::FETCH_ASSOC` on peut passer directement en paramètre quand on appelle fetch() mais on peut aussi utiliser directement une méthode pour changer l'information. 

En gros donc quand on a fait ici une query() au lieu de faire `PDO::FETCH_ASSOC` que je copie sur `$results` bien avant et je peux tout simplement le changer avec la méthode qui s'appelle setFetchMode().

Ca revient au même sauf que du coup on le fait avant.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	$results->setFetchMode(PDO::FETCH_ASSOC);
	
	/*
		FETCH :
			BOTH (par défaut)
			ASSOC (tableau associatif)
	*/
	
	while($data = $results->fetch())
	{
		echo '<pre>';
		print_r($data);
		echo '</pre>';
	}
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	
	Array
	(
		[id_client] => 1
		[client_firstname] => Jason
		[client_lastname] => CHAMPAGNE
		[client_birthday] => 1991-02-10
		[client_loyalty] => 15
	)
	Array
	(
		[id_client] => 2
		[client_firstname] => Bamogo
		[client_lastname] => SAKO
		[client_birthday] => 1965-09-15
		[client_loyalty] => 3
	)
	Array
	(
		[id_client] => 3
		[client_firstname] => Emmanuel
		[client_lastname] => MACRON
		[client_birthday] => 1977-12-21
		[client_loyalty] => 100
	)
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
		[id_client] => 5
		[client_firstname] => Tic
		[client_lastname] => KIT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
	Array
	(
		[id_client] => 6
		[client_firstname] => Tac
		[client_lastname] => KAT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
```
Voyez que j'actualise et c'est tout pareil donc on peut faire l'un ou l'autre, c'est vous qui voyez. 

Ici setFetchMode() ça va évidemment changer le mode complètement tandis que si vous le faites sur le fetch() c'est au moment de faire ici l'appel à fetch() qu'on va utiliser le paramètre en question donc ça ne va pas le changer de manière définitive pour le reste. 

À vous de voir comment vous voulez modifier l'information donc nous on va laisser comme ça parce qu'on va tester également d'autres modes.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$sql = 'SELECT * FROM fv_clients';
		
		$results = $PDO->query($sql);
		
		/
			FETCH :
				BOTH (par défaut)
				ASSOC (tableau associatif)
		/
		
		while($data = $results->fetch(PDO::FETCH_ASSOC))
		{
			echo '<pre>';
			print_r($data);
			echo '</pre>';
		}
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Voilà le mode par défaut et du coup pour maintenant récupérer l'information qui va bien, admettons que je veux récupérer que les prénoms de chacune des lignes qui ont été récupérés dans mes résultats, je vais faire `echo $data` parce que c'est la variable que nous utilisons dans la boucle et entre crochets comme un indice `$data['']`, un indice de tableau parce que nous sommes sur un tableau associatif nous allons donc lui passer le champ en question. 

Voilà et donc nous c'est client_firstname qu'on met à `$data['client_firstname']` alors je rappelle que c'est les champs de la base de données MySQL que nous avons ici.
```sql
	> select * from fv_clients;
	+-----------+------------------+-----------------+-----------------+----------------+
>	| id_client | client_firstname | client_lastname | client_birthday | client_loyalty |
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
Voilà c'est ce qu'on met dans notre base de données MySQL. On fait ça et je vais mettre des paragraphe HTML `<p>` histoire que ce ne soit pas tout à la suite. On va concatener tout ça (`.`) et voilà.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	/*
		FETCH :
			BOTH (par défaut)
			ASSOC (tableau associatif)
	*/
	
	while($data = $results->fetch(PDO::FETCH_ASSOC))
	{
		echo '<p>'.$data['client_firstname'].'</p>';
	}
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	Jason

	Bamogo

	Emmanuel

	Coco

	Tic

	Tac
```
Et là du coup nous avons bien toute l'information qui récupéré à chaque fois information qui a récupéré à chaque fois. 

Alors on peut le faire pour autre chose si on veut récupérer en même temps une autre information, on peut demander à récupérer l'information en question par la suite qu'on va séparer par ` / `, slash comme ça et qu'on voudrait récupérer le nombre de points par exemple. Eh bien ce serait la même chose.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	/*
		FETCH :
			BOTH (par défaut)
			ASSOC (tableau associatif)
	*/
	
	while($data = $results->fetch(PDO::FETCH_ASSOC))
	{
		echo '<p>'.$data['client_firstname'].' / '.$data['client_loyalty'].'</p>';
	}
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	Jason / 15

	Bamogo / 3

	Emmanuel / 100

	Coco / 0

	Tic / 5

	Tac / 5
```
Voilà j'actualise et nous avons toute l'information qui est automatiquement formatée de la manière que vous voulez. 

Ça c'est le mode associatif, très pratique d'accord. 

Si vous aimez bien les tableaux associatifs, Eh bien avec FETCH_ASSOC vous aurez donc ce format là pour les résultats quand vous avez récupéré dans le fetch. 

N'oubliez pas qu'il faut boucler dessus parce que lorsque vous utilisez la méthode fetch(), ça ne retourne qu'une seule ligne. 

Donc si je le fais hors d'une boucle d'accord si je fais juste ça.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
		
	$data = $results->fetch(PDO::FETCH_ASSOC);
	
	echo '<p>'.$data['client_firstname'].' / '.$data['client_loyalty'].'</p>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}
?>
```
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	Jason / 15
```
Ainsi le $data contient la première ligne qui est retournée donc en gros la première ligne de notre tableau MySQL.
```sql
	> select * from fv_clients;
	+-----------+------------------+-----------------+-----------------+----------------+
	| id_client | client_firstname | client_lastname | client_birthday | client_loyalty |
	+-----------+------------------+-----------------+-----------------+----------------+
>	|         1 | Jason            | CHAMPAGNE       | 1991-02-10      |             15 |
	|         2 | Bamogo           | SAKO            | 1965-09-15      |              3 |
	|         3 | Emmanuel         | MACRON          | 1977-12-21      |            100 |
	|         4 | Coco             | LASTICOT        | 1327-02-28      |              0 |
	|         5 | Tic              | KIT             | 2000-05-16      |              5 |
	|         6 | Tac              | KAT             | 2000-05-16      |              5 |
	+-----------+------------------+-----------------+-----------------+----------------+
	6 rows in set (0.00 sec)
```
Et après si il faut la 2e il faudrait en fait refaire la commande, et refaire et cetera. 

Pour donc éviter la répétition de code comme on l'a appris en programmation, on utilise pour cela une boucle et la boucle en fait ici.
```php
	while($data = $results->fetch(PDO::FETCH_ASSOC))
	{
		echo '<p>'.$data['client_firstname'].' / '.$data['client_loyalty'].'</p>';
	}
```
La boucle ici tant qu'elle renvoie quelque chose, le while va continuer et la boucle va s'arrêter quand fetch() retournera false donc quand il n'y aura plus aucun enregistrement à retourner, la méthode retourne false et du coup votre boucle s'arrêtera sans problème. 

Autre mode du coup parce que là on a vu le mode associatif donc ça c'est un cas qui peut être intéressant mais comme PHP est aussi un langage qui permet de programmer en objet, il y en a peut-être parmi vous qui vont préférer manipuler des objets. 

En gros donc le fetch() va transformer les éléments qu'on a récupéré en résultat sous forme de objet standard de PHP. 

Et dans ce cas-là nous avons le mode OBJ et donc on aura un objet qui va être retourné à la place. 

On va donc faire FETCH_OBJ et du coup, on récrit notre print_r() avec les balises `<pre>`.
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	/*
		FETCH :
			BOTH (par défaut)
			ASSOC (tableau associatif)
			OBJ (objet)
	*/
	
	while($data = $results->fetch(PDO::FETCH_OBJ))
	{
		echo '<pre>';
		print_r($data);
		echo '</pre>';
	}
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}
?>
```
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	stdClass Object
	(
		[id_client] => 1
		[client_firstname] => Jason
		[client_lastname] => CHAMPAGNE
		[client_birthday] => 1991-02-10
		[client_loyalty] => 15
	)
	stdClass Object
	(
		[id_client] => 2
		[client_firstname] => Bamogo
		[client_lastname] => SAKO
		[client_birthday] => 1965-09-15
		[client_loyalty] => 3
	)
	stdClass Object
	(
		[id_client] => 3
		[client_firstname] => Emmanuel
		[client_lastname] => MACRON
		[client_birthday] => 1977-12-21
		[client_loyalty] => 100
	)
	stdClass Object
	(
		[id_client] => 4
		[client_firstname] => Coco
		[client_lastname] => LASTICOT
		[client_birthday] => 1327-02-28
		[client_loyalty] => 0
	)
	stdClass Object
	(
		[id_client] => 5
		[client_firstname] => Tic
		[client_lastname] => KIT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
	stdClass Object
	(
		[id_client] => 6
		[client_firstname] => Tac
		[client_lastname] => KAT
		[client_birthday] => 2000-05-16
		[client_loyalty] => 5
	)
```
Si j'actualise on voit que cette fois çi, nous avons des stdClass Object d'accord donc ce sont des objets standards de PHP. 

Ce ne sont plus des tableaux associatifs, c'est vraiment des objets. 

Et du coup la méthode d'accès à cette information donc au lieu de faire le fameux tableau de tout à l'heure où faisait ceci.
```php
	while($data = $results->fetch(PDO::FETCH_ASSOC))
	{
>		echo '<p>'.$data['client_firstname'].' / '.$data['client_loyalty'].'</p>';
	}
```
Tout à l'heure on faisait ça quand on était en mode ASSOC, d'accord associatif mais en mode objet comme c'est tout simplement sous forme d'objets comme si on accédait à un attribut, Eh bien du coup c'est une flèche on fait comme ça.
```php
	while($data = $results->fetch(PDO::FETCH_OBJ))
	{
>		echo '<p>'.$data->client_firstname.'</p>';
	}
```
Voilà donc le nom de l'information `$data` qui est du coup un objet et pour accéder à un de ses attributs parce que cette fois-ci ce sont des attributs et non pas des clés dans le tableau associatif, on utilise la flèche. 
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	/*
		FETCH :
			BOTH (par défaut)
			ASSOC (tableau associatif)
			OBJ (objet)
	*/
	
	while($data = $results->fetch(PDO::FETCH_OBJ))
	{
		echo '<p>'.$data->client_firstname.'</p>';
	}
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}
```
```php
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	Jason

	Bamogo

	Emmanuel

	Coco

	Tic

	Tac
```
Donc on a le nom de l'information $data qui est du coup un objet et pour accéder à un de ses attributs parce que cette fois-ci ce sont des attributs et non pas de clés d'un tableau associatif et du coup on utilise la flèche. 

Ça revient au même c'est simplement qu'on lit la donnée d'une autre manière. 

Voilà elles sont formatées d'une autre manière et ce ne sont plus des tableaux mais des objets que l'on manipule. 

Ça du coup c'est vraiment une question de préférence après il y a certains modes qui sont plus efficaces que d'autres selon les types et la quantité d'informations que vous récupérées mais c'est quand même des écarts qui ne sont pas énormissime. 

Ainsi ici c'est surtout une question de préférence. 

Si vous préférez manipuler du tableau associatif, vous utiliserez le mode ASSOC. 

Si vous préférez manipuler tout sous forme d'objet, vous utiliserez OBJ donc FETCH_OBJ comme ceci pour manipuler sous forme d'objet.
```php
	while($data = $results->fetch(PDO::FETCH_OBJ))
	{
		echo '<p>'.$data->client_firstname.'</p>';
	}
```
Alors ça c'est à vous de voir en fonction de ce que vous faites sur votre projet. 

Et voilà un petit peu comment on peut récupérer toutes les informations. 

Alors vous voyez qu'on a fait du coup un fetch() donc le truc c'est que quand on fait une requête par exemple on est sûr de récupérer qu'un seul résultat, on peut éventuellement faire un fetch() de cette manière c'est-à-dire qu'on n'en fait qu'un seul, pas de problème, il n'y a pas besoin d'utiliser une boucle.

Voilà parce que la boucle ça consomme un peu plus quand même, on a plusieurs itérations donc ce n'est pas forcément efficace. 

Si vous avez besoin de récupérer plusieurs informations et c'est là que pour le coup ça va être intéressant. 

Plutôt que de faire une boucle parce que de toute façon ici je suis sûr de retourner plusieurs personnes avec `SELECT * FROM fv_clients` et au pire s'il n'y en a qu'une seule ce n'est pas trop grave non plus. 

Ainsi je ne vais pas utiliser fetch() mais je vais utiliser fetchAll() donc en gros ce que je vais faire, je commence par enlever certaines choses de mon code.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$sql = 'SELECT * FROM fv_clients';
		
		$results = $PDO->query($sql);
		
>
		
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
`$results` ce qui est ici, et pour récupérer tous les clients on va faire par exemple `$list_clients`. 

On va récupérer tous les clients comme ceci `$list_clients = $results->fetchAll()`.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$sql = 'SELECT * FROM fv_clients';
		
		$results = $PDO->query($sql);
		
>		$list_clients = $results->fetchAll();
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Attention à bien respecter encore une fois les minuscules et les majuscules c'est-à-dire que fetch est en minuscule et le A de ALL est en majuscule. 

Et ensuite je lui passe le paramètre que je voulais donc par exemple éventuellement en associatif.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$sql = 'SELECT * FROM fv_clients';
		
		$results = $PDO->query($sql);
		
>		$list_clients = $results->fetchAll(PDO::FETCH_ASSOC);
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
En fait nous allons pouvoir vérifier comment est-ce que ça va être récupéré avec la fonction print_r().
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	$list_clients = $results->fetchAll(PDO::FETCH_ASSOC);
	
	echo '<pre>';
	print_r($list_clients);
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
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
Voilà on peut actualiser ou bien toutes les informations ici récupérées. 

Voilà vous voyez qu'on a bien un tableau l'information d'indice 0 est récupéré là-dedans. 

Cette forme là représente déjà un tableau associatif et l'avantage de fetchAll() plutôt que le simple fetch() C'est pourquoi nous allons pouvoir utiliser un foreach(). 

Plus efficace nous allons pouvoir faire ceci parce que le foreach() est vraiment fait pour le parcours donc si on utilise le fetch() on va utiliser while(), ce qui n'est pas forcément le plus pratique. 

Là ici comme on en a plein d'enregistrement, on dit que pour chacun des clients de la liste donc par exemple comme ceci.
```php
	foreach($list_clients as $client)
	{
		
	}
```
Pour chacun des clients de la liste nous allons pouvoir indiquer une information particulière donc en gros je peux faire un echo `$client` ce qui est quand même beaucoup plus lisible en terme de nom de variable et ici du coup client_firstname.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$sql = 'SELECT * FROM fv_clients';
		
		$results = $PDO->query($sql);
		
		$list_clients = $results->fetchAll(PDO::FETCH_ASSOC);
		
		foreach($list_clients as $client)
		{
			echo $client['client_firstname'];
		}
		
		echo '<pre>';
		print_r($list_clients);
		echo '</pre>';
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Et comment on va évidemment intégrer ça on va mettre encore une fois une petite concaténation avec du HTML. 

Et voilà ce qui est plus pratique et encore une fois c'est plus simple de parcourir avec un foreach().
```php
<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	$list_clients = $results->fetchAll(PDO::FETCH_ASSOC);
	
	foreach($list_clients as $client)
	{
		echo '<p>'.$client['client_firstname'].'</p>';
	}
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>
```
Voilà encore une fois foreach() est vraiment conçue pour ça. 

Autant utiliser quand on a plein d'enregistrement un petit fetchAll() et ensuite foreach() sur la variable sur le quel on a fait le fetchAll() et ainsi on va pouvoir tout parcourir à la volée.

Ce qui est vraiment prévu pour ça donc c'est vraiment optimisé pour ce genre de parcours là donc autant s'en servir plutôt que d'utiliser des choses qui seront beaucoup moins optimale au niveau ensuite de l'exécution de votre page, en tout cas du traitement de vos pages. 

Et là nous récupérons bien toutes les informations que nous avons voulu.
```txt
	http://localhost/PHP/cours/030_interroger_base_de_donn%c3%a9es/
	Jason

	Bamogo

	Emmanuel

	Coco

	Tic

	Tac
```
Et on va pouvoir parcourir tout à la volée, ce qui est vraiment conçu pour ça donc c'est optimisé pour ce genre de parcours là donc autant s'en servir plutôt que d'utiliser des choses qui seront moins optimales au niveau ensuite de l'exécution de votre page en tout cas du traitement de vos pages. 

Et là nous avons donc bien récupéré toutes les informations que nous voulions. 

Voilà c'est plus efficace de procéder comme ça. 

Un fetch() c'est çi vous n'avez qu'un seul enregistrement et si il y a des chances d'en avoir plusieurs, c'est mieux d'utiliser fetchAll() comme ça vous pourrez vous servir du foreach() sinon vous ne pourrez pas et vous serez obligé de passer par while ce qui n'est pas forcément le plus pratique par rapport à ça. 

Alors à ce niveau on avait pas mal de choses on a d'abord vu query(), on a vu fetch(), on a vu fetchAll() ce qui est déjà pas mal. 

Alors ce que je n'ai pas dit également lorsqu'on fait une requête SELECT puisqu'il y a en fait une espèce de curseur qui se positionne pour faire la sélection, il est important de fermer ce curseur pour pouvoir faire éventuellement une nouvelle requête.

En gros quand vous avez finis de faire votre requête lorsqu'on a finis de récupérer tout les clients `SELECT * FROM fv_clients`, on va pouvoir fermer ce curseur pour la suite d'accord.

Ce n'est pas obligatoire mais c'est quand même mieux de le faire pour pouvoir ensuite réffectuer des requêtes donc en gros quand on finis de travailler avec $results notamment ici avec fetchAll donc je peux le faire juste après là.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$sql = 'SELECT * FROM fv_clients';
		
		$results = $PDO->query($sql);
		
		$list_clients = $results->fetchAll(PDO::FETCH_ASSOC);
		
>
		
		foreach($list_clients as $client)
		{
			echo '<p>'.$client['client_firstname'].'</p>';
		}
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Ou vraiment tout à la fin si j'ai peur de ne pas le faire au bon moment. Voilà je fais simplement un `$results` de closeCursor() comme ceci, pareil avec un C majuscule.
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$sql = 'SELECT * FROM fv_clients';
		
		$results = $PDO->query($sql);
		
		$list_clients = $results->fetchAll(PDO::FETCH_ASSOC);
		
		foreach($list_clients as $client)
		{
			echo '<p>'.$client['client_firstname'].'</p>';
		}
		
>		$results->closeCursor();
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Voilà donc je peux le faire là ou plutôt au moment où je n'ai plus besoin d'utiliser le `$results`. 

Comme là j'ai tout récupéré le fetchAll() dans `$list_clients`, j'en ai déjà plus besoin avant la boucle foreach() donc je peux fermer le curseur à cet endroit là. 
```php
	require 'db-config.php';

	try
	{
		$options =
		[
			PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
			PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		];
		
		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
		$sql = 'SELECT * FROM fv_clients';
		$results = $PDO->query($sql);
		
		$list_clients = $results->fetchAll(PDO::FETCH_ASSOC);
>		$results->closeCursor();
		
		foreach($list_clients as $client)
		{
			echo '<p>'.$client['client_firstname'].'</p>';
		}
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Voilà ça c'était pour du SELECT. 

Si vous faites du SELECT, utilisez closeCursor() et si vous faites de l'insertion, suppression et cetera vous n'en aurez pas forcément besoin. 

Ca c'est des petites choses à savoir par rapport aux différents méthodes que vous pouvez utiliser avec l'interface de PDO ou en tout cas l'interface de PDO pour être plus exact. 

Voilà nous avons vu pas mal de choses et je vais vous noter rapidement ça c'est plus pour ceux qui aiment bien prendre des notes. Je le fais pas tout le temps parce que ça c'est bien sûr à vous de prendre des notes de votre côté et de vous débrouiller mais je vous montre rapidement tout ce qu'on a vu. 

Voilà nous avons vu query(), on a vu fetch() et on a vu fetchAll(). On a vu également setFetchMode(). On a vu closeCursor() et voilà. 
```php
	/*
		query()
		fetch() / fetchAll()
		setFetchMode()
		closeCursor()
	*/
```
Je crois que ce sont un petit peu toutes les méthodes que je vous ai montré, c'est aussi histoire de voir que je n'ai rien oublié de vous montrer sur cette vidéo.

Le fait de les avoir listé ici, au moins comme ça je suis sûr de ne rien avoir oublié et normalement on a fait le tour par rapport à ça. 

Alors pour la prochaine séance parce que bien sûr il y a encore pas mal d'autres choses à voir avec PDO, on va voir comment sécuriser une requête parce que vous allez voir que l'utilisation de query() tel qu'on l'a vu n'est pas forcément sécurisé quand on va avoir par exemple le fait de passer des informations données par l'utilisateur. 

Et comme vous savez que l'utilisateur il faut vérifier absolument toutes les informations qu'il donne, vous verrez qu'ici on va avoir une faille en termes de sécurité qui n'assure pas en fait la protection ou en tout cas la sécurité de nos données notamment des requêtes que l'on veut effectuer et du coup je vous montrerai un autre système qui permet de faire des requêtes sécurisé par rapport à ça. 

Et ainsi pouvoir interroger vos bases de données sans risque en fait par rapport à des requêtes verrolées, ce qu'on appelle en fait des injections SQL mais on en parlera de toute façon dans la prochaine vidéo. 

On va s'arrêter là pour cette séance, j'espère que ça vous a plu et s'il y a des questions n'hésitez pas parce que ça fait une vidéo pas très très longue mais on a quand même vu pas mal de choses d'un coup. 

Et encore une fois je vous dis qu'on va avoir d'autres choses en complément, qu'on va voir dans la prochaine séance notamment concernant les requêtes préparées qui vont permettre de sécuriser un peu mieux tout ça. 

Mais c'était bien en tout cas de commencer par ça et de voir cette première partie. 

Je vous dis à bientôt pour la prochaine vidéo sur ce cours PHP. 

Ciao