# [27. Itérateurs](https://www.youtube.com/watch?v=fsNwdZL3XTY)

+ [Introduction](#Introduction)
+ [Qu'est-ce qu'un itérateur ?](#Qu-est-ce-qu-un-itérateur)
+ [Quel est leur utilité ?](#Quel-est-leur-utilité)
+ [Types d'itérateurs](#Types-d-itérateurs)
+ [Préparation du code d'exemple](#Préparation-du-code-d-exemple)
+ [Itérateur non constant](#Itérateur-non-constant)
+ [Itérateur constant](#Itérateur-constant)
+ [Itérateur déclaré constant](#Itérateur-déclaré-constant)
+ [Itérateur constant déclaré constant](#Itérateur-constant-déclaré-constant)
+ [Méthodes des itérateurs](#Méthodes-des-itérateurs)
+ [Opérateurs sur des itérateurs](#Opérateurs-sur-des-itérateurs)
+ [Parcours générique via un itérateur](#Parcours-générique-via-un-itérateur)
+ [D'autres opérateurs](#D-autres-opérateurs)
+ [Conclusion](#Conclusion)

>

## Introduction
## Qu est-ce qu un itérateur
## Quel est leur utilité

Objet qui permet d'itérer sur les élements d'un container tel un pointeur.

Générique pour tout les containeurs même une simple chaîne.

## Types d itérateurs

> [Types d'itérateurs](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/C%2B%2B/iterateurs.md)

Les entrées, sorties lorsqu'on travail avec des fichiers. Les itérateurs pour la lecture. Les opérateurs surchargés qui peuvent être utilisé avec leur itérateurs.

## Préparation du code d exemple

Test avec un itérateur standard (ni constant, ni non-constant)

Déférencer l'itérateur pour l'afficher.

```cpp
#include <iostream>
#include <string>
#include <vector>

int main()
{
    using namespace std::literals;
    std::string sentence{"Bonjour tout le monde"s};
    std::vector<int> vec{1, 2, 3, 4, 5};

    std::string::iterator it(std::begin(sentence));

    std::cout << *it << std::endl;
    std::cout << *it << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
B
B
```

Attention pas de déplacement du pointeur lorsqu'on réaffiche.

Modification des données :

```cpp
#include <iostream>
#include <string>
#include <vector>

int main()
{
    using namespace std::literals;
    std::string sentence{"Bonjour tout le monde"s};
    std::vector<int> vec{1, 2, 3, 4, 5};

    std::string::iterator it(std::begin(sentence));

    std::cout << *it << std::endl;
    *it = 'T';
    std::cout << *it << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
B
T
```

On peut faire ces modifications car c'est un itérateur qui n'est pas constant.

Point de vue d'un itérateur, on a les éléments à parcourir et ce sur quoi il pointe :
```cpp
std::string::iterator it(std::begin(sentence));
```

Déplacer l'itérateur à la fin de la chaîne, nous n'auront rien puisqu'on sera à la fin de la chaîne.
```cpp
it = std::end(sentence);
```

```cpp
#include <iostream>
#include <string>
#include <vector>

int main()
{
    using namespace std::literals;
    std::string sentence{"Bonjour tout le monde"s};
    std::vector<int> vec{1, 2, 3, 4, 5};

    std::string::iterator it(std::begin(sentence));

    std::cout << *it << std::endl;
    it = std::end(sentence);
    std::cout << *it << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
B

> 
```

## Itérateur non constant
## Itérateur constant

```cpp
std::string::const_iterator it(std::begin(sentence));
```

`const_iterator` signifie que les éléments parcourus seront en **lecture seule**.

Par exemple en Python, dans ce cas, on avait un itérateur en lecture seule et non modifible. Et pour permettre la modification, il fallait passer par la fonction range() avec un indice.

```py
s = "bonjour"

for letter in s:
    print(s)
```

```cpp
#include <iostream>
#include <string>
#include <vector>

int main()
{
    using namespace std::literals;
    std::string sentence{"Bonjour tout le monde"s};
    std::vector<int> vec{1, 2, 3, 4, 5};

    std::string::const_iterator it(std::begin(sentence));

    std::cout << *it << std::endl;
    *it = 'N';
    std::cout << *it << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
main.cpp: In function 'int main()':
main.cpp:14:9: error: assignment of read-only location 'it.__gnu_cxx::__normal_iterator<const char*, std::__cxx11::basic_string<char> >::operator*()'
   14 |     *it = 'N';
      |     ~~~~^~~~~
```


## Itérateur déclaré constant

On ne va pas pouvoir modifier la valeur d'une variable constante `const std::string::iterator it(std::begin(sentence));`

```cpp
#include <iostream>
#include <string>
#include <vector>

int main()
{
    using namespace std::literals;
    std::string sentence{"Bonjour tout le monde"s};
    std::vector<int> vec{1, 2, 3, 4, 5};

    const std::string::iterator it(std::begin(sentence));

    std::cout << *it << std::endl;
    *it = 'N';
    std::cout << *it << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
B
N 
```

C'est un itérateur déclaré constant, ainsi ce n'est pas un itérateur constant.

Avec un itérateur déclaré constant, on est pas autorisé à passé à l'élément suivant, pas autorisé à déplacer l'itérateur.

## Itérateur constant déclaré constant

Cumuler les deux syntaxes permet de ni déplacer l'itérateur lui-même, ni modifier les valeurs pointées par l'itérateur mais on peut les afficher.

```cpp
#include <iostream>
#include <string>
#include <vector>

int main()
{
    using namespace std::literals;
    std::string sentence{"Bonjour tout le monde"s};
    std::vector<int> vec{1, 2, 3, 4, 5};

    const std::string::iterator it(std::begin(sentence));

    std::cout << *it << std::endl;
    it = std::next(it);
    std::cout << *it << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
B
N 
```

Pour rappel,

```cpp
/*
    <iterator>  : on peut déplacer le curseur, on peut modifier les éléments
    const <iterator>    : on peut modifier les éléments (du conteneur)
    <const_iterator>    : on peut déplacer le curseur
    const <const_iterator>  : /
*/
```

## Méthodes des itérateurs

```cpp
/*
    vec.begin(), end()
    cbegin(), cend()
*/
```

begin() et end() place l'itérateur au début ou à la fin du containeur.

cbegin() ou cend() crée un itérateur constant au début ou à la fin du containeur. Garantie que l'itérateur est constant même si le containeur n'est pas déclaré `const`, ainsi l'itérateur ne pourra pas modifier.

```cpp
std::string sentence{"Bonjour tout le monde"s};
std::vector<int> vec{1, 2, 3, 4, 5};

const std::string::iterator it(std::cbegin(sentence));
```

Travailler le plus générique possible avec la bibliothèque standard,

```cpp
/*
    std::begin(), std::cbegin()
    std::end(), std::cend()

    std::next()     // déplace l'itérateur sur l'élément suivant
    std::prev()

    std::rbegin(), std::rend()   // déplace de la fin vers le début (à l'envers)
*/
```

## Opérateurs sur des itérateurs

Par exemple next() sert à incrémenter l'itérateur.

> [Types d'itérateurs](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/C%2B%2B/iterateurs.md)

```cpp
#include <iostream>
#include <string>
#include <vector>

int main()
{
    std::vector<int> vec{1, 2, 3, 4, 5};
    std::vector<int>::iterator it(std::begin(vec));
    // En pratique, on met le mot auto : auto it(std::begin(vec));

    std::cout << *it << std::endl;
    it = std::next(it);
    std::cout << *it << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
1
2 
```

## Parcours générique via un itérateur

```cpp
#include <iostream>
#include <string>
#include <vector>

int main()
{
    std::vector<int> vec{1, 2, 3, 4, 5};

    for(auto it = std::begin(vec) ; it != std::end(vec) ; it = std::next(it)) // méthode surchargeable : it = std::next(it) devient it++
        std::cout << *it << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
1
2 
3 
4 
5 
```

Ici on travaille le plus génériquement possible donc on va pouvoir itérer sur des chaînes.

```cpp
#include <iostream>
#include <string>
#include <vector>

int main()
{
    // std::vector<int> vec{1, 2, 3, 4, 5};
    std::string vec{"Bonjour"};

    for(auto it = std::begin(vec) ; it != std::end(vec) ; it = std::next(it))
        std::cout << *it << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
B
o
n
j
o
u
r
```

Plus de généricité au niveau de notre code.

## D autres opérateurs

On peut utiliser `++` au lieu de next()

```cpp
#include <iostream>
#include <string>
#include <vector>

int main()
{
    std::vector<int> vec{1, 2, 3, 4, 5};
    auto it(std::begin(vec));

    std::cout << *it << std::endl;
    it++; // it = std::next(it);
    std::cout << *it << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
1
2 
```

Attention certains opérateurs ne fonctionnent pas avec tous les types d'itérateurs.

## Conclusion

Plusieurs types d'itérateurs :

> [Types d'itérateurs](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/C%2B%2B/iterateurs.md)

Et des méthodes pour déplacer l'itérateurs.

Attention à la compatibilité des itérateurs avec les types de données.

On parlera de la surcharge des opérateurs.

On parlera de la généricité avec les modèles (template).

On vera avec des bibliothèques externes.

Á bientôt tout le monde