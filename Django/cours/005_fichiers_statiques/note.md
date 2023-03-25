# [5. Fichiers statiques](https://www.youtube.com/watch?v=_jfryi6pEOM)

+ [Introduction](#Introduction)
+ [Petits rappels](#Petits-rappels)
+ [Qu'est-ce qu'un fichier statique ?](#Qu-est-ce-qu-un-fichier-statique)
+ [Fichiers statiques pour une application](#Fichiers-statiques-pour-une-application)       
+ [Fichiers statiques du projet global](#Fichiers-statiques-du-projet-global)
+ [Conclusion](#Conclusion)

>

## Introduction

Comment se servir de fichiers statiques ?

Besoin d'être mis en place.

## Petits rappels

Voici une vue simple avec notre page visible : mangalib/index.html

+ views.py
```py
from django.shortcuts import render
from django.http import HttpResponse
from django.template import loader

def index(request):
    context = {"message": "Hello World !"}
    template = loader.get_template("mangalib/index.html")

    return HttpResponse(template.render(context, request))
```

Notre gabarit soit un fichier HTML.

+ index.html
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Mes mangas</title>
</head>
<body>
    <h1>Bienvenue sur MangaLib</h1>
    <p>{{ message }}</p>
</body>
</html>
```

## Qu est-ce qu un fichier statique

A propos de l'usage de fichiers statiques soit une feuille de style CSS. Ca pourrait être une image, une vidéo ou un script JavaScript.

## Fichiers statiques pour une application

On crèe le répertoire `static`
+ .\FV\mangalib\static\mangalib\css\main.css
```css
body
{
    background-color:#eee;
    color:#3d60cb;
    margin:auto;
    width:800px;
}
```

Au début du gabarit, on va permettre le chargement de fichiers statiques avec `<link rel="stylesheet" href="">` qui as pour référence le fichier static. L'utilisation de fichiers static est une application de Django :
+ .\FV\FV\settings.py => `'django.contrib.staticfiles',`

+ .\FV\mangalib\templates\mangalib\index.html
```html
{% load static %}
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Mes mangas</title>
    <link rel="stylesheet" href="{% static 'mangalib/css/main.css' %}">
</head>
<body>
    <h1>Bienvenue sur MangaLib</h1>
    <p>{{ message }}</p>
</body>
</html>
```

Relancer le serveur pour prendre en compte le fichier static.

+ .\MyDjango\FV
```ps1
> python .\manage.py runserver 
```

## Fichiers statiques du projet global

Cette fois, on crée notre fichier static ici :

+ 

Configurer une liste de répertoire de fichier static :
+ .\FV\FV\settings.py => 

9.30

## Conclusion



Mes critères de recherches :
Budget : 10 000 à 20 000 euros
Carnet d'entretien qui est à jour avec un suivi régulier
Marques : Skoda, Volkswagen, Audi
Modèles : Skoda Fabia, Volkswagen Polo, Volkswagen Golf, Audi A1
Couleur de carrosserie préférée : noir, gris, blanc ou orange
Type de carrosserie : compacte
Carburant : essence pour les petits trajets
Boîte de vitesses : manuelle
Kilométrage : max 15 000 km par an
Assurance : max 10 000 km par an
Années : max 3 ans
Faible émission en CO2
Euro 6
Faible consommation
Puissance : Max 100 ch
Equipements avec impact positif sur l'environnement et la sécurité : Système de récupération d'énergie de freinage, Pneus 4 saisons, start-stop, Phares LED, régulateur de vitesse adaptatif, Climatisation automatique, Système d'assistance à la conduite, système de navigation en temps réel, Affichage tête haute, Système de surveillance de la pression des pneus, Système de freinage d'urgence, système de détection de fatigue, système de maintien de voie, Système d'aide au stationnement, Caméra de recul, Affichage tête haute, Système de surveillance de la pression des pneus.
Autres : Android Auto ou CarPlay, Attache remorque, Jantes en alliage, Sièges chauffants, rétrovisseurs rabatables.


Quel est la meilleur voiture entre ces 3 modèles :

VOLKSWAGEN GOLF comfortline (16 990 €)
Carrosserie : BERLINE
CO2 NEDC : 110
Couleur : BLANC
Consommation sur route : 0 / 100 KM
Certificat Critair : NIVEAU 1
Euro Norm : EURO 6
Portes : 5 PORTES
Carburant : ESSENCE
Boîte de vitesse : MANUELLE
Puissance Fiscale : 6 CV
Puissance Réelle : 110 CH DIN
Modèle : GOLF
Version : COMFORTLINE
Kilométrage : 59 803 KM
Marque : VOLKSWAGEN
Prix TTC : 16 990 €
Type : OCCASION
Mise en circulation : 22/01/2020
Année : 2020
Carnet d’entretien : COMPLET
Référence véhicule : FB81581
Date de disponibilité : DISPONIBLE TOUT DE SUITE
Stockage : 5 AWANS 4340

Volkswagen POLO APP-CONNECT*CLIM*CAPTEURS AV/AR++++ (18 990 €)
Carrosserie : CITADINE
CO2 NEDC : 104
CO2 WLTP : 125
Couleur : NOIR
Consommation sur route : 0 / 100 KM
Certificat Critair : NIVEAU 1
Euro Norm : EURO 6
Portes : 5 PORTES
Carburant : ESSENCE
Boîte de vitesse : MANUELLE
Puissance Fiscale : 6 CV
Puissance Réelle : 80 CH DIN
Modèle : POLO
Version : APP-CONNECT*CLIM*CAPTEURS AV/AR++++
Kilométrage : 24 946 KM
Marque : VOLKSWAGEN
Prix TTC : 18 990 €
Type : OCCASION
Mise en circulation : 11/02/2021
Année : 2021
Carnet d’entretien : COMPLET
Référence véhicule : FB79214
Date de disponibilité : DISPONIBLE TOUT DE SUITE
Stockage : 16 VISÉ 4600

Volkswagen POLO Life 1.0TSi 95cv - Bluetooth/airco/cockpit digital (19 990 €)
Carrosserie : CITADINE
CO2 NEDC : 106
CO2 WLTP : 118
Couleur : GRIS
Consommation sur route : 0 / 100 KM
Certificat Critair : NIVEAU 1
Euro Norm : EURO 6
Portes : 5 PORTES
Carburant : ESSENCE
Boîte de vitesse : MANUELLE
Puissance Fiscale : 6 CV
Puissance Réelle : 95 CH DIN
Modèle : POLO
Version : LIFE 1.0TSI 95CV - BLUETOOTH/AIRCO/COCKPIT DIGITAL
Kilométrage : 7 422 KM
Marque : VOLKSWAGEN
Prix TTC : 19 990 €
Type : OCCASION
Mise en circulation : 13/07/2022
Année : 2022
Carnet d’entretien : COMPLET
Référence véhicule : FB77100
Date de disponibilité : DISPONIBLE TOUT DE SUITE
Stockage : 23 HERVE 4650