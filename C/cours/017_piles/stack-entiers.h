#ifndef __STACK__H__ /* Eviter de faire des inclusions inutiles.*/
#define __STACK__H__

	/* Type booléen */
	typedef enum
	{
		false, //0
		true //1
	}Bool;

	/*------------------------------------------*/

	/* Définition d'une Pile */
	typedef struct StackElement
	{
		int value; // cellule au sommet de la pile qui contient un entier.
		struct StackElement *next; // pointeur vers la cellule suivante jusqu'à la valeur insèrée pointe sur NULL.
	}StackElement, *Stack; // Deux notations possibles, pointeur cachée ou non.

	/*------------------------------------------*/

	/* Prototypes des fonctions */
	Stack new_stack(void); // retourner une nouvelle pile NULL qui ne prend rien.
	Bool is_empty_stack(Stack st);
	void print_stack(Stack st); // fonction d'affichage d'une pile.
	Stack push_stack(Stack st, int x); // push, insert pour ajouter un élément.
	Stack pop_stack(Stack st); // pop, retirer le dernier élément ajouté.
	int top_stack(Stack st); // afficher le sommet de la pile.
	int stack_length(Stack st); // retourner la longueur de la pile.
	Stack clear_stack(Stack st); // Retourner une pile vide.

	// Développer une bibliothèque de fonctions : c'est créer un prototype suivi de son implémentation en testant au fur et à mesure.

#endif