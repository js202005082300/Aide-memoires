/**
 *      YouTube: https://www.youtube.com/watch?v=FmaNOdbngLc
 *      Description:  Langage C #19 - listes
 *      Created:  29-01-20 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Compilation: gcc main.c list.c -o prog
 *      Author:  Samuel Jacquet
 */

/*
    La Liste : 
        Flexible : Pas d'ordre dans l'insertion et le retrait des données (ajout ou retrait en début ou fin de liste).
            insert_front()
            insert_back()
            delete_front()
            delete_back()
        
    Autres types de fonctions :
        Rechercher un élément en particulier (champ d'indice en plus dans la structure).
        Insertion avec des valeurs triées (valeurs uniques, etc.).
        etc.
*/

#include <stdio.h>
#include <stdlib.h>
#include "list.h"

 int main(void)
 {
    /* #1# Retourner une Liste vide.*/
    List mylist = new_list();
    /* #2# Retourner true si la liste est vide, faux sinon.*/
    if(is_empty_list(mylist))
        printf("Liste vide.\n");
    else
        printf("Liste a des éléments.\n");
    /* #3# Afficher une Liste.*/
    print_list(mylist);




    printf("*-----------*\n");
    mylist = push_back_list(mylist,1);
    mylist = push_back_list(mylist,2);
    mylist = push_back_list(mylist,3);
    mylist = push_back_list(mylist,4);
    mylist = push_back_list(mylist,5);
    mylist = push_back_list(mylist,12);
    mylist = push_back_list(mylist,7);
    mylist = push_back_list(mylist,7);
    mylist = push_back_list(mylist,8);
    mylist = push_back_list(mylist,12);
    mylist = push_back_list(mylist,10);
    mylist = push_back_list(mylist,11);
    mylist = push_back_list(mylist,12);
    print_list(mylist);
    /****/
    mylist = delElement(mylist, 12);
    print_list(mylist);
    printf("*-----------*\n");



    /* #4# Retourner le nombre d'élements de la Liste.*/
    printf("Nombre d'element : %d\n", list_length(mylist));
    /* #5# push_back_list() : Retourner la liste avec le nouvel élement ajouté.*/
    mylist = push_back_list(mylist,36);
    mylist = push_back_list(mylist,87);
    mylist = push_back_list(mylist,-4);
    print_list(mylist);
    /* #6# push_front_list() : Retourner la liste avec le nouvel élement ajouté.*/
    mylist = push_front_list(mylist,67);
    print_list(mylist);
    printf("Nombre d'element : %d\n", list_length(mylist));
    /* #7# pop_back_list() : La liste sans l'élément retiré.*/
    mylist = pop_back_list(mylist);
    print_list(mylist);
    /* #8# pop_front_list() : La liste sans l'élément retiré.*/
    mylist = pop_front_list(mylist);
    print_list(mylist);
    /* #9# Retourner une Liste vide.*/
    mylist = clear_list(mylist); // Eviter les fuites mémoires.
    print_list(mylist);

    return 0;
 }

 