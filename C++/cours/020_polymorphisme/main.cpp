#include "someone.hpp"
#include "english.hpp"
#include "indonesian.hpp"
#include <iostream>
#include <string>

int main()
{
    English en{"Jack"};
    en.sayGoodNight();

    Indonesian id{"Bunda"};
    id.sayGoodNight();

    return 0;
}