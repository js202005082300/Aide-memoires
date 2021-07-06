# [[ARCHIVE] C++ #12 - méthodes et accesseurs](https://www.youtube.com/watch?v=i92LckCRooA&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=26)

On va définir un méthode simple puis une métode qui concerne l'encapsulation des données c'est-à-dire la partie accesseur.

## Créer une méthode

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

    #include <string>

    class Human
    {
        public:
            Human();
            Human(std::string name, int age);
            Human(const Human &other);

            void hello();

        private:
            std::string mName;
            int mAge;
    };

#endif
```
+ human.cpp
```cpp
#include "human.hpp"
#include <iostream>

Human::Human() : mName("Inconnu"), mAge(1)
{
}

Human::Human(std::string name, int age) : mName(name), mAge(age)
{
}

Human::Human(const Human &other)
{
    mName = other.mName;
    mAge = other.mAge;
}

void Human::hello()
{
    std::cout << "Hello !" << std::endl;
}
```
:warning: les constructeur n'ont pas de retour.


```cpp
#include "human.hpp"
#include <iostream>

int main()
{
    Human h{"Paul", 36};
    h.hello();

    return 0;
}
```
```powershell
g++ -std=c++14 *.cpp -o prog   
.\prog.exe
Hello !
```

La méthode est appelé via notre instance de classe.

## Les accesseurs getter & setter

Les attributs sont privé et manipulable uniquement par la classe par contre pour les constructeur le niveau d'accès est public sinon on ne pourrais pas créer d'objet.

Alors comment affiche t-on le prénom de l'humain ?

```txt
#include "human.hpp"
#include <iostream>

int main()
{
    Human h{"Paul", 36};
    h.hello();

    std::cout << u << std::endl;

    return 0;
}
```

Pour respecter l'encapsulation, ce n'est pas propre au niveau de programmation objet d'accéder aux attribut.

L'encapsulation c'est dire que chacune de nos classe représente un container qui lui est propre, elle gère son fonctionnement et ses propriétés et si quelqu'un doit accéder voir modifier ces attributs, c'est à un humain de le faire. Ou alors on va permettre selon une certaine couche d'abstraction à une autre classe de le faire.

**Pour accéder à un attribut, on va faire une méthode public c'est-à-dire faire une couche d'abstraction**.

Deux cas d'accésseur, les *getter* pour obtenir une information et le *setter* permet de modifier un attribut.

### getName

Le mot-clé const signifie qu'on ne va jamais modifier les données.

Ensuite dans l'implémentation si on a rien d'autre à vérifier, on fait un return de l'attribut en question.

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

    #include <string>

    class Human
    {
        public:
            Human();
            Human(std::string name, int age);
            Human(const Human &other);

            std::string getName() const;

            void hello();

        private:
            std::string mName;
            int mAge;
    };

#endif
```
+ human.cpp
```cpp
#include "human.hpp"
#include <iostream>

Human::Human() : mName("Inconnu"), mAge(1)
{
}

Human::Human(std::string name, int age) : mName(name), mAge(age)
{
}

Human::Human(const Human &other)
{
    mName = other.mName;
    mAge = other.mAge;
}

std::string Human::getName() const
{
    /*if( tu as l'autorisation ) */
        return mName;
    /*else*/
}

void Human::hello()
{
    std::cout << "Hello !" << std::endl;
}
```
+ main.cpp
```cpp
#include "human.hpp"
#include <iostream>

int main()
{
    Human hu{"Paul", 36};

    std::cout << hu.getName() << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 *.cpp -o prog
.\prog.exe                            
Paul
```

On ne veux pas qu'il accède à nos attributs pourtant par le biais d'un méthode, il peut voir ce qu'il se passe via une couche d'abstraction, des services représentés par des méthodes.

## setName

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

    #include <string>

    class Human
    {
        public:
            Human();
            Human(std::string name, int age);
            Human(const Human &other);

            std::string getName() const;
            void setName(const std::string name);

            void hello();

        private:
            std::string mName;
            int mAge;
    };

#endif
```
+ human.cpp
```cpp
#include "human.hpp"
#include <iostream>

Human::Human() : mName("Inconnu"), mAge(1)
{
}

Human::Human(std::string name, int age) : mName(name), mAge(age)
{
}

Human::Human(const Human &other)
{
    mName = other.mName;
    mAge = other.mAge;
}

std::string Human::getName() const
{
    /*if( tu as l'autorisation ) */
        return mName;
    /*else*/
}

void Human::setName(const std::string name)
{
    mName = name;
}

void Human::hello()
{
    std::cout << "Hello !" << std::endl;
}
```
+ main.cpp
```cpp
#include "human.hpp"
#include <iostream>

int main()
{
    Human hu{"Paul", 36};

    std::cout << hu.getName() << std::endl;

    hu.setName("Marc");
    //hu.mName = "Marc";

    std::cout << hu.getName() << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 *.cpp -o prog
.\prog.exe                            
Paul
Marc
```

:warning: pour le getter la méthode est constante par contre pour le setter se sont les paramètres qui sont constants mais il est préférable de les mettre quand on a aucune modification des données.

Voilà donc pour modifier, on fait `hu.setName("Marc");` au lieu d'une modification directe `hu.mName = "Marc";`.

`hu.mName = "Marc";` est contraire à l'encapsulation des données et ne fait pas partie des convention à appliquer pour ce langage.

Voilà on part du principe que ce qui est public :
    - constructeur;
    - destructeur;
    - accesseurs;
    - méthodes.
Ce qui est privé :
    - attributs.

