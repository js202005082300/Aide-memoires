/**
 *      YouTube: https://www.youtube.com/watch?v=6E-zrVV2tSg
 *      Description: Langage C #2 - compiler programme
 *      Created:  18-01-2020 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Compilation: gcc main.c -o prog
 *      Author:  Samuel Jacquet
 */
 

/*
	1. Compiler et éxécuter le programme :
    
        a. La compilation :
            gcc fv_01.c -o hello
            -o : option pour créer un éxécutable, notre binaire.
            hello : nom de notre éxécutable.

        b. L'éxécution : 
            >hello ou >hello.exe : compiler notre éxécutable sur Windows.
            ./hello : compiler notre éxécutable sur Linux, Mac OS.

    2. Le code minimal pour afficher un message (ci-dessous).

        a. Une ligne d'inclusion = Une directive de pré-processeur.
            identifier avec un dièse. 
            permet de faire une inclusion.
            .h : extension pour identifier un fichier d'en tête.
            stdio.h : bibliothèque standard qui intègre diverses fonctions, comprises entre des chevrons.

        b. Une fonction main (obligatoire) :
            Identifier avec des acolades.
            Plus lisible grâce à l'indentation et la coloration synthaxique.
            Un en-tête pour transmettre des informations sur cette fonction :
                nom (main)
                paramètre-s entre parenthèses
                un type (int = integer) qui signifie le retour : ce que la fonction va renvoyer.
            Language de programmation impérative : 2 instructions.
                "return 0;" : instruction qui va retourner 0, un entier (int).
                "printf" : fonction qui va afficher à l'écran, incluse dans la bibliothèque standard du langage C.
*/

#include <stdio.h> 

int main(void)
{
    printf("Bonjour tous le monde ! :) \n");
    return 0;
}