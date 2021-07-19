# [14. Introduction design](https://www.youtube.com/watch?v=l10hhz0VJj4)
15-01-21

Bonjour à tous, on se retrouve sur cette séance 14 en html et css.

Précédemment, on avait terminé toute la partie html pur càd que je vous avais montrer toutes les balises et toutes les petites choses que je voulais vous apprendre en html.

Maintenant nous allons pouvoir commencer le design à l'aide du langage css donc le langage css, pour rappel je l'avais montré dans l'introduction donc la toute première séance de cette formation.

Je vous avait dit donc très rapidement, je vais repassé le pdf rapidement voilà voilà donc avec css nous allons donc retrouver pas mal de choses pour tout ce qui est la mise en forme de nos pages.
```txt
	CSS, pour la forme
	* Cascading Style Sheets - 1996
```
On vous a expliqué que le css était simplement pour dire Cascading Style Sheets d'accord, que c'était fondé en 96 c'est à dire à la suite de html puisqu'à la base tout se faisait dans le html et comme ça mélangait les choses et bien le w3c, qui est la norme vraiment de ces langages, a inventé le css pour pouvoir séparer le contenu d'accord donc le fond de la forme au niveau des pages web, histoire de bien séparer les choses et que ce soit complètement indépendant.

On a bien évidemment donc la possibilité de représenter une page correctement donc avec un design d'accord, de lui créer une identité c'est super important et on va voir tout un tas de propriété sur lesquelles on va pouvoir travailler donc on pourra changer le style du texte, les polices de caractères, on va pouvoir travailler sur les couleurs, travailler sur les positionnements d'éléments, sur beaucoup beaucoup de choses.
```txt
	CSS, pour la forme
	* Cascading Style Sheets - 1996
	* Style de présentation d'une page (design)
	* Propriétés :
		- Style du texte, police de caractères
		- Couleur de texte, de fond
		- Alignements, marges, zones
		- Dimensions, opacités, ...
```
C'est grosso modo tout ce que j'avais dit et n'hésitez pas évidemment retourner sur le pdf qui étaient disponibles sur la toute première séance de la formation si jamais vous voulez en voir un petit peu plus voilà donc ça c'était la petite parenthèse pour cette partie.

Alors comment que ça va se passer au niveau css ? ça va être très simple déjà on va essayer de voir un maximum de choses parce que css comme html sont des langages qui évoluent très très vite puisque le web bouge vraiment tous les jours donc voilà il y a plein plein de choses à connaître, plein de choses de savoir et surtout plein de manières de faire d'accord.

Vous allez voir qu'au niveau du web encore une fois comme je l'avais déjà dit également pour html c'est facile de créer des pages web mais c'est beaucoup plus difficile de bien le faire voilà et c'est ça le gros problème avec html et css, c'est que c'est à la porté de tout le monde mais vous pouvez très bien avoir une page qui va fonctionner d'accord elle serra bien affichée, il n'y aura pas de problème et pas d'erreur de compilation par exemple comme on aurait sur un langage de programmation.

Et là pour un langage dit de sémantique, un langage de balises comme il n'y a pas de souci de compilation, vous pouvez avoir une page qui s'affiche mais en ayant tout un tas d'erreurs à l'intérieur donc ça va faire à faire attention et pour css vous allez voir c'est un peu la même chose.

Alors comment ça va fonctionner, on a plusieurs méthodes d'accord plusieurs manières de travailler avec css. 

La méthode recommandée d'accord il y a la méthode vraiment que vous allez devoir utiliser dans 100% des cas c'est la création d'un fichier externe css d'accord pour travailler dessus c'est à dire que en plus de notre page html nous allons avoir un fichier css dans lequel nous mettrons toutes nos propriétés et nous allons lier ce fichier directement au html.

Alors on va le faire tout de suite puisque c'est la méthode que nous utiliserons, qui est vraiment la méthode recommandée.

Vous créer un nouveau fichier donc toujours avec les extensions affichées je rappelle c'est super important et vous remplacez du coup l'extension .txt si vous faites comme moi par .css donc on va l'appeler style.css ce sera un nom tout à fait reconnaissable et nous allons pouvoir ouvrir ce fichier là tout simplement.

+ index.html
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Introduction design</title>
	</head>
	<body>
		
	</body>
	</html>
```
+ style.css
```

```
Donc ça c'est la première méthode, comment lier notre fichier css à notre page html ? c'est très simple dans les balises `<head>` surtout au niveau du début du fichier, vous allez pouvoir indiquer un lien vers ce fichier donc on va utiliser la balise `<link>` d'accord que je n'ai pas forcément présenté avant puisque elle n'avait pas un intérêt puisqu'on avait pas encore le css au départ donc je ne l'ai pas présenté et vous allez utiliser la tribu 'rel' donc c'est pour la relation en fait pour lier ça au type de document nécessaires donc nous c'est une feuille de style, une style sheet tout simplement et vous mettez un attribut 'href' pour avoir le lien, c'est tout d'accord.

+ index.html
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Introduction design</title>
>		<link rel="stylesheet" href="">
	</head>
	<body>
		
	</body>
	</html>
```
+ style.css
```

```
Pas besoin de mettre d'autres attributs ils sont inutiles surtout en html5.

Il y avait plus d'attributs à mettre quand on travaillait encore en html 4 ou avec la syntaxe xml donc de xhtml mais là on en est plus du tout là, maintenant on travaille en html 5 donc les syntaxes sont beaucoup plus pratique, beaucoup plus simple à écrire.

Et au niveau du lien c'est toujours comme pour les images, comme pour toutst  et par rapport à l'endroit où est votre fichier html.

Moi comme il juste à côté, j'ai juste à mettre directement le nom de mon fichier css et voilà comment ça va se passer, on y va au niveau de ça. Si j'actualise, bien sûr on ne voit rien au niveau de ma page.
```html
	<link rel="stylesheet" href="style.css">
```
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	
</body>
</html>
```
+ style.css
```

```
On va regarder par contre au niveau du code source elle a bien été intégrée donc à partir où on va définir des choses à l'intérieur ça fonctionnera.

Voilà la première manière de procéder, celle que je recommande.

Il y en a une deuxième d'accord et une troisième que je vais présenter parce que c'est bien de les connaître mais qui sont évidemment à éviter d'accord vraiment sauf si vous ne pouvez pas faire autrement mais logiquement vous avez toujours moyen de passer par un fichier externe.

Donc la deuxième c'est de paser dans les balises `<head>`, de définir des balises style donc on fait `<style>` comme ceci.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Introduction design</title>
		<link rel="stylesheet" href="style.css">
>		<style></style>
	</head>
	<body>
		
	</body>
	</html>
```
`<style>`, c'est une balise fermante également et à l'intérieur on va définir nos propriétés css donc les commentaires en css c'est très simple à écrire c'est `/* */`
```css
	/* un commentaire */
```
C'est comme pour du c ou c++ et on termine avec étoile slash pour ceux qui font déjà du c, du c++ ou d'autres langages de programmation assez similaire vous avez ce type de commentaire là donc vous pouvez mettre des commentaires en css de cette manière ça fonctionne bien sûr dans les fichiers d'accord ça c'est une manière de faire des commentaires puisque ce sera évidemment pratiques pour organiser vos fichiers.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Introduction design</title>
		<link rel="stylesheet" href="style.css">
		<style>
>			/* un commentaire */
		</style>
	</head>
	<body>
		
	</body>
	</html>
```
Donc ça c'est la deuxième manière de faire, on va regarder après quelques propriétés par la suite de toute façon, je vais vous expliquer tout ça.

Et la troisième c'est directement sur une balise via un attribut, admettons que là j'ai un paragraphe et un deuxième paragraphe mais cette fois lui appliquer un autre rendu donc une autre mise en forme donc je pourrais tout simplement faire 'style' et à l'intérieur de cette attribut écrire des propriétés css d'accord.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Introduction design</title>
		<link rel="stylesheet" href="style.css">
		<style>
			/* un commentaire */
		</style>
	</head>
	<body>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
		
		<p style="">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
	</body>
	</html>
```
Ca c'est pareil c'est vraiment à éviter sauf si vous n'avez aucun moyen de procéder autrement mais logiquement encore une fois cette manière de faire.
```html
		<p style="">Lorem...
```
Et cette manière de faire.
```html
		<style>
			/* un commentaire */
		</style>
```
Vous pouvez les éviter toujours passer par un fichier externe.

Voilà je voulais vous montrer les deux mais de toute façons je vous montrerais pas comment ça fonctionne puisque honnêtement ce n'est pas ce qui est intéressant, nous on va se contenter du fichier en lui-même.

Au niveau du fichier du coup comment ça va se passer ? donc maintenant que vous savez comment utiliser css, comment l'intégrer, le lier à votre fichier html, ce qui est important de savoir c'est la syntaxe.

Comment allons nous écrire du css ? est-ce qu'il y a des balises ? est-ce qu'il y a des fonctions ? est-ce que c'est un langage de programmation ? non ce n'est pas de langage de programmation c'est un langage de style d'accord.

On va styliser nos pages en définissant tout un tas de choses.

La première c'est que css est capable d'identifier tous nos éléments html et pour cela il va utiliser ce qu'on appelle un système de sélecteurs.

Le sélecteur va tout simplement sélectionner un élément particulier de nos pages pour lui appliquer un style.

Là plusieurs manières de faire : vous pouvez le faire sur un élément directement donc un élément càd son nom en fait dans sa balise par exemple ici notre balise `<p>` je peux lui appliquer un style en faisant juste ça, le sélecteur p d'accord.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Introduction design</title>
		<link rel="stylesheet" href="style.css">
		<style>
			/* un commentaire */
		</style>
	</head>
	<body>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
		
		<p style="">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
	</body>
	</html>
```
+ style.css
```css
	/* un commentaire */
	P
	{
	}
```
Donc vous avez un sélecteur et ensuite vous ouvrez des accolades d'accord et à l'intérieur ici vous allez avoir un un ensemble de déclaration si vous voulez qui va fonctionner de cette manière, vous aurez une propriété, deux points suivi d'une valeur et un point virgule, c'est mieux de mettre un point virgule c'est plus propre.

+ style.css
```css
	/* un commentaire */
	P
	{
		/*
			<propriété>:<valeur>;
		*/
	}
```
Vous pouvez en avoir une seule propriété comme vous pourrez en avoir plusieurs d'accord s'il y a plusieurs propriétés, vous allez les marquer comme ça à la suite une propriété avec une valeur qui lui a appliqué, une autre propriété avec une autre valeur etc.

+ style.css
```css
	/* un commentaire */
	P
	{
		/*
			<propriété>:<valeur>;
			<propriété>:<valeur>;
			<propriété>:<valeur>;
			<propriété>:<valeur>;
		*/
	}
```
Et toutes ces propriétés là seront une mise en forme appliquée à toutes nos balises `<p>` donc à tous nos éléments de paragraphe de notre page html d'accord donc ça c'est une première possibilitée.

Alors nous allons faire, je vais montrer un petit exemple de propriété bien sûr tout cela vous allez l'apprendre par la suite dans les prochaines formations donc déjà on va voir ce que ça donne par défaut d'accord pour ne pas se tromper.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
</body>
</html>
```
+ style.css
```css
	/* un commentaire */
	P
	{

	}
```
Donc on va voir là d'accord donc on a un paragraphe tout bête.
```txt
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!
```
Pas de souci, je vais le faire sur `<body>`, ce sera mieux donc je rappelle par défaut pas de changement et au niveau du `<body>`, regardez, je vais utiliser une propriété de couleur de fond dans tout ça ne vous inquiétez pas on va l'apprendre par la suite donc là vous la connaissez pas mais c'est pas grave, on va l'apprendre par la suite voilà.

+ style.css
```css
	/* un commentaire */
	body
	{
		background-color:#DDD;
	}
```
Et pourquoi pas définir par exemple un largeur pour notre page de par exemple 1000 pixels et d'aligner notre bloc de contenu au centre de la page, `width:auto;`.

+ style.css
```css
	/* un commentaire */
	body
	{
		background-color:#DDD;
		margin:auto;
		width:1000px;
	}
```
Voilà donc trois propriétés qui ont chacune une valeur, voyez qu'elles sont séparés alors vous pouvez le mettre également tout à la ligne si vous voulez tout à fait possible de faire comme ça.

+ style.css
```css
	/* un commentaire */
	body
	{
		background-color:#DDD;margin:auto;width:1000px;
	}
```
Plus tard d'ailleurs on verra même sur un tuto comment minifier nos fichiers css c'est-à-dire pour accélérer leur exécution au niveau de nos pages donc par exemple afficher comme ça sera plus rapide.
```css
	background-color:#DDD;margin:auto;width:1000px;
```
Plus vous avez évidemment de choses dans un fichier css plus il sera long à lire donc le mieux, à la fin quand vous voulez optimiser vos page, c'est de minifier ces fichiers c'est à dire de virer tous les espaces en fait en trop ou autres d'accord ce que si vous faites ça évidemment ça va être beaucoup plus long à exécuter parce qu'il y a des espaces, des retours à la ligne et cetera.
```css
	body
	{
		background-color:#DDD;
		margin:auto;
		width:1000px;
	}
```
Donc tout peut être mis en fait sur une seule ligne, il n'y a pas de problème puisque vous voyez que tout est bien fermé en fait il y a toujours une présentation ici un sélecteur 'body', une balise ouvrante `{` tout un tas de propriétés avec des valeurs séparés par des points virgules d'ailleurs pour ça qu'on peut pas les mettre côte à côte et une accolade de fin `}`.

Du coup ici après je pourrais très bien mettre un autre truc, ouvrir l'accolade mettre quelque chose d'accord comme ceci et fermer et puis après de mettre encore autre chose, span je ne sais pas quoi et cetera.
```css
	body
	{
		background-color:#DDD;
		margin:auto;
		width:1000px;
	}p{color:blue;}span{...}
```
Voyez on peut tout mettre à la ligne sans problème voilà donc on va actualiser cette page pour voir ce qui se passe cette fois ci.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
</body>
</html>
```
+ style.css
```css
	/* un commentaire */
	body
	{
		background-color:#DDD;
		margin:auto;
		width:1000px;
	}
```
Et là vous voyez que le style css est appliquée nous avons maintenant donc un fonds qui est un peu plus gris qui n'est plus blanc pour le coup mais qui est gris. 
```txt
			Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
			Nam, omnis, perspiciatis, reprehenderit temporibus sint 
			porro libero et non aut nemo id animi eveniet perferendis 
			repudiandae aperiam mollitia expedita officia consectetur!
```
On a ici une largeur de 1000 pixels pour toute notre page parce que je rappelle que l'élément ici `<body>` qui concerne notre page web d'accord le corps de la page donc c'est là dessus que l'on a sélectionné en fait au niveau css pour appliquer des styles et en plus de ça on a aligné ce bloc d'accord de 1000 pixels parce que si on n'avait pas le margin:auto; tout simplement il se serait passé ça.
```txt
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!
```
Voilà c'est à dire que le bloc en fait il serait ici d'accord seulement il ne serait pas là donc ça c'est des choses importantes à savoir.

Voilà d'ailleurs je peux même vous montrer pour que ce soit plus visible à l'oeil nu, on va faire une espèce de bordures en rouge.
```css
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
</body>
</html>
```
+ style.css
```css
	/* un commentaire */
	body
	{
		background-color:#DDD;
		border:3px solid red;
		width:1000px;
	}
```
```txt
	+-----------------------------------------------------------+
	| Lorem ipsum dolor sit amet, consectetur adipisicing elit.	|
	| Nam, omnis,  perspiciatis, reprehenderit temporibus sint	|
	| porro libero et non aut nemo id animi eveniet perferendis |
	| repudiandae aperiam mollitia expedita officia consectetur!|
	+-----------------------------------------------------------+
```
Voilà donc voyez où elle se trouve.

Du coup si j'ajoute margin:auto;
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
</body>
</html>
```
+ style.css
```css
	/* un commentaire */
	body
	{
		background-color:#DDD;
		border:3px solid red;
		margin:auto;
		width:1000px;
	}
```
```txt
		+-----------------------------------------------+
		| Lorem ipsum dolor sit amet, consectetur		|
		| adipisicing elit. Nam, omnis,  perspiciatis,	|
		| reprehenderit temporibus sint porro libero et	|
		| non aut nemo id animi eveniet perferendis 	|
		| repudiandae aperiam mollitia expedita officia	|
		| consectetur!									|
		+-----------------------------------------------+
```
Tout ça ne vous inquiétez pas encore une fois on le verra.

Hop ça centre notre tout simplement notre bloc donc voyez ça fonctionne comme ça comme des blocs.

Voilà donc ça c'est clair ce niveau là.

Ccomment ça fonctionne du coup au niveau css ? C'est assez pratique à utiliser donc je rappelle que vous avez une déclaration à faire ici dans un groupe d'accord donc on va faire un sélecteur, on va choisir un sélecteur et on va définir plusieurs propriétés qui ont chacune une valeur séparées par des points virgules pour styliser certaines parties.

Donc on l'a fait sur un élément complet du html, body, mais on peut le faire je rappelle sur une balise `<p>` sans problème.

+ style.css
```css
	/* un commentaire */
	body
	{
		background-color:#DDD;
		border:3px solid red;
		margin:auto;
		width:1000px;
	}
	
	p{font-variant:small-caps;}
```
Le point virgule est pas obligatoire quand vous avez notamment qu'un seul élément mais moi je le mets pas habitude comme ça on n'a pas d'oubli.

Comprenez cette habitude là de mettre toujours des points virgules à la fin de chacune de vos propriétés comme ça il n'y aura jamais d'oubli, pas de problème et là voilà comment ça se passe.
```txt
			Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
			Nam, omnis, perspiciatis, reprehenderit temporibus sint 
			porro libero et non aut nemo id animi eveniet perferendis 
			repudiandae aperiam mollitia expedita officia consectetur!
			
			(petite lettre)
```
Voyez on a mis des petites lettres capitales pour tout le texte donc ça s'applique du coup sur le paragraphe `<p>` donc encore une fois on a utilisé un sélecteur ici sur un élément html.

Alors peut-être que certains désire ne pas le faire sur tout les paragraphe, si je ne veux pas le faire que sur certains, comment ça va fonctionner ?

Rappelez vous tout ce que j'avais évoqué sur la fin de la vidéo précédente parce qu'on a terminée avec html, avec les balises structurantes et je vous avez parlé notamment des éléments `<div>` et des éléments `<span>` en vous disant que `<div>` c'était un élément de bloc qu'on pouvait l'écrire comme ça ok.
```html
	<body>
		<div>
		
		</div>

		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
	</body>
```
Et que `<span>` c'était quelque chose que nous avions à l'intérieur par exemple donc un élément dit in-line que l'on avait par exemple à l'intérieur d'un texte ou autre voilà.
```html
	<body>
		<div>
		
		</div>

		<p>Lorem ipsum dolor sit amet, <span>consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
	</body>
```
Voilà et du coup on peut faire c'est 2 chose-là et là par exemple on peut mettre autre chose bla bla bla... d'accord pour faire tout ça.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div>
		bla bla bla...
	</div>

	<p>Lorem ipsum dolor sit amet, <span>consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
</body>
</html>
```
+ style.css
```css
	/* un commentaire */
	body
	{
		background-color:#DDD;
		margin:auto;
		width:1000px;
	}
	
	p{font-variant:small-caps;}
```
Voilà tout ça.
```txt

			bla bla bla...
			
			
(petite 	Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
lettre)		Nam, omnis, perspiciatis, reprehenderit temporibus sint 
			porro libero et non aut nemo id animi eveniet perferendis 
			repudiandae aperiam mollitia expedita officia consectetur!
```
Je vous avait expliqué qu'il y avait possibilité, de modifier d'ailleurs vous voyez que le `<div>` ça n'a pas changer parce que évidemment le sélecteur a directement fait la mise en forme que sur les paragraphes donc comme le `<div>` n'est pas un paragraphe vous voyez qu'il ne va pas être influencé par la mise en forme au niveau css.

Il aurait fallu faire div pour le modifier à ce moment-là.
```html
	div, p{font-variant:small-caps;}
```
Et je vous avais expliqué du coup qu'on pourrait utiliser certains attributs très précis, on avait un attribut 'id'.

'id' qui est un attribut unique que vous ne pouvez que sur un seul élément c'est par exemple un élément ici bloc comme ceci.
```html
	<div id="bloc">
		bla bla bla...
	</div>
```
Je ne pourrais pas refaire ailleurs dans mon programme, un 'id' égale "bloc" aussi parce que je ne peux pas avoir deux fois le même identifiant ici dans une page web c'est pas possible.

Par contre si on veut avoir plusieurs fois le même on pouvait utiliser l'attribut 'class' voilà et ça je vous avais dit que une fois que nous verrions css ce serait très pratique pour utiliser des identifiants et des classes directement dans nos fichiers css et ici on va faire ça.
```html
	<body>
		<div id="block">
			bla bla bla...
		</div>

		<p>Lorem ipsum dolor sit amet, <span class="text-red">consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
	</body>
```
Et là on va pouvoir du coup changer le sélecteur donc le sélecteur par défaut le plus simple c'est un élément html (body, p, ...) et vous pouvez également sélectionner un identifiant d'une classe donc soit vous faites simplement juste ça donc je met un dièse et block ici et ça veut dire que ce qui est d'identifiant block on va lui appliquer un style.
```css
>	#block
	{
	
	}
```
Si par contre vous voulez dire absolument un identifiant block qui a été mis sur un `<div>` il suffit de coupler les deux, vous faites comme ceci div#block et div est collé au dièse donc ça veut dire tous les éléments html `<div>` qui ont l'identifiant block vont avoir le style à appliquer.
```css
>	div#block
	{
	
	}
```
Voez c'est très simple à comprendre, très simple à lire et pour le `<span>`, il suffit de dire ça tout span de class donc là on met un point (on ne met pas un dièse) de classe text-red va avoir le style suivant d'accord.
```css
>	div#block
	{
	
	}
	
>	span.text-red
	{
	
	}
```
Alors on va montrer autre chose et faire ça voyez la différence.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div id="block">
		bla bla bla...
	</div>

	<p>Lorem ipsum dolor sit amet, <span class="text-red">consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
	
	<span class="text-red">Un autre texte</span>
</body>
</html>
```
Ensuite je vais enlever le div parce qu'on a un seul block.
```css
>	div#block			#block
	{					{
	
	}					}
```
Donc par exemple pour bloc je peux très bien faire comme ceci, avec des petit arrondi border-radius.

+ style.css
```css
	/* un commentaire */
	body
	{
		background-color:#DDD;
		margin:auto;
		width:1000px;
	}
	
	p{font-variant:small-caps;}
	
	#block
	{
>		background-color: #FFF;
>		border: 1px solid #000;
>		border-radius:8px;
	}
	
	span.text-red
	{
	
	}
```
Donc je vais actualiser ça.
```txt
	o---------------------------------------------------------------o
	| bla bla bla...												|
	o---------------------------------------------------------------o
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!

	Un autre texte
```
Ne vous atterdez pas sur ce que j'ai écris là parce que c'est des choses qu'on n'a pas encore appris, on s'en fiche parce que ce qui est important c'est de voir la syntaxe et de voir comment ça réagit au niveau de la page, c'est pas d'apprendre des propriétés, c'est pas pour tout de suite donc voilà comment ça s'applique.

Vous voyez que le `<div>` donc au niveau du sélecteur, on lui a dit que tout élément d'identifiant block aura une couleur de fond blanche.
```css
	background-color: #FFF;
```
... aura une bordure d'1 pixel noir.
```css
	border: 1px solid #000;
```
... et on aura des coins arrondis à 8 pixels et du coup c'est ce qui se passe ici.
```css
	border-radius:8px;
```
là d'accord c'est exactement ce qui s'est passé ici.

D'ailleurs on peut très bien faire ceci, `padding:10px;`

+ style.css
```css
	/* un commentaire */
	body
	{
		background-color:#DDD;
		margin:auto;
		width:1000px;
	}
	
	p{font-variant:small-caps;}
	
	#block
	{
		background-color:#FFF;
		border: 1px solid #000;
		border-radius:8px;
>		padding:10px;
	}
	
	span.text-red
	{
	
	}
```
Voilà on fait ceci avec une marge, c'est des choses qu'on verra plus tard.
```txt
	o---------------------------------------------------------------o
	|																|
	| bla bla bla...												|
	|																|
	o---------------------------------------------------------------o
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!

	Un autre texte
```
Et là une marge du coup ça permet de séparer bla bla bla... donc ça s'applique vraiment qu'à cet élément d'accord grâce à ça.

Par contre si je venais à faire un autre div donc si je fais admettons ça d'accord.
```css
	#block{}	->	div#block{}
```
Et puis que plus tard j'ai un autre `<div>` hop si j'actualise.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div id="block">
		bla bla bla...
	</div>
	
	<div>
		Un autre div...
	</div>

	<p>Lorem ipsum dolor sit amet, <span class="text-red">consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
	
	<span class="text-red">Un autre texte</span>
</body>
</html>
```
```css
	/* un commentaire */
	body
	{
		background-color:#DDD;
		margin:auto;
		width:1000px;
	}
	
	p{font-variant:small-caps;}
	
>	div#block
	{
		background-color:#FFF;
		border: 1px solid #000;
		border-radius:8px;
		padding:10px;
	}
	
	span.text-red
	{
	
	}
```
```txt
	o---------------------------------------------------------------o
	|																|
	| bla bla bla...												|
	|																|
	o---------------------------------------------------------------o
	Un autre div...
	
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!

	Un autre texte
```
Hop si j'actualise vous voyez que le style ne s'applique pas, pourquoi ? parce qu'au niveau css encore une fois je lui dis que tout ça.
```css
>	div#block
	{
		background-color:#FFF;
		border: 1px solid #000;
		border-radius:8px;
		padding:10px;
	}
```
... il appliquait que sur l'identifiant div qui ont l'identifiant block et comme ce `<div>` là n'a pas d'identifiant il n'est pas affecté par la mise en forme qui est appliqué.
```css
	<div>
		Un autre div...
	</div>
```
Alors maintenant pour le texte, vous voyez ici pour un `<span>` je peux utiliser une 'class' donc une 'class' en fait vous allez pouvoir ré-utiliser par exemple "text-red" partout où vous voulez, c'est pour ça que ici je l'utilise deux fois pour dire ici on va mettre ces texte en rouge.
```html
	<p>Lorem ipsum dolor sit amet, <span class="text-red">consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
	
	<span class="text-red">Un autre texte</span>
```
Alors je montre rapidement même si encore une fois vous l'apprendrez plus tard on va juste faire ça hop et là j'actualise et voilà comment ça se passe.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div id="block">
		bla bla bla...
	</div>
	
	<div>
		Un autre div...
	</div>

	<p>Lorem ipsum dolor sit amet, <span class="text-red">consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
	
	<span class="text-red">Un autre texte</span>
</body>
</html>
```
+ style.css
```css
	/* un commentaire */
	body
	{
		background-color:#DDD;
		margin:auto;
		width:1000px;
	}
	
	p{font-variant:small-caps;}
	
	div#block
	{
		background-color:#FFF;
		border: 1px solid #000;
		border-radius:8px;
		padding:10px;
	}
	
	span.text-red
	{
>		color:red;
	}
```
```txt
	o---------------------------------------------------------------o
	|																|
	| bla bla bla...												|
	|																|
	o---------------------------------------------------------------o
	Un autre div...
	
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!

	Un autre texte
```
Alors le texte s'est mis en rouge aux deux endroits et du coup je peux encore affinés si je veux par exemple mettre le texte en rouge seulement dans des paragraphes d'accord et bien je peux ici affiner le sélecteur span.text-red en disant toutes les balises `<p>` d'accord.
```css
>	p span.text-red
	{
		color:red;
	}
```
Donc dans les balises `<p>` ok, les paragraphes, dès qu'il y à un 'span' qui a la class text-red, on met le texte en rouge et à ce moment-là si j'actualise la page ça ne fonctionne plus sur le 2ème, pourquoi parce qu'encore une fois ici il n'est pas dans un paragraphe.
```html
	<span class="text-red">Un autre texte</span>
```
Donc le seul moyen ici de l'avoir également en rouge bien sûr ce sera de faire ça.
```html
	<p><span class="text-red">Un autre texte</span></p>
```
Voilà pour qu'il rentre dans le sélecteur du css et là ça fonctionne.

Voilà comment ça fonctionne j'ai pris le temps de vous l'expliquer, j'ai été assez long là dessus parce que je pense que c'est la base vraiment en css et si vous avez compris ça après vous aurez compris tout le fonctionnement au niveau des sélecteurs, au niveau des balises.

Il y a ou il y aura, tout dépend du moment où vous voyez cette vidéo un tutoriel en annexe sur les sélecteurs parce qu'il y a beaucoup de choses à dire sur les  sélecteurs donc je ne veux pas faire un cours dessus parce qu'il y en a beaucoup trop beaucoup trop donc je préfère juste au fur et à mesure de la formation vous montrer les sélecteurs les plus courants mais je réserve quand même un tuto en annexe où là vraiment on rentrera dans les détails de sélecteurs pour voir toutes les petites manipulations qu'on peut faire avec ça parce que c'est vachement puissants.

Et donc beaucoup beaucoup de possibilités avec les sélecteurs par exemple sur un élément qui est fils d'un autre ou qui est parent d'un autre ou un élément qui suit directement un autre etc ou des sommes en fait d'éléments bref il y a vraiment plusieurs types de sélecteurs différents et comme il y en a beaucoup à voir et beaucoup à connaître je ferai un tuto là-dessus ou alors peut-être qu'il est déjà là si vous voyez cette vidéo un peu plus tard que le moment où je l'enregistre; il est possible que le tutoriel soit déjà publiés entre temps.

Donc voilà pour cette partie ici, je vous ai dit tout ce que je voulais au niveau de la syntaxe donc vous voyez un petit peu comment ça fonctionne, c'est très simple.

Donc encore une fois on peut se faire un sélecteur sur un élément directement donc via son nom `body{}`, on peut faire un sélecteur sur un 'id' `#block` d'accord un identifiant, on peut faire un sélecteur sur une classe donc avec un point `span.text-red`.

Sinon je rappelle l'identifiant c'est un # et c'est unique, on ne peut pas avoir dans une page web plusieurs éléments avec le même nom d'identifiant d'accord.

Ici si je veux faire un autre 'id', je serais obligé de lui donner un autre nom genre "block2".
```html
	<div id="block">
		bla bla bla...
	</div>
	
	<div id="block2">
		bla bla bla...
	</div>
```
Je ne peux pas mettre "block" également encore si je fais ça.
```html
	<div id="block">
		bla bla bla...
	</div>
	
	<div id="block">
		bla bla bla...
	</div>
```
... ce n'est pas possible ok voilà, on ne peut pas l'appliquer à ce niveau là.

Normalement 'id' est vraiment quelque chose d'unique ok bon ça c'est important à savoir pour cette partie là.

Voilà donc je vous ai dit qu'il y avait l'élément html au niveau syntaxe, qu'il y avait l'identifiant et le sélecteur sur une classe `span.text-red` mais il y a également sur les attributs mais ça on le verra peut-être plus sur les formulaires.

On pourra en fait influer sur des attributs particulier par exemple de dire je sais pas moi un élément de formulaire qui à l'attribut un tel, on lui appliquera un style donc on peut également influencer certaines choses avec les attributs.

Les attributions se mettent entre crochets genre par exemple ici on peut dire toutes balises p[] qui à la attribut 'title' égal quelque chose, p[title=] ou même juste title, `p[title]`, on lui appliquera ce style là ...
```css
	p[title] span.text-red
	{
		color:red;
	}
```
Voyez on peut faire vraiment des sélecteurs très très très précis pour modifier vraiment exactement les choses que l'on veut mais ça pareil, on aura l'occasion de toute façon de les montrer plus tard en css donc je ne vais pas non plus rallonger les choses inutillement avec ça, on aura l'occasion de les manipuler donc c'est surtout ça qui est important.

Voilà alors est-ce que je vous présente d'autres choses pour cette intros parce que c'est vraiment la première vidéo en css et là on commence vraiment doucement dont je vais vous montrer la syntaxe parce que c'est quand même super important à savoir.

Au niveau de l'ordre, comment le fichier css va appliquer les styles si notamment par exemple on a plusieurs choses qui sont appliquées au cours de notre fichier ? comment que ça va se passer ? On va réduire nos fichiers.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<p>Lorem ipsum dolor sit amet, <span class="text-red">consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
</body>
</html>
```
+ style.css
```css
	/* un commentaire */
	body{background-color:#DDD;margin:auto;width:1000px;}
	p{font-variant:small-caps;}
	.text-red{color:red;}
```
Alors donc ça réduit au niveau de la taille et du coup voilà comment ça se présente.
```txt
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!
```
On va voir comment ça va se passer, le css va lire de manière séquentielle c'est à dire que notre fichier va appliquer les styles en fait au fur et à mesure de la lecture d'accord donc si par exemple vous avez un fichier défini, il va en premier prendre les éléments du haut donc il va définir les style.

Et s'il y a des styles par exemple que vous réécrivez par la suite il va les écraser encore non par exemple si je montre ça vous allez avoir ceci.
```txt
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!
```
Si admettons je fais ce serait honnêtement bizarre, je vous le dit clairement c'est pas logique du tout mais allons-y pourquoi pas.
```css
	.text-red{color:red;}
	.text-red{color:blue;}
```
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<p>Lorem ipsum dolor sit amet, <span class="text-red">consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
</body>
</html>
```
+ style.css
```css
	/* un commentaire */
	body{background-color:#DDD;margin:auto;width:1000px;}
	p{font-variant:small-caps;}
	.text-red{color:red;}
	.text-red{color:blue;}
```
Pourquoi pas voyez que là le style se met en bleu tout simplement parce que le css a fait quoi ? il a lu séquentiellement le fichier mais là il voit que la classe "text-red" on doit définir la couleur à rouge et puis d'un coup finalement on dit que "text-red" doit être défini à bleu donc cette propriété là d'accord.
```css
	.text-red{color:blue;}
```
... cette définition là va écraser l'ancienne donc c'est simple d'accord c'est très logique c'est tout ce qui a été déclaré en fait au plus tard et du coup ce qui va écraser le reste des style.

Petite exception en revanche si par exemple vous utilisez (c'est pas propre encore une fois) du css directement ici d'accord.
```html
	<span class="border:2px dashed;">
```
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<p>Lorem ipsum dolor sit amet, <span class="border:2px dashed;">consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
</body>
</html>
```
+ style.css
```css
	/* un commentaire */
	body{background-color:#DDD;margin:auto;width:1000px;}
	p{font-variant:small-caps;}
	.text-red{color:red;}
	.text-red{color:blue;}
```
Voilà ce n'est pas propre, à éviter complétement donc là ce style css.
```html
	<span class="border:2px dashed;">
```
... serra toujours prioritaire au fichier, pourquoi ? parce qu'en fait il part du principe que la page html va se charger en chargeant tous les fichiers css externes que vous avez parce que vous n'êtes pas obligés d'en avoir qu'un seul.

Vous pouvez avoir d'autres fichiers css et ensuite il va du coup lire le fichier donc le contenu de la page html et comme ces attributs vont être par la suite donc si par exemple vous avez un style ici qui avait déjà été définis dans le fichier css, il sera écrasé.

Admettons que l'on dise que les élément span n'ont pas de bordure d'accord.

+ style.css
```css
	/* un commentaire */
	body{background-color:#DDD;margin:auto;width:1000px;}
	p{font-variant:small-caps;}
	.text-red{color:red;}
	.text-red{color:blue;}
>	span{border:none}
```
Et au final dans le html ici en in line, pour ce `<span>` a une bordure de 2px.
```html
	<span class="border:2px dashed;">
```
Et bien là voyez que ça ne changerait d'accord parce que cet élément là span{border:none} du coup a été ignorée même s'il a été au début chargé effectivement mais comme on a eu maintenant ceci : `<span class="border:2px dashed;">` et bien pour le coup on a écrasé le style.

Par contre si j'écrivais un autre `<span>` puisque je n'ai pas appliquer ce style là `border:2px dashed;` il aurait ce qu'on a marqué dans style.css d'ailleurs je peux vous le montrer comme ceci, on va remettre un autre `<span>` mais sans lui mettre l'attribut style mais c'est pour que vous compreniez que je prenne vraiment le temps de bien vous l'expliquer donc si je fais juste un `<span>` comme ça tout seul.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<p>Lorem ipsum dolor sit amet, <span class="border:2px dashed;">consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
	
	<p>Lorem ipsum dolor sit amet, <span>consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
</body>
</html>
```
+ style.css
```css
	/* un commentaire */
	body{background-color:#DDD;margin:auto;width:1000px;}
	p{font-variant:small-caps;}
	.text-red{color:red;}
	.text-red{color:blue;}
	span{border:none}
```
là évidemment (pour le 2e paragraphe) vous voyez qu'il applique le fichier css seulement voilà parce que ça `border:2px dashed;` ça vient vraiment écraser le fichier donc ce qui était écrit dans le fichier css par contre au 2e paragraphe comme j'applique pas de style supplémentaires pas de souci il prend ce qu'il y avait par défaut c'est à dire ça d'accord.
```css
	span{border:none}
```
Je pense que vous avez bien compris maintenant comment ça fonctionne l'ordre des choses c'est à savoir parce que je sais qu'il y a des fois des personnes qui essaient d'appliquer des styles et qui ne comprennent pas et qu'ils essayent par exemple de modifier tel élément et en fait il reste comme avant ou il n'a pas bougé, il n'a pas été modifié c'est souvent un problème d'ordre au niveau de la mise en forme de vos page web en fait.

Attention à bien respecté pour avoir bien sûr la mise en forme que vous voulez c'est super important.

Et je termine avec un dernier point, un petit bonus mais c'est toujours bien à savoir quand vous avez par exemple très rapidement.

Admettons je dit que mon `<header>`, est margin:auto et pareil mon `<footer>` est en margin:auto et puis que le texte dessus est centré. Et que `<header>` fasse 100px de haut par exemple, fin bref je met pleins d'autres éléments ...

+ style.css
```css
	/* un commentaire */
	body{background-color:#DDD;margin:auto;width:1000px;}
	header{margin:auto;height:100px;}
	footer{margin:auto;text-align:center;}
```
Ici on a plein de propriété identique qui se répète avec les mêmes valeurs sur 3 sélecteurs et bien vous pouvez les grouper et vous pouvez très bien faire ceci et séparer avec des virgules, les sélecteurs.

+ style.css
```css
	/* un commentaire */
>	body,header,footer{}
	body{background-color:#DDD;margin:auto;width:1000px;}
	header{margin:auto;height:100px;}
	footer{margin:auto;text-align:center;}
```
Ici vous dégagez en fait, vous factoriser en fait la propriété qui est identique dans tous les cas où vous la rencontrez et là du coup vous alléger votre fichier.

+ style.css
```css
	/* un commentaire */
	body,header,footer{margin:auto;}
	body{background-color:#DDD;width:1000px;}
	header{height:100px;}
	footer{text-align:center;}
```
Pensez toujours optimisation d'accord quand vous avez comme ça des répétitions de propriétés avec des valeurs identiques plutôt que de les répéter à chaque fois dans chaque sélecteur, vous les rassemblez ensemble d'accords vous mettez tous les sélecteurs ensemble pour dire bah voilà les trois là ils ont un margin:auto; et après vous pouvez faire les 3 autres lignes ça ne pose aucun problème.

On peut d'ailleurs encore après faire ça c'est évidemment la même chose pour le coup.

+ style.css
```css
	/* un commentaire */
	body{background-color:#DDD;width:1000px;}
	header{height:100px;}
	footer{text-align:center;}
	body,header,footer{margin:auto;}
```
l'important c'est qu'à la fin, la marge ici en automatique se soit bien appliquée pour nos trois éléments puisque c'est ce que nous voulions faire à la base, il n'y a pas de problème à ce niveau là et du coup on va pouvoir appliquer les choses comme il faut donc ça fait attention également c'est important question optimisation.

N'oubliez pas qu'un fichier css moins il a de ligne moins il aura de taille en ce qui concerne le fichier en lui-même ici d'accord vous voyez le fichier css fait 148 octets donc plus la taille du fichier est petit, plus il sera rapide à charger, plus vos pages seront rapides également d'accord plus un fichier est gros et plus ça pose problème donc faites attention.

Egalement petit point important, on pourrait se demander du coup alors est-ce qu'il n'est pas mieux pour un fichier qui est vraiment très très gros de le séparer en plusieurs petits ?

Alors oui et non, oui dans le sens où si vous n'avez qu'un seul gros fichiers à charger, il peut prendre du temps a charger.

Par contre l'avantage c'est que maintenant les navigateurs propose un système de cache la plupart du temps et les gens qui font des sites web auront un système de cash sur leur site web en plus d'accord donc le système de cash du navigateur plus le système du cash créé directement via le site permet de mettre notamment le css en cache c'est à dire qu'il ne va pas être chargée à chaque fois.

Il va être chargé une seule fois et à vos prochaines visites sur le site et ben il va recharger le ccs qui était déjà existants donc au final ce gros fichiers ce ne sera pas tellement gênant, ça va être gênant la première fois mais après il sera chargé rapidement.

Tandis que si vous avez plusieurs fichiers css il va y avoir des requêtes effectuées à chaque fois, des requêtes http.

Et ça des requêtes http, on évite d'en faire 15000, plus i y en a et plus c'est pareil, on va ralentir tout simplement la navigation, ce ne sera pas agréable du tout pour l'utilisateur.

Donc le mieux c'est d'avoir le moins de fichiers css possible et si vraiment vous avez besoin de plusieurs ça peut être utile dans le cas par exemple où vous avez des styles qui vont s'appliquer pour une seule page par exemple de votre site.

Admettons vous avez une page très particulière de votre site où il y a des éléments qui sont introuvables nulle part ailleurs sur le site, ça paraît logique de ne pas utiliser cette mise en forme css sur les autres pages.

Si c'est jamais utilisé autant que vous chargiez les fichiers css en fonction de ce que vous avez besoin, au jour où vous avez défini des styles pour un forum c'est peut-être plus intéressant de charger ce style pour un forum qui peut être assez lourd seulement quand on est sur le forum et pas ailleurs sur le site sinon bah vous allez charger des propriétés en fait que vous n'allez jamais utiliser.

Donc ça éventuellement on peut y penser mais voilà encore une fois tout dépend de la taille de votre site, tout dépend de l'envergure d'accord donc quand vous serez sur des gros projets, sur des gros sites web, vous pourrez vous poser la question sinon en attendant pour un simple blog voilà des sites tout à fait modeste vous pouvez vous contenter d'un seul fichier css ça ne posera pas de problème.

Voilà comment ça fonctionneme.

Il y a une autre chose aussi qui est importante, il faut savoir que les navigateurs sont assez capricieux sur certaines choses c'est à dire que chacun applique un petit peu son style par défaut.

Tous les navigateurs, ils décident chacun de dire par exemple que nous les balises `<p>` et on leur met une marge 3 pixels comme ça par défaut et puis on en parle plus.

Et puis la balise `<body>` pareil on lui donne un style css par défaut etc etc

Le truc c'est que si tous les navigateurs étaient d'accord sur les styles par défaut, vous n'aurez pas de problème.

Le souci c'est que quand vous avez tester un site d'accord vous allez tester par exemple sur chrome vous allez un affichage, vous allez tester sur firefox, il va y avoir des différences.

Vous allez tester sur internet explorer ou sur microsoft edge, ou autres, opéras ou je ne sais quoi et vous allez avoir tout un tas de différence à chaque fois.

Si vous voulez éviter un maximum ça même s'il y a certaines choses qu'on ne peut forcément pas modifier mais en tout cas à 99% vous pouvez appliquer si vous voulez un style par défaut pour tout vous pouvez utiliser un fichier css de reset c'est à dire un fichier qui va reset toutes les propriétés basique des fichiers par exemple tous les éléments `<p>` et cetera en leur mettant une marge pareil pour tout le monde.

Ca permet de partir sur une base et vous avez pas mal de sites qui proposent ça, je pense notamment au site normalized d'accord.

https://csstools.github.io/normalize.css/

Vous taper normalize sur un moteur de recherche et vous devriez trouver la possibilité de télécharger un gros fichier css qui s'appelle normalize.css donc c'est très simple et vous aurez juste a ajouté ici d'accord, il faudra l'ajouter avant "style.css" c'est important.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Introduction design</title>
	<link rel="stylesheet" href="normalize.css">
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<p>Lorem ipsum dolor sit amet, <span class="border:2px dashed;">consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
	
	<p>Lorem ipsum dolor sit amet, <span>consectetur adipisicing elit</span>. Nam, omnis, perspiciatis, reprehenderit temporibus sint porro libero et non aut nemo id animi eveniet perferendis repudiandae aperiam mollitia expedita officia consectetur!</p>
</body>
</html>
```
Voilà il faut ajouter donc le fichier téléchargé de reset est on bref le fichier qui va réinitialiser toutes les balises, chargé en premier et ensuite vous chargez votre fichier css donc vous en aurez 2 mais au moins celui là le premier vous assurera que tous les navigateurs auront le même affichage de base par défaut.

Et comme ça après vous pouvez faire votre mise en forme sur un style par défaut quel que soit le navigateur ça va énormément vous faire gagner du temps et ça vous évitera des fois des arrachages de cheveux parce que vous voyez des différences pas possible entre les navigateurs alors que pourtant vous avez défini vos propriétés comme il faut.

Ca c'est les petites astuces comme ça à savoir que je vous donne au départ parce que maintenant que je les donné, vous serez tranquille pour la suite et vous n'allez pas garer de galérer comme certains en css et je vais rester avec ça. Je pense que j'ai fait une bonne introduction qu'il y a eu suffisamment de choses déjà à vous dire et à vous présenté.

Evidemment dans la prochaine vidéo on va commencer à découvrir quelques propriétés intéressantes donc on va travailler sur les couleurs, sur la mise en forme des textes, la mise en forme des éléments après on verra comment positionner des éléments bref comment faire des petits style sympa donc ça c'est la partie la plus marrante.

Autant html c'est plus du fond donc c'est pas spécialement le plus intéressant alors que css va vraiment créer un design, on va mettre en forme tout ça donc on va pouvoir commencer à obtenir des pages web assez intéressante et pourquoi pas par la suite sur la playlist des exercices qui sera disponible parce que je proposerai des exercices notamment la création d'un petit projet donc un petit site web tout simplement html css qui pourquoi pas pourrait être repris par la suite avec php ou autres pour en faire clairement un site dynamique donc ça peut être sympa.

Ce ne sera pas un très très gros projet le but c'est de faire un exercice assez simples, accessibles pour tout le monde mais ça permet quand même de mettre en pratique tout ça que vous voyez comment ça fonctionne dans la réalité lorsqu'on développe un site web.

Voilà je vous laisse avec ça à bientôt tout le monde du coup pour la séance 15 en html css et en attendant entraînez vous bien et si vous avez des questions n'hésitez pas à laisser des commentaires.

Ciao tout le monde