# [14. Tableaux](https://www.youtube.com/watch?v=8JosoQnWbag)

+ [Introduction](#Introduction)
+ [Qu'est-ce qu'un tableau ?](#Qu-est-ce-qu-un-tableau-?)
+ [Déclaration d'un tableau](#Déclaration-d-un-tableau)
Array(), of(), from()
+ [Affichage du tableau](#Affichage-du-tableau)
log()
+ [Vérifier si c'est un tableau](#Vérifier-si-c-est-un-tableau)
isArray()
+ [Accès ou modification d'un élément](#Accès-ou-modification-d-un-élément)
at()
+ [Parcours d'un tableau](#Parcours-d-un-tableau)
for(), forEach()
+ [Scinder une chaîne ou joindre depuis un tableau](#Scinder-une-chaîne-ou-joindre-depuis-un-tableau)
split(), join()
+ [Ajout ou suppression d'éléments](#Ajout-ou-suppression-d-éléments)
push(), unshift(), pop(), shift()
+ [Remplissage avec des valeurs](#Remplissage-avec-des-valeurs)
fill()
+ [Recherche de valeurs ou d'indices](#Recherche-de-valeurs-ou-d-indices)
indexOf(), lastIndexOf(), includes(), find(), findIndex()
+ [Fusion de tableaux (concaténation)](#Fusion-de-tableaux)
concat()
+ [Tri ou inversion des éléments](#Tri-ou-inversion-des-éléments)
sort(), reverse(), localeCompare()
+ [Copie superficielle d'un tableau (extraction)](#Copie-superficielle-d-un-tableau)
slice()
+ [Modifier le contenu du tableau](#Modifier-le-contenu-du-tableau)
splice()
+ [Création d'un tableau selon une condition](#Création-d-un-tableau-selon-une-condition)
filter()
+ [Création d'un tableau avec les résultats d'une fonction](#Création-d-un-tableau-avec-les-résultats-d-une-fonction)
map()
+ [Conclusion](#Conclusion)

>

## Introduction

+ index.html
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
    <h1>Tableaux (Array)</h1>
    <script src="main.js"></script>
</body>
</html>
```
+ main.js
```js
Array
```

On part de la classe, l'objet global `Array` en javascript puis beaucoup de méthodes pour les manipuler.

## Qu est-ce qu un tableau ?

Un tableaux est une manière d'organiser un ensemble de données qui vont être stocké en mémoire de manière continue.

```js
let a = 1;
let b = 2;
```

Ces données sont organisées par le système d'exploitation, mémorisées à des adresses mémoires, des adresses aléatoires (ex : 100, 227).

## Déclaration d un tableau

Déclarer un tableau vide.

```js
let someArray = [];
let someArray = [1, "OK", true];
let someArray = ["a", "e", "i", "o", "u", "y"];
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];
```

Un tableau accepte tous les types.

On peut faire appel directement appel au constructeur de la classe Array.

```js
let anotherArray = new Array("Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck");
```

Pour déclarer un tableau à plus d'une dimension.

```js
let array2D = [
    [1, 2, 3],
    [4, 5, 6]
];
```

La méthode of() est la plus éfficace.

```js
let someArray = Array.of(1, 2, 3);
```

Créer un tableau à partir d'une données que l'on peut déduire avec la méthode from().

```js
let data = {0: "Julien", 1: "Laura"};

let newArray = Array.from(data);
```

## Affichage du tableau

```js
let someArray = Array.of(1, 2, 3);

console.log(someArray);
```
```
[
    1,
    2,
    3
]
```

Noté que la Console indique l'indice du premier élément à 0.

## Vérifier si c est un tableau

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

console.log(Array.isArray(someArray));
```
```
true
```

## Accès ou modification d un élément

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

console.log(someArray[0]);
```
```
Laura
```

Avec un indice négatif `-1`, on passera par la fin du tableau.

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

console.log(someArray[someArray.length - 1]);
console.log(someArray[someArray.length]);
```
```
Franck
undefined
```

Utilisation de la méthode at().

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

console.log(someArray.at(5));
```
```
Franck
```

Plusieurs façons de faire les mêmes choses en python, en javascript. On peut faire des benchmark pour voir ce qui est le plus éfficace.

Pour modifier les données :

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

console.log(someArray[0]);

someArray[0] = "Salim";

console.log(someArray[0]);
```
**F12 pour ouvrir DevTools.**
**F5 pour actualiser.**
```
Laura
Salim
```

## Parcours d un tableau

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

for(let i = 0 ; i < someArray.length ; ++i)
    console.log(someArray[i]);
```
**F12 pour ouvrir DevTools.**
**F5 pour actualiser.**
```
Laura
​Bernard
​Salim
​Fatima
​Julien
​Franck
```

Modifier toutes les valeurs.

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

for(let i = 0 ; i < someArray.length ; ++i)
    someArray[i] = "Inconnu";

console.log(someArray);
```
**F12 pour ouvrir DevTools.**
**F5 pour actualiser.**
```
(6) ['Inconnu', 'Inconnu', 'Inconnu', 'Inconnu', 'Inconnu', 'Inconnu']
```

Parcourir toutes les valeurs avec une boucle `for of`.

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

for(value of someArray)
    console.log(value);
```
**F12 pour ouvrir DevTools.**
**F5 pour actualiser.**
```
Laura
Bernard
Salim
Fatima
Julien
Franck
```

Parcourir toutes les indices avec une boucle `for in`.

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

for(index in someArray)
    console.log(index);
```
**F12 pour ouvrir DevTools.**
**F5 pour actualiser.**
```
0
1
2
3
4
5
```

La boucle forEach() :

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

someArray.forEach(value => console.log(value));
```
**F12 pour ouvrir DevTools.**
**F5 pour actualiser.**
```
Laura
Bernard
Salim
Fatima
Julien
Franck
```

Récupérer *value* et *index*.

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

someArray.forEach(function(value, index)
{
    console.log(index + " - " + value);
});
```
**F12 pour ouvrir DevTools.**
**F5 pour actualiser.**
```
0 - Laura
1 - Bernard
2 - Salim
3 - Fatima
4 - Julien
5 - Franck
```

## Scinder une chaîne ou joindre depuis un tableau

On a vu dans la séance précédente qu'on pouvait spliter une chaine de caractères avec split() ou à l'inverse utiliser join(). Le séparateur `:` permet de lier nos élément d'un tableau en javascript.

```js
let s = "Salut à tous !";

let someArray = s.split(' ');
console.log(someArray);

s = someArray.join(":");
console.log(s);
```
```
(4) ['Salut', 'à', 'tous', '!']
Salut:à:tous:!
```

## Ajout ou suppression d éléments

Ajouter à la fin avec push().

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

console.log(someArray);

someArray.push("Maria", "Mathis");

console.log(someArray);
```
```
(6) ['Laura', 'Bernard', 'Salim', 'Fatima', 'Julien', 'Franck']
(8) ['Laura', 'Bernard', 'Salim', 'Fatima', 'Julien', 'Franck', 'Maria', 'Mathis']
```

Ajouter au début avec unshift().

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

console.log(someArray);

someArray.unshift("Marie");

console.log(someArray);
```
```
(6) ['Laura', 'Bernard', 'Salim', 'Fatima', 'Julien', 'Franck']
(7) ['Marie', 'Laura', 'Bernard', 'Salim', 'Fatima', 'Julien', 'Franck']
```

Supprimer à la fin avec pop().

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

console.log(someArray);

let deleteValue = someArray.pop();

console.log(someArray);
```
```
(6) ['Laura', 'Bernard', 'Salim', 'Fatima', 'Julien', 'Franck']
(5) ['Laura', 'Bernard', 'Salim', 'Fatima', 'Julien']
```

Supprimer au début avec shift().

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Julien", "Franck"];

console.log(someArray);

let deleteValue = someArray.shift();

console.log(someArray);
```
```
(6) ['Laura', 'Bernard', 'Salim', 'Fatima', 'Julien', 'Franck']
(5) ['Bernard', 'Salim', 'Fatima', 'Julien', 'Franck']
```

## Remplissage avec des valeurs

Remplir avec la méthode fill(). `fill(2, 0, 5)` c'est remplir avec la valeur 2 de l'indice 0 à 5.

```js
let someArray = [1, 2, 3];

someArray.fill(2, 0, someArray.length);

console.log(someArray);
```
```
(3) [2, 2, 2]
```

## Recherche de valeurs ou d indices

La recherche d'indice s'arrête au premier indice trouvé avec indexof().

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Salim", "Julien", "Franck"];

console.log(someArray.indexOf("Salim"));
```
```
2
```

La recherche d'indice s'arrête au premier indice trouvé depuis la fin du tableau avec lastindexof().

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Salim", "Julien", "Franck"];

console.log(someArray.lastIndexOf("Salim"));
```
```
4
```

Retourner un booléen includes().

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Salim", "Julien", "Franck"];

console.log(someArray.includes("Salim"));
```
```
true
```

find() et findindex() permettent de rechercher une valeur ou son indice. C'est le même format que les fonctions de rappel avec l'élément parcourus *item* ou la *valeur actuelle*, ensuite l'*indice* puis enfin le *tableau*.

```js
// valeur actuelle, indice, tableau
```

```js
let someArray = ["a", "Bernard", "e", "i", "o", "u"];

let result = someArray.find(value => value.length > 1);

console.log(result);
```
```
Bernard
```

Voilà il nous affiche Bernard qui est le seule avec une longueur strictement supérieur à 1.

Retourner l'indice.

```js
let someArray = ["a", "Bernard", "e", "i", "o", "u"];

let result = someArray.findIndex(value => value.length > 1);

console.log(result);
```
```
1
```

Bernard à l'indice 1.

Voilà on peut soit passer par valeur ou avec une fonction `find(function(){});`.

## Fusion de tableaux

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Salim"];
let anotherArray = ["Franck", "Nassima", "Paul"];

console.log(someArray.concat(anotherArray));
```
```
(8) ['Laura', 'Bernard', 'Salim', 'Fatima', 'Salim', 'Franck', 'Nassima', 'Paul']
```

## Tri ou inversion des éléments

Trier avec sort().

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

console.log(anotherArray.sort());
```
```
(10) [-2, -2, -23, 0, 1, 14, 2, 5, 56, 6]
```

Inverser les valeurs reverse().

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

console.log(anotherArray.reverse());
```
```
(10) [0, -2, -23, 56, 5, 6, 2, 1, 14, -2]
```

Trier des chaînes de caractères.

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

console.log(someArray.sort());
```
```
(5) ['Bernard', 'Fatima', 'Laura', 'Salim', 'Salim']
```

... mais pour trier encore mieux les chaînes de caractères, on utilise la méthode localeCompare().

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

console.log(someArray.sort( (a, b) => a.localeCompare(b) ));
```
```
(5) ['Bernard', 'Fatima', 'Laura', 'Salim', 'Salim']
```

Remarque : ici on a utilisé la notation flechée mais on peut l'écrire comme ceci.

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

console.log(someArray.sort(function(a, b)
{
    return a.localeCompare(b);
}));
```
```
(5) ['Bernard', 'Fatima', 'Laura', 'Salim', 'Salim']
```

Voilà une **fonction flechée** mais prévilégié toujours la méthode la plus lisible plutôt que gagner en nombre de lignes.

## Copie superficielle d un tableau

Extraire une partie du tableau avec la méthode slice().

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

let subArray = someArray.slice();

console.log(subArray);
```
```
(5) ['Laura', 'Bernard', 'Salim', 'Fatima', 'Salim']
```

Ici on a extrait la totalité du tableau, on a tous les éléments.

Le premier paramètre inclut l'élément et le second paramètre exclue l'indice, `someArray.slice(0, 2);`.

```js
let someArray = ["Laura", "Bernard", "Salim", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

let subArray = someArray.slice(0, 2);

console.log(subArray);
```
```
(2) ['Laura', 'Bernard']
```

Attention l'extraction permet de créer un nouveau tableau à partir des éléments extraits.

## Modifier le contenu du tableau

1e param : indice où j'effectue la modification.
2e param : nombre d'élément que je supprime.
3e param : élément à ajouter.

```js
let someArray = ["Laura", "Bernard", "Franck", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

someArray.splice(0, 0, "Marie");

console.log(someArray);
```
```
(6) ['Marie', 'Laura', 'Bernard', 'Franck', 'Fatima', 'Salim']
```

Maintenant à l'indice `0`, on supprimer `1` élément depuis cet indice et on le remplace par `Marie`.

```js
let someArray = ["Laura", "Bernard", "Franck", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

someArray.splice(0, 1, "Marie");

console.log(someArray);
```
```
(5) ['Marie', 'Bernard', 'Franck', 'Fatima', 'Salim']
```

Désolé Laura, on te remplace par Marie.

Maintenant on supprime Franck et Fatima par Marie et Julier.

```js
let someArray = ["Laura", "Bernard", "Franck", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

someArray.splice(2, 2, "Marie", "Julien");

console.log(someArray);
```
```
(5) ['Laura', 'Bernard', 'Marie', 'Julien', 'Salim']
```
## Création d un tableau selon une condition

Filtrer avec filter().

```js
let someArray = ["Laura", "Bernard", "Franck", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

console.log(anotherArray.filter(x => x > 0));
```
```
(6) [14, 1, 2, 6, 5, 56]
```

Voilà on a des valeurs strictement supérieur à 0.

## Création d un tableau avec les résultats d une fonction

Créer un nouveau tableau en remplacant tous les éléments par `inconnu` avec map().

```js
let someArray = ["Laura", "Bernard", "Franck", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

let result = someArray.map(value => "Inconnu");

console.log(result);
```
```
(5) ['Inconnu', 'Inconnu', 'Inconnu', 'Inconnu', 'Inconnu']
```

Idem avec une fonction map().

```js
let someArray = ["Laura", "Bernard", "Franck", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

let result = someArray.map(function(value, index)
{
    return value = "Inconnu";
});

console.log(result);
```
```
(5) ['Inconnu', 'Inconnu', 'Inconnu', 'Inconnu', 'Inconnu']
```

On remplace les valeurs par les index.

```js
let someArray = ["Laura", "Bernard", "Franck", "Fatima", "Salim"];
let anotherArray = [-2, 14, 1, 2, 6, 5, 56, -23, -2, 0];

let result = someArray.map(function(value, index)
{
    return value = index;
});

console.log(result);
```
```
(5) [0, 1, 2, 3, 4]
```

## Conclusion

Voilà nous avons manipulé les tableaux.

On manipulera les tableaux typées plutard.

Ciao tout le monde.