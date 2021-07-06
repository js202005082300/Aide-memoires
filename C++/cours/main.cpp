#include <iostream>
#include <string>

int main()
{
    using namespace std::literals;

    auto some_string{"Hello World"s};
    std::cout << some_string << std::endl;

    return 0;
}