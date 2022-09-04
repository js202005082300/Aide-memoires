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