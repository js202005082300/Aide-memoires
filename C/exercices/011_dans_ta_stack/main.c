/*
EXERCICES C #11
[Révision : 17 - piles]

> A partir de la structure de pile (d'entiers) abordée dans le cours, vous allez l'adapter pour pouvoir stocker des variables (leur nom + leur valeur), de type "int" pour faire plus simple.

> L'objectif de l'exercice :

    - Le code de la fonction main() doit compiler et s'exécuter pour afficher l'historique des variables stockées dans la Pile.
    - Vous utiliserez la commande : gcc -Wall -Wextra -Werror *.c -o prog

> Il faudra éditer en conséquence la structure de la Pile (stack.c + stack.h)
> La donné d'une variable (nom + valeur) sera une structure définie dans un autre fichier d'en-tête

[11. Dans ta stack](https://www.youtube.com/watch?v=yBaaLPBsRPM)
*/
#include "data.h" // modif.
#include "stack.h" // modif.
#include <stdio.h>

int main(void)
{
    Stack s = new_stack();

    int number = 144;
    Data d_number = {"number", number};

    s = push_stack(s, d_number);

    number = 26;
    d_number.value = number;
    s = push_stack(s, d_number);

    int rank = -1;
    Data d_rank = {"rank", rank};

    s = push_stack(s, d_rank);

    number = 0;
    d_number.value = number;

    rank = 3;
    d_rank.value = rank;

    s = push_stack(s, d_number);
    s = push_stack(s, d_rank);

    print_stack(s);

    return 0;
}