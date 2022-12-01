# [21. Tableaux](https://www.youtube.com/watch?v=051vzqDvx9A)

+ [Introduction](#Introduction)
+ [Qu'est-ce qu'un conteneur ?](#Qu-est-ce-qu-un-conteneur)  
+ [Tableau de taille fixe](#Tableau-de-taille-fixe)
+ [Méthode de classe et fonction libre](#Méthode-de-classe-et-fonction-libre)
+ [Tableau de taille dynamique](#Tableau-de-taille-dynamique)
+ [Ajout et suppression d'éléments](#Ajout-et-suppression-d-éléments)
+ [Copie d'un tableau](#Copie-d-un-tableau)
+ [Polymorphisme avec les conteneurs](#Polymorphisme-avec-les-conteneurs)
+ [Conclusion](#Conclusion)

>

## Introduction

Structure de données.

## Qu est-ce qu un conteneur

Implémentation de structures de données.

Stocker données de plusieurs types différents.

## Tableau de taille fixe

```cpp
#include <iostream>
#include <string>
#include <array>

int main()
{
    std::array<int, 5> arr{};

    for(const auto& element : arr)
        std::cout << element << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
0
0
0
0
0
```

Les valeurs sont intialisées par défaut à 0.

Pas d'ajout ou suppression possible, taille de 5 fixe.

Modification :

```cpp
#include <iostream>
#include <string>
#include <array>

int main()
{
    std::array<int, 5> arr{1, 2, 3, 4, 5};

    std::cout << arr[0] << std::endl;
    arr[0] = 10;
    std::cout << arr[0] << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
1
10
```

## Méthode de classe et fonction libre

### fill
```cpp
#include <iostream>
#include <string>
#include <array>

/*
    std::array : fill()
*/

int main()
{
    std::array<int, 5> arr{1, 2, 3, 4, 5};

    for(const auto& element : arr)
        std::cout << element << std::endl;

    arr.fill(2);

    for(const auto& element : arr)
        std::cout << element << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
1
2
3
4
5
2
2
2
2
2
```

### at
```cpp
#include <iostream>
#include <string>
#include <array>

/*
    std::array : fill()

    at()
*/

int main()
{
    std::array<int, 5> arr{1, 2, 3, 4, 5};

    std::cout << arr[2] << std::endl;
    std::cout << arr.at(2) << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
3
3
```

Boucle For :

```cpp
#include <iostream>
#include <string>
#include <array>

int main()
{
    std::array<int, 5> arr{1, 2, 3, 4, 5};

    for(auto i{0} ; i < 5 ; ++i)
        std::cout << arr[i] << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
1
2 
3 
4 
5 
```

### size
```cpp
#include <iostream>
#include <string>
#include <array>

/*
    std::array : fill()

    at()

    size()
*/

int main()
{
    std::array<int, 5> arr{1, 2, 3, 4, 5};

    for(size_t i{0} ; i < arr.size() ; ++i)
        std::cout << arr[i] << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
1
2 
3 
4 
5 
```

Écritures différentes :

```cpp
#include <iostream>
#include <string>
#include <array>

/*
    std::array : fill()

    at(), size()
    
    -------------------------

    std::size()
*/

int main()
{
    std::array<int, 5> arr{1, 2, 3, 4, 5};

    std::cout << "Taille : " << arr.size() << std::endl; // size() est une méthode de cette classe std::array
    std::cout << "Taille : " << std::size(arr) << std::endl; // fonction libre issue de la biblio standard

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Taille : 5
Taille : 5
```

Principe de polymorphisme entre méthode size().

Fonction libre `std::size()` compatible avec plus de choses. On prend le code le plus générique possible.

### empty

Utiliser la fonction libre, plus globale (méthodes de la classe VS. méthode de la biblio standard)

```cpp
#include <iostream>
#include <string>
#include <array>

/*
    std::array : fill()

    at(), size(), empty
    
    -------------------------

    std::size(), std::empty()
*/

int main()
{
    std::array<int, 5> arr{1, 2, 3, 4, 5};

    if(std::empty(arr))
        std::cout << "Oui" << std::endl;
    else
        std::cout << "Non" << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Non
```

Rappel sur la signature d'une méthode de classe :

+ someone.hpp
```cpp
#ifndef __SOMEONE__
    #define __SOMEONE__
    #include <string>

    class Someone // abstraite
    {
        public:
            Someone() = delete;
            Someone(const std::string& name) noexcept;
            virtual void sayGoodNight() const noexcept = 0;

            size_ size() // Méthode de classe

        protected:
            std::string _name;
    };

#endif
```

### front et back
```cpp
#include <iostream>
#include <string>
#include <array>

/*
    std::array : fill()

    at(), size(), empty
    front(), back()
    
    -------------------------

    std::size(), std::empty()
*/

int main()
{
    std::array<int, 5> arr{1, 2, 3, 4, 5};

    std::cout << arr.front() << std::endl;
    std::cout << arr.back() << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
1
5 
```

## Tableau de taille dynamique

Nécessite la biblio Vector.

Initialise sans valeur.
```cpp
#include <iostream>
#include <string>
#include <array>
#include <vector>

/*
    std::array : fill()

    at(), size(), empty
    front(), back()
    
    -------------------------

    std::size(), std::empty()
*/

int main()
{
    std::vector<std::string> arr{}; // conteneur

    if(std::empty(arr))
        std::cout << "Tableaux vide." << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Tableaux vide.
```

## Ajout et suppression d éléments

```cpp
#include <iostream>
#include <string>
#include <array>
#include <vector>

/*
    std::array : fill()

    std::vector : push_back(), pop_back()

    at(), size(), empty
    front(), back()
    
    -------------------------

    std::size(), std::empty()
*/

int main()
{
    std::vector<std::string> arr{};

    arr.push_back("Bonjour");
    arr.pop_back();

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
```

## Copie d un tableau

```cpp
#include <iostream>
#include <string>
#include <array>
#include <vector>

/*
    std::array : fill()

    std::vector : push_back(), pop_back()

    at(), size(), empty
    front(), back()
    
    -------------------------

    std::size(), std::empty()
*/

int main()
{
    std::vector<std::string> arr{};
    arr.push_back("Bonjour");

    std::vector<std::string> copy{arr};

    // avec l'opérateur d'affectation :

    std::vector<std::string> copy{};
    copy = arr;

    return 0;
}
```
```ps1
```

### clear

Repasser la taille du tableau à 0

```cpp
#include <iostream>
#include <string>
#include <array>
#include <vector>

/*
    std::array : fill()

    std::vector : push_back(), pop_back()

    at(), size(), empty
    front(), back()
    
    -------------------------

    std::size(), std::empty()
*/

int main()
{
    std::vector<std::string> arr{};
    arr.clear();

    return 0;
}
```
```ps1
```

## Polymorphisme avec les conteneurs

Tableau de personnes qui parlent anglais

```cpp
#include "polymorphisme/someone.hpp"
#include "polymorphisme/english.hpp"
#include "polymorphisme/indonesian.hpp"
#include <iostream>
#include <string>
#include <array>
#include <vector>

int main()
{
    English en1{"Rick"};
    English en2{"Morty"};

    std::vector<English> people{};

    people.push_back(en1);
    people.push_back(en2);

    for(const auto& p : people)
        std::cout << p.sayGoodNight() << std::endl;

    return 0;
}
```
```ps1
```

/!\ pour construire une liste, il faut passer par Someone mais comme il s'agit d'une classe abstraire (= au moins une méthode virtuelle pure) donc ça ne fonctionne pas.

Alors ici les codes ne fonctionnent pas car on ne peut plus instancier une classe abstraite.

```cpp
#include "polymorphisme/someone.hpp"
#include "polymorphisme/english.hpp"
#include "polymorphisme/indonesian.hpp"
#include <iostream>
#include <string>
#include <array>
#include <vector>

/*
    On ne peut instancier une classe Someone mais on peut dans d'autres languages :

        Someone s = new Indonesian("Bunda");

    ... car Indonesian est une sorte de Someone.
*/

int main()
{
    English en1{"Rick"};
    English en2{"Morty"};
    Indonesian in{"Bude"};

    std::vector<Someone> people{}; // On ne peut stocker des élément d'une classe abstraite.

    people.push_back(en1);
    people.push_back(en2);
    people.push_back(in);


    return 0;
}
```

**Le problème sera résolu avec un tableau de pointeurs vers des objets d'une classe abstraite au lieu d'un tableau d'objets.**

## Conclusion

Dans la prochaine vidéo, les chaînes de caractères `std::string`

A bientôt