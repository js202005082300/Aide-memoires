# [8. Lecture au clavier](https://www.youtube.com/watch?v=qqx6uARSewY)

## La méthode Read

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello les p'tits mousses !");

        int c = Console.Read();
        Console.WriteLine(c);
    }
}
```
```powershell
dotnet run     
Hello les p'tits mousses !
d
100
```
```powershell
dotnet run
Hello les p'tits mousses !
A
65
```
```powershell
dotnet run
Hello les p'tits mousses !
a
97
```

On tape un charactère et l'interprêteur nous retourne l'entier correspondant de la table ascii.

Si on essaye de récupérer un entier, on va avoir un problème à la compilation : `char c = Console.Read();`. Par la suite on verra les conversion `char s = Convert.ToChar(c);` mais cette fonction peut être source de problème, on n'a pas vu les cas d'erreur.

Read() est à éviter sans la gestion des erreur.

## La méthode ReadLine

Retourne une chaîne, pose moins de soucis.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello les p'tits mousses !");

        string text = Console.ReadLine();
        Console.WriteLine(text);
    }
}
```
```powershell
dotnet run     
Hello les p'tits mousses !
bonjour les amis
bonjour les amis
```

La fin de saisie se fait avec Enter, ctrl+c annule la saisie.

## Le type ConsoleKeyInfo et la méthode ReadKey

Retourne une structure *ConsoleKeyInfo*.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello les p'tits mousses !");

        ConsoleKeyInfo ck1 = Console.ReadKey();

        Console.WriteLine(ck1);
    }
}
```
```powershell
dotnet run     
Hello les p'tits mousses !
tSystem.ConsoleKeyInfo
```

Cette fonction écoute jusqu'à saisie d'une touche au clavier.

On peut récupérer la clé `Key` ou la clé sous forme de charactère unicode `KeyChar`. Unicode c'est la forme des émoji codé sur nos smartphone.

On affiche c'est deux attributs avec un point.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello les p'tits mousses !");

        ConsoleKeyInfo ck1 = Console.ReadKey();

        Console.WriteLine(ck1.Key);
    }
}
```
```powershell
dotnet run     
Hello les p'tits mousses !
aA
```
```powershell
dotnet run     
Hello les p'tits mousses !
Escape
```
```powershell
dotnet run     
Hello les p'tits mousses !
Enter
```
```powershell
dotnet run     
Hello les p'tits mousses !
        Tab
```
```powershell
dotnet run     
Hello les p'tits mousses !
 Spacebar
```

Récupérer le caractère unicode.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello les p'tits mousses !");

        ConsoleKeyInfo ck1 = Console.ReadKey();

        Console.WriteLine(ck1.KeyChar);
    }
}
```
```powershell
dotnet run     
Hello les p'tits mousses !
pp
```

Peu importe le clavier physique (azerty, querty), il reconnait le charactère correspondant à la touche pressé.

On prend le caractère unicode donc la vrai valeur de la touche.