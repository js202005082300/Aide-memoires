/*
 * 		YouTube: https://youtu.be/589GpRJ6VFo
 * 		Description: Langage C #20 - listes doublement chaînées
 * 		Created: 01-03-20 | Revision: --
 * 		Compilater: GNU Compiler - GCC.
 *      Compilation: gcc main.c dlist.c -o prog
 *      Author:  Samuel Jacquet
 */


#include <stdio.h>
#include <stdlib.h>
#include "dlist.h"

/*
	Liste: structure flexible sans conditions particuliere au niveau de l'ajout et la suppression.
	Liste doublement chainee: structure qui permet de circuler dans les 2 sens. Les noeuds, les maillons ont un pointeur Next mais aussi un pointeur Back. Ici on gere une seconde structure pour les parametres de la liste (parametre de longueur, pointeur sur le premier et pointeur sur le dernier element pour le parcours dans les deux sens).
	
		Les vrais termes sont INSERT(PUSH) et DELETE(POP).
*/

int main(void)
{
	/* #1# Retourne une DListe vide.*/
	DList mylist = new_dlist();
	/* #2# Teste si une DListe est vide.*/
	if(is_empty_dlist(mylist))
		printf("Elle est vide.\n");
	else
		printf("Elle contient des elements.\n");
	/* #3# Retourne la longueur d'une DListe.*/
	printf("Taille de la DListe : %d.\n",dlist_length(mylist));
	/* #5# Affiche une DListe.*/
	print_dlist(mylist);
	/* #6# Insère un élément en fin de DListe.*/
	mylist = push_back_dlist(mylist, 14);
	mylist = push_back_dlist(mylist, 6);
	mylist = push_back_dlist(mylist, 23);
	print_dlist(mylist);
	printf("Taille de la DListe : %d.\n",dlist_length(mylist));
	/* #4# Retourne le premier/dernier élément de la DListe.*/
	printf("Premier element de la liste : %d.\n",dlist_first(mylist));
	printf("Premier element de la liste : %d.\n",dlist_last(mylist));
	/* #7# Insère un élément en début de DListe.*/
	mylist = push_front_dlist(mylist, 45);
	print_dlist(mylist);
	printf("Taille de la DListe : %d.\n",dlist_length(mylist));
	/* #8# Retire un élément en fin de DListe.*/
	mylist = pop_back_dlist(mylist);
	print_dlist(mylist);
	printf("Taille de la DListe : %d.\n",dlist_length(mylist));
	/* #9# Retire un élément en début de DListe.*/
	mylist = pop_front_dlist(mylist);
	print_dlist(mylist);
	printf("Taille de la DListe : %d.\n",dlist_length(mylist));
	/* #10# Nettoie complètement une DListe de ses éléments.*/
	mylist = clear_dlist(mylist);
	printf("%p\n",mylist);
	return 0;
}
