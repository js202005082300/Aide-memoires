# [13. Structurer page web](https://www.youtube.com/watch?v=kvjz6GyiQsE)
21-01-21

Bonjour à tous, bienvenue sur la 13ème séance et une dernière vidéo concernant html donc pur html mais en tout cas, nous allons voir comment structurer nos page web.

Après sur cette formation nous allons attaquer css donc évidemment il y aura toujours du html mais on va l'utiliser avec css donc c'est vraiment la dernière vidéo d'apprentissage de quelques balises html qui vont vous servir pour la création de vos pages web.

Ici on va voir comment s'occuper de la structure de nos pages.

Ici jusqu'à présent je vous ai montré plein de baliste d'accord comment faire des paragraphes, comment mettre un texte plus important, comment faire des titres, des liens, des images, comment gérer même des médias comme les vidéos bref on a vu tout un tas de petites choses très intéressantes au niveau de nos pages mais on n'a pas vu non plus comment structurer ça à l'intérieur.

Vous avez tout un ensemble de balises mais ce qui est quand même intéressant de voir c'est comment structurer, comment organiser la hiérarchie au sein de nos pages pour que ce soit évidemment correctement conçus et surtout valide toujours pareil au niveau des normes du w3c d'accord donc ça c'est pareil, je vous renvoie vers les tutoriels de la playlist html css tutoriel où vous avez tout un tas de choses en annexe d'accord en complément du cours qui vous serviront à votre apprentissage d'html et de css.

Alors sur cette dernière vidéo pure html au niveau de la structuration je vais vous montrer quelques balises très utiles, des balises qui vont vraiment être indispensable pour pouvoir fabriquer vos pages web et structurer à l'intérieur les choses convenablement.

Alors jusqu'à présent avant même l'arrivée d'html 5 on a vu deux balises qui était popularisée pour faire ce genre de choses.

La première est une balise qui s'appelle `<div>` donc cette balise là va agir comme un bloc c'est à dire qu'elle va réserver un bloc de contenu au sein de la page. On peut le montrer tout simplement par exemple en mettant un texte ici.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Structurer page web</title>
	</head>
	<body>
		<div>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!</p>
		</div>
		<div>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!</p>
		</div>
	</body>
	</html>
```
Voilà je peux très bien en gérer plusieurs.

Imaginez en fait un bloc de contenus d'accord, un `<div>` pour dire une division, une division au sein de la page.

Dans un `<div>` j'ai un paragraphe mais j'aurais pu très bien en avoir deux puis mettre un lien après par la suite ce genre de choses.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<div>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!</p>
	</div>
	<div>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!</p>

		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!</p>
		
		<p><a href="#">Un lien...</a></p>
	</div>
</body>
</html>
```
On va actualiser notre page pour regarder un petit peu ce qu'il en est et voilà ce qu'on aura.
```txt
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!

	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!

	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!

	Un lien...
```
Donc on va avoir vraiment une portion alors encore une fois pour html on va pas forcément voir la différence d'accord il n'y a pas d'aspect visuel au niveau des divisions de la page, ça ne va pas faire des cadres par exemple avec des encadrements mais on a la première partie (les 3 paragraphes Lorem) et la deuxième avec le lien d'accord, on va avoir des divisions qui sont faites.

Au niveau du code source évidemment on retrouve ce que je vous ai montré au niveau du reste de la page donc ça c'est pour faire des blocs de contenu d'accord ça va agir comme étant un bloc.

On peut également travailler directement en ligne donc c'est à dire de modifier ou d'agir vraiment sur un élément en ligne donc au sein d'un contenu.

Par exemple dans mon paragraphe, je peux très bien ici vouloir appliquer quelque chose en particulier sur ce morceau de texte.

Pour cela on utiliserait la balise `<span>` comme ceci alors pour dire voilà d'appliquer quelque chose par la suite à cet ensemble là.
```html
	<div>
		<p>Lorem ipsum dolor sit amet, <span>consectetur adipisicing elit</span>. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!</p>
	</div>
```
Pareil si j'actualise vous n'allez voir absolument aucun changement.

Là où ce sera utile ce genre de cas c'est après avec css on verra qu'on pourra utiliser des 'id' ou des 'class' càd des identifiants des classes qui vont directement agir sur les `<div>` ou les `<span>` mais ne vous inquiètez pas tout ça on le verra bien évidemment par la suite sur la formation.

Et par exemple dire que ce texte ici on le met en rouge par exemple.
```html
	...<span>consectetur adipisicing elit</span>
```
On pourra utiliser une classe en css qui permettra de mettre du texte en rouge à chaque fois qu'on utilisera dans un `<span>` non comme c'est quelque chose qui agit sur un élément dit en ligne d'accord inline donc à l'intérieur comme ça d'un contenu.

On pourra le faire avec `<span>`.

En revanche si on veut appliquer un style précis d'accord au design sur un blog complet, le contenus admettons que on veut par exemple pour ce paragraphe là lui mettre une couleur de fond par exemple en gris d'accord pour que ce soit un peu plus foncé ici que le blanc par défaut eh bien on le fera directement sur ce `<div>`-là.
```html
	<div>
		<p>Lorem ipsum dolor sit amet, <span>consectetur adipisicing elit</span>. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!</p>
	</div>
```
Ici on utilisera une 'class' ou un 'id' et en css on appliquera une couleur de fond en gris par exemple.

Voilà à quoi il sert, `<div>` permet comme ça de structurer et d'organiser nos pages.

Avec html s'était pas assez précis parce que le problème d'un `<div>` c'est juste pour diviser d'accord pour faire une division au sein du document donc le document ici en l'occurrence le body d'accord tout ce qu'il y a dans body et ce n'était pas forcément suffisamment clair parce que `<div>` ça n'a pas de nom en particulier, ça n'a pas de nom.

Il y avait rien qui permettait de dire quelle portion de la page, ce à quoi ça correspond, quelle portion ça définit et dans une page web on retrouve quand même des éléments assez similaires.

On peut retrouver une en tête de page d'accord avec par exemple un logo, un titre du site, on peut retrouver un menu de navigation d'accord naviguer sur le site voir naviguer sur les différents éléments de la page.

On peut retrouver une partie copyright, on peut retrouver aussi des liens par exemple en pied de page pour accéder à différentes informations comme les mentions légales, l'à-propos, ce genre de choses.

On peut retrouver des articles, on peut retrouver par exemple des commentaires bref on voit comme ça qu'il y a des éléments assez similaires et html 5 a justement ajouter d'autres balises par la suite.

Donc grosso modo si on regarde avant html5 en tout cas avec les `<div>` et `<span>` voilà un petit peu comment que ça se passait d'accord je vous essayez de schématiser ça très simplement pour que vous voyez comment que ça se passe au niveau des blocs.
```txt
	+-----------------------------------+
	| <div>								|
	|									|
	+-----------------------------------+
	
	+-----------------------------------+
	| <div>								|
	|									|
	| bla bla bla <span>bla bla</span>	|
	| bla bla bla bla bla bla bla bla	|
	|									|
	+-----------------------------------+

	+---------------+	+---------------+
	| <div>			|   | <div>			|
	|				|   |				|
	+---------------+   +---------------+
```
Alors la dernière ligne, vous avez un bloc à gauche, un bloc à droite, ça c'est pareil tout ce qui est alignement et positionnement c'est des choses qu'on verra en css par défaut html lui va gérer tout ce qui est mis l'un en dessous de l'autre donc à le 1er `<div>` et puis le second `<div>` etc.
```txt
	1er...
	
	<div>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!</p>
	</div>
	
	2e...
	
	<div>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!</p>

		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, optio, saepe aliquam praesentium maxime expedita cumque possimus quidem architecto officiis incidunt repudiandae omnis velit esse quibusdam corporis aliquid aut est!</p>
		
		<p><a href="#">Un lien...</a></p>
	</div>
```
Donc ça ce sera le premier, ça ce sera le deuxième et cetera d'accord il y en a pas un qui sera à gauche et l'autre à droite, c'est des choses qui seront à faire en css d'accord donc on peut s'imaginer par exemple qu'au niveau du document html, on a écrit le `<div>` n°1, ensuite celui le `<div>` n°2 dans le quel on a écrit du `<span>` aussi puis le `<div>` n°3 et le `<div>` n°4.
```txt
	<div> n°1
	+-----------------------------------+
	| <div>								|
	|									|
	+-----------------------------------+
	
	<div> n°2
	+-----------------------------------+
	| <div>								|
	|									|
	| bla bla bla <span>bla bla</span>	|
	| bla bla bla bla bla bla bla bla	|
	|									|
	+-----------------------------------+
	
	<div> n°3
	+---------------+
	| <div>			|  
	|				|  
	+---------------+  

	<div> n°4
	+---------------+
	| <div>			|
	|				|
	+---------------+
```
Ensuite on a écrit suis `<div>` n°3 et ensuite on a écrit `<div>` n°4 et par la suite en css ont les positionnent là où on veux d'accord, on peut même redéfinir une largeur et une hauteur éventuellement voilà un petit peu comment que ça se passe.

Au niveau html 5, on a instauré du coup un ensemble de nouvelles balises qui seront très utiles donc ces balises attention je vais vous expliquez par la suite, il ne faut pas pour autant les abandonner d'accord mais ça on va y revenir de toute façon après.

Par exemple on va en avoir une première donc je vais en parler et qui est la balise `<main>` d'accord.

La balise `<main>` c'est une balise qui va être mise dans le `<body>` bien évidemment, il va y en avoir qu'une seule alors une seule pour être plus être plus précis une seule affichée parce que vous pourriez très bien dire par exemple je masque une portion `<main>` du document mais de manière générale vous ne devez avoir qu'une seule section `<main>` ici dans une page web d'accord.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Structurer page web</title>
	</head>
	<body>
		<main></main>
	</body>
	</html>
```
De manière générale, vous ne devez avoir qu'une seule section `<main>` ici dans une page web d'accord vous ne pouvez ps en avoir plusieurs à moins de cacher l'un deux, pareil de le mettre en hidden mais pareil je vous déconseille de faire ça.
```html
	<body>
		<main></main>
		
		<main></main>
	</body>
```
Vous ne pouvez en avoir qu'une seule.

Le `<main>` c'est tout simplement le contenu principal du `<body>` donc du document d'accord c'est vraiment tout ça que vous allez avoir donc c'est la partie principale de votre site d'accord de la page qui s'affiche.

Alors il y en a des fois qu'ils ne l'utilisent pas encore une fois parce qu'il n'est pas du tout obligatoire. Il est souvent d'ailleurs même souvent très mal utilisé donc à la rigueur ne vaut mieux pas l'utiliser que de mal s'en servir d'accord donc si vraiment vous ne savez pas trop comment vous en servir, éviter le mais sinon c'est assez simple il suffit juste voilà de le me mettre dans le `<body>`, vous faites un `<main>` et à l'intérieur vous allez pouvoir gérer la partie principale.

Ce qui sera la partie principale de votre page vous pourrez le mettre dans `<main>` et ce qui n'en fera pas partie, vous pourrez le mettre après d'accord vous pourrez très bien avoir d'autres balises par la suite.

On pourrait avoir du `<div>` et cetera sans problème d'accord.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Structurer page web</title>
	</head>
	<body>
		<main></main>
		<div></div>
		<div></div>
	</body>
	</html>
```
`<main></main>` ça c'est vraiment la partie principale, c'est là toute l'importance de votre page web, ça c'est important à savoir.

Alors je passe rapidement parce qu'il y a rien d'autre à dire de plus par rapport à `<main>` c'est quand même assez simple à définir.

Là ce qui va nous intéresser nous ce sont les sections d'accord c'est à dire le fait de pouvoir sectionner une partie de document et on va utiliser pour cela la balise section tout simplement.
```html
	<section></section>
```
Alors une balise `<section>` c'est pareil il faut bien comprendre à quoi elles servent, toutes ces balises là ont une utilité précise d'accord, elles ne sont pas faites pour être comme ça au pif pour être utilisés n'importe comment.

Encore une fois comme j'ai déjà dit dans plusieurs vidéos faire de l'html c'est à la portée de tout le monde c'est très facile d'accord même pour le plus grand des débutants.

En revanche bien écrire du code html là ce n'est pas à la portée tout le monde et même des gens qui se disent professionnels font énormément d'erreurs dans la réalisation de leurs pages web donc faut faire attention à ça.

La balise `<section>` donc elle est générique, elle va simplement sectionner d'accord prévoir une partie de votre page via ce type de balise là qui est à connaître d'accord donc c'est comme ça qu'elle fonctionne.

De manière générale elle est prévue pour avoir un titre au départ de cette section là, vous ne faites pas une section par exemple qui en général n'est pas titré ça n'aurait pas de sens donc admettons ici moi que je veux avoir un `<h1>`, je peux avoir cette section là d'accord mon titre de section.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Structurer page web</title>
	</head>
	<body>
		<section>
			<h1>Mon titre de section</h1>
		</section>
	</body>
	</html>
```
Comme voilà comment ça se passera d'accord.

Donc une section elle est faite pour être titrée, c'est important ce n'est pas non plus obligatoire à 100% mais c'est pour cela qu'elle a été conçue.

La section est prévu pour être titrée pour pouvoir dire voilà c'est une section qui parle de quoi d'accord, qui va proposer quoi en terme de contenu donc logiquement on est censé lui mettre un titre, ça c'est des choses à connaître.

Par contre d'accord si éventuellement vous voulez proposer un contenu qui pourrait être mis à part c'est à dire un contenu qui pourrait être mis sur un autre site ou un contenu qui pourrait distribuer càd qui peut être indépendant de votre page, vous n'allez pas utiliser la balise `<section>` vous utiliserez une autre balise qu'on va voir qui va s'appeler la balise `<article>` d'accord pour tout ce qui est article mais je vais en parler un petit peu qui sera plus utilisée pour ce type.

Alors grosso modo `<section>` voilà vous pouvez définir ici une section, vous pouvez avoir un ensemble d'informations, ça peut être plein d'informations et vous pouvez avoir une autre `<section>` derrière.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<section>
		<h1>Mon titre de section</h1>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, unde, ratione, animi nam tempora adipisci nostrum id asperiores minus architecto at minima dolor voluptates ipsa reiciendis illo laborum consectetur dolore.</p>
	</section>
	<section>
		<h1>Mon titre pour une autre section</h1>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, unde, ratione, animi nam tempora adipisci nostrum id asperiores minus architecto at minima dolor voluptates ipsa reiciendis illo laborum consectetur dolore.</p>
	</section>
</body>
</html>
```
```txt
	Mon titre de section
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, unde, ratione, animi nam tempora adipisci nostrum id asperiores minus architecto at minima dolor voluptates ipsa reiciendis illo laborum consectetur dolore.

	Mon titre pour une autre section
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, unde, ratione, animi nam tempora adipisci nostrum id asperiores minus architecto at minima dolor voluptates ipsa reiciendis illo laborum consectetur dolore.
```
Ca on peut en avoir plein et je pense que vous comprenez un petit peu le principe d'accord ici.

Alors petite parenthèse sur le `<h1>` d'accord vous pouvez avoir un `<h1>` sur différentes sections voyez que là vous avez peut-être vue pour la plupart si vous avez l'habitude de faire du web entendu que le `<h1>`, il fallait en avoir qu'un seul sur une page web => ce qui est faux, vous pouvez très bien avoir du `<h1>` par exemple ici sur une section et encore sur une autre.

Après c'est pareil comme beaucoup de gens souvent l'utilisent mal si vous avez peur de faire des bêtises au niveau de la sémantique de votre page, ne mettez qu'un seul titre `<h1>` dans vos pages et après comme ça vous jonglez avec plusieurs titres `<h2>`, `<h3>` et cetera en respectant bien tout ce qu'on avait dit sur les titres sur la vidéo où j'avais parlé des titres par exemple je vous avait dit qu'il ne fallait pas sauter des types de titres c'est à dire que si vous faites un `<h1>` n'allez pas directement passer à un `<h3>`, il faut que vous ayez au moins un `<h2>` avant.

D'accord il faudrait bien suivre comme ça de `<h1>` à `<h6>` sans faire des sauts de titres d'accord ou de catégories de titres parce que sinon ça n'aurait absolument aucun sens mais si vous avez bien compris comment ça marchait voilà et que vous faites les choses correctement vous pouvez très bien écrire un code comme ça d'accord ça ne pose aucun problème.
```html
	...
	<body>
		<section>
			<h1>Mon titre de section</h1>
			<p>Lorem ...</p>
```
Ce `<h1>` ne fait pas partie du `<body>` d'accord ce n'est pas un `<h1>` du document complet, on peut très bien d'ailleurs faire ça, ça ne pose aucun souci.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<h1>Mon titre de page</h1>
	<section>
		<h1>Mon titre de section</h1>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, unde, ratione, animi nam tempora adipisci nostrum id asperiores minus architecto at minima dolor voluptates ipsa reiciendis illo laborum consectetur dolore.</p>
	</section>
	<section>
		<h1>Mon titre pour une autre section</h1>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, unde, ratione, animi nam tempora adipisci nostrum id asperiores minus architecto at minima dolor voluptates ipsa reiciendis illo laborum consectetur dolore.</p>
	</section>
</body>
</html>
```
`<h1>Mon titre de page</h1>` ou le titre du site éventuellement, on va voir d'autre balise de toute façon après et voilà comment se serait présenté d'accord.
```txt
	Mon titre de page
	Mon titre de section
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, unde, ratione, animi nam tempora adipisci nostrum id asperiores minus architecto at minima dolor voluptates ipsa reiciendis illo laborum consectetur dolore.

	Mon titre pour une autre section
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, unde, ratione, animi nam tempora adipisci nostrum id asperiores minus architecto at minima dolor voluptates ipsa reiciendis illo laborum consectetur dolore.
```
Voyez d'ailleurs que le navigateur même si ce n'est évidemment pas à prendre en compte rappelez-vous tout qui est aspect visuel, ne on doit pas s'en tenir à ça puisque ça ce fera en css mais voyez qu'il est assez intelligent pour mettre les `<h1>` de section un peu plus petit.

Pourtant logiquement les `<h1>` devraient être tous à la même taille eh ouais bizarrement c'est le 1er qui est le plus gros donc il vous montre quelque part visuellement, il vous donne quand même une indication pour montrer que celui là c'est vraiment le principal et que les autres ce sont des `<h1>` réservé à des sections d'accord au niveau de notre page donc c'est tout à fait valide, ça ne pose aucun problème.

Voilà comment ça marche.

En revanche si vous avez besoin d'une parti à part, admettont que vous voulez alors là le nom est plutôt bien choisi à ce niveau là au niveau de la balise et que vous voulez par exemple définir une balise enfin une portion de contenu qui serait autonome, indépendante d'accord ça pourait être un message d'un forum, ça peut être par exemple un article tout simplement, `<article></article>`.

C'est pour ça que ça porte bien son nom genre vous avez tout un article écrit mais qui pourrait être partagé ailleurs, qui pourrait être par exemple copié ou redistribué par exemple sur un réseau social ou autre.

Plutôt que d'utiliser `<section>` qui est plutôt réservé pour quelque chose vraiment propre à la page, vous pouvez utiliser la balise `<article>`.

`<article>` va fonctionner pour ce genre de cas-là donc elle est très simple d'accord le nom est quand même assez explicite par rapport à ça donc tout ce qu'il faut savoir c'est que si votre contenu pourrait être utilisé ailleurs plutôt d'utiliser `<section>`, vous allez utiliser `<article>` d'accord comme type de balise donc ça c'est quand même important à savoir donc je vous montrer de toute façon comment ça marche d'accord pour que vous puissiez voir un petit peu comment ça fonctionne.

Donc `<article>` c'est tout simplement la même chose que `<section>` d'accord comme ça vous pourrez par exemple avoir ici un article, voilà vous avez tout un texte article alors qu'une `<section>` est super importante de garder sur le site en tant que sémantique d'accord.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<h1>Mon titre de page</h1>
	
	<section>
		<h1>Mon titre de section</h1>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, unde, ratione, animi nam tempora adipisci nostrum id asperiores minus architecto at minima dolor voluptates ipsa reiciendis illo laborum consectetur dolore.</p>
	</section>
	
	<article>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, unde, ratione, animi nam tempora adipisci nostrum id asperiores minus architecto at minima dolor voluptates ipsa reiciendis illo laborum consectetur dolore.</p>
	</article>
</body>
</html>
```
```txt
	Mon titre de page
	Mon titre de section
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, unde, ratione, animi nam tempora adipisci nostrum id asperiores minus architecto at minima dolor voluptates ipsa reiciendis illo laborum consectetur dolore.

	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, unde, ratione, animi nam tempora adipisci nostrum id asperiores minus architecto at minima dolor voluptates ipsa reiciendis illo laborum consectetur dolore.
```
Ce second paragraphe éventuellement à l'affichage tout ce que vous avez mis dans votre article, ça pourrait être distribué donc mis à part du site sans en perdre la compréhension sans en perdre le sens d'accord.

Ce premier paragraphe ça ce serait plutôt un descriptif lié au site, tandis que le second paragraphe ce serait plutôt par exemple un contenu comme ça, un article, un message de forums, un commentaire laissé par exemple par un utilisateur s'est complètement indépendant d'accord le commentaire même si c'est un commentaire lié à un article éventuellement voilà c'est quand même une information complètement indépendante que l'on peut partager ailleurs donc ça c'est des choses comme ça qui sont importantes à savoir au niveau de la balise `<article>` voilà.

Alors je vous ai dit tout ce qu'il fallait je pense au niveau de section j'essaye de ne pas trop mélanger.

Après ce qui peut être utile à savoir aussi mais ça on va le voir dans d'autres balises c'est `<article>` qui peut également être utilisée avec des choses en plus mais comme on n'a pas vu les autres balises, je vais vous en parler un petit peu après.

Donc je vais retirer tout ça et on va revenir comme ça ici.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Structurer page web</title>
	</head>
	<body>

	</body>
	</html>
```
On va parler maintenant de balises un peu spécifique donc je reviendrai de toute façon sur les autres et de toute manière avec toutes les autres vidéos qu'on aura, les tutos, les exercices, etc vous aurez l'occasion de mettre vraiment en pratique ça pour comprendre comment les utiliser correctement.

Nous allons avoir une balise maintenant qui s'appelle `<header>`.

Cette balise est très souvent mal utilisé ou en tout cas mal comprises pour ceux qui apprennent html parce que automatiquement quand on voit `<header>` donc on pense à en tête et on se dit ah donc c'est pour avoir par exemple "Le titre de mon site" ce genre de choses voilà et on s'imagine que ce n'est que ça.
```html
	<body>
		<header>
			Le titre de mon site
		</header>
	</body>
```
Eventuellement si on veut bien faire les choses, on fait ça, `<h1>`.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Structurer page web</title>
	</head>
	<body>
		<header>
			<h1>Le titre de mon site</h1>
		</header>
	</body>
	</html>
```
Ca n'est pas faux du tout d'accord vous pouvez très bien géré l'en-tête de votre site avec `<header>` d'accord parce que je rappelle que le `<header>` ici est directement liée au `<body>` d'accord donc le body rapelez vous c'est le corps de votre page, c'est vraiment tout simplement le document donc ça `<header>` c'est l'en-tête du document `<body>` ok et l'en-tête du document elle porte un titre d'accord donc c'est le titre le plus fort que vous pourriez avoir sur votre page en faisant de cette manière donc ça on peut y mettre vraiment le titre du site en faisant comme ça.

Par contre ce que les gens ne savent pas c'est que `<header>` ne sert pas que ici.

`<header>` vous pouvez également l'utiliser ailleurs il peut être par  exemple une en-tête pour un article justement on peut très bien faire ceci `<article>` et ensuite de faire un `<header>` d'article et à l'intérieur du `<header>` d'arcticle mettre un `<h1>` ou éventuellement `<h2>` vous pouvez faire comme vous voulez si vous ne voulez pas avoir de `<h1>` pourquoi pas ça peut très bien se faire.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Structurer page web</title>
	</head>
	<body>
		<header>
			<h1>Le titre de mon site</h1>
		</header>
		
		<article>
			<header>
				<h2></h2>
			</header>
		</article>
	</body>
	</html>
```
Vous pouvez très bien faire ceci d'accord ici un titre d'article même si ça parait un peu bisare de parler d'article dans `<article>` c'est un peu logique mais vous pouvez faire ça.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Structurer page web</title>
	</head>
	<body>
		<header>
			<h1>MonSite</h1>
		</header>
		
		<article>
			<header>
				<h2>Mon titre d'article</h2>
			</header>
		</article>
	</body>
	</html>
```
Et une fois que vous avez fait ça et bien après le `<header>` vous pouvez écrire directement le contenu de l'article....
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<header>
		<h1>MonSite</h1>
	</header>
	
	<article>
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		<p>Le contenu de l'article...</p>
	</article>
</body>
</html>
```
```txt
	MonSite
	Mon titre d'article
	Le contenu de l'article...
```
Voilà c'est tout à fait possible ok parce que ici l'en-tête comme elle est dans un `<article>` elle est liée à `<article>`.
```html
	<article>
		<header>
			...
```
D'accord ce n'est pas l'en-tête de document, de body, c'est l'en-tête de cet article `<article>`-là.

Ok donc si un jour quelqu'un doit par exemple récupèrer cette partie là <article>, vous voyez il n'aura pas le titre en fait ça n'aura aucun rapport avec le document.
```txt
	  MonSite
	
	+-------------------------------+
	| Mon titre d'article			|
	| Le contenu de l'article...	|
	+-------------------------------+
```
Rappelez-vous que `<article>` comme je l'ai dis c'était autonome donc cet en-tête `<header>`, elle est liée à l'article en question, pas aux documents c'est complètement indépendant donc ça ne pose aucun problème d'avoir un `<header>` ici et on peut même avoir et ça c'est une autre balise que je vous présente un pied de contenu donc un `<footer>`.
```html
	<body>
		<header>
			<h1>MonSite</h1>
		</header>
		
		<article>
		
			<header>
				<h2>Mon titre d'article</h2>
			</header>
			
			<p>Le contenu de l'article...</p>
			
			<footer>
				<p></p>
			</footer>
			
		</article>
	</body>
```
Et le `<footer>` ça peut être divers informations voilà "Ce contenu est rédigé par " et là vous pouvez utiliser la fameuse balise qu'on a déjà vu `<address>` et on peut mettre plein d'informations un nom, un prénom et une adresse, un téléphone, ce que vous voulez d'accord ce genre de choses et vous pouvez mettre également la balise `<datetime>` si vous voulez gérer les dates et vous mettrez comme ça vos dates etc comme je vous l'ai montré mais là je ne vais pas compliquer la vidéo non plus, c'est des choses que je vous ai déjà montré voilà.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<header>
		<h1>MonSite</h1>
	</header>
	
	<article>
	
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		
		<p>Le contenu de l'article...</p>
		
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
		
	</article>
</body>
</html>
```
```txt
	MonSite
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
```
Donc vous pouvez très bien géré ça comme ça ok, ça ne pose aucun problème donc c'est important là encore une fois c'est logique en voyant comment est fait l'imbrication on comprend bien que `<header>` est l'en-tête de l'article donc de cette section `<article>` et `<footer>` c'est le pied de page en fait, le pied de portion de de la partie `<article>` ici et `<p>...</p>` c'est le contenu d'accord, le corps de cette partie là, `<article>`.

Donc tout ça limite je pourrais faire un copier-coller par exemple pour le mettre ailleurs.
```html
	<article>
	
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		
		<p>Le contenu de l'article...</p>
		
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
		
	</article>
```
Si je l'enlève du document comme il est autonome je ne perds pas, vous voyez, l'information du reste du document d'accord c'est une partie complètement autonome.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Structurer page web</title>
	</head>
	<body>
		<header>
			<h1>MonSite</h1>
		</header>
		
		...
	</body>
	</html>
```
Ca c'est des choses à savoir je le dis parce que souvent les gens `<header>` ne l'utilisent que pour l'en-tête de la page et le `<footer>` ils ne l'utilisent que pour ça en faisant par exemple copyright.
```html
	<footer>
		<p>Copyright &copy; 2018</p>
	</footer>
```
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<header>
		<h1>MonSite</h1>
	</header>
	
	<article>
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		<p>Le contenu de l'article...</p>
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
	</article>
	
	<footer>
		<p>Copyright &copy; 2018</p>
	</footer>
</body>
</html>
```
```txt
	MonSite
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
	Copyright © 2018
```
voilà vous pouvez le gérer mais là ce pied de page il est lié encore une fois ici au document principal donc on peut le faire voyez il est en dehors d'une section, en dehors d'un article, en dehors de tout donc ça ne pose pas de problème.

On a un `<header>`, un `<footer>` pour le body.

On a un `<header>`, un `<footer>` pour l'article etc etc.

Si vous avez compris ça vous aurez tout compris au niveau structure d'une page web et vous aurez compris en majorité puisqu'il y a beaucoup beaucoup de gens qui ne savent pas ou qu'ils l'utilisent vraiment mauvais escient, qu'ils pensent vraiment que `<header>` c'est seulement pour la partie titre d'une page et `<footer>` est seulement pour les copyrights ou les liens, mentions légales, etc alors que pas du tout d'accord. 

Ca pas du tout cette utilité-là c'est simplement lié pour une en-tête ou un pied d'une portion de page donc le `<body>` c'est une balise qui existe déjà depuis le début de html donc évidemment ils n'en ont pas fait une nouvelle.

Eventuellement si vous mettez pas tout dans `<main>` comme on l'a vu ça fonctionnera pareil d'accord ça veut dire que cette fois-ci vous aurez fait un `<header>` pour le `<main>` et un `<footer>` pour le `<main>`, on pouvait très bien géré ça.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<main>
		<header>
			<h1>MonSite</h1>
		</header>
		
		<article>
			<header>
				<h2>Mon titre d'article</h2>
			</header>
			<p>Le contenu de l'article...</p>
			<footer>
				<p>Ce contenu est rédigé par <address>Jason</address></p>
			</footer>
		</article>
		
		<footer>
			<p>Copyright &copy; 2018</p>
		</footer>
	</main>
</body>
</html>
```
```txt
	MonSite
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
	Copyright © 2018
```
Comme ça et puis pourquoi pas par la suite d'avoir un contenu complètement à part `<p>Lorem ...</p>` ce qui fait que ça c'est la partie principale de votre site.
```txt
	MonSite
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
	Copyright © 2018
```
Et ça c'est une autre partie d'accord c'est un autre contenu qui est présent sur notre page mais qui ne fait pas partie de la section importante ici `<main>`.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<main>
		<header>
			<h1>MonSite</h1>
		</header>
		
		<article>
			<header>
				<h2>Mon titre d'article</h2>
			</header>
			<p>Le contenu de l'article...</p>
			<footer>
				<p>Ce contenu est rédigé par <address>Jason</address></p>
			</footer>
		</article>
		
		<footer>
			<p>Copyright &copy; 2018</p>
		</footer>
	</main>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur, rerum sed eius veritatis dolores alias consectetur minima quos omnis quibusdam debitis quidem ut autem quaerat cum! Dicta, tempora repudiandae saepe!</p>
</body>
</html>
```
```txt
	MonSite
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
	Copyright © 2018

	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur, rerum sed eius veritatis dolores alias consectetur minima quos omnis quibusdam debitis quidem ut autem quaerat cum! Dicta, tempora repudiandae saepe!
```
Ici `<main>` c'est un mot qui veut dire principal ça veut dire que c'est vraiment le plus important de notre page pour ça que souvent on utilise plus rarement `<main>` puisque c'est assez rare que les gens aient une partie pas forcément principal sur leur page mais si jamais ça arrivait évidemment vous n'hésitez pas à utiliser `<main>` elle est faite pour ça.

Voilà comment ça fonctionne pour cette partie là j'ai encore deux petites balises à vous montrer concernant les balises structurantes et après on fera un petit point sur tout ça parce que je vous ai fait évidemment un schéma pour vous montrer un peu la représentation de toute cette partie là.

Au niveau balise, on va garder ça comme ûisqu'après tout ça représente bien un exemple de page.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<header>
		<h1>MonSite</h1>
	</header>
	
	<article>
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		<p>Le contenu de l'article...</p>
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
	</article>
	
	<footer>
		<p>Copyright &copy; 2018</p>
	</footer>
</body>
</html>
```
```txt
	MonSite
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
	Copyright © 2018
```
On peut avoir également une balise qui est faites pour tout ce qui est navigation `<nav>` alors navigation `<nav>` ça sous-entend deux choses soit vous avez un menu pour pouvoir naviguer sur l'ensemble de votre site un menu pour aller sur l'accueil, la page de contact, une page d'info ou je ne sais quoi ou alors un menu juste pour la page en question.

Vous êtes sur une page et vous avez un espèce de sous menus en quelque sorte qui permet de naviguer sur plusieurs parties de cette page sans forcément changer de page d'accord.

Voilà donc un menu de navigation peut servir pour ces deux cas là.

Pour cela, on utilisera la balise `<nav>` tout simplement donc la balise `<nav>` en général, elle possède une liste d'accords un `<ul>` ou un `<ol>` peu importe c'est vous qui voyez.
```html
	<nav>
		<ul>
			<li></li>
		</ul>
	</nav>
```
Et on met plusieurs éléments ok donc ici on met des liens, je ne vais pas revenir sur ce qu'on a déjà montré d'accord je ne met rien à l'intérieur "#" voilà.
```html
	<nav>
		<ul>
			<li><a href="#">Aceuil</a></li>
			<li><a href="#">Articles</a></li>
			<li><a href="#">Forum</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</nav>
```
Vous avez l'accueil, articles, forum, contact càd plusieurs exemples assez évident et vous allez comme ça gérer un menu.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<header>
		<h1>MonSite</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="#">Aceuil</a></li>
			<li><a href="#">Articles</a></li>
			<li><a href="#">Forum</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</nav>
	
	<article>
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		<p>Le contenu de l'article...</p>
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
	</article>
	
	<footer>
		<p>Copyright &copy; 2018</p>
	</footer>
</body>
</html>
```
```txt
	MonSite
		* Aceuil
		* Articles
		* Forum
		* Contact
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
	Copyright © 2018
```
Vous allez gérer comme ça un menu.

Après par la suite vous allez me dire mais si je veux faire un menu horizontal, si je veux faire un menu à droite etc si je veux enlever les listes, si je veux changer ici le style évidemment on fera tout ça en css d'accord.

L'important comme toujours c'est que juste en lisant votre document html sans css que tout soit cohérent, que tout soit clair.

D'ailleurs pour ceux qui font des sites en faisant directement le css, pour vérifier que votre page est bien valide d'accord qu'elle est correcte, n'hésitez pas si vous avez inclut par exemple un document css au niveau de votre page comme on le verra dans la vidéo prochaine, à retirer le css et juste afficher le html.

Si vous voyez qu'il y a des infos qui manquent ou des choses qui ne sont pas claires c'est qu'à priori ben voilà vous n'avez pas fait le html correctement.

Donc logiquement quand on veut bien faire les choses, on s'occupe d'abord de faire le html sur son site et seulement après quand le html est correct d'accord, qu'il est sémantiquement correct, c'est seulement à partir de là qu'on s'occupe de faire la partie css donc la partie design d'accord.

Logiquement votre html tout seul il devrait être correcte et convenable pour l'internaute.

Si ce n'est pas le cas eh bien il est temps de le revoir et de corriger ce html avant de commencer à s'attaquer au design.

Pour cette partie donc le `<nav>` ça peut être là pour la navigation sur le site, puis vous pouvez avoir un `<nav>` sur page en particulier. Je peux très bien faire un `<nav>` ici au niveau de ma page.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<header>
		<h1>MonSite</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="#">Aceuil</a></li>
			<li><a href="#">Articles</a></li>
			<li><a href="#">Forum</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</nav>
	
	<section>
		<nav>
			<ul>
				<li><a href="#">Premier pas</a></li>
				<li><a href="#">Partie</a></li>
				<li><a href="#">Conclusion</a></li>
			</ul>
		</nav>
	</section>
	
	<article>
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		<p>Le contenu de l'article...</p>
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
	</article>
	
	<footer>
		<p>Copyright &copy; 2018</p>
	</footer>
</body>
</html>
```
```txt
	MonSite
	
		* Aceuil
		* Articles
		* Forum
		* Contact
		
		* Premier pas
		* Partie
		* Conclusion
		
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
	Copyright © 2018
```
Voilà un menu une navigation pour cette page en question d'accord.

Ca c'est un petit peu le menu qui sera affichée sur toutes les pages d'accord ce qui permet de naviguer sur le site.
```txt
		* Aceuil
		* Articles
		* Forum
		* Contact
```
Celui là, il ne sera affiché que sur ma page index.html  par exemple, il est lié à une section encore une fois.
```txt
		* Premier pas
		* Partie
		* Conclusion
```
Voilà donc on aurait des choses gérer différement, ça c'est vraiment important de bien connaître l'utilisation des balises pour éviter de faire n'importe quoi ok de bien comprendre comment elles s'utilisent et à quoi elles servent ...
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<header>
		<h1>MonSite</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="#">Aceuil</a></li>
			<li><a href="#">Articles</a></li>
			<li><a href="#">Forum</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</nav>
	
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Modi, deserunt ullam perferendis temporibus voluptatibus. Animi, doloribus, dicta, quos earum illum error enim laudantium eius molestiae deserunt deleniti suscipit quae pariatur.</p>
	
	<section>
		<nav>
			<ul>
				<li><a href="#">Premier pas</a></li>
				<li><a href="#">Partie</a></li>
				<li><a href="#">Conclusion</a></li>
			</ul>
		</nav>
	</section>
	
	<article>
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		<p>Le contenu de l'article...</p>
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
	</article>
	
	<footer>
		<p>Copyright &copy; 2018</p>
	</footer>
</body>
</html>
```
```txt
	MonSite
		* Aceuil
		* Articles
		* Forum
		* Contact
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Modi, deserunt ullam perferendis temporibus voluptatibus. Animi, doloribus, dicta, quos earum illum error enim laudantium eius molestiae deserunt deleniti suscipit quae pariatur.

		* Premier pas
		* Partie
		* Conclusion
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
	Copyright © 2018
```
Il y a quand même pas mal de balises prévues pour certains types de fonctionnement au niveau html et en tout cas depuis html 5.

Voilà pour le `<nav>` alors je vais peut-être retirer tout ça parce que ça fait beaucoup.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<header>
		<h1>MonSite</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="#">Aceuil</a></li>
			<li><a href="#">Articles</a></li>
			<li><a href="#">Forum</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</nav>
	
	<article>
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		<p>Le contenu de l'article...</p>
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
	</article>
	
	<footer>
		<p>Copyright &copy; 2018</p>
	</footer>
</body>
</html>
```
```txt
	MonSite
		* Aceuil
		* Articles
		* Forum
		* Contact
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
	Copyright © 2018
```
On termine avec une dernière balise qui est utile également même si on peut s'en passer assez souvent mais c'est bien de la savoir c'est la balise en fait qui permet d'avoir un contenu qui n'est pas lié au reste d'accord si par exemple vous voulez mettre des petites infos non importantes, facultative ou des petites choses comme ça en plus ou simplement je sais pas moi afficher un bouton de dons, afficher quelques liens précis, une image par exemple qui serait à la une d'une galerie où je ne sais quoi bref quelque chose qui est complètement non lié avec le reste de la page mais qui peut s'afficher un petit peu partoutn vous pouvez utiliser une balise `<aside>`.
```html
	<aside>
	
	</aside>
```
`<aside>` c'est un petit peu un encart, une balise un petit peu particulière qui possède un contenu quelconque d'accord qui n'est pas forcément lié à quoi que ce soit en particulier.

Voilà c'est une partie de contenu pour ça et moi je vais mettre un paragraphe encore une fois.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<header>
		<h1>MonSite</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="#">Aceuil</a></li>
			<li><a href="#">Articles</a></li>
			<li><a href="#">Forum</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</nav>
	
	<article>
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		<p>Le contenu de l'article...</p>
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
	</article>
	
	<aside>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, sed velit officiis. Dignissimos, deserunt, cumque mollitia in quasi sapiente autem possimus? Iste, incidunt, placeat commodi fuga ipsam quisquam in eligendi!</p>
	</aside>
	
	<footer>
		<p>Copyright &copy; 2018</p>
	</footer>
</body>
</html>
```
```txt
	MonSite
		* Aceuil
		* Articles
		* Forum
		* Contact
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
	
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, sed velit officiis. Dignissimos, deserunt, cumque mollitia in quasi sapiente autem possimus? Iste, incidunt, placeat commodi fuga ipsam quisquam in eligendi!
	
	Copyright © 2018
```
J'aurais pu mettre autre chose mais là j'ai pas spécialement d'image ou autre donc ça c'est vraiment une partie à part ok.

Et pareil avec css plus tard vous pourrez choisir où l'afficher, à quel endroit, la position.

Voilà au niveau de ces balises structurantes, je vous ai fait grosso modo le tour de ce qu'il à savoir donc la règle d'or, encore une fois, vraiment à retenir c'est de ne pas oublier que `<header>`, `<footer>` peuvent s'utiliser en tant qu'en-tête et en tant que pied pour une partie d'une page.

Les parties d'une page grosso modo c'est quoi ? hé bien c'est le `<body>` donc ça c'est le document complet. Vous avez `<section>` si vous faites une section de votre document ou `<article>` qui est une section un peu particulière qui elle est autonome d'accord, rappelez-vous autonome et indépendante donc on peut utiliser tout ça là dedans `<article></article>`.
```html
	<article>
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		<p>Le contenu de l'article...</p>
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
	</article>
```
Evidemment dans `<header>`, `<footer>`, etc quand on fait des titres encore une fois vous pouvez mettre du `<h1>` ça ne pose pas de problème même si et si vous avez peur de vous tromper, vous pouvez vous contenter d'un seul `<h1>` sur votre page et après pour les autres de commence en fait les titres à partir de `<h2>` et après vous faites `<h3>`, `<h4>`, `<h5>`, `<h6>` en fonction de la hiérarchie que vous voulez pour vos liens.

Mais si vous mettez du `<h1>` ici ce n'est pas faux d'accord ça ne posera aucun problème ce sera parfaitement valide au niveau html donc pas d'inquiétude à ce niveau là.
```html
	<article>
		<header>
			<h1>Mon titre d'article</h1>
		</header>
		<p>Le contenu de l'article...</p>
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
	</article>
```
Voilà une petite chose à savoir après ben il faut pas se tromper entre l'utilisation de `<article>` et de `<section>` évidemment d'accord savoir qu'il y en a un qui est autonome notamment `<article>` tandis que `<section>` est vraiment lié à la page d'accord on reste lucide.

Quand vous utilisez pareil `<article>` c'est bien d'avoir un en-tête `<header>` c'est important  d'accord, ne pas avoir un `<article>` sans titre c'est un peu gênant donc pensez quand même à ça et si vous utilisez des informations par exemple sur l'auteur du contenu en question, vous mettez ça dans un `<footer>` et tout ce qui est informations de l'auteur vous mettez dans un `<address>` comme on l'a déjà vu dans les vidéos précédentes.

Quand il y a une date de publication ou une date du contenu en question, vous mettez ça dans un `<time>` ou dans un `<datetime>` fin bref on peut utiliser les balises comme on les a vues pour gérer tout ce qui est date à l'intérieur ici du document.
```html
	...<address>Jason</address></p>
```
Encore une fois ça une fois que vous aurez des pages à analyser, vos informations seront très pertinente, ici on pourra extraire en fait l'auteur "Jason", on pourrait extraire la date et cetera donc au niveau des résultats des moteurs de recherches vous aurez quelque chose de beaucoup plus beaucoup plus efficace pour que ce soit pour le référencement ou pour simplement retrouver des contenus, retrouver des informations donc c'est plutôt intéressant si vous voulez gagner en visibilité au niveau de site web donc c'est des choses à savoir.

Voilà pour ça alors, je vais vous montrer du coup le petit chama rapidement que j'avais fait grosso modo pour montrer donc je rappelle évidemment et ça je vais en parler un petit peu après que vous pouvez utiliser des `<div>` pour des blocs spécifiques d'accord donc associé à des 'id' ou des classes css comme je le dis en début de vidéo et pareil pour la balise `<span>` qui ne perd aucunnement son intérêt.
```txt
	+-----------------------------------+
	| <header>							|
	|									|
	|									|
	+-----------------------------------+
	/!\ On peut toujours utiliser des <div> pour des blocs spécifiques (associés à des id ou class css). De même la balise <span> ne perd aucunnement son intérêt.
	+---------------------+	 +----------+
	| <section>			  |	 | <nav>	|
	| +-----------------+ |	 |			|
	| | <article>		| |	 |			|
	| | 				| |	 |			|
	| +-----------------+ |	 |			|
	| +-----------------+ |	 |			|
	| | <article>		| |	 |			|
	| |					| |	 |			|
	| +-----------------+ |	 |			|
	| +-----------------+ |	 |			|
	| | <article>		| |	 |			|
	| |					| |	 |			|
	| +-----------------+ |	 |			|
	+---------------------+	 +----------+
	+-----------------------------------+
	| <footer>							|
	+-----------------------------------+
	+----------------+ +----------------+
	| <aside>		 | | <aside>		|
	|				 | |				|
	+----------------+ +----------------+
```
D'accord là je vous ai montré un exemple de page qui pourrait être fait en html donc on a un gros `<header>` en haut qui serait pour le coup le titre de notre page avec éventuellement un logo.

Après on aurait ici une `<section>` d'accord alors `<article>`, je n'ai pas écrit à l'intérieur les `<header>`, `<footer>` parce que sinon je n'aurais pas eu beaucoup de place mais comprenez que ici voilà s'il y a un article, on aura au moins un `<header>` pour chacun. Il y aura des titres et là on a dit que tout est dans une section pour le coup parce que voilà on s'est dit tiens on met ça dans une section.

Le menu de navigation `<nav>`, on l'a mit à droite sur ce site là.

On a un petit `<footer>` d'accord pareil donc le `<footer>` ici, on voit que c'est le `<footer>` du document en l'occurrence et pas du restec, ce sera le copyright et cetera.

Et les petits `<aside>` donc ça c'est peut-être des liens par exemple, les mentions légales ou autres ou alors genre les derniers tweets par exemple si vous voulez lier votre twitter sur un site.

Bref voilà à quoi peut servir ce genre de balises `<aside>` d'accord comme j'ai dit c'est du contenu, c'est des petits plus que vous pouvez ajouter sur une page.

Voilà alors si jamais par exemple dans toutes les balises vous voyez qu'elles ont elles ont une utilisation assez particulière et si jamais vous voulez proposer un contenu qui ne rentre pas dans le cadre de l'une de ces balises, vous utiliserez à ce moment là un `<div>`

Admettons vous voulez afficher des images sous forme de galerie, une certaine espèce de mosaïques d'images, qui afficheraient plein d'images comme ça ensemble et bien voyez qu'il n'y a pas de balises html pour gérer ce type de contenu donc vous pouvez très bien faire tout simplement un div d'accord ce genre de choses.
```html
	<div class="gallery">
	
	</div>
```
Et plus tard avec css, vous verrez qu'on pourra utiliser l'attribut 'class' ou 'id' selon, par exemple crééer une classe "gallery" et après en css, on pourra définir comment est faite la classe "gallery" est-ce qu'on lui met une couleur de fond ? est-ce qu'on lui met un cadre ? est-ce qu'on met des marges et cetera ?

Tout ça on le verra de toute façon par la suite en css.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<header>
		<h1>MonSite</h1>
	</header>
	
	<div class="gallery">
	
	</div>
	
	<nav>
		<ul>
			<li><a href="#">Aceuil</a></li>
			<li><a href="#">Articles</a></li>
			<li><a href="#">Forum</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</nav>
	
	<article>
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		<p>Le contenu de l'article...</p>
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
	</article>
	
	<aside>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, sed velit officiis. Dignissimos, deserunt, cumque mollitia in quasi sapiente autem possimus? Iste, incidunt, placeat commodi fuga ipsam quisquam in eligendi!</p>
	</aside>
	
	<footer>
		<p>Copyright &copy; 2018</p>
	</footer>
</body>
</html>
```
```txt
	MonSite
		* Aceuil
		* Articles
		* Forum
		* Contact
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
	
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, sed velit officiis. Dignissimos, deserunt, cumque mollitia in quasi sapiente autem possimus? Iste, incidunt, placeat commodi fuga ipsam quisquam in eligendi!
	
	Copyright © 2018
```
Pour les attributs `<span>`, admettons que je veux à certains endroits de mes articles ou autre, avoir la possibilité de mettre du texte en rouge et bah je pourrais simplement faire ceci par exemple.
```html
	<span class="text-red"></span>
```
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Structurer page web</title>
</head>
<body>
	<header>
		<h1>MonSite</h1>
	</header>
	
	<div class="gallery">
	
	</div>
	
	<nav>
		<ul>
			<li><a href="#">Aceuil</a></li>
			<li><a href="#">Articles</a></li>
			<li><a href="#">Forum</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</nav>
	
	<article>
		<header>
			<h2>Mon titre d'article</h2>
		</header>
		<p>Le contenu de l'article...</p>
		<footer>
			<p>Ce contenu est rédigé par <address>Jason</address></p>
		</footer>
	</article>
	
	<aside>
		<p>Lorem ipsum dolor sit amet, consectetur <span class="text-red">adipisicing elit</span>. Corporis, sed velit officiis. Dignissimos, deserunt, cumque mollitia in quasi sapiente autem possimus? Iste, incidunt, placeat commodi fuga ipsam quisquam in eligendi!</p>
	</aside>
	
	<footer>
		<p>Copyright &copy; 2018</p>
	</footer>
</body>
</html>
```
```txt
	MonSite
		* Aceuil
		* Articles
		* Forum
		* Contact
	Mon titre d'article
	Le contenu de l'article...

	Ce contenu est rédigé par

	Jason
	
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, sed velit officiis. Dignissimos, deserunt, cumque mollitia in quasi sapiente autem possimus? Iste, incidunt, placeat commodi fuga ipsam quisquam in eligendi!
	
	Copyright © 2018
```
`<span class="text-red">adipisicing elit</span>` voilà et comme ça dans css, on définira une classe "texte-red" qui mettra tout simplement le texte en rouge et ça, ce sera écrit en rouge.

	adipisicing elit

Donc c'est pratique ça permet de faire comme ça des petits changements sur certaines parties, certains éléments de notre page web donc ces des petites choses à savoir.

Voilà donc n'oubliez pas `<div>` et `<span>` ne sont pas du tout à jeter parce qu'il y a des balises structurants, dans certains cas vous serez obligé d'utiliser des balises `<div>` ou des balises `<span>` oui si vous voulez avoir certaines mises en page quand même ça peut être sympa et les balises `<div>` à moins d'avoir un site très classique d'accord.

Si c'est juste un blog avec un article affiché, des commentaires voilà afficher le nombre de vues ou ce genre de choses c'est sûr qu'avec les balises structurantes vous pouvez honnêtement tout faire.

Par contre dans certains cas quand on a des sites beaucoup plus riches, beaucoup plus spécifique, beaucoup plus complexe vous verrez que ces balises structurants ne sont pas suffisantes, il faudra des fois avoir des `<div>` en créant vous même vos propres classes comme on le verra en css pour enrichir le contenu de vos pages web.

En tout cas je vous ai dit tout ce qu'il fallait au niveau de la structure des pages web donc de ces balises structurantes, logiquement j'ai fait le tour de tous.

Si j'ai oublié des choses, c'est pas bien grave de toute façon parce qu'on reviendra dessus que ce soit sur les tuto, sur les exercices et avec maintenant le fait d'aborder css par la suite.

Si vous avez des questions comme d'habitude n'hésitez pas à demander dans les commentaires, à partager, liker la vidéo, la partager surtout sur vos réseaux sociaux si vous vous servez de twitter, de facebook, de instagram je ne sais quoi n'hésitez pas à parler de la chaîne, à parlé des formations disponibles autour de vous ça fera connaître comme ça à un maximum de personnes.

On se retrouve pour la suite donc c'était la dernière vidéo html pur.

Dans la description de la vidéo vous pouvez retrouver le pdf memento donc c'est logiquement le mento en 10e édition donc ce sera ce sera le dernier concernant html.

J'en ferai sûrement un autre pour css, histoire que vous ayez un petit pense-bête donc y a pas forcément tous mais en tout cas vraiment, j'ai quand même centralisé à peu près tout ce qui a été vu dans les vidéos donc déjà vous avez de quoi faire à ce niveau là histoire de ne pas avoir les éléments éparpiller ça peut éventuellement de faire gagner du temps donc n'hésitez pas à télécharger ce pdf de 10e édition puisque ce sera le dernier concernant html.

Vous avez vraiment toutes les balises qu'on a vu sur toute la formation.

Je vous dis à bientôt, on se retrouve du coup pour la prochaine séance et la prochaine séance, on va attaquer css cette fois.

On en termine purement avec le html avec tout ce que je voulais vous montrer dans le cours.

A bientôt tout le monde