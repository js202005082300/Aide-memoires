#include "character.hpp"
#include <iostream>
#include <string>

// au lieu de passer `_id(id), _name(name)`, on les transmet au constructeur de Unit.
Character::Character(int id, const std::string& name, int level) noexcept : Unit(id,name), _level(level)
{

}

int Character::getLevel() const
{
    return _level;
}