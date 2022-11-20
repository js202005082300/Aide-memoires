#include "quest.hpp"
#include "queststatus.hpp" // inclure ici.
#include <iostream>
#include <string>

Quest::Quest(const std::string& name, const std::string& description, int unitId) noexcept : _name(name), _description(description)
{
    _status = QuestStatus::disabled; // Par défaut le statut de la classe est Disabled.
}

void Quest::show() const noexcept
{
    std::cout << _name << std::endl;
    std::cout << _description << std::endl;
}