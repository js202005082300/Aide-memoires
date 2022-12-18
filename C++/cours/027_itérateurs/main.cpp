#include <iostream>
#include <string>
#include <vector>

int main()
{
    std::vector<int> vec{1, 2, 3, 4, 5};
    auto it(std::begin(vec));

    std::cout << *it << std::endl;
    it++;
    std::cout << *it << std::endl;

    return 0;
}