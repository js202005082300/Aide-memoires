# [11. Enregistrer données](https://www.youtube.com/watch?v=ETBhek3AklE)
31-12-2020

[data3.sql](data3.sql)

Bonjour tout le monde et bienvenu pour la séance numéro 11 en sql.

Maintenant qu'on a vu comment lire des données et comment filtrer un petit peu le résultat de nos requêtes, on va voir comment ajouter de nouveaux enregistrements sur une table sql donc pouvoir tout simplement enregistrer de nouvelles informations.

Pour cela vous aurez un fichier sql à récupérer dans la description de la vidéo comme on a déjà fait précédemment avec un fichier très simple qui contient simplement donc la re création de la base de données fv_database et la création d'une table de clients tout simplement avec tout un tas d'informations qu'on va voir un peu plus tard, alors on va mettre ça de côté.

on va d'abord se connecter donc à la base de données et moi ici je vais importer mon fichier et c'est bien sûr à vous de voir en fonction du chemin.
```powershell
	>mysqld --console
	> mysql -u root -p
	> source C:/SQL/cours/011_Enregistrer_donnees/data3.sql
```
On le fait plusieurs fois comme ça on est sûr que tout est pris en compte.
```sql
	mysql> use fv_database;
	Database changed
```
On utilise la bonne base de données, database toujours gardé le même nom comme ça vous n'êtest pas perdu et ensuite je peux tout simplement faire un show tables pour voir que tout est bien là et on retrouve bien fv_clients ici.
```sql
	mysql> show tables;
	+-----------------------+
	| Tables_in_fv_database |
	+-----------------------+
	| fv_clients            |
	+-----------------------+
	1 row in set (0.02 sec)
```
On a plus qu'à faire un describe de fv_clients pour être sûr que toutes les informations ont bien été enregistrées donc là on a un identifiant de client qui auto incrémentée d'accords qui est notre clé primaire ici, on a client_firstname qui sera tout simplement le prénom, client_lastname pour le nom de famille, client_birthday pour la date de naissance et client_loyalty pour tout simplement un nombre de points de fidélité du client en question. On peut imaginer des points de fidélité pour un magasin par exemple.	
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
On va regarder ça de côté et on va voir comment enregistrer des nouvelles personnes puisque si je fais ici un select * from fv_clients on voit qu'il n'y a aucun enregistrement qui est retourné puisque la table est tout simplement vide donc on va ajouter de nouveaux clients à cette table.
```sql
	mysql> select * from fv_clients;
	Empty set (0.00 sec)
```
On va passer sur notre fichier commandes.sql ici et je vais vous montrer deux manières alors une première manière pour enregistrer, enfin faire un nouvel enregistrement et ensuite on verra comment faire plusieurs enregistrements en même temps avec une seule et même requête pour éviter de devoir faire un enregistrement par requête et d'alourdir du coup la base de données.

Alors première syntaxe toute simple c'est tout simplement l'utilisation de la requête INSERT INTO alors on pourrait sans problème utiliser une syntaxe très simple càd plus courte qui permet en fait donc d'enregistrer un élément mais il faudrait pour cela spécifier forcément tout les champs de la base de données d'accord, en tout cas de la table en question. Moi je ne vous recommande pas ça tous pour une simple et bonne raison c'est que si un jour vous voulez ajouter un nouveau champ à une table, admettons qu'un jour ici pour
le client on veut ajouter un nouveau champ.
```sql
	fv_clients
	+------------------+-------------+------+-----+---------+----------------+
	| Field            | Type        | Null | Key | Default | Extra          |
	+------------------+-------------+------+-----+---------+----------------+
	| id_client        | int         | NO   | PRI | NULL    | auto_increment |
	| client_firstname | varchar(65) | NO   |     | NULL    |                |
	| client_lastname  | varchar(65) | NO   |     | NULL    |                |
	| client_birthday  | date        | NO   |     | NULL    |                |
	| client_loyalty   | int         | NO   |     | NULL    |                |
	+------------------+-------------+------+-----+---------+----------------+
```
Si on veut ajouter un nouveau champ et bien vous serez obligés de réécrire toutes vos requêtes pour pas mal de choses alors que là si on ajoute un nouvel élément on pourra sans problème l'ajouter dans la liste et on pourra du coup adapter les requêtes que l'on fait et pouvoir du coup avoir quelque chose de beaucoup plus souple tout simplement parce que si on on obligé de renseigner tous les éléments de la table on est obligé de les mettre dans le bon ordre c'est à dire dans l'ordre dans lequel ils sont écrits ici alors que si vous les spécifiez manuellement vous pouvez les mettre dans l'ordre que vous voulez et du coup c'est beaucoup plus dynamique dans vos développements en web en tout cas par rapport aux requêtes que vous ferez.

En gros ce qu'on va faire, on va dire INSERT INTO ´fv_clients´ et ici je précise entre parenthèses l'ordre des champs que je veux voyez donc du coup c'est complètement en fait dynamique je peux gérer ça moi même.
```sql
	INSERT INTO `fv_clients`()
```
Donc en premier mot, moi je vais garder tout simplement client_firstname ça n'a pas changé, on ne m'est pas l'identifiant puisqu'il est auto incrémenté par la base de données donc il a évidemment aucun intérêt de l'ajouter nous mêmes, c'est à la base de données de le génèrer automatiquement.
```sql
	INSERT INTO `fv_clients`(client_firstname...)
```
client_lastname, ensuite la date de naissance donc je sépare chacun des champs par une virgule bien évidemment et ensuite client_loyalty voilà.
```sql
	INSERT INTO `fv_clients`(client_firstname, client_lastname, client_birthday, client_loyalty)
```
Comme ça si un jour je veux ajouter un nouveau champ ben je pourrais le mettre n'importe où et il suffira de l'ajouter dans les valeurs qui ont enregistré aussi simple que ça.

Et ici je vais à la ligne, on va ajouter dans l'ordre où j'ai renseigné dans ces parenthèses là des éléments, les valeurs tout simplement en question donc du coup firstname, on va mettre ça 'Jason' par exemple, le nom de famille 'CHAMPAGNE' pareil séparées par des virgules et dans des guillemets ou double guillemets en fonction. 
```sql
	INSERT INTO `fv_clients`(client_firstname, client_lastname, client_birthday, client_loyalty)
	VALUES('Jason', 'CHAMPAGNE', '');
```
la date de naissance alors les dates je vais vous faire une vidéo dédiée, il y aura une vidéo spécialement pour la gestion des dates en sql mais en gros le format c'est AAAA-MM-DD HH:mm:ss dans ce format là mais on aura de toute façon une vidéo dédiée spécialement pour les dates et des heures donc moi je vais mettre une date de naissance sous ce format là donc année mois jours et ensuite un certain nombre de points de fidélité.
```sql
	INSERT INTO `fv_clients`(client_firstname, client_lastname, client_birthday, client_loyalty)
	VALUES('Jason', 'CHAMPAGNE', '1991-02-10', 15);
```
voilà avec cette simple requête on va faire un seul enregistrement.

Je vais copier coller tout ça, on va copier coller dans le terminal et on fait entrer et ça a été ajouté.
```sql
	mysql> INSERT INTO `fv_clients`(client_firstname, client_lastname, client_birthday, client_loyalty)
		-> VALUES('Jason', 'CHAMPAGNE', '1991-02-10', 15);
	Query OK, 1 row affected (0.02 sec)
```
là je peux refaire une récupération de tous les clients et voir que le premier bien a bien été ajouté comme vous voyez l'identifiant a été automatiquement générés donc il commence par 1. Il sera auto incrémenté avec chacun des éléments qui sont bien mis là où il faut.
```sql
	mysql> select * from fv_clients;
	+-----------+------------------+-----------------+-----------------+----------------+
	| id_client | client_firstname | client_lastname | client_birthday | client_loyalty |
	+-----------+------------------+-----------------+-----------------+----------------+
	|         1 | Jason            | CHAMPAGNE       | 1991-02-10      |             15 |
	+-----------+------------------+-----------------+-----------------+----------------+
	1 row in set (0.00 sec)
```
Voilà donc comment on fait un enregistrement tout simplement via une requête simple en sql qui est insert into.

Si jamais et on va terminer avec ça parce que la vidéo est très courte, il n'y a pas grand chose à voir de plus si vous voulez ajouter plusieurs éléments d'un seul coup, vous allez pas vous amuser à répéter tout ça et en changeant par exemple les informations ici.
```sql
	INSERT INTO `fv_clients`(client_firstname, client_lastname, client_birthday, client_loyalty)
	VALUES('Jason', 'CHAMPAGNE', '1991-02-10', 15);
	
	INSERT INTO `fv_clients`(client_firstname, client_lastname, client_birthday, client_loyalty)
>	VALUES('Jason', 'CHAMPAGNE', '1991-02-10', 15);
```
Quand ce serait beaucoup plus lourd, ça ferait une requête pour chaque enregistrement ce qui évidemment pas du tout du tout optimisé.

Là ce que vous allez pouvoir faire c'est tout simplement la de mettre une virgule et en fait et de répéter les éléments là.

On va remettre ça d'accord alors je mettre les mêmes informations, je ne veux pas m'embêter à mettre d'autres informations, j'ai pas mis de contraintes d'unicité.

+ commandes.sql
```sql
	INSERT INTO `fv_clients`(client_firstname, client_lastname, client_birthday, client_loyalty)
	VALUES
	('Jason', 'CHAMPAGNE', '1991-02-10', 15),
	('Jason', 'CHAMPAGNE', '1991-02-10', 15),
	('Jason', 'CHAMPAGNE', '1991-02-10', 15),
	('Jason', 'CHAMPAGNE', '1991-02-10', 15),
	('Jason', 'CHAMPAGNE', '1991-02-10', 15);
```
Voilà en gros donc là je vais faire du coup cinq enregistrement d'un coup donc j'aurai à la fin 6 enregistrements dans ma base de données en tout cas dans la table fv_clients. Un seul value donc on va laisser juste un seul value c'est pour dire voilà il prend toutes ses valeurs et on sépare le groupe ici entre parenthèses par des virgules tout simplement donc on va faire ça ça serait quand même mieux et voilà on a cinq enregistrements qui ont été mis on va faire du coup select l'étoile from fv_clients à nouveau et on a bien nos 6 enregistrements au total.
```sql
	mysql> INSERT INTO `fv_clients`(client_firstname, client_lastname, client_birthday, client_loyalty)
		-> VALUES
		-> ('Jason', 'CHAMPAGNE', '1991-02-10', 15),
		-> ('Jason', 'CHAMPAGNE', '1991-02-10', 15),
		-> ('Jason', 'CHAMPAGNE', '1991-02-10', 15),
		-> ('Jason', 'CHAMPAGNE', '1991-02-10', 15),
		-> ('Jason', 'CHAMPAGNE', '1991-02-10', 15);
	Query OK, 5 rows affected (0.01 sec)
	Records: 5  Duplicates: 0  Warnings: 0

	mysql> select * from fv_clients;
	+-----------+------------------+-----------------+-----------------+----------------+
	| id_client | client_firstname | client_lastname | client_birthday | client_loyalty |
	+-----------+------------------+-----------------+-----------------+----------------+
	|         1 | Jason            | CHAMPAGNE       | 1991-02-10      |             15 |
	|         2 | Jason            | CHAMPAGNE       | 1991-02-10      |             15 |
	|         3 | Jason            | CHAMPAGNE       | 1991-02-10      |             15 |
	|         4 | Jason            | CHAMPAGNE       | 1991-02-10      |             15 |
	|         5 | Jason            | CHAMPAGNE       | 1991-02-10      |             15 |
	|         6 | Jason            | CHAMPAGNE       | 1991-02-10      |             15 |
	+-----------+------------------+-----------------+-----------------+----------------+
	6 rows in set (0.00 sec)
```
Voilà comment on pouvait du coup faire des enregistrements massif sans devoir encore une fois faire une requête pour chaque enregistrement ce qui serait vraiment très lourd donc si vous devez enregistrer plusieurs informations à la fois vous n'en fait qu'une seule vous pouvez faire ça via une seule requête c'est bien plus optimisée donc voilà comment vous pouviez tout simplement enregistrer de nouvelles informations dans une table en sql.

Pour la prochaine vidéo histoire de faire de pas faire des trucs trop long et que ce soit bien bien répartis on verra comment modifier certains éléments de nos tables et comment supprimer aussi des éléments et donc notamment la suppression qui demande un peu d'attention pour ne pas évidemment par exemple supprimer la totalité d'une table sql ce qu est ce qui serait assez dramatique quand on veut par exemple supprimer qu'un seul enregistrement donc on regardera tout ça pour les séances suivantes et je vous dis à bientôt.

N'hésitez pas à ça des questions quoi que ce soit par rapport à cette partie là à laisser des commentaires sous la vidéo et n'hésitez pas également à vous entraîner, je vous passe pas même pas mal de petits fichiers donc n'hésitez pas à tester un petit peu tout ce que vous avez vu sur les requêtes sql, à tout revoir pour ne rien oublié au fur et à mesure des vidéos qui avance sur cette formation est en du conte se retrouvera pour des nouvelles requêtes déjà pour la séance prochaine.

A bientôt