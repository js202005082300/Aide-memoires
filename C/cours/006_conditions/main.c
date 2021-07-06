/**
 *      YouTube: Langage C #6 - conditions
 *      Description: https://www.youtube.com/watch?v=_MP8yZjQCgk
 *      Created:  19-01-2020 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Compilation: gcc main.c -o prog
 *      Author:  Samuel Jacquet
 */
 /*
    1. Structures conditionnelles : if(){}else{}

    2. Opérateurs de comparaison :
        ==  : égal à
        !=  : différent de
        <   : plus petit que
        >   : plus grand que
        <=  : plus petit ou égal à
        >=  : plus grand ou égal à
    
    3. Les opérateurs logiques
        &&  : ET
        ||  : OU
        !   : NOT

    4. Switch(){default : break;}
        Test sur un nom mais pas sur une chaine de caractère.
        Break pour quitter le if.
    
    5. L'opérateur ternaire
        <condition> : <test validé> ? <test non validé>

 */

#include <stdio.h> 

int main(void)
{
    
    int nombre = 12;
    int jeu_demarre = 12;
    int age = 375;
    int il_a_quinze_ans = -1;

    if(nombre == 0) // test que l'on veux vérifier
    {
        printf("Nombre vaut bien 0.\n");
    }
    else
    {
        printf("Nombre ne vaut pas 0.\n");
    }

    // Retourne vrai si jeu_demarre est différent de 0.
    if(jeu_demarre)
    {
        printf("Bienvenue sur le jeu.\n");
    }
    else
    {
        printf("Le jeu n'as pas ete lance ....\n");
    }

    // Retourne vrai si jeu_demarre est égale à 0.
    if(!jeu_demarre)
    {
        printf("Bienvenue sur le jeu.\n");
    }
    else
    {
        printf("Le jeu n'as pas ete lance ....\n");
    }

    // Tests liés par else if
    if(age < 0)
    {
        printf("Tu n'es pas ne.\n");
    }
    else if(age == 10)
    {
        printf("Tu as 10 ans.\n");
    }
    else
    {
        printf("Age : %d\n", age);
    }

    // Test à conditions multiple
    if(age < 1)
    {
        printf("Tu n'es pas ne.\n");
    }
    else if(age > 1 && age < 100) // ET : les deux doivent être validées.
    {
        printf("Tu as un age compris entre 1 et 100 ans.\n");
    }
    else if(age == 1 || age == 100) // OU : un des deux doit être validé.
    {
        printf("Tu as 1 ou 100 ans.\n");
    }
    else
    {
        printf("Wahh, tu as plus de 100 ans\n");
    }

    // Test à conditions multiple avec des parenthèses
    if(age < 1)
    {
        printf("Tu n'es pas ne.\n");
    }
    else if((age >= 1 && age <= 100) || age == 375) // ET : les deux doivent être validées.
    {
        printf("Tu as un age compris entre 1 et 100 ans ou 375 ans.\n");
    }
    else
    {
        printf("Wahh, tu as plus de 100 ans et tu n'as pas 375 ans.\n");
    }

    // Switch
    switch(age)
    {
        case 0:
            printf("Tu as 0 an.\n");
            break;

        case 15:
            printf("Tu as 15 ans.\n");
            break;

        default:
            printf("Tu n'as ni 0 an, ni 15 ans.\n");
            break;
    }

    // Opérateur ternaire
    (age == 15) ? printf("Tu as 15 ans.\n") : printf("Tu n'as pas 15 ans.\n");
    il_a_quinze_ans = (age == 15) ?  1 : 0; // stocker le résultat dans une variable.

    printf("Il a quinze ans = %d.\n", il_a_quinze_ans);

    return 0;
}