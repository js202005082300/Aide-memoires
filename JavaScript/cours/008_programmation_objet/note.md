# [8. Programmation objet](https://www.youtube.com/watch?v=cnnhogixcI0)

+ [Notion de POO](#Notion-de-POO) : [Classe abstraite](#Classe-abstraite), [Représentation](#Représentation), [Réutilisation de code](#Réutilisation-de-code), [Evolutivité](#Evolutivité), [Factorisation](#Factorisation), [Langage Multi-Paradigme](#Langage-Multi-Paradigme)
+ [Code minimal - une classe et un constructeur par défaut et une nouvelle instance](#Code-minimal---une-classe-et-un-constructeur-par-défaut-et-une-nouvelle-instance)
+ [Créer un attribut](#Créer-un-attribut)
+ [Accessibilité des éléments](#Accessibilité-des-éléments)
+ [Accesseur - getter](#Accesseur---getter)
+ [Méthode de classe](#Méthode-de-classe)
+ [Accesseur - setter](#Accesseur---setter)
+ [Paramètre par défaut](#Paramètre-par-défaut)
+ [Mettre une classe en tant que expression ou en tant que anonyme](#Mettre-une-classe-en-tant-que-expression-ou-en-tant-que-anonyme)

```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Cours JavaScript</title>
</head>
<body>
    <h1>Cours JavaScript # 8 - programmation objet</h1>

    <script src="main.js"></script>
</body>
</html>
```

## Notion de POO

Par exemple, l'humain serait une entité, un modèle de fabrication, une classe.

On crée des instances de ce modèle pour créer nos objet.

Un Animal est une classe comme l'humain mais sont très générale mais on peut avoir d'autres classes plus spécifiques (chiens, chats, ...).

Une classe est un modèle por créer divers objets.

Une classe est constituées d'attributs et de services qu'elles peuvent faire sont des méthodes, des actions qu'elles peuvent faire. Ce sont des fonctions.

### Classe abstraite

On peut représenter des classes plus abstraites.

La capacité de vol peut être représenté par une classe qu'on rattache à d'autres classes comme l'humain, une voiture qui acquèrent la capacité de voler.

On peut faire interragir ces classes entre-elles.

Autre exemple, une classe management dans un jeu vidéo.

### Représentation

Une classe c'est comme une boîte.

Une voiture peut rendre plusieurs services (méthodes) et les attributs qui la constitue (vitesse, niveau de carburant ...).

### Réutilisation de code

Utiliser les classe, fonctions de quelqu'un d'autre pour manipuler des fichiers par exemple.

### Evolutivité

Enrichir une classe de traitement de fichier avec des attributs, des méthodes pour apporter de nouvelles fonctionnalités.

### Factorisation

La classe factorise toutes fonctions d'un modèle, ce qui permet de mieux organiser son code.

### Langage Multi-Paradigme

Certains langages utilisent les deux paradigmes suivant les parties d'un même code.

## Code minimal - une classe et un constructeur par défaut et une nouvelle instance

Par exemple, créons un lecteur de musique.

Le code minimal pour définir une nouvelle instance de MusicPlayer.

```js
class MusicPlayer
{
    constructor()
    {
        document.write("Objet cree !");
    }
}

let player = new MusicPlayer();
```

On définit une classe et un constructeur par défaut sans paramètres à lui passer.

## Créer un attribut

Passer des attributs dans notre constructeur et qui sont rattaché à notre classe, et pour former un attribut de la classe, on utilise le mot clé this.

this signifie que ça apprtient à cet instance en cours.

```js
class MusicPlayer
{
    constructor(format)
    {
        this.format = format;
        document.write(this.format);
    }
}

let player = new MusicPlayer("MP3");
let player2 = new MusicPlayer("OGG");
```

On crée un attribut de la classe MusicPlayer appelé format et tu lui affecte la valeur qu'on a passé au constructeur par exemple "MP3".

On affiche bien la chaîne de caractère.

Deux objets bien distinctes avec un attribut de valeur différentes.

## Accessibilité des éléments

Les attributs son accessible depuis la classe et si on veux pouvoir y accéder depuis l'extérieur, il faut utiliser des accesseurs.

Parmi les accesseurs, le getter pour obtenir la valeur d'un attribur et un setter pour modifier la valeur d'un attribut.

En JavaScript, on aura plutard la possibilité de créer des attributs publics ou privés et que ce soit pris en charge par tout les navigateurs webs mais pour le moment ce n'est pas possible.

```js
class MusicPlayer
{
    format; //public
    #format; //private

    constructor(format)
    {
        this.format = format;
        document.write(this.format);
    }
}

let player = new MusicPlayer("MP3");
let player2 = new MusicPlayer("OGG");
```

Voilà la syntaxe public `format;` et la syntaxe privé `#format;``mais pour l'instant il ne faut pas les utiliser car ça ne fonctionne pas sur Edge, Safari, FireFox.

On peut accéder à un attribut en dehors de la classe (sans le mot clé this qui s'utilise au sein de la classe pour représenter l'instance, l'objet).

```js
class MusicPlayer
{
    constructor(format)
    {
        this.format = format;
        document.write(this.format);
    }
}

let player = new MusicPlayer("MP3");
document.write(player.format);
```

Dans d'autres langages de programmation où l'attribut est privé ça ne marcherais pas, il faudrait faire quelque chose comme ceci `document.write(player.getFormat());` avec la méthode getFormat().

## Accesseur - getter

Il faudrait faire ceci `getFormat()` et non `function getFormat()` parce qu'on est dans une fonction appartenant à une classe donc il n'y a pas besoin du mot-clé function.

```js
class MusicPlayer
{
    constructor(format)
    {
        this.format = format;
    }

    getFormat()
    {
        return this.format;
    }
}

let player = new MusicPlayer("MP3");
document.write(player.getFormat());
```

function c'est pour une fonction standard en JavaScript mais quand on est dans une méthode de classe, on met juste directement le nom de la méthode.

On peut avoir l'habitude en c++ ou en Java, hé bien on demandera de garder cette habitude avec JavaScript même s'il n'y a pas encore de sécurité d'accès aux classes depuis l'extérieur.

Ainsi on obtient le même résultat en actualisant la page.

## Méthode de classe

Voilà nous avons vu comment faire une méthode pour une classe (voir pour les accesseurs - getFormat()).

```js
class MusicPlayer
{
    constructor(format)
    {
        this.format = format;
    }

    play()
    {
        console.log("Lecture en cours...");
    }

    getFormat()
    {
        return this.format;
    }
}

let player = new MusicPlayer("MP3");
player.play();
```

Voilà, on lit dans la console que la lecture est en cours.

## Accesseur - setter

Modification d'un attribut.

```js
class MusicPlayer
{
    constructor(format)
    {
        this.format = format;
    }

    play()
    {
        console.log("Lecture en cours...");
    }

    getFormat()
    {
        return this.format;
    }

    setFormat(new_format)
    {
        this.format = new_format;
    }
}

let player = new MusicPlayer("MP3");
console.log(player.getFormat());
player.setFormat("M4A");
console.log(player.getFormat());
```

Voilà la modification se fait bien.

Mais encore une fois JavaSCript ne fait pas la distinction entre privé et public donc il suffit de faire `player.format = "M4A";` dans la portée globale pour modifier l'attribut.

```js
class MusicPlayer
{
    constructor(format)
    {
        this.format = format;
    }

    play()
    {
        console.log("Lecture en cours...");
    }

    getFormat()
    {
        return this.format;
    }

    setFormat(new_format)
    {
        this.format = new_format;
    }
}

let player = new MusicPlayer("MP3");
player.format = "M4A";
```

Ceci serait impossible à faire en c++ ou en Java sans passer par un setter donc garder de bonne habitude.

## Paramètre par défaut

```js
class MusicPlayer
{
    constructor(format = "Toto")
    {
        this.format = format;
    }

    getFormat()
    {
        return this.format;
    }
}

let player = new MusicPlayer();
console.log(player.getFormat());
```

## Mettre une classe en tant que expression ou en tant que anonyme

On peut mettre une classe en tant qu'expression tel que l'on a vu avec les fonctions, expressions nommées.

```js
let MP = class MusicPlayer
{
    constructor(format)
    {
        this.format = format;
    }

    play()
    {
        console.log("Lecture en cours...");
    }

    getFormat()
    {
        return this.format;
    }

    setFormat(new_format)
    {
        this.format = new_format;
    }
};
```

Mais on peut faire une classe anonyme aussi.

```js
let MP = class
{
    constructor(format)
    {
        this.format = format;
    }

    play()
    {
        console.log("Lecture en cours...");
    }

    getFormat()
    {
        return this.format;
    }

    setFormat(new_format)
    {
        this.format = new_format;
    }
};
```

Ainsi notre classe est rattachée à `MP` et non plus à `MusicPlayer`.

On l'instancie donc comme ceci.

```js
let MP = class
{
    constructor(format)
    {
        this.format = format;
    }

    play()
    {
        console.log("Lecture en cours...");
    }

    getFormat()
    {
        return this.format;
    }

    setFormat(new_format)
    {
        this.format = new_format;
    }
};

let music = new MP("MP3");
music.play();
```

Voilà pour les expressions nommées (et les expressions anonymes), on fait un empacketage dans une variable.