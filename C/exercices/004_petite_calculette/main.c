/*
EXERCICE C #4
[Révision : jusqu'à la programmation modulaire]
> Ecrire un programme de calculatrice simple pour 2 nombres :
    - afficher un menu principal proposant les 4 types de calcul (+, -, * et /) ou de quitter.
    - une fois le calcul choisi, demander la saisie de 2 nombres et afficher le résultat.
    - rediriger sur le menu principal.

> Indications :
    - utiliser au maximum des fonctions (pour optimiser votre code et éviter les répétitions).
    - vérifier que la saisie au menu est correct, sinon redemander une saisie.
    - vérifier que les nombres saisis sont compris entre -1000 et 1000.
    - compiler avec la commande --> gcc *.c -o prog (donnera un exécutable prog ou prog.exe) 

[4. P'tite calculette](https://www.youtube.com/watch?v=CTuqMr6F59Q)
*/
#include "numbers.h"
#include <stdio.h>

int main(void)
{
    app_calc();
    return 0;
}