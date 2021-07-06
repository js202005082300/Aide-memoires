/**
 *      Modul:  header of player.c
 *      Created:  09-02-20 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Author:  Samuel Jacquet
 */

 // Les directives de pré-processeurs (commencent toujours par des #)
 #ifndef PLAYER_H // Autre directive (if not def) suivi d'un nom de constante en majuscules.
 #define PLAYER_H // Si la constante n'est pas définie, alors on la défini.

 // Prototype : le fichier .h décrit ce que notre player peut faire.
 void bonjour3(void);
 int reset_niveau(void); 
 int augmenter_niveau(void);
 int augmenter_niveau2(void);
 static void bonjour4(void);
 static int augmenter_niveau3(void);
 void bonjour5(void);

 #endif // si le fichier player.h a déjà été inclut, le préprocesseur ne doit pas le réinclure.
 // éviter les risques d'inclusion infinie mais inclure une seule fois le fichier.