# [15. Dates](https://www.youtube.com/watch?v=hibxWv9vrvc)

+ [Introduction](#Introduction)
+ [Epoch Time (heure Unix/Posix)](#Epoch-Time)
+ [Déclarer une nouvelle date](#Déclarer-une-nouvelle-date)
+ [Déclarer une date spécifique](#Déclarer-une-date-spécifique)
+ [Accesseurs pour les dates (méthodes "get")](#Accesseurs-pour-les-dates)
+ [Modificateurs pour les dates (méthodes "set")](#Modificateurs-pour-les-dates)
+ [Conclusion](#Conclusion)

## Introduction

Utilisation des dates et des temps, en javascript l'objet Date.

```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Cours JavaScript</title>
    <style>
        body{background-color:#111;color:#e2a93f;margin:auto;width:800px;}
        h1{color:#af8943;text-align:center;}
    </style>
</head>
<body>
    <h1>#15 - Dates et heures</h1>
    <script src="main.js"></script>
</body>
</html>
```

## Epoch Time

Le temps zéro est le 1e janvier 1970 à minuit UTC, le temps Unix.

Le timestamp est le nombre de milisecondes écoulées depuis cette date, le Epoch Time.

Ce temps permet de comparer deux date comme un référentiel.

## Déclarer une nouvelle date

+ Retourner une chaîne
```js
let d = Date(); // chaîne
document.write(d);
```
```
Wed Aug 17 2022 20:59:46 GMT+0200 (heure d’été d’Europe centrale)
```
On veut travailler avec l'objet.

+ Retourner un objet
```js
let d = new Date(); // objet
document.write(d);
```
```
Wed Aug 17 2022 21:01:22 GMT+0200 (heure d’été d’Europe centrale)
```

## Déclarer une date spécifique

```js
let d = new Date("January 16, 2002 20:45:12");
document.write(d);
```
```
Wed Jan 16 2002 20:45:12 GMT+0100 (heure normale d’Europe centrale)
```

+ Préciser juste la date
```js
let d = new Date(2020, 05, 23);
document.write(d);
```
```
Sat May 23 2020 00:00:00 GMT+0200 (heure d’été d’Europe centrale)
```

+ Préciser la date et l'heure
```js
let d = new Date(2020, 05, 23, 13, 23, 56);
document.write(d);
```
```
Tue Jun 23 2020 13:23:56 GMT+0200 (heure d’été d’Europe centrale)
```

+ Obtenir le nombre milisecondes écoulées depuis le temps Unix 1/1/1970 à minuit UTC.
```js
let d = Date.now();
document.write(d);
```
```
1660763491817
```

## Accesseurs pour les dates

+ Récupérer la date
```js
let d = new Date(2012, 05, 23, 16, 45, 17);
document.write("<p>" + d + "</p>");
document.write(d.getDate());
```
```
Sat Jun 23 2012 16:45:17 GMT+0200 (heure d’été d’Europe centrale)

23
```

+ Récupérer le numéro du jour
```js
let d = new Date(2012, 05, 23, 16, 45, 17);
document.write("<p>" + d + "</p>");
document.write(d.getDay());
```
```
Sat Jun 23 2012 16:45:17 GMT+0200 (heure d’été d’Europe centrale)

6
```

Saterday est le 6e jour avec dimanche le 0e jour en informatique et dans le système anglophone.

+ Récupérer le numéro du mois
```js
let d = new Date(2012, 05, 23, 16, 45, 17);
document.write("<p>" + d + "</p>");
document.write(d.getMonth());
```
```
Sat Jun 23 2012 16:45:17 GMT+0200 (heure d’été d’Europe centrale)

5
```

June est le 5e mois de l'année au lieu de 6 en informatique, attention.

January est le mois n°0.

+ Récupérer l'année complète
```js
let d = new Date(2012, 05, 23, 16, 45, 17);
document.write("<p>" + d + "</p>");
document.write(d.getFullYear());
```
```
Sat Jun 23 2012 16:45:17 GMT+0200 (heure d’été d’Europe centrale)

2012
```

+ Récupérer l'heure
```js
let d = new Date(2012, 05, 23, 16, 45, 17);
document.write("<p>" + d + "</p>");
document.write(d.getHours() + "<br>");
document.write(d.getMinutes() + "<br>");
document.write(d.getSeconds() + "<br>");
```
```
Sat Jun 23 2012 16:45:17 GMT+0200 (heure d’été d’Europe centrale)

16
45
17
```

+ Pour le format UTC, on rajoute UTC entre les deux
```js
let d = new Date(2012, 05, 23, 16, 45, 17);
document.write("<p>" + d + "</p>");
document.write(d.getUTCDate() + "<br>");
document.write(d.getUTCHours() + "<br>");
```
```
Sat Jun 23 2012 16:45:17 GMT+0200 (heure d’été d’Europe centrale)

23
14
```
Ici 14 heures au lieu de 16 car on est en GMT+0200 pour le fuseau horraire de Paris, et le +2 car on est en heure d'été.

## Modificateurs pour les dates

```js
let d = new Date(2012, 05, 23, 16, 45, 17);

document.write("<p>" + d.getFullYear() + "</p>");

d.setFullYear(2006);

document.write("<p>" + d.getFullYear() + "</p>");
```
```
2012

2006
```

+ idem pour le mois UTC
```js
let d = new Date(2012, 04, 23, 16, 45, 17);

document.write("<p>" + d.getMonth() + "</p>");

d.setUTCMonth(5);

document.write("<p>" + d.getMonth() + "</p>");
```
```
4

5
```
En UTC, on ne prend pas en compte le fuseau horaire.

En informatique, on besoin de travailler en UTC.

## Conclusion

Avec number qu'on a vu, on peut convertir une date en nombre.

On a vu les chaînes de caractères.

Ciao