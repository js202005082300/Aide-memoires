# [Base de données MySQL](https://www.youtube.com/watch?v=2R-BveCE-so)

[main.py](demo_db/main.py)
[data.sql](demo_db/data.sql)

Pour suivre cette vidéo, voir la séance 32 du cours où on a aborder comment communiqué avec une base de données depuis Python, et ce tutoriel permettra de passer par un autre système de gestion c'est-à-dire MySQL. On va voir qu'avec MySQL, beaucoup de choses sont similaires finalement entre ces différents SGBD et on va pouvoir communiquer de la même manière.

Alors ce n'est pas un cours MySQL mais c'est un cours sur Python, on va simplement utiliser une bibliothèque qui va nous permettre de communiquer avec un système MySQL. On peut retrouver le cours SQL notamment pour l'installation du serveur mysqld.exe et la connexion.

+ serveur
```powershell
mysqld --console
```
+ client
```powershell
mysql -u root -p
```
Voilà on fait une petite base de données  `datatest` avec une simple table qui référence en fait des ninjas et ensuite l'insertion de quelques informations qui seront affichées au sein de notre programme python.
+ data.sql
```sql
DROP DATABASE IF EXISTS `datatest`;
CREATE DATABASE IF NOT EXISTS `datatest`;
USE `datatest`;

/*
-------------------------------------------------------------------------------
-- Création des tables --------------------------------------------------------
-------------------------------------------------------------------------------
*/
CREATE TABLE IF NOT EXISTS `ninjatable`
(
    `id_ninja` INT NOT NULL AUTO_INCREMENT,
    `ninja_firstname` VARCHAR(30) NOT NULL UNIQUE,
    `ninja_lastname` VARCHAR(500) NOT NULL,
    PRIMARY KEY(`id_ninja`)
);

/*
-------------------------------------------------------------------------------
-- Ajout de quelques enregistrements ------------------------------------------
-------------------------------------------------------------------------------
*/
INSERT INTO `ninjatable`(`ninja_firstname`, `ninja_lastname`)
VALUES
('Naruto', 'UZUMAKI'),
('Kakashi', 'HATAKE'),
('Sakura', 'HARUNO'),
('Sasuke', 'UCHIHA'),
('Hinata', 'HYÛGA');
```
On a ensuite le fichier python sur lequel on va retravailler au cours de cette vidéo.
```py
#coding:utf-8
```

On va ajouter `datatest` donc là on va faire l'import de mon fichier.

```powershell
source C:/Python/tutos/demo_db/data.sql;
#... encore ...
source C:/Python/tutos/demo_db/data.sql;
#... encore une fois ...
source C:/Python/tutos/demo_db/data.sql;
```

+ client
```powershell
exit
mysqladmin -u root -p shutdown
```

On vérifie ensuite si les informations sont bien enregistrées.

```sql
mysql> describe ninjatable;
+-----------------+--------------+------+-----+---------+----------------+
| Field           | Type         | Null | Key | Default | Extra          |
+-----------------+--------------+------+-----+---------+----------------+
| id_ninja        | int          | NO   | PRI | NULL    | auto_increment |
| ninja_firstname | varchar(30)  | NO   | UNI | NULL    |                |
| ninja_lastname  | varchar(500) | NO   |     | NULL    |                |
+-----------------+--------------+------+-----+---------+----------------+
3 rows in set (0.01 sec)

mysql> select * from ninjatable;
+----------+-----------------+----------------+
| id_ninja | ninja_firstname | ninja_lastname |
+----------+-----------------+----------------+
|        1 | Naruto          | UZUMAKI        |
|        2 | Kakashi         | HATAKE         |
|        3 | Sakura          | HARUNO         |
|        4 | Sasuke          | UCHIHA         |
|        5 | Hinata          | HYÛGA          |
+----------+-----------------+----------------+
5 rows in set (0.00 sec)
```

D'accord ça c'était la première partie histoire de voir un affichage depuis le client pour voir qu'on opère bien sûr les données que nous avons et qu'elles sont bien importées.

Ensuite on va ouvrir un nouveau terminal de préférences administrateur, donc si on n'est sur Linux sur Mac OS, on parlera d'un terminal avec les droits superutilisateur donc il faudra passer en root. À partir de là on va utiliser l'outil `pip` (outil qui permet d'installer des packages, référence à un autre tutoriel). Là nous allons installer une version à jour de mysql-connector et à savoir la dernière version de MySQL c'est-à-dire la numéro 8 au moment où on la vidéo est faite.

```powershell
PS C:\WINDOWS\system32> pip install mysql-connector-python
Collecting mysql-connector-python
  Downloading mysql_connector_python-8.0.26-cp39-cp39-win_amd64.whl (799 kB)
     |████████████████████████████████| 799 kB 3.3 MB/s
Collecting protobuf>=3.0.0
  Downloading protobuf-3.17.3-cp39-cp39-win_amd64.whl (909 kB)
     |████████████████████████████████| 909 kB 2.2 MB/s
Collecting six>=1.9
  Downloading six-1.16.0-py2.py3-none-any.whl (11 kB)
Installing collected packages: six, protobuf, mysql-connector-python
Successfully installed mysql-connector-python-8.0.26 protobuf-3.17.3 six-1.16.0
```

Voilà dans ce cas ne pas oublier de mettre le terminal en mode d'administrateur pourquoi l'installation de MySQL se fasse.

Maintenant que le système est installé nous allons pouvoir l'utiliser, on fait un import. Alors normalement il y a énormément de choses similaires avec la séance 32 du cours.

+ main.py
```py
#coding:utf-8
import mysql.connector as MC
```

Alors nous allons procéder comme dans la séance 32 par rapport à SQLite, on va travailler avec une connexion à la base de données, ensuite on va travailler avec un curseur et à partir de là on va pouvoir faire toutes nos requêtes et les exécuter et éventuellement faire des commits si on a des insertions de données bref on retrouve toujours un petit peu le même principe.

Alors comme toute connexion à une base de données, il faut pouvoir garantir que cette connexion a bien été réalisée donc on va travailler dans un try except, finally avec certaines choses à faire si la connexion a réussi ou pas.

+ main.py
```py
#coding:utf-8
import mysql.connector as MC

try:
except:
finally:
```

On va établir la connexion dans la variable `conn`, en utilisant ensuite l'alias `MC` qui signifie *MySQL Connector* suivi d'une méthode qui s'appelle connect() qui est le même nom de méthode que pour le SGBD SQLite.

+ main.py
```py
#coding:utf-8
import mysql.connector as MC

try:
    conn = MC.connect()
except:
finally:
```

Alors ici dans ce tutoriel on voit MySQL connector, pourquoi ? Parce que tout simplement c'est-à-jour d'une part mais aussi parce que cet outil s'accorde avec les conventions qui ont été choisies pour manipuler des SGBD avec python. L'avantage surtout avec ce package là c'est qu'on voit toujours retrouver le même nom des méthodes et travailler avec les mêmes attributs ce qui permet de travailler avec quelque chose d'unifier.

Ainsi que vous soyez en train de travailler avec MySQL, SQLite ou un autre SGBD, vous utiliserez carrément toujours le même code.

Ensuite on précise toutes les informations de connexion, comme ici en étant local on va utiliser le nom localhost, la base de données datatest, le nom d'utilisateur et le mot de passe.

+ main.py
```py
#coding:utf-8
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
except:
finally:
```

Alors ça bien sûr c'est une connexion qui peut échouée donc on aura une erreur, en utilise l'alias MySQL Connector (MC) mais on va passer par la classe `Error` et ici pareil je vais mettre un alias pour que ce soit plus court `MC.Error as err` et au lieu de mettre un message explicite je vais juste afficher l'erreur directement.

+ main.py
```py
#coding:utf-8
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
except MC.Error as err:
    print(err)
finally:
```

Alors c'est la connexion a été fait ou pas, quoi qu'il arrive on vérifie ce qu'il s'est passé notamment si on est connecté, on va couper cette connexion, et on part du principe qu'il y a un curseur donc on mettra également la fermeture du curseur aussi.

+ main.py
```py
#coding:utf-8
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
except MC.Error as err:
    print(err)
finally:
    if(conn.is_connected()):
        cursor.close()
        conn.close()
```

Voilà on va justement initialiser notre curseur avec la méthode cursor() mais on va aller assez vite là dessus parce que ce sont des choses qu'on a déjà vu avec le cours avec SQLite encore une fois c'est très pratique comme ça on n'a pas besoin d'apprendre plusieurs syntaxes différentes.

+ main.py
```py
#coding:utf-8
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
    cursor = conn.cursor()

except MC.Error as err:
    print(err)
finally:
    if(conn.is_connected()):
        cursor.close()
        conn.close()
```

On va faire une petite requête SELECT pour afficher notamment les prénoms.

```sql
SELECT * FROM ninjatable;
```

On la récupère dans la variable `req` et ensuite on fait un `cursor.execute(req)` donc je rappelle que c'est le curseur à partir duquel on exécute notre requête alors je rappelle qu'on n'est pas obligé de passer par une variable intermédiaire.

+ main.py
```py
#coding:utf-8
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
    cursor = conn.cursor()

    req = 'SELECT * FROM ninjatable'
    cursor.execute(req)

except MC.Error as err:
    print(err)
finally:
    if(conn.is_connected()):
        cursor.close()
        conn.close()
```

Ici comme on va récupérer plusieurs données, on retrouve les mêmes méthodes comme pour SQLite c'est-à-dire fetchone, fetchall, fetchmany.

+ main.py
```py
#coding:utf-8
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
    cursor = conn.cursor()

    req = 'SELECT * FROM ninjatable'
    cursor.execute(req)

    #fetchone, fetchall, fetchmany

except MC.Error as err:
    print(err)
finally:
    if(conn.is_connected()):
        cursor.close()
        conn.close()
```

Plusieurs méthodes dont comment on passe par MySQL Connector, il s'est accordé pour convenir aux règles d'usage, aux conventions choisies pour interroger les SGBD avec python. C'est comme SQLite donc rien de nouveau c'est très simple.

Voilà nous allons faire un fetchall().

+ main.py
```py
#coding:utf-8
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
    cursor = conn.cursor()

    req = 'SELECT * FROM ninjatable'
    cursor.execute(req)

    ninjalist = cursor.fetchall()

except MC.Error as err:
    print(err)
finally:
    if(conn.is_connected()):
        cursor.close()
        conn.close()
```

À partir de là comme on a une séquence, un élément séquentiel, on fait pour chaque Ninja finalement de notre liste une petite boucle for pour afficher l'information que l'on veut et on va afficher par exemple le prénom.

+ main.py
```py
#coding:utf-8
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
    cursor = conn.cursor()

    req = 'SELECT * FROM ninjatable'
    cursor.execute(req)

    ninjalist = cursor.fetchall()

    for ninja in ninjalist:
        print('Prénom : {}'.format(ninja[0]))

except MC.Error as err:
    print(err)
finally:
    if(conn.is_connected()):
        cursor.close()
        conn.close()
```

Ainsi en première indice [0], rappelez-vous qu'on a l'identifiant.

```sql
mysql> use datatest
Database changed
mysql> SELECT * FROM ninjatable;
+----------+-----------------+----------------+
| id_ninja | ninja_firstname | ninja_lastname |
+----------+-----------------+----------------+
|        1 | Naruto          | UZUMAKI        |
|        2 | Kakashi         | HATAKE         |
|        3 | Sakura          | HARUNO         |
|        4 | Sasuke          | UCHIHA         |
|        5 | Hinata          | HYÛGA          |
+----------+-----------------+----------------+
5 rows in set (0.02 sec)
```

Nous alons donc récupérer le deuxième élément qui est l'indice [1].

+ main.py
```py
#coding:utf-8
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
    cursor = conn.cursor()

    req = 'SELECT * FROM ninjatable'
    cursor.execute(req)

    ninjalist = cursor.fetchall()

    for ninja in ninjalist:
        print('Prénom : {}'.format(ninja[1]))

except MC.Error as err:
    print(err)
finally:
    if(conn.is_connected()):
        cursor.close()
        conn.close()
```

Voilà normalement nous n'avons rien oublié, dans finally: le curseur est bien fermé et la connexion est bien fermée alors je rappelle que finally effets peu importe qu'on ait fait ce qu'il y a dans le try ou dans le except s'il y avait une exception quoi qu'il arrive au niveau de l'exécution de notre programme.

Voilà normalement on a fait tout ce qu'il fallait faire et nous allons ouvrir un nouveau terminal et on exécute tout ça.

```powershell
C:\Users\sam>cd C:.\Aide-mémoires\Python\tutos\demo_db\
C:.\Aide-mémoires\Python\tutos\demo_db>python main.py
Prénom : Naruto
Prénom : Kakashi
Prénom : Sakura
Prénom : Sasuke
Prénom : Hinata
```

En récupère bien les informations sur regarde par rapport à la base de données donc on a fait un SELECT ce qui est exactement ce que l'on attendait et ce que l'on voulait obtenir.

Voilà comment on travaille avec MySQL depuis python grâce à MySQL Connector donc c'est très facile et très simple.

Alors en petit bonus je vais vous noter quelques informations par rapport au curseur, nous avons `cursor.rowcount` qui permet en fait de compter la ligne ensuite vous allez avoir `cursor.lastrowid` qui permet tout simplement d'avoir le dernier identifiant.

```py
"""
cursor.rowcount
cursor.lastrowid
"""
```

Admettons que l'on veut faire une insertion d'éléments, il faudra récupérer le dernier identifiant en cours pour que vos identifiants se suivent mais en général ces identifiants on ne s'en sert pas c'est juste utile pour la base de données pour pouvoir enregistrer les informations, les enregistrements un à un donc si par exemple vous supprimez une information on perd tout simplement l'identifiant qui était enregistré pour cette information donc voilà c'est pour ça qu après les suppressions c'est intéressant de ne plus avoir l'identifiant.

Quand on fait de la JO on va s'assurer de récupérer le dernier identifiant ce qui permet de faire les choses de manière dynamique.

Voilà on ne va pas compter nous-mêmes ce qu'il y a dans la base de données pour faire nous-mêmes les insertions.

Voilà on faire une insertion.

+ main.py
```py
#coding:utf-8
"""
cursor.rowcount
cursor.lastrowid
"""
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
    cursor = conn.cursor()

    req = 'INSERT INTO ninjatable(id_ninja, ninja_firstname, ninja_lastname) VALUES(%s, %s, %s)'
    cursor.execute(req)

    ninjalist = cursor.fetchall()

    for ninja in ninjalist:
        print('Prénom : {}'.format(ninja[1]))

except MC.Error as err:
    print(err)
finally:
    if(conn.is_connected()):
        cursor.close()
        conn.close()
```

Alors comme je n'ai pas envie de passer les valeurs je vais passer par des jokers `%s` qui seront traités comme des chaînes ensuite je vais passer les infos que l'on va passer comme un tuple.

Alors pour commencer ce n'est pas à moi d'indiquer le nom de l'identifiant, on veut un programme dynamique c'est à dire que ce n'est pas à nous de regarder la table et de dire que le prochain événement c'est le 6e donc on va passer `cursor.lastrowid` qui est un attribut du curseur qui nous permettra de récupérer le dernier en cours sociaux entre temps je fais des opérations mais normalement non puisqu'on vient d'ajouter les données en début de vidéo. Ensuite je n'ai plus qu à entrer les informations que je veux c'est à dire un autre Ninja.

+ main.py
```py
#coding:utf-8
"""
cursor.rowcount
cursor.lastrowid
"""
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
    cursor = conn.cursor()

    req = 'INSERT INTO ninjatable(id_ninja, ninja_firstname, ninja_lastname) VALUES(%s, %s, %s)'
    infos = (cursor.lastrowid, 'Shikamaru', 'Nara')

    cursor.execute(req)
    ninjalist = cursor.fetchall()

    for ninja in ninjalist:
        print('Prénom : {}'.format(ninja[1]))

except MC.Error as err:
    print(err)
finally:
    if(conn.is_connected()):
        cursor.close()
        conn.close()
```

Ensuite au niveau de l'exécution `cursor.execute(req)` comme on en premier argument la requête mais là comme on injecte des informations ici `infos = … `, on va les passer en 2e argument `cursor.execute(req, infos)` et bien sûr au niveau de la connexion on va pas oublier de faire un commit() sinon les changements ne seront pas pris en compte c'est à dire qu'ils ne seront pas enregistrés sur la base de données.

Si à l'exécution on refait un affichage, on verra quel affichage il y a bien un nouveau Ninja qui a été affiché par contre dans la base de données en dur, dans le fichier de la base de données ça n'aura pas été enregistré donc c'est le commit() qui permet de faire ça.

```py
#coding:utf-8
"""
cursor.rowcount
cursor.lastrowid
"""
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
    cursor = conn.cursor()

    req = 'INSERT INTO ninjatable(id_ninja, ninja_firstname, ninja_lastname) VALUES(%s, %s, %s)'
    infos = (cursor.lastrowid, 'Shikamaru', 'Nara')

    cursor.execute(req, infos)
    conn.commit()

    ninjalist = cursor.fetchall()

    for ninja in ninjalist:
        print('Prénom : {}'.format(ninja[1]))

except MC.Error as err:
    print(err)
finally:
    if(conn.is_connected()):
        cursor.close()
        conn.close()
```

Ensuite pour les afficher on va refaire une requête SELECT comme tout à l'heure, on fait un fetchall() et on affiche tout histoire de voir que l'information a bien été ajoutée.

```py
#coding:utf-8
"""
cursor.rowcount
cursor.lastrowid
"""
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
    cursor = conn.cursor()

    req = 'INSERT INTO ninjatable(id_ninja, ninja_firstname, ninja_lastname) VALUES(%s, %s, %s)'
    infos = (cursor.lastrowid, 'Shikamaru', 'Nara')

    cursor.execute(req, infos)
    conn.commit()

    req = 'SELECT * FROM ninjatable'
    cursor.execute(req)

    ninjalist = cursor.fetchall()

    for ninja in ninjalist:
        print('Prénom : {}'.format(ninja[1]))

except MC.Error as err:
    print(err)
finally:
    if(conn.is_connected()):
        cursor.close()
        conn.close()
```
```powershell
C:.\Aide-mémoires\Python\tutos\demo_db>python main.py
Prénom : Naruto
Prénom : Kakashi
Prénom : Sakura
Prénom : Sasuke
Prénom : Hinata
Prénom : Shikamaru
```

Shikamaru a bien été ajouté à la liste des Ninjas.

Encore une fois ici c'est seulement un affichage c'est à dire qu'on arrive au même résultat en console mais c'est vraiment le commit() qui a permis d'enregistrer l'information.

Ainsi le meilleur moyen de s'en assurer c'est d'aller au niveau de son client, de refaire une petite requête directement et finalement de constater que Shikamaru a bien été ajouté à la base de données et qu'il porte bien l'identifiant le plus logique c'est à dire celui qui vient juste après le 5 c'est à dire le 6.

+ client
```sql
mysql> SELECT * FROM ninjatable;
+----------+-----------------+----------------+
| id_ninja | ninja_firstname | ninja_lastname |
+----------+-----------------+----------------+
|        1 | Naruto          | UZUMAKI        |
|        2 | Kakashi         | HATAKE         |
|        3 | Sakura          | HARUNO         |
|        4 | Sasuke          | UCHIHA         |
|        5 | Hinata          | HYÛGA          |
|        6 | Shikamaru       | Nara           |
+----------+-----------------+----------------+
6 rows in set (0.00 sec)
```

Voilà il n'y a rien de plus à vous montrer, ça rejoint ce qu'on a vu avec SQLite.

Maintenant il suffit simplement de manipuler SQL et de savoir un minimum programmer en Python et vous pourrez faire tout un tas de requêtes, de modifications et de suppressions comme on pourrait le faire en SQL sans même passer par un langage de programmation.

On verra plus tard éventuellement si on fera d'autres tutoriels avec d'autres SGBD.

Ciao tout le monde