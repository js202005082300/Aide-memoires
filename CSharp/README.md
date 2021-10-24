:label: [FormationVidéo Git](https://github.com/jasonchampagne/FormationVideo) - [Ressources CSharp](https://github.com/jasonchampagne/FormationVideo/tree/master/Ressources/C%23)

# Le langage CSharp
> [Doc](https://docs.microsoft.com/fr-fr/dotnet/csharp/)  

## [Playlists C# cours](https://github.com/jasonchampagne/FormationVideo/blob/master/Playlists/csharp-cours.md)  

||notes de cours|fichiers|pense-bêtes
-|:-|:-:|:-:
|:heavy_check_mark:|[1. Introduction](cours/001_introduction/note.md)|-|[:memo:](#Introduction)
|:heavy_check_mark:|[2. Afficher du texte](cours/002_afficher_du_texte/note.md)|-|[:memo:](#Afficher-du-texte)
|:heavy_check_mark:|[3. Types de données](cours/003_type_de_données/note.md)|-|[:memo:](#Types-de-données)
|:heavy_check_mark:|[4. Variables](cours/004_variables/note.md)|-|[:memo:](#Variables)
|:heavy_check_mark:|[5. Opérateurs](cours/005_opérateurs/note.md)|-|[:memo:](#Opérateurs)
|:heavy_check_mark:|[6. Conditions](cours/006_conditions/note.md)|-|[:memo:](#Conditions)
|:heavy_check_mark:|[7. Boucles](cours/007_boucles/note.md)|-|[:memo:](#Boucles)
|:heavy_check_mark:|[8. Lecture au clavier](cours/008_lecture_au_clavier/note.md)|-|[:memo:](#Lecture-au-clavier)
|:heavy_check_mark:|[9. Méthodes](cours/009_méthodes/note.md)|-|[:memo:](#Méthodes)
|:heavy_check_mark:|[10. Structures et classes](cours/010_structures_et_classes/note.md)|-|[:memo:](#Structures-et-classes)
|:heavy_check_mark:|[11. Énumérations](cours/011_énumérations/note.md)|-|[:memo:](#Énumérations)
|:heavy_check_mark:|[12. Propriétés d'encapsulation](cours/012_propriétés_encapsulation/note.md)|-|[:memo:](#Propriétés-encapsulation)

## Introduction

+ [Installation](cours/001_introduction/note.md#Installation)
+ [créer un projet en mode console](cours/001_introduction/note.md#créer-un-projet-en-mode-console)
+ [Enpackter et créer une version de publication](cours/001_introduction/note.md#Enpackter-et-créer-une-version-de-publication)

## Afficher du texte

+ [La classe Console](cours/002_afficher_du_texte/note.md#La-classe-Console)
    + [La méthode WriteLine](cours/002_afficher_du_texte/note.md#La-méthode-WriteLine)
    + [La méthode Write](cours/002_afficher_du_texte/note.md#La-méthode-Write)
    + [La méthode Clear](cours/002_afficher_du_texte/note.md#La-méthode-Clear)
    + [La méhode Beep](cours/002_afficher_du_texte/note.md#La-méhode-Beep)
    + [L'attribut Title](cours/002_afficher_du_texte/note.md#Attribut-Title)
+ [Les caractères spéciaux](cours/002_afficher_du_texte/note.md#Les-caractères-spéciaux)
+ [Ecrire des commentaires](cours/002_afficher_du_texte/note.md#Ecrire-des-commentaires)

## Types de données

![types.PNG](cours/003_type_de_données/types.PNG)

## Variables

+ [Déclarer une variable](cours/004_variables/note.md#Déclarer-une-variable)
+ [Déclaration et initialisation](cours/004_variables/note.md#Déclaration-et-initialisation)
+ [Afficher une variable](cours/004_variables/note.md#Afficher-une-variable)
+ [Affectation](cours/004_variables/note.md#Affectation)
    + [Affecter une nouvelle valeur](cours/004_variables/note.md#Affecter-une-nouvelle-valeur)
    + [Affecter une variable à une autre](cours/004_variables/note.md#Affecter-une-variable-à-une-autre)
    + [Affecter le retour d'une expression](cours/004_variables/note.md#Affecter-le-retour-d-une-expression)
+ [Conversion numérique](cours/004_variables/note.md#Conversion-numérique)
+ [Afficher un grand nombre](cours/004_variables/note.md#Afficher-un-grand-nombre)
+ [Affecter une valeur de base différent de 10](cours/004_variables/note.md#Affecter-une-valeur-de-base-différent-de-10)
    + [Préfixes](cours/004_variables/note.md#Préfixes)
    + [Sufixes](cours/004_variables/note.md#Sufixes)
+ [Notations mathématiques](cours/004_variables/note.md#Notations-mathématiques)
    + [Puissance](cours/004_variables/note.md#Puissance)

## Opérateurs

+ [Opérateur affectation](cours/005_opérateurs/note.md#Opérateur-affectation) (=)
+ [Opérateurs arithmétiques binaires](cours/005_opérateurs/note.md#Opérateurs-arithmétiques-binaires) (+, -, *, /, %)
+ [Raccourcis](cours/005_opérateurs/note.md#Raccourcis) (=, +=, -=, *=, /=, %=)
+ [Opérateurs arithmétiques unaires](cours/005_opérateurs/note.md#Opérateurs-arithmétiques-unaires) (+, -, ++, --)
+ [Opérateurs (In)égalités (Booléen)](cours/005_opérateurs/note.md#Opérateurs-égalités) (==, !, <, >, <=, >=)
+ [Opérateurs binaires conditionnels (Booléen)](cours/005_opérateurs/note.md#Opérateurs-binaires-conditionnels) (&&, ||)
+ [Autres opérateurs](cours/005_opérateurs/note.md#Autres-opérateurs) (&, |, ^, <<, >>)
+ [Opérateur ternaire](cours/005_opérateurs/note.md#Opérateur-ternaire) (On verra plus tard !)
+ [Chaîne de caractères](cours/005_opérateurs/note.md#Chaîne-de-caractères)
    + [Réaffecter une nouvelle valeur à une chaîne](cours/005_opérateurs/note.md#Réaffecter-une-nouvelle-valeur-à-une-chaîne)
    + [Concaténation](cours/005_opérateurs/note.md#Concaténation)

## Conditions

+ [if](cours/006_conditions/note.md#if)
+ [else](cours/006_conditions/note.md#else)
+ [else if](cours/006_conditions/note.md#else-if)
+ [Cumuler les tests](cours/006_conditions/note.md#Cumuler-les-tests)
+ [switch](cours/006_conditions/note.md#switch)
+ [Opérateur ternaire](cours/006_conditions/note.md#Opérateur-ternaire)

## Boucles

+ [while](cours/007_boucles/note.md#while)
+ [do while](cours/007_boucles/note.md#do-while)
+ [break](cours/007_boucles/note.md#break)
+ [continue](cours/007_boucles/note.md#continue)
+ [for](cours/007_boucles/note.md#for)
+ [foreach](cours/007_boucles/note.md#foreach)

## Lecture au clavier

+ [La méthode Read](cours/008_lecture_au_clavier/note.md#La-méthode-Read)
+ [La méthode ReadLine](cours/008_lecture_au_clavier/note.md#La-méthode-ReadLine)
+ [Le type ConsoleKeyInfo et la méthode ReadKey](cours/008_lecture_au_clavier/note.md#Le-type-ConsoleKeyInfo-et-la-méthode-ReadKey)

## Méthodes

+ [Signature de méthode](cours/009_méthodes/note.md#Signature-de-méthode)
+ [Accèssibilité](cours/009_méthodes/note.md#Accèssibilité)
+ [Appel de la méthode](cours/009_méthodes/note.md#Appel-de-la-méthode)
+ [Modificateurs](cours/009_méthodes/note.md#Modificateurs)
+ [Fonction avec paramètres](cours/009_méthodes/note.md#Fonction-avec-paramètres)
+ [Récupérer le retour de fonction](cours/009_méthodes/note.md#Récupérer-le-retour-de-fonction)
+ [Une petite méthode de dialogue](cours/009_méthodes/note.md#Une-petite-méthode-de-dialogue)
    + [Paramètre par défaut](cours/009_méthodes/note.md#Paramètre-par-défaut)
    + [Paramètres nommés](cours/009_méthodes/note.md#Paramètres-nommés)
+ [Le passage par valeur](cours/009_méthodes/note.md#Le-passage-par-valeur)
+ [Le passage par référence](cours/009_méthodes/note.md#Le-passage-par-référence)
    + [ref](cours/009_méthodes/note.md#ref)
    + [in](cours/009_méthodes/note.md#in)
    + [out](cours/009_méthodes/note.md#out)
+ [Le corps d'expression](cours/009_méthodes/note.md#Le-corps-expression)

## Structures et classes

+ [Partie 1 - les structures](cours/010_structures_et_classes/note.md#Partie-1---les-structures)
    + [Créer une structure](cours/010_structures_et_classes/note.md#Créer-une-structure)
    + [Réécriture de la méthode ToString](cours/010_structures_et_classes/note.md#Réécriture-de-la-méthode-ToString)
    + [Structure ou classe ?](cours/010_structures_et_classes/note.md#Structure-ou-classe)
+ [Partie 2 - Les classes](cours/010_structures_et_classes/note.md#Partie-2---Les-classes)
    + [Ajouter un constructeur par défaut](cours/010_structures_et_classes/note.md#Ajouter-un-constructeur-par-défaut)
    + [Ajouter un attribut privé](cours/010_structures_et_classes/note.md#Ajouter-un-attribut-privé)
    + [Ajouter un constructeur où on doit préciser nous-même un champ](cours/010_structures_et_classes/note.md#Ajouter-un-constructeur-où-on-doit-préciser-nous-même-un-champ)
    + [Ajouter une ToString pour afficher les informations](cours/010_structures_et_classes/note.md#Ajouter-une-ToString-pour-afficher-les-informations)
    + [Modifier un attribut](cours/010_structures_et_classes/note.md#Modifier-un-attribut)
        + [le mot-clé const](cours/010_structures_et_classes/note.md#le-mot-clé-const)
        + [le mot-clé readonly](cours/010_structures_et_classes/note.md#le-mot-clé-readonly)
        + [le mot-clé abstract](cours/010_structures_et_classes/note.md#le-mot-clé-abstract)
        + [le mot-clé static](cours/010_structures_et_classes/note.md#le-mot-clé-static)
        + [Le mot-clé partial](cours/010_structures_et_classes/note.md#Le-mot-clé-partial)
+ [Modularité](cours/010_structures_et_classes/note.md#Modularité)

## Énumérations

+ [Usage de enum](cours/011_énumérations/note.md#Usage-de-enum)
+ [Une méthode extension](cours/011_énumérations/note.md#Une-méthode-extension)

## Propriétés encapsulation

+ [Usage de propriétés](cours/012_propriétés_encapsulation/note.md#Usage-de-propriétés)
+ [Réduire en corps d'expression](cours/012_propriétés_encapsulation/note.md#Réduire-en-corps-d-expression)
+ [Réduire la propriété en une ligne](cours/012_propriétés_encapsulation/note.md#Réduire-la-propriété-en-une-ligne)