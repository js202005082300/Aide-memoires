# [28 - Fichiers](https://www.youtube.com/watch?v=RYsa_zEe4Xs)

+ [Introduction](#Introduction)
+ [L'API NIO](#L-API-NIO)
+ [Instancier un chemin Path](#Instancier-un-chemin-Path)
+ [Lecture de données avec BufferedReader](#Lecture-de-données-avec-BufferedReader)
+ [Écriture de données avec BufferedWriter](#Écriture-de-données-avec-BufferedWriter)
+ [Modes d'ouverture d'un fichier](#Modes-d-ouverture-d-un-fichier)
> WRITE | TRUNCATE_EXISTING | CREATE | CREATE_NEW | APPEND | DELETE_ON_CLOSE
+ [Méthodes de manipulation de fichiers et répertoires](#Méthodes-de-manipulation-de-fichiers-et-répertoires)
> exists() | createFile() | createDirectory() | isDirectory() | isRegularFile() | move() | copy() | size() | delete() | deleteIfExists().
+ [Conclusion](#Conclusion)

>

## Introduction

Utilisation de l'api NIO, la bibliothèque la plus à jour à l'heure actuelle, la plus optimisée.

Plusieurs manières différentes mais certaines sont obsolètes.

## L API NIO

Utilisation de l'api NIO, la version 2, qui utilise beaucoup de nouveauté dont des classes de nouveau noms et optimisées p/r aux anciennes versions.

Api qui propose des interfaces non-bloquante donc plus à jour à l'usage de l'informatique aujourd'hui.

## Instancier un chemin Path

Définir le chemin du fichier à ouvrir.

Définir un type Path, et utiliser une autre classe `Paths` avec un s cette fois.

Ici pas besoin de spécifier de chemin s'il est dans le même dossier.

Définir un type BufferedReader pour notre tampon de lecture, que l'on fermera avec une méthode close().

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path f = Paths.get("infos.txt");

        try
        {
            BufferedReader bfr = Files.newBufferedReader(f);

            bfr.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Exception : " + e.getMessage());
        }
        finally
        {
            
        }
    }
}
```
+ infos.txt
```
abcdef
123456
```

Voilà notre tampon de lecture et le chemin sont configurés, on peut maintenant procéder aux opérations de lecture du fichier.

## Lecture de données avec BufferedReader

La méthode read() récupère un seul caractère.

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path f = Paths.get("infos.txt");

        try
        {
            BufferedReader bfr = Files.newBufferedReader(f);

            System.out.println(bfr.read());

            bfr.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Exception : " + e.getMessage());
        }
        finally
        {

        }
    }
}
```
+ infos.txt
```
abcdef
123456
```
```powershell
> javac App.java
> java App
97
```

On retourne le code du caractère *a*, retourné sous forme d'entier.

La méthode readLine() récupère la ligne.

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path f = Paths.get("infos.txt");

        try
        {
            BufferedReader bfr = Files.newBufferedReader(f);

            System.out.println(bfr.readLine());
            System.out.println(bfr.readLine());

            bfr.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Exception : " + e.getMessage());
        }
        finally
        {

        }
    }
}
```
+ infos.txt
```
abcdef
123456
```
```powershell
> javac App.java
> java App
abcdef
123456
```

Si on lit deux lignes à la suite, on a comme un curseur qui se positionne.

Ignorer des caractères, 5 par exemples `bfr.skip(5);`.

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path f = Paths.get("infos.txt");

        try
        {
            BufferedReader bfr = Files.newBufferedReader(f);

            bfr.skip(5);
            System.out.println(bfr.readLine());

            bfr.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Exception : " + e.getMessage());
        }
        finally
        {

        }
    }
}
```
+ infos.txt
```
abcdef
123456
```
```powershell
> javac App.java
> java App
f
```

On a donc ignoré *abcde* et affiché *f*. Comme ce sont des valeurs très très longue puisqu'on peut mettre un long.

Noté que le système s'arrête à `\n\r` selon le système d'exploitation et permet de détecter où s'arrête la lecture d'une ligne.

## Écriture de données avec BufferedWriter

On travail maintenant avec `import java.io.BufferedWriter;` au lieu de `import java.io.BufferedReader;`

Noté qu'on peut indiquer un mode d'ouverture sachant que c'est une énumération.

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path f = Paths.get("infos.txt");

        try
        {
            BufferedWriter bfw = Files.newBufferedWriter(f);

            bfw.write(67); // code 67 pour c
            bfw.write('a'); // a
            bfw.write("Bonjour");
            bfw.newLine();
            bfw.write("Hello");
            bfw.newLine();
            bfw.write("Hello World", 2, 5);

            bfw.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Exception : " + e.getMessage());
        }
        finally
        {

        }
    }
}
```
```powershell
> javac App.java
> java App
```
+ infos.txt
```
CaBonjour
Hello
llo W
```

Par défaut, il a éffacé l'ancien contenu.

Pour le retour à la ligne, on utilise la méthode newLine() indépendamment du système d'exploitation.

Pour tronquer, on précise en paramètres les positions 2 à 5.

Ne pas oublier qu'on peut passer les valeurs par variable ou des valeurs brutes.

```java
String s = "Hello World";

bfw.write(s, 2, 5);
```

## Modes d ouverture d un fichier

Importer `import java.nio.file.StandardOpenOption;` et on déclare le type `StandardOpenOption` dont une énumération.

+ **WRITE** pour l'écriture.
+ **TRUNCATE_EXISTING** pour tronquer un fichier qui existerais déjà.
+ **CREATE** pour créer un fichier qui n'existe pas.
+ **CREATE_NEW** pour créer un fichier et lève une erreur s'il existe déjà.
+ **APPEND** pour écrire à la fin d'un fichier existant en mettant le curseur à la fin.
+ **DELETE_ON_CLOSE** pour supprimer à la fermeture du fichier.

Importer `import java.nio.charset.Charset;` pour le formatage.

La méthode statique forName() pour ouvrir en UTF-8 (valeur par défaut).

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path f = Paths.get("infos.txt");
        Charset c = Charset.forName("UTF-8");
        StandardOpenOption mode = StandardOpenOption.DELETE_ON_CLOSE;

        try
        {
            BufferedWriter bfw = Files.newBufferedWriter(f, c, mode);
            String s = "Hello World";

            bfw.write(s, 2, 5);
            bfw.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Exception : " + e.getMessage());
        }
        finally
        {

        }
    }
}
```
```powershell
> javac App.java
> java App
```

Le fichier infos.txt est supprimer à la fermeture grâce au mode **DELETE_ON_CLOSE** pour un usage de fichier temporaire où on met dedans pour le supprimer ensuite.

## Méthodes de manipulation de fichiers et répertoires

Vérifier l'existence d'un fichier avec la méthode exists().

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path f = Paths.get("infos.txt");
        System.out.println(Files.exists(f));
    }
}
```
```powershell
> javac App.java
> java App      
false
```

Créer un fichier avec la méthode createFile(), attention aux permissions des répertoires d'où try/catch.

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path f = Paths.get("newFile.truc");
        try
        {
            Files.createFile(f);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
```
```powershell
> javac App.java
> java App
```

Créer un répertoire avec la méthode createDirectory().

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path dir = Paths.get("Machin/");

        try
        {
            Files.createDirectory(dir);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
```
```powershell
> javac App.java
> java App
```

Utiliser le simple slash `/`.

Vérifier si on a un répertoire ou un fichier, avec la méthode isDirectory() et isRegularFile().

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path dir = Paths.get("Machin/");

        System.out.println(Files.isDirectory(dir));
        System.out.println(Files.isRegularFile(dir));
    }
}
```
```powershell
> javac App.java
> java App
true
false
```

Déplacer un fichier dans un répertoire ou bien le renomer, avec la méthode move().

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path fileSource = Paths.get("newFile.truc");
        Path machinDir = Paths.get("Machin");
        Path fileDestination = machinDir.resolve("newFile.newTruc");

        try
        {
            Files.move(fileSource, fileDestination);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
```
```powershell
> javac App.java
> java App
```

Voilà le fichier a été déplacé et renomé.

Copier avec la méthode copy().

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path fileSource = Paths.get("newFile.truc");
        Path machinDir = Paths.get("Machin");
        Path fileDestination = machinDir.resolve("newFile.newTruc");

        try
        {
            Files.copy(fileSource, fileDestination);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
```
```powershell
> javac App.java
> java App
```

Retourner la taille en octets avec la méthode size().

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path f = Paths.get("infos.txt");

        try
        {
            System.out.println(Files.size(f));
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
```
```powershell
> javac App.java
> java App
0
```

Il nous affiche 0 car à une certaine limite, il considère que le fichier fait 0 mais il contient quelques petits caractères.

Supprimer un fichier avec la méthode delete(), ou supprimer un fichier s'il existe avec la méthode deleteIfExists() mais delete() risque de lever une erreur ce qui peut problème si on travaille dans un environnement multi-threadé.

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path f = Paths.get("infos.txt");

        try
        {
            Files.deleteIfExists(f);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
```
```powershell
> javac App.java
> java App
```

*infos.txt* a bien été éffacé.

## Conclusion

Attention aux anciennes versions avec NIO, voir IO tout court, les vieilles versions de l'api de java.

Ciao, ciao