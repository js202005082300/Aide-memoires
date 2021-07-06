/*
EXERCICE C #7
[Révision : jusqu'à la séance 13 - chaînes de caractères]

1> Ecrire une fonction qui compte le nombre de caractères d'une chaîne (comme strlen de <string.h>)
2> Ecrire une fonction qui compte le nombre d'occurences d'un caractère (ex : 'a') dans une chaîne

Indications :
    - pour la partie n°2, vous utiliserez la fonction écrite en partie n°1.
    - pensez à mettre vos variables en lecture seule constantes (ex : const int myData = 10).

[7. Tout compte fait](https://www.youtube.com/watch?v=W1cNlw2H2xg)
*/
#include <stdio.h>

/* Vos fonctions */
int str_length(const char *str);
int count_occurences_of(const char *str, const char c);

int main(void)
{
    char chaine[] = "Bonjour tout le monde, je suis en train de faire des exercices pour reviser les chaines de caracteres";

    //Taille de chaîne
    printf("Taille de chaine : %d\n", str_length(chaine));

    //Nombre d'occurences de 'e'
    printf("Nombre de 'e' dans chaine : %d\n", count_occurences_of(chaine, 'e'));

    return 0;
}

int str_length(const char *str)
{
    int i = 0;

    while(str[i] != '\0')
        ++i;
    
    return i;
}

int count_occurences_of(const char *str, const char c)
{
    int occurences = 0;

    for(int i = 0 ; i < str_length(str) ; ++i)
        if(str[i] == c)
            occurences++;
    
    return occurences;
}