# [18. Styliser liste](https://www.youtube.com/watch?v=yMFEqm_8D5k)
31-01-21

Bonjour à tous, bienvenue pour un nouveau cours en html css, une vidéo très courte cette fois ci.

La dernière fois on avait vu tout ce qui était système de couleurs et couleur de fond, on avait appliquer même des images en fond sur nos sites web.

Et là je vais vous faire une petite vidéo concernant les listes.

On avait vu les listes en html et là on va voir comment styliser ces listes puisqu'il existe des propriétés css qui permettent de leur appliquer quelque chose d'assez sympathique dessus.

Alors on va reprendre un code très simple une page html avec mon fichier ici css qui va référençer et cette page là alors j'ai mis un petit peu de un petit peu de css pour une bonne partie des propriétés pour gérer évidemment la largeur de la page, tout ce qui est marge mais ça vous connaissez maintenant, pour la couleur de fond donc ce qu'on applique au `<body>` càd au corps de la page.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Mise en forme de la liste</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	
</body>
</html>
```
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
```
Alors au niveau de notre liste, on va faire une liste très simple par exemple à puce ce sera assez évident à utiliser voilà on peut faire par exemple une liste d'animaux.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Mise en forme de la liste</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>

	<p>Une liste d'animaux :</p>
	
	<ul>
		<li>Un chat</li>
		<li>Un ours</li>
		<li>Un écureil</li>
		<li>Un castor</li>
		<li>Un crocodile</li>
	</ul>

</body>
</html>
```
On va actualiser cette page web et on obtient donc notre liste à puce et c'est cette liste que nous allons utiliser avec css, je vous avait expliqué que c'est en css que nous nous occupons de la mise en forme du design de nos pages web donc de notre site et html se charge simplement d'avoir le contenu via son système de balises puisque c'est un langage de balises.
```txt
	Une liste d'animaux :

	* Un chat
	* Un ours
	* Un écureil
	* Un castor
	* Un crocodile
```
Voyez pour les listes nous avons `<ul>` ou `<ol>` selon le type de liste que vous voulez et nous avons les balises `<li>` à chaque fois que nous avons un élément de la liste donc le mieux si on veut pouvoir changer le style c'est d'appliquer le sélecteur en tout cas de choisir le sélecteur pour chacune des lignes de notre liste donc on va utiliser le sélecteur 'li' tout simplement et on va y trouver un ensemble de propriétés.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
	
	}
```
Il y a trois propriétés à connaître et une méta propriété qui permet d'utiliser les trois en une seule comme on a vu par exemple la propriété 'background' ou 'font' qu'on a vu précédemment donc pour la liste, la première ça va être de pouvoir choisir une image d'accord qui va représenter en fait cette fameuse puce.
```css
	*
```
Voyez qu'ici par défaut nous avons un disque d'accord un disque remplit de noir ici et on peut évidemment changer ça par des images si vous voulez.

Alors j'ai fait deux petites images.
```txt
	img1.png
	img2.png
```
Voyez il y a une petite croix rouge et puis une petite coche en orange, une petite flèche donc on va utiliser l'une ou l'autre à chaque fois pour voir.

La propriété css est simplement 'list-style-image' et ensuite on lui donne comme pour 'background-image', on lui donne l'url vers notre image tout simplement moi  par rapport à mon arborescence c'était ça, img1.png
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-image:url(img1.png);
	}
```
Vous pouvez avoir une image au format png ou alors au format svg vous savez l'image vectorielle qui va pouvoir du coup s'agrandir ou se rétrécir à l'infini sans perdre en qualité, sans ce pixeliser selon la taille de l'écran, de la police de caractères donc l'idéal pour ce genre de choses c'est d'utiliser un format svg mais moi pour aller plus vite je travaille directement avec des images en png.

On fait juste ça, on va actualiser et voilà ce qu'on obtient.
```txt
	Une liste d'animaux :

	x Un chat
	x Un ours
	x Un écureil
	x Un castor
	x Un crocodile
```
Voyez que ça modifie automatiquement la puce pour chacune des lignes de notre liste donc c'est très pratique.

Je peux utiliser l'autre aussi voilà pour voir un peu la différence et c'est la même chose.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-image:url(img2.png);
	}
```
Voilà ont peut comme ça adapter, puce qui est légement trop grande par rapport au texte donc évidemment en png, il faudrait adapter la hauteur de notre image par rapport à la taille que nous avons choisi pour notre texte histoire que ça colle bien ensemble si on veut faire quelque chose de plus petit, plus grand ou autre donc voilà pour l'image appliqué à nos listes.
```txt
	Une liste d'animaux :

	> Un chat
	> Un ours
	> Un écureil
	> Un castor
	> Un crocodile
```
Donc ça c'est la première chose qu'on peut faire en css.

Une autre chose que nous pouvons faire également, on verra la méta propriétés à la fin, c'est de pouvoir choisir la position donc on va utiliser 'list-style-position' alors il ne s'agit pas de faire du positionnement général mais c'est le comportement dans lequel va être la puce qui inclut la liste c'est à dire que vous pouvez choisir soit d'imaginer des sortes de boîtes en fait soit de considérer que cette ligne en fait ne peut pas être sectionner, je ne peux pas sélectionner la puce de la liste.
```txt
	Une liste d'animaux :

	> Un chat
	> Un ours
	> Un écureil
	> Un castor
	> Un crocodile
```
Avec > qui est un élément externe d'accord on a la puce qui ne fait pas partie en fait de la ligne ou alors on peut choisir de dirait que notre boîte, notre contenu, on peut imaginer une boîte elle englobe à la fois l'image qui représente la puce et ce qu'on a mis dans la liste d'accord.

C'est à dire soit vous choississez d'avoir tout ça ensemble comme un seul élément que dans une seule boîte.
```txt
	> Un chat
```
Soit vous choississez d'avoir juste ça, le texte et ça > à l'extérieur.

Je ne sais pas si vous avez bien compris mais normalement vous allez pouvoir du coup jouer là dessus.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-position:outside;
	}
```
Alors nous on va mettre "outside" et on actualise.

Voyez d'accord on a toujours notre puce qui est à l'extérieur.

On peut imaginer ici qu'on a une boîte d'accord pour mettre le le texte "un chat".
```txt
		+-------+
	*	|Un chat|	
		+-------+
```
Une autre pour "Un ours", "Un écureuil" etc et toutes ces puces en noir sont à l'extérieur de ces boîtes de texte d'accord elle n'en font pas partie.

Par défaut vous avez du outside et si vous voulez changer ce comportement vous pouvez mettre "inside".
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-position:inside;
	}
```
Et à ce moment là vous allez inclure la puce à l'intérieur alors vous visuellement vous ne voyez pas beaucoup de différence mais dans certains cas ça peut être pratique c'est à dire quand on va vouloir plus tard faire du positionnement précis parce qu'on va pouvoir positionner en fait tout cet ensemble.
```txt
	+-----------+
	|*	Un chat	|	
	+-----------+
```
C'est à dire que si on essaye par exemple d'appliquer des marges aux textes ici, si la puce en fait partie ça va décaler la puce également alors que si la puce et en extérieur ça fera une marge en fait d'espacement entre le petit cercle en noir là "*" et le début de mon texte ici "Un chat" donc ça on verra plus tard avec les marges, vous verrez comment ça fonctionne donc c'est peut-être pas forcément très intéressant, très utile pour vous pour le moment tout ce qui est position ici pour la liste mais il faut connaître c'est une des propriétés sur lesquels on peut agir avec css.

Et la dernière c'est tout simplement et ça on l'avait déjà vu c'est le style de la puce.

Si on n'utilise pas d'image on peut faire un 'list-style-type' et on peut d'ailleurs retirer le style càd que si vous voulez faire une liste à puce sans puce, vous pouvez mettre "none" d'accord.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-type:none;
	}
```
"none" qui est un mot qui fonctionne un peu partout et vous voyez que ça retire complètement l'image ici que nous avons ou en tout cas la représentation pour spécifier les puces de notre liste.

On peut également avoir d'autres valeurs, "disc" c'est la valeur par défaut d'accord par défaut sur les navigateurs.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-type:disc;
	}
```
Et on en a d'autres, on a également "square" qui est un petit carré.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-type:square;
	}
```
On assure "circle" qui est la même chose que "disc" sauf qu'il n'est pas rempli d'accord c'est juste un cercle.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-type:circle;
	}
```
Et on en a plein d'autres également alors attention, certains sont compatible avec certains navigateurs d'autres non.

Je vais vous donner principalement ceux qui marchent à priori sur tous les navigateurs pc et mobile, on a par exemple "armenian".
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-type:armenian;
	}
```
On a "georgian" finalement qui est compatible partout il me semble voilà.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-type:georgian;
	}
```
On a les caractères latins donc "lower-latin" donc c'est des caractères normals (a, b, c, d).
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-type:lower-latin;
	}
```
on a les mêmes en grec "lower-greek" (alpha, béta, etc).
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-type:lower-greek;
	}
```
Et on en a sûrement d'autres après ça va dépendre des navigateurs, il y en a qui seront compatibles, d'autres non donc ça me semble que ce soit sont compatibles après on pourrais avoir des caractères japonais par exemple "hiragana".
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-type:hiragana;
	}
```
Voyez que sur firefox, ils sont compatibles, ils ne sont pas forcément sur d'autres navigateurs donc attention.

N'hésitez pas à aller voir pour retrouver toute la liste en fait des valeurs que peut prendre "list-style-type" puisqu'il y en a vraiment beaucoup beaucoup beaucoup.

Il ne faut pas hésiter à aller voir, "katakana" aussi.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style-type:katakana;
	}
```
Il y en a pas mal comme ça, ça peut être utile dans certains cas d'avoir ces valeurs là donc n'hésitez pas à vous renseigner là dessus alors si vous voulez utiliser une ou deux ou les trois propriétés en une seule pour aller plus vite pour optimiser tout ça, vous pouvez vous servir évidemment de notre petite méta propriété qui va permettre de le gérer donc on va faire simplement un 'list-style' et là vous pouvez mettre les trois éléments qu'on a vu précédemment dans n'importe quel ordre, ils sont d'ailleurs optionnelles, vous n'êtes pas obligés de tous les mettre d'ailleurs voyez si on fait ça ça va effacer tout ok.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style:none;
	}
```
On peut mettre "square inside" d'accord on peut mettre "inside square" voilà il n'y a pas d'ordre obligatoire, l'ordre n'importe pas puisque les termes sont bien différentes évidemment css sera capable de retrouver à quoi ça correspond.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style:square inside;
	}
```
On pourrait encore une fois afficher une image plutôt que des carré.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:1000px;
	}
	
	li
	{
		list-style:square inside url(img1.png);
	}
```
Voilà vous pouvez comme ça gérer en une seule ligne, une seule propriété tout ce que nous avons vu précédemment donc voilà il n'y a pas grand chose à voir, pour les listes s'étaient assez simple il fallait que je fasse quand même une vidéo là dessus puisque les listes, les listes à puces ou les listes tout court on en a quand même beaucoup beaucoup l'usage sur les sites web donc c'est quelque chose qu'on ne peut pas passer à côté.

J'espère que ça vous aura apporté quelques petites propriétés en plus, ça fait une petite vidéo courte comme ça on va dire de pause entre 2 vidéos peut-être un peu plus longue.

J'espère que ça vous aura permis de mettre en pratique tout ça donc n'hésitez pas à vous en servir si nécessaire et on se retrouve du coup, on se retrouve pour une prochaine vidéo en html css.

A bientôt tout le monde