#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "stack-entiers.h"

/**
* Une pile vide, c'est une pile NULL (choix d'implémentaion). 
* On pourrais dire qu'elle vaut 0 mais on veux montrer que la fin de la pile arrivera à NULL.
* 
* Retourne une Pile vide
* @return Une Pile vide
*/
Stack new_stack(void)
{
	return NULL; 
}

/*-----------------------------------------------------------------*/

/**
* Vérifie si une Pile est vide
* @param st La pile à tester
* @return true si la Pile est vide, faux sinon
*/
Bool is_empty_stack(Stack st)
{
	if(st == NULL)
		return true;
	return false; // optimisation sans ELSE.
}

/*-----------------------------------------------------------------*/

/**
* Empile un entier dans la Pile
* @param st La Pile
* @param x L'entier à ajouter
* @return La nouvelle Pile
*/
Stack push_stack(Stack st, int x) // st vaut NULL par défaut OU contient déjà des éléments.
{
	StackElement *element; // créer un nouvel élément.
	element = malloc(sizeof(*element)); // allouer la taille de l'élément (char, int, ect.)
	if(element == NULL) // test de l'allocation.
	{
		fprintf(stderr, "Probleme allocation dynamique.\n"); // fprintf n'écrit pas dans un fichier mais sur la sortie standard.
		exit(EXIT_FAILURE); // Quitter le programme pour dire que ca echoue.
	}
	element->value = x; // Si l'allocation OK, on ajoute une valeur (passée en paramètre) à un élément de la pile qui est un pointeur.
	element->next = st; // L'élément de structure 'Next' est égale à l'adresse de ma pile.
	return element; // Retourne toute la pile avec le dernier élement (au sommet) rataché à la pile.
}

/*-----------------------------------------------------------------*/

/**
* Dépile un entier de la Pile (en respectant la structure en FILO).
* @param st La Pile (le dernier élément ajouté de ma pile)
* @param La pile sans le premier élément
*/
Stack pop_stack(Stack st)
{
	StackElement *element; // en début de fonction, on prend l'habitude déclarer un nouvel élément même si avec le test qui suit, on risque d'avoir créer un pointeur pour rien. Un pointeur ne prend pas beaucoup de place en mémoire.

	if(is_empty_stack(st)) // Si la pile est vide. 
		return new_stack(); // On retourne une nouvelle pile OU un void.

	element = st->next; // La nouvelle pile est toute notre pile sauf le dernier élément libéré.
	free(st);

	return element;
}

/*-----------------------------------------------------------------*/

/**
* Affiche une Pile (tant qu'on a pas NULL)
* @param st La Pile
*/
void print_stack(Stack st) 
{
	if(is_empty_stack(st)) // si la pile est vide.
	{
		printf("Rien a afficher, la Pile est vide.\n"); // Message d'avertissement.
		return; // quitter la fonction de type void.
	}
	while(!is_empty_stack(st)) // tant que la pile n'est pas vide.
	{
		printf("[%d]\n", st->value); // afficher la valeur de la pile.
		st = st->next; // égale les 4, 3, 2, 1 éléments de la boucle (sommet vers le bas).
	}
}

/*-----------------------------------------------------------------*/

/**
* Retourne l'entier au sommet de la Pile
* @param st La Pile
* @return Le nombre entier au sommet de la Pile
*/
int top_stack(Stack st)
{
	if(is_empty_stack(st)) // si la pile est vide.
	{
		printf("Aucun sommet, la Pile est vide.\n");
		exit(EXIT_FAILURE); // Sortir d'une fonction de type int. Equivaut à écrire exit(1).
		//return -1; // Dans ce cas on considère que la pile ne retourne que des entiers positif et -1 si la pile est vide. Il faut aussi que la structure contiennent des "unsigned int value;" dans ce cas. Dans ce cas, il faut également afficher un message pour dire qu'il n'y a pas de sommer si "return -1;".
	}
	return st->value; // Retourne le sommet de la pile. La pile pointe l'élément qui est le plus en haut par défaut.
}

/*-----------------------------------------------------------------*/

/**
* Retourne la hauteur (longueur) de la Pile
* @param st La Pile
* @return La taille de la Pile
*/
int stack_length(Stack st)
{
	int length = 0; // créer une variable de comptage (0 par défaut).
	while(!is_empty_stack(st)) // tant que la pile n'est pas vide.
	{
		length++; // incrémenter length de 1.
		st = st->next; // passer à la suite jusqu'à temps que la pile soit vide.
	}
	return length; // retourne 0 si la pile est vide.
}

/*-----------------------------------------------------------------*/

/**
* Utilisation de la récursivité :
* fonction qui s'appelle elle-même jusqu'à un certain point d'arrêt (pile vide).
* 
* Vide la Pile de ses éléments
* @param st La Pile à nettoyer
* @return Une Pile vide
*/
Stack clear_stack_bis(Stack st)
{
	StackElement *element; // création d'une structure.
	if(is_empty_stack(st)) // Vérifier si la pile n'est pas vide.
		return new_stack(); // On retourne une nouvelle pile.
	element = st->next; // sauvegarde de notre pile mais le dernier élément est libéré.
	free(st); // Autant de free que de malloc, très important.
	return clear_stack(element); // Recursivité : On execute à nouveau la même fonction.

	// Garder un seul élément : 
	// element = st->next;
	// free(st);
}

/**
* Optimisation de la fonction clear_stack_bis() avec la fonction pop_stack().
* 
* Vide la Pile de ses éléments
* @param st La Pile à nettoyer
* @return Une Pile vide
*/
Stack clear_stack(Stack st)
{
	while(!is_empty_stack(st)) // Tant que ma pile n'est pas vide.
		st = pop_stack(st); // Libérer la mémoire en supprimant tous les éléments 1 par 1 jusqu'à ce que la pile soit vide.
	return new_stack(); // Retourner en plus une nouvelle pile.
}