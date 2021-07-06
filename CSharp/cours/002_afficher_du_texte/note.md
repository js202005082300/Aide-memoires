# [2. Afficher du texte](https://www.youtube.com/watch?v=T1ghHTJtdGQ)

## La classe Console

### La méthode WriteLine

```cs
using System;

class App
{
    static void Main(string[] args)
    {
        System.Console.WriteLine("Bonjour :) !");
    }
}
```
```powershell
dotnet new console -o FirstApp
cd .\FirstApp\
dotnet build
dotnet run
Bonjour :) !
```

On peut l'écrire en incluant uniquement la classe Console de l'environnement système, et là on peut écrire uniquement la méthode.

```cs
using System.Console;

class App
{
    static void Main(string[] args)
    {
        WriteLine("Bonjour :) !");
    }
}
```
```powershell
dotnet run
Bonjour :) !
```

On déconseille de faire ceci parce que les noms des méthodes sont assez générique !

### La méthode Write

Idem sans retour à la ligne.

```cs
using System;

class App
{
    static void Main(string[] args)
    {
        Console.Write("Bonjour :) !");
        Console.Write("Bonjour :) !");
    }
}
```
```powershell
dotnet run
Bonjour :) !Bonjour :) !
```

### La méthode Clear

Efface la console.

```cs
using System;

class App
{
    static void Main(string[] args)
    {
        Console.Write("Bonjour :) !");
        Console.Clear();
        Console.Write("Bonjour :) !");
    }
}
```
```powershell
dotnet run
Bonjour :) !
```

### La méhode Beep

```cs
using System;

class App
{
    static void Main(string[] args)
    {
        Console.Write("Bonjour :) !");
        Console.Clear();
        Console.Beep();
        Console.Write("Bonjour :) !");
    }
}
```
```powershell
dotnet run
Bonjour :) !
```

### Attribut Title

```cs
using System;

class App
{
    static void Main(string[] args)
    {
        Console.Title = "MyFirstProgram";
        Console.Read();
    }
}
```
```powershell
dotnet run
```

```txt
+-------------------------------+
| MyFirstProgram        - # x   |
|                               |
```

La méthode Read() met en pause le terminal sinon le titre va revenir au titre par défaut de la console.

## Les caractères spéciaux

`\n` pour retourner à la ligne.

```cs
using System;

class App
{
    static void Main(string[] args)
    {
        Console.Write("Bonjour !\nComment allez-vous ?");
    }
}
```
```powershell
dotnet run
Bonjour !
```

On obtient le même comportement que WriteLine().

`\t` pour la tabulation.

```cs
using System;

class App
{
    static void Main(string[] args)
    {
        Console.Write("\tBonjour !");
    }
}
```
```powershell
dotnet run
        Bonjour !
```

## Ecrire des commentaires

```cs
// Un seul commentaire

/*  Commentaire sur
    plusieurs lignes
*/
```

On verra en annexe comment documenter du code #C avec un sous-langage.