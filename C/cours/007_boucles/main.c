/**
 *      YouTube: Langage C #7 - boucles
 *      Description: https://www.youtube.com/watch?v=in-XJLbQ1iY
 *      Created:  19-01-2020 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Compilation: gcc main.c -o prog
 *      Author:  Samuel Jacquet
 */
 /*
    Les itérations :
        répéter plusieurs fois
        i, j, k : compteurs
        Condition d'arrêt sinon boucle infinie (sauf en cas de listner dans un jeu vidéo)
        1. while(){}
        2. do{}while();
        3. for(1;2;3){}
            1. initialiser : i=0;
            2. condition à vérifier (condition d'arrêt); 
            3. incrémentation ou décrémentation à faire.
 */

#include <stdio.h> 

int main(void)
{
    int i = 0, j = 0; // généralement, on part de 0 et on va jusqu'à strictement inférieur à 20.
    int k;

    // while : Tant qu'une condition n'est pas vrai, tu va répéter ce qui suit.
    while(i < 20 || i != 20) 
    {
        printf("Alerte, les zombies nous envahissent !\n");
        i++;
    }

    // do while
    do
    {
        printf("Aya !!\n"); // afficher au moins une fois ce qu'il y a dans la boucle.
        j++;

    }while(i < 5);

    for(i = 0; i < 5; i++)
    {
        printf("Aya !!\n");
    }

    // for
    for(i = 0; i < 5; i++)
    {
        printf("Aya !!\n");
        break; // éxécuter 1 fois.
    }


    return 0;
}