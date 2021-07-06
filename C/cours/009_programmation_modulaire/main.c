/**
 *      YouTube: https://www.youtube.com/watch?v=tXgSx9MkVjs
 *      Description:  Langage C #9 - programmation modulaire
 *      Created:  09-02-20 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Compilation:    gcc main.c player.c -o prog
 *      Author:  Samuel Jacquet
 */

 /*

 ## Organiser un programme en plusieurs fichiers ##

 Modalirité = 
 inclure des bibliothèques, des bout de codes, des fonctions dans nos programmes et 
 les utiliser. Par exemple, printf est une fonction de la bibliothèque stdio.h. 
 C'est moduler, régorniser un développement sur plusieurs fichiers sources.
 Moduler 

 c'est des fichiers .h (contenu des prototypes toujours terminés par des point virgules, les valeurs 
 de retour, un fichier d'en-tête, la fiche de description, toujours associer à un fichier source).
 
 C'est des fichiers .c (implémentation des fonctions)

 La modularité est utile dans la 2D, inclure la SDL, OpenGL.

 La portée des variables = à la fin d'une fonction, une variable est détruite. Quand je quitte l'environnement de la fonction, son contexte,
 elle est détruite sauf pour les variables globales.
    *1* La variable globale = variable en dehors de toutes fonctions. Elles doivent être évitées. Utilisation dans tout le programme.
    *2* La variable static = utilisation forcée de la variable dans le fichier ou elle est implémentée. Elle ne serra pas détruite à la fin d'une fonction.

 */
 #include <stdio.h> // inclure un fichier d'en-tête standard.
 // bibliothèque non incluse dans l'environnement de développement.
 #include "player.h" // bibliothèque incluse dans les fichiers sources qui en ont besoin.
 // On évite de les mettre dans les fichiers d'en-têtes.

 // Variable statique.
 static int TVA = 20;

 // On écrit la fonction dans le fichier main quand il n'y a pas de modularité.
 void bonjour1(void)
 {
     printf("Bonjour :) !\n");
 }

 // Toujours sans modularité mais en utilisant un prototypes.
 void bonjour2(void);

 int main(void)
 {   
     /********** Fonctions, modules et prototypes **********/

     bonjour1();
     bonjour2();
     bonjour3();

     /********************/

     int level = 15;
     printf("Niveau actuel : %d\n", level);
     level = reset_niveau();
     printf("Niveau apres reset : %d\n", level);

     /********** Variable globale et static **********/
     printf("TVA = %d\n", TVA);

     /********** Variable static dans une fonction **********/

     printf("Niveau1 = %d\n",augmenter_niveau()); // afficher le retour d'une fonction dans un printf.
     printf("Niveau1 = %d\n",augmenter_niveau());
     printf("Niveau1 = %d\n",augmenter_niveau());

     printf("Niveau2 = %d\n",augmenter_niveau2());
     printf("Niveau2 = %d\n",augmenter_niveau2());
     printf("Niveau2 = %d\n",augmenter_niveau2());

     /********** Fonction static dans une fichier **********/

     // Les fonctions suivantes sont statiques et autorisées seulement dans le fichier player.
     //bonjour4();
     //augmenter_niveau3();

     bonjour5();

     return 0;
 }

 void bonjour2(void)
 {
     printf("Bonjour :) !\n");
 }