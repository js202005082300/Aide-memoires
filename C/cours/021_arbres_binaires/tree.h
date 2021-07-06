#ifndef __TREE__H__ // éviter plusieurs inclusions, les boucles infinies
#define __TREE__H__

/* Fichiers d'en-tête */
#include <stdio.h>
#include <stdlib.h>

/* Structure d'un Arbre */
typedef struct Tree
{
    int value;
    struct Tree *tleft;
    struct Tree *tright;
    struct Tree *parent;
}Tree; // Afficher les pointeurs au niveau du code.

/* Prototypes des fonctions */
Tree *new_tree(int x); // Ici le pointeur est affiché.
void clean_tree(Tree *tr);
Tree *join_tree(Tree *left, Tree *right, int node);
void print_tree_prefix(Tree *tr);
int count_tree_nodes(Tree *tr);

#endif