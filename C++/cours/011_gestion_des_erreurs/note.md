# [11. Gestion des erreurs](https://www.youtube.com/watch?v=6MnuOOr1iZ8)

+ [Introduction](#Introduction)
+ [Présentation des assertions (erreurs lors du développement)](#Présentation-des-assertions)
+ [Compiler en ignorant les assertions](#Compiler-en-ignorant-les-assertions)
+ [Présentation des exceptions](#Présentation-des-exceptions)
+ [Capturer une exception](#Capturer-une-exception)
+ [Lever (déclencher) une exception](#Lever-une-exception)
+ [Conclusion](#Conclusion)

> 

## Introduction

Voir la gestion des erreurs du programmeur puis de l'utilisateur final.

En langage C, on se base beaucoup sur le retour des fonctions avec un test et pas mal de rigeur.

```cpp
#include <iostream>

int main()
{

    return 0;
}
```

Pour gérer les erreurs du développeur, on se base sur les assertions.

## Présentation des assertions

Test sur une expression. En cas d'echec, l'assertion a échouée.

Exemple pour un jeu vidéo.

```cpp
#include <iostream>

void CreatePlayer(std::string name, int level)
{
    std::cout << "Creation de " << name << ", de niveau " << level << std::endl;
}

int main()
{
    CreatePlayer("Robert", 25);
    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Creation de Robert, de niveau 25
```

Idem avec des assertions `#include <cassert>` pour exclure les niveaux négatifs en accéder à une macro assert qui permet de tester une expression et retourne un message si l'assertion échoue : `assert(<expression> && <message>);`

```cpp
#include <iostream>
#include <cassert>

void CreatePlayer(std::string name, int level)
{
    assert(level > 0 && "Le niveau d'un joueur est minimum de 1"); // Si la condition est vrai, validé. En revanche, si échoue le programme est interrompu avec un message d'erreur pour le développeur.
    
    std::cout << "Creation de " << name << ", de niveau " << level << std::endl;
}

int main()
{
    CreatePlayer("Robert", -3);
    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Assertion failed: level > 0 && "Le niveau d'un joueur est minimum de 1", file main.cpp, line 6
> 
```

Ici l'assertion a échouée avec un message pour le développeur.

## Compiler en ignorant les assertions

Pour la version finale, on ne veut plus tester le développement.

On veut ignorer les assertions dans la compilation finale avec l'argument `-DNDEBUG` bien qu'on pourrait passer par une macro mais c'est plus propre en ligne de commande. En plus, c'est plus facile avec un outil comme CMake ou XMake, avec un Makefile.

```ps1
> g++ -std=c++20 -Wall -Wextra -DNDEBUG main.cpp -o prog  
> .\prog.exe
Creation de Robert, de niveau -3
```

Les assertions sont ignorée.

On utilise les assertions pour le développement, c'est le rôle du développeur de gerrer ses erreurs.

## Présentation des exceptions

Le développeur est un utilisateur dans la phase de développement mais l'utilisateur final peut faire des erreurs de saisies, si on a pas les bons identifiants, s'il n'y a plus d'encre dans l'imprimante donc C++ propose les Exception.

Voir la documentation [https://en.cppreference.com/w/cpp/error/exception](https://en.cppreference.com/w/cpp/error/exception) avec des sous-types tel que le débordement d'un conteneur d'une collection `out_of_range` et cetera. Par la suite on peut créer nos propres types.

## Capturer une exception

On capture les Exceptions dans un bloc Try/Catch

```cpp
#include <iostream>
#include <string>

int main()
{
    try
    {
        // Code qui pourrait déclencher une exception
    }
    catch(const std::invalid_argument& err)
    {
        std::cout << err.what() << std::endl;
    }
    catch(const std::exception& err)
    {
        std::cout << "Une erreur generéale s'est produite" << std::endl;
    }

    return 0;
}
```
```ps1
```

Mettre le std::exception global à la fin pour être sûr de tout capturer.

## Lever une exception

Créer notre propre type d'exception et la lever/déclencher avec le mot clé `throw`.

```cpp
#include <iostream>
#include <string>

int main()
{
    try
    {
        throw std::invalid_argument("Pas le bon argument");
    }
    catch(const std::invalid_argument& err)
    {
        std::cout << err.what() << std::endl;
    }
    catch(const std::exception& err)
    {
        std::cout << "Une erreur generéale s'est produite" << std::endl;
    }

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Pas le bon argument
```

Attention si on ne lève pas une exception, ne pas faire ce qui suit :

```cpp
#include <iostream>
#include <string>

int main()
{
    throw std::invalid_argument("Pas le bon argument");

    return 0;
}
```
```ps1
> .\prog.exe
terminate called after throwing an instance of 'std::invalid_argument'
  what():  Pas le bon argument
> 
```

Sans capture, le retour n'est vraiment pas propre.

Le programme est arrêter avec la première exception rencontrée ici, on rentre dans le premier bloc de code catch() donc attention à l'ordre des exceptions.

```cpp
#include <iostream>
#include <string>

int main()
{
    try
    {
        throw std::invalid_argument("Mince !");
        throw std::exception();
    }
    catch(const std::invalid_argument& err)
    {
        std::cout << err.what() << std::endl;
    }
    catch(const std::exception& err)
    {
        std::cout << "Une erreur generéale s'est produite" << std::endl;
    }

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Mince !
```

## Conclusion

On les utilisera plus tard en C++

A bientôt