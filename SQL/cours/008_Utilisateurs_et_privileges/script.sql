/*
SQL #8 - utilisateurs et privilèges
29-12-20

	> mysqld --console
	> mysql -u root -p

Bonjour à tous, bienvenue dans cette séance 8 en sql.

Nous allons parler de la gestion des utilisateurs et cette vidéo sera beaucoup plus courte que la précédente qui avait duré bien une heure le temps de faire le tour des contraintes.

Alors les utilisateurs par défaut, quand vous allez travailler en local nous allons nous
connecter et travailler avec l'utilisateur root ça ne pose pas de problème puisque nous ne sommes pas connecté à internet nous ne travaillons pas en ligne.

Et cet utilisateur-là possède tous les droits d'accord au niveau d'une des bases de données il va pouvoir tout faire.

Il peut créer des bases, il peut les supprimer, il peut gérer les droits d'utilisateurs, il peut
travailler sur les tables, bref il peut vraiment tout tout tout gérer tout modifier tout créer et supprimer et cetera.

Le problème c'est que dans un cas concret, dans un cas réel ou alors quand vous allez travailler directement via un hébergeur en ligne vous devrez utiliser ou alors en tout cas on vous mettra à disposition un utilisateur avec des droits limités.

En SQL, ces droits on les appelle des privilèges donc on va regarder un petit peu comment
travailler avec tout ça déjà comment gérer nos utilisateurs et ensuite on verra comment gérer leurs droits.

Alors première chose à faire c'est d'afficher la liste des utilisateurs par défaut qu'on peut avoir par exemple sur mysql ici, déjà si je fait show databases ...

	+--------------------+
	| Database           |
	+--------------------+
	| cours_sql          |
	| information_schema |
	| mysql              |
	| performance_schema |
	| sys                |
	+--------------------+
	6 rows in set (0.00 sec)

On peut remarquer que nous avons une base de données mysql, évidemment si vous utilisez un autre
système de gestion ce ne serait pas la même chose pour le coup mais ici dans ce cas là pour mysql nous avons une base ici qui contiendra une table user qui va nous permettre de récupérer toutes les infos que nous voulons donc on va juste faire une petite commande de recherche
donc de sélection mais c'est des choses que l'on verra par la suite en faisant select user from mysql donc ça c'est la base de données, point la table en question, mysql.user.

	+------------------+
	| user             |
	+------------------+
	| mysql.infoschema |
	| mysql.session    |
	| mysql.sys        |
	| root             |
	+------------------+
	4 rows in set (0.00 sec)

Et là on retrouve quelques utilisateurs dont notre utilisateur root avec lequel nous sommes connectés et que nous nous connectons depuis le départ pas comme ça y'a pas de problème à ce niveau là.

Si on veut on peut également s'assurer de vérifier par exemple l'utilisateur en cours, celui qu'on est en train d'utiliser. Pour ça très simplement on peut faire un select current_user() donc c'est une fonction de sql qui nous permet d'avoir l'utilisateur courant, celui qui est utilisé tout de suite.

	+----------------+
	| current_user() |
	+----------------+
	| root@localhost |
	+----------------+
	1 row in set (0.00 sec)

Et quand je fais ça on obtient cette information là.

Alors vous voyez qu'il y a un schéma un peu particulier on a le nom d'utilisateur d'accord on a ensuite un @ et nous avons un nom d'hôte.

Le nom d'hôte et bien c'est simplement l'hôte sur lequel on va se connecter.

Quand on est en local il s'agit de localhost c'est le terme utilisé partout et si vous êtes en ligne ou si vous passez par un hébergeur vous aurez à priori une adresse ip précise ou voir un nom de domaine d'accord ça peut être l'un ou l'autre.

Alors c'est pareil, localhost a une adresse ip qui lui est propre mais on utilise en général le nom localhost c'est
plus facile que d'écrire 127.0.0.1 donc ça fait gagner du temps donc ça c'est à connaître ce schéma, en fait tous nous
avons le nom de l'utilisateur, un @ et le nom de l'hôte parce que vous allez voir que ce schéma là va nous servir par la suite.

On va s'occuper de créer un utilisateur de test pour voir déjà comment on fait ça en SQL et ça va être très très simple.

	users.sql
	---------
	CREATE USER IF NOT EXISTS

On va utiliser la commande create user alors elle peut prendre également en option le fameux if not exist pour dire je crée un utilisateur s'il n'existe pas déjà parce
que si vous si vous essayez de créer un utilisateur dont le pseudo existe déjà dans votre système et bien vous aurez
une erreur ou alors un avertissement.

Vous pouvez toujours ajouter if not exists si vous voulez.

Et à partir de là, on va reproduire le schéma nous avons vu
tout à l'heure sauf qu'il faut mettre ça sous forme de chaîne pour éviter les problèmes par exemple en cas de caractères spéciaux donc on va mettre ça l'arobase et ça.

	users.sql
	---------
	CREATE USER ''@''

Mon premier point on met le nom d'utilisateur comme on l'a vu tout à l'heure et ensuite le nom de l'hôte, comme on est en local c'est toujours localhost, ok.

	users.sql
	---------
	CREATE USER 'jachampagne'@'localhost'

On peut directement lui définir un mot de passe si on veut pour cet utilisateur en faisant ceci.

	users.sql
	---------
	CREATE USER 'jachampagne'@'localhost' IDENTIFIED BY 'passe';

Par exemple 'passe' ce qui ne serait évidemment pas
sécurisé en cas réel mais voilà comment on pourrait faire ça en une fois.

Si vous ne faites pas le mot de passe vous pourrez par la suite le changer d'accord si vous voulez.

On va déjà faire ça nous voilà.

	mysql> CREATE USER 'jachampagne'@'localhost' IDENTIFIED BY 'passe';
	Query OK, 0 rows affected (0.01 sec)

	mysql> select user from mysql.user;
	+------------------+
	| user             |
	+------------------+
	| jachampagne      |
	| mysql.infoschema |
	| mysql.session    |
	| mysql.sys        |
	| root             |
	+------------------+
	5 rows in set (0.00 sec)

Et là du coup si j'affiche tous les utilisateurs vous
voyez qui m'a rajouté mon nouvel utilisateur.

On va se déconnecter du système de gestion hop.

	> exit
	Bye

	> mysql -u jachampagne -p
	Enter password: *****

On va se reconnecter avec sql, cette fois ci au lieu de se connecter à root et bien on va faire le nouvel utilisateur tiret p, il me demande mon mot de passe donc c'est celui qu'ont noté "passe" et nous nous connectons dessus.

	mysql> select current_user();
	+-----------------------+
	| current_user()        |
	+-----------------------+
	| jachampagne@localhost |
	+-----------------------+
	1 row in set (0.00 sec)

D'ailleurs si je fais un current_user(), il va nous le confirmer et nous sommes bien sur le nouvel utilisateur donc voilà comment que ça se passe.

On va revenir sur root parce qu'évidemment on va travailler avec lui.

	mysql> exit
	Bye

	PS C:\Users\sam> mysql -u root -p
	Enter password:

Voilà et par la suite nous pouvons éventuellement modifier encore le mot de passe ou alors en ajouter un si jamais
vous ne l'aviez pas fait, pour ça alors il y a une ancienne méthode d'accord qui était utilisé par exemple et qui peut toujours être utiliser.

La commande SET PASSWORD FOR puis l'ensemble d'utilisateurs donc ça 'jachampagne'@'localhost', voilà par exemple. Et de préciser le mot de passe que nous voulons en mettant simplement par exemple 'new' comme password ce genre de choses.

	users.sql
	---------
	CREATE USER 'jachampagne'@'localhost' IDENTIFIED BY 'passe';
	SET PASSWORD FOR 'jachampagne'@'localhost' = 'new';

On pouvait même sur certaines version de mysql directement chiffrer
ce mot de passe càd de lui imposer hash en fait pour éviter de l'avoir a stocker en clair en utilisant la fonction PASSWORD().

	SET PASSWORD FOR 'jachampagne'@'localhost' = PASSWORD('new');

Alors j'ai remarqué puisque ça je ne le savais pas forcément avant parce que c'est au niveau de cette formation que je suis passé à mysql 8 sinon j'étais
toujours sur une version 5.quelque chose et puis j'ai remarqué que depuis mysql 8 cette fonction a disparu, en fait elle ne fonctionne plus donc si vous êtes comme moi ici sur mysql 8 donc la version actuelle au moment je fais cette vidéo, cette commande ne fonctionnera pas.

D'ailleurs je peux vous montrer si j'essaye de faire ça, ça va me dire qu'il y a une erreur dans ma requête, une erreur de syntaxe.

	mysql> SET PASSWORD FOR 'jachampagne'@'localhost' = PASSWORD('new');
	ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'PASSWORD('new')' at line 1

Donc j'ai découvert en fait directement quand j'avais vérifié pour les utilisateurs que cette fonction n'existait plus d'accord donc d'ailleurs cette syntaxe-là n'est pas forcément recommandé maintenant d'accord, vous pouvez l'utiliser donc en faisant comme on a fait quand je l'ai montré au départ comme ceci.

	SET PASSWORD FOR 'jachampagne'@'localhost' = 'new';

... mais elle n'est pas forcément celle qu'il faut utiliser
maintenant, celle qui est recommandé le plus c'est la syntaxe avec l'altération c'est à dire qu'on va préférer altérer en fait un utilisateur en particulier et re-modifier
son mot de passe via la syntaxe utilisée ici.

Comment on va faire ça ?

On va simplement faire alter user le nom d'utilisateur et ensuite on va faire identified by et le nouveau mot de passe.

	users.sql
	---------
	CREATE USER 'jachampagne'@'localhost' IDENTIFIED BY 'passe';
	ALTER USER 'jachampagne'@'localhost' IDENTIFIED BY 'new';

Et là, c'est bon on refait la commande.

	mysql> ALTER USER 'jachampagne'@'localhost' IDENTIFIED BY 'new';
	Query OK, 0 rows affected (0.02 sec)

Voilà là je vais tester, je vais me déconnecter et me reconnecter pour voir s'il a bien pris en compte le
nouveau mot de passe.

Si c'est pas le cas ce serait embêtant.

	> exit
	Bye
	> mysql -u jachampagne -p
	Enter password: ***

Notre mdp new et c'est bon ok.

Voilà comment on fait une modification qui du coup est un peu plus à jour maintenant c'est un peu comme les alter table comme on a fait précédemment mais là on fait un alter user.

c'est une syntaxe un peu plus moderne on va dire en sql pour pouvoir modifier comme ça le mot de passe de votre
utilisateur ou des informations.

C'est mieux de procéder de cette manière donc on va reprendre notre utilisateur root et vous voyez que mon utilisateur root n'a pas de mot de passe.

	> exit
	Bye
	> mysql -u root -p
	Enter password:

Si je voulais, je pourrait changer, je pourrais très bien faire un alter user de root @ localhost identified by et lui metttre un mot de passe même s'il n'en a pas ça fonctionnera évidemment donc voilà pour tout ce qui est création d'utilisateurs d'accord.

On peut aussi renommé le nom car on avait vu comment faire pour le mot de passe donc si on veut changer le nom on fera simplement la commande ... je vais aller assez vite pour ne pas faire une vidéo trop trop long même si je sais quelle sera beaucoup plus courte que la précédente.

On fera lui rename user et là vous prenez toutes les informations d'avant et vous faites to et les nouvelles informations dont vous mettez ça tout simplement.

	users.sql
	---------
	CREATE USER 'jachampagne'@'localhost' IDENTIFIED BY 'passe';
	ALTER USER 'jachampagne'@'localhost' IDENTIFIED BY 'new';
	
	RENAME USER 'jachampagne'@'localhost' TO 'jason'@'localhost';

Voilà ça permet de changer les infos ici on fait ça.

	> RENAME USER 'jachampagne'@'localhost' TO 'jason'@'localhost';
	Query OK, 0 rows affected (0.01 sec)

	> select user from mysql.user;
	+------------------+
	| user             |
	+------------------+
	| jason            |
	| mysql.infoschema |
	| mysql.session    |
	| mysql.sys        |
	| root             |
	+------------------+
	5 rows in set (0.00 sec)

Voilà et on voit que le nom d'utilisateur a changé donc très facile à faire, très rapides et si on veut supprimer un utilisateur puisse que c'est bien de voir ça on fera simplement comme pour les tables, comme pour les bases de données un drop user suivi de toute l'information en question.

	users.sql
	---------
	CREATE USER 'jachampagne'@'localhost' IDENTIFIED BY 'passe';
	ALTER USER 'jachampagne'@'localhost' IDENTIFIED BY 'new';
	
	RENAME USER 'jachampagne'@'localhost' TO 'jason'@'localhost';
	DROP USER 'jason'@'localhost';

	client
	------
	> DROP USER 'jason'@'localhost';
	Query OK, 0 rows affected (0.02 sec)

	> select user from mysql.user;
	+------------------+
	| user             |
	+------------------+
	| mysql.infoschema |
	| mysql.session    |
	| mysql.sys        |
	| root             |
	+------------------+
	4 rows in set (0.00 sec)

Voilà si je fais ça hop, je n'ai plus mon utilisateurs donc ça c'est pour tout ce qui est gestion utilisateur. Il n'y a rien d'autre à voir d'accord.

Vous avez vu comment reconnaître l'utilisateur courant, comment lister les utilisateurs de votre système, vous avez vu comment créer, comment modifier le mot de passe, le nom d'utilisateur et supprimer donc avec ça, vous avez grosso modo tout ce qui à savoir au niveau gestion des utilisateurs.

Maintenant ces utilisateurs ont un système comme je vous l'ai dit de privilèges, de droit et ça ça va être un petit peu plus long à aborder mais on va aller assez vite aussi dessus parce que dans les cas, dans la majorité des cas, vous allez très très peu utilisé ce système là ou en tout cas de manière assez sommaire donc on ne va pas trop perdre de temps là-dessus et on va en parler.

Nous avons une commande qui va permettre d'appliquer ou éventuellement de révoquer c'est-à-dire de retirer des privilèges donc des droits selon nos utilisateurs donc on va utiliser la commande grant et grant elle va prendre un ensemble de privilèges.

	GRANT

Ces privilèges-là pour aller beaucoup plus vite et pour vous les résumer puisque ça sert à rien de vous les faire tous un par un je vous ai fait un petit tableau ici si vous voulez mettre en pause la vidéo et récupérer le tableau faire une capture d'écran ce que vous voulez ou prendre des notes vous pouvez.

+---------------------------+-----------------------------------------------------------------------+
| NOM PRIVILEGES			| AUTORISATION															|
+---------------------------+-----------------------------------------------------------------------+
| ALL / ALL PRIVILEGES		| Tous les droits (sauf GRANT)											|
| ALTER						| Droit de modifier une table											|
| ALTER ROUTINE				| Droit de modifier/supprimer une procédure ou fonction stockée			|
| CREATE TABLE				| Droit de créer une table												|
| CREATE TEMPORARY TABLE	| Droit de créer temporairement une table								|
| CREATE ROUTINE			| Droit de créer des procédures et fonctions stockées					|
| CREATE USER				| Droit de gérer les utilisateurs (création/modification/suppression)	|
| CREATE VIEW				| Droit de créerdes vues												|
| DROP						| Droit de supprimer des bases de données, tables et vues				|
| EXECUTE					| Droit d'éxécuter des procédures et fonctions stockées					|
| GRANT OPTION				| Droit d'utiliser la commande GRANT									|
| INDEX						| Droit de créer et supprimer des index									|
| LOCK TABLES				| Droit de vérouiller des tables										|
| TRIGGER					| Droit de créer et supprimer des "triggers"							|
| USAGE						| Aucun droit															|
+---------------------------+-----------------------------------------------------------------------+

Alors grosso modo pour résumer on voit que nous avons un autre privilège s'appelle ALL ou alors vous pouvez écrire ALL PRIVILIGES qui permet d'avoir tous les droits donc par exemple root on est sûr qu'actuellement il a ce droit là, il a le privilège ALL donc
ça c'est ce que vous allez faire part du temps quand vous allez vouloir gérer certains droits précis.

Après on voit par exemple ALTER qui va vous permettre de gérer tout ce qui est modification de table.

Si on fait ALTER ROUTINE et ça on n'en a pas encore parlé pour le moment à ce stade de la formation tout ce qui concerne la gestion des procédures et fonctions stocker et ça on n'en parlera plus tard.

CREATE TABLE pour avoir le droit de créer des tables càd que si vous ne mettez pas ce privilège là à un utilisateur il n'aura pas le droit de créer des tables, voyez on peut vraiment gérer tout particulièrement.

CREATE USER, on a le droit de gérer des utilisateurs donc si un utilisateur n'a pas ce privilège là, il ne pourra pas lui même à son tour créer, modifier ou supprimer des utilisateurs, ce qui est plutôt pas mal, imaginez sur un site avec plusieurs utilisateurs s'ils ne sont pas admin on n'a pas envie qu'ils aillent supprimer le compte de leurs collègues, ça paraît normal.

Les vues on n'en a pas parlé encore donc je passe très très vite et on a beaucoup de choses.

On a aussi le droit de GRANT càd qu'avec ALL tous les droits sauf GRANT d'accord ça ne vous permet pas d'utiliser justement la commande pour changer les privilèges. Pour cela il faut utiliser GRANT OPTION.

Voilà tout ce qui concerne les index on en a parlé précédemment avec les contraintes.

Le verrouillage LOCK TABLES, on n'en a pas parlé mais bon ça nous intéresse pas pour le moment.

Les TRIGGER non plus.

Et usages en fait simplement pour pas modifier les droits donc c'est Aucun droit en fait mais c'est pareil, c'est un cas assez particulier.

Voilà grosso modo je vais très vite parce qu'encore une fois à moins que vous ayez besoin de cas très particulier et à ce moment là vous reviendrez sur ce tableau pour utiliser le bon droit en question.

Nous on va aller assez vite sur les explications à donner.

Grosso modo le schéma de la commande pour l'application de privilèges c'est grant suivi des privilèges en particulier donc si par exemple vous vouliez un privilège de CREATE TABLE admettons par exemple, on noterait tout simplement comme ceci le nom CREATE TABLE, on peut remettre plusieurs avec des virgules.

	users.sql
	---------
	CREATE USER 'jachampagne'@'localhost' IDENTIFIED BY 'passe';
	ALTER USER 'jachampagne'@'localhost' IDENTIFIED BY 'new';
	RENAME USER 'jachampagne'@'localhost' TO 'jason'@'localhost';
	DROP USER 'jason'@'localhost';
	
>	GRANT CREATE TABLE

On peut les séparer par des virgules, on
peut mettre voilà par exemple GRANT sur select aussi pour un cas particulier 

>	GRANT SELECT

Bref on peut l'appliquer vraiment sur beaucoup de choses donc nous ce qu'on va faire la plupart du temps et c'est ce que vous pouvez retenir vous pour la majorité, on fait un GRANT ALL par exemple quand on veut pouvoir faire pas mal de choses sauf pouvoir modifier les les droits c'est à dire qu'on va créer un utilisateur qui ne pourra pas modifier les droits d'accord on va le refaire voilà parce que si on en a pas ça va être embêtant hop voilà comme ça on va en faire un nouveau.

	mysql> CREATE USER 'jachampagne'@'localhost' IDENTIFIED BY 'passe';
	Query OK, 0 rows affected (0.02 sec)

	mysql> select user from mysql.user;
	+------------------+
	| user             |
	+------------------+
	| jachampagne      |
	| mysql.infoschema |
	| mysql.session    |
	| mysql.sys        |
	| root             |
	+------------------+
	5 rows in set (0.00 sec)

C'est bon et cet utilisateur, on va lui permettre de tout faire sauf de modifier des droits des utilisateurs dont il ne pourra pas commencer à modifier les droits de root ou les droits des autres utilisateurs.

Par contre il pourra tout faire sur sa base de données, il pour en créer, il pourra créer des tables, faire des enregistrements, faire des sélects, supprimer des enregistrements, etc puisque c'est ça sa base de données à lui, c'est lui qui gérera ça.

On va donc dire GRANT ALL et ensuite on va dire où on le fait d'accord c'est à dire que on va utiliser le mot ON et ON justement va prendre plusieurs choses soit on veut lui donner les droits sur toutes les bases et toutes les tables et dans ce cas là on fait, on utilise des joker càd qu'on utilise le symbole étoile.

	GRANT ALL ON *.*

Ca * ça veut dire toutes les bases de données, point, toutes les tables de toutes les bases de données, *.*, donc ça c'est le droit maximale c'est à dire vraiment c'est tout sur tout.

Là on lui donne tous les droits sur tout et peut-être que cette personne là on lui a attribué une base de données qu'à lui  d'accord genre sa base à lui d'accords genre jabase, et à ce moment là on lui dit voilà sur sa base il peut tout faire mais que sur sa base.

	GRANT ALL ON jabase.*

Càd sur une autre base de données il n'aura pas tous les droits d'accord vous voyez on peut vraiment gérer des droits spécifiques.

On peut également dire sur une table précise genre une base précise qui s'appellerait base et puis une table par exemple une table qui s'appellerait tusers, ce genre de choses.

	GRANT ALL ON base.tusers

Ou directement le nom d'une d'une table tusers ou le nom d'une table suivi du nom d'un champ.

	GRANT ALL ON tusers
	
	GRANT ALL ON tusers.username

Voyez on peut vraiment vraiment prévoir comme ça les cas spécifiques d'accord donc nous par exemple ce qu'on va faire ? On avait créé une base de données cours_sql voilà.

	mysql> show databases;
	+--------------------+
	| Database           |
	+--------------------+
>	| cours_sql          |
	| information_schema |
	| mysql              |
	| performance_schema |
	| sys                |
	+--------------------+
	5 rows in set (0.01 sec)

Admettons voilà je veux protéger càd que mon utilisateur jachampagne ne puisse que travailler sur cours_sql mais j'ai pas envie qu'il aille commencer à toucher à information_schema, sys ou ce genre de choses.

Dans ce cas là je vais lui dire tu as tous les droits sur cours_sql.*, tu a tout les droits sur cours_sql.*

	GRANT ALL ON cours_sql.*

Tu as le tous les droits sur ça. Vous pouvez mettre à la ligne pour que ce soit plus lisible.

	GRANT ALL 
	ON cours_sql.*

Et après qui évidemment peut faire ça ? donc c'est notre utilisateur là et voilà.

	GRANT ALL 
	ON cours_sql.*
	TO 'jachampagne'@'localhost';

Si éventuellement vous lui ajouté un GRANT OPTION à une grande option d'accord c'est à dire le fameux droit d'utiliser la commande GRANT, moi j'ai pas envie ici mais on aurait fait par exemple WITH.

	GRANT ALL 
	ON cours_sql.*
	TO 'jachampagne'@'localhost'
	WITH GRANT OPTION;

là par exemple with grant option, avec le droit d'utiliser les commandes pour changer les privilèges mais nous on veut un utilisateur avec des droits limités donc il fait tout ce qu'il veut sur sa base de données, c'est lui que ça regarde par contre il ne pourra pas créer d'autres bases de données, il ne pourra pas en supprimer et il pourra certainement pas accéder aux autres bases de données donc en faisant notre petite commande si j'ai pas fait d'erreur voilà il aura comme ça ses droits en particulier, il ne pourra pas normalement faire n'importe quoi.

	users.sql
	---------
	CREATE USER 'jachampagne'@'localhost' IDENTIFIED BY 'passe';
	ALTER USER 'jachampagne'@'localhost' IDENTIFIED BY 'new';
	RENAME USER 'jachampagne'@'localhost' TO 'jason'@'localhost';
	DROP USER 'jason'@'localhost';
	GRANT ALL ON cours_sql.* TO 'jachampagne'@'localhost';

	mysql> GRANT ALL
		-> ON cours_sql.*
		-> TO 'jachampagne'@'localhost';
	Query OK, 0 rows affected (0.01 sec)

Alors je vais voir que ça s'est bien appliqué et si c'est pas cas ça va être assez embêtant donc on va faire se reconnecter.

	mysql> exit
	Bye
	> mysql -u jachampagne -p

	mysql> show databases;
	+--------------------+
	| Database           |
	+--------------------+
	| cours_sql          |
	| information_schema |
	+--------------------+
	2 rows in set (0.00 sec)

Par contre vous voyez information_schema c'est un cas particulier en fait mysql vous le laisse par contre voyez que je n'ai même pas la possibilité de voir les autres bases.

Si j'essaye de faire, d'accéder à la base de données mysql ... eh bien je n'ai pas le droit d'accord.

	mysql> use mysql;
	ERROR 1044 (42000): Access denied for user 'jachampagne'@'localhost' to database 'mysql'

On vous met que l'accès est refusé pour cet utilisateur pour accéder à la base à la base de données mysql
donc on peut gérer véritablement tous les droits comme cela correctement, précisément en fonction de ce que l'on veux faire d'accord. 

	mysql> exit
	Bye
	> mysql -u root -p
	Enter password:

Ce sera à vous de gérer en faites ce que vous voulez en fonction.

Comme ça vous pouvez vraiment interagir sur les droits précis ou les privilèges précis pour l'utilisateur que vous voulez.

Si on veut retirer certains droits parce qu'on peut en retirer quelques uns, on peut tous les retirer. On ne va pas utiliser GRANT, on va utiliser REVOKE donc ça peut être REVOKE ALL.

	users.sql
	---------
	CREATE USER 'jachampagne'@'localhost' IDENTIFIED BY 'passe';
	ALTER USER 'jachampagne'@'localhost' IDENTIFIED BY 'new';
	RENAME USER 'jachampagne'@'localhost' TO 'jason'@'localhost';
	DROP USER 'jason'@'localhost';
	GRANT ALL ON cours_sql.* TO 'jachampagne'@'localhost';
	
>	REVOKE ALL

Ca peut être simplement par exemple je retire juste à jachampagne, je lui retire le droit CREATE TABLE càd qu'il pourra tout faire parce qu'il aura toujours le ALL sauf qu'on lui aura retiré ce droit là voyez qu'on peut comme ça modifier les privilèges un à un si on veut.

	REVOKE CREATE TABLE

On peut faire par exemple ceci, la même chose donc ON cours_sql, point, étoile. Et là c'est pas tout, c'est FROM de l'utilisateur voilà on retire les droits sur cours_sql.* de l'utilisateur un tel et dans ce cas là si je fais ça.

	users.sql
	---------
	CREATE USER 'jachampagne'@'localhost' IDENTIFIED BY 'passe';
	ALTER USER 'jachampagne'@'localhost' IDENTIFIED BY 'new';
	RENAME USER 'jachampagne'@'localhost' TO 'jason'@'localhost';
	DROP USER 'jason'@'localhost';
	
	GRANT ALL
	ON cours_sql.* 
	TO 'jachampagne'@'localhost';

	REVOKE ALL
	ON cours_sql.*
	FROM 'jachampagne'@'localhost';
	
	client
	------

	mysql> REVOKE ALL
		-> ON cours_sql.*
		-> FROM 'jachampagne'@'localhost';
	Query OK, 0 rows affected (0.01 sec)

Je quitte, je me reconnecte.

	mysql> exit
	Bye
	> mysql -u jachampagne -p
	Enter password: *****

J'essaie de me connecter et là, il ne va pas pouvoir faire grand chose puisque je lui un petit peu tout retiré.

	mysql> show databases;
	+--------------------+
	| Database           |
	+--------------------+
	| information_schema |
	+--------------------+
	1 row in set (0.00 sec)


Voyez là, il a même aucune base. Je ne peux même pas faire de create database du genre test.

	mysql> create database test;
	ERROR 1044 (42000): Access denied for user 'jachampagne'@'localhost' to database 'test'

Voyez il ne peut absolument rien faire, on peut même pas créer d'utilisateurs et si j'essaie de refaire ceci.

	mysql> CREATE USER 'toto'@'localhost' IDENTIFIED BY 'passe';
	ERROR 1227 (42000): Access denied; you need (at least one of) the CREATE USER privilege(s) for this operation

Voilà il ne peut pas créer un utilisateur, il ne peut vraiment rien faire d'ailleurs ça vous dit voilà il n'a pas le privilège CREATE USER puis je vous rappelle est ici.

+---------------------------+-----------------------------------------------------------------------+
| NOM PRIVILEGES			| AUTORISATION															|
+---------------------------+-----------------------------------------------------------------------+
| ALL / ALL PRIVILEGES		| Tous les droits (sauf GRANT)											|
| ALTER						| Droit de modifier une table											|
| ALTER ROUTINE				| Droit de modifier/supprimer une procédure ou fonction stockée			|
| CREATE TABLE				| Droit de créer une table												|
| CREATE TEMPORARY TABLE	| Droit de créer temporairement une table								|
| CREATE ROUTINE			| Droit de créer des procédures et fonctions stockées					|
| CREATE USER				| Droit de gérer les utilisateurs (création/modification/suppression)	|
| CREATE VIEW				| Droit de créerdes vues												|
| DROP						| Droit de supprimer des bases de données, tables et vues				|
| EXECUTE					| Droit d'éxécuter des procédures et fonctions stockées					|
| GRANT OPTION				| Droit d'utiliser la commande GRANT									|
| INDEX						| Droit de créer et supprimer des index									|
| LOCK TABLES				| Droit de vérouiller des tables										|
| TRIGGER					| Droit de créer et supprimer des "triggers"							|
| USAGE						| Aucun droit															|
+---------------------------+-----------------------------------------------------------------------+

CREATE USER, ça fait partie des noms de privilège donc ça c'est ce qu'on a noté avec la petite description pour dire à quoi ça correspond donc vraiment vous pouvez comme ça affiner les privilèges donc les droits sql de vos utilisateurs est avoir comme ça une gestion complète et en tout cas minimum sur de ce qui est fait là.

Voilà j'espère que ça en tout cas que ça vous aura servi c'est quelque chose de très important souvent il y a des gens quand ils apprennent sql ils oublient cette gestion des utilisateurs parce que la plupart du temps sur certains logiciels s'est fait de manière automatique ou alors quand vous utilisez un hébergeur en ligne comme je disais tout à l'heure on vous fournit déjà un utilisateur avec un mot de passe donc les gens ont l'impression que tout fonctionne de manière automatique mais non parce que l'hébergeur vous a justement lui créer un utilisateur avec un mot de passe précis et cetera et vous a donné des infos et à gérer vos droits très précisément càd que c'est lui qui choisit qu'est ce qui vous autorise de faire et qu'est ce qui ne vous autorise pas mais là c'est vous qui êtes l'administrateur d'accord du système de gestion de base de données donc c'est vous qui pouvez gérer les droits de chacun des utilisateurs.

J'espère que cette vidéo vous a plu, si a besoin de question ou de précisions encore  une fois parce que j'étais assez rapide sur les explications mais on a fait le tour de tout, je n'ai rien oublié mais n'hésitez pas à le demander dans les commentaires et comme ça voilà vous serrez un petit peu comment mettre tout ça en place.

là maintenant on va pouvoir commencer vraiment à entrer un peu plus dans la pratique, on va commencer à faire vraiment des requêtes pour travailler sur des données donc je vais vous fournir par la suite une base de données avec un ensemble de table et plein d'enregistrement déjà déjà mis dedans d'accord on aura plein d'infos et comme ça vous aurez tous la même base sur laquelle travailler et pour les exercices je vous donnerai une autre table parce que je vous ferai une autre base de données en fait pour les exos histoire de ne pas faire la même comme ça sur le cours vous travaillez avec  certaines données et pour les exercices qui aura dans une playlist sql exercices, vous aurez d'autres données en fait et du coup vous pourrez faire pas mal de requêtes, des statistiques voilà des groupements d'information tout ça tout ça.

J'espère que ça vous plaira en tout cas, je vous dis à bientôt pour la prochaine vidéo en sql, en attendant entraînez vos biens et encore une fois si il y a des questions n'hésitez pas dans les commentaires, like, partage, vous savez comment ça marche donc n'hésitez pas à partager un petit peu autour de vous je pense que ça servira à beaucoup de monde.

Ciao tout le monde
*/