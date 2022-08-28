#include <iostream>
#include <string>

int main()
{
    try
    {
        throw std::invalid_argument("Mince !");
        throw std::exception();
    }
    catch(const std::invalid_argument& err)
    {
        std::cout << err.what() << std::endl;
    }
    catch(const std::exception& err)
    {
        std::cout << "Une erreur generéale s'est produite" << std::endl;
    }

    return 0;
}