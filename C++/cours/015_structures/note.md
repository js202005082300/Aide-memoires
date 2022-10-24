# [15. Structures](https://www.youtube.com/watch?v=G4VYMrejP70)

+ [Introduction](#Introduction)
+ [Qu'est-ce qu'une structure ?](#Qu-est-ce-qu-une-structure)
+ [Un code sans structures](#Un-code-sans-structures)
+ [Définition d'une structure](#Définition-d-une-structure)
+ [Utilisation de la structure définie](#Utilisation-de-la-structure-définie)
+ [Définition d'un alias](#Définition-d-un-alias)
+ [Conclusion](#Conclusion)

>

## Introduction

Regrouper un ensemble de données.

## Qu est-ce qu une structure

Agrégats de données de notre propre type tel que int et cetera.

Ces données seront public.

## Un code sans structures

Faire un inventaire, sans passer par un fichier, on passe par des variables mais ici les données sont dispercées.

```cpp
#include <iostream>

int main()
{
    std::string productName;
    float productPrice;
    bool productAvailable;

    return 0;
}
```

## Définition d une structure

En pratique les structures sont dans le fichier d'en-tête.

3 données membres de cette structure, terminée par un point virgule.

```cpp
#include <iostream>

struct Product
{
    std::string name;
    float price;
    bool available;
};

int main()
{

    return 0;
}
```

## Utilisation de la structure définie

```cpp
#include <iostream>

struct Product
{
    std::string name;
    float price;
    bool available;
};

int main()
{
    struct Product p{"Papier toilette", 1.29, true};

    std::cout << p.price << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
1.29
```

Voilà nous venons de définir un nouveau type de données avec lequel nous pouvons faire des implémentations et accéder aux variables grâce à l'opérateur `.`

## Définition d un alias

Utilisation de `Product` au lieu de `struct Product`.

```cpp
#include <iostream>

struct Product
{
    std::string name;
    float price;
    bool available;
};

int main()
{
    using Product = struct Product;

    Product p{"Papier toilette", 1.29, true};

    std::cout << "Prix : " << p.price << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Prix : 1.29
```

## Conclusion

Petite parenthèse pour préciser qu'une modification est possible.

```cpp
#include <iostream>

struct Product
{
    std::string name;
    float price;
    bool available;
};

int main()
{
    using Product = struct Product;

    Product p{"Papier toilette", 1.29, true};

    std::cout << "Prix : " << p.price << std::endl;

    p.price = 2.29f;

    std::cout << "Prix : " << p.price << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Prix : 1.29
Prix : 2.29
```

Vidéo courte pour expliquer que l'on peut créer un nouveau type de données en c++ avec la syntaxe `struct`, utiliser des alias `using` et les données sont accessible pour la lecture et l'écriture.

On peut s'en servir pour le passage de plusieurs données dans les fonctions, et pour éviter les copies à chaque fois, il faut utiliser le passage par référence.

A bientôt