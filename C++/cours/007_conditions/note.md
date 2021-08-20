# [7. Conditions](https://www.youtube.com/watch?v=TcqdKWAK894)

+ [if](#if)
+ [else](#else)
+ [else if](#else-if)
+ [Tests successifs](#Tests-successifs)
+ [Initialiser une variable dans un if](#Initialiser-une-variable-dans-un-if)
+ [switch](#switch)
+ [Blocs de code](#Blocs-de-code)

Partie du cours qui va nous permettre d'effectuer des tests sur notre code et surtout d'évaluer des expressions, un peu sur ce principe de résultat booléen parce que ça va être le point central des conditions que nous allons mettre en place dans notre code.

On va faire une condition, une condition est un test.

On peut parfaitement cumuler les tests, on peut même imbriquer les conditions si on veut et à partir de là effectuer un certain nombre d'opérations si le ou les tests sont validés.

Validé sous-entend c'est le résultat vaut True  donc un résultat booléen, vrai.

## if

Le plus simple, vérifier si une structure est vide
```cpp
#include <iostream>
#include <string>

int main()
{
    bool is_empty = true;

    if(is_empty) // vaut-elle "true" ?
        std::cout << "Vide" << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Vide
```

Attention cette écriture `if(is_empty == true)` est raccourcie en faisant `if(is_empty)`.

Egalement dans d'autres langages et en c++, on peut écrire `bool is_empty = true;` mais en c++, on écrit `bool is_empty{true};`.

Si l'expression qu'on test est validé, on entre dans le if() et exécuter ses instructions. On entre dans le bloc de l'instruction définis ou non par des accolades (1 seule instruction = pas besoin d'accolades).

Ici, on vérifie l'inverse de true, `!is_empty`.
```cpp
#include <iostream>
#include <string>

int main()
{
    bool is_empty{false};

    if(!is_empty) // vaut-elle "true" ?
        std::cout << "Vide" << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Vide
```

Vérifier un nombre avec les différents opérateurs vus.

```cpp
#include <iostream>
#include <string>

int main()
{
    int number{366};

    if(number < 500 && number >= 0)
    {
        std::cout << "OK" << std::endl;
    }

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
OK
```

On rentre dans la fourchette ce qui valide la totalité de l'expression.

366 rentre dans la condition `if(number < 500 && number >= 0)` et dans la condition `if(number < 500 || number >= 0)`.

On peut imbriquer les conditions.

```cpp
#include <iostream>
#include <string>

int main()
{
    int number{366};

    if(number < 500)
    {
        std::cout << "Strictement inferieur a 500" << std::endl;

        if(number < 400)
            std::cout << "Strictement inferieur a 400" << std::endl;
    }

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Strictement inferieur a 500
Strictement inferieur a 400
```

## else

On entre dans le bloc avec notre test ou le bloc par défaut (else), pas les deux.

```cpp
#include <iostream>
#include <string>

int main()
{
    int number{366};

    if(number < 500)
    {
        std::cout << "Strictement inferieur a 500" << std::endl;
    }
    else
    {
        std::cout << "Superieur ou egal a 500" << std::endl;
    }

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Strictement inferieur a 500
```

## else if

```cpp
#include <iostream>
#include <string>

int main()
{
    int number{640};

    if(number > 500)
    {
        std::cout << "> 500" << std::endl;
    }
    else if(number > 400)
    {
        std::cout << "> 400" << std::endl;
    }
    else
    {
        std::cout << "Inferieur ou egal a 400" << std::endl;
    }

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
> 500
```

## Tests successifs

Noté qu'on peut avoir plusieurs tests sans accolades.
```cpp
/*
    if(...)
        if(...)
            if(...)
            {

            }
            else if(...)
                // une instruction
            else
                // une autre instruction
*/
```

Noté qu'on peut avoir qu'un seul else mais plusieurs else if, plusieurs cas possibles.
```cpp
/*
    if()
    if()...else
    if()...else if()
    if()...else if()
    if()...else if()...else if()...
    if()...else if()...else
    if()...else if()...else if()...else
*/
```

## Initialiser une variable dans un if

On peut également initialisé une variable dans un if() ce qui fait gagner une ligne de code.

```cpp
#include <iostream>
#include <string>

int main()
{
    if(int number{843} ; number > 500)
        std::cout << "> 500" << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
> 500
```

Pour des raisons de lisibilité, on peut l'écrire simplement comme ça.
```cpp
#include <iostream>
#include <string>

int main()
{
    int number{843};

    if(number > 500)
        std::cout << "> 500" << std::endl;

    return 0;
}
```
Des développeurs ont souhaité avoir ce genre de syntaxe dans le langage, noté également que l'initialisation est séparé de la condition par un point-virgule.

## switch

```cpp
#include <iostream>
#include <string>

int main()
{
    int code{0};

    std::cout << "Entrez un chiffre : ";
    std::cin >> code;

    switch(code)
    {
        case 1:
        case 2:
            std::cout << "Vous avez saisi 1 ou 2" << std::endl;
    }

    return 0;
}
```

Ce code est équivalent à:
```cpp
#include <iostream>
#include <string>

int main()
{
    int code{0};

    std::cout << "Entrez un chiffre : ";
    std::cin >> code;

    switch(code)
    {
        if(code == 1 || code == 2)
        {
            std::cout << "Vous avez saisi 1 ou 2" << std::endl;
        }
    }

    return 0;
}
```

Si j'ai pas envie qu'il ne traîte pas tous les cas, j'utilise l'instruction `break;`.

```cpp
#include <iostream>
#include <string>

int main()
{
    int code{0};

    std::cout << "Entrez un chiffre : ";
    std::cin >> code;

    switch(code)
    {
        case 1:
            std::cout << "Vous avez saisi 1" << std::endl;
            break;
        case 2:
            std::cout << "Vous avez saisi 2" << std::endl;
            break;
        case 3:
            std::cout << "Vous avez saisi 3" << std::endl;
            break;
    }

    return 0;
}
```

Pratique si on ne veux traiter qu'un seul des cas possible.

Gérer un cas par défaut avec `default`

```cpp
#include <iostream>
#include <string>

int main()
{
    int code{0};

    std::cout << "Entrez un chiffre : ";
    std::cin >> code;

    switch(code)
    {
        case 1:
            std::cout << "Vous avez saisi 1" << std::endl;
            break;
        case 2:
            std::cout << "Vous avez saisi 2" << std::endl;
            break;
        case 3:
            std::cout << "Vous avez saisi 3" << std::endl;
            break;
        default:
            std::cout << "Code non reconnu" << std::endl;
            break;
    }

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Entrez un chiffre : 1
Vous avez saisi 1
> .\prog.exe
Entrez un chiffre : 2
Vous avez saisi 2
> .\prog.exe
Entrez un chiffre : 3
Vous avez saisi 3
> .\prog.exe
Entrez un chiffre : 64
Code non reconnu
```

Voilà le default prend tous les autres cas en compte.

On peut aussi initialiser une donnée comme ceci pour la prendre en compte dans notre switch.

```cpp
switch(int data{0} ; code)
{

}
```

## Blocs de code

```cpp
#include <iostream>
#include <string>

int main()
{
    int number{15};

    std::cout << number << std::endl;

    return 0;
}
```

Le bloc est délimité par des accolades, ceci représente le contexte de ma fonction:
```cpp
    int number{15};

    std::cout << number << std::endl;

    return 0;
```

Maintenant, je peux créer un bloc dans un autre, une pièce dans une pièce, ouvrir des accolades dans le contexte de ma fonction.

```cpp
#include <iostream>
#include <string>

int main()
{
    int number{15};

    std::cout << number << std::endl;

    {
        std::cout << number << std::endl;
    }

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
15
15
```

On a accès ici à des éléments parent du contexte parent sans problème mais l'inverse n'est pas possible.

```cpp
#include <iostream>
#include <string>

int main()
{
    int number{15};

    std::cout << number << std::endl;

    {
        int other_number{8};
    }

    std::cout << other_number << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
main.cpp: In function 'int main()':
main.cpp:11:13: error: unused variable 'other_number' [-Werror=unused-variable]
   11 |         int other_number{8};
      |             ^~~~~~~~~~~~
main.cpp:14:18: error: 'other_number' was not declared in this scope
   14 |     std::cout << other_number << std::endl;
      |                  ^~~~~~~~~~~~
cc1plus.exe: all warnings being treated as errors
```

Voyez que `'other_number' was not declared in this scope` avec scope qui est la portée dans le quel nous sommes c'est-à-dire qu'à ce stade il est incapable de dire ce qu'il se passer dans ce bloc-là.

```cpp
    {
        int other_number{8};
    }
```

Voilà on comprendra que ce bloc là a un droit d'accès là où il a été créé par contre tout ce qu'il y a autour de ce bloc n'a pas accès à l'intérieur.

```cpp
#include <iostream>
#include <string>

int main()
{
    int number{15};

    std::cout << number << std::endl;

    //...

    std::cout << other_number << std::endl;

    return 0;
}
```

Voilà ce qu'il y a autour n'a pas accès à notre bloc interne donc automatiquement ça ne communique pas dans les 2 sens.

C'est la portée des variables ici que nous devons bien comprendre.

Ce que l'on vient de voir ici est également valable pour les conditions, admettons le code suivant où on va retrouver le même principe.

```cpp
#include <iostream>
#include <string>

int main()
{
    int number{15};

    if(number == 15)
    {
        std::cout << number << std::endl;

        std::string s{"Hello"};
    }

    std::cout << s << std::endl;
    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
main.cpp: In function 'int main()':
main.cpp:15:18: error: 's' was not declared in this scope
   15 |     std::cout << s << std::endl;
      |                  ^
```

Il ne retrouve pas `s` parce que ni avant ni après la condition, nous n'avons pas déclaré de variable qui s'appelle `s` donc admettons maintenant qu'on décide de changer notre `s` dans ce bloc de condition.

```cpp
#include <iostream>
#include <string>

int main()
{
    int number{15};
    std::string s{"Hello"};

    std::cout << s << std::endl;

    if(number == 15)
    {
        std::cout << number << std::endl;
        s = "Hello World !";
    }

    std::cout << s << std::endl;
    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
Hello
15
Hello World !
```

Voilà notre information a été changée parce qu'on l'a créé d'abord dans notre bloc principal de la fonction main(), ensuite notre bloc de condition a connaissance de cette information et il modifie cette valeur (on verra aussi la portée des modifications parce qu'on va avoir une histoire de copie et de référence qui sont des notions que l'on verra un petit peu plus tard) mais retenez d'abord que ici on a bien modifié notre valeur `s = "Hello World !";` donc là pas de problème le changement a bien été pris en compte.

Ainsi même si le changement a eu lieu dans ce bloc (de condition) parce que cette variable a été créé dans le bloc parent et elle ne sera détruite qu'a partir de `return 0;`.

## Portée des variables

Alors lorsqu'on parle de durée de vie, on sous entend cette fameuse portée donc ici on commence par déclarer et initialiser une variable donc c'est sa création tout simplement.

```cpp
#include <iostream>
#include <string>

int main()
{
    int number{15};
    std::string s{"Hello"}; // s est déclarée et initialisée

    return 0;
}
```

À la fin du contexte où cette variable `s` a été créé donc en l'occurrence ici à la fin de la fonction `…}`, cette variable est détruite, elle est libérée de la mémoire et elle n'existe plus.

On verra la même chose lorsqu'on va créer des fonctions où tout ce que l'on va créer dans une fonction sera détruit à la fin de cette fonction et donc ne pourra pas forcément exister ailleurs donc c'est des choses qu'on abordera bien en détails parce que c'est très important en programmation.

Donc la portée des variables où ce qu'il y a dans un bloc enfant a une visibilité sur les blocs parents mais pas l'inverse c'est-à-dire qu'une variable qui est créée dans un bloc enfant ne sera pas accessible depuis la portée du parent.


```cpp
#include <iostream>
#include <string>

int main()
{
    int number{15};
    std::string s{"Hello"};

    {
        // Peut accéder à ce qu'il y a dans le bloc parent, mais pas l'inverse.
    }

    return 0;
}
```

Voilà pour cette séance.

En plus de la portée des variables qui va nous suivre tout au long de cette formation, c'est la possibilité de faire nos conditions avec ces 3 mots clés `if … else if … else` qui sont à connaître, et quand on veut avoir un ensemble de tests assez conséquent, on va utiliser `switch()` pour condenser l'écriture. Voilà ce que nous avons vu dans la vidéo en plus avec la possibilité d'initialiser dans la condition ou dans le switch() qui sont également possibles depuis quelques mises à jour de c++.

Voilà pour les conditions dans la séance suivante nous verrons les boucles c'est à dire de faire de la répétition de code si on a besoin de répéter un certain nombre d'instructions qui se traduiront par un certain nombre de mots clés et formeront leur bloc de code sur le même principe que le if(){}, le else{}, le switch{} et bien là on aura des blocs de code également pour les boucles avec une vérification qui sera faite c'est-à-dire une expression qui sera évoluée comme pour les conditions sur le même principe on aura des tests qui seront faits et en fonction du résultat du test, il va se passer un certain nombre de choses au niveau de l'exécution de nos boucles et de tout ce qui suivra derrière.

À bientôt pour la suite de ce cours en c++