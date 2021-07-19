# [23. Flexbox](https://www.youtube.com/watch?v=_RiiOPQ5CcU)
07-02-21

Bonjour à tous, bienvenue pour la vingt-troisième séance en html css nous allons aborder pour terminer ce cours des notions beaucoup plus avancé et plus modernes de ces deux langages avec différentes manières de pouvoir disposer, organiser les éléments de nos pages web.

On va voir 2 méthodes d'accord, à savoir la méthode 'flexbox' qui est le sujet de cette vidéo et la méthode 'grid' donc avec des grilles que nous verrons dans la vidéo prochaine.

Ces deux méthodes comme vous allez très vite vous vous en rendre compte et très vite le voir vont permettre d'organiser notre contenu de 2 manières différentes c'est à dire que l'intérêt de ces méthodes là, de cette technique c'est de les utiliser ensemble par la suite, de ne pas forcément utiliser que 'flexbox' ou que 'grid' où vous apprendrez à bien manipuler les deux pour pouvoir les utiliser ensemble parce que elles sont exploitables véritablement ensemble pour produire vraiment du contenu enrichi.

Pour cette vidéo nous allons voir déjà 'flexbox' avec son principe premier qui est lui d'organiser des éléments à petite échelle mais vous allez très vite comprendre pourquoi.

C'est à dire que sur un site web, si on prend n'importe quel site, vous allez avoir le gabarit du site par exemple ce qui va être l'en-tête, le menu de navigation, le pied de page, la partie principal, ce genre de choses.

Toutes ces choses là qui constituent le gabarit du site d'accord le modèle général sera généralement faits et de préférence avec les 'grid' que nous verrons dans la séance prochaine.

Par contre à l'intérieur de ces différentes sections, de ces différentes parties, quand on voudra organiser des éléments par exemple ça peut être des images, des paragraphes, ce genre de choses, on pourra très volontiers utilisé justement la méthode 'flexbox' qui permettra d'organiser ces différents contenus et c'est ce que nous allons voir aujourd'hui.

Alors 'flexbox' d'accord comme je l'ai très très vite expliqué ça va nous permettre d'organiser différents contenus on va dire à petite échelle donc là on va travailler vous allez voir sur un conteneur c'est à dire qu'on va voir ici un conteneur et à l'intérieur de ce conteneur différents éléments et je vais vous montrer un petit schéma pour que vous ayez un petit peu l'illustration de tout ça.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item">ELEMENT DEBUT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT FIN</div>
	</div>
</body>
</html>
```
Donc voilà comment ça va se passer donc il va y avoir beaucoup de propriétés que vous allez voir dans cette vidéo.

Comme je ne voulais pas la faire forcément en deux trois quatre parties parce que ça ne servirait pas à grand chose, autant qu'il n'y ait qu'une seule vidéo où on aborde absolument toute la notion comme ça vous aurez quelque chose de complet.

N'hésitez pas à mettre sur pause si nécessaire, à prendre des notes et à tester en même temps d'accord mettre en pause la vidéo pour tester de votre côté sur vos codes, vos navigateurs et de voir un petit peu le résultat que ça donne pour mieux comprendre tout ce que je vais vous montrer aujourd'hui.

Alors le principe déjà à savoir au niveau de 'flexbox' et 'flexbox' va travailler que dans une seule direction à la fois, là où les 'grid' comme on le verra plus tard permettent de travailler à la fois en horizontal, en vertical comme un tableau par exemple on aurait des lignes et des colonnes en même temps donc on travaillerait en fait sur deux dimensions plus ou moins et 'flexbox' qui va travailler que sur une seule direction à la fois. On travaillera soit à l'horizontale soit à la verticale mais pas les deux en même temps.

C'est pour ça qu'une méthode ne peut pas compléter toutes les manières de concevoir un design mais que là où il y a un intérêt c'est d'utiliser les deux comme vous saurez le faire de toute façon plus tard avec tout ce que vous aurez vu.

Alors au niveau du schéma, on va commencer par ça déjà. On va voir au niveau d'un petit chemin que je vous ai fait là.

![flexbox.JPG](flexbox.JPG)
<!--
	FLEXBOX CSS
	
	Axe principal
A	+---------------------------------------- >
x	| +--------------------------------------+
e	| | +----------++----------++----------+ |
	| | | Objet	   || Objet	   || Objet	   | |
s	| | | flexible || flexible || flexible | |
e	| | | (flex    || (flex    || (flex    | |
c	| | | -item)   || -item)   || -item)   | |
o	| | +----------++----------++----------+ |
n	| | conteneur flexible (flex-container)	 |
d	| +--------------------------------------+
a	|
i	|
r	|
e	|
	v
-->
Pour illustrer un petit peu le principe de 'flexbox' nous allons avoir un conteneur, un conteneur flexible d'accord qu'on appelle via le terme anglais "flex-container". C'est ce que j'ai représenté ici en bleu et on fera un petit peu le même jeu de couleurs pour nos tests au niveau du code et à l'intérieur nos éléments donc nos objets flexible les "flex-item" d'accord qui sont ici représentés en rouge.

Pour définir ça nous avons un axe principal d'accord qui est donc tout simplement comme on le voit ici la largeur du conteneur càd l'espace qu'il va occuper et éventuellement un axe secondaire par rapport à l'espace qu'il occupera en hauteur ok donc tout ça c'est un petit schéma que vous pouvez garder.

Voilà ce qu'il faut garder en tête au niveau de la représentation.

Au niveau du code comment ça va se représenter, le fameux conteneur qu'on a en bleu ici "conteneur flexible (flex-container)"conteneur flexible (flex-container)", moi j'ai choisi volontairement de le mettre dans une `<div>` avec une classe particulière. Vous pourriez mettre ça dans une autre balise structurante, il n'y aurait aucun problème donc une balise de type bloc pour le coup ici.
```html
	<div class="container">
		...
	</div>
```
Et nos différents "Flex-item" sont représentés ici par d'autres `<div>` mais qui auront une autre classe ok.
```html
		<div class="cont-item">ELEMENT DEBUT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT FIN</div>
```
Et pour qu'il n'y ait pas rien à l'intérieur, j'ai mis un petit texte d'exemple. Il faut savoir que pour simplifier je mets juste un petit mot (ELEMENT DEBUT...) et vous pourrez plus tard avoir des images, avoir des paragraphes, avoir des listes, des formulaires, n'importe quoi.

Il s'agit vraiment de boîtes flexibles dans lequel nous pour mettre tout ce que vous avez appris à faire en HTML.

A partir de là nous allons appliquer donc un style par la suite pour utiliser justement la méthode 'flexbox'.

Alors de base mon fichier css j'ai simplement bon une petite couleur de fond, j'ai centré le contenu et j'ai utilisé toute la largeur disponible de mon écran pour la largeur du site voilà.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}
```
Donc au niveau du rendu de base on obtient ceci tout simplement.
```txt
	ELEMENT DEBUT
	ELEMENT
	ELEMENT
	ELEMENT
	ELEMENT
	ELEMENT FIN
```
Comme ce sont tous des éléments mis dans des `<div>` donc des boîtes de type bloc, ils se mettent les uns à la suite des autres d'où le fait d'avoir quelque chose qui à l'air est réparti en colonnes d'accord

Au niveau de 'flexbox' pour changer un petit peu le comportement de notre navigateur, nous allons changer la méthode d'affichage pour ça alors la méthode d'affichage va s'appliquer sur le conteneur donc celui où j'ai donné une classe ici "container" donc je vais reprendre cette classe là et je vais l'utiliser comme sélecteur ici.
```css
	.container
	{}
```
On va lui mettre une couleur de fond, ça c'est pour vous, pour que vous puissiez mieux l'identifier au niveau du rendu mais ce n'est évidemment pas obligatoire, quand vous ferez un vrai site avec un vrai design, avec certaines parties en 'flexbox' vous n'allez pas forcément vous amuser à mettre une coureur de fond différente pour chaque chose et je le mets pour vous.
```css
	.container
	{
		background-color:rgb(113,155,245);
	}
```
Qu'est-ce qu'on peut mettre aussi ? hé bien on va mettre la méthode d'affichage, on va changer le type d'affichage alors vous pouvez mettre avec display "flex" d'accord le mode normal et vous avez bien évidemment "inline-flex" donc c'est du flexible mais en mode in line comme on avait vu la différence entre display "bloc" et display "inline" donc je ne reviendrai pas dessus c'est des choses que nous avons déjà abordé donc nous on va passer en mode "flex" donc là on va travailler avec un comportement dit flexbox donc avec des boîtes flexible au niveau de nos pages web.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
>		display:flex;
	}
```
Juste avec cette propriété là en actualisant ma page j'obtiens ceci.
```txt
	ELEMENT DEBUTELEMENTELEMENTELEMENTELEMENTELEMENT FIN
```
Tous nos éléments se mettent les uns à la suite des autres d'accord donc on a ELEMENT DEBUT puis tous les éléments se mettrent comme ça.

Ce qu'on va faire pour mieux les identifier aussi, on va reprendre comme sélecteur ici la classe pour nos items d'accord "flex-item" et on va leur mettre une couleur aussi et on va mettre plutôt une couleur rouge.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
	}
```
Voilà et on pourra mettre une bordure aussi c'est pour que vous puissiez mieux l'identifier de votre côté et voyez que ce sont bien des éléments distincts et voilà ça devrait être suffisant.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
Donc on fait ça, j'actualise et voilà.
```txt
	+---------------------------------------------------------+
	|ELEMENT DEBUT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT FIN|
	+---------------------------------------------------------+
```
Ca fait comme des cellules d'un tableau en fait qui pour le coup ici serait sur une seule ligne mais voilà comment ça fonctionne et on se rend bien compte qu'on a donc nos différents items ici, nos différents objets qui sont à l'intérieur d'un conteneur.

Le conteneur fait évidemment toute la largeur puisque j'ai appliqué comme on l'avait vu ici une largeur de 100%.
```css
	body
	{
		width:100%;
	}
```
Donc ça prend 100 % mon écran.

D'ailleurs si je joue un petit peu sur la largeur, on voit que le conteneur ici change.
```txt
	+-----------------------------------------------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|DEBUT	|       |       |       |       |FIN	|
	+-----------------------------------------------+
```
Il ne s'agit pas de faire un design adaptatif c'est à dire qu'il va s'adapter de manière automatique par rapport à la résolution de votre écran, ça c'est ce qu'on verra dans le dernière dans la dernière séance de ce cours.

On terminera la formation html css avec le responsive design mais en tout cas vous voyez un petit peu le principe ici pour "flexbox".

Alors ça c'est vraiment le comportement par défaut, on va évidemment pouvoir changer tout un tas de choses on va pouvoir modifier le comportement du conteneur d'accord la manière dont il organise dont il définit les choses donc ça peut être la disposition des éléments, les espaces.

Voyez qu'on pourra ici éventuellement créer tout un tas de choses et on aura bien évidemment possibilité de modifier le comportement des objets qui sont à l'intérieur de notre conteneur donc deux choses possibles.

Et ses comportements pourront également influéent sur l'axe principal, la répartition donc ici ou l'axe secondaire éventuellement.

![flexbox.JPG](flexbox.JPG)
<!--
	FLEXBOX CSS
	
	Axe principal
A	+---------------------------------------- >
x	| +--------------------------------------+
e	| | +----------++----------++----------+ |
	| | | Objet	   || Objet	   || Objet	   | |
s	| | | flexible || flexible || flexible | |
e	| | | (flex    || (flex    || (flex    | |
c	| | | -item)   || -item)   || -item)   | |
o	| | +----------++----------++----------+ |
n	| | conteneur flexible (flex-container)	 |
d	| +--------------------------------------+
a	|
i	|
r	|
e	|
	v
-->
Donc tout ça, vous allez le voir dans cette vidéo et vous aurez comme ça quelque chose de complet.

Maintenant qu'on a notre mise en page faite sous forme de boîtes flexible, on va voir tout ce qui est possible de faire au niveau comportement donc deux types encore une fois de modifications de comportement soit sur le conteneur, donc on va du coup travailler sur le sélecteur via notre conteneur soit sur les objets ou même des fois un objet en particulier par exemple on pourra appliquer un comportement exclusivement à cet objet la du conteneur et pas les autres.
```html
	<div class="container">
		<div class="cont-item">ELEMENT DEBUT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
>		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT FIN</div>
	</div>
```
Ca on pourra éventuellement le faire si on veux donc on va commencer par les choses les plus simples, je vous noterais rapidement les propriétés pour ceux qui veulent les prendre en note au fur et à mesure pour pas pour pas se perdre donc je noterais juste les noms.

Alors déjà on travaille en display "flex" ou (|).
```css
	/*
		display:flex|
	*/
```
Donc si je mets ça | c'est à dire que vous devez mettre une seule des valeurs que je propose quand je mets une barre verticale, ou éventuellement alors ça peut être "inline-flex" comme ça où comme ça "inline flex" parce qu'on peut utiliser à la fois "inline" et "flex" mais là c'est un raccourci en fait pour les deux.
```css
	/*
		display:flex|inline-flex
	*/
```
Voilà donc on travaille en display comme ça et on va avoir une première propriété qui est 'flex-direction'.
```css
	/*
		display:flex|inline-flex
		
		flex-direction
	*/
```
'flex-d irection' va tout simplement permettre de choisir la direction, l'orientation des éléments du conteneur on va le mettre ici puisque c'est sur le conteneur qu'on va appliquer un comportement défini, spécifiques et avec une certaine valeur particulière.
```css
	.container
	{
		flex-direction:;
	}
```
D'ailleurs je peux vous mettre les valeurs et après on va les montrer.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
	*/
```
Par défaut ça paraît un petit peu logique, l'orientation de nos éléments se fait en ligne "row" d'accord.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
	*/

	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		flex-direction:row;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
Donc si je mets "row" c'est ce que j'ai déjà donc j'aurais évidemment pas de changement si je mets en revanche "row-reverse" je vais inverser l'alignement.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
	*/

	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		flex-direction:row-reverse;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+---------------------------------------------------------+
	|ELEMENT FIN|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT DEBUT|
	+---------------------------------------------------------+
```
Donc là, regardez l'élément qui s'appelle ELEMENT DEBUT va se retrouver à la fin, ELEMENT FIN se retrouve au début.

On a vraiment inverser cela mais les autres ELEMENT ont le même texte donc vous ne vous en êtes pas rendu forcément compte de l'inversion mais ils ont également été inversés en réalité.

Si j'avais mis des couleurs différentes pour chaque boîte, on aurait vu que chaque boîte s'était mise à l'envers.

Voilà comment que ça se passe pour ça et donc on va revenir à "row" comme c'était au départ donc ça c'est par défaut et on peut bien sûr prévoir l'orientation sous forme de "column".
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
	*/

	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		flex-direction:column;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
Voyez on ne peut pas faire les 2, on ne peut pas dire "row" et " column" en même temps, on ne peut pas dire c'est en ligne et en colonne à la fois, on ne travaillera pas sur les deux directions, ça on pourra le faire plus tard avec les 'grid' pour 'flexbox' son principe c'est de travailler simplement sur un seul type d'alignement.
```txt
	+---------------+
	|ELEMENT DEBUT	|
	+---------------+
	|ELEMENT		|
	+---------------+
	|ELEMENT		|
	+---------------+
	|ELEMENT		|
	+---------------+
	|ELEMENT		|
	+---------------+
	|ELEMENT FIN	|
	+---------------+
```
Donc il a cette forme là et bien sûr on peut faire à l'envers "column-reverse".
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
	*/

	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		flex-direction:column-reverse;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+---------------+
	|ELEMENT FIN	|
	+---------------+
	|ELEMENT		|
	+---------------+
	|ELEMENT		|
	+---------------+
	|ELEMENT		|
	+---------------+
	|ELEMENT		|
	+---------------+
	|ELEMENT DEBUT	|
	+---------------+
```
Et là vous voyez que l'éléments au début passe à la fin, même principe, très simple d'accord vraiment très très simple pour modifier l'orientation des éléments de notre conteneurs avec cette petite propriété là simplement.

Alors ça c'est une chose et on va voir plusieurs éléments mais admettons qu'un moment donné j'ai plus d'éléments que ça par exemple une galerie d'image on aurait tout un tas d'images à la suite des autres donc là je vais tricher un petit peu, on va rajouter des éléments puisque mes blocs ne font pas énormément en largeur. 

Voilà j'en met vraiment plein.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item">ELEMENT DEBUT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT FIN</div>
	</div>
</body>
</html>
```
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
	*/

	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		flex-direction:row;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+------------------------------   --------------------+
	|ELEMENT DEBUT|ELEMENT|ELEMENT|...|ELEMENT|ELEMENT FIN|
	+------------------------------   --------------------+
```
Donc on imagine que ce sont là plusieurs éléments et vous voyez que là comme ça dépasse comme il n'y a plus assez de place pour chacun des éléments puisque voyez qu'on ne va pas couper le texte en fait, on ne va pas faire de cessures au niveau du texte, on obtient directement une barre de défilement horizontal pour faire passer tous les éléments puisqu'encore une fois on ne travaillera de toute façon que sur un seul alignement mais même s'il s'agit que d'une seule ligne et qu'elle travaille que sur une seule direction qu'on ne peut pas la disposer sur une autre c'est à dire on peut très bien couper cette ligne pour en faire une seconde pour avoir en fait quelque chose répartis sur plusieurs niveaux.

Et pour ça comme on pourrait couper un mot avec break word `<wbr>`, words wrap ce genre de choses, on va pouvoir faire la même chose avec nos boîtes flexible grâce à la propriété 'flex-wrap' donc par défaut la valeur c'est "nowrap" càd qu'on laisse comme c'est tel que ça se passe actuellement au niveau du rendu. On aura ensuite avec une coupure "wrap" et après toujours pareil à l'envers "wrap-reverse".
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
	*/
```
Donc toujours sur le conteneur "container" d'accord nous travaillons toujours sur la grande boîte ici qui contient tout donc ici flex-wrap:nowrap; donc ça c'est le comportement par défaut.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
	*/

	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		flex-wrap:nowrap;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
Si j'actualise, on voit rien de différent.
```txt
	+------------------------------   --------------------+
	|ELEMENT DEBUT|ELEMENT|ELEMENT|...|ELEMENT|ELEMENT FIN|
	+------------------------------   --------------------+
```
Et si je veux que ça coupe la ligne pour passer en dessous, je vais mettre le mot "wrap".
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
	*/

	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		flex-wrap:wrap;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-------------------------------------------+
	|ELEMENT DEBUT|ELEMENT|ELEMENT|ELEMENT|		|
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|	|
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|	|
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|	|
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT FIN|		|
	+-------------------------------------------+
```
Et là vous voyez on obtient ça d'accord donc là vous avez déjà remarqué quelque chose c'est que tout à l'heure nos éléments occupaient un certain espace et là vous voyez le conteneur c'est adaptés automatiquement d'accord à la hauteur qu'il avait besoin.

Alors en "nowrap" on pourrait penser que ça prend 2 lignes pourquoi ? comme ELEMENT DEBUT c'est en deux mots ici l'espace peut être coupé.
```txt
	+-----------------------------------------------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|DEBUT	|       |       |       |       |FIN	|
	+-----------------------------------------------+
```
C'était vrai d'ailleurs que j'aurais pu ne pas mettre ELEMENT DEBUT et ELEMENT FIN maintenant c'était surtout au début que ça pouvait être utile de laisser mais là on va l'enlever pour que ce soit encore plus clair.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
	</div>
</body>
</html>
```
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
	*/

	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		flex-wrap:nowrap;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
J'actualise
```txt
	+------------------------------   --------------------+
	|ELEMENT DEBUT|ELEMENT|ELEMENT|...|ELEMENT|ELEMENT FIN|
	+------------------------------   --------------------+
```
Donc vous voyez là on a vraiment juste la hauteur nécessaire pour afficher le mot à chaque fois par contre dès que je vais ici changer le mode de coupure donc en fait de la ligne, il passe à la ligne suivante mais c'est toujours la même, il s'agit que d'une seule ligne mais qui du coup passe en dessous, qui est coupé à un certain moment au niveau des éléments et automatiquement le conteneur s'adapte d'accord il déduit un petit peu la hauteur qu'il a besoin pour accueillir tout ces éléments fils.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
	*/

	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		flex-wrap:wrap;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|				|
	+-----------------------------------------------+
```
Automatiquement le conteneur s'adapte et comme un conteneur flexible tous ces éléments fils deviennent automatiquement des "flex-item" d'accord des objets flexible et bien il est capable de tout déduire. Le navigateur est capable de vraiment faire des calculs automatiquement sans que vous ayez besoin de les faire pour récupérer, englober tous les éléments.

Voilà ce que nous avons ici donc ça c'est à connaître et l'inverse bien sûr vous obtiendrez ceci d'accord sans surprise.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
	*/

	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		flex-wrap:wrap-reverse;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|				|
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-----------------------------------------------+
```
C'est une coupure mais à l'envers, en fait la dernière ligne c'est le début de notre ligne et la suite viens au dessus tout simplement donc c'est comme si on avait inversé les deux lignes.

Voilà pour cette petite propriété très importante à connaître aussi.

Si vous avez besoin d'utiliser ces deux propriétés en même temps pour changer le comportement au niveau du "container", vous pouvez aller plus vite en utilisant directement 'flex-flow' d'accord.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow
	*/

	body
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
'flex-flow' ça prend tout simplement la direction entre chevrons pour vous dire que ça `<direction>` en fait faut le remplacer par une des valeurs ici de 'flex-direction' et un espace et vous mettez ensuite une des valeurs de 'flex-wrap' d'accord.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
	*/
```
Vous écrivez tout simplement par exemple si on veut sous forme de lignes mais on veut que ce soit coupé ben on mettra ceci, on mettra "row wrap" mais bon comme ça c'est par défaut ce ne serait pas forcément utile.
```css
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		flex-flow:row wrap;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
Donc ce serait utile à ce moment là en faisant à la rigueur ceci "row-reverse wrap".
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		flex-flow:row-reverse wrap;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
Comme ça on utilise les deux et on optimise un petit peu notre fichier
css au lieu d'utilisé deux propriétés on en a ici une seule qui rassemble les deux donc ça c'est à connaître aussi, c'est pas mal utile.

Voilà pour les comportements spécifiques que l'on peut faire sur notre conteneur et qui sont assez basiques, on reste sur des choses assez basique, assez simple à comprendre.

On va passer à un stade un petit peu plus au dessus maintenant avec les alignements d'accord l'alignement en fait de ce que nous avons par rapport à nos objets, à notre contenu général.

On va pouvoir travailler donc sur l'alignement principal c'est-à-dire l'alignement sur cet axe là.

![flexbox.JPG](flexbox.JPG)
<!--
	FLEXBOX CSS
	
	Axe principal
A	+---------------------------------------- >
x	| +--------------------------------------+
e	| | +----------++----------++----------+ |
	| | | Objet	   || Objet	   || Objet	   | |
s	| | | flexible || flexible || flexible | |
e	| | | (flex    || (flex    || (flex    | |
c	| | | -item)   || -item)   || -item)   | |
o	| | +----------++----------++----------+ |
n	| | conteneur flexible (flex-container)	 |
d	| +--------------------------------------+
a	|
i	|
r	|
e	|
	v
-->
La disposition vous voyez qu'ici par exemple on a des espaces en fonction.

Voyez que le comportement par défaut c'est ça.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
	</div>
</body>
</html>
```
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
	*/
	
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-------------------------------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------------------------------+
```
Le comportement par défaut c'est par rapport à l'axe principal donc l'axe horizontal on voit que tous les éléments sont collés les uns aux autres et ils sont à gauche de notre conteneur d'accord ils ne sont pas centrés, ils ne sont pas à droites, ils ne sont pas répartis équitablement c'est le comportement par défaut.

Et au niveau verticale donc le fameux axe secondaire c'est la même chose, on a juste les éléments qui sont placés au plus haut donc c'est pour ça qu'on a une hauteur qui fait tout juste l'espace qu'il faut ici pour notre nos éléments y compris avec leurs bordures. Il faut compter la bordure de 1 pixel donc on a 1 pixel en haut, 1 pixels en bas mais tout ça est compté automatiquement. Nous on s'embête pas à calculer, le navigateur fait tout à notre place de manière automatique.
```txt
	+-------------------------------+---------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------------------------------+
	|
	|
```
Alors à partir de là on va pouvoir modifier également ces comportements.

Première propriété pour jouer sur l'axe principal c'est 'justify-content' qui va nous permettre de répartir nos éléments sur l'axe horizontal, le fameux axe principal.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start
	*/
```
Le comportement par défaut c'est "flex-start" comme valeur que je vais mettre ici.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start
	*/
	
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		justify-content:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
"flex-start" ça veut tout simplement dire au début d'accord du containeur flexible au départ ELEMENT DEBUT donc c'est effectivement ce qui se passe.

Si je fais linverse "flex-end" en toute logique on se placera à la fin du conteneur.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end
	*/
	
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		justify-content:flex-end;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	------+-------------------------------+
	      |ELEMENT|ELEMENT|ELEMENT|ELEMENT|
		  +-------------------------------+
										  |
```
Voyez comme ça se passe.

On a évidemment la possibilité de centrer tout ça et là c'est plus simple. La valeur c'est juste "center".
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center
	*/
	
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		justify-content:center;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+--+-------------------------------+--+
	|  |ELEMENT|ELEMENT|ELEMENT|ELEMENT|  |
	|  +-------------------------------+  |
	|									  |
```
Là on centre nos éléments d'accord quoi qu'il arrive même si on change la largeur voyez ça reste toujours parfaitement centré il n'y a pas de problème là dessus et on va pouvoir maintenant définir éventuellement des espaces donc pour ça nous avons par exemple la valeur "space-between" qui permet des espaces entre donc entre nos éléments.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between
	*/
	
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		justify-content:space-between;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-------+-+-------+-+-------+-+-------+
	|ELEMENT| |ELEMENT| |ELEMENT| |ELEMENT|
	+-------+-+-------+-+-------+-+-------+
	|									  |
```
Donc on obtient ceci, voyez le premier est tout collé à gauche, le dernier tout collé à la fin du conteneur. On ne va pas dire à gauche, à droite parce que ce ne serait pas forcément logique mais on va plutôt dire au début du conteneur et à la fin du conteneur et les autres voyez se répartissent comme il faut pour que les espaces soient égaux à chaque fois.

Si on veut des espaces partout d'accord autour de tous nos éléments, on mettra "space-around" qui veut dire des espaces tout autour donc à la fois entre, et autour de.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around
	*/
	
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		justify-content:space-around;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
  ++-------+-+-------+-+-------+-+-------++
  ||ELEMENT| |ELEMENT| |ELEMENT| |ELEMENT||
  ++-------+-+-------+-+-------+-+-------++
  |									      |
```
Voilà donc là voyez ces espaces là sont équitables, sont égaux mais ici on a du coup la place qui est resté par rapport à la largeur de mon écran, vous n'aurais pas forcément les mêmes dimensions si vous êtes sur un écran plus petit ou plus grand évidemment.

Mais ici c'est diviser en deux pour récupérer l'espace nécessairement et si on veut absolument que des espaces égaux et bien on peut utiliser la valeur "space-evenly" et là ils seront absolument égaux partout partout et compris entre les éléments et à l'extérieur voilà donc tous les espaces-là en bleu sont les mêmes partout.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
	*/
	
	{
		background-color:#EEE;
		margin:auto;
		width:100%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		justify-content:space-evenly;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
  +-+-------+-+-------+-+-------+-+-------+-+
  | |ELEMENT| |ELEMENT| |ELEMENT| |ELEMENT| |
  +-+-------+-+-------+-+-------+-+-------+-+
  |									  		|
```
Pareil si je redimensionne on voit que tout s'adapte, pas de souci à ce niveau-là.

Voilà pour cette partie.

Donc ça c'était juste pour l'alignement sur l'axe principal ok.

![flexbox.JPG](flexbox.JPG)
<!--
	FLEXBOX CSS
	
	Axe principal
A	+---------------------------------------- >
x	| +--------------------------------------+
e	| | +----------++----------++----------+ |
	| | | Objet	   || Objet	   || Objet	   | |
s	| | | flexible || flexible || flexible | |
e	| | | (flex    || (flex    || (flex    | |
c	| | | -item)   || -item)   || -item)   | |
o	| | +----------++----------++----------+ |
n	| | conteneur flexible (flex-container)	 |
d	| +--------------------------------------+
a	|
i	|
r	|
e	|
	v
-->
On va pouvoir maintenant travailler sur un alignement, sur l'axe secondaire mais pour que vous vous en rendez compte au niveau rendu parce que c'est là aussi le souci pour moi en tout cas au niveau de la vidéo parce qu'il faut que je pense à trouver des bons exemples pour que vous le voyez visuellement ce qui n'est pas forcément pratique sachant que là on a juste des petites boîtes de couleur et pas des vrais ... on ne travaille pas sur un vrai site web donc ce n'est pas forcément très pratique.

Ce qu'on va faire pour que vous le voyez, on va juste mettre une hauteur à notre conteneur donc normalement par défaut on va avoir ceci.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
	*/
	
	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		height:200px;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-------------------------------+---------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	+-------------------------------+
	|
	|
```
Voilà comme ça on se rend bien compte d'accord de ce qui va se passer donc le comportement par défaut voyez ce qu'on obtient alors après ça pas forcément tous les navigateurs appliquerait ça par défaut mais moi ici sur firefox on voit que il affiche par défaut tout ça.

Voyez que les blocs ici prennent vraiment toute la hauteur du contenu donc si j'ai mis un conteneur de 800 pixels bas à priori mes éléments ici aurait 800 pixels également de hauteur en prenant en compte bien sûr les bordures.

Là où on va modifier ça c'est avec non pas 'justify-content' mais avec 'align-items'.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:
	*/
```
Alors les noms là ça devient un peu plus compliqué parce que ceux qui ont qui ont créé ces propriétés ont choisi ces termes là mais c'est vrai que ces termes-là ne sont pas forcément très explicite parce que là on travaille sur le conteneur parce qu'on va le faire ici dans le .conteneur d'accord mais on parle des objets donc on aurait plus tendance à penser que 'align-items' c'est une propriété utilisé sur les items alors que non ces le .container puisqu'on parle de tous les objets.

Comme ce n'est pas un objet précis lui-même voilà tous les objets concernent donc le conteneur en fait.

Attention au niveau des noms et c'est pour ça que je vous les note parce qu'au début vous aurez peut-être des mélanges dans les noms, vous oublierez des lettres etc et ce sera peut-être un peu confus.

Donc 'align-items' on va le mettre ici et on voit que le comportement par défaut ici en tout cas sur tout les navigateurs c'est celui-là "stretch".
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:200px;
>		align-items:stretch;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
"stretch" ça veut tout simplement dire bien tu t'étale, en fait tu t'étire sur tout l'espace disponible et comme ici mon conteneur fait 200 pixels de haut et bien sur l'axe secondaire qui est ici sur l'axe vertical, il va occuper tout l'espace.

![flexbox.JPG](flexbox.JPG)
<!--
	FLEXBOX CSS
	
	Axe principal
A	+---------------------------------------- >
x	| +--------------------------------------+
e	| | +----------++----------++----------+ |
	| | | Objet	   || Objet	   || Objet	   | |
s	| | | flexible || flexible || flexible | |
e	| | | (flex    || (flex    || (flex    | |
c	| | | -item)   || -item)   || -item)   | |
o	| | +----------++----------++----------+ |
n	| | conteneur flexible (flex-container)	 |
d	| +--------------------------------------+
a	|
i	|
r	|
e	|
	v
-->
Absolument tout l'espace qui est disponible pour lui mais si vous ne voulez pas faire ça, que vous voulez juste garder l'espace par rapport à ce que vous avez dans vos éléments vous pouvez bien sûr utiliser "flex-start".
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:200px;
>		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	+-------------------------------+
	|
	|
```
On fait "flex-start" et voilà comment que ça se passe.

Comme ici dans nos objets on a juste un seul mot hé bien il n'y a pas besoin de plus de place que ça donc vous voyez que ça se met ici donc là on travaille plus sur l'axe principal qui est horizontale, on travaille vraiment sur l'axe secondaire qui est vertical.

C'est très important de retenir ça, c'est pour ça que pour le coup, j'applique une hauteur pour le conteneur sinon ça se serait arrêté là et on n'aurait pas vu la différence.

Si on fait l'inverser, on retrouve toujours voyez comme pour 'justify-content' on retrouve la même valeur ici "flex-end" et on y va voilà.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:200px;
>		align-items:flex-end;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	+-------+-------+-------+-------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------------------------------+
	|
	|
```
Voilà ça se met à la fin d'accord de l'axe secondaire donc logique au plus bas.

On va avoir comme pour tout à l'heure "center" donc là c'est centré ok.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:200px;
>		align-items:center;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	+-------+-------+-------+-------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|
```
Et là c'est centré.

"stretch" même si je vous l'ai déjà montré, c'est le comportement par défaut que j'ai sur mon navigateur.
```css
	.container
	{
>		align-items:stretch;
	}
```
```txt
	+-------------------------------+---------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	+-------------------------------+
	|
	|
```
Voyez ça fait un remplissage complet donc ça évite d'avoir par exemple admettons d'avoir ça, si on met un comportement par défaut "flex-start" voilà ce qu'on aurait.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item">ELEMENT<br>ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
	</div>
</body>
</html>
```
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:200px;
>		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|ELEMENT|		|		|		|
	|-------|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	+-------------------------------+
	|
	|
```
Selon les boîtes, elles ne s'arrêterait pas forcément toutes au même endroit et sur certains design des fois pour certaines parties ça pourrait être gênant d'avoir ça. On aimerait que tous les éléments comme ça se complète en fait tous à même hauteur donc sur le même axe donc à ce moment là c'est tout l'intérêt d'utiliser "stretch" puisque tous les éléments vont s'adapter en fait à celui qui est le plus grand en hauteur et la hop ils vont prendre vraiment tout le conteneur.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:200px;
>		align-items:stretch;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|ELEMENT|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	|		|		|		|		|
	+-------------------------------+
	|
	|
```
Si évidemment on ne va faire ça ben il suffirait d'enlever height:200px; et faire ça voilà.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		align-items:stretch;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|ELEMENT|		|		|		|
	+-------+-------+-------+-------+---------
	|
	|
```
D'accord ça prend juste la place qu'il faut.

Comme j'ai rajouté un hauteur fixe donc automatiquement il remplit toute la hauteur fixé.

Ok pour ça.

D'ailleurs je ne suis pas obligé de faire 200px, 100px c'est déjà bien.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
>		height:100px;
		align-items:stretch;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|ELEMENT|		|		|		|
	|		|		|		|		|
	+-------+-------+-------+-------+---------
	|
	|
```
Alors là où ça peut être utile aussi, je n'ai pas forcément montré c'est si on met par exemple une direction sous forme de colonne on aurait ça.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
>		flex-direction:column;
		align-items:stretch;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------
	|ELEMENT
	|ELEMENT
	+-----------------------------------------
	|ELEMENT
	+-----------------------------------------
	|ELEMENT
	+-----------------------------------------
	|ELEMENT
	+-----------------------------------------
	|
	|
```
Alors il y a énormément de choses que je peux vous montrer avec 'flexbox', je ne pourrais pas forcément pensé à tous les cas de figure dans la vidéo c'est juste impossible on pourrait écrire un livre complet sur 'flexbox' tellement qu'il y a des possibilités mais voilà un petit peu comment ça se passe.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
>		flex-direction:column;
>		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-------+----------------------------------
	|ELEMENT|
	|ELEMENT|
	+-------+----------------------------------
	|ELEMENT|
	+-------+----------------------------------
	|ELEMENT|
	+-------+----------------------------------
	|ELEMENT|
	+-------+----------------------------------
	|
	|
```
Evidemment là ça se passe comme si c'était sur la ligne puisque comme on a disposé sous forme de colonne l'axé principal c'est comme c'était celui-là.
```txt
	+-------+
	|ELEMENT|
	|ELEMENT|
	+-------+
	|ELEMENT|
	+-------+
	|ELEMENT|
	+-------+
	|ELEMENT|
	+-------+
	|
	|
```
Et l'axe secondaire devenait l'axe horizontal, on a une inversion mais c'est normal puisqu'on a inversé l'orientation de nos éléments d'accord on a une direction sous forme de colonne donc je pense que vous l'aurez compris, si on inverse la direction on inverse automatiquement les spécifications des alignements ça paraît logique.

Donc on va revenir sur un truc comme ça de base et voilà et après "stretch" parce qu'on n'a pas forcément que ça, on va également travailler avec "baseline" comme ceci.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
	</div>
</body>
</html>
```
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
>		align-items:baseline;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
## "baseline"
```css
>		align-items:baseline;
```
```txt
	+-----------------------------------------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+-------+-------+-------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+-------+---------------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+
	|ELEMENT|
	+-------+
	|
	|
	+-----------------------------------------
	|
	|
```
## "flex-start"
```css
>		align-items:flex-start;
```
```txt
	+-----------------------------------------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+-------+-------+-------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+-------+---------------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+
	|ELEMENT|
	+-------+
	|
	|
	+-----------------------------------------
	|
	|
```
## "flex-end"
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
>		align-items:flex-end;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+-------+-------+-------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+-------+---------------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+
	|ELEMENT|
	+-------+
	|
	|
	+-----------------------------------------
	|
	|
```
## "center"
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
>		align-items:center;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------
	|
	+-------+-------+-------+-------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+-------+-------+-------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+-------+---------------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+
	|ELEMENT|
	+-------+
	|
	+-----------------------------------------
	|
	|
```
Ca agit vraiment sur l'ensemble, ça agit vraiment comme s'il n'y avait qu'une seule ligne, on est vraiment sur ce type de comportement là.

## "stretch"
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
>		align-items:stretch;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-------+-------+-------+-------+---------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|		|		|		|		|
	+-------+-------+-------+-------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|		|		|		|		|
	+-------+-------+---------------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	|		|		|		|		|
	+-------+-------+-------+-------+
	|ELEMENT|
	|		|
	+-------+---------------------------------
	|
	|
```
"baseline" ça va dépandre si vous n'avez pas par exemple les mêmes tailles de bloc tout simplement. 

Alors en "flex-start" tout ce met au dessus absolument tous se met en haut d'accord tout en haut de notre conteneur alors qu'avec la valeur "baseline" en fait si on avait par exemple ici un bloc ou le contenu commence là.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT<br><br></div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
	</div>
</body>
</html>
```

## "baseline"
```css
>		align-items:baseline;
```
```txt
	+-----------------------------------------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+		+-------+
	|				|		|
	|				+-------+
	+-------+-------+-------+-------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+-------+---------------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+
	|ELEMENT|
	+-------+
	|
	|
	+-----------------------------------------
	|
	|
```
Avec la valeur "baseline" en fait si on avait un bloc où le contenu commence-là, hé bien tous ces autres blocs là, les petits où il a juste marqué les mains et ils se mettraient à hauteur de là où commence le contenu du bloc qui est un peu plus grand si vous comprenez un petit peu ce que je veux dire.

En fait là vous prenez tous ces rectangles là |ELEMENT| ici et ceux d'après il serait juste décaler un peu plus bas alors que celui-là il resterait coller en haut.
```txt
	+-----------------------+-----
	|ELEMENT|ELEMENT|ELEMENT|
	+-------+		+-------+-----
			|		|
			+-------+
```
C'est juste ça le principe de "baseline" c'est pour se baser par rapport vraiment par rapport à ce qu'il y a à l'intérieur mais comme moi j'ai juste une couleur de fond et un petit texte ce n'est pas forcément très probant bon je ne vais pas m'amuser à modifier chaque fois tout le html sinon ça va être très très long donc voilà en tout cas je voulais que vous sachiez qu'il y a cette propriété cette valeur "baseline" qui est très important par rapport à l'alignement sur l'axe secondaire.

Là on a fait le tour je vais revenir à un affichage normal, on va rester là dessus donc ça c'est l'affichage de base.

## "flex-start"
```css
>		align-items:flex-start;
```
```txt
	+-----------------------------------------
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+		+-------+
	|				|		|
	|				+-------+
	+-------+-------+-------+-------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+-------+---------------+
	|ELEMENT|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+-------+
	|
	+-------+
	|ELEMENT|
	+-------+
	|
	|
	+-----------------------------------------
	|
	|
```
Voilà on va garder quand même tous ces éléments ce sera peut-être beaucoup plus utile pour ce que j'ai à vous montrer pour la suite.

Donc là on a travaillé sur le conteneur d'accord on a vu dont je rappelle un très rapidement comment gérer l'orientation d'accord de nos différents objets dans le conteneur, comment gérer la coupure des éléments pour que ça tienne éventuellement sur plusieurs lignes, comment évidemment formater tout ça ensemble grâce à la méta propriété ici 'flex-flow' et on a vu ensuite comment gérer l'alignement selon l'axe principal 'justify-content' de notre conteneurs et l'alignement pour l'axe vertical 'align-items'.

![flexbox.JPG](flexbox.JPG)
<!--
	FLEXBOX CSS
	
	Axe principal
A	+---------------------------------------- >
x	| +--------------------------------------+
e	| | +----------++----------++----------+ |
	| | | Objet	   || Objet	   || Objet	   | |
s	| | | flexible || flexible || flexible | |
e	| | | (flex    || (flex    || (flex    | |
c	| | | -item)   || -item)   || -item)   | |
o	| | +----------++----------++----------+ |
n	| | conteneur flexible (flex-container)	 |
d	| +--------------------------------------+
a	|
i	|
r	|
e	|
	v
-->
Je rappelle sur le schéma, l'axe principal, l'axe secondaire pour pas vous mélanger les pinceaux donc à partir de ça on va maintenant pouvoir travailler également sur nos objets directement.

Là on a travaillé sur le conteneur mais on peut également faire pas mal de choses sur l'objet en lui même donc pour ça nous allons avoir accès a évidemment d'autres priorités pour le faire.

Alors elles sont très simples d'accord très simple à comprendre, très simple à mettre en oeuvre ce n'est pas trop trop compliqué ça va et vous verrez du coup pas mal de choses.

Alors je vais peut être enlever tout ça, je n'ai pas forcément besoin d'autant d'éléments en fait.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
		<div class="cont-item">ELEMENT</div>
	</div>
</body>
</html>
```
voilà on va laisser comme ça et ce que nous allons faire ici c'est d'appliquer sur nos objets voilà donc les objets en fonction il faudra plusieurs propriétés distinctes.

On va pouvoir déjà joué sur l'ordre des différents objets de notre conteneurs avec la propriété 'order' donc la propriétaire 'order' elle aura simplement un entier `<int>` par défaut c'est zéro ça veut dire que l'élément n'a pas de priorité particulière et après on pourra mettre un entier par exemple 1 donc l'élément sera prioritaire si vous mettez 2 hé bien 2 passera après 1. Je vais vous expliquer comment on va mettre ça en place alors ici, on va mettre "order1" d'accord in va appeler ça comme ça et là avec trois éléments l'explication sera suffisante pour que vous puissiez comprendre.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item order1">ELEMENT</div>
		<div class="cont-item order2">ELEMENT</div>
		<div class="cont-item order3">ELEMENT</div>
	</div>
</body>
</html>
```
Donc voyez je rajoute une classe order1-2-3 parce que je met ses éléments dans cet ordre là et je vais évidemment travailler avec.

Donc là on travaille bien sur un 'flex-items' ce sont des 'flex-items' et je dis que celui qui est d'ordre1 eh bien il aura la valeur 1 ici comme ordre.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
	.order1{order:1;}
```
Alors c'est pas obligés d'être 1, vous pouvez commencer à 100. L'intérêt c'est que ceux qui viennent normalement après ait un nombre plus grand derrière donc là si j'ai "order1" il faut que je mette quelque chose de plus grand derrière. Je peux mettre 1.1 ou 2 et cetera.
```css
	.order1{order:1}
	.order2{order:2}
```
Je peux mettre 2 et cetera. Comme je les appelez .order1, je reste sur des termes qui sont un peu pareil là, .order2, .order3 ici.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
	.order1{order:1;}
	.order2{order:2;}
	.order3{order:3;}
```
Ca c'est par défaut d'accord si j'actualise.
```txt
	+-----------------------------------------
	|ELEMENT|ELEMENT|ELEMENT|
	+-------+-------+-------+
	|
	|
```
On voit aucune différence si j'actualise on voit que les éléments d'ailleurs sont comme ça décidément on va y arriver sinon vous allez voir aucune différence. On le refait, on va y arriver avec le html.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item order1">A</div>
		<div class="cont-item order2">B</div>
		<div class="cont-item order3">C</div>
	</div>
</body>
</html>
```
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
	.order1{order:1;}
	.order2{order:2;}
	.order3{order:3;}
```
```txt
	+-----------------------------------------
	|A|B|C|
	+-+-+-+
	|
	|
```
Voilà a b c, on voit ici nos trois blocs d'accord et on peut changer l'ordre càd que j'ai juste à faire ça par exemple C passe en deuxième position et lui en troisième. On peut changer les classes et là je vais modifier.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item order1">A</div>
		<div class="cont-item order3">B</div>
		<div class="cont-item order2">C</div>
	</div>
</body>
</html>
```
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
	.order1{order:1;}
	.order2{order:2;}
	.order3{order:3;}
```
```txt
	+-----------------------------------------
	|A|C|B|
	+-+-+-+
	|
	|
```
Plus le nombre de 'order' est petit et plus l'élément sera prioritaire dans sa disposition ce sera en fait le premier affiché dans le conteneur et plus le nombre est grand et plus le nom le l'objet sera affiché en dernier voilà donc très simple vraiment order très facile à utiliser comme propriété et attention on l'utilise sur l'objet d'accords donc pas sur tout les objets parce que si vous le faites ça n'a pas d'intérêt.

Le but c'est d'avoir un ordre particulier éventuellement donc de pouvoir changer la disposition en fonction donc en général on mettra une classe particulière à certains objets pour avoir ça.

Si admettons on voulait que celui-là il soit prioritaire d'accord.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item">A</div>
		<div class="cont-item priority">B</div>
		<div class="cont-item">C</div>
	</div>
</body>
</html>
```
Genre que ma boîte B soit toujours prioritaire par rapport au reste et vous pouvez aussi très bien faire ça donc là vous dites que tous les items, quelle qu'ils soient, ils ont par exemple une priorité de 2 càd qu'ils se mettent eux mêmes en ordre comme il faut.
```css
	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
>		order:2;
	}
```
Mais par contre l'élément qui possède la classe 'priority' donc qui est prioritaire, lui il sera devant les autres donc on lui du coup un order plus petit que tous les autres éléments et comme ça quoi qu'il arrive le b ici sera toujours toujours toujours en premier d'accord.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
>		order:2;
	}
	
>	.priority{order:1;}
```
```txt
	+-----------------------------------------
	|B|A|C|
	+-+-+-+
	|
	+-----------------------------------------
	|
```
Je peux rajouter autant d'éléments que je peux même les mettre avant le B si je veux ça ne va absolument rien changer d'accord.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item">A</div>
		<div class="cont-item">C</div>
		<div class="cont-item">C</div>
		<div class="cont-item">C</div>
		<div class="cont-item priority">B</div>
		<div class="cont-item">C</div>
	</div>
</body>
</html>
```
Genre que ma boîte B soit toujours prioritaire par rapport au reste et vous pouvez aussi très bien faire ça donc là vous dites que tous les items, quelle qu'ils soient, ils ont par exemple une priorité de 2 càd qu'ils se mettent eux mêmes en ordre comme il faut.
```css
	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
>		order:2;
	}
```
Mais par contre l'élément qui possède la classe 'priority' donc qui est prioritaire, lui il sera devant les autres donc on lui du coup un order plus petit que tous les autres éléments et comme ça quoi qu'il arrive le b ici sera toujours toujours toujours en premier d'accord.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
>		order:2;
	}
	
>	.priority{order:1;}
```
```txt
	+-----------------------------------------
	|B|A|C|C|C|C|
	+-+-+-+-+-+-+
	|
	+-----------------------------------------
	|
```
Donc là c'est plus une question d'ordre dans lequel est écrit le code html qui va jouer sur l'ordre dans lequel est affiché ici le rendu avec l'ordre au niveau flexbox d'accord au niveau de boîte flexible on va vraiment pouvoir changer la disposition des différents éléments donc ça c'est important à voir.

Voilà du coup on va revenir un exemple ici.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item">AAA</div>
		<div class="cont-item">BBB</div>
		<div class="cont-item">CCC</div>
	</div>
</body>
</html>
```
Ensuite on va enlever .priority{order:1;} et order:2; donc le order à appliquer à des objets spécifiques. Si vous le faites sur tous évidemment ils auront tous la même priorité donc ils se mettront dans un ordre normal d'accord, dans l'ordre dans lequel vous avez écrit au niveau du fichier.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
```
```txt
	+-----------------------------------------
	|AAA|BBB|CCC|
	+---+---+---+
	|
	+-----------------------------------------
	|
```
Ca c'est pour order, maintenant on va voir sur les techniques de gestion de l'espace càd que chacun des objets vous voyez occupent un certain espace dans le conteneur par défaut il en occupe le moins possible mais on va voir que l'on peut également changer cette occupation de l'espace avec quelques propriétés css.

La première à voir c'est la propriété pour l'espace en tant qu'agrandissement donc on va utiliser 'flex-grow'.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
	*/
```
'flex-grow' va simplement dire donc avec un entier également comprendra, ou une valeur automatique ou ce que vous voulez, comment, quelle est la capacité en fait de notre objet d'accord à s'agrandir en relation avec les autres éléments càd relativement aux autres éléments quand bien évidemment il reste de l'espace dans le conteneur mais s'il n'y a pas d'espace il va se dimentionner relativement par rapport aux autres éléments et selon l'espace qu'il reste d'accord donc ça comment le faire ?

Comme tout à l'heure donc on les nommer obj1-2-3.
```html
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Flexbox</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cont-item obj1">AAA</div>
		<div class="cont-item obj2">BBB</div>
		<div class="cont-item obj3">CCC</div>
	</div>
</body>
</html>
```
On est d'accord que chaque élément comme ici n'a aucune particularité d'accord d'ailleurs je peux même le montrer et on va le faire avec la propriété 'flex-grow', `.obj1{flex-grow:1;}` ... vous voyez quand je disais qu'il y a plein de balises et que la vidéo allait être un peu longue.

Ce n'était pas une blague il y a vraiment beaucoup de choses à voir donc  vraiment prenez votre temps, vous avez vraiment tout le temps de voir cette vidéo même en plusieurs fois même sur plusieurs jours peu importe ça ne sert à rien de vous presser puis d'oublier la moitié des informations donc si je fais ceci.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
	.obj1{flex-grow:1;}
	.obj2{flex-grow:1;}
	.obj3{flex-grow:1;}
```
Voilà "1" "1" et "1" d'accord on a une répartition tel quel.
```txt
	+---------------------------------------+
	|AAA		 |BBB		  |CCC			|
	+------------+------------+-------------+
	|										|
	+---------------------------------------+
	|										|
```
Pourquoi ça ? parce que nous avons dit en fait au niveau des éléments ils vont occuper les mêmes proportions chacuns.

Comme ils sont trois d'accord donc on peut dire que 100% c'est l'espace total, comme ils sont trois ils vont occuper chacun un tiers de l'espace ça paraît logique d'accord donc en fait quand on met 1 il ne faut pas imaginer qu'il compte pour 1 c'est juste qu'ils vont occuper la même unité de dimensions.

C'est pas forcément facile à vous l'expliquer il faut le comprendre comme ça. Imaginez donc l'espace à 100% d'accord l'espace complet et si on met "1" "1" et "1" ils valent donc chacun la même chose donc comme ils valent chacun la même chose, on doit leur accorder la même place et comme ils sont trois éléments, on divise les 100% par trois et on obtient du coup 1/3 pour chacun. Ils occuperont chacun un tiers ok.

Alors si on mettait par exemple "2" "2" et "2" certains se pose peut être donc je vais devancer vos questions dans la vidéo on remarque qu'il ne se passe rien différent.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
>	.obj1{flex-grow:2;}
>	.obj2{flex-grow:2;}
>	.obj3{flex-grow:2;}
```
```txt
	+---------------------------------------+
	|AAA		 |BBB		  |CCC			|
	+------------+------------+-------------+
	|										|
	+---------------------------------------+
	|										|
```
C'est exactement ce que je viens de vous dire c'est juste une unité de mesures quelconques "2" comme elle est identique cette valeur d'accord comme ils sont égaux, ils auront un espace occupé égal d'accord c'est juste cette question là qui se pose.

En revanche et là c'est là où toute la différence à se faire si j'ai ça "1" "2" et "1". "2" donc l'élément en deuxième position, il est à "2" alors que les autres sont à "1" là on aura des proportions différentes d'accord.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
>	.obj1{flex-grow:1;}
>	.obj2{flex-grow:2;}
>	.obj3{flex-grow:1;}
```
```txt
	+---------------------------------------+
	|AAA	  |BBB		  		  |CCC		|
	+---------+-------------------+---------+
	|										|
	+---------------------------------------+
	|										|
```
Là on aura des proportions c'est à dire que par rapport aux autres éléments donc les éléments a et c, b va occuper deux fois plus même si ça ne veut pas dire qu'il occupe deux fois plus d'espace que les autres. C'est juste que proportionnellement a eu d'accord relativement à eux, il va prendre deux fois plus d'importance en tout cas dans l'occupation de l'espace donc on obtient ça.

Et puis on va augmenter le nombre et plus évidemment il va prendre de l'espace à a et b voyez automatiquement.
```css
	.obj1{flex-grow:1;}
	.obj2{flex-grow:4;}
	.obj3{flex-grow:1;}
```
```txt
	+---------------------------------------+
	|AAA   |BBB		  		  		 |CCC	|
	+------+-------------------------+------+
	|										|
	+---------------------------------------+
	|										|
```
Ca se voit également ici avec "4" et même si on rediomentionne voilà comment ça se passe selon la disposition vous voyez que tout se redimensionnent et B également mais il occupera quand même on va dire une unité de 4 comme espace par rapport à A et C qui n'occupent que 1. 

Voilà si vous voulez que A soit un petit peu plus grand que C mais toujours plus petit que 2 vous mettez par exemple 2 donc on peut jouer comme ça avec les unités pour prévoir les éléments.
```css
	.obj1{flex-grow:2;}
	.obj2{flex-grow:4;}
	.obj3{flex-grow:1;}
```
```txt
	+---------------------------------------+
	|AAA   	  |BBB		  		     |CCC	|
	+---------+----------------------+------+
	|										|
	+---------------------------------------+
	|										|
```
On peut jouer comme ça avec nos différents éléments par rapport à l'espace fournit donc la capacité à grandir donc évidemment qui dit agrandissement d'un élément avec 'flex-grow' il va y avoir des rétrécissements des autres mais le rétrécissement on peut volontairement le contrôler nous aussi avec justement la propriété 'flex-shrink' et là pareil je peux vous montrer un petit peu comment ça se passe.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
>	.obj1{flex-schrink:1;}
>	.obj2{flex-schrink:1;}
>	.obj3{flex-schrink:1;}
```
```txt
	+-----------------------------------------
	|AAA|BBB|CCC|
	+---+---+---+
	|
	+-----------------------------------------
	|
```
Si on met "1" partout on a ça d'accord ça veut dire quoi ? c'est à dire que les éléments comme on demande ici de se rétrécir et pas de s'agrandir, ils vont se rétrécir au maximum qu'ils peuvent d'accord donc comme on a mit ici "1" partout ils vont se rétrécir de manière égale et donc ils vont en fait avoir un comportement par défaut.

Si vous mettez par exemple un 'flex-shrink' en auto vous aurez en fait une occupation de 1 c'est à dire le minimum d'accord ils vont occuper le minimum de place qu'il a donc c'est ce qu'on observe quand on n'utilise pas cette propriété.

Maintenant si je m'amuse à mettre 2, on va refaire pareil comme pour comme pour 'flex-grow' et voir la différence.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
>	.obj1{flex-schrink:2;}
>	.obj2{flex-schrink:2;}
>	.obj3{flex-schrink:2;}
```
```txt
	+-----------------------------------------
	|AAA|BBB|CCC|
	+---+---+---+
	|
	+-----------------------------------------
	|
```
Qu'est ce qui se passe ? même chose comme on leur a demandé d'éventuellement se rétrécir d'accord d'avoir une capacité de rétrécissement relatives aux autres objets du conteneur d'accord donc si évidemment c'est nécessaire ainsi s'il manquait de la place les éléments comme il possède ici la même valeur pour 'flex-schrink' ils vont occuper le moins d'espace possible.

Donc là où ça aura un intérêt et il faidra l'utiliser avec 'flex-grow' d'accord sinon on ne verra pas grand chose par exemple en faisant ceci.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
>	.obj1{flex-grow:1;flex-schrink:1;}
>	.obj2{flex-grow:1;flex-schrink:1;}
>	.obj3{flex-grow:1;flex-schrink:1;}
```
Alors on va l'utiliser avec 'flex-grow' et ça va évidemment s'utiliser de pair puisque pour qu'il y ait un agrandissement, il faut qu'il y ait un rétrécissement de l'autre côté donc vous allez rarement utiliser juste le rétrécissement tout seul parce que le rétrécissement ça prendra une valeur minimale.
```txt
	+---------------------------------------+
	|AAA		 |BBB		  |CCC			|
	+------------+------------+-------------+
	|										|
	+---------------------------------------+
	|										|
```
On va avoir ça par défaut, pas de souci et logiquement si je met plus de place obj1 et surtout à obj3.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
>	.obj1{flex-grow:2;flex-schrink:1;}
>	.obj2{flex-grow:1;flex-schrink:1;}
>	.obj3{flex-grow:4;flex-schrink:1;}
```
```txt
	+---------------------------------------+
	|AAA		 |BBB	|CCC				|
	+------------+------+-------------------+
	|										|
	+---------------------------------------+
	|										|
```
Voilà comme ça on va pouvoir donner en fait une capacité de rétrécissement à l'élément ici l'objet 2 en fait d'accord on pourra vraiment influé sur le rétrécissement c'est à dire la place qu'il peut éventuellement céder quand on a besoin ici d'avoir un agrandissement pour d'autres éléments.

Alors là après c'est pareil il faut avoir des calculs assez précis puisque si le navigateur est capable de déduire lui-même automatiquement certaines valeurs votre rétrécissement ne sera pas pris en compte puisque qu'il est capable de calculer l'espace nécessaire donc en général le navigateur gère bien l'espace et ces propriétés-là quand on a besoin comme ça de gérer les agrandissements/rétrécissements on va plutôt utilisé ... pour ça que là je passe assez vite sur les propriétés-là parce que vous voyez qu'il y a pas mal de choses des fois qui ne sont pas modifiés sur le rendu puisque le navigateur fait ses calculs lui-mêmes, on va plutôt utiliser la propriété 'flex' qui est la méta-propriété qui va tout simplement récupérer `<grow>` `<shrink>` et `<basis>` ici.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
		flex-basis:<length>
		flex:<grow> <shrink> <basis>
	*/
```
Et 'flex-basis' j'en ai pas parlé c'est une autre propriété. Elle prend une comment dire une longueur éventuellement `<length>`.

Donc si vous mettez un flex à auto d'accord comme ceci, `.obj1{flex:auto;}` vous allez en réalité donc évidemment travailler sur les trois valeurs là flex:`<grow>` `<shrink>` `<basis>` donc ça va mettre une valeur de 1 à `<grow>` d'accord càd qu'on va lui donner en fait une seule unité pour l'agrandissement qu'il peut avoir. On mettra 1 à `<schrink>` d'accord donc pareil donc il serait capable aussi bien de s'agrandir que de se retraicir d'accord à une valeur de 1 et `<basis>` on mettra 0 et vous allez très vite comprendre pourquoi.
```css
	.obj1{flex:auto;}
	.obj2{}
	.obj3{}
```
`<basis>` en fait c'est simplement si vous voulez càd la taille initiale de votre élément c'est à dire qu'avant que l'espace soit partagé ici entre tous nos objets dans le conteneur on peut dire qu'un de nos éléments est déjà une dimensions initial d'accord et une fois que sa dimension initial est dites, est choisie, spécifiée on va partager, distribuer le reste de l'espace pour les autres éléments.

D'ailleurs je peux peut-être même vous montrer maintenant, on a obj1-2-3 donc on va faire ça.
```css
	.obj1{flex-basis:auto;}
	/*.obj2{}
	.obj3{}*/
```
Alors je vais le mettre en commentaire et je peux très bien par exemple dire 200 pixels.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
		flex-basis:<length>
		flex:<grow> <shrink> <basis>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
>	.obj1{flex-basis:200px;}
	/*.obj2{}
	.obj3{}*/
```
```txt
	+---------------------------------------+-------+
	|AAA		 					|BBB|CCC|		|
	+-------------------------------+---+---+		|
	|												|
	+-----------------------------------------------+
	|												|
	|												|
```
Voyez ce qu'il se passe, initialement lui il prend 200 pixels de largeur et après il répartit l'espace restant pour les autres éléments d'accord alors les autres éléments, ils ne prennent pas vraiment tout l'espace mais c'est normal je vous rappelle on n'aura pas forcément donner une capacité de s'agrandir si nécessaire donc si on veut le faire éventuellement on peut s'amuser de dire que pour les deux autres objets d'accord hé bien on leur donne une capacité d'agrandissement et voilà.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
		flex-basis:<length>
		flex:<grow> <shrink> <basis>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
	.obj1{flex-basis:200px;}
>	.obj2, .obj3{flex-grow:1;}
```
```txt
	+---------------------------------------+
	|AAA	   |BBB		     |CCC			|
	+----------+-------------+--------------+
	|										|
	+---------------------------------------+
	|										|
```
Hop et voilà, ils occuperont le reste disponible et en fonction si là je venais à changer un espace disponible genre 800 pixels pour le 1er et bien il
occupe 800 pixels de base initialement le 'flex-basis' et les autres voyez s'étalent sur l'espace s'étale/s'étire sur l'espace disponible tout en le partageant.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
		flex-basis:<length>
		flex:<grow> <shrink> <basis>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
>	.obj1{flex-basis:800px;}
	.obj2, .obj3{flex-grow:1;}
```
```txt
	+---------------------------------------+
	|AAA 						|BBB  |CCC  |
	+---------------------------+-----+-----+
	|										|
	+---------------------------------------+
	|										|
```
Comme ils sont tous les deux encore une fois 'flex-grow' hé bien en fait si admettons ici (après AAA) il reste 20% de l'espace d'accord eh bien ils vont partager 1/2 des 20% de l'espace restant donc il y aura 10 % d'espaces pour B, 10% d'espace pour C.

On fait des petits calculs mais normalement c'est des calculs simples, comprenez que si vous avaez le nombre 100 sous le diviser par 2 et vous obtenez 50 et 50.

Mais si vous prenez qu'une seule des moitiés, que vous la diviser à nouveau par la moitié, si vous prenez la moitié de 100 et que vous le diviser encore par la moitié, vous avez donc 25 et 25 donc je pense que vous avez tous le niveau suffisant pour comprendre ces petits calculs mathématiques très simple. Il n'y a pas de problème là dessus donc voilà d'accord comment ça fonctionne donc en général, très généralement, vous utiliserez directement la propriété 'flex' et attention elle s'utilise sur des 'flex-item' d'accord.

![flexbox.JPG](flexbox.JPG)
<!--
	FLEXBOX CSS
	
	Axe principal
A	+---------------------------------------- >
x	| +--------------------------------------+
e	| | +----------++----------++----------+ |
	| | | Objet	   || Objet	   || Objet	   | |
s	| | | flexible || flexible || flexible | |
e	| | | (flex    || (flex    || (flex    | |
c	| | | -item)   || -item)   || -item)   | |
o	| | +----------++----------++----------+ |
n	| | conteneur flexible (flex-container)	 |
d	| +--------------------------------------+
a	|
i	|
r	|
e	|
	v
-->
Ca s'utilise sur ce qui est ici indiqués en rouge, on n'utilise pas la propriété 'flex' sur le conteneur d'accord c'est véritablement les objets qui vont ici influer donc voilà comment fonctionne `<basis>` donc des fois ce qu'on fait bon ont met 'flex-grow', 'flex-basis' et puis pour la troisième valeur on met automatique comme ça le navigateur il se débrouille en fait pour prévoir éventuellement les dimensions initiales.

+ exemple
```css
	.child {
	  flex-grow: 0;
	  flex-shrink: 1;
	  flex-basis: auto;
	}
```
Voilà donc le plus intéressant des fois par exemple c'est de dire j'ai un de mes objets qui va devoir occuper un espace un peu plus grand que le reste et mon conseil c'est laisser le navigateur faire le reste automatiquement c'est mieux.

'schrink' par exemple utilisé pour calculer des rétrécissements, pas utile, parce qu'à partir du moment où vous allez juste faire 'flex-grow' tous les autres éléments vont s'adapter automatiquement d'accord.

Par exemple si vous faites juste ça, `.obj1{flex-flow:2;}`. Vous mettez à 2 et puis les autres vous mettez à 1.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
		flex-basis:<length>
		flex:<grow> <shrink> <basis>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
>	.obj1{flex-grow:2;}
>	.obj2, .obj3{flex-grow:1;}
```
Et automatiquement voyez ça va s'adapter sans problème donc pas besoin ici de calculer des rétrécissements, de voir comment on peut gérer ça. Le navigateur fait ça déjà très bien tout seul.

N'hésitez pas évidemment à passer par ça et voilà je pense que c'est bon.

Là on aurait pu faire ça mais évidemment aucune utilité.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
		flex-basis:<length>
		flex:<grow> <shrink> <basis>
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
		flex:auto;
	}
```
```txt
	+---------------------------------------+
	|AAA		 |BBB		  |CCC			|
	+------------+------------+-------------+
	|										|
	+---------------------------------------+
	|										|
```
Ca n'a aucune utilité parce que c'est comme si on faisait un 'flex-grow' à 1 mais voilà c'est bien de le savoir ici ça met 'flex-grow' à 1, 'flex-schrink' à 1 et 'flex-basis' à 0.

Voilà c'est comme si on avait utilisé les trois propriétés mais réunient en une seule et on a la propriété 'flex' qui du coup nous fait gagner beaucoup de temps donc ça c'est à connaître.

Donc à voir, il n'y a pas de secret comme toujours, mettez les en pratique vraiment dans plein d'exemples ou en faisant un vrai site d'accord avec un vrai pied de page, avec des vraies images, des textes tout ça pour voir un petit peu tout ce que je vous ai montré là et comment ça fonctionne réellement parce que moi je peux forcément vous montrer pas mal de choses mais il est impossible de pouvoir tout vous montrer, de pouvoir vous illustrer tous les cas qui peuvent arriver ou tous les contextes d'accord de rendu et d'affichage qu'on peut avoir.

Il y en a tellement, des milliers, des milliers donc ce serait vraiment compliqué de tout vous montrer.

Alors voilà pour ça et on peut peut-être terminer par une dernière propriété qui va ... parce qu'on a vu comment le conteneur pouvait lui travailler sur ces éléments d'accord influer dessus mais on va voir aussi qu'un objet on peut l'aligner en fonction des autres en particulier.

Alors j'espère qui est visible.

Alors on a toujours nos 3 objets je rappelle mais admettons que .obj2 ici je puisse lui appliquer en fait un alignement par rapport à ses voisins donc par rapport aux autres objets dans le conteneur donc on va utiliser ... c'est pour ça que je vous dit au niveau des noms faites attention parce que c'est pas forcément toujours très logique.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
		flex-basis:<length>
		flex:<grow> <shrink> <basis>
		align-self:
	*/
```
En effet parce que là on a un 'align-items' qui est à utiliser au niveau du conteneur et là on a 'align-self' pour l'objet d'accords donc ça c'est pour l'objet en question, self qui veut dire lui-même d'accord soi même.

Donc 'align-self' et on pourra comme ça utiliser aussi un changement au niveau de l'alignement.

'align-self' va tout simplement fonctionner comme pour le reste c'est à dire alors on peut mettre une valeur automatique si on veut mais bon ça n'aurait pas forcément d'intérêt.

On peut travailler avec le "flex-start", "flex-end" je vais les mettre rapidement pour terminer là et on a normalement "stretch" si je ne dis pas de bêtises voilà.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
		flex-basis:<length>
		flex:<grow> <shrink> <basis>
		align-self:flex-start|flex-end|center|baseline|stretch
	*/
```
Donc "flex-start", "flex-end", le centrage "center", "baseline" c'est comme ce que je vous avais expliqué comme pour "align-items" c'est exactement en fait les mêmes valeurs. Et "baseline" et "stretch" c'est pour l'étirement.

Donc là ce qu'on peut faire là c'est de dire que les autres éléments par exemple ici par défaut genre je leur dis ... 

Voyez on a dit tous les objets du conteneur seront en "flex-start" c'est à dire comme ça.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
		flex-basis:<length>
		flex:<grow> <shrink> <basis>
		align-self:flex-start|flex-end|center|baseline|stretch
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
>		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
>		flex:auto;
	}
	
	.obj2
	{

	}
```
```txt
	+---------------------------------------+
	|AAA		 |BBB		  |CCC			|
	+------------+------------+-------------+
	|										|
	+---------------------------------------+
	|										|
```
D'accord mais je peux très bien à un moment donné dire moi je veux qu'il y en a un qui à un moment donné ne respecte pas cette règle là càd l'alignement de tous les items qu'on a défini dans le conteneur et dire que je veux que mon objet 2 lui même s'aligne autrement, pas en "flex-start" mais par exemple en "stretch" et là on obtiendra ça d'accord.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
		flex-basis:<length>
		flex:<grow> <shrink> <basis>
		align-self:flex-start|flex-end|center|baseline|stretch
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
	.obj2
	{
>		align-self:stretch;
	}
```
```txt
	+---------------------------------------+
	|AAA|BBB|CCC|							|
	+---+	+---+							|
	|	|	|								|
	|	|	|								|
	+---+---+-------------------------------+
	|										|
	|										|
```
Voilà indépedemment de ceci, on définit un stretch sur un objet.
```css
	.container
	{
>		align-items:flex-start;
	}

	.obj2
	{
>		align-self:stretch;
	}
```
On peut changer comme ça le comportement d'un objet spécifique encore ils ne sont pas obliger d'avoir forcément tous le même modèle de comportement au niveau de l'alignement.

Si vous avez besoin de changer le comportement d'un seul des objets de tout ceux que vous avez et bien utilisz sur l'objet en question via une classe tout simplement la propriété 'align-self' et vous pourrez comme ça changer les différentes dispositions, ça fonctionne bien sûr pour toutes les autres valeurs je vous avais montré.
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
		flex-basis:<length>
		flex:<grow> <shrink> <basis>
		align-self:flex-start|flex-end|center|baseline|stretch
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
	.obj2
	{
>		align-self:flex-end;
	}
```
```txt
	+---------------------------------------+
	|AAA|	|CCC|							|
	+---+	+---+							|
	|										|
	|	+---+								|
	|	|BBB|								|
	+---+---+-------------------------------+
	|										|
	|										|
```
On vraiment s'amuser à tout en fait, il y a vraiment tout ce qu'on veut, "center".
```css
	/*
		display:flex|inline-flex
		
		flex-direction:row|column|row-reverse|column-reverse
		flex-wrap:nowrap|wrap|wrap-reverse
		flex-flow:<direction> <wrap>
		justify-content:flex-start|flex-end|center|space-between|space-around|space-evenly
		align-items:flex-start|flex-end|center|stretch|baseline
		order:<int>
		flex-grow:<int>
		flex-schrink:<int>
		flex-basis:<length>
		flex:<grow> <shrink> <basis>
		align-self:flex-start|flex-end|center|baseline|stretch
	*/

	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}

	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
		align-items:flex-start;
	}

	.cont-item
	{
		background-color:rgb(241,131,131);
		border:1px solid #000;
	}
	
	.obj2
	{
		align-self:flex-end;
	}
	
>	.obj1{align-self:center;}
```
```txt
	+-------+---+---------------------------+
	+---+	|CCC|							|
	|AAA|	+---+							|
	+---+									|
	|	+---+								|
	|	|BBB|								|
	+---+---+-------------------------------+
	|										|
	|										|
```
`align-self:center;` pour montrer qu'on peut changer le comportement de tout, je rappelle qu'en CSS tout va être traité en fait au fur et à mesure de la définition du fichier, ça veut dire quoi ? ça veut dire que quand on interprète le CSS il dit bon d'accord pour le `<body>` tu veux une couleur de fond comme ça #EEE, 'margin' tu veux aligner tout comme ça "auto" et tu veux une largeur de 100%.
```css
	body
	{
		background-color:#EEE;
		margin:auto;
		width:200%;
	}
	...

	body
	{
		background-color:#000;
	}
```
Il continue bon ça on s'en fiche et admettont qu'à un moment donné dans mon  fichier je refais ici une sélection sur `<body>` et que je dise 'background-color' égal #000... alors ça n'a rien à voir avec 'flex-box' mais j'en profite comme on est sur la fin de la formation pour faire une petite piqûre de rappel et là sans surprise la couleur de fond sera noir, pourquoi ? 

Parce que comme c'est arrivé à la fin, le plus tard dans le fichier cette propriété là 'background-color' avec sa valeur est venue écraser l'ancienne valeur d'accord donc ça pensez-y.

Donc c'est pour ça là, je le dis clairement, il se passe la même chose au niveau de ça.
```css
	.obj2{align-self:flex-end;}	
	.obj1{align-self:center;}
```
Là on a défini pour le conteneur de dire que tout ses objets seront en "flex-start" d'accord donc c'est le cas.
```css
	.container
	{
		background-color:rgb(113,155,245);
		display:flex;
		height:100px;
		flex-wrap:wrap;
>		align-items:flex-start;
	}
```
Au départ ils étaient partis pour tout mettre à "flex-start" mais au final on lui dit par contre attention pour l'objet 2 et l'objet 1, tu va appliquer un autre alignement que "flex-start" et à la fin quand il fait le rendu et bien il aura pris tout en compte, obj1 sera en "center" et obj2 sera en "flex-end" et au obj3 comme on a rien respicifier, il prendra ce qu'on avait déterminé au départ c'est-à-dire "flex-start" d'où ce rendu ici différent.
```txt
	+-------+---+---------------------------+
	+---+	|CCC|							|
	|AAA|	+---+							|
	+---+									|
	|	+---+								|
	|	|BBB|								|
	+---+---+-------------------------------+
	|										|
	|										|
```
Voilà donc ça c'était la petite petite parenthèse de fin qui était je pense importante et on en a terminé avec 'flex-box' au niveau des propriétés à voir, au niveau de toutes les choses.

N'hésitez pas vraiment à faire ça sur votre code, à revoir la vidéo même si nécessaire revoir d'anciennes vidéos s'il y a encore des choses qui ne sont suffisamment clair dans ce que j'ai pu vous expliquer dans les propriétés qu'on a utilisés, dans les sélecteurs qu'on a fait sur les classes ou ce genre de choses.

Si vous voyez que dans ce que j'ai expliqué dans la vidéo, il y a des petits passages que vous n'avez pas forcément compris et qui n'avait d'ailleurs rien à voir avec 'flex-box' c'est peut être que vous avez été trop vite sur les anciennes vidéos donc n'hésitez pas à revenir en arrière pour bien assimiler là puisque les dernières séances que nous allons voir ne seront pas forcément évidente.

Là en tout cas on en a terminé avec "flex-box".

Pour la prochaine séance nous allons parler des 'grid' et on terminera le cours avec les media Queries qui permettront tout simplement de gérer du responsive design c'est à dire une mise en page adaptative en fonction de la résolution de vos écrans.

Je vous dis à très bientôt, j'espère que cette vidéo vous aura plus et s'il y a des questions comme toujours n'hésitez pas à les poser dans les commentaires