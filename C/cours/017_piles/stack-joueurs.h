#ifndef __STACK__H__
#define __STACK__H__

	/* Type booléen */
	typedef enum
	{
		false, //0
		true //1
	}Bool;

	/*------------------------------------------*/

	/* Définition d'un Joueur */
	typedef struct Player
	{
		char name[25];
		int level;
	}Player;

	/*------------------------------------------*/

	/* Définition d'une Pile */
	typedef struct StackElement
	{
		Player pp; // Le simple entier devient une structure.
		struct StackElement *next;
	}StackElement, *Stack;

	/*------------------------------------------*/

	/* Prototypes des fonctions */
	Stack new_stack(void);
	Bool is_empty_stack(Stack st);
	void print_stack(Stack st);
	Stack push_stack(Stack st, Player p);
	Stack pop_stack(Stack st);
	Player top_stack(Stack st);
	int stack_length(Stack st);
	Stack clear_stack(Stack st);

#endif