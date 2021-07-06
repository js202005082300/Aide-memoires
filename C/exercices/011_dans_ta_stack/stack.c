#include "data.h" // ajout.
#include "stack.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>  // ajout.

Stack new_stack(void)
{
	return NULL; 
}

/*-----------------------------------------------------------------*/

bool is_empty_stack(Stack st)  // modif (bool).
{
	if(st == NULL)
		return true;
	return false;
}

/*-----------------------------------------------------------------*/

Stack push_stack(Stack st, Data d)
{
	StackElement *element;
	element = malloc(sizeof(*element));

	if(element == NULL)
	{
		fprintf(stderr, "Probleme allocation dynamique.\n");
		exit(EXIT_FAILURE);
	}
	element->d = d; // modif.
	element->next = st;
	return element;
}

/*-----------------------------------------------------------------*/

Stack pop_stack(Stack st)
{
	StackElement *element;

	if(is_empty_stack(st))
		return new_stack();

	element = st->next;
	free(st);

	return element;
}

/*-----------------------------------------------------------------*/

void print_stack(Stack st) 
{
	if(is_empty_stack(st))
	{
		printf("Rien a afficher, la Pile est vide.\n");
		return;
	}
	while(!is_empty_stack(st))
	{
		printf("[%s] : %d\n", st->d.name, st->d.value); // modif.
		st = st->next;
	}
}

/*-----------------------------------------------------------------*/

Data top_stack(Stack st) // modif (Data).
{
	if(is_empty_stack(st))
	{
		printf("Aucun sommet, la Pile est vide.\n");
		exit(EXIT_FAILURE);
	}
	return st->d; // modif.
}

/*-----------------------------------------------------------------*/

int stack_length(Stack st)
{
	int length = 0;
	while(!is_empty_stack(st))
	{
		length++;
		st = st->next;
	}
	return length;
}

/*-----------------------------------------------------------------*/

Stack clear_stack_bis(Stack st)
{
	StackElement *element;
	if(is_empty_stack(st))
		return new_stack();
	element = st->next;
	free(st);
	return clear_stack(element);
}

/*-----------------------------------------------------------------*/

Stack clear_stack(Stack st)
{
	while(!is_empty_stack(st))
		st = pop_stack(st);
	return new_stack();
}