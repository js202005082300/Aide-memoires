/**
 * YouTube: https://youtu.be/6nkUWnCoRp4
 * Description: Langage C #12 - tableaux
 * Created: 19-02-20 | --.
 * Compiler: MobileC
 * Compilation: gcc main.c -o prog
 * Author: Samuel Jacquet
 */
#include <stdio.h>

// Constantes de pre processeur.
#define TAILLE_TAB 5
#define nombre_lignes 3
#define nombre_colonnes 2

//void afficher_tableau(int *tab, int taille_tableau);
void afficher_tableau(int tab[], int taille_tableau);
void *creer_tableau(void);

/******************************************/

int main(void)
{
/* 
#1# [Declaration tableaux] : <type> <nom_tableaux>[x]; // declarer avec variables aleatoires.
*/
/*
	-a- <type> : choisir un type de donnees (int, float, string, voir plusieurs structure). On ne peux pas melanger les types.
	-b- <nom_tableaux> : choisir un nom.
	-c- [x] : choisir le nombre de case, donnees.Les cases contiennent des valeurs aleatoires.
*/	
	int tab[5];

/*
#2#	[Initialisation]
	-1- tableau[5] = {valeur1,valeur2,valeur3,valeur4,valeur5};
*/
	int tableauA[5] = {12, -4, 40, 409, 18};
	
/* -2- : Toutes les casent valent zeros. tableau[5] = {0} //ou {}.*/	
	int tableauB[5] = {0};
		
/* -3- : Premiere case a 4, LE RESTE A ZERO.*/
	int tableauC[5] = {4};
	int tableauD[5] = {4, 3}; // Les 2 premieres a 4 et 3, LE RESTE A ZERO.
	
/*
#3# [Acces au tableau]
	
	#3-1- tableau[x] : element d'indice x (x+1eme element du tableau).
	
	Les cases sont contigues, les cases se suivent en memoire.
	On accede aux espaces memoires en mettant entre crochet l'indice du tableau.
	L'indice 0 est la premiere case de mon tableau.
	L'indice de 4 de tab[4] represente la 5eme valeur.
	
Memoire RAM : 5
Adresses		Valeurs
00000001
...
00100000	tab[0] = 14
00100001	tab[1] = 6
00100002	tab[2]
00100003	tab[3]
00100004	tab[4]
...
00AA58F1
*/
	tab[0] = 14;
	tab[1] = 6;	
	
/*Note. Pour afficher un tableau : Avantage de toutes les cases qui se suivent, ce qui permet de faire une boucle en partant depuis la premiere case.*/
/* A. Afficher avec la boucle FOR.*/
	int tableauE[5] = {4};
	int i; //declarer un compteur.
	for(i=0;i<5;i++) //La boucle for est faite pour les parcours. On incremente i de 1 jusqu'a la taille du tableau.
	{
		printf("Valeur_tabE : %d\n",tableauE[i]); // afficher un tableau d'indice i.
	}
/* B. Definir la taille d'un tab.*/
	/*1. Avec une variable.*/
	/* Depuis la norme C99, on peut utiliser une variable pour dimentionner un tableau. -> Non recommande.
	int taille_tab = 5;
	int tableauF[taille_tab] = {4};
	int j;
	for(j=0;j<taille_tab;j++)
		printf("Valeur : %d\n",tableauF[j]);
	*/
	/*2. Avec un Define.*/
	int tableauG[TAILLE_TAB] = {0};
	int k;
	for(k=0;k<TAILLE_TAB;k++)
		printf("Valeur_tabG : %d\n",tableauG[k]);
	
/* C. Acceder et modifier une valeur d'un tab.*/
	int tableauH[TAILLE_TAB] = {10, 20, 30, 40, 50};
	int l;
	for(l=0;l<TAILLE_TAB;l++)
		printf("Valeur_tabH : %d\n",tableauH[l]);
	tableauH[2] = 15; //acceder et modifier la 3eme valeur.
	for(l=0;l<TAILLE_TAB;l++)
		printf("Valeur_tabH : %d\n",tableauH[l]);
	
	/* #3-2- tableau : adresse du tableau.*/
	/* #3-3- *tableau : premier element du tableau (la valeur).*/
	/* #3-4- *(tableau + x) : element d'indice X.
	Note. idem a -1-. tableau[5] meme chose que *(tableau + 5) mais les programmeurs faisaient beaucoup des erreurs (oubli de parantheses,etc) donc la syntaxe a changees ou on a masque le pointeur mais les tableaux sont bien des pointeurs vers leur premier element. Et a partir du moment ou a le premier element, on peux parcourir tout le tableau. Utilise rarement.
	*/
	int tableauI[TAILLE_TAB] = {0, 1, 2, 3, 4};
	int m;
	for(m=0;m<TAILLE_TAB;m++)
		printf("Valeur_tabI : %d\n",*(tableauI + m));	// Un tableau est un pointeur.

/* #4# Fonctions et tableaux.*/
	/* Les fonctions ont pour avantage d'eviter les repetitions de codes. On modifie une seule fonction pour modifier plusieurs applications.*/
	/* -1- mettre un tableau en parametre d'une fonction.*/
	int tableauJ[TAILLE_TAB] = {0, 1, 2, 3, 4};
	afficher_tableau(tableauJ, TAILLE_TAB); // tableauJ est deja un pointeur, une adresse vers la premiere case du tableau, pas besoin de & comme pour les variables. La fonction a modifiee le vrai tableau car on lui a passe un pointeur, une adresse vers le premier element d'un tableau et non une copie du tableau. La fonction a directement acceder a l'adresse du tableau pour modifier les valeurs.
	/* -2- retourner un tableau avec une fonction.
	Retourner l'adresse du premier element d'un tableau pour obtenir tous les autres. Un tableau est l'adresse vers sa premiere valeur puisqu'elles se suivent toutes.*/
	int *tableauK = creer_tableau(); // declaration d'un pointeur, on ne connais pas la taille du tableau a retourner.
	int n;
	for(n=0;n<5;n++)
		printf("creer_tab : %d\n",tableauK[n]);
	
	/* -2- declarer un tableau a deux dimension.*/
	int damierA[3][2] = 
	{
		{1,2},
		{3,4},
		{5,6}
	}; // 3 lignes et 2 colonnes pour notre damier de jeux video.
	//idem avec des constantes de pre processeur.
	int damierB[nombre_lignes][nombre_colonnes] = 
	{
		{1,2},
		{3,4},
		{5,6}
	};
	int o, p;
	// Utilisation d'une double boucle pour afficher.
	for(o=0;o<nombre_lignes;o++) // On met des acolades si on a au moins 2 instructions.
		for(p=0;p<nombre_colonnes;p++)
			printf("Element d'indice[%d][%d] : %d\n",o,p,damierB[o][p]);
	
	return 0;
}

/******************************************/

/*
 * Pre : un tableau et la taille du tableau 
 * (minimum)
 *
 */
 
//void afficher_tableau(int *tab, int taille_tableau)
void afficher_tableau(int tab[], int taille_tableau)
{
	int i;
	for(i=0;i<taille_tableau;i++)
		printf("fonction_tab : %d\n",tab[i]);
}

/******************************************/

/*
 * Pre : void
 * Post : un pointeur vers un tableau initialise
 */

void *creer_tableau(void)
{
	static int tableau_entiers[5];
	int i;
	for(i=0;i<5;i++)
		tableau_entiers[i] = i*3;
	return tableau_entiers; // ne pourra pas retourner l'adresse d'une variable local, une solution est de retourner l'adresse d'une variable static.
}