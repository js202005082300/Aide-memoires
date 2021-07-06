/**
 *      YouTube: Langage C #8 - fonctions
 *      Description: https://www.youtube.com/watch?v=TT2RbNKr4aU
 *      Created:  20-01-2020 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Compilation: gcc main.c -o prog
 *      Author:  Samuel Jacquet
 */
 /*
    1. Exemple de fonctions : printf(); scanf(); ...
            printf et scanf utilisent du texte formaté.
            printf sert à afficher du texte formaté (%d, %s ..) sur la sortie standard.
            scanf sert à saisir du texte formaté (les drapeaux). Il n'est pas sécurisé.
    2. La fonction main :
        Le compilateur cherche d'habord un main avec void comme paramètre et retourne un entier.
    3. Créer une fonction 
            Elle porte un
                nom (init_ball)
                paramètre et son type
                une valeur de retour (retourne un int, un character, un float, ...)
            Elle fait une chose à la fois. 
            Elle sert à factoriser, globaliser quelque chose qui se répète.
                Modifier une seule variable plutôt que tout le programme.
    4. Les prototypes : indicateur de fonction qui prend un int, se nomme init_ball et retourne un int.
    5. La portée des variables : Toute variable locale créé dans une fonction est détruite à la fin.
            balleX n'existe que dans la fonction main ;
            posX n'existe que dans l'environnement de la fonction init_ball (elle est déclarée en paramètre)
    6. L'appel de fonction exemple : bonjour();
 */


#include <stdio.h>

// Prototype de la fonction posX.
int init_ball(int posX);
//int init_ball(int);
void bonjour(void);
int bonjour2(void);
int bonjour3(void);

int main(void)
{
    int balleX;
    int balleY;
    int retour_fonction;

    bonjour();
    retour_fonction = bonjour2();
    printf("Retour : %d\n", retour_fonction);
    
    retour_fonction = bonjour3();
    printf("Retour : %d (cast du texte)\n", retour_fonction);

    balleX = init_ball(balleX);
    printf("Apres la partie : %d\n",balleX);

    balleX = 175;

    balleX = init_ball(balleX);
    printf("Apres la partie : %d\n",balleX);


    return 0;
}

/*
*   Fonction init_ball
*   @param      posX
*   @return     Retourne la coordonnée X.
*/
int init_ball(int posX)
{
    posX = 150;

    // Un seul return par fonction.
    return posX; 
}

/*
*   Fonction vonjour
*   @param      void
*   @return     Affiche Bonjour
*/

void bonjour(void)
{
    printf("Bonjour :) !\n");
}

//
int bonjour2(void)
{
    printf("Bonjour :) !\n");

    return 1;
}
//
int bonjour3(void)
{
    return printf("Bonjour :) !\n");
}