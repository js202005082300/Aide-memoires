#include <stdio.h>
#include <stdlib.h>
#include "graph.h"

int main(void)
{
    //création d'un graphe (erase_graph() est obligatoire).
    Graph g1 = new_graph(5, true);//orienté

    add_edge(g1, 1, 2); //l'inverse fonctionne aussi si c'est non-orienté : add_edge(g1, 2, 1);
    add_edge(g1, 1, 5); //on peux aller nule part avec le 5 lorsque le graphe est orienté.
    add_edge(g1, 2, 4);
    add_edge(g1, 2, 3);
    add_edge(g1, 3, 4);
    add_edge(g1, 4, 5);

    print_graph(g1); //afficher un graphe en console.
    display_graph(g1); //afficher avec Graphiz un graphe (o/n-o).
    erase_graph(g1);

    return 0;
}

/*
 * 		YouTube: https://youtu.be/T5MU8NDMMj4
 * 		Description: Langage C #22 - graphes
 * 		Created: 06-03-20 | Revision: --
 * 		Compilater: GNU Compiler - GCC.
 *      Compilation: gcc main.c graph.c -o prog
 *      Author:  Samuel Jacquet
 */

/*
	##Graphe##
		
	- Application:
	
	Internet est un reseau (la toile mindiale), un graphe. Chaque adresse Ip (adresse web, site internet) est un noeud, un sommet d'un graphe. Chaque URL qui permet de faire un pont d'une adresse IP a une autre adresse IP est appele une arete, un arc de graphe. C'est un maillage dont chaque petit cercle sont reliés par des segments.
	
	Autres types de reseaux : routier, aviation, jeux videos (Utilisation d'un arbre pour montrer la liste des coups possibles aux echecs), calcul d'un itineraire (Chemin le plus cours pour passer par tous les sommets, les noeuds du graphe).
	
	- Representation de graphe: 
	Cercles reliees par des aretes. 
	Representation par une liste d'adjacences. 
	La structure implementee (GraphElement) permet de dire si notre graphe est orientee ou non (graphes connexes, etc).
	Les graphes s'emploient à utiliser une matrice, une liste d'adjacence ou encore une liste de valeurs d'incidences. 
	Des le debut du programme, on choisit le nombre de sommets (vertex, vertises, ici des entiers) et liens qui relient ces sommets (edges, arc en francais). 
	On ne fait pas de fonctions pour ajouter ou retirer un sommet comme dans les vidéos précédentes.
	On ne fait pas les parcours (disponible dans la formation algoryhtmie).
	Ensuite on crée un nombre de voisins dans une liste d'adjacences (tab_neighbours) avec plusieurs element qui pourront etre reliees a d'autres.

	- Transition avec la 2D:
	GraphViz, programme pour représenter des graphe en utilisant un petit langage de script qui s'appelle le DOT.
	Il permet d'afficher un graphe sous forme de texte les différents liens dans une représentation 2D.
	Télécharger l'archive Zip sur https://graphviz.gitlab.io/_pages/Download/Download_windows.html
	Mettre le dossier release à coté de notre programme.
	Exemple de langage DOT, graphe non orienté (--) et graphe orienté (->).
	graph my_graph
	{
		1 -- 2;
		1 -- 5;
	}
	digraph my_graph
	{
		1 -> 2;
		1 -> 5;
		2 -> 1;
	}

	Graphiz:
		new_graph() 		-> créer le graphe et ouvrir le fichier.
		add_edge()			-> créer des liens et ajouter les liens dans le fichier.
		erase_graph()		-> libérer le graphe et fermer le fichier.

		--> Nouvelle fonction: display_graph()
	
	Affichage du fichier avec DOT.exe ou la commande system() -> pas forcément très propre.
		system() est une fonction qui va utiliser des fonction de l'OS (exemple; CD, cls ou clear sur Linux ou MacOS)
		system("cls"); 	-> reproduit l'introduction du commande dans le cmd par un utilisateur.
						-> fonction pas du tout portable et sécurisé : utilisation de commande propre au systeme.
						-> Afin d'éviter d'ouvrir un terminal, d'executer dotty.exe en prenant son chemin en absolu et enfin de renvoyer le chemin en absolu vers le fichier de graphe.
		echo %CD% : retourne le répertoire courant sous Windows.
		echo $WD : retourne le répertoire courant sous Linux ou MacOS.
		/ : en programmation et sous Windows.
		\ : sous Linux, MacOS.

	Simplement tapper dotty graph.out (si instalation de Graphiz dans les variables d'environnement).
*/