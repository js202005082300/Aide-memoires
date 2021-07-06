# [4. Variables](https://www.youtube.com/watch?v=3exIzj5MYzU)

+ [Afficher une valeur brute](#Afficher-une-valeur-brute)
+ [Le nommage et les types fondamentaux](#Le-nommage-et-les-types-fondamentaux)
+ [Initialiser](#Initialiser)
+ [Suffixes](#Suffixes)
+ [Préfixes](#Préfixes)
+ [Séparateur de milliers](#Séparateur-de-milliers)
+ [Déclarer et initialiser un seul caractère](#Déclarer-et-initialiser-un-seul-caractère)
+ [Déclarer et initialiser une chaîne de caractères](#Déclarer-et-initialiser-une-chaîne-de-caractères)
+ [Modifier notre chaîne de caractère](#Modifier-notre-chaîne-de-caractère)
+ [Déclarer une autre variable où on veut et selon une certaine portée](#Déclarer-une-autre-variable-où-on-veut-et-selon-une-certaine-portée)
+ [Variable constante](#Variable-constante)
+ [Déduire le type par le compilateur avec le mot-clé auto](#Déduire-le-type-par-le-compilateur-avec-le-mot-clé-auto)

## Afficher une valeur brute

```cpp
#include <iostream>

int main()
{
    std::cout << "Bonjour" << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
Bonjour
```

## Le nommage et les types fondamentaux

```cpp
#include <iostream>

int main()
{
    welcomeCase // camelCase
    WelcomeMessage // PascalCase
    welcome_message // snake_case

    return 0;
}
```
```powershell
```

+ [Les types fondamentaux](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/C%2B%2B/types-fondamentaux.md)

sizeof() pour vérifier la taille des données.
le standard C++ garantit que : `char` <= `short` <= `int` <= `short` <= `long` <= `long long`
Le plus souvent on utilise `int` et plutôt `long` pour les valeurs monétaire.
On utilise `double` ou `long double` pour plus de précision.
Un type non-signé `unsigned` ne peut pas être négatif, et la taille en valeur positive double en non-signé.
La mémoire vive est suffisament conséquente pour ne pas s'en soucier !

## Initialiser

Les accolades permettent d'initialiser par défaut mais on priviligie initialiser une variable dés sa déclaration.

```cpp
#include <iostream>

int main()
{
    bool is_secure{};
    int some_number{};
    int some_number_bis{144};

    std::cout << is_secure << std::endl;
    std::cout << some_number << std::endl;
    std::cout << some_number_bis << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
0
0
144
```

Par défaut, un booléen et un entier prennent 0 (false).

## Suffixes

`float some_number{14};` n'est pas faut car *14 = 14.0 = 14.00000000* donc si on veut contrôler le type de données on indique l'opérateur f `float some_number{14f};` donc si on veut être stricte `14` n'est pas un flottant.

```cpp
#include <iostream>

int main()
{
    float some_number{14f};

    std::cout << some_number << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
main.cpp: In function 'int main()':
main.cpp:5:23: error: unable to find numeric literal operator 'operator""f'
    5 |     float some_number{14f};
      |                       ^~~
main.cpp:5:23: note: use '-fext-numeric-literals' to enable more built-in suffixes 
```

Pour valider la compilation `float some_number{14.0f};`

```cpp
#include <iostream>

int main()
{
    float some_number{14.0f};

    std::cout << some_number << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
14
```

Les suffixes sont important à ce niveau-là.

:warning: on peut cumuler les suffixes par exemple si on a un flottant non signé `..fu`.

```cpp
#include <iostream>

// Suffixes
// u, U (non signé)
// f, F (flottant)
// l, L (long int, long double)
// ll, LL (long long int)

int main()
{
    float some_number{14.0f};
    unsigned int other_number{146330u};

    std::cout << some_number << std::endl;

    return 0;
}
```
```powershell
```

## Préfixes

```cpp
#include <iostream>

// Suffixes
// u, U (non signé)
// f, F (flottant)
// l, L (long int, long double)
// ll, LL (long long int)

// Préfixes
// 0b (binaire)
// 0 (octal)
// 0x (hexadécimal)

int main()
{
    int file_rights = 0755; // l'octal utile sur Linux

    std::cout << file_rights << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
493
```

*13* vaut *1101* en binaire.

```cpp
#include <iostream>

int main()
{
    int file_rights = 0b1101;

    std::cout << file_rights << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
13
```

## Séparateur de milliers

```cpp
#include <iostream>

int main()
{
    long long big_number = 14'815'100;

    std::cout << big_number << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
14815100
```

Sur certains langages, on utilise le underscore à la place *14_815_100*

## Déclarer et initialiser un seul caractère

```cpp
#include <iostream>

int main()
{
    char c{'A'}; // différent de 'a'

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
14815100
```

## Déclarer et initialiser une chaîne de caractères

`std::string` fait partie de la bibliothèque standard.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string welcome_message{"Hello World !"};

    std::cout << welcome_message << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
Hello World !
```

Voilà on passe par une variable et non plus par une variable en dur.

## Modifier notre chaîne de caractère

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string welcome_message{"Coucou !"};
    std::cout << welcome_message << std::endl;

    //code...
    welcome_message = "Hello";
    //code...

    std::cout << welcome_message << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
Coucou !
Hello
```

## Déclarer une autre variable où on veut et selon une certaine portée

:warning: on déclare les informations où on en a besoin mais avec certains vieux standard, il faut les déclarer au début de la portée de certaines fonctions mais pas où on veut.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string welcome_message{"Coucou !"};
    std::cout << welcome_message << std::endl;

    // code...

    int some_code{1455};
    std::cout << some_code << std::endl;


    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
1455
```

La portée de la variable s'arrête à l'accolade fermante de notre fonction où elle est libérée.

Suivant la portée, il faut libérer la variable dés qu'on en a plus besoin.

## Variable constante

Peut importe le sens `int const some_code{1455};` ou `const int some_code{1455};`

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string welcome_message{"Coucou !"};
    std::cout << welcome_message << std::endl;

    // code...

    const int some_code{1455};
    std::cout << some_code << std::endl;

    //...

    some_code = 166;
    std::cout << somme_code << std::endl;


    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
main.cpp: In function 'int main()':
main.cpp:16:15: error: assignment of read-only variable 'some_code'
   16 |     some_code = 166;
      |     ~~~~~~~~~~^~~~~
main.cpp:17:18: error: 'somme_code' was not 
declared in this scope; did you mean 'some_code'?
   17 |     std::cout << somme_code << std::endl;
      |                  ^~~~~~~~~~
      |                  some_code
```

Une variable constante est uniquement en lecture seule.

Ce mot-clé pour ajouter de la sécurité.

## Déduire le type par le compilateur avec le mot-clé auto

```cpp
#include <iostream>

int main()
{
    auto some_code{1455};
    std::cout << some_code << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
1455
```

Après pour en déduire que c'est un flottant, c'est pas évident mais par contre si on fait `auto some_code{1455.};` ou `auto some_code{1455.0};`. Pareil si on met `auto some_code{true};` le compilateur pourra déduire l'information.

```cpp
#include <iostream>
#include <string>

int main()
{
    auto some_string{"Hello World"};
    std::cout << some_string << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Hello World
```

Pour une chaîne, il ne va pas le déduire comme une `std::string` mais pour s'en assurer on va ajouter le suffixe `s` et précédé la variable de `using namespace std::literals;`

```cpp
#include <iostream>
#include <string>

int main()
{
    using namespace std::literals;

    auto some_string{"Hello World"s}; //std::string
    std::cout << some_string << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Hello World
```

Même résultat, sauf qu'avec ce suffixe, opérateur `s`, on s'assure d'avoir une vraie chaîne de caractères.