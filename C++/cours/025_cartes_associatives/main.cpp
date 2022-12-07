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

    if(um.contains(1))
        std::cout << "Oui" << std::endl;
    else
        std::cout << "Non" << std::endl;   

    return 0;
}