#include "window.hpp"
#include <iostream>

int main()
{
    Window app{"Mon application graphique"};

    std::cout << app.getTitle() << std::endl;
    app.setTitle("Mon nouveau titre");
    std::cout << app.getTitle() << std::endl;

    return 0;
}