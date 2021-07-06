/**
 * YouTube: https://www.youtube.com/watch?v=tDE4FNCcP0k
 * Description: Langage C #13 - chaînes de caractères
 * Created: 22-02-20 | --.
 * Compiler: GNU Compiler - GCC.
 * Compilation: gcc main.c -o prog
 * Author: Samuel Jacquet
 */

 #include <stdio.h>
 #include <string.h> // strcpy().

 int main(void)
 {
    
    //Caractère et chaine.
    signed char lettre = 'A'; //Un caractère.
    printf("lettre : %c\n",lettre);
    signed char chaine[] = "A"; //Une chaine de 1 caractère suivi de '\0'.
    printf("chaine : %s\n",chaine);

    /*
        #1# Chaine de caractères = tableau de caractères.
        charactere = element de type char ou signed de char.
        '/0' = element de fin de chaine.
        %s = afficher une chaine.
        %c = afficher un caractère.
        signed = element négatif ou positiif.
    */
    
    signed char motA[] = "Bonjour tout le monde !"; // Ici le compilateur va calculer le nombre de caractères nécessaires puisqu'on ne le précise pas. 
    //Après déclaration/initialisation, on ne pourra pas réinitialiser la variable, modifier la taille du tableau sans allocation dynamique.
    printf("motA : %s\n",motA); // Pas besoin de &, c'est comme un tableau.
    signed char motB[7] = "Samuel"; // Ici, on met la taille+1 entre crochet. Une chaine se termine par un symbole de fin, '\0'.
    printf("motB : %s\n",motB); // ['S']['a']['m']['u']['e']['l']['\0'] = mot[7] et non mot[6].
    signed char motC[] = {'S','a','m','u','e','l','\0'}; // tableau de 7 cases avec 6 caractères et '/0'.
    printf("motC : %s\n",motC); 
    signed char motD[7];
    motD[0] = 'S'; // stocker le 'S' dans le mot 0.
    motD[1] = 'a';
    motD[2] = 'm';
    motD[3] = 'u';
    motD[4] = 'e';
    motD[5] = 'l';
    motD[6] = '\0'; // ajouter la caractère '\0', caractère de fin de chaine.
    printf("motD : %s\n",motD); 

    /* #2# Saisie de nom d'utilisateur (non sécurisé).*/

    signed char prenom[256]; // réserver un espace de 256 caractères, c'est un Buffer, un espace tampon.
    printf("1. Comment tu t'appelles ? ");
    //scanf("%s",prenom); // scanf = méthode non sécurisée.
    printf("Ton prenom est %s.\n",prenom);
    printf("2. Comment tu t'appelles ? ");
    //scanf("%s",prenom); // dépasser le buffer = risque de plantage, de compotement inentendu.
    printf("Ton prenom devient %s.\n",prenom); // renommer une chaine = risque de plantage, de compotement inentendu.

    /* #3# fonctions des chaînes.*/

    /* -1- strcpy(<destination>,<source>) : copie une chaine dans une autre.*/   
    char prenomB[25] = "Samuel";
    char stockage[256];
    printf("Ton prenom de base est : %s.\n",prenomB);
    printf("Changer ton prenom ? ");
    //scanf("%s",stockage);
    strcpy(prenomB, stockage); // Par sécurité la seconde chaine ne devrait pas dépasser la premiere.
    printf("Ton nouveau prenom : %s\n",prenomB);

    char prenomC[25] = "Toto";
    printf("Ton prenom de base est : %s.\n",prenomC);
    strcpy(prenomC, "Samuel"); // idem avec une chaîne en dur.
    printf("Ton nouveau prenom : %s.\n",prenomC);
    
    /* -2- strlen() : longueur d'une chaine (sans caractère de fin de chaîne).*/
    char texteA[] = "Toto";
    printf("%s\n",texteA);
    printf("Taille du texte : %d\n",strlen(texteA)); // strlen ne compte pas le caractère de fin (il compte pour la mémoire du pc).
    
    /* -3- strcmp() : comparer deux chaines (lexicographiquement, au niveau des mots du dictionnaire).*/
    char mot1[] = "Samuel";
    char mot2[] = "Bateau";
    int test = strcmp(mot1, mot2); // retourne 0 si deux deux chaines sont lexicographiquement égales (Utilisation : ranger les mots dans l'ordre du dictionnaire). 
    if(test == 0)
        printf("Les deux mots sont les memes.\n");
    else if(test < 0)
        printf("%s < %s\n", mot1, mot2);
    else if(test > 0)
        printf("%s > %s\n", mot1, mot2); // La lettre S est après B de bateau dans le dictionnaire.

    /* -4- strcat() : concatener deux chaines (fusionner).*/
    char motE[] = "Boule et ";
    char motF[] = "Bill";
    printf("%s\n",strcat(motE,motF));

    /* -5- strstr() : chercher une chaine dans une autre.*/
    char texteB[] = "Boul et Bill";
    char motAtrouver[] = "Bill";
    if(strstr(texteB,motAtrouver) != NULL) // retourne le pointeur vers la premiere occurence.
        printf("Texte trouve !\n");

    /* -6- strchr() : chercher la premiere occurence du caractère.*/
    char texteC[] = "Ying-Yang";
    char characterAtrouver = '-';
    char *resultat = strchr(texteC,characterAtrouver); // retourne le texte à partir de la premiere occurence.
    printf("%s\n", resultat);

    /* -6- sprintf() : écrire dans une chaine (stockage dans une chaîne).*/
    char texteD[256];
    sprintf(texteD, "Samuel", 5); // écrit 5 caractères dans texteD.
    printf("texteD : %s\n",texteD);
    
    return 0;
 }