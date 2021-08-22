#include <stdio.h>

int main(void)
{
    int tabint[5] = {2, 5, 3, 1, 4};
    int taille = 5;
    int i,j, tmp;

    printf("\n");
    for(int k = 0 ; k < taille ; k++)
        printf("%d ", tabint[k]);

    for(i = 0 ; i < taille ; i++)
    {
        tmp = tabint[i];
        j = i;

        while(j > 0 && tabint[j-1] > tmp)
        {
            tabint[j] = tabint[j-1];
            j = j-1;
        }

        tabint[j] = tmp;
    }

    printf("\n");
    for(int k = 0 ; k < taille ; k++)
        printf("%d ", tabint[k]);

    return 0;
}