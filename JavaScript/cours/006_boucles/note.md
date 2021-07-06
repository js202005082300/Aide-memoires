# [6. Boucles](https://www.youtube.com/watch?v=mYXaFHKXku0)

+ [while](#while)
+ [do while](#do-while)
+ [for](#for)
+ [break](#break)
+ [continue](#continue)

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

## while

Factoriser du code pour éviter la répétition de code.

```js
let i = 0;

while(i < 5)
{
    document.write("a ");
    i++;
}
```

:warning: attention au point d'arrêt pour valider l'expression de la boucle et pour éviter la boucle infinie sauf que ça peut être utile lorsqu'on fait de l'affichage d'image par exemple.

## do while

Exécuter les insctructions au moins une fois.

```js
let i = 10;

do
{
    document.write("AAA ");
    i++;
}
while(i < 10); //; ou sans
```

Le point-virgule est optionnel.

## for

```js
for(let i = 0 ; i < 5 ; ++i)
    document.write("a ");
```

On fait une pré-incrémentation pour accéler l'éxécution.

Pour infos, on a également la boucle `for(let element of sac)` avec *of* ou *in* mais on vera ces particularitées plus tard.

## break

Interrompre la boucle.

```js
for(let i = 0 ; i < 50 ; ++i)
{
    document.write("a ");

    if(i === 25)
        break;
}
```

On fait la moitié des itérations.

## continue

Recommencer la boucle sans exécuter la suite, repartir sur une nouvelle itération.

```js
for(let i = 0 ; i < 50 ; ++i)
{
    document.write("a ");

    if(i === 25)
        continue;
}
```