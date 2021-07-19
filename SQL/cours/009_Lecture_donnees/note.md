# [9. Lecture données](https://www.youtube.com/watch?v=QfN_URkzw94)
29-12-20

[data1.sql](data1.sql)

Bonjour à tous, bienvenue sur cette formation sql pour notre neuvième vidéo.

On va enfin entrer dans la partie pratique de ce cours comme je l'avais dit précédemment.

On a fait toute une introduction qui n'était pas forcément la plus intéressante mais très importantes sur les moteurs de stockage, sur les système d'encodage, la configuration de votre de votre environnement en fait de votre serveur et la gestion des utilisateurs pour pouvoir ensuite être plus serein sur tout ce qui est apprentissage et découvertes un petit peu des différentes commandes et requêtes que vous allez pouvoir utiliser avec le langage sql.

Alors on va commencer tout doucement au débat avec la lecture de données et pour ça je vous propose dans la description de la vidéo de télécharger un script que nous allons importer.

Un script qui sera complétée au fur et à mesure suivant les vidéos s'il y a besoin de le modifier ou d'ajouter des choses et sur lequel vous allez travailler pour exécuter un petit peu les commandes que nous allons aborder sur les vidéos du cours.

Alors vous avez dans la description, la possibilité de récupérer ce fichier là d'accord qui s'appelle data1.sql puisque c'est le premier fichier sql que nous utilisons dans ce cours donc il y aura un data2 dans une autre séance si on a besoin également de travailler sur une autre base, si on doit la modifier ou avoir plus de choses etc etc.

Alors on va déjà se connecter sur mysql donc le serveur logiquement est lancé, c'est bon donc je rappelle à la commande pour lancer le serveur mysqld --console d'accord. Ensuite moi je suis en root pas de mots de passe et voilà je suis connecté.
```powershell
	>mysqld --console
	> mysql -u root -p
	Enter password:

	mysql>
```
A partir de là, on va importer notre fichier on va charger en fait notre script d'accord qui est un script sql qui va faire tout un tas de commandes.

Ce script, je vous montre rapidement.

+ sql_data1.sql
```sql
	DROP TABLE IF EXISTS `fv_users`;
	DROP TABLE IF EXISTS `fv_products`;
	DROP DATABASE IF EXISTS `fv_database`;
	CREATE DATABASE IF NOT EXISTS `fv_database`;
	USE `fv_database`;

	CREATE TABLE IF NOT EXISTS `fv_users`
	(
		`id_user` INT NOT NULL AUTO_INCREMENT, 
		`user_firstname` VARCHAR(65) NOT NULL, 
		`user_lastname` VARCHAR(65) NOT NULL, 
		`user_birthdate` DATE NOT NULL, 
		`user_tel` CHAR(10), 
		`user_purchases` INT(11) NOT NULL DEFAULT '0', 
		PRIMARY KEY(`id_user`)
	);

	CREATE TABLE IF NOT EXISTS `fv_products`
	(
		`id_product` INT NOT NULL AUTO_INCREMENT, 
		`product_name` VARCHAR(100) NOT NULL, 
		`product_stock` INT NOT NULL DEFAULT '1', 
		`product_amount` FLOAT NOT NULL, 
		PRIMARY KEY(`id_product`)
	);

	INSERT INTO `fv_users` (`user_firstname`, `user_lastname`, `user_birthdate`, `user_tel`, `user_purchases`)
	VALUES ('John Christopher', 'DEPP II', '1963-06-09', '0606060606', 4);
	INSERT INTO `fv_users` (`user_firstname`, `user_lastname`, `user_birthdate`, `user_tel`)
	VALUES ('Cyril', 'HANOUNA', '1974-09-23', '0611220044');
	INSERT INTO `fv_users` (`user_firstname`, `user_lastname`, `user_birthdate`, `user_purchases`)
	VALUES ('Adrien', 'NOUGARET', '1990-03-01', 12);
	INSERT INTO `fv_users` (`user_firstname`, `user_lastname`, `user_birthdate`, `user_tel`, `user_purchases`)
	VALUES ('Jaoued ', 'DAOUKI', '1987-08-18', '0612345678', 4);
	INSERT INTO `fv_users` (`user_firstname`, `user_lastname`, `user_birthdate`, `user_tel`, `user_purchases`)
	VALUES ('Kenny ', 'VANDERBECKEN', '1420-10-31', '0612345678', 666);

	INSERT INTO `fv_products` (`product_name`, `product_stock`, `product_amount`)
	VALUES ('PC portable Gaming Nabilla', 15, 1399.99);
	INSERT INTO `fv_products` (`product_name`, `product_stock`, `product_amount`)
	VALUES ('Kit de rituels TOS TES TAS', 6000, 9.95);
	INSERT INTO `fv_products` (`product_name`, `product_stock`, `product_amount`)
	VALUES ('MyBigBurger - salade tomates oignons chef', 15, 17.40);
	INSERT INTO `fv_products` (`product_name`, `product_stock`, `product_amount`)
	VALUES ('MyBigBurger - salade tomates oignons chef', 15, 17.40);
	INSERT INTO `fv_products` (`product_name`, `product_stock`, `product_amount`)
	VALUES ("Livre - l'Univers comme tu ne l'as jamais cru", 42, 14.95);
	INSERT INTO `fv_products` (`product_name`, `product_stock`, `product_amount`)
	VALUES ("Pain au chocolat OU Chocolatine", 1, 0.15);
	INSERT INTO `fv_products` (`product_name`, `product_stock`, `product_amount`)
	VALUES ("Toilette portatif pour streamers", 200, 275.00);
	INSERT INTO `fv_products` (`product_name`, `product_stock`, `product_amount`)
	VALUES ("Bidon d'essence (1L)", 1500, 0.15);
	INSERT INTO `fv_products` (`product_name`, `product_stock`, `product_amount`)
	VALUES ("Carte cadeau Steam", 400000, 25.00);
```
Ce script va tout simplement, va faire du nettoyage (DROP) si nécessaire et ensuite il va créer une base de données qui s'appellera fv_database d'accord donc on va ensuite pointer dessus (USE) et il va créer deux tables une table fv_users qui représentera des utilisateurs et une table fv_products qui représentera des produits.

C'est des choses très simples, il n'y a pas beaucoup d'informations.

On commence doucement et on verra si plus tard il faut rajouter des choses mais par rapport à ce qu'on a fait dans cette vidéo on a largement ce qu'il faut avec ces deux tables là et ensuite on ajoute quelques enregistrements donc on enregistre des utilisateurs, on enregistre des produits mais comme on n'a pas encore vu justement la création d'enregistrement sql, c'est des choses que vous verrez plus tard donc ne vous intéressez pas cette partie là, ça on n'a pas encore vu on le verra.

Bien je ferme ce fichier et on va pouvoir du coup le charger alors pour charger ce fichier là, on va utiliser la commande SOURCE d'accord et ensuite le chemin vers le fichier donc à moins que le fichier soit bien sûr présent dans le même répertoire bin de mysql, ce qui serait bizarre dans les binaires de mysql et donc vous tapez nom du fichier point sql si vous l'avez mis là mais ce serait bizarre, soit pour accéder au chemin du fichier alors soit vous savez manipuler les chemins de fichiers sur votre système et il y a pas de problème sinon petite astuce au passage pour ceux qui sont sur windows quand vous êtes dans votre explorateur vous cliquez à l'endroit où se trouve le fichier ici et vous avez le chemin complet d'accord, les répertoires et sinon vous pouvez faire encore mieux vous prenez en fait le fichier en question et vous le glisser-déposer à votre terminal.

Je n'ai pas forcément dit sur d'autres vidéos de la chaîne youtube mais s'est applicable bien évidemment sur par exemple le cours en c, en c++, en java ou autre quand vous besoin d'accéder à un chemin d'un fichier pour la compilation, ce genre de choses donc c'est tout bête très pratique, ça permet comme ça d'être sûr d'avoir le bon choix.

Alors à partir de là et là par contre c'est la petite particularité c'est que mysql ne prend pas en compte les anti slash donc les back slashs que vous voyez ici.
```sql
	mysql> SOURCE C:\SQL\cours\009_Lecture_donnees\data1.sql
```
Il va falloir les remplacer donc ça il va éventuellement n'hésitez pas à faire un copier coller de votre commande correct comme ça ça évitera de la retaper à chaque fois et de faire les remplacements donc je modifie toutes les parties ici voilà.
```sql
	mysql> SOURCE C:/SQL/cours/009_Lecture_donnees/data1.sql
```
Si vous les back slash ça ne marchera pas il vous dira qu'il n'arrive pas à ouvrir le fichier et vous indiquera une erreur donc il faut évidemment mettre les slash.

A partir de là on charge la commande voilà et on hésite pas parce que j'ai des petites erreurs ici et tout à re-exécuter le fichier éventuellement plusieurs fois pour être sûr qu'il soit bien pris en compte, y'a pas de problème voilà. Normalement après tout passe bien donc ça a fait tout ce que vous avez vu dans le fichier tout à l'heure d'accord, toutes ces petites requêtes ici ce sont exécutées les unes à la suite des autres d'accord tout est fait automatiquement et l'avantage c'est que du coup vous allez pouvoir faire ce que vous voulez sur cette base de données même plus tard si vous travaillez sur d'autres séances du cours, même si vous modifiez des données, vous en supprimez, tout ça par mégarde ou autre, c'est pas grave quand vous voudrez revenir à une base de données propre comme on l'a ici au début eh bien il suffira de refaire un SOURCE du fichier complet ou plusieurs fois éventuellement et vous repasserez comme ça à une base réinitialisée qui a les données de départ comme ça voilà tout sera dans le même état pour tout le monde et vous pourrez comme ça travailler sur les mêmes informations.

Ce sera aussi plus facile pour moi quand vous viendrez dans des commentaires demander de l'aide parce que vous êtes bloqués sur quelque chose comme on travaillera sur les mêmes données ce sera évidemment plus simple pour vous aider voilà pour cette partie.

Alors on est bon maintenant, on ne va pas recommencer cette lecture là.
```sql
	mysql> SOURCE C:/SQL/cours/009_Lecture_donnees/data1.sql
```
On va déjà vérifier que tout a bien été importés bon j'ai évidemment testé mon script avant de faire l'enregistrement de la vidéo sinon voilà on aurait perdu du temps sur cet enregistrement.

On va quand même vérifier c'est important.

Une première chose à faire c'est déjà de vérifier que alors nous avons bien mon ... ici on a on a pointé sur la base de données donc normalement on est déjà dessus.
```sql
	mysql> SOURCE C:/SQL/cours/009_Lecture_donnees/data1.sql
	Query OK, 0 rows affected (0.04 sec)

	Query OK, 0 rows affected (0.03 sec)

	Query OK, 0 rows affected (0.01 sec)

	Query OK, 1 row affected (0.01 sec)

>	Database changed
	...
```
Donc logiquement si on fait show tables, on doit avoir les tables de fv_database.
```sql
	mysql> show tables;
	+-----------------------+
	| Tables_in_fv_database |
	+-----------------------+
	| fv_products           |
	| fv_users              |
	+-----------------------+
	2 rows in set (0.01 sec)
```
Voilà vous voyez qu'on est bien sur fv_database, on a bien nos deux tables ça a l'air d'être bon et ensuite on fait juste ça.
```sql
	mysql> describe fv_products;
	+----------------+--------------+------+-----+---------+----------------+
	| Field          | Type         | Null | Key | Default | Extra          |
	+----------------+--------------+------+-----+---------+----------------+
	| id_product     | int          | NO   | PRI | NULL    | auto_increment |
	| product_name   | varchar(100) | NO   |     | NULL    |                |
	| product_stock  | int          | NO   |     | 1       |                |
	| product_amount | float        | NO   |     | NULL    |                |
	+----------------+--------------+------+-----+---------+----------------+
	4 rows in set (0.01 sec)
```
Donc on a apparemment tout ce qu'il faut pour les produits et ensuite on fait describe fv_users et on a tout ce qu'il faut aussi voilà.
```sql
	mysql> describe fv_users;
	+----------------+-------------+------+-----+---------+----------------+
	| Field          | Type        | Null | Key | Default | Extra          |
	+----------------+-------------+------+-----+---------+----------------+
	| id_user        | int         | NO   | PRI | NULL    | auto_increment |
	| user_firstname | varchar(65) | NO   |     | NULL    |                |
	| user_lastname  | varchar(65) | NO   |     | NULL    |                |
	| user_birthdate | date        | NO   |     | NULL    |                |
	| user_tel       | char(10)    | YES  |     | NULL    |                |
	| user_purchases | int         | NO   |     | 0       |                |
	+----------------+-------------+------+-----+---------+----------------+
	6 rows in set (0.00 sec)
```
Toutes les infos sont là, encore une fois très pratique en ligne de commande puisqu'il n'y a pas d'interface graphique donc c'est plus rapide et vous voyez que mysql ils ont quand même fait l'effort de bien présenter les informations sous forme de tableau donc c'est vachement lisible contrairement à d'autres systèmes qui ne seraient pas forcément aussi on va dire ergonomique donc là c'est quand même pas
mal.

A partir de là nous allons passer à la lecture de données on va voir déjà nos premières commandes.

Il y a une première requête à connaître, une première commande en tout cas sql pour lire de données pour les sélectionner, pour les récupérer, qui est la commande select et ça ça va être la première chose à connaître très importante qui vous servira partout quand même vous utiliserez les bases de données dans un autre langage comme php ou java etc quand on voudrait faire des requêtes sql et vous utiliserez principalement du sélect pour récupérer des données d'une base et ensuite les afficher sur une page web,  dans une application graphique etc.

Donc on a le sélect et ensuite on va vouloir récupérer une information en particulier, moi par exemple pour mes produits ici je vais récupérer le nom d'accord.
```sql
	+----------------+--------------+------+-----+---------+----------------+
	| Field          | Type         | Null | Key | Default | Extra          |
	+----------------+--------------+------+-----+---------+----------------+
	| id_product     | int          | NO   | PRI | NULL    | auto_increment |
>	| product_name   | varchar(100) | NO   |     | NULL    |                |
	| product_stock  | int          | NO   |     | 1       |                |
	| product_amount | float        | NO   |     | NULL    |                |
	+----------------+--------------+------+-----+---------+----------------+
```
Je veux récupérer le nom de tous les produits qui sont enregistrés dans ma table fv_products donc pour faire ça c'est très simple vous avez le select et vous mettez ensuite le nom du champ moi c'est product_name d'accord from le nom de la table.

+ commandes.sql
```sql
	SELECT product_name FROM fv_products;
```
Et on fait ceci.

Alors petite parenthèse vous avez vu un petit peu comment je nomme mes champs etc au niveau de sql, en général j'ai un nom de table, un préfixe fv_ pour formation vidéo. Vous pouvez mettre ce que vous voulez. On a _products qui est au pluriel et ensuite on a l'identifiant avec le id_ toujours au début, id_product donc là au singulier et ensuite pour tous les autres champs c'est le nom de la table au singulier underscore et le nom du champ en question.

L'avantage c'est que en mettant ça, je ne vais pas avoir de collision ou de nom identique. Si je m'étais que name dans fv_products et name par exemple dans fv_users et bien on aurait un champ name dans users et products et on ne serait pas du coup à quoi ils correspondent.

Là le fait de le préciser dans le nom du champ c'est beaucoup plus explicite et beaucoup plus pratique pour nous et ça va surtout réduire la taille des requêtes sql.

Je vous invite bien sûr à procéder à ce genre de nommage si vous n'avez pas voilà adopté un nommage particulier sinon si vous voulez faire un nommage à vous, prenez l'habitude d'avoir comme pour les variables en programmation d'avoir des noms suffisamment explicite pour savoir à quoi ça fait référence donc là au moins on sait s'y retrouver facilement.

Donc je fais cette commande, on va on revient sur notre parti ici du
coup et là quand j'exécute la commande on a bien donc tous les noms des produits qui ressort d'accord.
```sql
	mysql> SELECT product_name FROM fv_products;
	+-----------------------------------------------+
	| product_name                                  |
	+-----------------------------------------------+
	| PC portable Gaming Nabilla                    |
	| Kit de rituels TOS TES TAS                    |
	| MyBigBurger - salade tomates oignons chef     |
	| MyBigBurger - salade tomates oignons chef     |
	| Livre - l'Univers comme tu ne l'as jamais cru |
	| Pain au chocolat OU Chocolatine               |
	| Toilette portatif pour streamers              |
	| Bidon d'essence (1L)                          |
	| Carte cadeau Steam                            |
	+-----------------------------------------------+
	9 rows in set (0.01 sec)
```
On a tous les noms de nos produits qui sont dans notre base de données.

Si je veux maintenant récupérer admettons le nom du produit et son montant, le prix qu'il coûte. Je veux récupérer donc deux champs eh bien vous les séparés par une virgule et vous mettez ceci.

+ commandes.sql
```sql
	SELECT product_name, product_amount FROM fv_products;
```
Comme ceci alors vous pouvez mettre des espaces pas d'espace, ça ne pose évidemment pas de problème d'accord tant que vous respectez un petit peu les syntaxes il n'y aura pas de souci.

Toute façon si vous faites une erreur sur les requêtes sql, il va vous vite vous le faire savoir en indiquant qu'il y a une syntaxe erreur dans votre commande donc voila vous ne pourrait de toutes façons pas obtenir ce que vous voulez alors ensuite on va descendre un peu là et on fait la commande et voilà.
```sql
mysql> SELECT product_name, product_amount FROM fv_products;
+-----------------------------------------------+----------------+
| product_name                                  | product_amount |
+-----------------------------------------------+----------------+
| PC portable Gaming Nabilla                    |        1399.99 |
| Kit de rituels TOS TES TAS                    |           9.95 |
| MyBigBurger - salade tomates oignons chef     |           17.4 |
| MyBigBurger - salade tomates oignons chef     |           17.4 |
| Livre - l'Univers comme tu ne l'as jamais cru |          14.95 |
| Pain au chocolat OU Chocolatine               |           0.15 |
| Toilette portatif pour streamers              |            275 |
| Bidon d'essence (1L)                          |           0.15 |
| Carte cadeau Steam                            |             25 |
+-----------------------------------------------+----------------+
9 rows in set (0.00 sec)
```
Donc nous avons du coup les deux champs enfin les deux colonnes en fait donc les deux parties ici de notre table avec tous les enregistrements qu'elle contient donc on pour chaque nom de produit nous avons son prix d'accord le montant du produit en question, très pratique.

Maintenant si nous voulons récupérer la totalité des enregistrements et de toutes les colonnes de la table et ça vous connaissez un petit peu pour ceux qui font de l'informatique, nous avons le fameux symbole étoiles * qui veut dire ALL donc ça normalement vous connaissez bien si vous faites déjà de la programmation ou autre.

+ commandes.sql
```sql
	SELECT * FROM fv_products;
```
Et dans ce cas là en faisant juste ça on a toutes les informations qui ressortent.
```sql
mysql> SELECT * FROM fv_products;
+------------+-----------------------------------------------+---------------+----------------+
| id_product | product_name                                  | product_stock | product_amount |
+------------+-----------------------------------------------+---------------+----------------+
|          1 | PC portable Gaming Nabilla                    |            15 |        1399.99 |
|          2 | Kit de rituels TOS TES TAS                    |          6000 |           9.95 |
|          3 | MyBigBurger - salade tomates oignons chef     |            15 |           17.4 |
|          4 | MyBigBurger - salade tomates oignons chef     |            15 |           17.4 |
|          5 | Livre - l'Univers comme tu ne l'as jamais cru |            42 |          14.95 |
|          6 | Pain au chocolat OU Chocolatine               |             1 |           0.15 |
|          7 | Toilette portatif pour streamers              |           200 |            275 |
|          8 | Bidon d'essence (1L)                          |          1500 |           0.15 |
|          9 | Carte cadeau Steam                            |        400000 |             25 |
+------------+-----------------------------------------------+---------------+----------------+
9 rows in set (0.00 sec)
```
Voilà alors ça vous met d'ailleurs un petit peu le nombre de lignes dans rows donc ça ce sont les enregistrements d'accord il y en a bien 9 identifiants et en plus ça vous avez le temps d'exécution qu'a pris la requête donc là on voit que c'est quasi instantanée, ça n'affiche pas des milli secondes. Bref c'est très rapide donc on a toutes les infos qui sont affichées alors si vous devez afficher presque tous les champs d'une table ou autre il est mieux d'utiliser ce joker là d'accord le sélect étoile * parce que souvent il y a déjà des index qui sont déjà fait sur les bases de données et du coup les informations arriveront plus vite plutôt par exemple de dire, je veux que product_name et product_stock et product_amount.

Si vous voulez vraiment tout autant mettre le symbole étoile pour optimiser votre requête donc n'hésitez pas à vous en servir et principalement même quand on veut pas forcément tous les champs, on verra que dans ma grande majorité des cas utiliser l'étoile pour faire une sélection sera plus optimisé plus rapide que de sélectionner des champs particuliers donc à vous de voir bien sûr, testez sur des vrais cas concrets, des vraies bases de données, qu'est-ce qui est le plus rapide ? vous testez l'étoile, vous testez sans l'étoile et vous verrez de toute façon ce sera affiché clairement et vous verrez en fonction de la base et des données que vous avez qu'est-ce qui a été retourné le plus rapidement.

Ca dépend aussi de comment est enregistré votre base au niveau du moteur de stockage n'oubliez pas, si il y a plein de lectures on préfère un myisam et si on va surtout faire des update et des delete on préféra utiliser innodb et tout ça on en a déjà parlé dans des vidéos précédentes.

Voilà pour cette partie là donc pour le sélect, ces informations là.

Alors petite particularité bon déjà si je fais pour les utilisateurs, voyez je renvoie toutes les informations des utilisateurs.
```sql
mysql> select * from fv_users;
+---------+------------------+---------------+----------------+------------+----------------+
| id_user | user_firstname   | user_lastname | user_birthdate | user_tel   | user_purchases |
+---------+------------------+---------------+----------------+------------+----------------+
|       1 | John Christopher | DEPP II       | 1963-06-09     | 0606060606 |              4 |
|       2 | Cyril            | HANOUNA       | 1974-09-23     | 0611220044 |              0 |
|       3 | Adrien           | NOUGARET      | 1990-03-01     | NULL       |             12 |
|       4 | Jaoued           | DAOUKI        | 1987-08-18     | 0612345678 |              4 |
|       5 | Kenny            | VANDERBECKEN  | 1420-10-31     | 0612345678 |            666 |
+---------+------------------+---------------+----------------+------------+----------------+
5 rows in set (0.00 sec)
```
Ca fonctionne aussi, on récupère voilà le prénom, le nom, la date de naissance, un numéro de téléphone s'il en on parce que je n'avais pas rendue ce champ obligatoire donc Adrien NOUGARET n'avait pas numéro de téléphone donc aucune information et un nombre de produits et si on indiquait pas par défaut et il n'y avait pas d'achats éffectués, on voit que Cyril HANOUNA n'a fait aucun achat.

Et ça pourrait être des produits dans fv_products, voilà il n'y a pas forcément de relations entre les deux tables parce qu'on n'a pas encore vu les jointures ou ce genre de choses donc j'ai juste fait de table qui peuvent être très bien indépendante même si on peut très vite comprendre que des utilisateurs vont acheter quoi ? des produits et que du coup leurs membres d'achat ça pourrait correspondre à des produits achetés ici mais ça on le verra plus tard.

Voilà pour cette partie alors on se rend compte d'un petit truc vous avez peut-être remarqué que là pour les produits vous avez eu peut-être je pense pour la majorité d'entre vous, je pense, vu qu'il y avait deux lignes pareil d'accord on obtient ici deux enregistrements identiques qui sont bien deux enregistrements distincts puisqu'ils n'ont pas le même identifiant par contre toutes les informations sont identiques.

Si on veut éviter par exemple de récupérer deux fois le même nom de produits c'est-à-dire quand je fais alors quand je fais un select product_name from fv_products.
```sql
	mysql> SELECT product_name FROM fv_products;
	+-----------------------------------------------+
	| product_name                                  |
	+-----------------------------------------------+
	| PC portable Gaming Nabilla                    |
	| Kit de rituels TOS TES TAS                    |
	| MyBigBurger - salade tomates oignons chef     |
	| MyBigBurger - salade tomates oignons chef     |
	| Livre - l'Univers comme tu ne l'as jamais cru |
	| Pain au chocolat OU Chocolatine               |
	| Toilette portatif pour streamers              |
	| Bidon d'essence (1L)                          |
	| Carte cadeau Steam                            |
	+-----------------------------------------------+
	9 rows in set (0.00 sec)
```
Voilà là je vais récupérer deux fois le même nom de produit donc ça se fait quand on sélectionne un champ, ça fonctionnera pas sur l'étoile ici attention et bien on peut choisir de récupérer que les résultats distincts c'est-à-dire tout ce qui n'est pas en fait doublon tout ce qui n'est pas identique et pour cela il suffit simplement donc au lieu de mettre par exemple ceci.
```sql
	SELECT product_name FROM fv_products;
	-> SELECT DISTINCT product_name FROM fv_products;
	```
Voilà plutôt de mettre juste ça il suffit de rajouter après le sélect le mot DISTINCT, DISTINCT va dire de prendre des enregistrements distincts c'est à dire ce qui n'est pas doublon ce qui n'est pas identique alors attention si vous travaillez sur une base de données Oracle, Oracle apparemment n'aimait pas le mot DISTINCT donc ils ont choisi à la place le mot UNIQUE donc ça c'est pour oracle sinon pour tous les autres c'est distinct, pas de problème.

Voilà donc je vous avez dit nous on essaye dans ce cours de vous faire du sql général càd qui fonctionne partout et quand je vois qu'il y a des choses qui sont vraiment propre à mysql ou propre à postgressql propre à sql server ou oracle etc et je vous l'indiquerai mais pas forcément tout le temps mais j'essaye au maximum de vous faire un cours sql qui fonctionne sur toutes les types de bases de données même si il y aura de temps en temps quelques exceptions parce que malheureusement chaque système base donnée à ajouter ses propres fonctionnalités, ses propres fonctions donc c'est bien parce que ça ajoute des trucs en plus mais le problème c'est que du coup c'est assez confus parce que les gens pensent qu'une fonction sur oracle va fonctionner sur mysql or ce n'est pas forcément le cas et de toute façon généralement ça ne l'est pas donc fait attention à ça.
```sql
	mysql> SELECT DISTINCT product_name FROM fv_products;
	+-----------------------------------------------+
	| product_name                                  |
	+-----------------------------------------------+
	| PC portable Gaming Nabilla                    |
	| Kit de rituels TOS TES TAS                    |
	| MyBigBurger - salade tomates oignons chef     |
	| Livre - l'Univers comme tu ne l'as jamais cru |
	| Pain au chocolat OU Chocolatine               |
	| Toilette portatif pour streamers              |
	| Bidon d'essence (1L)                          |
	| Carte cadeau Steam                            |
	+-----------------------------------------------+
	8 rows in set (0.01 sec)
```
Donc là on fait ça et là du coup l'enregistrement, enfin le retour d enregistrement sera différent là on avait l'enregistrement en double et là on ne l'a plus voilà donc si vous voulez récupérer aucun enregistrement en double vous utilisez le mot DISTINCT et vous ne l'aurez pas comme ça dans les résultats.

On voit que là on a neuf lignes retournées et là avec le DISTINCT ça effectivement retourné ce qu'il fallait donc ça c'est à connaître d'accord vous savez maintenant comment récupérer donc lire des données d'accord suivant des champs, vous savez récupérer toutes les données, vous savez également éviter la lecture des doublons de ces données donc c'est des choses à connaître.

Alors par la suite a évidemment select on a vu vraiment que le début, avec select on va l'utiliser sur plein de choses. On l'utilisera également pour faire des sous requête, on va l'utiliser pour faire du filtrage, du tri de données, pour organiser, donner un certain ordre.

On verra également comment faire des jointures càd de créer vraiment des liaisons, indiquer des lésions entre plusieurs tables qui pourront par exemple voilà s'enchaîner en tout cas se lier entre elles. Exemple tout bête par rapport à ce qu'on a ici, on pourrait avoir un champ par exemple user_last_product (table fv_users) par exemple le dernier produit qui a été acheté et dans cette valeur on aurait en fait un identifiant ce serait l'identifiant d'un produit ici enregistré d'accord donc là on aurait véritablement une liaison ce n'est pas quelque chose indépendant.
```txt
	fv_users

	------------+-------------------+
				| user_last_product	|
	------------+-------------------+
				|					|
```
C'est ce qui aurait dans le champ ici derniers produits achetés serait directement comme un pointeur en fait une référence vers un identifiant du produit en question qui a été le dernier rachat de la personne voilà concernés donc là on pourra comme ça créer ce genre de liaison, de faire des jointures tout ça mais on le verra plus tard et c'est pas pour tout de suite.

Voilà donc sachez que niveau de sql on a vu que le début et c'est pas parce que on a vu cette vidéo sur sql que ça y est c'est terminé, on reviendra plus dessus, il y a évidemment plein d'autres choses à voir il y a également l'utilisation de fonctions qu'on verra par la suite et qui sont plutôt utile.

Voilà qu'est ce qu'on peut voir d'autres aussi ? qu'est-ce qu'on peut voir d'autres avec le select ?

On va pouvoir parler des alias, on peut voir ça maintenant de toute façon c'est pas forcément liée à la lecture de données mais ces pratiques à utiliser.

Un alias c'est simplement un renommage d'accord à la volée de certains termes on peut utiliser des aléas sur des noms de champs et on peut utiliser des alias sur des noms de tables par exemple.

Vous voyez que quand je fais une commande ici le tableau au niveau des résultats me retourne les noms des champs.
```sql
	mysql> select * from fv_users;
	| id_user | user_firstname   | user_lastname | user_birthdate | user_tel   | user_purchases |
	...
```
Alors quand on est l'administrateur de base de données qui crée les bases de données etc c'est évidemment plus simple de travailler comme ça. On travaille d'ailleurs principalement avec de l'anglais mais quand on veut l'afficher à un utilisateur ou quand on veut avoir l'information sous les yeux c'est peut-être mieux de l'avoir en français si on est français et d'avoir des choses un peu plus clair que voilà ici id_user etc qui est pas forcément suffisamment explicite donc vous allez pouvoir créer des alias.

Alors déjà au niveau des requêtes pour raccourcir les commandes càd que au lieu de taper product_name, on peut raccourcir ça et dans d'autres choses aussi.

Alors les alias on les réutilisera également dans d'autres vidéos parce que ça sera plus utile quand on travaillait sur les clause notamment les clause WHERE, on en parlera un petit peu plus tard mais je vous les montre déjà maintenant.
```sql
	SELECT product_name FROM fv_products;
```
Pour faire un alias donc c'est très simple par exemple product_name ici, je veux pas avoir à chaque fois à récrire product_name dans ma requête eh bien je vais utiliser le mot AS alors on n'est pas obligé de le mettre normalement on peut mettre juste un espace par exemple ceci.
```sql
	SELECT product_name aliasname FROM fv_products;
```
Mais moi je vous conseille d'utiliser le mot clé AS comme ça on sait qu'aux fait un alias et pour dire product_name son alias ce sera par exemple pN comme ceci.
```sql
	SELECT product_name AS pN FROM fv_products;
```
Voilà et ça veut dire que si plus tard on a d'autres choses dans la requête donc on ne l'a pas encore vu dans cette vidéo mais on le verra plus tard dans la formation, à chaque fois qu'on voudra refaire référence à product_name plutôt que de réécrire toujours ça dans la requête d'accord du coup voyez ça fait des noms plus long, on pourra passer par la l'alias ce sera plus rapide donc il n'y a pas de problème.

Là où c'est intéressant en faisant ça et là ça a une utilité au moment où vous en êtes pour le moment sur mysql c'est qu'en faisant ça vous voyez que là au niveau de l'affichage du résultat il m'affiche l'alias.

+ commandes.sql 
```sql
	SELECT product_name AS pN FROM fv_products;

	mysql> SELECT product_name AS pN FROM fv_products;
	+-----------------------------------------------+
	| pN                                            |
	+-----------------------------------------------+
	| PC portable Gaming Nabilla                    |
	| Kit de rituels TOS TES TAS                    |
	| MyBigBurger - salade tomates oignons chef     |
	| MyBigBurger - salade tomates oignons chef     |
	| Livre - l'Univers comme tu ne l'as jamais cru |
	| Pain au chocolat OU Chocolatine               |
	| Toilette portatif pour streamers              |
	| Bidon d'essence (1L)                          |
	| Carte cadeau Steam                            |
	+-----------------------------------------------+
	9 rows in set (0.00 sec)
```
Donc je peux très bien du coup mettre une information plus intéressante genre Nom_du_produit.

+ commandes.sql 
```sql
	SELECT product_name AS Nom_du_produit FROM fv_products;

	mysql> SELECT product_name AS Nom_du_produit FROM fv_products;
	+-----------------------------------------------+
	| Nom_du_produit                                |
	+-----------------------------------------------+
	| PC portable Gaming Nabilla                    |
	| Kit de rituels TOS TES TAS                    |
	| MyBigBurger - salade tomates oignons chef     |
	| MyBigBurger - salade tomates oignons chef     |
	| Livre - l'Univers comme tu ne l'as jamais cru |
	| Pain au chocolat OU Chocolatine               |
	| Toilette portatif pour streamers              |
	| Bidon d'essence (1L)                          |
	| Carte cadeau Steam                            |
	+-----------------------------------------------+
	9 rows in set (0.00 sec)
```
Voilà c'est quand même beaucoup plus exclusive Nom_du_produit quand on veut présenter des articles qui sont en français plutôt que de mettre product_name et en plus si vous voulez mettre des espaces ou autre en toute logique comme il ne faut pas d'espaces dans la commande vous mettez simplement par exemple des guillemets et là du coup vous ne vous embêter même plus avec des underscore.

+ commandes.sql 
```sql
	SELECT product_name AS "Nom du produit" FROM fv_products;
```
Vous pouvez faire ça et ça passe tranquille.
```sql
	mysql> SELECT product_name AS "Nom du produit" FROM fv_products;
	+-----------------------------------------------+
	| Nom du produit                                |
	+-----------------------------------------------+
	| PC portable Gaming Nabilla                    |
	| Kit de rituels TOS TES TAS                    |
	| MyBigBurger - salade tomates oignons chef     |
	| MyBigBurger - salade tomates oignons chef     |
	| Livre - l'Univers comme tu ne l'as jamais cru |
	| Pain au chocolat OU Chocolatine               |
	| Toilette portatif pour streamers              |
	| Bidon d'essence (1L)                          |
	| Carte cadeau Steam                            |
	+-----------------------------------------------+
	9 rows in set (0.01 sec)
```
Je fais la commande et voilà Nom du produit donc ça c'est bien plus pratique de procéder comme ça alors pareil voyez il faut bien sûr le nom précisé pour faire un alias dessus. Vous pouvez pas faire ça `SELECT * AS "Nom du produit"` sinon on ne sera pas à quoi ça correspond le nom du produit, à quel champ puisque là on les prend tous donc évidemment il faut spécifier un champ en particulier.

Alors après ce qui peut être fait aussi c'est sur une table si on ne veut pas noter fv_products, on peut faire pareil par exemple le stock des produits ou alors je sais pas moi l'inventaire des produits, on peut mettre du coup n'importe quels noms mains peu importe.

+ commandes.sql 
```sql
	SELECT product_name AS "Nom du produit" FROM fv_products AS "Inventaire des produits";
```
Et comme ça voilà on a des alias beaucoup plus alors évidemment il
n'était pas content.

+ client
```sql
	mysql> SELECT product_name AS "Nom du produit" FROM fv_products AS "Inventaire des produits";
	ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '"Inventaire des produits"' at line 1
```
+ commandes.sql 
```sql
	SELECT product_name AS "Nom du produit" FROM fv_products AS Inventory;
```
+ client
```sql
	mysql> SELECT product_name AS "Nom du produit" FROM fv_products AS Inventory;
	+-----------------------------------------------+
	| Nom du produit                                |
	+-----------------------------------------------+
	| PC portable Gaming Nabilla                    |
	| Kit de rituels TOS TES TAS                    |
	| MyBigBurger - salade tomates oignons chef     |
	| MyBigBurger - salade tomates oignons chef     |
	| Livre - l'Univers comme tu ne l'as jamais cru |
	| Pain au chocolat OU Chocolatine               |
	| Toilette portatif pour streamers              |
	| Bidon d'essence (1L)                          |
	| Carte cadeau Steam                            |
	+-----------------------------------------------+
	9 rows in set (0.00 sec)
```
Voilà on ne l'affiche pas mais en tout cas on pourra changer comme ça les noms au niveau de la table si on veut appliquer un alias après faut évidemment avoir l'utilité, ne m'étez pas d'alias pour rien en faire.

Là moi je vous montre que cette commande fonctionne mais il faut l'utiliser dans un cas concret quand ça une utilité pour vous au niveau lisibilité au niveau de la re lecture ou de l'affichage des données pour que ce soit évidemment beaucoup plus clair comme ça plutôt que d'avoir les noms des champs directement donc c'est à vous de voir bien sûr par rapport à ça.

Voilà comment ça fonctionne les alias d'accord vous avez dans votre champ ou votre table vous mettez AS et le nom et ça fonctionne.

Vous pouvez comme ça avoir des noms un peu plus propre un peu plus explicite en tout cas pour sélectionner des données et surtout éviter de toujours écrire les noms complets donc ce sera aussi utile vous verrez quand on aura des requêtes beaucoup plus long que ça et quand on devra par exemple écrire 15 fois product_name, on sera content d'avoir à écrire que pN à la place par exemple ce qui ira plus vite à taper que product_name même pour les copier coller ça fera des requêtes moins longue en tout cas donc c'est l'utilité en tout cas des alias c'est pas du tout obligatoire mais c'est pour ça que vous en parle sur cette fin de vidéo pour que vous puissiez les connaître et les utiliser si ça vous intéresse et que ça vous est utile.

Voilà pour cette lecture de données donc encore une fois c'était très basique en aura encore plein plein plein de choses à voir.

Je vous avouerais que c'est vraiment pas évident de faire un cours sql puisqu'il y a beaucoup de choses très vite qui s'emmèllent et des choses très avancée qui peuvent être faits au tout départ au tout départ de l'apprentissage du sql donc j'essaie de faire quelque chose d'assez progressif mais j'ai peur mais des fois dans certaines vidéos d'avoir oublié de parler de telles choses et que j'aurais pu en parler plus tôt et ben voilà on peut pas faire un cours parfait de toute façon donc moi mon intérêt c'est qu'à la fin en tout cas à la vidéo de conclusion on ait fait le tour de tout ce que je voulais aborder avec vous et que vous puissiez mettre ça en pratique que ce soit pour un projet personnel ou juste par passion ou un projet professionnel dans une vraie entreprise où vous travaillez sur une vraie base de données en production avec des vraies informations, sur des gens etc.

Voilà que vous puissiez mettre ça en application derrière donc on essaiera de toucher un petit peu à tout dans le cours, d'apporter des compléments sur les tutoriels et il y aura bien évidemment une grosse série d'exercices avec une grosse base de données pareil que je vous fournirai sous forme de fichiers comme je vous l'ai dit, que vous allez retrouver dans les exercices de sql et qui permettra comme ça de travailler là-dessus et de faire tout un tas de mise en pratique et de mise en application de ce que vous avez appris sur le cours.

Voilà voilà alors on va quitter du coup ça fera un petit rappel comme ça donc on fait ceci.

+ client
```sql
	mysql> exit
	Bye
	PS C:\Users\sam> mysqladmin -u root -p shutdown
	Enter password:
```
Et voilà le serveur est quitté, on peut fermer ça proprement.

Voilà voilà tout est beau je vous laisse pour cette vidéo là pour cette séance numéro 9.

On se retrouvera du coup pour la 10ème à sur cette formation sql.

A bientôt et n'hésitez pas à laisser des commentaires si vous avez besoin d'aides.

Ciao tout le monde