#include <iostream>
#include <string>

int main()
{
    std::cout << "Tapez un nombre entier : ";
    int number;
    std::cin >> number;

    std::cin.ignore(255, '\n');

    std::string username;
    std::cout << "Tapez votre nom complet : ";
    std::getline(std::cin, username);

    std::cout << "Nombre saisi : " << number << std::endl;
    std::cout << "Vous vous appelez : " << username << std::endl;

    return 0;
}