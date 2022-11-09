#include "point.hpp"
#include <iostream>

Point::Point()
{
    std::cout << "Creation d'un point : "  << this << std::endl;
}

Point::~Point()
{
    std::cout << "Destruction de l'objet : "  << this << std::endl;
}