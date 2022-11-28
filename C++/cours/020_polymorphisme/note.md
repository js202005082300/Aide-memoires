# [20. Polymorphisme](https://www.youtube.com/watch?v=ivuuoQSTTPY)

+ [Introduction](#Introduction)
+ [Qu'est-ce que le polymorphisme ?](#Qu-est-ce-que-le-polymorphisme)
+ [Code d'exemple](#Code-d-exemple)
+ [Mise en place d'un héritage](#Mise-en-place-d-un-héritage)
+ [Méthode virtuelle dans une classe](#Méthode-virtuelle-dans-une-classe)
+ [Redéfinition d'une méthode dans une sous-classe](#Redéfinition-d-une-méthode-dans-une-sous-classe)
+ [Ajout de nouveaux types pour le polymorphisme](#Ajout-de-nouveaux-types-pour-le-polymorphisme)
+ [Accès aux attributs depuis une sous-classe](#Accès-aux-attributs-depuis-une-sous-classe) 
+ [Fonctionnement du polymorphisme](#Fonctionnement-du-polymorphisme)
+ [Point sur le polymorphisme ad hoc](#Point-sur-le-polymorphisme-ad-hoc)
+ [Appel d'une méthode de la classe parente](#Appel-d-une-méthode-de-la-classe-parente)     
+ [Classe abstraite](#Classe-abstraite)
+ [Méthode virtuelle pure](#Méthode-virtuelle-pure)
+ [Quelle différence avec une interface ?](#Quelle-différence-avec-une-interface)
+ [Conclusion](#Conclusion)

>

## Introduction
## Qu est-ce que le polymorphisme

Polymorphisme, prendre plusieurs formes.

Fait référence aux différentes classes de notre programmation POO.

Fournir une interface globale pour chacune des entités qui auront leur propre comportement.

## Code d exemple

+ main.cpp
```cpp
#include "someone.hpp"
#include <iostream>
#include <string>

int main()
{
    Someone so{"Anonymous"};
    so.sayGoodNight();

    return 0;
}
```
+ someone.cpp
```cpp
#include "someone.hpp"
#include <iostream>

Someone::Someone(const std::string& name) noexcept : _name(name)
{}

void Someone::sayGoodNight() const noexcept
{
    std::cout << _name << " : ..." << std::endl;
}
```
+ someone.hpp
```cpp
#ifndef __SOMEONE__
    #define __SOMEONE__
    #include <string>

    class Someone
    {
        public:
            Someone() = delete; // désactiver le constructeur par défaut.
            Someone(const std::string& name) noexcept; // constructeur simple qui demande un nom
            void sayGoodNight() const noexcept;

        private:
            std::string _name;
    };

#endif
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Anonymous : ...
>
```

Le but du polymorphisme est de transmettre une interface globale et générique pour nos entités.

On va faire parler des personnes indépendamment de leur origine ethnique en créant plusieurs instances de quelqu'un puis en faisant appel à leur methode.

## Mise en place d un héritage

On crée une classe dérivé, on parle de **polymorphisme d'héritage**. On avait déjà vu le **polymorphisme Ad-hoc** avec la surcharge de méthodes.

## Méthode virtuelle dans une classe

English est une sorte de Someone, et là tout ce qui est dans Someone sauf les constructeurs est dans English. Ensuite, indiquer que la classe Someone est **virtuelle**

## Redéfinition d une méthode dans une sous-classe
## Ajout de nouveaux types pour le polymorphisme

On va dérivé cette classe English de notre classe Someone, avec la méthode en  `virtual` puis `override` pour redéfinir la méthode.

## Accès aux attributs depuis une sous-classe

L'attribut `_name` est en `protected` qui est accessible dans les classes dérivées, compromis entre `private` et `public`.

+ main.cpp
```cpp
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
```
+ english.cpp
```cpp
#include "english.hpp"
#include <iostream>

void English::sayGoodNight() const noexcept
{
    std::cout << _name << " : good night" << std::endl;
}
```
+ english.hpp
```cpp
#ifndef __ENGLISH___
    #define __ENGLISH___
    #include "someone.hpp"
    #include <string>

    class English : public Someone
    {
        using Someone::Someone;

        public:
            void sayGoodNight() const noexcept override; // override.
    };

#endif
```
+ someone.hpp
```cpp
#ifndef __SOMEONE__
    #define __SOMEONE__
    #include <string>

    class Someone
    {
        public:
            Someone() = delete;
            Someone(const std::string& name) noexcept;
            virtual void sayGoodNight() const noexcept; // virtual.

        protected:
            std::string _name;
    };

#endif
```
+ someone.cpp
```cpp
#include "someone.hpp"
#include <iostream>

Someone::Someone(const std::string& name) noexcept : _name(name)
{}

void Someone::sayGoodNight() const noexcept
{
    std::cout << _name << " : ..." << std::endl;
}
```
+ indonesian.hpp
```cpp
#ifndef __INDONESIAN__
    #define __INDONESIAN__
    #include "someone.hpp"
    #include <string>

    class Indonesian : public Someone
    {
        using Someone::Someone;

        public:
            void sayGoodNight() const noexcept override; // override sur la définition.
    };

#endif
```
+ indonesian.cpp
```cpp
#include "indonesian.hpp"
#include <iostream>

void Indonesian::sayGoodNight() const noexcept
{
    std::cout << _name << " : selamat malam" << std::endl;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Jack : good night    
Bunda : selamat malam
```

Voilà chacun s'exprime dans sa langue d'origine.

## Fonctionnement du polymorphisme

Lorsqu'on abordera les structures de données et les containeurs, on pourra faire une liste de personnes qui dérivent de ce type Someone. On pourra faire une boucle, et pour chaque personne de la liste, la méthode say() s'appliquera selon leurs comportements parce que chacun aura une méthode redéfinie. => Intérêt du polymorphisme = prendre plusieurs formes.

```cpp
// Liste/tableau de "Someone"

/*
    Déclarer une liste, un tableau, ... de "Someone", initialisé avec plusieurs objets dérivés (Indonésian, English, etc.)

    Pour chaque "Someone" de la liste/du tableau, faire appel à sayGoodNight()

    A aucun moment, on aura besoin de tester ...

        si c'est un Anglais, alors
            appeler sa méthode
        sinon si c'est un Indonésien, alors
            appeler sa méthode
        etc.
*/
```

Vérifier de quel type de classe est un objet représente beaucoup trop de vérifications à faire ...

Créer un tableau/liste de Someone permet de rassembler dans une seule liste plusieurs types différents, plutôt que de faire juste une liste d'anglais.

## Point sur le polymorphisme ad hoc

Dans une classe dérivée, on ne peut pas changer la signature lors de l'implémentation, un **double** ne peut pas devenir un **int**, ce type de surcharge ad-hoc n'est pas possible.

## Appel d une méthode de la classe parente

Depuis une sous-classe, faire appel à une méthode de la classe parente.

+ indonesian.cpp
```cpp
#include "indonesian.hpp"
#include <iostream>

void Indonesian::sayGoodNight() const noexcept
{
    Someone::sayGoodNight();
    std::cout << _name << " : selamat malam" << std::endl;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Jack : good night    
Bunda : ...
Bunda : selamat malam
```

Indonésien qui se comporte comme Someone.

## Classe abstraite

Les mots clés `abstract` et `interface` devant une classe n'existe pas en c++. On peut néanmoins gérer l'implémentation comme si c'était abstrait.

En Java et en Php, il y en a mais il faudra chipotter C++ pour en avoir car il n'y a pas de mots-clé au niveau de la syntaxe.

Classe abstraite, signifie qu'on ne pourra jamais instancier cette classe.

## Méthode virtuelle pure

La classe de base Someone sera abstraite lorsqu'au moins une méthode soit déclarée virtuelle pure (jusqu'ici on avait uniquement une méthode `virtual`) en ajoutant `= 0` à la signature, qui signifie qu'on lui attribue la valeur nulle.

+ someone.hpp
```cpp
#ifndef __SOMEONE__
    #define __SOMEONE__
    #include <string>

    class Someone // abstraite
    {
        public:
            Someone() = delete;
            Someone(const std::string& name) noexcept;
            virtual void sayGoodNight() const noexcept = 0; // virtual pure.

        protected:
            std::string _name;
    };

#endif
```
+ someone.cpp
```cpp
#include "someone.hpp"
#include <iostream>

Someone::Someone(const std::string& name) noexcept : _name(name)
{}

// void Someone::sayGoodNight() const noexcept
// {
//     std::cout << _name << " : ..." << std::endl;
// }
```

La méthode sayGoodNight() ne sera jamais plus utilisée, pas besoin de l'implémenter pour Someone.

## Quelle différence avec une interface

La classe abstraite devient interface si toute les méthodes sont virtuel pure `= 0`.

Une interface est un contrat, une liste de fonctionnalité.

Une interface pure est une interface avec une seule méthode.

Les classes qui implémente une interface a l'obligation d'implémenter toutes les classes de l'interface.

Si english ne redéfinis pas la méthode sayGoodNight(), appelle de la méthode de la classe parente mais si elle n'est pas implémentée (someone.cpp et sa signature dans someone.hpp), on est donc obligé de l'implémenter.

+ english.cpp
```cpp
#include "english.hpp"
#include <iostream>

void English::sayGoodNight() const noexcept
{
    std::cout << _name << " : good night" << std::endl;
}
```
+ english.hpp
```cpp
#ifndef __ENGLISH___
    #define __ENGLISH___
    #include "someone.hpp"
    #include <string>

    class English : public Someone
    {
        using Someone::Someone;

        public:
            void sayGoodNight() const noexcept override; // override.
    };

#endif
```
+ someone.hpp
```cpp
#ifndef __SOMEONE__
    #define __SOMEONE__
    #include <string>

    class Someone // abstraite
    {
        public:
            Someone() = delete;
            Someone(const std::string& name) noexcept;
            //virtual ~Someone() = 0; // destructeur obligatoire pour interface.
            virtual void sayGoodNight() const noexcept = 0; // virtual pure.

        protected:
            std::string _name;
    };

#endif
```
+ someone.cpp
```cpp
#include "someone.hpp"
#include <iostream>

Someone::Someone(const std::string& name) noexcept : _name(name)
{}

/*
    Interface : sayGoodNight() non implémenté dans la classe mère => implémentation obligatoire dans la classe fille.
*/

// void Someone::sayGoodNight() const noexcept
// {
//     std::cout << _name << " : ..." << std::endl;
// }
```
+ indonesian.hpp
```cpp
#ifndef __INDONESIAN__
    #define __INDONESIAN__
    #include "someone.hpp"
    #include <string>

    class Indonesian : public Someone
    {
        using Someone::Someone;

        public:
            void sayGoodNight() const noexcept override; // override sur la définition.
    };

#endif
```
+ indonesian.cpp
```cpp
#include "indonesian.hpp"
#include <iostream>

void Indonesian::sayGoodNight() const noexcept
{
    // Someone::sayGoodNight(); // On ne peut plus instancier la classe mère.
    std::cout << _name << " : selamat malam" << std::endl;
}
```
+ main.cpp
```cpp
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
```
```ps1
> g++ -std=c++20 -Wall -Wextra *.cpp -o prog
> .\prog.exe
Jack : good night    
Bunda : selamat malam
```

Dés que la classe dérive `class English : public Someone` donc tous les évennements virtuels pures vont devoir être réécrit.

/!\ lorsqu'on a un constructeur virtuel pure, on veut un destructeur virtuel pure aussi dont la responsabilité d'implémentation appartient aux classes filles. Le destructeur se charge de la libération des données allouées.

```cpp
virtual ~Someone() = 0;
```

Pour faire du code correct, il faudra l'implémenter.

## Conclusion

On a parlé :
    - transmission des données avec `protected`
    - héritage, dérivation, spécialisation
    - interface/abstraction
    - mécanisme de polymorphisme (élément qui prend plusieurs formes)

On manipulera dans des listes,structures,containeurs que ce type `Someone`, au niveau du traitement, on ne devra plus vérifier si c'est un anglais ou un indonésien qui dit bonjour.

Si on a une méthode virtuelle, prevoyez un destructeur virtuel.

Dans la prochaine vidéo, on abordera les tableaux.

Ciao tout le monde