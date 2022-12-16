# [26. Ensembles](https://www.youtube.com/watch?v=fhX4zHN-_gY)

+ [Introduction](#Introduction)
+ [Fonctionnement d'un ensemble](#Fonctionnement-d-un-ensemble)        
+ [Déclaration d'un ensemble](#Déclaration-d-un-ensemble)
+ [Parcours d'un ensemble](#Parcours-d-un-ensemble)
+ [Ajout et suppression d'éléments](#Ajout-et-suppression-d-éléments)  
+ [Taille d'un ensemble et éléments](#Taille-d-un-ensemble-et-éléments)
+ [Recherche d'élément](#Recherche-d-élément)
+ [Conclusion](#Conclusion)

>

## Introduction
## Fonctionnement d un ensemble

Regroupement de données uniques, pas de doublons.

Possibilité d'ensemble de type différents (nombre, chaîne).

Comme pour les cartes associatives, 2 cas : ordonné et non-ordonné.

On commence par `unordered_set` autrement un tri est effectué selon un hash calculé à partir de nos éléments mais ce ne sera pas forcément l'ordre auquel on s'attend.

Par contre l'avantage est le parcours et l'accès aux données plus optimisé.

## Déclaration d un ensemble
## Parcours d un ensemble

```cpp
#include <iostream>
#include <string>
#include <unordered_set>
// #include <set>

int main()
{
    std::unordered_set<int> s{1, 5, 3, -8};

    for(const auto& element : s)
        std::cout << element << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe            
-8
3 
5 
1 
```

Le hash de valeur -8 était inférieur et se retrouve au début.

Pas de distinction que ce soit ordonné ou pas, un tri est exécuté.

```cpp
#include <iostream>
#include <string>
#include <unordered_set>
#include <set>

int main()
{
    std::set<int> s{1, 5, 3, -8};

    for(const auto& element : s)
        std::cout << element << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe            
-8
3 
5 
1 
```

## Ajout et suppression d éléments

`set` permettra la conservation de l'ordre des éléments.

```cpp
#include <iostream>
#include <string>
#include <unordered_set>
#include <set>

/*
    insert(), erase(), clear()
*/

int main()
{
    std::set<int> s{1, 5, 3, -8};

    s.insert({9, 19, 99}); // ajout d'un ensemble de valeurs.
    s.insert(5); // sera ignoré car 5 existe déjà !

    for(const auto& element : s)
        std::cout << element << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
-8
1 
3 
5 
9 
19
99
```

## Taille d un ensemble et éléments

```cpp
#include <iostream>
#include <string>
#include <unordered_set>
#include <set>

/*
    insert(), erase(), clear()
    size(), empty()
*/

int main()
{
    std::set<int> s{1, 5, 3, -8};

    s.insert({9, 19, 99});

    std::cout << "Nombre d'elements : " << s.size() << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Nombre d'elements : 7
```

## Recherche d élément

`std::end` désigne la fin de notre ensemble car find() fonctionne comme itérateur, et s'il atteint la fin de l'ensemble c'est que l'élément n'as pas été trouvé.

```cpp
#include <iostream>
#include <string>
#include <unordered_set>
#include <set>

/*
    insert(), erase(), clear()
    size(), empty()
    find()
*/

int main()
{
    std::set<int> s{1, 5, 3, -8};

    s.insert({9, 19, 99});

    if(s.find(5) != std::end(s))
        std::cout << "Trouve !" << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Trouve !
```

contains() est plus rapide car l'avantage est d'avoir un booléen sans recourir à `std:end`

```cpp
#include <iostream>
#include <string>
#include <unordered_set>
#include <set>

/*
    insert(), erase(), clear()
    size(), empty()
    find(), contains()
*/

int main()
{
    std::set<int> s{1, 5, 3, -8};

    s.insert({9, 19, 99});

    if(s.contains(19))
        std::cout << "Trouve !" << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Trouve !
```

## Conclusion

On aurait pu aussi parler des tuples comme en Python, les n-tuples `std::tuple`

La liste `std::queue`, ensemble très proche de la liste.

Se documenter et voir d'autres structures et containneurs.

Á bientôt