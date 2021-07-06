# [5. Opérateurs](https://www.youtube.com/watch?v=9zUUp3HOtxo)

## Opérateur affectation

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string name = "Robert";
    }
}
```

## Opérateurs arithmétiques binaires

Addition.

```cs
using System;

/*
    Arithmétique +, -, *, /, %
*/

class Program
{
    static void Main(string[] args)
    {
        int result = 3 + 2;
        Console.WriteLine(result);
    }
}
```
```powershell
dotnet new console -o FirstApp
cd .\FirstApp\
dotnet build
dotnet run
5
```

Division.

```cs
using System;

/*
    Arithmétique +, -, *, /, %
*/

class Program
{
    static void Main(string[] args)
    {
        double result = 3 / 2;
        Console.WriteLine(result);
    }
}
```
```powershell
dotnet run
1
```

Modulo.

```cs
using System;

/*
    Arithmétique +, -, *, /, %
*/

class Program
{
    static void Main(string[] args)
    {
        double result = 5 % 2;
        Console.WriteLine(result);
    }
}
```
```powershell
dotnet run
1
```

Opérateur utilisé pour vérifier la parité et du codage sur des algorythmes de chiffrement.

## Raccourcis

```cs
using System;

/*
    Arithmétique +, -, *, /, %

    priorité : (5 + 3) * 2
*/

class Program
{
    static void Main(string[] args)
    {
        int result = 0;

        result = result + 5;

        Console.WriteLine(result);
    }
}
```
```powershell
dotnet run
5
```

L'affectation est non prioritaire, on peut donc faire `result += 5`.

```cs
using System;

/*
    Arithmétique    :  +, -, *, /, %
    Affectation     :  =, +=, -=, *=, /=, %=
*/

class Program
{
    static void Main(string[] args)
    {
        int result = 0;

        result += 5;

        Console.WriteLine(result);
    }
}
```
```powershell
dotnet run
5
```

Ainsi ce sont des affectations mais avec un calcul avant.

## Opérateurs arithmétiques unaires

```cs
using System;

/*
    Arithmétique    :   +, -, *, /, %   (binaire)
                        +, -, ++, --    (unaire)
    
    Affectation     :   =, +=, -=, *=, /=, %=
*/

class Program
{
    static void Main(string[] args)
    {
        int result = 0;

        result = -5;

        Console.WriteLine(result);
    }
}
```
```powershell
dotnet run
-5
```

On utilise l'opérataire unaire - pour marquer la négation `result = -5;` mais généralement on ne met pas `result = +5;` avec le + qui est implicite.

Puis on a les opérateurs d'incrémentation (++) et de décrémentation (--).

```cs
using System;

/*
    Arithmétique    :   +, -, *, /, %   (binaire)
                        +, -, ++, --    (unaire)
    
    Affectation     :   =, +=, -=, *=, /=, %=
*/

class Program
{
    static void Main(string[] args)
    {
        int result = 5;

        result++;//result = result + 1 | result += 1

        Console.WriteLine(result);
    }
}
```
```powershell
dotnet run
6
```

```cs
using System;

/*
    Arithmétique    :   +, -, *, /, %   (binaire)
                        +, -, ++, --    (unaire)
    
    Affectation     :   =, +=, -=, *=, /=, %=
*/

class Program
{
    static void Main(string[] args)
    {
        int result = 5;

        result--;

        Console.WriteLine(result);
    }
}
```
```powershell
dotnet run
4
```

La pré incrémentation.

```cs
using System;

/*
    Arithmétique    :   +, -, *, /, %   (binaire)
                        +, -, ++, --    (unaire)
    
    Affectation     :   =, +=, -=, *=, /=, %=
*/

class Program
{
    static void Main(string[] args)
    {
        int result = 5;

        ++result;

        Console.WriteLine(result);
    }
}
```
```powershell
dotnet run
5
```

L'incrémentation `result++` ou `++result` fait une incrémentation.

On aura une différence si on fait `result = result++;` ou `result = ++result;` avec une affectation après et l'autre avant.

```cs
using System;

/*
    Arithmétique    :   +, -, *, /, %   (binaire)
                        +, -, ++, --    (unaire)
    
    Affectation     :   =, +=, -=, *=, /=, %=
*/

class Program
{
    static void Main(string[] args)
    {
        int result = 5;

        //result = result++;
        //result = ++result;
        
        Console.WriteLine(++result);
    }
}
```
```powershell
dotnet run
6
```

L'incrémentation est faites avant ou après l'affichage en console.

On voit que quand on fait `result = ++result;` il y a un risque de caractère inatendu dû à l'opérateur d'affectation qui rentre en compte.

En terme de performance, c'est plus rapide de faire une pré incrémentation `++result`.

## Opérateurs égalités

```cs
using System;

/*
    Arithmétique    :   +, -, *, /, %   (binaire)
                        +, -, ++, --    (unaire)
    
    Affectation     :   =, +=, -=, *=, /=, %=

    Booléen - (In)égalité   :   ==, !, <, >, <=, >=
*/

class Program
{
    static void Main(string[] args)
    {
        bool result = (5 == 6);

        
        Console.WriteLine(result);
    }
}
```
```powershell
dotnet run
False
```

On évalue une expression qui retourne vrai ou faux.

```cs
using System;

/*
    Arithmétique    :   +, -, *, /, %   (binaire)
                        +, -, ++, --    (unaire)
    
    Affectation     :   =, +=, -=, *=, /=, %=

    Booléen - (In)égalité   :   ==, !, <, >, <=, >=
*/

class Program
{
    static void Main(string[] args)
    {
        bool result = (5 != 6);

        
        Console.WriteLine(result);
    }
}
```
```powershell
dotnet run
True
```

Retourner la négation de false.

```cs
using System;

/*
    Arithmétique    :   +, -, *, /, %   (binaire)
                        +, -, ++, --    (unaire)
    
    Affectation     :   =, +=, -=, *=, /=, %=

    Booléen - (In)égalité   :   ==, !, <, >, <=, >=
*/

class Program
{
    static void Main(string[] args)
    {
        bool result = !false;

        Console.WriteLine(result);
    }
}
```
```powershell
dotnet run
True
```

Utile pour un jeu vidéo.

```cs
using System;

/*
    Arithmétique    :   +, -, *, /, %   (binaire)
                        +, -, ++, --    (unaire)
    
    Affectation     :   =, +=, -=, *=, /=, %=

    Booléen - (In)égalité   :   ==, !, <, >, <=, >=
*/

class Program
{
    static void Main(string[] args)
    {
        bool isLaunched = true;

        bool test = !isLaunched;
    }
}
```
```powershell
dotnet run
True
```

Voilà `!` est un opérateur unaire parce qu'on test une seule valeur, on ne compare pas deux valeurs.

## Opérateurs binaires conditionnels

```cs
using System;

/*
    Arithmétique    :   +, -, *, /, %   (binaire)
                        +, -, ++, --    (unaire)
    
    Affectation     :   =, +=, -=, *=, /=, %=

    Booléen - (In)égalité           :   ==, !, <, >, <=, >=
    Booléen - binaire conditionnel  :   &&, ||
*/

class Program
{
    static void Main(string[] args)
    {
        bool test = (true && true);

        Console.WriteLine(test);
    }
}
```
```powershell
dotnet run
True
```

true && true    => True
true || true    => True
true || false   => True
true && false   => False

Voilà.

## Autres opérateurs

On a également des opérateurs binaires logiques (ET, OU, OU exclusif), des opérateurs pour faire des décallages de bits, notamment récupérer le complément.

```cs
/*
    Arithmétique    :   +, -, *, /, %   (binaire)
                        +, -, ++, --    (unaire)
    
    Affectation     :   =, +=, -=, *=, /=, %=

    Booléen - (In)égalité           :   ==, !, <, >, <=, >=
    Booléen - binaire conditionnel  :   &&, ||

    &, |, ^, <<, >>
*/
```

& : ET
| : OU
^ : OU exclusif
<<: opérateur de décallage de bits (gauche)
>>: opérateur de décallage de bits (droite)
~ : opérateur de complément

## Opérateur ternaire

On verra dans les prochaînes séances.

## Chaîne de caractères

### Réaffecter une nouvelle valeur à une chaîne

CSharp est un langage plus haut niveau que le C, on peut modifier des chaînes de caractères sans allocation dynamique, strcpy(), et cetera.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string name = "Jason";

        name = "Jean-Paul Gauthier";
    }
}
```

### Concaténation

```cs
using System;

/*
    Arithmétique    :   +, -, *, /, %   (binaire)
                        +, -, ++, --    (unaire)
    
    Affectation     :   =, +=, -=, *=, /=, %=

    Booléen - (In)égalité           :   ==, !, <, >, <=, >=
    Booléen - binaire conditionnel  :   &&, ||
*/

class Program
{
    static void Main(string[] args)
    {
        string result = "3" + "4";

        Console.WriteLine(result);
    }
}
```
```powershell
dotnet run       
34
```

Concaténation entre une chaîne et une variable.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string name = "Jason";

        Console.WriteLine("Ton prenom est : " + name);
    }
}
```
```powershell
dotnet run       
Ton prenom est : Jason
```

On crée une chaîne formatée avec un `$".."`, en Python on utilise `f".."` (ce qu'on appelle une fstring en Python).

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string name = "Jason";

        Console.WriteLine($"Ton prenom est : {name}");
    }
}
```
```powershell
dotnet run       
Ton prenom est : Jason
```

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string name = "Jason";
        int age = 28;

        Console.WriteLine($"Ton prenom est : {name} et tu as {age} ans");
    }
}
```
```powershell
dotnet run       
Ton prenom est : JasonTon prenom est : Jason et tu as 28 ans
```