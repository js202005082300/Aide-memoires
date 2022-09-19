# [23. Dates et heures (1/2)](https://www.youtube.com/watch?v=i8dqXQpXs5w)

+ [Introduction](#Introduction)
+ [Quels outils pour manipuler des dates et temps ?](#Quels-outils-pour-manipuler-des-dates-et-temps)
+ [Définir une date/heure spécifique (locale ou UTC)](#Définir-une-date-heure-spécifique)
+ [Quelques méthodes de DateTime](#Quelques-méthodes-de-DateTime)
+ [Calcul avec des dates et intervalle de temps](#Calcul-avec-des-dates-et-intervalle-de-temps)
+ [Rappel sur les méthodes Equals et CompareTo](#Rappel-sur-les-méthodes-Equals-et-CompareTo)
+ [Nombre de jours d'un mois spécifique](#Nombre-de-jours-d-un-mois-spécifique)
+ [Conversion d'une chaîne en date](#Conversion-d-une-chaîne-en-date)
+ [Conclusion](#Conclusion)

>

## Introduction

## Quels outils pour manipuler des dates et temps

La date du jour.
```cs
using System.IO;
using System;

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt = DateTime.Now;

            Console.WriteLine(dt);
        }
    }
}
```
```
> dotnet run
16-09-22 23:11:07
```

Voilà pour l'initialisation du datetime.

## Définir une date-heure spécifique

```cs
using System.IO;
using System;

// aaaa-mm-jj hh:mm:ss

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt = new DateTime(2022, 08, 25, 14, 23, 56);

            Console.WriteLine(dt);
        }
    }
}
```
```
> dotnet run
25-08-22 14:23:56
```

Voilà notredate au format français.

## Quelques méthodes de DateTime

Ajout de 3 jours.

```cs
using System.IO;
using System;

// aaaa-mm-jj hh:mm:ss
// AddDays, AddYears

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt = new DateTime(2022, 08, 25, 14, 23, 56);

            Console.WriteLine(dt.AddDays(3));
            Console.WriteLine(dt.AddMonths(3));
        }
    }
}
```
```
> dotnet run
28-08-22 14:23:56
25-11-22 14:23:56
```

AddDays() prendrait un dubble et AddMonths() prendrait un entier.

Rien ne garentit que la date est correct si par exemple on essaye de mettre un 19e mois.

```cs
using System.IO;
using System;

// aaaa-mm-jj hh:mm:ss

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt = new DateTime(2022, 19, 25, 14, 23, 56);

            Console.WriteLine(dt);
        }
    }
}
```
```
> dotnet run
Unhandled exception. System.ArgumentOutOfRangeException: Year, Month, and Day parameters describe an un-representable DateTime.
   at System.DateTime..ctor(Int32 year, Int32 month, Int32 day, Int32 hour, Int32 minute, Int32 second)
   at App.Program.Main(String[] args) in C:\.\FirstApp\Program.cs:line 12
> 
```

Il faut toujours gérer nos érreurs.

## Calcul avec des dates et intervalle de temps

Manipuler les dates comme des nombres.

```cs
using System.IO;
using System;

// aaaa-mm-jj hh:mm:ss

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt1 = new DateTime(2022, 8, 25);
            DateTime dt2 = new DateTime(2022, 11, 25);
            DateTime dt3 = new DateTime(2022, 11, 25);

            Console.WriteLine(dt1 == dt2);
            Console.WriteLine(dt2 == dt3);
            Console.WriteLine(dt1 < dt3);
        }
    }
}
```
```
> dotnet run
False
True
True
```

Ajouter une durée de temps.

```cs
using System.IO;
using System;

// aaaa-mm-jj hh:mm:ss

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt = new DateTime(2022, 8, 25);
            TimeSpan ts = new TimeSpan(2, 13, 25, 56);

            Console.WriteLine(dt);
            Console.WriteLine(dt + ts);
        }
    }
}
```
```
> dotnet run
25-08-22 00:00:00
27-08-22 13:25:56
```

Mettre des zéros si on ne veut pas les spécifier.

```cs
using System.IO;
using System;

// Structures : DateTime, TimeSpan

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt = new DateTime(2022, 8, 25);
            TimeSpan ts = new TimeSpan(2, 0, 0, 0);

            Console.WriteLine(dt);
            Console.WriteLine(dt + ts);
        }
    }
}
```
```
> dotnet run
25-08-22 00:00:00
27-08-22 00:00:00
```

Graçe aux opérateurs, on fais des calcul arithmétique sur des dates d'où l'intérêt de travailler avec des méthodes car on tiendra compte si c'est une heure local, UTC, le type de calendrier utilisé et cetera.

Le `+` ne prend pas en compte les décallages, les fuseaux horaires. Les dates sont prises comme des nombres sinon il faut travailler avec des méthodes.

## Rappel sur les méthodes Equals et CompareTo

La méthode Add() qui prend un TimeSpan()

```cs
using System.IO;
using System;

// Structures : DateTime, TimeSpan
//

// Equals, CompareTo

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt = new DateTime(2022, 8, 25);
            TimeSpan ts = new TimeSpan(2, 0, 0, 0);

            Console.WriteLine(dt.Add(ts));
        }
    }
}
```
```
> dotnet run
27-08-22 00:00:00
```

La méthode Add() prendra en compte les fuseaux horaires, le type de calendrier, le type d'heure et cetera à la différence de l'opérateur `+`.

Equals() ou `==` pour comparer des valeurs et CompareTo() pour trier (si l'une est plus grande que l'autre).
 
## Nombre de jours d un mois spécifique

La méthode statique DaysInMonth().

```cs
using System.IO;
using System;

// Structures : DateTime, TimeSpan
//

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt = new DateTime(2022, 8, 25);
            TimeSpan ts = new TimeSpan(2, 0, 0, 0);

            Console.WriteLine(DateTime.DaysInMonth(2022, 5));
        }
    }
}
```
```
> dotnet run
31
```

## Conversion d une chaîne en date

La méthode statique TryParse() avec un argument à passer en out.

```cs
using System.IO;
using System;

// Structures : DateTime, TimeSpan
//

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            string s = "2015-09-18";
            DateTime dt;

            if(DateTime.TryParse(s, out dt))
                Console.WriteLine(dt);
        }
    }
}
```
```
> dotnet run
18-09-15 00:00:00
```

Voilà la nouvelle date est appliquée.

## Conclusion

Toujours voir la doc.

Prochainnement les fuseaux, les tructures (juste les dates, juste les heures) et cetera.

A bientôt sur la seconde partie de cette vidéo sur le cours CSharp