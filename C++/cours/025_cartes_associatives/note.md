# [25. Cartes associatives](https://www.youtube.com/watch?v=d5KT20vQmQw)

+ [Introduction](#Introduction)
+ [Fonctionnement d'une carte associative](#Fonctionnement-d-une-carte-associative)    
+ [Déclaration d'une carte](#Déclaration-d-une-carte)
+ [Parcours de la carte](#Parcours-de-la-carte)
+ [Accès et modification d'un élément](#Accès-et-modification-d-un-élément)
+ [Ajout et suppression d'éléments](#Ajout-et-suppression-d-éléments)
+ [Taille de la carte et éléments](#Taille-de-la-carte-et-éléments)
+ [Recherche d'éléments](#Recherche-d-éléments)
+ [Conclusion](#Conclusion)

>

## Introduction
## Fonctionnement d une carte associative

carte/table associative avec un jeux de données, clé-valeur.

Carte associative avec des données ordonnées (triée, pour le travail de beaucoup de données) ou une map non-ordonnées, et on travaillera directement avec des tables non-ordonnées.

## Déclaration d une carte

```cpp
#include <iostream>
#include <string>
#include <unordered_map>
// #include <map>

int main()
{
    std::unordered_map<int, std::string> um{ {3, "arbre"}, {1, "Maison"}, {2, "Fourchette"} };

    return 0;
}
```

## Parcours de la carte

```cpp
#include <iostream>
#include <string>
#include <unordered_map>
// #include <map>

int main()
{
    std::unordered_map<int, std::string> um{ {3, "arbre"}, {1, "Maison"}, {2, "Fourchette"} };

    for(const auto& [key, value] : um)
        std::cout << key << " > " << value << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe              
2 > Fourchette
1 > Maison    
3 > arbre 
```

Et si on passe à Map, et on se rend compte que les éléments ont été **triés**.

```cpp
#include <iostream>
#include <string>
#include <unordered_map>
#include <map>

int main()
{
    std::map<int, std::string> um{ {3, "arbre"}, {1, "Maison"}, {2, "Fourchette"} };

    for(const auto& [key, value] : um)
        std::cout << key << " > " << value << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
1 > Maison    
2 > Fourchette
3 > arbre  
```

## Accès et modification d un élément

```cpp
#include <iostream>
#include <string>
#include <unordered_map>
#include <map>

int main()
{
    std::unordered_map<int, std::string> um{ {3, "arbre"}, {1, "Maison"}, {2, "Fourchette"} };

    std::cout << um[1] << std::endl;

    um[1] = "Villa";

    std::cout << um[1] << std::endl;

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Maison
Villa
```

## Ajout et suppression d éléments

```cpp
#include <iostream>
#include <string>
#include <unordered_map>
#include <map>

int main()
{
    std::unordered_map<int, std::string> um{ {3, "arbre"}, {1, "Maison"}, {2, "Fourchette"} };

    um[6] = "Ballon";

    for(const auto& [key, value] : um)
        std::cout << key << " > " << value << std::endl;

    

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
6 > Ballon    
2 > Fourchette
1 > Maison    
3 > arbre  
```

Avec la méthode insert().

```cpp
#include <iostream>
#include <string>
#include <unordered_map>
#include <map>

/*
    .at()
    .insert()
*/

int main()
{
    std::unordered_map<int, std::string> um{ {3, "arbre"}, {1, "Maison"}, {2, "Fourchette"} };

    um.insert( { {6, "Ballon"}, {13, "Serviette"}, {4, "Table"} } );

    for(const auto& [key, value] : um)
        std::cout << key << " > " << value << std::endl;

    

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
4 > Table     
13 > Serviette
6 > Ballon    
2 > Fourchette
1 > Maison    
3 > arbre    
```

La méthode at() fonctionne avec les Map en passant la clé en argument.

Maintenat pour supprimer l'élément de clé 3 :

```cpp
#include <iostream>
#include <string>
#include <unordered_map>
#include <map>

/*
    .at()
    .insert() / .erase()
    .empty() / .size()
    .contains()
*/

int main()
{
    std::unordered_map<int, std::string> um{ {3, "arbre"}, {1, "Maison"}, {2, "Fourchette"} };

    um.erase(3);

    for(const auto& [key, value] : um)
        std::cout << key << " > " << value << std::endl;

    

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog
> .\prog.exe
4 > Table     
13 > Serviette
6 > Ballon    
2 > Fourchette
1 > Maison    
3 > arbre    
```

## Taille de la carte et éléments

```cpp
/*
    .at()
    .insert() / .erase()
    ==> .empty() / .size()
    .contains()
*/
```

## Recherche d éléments

.contains() retourne un booléen.

```cpp
#include <iostream>
#include <string>
#include <unordered_map>
#include <map>

/*
    .at()
    .insert() / .erase()
    .empty() / .size()
    .contains()
*/

int main()
{
    std::unordered_map<int, std::string> um{ {3, "arbre"}, {1, "Maison"}, {2, "Fourchette"} };

    if(um.contains(3))
        std::cout << "Oui" << std::endl;
    else
        std::cout << "Non" << std::endl;   

    return 0;
}
```
```ps1
> g++ -std=c++23 -Wall -Wextra main.cpp -o prog                                               
> .\prog.exe
Oui 
```

Pour rappel, avec `std::map`, on trie les éléments dans l'ordre.

## Conclusion

On complétera les vidéos sur les containeurs lorsqu'on vera les itérateurs.

Ciao