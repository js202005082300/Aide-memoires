# [5. Conditions](https://www.youtube.com/watch?v=C3z7Ijv_gho)

+ [if](#if)
+ [else](#else)
+ [Imbriquer les blocs conditionnels](#Imbriquer-les-blocs-conditionnels)
+ [else if](#else-if)
+ [switch](#switch)
+ [Ternaire](#Ternaire)

Une structure conditionnelle est un bloc de code qui va vérifier une expression généralement de comparaison. En fonction de la validation de cette expression soit true ou false, on pourra exécuter certaines instructions.

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

## if

Vérifier une égalité en terme de type et de valeur

```js
let name = "Yuna";

if(name === "Yuna")
    document.write("OUI");
```

Cette expression est validé (nb. les accolades sont optionnelles).

## else

```js
let name = "Yuna";

if(name === "Yunah")
{
    document.write("OUI");
}
else
{
    document.write("NON");
}
```

## Imbriquer les blocs conditionnels

Utiliser le mot-clé `let` a une portée dans son bloc, et on peut imbriquer les blocs conditionnels.

```js
let name = "Yuna";

if(name === "Yunah")
{
    document.write("OUI");
    let number = 6;

    if(number === 6)
        document.write("oui");
}
else
{
    document.write("NON");
}
```

Ce code retourne *OUIoui*.

## else if

```js
let number = 6;

if(number < 0)
    document.write("< 0");
else if(number > 10)
    document.write("> 10");
else
    document.write(number);
```

## switch

```js
let number = 5;

switch(number)
{
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
        document.write("number < 5");
        break;

    case 5:
        document.write("number = 5");
        break;

    default:
        alert("Pas de valeur reconnue...");
        break;
}
```

Idem sur des chaînes mais ça ne sert à rien de faire un switch sur trop peu de tests.

```js
let name = "Yuna";

/*
    if(name === "Yuna")
        document.write("OK");
    else
        alert("Pas OK");
*/

switch(name)
{
    case "Yuna":
        document.write("OK");
        break;

    default:
        alert("Pas OK");
        break;
}
```

## Ternaire

```js
/*
    <condition> ? <cas_vrai> : <cas_faux>
*/

let number = 15;
//let res = (number > 10) ? true : false;
let res = (number > 10) ? "number > 10" : "number <= 10";

document.write(res);
```

On n'est pas obligé de passer par une variable.

```js
let number = 15;
document.write((number > 10) ? "number > 10" : "number <= 10");
```