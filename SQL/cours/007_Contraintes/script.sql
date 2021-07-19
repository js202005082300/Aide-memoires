/*
SQL #7 - contraintes
20-12-2020

Bonjour tout le monde et bienvenue pour cette séance numéro 7 en SQL. 

La dernière fois on avait vu comment créer des tables il en avait pris également pas mal de temps pour me montrer le type de données que nous pouvons utiliser pour les informations enregistrées dans notre table  comme les types sur le chaîne de caractères, les types numériques et également les types sur les dates avec des types également séquentiels comme les SET, ce genre de chose.

Là on va passer sur certainement une des vidéos le plus important de cette formation c'est-à-dire les contraintes. 

Les contraintes c'est tout simplement un ensemble de règles que nous allons définir sur les tables et même plus exactement sur les colonnes de nos tables, sur certaines colonnes en fonction qui permettront d'établir des règles à respecter lors de l'enregistrement de nouvelles informations que l'on aura et qu'on apprendra par la suite avec les requêtes sur cette formation.

C'est vraiment important parce que tout ce que vous allez voir là va vous servir tout au long c'est-à-dire que si vous précisez correctement les contraintes sur vos tables, vous aurez moins de problèmes par la suite et vous aurez des choses beaucoup plus performantes, et beaucoup plus de cohérence avec les données donc c'est vraiment très important.

La vidéo sera un peu longue mais n'hésitez pas à la regarder en plusieurs fois si nécessaire, voir à la regarder plusieurs fois et a prendre des notes bref vous pouvez faire comme vous voulez mais il faut vraiment vraiment bien assimiler tout ce que je vais vous expliquer là pour que ce soit plus pratique pour la suite et ce qui viendra sur les prochaines vidéos. 

Alors dernièrement on avait vu grosso modo tout ce que je veux vous montrer ici.

	contraintes.sql
	---------------
	
	CREATE DATABASE IF NOT EXISTS `cours_sql`;
	USE `cours_sql`;

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6),
		`user_name` VARCHAR(30),
		`user_email` VARCHAR(100),
		`user_registration` DATE,
		`user_admin` BOOLEAN
	);
	
Tout ce que je vous ai montré ici, tout ce qu'il y a sur mon fichier ici doit être compris sans problème. 

S'il y a quelque chose que vous ne comprenez pas sur cette syntaxe, n'hésitez pas à revenir sur les anciennes vidéos si vous avez loupé quelque chose pour qu'on soit déjà clair là dessus. 

On va recréer une nouvelle base de données mais déjà on va se connecter.

	>mysqld --console
	2020-12-20T09:41:16.068430Z 0 [System] [MY-010116] [Server] C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\mysql\bin\mysqld.exe (mysqld 8.0.22) starting as process 11116
	2020-12-20T09:41:16.093819Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
	2020-12-20T09:41:17.493967Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
	2020-12-20T09:41:18.029746Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060
	2020-12-20T09:41:18.281990Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
	2020-12-20T09:41:18.282890Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
	2020-12-20T09:41:18.460334Z 0 [System] [MY-010931] [Server] C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\mysql\bin\mysqld.exe: ready for connections. Version: '8.0.22'  socket: ''  port: 3306  MySQL Community Server - GPL.
	
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
	
Voilà donc on va recréer la base de données. On va demander d'utiliser la base de données USE évidemment toujours pareil et on va créer notre table.

	mysql> CREATE DATABASE IF NOT EXISTS `cours_sql`;
	Query OK, 1 row affected (0.02 sec)

	mysql> USE `cours_sql`;
	Database changed
	
	mysql> CREATE TABLE IF NOT EXISTS `table_users`
		-> (
		-> `id_user` SMALLINT(6),
		-> `user_name` VARCHAR(30),
		-> `user_email` VARCHAR(100),
		-> `user_registration` DATE,
		-> `user_admin` BOOLEAN
		-> );
	Query OK, 0 rows affected, 1 warning (0.10 sec)
	
Ça c'est ce qu'on a vu grosso modo précédemment, c'est la même table que sur la vidéo précédente mais j'ai repris le même principe en créant une table_users qui possède un identifiant is_user qui est un petit nombre entier SMALLINT(6). On va avoir user_name donc le pseudo ou le nom simplement qui peut avoir maximum 30 caractères VARCHAR(30), si on fait moins il occupera moins d'espace en mémoire. Un e-mail user_email qui peut occuper jusqu à 100 caractères VARCHAR(100). Une date d'enregistrement, ça peut être par exemple une date d'inscription, user_registration. Et un petit booléen user_admin qui va simplement déterminer si le membre en question sera un admin d'accord donc si c'est 0, il n'est pas admin et si c'est 1 il en est un.

Voilà on a vraiment un système très simple pour que ce soit bien compréhensible pour vous et bien clair et on va partir de ça aujourd'hui pour vous expliquer les contraintes.

Alors les contraintes ce n'est pas là pour vous embêter, ça va par contre est assez contraignant à mettre en place parce qu'il va falloir réfléchir à tout mais c'est surtout pour avoir des règles logiques, avec du sens au niveau de l'enregistrement prochain de vos données. 

Dans la vraie vie vous allez avoir beaucoup de choses qui vont intervenir dans l'enregistrement des informations et grâce à SQL on est capable de les mettre en place grâce à des contraintes. 

Un exemple tout bête et on va commencer par celui-là, dans certains cas, et ça on a envie pour ceux qui font par exemple des formulaires web en html que vous exploitez ensuite avec un langage de programmation, on a envie de renseigner certains champs obligatoires c'est-à-dire qu'on veut absolument que la personne renseigne les informations et dire qu'elles sont obligatoires lors de l'enregistrement par exemple lors d'une inscription via un formulaire d'inscription. 

En revanche on peut avoir des informations qui elle serait plutôt facultative, optionnel et dont on n'est pas obligé de les renseigner.

Dans notre cas on va utiliser une première contrainte que vous allez apprendre qui la contrainte NOT NULL qui est tout simplement une contrainte qui dit que tel champ, que telle colonne de notre table doit être obligatoirement renseigné quand on va enregistrer par exemple quand on va faire un nouvel enregistrement d'utilisateur. 

On peut le faire si on veut par exemple surtout l'ensemble des données, on va dire par exemple que toutes les données qui sont là sont obligatoires. J'ai absolument besoin de les avoir donc je vais les renseigner. 

Pour le user_admin, je ne vais pas le mettre parce que ça ce n'est pas à l'utilisateur de le renseigner quand il va s'inscrire mais c'est mon système qui va le déterminer par exemple si je suis l'administrateur du site ça va être mis à 1 et par défaut pour l'utilisateur de toute façon, on pourra déterminer via un autre système de contraintes la valeur de 0. 

On reviendra sur ce champ user_admin plus précisément par la suite. 

Je pars du principe que tous ces champs là sont obligatoires donc le moyen d'ajouter cette contrainte là à la création de la table c'est d'ajouter simplement NOT NULL qui est en 2 mots, vous pouvez encore une fois le écrire en minuscule ou en majuscule mais c'est vous qui voyez. 

	`id_user` SMALLINT(6) NOT NULL,

Vous voyez que j'ai l'habitude d'écrire tout en majuscules sauf tout ce qui est nommage de table, de base de données ou les colonnes d'une table mais vous faites vraiment comme vous voulez et on met bien NOT NULL avant la virgule.
	
	contraintes.sql
	---------------
	
	CREATE DATABASE IF NOT EXISTS `cours_sql`;
	USE `cours_sql`;

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN
	);
	
Alors pour la date, on peut imaginer sur un site web quand la personne va s'inscrire on va utiliser notre langage de programmation PHP ou autre pour récupérer la date au moment de l'enregistrement et l'intégrer directement. 

Mais pour être sûr qu'à la fin, le langage de programmation ait bien enregistré la date même si user_registration n'a pas été renseigné par l'utilisateur lors de l'inscription … on veut quand même bien préciser qu'on sait et qu'on sera à l'avance que dans notre table_users à la fin tous les enregistrements des utilisateurs que nous aurons qu'il soit 500, 1000 ou 10000, on aura obligatoirement une date qui a été renseignée. 

Si ce n'est pas le cas et l'avantage de devoir renseigner une contrainte, c'est que quand on va essayer d'enregistrer un utilisateur et qu'on ne met pas ici d'information a user_registration c'est-à-dire qu'on n'a pas de date, on aura une erreur SQL grâce à NOT NULL pour nous dire qu'on n'a pas respecté une contrainte. 

Voilà leur utilité. 

Ça c'est vraiment une contrainte très simple, c'est celle qui rend obligatoire une information donc une colonne d'une table. 

Très simple, je peux vous la noter très rapidement et si vous voulez je vais voulez noter vite fait les différentes contraintes que vous avez. Vous avez donc le NOT NULL qui est un peu une colonne obligatoire si vous ne le mettez pas par exemple la personne pour s'enregistrer sans mettre de user_name et dans ce cas-là on aura un enregistrement de l'utilisateur et au champ user_name, il n'y aurait rien d'accord. 

	/
		NOT NULL (colonne obligatoire)
	/

Au champ user_name, on aurait une valeur dite nul parce que c'est le terme qu'on emploie en informatique pour ceux qui font déjà de la programmation ou autre, vous êtes bien habitué à ce type de terme. 

Voilà comment ça se passe pour le NOT NULL. 

Alors ça c'est ce qu'on peut faire à la création lorsqu'on veut créer une table mais vous savez que en SQL si vous avez déjà créé la table et que vous voulez modifier une table ou une de ces colonnes, vous pouvez le faire. 

On l'a déjà vu précédemment notamment avec le ALTER TABLE, ça veut dire altérer la table donc modifier la table. 

On va donc faire ça ALTER TABLE sur la table_users et ensuite je vais à la ligne et dire que je veux procéder à une modification éventuellement, un changement, un ajout de quelque chose OK donc ça on peut le faire.

	ALTER TABLE `table_users`

Alors comment est-ce qu'on va pouvoir le faire, on va tout simplement leur enseigner avec une modification de la valeur on va pouvoir par exemple rajouter une contrainte NOT NULL au niveau d'un champ que l'on veut. 

Alors le bon moyen de le faire et admettons que nous avions pas mit NOT NULL à user_name et on va partir du principe qu'on avait enregistrer cette requête là au niveau de ma commande MySQL.

	contraintes.sql
	---------------
	
	/
		NOT NULL (colonne obligatoire)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30),
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN
	);
	
	ALTER TABLE `table_users`
	
Et j'ai finalement envie de mettre un NOT NULL à `user_name`, Eh bien il suffira tout simplement de réécrire toute l'information donc je vais reprendre toute la ligne et finalement je veux que `user_name` devienne VARCHAR(30) donc ça ça n'a pas changé suivi de NOT NULL et on n'oublie pas le ;

	contraintes.sql
	---------------
	
	/
		NOT NULL (colonne obligatoire)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30),
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN
	);
	
	ALTER TABLE `table_users`
	`user_name` VARCHAR(30) NOT NULL;

Alors ça rappelez-vous c'est toute une requête donc elle peut tenir sur une ligne.

	ALTER TABLE `table_users` `user_name` VARCHAR(30) NOT NULL;
	
Mais bon d'ailleurs je ne suis pas sûr qu'il va être content si je fais ça mais on verra ce n'est pas grave et on va déjà enregistrer la table.

	mysql> CREATE TABLE IF NOT EXISTS `table_users`
		-> (
		-> `id_user` SMALLINT NOT NULL,
		-> `user_name` VARCHAR(30),
		-> `user_email` VARCHAR(100) NOT NULL,
		-> `user_registration` DATE NOT NULL,
		-> `user_admin` BOOLEAN
		-> );
	Query OK, 0 rows affected (0.04 sec)
	
	> describe table_users;
	+-------------------+--------------+------+-----+---------+-------+
	| Field             | Type         | Null | Key | Default | Extra |
	+-------------------+--------------+------+-----+---------+-------+
	| id_user           | smallint     | NO   |     | NULL    |       |
	| user_name         | varchar(30)  | YES  |     | NULL    |       |
	| user_email        | varchar(100) | NO   |     | NULL    |       |
	| user_registration | date         | NO   |     | NULL    |       |
	| user_admin        | tinyint(1)   | YES  |     | NULL    |       |
	+-------------------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)
	
Voilà comme ça on voit toute l'information. 

Vous voyez qu'ici table_users, colonne NULL, on voit toute l'information et voyez est-ce qu'id_user peut-être nul ? la réponse est NO, NO pour user_email, NO pour user_registration, YES pour user_admin qui peut être nul apparemment mais ça on s'en fiche et vous voyez que user_name peut l'être aussi.

On va reprendre la commande ici.

	mysql> ALTER TABLE `table_users` `user_name` VARCHAR(30) NOT NULL;
	ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '`user_name` VARCHAR(30) NOT NULL' at line 1

Et là il me dit que j'ai fait une erreur !

On a oublié de mettre un MODIFY.

	contraintes.sql
	---------------
	
	/
		NOT NULL (colonne obligatoire)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30),
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN
	);
	
	ALTER TABLE `table_users`
	MODIFY `user_name` VARCHAR(30) NOT NULL;
	
OK c'est bon !

	mysql> ALTER TABLE `table_users`
		-> MODIFY `user_name` VARCHAR(30) NOT NULL;
	Query OK, 0 rows affected (0.08 sec)
	Records: 0  Duplicates: 0  Warnings: 0

Ensuite je refais un DESCRIBE.

	> describe table_users;
	+-------------------+--------------+------+-----+---------+-------+
	| Field             | Type         | Null | Key | Default | Extra |
	+-------------------+--------------+------+-----+---------+-------+
	| id_user           | smallint     | NO   |     | NULL    |       |
	| user_name         | varchar(30)  | NO   |     | NULL    |       |
	| user_email        | varchar(100) | NO   |     | NULL    |       |
	| user_registration | date         | NO   |     | NULL    |       |
	| user_admin        | tinyint(1)   | YES  |     | NULL    |       |
	+-------------------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)
	
Voilà, c'est bon, j'avais simplement oublié le MODIFY. Je savais bien que j'avais oublié un mot, je trouvais ça bisare qu'il y ait deux champs comme ça mais comme j'ai toujours l'habitude d'écrire sur deux lignes mes requêtes comme ça.

	contraintes.sql
	---------------
	
	/
		NOT NULL (colonne obligatoire)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30),
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN
	);
	
	ALTER TABLE `table_users` MODIFY `user_name` VARCHAR(30) NOT NULL;

Donc on oublie pas le MODIFY pour modifier justement donc on ne va pas l'ajouter car on ne fait pas de ADD sinon on aurait utilisé la commande ADD pour ajouter un nouveau champ parce que c'est quelque chose qu'on pourrait faire éventuellement comme je vous en avais parlé.

Mais là comme on veut modifier quelque chose d'existant, on fait MODIFY et du coup on rajoute ici le NOT NULL donc ça peut être pas mal pratique et du coup c'est comme si on avait enregistré tout ça.

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
>		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN
	);

Voilà et du coup comme j'ai déjà créé la table là, on altérera la table à chaque fois qu'on voudra ajouter une nouvelle contrainte.

Ca c'était donc la première contrainte, c'est le NOT NULL très facile, très rapide même si j'ai pris le temps de vous l'expliquer mais c'était assez suscinte parce qu'il n'y avait pas grand chose à dire dessus.

Je pense que vous avez compris un petit peu le principe.

On peut définir également un système et ça je pense qu'on le verra un peu plus tard l'auto-incrémentation parce que je ne l'ai pas ... On verra après pour tout ce qui est cas unique, je vous en parlerais un peu plus tard parce que ce n'est pas forcément utile d'en parler tout de suite.

On va garder tout ce qui est système de clé pour plus tard parce que c'est plus compliqué à comprendre au niveau des contraintes.

On va passer maintenant à une autre contrainte.

La contrainte qui va simplement dire ... et bien on l'a vu tout à l'heure, user_admin. Voilà par exemple si je crée mon compte administrateur, il va peut être déjà être créé avant peut être même avant d'ouvrir le site.

J'aurais donc peut-être user_admin qui aura pour valeur 1 si on admet par exemple que j'enregistre une information mais je veux que par défaut dès que quelqu'un s'ajoute, dès que quelqu'un s'enregistrer sur le site ou s'inscrit qu'on ne le mette pas comme administrateur donc je veux que par défaut, on renseigne la valeur 0 à user_admin. 

Voilà parce que je ne veux pas que user_admin reste un champ vide. 

Je veux qu'à chaque fois qu'on veut enregistrer un utilisateur si c'est moi j'aurai la valeur 1 donc administrateur et toutes les autres personnes auront 0 sauf si à un moment donné je veux passer quelqu'un administrateur, et alors à ce moment-là, on fera une requête pour modifier la colonne user_admin correspondant à son enregistrement. 

Dans ce cas-là nous allons pouvoir ajouter une autre contrainte  qui est très très facile à utiliser parce que comme on a utilisé avant le NOT NULL, vous avez juste à renseigner le mot DEFAULT et vous passez ensuite la valeur soit vous passez une chaîne de caractères DEFAULT "" parce que vous avez peut-être besoin de renseigner ça, soit ça peut être simplement une fonction mais ça on le verra plus tard parce que les fonctions on ne les a pas encore vues ou un chiffre ou ce genre de chose. Moi je veux que DEFAULT soit égal à 0.

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0
	);

Voilà et du coup est-ce qu'on va altérer parce que là c'est un peu le bazar vu que j'ai déjà créé ma table. 

Alors ici c'était dans le cadre de la création de la table comme je l'avais déjà dit et on va le noter là.

	contraintes.sql
	---------------
	
	/
		NOT NULL (colonne obligatoire)
		DEFAULT (valeur par défaut)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0
	);

Voilà valeur par défaut pour DEFAULT et je pense que c'est clair, si vous voulez qu'il y ait une valeur par défaut quand on enregistre un champ ce qui sous-entend un champ non obligatoire parce que si le champ est obligatoire il y a quand même peu de chance qu'il y ait une valeur par défaut. 

C'est un cas où vous avez un champ facultatif mais si vous voulez quand même le remplir avec quelque chose vous utilisez la contrainte DEFAULT suivi de quelque chose pour remplir par défaut. 

Par contre vous voyez que l'éditeur ne colore pas comme il faut mais ce n'est pas grave parce que ce n'est pas forcément un jour partout ce qui est un petit inconvénient de certains l'éditeur de code, c'est qu'il n'applique pas la coloration sur toutes les choses donc par exemple ici SQL, ça a du mal à prendre la coloration comme il faut mais peu importe. 

Alors donc ici on a enregistré cette table là.

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0
	);

Si on veut l'altérer c'est-à-dire que notre table est déjà créée comme pour tout à l'heure on va pouvoir dire qu'on modifie notre table et du coup on ajoute cette contrainte là que nous n'avions pas pour le champ par défaut. 

On va donc pouvoir le faire très facilement et moi je vais faire un ALTER TABLE de table_users et je vais modifier cette table et qu'est-ce qu'on va lui faire ? C'est qu'on va altérer le champ que l'on voulait ici user_admin. Alors sachez que ça ce n'est pas affaire si vous l'avez mis dans la création par contre si jamais vous n'aviez pas là contrainte lorsque vous avez créé votre table, que vous devez le faire après, Eh bien vous faites une ALTER TABLE donc on fait ça que si vous ne l'avez pas fait à la création. 

	ALTER TABLE `table_users`
	ALTER `user_admin`

Ça ne sert à rien de faire par exemple ça en mettant DEFAULT et ensuite de dire je modifie la table pour ajouter le DEFAULT parce qu'il y est déjà. 

Vous aurez donc fait une requête pour rien ce qui serait un petit peu dommage. 

Ensuite on va mettre un SET DEFAULT 0.

	ALTER TABLE `table_users`
	ALTER `user_admin` SET DEFAULT 0;

Voilà ça veut dire que tu altère la colonne user_admin et tu lui mets, tu lui attribue par défaut la valeur 0. 

Et si jamais je voulais supprimer la contrainte parce qu'on peut le faire aussi, il suffit de faire ALTER TABLE suivi du nom de la table comme on a mis ici et ensuite il suffirait de faire ALTER le nom de la colonne user_admin et là vous faites DROP DEFAULT; voilà. 

	ALTER TABLE `table_users`
	ALTER `user_admin` DROP DEFAULT;
	
On peut faire pareil pour le DROP NOT NULL, on pourrait le retirer aussi si on voulait en faisant ça. 

Voilà ça c'est pour retirer par exemple s'il y a déjà une contrainte, DROP pour la retirer. 

Et ça SET c'est pour ajouter la contrainte si elle n'est pas déjà présente. 

Alors je vous montre beaucoup de choses mais de toute façon avec la pratique, les exercices et tout ça, vous aurez l'occasion de mettre tout ça en pratique et de vous exercer. 

Ne vous en faites pas si vous voyez qu'il y a beaucoup de commandes, beaucoup de choses comme ça qui se mélange, c'est parfaitement normal et ça va être un petit peu le problème au départ quand vous allez étudier SQL parce que vous allez avoir plein de commandes différentes, des mots clés, des ALTER TABLE, de DROP, tout ça et on s'y perd un petit peu au début. 

Si vous faites les choses de manière logique, vous verrez que ça a parfaitement du sens et c'est très simple à mettre en place. 

Alors là vous voyez que le DEFAULT j'en ai pas avec user_admin, on voit ici qu'il n'y a rien par défaut.

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+-------+
	| Field             | Type         | Null | Key | Default | Extra |
	+-------------------+--------------+------+-----+---------+-------+
	| id_user           | smallint     | NO   |     | NULL    |       |
	| user_name         | varchar(30)  | NO   |     | NULL    |       |
	| user_email        | varchar(100) | NO   |     | NULL    |       |
	| user_registration | date         | NO   |     | NULL    |       |
>	| user_admin        | tinyint(1)   | YES  |     | NULL    |       |
	+-------------------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)

On voit que par défaut tout est égal à NULL C'est à dire que si c'était pas en mode NULL ça mettrait NULL par défaut. 

Moi je fais donc ça.

	mysql> ALTER TABLE `table_users`
		-> ALTER `user_admin` SET DEFAULT 0;
	Query OK, 0 rows affected (0.01 sec)
	Records: 0  Duplicates: 0  Warnings: 0

Et là je refais un petit DESCRIBE.

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+-------+
	| Field             | Type         | Null | Key | Default | Extra |
	+-------------------+--------------+------+-----+---------+-------+
	| id_user           | smallint     | NO   |     | NULL    |       |
	| user_name         | varchar(30)  | NO   |     | NULL    |       |
	| user_email        | varchar(100) | NO   |     | NULL    |       |
	| user_registration | date         | NO   |     | NULL    |       |
	| user_admin        | tinyint(1)   | YES  |     | 0       |       |
	+-------------------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)

Et vous voyez qu'il me met bien que maintenant user_admin par défaut prendra la valeur 0 donc tout simple à mettre en place. 

Voilà pour cette 2e contrainte en ce qui concerne le default. 

On en a une autre aussi, très pratique qui va permettre de vérifier, de CHECK, checker une valeur. C'est la contrainte CHECK qui porte bien son nom qui va permettre de faire un petit test, de dire voilà vérifier une valeur.

	contraintes.sql
	---------------
	
	/
		NOT NULL 	(colonne obligatoire)
		DEFAULT 	(valeur par défaut)
		CHECK 		(vérification d'une valeur)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0
	);

Alors sur quoi ça peut être utile ? Là je n'ai pas forcément fait de colonne qui serait logique, alors sur quoi je peux le faire ? Voilà on va le mettre sur id_user même si ce n'est pas forcément logique et que ça n'a pas beaucoup de sens parce qu'il faut bien que je le mette quelque part pour que vous voyez dans la vidéo donc on va le mettre sur le id_user. 

On va partir du principe qu'on ne veut pas que le id_user soit supérieur au nombre un million, je vous dis vraiment un exemple au hasard qui n'a pas forcément de sens mais c'est pour que vous compreniez comment fonctionne la contrainte donc il suffit d'utiliser le mot CHECK suivi d'un petit test à faire d'accord donc le test ça va être simplement entre parenthèses quelque chose dont le champ que vous voulez.

Par exemple, id_user je veux qu'il soit par exemple plus petit ou égal à 10000. 

	contraintes.sql
	---------------
	
	/
		NOT NULL 	(colonne obligatoire)
		DEFAULT 	(valeur par défaut)
		CHECK 		(vérification d'une valeur)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL CHECK(id_user <= 10000),
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0
	);

Voilà au lieu de mettre un million, on va mettre 10000. 

Ça veut dire que ça va vérifier à chaque fois qu'on voudra enregistrer un utilisateur qu'il n'y a pas un id_user qui est supérieur strictement à 10000. 

Sinon pareil on aura une erreur SQL pour nous dire qu'il y a une contrainte ici qui n'est pas respecté c'est-à-dire la contrainte CHECK. 

Ça peut être utile par exemple quand on veut avoir une fourchette de valeur ou un maximum et un minimum par exemple si vous avez des prix pour un objet dans votre base de données. 

On est d'accord qu'un produit ne peut pas avoir un prix négatif donc on pourrait par exemple vérifier que le prix est strictement supérieur à 0 par exemple.

	... CHECK(prix > 0),

Par exemple pour le prix d'un produit ça pourrait être assez intéressant et très utile comme contrainte. 

Là j'avoue que pour mon exemple, ce n'est pas forcément très utile mais c'est pour que vous compreniez donc ça c'est dans le cas de la création dans le cas où je veux vraiment créer le champ. 

Et si je veux le faire après, vous voyez qu'on fait toujours pareil c'est à dire un ALTER TABLE et cetera, et là il ne faut pas que je me trompe parce que là il faut que j'essaie de vous apprendre les commandes de SQL c'est-à-dire celles qui fonctionneront partout. 

	ALTER TABLE `table_users`

Ainsi il faut savoir que pour les contraintes de table, il y a des contraintes qui sont propres à MySQL, d'autres qui sont propres à SQL Server et d'autres à Oracle donc celle-là j'évite de vous les montrer parce que si vous les faites sur Oracle, le jour où vous allez passer à MySQL ça ne fonctionnera pas. 

Ainsi moi je vous montre les commandes qui vont fonctionner partout d'accord donc si un jour vous voyez dans des tutos, dans des documentations ou je ne sais quoi que les commandes ne soient pas les mêmes que celles que vous avez appris ici, c'est parfaitement normal. 

Moi je privilégie les commandes générales en SQL dans la mesure où vous pouvez basculer d'une base de données à l'autre, ce qui fonctionnera partout. 

C'est quand même beaucoup plus agréable et vous allez gagner du temps au niveau des bases de données. 

Après libre à vous d'apprendre les syntaxes propres au type de base de données sur lequel vous travaillez mais moi ce n'est pas ce que je vous montrerais. 

Du coup vous allez faire ça je crois que c'est juste un ADD. 

Normalement c'est un ADD, on fait un ADD CHECK.

	ALTER TABLE `table_users`
	ADD CHECK(id_user <= 10000);

Vous voyez des fois c'est MODIFY, des fois c'est ALTER enfin faut faire gaffe.

De toute façon si je me suis trompé, je le verrais dans MySQL et on corrigera à ce moment-là en direct dans la vidéo.

Alors c'est le ADD CHECK, le champ qui est ici et donc on va faire ça et là je précise comme je n'ai pas de CHECK et rien du tout, je fais un ALTER TABLE.

	mysql> ALTER TABLE `table_users`
		-> ADD CHECK(id_user <= 10000);
	Query OK, 0 rows affected (0.12 sec)
	Records: 0  Duplicates: 0  Warnings: 0

Et là du coup ça a marché donc apparemment je n'ai pas fait d'erreur, tant mieux on va vite le voir.

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+-------+
	| Field             | Type         | Null | Key | Default | Extra |
	+-------------------+--------------+------+-----+---------+-------+
	| id_user           | smallint     | NO   |     | NULL    |       |
	| user_name         | varchar(30)  | NO   |     | NULL    |       |
	| user_email        | varchar(100) | NO   |     | NULL    |       |
	| user_registration | date         | NO   |     | NULL    |       |
	| user_admin        | tinyint(1)   | YES  |     | 0       |       |
	+-------------------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)

Alors oui par contre on ne le verra forcément pas. 

Voilà on ne verra pas forcément toutes les infos donc ça c'est embêtant. 

On ne le verra pas du coup, on le verra plus tard si on avait par exemple une requête pour enregistrer un nouvel utilisateur, on l'aurait vu. 

On aurait pu faire un test exprès pour que ça ne marche pas. 

Alors on pourrait faire la commande SHOW TABLE STATUS mais on va avoir trop d'info et du coup voilà on ne comprend rien.

	mysql> show table status from cours_sql;
	+-------------+--------+---------+------------+------+
	| Name        | Engine | Version | Row_format | Rows |
	+-------------+--------+---------+------------+------+...
	| table_users | InnoDB |      10 | Dynamic    |    0 |
	+-------------+--------+---------+------------+------+

	----------------+-------------+-----------------+--------------+
	 Avg_row_length | Data_length | Max_data_length | Index_length |
	----------------+-------------+-----------------+--------------+...
				  0 |       16384 |               0 |            0 |
	----------------+-------------+-----------------+--------------+

	-----------+----------------+---------------------+-------------+
	 Data_free | Auto_increment | Create_time         | Update_time |
	-----------+----------------+---------------------+-------------+...
			 0 |           NULL | 2020-12-20 19:47:40 | NULL        |
	-----------+----------------+---------------------+-------------+

	------------+--------------------+----------+----------------+---------+
	 Check_time | Collation          | Checksum | Create_options | Comment |
	------------+--------------------+----------+----------------+---------+
	 NULL       | utf8mb4_unicode_ci |     NULL |                |         |
	------------+--------------------+----------+----------------+---------+

	1 row in set (0.01 sec)

Voilà on comprend rien et en plus je n'ai pas ce que je voulais. 

Et si on fait 

	mysql> explain table_users id_user;
	+---------+----------+------+-----+---------+-------+
	| Field   | Type     | Null | Key | Default | Extra |
	+---------+----------+------+-----+---------+-------+
	| id_user | smallint | NO   |     | NULL    |       |
	+---------+----------+------+-----+---------+-------+
	1 row in set (0.00 sec)

Voilà je n'ai rien de plus. 

Ce n'est pas grave mais bon ça a fonctionné donc pas de souci. 

Comprenez simplement que plus tard lorsqu'on fera des requêtes  et c'est vrai que vous aurez l'occasion de vérifier ça quand vous allez vouloir enregistrer un utilisateur si jamais on entrait un id_user qui est plus grand que ça 10000, Eh bien ça ne fonctionnera pas comme je vous l'ai dit il y aura une erreur SQL pour vous dire que vous n'avez pas respecté cette contrainte CHECK parce que vous avez une valeur trop grandes donc c'est bien à savoir. 

Alors ça c'est pour ajouter, ADD CHECK. 

Alors maintenant si vous avez besoin de faire une contrainte par exemple CHECK sur plusieurs champs différents, il faudra créer, il faudra nommer la contrainte c'est-à-dire que vous serez obligé de faire ADD CONSTRAINT donc attention c'est le terme anglais ce n'est pas contrainte en français.

	ALTER TABLE `table_users`
	ADD CONSTRAINT

Là vous donnez un nom à la contrainte, et comme il s'agit d'une contrainte CHECK, en général on prend l'habitude de l'appeler CHK_ avec un underscore suivi du nom de la contrainte qu'on veut. Moi ça va être par exemple CHK_idtoobig et ce serrait par exemple un CHECK() de plusieurs choses, on aurait par exemple un champ 1 genre id_user qui doit être plus petit ou égal à 10000 et on pourrait mettre id_user doit être par exemple absolulement plus grand que 0 et on pourrait par exemple faire ça.

	contraintes.sql
	---------------
	
	/
		NOT NULL 	(colonne obligatoire)
		DEFAULT 	(valeur par défaut)
		CHECK 		(vérification d'une valeur)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL CHECK(id_user <= 10000),
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0
	);
	
	client
	------
	
	ALTER TABLE `table_users`
	ADD CONSTRAINT CHK_idtoobig CHECK(id_user <= 10000 AND id_user > 0)

Et on pourrait faire par exemple ça. 

Si vous avez besoin de faire comme ça des vérifications sur plusieurs choses, même sur d'autres champs c'est-à-dire que ici je l'ai fait que sur id_user mais si j'avais par exemple besoin de le faire sur user_admin voilà.

	ALTER TABLE `table_users`
	ADD CONSTRAINT CHK_idtoobig CHECK(id_user <= 10000 AND user_admin > 1)

Par exemple user_admin, ce genre de chose avec user_admin qui ne peut pas être plus grand que 1 même si ce serait un peu bizarre de faire ce genre de contrainte. 

Voilà on aura créé une contrainte qui aura un nom CHK_idtoobig et sur plusieurs champs, id_user et user_admin. Et éventuellement sur plusieurs colonnes donc ça c'est une possibilité.

Si on veut supprimer cette contrainte, que si à un moment donné elle est faite et puis qu'on n'en veut plus.

Il suffira de faire juste simplement DROP CHECK suivi de la fameuse contrainte que vous avez créé CHK_idtoobig;

	ALTER TABLE `table_users`
	DROP CHECK CHK_idtoobig;
	
Voilà ce genre de choses donc c'est des possibilités qui peuvent être faites. 

Très pratique DROP CHECK et cetera. 

Voilà normalement tout est dit là-dessus, on a noté CHECK donc c'est bon. 

Un site très simple à utiliser ces petites vérifications comme CHECK que vous utiliserez quand même moins que NOT NULL et DEFAULT je pense mais c'est bien de le savoir parce que ça peut être utile mais moi je vais les enlever parce que dans mon cas ce n'est pas forcément utile. 

Et donc ici on va repartir déjà sur une table par défaut, on va faire ceci. 

	mysql> drop table table_users;
	Query OK, 0 rows affected (0.03 sec)

	mysql> show tables;
	Empty set (0.00 sec)

 Voilà ensuite je fais un show tables; et on n'en a évidemment pas. 

Ensuite on va reprendre cette table pour repartir sur une stable propre, pour être sûr d'avoir vraiment celle là voilà.

	contraintes.sql
	---------------
	
	/
		NOT NULL 	(colonne obligatoire)
		DEFAULT 	(valeur par défaut)
		CHECK 		(vérification d'une valeur)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0
	);
	
	client
	------
	mysql> CREATE TABLE IF NOT EXISTS `table_users`
		-> (
		-> `id_user` SMALLINT NOT NULL,
		-> `user_name` VARCHAR(30) NOT NULL,
		-> `user_email` VARCHAR(100) NOT NULL,
		-> `user_registration` DATE NOT NULL,
		-> `user_admin` BOOLEAN DEFAULT 0
		-> );
	Query OK, 0 rows affected (0.05 sec)

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+-------+
	| Field             | Type         | Null | Key | Default | Extra |
	+-------------------+--------------+------+-----+---------+-------+
	| id_user           | smallint     | NO   |     | NULL    |       |
	| user_name         | varchar(30)  | NO   |     | NULL    |       |
	| user_email        | varchar(100) | NO   |     | NULL    |       |
	| user_registration | date         | NO   |     | NULL    |       |
	| user_admin        | tinyint(1)   | YES  |     | 0       |       |
	+-------------------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)

Vous voyez que si dès le début je les met dans la création de table, regardez tout y est dès le début et donc je n'ai pas besoin de faire de ALTER TABLE parce que j'ai déjà tout renseigné à la création. 

Il est évidemment mieux d'avoir dès le départ d'avoir toutes les bonnes contraintes. 

C'est pour ça que je vous ai dit et que la vidéo est un peu longue parce qu'il faut bien comprendre que vous devez réfléchir d'avance comment seront les contraintes de vos tables et si un jour vous avez fait un oubli ou que quelque chose vient à changer, vous pourrez l'ajouter avec un ALTER TABLE mais c'est quand même lieu au départ d'avoir bien réfléchi à la chose pour avoir quelque chose de cohérent au départ avant de commencer à avoir plein de données et qu'il faut faire plein de modifications et plein de requêtes pour changer ce qui ne serait pas forcément valide suivant de nouvelles contraintes. 

Réfléchissez donc bien à ça c'est super important. 

Voilà pour ces contraintes-là. 

On a vu entre guillemets les plus simples à mettre en place, les plus évidentes. 

On va arriver maintenant sur les contraintes d'unicité, les clés primaires, les clés étrangères et cetera ainsi que les clés d'index. 

Je vais vous expliquer tout ça parce qu'il y en a encore pas mal et on n'en a pas vu beaucoup mais il en reste encore quelques-unes.

La première à connaître c'est la contrainte UNIQUE d'accord ça peut être par exemple la valeur de champ unique. 

	contraintes.sql
	---------------
	
	/
		NOT NULL 	(colonne obligatoire)
		DEFAULT 	(valeur par défaut)
		CHECK 		(vérification d'une valeur)
		UNIQUE		(valeur de champ unique)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0
	);

Voilà je pense que c'est clair pour la valeur d'un champ qui est unique. 

On pourrait partir du principe c'est un peu logique sur un site que le pseudo, le nom d'utilisateur soit unique. 

Il ne faut pas que 2 utilisateurs aient le même pseudo sinon ils vont se connecter sur le même compte ce qui provoquerait de sérieux problèmes au niveau authentification, au niveau vie privée, respect de données et cetera. 

Pour cela on peut donc dire que le username deviendra une information unique, de dire simplement que c'est une info à réserver pour l'unicité du nom d'utilisateur. 

Et si un jour quelqu'un veut créer un nouvel utilisateur qui porte déjà un pseudo qui existe dans notre table, il y aura une erreur qui sera générée pour dire que le pseudo est déjà utilisé donc on pourra pas la voir à ce moment-là. 

Ça ce sont des choses à voir alors comment est-ce qu'on va utiliser le UNIQUE ? Quand vous avez tout ses champs, vous pouvez tout simplement faire avant la fin de la création un UNIQUE() et entre parenthèses voulu passer la valeur qui sera unique par exemple le id_user.

	contraintes.sql
	---------------
	
	/
		NOT NULL 	(colonne obligatoire)
		DEFAULT 	(valeur par défaut)
		CHECK 		(vérification d'une valeur)
		UNIQUE		(valeur de champ unique)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		UNIQUE(`user_name`)
	);

On lui dit qu'on applique une contrainte d'unicité sur id_user et on peut l'appliquer sur autre chose, on peut le mettre par exemple sur user_name et pour le coup on va juste la mettre sur user_name pour le coup parce qu'on fera autre chose avec id_user donc on pourra pas tout mélanger et comme ça je vous l'expliquerait. 

Ça c'est donc important de l'avoir. 

On peut également utiliser une contrainte nommée mais je ne suis pas sûr que ce soit forcément utile de vous le montrer, ce n'est pas forcément nécessaire mais ça c'est la méthode qui on va dire fonctionne bien à tous les coups il n'y a pas de problème. 

Si vous avez besoin de l'ajouter donc par la suite, on reprend toujours la même chose ALTER TABLE suivi du nom de la table. 

	ALTER TABLE `table_users`

J'essaie de ne pas aller trop vite dans les explications  parce que je sais qu'il y a beaucoup de choses à faire et je ne veux pas non plus faire une vidéo trop longue mais j'essaye de jauger avec une vidéo pas trop trop longue mais il faut pas non plus que je vous bacle en vous balançant toutes les choses comme ça. J'ai l'habitude de bien prendre le temps de tout vous expliquer parce que l'intérêt c'est que vous ayez compris par la suite. 

Et on fait un ADD UNIQUE() qui prend le champ entre les anti quotes.

	contraintes.sql
	---------------
	
	/
		NOT NULL 	(colonne obligatoire)
		DEFAULT 	(valeur par défaut)
		CHECK 		(vérification d'une valeur)
		UNIQUE		(valeur de champ unique)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		UNIQUE(`user_name`)
	);

	ALTER TABLE `table_users`
	ADD UNIQUE(`user_name`);

	client
	------
	
	mysql> ALTER TABLE `table_users`
		-> ADD UNIQUE(`user_name`);
	Query OK, 0 rows affected (0.10 sec)
	Records: 0  Duplicates: 0  Warnings: 0
	
On fait ça et on voit que c'est passé.

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+-------+
	| Field             | Type         | Null | Key | Default | Extra |
	+-------------------+--------------+------+-----+---------+-------+
	| id_user           | smallint     | NO   |     | NULL    |       |
	| user_name         | varchar(30)  | NO   | PRI | NULL    |       |
	| user_email        | varchar(100) | NO   |     | NULL    |       |
	| user_registration | date         | NO   |     | NULL    |       |
	| user_admin        | tinyint(1)   | YES  |     | 0       |       |
	+-------------------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)

Et là vous voyez il nous met que à user_name, il y a un PRI et vous allez comprendre pourquoi. 

Il a fait en fait une règle d'unicité donc PRI c'est pour Primary Key pour clé primaire mais on va en parler un petit peu après. 

Il a donc bien créé une règle d'unicité là-dessus c'est-à-dire qu'on ne pourra plus avoir d'utilisateur qui porte le même user_name et donc ce sera impossible grâce à cette contrainte-là d'unicité qui est très très importante et vous allez comprendre pourquoi. 

Alors si on veut la nommer, si on veut définir une contrainte d'unicité sur plusieurs champs par exemple id_user et user_name. On peut le faire aussi c'est tout à fait possible un peu comme tout à l'heure avec le CHECK.

On va faire ADD CONSTRAINT et pas se tromper, ensuite on lui met un nom et moi j'ai envie de lui mettre UC_ qui est mit habituellement par les gens pour les contraintes d'unicité mais voilà vous mettez ce que vous voulez ce n'est pas obligatoire. C'est juste que par convention les gens ont pris l'habitude d'écrire des contraintes comme ça. 

Personnellement moi je n'utilise pas les normes à ce niveau-là, j'écris toujours un petit peu les contraintes comme ça m'arrange pour que ce soit clair de mon côté. 

Et du coup ici on va mettre UC_userid bien que ce soit un peu bizarre comme nom. 

	ALTER TABLE `table_users`
	ADD CONSTRAINT UC_userid ...

Ensuite l'unicité se fera sur id_user et user_name.

	contraintes.sql
	---------------
	
	/
		NOT NULL 	(colonne obligatoire)
		DEFAULT 	(valeur par défaut)
		CHECK 		(vérification d'une valeur)
		UNIQUE		(valeur de champ unique)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		UNIQUE(`user_name`)
	);

	ALTER TABLE `table_users`
	ADD CONSTRAINT UC_userid UNIQUE(`id_user`, `user_name`);

Vous voyez que là on ne fait plus l'unicité seulement sur une seule colonne mais sur plusieurs en l'occurrence ici 2. 

Je vais le faire.

	mysql> ALTER TABLE `table_users`
		-> ADD CONSTRAINT UC_userid UNIQUE(`id_user`, `user_name`);
	Query OK, 0 rows affected (0.03 sec)
	Records: 0  Duplicates: 0  Warnings: 0

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+-------+
	| Field             | Type         | Null | Key | Default | Extra |
	+-------------------+--------------+------+-----+---------+-------+
	| id_user           | smallint     | NO   | MUL | NULL    |       |
	| user_name         | varchar(30)  | NO   | PRI | NULL    |       |
	| user_email        | varchar(100) | NO   |     | NULL    |       |
	| user_registration | date         | NO   |     | NULL    |       |
	| user_admin        | tinyint(1)   | YES  |     | 0       |       |
	+-------------------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)
	
Et là regardez nous avons tout ce qui a été fait voilà donc on a toujours la Primary Key pour user_name et on a également une contrainte spéciale pour id_user. 

Ça c'est plutôt à connaître à ce niveau-là comme ça on a un nom qui a été donné sur lequel on pourra travailler, UC_userid. 

On peut bien sûr l'enlever et ça paraît logique. 

Je vais faire un ALTER TABLE et ensuite un DROP mais là ça va être INDEX UC_userid.

	contraintes.sql
	---------------
	
	/
		NOT NULL 	(colonne obligatoire)
		DEFAULT 	(valeur par défaut)
		CHECK 		(vérification d'une valeur)
		UNIQUE		(valeur de champ unique)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		UNIQUE(`user_name`)
	);

	ALTER TABLE `table_users`
	DROP INDEX UC_userid;

	client
	------
	
	mysql> ALTER TABLE `table_users`
		-> DROP INDEX UC_userid;
	Query OK, 0 rows affected (0.02 sec)
	Records: 0  Duplicates: 0  Warnings: 0

Voilà il ne faut pas se gourer dans les noms si on veut pouvoir la retirer. 

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+-------+
	| Field             | Type         | Null | Key | Default | Extra |
	+-------------------+--------------+------+-----+---------+-------+
	| id_user           | smallint     | NO   |     | NULL    |       |
	| user_name         | varchar(30)  | NO   | PRI | NULL    |       |
	| user_email        | varchar(100) | NO   |     | NULL    |       |
	| user_registration | date         | NO   |     | NULL    |       |
	| user_admin        | tinyint(1)   | YES  |     | 0       |       |
	+-------------------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)

Vous voyez qu'on a retiré mais qu'on a gardé PRI parce qu'on avait déjà mis une contrainte ici d'unicité. 

Vous voyez que ça ne se mélange pas, c'était 2 choses différentes. 

Si on définit une contrainte nommée, ça va être autre chose qu'une contrainte sur un seul champ. 

Voilà pour cette partie là au niveau de UNIQUE et normalement je vous ai dit tout ce qu'il y avait à faire. 

Au niveau d'autres types également de contraintes, on a la fameuse contrainte PRIMARY KEY alors la contrainte de clé primaire et ça c'est particulier parce que c'est en général utilisé pas mal sur les identifiants par exemple lorsque vous avez un id de votre table, on va utiliser la clé primaire là-dessus. 

C'est pour dire qu'on aura un identifiant unique, c'est important vraiment parce que c'est l'information importante de notre table et on définira en général une clé primaire. 

Alors pour le faire, on va procéder de la même manière que ce que nous avons fait ici avec UNIQUE c'est à dire qu'on va avoir PRIMARY KEY avec un espace entre les 2 mots, ce n'est pas un underscore il faut faire gaffe.

Et là je vais le définir sur id_user.

	contraintes.sql
	---------------
	
	/
		NOT NULL 	(colonne obligatoire)
		DEFAULT 	(valeur par défaut)
		CHECK 		(vérification d'une valeur)
		UNIQUE		(valeur de champ unique)
		PRIMARY KEY	(clé primaire)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);

Voilà pour ça et du coup on va reprendre ce code, et comment on fait 15000 contraintes en même temps et pour éviter que ça se mélange on va faire d'abord un drop. Et donc éviter de faire des bétises.

	mysql> drop table table_users;
	Query OK, 0 rows affected (0.03 sec)

Je vais même faire un exit pour revenir à quelque chose de propre.

	mysql> exit
	Bye

	> mysql -u root -p
	Enter password:
	Welcome to the MySQL monitor.  Commands end with ; or \g.
	Your MySQL connection id is 11
	Server version: 8.0.22 MySQL Community Server - GPL

	Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

	Oracle is a registered trademark of Oracle Corporation and/or its
	affiliates. Other names may be trademarks of their respective
	owners.

	Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

	mysql>

	mysql> use cours_sql;
	Database changed

	mysql> CREATE TABLE IF NOT EXISTS `table_users`
		-> (
		-> `id_user` SMALLINT(6) NOT NULL,
		-> `user_name` VARCHAR(30) NOT NULL,
		-> `user_email` VARCHAR(100) NOT NULL,
		-> `user_registration` DATE NOT NULL,
		-> `user_admin` BOOLEAN DEFAULT 0,
		->
		-> PRIMARY KEY(`id_user`)
		-> );
	Query OK, 0 rows affected, 1 warning (0.05 sec)

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+-------+
	| Field             | Type         | Null | Key | Default | Extra |
	+-------------------+--------------+------+-----+---------+-------+
	| id_user           | smallint     | NO   | PRI | NULL    |       |
	| user_name         | varchar(30)  | NO   |     | NULL    |       |
	| user_email        | varchar(100) | NO   |     | NULL    |       |
	| user_registration | date         | NO   |     | NULL    |       |
	| user_admin        | tinyint(1)   | YES  |     | 0       |       |
	+-------------------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)

Et vous voyez que cette fois-ci nous avons notre clé primaire sur id_user. 

Alors à quoi ça va servir ? 

En général quand on fait des petits identifiant comme ça sur une base de données, c'est un identifiant qui va s'auto-incrémenter c'est à dire que ce n'est pas vous qui va le renseigner manuellement mais c'est le système qui par exemple quand vous allez ajouter un utilisateur c'est-à-dire que quand vous allez ajouter toutes ces informations là (tous les champs) que ce soit par programmation ou via un formulaire HTML ou ce genre de chose, c'est en fait SQL qui va automatiquement indiquer à id_user un identifiant. 

Il partira par exemple de 1 au début jusqu à évidemment ce que peut accepter un SMALLINT(6) par rapport à la fourchette de valeurs possibles, et il enregistrera ça comme un NOT NULL parce que ce sera évidemment renseigné à chaque fois. 

Et on pourra même appliquer si on veut une auto incrémentation. 

Alors l'auto incrémentation c'est une autre contrainte mais si je ne dis pas de bêtises je pense qu'il y a un underscore et on va l'ajouter sur le id_user voilà.

	contraintes.sql
	---------------
	
	/
		NOT NULL 	(colonne obligatoire)
		DEFAULT 	(valeur par défaut)
		CHECK 		(vérification d'une valeur)
		UNIQUE		(valeur de champ unique)
		PRIMARY KEY	(clé primaire)
		AUTO_INCREMENT
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);

Alors qu'est-ce que ça veut dire ?

Lorsque vous allez enregistrer votre première utilisateur, SQL va mettre la valeur 1 pour le premier, et 2, et 3, et 4 jusqu à encore une fois la limite par rapport à la taille de la donnée que vous avez définie.

Vous n'aurez pas besoin de le renseigner vous-même parce que ce sera auto-incrémenté. 

Pareil si un jour vous avez besoin de changer l'endroit où ça s'incrémente, vous aurez juste à faire un ALTER TABLE de la table, et là il suffira de faire un AUTO_INCREMENT de 100 si vous voulez par exemple que l'incrémentation commence à 100.

	contraintes.sql
	---------------
	
	/
		NOT NULL 	(colonne obligatoire)
		DEFAULT 	(valeur par défaut)
		CHECK 		(vérification d'une valeur)
		UNIQUE		(valeur de champ unique)
		PRIMARY KEY	(clé primaire)
		AUTO_INCREMENT
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);
	
	ALTER TABLE `table_users` AUTO_INCREMENT = 100;

Voilà votre premier utilisateur commencera à l'id 100, 101, 102 et cetera. 

Ça ira de 1 en 1. 

Ça on peut donc le faire, on n'est pas obligé de commencer à 1 obligatoirement, on peut commencer à 100, à 1000 comme on veut. 

Imaginez quelqu'un qui aurait par exemple une liste de factures, souvent les factures on les commence à 1000, à 10000 et cetera. 

On ne commence pas forcément à la facture numéro une, facture numéro 2 donc ça peut être quelque chose à savoir ici. 

Alors quand on fait souvent sur un identifiant, on définit une clé primaire sur ce dernier et une auto incrémentation c'est-à-dire que cet identifiant va nous servir bien que on s'en fiche parce que ce n'est pas un identifiant que nous avons créé nous-mêmes. Il est généré et il va nous servir plus tard vous allez voir pour des requêtes de sélection qui se rend du coup très rapide parce qu'elles se serviront de cet identifiant éventuellement d'un index pour faire des parcours et ce sera beaucoup plus rapide et beaucoup plus performant en termes de ressources, en termes de tout ça. 

Il faut donc penser à le faire et c'est ce qu'on fait habituellement sur une base de données quand on a une id de quelque chose qui est auto-généré, on le met en NOT NULL, on le met en PRIMARY KEY.

Alors PRIMARY KEY c'est comme un UNIQUE mais en plus fort mais avec une auto incrémentation donc ça c'est ce qu'on fait à tous les coups. 

Après si vous voulez vous créer un identifiant spécial par exemple vous prenez les 3 premières lettres du prénom de la personne suivi d'autres choses Eh bien à ce moment-là ce sera à vous de créer un identifiant spécifique en le mettant en UNIQUE ce genre de chose et éventuellement avec un CHECK et c'est vous qui l'aurez créé vous-même. 

 Là c'est un identifiant qui est généré automatiquement par SQL.

		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,

On n'aura même pas besoin de s'en occuper, c'est pour entre guillemets au niveau de notre représentation, au niveau de notre schéma, de notre base de données. 

C'est comme s'il n'existait pas, c'est géré par le système et c'est à la machine de s'en occuper.

Nous ce qui nous intéresse pour l'utilisateur c'est ça.

		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,

On s'en fiche de savoir qu'un tel utilisateur a un id_user de 37 par exemple on s'en fiche complètement. 

Ça c'est important au niveau de l'auto-incrémentation.

Alors je vais mettre on note : auto incrémentation de 1 en 1. 

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);

Voilà c'est juste ça je ne sais pas ce que je peux indiquer de plus. 

Voilà vous avez toutes les infos ici. 

Tout est dit sur cette partie là. 

Si jamais vous voulez l'indiquer par la suite, vous faites ça. 

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);
	
	ALTER TABLE `table_users`
	ADD PRIMARY KEY(`user_name`);

Alors est-ce que je l'avais dans ma base ? oui je l'avais, PRI su id_user. 

Par exemple admettons que j'ajouterai une clé primaire à user_name même si je juge que ce ne serait pas utile mais de toute façon ce n'est pas grave après on pourra supprimer la table, Eh bien vous faites ça. 

	mysql> ALTER TABLE `table_users`
		-> ADD PRIMARY KEY(`user_name`);
	ERROR 1068 (42000): Multiple primary key defined

 Et voilà on ne peut pas définir plusieurs clés primaires mais ce n'est pas grave. 

J'aurais dû faire ma clé primaire sur id_user mais elle y est déjà parce qu'évidemment une clé primaire sur une table vous n'en avez qu'une seule. 

Ce n'est pas comme unicité, vous pouvez mettre plusieurs contraintes d'unicité parce que c'est définir qu'un champ est unique et qu'il ne peut pas avoir des valeurs similaires. 

Par contre une clé primaire comme ça sert justement pour quelque chose d'automatique, vous n'en aurez qu'une seule.

C'est pour ça que ce sont 2 choses différentes. 

Si ce n'était pas différent on n'aurait pas 2 cas ici, on aurait un seul type de contrainte et non pas 2. 

C'est pour ça qu'on parle de primaire, il n'y a qu'une seule clé primaire alors que des règles d'unicité on peut en avoir plusieurs donc faites attention à ça. 

Alors oui j'avais pas vu que id_user avait déjà une clé primaire donc faites attention à ça. 

Alors si on veut définir une clé primaire nommée comme on l'a déjà vu tout à l'heure c'est-à-dire sur plusieurs champs admettons que je vais faire une clé primaire basé sur les 3 premières lettres de uder_name et sur les 3 premières lettres de user_name même si c'est complètement ridicule mais ça pourrait se faire. 

Eh bien on ne fera pas ADD PRIMARY KEY mais on fera un ADD CONSTRAINT et ensuite vous mettez PK_ident ou autre chose ça c'est vous qui voyez et enfin PRIMARY KEY() que vous définissez sur les champs que vous voulez.

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);
	
	ALTER TABLE `table_users`
	ADD CONSTRAINT PK_ident PRIMARY KEY(`id_user`, `user_name`);

Voilà on peut faire tout à fait ça sur id_user et sur le nom d'utilisateur user_name. 

Alors est-ce qu'il va accepter la modification ?

	mysql> ALTER TABLE `table_users`
		-> ADD CONSTRAINT PK_ident PRIMARY KEY(`id_user`, `user_name`);
	ERROR 1068 (42000): Multiple primary key defined

Évidemment que non puisqu'il y en a déjà une qui a été défini par là évidemment. 

Alors DROP PRIMARY KEY pour la retirer.

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);
	
	ALTER TABLE `table_users`
	DROP PRIMARY KEY;

	client
	------

	mysql> ALTER TABLE `table_users`
		-> DROP PRIMARY KEY;
	Query OK, 0 rows affected (0.22 sec)
	Records: 0  Duplicates: 0  Warnings: 0

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+-------+
	| Field             | Type         | Null | Key | Default | Extra |
	+-------------------+--------------+------+-----+---------+-------+
	| id_user           | smallint     | NO   |     | NULL    |       |
	| user_name         | varchar(30)  | NO   |     | NULL    |       |
	| user_email        | varchar(100) | NO   |     | NULL    |       |
	| user_registration | date         | NO   |     | NULL    |       |
	| user_admin        | tinyint(1)   | YES  |     | 0       |       |
	+-------------------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)

Alors pourquoi y a t-il pas besoin de spécifier ? vous n'avez qu'à mettre juste DROP PRIMARY KEY et il va automatiquement la retirer puisque il sait où là chercher vu qu'il n'y en a qu'une seule et que vous ne pouvez pas en mettre plusieurs. 

Et du coup vous voyez qu'il n'y en a plus. 

Et après on peut éventuellement faire ce que j'ai fait même si c'est très moche parce que ça ne sert à rien de faire une clé primaire de cette manière mais bon c'est pour l'exemple.

	mysql> ALTER TABLE `table_users`
		-> ADD CONSTRAINT PK_ident PRIMARY KEY(`id_user`, `user_name`);
	Query OK, 0 rows affected (0.08 sec)
	Records: 0  Duplicates: 0  Warnings: 0

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+-------+
	| Field             | Type         | Null | Key | Default | Extra |
	+-------------------+--------------+------+-----+---------+-------+
	| id_user           | smallint     | NO   | PRI | NULL    |       |
	| user_name         | varchar(30)  | NO   | PRI | NULL    |       |
	| user_email        | varchar(100) | NO   |     | NULL    |       |
	| user_registration | date         | NO   |     | NULL    |       |
	| user_admin        | tinyint(1)   | YES  |     | 0       |       |
	+-------------------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)

Voilà comment ça se passe, vous avez une clé primaire mais il ne faut pas croire qu'il n'y en a 2 en fait c'est juste que vous avez une clé primaire qui est fondée, qui est créé sur 2 colonnes de votre base de données. 

C'est vrai que là le tableau ne le montre pas forcément très bien parce qu'en console ce n'est pas sous forme graphique mais si par exemple vous affichez cette forme graphique, vous le verrez certainement mieux donc là ça pourrait induire en erreur. 

Et attention il s'agit bien d'une seule clé primaire basée sur id_user et user_name à la fois mais le tableau vous le met sur les 2. 

Voilà pour ça. 

Et du coup on va le enlever parce que c'est vraiment pas beau, DROP PRIMARY KEY, ce n'est pas joli tout ça, on va donc enlever cette clé primaire. 

	mysql> ALTER TABLE `table_users`
		-> DROP PRIMARY KEY;
	Query OK, 0 rows affected (0.10 sec)
	Records: 0  Duplicates: 0  Warnings: 0
	
Du coup on va juste garder ça et on va réenregistrer la table proprement.
 
	mysql> drop table table_users;
	Query OK, 0 rows affected (0.03 sec)

	mysql> CREATE TABLE IF NOT EXISTS `table_users`
		-> (
		-> `id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		-> `user_name` VARCHAR(30) NOT NULL,
		-> `user_email` VARCHAR(100) NOT NULL,
		-> `user_registration` DATE NOT NULL,
		-> `user_admin` BOOLEAN DEFAULT 0,
		->
		-> PRIMARY KEY(`id_user`)
		-> );
	Query OK, 0 rows affected, 1 warning (0.04 sec)

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+----------------+
	| Field             | Type         | Null | Key | Default | Extra          |
	+-------------------+--------------+------+-----+---------+----------------+
	| id_user           | smallint     | NO   | PRI | NULL    | auto_increment |
	| user_name         | varchar(30)  | NO   |     | NULL    |                |
	| user_email        | varchar(100) | NO   |     | NULL    |                |
	| user_registration | date         | NO   |     | NULL    |                |
	| user_admin        | tinyint(1)   | YES  |     | 0       |                |
	+-------------------+--------------+------+-----+---------+----------------+
	5 rows in set (0.00 sec)

Voilà là on a une table qui est propre, le l'auto increment y est aussi évidemment bien renseigné donc c'est important de l'ajouter à chaque fois. 

Voilà pour la clé primaire. 

On a un autre cas évidemment et qui va être très important, il s'agit des clés étrangères qui est le dernier cas abordé et ensuite on verra les index mais ça va aller très vite parce que vous allez très vite comprendre. 

Et là c'est un des cas les plus important parce que c'est ça qui produit les relations entre les différentes tables. 

Rappelez-vous qu'on parle de SGBD relationnel, ce n'est pas pour rien, c'est parce que nous allons gérer tout un tas de relations. 

Et je vais vous montrer ça par un exemple très rapide et très moche montré sur Paint, fait rapidement à la main. 

Vous avez votre table_users admettons.

	+---------------+
	| table_users	|
	+---------------+
	|				|
	|				|
	+---------------+

Ensuite une table de news genre sur un blog, un site, n'importe quoi, on aura une table de news même si le schéma n'est pas beau du tout c'est surtout pour comprendre voilà.

	+---------------+	+---------------+
	| table_news	|	| table_users	|
	+---------------+	+---------------+
	| 				|	|				|
	| 				|	|				|
	+---------------+	+---------------+

Alors vous avez pleins d'informations sur cette table de news, vous aurez par exemple un id_news vous savez le truc automatique. Vous auriez un news_title qui est le type de la news, ensuite un news_date, news_content et vous aurez par exemple un news_author.

	+---------------+	+---------------+
	| table_news	|	| table_users	|
	+---------------+	+---------------+
	| id_news		|	|				|
	| news_title	|	|				|
	| news_date		|	+---------------+
	| news_content	|
	| news_author	|
	+---------------+

Voilà on aurait par exemple aussi un auteur mais vous êtes d'accord pour éviter la redondance, on ne va pas s'amuser dans la table des news à renseigner tout ce qu'on aurait dans la table_users. Imaginez enfaite qu'on aurait toutes les informations qu'on a ici.	

	+---------------+	+---------------+
	| table_news	|	| table_users	|
	+---------------+	+---------------+
	| id_news		|	| id_user		|
	| news_title	|	| user_name		|
	| news_date		|	| user_email	|
	| news_content	|	| user_registration
	| news_author	|	| user_admin	|
	+---------------+	+---------------+

Alors on ne va pas s'amuser à remettre toutes ces infos-là dans la table des news parce que ça ne les concerne pas. 

La table de news n'a pas besoin qu'on indique, le user_name, le user_email, la date d'inscription et l'aspect administrateur sinon on aurait de la recopie, on aurait des doublons, on aurait des triplés enfin bref on aurait de la redondance de données et du coup ça ne serait pas pratique. 

Alors du coup ce qu'on va faire, vous allez voir c'est tout bête et si vous comprenez ce que je vous dis là vous aurez tout compris au niveau SQL sur les relations entre les tables. Voilà il n'y aura rien d'autre à savoir. 

Alors vous allez avoir dans table_news, l'id_news c'est la fameuse Primary Key, c'est l'identifiant le plus fort on va dire. Et id_user c'est l'identifiant le plus fort pour la table_user.

	+---------------+	+---------------+
	| table_news	|	| table_users	|
	+---------------+	+---------------+
>	|>id_news		|	|>id_user		|
	| news_title	|	| user_name		|
	| news_date		|	| user_email	|
	| news_content	|	| user_registration
	| news_author	|	| user_admin	|
	+---------------+	+---------------+

id_user est l'identifiant le plus fort pour l'utilisateur donc c'est quelque chose qui sera unique, c'est que ça va être généré automatiquement. Le premier utilisateur inscrit aura l'id 1, 2, 3 et cetera jusqu à je ne sais pas combien. 

Pour les news c'est pareil, il y aura un id_news de 1, de 3 et cetera. 

Nous ce qu'on veut faire c'est que pour l'auteur plutôt que de dire on met toutes ces informations parce que ce serait évidemment très très lourd, on va simplement dire que news_author est un identifiant donc ce serait simplement l'id relié à celui que l'on veut.

	+---------------+				+---------------+
	| table_news	|				| table_users	|
	+---------------+				+---------------+
	| id_news		|		+-------| id_user		|
	| news_title	|		|		| user_name		|
	| news_date		|		|		| user_email	|
	| news_content	|		|		| user_registration
	| news_author	|-------+		| user_admin	|
	+---------------+				+---------------+

On crée du coup cette relation c'est-à-dire qu'à la place de news_author, on va juste mettre un identifiant admettons qu'on est l'identifiant 36 qui correspondra à un id_user de 36.

	+-------------------+				+-------------------+
	| table_news		|				| table_users		|
	+-------------------+				+-------------------+
	| id_news			|		+-------| id_user = 36		|
	| news_title		|		|		| user_name			|
	| news_date			|		|		| user_email		|
	| news_content		|		|		| user_registration	|
	| news_author = 36	|-------+		| user_admin		|
	+-------------------+				+-------------------+

Et quand on fera des requêtes plus tard pour faire ce qu'on appelle des jointures, on sera capable comme ça de relier plusieurs tables pour dire liste moi par exemple toutes les news faites par l'utilisateur qui a l'id 36, et dans ce cas on partirait même d'ailleurs sur son user_name pour faire ça plus humainement parlant. On partirait plutôt sur le nom d'utilisateur plutôt que son id (id_user). 

Mais au niveau relationnel, SQL, il serait capable juste grâce à l'id_user qu'on aura stockée retrouvez toutes les informations de l'utilisateur en question. 

L'avantage de tout stocker à chaque fois, ça va juste être un chiffre ici qu'on va stocker dans news_author ce qui est quand même beaucoup plus pratique. 

Et vous allez pouvoir faire ça partout. 

Du coup ce qu'on va définir, Eh bien on aura ce qu'on appelle une clé étrangère c'est-à-dire que news_author ce sera une clé étrangère qui fait référence à id_user de la table_users d'accord. 

Ça c'est donc ce qu'il faut comprendre, news_author et une clé étrangère qui fait référence au id_user de table_users.

Si vous avez compris ça, vous aurez tout compris en SQL parce que c'est vraiment pas plus compliqué que ça donc comment définir ce genre de relation un peu particulière, on va pouvoir la faire. 

Alors évidemment si je n'ai pas plusieurs tables, et on va reprendre du coup les mêmes exemples dans mon schéma et on va remettre tous les champs qu'on avait dans le schéma. 

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);
	
	CREATE TABLE IF NOT EXISTS `table_news`
	(
		`id_news` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`news_title` VARCHAR(80) NOT NULL,
		`news_content` TEXT NOT NULL,
		`news_author` SMALLINT(6) NOT NULL,
		
		PRIMARY KEY(`id_news`)
	);

Et on aura notre fameux news_author qui correspond à id_user et du coup on peut leur mettre la même taille SMALLINT(6) pour faire les choses proprement. 

On aura tout simplement cette information là, news_author sera une clé étrangère, NOT NULL ça paraît logique qui sera notre clé étrangère en référence à id_user ici donc on aura une relation qui va se créer entre la table des news et la table des utilisateurs. 

Ce sera du coup très important de la prendre en compte. 

Comment la définir ? Eh bien on pourra tout simplement faire notre clé primaire, notre clé étrangère en fait directement ici donc on va marquer FOREIN KEY pour clé étrangère ok et ensuite la clé étrangère c'est news_author et ça fait référence REFERENCES donc on n'oublie pas le s à la fin à la table des utilisateurs, table_users.

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);
	
	CREATE TABLE IF NOT EXISTS `table_news`
	(
		`id_news` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`news_title` VARCHAR(80) NOT NULL,
		`news_content` TEXT NOT NULL,
		`news_author` SMALLINT(6) NOT NULL,
		
		PRIMARY KEY(`id_news`),
		FOREIGN KEY(`news_author`) REFERENCES `table_users`...
	);

Si vous réfléchissez en fait de manière logique, SQL c'est vraiment très simple. 

Il suffit de vous parler en même temps au moment où vous construisez vos requêtes ou la création de vos tables, et c'est tout organisé de manière logique quand on fait la même chose. 

Après vous ferez peut-être des erreurs de frappe, ça m'arrive aussi régulièrement surtout en SQL, je ne vous le cache pas. C'est quelque chose qui arrivent assez régulièrement mais on se corrige relativement vite parce qu'on ne fait pas du SQL tous les jours ce n'est pas forcément la chose que l'on fait le plus donc on a parfois vite fait d'oublier des mots, des petits détails mais on arrive très vite à se corriger. 

Et donc ça fait référence au id_user voilà.

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);
	
	CREATE TABLE IF NOT EXISTS `table_news`
	(
		`id_news` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`news_title` VARCHAR(80) NOT NULL,
		`news_content` TEXT NOT NULL,
		`news_author` SMALLINT(6) NOT NULL,
		
		PRIMARY KEY(`id_news`),
		FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`)
	);

D'accord on a une clé étrangère FOREIGN KEY news_author qui fait référence à id_user de table_users d'accord donc on va faire ça.

	mysql> CREATE TABLE IF NOT EXISTS `table_news`
		-> (
		-> `id_news` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		-> `news_title` VARCHAR(80) NOT NULL,
		-> `news_content` TEXT NOT NULL,
		-> `news_author` SMALLINT(6) NOT NULL,
		->
		-> PRIMARY KEY(`id_news`),
		-> FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`)
		-> );
	Query OK, 0 rows affected, 2 warnings (0.06 sec)

Okay c'est bon il l'a ajouter.

	mysql> describe table_news;
	+--------------+-------------+------+-----+---------+----------------+
	| Field        | Type        | Null | Key | Default | Extra          |
	+--------------+-------------+------+-----+---------+----------------+
	| id_news      | smallint    | NO   | PRI | NULL    | auto_increment |
	| news_title   | varchar(80) | NO   |     | NULL    |                |
	| news_content | text        | NO   |     | NULL    |                |
	| news_author  | smallint    | NO   | MUL | NULL    |                |
	+--------------+-------------+------+-----+---------+----------------+
	4 rows in set (0.00 sec)

Voilà et vous avez du coup news_author et ça du coup on ne le verra pas, si on avait quelque chose qui nous schématise à les tables, on s'en renterait beaucoup plus compte.

Voyez on a bien quand même nos 2 tables.

	mysql> describe table_news;
	+--------------+-------------+------+-----+---------+----------------+
	| Field        | Type        | Null | Key | Default | Extra          |
	+--------------+-------------+------+-----+---------+----------------+
	| id_news      | smallint    | NO   | PRI | NULL    | auto_increment |
	| news_title   | varchar(80) | NO   |     | NULL    |                |
	| news_content | text        | NO   |     | NULL    |                |
	| news_author  | smallint    | NO   | MUL | NULL    |                |
	+--------------+-------------+------+-----+---------+----------------+
	4 rows in set (0.00 sec)

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+----------------+
	| Field             | Type         | Null | Key | Default | Extra          |
	+-------------------+--------------+------+-----+---------+----------------+
	| id_user           | smallint     | NO   | PRI | NULL    | auto_increment |
	| user_name         | varchar(30)  | NO   |     | NULL    |                |
	| user_email        | varchar(100) | NO   |     | NULL    |                |
	| user_registration | date         | NO   |     | NULL    |                |
	| user_admin        | tinyint(1)   | YES  |     | 0       |                |
	+-------------------+--------------+------+-----+---------+----------------+
	5 rows in set (0.00 sec)

Et là du coup vous voyez qu'il y a quand même cette relation, il y a MUL qui se crée ici pour que news_author soit relié à id_user. 

Ça vous vous en rendrez donc compte quand on commencera à faire de vraies requête et vous voyez que les relations ont bien été faites parce que si elles n'ont pas été faites correctement, les requêtes ne fonctionneront pas donc on s'en rendra très vite compte si on a bien fait les choses ou pas donc il n'y aura pas de problème à ce niveau-là. 

Voilà les NOT NULL ont bien été appliqué parce que j'avais peur qu'ils ne le soient pas.

Voilà pas de problème donc voilà comment ça se passe c'est aussi simple que ça. 

Si on veut ajouter par la suite, c'est un peu pareil, vous faites encore une fois c'est-à-dire que si on a oublié de faire cette ligne là. 

		FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`)

Eh bien on va juste faire ça ALTER TABLE de table_news et ensuite vous faites comme tout à l'heure ADD FOREIGN KEY la news_author et ensuite REFERENCES de id_user de table_users() et elle n'a rien entre parenthèse puis un point-virgule parce que c'est une requête.

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);
	
	CREATE TABLE IF NOT EXISTS `table_news`
	(
		`id_news` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`news_title` VARCHAR(80) NOT NULL,
		`news_content` TEXT NOT NULL,
		`news_author` SMALLINT(6) NOT NULL,
		
		PRIMARY KEY(`id_news`),
		FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`)
	);
	
>	ALTER TABLE `table_news`
>	ADD FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`);

Voilà on altère la table_news, on ajoute une clé étrangère sur news_author qui fait référence dans table_users à id_user. 

Voyez que quand on reprend les choses au fur et à mesure, on est à peu près sûr de ne pas s'être trompé là dessus et ça c'est bon. 

Ci-après vous avez besoin de la nommer, admettons que vous ayez besoin de nommer votre contrainte. Vous faites toujours pareil, vous utilisez la commande ADD CONSTRAINT, vous le mettez un nom FK_ pour Foreign Key et je ne sais pas quoi voilà.

	ALTER TABLE `table_news`
	ADD CONSTRAINT FK_jesaispasquoi FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`);

Et puis tout simplement une FOREIGN KEY de pareil news_author puis REFERENCES et cetera mais éventuellement de plusieurs champs, on peut éventuellement le faire sur plusieurs champs mais nous on le fait sur un seul. 

Ça c'est donc si vous avez besoin de renommer votre clé étrangère. 

Moi honnêtement je ne le fais jamais, c'est très rare que je renomme clé et cetera.

Je préfère faire simplement faire la syntaxe comme je vous ai montré au début par rapport aux usage que j'ai pu en avoir que je trouve largement suffisante mais je suis quand même obligé de vous la montrer parce que peut être qu'un jour, vous voudriez utiliser cette syntaxe là. 

Voilà comment vous pouvez faire. 

Si par contre vous voulez retirer cette petite contrainte, il suffit simplement de faire un DROP FOREIGN KEY suivi du nom de la contrainte en question.

	ALTER TABLE `table_news`
	DROP FOREIGN KEY FK_jesaispasquoi;

D'ailleurs si on voulait faire les choses correctement, les noms des contraintes nommées devraient être mise entre anti quotes pour être sûr qu'il n'y a pas de problème.

	ALTER TABLE `table_news`
	DROP FOREIGN KEY `FK_jesaispasquoi`;

Voilà comme ça vous retirez la clé étrangère si jamais il y en a une qui a été définie. 

C'est bien quand nous avons quelque chose de nommé comme ça on peut facilement le supprime. 

Dans certains cas ça peut être utile de le savoir aussi. 

Voilà pour FOREIGN KEY.

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
		FOREIGN KEY		(clé étrangère)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);
	
	CREATE TABLE IF NOT EXISTS `table_news`
	(
		`id_news` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`news_title` VARCHAR(80) NOT NULL,
		`news_content` TEXT NOT NULL,
		`news_author` SMALLINT(6) NOT NULL,
		
		PRIMARY KEY(`id_news`),
		FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`)
	);

Alors ça je vous dis que ça c'est souvent ce qui pose problème aux gens qui apprennent SQL mais si vous avez compris ce que ça permet de faire une relation comme ça en ayant par exemple un identifiant qui est lié en fait à l'identifiant d'une autre table qui créé cette relation entre les 2, vous aurez tout compris en SQL et ça va largement vous facilité tout ce que vous allez faire dans ce langage et toutes les requêtes que vous avez élaboré par la suite. 

Parce qu'il y a beaucoup de gens qui bloquent là dessus alors que c'est quand même très très simple à comprendre. 

Si on prend ça de manière logique, ça s'assimile de manière beaucoup mieux. 

Voilà pour ces clés étrangères. 

On a vu et j'ai bien fait de noter parce que là je suis perdu, on a NOT NULL, DEFAULT, CHECK, UNIQUE, PRIMARY KEY, AUTO_INCREMENT, FOREIGN KEY et on doit terminer avec les INDEX. 

Alors un INDEX va être utile et même très très très utile, c'est une obligation et ça je vous le dis clairement et on termine avec ça dans le cas on en avait parlé lorsqu'on avait vu les différents moteurs de stockage notamment pour le moteur MyISAM.

Voyez l'avantage d'avoir vu les moteurs de stockage dans une autre vidéo. 

Et si vous savez de quoi je parle, et bien vous utilisez SQL en connaissance de cause et pas comme certains qui l'utilisent à l'aveuglette sans savoir ce qu'ils font. 

Eh bien je vous avais expliqué que le moteur MyISAM était très très pratique par exemple quand on a une table qui va par exemple avoir beaucoup de lecture à faire, beaucoup de recherche où ce genre de choses. 

Dans le cas où vous avez énormément de lecture c'est-à-dire de données à lire sur votre table ou des recherches à faire, l'idéal pour améliorer les performances ça va être de définir un index. 

C'est-à-dire que au lieu de définir du coup, de faire toujours les recherches et imaginez un système où il n'y aurait pas de cache où il n'y aurait pas de système de cache, Hé bien SQL serait obligé de parcourir toutes les données, toutes les données, toutes les données à chaque fois. 

Et comme ça fonctionne sous une structure d'arbre c'est-à-dire qu'on part d'un tronc qui peut ensuite se diviser en 2 puis ces deux-là peuvent se diviser encore en 2 et cetera. 

Bref ça pourrait comme ça avoir une quantité assez énormissime et du coup ralentir le temps d'exécution des requêtes. 

L'avantage des index, c'est comme pour un index Windows qui va indexer vos fichiers sur votre système d'exploitation, c'est qu'on va accélérer les choses parce qu'on aura un système de fichiers, un cache qui va enregistrer toute l'arborescence de votre table. 

Et quand on aura besoin de faire de la recherche ou de la sélection, comme on aura déjà tout indexé, ça va aller très très vite pour donner les résultats de votre requête. 

Ça va évidemment, ça peut tripler les performances et voir même plus. 

Dans certains cas, on peut même multiplier par 20 la vitesse d'exécution d'une requête donc ce n'est vraiment pas inutile. 

Il ne faut pas penser que c'est juste une petite accélération. 

Des fois la différence entre un index et pas d'index, ça peut être 20 fois plus rapide en termes de différences d'exécution donc c'est assez impressionnant l'apport que ça peut donner en termes de rapidité d'exécution et de performance. 

Donc l'index dans le cas où on aurait une table en MyISAM parce que c'est évidemment plus pratique. 

Faire ça sur une InnoDB, ce n'est pas forcément l'idéal mais on n'a qu'a partir du principe qu'on a ici une table MyISAM.

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
		FOREIGN KEY		(clé étrangère)
		
		INDEX
	/

>	CREATE TABLE IF NOT EXISTS `table_users`
>	(
>		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
>		`user_name` VARCHAR(30) NOT NULL,
>		`user_email` VARCHAR(100) NOT NULL,
>		`user_registration` DATE NOT NULL,
>		`user_admin` BOOLEAN DEFAULT 0,
>		
>		PRIMARY KEY(`id_user`)
>	);
	
	CREATE TABLE IF NOT EXISTS `table_news`
	(
		`id_news` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`news_title` VARCHAR(80) NOT NULL,
		`news_content` TEXT NOT NULL,
		`news_author` SMALLINT(6) NOT NULL,
		
		PRIMARY KEY(`id_news`),
		FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`)
	);

Sur une InnoDB, ce n'est pas forcément l'idéal mais on a qu'a partir du principe qu'on a une table MyISAM même si c'est pas le cas parce que je crois qu'elles sont par défaut en InnoDB, Eh bien ce serait de définir un index. 

Pour définir un index, le meilleur moyen de le faire lorsque vos tables sont créées. 

Il faut le faire bien sûr sur les tables existantes et là pour le coup c'est un petit peu différent de ce qu'on a vu tout à l'heure, c'est pour ça que je le fais sur la fin de cette vidéo. 

Vous faites un CREATE et je crois qu'il y a le mot UNIQUE mais il n'est pas obligatoire donc il me semble qu'il est facultatif c'est à voir mais il doit s'agir de l'ancienne syntaxe. 

Vous faites simplement CREATE INDEX, vous donner un nom d'index par exemple vous pouvez appeler idx_users pour les utilisateurs suivi de ON c'est à dire c'est index `idx_users` sur la table des utilisateurs table_users. 

Et l'index vous le faites sur les champs que vous voulez d'accord c'est vous qui voyez.

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
		FOREIGN KEY		(clé étrangère)
		
		INDEX
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);
	
	CREATE TABLE IF NOT EXISTS `table_news`
	(
		`id_news` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`news_title` VARCHAR(80) NOT NULL,
		`news_content` TEXT NOT NULL,
		`news_author` SMALLINT(6) NOT NULL,
		
		PRIMARY KEY(`id_news`),
		FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`)
	);

>	CREATE INDEX `idx_users` ON `table_users`(...);
	
Si vous voulez faire un index sur tous les champs de la table, vous le faites sur tous les champs sinon vous prenez pour vous ceux qui sont utiles et moi par exemple user_name est utile par contre le id_user comme il est automatique, il a aucun intérêt donc je ne vais pas le mettre ici mais on peut le faire par exemple sur user_email et puis admettons c'est tout.

>	CREATE INDEX `idx_users` ON `table_users`(`user_name`, `user_email`);

Voilà juste sur ça et du coup je définis un index là-dessus. 

	mysql> CREATE INDEX `idx_users` ON `table_users`(`user_name`, `user_email`);
	Query OK, 0 rows affected (0.03 sec)
	Records: 0  Duplicates: 0  Warnings: 0

Alors je ne sais pas si on fera grand-chose mais est-ce qu'il va me montrer-là.

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+----------------+
	| Field             | Type         | Null | Key | Default | Extra          |
	+-------------------+--------------+------+-----+---------+----------------+
	| id_user           | smallint     | NO   | PRI | NULL    | auto_increment |
	| user_name         | varchar(30)  | NO   | MUL | NULL    |                |
	| user_email        | varchar(100) | NO   |     | NULL    |                |
	| user_registration | date         | NO   |     | NULL    |                |
	| user_admin        | tinyint(1)   | YES  |     | 0       |                |
	+-------------------+--------------+------+-----+---------+----------------+
	5 rows in set (0.00 sec)

Alors non il ne va pas me montrer les index mais ce n'est pas grave mais par contre peut être qu'en faisant SHOW TABLE STATUS.

	mysql> show table status;
	+-------------+--------+---------+------------+------+----------------+
	| Name        | Engine | Version | Row_format | Rows | Avg_row_length |
	+-------------+--------+---------+------------+------+----------------+...
	| table_news  | InnoDB |      10 | Dynamic    |    0 |              0 |
	| table_users | InnoDB |      10 | Dynamic    |    0 |              0 |
	+-------------+--------+---------+------------+------+----------------+

	-------------+-----------------+--------------+-----------+----------------+
	 Data_length | Max_data_length | Index_length | Data_free | Auto_increment |
	-------------+-----------------+--------------+-----------+----------------+...
		   16384 |               0 |        16384 |         0 |           NULL |
		   16384 |               0 |            0 |         0 |              1 |
	-------------+-----------------+--------------+-----------+----------------+

	---------------------+-------------+------------+--------------------+
	 Create_time         | Update_time | Check_time | Collation          |
	---------------------+-------------+------------+--------------------+...
	 2020-12-21 01:08:44 | NULL        | NULL       | utf8mb4_unicode_ci |
	 2020-12-21 02:31:22 | NULL        | NULL       | utf8mb4_unicode_ci |
	---------------------+-------------+------------+--------------------+

	----------+----------------+---------+
	 Checksum | Create_options | Comment |
	----------+----------------+---------+
		 NULL |                |         |
		 NULL |                |         |
	----------+----------------+---------+

	2 rows in set (0.01 sec)

Alors il y a bien un index mais je ne saurais pas vous dire à quoi ça correspond parce qu'il y a trop de trucs. 

Et en plus c'est sur du InnoDB donc ce n'est pas forcément au top mais peu importe. 

Bref on a créé un index et c'est index là va favoriser, va vraiment améliorer, rendre plus rapide l'exécution de requêtes, de sélection de recherche comme vous allez apprendre à le faire plus tard dans cette formation ou tout simplement des recherches dans les données. 

C'est par exemple vous voulez faire un petit moteur de recherche ou autre, dès qu'il va falloir comme ça parcourir le contenu de notre table en ayant un index de défini, on va vraiment vraiment accélérer les choses. 

Alors si on veut le retirer. 

On va bientôt terminer cette vidéo et c'est pourquoi n'hésitez pas à la regarder en plusieurs fois parce qu'elle est quand même assez longue je pense. Je pense qu'il fera plus d'une heure celle là je n'ai pas fait gaffe à quelle heure j'ai commencé cet enregistrement mais elle aura probablement occupé pas mal votre journée. 

Alors donc on fait ALTER TABLE table_users, ensuite on fait simplement DROP INDEX suivi du nom de l'index qu'on avait mis et moi c'était idx_users.

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
		FOREIGN KEY		(clé étrangère)
		
		INDEX
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);
	
	CREATE TABLE IF NOT EXISTS `table_news`
	(
		`id_news` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`news_title` VARCHAR(80) NOT NULL,
		`news_content` TEXT NOT NULL,
		`news_author` SMALLINT(6) NOT NULL,
		
		PRIMARY KEY(`id_news`),
		FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`)
	);
	
	ALTER TABLE `table_users`
	DROP INDEX `idx_users`;

Voilà ça c'est pareil parce que vous n'en voyez peut-être pas encore l'utilité parce que vous n'avez pas encore fait énormément de choses en SQL mais par la suite vous allez très vite vous rendre compte de leur efficacité.

	mysql> ALTER TABLE `table_users`
		-> DROP INDEX `idx_users`;
	Query OK, 0 rows affected (0.02 sec)
	Records: 0  Duplicates: 0  Warnings: 0

Voilà ce sera très utile, on le verra. 

On pourra même tester les requêtes avec ou sans index et on pourra comme savoir car MySQL affiche le temps d'exécution des requêtes donc ça permettra de observer les différences assez hallucinante entre 2 cas différents. 

Pas forcément sur les grosses bases de données déjà sur des bases de données assez modestes, on peut déjà avoir des différences assez flagrantes donc c'est plutôt sympa. 

Voilà pour les contraintes donc on a fait le tour. 

Alors on va le noter ici, les index c'est pour la lecture et la recherche de données évidemment.

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
		FOREIGN KEY		(clé étrangère)
		
		INDEX			(index - pour la lecture et la recherche)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);
	
	CREATE TABLE IF NOT EXISTS `table_news`
	(
		`id_news` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`news_title` VARCHAR(80) NOT NULL,
		`news_content` TEXT NOT NULL,
		`news_author` SMALLINT(6) NOT NULL,
		
		PRIMARY KEY(`id_news`),
		FOREIGN KEY(`news_author`) REFERENCES `table_users`(`id_user`)
	);
	
	ALTER TABLE `table_users`
	DROP INDEX `idx_users`;

Ça ce sont donc toutes les contraintes à connaître.

	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
		FOREIGN KEY		(clé étrangère)
		
		INDEX			(index - pour la lecture et la recherche)
	/

D'accord tout ce qu'il y a à connaître. 

Je vous ai montré les syntaxes encore une fois SQL général mais sachez qu'il y a des syntaxes que pour MySQL puis des syntaxes que pour Oracle puis des syntaxes que pour PostgreSQL puis des syntaxes que pour SQL Server et cetera et cetera donc vous êtes bien évidemment libre de les apprendre si ça vous chante. 

Petite parenthèse de fin, je ne vais pas vous laisser avec ça. 

Au niveau de la création de tables parce que je n'en ai pas forcément parlé dans la vidéo précédente et en y repensant je me dis que ça peut être bien de vous en parler parce que ce sont des choses à savoir faire c'est-à-dire à la création de tables on peut spécifier des informations précises sur le moteur de la table et tout ce qui est encodage. 

Vous savez que vous avez un encodage par défaut et un moteur de stockage géré par défaut mais je trouve qu'il est mieux quand on crée nos tables de le spécifier manuellement pour être sûr comme ça que si un jour on a des valeurs par défaut qui sont différentes que celles que vous auriez sur votre système que vous n'ayez pas de mauvaises surprises. 

Donc on peut et d'ailleurs je vais virer tout ça.

	client
	-------

	mysql> drop table table_users;
	ERROR 3730 (HY000): Cannot drop table 'table_users' referenced by a foreign key constraint 'table_news_ibfk_1' on table 'table_news'.


Alors oui je ne vous avais pas dit lorsque vous avez des clés étrangères et comme vous avez des relations qui ont été faites entre les tables, vous allez devoir enlever donc casser les clés étrangères, les relations que vous avez avant de pouvoir supprimer les tables. 

Tant que les relations n'auront pas été enlevée, vous ne pourrez pas comme vous pouvez le voir en direct, supprimer une table qui aurait encore des relations encore existantes. 

Par exemple quand vous aurez des données reliées, vous pourrez par la suite dire que quand je supprime par exemple un news, Eh bien toutes les informations qui sont reliées à cette news, je les supprime aussi parce qu'elles n'ont plus d'intérêt à être là. 

Ou alors utilisateur a été supprimé dans le site et il a demandé à ce qu'on supprime tout son contenu donc on demanderait à retirer tous les messages du forum laissé par l'utilisateur un tel. 

Voyez ce genre de chose.

C'est ce qu'on appelle la suppression en cascade mais ça on verra ça pour la suite sur les vidéos en SQL. 

Là du coup, on va virer l'autre table. 

	client
	------

	mysql> drop table table_news;
	Query OK, 0 rows affected (0.03 sec)

	mysql> drop table table_users;
	Query OK, 0 rows affected (0.03 sec)

Très bien du coup comme j'ai enlevé la table qui avait la clé étrangère du coup ça ne lui pose pas de problème. 

Évidemment ne faites pas ça sur un vrai projet. 

Si vous faites ça sur une vraie base de données avec de vraies données, vous risquez de vous faire taper sur les doigts. 

Là je suis sur un truc en local de test donc je peux faire plein de bêtises sans problème mais dans la vraie vie on ne fait pas ça. 

Alors on va virer table_news, on s'en fiche.

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
		FOREIGN KEY		(clé étrangère)
		
		INDEX			(index - pour la lecture et la recherche)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	);

Et ensuite vous pouvez le faire mais ce n'est pas obligé, spécifiez 3 informations à la création de la table qui peuvent être utiles. 

La première c'est le moteur à définir et vous avez vu que moi par défaut MySQL je me définis tout en InnoDB mais dans le cadre de tout à l'heure on avait dit qu'on mettrait un index, ça aurait été mieux d'avoir une table en MyISAM avec le moteur MyISAM. 

Donc pour ça vous mettez après la parenthèse fermante de CREATE TABLE, ENGINE = et vous pouvez mettre le nom que vous voulez donc ça peut être InnoDB ou le fameux MyISAM.

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
		FOREIGN KEY		(clé étrangère)
		
		INDEX			(index - pour la lecture et la recherche)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	)
	ENGINE = MyISAM;

Alors je crois qu'il n'y a pas de case obligatoire genre de minuscules ou majuscules donc ça vous pouvez l'écrire comme vous voulez mais moi j'essaie de garder la syntaxe comme ça ENGINE = MyISAM par habitude. 

Ensuite on va définir CHARACTER SET mais je pense que le mot DEFAULT n'est pas obligatoire. 

Alors CHARACTER SET c'est le fameux utf8mb4 dont on avait parlé précédemment. 

Et on va avoir le COLATE qui va être utf8mb4_unicode_ci parce qu'on veut que ce soit sensible par rapport à la casse. 

	contraintes.sql
	---------------
	
	/
		NOT NULL 		(colonne obligatoire)
		DEFAULT 		(valeur par défaut)
		CHECK 			(vérification d'une valeur)
		UNIQUE			(valeur de champ unique)
		PRIMARY KEY		(clé primaire)
		AUTO_INCREMENT	(incrémentation de 1 en 1)
		FOREIGN KEY		(clé étrangère)
		
		INDEX			(index - pour la lecture et la recherche)
	/

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	)
	ENGINE = MyISAM
	CHARACTER SET utf8mb4
	COLLATE utf8mb4_unicode_ci;

On enregistre.

	mysql> CREATE TABLE IF NOT EXISTS `table_users`
		-> (
		-> `id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		-> `user_name` VARCHAR(30) NOT NULL,
		-> `user_email` VARCHAR(100) NOT NULL,
		-> `user_registration` DATE NOT NULL,
		-> `user_admin` BOOLEAN DEFAULT 0,
		->
		-> PRIMARY KEY(`id_user`)
		-> )
		-> ENGINE = MyISAM
		-> CHARACTER SET utf8mb4
		-> COLLATE utf8mb4_unicode_ci;
	Query OK, 0 rows affected, 1 warning (0.03 sec)

	mysql> describe table_users;
	+-------------------+--------------+------+-----+---------+----------------+
	| Field             | Type         | Null | Key | Default | Extra          |
	+-------------------+--------------+------+-----+---------+----------------+
	| id_user           | smallint     | NO   | PRI | NULL    | auto_increment |
	| user_name         | varchar(30)  | NO   |     | NULL    |                |
	| user_email        | varchar(100) | NO   |     | NULL    |                |
	| user_registration | date         | NO   |     | NULL    |                |
	| user_admin        | tinyint(1)   | YES  |     | 0       |                |
	+-------------------+--------------+------+-----+---------+----------------+
	5 rows in set (0.00 sec)

Voilà comme ça la table elle redéfinit et si je vérifie, je verrai que ça a changé et que ma table USER est bien en MyISAM.

	mysql> show table status;
	+-------------+--------+---------+------------+------+----------------+
	| Name        | Engine | Version | Row_format | Rows | Avg_row_length |
	+-------------+--------+---------+------------+------+----------------+...
	| table_users | MyISAM |      10 | Dynamic    |    0 |              0 |
	+-------------+--------+---------+------------+------+----------------+

	-------------+-----------------+--------------+-----------+----------------+
	 Data_length | Max_data_length | Index_length | Data_free | Auto_increment |
	-------------+-----------------+--------------+-----------+----------------+...
			   0 | 281474976710655 |         1024 |         0 |              1 |
	-------------+-----------------+--------------+-----------+----------------+

	---------------------+---------------------+------------+--------------------+
	 Create_time         | Update_time         | Check_time | Collation          |
	---------------------+---------------------+------------+--------------------+...
	 2020-12-21 03:10:57 | 2020-12-21 03:10:57 | NULL       | utf8mb4_unicode_ci |
	---------------------+---------------------+------------+--------------------+

	----------+----------------+---------+
	 Checksum | Create_options | Comment |
	----------+----------------+---------+
		 NULL |                |         |
	----------+----------------+---------+

	1 row in set (0.01 sec)

Ma table_users est bien en MyISAM alors que par défaut c'est bien en InnoDB et que ça a bien enregistrer les bons encodage donc à priori c'est okay. 

Alors ça vous pouvez le faire et c'est même mieux parce que admettons que vous ayez un fichier tout fait, que vous avez importé sur votre machine. 

Sur votre machine vous savez que vous avez spécifié InnoDB par défaut, ce genre de choses donc pas de problème. 

Le jour vous allez sur une autre machine qui n'a pas les mêmes paramètres par défaut pour le moteur de stockage, les encodages, Eh bien quand vous allez faire juste votre CREATE TABLE comme ça.

	mysql> CREATE TABLE IF NOT EXISTS `table_users`
		-> (
		-> `id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		-> `user_name` VARCHAR(30) NOT NULL,
		-> `user_email` VARCHAR(100) NOT NULL,
		-> `user_registration` DATE NOT NULL,
		-> `user_admin` BOOLEAN DEFAULT 0,
		->
		-> PRIMARY KEY(`id_user`)
		-> )

Eh bien vous n'aurez pas les mêmes moteurs, les mêmes encodages et vous allez avoir de nouvelles surprises quand vous allez faire vos requêtes. 

Alors que là.

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	)
	ENGINE = MyISAM
	CHARACTER SET utf8mb4
	COLLATE utf8mb4_unicode_ci;

Alors que là comme c'est spécifié manuellement, je suis sûr qu'en créant ma table ici peu importe sur quelle machine, peu importe les paramètres par défaut et comme je spécifie mes propres paramètres manuellement, et bien ça appliquera ce moteur-là et ces encodages-là pour ma table_users. 

Donc n'hésitez pas à le faire, ce n'est que 3 lignes de plus même pas et on pourrait tout mettre sur une seule si on voulait. On pourrait faire ça comme ça même si je le mets sur 3 lignes parce que c'est beaucoup plus facile à la lecture.

	CREATE TABLE IF NOT EXISTS `table_users`
	(
		`id_user` SMALLINT(6) NOT NULL AUTO_INCREMENT,
		`user_name` VARCHAR(30) NOT NULL,
		`user_email` VARCHAR(100) NOT NULL,
		`user_registration` DATE NOT NULL,
		`user_admin` BOOLEAN DEFAULT 0,
		
		PRIMARY KEY(`id_user`)
	)
	ENGINE = MyISAM CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

Voilà ça prendra un peu plus de temps mais c'est bien de le savoir, et c'est vrai que j'en avais pas parlé dans la vidéo précédente donc je le fais maintenant parce que moi je le fais habituellement quand je fais mes fichiers SQL donc après tout ce serait dommage de ne pas vous en faire profiter. 

Voilà pour cette vidéo qui encore une fois et comme je vous l'avais dit au début n'était pas mal longue mais c'est vraiment une des vidéos ou en tout cas la vidéo la plus importante sur cette formation SQL. 

J'espère que tout était suffisamment clair pour vous et que j'ai bien expliqué les choses sinon n'hésitez pas à poser des questions en commentaire, s'il y a plein de questions n'hésitez pas parce que la vidéo était très très longue, riche en détails, en requêtes, en mots clés. 

Il n'y avait plein de choses et j'espère que vous avez pu prendre des notes et dans tous les cas c'est facile sur vidéo parce que vous pouvez mettre sur pause donc c'est plus simple que dans un amphithéâtre ou une salle de classe. 

Voilà n'hésitez pas également à faire vos tables, à spécifier les contraintes particulières, à faire des tests pour voir quel chose marche et quel chose ne marche pas pour assimiler tout ça. 

Et comprenez bien le principe de clé étrangère qui est très important parce qu'il va vous suivre tout le long et ça vous servira tout le temps en SQL quand vous ferez même du web en PHP, en Javascript et même avec python. 

Avec d'autres langages de programmation quel qu'il soit, ce principe de clé étrangère est très important en SQL parce que c'est ce qui détermine les relations entre les différentes tables. 

Voilà je vous dis à très bientôt pour une prochaine vidéo. 

Pour la prochaine vidéo on fera quelque chose de très court, ça va nous changer et on parlera des utilisateurs. 

Voilà on revient sur quelques petites requêtes ou autre pour spécifier des informations et gérer nos utilisateurs qui pourront utiliser nos bases de données donc ce sera très très court comparé à cette vidéo là. 

Je vous dis à très bientôt et encore une fois n'hésitez pas en commentaire et que vous avez des questions si quelque chose n'a pas été compris, je serai présent pour y répondre. 

À bientôt tout le monde
*/

