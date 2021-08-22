#include <stdio.h>

void maFonction(int nombre)
{
	printf("%d\n", nombre);
}

int main(void)
{
	char monPrenom[] = "Jason";
	int monAge = 26;
	//float nombrePI = 3.14;
	//---------------
	int nombre = 15;
	int nombre2 = 6;
	int *ptr_nombre = &nombre;
	
	if(monAge > 18)
		printf("Tu est majeur\n");
	else
		printf("Tu est mineur\n");

	for(int i = 0; i <= 5; i++)
		printf("%c\n", monPrenom[i]);
	
	maFonction(14);
		
	ptr_nombre = &nombre2; // ptr_nombre = nombre2; ne fonctionne pas.
	printf("%d\n", *ptr_nombre);
	
	*ptr_nombre = 3;
	printf("%d\n", *ptr_nombre);
	
	return 0;
}