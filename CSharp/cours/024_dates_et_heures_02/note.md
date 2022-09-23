# [24. Dates et heures (2/2)](https://www.youtube.com/watch?v=9E42GFO1bVs)

+ [Introduction](#Introduction)
+ [Quelques propriétés de DateTime](#Quelques-propriétés-de-DateTime)
+ [Définir une date avec un décalage de temps](#Définir-une-date-avec-un-décalage-de-temps)
+ [Propriétés et méthodes de DateTimeOffset](#Propriétés-et-méthodes-de-DateTimeOffset)
+ [Définir un jour de la semaine](#Définir-un-jour-de-la-semaine)
+ [Définir une date seule ou un temps seul](#Définir-une-date-seule-ou-un-temps-seul)
+ [Conversion vers un intervalle de temps](#Conversion-vers-un-intervalle-de-temps)
+ [Définir un fuseau horaire](#Définir-un-fuseau-horaire)
+ [Conversion en date avec fuseau horaire](#Conversion-en-date-avec-fuseau-horaire)
+ [Conversion depuis ou vert UTC](#Conversion-depuis-ou-vert-UTC)
+ [Récupération d'un fuseau horaire depuis le système](#Récupération-d-un-fuseau-horaire-depuis-le-système)
+ [Conclusion](#Conclusion)

>

## Introduction

## Quelques propriétés de DateTime

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
            DateTime dt = new DateTime(2022, 8, 13, 14, 53, 59);

            Console.WriteLine(dt.Month);
        }
    }
}
```
```
> dotnet run
8
```

Mêmes propriétés pour TimeSpan().

Rappel, addition de mois comme des nombres.

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
            DateTime dt = new DateTime(2022, 8, 13, 14, 53, 59);
            DateTime dt2 = new DateTime(2022, 10, 13, 14, 53, 59);

            Console.WriteLine(dt.Month + dt2.Month);
        }
    }
}
```
```
> dotnet run
18
```

## Définir une date avec un décalage de temps

DateTime() est UTC local et DateTimeOffset() est avec un décallage.

```cs
using System.IO;
using System;

// Structures : DateTime, TimeSpan, DateTimeOffset
//

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt= new DateTime(2022, 8, 13, 14, 53, 59);
            DateTimeOffset dto = new DateTimeOffset(dt);

            Console.WriteLine(dto);
        }
    }
}
```
```
> Dotnet run
13-08-22 14:53:59 +02:00
```

On a le décallage qui est pris en compte selon le système que l'on utilise.

On prend bien en compte le bon fuseau si le décallage est important.

Pour rappel,
+ DateTime : Gérer une date, un temps localement UTC
+ TimeSpan : Gérer un intervalle de temps
+ DateTimeOffset : Gérer les fuseau horaire et décallage

Ici, on peut gérer un intervalle de temps pour créer notre date en tenant compte du décallage.

```cs
DateTimeOffset dto = new DateTimeOffset(dt, new TimeSpan());
DateTimeOffset dto = new DateTimeOffset(2022, 8, 13, 14, 53, 59, new TimeSpan());
```

## Propriétés et méthodes de DateTimeOffset

DateTimeOffset() est un DateTime donc ce sont les mêmes propriétés (months ...) et pareil pour les méthodes (AddDays(), AddMonths() ...) auquel on ajouterais par exemple un décallage avec Add().

```cs
using System.IO;
using System;

// Structures : DateTime, TimeSpan, DateTimeOffset
//

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt= new DateTime(2022, 8, 13, 14, 53, 59);
            DateTimeOffset dto = new DateTimeOffset(dt);

            Console.WriteLine(dto.Hour);
            Console.WriteLine(dto.Add(new TimeSpan(2, 0, 0, 0)));
        }
    }
}
```
```
> Dotnet run
14
15-08-22 14:53:59 +02:00
```

**/!\ `dto.Now` ne marcherait pas parce qu'il s'agit d'un objet et un objet ne peut pas appeler une méthode statique.**

## Définir un jour de la semaine

**/!\ le mois n°1 en CSharp est janvier et au format anglais le n°0 est dimanche.**

```cs
using System.IO;
using System;

// Structures : DateTime, TimeSpan, DateTimeOffset
//

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine(DayOfWeek.Monday);
        }
    }
}
```
```
> Dotnet run
Monday
```

Voilà pour l'énumération des jours.

## Définir une date seule ou un temps seul

DateOnly() ou TimeOnly().

```cs
using System.IO;
using System;

// Structures : DateTime, DateTimeOffset, TimeSpan, DateOnly, TimeOnly
// Énumérations : DayOfWeek

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateOnly do = new DateOnly(2022, 6, 24);
            DateOnly to = new TimeOnly(19, 58, 42);
            
            // Console.WriteLine(ToTimeSpan(do));
            // Console.WriteLine(ToTimeSpan(to));
        }
    }
}
```
```
> Dotnet run
Monday
```

Ce sont toujours les mêmes méthodes, on ne travail pas avec 20 classes. On travail avec ce qui est propre au mono-threadé, on travail de manière synchronisé si on est sur un système asynchrone et cetera. En Java, beaucoup de classes, de méthodes et d'interfaces selon le type d'usage.

## Conversion vers un intervalle de temps

Noté qu'on peut faire de la conversion ToTimeSpan() si on veut faire de la conversion. 

## Définir un fuseau horaire

Récupérer l'info avec TimeZoneInfo().

Voir la [doc displayname](https://learn.microsoft.com/fr-fr/dotnet/api/system.timezoneinfo.displayname?view=net-6.0)

```cs
using System.IO;
using System;

// Structures   : DateTime, DateTimeOffset, TimeSpan, DateOnly, TimeOnly
// Classe       : TimeZoneInfo
// Énumérations : DayOfWeek

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            TimeZoneInfo tzi = TimeZoneInfo.Utc;

            Console.WriteLine(tzi.DisplayName);
            Console.WriteLine(tzi.StandardName);
            Console.WriteLine(tzi.Id);

            TimeZoneInfo tzi_heure_local = TimeZoneInfo.Local;

            Console.WriteLine(tzi_heure_local.DisplayName);
        }
    }
}
```
```
> Dotnet run
(UTC) Temps universel coordonné
Temps universel coordonné
UTC
(UTC+01:00) Bruxelles, Copenhague, Madrid, Paris
```

On est en heure local pour plus d'informations.

Le fuseau de Bruxelles montre +01:00 pour l'heure d'été. Le 0 c'est Londre p/r à Greenwich.

Sachez que DateTimeOffset() prend en compte le changement d'heure.

Il faut savoir que des pays n'ont même pas de changement d'heures.

Le Time est géré par d'autres classes au niveau de C# mais on peut l'utiliser.

## Conversion en date avec fuseau horaire

```cs
using System.IO;
using System;

// Structures   : DateTime, DateTimeOffset, TimeSpan, DateOnly, TimeOnly
// Classe       : TimeZoneInfo
// Énumérations : DayOfWeek

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt = new DateTime(2022, 8, 13, 14, 53, 59);
            TimeZoneInfo tzi = TimeZoneInfo.Local;

            DateTime finalDate = TimeZoneInfo.ConvertTime(dt, tzi);
            Console.WriteLine(finalDate);
        }
    }
}
```
```
> Dotnet run
13-08-22 14:53:59
```

Par exemple, on crée une date UTC (sans décallage) et ensuite appliquer un fuseau horaire pour adapter la date si besoin avec ConvertTime().

## Conversion depuis ou vert UTC

ConvertTimeFromUTC(), ConvertTimeToUTC().

Ils prennent DateTime ou TimeSpan soit les mêmes arguments.

```cs
using System.IO;
using System;

// Structures   : DateTime, DateTimeOffset, TimeSpan, DateOnly, TimeOnly
// Classe       : TimeZoneInfo
// Énumérations : DayOfWeek

// ConvertTimeFromUTC, ConvertTimeToUTC

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt = new DateTime(2022, 8, 13, 14, 53, 59);
            TimeZoneInfo tzi = TimeZoneInfo.Local;

            DateTime finalDate = TimeZoneInfo.ConvertTime(dt, tzi);
            Console.WriteLine(finalDate);
        }
    }
}
```
```
> Dotnet run
13-08-22 14:53:59
```

Il y a beaucoup de conversion pour le passage de mode en fonction du pays.

## Récupération d un fuseau horaire depuis le système

```cs
public static TimeZoneInfo FindSystemTimeZoneById (string id);
```

+ [doc FindSystemTimeZoneById](https://learn.microsoft.com/fr-fr/dotnet/api/system.timezoneinfo.findsystemtimezonebyid?view=net-6.0)

## Conclusion

Voilà pour l'essentiel.

Bien attention à la gestion des erreurs.

Exemple d'utilisation où on fais saisir une date à l'utilisateur, on tiens en compte son fuseau horaire puis on enregistre cela dans un fichier.

A bientôt