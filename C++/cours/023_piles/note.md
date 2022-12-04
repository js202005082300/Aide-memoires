# [23. Piles](https://www.youtube.com/watch?v=BetAhan2BdQ)

+ [Introduction](#Introduction)
+ [Fonctionnement d'une pile](#Fonctionnement-d-une-pile)
+ [Déclaration d'une pile](#Déclaration-d-une-pile)
+ [Taille de la pile et ses éléments](#Taille-de-la-pile-et-ses-éléments)
+ [Accès aux éléments](#Accès-aux-éléments)
+ [Empiler un élément](#Empiler-un-élément)
+ [Dépiler un élément](#Dépiler-un-élément)
+ [Parcourir une pile](#Parcourir-une-pile)
+ [Conclusion](#Conclusion)

>

## Introduction

Include la biblio stack.

```cpp
#include <iostream>
#include <string>
#include <stack>

int main()
{

    return 0;
}
```

## Fonctionnement d une pile

Structure LIFO (ex. Pile d'assiètes).

Structures de données comme une fil d'attente où le dernier élément est retiré en premier lors de la libération du programme.

## Déclaration d une pile

```cpp
#include <iostream>
#include <string>
#include <stack>

int main()
{
    std::stack<int> st;

    return 0;
}
```

## Taille de la pile et ses éléments

`size()` (méthode non-libre)

```cpp
#include <iostream>
#include <string>
#include <stack>

int main()
{
    std::stack<int> st;

    std::cout << "Taille : " << st.size() << std::endl;

    if(st.empty())
        std::cout << "Pile vide." << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Taille : 0
Pile vide.
```

## Accès aux éléments

Lire l'élément le plus en haut de la pile, le dernier inséré : `top()`

## Empiler un élément

```cpp
#include <iostream>
#include <string>
#include <stack>

int main()
{
    std::stack<int> st;

    st.push(5);
    std::cout << "Top : " << st.top() << std::endl;

    std::cout << "Taille : " << st.size() << std::endl;

    if(st.empty())
        std::cout << "Pile vide." << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Top : 5   
Taille : 1
```

Pour lire n'importe quel donnée d'une pile, ne pas utiliser les piles en c++.

## Dépiler un élément

`pop()`

```cpp
#include <iostream>
#include <string>
#include <stack>

/*
    size(), empty()
    push(), pop(), top()
*/

int main()
{
    std::stack<int> st;

    st.push(5);
    std::cout << "Top : " << st.top() << std::endl;

    st.push(3);
    std::cout << "Top : " << st.top() << std::endl;

    st.pop();
    std::cout << "Top : " << st.top() << std::endl;

    std::cout << "Taille : " << st.size() << std::endl;

    if(st.empty())
        std::cout << "Pile vide." << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Top : 5
Top : 3
Top : 5
Taille : 1
```

## Parcourir une pile

```cpp
#include <iostream>
#include <string>
#include <stack>

/*
    size(), empty()
    push(), pop(), top()
*/

int main()
{
    std::stack<int> st;

    for(const auto& element : st)
        std::cout << element << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
main.cpp: In function 'int main()':
main.cpp:14:31: error: no matching function for call to 'begin(std::stack<int>&)'
   14 |     for(const auto& element : st)
      |   
```

/!\ Impossible sans dépiler pour lire à chaque fois le haut de la pile.

```cpp
#include <iostream>
#include <string>
#include <stack>

/*
    size(), empty()
    push(), pop(), top()
*/

int main()
{
    std::stack<int> st;
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);

    while(!st.empty())
    {
        std::cout << st.top() << " ";
        st.pop();
    }
    std::cout << "\n";

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
4 3 2 1 
```


## Conclusion

On abordera les itérateurs et les pointeurs et donc les conteneurs nécéssitait d'être vus.

A bientôt tout le monde