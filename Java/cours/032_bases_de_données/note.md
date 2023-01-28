# [32. Bases de données](https://www.youtube.com/watch?v=TN_xTjbrzzc)

+ [Introduction](#Introduction)
+ [Données utilisées](#Données-utilisées)
+ [L'API JDBC](#L-API-JDBC)
+ [Requêtes sur une base SQLite](#Requêtes-sur-une-base-SQLite)
+ [Requêtes sur une base MySQL](#Requêtes-sur-une-base-MySQL)
+ [Requêtes sécurisées](#Requêtes-sécurisées)
+ [Point particulier sur les dates](#Point-particulier-sur-les-dates)
+ [Conclusion](#Conclusion)

>

## Introduction

Utilisation de méthodes au sein des classes, d'une interface.

En 1e SQLite qui travaille sur une version portable, embarquable avec l'app., pas de connexion à distance.

## Données utilisées
## L API JDBC

On a besoin d'un pilote car Java utilise une API qui est JDBC (Java Database Connectivity). Les pilotes par système de gestion se trouvent sur les sites spécifiques car ils ne sont pas natifs à la machine virtuelle.

+ [https://mavenlibs.com/](https://mavenlibs.com/)

... et chercher **SQLite JDBC** ou **MySQL Connector** (MySQL 8 minimum) ou d'autres pilotes à jour au format .jar

Lien vers le pilote SQLite : [https://github.com/xerial/sqlite-jdbc/releases](https://github.com/xerial/sqlite-jdbc/releases)  

Lien vers le pilote MySQL : [https://mavenlibs.com/maven/dependency/mysql/mysql-connector-java](https://mavenlibs.com/maven/dependency/mysql/mysql-connector-java)  

Visé des versions les plus récentes possibles.

## Requêtes sur une base SQLite

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main
{
    public static void main(String args[])
    {
        try
        {
            Connection co = DriverManager.getConnection("jdbc:sqlite:base.db");
            Statement stmt = co.createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM products");

            while(res.next())
            {
                String name = res.getString("product_name");
                float price = res.getFloat("product_price");
                System.out.println(name + ", vendu au prix de " + price + " euro.");
            }

            co.close();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
```

Toujours traiter les exceptions.

Comme pour les collections, on a un itérateur sur l'ensemble des enregistrements puis les parcourir.

On pourrait faire un bloc finally() pour fermer `co` mais alors il faut l'initialiser à null avec le bloc try catch.

Pour l'exécution sur Windows `java -classpath ".;sqlite-jdbc-3.40.0.0.jar" Main` et sur Linux/MacOs `java -classpath ".:sqlite-jdbc-3.40.0.0.jar" Main`

```ps1
> javac Main.java
> java -classpath ".;sqlite-jdbc-3.40.0.0.jar" Main
Zotac Gaming NVDIA GeForce RTX 3080, vendu au prix de 985.99 euro.
Logitech G502 LIGHTSPEED, vendu au prix de 159.0 euro.
FITFIU Fitness MC-200, vendu au prix de 389.99 euro.
Peluche Dora l'exploratrice, vendu au prix de 39.99 euro.
Nikon D5600, vendu au prix de 1049.99 euro.
SanDisk 32 Go Externe PRO SDXC, vendu au prix de 26.88 euro.
Pattex Bois Classic 250g, vendu au prix de 7.2 euro.
Lot de 4 bocaux en verre avec couvercle en bambou, vendu au prix de 34.99 euro.
Yaourts au lait entier vanille La Laitière, vendu au prix de 4.49 euro.        
SONGMICS fauteuil de bureau en toile, vendu au prix de 74.99 euro.
```

Lorsqu'on ne récupère pas de jeu de résultat :

```java
import java.sql.Connection;
import java.sql.DriverManager;
// import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main
{
    public static void main(String args[])
    {
        try
        {
            Connection co = DriverManager.getConnection("jdbc:sqlite:base.db");
            Statement stmt = co.createStatement();

            String req = "DELETE FROM products WHERE product_quantity = 15";
            stmt.executeUpdate(req);

            System.out.println("Produit supprimé");

            // while(res.next())
            // {
            //     String name = res.getString("product_name");
            //     float price = res.getFloat("product_price");
            //     System.out.println(name + ", vendu au prix de " + price + " euro.");
            // }

            co.close();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
```
```ps1
> javac Main.java
> java -classpath ".;sqlite-jdbc-3.40.0.0.jar" Main
Produit supprimÃ©
> 
```

executeQuery() si on retourne des données ou executeUpdate() si on ne retourne pas de résultats.

## Requêtes sur une base MySQL

```ps1
mysqld --console
mysql -u root -p
```
```sql
USE fv_database;
DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products`
(
    `product_id` INT NOT NULL AUTO_INCREMENT, 
    `product_name` VARCHAR(255) NOT NULL, 
    `product_price` FLOAT NOT NULL, 
    `product_quantity` INT NOT NULL, 
    PRIMARY KEY(`product_id`)
);
INSERT INTO `products` (`product_name`,`product_price`,`product_quantity`)
VALUES
('Zotac Gaming NVIDIA GeForce RTX 3080',985.99,15),
('Logitechh G582 LIGHTSPEED',159,3),
('FITFIU Fitness MC-200',389.99,11),
("Peluche Dora l'exploratrice",39.99,20),
('Nikon D5600',1849.99,2),
('SanDisk 32 Go Extreme PRO SDXC',26.88,48),
('Pattex Bois Classic 250g',7.2,13),
('Lot de 4 bocaux en verre avec couvercle en bambou',34.99,7),
('Yaourts au lait entier vanille La Laitière',4.49,0),
('SONGMICS fauteuil de bureau en toile',74.99,3);
```
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
jdbc:mysql://localhost:3306/fv_database?useSSL=false
*/

public class Main
{
    public static void main(String args[])
    {
        try
        {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/fv_database?useSSL=false", "root", ""); // changer le pilotes sur lequel se connecter
            Statement stmt = co.createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM products");

            while(res.next())
            {
                String name = res.getString("product_name");
                float price = res.getFloat("product_price");
                System.out.println(name + ", " + price + " euro.");
            }

            co.close();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
```
```ps1
> javac Main.java
> java -classpath ".;mysql-connector-java-8.0.30.jar" Main
Zotac Gaming NVIDIA GeForce RTX 3080, 985.99 euro.
Logitechh G582 LIGHTSPEED, 159.0 euro.
FITFIU Fitness MC-200, 389.99 euro.
Peluche Dora l'exploratrice, 39.99 euro.
Nikon D5600, 1849.99 euro.
SanDisk 32 Go Extreme PRO SDXC, 26.88 euro.
Pattex Bois Classic 250g, 7.2 euro.
Lot de 4 bocaux en verre avec couvercle en bambou, 34.99 euro.
Yaourts au lait entier vanille La Laitière, 4.49 euro.        
SONGMICS fauteuil de bureau en toile, 74.99 euro.
```

## Requêtes sécurisées

L'intérêt est de lutter contre les injections SQL dés lors qu'on demande des données formulaire à un utilisateur. La requête est préparée et on injecte les données via des méthodes pour avoir les bons type de données getString() et getFloat(). Utilisez toujours des **requêtes préparée**.

```java
import java.sql.Connection;
import java.sql.DriverManager;
// import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/*
jdbc:mysql://localhost:3306/fv_database?useSSL=false
*/

public class Main
{
    public static void main(String args[])
    {
        try
        {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/fv_database?useSSL=false", "root", "");
            PreparedStatement stmt = co.prepareStatement("UPDATE products SET product_name = ? WHERE product_name = ?");

            stmt.setString(1,"Ordinateur portable Lenovo");
            stmt.setString(2,"Nikon D5600"); 
            stmt.executeUpdate();

            co.close();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
```
```sql
mysql> select * from products;
+------------+---------------------------------------------------+---------------+------------------+
| product_id | product_name                                      | product_price | product_quantity |
+------------+---------------------------------------------------+---------------+------------------+
|          1 | Zotac Gaming NVIDIA GeForce RTX 3080              |        985.99 |               15 |
|          2 | Logitechh G582 LIGHTSPEED                         |           159 |                3 |
|          3 | FITFIU Fitness MC-200                             |        389.99 |               11 |
|          4 | Peluche Dora l exploratrice                       |         39.99 |               20 |
|          5 | Nikon D5600                                       |       1849.99 |                2 |
|          6 | SanDisk 32 Go Extreme PRO SDXC                    |         26.88 |               48 |
|          7 | Pattex Bois Classic 250g                          |           7.2 |               13 |
|          8 | Lot de 4 bocaux en verre avec couvercle en bambou |         34.99 |                7 |
|          9 | Yaourts au lait entier vanille La Laitière        |          4.49 |                0 |
|         10 | SONGMICS fauteuil de bureau en toile              |         74.99 |                3 |
+------------+---------------------------------------------------+---------------+------------------+
10 rows in set (0.00 sec)
```
```ps1
> javac Main.java
> java -classpath ".;mysql-connector-java-8.0.30.jar" Main
```
```sql
mysql> select * from products;
+------------+---------------------------------------------------+---------------+------------------+
| product_id | product_name                                      | product_price | product_quantity |
+------------+---------------------------------------------------+---------------+------------------+
|          1 | Zotac Gaming NVIDIA GeForce RTX 3080              |        985.99 |               15 |
|          2 | Logitechh G582 LIGHTSPEED                         |           159 |                3 |
|          3 | FITFIU Fitness MC-200                             |        389.99 |               11 |
|          4 | Peluche Dora l exploratrice                       |         39.99 |               20 |
|          5 | Ordinateur portable Lenovo                        |       1849.99 |                2 |
|          6 | SanDisk 32 Go Extreme PRO SDXC                    |         26.88 |               48 |
|          7 | Pattex Bois Classic 250g                          |           7.2 |               13 |
|          8 | Lot de 4 bocaux en verre avec couvercle en bambou |         34.99 |                7 |
|          9 | Yaourts au lait entier vanille La Laitière        |          4.49 |                0 |
|         10 | SONGMICS fauteuil de bureau en toile              |         74.99 |                3 |
+------------+---------------------------------------------------+---------------+------------------+
10 rows in set (0.00 sec)
```

## Point particulier sur les dates

Ces outils utilisent les méthodes Date() et Time() comme pour beaucoup de constructeurs, ces méthodes sont obseletes ou dépréciées.

Précédemment on a travaillé avec LocalDate et LocalTime, et non plus la classe Date et Time donc ré-utiliser ce que on a appris.

## Conclusion

Pour terminer ce cours de Java, le chapitre Réseaux et le chapitre sur les Interfaces graphiques.

Puis la vidéo de conclusion.

Ciao