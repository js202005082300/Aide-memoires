# [30. Dates et durées](https://www.youtube.com/watch?v=SifudCti3pQ)

+ [Introduction](#Introduction)
+ [Point de référence](#Point-de-référence)
+ [Date locale](#Date-locale)
+ [Heure locale](#Heure-locale)
+ [Date et heure locales](#Date-et-heure-locales)
+ [Durée](#Durée)
+ [Période](#Période)
+ [Fuseau horaire](#Fuseau-horaire)
+ [Jours de la semaine et mois](#Jours-de-la-semaine-et-mois)
+ [Formatage de dates](#Formatage-de-dates)
+ [Conclusion](#Conclusion)

>

## Introduction
## Point de référence

Le point epoque qui fais référence au 01/01/1970, nombre de millisecondes écoulées.

## Date locale

```java
import java.time.LocalDate;
/*
    LocalDate
    LocalTime
    LocalDateTime
*/
public class Main
{
    public static void main(String args[])
    {
        LocalDate aDate = LocalDate.EPOCH;
        System.out.println(aDate);

        LocalDate nowDate = LocalDate.now();
        System.out.println(nowDate);

        LocalDate someDate = LocalDate.of(1984, 03, 14);
        System.out.println(someDate);
        System.out.println(someDate.getMonth());
        System.out.println(someDate.getMonthValue());
        System.out.println(someDate.getDayOfWeek());
        System.out.println(someDate.getDayOfMonth());

        someDate = someDate.plusMonths(11);
        someDate = someDate.plusDays(11);
        someDate = someDate.plusYears(11);
        System.out.println(someDate);

        someDate = someDate.minusYears(11);
        System.out.println(someDate);
    }
}
```
```ps1
> javac .\Main.java
> java Main        
1970-01-01
2023-01-14
1984-03-14
MARCH     
3
WEDNESDAY 
14        
1996-02-25
1985-02-25
```

## Heure locale

```java
import java.time.LocalDate;
import java.time.LocalTime;
/*
    LocalDate
    LocalTime
    LocalDateTime
*/
public class Main
{
    public static void main(String args[])
    {
        LocalTime aTime = LocalTime.now();
        System.out.println(aTime);

        LocalTime someTime = LocalTime.of(16, 45, 59);
        System.out.println(someTime.getHour());
        System.out.println(someTime.plusHours(8));
    }
}
```
```ps1
> javac .\Main.java
> java Main
13:55:20.575704700
16      
00:45:59
```

## Date et heure locales

```java
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
/*
    LocalDate
    LocalTime
    LocalDateTime
*/
public class Main
{
    public static void main(String args[])
    {
        LocalDate someDate = LocalDate.of(1984, 03, 14);
        LocalTime someTime = LocalTime.of(16, 45, 59);

        LocalDateTime ldt = LocalDateTime.of(someDate, someTime);
        System.out.println(ldt);

        LocalDateTime ldt_2 = LocalDateTime.of(1991, 05, 13, 8, 45, 13);
        System.out.println(ldt_2);
    }
}
```
```ps1
> javac .\Main.java
> java Main
1984-03-14T16:45:59
1991-05-13T08:45:13
```

## Durée

Ajouter du temps.

```java
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
/*
    LocalDate
    LocalTime
    LocalDateTime

    Duration
    Period
*/
public class Main
{
    public static void main(String args[])
    {
        Duration du = Duration.ofHours(3).plusMinutes(30);
        LocalTime someTime = LocalTime.of(16, 45, 59);

        System.out.println(someTime.plus(du));
    }
}
```
```ps1
> javac .\Main.java
> java Main
20:15:59
```

## Période

```java
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.Period;
/*
    LocalDate
    LocalTime
    LocalDateTime

    Duration
    Period
*/
public class Main
{
    public static void main(String args[])
    {
        Period pe = Period.of(3, 4, 6); // 3 ans, 4 mois, 6 jours
        LocalDate someDate = LocalDate.of(2001, 11, 16);

        System.out.println(someDate.plus(pe));
    }
}
```
```ps1
> javac .\Main.java
> java Main
2005-03-22
```

## Fuseau horaire

Définir un identifiant de zone et une date.

```java
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
/*
    LocalDate
    LocalTime
    LocalDateTime

    Duration
    Period

    ZoneId
    ZoneDateTime
*/
public class Main
{
    public static void main(String args[])
    {
        LocalDate someDate = LocalDate.of(2001, 11, 16);
        LocalTime someTime = LocalTime.of(14, 29, 59);
        
        ZoneId gmtPlusTwo = ZoneId.of("GMT+2");
        ZonedDateTime zdt = ZonedDateTime.of(someDate, someTime, gmtPlusTwo);
        System.out.println(gmtPlusTwo);
        System.out.println(zdt);
    }
}
```
```ps1
> javac .\Main.java
> java Main        
GMT+02:00
2001-11-16T14:29:59+02:00[GMT+02:00]
```

## Jours de la semaine et mois

```java
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import java.time.Month;
import java.time.DayOfWeek;
/*
    LocalDate
    LocalTime
    LocalDateTime

    Duration
    Period

    ZoneId
    ZoneDateTime

    Month
    DayOfWeek
    Calendar
*/
public class Main
{
    public static void main(String args[])
    {
        System.out.println(Month.JANUARY); //enum
        System.out.println(DayOfWeek.WEDNESDAY); //enum
    }
}
```
```ps1
> javac .\Main.java
> java Main        
JANUARY
WEDNESDAY
```

## Formatage de dates

```java
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import java.time.Month;
import java.time.DayOfWeek;

import java.time.format.DateTimeFormatter;
/*
    LocalDate
    LocalTime
    LocalDateTime

    Duration
    Period

    ZoneId
    ZoneDateTime

    Month
    DayOfWeek
    Calendar

    DateTimeFormatter
*/
public class Main
{
    public static void main(String args[])
    {
        LocalDate someDate = LocalDate.of(2008, 11, 16);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String texDate = someDate.format(fmt);
        System.out.println(texDate);

        LocalDateTime someDateTime = LocalDateTime.of(2008, 11, 16, 11, 45, 59);
        DateTimeFormatter fmt_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy à HH:mm:ss");
        String texDate_2 = someDateTime.format(fmt_2);
        System.out.println(texDate_2);
    }
}
```
```ps1
> javac .\Main.java
> java Main
16/11/2008
16/11/2008 Ã  11:45:59
```

## Conclusion

On a vu : Méthodes, constantes, formatage.

```java
/*
    LocalDate
    LocalTime
    LocalDateTime

    Duration
    Period

    ZoneId
    ZoneDateTime

    Month
    DayOfWeek
    Calendar

    DateTimeFormatter
*/
```

À bientôt