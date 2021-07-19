# [3. Configuration encodage](https://www.youtube.com/watch?v=bkrNOyo1gYk)
16-12-20

Bonjour à tous bienvenue pour la séance 3 en SQL. 

On continue tranquillou avec quelques petites séances de préparation pour la configuration de notre environnement et d'y aller simplement étape par étape avant de commencer directement à travailler avec le langage SQL pour préparer encore une fois l'environnement sur lequel nous allons travailler et connaître un peu les outils que nous allons utiliser. 

Pour cette séance comme vous l'avez vu dans le titre, je voulais parler d'encodage parce que c'est un point très récurrent en informatique de manière générale. 

Et certaines personnes, ont des fois tendance à oublier et ça peut amener énormément d'erreurs donc je voulais qu'on revienne un petit peu dessus. 

Qu'est-ce que nous allons entendre par encodage ? nous allons parler tout simplement de la gestion des différends caractères donc par exemple ce que nous allons utiliser lorsque nous allons faire usage de chaîne de caractères et vous pouvez communiquer dans différentes langues.

On n'a pas l'habitude en tout cas de manière générale la langue anglaise qui ne possède pas par exemple de caractères accentués ou de caractère on va dire très spéciaux. 

Du coup c'est une langue qui est très très bien gérée par défaut, par le système informatique puisque c'est la langue de base. 

C'est la langue on va dire un petit peu universel dans les systèmes informatiques. 

Le problème c'est que quand on arrive sur quelque chose comme le français qui lui possède des caractères accentués ou par exemple allemand qui a également des caractères assez spécifiques ou des langues plus oriental comme le japonais, le thaïlandais, le coréen qui ont des idéogrammes, des kanji, des Kana bref tout un système d'écriture qui sort un peu de l'ordinaire, on aurait des problèmes de lecture. 

Pour cela je vous ai habitué, je l'ai assez répété dans d'autres formations et je l'ai dit assez souvent le travailler avec un encodage dit unicode c'est-à-dire un encodage de manière générale utf 8, pourquoi ? Eh bien parce que ce type d'encodage va pouvoir gérer toutes les langues du monde que vous écriviez du français avec des accents, de l'anglais, du japonais, de l'arabe, du chinois, ce que vous voulez.

Vous allez pouvoir gérer ces différents caractères via cet ensemble, cette table de caractère que l'on appelle l'unicode même s'il y a plusieurs après distinction mais il faut considérer ça. 

Alors par défaut et selon les systèmes, vous allez par exemple avoir des systèmes comme Windows qui vont travailler en latin. 

En latin on va avoir certains encodages en ISO qui eux par contre ne gère pas tous les caractères. 

Ils ne vont avoir aucun problème avec la langue anglaise mais dès qu'il va s'agir de travailler avec des accents, des caractères spéciaux par exemple c cédille ou des symboles spécifiques que l'on peut retrouver dans des caractères dans une chaîne, Eh bien là on aurait des problèmes. 

Alors la première chose à faire c'est au niveau de votre éditeur même si bon en SQL on ne va pas s'en servir énormément de l'éditeur sauf qu'on aura besoin d'écrire quelques scripts ou d'écrire quelques requêtes SQL.

Mais voilà je prends le k de manière générale quel que soit le langage sur lequel vous allez travailler, la technologie logicielle du moment que vous êtes sur un domaine informatique, travailler en unicode. 

Au niveau de votre éditeur de texte il va falloir penser à encoder vos fichiers c'est-à-dire les fichiers sur lequel vous travaillez par exemple si vous faites du HTML vous allez avoir des fichiers HTML. 

Si vous faites du langage python vous allez avoir des fichiers avec l'extension .py et cetera. 

Tous ces fichiers là quel qu'il soit doivent être encodé en utf 8 pour ne pas avoir de problème. 

Moi je suis au niveau de cet éditeur de code sous Visual Studio code alors il ne s'agit pas de Visual Studio qui lui est le gros environnement de développement mais moi c'est juste l'éditeur de code. 

Pour modifier l'encodage c'est facile, on voit que l'encodage est affiché en bas à droite donc vous cliquez ici et vous pourrez sans problème changer. 

Souvent les encodages qu'on va retrouver c'est celui-là, Western ISO 8859 1. 

On peut retrouver également  le Latin 1 en fonction mais nous celui que l'on veut c'est le UTF-8 tout court c'est-à-dire qu'il ne faut pas le TFF-8 with BOM parce que ça ça va amener des petits problèmes également selon le système sur lequel vous allez travailler mais UTF-8 standard, UTF-8 simple. 

Si ce n'est pas le cas et que vous voyez dans vos éditeurs, vous n'êtes pas en UTF-8 pensez à convertir tout le temps vos fichiers en UTF-8ou en tout cas vérifier qu'ils le sont. 

Logiquement une fois après quand vous aurez converti sous cet encodage, à chaque fois que vous allez créer un nouveau fichier logiquement il devrait vous le créer dans cet encodage là. 

Moi dès que je crée un fichier maintenant il me le fait tout le temps du UTF-8 sans problème quel que soit le domaine sur lequel je travaille donc ça c'est pour Visual Studio code. 

Si vous êtes sur sublime text par exemple qui est ton anglais, il faut aller dans file > save with encoding  > UTF-8.

Et après si vous utilisez un autre éditeur de code ou même un environnement de développement quel qu'il soit, vérifiez tout le temps que vous êtes en utf 8 donc en unicode. 

Si ce n'est pas le cas Regardez comment changer. 

Aller voir sur internet comment on changer l'encodage de votre logiciel en particulier si vous utilisez un logiciel spécifique. 

Ça c'était la première partie pour l'éditeur parce qu'il faut vraiment que tout soit on codé en utf 8. 

Il ne faut pas juste se dire que si mes fichiers sont en utf 8, automatiquement tout le reste le sera … non il faut vraiment que tous les outils donc vous vous servez, tous les environnements sur lequel vous allez déployer du code, déployer une application doivent travailler avec une icône. 

C'est un peu casse-pied mais il va falloir vraiment penser à configurer tout ça. 

Là on a donc nos fichiers là ou en tout cas tout ce qui sera utilisé via un éditeur serra en utf 8 donc ça c'est une première étape. 

Là on va revenir à MySQL ou en tout cas à SQL de manière générale et là il va falloir travailler également en utf 8. 

En SQL en tout cas pour cette formation on a choisi le moteur de gestion de base de données MySQL dans la vidéo précédente. 

Il va falloir configurer tout un tas de choses c'est-à-dire que nous avons le serveur rappelez vous mysqld. 

Alors le serveur doit être configuré en utf 8. 

Il est possible qu'il le soit peut être et si vous avez de la chance peut-être qu'il y a déjà. 

Nous on va s'y assuré via une configuration personnalisée de spécifier les bons encodages mais en plus vous allez voir que pour MySQL, il y a un cas un peu particulier et ça c'est encore une autre chose à faire. 

Il faudra également configurer les clients et l'utilisation de MySQL en utf 8 donc il y a beaucoup de choses à passer en utf 8 et nous allons voir tout ça. 

Alors je disais qu'il y avait un cas un peu particulier pour MySQL, oui parce que en réalité MySQL quand on utilise l'utf 8 d'accord ce n'est pas vraiment de l'utf 8 c'est-à-dire qu'il s'agit d'un utf 8 mais codé sur 3 octets pour les caractères sauf que ça ne prendrait pas en compte tous les caractères de l'unicode que l'on peut utiliser. 

Par exemple il va y avoir des caractères très spécifiques en unicode. Eh bien avec de l'utf 8 simple, il ne pourrait pas être formaté donc être pris en compte, il ne rentrerait pas enfin dans la table de disponibilité de cette unicode-là.

Pour MySQL donc et de toute façon on va le faire pour la vidéo, il va falloir utiliser un encodage utf 8 assez peu particulier qui peut travailler jusqu à 4 octet. 

Cet encodage peut être sur 1 octet, 2 octets, 3 ou 4 d'accord il peut aller jusqu à 4. 

Avec cette fourchette possible de 1 à 4 octets, on va effectivement pouvoir prendre en compte tous les caractères que l'on veut. 

Ne vous inquiétez pas pour d'autres langages, pour d'autres cours, en mettant utf 8 standard ça prend déjà tout en compte. 

C'est juste que pour MySQL à l'époque utf 8 prenait que jusqu'à 3 octets.

Ils ont dû rajouter un autre encodage spécifique pour pouvoir éventuellement aller jusque 4 parce que de nouveaux caractères sont ajoutés en unicode et à un moment donné il faut que ça puisse être stocké sur le plus grand espace en mémoire. 

C'est simplement ça qu'il faut comprendre sans rentrer dans les détails, sans compliquer les choses. 

Nous allons du coup pour MySQL préciser un encodage un peu particulier, ce sera de l'utf 8 avec la possibilité d'être codé sur 4 octets maximum.

Et non plus être limité au maximum à 3 octets. 

Pour cela nous allons commencer par Windows et nous allons éditer notre fichier de configuration parce que c'est la meilleure manière de faire c'est-à-dire qu'on va modifier le fichier de configuration pour spécifier les bons encodage pour être sûr de toujours travailler sur ceci. 

On s'est donc occupé de notre éditeur de code pas de souci. 

On va aller dans notre répertoire MySQL. 

Rappelez vous si vous avez fait comme moi et que vous avez bien suivi la vidéo, vous avez normalement un fichier my.ini que vous avez dû logiquement mettre ici.
```txt
	C:\MyWAMP\mysql\
```
Histoire de ne pas compliquer les choses pour qu'il ne soit pas perdu ou tout seul je ne sais pas ou sur votre système. 

On va l'ouvrir et nous allons éditer ce fichier là. 

Alors nous avons la partie MySQL.

+ my.ini
```ini
	[mysqld]
	basedir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql
	datadir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql/data
```
On a la partie mysqld donc le serveur, mysql serveur et on va pouvoir le modifier pour ajouter toutes les informations concernant l'encodage. 

Rappelez-vous on avait le chemin de base, la racine du répertoire mysql (basedir). 

Et le chemin pour les données (datadir) c'est-à-dire là où sont enregistrés les bases de données, dans ./data. 

On va aller à la ligne et on va rajouter 2 petites lignes pour le serveur nous allons d'abord ajouter la plage d'encodage pour le serveur en lui-même, character-set-server = et on va lui mettre un paramètre donc nous le paramètre que l'on veut c'est utf8.

+ my.ini
```ini
	[mysqld]
	basedir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql
	datadir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql/data
	character-set-server = utf8
```
Donc ça c'est ce qu'on était avant.

Ca c'est l'encodage simple qui va pouvoir aller maximum jusqu à 3 octets maximum mais comme nous on veut être sûr de pouvoir prendre tout et comme on vient tout simplement de commencer à installer notre environnement, avant même de commencer à créer des bases de données et des tables et d'avoir vraiment plein plein plein de données plutôt d'éviter d'utiliser un mauvais encodage et après de devoir tout convertir ce qui pourrait prendre du temps, amener des erreurs enfin bref. 

Ça n'a rien de drôle de devoir changer l'encodage encours d'une base de données tu aurais des milliers de table avec je ne sais combien de millions d'informations. Ce serait juste là pagaille. 

Nous comme on parle juste de la base du début, on n'a pas encore commencé à travailler. 

Autant configurer les choses dès le départ comme il faut pour être tranquille. 

On va donc simplement rajouter après utf8, pour ajouter mb4 voilà.

+ my.ini
```ini
	[mysqld]
	basedir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql
	datadir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql/data
	character-set-server = utf8mb4
```
Voilà avant il y avait le mb3 mais ça reviendrait à marquer utf8 tout court. 

Ça veut donc dire qu'on peut coder les chaînes jusqu à 3 octets donc 3 fois 8 bits pour ceux qui voudraient se poser la question donc 24 bits. 

Et nous on va travailler jusqu à maximum 4 octets donc 4 fois 8 = 32 bits donc vous pouvez faire utf8mb4. 

Ca marqué le tout le temps, mettez toujours utf8mb4 pour travailler vraiment sur la plus grande plage disponible pour l'utf8. 

Ça c'est pour l'encodage des chaînes de caractères vraiment pour le serveur. 

On va également faire pareil pour les bases de données c'est-à-dire pour la base en elle-même d'accord au sein du serveur, les bases, les tables et tout ça, modifier ce qu'on appelle la collation donc c'est la partie collation pour tout ce qui concerne la plage d'encodage mais pour les données telles qu'elles sont stockées donc les bases de données les tables et cetera et les enregistrements que nous aurons. 

Pour ça nous allons juste faire collation-server = et on met pareil utf8mb4 qui est l'encodage ensuite il faut mettre un underscore pour ajouter unicode. C'est comme ça que ça s'écrit les encodages précis pour le collation et ensuite c'est un mode c'est-à-dire comment vous l'ouvrez et nous on va toujours travailler en case in sensitive donc ce ne sera pas sensible à la case.
```ini
	collation-server = utf8mb4_unicode_...
```
C'est par exemple un jour dans vos bases de données c'est-à-dire dans votre table, vous marquez ceci matable, ce sera égal à MATABLE, ce sera égal à maTABLE c'est-à-dire que pour nous C'est comme ça qu'on travaille généralement base de données on part du principe que marqué en majuscules ou en minuscules pour nous c'est la même chose sinon ça compliquerait un peu les choses donc on termine par ci, case insensitive d'accord voilà.

+ my.ini
```ini
	[mysqld]
	basedir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql
	datadir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql/data
	character-set-server = utf8mb4
	collation-server = utf8mb4_unicode_ci
```
Alors ça ça peut être intéressant. 

On peut mettre cs pour case sensitive si vous voulez avoir des données qui sont sensibles à la case. 

Il y a également as pour accent sensitive si vous voulez que les caractères accentués changent pour dire par exemple que é c'est différent de e au niveau de vos bases de données. 

Moi personnellement je veux que ce soit considéré comme étant la même chose donc moi je travaille de manière générale très souvent avec ce mode là en case insensitive, ci. 

Voilà utf8mb4_unicode_ci.

Et là nous avons toutes les informations nécessaires donc ces 2 lignes.
```ini
	character-set-server = utf8mb4
	collation-server = utf8mb4_unicode_ci
```
Et là nous avons toutes les informations nécessaires donc ces 2 lignes tout simplement pour la partie serveur. 

On va pouvoir maintenant faire pour [mysql] donc vous notez juste mysql entre crochets et vous allez ajouter tout simplement donc c'est très simple default-character-set = utf8mb4 voilà.

+ my.ini
```ini
	[mysqld]
	basedir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql
	datadir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql/data
	character-set-server = utf8mb4
	collation-server = utf8mb4_unicode_ci
	
	[mysql]
	default-character-set = utf8mb4
```
Voilà encore une fois la plage pour l'encodage des caractères pour mysql et ensuite on va répéter la même chose pour tous les clients éventuels qui se connecterait à mysql. 

On met donc [client] et on peut faire un copié collé de la ligne.

+ my.ini
```ini
	[mysqld]
	basedir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql
	datadir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql/data
	character-set-server = utf8mb4
	collation-server = utf8mb4_unicode_ci
	
	[mysql]
	default-character-set = utf8mb4
	
	[client]
	default-character-set = utf8mb4
```
Toutes les personnes qui vont se connecter en tant que client mysql pour arriver sur le serveur d'accord [mysqld] devront utiliser l'encodage ici [client]. 

Alors je n'aurais peut-être pas dû faire que ça comme ça. 

J'aurais peut-être déjà dû vous montrer l'encodage de base. 

On remet le my.ini tel qu'il est de base.

+ my.ini
```ini
	[mysqld]
	basedir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql
	datadir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql/data
```
De base tel qu'il était dans la vidéo précédente. 

Alors nous allons démarrer le serveur tout de suite et c'est ça que j'aurais dû vous montrer ce qui est un peu logique de voir comment la commande locale va être. 
```powershell
	> mysqld.exe --console
	
	2020-12-16T02:26:57.547776Z 0 [System] [MY-010116] [Server] C:\MyWAMP\mysql\bin\mysqld.exe (mysqld 8.0.22) starting as process 5988
	2020-12-16T02:26:57.575214Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
	2020-12-16T02:26:59.011850Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
	2020-12-16T02:26:59.270710Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060
	2020-12-16T02:26:59.305891Z 0 [System] [MY-010229] [Server] Starting XA crash recovery...
	2020-12-16T02:26:59.314201Z 0 [System] [MY-010232] [Server] XA crash recovery finished.
	2020-12-16T02:26:59.391963Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
	2020-12-16T02:26:59.392607Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
	2020-12-16T02:26:59.455513Z 0 [System] [MY-010931] [Server] C:\MyWAMP\mysql\bin\mysqld.exe: ready for connections. Version: '8.0.22'  socket: ''  port: 3306  MySQL Community Server - GPL.
```
Ensuite on va démarrer mysql et je n'ai pas de mot de passe sur Windows.
```powershell
	>mysql.exe -u root -p
	
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
Et là ce qu'on va faire c'est qu'on va juste faire quelques petites requêtes que vous n'avez pas besoin d'apprendre parce que ce sont des choses qu'on apprendra par la suite ne vous en faites pas. 

Je lui dis simplement de m'afficher des variables enregistrées en interne liées à MySQL mais qui sont écrites de la forme c'est-à-dire de manière tel que donc on utilise le mot like, cette forme que je vais mettre entre cotes '' donc 'char' parce que ça commence par char pour character ou quelque chose d'autre et je mets ensuite le symbole % pour dire que ça peut être suivi par n'importe quoi 'char%' et c'est tout.  
```sql
	> show variables like 'char%';

	+--------------------------+-----------------------------------------------+
	| Variable_name            | Value                                         |
	+--------------------------+-----------------------------------------------+
	| character_set_client     | cp850                                         |
	| character_set_connection | cp850                                         |
	| character_set_database   | utf8mb4                                       |
	| character_set_filesystem | binary                                        |
	| character_set_results    | cp850                                         |
	| character_set_server     | utf8mb4                                       |
	| character_set_system     | utf8                                          |
	| character_sets_dir       | C:\Users\sam\...\MyWAMP\mysql\share\charsets\ |
	+--------------------------+-----------------------------------------------+
	8 rows in set (0.02 sec)
```
Voilà comment ça marqué par défaut donc vous voyez que pour le client ou pour la connexion, on voit que pour les résultats (set_results) et pour les autres on voit que c'est du cp850 donc vous voyez que ce n'est pas le bon encodage. 

On voit quand même par contre rappelez vous qu'on est sur MySQL 8 donc c'est une version très récente au moment où je fais cette vidéo, on voit quand même qu'il a commencé à gérer utf8mb4 par défaut. 

Et c'est la nouveauté avec MySQL 8 il me semble, ils ont justement intégré par défaut pour une partie de certaines choses c'est encodage-là parce qu'il est évidemment plus efficace il va présenter beaucoup beaucoup moins de problèmes tel qu'on pouvait par exemple la voir avant utf8mb3. 

Ça ce tableau c'est donc le cas par défaut. 

On va se déconnecter. 

+ client
```powershell
	mysql> exit
	Bye
	
	PS C:\Users\sam> mysqladmin.exe -u root -p shutdown
	Enter password:
```
Voilà j'ai pas de mot de passe et ici on va quitter le serveur je rappelle. 

Ça c'est donc le cas par défaut tel que c'est normalement de base alors ce sera peut-être différent si vous installez une autre version de MySQL. 

Il est possible que vous ayez des résultats différents peu importe parce que l'intérêt c'est de voir à la fin on a bien quelque chose qui a été modifié. 

Ainsi on va remettre tout ce que j'avais, on va le remettre dans le my.ini. 

+ my.ini
```ini
	[mysqld]
	basedir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql
	datadir=C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/mysql/data
	character-set-server = utf8mb4
	collation-server = utf8mb4_unicode_ci
	
	[mysql]
	default-character-set = utf8mb4
	
	[client]
	default-character-set = utf8mb4
```
Alors le fichier my.ini sur Windows à avoir à la fin c'est ça, c'est vraiment le strict minimum.

L'information basedir= pour je rappelle le chemin principal de MySQL.
```ini
	basedir=
```
`datadir=` c'est le répertoire des données.
```ini
	datadir=
```
Et les différents encodages, les paramétrages d'encodage, vous avez 4 lignes grosso modo à gérer pour ça.
```ini
	character-set-server = utf8mb4
	collation-server = utf8mb4_unicode_ci
	
	[mysql]
	default-character-set = utf8mb4
	
	[client]
	default-character-set = utf8mb4
```
On y va et on va démarrer notre petit serveur et on va aller se connecter toujours pareil sans mot de passe.
```powershell
	>mysqld --console
	
	2020-12-16T19:52:51.311892Z 0 [System] [MY-010116] [Server] C:\MyWAMP\mysql\bin\mysqld.exe (mysqld 8.0.22) starting as process 6796
	2020-12-16T19:52:51.488055Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
	2020-12-16T19:52:54.464869Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
	2020-12-16T19:52:54.824525Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060
	2020-12-16T19:52:55.098690Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
	2020-12-16T19:52:55.100089Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
	2020-12-16T19:52:55.219481Z 0 [System] [MY-010931] [Server] C:\MyWAMP\mysql\bin\mysqld.exe: ready for connections. Version: '8.0.22'  socket: ''  port: 3306  MySQL Community Server - GPL.
```
```powershell
	> mysql.exe -u root -p
	
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
Alors je n'ai pas fais la requête pour montrer collation mais ce n'est pas grave, on va déjà regarder pour les caractères déjà. 

On va faire ça.
```sql
	> show variables like 'char%';
	
	+--------------------------+-----------------------------------------------+
	| Variable_name            | Value                                         |
	+--------------------------+-----------------------------------------------+
	| character_set_client     | utf8mb4                                       |
	| character_set_connection | utf8mb4                                       |
	| character_set_database   | utf8mb4                                       |
	| character_set_filesystem | binary                                        |
	| character_set_results    | utf8mb4                                       |
	| character_set_server     | utf8mb4                                       |
	| character_set_system     | utf8                                          |
	| character_sets_dir       | C:\Users\sam\...\MyWAMP\mysql\share\charsets\ |
	+--------------------------+-----------------------------------------------+
	8 rows in set (0.02 sec)
```
Et là vous voyez que tout est passé en utf8mb4 mais pas le système de fichiers qui lui est en binaire, des fois il peut même être en utf8 mais peu importe c'est pour la gestion binaire donc ça ne change pas. 

Et pour le système c'est toujours en utf 8 ça ne peut pas être changé, je vous le dis et ne soyez pas étonné si vous voyez que c'est toujours utf 8. 

Ça ça fonctionne toujours comme ça parce qu'il n'y a pas en fait besoin de plus. 

Il me semble de toute façon qu'on ne peut pas le changer la plage de caractère ici pour système, character_set_system, il n'y a aucun moyen de la changeur. 

Ça ne peut pas être surchargé donc écrasé en fait, on ne peut pas remplacer cette valeur. 

Logiquement tout doit être en utf8mb4 parce que vous avez bien spécifié cet encodage là. 

Ensuite character_set_filesystem en binary, et character_set_system qui reste en utf 8 et qui ne bouge pas. 

On peut faire une vérification supplémentaire donc on peut la faire avec show variables like et on va vérifier 'collation%' on va voir qu'il peut y avoir des choses aussi là qui ont un encodage précis et voilà.
```sql
	> show variables like 'collation%';
	+----------------------+--------------------+
	| Variable_name        | Value              |
	+----------------------+--------------------+
	| collation_connection | utf8mb4_0900_ai_ci |
	| collation_database   | utf8mb4_unicode_ci |
	| collation_server     | utf8mb4_unicode_ci |
	+----------------------+--------------------+
	3 rows in set (0.00 sec)
```
Alors pourquoi est-ce qu'il m'a mis 0900_ai pour collation_connection et donc pourquoi est-ce qu'il n'a pas mis unicode pour ça ? C'est étonnant même si ça ne posera pas problème parce que c'est en utf8mb4, je suis étonné qu'il ait mis ça comme ça. 

OK en tout cas c'est bon mais moi ce que je voulais c'était ça surtout utf8mb4. 

Alors c'est surtout ces 2 là qui sont importants collation_database et collation_server. 

Il faut que la base de données et le serveur soit géré comme ça en utf8mb4 donc c'est ce qu'on a fait avec my.ini. 

Okay okay là vous voyez que tout est prêt au niveau de l'encodage. 

On y va donc et en quitte.

+ client
```powershell
	> exit
	Bye

	> mysqladmin.exe -u root -p shutdown
	Enter password:
	>
	
	> cls
	
	> exit
```
Voilà donc ça c'est bon pour Windows. 

Avec ça vous avez tout ce qu'il faut pour travailler sur le bon encodage. 

L'avantage c'est que dès le départ avec cette formation, vous serez sur le même encodage que moi et surtout le bon encodage et normalement vous n'aurez pas de problème avec la gestion de vos données quand vous allez devoir traiter des caractères particuliers vous ne devriez pas avoir de problème. 

Si un jour vous travaillez sur des bases de données en ligne ou ailleurs, essayez de vous arranger pour modifier si possible toutes ces informations là. 

De toute façon plus tard lorsqu on créera des tables et tout ça, on verra comment spécifier les bons encodage pour être sûr de toujours travailler avec les données comme il faut donc on va faire ça tout du long pour être sûr de travailler correctement. 

Voilà pour Windows et j'ai été un petit peu long dans les explications mais encore une fois je ne pense pas que ce soit inutile, c'est bien de savoir ce que vous manipulez. 

Encore une fois vous aurez mine de rien appris beaucoup beaucoup de choses là où beaucoup de gens auraient installé MySQL en automatique elles n'auront absolument pas compris pourquoi est-ce que des fois ils ont des problèmes de caractère et tout ça parce qu'évidemment ils n'auront pas été édités eux-mêmes c'est-à-dire configurer leur environnement de travail. 

Ça pour Windows vous avez vu que c'était assez pratique, un seul fichier de configuration, on peut tout mettre dedans et ça se lit très facilement. 

Évidemment je ne l'ai pas dit mais ça paraît logique quand vous voulez modifier la configuration de MySQL, il ne faut pas avoir le serveur qui tourne ça paraît logique. 

Vous coupez le serveur il faut modifier la configuration et vous le démarrez pour que ça prenne en compte les changements sinon vous aurez évidemment de petits soucis. 

Ca je n'ai donc pas dit mais ça paraît logique.

On va terminer ou en tout cas poursuivre avec Linux et comme d'habitude on va montrer l'équivalence sur Linux. 

Linux c'est la même chose simplement que ce n'est pas le même fichier à éditer parce que vous avez vu que la configuration pour Linux était un poil un peu plus dispatché, un peu plus compliqué. 

Nous comme c'est notre configuration qu'on va rajouter, moi je le conseil de le mettre simplement dans un seul fichier pour éviter de s'éparpiller partout. 

On va retourner sur l'arborescence et rappelez-vous c'était dans 
```txt
	/etc/mysql/mysql.conf.d/mysqld.cnf
```
Et voilà c'est lui, mysqld.cnf. 

Celui qu'on va éditer. 

Alors on va faire, moi je passe directement par l'environnement graphique.
```bash
	sudo gedit /etc/mysql/mysql.conf.d/mysqld.cnf
```
Bref l'avantage c'est de tomber sur le bon fichier, c'est un fichier qui existe déjà donc voilà. 

Et on voit qu'il y a déjà la partie [mysql]. 

Plutôt que d'ajouter les données pour [mysql] directement à la suite là. 

Comme c'est ma configuration que je vais ajouter en plus pour éviter de toucher aux lignes qui ont déjà été générées par défaut à l'installation, je vais mettre tout ça à la fin. 

Je préfère mettre tout à la fin parce que si un jour j'ai un problème, je pourrais toujours les enlever et retrouver le fichier de base. 

Dans l'idéal vous pouvez faire une sauvegarde de ce fichier c'est à dire que vous pouvez copier ce fichier là pour en faire un backup. 

C'est même d'ailleurs ce que je conseille quand on commence à modifier des fichiers de configuration sur le système. 

C'est-à-dire que vous devez enregistrer le fichier d'origine en tant que backup avant de faire des modifications comme ça le jour où il y a un problème et que vous voulez revenir à une configuration de base vous n'aurez plus qu à restaurer l'ancien fichier et tout fonctionnera. 

Pas besoin de chercher comme ça quel ligne vous avez modifiée et cetera parce que ça pourrait très vite devenir compliqué avec des grosses modification. 

Alors ça je ne vais pas le faire parce que ça ne sert à rien pour le coup mais dans l'idéal pensez à faire une copie du fichier avant toute modification pour pouvoir le restaurer si nécessaire.

Là je vais leur noter comme j'ai fait pour Windows ça va être la même chose. 

Je vais noter [mysqld] et ici on va faire ceci.

+ mysqld.cnf
```ini
	[mysqld]
	character-set-server=utf8mb4
	collation-server=utf8mb4_unicode_ci
	
	[mysql]
	default-character-set=utf8mb4
	
	[client]
	default-character-set=utf8mb4
```
Ctrl+S pour enregistrer parce que je suis en graphique. 

Je n'ai plus qu'a démarrer le service et vérifier que tout est bon donc je n'ai pas montré avant tels que c'était parce que maintenant vous avez compris. 

Vu qu'on l'a fait sur Windows pas besoin de le répéter ici. 

En fait.
```bash
	sudo service mysql start
```
Voilà je peux même si je veux insister faire un reload pour prendre en compte les configurations.
```bash
	sudo service mysql reload
```
Voilà j'ai rechargé la configuration. 

OK et maintenant on peut se connecter.
```bash
	mysql -u root -p
```
Le mot de passe ici j'en avais un et on fait comme tout à l'heure.
```sql
	show variables  like 'char%';
```
```sql
	mysql> show variables  like 'char%';
	+--------------------------+----------------------------+
	| Variable_name            | Value                      |
	+--------------------------+----------------------------+
	| character_set_client     | utf8mb4                    |
	| character_set_connection | utf8mb4                    |
	| character_set_database   | utf8mb4                    |
	| character_set_filesystem | binary                     |
	| character_set_results    | utf8mb4                    |
	| character_set_server     | utf8mb4                    |
	| character_set_system     | utf8                       |
	| character_sets_dir       | /usr/share/mysql/charsets/ |
	+--------------------------+----------------------------+
	8 rows in set (0.00 sec)
```
Et voilà tout est en utfmb4 pour ça. 

Et on va faire la même chose pour collation.
```sql
	show variables  like 'collation%';
```
```sql
	mysql> show variables  like 'collation%';
	+----------------------+--------------------+
	| Variable_name        | Value              |
	+----------------------+--------------------+
	| collation_connection | utf8mb4_0900_ai_ci |
>	| collation_database   | utf8mb4_unicode_ci |
>	| collation_server     | utf8mb4_unicode_ci |
	+----------------------+--------------------+
	3 rows in set (0.00 sec)
```
OK et là vous voyez que pour collation_connection il nous met une valeur sur .._general_ donc c'est pour ça que je vous dise ça au final on s'en fiche au niveau de la connexion. 

Après en général tout ce qui est encodage au niveau connexion c'est à faire avec le système avec lequel vous vous connecterez. 

Si par exemple vous comptez faire de la base de données avec PHP, python, ruby ou autre, c'est avec ce langage là que vous pourrez faire une petite requête notamment en faisant juste un SET NAMES utf8mb4 par exemple. 

Eh bien vous pourrez faire cette petite requête qui va tout simplement dire qu'elle enregistre tout en utf8mb4 pour le coup. 

Ça vous permettra de gérer, par exemple même au niveau de la connexion ce mode là donc ça peut être éventuellement intéressant. 

On peut même d'ailleurs faire.
```sql
	SET NAMES utf8mb4 COLLATE utf8mb4_unicode_ci;
```
<!-- (erreur copier/coller)
	mysql> show variables  like 'collation%';
	+----------------------+--------------------+
	| Variable_name        | Value              |
	+----------------------+--------------------+
	| collation_connection | utf8mb4_unicode_ci |
	| collation_database   | utf8mb4_unicode_ci |
	| collation_server     | utf8mb4_unicode_ci |
	+----------------------+--------------------+
	3 rows in set (0.01 sec)
-->

Voilà ce genre de chose.

Bref ce qui nous intéressait c'était au niveau de la configuration donc là tout est modifié que vous soyez sur Windows ou sur Linux. 

Pour Mac os comme d'habitude essayez de vous dépatouiller mais logiquement ça ne devrait pas trop différer de Linux donc vous devriez certainement trouver le fichier de configuration également dans un répertoire MySQL que vous allez pouvoir modifier pour ajouter toutes les même choses c'est-à-dire le [mysqld], le [mysql], le [client] avec toutes les lignes que j'ai fait pour l'encodage et vous aurez quelque chose de fonctionnel par rapport à ça. 

Voilà maintenant nous travaillons sur les mêmes et on sera sûr de ne pas avoir de problème lié à l'encodage.

On quitte.
```bash
	sudo service mysql stop
	
	exit
```
Voilà je vous le dis commença à faire ça dès le départ c'est pas qu'une fois qu'on a des millions et des milliers de données enregistrées…

Ça parfois il y a des gens qui doivent le faire lorsqu'ils ont eu des problèmes en travaillant en utf 8 sur 3 octets, et un jour ils ont un caractère un peu particulier mis sur leur base de données qui fait tout planter ou qui fait des erreurs. 

Et dans ce cas ils sont obligés de passer en utf8mb4 et je vous raconte pas la galère que c'est parce que faire de la conversion d'encodage sur une base de données qui existe déjà, c'est le bazar parce qu'il y a très peu de chances que tout se passe bien du premier coup. 

Alors ça nécessitent des modifications manuelles, des vérifications, réparation optimisation de table, c'est la galère. 

Il n'y a rien de plus galère que devoir réparer ou faire une modification de configuration sur une base de données qui possède déjà des millions d'enregistrements et croyez moi les millions d'enregistrements sur une base de données, c'est quelque chose de très récurrent parce que les bases de données peuvent accueillir énormément de gigas voir de Terra octet de données donc on parle vraiment de grosses quantités de données. 

On ne parle pas de quelques méga ici d'accord on parle vraiment de giga ou de Terra octet. 

Pensez dès le départ à travailler comme ça. 

Plus tard quand vous ferez du web avec un langage de programmation éventuellement, que vous allez travailler sur MySQL ou même sur PhpMyAdmin et on aura l'occasion de parler un petit peu d'ailleurs. 

Vérifiez toujours dès le départ de bien mettre les bons encodages parce que dites-vous que tout ce qui sera fait au début ne posera plus de soucis par la suite surtout quand vous aurez plein de données. 

Pensez à faire ça dès le départ pour être tranquille par la suite. 

Je vais m'arrêter là pour cette vidéo, qui n'était pas si long que ça je pense pas mais il y avait quand même pas mal de choses à voir au niveau des encodages pour notre environnement de travail. 

Pour la prochaine vidéo nous allons parler des moteurs de stockage. 

C'est pareil, c'est une chose que les gens qui enseignent SQL n'évoque pas et pourtant c'est super important on ne peut pas passer à côté de ça parce que je connais plein de gens qui font du web et de la base de données et qui ne savent même pas ce que c'est innoDB, MyISAM ou d'autres moteurs de ce genre.

Nous on se réserve une vidéo qui sera peut être un peu longue le temps d'expliquer ça, pour présenter et expliquer ce qu'est c'est un moteur de stockage et justifier le choix de celui que nous utiliserons que nous prendrons pour utilisation sur la formation donc sur les différents cours que je vais vous proposer. 

Voilà je vous dis à très bientôt pour la suite de cette formation, j'espère que ça vous a plu et s'il y a des questions n'hésitez pas. 

Vérifiez de bien tout configurer de votre côté, de vous assurer que ça fonctionne, que vous en êtes au même résultat que moi et que tout est en utf8mb4 et vous n'aurez pas de problème pour la suite de ces vidéos. 

À bientôt tout le monde