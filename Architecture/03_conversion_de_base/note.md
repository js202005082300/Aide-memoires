# [Conversion de base](https://www.youtube.com/watch?v=RdBNK43JK5c)

## Conversion de base

convertir un nombre d'une base M vers un nombre en base N (ex: binaire vers décimal)

## Quelques rappels

* binaire (base 2)
* octal (base 8)
* binaire (base 10)
* hexadécimal (base 16)

## Tableau d'equivalences

|          |    |    |    |    |    |    |    |    |    |    |    |    |    |    |    |    |
:-:        |:-: |:-: |:-: |:-: |:-: |:-: |:-: |:-: |:-: |:-: |:-: |:-: |:-: |:-: |:-: |:-: |
Décimal    |0   |1   |2   |3   |4   |5   |6   |7   |8   |9   |10  |11  |12  |13  |14  |15  |
Binaire    |0000|0001|0010|0011|0100|0101|0110|0111|1000|1001|1010|1011|1100|1101|1110|1111|
Octal      |0   |1   |2   |3   |4   |5   |6   |7   |10  |11  |12  |13  |14  |15  |16  |17  |
Hexadécimal|0   |1   |2   |3   |4   |5   |6   |7   |8   |9   |A   |B   |C   |D   |E   |F   |

> Par exemple : avec ce tableau, on sait rapidement convertir le nombre 12 octal en hexadécimale : A

## Numeration décimale

Base 10 : 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
Comptage : (0), 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
                1 (1re valeur), 2 (2e valeur) ... 11 (11e valeur) ...

## Dénombrement décimale

245 = 2 x 10^2 + 4 x 10^1 + 5 x 10^0
245 = 2 x 100  + 4 x 10   + 5 x 1
245 = 200      + 40       + 5

> vive la numération positionelle !

## Binaire vers décimal

1101 (2) = 1 x 2^3 + 1 x 2^2 + 0 x 2^1 + 1 x 2^0
1101 (2) = 1 x 8   + 1 x 4   + 0 x 2   + 1 x 1
1101 (2) = 8       + 4       + 0       + 1
1101 (2) = 13 (10)

## Octal vers décimal

644 (8) = 6 x 8^2 + 4 x 8^1 + 4 x 8^0
644 (8) = 6 x 64  + 4 x 8   + 4 x 1
644 (8) = 384     + 32      + 4
644 (8) = 420

## Hexadecimal vers décimal

B5 (16) = B x 16^1 + 5 x 16^0
B5 (16) = 11 x 16  + 5 x 1
B5 (16) = 176      + 5
B5 (16) = 181

## En résumé

1101 (2) = 1 x 2^3 + 1 x 2^2 + 0 x 2^1 + 1 x 2^0
644 (8) = 6 x 8^2 + 4 x 8^1 + 4 x 8^0
B5 (16) = B x 16^1 + 5 x 16^0
...
Nombre (b) => Nombre (10)

> Somme du produit des chiffres à leur poids

## Décimal vers binaire

> Par division successive de 2, on a : 13 (10) = 1101 (2) [Lecture à l'envers]

```
13 | 2
---+---
1  | 6 | 2
    ---+---
     0 | 3 | 2
        ---+---
         1 | 1 | 2  -> valeur de la base binaire
            ---+---
             1 | 0  -> On s'arrête quand le quotient final vaut zéro
             |
             --------> Modulo, reste de la division Euclidienne
```

## En application

181 (10) = B5 (16)
```
181 | 16
 ---+---
  5 | 11 | 16
      ---+---
       B |  0
```

13 (10) = 1101 (2)
```
13 | 2
---+---
 1 | 6 | 2
    ---+---
     0 | 3 | 2
        ---+---
         1 | 1 | 2
            ---+---
             1 | 0
```

420 (10) = 644 (16)
```
420 | 8
 ---+---
 4  | 52 | 8
      ---+---
       4 | 6 | 8
          ---+---
           6 | 0
```

## Finalement !

* Décimal vers une autre base "b".
(division "modulo" successives de "b")
* Base "b" vers décimal
(somme des produits des chiffres par leur poids) ---> c'est la valeur du nombre !

## Mais alors ?

> Convertir entre ces trois bases est plus pratiques !

        Binaire
        /     \
       /       \
      /         \
     /           \
Héxadécimal ---- Octal

## Le saviez-vous ?

__11 0111 1101 (2)
regroupement par 4 car 2^4=16
   3    7    D (16)

__1 101 111 101 (2)
regroupement par 3 car 2^3=8
  1   5   7   5 (8)

  > Du tableau d'équivalences, tu t'aideras !

## Maintenant, Oui !

* Cela marche aussi à l'envers
(ex: passer de l'hexadécimal au binaire)

* Si on veut passer de l'hexadécimal à l'octal, on peut passer par le binaire :
A5F (16) = 101001011111 (2) = 5137 (8)

## Aller plus loin ...

* Faire les divisions successives de 153 (10), que remarquez-vous ?
```
153 | 10
 ---+---
 3  | 15 | 10
      ---+---
       5 | 1 | 10
          ---+---
           1 | 0
```