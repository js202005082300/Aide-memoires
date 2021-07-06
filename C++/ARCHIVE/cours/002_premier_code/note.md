# [[ARCHIVE] C++ #2 - premier code](https://www.youtube.com/watch?v=hwZTgl7puU0&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=16)

## Code minimal

    - std       | bibiliothèque stanndard définis dans un espace de nom nommé
    - ::        | opérateur d'accès, de référence
    - cout      | permet d'afficher sur la console, sortie standard
    - <<        | opérateur de flux
    - std::endl | retour à la ligne (notion de tampon, flush)
        ou  std::cout << "Bonjour tout le monde" << "\n";
        ou  std::cout << "Bonjour tout le monde\n";

```cpp
#include <iostream>

/*
    C++11   : >= 4.8.1
    C++14   : >= 6.1
    C++17   : >= 7.0

    g++ -std=c++14 main.cpp -o prog
*/

int main()
{
    std::cout << "Bonjour tout le monde" << std::endl;
    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Bonjour tout le monde
```