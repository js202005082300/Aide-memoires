# [16. Sous-requêtes](https://www.youtube.com/watch?v=n2y6DZAM_fM)
03-01-21

[data6.sql](data6.sql)

Bonjour à tous c'est la séance 16 en sql, nous allons aborder ensemble les sous-requêtes qui est un principe en fait de requête imbriquées qui va grandement faciliter les choses et qui est une notion très importante en base de données qui vous servira énormément énormément par la suite lorsque vous serez amenés à manipuler des bases de données plus tard de manière plus concrète.

On va regarder tout ça ensemble c'est important d'avoir toute l'informationc, comme d'habitude dans la description de la vidéo vous avez un lien vers un fichier sql que vous pouvez récupérer le contenu pour pouvoir importer pas mal d'informations et ça diffère un peu des séances précédentes.
	
Pour vous faire rapidement à une explication nous avons une première table qui représente des joueurs avec un nom d'utilisateur, un niveau, une classe. Pour changer un petit peu j'ai mis une contrainte UNIQUE sur player_name pour dire que c'est une information qui doit être absolument unique pour chaque joueur et pas avoir des valeurs en double d'accord des doublons.

On a une deuxième table qui représente des échanges entre joueurs quelque chose, un système très simplifiée, le but n'était pas de compliquer ce que je vais vous montrer dans cette vidéo donc très simplement on a une personne qui propose un objet playertrade_buyer, une personne qui l'achète playertrade_seller même s'il n'y a pas vraiment de questions d'argent dans la table mais peu importe, l'objet en question de l'échange playertrade_item et la date de la transaction playertrade_date et puis tout simplement un identifiants id_playertrade donc ça pas de changement.

Quelques enregistrements bien sûr derrière, des joueurs et des transactions qui sont prises en compte.

Et vous voyez pour la date d'ailleurs petit détail j'ai mis un datetime à la place histoire qu'on ait également l'heure précise de la transaction ce qui change un peu notamment avec la présente séance.

Voilà pour ces informations déjà donc ce fichier vous le récupérer comme d'habitude pour pouvoir l'importer ensuite comme je vais le faire donc on fait ça.

+ notes.sql
```sql
	SOURCE C:/SQL/cours/016_Sous-requetes/data6.sql
```
Le chemin moi je l'ai préparer ici encore une fois, hop ok ok.

On vérifie que tout est bon c'est important toujours pour être sûr qu'on a bien les structures comme il faut et ensuite les données, UNIQUE est bien prit en compte.
```sql
	mysql> use fv_database;
	Database changed
	mysql> show tables;
	+-----------------------+
	| Tables_in_fv_database |
	+-----------------------+
	| fv_players            |
	| fv_playertrades       |
	+-----------------------+
	2 rows in set (0.02 sec)

	mysql> describe fv_players;
	+--------------+-------------+------+-----+---------+----------------+
	| Field        | Type        | Null | Key | Default | Extra          |
	+--------------+-------------+------+-----+---------+----------------+
	| id_player    | int         | NO   | PRI | NULL    | auto_increment |
	| player_name  | varchar(65) | NO   | UNI | NULL    |                |
	| player_level | int         | NO   |     | NULL    |                |
	| player_class | varchar(30) | NO   |     | NULL    |                |
	+--------------+-------------+------+-----+---------+----------------+
	4 rows in set (0.01 sec)

	mysql> describe fv_playertrades;
	+--------------------+-------------+------+-----+---------+----------------+
	| Field              | Type        | Null | Key | Default | Extra          |
	+--------------------+-------------+------+-----+---------+----------------+
	| id_playertrade     | int         | NO   | PRI | NULL    | auto_increment |
	| playertrade_seller | varchar(65) | NO   |     | NULL    |                |
	| playertrade_buyer  | varchar(65) | NO   |     | NULL    |                |
	| playertrade_item   | varchar(65) | NO   |     | NULL    |                |
	| playertrade_date   | datetime    | NO   |     | NULL    |                |
	+--------------------+-------------+------+-----+---------+----------------+
	5 rows in set (0.00 sec)
```
UNIQUE est bien prit en compte et ensuite un petit select * pour chacun.
```sql
mysql> select * from fv_players;
+-----------+-------------+--------------+--------------+
| id_player | player_name | player_level | player_class |
+-----------+-------------+--------------+--------------+
|         1 | BigBoss_89  |           15 | Guerrier     |
|         2 | Sephiroth   |           37 | Mage noir    |
|         3 | Nephion     |           23 | Barde        |
|         4 | Cladjuju    |            1 | Archer       |
|         5 | Haryko      |            1 | Voleur       |
|         6 | Greg_war    |           16 | Mage noir    |
|         7 | Icekissy    |           50 | Mage blanc   |
+-----------+-------------+--------------+--------------+
7 rows in set (0.00 sec)

mysql> select * from fv_playertrades;
+----------------+--------------------+-------------------+-----------------------------+---------------------+
| id_playertrade | playertrade_seller | playertrade_buyer | playertrade_item            | playertrade_date    |
+----------------+--------------------+-------------------+-----------------------------+---------------------+
|              1 | Sephiroth          | BigBoss_89        | Épée en mousse              | 2020-01-17 14:37:23 |
|              2 | Icekissy           | Greg_war          | Anneau rouillé              | 2020-01-17 15:10:01 |
|              3 | Greg_war           | BigBoss_89        | Cape de héros Niv. 13       | 2020-01-17 18:43:18 |
|              4 | Haryko             | Cladjuju          | Arc en bois                 | 2020-01-18 02:08:17 |
|              5 | BigBoss_89         | Sephiroth         | Épée en mousse              | 2020-01-19 00:00:36 |
|              6 | BigBoss_89         | Sephiroth         | Grimoire de sorts Niv. 30   | 2020-01-19 00:15:43 |
|              7 | Sephiroth          | Icekissy          | Sacoche 20 emplacements     | 2020-01-20 09:24:54 |
|              8 | Icekissy           | Haryko            | Extrait de rubis            | 2020-01-23 12:28:00 |
|              9 | Icekissy           | Sephiroth         | Sceptre des anciens Niv. 40 | 2020-01-24 10:10:10 |
|             10 | Greg_war           | Haryko            | Potion de furtivité         | 2020-01-24 10:10:26 |
|             11 | Greg_war           | Haryko            | Mitaines en cuir Niv. 4     | 2020-01-26 19:44:27 |
|             12 | Sephiroth          | Icekissy          | Enclos à bétail             | 2020-01-27 21:33:03 |
+----------------+--------------------+-------------------+-----------------------------+---------------------+
12 rows in set (0.00 sec)
```
Ca a l'air bon c'était 12 c'est bon.

Une fois que nous avons ça on va pouvoir commencer à voir ensemble comment fonctionne justement ce principe un petit peu de sous-requêtes alors ça je vais le laisser notes.sql voilà ouvert parce que si jamais j'ai besoin de vous montrer des trucs c'est bien de garder le fichier sql sous la main et on va voir tout ça ensemble.

Alors le principe de la requête imbriquée en réalité va faire appel à deux requêtes alors on n'est pas dans le union comme on l'a vu précédemment, une intersection, etc mais véritablement en une requête dont on va se servir du résultat ensuite dont la clause d'une seconde requête.

Au niveau syntaxe c'est très simple par exemple je peux dire récupère toutes les informations éventuellement d'un joueur d'accord dont le player_name, dont le nom d'utilisateur existe donc est égal à quelque chose et ce quelque chose c'est une requête que nous allons imbriquer d'accord cc'est une sous-requête ici.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name =
	(
	
	);
```
En gros on va effectuer une requête là, là qui va devoir retourner un seul résultat très important vous verez qu'il y a un cas un peu particulier après dans lequel nous aurions plusieurs colonnes de retourner mais on verra ça juste après donc là il faut qu'une seule colonne à retourner c'est à dire un seul player_name obligatoirement.

Alors soit vous êtes assurés qu'il n'y a qu'une seule valeur qui va être retournée dans ce cas là pas de problème sinon vous faites un fameux LIMIT 1 comme on a déjà vu dans bien
d'autres vidéos pour pouvoir récupérer qu'un seul résultat.

Le truc c'est simplement de se dire on veut être sûr voilà qui a au moins un enregistrement donc on n'aura pas besoin d'avoir plus d'informations, qu'est-ce que veux faire cette requête ? c'est de te dire, je veux voir en fait si tel utilisateur on va voir lequel, on verra par la suite bah on ne va pas aller trop vite on va faire SELECT playertrade_seller, on cherche un vendeur de la table fv_playertrades dont le nom d'utilisateur finalement playertrade_seller, le pseudonyme utilisé dans le jeu correspond à quelque chose ''.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name =
	(
		SELECT playertrade_seller
		FROM fv_playertrades
		WHERE playertrade_seller = ''
	);
```
Par exemple on peut dire bah tiens est-ce que Icekissy fait partie de certains vendeurs, dans cette table est-ce qu'il est enregistré en tant que vendeur.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name =
	(
		SELECT playertrade_seller
		FROM fv_playertrades
		WHERE playertrade_seller = 'Icekissy'
	);
```
En résumé est-ce que Icekissy a déjà vendu des objets à un autre joueur.

Voyez ça peut être tout à fait utilisable dans un jeu vidéo, ça va être une information qu'on aurait tout à fait besoin d'avoir, de se dire que pour tel joueur je vais vérifier les transactions qu'il a pu effectuer avec d'autres joueurs en l'occurrence ici des ventes. Est-ce que ce joueur a effectué des ventes et si oui donc si on retourne une information ici alors je veux afficher toutes les informations de ce joueur parce que j'en ai besoin pour vérifier quelque chose.

Ici on n'oublie pas un LIMIT 1 parce que si jamais il y en a plus et là comme je sais évidemment ce que j'ai mis là je sais qu'il y en a plus que 1 donc on va retourner plus d'une colonne donc je me limite à 1.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name =
	(
		SELECT playertrade_seller
		FROM fv_playertrades
		WHERE playertrade_seller = 'Icekissy'
		LIMIT 1
	);
```
Automatiquement si cette requête retourne un résultats donc elle valide ici l'égalité vous aurez toutes les informations affichées là.

Vous comprenez un peu le principe ça fonctionne à l'envers d'accord la requête qui est imbriquée d'abord c'est elle qui est fait et en fonction de ça elle valide une clause d'accord et permet de sélectionner des informations selon cette clause alors ça s'utilise soit avec un WHERE soit avec un HAVING d'accord. C'est deux systèmes en fait pour avoir une clause comme ça pour filtrer au grouper, enfin filtrer des résultats groupe et qu'on peut utiliser l'un ou l'autre donc évidemment ça fonctionnera avec un having aussi.

Alors on va garder cette information et on va voir voilà directement en direct est-ce que cette personne, ce joueur a vendu des objets sur le jeu, on fait ça et on a toute l'information qui s'affiche donc cet utilisateur a vendu quelque chose.
```sql
	mysql> SELECT * FROM fv_players
		-> WHERE player_name =
		-> (
		-> SELECT playertrade_seller
		-> FROM fv_playertrades
		-> WHERE playertrade_seller = 'Icekissy'
		-> LIMIT 1
		-> );
	+-----------+-------------+--------------+--------------+
	| id_player | player_name | player_level | player_class |
	+-----------+-------------+--------------+--------------+
	|         7 | Icekissy    |           50 | Mage blanc   |
	+-----------+-------------+--------------+--------------+
	1 row in set (0.00 sec)
```
Normalement j'ai mis un exemple de quelqu'un qui avait absolument rien vendu, Nephion il est même pas dans la table 2 parce qu'il n'a jamais rien vendu, jamais rien acheter encore sur le jeu donc on va voir avec cette personne là par exemple donc on change le nom.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name =
	(
		SELECT playertrade_seller
		FROM fv_playertrades
		WHERE playertrade_seller = 'Nephion'
		LIMIT 1
	);
	
	mysql> SELECT * FROM fv_players
		-> WHERE player_name =
		-> (
		-> SELECT playertrade_seller
		-> FROM fv_playertrades
		-> WHERE playertrade_seller = 'Nephion'
		-> LIMIT 1
		-> );
	Empty set (0.00 sec)
```
Empty set, tout simplement aucun résultat à retournez donc en gros on sait par cette requête que nous avons fait cette sous-requête même plus exactement ici que cet utilisateur n'a jamais vendu d'objets sur le jeu, il ne fait pas partie de la table en fait qui a enregistré tous les échanges entre joueurs très simple voilà un moyen de faire cette sous-requête là avec cette syntaxe là.

Une clause where ou having d'accord, un opérateur = et évidemment n'importe quel opérateur pourrait servir inférieur à, supérieur à, etc, tous les opérateurs que vous avez pu voir et ensuite entre parenthèses la deuxième requête qui est en fait donc là sous requête imbriquée donc voici un petit peu la syntaxe que l'on utilise.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name =
	(
		SELECT playertrade_seller
		FROM fv_playertrades
		WHERE playertrade_seller = 'Nephion'
		LIMIT 1
	);
```
Admettons qui puisse y avoir plusieurs colonnes renvoyer c'est à dire voyez qu'on travaille toujours une colonne par colonne normal puisqu'on a une clause where donc on fait toujours sur un champ bien précis.

Si on se dit que peut-être que si on enlève le LIMIT ici.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name =
	(
		SELECT playertrade_seller
		FROM fv_playertrades
		WHERE playertrade_seller = 'Icekissy'
	);
```
Il pourrait y avoir plusieurs retours d'ailleurs on le voit ici, on va remettre notre ami Icekissy ici qui lui a vendu plus d'un objet finalement et si je fais juste ça naturellement ça ne va pas aller.
```sql
	mysql> SELECT * FROM fv_players
		-> WHERE player_name =
		-> (
		-> SELECT playertrade_seller
		-> FROM fv_playertrades
		-> WHERE playertrade_seller = 'Icekissy'
		-> );
	ERROR 1242 (21000): Subquery returns more than 1 row
```
On vous met Subquery donc la requête retourne plus d'une ligne donc elle retourne en fait plus d'un résultat et ça ne va pas parce qu'on ne peut pas comparer plusieurs résultats avec une seule valeur, ça va pas du tout on veut comparer valeur par valeur et pas une valeur avec plusieurs ça n'a aucun sens.

Pour cela vous remplacer tout simplement ... c'est quelque chose qu'on a déjà vu ... votre opérateur d'égalité, d'inégalités par le IN d'accord c'est la commande qu'on peut utiliser pour ça.

+ notes.sql
```sql
	SELECT * FROM fv_players
>	WHERE player_name IN
	(
		SELECT playertrade_seller
		FROM fv_playertrades
		WHERE playertrade_seller = 'Icekissy'
	);
```
Et là si je relance pas de problème on retrouve le résultat de tout à l'heure.
```sql
	mysql> SELECT * FROM fv_players
		-> WHERE player_name IN
		-> (
		-> SELECT playertrade_seller
		-> FROM fv_playertrades
		-> WHERE playertrade_seller = 'Icekissy'
		-> );
	+-----------+-------------+--------------+--------------+
	| id_player | player_name | player_level | player_class |
	+-----------+-------------+--------------+--------------+
	|         7 | Icekissy    |           50 | Mage blanc   |
	+-----------+-------------+--------------+--------------+
	1 row in set (0.00 sec)
```
Voilà si l'on en trouve au moins ça valide la sous-requête donc on affiche les informations du joueur en question on peut faire comme ça.

Après on peut s'amuser à faire aussi éventuellement ceci.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name IN
	(
		SELECT playertrade_seller
		FROM fv_playertrades
	);

	mysql> SELECT * FROM fv_players
		-> WHERE player_name IN
		-> (
		-> SELECT playertrade_seller
		-> FROM fv_playertrades
		-> );
	+-----------+-------------+--------------+--------------+
	| id_player | player_name | player_level | player_class |
	+-----------+-------------+--------------+--------------+
	|         1 | BigBoss_89  |           15 | Guerrier     |
	|         2 | Sephiroth   |           37 | Mage noir    |
	|         5 | Haryko      |            1 | Voleur       |
	|         6 | Greg_war    |           16 | Mage noir    |
	|         7 | Icekissy    |           50 | Mage blanc   |
	+-----------+-------------+--------------+--------------+
	5 rows in set (0.00 sec)
```
Est ce que ce sera assez parlant par rapport à ce que j'ai enregistré ? oui très bien en dessous j'avais prévu quand même pour que ce soit assez parlant.

Voilà là via cette requête ici d'accord en faisant juste un select from et cetera grâce au IN d'accord j'ai récupéré plusieurs enregistrements que j'ai comparé un à un et du coup qu'est ce qu'il fait ? bien il affiche les informations des joueurs qui ont vendu des objets voilà donc là on voit qu'on a la liste du coup de tous les vendeurs qu'il a eu pour le moment donc vous pourrez vérifier vous même par le fichier ... je peux pas tout vérifier un par un mais en gros voilà donc on retrouve naturellement pas un Nephion ici parce que si je sélectionne on le retrouve pas ailleurs.

Icekissy est vendeur, il a même été acheteur. Si on regarde Haryko on voit pareil il est acheteur et vendeur voilà. Il y en a qu'on retrouve à plusieurs endroits et d'autres non.

Justement j'ai prit ce cas là Nephion parce qu'il n'a fait aucun échange ni achat ni vente.

Voilà donc il n'est pas présent donc évidemment on ne l'a pas retrouvé ici dans la liste qui est retourné donc ça c'est très pratique on peut véritablement récupérer pas mal de résultats.

C'est la fameuse sous-requête de base avec l'utilisation d'opérateur ou même d'un mot clé comme le IN par exemple dans une clause where ou having. On peut simplement procéder de cette manière et c'est très simple et le concept en lui même est pas compliqué. Il n'y a rien de compliqué dans cette notion mais il faut bien utiliser pour pas se retrouver avec des résultats un peu bizarre donc attention entre la distinction entre l'utilisation d'opérateurs et le fameux IN qui lui permet de récupérer plusieurs enregistremennt de la requête imbriquée, ça c'est important.

Autre possibilité, j'espère que normalement j'ai suffisamment d'exemples parce que j'en ai quand même mit pas mal donc ça devrait aller.

Au niveau de ces sous-requêtes on peut également procéder à un autre système en gros par rapport à ce qu'on a mis, where d'accord quand on utilise égal, =.

On va utiliser un autre système qui va valider en fait ces informations si la sous-requête ici à au moins une valeur càd que si ça correspond avec l'égalité parce que si ça correspond à au moins un enregistrement de ce qu'on a là d'accord.

Pour ça c'est évidemment beaucoup plus simple à comprendre avec un exemple et vous mettez le mot ANY() là.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name = ANY
	(
		SELECT playertrade_seller
		FROM fv_playertrades
	);
```
En gros on lui dit voilà si on trouve ANY au moins une personne d'accord càd on a au moins une égalité ici avec une valeur de cette sous-requête, si on exécute.
```sql
	mysql> SELECT * FROM fv_players
		-> WHERE player_name = ANY
		-> (
		-> SELECT playertrade_seller
		-> FROM fv_playertrades
		-> );
	+-----------+-------------+--------------+--------------+
	| id_player | player_name | player_level | player_class |
	+-----------+-------------+--------------+--------------+
	|         1 | BigBoss_89  |           15 | Guerrier     |
	|         2 | Sephiroth   |           37 | Mage noir    |
	|         5 | Haryko      |            1 | Voleur       |
	|         6 | Greg_war    |           16 | Mage noir    |
	|         7 | Icekissy    |           50 | Mage blanc   |
	+-----------+-------------+--------------+--------------+
	5 rows in set (0.00 sec)
```
Voilà on retrouve comme vous voyez ici alors on a la même chose comme on est censé avoir les mêmes résultats voilà.
```sql
	mysql> SELECT * FROM fv_players
		-> WHERE player_name IN
		-> (
		-> SELECT playertrade_seller
		-> FROM fv_playertrades
		-> );
	+-----------+-------------+--------------+--------------+
	| id_player | player_name | player_level | player_class |
	+-----------+-------------+--------------+--------------+
	|         1 | BigBoss_89  |           15 | Guerrier     |
	|         2 | Sephiroth   |           37 | Mage noir    |
	|         5 | Haryko      |            1 | Voleur       |
	|         6 | Greg_war    |           16 | Mage noir    |
	|         7 | Icekissy    |           50 | Mage blanc   |
	+-----------+-------------+--------------+--------------+
	5 rows in set (0.00 sec)
```
On a la même chose d'accord il validera en fait s'il y a au moins un cas comme on a plusieurs utilisateurs qui correspondent forcément on retrouvera plusieurs résultats.

On peut éventuellement remettre un where comme j'avais fait, on peut éventuelement dire est-ce que quelqu'un a vendu par exemple des Épée en mousse ?, qui ont fait transaction d'une Épée en mousse ? vous voyez ça des gens se sont fait avoir, on leur a vendu éventuellement des Épée en mousse donc on peut faire un test là-dessus avec playertrade_item = 'Épée en mousse'.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name = ANY
	(
		SELECT playertrade_seller
		FROM fv_playertrades
		WHERE playertrade_item = 'Épée en mousse'
	);

	mysql> SELECT * FROM fv_players
		-> WHERE player_name = ANY
		-> (
		-> SELECT playertrade_seller
		-> FROM fv_playertrades
		-> WHERE playertrade_item = 'Épée en mousse'
		-> );
	+-----------+-------------+--------------+--------------+
	| id_player | player_name | player_level | player_class |
	+-----------+-------------+--------------+--------------+
	|         2 | Sephiroth   |           37 | Mage noir    |
	|         1 | BigBoss_89  |           15 | Guerrier     |
	+-----------+-------------+--------------+--------------+
	2 rows in set (0.00 sec)
```
Voilà on fait ça et voilà on voit du coup que Sephiroth et BigBoss_89, Mage noir et guerrier respectivement, ont vendu à un moment donné des épées en mousse à quelqu'un.

Effectivement si on vérifie que Sephiroth a bien vendu une épée en mousse et big boss à un moment donnée la renvoyer du coup apparemment à Sephiroth. Voilà il lui a redonné son Épée en mousse dont il a redonné deux jours plus tard mais il en voulait plus donc il lui dit tu récupères ton armes en mousse, j'en veux pas donc on peut comme ça récupérer directement d'autres résultats.

Vous avez un alias aussi de ANY qui est SOME, on peut faire cette commande c'est un alias.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name = SOME
	(
		SELECT playertrade_seller
		FROM fv_playertrades
		WHERE playertrade_item = 'Épée en mousse'
	);
```
SOME c'est exactement le même mot clé d'accord ça fonctionne tout à fait pareil vous avez l'une ou l'autre des syntaxes possibles, ça c'était du coup la deuxième possibilité d'accord de faire un ANY pour vérifier au moins une valeur d'accord au moins que ça corresponde en fait cette clause where que vous avez là, corresponde à au moins une valeur de votre sous-requête. C'est comme ça que ça fonctionne.

Troisième et dernière possibilité par rapport à ces sous-requêtes, c'est de vérifier en réalité l'existence d'accords de l'information que vous avez par exemple est-ce que ma sous-requête renvoie un résultat ?

Càd que si la requête renvoie un résultat, à ce moment là on va pouvoir traiter la sous-requête.

Comme vous voyer c'est des cas c'est des petites particularités finalement à travers la syntaxe mais qui ont quand même leur importance alors ce qu'on va faire par exemple c'est de déjà tester avec EXISTS.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name = EXISTS
	(
		SELECT playertrade_seller
		FROM fv_playertrades
		WHERE playertrade_item = 'Épée en mousse'
	);

	mysql> SELECT * FROM fv_players
		-> WHERE player_name = EXISTS
		-> (
		-> SELECT playertrade_seller
		-> FROM fv_playertrades
		-> WHERE playertrade_item = 'Épée en mousse'
		-> );
	Empty set, 7 warnings (0.00 sec)
```
Donc là évidemment, il me met Empty.

On a une première requête imbriquée, ensuite on va sélectionner tous les vendeurs SELECT playertrade_seller d'ailleurs j'aurais pu mettre toutes les infos * en fait.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE player_name = EXISTS
	(
		SELECT *
		FROM fv_playertrades
		WHERE playertrade_item = 'Épée en mousse'
	);
```
Imaginez que cette sous-requête est toute seule et isolé d'accord.
```sql
		SELECT *
		FROM fv_playertrades
		WHERE playertrade_item = 'Épée en mousse';
```	
Je récupère toutes les informations de la table des échanges, fv_playertrades, dans le cas où l'objet en question de la transaction est une épée en mousse d'accord. Si ce type de requête si vous l'avez fait toute seule càd que je peux même la récupérer toute seule.
```sql
mysql> SELECT *
    -> FROM fv_playertrades
    -> WHERE playertrade_item = 'Épée en mousse';
+----------------+--------------------+-------------------+------------------+---------------------+
| id_playertrade | playertrade_seller | playertrade_buyer | playertrade_item | playertrade_date    |
+----------------+--------------------+-------------------+------------------+---------------------+
|              1 | Sephiroth          | BigBoss_89        | Épée en mousse   | 2020-01-17 14:37:23 |
|              5 | BigBoss_89         | Sephiroth         | Épée en mousse   | 2020-01-19 00:00:36 |
+----------------+--------------------+-------------------+------------------+---------------------+
2 rows in set (0.00 sec)
```
voilà là il retourne des résultats on retrouve les deux résultats de tout à l'heure donc ça correspond.

Dans ce cas là cette requête a des résultats qui existent donc on valide cette clause d'accord, where existe donc la sous-requête vaut true.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE EXISTS
	(
		SELECT *
		FROM fv_playertrades
		WHERE playertrade_item = 'Épée en mousse'
	);
```
C'est vrai donc dans ce cas là on sélectionne tout les joueurs.

Si je fais cette requête comme ça, on obtient ceci.
```sql
	mysql> SELECT * FROM fv_players
		-> WHERE EXISTS
		-> (
		-> SELECT *
		-> FROM fv_playertrades
		-> WHERE playertrade_item = 'Épée en mousse'
		-> );
	+-----------+-------------+--------------+--------------+
	| id_player | player_name | player_level | player_class |
	+-----------+-------------+--------------+--------------+
	|         1 | BigBoss_89  |           15 | Guerrier     |
	|         2 | Sephiroth   |           37 | Mage noir    |
	|         3 | Nephion     |           23 | Barde        |
	|         4 | Cladjuju    |            1 | Archer       |
	|         5 | Haryko      |            1 | Voleur       |
	|         6 | Greg_war    |           16 | Mage noir    |
	|         7 | Icekissy    |           50 | Mage blanc   |
	+-----------+-------------+--------------+--------------+
	7 rows in set (0.00 sec)
```
Et là vous allez dire ça a changé au niveau des résultats, c'est normal pour ça que je vous dis attention si vous vous doutez bien qu'il y a plusieurs mots clés, les syntaxes ne font pas toutes la même chose sinon bah ça servirait à rien d'avoir autant de mots clés différent si ça produit exactement le même résultat.

Je répète ce que j'avais dit, on a une première requête si elle valide des résultats, si elle retourne des résultats donc elle existe, on considère qu'elle existe en fait pour la clause where et à ce moment là on fait cette requête là, SELECT * FROM fv_players.

En gros c'est une simple condition imaginer que ça c'est la condition :
```sql
	WHERE EXISTS
	(
		SELECT *
		FROM fv_playertrades
		WHERE playertrade_item = 'Épée en mousse'
	);
```
Et la requête que vous avez avant le where sera fait si et seulement si cette requête a retourné quelque chose, il faut juste le comprendre comme ça tout simplement et cette requête c'est quoi, hé bien c'est juste ça en fait.
```sql
	SELECT * FROM fv_players
```
Voyez là on n'a pas de filtres qui ont été appliqués, on a dit de retourner tout le monde, tous les joueurs donc évidemment je retrouve tous les joueurs sur le jeu d'accord toute la liste qu'il y a là.

Après bon on pourrait bien sûr s'amuser à faire un AND.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE EXISTS
	(
		SELECT *
		FROM fv_playertrades
		WHERE playertrade_item = 'Épée en mousse'
	) AND player_level > 10;

	mysql> SELECT * FROM fv_players
		-> WHERE EXISTS
		-> (
		-> SELECT *
		-> FROM fv_playertrades
		-> WHERE playertrade_item = 'Épée en mousse'
		-> ) AND player_level > 10;
	+-----------+-------------+--------------+--------------+
	| id_player | player_name | player_level | player_class |
	+-----------+-------------+--------------+--------------+
	|         1 | BigBoss_89  |           15 | Guerrier     |
	|         2 | Sephiroth   |           37 | Mage noir    |
	|         3 | Nephion     |           23 | Barde        |
	|         6 | Greg_war    |           16 | Mage noir    |
	|         7 | Icekissy    |           50 | Mage blanc   |
	+-----------+-------------+--------------+--------------+
	5 rows in set (0.00 sec)
```
On fait ça, ok et on peut même aller plus loin.

Plutôt à la ligne pour que ce soit plus lisible.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE EXISTS
	(
		SELECT *
		FROM fv_playertrades
		WHERE playertrade_item = 'Épée en mousse'
	) AND player_level > 10
	ORDER BY player_level ASC;
```
On va préciser ASC même si c'est ascendant installé par défaut donc là en gros tu lui dit tu sélectionnes tous les joueurs dont le niveau est supérieur à 10 si et seulement si on a trouvé des gens qui vendaient des Épée en mousse.

Evidemment dans un cas réel ça n'a absolument aucun intérêt de faire ce genre de requêtes mais voilà c'est tout à fait un exemple qui illustre bien ce que je voulais vous montrer.

On fait ça et à partir du moment où on a trouvé des gens qui avaient vendu des Épée en mousse on décide d'afficher tous les joueurs qui ont dépassé le niveau 10 et on trié tout ça par ordre croissant des niveaux ce qui est bien le cas 15, 16, 23, 37 et 50.
```sql
	mysql> SELECT * FROM fv_players
		-> WHERE EXISTS
		-> (
		-> SELECT *
		-> FROM fv_playertrades
		-> WHERE playertrade_item = 'Épée en mousse'
		-> ) AND player_level > 10
		-> ORDER BY player_level ASC;
	+-----------+-------------+--------------+--------------+
	| id_player | player_name | player_level | player_class |
	+-----------+-------------+--------------+--------------+
	|         1 | BigBoss_89  |           15 | Guerrier     |
	|         6 | Greg_war    |           16 | Mage noir    |
	|         3 | Nephion     |           23 | Barde        |
	|         2 | Sephiroth   |           37 | Mage noir    |
	|         7 | Icekissy    |           50 | Mage blanc   |
	+-----------+-------------+--------------+--------------+
	5 rows in set (0.00 sec)
```
Voilà c'était tout simplement ce type d'exemple d'usage d'accord de ce mot-clé EXISTS.

Vous voyez c'est vraiment un autre cas, c'est vraiment pour dire en fait tu fais ta requête à condition que la sous-requête soit valide et donc qu'elle ait retournée quelque chose.

Si ça ne retourne rien, on peut imaginer une épée en bois, normalement je n'avais pas d'épée en bois dans les informations que j'ai importé et bien Empty set donc en gros rien est retourné tout simplement.

+ notes.sql
```sql
	SELECT * FROM fv_players
	WHERE EXISTS
	(
		SELECT *
		FROM fv_playertrades
		WHERE playertrade_item = 'Épée en bois'
	) AND player_level > 10
	ORDER BY player_level ASC;

	mysql> SELECT * FROM fv_players
		-> WHERE EXISTS
		-> (
		-> SELECT *
		-> FROM fv_playertrades
		-> WHERE playertrade_item = 'Épée en bois'
		-> ) AND player_level > 10
		-> ORDER BY player_level ASC;
	Empty set (0.00 sec)
```
Empty set donc rien n'est retourné.

Voilà vous avez une petite démonstration des 3 solutions possibles pour effectuer les sous-requête encore une fois soit vous avez pour récapituler sur cette vidéo la fameuse sous-requête très simple juste via l'opérateur (=,...) vous écrivez directement votre requête et vous pouvez la valider par rapport une clause WHERE d'accord avec à une égalité, une inégalité ou le IN qui permet éventuellement de récupérer plusieurs colonnes quand une sous-requête retourne plusieurs résultats. Vous avez le ANY ou SOME ou votre votre on va dire égalité inégalités vaut en fait pour au moins une valeur de la sous-requête et vous avez simplement le EXISTS qui va simplement réalisé une requête sous la condition que la sous-requête a retourné quelque chose.

J'ai résumé en gros ce que je vous ai dit là, détailler au cours de cette séance et je pense qu'on va s'arrêter là parce que c'est suffisant par rapport ce que je voulais vous montrer.

C'est encore une fois comme je vous ai dit dans le principe c'est très simple après en pratique vous allez véritable avoir besoin de vous entraîner un minimum, c'est pour ça que je vous ai fait pour le coup voyez ces fichiers à chaque séance justement pour vous puissiez les réutiliser par vous même, vous en servir pour vous entraîner. Ce n'est pas fait juste pour les vidéos c'est aussi et c'est disponible justement pour vous pour que vous puissiez les récupérer et j'ai fait des fichiers un peu différent aussi pour vous exercer pour faire plein de tests de votre côté et comprendre avec ce que vous apprenez au fur et à mesure de cette formation c'est ça le plus important.

En tout cas je vais pouvoir vous laisse avec cette partie là et j'espère que c'était suffisamment clair parce que c'est pas encore évident, c'est pas pour le coup très simple à expliquer ce principe de sous-requête parce qu'encore une fois c'est très très simple avec les exemples tout ça mais l'expliquer ce n'est pas forcément si évident que ça.

N'hésitez pas encore une fois en cas de besoin, si vous avez besoin d'aide pour  quoi que ce soit ou bloqués sur une requête en particulier ou voudriez récupérer des résultats.

N'hésitez pas à vous servir des fichiers que je vous que je vous partage pour pouvoir justement vous exercez d'autant qu'il y a pas mal d'informations de toute façon.

Vous pouvez faire des requêtes bien filtrés par exemple tiens voilà les personnes par exemple qui ont fait des transactions à partir de telle date ou entre telle date et telle date.

Vous avez maintenant à ce stade en tout cas de la formation mine de rien appris beaucoup beaucoup de choses, on n'a plus beaucoup de notions à voir avant la fin de ce cours donc vous avez vu le plus gros en fait de ce qu'ils avaient à vous montrer. Vous avez moyen déjà de faire pas mal pas mal de choses avec plein de fichiers qui sont déjà prêts à l'usage pour vous exercer donc n'hésitez pas à vous en servir.

Moi je vous retrouve prochainement on abordera les jointures, on va y arriver. Il y a des gens qui attendent ça. Vous êtes quand même certains aussi a déjà connaître sql, à l'avoir déjà utilisé donc on aura toute une vidéo pour le coup assez longue. Il y aura beaucoup de choses à voir sur les jointures en sql et là ça va énormément servir aussi puisque c'est un petit peu la seule notion qui vous manque en fait pour pouvoir réaliser un petit peu tous les types de requêtes que vous voulez en sql.

A bientôt pour la prochaine séance du coup sur les jointures dans ce cours