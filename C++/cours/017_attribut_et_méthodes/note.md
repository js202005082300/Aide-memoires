# [17. Atributs et méthodes](https://www.youtube.com/watch?v=a0_xBdcLd0Y)

+ [Introduction](#Introduction)
+ [Qu'est-ce qu'un attribut, une méthode ?](#Qu-est-ce-qu-un-attribut,-une-méthode)        
+ [Retour sur le constructeur par défaut](#Retour-sur-le-constructeur-par-défaut)
+ [Constructeur avec paramètres](#Constructeur-avec-paramètres)
+ [Application de "const" et "noexcept"](#Application-de-const-et-noexcept)
+ [Attributs de classe](#Attributs-de-classe)
+ [Liste d'initialisation](#Liste-d-initialisation)
+ [Implémentation d'une méthode](#Implémentation-d-une-méthode)
+ [Accès à un attribut depuis un objet](#Accès-à-un-attribut-depuis-un-objet)
+ [Conclusion](#Conclusion)

>

## Introduction

Représenter une fenêtre dans une application avec un constructeur par défaut `Window:Window()` et sa définition dans le fichier d'en-tête.

+ main.cpp
```cpp
#include "window.hpp"
#include <iostream>

int main()
{
    Window app{};

    return 0;
}
```
+ window.cpp
```cpp
#include "window.hpp"
#include <iostream>

Window::Window()
{
    std::cout << "Construction d'une fenetre..." << std::endl;
}
```
+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__

    class Window
    {
        public:
            Window();
    };

#endif
```

## Qu est-ce qu un attribut, une méthode

Un attribut est une variable d'une classe.

Une méthode est une fonction d'une classe.

Voilà pour le vocabulaire en POO.

## Retour sur le constructeur par défaut

Définir un constructeur enrichis càd qui possède des paramètres.

On avait vu qu'on pouvait annuler ce constructeur avec le mot `delete` :

+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__

    class Window
    {
        public:
            Window() = delete;
    };

#endif
```

On peut aussi le mettre par défaut `default` :

+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__

    class Window
    {
        public:
            Window() = default;
    };

#endif
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
window.cpp:4:1: error: definition of explicitly-defaulted 'Window::Window()'
    4 | Window::Window()
      | ^~~~~~
In file included from window.cpp:1:
window.hpp:7:13: note: 'constexpr Window::Window()' explicitly defaulted here
    7 |             Window() = default;
      |             ^~~~~~
> 
```

A partir d'ici je ne peux plus implémenter le constructeur `error: definition of explicitly-defaulted` puisque c'est au compilateur de faire ce travail ==> `Window::Window()`

+ main.cpp
```cpp
#include "window.hpp"
#include <iostream>

int main()
{
    Window app{};

    return 0;
}
```
+ window.cpp
```cpp
#include "window.hpp"
#include <iostream>

// Window::Window()
// {
//     std::cout << "Construction d'une fenetre..." << std::endl;
// }
```
+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__

    class Window
    {
        public:
            Window();
    };

#endif
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
> 
```

Voilà c'est le compilateur qui fait le constructeur.

## Constructeur avec paramètres

On crée un autre constructeur avec un paramètre String en chaîne de charactère : `Window(std::string title);` et on l'implémente donc ici c'est un `void` mais on ne l'indique pas : `void Window::Window(std::string title)`. Le type de retour sera toujours avant le nom de la méthode qui est `Window::Window`.

+ main.cpp
```cpp
#include "window.hpp"
#include <iostream>

int main()
{
    Window app{};
    Window newapp{"Mon programme GUI"};

    return 0;
}
```
+ window.cpp
```cpp
#include "window.hpp"
#include <iostream>

Window::Window(std::string title)
{
    std::cout << "Ma fenetre : " << title << std::endl;
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
            Window() = default;
            Window(std::string title);
    };

#endif
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Ma fenetre : Mon programme GUI
> 
```

Le constructeur par défaut implicite, est généré par le compilateur et nous avons un constructeur avec un paramètre qui est implémenté, qui est renseigné comme argument.

On peut donc créer plusieurs constructeurs avec des signatures différentes :

+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__

    #include <string>

    class Window
    {
        public:
            Window() = default;
            Window(std::string title);
            Window(std::string title, int width, int height);
    };

#endif
```

Pareil, je peux l'implémenter et en créer autant que je veux.

En Java par exemple, les classes ont beaucoup de constructeurs disponibles.

## Application de const et noexcept

### const

Une constante est une donnée qui ne va pas être modifiée.

Le paramètre du constructeur déclaré constant :

```cpp
Window(const std::string title);
```

Une méthode dites `const` se placerais comme ceci :

```cpp
Window(std::string title) const;
```

... et devra être noté dans l'implémentation :

```cpp
Window::Window(std::string title) const
{
    std::cout << "Ma fenetre : " << title << std::endl;
}
```

### noexcept

Permet de valider la garantie qu'une méthode ne va pas déclencher d'exception pour garantir qu'il n'y aura pas d'exception :

```cpp
Window(std::string title) noexcept;
```

... et devra être noté dans l'implémentation :

```cpp
Window::Window(std::string title) noexcept
{
    std::cout << "Ma fenetre : " << title << std::endl;
}
```

## Attributs de classe

Après on peut tester lorsqu'on lève une exception. 

On commence par déclarer un attribut `title` en privé qui est le nom de ma fenêtre, ensuite dans l'implémentation, j'initialise la valeur, et le tout avec le mot-clé `noexcept`.

+ main.cpp
```cpp
#include "window.hpp"
#include <iostream>

int main()
{
    Window app{};
    Window newapp{"Mon programme GUI"};

    return 0;
}
```
+ window.cpp
```cpp
#include "window.hpp"
#include <iostream>

Window::Window(std::string title) noexcept
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
            Window() = default;
            Window(std::string title) noexcept;

        private:
            std::string title;
    };

#endif
```

## Liste d initialisation

+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__

    #include <string>

    class Window
    {
        public:
            Window() = default;
            Window(std::string title);

        private:
            std::string title;
    };

#endif
```

On ne fait plus l'initialisation des valeurs dans l'implémentation `this->title = title;` mais avant les accolades avec l'opérateur `:` en renseignant l'attribut qui est dans la définition de notre classe `std::string title` et on indique la valeur qui sera injecté dans cet attribut :

+ window.cpp
`Window::Window(std::string t) : title(t){}`

Ainsi dans l'attribut `title` de ma classe window, j'injecte le contenu de cette variable `t`.

Voilà pour la liste d'initialisation.

### Liste de plusieurs attributs obligatoires

+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__

    #include <string>

    class Window
    {
        public:
            Window() = default;
            Window(std::string t, int w, int h) noexcept;

        private:
            std::string title;
            int width;
            int height;
    };

#endif
```
+ window.cpp
```cpp
#include "window.hpp"
#include <iostream>

Window::Window(std::string t, int w, int h) : title(t), width(w), height(h) noexcept
{
    // this->title = title;
}
```
+ main.cpp
```cpp
#include "window.hpp"
#include <iostream>

int main()
{
    Window app{"Mon programme GUI", 640, 480};

    return 0;
}
```

Voilà.

On pourrait mettre aussi des valeurs par défaut, et indiquer que si on ne précise pas une valeur, on peut mettre une valeur par défaut : `int w = 800, int h = 600`

`Window::Window(std::string t, int w = 800, int h = 600) : title(t), width(w), height(h) noexcept`

### Test de compilation

Attention comme le type `std::string` peut lever des exception, on l'enlève et on compile (si on avait que des nombres, ce serait bon) :

+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__

    #include <string>

    class Window
    {
        public:
            Window() = default;
            Window(std::string t);

        private:
            std::string title;
    };

#endif
```
+ window.cpp
```cpp
#include "window.hpp"
#include <iostream>

Window::Window(std::string t) : title(t)
{
    // this->title = title;
}
```
+ main.cpp
```cpp
#include "window.hpp"
#include <iostream>

int main()
{
    Window app{"Mon programme GUI"};

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog 
> .\prog.exe
>
```

Voilà au plus simple pour créer une fenêtre avec un titre.

## Implémentation d une méthode

Créer une méthode run() constante `const` car elle ne va pas faire de modification donc on la déclare `const`.

+ window.hpp
```cpp
#ifndef __WINDOW__
    #define __WINDOW__

    #include <string>

    class Window
    {
        public:
            Window() = default;
            Window(std::string t);
            void run() const noexcept;

        private:
            std::string title;
    };

#endif
```

Lors de l'implémentation, cette méthode fait partie de la classe donc il faut entièrement la qualifier avec le nom de la classe `Window::run()`

+ window.cpp
```cpp
#include "window.hpp"
#include <iostream>
#include <string>

Window::Window(std::string t) : title(t)
{
    // this->title = title;
}

void Window::run() const noexcept
{
    std::cout << "Affichage..." << std::endl;
}
```

Pour l'appel comme tout par d'un objet, on doit faire référence à cet objet `app.run();` avec l'opérateur de portée `.` et biensûr la méthode run() doit exister pour être appelée.

+ main.cpp
```cpp
#include "window.hpp"
#include <iostream>

int main()
{
    Window app{"Mon programme GUI"};

    app.run();

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Affichage...
```

## Accès à un attribut depuis un objet

Attention contrairement à Python, on est confronté au niveau d'accès `app.title` n'est pas possible en c++, et si on le passe public, on perd une règle de la PO qui est l'encapsulation des données.

+ main.cpp
```cpp
#include "window.hpp"
#include <iostream>

int main()
{
    Window app{"Mon programme GUI"};

    // std::cout << app.title << std::endl;

    return 0;
}
```

Ainsi `std::cout << app.title << std::endl;` n'est pas possible par sécurité, on verra comment la récupérer dans une autre vidéo.

## Conclusion

Il est recommandé de mettre un maximum d'information de sécurité `noexcept`, comme tout interdire par défaut et accepter au cas par cas. Puis l'autre mot-clé `const` si une donnée ne doit pas être modifiée ou si une méthode ne modifie pas de données. 

`const` partout permet de ce rendre compte, là ou les données ne sont pas constante. Coder intéligement.

Rappelez vous que le constructeur n'as pas de type de retour `void`.

On verra plus en détails comment accéder aux données avec cette sécurité d'encapsulation de données.

À bientôt