#include "tree.h"

int main(void)
{
    /* 1. Initialisation */
    Tree *arbre_A = new_tree(32);

    /* 2. Eviter les fuites mémoires */
    clean_tree(arbre_A);
    // Sans free(arbre), il y a une fuite de mémoire à la fin du programme,
    // il faudra attendre le redemarrage ou la reinitialisation de la RAM.
    
    printf("--------------------------\n");
    
    /* 3. Joint deux arbres pour n'en former qu'un */
    Tree *arbre_B = join_tree(new_tree(2), new_tree(4), 6);
    
    clean_tree(arbre_B);

    printf("--------------------------\n");

    /* 4. Idem en développant l'arbre gauche */
	Tree *arbre_C = join_tree(join_tree(new_tree(8), new_tree(3), 2), new_tree(4), 6);
	
    /* 5. Affiche un arbre récursivement (parcours préfixé) */
	print_tree_prefix(arbre_C);
    // La racine n'est pas relié, les premiers liens sont liés en préfixe
	
    /* 6. Compte le nombre de noeuds d'un arbre */
	printf("Nombre de noeuds : %d\n", count_tree_nodes(arbre_C));
	
    /* 7. Libérer la mémoire */
	clean_tree(arbre_C);
    
    return 0;
}

/*
 * 		YouTube: https://youtu.be/x56yrmgx5B4
 * 		Description: Langage C #21 - arbres binaires
 * 		Created: 02-03-20 | Revision: --
 * 		Compilater: GNU Compiler - GCC.
 *      Compilation: gcc main.c tree.c -o prog
 *      Author:  Samuel Jacquet
 */

/*
	Structure de donnees.
	La pile : Grace a typedef, le pointeur de stack est cache (StackElement, *Stack), il est explicite. Masquer les pointeurs permet d'eviter les risques d'oubli. Pour d'autre, la force du langage C vient de l'utilisation des pointeurs et ainsi il est preferable de les afficher.
	
	Les arbres binaire:
		structure de donnees hiarchisees avec des elements, appeles noeud. Le noeud initial est appele racine.
		Branche : lien entre deux noeuds.
		Fils (droit ou gauche): element au niveau inferieur (au plus deux noeuds fils).
		Pere: element au niveau superieur.
		Noeud racine: element au niveau le niveau le plus eleve.
		Feuille: noeud n'ayant aucun fils.
		Hauteur de l'arbre: distance entre la feuille la plus éloignée et la racine.
		Profondeur: le niveau d'un nœud.

		Structure qui se prête bien à la récursivité.

		Autres fonctions : 
			comparer(), 
			trier(), 
			rotation_arbre(), 
			insert_par_ordre_croissant() -> parcourir en reccursif et si le noeud suivant était plus petit que la valeur à insérer, on fait soit une insertion ou bien continuer le parcours.
*/