# [[ARCHIVE] C++ #7 - tableaux](https://www.youtube.com/watch?v=IhRBe5pwgG4&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=21)


## Déclaration
```cpp
#include <iostream>

#define SIZE_TAB 2

int main()
{
    int tab[2];
    int tab[SIZE_TAB];

    return 0;
}
```

On déclare avec une valeur en dur ou un define qui serra remplacé dans le code lors de l'étape de pre-processing.

## Initialiser et afficher

Afficher la première case de notre tab[].

```cpp
#include <iostream>

int main()
{
    int tab[2] = {1, 2};

    std::cout << tab[0] << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
1
```

:warning: on éviter de spécifier la taille d'un tableau en c avec une variable.

```cpp
#include <iostream>

int main()
{
    const int TAB_SIZE = 2;
    int tab[TAB_SIZE] = {1, 2};

    std::cout << tab[0] << std::endl;

    return 0;
}
```

On passe par une constante mais sans const, c'est pareil. Ici on ne passe pas par une macro.

Ainsi on peut le faire en c++ et après c'est pratique pour faire les parcours.

## Parcours et lecture

```cpp
#include <iostream>

int main()
{
    int tab[2] = {1, 2};

    for(int i{} ; i < 2 ; ++i)
        std::cout << tab[i] << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
1
2
```

En c pour manipuler un tableau dans une fonction, il faut le tableau et la taille du tableau sauf si bien sûr elle était enregistré dans une macro pour être accessible partout.

Depuis C++17, on a la possibilité d'utiliser size de la bibliothèque standard sur un simple tableau statique.

## La méthode size

`std::size()` est pris en charge à partir de c++17.

```cpp
#include <iostream>

int main()
{
    int tab[2] = {1, 2};

    std::cout << "Taille du tableau : " << std::size(tab) << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 main.cpp -o prog
.\prog.exe
Taille du tableau : 2
```

Idem on utilise cette méthode sans devoir passer par une valeur en dur, une macro ou une variable.

```cpp
#include <iostream>

int main()
{
    int tab[2] = {1, 2};

    for(int i{} ; i < std::size(tab) ; ++i)
        std::cout << tab[i] << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 main.cpp -o prog
.\prog.exe
1
2
```

Voilà c'est du c++ moderne en utilisant c++17 au lieu de c++14.