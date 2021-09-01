:label: [FormationVidéo](https://github.com/jasonchampagne/FormationVideo) - [Ressources C](https://github.com/jasonchampagne/FormationVideo/tree/master/Ressources/C)

# Le langage C
> [C reference](https://en.cppreference.com/w/c)  

## [cours](cours)
> [Playlists C cours](https://github.com/jasonchampagne/FormationVideo/blob/master/Playlists/c-cours.md)  

### Les notions de bases

||notes de cours|fichiers|pense-bêtes
-|:-|:-:|:-:
|:heavy_check_mark:|[1. Introduction](cours/001_introduction)|[notes.md](cours/001_introduction/note.md)|[:memo:](#Introduction)
|:heavy_check_mark:|[2. Compiler](cours/002_compiler)|[main.c](cours/002_compiler/main.c)|[:memo:](#Compiler)
|:heavy_check_mark:|[3. Variables](cours/003_variables)|[main.c](cours/003_variables/main.c) [Les mots réservés en C](cours/003_variables/mots_réservés.png) [Les type de variables en C](cours/003_variables/types_variables.png)|[:memo:](#Variables)
|:heavy_check_mark:|[4. Lire données au clavier](cours/004_lire_données_au_clavier)|[main.c](cours/004_lire_données_au_clavier/main.c)|[:memo:](#Lire-données-au-clavier)
|:heavy_check_mark:|[5. Operateurs](cours/005_operateurs)|[main.c](cours/005_operateurs/main.c)|[:memo:](#Opérateurs)
|:heavy_check_mark:|[6. Conditions](cours/006_conditions)|[main.c](cours/006_conditions/main.c)|[:memo:](#Conditions)
|:heavy_check_mark:|[7. Boucles](cours/007_boucles)|[main.c](cours/007_boucles/main.c)|[:memo:](#Boucles)
|:heavy_check_mark:|[8. Fonctions](cours/008_fonctions)|[main.c](cours/008_fonctions/main.c)|[:memo:](#Fonctions)
|:heavy_check_mark:|[9. Programmation modulaire](cours/009_programmation_modulaire)|[main.c](cours/009_programmation_modulaire/main.c) [player.c](cours/009_programmation_modulaire/player.c) [player.h](cours/009_programmation_modulaire/player.h)|[:memo:](#Programmation-modulaire)
|:heavy_check_mark:|[10. Preprocesseurs](cours/010_preprocesseurs)|[main.c](cours/010_preprocesseurs/main.c) [bibli.h](cours/010_preprocesseurs/bibli.h)|[:memo:](#Preprocesseurs)
|:heavy_check_mark:|[11. Pointeurs](cours/011_pointeurs)|[main.c](cours/011_pointeurs/main.c)|[:memo:](#Pointeurs)
|:heavy_check_mark:|[12. Tableaux](cours/012_tableaux)|[main.c](cours/012_tableaux/main.c)|[:memo:](#Tableaux)
|:heavy_check_mark:|[13. Chaines de caractères](cours/013_chaines_de_caractères)|[main.c](cours/013_chaines_de_caractères/main.c)|[:memo:](#Chaînes-de-caractères)
|:heavy_check_mark:|[14. Structures et types](cours/014_structures_et_types)|[main.c](cours/014_structures_et_types/main.c)|[:memo:](#Structures-et-types)
|:heavy_check_mark:|[15. Allocation dynamique mémoire](cours/015_allocation_dynamique_mémoire)|[main.c](cours/015_allocation_dynamique_mémoire/main.c) [types_variables.png](cours/015_allocation_dynamique_mémoire/types_variables.png)|[:memo:](#Allocation-dynamique-mémoire)
|:heavy_check_mark:|[16. Fichiers](cours/016_fichiers)|[main.c](cours/016_fichiers/main.c) [016-R.txt](cours/016_fichiers/016-R.txt) [016-W.txt](cours/016_fichiers/016-W.txt)|[:memo:](#Fichiers)

### Les structures de données

||notes de cours|fichiers|pense-bêtes
-|:-|:-:|:-:
|:heavy_check_mark:|[17. Piles](cours/017_piles)|[entiers.c](cours/017_piles/entiers.c) [stack-entiers.c](cours/017_piles/stack-entiers.c) [stack-entiers.h](cours/017_piles/stack-entiers.h) [joueurs.c](cours/017_piles/joueurs.c) [joueurs.c](cours/017_piles/joueurs.c) [schema-pile.png](cours/017_piles/schema-pile.png) [schema-pile-2.png](cours/017_piles/schema-pile-2.png)|[:memo:](#piles)
|:heavy_check_mark:|[18. Files](cours/018_files)|[main.c](cours/018_files/main.c) [queue.c](cours/018_files/queue.c) [queue.h](cours/018_files/queue.h) [schema-file.png](cours/018_files/schema-file.png)|[:memo:](#files)
|:heavy_check_mark:|[19. Listes](cours/019_listes)|[main.c](cours/019_listes/main.c) [list.c](cours/019_listes/list.c) [list.h](cours/019_listes/list.h) [schema-liste.png](cours/019_listes/schema-liste.png)|[:memo:](#listes)
|:heavy_check_mark:|[20. Dlist](cours/020_listes_doublement_chaînées)|[main.c](cours/020_listes_doublement_chaînées/main.c) [dlist.c](cours/020_listes_doublement_chaînées/dlist.c) [dlist.h](cours/020_listes_doublement_chaînées/dlist.h) [schema-liste-doublement-chainee.png](cours/020_listes_doublement_chaînées/schema-liste-doublement-chainees.png)|[:memo:](#listes-doublement-chaînées)
|:heavy_check_mark:|[21. Arbres binaires](cours/021_arbres_binaires)|[main.c](cours/021_arbres_binaires/main.c) [tree.c](cours/021_arbres_binaires/tree.c) [tree.h](cours/021_arbres_binaires/tree.h)|[:memo:](#Arbres-binaires)
|:heavy_check_mark:|[22. Graph](cours/022_graphes)|[main.c](cours/022_graphes/main.c) [graph.c](cours/022_graphes/graph.c) [graph.h](cours/022_graphes/graph.h)  [graph.out](cours/022_graphes/graph.out) [digraph.out](cours/022_graphes/digraph.out)|[:memo:](#Graphes)

### La bibliothèque SDL

||notes de cours|fichiers|pense-bêtes
-|:-|:-:|:-:
|:heavy_check_mark:|[23. Introduction SDL](cours/023_introduction_SDL/note.md)|[x86](SDL/x86) [x64](SDL/x64) [main.c](SDL/x64/src/m023.c)|[:memo:](#introduction-sdl)
|:heavy_check_mark:|[24. Création fenêtre](cours/024_création_fenêtre/note.md)|[x64](SDL/x64) [main.c](SDL/x64/src/m024.c)|[:memo:](#création-fenêtre)
|:heavy_check_mark:|[25. Création rendu](cours/025_création_rendu/note.md)|[x64](SDL/x64) [main.c](SDL/x64/src/m025.c)|[:memo:](#création-rendu)
|:heavy_check_mark:|[26. Création texture](cours/026_création_texture/note.md)|[x64](SDL/x64) [main.c](SDL/x64/src/m026.c)|[:memo:](#création-texture)
|:heavy_check_mark:|[27. Gestion d'événements (1/2)](cours/027_gestion_événements_01/note.md)|[x64](SDL/x64) [main.c](SDL/x64/src/m027.c)|[:memo:](#gestion-événements-01)
|:heavy_check_mark:|[28. Gestion d'événements (2/2)](cours/028_gestion_événements_02/note.md)|[x64](SDL/x64) [main.c](SDL/x64/src/m028.c)|[:memo:](#gestion-événements-02)
|:heavy_check_mark:|[29. Conclusion](cours/029_conclusion/note.md)

> [SDL2 Windows installation](https://www.libsdl.org/download-2.0.php) | [SDL2 Linux installation](https://doc.ubuntu-fr.org/sdl) {sudo apt-get install libsdl2-dev} 

## [tutos](tutoriels)

[Playlists C tutoriels](https://github.com/jasonchampagne/FormationVideo/blob/master/Playlists/c-tutoriels.md)  

||notes de tutoriels
-|:-
|:heavy_check_mark:|[afficher des images (SDL)](tutoriels/afficher_des_images_(SDL).md)
|:heavy_check_mark:|[arguments fonction main()](tutoriels/arguments_fonction.md)
|:heavy_check_mark:|[fichiers binaires](tutoriels/fichiers_binaires.md)
|:heavy_check_mark:|[généricité.md](tutoriels/généricité.md)
|:heavy_check_mark:|[gestion_erreurs.md](tutoriels/gestion_erreurs.md)
|:heavy_check_mark:|[lecture sécurisée](tutoriels/lecture_sécurisée.md)
|:heavy_check_mark:|[récursivité](tutoriels/récursivité.md)
|:heavy_check_mark:|[installer MinGW (old)](tutoriels/installer_MinGW.md)

## [Exercices](exercices)

[Playlists C exercices](https://github.com/jasonchampagne/FormationVideo/blob/master/Playlists/c-exercices.md)  

||notes de tutoriels
-|:-
|:heavy_check_mark:|[1. Affichage formaté](exercices/001_affichage_formaté/main.c)
|:heavy_check_mark:|[2. Rendez l'argent !](exercices/002_rendez_l'argent/main.c)
|:heavy_check_mark:|[3. Somme de nombres](exercices/003_somme_de_nombres/main.c)
|:heavy_check_mark:|[4. P'tite calculette](exercices/004_petite_calculette)
|:heavy_check_mark:|[5. Pointeurs (QCM)](exercices/005_pointeurs_qcm/note.md)
|:heavy_check_mark:|[6. Ballade en T](exercices/006_ballade_en_T)
|:heavy_check_mark:|[7. Tout compte fait](exercices/007_tout_compte_fait/main.c)
|:heavy_check_mark:|[8. À fond la caisse](exercices/008_a_fond_la_caisse/main.c)
|:heavy_check_mark:|[9. Entrez dans la matrice](exercices/009_entrez_dans_la_matrice/main.c)
|:heavy_check_mark:|[10. Un poti fichier](exercices/010_un_poti_fichier/main.c)
|:heavy_check_mark:|[11. Dans ta stack](exercices/011_dans_ta_stack)

> --------------------------------------------------------------------------------
> Notes
> --------------------------------------------------------------------------------

## [Introduction](cours/001_introduction/note.md)
> [Ken Thompson et Dennis Ritchie](cours/001_introduction/KenThompson_DennisRitchie.jpg)  
![KenThompson_DennisRitchie.jpg](cours/001_introduction/KenThompson_DennisRitchie.jpg)  

+ [Introduction](cours/001_introduction/note.md#Introduction)
+ [Compilation](cours/001_introduction/note.md#Compilation)
+ [Haut et bas niveau](cours/001_introduction/note.md#Haut-et-bas-niveau)
+ [Avantage du langage C](cours/001_introduction/note.md#Avantage-du-langage-C)
+ [Inconvénient du langage C](cours/001_introduction/note.md#Inconvénient-du-langage-C)
+ [Pourquoi choisir le C](cours/001_introduction/note.md#Pourquoi-choisir-le-C)

## [Compiler](cours/002_compiler/note.md)
> [main.c](cours/002_compiler/main.c)

## [Variables](cours/003_variables/note.md)
> [main.c](cours/003_variables/main.c) [Les mots réservés en C](cours/003_variables/mots_réservés.png) [Les type de variables en C](cours/003_variables/types_variables.png)

+ [Commentaires](cours/003_variables/note.md#Commentaires)
+ [Les types de variable](cours/003_variables/note.md#Les-types-de-variable)
+ [Les mots réservés](cours/003_variables/note.md#Les-mots-réservés)
+ [Déclarer une variable](cours/003_variables/note.md#Déclarer-une-variable)
    + [Nommage](cours/003_variables/note.md#Nommage)
    + [Typage](cours/003_variables/note.md#Typage)
    + [Déclarer une variable de type entier](cours/003_variables/note.md#Déclarer-une-variable-de-type-entier)
+ [Manipuler une variable](cours/003_variables/note.md#Manipuler-une-variable)
    + [Affecter une variable](cours/003_variables/note.md#Affecter-une-variable)
    + [Conversion de type (cast)](cours/003_variables/note.md#Conversion-de-type)
+ [Afficher une variable](cours/003_variables/note.md#Afficher-une-variable)
+ [Quelques mots-clés réservés](cours/003_variables/note.md#Quelques-mots-clés-réservés)
    + [const](cours/003_variables/note.md#const)
    + [volatile et register](cours/003_variables/note.md#volatile-et-register)

## [Lire données au clavier](cours/004_lire_données_au_clavier/note.md)
> [main.c](cours/004_lire_données_au_clavier/main.c)

## [Opérateurs](cours/005_operateurs/note.md)
> [main.c](cours/005_operateurs/main.c)

+ [Les différents opérateurs](cours/005_operateurs/note.md#Les-différents-opérateurs)
+ [Affectation statique](cours/005_operateurs/note.md#Affectation-statique)
+ [Affectation dynamique](cours/005_operateurs/note.md#Affectation-dynamique)
+ [Priorité des opérateurs](cours/005_operateurs/note.md#Priorité-des-opérateurs)
+ [Raccourcis sur les calculs entre variables](cours/005_operateurs/note.md#Raccourcis-sur-les-calculs-entre-variables)
+ [Incrémentation et décrémentation de 1](cours/005_operateurs/note.md#Incrémentation-et-décrémentation-de-1)
+ [Raccourcis sur les incrémentations et les décrémentations](cours/005_operateurs/note.md#Raccourcis-sur-les-incrémentations-et-les-décrémentations)

## [Conditions](cours/006_conditions/note.md)
> [main.c](cours/006_conditions/main.c)

+ [if](cours/006_conditions/note.md#if)
+ [Opérateurs de comparaisons](cours/006_conditions/note.md#Opérateurs-de-comparaisons)
+ [else](cours/006_conditions/note.md#else)
+ [Test booléen et opérateur de négation](cours/006_conditions/note.md#Test-booléen-et-opérateur-de-négation)
+ [else if](cours/006_conditions/note.md#else-if)
+ [Opérateurs de tests multiple](cours/006_conditions/note.md#Opérateurs-de-tests-multiple)
+ [switch](cours/006_conditions/note.md#switch)
+ [ternaire](cours/006_conditions/note.md#ternaire)

## [Boucles](cours/007_boucles/note.md)
> [main.c](cours/007_boucles/main.c)

+ [compteur](cours/007_boucles/note.md#compteur)
+ [while](cours/007_boucles/note.md#while)
+ [Condition d'arrêt](cours/007_boucles/note.md#Condition-arrêt)
+ [do while](cours/007_boucles/note.md#do-while)
+ [for](cours/007_boucles/note.md#for)
+ [break](cours/007_boucles/note.md#break)

## [Fonctions](cours/008_fonctions/note.md)
> [main.c](cours/008_fonctions/main.c)

+ [Créer une fonction](cours/008_fonctions/note.md#Créer-une-fonction)
+ [Prototype de fonction](cours/008_fonctions/note.md#Prototype-de-fonction)
+ [Portée des variables](cours/008_fonctions/note.md#Portée-des-variables)
+ [Une fonction sans valeur de retour](cours/008_fonctions/note.md#Une-fonction-sans-valeur-de-retour)

## [Programmation modulaire](cours/009_programmation_modulaire/note.md)
> [main.c](cours/009_programmation_modulaire/main.c) [player.c](cours/009_programmation_modulaire/player.c) [player.h](cours/009_programmation_modulaire/player.h)

+ [Définition de la modularité](cours/009_programmation_modulaire/note.md#Définition-de-la-modularité)
+ [Inclure nos bibliothèques](cours/009_programmation_modulaire/note.md#Inclure-nos-bibliothèques)
+ [Parenthèse sur les directives de préprocesseur](cours/009_programmation_modulaire/note.md#Directives-de-préprocesseur)
+ [La portée des variables](cours/009_programmation_modulaire/note.md#La-portée-des-variables)
+ [La variable static](cours/009_programmation_modulaire/note.md#La-variable-static)
+ [La fonction static](cours/009_programmation_modulaire/note.md#La-fonction-static)

## [Preprocesseurs](cours/010_preprocesseurs/note.md)
> [main.c](cours/010_preprocesseurs/main.c) [bibli.h](cours/010_preprocesseurs/bibli.h)

+ [include](cours/010_preprocesseurs/note.md#include)
+ [define](cours/010_preprocesseurs/note.md#define)
+ [Constantes prédéfinies du langage c](cours/010_preprocesseurs/note.md#Constantes-prédéfinies-du-langage-c)
```c
/*
    Constantes prédéfinies du langage c :
        __FILE__    (nom du fichier)
        __LINE__    (ligne du fichier)
        __DATE__    (date de compilation)
        __TIME__    (heure de compilation)
*/
```

## [Pointeurs](cours/011_pointeurs/note.md)
> [main.c](cours/011_pointeurs/main.c)

+ [Passage par valeurs](cours/011_pointeurs/note.md#Passage-par-valeurs)
    + [Retourner une valeur](cours/011_pointeurs/note.md#Retourner-une-valeur)
+ [Passage par adresse](cours/011_pointeurs/note.md#Passage-par-adresse)
    + [Définition pointeur](cours/011_pointeurs/note.md#Définition-pointeur)
    + [Différencier passage par valeur et passage par adresse](cours/011_pointeurs/note.md#Différencier-passage-par-valeur-et-passage-par-adresse)
+ [Créer des pointeurs](cours/011_pointeurs/note.md#Créer-des-pointeurs)
    + [Avantages des pointeurs](cours/011_pointeurs/note.md#Avantages-des-pointeurs)
+ [change_nombre - autre exemple de fonction](cours/011_pointeurs/note.md#change_nombre---autre-exemple-de-fonction)

```c
/*
    Pointeur : variable contenant l'adresse d'une autre variable
    %d -> affiche une adresse de variable ou pointeur

    [VARIABLES]
        maVariable  : valeur de la variable
        &maVariable : adresse de la variable

    [POINTEURS]
        *monPointeur = NULL ou *monPointeur = &maVariable
        (déclaration et initialisation d'un pointeur)

        monPointeur : adresse de la variable pointée
        *monPointeur : valeur de la variable pointée
        &monPointeur : adresse du pointeur
*/
```

## [Tableaux](cours/012_tableaux/note.md)
> [main.c](cours/012_tableaux/main.c)

+ [Déclaration tableau](cours/012_tableaux/note.md#Déclaration-tableau) `<type> <nom_tableau>[X]; //Déclare avec valeurs aléatoires`
+ [Accès au tableau](cours/012_tableaux/note.md#Accès-au-tableau) `tableau[X] : élément d'indice X (X+1ème élément du tableau)`
+ [Initialisation](cours/012_tableaux/note.md#Initialisation)
+ [Afficher](cours/012_tableaux/note.md#Afficher)
+ [Accès au tableau - les pointeurs](cours/012_tableaux/note.md#Accès-au-tableau---les-pointeurs)
+ [Fonctions](cours/012_tableaux/note.md#Fonctions)
    + [afficher_tableau()](cours/012_tableaux/note.md#afficher_tableau)
    + [creer_tableau()](cours/012_tableaux/note.md#creer_tableau())
+ [Tableau à deux dimensions](cours/012_tableaux/note.md#Tableau-à-deux-dimensions)

```c
/*
    [Déclaration tableau]
        <type> <nom_tableau>[X]; //Déclare avec valeurs aléatoires

    [Initialisation]
        tableau[5] = {valeur1, valeur2, valeur3, valeur4, valeur5};
        tableau[5] = {0}; //Toutes les cases valent 0
        tableau[5] = {4}; //Première case à 4, le reste à 0
        tableau[5] = {4, 3}; //Deux première cases à 4 et 3, le reste à 0
      
    [Accès au tableau]
        tableau[X]      : élément d'indice X (X+1ème élément du tableau)

        tableau         : adresse du tableau
        *tableau        : premier élément du tableau
        *(tableau + X)  : élément d'indice X

    (NOTE)
        tableau[5] même chose que -> *(tableau + 5)
*/
```

## [Chaînes de caractères](cours/013_chaînes_de_caractères/note.md)
> [main.c](cours/013_chaînes_de_caractères/main.c)

+ [Définition](cours/014_structures_et_types/note.md#Définition)
+ [Déclaration et initialisation](cours/014_structures_et_types/note.md#Déclaration-et-initialisation)
+ [Afficher](cours/014_structures_et_types/note.md#Afficher)
+ [Préciser une taille](cours/014_structures_et_types/note.md#Préciser-une-taille)
+ [Intialiser comme un tableau](cours/014_structures_et_types/note.md#Intialiser-comme-un-tableau)
+ [Modifier une chaîne](cours/014_structures_et_types/note.md#Modifier-une-chaîne)
+ [Fonctions](cours/014_structures_et_types/note.md#Fonctions)
    + [strcpy](cours/014_structures_et_types/note.md#strcpy)
    + [strlen](cours/014_structures_et_types/note.md#strlen)
    + [strcmp](cours/014_structures_et_types/note.md#strcmp)
    + [strcat](cours/014_structures_et_types/note.md#strcat)
    + [strstr](cours/014_structures_et_types/note.md#strstr)
    + [strchr](cours/014_structures_et_types/note.md#strchr)
    + [sprintf](cours/014_structures_et_types/note.md#sprintf)

## [Structures et types](cours/014_structures_et_types/note.md)
> [main.c](cours/014_structures_et_types/main.c)

+ [struct est un type de structure](cours/014_structures_et_types/note.md#struct-est-un-type-de-structure)
    + [Créer une structure](cours/014_structures_et_types/note.md#Créer-une-structure)
    + [Déclarer et initialiser une structure](cours/014_structures_et_types/note.md#Déclarer-et-initialiser-une-structure)
    + [Afficher les valeurs de variables de structures](cours/014_structures_et_types/note.md#Afficher-les-valeurs-de-variables-de-structures)
    + [Définir un type de variable avec typedef](cours/014_structures_et_types/note.md#Définir-un-type-de-variable-avec-typedef)
    + [Modifier une variable de structure](cours/014_structures_et_types/note.md#Modifier-une-variable-de-structure)
    + [Initialiser une structure via une fonction](cours/014_structures_et_types/note.md#Initialiser-une-structure-via-une-fonction)
    + [Un tableau de Player](cours/014_structures_et_types/note.md#Un-tableau-de-Player)
+ [enum est un autre type de structure](cours/014_structures_et_types/note.md#enum-est-un-autre-type-de-structure)
+ [union](cours/014_structures_et_types/note.md#union)
    + [Identifier les valeurs des énumération - petite parenthèse](cours/014_structures_et_types/note.md#Identifier-les-valeurs-des-énumération---petite-parenthèse)
    + [Les unions](cours/014_structures_et_types/note.md#Les-unions)

## [Allocation dynamique mémoire](cours/015_allocation_dynamique_mémoire/note.md)
> [main.c](cours/015_allocation_dynamique_mémoire/main.c) [types_variables.png](cours/015_allocation_dynamique_mémoire/types_variables.png)

[stdlib.h](cours/015_allocation_dynamique_mémoire/note.md#stdlib)

+ [malloc](cours/015_allocation_dynamique_mémoire/note.md#malloc)
+ [sizeof](cours/015_allocation_dynamique_mémoire/note.md#sizeof)
+ [free](cours/015_allocation_dynamique_mémoire/note.md#free)
    + [1e compilation et exécution](cours/015_allocation_dynamique_mémoire/note.md#1e-compilation-et-exécution)
+ [calloc](cours/015_allocation_dynamique_mémoire/note.md#calloc)
+ [realloc](cours/015_allocation_dynamique_mémoire/note.md#realloc)

## [Fichiers](cours/016_fichiers/note.md)
> [main.c](cours/016_fichiers/main.c) [016-R.txt](cours/016_fichiers/016-R.txt) [016-W.txt](cours/016_fichiers/016-W.txt)

+ [fopen](cours/016_fichiers/note.md#fopen)
+ [fclose](cours/016_fichiers/note.md#fclose)
+ [feof](cours/016_fichiers/note.md#feof)

+ [LECTURE](cours/016_fichiers/note.md#LECTURE)
    + [fgetc](cours/016_fichiers/note.md#fgetc)
    + [fgets](cours/016_fichiers/note.md#fgets)
    + [fscanf](cours/016_fichiers/note.md#fscanf)

+ [ECRITURE](cours/016_fichiers/note.md#ECRITURE)
    + [fputc](cours/016_fichiers/note.md#fputc)
    + [fputs](cours/016_fichiers/note.md#fputs)
    + [fprintf](cours/016_fichiers/note.md#fprintf)

+ [POSITIONNEMENT](cours/016_fichiers/note.md#POSITIONNEMENT)
    + [ftell](cours/016_fichiers/note.md#ftell)
    + [fseek](cours/016_fichiers/note.md#fseek)
    + [rewind](cours/016_fichiers/note.md#rewind)

+ [DIVERS](cours/016_fichiers/note.md#DIVERS)
    + [rename](cours/016_fichiers/note.md#rename)
    + [remove](cours/016_fichiers/note.md#remove)

## [Piles](cours/017_piles/note.md)
> [entiers.c](cours/017_piles/entiers.c) [stack-entiers.c](cours/017_piles/stack-entiers.c) [stack-entiers.h](cours/017_piles/stack-entiers.h) [joueurs.c](cours/017_piles/joueurs.c) [joueurs.c](cours/017_piles/joueurs.c) [schema-pile.png](cours/017_piles/schema-pile.png) [schema-pile-2.png](cours/017_piles/schémas/00.PNG)

+ [Type booléen](cours/017_piles/note.md#Type-booléen)
+ [Définition d'une Pile](cours/017_piles/note.md#Définition-de-la-Pile)
+ [new_stack](cours/017_piles/note.md#new_stack)
+ [is_empty_stack](cours/017_piles/note.md#is_empty_stack) | [1e compilation et exécution](cours/017_piles/note.md#1e-compilation-et-exécution)
+ [push_stack](cours/017_piles/note.md#push_stack)
+ [clear_stack](cours/017_piles/note.md#clear_stack) | [2e compilation et exécution](cours/017_piles/note.md#2e-compilation-et-exécution)
+ [print_stack](cours/017_piles/note.md#print_stack) | [3e compilation et exécution](cours/017_piles/note.md#3e-compilation-et-exécution)
+ [pop_stack](cours/017_piles/note.md#pop_stack) | [4e compilation et exécution](cours/017_piles/note.md#4e-compilation-et-exécution)
+ [clear_stack optimisé](cours/017_piles/note.md#clear_stack-optimisé) | [5e compilation et exécution](cours/017_piles/note.md#5e-compilation-et-exécution)
+ [top_stack](cours/017_piles/note.md#top_stack) | [6e compilation et exécution](cours/017_piles/note.md#6e-compilation-et-exécution)
+ [stack_length](cours/017_piles/note.md#stack_length) | [7e compilation et exécution](cours/017_piles/note.md#7e-compilation-et-exécution)
+ [Bonus pour définir des joueurs plutôt que des entiers](cours/017_piles/note.md#Bonus-pour-définir-des-joueurs-plutôt-que-des-entiers)
    + [modification des définitions](cours/017_piles/note.md#modification-des-définitions)
    + [modification de print_stack](cours/017_piles/note.md#modification-de-print_stack)
    + [modification de push_stack](cours/017_piles/note.md#modification-de-push_stack)
    + [modification de top_stack](cours/017_piles/note.md#modification-de-top_stack)
    + [modification de main](cours/017_piles/note.md#modification-de-main)
+ [8e compilation et exécution](cours/017_piles/note.md#8e-compilation-et-exécution)

## [Files](cours/018_files/note.md)
> [main.c](cours/018_files/main.c) [queue.c](cours/018_files/queue.c) [queue.h](cours/018_files/queue.h) [schema-file.png](cours/018_files/schema-file.png)

+ [Bool](cours/018_files/note.md#Bool)
+ [Paramètres de la File](cours/018_files/note.md#Paramètres-de-la-File)
+ [is_empty_queue](cours/018_files/note.md#is_empty_queue) | [1e compilation et exécution](cours/018_files/note.md#1e-compilation-et-exécution)
+ [queue_length](cours/018_files/note.md#queue_length)
+ [queue_first](cours/018_files/note.md#queue_first)
+ [queue_last](cours/018_files/note.md#queue_last)
+ [print_queue](cours/018_files/note.md#print_queue)
+ [push_queue](cours/018_files/note.md#push_queue)
+ [pop_queue](cours/018_files/note.md#queue_last)
+ [queue_last](cours/018_files/note.md#queue_last) | [2e compilation et exécution](cours/018_files/note.md#2e-compilation-et-exécution)
+ [clear_queue](cours/018_files/note.md#clear_queue) | [3e compilation et exécution](cours/018_files/note.md#3e-compilation-et-exécution)

## [Listes](cours/019_listes/note.md)
> [main.c](cours/019_listes/main.c) [list.c](cours/019_listes/list.c) [list.h](cours/019_listes/list.h) [schema-liste.png](cours/019_listes/schema-liste.png)

1. [Définition de la structure ListElement](cours/019_listes/note.md#Définition-de-la-structure-ListElement)
1. [Prototypes et fonctions](cours/019_listes/note.md#Prototypes-et-fonctions)
    1. [new_list](cours/019_listes/note.md#new_list)
    1. [is_empty_list](cours/019_listes/note.md#is_empty_list)
    1. [list_length](cours/019_listes/note.md#list_length)
    1. [print_list](cours/019_listes/note.md#print_list)
1. [1e compilation et exécution](cours/019_listes/note.md#1e-compilation-et-exécution)
    1. [push_back_list](cours/019_listes/note.md#push_back_list)
    1. [push_front_list](cours/019_listes/note.md#push_front_list)
    1. [pop_back_list](cours/019_listes/note.md#pop_back_list)
    1. [pop_front_list](cours/019_listes/note.md#pop_front_list)
1. [2e compilation et exécution](cours/019_listes/note.md#2e-compilation-et-exécution)
    1. [clear_list](cours/019_listes/note.md#clear_list)
1. [3e compilation et exécution](cours/019_listes/note.md#3e-compilation-et-exécution)

## [Listes doublement chaînées](cours/020_listes_doublement_chaînées/note.md)
> [main.c](cours/020_listes_doublement_chaînées/main.c) [dlist.c](cours/020_listes_doublement_chaînées/dlist.c) [dlist.h](cours/020_listes_doublement_chaînées/dlist.h) [schéma-liste-doublement-chaînée.png](cours/020_listes_doublement_chaînées/schema-liste-doublement-chainees.png)

1. [Définition](cours/020_listes_doublement_chaînées/note.md#Définition)
    1. [Un maillon de la DList](cours/020_listes_doublement_chaînées/note.md#Un-maillon-de-la-DList)
    1. [Une DListe](cours/020_listes_doublement_chaînées/note.md#Une-DListe)
1. [Prototypes](cours/020_listes_doublement_chaînées/note.md#Prototypes)
    1. [new_dlist](cours/020_listes_doublement_chaînées/note.md#new_dlist)
    1. [is_empty_dlist](cours/020_listes_doublement_chaînées/note.md#is_empty_dlist)
    1. [dlist_length](cours/020_listes_doublement_chaînées/note.md#dlist_length)
    1. [dlist_first](cours/020_listes_doublement_chaînées/note.md#dlist_first)
    1. [dlist_last](cours/020_listes_doublement_chaînées/note.md#dlist_last)
    1. [push_back_dlist](cours/020_listes_doublement_chaînées/note.md#push_back_dlist)
    1. [push_front_dlist](cours/020_listes_doublement_chaînées/note.md#push_front_dlist)
    1. [pop_back_dlist](cours/020_listes_doublement_chaînées/note.md#pop_back_dlist)
    1. [pop_front_dlist](cours/020_listes_doublement_chaînées/note.md#pop_front_dlist)
    1. [print_dlist](cours/020_listes_doublement_chaînées/note.md#print_dlist)
1. [Compilation et exécution](cours/020_listes_doublement_chaînées/note.md#Compilation-et-exécution)
    1. [clear_dlist](cours/020_listes_doublement_chaînées/note.md#clear_dlist)

## [Arbres binaires](cours/021_arbres_binaires/note.md)
> [main.c](cours/021_arbres_binaires/main.c) [tree.c](cours/021_arbres_binaires/tree.c) [tree.h](cours/021_arbres_binaires/tree.h)

1. [La structure Tree](cours/021_arbres_binaires/note.md#La-structure-Tree)
1. [La fonction new_tree](cours/021_arbres_binaires/note.md#La-fonction-new_tree)
1. [1e compilation et exécution](cours/021_arbres_binaires/note.md#1e-compilation-et-exécution) *attention à bien libérer la mémoire malloc() & free()*
1. [La fonction clean_tree](cours/021_arbres_binaires/note.md#La-fonction-clean_tree)
    + [Récursivité](tutoriels/récursivité.md)
1. [2e compilation et exécution](cours/021_arbres_binaires/note.md#2e-compilation-et-exécution) 
1. [La fonction print_tree_prefix](cours/021_arbres_binaires/note.md#La-fonction-print_tree_prefix) *pour une fonction postfix on inverse l'affichage de tleft et tright*
1. [3e compilation et exécution](cours/021_arbres_binaires/note.md#3e-compilation-et-exécution) 
1. [La fonction count_tree_nodes](cours/021_arbres_binaires/note.md#La-fonction-count_tree_nodes) 

## [Graphes](cours/022_graphes/note.md)
> [main.c](cours/022_graphes/main.c) [graph.c](cours/022_graphes/graph.c) [graph.h](cours/022_graphes/graph.h)  

1. [Définitions des structures](cours/022_graphes/note.md#Définitions-des-structures)
    1. [Bool](cours/022_graphes/note.md#Bool)
    1. [NodeListElement](cours/022_graphes/note.md#NodeListElement)
    1. [AdjencyListElement](cours/022_graphes/note.md#AdjencyListElement)
    1. [GraphElement](cours/022_graphes/note.md#GraphElement)
1. [new_graph](cours/022_graphes/note.md#new_graph)
    1. [Prototype de new_graph](cours/022_graphes/note.md#Prototype-de-new_graph)
    1. [Implémentation de new_graph](cours/022_graphes/note.md#Implémentation-de-new_graph)
1. [is_empty_graph](cours/022_graphes/note.md#is_empty_graph)
1. [add_node](cours/022_graphes/note.md#add_node)
1. [erase_graph](cours/022_graphes/note.md#erase_graph)
    1. [Définition erase_graph](cours/022_graphes/note.md#Définition-erase_graph)
    1. [Parenthèse pointeur et structure](cours/022_graphes/note.md#Parenthèse-pointeur-et-structure)
    1. [Début implémentation erase_graph](cours/022_graphes/note.md#Début-implémentation-erase_graph)
1. [add_edge](cours/022_graphes/note.md#add_edge)
    1. [Fin implémentation erase_graph](cours/022_graphes/note.md#Fin-implémentation-erase_graph)
1. [Compilation et exécution](cours/022_graphes/note.md#Compilation-et-exécution)
1. [print_graph](cours/022_graphes/note.md#print_graph)
1. [Execution et affichage](cours/022_graphes/note.md#Execution-et-affichage)
1. [Graphviz](cours/022_graphes/note.md#Graphviz)
    1. [Ajouter un champ FILE à la structure GraphElement](cours/022_graphes/note.md#Ajouter-un-champ-FILE-à-la-structure-GraphElement)
    1. [Création du fichier Graphviz](cours/022_graphes/note.md#Création-du-fichier-Graphviz)
    1. [Ajouter un lien dans le fichier Graphviz](cours/022_graphes/note.md#Ajouter-un-lien-dans-le-fichier-Graphviz)
    1. [Fin et fermeture du fichier Graphviz](cours/022_graphes/note.md#Fin-et-fermeture-du-fichier-Graphviz)
1. [display_graph](cours/022_graphes/note.md#display_graph)

## [Introduction SDL](cours/023_introduction_SDL/note.md)
> [m023.c](SDL/x64/src/m023.c) [x64](SDL/x64)  
> [SDL2 - Memento (Jason Champagne)](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/C/memento-sdl.md)  
> [SDL2 Windows installation](https://www.libsdl.org/download-2.0.php)  
> [SDL2 Linux installation](https://doc.ubuntu-fr.org/sdl) {sudo apt-get install libsdl2-dev}  
> [SDL2 - documentation officielle](https://www.libsdl.org/release/SDL-1.2.15/docs/html/)  
> [SDL 2.0.14](https://www.libsdl.org/download-2.0.php) [x86](cours/023_introduction_SDL/x86) [x64](cours/023_introduction_SDL/x64)

## [Création fenêtre](cours/024_création_fenêtre/note.md)
> [m024.c](SDL/x64/src/m024.c) [x64](SDL/x64)  
> [Memento SDL](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/C/memento-sdl.md)  
> [SDL2 : documentation officielle](https://www.libsdl.org/release/SDL-1.2.15/docs/html/)  

1. [Initialisation & Libération](cours/024_création_fenêtre/note.md#initialisation-&-Libération)  
    1. [SDL_Init](cours/024_création_fenêtre/note.md#sdl_init)  
    1. [SDL_Log & SdlGetError](cours/024_création_fenêtre/note.md#sdl_log-&-sdlgeterror)  
    1. [SDL_Quit](cours/024_création_fenêtre/note.md#sdl_quit)  
    1. [Sous-système](cours/024_création_fenêtre/note.md#sous-système)  
    1. [Récapitulation et initialisation](cours/024_création_fenêtre/note.md#récapitulation-et-initialisation)  
1. [Afficher une fenêtre](cours/024_création_fenêtre/note.md#afficher-une-fenêtre)  
    1. [SDL_Window](cours/024_création_fenêtre/note.md#sdl_window)  
    1. [SDL_CreateWindow](cours/024_création_fenêtre/note.md#sdl_createwindow)  :warning: [SDL_DestroyWindow](cours/025_création_rendu/note.md#SDL_DestroyWindow)
1. [Compilation & exécution](cours/024_création_fenêtre/note.md#compilation-&-exécution)  
    1. [SDL_Delay](cours/024_création_fenêtre/note.md#sdl_delay)  
1. [Memento](cours/024_création_fenêtre/note.md#memento)  

## [Création rendu](cours/025_création_rendu/note.md)
> [m025.c](SDL/x64/src/m025.c) [x64](SDL/x64)  

1. [SDL_DestroyWindow](cours/025_création_rendu/note.md#SDL_DestroyWindow) 
1. [SDL_ExitWithError (c)JC](cours/025_création_rendu/note.md#SDL_ExitWithError) 
1. [Création d'un rendu](cours/025_création_rendu/note.md#création-rendu)  
    1. [SDL_CreateRenderer](cours/025_création_rendu/note.md#SDL_CreateRenderer)  
    1. [SDL_DestroyRenderer](cours/025_création_rendu/note.md#SDL_DestroyRenderer)  
    1. [SDL_RenderPresent](cours/025_création_rendu/note.md#SDL_RenderPresent)  
    1. [SDL_RenderClear](cours/025_création_rendu/note.md#SDL_RenderClear)  
1. [SDL_CreateWindowAndRenderer](cours/025_création_rendu/note.md#SDL_CreateWindowAndRenderer)  
1. [SDL_SetRenderDrawColor](cours/025_création_rendu/note.md#SDL_SetRenderDrawColor)  
1. [SDL_RenderDrawPoint/Line/Rect](cours/025_création_rendu/note.md#SDL_RenderDraw)  
    1. [SDL_RenderDrawPoint](cours/025_création_rendu/note.md#SDL_RenderDrawPoint)  
    1. [SDL_RenderDrawLine](cours/025_création_rendu/note.md#SDL_RenderDrawLine)  
    1. [SDL_RenderDrawRect](cours/025_création_rendu/note.md#SDL_RenderDrawRect)  
    1. [SDL_RenderFillRect](cours/025_création_rendu/note.md#SDL_RenderFillRect)  

## [Création texture](cours/026_création_texture/note.md)
> [m026.c](SDL/x64/src/m026.c) [x64](SDL/x64)  

1. [SDL_loadBMP](cours/026_création_texture/note.md#SDL_loadBMP)
1. [SDL_CreateTextureFromSurface](cours/026_création_texture/note.md#SDL_CreateTextureFromSurface)
1. [SDL_FreeSurface](cours/026_création_texture/note.md#SDL_FreeSurface)
1. [SDL_QueryTexture](cours/026_création_texture/note.md#SDL_QueryTexture)
    1. [define width & height](cours/026_création_texture/note.md#define-width-et-height)
1. [SDL_RenderCopy](cours/026_création_texture/note.md#SDL_RenderCopy)
1. [SDL_RenderPresent](cours/026_création_texture/note.md#SDL_RenderPresent)

## [Gestion événements 01](cours/027_gestion_événements_01/note.md)
> [m027.c](SDL/x64/src/m027.c) [x64](SDL/x64)

### [Partie 1](cours/027_gestion_événements_01/note.md#Partie-1)
1. [SDL_bool](cours/027_gestion_événements_01/note.md#SDL_bool)
1. [SDL_Event](cours/027_gestion_événements_01/note.md#SDL_Event)
1. [SDL_PollEvent](cours/027_gestion_événements_01/note.md#SDL_PollEvent)
    1. [event.type](cours/027_gestion_événements_01/note.md#event-type)
        1. [SDL_QUIT](cours/027_gestion_événements_01/note.md#SDL_QUIT)
1. [SDL_WaitEvent](cours/027_gestion_événements_01/note.md#SDL_WaitEvent)

### [Partie 2](cours/027_gestion_événements_01/note.md#Partie-2)
1. [SDL_KeyboardEvent](cours/027_gestion_événements_01/note.md#SDL_KeyboardEvent)
1. [SDL_KEYDOWN](cours/027_gestion_événements_01/note.md#SDL_KEYDOWN)
    1. [event.key.keysym.sym](cours/027_gestion_événements_01/note.md#event-key-keysym-sym)
        1. [SDLK_b](cours/027_gestion_événements_01/note.md#SDLK_b)
1. [SDL_KEYUP](cours/027_gestion_événements_01/note.md#SDL_KEYUP)

## [Gestion événements 02](cours/028_gestion_événements_02/note.md)
> [m028.c](SDL/x64/src/m028.c) [x64](SDL/x64)

### [Partie 1](cours/028_gestion_événements_02/note.md#Partie-1)
1. [SDL_MOUSEMOTION](cours/028_gestion_événements_02/note.md#SDL_MOUSEMOTION)
    1. [event.motion.x-y-xrel-yrel](cours/028_gestion_événements_02/note.md#event-motion-x-y-xrel-yrel)
1. [SDL_MOUSEBUTTONDOWN](cours/028_gestion_événements_02/note.md#SDL_MOUSEBUTTONDOWN)
    1. [event.button.x-y](cours/028_gestion_événements_02/note.md#event-button-x-y)
    1. [event.button.clicks](cours/028_gestion_événements_02/note.md#event-button-clicks)
    1. [event.button.button](cours/028_gestion_événements_02/note.md#event-button-button)
        1. [SDL_BUTTON_LEFT-MIDDLE-RIGHT](cours/028_gestion_événements_02/note.md#SDL_BUTTON_LEFT-MIDDLE-RIGHT)
        1. [SDL_BUTTON_WHEEL](cours/028_gestion_événements_02/note.md#SDL_BUTTON_WHEEL)

### [Partie 2](cours/028_gestion_événements_02/note.md#Partie-2)
1. [SDL_WINDOWEVENT](cours/028_gestion_événements_02/note.md#SDL_WINDOWEVENT)
    1. [event.window.event](cours/028_gestion_événements_02/note.md#event-window-event)  
        SDL_WINDOWEVENT_SHOWN | MOVED | RESIZED | MINIMIZED | RESTORED | CLOSED | ENTER | LEAVE  
    1. [event.window.data1-data2](cours/028_gestion_événements_02/note.md#event-window-data1-data2)
1. [SDL_GetTicks](cours/028_gestion_événements_02/note.md#SDL_GetTicks) > [Code Bonus fps](cours/028_gestion_événements_02/note.md#Code-Bonus-fps)

## [Conclusion](cours/029_conclusion/note.md)