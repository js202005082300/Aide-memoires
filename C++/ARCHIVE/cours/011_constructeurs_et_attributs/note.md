# [[ARCHIVE] C++ #11 - constructeurs et attributs](https://www.youtube.com/watch?v=s6dnU0MEUms&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=25)

## Déclarer des attributs

On ajoute les propriétés au modèle de construction de notre classe Human.

Accès privé pour les attributs, propriétés de notre classe. L'être humain est seul à pouvoir manipuler ce qui est accéssible en privé. L'attribut peut être un type, un tableau, une structure voir un objet d'une autre classe.

```cpp
private
    Animal an;
```

On va définir une propriété de nom, par convention `mName`, et on va devoir inclure un fichier d'en-tête dans notre fichier d'en-tête même si généralement `string` est mis dans le fichier source. On ajoute également un âge.

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

    #include <string>

    class Human
    {
        public:
            Human();
            ~Human();
        
        private:
            std::string mName;
            int mAge;
    };

#endif
```

## Implémenter des attributs dans le constructeur

Soit on accède depuis le mot-clé `this` soit on utilise le nom qu'on a donné pour l'attribut. On met des valeurs par défaut.

+ human.cpp
```cpp
#include "human.hpp"
#include <iostream>

Human::Human()
{
    mName = "Inconnu"; //ou this->mName
    mAge = 1;
    
    std::cout << "Construction de Human" << std::endl;
}

Human::~Human()
{
    std::cout << "Destruction de Human" << std::endl;
}
```

# 1e - définir un constructeur avec paramètres optionnels

Ainsi s'il n'y a pas de nom ou d'âge, je met autre chose.

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

    #include <string>

    class Human
    {
        public:
            Human(std::string name = "Inconnu", int age = 1);
            ~Human();
        
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

Human::Human(std::string name = "Inconnu", int age = 1)
{
    mName = name;
    mAge = age;
}

Human::~Human()
{
    std::cout << "Destruction de Human" << std::endl;
}
```

On définit les valeurs ou alors c'est le constructeur par défaut qui s'en occupe.

## 2e - définir un constructeur particulier

Par exemple, on va pouvoir créer un humain juste en renseignant son nom.

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

    #include <string>

    class Human
    {
        public:
            Human(std::string name);
            ~Human();
        
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

Human::Human(std::string name)
{
    mName = name;
    mAge = 1;
}

Human::~Human()
{
    std::cout << "Destruction de Human" << std::endl;
}
```

Voilà ici le nom est obligatoire par contre pour l'âge, on renseigne une valeur par défaut.

### Définir un constructeur complet

Un constructeur qui va initialiser toutes les propriétés.

On va définir une méthode Human() en plus donc une surcharge de constructeur.

Le compilateur choisira le bon constructeur en fonction.

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

    #include <string>

    class Human
    {
        public:
            Human(); // constructeur par défaut.
            Human(std::string name); // constructeur particulier.
            Human(std::string name, int age); //toutes les infos sont obligatoires.
            ~Human();
        
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

Human::Human(std::string name)
{
    mName = name;
    mAge = 1;
}

Human::Human(std::string name, int age)
{
    mName = name;
    mAge = age;
}

Human::~Human()
{
    std::cout << "Destruction de Human" << std::endl;
}
```

:warning: au minimum on garde un constructeur vide `Human();` et ensuite les constructeur que vous voulez par rapport aux paramètres que vous voulez rendre obligatoire ou non.

Voilà au moins un constructeur par défaut plutôt que de laisser le compilateur faire ça.

Par exemple si je fait ceci.

+ main.cpp
```cpp
#include "human.hpp"
#include <iostream>

int main()
{
    Human h{"Richard"};

    return 0;
}
```

... cela appelle ce constructeur :

```cpp
Human::Human(std::string name)
{
    mName = name;
    mAge = 1;
}
```

Et cetera.

Si je fait ceci.

Le constructeur adéquat serra choisit en fonction de la manière dont vous créer l'objet.

### Un constructeur par défaut et plusieurs constructeurs particuliers

+ human.cpp
```cpp
#include "human.hpp"
#include <iostream>

Human::Human()
{
    mName = "Inconnu";
    mAge = 1;
}

Human::Human(std::string name)
{
    mName = name;
    mAge = 1;
}

Human::Human(std::string name, int age)
{
    mName = name;
    mAge = age;
}

//Human::~Human()
//{
//    std::cout << "Destruction de Human" << std::endl;
//}
```
+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

    #include <string>

    class Human
    {
        public:
            Human();
            Human(std::string name);
            Human(std::string name, int age);
            //~Human();
        
        private:
            std::string mName;
            int mAge;
    };

#endif
```
+ main.cpp
```cpp
#include "human.hpp"
#include <iostream>

int main()
{
    Human h{"Richard"};
    Human h2{"Paul", 26};

    return 0;
}
```
```powershell
g++ -std=c++14 *.cpp -o prog
.\prog.exe
```

## Raccourcir une implémentation avec deux points

+ human.cpp
```cpp
#include "human.hpp"
#include <iostream>

Human::Human() : mName("Inconnu"), mAge(1)
{
}

Human::Human(std::string name) : mName(name), mAge(1)
{
}

Human::Human(std::string name, int age) : mName(name), mAge(age)
{
}
```
+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

    #include <string>

    class Human
    {
        public:
            Human();
            Human(std::string name);
            Human(std::string name, int age);
            //~Human();
        
        private:
            std::string mName;
            int mAge;
    };

#endif
```
+ main.cpp
```cpp
#include "human.hpp"
#include <iostream>

int main()
{
    Human h{"Richard"};
    Human h2{"Paul", 26};

    return 0;
}
```
```powershell
g++ -std=c++14 *.cpp -o prog
.\prog.exe
```

## 3e - définir un constructeur par copie

Constructeur qui va cloner un objet pour un créer un autre.

Par exemple une copie de Marcel h1 dans h2.

+ main.cpp
```cpp
#include "human.hpp"
#include <iostream>

int main()
{
    Human h1{"Marcel", 46};
    Human h2{h1};

    return 0;
}
```

Pour contrôler la copie, il faut créer un constructeur particulier parce qu'on ne veut pas tout copier.

On passe l'élément à copier en `const` parce qu'on ne va pas le modifier.

+ human.hpp
```cpp
#if !defined(__HUMAN__)
#define __HUMAN__

    #include <string>

    class Human
    {
        public:
            Human();
            Human(std::string name);
            Human(std::string name, int age);
            Human(const Human &other);
        
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

Human::Human(std::string name) : mName(name), mAge(1)
{
}

Human::Human(std::string name, int age) : mName(name), mAge(age)
{
}

Human::Human(const Human &other)
{
    mName = other.mName; //this.mName
    mAge = other.mAge;
}
```
```powershell
g++ -std=c++14 *.cpp -o prog
.\prog.exe
```

On ne peut pas afficher les valeurs parce qu'elle sont `private`.

Alors ici on passe nos données en constante avec le mot-clé `const` parce qu'elle ne sera pas modifiée.

Voilà nous avons **surcharger** la méthode du constructeur, plusieurs version d'une seule méthode en fonction du contexte.