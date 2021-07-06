# [[ARCHIVE] C++ #10 - programmation objet](https://www.youtube.com/watch?v=I3VH14g0eMk&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=24)

## Créer une classe

Une classe est un modèle de fabrication pour illustrer un concept, par exemple l'Humain serait une classe. On instancie cette classe pour créer des objets.

En c++, généralement on a un fichier par classe `human.hpp` et un fichier pour implémenter `humain.cpp`.

On crée une classe Human qui est un genre de structure, ses attributs formeront les propriétés d'un être-humain et les comportements sont les méthodes.

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

class Human
{

};

#endif
```
+ main.cpp
```cpp
#include "human.hpp"
#include <iostream>

int main()
{
    Human h{};

    return 0;
}
```
+ human.cpp
```cpp
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
```

Ici pas d'erreur.

Le compilateur a vu qu'on avait créé une classe sans rien donc il fait une construction par défaut de l'objet Human.

## Définir un constructeur

Pour autoriser la construction dans main.cpp, il faut un objet public.

Le constructeur minimal c'est `public: Human();`, la méthode Human() est le constructeur de cette classe Human.

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

class Human
{
    public:
        Human();
};

#endif
```

## Implémenter le constructeur

+ human.cpp
```cpp
#include "human.hpp"
#include <iostream>

Human::Human()
{
    std::cout << "Construction de Human" << std::endl;
}
```

Quand aucun paramètre n'est passé en paramètre, on dit que le constructeur est par défaut mais il est un peu plus spécifique qui est fait par le compilateur comme on vu tout à l'heure.

On affiche un simple texte histoire de voir si on passe bien par cette méthode-là.

On garde notre instanciation de classe Human dans main et c'est terminé.

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

class Human
{
    public:
        Human();
};

#endif
```
+ main.cpp
```cpp
#include "human.hpp"
#include <iostream>

int main()
{
    Human h{};

    return 0;
}
```
+ human.cpp
```cpp
#include "human.hpp"
#include <iostream>

Human::Human()
{
    std::cout << "Construction de Human" << std::endl;
}
```
```powershell
g++ -std=c++14 *.cpp -o prog
.\prog.exe
Construction de Human
```

Cette fois on compile tout les fichier *.cpp

## this

this est un mot-clé qui permet d'identifier l'objet créé, identifiant de son emplacement en mémoire.

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

class Human
{
    public:
        Human();
};

#endif
```
+ main.cpp
```cpp
#include "human.hpp"
#include <iostream>

int main()
{
    Human h{};
    Human h2{};

    return 0;
}
```
+ human.cpp
```cpp
#include "human.hpp"
#include <iostream>

Human::Human()
{
    std::cout << "Construction de Human : " << this << std::endl;
}
```
```powershell
g++ -std=c++14 *.cpp -o prog
.\prog.exe
Construction de Human : 0xd778dffaef
Construction de Human : 0xd778dffaee
```

`this` permet de récupérer son adresse en mémoire, son identifiant.

Ici deux objets distinctes, deux emplacements mémoire.

## Destructeur

Un objet est une variable donc à la fin de la fonction, du programme, il est libéré de la mémoire donc si on ne le définit pas il est également par défaut mais quand on fait de l'allocation dynamique ça peut être utile de le définir.

Le destructeur c'est le nom de la classe précédé d'un tild.

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

class Human
{
    public:
        Human();
        ~Human();
};

#endif
```
+ human.cpp
```cpp
#include "human.hpp"
#include <iostream>

Human::Human()
{
    std::cout << "Construction de Human : " << this << std::endl;
}

Human::~Human()
{
    std::cout << "Destruction de Human : " << this << std::endl;
}
```
+ main.cpp
```cpp
#include "human.hpp"
#include <iostream>

int main()
{
    Human h{};
    Human h2{};

    return 0;
}
```
```powershell
g++ -std=c++14 *.cpp -o prog
.\prog.exe
Construction de Human : 0xeae63ff89f
Construction de Human : 0xeae63ff89e
Destruction de Human : 0xeae63ff89e
Destruction de Human : 0xeae63ff89f
```

Regardez le 1e créé est le dernier détruit, c'est le sens inverse de la création des instances.

Un appel au destructeur est fait au moment du return 0; dans main.