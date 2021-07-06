/**
 * YouTube: https://www.youtube.com/watch?v=1Kmq-9knIUY
 * Description: Langage C #14 - structures et types
 * Created: 22-02-20 | --.
 * Compiler: GNU Compiler - GCC.
 * Compilation: gcc main.c -o prog
 * Author: Samuel Jacquet
 */

#include <stdio.h>
#include <string.h> // Pour passer par une fonction de chaîne.

/* 
    structure : 
        rassemble un ensemble de données. 
        Accès plus rapide (lecture, modification, etc.).
        définis dans les fichiers d'en-tête avec les prototypes de fonctions.
    typedef : définis comme type ce qui suit. Permet de transformer une structure et une énumération en type.
    énumération : 
        énumérer un type de donnée, une structure (regroupement) qui fait appel à des constantes (possibilité de valeurs).
        énumerer une liste de valeur possible pour une étiquette.
    union : 
        regroupement de plusieurs types de données (idem aux structures) mais qui permettent d'accéder à la même zone de la mémoire.
        une seule enumération, case en mémoire qui va être reservée.
        utilisé souvent dans une structure.
        Applications : éviter de creer deux structures identiques dans un jeux video alors que les allies et les ennemis ont les mêmes paramètres (pseudo, PV, Vitesse, types d'armes, etc.). Accéder à la même zone mémoire qu'il s'agisse d'un allie ou d'un ennemi.

*/
/********************************************************************/
struct Player // Création d'une structure Player.
{
    signed char username[256]; // champ de structure (variable, pointeur, tableau, autre structure).
    int hp;
    int mp;
};

typedef struct Player Player; // Remplacer "struct Player" par "Player".
// Player devient un type de variable comme int, float dans le programme.

/********************************************************************/

typedef struct str_player 
{
    signed char username[256];
    int hp;
    int mp;
}typ_player; // création d'un type.

/********************************************************************/

void create_player(typ_player *p) // toute la structure est un pointeur.
{
    strcpy((*p).username, "Naoki"); // (*nom_pointeur).champ_a_modifier : modifier un pointeur.
    (*p).hp = 100; // syntaxe pour pointeur 1 : (*pointeur).un_champ = valeur;
    p->mp = 80; // syntaxe pour pointeur 2 : pointeur->un_champ = valeur;
}

void create_player2(typ_player p) // Sans pointeur, toutes les variables sont détruites à la fin de la fonction.
{
    strcpy(p.username, "Naoki");
    p.hp = 100;
    p.mp = 80;
}

/********************************************************************/

/* Déclaration de type Booleen.*/
enum Booleen // Booleen est l'étiquette de notre enumération.
{
    false, // Le premier champ vaut 0.
    true // Le second champ vaut 1.
};

typedef enum enum_Booleen
{
    FALSE,// En informatique, quand c'est faux, c'est égal à 0.
    TRUE// 1
}typ_Booleen;

typedef enum enum_autre
{
    NON,
    OUI
}typ_autre;

typedef enum enum_MarqueVoiture
{
    PEUGEOT, //0
    RENAULT, //1
    TOYOTA, //2
    MAZDA //3
} typ_Marque;

typedef enum MarqueVoiture
{
    PEUGEOT2 = 10, // attribuer des valeur à des constantes énumérées, autre que les valeurs par défaut (0,1,2...).
    RENAULT2 = 20,
    TOYOTA2 = 30,
    MAZDA2 = 40
} Marque;

/********************************************************************/

union Nombre // Une nombre peut être un :
{
    int entier;
    float decimal;
};


/********************************************************************/

int main(void)
{
    /* #1# Initialiser un joueur appelé p1 (var).*/
    struct Player p1 = {"Samuel",120,80};
    
    /* #2# Afficher une structure.*/
    printf("Nom du joueur 1 : %s\n",p1.username);
    printf("PV : %d | MP : %d\n",p1.hp,p1.mp);
    
    /* #3# Créer un type de variable.*/
    /* -1- typedef séparé de la structure.*/
    Player p2 = {"Jessica",120,80}; // initialisation sans struct avec typedef.
    printf("Nom du joueur 2 : %s\n",p2.username);
    printf("PV : %d | MP : %d\n",p2.hp,p2.mp);
    /* -2- typedef rataché à la structure.*/
    typ_player p3 = {"Arnold",120,80}; 
    printf("Nom du joueur 3 : %s\n",p3.username);
    printf("PV : %d | MP : %d\n",p3.hp,p3.mp);
    
    /* #4# Accéder une chaine de character.*/
    /* -1- Mettre en dur un nom de variable à sa création.*/
    Player p4 = {"Casablanca"};
    printf("Nom du joueur 4 : %s\n",p4.username);
    printf("PV : %d | MP : %d\n",p4.hp,p4.mp);
    // p1.username = "Naoki"; --> On ne peux pas réinitialiser/modifier une chaine de char déjà créer.
    /* -2- Passer par une fonction de chaine.*/
    strcpy(p2.username,"Naoki"); // Dans p2.username qui contient jusqu'à 256 char possible, on met Naoki.
    p2.hp -= 50; // accès facile pour tout ce qui n'est pas une chaine.
    printf("Nom du joueur 2 : %s\n",p2.username);
    printf("PV : %d | MP : %d\n",p2.hp,p2.mp);
    
    /* #5# Initialiser une structure par une fonction (souvent).*/
    typ_player p5 = {"", 0, 0};
    create_player(&p5); // Passage par adresse pour modifier l'orginal.
    printf("Nom du joueur 5 : %s\n",p5.username);
    printf("PV : %d | MP : %d\n",p5.hp,p5.mp);
    typ_player p6 = {"", 0, 0};
    create_player2(p6); // Sans pointeur, les modifications de valeurs sont détruites.
    printf("Nom du joueur 6 : %s\n",p6.username);
    printf("PV : %d | MP : %d\n",p6.hp,p6.mp);
    
    /* #6# Créer un tableau de player.*/
    typ_player p7[3] = {{"",0,0},{"",0,0},{"",0,0}};
    //typ_player p7[3];
    //p7[0] = {"", 0, 0}; --> On ne peux pas réinitialiser/modifier une chaine de char déjà créer.
    create_player(&p7[0]);
    printf("Nom du joueur 7 : %s\n",p7->username);
    printf("PV : %d | MP : %d\n",p7->hp,p7->mp);
    
    /* #7# Créer un tableau de player local.*/
    typ_player tableau_joueurs[5];
    tableau_joueurs[0].hp = 150;
    tableau_joueurs[1].hp = 70;

    /* #8# Créer une énumération.*/
    enum Booleen jeu_lanceA = true;
    typ_Booleen jeu_lanceB = FALSE;
    typ_autre jeu_lanceC = OUI;

    jeu_lanceA = 0;
    jeu_lanceB = TRUE;
    jeu_lanceC = NON;

    if(jeu_lanceA == OUI) // développement plus compréhensible grace à enum et ses valeurs en français.
    {}

    typ_Marque v1 = TOYOTA;

    /* #9# Créer une union.*/
    union Nombre nb1; // le même emplacement mémoire que ce soit un entier OU un décimal en réservant la capacité mémoire pour int ou float.
    // -> éviter de reserver la taille d'un float si on ne met qu'un int (éviter 10 places en mémoire alors que besoin que de 2).
    nb1.entier = 3; // Valeur si nb1 est un entier.
    nb1.decimal = 3.14; // Valeur si nb2 est un décimal.

    return 0;
}