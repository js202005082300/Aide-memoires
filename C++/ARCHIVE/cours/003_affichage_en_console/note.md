# [[ARCHIVE] C++ #3 - affichage en console](https://www.youtube.com/watch?v=CMx1WOVXkW0&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=17)

## cout est une instance de ios_base

+ ios_base : classe qui gère les entrées/sorties (affichage), instancié, on crée un objet, une version de cette classe pour obtenir cout
+ cout : c pour char (caractère) et out pour sortie
+ endl : end of line pour faire un retour à la ligne. On fait un flush càd qu'on vide la mémoire tampon, et à chaque appel de cout, on réutilise la même instance.


```cpp
#include <iostream>

/* commentaire sur
plusieurs lignes */

// Commentare sur une seule ligne

int main()
{
    std::cout << "Bonjour tout le monde" << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Bonjour tout le monde
```

    + cout : gère la sortie standard pour des caractères.
    + cerr : permet d'afficher sur la sortie d'erreur standard.
    + clog : export dans un fichier pour analyser les erreurs d'un programme.

wchar : type plus moderne que char qui permet de travailler avec d'autres encodages, avec des accents. Pour gérer wchar, on a :
    + wcout
    + wcerr
    + wclog

## Changer le format affichage et le principe du flux

### En héxadécimal

Changer le format d'affichage d'un nombre en dur en héxadécimale grâce à cout instancié de ios_base. Tout les affichage après `std::cout << std::hex;` seront en héxadécimal.

```cpp
#include <iostream>

/*
Décimal : 0 à 9
Octale  : 0 à 7
Hexa.   : 0 à 9 puis A à F
*/

int main()
{
    std::cout << std::hex;
    std::cout << 146 << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
92
```

### En octale

```cpp
#include <iostream>

/*
Décimal : 0 à 9
Octale  : 0 à 7
Hexa.   : 0 à 9 puis A à F
*/

int main()
{
    std::cout << std::oct;
    std::cout << 146 << std::endl;
    std::cout << 18 << std::endl;
    std::cout << std::dec << 1466 << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
222
22
1466
```

C'est le même cout à chaque affichage, la même instance de classe std. Il faut rechanger le format pour revenir au format décimale.

On peut tout mettre sur une seule ligne.

```cpp
#include <iostream>

int main()
{
    std::cout << std::oct << 146 << std::endl << 18 << std::endl << std::dec << 1466 << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
222
22
1466
```

La conversion se met en **mémoire tampon** sans modifier la valeur. Quand on a std::endl, on affiche le contenu de la mémoire tampon et on la vide (flush) et on réutilise cette boîte au prochain affichage.

Voilà comment fonctionne le principe de flux en c++

## Les fonctions incluses dans iostream et iomanip

![fonctions.PNG](fonctions.PNG)

Voilà pour changer le format d'affichage.

Par défaut on a `std::dec` et `std::defaultfloat`.

Par exemple la notation scientifique.

```cpp
#include <iostream>

int main()
{
    std::cout << std::scientific << 14.155464 << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
1.415546e+01
```

Pour revenir au comportement par défaut, il faut faire `std::cout << std::defaultfloat`.

Ensuite `std::boolalpha` affiche la valeur littérale true/false au lieu de 1/0.

`std::showbase` affiche le préfixe `o...` (base octale) ou aussi `0xAF..` (base hexa.).

`std::noshowpoint` est la valeur par défaut.

```cpp
#include <iostream>

int main()
{
    std::cout << "Normal : " << 1.0 << std::endl;
    std::cout << "Showpoint : " << std::showpoint << 1.0 << std::endl;
    std::cout << "Noshowpoint : " << std::noshowpoint << 1.0 << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Normal : 1
Showpoint : 1.00000
Noshowpoint : 1
```

`std::showpos` affiche le symbole le signe positif (+) ou négatif (-).

`std::uppercase` affiche les notation scientifique en majuscule `E..`, `0XAF...`.

`std::setw` insère des espaces.

```cpp
#include <iostream>
#include <iomanip>

int main()
{
    std::cout << "         W" << std::endl;
    std::cout << std::setw(10) << "W" << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
         W
         W
```

`std::setfill` insère des caractères choisis. Ici on prépare la mémoire tampon pour un affichage et je dit que le caractère de remplissage par défaut au lieu d'espace blanc c'est un tiret.

```cpp
#include <iostream>
#include <iomanip>

int main()
{
    std::cout << std::setfill('-') << std::setw(10) << "W" << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
---------W
```

`std::left` et `std::right`

```cpp
#include <iostream>
#include <iomanip>

/*
    std::left   ->  W---------
    std::right  ->  ---------W
*/

int main()
{
    std::cout << std::left << std::setw(10) << "W" << std::endl;
    std::cout << std::right << std::setw(10) << "W" << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
W
         W
```
