# [19. Modèle de boîte](https://www.youtube.com/watch?v=ByUtms52CGc)
01-02-21

Bonjour à tous, bienvenue sur cette séance 19 en html css nous attaquons un chapitre assez important de cette formation puisque nous allons pas mal aborder la notion de boîte c'est à dire les modèles de boîtes que l'on retrouve dans ces développements là et il y a pas mal de choses à voir et des choses on va dire un peu plus historique.

Il y a eu des méthodes maintenant, un peu des solutions un peu plus récente, un peu plus moderne qu'on aura l'occasion de voir également au cours des vidéos. Vous en faites pas, on aura vraiment tout le temps de voir tout ça dans le détail mais on va commencer déjà par la base et savoir un petit peu en quoi ça consiste justement ce principe de boîtes.

On parle de modèles de boîtes.

Alors au niveau de nos pages html comme je vous l'avais écrit, nous avons vu pas mal de type de balises notamment les balises `<div>` et je vous avais dit par exemple ces balises étaient des balises de blocs c'est à dire que quand on crée un `<div>` en fait on peut s'attendre à un espèce de bloc d'accord qui va nous permettre de mettre tout un tas de contenus.

C'est l'inverse des balises inline comme par exemple la balise `<span>` d'accord.

La valise `<img>` est une balise inline, pareil on pourrait imaginer que l'image est mise dans une boîte mais c'est une balise inline et à l'inverse par exemple un simple lien d'accord une adresse par exemple serait du inline d'accord avec la balise `<a>` ce genre de choses.

Du coup tous ces éléments là, il faut comprendre donc que nos éléments html fonctionnent par ce principe de boîtes quel qu'il soit pour pouvoir faire la mise en forme de nos éléments.

D'ailleurs par défaut ici nous avons déjà deux boîtes, nous en avons une qui représente le document `<html>` et à l'intérieur nous avons `<body>`.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Modèle de boite en CSS</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	
</body>
</html>
```
Alors par défaut comme elles n'ont rien de spécifier en particulier `<body>` prend à peu près tout l'espace que prend `<html>` d'accord on ne voit pas forcément de différence donc nous ce que nous allons faire, nous allons créer une `<div>` ici d'accord juste une seule et à l'intérieur nous allons mettre un paragraphe voilà.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Modèle de boite en CSS</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Debitis, ipsa, dolorum fugiat quae ea quaerat adipisci unde ducimus modi tenetur libero quidem tempora cupiditate voluptatibus labore neque reiciendis? Id, repellendus.</p>
	</div>
</body>
</html>
```
Là nous venons de créer plusieurs boîtes différentes, nous avons `<html>`, ensuite à l'intérieur de `<html>` nous avons une boîte `<body>`, ensuite à l'intérieur de la boîte `<body>` nous avons une boîte `<div>` donc une seule. On pourrait en avoir plusieurs évidemment dans notre document mais là pour l'exemple on en aura qu'une seule et à l'intérieur de ce `<div>`, de cette boîte `<div>` nous avons une boîte de paragraphe.

Ok donc ces éléments là vont pouvoir être spécifié en css alors déjà pour que vous puissiez bien différencier les choses ce qu'on va faire c'est mettre des couleurs différentes donc ça je ne reviens pas dessus on l'a déjà vu dans une des vidéos précédentes donc se saura du blanc incomplet #FFF pour le `<html>` et `<body>` on va le faire un petit peu plus foncée #DDD et ensuite on va `<div>` avec #BBB que je vous expliquerai tout ça après voilà et notre paragraphe `<p>` avec une espèce de rouge histoire que ce soit assez visible pour vous avec la valeur en héxadécimale #c76f6f.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;	
	}
	div
	{
		background-color:#BBB;	
	}
	p
	{
		background-color:#c76f6f;	
	}
```
voilà d'accord et là nous avons une différence d'élément là on ne se rend pas compte des différentes couleurs et vous allez très vite le voir pourquoi puisqu'il y a beaucoup de boîtes qui se confondent d'accord.
```txt
	+-----------+
	| Lorem...	|
	+-----------+
```
Pour cela on va commencer à voir comment ça fonctionne, ces différentes boîtes ont besoin qu'en css, on leur attribuent déjà des dimensions et pour cela nous allons utiliser deux propriétés très simples qui sont 'width' pour la largeur et on lui met une largeur en pixels, en %, avec des valeurs relatives et cetera comme vous avez déjà vu précédemment avec pas mal d'autres éléments sur cette formation donc je ne reviens pas dessus non plus, là par exemple on va dire 800 pixels.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;	
	}
	p
	{
		background-color:#c76f6f;	
	}
```
Ok on actualise et voilà comment ça se passe, on voit une petite différence.
```txt
	|--------------------- >
		800px
	+-----------------------+
	| Lorem...				|
	+-----------------------+
```
On va continuer avec le `<div>` et on va lui appliquer une autre largeur histoire qu'on voit la différence soit 600px.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		width:600px;
	}
	p
	{
		background-color:#c76f6f;	
	}
```
On actualise.
```txt
	|---------------------- >
		800px
	+---------------+-------+
	| Lorem...		|		|
	+---------------+-------+
		600px
	|------------- >
```
Voilà donc là on voit du coup apparaître cette nouvelle couleur et le `<p>` je vais le laisser comme ça, on ne pas le changer alors on aura pas toutes les couleurs donc le `<p>` je vais le changer quand même parce que histoire que l'on voit bien donc `<p>` à 400 pixels.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		width:600px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
	}
```
On actualise.
```txt
	+---------------+-------+-------+
	| Lorem... <p>	| <div>	| <body>| <html>
	+---------------+-------+-------+
```
Voilà comme ça vous voyez bien les trois différences donc tout ce qui est en blanc d'accord c'est le document html comme j'ai dit c'est la boîte général d'accord à l'intérieur de cette grande boîte, nous avons la boîte qui représente le corps de notre document donc le `<body>` c'est tout ce qui est à l'intérieur, la page voyez ce n'est plus du `<body>` c'est du `<html>` c'est la partie de la boîte html.

Ensuite à l'intérieur de cette boîte `<body>` nous avons notre `<div>` c'est tout ce qui est en clair. `<div>` passe en dessous ici du paragraphe évidemment comme pour le `<body>` elle passe en dessous parce que c'est mit par dessus et ensuite on a notre paragraphe `<p>` qui est en rouge donc le `<p>` est bien dans le gris foncé, qui est dans le gris claire, qui est dans le blanc d'accord vous voyez ça suit cet ordre là.

Ca c'est la première chose, voyez qu'on peut spécifier une largeur, on peut évidemment spécifier des hauteurs sans problème donc si on ne met rien par défaut vous voyez donc que ça prend en fait des hauteurs automatique par rapport ici aux éléments (Lorem...).

Moi ce que je vais faire par rapport au `<div>` c'est que je vais utiliser la propriété 'height' et je vais dire tu vas faire une hauteur de 400 pixels.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		width:600px;
		height:400px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
	}
```
On actualise.
```txt
	+---------------+-------+-------+
	| Lorem... <p>	| <div>	| <body>| <html>
	+---------------+		|		|
	|						|		|
	|						|		|
	|						|		|
	+-----------------------+-------+
```
Voilà comment ça se passe.

Voilà donc du coup `<p>` ferra 300 pixels.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		width:600px;
		height:400px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:300px;
	}
```
On actualise.
```txt
	+---------------+-------+-------+
	| Lorem... <p>	| <div>	| <body>| <html>
	|				|		|		|
	|				|		|		|
	+---------------+		|		|
	|						|		|
	+-----------------------+-------+
```
On peut sans problème alors peut-être même dire voilà 30%.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		width:600px;
		height:400px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
	}
```
On actualise.
```txt
	+---------------+-------+-------+
	| Lorem... <p>	| <div>	| <body>| <html>
	|				|		|		|
	+---------------+		|		|
	|						|		|
	|						|		|
	+-----------------------+-------+
```
30% comme ça on a un peu près un propre résultat donc on arrive comme ça à séparer chacun des éléments en fonction voyez on a des dimensions à notre boîte et elles s'imbriquent chacune à l'intérieur de l'autre de la mène mesure où nous avons ici le `<p>` dans `<div>` qui est dans le `<body>` et qui est du coup dans tout le `<html>` d'accord donc c'est des boîtes à l'intérieur donc c'est pour ça que c'est important cette notion de modèle de boîte c'est tout ce qui fait justement ces éléments là que vous allez retrouvé en html sur lesquels vous allez pouvoir travailler avec des propriétés en css donc il faut bien comprendre ça.

Si vous comprenez ce principe de boîte et bien vous aurez tout compris au niveau du css.

Alors à ce niveau là, on n'a pas fait grand chose, on a juste spécifié les dimensions il faut savoir qu'en plus de ces propriétés 'width' pour la largeur et 'height' pour la hauteur, vous en avez également pour spécifier des valeurs minimales, maximales par exemple en faisant 'min-width' ou 'max-width'.
```css
	/*
		width | min-width | max-width
		height
	*/
```
Ca va être simplement pour dire voilà choisi une largeur minimale càd qu'on ne pourra pas aller en dessous et tu choisis une largeur maximal sur laquelle on ne pourra pas dépasser peu importe comment on redimentionnera par exemple l'écran ou selon la résolution de l'écran qu'on aura que ce soit par exemple un site visité sur smartphone ou autre.
```css
	/*
		width | min-width | max-width
		height| min-height| max-height
	*/
```
Voilà donc je les passe rapidement ces éléments min-..., max-... pour chacun ça fonctionne tout simplement comme ça et ce qu'on peut voir c'est que par exemple on peut dire par exemple `max-width:600px;` pour `<div>`
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
	}
```
On actualise.
```txt
	+---------------+-------+-------+
	| Lorem... <p>	| <div>	| <body>| <html>
	|				|		|		|
	+---------------+		|		|
	|						|		|
	|						|		|
	+-----------------------+-------+
```
Voilà ce qui fait voyez, on ne voit pas évidemment la redimension parce qu'on a spécifié la taille maximale qu'on aura pour ça. Avec la propriété 'max-width' l'occupation à 100% de `<p>` est bloqué.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
>		/* max-width:600px; */
		height:400px;
	}
	p
	{
		background-color:#c76f6f;
>		width:100%;
		height:30%;
	}
```
Voilà ça va permettre de spécifier une largeur minimale, une largeur max, etc bon dans certains cas ça peut être utile donc c'est bien à connaître mais je passe assez rapidement dessus puisque c'est le principe est simple c'est comme pour la largeur et la hauteur sauf qu'on donne ici une valeur minimale et une valeur maximale donc on peut éventuellement les mettre.

Voilà pour ça donc ça ce sont les dimensions de notre petite boîte.

On va maintenant voir autre chose et pour ça j'ai fait un petit schéma qui va vous représenter en fait la totalité de ce que nous allons voir sur ce principe de modèles de boîtes qui est ce dernier.
```txt
					|
					| margin
		+-------------------------------+
margin	|  outline						|
--------|  +------------------------+	|
		|  |  border				|	|
		|  |  +-----------------+	|	|
		|  |  |		| padding	|	|	|
		|  |  |--- CONTENT -----|	|	|
		|  |  |		|			|	|	|
		|  |  +-----------------+	|	|
		|  |						|	|
		|  +------------------------+	|----------
		|								|
		+-------------------------------+
```
Alors vous pouvez faire une capture d'écran, vous pouvez le redessiner de votre côté sur une feuille, n'importe où, faire une photo peu importe c'est tout ce qu'il y a à savoir au niveau de ce principe de modèles de boîtes en css.

Alors il y a pas mal de choses qu'on réservera pour une prochaine vidéo notamment ici 'outline' donc les contours et les bordures avec 'border' mais nous on va s'intéresser au reste.

Le contenu (CONTENT) que vous voyez ici en gris sur ce schéma ben c'est en fait tout simplement ce que nous avons ici c'est à dire dans notre code c'est ça.
```html
	<div>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Debitis, ipsa, dolorum fugiat quae ea quaerat adipisci unde ducimus modi tenetur libero quidem tempora cupiditate voluptatibus labore neque reiciendis? Id, repellendus.</p>
	</div>
```
On va partir du principe que c'est ce contenu plutôt cette ensemble là même si plus exactement que lui-même c'est déjà une boîte d'accord donc le `<p>` est déjà un contenu en lui-même.

A l'intérieur de ce contenu, on va pouvoir déterminer des marges intérieur d'accord.

Les marges intérieurs sont identifiés par la propriété 'padding' en css.

Alors on va appliquer cette propriété 'padding' et on va voir comment on fait ça.

'padding' fonctionne de plusieurs manières, vous avez déjà la possibilité de spécifier 'padding' à un certain endroit, vous avez vu qu'il y a une marge en haut d'accord qu'on appellera ça "top" en css, une marge à droite "right", une marge en bas "bottom" et une marge à gauche "left" donc ces différents éléments je peux faire ceci, padding-top, padding-right, padding-bottom et padding-left.
```css
	/*
		width | min-width | max-width
		height| min-height| max-height
		
		padding-top
		padding-right
		padding-bottom
		padding-left
	*/
```
Et je vais dire par exemple ici à mon paragraphe `<p>` tu va appliquer une marge en haut d'environ 25 pixels d'accord 'padding-top' 2 points une valeur en pixels.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
>		padding-top:25px;
	}
```
On actualise.
```txt
	+---------------+-------+-------+
>	|				|		|		|
	| Lorem... <p>	| <div>	| <body>| <html>
	|				|		|		|
	+---------------+		|		|
	|						|		|
	|						|		|
	+-----------------------+-------+
```
J'actualise et donc la marge voyez elle s'est bien mise à l'intérieur du contenu, elle s'est mise dans le rouge d'accord si ce n'était pas à l'intérieur la marge se serait fait ailleurs on ne l'aurait pas eu dans le rouge donc ça a décalé donc ça a vraiment laissé un espace à l'intérieur du contenu, dans toute la zone rouge et ensuite ça a commencé le `<p>`.

Je peux faire pareil pour le `<div>` mais genre on va lui mettre un 'padding-left' de 50 pixels.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
		padding-left:50px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
		padding-top:25px;
	}
```
On actualise.
```txt
	+---+---------------+-------+-------+
	|	|				|		|		|
	|	| Lorem... <p>	| <div>	| <body>| <html>
	|	|				|		|		|
	|	+---------------+		|		|
	|							|		|
	|							|		|
	+---------------------------+-------+
```
Voilà ce qu'on obtient tac.

Voilà on a une marge donc j'insiste bien c'est une marge mais intérieure dans le `<div>` d'accord juste ici donc en fait c'est toute la marge intérieur gauche, toute la partie grise ici donc là on a 50 pixels pour cette marge intérieure gauche.

Si vous avez besoin évidemment de spécifier les quatre éléments puisque voyez qu'on a 4 éléments...
```txt
		padding-top
		padding-right
		padding-bottom
		padding-left
```
Vous allez pouvoir utiliser la méta propriété d'accord qui est 'padding' et celle ci fonctionne dans un ordre précis.

'padding' on va lui mettre un premier argument donc pareil en pixels, en %, etc d'abord la valeur en haut pour le 'top', la deuxième se sera à droite, la troisième ce sera le bas et la 4e ce sera à gauche donc toujours dans cet ordre : haut, droite, bas, gauche.
```txt
	'top', 'right', 'bottom' et 'left'.
```
Tout le temps au niveau des marges ici donc si par exemple je veux dire pour les parapgraphes tu met une marge de 25 pixels partout, il a juste à mettre ça.
```css
	p						p
	{						{
		padding-top:25px;		padding:25px;
	}						}
```
Je peux faire ça comme ça je l'écris qu'une seule fois et ça s'applique de tous les côtés donc ça a mit une marge intérieur de 25 pixels de tout les cotés.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
		padding-left:50px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
		padding:25px;
	}
```
On actualise.
```txt
	+---------------+
	|				|
	| Lorem... <p>	|
	|				|
	+---------------+
	-- >
			+-------------------+
			|					|
			|	Lorem... <p>	|
			|					|
			+-------------------+
```
Une marge intérieure de 25px là, une marge intérieure de 25px là, une marge intérieure de 25px là etc ... et si je ne veux pas appliquer les mêmes marges selon l'endroits eh bien il suffit de spécifier.

La marge en haut, je veux qu'elle soit de 25 pixels, la marge à gauche je veux qu'elle soit de 50, la marge à droite, je peux même la retirer c'est-à-dire je peux par exemple faire - genre -10 pixels (on peut faire à des valeurs négatives) et la marge d'en bas par exemple je mets 0 donc je met même pas px pour optimiser un peu ça et j'actualise et voilà comment que ça se passe d'accord.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
		padding-left:50px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
		padding:25px 50px -10px 0;
	}
```
On actualise.
```txt
	+---------------+
	|Lorem... <p>	|
	|				|
	+---------------+
```
Voilà comment ça se passe donc là ce sera un peu bizarre pour le coup comme j'ai fait une marge de -10 ça change un peu les choses et voilà comment ça se passera d'accord.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
		padding-left:50px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
		padding:25px 50px 10px 0;
	}
```
On actualise.
```txt
	+---+---------------+-------+-------+
	|	|				|		|		|
	|	|Lorem... <p>	| <div>	| <body>| <html>
	|	|				|		|		|
	|	+---------------+		|		|
	|							|		|
	|							|		|
	+---------------------------+-------+
```
Alors c'est à droite que je voulais mettre zéro parce que je réflissait à l'envers donc à droite je voulait mettre zéro et c'est à gauche que je voulait mettre 56 pixels pour qu'on se rend mieux compte visuellement en tout cas pour vous voilà.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
		padding-left:50px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
		padding:25px 0px 10px 50px;
	}
```
On actualise.
```txt
	+---------------+-----------+-------+
	|				|			|		|
	|	Lorem... <p>| <div>		| <body>| <html>
	|				|			|		|
	+---------------+			|		|
	|							|		|
	|							|		|
	+---------------------------+-------+
```
Voilà je voulais qu'il y ai une marge à l'intérieur gauche voilà un petit peu comment ça se passe d'accor donc ici la marge de 25 pixels (top), droite (right) on a mit 0 pas de souci on a rien d'ailleurs si je fais -10 voilà ce qui se passerait.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
		padding-left:50px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
		padding:25px -10px 10px 50px;
	}
```
On actualise.
```txt
	+---------------+-----------+-------+
	|Lorem... <p>	|			|		|
	|				| <div>		| <body>| <html>
	|				|			|		|
	+---------------+			|		|
	|							|		|
	|							|		|
	+---------------------------+-------+
```
Voilà ça va carrément changer tout (coin supérieur gauche).

'padding' c'est la méta propriété qui en fait remplace les 4 là.
```txt
		padding-top
		padding-right
		padding-bottom
		padding-left
```
Vous pouvez du coup les spécifier dans cet ordre, le top, right, bottom et left.

Et si vous voulez mettre la même valeur aux quatres parties eh bien vous n'en mettez qu'une seule c'est suffisant.
```txt
	padding:25px 25px 25px 25px
	= padding:25px
```
Vous faites comme cela et ça marchera voilà donc pour cette marge intérieur ok.

On va maintenant regarder cette marge extérieur, si vous voyez elle est absolument vraiment en dehors de l'élément d'accord donc notre élément c'est tout ça.
```txt
					Ext

		+-------------------------------+
		|  outline						|
		|  +------------------------+	|
		|  |  border				|	|
		|  |  +-----------------+	|	|
		|  |  |		| padding	|	|	|
Ext		|  |  |--- CONTENT -----|	|	|	Ext
		|  |  |		|			|	|	|
		|  |  +-----------------+	|	|
		|  |						|	|
		|  +------------------------+	|
		|								|
		+-------------------------------+

						Ext
```
On verra plus tard qu'il peut avoir une bordure et un contour, on en parlera dans la prochaine vidéo mais sinon vous voyez qu'en dehors de l'élément on peut mettre une marge externe qui est vraiment en dehors de lui et dans ce cas là c'est exactement ça càd que je peux reprendre vraiment exactement les mêmes propriétés sauf que la place d'avoir 'padding' c'est 'margin'.
```css
	/*
		width | min-width | max-width
		height| min-height| max-height
		
		padding:
			padding-top
			padding-right
			padding-bottom
			padding-left

		margin:
			margin-top
			margin-right
			margin-bottom
			margin-left
	*/
```
Alors c'est un peu bizarre, padding ce n'est pas une marge mais si c'est une marge mais interne mais il fallait utiliser un autre mot donc ils ont utilisé 'padding' tout simplement donc 'margin' c'est marge  externe, 'padding' marge interne.

Et la différence hé bien il suffit de le voir c'est à dire que si je fais ça, `margin:25px;`
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
>		margin:25px;
	}
```
On actualise.
```txt
>
	+--+------------+-----------+-------+
	|  |Lorem... <p>|			|		|
	|  |			| <div>		| <body>| <html>
	|  |			|			|		|
	|  +------------+			|		|
	|							|		|
	|							|		|
	+---------------------------+-------+
```
On n'aura plus la marge ici à l'intérieur regardez  mais à l'extérieur donc du coup ça mit une marge à l'extérieur de `<p>`.

D'ailleurs il n'y a pas du padding dans le `<div>` d'ailleurs il suffit de le tester en faisant ça `margin:250px;` vous allez vite vous rendre compte que c'est bien lui qui influe.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
>		margin:250px;
	}
```
On actualise.
```txt
	+-----------+-----------+---+-------+
	|  			|Lorem.. <p>|	|		|
	|  	<div>	|			| 	| <body>| <html>
	|  			|			|	|		|
	|  			+-----------+	|		|
	|							|		|
	|							|		|
	+---------------------------+-------+
```
Donc là on décalle, on met une marge de 250px de chaque coté de `<p>` donc ça a tout changé.

A l'inverse si je mets 2px et bien on va avoir un truc tout petit `margin:2px;` pour `<p>`.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
>		margin:2px;
	}
```
On actualise.
```txt
 ++-------------+-----------+-------+
 ||Lorem... <p>	|			|		|
 ||				| <div>		| <body>| <html>
 ||				|			|		|
 |+-------------+			|		|
 |							|		|
 |							|		|
 +--------------------------+-------+
```
On voit à peine une marge de 2px donc ça c'est important, on peut du coup le faire un peu partout et l'appliquer également au `<div>` par exemple c'est évidement pareil.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
>		margin:15px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
>		margin:2px;
	}
```
On actualise.
```txt
 +-++-------------+-----------+-------+
 | ||Lorem... <p> |			  |		  |
 | ||			  | <div>	  | <body>| <html>
 | ||			  |			  |		  |
 | |+-------------+			  |		  |
 | |						  |		  |
 | |						  |		  |
 +-+--------------------------+-------+
```
Et vous voyez que là, on voit le `<body>`, on arrive à le voir partout (tout à gauche).

Et là on peut faire `padding:50px;` sur `<body>` par exemple que voyez visuellement la différence entre les deux (`<body>` et `<div>`).
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
>		padding:50px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
>		margin:15px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
>		margin:2px;
	}
```
On actualise.
```txt
 +------------------------------------+
 |    			   			  		  |
 |   ++-------------+---------+		  |
 |   ||Lorem... <p> |		  |		  |
 |   ||			    | <div>	  | <body>| <html>
 |   ||			    |	      |		  |
 |   |+-------------+	      |		  |
 |   |						  |		  |
 |   +------------------------+		  |
 |  								  |
 +------------------------------------+
```
La voyez on a mit un 'padding' du `<body>` donc ça met une marge à l'intérieur du `<body>` de 50 pixels de tous les côtés.

Du coup on a ça, on obtient ces valeurs là un peu particulière.

Voilà comment ça fonctionne d'accord au niveau de ce principe de modèle de boîte donc on continuera évidemment de le voir dans les prochaines vidéos.

Ce qui est à retenir là c'est le dimensionnement avec tout ceci.
```css
	/*
		width | min-width | max-width
		height| min-height| max-height
	*/
```
Pour la largeur, la hauteur, des valeurs minimales ou maximales pour chacunes des propriétés.

Une marge à l'intérieur de l'élément avec 'padding' et une marge à l'extérieur de l'élément et de ce qu'on verra dans la prochaine vidéo avec 'margin'.
```css
	/*	
		padding:
			padding-top
			padding-right
			padding-bottom
			padding-left

		margin:
			margin-top
			margin-right
			margin-bottom
			margin-left
	*/
```
Et avec ça vous avez tout ce qu'il faut par rapport à ce principe comme ça de boîte pour pouvoir évidemment prévoir la mise en forme ici.

Voilà pour cette partie là.

On va revenir du coup surr les choses un peu plus normal puisque on a évidemment un affichage pas joli joli du tout, on va essayer un 'padding' sur `<p>` pour éviter que ça touche les bords de la boîte en rouge.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		max-width:600px;
		height:400px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		height:30%;
>		padding:10px;
	}
```
On actualise.
```txt
 +-------------+---------+--------+
 |             |		 |		  |
 |	Lorem...<p>| <div>	 | <body> | <html>
 |			   |	     |		  |
 +-------------+	     |		  |
 |					  	 |		  |
 |						 |		  |
 +-----------------------+--------+
```
Voilà comme ça on a un beau petit écart c'est sympa.

On peut même éviter par exemple de mettre 'height' et 'max-width' ça ne sert à rien.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
>		width:600px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		padding:10px;
	}
```
On actualise.
```txt
 +-------------+---------+--------+
 |             |		 |		  |
 |	Lorem...<p>| <div>	 | <body> | <html>
 |			   |	     |		  |
 +-----------------------+--------+
```
voilà comme ça voilà vous vous rendez bien compte que le texte vraiment mit en évidence et je peux correctement mettre en évidence avec ce qu'on a déjà vu avant `text-align:justify;`
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		width:600px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		padding:10px;
>		text-align:justify;
	}
```
On actualise.
```txt
 +-------------+---------+--------+
 |             |		 |		  |
 |Lorem...  <p>| <div>	 | <body> | <html>
 |			   |	     |		  |
 +-----------------------+--------+
```
Voilà vous vous rendez bien compte que c'est effectivement ici un 'padding' à égale distance de tous les côtés que ce soit en haut à droite en bas à gauche.

Si je modifie ça voilà ce qui se passe hop d'accord, `padding:100px;`
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		width:600px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
>		padding:100px;
		text-align:justify;
	}
```
On actualise.
```txt
 +-----------------------+---------+--------+
 |			             |		   |		|
 |		Lorem...<p>	     | <div>   | <body> | <html>
 |						 |	  	   |		|
 +-----------------------+---------+--------+
```
Voilà ce qui se passe, c'est vraiment à l'intérieur donc si je faisais l'inverse (padding->margin) le comportement change complètement ça ressort donc ça ce sera d'accord à l'extérieur.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		width:600px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
>		margin:100px;
		text-align:justify;
	}
```
On actualise.
```txt
 +------+-----------+----+---------+--------+
 |		|Lorem...<p>|	 | <div>   | <body> | <html>
 +------+-----------+----+---------+--------+
```
Et y voilà c'est bon pour ça, on va laissé le texte en "justify" voilà.

Et on va passer pour terminer cette vidéo donc je ne vais pas faire quelque chose de trop trop long non plus puisqu'il y aura plusieurs vidéos pour parler de toutes ces boîtes différentes et toutes les solutions que css propose et notamment les solutions récentes pour mettre justement en boîte tout ce que nous faisons ici avec html.

On peut également gérer donc le contenu càd que dans certains cas, vous pouvez rencontrer un souci càd que quelque chose qui peut arriver notamment avec des textes par exemple donnés par un utilisateur que ce soit sur un forum, soit dans un profil ou autre.

Il y a une chose qui peut apparaître alors soit la personne par exemple a voulu copier coller un lien et des fois cédé ce sont des liens un peu spéciaux notamment sur les moteurs de recherche comme google qui est des fois des liens à rallonge avec des identifiants, plein de choses qui suivent ou alors simplement un petit rigolo qui aura tout simplement fait ceci admettons.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Modèle de boite en CSS</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg Debitis, ipsa, dolorum fugiat quae ea quaerat adipisci unde ducimus modi tenetur libero quidem tempora cupiditate voluptatibus labore neque reiciendis? Id, repellendus.</p>
	</div>
</body>
</html>
```
Voilà c'est à dire un mot qui évidemment ne veut rien dire mais avec des lettres qui sont toutes collées.

On actualise.
```txt
	+-----------+-------------+--------+
	|Lorem...<p>|	  <div>   | <body> | <html>
	|ggggggggggggggggggg      |		   |
	+-----------+-------------+--------+
```
Alors ce qui va se passer ? si j'actualise, j'ai un dépassement de la boîte c'est à dire que normalement le texte est censé bien tenir correctement dans la partie rouge et là vous voyez que là, il dépasse complètement d'accord.

Il dépassa et ça pourrait même être pire.
```txt
	+-----------+-------------+--------+
	|Lorem...<p>|	  <div>   | <body> | <html>
	|ggggggggggggggggggggggggggggggggggggggggggggggg...
	+-----------+-------------+--------+
```
Voilà imaginez un petit peu le bazar et encore pire au point d'ajouter des barres de défilement sur votre site donc ça évidemment, il ne faut absolument pas avoir ce genre de choses sur un site web puisque vous pouvez du coup déformer et détériorer tout l'affichage du site.

C'est pas agréable ça ne fait pas pro, ça fait vraiment voilà pas bon développement en tout cas derrière donc il ne faut pas faire ce genre de chose en tout cas prévoir ce genre de possibilités parce que c'est quelque chose qui peut arriver et pour cela vous avez une propriété donc pour éviter les dépassements comme ça de ces fameuses boîtes que nous avons en css, nous avons la 'overflow'.
```css
	/*
		width | min-width | max-width
		height| min-height| max-height
		
		padding:
			padding-top
			padding-right
			padding-bottom
			padding-left

		margin:
			margin-top
			margin-right
			margin-bottom
			margin-left
		
		overflow
	*/
```
Propriété overflow tout simplement tout ce qui est en surplus càd tout ce qui dépasse d'accord du parent donc de l'endroit où l'élément est mis, dans la boîte à l'intérieur de laquelle l'élément est mis, l'élément que l'on veut sur lequel on va utiliser cette propriété. Voilà on va lui dire tu vas te comporter une certaine manière d'accord alors on peut dire au navigateur de se débrouiller et on lui mettra "auto".
```css
	/*
		width | min-width | max-width
		height| min-height| max-height
		
		padding:
			padding-top
			padding-right
			padding-bottom
			padding-left

		margin:
			margin-top
			margin-right
			margin-bottom
			margin-left
		
		overflow:auto
	*/
```
On peut dire de masquer l'élément, mettra notamment la valeur "hidden" donc c'est à dire le surplus qui dépasse et on peut aussi dire d'afficher une barre de défilement "scroll" par exemple.
```css
	/*
		width | min-width | max-width
		height| min-height| max-height
		
		padding:
			padding-top
			padding-right
			padding-bottom
			padding-left

		margin:
			margin-top
			margin-right
			margin-bottom
			margin-left
		
		overflow:auto|hidden|scroll
	*/
```
Donc moi on voit que le souci de ce qui dépasse c'est le `<p>` d'accord c'est l'élément `<p>` en fait qui dépasse du `<div>` donc sur `<p>` je vais prévoir ce genre de choses : hé bien en cas de dépassement dans un paragraphe tu va par exemple cacher ce qui dépasse donc ça c'est pas forcément le mieux puisque regarder ça va couper et en fait voyez on perd de l'information pourtant si je regarde le code source, elle y est toujours. On a rien perdu, il n'y a pas de problème mais au niveau affichage pour nous, pour l'utilisateur, il manque de l'information.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		width:600px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		margin:10px;
		text-align:justify;
		overflow:hidden;
	}
```
On actualise.
```txt
	+-----------+-------------+--------+
	|Lorem...<p>|	  <div>   | <body> | <html>
	|ggggggggggg|             |        |
	+-----------+-------------+--------+
```
Ce qu'on va plutôt faire dans ce genre de cas, c'est faire un "scroll" ou un "auto" éventuellement et on aura tout simplement des barres de défilement et on retrouve toute l'info.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		width:600px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		margin:10px;
		text-align:justify;
		overflow:scroll;
	}
```
On actualise.
```txt
	+-----------+-------------+--------+
	|Lorem...<p>|	  <div>   | <body> | <html>
	|ggggggggggg#             |        |
	+##=========+-------------+--------+
```
Voilà une possibilité.

Alors 'overflow' vous pouvez également appliquer la barre de défillement que sur un seul côté càd donc overflow vous pouvez aussi le faire sur l'axe x 'overflow-x' ou l'axe y 'overflow-y'.
```css
	/*
		width | min-width | max-width
		height| min-height| max-height
		
		padding:
			padding-top
			padding-right
			padding-bottom
			padding-left

		margin:
			margin-top
			margin-right
			margin-bottom
			margin-left
		
		overflow:auto|hidden|scroll
		overflow-x
		overflow-y
	*/
```
Si je ne veux pas la barre verticale parce que au pire ça s'adapterait automatiquement en hauteur toute seul et bien je peux dire là seulement pour x tu mets un scroll, 'overflow-x'.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		width:600px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		margin:10px;
		text-align:justify;
>		overflow-x:scroll;
	}
```
On actualise.
```txt
	+-----------+-------------+--------+
	|Lorem...<p>|	  <div>   | <body> | <html>
	|ggggggggggg|             |        |
	+##=========+-------------+--------+
```
Et du coup regardez et hop voilà ça a virer la barre de défillement qu'on ne voulait pas et ça a laissé que la barre horizontale donc en x.

En y ce serait la barre verticale donc ça c'est des petites choses à savoir.

Petite dernière astuce aussi parce que là vous avez vu qu'on a simplement vue comment ça se comportaient. On ne va pas forcément par exemple changer ici le texte mais par contre on va changer la manière de l'afficher.

Nous ce qu'on peut faire c'est carrément modifier le paragraphe en lui-même et pour cela on peut utiliser 'overflow-wrap' et on va notamment se servir de "break-word".

Comme le nom l'indique, on va couper le mot, on va casser le mot à l'endroit où il aurait pu dépasser càd qu'il va se passer ça, un retour à la ligne tout simplement à chaque fois.
```css
	html
	{
		background-color:#FFF;
	}
	body
	{
		background-color:#DDD;
		width:800px;
	}
	div
	{
		background-color:#BBB;
		width:600px;
	}
	p
	{
		background-color:#c76f6f;
		width:400px;
		margin:10px;
		text-align:justify;
>		overflow-wrap:break-word;
	}
```
On actualise.
```txt
	+-----------+-------------+--------+
	|Lorem...<p>|	  <div>   | <body> | <html>
	|ggggggggggg|             |        |
	|ggggggggggg|             |        |
	|gggggg     |             |        |
	+-----------+-------------+--------+
```
Comme le nom l'indique "break-word", on va couper/casser le mot à l'endroit où il aurait pu dépasser càd qu'il y a un retour à la ligne tout simplement à chaque fois.

Et l'avantage de ce mode c'est qu'il ne va pas inséré des espaces blanc qu'il n'y avait pas donc si je m'amuse par exemple, imaginez une url, que quelqu'un récupère une url pour la copier coller et bien vous voyez que toutes les parties de l'information se suivent, il n'y a pas eu par exemple d'insertion d'espaces blancs parce qu'imaginez par exemple une url si quelqu'un fait ça, il fait un copier coller et qu'il y a un espace blanc qui s'insère dedans du coup l'url ne fonctionnera pas, il pensera du coup que le lien n'est pas valide alors que si donc dans ce genre de cas c'est bien d'avoir ça.
```txt
	ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg
```
Alors 'overflow-wrap' c'est un alias d'une propriété un peu plus ancienne mais que vous pouvez utiliser aussi, qui est toujours valide qui est 'word-wrap'.
```css
>		overflow-wrap:break-word;/* word-wrap */
```
Avant ils n'avaient pas forcément le même fonctionnement maintenant c'est le cas, plus ou moins, donc voilà on part du principe que en fait 'overflow-wrap' est un alias de 'word-wrap' d'accord et 'word-wrap' s'utilise avec "break-word" comme valeur pour dire de casser en fait à l'endroit où ça aurait pu dépasser.

Donc là on va pas changer les barres de défilement ou masquer c'est juste qu'on va tout simplement étaler, élargir en fait le contenu dans l'endroit donc dans les dimensions qu'il est censé respecter quit à devoir passer à la ligne à chaque fois c'est ce qui s'est passé là plusieurs fois 1, 2, 3, 4, 5 fois.
```txt
	+-----------+-------------+--------+
	|Lorem...<p>|	  <div>   | <body> | <html>
	|ggggggggggg|             |        |
	|ggggggggggg|             |        |
	|ggggggggggg|             |        |
	|ggggggggggg|             |        |
	|gggggg     |             |        |
	+-----------+-------------+--------+
```
On a 5 retours à la ligne pour pouvoir afficher ce long mot du coup qui n'est pas forcément évident.

Alors ça peut paraître bête mais sur beaucoup de navigateurs internet enfin beaucoup de moteurs de recherche, vous avez des fois des vraiment des liens à rallonge ou des forums ou certains sites par exemple e-commerces ou des fois ils mettent pleins pleins d'informations, des identifiants, tout ça dans l'url et c'est pas rare de se retrouver avec une url de 100, 200, 300 caractères différents et du coup bien si quelqu'un veut copier coller l'url par exemple sur un forum, sur un chat ou ce genre de choses ... si le développeur derrière n'a pas prévu ce problème avec 'overflow-wrap', 'word-wrap' et bien on aura du coup un dépassement ça peut très très très vite arrivé d'accord.

Il faut vraiment prévoir ce cas là pour éviter les déformations, les dépassements sur votre interface comme ça là on ne casse pas le design, on garde les choses au propre c'est quand même plus agréable ensuite pour l'utilisateur.

Voilà pour cette partie donc c'est une partie d'une longue série, un démarrage, une introduction si vous voulez aux modèles de boîtes puisque dans les vidéos prochaine on aura encore l'occasion d'en parler.

Là c'est vraiment ce qui constitue la base d'accords de ce cette notion à bien  comprendre d'accord donc que je peux terminer avec ce schéma qu'on a déjà montré.
```txt
					|
					| margin
		+-------------------------------+
margin	|  outline						|
--------|  +------------------------+	|
		|  |  border				|	|
		|  |  +-----------------+	|	|
		|  |  |		| padding	|	|	|
		|  |  |--- CONTENT -----|	|	|
		|  |  |		|			|	|	|
		|  |  +-----------------+	|	|
		|  |						|	|
		|  +------------------------+	|----------
		|								|
		+-------------------------------+
```
Vous avez compris les marges intérieur qui se font dans le contenu avec 'padding', les marges extérieurs avec 'margin' et dans une prochaine vidéo donc la séance qui va venir, la séance prochaine, on va parler des bordures et des contours et d'autres petites choses parmi d'autres pour compléter ça et on verra ensuite des solutions un peu plus moderne.

Peut-être que ça parlera à certaines personnes si je parle de 'box-sizing', de 'flexbox', de tout ça.

On verra ces méthodes un peu plus récentes pour justement avoir des modèles de boîtes un peu plus dynamique, un peu plus pratiques en termes de fonctionnement, en termes d'affichage de comportement tout ça notamment quand on travaille sur différentes résolutions maintenant avec le responsive, les résolutions sur mobile, sur tablette, sur télé, sur pc, etc.

C'est bien de pouvoir gérer ça de manière un peu plus dynamique, un peu plus moderne.

Voilà j'espère que cette vidéo en tout cas vous a plu, qu'elle était suffisamment complète pour cette première partie des modèles de boîtes.

S'il y a des questions des remarques, que vous êtes bloqués sur quelque chose n'hésitez pas.

Encore une fois et c'est un conseil que je donne tout le temps en html css vous avez l'avantage d'avoir des résultats visuels donc testez, mettez en pratique tout ce que vous avez vu sur ce cours.

Vous pouvez également vous exercez avec la playlist html css exercice même si au moment où je fais cette vidéo, il n'y en a pas encore beaucoup mais je complète au fur et à mesure avec plein d'exercices sur toutes les playlists que ce soit ici en html css ou dans d'autres langages ou dans d'autres voilà d'autres parties pour que vous puissiez mettre en pratique tout ce que vous avez vu dans le coup et voilà valider on va dire vos acquis pour continuer sur la suite.

N'hésitez pas évidemment et vous avez des commentaires si jamais vous êtes bloqués sur quelque chose et je viendrai vous débloquez et puis voir un petit peu avec vous, pour vous dépanner si quelque chose n'a pas été compris sur cette vidéo.

A bientôt du coup pour la suite et je vous dit la prochaine fois, on devrait aborder normalement les bordures et les contours.

A bientôt tout le monde