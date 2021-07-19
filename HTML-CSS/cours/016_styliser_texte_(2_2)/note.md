# [16. Styliser texte (2/2)](https://www.youtube.com/watch?v=K9UciHsxieI)
27-01-21

Bonjour à tous, bienvenue sur la formation html css on continue avec séance 16 sur tout ce qui concerne le style que nous allons pouvoir appliquer à nos différents textes sur nos pages web donc je vais vous présenter un petit peu d'autres propriétés que nous allons tout simplement connaître voir un petit peu comment les utiliser, lesquels sont  intéressantes ou lesquels ne le sont pas forcément et on verra directement ce que ça donne en terme de résultat visuel directement sur nos pages web.

Alors j'ai repris le même exemple d'accord que la dernière fois.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>CSS - Styliser texte (2/2)</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Chat</h1>
	
	<p>Le Chat domestique (Felis silvestris catus) est la sous-espèce issue de la domestication du Chat sauvage (Felis silvestris), mammifère carnivore de la famille des Félidés.</p>
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p>Source : <a href="https://fr.wikipedia.org/wiki/Chat">ChachaPédia</a></p>
</body>
</html>
```
Donc j'ai repris le même code html puisque c'est suffisant par rapport à ce que j'ai à vous montrer et on va pouvoir tester tout un ensemble de balises alors la dernière fois vous avez vu comment transformer du texte en gras, vous avez vu comment procéder à beaucoup beaucoup de changements sur la 'font' donc pouvoir changer la police de caractère, pourvoir changer la taille de la police, ce genre de choses.

Donc là on va continuer un petit peu avec d'autres petites choses concernant le texte d'accord que ce soit de changement de texte et que se soit ensuite tout ce qui est gestion de positionnement, alignement du texte et on pourra terminer éventuellement avec d'autres petites choses qui nous serviront notamment concernant les mots en eux mêmes puisque le texte est composé en l'occurrence de mots et de caractères.

La première chose que je voulais vous montrer, qui est un peu la suite logique de ce qu'on avait vu la dernière fois c'est la possibilité de mettre un texte souligné d'accord on avait vu comment mettre un texte en gras, on a vu comment mettre un texte en italique.

Là je rappelle effectivement que là il s'agit bien d'aspects visuels d'accord c'est vraiment important, on parle de ce qui est affiché à l'écran, de ce qui sera visuellement présent pour l'utilisateur.

Donc nous avons une autre propriété qui est très pratique qui s'appelle 'text-decoration' tout simplement alors elle s'écrit tout simplement comme ceci d'accord.
```css
	p.modif-p
	{
		text-decoration:;
	}
```
On va pouvoir lui passer tout un tas d'éléments, elle prend en réalité trois valeurs qu'on peut mettre l'une à la suite des autres en les séparant avec un espace comme l'a vu par exemple pour 'font' ou autres.

La première ça va être ce qui concerne les lignes.

La deuxième ça va être ce qui concerne la couleur et ensuite le style.

Alors en général on évite d'utiliser ces trois là donc je peux vous les montrer en fait en version on va dire normal donc on va avoir ça en fait d'accord.
```css
	p.modif-p
	{
		text-decoration-line:;
		text-decoration-color:;
		text-decoration-style:;
	}
```
Le petit souci qui est bien à savoir, la troisième partie en fait de cette grande propriété qui peut être assemblé comme ça en une seule plutôt d'avoir trois propriétés séparés c'est qu'elle n'est pas compatible par exemple avec microsoft edge de windows 10 donc évidemment attention à son utilisation parce que encore une fois selon le navigateur utilisé par la personne qui navigue sur votre site certaines choses seront compatibles et d'autres non.

Il faut faire attention à ça donc c'est très rare honnêtement mais moi personnellement je n'utilise jamais la séparation comme ça entre ces trois propriétés mais j'utilise directement 'text-decoration' tout simplement qui va prendre en premier donc la valeur pour 'line', ensuite un espace la valeur pour 'color' un espace et éventuellement la valeur pour le 'style' d'accord.

Comment ça fonctionne donc on va mettre tout dans une seule puisque c'est comme ça que vous procéderez la plupart du temps.
```css
	p.modif-p
	{
		text-decoration:;
	}
```
Tout ce qui concerne les lignes d'acord la partie 'line' ça va être justement ce que je disais qui permet par exemple de souligner le texte donc on peut utiliser la valeur "underline".
```css
	p.modif-p
	{
		text-decoration:underline;
	}
```
Là je peux simplement mettre qu'une seule valeur ça fonctionnera aussi puisque la première valeur attendue concerne le système sur les lignes.

Là si je vais sur un page que j'actualise avec F5 vous voyez qu'effectivement le texte a bien été souligné.

On peut faire exactement l'inverse c'est à dire en mettant une ligne par dessus donc c'est "overline" tout simplement.
```css
	p.modif-p
	{
		text-decoration:overline;
	}
```
Si j'actualise on voit que cette fois ci le trait en fait comme ça ici se met au dessus du texte d'accord et non pas en dessous donc ça c'est les possibilités.

On peut évidemment posséder un troisième style intéressant qui peux servir dans certains cas qui est le fameux 'line-through'.
```css
	p.modif-p
	{
		text-decoration:line-through;
	}
```
'line-through' tout simplement pour barrer le texte alors là attention on parle en termes visuels on ne parle pas en terme de sémantique c'est à dire si vous barrée du texte comme ça, vous ne dites pas j'utilise line-through pour que les analyseurs de sites web quand ils vont arriver sur ma page web c'est à dire regardez mon code source d'accord vont se dire que le texte là n'est plus un texte pertinent puisque rappelez vous parce qu'on avait évoqué avec le html en utilisant certaines balises html pour justement indiqué qu'un texte n'était plus pertinent, vous avez vu visuellement ça produisait le même résultat càd que ça barrait le texte.

Là il suffit de voir le code source de la page pour voir qu'il n'y a rien, absolument rien en terme de sémantique, en termes de structure de notre page qui indique que ce texte-là n'est plus pertinents d'accord.
```html
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>CSS - Styliser texte (2/2)</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<h1>Chat</h1>
		
		<p>Le Chat domestique (Felis silvestris catus) est la sous-espèce issue de la domestication du Chat sauvage (Felis silvestris), mammifère carnivore de la famille des Félidés.</p>
		
		<p class="modif-p">Il est l’un des principaux animaux de compagnie et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
		
		<p>Source : <a href="https://fr.wikipedia.org/wiki/Chat">ChachaPédia</a></p>
	</body>
	</html>
```
Ce n'est pas pertinent parce que lui pour l'analyseur de sites une classe ici `<p class="modif-p">...` utilisée comme attribut franchement ça ne vaut rien du tout d'accord tout ce qu'il voit c'est qu'il y a un paragraphe donc on n'a aucune information en termes de sémantique concernant ce paragraphe `<p class="modif-p">...` qui apparemment ne serait pas pertinent donc attention n'oubliez pas tout ce qui est en termes de sémantique, de pertinence de l'information doit être fait en html et tout ce qui est simplement fait pour décorer, tout ce qui est l'aspect visuel, le design est fait en css ne mélanger surtout pas l'un et l'autre.

Utiliser du css pour avoir un contenu sémantique ou utiliser html pour mettre en forme vos pages web d'accord surtout ne mélangez pas les deux sinon vous aurez de gros soucis au niveau de vos pages web donc là c'est vraiment pour dire que visuellement je veux que l'utilisateur voit un texte barré.

Par contre s'il y a un analyseur de sites qui tombe sur ma page lui il ne sera pas qu'ici j'ai barré un texte, il n'en sera absolument rien parce que ça n'a aucune pertinence en termes de sémantique, en termes de SEO carrément niveau du référencement d'accord absolument aucun donc attention à ça, j'insiste beaucoup beaucoup dessus parce que c'est très important et c'est bien que vous ayez encore une fois les bonnes habitudes dès le départ pour ne pas les garder ensuite et après devoir les oublier puisque les mauvaises habitudes sont très durs a oublier une fois qu'on les a tout simplement adopter donc ça c'est vraiment juste un aspect visuel.

Donc on utilise "line-through" toujours sur 'text-decoration' d'accord.

Alors j'aurais pu également mettre autre chose par exemple ici mettre un nom de couleurs donc il y a des espèces de noms de couleurs qui sont prévues au niveau du css en deuxième argument.
```css
	p.modif-p
	{
		text-decoration:line-through red;
	}
```
Genre je met "red" mais je ne rentrerai pas là dessus parce qu'on n'a pas encore vu tout ce qui concerne les couleurs au niveau du css d'accord que ce soit par exemple pour la couleur d'un fonds ou la couleur de la police ou ce genre de choses. On verra évidemment ça dans une autre vidéo au niveau du cours ne vous en faites pas.

Mais là grosso modo sans entrer dans les détails, voyez qu'il y a des noms de code qui existent (red) ou également éventuellement une valeur hexadécimal des couleurs mais encore une fois on reviendra dessus d'accord.

Par exemple si je mets #ABFF28 voyez que ça fait une sorte de vert, je peux actualiser et là ça fait un trait vert fluo pas très visible qui barre en fait tout ça.
```css
	p.modif-p
	{
		text-decoration:line-through #ABFF28;
	}
```
Donc ça tout ce qui est gestion de couleurs en css on le verra d'accord on verra comment modifier ça d'ailleurs on regardera tout ça plus en détail dans une autre vidéo et là ce n'est pas une vidéo sur les couleurs, c'est une vidéo concernant le style sur les textes mais sachez que le 'text-decoration-color' peut être passé comme ça en deuxième valeur après ce qui concerne les lignes d'accord.
```css
	p.modif-p
	{
		text-decoration:line-through regb(115, 128, 92);
	}
```
Donc vous tout ce qu'il y a à retenir surtout c'est que vous pouvez souligner le texte, vous pouvez également le surligner donc en mettant un trait au dessus du texte ou le barrer d'accord mais c'est vraiment juste un aspect visuel, ça n'apporte rien de manière sémantique.

Voilà pour 'test-decoration', j'ai pris un peu de temps pour l'expliquer parce que c'était bien de le savoir.

On va passer maintenant à un autre donc là c'est une propriété un peu plus récente qui est la propriété 'text-shadow'.

text-shadow va également utiliser des couleurs mais cette pas grave de toute façon je vous dis on verra ça par la suite.

'texte-shadow' va permettre de mettre une ombre d'accord une espèce d'ombre portée qu'on en infographie, en graphisme qui va pouvoir en fait se mettre en plus du texte.

Elle va prendre plusieurs valeurs l'une à la suite des autres, la première ça va être la valeur horizontale donc le positionnement horizontale de cette ombre d'accord en premier.

Donc c'est une valeur qu'on met notamment par exemple en pixels  qu'elles soient négatives ou positives.

Par exemple je peux mettre 2px pour dire que c'est à 2 pixels horizontale d'accord mais décalé, il va y avoir un décalage de deux pixels.
```css
	p.modif-p
	{
		text-shadow:2px;
	}
```
On peut avoir également pour la valeur verticale d'accord donc la valeur verticale, je vais mettre admettons pareil, on va mettre 2px pourquoi pas.
```css
	p.modif-p
	{
		text-shadow:2px 2px;
	}
```
A partir de là on peut également travailler maintenant sur l'intensité de l'ombre d'accord, plus vous allez mettre une valeur ici haute en pixels et plus l'ombre va être dispersée d'accord moi par exemple je met 5px et ensuite on terminera avec une couleur.
```css
	p.modif-p
	{
		text-shadow:2px 2px 5px #bb2d2d;
	}
```
Voilà ce qu'il se passe d'accord donc comme j'ai mis 2 pixels pour l'horizontale ça a décalé vers la droite de 2 pixels.

Cà a décallé également vers le bas de 2 pixels.

J'ai une intensité fait en tout cas un blur c'est à dire la projection de notre ombre qui fait 5 pixels d'accord tout autour du texte et une espèce de couleur rouge comme vous le voyez ici.

Si on veut vraiment que ça épouse parfaitement le texte il suffit de mettre à zéro.
```css
	p.modif-p
	{
		text-shadow:0px 0px 3px #bb2d2d;
	}
```
Là en actualisant voyé que ça se met pile en dessous du texte en fait d'accord ça va vraiment juste autour sans faire de décalage donc l'ombre se met à la fois à gauche, à droite, en haut et en bas du texte d'accord ça permet comme ça d'avoir un style un peu particulier.

Donc on n'a pas encore vu les couleurs au niveau du texte en lui-même, on voit juste le shadow donc l'ombre pour un texte ça fait appel à des couleurs parce qu'évidemment c'est plus pratique de fonctionner comme ça mais quand on étudiera vraiment les couleurs, on reviendra éventuellement sur 'text-shadow' pour que vous voyez l'association des deux et ce que ça peut donner comme résultat, c'est plutôt sympathique.

Je ne perdrais pas trop de temps là-dessus, c'est très simple à utiliser comme pour tout ce que je vous présente dans les cours en css, mettez en pratique tout ça en faisant voilà vos pages web en testant plein de propriétés et voyez visuellement ce que ça donne.

C'est le meilleur moyen d'apprendre, de comprendre comment les choses fonctionnent entre elles et surtout quand on les associe voilà plusieurs fois parce que moi je n'associe pas trop de propriétés entre elles pour éviter d'alourdir la vidéo.

Il y a un autre point qui est intéressant c'est 'text-transform' c'est à dire qu'on a vu par exemple encore une fois comment mettre en gras, en italic etc mais on peut également procéder à d'autres modifications sur le texte.

Pour cela on va utiliser 'text-transform' qui va pouvoir également prendre plusieurs valeurs différentes.
```css
	p.modif-p
	{
		text-transform:;
	}
```
Là ce qui est intéressant c'est qu'on va pouvoir par défaut si on ne met rien du tout on mettrait un none d'accord.
```css
	p.modif-p
	{
		text-transform:none;
	}
```
"none" c'est pour dire voilà on laisse tel que c'est d'accord c'est la valeur par défaut que l'on a et si j'actualise ça laisse comme c'était donc si vous avez un "none" pour quelque chose qui à la base ne l'est pas ça sert à rien de mettre la propriété. Cette propriété là est inutile dans mon cas.

Par contre là où elle peut être utile c'est de mettre une autre valeur, on va avoir notamment la valeur "capitalize" donc je vous montre également parce que c'est beaucoup plus parlant que de vous l'expliquer comme vous voyez ça fait comme pour les "small-caps" mais pas tout à fait d'accord parce que vous voyez que ce qui est mis en lettres capitales c'est uniquement les premières lettres de chaque mot et non pas toutes les lettres du texte donc attention c'est pas comme "small-caps" c'est un peu différent.

	p.modif-p
	{
		text-transform:capitalize;
	}

Là c'est seulement les premières lettres de chaque mot de mon texte donc ça pas être utile dans certains cas éventuellement si vous avez besoin de faire ça sur les termes anglais qui sont souvent écrits comme ça, en français avec une majuscule au début et en anglais je pense notamment dans les jeux vidéo où souvent par exemple quand vous avez un nom d'objets ou autre qui est en plusieurs mots vous avez dû remarquer que chaque mot commence par une majuscule parce que c'est comme ça que c'est fait l'orthographe en anglais contrairement au français par exemple où on mettrait juste une majuscule sur le premier mot.

Ca voilà ça peut être utile c'est bien en tout cas à savoir. On peut également lui mettre "uppercase" pour tout mettre en majuscules voilà tout simplement.

	p.modif-p
	{
		text-transform:uppercase;
	}

Et on peut carrément décidé de faire l'inverse qui est "lowercase" donc là c'est vraiment l'effet inverse, on passe tout en minuscule voilà tout simplement donc on vire vraiment toutes les majuscules donc c'est des petites choses à savoir en plus de 'text-décoration', de 'font-weight' ou de 'font-variant', 'font-style' comme on l'a déjà vu précédemment.

	p.modif-p
	{
		text-transform:lowercase;
	}

Ce des petites choses à connaître et c'est une propriété plutôt sympa à ce niveau.

là voilà je vous ai montré 'text-decoration', 'text-transform' et 'text-shadow' ça fait 3 petites propriétés mais qui permettent déjà de faire beaucoup beaucoup de choses.

Maintenant qu'on a vu des transformations de textes, on va continuer avec des positionnements ou du système d'espacement d'accord maintenant qu'on a vu toutes les transformations notamment déjà avec l'alignement de textes, ça c'est un point qui est super super pratique et très très utilisé en web puisqu'il va permettre de gérer évidemment l'alignement de nos textes d'accord par défaut 'text-align' est à "left".

	p.modif-p
	{
		text-align:left;
	}

Par défaut c'est comme ceci d'accord aucune modification par rapport au fait de ne rien avoir. On peut évidemment mettre un "right" qui va faire un alignement vers la droite voyez ça ce met sur la droite.

	p.modif-p
	{
		text-align:right;
	}

On peut avoir également un alignement centrale donc "center" voyez ça centre le texte.

	p.modif-p
	{
		text-align:center;
	}

Voilà ça on le retrouve dans les bouquins ou autre quand on veut présenter du texte de manière à mieux répartir dans un bloc en utilisant la justification donc "justify" et là on obtient ce type de rendu voyé ça va occuper toute la largeur en fait du conteneur où on a mis notre texte donc s'il faut il fera des espaces entre les mots un peu plus grand selon les cas.

	p.modif-p
	{
		text-align:justify;
	}

C'est à ça que sert la justification d'un texte donc ce sont de petites choses à connaître qui sont très pratiques et ça vous utiliserez tout le temps en tout le temps tout le temps etc 'text-align' c'est vraiment la base, ça sert également par exemple après pour aligner des images parce que les images comme vous l'avez vu en html ce sont des éléments in-line c'est pas des éléments qui fonctionnent comme des blocs donc on peut aligner, centrer par exemple une image en utilisant sur la propriété d'une image 'text-align' à "center" ça fonctionnera même si vous allez me dire que dans 'text-align' il y a 'text' ce qui est bizarre parce qu'une image n'est pas un texte.

Voilà c'est juste que c'est une propriété qui fonctionne en mode in-line et comme une image est en mode in-line aussi et bien 'text-alin'="center"; sur par exemple une classe que vous mettez à une image va centrer l'image sur votre page web donc c'est une petite astuce que je vous donne mais de toute façon on verra ça en pratique et notamment dans les exercices que je propose ou que je proposerai sur la chaîne dans la playlist dédié à ça.

Voilà pour 'text-align' donc c'est pas mal à utiliser et bien à reconnaître aussi.

Maintenant qu'on a vu 'text-align' donc l'alignement comme vous voyez, positionnement horizontale, on va avoir l'alignement verticale donc là c'est pas text- quelque chose c'est 'vertical-align' tout simplement.

	p.modif-p
	{
		vertical-align:;
	}

Là le fonctionnement, il y a plein de valeurs disponibles et il y a plein de valeurs que je n'utilise jamais parce que c'est très très très rare au niveau utilisation.

On a "baseline" c'est tout simplement basé au reste du document, on ne voit pas de distinction d'accord.
```css
	p.modif-p
	{
		vertical-align:baseline;
	}
```
D'ailleurs on verra mieux si modifie mon paragraphe `<p>` pour voir un peu mieux avec une balise `<span>` qu'on a vue dans la vidéo sur les balises structurante, comment structurer une page web.
```html
	<span class="modif-p">le chat entre dans le cadre</span>
```
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>CSS - Styliser texte (2/2)</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Chat</h1>
	
	<p>Le Chat domestique (Felis silvestris catus) est la sous-espèce issue de la domestication du Chat sauvage (Felis silvestris), mammifère carnivore de la famille des Félidés.</p>
	
	<p>Il est l’un des principaux animaux de compagnie et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, <span class="modif-p">le chat entre dans le cadre</span> de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p>Source : <a href="https://fr.wikipedia.org/wiki/Chat">ChachaPédia</a></p>
</body>
</html>
```
Là pas de différence en "baseline".

Alors je peux mettre un alignement verticale selon une valeur en pixels par exemple je peux mettre 25 pixels, par exemple je peux mettre -25 pixels et je vais vous montrer rapidement en résultats donc là on ne voit pas de grandes différences par rapport à ça mais c'est peut-être par rapport à la taille de mon conteneurs.
```css
	p.modif-p
	{
		vertical-align:-25px;
	}
```
Mais là où on va opérer un changement d'accord et c'est à utiliser par exemple dans les tableaux quand vous voulez également aligner une image de manière centré par rapport par exemple à un texte pour que l'image ne se retrouve pas plus en haut du texte, plus en bas mais la centrer par rapport à un texte où l'image serait par exemple plus grande en hauteur que le texte en lui-même.

On peut utiliser certaines valeurs autres que des pixels, des pourcentages ou les fameux "cm" ou "em" comme je vous ai déjà présenté mais notamment utiliser des termes particuliers comme "sub" donc "sub" c'est pour un texte en dessous.
```css
	p.modif-p
	{
		vertical-align:sub;
		vertical-align:super;
	}
```
Alors on ne verra pas forcément le résultat, j'aurais peut-être dû utiliser un autre élément "super" mais comme on n'a pas vu grand grand chose en css alors malheureusement vous ne verrez pas le visuel mais bon ce n'est pas bien grave. Vous pourrez le tester de toute façon de votre côté.

On a par exemple "top", "bottom" et cetera d'accord et ça va appliquer vraiment un alignement vertical et je vous dis c'est surtout utilisé sur des images.
```css
	p.modif-p
	{
		vertical-align:top;
		vertical-align:bottom;
	}
```
En tout cas si vous voulez vous pouvez le faire sur une image par exemple vous faites sur `<img>` d'accord vous mettez genre votre texte et vous mettez une image par exemple à l'intérieur d'accord genre ceci.
```css
	<p> bla bla <img src="image.png"> bla bla bla </p>

	p.modif-p
	{
		vertical-align:top;
		vertical-align:bottom;
	}
```
Voilà testez un petit peu le 'vertical-align' avec les différentes valeurs en mettant "sub", "super" ça c'est au dessus. On va avoir "top" d'accord c'est en haut. On va avoir évidemment "bottom" d'accord. On va avoir "middle" donc ça c'est très utilisé quand on veut aligner le texte de manière centré par rapport au texte et on aura des choses comme "text-bottom" et "text-top".

Vous n'allez pas en avoir besoin tout de suite, on aura l'occasion de s'en reservir par la suite et même dans les exercices mais si vous voulez les utiliser maintenant et voir comment ça fonctionne et bien mettez une image dans votre page web et testez directement sur des images, l'alignement verticale et vous verrez un petit peu ce que ça apporte en fait en terme de modification voilà.
```css
	p.modif-p
	{
		vertical-align:top;
	}
```
Je n'aurais aucune différence du fait que c'est dans un seul bloc ici il n'y aura pas de différence tant pis c'est parce que la balise <p> donc le paragraphe est un élément de type block en l'occurrence, voilà contrairement à l'image qui elle est in-line donc ce n'est pas bien grave de toute façon je vous ai expliqué comment vous en servir pour voir éventuellement les changements que ça apporte donc sachez que c'est pratique pour tout ce qui alignement vertical.

Voilà je vous les donne ici parce que je ne voyais pas dans quelle vidéo je pourrais vous les donner tout ce qui concerne le style sur le texte ou autres me paraît bien à ce niveau là.

On va ensuite passer donc on revient sur du texte vraiment, sur par exemple l'indentation d'un texte avec 'text-indent' ça c'est très utile pour gérer justement comme le terme l'indentation du texte qui va pouvoir opérer du coup de plusieurs manières.
```css
	p.modif-p
	{
		text-indent:;
	}
```
On peut déjà mettre une valeur en pixels par exemple, on peut très bien mettre 12px et là visuellement on ne voit rien évidemment.
```css
	p.modif-p
	{
		text-indent:12px;
	}
```
Je peux travailler sur des pourcentages, je peux travailler sur beaucoup de petites choses d'accord au niveau de l'indentation de mon texte, je peux également le faire avec "em" etc. On peut évidemment procéder de cette manière aussi.

Je vais remettre mon paragraphe comme au début, pour la prochaine fois il faudra peut être que j'ajoute des images ou autres dans ma page web pour les prochaines vidéos pour avoir plus d'éléments sur lesquelles travailler. Ce serra évidemment plus pratique.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>CSS - Styliser texte (2/2)</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Chat</h1>
	
	<p>Le Chat domestique (Felis silvestris catus) est la sous-espèce issue de la domestication du Chat sauvage (Felis silvestris), mammifère carnivore de la famille des Félidés.</p>
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p>Source : <a href="https://fr.wikipedia.org/wiki/Chat">ChachaPédia</a></p>
</body>
</html>
```
Alors ce que je voulais vous montrer c'était 15px.
```css
	p.modif-p
	{
		text-indent:15px;
	}
```
On le voit directement au moins sur le pragraphe, ça met une indentation comme voir dans certains livres ou autre, le fait de faire ce qu'on appelle le fameux alinéas d'accord au niveau d'un texte.

C'est quand même mieux quand on a un résultat visuel sinon c'est pas très parlant donc évidemment ça fonctionne ici sur mon bloc donc mon paragraphe.
```html
		<p>........
	.........</p>
```
Ca permet comme ça de gérer cette partie-là, c'est très pratique par exemple si je fait genre un gros alinéas voyez qu'on a 150 pixels ici.
```css
	p.modif-p
	{
		text-indent:150px;
	}
```
Très pratique l'alinéas, voyez que ça peut servir dans certains cas donc c'est une propriété évidemment à connaître.

On continue avec une autre qui est 'text-overflow' et je ne perds pas trop trop de temps non plus qu'il y a beaucoup de choses à voir le css prend beaucoup de temps pour vous montrer toutes les balises.

'text-overflow' est très pratique par exemple quand vous vous avez votre texte qui est contenue dans un bloc mais il risque de dépasser c'est à dire qu'il risque d'être beaucoup plus grand et du coup plutôt que de tout afficher vous voulez par exemple à akker afficher à la fin trois petits points comme on peut par exemple comme ça ... ça vous n'avez pas besoin de le faire vous-même en programmation vous pourrez le gérer directement avec css.

'text-overflow' peut prendre différentes valeurs intéressantes, on a soit alors on peut mettre une chaîne éventuellement à la place mais ça ce n'est pas pas forcément très utile mais moi ce que je vous montrez c'est le cas de "clip".
```css
	p.modif-p
	{
		text-overflow:clip;
	}
```
"clip" c'est tout simplement qu'on va couper le texte sans rien changer d'accord alors là le problème c'est que comme mon bloc est déjà assez grand vous risquez de ne rien voir.

Le problème c'est qu'avec css, on est parfois obligé de présenter d'autres balises parce qu'on ne verra pas tout. Alors ce que je montre là, on le verra dans d'autres vidéos, je vais mettre une marge `margin:auto;` et une largeur `width:500px;` mais ne vous inquitez pas on verra tout ça.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		text-overflow:clip;
	}
```
Ca ne change pas bien grand chose mais ce n'est pas bien grave donc "clip" puisque je vous le dis encore une fois car il me manque des éléments pour vous montrer vraiment "clip" par exemple à la fin une fois qu'il est arrivé au bout en fait de ce que l'on veut, sur l'endroit où on veut l'appliquer il va tout simplement s'arrêter d'accord.

Il va arrêter en fait le texte, en revanche si j'utilise à la place de "clip" la valeur "ellipsis" que je ne me trompe pas "ellipsis" va rajouter carrément des petits points d'accords.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		text-overflow:ellipsis;
	}
```
Ici on ne verra pas les trois petits points mais il mettra par exemple 3 petits points à la fin de son texte donc ça peut être super pratique quand on ne veut pas par exemple dépasser une certaine quantité d'informations à l'affichage encore plutôt que devoir tout afficher ou autre et bien il va afficher toute la partie qui nous intéresse et à la fin, il mettra 3 petits points tout simplement donc ça peut être pratique aussi.

Mais encore une fois il faudrait que je fasse vraiment une vraie page web avec pas mal d'informations pour que ce soit visuellement, que je puisse vraiment vous le montrer mais au moins je vous explique comment ça s'utilise d'accord.

La différence c'est que "clip" ça va couper directement d'accord le texte alors que "ellipsis" lui va rajouter trois petits points, il va faire tout simplement une ellipse en fait au niveau de notre texte.

Pas grave de toute façon, je voulais montrer comment ça fonctionne et c'est pas gênant puisqu'il manque des éléments au niveau html pour que ça fonctionne mais c'est pas gênant, au moins je vous ai montré comment ça fonctionnait dans tous les cas.

Donc "overflow" c'est par rapport à ça, on verra d'autres choses de toute façon concernant "overflow", on pourrais je pense faire une vidéo complète rien que sur ça donc éventuellement je reviendrai là dessus.

Ce n'est pas gênant mais c'est vrai que css n'est pas forcément pratique à faire apprendre parce qu'il faudrait qu'en fait on voit tout en même temps.

Il faudrait pas qu'on dise bah tiens au début on voit telles propriétés et ensuite on voit tel autre parce qu'il y a des propriétés qui fonctionnent avec certaines autres et du coup tout ce mélange mais si je commence à tout mélanger, on aura une vidéo qui n'en finis pas et puis surtout enfin voilà on se mélangerais dans tout, absolument tout, et ce ne serait pas forcément pratique pour vous donc désolé de devoir comme ça segmenté chaque partie.

Voilà c'est histoires de faire quelque chose de progressif parce qu'on ne peut pas tout voir d'un coup sinon ce serait juste ingérable pour vous, infaisable même au niveau de la vidéo il y aurait trop de choses à montrer.

Donc je fais un récapitulatif, on a vu donc 'text-decoration', on a vu 'text-transform', on a vu 'text-shadow', 'text-align', on a vu 'text-vertical' même si c'est pas très très utile pour le moment.

On a vu 'text-indent' et 'text-overflow' d'accord ça c'est tout ce qui concerne le texte donc on a vu grosse modo tout ce que je voulais vous montrer par rapport à ça.

Maintenant on va rentrer plus en détail dans les caractères et les mots, on peut également faire des petites modifications à ce niveau là qui sont ma fois très pratique.

La première ça concerne l'espacement des lettres donc encore une fois des caractères enfin pour ça on va utiliser la propriété 'letter-spacing'.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		letter-spacing:;
	}
```
'letter-spacing' c'est comme pour beaucoup de choses, vous allez pouvoir jouer ... je pense que le nom suffisamment claire par rapport à ça ... jouer l'espacement d'accord au niveau des caractères de votre texte d'accord donc c'est très simple à l'utilisation et vous allez pouvoir comme ça choisir une valeur que vous voulez donc en général on met des pixels d'accord c'est ce qu'on utilise.

Si je dis trois pixels ça veut dire que chaque lettre est séparée évidemment avec une marge de 3 pixels.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		letter-spacing:3px;
	}
```
Vous voyez comment ça transforme le texte d'accord on peut même le voir ici donc ça peut rendre des choses, des fois un peu bizarre au niveau de la lisibilité mais ça pour certains cas ça peut être intéressant de travailler cette propriété pour l'adapter à quelque chose que l'on voudrait donc c'est plutôt sympa à voir donc n'hésitez pas éventuellement à vous servir de ça donc je vais aller très vite sur la fin parce que je pense que la vidéo dure depuis un petit moment déjà et je ne veux pas non plus trop trop long.

On a ensuite tout ce qui est les espaces blancs donc au niveau des espaces blancs d'accord donc on va utiliser cette fois-ci 'white-space' et donc 'white-space', on va avoir en fait la méthode de base qui est "normal".
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		white-space:normal;
	}
```
Donc "normal" c'est comme ceci aucun changement, on peut également faire une méthode "nowrap", "nowrap" c'est pour dire en fait tu ne fais pas de coupures dans le texte.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		white-space:nowrap;
	}
```
Voilà il va y avoir une différence ici donc vous voyez qu'il ne décide pas en fait une fois qu'il a atteint le bloc de fin donc là imaginer que `<p>...</p>` c'est une boîte en fait qui fait je crois 500 pixels de largeur et bien même si tu arrives à la fin de cette boîte tu ne reviens pas la ligne, tu t'en fous, tu continues et là vous voyez que le texte est continus comme ça et ça m'affiche une grande barre de défilement horizontale ok ça ça peut être dans certains cas utile, je ne sais pas exactement lesquels, à voir mais ça peut servir.

On a en revanche un cas très particulier qui lui dirais tu agis comme un "pre" donc ça je ne reviens pas dessus vous savez en html à quoi ça correspond donc il va garder le texte en fait en fonction de la manière dont il a écrit dans votre page.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		white-space:pre;
	}
```
Donc moi ici même si bon mon éditeur prévoit un retour à ligne automatique, en réalité là le `<p>` ici est tout sur une seule ligne. Par contre si moi je décide à un moment donné de couper d'accord j'aurais normalement comme vous voyez une modification ici pour qu'il garde en fait le même affichage donc la même représentation tel que je l'ai écrit dans mon fichier voyez.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>CSS - Styliser texte (2/2)</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Chat</h1>
	
	<p>Le Chat domestique (Felis silvestris catus) est la sous-espèce issue de la domestication du Chat sauvage (Felis silvestris), mammifère carnivore de la famille des Félidés.</p>
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la 
	
		législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p>Source : <a href="https://fr.wikipedia.org/wiki/Chat">ChachaPédia</a></p>
</body>
</html>
```
Graçe à la valeur "pre" il gère les espaces blancs, les tabulation, etc tout est géré à ce niveau là voilà donc c'est à tester donc je voulais montrer "pre".

On a également d'autres choses, on "pre-line" donc ça c'est un autre style aussi à voir mais il y en a que j'utilise pas parce que honnêtement j'en ai pas spécialement besoin.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		white-space:pre-line;
	}
```
Et on a "pre-wrap", c'est pareil c'est le navigateur surtout qui va gérer par exemple les retours à la ligne éventuel soit avec des retours à ligne genre avec des balises `<br>` ou non d'accord.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		white-space:pre-wrap;
	}
```
Et là par défaut, vous voyez qu'au niveau du code source effectivement tout une sur une ligne en fait à la base d'accords c'est grâce au css qu'on arrive à lui dire bah en fait tu repasses à la ligne à chaque fois mais sans css on aurais un texte comme ça qui irait tout le long, tout le long, tout le long en fait au niveau notre fichier donc ça attention c'est des petites choses à savoir.

"pre-wrap", ça c'est pour les espaces tout ce qui cassure, donc césure en fait au niveau des mots ou alors simplement de tout mettre, tout laisser en fait sur une seule ligne.

Alors au niveau de l'espacement entre, on a vu 'letter-spacing' mais on peut voir l'équivalent qui est 'world-spacing'.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		word-spacing:;
	}
```
'world-spacing', c'est pareil vous avez une valeur en pixels par exemple comme ceci, 15px c'est-à-dire que tu sépare de 15 pixels chaque mot d'accord.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		word-spacing:15px;
	}
```
D'accord donc on peut le coupler avec 'letter-spacing' pour faire quelque chose d'assez lisible pour rendre les choses un peu plus agréable à l'oeil genre 'letter-spacing' vous pouvez faire 8px bien que ce serait bizarre honnêtement de faire ce genre de choses.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		letter-spacing:8px;
		word-spacing:15px;
	}
```
Voilà mais du coup c'est un petit peu étrange voilà ça fait effectivement des gros espaces comme ça entre chaque mot donc ça peut être un moyen de styliser encore une fois le texte de le présenter d'une certaine manière comme vous le voulez donc n'hésitez pas à voir tout ça.

Je remets le texte par défaut voilà au niveau de 'word-spacing'.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{

	}
```
On également la coupure des mots donc le 'word-break' et 'word-break' va fonctionner par défaut en "normal" si vous voulez le mettre en normal.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		word-break:normal;
	}
```
On peut lire également tu coupes tout "break-all" voilà donc là vous voyez il occupe vraiment tout l'espace et là regardez ce qu'il fait au niveau des mots, ils les coupent complètement.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		word-break:break-all;
	}
```
```txt
	Essentiellement territor
	ial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseau
	x.
```
Donc là le mot territor-ial est coupé.

Une fois que le navigateur considère en fait ici qu'il arrive à la fin du bloc, il ne cherche pas à placer ce nouveau mot à la ligne, non non, il coupe à l'endroit exacte où il peut le couper du coup vous voyez ça coupe les mots donc ça attention dans certains cas cela peut rendre les choses illisibles mais il faut savoir que ça fonctionne.

Sinon vous pouvez faire l'inverse qui est "keep-all" qui garde tout.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		word-break:keep-all;
	}
```
Et là éffectivement voyez par exemple le mot
cinquantaine ici au lieu de le couper ici à ci- eh bien il dit que si le mot cinquantaine ici ne peut plus passer parce qu'il y a plus de place dans mon block, hé bien pas grave il le commence à partir de la nouvelle ligne et ainsi de suite c'est pour ça que le texte est bien présenté comme ceci.

Voilà pour 'word-break' et on a ensuite un autre équivalent qui est 'word-wrap' d'accord donc ça 'word-wrap' c'est pareil, c'est un petit peu plus récents, un petit peu différent.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		word-wrap:normal;
	}
```
On va avoir le cas de "normal" donc par défaut et on va avoir le cas de couper les mots donc "break-word" et ça c'est pareil ça peut être très utile.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	p.modif-p
	{
		word-wrap:break-word;
	}
```
"break-word" alors ça c'est pareil, ça peut être très utile alors là on ne voit pas de différence, oui parce que ça fonctionne surtout beaucoup avec les url's.

Pourquoi je parle du url parce qu'une url en fait dans certains cas elle va faire comme si ce n'était qu'un seul mot donc une url en réalité on ne devrait pas pouvoir la couper en plusieurs mots je pense qu'on peut d'ailleurs la montrer et je peux mettre une url comme ça dans mon texte pour que vous voyez, je met vraiment n'importe quoi comme url d'accord.
```css
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>CSS - Styliser texte (2/2)</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Chat</h1>
	
	<p>Le Chat domestique (Felis silvestris catus) est la sous-espèce issue de la domestication du Chat sauvage (Felis silvestris), mammifère carnivore de la famille des Félidés.</p>
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie <a href="#">http://www.monsite.fr/animaux/chat/alimentation</a> et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p>Source : <a href="https://fr.wikipedia.org/wiki/Chat">ChachaPédia</a></p>
</body>
</html>
```
```txt
	http://www.monsite.fr/animaux/chat/alimentation
```
Donc je mets n'importe quoi ici comme url, ce genre de choses ici en fait tout ça forme un seul mot parce que vous voyez tout est attaché d'accord alors dans certains cas ça peut être assez embêtant lorsque l'url est comme ceci.
```txt
	http://www.monsite.fr/animaux/chat/alimentation/croquettes/a/1128
```
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>CSS - Styliser texte (2/2)</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Chat</h1>
	
	<p>Le Chat domestique (Felis silvestris catus) est la sous-espèce issue de la domestication du Chat sauvage (Felis silvestris), mammifère carnivore de la famille des Félidés.</p>
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie <a href="#">http://www.monsite.fr/animaux/chat/alimentation/croquettes/a/1128</a> et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p>Source : <a href="https://fr.wikipedia.org/wiki/Chat">ChachaPédia</a></p>
</body>
</html>
```
```txt
	http://www.monsite.fr/animaux/chat/alimentation/croquettes/a/1128
```
Là voyez par défaut et bien les choses vont être coupés grâce à "break-word".
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	.modif-p
	{
		word-wrap:break-word;
	}
```
Or le problème c'est que dans certains cas si on n'a pas ça.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	.modif-p
	{

	}
```
Alors je ne sais pas si ça va le fermer mais logiquement ça devrait... oh non parce que c'est au niveau du bloc pardon mais par exemple vous allez vouloir faire un tableau en html d'accord et vous allez pouvoir gérer l'espacement et bien les petits malins surtout par exemple quand vous des gens qui vont pouvoir ajouter même du texte genre un ajout dans un article ou autre et bien en ayant des url on aura donc une cassure qui ne se fera pas automatiquement ce qui fait que du coup on se retrouvera avec une url comme ça qui va dépasser du cadre qui était prévu par votre page web alors que vous auriez pourtant spécifié une largeur disponible.

Mais comme une url normalement ne peut pas être coupée c'est-à-dire qu'il considère tout ça comme un seul et même mot parce que tout est ensemble, il n'y a pas d'espaces dans une url normalement.

S'il y a des espaces dans une url, ce n'est pas une url donc automatiquement il ne pourrait pas faire la coupure donc ça c'est pareil ça peut être très utile notamment dans les tableaux, on se sert beaucoup 'word-wrap' dans les tableaux pour permettre la cassure de certaines choses quand on se retrouve avec des éléments qui peuvent dépasser pour éviter par exemple que ça déborde d'un tableau ce qui ferait visuellement pas propre du tout, ça peut être très utile à ce niveau là.

Voilà au niveau des propriétés qui est intéressantes, on en a quelques unes, on va terminer avec quelques petites propriétés rapides.

Il y en a une qui peut concerner la direction donc c'est des choses ça encore une fois qui sont à voir surtout en html mais n'oubliez pas de pas ne mélanger la sémantique de la mise en forme mais vous savez que vous pouvez par exemple pour les textes de droite à gauche le faire de manière sémantique via html, c'est ce qui a recommandé par contre si vous voulez juste le faire visuellement admettons par exemple vous faites un petit jeu vidéo sur navigateur en ligne, vous voulez du coup faire une espèce de message un petit peu masqué ou autre et vous voulez visuellement du coup mettre l'écriture de droite à gauche donc c'est pas un apport sémantique mais un apport visuel, vous pouvez utiliser la propriété 'direction' avec plusieurs valeurs possibles.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	.modif-p
	{
		direction:;
	}
```
la valeur de base c'est "initial" qui va prendre la valeur par défaut évidemment donc là on verra pas de changement.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	.modif-p
	{
		direction:initial;
	}
```
En revanche, on peut très bien avoir "ltr" pour left to right ou alors "rtl" pour right to left d'accord et là vous voyez comment ça se passe.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	.modif-p
	{
		direction:rtl;
	}
```
On a une écriture qui se fait dans ce sens là ça peut également s'appliquer avec une autre propriété qui s'appelle 'unicode-bidi' d'accord que je ne montrerai pas parce que honnêtement moi je ne l'ai jamais utilisé personnellement je vous le dis voilà tout de suite donc si vous avez vraiment besoin de vous en servir un jour bas vous pourrez toujours aller voir au niveau des normes du w3c comment elles s'utilisent mais je pense que ça ne servira pas à 99 % des gens parmi vous donc voilà je dis juste simplement qu'elle existe donc elle s'écrit comme ça pour vous montrez un petit peu.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	.modif-p
	{
		unicode-bidi:;
	}
```
L'éditeur nous montre plusieurs valeurs qu'elle peut gérer donc ça c'est les valeurs de bases : "isolate", "bidi-override", et cetera donc à voir personnellement je ne les ai jamais utilisées donc je ne sais pas vous dire dans le détail comment elle fonctionne parce que comme je n'en ai pas besoin, je n'ai pas eu besoin forcément d'apprendre son utilisation mais n'hésitez pas à voir éventuellement ça peut servir dans certains cas.

Et après on a également 'text-justify', j'en ai pas encore parlé parce que c'est un cas particulier qui va en fait pouvoir jouer pour la justification d'accord 'text-justify'.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	.modif-p
	{
		text-justify:;
	}
```
'text-justify' qui peut par exemple choisir de gérer la justification, savez le fait que par exemple ça occupe tout l'espace dans un conteneur en disant de faire les séparations soit entre les mots donc ça c'est quand générallement ça se fait par défaut avec le texte text-align:justify; ou alors entre les caractères mais comme c'est pas compatible ni sur chrome et opéra parce que moi je l'avais testé sur Chrome parce que j'utilise là tout de suite ça ne marchait pas et Opéra ça ne marchais pas non plus, je vous déconseille évidemment son utilisation parce que tous ceux qui seront sur opera et chrome alors que chrome est quand même un des navigateurs les plus utilisés, hé bien ça ne fonctionnera pas donc ce serait dommage d'avoir des soucis d'affichage de votre site à cause de ça.

Donc 'text-justify' sachez qu'elle existe mais elle n'est pas compatible avec tous les navigateurs donc ne vous en servez pas.

Après oui je reviens sur un petit point au niveau de 'text-align' mais c'est pareil c'est pas forcément valide partout, on peut également appliquer une autre propriété qui est 'text-align-last'.
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	.modif-p
	{
		text-align-last:;
	}
```
'text-align-last' ça veut dire quoi ? ça veut dire en fait de choisir l'alignement de la dernière ligne d'un texte, par exemple vous faites ça genre 'text-align' par défaut genre "center" d'accord et pour dire par contre l'alignement de ce block donc ici de la dernière tu le mets à "right".
```css
	body
	{
		margin:auto;
		width:500px
	}
	
	.modif-p
	{
		text-align:center;
		text-align-last:right;
	}
```
Il va se passer ça d'accord donc là vous voyez tout est centré, en revanche sur la dernière ligne même si on ne s'en rend pas trop trop compte ici eh bien on voit en fait qu'elle est alignée à droite.

Le point est vraiment tout au bout ici du conteneur si je faisais une bordure on se rendrait compte donc que la dernière ligne est alignée à droite alors qu'ici tout le reste est aligné au centre.

Mais ça c'est pareil comme ça ne fonctionne pas forcément partout donc c'est pas forcément très utilisé, je vous en parle rapidement sachez que ça existe encore une fois après est-ce que vous en servirez je pense pas ou en tout cas dans très peu de cas mais moi je m'en sers jamais donc personnellement je pense pas qu'ils aient de énormément d'utilisation de cette propriété mais c'est bien de savoir qu'elle existe que ce n'est pas une propriété qui a été inventé. Elle existe bien en css donc je suis là pour vous apprendre des choses, pour vous montrer que les choses existent après il y a des choses dont vous vous servirez et d'autres non évidemment.

Et j'en terminerai je pense, je pense que c'est déjà pas mal avec cette deuxième partie du coup sur tout ce qui est stylisation donc style appliqueé à notre texte on aura vu beaucoup beaucoup de propriétés donc s'il y a des questions parce que j'ai dû quand même aller relativement vite par rapport à ça, n'hésitez pas à les poser, encore une fois entraînez-vous.

Tout dépend de quand est-ce que vous aurez regardez cette vidéo mais il y a ou il y aura ça dépend des exercices en html et css donc dans une playlist html css - exercice d'accord comme je fais habituellement pour les autres formation.

Pour les autres formations vous pouvez comme ça mettre en pratique tout ça donc il y aura du html, il y aura du css également pour tout voir et revoir pour vraiment mettre en pratique, mettre en application ce que vous avez appris et voir comment tout cela fonctionne ensemble d'accords, et pas seulement séparément.

Le cours est là pour vous permettre d'apprendre les exercices sont là ensuite pour vous permettre d'assimiler et les tutoriels c'est des petites annexe, des suppléments pour compléter vos connaissances, vos compétences et pouvoir appliquer plus de choses encore dans tout ce que vous apprenez.

J'espère que cette vidéo vous a plu que ça n'a pas été trop trop long même si bon j'ai expliqué tout le nécessaire parce qu'encore une fois il y a beaucoup de choses à présenter, on ne peut pas passer à côté des choses sinon on passe à côté de certaines fonctionnalités qui peuvent peut-être vous intéresser.

Ce n'est pas parce que certaines propriétés que moi je n'utilise pas personnellement que vous vous n'aurez jamais besoin on et voilà on a tous des projets différents donc n'hésitez pas à voir tout ça, à les réutiliser, à bien comprendre comment ça marche et s'il ya des questions encore une fois n'hésitez pas vous avez notre discord je rapelle, on a un discord avec tous les abonnés en tout cas pas mal d'abonnés qui sont présents dessus.

A l'heure actuelle on est presque 800 donc n'hésitez pas à nous rejoindre si vous voulez, vous pouvez trouver de l'aide, moi je suis présent également très très souvent dessus et puis si vous avez des questions bien évidemment comme toujours, privilégié les commentaires youtube d'accord parce que je réponds à tout le monde là bas et en priorité voilà plutôt que les mails, les messages en privé sur twitter, etc.

Si vous voulez avoir une réponse rapide de ma part contactez-moi priorité via les commentaires youtube, c'est là que je réponds le plus rapidement et en priorité donc n'hésitez pas.

Pareil le like, le partage de vidéos etc si ça vous a plu et si vous pensez que ça peut aider d'autres personnes dans votre entourage.

Partager un maximum c'est super important, il n'y a que comme ça que vous ferez connaître mon travail que ma chaîne pourra se développer encore plus, je vous remercie d'avance.

A bientôt pour une nouvelle vidéo sur formation vidéo et en attendant entraînez-vous bien en html et css.

A bientôt tout le monde