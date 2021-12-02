# [Liste en compréhension](https://www.youtube.com/watch?v=Vf9Wwa1CGgk)

Liste en compréhension a pour but de créer une liste de façon plus rapide et concise mais risque de perdre en lisibilité.

## Créer une liste simple
```py
li = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(li)

for el in li:
    print(el)
```
```powershell
[1, 2, 3, 4, 5, 6, 7, 8, 9] 
1
2
3
4
5
6
7
8
9
```

## idem en liste de compréhension

Condenser cette expression de boucle for :
```py
"""
    [<expression> for <value> in <list>]
"""
li = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    [print(el) for el in li] # format d'une compréhension de liste
```
```powershell
1
2
3
4
5
6
7
8
9
```

## Copie de liste
```py
li = [1, 2, 3, 4, 5, 6, 7, 8, 9]
nli = []

for el in li:
    nli.append(el)

print(li)
print(nli)
```
```powershell
[1, 2, 3, 4, 5, 6, 7, 8, 9] 
[1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## idem en liste de compréhension
```py
li = [1, 2, 3, 4, 5, 6, 7, 8, 9]

nli = [el for el in li] # Plus besoin de faire appel à append

print(li)
print(nli)
```
```powershell
[1, 2, 3, 4, 5, 6, 7, 8, 9]
[1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## idem en incrémentant chaque élément de la liste
```py
li = [1, 2, 3, 4, 5, 6, 7, 8, 9]

nli = [el + 1 for el in li] # Plus besoin de faire appel à append

print(li)
print(nli)
```
```powershell
[1, 2, 3, 4, 5, 6, 7, 8, 9]
[2, 3, 4, 5, 6, 7, 8, 9, 10]
```

## Les conditions
### Copier les élements pairs de ma liste
```py
"""
    [<expression> for <value> in <list>]
    [<expression> for <value> in <list> if <conditions>]
"""
li = [1, 2, 3, 4, 5, 6, 7, 8, 9]
nli = [el for el in li if el % 2 == 0]

print(li)
print(nli)
```
```powershell
[1, 2, 3, 4, 5, 6, 7, 8, 9]
[2, 4, 6, 8]
```

### Accumuler les conditions if (au lieu de AND)
```py
"""
    [<expression> for <value> in <list>]
    [<expression> for <value> in <list> if <conditions>]
    [<expression> for <value> in <list> if <conditions> if <conditions> ...]
"""
li = [1, 2, 3, 4, 5, 6, 7, 8, 9]
nli = [el for el in li if el % 2 == 0 if el > 4]

print(li)
print(nli)
```
```powershell
[1, 2, 3, 4, 5, 6, 7, 8, 9]
[6, 8]
```

### Remplacer tels éléments à tels conditions (pair)
```py
li = [1, 2, 3, 4, 5, 6, 7, 8, 9]
nli = [True if el % 2 == 0 else False for el in li]

print(li)
print(nli)
```
```powershell
[1, 2, 3, 4, 5, 6, 7, 8, 9]
[False, True, False, True, False, True, False, True, False]
```

### Idem mais en remplacant par une chaîne (au lieu d'un booléen)
```py
li = [1, 2, 3, 4, 5, 6, 7, 8, 9]
nli = ["o" if el % 2 == 0 else "n" for el in li]

print(li)
print(nli)
```
```powershell
[1, 2, 3, 4, 5, 6, 7, 8, 9]
['n', 'o', 'n', 'o', 'n', 'o', 'n', 'o', 'n']
```

## Imbriquer une liste en compréhension dans une liste en compréhension

### Intégrer les sous-listes dans une seule liste
```py
dli = [
    [1, 2, 3, 4],
    [10, 20, 30, 40],
    [100, 200, 300, 400]
]

ndli = []

for subli in dli:
    for el in subli:
        ndli.append(el)

print(dli) # afficher une liste de liste
print(ndli)
```
```powershell
[[1, 2, 3, 4], [10, 20, 30, 40], [100, 200, 300, 400]]
[1, 2, 3, 4, 10, 20, 30, 40, 100, 200, 300, 400]
```
### Idem avec une liste en compréhension
```py
dli = [
    [1, 2, 3, 4],
    [10, 20, 30, 40],
    [100, 200, 300, 400]
]

# élément pour chaque élément de sous-liste de ma liste : el for subli in dli ...
# ... for el in subli : ... pour chaque élément de la sous-liste.
ndli = [el for subli in dli for el in subli]

print(dli) # afficher une liste de liste
print(ndli)
```
```powershell
[[1, 2, 3, 4], [10, 20, 30, 40], [100, 200, 300, 400]]
[1, 2, 3, 4, 10, 20, 30, 40, 100, 200, 300, 400]
```

Voilà une seule instruction pas forcément moins lisible tandis qu'ici en liste de compréhension, il faut un peu plus réflechir.

Notez qu'une liste en compréhension est représenté par des crochets et qu'on peut retrouver cette syntaxe :

    [ [] for <value> in <list> ]

Voilà, à bientôt