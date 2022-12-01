#include "indonesian.hpp"
#include <iostream>

void Indonesian::sayGoodNight() const noexcept
{
    // Someone::sayGoodNight(); // On ne peut plus instancier la classe mère.
    std::cout << _name << " : selamat malam" << std::endl;
}