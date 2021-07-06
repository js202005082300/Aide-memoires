#include "numbers.h"
#include <stdio.h>
#include <stdlib.h>

void app_calc(void)
{
    int choice = 0;

    do
    {
        show_menu();
        printf("> ");
        scanf("%d", &choice);

        switch(choice)
        {
            case 1:
                do_operation(choice);
                break;

            case 2:
                do_operation(choice);
                break;

            case 3:
                do_operation(choice);
                break;
            
            case 4:
                do_operation(choice);
                break;
            
            case 5:
                break;
            
            Default:
                printf("Option incorrecte !\n");
        }
    }
    while(choice != 5);
}

void show_menu(void)
{
    printf("1. Addition\n2. Soustration\n3. Multiplication\n4. Division\n5. Quitter le programme\n");
    printf("------------------------\n");
}

void do_operation(int choice)
{
    int nb1 = 0, nb2 = 0;
    int result = 0;

    do
    {
        printf("Entrez un premier nombre : ");
        scanf("%d", &nb1);

        printf("Entrez un deuxieme nombre : ");
        scanf("%d", &nb2);

        if(nb1 < -1000 || nb1 > 1000 || nb2 < -1000 || nb2 > 1000)
            printf("Saisie incorrecte (choisir un nombre entre -1000 et 1000)\n");
        else
        {
            if(choice == 1) result = addition(nb1, nb2);
            else if(choice == 2) result = soustraction(nb1, nb2);
            else if(choice == 3) result = multiplication(nb1, nb2);
            else if(choice == 4) result = division(nb1, nb2);

            printf("Resultat de calcul = %d\n", result);
        }
    }
    while(nb1 < -1000 || nb1 > 1000 || nb2 < -1000 || nb2 > 1000);
}

int addition(int a, int b)
{
    return a + b;
}

int soustraction(int a, int b)
{
    return a - b;
}

int multiplication(int a, int b)
{
    return a * b;
}

int division(int a, int b)
{
    if(b == 0)
    {
        printf("Division par 0 impossible\n");
        exit(-1);
    }
    
    return a / b;
}