# [29. Introduction PDO](https://www.youtube.com/watch?v=ZXekAnqLwe0)
13-12-20

Bonjour à tous et bienvenue pour ce court numéro 29 en PHP. 

Nous allons attaquer un dernier chapitre et le dernier de ce cours avec l'introduction à PDO. 

Alors PDO c'est tout simplement une interface qui va nous permettre de travailler, de manipuler nos bases de données quel que soit le SGBD que vous utilisez. 

Alors je vais faire une petite parenthèse avant d'aborder la PDO avec d'autres moyens qui existaient ou qui existe même encore avec PHP pour pouvoir travailler sur des bases de données SQL. 

Vous avez peut-être pour certains si vous avez déjà utilisé PHP et manipuler des bases de données, utilisé mysql_connect alors ça c'est le genre de fonction qui est absolument obsolète aujourd'hui mais qui de toute façon ne marche plus avec PHP 7 ça a été complètement supprimé et qui est obsolète depuis PHP 5.5.

	https://www.php.net/manual/fr/function.mysql-connect.php

Je vous le déconseille donc évidemment et de toute façon vous êtes censé être au minimum sur PHP 7. 

Je vous déconseille ainsi d'utiliser ce genre de fonctions, tout ce qui est mysql_connect, mysql_ et cetera. 
```txt
	Fonctions MySQL
	mysql_​affected_​rows
	mysql_​client_​encoding
	mysql_​close
	mysql_​connect
	mysql_​create_​db
	mysql_​data_​seek
	mysql_​db_​name
	mysql_​db_​query
	mysql_​drop_​db
	mysql_​errno
	...
```
Alors toutes ces fonctions là ne sont absolument plus utilisé en PHP pour manipuler tout simplement ou en tout cas interroger une base de données SQL. 

Si maintenant vous voulez rester exclusivement sur de la base de données MySQL et j'insiste bien sur le système MySQL et qu'il travaillait avec quelque chose qui ressemblait avec ses anciennes fonctions devenues obsolète, vous avez l'équivalent qui fonctionne avec le paradigme objet qui est "mysqli". 
```php
	mysqli_connect()
```
C'est donc tout simplement les mêmes fonctions mais en rajoutant un i avant le underscore donc par exemple pour mysql_connect() qui est obsolète nous avons son équivalent objet qui est mysqli_connect() et ça vous pouvez parfaitement l'utiliser même avec PHP 7. Il n'y a aucun problème. 

Alors moi je ne le aborderais pas sur le cours parce que je ne peux pas tout aborder en ce qui concerne tous les moyens qui existent pour manipuler les bases de données puis ce n'est pas forcément celui qui m'intéresse le plus pour le coup mais pour MySQL vous pouvez sans problème utiliser "mysqli" et la doc de PHP est de toute façon suffisamment fournie pour vous donner tout le détail de comment se connecter, comment faire des requêtes et cetera. 

Nous nous allons du coup utiliser l'objet ou en tout cas l'interface PDO c'est-à-dire que c'est une interface qui apporte une couche d'abstraction. 

Là où mysqli va fonctionner que pour un système MySQL, PDO va pouvoir interroger une base de données MySQL, PostgreSQL, MS Server, Oracle … Voilà n'importe quel type de base de données comme ça sans se soucier de ce qu'il y a en fait dessous c'est-à-dire que vous allez utiliser exactement les mêmes méthodes en PHP via l'interface PDO pour interroger n'importe quel SGBD. 

C'est pour ça que j'ai choisi celui-là pour le cours PHP parce qu'on n'a pas mal de choses à voir et c'est le plus intéressant dans ce cas de figure. 

Voilà pour ça. 

Regardons un petit peu Comment ça va fonctionner. 

Alors on dit PDO de pour PHP Data Object pour ceux qui se poseraient la question déjà on va tout préparer au niveau de l'introduction de cette interface là pour cette séance, et par la suite on verra comment utiliser quelques méthodes liées justement à cette interface PDO. 

Pour suivre ce nouveau et dernier chapitre sur ce cours PHP, je vous invite obligatoirement en tout cas c'est un prérequis, à avoir vu au minimum les 5 premières séances de mon cours SQL parce que tout ce qui est lié à SQL, je ne vais évidemment pas revenir là-dessus.

Vous êtes censé le connaître et vous avez besoin au moins des 5 premières vidéos du cours SQL de la chaîne pour pouvoir suivre convenablement ce nouveau chapitre et en tout cas ce dernier chapitre PHP concernant justement les bases de données. 

Alors nous on y va parce qu'on a pas mal de choses à voir et qu'est-ce qu'on va faire ? On va déjà essayer de se connecter avec l'interface PDO. 

Et on va voir déjà un petit peu si on arrive déjà à se connecter et sinon est-ce qu'il n'y a pas des choses à corriger.

Je vais faire ça en vidéo comme ça on verra un petit peu ce qui ne va pas éventuellement et pouvoir tout configurer. 

L'avantage du cours que je vous avais proposé comme vous l'avez bien vu dans les vidéos précédentes, ce que nous avons tout installé à la main manuellement chaque outil séparément donc on va pouvoir véritablement garder le contrôle et la main sur tout ce que nous avons et au moindre problème on sera comment le résoudre et qu'est-ce qui permet d'activer toutes les options nécessaires. 

Rappelez-vous sur la vidéo précédente on avait parlé des exceptions pour pouvoir gérer en tout cas et convenablement nos erreurs ici en PHP. 

Eh bien on va utiliser un petit peu ce système là puisque une connexion à une base de données n'est pas assurée c'est-à-dire qu'on va essayer de se connecter à la base de données et si jamais ça n'a pas fonctionné on aimerait avoir une erreur, on aimerait qu'on nous retourne une erreur pour savoir quoi faire. 

On va donc utiliser le fameux bloc try catch et ça c'est quelque chose qu'on a vu récemment et pour PDO nous avons un type d'exception particulier qui héritent des exceptions générales qui est PDOException et on peut donner un nom de variable `$pe` par exemple mais vous mettez le nom de la variable que vous voulez évidemment et on pourra comme ça travailler là-dessus.
```php
	try
	{
		
	}
	catch(PDOException $pe)
	{
		
	}
```
Comme PDOException est une classe spécialisée de Exception, évidemment elle hérite de toutes les méthodes de Exception donc je peux sans problème faire un 'ERREUR : ' comme ceci et de faire un $pre->… pour utiliser la méthode getMessage(). 
```php
	try
	{
		
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Comme ça s'il y a une exception qui est levée donc une erreur qui survient, on aura le message affiché et on pourra du coup travailler dessus. 

Alors au niveau de la connexion comment est-ce que ça va se passer ? On va instancier c'est à dire que pdo possède un constructeur et nous allons créer une instance de pdo pour obtenir un objet pdo sur lequel nous allons pouvoir travailler par la suite. 

Je vais donc appeler ma variable `$PDO`, je veux rester très simple au niveau du nom comme ça je serai automatiquement que c'est mon instance et ensuite je mets new PDO() comme ceci pour instancier cet objet-là, en tout cas cette classe.
```php
	try
	{
		$PDO = new PDO();
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Au niveau des paramètres on va en avoir plusieurs, on va avoir un paramètre qui va spécifier le moteur à utiliser, en l'occurrence même le driver donc le pilote de base de données à utiliser : MySQL, Oracle, PostgreSQL, SQLite et cetera. 

Et des informations comme l'identifiant donc l'utilisateur et le mot de passe sql avec lequel nous allons nous connecter. 

Alors je vous déconseille de mettre toutes ces informations là directement en dur `''` dans `PDO('', '', '')`  parce que ça va être sous forme de 3 chaînes en fait. Une pour toutes les informations liées aux drivers et à la base de données. Une pour le user et le password tout simplement parce que c'est déjà pas très propre de mettre ces informations là en dur et ça risque de mélanger un petit peu tout. 

Au minimum ce que vous pouvez vous amuser à faire, vous pouvez mettre ces informations là en dehors c'est-à-dire qu'on va faire par exemple un `$DB_DSN` je vous expliquerai pourquoi j'appelle ça comme ça parce que c'est un nom plus pratique pour moi. On va avoir un `$DB_USER` et on aura un `$DB_PASSWORD`. 
```php
	$DB_DSN = '';
	$DB_USER = '';
	$DB_PASS = '';
	
	try
	{
		$PDO = new PDO();
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Voilà et le mieux aussi, et ça ça arrivera surtout quand vous travaillerez sur des projets plus concrets, c'est même de sortir ces éléments parce que ce sont des éléments de configuration dans un fichier à part. 

Moi je préférerais faire carrément un require et d'avoir un  'db-config.php' admettons comme ça et qui va demander, exiger, qui requiert obligatoirement ce fichier là dans lequel on aura éventuellement ces infos pour se connecter à la base de données.
```php
	require 'db-config.php';
	
	try
	{
		$PDO = new PDO();
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Ensuite je vais créer un nouveau fichier db-config.php voilà et je passe les paramètres.

+ db-config.php
```php	
	<?php
	$DB_DSN = '';
	$DB_USER = '';
	$DB_PASS = '';
```
Alors vous pouvez utiliser des variables comme ça, vous pouvez passer par un tableau associatif. 

Vous pouvez même carrément faire des constantes avec un define(); voilà c'est vous qui voyez.

+ db-config.php
```php	
	<?php
	$DB_DSN = '';
	$DB_USER = '';
	$DB_PASS = '';
	
	define();
```
Je ne vous impose rien du tout, vous voyez en fonction et vous savez de toute façon comment faire donc vous pouvez gérer par rapport à ça. 

Vous voyez en fonction et vous savez de toute manière comment faire donc vous pouvez gérer par rapport à ça. 

En gros ces informations là, on va déjà remplir ici et comme vous le savez il fallait déjà avoir vu le cours sql donc normalement vous avez une base de données MySQL qui est prête puisque nous allons travailler sur MySQL en l'occurrence ici on ne va pas travailler sur Oracle parce que je n'ai pas Oracle sur mon PC donc on travaillera sur MySQL. 

Pour ceux qui avaient vu, et c'est un prérequis, les vidéos sur le cours SQL. Moi j'avais un USER qui s'appelle 'root' ensuite je n'avais pas de mot de passe parce que j'étais en local donc pas besoin de mot de passe ''. 

+ db-config.php
```php
	<?php
	$DB_DSN = '';
	$DB_USER = 'root';
	$DB_PASS = '';
```
Vous évidemment vous remplissez avec les informations qui correspondent à votre configuration. 

Et le DSN justement a un format un peu particulier.

Alors pour DSN, en premier on va lui passer le driver à utiliser. 

Comme on a dit qu'on allait travailler sur mysql, je le mets directement ici suivi de : et attention pas d'espace et cetera sinon vous aurez des erreurs pour ça que je dis que c'est très important le format à respecter et ensuite 2 informations. La première qui est très importante c'est l'ôte sur lequel se connecter donc ça c'est obligatoire donc nous ce sera host=localhost parce qu'on est en local sinon ce serait un nom de domaine, une adresse IP ou autre chose. Et pour éviter de devoir spécifier manuellement sur quelle base de données on va se connecter, on va mettre la suite qu'on va se connecter sur une base en particulier donc je mets un ; dbname= et là pour ceux qui ont vu de toute manière le cours sql, j'avais fait une base de données qui s'appelait fv_database.

+ db-config.php
```php
	<?php
	$DB_DSN = 'mysql:host=localhost;dbname=fv_database';
	$DB_USER = 'root';
	$DB_PASS = '';
```
Pareil vous éditez en fonction.

Vous pouvez très bien démarrer votre client en MySQL, vous créez une base de données avec le nom que vous voulez comme ça vous pourrez directement vous connecter dessus pour faire des tests et des requêtes par la suite.

Voilà les 3 informations dont nous avions besoin. 

Du coup c'est beaucoup plus pratique parce que comme j'ai directement inclus mon fichier. Ainsi je n'ai plus qu'à appeler ces 3 informations en séparant par des virgules. 

+ index.php
```php
	<?php
>	require 'db-config.php';

	try
	{
>		$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS);
	}
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Déjà ça évite de faire des erreurs parce qu'on aurait déjà eu toute cette chaîne là `'mysql:host=localhost;dbname=fv_database'` à donner en premier paramètre.

Et comme vous voyez qu'il y a plein de deux-points, de virgule puis ensuite des paramètres, c'est un coup à se trompait et en plus ça mélange les informations de connexion donc de configuration avec directement à l'instance. 

Alors comme ça c'est beaucoup plus propre, comme ça le jour où vous modifier ces informations là tout est dans le fichier de config et en plus ça permet de sécuriser un peu plus plutôt que de tout avoir dans index.php donc on garde bien sa part et ce qui est beaucoup plus pratique. 

Voilà pour ça et ensuite je peux simplement en faire un `'Connexion &eacute;tablie !'`. eacute Pour afficher les actions parce que je n'ai pas du tout de code HTML. On mettra ainsi un petit message comme ça, connexion établie !
```php
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
En gros si on arrive sur ce echo et que le message s'affiche c'est que la connexion a réussi. 

Sinon une exception va être lever par le instanciation ici, new PDO(), le constructeur.
```php
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS);
```
Ça va nous renvoyer dans le catch() parce qu'on va capturer l'exception dans `$pe` qui sera éventuellement noté ' PDEException' et on affichera du coup l'erreur qui survient.
```php
	catch(PDOException $pe)
	{
		echo 'ERREUR : '.$pe->getMessage();
	}
```
Voilà comme ça on a toute l'information qui va. 

Alors moi je vais démarrer notre serveur Apache.
```powershell
	C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\apache\bin\httpd.exe
```
On démarre le serveur, on réduit seulement la page parce qu'on doit laisser tourner. 

On va laisser ça comme ça et ensuite on va dans notre sous-dossier localhost sur le navigateur.
```txt
	http://localhost/PHP/cours/029_introductionPDO/
	ERREUR : could not find driver
```
Normalement j'arrive sur cette page qui nous met ERREUR: could not find driver.

On a donc un premier problème et ça tombe bien on va justement voir pourquoi. 

Rappelez-vous au niveau du cours nous avons installé notre serveur Apache, serveur web pas de souci. 

On a installé l'interpréteur PHP, on a configuré tout ça pour que ça fonctionne ensemble. 

Et sur le cours SQL nous avons installé MySQL. On a configuré rappelez vous la création du répertoire data. On s'est arrangé pour avoir un utilisateur sur lequel on pouvait se connecter donc en l'occurrence l'utilisateur root même si on a vu dans des vidéos comment créer de nouveaux utilisateurs donc c'est au-delà de la séance 5 en SQL d'ailleurs. 

Enfin bref nous avons vu tout ce qu'il fallait par rapport à ça. 

Et c'est grosso modo nous ne trouvons pas le driver donc en l'occurrence le driver MySQL pour se connecter donc ça c'est un premier problème que nous avons. 

Alors ce qu'on va faire déjà, c'est faire un phpinfo() et je vais exit directement pour ne pas lancer le reste de l'exécution de la page, pour voir un petit peu si mon driver est chargé ou en tout cas qu'est-ce que j'ai comme information. 

J'actualise ma page.
```php
<?php

require 'db-config.php';

phpinfo();
exit;

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
```txt
	http://localhost/PHP/cours/029_introductionPDO/
	PHP Version 7.4.7
	...
```
Je suis donc à jour. 

Alors un autre petit conseil c'est que si vous avez une nouvelle version de PHP n'hésitez pas à la mettre à jour d'ailleurs vous avez ma playlist PHP tutoriel où j'ai fait une vidéo justement pour mettre à jour PHP donc n'hésitez pas à aller voir si vous voulez pour être sur la version la plus récente possible que vous pouvez avoir pour ne pas avoir de problème et surtout pour avoir de nouvelles fonctionnalités. 

Surtout que PHP 7 permettre d'avoir de gros gros gains en performance, en vitesse d'exécution. 

Voilà ils se sont vraiment bien rattrapé avec la version 7 de PHP par rapport à la version 5. 

Il faut vraiment profiter de tout ça donc n'hésitez pas à mettre à jour PHP. 

Moi il est mis à jour comme j'avais fait ma vidéo de mise à jour avant, j'ai pu le mettre à jour récemment donc pas de problème. 

Alors je vais descendre dans mes infos et je vais chercher du coup pdo parce que ça c'est ce qui m'intéresse en fait. 

Voilà la partie pdo et je regarde dans les drivers.
```txt
	http://localhost/PHP/cours/029_introductionPDO/
	PHP Version 7.4.7
	...
	PDO
	PDO support				enabled
	PDO drivers				no value
```
Je regarde dans les drivers et je vois qu'il y a no value donc déjà là il y a un problème parce que je n'ai aucun driver d'activé ce qui explique pourquoi j'ai cette fameuse erreur Not find drivers. 

Alors on va voir pour activer ce driver donc déjà avec notre installation qu'on a fait précédemment, pdo n'est pas activé par défaut. 

Alors je vous rassure sur les versions de PHP actuelle, il est déjà installé d'accord il y a tous les fichiers qui sont présents et le meilleur moyen de s'en assurer c'est d'aller dans :
```txt
	C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\php\ext
```
Et de vérifier, voilà de trouver des fichiers PDO qui sont ici.
```txt
	php_pdo_firebird.dll
	php_pdo_mysql.dll
	php_pdo_oci.dll
	php_pdo_odbc.dll
	php_pdo_pgsql.dll
	php_pdo_sqlite.dll
```
Voilà php_pdo et notamment php_pdo_mysql, vous en avez pour chaque Firebird, ODBC, PostgreSQL, SQLite et cetera. 

On a même pour Oracle. 

On a tout ce qu'il nous faut même php_mysqli.dll que vous pouvez trouver. 

Si vous voulez utiliser mysqli c'est cette extension là qui va être utilisée. 

On veut donc MySQL qui est bien présent php_pdo_mysql.dll donc pas de problème. 

Maintenant il n'a pas l'air d'être activé.

Comme ça concerne PHP donc on va aller dans php.ini qui je rappelle est dans Apache.
```txt
	C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\apache\php.ini
```
Et ici nous allons chercher l'extension, je vais cherché pdo_mysql c'est comme ça que ça s'appelle. Et on voit que toutes les extensions sont commentées donc en fait elles sont désactivées par défaut ce qui est logique parce qu'on ne va pas activer tous les drivers en même temps sinon ça va tout charger alors qu'on n'a pas besoin d'utiliser tout donc c'est pour ça que par défaut ce n'était pas activé donc on active que ce qu'on a besoin. 

Si vous voulez utiliser mysqli, vous allez décommenter cette ligne.
```ini
	;extension=mysqli
```
Mais nous comme on travaille sur MySQL, on va décommenter cette ligne.
```ini
	+-------------------------------+
	| extension=pdo_mysql			|
	+-------------------------------+
```
Donc là l'extension est activée. 

On va relancer le serveur parce que comme on a modifié le php.ini, il faut quitter le serveur Apache donc il faut bien y penser à chaque modification. 
```powershell
	C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\apache\bin\httpd.exe
```
On relance et une fois que c'est relancer on va réactualiser et on regarde s'il y a mieux. Est-ce qu'il a trouvé le driver ?
```txt
	http://localhost/PHP/cours/029_introductionPDO/
	PHP Version 7.4.7
	...
	PDO
	PDO support				enabled
	PDO drivers				no value
```
Est-ce qu'il a trouvé le driver ? non. 

Alors là et ça vous ne pouviez pas le deviner, il fallait peut-être voir un petit peu par rapport à ça. 

Le driver a bien été activé, il est bien présent dans mes fichiers et je pense que c'est un problème d'accès aux extensions. 

Ce qu'on va donc faire au niveau du php.ini, on va cherché ce qui permet d'accéder à ce fameux répertoire.
```txt
	C:\MyWAMP\php\ext
```
On doit pouvoir accéder à ce fichier php_pdo_mysql.dll donc apparemment ma configuration de PHP n'arrive pas à accéder à ce répertoire et donc à ce fichier. 

Ainsi vous cherchez la ligne extension_dir et normalement vous avez... pas pour SQLite 3, on s'en fiche mais on a ligne 757.
```ini
	; Directory in which the loadable extensions (modules) reside.
	; http://php.net/extension-dir
	;extension_dir = "./"
	; On windows:
>	;extension_dir = "ext"
```
On a cette ligne là où il nous dit quel est le répertoire pour charger les extensions, les modules, et vous indiquent pour Windows, il faut décommenter ça.
```ini
	extension_dir = "ext"
```
On va donc décommenter cette ligne.
```ini
	+-------------------------------+
	| extension=pdo_mysql			|
	| extension_dir = "ext"			|
	+-------------------------------+
```
Je vais couper mon serveur encore une fois. 

Je le relance. 

Je vais réactualiser ma page et on n'a pas encore le problème qui est résolu encore une fois.

Il y a donc ici un souci de chemin apparemment par rapport à ça. 

Il n'arrive pas à trouver "ext" et C'est d'ailleurs un souci qu'on a vu sur d'autres chemins, je vous avais même dit pour ne pas avoir de problème de mettre le chemin en absolu parce que un chemin comme ça relatif c'est un petit peu galère. 

Alors pourquoi est-ce que c'est galère, tout simplement parce que mon php.ini, mon fichier de configuration PHP par habitude je le mets dans apache, il n'est pas mis dans PHP. 

S'il était dans MyWAMP/php/ je pense que le chemin aurait marché parce qu'en partant de la racine, il accède directement au répertoire ext et là du coup ça ne va pas. 

Pour éviter de revenir dans des répertoires précédents, pour ne pas s'embêter, puisque moi je garde toujours cette configuration en mettant toujours mon fichier php.ini dans MyWAMP/apache/.

Je vais simplement récupérer tout le chemin en absolu de ext comme ça pas de problème.
```ini
	extension_dir = "C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\php\ext"
```
On fait ça. 

Je rappelle que pour les fichiers de config même sur Windows, ce sont des slashs et pas des antislashs et là comme ça je suis sûr que le chemin sera bon.
```ini
	+-----------------------------------------------------------------------------------+
	| extension=pdo_mysql																|
	| extension_dir = "C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/php/ext"	|
	+-----------------------------------------------------------------------------------+
```
Et là comme ça je suis sûr que le chemin sera bon, ça c'est obligatoire et celui-là il fonctionnera sans problème. 

On y retourne et on fait tout bien par étape. La vidéo sera un peu longue mais comme ça on aura vraiment toutes les étapes pour être sûr de configurer tout comme il faut. 

On redémarre le serveur et logiquement ça devrait être bon, j'actualise le driver MySQL a bien été reconnu et est bien activée.
```txt
	C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\apache\bin\httpd.exe
	
	http://localhost/PHP/cours/029_introductionPDO/
	...
	PDO
	PDO support	enabled
	PDO drivers	mysql
	...
```
Ça c'est bon, au moins pas de problème à ce niveau-là. 

Alors on vire phpinfo() et maintenant on s'attend à être connecté.
```php
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
Et maintenant on s'attend à être connecté. 

Maintenant que tout est connecté que le driver est bon donc il peut utiliser pdo_mysql. 

Voilà on charge la page. 
```txt
	http://localhost/PHP/cours/029_introductionPDO/
	ERREUR : SQLSTATE[HY000] [2002] Aucune connexion n’a pu être établie car l’ordinateur cible l’a expressément refusée.
```
Voilà on charge la page et là il nous met qu'aucune connexion n'a pu être établie car l'ordinateur cible l'a expressément refusée donc c'est parfaitement logique et je pense que beaucoup l'aurons compris d'où vient cette erreur. 

On a simplement démarrer notre serveur apache, notre serveur web mais est-ce qu'on a démarré notre serveur MySQL pas du tout. 

Donc évidemment on démarre notre serveur MySQL, c'est comme pour accéder avec le client MySQL parce que si on ne démarre pas notre serveur on ne pourra pas se connecter dessus. 

Si on ne peut pas accéder nous, PHP ne va pas pouvoir y accéder pour autant. 

Donc c'est dans mysql\bin\.

Toujours pareil et je rappelle que c'est comme dans le cours MySQL, on utilise cette commande.
```powershell
	serveur
	-------
	
	cd C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\mysql\bin
	
	>mysqld --console
	2020-12-21T11:00:04.538511Z 0 [System] [MY-010116] [Server] C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\mysql\bin\mysqld.exe (mysqld 8.0.22) starting as process 10148
	2020-12-21T11:00:04.614686Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
	2020-12-21T11:00:05.682709Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
	2020-12-21T11:00:05.904001Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060
	2020-12-21T11:00:06.177924Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
	2020-12-21T11:00:06.178349Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
	2020-12-21T11:00:06.251509Z 0 [System] [MY-010931] [Server] C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\mysql\bin\mysqld.exe: ready for connections. Version: '8.0.22'  socket: ''  port: 3306  MySQL Community Server - GPL.

	client
	------
	
	> mysql -u root -p
	Enter password:
	Welcome to the MySQL monitor.  Commands end with ; or \g.
	Your MySQL connection id is 12
	Server version: 8.0.22 MySQL Community Server - GPL

	Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

	Oracle is a registered trademark of Oracle Corporation and/or its
	affiliates. Other names may be trademarks of their respective
	owners.

	Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

	mysql> CREATE DATABASE `fv_database`;
	Query OK, 1 row affected (0.01 sec)

	mysql> SHOW DATABASES;
	+--------------------+
	| Database           |
	+--------------------+
	| cours_sql          |
	| fv_database        |
	| information_schema |
	| mysql              |
	| performance_schema |
	| sys                |
	+--------------------+
	6 rows in set (0.01 sec)
```

Et on démarre notre serveur, on attend un petit peu. Une fois qu'il y a le socket, port 3306 qui est marqué et cetera, c'est bon. 

Moi je rappelle que je suis sur MySQL version 8 donc une des plus récentes. 

Ensuite on actualise la page et là la connexion est établie.
```txt
	http://localhost/PHP/cours/029_introductionPDO/
	Connexion établie !
```
Connexion établie ! donc la connexion est réussie, alors il y a de fortes chances que parmi vous certains ait un problème d'authentification que ça vous mette Requested authentification unknown et cetera, enfin bref vous aurez un message d'erreur qui vous indique que l'authentification a échoué et que du coup vous ne pouvez pas vous connecter. 

Alors cela provient des utilisateurs et surtout si comme moi vous utilisez la version de MySQL 8 c'est-à-dire que pour la version MySQL 5, vous ne devriez pas avoir de problème par contre avec la version 8 ils ont changé un petit peu les méthodes d'authentification. 

Ils ont rendu un petit peu plus sécurisé l'authentification de l'utilisateur et comme ce n'est pas encore compatible avec les versions PHP actuelles en tout cas moi avec la version récente, ça n'avait pas l'air de bien fonctionner donc je suis repassé en fait vers le système d'authentification natif de MySQL et pour faire ça ? C'est très simple donc là le serveur MySQL est démarrer et on va juste aller sur une autre console et je vais me connecter au client cette fois-ci.
```powershell
	cd C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\mysql\bin

	> mysql -u root -p
	Enter password:
	Welcome to the MySQL monitor.  Commands end with ; or \g.
	Your MySQL connection id is 14
	Server version: 8.0.22 MySQL Community Server - GPL

	Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

	Oracle is a registered trademark of Oracle Corporation and/or its
	affiliates. Other names may be trademarks of their respective
	owners.

	Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

	mysql>
```
Voilà donc mon utilisateur root je précise qui n'a pas de mot de passe voilà et une fois que je suis connecté là. 

Je rappelle comme d'habitude pour ceux qui viennent du cours SQL, je l'ai bien ma fv_database qui est là.
```sql
	mysql> show databases;
	+--------------------+
	| Database           |
	+--------------------+
	| cours_sql          |
	| fv_database        |
	| information_schema |
	| mysql              |
	| performance_schema |
	| sys                |
	+--------------------+
	6 rows in set (0.00 sec)
```
Et là je vais tout simplement faire cette commande là que je n'ai pas besoin de refaire parce que je l'ai déjà fait et que ça fonctionne déjà mais vous vous aurez besoin de faire ça. 

Vous aurez besoin de faire `ALTER USER` donc on va altérer la table des utilisateurs, ensuite l'utilisateur en question entre quote et donc moi c'est `'root'@`, voilà avec notre `@` qui est en dehors des doubles quotes donc faites attention à ne pas vous tromper dans l'écriture et ensuite vous écrivez `'root'@'localhost'` donc ça c'est l'hôte, c'est l'hôte local et ensuite on va simplement faire IDENTIFIED WITH donc attention au niveau de l'écriture et ce qu'il va falloir faire ce n'est pas un BY mais un WITH parce que BY c'était la version par défaut et terminer par `mysql_native_password by '';` Et ensuite entre code vous mettez le mot de passe que vous voulez et moi comme je n'ai pas de mot de passe je laisse vide, une chaîne vide mais vous pouvez mettre un mot de passe à l'intérieur il n'y a pas de problème.
```php
	/*
		alter user 'root'@'localhost' identified with mysql_native_password by '';
	*/
```
```sql
	mysql> alter user 'root'@'localhost' identified with mysql_native_password by '';
	Query OK, 0 rows affected (0.01 sec)
```
Voilà moi je fais ça, il suffit juste de faire ça et ça change ici la méthode d'authentification de l'utilisateur. 

On peut quitter le client à partir de là et normalement ça doit être pris en compte tout de suite.
```sql
	mysql> exit
	Bye
```
Sinon redémarrez au pire le serveur MySQL si ce n'est pas pris en compte mais logiquement ça devrait être bon, et après vous aurez du coup comme moi la connexion qui est établie donc ça devrait être bon. 

Logiquement vous ne devriez pas avoir d'erreur donc ça devait être la seule erreur. 

Ça c'est encore une fois parce que MySQL 8 a changé beaucoup de choses dans l'authentification des utilisateurs et PHP a du coup besoin de se mettre à jour par rapport à ça et ce n'est pas toujours forcément le cas. 

D'ailleurs comment est-ce que j'ai corrigé l'erreur parce que je l'ai évidemment pas deviné comme ça au départ, j'ai eu le fameux message d'erreur que l'on va retrouver et en cherchant avec ce message dans le navigateur, j'ai écrit PDO MySQL PHP et je suis allé voir sur la doc.

https://www.bing.com/search?q=PDO+MySQL+PHP
https://www.php.net/manual/fr/ref.pdo-mysql.php

Voilà et j'ai du coup retrouvé le message que j'avais rencontré, c'est pas tout à fait le même mais vous devriez avoir un gros ce genre de messages.
```txt
	The server requested authentication method unknown to the client
```
Alors moi j'avais eu ce message là et en cherchant du coup PDO MySQL sur la doc, je suis tombé là-dessus, et on vous dit en gros que si vous avez une version trop ancienne de PHP, même de PHP 7, Eh bien il va falloir passer le plug-in avec le mode natif. 

On vous dit que de toute façon la nouvelle méthode d'authentification de MySQL, caching_sha2_password pour MySQL 8 sera supporté dans une version future de PHP. 

Après là ils disent que apparemment au-dessus de la version 7.2.4 et plus, ça marchait mais moi je suis en 7.3.4 et ça n'avait pas l'air de marcher pour autant donc du coup j'ai fait la petite commande SQL que je vous ai montré tout à l'heure et ça marchait sans problème. 

Après éventuellement une autre chose que l'on peut rajouter surtout pour les prochains utilisateurs que vous allez créer. 

Si vous voulez dans MyWAMP\mysql\my.ini soit le fichier de configuration qu'on avait fait pour MySQL.
	
+ my.ini
```ini
	[mysqld]
	basedir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql
	datadir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql/data
	character-set-server = utf8mb4
	collation-server = utf8mb4_unicode_ci

	[mysql]
	default-character-set = utf8mb4

	[client]
	default-character-set = utf8mb4
```
Alors vous allez pouvoir ajouter, il s'agit de la fameuse ligne qui était donnée dans la doc.
```powershell
	https://www.php.net/manual/fr/ref.pdo-mysql.php
	...
	Ceci est dû au fait que MySQL 8 utilise par défaut caching_sha2_password, un plugin qui n'est pas reconnu par les anciennes versions de PHP (mysqlnd). À la place il faut modifier le paramètre default_authentication_plugin=mysql_native_password dans my.cnf. Le plugin caching_sha2_password sera surporté dans une version future de PHP.
	...
```
Voilà elle est ici, cette ligne là : `default_authentication_plugin=mysql_native_password`

Pour que par défaut le plug-in d'authentification utilisé soit la version native. 

Pareil des fois ça fonctionne et des fois ça ne passe pas très bien comme paramètre.

+ my.ini
```ini
	[mysqld]
	basedir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql
	datadir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql/data
	character-set-server = utf8mb4
	collation-server = utf8mb4_unicode_ci
>	default_authentication_plugin = mysql_native_password

	[mysql]
	default-character-set = utf8mb4

	[client]
	default-character-set = utf8mb4
```
Voilà ça ce n'est pas sûr que ça résolve tout seul les problèmes mais vous pouvez toujours le rajouter ça ne fait pas de mal par rapport à ça mais sinon avec la requête ALTER USER que je vous ai montré normalement ça change l'authentification de votre utilisateur donc moi en l'occurrence root Et ça corrigera le problème justement, cette fameuse erreur :
```txt
	The server requested authentication method unknown to the client
```
Et si ce n'est toujours pas résolu n'hésitez pas en commentaire de la vidéo, à me le dire si vous avez encore des problèmes pour vous connecter malgré tous les changements qui ont été faits. 

Logiquement si vous avez une version de PHP suffisamment récente donc essayer de mettre la plus récente possible tant qu'à faire. 

Si vous avez bien fait la commande SQL que je vous ai montré pour changer la méthode d'authentification de l'utilisateur, et que vous avez bien modifié votre php.ini au niveau du chemin pour activer l'extension pdo_mysql, logiquement tout le monde devrait arriver à Connexion établie ! 

Voilà il ne devrait pas y avoir de problème.
```ini
	+-----------------------------------------------------------------------------------+
	| extension=pdo_mysql																|
	| extension_dir = "C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/php/ext"	|
	+-----------------------------------------------------------------------------------+
```
Voilà je pense qu'on a fait le tour donc je vais couper mon serveur MySQL donc on va faire ça.
```powershell
	client
	------
	
	mysql> exit
	Bye
	
	PS C:\Users\sam> mysqladmin -u root -p shutdown
	Enter password:
```
Voilà histoire de quitter le serveur proprement et on va quitter également le serveur Apache [x]. 

Et voilà on a vu comment faire l'introduction par rapport à PDO, alors je viens de voir que je n'aurais peut-être pas dû tout quitter maintenant parce que j'avais d'autres choses à vous montrer. 

Je viens de penser à quelque chose qui aurait pu être intéressant à vous montrer mais on verra ça pour la vidéo prochaine, ce n'est pas grave comment on va commencer de toute façon à faire des requêtes pour interroger une base de données.

On verra au niveau des paramètres pour la prochaine fois ce n'est pas bien grave alors que la vidéo était déjà pas mal longue.

Au moins si vous êtes déjà bien connecté à votre base de données déjà c'est pas mal, vous avez tout qui y est prêt pour la suite. 

Voilà j'espère que cette vidéo vous a plu.

Pour la prochaine séance de PHP, on verra comment interroger du coup notre base de données et on verra comment spécifier un petit peu des options un peu particulière pour la connexion à PDO pour avoir des paramètres qui vont bien par rapport à l'utilisation que nous en aurons. 

Et après on verra comment faire des requêtes tout simplement, à utiliser tout ce que vous avez vu en SQL, tous les types de requêtes que vous avez appris sur le cours SQL que vous allez pouvoir du coup utiliser en appelant des méthodes de PDO en PHP. 

Je vous dis à bientôt pour la prochaine séance sur formation vidéo.

Ciao tout le monde