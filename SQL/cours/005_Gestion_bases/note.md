# [5. Gestion bases](https://www.youtube.com/watch?v=86f6ldnLVLM)
18-12-20

Bonjour tout le monde et bienvenue pour la 5e séance en SQL. 

Alors la dernière fois on avait pris une petite demi-heure enfin une bonne demi-heure quand même pour parler des moteurs de stockage. 

Je reviens dessus parce que c'était vraiment très très important comme je vous l'avais dit précédemment. 

Une vidéo qui avait toute son importance pour votre apprentissage de SQL et notamment de l'utilisation d'un SGBD en l'occurrence SQL pour cette formation. 

Et cette vidéo sera beaucoup plus courte parce qu'il n'y a pas grand chose à vous montrer parce que voilà il y a vraiment très peu de requêtes à connaître mais nous allons parler des bases d'accord. 

Comment faire des bases de données, il faut bien comprendre qu'à un moment on rentre dans le vif du sujet parce qu'on n'arrête pas d'en parler depuis le départ mais il serait peut-être temps maintenant de créer une base de données donc on va voir tout ça. 

Alors la base de données ça va tout simplement être géré sur le disque dur. 

Alors sur le disque dur à l'emplacement des données dans data, on va avoir tout un tas de répertoire. 

J'ai fait un répertoire fv_database pour formation vidéo database. 

Ce n'est pas que j'ai fait le répertoire, c'est que j'ai créé une base de données qui s'appelle comme ça et ça m'a fait du coup un répertoire avec pas mal de choses mais ça on verra plus tard parce qu'on va travailler avec ce genre de bases de données par la suite.

Quand on commencera à apprendre à faire des requêtes, je vous filerais un dossier SQL pour que vous ayez tous les mêmes données en fait sur lequel travaillait et sur lequel vous exercez. Il n'y a rien de vraiment plus sympa.

L'avantage de SQL c'est qu'on va pouvoir travailler facilement, vous allez pouvoir faire des exercices facilement aussi et mettre en pratique tous ce vous allez apprendre parce qu'on va pouvoir manipuler pas mal d'information sur une base de données concrètes avec de vraies données donc ça va être plutôt sympa.

La base de données c'est simplement un fichier qui va stocker toutes ces informations sauf si vous travaillez comme on l'a vu précédemment avec le moteur par exemple Memory qui lui enregistrait les données de manière temporaire sur la mémoire vive mais pour le cas de MyISAM et InnoDB si on prend nos 2 références d'accord.

Eh bien on va travailler directement avec des fichiers. 

Alors normalement j'ai déjà ouvert tout, le serveur est en route et le client MySQL est en route également.

+ serveur
```powershell
	>mysqld --console
	
	2020-12-18T17:32:09.697135Z 0 [System] [MY-010116] [Server] C:\MyWAMP\mysql\bin\mysqld.exe (mysqld 8.0.22) starting as process 4548
	2020-12-18T17:32:09.851553Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
	2020-12-18T17:32:11.154862Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
	2020-12-18T17:32:11.605959Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060
	2020-12-18T17:32:11.792468Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
	2020-12-18T17:32:11.792975Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
	2020-12-18T17:32:11.883811Z 0 [System] [MY-010931] [Server] C:\MyWAMP\mysql\bin\mysqld.exe: ready for connections. Version: '8.0.22'  socket: ''  port: 3306  MySQL Community Server - GPL.
```
+ mysql
```powershell	
	> mysql -u root -p
	
	Enter password:
	Welcome to the MySQL monitor.  Commands end with ; or \g.
	Your MySQL connection id is 8
	Server version: 8.0.22 MySQL Community Server - GPL

	Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

	Oracle is a registered trademark of Oracle Corporation and/or its
	affiliates. Other names may be trademarks of their respective
	owners.

	Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

	mysql>
```
Alors normalement j'ai déjà ouvert tout, le serveur est en route, le client MySQL est en route et on va pouvoir regarder tout ça. 

On a toujours fait la fameuse requête show databases; donc vous pouvez l'écrire en majuscules ou en minuscules mais de préférence écrivait tout en majuscules prenez cette habitude là sauf bien sûr pour les noms des bases de données ou des tables parce qu'ils sont en minuscule.
```sql
	> show databases;
	
	+--------------------+
	| Database           |
	+--------------------+
	| information_schema |
	| mysql              |
	| performance_schema |
	| sys                |
	+--------------------+
	4 rows in set (0.02 sec)
```
Voilà on va dire que pour les mots-clés en SQL n'hésitez pas à les écrire en majuscule parce que c'est mieux. 

Et alors là on voit toutes nos bases de données, les fameuses databases.

Database c'est le terme base de données en anglais. 

Alors on va pouvoir et ça vous les voyez, on va pouvoir travailler dessus. 

Pour commencer à travailler sur une base de données il faut dire que nous l'utilisons d'accord donc on verra par la suite comment définir l'utilisation d'une base de données mais nous allons commencer par en créer une. 

On va faire une base de données de test au départ pour les vidéos que je vais vous montrer. 

Et par la suite tout ce que nous allons faire sur les vidéos prochaines, on travaillera sur une vraie base de données où je vous aurais donné un fichier où on aura plein de tables dedans, des enregistrements avec pas mal d'informations et comme ça on aura vraiment quelque chose. 

On ne va pas s'amuser comme ça à chaque vidéo à créer des données d'exemple, créer quelque chose qui aurait par exemple 5 données parce que ça n'aurait aucun intérêt. 

On travaille vraiment avec une grosse base de données assez conséquent pour avoir pas mal de possibilités et pas mal de choses à faire dessus.

Nous tout ce qu'on va voir déjà c'est comment créer une base de données et c'est vraiment très simple. 

La commande pour le faire je vais d'ailleurs noter ça dans un fichier .sql pour qu'on ait la bonne coloration syntaxique. 

On va mettre notes.sql donc c'est .sql pour l'extension de fichier sql justement. 

Et on a la commande suivante.

+ notes.sql
```sql
	CREATE DATABASE test;
```
Moi je vais donc mettre test, juste ça d'accord. 

Vous pouvez également faire une petite sécurité supplémentaire en faisant IF NOT EXISTS avec un s à la fin et enfin la base, test.

+ notes.sql
```sql	
	CREATE DATABASE test;
	CREATE DATABASE IF NOT EXISTS test;
```
L'avantage c'est que si la base existe déjà, Eh bien elle ne sera pas créée. 

En revanche si vous faites cette requête et que la base test existe déjà, vous aurez un message d'erreur mais moi je sais qu'elle n'y est pas parce qu'on a regardé avant donc je vais sur le terminal mysql faire un copier coller.
```sql
	> CREATE DATABASE test;
	Query OK, 1 row affected (0.01 sec)
```
Il faut voyez que ça me met Query OK, 1 row affected donc j'ai bien créé quelque chose. 

Je peux ré afficher mes bases de données et on va voir que test a été rajouté à la liste par rapport à ce qu'on avait avant.
```sql
	> show databases;
	+--------------------+
	| Database           |
	+--------------------+
	| information_schema |
	| mysql              |
	| performance_schema |
	| sys                |
	| test               |
	+--------------------+
	5 rows in set (0.00 sec)
```
Ca c'était donc la création d'une base de données donc c'est vraiment très simple on est sur quelque chose de vraiment très simple pas de souci. 

Logiquement elle est gérée en utf 8 parce que vous avez vu qu'on avait tout mis en utf 8. 

On avait d'ailleurs notre fameuse commande d'avant et on va vérifier pour voir que nos paramètres n'ont pas changé.
```sql
	> show variables like 'char%';
	+--------------------------+------------------------------------------+
	| Variable_name            | Value                                    |
	+--------------------------+------------------------------------------+
	| character_set_client     | utf8mb4                                  |
	| character_set_connection | utf8mb4                                  |
	| character_set_database   | utf8mb4                                  |
	| character_set_filesystem | binary                                   |
	| character_set_results    | utf8mb4                                  |
	| character_set_server     | utf8mb4                                  |
	| character_set_system     | utf8                                     |
	| character_sets_dir       | C:\Users\..\MyWAMP\mysql\share\charsets\ |
	+--------------------------+------------------------------------------+
	8 rows in set (0.01 sec)
```
Ensuite je vérifie pour voir que les paramètres n'ont pas changé. 

Voyez character_set_database avec utf8mb4 donc j'aurais pu le préciser mais on ne va pas le préciser mais je sais que ma base de données va être gérée de cette manière. 

Alors selon certain type de système que ce soit Oracle, MySQL, SQL server, … vous pouvez des fois sélectionnez ou en tout cas ajouter des options à cette commande d'accord mais ce n'est pas quelque chose qui est géré par défaut en SQL parce que la création donc cette requête là CREATE DATABASE ne fait même pas partie des standards de SQL. 

Donc je vous le dis parce que je vous assuré qu'on allait travailler un maximum avec le langage SQL qui est général c'est-à-dire qu'il fonctionne partout. 

Rassurez vous cette commande va fonctionner sur tous les systèmes. 

Juste comme il ne s'agit pas d'une commande standard à la base, Eh bien chaque SGBD propose différentes options qui pourrait par exemple être renseigné à la suite donc moi que je n'utilise jamais personnellement parce qu'on peut travailler avec les différentes options par la suite. 

Ce qui m'intéresse donc quand je fais ça c'est de pouvoir créer moi-même mes bases de données et c'est terminé. 

Retenez juste si vous voulez apprendre les options de votre système de gestion, vous pouvez. 

Si vous travaillez sur Oracle vous n'aurez qu'a voir ce que Oracle propose comme option à la création d'une base mais aussi ce cours propose SQL server ou autre.

Moi ça ne m'intéresse pas mais bon voilà vous êtes libre de faire comme vous voulez. 

Nous tout ce qu'on voulait c'était créer notre base, c'est terminé.

Comment allons-nous dire d'utiliser une base en particulier, Eh bien nous allons utiliser la petite requête USE et le nom de la base en question donc en faisant juste ça. 

+ notes.sql
```sql	
	CREATE DATABASE test;
	CREATE DATABASE IF NOT EXISTS test;
	
	USE test;
```
Et si je fait ça.
```sql
	> USE test;
	Database changed
```
Et là il me dit Database changed d'accord et par la suite on verra qu'on pourra gérer les tables mais ça ce n'est pas le sujet de cette vidéo, ce sera pour la prochaine vidéo. 

La prochaine vidéo on devrait aborder les tables et les types de données que nous allons pouvoir manipuler donc là il va vraiment pouvoir rentrer dans le vif du sujet. 

Alors à partir de ce moment-là nous utilisons notre table test. 

Si on veut pouvoir modifier notre base de données, on utilisera la commande DROP DATABASE et le nom de la base en question, test; c'est tout. 

+ notes.sql
```sql	
	CREATE DATABASE test;
	CREATE DATABASE IF NOT EXISTS test;
	
	USE test;
	
	DROP DATABASE test;
```
Alors là ce que je peux faire. Normalement si je fais un exit, on va tout quitter. 
```powershell
	> exit
	Bye
	
	> cls
```
Alors je ne voulais pas forcément faire ça …

Alors on va remontrer pour voir que là suppression se fait bien vous allez pouvoir voir que je vais d'abord bien ma base de données test.
```sql
	> mysql -u root -p

	mysql> show databases;
	+--------------------+
	| Database           |
	+--------------------+
	| information_schema |
	| mysql              |
	| performance_schema |
	| sys                |
	| test               |
	+--------------------+
	5 rows in set (0.00 sec)
```
Je fais ensuite un `DROP DATABASE test;`
```sql
	mysql> DROP DATABASE test;
	Query OK, 0 rows affected (0.02 sec)
```
Ensuite je refais la commande de tout à l'heure.
```sql
	mysql> show databases;
	+--------------------+
	| Database           |
	+--------------------+
	| information_schema |
	| mysql              |
	| performance_schema |
	| sys                |
	+--------------------+
	4 rows in set (0.00 sec)
```
En faisant la commande tout à l'heure on voit qu'on a bien supprimé la base de données test. 

Au niveau des bases de données, c'est tout ce que j'ai à vous apprendre alors je vous dis il y a des options que vous pouvez apprendre si vous voulez mais c'est propre au système de gestion que vous utilisez. 

Ici sur la formation il s'agit de MySQL mais peut-être qu'un jour vous allez utiliser cette formation pour travailler sur Oracle, pour travailler sur SQL Server, SQLite ou bien d'autres trucs, PostgreSQL et cetera.

Vous aurez des options différentes éventuellement mais au niveau de la gestion de base, franchement c'est tout ce qu'il y a à savoir. 

S'il y a besoin de rajouter quelque chose par la suite, on le verra au moment opportun mais pour tout ce qui est gestion, c'est ça. 

Vous avez comment afficher et on peut le montrer on va le remettre ici.

+ notes.sql
```sql	
	SHOW DATABASES;
	
	CREATE DATABASE test;
	CREATE DATABASE IF NOT EXISTS test;
	
	USE test;
	
	DROP DATABASE test;
```
Voilà comment afficher les bases de données avec la commande SHOW DATABASES; ensuite comment créer une base de données CREATE … ensuite comment demander à l'utiliser USE… parce qu'il faudra bien l'utiliser avant de travailler dessus … et enfin comment la supprimer DROP DATABASE. 

Si vous connaissez ces requêtes là et d'ailleurs vous pouvez aller prendre un autre si vous voulez mais vous avez tout le nécessaire pour ce qui est des gestions des bases de données  avec le bon encodage parce qu'on a évidemment vu et aborder avant et que nous avons normalement configuré notre environnement correctement pour travailler avec les bons encodages. 

Ça c'est donc plutôt sympa. 

Voilà on va s'arrêter avec cette vidéo, et j'avais dit que ça allait être très court comparer la vidéo d'une demi-heure précédemment. 

La prochaine sera un peu plus longue parce qu'on va parler à la fois de gestion de table donc c'est vraiment le vif du sujet concernant les bases de données et le type de données. 

Alors ça les types de données ça va prendre pas mal de temps à vous l'expliquer parce qu'il va falloir que je vous explique les différents types de données disponibles déjà et ensuite dans quel cas utiliser l'un ou l'autre comme pour le moteur, comme pour l'encodage parce que c'est bien d'avoir dès le début des bonnes habitudes pour ne pas utiliser les mauvais types de données parce que ça pourrait évidemment baisser drastiquement les performances de votre base de données. 

Ainsi si on utilise les bons types dès le départ, on s'assure d'avoir quelque chose de cohérent et qui est le plus efficace possible. 

Je vais vous laisser du coup avec ça, s'il y a des commentaires des questions des remarques n'hésitez pas comme d'habitude à l'est poser sous la vidéo. 

Je vous dis à bientôt pour la suite de cette formation et en attendant n'hésitez pas à bien voir et revoir sa vidéo là pour être sûr de bien avoir tout assimilé il n'a pas rencontré de problèmes par la suite. 

À bientôt

+ client
```powershell
	mysql> exit
	Bye

	> mysqladmin -u root -p shutdown
	Enter password:
	
	>exit
```
+ serveur
```powershell
	
	>exit
```