# [6. Opérations](https://www.youtube.com/watch?v=CZ03XvQySsY)

+ [Opérateurs Arithmétiques     + - * / %](#Opérateurs-Arithmétiques)
+ [Opérateurs booléens          ! && ||](#Opérateurs-booléens)
+ [Opérateur de comparaison     < <= > >= == !=](#Opérateur-de-comparaison)
+ [Opérateurs Divers            += -= *= /= %= ++ --](#Opérateurs-Divers)
+ [Différence entre pre- et post incrémentation](#Différence-entre-pre--et-post-incrémentation)

On a vu l'opérateur d'affectation (=) qui permet de changer la valeur d'une variable bien après qu'elle soit déclarée et/ou initialisée. On a l'opérateur de flux (<<) tel qu'on l'utilisait pour cout, et l'autre coté (>>) pour cin. Puis l'opérateur de résolution de portée (::) et cetera.

Pour info,
```cpp
namespace A {
  class B { /* ... */ };
  int i;
}
 
void f(void) {
  // Je veux instancer  un objet de type B.
  B mon_b; // ERREUR : B n'existe pas.
  A::B mon_b; // OK, on a précisé que B était définit dans A.
 
  // Je veux modifier i.
  i = 42; // ERREUR : i n'est pas définit.
  A::i = 42; // OK.
```

## Opérateurs Arithmétiques

% est le reste de la division euclidiènne, sert beaucoup en informatique notamment en cryptographie.

```cpp
#include <iostream>
/*
    Arithmétiques : + - * / %
*/

int main()
{
    int result;
    result = 5 + 5 - 2;
    std::cout << "5 + 5 - 2 = " << result << std::endl;
    result = 5 - 16;
    std::cout << "5 - 16 = " << result << std::endl;
    result = 5 - 2 * 3;
    std::cout << "5 - 2 * 3 = " << result << std::endl;
    result = (5 - 2) * 3;
    std::cout << "(5 - 2) * 3 = " << result << std::endl;
    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog     
> .\prog.exe                                                
5 + 5 - 2 = 8
5 - 16 = -11
5 - 2 * 3 = -1
(5 - 2) * 3 = 9
```

Avec `5 - 16`, le résultat est un entier relatif, ce qui n'est pas accepté si l'entier est non signé `unsigned int result;`. Également attention aux divisions par zéro.

Attention aux priorités ici `5 - 16 * 3`: *, / et % sont prioritaires sur + et -. Noté que les parenthèse change l'ordre de priorité.

## Opérateurs booléens

Opérateur qui prend deux valeurs possibles : vrai ou faux.

L'opérateur de négation, le NOT, un point d'intérrogation (!), puis le ET (&&) et le OU (||).

```cpp
#include <iostream>
/*
    Arithmétiques   : + - * / %
    Booléens        : ! && ||
*/

int main()
{
    int result;
    result = 6 && 6;
    std::cout << "6 && 6 = " << result << std::endl;

    result = true && true;
    std::cout << "true && true = " << result << std::endl;

    result = true && false;
    std::cout << "true && false = " << result << std::endl;

    result = true;
    std::cout << "true = " << result << std::endl;

    result = !true; // négation de V = F
    std::cout << "!true = " << result << std::endl;

    result = true && true || false;
    std::cout << "!true = " << result << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog     
> .\prog.exe  
6 && 6 = 1
true && true = 1
true && false = 0
true = 1
!true = 0
(true && true) || false = 1
```

Le résultat de `6 && 6` vaut 1 car on a évaluer l'expression à Vrai (1) mais on peut travailler sur des valeurs booléennes pour être plus clair `true && true` donc ici ce serra vrai uniquement si les deux opérandes sont vrais. Si un des deux est faux, le ET (&&) n'est plus respecté donc le résultat sera false (0).

`!` donne l'inverse, la négation de true. Cette condition consiste à vérifier si la négation de vrai est égal à faux ?

Le NOT (!) est prioritaire au ET (&&) qui est lui-même prioritare au OU (||).

## Opérateur de comparaison

```cpp
#include <iostream>
/*
    Arithmétiques   : + - * / %
    Booléens        : ! && ||
    Comparaison     : < <= > >= == !=
*/

int main()
{
    int result;
    result = 5 < 9;
    std::cout << "5 < 9 : " << result << std::endl;

    result = 5 == 9;
    std::cout << "5 == 9 : " << result << std::endl;

    result = 5 != 9;
    std::cout << "5 == 9 : " << result << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog     
> .\prog.exe  
5 < 9 : 1
5 == 9 : 0
5 == 9 : 1
```

Ne pas hésiter à appliquer des parenthèses pour rendre la relecture plus clair.

## Opérateurs Divers

L'erreur des débutant en jeu vidéo est d'augmenter le niveau du joueur de manière statique, brut, par exemple le joueur passe du niveau 35 à 2 au lieu de penser de manière dynamique.

```cpp
#include <iostream>
/*
    Arithmétiques   : + - * / %
    Booléens        : ! && ||
    Comparaison     : < <= > >= == !=
    Divers          : += -= *= /= %= ++ --
*/

int main()
{
    // int player_level{35};
    // std::cout << "Niveau actuel : " << player_level << std::endl;
    // player_level = 2;
    // std::cout << "Niveau actuel : " << player_level << std::endl;

    int player_level{1};
    std::cout << "Niveau actuel : " << player_level << std::endl;

    player_level = player_level + 1;
    std::cout << "Niveau actuel : " << player_level << std::endl;

    player_level += 1;
    std::cout << "Niveau actuel : " << player_level << std::endl;

    player_level += 2;
    std::cout << "Niveau actuel : " << player_level << std::endl;

    player_level *= 2;
    std::cout << "Niveau actuel : " << player_level << std::endl;

    player_level++;
    std::cout << "Niveau actuel : " << player_level << std::endl;

    ++player_level;
    std::cout << "Niveau actuel : " << player_level << std::endl;

    return 0;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog     
> .\prog.exe  
Niveau actuel : 1
Niveau actuel : 2
Niveau actuel : 3
Niveau actuel : 5
Niveau actuel : 10
Niveau actuel : 11
Niveau actuel : 12
```

## Différence entre pre- et post incrémentation

La différence entre `player_level++;` et `++player_level;` est l'ordre de priorité des calculs qui sont fait lors de priorité de l'évaluation complète de notre expression.

```cpp
/*
    Arithmétiques   : + - * / %
    Booléens        : ! && ||
    Comparaison     : < <= > >= == !=
    Divers          : += -= *= /= %= ++ --

    (0)
    data++ : data + 1 -> 1
    ++data : 1 + data -> 1
*/
```

Si ma donnée vaut (0) et que je fait une post-incrémentation, cela donne 1 pareil avec une pré-incrémentation. On a bien quelque chose qui est inversé mais on retrouve bien la même chose à l'arrivé.

La différence vient quand je fais une nouvelle affectation.

```cpp
/*
    result = data++;
    result = ++data;
*/
```

Là où les gens peuvent rencontrer un problème c'est lorsqu'il y a une affectation `result = data++;` et `result = ++data;` où un nouvel opérateur est ajouté qui est le `=` c'est-à-dire l'opérateur d'affectation et qui va faire partie de l'expression. Ainsi l'expression qui va être évaluée ce n'est plus seulement `data++` mais il y a aussi ce `=` qui va rentrer dans l'expression forcément parce qu'il va y avoir une affectation à cette variable `result` et c'est là que l'ordre va changer.

Ce qui va changer ? C'est que quand les opérateurs `++` sont après, on parle d'une post incrémentation et si c'était avec `--` ce serait une poste décrémentation. Alors qu'est ce qu'il va se passer ? On va récupérer l'ancienne valeur de data et on incrémenterais de 1 par la suite donc dans ce cas `result = data++;`, on va se retrouver avec l'ancienne valeur de data dans result donc si `data = 0` alors `result = 0` et après data va augmenter de 1 (data + 1).

```cpp
/*
    result = data++; //result <- 0 / data + 1
    result = ++data;
*/
```

Voilà dans ce cas `result = data++;`, data a bien été incrémenté parce qu'il y a une poste incrémentation qui est faite mais nous on a voulu récupérer la valeur dans result et du coup on n'a pas le résultat que l'on voulait.

Par exemple pour la post incrémentation:

```cpp
#include <iostream>

int main()
{
    auto data{0};
    auto result{0};

    result = data++;

    std::cout << "result = " << result << std::endl; 
    std::cout << "data = " << data << std::endl;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
result = 0
data = 1
```

Avec la poste incrémentation vous voyez que l'incrémentation s'est bien faite sur data par contre pour result, on a récupéré la valeur d'avant putain voilà l'affectation s'est fait avant l'incrémentation de data donc ça ça arrive avec une poste incrémentation `result = ++data;`.

Si on veut le résultat qu'on attend, il faut faire une pré incrémentation parce que là on va faire d'abord `data + 1` et ensuite on va affecter le contenu, la valeur de data à result. Dans ce cas `result = ++data;` il n'y aura pas de problème.

```cpp
#include <iostream>

int main()
{
    auto data{0};
    auto result{0};

    result = ++data;

    std::cout << "result = " << result << std::endl; 
    std::cout << "data = " << data << std::endl;
}
```
```powershell
> g++ -std=c++17 -Wall -Wextra -Werror main.cpp -o prog
> .\prog.exe
result = 1
data = 1
```

Voilà il n'y a pas de problème avec près incrémentation.

Ainsi il faut retenir que quand on est dans un usage plutôt isolé, on va plutôt travailler avec la pré incrémentation `result = ++data;` qui est plus rapide même si on va pas parler d'optimisation ça reste quand même plus rapide. La près incrémentation est toujours plus rapide que la post incrémentation quel qu'il soit.

Attention donc suivant les cas ils peuvent se passer des choses qu'on n'attendait pas, donc on a vu que dans certains cas ça ne posait aucune différence mais par contre on a vu que pour l'affectation on avait des choses différentes.

À bientôt tout le monde