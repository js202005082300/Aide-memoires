# [19. Héritage](https://www.youtube.com/watch?v=Z1R-q8mlGbs)

+ [Introduction](#Introduction)
+ [Qu'est-ce que l'héritage ?](#Qu-est-ce-que-l-héritage)
+ [Code de départ](#Code-de-départ)
+ [Définir un héritage](#Définir-un-héritage)
+ [Interaction de classe sans héritage](#Interaction-de-classe-sans-héritage)
+ [Définir une composition](#Définir-une-composition)
+ [Héritage multiple](#Héritage-multiple)
+ [Conclusion](#Conclusion)

>

## Introduction
## Qu est-ce que l héritage

L'héritage, où la manière de définir des relations entre plusieurs classes.

L'héritage est souvent confondu avec le concept de composition.

## Code de départ

*npc* pour *non-player character* ou *pnj* en français.

+ main.cpp
```cpp
#include "unit.hpp"
#include <iostream>

int main()
{
    Unit npc(114, "Forgeron Gibbons");

    std::cout << npc.getName() << std::endl;
    std::cout << npc.getId() << std::endl;

    return 0;
}
```
+ unit.cpp
```cpp
#include "unit.hpp"
#include <iostream>
#include <string>

Unit::Unit(int id, const std::string& name) noexcept : _id(id), _name(name)
{
}

int Unit::getId() const noexcept
{
    return _id;
}

std::string Unit::getName() const noexcept
{
    return _name;
}
```
+ unit.hpp
```cpp
#ifndef __UNIT__
    #define __UNIT__
    #include <string>

    class Unit
    {
        public:
            Unit() = delete; // désactive le constructeur par défaut
            Unit(int id, const std::string& name) noexcept;
            int getId() const noexcept;
            std::string getName() const noexcept;
        
        private:
            int _id;
            std::string _name;
    };

#endif
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Forgeron Gibbons
114
```

## Définir un héritage

Enregistrement en base de données d'unité avec un identifiant unique (le nom n'est pas un identifiant unique) donc on crée une relation d'héritage pour notre personnage.

La classe `Unit` est la classe mère et notre classe enfant sera `Character` : 

Créons cette relation d'héritage et on écrit `class Character : public Unit` (=pour creer une relation d'héritage) car on veut que tout les éléments publics dans la classe mère le soit dans la classe enfant.

+ Character.hpp
```cpp
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
```
+ Character.cpp
```cpp
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
```
+ main.cpp
```cpp
#include "unit.hpp"
#include "character.hpp"
#include <iostream>

int main()
{
    Unit npc(114, "Forgeron Gibbons");
    std::cout << npc.getName() << std::endl;
    std::cout << npc.getId() << std::endl;

    Character c(16, "Jason", 1);
    std::cout << c.getName() << std::endl;
    std::cout << c.getId() << std::endl;
    std::cout << c.getLevel() << std::endl; // afficher le niveau (indisponible avec Unit)

    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Forgeron Gibbons
114  
Jason
16   
1  
```

Y a t'il une relation d'héritage ? Si Character est une sorte d'unité alors on a une relation. 

B est une sorte de A.

## Interaction de classe sans héritage

En général, un joueur propose une quête et nous on l'accepte, on va créer une quête.

+ quest.hpp
```cpp
#ifndef __QUEST__
    #define __QUEST__
    #include <string>

    class Quest
    {
        public:
            Quest() = delete;
            Quest(const std::string& name, const std::string& description, int unitId) noexcept; // unitId afin d'indiquer de quel personnage elle vient, /!\ ce n'est pas un attribut mais une information
            void show() const noexcept; // pour afficher tous les attributs.
        
        private:
            std::string _name;
            std::string _description;
    };

#endif
```
+ quest.cpp
```cpp
#include "quest.hpp"
#include <iostream>
#include <string>

Quest::Quest(const std::string& name, const std::string& description, int unitId) noexcept : _name(name), _description(description)
{

}

void Quest::show() const noexcept
{
    std::cout << _name << std::endl;
    std::cout << _description << std::endl;
}
```
+ main.cpp
```cpp
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
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
quest.cpp: In constructor 'Quest::Quest(const std::string&, const std::string&, int)':      
quest.cpp:5:75: warning: unused parameter 'unitId' [-Wunused-parameter]
    5 | Quest::Quest(const std::string& name, const std::string& description, int unitId) noexcept : _name(name), _description(description)
      |                                                                       ~~~~^~~~~~    
> .\prog.exe
Tourte au sanglier
Rapporte 5 morceaux de viande
```

Juste une variable non utilisée, aucun soucis.

## Définir une composition

Nous créeons une `enum class` pour avoir l'état de la quête, le statut de la classe.

Une classe d'enumération signifie que le statut de notre quête est dissocié de la classe et rentre dans le principe de compsition.

La classe possédera un statut, une information complexe au lieu d'une seule donnée.

Par défaut, je fais : `QuestStatus _status;` et son statut est Disabled.

+ quest.hpp
```cpp
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
```
+ quest.cpp
```cpp
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
```
+ queststatus.hpp
```cpp
#ifndef __QUESTSTATUS__
    #define __QUESTSTATUS__
    #include <string>

    enum class QuestStatus
    {
        disabled,
        activited,
        failed // quête échouée.
    };

#endif
```

Au moment où une quête est prise par un perso, la quête est activée.

Voilà pour la relation de composition, pas d'héritage.

La relation de composition est la classe A contient un élément de la classe B. On met une des instances de la classe B à l'intérieur de la classe A.

Pour l'héritage, pas d'attribut de type Charactere dans la classe Unit donc pas une relation de composition.

Héritage, B est une sorte de A.

Composition, B est inclut, contenu, fait partie de A.

## Héritage multiple

C++ permet l'héritage multiple.

+ character.hpp
```cpp
class Character : public Unit, public OtherClass 
{

};
```

Pas autoriser dans tous les languages, les interfaces permettent de palier à cela. On peut se passer de l'héritage multiple, voilà pourquoi il n'existe pas partout.

On fait appel aux constructeurs parents ici :

+ Character.cpp
```cpp
#include "character.hpp"
#include <iostream>
#include <string>

// au lieu de passer `_id(id), _name(name)`, on les transmet au constructeur de Unit et cetera ...
Character::Character(int id, const std::string& name, int level) noexcept : Unit(id,name), _level(level)
{

}
```


## Conclusion

On vera le polymorphisme dans la prochaine séance