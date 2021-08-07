#coding:utf-8

# [5. Damn geoshape !](https://www.youtube.com/watch?v=mJwjyE5HSEA)

"""
EXERCICES PYTHON #5
[Révision : fonctions, modularité]

> Concevoir un module de calcul de périmètre, aire et volume de plusieurs formes géométriques :
    - votre module sera un fichier nommé "geoshape.py"
    - vous devez définir 6 fonctions -> périmètre d'un carré
                                        aire d'un carré
                                        volume d'un cube
                                        périmètre d'un cercle
                                        aire d'un cercle
                                        volume d'une sphère.
    - prévoir l'exécution du module en indépendant qui effectuera le test de toutes vos fonctions (if __name__ == '__main__':).
    - la valeur de Pi sera définir dans le module avec pour valeur 3.14 (pour plus de facilité).
    - les valeurs etrésultats seront en flottant - 2 chiffres après la virgule -> print("%.2f" % result)

> Idées d'évolution :
    - vous pourrez ajouter de nombreuses autres fonctions à votre module qui pourra prendre en charge une multitude d'autres formes (rectangle, triangle, losange, pyramide, cône, cylindre, ...)
    - prendre en charge une certaine fourchette de valeurs seulement (pour le côté d'un carré, le rayon d'un cercle, ...)
    - pour celles et ceux ayant abordé tkinter/pygame, on pourra élaborer un programme 2D pour apporter un côté plus visuel.
"""
import geoshape

#------------------------------------------------------------------
# Calculs pour le carré/cube
#------------------------------------------------------------------
square_length = 2

area1 = geoshape.square_area(square_length)
print("L'aire du carré de côté {} est de {}m²".format(square_length, area1))

#------------------------------------------------------------------
# Calculs pour le cercle/la sphère
#------------------------------------------------------------------
circle_radius = 15

area2 = geoshape.circle_area(circle_radius)
print("L'aire du cercle de rayon {} est de {}m²".format(circle_radius, area2))