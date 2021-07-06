# [Systèmes de numération](https://www.youtube.com/watch?v=GEW_PYZEdNU)  
> 20-01-21

## Numération?

    Ensemble de conventions pour représenter des nombres

## Dénombrement

* temps (secondes, jours, mois...)
* capacité d'un support informatique
* comptage indo-arable

## Usages Dénombrement

* 60 secondes = 1 minutes, 60 minutes = 1 heure
* 12 mois = 1 an, 100 ans = 1 siècle
* 1000 Ko = 1Mo, 1000 Mo = 1 Go

## Quelques bases...

* décimale (10)
* binaire (2)
* octale (8)
* hexadécimale(16)

## Base décimale

* 10 chiffres: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
* groupes: unité, dizaine, centaine, millier, ...

## Base binaire

* 2 chiffres: 0, 1
* groupes: unité, deuzaine, quatraine, ...

## Base octale

* 8 chiffres: 0, 1, 2, 3, 4, 5, 6, 7
* groupes: unité, huitaine, "soixante-quatraine"

## Base hexadécimale

* 16 chiffres: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F
* groupes: unité, seizaine, " deux-cent-cinquante-sizaine (puisque 16^2 = 256)", ...

## Mais comment?!

compter au-delà du chiffre maximum qu'une base dispose (ex: après 10 en décimal)?

## Numération de position

* décimal: passer de 9 à 10 (ou de 999 à 1000)
* binaire: passer de 1 à 10
* hexadécimale: passer de F à 10

## Des exemple?

    Décimal: 123

    3 - position 0 : 3 x 10^0
    2 - position 1 : 2 x 10^1
    1 - position 2 : 1 x 10^2

    10^0 = 1
    10^1 = 10
    10^2 = 100
    10^6 = 1 000 000
  
    3 x 1   =   3
    2 x 10  =  20
    1 x 100 = 100
            = 123

    Base décimale : 536
        6 est l'unité (position 0):        6x10^0 =   6
        3 est la dizaine (position 1):     3x10^1 =  30
        5 est la centaine (position 2):    5x10^2 = 500

    Donc:
        500 + 30 + 6 = 536
    
    Poids d'un chiffre:
                            10^0
                            10^1
                            10^2
        C'est la base, puissance de sa position.

## Ce qu'il faut retenir !

* chaque nombre d'une base est formée par ses puissance successives
* ajouter un 0 revient à multiplier un nombre par sa base
* poids d'un chiffre = base^position
* valeur d'un chiffre = chiffre x poids


:thinking: Quid ajouter un 0 revient à multiplier un nombre par sa base

    Décimale : 23
        230 (23 x 10)
    
    Binaire : 11
        110 (11 x 2)
        -> Pas cent-dix mais unité (0), deuzaine (1) et quatraine (1).

## Et en informatique

* bit (binary digit) en base 2
* groupement en mots (8, 16, 32, 64, ...)

* octet (byte) = 8 bits
* 1 octet peut avoir 256 valeurs (2^8)
        -> 255 sans le null.

## C'est déjà terminé!

\0/