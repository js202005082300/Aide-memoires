#ifndef __GRAPH__H__
#define __GRAPH__H__

    /* Définition d'un Bolléen */
    typedef enum
    {
        false,
        true
    }Bool;

    /* Définition d'un Noeud (sommet) */
    typedef struct NodeListElement//définition d'une liste de Noeuds (sommet)
    {
        int value;//élement, sommet qui contiendra une valeur.
        struct NodeListElement *next;//pointeur vers l'element suivant.
    }NodeListElement, *NodeList;

    /*Définition d'une liste d'adjacence*/
        //définition d'une liste d'ajdacence (tableau)
        // --> tableau pour lequel, on va allouer dynamiquent.
    typedef struct AdjencyListElement
    {
        NodeListElement *begin;
    }AdjencyListElement, *AdjencyList;

    /* Définition d'un graphe */
    typedef struct GraphElement
    {
        Bool is_oriented;//graph=non-orienté soit AB même chose que BA (--) et digraph=orienté soit A vers B (->).
        int nb_vertices;//nombre de sommets (lieux où on peut aller).
        AdjencyList tab_neighbours;//tableaux des voisins (liste d'adjacences).
        /*--------- Graphviz ----------*/
        FILE *graph_file;//utilisation d'un fichier tout au long du programme.
        /*-----------------------------*/
    }GraphElement, *Graph;

    //Graph g == GraphElement *G (masquer le pointeur).

/* Prototypes */
Graph new_graph(int vertices, Bool is_oriented);
Bool is_empty_graph(Graph G);
NodeList add_node(int x);
void add_edge(Graph g, int src, int dest);//idem si on inverse src et dest.
void print_graph(Graph g);
void display_graph(Graph g);
void erase_graph(Graph g);

#endif

/*
 * En premier on a un graphe avec une liste d'adjacences.
 * Chaque liste d'adjacence est une liste chainée d'éléments.
 * On a une liste chainée dans une liste plus ou moins chainées sauf qu'on utilise des tableaux.
 * Tableaux pour lequel on va alouer dynamiquement:
 *		-> Un malloc pour le Graphe -> new_graph().
 *		-> Un malloc pour les listes d'adjacences -> new_graph().
 *		-> Autant de malloc nécessaire pour chacun des nodes -> add_node() -> éxécuter autant de fois qu'il y a add_edge().
 * Dés qu'il y a un malloc, il y a un free -> erase_graph().
 */