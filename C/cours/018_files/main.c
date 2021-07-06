/*
 * 		YouTube: https://youtu.be/OV8f1hRsNP4
 * 		Description: Langage C #18 - files
 * 		Created: 29-02-20 | Revision: --
 * 		Compilater: GNU Compiler - GCC.
 *      Compilation: gcc main.c queue.c -o prog
 *      Author:  Samuel Jacquet
 */


/*
	Structures de donnees : stack (pile), queue (file).
La File:
	FIFO: c'est comme une file d'attente, la première valeur ajoutée sera la première traitée/retirée.
	La tête de la file et la queue de la file.
	Structure de donnees avec un pointeur vers l'element suivant.
	Le dernier element pointera sur NULL.
	Fonctions: push_queue() : enfiler, ajouter (enqueue) ; pop_queue() : defiler, retirer (dequeue).
	Application: gestionnaire de traitement de tâches. 
		Exemple : application avec une imprimante branchée en réseau dans une entreprise. 
		Si 3 personnes lancent une impression, il faudra bien gérer une "file d'attente" 
		entre les différentes impressions, aussi pour éviter de mélanger tous les documents 
		(ex : imprimer la page 1 de la personne A, puis la page 1 de la personne B, etc.)

La Pile:
	structure LIFO: la dernière valeur qui aura été ajoutée sera la première à pouvoir être retirée. 
	C'est un système utile dans la récursivité par exemple.

La Liste:
	Flexible que les deux autres (ajout/suppression en début, en fin, ou à un endroit précis). 
	Application: stocker une Liste d'informations, un inventaire dans un jeu vidéo, une Liste d'élèves pour une école, etc.
	
*/

#include <stdio.h>
#include "queue.h"

int main(void)
{
	/* #1# Vérifie qu'une File est vide.*/
	printf("La File est vide : %d.\n",is_empty_queue());
	/* #2# Retourne la longueur d'une File.*/
	printf("La taille de la File : %d.\n", queue_length());
	/* #3# Affiche une File.*/
	printf("Afficher une file : ");
	print_queue();
	/* #4# Insère un entier dans une File.*/
	printf("Ajouter en fin de file : ");
	push_queue(14);
	push_queue(-26);
	push_queue(173);
	print_queue();
	/* #5# Retire un élément de la File.*/
	printf("Retirer en debut de file : ");
	pop_queue();
	print_queue();
	/* #6# Retourne la tête de la File.*/
	printf("La tete de la File : [%d]\n",queue_first());
	/* #7# Retourne la queue de la File.*/
	printf("La queue de la File : [%d]\n",queue_last());
	/* #9# Nettoie la File de tous ses éléments.*/
	clear_queue();
	print_queue();

	return 0;
}
