# [14. Grouper résultats](https://www.youtube.com/watch?v=5RFdXGicu1o)
01-01-21

[data4.sql](data4.sql)

Bonjour tout le monde et bienvenu pour notre quatorzième séance en sql.

On va regarder ensemble comment grouper et des résultats c'est à dire qu'on va effectuer certaines requêtes à partir des résultats retournés par la requête.

Nous allons pouvoir faire des regroupements de données pour éventuellement par exemple récupérer des informations supplémentaires.

La vidéo sera très simple, il n'y a pas grand chose à voir, pas beaucoup de nouvelles commandes que vous allez que nous allons aborder dans cette vidéo mais elles sont très très importante et elle vous serviront beaucoup en sql par la suite.

On va directement se connecter aux serveurs un petit rappel ça ne fait pas de mal, on connecte avec le client et nous allons pour les besoins de cette vidéo directement importer un fichier que vous pouvez retrouver dans la description de la vidéo je rappelle notamment celui là data4.sql.
	
+ serveur
```sql
	> mysqld --console
```
+ client
```sql
	> mysql -u root -p
```

C'est simplement la suppression de la base de données si elle existe, on recrée cette base de données, on crée une table fv_users qui contient comme vous le voyez un utilisateur, un âge, un pays, une date d'enregistrement et ensuite quelques enregistrements qui sont ajoutés à cette table qui nous serviront pour la vidéo parce que vous verrez qu'il y a des cas spécifiques et que les tables qu'on avait créé précédemment n'aurait pas permis de vous montrer justement les quelques commandes que nous allons voir pour cette vidéo.

On va importer ce fichier directement, j'avais préparé la commande dont je rappelle qu'il faut des slash au niveau de l'ajout avec la commande source rappelez-vous et pas de guillemets et pas d'espaces non plus, de caractères spéciaux, tout ça.
```sql
	mysql> SOURCE C:/SQL/cours/014_Grouper_resultats/data4.sql;
```
On prend ça, on va directement sur le client, on fait source puis le chemin, petit point virgule et on n'hésite pas à le faire deux trois fois pour être sûr voilà que l'apport c'est bien fait correctement.

Une fois que ça c'est fait je peux aller sur la base de données.
```sql
	mysql> use fv_database;
	Database changed
```
fv_database et normalement si je fais déjà describe fv_users, je dois retrouver toutes les informations qu'on avait vu dans le fichier, pas de souci à ce niveau-là.
```sql
	mysql> describe fv_users;
	+-------------------+-------------+------+-----+---------+----------------+
	| Field             | Type        | Null | Key | Default | Extra          |
	+-------------------+-------------+------+-----+---------+----------------+
	| id_user           | int         | NO   | PRI | NULL    | auto_increment |
	| user_name         | varchar(65) | NO   |     | NULL    |                |
	| user_age          | int         | NO   |     | NULL    |                |
	| user_country      | varchar(65) | NO   |     | NULL    |                |
	| user_registration | date        | NO   |     | NULL    |                |
	+-------------------+-------------+------+-----+---------+----------------+
	5 rows in set (0.01 sec)
```
Ensuite un petit select dois me retourner tous les enregistrements.
```sql
	mysql> select * from fv_users;
	+---------+-------------+----------+--------------+-------------------+
	| id_user | user_name   | user_age | user_country | user_registration |
	+---------+-------------+----------+--------------+-------------------+
	|       1 | Marc        |       43 | France       | 2019-01-01        |
	|       2 | Fatima      |       24 | Maroc        | 2019-03-27        |
	|       3 | Fatou       |       22 | Sénégal      | 2019-04-01        |
	|       4 | Yuna        |       38 | Japon        | 2019-06-13        |
	|       5 | Nina        |       21 | Italie       | 2019-06-13        |
	|       6 | Bryan       |       37 | États-Unis   | 2019-12-22        |
	|       7 | Anne-Claire |       47 | France       | 2019-12-23        |
	|       8 | Thomas      |       17 | France       | 2020-01-05        |
	|       9 | Qiao        |       16 | Chine        | 2020-01-05        |
	|      10 | Fujiko      |       22 | Japon        | 2020-01-18        |
	+---------+-------------+----------+--------------+-------------------+
	10 rows in set (0.00 sec)
```
Ca c'est à vérifier, vérifier bien de votre côté que vous avez bien récupéré tous les enregistrements tel qu'ils étaient présentés dans le fichier que vous avez importé, pour être sûr qu'il n'y a pas eu de problème.

Une fois que ça c'est fait on va pouvoir commencer à voir ensemble 3 choses.

On va voir grosso modo bon deux grosses commandes, on va dire, et une qui est quand même pas mal pratique aussi qui permet de récupérer un résultat supplémentaire en fait aux enregistrements que vous obtenez via une requête.

La première chose c'est dans le cas par exemple où on obtient donc voyez un certain nombre d'utilisateurs (pour ça que j'ai fait ce type de table) d'accord on à leur âge, on a leur pays de résidence, on a une date tout simplement d'inscription, de création du compte sur cette base.

Nous ce qu'on aimerait retourner, vous voyez qu'il y a différents pays ici et moi j'aimerais par exemple récupérer en fait pour chaque pays le nombre de personnes qui sont inscrites, le nombre de personnes présentes parmi les utilisateurs.

Si vous essayez jusqu'à présent de faire avec tout ce que vous avez vu c'est à dire à coups de select ou je ne sais pas ou même éventuellement certaines commandes d'agrégation, on pourrait utiliser des commandes d'agrégation.

On pourrait penser notamment à la commande COUNT() d'accord qui permet en fait comme fonction de compter un certain nombre de choses.

+ notes.sql
```sql
	-- C:/SQL/cours/014_Grouper_resultats/data4.sql
	
	SELECT COUNT
```
Là le problème c'est que vous allez pouvoir compter des âges, vous aller par exemple pouvoir faire ça car ensuite on va faire from et pourquoi pas une clause where.

+ notes.sql
```sql
	-- C:/SQL/cours/014_Grouper_resultats/data4.sql
	
	SELECT COUNT(*)
	FROM fv_users
	WHERE user_country = 'FRANCE';
```
Donc ça à ce stade de la formation vous êtes tout à fait capable de faire ce genre de requête et là vous allez obtenir ce genre de choses d'accord.
```sql
	mysql> SELECT COUNT(*)
		-> FROM fv_users
		-> WHERE user_country = 'FRANCE';
	+----------+
	| COUNT(*) |
	+----------+
	|        3 |
	+----------+
	1 row in set (0.00 sec)
```
Voilà on obtient 3 effectivement si on regarde les personnes qui habitent en france vous allez vous retrouver trois personnes donc on peut dire on a réussi à récupérer cette information.

Le problème c'est que moi j'aimerais faire ceci pour toutes les personnes qui sont présentes dans la table et ça vous pouvez pas vous voyez niveau de la clause where, vous n'allez pas vous amuser à vérifier, faire une requête en fait par pays d'autant que vous n'avez pas spécialement non plus envie de chercher vous même les pays qui sont présents dans la table donc on va pouvoir faire un groupement c'est à dire qu'on va récupérer tous les utilisateurs et par ses utilisateurs là d'accord on va faire un groupement selon leur pays et ont récupérera dans la foulée bien sûr le nombre de personnes pour chacun de ces pays tout simplement.

Première chose on garde le fameux select count(*), il faut bien qu'on compte quelque chose donc on compte tous les utilisateurs en question.

Ensuite qu'est-ce qu'on va faire ? On a besoin de récupérer le pays d'accord parce que veut faire un groupement par rapport au pays donc ça c'est important, pas de problème, on récupère depuis cette table fv_users et de toute façon il n'y en a qu'une seule pour cette vidéo donc c'est pas compliqué.

+ notes.sql
```sql
	-- C:/Users/sam/OneDrive/Formations/FormationVideo/Ressources/SQL/cours/014_Grouper_resultats/data4.sql
	
	SELECT COUNT(*), user_country
	FROM fv_users
	WHERE user_country = 'FRANCE';
```
Par contre là la clause where ne sera pas utile parce que vous voyez bien qu'avec une clause where on n'aurait pas assez d'information a récupérer, on va vraiment se limiter au niveau des résultats.

Pour effectuer ce groupement voici une nouvelle commande que vous avez vous allez pouvoir apprendre ici c'est la commande GROUP BY qui est très simple à retenir qui veut simplement dire grouper par quelque chose et ça tombe bien on a dit qu'on voulait récupérer le nombre de chaque résident je rappelle par rapport à chacun des pays que nous avons dans notre table donc on va regrouper par rapport à ces pays-là.

+ notes.sql
```sql
	-- C:/Users/sam/OneDrive/Formations/FormationVideo/Ressources/SQL/cours/014_Grouper_resultats/data4.sql
	
	SELECT COUNT(*), user_country
	FROM fv_users
	GROUP BY user_country;
```
WHERE user_country donc ça récupère tout le monde éffectivement, on aura une colonne qui va compter, une colonne qui va indiquer le pays correspondant et on va regrouper par pays en gros ça va éviter de répéter des enregistrements en double. Ils ne vont pas par exemple vous ferme en fait cet affichage-là.
```sql
	mysql> select * from fv_users;
	+---------+-------------+----------+--------------+-------------------+
	| id_user | user_name   | user_age | user_country | user_registration |
	+---------+-------------+----------+--------------+-------------------+
	|       1 | Marc        |       43 | France       | 2019-01-01        |
	|       2 | Fatima      |       24 | Maroc        | 2019-03-27        |
	|       3 | Fatou       |       22 | Sénégal      | 2019-04-01        |
	|       4 | Yuna        |       38 | Japon        | 2019-06-13        |
	|       5 | Nina        |       21 | Italie       | 2019-06-13        |
	|       6 | Bryan       |       37 | États-Unis   | 2019-12-22        |
	|       7 | Anne-Claire |       47 | France       | 2019-12-23        |
	|       8 | Thomas      |       17 | France       | 2020-01-05        |
	|       9 | Qiao        |       16 | Chine        | 2020-01-05        |
	|      10 | Fujiko      |       22 | Japon        | 2020-01-18        |
	+---------+-------------+----------+--------------+-------------------+
```
D'accord parce que là, on voit bon on a récupéré un français, un autre français, un autre français, un chinois, un japonais ou une japonaise, un sénégalais et une sénégalaises, etc mais tout les enregistrements sont bien distincts, ils sont séparés chacun.

Nous on veut pouvoir les regrouper donc avec cette requête là, cette nouvelle requête pour le coup on fait ceci et là vous voyez on récupère bien toutes les informations.
```sql
	mysql> SELECT COUNT(*), user_country
		-> FROM fv_users
		-> GROUP BY user_country;
	+----------+--------------+
	| COUNT(*) | user_country |
	+----------+--------------+
	|        3 | France       |
	|        1 | Maroc        |
	|        1 | Sénégal      |
	|        2 | Japon        |
	|        1 | Italie       |
	|        1 | États-Unis   |
	|        1 | Chine        |
	+----------+--------------+
	7 rows in set (0.00 sec)
```
Là on pourrait même faire ça plus proprement, si vous voulez par exemple nommer votre collonne, vous pouvez le faire aussi et là du coup, ce qu'on observe c'est que des gens qui résident en france il y en a 3, au maroc 1, sénégal 1, japon 2, etc et si vous vérifiez évidemment dans votre table ici vous verrez que ça correspond.

+ notes.sql
```sql
	-- C:/Users/sam/OneDrive/Formations/FormationVideo/Ressources/SQL/cours/014_Grouper_resultats/data4.sql
	
	SELECT COUNT(*) AS 'Nombre de résidents', user_country
	FROM fv_users
	GROUP BY user_country;
```
```sql
mysql> SELECT COUNT(*) AS 'Nombre de résidents', user_country
    -> FROM fv_users
    -> GROUP BY user_country;
+----------------------+--------------+
| Nombre de résidents  | user_country |
+----------------------+--------------+
|                    3 | France       |
|                    1 | Maroc        |
|                    1 | Sénégal      |
|                    2 | Japon        |
|                    1 | Italie       |
|                    1 | États-Unis   |
|                    1 | Chine        |
+----------------------+--------------+
7 rows in set (0.00 sec)

mysql> select * from fv_users;
+---------+-------------+----------+--------------+-------------------+
| id_user | user_name   | user_age | user_country | user_registration |
+---------+-------------+----------+--------------+-------------------+
|       1 | Marc        |       43 | France       | 2019-01-01        |
|       2 | Fatima      |       24 | Maroc        | 2019-03-27        |
|       3 | Fatou       |       22 | Sénégal      | 2019-04-01        |
|       4 | Yuna        |       38 | Japon        | 2019-06-13        |
|       5 | Nina        |       21 | Italie       | 2019-06-13        |
|       6 | Bryan       |       37 | États-Unis   | 2019-12-22        |
|       7 | Anne-Claire |       47 | France       | 2019-12-23        |
|       8 | Thomas      |       17 | France       | 2020-01-05        |
|       9 | Qiao        |       16 | Chine        | 2020-01-05        |
|      10 | Fujiko      |       22 | Japon        | 2020-01-18        |
+---------+-------------+----------+--------------+-------------------+
10 rows in set (0.00 sec)
```
Voilà on a fait un groupement de nos résultats pour pouvoir par exemple et bien filtrer sur un certains paramètres précis là nous en l'occurence c'était de faire un groupement par pays donc on peut du coup savoir très facilement si vous avez besoin un jour de faire des statistiques.

Je prends par exemple vous avez un site avec un nom d'utilisateur et vous voulez savoir quelle est la part en fait de résidents la plus importante parmi les gens de votre site eh bien vous pourrez très facilement le savoir et notamment en faisant un petit order by pour pouvoir filtrer.

On peut très vite savoir bon il n'y a pas beaucoup d'exemples bien sûr parce que j'ai pas fait 100 200 enregistrements et donc on voit qu'il ya plus de français que le reste donc on peut par exemple comme ça avoir des outils statistiques qui peuvent servir par rapport à ces quelques commandes ici, deux groupements de résultats donc ça c'est la première chose que je voulais vous montrer.

on va passer un deuxième exemple très simple.

Le deuxième exemple par exemple c'est donc d'avoir une requête à effectuer pas de soucis mais je veux également récupérer une information supplémentaire, même chose dont je veux pas vous remontrer à chaque fois avec le select et puis la close where.

On a vu de toutes manières dès qu'on va vouloir travailler notamment avec des fonctions comme ça, COUNT() etc, des fonctions d'agrégation pour compter ou autre. 

On verra plus tard, vous allez également aborder des fonctions mathématiques, des fonctions voilà sur des chaînes, des dates, on va voir pas mal de choses sur cette formation et vous ne pourrez pas travailler directement avec une clause where d'accord ce sera soit trop limitées, oit simplement vous verrez qu'au niveau des informations vous voulez récupérer, il faut obligatoirement utiliser un groupe by.

Même que d'ailleurs sql vous indiquera dans l'erreur que en fait vous avez besoin voilà d'avoir une information groupé puisque vous utilisez par exemple des fonctions d'agrégation ça c'est important et on l'a vu dans la séance précédente.

Passons à autre chose, je vais par exemple récupérer donc toujours pareil vous allez voir moi je veux donc par pays ça pas de problème récupérer en fait ... c'est bon pour le coup l'exemple n'est pas très utile, dans un cas concret ça ne serait pas vraiment très utile de faire ça mais pour ce que je vais vous montrer au niveau de la commande ça permettra de bien illustrer avec cet exemple ... je veux pour chacun des pays puisque maintenant vous avez appris à regrouper par pays les enregistrements de votre table, faire la somme des âges de toutes les personnes alors c'est pas cool pour les gens malheureusement voilà qui veulent pas trop qu'on parle de leur âge mais nous on va faire comme ça.

On a tous les âges et on veut savoir par exemple si on compte tous les français, si on fait la somme de tout leur âge combien on obtient ? pareil pour tout le monde.

Encore une fois si on avait fait sans groupement hé bien on pourrait le faire que pour un pays en particulier par exemple dire voilà on fait la somme de tous les âges des marocains, on fait la somme de tous les âges des japonais d'accord on sera obligé de faire toujours un cas par un cas comme je vous l'ai montré en début de vidéo.

L'avantagent du regroupement c'est qu'on va pouvoir appliquer ce calcul de somme à l'ensemble des pays puisqu'on fait un groupement sur ces pays donc là c'est très simple aussi, on va refaire un SELECT user_country ça on le récupère évidemment parce que c'est là dessus que se fera le regroupement.
```sql
	SELECT user_country
```
On va faire la somme de l'ensemble des âges et pas des personnes, on récupère tout ça sur notre table ici.
```sql
	SELECT user_country, sum(user_age)
	FROM fv_users
```
Et le groupement d'accord se fera évidemment par rapport au pays ok mais vous allez rajouter un petit ROLLUP ici d'accord.

+ notes.sql
```sql
	-- C:/Users/sam/OneDrive/Formations/FormationVideo/Ressources/SQL/cours/014_Grouper_resultats/data4.sql

	SELECT user_country, sum(user_age)
	FROM fv_users
	GROUP BY user_country WITH ROLLUP;
```
Et là vous allez voir l'information en fait, on va récupérer la somme de tous les âges d'accord donc je vous montrer de façon comment quand ça se passer et on va récupérer les résultats comme on l'avait précédemment.
```sql
	mysql> SELECT user_country, sum(user_age)
		-> FROM fv_users
		-> GROUP BY user_country WITH ROLLUP;
	+--------------+---------------+
	| user_country | sum(user_age) |
	+--------------+---------------+
	| Chine        |            16 |
	| États-Unis   |            37 |
	| France       |           107 |
	| Italie       |            21 |
	| Japon        |            60 |
	| Maroc        |            24 |
	| Sénégal      |            22 |
	| NULL         |           287 |
	+--------------+---------------+
	8 rows in set (0.00 sec)
```
Voilà vous voyez on récupère chine/16 etc.

Voilà donc c'est bon donc il a fait la somme complète de tous les personnes par pays donc ça c'est ce qu'on voulait, ce qu'on avait dit au début.

Par exemple si vous regardez rappelez vous en france on a trois personnes ici, on a Marc, Anne-Claire et Thomas donc ça fait 47 ans, 17 ans et 43 et si on fait la somme de ces trois âges on obtient bien 107.

Vous voyez pour la France il vous dit que la somme de tous les âges correspond à 107, pour les états unis comme il n'y a qu'une personne de 37 ans donc il n'y a que 37.

Et pour le japon, on a Yuma et Jujiko, 38 et 22 on obtient bien du coup si on fait la somme 60 d'accord.

Et là si vous regardez, on a obtenu une dernière ligne en plus des résultats qu'on avait faits par regroupement, qui elle a fait la somme de tous les âges d'accord donc on a déjà fait une somme par pays par rapport au groupement qu'on a voulu faire et en plus de ça on a retourné une dernière lie à notre à notre résultat qui a fait la somme de toutes les sommes.

Vous voyez on a fait deux choses en une donc ça c'est pas mal pratique et plus tard parce que là vous avez dû remarquer que c'est marquez NULL et mieux donc c'est pas forcément très esthétique, vous apprendrez il y a certaines autres fonctions plus tard éventuellement a renommer ici plutôt que laisser ça par défaut.
```sql
	mysql> SELECT user_country, sum(user_age)
		-> FROM fv_users
		-> GROUP BY user_country WITH ROLLUP;
	+--------------+---------------+
	| user_country | sum(user_age) |
	+--------------+---------------+
	| Chine        |            16 |
	| États-Unis   |            37 |
	| France       |           107 |
	| Italie       |            21 |
	| Japon        |            60 |
	| Maroc        |            24 |
	| Sénégal      |            22 |
>	| NULL         |           287 |
	+--------------+---------------+
	8 rows in set (0.00 sec)
```
On apprendra à mettre un autre nom mais comme on l'a pas encore vu on passera pour le moment et on verra tout ça plus tard.

Donc là on a fait 2 choses on a fait notre groupement par pays donc ça c'est la première chose qu'on a fait pour chacun de ces regroupements de pays on a fait la somme des âges de chaque résident par pays donc on a fait donc du coup une deuxième chose et ensuite une fois qu'on a eu la somme de tous les âges on a fait la somme totale de toutes les personnes de notre temps donc on a fait trois traitements en fait d'accord trois opérations en une seule requête.

C'est donc du coup beaucoup plus optimisé que si on s'est amusé à faire plein plein de requêtes partout éventuellement des sous requêtes comme on le verra un peu par la suite dans la formation et on a des choses beaucoup plus optimisée grâce à ce WITH ROLLUP d'accord permet de travailler comme ça plus efficacement de manière plus optimisé au niveau des requêtes.

Donc ça c'est la deuxième chose que je voulais vous montrer évidemment je ne vais pas vous montrer 15 millions d'exemples parce que c'est assez vague comme on n'a pas beaucoup d'infos beaucoup de données sur le la table que j'ai prise donc on tomberait un petit peu en rond sur les exemples, on resterait un peu sur la même chose.

Toujours pareil en sql ça je le dirai jamais assez c'est véritablement la formation qui est la plus intéressante au niveau de votre entraînement c'est à dire que si vous voulez par exemple vous exercez avec les requêtes c'est très très simple puisque vous pouvez vous même de votre côté vous faire une base de données avec plein plein de tables, plein d'enregistrements d'accord, on peut même en trouver sur internet avec tout les fichiers prêt à l'emploi que vous pouvez comme ça importer si vous ne voulez pas le faire vous même et après vous pouvez vous amuser comme ça à faire, imaginez voilà comme si vous étiez un statisticien et vous pouvez comme ça effectuer tout un tas de requêtes, récupérer par exemple, faire des rapports sur des patients, sur tout un tas d'informations comme ça.

C'est très facile de s'exercer finalement à sql avec des bases de données puisqu'on peut travailler sur pas mal d'enregistrements et on a beaucoup d'outils pour le faire donc moi je vous montre quand même quelques petits exemples pour pas que ça fasse trop non plus mais évidemment à la suite de la vidéo, n'hésitez pas de votre côté a continuer voilà tester d'autres requêtes, tester sur d'autres champs faire avec vos propres tables, pas forcément utiliser que celles que je vous présente dans les fichiers, dans les vidéos.

Exercez vous, n'hésitez pas.

On termine du coup cette petite séance avec une dernière commande qui va être bien pratique aussi c'est une commande qui va nous permettre alors un peu comme vous avez tout à l'heure, alors on avait la clause where que maintenant vous connaissez bien qui nous permet par exemple de valider une expression ou non c'est à dire de retourner des résultats et ensuite les filtrer selon une information que l'on veut.

Comme là on effectue un regroupement vous avez vu que si on essaye d'utiliser une clause where avec un groupe by ça ne marche pas très bien, on n'aura pas toute les informations et de toute façon, vous aurez même des erreurs si vous testez ça n'ira pas parce que on fait un regroupement de pas mal d'informations qui au départ ne sont pas dans la table, ne sont pas enregistrées.

Ici nulle part dans la table, il est enregistré la somme des âges par exemple par pays ou autre où le nombre par exemple de français c'est présent nulle part c'est nous qui pouvons extraire cette information avec des requêtes.

Si vous avez besoin de d'utiliser une clause par exemple avec un groupement et notamment d'utiliser des fonctions dans cette clause au lieu d'utiliser un where, on va utiliser HAVING.

HAVING c'est une autre commande c'est la troisième commande de cette vidéo et la dernière qu'on verra qui va vous permettre de filtrer d'accord des résultats issus d'un groupement de données d'accord d'un groupement d'information que vous avez récupèré.

Comment on peut faire ça ? par exemple, qu'est ce qu'on pourrait faire ? admettons qu'on peut récupérer la somme çad qu'on avait fait la somme des âges comme on avait jusqu'à présent et on peut dire par exemple d'indiquer en fait les pays où la somme de leurs âges et encore une fois dans un vrai cas d'utilisation ça n'aurait pas beaucoup d'utilité mais c'est pour l'exercice.

Un exemple on pourrait dire on veut récupérer les résultats et on veut avoir par exemple les pays pour lesquels la somme de l'âge des résidents dépasse par exemple un certain donc on peut dire par exemple dépasse 20 on va commencer par ça donc comment on va faire ça parce que ce sera plus simple avec un exemple.

On récupère toujours pareil le pays car justement le regroupement va se faire part ça. Je veux qu'on ait une ligne pour chaque pays.
```sql
	SELECT user_country
```
On va faire la somme de chacun des âges ça c'est important.
```sql
	SELECT user_country, SUM(user_age)
```
On récupère depuis une base de données pas de problème ok.
```sql
	SELECT user_country, SUM(user_age)
	FROM fv_users
```
On fait notre groupement par rapport au pays ça ça ne change pas.
```sql
	SELECT user_country, SUM(user_age)
	FROM fv_users
	GROUP BY user_country
```
Et le petit bonus c'est le fameux having, having c'est un peu comme un where d'accord qui va permettre de filtrer, qu'est ce que je lui dis ? hé bien cette fameuse somme là ici SUM() en fait je veux récupérer que les enregistrements dont la somme des âges dépasses, strictement supérieur par exemple à 20, on peut faire ce genre d'exemple.

+ notes.sql
```sql
	-- C:/Users/sam/OneDrive/Formations/FormationVideo/Ressources/SQL/cours/014_Grouper_resultats/data4.sql
	
	SELECT user_country, SUM(user_age)
	FROM fv_users
	GROUP BY user_country
	HAVING SUM(user_age) > 20;
```
Alors encore une fois l'utilité de cette requête bon et très discutable mais ça suffit par rapport à ce que je veux vous montrez.
```sql
	mysql> SELECT user_country, SUM(user_age)
		-> FROM fv_users
		-> GROUP BY user_country
		-> HAVING SUM(user_age) > 20;
	+--------------+---------------+
	| user_country | SUM(user_age) |
	+--------------+---------------+
	| France       |           107 |
	| Maroc        |            24 |
	| Sénégal      |            22 |
	| Japon        |            60 |
	| Italie       |            21 |
	| États-Unis   |            37 |
	+--------------+---------------+
	6 rows in set (0.00 sec)
```
On va ici et voilà donc toutes les sommes d'âge de chacun des pays qu'on a regroupé, dépasserait 20 ans au final, dépasserait 20 ans si on fait la somme des âges, seront récupérés dans cette requête.

Par exemple si on voit alors on a une seule personne qui vient de chine, elle a 16 ans et du coup comme ce n'est pas strictement supérieure à 20, si on fait la somme eh bien voyez qu'on a pas retourné la chine d'accord. 

On a les états unis puisqu'il ya qu une seule personne qui a 37 ans.

L'italie a une seule personne 21 etc etc.

Maintenant on peut être un peu plus strict et dire 50 et là il y aura forcément moins d'enregistrement, toutes les sommes qui sont inférieures ne passeront pas.
```sql
mysql> SELECT user_country, SUM(user_age)
    -> FROM fv_users
    -> GROUP BY user_country
    -> HAVING SUM(user_age) > 50;

+--------------+---------------+
| user_country | SUM(user_age) |
+--------------+---------------+
| France       |           107 |
| Japon        |            60 |
+--------------+---------------+
2 rows in set (0.00 sec)
```
Voilà la voyez du coup il n'y a que le japon et la france qui dont 30 ans.

Ca permet éventuellement comme ça de filtrer encore des résultats donc là il y a, vraiment une seule requête c'est ça qui est important qu'il faut comprendre, c'est qu'on peut sélectionner des données çad qu'au départ il faut voir comme ça parce qu'au niveau sql ces pas si compliqué que ça.

C'est pas plus compliqué que ça en fait on sélectionne un certain nombre d'informations d'accords alors généralement ces informations on prend plein plein de choses, on seclectionne plein de choses.


Ensuite de ces informations, on veut les présenter d'une certaine manière donc on effectue à un groupement avec le group by et ensuite on peut avant même de retourner le résultat parce qu'on veut pas forcément tout récupérer tout, n'importe, effectuer une petite clause là donc le fameux having qui permet de filtrer d'accord les résultats qu'on va recevoir parce qu'on n'a pas forcément envie de tout avoir.

On a besoin peut-être d'information bien spécifique bien particulière donc on utilise une clause having pour pouvoir filtrer le retour en fait de notre requête.

Donc n'hésitez pas à vous en servir aussi, à l'utiliser dans d'autres
exemples vous verrez que c'est très très très efficace.

On peut véritablement obtenir des résulttats bien bien filtrés en fait avec ce type de requête et on va pouvoir s'arrêter là.

De toute façon je vous avais dit que c'était pas très très long, qu'il n'y avait pas grand chose à voir un par rapport à d'autres d'autres séances s'était assez court voilà c'est ce qui englobe un peu justement ce groupement de résultats que vous pouvez obtenir une requête.

Le groupe by, le with rollup évidemment ça vous ne l'utiliserez peut-être pas très souvent mais c'est bien de le connaître je voulais vous le montrer et le fameux having qui lui sert énormément pour des résultats par rapport à des données qui ont été groupés donc c'est important de le savoir.

J'espère en tout cas que ça était suffisamment explicite suffisamment clair, n'hésitez pas à vous entraîner c'est très très très important parce que je vous présente toujours des détails pas trop long ce que je peux pas vous faire des exemples sur des tables qui ont 150 enregistrons ou autre voilà déjà ce serait un changement à chaque fois chaque séance et pas sur d'autres d'autres types de table pour vous faire un petit habituer à travailler sur des données différentes.

Et vous vraiment n'hésitez pas et comme je vous l'ai dit si vous ne voulez pas faire vous même vos propres tables, vos propres enregistrements et toujours vous trouvererez sur internet, des trucs comme ça donc vous pouvez éventuellement pour vous exerçer en sql.

Je vous dis à bientôt pour la suite, la prochaine séance, on a encore pas mal de choses à voir et je pense qu'on terminera ce cours aux alentours de la séance 22 je pense qu'il y a encore quelques vidéos à faire pour terminer ce cours donc on a encore les jointures à voir, on a des sous requêtes, on a pas mal de fonctions différentes, chiffrement, les fonctions sur les chaînes de caractères, les dates etc et on pourra clore cette formation à sql et vous aurez pas pour le coup plein plein de choses que vous aurez vu et que vous pourrez du coup utiliser avec éventuellement des langages de programmation ou simplement si un jour vous travaillez sur des bases de données.

A bientôt tout le monde pour la suite de ce cours sql