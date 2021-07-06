# [9. Prototypes et classes](https://www.youtube.com/watch?v=_Ilj_unoqvA)

+ [Accèder à un élément de classe](#Accèder-à-un-élément-de-classe)
+ [Modifier un élément de classe](#Modifier-un-élément-de-classe)
+ [Définir un attribut privé en programmation orienté prototype ou pseudo-classe](#Définir-un-attribut-privé-en-programmation-orienté-prototype-ou-pseudo-classe)
+ [Définir un attribut statique - programmation orienté prototype](#Définir-un-attribut-statique---programmation-orienté-prototype)
+ [Définir une méthode statique - programmation orienté prototype](#Définir-une-méthode-statique---programmation-orienté-prototype)
+ [Définir une méthode statique - programmation orienté classe](#Définir-une-méthode-statique---programmation-orienté-classe)
+ [Avantage de la pseudo-classe](#Avantage-de-la-pseudo-classe)
+ [Créer un attribut de classe en dehors de cette classe](#Créer-un-attribut-de-classe-en-dehors-de-cette-classe)
    + [Modifier cet attribut](#Modifier-cet-attribut)
    + [Supprimer cet attribut](#Supprimer-cet-attribut)
+ [Créer une fonction de classe en dehors de cette classe](#Créer-une-fonction-de-classe-en-dehors-de-cette-classe)
+ [Info - héritage](#Info---héritage)

>

On reprend notre code.

```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Cours JavaScript</title>
</head>
<body>
    <h1>Cours JavaScript # 9 - prototypes et classes</h1>

    <script src="main.js"></script>
</body>
</html>
```

```js
// ES6
class MusicPlayer
{
    constructor(filetype)
    {
        this.filetype = filetype;
    }

    /*getFiletype()
    {
        return this.format;
    }

    setFiletype(new_filetype)
    {
        this.filetype = new_filetype;
    }*/
};

let song = new MusicPlayer("MP3");
```

## Accèder à un élément de classe

La norme ECMAScript a apporté tout un tas de nouvelles fonctionnalités. Sur ECMAScript 5, on a des syntaxes anciennes et sur la version 6 de 2015, abrégé ES6, on a eu de nouvelle syntaxe comme ci-dessous.

Dans cette vidéo on va voir les prototypes et classes.

Comme on l'a vu précédemment les méthodes getter et setter sont complément inutiles car l'attribut filetype sera forcément public.

```js
// ES6
class MusicPlayer
{
    constructor(filetype)
    {
        this.filetype = filetype;
    }
};

let song = new MusicPlayer("MP3");
document.write(song.filetype);
```

On a parfaitement accès à l'information sans passer par un getter, sans passer par un setter.

C'est le comportement déterminer depuis l'arrivé de la norme ES6.

## Modifier un élément de classe

Idem la portée des attributs est public par défaut.

```js
// ES6
class MusicPlayer
{
    constructor(filetype)
    {
        this.filetype = filetype;
    }
};

let song = new MusicPlayer("MP3");
document.write(song.filetype + "<br>");
song.filetype = "OGG";
document.write(song.filetype + "<br>");
```

Tout est public donc pas de problème, la philosophie au niveau des attributs d'une classe rejoint un peu Python mais des différences aux niveaux des syntaxes.

## Définir un attribut privé en programmation orienté prototype ou pseudo-classe

Une syntaxe qui permet la définition d'attribut privé.

this fait référence à l'instance courrante et est public.

```js
// ES6
// class MusicPlayer
// {
//     constructor(filetype)
//     {
//         this.filetype = filetype;
//     }
// };

function MusicPlayer(filetype)
{
    this.filetype = filetype;
};

let song = new MusicPlayer("MP3");
document.write(song.filetype + "<br>");
song.filetype = "OGG";
document.write(song.filetype + "<br>");
```

Avec le mot-clé var, l'attribut devient privé et le navigateur retourne undefined donc pour accéder à cet élément, je vais devoir faire une méthode public englobé par `this.filetype` et qui retournera `filetype` directement.

```js
function MusicPlayer(filetype)
{
    var filetype = filetype;
};

let song = new MusicPlayer("MP3");
document.write(song.filetype + "<br>");
```

`filetype` est enfin privé donc je vais faire une méthode pour y accéder.

```js
/*
    Classe : pas d'attributs privés
*/

function MusicPlayer(filetype)
{
    var filetype = filetype;

    this.filetype = function()
    {
        return filetype; //et non this.filetype parce qu'on a dit que this était public.
    }
};

let song = new MusicPlayer("MP3");
document.write(song.filetype() + "<br>");
```

Voilà l'appel à la méthode filetype() fait office d'accesseur, un getter() (on pourrais aussi faire un setter...).

## Définir un attribut statique - programmation orienté prototype

Un élément statique est accéssible en dehors de notre classe donc forcément public mais surtout sans avoir besoin de créer une instance.

Par exemple `MusicPlayer.data = 14;` déclaré en dehors de la classe.

```js
/*
    Classe :    pas d'attributs privés
                pas d'attributs statiques
*/

// class MusicPlayer
// {
//     constructor(filetype)
//     {
//         this.filetype = filetype;
//     }
// };

function MusicPlayer(filetype)
{
    var filetype = filetype;

    this.filetype = function()
    {
        return filetype;
    }
};

MusicPlayer.data = 14;

//let song = new MusicPlayer("MP3");
document.write(MusicPlayer.data);
```

On actualise et on a bien accès à l'information (14).

Ca c'était pour de la programmation orienté prototype plutôt que de la programmation orienté classe.

Maintenant on sait qu'une classe ne peut pas avoir d'attributs privés ou d'attributs statiques donc si on veut une forme de classe qui a besoin d'attributs privés ou d'attributs statisques, il faudra passer par cette syntaxe.

```js
function MusicPlayer(filetype)
{
    var filetype = filetype;

    this.filetype = function()
    {
        return filetype;
    }
};

MusicPlayer.data = 14;
```

Et si ça n'a pas d'importance et qu'on a pas besoin de ce type d'attribut, on fait de la programmation orienté classe.

```js
class MusicPlayer
{
    constructor(filetype)
    {
        this.filetype = filetype;
    }
};
```

## Définir une méthode statique - programmation orienté prototype

Encore une fois un variable englobe une fonction et comme elle fait qu'une seule chose, on la met sur une seule ligne.

```js
/*
    Classe :    pas d'attributs privés
                pas d'attributs statiques
*/

// class MusicPlayer
// {
//     constructor(filetype)
//     {
//         this.filetype = filetype;
//     }
// };

function MusicPlayer(filetype)
{
    var filetype = filetype;

    this.filetype = function()
    {
        return filetype;
    }
};

MusicPlayer.hello = function() {return "Hello World !";};

//let song = new MusicPlayer("MP3");
document.write(MusicPlayer.hello());
```

## Définir une méthode statique - programmation orienté classe

Idem mais en passant par une classe.

```js
/*
    Classe :    pas d'attributs privés
                pas d'attributs statiques
*/

class MusicPlayer
{
    constructor(filetype)
    {
        this.filetype = filetype;
    }

    static hello()
    {
        return "Hello World !";
    }
};

// function MusicPlayer(filetype)
// {
//     var filetype = filetype;

//     this.filetype = function()
//     {
//         return filetype;
//     }
// };

// MusicPlayer.hello = function() {return "Hello World !";};

//let song = new MusicPlayer("MP3");
document.write(MusicPlayer.hello());
```

Ici on a bien la méthode dans le scope de la classe alors que précédemment, la méthode était globale.

## Avantage de la pseudo-classe

L'avantage c'est qu'on peut avoir une partie de notre programme ou la pseudo-classe est définie, et dans un autre fichier si on fait de la programmation plus modulaire, avoir d'autres méthodes statiques qu'on pourra ajouter donc on pourra avoir une séparation au niveau du code.

Dans la programmation orienté classe, il faudra que tout le code soit au même endroit.

## Créer un attribut de classe en dehors de cette classe

```js
/*
    Classe :    pas d'attributs privés
                pas d'attributs statiques
*/

class MusicPlayer
{
    constructor(filetype)
    {
        this.filetype = filetype;
    }
};

let song = new MusicPlayer("MP3");
document.write(song.filename + "<br>");

MusicPlayer.prototype.filename = "C:";

let song2 = new MusicPlayer("OGG");
document.write(song2.filename + "<br>");
```

Il faut comprendre que toutes nos classes héritent d'une autre classe qui s'appelle `object` et notament une autre classe qui s'appelle `function` et qui possède un élément `prototype` (nous verrons quand on parlera d'héritage) donc en écrivant ce genre de syntaxe `MusicPlayer.prototype` commençant par le nom de notre classe suivant de notre élément prototype, nous pouvons ajouter un nouveau attribut.

:warning: cet élément est disponible uniquement pour les instances déclarées après (song2).

### Modifier cet attribut

On peut néanmoins l'initialiser à null puis changer la valeur au fil du code.

```js
/*
    Classe :    pas d'attributs privés
                pas d'attributs statiques
*/

class MusicPlayer
{
    constructor(filetype)
    {
        this.filetype = filetype;
    }
};

MusicPlayer.prototype.filename = null;

let song = new MusicPlayer("MP3");
document.write(song.filename + "<br>");

song.filename = "C:\\Users\\";
document.write(song.filename + "<br>");
```

### Supprimer cet attribut

```js
/*
    Classe :    pas d'attributs privés
                pas d'attributs statiques
*/

class MusicPlayer
{
    constructor(filetype)
    {
        this.filetype = filetype;
    }
};

MusicPlayer.prototype.filename = null;

let song = new MusicPlayer("MP3");
document.write(song.filename + "<br>");

song.filename = "C:\\Users\\";
document.write(song.filename + "<br>");

delete song.filename;
document.write(song.filename + "<br>");
```

Voilà on peut ajouter l'attribut avec le fameux prototype et on peut supprimer cet attribut donc on retourne ceci.

```html
null
C:\Users\
null
```

## Créer une fonction de classe en dehors de cette classe

```js
/*
    Classe :    pas d'attributs privés
                pas d'attributs statiques
*/

class MusicPlayer
{
    constructor(filetype)
    {
        this.filetype = filetype;
    }
};

MusicPlayer.prototype.hello = function()
{
    return "Hello !";
};

let song = new MusicPlayer("MP3");
document.write(song.hello());
```

`prototype` permet après la définition de la classe d'ajouter des attributs et des méthodes, mais il existe encore d'autres syntaxes pour atteindre ce résultat.

## Info - héritage

Comme les classe hérite de `Object`, on peut instancier en faisant `Objet.create()` au lieu de `new`.

```js
//...

let song = Object.create(MusicPlayer/*...*/);
document.write(song.hello());
```