/**
 *      YouTube: Langage C #5 - opérateurs
 *      Description: https://www.youtube.com/watch?v=imc6C96-TW8
 *      Created:  19-01-2020 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Compilation: gcc main.c -o prog
 *      Author:  Samuel Jacquet
 */
 /*
    1. Les opérateurs :
        + addition
        - soustraction
        * multiplication
        / division -> 5 / 2 = 2
        % modulo (reste de la division euclidienne) -> 5 % 2 = 1

        = opérateur d'affectation (moins prioritaire que les autres opérateurs)

    2. Les raccourcis
        <variable> = <variable> + X <--> <variable> += X
        <variable> = <variable> - X <--> <variable> -= X
        <variable> = <variable> * X <--> <variable> *= X
        <variable> = <variable> / X <--> <variable> /= X
        <variable> = <variable> % X <--> <variable> %= X

    3. Les raccourcis (post-/pre- in-/dé-crémentation)
        <variable> += 1 --> <variable> = <variable> + 1
        <variable> -= 1 --> <variable> = <variable> - 1        

        <variable>++    ++<variable>
        <variable>--    --<variable>
        Note :  post- ou pre- diffère à un bas niveau, au niveau des instructions machines.
                Pas de différence au niveau d'une boucle.


 */

#include <stdio.h> 

int main(void)
{
    
    // Expressions arithmétiques
    printf("%d\n", 6+4);
    printf("%d\n", 4+5*6);
    printf("%d\n", (4+5)*6);

    /*************/
    int niveau_joueur = 1;
    printf("Choisir le niveau de depart : ");
    scanf("%d",&niveau_joueur);

    printf("Niveau de depart : %d\n", niveau_joueur);

    // Le personnage a fait des quêtes ...

    niveau_joueur = niveau_joueur + 1;
    niveau_joueur++; // affectation avant l'incrémentation
    ++niveau_joueur; // incrémentation avant l'infectation
    printf("Niveau actuel : %d\n", niveau_joueur);


    return 0;
}