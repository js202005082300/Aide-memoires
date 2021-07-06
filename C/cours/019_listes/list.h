/* 
 * Fichier list.h : définitions et prototypes de fonctions.
 */

#ifndef __LIST__H__
#define __LIST__H__

	/* Définition d'un Booléen */
	typedef enum
	{
		false,
		true
	}Bool;

	/* Définition d'une Liste */
	typedef struct ListElement
	{
		int value;
		struct ListElement *next; // pointeur vers l'élément suivant.
	}ListElement, *List;

	/* Pas de variables statiques pour faciliter certains traitements.
		Pas d'éléments de paramètres.*/

	/* Prototypes */
	List new_list(void); // création de nouvelles structures.
	Bool is_empty_list(List li); 
	void print_list(List li); // afficher la liste.
	int list_length(List li); // compter le nombre d'élément que la liste contient.
	List push_back_list(List li, int x);
	List push_front_list(List li, int x);
	List pop_back_list(List li);
	List pop_front_list(List li);
	List clear_list(List li);

#endif