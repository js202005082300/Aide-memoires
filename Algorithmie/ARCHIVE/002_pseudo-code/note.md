# [[ARCHIVE] Algorithmie #2 - pseudo-code](https://www.youtube.com/watch?v=HwIkkngfjpU&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=2)

Les mots sont écrit en majuscule, pas d'accent, mots FR ou EN
```txt
PSEUDO-CODE
```

On commence par lui mettre un nom, un identifiant :
```txt
ALGORITHME tri
```
```txt
ALGORITHME tri_bulle
```

Puis on fonctionne avec des tabulations pour savoir qu'on est dans l'algorithme. On déclare nos variables, le mot clé DEBUT (ou BEGIN) puis le mot-clé FIN (ou END). On utilise toujours le mot-clé FIN pour les structures de contrôle même si c'est pas propre à tout les langages.

```txt
ALGORITHME <nom>
    <déclarations...>
DEBUT
    <instructions...>
FIN
```

Voilà pour la base.

## Affichage ou saisie

Utiliser le mot AFFICHER (ou PRINT).

```txt
AFFICHER("Bonjour")
AFFICHER("Tu as ", <variable>, " ans")
```

## Lecture d'une information

Lire une variable ou stocker dans une variable.

```txt
LIRE(<variable>)
<variable> <- LIRE("Quel âge as-tu ? ")
```

## Types de variable

Un booléen c'est `True` ou `False` avec une majuscule, ou `Vrai`ou `Faux`.

```txt
ENTIER, REEL, BOOLEEN, CARACTERE, CHAINE, <TYPE_PERSONNALISE>
```

Le type personnalisé si on crée une arme dans un jeu-vidéo ici entre chevrons pour être remplacé par n'importe quel type de variable ou de structure créé.

## Nommage

```txt
mavariable
ma_variable
MaVariable
_maVariable
```

Pas d'espace, de caractères spéciaux, juste chiffres et lettres te des underscores.

## Déclarer une variable

Le nom de variable suivi de `EST UN ENTIER` (ou `IS INTEGER`)

```txt
nombre EST UN ENTIER
PI EST UN REEL
pseudo EST UNE CHAINE
```

## Affecter ou modifier une valeur

Utiliser une flèche vers la gauche `<-`.

```txt
nombre <- 16
PI <- 3.14
pseudo <- "Chuck Norris"
```

## Déclarer et initialiser une variable

```txt
nombre EST UN ENTIER <- 16
age EST UN ENTIER <- 24
```

On met le type en majuscule pour différencier le type de la variable et savoir que 16 est mis dans nombre.

## Structure de contrôle

### Condition

```txt
age EST UN ENTIER <- 24

SI age > 18 ALORS
    AFFICHER("Tu est majeur")
SINON
    AFFICHER("TU es mineur")
FIN SI
```

```txt
nombre EST UN ENTIER <- 24

SI nombre < 0 ALORS
    AFFICHER("Plus petit que 0")
SINON SI nombre > 100 ALORS
    AFFICHER("Plus grand que 100")
SINON
    AFFICHER("Entre 0 et 100")
FIN SI
```

```txt
choixCalcul EST UN ENTIER <- 2

SELON choixCalcul
    1 : addition(nb1, nb2)
    2 : soustraction(nb1, nb2)
    3 : quitter_programme()
    AUTREMENT : AFFICHER("Commande inconnue")
FIN SELON
```

Switch avec plusieurs instructions.

```txt
choixCalcul EST UN ENTIER <- 2

SELON choixCalcul
    1 : 
        addition(nb1, nb2)
        addition(nb1, nb2)
    2 : 
        soustraction(nb1, nb2)
    3 : 
        quitter_programme()
    AUTREMENT :
        AFFICHER("Commande inconnue")
FIN SELON
```

### Boucles

#### While

```txt
i EST UN ENTIER <- 0

TANT QUE i < 10
    AFFICHER("i = ", i)
    i <- i + 1
FIN TANT QUE
```

#### Do while

```txt
i EST UN ENTIER <- 0

REPETER
    AFFICHER("i = ", i)
    i <- i + 1
TANT QUE i < 10
```

#### For

```txt
i EST UN ENTIER

POUR i ALLANT DE 0 A 10 [SAUT DE <pas>]
    AFFICHER("i = ", i)
FIN POUR
```

Avec un saut de 2 en 2.

```txt
i EST UN ENTIER

POUR i ALLANT DE 0 A 10 [SAUT DE 2]
    AFFICHER("i = ", i)
FIN POUR
```

Avec une décrémentation de -1 en -1.

```txt
i EST UN ENTIER

POUR i ALLANT DE 0 A 10 [SAUT DE -1]
    AFFICHER("i = ", i)
FIN POUR
```

Si on ne met rien, on considère que ça fait une incrémentation de 1.

```txt
i EST UN ENTIER

POUR i ALLANT DE 0 A 10
    AFFICHER("i = ", i)
FIN POUR
```

C'est ce que fait généralement le plus mois pour que ce soit plus clair, on met le pas.

## Fonction

On différencie procédure et fonction en algorithmie.

```txt
PROCEDURE addition(nb1, nb2)
    <declarations...>
    res EST UN ENTIER
DEBUT
    <instructions...>
    AFFICHER("res = ", res)
FIN
```

C'est une procédure parce qu'elle ne retourne pas de valeur autrement c'est une fonction.

```txt
FONCTION addition(nb1, nb2)
    <declarations...>
    res EST UN ENTIER
DEBUT
    <instructions...>
    RETOURNER res
FIN
```

Voilà on pourrais se demander comment représenter une classe en POO ? Encore une fois, un algorithme c'est un bout de code pour représenter un ensemble d'instructions, une fonction, méthode mais pas une classe parce qu'une classe c'est comme un gros bout de code.

Pour représenter une classe, on utilisera un système d'analyse (uml diagram, et cetera) qui serve à représenter des classes, des méthodes et cetera

## Tableau et liste

```txt
nombre EST UN ENTIER

tab_nombres EST UN TABLEAU D'ENTIERS
tab_nombres EST UN TABLEAU D'ENTIERS [14, 26, -133]

inventaire EST UNE LISTE
inventaire EST UNE LISTE D'ITEMS
inventaire EST UNE LISTE D'ITEMS ["épée", "potion de mana"]
inventaire <- "bouclier"

liste_joueurs EST UNE LISTE DE JOUEURS
```

On a pas vu de collections de tous les langages mais après c'est à vous de le développer de votre coté.

On créera une liste, on peut définir une liste d'ITEMS où ITEMS serait une structure de données que l'on a créé ou ça peut carrément être une classe.

Dans ce cas `JOUEURS` serait une structure ou une classe peu importe donc si le programmeur traduit en C, il créera une structure de joueurs, en C++ il y aurait plus d'intérêt à créer une classe joueurs donc il traduit l'algorithme ou le pseudo-code en fonction du langage pour lequel il veut produire cet algorithme. En C++, il peut en faire une structure, il n'est pas obligé d'en faire une classe. En python comme tout est objet, il en ferra une classe JOUEURS et une classe ITEMS.

En général, on restera sur du procédural en algorithmie, et on ne travaillera pas sur des objets mais si un jour on veux utilisé des types personnalisés comme JOUEURS et ITEMS, on peut le faire aussi mais maintenant si on veut implémenter, pré-remplir et ajouter dans une liste, on sera comment le gérer.
