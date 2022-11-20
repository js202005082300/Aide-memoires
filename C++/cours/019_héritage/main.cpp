#include "unit.hpp"
#include "character.hpp"
#include "quest.hpp"
#include <iostream>

int main()
{
    Character c(16, "Jason", 1);
    
    Unit npc(114, "Forgeron Gibbons");
    Quest q("Tourte au sanglier", "Rapporte 5 morceaux de viande", npc.getId()); // getId() est l'accesseur qui indique que la quête est attribuée à un perso au lieu d'un autre.

    q.show();

    return 0;
}