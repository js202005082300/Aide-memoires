# [12. Modifier et supprimer](https://www.youtube.com/watch?v=7gMgsSrFgaw)
01-01-20

[data2.sql](data2.sql)

Bonjour, bienvenue sur la séance 12 en sql.

On va continuer un petit peu sur les opérations élémentaires que nous pouvons faire sur les données.

Alors en gros il faut savoir qu'au niveau de la manipulation de données sql, nous avons quatre opérations qui sont très importantes qu'on nomme généralement CRUD qu'on écrit de cette manière.

+ commandes.sql
```sql
	CRUD
```
Alors tout simplement parce que le C en fait représente CREATE, c'est ce qu'on a fait en fait avec le fameux INSERT TO d'accord quand on a vu comment insérer des données.

+ commandes.sql
```sql
	CRUD
	
	C : create (INSERT TO)
```
On a le r pour lui c'est donc tout simplement la lecture de
données et dans cette séance nous allons voir les deux dernières opérations à savoir update qui va utiliser donc une commande update justement et le delete, la suppression de données qui porte également le même nom.

+ commandes.sql
```sql
	CRUD
	
	C : create (INSERT TO)
	R : read (SELECT)
	U : update (UPDATE)
	D : delete (DELETE)
```
Voilà quatre opérations élémentaires qui permettent comme ça de manipuler des données.

En gros quand vous avez une donnée précise sql et bien vous devez pouvoir normalement insérer des enregistrements d'accord non par exemple dans une table, vous devez pouvoir lire sur cette table, vous devez pouvoir éditer des informations et les supprimer donc on va regarder nous les deux autres ici opérations qu'on n'a pas encore vu.
```sql
	U : update (UPDATE)
	D : delete (DELETE)
```
C'est très très simple déjà bon au niveau de la base de données on va se connecter.
```sql
	SOURCE C:/SQL/cours/012_Modifier_et_supprimer/data2.sql
	
	use fv_database;
```
Le but c'est que vous ayez des informations évidemment en bases de données peu importe quel genre de table, ça ne change pas grand chose donc j'ai fv_games.
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
Voilà toute l'information que j'ai ici donc vous êtes obligés d'avoir les mêmes, vous pouvez avoir d'autres informations peu importe. Le but c'est vous ayés quelques enregistrements pour pouvoir éditer certains enregistrements et pouvoir plus tard supprimer aussi voilà ce qu'on va voir sur cette séance donc voilà grosso modo mois la table que j'ai sur fv_games, vous avez tout un tas de jeux vidéos enregistrées ici.

Première chose avoir déjà c'est comment on va pouvoir éditer une information par exemple si je prends que n'importe où ici pour le jeu par exemple ici.
```txt
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|       1 | Final Fantasy VII                             | 1997-11-17       |      12.99 |          7 |
```
On voit qu'il y a sept jeux en stock je veux pouvoir modifier ce stock parce que par exemple y a un jeu qui vuent d'être acheté donc le stock va passer à 6 d'accord.

Alors pour faire ce genre de choses je peux tout simplement utiliser la commande update qui va prendre en tout cas qui va attendre ensuite le nom de la table qui fv_games d'accord et on va choisir la l'information donc le champ à modifier moi c'est set game_stock et ici on peut faire une opération un peu importe mais moi je veux faire directement une affectation donc on avait sept jeux et on a dit qu'on passait du coup à un jeu de moins donc 6 voilà.

+ commandes.sql
```sql
	UPDATE fv_games SET game_stock = 6
```
Et pour pouvoir modifier le bon jeu évidemment il faut avoir une condition pour dire quelle ligne, quel enregistrement de modifier donc soit on peut utiliser game_title soit on utiliser son identifiant pour moi je vais utiliser l'identifiants pour faire simple donc WHERE id = 1.

+ commandes.sql
```sql
	UPDATE fv_games SET game_stock = 6 WHERE id_game = 1;
```
Voilà en gros c'est ça donc si je décompose un petit peu la requête voilà ce que ça donne update puis le nom de la table en question ensuite on fait un set de du champ a modifier et selon une conditione donc selon une clause WHERE à partir de là.

Si on veut éventuellement modifier plusieurs informations on peut les séparer par des virgules càd que le set vous le mettez qu'une seule fois et ensuite ici vous pouvez mettre une autre information du genre game_price admettons qu'on veuille modifier également le prix, on va faire les deux d'ailleurs au passage, le prix était à 12,99 et là voilà on va faire une petite réduction attention 11,59 voilà ça ne rigole plus.

+ commandes.sql
```sql
	UPDATE fv_games
	SET game_stock = 6, game_price = 11.59
	WHERE id_game = 1;
```
Voilà donc on a du coup deux informations à modifier pour l'enregistrement qui porte l'idensifiant 1 dans la table fv_games voilà comment il faut bien un peu cette requête-là.

On va l'exécuter.
```sql
	mysql> UPDATE fv_games
		-> SET game_stock = 6, game_price = 11.59
		-> WHERE id_game = 1;
	Query OK, 1 row affected (0.01 sec)
	Rows matched: 1  Changed: 1  Warnings: 0
```
```sql
mysql> select * from fv_games;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|       1 | Final Fantasy VII                             | 1997-11-17       |      11.59 |          6 |
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
Et voilà on va directement aller sur la lecture des informations et on voit bien que le jeu qui porte l'identifiant numéro 1 a bien donc son prix qui a été modifié en 11.59 et le stock qui est bien arrivé à six au lieu de sept d'accord on vient effectivement de modifier les informations pour un
enregistrement.

Maintenant si je veux pouvoir modifier tous les éléments par exemple tous les champs d'une même table mais pour tous les enregistrements qu'elle contient on aura tout simplement pas à faire de cause where d'accord.

Si par exemple je veux que tous les jeux pas une d'un coup à un stock de six et à un prix de 11.59 bah vous enlevez simplement la clause where en fait c'est vraiment aussi simple que ça.

Si vous n'avez pas de clause where pour une requête comme UPDATE, vous allez toucher tous les enregistrements de la table en question.

+ commandes.sql
```sql
	UPDATE fv_games SET game_stock = 6, game_price = 11.59;
```
```sql
mysql> UPDATE fv_games SET game_stock = 6, game_price = 11.59;
Query OK, 19 rows affected (0.01 sec)
Rows matched: 20  Changed: 19  Warnings: 0

mysql> select * from fv_games;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|       1 | Final Fantasy VII                             | 1997-11-17       |      11.59 |          6 |
|       2 | God of War : Ascension                        | 2013-03-13       |      11.59 |          6 |
|       3 | Gran Turismo 5                                | 2010-11-24       |      11.59 |          6 |
|       4 | Tekken                                        | 1995-11-03       |      11.59 |          6 |
|       5 | Euro Truck Simulator 2                        | 2012-10-19       |      11.59 |          6 |
|       6 | Professeur Layton et l'Héritage des Aslantes  | 2013-11-08       |      11.59 |          6 |
|       7 | Pokémon Let's Go, Pikachu                     | 2018-11-16       |      11.59 |          6 |
|       8 | Pokémon Let's Go, Évoli                       | 2018-11-16       |      11.59 |          6 |
|       9 | Sea of Thieves                                | 2018-03-20       |      11.59 |          6 |
|      10 | Fortnite Battle Royale                        | 2017-09-28       |      11.59 |          6 |
|      11 | World of Warcraft                             | 2005-02-11       |      11.59 |          6 |
|      12 | Tekken 3                                      | 1998-09-12       |      11.59 |          6 |
|      13 | Rocket League                                 | 2015-07-07       |      11.59 |          6 |
|      14 | The Legend of Zelda : Ocarina of Time         | 1998-12-11       |      11.59 |          6 |
|      15 | Minecraft                                     | 2011-11-18       |      11.59 |          6 |
|      16 | Life is Strange - épisode 1                   | 2015-01-30       |      11.59 |          6 |
|      17 | Devil May Cry 2                               | 2003-04-03       |      11.59 |          6 |
|      18 | Skylanders : Spyro's Adventure                | 2011-10-14       |      11.59 |          6 |
|      19 | Forza Horizon 4                               | 2018-10-02       |      11.59 |          6 |
|      20 | Grand Theft Auto : San Andreas                | 2004-10-29       |      11.59 |          6 |
+---------+-----------------------------------------------+------------------+------------+------------+
20 rows in set (0.00 sec)
```
Donc là si j'exécute cette requête là, on voit que tous les jeux ont le même stock maintenant et le même prix d'accord on a vraiment affecté tous les enregistrements donc voilà pour la requête update c'est vraiment très très simple à utiliser comme vous le voyez il n'y a pas grand chose à retenir et ça se fait simplement il faut juste pas se tromper quand vous voulez par exemple éditer un seul enregistrement de ne pas oublier d'avoir une clause where sinon vous allez malheureusement modifier tous les enregistrements de la table et ça risquerait d'être un petit peu embêtant donc attention une clause where pour modifier un seul enregistrement ou plusieurs parce que ça dépend évidemment de ce que vous avez dans la clause where si c'est par exemple tous les jeux dont le prix dépasse telle ou telle chose, on peut faire ça.

Par exemple la le problème c'est que là maintenant tous les enregistrements ont tous le même prix donc je pourrai plus faire ça parce que ça va forcément tout affectés mais j'aurais pu dire par exemple je passe le stock à 5 pour tous les jeux qui sont à plus de 10 euros par exemple, changer de genre de choses donc après vous avez vu comment faire des clauses where de toute façon donc ça s'applique parfaitement pour la modification d'un ou de plusieurs enregistrements.

Donc voilà pour cette troisième opération de modification et on va terminer sur cette vidéo avec la quatrième qui est tout simplement la suppression de données et ça fonctionne exactement pareil.

En gros si je veux par exemple modifier une seule chose donc je vais déjà utiliser le mot clé DELETE mais là je rajoute un petit from et le nom de la
table.

+ commandes.sql
```sql
	DELETE FROM fv_games
```
Voilà ensuite il nous faut une clause évidemment sinon on va avoir des modifications qui ne sont pas prévues et là bas en fonction de la condition qui est mise c'est l'enregistrement suivant le where qui est valide et donc la condition qui est validé et qui sera supprimé donc moi par exemple moi là comme tout est pareil pour les autres champs on va du coup devoir filtrer sur le titre parce ce que j'ai mis pour le reste, j'ai mis qu'ils ont toutes la même valeur appart la date de sortie mais ce n'est pas intéressant pour nous ici et par exemple le jeu ici qui s'appelle Tekken.

Alors si on veut par exemple tous les jeux qui commence par tekken hé bien on peut utiliser le fameux like qu'on avait vue pour filtrer dans la clause where.

Encore une fois vous pouvez vous servir de tout ce que vous avez vu avant pour l'appliquer parfaitement dans les requêtes de modification et de suppression de données donc moi comme je veux supprimer vraiment celui qui s'appelle que Tekken non pas le Tekken 3 notamment eh bien je vais juste faire ça.

+ commandes.sql
```sql
	DELETE FROM fv_games WHERE game_title = 'Tekken';
```
Je prends cette requête et là on exécute et voilà et le jeu tekken ne fait plus partie de la table bien d'accord il a bien été supprimé.
```sql
mysql> DELETE FROM fv_games WHERE game_title = 'Tekken';
Query OK, 1 row affected (0.01 sec)

mysql> select * from fv_games;
+---------+-----------------------------------------------+------------------+------------+------------+
| id_game | game_title                                    | game_releaseDate | game_price | game_stock |
+---------+-----------------------------------------------+------------------+------------+------------+
|       1 | Final Fantasy VII                             | 1997-11-17       |      11.59 |          6 |
|       2 | God of War : Ascension                        | 2013-03-13       |      11.59 |          6 |
|       3 | Gran Turismo 5                                | 2010-11-24       |      11.59 |          6 |
|       5 | Euro Truck Simulator 2                        | 2012-10-19       |      11.59 |          6 |
|       6 | Professeur Layton et l'Héritage des Aslantes  | 2013-11-08       |      11.59 |          6 |
|       7 | Pokémon Let's Go, Pikachu                     | 2018-11-16       |      11.59 |          6 |
|       8 | Pokémon Let's Go, Évoli                       | 2018-11-16       |      11.59 |          6 |
|       9 | Sea of Thieves                                | 2018-03-20       |      11.59 |          6 |
|      10 | Fortnite Battle Royale                        | 2017-09-28       |      11.59 |          6 |
|      11 | World of Warcraft                             | 2005-02-11       |      11.59 |          6 |
|      12 | Tekken 3                                      | 1998-09-12       |      11.59 |          6 |
|      13 | Rocket League                                 | 2015-07-07       |      11.59 |          6 |
|      14 | The Legend of Zelda : Ocarina of Time         | 1998-12-11       |      11.59 |          6 |
|      15 | Minecraft                                     | 2011-11-18       |      11.59 |          6 |
|      16 | Life is Strange - épisode 1                   | 2015-01-30       |      11.59 |          6 |
|      17 | Devil May Cry 2                               | 2003-04-03       |      11.59 |          6 |
|      18 | Skylanders : Spyro's Adventure                | 2011-10-14       |      11.59 |          6 |
|      19 | Forza Horizon 4                               | 2018-10-02       |      11.59 |          6 |
|      20 | Grand Theft Auto : San Andreas                | 2004-10-29       |      11.59 |          6 |
+---------+-----------------------------------------------+------------------+------------+------------+
19 rows in set (0.00 sec)
```
Maintenant si je veux tout supprimer càd si je veux en fait retirer tous les enregistrements de ma table fv_games hé bien comme pour les modifications, il suffit simplement de ne pas avoir de clause where tout simplement.

+ commandes.sql
```sql
	DELETE FROM fv_games;
```
Si je fais ça je vais supprimer tous les enregistrements par contre comme ce n'est pas vraiment prévu pour càd que le delete est prévu normalement pour supprimer un ou des enregistrements si vraiment votre but c'est de vider complètement une table d'accord retirer tous les enregistrements qu'elle contient vous devrez plutôt utilisé à la place cette commande là.

+ commandes.sql
```sql
	DELETE FROM fv_games;
>	TRUNCATE TABLE fv_games;
```
TRUNCATE TABLE qui est vraiment pour le coup, c'est une requête qui est prévu pour vider complètement une table d'accord donc c'est mieux d'utiliser ça plus optimisé plus performante que de faire un delete from sur une table complète d'accord on va faire tout ça et on exécute.
```sql
	mysql> TRUNCATE TABLE fv_games;
	Query OK, 0 rows affected (0.06 sec)

	mysql> select * from fv_games;
	Empty set (0.00 sec)
```
Et là évidemment si j'essaie de re afficher le contenu de la table ça me met Empty set puisqu'il n'y a plus aucune donnée enregistrée et voilà pour cette du coup 4e opération qui est comme vous l'avez vu très simple à utiliser alors c'est très simple mais encore une fois il faut faire attention parce que tout ce qui est modifications surtout la suppression peut du coup avoir de grosses conséquences si vous ne mettez pas de clause et vous risquez de tout supprimer donc attention autant dans l'insertion vous ne prenez pas trop de risque vous allez enregistrer une information ... la sélection c'est juste de la lecture donc ça va mais tout ce qui est évidemment de la modification de données ou de la suppression, il faut vraiment faire attention de voir bien ce qu'on modifie et ce que l'on supprime pour ne pas se retrouver à tout modifier ou carrément à vider la table tout simplement et perdre toutes les informations qui étaient stockés.

Attention par rapport à ça, c'est vraiment important en fait de bien veiller un petit peu comment vous écrivez vos requêtes là dessus et voilà donc cette vidéo je vous dis il y a pas grand chose à voir c'est assez court mais ça nous permettait comme ça de clore un petit peu de clore toutes ces opérations élémentaires qu'il faut connaître en sql et on va pouvoir pour les prochaines séances passer à d'autres petites choses parce qu'évidemment on est loin encore d'avoir fait le tour de tout ce qui est possible de faire avec ce langage sql.

Je vous dis à bientôt du coup pour la prochaine vidéo