# [13. Chaînes de caractères](https://www.youtube.com/watch?v=x87WIDfPtG8)

+ [Les méthodes](#Les-méthodes)
    + [concat](#concat)
    + [startsWith et endsWith](#startsWith-et-endsWith)
    + [padStart et padEnd](#padStart-et-padEnd)
    + [trim et trimStart et trimEnd](#trim-et-trimStart-et-trimEnd)
    + [indexOf](#indexOf)
    + [includes](#includes)
    + [repeat](#repeat)
    + [search](#search)
    + [replace et replaceAll](#replace-et-replaceAll)
    + [toLowerCase et toUpperCase](#toLowerCase-et-toUpperCase)
    + [substring et slice](#substring-et-slice)
    + [split](#split)

Une déclaration simple avec des quotes `' '`, des doubles quotes `" "` et maintenant on va voir les back-quotes.

```js
let s = "Hello World";

document.write(s);
```
```
Hello World
```

Voilà pour la déclaration dites primitives d'une chaîne mais on peut passer également par la création d'un objet avec la classe String.

QUel est la différence ? Il faut regarder le type.
```js
let s = "Hello World";
let s2 = new String("Hello World");

document.write(typeof s + "<br>");
document.write(typeof s2 + "<br>");
```
```
string
object
```

Peut importe la déclaration d'une chaîne primitive ou bien un objet au niveau de JavaScript avec une ou l'autre syntaxe, toutes les méthodes de manipulation sont parfaitement utilisables. Il n'y aura pas de soucis pour utiliser les méthodes qu'on va voir.

Notez que l'opérateur `+` permet de faire une concaténation même si on verra qu'on a une méthode pour faire ça.

```js
let s = "Hello World";

document.write(s + " !");
```
```
Hello World !
```

On peut faire des comparaisons.

```js
let s1 = "arbre";
let s2 = "bol";

if(s1 < s2)
    document.write("s1 < s2");
else
    document.write("...");
```
```
s1 < s2
```

Au niveau lexicographique arbre est avant bol car a est avant b.

On peut également tenter si on a une égalité.

```js
let s1 = "arbre";
let s2 = "Arbre";

if(s1 == s2)
    document.write("Oui");
else
    document.write("Non");
```
```
Non
```

Non car on se base sur la case du texte mais on peut faire une fonction pour transformer les chaînes en minuscule, puis faire une comparaison complète de la valeur et du type `===` tel qu'on la vu en PHP.

Afficher un élément en particulier à un indice, le premier élément est 0 et le dernier est *taille de la chaîne - 1* parce qu'on commence par 0.

```js
let s = "Arbre";

document.write(s.charAt(0));
document.write(s.charAt(s.length - 1)); // taille - 1
```
```
Ae
```

Voilà pour les accès.

On passe également par un système d'indice dans un autre type d'objet que sont les tableaux avec des crochets au lieu de faire appel à une méthode donc ce type de syntaxe devient fonctionnelle en JavaScript.

```js
let s = "Arbre";

document.write(s[0]);
document.write(s[s.length - 1]);
```
```
Ae
```

Notez qu'on peut utiliser le `+` pour la concaténation du plusieurs chaînes.

```js
let s = "Luc";

document.write("Bonjour " + s + ", comment vas-tu ?");
```
```
Bonjour Luc, comment vas-tu ?
```

... pour éviter cette syntaxe qui est parfois source d'erreur, on passera par un littéral de gabarit (les template en anglais) que JavaScript utilise via une chaîne formatée avec des back-quotes, l'accent grave.

```js
let s = "Luc";

document.write(`Bonjour ${s}, comment vas-tu ?`);
```
```
Bonjour Luc, comment vas-tu ?
```

Syntaxe plus lisible.

+ Affichage sur plusieurs lignes

Comme on fait appel à une variable `${s}`, on peut faire l'appel à une fonction `${maFonction(s)}`.

Notez qu'on peut mettre une chaîne sur plusieurs lignes.

```js
let s = "Bonjour, je suis en train d'apprendre " + 
        "à programmer en JavaScript.";

document.write(s);
```
```
Bonjour, je suis en train d'apprendre à programmer en JavaScript.
```

Pour un retour à la ligne, on passera par une balise `<br>`.

```js
let s = "Bonjour, je suis en train d'apprendre " + 
        "<br>à programmer en JavaScript.";

document.write(s);
```
```
Bonjour, je suis en train d'apprendre
à programmer en JavaScript.
```

... idem mais en utilisant les anti-quotes.

```js
let s = `Bonjour, je suis en train d'apprendre 
        à programmer en JavaScript.`;

document.write(s);
```
```
Bonjour, je suis en train d'apprendre à programmer en JavaScript.
```

## Les méthodes

### concat

```js
let s = "Bonjour, je suis en train d'apprendre à programmer en JavaScript";

document.write(s.concat("..."));
```
```
Bonjour, je suis en train d'apprendre à programmer en JavaScript...
```

Voilà on viens de concatener deux points.

### startsWith et endsWith

On a vu charAt() et concat(), et on peut vérifier qu'une chaîne commence ou termine par un certains nombres de caractères, et retourne un booléen.

```js
/*
    charAt(), []
    concat()
    startsWith(), endsWith()
*/

let s = "Bonjour, je suis en train d'apprendre à programmer en JavaScript.";


document.write(s.startsWith("B") + "<br>");
document.write(s.startsWith("b") + "<br>");
document.write(s.endsWith(".") + "<br>");
```
```
true
false
true
```

true car la chaîne commence par un B majuscule et finis par un point.

### padStart et padEnd

Méthode pour afficher un certains nombre de caractères ou si on veux du remplissage.

```js
/*
    charAt(), []
    concat()
    startsWith(), endsWith()
    padStart(), padEnd()
*/

let s = "M";

document.write(s.padEnd(10, ".") + "<br>");
document.write(s.padStart(10, ".") + "<br>");
```
```
M.........
.........M
```

Voilà une chaîne de 10 caractères dont 9 points ajoutés.

### trim et trimStart et trimEnd

Enlever des espaces avant et/ou après.

```js
/*
    charAt(), []
    concat()
    startsWith(), endsWith()
    padStart(), padEnd()
    trim(), trimStart(), trimEnd()
*/

let s0 = "|    bonjour    |";
let s1 = "|    bonjour    |";
let s2 = "|    bonjour    |";

document.write(s0.trim() + "<br>");
document.write(s1.trimStart() + "<br>");
document.write(s2.trimEnd() + "<br>");
```
```
| bonjour |
| bonjour |
| bonjour |
```

*On peut également utiliser des expressions rationnelles qui est à voir dans la Playlist Aide.*

### indexOf

Retourne l'indice de la 1er rencontre avec l'occurence.

```js
/*
    charAt(), []
    concat()
    startsWith(), endsWith()
    padStart(), padEnd()
    trim(), trimStart(), trimEnd()

    indexOf()
*/

let s0 = "Bonjour, j'apprends le JavaScript.";
let s1 = "Bonjour j'apprends le JavaScript.";

document.write(s0.indexOf(",") + "<br>");
document.write(s1.indexOf(",") + "<br>");
```
```
7
-1
```

On a bien la virgule à l'indice 7 parce que la chaîne commence à 0.

-1 si on ne trouve pas l'élément.

On peut l'utiliser dans une condition et tester cette méthode.

```js
let s = "Bonjour, j'apprends le JavaScript.";

if(s.indexOf(",") != -1)
    document.write("Trouvé !");
else
    document.write("Pas trouvé...");
```
```
Trouvé !
```

Voilà avec une expression à évaluer.

Plutôt pratique si on veux récupérer l'indice dans une variable et le passer à une méthode qui a besoin de cet indice pour faire un changement.

### includes

Vérifier si la chaîne inclut un élément, renvoie true si vrai.

```js
/*
    charAt(), []
    concat()
    startsWith(), endsWith()
    padStart(), padEnd()
    trim(), trimStart(), trimEnd()

    includes()
    indexOf()
*/

let s = "Bonjour, j'apprends le JavaScript.";

document.write(s.includes("Java"));
```
```
true
```

true, notre chaîne inclut une "Java".

### repeat

Répèter une chaîne.

```js
/*
    charAt(), []
    concat()
    startsWith(), endsWith()
    padStart(), padEnd()
    trim(), trimStart(), trimEnd()

    repeat()

    includes()
    indexOf()
*/

let s = "Bonjour";

document.write(s.repeat(3));
```
```
BonjourBonjourBonjour
```

On l'utilise en affichage mais on peut s'en servir pour créer une nouvelle chaîne.

```js
let s = "Bonjour";
let s_new = s.repeat(3);

document.write(s_new);
```
```
BonjourBonjourBonjour
```

### search

Fonctionne surtout avec des expressions rationnelles mais on ne verra pas cette méthode ici.

### replace et replaceAll

Méthodes pour faire du remplacement de chaîne.

replace() fait un remplacement unique et replaceAll() va remplacer toutes les occurences.

```js
/*
    charAt(), []
    concat()
    startsWith(), endsWith()
    padStart(), padEnd()
    trim(), trimStart(), trimEnd()

    repeat()
    replace(), replaceAll()

    includes()
    indexOf()
*/

let s = "Bonjour";

document.write(s.replace("o", "a") + "<br>");
document.write(s.replaceAll("o", "a") + "<br>");
```
```
Banjour
Banjaur
```

### toLowerCase et toUpperCase

Formater une chaîne tout en minuscule ou tout en majuscule.

```js
/*
    charAt(), []
    concat()
    startsWith(), endsWith()
    padStart(), padEnd()
    trim(), trimStart(), trimEnd()

    repeat()
    replace(), replaceAll()

    includes()
    indexOf()

    toLowerCase(), toUpperCase()
*/

let s = "Bonjour";

document.write(s.toLowerCase() + "<br>");
document.write(s.toUpperCase() + "<br>");
```
```
bonjour
BONJOUR
```

### substring et slice

Récupérer une sous-chaîne dans une chaîne

```js
/*
    charAt(), []
    concat()
    startsWith(), endsWith()
    padStart(), padEnd()
    trim(), trimStart(), trimEnd()

    repeat()
    replace(), replaceAll()
    substring(), slice()

    includes()
    indexOf()

    toLowerCase(), toUpperCase()
*/

let s = "Bonjour";

document.write(s.substring(1) + "<br>");
document.write(s.substring(3, 7) + "<br>"); // jour
document.write(s.slice(3, 7) + "<br>");
```
```
onjour
jour
jour
```

Avec substring(), la 1e valeur est inclue et la 2e est exclue.

slice() a le même comportement.

La différence c'est que substring inverse les deux éléments tandis que slice() retournera une chaîne vide avec les deux arguments inversés.

```js
let s = "Bonjour";

document.write(s.substring(7, 3) + "|<br>"); // jour
document.write(s.slice(7, 3) + "|<br>");
```
```
jour|
|
```

`substring(<end>, <start>)` accepte les arguments inversés.

### split

Méthode qui va spliter les éléments d'une chaîne dans un tableau.

```js
/*
    charAt(), []
    concat()
    startsWith(), endsWith()
    padStart(), padEnd()
    trim(), trimStart(), trimEnd()

    repeat()
    replace(), replaceAll()
    substring(), slice()

    includes()
    indexOf()

    toLowerCase(), toUpperCase()

    split()
*/

let s = "Salut à tous !";

let a = s.split(" ");

document.write(a);
```
```
Salut,à,tous,!
```

Ici on a un tableau de 4 éléments : `Salut,à,tous,!`.

On peut mettre une limite de split avec un nombre en second arguments `let a = s.split(" ", 2);` avec 2 pour récupérer que 2 éléments.

On peut utiliser d'autres séparateurs.

```js
let s = "123:456";

let a = s.split(":");

document.write(a);
```
```
123,456
```

Transition vers la prochaîne séance où on verra les tableaux donc plutôt pratique.

Ciao tout le monde