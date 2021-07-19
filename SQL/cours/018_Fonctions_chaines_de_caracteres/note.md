# [18. Fonctions chaînes de caractères](https://www.youtube.com/watch?v=oEaLoI3Io90)
04-01-2020

Bonjour à tous on se retrouve pour une 18e vidéo en sql.

On va voir ensemble pour terminer en tout cas cette formation pas mal de fonctions sur différentes catégories et pour cette vidéo nous allons voir les fonctions qui sont attachés aux chaînes de caractères.

Vous allez pouvoir effectuer certains traitements sur ces chaînes que vous avez donc dans des colonnes de table dans vos bases de données, je vais vous en présenter quelques-unes.

Alors pour les vidéos qui vont venir et qui terminerons le cours sql, la petite particularité c'est que vous allez vous vite vous rendre compte que certaines fonctions ne sont pas en fait supporté par tous les systèmes de gestion de bases de données.

En vidéo je vous montrerai bien sûr les fonctions que vous allez pouvoir utiliser avec mysql.

Je vous parlerais évidemment de fonctions qui sont supportés par d'autres systèmes de gestion et vous pouvez retrouver dans la description de la vidéo en plus du fichier data8.sql qui est un petit fichier de base de données que je vais vous montrez très rapidement, vous pourrez également dans la description avoir un lien vers mon github où vous aurez en fait des tableaux avec les différentes fonctions sur les chaînes de caractères que vous pouvez retrouver.

Si vous travaillez je sais pas moi avec sql server microsoft avec sqlite, postgressql ou même oracle database vous pourrez adapter en fonction les fonctions utilisées sur ces différents systèmes parce que ces fonctions ne sont pas compatibles forcément avec tous.

On va pouvoir passer dans le vif du sujet pour la réalisation en tout cas de cette vidéo, je vous ai fait un petit fichier beaucoup plus léger que ce qu'on avait vu précédemment.

+ data8.sql
```sql
	DROP DATABASE IF EXISTS `fv_database`;
	CREATE DATABASE IF NOT EXISTS `fv_database`;
	USE `fv_database`;


	CREATE TABLE IF NOT EXISTS `fv_carbrands`
	(
		`id_carbrand` INT NOT NULL AUTO_INCREMENT, 
		`carbrand_name` VARCHAR(30) NOT NULL UNIQUE, 
		`carbrand_country` CHAR(2) NOT NULL, 
		`carbrand_website` VARCHAR(255) NOT NULL UNIQUE, 
		PRIMARY KEY(`id_carbrand`)
	);

	CREATE TABLE IF NOT EXISTS `fv_countries`
	(
		`id_country` INT NOT NULL AUTO_INCREMENT, 
		`country_code` CHAR(2) NOT NULL UNIQUE, 
		`country_name` VARCHAR(25) NOT NULL UNIQUE, 
		PRIMARY KEY(`id_country`)
	);


	INSERT INTO `fv_countries`(`country_code`, `country_name`)
	VALUES
	('FR', 'France'), 
	('JP', 'Japon'), 
	('DE', 'Allemagne'), 
	('IT', 'Italie'), 
	('KR', 'Corée');

	INSERT INTO `fv_carbrands`(`carbrand_name`, `carbrand_country`, `carbrand_website`)
	VALUES
	('Mazda', 'JP', 'https://www.mazda.fr/'), 
	('Peugeot', 'FR', 'https://www.peugeot.fr/accueil.html'), 
	('Renault', 'FR', 'https://group.renault.com/'), 
	('Audi', 'DE', 'https://www.audi.com/en.html'), 
	('Toyota', 'JP', 'https://global.toyota/en/'), 
	('Ferrari', 'IT', 'https://www.ferrari.com/fr-FR'), 
	('Hyundai', 'KR', 'http://www.hyundaigroup.com/'), 
	('Nissan', 'JP', 'https://www.nissan-global.com/EN/index.html'), 
	('BMW', 'DE', 'https://www.bmwgroup.com/de.html'), 
	('Lamborghini', 'IT', 'https://www.lamborghini.com/en-en/');
```
On a principalement ici notre notre base de données ça ça change pas. On a une petite table qui va créer en fait des marques de voitures tout simplement des marques automobiles et on a une table qui va représenter des pays (fv_carbrands), on a le code d'un pays par exemple fr pour la france, jp pour le japon et là pour les marques de voitures on a simplement son nom on a le pays dans lequel elle est originaire donc c'est une clé étrangères par rapport à ça.
```txt
	fv_carbrands				fv_countries
	------------				------------
	carbrand_country <-------->	country_code
```
En gros par rapport aux codes qu'on a ici (fv_carbrands) et on a un site web (carbrand_website) donc ça va être utile parce qu'on va travailler sur des chaînes voyez qu'on retrouve chaînes de caractères VARCHAR(30) et ici un petit code en deux caractères CHAR(2) et là une chaîne de caractères VARCHAR(255) pour le site web donc ça tombe bien ce sera l'idéal par rapport aux fonctions que je veux vous montrer.

A partir de là quelques codes évidemment deux pays sont ajoutés (fv_countries), quelques marques de voitures aussi (fv_carbrands).

A partir de là en récupérant ce fichier depuis la description de la vidéo vous pourrez tester les fonctions sur les chaînes de caractères de votre côté.

On va passer directement à l'import de ce ficher dans mon mysql.

Normalement mysqld est lancé, il n'y a plus qu'a lancé le client de mon côté hop et on va directement copier coller voilà.
```sql
	> mysqld --console
	> mysql -u root -p
	mysql> SOURCE C:/SQL/cours/018_Fonctions_chaines_de_caracteres/data8.sql;
```
Vérifier que tout est bon très rapidement.
```sql
	mysql> use fv_database;
	Database changed
	
	mysql> show tables;
	+-----------------------+
	| Tables_in_fv_database |
	+-----------------------+
	| fv_carbrands          |
	| fv_countries          |
	+-----------------------+
	2 rows in set (0.01 sec)
```
Je ne fait pas describe car j'ai pas fait de contraintes, rien du tout donc ça n'a pas d'intérêt par rapport à ce que je vous montre dans cette vidéo mais le plus important c'est surtout d'avoir des données sur lesquelles travailler.
```sql
	mysql> select * from fv_carbrands;
	+-------------+---------------+------------------+---------------------------------------------+
	| id_carbrand | carbrand_name | carbrand_country | carbrand_website                            |
	+-------------+---------------+------------------+---------------------------------------------+
	|           1 | Mazda         | JP               | https://www.mazda.fr/                       |
	|           2 | Peugeot       | FR               | https://www.peugeot.fr/accueil.html         |
	|           3 | Renault       | FR               | https://group.renault.com/                  |
	|           4 | Audi          | DE               | https://www.audi.com/en.html                |
	|           5 | Toyota        | JP               | https://global.toyota/en/                   |
	|           6 | Ferrari       | IT               | https://www.ferrari.com/fr-FR               |
	|           7 | Hyundai       | KR               | http://www.hyundaigroup.com/                |
	|           8 | Nissan        | JP               | https://www.nissan-global.com/EN/index.html |
	|           9 | BMW           | DE               | https://www.bmwgroup.com/de.html            |
	|          10 | Lamborghini   | IT               | https://www.lamborghini.com/en-en/          |
	+-------------+---------------+------------------+---------------------------------------------+
	10 rows in set (0.00 sec)

	mysql> select * from fv_countries;
	+------------+--------------+--------------+
	| id_country | country_code | country_name |
	+------------+--------------+--------------+
	|          1 | FR           | France       |
	|          2 | JP           | Japon        |
	|          3 | DE           | Allemagne    |
	|          4 | IT           | Italie       |
	|          5 | KR           | Corée        |
	+------------+--------------+--------------+
	5 rows in set (0.00 sec)
```
Nous avons toutes les informations parfait on va pouvoir travailler là dessus.

Les fonctions sont utilisables directement au sein de vos requêtes par exemple quand on fait un select qui va permettre de récupérer des données bien précises, vous pouvez si vous le voulez appliquer des fonctions.

On avait déjà vu dans une séance des fonctions d'agrégation par exemple pour calculer des moyennes, des sommes, pour compter le nombre d'enregistrements de quelque chose, voilà on a eu déjà abordé quelques petites fonctions et là on passe à des fonctions dans un autre domaine qui concerne en particulier les chaînes de caractères.

Pour des raisons évidentes je ne vais pas vous présenter toutes les fonctions qui existe parce qu'il y en a plein et puis ça c'est la vidéo concernant les fonctions sur les chaînes mais on va également par la suite voir quelques fonctions mathématiques.

On verra des fonctions liées à la sécurité, des fonctions liées aux dates et aux horraires d'accord sur une tout ce qui est date et heure parce qu'il ya pas mal de choses également à voir là dessus au niveau de sql donc je vais vous présenter celles qui seront très certainement les plus intéressantes pour vous que vous aurez certainement besoin de connaître et bien évidemment il faudra pas hésiter à les voir dans les tableaux que je vous fournis en descriptions de vidéos pour d'autres fonctions que je n'aurais pas forcément abordé en vidéo dans le détail et également pourquoi pas dans les documentations respectives du système de gestion de base de données que vous utilisez vous trouverez bien sûr tout de manière complète au niveau des fonctions, éventuellement de leur usage ou de certains à alias et cetera donc il y a pas mal de choses comme ça connaître.

Pour le moment au niveau de ce que nous allons faire ici, on va commencer par une fonction toute simple qui est un peu logique finalement qu'on retrouve même d'ailleurs dans des langages de programmation, ce sont des choses que vous avez l'habitude de manipuler si vous programmez c'est par exemple de récupérer le nombre de caractères d'une chaîne alors là effectivement pour la base de données tel que j'ai fait ici on n'a pas tellement d'intérêt par exemple de dire bien dans le mot mazda combien il y a de caractère d'accord mais c'est évidemment une base de données que je vous ai que je vous ai proposé pour avoir des exemples sur lesquels vous pouvez travailler.

Alors ce qu'on peut faire directement c'est justement ce que je viens de dire là on va compter le nombre de caractères.

Alors on va afficher carbrand_name donc ça c'est le nom de la marque et on va ensuite faire tout simplement un char_length() alors je met tout en minuscule mais évidemment vous pouvez le marquer en majuscule si vous voulez pour les noms de fonctions et char_length() de cette colonne carbrand_name.
```sql
	SELECT carbrand_name, char_length(carbrand_name);
```
Donc char_length() c'est la fonction propre à mysql qui va permettre de compter le nombre de charactères.

Vous pouvez mettre character_length() également qui est un alias et pour d'autres systèmes de gestion de bases de données si cette fonction n'est pas disponible, vous avez notamment cette fonction là, length(). Alors je crois que c'est pour oracle et postgressql qui prend en compte mais postgressql prend aussi en compte length() il me semble.

Vous avez length() et pour sql server de microsoft c'est len() tout simplement à rejoindre d'ailleurs un petit peu le genre de fonction qu'on retrouve en console quand on fait du powershell pour ceux qui en font un petit peu donc attention au niveau des fonctions, je vous montre en majorité sur mysql mais n'oubliez pas que le cours que je vous propose est fait justement pour qu'il soit adaptable et utilisable pour n'importe quel système de gestion c'est pour ça que le cours s'appelle sql et pas seulement mysql ou autre chose.

Je voulais faire le cours le plus général possible donc il faudra adapter si vous voyez que char_length() de votre côté ne fonctionne pas il faudra voir encore une fois depuis la description de la vidéo par rapport aux liens que je vous ai mis quelle fonction peut faire la même chose sur votre système si par exemple vous vous servez d'autres choses que mysql ou d'un système qui ne supporteraient pas ces mêmes noms de fonction.

Donc char_length(), on va reprendre directement ça puis évidemment from fv_carbrands, un point virgule et là on va récupérer l'information.
```sql
SELECT carbrand_name, char_length(carbrand_name)
from fv_carbrands;
```
```sql
	mysql> SELECT carbrand_name, char_length(carbrand_name)
		-> from fv_carbrands;
	+---------------+----------------------------+
	| carbrand_name | char_length(carbrand_name) |
	+---------------+----------------------------+
	| Audi          |                          4 |
	| BMW           |                          3 |
	| Ferrari       |                          7 |
	| Hyundai       |                          7 |
	| Lamborghini   |                         11 |
	| Mazda         |                          5 |
	| Nissan        |                          6 |
	| Peugeot       |                          7 |
	| Renault       |                          7 |
	| Toyota        |                          6 |
	+---------------+----------------------------+
	10 rows in set (0.01 sec)
```
Très simple pour le coup l'usagé-e est simple et là ça va compter en fait le nombre de caractère du nom de la marque automobile tout simplement. On voit dans Nissan, il y a 6 caractères, dans Mazda il y en a 5, dans Lamborghini il y en a 11 bref pas besoin de vous expliquer tout ça en détail vous l'avez bien compris.

Donc ça c'est un premier exemple compter le nombre de caractère, on a ça char_length() ou éventuellement character_length() qui est un alias en fait simplement qui s'écrit un peu plus long c'est éventuellement plus rapide de faire comme ça char_length() et vous avez dans d'autres systèmes gestion vous avez length() comme je l'ai dis et pour sql server vous avez len() voilà en fonction il faudra l'adapter par rapport au nom de la fonction qui est supporté par le sgbd ça c'est un début.

Autre chose qui peut être intéressant de faire sur des chaînes c'est de la concaténation alors là pareil, il y aura pas l'exemple que je vais vous montrez ne nous sera pas énormément utile pour le coup c'est vraiment pour comprendre un peu comment ça fonctionne pour faire de la concaténation.

La concaténation si jamais vous ne savez pas ce que c'est, par exemple si on a une information du genre du "bonjour" et qu'on a une autre chaîne qui est "tout le monde" on peut parfaitement concatener ces 2 chaînes pour obtenir "bonjour ... un espace d'accord ... tout le monde" donc là on aura la concaténation de la chaîne bonjour, un espace blanc d'accord un espace que vous faites sur votre clavier et ensuite la chaîne tout le monde, ça fait donc une concaténation de trois chaînes qui produiront cette chaîne finale.
```txt
	"bonjour"
	"tout le monde"
	
	-> "bonjour tout le monde"
```
Pour faire ça nous avons la fonction concat() alors on va faire que ça affiche le nom de la marque, un espace, on pourrait même mettre entre parenthèses si on veut par exemple afficher ça. On peut s'amuser à faire ça.

Voilà comment on va faire cette information, on va garder par contre la même table ici, on va faire concat() dans le quel vous mettez en fait chacune des chaînes que vous concatener comme paramètre en fait, comme argument ici de votre fonction donc la première chose concat() de carbrand_name.
```sql
	select concat(carbrand_name, )
	from fv_carbrands;
```
On peut sans problème mettre des chaînes de caractères en dur il n'y a pas de souci donc là c'est ce que je vais faire je met par exemple une parenthèse même un espace et une parenthèse ' (' voilà ensuite je concatène avec carbrand_country comme nom de colonnes et ensuite je concatène avec une autre parenthèse ')' voilà.
```sql
SELECT CONCAT(carbrand_name, ' (', carbrand_country, ')')
FROM fv_carbrands;
```
On va faire ça.
```sql
	mysql> SELECT CONCAT(carbrand_name, ' (', carbrand_country, ')')
		-> FROM fv_carbrands;
	+----------------------------------------------------+
	| CONCAT(carbrand_name, ' (', carbrand_country, ')') |
	+----------------------------------------------------+
	| Mazda (JP)                                         |
	| Peugeot (FR)                                       |
	| Renault (FR)                                       |
	| Audi (DE)                                          |
	| Toyota (JP)                                        |
	| Ferrari (IT)                                       |
	| Hyundai (KR)                                       |
	| Nissan (JP)                                        |
	| BMW (DE)                                           |
	| Lamborghini (IT)                                   |
	+----------------------------------------------------+
	10 rows in set (0.00 sec)
```
Voilà comment la concaténation c'est fait, voyez on peut parfaitement concaténer soit avec des colonnes directement si vous faites la programmation encore une fois ça comme si vous aviez en fait du remplacement comme on aurait avec des variables en programmation et on peut noter directement nous mêmes voilà des chaînes comme ça en dur dans la requête et ça qu'on concatène sans problème l'ensemble de tout de ce que vous avez ici.

Très  simple à utiliser, pour d'autres systèmes de gestion également, ils se sont dit plutôt que de faire une fonction pour faire de la concaténation de chaîne nous on va carrément proposer un opérateur pour le faire.

Par exemple sur postgressql vous pouvez avoir par exemple pour faire ceci :
```sql
	SELECT CONCAT(carbrand_name, ' (', carbrand_country, ')')
	FROM fv_carbrands;
```
Voilà pour faire ceci sur postgressql on ferait en gros et dommage moi je ne pourrais pas exécuter ce code mais on ferais tout simplement ça.
```sql
	SELECT carbrand_name || ' (' || carbrand_country || ')'
```
Ce style d'orateur donc doubles barres verticales très important, ça ' (', on refait les doubles barres verticales, carbrand_country et là encore les barres verticales et ça ')' voilà.

On aurait ceci comme requête sur postgressql par exemple ou tout autre système de gestion qui prend en charge cet opérateur || pour faire de la concaténation.

L'avantagé c'est qu'on ne passe pas par une fonction, on a comme ça directement des doubles pipe que ça s'appelle. Ce sont les double barres verticales pour pouvoir faire de la concaténation de chaîne ou d'éléments qui ne sont pas forcément des chaînes.

L'intérêt c'est qu'à la fin ce que vous obtiendrez de tout ça sera une chaîne de caractères même si à l'intérieur vous avez mis des infos qui n'en était pas genre des entiers, ça qu'il faut prendre en compte.

Voilà pour cette partie donc on va allez assez vite avec ces différentes fonctions ce qui a rien de compliqué en soi, honnêtement là on arrive vraiment à la fin du coup il y aurait évidemment pas mal d'autres choses qu'on va aborder sous forme d'annexes dans des tutoriels qui sont des notions beaucoup plus avancé ou des choses qu'on n'a pas forcément besoin d'utiliser au quotidien dans le sens où beaucoup de gens se servent du langage sql par exemple comme interface, de connexion à des données depuis un langage de programmation.

On va s'en servir en web par exemple avec du php pour interroger une base ou sur une application mobile par exemple avec du sqlite et c'est quand même moins souvent que des gens s'en servent purement d'accord à par des administrateurs de bases de données par exemple dont c'est le métier qui vont travailler directement sur des bases de données et qui vont jamais employer de langages de programmation donc je dis simplement, petite parenthèse parce qu'on abordera notamment des notions comme les transactions, les triggers, on va parler des curseurs, on parlera de tout ... on ira un peu plus loin aussi dans tout ce qui est contrainte d'unicité d'intégrité de données, des choses que je n'ai pas forcément abordé dans le cours puisque c'est déjà des choses beaucoup plus avancé et le but c'était d'avoir quand même un cours qui ne soit pas non plus trop chargé dans le sens où vous avez vous aurez toutes les notions qu'il faut pour pouvoir effectuer des requêtes, utiliser certaines fonctions de vos systèmes de gestion et si elles existent c'est quand même pour s'en servir un minimum, c'est dommage de passer à côté.

Et après vous retrouverez dans la playlist de tutoriels de sql pas mal d'autres notions qui ne sont pas pour autant secondaire il ne faut pas le voir forcément comme quelque chose secondaires ou de facultatif et des choses beaucoup plus avancée qui vont sur des notions bien plus spécifiques comme les transactions, les verrous, etc et qui serviront si par exemple un jour on fait véritablement de l'administration sur des bases de données où vous avez besoin de créer par exemple des procédures stockées ou de faire des requêtes préparés, ce genre de choses.

On aura comme ça pas mal de notions là c'est histoire de vous ou caler un petit peu sur ce qui vous attend pour les prochaines vidéos et éventuellement donc là pour le coup on va terminer de va voir ensemble fait pas mal de fonctions donc on a fait finalement le plus dur par rapport à ça vous avez vu comment faire des requêtes, regrouper des résultats, filtrer, etc.

On termine tranquillement ce cours et il y a vraiment rien de compliqué je vous présente quelques fonctions, à vous de vous en servir, de les tester, de les utiliser et vous verrez que ça vous apportera pas mal de faciliter par la suite pour les requêtes que vous ferez.

Alors on a vu en gros si on ressent on a vu le nombre de caractères d'une chaîne, on a vu également comment faire de la concaténation de chaîne.
```sql
	-- Nombre de caractères d'une chaîne
	-- Concaténation de chaîne
```
Voilà on a des fonctions qui sont très simple et notamment sur par exemple le passage en majuscules, en minuscules ça c'est des fonctions pareil qu'on a souvent besoin d'utiliser notamment quand on veut faire des tests, de travailler automatiquement sur une chaîne qui a été convertie en minuscule, en majuscules pour être sûr d'avoir les informations comme il faut.
```sql
	-- Nombre de caractères d'une chaîne
	-- Concaténation de chaîne
	-- Conversion en minuscule / majuscule
```
Pour ça gros avantage, les fonctions sont supportés par a priori tous les systèmes de gestion les plus réputés on va dire, je ne peux pas vous garantir que tous les systèmes de gestion de bases de données au monde ont des fonctions qui sont compatibles et à priori à moins utiliser des systèmes très exotique vous n'aurez pas de souci donc généralement quand je parle des systèmes on va dire les plus usitées pour qu'on soit d'accord, considéré que je parle en fait de MySQL, Oracle Database et je rapelle que MySQL c'est Oracle aussi et généralement on fait la distinction comme ça. On a également PostgreSQL, SQLite, MS SQL donc c'est en fait sql server.
```sql
	-- MySQL, Oracle Database, PostgreSQL, SQLite, MS SQL Server

	-- Nombre de caractères d'une chaîne
	-- Concaténation de chaîne
	-- Conversion en minuscule / majuscule
```
Je me suis arrangée pour que le cours que vous ayez en sql ici soit tout à fait utilisable pour tous ces systèmes de gestion de bases de données, éventuellement d'autres il y a Firebird, il y a également ODB de IBM qui sont quand même assez similaire, on n'a pas trop de différences du sql server donc généralement c'est une fonction disponible sur l'un ou l'autre. Vous allez la retrouver sur Firebird sur ODB IBM donc vous n'aurez pas trop trop de problèmes de compatibilité.

Pour cette conversion, les fonctions très simple je vais vous les montrer ici c'est lower() en passant la chaîne bien évidemment que vous voulez ou upper() donc si vous faites pareil de la programmation c'est des noms qui vous disent quelque chose ça vous parle certainement pour pouvoir passer, convertir en fait une chaîne en minuscule, en majuscules par exemple, un exemple très simple :
```sql
SELECT UPPER(carbrand_name) FROM fv_carbrands;
```
En gros, on va sélectionner toutes les noms des marques de voitures de cette table (fv_carbrands) en les convertissant en majuscules.
```sql
	mysql> SELECT UPPER(carbrand_name) FROM fv_carbrands;
	+----------------------+
	| UPPER(carbrand_name) |
	+----------------------+
	| AUDI                 |
	| BMW                  |
	| FERRARI              |
	| HYUNDAI              |
	| LAMBORGHINI          |
	| MAZDA                |
	| NISSAN               |
	| PEUGEOT              |
	| RENAULT              |
	| TOYOTA               |
	+----------------------+
	10 rows in set (0.01 sec)
```
Voilà voyez tout est écrit en majuscules.

Très simple et je peux faire l'inverse évidemment avec un lower() pour mettre en minuscules.
```sql
SELECT LOWER(carbrand_name) FROM fv_carbrands;
```
```sql
	mysql> SELECT LOWER(carbrand_name) FROM fv_carbrands;
	+----------------------+
	| LOWER(carbrand_name) |
	+----------------------+
	| audi                 |
	| bmw                  |
	| ferrari              |
	| hyundai              |
	| lamborghini          |
	| mazda                |
	| nissan               |
	| peugeot              |
	| renault              |
	| toyota               |
	+----------------------+
	10 rows in set (0.01 sec)
```
Voilà tout en minuscule, très simple aussi je vais aller assez vite pour enchaîner sur la suite.

Là on arrive sur l'inversion de chaîne.
```sql
	-- MySQL, Oracle Database, PostgreSQL, SQLite, MS SQL Server

	-- Nombre de caractères d'une chaîne
	-- Concaténation de chaîne
	-- Conversion en minuscule / majuscule
	-- Inversion de chaîne
```
Ca c'est REVERSE() voilà.
```sql
SELECT REVERSE(carbrand_name) FROM fv_carbrands;
```
```sql
	mysql> SELECT REVERSE(carbrand_name) FROM fv_carbrands;
	+------------------------+
	| REVERSE(carbrand_name) |
	+------------------------+
	| iduA                   |
	| WMB                    |
	| irarreF                |
	| iadnuyH                |
	| inihgrobmaL            |
	| adzaM                  |
	| nassiN                 |
	| toegueP                |
	| tluaneR                |
	| atoyoT                 |
	+------------------------+
	10 rows in set (0.00 sec)
```
Là hop on inverse tout simplement les caractères d'une chaîne dans certains cas ça peut servir par exemple pour des jeux ou autre que pour des palindromes, quand on a besoin de certains traitements spécifiques, c'est une opération qui peut servir c'est bien de le connaître, savoir le faire ok ça c'est fait.

Qu'est ce que je peux vous montrer également d'autres ?

Autre chose par exemple vous avez un formulaire d'accord vous voulez enregistrer des informations d'un utilisateur et l'utilisateur quand vous lui demandez par exemple un nom d'utilisateur ou une information comme une adresse mail, n'importe quoi, il a mis des espaces, il a utilisé l'espace de son clavier, il a par exemple fait ça et puis il a commencé à noter son adresse. Vous n'avez pas forcément envie de stocker tout ces caractères là qu'on ne voit pas d'ailleurs en base de données. Vous allez du coup pouvoir faire de la suppression, on va mettre suppression d'espaces blancs, les caractères vides en fait depuis la fonction TRIM().
```sql
	-- MySQL, Oracle Database, PostgreSQL, SQLite, MS SQL Server

	-- Nombre de caractères d'une chaîne
	-- Concaténation de chaîne
	-- Conversion en minuscule / majuscule
	-- Inversion de chaîne
	-- Suppression d'espaces blancs
```
```sql
SELECT TRIM(carbrand_name) FROM fv_carbrands;
```
Alors j'en ai pas, j'ai pas mis d'espaces blancs dans cette exemple là donc ce qu'on va faire, on veut même pas passer par une table et par exemple.
```sql
SELECT TRIM('bonjour');
```
```sql
	mysql> SELECT TRIM('bonjour');
	+-----------------+
	| TRIM('bonjour') |
	+-----------------+
	| bonjour         |
	+-----------------+
	1 row in set (0.00 sec)
```
Si je note donc ça comme ça d'accord, il n'y a pas de problème ok ça va afficher bonjour et si je mets des espaces que ce soit avant, après, n'importe quoi alors là si je fais ça.
```sql
SELECT TRIM('    bonjour     d');
```
```sql
	mysql> SELECT TRIM('    bonjour     d');
	+---------------------------+
	| TRIM('    bonjour     d') |
	+---------------------------+
	| bonjour     d             |
	+---------------------------+
	1 row in set (0.00 sec)
```
C'est un cas un peu particulier d'accord et tout ce qui va être avant en fait ou après la chaîne d'accord, de l'ensemble de la chaîne, sera supprimé donc là c'est par exemple j'avais fait ça.
```sql
SELECT TRIM('    bonjour     ');
```
```sql
	mysql> SELECT TRIM('    bonjour     ');
	+--------------------------+
	| TRIM('    bonjour     ') |
	+--------------------------+
	| bonjour                  |
	+--------------------------+
	1 row in set (0.00 sec)
```
On ne va pas avoir tous les espaces qu'il a avant et après le mot bonjour.

Et on a des équivalents également pour enlever que la partie à gauche ou la partie à droite donc elle LTRIM() et RTRIM() et on a également des alias ou d'autres noms de fonctions si vous passez par des systèmes de gestion pour lesquelles ces noms ne sont pas compatibles logiquement trim() il semble que ça fonctionne à peu près partout.

C'est très simple si à un moment donné vous êtes sur un autre système de gestion, vous tester les fonctions que je vous ai montré et si vous voyez qu'elles ne fonctionnent pas c'est que vous avez une erreur de syntaxe et c'est qu'a priori ce n'est pas le bon nom voilà qu'elles ne sont pas supportées mais généralement vous avez une fonction qui porte un autre nom qui fait la même chose. C'est assez rare d'avoir par exemple un système de gestion qui ait ce genre de fonction assez standards qui ne soit pas disponible du tout.
```sql
	-- MySQL, Oracle Database, PostgreSQL, SQLite, MS SQL Server
```
Encore une fois je vous parle quand même de système de gestion qui sont utilisés dans le milieu professionnel aussi, il y a des gens voilà il passe des heures et des heures entières depuis plus de 20 ans sur ces systèmes pour ceux en tout cas qui existe depuis depuis ce temps là et bien sûr c'est des systèmes qui ont évolués, qui ont été, on va dire, agrémenté de nouvelles fonctionnalités donc toutes ces petites fonctions assez assez basique, assez standards finalement sont normalement disponible un peu partout, il n'y a pas trop à s'en faire là dessus.

Voilà pour les petites fonctions on va dire assez simple sur des manipulations assez simple, on a fait le tour et je voudrais éventuellement vous montrez une qui est très très intéressante ça surtout quand on a par exemple un site web a gérer ou beaucoup d'informations à remplacer c'est très
bien.

Là pour le coup je vous ai mis un exemple alors j'ai pas un beaucoup d'exemples ici mais vous allez pouvoir par exemple effectuer du remplacement de chaînes alors dans une chaîne de caractères vous allez pouvoir remplacer une information par un autre par exemple on peut imaginer ça.

Imaginons qu'un jour cette adresse ici.
```sql
	INSERT INTO `fv_carbrands`(`carbrand_name`, `carbrand_country`, `carbrand_website`)
	VALUES
>	('Mazda', 'JP', 'https://www.mazda.fr/'), 
	('Peugeot', 'FR', 'https://www.peugeot.fr/accueil.html'), 
	('Renault', 'FR', 'https://group.renault.com/'), 
	('Audi', 'DE', 'https://www.audi.com/en.html'), 
	('Toyota', 'JP', 'https://global.toyota/en/'), 
	('Ferrari', 'IT', 'https://www.ferrari.com/fr-FR'), 
	('Hyundai', 'KR', 'http://www.hyundaigroup.com/'), 
	('Nissan', 'JP', 'https://www.nissan-global.com/EN/index.html'), 
	('BMW', 'DE', 'https://www.bmwgroup.com/de.html'), 
	('Lamborghini', 'IT', 'https://www.lamborghini.com/en-en/');
```
Imaginons qu'un jour cette adresse ici ne soit plus correct alors on pourrait faire une simple édition par exemple, on fait un update en fait sur l'information on peut le changer ça évidemment c'est quand on a qu'une seule information mais si vous avez à un moment donné plusieurs enregistrements d'une table qui on des informations erronées par exemple vous avez un blog d'accord un site de news, il y a des moments dans votre dans votre site où vous faites référence par exemple au site wikipédia d'accord vous avez besoin de citer wikipédia et on retrouve souvent le lien vers le site wikipedia dans le contenu de vos news ou de vos articles mais admettons qu'à un moment donné wikipedia change complètement l'adresse de son site.

Si vous aviez mis le lien vers le site wikipédia, je ne sais pas, 50 voir 100 voir 1500 fois dans votre base de données et bien le jour ou Wikipedia change en fait d'url vous vous retrouvez avec tout autant en fait d'url qui ne sont plus valides. Hélas si vous commencez à faire voilà des modifications une par une vous n'avez pas fini.

Autre exemple tout simple votre propre site d'accord càd que sur votre site vous pouvez faire des liens vers d'autres pages de votre site et un jour votre site est en http et plus tard vous décidé enfin de sécuriser votre site et de le passer avec le https donc un protocole en fait sécuriser et à ce moment là il faudra également modifier les adresses pour que les url dans votre base ne soit plus en http mais en https ou simplement modification du nom de votre site, de l'extension où vous passez d'un point fr à un point com ou un sous domaine où n'importe quoi.

Bref quand on a besoin comme ça de faire du remplacement d'information qui sont assez massive il ne s'agit pas juste de modifier un seul enregistrement.

Pour cela on peut utiliser une fonction très simple qui est la fonction REPLACE() alors la fonction REPLACE() si vous la faites tel quel dans un select, encore une fois si vous avez bien compris on utilise des fonctions pour de la sélection de données càd qu'on sélectionne des données depuis une table et ensuite on applique un traitement sur des chaînes de caractères qu'on a récupéré et c'est ce qui est affiché à notre écran et bien sûr ce que je vous montre ici vous pouvez l'effectuer dans une modification par exemple on va faire UPDATE fv_carbrands... on va prendre un exemple très simple :
```sql
	UPDATE fv_carbrands
	SET carbrand_website = REPLACE()
	WHERE carbrand_name = 'Renault';
```
carbrand_website égal et je vais utiliser ma fonction REPLACE() directement ici d'accord et je vais dire dans le cas où par exemple le carbrand_name 'Renault' qui ont changé dans l'url en fait c'est pas group en anglais mais c'est groupe en français avec un E.

Là pas de bol on a une url qui n'est pas bonne et on n'a pas  envie que quand les gens cliquent dessus tombe finalement sur une page avec une erreur 404 donc une page qui n'est pas valide voilà.

Ce qu on va faire pour le coup l'information a traité donc carbrand_website c'est en fait la chaîne source sur laquelle on veut travailler, c'est le premier argument de cette fonction REPLACE() et le second c'est l'élément à remplacer et en 3e là c'est l'élément que l'on veut obtenir donc là en fait le mot qui est 'group' ici d'accord donc il va en fait chercher ça et il le remplace par 'groupe' avec un E.
```sql
UPDATE fv_carbrands
SET carbrand_website = REPLACE(carbrand_website, 'group', 'groupe')
WHERE carbrand_name = 'Renault';
```
```sql
	mysql> select * from fv_carbrands;
	... +---------------------------------------------+
	... | carbrand_website                            |
	... +---------------------------------------------+
	... | https://www.mazda.fr/                       |
	... | https://www.peugeot.fr/accueil.html         |
	... | https://group.renault.com/                  |
	... | https://www.audi.com/en.html                |
	... | https://global.toyota/en/                   |
	... | https://www.ferrari.com/fr-FR               |
	... | http://www.hyundaigroup.com/                |
	... | https://www.nissan-global.com/EN/index.html |
	... | https://www.bmwgroup.com/de.html            |
	... | https://www.lamborghini.com/en-en/          |
	... +---------------------------------------------+
	10 rows in set (0.00 sec)

	mysql> UPDATE fv_carbrands
		-> SET carbrand_website = REPLACE(carbrand_website, 'group', 'groupe')
		-> WHERE carbrand_name = 'Renault';
	Query OK, 1 row affected (0.03 sec)
	Rows matched: 1  Changed: 1  Warnings: 0

	mysql> select * from fv_carbrands;
	... +---------------------------------------------+
	... | carbrand_website                            |
	... +---------------------------------------------+
	... | https://www.mazda.fr/                       |
	... | https://www.peugeot.fr/accueil.html         |
	... | https://groupe.renault.com/                 |
	... | https://www.audi.com/en.html                |
	... | https://global.toyota/en/                   |
	... | https://www.ferrari.com/fr-FR               |
	... | http://www.hyundaigroup.com/                |
	... | https://www.nissan-global.com/EN/index.html |
	... | https://www.bmwgroup.com/de.html            |
	... | https://www.lamborghini.com/en-en/          |
	... +---------------------------------------------+
	10 rows in set (0.00 sec)
```
On fait ça alors on va faire un petit `select * from fv_carbrands` pour avoir l'information avant et après ok, j'applique cette requête est normalement si j'ai pas fait d'erreur dessus ça a l'air d'être bon et on remarque maintenant que le E a bien été ajouté à groupe donc là bien sûr c'est une modification sur une seule colonne d'un seul enregistrement d'une table mais comme je vous l'ai expliqué juste avant, imaginez sur un site, vous avez plusieurs enregistrements ou cette adresse par exemple de Renault étaient indiquée voilà là vous n'avez pas vous amuser à modifier tout un par un donc vous pouvez utiliser REPLACE() pour faire ça.

Alors là du coup je ne fais rien parce que sinon je me retrouve avec une url qui n'est pas bonne donc donc on va refaire l'élément à l'envers pareil voilà là pour le coup on n'a pas encore abordé mais si on avait par exemple travailler sur des transactions, tout ça on pourrait faire des roll back c'est à dire des retours en arrière pour annuler par exemple des requêtes précédentes.

On fait ça et là hop on revient avec ce qu'on avait juste avant.
```sql
UPDATE fv_carbrands
SET carbrand_website = REPLACE(carbrand_website, 'groupe', 'group')
WHERE carbrand_name = 'Renault';
```
```sql
	mysql> UPDATE fv_carbrands
		-> SET carbrand_website = REPLACE(carbrand_website, 'groupe', 'group')
		-> WHERE carbrand_name = 'Renault';
	Query OK, 1 row affected (0.02 sec)
	Rows matched: 1  Changed: 1  Warnings: 0

	mysql> select * from fv_carbrands;
	... +---------------------------------------------+
	... | carbrand_website                            |
	... +---------------------------------------------+
	... | https://www.mazda.fr/                       |
	... | https://www.peugeot.fr/accueil.html         |
	... | https://group.renault.com/                  |
	... | https://www.audi.com/en.html                |
	... | https://global.toyota/en/                   |
	... | https://www.ferrari.com/fr-FR               |
	... | http://www.hyundaigroup.com/                |
	... | https://www.nissan-global.com/EN/index.html |
	... | https://www.bmwgroup.com/de.html            |
	... | https://www.lamborghini.com/en-en/          |
	... +---------------------------------------------+
	10 rows in set (0.00 sec)
```

Donc ça très pratique le remplacement comme ça de chaîne, fonctionnellement ça correspond à pas mal de fonctions de remplacement que vous avez dans des langages de programmation aussi de toute façon il ne faut pas faut pas quand même oublier que sql c'est un langage de manipulation de données relationnelles dans des bases, dans des fichiers mais on a quand même beaucoup beaucoup de choses aussi qui sont propres à des langages de programmation.

D'accord on peut même presque vous verrez faire des variables aussi en sql, on peut créer des procédures donc des fonctions en fait on n'a véritablement pas mal mine de rien de similitudes avec des langages de programmation donc sql est un peu particulier dans ce sens là mais il permet de faire énormément de choses et c'est pour ça que c'est très puissant et que c'est aussi très utilisé aujourd'hui.

Ca c'est fait pour le remplacement alors je vais mettre "emplacement d'une chaîne".
```sql
	-- MySQL, Oracle Database, PostgreSQL, SQLite, MS SQL Server

	-- Nombre de caractères d'une chaîne
	-- Concaténation de chaîne
	-- Conversion en minuscule / majuscule
	-- Inversion de chaîne
	-- Suppression d'espaces blancs
	-- Remplacement d'une chaîne
```
Encore une fois toutes les fonctions etc, vous les avez en descriptions, un lien vers un des dépôts de mon github où je vous ai fait tout un tas de tableaux qui seront plus mis à jour au fur et à mesure, je les complète au fur et à mesure pour que vous ayez un bon listing de toutes les fonctions sur les chaînes pour les différents systèmes de gestion qu'on vérifie un peu tout ça et que vous ayez tout sous la main.

Ok ça c'est la plus grosse partie, on va terminer avec quelques fonctions qui sont plus ... alors la sous-chaîne, je vais garder pour la fin puisque c'est très utilisé mais c'est peut-être la fonction la plus compliquée à utiliser même si en soit il n'y a pas mort d'homme et on va voir par contre tout ce qui est positionnement donc en gros la position d'une occurrence donc faut entendre une chaîne d'accord dans une chaîne.
```sql
	-- MySQL, Oracle Database, PostgreSQL, SQLite, MS SQL Server

	-- Nombre de caractères d'une chaîne
	-- Concaténation de chaîne
	-- Conversion en minuscule / majuscule
	-- Inversion de chaîne
	-- Suppression d'espaces blancs
	-- Remplacement d'une chaîne
	-- Position d'une occurence dans une chaîne
	-- 
```
Je vais vous expliquer comment ça fonctionne, on va faire un select ça pas de problème, on va utiliser alors moi par contre sur mysql normalement les deux sont pris en compte vous avez INSTR() comme ça selon le système de gestion ou LOCATE() mais le truc c'est que LOCATE() prend les arguments à l'inverse de INSTR() donc en gros on va voir ici l'information qu'on cherche en premier d'accord et ensuite la chaîne sur laquelle on travaille et pour INSTR() les paramètres sont inversés.
```sql
	SELECT LOCATE(1, ...)
```
Attention selon le système de gestion encore une fois certaines fonctions sont compatibles et d'autres non donc il faudra faire attention par rapport à ça.

Donc on va faire ça comme ça locate() moi je recherche alors qu'est ce qu'on recherche parce qu'encore une fois bon c'est pas des exemples très très parlant, toujours des exemples pour illustrer des fonctions mais il n'y a rien de très très incroyable comme traitement à faire.

On peut dire je cherche par exemple dans l'unité où on peut chercher ça dans Hyundai, on peut chercher ça. Dans Hyundai je cherche par exemple la première occurrence de 'y', c'est un peu bizarre c'est pas très utile encore une fois mais c'est pas bien grave le tout c'est que vous compreniez comment fonctionne justement ben l'utilisation de locate() et des autres fonctions qu'on a vu pour manipuler des chaînes de caractères.
```sql
SELECT LOCATE('y', carbrand_name) FROM fv_carbrands;
```
```sql
	mysql> SELECT LOCATE('y', carbrand_name) FROM fv_carbrands;
	+----------------------------+
	| LOCATE('y', carbrand_name) |
	+----------------------------+
	|                          0 |
	|                          0 |
	|                          0 |
	|                          2 |
	|                          0 |
	|                          0 |
	|                          0 |
	|                          0 |
	|                          0 |
	|                          3 |
	+----------------------------+
	10 rows in set (0.01 sec)
```
Ok donc là je vais faire l'exécution direct, il le fait pour chacune voilà si vous remarquez bien donc on va reprendre un résultat qui est retourné mais par contre on n'arrive pas bien à lire donc il faudrait qu'on ai le nom sous les yeux. Le nom est un peu plus pratique pour vous.
```sql
SELECT carbrand_name, LOCATE('y', carbrand_name) FROM fv_carbrands;
```
```sql
	mysql> SELECT carbrand_name, LOCATE('y', carbrand_name) FROM fv_carbrands;
	+---------------+----------------------------+
	| carbrand_name | LOCATE('y', carbrand_name) |
	+---------------+----------------------------+
	| Audi          |                          0 |
	| BMW           |                          0 |
	| Ferrari       |                          0 |
	| Hyundai       |                          2 |
	| Lamborghini   |                          0 |
	| Mazda         |                          0 |
	| Nissan        |                          0 |
	| Peugeot       |                          0 |
	| Renault       |                          0 |
	| Toyota        |                          3 |
	+---------------+----------------------------+
	10 rows in set (0.00 sec)
```
Ok on voit que pour Audi on a 0, on voit que pour Hyundai voyez il a compté 2 d'accord on pare de 1 donc il estime qu'on a rencontré ce y à partir d'une deuxième position.

C'est en fait la position à partir du quel on a rencontré l'élément.

Pour Toyota et c'est logique il l'a rencontré au bout de la troisième position voilà ça vous indiquera la position où il a rencontré une occurrence et s'il ne trouve pas la chaîne que vous cherché ici en fait dans celle ci, il retournera tout simplement 0.

0 c'est qu'il n'a pas trouvé de y là-dedans on peut le faire bien sûr comme ça.
```sql
SELECT carbrand_name, LOCATE('yo', carbrand_name) FROM fv_carbrands;
```
```sql
	mysql> SELECT carbrand_name, LOCATE('yo', carbrand_name) FROM fv_carbrands;
	+---------------+-----------------------------+
	| carbrand_name | LOCATE('yo', carbrand_name) |
	+---------------+-----------------------------+
	| Audi          |                           0 |
	| BMW           |                           0 |
	| Ferrari       |                           0 |
	| Hyundai       |                           0 |
	| Lamborghini   |                           0 |
	| Mazda         |                           0 |
	| Nissan        |                           0 |
	| Peugeot       |                           0 |
	| Renault       |                           0 |
	| Toyota        |                           3 |
	+---------------+-----------------------------+
	10 rows in set (0.00 sec)
```
Quand je parle de chaîne c'est pas forcément qu'un seul caractère là on le retrouvera que pour Toyota parce que Hyundai en fait n'est pas pas suivi d'un 'yo' mais d'un 'yu'.

Très simple d'usage rien de compliqué je pense et voilà cet exemple suffit et bien sûr vous n'hésitez pas encore une fois toujours pareil à faire vos petites bases de données avec des choses beaucoup plus complète en nombre de tables, de contraintes, d'éléments que vous avez enregistré dans vos tables comme ça vous pourrez vraiment tester ça sur des choses beaucoup plus parlante et puis surtout vos exemples à vous pas forcément reprendre toujours juste mes fichiers, de vous contenter de faire des requêtes dessus et terminé même si je fournis quand même pas mal de support pour cette formation. Vous avez largement déjà de quoi faire.

On termine enfin cette vidéo avec tout ce qui est des traitements sur des sous chaînes, ça c'est quelque chose pareil en programmation qu'on retrouve énormément et sql permet bien sûr de le faire.

On va alors mette un mot très simple et voilà hop je ne met rien de plus parce que c'est quand même mieux de le voir avec un exemple.
```sql
	-- MySQL, Oracle Database, PostgreSQL, SQLite, MS SQL Server

	-- Nombre de caractères d'une chaîne
	-- Concaténation de chaîne
	-- Conversion en minuscule / majuscule
	-- Inversion de chaîne
	-- Suppression d'espaces blancs
	-- Remplacement d'une chaîne
	-- Position d'une occurence dans une chaîne
	-- Sous-chaîne
```
Selon le système de gestion et je crois que c'est sqlite, on a le SUBSTR() pour substring en gros, ça normalement c'est fonctionnelles partout, quand je dis partout encore une fois c'est partout, encore une fois c'est ceux là.
```sql
	-- MySQL, Oracle Database, PostgreSQL, SQLite, MS SQL Server
```
Vous avez également substring() comme un alias mais il me semble celui là n'est pas compatible pour sqlite. Voilà sqlite prend SUBSTR(). Il ne voulait pas du ring à la fin, trop long du coup il l'on enlevé donc peu importe lequel nous on va utiliser SUBSTR() puisqu'il fonctionne partout et là on va pouvoir gérer tout un tas d'éléments aussi.

On peut par exemple je peux peut-être le montrer ici, on va faire ça, on va faire comme tout à l'heure select carbrand_name, SUBSTR() et on va pouvoir prendre là-dessus carbrand_name, premier argument d'accord l'élément sur lequel je travaille sur la chaîne pour laquelle je veux pouvoir extraire une sous chaîne en fait donc ça que j'aurait pu mettre.
```sql
	-- MySQL, Oracle Database, PostgreSQL, SQLite, MS SQL Server

	-- Nombre de caractères d'une chaîne
	-- Concaténation de chaîne
	-- Conversion en minuscule / majuscule
	-- Inversion de chaîne
	-- Suppression d'espaces blancs
	-- Remplacement d'une chaîne
	-- Position d'une occurence dans une chaîne
	-- Extraction d'une sous-chaîne
```
SUBSTR(carbrand_name, ...) et ici le nombre d'éléments à partir d'où on commence alors moi je vais dire on commence à partir de 2.
```sql
SELECT carbrand_name, SUBSTR(carbrand_name, 2) FROM fv_carbrands;
```
Evidemment quand on explique comme ça juste avec des mots c'est pas très clair c'est normal, c'est le genre de fonction il faut montrer un exemple sinon bah comme c'est pas trés n'est pas évident expliqué pis même si ça l'était c'est bien quand même d'avoir un exemple.

En gros voilà comment que ça se passe. 
```sql
	mysql> SELECT carbrand_name, SUBSTR(carbrand_name, 2) FROM fv_carbrands;
	+---------------+--------------------------+
	| carbrand_name | SUBSTR(carbrand_name, 2) |
	+---------------+--------------------------+
	| Audi          | udi                      |
	| BMW           | MW                       |
	| Ferrari       | errari                   |
	| Hyundai       | yundai                   |
	| Lamborghini   | amborghini               |
	| Mazda         | azda                     |
	| Nissan        | issan                    |
	| Peugeot       | eugeot                   |
	| Renault       | enault                   |
	| Toyota        | oyota                    |
	+---------------+--------------------------+
	10 rows in set (0.00 sec)
```
Comme ça vous voyez un petit peu sous les yeux le résultat que ça donne, je dit en fait de prendre à partir de la deuxième position, de lire en fête ma chaîne càd qu'il va prendre tout le contenu de la chaîne mais qu'à partir de cette position là <2> d'accord donc il prend le nom de la marque mais à partir de 2 donc là forcément comme la position 2 de Audi c'est le deuxième caractère donc le 'u', on a du coup laché le premier caractère et pour chacune des marques on a finalement comme vous voyez on a pas extrait donc on n'a pas pris en fait le premier caractère et donc on a commencé la chaîne à partir du deuxième.

Donc ça peut servir par exemple si vous avez besoin dans un exemple je ne sais pas moi de ne pas récupérer les 10 premiers caractères d'une chaîne ou les 15 premiers vous pouvez utiliser cette fonction d'extraction de cette manière.

carbrand_name, ça c'est la colonne, la chaîne sur laquelle vous travaillez parce qu'on pourrait très bien avoir ça je rappelle.
```sql
SELECT SUBSTR('bonjour', 2);
```
Encore une fois on n'est jamais obligé de travailler directement sur les tables on pourrait sans problème faire ça même si au final je pourrais avoir une base de données qui est vide, une table qui est vide.
```sql
	mysql> SELECT substr('bonjour', 2);
	+----------------------+
	| substr('bonjour', 2) |
	+----------------------+
	| onjour               |
	+----------------------+
	1 row in set (0.00 sec)
```
Encore une fois on peut très bien faire ça, ça fonctionnerait aussi. J'ai même pas besoin de passer par une table pour vous montrer comment ça fonctionne.

C'est une possibilité.

On peut également sinon décider de l'endroit où on démarre et choisir surtout la longueur du nombre de caractères qu'on récupère alors je vais remettre ce qu'on avait tout à l'heure et puis voilà par exemple de dire :
```sql
SELECT carbrand_name, SUBSTRING(carbrand_name, 2, 2) FROM fv_carbrands;
```
```sql
	mysql> SELECT carbrand_name, SUBSTRING(carbrand_name, 2, 2) FROM fv_carbrands;
	+---------------+--------------------------------+
	| carbrand_name | SUBSTRING(carbrand_name, 2, 2) |
	+---------------+--------------------------------+
	| Audi          | ud                             |
	| BMW           | MW                             |
	| Ferrari       | er                             |
	| Hyundai       | yu                             |
	| Lamborghini   | am                             |
	| Mazda         | az                             |
	| Nissan        | is                             |
	| Peugeot       | eu                             |
	| Renault       | en                             |
	| Toyota        | oy                             |
	+---------------+--------------------------------+
	10 rows in set (0.00 sec)
```
Donc là je lui dis tu commences à la deuxième position et tu récupères deux caractères.

Si je voulais récupérer plus évidemment je fais ça.
```sql
SELECT carbrand_name, SUBSTRING(carbrand_name, 2, 3) FROM fv_carbrands;
```
Donc si on prend plus que la taille des éléments, il s'arrêtera évidemment à la fin de la chaîne parce qu'ils ne peut pas récupérer plus d'informations, on peut faire ça comme ça.
```sql
	mysql> SELECT carbrand_name, SUBSTRING(carbrand_name, 2, 3) FROM fv_carbrands;
	+---------------+--------------------------------+
	| carbrand_name | SUBSTRING(carbrand_name, 2, 3) |
	+---------------+--------------------------------+
	| Audi          | udi                            |
	| BMW           | MW                             |
	| Ferrari       | err                            |
	| Hyundai       | yun                            |
	| Lamborghini   | amb                            |
	| Mazda         | azd                            |
	| Nissan        | iss                            |
	| Peugeot       | eug                            |
	| Renault       | ena                            |
	| Toyota        | oyo                            |
	+---------------+--------------------------------+
	10 rows in set (0.00 sec)
```
Voilà donc ça c'est vraiment pour le coût de l'extraction d'une chaîne en fait dans une autre ça aura son utilité dans certains cas.

Là bien sûr par rapport à la table que je vous ai mises ici ça n'a pas vraiment ... je ne pense pas qu'on puisse trouver une utilité à ce genre de fonction dans ce cas là je ne vois pas trop pourquoi on irait s'amuser à extraire une sous-chaîne d'un nom de marque de voiture mais pourquoi pas  éventuellement pourquoi pas j'ai envie de dire.

On va pouvoir s'arrêter là, je pense qu'au niveau des fonctions j'en montré pas mal, il n'en existe pas mal d'autres on peut par exemple savoir l'occupation d'une chaîne en mémoire en bits, en octet mais tout ça pareil dans la description de la vidéo vous avez toutes ces fonctions vous allez avoir dans les tableaux présentés pas mal de fonctions que je vous ai pas montré dans cette séance et s'est parfaitement volontaire.

Encore une fois ça servira à rien de vous énumérer va 20, 30, 40 fonctions sur des chaînes pour qu'au final vous en ayez retenus que 2/3 donc c'est pas utile.

Je vous ai présenté celles qui me semblaient les plus pertinentes en l'occurrence, celles que vous aurez peut-être besoin d'utiliser après à vous de voir si vous avez besoin de faire telles choses bien précises.

En gros on a aussi des éléments qui permettent de compter à partir du début d'une chaîne.

On a vraiment des fonctions sur d'autres usages mais qui sont moins utilisé que ce que je vous ai présenté ici donc là ça me parait déjà pas mal suffisant par rapport à tout ce qu'on a vu donc n'hésitez pas bien sûr à vous renseigner si vous avez besoin d'autres fonctions particulières mais nous on va s'arrêter ici.

Pour la prochaine séance on va voir les dates et les heures que pareil une autre partie assez importante.

Je pense qu'on terminera avec les fonctions mathématiques, ça peut servir aussi dans certains cas.

Et on terminera sur tout ce qui est lié à la sécurité voilà les fonctions de sécurité surtout si  vous faites des sites web et vous vous servez de sql pour ça c'est quelque chose qui sera ma foi très utile.

Je vous dis à bientôt, n'hésitez pas à partager, liker et laisser un petit commentaire surtout si vous avez des questions ou que vous êtes bloqués sur quelque chose.

N'hésitez pas à vous entraîner aussi, récupérer ... toute façon vous allez voir c'est sur le github pour trouver à chaque fois tout les fichiers sql que je vous ai proposé sur les différentes séances du cours.

Il ne faut pas hésiter à les récupérer pour récupérer ces fichiers là, travailler dessus, faire vos propres fichiers et vous aurez comme ça largement de quoi faire pour vos tests et vous exercer à sql avec toutes ces choses qu'on a vues finalement parce que le cours commence à être assez conséquent mine de rien.

Je vous dis à bientôt pour la suite pour la prochaine séance, prenez soin de vous et entraînez-vous bien.

Ciao tout le monde