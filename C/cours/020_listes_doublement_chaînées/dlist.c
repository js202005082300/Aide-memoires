#include <stdio.h>
#include <stdlib.h>
#include "dlist.h"

/**
* Retourne une DListe vide
* @return Une nouvelle DListe
*/
DList new_dlist(void)
{
    return NULL;
}

/*-----------------------------------------------------*/

/**
* Teste si une DListe est vide
* @param li La DListe
* @return true si la DListe ne contient pas d'éléments, false sinon
*/
Bool is_empty_dlist(DList li)
{
    if(li == NULL)
        return true;
    
    return false;
}

/*-----------------------------------------------------*/

/**
* Retourne la longueur d'une DListe
* @param li La DListe
* @return Le nombre d'éléments de la DListe
*/
int dlist_length(DList li)
{
    if(is_empty_dlist(li))
        return 0;
    
    return li->length;
}

/*-----------------------------------------------------*/

/**
* Retourne le premier élément de la DListe
* @param li La DListe
* @return Le premier entier
*/
int dlist_first(DList li)
{
	if(is_empty_dlist(li))
		exit(1); // On pourrais retourner un message d'erreur mais on quitte le programme.
	return li->begin->value;
}

/**
* Retourne le dernier élément de la DListe
* @param li La DListe
* @return Le dernier entier
*/
int dlist_last(DList li)
{
	if(is_empty_dlist(li))
		exit(1);
	return li->end->value;
}

/*----------------------------------------------------------------*/

/**
* Affiche une DListe
* @param li La DListe à parcourir
*/
void print_dlist(DList li)
{
	/* #1# Test si la liste est vide.*/
	if(is_empty_dlist(li))
	{
		printf("Rien a afficher, la DListe est vide.\n");
		return; // return sans rien derriere puisque le type de retour est void.
	}
	/* #2# Sauvegarder la liste.*/
	DListNode *temp = li->begin; // l'element temp pointe sur la meme adresse que li->begin.
	/* #3# Afficher les valeurs de la liste.*/
	while(temp != NULL) // Tant qu'on est pas sorti de la liste.
	{
		printf("[%d] ", temp->value);
		temp = temp->next; // deplacement du pointeur.
	}
	printf("\n");
}

/*----------------------------------------------------------------*/

/**
* Insère un élément en fin de DListe
* @param li La DListe
* @param x L'entier à ajouter
* @return La DListe avec son élément ajouté
*/
DList push_back_dlist(DList li, int x)
{
	/* #1# declaration et allocation.*/
	DListNode *element;
	element = malloc(sizeof(*element));
	if(element == NULL)
	{
		fprintf(stderr, "Erreur : probleme allocation dynamique.\n");
		exit(EXIT_FAILURE);
	}
	/* #2# Initialisation de l'element de base sans aucune liaison.*/
	element->value = x;
	element->next = NULL; // rien avant.
	element->back = NULL; // rien apres.
	/* #3# Tester si la liste est vide.*/
	if(is_empty_dlist(li)) // si la liste est vide.
	{
		/* -1- Creer la seconde structure DList puisqu'on a creer un maillon.*/
		li = malloc(sizeof(*li)); // Deferencer le pointeur quand on indique la taille. Sizeof ira chercher la taille qui faut en voyant qu'ici on fait reference a des listes.
		if(li == NULL)
		{
			fprintf(stderr, "Erreur : probleme allocation dynamique.\n");
			exit(EXIT_FAILURE); // Ne surtout pas continuer un programme si une allocation dynamique n'a pas fonctionne.
		}
		/* -2- Initialiser tous les champs.*/
		li->length = 0; // taille par defaut.
		li->begin = element; // element qui vient d'etre cree.
		li->end = element; // 1 seul element dans la liste.
	}
	else // si la liste n'est pas vide.
	{
		/* -2_bis- re-initialiser la DList.*/
		li->end->next = element; // Pointer le nouvel element a la fin de la liste doublement chainee.
		element->back = li->end; // Pointer la tete de liste comme retour du nouvel element.
		li->end = element; // Pointer le paramtre de fin sur le dernier element. 
	}
	/* #4# Incrementer le nombre d'elements.*/
	li->length++; // incrementer le nombre d'element que la liste ai ete vide ou non.
	/* #5# Retourner la DList.*/
	return li;
}

/*-----------------------------------------------------*/

/**
* Insère un élément en début de DListe
* @param li La DListe
* @param x L'entier à ajouter
* @return La DListe avec son élémént ajouté
*/
DList push_front_dlist(DList li, int x)
{
	/* #1# declaration et allocation.*/
	DListNode *element;
	element = malloc(sizeof(*element));
	if(element == NULL)
	{
		fprintf(stderr, "Erreur : probleme allocation dynamique.\n");
		exit(EXIT_FAILURE);
	}
	/* #2# Initialisation de l'element de base sans aucune liaison.*/
	element->value = x;
	element->next = NULL;
	element->back = NULL;
	/* #3# Tester si la liste est vide.*/
	if(is_empty_dlist(li))
	{
		/* -1- Creer la seconde structure DList puisqu'on a creer un maillon.*/
		li = malloc(sizeof(*li));
		if(li == NULL)
		{
			fprintf(stderr, "Erreur : probleme allocation dynamique.\n");
			exit(EXIT_FAILURE);
		}
		/* -2- Initialiser tous les champs.*/
		li->length = 0;
		li->begin = element;
		li->end = element;
	}
	else
	{
		/* -2_bis- re-initialiser la DList.*/
		li->begin->back = element; // push_back_dlist : li->end->next.
		element->next = li->begin; // push_back_dlist : element->back = li->end.
		li->begin = element; // push_back_dlist: li->back.
	}
	/* #4# Incrementer le nombre d'elements.*/
	li->length++;
	/* #5# Retourner la DList.*/
	return li;
}

/*-----------------------------------------------------*/

/**
* Retire un élément en fin de DListe
* @param li La DListe
* @param x L'entier à supprimer
* @return La DListe moins l'élément supprimé
*/
DList pop_back_dlist(DList li)
{
	/* #1# Test si liste vide.*/
	if(is_empty_dlist(li)) // Ne pas chercher a supprimer un element d'une liste vide.
	{
		printf("Rien a supprimer, la DListe est deja vide.\n");
		return new_dlist(); // retourner une liste vide plutot que return li; en terme de comprehension du code.
	}
	/* #2# Test si un element dans la liste.*/
	if(li->begin == li->end) // Test d'egalite entre deux adresses de variables pointees.
	{
		free(li);
		li = NULL;
		return new_dlist();
	}
	/* #3# Si plusieurs elements dans la liste.*/
	/* -1- Sauvegarder la liste dans une variable temporaire.*/
	DListNode *temp = li->end; // On cree une sauvegarde du dernier element que l'on veux retirer.
	/* -2- Deplacement des pointeurs.*/
	li->end = li->end->back; // reinitialiser le pointeur sauvegarde.
	/* -3- Casser le lien avec le dernier element de la liste.*/
	li->end->next = NULL;
	/* -4- Casser les liens Next/back du dernier element.*/
	temp->next = NULL;
	temp->back = NULL;
	/* -5- Supprimer le dernier element.*/
	free(temp);
	temp = NULL;
	/* -6- Decrementer le nb d'elements.*/
	li->length--;
	/* -7- Retourner Li qui n'as plus ce dernier element.*/
	return li;
}

/*-----------------------------------------------------*/

/**
* Retire un élément en début de DListe
* @param li La DListe
* @param x L'entier à supprimer
* @return La DListe moins l'élément supprimé
*/
DList pop_front_dlist(DList li)
{
	/* #1# Test si liste vide.*/
	if(is_empty_dlist(li))
	{
		printf("Rien a supprimer, la DListe est deja vide.\n");
		return new_dlist();
	}
	/* #2# Test si un element dans la liste.*/
	if(li->begin == li->end)
	{
		free(li);
		li = NULL;

		return new_dlist();
	}
	/* #3# Si plusieurs elements dans la liste.*/
	/* -1- Sauvegarder la liste dans une variable temporaire.*/
	DListNode *temp = li->begin; // pop_back_dlist: li->end.
	/* -2- Deplacement des pointeurs.*/
	li->begin = li->begin->next; // pop_back_dlist: li->end = li->end->back;
	/* -3- Casser le lien avec le premier element de la liste.*/
	li->begin->back = NULL; // pop_back_dlist: li->end->next.
	/* -4- Casser les liens Next/back du dernier element.*/
	temp->next = NULL;
	temp->back = NULL; // deux liens casses, on se retrouvent avec un simple entier.
	/* -5- Supprimer le dernier element.*/
	free(temp);
	temp = NULL;
	/* -6- Decrementer le nb d'elements.*/
	li->length--;
	/* -7- Retourner Li qui n'as plus ce dernier element.*/
	return li;
}

/*-----------------------------------------------------*/

/**
* Nettoie complètement une DListe de ses éléments
* @param li La DListe à effacer
* @return Une nouvelle DListe (vide)
*/
DList clear_dlist(DList li)
{
	/* #1# Retirer les elements par la fin.*/
	while(!is_empty_dlist(li)) // Tant que la liste n'est pas vide.
		li = pop_back_dlist(li); // OU pop_front_dlist(li).
	/* #2# Retourner une liste vide qui correspond a la valeur de retour.*/
	return new_dlist();
}