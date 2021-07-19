# [22. Modèle avancé de boîte](https://www.youtube.com/watch?v=E-AphbscmP8)
07-02-21

Bonjour à tous et bienvenue pour cette séance 22 en HTML CSS, une petite vidéo de transition qui sera un petit peu moins long que d'habitude parce que nous allons revenir sur le modèle de boîte avec quelques petites manipulations avancées qui sont importantes à voir et qui sont un petit peu plus moderne. 

Je vais vous montrer ça je ferai une petite parenthèse avec une petite propriété que je ne vous ai pas montré dans la vidéo précédente et qui a quand même son intérêt. 

Alors vous vous souvenez peut-être de la propriété "text-shadow' qui permettait de mettre une ombre portée en dessous d'un texte si vous vous souvenez de celle-là. 

Vous allez voir qu'on peut appliquer la même chose mais pour une bordure. 
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div id="wrapper">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam, numquam ipsum quibusdam aliquid magnam eos impedit nulla ad? Quod aliquid earum maiores provident excepturi saepe beatae doloremque ducimus impedit magnam?</div>
</body>
</html>
```
Alors on obtient par défaut.
```txt
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam, numquam ipsum quibusdam aliquid magnam eos impedit nulla ad? Quod aliquid earum maiores provident excepturi saepe beatae doloremque ducimus impedit magnam?
```
Tout simplement parce que je n'ai appliqué aucun style en CSS mais on va quand même mettre un style de base pour avoir quelque chose d'un peu plus visuel avec une couleur un peu moins blanche #EEE, on va mettre un alignement automatique donc centré et une largeur de 800 pixels donc ça comme d'habitude ça ne va pas changer grand-chose c'est juste pour que ce soit un peu plus agréable au niveau de la vidéo.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
```
Et voilà à partir de là on va appliquer une ombre portée au niveau de notre bloc donc notre blog s'est un 'id' qu'on lui a affecté "wraper" donc on va l'ajouter ici avec un # je rappelle donc ça c'est des petits rappels de tout ce qu'on a pu voir dans la vidéo CSS, alors on peut déjà s'amuser à lui mettre une bordure on peut très bien faire une petite bordure un peu noir comme ça.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
		border:1px solid #333;
	}
```
```txt
	+---+------------------------------+----+
	|	|Lorem...					   |	|
	|	+------------------------------+	|
	|				800px					|
	|										|
	+---------------------------------------+
```
On peut mettre également une petite bordure avec le haut, `margin-top:50px;`
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
		border:1px solid #333;
		margin-top:50px;
	}
```
Voilà la petite bordure pas de problème.
```txt
>	+---------------------------------------+
>	|	+------------------------------+	|
	|	|Lorem ipsum dolor sit ...	   |	|
	|	+------------------------------+	|
	|										|
	|										|
	+---------------------------------------+
```
Alors je vais mettre aussi un padding:5px;
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
		border:1px solid #333;
		margin-top:50px;
		padding:5px;
	}
```
```txt
	+---------------------------------------+
	|	+------------------------------+	|
>	|	|							   |	|
	|	|	Lorem ipsum dolor sit ...  |	|
	|	|							   |	|
	|	+------------------------------+	|
	|										|
	|										|
	+---------------------------------------+
```
Et maintenant nous pouvons appliquer notre ombre portée à cette petite boîte que nous avons fait donc on peut tout simplement utiliser la propriété 'box-shadow' c'est-à-dire que c'est comme 'text-shadow' comme on l'avait vu avec le texte mais là c'est pour les boîtes, ça fonctionne avec les mêmes valeurs au niveau des décalages. 

Vous avez le décalage en x, en pixel ou autre, vous avez le décalage en y mais nous on peut laisser 0 pour le décalage en y.
```css
	box-shadow:0 0
```
Ensuite on a l'étendue de l'ombre portée, on peut mettre 3 pixels et ensuite la couleur qu'on peut mettre en hexadécimal ou autre #111, et là on peut mettre simplement un noir par exemple.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
		border:1px solid #333;
		box-shadow:0 0 3px #111;
		margin-top:50px;
		padding:5px;
	}
```
```txt
	+---------------------------------------+
	|	+******************************+	|
	|	*							   *	|
	|	*	Lorem ipsum dolor sit ...  *	|
	|	*							   *	|
	|	+******************************+	|
	|										|
	|										|
	+---------------------------------------+
```
Voilà on obtient ce petit effet là donc ce qui est très très sympa, à l'usage ce n'est pas compliqué du tout, vous allez pouvoir comme ça gérer des petites ombres un peu particulières ici au niveau de notre boîte. 

Après on peut varier un peu les couleurs et mettre un peu en évidence quelque chose et ce qui est un petit peu plus sympathique au niveau effet, voilà ce que j'avais oublié de vous parler dans la vidéo précédente.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
>		background-color:#FFF;
		border:1px solid #333;
		box-shadow:0 0 3px #111;
		margin-top:50px;
		padding:5px;
	}
```
```txt
	+---------------------------------------+
	|	+******************************+	|
	|	*							   *	|
	|	*	Lorem ipsum dolor sit ...  *	|
	|	*							   *	|
	|	+******************************+	|
	|										|
	|										|
	+---------------------------------------+
```
Voilà on peut comme ça faire sortir un bloc par rapport au fond donc c'est à connaître et évidemment si vous affectez l'étendue de l'ombre, vous verrez qu'elle va se propager un peu plus.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
		background-color:#FFF;
		border:1px solid #333;
>		box-shadow:0 0 10px #111;
		margin-top:50px;
		padding:5px;
	}
```
```txt
	+---------------------------------------+
	|	+********************************	|
	|	*							   **	|
	|	*	Lorem ipsum dolor sit ...  **	|
	|	*							   **	|
	|	*********************************	|
	|	*********************************	|
	|										|
	+---------------------------------------+
```
Là on en arrive vraiment à ce que je voulais vous montrer pour cette vidéo avec une manipulation un petit peu avancé concernant ce modèle de boîte, que vous avez appris à manipuler en travaillant sur les marges intérieures donc le 'padding', on a également vu comment faire des bordures, on a vu comment faire des bordures externes donc les outlines et les marges extérieurs avec 'margin'.

Alors il faut savoir que le comportement par défaut pour les boîtes et on va l'appliquer ici.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div id="wrapper">
		<div class="bloc1">
			Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam, numquam ipsum quibusdam aliquid magnam eos impedit nulla ad? Quod aliquid earum maiores provident excepturi saepe beatae doloremque ducimus impedit magnam?
		</div>
		<div class="bloc2">
			Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam, numquam ipsum quibusdam aliquid magnam eos impedit nulla ad? Quod aliquid earum maiores provident excepturi saepe beatae doloremque ducimus impedit magnam?
		</div>
	</div>
</body>
</html>
```
Voilà on a 2 blocs si on leur rappelle que rien du tout par défaut on a ça.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{

	}
```
```txt
	+---------------------------------------+
	|	Lorem ipsum dolor sit amet ...		|
	|	Lorem ipsum dolor sit amet ...		|
	|										|
	|										|
	|										|
	|										|
	|										|
	+---------------------------------------+
```
Voilà on a ça mais pour le bloc1 et le bloc2, on va appliquer un style et ensuite pour chacun des blocs, on fera quelque chose en particulier aussi et donc on verra quoi.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{

	}

	.bloc1, .bloc2
	{
	}
	
	.bloc1
	{
	}

	.bloc2
	{
	}
```
Donc on va faire ça, admettons que #wrapper prends une largeur de admettons 100% c'est-à-dire qu'il prend la totalité de la largeur c'est-à-dire la totalité de 800 pixels qu'on a mis ici au <body>.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
>		width:100px;
	}

	.bloc1, .bloc2
	{
	}
	
	.bloc1
	{
	}

	.bloc2
	{
	}
```
Alors là évidemment ça ne change absolument rien parce qu'on a déjà 800 pixels, on va par contre lui mettre une bordure pour pouvoir le reconnaître de 3 pixels, avec un très "solid" et la couleur "darkblue". voilà ce genre de chose.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
>		border:3px solid darkblue;
		width:100%;
	}

	.bloc1, .bloc2
	{
	}
	
	.bloc1
	{
	}

	.bloc2
	{
	}
```
```txt
	+---+------------------------------+----+
	|	|Lorem...					   |	|
	|	+------------------------------+	|
	|				800px					|
	|										|
	+---------------------------------------+
```
Voilà je fais les étapes au fur et à mesure histoire que vous voyez un petit peu après là où on veut en venir. 

On a donc ça et pour le bloc1, on va également le refaire une bordure et là vous allez vous rendre compte un petit peu ce qui va se passer par la suite mais on va d'abord faire sans bordure en mettant juste en 'background-color' que l'on va mettre En clair mais pas trop foncé, rgb(224,185,185). Et bloc2, on va faire pareil mais d'une autre couleur pour que ce soit assez visuel pour vous, rgb(156,169,212).
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
		border:3px solid darkblue;
		width:100%;
	}

	.bloc1, .bloc2
	{
	}
	
	.bloc1
	{
>		background-color:rgb(224,185,185);
	}

	.bloc2
	{
>		background-color:rgb(156,169,212);
	}
```
On actualise.
```txt
	+---+------------------------------+----+
	|	|Lorem...					   |	|
	|   +..............................+    |
	|	|Lorem...					   |	|
	|	+------------------------------+	|
	|										|
	+---------------------------------------+
```
Donc là on se rend bien compte des choses. 

Ça ce sont les comportements par défaut que vont avoir les boîtes en CSS. 

C'est-à-dire que les boîtes vont fonctionner par rapport à un type de contenu et donc là mes boîtes par défaut elles ont juste une couleur de fond  et donc là par rapport à la bordure, elles occupent tout l'espace qui leur ont été proposés ici.

D'ailleurs je peux le spécifier manuellement, on peut le mettre pour les 3 histoire de faire les choses un peu plus proprement et factoriser un maximum ce fichier pour éviter de répéter le 'width' inutilement et on appliquerait quelque chose de particulier plus tard.  

Voilà on appliquera quelque chose de particulier plus tard donc on peut très bien faire ça sans problème d'accord ça occupe 100 % la largeur pas de souci.

Maintenant si je tiens par exemple à appliquer une bordure ou un outline ou tout simplement un padding au niveau de l'élément par exemple ici en bleu d'accord donc le deuxième bloc par exemple si je m'amuse à faire 15 pixels ici.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
		border:3px solid darkblue;
		width:100%;
	}

	.bloc1, .bloc2
	{
	}
	
	.bloc1
	{
		background-color:rgb(224,185,185);
	}

	.bloc2
	{
		background-color:rgb(156,169,212);
>		padding:15px;
	}
```
On actualise.
```txt
	+---+------------------------------+----+
	|	|Lorem...					   |	|
	|   +.................................+ |
	|	|Lorem...					   	  |	|
	|	+---------------------------------+	|
	|				100% + 15x2 pixels		|
	+---------------------------------------+
```
On peut obtenir ce genre de résultat d'accord on a un dépassement du bloc tout simplement parce que par défaut les boîtes de contenu quand elles sont gérées par css prennent en compte seulement la largeur que vous avez spécifié pour le contenu. Nous on lui a dit 100% ça c'est très bien il applique une largeur pour le coût de 100% mais il ne prend pas en compte à l'intérieur de c'est 100% les bordures donc avec la propriété 'border' les bordures externe avec 'outline' et les marges intérieur donc avec le fameux 'padding'.

Donc à partir de ce moment là on obtient une largeur donc pour le bloc 2 qui est de 100% et vous ajoutez à ces 100%, les 15 pixels ici de marge interne mais x2 puisqu'il y a celle du coup qui sont à gauche et à droite puisque on travaille sur la largeur et on obtient ce dépassement-là.

On remarque aussi d'ailleurs qu'on pourra obtenir également le dépassement par la suite au niveau de la hauteur d'accord on pourra avoir un débordementau niveau de la hauteur.

Donc ça c'est le comportement par défaut de nos boîtes de contenu, si je m'amuse en plus à rajouter également une 'border' par exemple une grosse bordure 10px genre "dashed" et "red".
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
		border:3px solid darkblue;
		width:100%;
	}

	.bloc1, .bloc2
	{
	}
	
	.bloc1
	{
		background-color:rgb(224,185,185);
	}

	.bloc2
	{
		background-color:rgb(156,169,212);
>		border:10px dashed red;
		padding:15px;
	}
```
On actualise.
```txt
	+---+------------------------------+----+
	|	|Lorem...					   |	|
	|   +=================================+ |
	|	#Lorem...					   	  # |
	|	+=================================+	|
	|				100% + 15x2 + 10x2		|
	+---------------------------------------+
```
On aura évidemment un dépassement encore plus prononcée puisque ça prendra en compte tous d'accord donc la hauteur pas de problème ça arrive parce qu'on n'a pas appliqué de hauteur spécifique à s'agrandir sans problème d'accord par contre vous voyez que la largeur ça déborde complètement, ça ne s'adaptent pas ici par rapport aux 100 % puisque le 100% s'arrête là et là vous avez en fait l'épaisseur des 2 'padding' donc padding x 2 et du border x 2 qui viennent s'ajouter à la boîte, c'est pour ça qu'on a ce dépassement.

Pour éviter ce type de comportement, il va falloir le changer càd avant quelques nouveautés qu'apporte CSS 3, on n'avait pas le choix, on avait ce comportement là et il fallait faire avec.

Avec CSS 3, on a introduit une nouvelle propriété qui permet de changer ce comportement par défaut.

Ce comportement par défaut donc déjà c'est la propriété 'box-sizing' et ce comportement par défaut c'est "content-box" donc si je mets ça c'est comme si je ne m'étais rien évidemment parce que c'est le comportement par défaut.
```css
	.bloc1, .bloc2
	{
		box-sizing:content-box;
	}
```
Pour changer ce dernier on aura juste à modifier la valeur "content-box" par "border-box".
```css
	.bloc1, .bloc2
	{
		box-sizing:border-box;
	}
```
Ca veut tout simplement dire que ça prendra en compte ces fameuses valeurs de bordure, de marge intérieur etc dans le calcul de la largeur ou éventuellement de la hauteur donc dans ces 100% là, on inclura tout ça le 'border' (10px), le 'padding' (15px) et 'width' (800px) qu'on a fait ici.

Et si nécessaire bien sûr comme le 'padding' et 'border' vont prendre une certaine épaisseur, on va du coup compresser l'espace réservé au contenu donc l'espace qui est réservé ici à notre texte et vous allez le voir en résultat visuel.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
		border:3px solid darkblue;
		width:100%;
	}

	.bloc1, .bloc2
	{
>		box-sizing:border-box;
	}
	
	.bloc1
	{
		background-color:rgb(224,185,185);
	}

	.bloc2
	{
		background-color:rgb(156,169,212);
		border:10px dashed red;
		padding:15px;
	}
```
On actualise.
```txt
	+---+------------------------------+----+
	|	|Lorem...					   |	|
	|   +==============================+ 	|
	|	#Lorem...				 	   # 	|
	|	+==============================+	|
	|		box-sizing:border-box			|
	+---------------------------------------+
```
Voilà comment ça ce passe d'accord on garde l'élément, le contenu à l'intérieur du Wrapper, c'est pour ça que je voulais faire cette <div> là avec le petit cadre en bleu foncé pour que vous voyez bien que ça se met à l'intérieur, ça c'est très important quand on voulait par exemple placez des éléments d'une certaine manière sans risquer des dépassements, ça peut être utile de travailler comme ça.

On prendra en compte absolument toutes les marges sauf les marges externe si vous faites un 'margin' évidemment ça ne sera pas pris en compte par ce type de comportement parce que là il s'agit d'une marge extérieur au contenu, à la boîte.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
		border:3px solid darkblue;
		width:100%;
	}

	.bloc1, .bloc2
	{
		box-sizing:border-box;
	}
	
	.bloc1
	{
		background-color:rgb(224,185,185);
	}

	.bloc2
	{
		background-color:rgb(156,169,212);
		border:10px dashed red;
		padding:15px;
>		margin:10px;
	}
```
On actualise.
```txt
	+---+------------------------------+----+
	|	|Lorem...					   |	|
	|    +==============================+ 	|
	|	 #Lorem...				 	    # 	|
	|	 +==============================+	|
	|				margin:10px;			|
	+---------------------------------------+
```
Là évidemment il y aura un dépassement parce qu'on est on est plus en fait dans le modèle de boîte, on est à son extérieur donc ce n'est pas appliqué à ce moment.

Et pour tout le reste tout ce qui fait partie de la boîte 'padding', 'border', 'outline', on peut mettre 'outline' si vous voulez.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
		border:3px solid darkblue;
		width:100%;
	}

	.bloc1, .bloc2
	{
		box-sizing:border-box;
	}
	
	.bloc1
	{
		background-color:rgb(224,185,185);
	}

	.bloc2
	{
		background-color:rgb(156,169,212);
		border:10px dashed red;
		padding:15px;
		margin:10px;
>		outline:3px solid green;
	}
```
Par contre là ça va être différent voyez qu'il va se mettre ici.
```txt
	+---+------------------------------+----+
	|	|Lorem						   |	|
	|  ..................................	|
	|  .+==============================+. 	|
	|  .#Lorem					 	   #. 	|
	|  .+==============================+.	|
	|		outline:3px solid green;		|
	+---------------------------------------+
```
Alors la outline comme c'est externe, extérieurs vous voyez que du coup il vient ce il vient chevauchze en fait ici la bordure du #wrapper d'accord donc c'est encore différent pour le 'outline'.

Si on met un 10 voilà comment ça va se passer on aura un dépassement ici d'accord puisque c'est vraiment extérieur.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:800px;
	}
	
	#wrapper
	{
		border:3px solid darkblue;
		width:100%;
	}

	.bloc1, .bloc2
	{
		box-sizing:border-box;
	}
	
	.bloc1
	{
		background-color:rgb(224,185,185);
	}

	.bloc2
	{
		background-color:rgb(156,169,212);
		border:10px dashed red;
		padding:15px;
		margin:10px;
>		outline:10px solid green;
	}
```
On actualise.
```txt
	+---+------------------------------+----+
	|	|Lorem						   |	|
	|  #================================#	|
	|  #+==============================+# 	|
	|  ##Lorem					 	   ## 	|
	|  #+==============================+#	|
	|		outline:3px solid green;		|
	+---------------------------------------+
```
C'est une bordure extérieure, la 'outline', on l'avait déjà vu en vidéo et là c'est pareil si vous êtes dans dans des proportions qui entre dans le <div> principal que vous avez ça ne dépassera pas (3px) mais à partir du moment où vous aurez des valeurs trop importante (10px) évidemment ça dépassera mais là comme il s'agit d'une bordure extérieure vous voyez que ce n'est pas que d'un côté que ça dépasse mais de tous les autres mais ça dépasse même au niveau de la hauteur donc ça c'est des cas particuliers.

Donc le 'border', 'padding', ce qui est interne sera pris en compte par ce comportement là.
```css
	.bloc1, .bloc2
	{
		box-sizing:border-box;
	}
```
Le 'outline' et le 'margin' comme c'est extérieurs, ce ne sera pas pris en compte d'accord donc ça il faudra voir avec ces éléments.

Donc c'était une petite chose que je voulais vous montrer je ne vais pas faire une vidéo trop trop longue mais je voulais quand même en parler parce que c'est important à savoir surtout que les prochaines vidéos, on va pas mal à aborder d'autres manières d'organiser nos boîtes et de créer des modèles de boîtes pour nos pages web et ça terminera d'ailleurs le cours donc je voulais voir ceci pour maîtriser en tout cas cette petite propriété qui est très simple à mettre en oeuvre.

Je dis encore une fois, vous avez juste une propriété à connaître et une valeur particulière "border-box" qui permet de gérer comme ça les différentes dimensions, prendre en compte nos fameuses bordures ici et les marges intérieurs dans le calcul de la largeur et de la hauteur de nos éléments donc ça sert simplement à ça.

Cette propriété 'box-sizing' elle change tout simplement le comportement du modèle standard en fait des boîtes en CSS comme en CSS gère en fait les modèles de boîtes, un tèrme qu'on a déjà employé précédemment.

Voilà je vous laisse avec cette fin de vidéo c'était très très très très rapide à voir.

On va bientôt arriver à la fin de ce cours puisqu'il nous reste à aborder quelques modèles de boîtes particulieres qui ont été introduites également avec les derniers standards du langage css.

On parlera également après de design adaptatif ou design responsive pour ceux qui veulent travailler sur des sites web qui s'adapte automatiquement aux différentes résolutions, smartphones, tablettes, pc,  etc et on en aura terminé avec le cours.

Grosso modo il devrait nous rester 3 vidéos, 3 séances soit la petite séance de conclusion comme je fais à chaque fin de formation et on aura terminé avec le cours.

Et pour tout le reste parce qu'il y a pas mal de petites choses qu'on n'a pas vu non plus, on n'a pas vu par exemple certains cas spécifiques, comment créer un menu, comment faire telle ou telle chose, et cetera.

Tous ces concepts un peu particulier seront vus dans des tutoriels et on aura d'autres choses que je n'ai pas abordé dans le cours puisque ça reste du secondaire, c'est pas obligatoire comme par exemple les effets d'animation, de transition, les canevas, tous ces trucs là.

D'autant qu'il y aura certaines particularités qui vont devoir fonctionner avec javascript qui sera une autre formation, qui n'est pas encore faite au moment où j'enregistre cette vidéo mais vous aurez de toute façon sur la chaîne et peut-être même au moment où vous verrez cette séance.

En tout cas vous aurez de quoi faire et avec le cours que vous aurez ici, vous aurez vraiment quelque chose de très complets.

On aura fait le tour de l'ensemble des balises des propriétés html et css sauf les cas encore une fois qu'ils ne sont pas encore pris en charge et compatible avec l'ensemble des navigateurs donc j'ai évité d'aborder avec vous ces balises là où ces propriétés là pour être sûr voilà que vous ayez quelque chose de fonctionnel partout et dans toute circonstance donc sinon pour le reste vous aurez eu quelque chose vraiment de très complet.

J'espère que ça vous a plu c'était pas très compliqué je pense à mettre en oeuvre, n'hésitez pas bon à mettre en pratique comme toujours c'est important de de tester de votre côté d'avoir des résultats visuels pour bien assimiler, bien comprendre comment ça fonctionne et on se retrouvera du coup pour les prochaines vidéos donc on va parler de boîtes flexible.

On parlera également des grilles donc toutes ces petites notions là qui sont très très importante aujourd'hui en css et qui vont terminer un petit peu ce cours de web du coup côté 'front-end'.

Voila voila je vous dis à bientôt pour la prochaine séance en html css.

Cia tout le monde