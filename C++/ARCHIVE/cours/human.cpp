#include "human.hpp"
#include <iostream>

Human::Human() : mName("Inconnu"), mAge(1)
{
}

Human::Human(std::string name, int age) : mName(name), mAge(age)
{
}

Human::Human(const Human &other)
{
    mName = other.mName;
    mAge = other.mAge;
}

std::string Human::getName() const
{
    /*if( tu as l'autorisation ) */
        return mName;
    /*else*/
}

void Human::setName(const std::string name)
{
    mName = name;
}

void Human::hello()
{
    std::cout << "Hello !" << std::endl;
}