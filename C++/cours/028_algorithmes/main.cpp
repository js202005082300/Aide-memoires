#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/*
    std::fill()
    std::equal()
    std::find(), std::search(), std::replace()
    std::count()
    std::sort(), std::reverse()
    std::remove(), std::erase()
    std::swap()
    std::for_each()
    std::all_of(), std::any_of(), std::none_of()
*/

bool is_pair(int n) // retourne un booléen
{
    return n % 2 == 0;
}

int main()
{
    std::vector<int> vec{1, 2, 3, 4, 5};

    std::cout << std::all_of(std::begin(vec), std::end(vec), is_pair) << std::endl;

    return 0;
}