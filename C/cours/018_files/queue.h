#ifndef __QUEUE__H__ // Eviter les inclusions qui tournent en boucle.
#define __QUEUE__H__

	/* Définition du type Booléen */
	typedef enum
	{
		false,
		true
	}Bool;

	/* Définition d'une File */
	typedef struct QueueElement
	{
		int value;
		struct QueueElement *next; // Pointeur vers l'element suivant.
	}QueueElement, *Queue;

	/* Paramètres de la File */
	/* 	Variables static qui vont fonctionner dans tout le programme (elles peuvent etre remplacee par une structure 'parametres_file' mais alourdis le code).
		Le mot cle static rend le code disponible un peu partout.
		Les pointeurs en memoire sur les elements de debut et de fin rendent l'acces rapide.	
	*/
	// Parametres d'une file vide.
	static QueueElement *first = NULL; //Garder l'element en tete de file en memoire (acces rapide).
	static QueueElement *last = NULL; //Garder l'element en queue de file en memoire (acces rapide).
	static int nb_elements = 0; //Variable mise a jour et retournee avec une fonction queue_length().
	
	// NB pile: on pourrait avoir une variable de paramètre en tant que sommet dans une pile.

	/* Prototypes */
	// Les parametres sont statiques, pas de parametres aux fonctions.
	Bool is_empty_queue(void); // Verifier si une file est vide (first et last).
	int queue_length(void);
	int queue_first(void);
	int queue_last(void);
	void print_queue(void);
	void push_queue(int x);
	void pop_queue(void);
	void clear_queue(void);

#endif
