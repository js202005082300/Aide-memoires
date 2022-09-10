# [12. Énumérations](https://www.youtube.com/watch?v=q6AUExuGhyU)

+ [Introduction](#Introduction)
+ [Qu'est-ce qu'une énumération ?](#Qu-est-ce-qu-une-énumération)
+ [Énumération régulière](#Énumération-régulière)
+ [Énumération étendue](#Énumération-étendue)
+ [Définir une énumération sans énumérateurs](#Définir-une-énumération-sans-énumérateurs)
+ [Définir une énumération fortement typée](#Définir-une-énumération-fortement-typée)
+ [Conclusion](#Conclusion)

>

## Introduction

L'énumération permet de définir un type et ce type pourra contenir des variables listées prédéfinies.

## Qu est-ce qu une énumération

Énumération sur les éléments naturels. Á l'intérieur de l'énumération, des énumérateurs càd des constantes intégrales.

```cpp
#include <iostream>

enum NaturalElement
{
    earth,  // 0
    air,    // 1
    fire,   // 2
    water   // 3
};

int main()
{
    NaturalElement ne{water};

    std::cout << ne << std::endl;

    return 0;
}
```

La portée de l'énumération est globale.

```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
3
```

3 est la valeur de `water`.

On pourrait avoir une valeur explicite.

```cpp
enum NaturalElement
{
    earth = 2,  // 0
    air,    // 1
    fire = 1,   // 2
    water   // 3
};
```

Les valeurs sont incrémentées p/r à la valeur précédente soit `water` vaudra 2 p/r à `fire`. Cela fonctionne avec des entiers.

Avec l'affichage, on a des entiers puisqu'une conversion implicite est éffectuée.

Éviter la numérotation implicite.

L'énumérateur ne peut avoir qu'une seule de ces valeurs à la fois.

```cpp
#include <iostream>

enum NaturalElement
{
    earth,  // 0
    air,    // 1
    fire,   // 2
    water   // 3
};

int main()
{
    NaturalElement ne{water};

    std::cout << ne << std::endl;

    ne = fire;

    std::cout << ne << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
3
2 
```

On peut faire un test.

```cpp
#include <iostream>

enum NaturalElement
{
    earth,  // 0
    air,    // 1
    fire,   // 2
    water   // 3
};

int main()
{
    NaturalElement ne{water};

    std::cout << ne << std::endl;

    if(ne == water)
        std::cout << "Oui !" << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
3
Oui !
```

## Énumération régulière

On est sur une énumération régulière dans une portée globale.

```cpp
enum NaturalElement
{
    earth = 2,  // 0
    air,    // 1
    fire = 1,   // 2
    water   // 3
};

enum OtherElement
{
    either,
    fire
};
```

Comme on est dans une portée globale, on ne peut pas définir deux fois un élément fire qui est dans une portée globale.

Voilà pour la portée et la conversion implicite lorsqu'on fait de l'affichage.

## Énumération étendue

Garantie supplémentaire p/r aux énumérations classiques.

Ajout du mot-clé `class` mais pour le même résultat, on peut utiliser le mot clé `struct` à ne pas confondre avec les structures.

Ici on a une portée propre à l'énumération, on doit donc définir l'élément avec un opérateur de portée `::` et le type de l'énumération en disant c'est l'élément fire du type NaturalElement mais ici on aura plus de conversion implicite à l'affichage mais une conversion explicite.

On utilise ainsi un static_cast() pour affichr la valeur.

```cpp
#include <iostream>

enum class NaturalElement
{
    earth,  // 0
    air,    // 1
    fire,   // 2
    water   // 3
};

int main()
{
    NaturalElement ne{NaturalElement::fire};

    std::cout << static_cast<int>(ne) << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
2
```

Pour faire les tests.

```cpp
#include <iostream>

enum class NaturalElement
{
    earth,  // 0
    air,    // 1
    fire,   // 2
    water   // 3
};

int main()
{
    NaturalElement ne{NaturalElement::water};

    if(ne == NaturalElement::water)
        std::cout << "Oui !" << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Oui !
```

Dans une énumération étendue, on doit spécifier le type NaturalElement.

Pour la modification, c'est pareil : `ne = NaturalElement::air;`

```cpp
#include <iostream>

enum class NaturalElement
{
    earth,  // 0
    air,    // 1
    fire,   // 2
    water   // 3
};

int main()
{
    NaturalElement ne{NaturalElement::water};

    if(ne == NaturalElement::water)
        std::cout << "Oui !" << std::endl;

    ne = NaturalElement::air;

    return 0;
}
```

Pour rappel, l'énumération n'es qu'un seul des type à la fois.
Se rappeler l'énumération régulière contre l'énumération étendue avec leur différence de portée.
Pour l'énumération étendue, il faut faire la conversion statique à l'affichage explicitement.

## Définir une énumération sans énumérateurs

C'est créer un type sous-jacent mais il faut préciser un autre type, par exemple `smallint` est un `int`. C'est une copie complète du type. On pourrait passer par un alias mais ici on a une énumération.

```cpp
enum class smallint : int {};
```

## Définir une énumération fortement typée

Si on veux que notre type soit booléen (pour définir deux valeurs uniquement) ou short, long, tous les types intégrales, char qui permet de coder des petits nombres sauf qu'au lieu de 0, on aura un espace blanc puis l'ancètre des émoji et cetera mais on peut spécifier les valeurs.

```cpp
enum class NaturalElement : bool
{
    earth,  // 0
    air     // 1
};
```
```cpp
enum class NaturalElement : long
{
    earth,  // 0
    air,    // 1
    fire,   // 2
    water   // 3
};
```
```cpp
enum class NaturalElement : char
{
    earth = 'E',  // 0
    air,     // 1
    fire,   // 2
    water   // 3
};
```
```cpp
enum class NaturalElement : int
{
    earth,  // 0
    air,    // 1
    fire,   // 2
    water   // 3
};
```

## Conclusion

Dans les chapitres suivants, la programmation orientée objet.

Ciao tout le monde