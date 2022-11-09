# [16. Classes et objets](https://www.youtube.com/watch?v=sFdFzlbMKVs)

+ [Introduction](#Introduction)
+ [Rappel sur les structures](#Rappel-sur-les-structures)
+ [Principe de la programmation objet](#Principe-de-la-programmation-objet)
+ [Abstraction des données](#Abstraction-des-données)
+ [Écriture d'une classe et instanciation](#Écriture-d-une-classe-et-instanciation)
+ [Comment sont créés les objets ?](#Comment-sont-créés-les-objets)
+ [Niveaux d'accès](#Niveaux-d-accès)
+ [Constructeur par défaut](#Constructeur-par-défaut)
+ [Instance courante d'une classe](#Instance-courante-d-une-classe)
+ [Constructeur de copie](#Constructeur-de-copie)
+ [Constructeur de déplacement](#Constructeur-de-déplacement)
+ [Destructeur](#Destructeur)
+ [Conclusion](#Conclusion)

>

## Introduction

## Rappel sur les structures

Le terme de struct admet par défaut que les données sont publiques qui va à l'encontre de l'encapsulation des données en programmation objet. 

```cpp
#include <iostream>

struct Point
{
    int x;
    int y;
};

int main()
{
    Point p{145, 38};

    std::cout << "(" << p.x << ", " << p.y << ")" << std::endl;
    p.x = 64;
    std::cout << "(" << p.x << ", " << p.y << ")" << std::endl;

    return 0;
}
```

## Principe de la programmation objet

En programmation objet, on fonctionne en terme de services tel que démarrer ou tourner le volant pour une voiture par exemple. Différentes fonctionnalités qui fournissent le service attendu.

## Abstraction des données

Ainsi la couche d'abstraction apporter par la programmation orienté objet, nous fournissons un modèle très abstrait avec différent services, fonctionnalités proposées et on peut l'utiliser tel quel.

Avec l'héritage du c++, on peut réutiliser ce terme `struct` avec les différentes données publiques.

Un premier pilier important en programmation objet est l'**encapsulation**, nous aborderons ensuite l'**héritage** et le **polymorphisme**.

On verra également des mots-clés pour changer le niveau d'accès mais par défaut on a :

```cpp
/*
    struct  : données publiques (par défaut)
    class   : données privées (par défaut)
*/
```

`struct` permet de créer un type qui regroupe des données. C'est publique, on ne ressent pas le besoin de cacher certaines choses, on peut y accéder et les modifier sans problèmes :
```cpp
p.x = 64;
std::cout << "(" << p.x << ", " << p.y << ")" << std::endl;
```

`class` est utilisé pour faire des tests sur les données, par exemple `x` reste dans un intervale de données. Utilisé lorsqu'on fait appel à des invariant et dans le besoin de faire des tests, des assertions et cetera.

## Écriture d une classe et instanciation

Créer une classe pour permettre de faire des vérifications sur les données et ne pas avoir n'importe quoi.

```cpp
#include <iostream>

/*
    struct  : données publiques (par défaut)
    class   : données privées (par défaut)
*/

class Point
{

};

int main()
{
    Point p{};

    return 0;
}
```

On a un objet de type Point, on a créé une instance à partir de ce modèle de class qui représente un point.

```cpp
std::cout << p << std::endl;
```

A cet instant, on ne sait pas afficher P car cela retournerait une erreur, impossible de convertir 'p' de type `Point` en le type `const signed char*` parce que notre ordinateur ne sait pas comment l'afficher donc on ne peut pas utiliser l'opérateur de flux donc il faudra surcharger les opérateurs (arithmétique, comparaison, affectation, et cetera) donc définir des méthodes (fonctions propres aux classes).

## Comment sont créés les objets

Même si ici `class Point{};`, on a peu de code mais on crée une instance `Point p{};` avant d'être libérée, détruite donc on a le mécanisme du constructeur et du destrcuteur.

## Niveaux d accès

```cpp
/*
    Niveaux d'accès : public, private, protected
*/
```

Préféré écrire toujours le niveau d'accès, ici `public:` par exemple, ce qui est implicite par défaut selon les langage n'est pas clairement définit sinon.

On va hiéarchiquement mettre ce qui est public, ensuite privé parce qu'on s'intéresse à ce qui est d'habord mis publiquement à l'utilisateur plutôt que les données encapsulées misent en privée.

```cpp
#include <iostream>

/*
    struct  : données publiques (par défaut)
    class   : données privées (par défaut)

    Niveaux d'accès : public, private, protected
*/

class Point
{
    public:
        //....

    private:
        //....
};

int main()
{
    Point p{};

    return 0;
}
```

On utilise des étiquêtes qui changent le niveau d'accès : `public:` et `private:`

## Constructeur par défaut

Le constructeur est très simple à écrire : `Point();`, constructeur par défaut où on renseigne aucun paramètre car on va créer l'objet.

Pour travailler proprement, on travaille avec un fichier d'en-tête avec les définitions et les prototypes puis l'implémentation dans un fichier source donc on implémente notre constructeur `Point();`.

Pour l'implémentation du constructeur, on utilise l'opérateur de portée `::`.

+ main.cpp
```cpp
#include "point.hpp"
#include <iostream>

int main()
{
    Point p{};

    return 0;
}
```
+ point.cpp
```cpp
#include "point.hpp"
#include <iostream>

Point::Point()
{
    std::cout << "Creation d'un point."  << std::endl;
}
```
+ point.hpp
```hpp
#ifndef __POINT__
    #define __POINT__

    class Point
    {
        public:
            Point();
    };
#endif
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Cr├®ation d'un point.
```

## Instance courante d une classe

Utiliser le mot clé `this` qui représente l'instance courante.

+ point.cpp
```cpp
#include "point.hpp"
#include <iostream>

Point::Point()
{
    std::cout << "Creation d'un point : "  << this << std::endl;
}
```
```txt
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Creation d'un point.0x65c07ff8af
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Creation d'un point : 0x19789ff8ef
> .\prog.exe
Creation d'un point : 0xe92adffd5f
> .\prog.exe
Creation d'un point : 0xf37ffffc4f
> .\prog.exe
Creation d'un point : 0x8680dffd8f
> .\prog.exe
Creation d'un point : 0xca833ffd9f
```

L'adresse de l'objet qui change donc c'est un nouvel objet qui est créé à chaque fois.

Lorsqu'on crée deux objet :

+ main.cpp
```cpp
#include "point.hpp"
#include <iostream>

int main()
{
    Point p{};
    Point p2{};

    return 0;
}
```
+ point.cpp
```cpp
#include "point.hpp"
#include <iostream>

Point::Point()
{
    std::cout << "Creation d'un point."  << this << std::endl;
}
```
+ point.hpp
```hpp
#ifndef __POINT__
    #define __POINT__

    class Point
    {
        public:
            Point();
    };
#endif
```
```txt
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Creation d'un point : 0xf6c3dffb1f
Creation d'un point : 0xf6c3dffb1e
```

On crée deux objet et `this` fait référence à l'instance qui est en cours avec `this` qui fait successivement référence à P puis à P2 en fonction de leurs appels ce qui permet de distinguer les objets parce qu'on ne peut pas écrire ceci (avec `p` au lieu de `this`) :

```ps1
std::cout << "Creation d'un point."  << p << std::endl;
```

`this` fait référence à l'instance qui a appelé la méthode.

On verra le constructeur, les attributs et les méthodes à la suite des vidéos. Comment créer son constructeur et comment ne pas appeler le constructeur par défaut avec le mot clé `delete` :

```ps1
class Point
{
    public:
        Point() = delete;
}
```

## Constructeur de copie

Déclarer un nouvel objet, construit à partir de notre premier objet :

```ps1
Point p{};
Point p2{p};
```

Ce constructeur de copie est créé par défaut et nous pouvons l'implémenter nous-même de cette manière en faisant une référence vers ce type `const Point` car nous ne faisons pas de modification de l'objet en question.

```ps1
Point p{};
Point p2{const Point& p};
```

Pour l'aspect visuel, on définit notre constructeur de copie : `Point::Point(const Point& p){}`

+ main.cpp
```cpp
#include "point.hpp"
#include <iostream>

int main()
{
    Point p{};
    Point p2{};

    return 0;
}
```
+ point.cpp
```cpp
#include "point.hpp"
#include <iostream>

Point::Point()
{
    std::cout << "Creation d'un point."  << this << std::endl;
}

Point::Point(const Point& p)
{
    std::cout << "Copie d'un point." << std::endl;
}
```
+ point.hpp
```hpp
#ifndef __POINT__
    #define __POINT__

    class Point
    {
        public:
            Point();
    };
#endif
```
```txt
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
point.cpp:9:28: error: definition of implicitly-declared 'constexpr Point::Point(const Point&)'
    9 | Point::Point(const Point& p)
      |                            ^
> .\prog.exe
Creation d'un point : 0xabe0fff5ff
Creation d'un point : 0xabe0fff5fe
```

Voilà un message d'avertissement car je n'utilise pas la variable et c'est normal.

La copie a bien été faites.

Ainsi on peut faire la copie d'un objet, on peut l'implémenter sinon on peut se contenter du constructeur de copie ou voir même ne pas en utiliser.

Ce n'est pas parce que l'on crée une classe que l'on doit créer un constructeur de copie, ce n'est pas obligatoire.

## Constructeur de déplacement

Syntaxe avec `&&` pour éviter la copie des données lorsqu'on va trasmettre donc la responsabilité des données. On transmet la responsabilités, la propriété des données à une autre variable sans effectuer une copie. On travail avec de la référence aussi.

```ps1
Point p{};
Point p2{Point&& p};
```

## Destructeur

Il commence avec une `~` : `~Point();`. Le destructeur est généré automatiquement, pas besoin de l'implementer. On pourra l'appeler sans à avoir à attendre la fin de vie d'un objet. On va juste faire une petite implémentation pour avoir un petit message.

+ main.cpp
```cpp
#include "point.hpp"
#include <iostream>

int main()
{
    Point p{};
    Point p2{};

    return 0;
}
```
+ point.cpp
```cpp
#include "point.hpp"
#include <iostream>

Point::Point()
{
    std::cout << "Creation d'un point : "  << this << std::endl;
}

Point::~Point()
{
    std::cout << "Destruction de l'objet : "  << this << std::endl;
}
```
+ point.hpp
```hpp
#ifndef __POINT__
    #define __POINT__

    class Point
    {
        public:
            Point();
            ~Point();
    };
#endif
```
```txt
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Creation d'un point : 0x20621ff77f   
Creation d'un point : 0x20621ff77e   
Destruction de l'objet : 0x20621ff77e
Destruction de l'objet : 0x20621ff77f
```

On peut donc faire appel au destructeur, on n'est pas obligé d'attendre la fin de vie d'un objet.

On voit que l'objet créé en premier est détruit en dernier.

## Conclusion

Dans la prochaine vidéo, les attributs et les méthodes avec la notion d'encapsalution avec des données privées.

Ciao tout le monde