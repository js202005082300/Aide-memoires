#include <iostream>
#include <string>

int main()
{
    std::string s1{"aaa"};
    std::string s2{"bbb"};

    std::cout << "s1 = " << s1 << std::endl;
    std::cout << "s2 = " << s2 << std::endl;

    s1.swap(s2);

    std::cout << "s1 = " << s1 << std::endl;
    std::cout << "s2 = " << s2 << std::endl;

    return 0;
}