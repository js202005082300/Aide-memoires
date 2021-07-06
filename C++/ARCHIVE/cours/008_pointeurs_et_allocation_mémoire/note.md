# [[ARCHIVE] C++ #8 - pointeurs et allocation mémoire](https://www.youtube.com/watch?v=k0hlWQKk7d8&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=22)

## Pointeurs

Initialiser un pointeur avec nullptr.
```cpp
int *pNumber = nullptr;
int *pNumber{nullptr};
```

Rappel du langage c :

```cpp
#include <iostream>

int main()
{
    int a = 16;
    int *pNumber{nullptr};

    pNumber = &a;

    std::cout << *pNumber << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog   
.\prog.exe                        
16
```

Tout ce qu'on a vu sur les pointeurs en langage c est parfaitement valable en c++.

## Allocation dynamique

malloc() et free() sont des syntaxes à ne plus à adopter en c++.

```cpp
#include <iostream>

int main()
{
    int *pNumber{new int{16}};

    std::cout << *pNumber << std::endl;

    delete pNumber;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog   
.\prog.exe                        
16
```

Pour le tableau.

```cpp
#include <iostream>

int main()
{
    int *pNumber{new int{16}};
    int *tab{new int[100]};

    std::cout << *pNumber << std::endl;

    delete [] tab;
    delete pNumber;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog   
.\prog.exe                        
16
```

`delete[] tab;` ou `delete [] tab;`.

Voilà pour un simple pointeur et pour un tableau de plusieurs valeurs. On remplace malloc() et free() par new et delete.

Ce système est obsolète pour des raisons d'oublis, en Java, on a la fameuse erreur **NullPointerException**. Par ailleurs la ressource peut ne pas être disponible, non initialisé. Puis l'erreur la plus connue, les fuites de mémoire lorsqu'on oubli le delete sans quoi les données restent sur la mémoire vive après l'arrêt du programme.

## Les pointeurs intelligents

Pour éviter les erreurs de programmation, c++ a introduit les pointeurs intélligents, les **smart pointers**.

auto_ptr est un ancien pointeur intélligent devenu obsolète. Aujourd'hui on a 3 types de pointeurs :
+ pointeur unique `unique_ptr`
Signifie qu'un seul propriétaire a accès à la ressource. Tant que ce pointeur utilise la ressource, ça fonctionne mais si le pointeur est détruit la ressource est libérée de la mémoire.
+ pointeur partagé `shared_ptr`
Plusieurs origines peuvent utiliser la ressource. Tant qu'il y a des pointeurs qui utilisent la ressources ça fonctionne sinon la ressource est libérée.
+ pointeur faible `weak_ptr`
Pointeur qui vérifie que la ressource existe et si c'est le cas, on va pouvoir en faire un pointeur partagé.

Dans la majorité des cas, on utilise `unique_ptr` car on aura le plus souvent un seul propriétaire ou dans le cas d'un design pattern avec un observateur (tel qu'on a vu en Python avec tkinter, le **pattern observer**).

Pour des ressources partagées on utilisera alors shared_ptr.

On utilise surtout `unique_ptr`, puis `shared_ptr` et dans des cas très spécifique `weak_ptr`.

### Pour un simple pointeur

On passe par la bibliothèque standard pour lui donner un type, entre chevron on lui donne le type.

```cpp
#include <iostream>
#include <memory>

int main()
{
    std::unique_ptr<int> pNumber{std::make_unique<int>(16)};

    std::cout << *pNumber << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog   
.\prog.exe   
16                     
```

On ne s'occupe pas de libérer la ressource sans problème de libération de mémoire. A la fin de la fonction main() le pointeur n'est pas seulement détruit mais ce qu'il pointait sera libéré de la mémoire.

Par contre si c'est des pointeurs partagés, il faut que tout les pointeurs soient détruit pour libérer la donnée.

On peut également raccourcir la syntaxe en utilisant le mot clé `auto`.

```cpp
#include <iostream>
#include <memory>

int main()
{
    auto pNumber{std::make_unique<int>(16)};

    std::cout << *pNumber << std::endl;

    return 0;
}
```

### Pour un tableau de 100 valeurs

```cpp
#include <iostream>
#include <memory>

int main()
{
    auto pNumber{std::make_unique<int[]>(100)};

    std::cout << *pNumber << std::endl;

    return 0;
}
```

C'est un pointeur intélligent donc le pointeur sera bien libéré de la mémoire à la fin de la fonction.

## Libérer un pointeur proprement

Quand on libère une ressource, ne pas seulement faire un free() ou le delete mais n'oubliez pas de refaire pointer le pointeur sur NULL en c ou en c++.

En c++, on écrit `ptr = nullptr;` ou `ptr = 0;`

```cpp
#include <iostream>
#include <memory>

int main()
{
    int *ptr{new int{16};

    delete ptr;
    ptr = nullptr;

    return 0;
}
```

## Pointeur partagé

Simplement remplacé unique_ptr par shared_ptr mais l'usage est différent

```cpp
#include <iostream>
#include <memory>

int main()
{
    std::shared_ptr<int> pNumber{std::make_shared<int>(16)};

    return 0;
}
```

On peut également passer par un pointeur sans problème.

```cpp
#include <iostream>
#include <memory>

int main()
{
    int a = 16;
    int *ptr;
    ptr = &a;
    std::shared_ptr<int> pNumber{std::make_shared<int>(ptr)}; //ou std::make_shared<int>(*ptr)

    return 0;
}
```

## Conversion de type de pointeur

release() sur le pointeur unique pour revenir à un pointeur brute et bien sûr ne pas oublier de le libérer.

C'est de la conversion pour repasser à un pointeur brute.

```cpp
#include <iostream>
#include <memory>

int main()
{
    auto ptr{std:make_unique<int>(16)};
    auto *pNumber = ptr.release();

    delete pNumber;
    pNumber = nullptr;


    return 0;
}
```

Cette syntaxe n'est pas recommandé, je recommande les pointeurs uniques et d'éviter les new/delete au possible.