# [7. Fonctions](https://www.youtube.com/watch?v=RUT2fr28YYg)

+ [Créer une fonction](#Créer-une-fonction)
+ [Appel à la fonction](#Appel-à-la-fonction)
+ [Nommage](#Nommage)
+ [Portée globale](#Portée-globale)
+ [return et la portée des variable](#return-et-la-portée-des-variable)
+ [Paramètre par défaut](#Paramètre-par-défaut)
+ [Nombre de paramètres variables](#Nombre-de-paramètres-variables)
+ [Fonctions imbriquées et la portée de fonction](#Fonctions-imbriquées-et-la-portée-de-fonction)
+ [Expression de fonction](#Expression-de-fonction)
+ [Expression de fonction anonyme](#Expression-de-fonction-anonyme)
+ [Fonction fléchée](#Fonction-fléchée)

```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Cours JavaScript</title>
</head>
<body>
    <h1>Cours JavaScript # 7 - fonctions</h1>

    <script src="main.js"></script>
</body>
</html>
```

Nous avons vu quelques fonctions console.log(), document.write() et cetera.

La 1e utilité des fonctions est de factoriser du code et éviter la répétition.

## Créer une fonction

```js
function helloWorld()
{
    document.write("Hello ");
    document.write("World !");
}
```

Elle ne retourne rien (void).

## Appel à la fonction

```js
function helloWorld()
{
    document.write("Hello ");
    document.write("World !");
}

helloWorld();
```

:warning: une fonction ne doit faire qu'une seule chose.

```js
function getNewsDatabase()
{
    //code...
}
```

## Nommage

```js
/*
    Pas de caractères spéciaux,
    Underscores,...
*/
myFunction // camelCase
my_function // snake_case
MyFunction // PascalCase
My_Function // ...
```

## Portée globale

```js
let data = "OK";

function FunctionName()
{
    document.write("TEST : " + data);
}

FunctionName();
```

On peut accéder à la variable data à l'extérieur de la fonction.

```js
let data = "OK";

function FunctionName()
{
    let data2 = 14;
    document.write(data2);
    document.write("TEST : " + data);
}

FunctionName();

console.log(data2);
```

![portée_variable.PNG]([portée_variable.PNG)

:warning: attention la portée des variables change d'un langage à l'autre tandis que pour JavaScript la portée des variable de la variable sont disponibles à l'intérieur de la fonction uniquement.

## return et la portée des variable

Admettons une fonction de somme.

```js
function sum(nb1, nb2)
{
    document.write(nb1 + nb2)
}

sum(4, 3);
```

Mais on peut retourner l'information dans la portée globale.

```js
function sum(nb1, nb2)
{
    return nb1 + nb2;
}

let res = sum(4, 3); // let res <- sum(4, 3)
document.write(res);
```

Notre expression de droite vient affecter la qui est à gauche.

Ou bien on déclare notre variable dans la fortée globale avant la fonction.

```js
let result = 0;

function sum(nb1, nb2)
{
    result = nb1 + nb2;
    return result;
}

result = sum(4, 3);
document.write(result);
```

On peut avoir plusieurs return.

```js
let result = 0;

function strange_sum(nb1, nb2)
{
    if(nb1 > nb2)
        return nb1 + nb2;
    else
        return nb1;
}

result = strange_sum(4, 3);
document.write(result);
```

Soit on l'affiche directement `document.write(strange_sum(4, 3));` soit on passe par une variable intermédiaire.

:warning: L'argument c'est le terme qu'on emploi lors de l'appel d'une fonction, et les paramètres c'est le terme qu'on emploi pour la définition d'une fonction.

On peut définir deux variables dans la portée globale.

```js
function sum(nb1, nb2)
{
    return nb1 + nb2;
}

let n1 = 14;
let n2 = 86;
document.write(sum(n1, n2));
```

Si on ne passe pas le nombre de paramètre : `document.write(sum(n1));` On aura une erreur *NaN* (Not a number).

## Paramètre par défaut

```js
function sum(nb1, nb2 = 1)
{
    return nb1 + nb2;
}

let n1 = 14;
let n2 = 86;
document.write(sum(n1));
```

## Nombre de paramètres variables

Trois petits points suivis de args.

```js
function sum(...args)
{
    return nb1 + nb2;
}

let n1 = 14;
let n2 = 86;
document.write(sum(n1));
```

## Fonctions imbriquées et la portée de fonction

Imbriqué une fonction dans une autre. 

```js
function some_function()
{
    let data = 16;

    function another_function()
    {
        document.write(data);
    }

    another_function();
}

some_function();
```

:warning: Une fonction imbriquée a accès aux données de sa fonction parente (issue de la même portée globale), là où elle a été définie.

Dans un langage de programmation, une **fermeture** ou clôture (closure en anglais) est le fait d'avoir une fonction imbriquée dans une autre.

## Expression de fonction

C'est une variable auquel on affecte la définition d'une fonction.

```js
let hi = function helloWorld()
{
    document.write("Hello World !");
};

hi();
```

Le mot-clé `let` et on termine par un point-virgule.

## Expression de fonction anonyme

Pas de nom à ma fonction.

```js
let sum = function(x, y){return x + y;};

document.write(sum(45, 6));
```

C'est ce qu'on utilisait comme notation sur ECMAScript 5 mais sur ECMAScript 6, on a introduit la notion de **fonction flèchée** qui va permettre d'écrire de façon plus raccourcie ce type d'expression de fonction.

## Fonction fléchée

Manière plus raccourcie que les expressions de fonction anonyme.

```js
/*
(<arguments>) => {<instructions>}
*/

let sum = (x, y) => {return x + y;};

document.write(sum(45, 6));
```
