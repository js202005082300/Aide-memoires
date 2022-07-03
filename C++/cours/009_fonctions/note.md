# [9. Fonctions](https://www.youtube.com/watch?v=2CzOycVN-FY)

+ [Introduction](#Introduction)
+ [Qu'est-ce qu'une fonction ?](#Qu-est-ce-qu-une-fonction)
+ [Utiliser des fonctions existantes](#Utiliser-des-fonctions-existantes)
+ [Créer notre propre fonction](#Créer-notre-propre-fonction)
+ [Fonction avec des paramètres (et retour)](#Fonction-avec-des-paramètres)
+ [Portée des variables](#Portée-des-variables)
+ [Passage par valeur, par référence](#Passage-par-valeur-et-par-référence)
+ [Surcharge de fonctions](#Surcharge-de-fonctions)
+ [Expression lambda](#Expression-lambda)
+ [Conclusion](#Conclusion)

## Introduction

Travailler à plusieurs, organiser et partager du code.

## Qu est-ce qu une fonction

Factorisation de code.

## Utiliser des fonctions existantes

Quelques fonctions déjà vues.

+ main.cpp
```cpp
#include <iostream>

/*
    getline()
    ignore(), good, fail()
*/

int main()
{
    std::string s{"Hello World !"};

    std::cout << s.length() << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
13
```

## Créer notre propre fonction

Une fonction printHelloWorld(). Autrefois une fonction qui ne retournait rien était appelé une procédure, ici on utilise le type `void`.

+ main.cpp
```cpp
#include <iostream>

void printHelloWorld()
{
    std::cout << "Hello World !" << std::endl;
}

int main()
{
    printHelloWorld();

    // code ...

    printHelloWorld();

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
Hello World !
Hello World !
```

Avantage de réduire la répétition de code et un coté dynamique avec l'utilisation de paramètres.

## Fonction avec des paramètres

+ main.cpp
```cpp
#include <iostream>

int sum(int a, int b)
{
    return a + b;
}

int main()
{
    auto result1 = sum(14, 7);
    std::cout << result1 << std::endl;

    auto n{5};
    auto m{9};

    auto result2 = sum(n, m);
    std::cout << result2 << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
21
14
```

L'avantage c'est qu'on peut ajouter nos vérifications à la function sum().

## Portée des variables

Attention sum() et main() ont chacun leur portée. Les variables déclarées dans sum() ne sont pas disponible dans main() et inversement.

`auto n{5};` est détruite à la fin de la fonction main().

Du code après le `return` sera ignoré.

La variable du même nom `n` dans sum() et dans main() seraient différentes.

Attention une nouvelle portée avec la variable `int a{5};` qui n'es disponible dans aucune autre portée/contexte/container.

```cpp
int main()
{
    auto result1 = sum(14, 7);
    std::cout << result1 << std::endl;

    {
        int a{5};
    }

    auto n{5};
    auto m{9};

    auto result2 = sum(n, m);
    std::cout << result2 << std::endl;

    return 0;
}
```

## Passage par valeur et par référence

Voyez soit on passe les valeurs en dur soit on passe des variables.

Ici `auto result1 = sum(14, 7);`, on crée un passage par valeur. En réalité une copie est initialisée avec ces valeurs par le compilateur.

Une référence n'est pas un pointeur mais c'est un alias. Noté qu'on ne peut pas faire une référence à Null.

Pointeur `*` et référence `&` sont différent.

+ main.cpp
```cpp
#include <iostream>

int main()
{
    int n{15};
    int &refN{n};

    std::cout << n << std::endl;
    std::cout << refN << std::endl;

    n = 28;

    std::cout << n << std::endl;
    std::cout << refN << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
15
15
28
28
```

Voilà ici on a un alias grâce à un `&`. C'est une autre variable pour accéder à l'information.

Passage par référence.

+ main.cpp
```cpp
#include <iostream>

// Modification des variables d'origines
void setNumbers(int& a, int& b)
{
    a -= 6;
    b += 2;
}

int main()
{
    int n{5};
    int m{8};

    std::cout << n  << " " << m << std::endl;

    setNumbers(n, m);

    std::cout << n  << " " << m << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
5 8  
-1 10
```

En modifiant les références, on modifie les variables d'origine.

Attention ici, on modifie des copies donc pas de changement.
```cpp
void setNumbers2(int a, int b)
{
    a -= 6;
    b += 2;
}
```

## Surcharge de fonctions

+ main.cpp
```cpp
#include <iostream>

void printSum(int a, int b)
{
    std::cout << a + b << std::endl;
}

int main()
{
    printSum(4, 7);
    printSum(6.9, 10.03);

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
11
16
```

La partie à virgule flottante a été ici tronquée (6+10).

On va réécrire la signature.

+ main.cpp
```cpp
#include <iostream>

void printSum(int a, int b)
{
    std::cout << a + b << std::endl;
}

void printSum(float a, float b)
{
    std::cout << a + b << std::endl;
}

int main()
{
    printSum(4, 7);
    printSum(6.9F, 10.03F);

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
11
16.93
```

Cette fois la partie décimale est prise en compte.

Attention que les signatures doivent être identique pour être prises en compte si on a le prototype `void printSum(int a, int b);` puis `int printSum(float a, float b);`, le compilateur ne pourra pas déterminer laquelle utilisée.

Le compilateur doit rencontrer le prototype (signature + point virgule) puis les fonctions pourront être implémentées même après main().

## Expression lambda

La syntaxe.

Une classe/zone de capture `[]` puis parenthèses `()` pour les paramètres puis des spécificateurs éventuellements puis on précise le type de retour, les accolades classiques `{}` et enfin le point virgule `;`.

```cpp
#include <iostream>

int main()
{
    // []() <spécificateurs> -> <type_retour> { };
}
```

L'expression anonyme que l'on défini a une portée locale, ce qui change des fonctions avec leurs portées globales.

Au plus simple, on va l'affecter à une variable auto puis o appelle notre fonction.

```cpp
#include <iostream>

int main()
{
    auto func = []() -> void { std::cout << "Hello World !" << std::endl; };
    func();

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
Hello World !
```

On peut faire des passages par valeurs ou des passages par référence dans cette fonction qui suit les mêmes règles.

Faire référence à une variable `n` en fonction de la portée locale donc utuliser le symbole égal `[=]` pour passer la totalité des variables externes (on passe bien l'information car nous passons une copie).

```cpp
#include <iostream>

int main()
{
    int n{67};

    std::cout << n << std::endl;
    
    auto func = [=]() -> void { std::cout << n << std::endl; };
    func();

    std::cout << n << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
67
67
67
```

Par défaut les informations capturées dans une fonction lambda sont accessibles en lecture seule uniquement.

Les données sont dites immuables.

Pour les rendre muable, la spécification de muabilité est la spécification `mutable`.

```cpp
#include <iostream>

int main()
{
    int n{67};

    std::cout << n << std::endl;
    
    auto func = [=]() mutable -> void { n = 68; };
    func();

    std::cout << n << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
67
67
```

L'information n'est pas modifier car c'est une capture par copie.

Si on veux l'ensemble des informations par référence, il faut utiliser le Et commerciale `&`.

```cpp
#include <iostream>

int main()
{
    int n{67};

    std::cout << n << std::endl;
    
    auto func = [&]() mutable -> void { n = 68; };
    func();

    std::cout << n << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
67
68
```

Voilà pour résumé, `[&]` permet de modifier avec une capture par référence.

```cpp
#include <iostream>

int main()
{
    int n{67};
    int m{34};

    std::cout << n << " - " << m << std::endl;
    
    auto func = [&]() mutable -> void
    {
        n += 3;
        m -= 4;
        std::cout << n << " - " << m << std::endl;
    };
    func();

    std::cout << n << " - " << m << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog   
> ./prog
67 - 34
70 - 30
70 - 30
```

Via une capture par copie `[=]`, on modifie les copies dans l'expression. On modifie uniquement dans la fonction lambda qui a une portée locale.

```cpp
#include <iostream>

int main()
{
    int n{67};
    int m{34};

    std::cout << n << " - " << m << std::endl;
    
    auto func = [=]() mutable -> void
    {
        n += 3;
        m -= 4;
        std::cout << n << " - " << m << std::endl;
    };
    func();

    std::cout << n << " - " << m << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
67 - 34
70 - 30
67 - 34
```

En plus, on peut passer par copie et par référence à la fois `[&n, m]`.

```cpp
auto func = [&n, m]() mutable -> void
{

}
```

En résumé,

```cpp
/*
    var     : passage par copie
    &var    : passage par référence

    =       : tout est passé par copie
    &       : tout est passé par référence
*/
```

```cpp
#include <iostream>

int main()
{
    int n{67};
    int m{34};

    std::cout << n << " - " << m << std::endl;
    
    auto func = [&n, m]() mutable -> void
    {
        n += 3;
        m -= 4;
        std::cout << n << " - " << m << std::endl;
    };
    func();

    std::cout << n << " - " << m << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
67 - 34
70 - 30
70 - 34
```

Voilà le `m` n'as pas été changé car il a été passé par copie tandis que `n` change car il est passé par référence.

On peut également l'écrire comme `[&, m]` pour dire que tu passe tout par référence sauf `m` par copie.

```cpp
auto func = [&, m]() mutable -> void
{

}
```

Ou l'inverse `[=, &n]`, tu passe tout par copie sauf `n` par référence.

```cpp
auto func = [=, &n]() mutable -> void
{

}
```

```cpp
#include <iostream>

int main()
{
    int n{67};
    int m{34};

    std::cout << n << " - " << m << std::endl;
    
    auto func = [=, &n]() mutable -> void
    {
        n += 3;
        m -= 4;
        std::cout << n << " - " << m << std::endl;
    };
    func();

    std::cout << n << " - " << m << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> ./prog
67 - 34
70 - 30
70 - 34
```

Regles de capture inversées mais même résultat que tout à l'heure.

Indiquer que notre expression lambda ne peut pas déclencher d'exception avec le mot `noexcept`.

```cpp
auto func = [=, &n]() mutable noexcept -> void
{

}
```

On abordera les exception plus tard.

## Conclusion

On peut changer le mode de capture et les spécifications de nos expressions lambda pour s'entrainer à cette syntaxe un peu compliqué puis on peut passer des paramètres aussi `()` ou retourner un résultat.

A bientôt