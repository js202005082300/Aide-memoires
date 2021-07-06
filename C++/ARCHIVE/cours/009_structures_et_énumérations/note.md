# [[ARCHIVE] C++ #9 - structures et énumérations](https://www.youtube.com/watch?v=8F3MDdqcr5g&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=23)

On va les changements par rapport à c.

## struct est optionnel

Les champs d'une structure sont énumérés du plus gros au plus petit, les tableaux, les chaînes de caractères et les simple entier.

```cpp
#include <iostream>

struct Animal
{
    std::string name;
    int age;
};

int main()
{
    Animal a{"Panda", 2}; //ou struct Animal a{};

    std::cout << "Nom : " << a.name << std::endl;
    std::cout << "Age : " << a.age << std::endl;

    return 0;
}
```

En c++, le mot clé *struct*, *typedef* ne sont plus nécéssaires. 

```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Nom : Panda
Age : 2
```

## Créer une copie

```cpp
#include <iostream>

struct Animal
{
    std::string name;
    int age;
};

int main()
{
    Animal a{"Panda", 2};
    Animal aa{a};

    std::cout << "Nom : " << aa.name << std::endl;
    std::cout << "Age : " << aa.age << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Nom : Panda
Age : 2
```

Ce sont deux structures distinctes, si on change une valeur de `a`, ça ne change pas la valeur de `aa`.

## Créer un alias

En c, on utilise `typedef` et en c++, on utilise `using`.

```cpp
#include <iostream>

using Bete = struct Animal;

struct Animal
{
    std::string name;
    int age;
};

int main()
{
    Animal a{"Panda", 2};
    Bete aa{a};

    std::cout << "Nom : " << aa.name << std::endl;
    std::cout << "Age : " << aa.age << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Nom : Panda
Age : 2
```

`typedef` doit être oublié en c++.

## Enumération

```cpp
#include <iostream>

enum Polarity
{
    NEGATIVE, //0
    POSITIVE //1
};

struct Processor
{
    std::string model;
    Polarity p;
    int watts;
};

int main()
{
    Processor proc{"17 4770", Polarity::NEGATIVE, 120};

    if(proc.p == Polarity::NEGATIVE) //ou if(proc.p == 0)
        std::cout << "NEGATIF: " << proc.p << std::endl;
    else
        std::cout << "POSITIF: " << proc.p << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
NEGATIF: 0
```

Pour des raison de lisibilité, on emploi le nom complet avec l'opérateur de portée `Polarity::NEGATIVE` ou `Polarity::POSITIVE`.