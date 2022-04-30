# [21. Espaces de noms](https://www.youtube.com/watch?v=rM5BbdxR9pk)

## Introduction

Créer automatiquement lorsqu'on crée un nouveau projet, on retrouve notre espace de noms lorsqu'on avait détaillé la structure d'un programme.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
        }
    }
}
```

Utiliser le mot-clé `namespace` et par convention on met une majuscule à l'espace de noms puis délimité par des accolades.

Tout notre code n'est pas contenu dans un seul fichier pour un projet sur du dessin en 2D, on a un dossier qui contient l'interface (Editor) puis des utilitaires (Util) puis pour la gestion des formes (Brush).

On utilisera l'arborescence des fichiers comme des espaces de noms :

+ App
    + bin
    + Brush
    + Editor
    + obj
    + Util
    + App.csproj
    + Program.cs

Incluant le terme System avec using est un espace de noms qui inclu d'autres espace de noms `Console.WriteLine("OK");`. System est l'espace de noms racine puis Console est une classe de System puis une méthode `System.Console.WriteLine("OK");`. System est un répertoire.

Hiéarchisation/oraginsation par espaces de noms.

L'identification d'une classe Test serait ici : `App.Test`, ce qui évite les conflits si d'autres classes du même nom.

```cs
using System;

namespace App
{
    class Test
    {
        static void Main(string[] args)
        {
            Console.WriteLine("OK");
        }
    }
}
```

Une mise à jour (>= Csharp 10.0) permet de définir tout le fichier comme espace de noms, en terminant l'instruction par un `;`.

```cs
using System;

namespace App;

class Test
{
    static void Main(string[] args)
    {
        Console.WriteLine("OK");
    }
}
```

## Appel

Appeler le constructeur d'un sous répertoire.

+ App
    + bin
    + Brush
    + Editor
        + Window.cs
    + obj
    + Util
    + App.csproj
    + Program.cs

+ Program.cs
```cs
using System;
using Editor;

namespace App;

class Test
{
    static void Main(string[] args)
    {
        Window w = new Window();
    }
}
```
+ Window.cs
```cs
using System;

namespace Editor
{
    class Window
    {
        public Window()
        {
            Console.WriteLine("Window()");
        }
    }
}
```
```Powershell
> dotnet run
Window()
```

## Alias

Pour éviter d'écrire toute l'arborescence, utiliser un alias.
```cs
using Terminal = Namespace1.Namespace2.Namespace3;
```

+ Program.cs
```cs
using Terminal = System.Console;

namespace App
{
    class Test
    {
        static void Main(string[] args)
        {
            Terminal.WriteLine("OK");
        }
    }
}
```

## Création programme

+ Program.cs
```cs
using System;

namespace App;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");
    }
}
```
```Powershell
> dotnet new console -o NewApp
Le modèle « Application console » a bien été créé.
...
```

On obtient :
```cs
// See https://aka.ms/new-console-template for more information
Console.WriteLine("Hello, World!");
```
```Powershell
> cd .\NewApp\
> dotnet run       
Hello, World!
```

Cela fonctionne sans espace de noms ou de classe !

Depuis Dotnet 6.0, on a des inclusions implicites.

Pour retrouver l'ancienne génération automatique :
```Powershell
> dotnet new console -o OldButNewApp -f net5.0
```
+ Program.cs
```cs
using System;

namespace OldButNewApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
        }
    }
}
```
Ici il n'y a plus d'inclusions automatique.

Ne pas oublier d'aller préciser la version que l'on a ici :

+ FirstApp.csproj
```xml
<Project Sdk="Microsoft.NET.Sdk">

  <PropertyGroup>
    <OutputType>Exe</OutputType>
    <TargetFramework>net6.0</TargetFramework>
    <ImplicitUsings>enable</ImplicitUsings>
    <Nullable>enable</Nullable>
  </PropertyGroup>

</Project>
```

`<ImplicitUsings>enable</ImplicitUsings>` permet d'avoir les inclusions implicites. 

Ainsi sans utiliser `using`, ça fonctionne !

+ Program.cs
```cs
namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
        }
    }
}
```
+ FirstApp.csproj
```xml
<Project Sdk="Microsoft.NET.Sdk">

  <PropertyGroup>
    <OutputType>Exe</OutputType>
    <TargetFramework>net6.0</TargetFramework> <!-- version 6-->
    <ImplicitUsings>enable</ImplicitUsings>
    <Nullable>enable</Nullable>
  </PropertyGroup>

</Project>
```
```Powershell
> dotnet run
Hello, World!
```

Dans ce cas, l'espace de noms et la classe Program sont facultatives.

Ciao tout le monde