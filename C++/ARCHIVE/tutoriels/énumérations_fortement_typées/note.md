# [[ARCHIVE] Tutoriel C++ - énumérations fortement typées](https://www.youtube.com/watch?v=Ht3AuVr82zQ&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=28)

Par exemple un feu tricolore sur la route.

```cpp
#include <iostream>

enum TrafficLight{RED, ORANGE, GREEN};

int main(void)
{
    TrafficLight t = TrafficLight::RED;

    return 0;
}
```

C'est comme si on avait dit : `enum TrafficLight{RED = 0, ORANGE = 1, GREEN = 2};` et on pouvait l'initialiser avec l'opérateur de portée `TrafficLight t = TrafficLight::RED;`.

## Problème de redéclaration

```cpp
#include <iostream>

enum TrafficLight{RED, ORANGE, GREEN};
enum ButtonStatus{RED, GREEN};

int main(void)
{

    return 0;
}
```
```powershell
g++ -std=c++14 *.cpp -o prog
main.cpp:4:19: error: 'RED' conflicts with a previous declaration
    4 | enum ButtonStatus{RED, GREEN};
      |                   ^~~
main.cpp:3:19: note: previous declaration 'TrafficLight RED'
    3 | enum TrafficLight{RED, ORANGE, GREEN};
      |                   ^~~
main.cpp:4:24: error: 'GREEN' conflicts with a previous declaration
    4 | enum ButtonStatus{RED, GREEN};
      |                        ^~~~~
main.cpp:3:32: note: previous declaration 'TrafficLight GREEN'
    3 | enum TrafficLight{RED, ORANGE, GREEN};
      |                                ^~~~~
```

Problème car ce sont des énumérations sans portée et donc on ne peut pas déclarer des valeurs de même noms.

On utilise au choix le mot-clé `class` ou `struct` pour résourdre ce problème de déclaration multiple.

```cpp
#include <iostream>

enum class TrafficLight{RED, ORANGE, GREEN};
enum struct ButtonStatus{RED, GREEN};

int main(void)
{

    return 0;
}
```
```powershell
g++ -std=c++14 *.cpp -o prog
.\prog.exe
```

On crée une énumération qui ont une portée différente comme les objets de la même classe.

## Spécifier un type particulier

Modifier le type de l'énumération.

```cpp
#include <iostream>

enum class Choice : char{YES = 'Y', NO = 'N'};

int main(void)
{
    Choice c = Choice::YES;

    std::cout << static_cast<char>(c) << std::endl;

    return 0;
}
```
```powershell
g++ -std=c++14 *.cpp -o prog
.\prog.exe
Y
```

:warning: il faut vraiment caster pour obtenir le bon type.