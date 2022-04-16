# [19. Gestion d'erreurs](https://www.youtube.com/watch?v=eQrZVi6AXHo)

## Mode Debug

Eviter de faire de la documentation inutile.
Insérer les assertions `using System.Diagnostics;` et utiliser la méthode pour englober la condition à vérifier.
Si l'assertion est vrai, pas d'érreur déclenchée.

```cs
using System;
using System.Diagnostics;

namespace App
{
    class Program
    {
        static void PrintPositiveNumber(int n)
        {
            Debug.Assert(n > 0);
            Console.WriteLine(n);
        }

        static void Main(string[] args)
        {
            PrintPositiveNumber(15);
            PrintPositiveNumber(-1);
        }
    }
}
```
```powershell
> dotnet run
15
Process terminated. Assertion failed.
   at App.Program.PrintPositiveNumber(Int32 n)
   at App.Program.Main(String[] args)
```

Avec -1, l'assertion n'est pas validée donc cela entraîne une erreur et **le programme s'arrête**.

Quand on fait `dotnet build` ou `dotnet run` (commande qui fait un dotnet build avant), on est en mode débuguage. On produit un exécutable lié au développement. Et enfin on produit un programme pour la distribution en mode release.

Pour l'utilisateur final, on gère les erreurs différemment et il faut donc compiler d'une autre manière pour ignorer ces erreurs.

## Ignorer assertions faites en mode debug

```cs
> dotnet run -c release
15
-1
```
Le dossier qu'on distribue à l'utilisateur finale.
+ FirstApp\
    + bin\
        + release\
        + Debug\

Avant de produire le programme final, il corrige les erreurs levées en mode debug.

## Trace

Pour les assertions traitées en mode Debug et en mode Release.

```cs
using System;
using System.Diagnostics;

namespace App
{
    class Program
    {
        static void PrintPositiveNumber(int n)
        {
            Trace.Assert(n > 0);
            Console.WriteLine(n);
        }

        static void Main(string[] args)
        {
            PrintPositiveNumber(-1);
        }
    }
}
```
```powershell
> dotnet run
Process terminated. Assertion Failed
   at App.Program.PrintPositiveNumber(Int32 n)
   at App.Program.Main(String[] args)      

> dotnet run -c release
Process terminated. Assertion Failed
   at App.Program.PrintPositiveNumber(Int32 n)
   at App.Program.Main(String[] args)
```

L'assertion échoue. On obtient la même chose en mode Debug et en en mode Release. La méthode Assert() fonctionne dans les deux cas, en deuxième argument, on peut mettre un message.

```cs
using System;
using System.Diagnostics;

namespace App
{
    class Program
    {
        static void PrintPositiveNumber(int n)
        {
            Debug.Assert(n >= 0, "n >= 0", "n doit etre superieur ou egal a 0");
            Console.WriteLine(n);
        }

        static void Main(string[] args)
        {
            PrintPositiveNumber(-15);
        }
    }
}
```
```powershell
> dotnet run
Process terminated. Assertion failed.
n >= 0
n doit etre superieur ou egal a 0
   at App.Program.PrintPositiveNumber(Int32 n)
   at App.Program.Main(String[] args)
```

Voilà pour ajouter d'autres informations.

On verra dans une autre vidéo comment utiliser un fichier de log.

## Try Catch

Contrôler la saisie d'un utilisateur.

```cs
using System;
using System.Diagnostics;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Saisir un entier : ");

            int number = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine($"Le nombre saisi est {number}");
        }
    }
}
```
```powershell
> dotnet run
Saisir un entier : 
15
Le nombre saisi est 15

> dotnet run
Saisir un entier : 
Bonjour
Unhandled exception. System.FormatException: Input string was not in a correct format.      
   at System.Number.ThrowOverflowOrFormatException(ParsingStatus status, TypeCode type)     
   at System.Convert.ToInt32(String value)
   at App.Program.Main(String[] args)
```

Exception déclenchée par l'exécution de programme, on essaye de convertir une valeur qui n'est pas un nombre.

En terme d'héritage, cela est issue de la classe Exception.

Une exception qui n'est pas capturée va interrompre le programme, **il faut gérer toute exception qui peut survenir**.

Travailler avec la documentation, p.e. ToInt32() déclenchera tels exceptions.

```cs
using System;
using System.Diagnostics;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Saisir un entier : ");
            int number = 0;
            
            try
            {
                number = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine($"Le nombre saisi est {number}");
            }
            catch(Exception e)
            {
                Console.WriteLine(e);
            }
        }
    }
}
```
```powershell
> dotnet run
Saisir un entier :
152
Le nombre saisi est 152

> dotnet run
Saisir un entier : 
Bonjour
System.FormatException: Input string was not in a correct format.
   at System.Number.ThrowOverflowOrFormatException(ParsingStatus status, TypeCode type)     
   at System.Convert.ToInt32(String value)
   at App.Program.Main(String[] args)
```

En cas de mauvais scénarios, on affiche nous même la levée d'exception.

On peut adapter plus explicitement le message d'erreur.

### Gerer une exception

```cs
using System;
using System.Diagnostics;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Saisir un entier : ");
            int number = 0;
            
            try
            {
                number = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine($"Le nombre saisi est {number}");
            }
            catch(Exception)
            {
                Console.WriteLine("Saisie incorrecte");
            }
        }
    }
}
```
```powershell
> dotnet run
Saisir un entier : 
bonjour
Saisie incorrecte
```

Idem en capturant l'exception bien précise que nous avons obtenu : `FormatException`.

```cs
using System;
using System.Diagnostics;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Saisir un entier : ");
            int number = 0;
            
            try
            {
                number = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine($"Le nombre saisi est {number}");
            }
            catch(FormatException)
            {
                Console.WriteLine("Saisie incorrecte");
            }
        }
    }
}
```
```powershell
> dotnet run
Saisir un entier : 
bonjour
Saisie incorrecte
```

### Gerer plusieurs exceptions

```cs
try
{

}
catch(FormatException)
{

}
catch(OtherException)
{

}
catch(Exception)
{

}
```

La classe globale `Exception` doit être mise en dernier sinon on ne passerais jamais par les autres blocs.

Si on est sûr qu'on ne tombera jamais sur `Exception`, éventuellement on peut s'en passer.

## finally

Bloc exécuté peut importe le scénario try ou catch.

```cs
try
{

}
catch(FormatException)
{

}
catch(OtherException)
{

}
Finally
{

}
```

On test.

```cs
using System;
using System.Diagnostics;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Saisir un entier : ");
            int number = 0;
            
            try
            {
                number = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine($"Le nombre saisi est {number}");
            }
            catch(FormatException)
            {
                Console.WriteLine("Saisie incorrecte");
            }
            finally
            {
                Console.WriteLine("Je suis affiche dans tous les cas");
            }
        }
    }
}
```
```powershell
> dotnet run
Saisir un entier :
15
Le nombre saisi est 15
Je suis affiche dans tous les cas
> dotnet run
Saisir un entier : 
Bonjour
Saisie incorrecte
Je suis affiche dans tous les cas
```

Par exemple lorsqu'on a alloué des ressources dans le try avec besoin de les libérer même si le programme plante, par exemple on ouvre un fichier, ensuite la lecture déclenche une exception avec obligation de quand même fermé le fichier dans le bloc finally.

En python, on a le même modèle sauf que le bloc catch() est remplacé par except().

## Etendre une classe exception

Fabriquer une classe qui va étendre la classe Exception, ce qui permet de créer une classe propre à notre application.

Pour déclencher l'exception, on fait un `throw new`. Si la condition est vrai, on déclenche la fameuse exception puis la capturer comme si c'était une exception native du language `catch(MyBigExcepton e)`.

```cs
using System;
using System.Diagnostics;

namespace App
{
    class ProgramExeception : Exception
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Saisir un entier : ");
            int number = 0;

            try
            {
                // Code
                // Condition
                throw new MyBigException("Il ne fallait pas avoir les yeux plus gros que le ventre")
            }
            catch(MyBigExcepton e)
            {

            }
        }
    }
}
```

Retenez qu'en mode de distribution, les assertions seront ignorées du code donc une empreinte mémoire moins importante.

Toujours régarder les exceptions au niveau de la documentation suivant les types d'exceptions qui peuvent être levées avec les outils utilisés.

Ciao tout le monde