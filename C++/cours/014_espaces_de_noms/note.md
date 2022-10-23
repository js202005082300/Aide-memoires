# [14. Espaces de noms](https://www.youtube.com/watch?v=vMrIyb6PhwM)

+ [Introduction](#Introduction)
+ [Qu'est-ce qu'un espace de nom ?](#Qu-est-ce-qu-un-espace-de-nom)
+ [L'espace de nom "std"](#L-espace-de-nom-"std")
+ [Déclaration d'un espace de nom](#Déclaration-d-un-espace-de-nom)
+ [Implémentation des données de l'espace de nom](#Implémentation-des-données-de-l-espace-de-nom)
+ [Utilisation de l'espace de nom](#Utilisation-de-l-espace-de-nom)
+ [Espace de nom anonyme](#Espace-de-nom-anonyme)
+ [L'usage de "using namespace"](#L-usage-de-using-namespace)
    + [Parenthèse : L'Usage de deux méthodes identiques](#L-Usage-de-deux-méthodes-identiques)
+ [Espaces de noms imbriqués](#Espaces-de-noms-imbriqués)
+ [Espace de nom en ligne ("inline")](#Espace-de-nom-en-ligne-"inline")
+ [Création d'alias pour un espace de nom](#Création-d-alias-pour-un-espace-de-nom)
+ [Conclusion](#Conclusion)

>

## Introduction

Attention au mauvais usage de cette directive `using namespace std;`

```cpp
#include <iostream>

using namespace std;

int main()
{

    return 0;
}
```

## Qu est-ce qu un espace de nom

Un espace de nom permet d'organiser son code et éviter la collision de nom !

## L espace de nom "std"

On travaille avec la bibliothèque standard de C++ avec le préfixe `std::` avec std qui est l'espace de nom qui globalise l'ensemble de la bibliothèque standard avec `std::cout` pour l'affichage à l'écran, `std::ofstream` pour créer un flux de sortie dans un fichier, `std::string` pour le type de chaîne de charactères en C++ (avec l'en-tête string).

On évite l'utilisation de `string` tout court car il y a un ensemble de bibliothèques dans le monde qui utilise ce mot.

On utilise `string`, nommage qualifié, qui est spécifique à la bibliothèque standard c++

## Déclaration d un espace de nom

+ main.cpp
```cpp

```
+ util.cpp
```cpp

```
+ util.hpp
```cpp
#ifndef __UTIL__
    #define __UTIL__

    namespace Util
    {

    }
#endif
```

Choisir la convetion qui plaît et s'y tenir (nommage avec une majuscule au début).

On peut créer un objet `cout` dans notre espace de nom Util, qui ne sera pas l'objet `cout` de l'espace de nom `std` en c++, pareil avec `string`, on aura `Util::string`

```cpp
#ifndef __UTIL__
    #define __UTIL__

    // Util::string
    // std::string

    namespace Util
    {
        string
    }
#endif
```

Voilà pourquoi on insiste sur le fait de mettre l'espace de nom suivi de l'opérateur de portée.

Quand on travaille en Php, on considère que les espaces de noms sont dans des fichiers.

On peut créer plusieurs espaces de noms avec des chemins où on définit un espace de nom par répertoire **dans d'autres langages** (exemple : l'arborescence de dossiers Util\Kernel\UserApp).

```cpp
#ifndef __UTIL__
    #define __UTIL__

    namespace Util\Kernel\UserApp
    {
        string
    }
#endif
```

Certains outils, frameworks imposent leurs arborescences dans leurs systèmes de projets.

## Implémentation des données de l espace de nom

Quid la portée global `test()` sur l'ensemble du fichier vs l'espace de noms `Util::test()`. Les deux fonctions sont différentes.

+ util.hpp
```cpp
#ifndef __UTIL__
    #define __UTIL__

    namespace Util
    {
        void test(); // Util::test()
    }

    void test(); // test()

#endif
```

Pour les programmeurs en C, on définirait les données `namespace Util { ... }` comme étant statiques càd qu'elles sont propres au fichier.

Ce qui change c'est qu'on utilise `namespace` pour définir notre espace de nom, et après dans notre implémentation, on fait précéder la définition de méthode par le nom de l'espace de nom en préfixe `Util::test()` à la différence lorsqu'on travaillais de façon modulaire.

## Utilisation de l espace de nom

+ main.cpp
```cpp
#include "util.hpp"
#include <iostream>

int main()
{
    Util::test();

    return 0;
}
```
+ util.cpp
```cpp
#include "util.hpp"
#include <iostream>

void Util::test()
{
    std::cout << "Test !" << std::endl;
}
```
+ util.hpp
```cpp
#ifndef __UTIL__
    #define __UTIL__

    namespace Util
    {
        void test(); // Util::test()
    }

#endif
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Test !
```

On utilise les espaces de noms pour éviter les collisions de noms identiques.

Par exemple, on pourrait définir un type string sans aucun problème dans notre espaces de noms.

## Espace de nom anonyme

Pour que ça ne suive pas le comportement d'une déclaration statique, on fait `namespace` au lieu de `namespace Util` pour avoir un espace de nom anonyme dans lequel on retrouve notre déclaration statique comme en language C.

Ainsi si on veut un type d'information qui n'as de portée que dans ce fichier-là, on peut créer ceci.

+ util.hpp
```cpp
#ifndef __UTIL__
    #define __UTIL__

    namespace
    {
        void test();
    }

#endif
```

Après dans un espace de noms c'est du code, donc on peut définir nos classes et nos structures :

```cpp
namespace
{
    class //...

    struct //...
}
```

C'est simplement pour dire qu'on ne déclare pas les données dans une portée globale mais dans une portée moindre pour dire que c'est dans son bloc `namespace` qu'on a tel ou tel donnée.

On utilise les espaces de noms pour organiser les parties d'un projet, d'une application, une partie d'affichage, une partie de traitement et cetera. On peut trier de pleins de manières, hiéarchiser en catégories et en sous-catégories.

## L usage de using namespace

Il est grave de faire ceci `using namespace Util;` qui signifie qu'on utilise cet espace par défaut et ce qui permetrait de le masquer : `Util::test();` devient `test();`. Ainsi si quelqu'un d'autres à une fonction test() et bien cela rentrerait en conflit.

+ main.cpp
```cpp
#include "util.hpp"
#include <iostream>

using namespace Util;

int main()
{
    Util::test();

    return 0;
}
```

Voilà si quelqu'un à un `using namespace Util;`, cela poserait problème.

Éventuellement, on pourrait le mettre dans une portée la plus proche possible, par exemple seulement dans main() où je pourrait utiliser test() de cette manière `test();` tout en s'assurant que dans cette fonction, on ne fera pas appel à une autre fonction test() qui ne serait dans un autre espace et qui pourrait entrer en conflit.

+ main.cpp
```cpp
#include "util.hpp"
#include <iostream>

int main()
{
    using namespace Util;
    test();

    return 0;
}
```

Par exemple, si on a la flemme d'écrire `std::`, on peut écrire :

+ main.cpp
```cpp
#include "util.hpp"
#include <iostream>

int main()
{
    using namespace std::cout;
    cout << "Test !";

    return 0;
}
```

Bon ici cout n'est pas un espace de nom, et ça ne fonctionne pas !

Je ne conseille pas cette syntaxe ensuite au niveau global, évitez de masquer les espaces de noms.

Si on doit masquer un espace de noms, il faut le faire dans une portée la plus restreinte possible.

Mais c'est à éviter !

### L Usage de deux méthodes identiques

On met les définitions d'un espace de noms dans le fichier d'en-tête *util.hpp* et dans l'implémentation *util.cpp* on met les noms entièrement qualifié.

Une déclaration dans l'espace de noms et une déclaration dans le global, et éviter les problèmes de collisions.

+ main.cpp
```cpp
#include "util.hpp"
#include <iostream>

int main()
{
    Util::test();
    test();

    return 0;
}
```
+ util.cpp
```cpp
#include "util.hpp"
#include <iostream>

void Util::test()
{
    std::cout << "Test de Util!" << std::endl;
}

void test()
{
    std::cout << "Test global !" << std::endl;
}
```
+ util.hpp
```cpp
#ifndef __UTIL__
    #define __UTIL__

    namespace Util
    {
        void test();
    }

    void test();

#endif
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Test de Util!
Test global !
```

## Espaces de noms imbriqués

Imbriquer les espaces de noms changent la portée.

Si je veux accéder une information de A dans B, `Util::test();`.

+ util.hpp
```cpp
#ifndef __UTIL__
    #define __UTIL__

    namespace Util // A
    {
        void test();
        
        namespace SubUtil // B
        {
            Util::test();
        }
    }

    void test();

#endif
```

Comme c'est un bloc de codes, on peut les imbriquer.

## Espace de nom en ligne "inline"

Ont peut écrire `inline namespace Util`.

+ util.hpp
```cpp
#ifndef __UTIL__
    #define __UTIL__

    namespace A
    {
        inline namespace B
        {

        }
    }

#endif
```

Pas d'exemple mais comprendre que l'espace de noms sera considéré comme une donnée membre.

Peut être intéressant si on a un espace de noms parent où `inline namespace B {}` cela devient une donnée membre de l'espace de nom A mais on pas abordé cette notion et il faudrait voir de la programmation objet.

Ainsi B devient une donnée membre de l'espace de nom A.

## Création d alias pour un espace de nom

+ util.hpp
```cpp
#ifndef __UTIL__
    #define __UTIL__

    namespace TooLongNamespaceName
    {

    }

    namespace TLNN = TooLongNamespaceName;

    using TLNN = ToolLongNamespaceName;

#endif
```

On peut aussi utiliser la syntaxe pour faire des alias `using TLNN` tel qu'on le faisais avec `typedef`.

Si par exemple, on veut transformer le langage C++ en langage français même si techniquement c'est faisable, je ne vous le recommande pas.

+ util.hpp
```cpp
#ifndef __UTIL__
    #define __UTIL__

    namespace TooLongNamespaceName
    {

    }

    using entier = int;

    entier n;

#endif
```

Voilà pour déclarer un entier en français.

## Conclusion

Il faut comprendre pourquoi il ne faut pas masquer la bibliothèque standard `std::` pour éviter les problèmes et l'organisation de l'ensemble de son code.

A bientôt sur le prochain chapitre de ce cours.

Ciao