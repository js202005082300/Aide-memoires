/**
 * YouTube: https://www.youtube.com/watch?v=71QV6fFl_bk
 * Description: Langage C #15 - allocation dynamique mémoire
 * Created: 23-02-20 | --.
 * Compiler: GNU Compiler - GCC.
 * Compilation: gcc main.c -o prog
 * Author: Samuel Jacquet
 */

 /*
    allocation dynamique mémoire :
        réserver des zones en mémoire de manière dynamique.
        diffère du tableau avec une taille fixe en mémoire définie entre crochets.
        Application : données variables, nombre de joueurs inconnus dans un jeu.

 */

 #include <stdio.h> // Bibliothèque standard pour les entrées/sorties. L'espace est important dans la syntaxe.
 #include <stdlib.h> // Bibliothèque pour les allocations dynamiques.

 int main(void)
 {
    printf("\n------------------- 1 --------------------\n");
    /* #1# Créer une allocation dynamique.*/
    int nombreJoueursA = 2;
    //int listeJoueurs[nombreJoueurs]; -> validé depuis la norme C99 mais à éviter car cela fonctionne pour un nombre réduit de personnes.
    int *listeJoueursA = NULL; // initialiser proprement un pointeur (tableau) à NULL.
    int i;
    //printf("Combien de joueurs ? ");
    //scanf("%d",&nombreJoueurs);
    /* -1- Alloue et initialiser un pointeur avec la fonction malloc.*/
    listeJoueursA = malloc(sizeof(int) * nombreJoueursA); // -> reserve autant d'entiers qu'il y a de joueurs.
                                                        // malloc(<taille_en_octet>) : allouer dynamiquement une zone mémoire. Taille diffère selon l'exploitation : char(1 octet), int(2,4 octets pour une architecture 64 bits). Si on utilise des structures de plusieurs types de données, on preferera utiliser la fonction sizeof plutot que calculer la somme de toutes les variables.
    /* -2- Tester l'allocation sinon exit().*/          // ziseof(<type_de_donnee>) : retourne la taille en octets d'une donnée.
    if(listeJoueursA == NULL) // Si la fonction n'as pas retourner l'objet alloué, la fonction rend null.
        exit(1); // quitter le programme.
    
    /* -3- Modifier et acceder aux cases mémoires.*/ 
    for(i = 0 ; i < nombreJoueursA ; i++)
    {
        printf("Joueur %d -> numero %d\n", i+1, i*3);
        listeJoueursA[i] = i*3; // Sinon Malloc retourne des emplacements mémoires avec des valeurs quelconques.
    }

    /* -4- Afficher le tableau.*/ 
    for(i = 0 ; i < nombreJoueursA ; i++)
    {
        printf("[%d] ", listeJoueursA[i]);
    }
    /* -5- Libérer la mémoire.*/
    free(listeJoueursA); // free(<donne_allouee>) : Libérer la mémoire allouée dynamiquement. Autant de Free que de Malloc.
    
    printf("\n------------------- 2 --------------------\n");
    /* #2# Créer une allocation dynamique et tout initialiser à zero.*/
    int nombreJoueursB = 2;
    int *listeJoueursB = NULL;
    int j;
    /* -1- Alloue et initialise tout à zero.*/
    listeJoueursB = calloc(nombreJoueursB, sizeof(int)); // calloc(<type_de_donnee>, <taille_en_octet>) : alloue et initialise tout a 0 (c : clear memory, alloc : allocation).
    /* -2- Tester l'allocation sinon exit().*/
    if(listeJoueursB == NULL)
        exit(1);
    /* -3- Afficher le tableau.*/ 
    for(j = 0 ; j < nombreJoueursB ; j++)
    {
        printf("[%d] ", listeJoueursB[j]);
    }
    /* -4- Libérer la mémoire.*/
    free(listeJoueursB);
    
    printf("\n------------------- 3 --------------------\n");
    /* #3# Reallouer un espace mémoire.*/ 
    /* -1- Malloc : allouer dynamiquement une zone mémoire.*/
    int nombreJoueursC = 2;
    int *listeJoueursC = NULL;
    int k;
    listeJoueursC = malloc(sizeof(int) * nombreJoueursC);
    if(listeJoueursC == NULL)
        exit(1);
    for(k = 0 ; k < nombreJoueursC ; k++)
    {
        printf("Joueur %d -> numero %d\n", k+1, k*3);
        listeJoueursC[k] = k*3;
    }
    for(k = 0 ; k < nombreJoueursC ; k++)
    {
        printf("[%d] ", listeJoueursC[k]);
    }

    printf("\nAdresse de la liste : %p\n", listeJoueursC);
    
    printf("\n---------------------------------------\n");
    /* -2- Realloc : Reallouer une espace mémoire.*/
    // Risque de perdre des données allouées si Realloc ne fonctionne pas --> sécuriser..
    nombreJoueursC = 5; // Le nombre de joueurs passe à 5.
    listeJoueursC = realloc(listeJoueursC, nombreJoueursC * sizeof(int)); // realloc(<donnee>, <nouvelle_taille>) : realloue un espace mémoire. 
    if(listeJoueursC == NULL) // vérifier que le realloc a bien alloué la mémoire.
        exit(1);
    for(k = 0 ; k < nombreJoueursC ; k++)
    {
        printf("Joueur %d -> numero %d\n", k+1, k*3);
        listeJoueursC[k] = k*3;
    }
    for(k = 0 ; k < nombreJoueursC ; k++)
    {
        printf("[%d] ", listeJoueursC[k]);
    }
    printf("\nAdresse de la liste : %p\n", listeJoueursC); // Recherche d'un nouvelle emplacement mémoire avec 5 entiers au lieu de 3.
    free(listeJoueursC); 
    return 0;
 }