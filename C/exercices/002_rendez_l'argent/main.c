/*
EXERCICE C #2
[Révision : jusqu'à la séance 6 - conditions]
> Ecrire un programme de rendu de monnaie. En saissant le montant total des achats puis la somme donnée, indiquer la monnaie à rendre (en billets de 20€, 10€, 5€ et pièces de 2€ et 1€)

> Indications :
    - S'assurer que la somme donnée est bien supérieure à la somme des achats
    - Gérer le cas où on aurait payé un montant égal aux achats
    - Rendre le moins de billets/pièces possible (25€ de monnaie -> 1 billet de 20€ + 1 billet de 5€)
    - L'opérateur % (modulo) sera utile pour cet exercice

[2. Rendez l'argent !](https://www.youtube.com/watch?v=OQP3kgexXtU)
*/
#include <stdio.h>

int main(void)
{
    int purchases = 0, amount_paid = 0, result = 0;
    int bill20 = 0, bill10 = 0, bill5 = 0, coin2 = 0, coin1 = 0;

    printf("Entrez le total des achats : ");
    scanf("%d", &purchases);
    printf("Entrez la somme payee      : ");
    scanf("%d", &amount_paid);

    if(amount_paid < purchases)
    {
        printf("Vous n'avez pas paye suffisamment.\n");
        return -1;
    }
    else if(amount_paid == purchases)
    {
        printf("Pas de monnaie a rendre.\n");
        return 0;
    }
    else
    {
        result = amount_paid - purchases;

        bill20 = result / 20;
        result %= 20;
        bill10 = result / 10;
        result %= 10;
        bill5 = result / 5;
        result %= 5;

        coin2 = result / 2;
        result %= 2;
        coin1 = result / 1;
        result %= 1;

        printf("\n_____MONNAIE A RENDRE_____\n");
        if(bill20 > 0)
            printf("Billet(s) de 20 euros : %d\n", bill20);
        if(bill10 > 0)
            printf("Billet(s) de 10 euros : %d\n", bill10);
        if(bill5 > 0)
            printf("Billet(s) de 5 euros  : %d\n", bill5);
        if(coin2 > 0)
            printf("Piece(s) de 2 euros   : %d\n", coin2);
        if(coin1 > 0)
            printf("Piece(s) d'1 euro     : %d\n", coin1);
    }

    return 0;
}
