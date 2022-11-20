# [18. Encapsulation](https://www.youtube.com/watch?v=50ChszaNyMU)

+ [Introduction](#Introduction)
+ [Qu'est-ce que l'encapsulation ?](#Qu-est-ce-que-l-encapsulation)
+ [Accesseurs et modificateurs](#Accesseurs-et-modificateurs)
+ [Définir un accesseur (lecture)](#Définir-un-accesseur-lecture)
+ [Définir un modificateur (écriture)](#Définir-un-modificateur-écriture)
+ [Précautions sur les méthodes](#Précautions-sur-les-méthodes)
+ [Conclusion](#Conclusion)

>

## Introduction

+ main.cpp
```cpp
#include "window.hpp"
#include <iostream>

int main()
{
    Window app{"Mon application graphique"};

    return 0;
}
```
+ window.cpp
```cpp
#include "window.hpp"
#include <iostream>
#include <string>

Window::Window(std::string title) : title(title)
{

}
```
+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__
    #include <string>

    class Window
    {
        public:
            Window(std::string title);

        private:
            std::string title;
    };

#endif
```

## Qu est-ce que l encapsulation

Permet de contrôler la portée de nos attributs de notre classe.

Les attributs privés ne seront pas accessible en lecture ou en écriture en dehors de nos classes.

Les attributs sont mis en relations via des attributs et des méthodes, surtout pour les attributs privés. Ces méthodes sont publics, ce sont les Accesseurs et modificateurs.

## Accesseurs et modificateurs

L'accesseurs permet de lire la donnée.

`std::string getTitle() const;`

Le modificateur permet de modifier.

## Définir un accesseur lecture

Par exemple si on veux gérer l'attribut `title`.

+ main.cpp
```cpp
#include "window.hpp"
#include <iostream>

int main()
{
    Window app{"Mon application graphique"};

    std::cout << app.getTitle() << std::endl;

    return 0;
}
```
+ window.cpp
```cpp
#include "window.hpp"
#include <iostream>
#include <string>

Window::Window(std::string title) : title(title)
{
}

std::string Window::getTitle() const
{
    return this->title;
}
```
+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__
    #include <string>

    class Window
    {
        public:
            Window(std::string title);
            std::string getTitle() const;
        private:
            std::string title;
    };

#endif
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Mon application graphique
> 
```

Le principe de la PO est d'apporter une couche d'abstraction.

On ne dévoile pas les implémentations, on parle de services et de fonctionnalités.

On pourrait se contenter de `return` mais on pourrait tester les droits d'utilisateur, créer un accesseur sous certaines conditions.

## Définir un modificateur écriture

On déclare le titre constant car on ne va pas le modifier : `void setTitle(const std::string title)`

+ main.cpp
```cpp
#include "window.hpp"
#include <iostream>

int main()
{
    Window app{"Mon application graphique"};

    std::cout << app.getTitle() << std::endl;
    app.setTitle("Mon nouveau titre");
    std::cout << app.getTitle() << std::endl;

    return 0;
}
```
+ window.cpp
```cpp
#include "window.hpp"
#include <iostream>
#include <string>

Window::Window(std::string title) : title(title)
{
}

std::string Window::getTitle() const
{
    return this->title;
}

void Window::setTitle(const std::string title)
{
    this->title = title;
}
```
+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__
    #include <string>

    class Window
    {
        public:
            Window(std::string title);
            std::string getTitle() const;
            void setTitle(const std::string title);
        private:
            std::string title;
    };

#endif
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Mon application graphique
Mon nouveau titre
```

## Précautions sur les méthodes

Lever une exception si l'attribut ne répond pas aux conditions de modifications.

+ main.cpp
```cpp
#include "window.hpp"
#include <iostream>

int main()
{
    Window app{"Mon application graphique"};

    std::cout << app.getTitle() << std::endl;
    app.setTitle("Mon nouveau titre qui est un peu trop long pour l'interface graphique");
    std::cout << app.getTitle() << std::endl;

    return 0;
}
```
+ window.cpp
```cpp
#include "window.hpp"
#include <iostream>
#include <string>

Window::Window(std::string title) : title(title)
{
}

std::string Window::getTitle() const
{
    return this->title;
}

void Window::setTitle(const std::string title)
{
    if(title.length() > 20)
        throw new std::invalid_argument("Le nom de la fenetre doit comporter 20 caracteres max");
        
    this->title = title;
}
```
+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__
    #include <string>

    class Window
    {
        public:
            Window(std::string title);
            std::string getTitle() const;
            void setTitle(const std::string title);
        private:
            std::string title;
    };

#endif
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Mon application graphique
terminate called after throwing an instance of 'std::invalid_argument*'
> 
```

Voilà on lève une exception qui n'as pas été capturée.

Si le titre est plus court :

+ main.cpp
```cpp
app.setTitle("Mon nouveau titre qui est un peu trop long pour l'interface graphique");
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Mon application graphique
Mon nouveau titre
>
```

## Conclusion

L'encapsulation est le fait de masquer des données, cacher de l'implémentation et proposer une interface à l'utilisateur soit des briques logiciels.

Si l'attribut par défaut ne doit pas être accessible depuis l'extérieur, laisser tel quel.

Implementer ces méthodes si besoin :

```cpp
std::string getTitle() const;
void setTitle(const std::string title);
```

Les accesseurs sont aussi un moyen de récupérer des données traitées. Par exemple retourner le périmètre d'une fenêtre si on a la longueur et la largeur en données privées.

Par exemple,

```cpp
std::string getSomething() const
{
    return this->A + this->B;
}
```

Voilà on continue sur la programmation objet.

À bientôt