/**
 *      Modul:  player.c
 *      Created:  09-02-20 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Author:  Samuel Jacquet
 */

 #include <stdio.h>
 #include "player.h" // inclusion vers le fichier d'en-tête, vers le prototype.

 // Implémentation : En modularité, on écrit le code, l'implémentation dans un fichier source associé à une en-tête (même nom).
 void bonjour3(void)
 {
     printf("Bonjour :) !\n");
 }

 int reset_niveau(void)
 {
     int niveau;
     niveau = 0;
     return niveau;
 }

 int augmenter_niveau(void)
 {
     int niveau = 0;
     niveau += 2;
     return niveau;
 }

 int augmenter_niveau2(void)
 {
     static int niveau = 0; /* Le mot clé static dans une variable 
     *de fonction fait en sorte que la variable n'est pas détruite 
     *à la fin de la fonction. Elle exécutée une fois, enregistrée
     *et incrémenté directement à la ligne suivante. Elle serra
     *seulement détruite à la fin du programme.
     */
     niveau += 2;
     return niveau;
 }

 static void bonjour4(void)
 {
     printf("Bonjour :) !\n");
 }

 static int augmenter_niveau3(void)
 {
     static int niveau = 0;
     niveau += 2;
     return niveau;
 }
 
 void bonjour5(void)
 {
     printf("Bonjour :) !\n");
     printf("Niveau3 = %d\n",augmenter_niveau3()); // fonction static utilisable seulement dans le fichier ou elle est implémentée.
 }