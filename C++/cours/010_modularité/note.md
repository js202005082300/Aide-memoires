# [10. Modularité](https://www.youtube.com/watch?v=-bnCYbP15a8)

+ [Introduction](#Introduction)
+ [Pourquoi organiser son code ?](#Pourquoi-organiser-son-code)
+ [Création d'autres fichiers source](#Création-d-autres-fichiers-source)
+ [Création d'un fichier d'entête](#Création-d-un-fichier-d-entête)
+ [Comment fonctionnent les entêtes du standard C++ ?](#Comment-fonctionnent-les-entêtes-du-standard-C++)
+ [Éviter les inclusions circulaires](#Éviter-les-inclusions-circulaires)
+ [Organiser son programme dans des répertoires](#Organiser-son-programme-dans-des-répertoires)
+ [Conclusion](#Conclusion)

## Introduction

## Pourquoi organiser son code

+ sécurité

Question de sécurité et permet d'isoler en cas de bug, de problème de conditionnalité. Par exemple, donner la totalité du code source du O.S. de Windows à un seul employé, d'un point de vue sécurité, la modularité permet de prévenir un problème de fuite.

+ réutilisation

Créer des modules, des bibliothèques.

## Création d autres fichiers source

+ main.cpp
```cpp
#include <iostream>

int main()
{
    helloWorld();

    return 0;
}
```
+ utils.cpp
```cpp
#include <iostream>

void helloWorld()
{
    std::cout << "Hello World !" << std::endl;
}
```

## Création d un fichier d entête

On crée un fichier d'en-têtes *utils.h*, il contient la couche d'abstraction, les interfaces, les définitions des classes, des structures ect.

+ main.cpp
```cpp
#include "utils.hpp"
#include <iostream>

int main()
{
    helloWorld();

    return 0;
}
```
+ utils.cpp
```cpp
#include "utils.hpp"
#include <iostream>

void helloWorld()
{
    std::cout << "Hello World !" << std::endl;
}
```
+ utils.hpp
```h
void helloWorld();
```
```powershell
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Hello World !
```

## Comment fonctionnent les entêtes du standard C++

`#include <iostream>` et `#include <string>` sont des inclusions natives stockées dans les répertoires des fichiers d'installation du compilateur pour trouver ces fichiers d'entêtes.

Voir à l'intérieur du dossier : *mingw64\include\c++\12.1.0*, plusieurs fichier sans extension tel que *iostream* qui contient d'autres inclusions. On peut inclure des fichiers d'en-têtes dans notre fichier d'en-tête.

```h
#include <bits/c++config.h>
#include <ostream>
#include <istream>
```

On a aussi la déclaration de nos objets globaux utilisé jusqu'à présent :

```h
extern istream cin;		/// Linked to standard input
extern ostream cout;	/// Linked to standard output
extern ostream cerr;	/// Linked to standard error (unbuffered)
extern ostream clog;	/// Linked to standard error (buffered)
```

Dans *string*, on a que les définitions sans implémentation pour prit en compte par le compilateur.

Si on veut faire une interface 2D, on veut juste la documentation et ensuite le listing, l'interface, des différentes possibilités (savoir que dans cette biblothèque, je peux faire un trait, un rotation, dessiner un cercle et cetera).

Pareil pour nos fichier d'en-tête que l'on inclut mais on ne connaît pas l'implémentation.

## Éviter les inclusions circulaires

Pour éviter les inclusions multiples, si le compilateur ne sais pas dans quel ordres les traîter, il va forcément les traiter en boucle.

Si le fichier n'as pas déjà été inclut, on définit une constante et ça servira au compilateur pour savoir si ce fichier à déjà été inclut ou pas. Pour ce faire on utilise une macro `#ifndef` :

+ utils.hpp
```h
#ifndef __UTILS__
    #define __UTILS__
    
    void helloWorld();
#endif
```

Ainsi si la constante `__UTILs__` n'existe pas c'est qu'à priori le fichier n'as pas été écrit et donc je la définit `#define`

La fin de la condition `#endif`

Pour inclure d'autres fichiers (toujours des fichiers d'en-têtes) donc jamais mettre de fichiers sources dans les inclusions.

+ utils.hpp
```h
#ifndef __UTILS__
    #define __UTILS__

    #include "other.hpp"
    
    void helloWorld();
#endif
```


## Organiser son programme dans des répertoires

On change en fonction du chemin relatif.

+ bin/
    + prog.exe
+ src/
    + main.cpp
    + utils.cpp
+ include/
    + utils.hpp

+ main.cpp
```cpp
#include "../include/utils.hpp"
#include <iostream>

int main()
{
    helloWorld();

    return 0;
}
```
+ utils.cpp
```cpp
#include "../include/utils.hpp"
#include <iostream>

void helloWorld()
{
    std::cout << "Hello World !" << std::endl;
}
```
+ utils.hpp
```h
#ifndef __UTILS__
    #define __UTILS__
    
    void helloWorld();
#endif
```
```powershell
> g++ -std=c++20 -Wall -Wextra src/*.cpp -o bin/prog
> .\bin\prog.exe
Hello World !
```

On retrouve cette hiéarchisation pour les bibliothèques pré-compilées. Il est recommandé de télécharger de gros projets pour voir comment organiser cela.

## Conclusion

Bien séparer les définitions des implémentations. Pareil pour les templates qu'on verra plus tard, on sépare les choses.

Ciao ciao