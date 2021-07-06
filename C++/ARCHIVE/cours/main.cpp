#include "human.hpp"
#include <iostream>

int main()
{
    Human hu{"Paul", 36};

    std::cout << hu.getName() << std::endl;

    hu.setName("Marc");

    std::cout << hu.getName() << std::endl;

    return 0;
}