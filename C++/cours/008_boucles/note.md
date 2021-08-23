# [8. Boucles](https://www.youtube.com/watch?v=blot7YV0MH4)

+ Ensemble de mot-clés.
+ Faire évaluer une expression qui permet d'entrer dans un bloc de code sinon ce bloc est ignoré.
+ Une boucle sert à respecter un certains nombres d'instructions au sein d'un bloc.

## while

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string sentence{"Hello world, how are you?"};
    int i{0};

    while(i < 10) // tant que l'expression est vraie
    {
        std::cout << sentence << "\n";
        i++;
    }

    return 0;
}
```
+ i est notre itérateur. Un tour de boucle est une itération.
+ l'incrémentation de i permet d'avoir un point d'arrêt. `i++` ou `++i` n'a pas d'importance puisqu'on ne fait pas d'affectation à l'intérieur.
+ :warning: C'est donc très important d'avoir un point d'arrêt pour éviter les boucles infinies (utilisation de CTRL+C dans le terminal)

```powershell
> g++ -std=c++17 -Wall -Werror -Werror main.cpp -o prog
> .\prog.exe
Hello world, how are you?
Hello world, how are you?
Hello world, how are you?
Hello world, how are you?
Hello world, how are you?
Hello world, how are you?
Hello world, how are you?
Hello world, how are you?
Hello world, how are you?
Hello world, how are you?
```

```cpp
/*
    i : 0

    Est-ce que i est < 10 ? V
    1ère itération -> phrase affichée

    i : 1
    Est-ce que i est < 10 ? V
    2e itération -> phrase affichée
    incrémente i

    i : 2
    ...
    i : 10
    Est-ce que i est < 10 ? F
    Bloc d'itération ignoré et on passe à la suite du code
*/
```

Voilà comment se passe le déroulement à l'exécution avec une boucle qui est évaluée.

+ Si i vaut 10, on ne rentre pas dans le bloc.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string sentence{"Hello world, how are you?"};
    int i{10};

    while(i < 10) // tant que l'expression est vraie
    {
        std::cout << sentence << "\n";
        i++;
    }

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Werror -Werror main.cpp -o prog
> .\prog.exe
```

## do while

+ Le bloc est exécuté au moins une fois.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string sentence{"Hello world, how are you?"};
    int i{10};

    do
    {
        std::cout << sentence << "\n";
        i++;
    }
    while(i < 10);

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Werror -Werror main.cpp -o prog
> .\prog.exe
Hello world, how are you?
```

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string sentence{"Hello world, how are you?"};
    int i{8};

    do
    {
        std::cout << sentence << "\n";
        i++;
    }
    while(i < 10);

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Werror -Werror main.cpp -o prog
> .\prog.exe
Hello world, how are you?
Hello world, how are you?
```

## break

+ Instruction break qui permet de sortir de la boucle et de poursuivre le programme.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string sentence{"Hello world, how are you?"};
    int i{8};

    do
    {
        std::cout << sentence << "\n";
        break;
        i++;
    }
    while(i < 10);

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Werror -Werror main.cpp -o prog
> .\prog.exe
Hello world, how are you?
```

## continue

+ Instruction qui relance une nouvelle iétartion càd au moment de l'appel de continue, on va ignorer ce qui suit dans la boucle pour refaire le test tout de suite.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string sentence{"Hello world, how are you?"};
    int i{0};

    while(i < 10)
    {
        i++;

        if(i == 4 || i == 5 || i == 6)
            continue;

        std::cout << "i vaut " << i << std::endl;
    }
    
    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Werror -Werror main.cpp -o prog
> .\prog.exe
i vaut 1
i vaut 2
i vaut 3
i vaut 7
i vaut 8
i vaut 9
i vaut 10
```

## for

+ idéal pour le parcours avec beaucoup d'itérations.
+ syntaxe plus condensée
+ 1e partie : initialisation de l'itérateur
+ 2e partie : notre point d'arrêt avec l'expression évaluée
+ 3e partie : incrémentation/décrémentation sur le compteur
+ Les 3 parties ne sont pas obligatoire, on peut rencontrer certains points ignorées `for(auto i{0} ; i < 10 ;;)`.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string sentence{"Hello world, how are you?"};

    for(auto i{0} ; i < 10 ; ++i)
    {
        std::cout << "i vaut " << i << std::endl;
    }
    
    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Werror -Werror main.cpp -o prog
> .\prog.exe
i vaut 0
i vaut 1
i vaut 2
i vaut 3
i vaut 4
i vaut 5
i vaut 6
i vaut 7
i vaut 8
i vaut 9
```

+ Portée des variable : attention le bloc de code de for() a une autre portée que main() et forcément application de règles. Ce qui est créé dans for() n'ext pas accessible dans main(), en revanche ce qui est créé dans main() est accesible dans for(). Le bloc for() fait partie du bloc de main() et c'est pour ça qu'on a cette différence d'accessibilité et de visibilité des élements de notre code.

## Parcourir une chaîne

+ La chaîne de caractères est un élement qu'on va pouvoir lire, parcourir parce que c'est un élement séquentiel parce qu'une chaîne de caratères est une séquence de caractères donc je peux parcourir chaque caractères 1 à 1. On peut itérer sur chaque élément via une boucle.
+ On utilise for() avec quelques particularité. On utilise une variable temporaire `const auto letter` avec `const` car on ne va pas la modifier.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string sentence{"Hello world, how are you?"};

    for(const auto letter : sentence) // pour chaque "letter" de "sentence"
    {
        std::cout << letter << "\n";
    }
    
    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Werror -Werror main.cpp -o prog
> .\prog.exe
H
e
l
l
o

w
o
r
l
d
,

h
o
w

a
r
e

y
o
u
?
```