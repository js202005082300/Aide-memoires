#include <iostream>

int main()
{
    int n{67};
    int m{34};

    std::cout << n << " - " << m << std::endl;
    
    auto func = [=, &n]() mutable -> void
    {
        n += 3;
        m -= 4;
        std::cout << n << " - " << m << std::endl;
    };
    func();

    std::cout << n << " - " << m << std::endl;

    return 0;
}