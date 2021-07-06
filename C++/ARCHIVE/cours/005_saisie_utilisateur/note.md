# [[ARCHIVE] C++ #5 - saisie utilisateur](https://www.youtube.com/watch?v=wqTRMfdkoNA&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=19)

## cin

Le flux d'entrée cin est un buffer et s'il est vide, il passe par un périphérique d'entrée afin d'attendre une saisie de l'utilisateur. Le flux d'entrée se fait avec des chevron vers la droite `>>` qui dirige le flux ici vers une variable qu'on affiche par exemple.

```c++
#include <iostream>

int main()
{
    int number{0};

    std::cout << "Entrez un nombre : ";
    std::cin >> number;

    std::cout << "Nombre : " << number << std::endl;

    return 0;
}
```

`std::endl` vide les données de la boîte, les données du buffer.

`"\n"` permet de retourner à la ligne mais sans vider le buffer.

```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Entrez un nombre : 14
Nombre : 14
```

## Le problème de la mémoire tampon

```c++
#include <iostream>

int main()
{
    int number{0};

    std::cout << "Entrez un nombre : ";

    std::cin >> number;
    std::cout << "Nombre : " << number << std::endl;

    std::cin >> number;
    std::cout << "Nombre : " << number << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Entrez un nombre : 14 69
Nombre : 14
Nombre : 69
```

Le buffer est vide par défaut.
On entre deux nombres séparés par un espace.
Comme l'extraction du buffer s'arrête quand on a lu une fin de chaîne, un espace blanc, il arrête la lecture.

La deuxième fois qu'on fait appel à l'objet cin, il constate que le buffer n'est pas vide avec le reste de ce qui n'a pas été lu.

Quand le buffer est vide, cin cherche le périphérique pour remplir cette mémoire tampon et en l'occurence c'est notre clavier.

## La chaîne de caractères

On crée un type de variable dechaîne de chaîne de caractères à partir de l'espace de nom de la bibliothèque standard et lié par l'opérateur de porté `::`. string, cout, cin sont des objets de la bibliothèque standard.

```c++
#include <iostream>
#include <string>

int main()
{
    std::string name{};

    std::cout << "Comment vous appelez-vous ? : "; 

    std::cin >> name;
    std::cout << "Tu t'appelles " << name << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Comment vous appelez-vous ? : Jason
Tu t'appelles Jason
```

## Le problème de la mémoire tampon avec les chaînes de caractères

```c++
#include <iostream>
#include <string>

int main()
{
    std::string name{};

    std::cout << "Comment vous appelez-vous ? : "; 

    std::cin >> name;
    std::cout << "Tu t'appelles " << name << std::endl;

    std::cin >> name;
    std::cout << "Tu t'appelles " << name << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Comment vous appelez-vous ? : Jason CHAMPAGNE
Tu t'appelles Jason
Tu t'appelles CHAMPAGNE
```

## Les méthodes de l objet cin

La gestion du buffer est faites de manière sous-jacente, il y a des contrôles pour la récupération, vérifier les erreurs de saisies.

cin est une espèce de petite boîte qui représente une entité qui permet de lire sur le buffer donc de procéder à des lectures et possède des fonctions, des méthodes.

### La méthode clear

`std::cin.clear()`

Nettoie le buffer de cin qu'il soit rempli, ou en erreur de saisie de données, on enlève l'historique de tout ce qui a pu se passer au niveau des états de l'objet.

### La méthode ignore

`std::cin.ignore(<nombre_caracteres>[, <delimateur>-> \n])`

Ignore certaines choses que nous allons lire.

Par exemple, elle peut servir à attendre quelque chose au clavier de l'utilisateur pour éviter d'utiliser la fonction system/pause sur Windows pour garder le terminal ouvert, ce qui est complétement à éviter pour des questions de sécurité.

Elle prend un nombre de caractères à ignorer et un délimiteur c'est de dire à quel moment elle s'arrête d'ignorer et par défaut ce délimiteur c'est `\n`. ignore() sans paramètre lit tous les charactères jusqu'à rencontrer le fameux `\n`.

### La méthode get ou getline

`std::cin.getline()` ou bien `std::cin.get()`

La méthode get() permet de saisir le retour à la ligne et getline() permet d'éviter d'avoir `\n`. Elles prenent en compte les espaces blancs.

`std::cin.getline(<flux>, <string> [, <delimiter>])`

```c++
#include <iostream>
#include <string>

int main()
{
    std::string name{};

    std::cout << "Comment vous appelez-vous ? : "; 

    std::getline(std::cin, name);//std::cin >> name;
    std::cout << "Tu t'appelles " << name << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Comment vous appelez-vous ? : Jason CHAMPAGNE
Tu t'appelles Jason CHAMPAGNE
```

Tout est prit en compte jusqu'au retour à la ligne.

On peut changer le délimiteur `std::getline(std::cin, name, ' ');` ce qui reviens à ne pas utiliser getline(). On peut mettre une tabulation pour arrêter la saisie `std::getline(std::cin, name, '\t');`

### Les méthodes d êtat de cin

Changement de l'état de l'objet cin, en cas d'erreur de saisie et cetera.

Plusieurs méthodes booléenne : 

`std::cin.good()` | `std::cin.bad()` | `std::cin.fail()`

good() retourne true si aucun problème sinon false.

bad() retour true si erreur sur le flux en cas d'erreur de saisie sinon false.

fail() retourne true si erreur de flux ou que la dernière extraction, la dernière action avec `std::cin` a échouée. Si bad() vaut true, fail() vaut true par contre si bad() vaut false cela signifie qu'il n'y a pas d'erreur de flux mais peut être que la dernière opération a échouée donc fail() vaut true ou false.

fail() est plus complète que bad().

### La méthode EOF

`std::cin.eof()` test la fin d'une entrée de flux (un fichier, une saisie par exemple). L'extraction dans un buffer est une saisie au clavier, un flux d'entrée. L'écriture dans un fichier est un flux de sortie.

En c++, on travaille toujours avec des flux.

## Vider un buffer

```cpp
/*
    std::cin.clear()
    std::cin.ignore()
    std::cin.good() | std::cin.bad() | std::cin.fail() | std::cin.eof()

    std::cin.getline(<flux>, <string> [, <delimiter>])
*/
```

Attention la méthode ignore() fait également une extraction, ainsi utiliser clear() avant ignore().

Pour vider un buffer, on a `std::endl;` qui intervient directement après mais on peut le faire avec clear() et ignore() mais attention à ne pas vider deux fois le buffer à la suite pour éviter d'avoir des problème donc nous devons tester.

```c++
#include <iostream>
#include <string>
#include <limits>

int main()
{
    std::string name{};

    std::cout << "Comment vous appelez-vous ? : "; 

    std::cin >> name;
    std::cout << "Tu t'appelles " << name << std::endl;

    std::cin.clear();
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

    std::cin >> name;
    std::cout << "Tu t'appelles " << name << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 main.cpp -o prog
.\prog.exe
Comment vous appelez-vous ? : Jason
Tu t'appelles Jason
Richard
Tu t'appelles Richard
```

Cette ligne `std::numeric_limits<std::streamsize>::max()` signifie que tu va ignorer le maximuximum que peut accepter un flux, et tu t'arrête une fois que tu rencontre un retour à la ligne.

:warning: ne vider pas deux de suite le buffer !

```ccp
std::cin.clear();
std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

std::cin.clear();
std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
```