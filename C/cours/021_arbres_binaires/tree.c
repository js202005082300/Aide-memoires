#include "tree.h"

/**
* Créée un nouvel Arbre
* @param x La valeur de la racine
* @return Le nouvel arbre créé
*/
Tree *new_tree(int x)
{
    /* #1# Allouer un espace mémoire pour un nouvel arbre */ 
    Tree *tr = malloc(sizeof(*tr)); //Sans free, il y a une fuite de mémoire à la fin du programme
    if(tr == NULL)
    {
        fprintf(stderr, "Erreur allocation mémoire.\n");
        exit(EXIT_FAILURE); //Si l'alloc n'as pas été, on quitte le programme
    }
    /* #2# Initialisation */
    tr->value = x;//Le reste est Null car on a que la racine X
    tr->tleft = NULL;
    tr->tright = NULL;
    tr->parent = NULL;//Pas de parent car c'est la racine (arbre de haut en bas, vue informatique)

    //Aide pour le développeur
    printf("Creation de %d\n", tr->value);

    /* #3# Retourner le pointeur sur la racine de l'arbre.*/
    return tr;
}

/*-----------------------------------------------------------------------*/

/**
* Nettoie un arbre
* @param tr L'arbre à vider de ses valeurs
*/
void clean_tree(Tree *tr)
{
    /* #1# Ne pas supprimer un pointeur vide */
    if(tr == NULL)
        return;//Ne pas quitter le programme et parcourir recursivement la libération des noeuds
    
    //Aide pour le développeur
    printf("Suppression de %d\n", tr->value);

    /* #2# Appel recursif pour dépiler l'arbre (left/right stack).*/
    clean_tree(tr->tleft);//Suppression gauche de bas en haut. Libérer chaque noeud un par un
    clean_tree(tr->tright);//Suppression droite de bas en haut

    /* #3# Libérer l'arbre.*/
    free(tr);
}

/*-----------------------------------------------------------------------*/

/**
* Joint deux arbres pour n'en former qu'un
* @param left L'arbre de gauche
* @param right L'arbre de droite
* @param node Le noeud qui lie les deux arbres
* @return Le nouvel arbre formé
*/
Tree *join_tree(Tree *left, Tree *right, int node)
{
    /* #1# Allouer dynamiquement la mémoire */
    Tree *tr = new_tree(node);//Node est la valeur

    /* #2# Brancher les paramètres de fonctions à tr */
    tr->tleft = left;
    tr->tright = right;

    /* #3# Brancher le fils gauche au parent */
    if(left != NULL)//Tester si left existe
        left->parent = tr;

    /* #4# Brancher le fils droit au parent */
    if(right != NULL)//Tester si right existe
        right->parent = tr;
    
    /* #5# Retourner un nouvel arbre */
    return tr;
}

/*-----------------------------------------------------------------------*/

/*
	L'ordre Préfixe : Lire le node racine, ensuite partie gauche et enfin partie droite.
	L'ordre Postfixe : Lire le node racine, ensuite partie droite et enfin partie gauche.
*/

/**
* Affiche un arbre récursivement (parcours préfixé)
* @param tr L'arbre à parcourir
*/
void print_tree_prefix(Tree *tr)
{
    /* #1# Ne pas afficher un pointeur vide */
    if(tr == NULL)
        return;
    
    /* #2# Afficher.*/
    if(tr->parent != NULL)//Si ce n'est pas la racine
        printf("(%d) -> (%d)\n", tr->parent->value, tr->value);//Afficher la racine et ensuite le fils
    else
        printf("(%d)\n", tr->value);

    /* #3# Affichage et recursivité */
    if(tr->tleft != NULL)
        print_tree_prefix(tr->tleft);
    if(tr->tright != NULL)
        print_tree_prefix(tr->tright);

	/* Note: Inverser les deux if pour un postfix
    if(tr->tleft != NULL)
    	print_tree_prefix(tr->tleft);
    if(tr->tright != NULL)
    	print_tree_prefix(tr->tright);
	*/
}

/*-----------------------------------------------------------------------*/

/**
* Ici on considère la racines et les feuilles comme des noeuds.
* C'est un parcours en préfix (gauche -> droite).
*
* Compte le nombre de noeuds d'un arbre
* @param tr L'arbre dont il faut compter les noeuds
* @return Le nombre de noeuds de l'arbre binaire
*/
int count_tree_nodes(Tree *tr)
{
    /* #1# Vérifier si l'arbre n'est pas vide.*/
    if(tr == NULL)
        return 0;
    
    /* #2# Appel recursif pour compter les sous-noeud/sous-ensemble.*/
    return (count_tree_nodes(tr->tleft) + count_tree_nodes(tr->tright) + 1);

    /* Note: Sans compter la racine (+1)
    return (count_tree_nodes(tr->tleft) + count_tree_nodes(tr->tright));
    */
}