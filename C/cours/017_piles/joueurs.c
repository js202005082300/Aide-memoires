/**
 *      YouTube: https://www.youtube.com/watch?v=zERZNLuxtyU (45 min)
 *      Description:  Langage C #17 - piles
 *      Created:  27-02-20 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Compilation: gcc joueurs.c stack-joueurs.c -o prog
 *      Author:  Samuel Jacquet
 */

#include <stdio.h>
#include <stdlib.h> // pour l'allocation en mémoire.
#include "stack-joueurs.h"

int main(void)
{

    /*#1# Créer une pile (vide).*/
    Stack sta = new_stack();
    /*#2# Tester si la pile est vide.*/
    if(is_empty_stack(sta))
        printf("La Pile est vide.\n");
    else
        printf("La Pile a des elements.\n");
    /*#3# Ajouter des éléments.*/
    sta = push_stack(sta, 14); // sta est le retour de la fonction push_stack.
    sta = push_stack(sta, 47); // 14 et 47 valeurs qui suivent mon élément NULL.
    sta = push_stack(sta, 23);
    sta = push_stack(sta, 31);
    /*#4# Néttoyer la pile avant l'arrêt du code.*/ 
    sta = clear_stack(sta); // fonction très importante pour éviter les fuites mémoire. 
    /*#5# Afficher des éléments.*/
    print_stack(sta); // Retourne les éléments d'une pile. Afficher quand la pile a été créé, quand on a ajouté des éléments et quand on vidé la pile.
    /*#6# Retirer le dernier élément qui a été ajouté.*/
    sta = pop_stack(sta); // le dernier element ajouté à la structure, au sommet de la pile est libéré.
    /*#7# Afficher le sommet de la pile.*/
    printf("Sommet actuel : %d\n", top_stack(sta));
    /*#8# Afficher la taille de la pile.*/
    printf("Taille de la pile : %d\n", stack_length(sta));
    
    return 0;
}