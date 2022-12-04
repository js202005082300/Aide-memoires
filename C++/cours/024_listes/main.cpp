#include <iostream>
#include <string>
#include <list>

int main()
{
    std::list<std::string> li{"arbre", "bateau", "castor", "baleine", "barbecue", "saucisse"};

    for(const auto& element : li)
        std::cout << element << std::endl;

    std::cout << "=======================" << std::endl;

    li.reverse();

    for(const auto& element : li)
        std::cout << element << std::endl;
    
    return 0;
}