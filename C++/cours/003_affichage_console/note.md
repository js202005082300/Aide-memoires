# [3. Affichage console](https://www.youtube.com/watch?v=lS4sXuTXkyI)

+ [Description](#Description)
+ [Ecrire des commentaires](#Ecrire-des-commentaires)
+ [Les 3 types de flux](#Les-3-types-de-flux)
+ [La mise en mémoire tampon](#La-mise-en-mémoire-tampon)
+ [Le retour à la ligne et les caractères spéciaux](#Le-retour-à-la-ligne-et-les-caractères-spéciaux)
+ [Le flush](#Le-flush)

## Description

```cpp
#include <iostream>

int main()
{
    std::cout << "Hello World !" << std::endl;
    return 0;
}
```

+ `std::`     bibliothèque standard, espace de nom, indique l'utilisation d'une fonctionnalité.  
+ `cout`      élément inclus dans cet espace de nom, objet d'une classe particulière, permet d'afficher sur notre sortie standard en console.  
+ `<<`        chevrons différents élément dans notre type d'objet pour l'affichage.  
+ `endl`      élément inclus dans cet espace de nom de la bibliothèque standard, signifie end line.  

## Ecrire des commentaires

```cpp
#include <iostream>

// Un commentaire court...

/*
    Un commentaire sur
    plusieurs lignes
*/

int main()
{
    std::cout << "Hello World !" << "How are you?" << std::endl;
    std::cout << "Bye!";
    return 0;
}
```

Les commentaire ne sont pas prit en compte dans la compilation.

## Les 3 types de flux

Différenciation au niveau des types de flux c'est-à-dire des zones d'affichages.

`cout` permet l'affichage, sortie standard pour afficher un simple texte.

`cerr` permet l'affichage sur la sortie d'erreur standard.

```cpp
#include <iostream>

int main()
{
    std::cout << "Hello World !" << std::endl;
    std::cerr << "Hello World !" << std::endl;
    std::cerr << "Hello World !" << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
Hello World !
Hello World !
Hello World !
```

Aucune différence entre `cout` et `cerr` sauf au niveau informatique.

`clog` concerne la journalisation tel que notre système dés qu'on connecte une usb, mettre à jours des pilotes, et cetera tout est journalisé.

## La mise en mémoire tampon

Problème des accès en mémoire (RAM plus rapide que notre vieux disque dur mécanique) donc mis en mémoire tampon puis vidange avec des flushs.

```cpp
#include <iostream>

int main()
{
    std::cout << "Hello World !";
    std::cout << "How are you ?";

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
Hello World !How are you ?
```

Ici, pas de retour à la ligne, il se contente de tout mettre en mémoire tampon puis de faire un flush puis afficher à l'écran.

`std::endl` fait un retour à la ligne et il fait ensuite un flush.

```cpp
std::cout << "Hello World !" << "How are you?" << std::endl;
```

On injecte un texte, puis un autre, un retour à la ligne et enfin on flush.

Voilà pour le tampon de sortie suivant différentes zones, zone de sortie standard, sortie d'erreur standard et on aura également le flux d'entrée, le tampon d'entrée.

```cpp
#include <iostream>

int main()
{
    std::cout << "Hello World !" << "How are you?" << std::endl;
    std::cout << "Bye!";
    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
Hello World !How are you?
Bye!
```

Voilà ça aura son importance surtout quand on travaillera plutard sur des fichiers.

En gros,

```cpp
#include <iostream>

/*
    std::cout   : affichage standard (en mémoire tampon)
    std:cerr    : erreurs (affichage direct)
    std::clog   : journalisation (en mémoire tampon)
*/

int main()
{
    std::cout << "Hello World !";
    std::cout << "How are you ?";

    return 0;
}
```

`cout` et `clog` propose une mise en mémoire tampon, on dit qu'ils sont bufferisé tandis `cerr` s'affichera directement.

L'affichage en mémoire tampon est très important quand on fait de la programmation en multi-thread surtout quand on va travailler sur des fichiers et faire la différence entre ce qui est affiché directement et ce qui est mis en mémore tampon donc l'instruction est plus rapide quand on ne fait pas de mise en mémoire.

## Le retour à la ligne et les caractères spéciaux

```cpp
#include <iostream>

/*
    std::cout   : affichage standard (en mémoire tampon)
    std:cerr    : erreurs (affichage direct)
    std::clog   : journalisation (en mémoire tampon)

    std::endl   : retour à ligne (\n) + flush

    \n          : retour à la ligne
    \t          : tabulation
    \\          : afficher un antislash
*/

int main()
{
    std::cout << "Hello World !";
    std::cout << "How are you ?";

    return 0;
}
```

`\n` est un simple caractère pour faire un retour à la ligne. Il n'est pas forcément compatible avec tout les systèmes d'exploitation mais le compilateur fait bien son boulot.

Sur windows, il faudrait faire un `\n\r` pour des compatibilités historiques.

## Le flush

Le flush vide la mémoire tampon et affiche tout ce qui a été mis dedans quand on parle de tampon de sortie.

Le tampon de sortie pour de l'affichage par exemple (on en vera d'autres) et le tampon d'entrée pour lire un clavier, un périphérique peu importe et cetera.

```cpp
#include <iostream>

/*
    std::cout   : affichage standard (en mémoire tampon)
    std:cerr    : erreurs (affichage direct)
    std::clog   : journalisation (en mémoire tampon)

    std::endl   : retour à ligne (\n) + flush
    std::flush

    \n          : retour à la ligne
    \t          : tabulation
    \\          : afficher un antislash
*/

int main()
{
    std::cout << "Hello World !";
    std::cout << "How are you ?";

    return 0;
}
```

La bibliothèque standard propose de faire un flush au niveau de notre affichage `std::flush` mais sachez que ça existe.

:warning: par contre ne jamais faire un flush sur un tampon de lecture. Ainsi quand on flush une mémoire tampon, on flush uniquement un tampon de sortie.

Voilà, on a vu ces petits objets.

Utiliser `std::endl` reviens à utiliser `std::flush` et `\n`.

```cpp
#include <iostream>

/*
    std::cout   : affichage standard (en mémoire tampon)
    std:cerr    : erreurs (affichage direct)
    std::clog   : journalisation (en mémoire tampon)

    std::endl   : retour à ligne (\n) + flush
    std::flush

    \n          : retour à la ligne
    \t          : tabulation
    \\          : afficher un antislash
*/

int main()
{
    std::cout << "Hello World !\n";

    return 0;
}
```
```powershell
g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
.\prog.exe
Hello World !
```