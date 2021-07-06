/**
 *      YouTube: https://www.youtube.com/watch?v=Qra-0U_jEKs
 *      Description:  Langage C #11 - pointeurs
 *      Created:  17-02-20 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Compilation:    gcc main.c -o prog
 *      Author:  Samuel Jacquet
 */


#include <stdio.h>
/* 
    Mémoire RAM :

    Adresse         Valeur      Nom (étiquette)
    0x00000001      15          nombreA (de la fonction "main")
    0x00000002
    ...
    ...
    0x00001A10      15->28      nombreA (de la fonction "inverser_nombres").
    0x00001A11      28->25      nombreB (de la fonction "inverser_nombres").
    ...
    0xFFFF00A5      28          nombreB (de la fonction "main")
*/

// Ne retourne pas deux nombre inverser grace à une variable temporaire.
void inverser_nombres_1(int nombreA, int nombreB)// On fait un passage par valeurs : copie des variables de la main.
{
    int temporaire = nombreB;
    printf("FONCTION AVANT : A = %d et B = %d\n", nombreA, nombreB);
    nombreB = nombreA;
    nombreA = temporaire;
    printf("FONCTION APRES : A = %d et B = %d\n", nombreA, nombreB);
    //Portée de variable : la variable locale créer dans une fonction est détruite à la fin.
    //NombreA dans la fonction main est différent de nombreA dans la fonction inverser_nombre.
}

int inverser_nombres_2(int nombreA, int nombreB)// On fait un passage par valeurs : copie des variables de la main.
{
    int temporaire = nombreB;
    nombreB = nombreA;
    nombreA = temporaire;
    return nombreA;
    return nombreB; // Ligne qui ne serra jamais compilée, on sort au précédent return.
}

void inverser_nombres_3(int *nombreA, int *nombreB)// On fait un passage par adresses : copie des adresses.
{
    int temporaire = 0; //B.

    temporaire = *nombreB;
    *nombreB = *nombreA;
    *nombreA = temporaire;
    // Pas besoin de return avec les pointeurs.
}

void inverser_nombres_4(int *pt_nb1, int *pt_nb2)// Choisir un nom pour identifier mes pointeurs.
{
    int temporaire = 0; //B.

    temporaire = *pt_nb2;
    *pt_nb2 = *pt_nb1;
    *pt_nb1 = temporaire;
}

int change_nombre_01(int nb)
{
    nb = 15;
    return nb;
}

void change_nombre_02(int *nb)
{
    *nb = 15;
}

int main(void)
{
    int nombre = 100; // Demander l'autorisation au système, un emplacement mémoire vive/RAM pour y stocker ce nombre.
    int nombreA = 15;
    int nombreB = 28;

    /* #0# La fonction MAIN suffirait à inverser deux nombres mais dans les vrais projets, 
     * on organise le code sur plusieurs fichiers avec plusieurs fonctions afin de mieux 
     * répartir le travail (raison de sécurité, confidentialité, etc.).
     */
    printf("AVANT : A = %d et B = %d\n", nombreA, nombreB);
    
    /*#1# Le passage par valeur et la portée des variables.*/
    nombreA = 15;
    nombreB = 28;
    inverser_nombres_1(nombreA, nombreB); // Ici est détruit les variables nombreA et nombreB de la fonction "inverser_nombres".
    printf("APRES #1 : A = %d et B = %d\n", nombreA, nombreB);
    
    /*#2# Le passage par valeur et le retour possible d'une valeur.*/
    nombreA = 15;
    nombreB = 28;    
    nombreA = inverser_nombres_2(nombreA, nombreB); // Ici est détruit la variable nombreB.
    printf("APRES #2 : A = %d et B = %d\n", nombreA, nombreB);
    
    /* #3#      La première utilitée des pointeurs : modifier des données dans une fonction (autant que l'on veux).
     *          La seconde utilitée des pointeurs : éviter de faire des copies (Ok pour un entier mais pas pour des structures de données : listes chainées, liste de 1000 joueurs, arbres).
     *          La troisième utilitée des pointeurs : permet d'avoir plus de rapidité et de performance car on ne fait pas de copie.
     * 
     * Un pointeur : Variable qui contient l'adresse d'une autre variable.     
     *      Il permet de pointer une autre variable.
     *      Il permet de faire une référence et non une copie.
     *      Il est donc très léger en mémoire car on ne fait pas copie.
     *      symbolisé par une étoile *.
     *      %p : afficher une adresse de variable OU pointeur.
     *      & : esperluette qui permet de saisir une donnée avec scanf ou d'afficher l'adresse d'une variable avec printf/%p.
     * 
     * Variables :
     *      maVariable : valeur de la variable.
     *      &maVariable : adresse de la variable.
     *
     * Pointeurs : 
     *      *monPointeur = NULL OU *monPointeur = &maVariable (Déclaration et initialisation d'un pointeur, la création de pointeurs).
     *      
     *      monPointeur : adresse de la variable pointée.
     *      *monPointeur : valeur de lavariable pointée. -> Si on modifie la référence, on modifie aussi la valeur de la variable.
     *      &monPointeur : adresse du pointeur.
     */
    nombreA = 15;
    nombreB = 28; 
    printf("Adresse de NombreB =%p\n", &nombreB); // afficher l'adresse d'une variable.
    inverser_nombres_3(&nombreA, &nombreB); // passage par adresse.
    printf("APRES #3 : A = %d et B = %d\n", nombreA, nombreB);
    
    /* 
        ## En modifiant *nombreA, on modifie la valeur à l'adresse de référence. ##
        
        Mémoire RAM :

        Adresse         Valeur          Nom (étiquette)
        0x00000001      15              nombreA (de la fonction "main")
        0x00000002
        ...
        ...
        0x00001A10      {0x00000001}    *nombreA (pointeur qui pointe sur nombreA)
        0x00001A11      {0xFFFF00A5}    *nombreB (pointeur qui pointe sur nombreB)
        ...
        0xFFFF00A5      28              nombreB (de la fonction "main")
    */

    /* #4# Les pointeurs : création de pointeurs.
     * Déclaration et initialisation d'un pointeur : *monPointeur = NULL ou *monPointeur = &maVariable(affectation de l'adresse d'une variable).
     * NULL : valeur d'initialisation pour un pointeur pour dire qu'il pointe sur rien.
     */
    nombreA = 15;
    nombreB = 28;

    // Création de pointeur, facultatif dans ce cas.
    int *pointeurSurNombreA = &nombreA; // création : déclaration et initialisation.
    int *pointeurSurNombreB = &nombreB;

    inverser_nombres_4(pointeurSurNombreA, pointeurSurNombreB); // L'adresse de la variable pointée, c'est le nom tout cours (voir pense bête).
    printf("APRES #4 : A = %d et B = %d\n", nombreA, nombreB);

    /* #5# Les pointeurs : Si on a une valeur, on a pas besoin de pointeur.*/
    nombre = 0;
    printf("1. AVANT nombre #5 = %d\n",nombre);
    change_nombre_01(nombre); // Passage par valeur (désavantage de faire une copie).
    printf("1. APRES nombre #5 = %d\n",nombre);

    nombre = 0;
    printf("2. AVANT nombre #5 = %d\n",nombre);
    change_nombre_02(&nombre); // Passage par adresse (avantage de faire une référence).
    printf("2. APRES nombre #5 = %d\n",nombre);

    return 0;
}