#include <iostream>
#include <string>

int main()
{
    int number{15};
    std::string s{"Hello"};

    std::cout << s << std::endl;

    if(number == 15)
    {
        std::cout << number << std::endl;
        s = "Hello World !";
    }

    std::cout << s << std::endl;
    return 0;
}