# [17. Couleur et fond](https://www.youtube.com/watch?v=txiwOU0gUlw)
29-01-2021

Bonjour tout le monde, bienvenue sur la séance numéro 17, vous êtes sur la formation html css et maintenant que nous avons vu comment appliquer une mise en forme sur nos textes, on va pouvoir passer à un passage assez intéressant et important également au niveau css qui concerne les couleurs et tout ce qui est font donc un fond qu'on va pouvoir appliquer au niveau de nos page.

Je vous avais dit dans la vidéo précédente qu'on aura l'occasion de revenir là dessus puisque ça tout son intérêt évidemment surtout plus tard quand vous allez commencer à faire vos vrais design si vous voulez, vous passer d'image, vous allez pouvoir appliquer différentes couleurs éventuellement pourquoi pas même des dégradés chose que par contre que je réserve pour un tuto en annexe que vous pouvez trouver ou vous trouverez sur la chaîne youtube par rapport à ça et nous on va se concentrer déjà sur tout ce qui est couleur notamment les fonds, utilisés par exemple des images de fond même des couleurs de fond pour nos pages.

Alors j'ai mis à jour notre petit fichier html comme j'avait dit il manquait des petits éléments donc j'ai en fait rajouter une simple image.
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
	
	<p>Le Chat domestique (Felis silvestris catus) est la <p class="modif-p">sous-espèce issue de la domestication du Chat sauvage (Felis silvestris), mammifère carnivore de la famille des Félidés.</p>
	
	<p><img src="cat.jpg" alt="Illustration d'un chat"></p>
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie <a href="#">http://www.monsite.fr/animaux/chat/alimentation/croquettes/a/1128</a> et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p>Source : <a href="https://fr.wikipedia.org/wiki/Chat">ChachaPédia</a></p>
</body>
</html>
```
Donc maintenant on a ça d'accord c'est histoire d'avoir une illustration par ce qu'elle va éventuellement nous servir surtout pour la suite ça permettra d'avoir quelque chose d'un petit peu plus complet.

Je rappelle on a un titre, on a quelques paragraphes avec ici un lien à rallonge exprès pour voir un petit peu comment ça se comporte au niveau de la page, un petit lien ici à la fin et une petite image maintenant qui est affichée au sein du contenu donc on se retrouve par exemple dans un article type sur un blog ou autre c'est tout à fait dans ce genre d'exemple.

A partir de là je vais vous montrer très simplement comment utiliser certaines propriétés.

On ne va pas avoir beaucoup de propriétés, on ne va pas voir beaucoup de propriétés, on va en voir 2 dont une qui en engloble en fait plusieurs comme vous l'aviez par exemple avec 'text-transform' au 'font' dans les vidéos précédentes et on va regarder tout ça.

La première donc c'est la propriété qui va permettre de jouer sur les couleurs donc la propriété color et je vous avais dit qu'on allait revenir là dessus puisque la couleur en css peut être géré de plusieurs manières différentes et il est même possible que selon l'éditeur de code que vous utilisez, il peut gérer ça de manière bien pratique en proposant par exemple de sectionner les couleurs plutôt que de le faire vous-même à la main.

Plusieurs possibilités on des codes couleurs qui sont disponibles en css, pour cela je vous invite à rejoindre donc le lien ici donc directement sur le site du w3c.

https://www.w3.org/wiki/CSS3/Color/Extended_color_keywords

Vous avez le lien ici qui vous ramène donc vers les codes couleurs officielles d'accord donc c'est par rapport à la norme officielle au niveau des couleurs.

Les codes couleur c'est tout simplement ça ce sont les noms d'accord donc si je veux appliquer une couleur en particulier ici nous avons comme vous voyez tout un tas de couleurs disponibles avec des noms particuliers d'accord donc on peut par exemple sectionner "darkslateblue" dont je vais le copier coller ici.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:darkslateblue;
	}
```
J'actualise au niveau de ma page et on voit la modification qui s'est éffectué, on la voit légèrement mais en fait le texte est devenu violet alors je n'ai pas forcément pris le bon exemple alors qu'est-ce qui peut être pas mal visible. On peut éventuellement un petit vert que ce ne soit pas trop agressif à l'oeil voilà.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:mediumseagreen;
	}
```
Là on le voit d'accord ici évidemment tout le paragraphe donc excepté le lien puisqu'on a pas demandé à modifier le lien, si vous voulez le faire il faudrait sélectionné donc utiliser le sélecteur 'a' tout simplement qui concerne la balise `<a>` donc la balise pour les liens et ça se modifierait également, il suffirait par exemple de faire ça.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p,a
	{
		color:mediumseagreen;
	}
```
hop et à partir de ce moment le lien passe en vert aussi même si du coup on ne le reconnaît pas forcément bien dans le texte mais c'est quelque chose évidemment de possibles donc ça c'est la première possibilité au niveau de la gestion des couleurs en utilisant le code, ça nécessite de connaître les noms ou en tout cas d'avoir la doc ici pas très loin pour avoir tous ces noms-là.

C'est pas forcément pratique en plus il y a des couleurs un peu bizarre autant il y a des couleurs qui peuvent effectivement être très utilisé et d'autres qui moi personnellement je ne vois pas comment utiliser ici la couleur "chartreuse" qui est un vert fluo, qui du coup serait très très désagréable ou le "greenyellow" qui serait aussi très désagréable visuellement sur un site web mais admettons d'accord on a des couleurs comme ça.

La deuxième possibilité c'est tout simplement d'utiliser le code hexadécimale d'une couleur.

Pour savoir que pour une couleur vous avez 3 trucs principaux, vous avez en fait l'intensité de rouge, vous avaez l'intensité de vert et une intensité de bleu, soit red green blue.

C'est trois intensités peuvent être stockées donc en termes informatiques même sans trop entrer dans les détails via un système de code.

Si vous n'avez pas la présence d'une couleur ça va est égal à zéro et si vous avez la présence totale d'une des couleurs primaires, elle sera égal à FF c'est à dire 255 d'accord si on parle en termes décimale ou hexadécimal et du coup elle s'écrit plutôt de la manière suivante.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:#FF;
	}
```
On va mettre un dièse et on va mettre ensuite 2 premiers caractères donc on va mettre un nombre hexadécimal pour spécifier de 0 à 255 le taux de rouge d'accord donc le minimum c'est 00 et le maximum c'est FF pour 255 en rouge.

Ensuite on va avoir pareil por le vert donc pareil donc un autre nombre concernant le taux de vert donc par exemple si je veux avoir le maximum de vert, je vais remettre FF et ensuite on termine avec le bleu c'est donc FF aussi.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:#FFFFFF;
	}
```
Alors je rappelle pour ceux qui ne seraient pas en infographie, si vous avez par exemple un code en hexadécimal ou simplement ce qui est écrit simplement avec des F c'est à dire vous avez 255 d'intensité de rouge, 255 d'intensité de vert et 255 d'intensité de bleu, c'est du blanc d'accord.

Pour retrouver ces codes là vous n'êtes pas obligé de les connaître par coeur même s'il y en a que vous vous souviendrez par coeur par exemple si vous mettez que des F c'est du blanc, si vous mettez que des 0 c'est du noir.

Là pour les retrouver vous pouvez utiliser n'importe quel logiciel d'infographie ça peut être paint sur windows, ça peut être Gimp, ça peut être photoshop, n'importe quoi et vous avez en général possibilité de trouver une palette de couleurs sur paint c'est ici et du coup vous allez trouver la possibilité d'avoir non pas le code hexadécimal ici mais on verra par exemple d'autres taux.

Le code hexadécimal c'est sur des logiciels un peu plus poussés comme photoshop ou autre, je ne les ai pas ici mais peu importe vous saurez où trouver et vous pourrez trouver du coup ce code à 6 chiffres ou lettres puisque les hexadécimales ont des lettres de A à F pour pouvoir choisir ça.

Moi ici l'éditeur visual studio code, je lui passe simplement ma souris dessus et vous voyez qu'il me propose de faire directement le code héxadécimale et choisir la couleur que je veux et regardez il modifie automatiquement et hop j'ai plus qu'à faire ctrl+S et j'actualise ma page et voilà il a modifié la couleur très pratique.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:#4b8cb8;
	}
```
Voilà il a modifié la couleur sinon utilisez un logiciel quelques quelconque ou même par internet vous pouvez chercher html color codes sur un moteur de recherche et vous trouverez des sites qui permettent via une pipette de sectionner une couleur et d'obtenir son code hexadécimal.

Vous avez plein d'outils en ligne, des outils également sur votre pc donc n'hésitez pas à voir tout ça.

Ca c'était la deuxième notation d'accord hexadécimal très pratique.

On peut également séparer cette notation via son équivalent en rgb() red green blue ensemble donc on l'a même vu tout à l'heure c'est tout simplement rgb() et on va passer en paramètre les trois types de couleur donc je rappelle que le minimum c'est zéro donc là 0 de rouge, 0 de vert, 0 de bleu.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:rgb(0, 0, 0);
	}
```
rgb, red green blue attention c'est des termes anglais et vous voyez que ça me donne du noir tout simplement, si j'actualise voilà le texte est en noir.

A l'inverse si je mettais tout à 255 encore une fois ce serait la couleur max.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:rgb(250, 250, 250);
	}
```
Là si je fais (250, 0, 0) ça veut dire qu'il a le maximum de rouge, rien en vert, rien en bleu donc ça produit quoi ? eh bien ça produit un rouge maximum d'accord. 

Voilà donc ça c'est une autre notation possible, on peut également l'améliorer en ajoutant également le taux de transparence en mettant rgba(), a c'est pour la couche alpha pareil c'est une valeur qui va de 0 à 255.

Si vous avez zéro c'est tout simplement que la couleur est transparentes mais par contre en passant dessus regardez la sélection la prend en compte.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:rgba(250, 0, 0, 0);
	}
```
Et si vous mettez à 255 c'est que l'opacité donc la couche alpha de la couleur est maximale d'accord.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:rgba(250, 0, 0, 255);
	}
```
Vous pouvez régler entre deux par exemple ou faire des choses un petit peu moins opaque en mettant 150 et vous pourrez obtenir une opacité moindre d'accord au niveau de la couleur ici donc c'est des choses à voir, ça peut être intéressant de travailler là dessus.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:rgba(250, 0, 0, 150);
	}
```
Donc n'hésitez pas évidemment à voir ça alors en général opacity on ne va pas l'utiliser comme ça, je dis des bêtises, on va plutôt mettre 0 comme ceci et le maximum c'est pas 255 excusez moi c'est 1.0 voilà d'accord plus exactement donc si on veut par exemple un truc amoindri on va mettre par exemple 0.5 pour faire la moitié.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:rgba(250, 0, 0, 0.5);
	}
```
C'est semi opaque et là on pourrait penser qu'elle change non non c'est bien du rouge complet, c'est juste qu'elle est à opaque la couleur donc on a l'impression que ça fait presque un orange d'accord que ça vire à l'orange donc c'est simplement une question d'opacité de la couleur donc en utilisant non pas rgb mais rgba.

Et on a enfin un dernier cas pareil pour ceux qui font de l'infographie vous connaissez bien c'est tout ce qui concerne la teinte, la saturation et la luminosité pour une couleur et pour cela on va utiliser hsl() pour hue saturation lightness donc la luminosité pareil ça va prendre trois cas possibles.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:hsl(...);
	}
```
Le premier c'est niveau teinte donc soit vous mettez 0 et du coup vous aurez la même teinte alors je crois que ça va être du coup bah rien en fait c'est du gris grosso modo soit vous mettez 100 et du coup ce sera floue d'accord vous allez avoir par exemple 0 pour le rouge.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:hsl(0, ...);
	}
```
Ensuite on va avoir la saturation donc la saturation ça va être de 0 à 100. Si c'est deux 0 vous n'avez aucune saturation donc vous avez quelque chose de noir et blanc en niveaux de gris soit c'est à 100 et du coup vous avez la saturation au max donc ça pique les yeux donc évitez de mette une saturation max ça risque de faire assez mal donc par exemple 50.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:hsl(0, 50, ...);
	}
```
Et la luminosité c'est comme par exemple sur un écran de pc ou n'importe quoi. La luminosité à 0 vous aurez un écran noir d'accord on ne verra rien, je peux vous montrer la voilà donc ça pas de changement.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:hsl(0, 50, 0);
	}
```
Et si on met la luminosité au max c'est à dire 100 % et bien c'est du blanc d'accord tout simplement donc ce sera réglé évidemment à ce niveau-là.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:hsl(0, 50, 100);
	}
```
Ici du coup on va pouvoir modifier ça je peux mettre 360 éventuellement mais de toute façon il a mit ça en blanc parce que j'ai mit une luminosité au max (360) et on peut mettre différentes choses d'accord.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:hsl(360, 100, 25);
	}
```
A ce niveau là donc là quand il est comme ça ça correspond à du rgb(128, 0, 0);

Donc ça ne fonctionne pas forcément partout le hsl() pas partout donc c'est à connaître également au niveau de la gestion des couleurs en css, je ne rentrerai pas dans les détails non plus puisqu'on rentre dans de l'imagerie donc c'est encore autre chose mais grosso modo vous ce que vous allez utiliser le plus d'accords principalement c'est le rgb() quand vous allez vouloir écrire vraiment les valeurs de 0 à 255 pareil que l'on peut retrouver sur des logiciels d'imagerie par exemple si je sélectionne une couleur au hazard ça me donne le taux de rouge 233, le taux de vert 22 et le taux de bleu 143 donc il suffit d'écrire rgb() entre parenthèses, de mettre 233,25 143 pour avoir cette espèce de rose là tout simplement donc c'est très simple à retrouver sinon on travail principalement en héxadécimale le plus.

Petite astuce également si par exemple vous voulez du noir plutôt que de mettre 6 x 0 vous verrez un raccourci pour les noter que 3 x parce qu'il part du principe que si on mettait 3 x 0 c'est comme en mettre 6 donc c'est que du noir.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:#000000;
		color:#000;
	}
```
Pareil pour le blanc si vous mettez 3 x F ça correspond au 6 également simplement pour écrire de manière plus courte donc c'est une petite astuce à connaître.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:#FFFFFF;
		color:#FFF;
	}
```
Voilà pour les couleurs encore c'est aussi simple que ça donc vous avez vraiment plusieurs plusieurs manières différentes et ça va tout faire au niveau de vos pages web parce que ça va être vraiment le début d'un petit peu tout d'accord tout ce que vous allez modifier au niveau vos pages web donc c'est plutôt sympa à connaître à ce niveau là.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:rgb(78, 114, 233);
	}
```
On passe maintenant maintenant au fond tout ce qui est gestion des fonds au niveau de nos pages web alors j'ai téléchargé quelques images de fonds qui serviront voilà j'e les appelé bg1.jpg, bg2.jpg, bg3.jpg pour background pour gérer le fond à ce niveau là.

On va le faire sur le `<body>` ici je vais utiliser une propriété 'background' qui peut gérer du coup plusieurs valeurs possibles, la plus simple c'est 'background-color' qui va dire que tu choisit une couleur de fond, moi je vais mettre par exemple un espèce de gris pas trop clair mais pas trop foncée non plus donc je vais mettre DDD donc pas besoin de mettre DDDDDD non plus puisque c'est toujours le même.
```css
	body
	{
		background-image:#DDD;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:rgb(78, 114, 233);
	}
```
J'actualise et vous voyez que c'est devenu un peu plus gris au niveau du fond ma page donc ça permet comme ça de gérer des couleurs de fond, ça c'est le premier.

Après on peut également choisir de mettre une image donc au lieu de 'background-color' on va gérer avec 'background-image' et là on va lui passer une url donc on utilise url en valeur et entre parenthèses alors vous pouvez mettre des doubles quotes, des simples quotes voir rien du tout, autant mettre rien du tout ce sera plus optimisé tant qu'à faire parce que n'oublié pas que le css, plus le fichier est gros et plus il est long à charger donc n'hésitez pas à ne pas mettre de double quotes ou simple ce sera beaucoup plus rapide.
```css
	body
	{
		background-image:url(...);
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:rgb(78, 114, 233);
	}
```
Et à ce niveau là, on précise le lien comme vous le savez le faire pour les images ou tout ce qui est audio, vidéo comme on l'a déjà vu précédemment vers l'image.

Moi si par exemple je veux sectionner cette image bg4.jpg, il faut prendre tout le nom également avec l'extension c'est important et on le charge ici et là j'actualise et voilà vous voyez qu'il a chargé le fonds au niveau de la page du site donc c'est plutôt sympa à ce niveau là.
```css
	body
	{
		background-image:url(bg4.jpg);
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{
		color:rgb(78, 114, 233);
	}
```
D'ailleurs au niveau du texte, on ne veut pas forcément du bleu.
```css
	body
	{
		background-image:url(bg4.jpg);
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Voyez que quand j'actualise ça prend du temps chargé ce normal parce que l'image est très grande elle doit faire 1920 x 1080, c'est une image en full hd donc évidemment ça peut être plus ou moins long à charger.

Là il y a un petit temps de chargement à chaque fois que j'actualise d'accord donc ça attention bien évidemment je parle pas encore d'optimisation au niveau des ressources, comment en optimise par exemple les images pour avoir des images compressées et qui soit optimisés pour le web mais c'est des choses sur lesquelles on viendra par la suite de toutes façons notamment dans les exercices, les tutos donc n'hésiter pas à regarder tout ça par la suite c'est du complément.

Voilà pour tout ce qui est gestion d'image.

Maintenant qu'on a géré la couleur de fond, l'image de fond, on peut aussi bien évidemment gérer sa position par exemple ici, on a mis l'image on peut faire un 'background-position' mais on ne le verra pas parce que l'image est très très grande mais éventuellement on le verra mieux avec le petit chat voilà.
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Donc là on a des chats partout, c'est l'invasion des chats !

Voilà et là on voit que mon fonds se fait sur l'image d'accord grâce à 'background-position' je vais pouvoir choisir où la placer.

'background-position' ça prend plusieurs plusieurs valeurs possibles, on peut mettre des valeurs en pixels pour x et y donc je rappelle les coordonnées en x et y parvient on peut faire 25 pixels pour x, 25 pixels pour y comme ceci voyer que ça décale comme ça de 25 25.
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:25px 25px;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
On peut gérer avec des pourcentages par exemple 25% pour x et 70% pour y.
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:25% 70%;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Personnellement moi je n'utilise jamais de cette manière mais ça peut être utile et on peut également faire avec des noms précis, on peut dire par exemple position, on va le faire par exemple en "top" d'accord donc càd du positionnement en haut.
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:top;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
On peut le faire un "bottom" qui positionne en bas, en "left", en "right".
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:bottom;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Si vous faites ça il va choisir comme deuxième argument "center" par défaut sinon il faut préciser les deux par exemple "bottom left" qui veut dire en bas à gauche.
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:bottom left;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Voilà si vous mettez juste "bottom", c'est comme si vous mettez "bottom center" d'accord si vous mettez juste un seul mot il va considérer que le deuxième en fait c'est toujours "center" c'est pareil c'est une écriture raccourcis donc c'est pas mal à savoir.

Là par contre vous voyez que l'image est répétée, ça tombe bien tout ce qui est répétition de l'image on va pouvoir également le modifier avec 'background-repeat' et moi je vais commencer par mettre dès le départ "no-repeat" comme ça on va voir un petit peu la modification et voilà ce qui se passe d'accord.
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:bottom;
		background-repeat:no-repeat;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Ici je peux mettre "top" en position d'accord on pourra comme ça modifier.
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:top;
		background-repeat:no-repeat;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
On peut mettre également "left" donc là ça donne "left center" soit à gauche centré d'accord etc, on peut jouer là dessus. On peut mettre aussi "left bottom", on ne se rend pas trop compte de la différence en fait puisque le fonds est géré par rapport au `<body>` donc le `<body>` il n'est pas très grand au niveau de ma page puisqu'il n'est pas très grand donc il occupe vraiment peu de place en tout cas éventuellement ce que je peux faire ce sera pas mal c'est de doubler mon paragraphe voilà comme ça on se rend mieux compte d'avoir quelque chose comme ça.
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
	
	<p>Le Chat domestique (Felis silvestris catus) est la <p class="modif-p">sous-espèce issue de la domestication du Chat sauvage (Felis silvestris), mammifère carnivore de la famille des Félidés.</p>
	
	<!-- <p><img src="cat.jpg" alt="Illustration d'un chat"></p> -->
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie <a href="#">http://www.monsite.fr/animaux/chat/alimentation/croquettes/a/1128</a> et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie <a href="#">http://www.monsite.fr/animaux/chat/alimentation/croquettes/a/1128</a> et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p>Source : <a href="https://fr.wikipedia.org/wiki/Chat">ChachaPédia</a></p>
</body>
</html>
```
Donc là je remontre du coup parce que sinon vous n'auriez pas vu la différence parce que pas de bol l'image faisait la hauteur de mon texte ça c'est vraiment un hasard, voilà vous voyez un petit peu comment ça réagit.
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:center;
		background-repeat:no-repeat;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
On met juste "center" et le deuxième il va se mettre à "center" tout seul d'accord et là c'est centré par rapport à mon contenu. On peut mettre aussi "center top" pour dire tu centre mais tu mets en haut etc ... tu centre et tu mets en bas pareil voilà je pense que vous avez compris un petit peu le positionnement pour notre fond.
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:center bottom;
		background-repeat:no-repeat;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Mais tout ce qui est positionnement après au niveau des éléments en html css, on le verra dans une autre vidéo également, on aura une vidéo consacré à tout ce qui est positionnement relatif, absolu, tout ça là c'est juste pour l'image puisqu'on parle ici des fonds et des couleurs donc je l'ai gardez pour ça donc c'est à connaître.

On a également autre chose qui est intéressant c'est le background au niveau du comportement de l'image et notamment concerné la taille de l'image donc ce qu'on appelle en général le 'background-size'.

'background-size' c'est très sympa comme fonctionnalité vous allez voir pourquoi notamment pour ceux qui veulent faire un fond par exemple pour un site mais qui doit pouvoir s'étaler en fait peu importe la résolution de l'écran d'accord si vous imaginez par quelqu'un qui aurait un écran full hd, si vous devez changer à chaque fois une image qui fait 1920 par 1080 pixels ça va être très lourd d'accord parce que ça veut dire celui par exemple celui qui est sur son smartphone il va devoir charger un fonds de sites qui fait également 1920 par 1080, ca ne va être absolument pas optimisé.
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:center bottom;
		background-repeat:no-repeat;
		background-size:;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Vous pouvez sans problème décidé de faire un espèce de fond un peu flou, un petit peu abstrait et choisir dans le 'background-size' de lui demander de prendre en fait tout l'espace réservé par l'écran ce qui fait que ça fonctionnera pour tout le monde.

Ce type de fonctionnement se fait avec 'background-size' en mettant la valeur "cover".
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:center bottom;
		background-repeat:no-repeat;
		background-size:cover;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
D'accord et la voilà comment ça se passe.

Alors par défaut le "cover" peut couper éventuellement l'image d'ailleurs elle est un petit peu pixelisée, pourquoi ? parce que c'est une image en jpeg donc évidemment quand on l'agrandît plus que sa taille d'origine eh bien ça commence à flouter donc à se pixelliser c'est normal.

Par contre voyez que ça occupe du coup tout l'espace et si je m'amuse à redimensionner mon écran, regardez ce qui se passe mon image elle va s'adapter par rapport à ça, plutôt sympa alors le texte non puisque j'ai rien mit pour faire adapter le texte mais sinon oui pour l'image c'est le cas donc c'est plutôt très très intéressant voilà quand on veut gérer un fonds particuliers, c'est d'autant plus intéressant quand on le fait par exemple avec un type de fonds d'écran genre là je vais mettre bg5.jpg
```css
	body
	{
		background-image:url(bg5.jpg);
		background-position:center bottom;
		background-repeat:no-repeat;
		background-size:cover;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Là vous allez voir que ça va plutôt rendre de manière assez sympa au niveau de cd fond là, ça modifie en fait le comportement ici de remplissage de l'image de fond donc c'est à connaître.

Alors 'background-size' ça ne prend pas que "cover" comme valeur même si c'est celle qu'on utilise le plus c'est pour ça que j'en avais parlé.

On peut avoir également "contain" donc "contain" c'est un peu différent càd qu'il va éviter en fait de couper l'image voyez il s'arrange en fait pour que l'image soit toujours affiché complètement dans l'espace donc si des fois c'est trop petit bah tant pis mais voyez qu'il s'arrange toujours pour qu'elle soit affiché tout le temps, au maximum donc il fait un redimensionnement nécessaire et il gère les proportions pour que 100% l'image soit tout le temps affiché dans tous les cas contrairement à "cover" qui lui peut relier certaines parties qui ne sont pas affichée.
```css
	body
	{
		background-image:url(bg5.jpg);
		background-position:center bottom;
		background-repeat:no-repeat;
		background-size:contain;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Après on peut bien évidemment gérer ça avec des valeurs en pixels en % comme on l'a vu tout à l'heure pour la position  en faisant par exemple simplement ça, 25px 25px, admettons.
```css
	body
	{
		background-image:url(bg5.jpg);
		background-position:center bottom;
		background-repeat:no-repeat;
		background-size:25px 25px;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
C'est pareil et on pourra gérer les choses aussi d'accord notamment en mettant "center" en disant ça et c'est 25 25 on peut dire également 50% et du coup ça fait ça.
```css
	body
	{
		background-image:url(bg5.jpg);
		background-position:center;
		background-repeat:no-repeat;
		background-size:50%;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
50% du coup ça charge l'image de moitié etc mais ça s'est pareil, on ne l'utilise pas souvent donc je vous en parle parce qu'il faut savoir que ça existe et que ça fonctionne mais vous n'en aurez pas forcément le plus grand usage.

Le plus grand usage ça va sûrement être "cover" qui lui sera très très très utilisé.
```css
	body
	{
		background-image:url(bg5.jpg);
		background-position:center;
		background-repeat:no-repeat;
		background-size:cover;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Voilà un petit peu le rendu que ça peut donner ça peut être sympa du coup on peut commencer à avoir des sites assez sympa là, on a un fond parchemin et on a une page qui s'adapte automatiquement peu importe l'écran que nous avons d'accord c'est plutôt très sympathique même si a bon se rend compte qu'on a une petite marge comme a l'a vu en bas mais c'est normal parce qu'on n'a pas encore vu les marges alors que par défaut les navigateurs mettent des marges donc ça (margin) on pourrait éventuellement l'enlever.

Alors ce que je montre n'est pas forcément à faire parce qu'on évite en général d'utiliser des propriétés sur tous (*) les éléments de notre page, grosse modo je peux tout viré en faisant ça mais ne vous en faites pas on le verra dans d'autres vidéos.
```css
	*
	{
		margin:0;
		padding:0;
		outline:none;
	}
	
	body
	{
		background-image:url(bg5.jpg);
		background-position:center;
		background-repeat:no-repeat;
		background-size:cover;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Et là, l'espace blanc sous le fond parchemin fait partie du navigateur d'accord ce n'est plus lié à notre contenu mais du coup si vous avez une page suffisamment remplie en hauteur et bien ce sera bien géré d'accord donc là on a perdu complètement toutes nos marges mais ça (*) je vais l'enlever parce que c'est pas des choses à apprendre, surtout pas, on évite de faire ça dans la mesure du possible donc on va gérer ça comme ça c'est beaucoup plus propre.
```css
	body
	{
		background-image:url(bg5.jpg);
		background-position:center;
		background-repeat:no-repeat;
		background-size:cover;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Voyez que ça rend plutôt bien on a vraiment des exemples très sympa on peut du coup jouer sur une image un peu plus visuel on va dire voilà (bg2.png) et là c'est pareil tout va se jouer à ce niveau là (redimentionnement du navigateur) voilà ça ne rend évidemment pas lisible le texte pour le coup donc faites attention comment vous gérer ça mais évidemment c'est de voir que ça fonctionne d'accord.

'background-size' très très pratique en web, c'est une bonne astuce pour pouvoir par exemple appliquer un fond qui se gère automatiquement selon les résolutions d'écran sans devoir charger une image qui soit énormissime puisque du coup on peut prendre une image de 100 par 100 pixels et elle va remplir même un contenu qui ferait 4400 pixels de largeur sans problème ce serait gérée voilà sans souci à ce niveau-là mais du coup ça permet de faire des répétitions.

D'ailleurs je reviens à 'background-repeat' puisque j'en ai pas parlé plus que ça d'accord notamment pour cat.jpg ici.
```css
	body
	{
		background-image:url(cat.jpg);
		background-position:center;
		background-repeat:no-repeat;
		background-size:cover;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Comment ça fonctionne ? Je vous est juste montrer comment ne pas répéter le contenu d'accord on va même viré tient 'background-position' parce que par défaut si on ne le met pas qu'est-ce qui se passe ? le contenu est répété indépendament.
```css
	body
	{
		background-image:url(cat.jpg);
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Voyez tout est répété.

On peut donc lui passer "repeat" c'est comme ça que ça se met par défaut d'accord.
```css
	body
	{
		background-image:url(cat.jpg);
		background-repeat:repeat;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
"repeat" voyez ça ne change rien parce que c'est comme ça que c'est par défaut.

Si je met "no-repeat" ça ne se répète pas, il le fait qu'une seule fois et c'est tout.
```css
	body
	{
		background-image:url(cat.jpg);
		background-repeat:no-repeat;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
On peut également dire que tu te répète que en x donc je rappelle que sur l'horizontale "repeat-x".
```css
	body
	{
		background-image:url(cat.jpg);
		background-repeat:repeat-x;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Ou tu te répète qu'en y donc sur la verticale donc les ordonnées etc.
```css
	body
	{
		background-image:url(cat.jpg);
		background-repeat:repeat-y;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Voilà donc ça c'est plusieurs possibilités d'accords qui existent et qui sont ma foi très utile.

On a également "space" qui va choisir une image de début et de fin dans le conteneur et il va ensuite gérer les espaces blancs entre ces images de manière égale d'accord donc ici voyez il met une image en début et une image en fin et ici il essaye de réserver des espaces suffisants. Si mon image avait été plus petite il en aurait mis beaucoup plus que deux et on aurait des espaces blancs entre chacune de la même taille ça permet d'avoir quelque chose d'uniformes.
```css
	body
	{
		background-image:url(cat.jpg);
		background-repeat:space;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Et si on veut virer ces espaces donc faire le même fonctionnement en virant les espaces, ça doit être "round" qui fait ça.
```css
	body
	{
		background-image:url(cat.jpg);
		background-repeat:round;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Voilà donc là voyez l'image elle ne s'est pas répétée comme ça il la redimensionnée d'ailleurs comme vous voyez les proportions de l'image mais il s'arrange pour l'afficher de manière également comme une mosaïque et uniformément sur le contenu dans certains cas ça peut être sympa de faire un affichage comme ça comme par exemple quand vous avez une petite image de fond qui en fait peut se lier comme du papier peint d'accord ou les morceaux de papier peint peuvent se rejoindre et se lier ensemble au niveau des transitions.

Là on voit par exemple qu'il y a une cassure (entre les images) parce que c'est pas les mêmes couleurs.

Par contre si vous avez ici le début de l'image qui peut se coller avec la fin et ben vous aurez l'impression que c'est une seule et même image alors qu'en fait non elle se répète ce qu'on appelle des motifs et ça ça peut se faire en web sans problème donc là j'ai pas pris une image de motifs mais on aurait pu le faire avec une image de motifs si on voulait pour avoir cette impression d'optique ou d'images infinies alors qu'en fait c'est une toute petite image qui se répètent tout un tas de fois au niveau du fond de notre page.

Voilà donc je recapitule rapidement, on a vu 'background-color', on a vu 'background-image', on a vu 'background-position', on a vu 'background-size', 'background-repeat'.

Il en reste quelques uns encore 'background-origin' et 'background-clip'.

'background-origin' et 'background-clip' vont permettre de gérer même si on a pas encore vu maintenant l'espacement dans le contenu.

Il y a trois types d'espacement le padding c'est ce qu'on appelle une marge extérieur d'accord pour le coup mais on reviendra dessus avec une vidéo spécialement dédié à sa dans la formation.

On a "border" qui va concerner va la bordure du contenu et "content" et bien c'est à l'intérieur du contenu alors là je ne sais pas s'il y a vraiment de quoi vous montrer, comment ça se passe ? on va voir on va faire "no-repeat" et on va faire un 'background-origine' et ça prend trois valeurs possibles comme je l'ai dit "padding-box" et "padding-box" voilà ce qui se passe visuellement.
```css
	body
	{
		background-image:url(cat.jpg);
		background-repeat:no-repeat;
		background-origin:padding-box;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Donc le padding ici a été défini tout autour de ma page voyez que du coup l'image se met (coin supérieur gauche).

Si je choisit "border-box" il va choisir par rapport à la bordure d'accord donc là pas de différence parce que je n'ai pas de bordures définie, pas de padding en particulier donc vous dans certains cas vous verrez une différence mais ici vous n'en voyez pas.
```css
	body
	{
		background-image:url(cat.jpg);
		background-repeat:no-repeat;
		background-origin:border-box;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Ici on ne voit pas et si on met "content-box", on n'aura pas non plus de différence là parce que je l'ai mis sur le `<body>` voyez.
```css
	body
	{
		background-image:url(cat.jpg);
		background-repeat:no-repeat;
		background-origin:content-box;
		margin:auto;
		width:1000px;
	}
	
	.modif-p
	{

	}
```
Par contre je vais faire ça parce que du coup on ne se rend pas compte de la différence parce qu'il y a un padding par défaut pour la balise de paragraphe donc on va le faire là parce qu'encore une fois si vous ne voyez pas de différente visuellement c'est pas très intéressant.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	p.modif-p
	{
		background-image:url(cat.jpg);
		background-repeat:no-repeat;
		background-origin:padding-box;
	}
```
Voilà on va le faire là parce que encore une fois si vous ne voyez pas de différence visuellement ce n'est pas très intéressant.

Voilà comment ça se passe pour chaque paragraphe `<p>`, padding c'est ça.

Est-ce qu'on va voir une différence avec "border-box", on va tester et on ne voit pas de différence parce que j'ai pas de bordures évidemment.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	p.modif-p
	{
		background-image:url(cat.jpg);
		background-repeat:no-repeat;
		background-origin:border-box;
	}
```
Et ensuite on peux mettre "content-box" mais là c'est pareil je n'aurai pas beaucoup de différence donc c'est vraiment dans le cas où j'ai eu un pad ou une bordure définie.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	p.modif-p
	{
		background-image:url(cat.jpg);
		background-repeat:no-repeat;
		background-origin:content-box;
	}
```
Mais considéré en fait que si j'avais une bordure et un pad donc c'est à dire une bordure admettons on aurait un encadrement d'accord au niveau du paragraphe.

Un pad c'est une largeur externe donc une marge à l'extérieur de mon paragraphe.

Le "padding-box" mettrait le début de l'image donc en fait à l'extérieur d'accord sur la marge.

Le "border-box" il mettrait juste au niveau de l'encadrement d'accord de mon paragraphe.

Et "content-box" c'est ce que vous voyez là c'est à dire qu'il le met pile à l'endroit où commence le paragraphe d'accord vraiment au moment où il y a le contenu voilà la différence donc là on ne voit pas visuellement parce qu'on a pas encore vu les bordures, les espacements, on verra ça dans les prochaines vidéos donc éventuellement...

Maintenant vous n'avez qu'à noter d'accord le 'background-origin' et le 'background-clip' qui s'utilise pareil avec les mêmes types de données  comme "content-box", "padding-box" et cetera notamment pour la coupure donc la césure au niveau de l'image.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	p.modif-p
	{
		background-image:url(cat.jpg);
		background-repeat:no-repeat;
		background-clip:content-box;
	}
```
Noter les de côtés comme ça quand vous aurez vu les espacements et tout ce qui est bordure voilà dès que vous aurez vu ça au niveau de la formation vous pourrez utiliser ces propriétés pour voir voilà qu'effectivement elles ont un comportement différent.

Voilà c'est justement encore une fois comme pour la vidéo précédente, il y a des choses qu'on n'a pas encore vu donc je ne peux pas tout vous montrer malheureusement parce que je suis obliger de vous apprendre les choses de manières progressif et pas tout d'un coup.

Voilà pour 'background' et ensuite on termine avec le dernier qui est 'background-attachment' qui lui est utile pour la gestion donc pareil c'est un peu au niveau du comportement de l'image avec plusieurs choses possibles.
```css
	body
	{
		margin:auto;
		width:1000px;
	}
	
	p.modif-p
	{
		background-image:url(cat.jpg);
		background-repeat:no-repeat;
		background-attachment:;
	}
```
Le 'background-attachment' va fonctionner de plusieurs manières, si je mets "local" donc "local" on ne se rend pas compte de quoi que ce soit.
```css
	body
	{
		margin:auto;
		width:1000px;
		background-image:url(cat.jpg);
		background-repeat:no-repeat;
		background-attachment:local;
	}
	
	p.modif-p
	{

	}
```
Si je mets en revanche "scroll". Si l'image est trop grande, on va peut être changer le nom de l'image.
```css
	body
	{
		margin:auto;
		width:1000px;
		background-image:url(bg5.jpg);
		background-repeat:no-repeat;
		background-attachment:local;
	}
	
	p.modif-p
	{

	}
```
Voilà comment que ça se passe par défaut.

Je vais à grandir mon paragraphe et vous allez voir pourquoi est-ce qu'il faut en fait que ça dépasse la hauteur de mon navigateur donc mon écran en particulier autant de fois que nécessaire voilà il faut que je puisse avoir une barre de défillement.
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
	
	<p>Le Chat domestique (Felis silvestris catus) est la <p class="modif-p">sous-espèce issue de la domestication du Chat sauvage (Felis silvestris), mammifère carnivore de la famille des Félidés.</p>
	
	<!-- <p><img src="cat.jpg" alt="Illustration d'un chat"></p> -->
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie <a href="#">http://www.monsite.fr/animaux/chat/alimentation/croquettes/a/1128</a> et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie <a href="#">http://www.monsite.fr/animaux/chat/alimentation/croquettes/a/1128</a> et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie <a href="#">http://www.monsite.fr/animaux/chat/alimentation/croquettes/a/1128</a> et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie <a href="#">http://www.monsite.fr/animaux/chat/alimentation/croquettes/a/1128</a> et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie <a href="#">http://www.monsite.fr/animaux/chat/alimentation/croquettes/a/1128</a> et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p class="modif-p">Il est l’un des principaux animaux de compagnie <a href="#">http://www.monsite.fr/animaux/chat/alimentation/croquettes/a/1128</a> et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p>Source : <a href="https://fr.wikipedia.org/wiki/Chat">ChachaPédia</a></p>
</body>
</html>
```
Voilà ce qu'il se passe en local d'accord  voyez pas de changement.

Ici on constate rien de particulier.

C'est un petit peu comme si j'avais le scroll.
```css
	body
	{
		margin:auto;
		width:1000px;
		background-image:url(bg5.jpg);
		background-repeat:no-repeat;
		background-attachment:scroll;
	}
	
	p.modif-p
	{

	}
```
Si j'utilise la valeur "scroll" au moment où je défile ma page voyez que le fond défile avec le contenu d'accord ça fait ce type là.

En revanche vous pouvez choisir de fixer le fond en utilisant la valeur "fixed" qui elle va faire bouger le contenu mais regardez quand je bouge ma page c'est juste le contenu qui bouge alors que le fond reste fixe.
```css
	body
	{
		margin:auto;
		width:1000px;
		background-image:url(bg5.jpg);
		background-repeat:no-repeat;
		background-attachment:fixed;
	}
	
	p.modif-p
	{

	}
```
Voilà dans certains cas ça peut être sympa voilà selon les cas il y en a qui préféreront le mode "fixed", d'autres préférerons le mode en "scroll" ça c'est vous qui voyez, c'est une question de goût, de préférence donc les deux sont bien.

Les deux sont à tester et à vous d'adopter celui qui vous plaît le plus sur vos sites web donc c'est deux possibilités comme ça intéressante d'ailleurs pour ça ce sera mieux de faire comme ceci.
```css
	body
	{
		color:#EEE;
		margin:auto;
		width:1000px;
		background-image:url(bg5.jpg);
		background-repeat:no-repeat;
		background-attachment:fixed;
	}
	
	p.modif-p
	{

	}
```
Voilà du coup on peut gérer ça comme ça au niveau de background.

Voilà au niveau des propriétés ce que j'avais à vous montrer dans cette vidéo donc on a vu 'color' et on a vu plein de propriété de 'background' et toutes les propriétés que je viens de vous énoncez là donc je rappelle dans l'ordre : 'background-color' 'background-image' 'background-position' 'background-size' background-repeat' 'background-origin' 'background-clip' ensuite 'background-attachment' ... peu importe ça se retrouve vite.

Vous pouvez les rassembler dans une méta propriété qui s'appelle tout simplement 'background' comme ceci.
```css
	body
	{
		color:#EEE;
		margin:auto;
		width:1000px;
		background:;
	}
	
	p.modif-p
	{

	}
```
Voilà la première chose c'est la couleur donc par exemple une valeur en hexadécimal. Si on ne veut pas de couleur, il y a une petite astuce il faut mettre "transparent" c'est une valeur possible également.
```css
	background:transparent;
```
Ensuite il veut l'image donc l'url de l'image d'accord.
```css
	background:transparent url(bg1.jpg);
```
Ensuite il veut la position donc genre "top center".
```css
	background:transparent url(bg1.jpg) top center;
```
Ensuite il veut 'size' par exemple "cover".
```css
	background:transparent url(bg1.jpg) top center cover;
```
Ensuite il veut la répétition genre "no-repeat".
```css
	background:transparent url(bg1.jpg) top center cover no-repeat;
```
Voyez il prends tout à la suite comme ça tout ensemble, ensuite il veut l'origine, le clip mais moi je n'utilise pas donc moi je ne les met pas et à la fin l'attachment donc on peut mettre par exemple "fixed" ou "scroll".
```css
	background:transparent url(bg2.jpg) top center cover no-repeat scroll;
```
Et voyez qu'en une seule ligne on peut tout mettre d'un coup donc ça peut faire gagner du temps aussi d'accord dans certains cas.
```css
	body
	{
		color:#EEE;
		margin:auto;
		width:1000px;
		background:transparent url(bg2.jpg) top center cover no-repeat scroll;
	}
	
	p.modif-p
	{

	}
```
"transparent" forcément il n'est pas content aussi.
```css
	body
	{
		color:#EEE;
		margin:auto;
		width:1000px;
		background:#000 url(bg1.jpg) top center cover no-repeat scroll;
	}
	
	p.modif-p
	{

	}
```
Moi en général encore une fois si je n'ai pas grand chose à utiliser du coup je fait juste ça d'accord.
```css
	body
	{
		color:#EEE;
		margin:auto;
		width:1000px;
		background:#000 url(bg1.jpg);
	}
	
	p.modif-p
	{

	}
```
Genre je fait juste ça admettons si vous avez juste besoin d'utiliser la couleur, l'image, vous pouvez rassembler en 2 d'accord ça ne posserais pas de soucis de faire comme ça.

Evidemment là ...
```css
	background:#000 url(bg1.jpg) top center cover no-repeat scroll;
```
tout à l'heure il y en avait trop par rapport aux éléments.

Essayer de les ranger comme ça dans l'ordre et de préférence utiliser les attributs séparés d'accord, mettez 'background-color' 'background-image' c'est plus facile quand on veut modifier plus tard dans le design de votre site et beaucoup plus lisible parce qu'on comprend tout de suite à quoi correspond chaque valeur.

Si on a quinze milles valeurs dans une propriété, on ne sait plus à quoi ça correspond et on finit par les mélanges et du coup ça ne va pas donc c'est mieux je trouve d'utiliser plutôt 'background-color' comme ceci même si ça rajoute des lignes c'est vrai que c'est moins optimisé en termes de rajout de lignes donc et ensuite de faire tout simplement comme ceci.
```css
	body
	{
		color:#EEE;
		margin:auto;
		width:1000px;
		background-color:#000;
		background-image:url(bg1.jpg);
	}
	
	p.modif-p
	{

	}
```
Après si vous avez peu d'éléments vous pouvez les rassembler comme je l'ai fait s'il y a juste par exemple la couleur de fond et l'image vous pouvez les mettre ensemble dans le 'background' ce sera évidemment mieux et ce sera ça restera lisible quand même mais si vous commencez à avoir cinq six valeurs c'est peut-être mieux de les séparer en tout cas pour que se soit beaucoup plus lisible, beaucoup plus facilement maintenable par la suite.

Voilà pour cette vidéo je pense qu'on a fait le tour de tout ce qui pouvait être intéressant en terme de couleur, en terme de fond ça fait encore beaucoup de choses qui viennent s'ajouter à ce que vous avez appris en css.

Pareil comme d'habitude toujours le même conseil n'hésitez pas à mettre ça en pratique et faire vos petites pages web.

Voilà faites vous une belle page html d'accord avec des titres, des bonnes sections, des bonnes structures au niveau de votre page ... savez les `<section>` `<header>` `<footer>` tout ce qu'on a déjà vu précédemment `<article>` etc.

Vous faites un exemple d'article de blog ou même carrément de pages de sites, un truc bien complet avec des liens, des titres, des textes mis en emphases avec une liste à puces, avec un tableau pourquoi pas bref pas mal de choses et essayer d'appliquer un design css petit à petit que vous faites évoluer au fur et à mesure de ce que vous apprenez.

Il n'y a pas de meilleur moyen pour apprendre et à assimiler tout ce que vous allez voir et tout ce que vous avez déjà vu sur cette formation.

Je vous dis à bientôt pour la prochaine vidéo on se retrouvera du coup pour la séance 18.

Ciao tout le monde