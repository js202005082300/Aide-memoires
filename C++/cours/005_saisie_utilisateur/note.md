# [5. Saisie utilisateur](https://www.youtube.com/watch?v=tkCCUzIErNU)

+ [Objet globale pour faire la lecture est Cin](#Objet-globale-pour-faire-la-lecture-est-Cin)
+ [États de cin avec les méthodes Good Fail et Bad](#États-de-cin-avec-les-méthodes-Good-Fail-et-Bad)
+ [Réinitialiser l état de cin avec la méthode Clear](#Réinitialiser-l-état-de-cin-avec-la-méthode-Clear)
+ [Lire un texte complet avec des espaces blancs avec la méthode Getline](#Lire-un-texte-complet-avec-des-espaces-blancs-avec-la-méthode-Getline)
+ [Lecture multiple](#Lecture-multiple)
    + [Objt WS pour virer les espaces blancs entre 2 lectures](#Objt-WS-pour-virer-les-espaces-blancs)
    + [Méthode Getline pour faire un appel dans le vide entre 2 lectures](#Méthode-Getline-pour-faire-un-appel-dans-le-vide)
    + [Méthode Ignore pour extraire un nombre de caractères avant un délimiteur entre 2 lectures](#Méthode-Ignore-pour-extraire-un-nombre-de-caractères-avant-un-délimiteur)

>

## Objet globale pour faire la lecture est Cin

Travaillez avec `std::cin` avec le flux dans l'autre sens `>>` pour faire nos lectures sur le flux d'entrée dont on a déjà parlé précédemment avec la mémoire tampn et le vidage de la mémoire tampon avec `std::endl` ou `std::flush`.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::cout << "Tapez un nombre entier : ";

    int number;
    std::cin >> number;

    std::cout << "Nombre saisi : " << number << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Tapez un nombre entier : 15
Nombre saisi : 15
> .\prog.exe
Tapez un nombre entier : 15 30
Nombre saisi : 15
```

Si je saisi un espace `15 30`, je ne récupère que la première partie et ce qui viens après l'espace blanc est ignoré (on verra une méthode particulière pour tout lire).

## États de cin avec les méthodes Good Fail et Bad

Concernant le comportement de `std::cin` par rapport à l'état dans lequel il peut se trouver, pour cela c++ possède un certain nombre de Flags, de drapeau, en l'occurrence le bouléen `goodbit` qui va nous indiquer s'il n'y a pas d'erreur donc par défaut quand il n'y a pas de problème c'est à 1. enfin aura `failbit` et `badbit` dont la différence est que `failbit` va concerner tout ce qui est erreur de saisie, et là `badbit` concerne une erreur générale concernant directement le flux et qui n'est pas une erreur que l'on va pouvoir corriger c'est à dire que ce n'est pas récupérable même si on tente d'autre lecture, on ne sortira pas de ce type d'erreur.

```cpp
/*
    goodbit : 1
    failbit : 0
    badbit : 0
*/
```

Au départ l'ensemble de ces valeurs sont dans cet état 1, 0, 0.

Il existe 3 méthodes qui nous retourne cet état.

```cpp
#include <iostream>
#include <string>

/*
    goodbit : 1
    failbit : 0
    badbit : 0
*/

int main()
{
    std::cout << " Good : " << std::cin.good() << std::endl;
    std::cout << " Fail : " << std::cin.fail() << std::endl;
    std::cout << " Bad : " << std::cin.bad() << std::endl;

    std::cout << "Tapez un nombre entier : ";

    int number;
    std::cin >> number;

    std::cout << "Nombre saisi : " << number << std::endl;

    std::cout << " Good : " << std::cin.good() << std::endl;
    std::cout << " Fail : " << std::cin.fail() << std::endl;
    std::cout << " Bad : " << std::cin.bad() << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
 Good : 1
 Fail : 0
 Bad : 0
Tapez un nombre entier : 15
Nombre saisi : 15
 Good : 1
 Fail : 0
 Bad : 0
```

Voilà pas de changement de valeur mais si on essaye de lire autre chose qu'un entier, on aura un changement au niveau de ces états qui nous indique qu'on a une erreur de saisie.

```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
 Good : 1
 Fail : 0
 Bad : 0
Tapez un nombre entier : m
Nombre saisi : 0
 Good : 0
 Fail : 1
 Bad : 0
```

On pourrait bien sûr faire des tests de vérification au niveau de notre programme mais on n'a pas encore vu les conditions dans ce cours mais voilà on peut vérifier ici l'état de notre objet global par rapport à ce qui est fait au niveau des lectures donc ça c'est quelque chose à contrôler qu'on verra plus tard.

Si on a une erreur sur `cin`, ce sera à nous de le réinitialiser à l'état de fonctionnement correct, de départ, pour faire de nouvelles lectures.

## Réinitialiser l état de cin avec la méthode Clear

Et pour le remettre à son état départ, on utilise la méthode clear().

```cpp
#include <iostream>
#include <string>

int main()
{
    std::cout << "Tapez un nombre entier : ";

    int number;
    std::cin >> number;

    std::cout << "Nombre saisi : " << number << std::endl;

    //Si cin est un état d'erreur...
    std::cin.clear()

    return 0;
}
```

On verra plus tard...

On va voir le cas particulier des chaîne de caractères.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::cout << "Tapez un nom complet : ";

    std::string username;
    std::cin >> username;

    std::cout << "Vous vous appelez : " << username << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Tapez un nom complet : Luc
Vous vous appelez : Luc
> .\prog.exe
Tapez un nom complet : Luc SKYWALKER
Vous vous appelez : Luc
```

si on met plusieurs informations, on perd la suite, elle a été ignoré tout simplement puisque ça s'arrête dès qu'il y a un espace blanc qui est rencontré.

## Lire un texte complet avec des espaces blancs avec la méthode Getline

Si on veut pouvoir lire un ensemble de caractère avec des espaces blancs, il faudra passer par une autre méthode que `cin` mais qui est la méthode `getline` qui est de la bibliothèque standard directement.

```cpp
std::getline()
```

Cette méthode va déjà prendre en paramètre le flux à lire est ce que vous verrez que plus tard ça ne prend pas seulement à lire le flux d'entrée de notre clavier mais nous c'est ce que nous allons faire donc `std::cin`, ensuite la chaîne de caractères dans laquelle est mémorisé l'information.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::cout << "Tapez un nom complet : ";

    std::string username;
    std::getline(std::cin, username);

    std::cout << "Vous vous appelez : " << username << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Tapez un nom complet : Luc SKYWALKER
Vous vous appelez : Luc SKYWALKER
```

Voilà par défaut la lecture s'arrêtera au retour à la ligne `\n`. 

On peut ajouter un autre délimiteur.

Par défaut avec getline(), on a `std::getline(std::cin, username, '\n');`. 

Par défaut avec cin, on a `std::getline(std::cin, username, ' ');`. 

C'est le débiteur qui arrête la saisie et ce délimiteur peut être définis tant que c'est un caractère.

## Lecture multiple

Enchaîner les lectures et lire des données différentes

```cpp
#include <iostream>
#include <string>

int main()
{
    std::cout << "Tapez un nombre entier : ";
    int number;
    std::cin >> number;

    std::cout << "Tapez votre nom complet : ";
    std::string username;
    std::getline(std::cin, username);

    std::cout << "Nombre saisi : " << number << std::endl;
    std::cout << "Vous vous appelez : " << username << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Tapez un nombre entier : 15
Tapez votre nom complet : Nombre saisi : 
Vous vous appelez :
```

Le comportement est inentendu car en validant le nombre entier, on presse enter qui est symboliser par le caractère de retour à la ligne `\n`.

Pour éviter ça, il faut faire attention à la mise en mémoire tampon de lecture, d'entrée (au début du cours, on a abordé la mise en mémoire tampon de sortie) donc à ce stade il faut vider le tampon.

### Objt WS pour virer les espaces blancs

Le plus simple est de virer tous les espaces blancs avec `std::cin >> std::ws;`.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::cout << "Tapez un nombre entier : ";
    int number;
    std::cin >> number;

    std::cin >> std::ws;

    std::cout << "Tapez votre nom complet : ";
    std::string username;
    std::getline(std::cin, username);

    std::cout << "Nombre saisi : " << number << std::endl;
    std::cout << "Vous vous appelez : " << username << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Tapez un nombre entier : 15         





```

On saisi des espaces blanc en plus du nombre `15             ` et ne permet pas de passer à la saisie suivante.

### Méthode Getline pour faire un appel dans le vide

```cpp
#include <iostream>
#include <string>

int main()
{
    std::cout << "Tapez un nombre entier : ";
    int number;
    std::cin >> number;

    std::string username;
    std::getline(std::cin, username);

    std::cout << "Tapez votre nom complet : ";
    std::getline(std::cin, username);

    std::cout << "Nombre saisi : " << number << std::endl;
    std::cout << "Vous vous appelez : " << username << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Tapez un nombre entier : 15
Tapez votre nom complet : Luc SKYWALKER
Nombre saisi : 15
Vous vous appelez : Luc SKYWALKER
```

Voilà on al'info tel qu'on voulais !

Soit `std::ws` pour les espaces qui ont suivis, pour enlever tous les espaces blancs au début du tampon d'entrée c'est-à-dire ce qui est rester en mémoire de ce tampon, soit `std::getline()` pour refaire un appel avant, dans le vide si on veut qui va capturer tous ce qui restait.

### Méthode Ignore pour extraire un nombre de caractères avant un délimiteur

Et on peut aussi extraire tous les caractères que l'on veut de l'entrée standard, du tampon d'entrée, pour pouvoir en fait les retirer et ne pas les prendre en compte par la suite et pour ça on va utiliser une autre méthode `std::cin.ignore()` qui va prendre en paramètre l'ensemble des caractères qu'on va vouloir ignorer. On peut ainsi indiquez le nombre de caractères maximum (255) et on n'oublie pas d'indiquer le caractère de fin (`\n`) genre j'extrait 255 caractères jusqu'au caractère de fin, antislash n, le retour à la ligne.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::cout << "Tapez un nombre entier : ";
    int number;
    std::cin >> number;

    std::cin.ignore(255, '\n');

    std::string username;
    std::cout << "Tapez votre nom complet : ";
    std::getline(std::cin, username);

    std::cout << "Nombre saisi : " << number << std::endl;
    std::cout << "Vous vous appelez : " << username << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Tapez un nombre entier : 15
Tapez votre nom complet : Luc SKYWALKER
Nombre saisi : 15
Vous vous appelez : Luc SKYWALKER
```

On a des outils pour avoir les limites, on peut s'arranger pour avoir le maximum de caractères pour notre saisie mais nous on se contentera de choisir une limite de 255 caractères.

Le plus pratique serra de faire une lecture dans le vide avec getline() qui va capturer entre 2 saisies les informations qui auraient rester en mémoire dont le tampon d'entrée, tampon de lecture donc ça c'est très important parce qu'on a déjà beaucoup insisté sur les histoires de tampons d'entrée et de sortie, le vidage tampon et cetera.

Alors là où on faisait un flush c'est-à-dire faire un vidage sur un sortie de sortie est quelque chose de tout à fait normal, c'est quelque chose qu'on peut avoir besoin mais attention **on ne fait pas un flush sur un tampon d'entrée** donc attention c'est très important d'accord on peut pas avoir de comportements définis c'est-à-dire le comportement où on sait ce qu'il va se passer dont on la garantie du fonctionnement donc c'est pour ça qu'on a des outils tel que `std::ignore()` pour extraire un certain nombre de caractères directement pour faire ça de manière propre et sécurisée sans problème.

Voilà c'est tout.

Au final ce qu'il faut retenir `std::cin` notre objet global pour faire la lecture. Ensuite on a nos différents états `good()`, `fail()` et `bad()` et on reviendra plus tard sur ses méthodes lorsqu'on apportera les fichiers notamment. Enfin on a finalement `ignore()` et `getline()` et `ws` dont on se servira beaucoup moins.

```cpp
/*
    std::cin -> std::cin.good(), std::cin.fail(), std::cin.bad()
    std::cin.ignore()
    std::getline()
    std::ws
*/
```

Voilà on reviendra sur ces états pour notamment contrôler les saisies, pour être sûr qu'on a bien saisis un nombre et pas autre chose on abordera dans la gestion d'erreurs.

Ciao