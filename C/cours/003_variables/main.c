/**
 *      YouTube: Langage C #3 - variables
 *      Description: https://www.youtube.com/watch?v=kKeGTDyvi1o
 *      Created:  18-01-2020 | Revision: --.
 *      Compiler:  GNU Compiler - GCC.
 *      Compilation: gcc main.c -o prog
 *      Author:  Samuel Jacquet
 */

/*
    1. Les variables : 
        Elles permettent de stocker des données durant l'exécution du programme dans la mémoire vive, ram
        Elles peuvent varier
        Elles disparaissent après l'éxécution du programme (ou en cours d'éxécution, voir les fonction).
        Elles sont l'alias/l'identité d'une adresse de stockage (ex : aireDuCarre = 0xF500DA)
        Nommage : 
            Ne commencent pas par un chiffre (ok au milieu)
            Ne comportent pas de caractères spéciaux
            Ne comportent pas de caractères accentués
            Ne contiennent pas d'espace
            Ne contiennent pas de tiret "-"
            Peuvent commencer par un underscore "_" (aire_du_carre, _aireDuCarre)
        
        Attention la syntaxe est sensible à la case (exemple camelCase) : prévoir des convention afin de préserver la même syntaxe.
        
    2. Les type de variables en C :
        signed : soit positif soit négatif.
        unsigned : toujours positif.
        Occupation en mémoire : 
            pc : 8gb mémoire = 8000 mega octets = 8000000 de kilo octets
        Valeur minimum, maximum (cf. Tableau des types de variables en C).
    
    3. Les mots réservés en C :
        Noms qui ne peuvent pas servir à renommer nos variables (cf. Tableau des mots réservés en C).
*/

//  Ceci est un simple commentaire

/*  Ceci est un simple commentaire */

/* 
    Ceci est un commentaire 
    sur plusieurs lignes
*/

/*
*   Fonction principale du programme
*   @param      Aucun
*   @return     0
*/

#include <stdio.h>

int main(void)
{
       
    // Déclarer une constante (accessible seulement en lecture seule), toujours en majuscule.
    const float PI = 3.14;
    const float TVA = 20.0;

    // Variable qui va être stockée dans les registres (prior). (6,8 ou 12 Mo de cache sur les processeurs).
    register int nombre = 5;

    // Variable qui va être stockée dans la mémoire Ram, jamais dans les registres.
    volatile int autreNombre = 10;
 
    // Déclaration de variables de type entier (int) en début de fonction
    int aireDuCarre;
    int aiducarre;
    int aire_du_carre;
    int _aireDuCarre;

    // Affectation de variables
    aire_du_carre = 0;
    _aireDuCarre = 0;

    // Modification de variable
    aire_du_carre = 15;

    // Déclaration et affectation de type float
    float prixReservation = 125.99;

    // Caster, recupérer la valeur entière d'un nombre
    int nombre_entier = (int)prixReservation;

    // Déclaration et affectation de référence à la table Ascii (65 = 'A' = A) pour afficher des charactère.
    signed char char_01 = 65; // 
    signed char char_02 = 'A';

    // Afficher les variables avec des drapeaux

    /*
        %d : nombre entier (int)
        %f : nombre flottant (float)
        %c : caractère (char)
        %s : châine de caractères (texte)
    */
    printf("Aire : %d\n", aire_du_carre);
    printf("Prix : %d euros | Prix en décimale : %.3f euros\n", nombre_entier, prixReservation);
    printf("Valeur de PI : %.2f\n", PI);

    return 0;
}