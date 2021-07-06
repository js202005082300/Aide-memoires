/**
 * YouTube: https://www.youtube.com/watch?v=j1lHUmwnmA0
 * Description: Langage C #16 - fichiers
 * Created: 23-02-20 | --.
 * Compiler: GNU Compiler - GCC.
 * Compilation: gcc main.c -o prog
 * Author: Samuel Jacquet
 */

 #include <stdio.h>
 #include <stdlib.h> // exit().

 /*
    Fonctions d'ouverture/fermeture :
    fopen(<fichier>, <mode_ouverture>) :    r (lecture seule, doit exister)
                                            w (écriture seule)
                                            a (ajout fin de fichier)
                                            r+ (lecture/écriture, doit exister)
                                            w+ (lecture/écriture, supprime contenu)
                                            a+ (ajout lecture/écriture, fin de fichier)
    fclose(<fichier>) : fermer un fichier ouvert (obligatoire).
    feof(<fichier>) : tester la fin d'un fichier.
    fonctions de fichiers :
    
    [LECTURE]
    fgetc(<fichier>)                : lire un caractère. 
                                    -> Retourne EOF en cas d'erreur de lecture ou de fin de fichier.
    fegets(<chaine>)                : lire une ligne. (Très utilesé et plus sécurisé car lit jusqu'à 255 caractères max).
                                    -> Retourne NULL en cas de fin de fichier.
    fscanf(<fichier>,<format>,...)  : lire un texte formaté (%s, %d, %f).
                                    -> Retourne 0 en cas de fin de fichier.
    
    [ECRITURE] -> Pas besoin de sécuriser, on ne remplis pas une variable vide (voir lecture).
    fputc(<caractère>, <fichier>)   : écrire un caractère.
    fputs(<chaine>, <fichier>)      : écrire une ligne de texte.
    fprintf(<fichier>, <format>,..) : écrire du texte formaté.

    [POSITIONNEMENT]
    ftell(<fichier>) : retourne position curseur dans fichier.
    fseek(<fichier>, <deplacement>, <origine>) : déplace curseur.
        -> <origine> :  SEEK_SET (debut fichier).
                        SEEK_CUR (position courante).
                        SEEK_END (fin fichier).
    rewind(<fichier>) : réinitialise la position du curseur.

    [DIVERS] 
    rename(<ancien_nom>, <nouveau_nom>)
    remove(<fichier>) -> action à faire sur un fichier fermé.
 */

 int main(void)
 {
    printf("\n------------------- LECTURE 1 --------------------\n");
    /* #1# Ouvrir un fichier.*/
    // Lecture de texte formaté (voir tuto sur lecture fichiers binaire).
    FILE *ficA = fopen("016-R.txt", "r"); // structure (struct) FILE, type de donnée.
    int lettreA = 0; // stocker et lire un tout petit caractère.
    if(ficA == NULL)
        exit(1); // quitter si l'ouverture échoue.
    /* Lire un fichier.*/
    lettreA = fgetc(ficA);
    printf("%c",lettreA);
    /* Fermer un fichier.*/
    fclose(ficA);
    printf("\n------------------- LECTURE 2 --------------------\n");
    /* #2# Lecture avec une boucle infinie -> condition d'arrêt : feof().*/
    FILE *ficB = fopen("016-R.txt", "r");
    int lettreB = 0;
    if(ficB == NULL)
        exit(1);
    while(1) // boucle infinie. Lire les lettres 1 par 1 jusqu'à la fin du fichier.
    {
        lettreB = fgetc(ficB); // première lecture.
        if(feof(ficB)) // retourne vrai si on est à la fin du fichier.
            break; // condition d'arrêt : quitter la boucle infinie si on est à la fin du fichier.
        printf("%c",lettreB);
    }
    fclose(ficB);
    printf("\n------------------- LECTURE 3 --------------------\n");
    /* #3# Lecture avec une boucle -> condition d'arrêt : fgetc() == EOF*/
    FILE *ficC = fopen("016-R.txt", "r");
    int lettreC = 0;
    if(ficC == NULL)
        exit(1);
    while((lettreC = fgetc(ficC)) != EOF) // Condition d'arrêt : le retour de la fonction fgetc est la constante EOF, End Of File (si on est à la fin du fichier ou qu'on a pas reussi à lire).
    {
        printf("%c",lettreC); // Tant que fgetc ne retourne pas EOF, on continue de lire.
    }
    fclose(ficC);
    printf("\n------------------- LECTURE 4 --------------------\n");
    /* #4# Lecture avec fgets.*/
    FILE *ficD = fopen("016-R.txt", "r");
    signed char texteA[256];
    if(ficD == NULL)
        exit(1);
    while(fgets(texteA, 255, ficD) != NULL) // fgets(texte, 255, ficD); : retourne une seule ligne.
        printf("%s",texteA);
    fclose(ficD);
    printf("\n------------------- LECTURE 5 --------------------\n");
    /* #5# Lecture avec fscanf.*/
    FILE *ficE = fopen("016-R.txt", "r");
    signed char texteB[256]; // On récupère une partie de la ligne dans un buffer et le reste dans des variables entières.
    int age = 0;
    int nombre_abonnes = 0;
    if(ficE == NULL)
        exit(1);
    fscanf(ficE, "%s %d %d", texteB, &age, &nombre_abonnes); // Indiquer l'adresse & pour ce qui n'est pas un pointeur (cf. scanf).
    printf("Nom : %s\n", texteB);
    printf("Age : %d\n", age);
    printf("Nombre abonnes : %d\n", nombre_abonnes);
    fclose(ficE);
    printf("\n------------------- ECRITURE --------------------\n");
    /* #1# Ecriture avec fputc.*/ 
    FILE *ficF = fopen("016-W.txt", "w"); // ouvrir/créer(w) un fichier en écriture.
    if(ficF == NULL)
        exit(1);
    fputc('J', ficF);
    fclose(ficF);
    /* #2# Ecriture avec fputs.*/ 
    FILE *ficG = fopen("016-W.txt", "w");
    char mot[] = "Bonjour";
    if(ficG == NULL)
        exit(1);
    fputs(mot, ficG);
    fclose(ficG);
    /* #3# Ecriture avec fprintf.*/ 
    FILE *ficH = fopen("016-W.txt", "w");
    char pseudo[] = "Magnum8760";
    int agePersonne = 32;
    int abonnes = 100000;
    if(ficH == NULL)
        exit(1);
    fprintf(ficH, "%d %s %d", age, pseudo, abonnes); // choix du formatage, de l'ordre.
    fclose(ficH);
    printf("\n------------------- POSITIONNEMENT --------------\n");
    /* #1# Afficher(ftell), positionner(fseek) et reinitialiser(rewind) un curseur.*/ 
    FILE *ficI = fopen("016-R.txt", "r");
    int position_curseur = -1;
    printf("Position : %d\n", ftell(ficI));
    fseek(ficI, 5, SEEK_SET);
    printf("Position : %d\n", ftell(ficI));
    rewind(ficI);
    printf("Position : %d\n", ftell(ficI));
    fclose(ficI);
    printf("\n------------------- DIVERS ----------------------\n");
    /* #1# Renommer un fichier (rename).*/
    FILE *ficJ = fopen("016-test.txt", "w");
    fclose(ficJ);
    rename("016-test.txt", "data.save");
    /* #2# Supprimer définitivement un fichier (remove).*/
    remove("016-test.txt"); // Ne pourront pas être récupére.
    remove("data.save");
    return 0;
 }