# [16. Ensembles](https://www.youtube.com/watch?v=0OO_JbiKQHA)

+ [Introduction](#Introduction)
+ [Qu'est-ce qu'un ensemble ?](#Qu-est-ce-qu-un-ensemble)
+ [Déclarer un ensemble](#Déclarer-un-ensemble)
+ [Parcourir un ensemble](#Parcourir-un-ensemble)
+ [Nombre d'éléments de l'ensemble](#Nombre-d-éléments-de-l-ensemble)
+ [Ajouter ou supprimer des éléments](#Ajouter-ou-supprimer-des-éléments)
+ [Rechercher un élément](#Rechercher-un-élément)
+ [Récupérer les éléments via un itérateur](#Récupérer-les-éléments-via-un-itérateur)
+ [Récupérer les éléments sous forme de tableau](#Récupérer-les-éléments-sous-forme-de-tableau)
+ [Exécuter une fonction sur chaque élément](#Exécuter-une-fonction-sur-chaque-élément)
+ [Conclusion](#Conclusion)

>

## Introduction

## Qu est-ce qu un ensemble

L'ensemble est un type particulier qui permet de regrouper des éléments qui ont des **valeurs uniques**.

Par contre les éléments pourront être de plusieurs **types différents** (des nombres, des dates ...).

Un ensemble est **itérable**, on va pouvoir le parcourir.

## Déclarer un ensemble

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
    <h1>JavaScript #16 - ensembles</h1>
    <script src="main.js"></script>
</body>
</html>
```
On crée un ensemble vite.

```js
let someSet = new Set();
```

On peut ajouter tout éléments itérables pour créer une liste d'ensembles.

```js
let someSet = new Set([1, 2, 3]);
```

```js
let someSet = new Set({one:1, two:2, three:3});
```

## Parcourir un ensemble

Et pour le parcourir :
```js
let someSet = new Set([1, 2, 3]);

for(element of someSet)
    document.write("<p>" + element + "</p>");
```
```
JavaScript #16 - ensembles
1

2

3
```

Avec des types différents :
```js
let someSet = new Set([1, "bonjour", new Date()]);

for(element of someSet)
    document.write("<p>" + element + "</p>");
```
```
JavaScript #16 - ensembles
1

bonjour

Sun Sep 04 2022 19:40:30 GMT+0200 (heure d’été d’Europe centrale)
```

On ne peut avoir que des éléments uniques sinon ce sera compté comme une erreur.
```js
let someSet = new Set([1, "bonjour", 1]);

for(element of someSet)
    document.write("<p>" + element + "</p>");
```
```
JavaScript #16 - ensembles
1

bonjour
```

## Nombre d éléments de l ensemble

```js
let someSet = new Set([1, "bonjour", 1]);

document.write(someSet.size);
```
```
JavaScript #16 - ensembles
2
```

Ici le 3e élément n'as pas été ajouté car ce sont des valeurs uniques.

```js
let someSet = new Set([1, 2, 3]);

document.write(someSet.size);
```
```
JavaScript #16 - ensembles
3
```

## Ajouter ou supprimer des éléments

```js
let someSet = new Set([1, 2, 3]);

someSet.add(4);

for(element of someSet)
    document.write("<p>" + element + "</p>");
```
```
JavaScript #16 - ensembles
1

2

3

4
```

Supprimer delete(), méthode qui renvoie un booléen.

```js
let someSet = new Set([1, 2, 3]);

someSet.add(4);
someSet.delete(1);

for(element of someSet)
    document.write("<p>" + element + "</p>");
```
```
JavaScript #16 - ensembles
2

3

4
```

Récupérer un ensemble vide avec clear().

```js
let someSet = new Set([1, 2, 3]);

someSet.clear();

for(element of someSet)
    document.write("<p>" + element + "</p>");
```
```
JavaScript #16 - ensembles
```

## Rechercher un élément

Rechercher si un élément existe avec la méthode has().

```js
let someSet = new Set([1, 2, 3]);

if(someSet.has(2))
    document.write("On est content !");
```
```
JavaScript #16 - ensembles
On est content !
```

Si on retire l'élément 2, on n'est pas content !

## Récupérer les éléments via un itérateur

Avec les méthodes values() ou keys().

```js
let someSet = new Set([1, 2, 3]);

const iterValues = someSet.values(); // keys()

document.write(iterValues.next().value);
document.write(iterValues.next().value);
```
```
JavaScript #16 - ensembles
12
```

Appeler l'élément prochain à l'aide de l'itérateur et la méthode next() avec la propriété value pour la valeur. Un curseur qui avance .. 1 .. 2

## Récupérer les éléments sous forme de tableau

entries() renvoie un itérateur sous forme de tableau qui contient deux fois la valeur (aux indices 0 et 1).

```js
let someSet = new Set([1, 2, 3]);

const allEntries = someSet.entries();

for(const element of allEntries)
    document.write("<p>" + element + "</p>");
```
```
JavaScript #16 - ensembles
1,1

2,2

3,3
```

On faisait sinon directement sur l'ensemble.

```js
let someSet = new Set(["bonjour", "hello", "hi"]);

for(const element of someSet)
    document.write("<p>" + element + "</p>");
```
```
JavaScript #16 - ensembles
bonjour

hello

hi
```

## Exécuter une fonction sur chaque élément

Avec la méthode forreach(), ici appliquer un traitement (fonction) sur l'ensemble des éléments.

```js
let someSet = new Set(["bonjour", "hello", "hi"]);

function show(value)
{
    document.write("<p>" + value + "</p>");
}

someSet.forEach(show);
```
```
JavaScript #16 - ensembles
bonjour

hello

hi
```

Intérêt pour les vérifications à travers une fonction.

## Conclusion

Propriétés et méthodes vues.

```js
/*
    .size

    add(), delete(), clear()
    values()/keys, entries()
    has()
    forEach()
*/
```
```
```

Ciao tout le monde