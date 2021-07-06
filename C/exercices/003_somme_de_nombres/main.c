/*
EXERCICE C #3
[Révision : boucles]
> Ecrire un programme qui calcule la somme des entiers d'un nombre à un autre (Maximum : entre 1 et 1 000)

> Indications : 
    - prévoir le cas où "min" serait plus grand que "max" et quitter le programme si cela arrive.
    - prévoir le cas où "min" serait plus petit que 1 et "max" plus grand que 1 000.

[3. Somme de nombres](https://www.youtube.com/watch?v=aXHroKdj_mI)
*/
#include <stdio.h>

int main(void)
{
    int min = 0, max = 0, sum = 0;

    printf("Entrez un nombre MIN (entre 1 et 1 000) : ");
    scanf("%d", &min);

    if(min < 1)
    {
        printf("MIN trop petit !\n");
        return -1;
    }

    printf("Entrez un nombre MAX (entre 1 et 1 000) : ");
    scanf("%d", &max);

    if(max > 1000)
    {
        printf("MAX trop grand !\n");
        return -1;
    }

    if(min > max)
    {
        printf("Saisies incorrectes !\n");
        return -1;
    }

    if(min != max)
        for(int i = min ; i < max + 1 ; i++)
            sum += i;
    else
        sum = min;

    printf("Somme finale : %d\n", sum);

    return 0;
}
