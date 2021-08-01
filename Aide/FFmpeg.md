# [AIDE - convertir des fichiers média (FFmpeg)](https://www.youtube.com/watch?v=gIZzxPgilCA)
@https://github.com/jasonchampagne/FormationVideo/tree/master/Ressources/Aide

## Installation

	https://ffmpeg.org/download.html
	https://github.com/BtbN/FFmpeg-Builds/releases

Variables d'environnement PATH

	C:\...\ffmpeg\bin

Conversion de fichier audio ou video (ré-encodage) :

	ffmpeg -i musique.wav musique.mp3
	ffmpeg -i video.avi video.mp4

Changer de format (sans ré-encodage) :

	ffmpeg -i video.mp4 -c copy video.avi
	ffmpeg -i olg.mp4 new.mp4

A noter que ffmpeg -i olg.mp4 new.mp4 réduit la taille du fichier.

Extraire la partie audio d'une vidéo (ré-encodage) :

	ffmpef -i video.mp4 audio.mp3
	ffmpef -i video.mp4 audio.ogg

Couper le son d'une vidéo (sans ré-encodage) :

	ffmpeg -i video.mp4 -vcodec copy -an out.mp4

Extraire une partie de fichier audio ou vidéo :

	ffmpeg -i video.mp4 -ss 00:00:10 -c copy out.mp4 

/!\ si on ne met pas -c copy, on va faire un ré-encodage inutile. On ne veux pas changer la qualité mais extraire une copie.

	ffmpeg -i video.mp4 -ss 00:00:10 -to 00:00:15 -c copy out.mp4 

Scinder un fichier en 2 parties (sans ré-encodage) :

	ffmpeg -i video.mp4 -t 00:00:10 -c copy part1.mp4 -ss 00:00:10 -c copy part2.mp4

Fusionner plusieurs fichiers en un seul (sans ré-encodage) :

	créer un fichier texte info.txt :
		file 'navire1.mp4'
		file 'navire2.mp4' 
	ffmpeg -f concat -i info.txt -c copy out.mp4 

/!\ méthode sans ré encodage avec perte de frames, de partie audio d'où pas top. ==> ré-encoder les fichiers avant la concaténation pour fussionner les fichiers avec les mêmes propriétés.

>-----------------------------------------------

## Liste arguments \<valeur\>

* i <file\> : input, le fichier à prendre.
* c copy <file\> : copie de tout les flux sans ré-encodage.
* vcodec copy <file\> : copie le flux vidéo sans ré-encodage.
* an <file\> : ignorer la partie audio.
* vn <file\> : ignorer la partie vidéo.
* sn <file\> : ignorer les sous-titres.
* ss <hh:mm:ss\> : start string, à partir d'où on coupe le média.
* to <hh:mm:ss\> : jusqu'à.
* t <hh:mm:ss\> : temps que dure notre part1.
* f <command\> : utiliser une autre commande.

## Commands
* ffmpeg
* concat (fussionner les fichiers)

## Redimentionner

	ffmpeg -i pic-large.jpg -vf scale=320:-1 pic-little.jpg
	ffmpeg -i pic-large.jpg -vf scale=320:240 pic-little.jpg
	
	ffmpeg -i img2.png -vf scale=15:-1 img22.png

src: https://trac.ffmpeg.org/wiki/Scaling

## Alpha mask

	ffmpeg -i in.png -filter_complex "color=white [alpha]" out.png  
	ffmpeg -i in.png -filter_complex "color=black; alphaextract[alpha]" out.png  
	ffmpeg -i in.png -filter_complex "color=white" alphaextract[alpha] out.png  
	ffplay -i in.png -vf alphaextract out.png  

## monochrome

ffmpeg -i couleur.png -vf hue=s=0 -c:a copy monochrome.png

## contraste

ffmpeg -i input.png -vf curves=preset=increase_contrast -c:a copy output.png