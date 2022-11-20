#ifndef __QUEST__
    #define __QUEST__
    #include "queststatus.hpp" // inclure ici.
    #include <string>

    class Quest
    {
        public:
            Quest() = delete;
            Quest(const std::string& name, const std::string& description, int unitId) noexcept;
            void show() const noexcept;
        
        private:
            std::string _name;
            std::string _description;
            QuestStatus _status; // signature, attribut de type QuestStatus (Composition)
    };

#endif