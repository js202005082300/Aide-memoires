# [10. Filtrer requêtes](https://www.youtube.com/watch?v=jLQ7r6a9aiA)
30-12-20

[data2.sql](data2.sql)

Bonjour à tous bienvenue sur le cours sql, on se retrouve avec cette séance 10 pour voir comment filtrer un petit peu nos requêtes.

Alors dernièrement on avait vu comment lire des données avec une commande très très simple à utiliser au départ en tout cas mais qui va nous servir énormément qui est la commande select.

Et là on va ajouter à cette commande en fait une clause, la fameuse clause WHERE qui va nous permettre via quelques systèmes on va dire de conditions ou certains mots on va dire spécifique de filtrer tout simplement les résultats que nous allons récupérer.

Alors on va commencer déjà par ajouter des données via un fichier sql, importer un ensemble de données comme on avait fait dans la vidéo précédente.

Dans la description de la vidéo vous allez pouvoir récupérer un fichier ici de données d'accord donc il n'y a pas besoin d'aller voir ce qu'il y a à l'intérieur, peu importe on s'en fiche, c'est juste pour pouvoir importer en fait une table avec des enregistrements pour voir un petit peu comment que ça se passe.

Alors on va directement passer à ça et j'ai déjà préparé la commande pour éviter de la refaire à la main ici pour importer donc mon serveur sql est lancé et là j'ai eu un autre terminal pour le client donc on va lancer ce dernier voilà.
```powershell
	>mysql --console
	
	>mysql -u root -p
```
Alors à partir d'ici je mets ma commande, je l'exécute plusieurs fois pour être sûr tout est bien passé et normalement ça va être bon
```sql
	SOURCE C:/SQL/cours/010_Filtrer_requetes/data2.sql
```
Du coup je vais faire show databases donc je vais assez vite.
```sql
	mysql> show databases;
	+--------------------+
	| Database           |
	+--------------------+
	| fv_database        |
	| information_schema |
	| mysql              |
	| performance_schema |
	| sys                |
	+--------------------+
	5 rows in set (0.00 sec)
```
On retrouve normalement fv_database qu'on va utiliser cette bases de données donc c'est le même nom que celui vu précédemment simplement qu'on a plus du tout les mêmes tables donc là si on fait un petit show tables.
```sql
	mysql> use fv_database;
	Database changed
	mysql> show tables;
	+-----------------------+
	| Tables_in_fv_database |
	+-----------------------+
	| fv_games              |
	+-----------------------+
	1 row in set (0.01 sec)
```
Voilà ce que nous avons. Nous n'avons plus qu'une seule table comparé à la vidéo précédente où on avait d'autres choses donc on va directement faire ce qu'on a déjà fait jusqu'à présent c'est à dire sélectionner par exemple tous les enregistrements d'une table par défaut.

Ca on l'avait déjà vu je rappelle select * from le nom de la table, n'oubliez pas le point virgule et voilà donc cette table que vous venez d'importer du coup pour cette séance là qui va nous permettre d'aborder justement la fameuse clause WHERE pour filtrer nos données.
```sql
	SELECT * FROM fv_games;
```
```sql
mysql> SELECT * FROM fv_games;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|       1 | Final Fantasy VII                             | 1997-11-17       |      12.99 |          7 |
|       2 | God of War : Ascension                        | 2013-03-13       |      22.75 |          1 |
|       3 | Gran Turismo 5                                | 2010-11-24       |         25 |          1 |
|       4 | Tekken                                        | 1995-11-03       |       59.9 |          1 |
|       5 | Euro Truck Simulator 2                        | 2012-10-19       |       8.99 |          5 |
|       6 | Professeur Layton et l'Héritage des Aslantes  | 2013-11-08       |      74.99 |          3 |
|       7 | Pokémon Let's Go, Pikachu                     | 2018-11-16       |      44.39 |          2 |
|       8 | Pokémon Let's Go, Évoli                       | 2018-11-16       |      44.39 |          2 |
|       9 | Sea of Thieves                                | 2018-03-20       |      34.99 |         10 |
|      10 | Fortnite Battle Royale                        | 2017-09-28       |          0 |          7 |
|      11 | World of Warcraft                             | 2005-02-11       |      14.51 |         15 |
|      12 | Tekken 3                                      | 1998-09-12       |       89.9 |          1 |
|      13 | Rocket League                                 | 2015-07-07       |      21.99 |          6 |
|      14 | The Legend of Zelda : Ocarina of Time         | 1998-12-11       |       14.9 |          4 |
|      15 | Minecraft                                     | 2011-11-18       |      18.48 |          2 |
|      16 | Life is Strange - épisode 1                   | 2015-01-30       |          0 |          1 |
|      17 | Devil May Cry 2                               | 2003-04-03       |         57 |          3 |
|      18 | Skylanders : Spyro's Adventure                | 2011-10-14       |      19.95 |          4 |
|      19 | Forza Horizon 4                               | 2018-10-02       |      35.99 |          4 |
|      20 | Grand Theft Auto : San Andreas                | 2004-10-29       |       6.58 |          1 |
+---------+-----------------------------------------------+------------------+------------+------------+
20 rows in set (0.01 sec)
```
Alors c'est une table qui répertorie en fait des jeux vidéo tout simplement donc vous avez le nom du jeu en question, vous avez sa date de sortie, vous avez un prix d'accord et vous avez également un nombre de ce jeu en stock.

On pourrait imaginer par exemple un stock d'un magasin.

vous avez toutes ces infos là et on va pouvoir comme ça travailler avec ces petites infos donc une seule table ça suffisait par rapport à ce qu'on va voir sur cette séance.

A partir de là nous allons voir comment filtrer ces données avec le mot clé justement qui va nous servir, la clause WHERE.

La clause WHERE va pouvoir utiliser plein d'autres choses également pour faire des conditions ou en tout cas des filtres bien précis.

Alors je vais le noter ici comme d'habitude la commande comme ça après y'a plus qu'à copier coller dans le terminal ça va beaucoup plus vite donc jusqu'à présent ou faisait ce genre de chose et on mettait directement point virgule pour terminer la requête. 

+ commandes.sql
```sql
	SELECT *FROM fv_games;
```
Nous nous allons pouvoir rajouter une clause where d'accord suivi ensuite d'une condition alors la clause where, elle peut utiliser tout un ensemble d'opérateurs comme en gros donc les opérateurs si les listes ici pour faire rapidement, vous allez avoir l'opérateur d'égalité = d'accord tout simplement donc c'est un seul égale attention ce n'est pas un double comme dans les langages de programmation. Vous avez l'opérateur de différence != et ensuite on retrouve donc je vais allez très vite les opérateurs habituels > < <= >=.

+ commandes.sql
```sql
	/*
		= égalité
		!= différence
		> < <= >=
	*/
	SELECT *FROM fv_games WHERE ;
```
Voilà les différents opérateurs dits de comparaison que l'on va retrouver d'accord donc je vous les ai noté ici rapidement pour et vous pouvez mettre en pause la vidéo si vous voulez les noter de côtés mais on retrouve de toute façon cela un petit peu partout.

La seule différence ici c'est que pour l'égalité ce n'est pas un double égale comme dans un langage de programmation mais un simple égale ici parce qu'on n'a pas d'histoire d'affectation en sql.

Voilà alors du coup qu'est-ce que je peux faire ? et bien je vais pouvoir faire une condition sur un champ de ma table en particulier par exemple admettons que je veuille le jeu qui a notre clé primaires par exemple celui qui aurait l'identifiant numéro 11 donc je peux sans problème dire tu me sélectionne toutes les informations d'accord depuis la table fv_games où (where) l'identifiant donc id_game = par exemple je sais pas on peut retourner le 11e, l'identifiant numéro 11.

+ commandes.sql
```sql
	/*
		= égalité
		!= différence
		> < <= >=
	*/
	SELECT *FROM fv_games WHERE id_game = 11;
```
Donc ici en faisant simplement ça je copie colle la requête et on va du coup récupérer l'enregistrement qui a bien l'identifiant numéro 11.
```sql
mysql> SELECT *FROM fv_games WHERE id_game = 11;
+---------+-------------------+------------------+------------+------------+
| id_game | game_title        | game_releaseDate | game_price | game_stock |
+---------+-------------------+------------------+------------+------------+
|      11 | World of Warcraft | 2005-02-11       |      14.51 |         15 |
+---------+-------------------+------------------+------------+------------+
1 row in set (0.01 sec)
```
Donc voilà un premier filtre que nous avons appliqué càd en disant voilà que l'on veut cet identifiant précis.

Du coup on peut également tout simplement dire tous les jeux dont l'identifiant est supérieur par exemple à 5 alors encore une fois travailer sur identifions ici ça n'a pas vraiment d'intérêt mais c'est pour montrer que ça marche bien et du coup
voilà.

+ commandes.sql
```sql
	SELECT *FROM fv_games WHERE id_game > 5;
```
```sql
mysql> SELECT *FROM fv_games WHERE id_game > 5;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|       6 | Professeur Layton et l'Héritage des Aslantes  | 2013-11-08       |      74.99 |          3 |
|       7 | Pokémon Let's Go, Pikachu                     | 2018-11-16       |      44.39 |          2 |
|       8 | Pokémon Let's Go, Évoli                       | 2018-11-16       |      44.39 |          2 |
|       9 | Sea of Thieves                                | 2018-03-20       |      34.99 |         10 |
|      10 | Fortnite Battle Royale                        | 2017-09-28       |          0 |          7 |
|      11 | World of Warcraft                             | 2005-02-11       |      14.51 |         15 |
|      12 | Tekken 3                                      | 1998-09-12       |       89.9 |          1 |
|      13 | Rocket League                                 | 2015-07-07       |      21.99 |          6 |
|      14 | The Legend of Zelda : Ocarina of Time         | 1998-12-11       |       14.9 |          4 |
|      15 | Minecraft                                     | 2011-11-18       |      18.48 |          2 |
|      16 | Life is Strange - épisode 1                   | 2015-01-30       |          0 |          1 |
|      17 | Devil May Cry 2                               | 2003-04-03       |         57 |          3 |
|      18 | Skylanders : Spyro's Adventure                | 2011-10-14       |      19.95 |          4 |
|      19 | Forza Horizon 4                               | 2018-10-02       |      35.99 |          4 |
|      20 | Grand Theft Auto : San Andreas                | 2004-10-29       |       6.58 |          1 |
+---------+-----------------------------------------------+------------------+------------+------------+
15 rows in set (0.00 sec)
```
Tout ce qui est du coup supérieur à 5.

Voilà un petit peu le genre de possibilités que nous avons.

Alors ça c'est une possibilité on peut également ajouter une autre condition par la suite avec d'autres opérateurs pour cumuler en fait des tests dont vous avez le AND qui permet d'en faire plusieurs donc je pense que c'est assez clair pour tout le monde et le OR qui est tout simplement le ou d'accords vérifier une chose ou une chose.

+ commandes.sql
```sql
	/*
		AND : et
		OR : ou
	*/
	SELECT *FROM fv_games WHERE id_game = 5 OR id_game = 10;
```
Par exemple on peut dire tu retourne tous les enregistrements où l'identifiant est égal à 5 (pas ET parce que ce n'est pas possible qu'il en égal 2) ou alors pour l'identifiant qui est égale à 10 d'accord donc l'un ou l'autre. On fait ça et
là du coup nous récupérons bien l'enregistrement avec l'identifiant id 5 et id 10 d'accords parce ce que c'est soit l'un ou l'autre donc il va retourner ces deux enregistrements là.
```sql
mysql> SELECT *FROM fv_games WHERE id_game = 5 OR id_game = 10;
+---------+------------------------+------------------+------------+------------+
| id_game | game_title             | game_releaseDate | game_price | game_stock |
+---------+------------------------+------------------+------------+------------+
|       5 | Euro Truck Simulator 2 | 2012-10-19       |       8.99 |          5 |
|      10 | Fortnite Battle Royale | 2017-09-28       |          0 |          7 |
+---------+------------------------+------------------+------------+------------+
2 rows in set (0.00 sec)
```
Voilà une possibilité.

Après si on fait par exemple une vérification avec un AND on peut par exemple le faire sur le prix, on peut très bien s'amuser à faire game_price > 5 AND game_price < 30 et dans ce cas-là, on retournera tous les jeux qui sont entre 5 et 30 euros par exemple, alors pareil un petit copier coller et voilà.

+ commandes.sql
```sql
	SELECT *FROM fv_games WHERE game_price > 5 AND game_price < 30;
```
```sql
mysql> SELECT *FROM fv_games WHERE game_price > 5 AND game_price < 30;
+---------+---------------------------------------+------------------+------------+------------+
| id_game | game_title                            | game_releaseDate | game_price | game_stock |
+---------+---------------------------------------+------------------+------------+------------+
|       1 | Final Fantasy VII                     | 1997-11-17       |      12.99 |          7 |
|       2 | God of War : Ascension                | 2013-03-13       |      22.75 |          1 |
|       3 | Gran Turismo 5                        | 2010-11-24       |         25 |          1 |
|       5 | Euro Truck Simulator 2                | 2012-10-19       |       8.99 |          5 |
|      11 | World of Warcraft                     | 2005-02-11       |      14.51 |         15 |
|      13 | Rocket League                         | 2015-07-07       |      21.99 |          6 |
|      14 | The Legend of Zelda : Ocarina of Time | 1998-12-11       |       14.9 |          4 |
|      15 | Minecraft                             | 2011-11-18       |      18.48 |          2 |
|      18 | Skylanders : Spyro's Adventure        | 2011-10-14       |      19.95 |          4 |
|      20 | Grand Theft Auto : San Andreas        | 2004-10-29       |       6.58 |          1 |
+---------+---------------------------------------+------------------+------------+------------+
10 rows in set (0.00 sec)
```
Et si on vérifie game_price on voit bien que du coup ça ne dépasse pas d'accord on verra plus tard vous verrez que l'on peut ordonner un petit peu les résultats de nos requêtes. On va voir ça sur la vidéo par la suite donc voilà comment on peut via cette clause WHERE justement faire pas mal de petits filtres pour trier en fait tout simplement filtrer les résultats que l'on obtient de notre requête donc ça ne va pas renvoyer tous les enregistrements data mais seulement ceux qui valide et bien tout ce que vous avez mit dans votre clause WHERE qui a plusieurs conditions ou pas d'ailleurs.

Voilà pour le début très simplement les différents opérateurs de comparaison et vous pouvez faire plusieurs tests d'accord en fonction.

Nous avons d'autres mots clés bien pratique également pour nos petites conditions notamment quand vous devez par exemple vérifier une liste de valeurs.

Moi par exemple j'aimerais qu'ils puissent me dire bah tu vas me retourner tous les jeux par exemple qui ont un stock par exemple qui est de 1, de 4 ou de 6 admettons.

Voyez il y a une liste de valeur possible que j'aimerais faire alors plutôt que d'éviter de faire un or à chaque fois et encore un deuxième ce qui va cumuler en fait les nombres en fait de conditions je peux faire plus rapide en faisant tout simplement IN(2, 4, 6).

+ commandes.sql
```sql
	SELECT * FROM fv_games WHERE game_stock=2 OR game_stock=4 OR game_stock=6;
	//-->
	SELECT * FROM fv_games WHERE game_stock IN(2, 4, 6);
```
Vous pouvez passer par dont la liste entre parenthèses avec les valeurs différentes séparées pas des virgules.

Si c'est quelque chose qui est sous forme de chaîne évidemment vous mettez des guillemets ou des doubles guillemets en fonction donc c'est à voir en fonction du type de données récupérées.
```sql
	SELECT * FROM fv_games WHERE game_stock IN('2', '4', '6');
```
En faisant ça du coup voilà je récupère tous les jeux qui sont en 2 4 ou 6 exemplaires, pas les autres d'accord.
```sql
mysql> SELECT * FROM fv_games WHERE game_stock IN(2, 4, 6);
+---------+---------------------------------------+------------------+------------+------------+
| id_game | game_title                            | game_releaseDate | game_price | game_stock |
+---------+---------------------------------------+------------------+------------+------------+
|       7 | Pokémon Let's Go, Pikachu             | 2018-11-16       |      44.39 |          2 |
|       8 | Pokémon Let's Go, Évoli               | 2018-11-16       |      44.39 |          2 |
|      13 | Rocket League                         | 2015-07-07       |      21.99 |          6 |
|      14 | The Legend of Zelda : Ocarina of Time | 1998-12-11       |       14.9 |          4 |
|      15 | Minecraft                             | 2011-11-18       |      18.48 |          2 |
|      18 | Skylanders : Spyro's Adventure        | 2011-10-14       |      19.95 |          4 |
|      19 | Forza Horizon 4                       | 2018-10-02       |      35.99 |          4 |
+---------+---------------------------------------+------------------+------------+------------+
7 rows in set (0.00 sec)
```
Tous les autres ne sont pas récupéré du coup donc là on récupère bien la quantité du coup qui est voulu par rapport à ça donc ce petit mot clé IN() permet de raccourcir un petit peu la taille de votre cadre, ce qui permet de gagner pas mal de temps quand même.

Voilà pour une des possibilités encore qui existent par rapport à ça.

On peut également travailler sur une intervalle de valeur donc plutôt que d'éviter par exemple de faire tant que game_price > 0 AND game_price <= 20. Voilà pareil cette écriture là, on va pouvoir la changer avec un autre mot qui est tout simplement BETWEEN 0 AND 20.

+ commandes.sql
```sql
	SELECT * FROM fv_games WHERE game_price > 0 AND game_price <= 20;
	//-->
	SELECT * FROM fv_games WHERE game_price BETWEEN 0 AND 20;
```
Et du coup ça nous évitera tout simplement voilà de faire chaque fois des AND AND et cetera.
```sql
mysql> SELECT * FROM fv_games WHERE game_price BETWEEN 0 AND 20;
+---------+---------------------------------------+------------------+------------+------------+
| id_game | game_title                            | game_releaseDate | game_price | game_stock |
+---------+---------------------------------------+------------------+------------+------------+
|       1 | Final Fantasy VII                     | 1997-11-17       |      12.99 |          7 |
|       5 | Euro Truck Simulator 2                | 2012-10-19       |       8.99 |          5 |
|      10 | Fortnite Battle Royale                | 2017-09-28       |          0 |          7 |
|      11 | World of Warcraft                     | 2005-02-11       |      14.51 |         15 |
|      14 | The Legend of Zelda : Ocarina of Time | 1998-12-11       |       14.9 |          4 |
|      15 | Minecraft                             | 2011-11-18       |      18.48 |          2 |
|      16 | Life is Strange - épisode 1           | 2015-01-30       |          0 |          1 |
|      18 | Skylanders : Spyro's Adventure        | 2011-10-14       |      19.95 |          4 |
|      20 | Grand Theft Auto : San Andreas        | 2004-10-29       |       6.58 |          1 |
+---------+---------------------------------------+------------------+------------+------------+
9 rows in set (0.01 sec)
```
donc BETWEEN est un autre mot également à connaître.

Vous voyez qu'il y a pas mal de choses qui s'ajoute justement à cette clause WHERE et qui vous permettent du coup de faire vraiment des requêtes très très spécifiques en fonction de ce que vous voulez récupérer comme information donc on a vu IN, on a vu BETWEEN, on a vu où également les opérateurs de comparaison avec la possibilité de cumuler des vérifications et on également d'autres petits mots comme ça qui viennent s'ajouter qui sont vachement pratique par rapport à cette clause WHERE.

Notamment la possibilité tout simplement de faire une vérification sur une certaine chaîne de caractères.

Si on regarde les jeux complets donc je vais faire un petit SELECT*FROM fv_games; ... c'est pour ça que je vous avais dit d'importer ces données là parce que j'ai fait exprès justement qu'il ait des données un peu similaire pour ce genre de choses que et que vous puissez comme ça vous entraîner ensuite au niveau de vos requêtes.
```sql
mysql> select * from fv_games;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|       1 | Final Fantasy VII                             | 1997-11-17       |      12.99 |          7 |
|       2 | God of War : Ascension                        | 2013-03-13       |      22.75 |          1 |
|       3 | Gran Turismo 5                                | 2010-11-24       |         25 |          1 |
|       4 | Tekken                                        | 1995-11-03       |       59.9 |          1 |
|       5 | Euro Truck Simulator 2                        | 2012-10-19       |       8.99 |          5 |
|       6 | Professeur Layton et l'Héritage des Aslantes  | 2013-11-08       |      74.99 |          3 |
|       7 | Pokémon Let's Go, Pikachu                     | 2018-11-16       |      44.39 |          2 |
|       8 | Pokémon Let's Go, Évoli                       | 2018-11-16       |      44.39 |          2 |
|       9 | Sea of Thieves                                | 2018-03-20       |      34.99 |         10 |
|      10 | Fortnite Battle Royale                        | 2017-09-28       |          0 |          7 |
|      11 | World of Warcraft                             | 2005-02-11       |      14.51 |         15 |
|      12 | Tekken 3                                      | 1998-09-12       |       89.9 |          1 |
|      13 | Rocket League                                 | 2015-07-07       |      21.99 |          6 |
|      14 | The Legend of Zelda : Ocarina of Time         | 1998-12-11       |       14.9 |          4 |
|      15 | Minecraft                                     | 2011-11-18       |      18.48 |          2 |
|      16 | Life is Strange - épisode 1                   | 2015-01-30       |          0 |          1 |
|      17 | Devil May Cry 2                               | 2003-04-03       |         57 |          3 |
|      18 | Skylanders : Spyro's Adventure                | 2011-10-14       |      19.95 |          4 |
|      19 | Forza Horizon 4                               | 2018-10-02       |      35.99 |          4 |
|      20 | Grand Theft Auto : San Andreas                | 2004-10-29       |       6.58 |          1 |
+---------+-----------------------------------------------+------------------+------------+------------+
20 rows in set (0.00 sec)
```
On voit donc dans la liste de jeux par exemple et j'aimerais me récupérer eh bien tous les jeux qui vont commencer par pokémon par exemple donc ce que je vais faire et imaginons que vous ne voyez pas ces données là voilà et vous venez d'importer la base de donnée avec toutes les tables, les enregistrements etc.

Vous ne savez absolument pas ce qu'il y a ou vous devez faire des statistiques eh bien vous feriez tout simplement votre requête donc vous allez dire moi je vais récupérer toutes les infos SELECT*FROM donc depuis ma table fv_games WHERE tout simplement le titre du coup game_title qui commence donc on utilise le mot clé ici LIKE, qui commence par 'Pokemon' donc on respecte bien la case minuscules, majuscules etc et ensuite le nom peut se poursuivre avec n'importe quoi donc pour dire n'importe quoi qui vient après on met tout tout simplement un %.

+ commandes.sql
```sql
	SELECT * FROM fv_games WHERE game_title LIKE 'Pokémon%';
```
Si on veut n'importe quoi avant on mettra % avant comme ceci, on peut bien sûr cumuler les deux, il n'y a pas de problème. 

+ commandes.sql
```sql
	SELECT * FROM fv_games WHERE game_title LIKE '%Pokémon%';
```
Nous on veut juste que le nom du jeu commence par pokémon et après peu importe ce qu'il y a derrière peu importe, peut importe le nom on fait ça.
```sql
mysql> SELECT * FROM fv_games WHERE game_title LIKE 'Pokémon%';
+---------+----------------------------+------------------+------------+------------+
| id_game | game_title                 | game_releaseDate | game_price | game_stock |
+---------+----------------------------+------------------+------------+------------+
|       7 | Pokémon Let's Go, Pikachu  | 2018-11-16       |      44.39 |          2 |
|       8 | Pokémon Let's Go, Évoli    | 2018-11-16       |      44.39 |          2 |
+---------+----------------------------+------------------+------------+------------+
2 rows in set (0.00 sec)
```
Du coup avec ce type de requête ici, on va filtrer seulement selon le nom ici et vous voyez donc qu'il a bien retourné ces résultats là.

On peut tester ce genre de choses, je peux même faire la même chose avec Tekken dont j'en ai plusieurs aussi dans les enregistrements en faisant ça et voilà.
```sql
mysql> SELECT * FROM fv_games WHERE game_title LIKE 'Tekken%';
+---------+------------+------------------+------------+------------+
| id_game | game_title | game_releaseDate | game_price | game_stock |
+---------+------------+------------------+------------+------------+
|       4 | Tekken     | 1995-11-03       |       59.9 |          1 |
|      12 | Tekken 3   | 1998-09-12       |       89.9 |          1 |
+---------+------------+------------------+------------+------------+
2 rows in set (0.00 sec)
```
Il ne retourne du coup les jeux Tekken et Tekken 3, on peut faire ce genre de choses.

Voilà au niveau du mot-clé like qui est bien pratique.

On pas aussi donc rajouter d'autres choses parce que je vous ai parlé du petit % et il peut y avoir plein de plein de caractère derrière un ou plusieurs d'accord mais si on veut absolument qu'une seule chose, on mettra tout simplement un underscore d'accord.
```sql
	SELECT * FROM fv_games WHERE game_title LIKE 'Tekken_';
```
Là je crois que je n'avais pas prévu d'enregistrer ça mais en gros il prendra que des choses par exemple qui s'appelle Tekken ou Tekken 1 et 2 si le chiffre venait par exemple juste après le nom donc en étant collés (Tekken1 et Tekken2) donc là de toute façon logiquement si je fais ça voilà ça nous met Empty set donc il y a aucun résultat qui est retourné et donc  il y a aucun jeu en fait qui s'appelle tekken suivi directement sans espace en fait de quelque chose que ce soit d'un chiffre ou d'une lettre donc il faut voir par rapport à ça.
```sql
	mysql> SELECT * FROM fv_games WHERE game_title LIKE 'Tekken_';
	Empty set (0.00 sec)
```
En tout cas sachez vous avez cette possibilité là dans le like d'accord à la base du `%`.

`_` ça c'est un seul caractère et le `%` c'est un ou plusieurs.

C'est vraiment différent il faut faire attention entre les deux voilà pour l'utilisation de là et donc j'enchaîne assez vite les exemples parce que c'est quand même très simple après si vous voulez bien sûr vous exercez là il faudra tester, faire plein d'autres types de requêtes en utilisant ces mots et dans la playlist d'exercice du sql vous serez amenés de toute façon mettre en pratique tous ces différentes choses sur des cas un peu plus concret donc moi je les passe assez vite puisque c'est quand même je pense très simple à comprendre donc on peut on peut passer assez vite sur chacun.

On en a quelques petits derniers aussi qui sont intéressants parce ce que vous saviez dans les données qu'on manipule en sql qu'on pouvait très bien avoir des données par exemple qui sont nulles ou not nul donc pareil on peut sans problème dire par exemple tu retournes un jeu dont le prix par exemple n'est pas nul.

+ commandes.sql
```sql
	SELECT * FROM fv_games WHERE game_price IS NOT NULL;
```
Voilà tous les jeux dont le prix n'est pas nul.
```sql
mysql> SELECT * FROM fv_games WHERE game_price IS NOT NULL;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|       1 | Final Fantasy VII                             | 1997-11-17       |      12.99 |          7 |
|       2 | God of War : Ascension                        | 2013-03-13       |      22.75 |          1 |
|       3 | Gran Turismo 5                                | 2010-11-24       |         25 |          1 |
|       4 | Tekken                                        | 1995-11-03       |       59.9 |          1 |
|       5 | Euro Truck Simulator 2                        | 2012-10-19       |       8.99 |          5 |
|       6 | Professeur Layton et l'Héritage des Aslantes  | 2013-11-08       |      74.99 |          3 |
|       7 | Pokémon Let's Go, Pikachu                     | 2018-11-16       |      44.39 |          2 |
|       8 | Pokémon Let's Go, Évoli                       | 2018-11-16       |      44.39 |          2 |
|       9 | Sea of Thieves                                | 2018-03-20       |      34.99 |         10 |
|      10 | Fortnite Battle Royale                        | 2017-09-28       |          0 |          7 |
|      11 | World of Warcraft                             | 2005-02-11       |      14.51 |         15 |
|      12 | Tekken 3                                      | 1998-09-12       |       89.9 |          1 |
|      13 | Rocket League                                 | 2015-07-07       |      21.99 |          6 |
|      14 | The Legend of Zelda : Ocarina of Time         | 1998-12-11       |       14.9 |          4 |
|      15 | Minecraft                                     | 2011-11-18       |      18.48 |          2 |
|      16 | Life is Strange - épisode 1                   | 2015-01-30       |          0 |          1 |
|      17 | Devil May Cry 2                               | 2003-04-03       |         57 |          3 |
|      18 | Skylanders : Spyro's Adventure                | 2011-10-14       |      19.95 |          4 |
|      19 | Forza Horizon 4                               | 2018-10-02       |      35.99 |          4 |
|      20 | Grand Theft Auto : San Andreas                | 2004-10-29       |       6.58 |          1 |
+---------+-----------------------------------------------+------------------+------------+------------+
20 rows in set (0.00 sec)
```
Voilà donc là il nous a retourné évidemment tout parce que j'avais fait vingt enregistrements pour information, de toute façon je crois que j'avais pas laisser de valeur à null parce que j'avais mis tout à not null dans la création de la table donc on peut dire aussi linverse dire voilà dont le prix est null.
```sql
	mysql> SELECT * FROM fv_games WHERE game_price IS NULL;
	Empty set (0.00 sec)
```
logiquement il va rien vous retourner parce qu'il n'y en avait aucun voilà d'accord mais si un jour vous avez par exemple un des champs de table qui est nul sachez qu'en utilisant IS NULL dans le WHERE avec is null à la fin, ça permet de faire la vérification en fait que le champ game_price est éventuellement null.

Eventuellement il vous filtrera ces résultats là, il vous les retournera via le select donc c'est quelque chose qu'on peut utiliser.

Voilà donc grosso mode si je résume vous avez vu donc évidemment tous les opérateurs de comparaison avec and et or d'accord.

+ commandes.sql
```sql
	AND, OR
```
On a vu également IN, on a vu between donc je les passe très rapidement.

+ commandes.sql
```sql
	AND, OR
	IN,BETWEEN
```
On a vu le like, on a vu is null et on a vu le is not null.

+ commandes.sql
```sql
	AND, OR
	IN,BETWEEN, LIKE, IS NULL, IS NOT NULL
```
Voilà en gros tous les petits mots clés que je vous ai montré pour compléter votre clause WHERE et du coup filtrer un petit peu les résultats de vos requêtes.

Voilà pour cette partie.

On va terminer parce que la vidéo n'est pas très très longue pour le coup avec quelques autres mots qui vont permettre là en l'occurrence de trier les données que vous allez récupérer ou éventuellement de limiter le nombre de résultats que vous récupérez donc que j'ai mis dans cette vidéo parce que j'allais pas faire une vidéo juste pour ces deux petits points de détail-là parce que ce sont des choses très courte à voir donc je les inclus du coup dans cette vidéo sur notamment le filtrage des données.

Alors à partir d'ici et je vous l'ai dit tout à l'heure parce que j'aimerais par exemple c'est récupérer tous mes jeux mais rangés par ordre alphabétique concernant le titre du jeu.

Bon pour le faire tout simplement je vais faire un select * from fv_games voilà je ne vais pas mettre de where parce que je m'en fiche par rapport à ça mais je vais utiliser order by et ensuite spécifier l'ordre qu'il faut alors par défaut vous avez vu que si je fais un simple select comme ça de fv_games
```sql
mysql> select * from fv_games;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|       1 | Final Fantasy VII                             | 1997-11-17       |      12.99 |          7 |
|       2 | God of War : Ascension                        | 2013-03-13       |      22.75 |          1 |
|       3 | Gran Turismo 5                                | 2010-11-24       |         25 |          1 |
|       4 | Tekken                                        | 1995-11-03       |       59.9 |          1 |
|       5 | Euro Truck Simulator 2                        | 2012-10-19       |       8.99 |          5 |
|       6 | Professeur Layton et l'Héritage des Aslantes  | 2013-11-08       |      74.99 |          3 |
|       7 | Pokémon Let's Go, Pikachu                     | 2018-11-16       |      44.39 |          2 |
|       8 | Pokémon Let's Go, Évoli                       | 2018-11-16       |      44.39 |          2 |
|       9 | Sea of Thieves                                | 2018-03-20       |      34.99 |         10 |
|      10 | Fortnite Battle Royale                        | 2017-09-28       |          0 |          7 |
|      11 | World of Warcraft                             | 2005-02-11       |      14.51 |         15 |
|      12 | Tekken 3                                      | 1998-09-12       |       89.9 |          1 |
|      13 | Rocket League                                 | 2015-07-07       |      21.99 |          6 |
|      14 | The Legend of Zelda : Ocarina of Time         | 1998-12-11       |       14.9 |          4 |
|      15 | Minecraft                                     | 2011-11-18       |      18.48 |          2 |
|      16 | Life is Strange - épisode 1                   | 2015-01-30       |          0 |          1 |
|      17 | Devil May Cry 2                               | 2003-04-03       |         57 |          3 |
|      18 | Skylanders : Spyro's Adventure                | 2011-10-14       |      19.95 |          4 |
|      19 | Forza Horizon 4                               | 2018-10-02       |      35.99 |          4 |
|      20 | Grand Theft Auto : San Andreas                | 2004-10-29       |       6.58 |          1 |
+---------+-----------------------------------------------+------------------+------------+------------+
20 rows in set (0.00 sec)
```
On voit qu'il trie tout par l'identifiant d'accord qui est du coup mon auto incrémentation donc ma clé primaires et s'est rangé par défaut dans l'ordre croissant donc moi je veux le ranger par rapport à game_title et dans ce cas là je vais mettre order by game_title.
```sql
	SELECT * FROM fv_games ORDER BY game_title;
```
```sql
mysql> SELECT * FROM fv_games ORDER BY game_title;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|      17 | Devil May Cry 2                               | 2003-04-03       |         57 |          3 |
|       5 | Euro Truck Simulator 2                        | 2012-10-19       |       8.99 |          5 |
|       1 | Final Fantasy VII                             | 1997-11-17       |      12.99 |          7 |
|      10 | Fortnite Battle Royale                        | 2017-09-28       |          0 |          7 |
|      19 | Forza Horizon 4                               | 2018-10-02       |      35.99 |          4 |
|       2 | God of War : Ascension                        | 2013-03-13       |      22.75 |          1 |
|       3 | Gran Turismo 5                                | 2010-11-24       |         25 |          1 |
|      20 | Grand Theft Auto : San Andreas                | 2004-10-29       |       6.58 |          1 |
|      16 | Life is Strange - épisode 1                   | 2015-01-30       |          0 |          1 |
|      15 | Minecraft                                     | 2011-11-18       |      18.48 |          2 |
|       8 | Pokémon Let's Go, Évoli                       | 2018-11-16       |      44.39 |          2 |
|       7 | Pokémon Let's Go, Pikachu                     | 2018-11-16       |      44.39 |          2 |
|       6 | Professeur Layton et l'Héritage des Aslantes  | 2013-11-08       |      74.99 |          3 |
|      13 | Rocket League                                 | 2015-07-07       |      21.99 |          6 |
|       9 | Sea of Thieves                                | 2018-03-20       |      34.99 |         10 |
|      18 | Skylanders : Spyro's Adventure                | 2011-10-14       |      19.95 |          4 |
|       4 | Tekken                                        | 1995-11-03       |       59.9 |          1 |
|      12 | Tekken 3                                      | 1998-09-12       |       89.9 |          1 |
|      14 | The Legend of Zelda : Ocarina of Time         | 1998-12-11       |       14.9 |          4 |
|      11 | World of Warcraft                             | 2005-02-11       |      14.51 |         15 |
+---------+-----------------------------------------------+------------------+------------+------------+
20 rows in set (0.00 sec)
```
Là si je fais cette requête voilà tout est trié par ordre alphabétique ici.

Alors par défaut c'est par ordre croissant mais vous pouvez également mettre ASC pour ascendant donc ça c'est pareil c'est le mode que si vous ne mettiez pas ou que vous mettiez c'est la même chose.
```sql
	SELECT * FROM fv_games ORDER BY game_title;
	SELECT * FROM fv_games ORDER BY game_title ASC;
```
Et si on veut faire bien sûr l'inverse c'est à dire décroissant, on va mettre desc et là du coup ils seront triés à l'nverse donc de z à a.
```sql
	SELECT * FROM fv_games ORDER BY game_title DESC;
```
```sql
mysql> SELECT * FROM fv_games ORDER BY game_title DESC;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|      11 | World of Warcraft                             | 2005-02-11       |      14.51 |         15 |
|      14 | The Legend of Zelda : Ocarina of Time         | 1998-12-11       |       14.9 |          4 |
|      12 | Tekken 3                                      | 1998-09-12       |       89.9 |          1 |
|       4 | Tekken                                        | 1995-11-03       |       59.9 |          1 |
|      18 | Skylanders : Spyro's Adventure                | 2011-10-14       |      19.95 |          4 |
|       9 | Sea of Thieves                                | 2018-03-20       |      34.99 |         10 |
|      13 | Rocket League                                 | 2015-07-07       |      21.99 |          6 |
|       6 | Professeur Layton et l'Héritage des Aslantes  | 2013-11-08       |      74.99 |          3 |
|       7 | Pokémon Let's Go, Pikachu                     | 2018-11-16       |      44.39 |          2 |
|       8 | Pokémon Let's Go, Évoli                       | 2018-11-16       |      44.39 |          2 |
|      15 | Minecraft                                     | 2011-11-18       |      18.48 |          2 |
|      16 | Life is Strange - épisode 1                   | 2015-01-30       |          0 |          1 |
|      20 | Grand Theft Auto : San Andreas                | 2004-10-29       |       6.58 |          1 |
|       3 | Gran Turismo 5                                | 2010-11-24       |         25 |          1 |
|       2 | God of War : Ascension                        | 2013-03-13       |      22.75 |          1 |
|      19 | Forza Horizon 4                               | 2018-10-02       |      35.99 |          4 |
|      10 | Fortnite Battle Royale                        | 2017-09-28       |          0 |          7 |
|       1 | Final Fantasy VII                             | 1997-11-17       |      12.99 |          7 |
|       5 | Euro Truck Simulator 2                        | 2012-10-19       |       8.99 |          5 |
|      17 | Devil May Cry 2                               | 2003-04-03       |         57 |          3 |
+---------+-----------------------------------------------+------------------+------------+------------+
20 rows in set (0.00 sec)
```
Voilà donc pas le 1e du coup c'est world of warcraft et le dernier c'est devil may cry tout simplement.

Voilà pour ça donc ça c'est simplement pour trier l'ordre un petit peu de ce que vous voulez récupérer dans c'est très simple et on peut trier bien sûr sur plusieurs champs, on peut très bien dire sur game_title, qu'on trie en fait les jeux par ordre alphabétisme au niveau de leur nom et ensuite on va trier le prix lui à l'envers c'est à dire que s'il y a des jeux qui porte le même nom d'accord et bien le prix sera mis de manière décroissante donc le plus plus cher au moins cher.
```sql
	SELECT * FROM fv_games ORDER BY game_title, game_price DESC;
```
```sql
mysql> SELECT * FROM fv_games ORDER BY game_title, game_price DESC;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|      17 | Devil May Cry 2                               | 2003-04-03       |         57 |          3 |
|       5 | Euro Truck Simulator 2                        | 2012-10-19       |       8.99 |          5 |
|       1 | Final Fantasy VII                             | 1997-11-17       |      12.99 |          7 |
|      10 | Fortnite Battle Royale                        | 2017-09-28       |          0 |          7 |
|      19 | Forza Horizon 4                               | 2018-10-02       |      35.99 |          4 |
|       2 | God of War : Ascension                        | 2013-03-13       |      22.75 |          1 |
|       3 | Gran Turismo 5                                | 2010-11-24       |         25 |          1 |
|      20 | Grand Theft Auto : San Andreas                | 2004-10-29       |       6.58 |          1 |
|      16 | Life is Strange - épisode 1                   | 2015-01-30       |          0 |          1 |
|      15 | Minecraft                                     | 2011-11-18       |      18.48 |          2 |
|       8 | Pokémon Let's Go, Évoli                       | 2018-11-16       |      44.39 |          2 |
|       7 | Pokémon Let's Go, Pikachu                     | 2018-11-16       |      44.39 |          2 |
|       6 | Professeur Layton et l'Héritage des Aslantes  | 2013-11-08       |      74.99 |          3 |
|      13 | Rocket League                                 | 2015-07-07       |      21.99 |          6 |
|       9 | Sea of Thieves                                | 2018-03-20       |      34.99 |         10 |
|      18 | Skylanders : Spyro's Adventure                | 2011-10-14       |      19.95 |          4 |
|       4 | Tekken                                        | 1995-11-03       |       59.9 |          1 |
|      12 | Tekken 3                                      | 1998-09-12       |       89.9 |          1 |
|      14 | The Legend of Zelda : Ocarina of Time         | 1998-12-11       |       14.9 |          4 |
|      11 | World of Warcraft                             | 2005-02-11       |      14.51 |         15 |
+---------+-----------------------------------------------+------------------+------------+------------+
20 rows in set (0.00 sec)
```
Pour moi comme j'avais pas de jeu qui portait le même nom pour le coup évidemment on aura juste un tri en fait sur le nom mais on n'aura pas de tri des croissants sur le prix parce qu'on a aucun jeu qui porte le même nom puisque c'est un champ ici unique.

game_title est un champ ici unique pour le coup donc voilà mais bon sachez que sur certaines tables vous pourriez avoir besoin des fois de trier sur plusieurs champs de votre votre table donc ça peut être intéressant aussi.

Voilà pour l'utilisation d'order by.

Et on terminera du coup avec la manière de limiter le nombre d'enregistrements que nous récupérons.

Par défaut, je vous ai dit cette table a 20 enregistrements mais si admettons à un moment donné par exemple imaginer sur un site web je veux listés par exemple 10 news par page.

Vous imaginez si vous récupérez toutes les news de votre base de données et que ba votre site il a cinq ans et que vous avez fait 2000 news vous aller afficher 2000 news sur la page ça risque d'être un petit peu compliqué pour l'utilisateur.

On va préférer plutôt en lister 10 15 20 et proposer une pagination.

Dans ce cas là on pourra très bien dire alors en mettant LIMIT, mettre une limite et moi par exemple je veux dire que je veux récupérerer que les 10 premier ou même les 5 premiers et je mettrai tout simplement LIMIT suivi de l'entier qui correspond au nombre d'enregistrements que je veux récupérer.

+ commandes.sql
```sql	
	SELECT * FROM fv_games LIMIT 5;

	(!) Syntaxe différente suivant le SGBD utilisé (!)
		LIMIT (MySQL, PostgreSQL)
		TOP (SQL Server, MS Access)
		ROWNUM (Oracle)
```
Alors petite parenthèse ici, il ne faut pas s'imaginer qu'en faisant ça par exemple votre requête sera plus optimisée qu'en faisant ceci.
```sql
	SELECT * FROM fv_games LIMIT 5; 
	//...n'est pas plus optimisée que ...
	SELECT * FROM fv_games;
```
Tout simplement parce que dans les deux cas ici on va récupérer tous les enregistrements d'accord et ensuite seulement là on se limite à l'affichage d'accord des 5 premiers donc c'est ça qu'il faut se dire voilà faut faire attention, faut pas se dire qu'avec une limite ici et bien du coup la requête sera plus rapide en termes d'exécution.

C'est vraiment ici un niveau de filtrage càd pour l'affichage pas tellement pour la récupération des données.
```sql
	mysql> SELECT * FROM fv_games LIMIT 5;
	+---------+------------------------+------------------+------------+------------+
	| id_game | game_title             | game_releaseDate | game_price | game_stock |
	+---------+------------------------+------------------+------------+------------+
	|       1 | Final Fantasy VII      | 1997-11-17       |      12.99 |          7 |
	|       2 | God of War : Ascension | 2013-03-13       |      22.75 |          1 |
	|       3 | Gran Turismo 5         | 2010-11-24       |         25 |          1 |
	|       4 | Tekken                 | 1995-11-03       |       59.9 |          1 |
	|       5 | Euro Truck Simulator 2 | 2012-10-19       |       8.99 |          5 |
	+---------+------------------------+------------------+------------+------------+
	5 rows in set (0.00 sec)
```
Donc là je récupère les cinq premiers enregistrements mais pour autant la requête est la même d'accord c'est juste qu'on a limité l'affichage.

On peut également choisir d'afficher par exemple d'un certain enregistrement jusqu'à un certain autre càd de ne pas commencer depuis le premier alors il faut savoir qu'en terme d'ordre, de numéro d'enregistrement, ce qu'on appelle donc l'offset par rapport au nombre de lignes que vous récupérez commence à 0 comme beaucoup de choses en informatique, le premier élément ce n'est jamais 1 lais c'est toujours 0. C'est de 0 à 1 2 3 4 5 jusqu'à je sais pas combien plutôt que de commencer par 1.

Donc si admettons on veut récupérer je sais pas moi 5 enregistrements mais en commençant du 3e offset, j'ai juste à faire tout simplement LIMIT 5 donc je veux récupérer que 5 enregistrement mais que ces derniers commencent à l'offset 3, ce genre de chose.

+ commandes.sql
```sql	
	SELECT * FROM fv_games LIMIT 5;
	SELECT * FROM fv_games LIMIT 5 OFFSET 3;
```
```sql
mysql> SELECT * FROM fv_games LIMIT 5 OFFSET 3;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|       4 | Tekken                                        | 1995-11-03       |       59.9 |          1 |
|       5 | Euro Truck Simulator 2                        | 2012-10-19       |       8.99 |          5 |
|       6 | Professeur Layton et l'Héritage des Aslantes  | 2013-11-08       |      74.99 |          3 |
|       7 | Pokémon Let's Go, Pikachu                     | 2018-11-16       |      44.39 |          2 |
|       8 | Pokémon Let's Go, Évoli                       | 2018-11-16       |      44.39 |          2 |
+---------+-----------------------------------------------+------------------+------------+------------+
5 rows in set (0.00 sec)
```
Voilà donc pourquoi démarrer à l'OFFSET 3 ? Parce que je rapelle que l'offset 3 c'est tout simplement le quatrième d'accord parce ce que je rappelle que le premier c'est zéro donc si vous regardez ici on a bien récupéré cinq enregistrements mais on a commencé par celui d'indice offset + 1 d'accord puisque ça commence à zéro le premier donc on commence par le 4 et on récupère 5 enregistrement à la suite voilà.

Alors sur mysql il ya une autre syntaxe mais que pour mysql en l'occurrence qui au lieu de faire toute cette syntaxe avec l'offset 3, 5.

+ commandes.sql
```sql	
	SELECT * FROM fv_games LIMIT 5;
	SELECT * FROM fv_games LIMIT 5 OFFSET 3;
	SElECT * FROM fv_games LIMIT 3, 5;
```
En gros donc on dit on commence à 3 et on retourne 5 enregistrements donc là pareil c'est inversé en fait, faut faire attention par rapport à ça. C'est l'offset en premier, virgule, le nombre d'enregistrements à retourner mais ça c'est propre à mysql et comme moi je privilégie comme je voulais dit des commandes sql qui fonctionne sur n'importe quel système de gestion de base de données, je recommande plutôt d'utiliser ça.
```sql
	SELECT * FROM fv_games LIMIT 5 OFFSET 3;
```
Mais sachez que mysql, vous pouvez faire ça.
```sql
mysql> SElECT * FROM fv_games LIMIT 3, 5;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|       4 | Tekken                                        | 1995-11-03       |       59.9 |          1 |
|       5 | Euro Truck Simulator 2                        | 2012-10-19       |       8.99 |          5 |
|       6 | Professeur Layton et l'Héritage des Aslantes  | 2013-11-08       |      74.99 |          3 |
|       7 | Pokémon Let's Go, Pikachu                     | 2018-11-16       |      44.39 |          2 |
|       8 | Pokémon Let's Go, Évoli                       | 2018-11-16       |      44.39 |          2 |
+---------+-----------------------------------------------+------------------+------------+------------+
5 rows in set (0.00 sec)
```
Copier coller et voilà, on récupère exactement voyez les mêmes choses. C'est vraiment la même chose de 4e au 8e enregistrements donc ça fait exactement le même résultat mais la commande est écrite différemment.

Voilà pour en tout cas la limite donc por la récupération d'enregistrement lié à une certaine limite donc concernant notamment cette offset donc voilà, je vous du coup montré pas mal de choses sur cette séance notamment l'arrivée de l'introduction de cette clause WHERE qui permet encore une fois de filtrer les données qu'on va réutiliser énormément énormément de toute façon au cours de cette formation.

Et j'ai du coup abordé avec vous order by et limit qui vous serviront également dans certains cas donc voilà comme ça tout est vu ici sur cette séance et on pourra pour la prochaine séance en tout cas commencé à voir d'autres choses notamment l'enregistrement de données voilà. On va commencer par voir ça parce que c'est pas mal de manipulation standard que ce soit la lecture de données, l'enregistrement, la modification et la suppression donc sur les vidéos suivantes, on va s'occuper vraiment de voir toutes ces petites choses et après on passera sur des concepts déjà un peu plus avancés pour on va dire manipulé de manière un peu plus spécifique les données que l'on aura au niveau de nos bases de données sql.

Je vous dis à bientôt pour la prochaine séance sur ce cours sql et n'hésitez pas s'il y a des questions vous pouvez passer par les commentaires de la vidéo.

Cia tout le monde