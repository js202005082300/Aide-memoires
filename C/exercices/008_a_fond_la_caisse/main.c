/*
EXERCICE C #8
[Révision : jusqu'à la séance 14 - structures et types]

1> Créer un type de Voiture qui possède les informations suivantes :
    - Son nom de marque
    - Son nom de modèle
    - Sa réserve de gazole/essence (en pourcentage)
    - Sa vitesse de déplacement maximum (en Km/h)
    - Son état (fonctionnel ou en panne)

2> Définir une fonction pour créer un Véhicule, qui nécessite d'indiquer :
    - Sa marque, son modèle et sa vitesse maximum.
    - Pour la réserve, vous choisirez une valeur arbitraire (par défaut)
    - Pour l'état, le Véhicule sera par défaut "fonctionnel".

3> Définir une fonction afficher les informations du Véhicule

INDICATION :
    - L'état du véhicule sera à définir via une énumération.
    - Les données textuelles seront stockées dans une chaîne de taille max. de 256 caractères.


[8. À fond la caisse](https://www.youtube.com/watch?v=cY79sEvkEQc)
*/

#include <stdio.h>
#include <string.h>

typedef enum { BROKEN_DOWN, FUNCTIONNAL } VEHICLE_STATE;

typedef struct Vehicle
{
    char brand[256];
    char model[256];
    int patrolTank;
    int maximumSpeed;
    VEHICLE_STATE state;
}
Vehicle;

Vehicle vehicle_create(char *brand, char *model, int speed);
void vehicle_info(Vehicle v);

int main(void)
{
    Vehicle veh;

    veh = vehicle_create("Mazda", "RX8", 185);
    vehicle_info(veh);

    return 0;
}

Vehicle vehicle_create(char *brand, char *model, int speed)
{
    Vehicle v;

    strcpy(v.brand, brand);
    strcpy(v.model, model);
    v.patrolTank = 100;
    v.maximumSpeed = speed;
    v.state = BROKEN_DOWN;

    return v;
}

void vehicle_info(Vehicle v)
{
    printf("Marque : %s\nModele : %s\nReserve : %d%%\nVitesse max.: %dKm/h\n", v.brand, v.model, v.patrolTank, v.maximumSpeed);

    if(v.state == FUNCTIONNAL)
        printf("EN ETAT DE FONCTIONNEMENT !\n");
    else
        printf("EN PANNE !\n");
}