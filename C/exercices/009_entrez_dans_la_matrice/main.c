/*
EXERCICE C #9
[Révision : jusqu'à la séance 15 - Alocation dynamique mémoire]

Votre programme doit permettre de créer une matrice d'entiers (de X lignes et Y colonnes)

<> Le programme s'exécutera en plusieurs étapes :
	- Création de la matrice
	- Remplissage des valeurs
	- Affichage
	- Destruction

Indications :
	- La taille voulue pour la matrice est saisie par l'utilisateur
	- La matrice est remplie de valeurs par ce dernier

[9. Entrez dans la matrice](https://www.youtube.com/watch?v=M_GufgQqztA)
*/
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int **matrix = NULL;
	int rows;
	int columns;
	int i, j;

	printf("Taille de la matrice (format : <rows> <columns>) ? ");
	scanf("%1d %1d", &rows, &columns);

	//Création
	matrix = malloc(rows * sizeof(int*));

	if(matrix == NULL)
		exit(1);

	for(i = 0 ; i < rows ; i++)
	{
		matrix[i] = malloc(columns * sizeof(int));

		if(matrix[i] == NULL)
			exit(1);
	}

	//Remplissage
	for(i = 0 ; i < rows ; i++)
		for(j = 0 ; j < columns ; j++)
		{
			printf("Valeur pour [%d][%d] ? ", i, j);
			scanf("%2d", &matrix[i][j]);
		}

	//Affichage
	for(i = 0 ; i < rows ; i++)
		for(j = 0 ; j < columns ; j++)
			printf("[%d][%d] = %d\n", i, j, matrix[i][j]);

	//Destruction
	for(i = 0 ; i < rows ; i++)
	{
		free(matrix[i]);
		matrix[i] = NULL;
	}
	free(matrix);
	matrix = NULL;

	return 0;
}
