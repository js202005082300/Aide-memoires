# [Calculs mathématiques](https://www.youtube.com/watch?v=uwLhuFd7ruA)

+ [ceil](#ceil)
+ [floor](#floor)
+ [sqrt](#sqrt)
+ [pow](#pow)
+ [fabs](#fabs)
+ [factorial](#factorial)
+ [exp](#exp)
+ [log](#log)
    + [log2](#log2)
    + [log10](#log10)
+ [sin](#sin)
+ [cos](#cos)
+ [tan](#tan)
+ [asin acos atan](#asin-acos-atan)
+ [radians](#radians)
+ [degrees](#degrees)
+ [isnan](#isnan)
+ [Attribut PI](#Attribut-PI)
+ [Attribut e](#Attribut-e)

Tutoriel pour aborder le module de mathématique mais il existe des modules plus spécifiques pour les nombres complexes.

`math` est le module standard et nous allons commencer par l'importer.

```py
#coding:utf-8
import math
```

Ou alors on peut l'importer en faisant `from math import *` avec l'étoile pour importer toutes les fonctions du modules ou alors on met les noms que l'on veut `from math import sqrt,...`. On fait comme on veut mais nous allons rester sur cette méthode `import math` comme ça on voit bien que ça provient de ce module-là.

On va créer un nombre et on va utiliser quelques-unes des fonctions standards, celles qu'on va retrouver le plus souvent.

```py
#coding:utf-8
import math

number = 14.6 
```

## ceil

Fonction qui permet d'obtenir l'entier supérieur d'un nombre.

Dans le module math, on utilise la fonction ceil() qui prend un entier, une valeur.

```py
#coding:utf-8
import math

number = 14.6 

print("Entier supérieur : {}".format(math.ceil(number)))
```

La fonction ceil() retourne généralement un flottant, un float, après si c'est une valeur entière, on peut éventuellement caster en integer, en entier donc attention au retour car ça peut retourner un flottant. Attention au retour et au type de la donnée que l'on a d'ailleurs on a la fonction type() qui permet de vérifier.

```powershell
> python main.py
Entier supérieur : 15
```

L'entier supérieur de 14,6 c'est 15.

## floor

On a l'inverse c'est-à-dire le plafond en dessous.

```py
#coding:utf-8
import math

number = 14.6 

print("Entier supérieur : {}".format(math.ceil(number)))
print("Entier supérieur : {}".format(math.floor(number)))
```
```powershell
> python main.py
Entier supérieur : 15
Entier supérieur : 14
```

Ici il ne garde que la partie entière du nombre (14).

Prenons un exemple d'application, admettons maintenant quand on développe un site web et que l'on fasse de la pagination sur un forum, sur un ensemble de news et que l'on veut paginer et que maintenant on décide d'afficher 5 news par page en admettant qu'on ai 6 news on va avoir une page qui en aura 5 et il faudra réserver une page qui n'aura qu'une seule news donc là ça peut être utile d'avoir cette fonction ceil() quand on a besoin de faire des arrondis supérieurs.

Voilà un exemple d'application quand on a besoin de faire des arrondis supérieurs, ou des arrondis inférieurs.

## sqrt

Fonction racine carré.

```py
#coding:utf-8
import math

number = 14.6 

print("Racine carré : {}".format(math.sqrt(number)))
```
```powershell
> python main.py
Racine carré : 3.82099463490856
```

La racine carré de 100, c'est évidemment 10.

```py
#coding:utf-8
import math

number = 100

print("Racine carré : {}".format(math.sqrt(number)))
```
```powershell
> python main.py
Racine carré : 10.0
```

Voilà ici on rentre une valeur entière et nous retourne un flottant alors que pour les fonctions de tout à l'heure ceil() et floar() retourne un entier.

Si on veut une partie entière, il faudra caster avec la fonction int() comme on l'a vu dans la formation.

## pow

Fonction de puissance.

```py
#coding:utf-8
import math

number = 10

print("Puissance : {}".format(math.pow(number, 3)))
```
```powershell
> python main.py
Puissance : 1000.0
```

Elle prend un nombre puis la puissance en second paramètre.

## fabs

Valeur absolue d'un nombre (c'est l'entier positif d'un nombre).

```py
#coding:utf-8
import math

number = 6

print("Valeur absolue : {}".format(math.fabs(number)))
```
```powershell
> python main.py
Valeur absolue : 6.0
```

Mais si on met -6.

```py
#coding:utf-8
import math

number = -6

print("Valeur absolue : {}".format(math.fabs(number)))
```
```powershell
> python main.py
Valeur absolue : 6.0
```

Ainsi la valeur absolue d'un nombre c'est toujours ce nombre mais positif.

## factorial

Factorielle d'un nombre.

```py
#coding:utf-8
import math

number = 4

print("Factorielle : {}".format(math.factorial(number)))
```
```powershell
> python main.py
Factorielle : 24
```

En résumé, la factorielle de 4 c'est 4*3*2*1.

```py
# 3! = 3 * 2 * 1
# 10! = 10 * 9 * 8 * ... * 1
```

Attention à la taille mémoire que ça peut prendre puisque plus le nombre est grand plus ça prend de la mémoire.

Par exemple avec factorielle de 400, ça fonctionne mais avec la limite atteinte, python affiche des 0 donc il y a une limite au niveau de la puissance du langage, de l'ordinateur donc on peut obtenir des nombres énormes avec les factorielles.

```py
#coding:utf-8
import math

number = 400

print("Factorielle : {}".format(math.factorial(number)))
```
```powershell
> python main.py
Factorielle : 64034522846623895262347970319503005850702583026002959458684445942802397169186831436278478647463264676294350575035856810848298162883517435228961988646802997937341654150838162426461942352307046244325015114448670890662773914918117331955996440709549671345290477020322434911210797593280795101545372667251627877890009349763765710326350331533965349868386831339352024373788157786791506311858702618270169819740062983025308591298346162272304558339520759611505302236086810433297255194852674432232438669948422404232599805551610635942376961399231917134063858996537970147827206606320217379472010321356624613809077942304597360699567595836096158715129913822286578579549361617654480453222007825818400848436415591229454275384803558374518022675900061399560145595206127211192918105032491008000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
```

## exp

Valeur exponentielle d'un nombre.

```py
#coding:utf-8
import math

number = 12

print("Exponentielle : {}".format(math.exp(number)))
```
```powershell
> python main.py
Exponentielle : 162754.79141900392
```

## log

Logarithme, opposé de l'exponentielle.

nb. On a également le logarithme népérien.

```py
#coding:utf-8
import math

number = 12

print("Exponentielle : {}".format(math.exp(number)))
print("Logarithme : {}".format(math.log(number)))
```
```powershell
> python main.py
Exponentielle : 162754.79141900392
Logarithme : 2.4849066497880004
```

Par défaut, log() prend quelque chose mais c'est mieux de préciser la base.

Par exemple le logarithme en base 2 ou en base 10.

```py
#coding:utf-8
import math

number = 12

print("Exponentielle : {}".format(math.exp(number)))
print("Logarithme : {}".format(math.log(number, 10)))
```
```powershell
> python main.py
Exponentielle : 162754.79141900392
Logarithme : 1.0791812460476247
```

### log2

Alors comme le logarithme en base 2 ou en base 10 est assez courant, il y a des fonctions pour calculer ces fonctions-là précissement.

Utiliser la fonction log2() plutôt que la fonction générique log() pour la base 2.

```py
#coding:utf-8
import math

number = 12

print("Logarithme : {}".format(math.log(number, 2)))
print("Logarithme : {}".format(math.log2(number)))
```
```powershell
> python main.py
Logarithme : 3.5849625007211565
Logarithme : 3.584962500721156
```

Ainsi on constatera que la fonction log2() fonctionera mieux que la fonction générique en base 2.

### log10

Idem pour log10() calculera mieux que la fonction générique log().

```py
#coding:utf-8
import math

number = 12

print("Logarithme : {}".format(math.log(number, 10)))
print("Logarithme : {}".format(math.log10(number)))
```
```powershell
> python main.py
Logarithme : 1.0791812460476247
Logarithme : 1.0791812460476249
```

## sin

Sinus d'un nombre renvoit une valeur en radian.

```py
#coding:utf-8
import math

number = 12

print("Sinus de number = {}".format(math.sin(number)))
```
```powershell
> python main.py
Sinus de number = -0.5365729180004349
```

## cos

Sinus d'un nombre renvoit une valeur en radian.

```py
#coding:utf-8
import math

number = 12

print("Cosinus de number = {}".format(math.cos(number)))
```
```powershell
> python main.py
Cosinus de number = 0.8438539587324921
```

## tan

Tangente d'un nombre.

```py
#coding:utf-8
import math

number = 12

print("Tangente de number = {}".format(math.tan(number)))
```
```powershell
> python main.py
Tangente de number = -0.6358599286615808
```

## asin acos atan

Arcsinus, arcconsinus et arctangente d'un nombre.

```py
#coding:utf-8
import math

number = 12

print("Arc tangente de number = {}".format(math.atan(number)))
```
```powershell
> python main.py
Arc tangente de number = 1.4876550949064553
```

## radians

Fonction pour convertir dégré en radian.

```py
#coding:utf-8
import math

nb_degree = 128

print("Degre -> Radian = {}".format(math.radians(nb_degree)))
```
```powershell
> python main.py
Degre -> Radian = 2.234021442552742
```

## degrees

Fonction pour convertir radian en degré.

```py
#coding:utf-8
import math

nb_rad = 2.234697

print("Radian -> Degré = {}".format(math.degrees(nb_rad)))
```
```powershell
> python main.py
Radian -> Degré = 128.03870659054652
```

## isnan

Vérifier que ce n'est pas un nombre. Attention *nan* pour *not a number* et on vérifie que ce n'est pas un nombre, le test est inversé.

```py
#coding:utf-8
import math

maVariable = "14"

print("Not a number ? {}".format(math.isnan(maVariable)))
```
```powershell
> python main.py
Traceback (most recent call last):
  File "C:\Users\sam\OneDrive\Bureau\main.py", line 6, in <module>
    print("Not a number ? {}".format(math.isnan(maVariable)))
TypeError: must be real number, not str
```

Si ça retourne false, c'est que c'est bien un nombre. Et si ça retourne true, c'est que c'est un nombre.

Cette fonction vérifie que ce n'est pas un nombre.

Ici ça retourne false parce que c'est un nombre.

```py
#coding:utf-8
import math

maVariable = 14

print("Not a number ? {}".format(math.isnan(maVariable)))
```
```powershell
> python main.py
Not a number ? False
```

Plutard, si on veut travailler avec des nombres complexes on utilise la bibliothèque cmath `import cmath`.

## Attribut PI

Utiliser de préférence les attributs disponibles pour avoir quelque chose d'assez précis.

```py
#coding:utf-8
import math

maVariable = 14

print("PI = {}".format(math.pi))
```
```powershell
> python main.py
PI = 3.141592653589793
```

## Attribut e

e, constante de la valeur de l'exponentiel.

```py
#coding:utf-8
import math

maVariable = 14

print("e = {}".format(math.e))
```
```powershell
> python main.py
e = 2.718281828459045
```