# [Projets et solutions](https://www.youtube.com/watch?v=HaDML4J3Wzg)

+ [Introduction](#Introduction)
+ [Qu'est-ce qu'une solution ?](#Qu-est-ce-qu-une-solution)
+ [Créer une solution](#Créer-une-solution)
+ [Ajouter un projet à une solution](#Ajouter-un-projet-à-une-solution)
+ [Exécuter chaque projet séparément](#Exécuter-chaque-projet-séparément)
+ [Compiler tous les projets d'une solution](#Compiler-tous-les-projets-d-une-solution)
+ [Retirer un projet d'une solution](#Retirer-un-projet-d-une-solution)
+ [Communiquer entre différents projets d'une solution](#Communiquer-entre-différents-projets-d-une-solution)
+ [Organiser des bibliothèques de classes dans un dossier de solution](#Organiser-des-bibliothèques-de-classes-dans-un-dossier-de-solution)
+ [Conclusion](#Conclusion)

>

## Introduction

Créer un nouveau projet :

```ps1
> dotnet new console -o App
```

Noté que VS code permet un environnement de développement pour créer les projets, les dépendances et cetera.

## Qu est-ce qu une solution

Une solution est un container qui rassemble un ou plusieurs projets.

Une application peut avoir une partie pour la gestion de la base de données, une application graphique puis un projet de tests sur l'applications qui forment tout un tas d'application autour de notre application.

## Créer une solution

On crée un répertoire du même nom que le solution et le fichier à l'intérieur.

```ps1
> dotnet new sln -o GlobalApp
```
```txt
C:.
├───App
│   └───obj
└───GlobalApp
```

Lister les commandes :
```ps1
> cd .\GlobalApp\
> dotnet sln list
Aucun projet trouvé dans la solution.
```

## Ajouter un projet à une solution

Se mettre dans le répertoire où il y a le fichier de la solution pour avoir la commande la plus courte et ne pas renseigné le chemin.

On glisse le répertoire App manuellement à l'intérieur du dossier `.\GlobalApp\` et avec la commande `dotnet sln list`, il n'y aucun projet pour la solution.
```ps1
> cd .\GlobalApp\ 
> ls
    Rép .\Aides-mémoires\CSharp\tutoriels\GlobalApp

    App
    GlobalApp.sln

> dotnet sln list
    Aucun projet trouvé dans la solution.
> dotnet sln add .\App\App.csproj
    Projet 'App\App.csproj' ajouté à la solution.
> dotnet sln list
    Projet(s)
    ---------
    App\App.csproj
```

Ici on a ajouté le fichier que l'on veut mais on va ajouter un nouveau projet avec une partie pour les tests. `wpf` créé pour montrer que tout fonctionne bien. ENfin on ajoute le tout soit les test `Tests` et l'interface `UI`.

```ps1
> cd .\GlobalApp\ 
> dotnet new console -o Tests
    Le modèle « Application console » a bien été créé.
> dotnet new wpf -o UI
    Le modèle « Application WPF » a bien été créé.
> dotnet sln add .\Tests\Tests.csproj
    Projet 'Tests\Tests.csproj' ajouté à la solution.
> dotnet sln add .\UI\UI.csproj      
    Projet 'UI\UI.csproj' ajouté à la solution.
> dotnet sln list
    Projet(s)
    ---------
    App\App.csproj
    Tests\Tests.csproj
    UI\UI.csproj
```

On termine avec la commande pour tout lister et l'ensemble des 3 projets qui ont été ajouté.


## Exécuter chaque projet séparément

Chacun des 3 projets peuvent être exécutés séparemment, ils ont leur point de lancement.

Par exemple dans App/

```ps1
> cd .\App\    
> dotnet run
Hello, World!
```

On utilise la commande `run` si on veut le compiler et l'exécuter, ou `build` ...

## Compiler tous les projets d une solution

Au niveau du dossier de la solution, on doit faire `build` au lieu de `run` sinon il ne sera pas quel projet démarrer. Ainsi on peut lancer la compilation de l'ensemble et le programme va tout vérifier.

```ps1
> cd ..
> ls
    .\Aides-mémoires\CSharp\tutoriels\GlobalApp
        App
        Tests
        UI
        GlobalApp.sln
> dotnet build
    Identification des projets à restaurer...

    La génération a réussi.
        0 Avertissement(s)
        0 Erreur(s)

    Temps écoulé 00:00:04.34
```
Voilà il nous génère une bibliothèque, on peut procéder ainsi.

## Retirer un projet d une solution

Retirer un projet du fichier de configuration mais ça ne supprime pas le répertoire.

```ps1
> dotnet sln remove .\Tests\Tests.csproj
Projet 'Tests\Tests.csproj' retiré de la solution.
> dotnet sln list
    Projet(s)
    ---------
    App\App.csproj
    UI\UI.csproj
```

## Communiquer entre différents projets d une solution

Comment écrire un projet dans un autre car on pourrait avoir différents langages dans un même projet.

Pour travailler avec le code d'un projet dans un autre lorsqu'on a plusieurs fichiers sources :

Dans la séance précédente, on importait un espace de nom avec la directive `using` et après on faisait appel aux méthodes.

+ GlobalApp/App/Program.cs
```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }
}
```

Pour l'exemple, on crée un nouveau projet avec `-f net5.0` pour ne pas avoir les inclusions implicites.

```ps1
> dotnet new console -o Utils -f net6.0
    Le modèle « Application console » a bien été créé.
```

Et maintenant, nous mettons tout en `public` pour que ce soit accessible depuis l'extérieur (vaut mieux toujours l'indiquer explicitement). ET une petite fonction Test() dont on veut faire appel dans mon projet `App` donc il faut ajouter une dépendance.

+ GlobalApp/App/Program.cs
```cs
using Utils;
using System;

namespace App
{
    public class A
    {
        public static void Test()
        {
            Console.WriteLine("Un test depuis le projet Utils");
        }

        public static void Main(string[] args)
        {
            Console.WriteLine("Hello World de App !");
            U.Test();
        }
    }
}
```
+ GlobalApp/Utils/Program.cs
```cs
using System;

namespace Utils
{
    public class U
    {
        public static void Test()
        {
            Console.WriteLine("Un test depuis le projet Utils");
        }

        public static void Main(string[] args)
        {
            Console.WriteLine("Hello World de Utils !");
        }
    }
}
```

+ Créer la dépendance.

```ps1
> cd .\GlobalApp\App
> dotnet add reference ..\Utils\Utils.csproj
    Référence '..\Utils\Utils.csproj' ajoutée au projet.
> dotnet list reference 
    Référence(s) de projet
    ----------------------
    ..\Utils\Utils.csproj
```

L'espace de nom est ajouté `using Utils` puis l'appel à la classe `U` puisque nous faisons appel à une méthode statique.

```ps1
> cd ..
> ls
    Répertoire : .\CSharp\tutoriels\GlobalApp
> dotnet build
    La génération a réussi.
```

Maintenant la construction se passe bien sans problème de dépendance.

```ps1
> cd App
> dotnet run
Hello World de App !
Un test depuis le projet Utils
```

On peut exécuter encore les projets indépedemment lorsque plusieurs collaborateurs travaillent sur différents projets pour autant tout est lié à une même solution.

```ps1
> cd ..
> cd .\Utils\
> dotnet run
Hello World de Utils !
```

## Organiser des bibliothèques de classes dans un dossier de solution

Un ensemble de bibliothèques de classes peuvent classer dans un répertoire `.\GlobalApp\src\` dans lequel on met l'ensemble des projets.

Si on les déplace, on casse les chemins donc on va tout reprendre.

```ps1
> cd ..
> cd .\GlobalApp\
> Remove-Item *
> md src
> md lib
> ls        
    Répertoire : .\Aides-mémoires\CSharp\tutoriels\GlobalApp

    lib
    src
> cd .\src\
> dotnet new console -o App -f net6.0
    Le modèle « Application console » a bien été créé.
> cd .\lib\
> dotnet new classlib -o LibOne
    Le modèle « Bibliothèque de classe » a bien été créé.
> dotnet new classlib -o LibTwo
    Le modèle « Bibliothèque de classe » a bien été créé.
> cd ..
> ls        
    Répertoire : .\Aides-mémoires\CSharp\tutoriels\GlobalApp

        lib
        src
> dotnet new sln -n MaSol
    Le modèle « Fichier solution » a bien été créé.
> ls
    Répertoire : C:\MesProjets\Aides-mémoires\CSharp\tutoriels\GlobalApp

        lib
        src
        MaSol.sln
> dotnet sln add .\src\App\App.csproj
    Projet 'src\App\App.csproj' ajouté à la solution.
> dotnet sln list
    Projet(s)
    ---------
    src\App\App.csproj
> dotnet sln add .\lib\LibOne\LibOne.csproj --solution-folder lib
    Projet 'lib\LibOne\LibOne.csproj' ajouté à la solution.
> dotnet sln add .\lib\LibTwo\LibTwo.csproj --solution-folder lib
    Projet 'lib\LibTwo\LibTwo.csproj' ajouté à la solution.
> dotnet sln list
    Projet(s)
    ---------
    src\App\App.csproj
    lib\LibOne\LibOne.csproj
    lib\LibTwo\LibTwo.csproj
```

On crée deux bibliothèque de classe dans le répertoire lib puis on crée la solution `.sln` avec `-n` car nous sommes dans le répertoire en question, et on l'appelle *MaSol* pour l'exemple.

Enfin on ajoute l'ensemble à tout ça avec l'argument `--solution-folder lib` pour indiquer le répertoire que l'on a.

## Conclusion

Ce système de solution pour avoir plusieurs projets au sein d'une application.

Séparer chaque éléments dans un projet, idem via une interface graphique où on clique pour ajouter une référence, ajouter un projet et cetera.

A bientôt