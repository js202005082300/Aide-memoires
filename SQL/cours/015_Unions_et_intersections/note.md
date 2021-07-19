# [15. Unions et intersections](https://www.youtube.com/watch?v=tIP_bQeFeXg)
02-01-20

[data5.sql](data5.sql)

Bonjour bienvenue sur ce cours sql.

Nous en sommes à la 15ème séance et on va continuer de voir ensemble quelques commandes.

Comme vous le savez sur ce cours je vous propose un cours sql qui soit le plus général possible c'est à dire peu importe le système de gestion de base de données que vous utilisez même si nous nous servons de mysql pour les différentes vidéos donc ça tombe bien puisque les commandes que je vais vous montrer dans cette séance ne sont pas des commandes compatible avec tous les systèmes et vous allez voir que mysql en fait les dernières que je vais vous montrer ne fonctionneront pas sur mysql.

Vous pourrez donc les oublier mais on verra par la suite des moyens en fait de simuler ces mots clés, ces commandes particulières qui sont par contre utilisable si vous servez de postgressql, Oracle ou sur le système de microsoft ça fonctionnera aussi.

On va directement entrer dans le vif du sujet et on va déjà démarrer le client ce sera fait. On va importer un fichier que vous pouvez comme d'habitude retrouver dans la description de la vidéo, vous avez le lien vers le fichier sql qui va falloir importer pour pouvoir évidemment vos requête que voulez faire en même temps pour voir un peu comment ça fonctionne et surtout encore une fois si vous êtes sur d'autres systèmes que mysql, vous pourrez également tester les autres commandes qui pour le coup ne fonctionneront pas sur mysql.
	
+ serveur
```sql
	> mysqld --console
```
+ client
```sql
	> mysql -u root -p
	SOURCE C:/SQL/cours/015_Unions_et_intersections/data5.sql;
```
Je n'aurai pas beaucoup à vous montrer dans cette vidéo mais je tenais quand même à les aborder dans la séance.

Alors on est connecté donc le fichier très simple alors j'ai repris un peu l'exemple de ce que j'avais fait dans la séance précédente c'est à dire voyez avec plusieurs utilisateurs, un âge, un pays puis une date d'enregistrement sauf que là il a cette fois ci deux tables, vous allez vous comprendre pourquoi et bien sûr des enregistrements qui sont faits pour les deux tables avec petite remarque voyez par exemple certains utilisateurs dans la table numéro 2 sont également présents dans la 1 ou inversement mais pas forcément tous.

+ data5.sql
```sql
	INSERT INTO `fv_site1_users`(`user_name`, `user_age`, `user_country`, `user_registration`)
	VALUES
	('Bryan', 37, 'États-Unis', '2019-12-22'), 
	('Anne-Claire', 47, 'France', '2019-12-23'), 
	('Thomas', 17, 'France', '2020-01-05'), 
	('Qiao', 16, 'Chine', '2020-01-05'), 
	('Fujiko', 22, 'Japon', '2020-01-18'), 
	('Nina', 21, 'Italie', '2019-06-13'), 
	('Fatou', 22, 'Sénégal', '2019-04-01');

	INSERT INTO `fv_site2_users`(`user_name`, `user_age`, `user_country`, `user_registration`)
	VALUES
	('Marc', 43, 'France', '2019-01-01'), 
	('Fatima', 24, 'Maroc', '2019-03-27'), 
	('Fatou', 22, 'Sénégal', '2019-04-01'), 
	('Yuna', 38, 'Japon', '2019-06-13'), 
	('Qiao', 16, 'Chine', '2020-01-05'), 
	('Thomas', 17, 'France', '2020-01-05');
```
Voilà donc à ce fichier à récupérer encore une fois dans la description de la vidéo pour suivre cette séance si vous voulez faire des tests 1 pour vous entraîner.

Ok alors j'avais vraiment noté le nom, ça évite de remplacer les anti-slash par des slash.
```txt
	C:/SQL/cours/015_Unions_et_intersections/data5.sql
```
On fait un petit source hop, on importe 2, 3 fois pour être sûr.

On va refaire une vérification.
```sql
mysql> use fv_database;
Database changed
mysql> select * from fv_site1_users;
+---------+-------------+----------+--------------+-------------------+
| id_user | user_name   | user_age | user_country | user_registration |
+---------+-------------+----------+--------------+-------------------+
|       1 | Bryan       |       37 | États-Unis   | 2019-12-22        |
|       2 | Anne-Claire |       47 | France       | 2019-12-23        |
|       3 | Thomas      |       17 | France       | 2020-01-05        |
|       4 | Qiao        |       16 | Chine        | 2020-01-05        |
|       5 | Fujiko      |       22 | Japon        | 2020-01-18        |
|       6 | Nina        |       21 | Italie       | 2019-06-13        |
|       7 | Fatou       |       22 | Sénégal      | 2019-04-01        |
+---------+-------------+----------+--------------+-------------------+
7 rows in set (0.00 sec)

mysql> select * from fv_site2_users;
+---------+-----------+----------+--------------+-------------------+
| id_user | user_name | user_age | user_country | user_registration |
+---------+-----------+----------+--------------+-------------------+
|       1 | Marc      |       43 | France       | 2019-01-01        |
|       2 | Fatima    |       24 | Maroc        | 2019-03-27        |
|       3 | Fatou     |       22 | Sénégal      | 2019-04-01        |
|       4 | Yuna      |       38 | Japon        | 2019-06-13        |
|       5 | Qiao      |       16 | Chine        | 2020-01-05        |
|       6 | Thomas    |       17 | France       | 2020-01-05        |
+---------+-----------+----------+--------------+-------------------+
6 rows in set (0.00 sec)
```
Ok on a les tables qui ont été importés et les enregistrements qui ont bien été écrits.

On a ce qu'il faut du coup pour suivre ce que je vais vous montrer par la suite.

note.sql du coup pour montrer les différentes requêtes que je vais vouloir aborder avec vous dans cette vidéo.

La première, ce sont évidemment des mots clés que je vais vous montrer et qui permettent de réaliser certains types de requêtes un peu particulière.

Le premier fonctionne partout donc ça vous n'aurez pas de souci tout le monde peut le tester de son côté c'est UNION qui va permettre en fait de si vous voulez de compacter et de concatener plus exactement le résultat de deux requêtes.

Admettons ici c'est pour ça qu'il avait besoin pour cette séance de 2 tables vous allez très vite comprendre pourquoi et si je voulais par exemple récupérer tous les utilisateurs de cette table là et ensuite tous les utilisateurs de cette table là. A l'heure où vous en êtes, au niveau actuel de ce que vous avez vu en tout cas en sql vous auriez fait ce que je viens de faire en fait directement depuis le client c'est à dire ceci.

+ notes.sql
```sql	
	SELECT * FROM fv_site1_users;
```
On fait une première requête on va la copier coller donc je ne vais pas le refaire c'est exactement ce que j'ai fait. Voyez j'ai fait une première requête ça m'a affiché le résultat, une deuxième ça m'a affiché un résultat.

J'ai donc deux requêtes qui ont été effectués évidemment chaque requête a un coût.

L'avantage de ce que vous allez voir avec UNION, ça va permettre de concatener le résultat de deux requêtes d'accord, de deux ensembles de résultat finalement en une seule et là évidemment on optimise un petit peu la requête qui est effectuée.

Pour faire ça c'est très simple au lieu d'avoir ici 2 requêtes différentes, on va avoir un UNION entre les deux qui permet justement de lier ces deux requêtes là.

Alors attention ça ne s'utilise pas n'importe comment, je vais mettre comme ça pour que ce soit plus lisible pour vous.

+ notes.sql
```sql	
	SELECT * FROM fv_site1_users
	UNION
	SELECT * FROM fv_site2_users;
```
Il y a des règles à respecter par rapport aux différentes commandes que je vous montrer sur cette vidéo.

Première chose au niveau des exemples que vous avez là, il faut qu'il y ait déjà le même nombre de colonnes à récupérer donc là par exemple j'ai fait un * donc ça récupère tout.

On voit alors je rappelle que le id_user ici on la récupèré aussi quand on fait une *, on a 5 colonnes avec la table fv_site1_users. 

Il faut le même nombre pour l'autre requête d'accord c'est très important càd que si par exemple on veut récupérer juste le nom d'utilisateur et par exemple l'âge, il faudra qu'on ait le même nombre de colonnes à récupérer sur la seconde requête.

C'est la première règle et c'est très important parce que sinon si vous ne pigez pas ça évidemment vous aurez plein d'erreurs lorsque vous allez vouloir comme ça concatener 2 requêtes.

Première chose, le même nombre de colonnes.

Ensuite il faut que l'ordre que vous donnez aux colonnes soit le même par exemple  si je voulais récupérer le username et l'âge, il faut que pour la deuxième requête, je récupère sous ce même ordre et récupère également le même type de données donc là exceptionnellement pour cet exercice vous voyez que j'ai mis les mêmes noms ici aux différents champs des tables parce que ça viendrait simuler par exemple une table pour récupérer des utilisateurs d'un site numéro 1 d'accordet un deuxième site ou bien finalement la structure de la table est la même, ce n'est pas obligatoire. Ici j'aurais pu appeler par exemple ça en français prénom, âge ou encore ici mettre pays d'accord.
```sql
mysql> select * from fv_site1_users;
+---------+-------------+----------+--------------+-------------------+
| id_user | user_name   | user_age | user_country | user_registration |
+---------+-------------+----------+--------------+-------------------+

mysql> select * from fv_site2_users;
+---------+-----------+----------+--------------+-------------------+
| id_user | user_name | user_age | user_country | user_registration |
+---------+-----------+----------+--------------+-------------------+
```
Vous n'êtes pas obligé d'avoir évidemment le même nom.

Il y a juste trois règles le même nombre de colonnes que vous voulez récupérer lors de vos requêtes, le même ordre et le même type de données.

Ici comme user_name est un VARCHAR donc pas de souci, et là user_age c'est un INT donc pas de problème d'accord là user_registration on est sur un DATE donc on a bien le même type qui a été récupéré en l'occurrence le même ordre et forcément le même monde de colonne puisque voyez que j'ai fait des table qui ont finalement le même nombre de colonne donc pas de problème.

A partir de là si ces règles sont respectées vous pouvez sans problème utiliser et UNION qui va permettre de concatener deux requêtes et encore une fois sous une seule.
```sql
	mysql> SELECT * FROM fv_site1_users
		-> UNION
		-> SELECT * FROM fv_site2_users;
	+---------+-------------+----------+--------------+-------------------+
	| id_user | user_name   | user_age | user_country | user_registration |
	+---------+-------------+----------+--------------+-------------------+
	|       1 | Bryan       |       37 | États-Unis   | 2019-12-22        |
	|       2 | Anne-Claire |       47 | France       | 2019-12-23        |
	|       3 | Thomas      |       17 | France       | 2020-01-05        |
	|       4 | Qiao        |       16 | Chine        | 2020-01-05        |
	|       5 | Fujiko      |       22 | Japon        | 2020-01-18        |
	|       6 | Nina        |       21 | Italie       | 2019-06-13        |
	|       7 | Fatou       |       22 | Sénégal      | 2019-04-01        |
	|       1 | Marc        |       43 | France       | 2019-01-01        |
	|       2 | Fatima      |       24 | Maroc        | 2019-03-27        |
	|       3 | Fatou       |       22 | Sénégal      | 2019-04-01        |
	|       4 | Yuna        |       38 | Japon        | 2019-06-13        |
	|       5 | Qiao        |       16 | Chine        | 2020-01-05        |
	|       6 | Thomas      |       17 | France       | 2020-01-05        |
	+---------+-------------+----------+--------------+-------------------+
	13 rows in set (0.00 sec)
```
Il s'agit pour le coup d'une seule requête c'est bien plus optimisé que de le faire séparément et surtout ça permet de récupérer tout en un.

Autre pont aussi intéressant de ce type de mot clé, c'est que ça ne va pas récupérer les doublons admettons que vous ayez  deux sites internet d'accord que vous gérez pour des questions de gestion de ressources, vous n'allez pas gérer ça sur les mêmes tables d'accord vous avez une table réservé pour certains nom d'utilisateur et une autre mais ben vous pouvez très bien avoir une utilisateur qui est à la fois présent sur le premier site et le second.

Là d'ailleurs Qiao est l'utilisateur 4 et sur le site2 c'est le 5e donc ils sont considèré comme différents mais par contre c'est si en fait on avait des tables vraiment identiques vous ne récupérerez pas en fait des doublons càd qui si il y a des enregistrements qui sont parfaitement identiques d'une table à l'autre ils ne seront pas récupérés.

Le problème c'est par rapport à ce que je voulais vous dire pour les autres commandes, j'ai du coup mit des noms ici qui pourrait induire en erreur donc attention voilà il est bien considéré que Qiao et Qiao ne sont pas le même ... en réalité ce qu il faut ? c'est des enregistrements purement identique sur tout ce que vous avez récupéré.

Alors là par contre ce qu'on peut faire éventuellement plutôt que de tout récupérer comme ça risquera moins de vous embrouiller c'est de juste récupérer les noms d'utilisateurs.

+ notes.sql
```sql	
	SELECT user_name FROM fv_site1_users
	UNION
	SELECT user_name FROM fv_site2_users;
```
On fait ça et voilà.
```sql
	mysql> SELECT user_name FROM fv_site1_users
		-> UNION
		-> SELECT user_name FROM fv_site2_users;
	+-------------+
	| user_name   |
	+-------------+
	| Bryan       |
	| Anne-Claire |
	| Thomas      |
	| Qiao        |
	| Fujiko      |
	| Nina        |
	| Fatou       |
	| Marc        |
	| Fatima      |
	| Yuna        |
	+-------------+
	10 rows in set (0.00 sec)
```
Et là vous voyez que Qiao est bien une seule fois présent comme on s'est basé que que là dessus voilà on évite complètement les doublons dans les résultats qu'on fournit donc attention si vous prenez plusieurs champs il faut que tous les champs soient identiques entre plusieurs enregistrements pour qu'il considère que c'est un doublon et du coup ne vous le retourne pas dans le résultat.

Donc la commande union ne retournera pas d'accord si vous utilisé ce mot clé là les doublons d'enregistrement qui sont parfaitement identiques d'accord au niveau de toutes les colonnes que vous avez demandé et là je vous monterai du coup ces petites là.

Si vous avez éventuellement besoin de récupérer tous les doublons quel qu'il soit il faut simplement rajouté un ALL c'est UNION ALL du coup le mot clé qu'il faut et là ça va tout récupérer peu importe les cas.

+ notes.sql
```sql	
	SELECT user_name FROM fv_site1_users
	UNION ALL
	SELECT user_name FROM fv_site2_users;

	mysql> SELECT user_name FROM fv_site1_users
		-> UNION ALL
		-> SELECT user_name FROM fv_site2_users;
	+-------------+
	| user_name   |
	+-------------+
	| Bryan       |
	| Anne-Claire |
	| Thomas      |
	| Qiao        |
	| Fujiko      |
	| Nina        |
	| Fatou       |
	| Marc        |
	| Fatima      |
	| Fatou       |
	| Yuna        |
	| Qiao        |
	| Thomas      |
	+-------------+
	13 rows in set (0.00 sec)
```
Bien et là on récupère Qiao deux fois, on récupère
Thomas deux fois, là il récupère tous les doublons et considère qu'il n'y a pas de doublons.

Il récupère absolument le résultat des deux requêtes qu'il a concaténé indépendamment des doublons donc ça autres mot clé à connaître union, union hall pour récupérer les doublons de vos résultats.

Ca c'est tous les systèmes de gestion de bases de données encore mysql, postgresql, sql, oracle, ms sql server pour microsoft, autre peu importe vous pourrez utiliser ce genre de mots clés partout.

Là on va arriver sur deux autres exemples qui sont très pratiques donc là on a vu comment concatener le résultat si vous voulez des données de deux requêtes en une seule en faisant une concaténation.

On va voir maintenant comment on peut tout simplement renvoyer des résultats qui sont présents dans 2 requête différentes en l'occurrence ici comme voyez que je fais mes requêtes sur deux tables différent, on peut se dire comment je peux récupérer des résultats qui seraient présents dans deux tables ?

Et ça justement au niveau de l'exemple parce qu'évidemment vous n'êtes pas forcément obligé de suivre ce cours en étant sur mysql, évidemment moi je vous montre ça au niveau du cours mais vous peut-être qu'un jour vous utiliserez ce cours pour travailler sur un autre.

Vous pourrez de votre côté pour le coup tester des commandes, moi je ne peux pas vous les montrer parce que je suis sur mysql ici et c'était pas bien grave alors par contre c'est pour ça que ce que j'avais montré en début de vidéo, voyez j'avais remis comme ça certains utilisateurs ici dans les deux tables.

+ data5.sql
```sql
	INSERT INTO `fv_site1_users`(`user_name`, `user_age`, `user_country`, `user_registration`)
	VALUES
	('Bryan', 37, 'États-Unis', '2019-12-22'), 
	('Anne-Claire', 47, 'France', '2019-12-23'), 
	('Thomas', 17, 'France', '2020-01-05'), 
	('Qiao', 16, 'Chine', '2020-01-05'), 
	('Fujiko', 22, 'Japon', '2020-01-18'), 
	('Nina', 21, 'Italie', '2019-06-13'), 
	('Fatou', 22, 'Sénégal', '2019-04-01');

	INSERT INTO `fv_site2_users`(`user_name`, `user_age`, `user_country`, `user_registration`)
	VALUES
	('Marc', 43, 'France', '2019-01-01'), 
	('Fatima', 24, 'Maroc', '2019-03-27'), 
	('Fatou', 22, 'Sénégal', '2019-04-01'), 
	('Yuna', 38, 'Japon', '2019-06-13'), 
	('Qiao', 16, 'Chine', '2020-01-05'), 
	('Thomas', 17, 'France', '2020-01-05');
```
Tout simplement pour ne pas en fait simplement montrer si vous voulez les similitudes qu'il y a entre deux enregistrements.

Alors là pareil comme ils n'ont pas le même identifiant ça peut éventuellement poser problème, je vais quand même montrer la commande c'est pas grave.

Admettons je vais récupérer voilà les utilisateurs comme ça en disant je veux qu'on me retourne le nom d'utilisateur de quelqu'un qui serait à la fois présent sur le premier site et le second donc le mot clé à utiliser c'est tout simplement INTERSECT.

+ notes.sql
```sql
	SELECT user_name FROM fv_site1_users
	INTERSECT
	SELECT user_name FROM fv_site2_users;
```
Voilà et avec cette commande là il va faire l'intersection de vos deux requêtes et se dire bon là je sélectionne tous les noms d'utilisateurs de la table fv_site1_users et je sectionne les utilisateurs de la table fv_site2_users et si je vois qu'il y en un qui est à la fois présent sur cette table et cette table et bien ce sera le résultat qui sera envoyée en finale de toute cette requête.

Ok donc ça je ne peux pas encore une fois vous montrer en exemple directement là à l'exécution parce que ça ne marchera pas sur mysql.

On peut s'amuser évidemment après de toute façon je pense qu'il mettra une erreur, une syntax error a priori voilà.
```sql
	mysql> SELECT user_name FROM fv_site1_users
		-> INTERSECT
		-> SELECT user_name FROM fv_site2_users;
	ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'SELECT user_name FROM fv_site2_users' at line 3
```
Syntax error, voilà c'est tout à fait normal.

Si vous êtes sur postgresql, encore une fois sur oracle, vous pouvez tester ce genre de commandes et ça fonctionnera donc en l'occurrence là ça retournera tout simplement les personnes qui sont présentes dans les deux tables donc ça va renvoyer Thomas, Qiao et Fatou qui est présente dans les deux tables donc elle fera partie des résultats retournés par la requête INTERSECT ça automatiquement on l'aura voilà.

Autre mot clé à connaître, on a vu une UNION, on a vu INTERSECT et on va en voir un dernier qui est MINUS.

MINUS pareil sur mysql ce n'est pas disponible, sur d'autres systèmes de bases de données, vous pourrez l'utiliser ou alors vous avez une autre syntaxe càd qu'au lieu d'utiliser le mot minus ça utilise simplement le mot except.

Je vais vous montrez tout simplement au niveau de la syntaxe comment ça s'écrit et après expliquer en gros comment ça fonctionne.

On va reprendre la syntaxe basique MINUS.

+ notes.sql
```sql
	SELECT user_name FROM fv_site1_users
	MINUS
	SELECT user_name FROM fv_site2_users;
```
Comme si d'ailleurs voyez que mon éditeur ne le color absolument pas donc il ne le prend pas en compte.

Alors on a ces commandes ici SELECT et là ce que ça va faire ? ça va tout simplement vous renvoyez les enregistrements de cette première requête SELECT ok mais qui ne sont pas présents en fait dans la deuxième donc vous dire si j'ai un utilisateur admettons qui est aussi présent dans la deuxième table là, je ne vais pas le renvoyer d'accord.

C'est en gros tu me retourne le nom d'utilisateur du site 1 mais qui ne sont pas enregistrés dans le deuxième site.

Si ils sont présents dans les deux sites, je n'en veux pas dans mon résultat.

On utilise pour cela MINUS et sur d'autres sgbd, j'ai plus exactement en tête qui utilisent quoi mais il me semble que MINUS c'est oracle qui s'en sert.

C'est oracle qui sert de MINUS et les autres se servent de EXCEPT donc except ça s'écrit comme ça se prononce car c'est de l'anglais, except tout simplement.

Voilà donc si vous voyez que MINUS ne fonctionne pas sur votre sgbd, utilisez except et ça fonctionne parce que c'est l'autre syntaxe.

Encore une fois sur mysql, ces deux mots EXCEPT, MINUS et INTERSECT ne fonctionne pas.

Je le rappelle c'est important de le savoir comme vous serez sûrement de majorité à avoir installé et utilisé mysql pour suivre ce cours puisque c'est celui que j'ai proposé qui est quand même le plus standard, forcément vous ne pourrez utiliser ces commandes là mais si un jour vous êtes amené à travailler sur un autre sgbd sachez qu'il existe ces mots clés et qui sont quand même pas mal pratique.

On verra de toute façon à la suite du cours, pas mal de choses, des moyens d'accord il y a d'autres manières de faire des requêtes qui permettent de produire ces comportements.

On peut faire en réalité un MINUS en mysql mais il n'y a pas de mots clés en fait qui fait tout cela à notre place. On aura besoin de faire certaines requêtes et vous verrez qu'en utilisant un système de sous requêtes on peut réussir à simuler certains certains mots clés et également avec les jointures, on verra un peu plus tard au niveau du cours, on pourra également par exemple se débrouiller pour produire le résultat que ferait un MINUS sur un autre sgbd donc ça c'est important de le savoir.

Alors en gros voilà donc par exemple ici il va récupérer dans tous les utilisateurs de la table 1 et la table 2 et il va comparer en fait il va voir.

Par exemple, Fatou ne sera pas récupérée puisqu'elle est présente dans l'autre table d'accord et cetera.

Donc tout ce qui en fait est présent dans la première requête mais n'existe pas d'accord d'accord c'est moins, MINUS ça veut dire moins en anglais, pour dire voilà je récupère tous les utilisateurs de la table 1 moins ceux qui sont présents dans la table 2 donc c'est très simple.

D'accord vous faites une soustraction simplement voilà comme Thomas est dans la 1er table et comme il est présent dans la 2e table, on ne le récupère pas, tant pis désolé thomas.

Par contre Bryan n'est pas présent dans la deuxième table donc lui sera bien récupéré, sera bien donné comme résultat d'une requête avec MINUS ou avec EXCEPT comme je vous l'avais dit en vidéo.

Et on va pouvoir s'arrêter là tout simplement, il n'y avait pas grand chose à voir mais je tenais quand même à faire une vidéo là dessus sur tout ce qui était union est intersection parce que c'est quand même un des concepts à connaître d'où le titre de cette séance là et qui sont nécessaires parce que si vous manipulez d'autres systèmes de gestion de bases de données vous aurez grandement grandement utilisé ces différents mots clés au niveau de vos requêtes.

Vous avez vu que ça optimise pas mal et ça rend le tout un peu plus performant que si on se contentait de faire certaines requêtes comme ça la suite est d'autant mieux qu'une fois que vous avez groupé les résultats vous pouvez faire mal de choses avec.

D'ailleurs, avant de se quitter, c'est bien de le dire parce que peut-être que ça ne paraîtrait pas évident pour certains, on va revenir sur un exemple qui du coup fonctionne parce que ne pas avoir de code, de requête a montrer ce serait un peu dommage.

On va revenir sur l'union et par exemple quand vous faites ça, n'oubliez pas qu'après tout ça en fait c'est votre requête d'accord. C'est votre partie sélection de requêtes.

+ notes.sql
```sql
	SELECT user_name FROM fv_site1_users
	UNION
	SELECT user_name FROM fv_site2_users;
```
Ensuite si moi derrière, on va refaire ça proprement, je récupère plein d'utilisateurs sauf les doublons pas de problème.
```sql
	mysql> SELECT user_name FROM fv_site1_users
		-> UNION
		-> SELECT user_name FROM fv_site2_users;
	+-------------+
	| user_name   |
	+-------------+
	| Bryan       |
	| Anne-Claire |
	| Thomas      |
	| Qiao        |
	| Fujiko      |
	| Nina        |
	| Fatou       |
	| Marc        |
	| Fatima      |
	| Yuna        |
	+-------------+
	10 rows in set (0.00 sec)
```

D'ailleurs, je peux peut être récupérer toutes les informations pour le coup, plus pratique pour ce que j'ai à vous montrer avant de finir cette vidéo.

+ notes.sql
```sql
	SELECT * FROM fv_site1_users
	UNION
	SELECT * FROM fv_site2_users;
```
```sql
mysql> SELECT * FROM fv_site1_users
    -> UNION
    -> SELECT * FROM fv_site2_users;
+---------+-------------+----------+--------------+-------------------+
| id_user | user_name   | user_age | user_country | user_registration |
+---------+-------------+----------+--------------+-------------------+
|       1 | Bryan       |       37 | États-Unis   | 2019-12-22        |
|       2 | Anne-Claire |       47 | France       | 2019-12-23        |
|       3 | Thomas      |       17 | France       | 2020-01-05        |
|       4 | Qiao        |       16 | Chine        | 2020-01-05        |
|       5 | Fujiko      |       22 | Japon        | 2020-01-18        |
|       6 | Nina        |       21 | Italie       | 2019-06-13        |
|       7 | Fatou       |       22 | Sénégal      | 2019-04-01        |
|       1 | Marc        |       43 | France       | 2019-01-01        |
|       2 | Fatima      |       24 | Maroc        | 2019-03-27        |
|       3 | Fatou       |       22 | Sénégal      | 2019-04-01        |
|       4 | Yuna        |       38 | Japon        | 2019-06-13        |
|       5 | Qiao        |       16 | Chine        | 2020-01-05        |
|       6 | Thomas      |       17 | France       | 2020-01-05        |
+---------+-------------+----------+--------------+-------------------+
13 rows in set (0.00 sec)
```
Voilà on a tout les utilisateurs-là, si vous voulez admettons changer l'ordre des résultats que vous avez bien appris à faire des clauses where ou simplement order by si on veut changer l'ordre des résultats on peut le faire.

Vous pourriez être tenté de vous dire, je fais un order by sur chaque requête SELECT puis se dire on a une requête et une deuxième parce qu'on nous avait appris à mettre la clause where et order by en fin de la commande select.

Là il faut vraiment partir du principe que tout ceci c'est votre requête en fait, encore c'est limites si vous voulez vous aider au niveau écriture vous pouvez la marquer comme ça.

+ notes.sql
```sql
	SELECT user_name FROM fv_site1_users UNION SELECT user_name FROM fv_site2_users;
```
Et du coup si vous voulez rajouter un ordre, vous le mettez à la toute fin et là on va mettre du coup sur ce que l'on veut donc là bon pour le coup les noms des champs des deux tables sont les mêmes donc c'est très simple donc il suffit de mettre par exemple user_name.

+ notes.sql
```sql
	SELECT user_name FROM fv_site1_users UNION SELECT user_name FROM fv_site2_users
	ORDER BY user_name;
```
Et si vous avez par exemple sur votre table un certain nombre de champ càd que vous avez bien le même nombre de colonnes, le même ordre et le même type de données mais pas les mêmes noms que vous avez mis dans fv_site1_users et fv_site2_users d'accord c'est les noms de la première table si je dis pas de bêtises qui seront marquées au niveau des résultats d'accord il va prendre ces noms là au niveau de ce que vous aurez affiché au niveau du tableau d'accord à l'affichage.

Donc c'est ce qui sera récupérée dans la requête concatenée avec un union donc là je fais ça et puis c'est tout.

+ notes.sql
```sql
	SELECT * FROM fv_site1_users UNION SELECT * FROM fv_site2_users
	ORDER BY user_name;
```
```sql
	mysql> SELECT * FROM fv_site1_users UNION SELECT * FROM fv_site2_users
		-> ORDER BY user_name;
	+---------+-------------+----------+--------------+-------------------+
	| id_user | user_name   | user_age | user_country | user_registration |
	+---------+-------------+----------+--------------+-------------------+
	|       2 | Anne-Claire |       47 | France       | 2019-12-23        |
	|       1 | Bryan       |       37 | États-Unis   | 2019-12-22        |
	|       2 | Fatima      |       24 | Maroc        | 2019-03-27        |
	|       7 | Fatou       |       22 | Sénégal      | 2019-04-01        |
	|       3 | Fatou       |       22 | Sénégal      | 2019-04-01        |
	|       5 | Fujiko      |       22 | Japon        | 2020-01-18        |
	|       1 | Marc        |       43 | France       | 2019-01-01        |
	|       6 | Nina        |       21 | Italie       | 2019-06-13        |
	|       4 | Qiao        |       16 | Chine        | 2020-01-05        |
	|       5 | Qiao        |       16 | Chine        | 2020-01-05        |
	|       3 | Thomas      |       17 | France       | 2020-01-05        |
	|       6 | Thomas      |       17 | France       | 2020-01-05        |
	|       4 | Yuna        |       38 | Japon        | 2019-06-13        |
	+---------+-------------+----------+--------------+-------------------+
	13 rows in set (0.00 sec)
```
Vous voyez qu'ils sont bien triés par ordre alphabétique par contre il a renvoyé 2 Qiao et 2 Thomas parce que rappelez-vous même id_user donc comme il fait une comparaison sur tous les champs et s'il y a un seul deschamps qui diffèrent il considère que ce ne sont pas des doublons donc effectivement il vous retourne les deux.

En revanche s'il avait juste par exemple fait user_name et user_country donc environ je peut même tout faire sauf récupérer l'identifiant finalement parce que c'est ça.

+ notes.sql
```sql
	SELECT user_name, user_country FROM fv_site1_users UNION SELECT user_name, user_country FROM fv_site2_users ORDER BY user_name;

	mysql> SELECT user_name, user_country FROM fv_site1_users UNION SELECT user_name, user_country FROM fv_site2_users ORDER BY user_name;
	+-------------+--------------+
	| user_name   | user_country |
	+-------------+--------------+
	| Anne-Claire | France       |
	| Bryan       | États-Unis   |
	| Fatima      | Maroc        |
	| Fatou       | Sénégal      |
	| Fujiko      | Japon        |
	| Marc        | France       |
	| Nina        | Italie       |
	| Qiao        | Chine        |
	| Thomas      | France       |
	| Yuna        | Japon        |
	+-------------+--------------+
	10 rows in set (0.00 sec)
```
On va faire les choses plus claires encore une fois je ne veux pas que vous soyez embrouillé et voilà là effectivement on a juste les résultats qui ne sont pas des doublons et tout est bien rangé par la ordre alaphébitue selon le user_name puisque c'est celui qu'on avait demandé avec le order by, qui est bien mis encore une fin de la requête.

Je rappelle un appel toujours à la fin puisque c'est le order qui va être appliqué sur tout ça.
```sql
	SELECT user_name, user_country FROM fv_site1_users UNION SELECT user_name, user_country FROM fv_site2_users ...
```
Il s'agit bien d'une concatenation donc on applique la clause d'ordre sur la concatenation qui a été fait.

On terminera du coup cette partie, c'est ce que je voulais montrer sur cet élément là.

J'espère que ce n'était pas trop compliqué mais je pense pas, s'est vraiment des choses à mettre en pratique après vous apprendrez de façon à vous servir de ces différents mots clés dans vos requêtes après ça se retient naturellement, il n'y pas besoin d'apprendre par coeur encore une fois.

Donc je pense que c'est suffisamment explicite, que ça vous a permis de comprendre un peu l'utilité qu'elles ont, ça va pas mal économiser, pas mal optimiser les requêtes sql que vous allez faire.

Et on se retrouvera du coup pour la prochaine séance, prochaine vidéo je pense qu'on va attaquer, on va commencer à arriver dans l'histoire dessous, sous requêtes, jointures.

tout ce que avez vu en début de vidéo donc on arrive sur des choses très intéressantes très sympa, un peu plus complexe et c'est pour ça que là je voulais faire des petites vidéos qui sont quand même beaucoup plus simple histoire de se préparer à des choses donc on arrive pour la suite et fin parce qu'on arrivera quand même mine de rien pas très loin de la fin de cette formation sql.

N'hésitez pas en tout cas dans les commentaires si il y a des questions des remarques ou bloquées sur quelque chose je suis là évidemment pour y répondre et pour pouvoir vous aider si
besoin est.

A bientôt tout le monde pour la prochaine vidéo.

Ciao