:label: [FormationVidéo Git](https://github.com/jasonchampagne/FormationVideo) - [Ressource SQL](https://github.com/jasonchampagne/FormationVideo/tree/master/Ressources/SQL)

# SQL
> [DB2](https://www-01.ibm.com/support/docview.wss?uid=swg27023558)
> [MongoDB](https://docs.mongodb.com/manual)
> [MySQL](https://dev.mysql.com/doc/)
> [Oracle Database](https://docs.oracle.com/cd/B19306_01/index.htm)
> [PL/SQL](https://docs.oracle.com/cd/B10501_01/index.htm)
> [PostgreSQL](https://docs.postgresql.fr)
> [SQLite](https://sqlite.org/docs.html)
> [SQL Server](https://docs.microsoft.com/fr-fr/sql)

## [Playlist cours](https://github.com/jasonchampagne/FormationVideo/blob/master/Playlists/sql-cours.md)

||notes de cours|pense-bêtes
-|:-|:-:
|:heavy_check_mark:|[1. Introduction](cours/001_Introduction/note.md)
|:heavy_check_mark:|[2. Installation mysql](cours/002_Installation_mysql/note.md)
|:heavy_check_mark:|[3. Configuration encodage](cours/003_Configuration_encodage/note.md)
|:heavy_check_mark:|[4. Moteur de stockage](cours/004_Moteur_de_stockage/note.md)
|:heavy_check_mark:|[5. Gestion bases](cours/005_Gestion_bases/note.md)
||[6. Tables et données](cours/006_Tables_et_donnees/note.md)
||[7. Contraintes](cours/007_Contraintes/note.md)
||[8. Utilisateurs et privilèges](cours/008_Utilisateurs_et_privileges/note.md)
||[9. Lecture données](cours/009_Lecture_donnees/note.md)
||[10. Filtrer requêtes](cours/010_Filtrer_requetes/note.md)
||[11. Enregistrer données](cours/011_Enregistrer_donnees/note.md)
||[12. Modifier et supprimer](cours/012_Modifier_et_supprimer/note.md)
||[13. Fonctions d'agrégation](cours/013_Fonctions_d_agregation/note.md)
||[14. Grouper résultats](cours/014_Grouper_resultats/note.md)
||[15. Unions et intersections](cours/015_Unions_et_intersections/note.md)
||[16. Sous-requêtes](cours/016_Sous-requetes/note.md)
||[17. Jointures](cours/017_Jointures/note.md)
||[18. Fonctions chaînes de caractères](cours/018_Fonctions_chaines_de_caracteres/note.md)
||[19. Fonctions dates et heures](cours/019_Fonctions_dates_et_heures/note.md)
||[20. Fonctions mathématiques](cours/020_Fonctions_mathematiques/note.md)
||[21. Fonctions de sécurité](cours/021_Fonctions_de_securite/note.md)
||[22. Conclusion](cours/022_Conclusion/note.md)


<!--

# [6. Tables et données](https://www.youtube.com/watch?v=Y_y-RNZApmk)
# [7. Contraintes](https://www.youtube.com/watch?v=b3kbXSOg9ZU)
# [8. Utilisateurs et privilèges](https://www.youtube.com/watch?v=IvOCAobeihs)
# [9. Lecture données](https://www.youtube.com/watch?v=QfN_URkzw94)
# [10. Filtrer requêtes](https://www.youtube.com/watch?v=jLQ7r6a9aiA)
# [11. Enregistrer données](https://www.youtube.com/watch?v=ETBhek3AklE)
# [12. Modifier et supprimer](https://www.youtube.com/watch?v=7gMgsSrFgaw)
# [13. Fonctions d'agrégation](https://www.youtube.com/watch?v=TnPLdAuGCzU)
# [14. Grouper résultats](https://www.youtube.com/watch?v=5RFdXGicu1o)
# [15. Unions et intersections](https://www.youtube.com/watch?v=tIP_bQeFeXg)
# [16. Sous-requêtes](https://www.youtube.com/watch?v=n2y6DZAM_fM)
# [17. Jointures](https://www.youtube.com/watch?v=Qms4XqTtnkA)
# [18. Fonctions chaînes de caractères](https://www.youtube.com/watch?v=oEaLoI3Io90)
# [19. Fonctions dates et heures](https://www.youtube.com/watch?v=hLY7cBnFoPQ)
# [20. Fonctions mathématiques](https://www.youtube.com/watch?v=9Y20_0MQzEE)
# [21. Fonctions de sécurité](https://www.youtube.com/watch?v=VTkhWoQ4QPA)
# [22. Conclusion](https://www.youtube.com/watch?v=TgvBXMaZULk)
-->

>

## [Introduction - Installation mysql](cours/002_Installation_mysql/note.md)

### Windows
[https://dev.mysql.com/downloads/mysql/](https://dev.mysql.com/downloads/mysql/)

```batch
mkdir C:\MyWAMP\mysql\my.ini
```
```ini
	[mysqld]
	basedir=C:/MyWAMP/mysql
	datadir=C:/MyWAMP/mysql/data
```
```sql
cd C:/MyWAMP/mysql/bin
mysqld.exe --defaults-file=C:/MyWAMP/mysql/my.ini --initialize
C:/MyWAMP/mysql/data/hostname.err
mysqld.exe --console
mysql.exe -u root -p
alter user 'root'@'localhost' identified by '';
exit
mysqladmin.exe -u root -p shutdown
```
### GNU-Linux
```sql
sudo apt-get update
sudo apt-get install mysql-server
sudo service mysql start
sudo service mysql restart
sudo service mysql stop
sudo service mysql reload
sudo service mysql force-reload
mysqld --version
```

Lors de la 1e connection (authentification)

```sql
sudo mysql
```
Si nécessaire ...

```sql
SELECT user,authentication_string,plugin,host FROM mysql.user;
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '';
sudo service mysql restart
mysql -u root -p
```
## [Configuration encodage](cours/003_Configuration_encodage/note.md)

### Windows
```ini
C:\MyWAMP\mysql\my.ini

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
```sql
show variables like 'char%';
show variables like 'collation%';
```
### GNU-Linux
```ini
sudo gedit /etc/mysql/mysql.conf.d/mysqld.cnf

	[mysqld]
	character-set-server=utf8mb4
	collation-server=utf8mb4_unicode_ci
	
	[mysql]
	default-character-set=utf8mb4
	
	[client]
	default-character-set=utf8mb4
```
```sql
sudo service mysql start
sudo service mysql reload
mysql -u root -p
show variables  like 'char%';
show variables  like 'collation%';
```
Si nécessaire...
```sql
SET NAMES utf8mb4 COLLATE utf8mb4_unicode_ci;
```
## [Moteur de stockage](cours/004_Moteur_de_stockage/note.md)
```sql
/*
	MyISAM (non transactionnel)
	InnoDB (transactionnel)
	
	MyISAM
	> beaucoup de lectures
	> efficace pour la recherche
	
	InnoDB
	> beaucoup d'écritures
	> sécuriser les données
	> cohérence entre les données (tables)
*/

SHOW ENGINES;
SET default_storage_engine = InnoDB;
C:\MyWAMP\mysql\my.ini
```
```ini
	[mysqld]
	basedir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql
	datadir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql/data
	character-set-server = utf8mb4
	collation-server = utf8mb4_unicode_ci
	default-storage-engine = InnoDB

	[mysql]
	default-character-set = utf8mb4

	[client]
	default-character-set = utf8mb4
```
## [Gestion bases](cours/005_Gestion_bases/note.md)
```sql
SHOW DATABASES;
CREATE DATABASE ``;
CREATE DATABASE IF NOT EXISTS ``;
USE ``; 
DROP DATABASE ``;
```
## [Tables et données](cours/006_Tables_et_donnees/note.md)
```sql

-- 	Commentaire sur une seule ligne
# 	Commentaire sur une seule ligne
/ * Commentaire sur plusieurs 
	lignes * /

SHOW TABLES;
SHOW TABLES FROM ``;
CREATE TABLE ``;
CREATE TABLE IF NOT EXISTS ``;
CREATE TABLE ``
(
	
);
```
Par exemple ...
```sql
	CREATE TABLE `t_users`
	(
		`id_user` SMALLINT,
		`user_name` VARCHAR(65),
		`user_birthday` DATE
		`user_is_subscriber` ENUM(`N`, `Y`)
	);
```
```sql
DESCRIBE ``; -- EXPLAIN / DESC
ALTER TABLE ``

	Par exemple ...
	ALTER TABLE `t_users` ADD `user_points` TINYINT(2);
	ALTER TABLE `t_users` DROP `user_points` TINYINT(2);
	ALTER TABLE `t_users` MODIFY `id_user` SMALLINT;
	ALTER TABLE `t_users` CHANGE `user_birthday` `user_birth` DATE;

DROP TABLE ``;
DROP TABLE IF EXISTS ``;
SHOW TABLE STATUS;
```
## [Contraintes](cours/007_Contraintes/note.md)
```sql
/*
	NOT NULL 		(colonne obligatoire)
	DEFAULT 		(valeur par défaut)
	CHECK 			(vérification d'une valeur)
	UNIQUE			(valeur de champ unique)
	PRIMARY KEY		(clé primaire)
	AUTO_INCREMENT	(incrémentation de 1 en 1)
	
	INDEX			(index - pour la lecture et la recherche)
*/

CREATE TABLE IF NOT EXISTS `table_users`
(
	`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT CHECK(id_user <= 10000),
	`user_name` VARCHAR(30),
	`user_email` VARCHAR(100) NOT NULL,
	`user_registration` DATE NOT NULL,
	`user_admin` BOOLEAN DEFAULT 0,
	
	PRIMARY KEY(`id_user`),
	UNIQUE(`user_name`)
)
ENGINE = MyISAM CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `table_news`
(
	`id_news` SMALLINT(6) NOT NULL AUTO_INCREMENT,
	`news_title` VARCHAR(80) NOT NULL,
	`news_content` TEXT NOT NULL,
	`news_author` SMALLINT(6) NOT NULL,
	
	PRIMARY KEY(`id_news`),
	FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`)
);

ALTER TABLE `table_users` MODIFY `user_name` VARCHAR(30) NOT NULL;
ALTER TABLE `table_users` ALTER `user_admin` SET DEFAULT 0;
ALTER TABLE `table_users` DROP `user_admin` DEFAULT 0;
ALTER TABLE `table_users` ADD CHECK(id_user <= 10000);
ALTER TABLE `table_users` ADD CONSTRAINT CHK_idtoobig CHECK(id_user <= 10000 AND user_admin > 1);
ALTER TABLE `table_users` DROP CHECK CHK_idtoobig;
ALTER TABLE `table_users` ADD UNIQUE(`user_name`);
ALTER TABLE `table_users` ADD CONSTRAINT UC_userid UNIQUE(`id_user`, `user_name`);
ALTER TABLE `table_users` DROP INDEX UC_userid;
ALTER TABLE `table_users` AUTO_INCREMENT = 100;
ALTER TABLE `table_users` ADD PRIMARY KEY(`user_name`);
ALTER TABLE `table_users` ADD CONSTRAINT PK_ident PRIMARY KEY(`id_user`, `user_name`);
ALTER TABLE `table_users` DROP PRIMARY KEY;
ALTER TABLE `table_news` ADD FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`);
ALTER TABLE `table_news` ADD CONSTRAINT FK_jesaispasquoi FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`);
ALTER TABLE `table_news` DROP FOREIGN KEY `FK_jesaispasquoi`;
CREATE INDEX `idx_users` ON `table_users`(`user_name`, `user_email`);
ALTER TABLE `table_users` DROP INDEX `idx_users`;
```
[Exemples selon le SGBD](https://www.w3schools.com/SQL/sql_check.asp)
```sql
DESCRIBE ``; -- EXPLAIN / DESC
SHOW TABLES;
SHOW TABLE STATUS FROM `basename`;
EXPLAIN `tablename` `fieldname`;
```
## [Utilisateurs et privilèges](cours/008_Utilisateurs_et_privileges/note.md)
```sql
SHOW DATABASES;
SELECT USER FROM mysql.user;
SELECT current_user();
CREATE USER IF NOT EXISTS 'jachampagne'@'localhost' IDENTIFIED BY 'passe';
ALTER USER 'jachampagne'@'localhost' IDENTIFIED BY 'new';
RENAME USER 'jachampagne'@'localhost' TO 'jason'@'localhost';
DROP USER 'jason'@'localhost';
GRANT CREATE TABLE ON cours_sql.* TO 'jachampagne'@'localhost';
GRANT SELECT ON cours_sql.* TO 'jachampagne'@'localhost';
GRANT ALL ON cours_sql.* TO 'jachampagne'@'localhost';
GRANT ALL ON cours_sql.* TO 'jachampagne'@'localhost' WITH GRANT OPTION;
REVOKE ALL ON cours_sql.* TO 'jachampagne'@'localhost';
REVOKE CREATE TABLE ON cours_sql.* TO 'jachampagne'@'localhost';
```
## [Lecture données](cours/009_Lecture_donnees/note.md)
```sql
SOURCE C:/MyWAMP/mysql/data1.sql
SELECT product_name FROM fv_products;
SELECT product_name, product_amount FROM fv_products;
SELECT * FROM fv_products;
SELECT * FROM fv_users;
SELECT product_name FROM fv_products;
SELECT DISTINCT product_name FROM fv_products;
SELECT product_name aliasname FROM fv_products;
SELECT product_name AS pN FROM fv_products;
SELECT product_name AS Nom_du_produit FROM fv_products;
SELECT product_name AS "Nom du produit" FROM fv_products;
SELECT product_name AS "Nom du produit" FROM fv_products AS Inventory;
```
## [Filtrer requêtes](cours/010_Filtrer_requetes/note.md)
```sql
SOURCE C:/MyWAMP/mysql/data2.sql
/*
	= égalité
	!= différence
	> < <= >=
	
	AND, OR
	IN,BETWEEN, LIKE, IS NULL, IS NOT NULL
*/
SELECT *FROM fv_games WHERE id_game = 11;
SELECT *FROM fv_games WHERE id_game > 5;
SELECT *FROM fv_games WHERE id_game = 5 OR id_game = 10;
SELECT *FROM fv_games WHERE game_price > 5 AND game_price < 30;
SELECT * FROM fv_games WHERE game_stock=2 OR game_stock=4 OR game_stock=6;
	SELECT * FROM fv_games WHERE game_stock IN(2, 4, 6);
	SELECT * FROM fv_games WHERE game_stock IN('2', '4', '6');
SELECT * FROM fv_games WHERE game_price > 0 AND game_price <= 20;
	SELECT * FROM fv_games WHERE game_price BETWEEN 0 AND 20;
SELECT * FROM fv_games WHERE game_title LIKE 'Pokémon%';
SELECT * FROM fv_games WHERE game_title LIKE '%Pokémon%';
SELECT * FROM fv_games WHERE game_title LIKE 'Tekken%';
SELECT * FROM fv_games WHERE game_title LIKE 'Tekken_';
SELECT * FROM fv_games WHERE game_price IS NOT NULL;
SELECT * FROM fv_games WHERE game_price IS NULL;
SELECT * FROM fv_games ORDER BY game_title;
SELECT * FROM fv_games ORDER BY game_title ASC;
SELECT * FROM fv_games ORDER BY game_title DESC;
SELECT * FROM fv_games ORDER BY game_title, game_price DESC;
SELECT * FROM fv_games LIMIT 5;
```
```
(!) Syntaxe différente suivant le SGBD utilisé (!)
	LIMIT (MySQL, PostgreSQL)
	TOP (SQL Server, MS Access)
	ROWNUM (Oracle)
```
```sql
SELECT * FROM fv_games LIMIT 5 OFFSET 3;
SElECT * FROM fv_games LIMIT 3, 5;
```
## [Enregistrer données](cours/011_Enregistrer_donnees/note.md)
```sql
SOURCE C:/MyWAMP/mysql/data3.sql

INSERT INTO `fv_clients`(client_firstname, client_lastname, client_birthday, client_loyalty)
VALUES('Jason', 'CHAMPAGNE', '1991-02-10', 15);

INSERT INTO `fv_clients`(client_firstname, client_lastname, client_birthday, client_loyalty)
VALUES
('Jason', 'CHAMPAGNE', '1991-02-10', 15),
('Jason', 'CHAMPAGNE', '1991-02-10', 15),
('Jason', 'CHAMPAGNE', '1991-02-10', 15),
('Jason', 'CHAMPAGNE', '1991-02-10', 15),
('Jason', 'CHAMPAGNE', '1991-02-10', 15);
```
## [Modifier et supprimer](cours/012_Modifier_et_supprimer/note.md)
```sql
/*
	CRUD
	
	C : create (INSERT TO)
	R : read (SELECT)
	U : update (UPDATE)
	D : delete (DELETE)
*/

SOURCE C:/MyWAMP/mysql/data2.sql
UPDATE fv_games SET game_stock = 6, game_price = 11.59 WHERE id_game = 1;
UPDATE fv_games SET game_stock = 6, game_price = 11.59;
DELETE FROM fv_games WHERE game_title = 'Tekken';
DELETE FROM fv_games;
TRUNCATE TABLE fv_games;
```
## [Fonctions d'agrégation](cours/013_Fonctions_d_agregation/note.md)
```sql
SOURCE C:/MyWAMP/mysql/data2.sql
SELECT COUNT(*) FROM fv_games;
SELECT COUNT(*) AS Total_jeu FROM fv_games;
SELECT AVG(game_price) FROM fv_games;
SELECT MAX(game_price) FROM fv_games;
SELECT MIN(game_price) FROM fv_games;
SELECT SUM(game_stock) FROM fv_games;
```
## [Grouper résultats](cours/014_Grouper_resultats/note.md)
```sql
SOURCE C:/MyWAMP/mysql/data4.sql
SELECT COUNT(*) FROM fv_users WHERE user_country = 'FRANCE';
SELECT COUNT(*), user_country FROM fv_users WHERE user_country = 'FRANCE';
SELECT COUNT(*), user_country FROM fv_users GROUP BY user_country;
SELECT COUNT(*) AS 'Nombre de résidents', user_country FROM fv_users GROUP BY user_country;
SELECT user_country, sum(user_age) FROM fv_users GROUP BY user_country WITH ROLLUP;
SELECT user_country, SUM(user_age) FROM fv_users GROUP BY user_country HAVING SUM(user_age) > 20;
SELECT user_country, SUM(user_age) FROM fv_users GROUP BY user_country HAVING SUM(user_age) > 50;
```
## [Unions et intersections](cours/015_Unions_et_intersections/note.md)
```sql
SOURCE C:/MyWAMP/mysql/data5.sql

SELECT * FROM fv_site1_users
UNION
SELECT * FROM fv_site2_users;

SELECT user_name FROM fv_site1_users
UNION
SELECT user_name FROM fv_site2_users;

SELECT user_name FROM fv_site1_users
UNION ALL
SELECT user_name FROM fv_site2_users;
```
Non dispo sur MySQL ...
```
	SELECT user_name FROM fv_site1_users
	INTERSECT
	SELECT user_name FROM fv_site2_users;

	SELECT user_name FROM fv_site1_users
	MINUS / EXCEPT
	SELECT user_name FROM fv_site2_users;
```
```sql
SELECT user_name FROM fv_site1_users
UNION
SELECT user_name FROM fv_site2_users
ORDER BY user_name;

SELECT user_name, user_country FROM fv_site1_users
UNION
SELECT user_name, user_country FROM fv_site2_users
ORDER BY user_name;
```
## [Sous-requêtes](cours/016_Sous-requetes/note.md)
```sql
SOURCE C:/MyWAMP/mysql/data6.sql

SELECT * FROM fv_players
WHERE player_name =
(
	SELECT playertrade_seller
	FROM fv_playertrades
	WHERE playertrade_seller = 'Icekissy'
	LIMIT 1
);

SELECT * FROM fv_players
WHERE player_name =
(
	SELECT playertrade_seller
	FROM fv_playertrades
	WHERE playertrade_seller = 'Nephion'
	LIMIT 1
);

SELECT * FROM fv_players
WHERE player_name IN
(
	SELECT playertrade_seller
	FROM fv_playertrades
	WHERE playertrade_seller = 'Icekissy'
);

SELECT * FROM fv_players
WHERE player_name IN
(
	SELECT playertrade_seller
	FROM fv_playertrades
);

SELECT * FROM fv_players
WHERE player_name = ANY
(
	SELECT playertrade_seller
	FROM fv_playertrades
);

SELECT * FROM fv_players
WHERE player_name = ANY
(
	SELECT playertrade_seller
	FROM fv_playertrades
	WHERE playertrade_item = 'Épée en mousse'
);
```
Alias ...
```
	SELECT * FROM fv_players
	WHERE player_name = SOME
	(
		SELECT playertrade_seller
		FROM fv_playertrades
		WHERE playertrade_item = 'Épée en mousse'
	);
```
```sql
SELECT * FROM fv_players
WHERE EXISTS
(
	SELECT *
	FROM fv_playertrades
	WHERE playertrade_item = 'Épée en mousse'
);

SELECT * FROM fv_players
WHERE EXISTS
(
	SELECT *
	FROM fv_playertrades
	WHERE playertrade_item = 'Épée en mousse'
) AND player_level > 10;

SELECT * FROM fv_players
WHERE EXISTS
(
	SELECT *
	FROM fv_playertrades
	WHERE playertrade_item = 'Épée en mousse'
) AND player_level > 10
ORDER BY player_level ASC;

SELECT * FROM fv_players
WHERE EXISTS
(
	SELECT *
	FROM fv_playertrades
	WHERE playertrade_item = 'Épée en bois'
) AND player_level > 10
ORDER BY player_level ASC;
```
## [Jointures](cours/017_Jointures/note.md)
```sql
SOURCE C:/MyWAMP/mysql/data7.sql

/*
	(fv_players) player_ability <------> id_ability (fv_abilities)
	
	(fv_playertrades) playertrade_item <----> id_item (fv_items)
*/

SELECT player_name, player_level, ability_name
FROM fv_players
INNER JOIN fv_abilities ON fv_players.player_ability = fv_abilities.id_ability;

SELECT player_name, player_level, ability_name
FROM fv_players, fv_abilities
WHERE fv_players.player_ability = fv_abilities.id_ability;

SELECT player_name, player_level, ability_name
FROM fv_players
INNER JOIN fv_abilities ON fv_players.player_ability = fv_abilities.id_ability
WHERE player_level > 10;

SELECT *
FROM fv_abilities
LEFT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability;

SELECT *
FROM fv_abilities
INNER JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability;

SELECT *
FROM fv_abilities
LEFT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability
WHERE fv_players.player_ability IS NULL;

SELECT ability_name
FROM fv_abilities
RIGHT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability
WHERE fv_players.player_ability IS NULL;

SELECT item_name
FROM fv_items
LEFT JOIN fv_playertrades ON fv_items.id_item = fv_playertrades.playertrade_item;

SELECT item_name
FROM fv_items
INNER JOIN fv_playertrades ON fv_items.id_item = fv_playertrades.playertrade_item;

SELECT item_name
FROM fv_items
LEFT JOIN fv_playertrades ON fv_items.id_item = fv_playertrades.playertrade_item
WHERE fv_playertrades.playertrade_item IS NULL;
```
Non dispo sur MySQL ...
```
	SELECT item_name
	FROM fv_items
	FULL JOIN fv_playertrades ON fv_items.id_item = fv_playertrades.playertrade_item
```
```sql
SELECT *
FROM fv_players
CROSS JOIN fv_abilities;

SELECT *
FROM fv_players
CROSS JOIN fv_abilities
ORDER BY player_name;
```
## [Fonctions chaînes de caractères](cours/018_Fonctions_chaines_de_caracteres/note.md)
```sql
/*
	(fv_carbrands) carbrand_country <--------> country_code (fv_countries)
*/

-- MySQL, Oracle Database, PostgreSQL, SQLite, MS SQL Server

-- Nombre de caractères d'une chaîne
SELECT carbrand_name, char_length(carbrand_name) FROM fv_carbrands;

-- Concaténation de chaîne
SELECT CONCAT(carbrand_name, ' (', carbrand_country, ')') FROM fv_carbrands;

-- Conversion en minuscule / majuscule
SELECT UPPER(carbrand_name) FROM fv_carbrands;
SELECT LOWER(carbrand_name) FROM fv_carbrands;

-- Inversion de chaîne
SELECT REVERSE(carbrand_name) FROM fv_carbrands;

-- Suppression d'espaces blancs
SELECT TRIM(carbrand_name) FROM fv_carbrands;
SELECT TRIM('bonjour');
SELECT TRIM('    bonjour     d');
SELECT TRIM('    bonjour     ');

-- Remplacement d'une chaîne
UPDATE fv_carbrands
SET carbrand_website = REPLACE(carbrand_website, 'group', 'groupe')
WHERE carbrand_name = 'Renault';

UPDATE fv_carbrands
SET carbrand_website = REPLACE(carbrand_website, 'groupe', 'group')
WHERE carbrand_name = 'Renault';

-- Position d'une occurence dans une chaîne
SELECT LOCATE('y', carbrand_name) FROM fv_carbrands;
SELECT carbrand_name, LOCATE('y', carbrand_name) FROM fv_carbrands;
SELECT carbrand_name, LOCATE('yo', carbrand_name) FROM fv_carbrands;

-- Extraction d'une sous-chaîne
SELECT carbrand_name, SUBSTR(carbrand_name, 2) FROM fv_carbrands;
SELECT SUBSTR('bonjour', 2);
SELECT carbrand_name, SUBSTRING(carbrand_name, 2, 2) FROM fv_carbrands;
SELECT carbrand_name, SUBSTRING(carbrand_name, 2, 3) FROM fv_carbrands;
```
## [Fonctions dates et heures](cours/019_Fonctions_dates_et_heures/note.md)
```sql
SELECT NOW();
	SELECT SYSDATE() 	-- Oracle
	DATE('now')			-- PostgreSQL
	GETDATE() 			-- Oracle, SQL Server

INSERT INTO ''
VALUES
('bonjour', 'Tom', NOW());

INSERT INTO ''
VALUES
('bonjour', 'Tom', '2020-02-13');

SELECT DAY('2020-02-13');
SELECT MONTH('2020-02-13');
SELECT YEAR('2020-02-13');
SELECT HOUR('2020-02-13 15:12:30');
SELECT MINUTE('2020-02-13 15:12:30');
SELECT SECOND('2020-02-13 15:12:30');
	EXTRACT(MONTH FROM TIMESTAMP '2020-03-15')	-- Oracle et pe PostgreSQL

SELECT DATEDIFF('2020-02-17', '2019-11-16');
	SELECT AGE('2020-02-17', '2019-11-16');		-- PostgreSQL
	SELECT TIMESTAMPDIFF();						-- Oracle

SELECT TIMESTAMPDIFF(DAY, '2020-03-15', '2020-05-16');

SELECT DATE_FORMAT('2020-12-06 14:07:23', 'Le %d/%m/%Y, à %H:%i:%S');	-- MySQL
	-- Oracle & PostgreSQL
	TO_CHAR(<date>, <format>) -> DD/MM/YYYY HH24:MI:SS
	-- SQLite
	STRFTIME(<format>, <date>)
	-- SQL Server
	FORMAT(<date>, <format>)  -> dd/MM/yyyy
```
## [Fonctions mathématiques](cours/020_Fonctions_mathematiques/note.md)
```sql
SELECT ABS(-1) FROM dual;
SELECT ABS(-1);
-- COS(), SIN(), TAN(), ACOS(), ASIN(), ATAN()
SELECT COS(PI());
SELECT PI();
SELECT PI() + 0.00000000;
SELECT RADIANS(60);
SELECT DEGREES(1.0471975511965976);
SELECT CEIL(14.26334);
SELECT FLOOR(14.26334);
SELECT ROUND(14.26334);
SELECT ROUND(14.26334, 3);
SELECT ROUND(14.26364, 3);
SELECT TRUNCATE(14.26364, 3);
SELECT TRUNCATE(14.26364, 2);
SELECT POW(2, 3);
SELECT CONV(145, 10, 2);
SELECT EXP(2);
SELECT LOG(2, 10);
/*
	Oracle Database
	---------------
	Logarithme népérien	LN(n)
	Logarithme en base	LOG(base, n)
	
	MySQL
	-----
	Alias de log()			LN(n)
	Logarithme népérien		LOG(n)
							LOG(n, base)
	Logarithme en base 2	LOG2(n)
	Logarithme en base 10	LOG10(n)
*/
SELECT SQRT(4);
SELECT CBRT(4);

/*
	+ - * / %
	5 % 2 = 1
*/
SElECT MOD(5, 2);
SELECT 5 % 2;
SELECT 5 MOD 2;
SELECT RAND();
SELECT RAND(15);
```
## [Fonctions de sécurité](cours/021_Fonctions_de_securite/note.md)
```sql
/*
	> Chiffrement 	: (donnée en clair) -> clé -> (donnée chiffré)
	> Hashage 		: (donnée en clair) -> (hash)
	
	N bits = N/4 caractères
*/

-- MD5('Bonjour') -> 128 bits (32 caractères) char(32)
SELECT MD5('bonjour');
SELECT SHA1('bonjour');

-- MySQL : SHA2 -> 224 bits, 256 bits, 384 bits, 512 bits.
SELECT SHA2('bonjour', 256);
SELECT SHA2('bonjour', 224);
SELECT SHA2('bonjour', 384);
SELECT SHA2('bonjour', 512);

	-- PostgreSQL
	-- Algorithmes de hash disponibles : md5, sha1, sha224, sha256, sha384, sha512
	DIGEST('bonjour','mb5');
	DIGEST('bonjour','sha1');
	DIGEST('bonjour','sha256');
	
	-- Oracle DATABASE
	STANDARD_HASH('bonjour', 'MD5');
	
	-- SQL Server
	HASHBYTES('MD4', 'bonjour');
	HASHBYTES('SHA2_256', 'bonjour');
	
	-- SQLite
	None

--MySQL
SELECT AES_ENCRYPT('bonjour', 'secret');

SET @passw = AES_ENCRYPT('bonjour', 'secret');
SELECT @passw;
SET @text = cast(AES_DECRYPT(@passw, 'secret') AS char);
SELECT @text;
```
## [Conclusion](cours/022_Conclusion/note.md)
/