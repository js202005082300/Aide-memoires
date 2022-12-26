# [28. Algorithmes](https://www.youtube.com/watch?v=2JwLAZuZ5Pw)

+ [Introduction](#Introduction)
+ [Remplissage de valeur](#Remplissage-de-valeur)
+ [Égalité de deux collections](#Égalité-de-deux-collections)       
+ [Recherche de données](#Recherche-de-données)
+ [Nombre d'occurrences](#Nombre-d-occurrences)
+ [Tri d'éléments](#Tri-d-éléments)
+ [Remplacement d'éléments](#Remplacement-d-éléments)
+ [Suppression d'éléments](#Suppression-d-éléments)
+ [Inversion de valeurs](#Inversion-de-valeurs)
+ [Traitement sur des éléments](#Traitement-sur-des-éléments)
+ [Conclusion](#Conclusion)

>

## Introduction

Utilisation des algorithmes dans la bibliothèque C++, beaucoup utilisent les itérateurs vues précédemment.

Les algorithmes permettent d'avoir le code le plus générique possible.

Ils permettent aussi de travailler sur différents types de données.

## Remplissage de valeur

Avec fill(), on choisit la fourchette avec un itérateur sur le début de la collection et la fin, et on remplit avec des 0.

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/*
    std::fill()
*/

int main()
{
    std::vector<int> vec{1, 2, 3, 4, 5};

    for(const auto& e : vec)
        std::cout << e << std::endl;
    
    std::fill(std::begin(vec), std::end(vec), 0);

    for(const auto& e : vec)
        std::cout << e << std::endl;
    
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
0
0
0
0
0
```

C'est générique, on remplit une collection ou une chaîne en se servant des itérateurs.

## Égalité de deux collections

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/*
    std::fill()
    std::equal()
*/

int main()
{
    std::vector<int> vec_one{1, 2, 3, 4, 5};
    std::vector<int> vec_two{1, 2, 3, 4, 5};
   
    if(std::equal(std::begin(vec_one), std::end(vec_one), std::begin(vec_two), std::end(vec_two)))
        std::cout << "Oui !" << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Oui !
```

## Recherche de données

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/*
    std::fill()
    std::equal()
    std::find()
*/

int main()
{
    std::vector<int> vec{1, 2, 3, 4, 5};

    auto begin = std::begin(vec);
    auto end = std::end(vec);

    if(std::find(begin, end, 3) != end)
        std::cout << "Oui !" << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Oui !
```

Quand on arrive à la fin de la chaîne, find() retourne l'élément de fin au lieu d'un booléen.

## Nombre d occurrences

On pourrait utiliser des itérateurs constant cbegin() et cend() puisqu'on ne compte pas faire de modification.

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/*
    std::fill()
    std::equal()
    std::find(), std::search()
    std::count()
*/

int main()
{
    std::string s{"Bonjour"};

    std::cout << std::count(std::begin(s), std::end(s), 'o') << " occurences de 'o' dans Bonjour" << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog   
> .\prog.exe
2 occurences de 'o' dans Bonjour
```

## Tri d éléments

std::sort()

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/*
    std::fill()
    std::equal()
    std::find(), std::search()
    std::count()
    std::sort(), std::reverse()
*/

int main()
{
    std::vector<int> vec{5, 3, 1, 2, 4};

    std::sort(std::begin(vec), std::end(vec));
    
    for(const auto& e : vec)
        std::cout << e << std::endl;    

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

std::reverse()

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/*
    std::fill()
    std::equal()
    std::find(), std::search()
    std::count()
    std::sort(), std::reverse()
*/

int main()
{
    std::vector<int> vec{5, 3, 1, 2, 4};

    auto begin{std::begin(vec)};
    auto end{std::end(vec)};

    std::sort(begin, end);
    std::reverse(begin, end);
    
    for(const auto& e : vec)
        std::cout << e << std::endl;    

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
5
4 
3 
2 
1 
```

## Remplacement d éléments

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/*
    std::fill()
    std::equal()
    std::find(), std::search(), std::replace()
    std::count()
    std::sort(), std::reverse()
*/

int main()
{
    std::string s{"lala lolo lolo lala lolo"};

    std::cout << s << std::endl; 
    std::replace(std::begin(s), std::end(s), 'o', 'i');
    std::cout << s << std::endl;    

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
lala lolo lolo lala lolo
lala lili lili lala lili
```

Remplacement de charactère, d'entiers, de nombres à virgule flottante. On est sur du générique !

## Suppression d éléments

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/*
    std::fill()
    std::equal()
    std::find(), std::search(), std::replace()
    std::count()
    std::sort(), std::reverse()
    std::remove(), std::erase()
*/

int main()
{
    // std::string s{"lala lolo lolo lala lolo"};

    std::erase(vec, 5); // retirer la valeur 5

    return 0;
}
```

Utiliser erase() plutôt que remove()

## Inversion de valeurs

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/*
    std::fill()
    std::equal()
    std::find(), std::search(), std::replace()
    std::count()
    std::sort(), std::reverse()
    std::remove(), std::erase()
    std::swap()
*/

int main()
{
    int a{5};
    int b{3};

    std::cout << "a = " << a << " / b = " << b << std::endl;
    std::swap(a, b);
    std::cout << "a = " << a << " / b = " << b << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
a = 5 / b = 3
a = 3 / b = 5
```

## Traitement sur des éléments

Utiliser souvent en JS ou en programmation fonctionnelle.

La méthode for_each() 

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/*
    std::fill()
    std::equal()
    std::find(), std::search(), std::replace()
    std::count()
    std::sort(), std::reverse()
    std::remove(), std::erase()
    std::swap()
    std::for_each()
    std::all_of(), std::any_of(), std::none_of()
*/

void print_elements(int n)
{
    std::cout << n << std::endl;
}

int main()
{
    std::vector<int> vec{1, 2, 3, 4, 5};

    // for(const auto& e : vec)
    //     std::cout << e << std::endl;

    std::for_each(std::begin(vec), std::end(vec), print_elements);

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

Équivalence avec les méthodes :
all_of() retourne un booléen si tout est valide.
any_of() idem si au moins un est valide.
none_of() idem avec tout les éléments qui doivent rencoyer false.

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/*
    std::fill()
    std::equal()
    std::find(), std::search(), std::replace()
    std::count()
    std::sort(), std::reverse()
    std::remove(), std::erase()
    std::swap()
    std::for_each()
    std::all_of(), std::any_of(), std::none_of()
*/

bool is_pair(int n) // retourne un booléen
{
    return n % 2 == 0;
}

int main()
{
    std::vector<int> vec{1, 2, 3, 4, 5};

    std::cout << std::all_of(std::begin(vec), std::end(vec), is_pair) << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
0
```

Au moins 1 fois un cas de figure où le premier élément `1` retourne false donc voilà le traitement se termine puisque tout devait être égal à vrai.

Test du début à la fin, avec le passage d'une fonction en 3e argument.

## Conclusion

Autres méthodes tels que le minimum ou le maximum des valeurs, fusion des éléments, tirrage, ect.

Voir ce qui est disponible dans la bibliothèque standard.

Nécéssité de comprendre les itérateurs pour aborder les algorithmes.

Á bientôt