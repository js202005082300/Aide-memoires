#ifndef __CHARACTER__
    #define __CHARACTER__
    #include "unit.hpp"
    #include <string>

    class Character : public Unit
    {
        using Unit::Unit; //!\ Obligé indiquer que la classe Character utilise tous les constructeurs de la classe Unit (seul chose qui n'est pas hérité par défaut en c++)
        
        public:
            Character() = delete;
            Character(int id, const std::string& name, int level) noexcept; // ajout du niveau
            int getLevel() const;
        
        private:
            // Pas besoin de réécrire _id et _name comme attributs
            int _level;
    };

#endif