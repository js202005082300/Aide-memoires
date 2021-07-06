# [6. Conditions](https://www.youtube.com/watch?v=QkOUHfTVXEI)

## if

Exemple d'un jeu vidéo avec l'opérateur unaire !.

```cs
using System;

/*
    Rappel du minimum pour effectuer des conditions :
    Opérateurs (In)égalités (Booléen) : ==, !, <, >, <=, >=
    Opérateurs binaires conditionnels (Booléen) : &&, ||
*/

class Program
{
    static void Main(string[] args)
    {
        bool isLaunched = true;

        //il se passe tout un tas de choses...

        isLaunched = false;

        if(!isLaunched)
            Console.WriteLine("Jeu OFF");
    }
}
```
```powershell
dotnet new console -o FirstApp
cd .\FirstApp\
dotnet build
dotnet run
Jeu OFF
```

## else

Idem avec else.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        bool isLaunched = true;

        if(isLaunched)
        {
            Console.WriteLine("Jeu ON");
        }
        else
        {
            Console.WriteLine("Jeu OFF");
        }
    }
}
```
```powershell
dotnet run
Jeu ON
```

On peut les imbriquer.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        int number = 14;

        if(number > 0)
            if(number > 10)
                if(number == 14)
                    Console.WriteLine("Bingo !");
                else
                    Console.WriteLine("Perdu...");
    }
}
```
```powershell
```

On peut tester une condition stocké dans une variable intermédiaire.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        int number = 14;
        int result_test = number > 0;

        if(result_test)
            if(number > 10)
                if(number == 14)
                    Console.WriteLine("Bingo !");
                else
                    Console.WriteLine("Perdu...");
    }
}
```
```powershell
```

## else if

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        int number = 15;

        if(number > 0)
            Console.WriteLine("> 0");
        else if(number < 10)
            Console.WriteLine("< 0");               
        else
            Console.WriteLine("== 0");
    }
}
```
```powershell
dotnet run       
> 0
```

On peut faire juste des simples if(), else n'est pas obligatoire.

```cs
using System;

/*
    ==, !=, !, <, >, <=, >=
    &&, ||

    if()...[else if()]...[else]
*/

class Program
{
    static void Main(string[] args)
    {
        int number = 15;

        if(number > 0)
            Console.WriteLine("> 0");

        if(number > 10)
            Console.WriteLine("> 10");               
    }
}
```
```powershell
dotnet run       
> 0
> 10
```

Voilà la syntaxe pour ce langage `if()...[else if()]...[else]` d'autres langages utilisent `elif()` ou attaché `elseif()`.

## Cumuler les tests

```cs
using System;

/*
    ==, !=, !, <, >, <=, >=
    &&, ||

    if()...[else if()]...[else]
*/

class Program
{
    static void Main(string[] args)
    {
        int number = 26;

        if(number > 0 && number < 50)
            Console.WriteLine("OK");             
    }
}
```
```powershell
dotnet run       
OK
```

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        int number = 26;

        if(number > 0 || number < 50)
            Console.WriteLine("OK");             
    }
}
```
```powershell
dotnet run       
OK
```

## switch

Remplace au moins 4-5 structures conditionnelles.

Comme pour Java, on peut faire un test sur une chaîne de caractères (différent du C).

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        int number = 70;

        switch(number)
        {
            case 70:
                Console.WriteLine("C'est 70");
                break;
            default:
                break;
        }            
    }
}
```
```powershell
```

## Opérateur ternaire

Pas très lisible au niveau du code.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        bool result;
        int age = 19;

        result = (age >= 18) ? true : false;
        Console.WriteLine(result);       
    }
}
```
```powershell
dotnet run       
True
```

Ce n'est pas forcément un booléen, on peut faire d'autres affectations comme des calculs mais on perd vite en lisibilité.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        bool result;
        int age = 19;

        result = (age >= 18) ? 3 + 1 * (6 - 4) : false;
        Console.WriteLine(result);       
    }
}
```
```powershell
```

Ca c'était la version raccourcie mais on peut faire autrement.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        bool result;
        int age = 19;

        //result = (age >= 18) ? true : false;
        
        if(age >= 18)
            result = true;
        else
            result = false;
        
        Console.WriteLine(result);       
    }
}
```
```powershell
dotnet run       
True
```