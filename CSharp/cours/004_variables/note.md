# [4. Variables](https://www.youtube.com/watch?v=Ssu2rZUZY64)

Le code minimal.

+ Program.cs
```cs
using System;

class Program
{
    static void Main(string[] args)
    {

    }
}
```

Les types en C#.

![types.PNG](types.PNG)

Tous les types en C# que ce soit par référence (ex: string) ou par valeur héritent d'une classe Object qui est une classe au plus haut de la hiéarchie, et tous les objets vont hériter de cette dernière.

## Déclarer une variable

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        int number;
        int numBer;
        int NUMBER;
        int numberOfUsers; // camelCase
        int NumberOfUsers; // PascalCase
        int number_of_users; // snake_case
    }
}
```

On manipule des étiquette, des labels derrières les-quelles se cachent des adresses mémoires.

## Déclaration et initialisation

Affecter une valeur par défaut pour éviter qu'il y ait n'importe quoi.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        int numberOfUsers = 0;

    }
}
```

## Afficher une variable

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        int NumberOfUsers = 0;

        Console.WriteLine(NumberOfUsers);
    }
}
```
```powershell
dotnet new console -o FirstApp
cd .\FirstApp\
dotnet build
dotnet run        
0
```

Même résultat mais sans mémoriser d'information.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        //int NumberOfUsers = 0;

        Console.WriteLine(0);
    }
}
```
```powershell
dotnet run        
0
```

C'est une erreur de travailler avec des valeurs volatiles, écrite en dur, puis de faire des copies et on répète des informations ainsi la répétition de code ce n'est jamais très bon.

## Affectation

### Affecter une nouvelle valeur

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        int NumberOfUsers = 0;
        Console.WriteLine(NumberOfUsers);

        NumberOfUsers = 14;
        Console.WriteLine(NumberOfUsers);
    }
}
```
```powershell
dotnet run        
0
14
```

Affecter selon le type de l'information, on peut avoir des nombres, des chaînes de caractères et pourquoi des personnages, des fenêtres dans un programme graphique, un pinceau pour faire la peinture numérique, et cetera.

Idem avec un string.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string Username = "Jason";

        Console.WriteLine(Username);
    }
}
```
```powershell
dotnet run        
Jason
```

Réaffecter une chaîne de caractères.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string Username = "Jason";
        Console.WriteLine(Username);

        Username = "Robert";
        Console.WriteLine(Username);
    }
}
```
```powershell
dotnet run        
Jason
Robert
```

Pareil ce sont des valeurs en durs.

### Affecter une variable à une autre

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string UserName = "Jason";
        string OtherName = "Robert";

        Console.WriteLine(UserName);

        UserName = OtherName;
        Console.WriteLine(UserName);
    }
}
```
```powershell
dotnet run        
Jason
Robert
```

On obtient un code qui n'est plus en dur mais un code dynamique.

Plus tard, on aura une valeur saisie par l'utilisateur au lieu d'une valeur en dure.

On pourra récupérer l'information dans un fichier ou même sur une page web.

On peut affecter une valeur en dur, le contenu d'une variable, le retour d'une expression `14 + 6` par exemple.

### Affecter le retour d une expression

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        int number = 14 + 6;

        Console.WriteLine(number);
    }
}
```
```powershell
dotnet run        
20
```

Il faut lire de droite à gauche, on fait le calcul `14 + 6` affecté (=) à la variable number de type int.

On peut affecter tout et n'importe quoi tant que ça respecte le type.

On ne pourra pas faire ceci `int number = 14 + "Jason";`, faire des conversion implicite, le compilateur refusera de compiler.

## Conversion numérique

Cast en anglais.

C'est à éviter à cause de situation inattendue. 

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        float number = 3.14f;
        int nb = 0;

        Console.WriteLine(number);

        nb = (int)number;
        Console.WriteLine(nb);
    }
}
```
```powershell
dotnet run        
3,14
3
```

Plutard on abordera les exceptions pour vérifier si c'est ok.

Si on essaye de caster une chaîne en int, ça n'ira pas.

## Afficher un grand nombre

On peut séparer les triplets de nombres par des underscores pour plus de lisibilité.

```cs
using System;

/*
    455
    455_123
*/

class Program
{
    static void Main(string[] args)
    {
        int number = 2_455_123;
    }
}
```
```powershell
```

## Affecter une valeur de base différent de 10

### Préfixes

Pour une valeur binaire on utilise le préfixe `0b` et des underscores pour plus de lisibilité. Pour les valeurs héxadécimales `0x`.

```cs
using System;

/*
    455
    455_123

    0b_1101_1111_0011
    0x_C6
*/

class Program
{
    static void Main(string[] args)
    {
        int number = 2_455_123;
    }
}
```

### Sufixes

Quelques sufixes pour représenter les types par exemple pour les grands nombres.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        /*
            long number = 145_697l;
            long number = 145_697L;
        */
    }
}
```

Les suffixes sont disponible en minuscule et majuscule pour des raisons des libilités.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        /*
            long    -> L ou l
            float   -> f ou F
            double  -> d ou D
            decimal -> m ou M

            decimal bigNumber = 145_125_646_979_999m;
        */
    }
}
```

On peut du coup manipuler de grand nombre `decimal bigNumber = 145_125_646_979_999m;`.

## Notations mathématiques

### Puissance

Pour représenter *10^6*, on écrit *10e6* ou *10E6*.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        /*
            10^6
            10e6
            10E6
        */

        double number = 10E6;

        Console.WriteLine(number);
    }
}
```
```powershell
dotnet run        
10000000
```

Attention à ne pas confondre avec l'exponentiel.

Nous parlerons des constantes puis des attributs plutard et cetera.