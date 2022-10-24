#include <iostream>

struct Product
{
    std::string name;
    float price;
    bool available;
};

int main()
{
    using Product = struct Product;

    Product p{"Papier toilette", 1.29, true};

    std::cout << "Prix : " << p.price << std::endl;

    p.price = 2.29f;

    std::cout << "Prix : " << p.price << std::endl;

    return 0;
}