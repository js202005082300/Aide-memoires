#include <stdio.h>
#include <stdlib.h>
#include "graph.h"

/**
* Créée un Graphe
* @param vertices Le nombre de sommets
* @param is_oriented Est-ce un graphe orienté ou non-orienté ?
* @return Le graphe créé
*/
Graph new_graph(int vertices, Bool is_oriented)
{
    int i;// compteur
    /* #1# Allocation dynamique d'un nouvel élément.*/
    GraphElement *element;
    element = malloc(sizeof(*element));
    if(element == NULL)
    {
        fprintf(stderr, "Erreur : Probleme creation Graphe.\n");//stderr, sortie d'erreur standard.
        exit(EXIT_FAILURE);//quitter le programme.
    }
    /* #2# Remplissage champs de structure.*/
    element->is_oriented = is_oriented;//true ou false en paramètre pendant l'appel de fonction.
    element->nb_vertices = vertices;//entier pour le nombre de sommet.
    /* #3# Allocation dynamiques de listes adjacentes X nombre sommet.*/
    element->tab_neighbours = malloc(vertices * sizeof(AdjencyListElement));
		// Chacune des listes d'adjacences pointera (*begin) sur un noeud d'une liste chainée.
		// Chaque sommet aura une liste d'autres sommets.
    if(element->tab_neighbours == NULL)
    {
        fprintf(stderr, "Erreur : Probleme creation Graphe.\n");
        exit(EXIT_FAILURE);
    }
    /* #4# Initialisation du pointeur begin.*/
    for(i=1;i<element->nb_vertices+1;i++)//i=1 pour nommer les sommets 1, 2, 3, 4, 5 (on utilise pas de chaine pour eviter de complexifier).
        element->tab_neighbours[i-1].begin = NULL;//i-1 car on commence à i=1 ([i] si i=0).

    /*--------- Graphviz ----------*/
    /* #5# Créer/écraser/ouvrir un nouveau fichier.*/
    if(element->is_oriented)
        element->graph_file = fopen("digraph.out", "w");//création d'un fichier de sortie orientée.
    else
        element->graph_file = fopen("graph.out", "w");
        // Vérifier que le fichier est bien créer.
    if(element->graph_file == NULL)
    {
        fprintf(stderr, "Erreur : Probleme creation du fichier.\n");
        exit(EXIT_FAILURE);
    }
    /* #6# Commencer à remplir le fichier en script.*/
    if(element->is_oriented)
        fprintf(element->graph_file, "digraph my_graph\n{\n");//script d'un graphe orienté.
    else
        fprintf(element->graph_file, "graph my_graph\n{\n");
    /*-----------------------------*/
    /* #7# Retourner l'élément.*/
    return element;
}

/*-------------------------------------------------------------------------------*/

/**
* Teste si un Graphe existe
* @param g Le Graphe à vérifier
* @return true Si le Graphe n'existe pas, false sinon
*/
Bool is_empty_graph(Graph g)
{
    if(g == NULL)
        return true;
    
    return false;
}

/*-------------------------------------------------------------------------------*/

/**
* Retourne un Noeud
* @param x La valeur du Noeud
* @param Le Noeud créé
*/
NodeList add_node(int x)
{
    NodeList n = malloc(sizeof(NodeListElement));
    //NodeListElement *n = malloc(sizeof(*n)); // idem.
    if(n == NULL)
    {
        fprintf(stderr, "Erreur : Probleme creation Node.\n");
        exit(EXIT_FAILURE);
    }

    n->value = x;//ajouter une valeur au noeud.
    n->next = NULL;//Pas d'élément suivant parce qu'on va le réutiliser.

    return n;
}

/*-------------------------------------------------------------------------------*/

/**
* Ajoute une arête à un Graphe
* @param g Le Graphe
* @param src Le premier sommet (ou source)
* @param dest Le second sommet (ou destination)
*/
void add_edge(Graph g, int src, int dest)
{
    /* #0# Amélioration de sécurité : Test pour savoir si le sommet existe (ou si quelqu'un met autre chose que des entiers).
     * codes pour éviter de créer un lien vers des sommets qui n'existeraient pas 
     * Exemple ou le nombre de sommets est inférieur à src ou dest.
     */
    
    /* #1# Ajouter une destination. Par défaut : Graphe orienté (A->B).*/
    NodeList n = add_node(dest);//dest : destination en paramètre.
        // n devient le nouveau premier élément de la liste chainée. src-1 : car numéro des sommets commence à 1.
    n->next = g->tab_neighbours[src-1].begin;//L'ensemble des voisins est mise sur la suite du node (Si Null, la suite du node vaudra Null).
    g->tab_neighbours[src-1].begin = n;//Le node n devient le premier élément, begin. Il devient la tête.
    /* #2# Ajouter une destination si le graphe est non orienté (A->B et B->A).*/
    if(!g->is_oriented)//Si le graphe est non orienté.
    {
        n = add_node(src);//n peut aller de Dest à Src (situation inversé).
        n->next = g->tab_neighbours[dest-1].begin;
        g->tab_neighbours[dest-1].begin = n;  
    }

    /*--------- Graphviz ----------*/
    /* #3# Ajout d'un lien dans le fichier Graphviz.*/
    //Ajout d'un lien dans le fichier Graphviz
    if(g->is_oriented)
        fprintf(g->graph_file, "\t%d -> %d;\n", src, dest);//l'ordre des variable src et dest est importante.
    else
        fprintf(g->graph_file, "\t%d -- %d;\n", src, dest);
    /*-----------------------------*/
}

/*-------------------------------------------------------------------------------*/

/**
* Affiche un Graphe en mode console
* @param g Le Graphe
*/
void print_graph(Graph g)
{
    /* #0# Déclaration.*/
    //rmq:Sur les anciennes versions du C, on ne pouvais pas faire de déclaration au milieu du code, c'était réservé au C++.
    int i;//compteur.
    /* #1# Tester si le graphe est vide.*/
    // if(g->nb_vertices == 0)
    // {
    //     printf("Rien a afficher, le Graphe n'existe pas.\n");
    //     return;
    // }
    /* #2# Affichage en parcourant un tableau de listes d'adjacences.*/
    for(i = 1 ; i < g->nb_vertices + 1 ; i++)
    {
        NodeList n = g->tab_neighbours[i-1].begin;//n, copie de la premiere liste d'adjacence.
        printf("(%d) : ", i);//afficher le sommet concerné.

        while(n != NULL)
        {
            printf("%d, ", n->value);//afficher la valeur du sommet.
            n = n->next;//décalage.
        }
    /* #3# Afficher le caractère de fin d'une liste.*/
        printf("NULL\n");
    }
}

/*-------------------------------------------------------------------------------*/

/**
* Affiche un Graphe en 2D (avec Graphviz sous WINDOWS)
* @param g Le Graphe
*/
void display_graph(Graph g)
{
    //Windows seulement !
    if(g->is_oriented)
        system("%CD%/Graphviz/bin/dotty.exe digraph.out");
    else
        system("%CD%/Graphviz/bin/dotty.exe graph.out");
}

/*-------------------------------------------------------------------------------*/

/**
* Supprime un Graphe (ne retourne pas un graphe vide, suppression définitive)
* @param g Le Graphe
*/
void erase_graph(Graph g)
{
    /* #1# Sortir si le graphe est vide.*/
    if(is_empty_graph(g))
    {
       printf("Rien a effacer, le Graphe n'existe pas.\n");
       return; 
    }
    /* #2# Libérer tous les noeuds (parcourir les listes).*/
    if(g->tab_neighbours)//tester si il y a une liste d'ajacences (Si il existe des sommets adjacents).
    {
        int i;

        for(i = 1 ; i < g->nb_vertices + 1 ; i++)//parcourir le nombre de sommets. i=1 et nb_sommet+1 comme pour la création.
        {
            NodeList n = g->tab_neighbours[i-1].begin;//créer un node pour récupérer le premier sommet de la liste chainée des noeuds.
            //supprimer la liste des noeuds.
            while(n != NULL)//parcourir la liste chainée.
            {
                NodeList tmp = n;//isoler l'élement à supprimer.
                n = n->next;//déplacement sur le node.
                free(tmp);//libérer tous les nodes.
            }
        }
    /* #3# Libération de la liste d'adjacence.*/
        //Libération de la liste d'adjacence
        free(g->tab_neighbours); //libérer la liste d'adjacence.
    }
    
    /*--------- Graphviz ----------*/
    /* #4# Fin et fermeture du fichier Graphviz.*/
    //Fin et fermeture du fichier Graphviz
    fprintf(g->graph_file, "}\n");// \n: convention pour le retour à la ligne fichier.
    fclose(g->graph_file);
    /*-----------------------------*/

    /* #5# Libération du Graphe de la mémoire.*/
    //Libération du Graphe
    free(g);
}

/*-------------------------------------------------------------------------------*/