# [4. Opérateurs](https://www.youtube.com/watch?v=lThLyuv2_JM)

+ [Opérateur affectation](#Opérateur-affectation)
+ [Opérateur arithmétique](#Opérateur-arithmétique)
+ [Incrémentation et décrémentation](#Incrémentation-et-décrémentation)
+ [Opérateur de comparaison](#Opérateur-de-comparaison)
+ [Opérateur égalité](#Opérateur-égalité)
+ [Opérateur inégalité](#Opérateur-inégalité)

```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Ma page web</title>
</head>
<body>
    <h1>FormationVidéo</h1>

    <button>CLIQUEZ ICI !</button>

    <script src="script.js"></script>
</body>
</html>
```

## Opérateur affectation

```js
let age = 14;

document.write(age);
```

## Opérateur arithmétique

Priorité : PEMDAS.
Modulo = reste de la division euclidiène.
5 / 2 = 2 (modulo = 1)

```js
/*
    =
    + - * / %
*/
document.write(5 / 2); // 5/2 <-> 5.0 / 2.0
```

## Incrémentation et décrémentation

```js
/*
    = += -= *= /= %=
    + - * / %
*/

let N = 450;

N = N + 1;//N += 1
N = N - 2;//N -= 2

document.write(N);
```

Voilà le code est dynamique surtout pour les système de progression de niveau par exemple.

```js
/*
    = += -= *= /= %=
    ++ --
    + - * / %
*/

let N = 450;
N++;//++N
N--;//--N

document.write(N);
```

Voilà pré-/post-décrémentation et pré-/post-incrémentation.

`N++` signifie qu'on évalue l'expression d'habord et qu'on ajoute 1 et revient à faire `N = N + 1`. En gros, on affecte d'abord N à N `N = N` c'est-à-dire l'affectation d'habord et enfin on ajoute 1 à N `N + 1` donc 2 opérations qui sont faites.

```js
/*
    N++
        -> N = N
        -> N + 1
    
    ++N
        -> N + 1
        -> N = N
*/
```

post-incrémentation car on ajoute 1 après l'affectation et dans la préincrémentation c'est l'inverse.

```js
let N = 5;

document.write(N++);//5
document.write(N);//6
```
Retourne 5 car affichage avant l'incrémentation.

:warning: Pour éviter des résultats inantendus utiliser la pré-incrémentation/décrémentation comme ça vous êtes sûr que l'opération arithmétatique est faites d'habord et l'affectation ensuite. Sinon si on fait une post- selon la priorité comme par exemple l'affichage est prioritaire par rapport à l'incrémentation.

Idem pour la décrémentation.

```js
let N = 5;

document.write(--N);//4
```

## Opérateur de comparaison

```js
/*
    = += -= *= /= %=
    ++ --
    + - * / %
    < > <= >=
*/
document.write(8 < 12);
```

Le résultat est true.

## Opérateur égalité

```js
/*
    = += -= *= /= %=
    ++ --
    + - * / %
    < > <= >=
    == ===
*/
document.write(8 == 12);
```

Le résultat est false.

On peut aussi vérifier l'égalité de type.

```js
document.write(8 === 12);
```

Le résultat est true.

```js
document.write(8 === '8');
```

Le résultat est false car même si les valeurs sont les mêmes, les types sont différents.

## Opérateur inégalité

```js
/*
    = += -= *= /= %=
    ++ --
    + - * / %
    < > <= >=
    == === != !==
*/
document.write(8 != 16);
```

Le résultat est true.

Ensuite `!==` retourne true si le type des données est différent OU alors si les valeurs ne sont pas égales. C'est l'un ou l'autre, il ne faut pas que le type soit différent et que la valeur soit différente. C'est seulement une des deux.

```js
document.write(8 !== 8);
```

Le résultat est false.

```js
document.write(8 !== '8');
```

Le résultat est true car une seule des conditions à été validée.

C'est vraiment l'un ou l'autre.