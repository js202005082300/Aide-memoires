Expression rationnelle -> Regular expression (regex)

Normes : POSIX, PCRE (Perl), ECMAScript, etc.

> ------------------------------------------------------------

str = "Hello World"
pattern = ""

pattern/regex -> fonction (match, search, find) -> str

```txt
str = "Hello World"
pattern = "Hello"
```

Recherche globale, match à la 1e occurence ou à chaque occurence

```txt
str = "aaaaaaaaaaaaaaa"
pattern = "a"
```

H différent de h, pas de match

```txt
str = "Hello World"
pattern = "hello"
```

## ^ métacharactère pour dire de chercher au début de la chaîne

```txt
str = "Hello World Hello World"
pattern = "^Hello"
```

## $ métacharactère pour dire de chercher en fin de la chaîne

```txt
str = "Hello World Hello World"
pattern = "Hello$"
```

## $ avec un charactère d'échappement pour chercher exactement 25$

```txt
str = "25$"
pattern = "^25\$$"
```

## Un ou l'autre

```txt
str =   "mama"
        "papa"
pattern = "papa|mama"
```

```txt
str =   "mama"
        "papa"
pattern = "^(p|m)a(p|m)a$"
```

`^` début de chaîne
´$` fin de chaîne
si "mama ", pas de match

```txt
str =   "fe     mama"
        "   papa    "
pattern = "(p|m)a(p|m)a"
```

## Capturer deux cas avec le metacharactère (|)

```txt
str = "hello everyone"
      "hello world"
pattern = "^hello (everyone|world)$"
```

## Les quantificateurs

Quantificateurs : 
    ? (0 ou 1 fois)
    * (0 ou plusieurs fois)
    + (1 ou plusieurs fois)
    {N} N fois
    {N,} au moins N fois
    {N, M} entre N et M fois
Métacaractères, séquences :
    . tout caractère, sauf \n
    \t


Capturer toutes les chaînes suivantes

```txt
str = "R"
      "Rr"
      "RRRrrr"
      "rrrr"
pattern = "(R|r)+"
```

Recherche 'r' 4 fois

```txt
str = "R"
      "Rr"
      "RRRrrr"
      "rrrr"
pattern = "^r{4}$"
```

Capturer les 3 chaînes

```txt
str = "hello everyone hello world hello all"
      "hello everyone"
      "hello all hello all"
pattern = "(hello (everyone|world|al))+"
```

`+` car le groupement est répété

## Les délimiteurs

Ni une lettre, ni un chiffre (caractères alphanumériques) mais il faut que ce soit le même `<...>`, `/.../`

```txt
pattern = "/(.*)/"
pattern = "<(.*)>"
```

En langage V, seul 3 délimiteurs fonctionnent ($, /, #)

## Les classes de caractères

`[...]`

Capturer n'importe quel mot

```txt
str = "bonjour"
pattern = "[a-zA-Z]"
```

`[a-z]`, `[a-zA-Z]`,`[0-9]`

Tout sauf des chiffres `[^0-9]` avec `^` pour la négation

```

Classe ASCI de ce que l'on recherche

Capturer une lettre qui commence par une tabulation

```txt
str = "     bonjour"
pattern = "^[\ta-z]$"
```

Capturer un ou plusieurs caractères alphanumériques

```txt
str = "     bonjour"
pattern = "[a-zA-Z0-9]+"
```

`"[a-zA-Z0-9]+"` correspond à noter, au minimum 1 `"[a-zA-Z0-9]{1,}"`

Dans certaines normes (Posix), on a des classes toutes faites :

Classes : 
    `[:alpha:]`     càd tout ce qui est alphabétique et correspond à `[a-zA-Z]` avec `+` pour en prendre plusieurs.
    `[:alnum:]`  pour l'alphanumérique
    `[:digit:]`     pour les chiffres
    `[:xdigit:]`    pour les hexadécimales (0->F)
    `[:space:]`     pour les caractères d'espacement

## Les caractères d'échapement

`\w` correspond à `[:alnum:]`correspond à `"[a-zA-Z0-9]"`

On utilise les crochets, pas forcément obligatoire.

```txt
str = "     bonjour"
pattern = "[\w]"
```

Si on veut tout ce qui n'est pas alphanumérique c'est une majuscule `\W`

```txt
pattern = "\W"
```

Tout ce qui est chiifre `\d` et tout ce qui ne l'est pas `\D`

/!\ les notations ne peuvent pas forcément avoir la même signification d'un langage à l'autre.

## Options de recherches

Exemple en PHP,

i : insensible à case
```php
$pattern = '#^[a-zA-Z0-9]+#i'
```
m : multiligne
s : pour que le point `.` trouve aussi le `\n`
```php
$pattern = '#(.*)#ms'
$pattern = '#(.*)#is'
```
On peut cumuler les options
u : traitement unicode (en en parle pas)
g : traitement global pour éviter de s'arrêter au 1e résultat trouvé pour recherche complète

## Remplacer Markdown en html

Utilisation de l'option `u`

```txt
str = "**Bonjour** à tous et bienvenue"
pattern = ''
```

```txt
str = "<p>Bonjour,la réunion <strong>est bientôt</strong>, ne la <strong>manquez</strong> pas!</p>"
pattern = ''
```

## Conclusion

L'ensemble des métacharactères avec des exemples notament pour Posix

+ [Expressions rationnelles](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/Aide/expressions-rationnelles.md)

+ [Convertisseur en Regex](https://regex101.com/)