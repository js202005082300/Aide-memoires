/**
 *      YouTube: https://www.youtube.com/watch?v=L8q1wJ8z7Ts
 *      Description:  Langage C #10 - préprocesseur
 *      Created:  09-02-20 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Compilation:    gcc main.c -o prog
 *      Author:  Samuel Jacquet
 */

 /*

 ## Donner des directives au préprocesseur ##

 Action qui a lieu avant la compilation.

 Commande du préprocesseur = commence par un dièse. 
 #include permet d'inclure un fichier.

 préprocesseur = sous-programme qui s'execute de manière prioritaire. 
 Il effectue des changements, des inclusions, des paramètrages suivant 
 les directives données (commencées par un dièse).

    *1* #include : Inclure des fichiers natif ou bibliothèques propres. 
 Le préprocesseur inclut des fichiers d'en-têtes natif (intégré au langage) en mettant des chevrons.
 Par exemple, tout ce qui est entrée/sortie standard (input, output) du langage c qui permettent
 d'utiliser les fonctions printf, scanf, fopen (gestion de fichier), etc.
 La compilation se fait après l'étape pré-processing.

    *2* #define : Définir des constantes.
 Directive qui permet de définir une constante au quel on attribue une valeur pour l'ensemble du programme.
 Cette directive permet de modifier une valeur qui se répercute sur tout le code sans soucis.
 En résumé, le define fait du remplacement pour le pré processeur d'une valeur en une autre.
 Il permet aussi de faire des expression arithmétique.

    *3* #ifndef... #define ... #endif : protéger des problèmes d'inclusions (inclusions infinies) avec ces 3 directives.
 Directive dont la variable s'écrit en majuscule. 
 Cette variable commence et finie par 2 underscores par convention.
 Cette directive protège le fichier en l'empêchant de tourner en boucle en évitant 
 le cas ou deux fichiers veulent commencer par s'inclure l'un l'autre et donc avoir une boucle infinie.
 La directive #ifndef permet de ne pas inclure un fichier s'il a déjà été inclut/définis.

 Constante prédifinies en langage C : 
    __FILE__ (nom du fichier source)
    __LINE__ (ligne du fichier)
    __DATE__ (date de compilation)
    __TIME__ (heure de compilation)
 -> Utilisé en débogage.

 */

/*********** Partie Préprocesseur *************/
 #include <stdio.h>
 #include "bibli.h"
 #define TVA 20
 #define afficher printf //Les mots afficher seront remplacé par printf avant la compilation par le préprocesseur.
 //Le préprocesseur remplace les mot afficher, élimine le define et passe ensuite à l'étape de compilation.
 //Les directives du préprocesseur ne sont pas prise en charge par le compilateur.
 #define Coucou printf("Coucou !\n")
 //#define printf pspDebugScreenPrintf //exemple pour la psp (simplification de nom).
 #define LONGUEUR 15
 #define LARGEUR 38
 #define AIRE (LONGUEUR * LARGEUR)
/****************************************/

/*********** Partie Compilateur *************/
 int main()
 {
     int prixHT = 15;
     int prixTTC = 0;

     /* Constante globale */
     //Le compilateur n'aura pas de constante dans le code source à la base. 
     //La transformation de TVA en 20 se fait avant la compilation.
     prixTTC = prixHT + (prixHT + TVA / 100);
     printf("prixTTC : %d\n",prixTTC);

     /* Modification de fonction */
     afficher("prixTTC : %d\n",prixTTC);
     Coucou;

     /* Arithmétique */
     printf("Aire du carre : %d\n",AIRE);
    
     /* Constante prédifinies en langage C */
     printf("Nom du fichier : %s\n",__FILE__);

     return 0;
 }
/****************************************/