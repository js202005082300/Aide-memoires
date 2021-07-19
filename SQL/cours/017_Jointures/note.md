# [17. Jointures](https://www.youtube.com/watch?v=Qms4XqTtnkA)
03-01-20

[data7.sql](data7.sql)

Bonjour à tous, nous voici pour la séance 17 en sql, nous allons aborder ensemble les jointures c'est une notion qui est essentiel dans l'apprentissage de sql au niveau des bases de données puisqu'il va permettre justement ... il est la base en fait des différentes relations que vous allez avoir entre les tables de votre base de données.

On va revenir pour cela sur le fichier de la séance précédente vous allez et vous comprendre un petit peu pourquoi et ça fait fait la transition comme ça avec cette nouvelle séance avec les informations qu'on avait précédemment.

En gros nous avions une liste du joueur, une table de joueurs et une table d'échanges pour ces différents joueurs.

On avait notamment des informations on remarque ici qui se répètent. Par exemple ici notre liste de joueurs fv_players et dans les différents échanges fv_playertrades et bien à chaque fois qu'on a la liste vendeur, acheteur, etc, l'objet échangé ... on a des informations marquées directement là dedans.

On a également des objets d'accord qui sont ... on peut imaginer ça peut être une base de données par exemple pour un jeu vidéo. Ces objets sont directement là mais on est d'accord que les objets seront a priori utilisé autrement pas seulement au travers d'échanges.

Le problème c'est qu'on n'a rien en fait pour stocker les objets, on n'a pas de table particulière ou autre.

Et là on indique ici des noms de joueurs alors qu'on a directement une table fv_players et qu'on pourrait se servir justement des possibilités relationnel que proposent les bases de données.

Si vous vous souvenez d'ailleurs sur la vidéo concernant les contraintes, je vous avez parlé des clés étrangères.

Les clés étrangères par exemple, permettent par exemple de dire que dans une table nous allons avoir une information en fait qui est reliée à une autre information d'une autre table.

En gros un champ d'une table A est relié à un champ d'une table B d'accord on crée comme ça une relation via les clés étrangères.

Là data6.sql c'est comme si on n'avait pas du tout l'usage de clé étrangères dans cet exemple là et c'est justement volontaire en fait pour faire la transition avec la prochaine séance.

Alors petite parenthèse si vous voulez travailler avec des clés étrangères il faut utiliser le moteur de stockage innodb pour la table en question d'accord pour les tables qui vont faire usage de ces différentes clés ça ne marchera pas avec par exemple le moteur myisam donc il faut mettre à jour en conséquence et adapter le moteur que vous utilisez au niveau de vos tables.

Donc ça c'est bon je vais garder ça sous le coude et ça pourra servir.

J'ai mis pour cette cette séance et vous pouvez récupérer dans la description de la vidéo ou depuis mon github ce fichier data7.sql qui reprend en fait les exemples de la séance précédente mais avec des mises à jour pour correspondre un peu plus justement avec ce principe d'organisation de données, de structures de données en plusieurs tables pour avoir en fait plus de cohérence.

Ca va éviter aussi les répétitions d'information c'est à dire que là au lieu de stocker des chaînes de caractères à chaque fois nous allons pouvoir stocker à la place des clés qui sont en fait simplement des entiers qui prendront en conséquence beaucoup beaucoup moins de place et ça va nous permettre de créer ensuite les différentes relations.

Alors c'est tout à fait logique dans le fonctionnement fait des bases de données c'est à dire que nous avons plusieurs tables, ça vous allez être amener dans des vrais projets à travailler sur des dizaines, des dizaines peut-être même des centaines des milliers de table, même plusieurs bases différentes et on va avoir besoin de créer des relations entre ces différentes informations.

Ici data6.sql nous avons par exemple des joueurs, ces joueurs sont naturellement relié à une table qui concerne des échanges puisque les échanges sont faits par des joueurs et par personne d'autre donc automatiquement on comprend qu'il peut y avoir une relation entre des joueurs et des transactions effectuées entre joueurs, ce qui est parfaitement logique.

D'ailleurs on pourrait très bien se dire qu'une table donc qui concerne des échanges d'objets peut tout à fait être liée également à une table qui contiendrait ces fameuses objets.

L'avantagent aussi c'est que si un jour j'ai besoin d'utiliser, d'ajouter de nouveaux objets à mon jeu vidéo on va pouvoir avoir une table spécialement pour ça qui va en fait répertorier tous les objets du jeu d'accord et éventuellement certains de ces objets seront utilisés dans des échanges.

Même chose pour cette information là, player_class (table fv_players dans data6.sql), on voit que chaque joueur possède une habilité donc une classe et si un jour je veux rajouter d'autres classes c'est dommage quand même de devoir répéter ces informations là et d'avoir de la redondance.
```txt
	'Guerrier', 'Mage noir', 'Barde', 'Archer', 'Voleur', 'Mage noir' (à nouveau), 'Mage blanc'.
```
Autant faire une table qui contient la liste des classes déjà ça économise on en espace par rapport aux informations et ça permettrait en plus par la suite d'avoir tout un tas de requêtes possible que l'on peut faire pour récupérer ces informations là par exemple faire la liste en fait des classes disponibles dans le jeu et si on doit le faire à partir des informations-là autant dire qu'on va s'embêter quand même pour pas grand chose, on va voir beaucoup de répétitions.

+ data6.sql
```sql
	...
	INSERT INTO `fv_players`(`player_name`, `player_level`, `player_class`)
	VALUES
	('BigBoss_89', 15, 'Guerrier'), 
	('Sephiroth', 37, 'Mage noir'), 
	('Nephion', 23, 'Barde'), 
	('Cladjuju', 1, 'Archer'), 
	('Haryko', 1, 'Voleur'), 
	('Greg_war', 16, 'Mage noir'),  
	('Icekissy', 50, 'Mage blanc');
```
Voilà en conséquence le nouveau fichier dont pour la séance présente sur les jointures qui est mis à jour pour par rapport à ces informations.

+ data7.sql
```sql
	DROP DATABASE IF EXISTS `fv_database`;
	CREATE DATABASE IF NOT EXISTS `fv_database`;
	USE `fv_database`;

	CREATE TABLE IF NOT EXISTS `fv_players`
	(
		`id_player` INT NOT NULL AUTO_INCREMENT, 
		`player_name` VARCHAR(65) NOT NULL UNIQUE, 
		`player_level` INT NOT NULL, 
		`player_ability` INT NOT NULL, 
		PRIMARY KEY(`id_player`)
	);

	CREATE TABLE IF NOT EXISTS `fv_abilities`
	(
		`id_ability` INT NOT NULL AUTO_INCREMENT, 
		`ability_name` VARCHAR(30) NOT NULL UNIQUE, 
		PRIMARY KEY(`id_ability`)
	);

	CREATE TABLE IF NOT EXISTS `fv_playertrades`
	(
		`id_playertrade` INT NOT NULL AUTO_INCREMENT, 
		`playertrade_seller` INT NOT NULL, 
		`playertrade_buyer` INT NOT NULL, 
		`playertrade_item` INT NOT NULL, 
		`playertrade_date` DATETIME NOT NULL, 
		PRIMARY KEY(`id_playertrade`)
	);

	CREATE TABLE IF NOT EXISTS `fv_items`
	(
		`id_item` INT NOT NULL AUTO_INCREMENT, 
		`item_name` VARCHAR(65) NOT NULL UNIQUE, 
		`item_type` VARCHAR(65) NOT NULL, 
		`item_sellprice` INT NOT NULL, 
		PRIMARY KEY(`id_item`)
	);

	INSERT INTO `fv_players`(`player_name`, `player_level`, `player_ability`)
	VALUES
	('BigBoss_89', 15, 1), 
	('Sephiroth', 37, 5), 
	('Nephion', 23, 6), 
	('Cladjuju', 1, 2), 
	('Haryko', 1, 3), 
	('Greg_war', 16, 5),  
	('Icekissy', 50, 4);

	INSERT INTO `fv_abilities`(`ability_name`)
	VALUES
	('Guerrier'), 
	('Archer'), 
	('Voleur'), 
	('Mage blanc'), 
	('Mage noir'), 
	('Barde'), 
	('Démoniste'), 
	('Ingénieur');

	INSERT INTO `fv_items`(`item_name`, `item_type`, `item_sellprice`)
	VALUES
	('Épée en mousse', 'arme', 2), 
	('Potion de furtivité', 'consommable', 4), 
	('Extrait de rubis', 'minerau', 25), 
	('Arc en bois', 'arme', 5), 
	('Arc en fer', 'arme', 8), 
	('Arc en argent', 'arme', 15), 
	('Cape de héros Niv. 13', 'armure', 23), 
	('Pierre brute', 'matériau', 1), 
	('Grimoire de sorts Niv. 30', 'magie', 30), 
	('Enclos à bétail', 'elevage', 14), 
	('Sacoche 20 emplacements', 'stockage', 8), 
	('Anneau rouillé', 'accessoire', 10), 
	('Sceptre des anciens Niv. 40', 'arme', 41), 
	('Mitaines en cuir Niv. 4', 'armure', 4);

	INSERT INTO `fv_playertrades`(`playertrade_seller`, `playertrade_buyer`, `playertrade_item`, `playertrade_date`)
	VALUES
	(2, 1, 1, '2020-01-17 14:37:23'), 
	(7, 6, 9, '2020-01-17 15:10:01'), 
	(6, 1, 5, '2020-01-17 18:43:18'), 
	(5, 4, 4, '2020-01-18 02:08:17'), 
	(1, 2, 1, '2020-01-19 00:00:36'), 
	(1, 2, 6, '2020-01-19 00:15:43'), 
	(2, 7, 8, '2020-01-20 09:24:54'), 
	(7, 5, 3, '2020-01-23 12:28:00'), 
	(7, 2, 10, '2020-01-24 10:10:10'), 
	(6, 5, 2, '2020-01-24 10:10:26'), 
	(6, 5, 11, '2020-01-26 19:44:27'), 
	(2, 7, 7, '2020-01-27 21:33:03');
```
On retrouve la table des joueurs fv_players, ça pas de changement : player_name, player_level, etc mais cette fois ci au lieu d'avoir un player_class comme en avait dans data6.sql, j'ai juste changer le nom et ce n'est plus une chaîne cette fois ci c'est là que c'est important mais c'est un identifiant donc une clé étrangères d'accord. 

J'ai pas mis les contraintes, je me suis pas embêté à mettre les contraintes j'aurais pu mais pour pas non plus alourdir le fichier, il n'y a pas de contraintes marquées et peu importe mais en tout cas ce player_ability est un entier qui va correspondre à une valeur d'identifiant dans fv_abilities.
```txt
	fv_players				fv_abilities
	----------				------------
	player_ability <------>	id_ability
```
Evidemment si vous voulez faire ça vraiment propre que ce soit nickel à ce niveau-là on peut ajouter des contraintes pour que en fait vous ne puissiez pas par exemple ajouter une information qui n'existerait pas ou en fonction de ce que vous voulez permettre la suppression automatique de certaines données en fonction de ce que vous supprimez, ce que vous mettez à jour, tout ça, c'est l'intérêt des contraintes et c'est ce qu'on avait déjà vue dans des vidéos précédentes.

Donc là je vais dire va par exemple un tel joueur aura un numéro qui correspondra en fait à un identifiant d'habilité qui est relié comme vous le voyez dans cette table fv_abilities et qui possède donc un nom d'accord ability_name donc on aura en fait le nom de la classe pour les joueurs.
```sql
	CREATE TABLE IF NOT EXISTS `fv_abilities`
	(
		`id_ability` INT NOT NULL AUTO_INCREMENT, 
>		`ability_name` VARCHAR(30) NOT NULL UNIQUE, 
		PRIMARY KEY(`id_ability`)
	);
```
Au lieu d'avoir mis directement dans la table des joueurs, on le met dans une nouvelle table fv_abilities et comme ça on a les informations ability_name qui pourra du coup cette table fv_abilities être reliée à plein d'autres tables au niveau de notre base.

C'est là que ça va être intéressant.

On retrouve la même table pour les échanges fv_playertrades donc cette fois-ci même chose j'ai viré tout ce qui était en rapport avec des chaînes de caractères pour n'utiliser que des clés donc ici le vendeur ce sera ici un identifiant de joueurs.

L'acheteur ce sera également un identifiant de joueurs et pour playertrade_item donc l'objet ce n'est plus le nom de l'objet directement mais c'est également une clé vers une nouvelle table fv_items et notamment un identifiant d'objets qui permet donc pour chacun des objets d'avoir un nom, un type et un prix de vente par exemple.
```txt
	fv_playertrades			fv_items
	---------------			--------
	playertrade_item <---->	id_item
```
On peut imaginer tout un tas d'autres tables qu'on pourrait ajouter, d'autres relations qu'on pourrait faire.

A partir de là enregistrement justement de quelques joueurs, ça y'a pas eu de changement je crois par rapport à la séance précédente.
```sql
	INSERT INTO fv_players ...
```
Les classes sont maintenant ici d'accord à part dans une table spécialement pour elle.
```sql
	INSERT INTO fv_abilities ...
```
On a les objets voilà du jeu.
```sql
	INSERT INTO fv_items ...
```
Et on a tous les toutes les transactions qui ont été effectués.
```sql
	INSERT INTO fv_playertrades 
	...
	(2, 1, 1, '2020-01-17 14:37:23'), 
	(7, 6, 9, '2020-01-17 15:10:01'),
	...
```
Il n'y a plus que des identifiants pour les vendeurs, les acheteurs et l'objet qui est passé en fait dans la transaction tout simplement.

On va importer ce fichier donc ça vous l'avez déjà fait maintenant plusieurs fois donc vous avez l'habitude. On va démarrer le client ok.
```sql
	SOURCE C:/SQL/cours/017_Jointures/data7.sql;
```
Alors je vais par vérifier chaque information, pensez à bien le faire votre côté mais même chose j'ai déjà fait maintenant plusieurs fois en vidéo donc on va gagner un peu de temps là-dessus et puis je vais juste faire un show tables pour voir que tout est bien là.
```sql
	mysql> use fv_database;
	Database changed
	mysql> show tables;
	+-----------------------+
	| Tables_in_fv_database |
	+-----------------------+
	| fv_abilities          |
	| fv_items              |
	| fv_players            |
	| fv_playertrades       |
	+-----------------------+
	4 rows in set (0.00 sec)

mysql> select * from fv_players;
+-----------+-------------+--------------+----------------+
| id_player | player_name | player_level | player_ability |
+-----------+-------------+--------------+----------------+
|         1 | BigBoss_89  |           15 |              1 |
|         2 | Sephiroth   |           37 |              5 |
|         3 | Nephion     |           23 |              6 |
|         4 | Cladjuju    |            1 |              2 |
|         5 | Haryko      |            1 |              3 |
|         6 | Greg_war    |           16 |              5 |
|         7 | Icekissy    |           50 |              4 |
+-----------+-------------+--------------+----------------+
7 rows in set (0.00 sec)

mysql> select * from fv_items;
+---------+-----------------------------+-------------+----------------+
| id_item | item_name                   | item_type   | item_sellprice |
+---------+-----------------------------+-------------+----------------+
|       1 | Épée en mousse              | arme        |              2 |
|       2 | Potion de furtivité         | consommable |              4 |
|       3 | Extrait de rubis            | minerau     |             25 |
|       4 | Arc en bois                 | arme        |              5 |
|       5 | Arc en fer                  | arme        |              8 |
|       6 | Arc en argent               | arme        |             15 |
|       7 | Cape de héros Niv. 13       | armure      |             23 |
|       8 | Pierre brute                | matériau    |              1 |
|       9 | Grimoire de sorts Niv. 30   | magie       |             30 |
|      10 | Enclos à bétail             | elevage     |             14 |
|      11 | Sacoche 20 emplacements     | stockage    |              8 |
|      12 | Anneau rouillé              | accessoire  |             10 |
|      13 | Sceptre des anciens Niv. 40 | arme        |             41 |
|      14 | Mitaines en cuir Niv. 4     | armure      |              4 |
+---------+-----------------------------+-------------+----------------+
14 rows in set (0.00 sec)

mysql> describe fv_abilities;
+--------------+-------------+------+-----+---------+----------------+
| Field        | Type        | Null | Key | Default | Extra          |
+--------------+-------------+------+-----+---------+----------------+
| id_ability   | int         | NO   | PRI | NULL    | auto_increment |
| ability_name | varchar(30) | NO   | UNI | NULL    |                |
+--------------+-------------+------+-----+---------+----------------+
2 rows in set (0.00 sec)
```
Voilà on a des informations qui sont disponibles à priori d'où il n'y a pas de problème.

Des champs comme item_type, on ne s'en servira pas c'est juste mis là pour que vous ayez un petit visuel histoire de pas avoir des tables avec pas grand chose comme information, travailler comme ça sur des exemples assez illustratif on va dire pour cette partie là puisque les jointures encore une fois sont très importantes, ça va vraiment vous servir dans pas mal de choses.

On va aller tranquillement, on ne va pas trop se presser au niveau des jointures très simplement ça va permette de faire la relation entre plusieurs tables donc là l'avantage de ce système c'est que on a organisé nos informations entre différentes tables donc ça pas de problème on économise comme ça au niveau des informations que l'on stocke et c'est très pratique pour l'évolutivité donc la maintenance en fait de notre base de données.

Comme je vous ai dit imaginons que ça ça représente donc une base de données pour un jeu vidéo, à tout moment je peux ajouter de nouvelles classes dans fv_ability, de nouveaux joueurs fv_players peuvent s'inscrire, on pourra ajouter des nouveaux objets au jeu fv_items et s'il y a de nouveaux échanges qui sont entre les joueurs pas de problème ça s'enregistrera dans fv_playertrades. Tout est cohérent on a donc des données qui sont chacune dans des tables, partie spécifique, pas de problème, pas de problème mais forcément à partir de là si on veut par exemple, je sais pas moi, lister tous les joueurs de mon jeu et je veux également voir quelle classe ils utilisent dans mon jeu naturellement au plus simple on peut faire simplement un petit select étoile from fv_players.
```sql
	mysql> select * from fv_players;
	+-----------+-------------+--------------+----------------+
	| id_player | player_name | player_level | player_ability |
	+-----------+-------------+--------------+----------------+
	|         1 | BigBoss_89  |           15 |              1 |
	|         2 | Sephiroth   |           37 |              5 |
	|         3 | Nephion     |           23 |              6 |
	|         4 | Cladjuju    |            1 |              2 |
	|         5 | Haryko      |            1 |              3 |
	|         6 | Greg_war    |           16 |              5 |
	|         7 | Icekissy    |           50 |              4 |
	+-----------+-------------+--------------+----------------+
	7 rows in set (0.00 sec)
```
fv_players et en récupérant ces informations on se retrouve avec ça ce qui est parfaitement logique puisque c'est ce que nous avons enregistré ici, INSERT INTO fv_players ... d'accord ce sont toutes ces informations.

Le problème c'est que si je lis ça moi par exemple ben tiens Sephiroth qu'est-ce qu'il joue comme classe ? hé bien tiens il joue la classe 5, pas
pratique.

Le moyen d'aller voir c'est de faire un select donc je fait une deuxième requête et je fais ça, je dois chercher où est le 5 et à quoi il correspond.
```sql
	mysql> select * from fv_abilities;
	+------------+--------------+
	| id_ability | ability_name |
	+------------+--------------+
	|          2 | Archer       |
	|          6 | Barde        |
	|          7 | Démoniste    |
	|          1 | Guerrier     |
	|          8 | Ingénieur    |
	|          4 | Mage blanc   |
	|          5 | Mage noir    |
	|          3 | Voleur       |
	+------------+--------------+
	8 rows in set (0.00 sec)
```
C'est Mage noir et à ce moment là je peux savoir.

Moi j'aimerais pouvoir lister tous mes joueurs est lister directement la classe qui est utilisé c'est à dire le nom en fait de cette classe pour cela comme il y à des informations qui proviennent en fait de deux tables différentes, on va utiliser ce qu'on appelle une jointure justement on va faire une relation entre deux tables pour récupérer toutes les informations que l'on veut dans l'une ou l'autre ou les deux de ces tables en fonction donc on n'y va, on passe à notes.sql

On sélectionne toute l'information qu'on veut alors information si vous avez pris la mauvaise habitude selon en tout cas de mettre des noms de champs identiques entre plusieurs tables n'oubliez pas de préciser toujours le nom de la table, de mettre un point et ensuite de mettre le nom du champ d'accord.

Comme les noms des champs sont tous différents càd que les informations que je mets à playertrade_seller sont tous des noms qui sont différents dans chacun des cas, il n'y n'est pas besoin de mettre le nom de la table par rapport à ça donc je veux le nom de l'utilisateur, je veux le niveau de son personnage et je veux le nom de sa classe c'est à dire ability_name dans fv_abilities d'accord.
```sql
	SELECT player_name, player_level, ability_name
```
Jusque là pas de problème ça ce que je veux faire en fait c'est le listing de mes joueurs, je veux pas lister mes classes ça je m'en fiche, je veux vraiment faire la liste des joueurs donc ça provient de cette table là.
```sql
	SELECT player_name, player_level, ability_name
	FROM fv_players
```
Mais si je fais que ça il va chercher ability_name dans la table des joueurs, il ne va pas trouver le champ ça va faire une erreur de syntaxe et votre requête ne fonctionnera pas donc on va créer une jointure pour relier la table des players à la table des habilités pour cela on va procéder à la jointure la plus standard qu'on peut trouver en sql c'est la fameuse jointures interne c'est à dire qui est faite directement qui concerne en fait en interne les différentes tables de votre base.
```sql
	SELECT player_name, player_level, ability_name
	FROM fv_players
	INNER JOIN fv_abilities
```
On fait INNER JOIN, la seconde table fv_abilities et préciser sur quoi nous faisons la relation, la jointure entre ces deux tables. En gros c'est ça c'est de dire que pour player_ability de fv_players ça correspond au fait au id_ability de ma table fv_abilities donc là exceptionnellement je vais mettre le nom des tables même si encore une fois dans mon cas je n'en ai pas besoin puisque j'ai des noms de champ différent mais pour préciser que cette information player_ability c'est la clé étrangères en fait qui correspond à la clé primaire en fait id_ability de la table fv_abilities.
```sql
SELECT player_name, player_level, ability_name
FROM fv_players
INNER JOIN fv_abilities ON fv_players.player_ability = fv_abilities.id_ability;
```
On va retourner et on va exécuter la requête et voilà les informations que nous récupérons.
```sql
	mysql> SELECT player_name, player_level, ability_name
		-> FROM fv_players
		-> INNER JOIN fv_abilities ON fv_players.player_ability = fv_abilities.id_ability;
	+-------------+--------------+--------------+
	| player_name | player_level | ability_name |
	+-------------+--------------+--------------+
	| BigBoss_89  |           15 | Guerrier     |
	| Sephiroth   |           37 | Mage noir    |
	| Nephion     |           23 | Barde        |
	| Cladjuju    |            1 | Archer       |
	| Haryko      |            1 | Voleur       |
	| Greg_war    |           16 | Mage noir    |
	| Icekissy    |           50 | Mage blanc   |
	+-------------+--------------+--------------+
	7 rows in set (0.00 sec)
```
Cette requête interne, jointure interne pour être plus exact va retourner en fait les enregistrements dans le cas où les informations de la table A et la table B existent. Qu'est-ce que ça veut dire ? En gros on va retourner tous les joueurs qui ont forcément une classe et en même temps j'ai rendu obligatoire le fait de renseigner une classe donc on ne peut pas avoir un joueur sans classe ce n'est pas possible.
```sql
	CREATE TABLE IF NOT EXISTS `fv_players`
	(
		`id_player` INT NOT NULL AUTO_INCREMENT, 
		`player_name` VARCHAR(65) NOT NULL UNIQUE, 
		`player_level` INT NOT NULL, 
>		`player_ability` INT NOT NULL, 
		PRIMARY KEY(`id_player`)
	);
```
La manière dont on a conçu notre base de données, on estime que tout joueur a forcément une classe mais on pourrait très bien ajouter des nouvelles classes que aucun joueur n'a encore joué donc là si vous voyez deux classes que j'ai ajoutés par rapport à la séance précédente Démoniste et Ingénieur ne sont pas utilisés en fait par des joueurs, aucun joueur n'utilise ces classes.

Du coup niveau de mes résultats, je n'ai nulle pas en fait mention de ces classes, on retourne simplement les joueurs et les classes en fait qui correspondent donc il faut que les informations des deux tables soit valide d'accord on ne va jamais retourner en fait des informations dans le cas où on aurait des joueurs sans classe ou des classes qui ne sont pas utilisés par des joueurs mais là on a automatiquement toute l'information que l'on veut et c'est forcément plus lisible grâce à la requête et jointure, on a toutes les informations qu'on veut plus lisible.

On a plus les identifiants de classes ce qui est quand même bien pratique on a directement leur nom c'est beaucoup plus lisible. Là on voit que Sephiroth est effectivement un Mage noir d'un seul coup d'oeil, c'est plus simple de travailler comme ça.

Ca c'est la requête encore une fois la plus standard que l'on peut avoir dans ce sens là donc c'est à connaître.

Si vous avez déjà fait du sql ou si un jour de façon vous fait pas mal de recherches là dessus vous pourrez tomber sur une syntaxe, vous allez avoir 2 tables qui sont précisées là par exemple.
```sql
	SELECT player_name, player_level, ability_name
>	FROM fv_players, fv_abilities
```
Et là au lieu d'avoir une jointure indiqué comme ça, on a simplement une clause where qui refait ce que je vous ai montré tout à l'heure c'est à dire fv_players.player_ability = fv_abilities.id_ability.
```sql
SELECT player_name, player_level, ability_name
FROM fv_players, fv_abilities
WHERE fv_players.player_ability = fv_abilities.id_ability;
```
Là on vire la jointure mais on fait une clause where en fait pour indiquer la relation donc c'est une autre possibilité mais qui n'est pas pratique dans le sens niveau syntaxe puisque dans une jointure vous pourriez avoir une clause where c'est à dire que là s'il faut gérer plusieurs informations dans la clause where, vous allez très vite perdre en lisibilité au niveau de votre syntaxe.

Vous pouvez vous servir de cette syntaxe mais ce n'est pas forcément la plus recommandée. L'avantage quand même de la jointure déjà c'est qu'on ne voit plus facilement qu'effectivement il s'agit d'une jointure d'accord c'est plus explicite et sans problème si à un moment donné je veux filtrer des résultats je fait ma clause where ici.
```sql
SELECT player_name, player_level, ability_name
FROM fv_players
INNER JOIN fv_abilities ON fv_players.player_ability = fv_abilities.id_ability
WHERE player_level > 10;
```
```sql
mysql> SELECT player_name, player_level, ability_name
    -> FROM fv_players
    -> INNER JOIN fv_abilities ON fv_players.player_ability = fv_abilities.id_ability
    -> WHERE player_level > 10;
+-------------+--------------+--------------+
| player_name | player_level | ability_name |
+-------------+--------------+--------------+
| BigBoss_89  |           15 | Guerrier     |
| Sephiroth   |           37 | Mage noir    |
| Nephion     |           23 | Barde        |
| Greg_war    |           16 | Mage noir    |
| Icekissy    |           50 | Mage blanc   |
+-------------+--------------+--------------+
5 rows in set (0.00 sec)
```
Là Cladjuju et Haryko ne sont pas affichés parce que ces joueurs n'ont pas atteint le niveau 10 mais il n'ont même pas dépasser niveaux 2 donc on peut filtrer sans problème et c'est beaucoup plus lisible comme ça donc à vous de voir mais je vous conseille quand même plutôt d'utiliser INNER JOIN plutôt que d'utiliser directement une clause where en fait sinon ça vous rajoute des noms de tables qu'il faut passer dans la partie from ce qui n'est pas forcément l'idéal.

Là au moins on voit bien qu'on a la première table qui est en relation avec la seconde selon ce shéma de clé, cette clé player_ability qui est rattachée à celle ci id_ability, beaucoup plus lisible.

Après si on veut mettre plein de clauses where derrière, on peut les faire.

Si on veut mettre un order by, on le met à la suite il n'y a pas de problème, on peut le placer sur player_name, player_level et cetera.

C'est bien plus pratique de fonctionner comme ça.

Ca c'est la première requête en tout cas la première type de jointures voilà pour cette information-là éventuellement même si c'est pas l'idéal mais il faut que je vous montre parce qu'il faut savoir que ça existe en sql si vous avez un cas particulier où entre plusieurs tables vous avez des champs qui possèdent le même nom et qui sont du même type de données, vous pouvez effectuer ce qu'on appelle une jointure naturelle.

La jointure naturelle c'est très simple, je vais faire genre une sélection complète d'une premier table et on fait natual join d'une autre table en mettant une égalité entre 2 champs id ce qui est évidemment une très mauvaise idée.
```sql
	SELECT *
	FROM  fv_players
	NATURAL JOIN fv_abilities ON fv_players.id = fv_abilities.id;
```
2 champs qui s'appelle id du coup qui ont le même nom qui sont de même type.

Voilà si vous avez un cas particulier comme ça vous pouvez faire une jointure naturelle et ce n'est pas encore une fois le meilleur non plus puisque je vous conseille quand même plutôt d'avoir des noms de champ différent pour chacune des tables, c'est plus pratique surtout et ça permet de rien qu'en lisant sa requête, on sait à quoi font références les informations et surtout ça évite de toujours indiquer les noms des tables.

Mine de rien quand on met des préfixes (player_...) tout ça on s'y retrouve mieux parce que si par exemple je les enlève et vous voyez tout de suite si un jour vous avez name vous ne savez pas si ça correspond à un nom d'objets ou si ça correspond un nom de
joueur.
```txt
	fv_players
	----------
	id_player		--> id
	player_name		--> name
	player_level	--> level
	player_ability	--> ability
```
L'avantage quand on est beaucoup plus précis ça rajoute peut-être des caractères au niveau des noms vous devrez écrire plus de choses et vous allez largement largement économiser au niveau de vos requêtes et ça évite comme ça ce genre de type de jointure là mais sachez que ça existe on peut faire une kointure naturelle comme ça dans le cas où la relation se fait entre deux clés qui porte le même nom de colonnes et le même type de données. Ca ces deux informations obligatoires pour ce type de jointure soit faisable.

Je voulais vous en parler c'était bien de le savoir, on va passer à un autre type et après bon de toute façon le dernier je pourrais pas vous montrer puisque en fait MySQL ne le prend en charge donc vous pourrez éventuellement le tester de votre côté si vous travailler sur oracle ou autre sgbd et je vous en parlerais quand même rapidement en fin de vidéo.

Nous allons passer à un autre cas de jointure qui va permettre et là pour le coup ça va être intéressant par rapport à ce que je vous ai mis dans cette base de données, récupérer certains enregistrements.

En gros moi je vais faire ça on va faire select * from fv_abilities d'ailleurs on va faire ça comme ça.
```sql
	SELECT *
	FROM fv_abilities
```
Je récupére la liste des habilités donc toutes les classes que j'ai dans mon jeu et je vais faire une jointure gauche donc c'est des jointures externe cette fois-ci, vous pouvez écrire LEFT JOIN ou LEFT OUTER JOIN comme ceci mais ce mot OUTER est facultatif on n'est pas obligé de le mettre et ça raccourci en ne le mettant pas.
```sql
	SELECT *
	FROM fv_abilities
	LEFT JOIN
```
Vous faites ça comme ça et cette relation je vais la faire avec fv_players et même chose ça sous-entend id_ability égal player_ability.
```sql
SELECT *
FROM fv_abilities
LEFT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability;
```
En gros j'ai inversé voyez là fv_abilities devient la table A et fv_players devient la table B, tout à l'heure c'était l'inverse mais peu importe je vous ai montré pourquoi j'ai fait dans ce sens là par rapport à cette requête.

Voilà les enregistrements que ça me retourne donc ça retourne tous les champs des deux tables.
```sql
mysql> SELECT *
    -> FROM fv_abilities
    -> LEFT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability;
+------------+--------------+-----------+-------------+--------------+----------------+
| id_ability | ability_name | id_player | player_name | player_level | player_ability |
+------------+--------------+-----------+-------------+--------------+----------------+
|          2 | Archer       |         4 | Cladjuju    |            1 |              2 |
|          6 | Barde        |         3 | Nephion     |           23 |              6 |
|          7 | Démoniste    |      NULL | NULL        |         NULL |           NULL |
|          1 | Guerrier     |         1 | BigBoss_89  |           15 |              1 |
|          8 | Ingénieur    |      NULL | NULL        |         NULL |           NULL |
|          4 | Mage blanc   |         7 | Icekissy    |           50 |              4 |
|          5 | Mage noir    |         2 | Sephiroth   |           37 |              5 |
|          5 | Mage noir    |         6 | Greg_war    |           16 |              5 |
|          3 | Voleur       |         5 | Haryko      |            1 |              3 |
+------------+--------------+-----------+-------------+--------------+----------------+
9 rows in set (0.01 sec)
```
Si vous remarquez dans les résultats voyé qu'à certains endroits c'est marqué NULL NULL NULL et c'est tout à fait cohérent par rapport à ce que je vous ai dit. J'avais dit qu'il y avait des classes en fait qui n'était pas encore joué par des joueurs et du coup quand on fait notre jointures eh bien ces informations là sont indiqués comme NULL càd qu'elles n'existent pas en fait voilà il n'y a aucun joueur correspondant, qui joue en tant que démoniste, aucun joueur qui est un ingénieur donc ces informations sont retournés de cette manière.

En gros une jointure gauche comme c'est indiqué là va dire de retourner tous les enregistrements de la première table c'est celle qu'on met dans le FROM (fv_abilities) même si il n'y a pas d'information qui existe dans la seconde (fv_players) donc là je lui ai dit tu me retourne la liste de toutes les classes de mon jeu même s'il y a des joueurs qui ne se servent pas de certaines d'entre elles peu importe.

Je veux mon listings au complet même si certains ne sont pas utilisés.

Alors si j'avais fait un inner join, une jointure interne comme on l'a vu juste avant rappelé vous ces enregistrements n'était pas retourné, on n'aurait pas eu Démoniste et Ingénieur.

On peut d'ailleurs juste en changeant comme ça, l'avantage si vous changez un mot ça vous change le type de jointures.
```sql
SELECT *
FROM fv_abilities
INNER JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability;
```
```sql
mysql> SELECT *
    -> FROM fv_abilities
    -> INNER JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability;
+------------+--------------+-----------+-------------+--------------+----------------+
| id_ability | ability_name | id_player | player_name | player_level | player_ability |
+------------+--------------+-----------+-------------+--------------+----------------+
|          1 | Guerrier     |         1 | BigBoss_89  |           15 |              1 |
|          5 | Mage noir    |         2 | Sephiroth   |           37 |              5 |
|          6 | Barde        |         3 | Nephion     |           23 |              6 |
|          2 | Archer       |         4 | Cladjuju    |            1 |              2 |
|          3 | Voleur       |         5 | Haryko      |            1 |              3 |
|          5 | Mage noir    |         6 | Greg_war    |           16 |              5 |
|          4 | Mage blanc   |         7 | Icekissy    |           50 |              4 |
+------------+--------------+-----------+-------------+--------------+----------------+
7 rows in set (0.01 sec)
```
Voilà automatiquement, on voit la différence on ne récupère pas les enregistrements ici qui n'existe pas dans les deux cas.

Attention la jointure interne, le inner join dans le cas où il existe les informations dans les deux tables à la fois.

Ici on dit simplement la table de gauche, on parle généralement de la première table quand on parle de table de gauche c'est fv_abilities et table de droite c'est fv_players, table A et table B, et là pas besoin forcément que l'information existe dans l'autre table, on les retourne.

On peut faire sinon une information inverse c'est à dire de faire l'inverse par exemple du inner join d'accord de récupérer en fait ce qui n'a pas d'enregistrement sur l'autre table.

Pour cela alors je vais faire comme ça un left join et on va rajouter une clause where.
```sql
SELECT *
FROM fv_abilities
LEFT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability
WHERE fv_players.player_ability IS NULL;
```
```sql
	mysql> SELECT *
		-> FROM fv_abilities
		-> LEFT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability
		-> WHERE fv_players.player_ability IS NULL;
	+------------+--------------+-----------+-------------+--------------+----------------+
	| id_ability | ability_name | id_player | player_name | player_level | player_ability |
	+------------+--------------+-----------+-------------+--------------+----------------+
	|          7 | Démoniste    |      NULL | NULL        |         NULL |           NULL |
	|          8 | Ingénieur    |      NULL | NULL        |         NULL |           NULL |
	+------------+--------------+-----------+-------------+--------------+----------------+
	2 rows in set (0.00 sec)
```
voilà là on fait donc je vous explique, je vous ai fait le petit exemple, j'ai refait la même chose d'accord ma petite jointures mais je lui ai dit du coup de filtrer les résultats dans les cas où parmi donc les classes que je récupère dans mon select il n'y a pas de joueur en fait attribués à ces classes.

Donc là il a fait l'inverse de la jointure interne c'est à dire de retourner en fait ce qu'il avait dans un enregistrement qui n'existait pas de l'autre côté donc là on observe du coup on a même plus juste faire par exemple ça.
```sql
SELECT ability_name
FROM fv_abilities
LEFT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability
WHERE fv_players.player_ability IS NULL;
```
Admettons là je suis en train de faire des statistiques, j'ai un jeu, j'ai créé des classes, et cetera, je veux savoir quelle classe ne sont pas utilisés par mes joueurs donc je fais ça.
```sql
	mysql> SELECT ability_name
		-> FROM fv_abilities
		-> LEFT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability
		-> WHERE fv_players.player_ability IS NULL;
	+--------------+
	| ability_name |
	+--------------+
	| Démoniste    |
	| Ingénieur    |
	+--------------+
	2 rows in set (0.00 sec)
```
Et voilà je sais que démoniste et ingénieur ne sont pas encore joué par des joueurs sur le jeu tout simplement d'accord.

C'est pour ça que j'ai inversé les tables parce que comme je vous l'avais dit dans notre cas, on s'est arrangé pour que tous les joueurs aient forcément une classe donc si j'avais gardé l'autre ordre, que j'arais fait par exemple à l'envers en fait là ça n'aurait pas été bon parce que tous les joueurs ont forcément une classe donc ils ont tous en fait une information qui existe.

C'est pour ça que j'ai inversé l'information pour que l'exemple fonctionne par rapport à la base de données que je vous ai fourni donc ça pareil on peut du coup via ce type de jointure récupérer tout un tas d'informations.

cette petite clause permet en fait tout simplement récupérer les enregistrements moins ce qui fait le croisement entre les deux tables.

En gros ça dit tu récupère toutes les informations de la première table fv_abilities mais tu retires donc grâce à cette clause where tout ce qui est en relation également avec l'autre table, ce qui existerait dans l'autre table.

Alors pour cela je vous ai fait des petits schémas que vous pouvez récupérer également sur le Github qui est disponible dans la description des vidéos aussi via un petit lien et comme ça je vous ai repris un petit peu chacune des jointures.

Pour résumer rapidement,
![schema-jointures-tables.png](schema-jointures-tables.png)
<!--
	A B
	 x		Jointure interne : 			SELECT * FROM tA INNER JOIN tB ON tA.id = tB.id
	 x		Jointure naturelle :		SELECT * FROM tA NATURAL JOIN tB
										Au moins une colonne de même type entre les deux tables.
			Jointure externe gauche :
	xx			SELECT * FROM tA LEFT JOIN tB ON tA.id = tB.id
	x			SELECT * FROM tA LEFT JOIN tB ON tA.id = tB.id WHERE tB.id IS NULL
			Jointure externe droite :	
	 xx			SELECT * FROM tA RIGHT JOIN tB ON tA.id = tB.id
	  x			SELECT * FROM tA RIGHT JOIN tB ON tA.id = tB.id WHERE tB.id IS NULL
			Jointure externe pleine :
	xxx			SELECT * FROM tA FULL JOIN tB ON tA.id = tB.id
	x x			SELECT * FROM tA FULL JOIN tB ON tA.id = tB.id WHERE tA.id IS NULL OR tB.id IS NULL
-->
La jointure interne ça correspond à ça càd qu'il faut que l'information existe à la fois dans les deux tables c'est pour ça que j'ai ici coloré la partie qui rassemblé 2 ok.

La jointure naturelle donc là je vous ai précisé ce que j'ai dit tout à l'heure, il faut qu'il y ait au moins une colonne de même nom et de même type d'accord dans les deux tables donc ça évidemment je vous la recommande pas spécialement la jointure naturelle mais sachez que ça existe si un jour vous l'a rencontrée dans un fichier ou outre ou travailler dans une base de données qui elle s'en sert ou qui se sert de ce genre de requête, vous savez que ça existe et vous savez vous saurez comment ça fonctionne.

Et après on retrouve les fameuses jointures externes gauche LEFT JOIN donc on a en premier l'exemple principal qui a dit voilà comme on l'a dit la liste de toutes les classes même si elles ne sont pas utilisées par les joueurs d'accord voilà on exclut en fait, on s'en fiche on fait de savoir qu'elles sont utilisées ou pas et en second c'est en fait l'autre partie de dire tout simplement la liste d'accord mais qui ne sont pas utilisés en fait d'accord certes ça c'est toutes les classes mais pas utilisés par les joueurs. Voyez qu'on inclut pas B on retire cette partie là et c'est pour ça qu'on avait que c'est 2 là.
```sql
	mysql> SELECT ability_name
		-> FROM fv_abilities
		-> LEFT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability
		-> WHERE fv_players.player_ability IS NULL;
	+--------------+
	| ability_name |
	+--------------+
	| Démoniste    |
	| Ingénieur    |
	+--------------+
	2 rows in set (0.00 sec)
```
Voilà c'est histoire que vous voyez un petit peu différente dés qu'on ajoute cette clause where en fait par rapport aux filtres que ça fait.

A l'inverse parce que je ne vais pas vous montrer de requêtes dessus parce ce que c'est exactement la même chose c'est l'inverse, ce sont les requêtes droites donc la requête RIGHT JOIN c'est la même chose mais vous voyez sur la table à l'envers donc ça vous pas honnêtement besoin de vous en servir puisque si vous voulez au pire faire inverse même avec un left il suffit simplement changer les noms des tables ici d'accord donc ça c'est à vous de voir.
```sql
	SELECT ability_name
>	FROM fv_abilities
>	LEFT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability
	WHERE fv_players.player_ability IS NULL;
```
Sachez que ça existe, on peut l'utiliser il suffit de remplacer avec left par right et en fait ça fait l'inverse c'est-à-dire la liste des joueurs, je peut même l'exécuter.
```sql
SELECT ability_name
FROM fv_abilities
RIGHT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability
WHERE fv_players.player_ability IS NULL;
```
```sql
	mysql> SELECT ability_name
		-> FROM fv_abilities
		-> RIGHT JOIN fv_players ON fv_abilities.id_ability = fv_players.player_ability
		-> WHERE fv_players.player_ability IS NULL;
	Empty set (0.00 sec)
```
Voilà ça me retourne rien parce qu'on vous dit que tous les joueurs ont forcément une classe.

Alors on peut le faire peut-être maintenant sur un autre exemple par contre on va reprendre le left et on va travailler sur la liste des objets voilà et on va rattacher ça à des échanges et on va faire la relation entre l'item donc l'identifiant de l'objet et playertrade_item.
```sql
SELECT item_name
FROM fv_items
LEFT JOIN fv_playertrades ON fv_items.id_item = fv_playertrades.playertrade_item;
```
D'ailleurs je vous remontez les informations pour les objets nous avons un nom, un type, etc sur fv_items et dans nos échanges nous avons l'identifiant qui correspond à l'objet en question, c'est l'information qu'il y a en troisième colonne de fv_playertrades.

Ca permet via cette petite jointure de récupérer toutes ces informations là.
```sql
	mysql> SELECT item_name
		-> FROM fv_items
		-> LEFT JOIN fv_playertrades ON fv_items.id_item = fv_playertrades.playertrade_item;
	+-----------------------------+
	| item_name                   |
	+-----------------------------+
	| Anneau rouillé              |
	| Arc en argent               |
	| Arc en bois                 |
	| Arc en fer                  |
	| Cape de héros Niv. 13       |
	| Enclos à bétail             |
	| Épée en mousse              |
	| Épée en mousse              |
	| Extrait de rubis            |
	| Grimoire de sorts Niv. 30   |
	| Mitaines en cuir Niv. 4     |
	| Pierre brute                |
	| Potion de furtivité         |
	| Sacoche 20 emplacements     |
	| Sceptre des anciens Niv. 40 |
	+-----------------------------+
	15 rows in set (0.01 sec)
```
Voilà comme c'est une left join, ça ce sont tous les objets que nous avons dans notre jeu même s'ils n'ont pas été en fait utilisés dans des échanges.

Si je veux voir seulement ceux utilisés dans des échanges rappelez vous il faut utiliser une jointure interne.
```sql
SELECT item_name
FROM fv_items
INNER JOIN fv_playertrades ON fv_items.id_item = fv_playertrades.playertrade_item;
```
```sql
	mysql> SELECT item_name
		-> FROM fv_items
		-> INNER JOIN fv_playertrades ON fv_items.id_item = fv_playertrades.playertrade_item;
	+---------------------------+
	| item_name                 |
	+---------------------------+
	| Épée en mousse            |
	| Grimoire de sorts Niv. 30 |
	| Arc en fer                |
	| Arc en bois               |
	| Épée en mousse            |
	| Arc en argent             |
	| Pierre brute              |
	| Extrait de rubis          |
	| Enclos à bétail           |
	| Potion de furtivité       |
	| Sacoche 20 emplacements   |
	| Cape de héros Niv. 13     |
	+---------------------------+
	12 rows in set (0.00 sec)
```
Dans ce cas la liste est beaucoup moins longue, en gros certains objets qu'on n'a pas.

En fait, je voulais voir notamment ce qui n'est pas échangé.
```sql
SELECT item_name
FROM fv_items
LEFT JOIN fv_playertrades ON fv_items.id_item = fv_playertrades.playertrade_item
WHERE fv_playertrades.playertrade_item IS NULL;
```
```sql
	mysql> SELECT item_name
		-> FROM fv_items
		-> LEFT JOIN fv_playertrades ON fv_items.id_item = fv_playertrades.playertrade_item
		-> WHERE fv_playertrades.playertrade_item IS NULL;
	+-----------------------------+
	| item_name                   |
	+-----------------------------+
	| Anneau rouillé              |
	| Mitaines en cuir Niv. 4     |
	| Sceptre des anciens Niv. 40 |
	+-----------------------------+
	3 rows in set (0.00 sec)
```
Même si des fois je vous montre pas en vidéo, je ne vous montre pas d'autre exemple sur sur toutes les tables, tout ça, je vous fournis et c'est pas pour rien des bases de données, des fichiers sql à chaque fois pour que vous puissiez de votre côté faire d'autres requête pas forcément répéter les requêtes que je montre en vidéo et puis voir que ça fait le même résultat que moi en vidéo et puis passer à la suite, non, ça vous permet aussi de faire d'autres requêtes avec tout ce que vous avez appris et vous voyez bien que vous verrez comme ça que vous pouvez récupérer plein d'autres informations donc je ne vous montre pas tout en vidéo mais pour autant vous avez de quoi travailler avec ces différents fichiers là et vous avez de quoi faire par rapport aux jointures parce que vous voyez qu'il y a plusieurs types de jointures donc on va passer très vite sur les jointures pour terminer assez vite.

Et on arrive sur un autre exemple que je ne peux pas vous montrer mais en gros voyez qu'on rajoute simplement un FULL JOIN d'accord il suffit généralement de juste remplacer le nom c'est simplement INNER JOIN, FULL JOIN, LEFT JOIN, RIGHT JOIN, il n'y a pas grand chose à remplacer au niveau de la requête en ellemême.
```sql
SELECT item_name
FROM fv_items
FULL JOIN fv_playertrades ON fv_items.id_item = fv_playertrades.playertrade_item
```
Mais moi je ne peux pas le faire parce que ça ne fonctionne pas sur le sgbd mysql et si vous travaillez sur un autre vous pouvez tester voir si c'est pris en charge par rapport à votre système de gestion et ça va permettre tout simplement de faire tout d'accord.

Ca récupère vraiment la totalité des informations et on peut éventuellement en faisant une petite clause récupérer les informations qui sont en fait exclue dans chacun des cas càd A et B mais pas ce qui en fait appartient au deux en même temps.

Vous voyez là c'est carrément l'inverse de la jointure interne, on a vraiment tout l'inverse donc ça vous pouvez si vous voulez le tester par rapport à ça.

Alors logiquement si vous avez bien suivi les différentes séances qu'on a fait jusqu'à présent même si mysql ne permet pas de faire une FULL JOIN comme ça d'accord une jointure externe pleine comme j'ai marqué ici rappelé vous avec le union d'accord on peut faire en fait ce système là.

D'accord vous pouvez utiliser avec mysql UNION qui permet en fait de faire l'union de deux tables et au final pas de faire tout simplement un `SELECT * FROM table_A` et ensuite `UNION SELECT * FROM table_B` et du coup ça fait exactement la même chose que ça sauf qu'on n'a pas forcément de relations entre deux clés mais peu importe parce que là on récupère vraiment tout donc ça on peut le faire, on peut le simuler avec un UNION en mysql bien que ce ne soit pas pris en charge directement par ce système de gestion de base de données.

Et pour finir cette séance donc là pareil, je vais vous le montrer mais ça n'a pas tellement d'intérêt parce qu'il faudra que vous ayez un jour un usage un réel et utile pour employer ce genre de jointures mais je vais vous montrez au niveau du schéma parce qu'il n'est pas forcément très très lisible et ce n'est pas pratique de faire un schéma lisible là dessus.

La jointure croisée donc là c'est simple il suffit de faire un CROSS JOIN donc on va faire très simple, on va faire `SELECT * FROM fv_players` et `CROSS JOIN fv_abilities` et on ne va pas forcément prendre tout les enregistrements.
```sql
SELECT *
FROM fv_players
CROSS JOIN fv_abilities;
```
Cette requête et donc il n'y a pas beaucoup d'information, elle va prendre chacun des champs de votre première table d'accord et elle va le rattacher, le relier avec tous les champs de la seconde table et ce pour chaque champ.

Voilà le champ A de la table A va être attaché au champ A de la table B.

Ensuite le champ B de la table A au champ B de la table B.

Voyez depuis ce champ-là j'ai mis field1 et field2 ce qui correspond à une colonne, à un enregistrement en fait, on a ça et hop on relie les champs ensembles donc ça fait en fait tout simplement le produit des deux tables d'accord, produits cartésien des 2 tables que nous avons et ça permet de récupérer en fait le produit des deux donc si vous avez 40 enregistrement, ça fait 40 x 40 tout simplement donc c'est pour le coup tout de suite en tout cas avec ce que vous avez vu pas utile comme type de requête mais dans certains cas quand on a besoin de relier en fait des informations de deux tables et bien on peut utiliser tout simplement une requête, une jointure croisée donc là si vous regardez ça retour tout ça.
```sql
mysql> SELECT *
    -> FROM fv_players
    -> CROSS JOIN fv_abilities;
+-----------+-------------+--------------+----------------+------------+--------------+
| id_player | player_name | player_level | player_ability | id_ability | ability_name |
+-----------+-------------+--------------+----------------+------------+--------------+
|         1 | BigBoss_89  |           15 |              1 |          2 | Archer       |
|         2 | Sephiroth   |           37 |              5 |          2 | Archer       |
|         3 | Nephion     |           23 |              6 |          2 | Archer       |

...

|         7 | Icekissy    |           50 |              4 |          3 | Voleur       |
+-----------+-------------+--------------+----------------+------------+--------------+
56 rows in set (0.00 sec)
```
Attention parce que ça multiplie évidemment les enregistrements d'une table par l'autre un donc ça peut faire du coup une requête assez longue puisqu'elle peut retourner beaucoup beaucoup de résultats.

Après on peut trier bien sûr on peut faire un petit order by sur player_name par exemple.
```sql
SELECT *
FROM fv_players
CROSS JOIN fv_abilities
ORDER BY player_name;
```
```sql
mysql> SELECT *
    -> FROM fv_players
    -> CROSS JOIN fv_abilities
    -> ORDER BY player_name;
+-----------+-------------+--------------+----------------+------------+--------------+
| id_player | player_name | player_level | player_ability | id_ability | ability_name |
+-----------+-------------+--------------+----------------+------------+--------------+
|         1 | BigBoss_89  |           15 |              1 |          2 | Archer       |
|         1 | BigBoss_89  |           15 |              1 |          7 | Démoniste    |
|         1 | BigBoss_89  |           15 |              1 |          4 | Mage blanc   |
|         1 | BigBoss_89  |           15 |              1 |          1 | Guerrier     |
|         1 | BigBoss_89  |           15 |              1 |          5 | Mage noir    |
...
|         2 | Sephiroth   |           37 |              5 |          6 | Barde        |
|         2 | Sephiroth   |           37 |              5 |          3 | Voleur       |
|         2 | Sephiroth   |           37 |              5 |          1 | Guerrier     |
|         2 | Sephiroth   |           37 |              5 |          5 | Mage noir    |
+-----------+-------------+--------------+----------------+------------+--------------+
56 rows in set (0.00 sec)
```
voilà il a pris pour BigBoss_89 et il a pris toutes les classes qui existent. J'ai pour le coup toutes les classes qui existent (ability_name).

Voilà donc j'ai pas vraiment d'exemples qui serait très concret à vous montrer ici parce qu'il faut savoir si ça peut avoir l'utilité. Il faut un cas où effectivement j'ai besoin de faire ce type de jointure là pour l'exemple ici il n'y en avait pas forcément d'intéressants donc sachez également que ça existe peut-être un jour vous serez amené à vous en servir, peut-être jamais c'est pas grave mais vous pouvez vous servir de ce type de jointure en sql également.

N'hésitez pas encore une fois vous avez un fichier sql qui est quand même pas mal fourni mine de rien pour vous exercer à vous servir des différentes jointures parce qu'il y a quand même plusieurs donc vous pouvez vous servir un petit peu tout ça.

Vous avez ce schéma qui est disponible dans la description de la vidéo c'est toujours attaché, voilà des liens directement depuis mon github où vous avez tout qui est disponibles, voilà des playlists ici et toutes les ressources sont disponibles où donc vous pouvez retrouver les fichiers, les schémas, les tables de onnées et cetera en fonction de vos besoins.

Profitez-en pour vous exercer, faire tout un tas de requêtes, prendre des notes, récupérer les différents fichiers pour pouvoir comme ça voilà bien comprendre un peu assimiler tout ce que vous avez vu parce que pour le coup en sql il ya beaucoup beaucoup de commandes différentes, beaucoup d'exemples de requêtes, de systèmes qu'on peut utiliser.

Pour la fin de cette formation, on n'a plus qu'à terminer avec quelques séances en fait sur des fonctions, ça je vais vous parler de fonctions qu'on pourra utiliser pour nos chaînes de caractères, pour le traitement des dates et des heures, pour tout ce qui est chiffrement où en fera un petit une petite vidéo rapide assez rapide d'ailleurs sur les questions de sécurité en sql et on pourra comme ça terminer, clore ce cour sql. Vous aurez largement vu ce qu'il faut pour pouvoir employer justement ce langage directement tout seul si vous travaillez en tant qu'administrateur de bases de données ou l'employé directement via un langage de programmation par exemple en web pour pouvoir manipuler des données ou dans un jeu vidéo aussi puisqu'on peut évidemment faire du sql un peu partout.

J'espère que cette vidéo a été suffisamment clair j'ai essayé de pas faire trop long non plus mais il fallait qu'on fasse un peu le tour de tout ça et je vous ai volontairement encore une fois fourni un fichier avec pas mal de tables, pas mal d'enregistrements pour que vous puissiez vous exercez avec plein d'autres requêtes que je n'ai pas forcément montré en vidéo et c'est l'idéal pour que vous puissiez bien comprendre ce que vous apprenez c'est un petit peu le but en tout cas de ce cours.

A bientôt tout le monde pour la prochaine séance sur formation vidéo