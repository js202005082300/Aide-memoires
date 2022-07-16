# [22. Fichiers](https://www.youtube.com/watch?v=R_X_nusMKgM)

+ [Introduction](#Introduction)
+ [Récupérer tout le contenu d'un fichier](#Récupérer-tout-le-contenu-d-un-fichier)
+ [Récupérer toutes les lignes dans un tableau](#Récupérer-toutes-les-lignes-dans-un-tableau)
+ [Gestion de l'encodage](#Gestion-de-l-encodage)
+ [Écrire une chaîne (ou tableau) dans un fichier](#Écrire-une-chaîne-dans-un-fichier)
+ [N'oubliez pas de gérer les erreurs !](#N-oubliez-pas-de-gérer-les-erreurs)
+ [Gestion de ressources](#Gestion-de-ressources)
+ [Lire un fichier ligne par ligne](#Lire-un-fichier-ligne-par-ligne)
+ [Écrire une ligne dans un fichier](#Écrire-une-ligne-dans-un-fichier)
+ [Méthodes usuelles pour les fichiers](#Méthodes-usuelles-pour-les-fichiers)
+ [Méthodes usuelles pour les répertoires](#Méthodes-usuelles-pour-les-répertoires)
+ [Bonus : d'autres outils pour les fichiers](#Bonus---Autres-outils-pour-les-fichiers)
+ [Conclusion](#Conclusion)

>


## Introduction

On abordera,
+ lecture & écriture
+ création de dossier/fichier
+ ajout & suppression
+ et cetera

Beaucoup de méthodes différentes pour lire nos fichiers : sous formes de caractères, sous forme binaire ou sous forme de flux.

On peut également avoir des versions synchronisées ou non-synchronisées, lecture synchrone ou lecture asynchrone.

## Récupérer tout le contenu d un fichier

Pas ligne par ligne mais la totalité d'un fichier dans une seule chaîne de caractères avec `ReadAllText`.

Inclure `System.IO` pour avoir des classes statiques notament `File` qui va permettre de faire tout ce que l'on veut sur la gestion de nos fichiers.

```cs
using System.IO;
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            string filepath = "data/names.txt";

            string allText = File.ReadAllText(filepath);
            Console.WriteLine(allText);
        }
    }
}
```
```ps1
> dotnet run
Squall Leonhart
Linoa Heartilly
Quistis Trèpe
Seifer Almasy
Laguna Loire
Edea Kramer
Zell Dincht
Ward Zabac
Irvine Kinéas
```

## Récupérer toutes les lignes dans un tableau

Récupérer dans un tableau de chaînes de caractères avec `ReadAllLines` au lieu d'une seule chaîne.

```cs
using System.IO;
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            string filepath = "data/names.txt";

            string[] allLines = File.ReadAllLines(filepath);
            

            foreach(string line in allLines)
            {
                Console.WriteLine("> " + line);
            }
        }
    }
}
```
```ps1
> dotnet run
> Squall Leonhart
> Linoa Heartilly
> Quistis Trèpe
> Seifer Almasy
> Laguna Loire
> Edea Kramer
> Zell Dincht
> Ward Zabac
> Irvine Kinéas
```

## Gestion de l encodage

Spécifier l'encodage avec le paramètre `Encoding.UTF8` (par défaut) ou `Encoding.ASCII`.

```cs
using System.IO;

string[] allLines = File.ReadAllText(filepath, Encoding.UTF8);
string[] allLines = File.ReadAllLines(filepath, Encoding.UTF8);
```

Vérifier le bon encodage des fichiers.

## Écrire une chaîne dans un fichier

Écrire une chaîne ou un tableau de chaînes.

```cs
using System.IO;
using System;

/*
    ReadAllText, ReadAllLines
    WriteAllText, WriteAllLines
*/

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            string filepath = "data/names.txt";
            
            // Écrire une chaîne
            string s = "Hello World";
            File.ReadAllText(filepath, s);

            // Écrire un tableau de chaînes
            string[] s;
            File.ReadAllLines(filepath, s);
            

            foreach(string line in allLines)
            {
                Console.WriteLine("> " + line);
            }
        }
    }
}
```
```ps1

```

## N oubliez pas de gérer les erreurs

Englober cela dans un bloc try/catch pour vérifier si le fichier existe bien.

## Gestion de ressources

Équivalent d'un gestionnaire de contexte en Python (syntaxe avec le mot clé `with`) pour la ressource en CSharp.

Utilisation de la syntaxe `using()` qui fonctionne en 3 étapes : acquisition de la ressource, utilisation de la ressource puis la suppression de cette resource soit l'acquisition d'un fichier, pour lire/écrire avant la fermeture du flux sans devoir le fermer nous-même.

## Lire un fichier ligne par ligne

Pour la lecture, StreamReader().

```cs
using System.IO;
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            string filepath = "data/names.txt";
            
            using(StreamReader sr = new StreamReader(filepath))
            {
                string line;

                while ((line = sr.ReadLine()) != null)
                    Console.WriteLine("Ligne : " + line);
            }
        }
    }
}
```
```ps1
> dotnet run
Ligne : Squall Leonhart
Ligne : Linoa Heartilly
Ligne : Quistis Trèpe  
Ligne : Seifer Almasy
Ligne : Laguna Loire
Ligne : Edea Kramer
Ligne : Zell Dincht
Ligne : Ward Zabac
Ligne : Irvine Kinéas
```

using() génère un contexte avec l'appel à une méthode pour récupérer le flux.

Ici pas besoin de gérer la fermeture de notre fichier dans un bloc finally et cetera mais rien nous empêche de gérer les exceptions avec try/catch.

Pour lire, on utilise un StreamReader que l'on instancie, et les accolades définissent la portée, le contexte de notre ressource.

On affiche les données, on pourrait vouloir les enregistrer dans un contenant, les modifier et cetera.

## Écrire une ligne dans un fichier

Et pour l'écriture, StreamWriter().

```cs
using System.IO;
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            string filepath = "data/names.txt";
            
            using(StreamWriter sr = new StreamWriter(filepath))
            {
                sr.WriteLine("Hello");
            }
        }
    }
}
```
```ps1
> dotnet run
```
```txt
Hello

```

## Méthodes usuelles pour les fichiers

Pour les fichiers, on a Exists(), Create(), Move(), Delete().

### Exists

Vérifier si le fichier existe et faire cela proprement ! Au minimum, on affiche le message d'exception.

Pareil pour la méthode ReadAllText(), il y a également un gestionnaire de contexte qui est pris en charge pour la fermeture de fichier comme pour using() donc pas besoin de bloc finally pour fermer le fichier.

```cs
using System.IO;
using System;

/*
    ReadAllText, ReadAllLines
    WriteAllText, WriteAllLines
    StreamReader, StreamWriter

    File :
        Exists(),
*/

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            string filepath = "data/names.txt";

            try
            {
                if(File.Exists(filepath))
                {
                    string text = File.ReadAllText(filepath);
                    Console.WriteLine(text);
                }
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {

            }
        }
    }
}
```
```ps1
> dotnet run
Hello

> 
```

### Create

```cs
using System.IO;
using System;

/*
    ReadAllText, ReadAllLines
    WriteAllText, WriteAllLines
    StreamReader, StreamWriter

    File :
        Exists(), Create(),
*/

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                File.Create("data/newnames.txt");
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
```
```ps1
> dotnet run
>
```

### Move

```cs
using System.IO;
using System;

/*
    ReadAllText, ReadAllLines
    WriteAllText, WriteAllLines
    StreamReader, StreamWriter

    File :
        Exists(), Create(), Move()
*/

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                string src = "data/names.txt";
                string dest = "names.txt";

                File.Move(src, dest);
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
```
```ps1
> dotnet run
>
```

### Delete

Attention à l'usage de cette méthode.

```cs
using System.IO;
using System;

/*
    ReadAllText, ReadAllLines
    WriteAllText, WriteAllLines
    StreamReader, StreamWriter

    File :
        Exists(), Create(), Move(), Delete()
*/

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                File.Delete("data/newnames.txt");
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
```
```ps1
> dotnet run
>
```

## Méthodes usuelles pour les répertoires

Pour les répertoires, on a :
+ Exists(), CreateDirectory(), Move(), Delete()
+ GetFiles(), GetDirectories()
+ GetParent(), GetCurrentDirectory()

### GetFiles

Par exemple, retourner les chemins relatifs des fichiers contenus, GetFiles().

```cs
using System.IO;
using System;

/*
    ReadAllText, ReadAllLines
    WriteAllText, WriteAllLines
    StreamReader, StreamWriter

    File :
        Exists(), Create(), Move(), Delete()
    Directory :
        Exists(), CreateDirectory(), Move(), Delete()
*/

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                string[] files = Directory.GetFiles("data/");

                foreach(string f in files)
                    Console.WriteLine("- " + f);
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
```
```ps1
> dotnet run
- data/fi.txt
- data/info.txt
- data/save.txt
> 
```

### GetParent

Obtenir le répertoire parent.

```cs
using System.IO;
using System;

/*
    ReadAllText, ReadAllLines
    WriteAllText, WriteAllLines
    StreamReader, StreamWriter

    File :
        Exists(), Create(), Move(), Delete()
    Directory :
        Exists(), CreateDirectory(), Move(), Delete()
        GetFiles(), GetDirectories()
        GetParent(), GetCurrentDirectory()
*/

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                Console.WriteLine(Directory.GetParent("data"));
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
```
```ps1
> dotnet run
C:\MesProjets\Aides-mémoires\CSharp\cours\FirstApp
```

## Bonus - Autres outils pour les fichiers

On peut rencontrer OpenText() qui ouvrirait les données en UTF8, au lieu de StreamReader(), directement pour de la lecture.

On peut également utiliser CreateText() au lieu du StreamWriter().

OpenText() et CreateText() sont par contre statique.

```cs
using(StreamReader sr = File.OpenText("data/names.txt"));

// au lieu de ...

using(StreamReader sr = new StreamReader("data/names.txt"));
```

Voir selon l'usage mais pour l'écriture et la lecture, utiliser OpenText() et StreamReader().

## Conclusion

Pour la lecture et l'écriture, utiliser OpenText() et StreamReader() sinon s'il y a peu de caractères, utiliser :
+ ReadAllText, ReadAllLines
+ WriteAllText, WriteAllLines

```cs
/*
    ReadAllText, ReadAllLines
    WriteAllText, WriteAllLines
    StreamReader, StreamWriter

    OpenText, CreateText

    File :
        Exists(), Create(), Move(), Delete()
    Directory :
        Exists(), CreateDirectory(), Move(), Delete()
        GetFiles(), GetDirectories()
        GetParent(), GetCurrentDirectory()
*/
```

On a vu rapidement OpenText et CreateText, le cas où on les rencontrerait.

Attention aux chemins, toujours compliqué. Faut s'entrainer ! Si le chemin fonctionne avec le code source, attention si on déplace l'excutable dans un répertoire différent.

À bientôt tout le monde pour la suite des vidéo sur la chaîne