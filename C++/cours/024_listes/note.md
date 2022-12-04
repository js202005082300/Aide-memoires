# [24. Listes](https://www.youtube.com/watch?v=Piwp2SICKzE)

+ [Introduction](#Introduction)
+ [Fonctionnement d'une liste](#Fonctionnement-d-une-liste)
+ [Déclaration d'une liste](#Déclaration-d-une-liste)      
+ [Accès aux éléments](#Accès-aux-éléments)
+ [Taille de la liste et ses éléments](#Taille-de-la-liste-et-ses-éléments)
+ [Quel conteneur utiliser ?](#Quel-conteneur-utiliser)
+ [Parcours d'une liste](#Parcours-d-une-liste)
+ [Ajout d'éléments](#Ajout-d-éléments)
+ [Suppression d'éléments](#Suppression-d-éléments)
+ [Tri des éléments](#Tri-des-éléments)
+ [Conclusion](#Conclusion)

>

## Introduction
## Fonctionnement d une liste

Include notre list.

```cpp
#include <iostream>
#include <string>
#include <list>

int main()
{
    return 0;
}
```

## Déclaration d une liste

```cpp
#include <iostream>
#include <string>
#include <list>

int main()
{
    std::list<std::string> li{"arbre", "bateau"};
    
    return 0;
}
```

## Accès aux éléments

```cpp
#include <iostream>
#include <string>
#include <list>

int main()
{
    std::list<std::string> li{"arbre", "bateau"};

    std::cout << "Premier : " << li.front() << std::endl;
    std::cout << "Dernier : " << li.back() << std::endl;
    
    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe                           
Premier : arbre 
Dernier : bateau
```

## Taille de la liste et ses éléments

```cpp
#include <iostream>
#include <string>
#include <list>

int main()
{
    std::list<std::string> li{"arbre", "bateau"};

    std::cout << "Taille : " << li.size() << std::endl;

    if(li.empty())
        std::cout << "Liste vide" << std::endl;
    
    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Taille : 2
```

## Quel conteneur utiliser

Pour les données très rapidement, on utilise les tableaux car on est en accès direct. Pour les liste chaînées, il faut parcourir les éléments.

Pour les insertions, on préfère les listes car on peut le faire n'importe où.

## Parcours d une liste

La liste est un containeur itérable contrairement à la pile.

```cpp
#include <iostream>
#include <string>
#include <list>

int main()
{
    std::list<std::string> li{"arbre", "bateau"};

    for(const auto& element : li)
        std::cout << element << std::endl;
    
    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
arbre
bateau
```

## Ajout d éléments

```cpp
#include <iostream>
#include <string>
#include <list>

int main()
{
    std::list<std::string> li{"arbre", "bateau"};

    // for(const auto& element : li)
    //     std::cout << element << std::endl;

    li.push_back("castor");
    li.push_front("barrage");

    for(const auto& element : li)
        std::cout << element << std::endl;
    
    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
# arbre
# bateau 
barrage
arbre  
bateau 
castor 
```

## Suppression d éléments

```cpp
#include <iostream>
#include <string>
#include <list>

int main()
{
    std::list<std::string> li{"arbre", "bateau"};

    // for(const auto& element : li)
    //     std::cout << element << std::endl;

    li.push_back("castor");
    li.push_back("barrage");

    li.pop_front();
    li.pop_back();

    for(const auto& element : li)
        std::cout << element << std::endl;
    
    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
bateau
castor
```

## Tri des éléments

sort() tri lexicographiquement.

```cpp
#include <iostream>
#include <string>
#include <list>

int main()
{
    std::list<std::string> li{"arbre", "bateau", "castor", "baleine", "barbecue", "saucisse"};

    for(const auto& element : li)
        std::cout << element << std::endl;

    std::cout << "=======================" << std::endl;

    li.sort();

    for(const auto& element : li)
        std::cout << element << std::endl;
    
    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
arbre
bateau
castor
baleine
barbecue
saucisse
=======================
arbre
baleine
barbecue
bateau
castor
saucisse
```

reverse() trie de manière décroissante.

```cpp
#include <iostream>
#include <string>
#include <list>

int main()
{
    std::list<std::string> li{"arbre", "bateau", "castor", "baleine", "barbecue", "saucisse"};

    for(const auto& element : li)
        std::cout << element << std::endl;

    std::cout << "=======================" << std::endl;

    li.reverse();

    for(const auto& element : li)
        std::cout << element << std::endl;
    
    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
arbre
bateau
castor
baleine
barbecue
saucisse
=======================
saucisse
barbecue
baleine
castor
bateau
arbre
```

## Conclusion

Les méthodes vues :

```cpp
/*
    front(), back()
    size(), empty()
    push_front(), push_back(), insert()
    pop_front(), pop_back(), clear()
    sort(), reverse()
*/
```

Parmi les conteneurs : les tableaux (taille fixe ou dynamique), les chaînes de caractères, la pile, la liste puis la map et cetera.

Ciao