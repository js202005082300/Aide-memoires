# [13. Fonctions d'agrégation](https://www.youtube.com/watch?v=TnPLdAuGCzU)
01-01-21

[data2.sql](data2.sql)

Bonjour on se retrouve pour la 13e séance sql avec l'arrivée de pas mal de nouvelles choses que vous allez apprendre sur ce langage notamment l' usage de fonction qui vont permettre de réaliser certaines opérations bien précises au niveau de vos requêtes sql.

On va commencer dans cette vidéo avec quelques fonctions d'agrégation qui vont servir notamment à faire des stats ici, si par exemple vous avez besoin de compter le nombre d'enregistrements d'une table ou faire la moyenne de notes et d'étudiants, ce genre de choses, vous allez vous pouvoir justement vous servir de ses fonctions en sql pour pouvoir réaliser ces différentes opérations justement pour de requêtes.

On va regarder ça très rapidement.

J'ai repris alors au niveau des données pour montrer ici j'ai repris le fichier sql, c'est le data2.sql où vous avez les jeux vidéo mais vous pouvez évidemment suivre cette vidéo avec n'importe quelles autres données mais peu importe parce que vous avez dans votre table puisque c'est assez facile de tester ces différentes fonctions au niveau de nos fichiers sql.
```sql
SOURCE C:/SQL/cours/013_Fonctions_d_agregation/data2.sql
```
Alors première chose que nous allons voir déjà c'est une fonction qui est très très utile qui va permettre de compter un certain nombre d'enregistrements et qu'on va utiliser en fait par rapport à ça.

Alors généralement c'est une fonction qui va s'utiliser en fait avec son nom d'accord, on va avoir un nom de fonction.

La fonction et entre parenthèses le champ sur laquelle nous allons vouloir utiliser cette fonction.

Pour celle que nous allons voir pour commencer il y aura une exception, on ne va pas le faire sur un champ pour des raisons on va dire d'optimisation mais sur étoile c'est à dire sur l'ensemble des champs pour une table et en gros j'aimerais par exemple tout simplement compter le nombre de jeux qu'il y a d'enregistrer donc ça correspond en fait au nombre de ligne d'accords qui existent dans cette table-là et pour le faire on va passer par une requête select d'accord et au lieu de faire simplement un select de je ne sais pas quoi je vais utiliser la fonction COUNT() et je vais le faire sur les toiles d'accord, on ne va pas le mettre sur un champ mais sur l'étoile et ensuite évidemment FROM gv_games.

+ commandes.sql
```sql
	SELECT COUNT(*) FROM fv_games;
```
Ca va compter tout simplement la totalité des enregistrements de cette table et on va utiliser cette requête et là ça nous retourne tout simplement 20 d'accord.
```sql
	mysql> SELECT COUNT(*) FROM fv_games;
	+----------+
	| COUNT(*) |
	+----------+
	|       20 |
	+----------+
	1 row in set (0.00 sec)
```
Alors on peut utiliser des alias bien sûr ça ne pose aucun problème, on peut faire par exemple ceci.

+ commandes.sql
```sql
	SELECT COUNT(*) AS Total_jeu FROM fv_games;
```
Total_jeu, aucun problème à ça pour que ça vous retourne tout simplement voyez ici un résultat avec un champ nommé d'accord avec un alias que vous avez choisi voilà donc là je sais que j'ai 20 jeux qui ont été enregistrées en fait dans cette table comme ça peut être pratique, imaginez par exemple sur un blog où vous voulez récupérer le nombre d'articles ou savoir le nombre de messages d'un forum ou le nombre d'image dans une galerie ou le nombre de commentaires, on peut utiliser ce genre de fonctions là en sql pour le faire donc très très simple.

On va passer à d'autres petites fonctions d'agrégation très simple notamment une fonction pour la moyenne.

Ici bon pour le coup j'aurais un bon exemple à vous montrer puisqu'on a on a une table avec différents jeux vidéo notamment un prix ça peut être intéressant par exemple de se dire et bien quel est le prix moyen d'accords de la totalité des jeux que nous avons.

Donc ici on n'utilisera pas COUNT() alors on va utiliser la fonction AVG() d'accord pour average c'est la moyenne tout simplement et sur le champ en question donc moi ici c'est game_price.

+ commandes.sql
```sql
	SELECT AVG(game_price) FROM fv_games;
```
Je vais dire calculer la moyenne de prix de game_price dans la table fv_games voilà et là on aura la moyenne qui est retourné.
```sql
	mysql> SELECT AVG(game_price) FROM fv_games;
	+--------------------+
	| AVG(game_price)    |
	+--------------------+
	| 30.384500122070314 |
	+--------------------+
	1 row in set (0.00 sec)
```
Et donc on sait que la moyenne, on peut l'arrondir éventuellement par la suite si on veut mais on voit en tout cas que la moyenne est de 30 euros un peu plus de 30 euros par raport à ce que j'avais ici au niveau de la totalité des jeux de cette table.

Voilà très simple, COUNT() pour compter le nombre d'enregistrements, average donc AVG() pour tout simplement la moyenne et on a d'autres fonctions également et je vais les passer rapidement la fonction MAX() qui va retourner dans ce cas là le prix maximum de la table donc en gros le jeu le plus cher.

+ commandes.sql
```sql
	SELECT MAX(game_price) FROM fv_games;
```
+ client
```sql
	mysql> SELECT MAX(game_price) FROM fv_games;
	+-----------------+
	| MAX(game_price) |
	+-----------------+
	|            89.9 |
	+-----------------+
	1 row in set (0.00 sec)
```
Là on a le prix qu'est 89 alors si on veut savoir lequel c'est il faudrait retourner également le nom du jeu mais bon on peut faire par exemple game_title.

+ commandes.sql
```sql
	SELECT game_title, MAX(game_price) FROM fv_games;
```
+ client
```sql
	mysql> SELECT game_title, MAX(game_price) FROM fv_games;
	ERROR 1140 (42000): In aggregated query without GROUP BY, expression #1 of SELECT list contains nonaggregated column 'fv_database.fv_games.game_title'; this is incompatible with sql_mode=only_full_group_by
	mysql>
```
Et là évidemment c'est les choses qu'on n'a pas vu pour le moment puisque vous verrez que par la suite certes la voyez je fais une sélection sur un champ et une sélection ici avec une fonction et vous voyez qu'au niveau de l'erreur, on obtient une erreur et un petit peu bizarre d'accord et notamment on dit voilà qu'on a essayé de faire une fonction d'agrégation d'accord on fait une fonction d'agrégation sans utiliser un regroupement d'accord un groupement pour cette requête donc c'est des choses que nous verrons par la suite d'accord c'est pour ça que je voulais faire cette vidéo notamment sur les fonctions d'agrégats parce qu'on aura besoin de savoir qu'il y a ces choses-là en sql pour aborder ensuite d'autres choses très importantes en sql.

Donc ça plus tard on pourra le faire, on pourra par exemple dire et bien d'afficher en fait le jeu qui contient notamment le prix le plus cher d'accord c'est des choses très précises avec ce simple type de requête là ce n'est pas pour le moment possible donc on abordera tout ce qui est GROUP BY, HAVING, toutes ces choses là qui sont des petites subtilitées en plus en sql et qui nous serviront par la suite donc ça fera une bonne transition pour ça.

Donc là on veut rester sur max d'accord je vais montrer simplement ça.

+ commandes.sql
```sql
	SELECT MAX(game_price) FROM fv_games;
```
On a l'inverse qui est MIN() d'accord pour avoir le prix minimum ok.

+ commandes.sql
```sql
	SELECT MIN(game_price) FROM fv_games;
```
Alors c'est des fonctions qu'on peut utiliser également sur des chaînes de caractères comme celles qu'on peut classer par ordre alphabétique selon le champ en fait des chaînes de caractères et bien elle est plus petites ou plus grande qu'on peut faire pas forcément sur une valeur numérique mais on peut le faire également sur des chaînes de caractères.

Et ensuite ce qui peut être pas mal par exemple ce qui peut être intéressant c'est de calculer par exemple le nombre de jeux au total que j'ai càd que là j'ai le nombre d'enregistrements certain que le nombre de jeux est différent d'accords c'est ce qu'on avait fait tout à l'heure avec COUNT() mais moi j'aimerais savoir le nombre de jeux réellement que j'ai et on a un nombre ici qui est notamment le game_stock donc on peut s'amuser à faire la somme donc c'est tout simplement somme de game_stock comme ceci.

+ commandes.sql
```sql
	SELECT SUM(game_stock) FROM fv_games;
```
Vraiment le nombre de jeux au total et là on voit qu'on en a 80 donc ça a fait la somme de toutes ces valeurs ici.
```sql
	mysql> SELECT SUM(game_stock) FROM fv_games;
	+-----------------+
	| SUM(game_stock) |
	+-----------------+
	|              80 |
	+-----------------+
	1 row in set (0.00 sec)
```
C'est +1 +5 etc etc tout ça en fait, je tombe sur 80 tout pile voilà très pratique quelques petites fonctions d'agrégation comme ça.

Si vous avez besoin de faire des statistiques de récupérer certaines informations bien précises comme je vous l'ai montré ici sur cette vidéo, vous avez toutes ces petites fonctions sql pour le faire.

Voilà on va s'arrêter là donc la vidéo était très courte et il y avait pas grand chose a montré alors selon les normes du langage sql il existe d'autres fonctions on a ANY / SOME etc et notamment pour aussi reprendre par exemple tous les enregistrements mais ce sont des fonctions malgré le fait qu'elle soit écrite dans la norme de sql qui ne sont pas implémentées voir même pas disponible dans une majorité de systèmes de gestion de bases de données.

Moi je vous montre celle qui marche partout et après il y en a évidemment d'autres mais comme elles ne sont pas fonctionnels sur mysql, postgresql et sql etc ça ne valait pas forcément le coup de les faire. Vous ne pourrez pas de toute façon les utiliser pour la majorité.

Vous pourrez vous contenter de ça et n'hésitez pas à les utiliser un petit peu justement sur les différentes données que vous avez, à vous faire encore une fois vos petit fichier d'enregistrement et vous pouvez mettre pas mal de table et d'enregistrement dans une base pour tester un petit peu tout ça et puis voir un peu comment ça fonctionne.

Je vous dis à bientôt pour une prochaine séance sql donc on verra d'autres fonctions, on n'a pas mal d'autres fonctions à voir et on verra bien sûr d'autres fonctionnalités aussi qui sont qui peuvent être mises en tout cas en place au niveau de nos requêtes sql.

A bientôt pour une prochaine vidéo