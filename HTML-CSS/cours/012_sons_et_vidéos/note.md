# [12. Sons et vidéos](https://www.youtube.com/watch?v=XSJj1uKF1RU)
21-01-21

Bonjour à tous bienvenue sur la formation html et css, nous attaquons dans cette vidéo 12 l'utilisation de sons et de vidéos.

La dernière fois, on avait vu un petit peu comment que ça se passait au niveau des images.

Alors c'est des vidéos assez longues parce que j'avais beaucoup de choses à vous présenter, là cette vidéo pour le coup va être assez courte parce qu'il n'y aura pas énormément de balises à voir pour pouvoir utiliser des sons, écouter de la musique, afficher des sons ou carrément afficher un lecteur vidéo pour pouvoir visionner évidemment un contenu média de votre choix.

Je vais vous expliquer tout ça dans le détail, on va regarder comment ça se passe html5 alors au niveau de l'audio, déjà il va falloir prendre en compte certains formats puisque savez qu'il existe plusieurs navigateurs internet d'accord donc certains ont des formats qui sont bien compatibles, d'autres non donc grosso modo pour l'audio vous allez avoir 3 formats possibles.

Vous allez avoir le mp3 donc lui il est compatible partout ça c'est l'avantage donc évidemment utiliser du mp3 puisque comme ça il sera fonctionnel sur tout les navigateurs donc ça c'est plutôt sympa.

On va avoir le format wav qui lui est compatible sauf IE donc internet explorer et vous allez avoir le format ogg qui lui est compatible partout sauf internet explorer et safari.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3	(compatible partout)
				wav	(compatible sauf IE)
				ogg (compatible sauf IE et Safari)
	-->
	<h1>Sons et vidéos</h1>
	
</body>
</html>
```
Voilà je vous donne les trois formats possibles parce qu'ils sont évidemment à connaître mais si vous voulez privilégier la compatibilité préféré opter pour le format mp3 qui sera lisible pour tout le monde donc ça c'est la première partie pour la vidéo dont on va parler évidemment après.

Vous avez le mp4 donc lui qui est compatible partout, ça c'est un gros avantage. On a également le webm, le webm qui lui n'est pas compatible partout sauf IE et safari donc c'est un peu toujours les mêmes dans l'histoire et le ogg en vidéo pareil compatible sauf IE et safari aussi.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>
	
</body>
</html>
```
Voilà il faut savoir qu'au niveau audio et vidéo en html c'était assez galère à l'époque parce qu'à l'époque en fait il n'y avait aucun format qui fonctionnait partout donc il fallait avoir plusieurs formats différents d'audios et de vidéos pour être sûr que ce soit lisible sur tous les navigateurs ce qui était assez casse pieds parce que vous deviez stocker sur votre serveur et bien plusieurs formats différents de vidéos et d'audios ce qui prend évidemment beaucoup plus de place, si vous avez plusieurs versions donc là au moins l'avantage c'est que maintenant avec le mp3 en audio ce sera lisible partout et avec le mp4 en vidéo ce sera lisible partout également.

Ca fait quand même gagner pas mal de places après plus tard quand vous allez héberger vos sites en ligne.

C'est quelque chose à prendre en compte à ce niveau là je vous recommande pour l'audio le mp3 et pour la vidéo le mp4 pour être tranquille à ce niveau là.

On va commencer au niveau de l'audio donc moi j'ai récupéré des fichiers tout simplement que je récupèré et voilà une vidéo et puis un son, histoire de montrer au niveau des tests ici ce qu'on va faire dans la vidéo.

Pour l'audio et bien la balise est très simple c'est la balise `<audio>` donc là pas de surprise donc c'est une balise qui se ferme ici et qui va prendre un certain nombre de paramètres.
```html
	<audio></audio>
```
Alors déjà à l'intérieur par défaut on prend l'habitude de mettre un petit message par exemple votre navigateur parce que si la personne il utilise une trop vieilles versions des navigateurs ça pourrait ne pas être compatibles donc on va mettre par exemple "Votre navigateur ne supporte pas l'audio" admettons ce genre de choses.
```html
	<audio>
		Votre navigateur ne supporte pas l'audio
	</audio>
```
Vous mettez un message que vous voulez peu importe donc si vous voulez une petite indication en plus et ici `<audio ...>` à l'intérieur on va pouvoir avoir des attributs pour audio et il y en a plusieurs.

Un attribut déjà qui va être intéressant évidemment c'est un attribut pour lire le fichier donc vous avez deux choix possibles comme on a vu un petit peu justement au niveau des images soit vous avez l'attribut 'src' d'accord, vous allez pouvoir mettre votre fichier donc pareil au niveau du système de liens comme ce qu'on a vu dans les vidéos précédentes donc moi là il est près de mon fichier html, je mets directement song.mp3
```html
	<audio src="song.mp3">
		Votre navigateur ne supporte pas l'audio
	</audio>
```
Voilà ça c'est la première possibilité, la deuxième c'est celle que vous avez déjà vu avec les images c'est de ne pas mettre 'src' et de mettre ça dans une balise `<source>` en faisant ceci, et là carrément de rajouter le type mime tant qu'à faire qui pour le coup bas est "audio/mpeg".
```html
	<audio>
		<source src="song.mp3" type="audio/mpeg">
		Votre navigateur ne supporte pas l'audio
	</audio>
```
"audio/mpeg" donc pour le format mp3, c'est "audio/wav" si vous voulez le format wav et "audio/ogg" pour avoir le format ogg d'accord donc ça c'est par rapport au type mine.

Donc c'est deux possibilités d'accords qui existe pour les deux, on va actualiser pour voir.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>

	<audio>
		<source src="song.mp3" type="audio/mpeg">
		Votre navigateur ne supporte pas l'audio
	</audio>
</body>
</html>
```
```txt
	Sons et vidéos
```
Là on ne voit pas de changements à ce niveau là on va appliquer un certain nombre d'attributs, les attributs il en a plusieurs ok y'a vraiment plusieurs attributs, celui de base qui est quand même à mettre partout c'est l'attribut 'controls' chose comme ceci.
```html
	<audio controls>
		<source src="song.mp3" type="audio/mpeg">
		Votre navigateur ne supporte pas l'audio
	</audio>
```
Ce sont des attributs qui fonctionnent comme des bouléen d'accord vrai ou faux donc il suffit simplement de les mettre comme ça juste de les écrire 'controls' pour qu'ils soient activées et si vous ne voulez pas les activer, vous ne les mettez pas d'accord carrément comme ça au moins c'est plus efficace.

Donc là on va actualiser et là maintenant que nous avons les contrôles en place, on peut évidemment commander le son.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>

	<audio controls>
		<source src="song.mp3" type="audio/mpeg">
		Votre navigateur ne supporte pas l'audio
	</audio>
</body>
</html>
```
```txt
	Sons et vidéos
	> 0:00 / 3:35 O--------- <) ---O
```
Donc là je peux le lire d'accord, donc on peut avancer sur le fichier pas de souci et on peut gérer le volume. On peut passer en Mute.

Voilà pour cette partir donc ça c'est vraiment le minimum d'accord 'controls' etc.

Je rappelle si vous voulez pas le mettre dans `<source>` vous pouvez juste faire ça.
```html
	<audio src="song.mp3" controls>
		Votre navigateur ne supporte pas l'audio
	</audio>
```
Il n'y a pas d'ordre, on peut très bien mettre les petits attributs là avant et le 'src' à la fin c'est vous qui voyez.
```html
	<audio controls src="song.mp3">
		Votre navigateur ne supporte pas l'audio
	</audio>
```
Moi par habitude je le met en général tout au début, en premier attribut et vous faites que ça.
```html
	<audio src="song.mp3" controls>
		Votre navigateur ne supporte pas l'audio
	</audio>
```
Si vous voulez, il n'y a pas de problème donc 'controls' c'est vraiment la base, c'est pour avoir les commandes de contrôle du lecteur d'accord sinon la personne ne pourra pas gérer à ce niveau-là.

Vous avez d'autres paramètres qui peuvent servir notamment l'autoplay alors ça je déconseille évidemment parce que les gens détestent que un son, une vidéo démarre toute seule quand vous charger la page d'un site d'accord c'est assez désagréable donc si vous mettez autoplay bien évidemment au chargement de la page ça démarre tout seul.
```html
	<audio src="song.mp3" controls autoplay>
		Votre navigateur ne supporte pas l'audio
	</audio>
```
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>

	<audio src="song.mp3" controls autoplay>
		Votre navigateur ne supporte pas l'audio
	</audio>
</body>
</html>
```
```txt
	Sons et vidéos
	> 0:01 / 3:35 O--------- <) ---O
```
C'est à la personne du coup de mettre sur pause ou réduire le son ce qui est assez embêtant donc c'est pareil si vous ne voulez pas que ça démarre automatiquement ce qui est conseillé, vous ne mettez tout simplement pas d'attribut dans la liste comme ça pas de problème.

Un autre attribut qui peut être utile c'est l'attribut également 'muted' ça éventuellement si vous voulez faire un 'autoplay' vous pouvez dire voilà je démarre le contenu par contre par défaut il est muté.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>

	<audio src="song.mp3" controls autoplay muted>
		Votre navigateur ne supporte pas l'audio
	</audio>
</body>
</html>
```
```txt
	Sons et vidéos
	> 0:00 / 3:35 O--------- <\) ---O
```
Vous voyez que le son démarre par contre le son n'est pas mis donc c'est à la personne après de régler le son, ça c'est éventuellement une possibilité.

Le 'muted' et vous avez bien évidemment le 'loop' qui va lire le fichier en boucle donc on va arriver à la fin du fichier ici et le fichier redémarre.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>

	<audio src="song.mp3" controls autoplay muted loop>
		Votre navigateur ne supporte pas l'audio
	</audio>
</body>
</html>
```
```txt
	Sons et vidéos
	> 0:00 / 3:35 O--------- <) ---O
```
Le fichier redémarre, voilà ça c'est pour le 'loop' c'est quand même vachement pratique pour bien afficher en boucle si évidemment c'est nécessaire.

Un dernier point qui peut servir au niveau chargement de la page, vous pouvez précharger ou non le fichier avec l'attribut 'preload', par défaut il va prendre plusieurs arguments.
```html
	preload=""
```
Vous pouvez le mettre évidemment à "none" pour dire en fait on ne fait pas de préchargement du fichier éventuellement.
```html
	<audio src="song.mp3" preload="none">
		Votre navigateur ne supporte pas l'audio
	</audio>
```
vous pouvez le mettre en "auto" d'accord comme ceci.
```html
	<audio src="song.mp3" preload="auto">
		Votre navigateur ne supporte pas l'audio
	</audio>
```
En "auto" ça veut dire qu'il va télécharger l'ensemble du fichier et si vous voulez pas forcément télécharger l'ensemble du fichier puisque il va faloir qu'il télécharge évidemment dans votre navigateur le son pour pouvoir le lire, vous pouvez mettre simplement "metadata" donc ça permet simplement de réduire les choses.
```html
	<audio src="song.mp3" preload="auto">
		Votre navigateur ne supporte pas l'audio
	</audio>
```
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>

	<audio src="song.mp3" preload="metadata">
		Votre navigateur ne supporte pas l'audio
	</audio>
</body>
</html>
```
```txt
	Sons et vidéos
```
Voyez que là, le fichier n'est pas chargé donc dans certains cas ça peut être utile ou non selon comment vous allez vouloir travailler votre son.

Alors vous comme vous allez à priori vous en servir pour que l'utilisateur puisse le lire vous allez plutôt préféré ne pas mettre ce champ là tout simplement d'accord.

Après on peut travailler avec les médias via des scripts et cetera donc cet attribut peut servir dans ce genre de cas mais pour un cas normal vous mettez juste 'controls', par exemple vous mettez 'preload' égal "metadata" comme ceci.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>

	<audio src="song.mp3" controls preload="metadata">
		Votre navigateur ne supporte pas l'audio
	</audio>
</body>
</html>
```
```txt
	Sons et vidéos
	> 0:00 / 3:35 O--------- <) ---O
```
Voilà d'accord donc là il va vraiment charger que les métadonnées du son et c'est vraiment quand la personne va vouloir charger qu'il va charger le fichier donc là c'est rapide puisque je suis en local et puis voilà c'est pas un très gros fichier donc ça va vite.

Ca permet des fois de gagner en chargement de page ou surtout en chargement de données parce que là vous voyez mon fichier audio fait 8,23 méga d'accord ce qui n'est pas petit pour un fichier son mais ça veut dire qu'au niveau de la page, il va devoir charger 8 mégas en plus donc vous pouvez comme ça accélérer le chargement de vos pages puisqu'il n'aura pas forcément télécharger l'ensemble du fichier donc ça c'est important.

A voir le 'preload' il peut vraiment servir à ce niveau là donc la base encore une fois  comme je le dis c'est l'attribut 'src' ou via la balise `<source>` pour évidemment indiquer le fichier, et 'controls' pour avoir le contrôle sur le fichier à lire donc ça c'était des choses à savoir.

Un autre petit point aussi qui peut éventuellement servir c'est l'attribut 'volume' tout simplement alors qui peut prendre la valeur de "0.1" donc ça c'est le son minimum d'accord enfin c'est même "0" pour être exact, jusqu'à 1.0 d'accord.
```html
	<audio src="song.mp3" controls volume="0.2">
		Votre navigateur ne supporte pas l'audio
	</audio>
```
D'accord vous pouvez basculer vous pouvez faire par exemple "0.2", "0.3", etc.

Une fois vous êtes à "1.0", vous êtes à 100% de volume, on peut mettre "0.6" par exemple.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>

	<audio src="song.mp3" controls volume="0.6">
		Votre navigateur ne supporte pas l'audio
	</audio>
</body>
</html>
```
```txt
	Sons et vidéos
	> 0:00 / 3:35 O--------- <) --O--
```
Le son est légèrement moins fort, il n'est pas à 100% voilà donc ça c'est à voir aussi, ça peut servir au niveau des attributs je pense qu'en audio c'est tout ce qu'il y a  d'intéressant à vous montrer donc on va pouvoir passer à la vidéo.

Alors la vidéo, ça va être très simple aussi c'est un peu le même principe, pour ça que cette vidéo est courte, vous avez une balise `<video>` tout simplement donc pareil vous mettre un message "Votre navigateur ne prend pas en charge la vidéo HTML" et ça va prendre
différents attributs.
```html
	<video controls src="bunny.mp4">
		Votre navigateur ne prend pas en charge la vidéo HTML
	</video>
```
Donc comme pour l'audio, vous pouvez mettre le 'src' ici charger pour le coup votre ficher de cette manière d'accord ou alors via la balise `<source>`.
```html
	<video controls>
		<source src="bunny.mp4" type="video/mp4">
		Votre navigateur ne prend pas en charge la vidéo HTML
	</video>
```
`<source>`, 'src' et le type mime 'type' donc le type mime c'est "video/mp4". Si c'est du webm c'est tout simplement "video/webm" et si c'est de l'ogg c'est comme tout à l'heure sauf qu'au lieu d'être "audio/ogg" c'est "video/ogg" et voilà vous pouvez le charger de cette manière.

Les mêmes attributs 'controls' etc, on va retrouver la même chose sauf que là on va avoir cette fois bunny.mp4 qui charge.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>

	<video controls>
		<source src="bunny.mp4" type="video/mp4">
		Votre navigateur ne prend pas en charge la vidéo HTML
	</video>
</body>
</html>
```
```txt
	> 0:00 / 9:48 O-------------------------------------- <) ---------O # :
```
Là je peux charger avec un gros lecteur mon document d'accord voyez que la vidéo est lisible.

On peut gérer au niveau du volume toujours pareil et bien sûr gérer le plein écran voilà.

Donc ça c'est par défaut d'accord maintenant vous voyez que ça s'affiche en grand ce n'est pas forcément agréable.

Alors vous allez avoir d'autres attributs.
```html
	<video controls src="bunny.mp4">
		Votre navigateur ne prend pas en charge la vidéo HTML
	</video>
```
Alors les attributs que vous allez retrouver, il y a 'controls', il y a 'muted', il y a 'autoplay', toujours pareil le 'preload' donc ça je ne reviens pas dessus où je l'ai montré l'audio vous pouvez faire la même chose en vidéo mais il y a également d'autres informations intéressantes notamment la première qui est la miniature.

Là vous voyez par défaut j'affiche pas de miniatures à mon image, c'est embêtant on va pouvoir gérer ça alors avant de voir la miniature par contre je vais peut-être changer la largeur et la hauteur parce que c'est assez désagréable donc vous allez utiliser l'attribut 'width' pour définir une largeur et l'attribut height pour définir une hauteur.

Par exemple 640 x 480 admettons je crois que c'est vidéo en 16/9.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>

	<video src="bunny.mp4" width="640" height="480" controls>
		Votre navigateur ne prend pas en charge la vidéo HTML
	</video>
</body>
</html>
```
```txt
	> 0:00 / 9:48 O-------------------------------------- <) ---------O # :
```
Logiquement voilà c'est quand même plus agréable à lire sur cette taille là.

Du coup vous allez pouvoir changer la résolution de votre vidéo.

Si vous voulez gérer la hauteur automatiquement en fonction de la largeur comme on l'a vu pour les images, vous mettez un attribut à "auto" d'accords et ce sera gérée automatiquement donc ça peut être pratique aussi, ça évite d'avoir des hauteurs trop grande ça garde les bonnes proportions à ce niveau là donc c'est quand même plus pratique.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>

	<video src="bunny.mp4" width="640" height="auto" controls>
		Votre navigateur ne prend pas en charge la vidéo HTML
	</video>
</body>
</html>
```
```txt
	> 0:00 / 9:48 O-------------------------------------- <) ---------O # :
```
Voilà donc ça c'est plutôt bien à savoir et on termine avec la partie miniature parce que ça c'est ce que je voulais vous montrer surtout qui est 'poster' donc vous mettez l'attribut 'poster' et elle va prendre tout simplement une url donc vers une image qui sera votre mignature.

Voyez j'ai récupéré une image ici que j'ai appelé miniature.jpg, un jpeg, ça va être rapide on affiche le chemin et on va actualiser F5 et voilà et vous avez votre miniature qui s'affiche au niveau du lecteur vidéo donc c'est plutôt pratique.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Sons et vidéos</title>
</head>
<body>
	<!--
		AUDIO : mp3		(compatible partout)
				wav		(compatible sauf IE)
				ogg 	(compatible sauf IE et Safari)
				
		VIDEO : mp4		(compatible partout)
				webm	(compatible sauf IE et Safari)
				ogg		(compatible sauf IE et Safari)
				
	-->
	<h1>Sons et vidéos</h1>

	<video src="bunny.mp4" width="640" height="auto" poster="miniature.jpg" controls>
		Votre navigateur ne prend pas en charge la vidéo HTML
	</video>
</body>
</html>
```
```txt
	+-------+
	|		|
	|miniature.jpg
	+-------+

	> 0:00 / 9:48 O-------------------------------------- <) ---------O # :
```
Pour ceux qui voudraient éventuellement modifier des choses par exemple ici le style du lecteur ou le format ou je ne sais quoi évidemment tout ça on apprendre à le faire en css d'accord, c'est des choses que vous pourrez faire concernant le design d'accord.

Là on reste sur de la sémantique pur au niveau du fichier, la création des pages tout ce qui est encore une fois design, aspect graphique, c'est des choses qui seront en css.

En tout cas maintenant grâce avec cette vidéo, vous savez lire des sons, vous savez également lire des vidéos en html donc vous voyez que c'est très très simple d'accord c'était pas très long à vous montrer.

Pareil n'hésitez pas à mettre vos petits fichiers pour voir comment ça fonctionne mais logiquement si jusqu'à présent vous n'avez pas eu de souci avec html c'est pas ça qui sera compliqué au niveau des balises à apprendre donc pas la balise `<audio>`, la balise `<video>` et pas mal d'attributs qui sont plus ou moins utiles en fonction de ce que vous voulez faire.

Je vous laisse avec ça et je vous dis à bientôt pour la prochaine vidéo en html où l'on commencera vraiment à voir comment structurer nos pages d'accord on va commencer sur vraiment voir comment structurer les parties de notre page et à priori ça devrait être la prochaine fois la dernière vidéo purement html pour démarrer ensuite la partie css donc on va vraiment entrer dans l'aspect design,  l'aspect graphique au niveau de la création de vos pages web.

A bientôt tout le monde pour une prochaine vidéo