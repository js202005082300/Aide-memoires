/* 
EXERCICES C #1
[Révision : affichage/saisie, variables]
> Ecrire un programme qui demande un nombre entier à l'utilisateur et affiche la valeur de la saisie en octal et héxadécimal

> Indications :
    - Formater en octal -> %o
    - Formater en hexa  -> %x ou %X
*/
#include <stdio.h> //affichage + saisie.

int main(void)
{
    int number = 0; // initialiser pour ne pas avoir n'importe quoi dedans.

    printf("Entrez un nombre entier : ");
    scanf("%d", &number); 
    //%d ou %i (alias)
    //&number, passage par adresse avec &
    //scanf() pour affecter une variable avec saisie.

    printf("Valeur en octal : %o\n", number);
    printf("Valeur en hexa : %x\n", number);

    return 0;
}
