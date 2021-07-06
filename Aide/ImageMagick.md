# ImageMagick

[Installation sur Windows](https://imagemagick.org/script/download.php#windows)
GNU/Linux

	sudo apt-get install imagemagick

Pense bête : 
	https://www.quennec.fr/trucs-astuces/syst%C3%A8mes/gnulinux/commandes/multim%C3%A9dia/photo/imagemagick


	magick in.png win:

	magick in.png out.png

Ajouter un canal Alpha

	convert img1.png -alpha set -channel Alpha -evaluate set 90% png32:out.png
	
AVI en GIF

	convert -quiet -delay 1 in.avi  +map  out.gif
	
png en jpg

	convert source.png destination.jpg

png's en jpg's

	for f in *.png; do convert $f $(echo $f | cut -d. -f1).jpg; done
	
ou :

	mogrify -format jpg *.png

Modifier le taux de compression pendant la conversion 

	mogrify -quality 90 -format jpg *.png

jpg's en gif

	convert *.jpg anime.gif

## paramètres :

La vitesse d'animation du gif avec x en 1/100 seconde

	-delay x

Le nombre de boucle, -loop 0 (infini)

	-loop x

## Convertir et redimensionner une image

	convert in.jpg -resize 50% out.png

En indiquant une taille en pixel

	convert -resize 800x600 in.png out.jpg

En indiquant seulement la largeur en pixel

	convert -resize 800x in.png out.jpg

En indiquant seulement la hauteur en pixel

	convert -resize x600 in.png out.jpg

Sur plusieurs images

	mogrify -resize 800x600 -format jpg *.png

Créer une icone

	convert -colors 256 -resize 16x16 image.jpg icone.ico

Convertir une image en niveau de gris

	convert -type Grayscale image.jpg image.grayscale.jpg
	
Les différents niveau

	convert -list type

Une bordure transparente d'1 pixel

	convert -bordercolor Transparent -border 1x1 image.jpg image-bordure.jpg

Une bordure noire de 10 pixels

	convert -bordercolor black -border 10x10 image.jpg image-bordure.jpg

Négatif

	convert -negate image.jpg negate.jpg

Retournement verticale

	convert -flip in.jpg out.jpg

Retournement horizontale

	convert -flop in.jpg out.jpg

Pivoter à droite

	convert -rotate 90 in.jpg out.jpg
	
Pivoter à gauche

	convert -rotate -90 in.jpg out.jpg

Ajouter un texte en haut à gauche sur plusieurs images

	mogrify -fill white -pointsize 16 -annotate +10+26 'Copie Interdite' *.jpg

à propos:
* -annotate +10+26 (position verticale/horizontale)
* -pointsize 16 (dimension du texte en pixel)
* -fill white (couleur du texte)

Faire un montage avec plusieurs images

	montage -background "azure3" *.jpg montage.jpg
	
Bordure de 5 pixels entre chaque image

	montage -geometry +5+5 *.jpg montage.jpg
	
Réduit la taille de chaque image de 80% avant de les assembler

	montage -resize 20% *.jpg montage.jpg
	
Extraire une partie d'une image

	convert image.jpg -crop XxY+L+T newImage.jpg

à propos:
* X : Largeur de la nouvelle image
* Y : Hauteur de la nouvelle image
* L : Point de départ à gauche de l'image d'origine
* T : Point de départ du haut de l'image d'origine
	
	convert in.jpg -crop 500x300+20+15 out.jpg

Par exemple, dans le schéma ci-dessous, pour extraire out.png (500x300) de in.png (800x600) à partir du point L (20 px à partir du bord gauche) et du point T (15 px à partir du bord haut).

Idem sur plusieurs images

	for f in *.png; do convert $f -crop 500x300+20+15 new_$f; done

png's en pdf (+ compression)

	convert *.png -compress jpeg monDoc.pdf

pdf en png

	convert -density 500 monDoc.pdf monDoc.jpg

Liste des couleurs disponibles

	convert -list color

Afficher les informations d'une image

	identify image.jpg

Avec plus de détails

	identify -verbose image.jpg