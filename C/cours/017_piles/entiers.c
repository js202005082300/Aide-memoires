/**
 *      YouTube: https://www.youtube.com/watch?v=zERZNLuxtyU
 *      Description:  Langage C #17 - piles
 *      Created:  23-02-20 | Revision: 24-02-20.
 *      Compiler:  GNU Compiler - GCC.
 *      Compilation: gcc entiers.c stack-entiers.c -o prog
 *      Author:  Samuel Jacquet
 */

 /*
    Les structures de données : 
    #1# La pile

    -> utilisée en tant que pile d'appel pendant un appel de fonction en C (notamment en recursivité).
    -> Le compilateur crée un contexte pour la fonction en empilant des variable locales (variables propres à la fonction) dans la pile.
    -> Empilement du bas vers le haut pour les nouvelles fonctions.
    -> Structure FILO (First In, Last Out) : Le dernier element inséré (empiler) sera le premier retirer (dépiler).
    -> Longueur/hauteur pile : nombre d'élements intégrés.
    -> sommet pile : dernière valeur insérée dans la pile.

    En plus avec les piles, 
        - fonctions de tri;
        - fonctions d'inversions;
        - scinder une pile en deux;
        - fusionner deux piles;
        - etc.
 */

#include <stdio.h>
#include <stdlib.h> // pour l'allocation en mémoire.
#include "stack-entiers.h"

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
    print_stack(sta);
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