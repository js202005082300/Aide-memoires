#include <iostream>

enum class Choice : char{YES = 'Y', NO = 'N'};

int main(void)
{
    Choice c = Choice::YES;

    std::cout << c << std::endl;
    
    return 0;
}