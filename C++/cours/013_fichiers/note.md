# [13. Fichiers](https://www.youtube.com/watch?v=s98HCale71U)

+ [Introduction](#Introduction)
+ [Comment conserver de l'information ?](#Comment-conserver-de-l-information)
+ [Comment est nommé un fichier ?](#Comment-est-nommé-un-fichier)
+ [Quelles opérations sur un fichier ?](#Quelles-opérations-sur-un-fichier)
+ [L'entête fstream pour gérer les flux de fichiers](#L-entête-fstream-pour-gérer-les-flux-de-fichiers)
+ [Lecture d'un fichier](#Lecture-d-un-fichier)
+ [Rappels sur la mémoire tampon](#Rappels-sur-la-mémoire-tampon)
+ [Remarques sur la gestion d'un fichier par C++](#Remarques-sur-la-gestion-d-un-fichier-par-Cplusplus)
+ [Écriture dans un (nouveau) fichier](#Écriture-dans-un-nouveau-fichier)
+ [Modes d'ouverture d'un fichier](#Modes-d-ouverture-d-un-fichier)
+ [Bonus : lire plusieurs lignes](#Bonus---lire-plusieurs-lignes)
+ [Conclusion](#Conclusion)

>

## Introduction

Sur le cours d'achitecture, on aborde le système de fichiers de notre OS mais ici on se concentre sur la gestion de fichier lorsqu'on programme en C++.

## Comment conserver de l information

Lorsqu'on éteint notre ordinateur sous forme d'informations persistantes, les fichiers sont stocker dans la mémoire de notre machine (carte, disque dur).

Distinguer les données volatiles et la persistances des données pour écrire des données dans fichiers.

## Comment est nommé un fichier

Afficher par défaut les extensions et nommer nos fichiers.

Ce qui détermine le type d'un fichier, ce sont les données inscrites dans les octets au niveau du fichier lui-même ou simplement utiliser des types mimes.

L'extension sert surtout pour la lecture par les applications.

L'extension n'as aucune garantie sur le type d'un fichier (exemple fichier audio avec .jpeg) !

## Quelles opérations sur un fichier

Dans cette leçon, on ne regarde pas les différents types de données car on a pas encore abordés le chapître sur la programmation orienté objet.

Pour manipuler nos fichiers, on travaille avec des flux comme pour l'affichage sur la sortie standard (bibliothèque) dans la console `std::cout` et on a également fais de la lecture.

## L entête fstream pour gérer les flux de fichiers

On utilise le flux d'entrée pour la lecture et le flux de sortie pour l'écriture grâce à l'en-tête `fstream`.

Il y a beaucoup plus de possibilités que ce qu'on fait en vidéo.

Nous devons faire la distinction entre les différents modes et types de fichiers en générals mais réservé au système d'exploitation et la gestion des système de fichier vu en Architecture.

+ animal.txt
```txt
Tigre Lion Jaguar
Requin Saumon Truite
Aigle Faucon Corbeau
Crocodile Serpent Tortue
```

```cpp
#include <iostream>
#include <fstream>

int main()
{
    return 0;
}
```

On travaille avec des bits vu au cours d'achitecture puis l'ordinateur code en binaire mais à l'usage on distingue fichier en mode binaire et fichier en mode texte. Il y a du binaire dérrière la table ascii de notre fichier texte. Du binaire, fichier avec un en-tête et un corps. Une vidéo, une musique sont en binaire.

En mode binaire, c'est une suite d'octet (de bits d'informations). Éditeur hexadécimale qui compacte nos données en pac de 16 pour lire un fichier binaire.

Si je fais une modification, la modification est volatille, il faudra faire ctrl+S pour sauver sur l'ordinateur.

## Lecture d un fichier

Déclarer un flux de fichier :

```cpp
#include <iostream>
#include <string>
#include <fstream>

int main()
{
    std::ifstream f{"animals.txt"}; //std::ios::in

    std::string name{""};

    f >> name;
    std::cout << name << std::endl;

    f >> name;
    std::cout << name << std::endl;
    
    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Tigre
Lion
```

On ouvre notre fichier sous ce mode *std::ios::in* à partir du nom de l'espace de noms de la bibliothèque standard, et en `in` car nous sommes en lecture.

Reppelez vous avec `cin` et `cout` pour la lecture sur clavier et l'affichage en console, on utilise les mêmes mécanismes.

Lire au clavier, c'est un type de flux et lire un fichier c'est un autre type de flux mais on utilise les mêmes opérateurs partour `<<` et `>>`.

Alors afficher les deux premiers éléments si on veut tout afficher, on boucle.

Entre les affichages, un retour à la ligne, car on utilise `std::endl` mais on pourrait écrire ceci :

```cpp
std::cout << name << "\n";
```

## Rappels sur la mémoire tampon

Ainsi tant que le flux n'est pas vidé, tout est gardé dans la mémoire tampon donc l'un s'affiche après l'autre.

## Remarques sur la gestion d un fichier par Cplusplus

A aucun moment je ferme mon fichier, cela est géré par C++ qui est suffisament évolué pour désallouer la mémoire utilisée par des ressources qui ont été initialisées.

A la fin de la portée main, la mémoire est libérée.

Si on veut fermer manuellement un fichier, ... par exemple si on veut être tenté d'ouvrir un fichier qui n'existe pas où on devrait avoir une erreur :

```cpp
    std::ifstream f{"animal.txt"}; // 'animal' au lieu de 'animals'
```

Si le flux n'est pas associé à un fichier, il n'y a pas d'erreur d'où utiliser is_open().

```cpp
#include <iostream>
#include <string>
#include <fstream>

int main()
{
    std::ifstream f{"animals.txt"}; //std::ios::in

    if(f.is_open())
    {
        std::string name{" "};
        
        f >> name;
        std::cout << name << "\n";

        f >> name;
        std::cout << name << std::endl;

        f.close();
    }
    
    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Tigre
Lion
```

Méthode pour s'assurer que le fichier qui est bien ouvert mais cela ne crée pas d'exception.

Pour le destructeur de flux, on la méthode close()

## Écriture dans un nouveau fichier

`std::ofstream` pour l'écriture au lieu de `std::ifstream` pour la lecture.

On ouvre avec ce mode *std::ios::out*

Même chose, on vérifie s'il est bien ouvert.

+ main.cpp
```cpp
#include <iostream>
#include <string>
#include <fstream>

int main()
{
    std::ofstream f{"data.txt"}; //std::ios::out

    if(f.is_open())
    {       
        f << "Hello World !";
    }
    
    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Tigre
Lion
```
+ data.txt
```
Hello World !
```

Par exemple on peut passer des variables pour sauver le score d'un joueur puis lire le fichier précédemment écrit.

+ main.cpp
```cpp
#include <iostream>
#include <string>
#include <fstream>

int main()
{
    std::ofstream f{"data.txt"}; //std::ios::out

    if(f.is_open())
    {       
        int scoreJoueur{114};
        f << scoreJoueur;
    }
    
    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Tigre
Lion
```
+ data.txt
```
Hello World !
```

## Modes d ouverture d un fichier

Le mode par défaut en écriture est `std::ios::out` et en lecture `std::ios::in`.

Pour ouvrir un fichier en mode binaure : `std::ios::binary`.

```cpp
/*
    std::ios::out, std::ios::in
    std::ios::binary
*/
```

Ouvrir un fichier image en mode binaire, on peut changer quelques couleurs et cetera.

Pour tronquer le fichier au début avec `std::ios::trunc` et à la fin `std::ios::ate` en mode texte. `std::ios::app` permet de passer les données à la fin. Si on ferme le fichier et qu'on le réouvre avec ce mode, on ajoute à la fin du fichier.

```cpp
/*
    std::ios::out, std::ios::in
    std::ios::binary

    std::ios::trunc
    std::ios::ate
    std::ios::app
*/
```

On a vu comment écrire et lire des données. On a vu quelques modes. On a vu si un fichier a bien été ouvert avec is_open() ou fermer prématurémment un fichier close() si besoin mais laisser faire le compilateur dans la libération des données sauf si manuellement besoin de fermer le fichier pour faire d'autres traitement.

## Bonus - lire plusieurs lignes

Utiliser getLine() coupler à `std::ws` qui permet d'enlever les espaces blancs et on enlève le retour à la ligne.

+ animals
```txt
Tigre Lion Jaguar
Requin Saumon Truite
Aigle Faucon Corbeau
Crocodile Serpent Tortue
```
+ main.cpp
```cpp
#include <iostream>
#include <string>
#include <fstream>

void lecture_test(std::string file)
{
    std::ifstream f{file};

    if(f.is_open())
    {
        std::string line{" "};

        while(f) {
            std::getline(f >> std::ws, line);
            std::cout << line << std::endl;
        }
    }
}

int main()
{
    std::ifstream f{"animals.txt"}; //std::ios::in

    if(f.is_open())
    {
        std::string line{" "};

        std::getline(f >> std::ws, line);
        std::cout << line << std::endl;

        std::getline(f >> std::ws, line);
        std::cout << line << std::endl;
    }

    std::cout << std::endl;

    lecture_test("animals.txt");
    
    return 0;
}
```
```ps1
> g++ -std=c++20 -Wall -Wextra main.cpp -o prog
> .\prog.exe
Tigre Lion Jaguar
Requin Saumon Truite

Tigre Lion Jaguar
Requin Saumon Truite
Aigle Faucon Corbeau
Crocodile Serpent Tortue
Crocodile Serpent Tortue
```

Utiliser une boucle pour lire tout le fichier tant que f est vrai.

Créer votre petite fonction.

## Conclusion

Dans les prochains chapitre, on abordera la POO.

On avait déjà l'habitude d'aborder les flux.

A bientôt