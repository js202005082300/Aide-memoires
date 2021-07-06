# [[ARCHIVE] C++ #6 - fonctions](https://www.youtube.com/watch?v=KlsD_zFgFRk&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=20)

## Passage par valeur
```cpp
#include <iostream>

void change_variable(int n)
{
    n = 16;
}

int main()
{
    auto nb{1};
    std::cout << "Avant changement : " << nb << std::endl;
    change_variable(nb);
    std::cout << "Avant changement : " << nb << std::endl;
    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Avant changement : 1
Avant changement : 1
```

## Passage par adresse
```cpp
#include <iostream>

void change_variable(int &n)
{
    n = 16;
}

int main()
{
    auto nb{1};
    std::cout << "Avant changement : " << nb << std::endl;
    change_variable(nb);
    std::cout << "Avant changement : " << nb << std::endl;
    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Avant changement : 1
Avant changement : 16
```

Petite nouveauté avec le c++, le n de la signature de la fonction fait référence à notre variable dans le contexte de main().

:warning: ne pas faire de return de référence sur une variable locale sinon on perd l'intéret de passer par une référence.
```cpp
#include <iostream>

int change_variable(int &n)
{
    n = 16;
    return n;
}

int main()
{
    auto nb{1};
    std::cout << "Avant changement : " << nb << std::endl;
    n = change_variable(nb);
    std::cout << "Avant changement : " << nb << std::endl;
    return 0;
}
```

## Surcharge de fonction

Changer la méthode pour qu'elle accepte les nombres à virgule flottante.

```cpp
#include <iostream>

int sum(int a, int b)
{
    return a + b;
}

double sum(double a, double b)
{
    return a + b;
}

int main()
{
    auto nb1{16.6};
    auto nb2{4.1};

    std::cout << sum(nb1, nb2) << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
20.7
```

Le compilateur choisit la bonne fonction à utiliser.

## Les templates

Le template déduit le type.

```cpp
#include <iostream>

template<typename T>
T sum(T a, T b)
{
    return a + b;
}

int main()
{
    auto nb1{16.6};
    auto nb2{4.1};
    std::cout << sum(nb1, nb2) << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
20.7
```

On peut également chosir entre chevrons le type à utiliser `<int>`.

```cpp
#include <iostream>

template<typename T>
T sum(T a, T b)
{
    return a + b;
}

int main()
{
    auto nb1{16.6};
    auto nb2{4.1};
    std::cout << sum<int>(nb1, nb2) << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
20
```

Voilà la partie décimale est tronquée.

## Les fonctions Lambda

C'est une fonction sans nom et qu'on stocke dans une variable.

```cpp
#include <iostream>

/*
    [](auto a, auto b){return a + b;}
*/

int main()
{
    auto sum = [](auto a, auto b){return a + b;};
    std::cout << sum(14, 3) << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
17
```

On peut utiliser la fonction lambda comme paramètre de fonction.

```cpp
void maFonction(int a, [](auto b, auto c){})
{

}
```

Passer les variables par référence (on pourrais les modifier).

```cpp
#include <iostream>

/*
    FONCTION LAMBDA - CAPTURE

    [&] : toutes variables par référence
    [=] : toutes variables par valeur
*/

int main()
{
    auto nb1{2};
    auto nb2{3};
    
    auto sum = [&](auto a, auto b){return a + b + nb1 + nb2;};

    std::cout << sum(14, 3) << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
22
```

Passer les variables par valeurs.

```cpp
auto nb1{2};
auto nb2{3};

auto sum = [=](auto a, auto b){return a + b + nb1 + nb2;};
```

Passer une nb1 par valeur et nb2 par référence.

```cpp
auto sum = [nb1, &nb2](auto a, auto b){return a + b + nb1 + nb2;};
```

Passer une nb1 par valeur et toutes les autres par valeur.

```cpp
auto sum = [nb1, &](auto a, auto b){return a + b + nb1 + nb2;};
```

Passer nb2 par référence et tout le reste par valeur.

```cpp
auto sum = [&nb2, =](auto a, auto b){return a + b + nb1 + nb2;};
```

Voilà le & pour le passage par référence et le = (ou le nom de la variable) pour le passage par valeur

```cpp
/*
    FONCTION LAMBDA - CAPTURE

    [&] : toutes variables par référence
    [=] : toutes variables par valeur

    [var]   : "var" par valeur
    [&var]  : "var" par référence
*/
```

Utile pour les opération rapide avec une fonction à la volée.

:warning: le c++ est une extension du langage c mais le vrai c++ s'utilise avec des types déduit (auto, decltype et cetera)