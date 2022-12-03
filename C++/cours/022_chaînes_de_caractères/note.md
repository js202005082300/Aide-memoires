# [22. Chaînes de caractères](https://www.youtube.com/watch?v=urA7bqPmMgs)

+ [Introduction](#Introduction)
+ [Qu'est-ce qu'une chaîne de caractères ?](#Qu-est-ce-qu-une-chaîne-de-caractères)
+ [Accès aux caractères d'une chaîne](#Accès-aux-caractères-d-une-chaîne)
+ [Nouvelle affectation de chaîne](#Nouvelle-affectation-de-chaîne)
+ [Ajout et retrait de caractères](#Ajout-et-retrait-de-caractères)
+ [Parcours d'une chaîne](#Parcours-d-une-chaîne)
+ [Rappel sur les fonctions libres](#Rappel-sur-les-fonctions-libres)
+ [Ce qui se trouve derrière une std::string](#Ce-qui-se-trouve-derrière-une-std-string)
+ [Test sur le début et la fin d'une chaîne](#Test-sur-le-début-et-la-fin-d-une-chaîne)
+ [Présence d'une chaîne dans une autre](#Présence-d-une-chaîne-dans-une-autre)
+ [Extraction d'une sous-chaîne](#Extraction-d-une-sous-chaîne)
+ [Inversion de chaînes](#Inversion-de-chaînes)
+ [Référence constante à une chaîne existante](#Référence-constante-à-une-chaîne-existante)
+ [Conclusion](#Conclusion)

>

## Introduction
## Qu est-ce qu une chaîne de caractères

Suite de caractères dont le dernier est `\0`

```cpp
/*
    'H', 'e', 'l', 'l', 'o', '\0'

    std::string
*/
```

`std::string` est le type qui permet d'éviter de s'embêter avec les méthodes qu'on utilisait en C (pas d'allocation, pas de calcul de taille, libération ...).

## Accès aux caractères d une chaîne

Afficher la chaîne

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s{"Hello World !"};
    std::cout << s << std::endl;
    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Hello World !
```

Une chaîne est un tableau de caractère

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s{"Hello World !"};
    std::cout << s[0] << std::endl;
    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
H
```

Avec les méthodes at(), front() et back().

```cpp
std::cout << s.at(0) << std::endl;
std::cout << s.front() << " - " << s.back() << std::endl;
```

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s{"Hello World !"};
    std::cout << s[0] << std::endl;

    std::cout << s.at(0) << std::endl;
    std::cout << s.front() << " - " << s.back() << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
H
H    
H - !
```

## Nouvelle affectation de chaîne

Modification possible.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s{"Hello World !"};

    std::cout << s << std::endl;
    s = "Bonjour";
    std::cout << s << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Hello World !
Bonjour
```

## Ajout et retrait de caractères

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s{"Hello World !"};

    std::cout << s << std::endl;
    s.push_back('!');
    std::cout << s << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Hello World ! 
Hello World !!
```

On retrouve les mêmes méthodes.

```cpp
/*
    'H', 'e', 'l', 'l', 'o', '\0'
    std::string

    at(), front(), back()
    push_back(), pop_back(), append(), clear()
*/
```

Ajouter un nombre de caractère avec en entier en argument.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s{"Hello World !"};

    std::cout << s << std::endl;
    s.append(4, '!');
    std::cout << s << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Hello World !
Hello World !!!!!
```

... sans le nombre d'occurence en argument.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s{"Hello World !"};

    std::cout << s << std::endl;
    s.append("!!!!!!!!!!!!!!!!!");
    std::cout << s << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Hello World !
Hello World !!!!!!!!!!!!!!!!!!
```

## Parcours d une chaîne

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s{"Hello World !"};

    for(const auto& c : s)
        std::cout << c << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
H
e 
l 
l 
o 
  
W 
o 
r 
l 
d 
  
! 
> 
```

## Rappel sur les fonctions libres

Par rapport aux parcours (les anciennes boucles For), privilégié les fonctions libres plus génériques : `std::size()`, `std::empty()`

```cpp
/*
    'H', 'e', 'l', 'l', 'o', '\0'
    std::string

    std::size(), std::empty()

    at(), front(), back()
    push_back(), pop_back(), append(), clear()
*/
```

Privilégier les fonctions issues de la bibliothèque standard.

## Ce qui se trouve derrière une std string

`std::string` est composé de char, `std::basic_string<char>`.

```cpp
/*
    'H', 'e', 'l', 'l', 'o', '\0'
    std::string -> std::basic_string<char>

    std::size(), std::empty()

    at(), front(), back()
    push_back(), pop_back(), append(), clear()
*/
```

Le vrai type est `std::basic_string<char>`, `std::string` est un alias.

## Test sur le début et la fin d une chaîne

starts_with(), ends_with()

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s{"Hello World !"};

    if(s.starts_with('H'))
        std::cout << "Oui" << std::endl;

    if(s.starts_with("Hell"))
        std::cout << "Oui" << std::endl;

    // if(s.contains("Wo"))
    //     std::cout << "Oui" << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Oui
Oui
>  
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe         
Oui
Oui
Oui
```

Voilà pour les méthodes dont la méthode contains() disponible depuis le standard c++23

```cpp
/*
    'H', 'e', 'l', 'l', 'o', '\0'
    std::string -> std::basic_string<char>

    std::size(), std::empty()

    at(), front(), back()
    push_back(), pop_back(), append(), clear()
    starts_with(), ends_with(), contains()
    substr(), swap()
*/
```

## Présence d une chaîne dans une autre

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s{"Hello World !"};

    if(s.contains("Wo"))
        std::cout << "Oui" << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe         
Oui
```

## Extraction d une sous-chaîne

A partir de maintenant dans le cours, on compile avec `std=c++23`.

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s{"Hello World !"};

    std::cout << s.substr(3) << std::endl;
    std::cout << s.substr(5,3) << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
lo World !
 Wo
```

## Inversion de chaînes

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s1{"aaa"};
    std::string s2{"bbb"};

    std::cout << "s1 = " << s1 << std::endl;
    std::cout << "s2 = " << s2 << std::endl;

    s1.swap(s2);

    std::cout << "s1 = " << s1 << std::endl;
    std::cout << "s2 = " << s2 << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
s1 = aaa
s2 = bbb
s1 = bbb
s2 = aaa
```

## Référence constante à une chaîne existante

Et maintenant nous abordons le type `std::string_view`. C'est une chaîne, élément en lecture seul donc plus léger, simple élément constant. Si la chaîne est détruire, on rencontrera des problème à l'affichage. Avec un tableau de caractères comme en C `'H', 'e', 'l', 'l', 'o', '\0'`, on n'utilise pas de string_view. string_view ne fais pas d'allocation. On l'utilisera de temps en temps.

```cpp
/*
    'H', 'e', 'l', 'l', 'o', '\0'
    std::string
    std::string_view

    std::size(), std::empty()

    at(), front(), back()
    push_back(), pop_back(), append(), clear()
    starts_with(), ends_with(), contains()
    substr(), swap()
*/
```

```cpp
#include <iostream>
#include <string>

int main()
{
    std::string s{"Hello World !"};
    std::string_view sv{s};

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
s1 = aaa
s2 = bbb
s1 = bbb
s2 = aaa
```

## Conclusion

Nous aurons vu ce nouveau type `std::string_view`

A bientôt le monde