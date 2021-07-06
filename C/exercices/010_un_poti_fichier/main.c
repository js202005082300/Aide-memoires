/*
Exercice C #10
[Révision : jusqu'à la séance 16 - Fichiers]

> Un fichier texte contient des séquences de caractères alphabétiques (ex : AAAABBBDDDDDDDDFEEEXXXXXP)
> Chaque séquence de ce fichier devra être transformée et écrite dans un nouveau fichier :

	- Par exemple, les séquences "AAAABBXXXXXXX" deviendront "A4B2X7"

> Testez ensuite votre programme avec les deux fichiers de données fournis (small_data + big_data)

	- Que remarquez-vous concernant les fichiers produits par votre code ?


[10. Un poti fichier](https://www.youtube.com/watch?v=7MzC5MIGyEs)
*/

#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	FILE *datafile = fopen("data_big.txt", "r");

	if(datafile == NULL)
		exit(1);

	FILE *potifile = fopen("data_big.poti", "w");

	if(potifile == NULL)
		exit(1);

	//-----------------------------------------------------------

	char character, last_character;
	int count = 0;

	printf("Compression en cours...");

	if((last_character = fgetc(datafile)) != EOF)
	{
		count++;

		while((character = fgetc(datafile)) != EOF)
		{
			if(character == last_character)
				count++;
			else
			{
				fprintf(potifile, "%c%d", last_character, count);
				last_character = character;
				count = 1;
			}
		}

		fprintf(potifile, "%c%d", last_character, count);
	}

	printf("OK\n");

	//-----------------------------------------------------------
	
	fclose(datafile);
	fclose(potifile);

	return 0;
}
