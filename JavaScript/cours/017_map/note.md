# [17. Map](https://www.youtube.com/watch?v=UgyCb9_ytho)

+ [Introduction](#Introduction)
+ [Qu'est-ce qu'un objet Map ?](#Qu-est-ce-qu-un-objet-Map)
+ [Différences avec une structure d'objet](#Différences-avec-une-structure-d-objet)
+ [Déclarer une map](#Déclarer-une-map)
+ [Nombre d'éléments d'une map](#Nombre-d-éléments-d-une-map)
+ [Ajouter ou supprimer des éléments](#Ajouter-ou-supprimer-des-éléments)
+ [Rechercher un élément](#Rechercher-un-élément)
+ [Récupérer une valeur suivant la clé](#Récupérer-une-valeur-suivant-la-clé)
+ [Récupérer les entrées via un itérateur](#Récupérer-les-entrées-via-un-itérateur)
+ [Exécuter une fonction sur chaque élément](#Exécuter-une-fonction-sur-chaque-élément)
+ [Conclusion](#Conclusion)

>

## Introduction
## Qu est-ce qu un objet Map

Les maps sont une collection de données composées d'une clé et d'une valeur.

On peut itérer sur ce type de données dans l'ordre de leurs insertions.

## Différences avec une structure d objet

Syntaxe d'une structure de type d'objet.

```js
let something = {
    one: "One",
    two: "Two"
}
```

Ici on a des type par défaut, pour les maps on a pas de type par défaut.

L'avantage de la map, c'est qu'on peut avoir des clés de n'importe quel type.

L'ordre d'insertion dans la map aura son importance.

## Déclarer une map
## Nombre d éléments d une map

Une map vide avec la propriété size qui retourne le nombre d'éléments.

```js
let someMap = new Map();

document.write(someMap.size);
```
```
JavaScript #17 - Map
0
```

## Ajouter ou supprimer des éléments

Pour l'ajout,

```js
let someMap = new Map();

document.write(someMap.size);

someMap.set(1, "Un");
someMap.set(2, "Deux");

document.write(someMap.size);
```
```
JavaScript #17 - Map
02
```

Le couple clé-valeur compte pour un seul élément.

Pour la suppression,

```js
let someMap = new Map();

document.write(someMap.size);

someMap.set(1, "Un");
someMap.set(2, "Deux");

someMap.delete(2);
someMap.clear();

document.write(someMap.size);
```
```
JavaScript #17 - Map
00
```

Résumé,

```js
/*
    .size

    set(), delete(), clear()
*/
```

## Rechercher un élément

Pour les conditions,

```js
let someMap = new Map();

someMap.set(1, "Un");
someMap.set(2, "Deux");

if(someMap.has(1))
    document.write("Oui !");
```
```
JavaScript #17 - Map
Oui !
```

Si on test "1" au lieu de 1, ça ne marche pas.

## Récupérer une valeur suivant la clé

Méthode get().

```js
/*
    .size

    set(), delete(), clear()
    has(), get()
*/

let someMap = new Map();

someMap.set(1, "Un");
someMap.set(2, "Deux");

document.write(someMap.get(1));
document.write(someMap.get(3));
```
```
JavaScript #17 - Map
Un
undefined
```

## Récupérer les entrées via un itérateur

Parcourir sur les clés.

```js
let someMap = new Map();

someMap.set(1, "Un");
someMap.set(2, "Deux");

const it = someMap.keys();

document.write(it.next().value);
document.write(it.next().value);
```
```
JavaScript #17 - Map
12
```

Avec next(), on réitère bien sur le suivant.

Parcourir pour obtenir les valeurs.

```js
let someMap = new Map();

someMap.set(1, "Un");
someMap.set(2, "Deux");

const it = someMap.values();

document.write(it.next().value);
document.write(it.next().value);
```
```
JavaScript #17 - Map
UnDeux
```

**Attention pour les Ensembles, keys est un alias de values parce que pour les ensembles, nous n'avons pas de couples clés-valeurs mais pour les maps, il y a la distinction entre keys et values.**

pour récupérer, comme pour les ensembles, c'est Entries() qui nous renvoie un tableau.

```js
/*
    .size

    set(), delete(), clear()
    has(), get()
    keys(), values(), entries()
*/

let someMap = new Map();

someMap.set(1, "Un");
someMap.set(2, "Deux");

const allEntries = someMap.entries();

for(entries of allEntries)
    document.write("<p>" + entries[0] + " > " + entries[1] + "</p>");
```
```
JavaScript #17 - Map
1 > Un

2 > Deux
```


## Exécuter une fonction sur chaque élément

```js
/*
    .size

    set(), delete(), clear()
    has(), get()
    keys(), values(), entries()
    forEach()
*/

let someMap = new Map();

someMap.set(1, "Un");
someMap.set(2, "Deux");

function showMeTheTruth(value, key)
{
    document.write("<p>(" + key + ", " + value + ")</p>");
}

someMap.forEach(showMeTheTruth);
```
```
JavaScript #17 - Map
(1, Un)

(2, Deux)
```
Appliquer un foreach() sur l'ensemble des entrée de notre Map.

## Conclusion

Voilà pour les notions en Javascript.

Ciao tout le monde