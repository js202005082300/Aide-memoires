# [11. Énumérations](https://www.youtube.com/watch?v=Ux5xvUByCjk)

Bonjour dans cette séance nous allons parler des énumérations, ce qui fera directement ensuite avec le principe de données constantes avec les mots clés `const` et `readonly`.

On va poursuivre avec le principe de données constantes avec un type d'énumération qu'on va voir donc cette séance.

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

## Usage de enum

Le type d'énumération est un type valeur Comme les autres qu'on a vu jusqu'à présent et nous allons voir comment le créer. Ce type va permettre de définir, Rassembler un ensemble de constantes dites nommées.

Pour créer une énumération, On va le représenter par un bloc de code tel qu'on a vu pour les classes avec le mot-clé `enum`.

Par exemple on peut imaginer un niveau d'alertes pour une application qui serait alors capable de pouvoir générer des erreurs, avertissements, et cetera.

```cs
using System;

namespace App
{
    enum AlertLevel
    {
        Warning,
        Error,
        FatalError
    }

    class Program
    {
        static void Main(string[] args)
        {

        }
    }
}
```

Voilà nous avons le code minimal pour définir une énumération en CSharp.

Attention sous ce format-là, le niveau d'accès de l’énumération sera public Mais si on veut on peut également l'indiquer explicitement `public` comme ça son programme dans d'autres langages de programmation qui peuvent avoir un comportement par défaut différent, on a dit quant explicitement le terme on ne risque pas de se tromper ainsi.

Notez également que le type par défaut est `int` même si on n'a pas besoin de l'écrire.

```cs
using System;

namespace App
{
    public enum AlertLevel : int
    {
        Warning,
        Error,
        FatalError
    }

    class Program
    {
        static void Main(string[] args)
        {

        }
    }
}
```

Si je veux utiliser un autre type `short` Mais dans ce cas-ci on pourra avoir un type intégral c'est à dire qu'il ne représente qu'un entier : `sbyte`, `short`, `long`, `ulong` et cetera mais bon si on est sur un entier on n'aura pas besoin de le spécifier puisque c'est implicite.

```cs
public enum AlertLevel : short
```

Par défaut également les valeurs pour les constantes nommées c'est à dire que par défaut la première de notre liste aura pour valeur 0 et les autres auront des valeurs incrémenté de 1.

```cs
public enum AlertLevel
{
    Warning, // 0
    Error, // 1
    FatalError // 2
}
```

Alors on peut le spécifier explicitement ou bien ajouter d'autres valeurs.

```cs
public enum AlertLevel
{
    Warning = 0,
    Error = 10,
    FatalError = 20
}
```

Après il est préférable de laisser les valeurs par défaut ou de les indiquer explicitement pour éviter toute erreur dans des codes un peu plus complexes ou le risque serait que l'énumération lève des exceptions éventuellement si on n'arrive pas à déduire la valeur précisément de l'information déclarée.

En résumé nous avons une génération de valeur publique qui de manière sous-jacente va gérer des entiers, et on a ensuite notre liste de valeurs possibles avec leur valeur numérique associée.

Comment déclarer une variable de ce type d'énumération ? c'est très simple, on l'applique directement à une variable ainsi initialisée `AlertLevel a = AlertLevel.Warning;`.

```cs
using System;

namespace App
{
    enum AlertLevel
    {
        Warning = 0,
        Error = 1,
        FatalError = 2
    }

    class Program
    {
        static void Main(string[] args)
        {
            AlertLevel a = AlertLevel.Warning;
        }
    }
}
```

On peut écrire `AlertLevel a = 0;` mais ce sera moins explicite.

Avec ce type de programmation peut ainsi avoir quelque chose de plus explicite tout en ayant derrière encore une fois des entiers puisque `AlertLevel.Warning` correspond bien à un entier 0.

Alors il peut y avoir plusieurs applications par exemple dans des applications en 2D lorsqu'on veut représenter des couleurs en mettant une valeur en particulier même des valeurs en binaire ou pour chaque constant nommé, on indiquera sa valeur et c'est un c'est bien plus simple que d'avoir une liste de variables ou de faire ça dans un tableau donc ça permet d'avoir une certaine logique dans le fonctionnement de ce que l'on veut faire.

On va récupérer la valeur correspondante.

```cs
using System;

namespace App
{
    enum AlertLevel
    {
        Warning = 0,
        Error = 1,
        FatalError = 2
    }

    class Program
    {
        static void Main(string[] args)
        {
            AlertLevel a = AlertLevel.Warning;

            Console.WriteLine(a);
        }
    }
}
```
Créer un nouveau projet.
```powershell
> dotnet new console -o App
> cd .\App\
> dotnet build
> dotnet run
Warning
```

Noter que le tostring() va être appelé implicitement avec WriteLine() donc il va en fait récupérer `Warning`, le nom correspondant à la valeur ce qui ne serait évidemment pas le cas si on voulait récupérer la valeur numérique mais si on veut récupérer la valeur bien sûr il faudra procéder autrement.

On peut également retourner la liste des valeurs que contient l'énumération avec une bouche foreach().

```cs
using System;

namespace App
{
    enum AlertLevel
    {
        Warning = 0,
        Error = 1,
        FatalError = 2
    }

    class Program
    {
        static void Main(string[] args)
        {
            foreach(string name in Enum.GetNames(typeof(AlertLevel)))
            {
                Console.WriteLine(name);
            }
        }
    }
}
```
```powershell
> dotnet run
Warning
Error
FatalError
```

On peut ainsi récupérer la liste des différentes constantes nommées dans notre énumération.

On peut également voir si notre type d'énumération existe dans notre liste en faisant un test, par exemple si AlertLevel qui a le code d'alert 1 et voir s'il existe.

```cs
using System;

namespace App
{
    enum AlertLevel
    {
        Warning = 0,
        Error = 1,
        FatalError = 2
    }

    class Program
    {
        static void Main(string[] args)
        {
            if(Enum.IsDefined(typeof(AlertLevel), 2))
                Console.WriteLine("Oui !");
            else
                Console.WriteLine("Non");
        }
    }
}
```
```powershell
> dotnet run
Oui !
```

Voilà on affiche oui parce que on retrouve bien la valeur 2 dans notre énumération et si je teste quelque chose qui n'est pas disponible dans notre énumération cela affichera non puisqu'on ne rentre pas dans la condition.

```cs
using System;

namespace App
{
    enum AlertLevel
    {
        Warning = 0,
        Error = 1,
        FatalError = 2
    }

    class Program
    {
        static void Main(string[] args)
        {
            AlertLevel a1 = AlertLevel.Warning;
            AlertLevel a2 = AlertLevel.FatalError;
            
            if(a1 == a2)
                Console.WriteLine("égal");
        }
    }
}
```
```powershell
> dotnet run

```

On peut ainsi utiliser l'opérateur de comparaison et dans ce cas ci-dessous le message ne sera pas affiché parce que il y en a un qui est de type Warning et l'autre qui est de type FatalError et donc effectivement si je mets la même valeur pour les 2, on aura une égalité.

```cs
using System;

namespace App
{
    enum AlertLevel
    {
        Warning = 0,
        Error = 1,
        FatalError = 2
    }

    class Program
    {
        static void Main(string[] args)
        {
            AlertLevel a1 = AlertLevel.FatalError;
            AlertLevel a2 = AlertLevel.FatalError;
            
            if(a1 == a2)
                Console.WriteLine("égal");
        }
    }
}
```
```powershell
> dotnet run

```

Idem si on passe par la classe du type Enum avec la méthode Equals()

```cs
using System;

namespace App
{
    enum AlertLevel
    {
        Warning = 0,
        Error = 1,
        FatalError = 2
    }

    class Program
    {
        static void Main(string[] args)
        {
            AlertLevel a1 = AlertLevel.FatalError;
            AlertLevel a2 = AlertLevel.FatalError;
            
            if(a1.Equals(a2))
                Console.WriteLine("égal");
        }
    }
}
```
```powershell
> dotnet run
égal
```

Voilà c'est pareil et parfois, on peut avoir besoin de l'appeler si on a les instances.

:warning: l'énumération n'est pas une classe, ce n'est pas une structure, c'est vraiment différent de la déclaration de `int number;` comme on a fait dans les précédentes vidéos.

Voilà pour l'usage classique des énumérations.

## Une méthode extension

Maintenant si vous avez besoin d'ajouter des fonctionnalités et pour ça on va passer par une méthode d'extension, et si ça vous intéresse il faudra regarder dans la playlist des tutoriels parce que cette méthode ne s'applique pas qu’aux énumérations.

```cs
public static class CheckAlert
{
    public static AlertLevel error = AlertLevel.Error;

    public static bool IsError();
}
```

Ici on va vérifier le niveau d'alerte et on va considérer qu'une erreur va être une erreur tout simplement à partir du niveau `AlertLevel.Error`.

Ainsi une autre méthode pour vérifier si c'est une erreur, IsError().

Alors comme c'est une extension de méthode, il faut savoir que ça se reconnaît avec le mot-clé `this` qu'on a inclus comme paramètre dans la méthode et voilà comment on reconnaît une méthode d'extension tel que IsError().

```cs
public static class CheckAlert
{
    public static AlertLevel error = AlertLevel.Error;

    public static bool IsError(this AlertLevel a)
    {
        return a >= error;
    }
}
```

Voilà une énumération ne peut pas avoir de méthodes, j'applique à partir de cette class CheckAlert, je vais pouvoir travailler avec mon alerte et rajouter une fonctionnalité supplémentaire dans mon énumération.

On considère pour cette fonction que si c'est supérieur à 2, ce sera une erreur. Si est égal à 1, ce sera une erreur et si c’est en dessous, ce sera évidemment autre chose. Admettons par exemple que plus tard j'ajoute une autre valeur, ce sera également considéré comme une erreur mais si on rajoute un champ qui s'appelle Info et qui n'est pas une erreur, ça n'ira pas du tout !

```cs
enum AlertLevel
{
    Warning = 0,
    Error = 1,
    FatalError = 2,
    Info
}
```

Ou alors il faudra le mettre sous cette forme.

```cs
enum AlertLevel
{
    Info = -1,
    Warning = 0,
    Error = 1,
    FatalError = 2
}
```

On teste.

```cs
using System;

namespace App
{
    public enum AlertLevel
    {
        Warning = 0,
        Error = 1,
        FatalError = 2
    }

    public static class CheckAlert
    {
        public static AlertLevel error = AlertLevel.Error;

        public static bool IsError(this AlertLevel a)
        {
            return a >= error;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            AlertLevel a1 = AlertLevel.Warning;
            AlertLevel a2 = AlertLevel.Error;
            AlertLevel a3 = AlertLevel.FatalError;
            
            if(CheckAlert.IsError(a1))
                Console.WriteLine("a1 : C'est un niveau d'erreur");
            if(CheckAlert.IsError(a2))
                Console.WriteLine("a2 : C'est un niveau d'erreur");
            if(CheckAlert.IsError(a3))
                Console.WriteLine("a3 : C'est un niveau d'erreur");
        }
    }
}
```
```powershell
> dotnet run
a2 : C'est un niveau d'erreur
a3 : C'est un niveau d'erreur
```

Voilà pour un exemple de méthode d'extension.

Ciao