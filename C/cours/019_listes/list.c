/* 
 * Fichier list.c : implémentations de fonctions.
 */

#include <stdio.h>
#include <stdlib.h>
#include "list.h"

/**
* Retourne une nouvelle Liste
* @return Une liste vide
*/
List new_list(void)
{
	return NULL;
}

/*---------------------------------------------------------------------*/

/**
* Vérifie si une List est vide
* @param li La liste à tester
* @return true si elle est vide, faux sinon
*/
Bool is_empty_list(List li)
{
	if(li == NULL)
		return true;
	return false;
}

/*---------------------------------------------------------------------*/

/**
* Affiche une Liste
* @param li La liste à afficher
*/
void print_list(List li)
{
	if(is_empty_list(li))
	{
		printf("Rien a afficher, la Liste est vide.\n");
		return; // retourne rien puisque c'est void.
	}
	while(li != NULL) // Tant que nous sommes pas en dehors de la liste.
	{
		printf("[%d] ", li->value); // affichage de l'élément en cours.
		li = li->next; // déplacer le pointeur sur l'élément suivant sinon boucle infini.
	}
	printf("\n");
}

/*---------------------------------------------------------------------*/

/**
* Retourne la taille de la Liste
* @param li La liste
* @return Le nombre d'élements de la Liste
*/
int list_length(List li)
{
	int size = 0;
	if(is_empty_list(li))
		return size;
	while(li != NULL)
	{
		size++;
		li = li->next;
	}
	return size;
}

int list_length_bis(List li)
{
	int size = 0;
	if(!is_empty_list(li))
		while(li != NULL)
		{
			size++;
			li = li->next;
		}
	return size;
}

/*---------------------------------------------------------------------*/

/**
* Ajoute un entier en fin de Liste
* @param li La liste
* @param x L'entier à insérer
* @return La liste avec le nouvel élement ajouté
*/
List push_back_list(List li, int x)
{
	/* #1# Créer un nouvel élément.*/
	ListElement *element;
	/* #2# Allouer le nécessaire pour le nouvel élément.*/
	element = malloc(sizeof(*element)); // Mettre le nom du pointeur avec son étoile pour avoir la bonne taille.
	if(element == NULL)
	{
		fprintf(stderr, "Erreur : probleme allocation dynamique.\n");
		exit(EXIT_FAILURE); // ou exit(1) au lieu de la constante.
	}
	/* #3# Initialiser.*/
	element->value = x;
	element->next = NULL; // Null car ajout en fin de liste.
	/* #4# Ajouter.*/
			/* -a- Si c'est le premier élément, on retourne l'élément seul.*/
	if(is_empty_list(li))
		return element;
			/* -b- Si la liste n'est pas vide, on crée un nouveau pointeur sur la liste.*/
	ListElement *temp;
	temp = li; // Pour éviter de modifier le pointeur de la liste, l'adresse de li et temp sont pareil, il pointe sur la même adresse.
	/* #5# Se déplacer tout à la fin de la liste.*/
	while(temp->next != NULL) // Tant qu'on est pas à la fin de la liste.
		temp = temp->next; // se déplacer.
	/* #6# Ajouter element.*/
	temp->next = element;
	/* #7# Retourner un pointeur.*/
	return li; // retourner la liste non modifié.
}

/*---------------------------------------------------------------------*/

/**
* Ajoute un entier en début de Liste
* @param li La liste
* @param x L'entier à insérer
* @return La liste avec le nouvel élement ajouté
*/
List push_front_list(List li, int x)
{
	/* #1# Créer un nouvel élément.*/
	ListElement *element;
	/* #2# Vérifier l'allocation.*/
	element = malloc(sizeof(*element));
	if(element == NULL)
	{
		fprintf(stderr, "Erreur : probleme allocation dynamique.\n");
		exit(EXIT_FAILURE);
	}
	/* #3# Initialiser.*/
	element->value = x;
	/* #4# Ajouter.*/
	if(is_empty_list(li))
		element->next = NULL; // Un seul element dans la liste pointe vers null.
	else
		element->next = li; // Un nouvel element pointe vers toute la liste d'avant.
	/* #5# Retourner la liste qui contient toute la liste.*/
	return element;
}

/*---------------------------------------------------------------------*/

/**
* Supprime un entier de la fin de la Liste
* @param li La liste
* @return La liste sans l'élément retiré
*/
List pop_back_list(List li)
{
	/* #1# Test si liste vide.*/
	if(is_empty_list(li)) // Ne pas retirer un element d'une liste qui est vide.
		return new_list(); // OU return li, == à Null dans implantation.
	/* #2# Test si un element dans la liste.*/
	if(li->next == NULL)// Si la liste n'a qu'un seul élément.
	{
		free(li); // Un seul élément = libérer la liste.
		li = NULL; // Affecter la valeur Null en plus de la libération de mémoire (éviter que le compilateur mette n'importe quoi dedans).
		return new_list(); // OU return li, == à Null dans implantation.
	}
	/* #3# Si plusieurs elements dans la liste.*/
	/* -1- Sauvegarder la liste dans 2 variables temporaire, réference à Li.*/
	ListElement *temp = li; // 1er variable temporaire. Reference à Li.
	ListElement *before = li; // 2eme variable temporaire. Reference à Li.
	/* -2- Déplacement des pointeurs.*/
	while(temp->next != NULL) // Tant qu'on arrive pas à la fin.
	{
		before = temp; // Pour ne pas perdre la valeur juste avant, on sauvegarde dans before.
		temp = temp->next; // Temp contient maintenant l'élément qui suit.
	}
	/* -3- Casser le lien avec le dernier element de la liste.*/
	before->next = NULL; /* Before est l'avant dernier element de la liste.*/
	/* -4- Supprimer le dernier élément.*/
	free(temp);
	temp = NULL;
	/* -5- Retourner Li qui n'as plus ce dernier element.*/
	return li;
}

/*---------------------------------------------------------------------*/

/**
* Supprime un entier de la tête de la Liste
* @param li La liste
* @return La liste sans l'élément retiré
*/
List pop_front_list(List li)
{
	/* #1# Créer un nouvel élément.*/
	ListElement *element; // Pointeur de récupération.
	/* #2# Vérifier l'allocation.*/
	element = malloc(sizeof(*element));
	if(element == NULL)
	{
		fprintf(stderr, "Erreur : probleme allocation dynamique.\n");
		exit(EXIT_FAILURE);
	}
	/* #3# Test si liste vide.*/
	if(is_empty_list(li))
		return new_list();
	/* #4# Sauvegarder toute la liste sauf le premier element (li->next).*/
	element = li->next; // Affecter toute la liste dans mon pointeur de récupération.
	/* #5# Libérer la liste (sauvé dans Temp) et son premier element.*/
	free(li);
	li = NULL;
	/* #5# Retourner le pointeur de récupération.*/
	return element;
}

/*---------------------------------------------------------------------*/

/**
* Supprime tous les éléments d'une Liste
* @param li La liste
* @return Une Liste vide
*/
List clear_list(List li)
{
	/* #1# Test si liste vide.*/
	if(is_empty_list(li))
		return new_list();
	/* #2# Suppresion.*/
	while(li != NULL) // Tant qu'on est pas à la fin.*/
		li = pop_front_list(li); // pop_front est plus performante que pop_back car elle ne pascours pas la liste avec une boucle (1000 elements à parcourir..).

	return li;
}