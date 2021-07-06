#include <stdio.h>
#include <stdlib.h> // Pour les allocations dynamiques.
#include "queue.h"

/**
* Vérifie qu'une File est vide
* @return true si elle ne contient pas d'élements, false sinon
*/
Bool is_empty_queue(void)
{
	if(first == NULL && last == NULL)
		return true;
	return false;
}

/*------------------------------------------------------------------------*/

/**
* Retourne la longueur d'une File
* @return Le nombre d'élements de la File
*/
int queue_length(void)
{
	return nb_elements; // retourne une valeur statique.
}

/*------------------------------------------------------------------------*/

/**
* Retourne la tête de la File
* @return La valeur en début de File
*/
int queue_first(void)
{
	if(is_empty_queue())
		exit(1);
	return first->value; // retourne une valeur statique.
}

/*------------------------------------------------------------------------*/

/**
* Retourne la queue de la File
* @return La valeur en fin de File
*/
int queue_last(void)
{
	if(is_empty_queue())
		exit(1);
	return last->value; // retourne une valeur statique.
}

/*------------------------------------------------------------------------*/

/**
* Affiche une File
*/
void print_queue(void)
{
	/* -1- void en valeur de retour si la liste est vide (return sans valeur).*/
	if(is_empty_queue())
	{
		printf("Rien a afficher, la File est vide.\n");
		return;
	}
	/* -2- Variable temporaire pour eviter de modifier first. 
	temp et first sont des pointeurs vers le premier element.*/
	QueueElement *temp = first;
	/* -3- Tant que notre variable n'est pas NULL (invariant).*/
	while(temp != NULL)
	{
		printf("[%d | %d] ", temp->value, &temp->value);
		temp = temp->next; // se deplacer d'element en element.
	}
	printf("\n");
}

/*------------------------------------------------------------------------*/

/**
* Insère un entier dans une File (On dira injonction en queu. On parle de Push et Pop plutôt dans le cadre de la pile)
* @param x L'entier à ajouter
*/
void push_queue(int x) 
{
	/* -1- Déclaration et allocation dynamique.*/
	QueueElement *element; // Choix de faire le malloc à la ligne.
	element = malloc(sizeof(*element));
	if(element == NULL) // Verifier si l'allocation a bien fonctionner.
	{
		fprintf(stderr, "Erreur : probleme allocation dynamique.\n");
		exit(EXIT_FAILURE); // Preciser qu'on quitte a cause d'une erreur.
	}
	/* -2- Initialisation.*/
	element->value = x;
	element->next = NULL; // stocker une valeur a la fin, sur l'element Null.
	/* -3- Ajouter.*/ 
	if(is_empty_queue()) // Si la file est vide, mon nouvel element est a la fois le premier et le dernier.
	{
		first = element; // dire à mes pointeurs statiques ou se trouve le nouvel element.
		last = element;
	}
	/* -4- Mise à jour du dernier element.*/
	else // Si il y a déjà des éléments.
	{
		/* -a- Next du dernier element pointe maintenant sur la nouvelle structure.*/
		last->next = element;
		/* -b- Le dernier element pointe sur le nouvel element.*/
		last = element;
	}
	/* -5- incrémenter.*/
	nb_elements++;
}

/*------------------------------------------------------------------------*/

/**
* Retire un élément de la File
*/
void pop_queue(void)
{
	
	/* -1- void en valeur de retour si la liste est vide (return sans valeur).*/
	if(is_empty_queue()) // Eviter de décrémenter le nb_elements si il y a 0 élément.
	{
		printf("Rien a retirer, la File est deja vide.\n");
		return;
	}
	/* -2- Déclaration et initialisation.*/
	QueueElement *temp = first; // créer une variable temporaire qui pointe vers le meme element que first.
	/* -3- Retirer.*/
			/* -a- Libérer les pointeurs de l'unique element.*/
	if(first == last) // Test si on a un seul élément.
	{
		first = NULL;
		last = NULL;
	}
			/* -b- Si on a plus d'un element, pointer le premier element sur le second élément.*/
	else
		first = first->next;
			/* -c- Libérer temp et donc l'emplacement mémoire du premier élément.*/
	free(temp);
	/* -4- décrémenter.*/
	nb_elements--;
}

/*------------------------------------------------------------------------*/

/**
* Nettoie la File de tous ses éléments
*/
void clear_queue(void)
{
	if(is_empty_queue())
	{
		printf("Rien a nettoyer, la File est deja vide.\n");
		return;
	}

	while(!is_empty_queue())
		pop_queue(); // fonction dans une fonction (cas ou s'est répétitif).
}