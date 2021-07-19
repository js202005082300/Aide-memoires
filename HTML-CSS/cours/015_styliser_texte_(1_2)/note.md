# [15. Styliser texte (1/2)](https://www.youtube.com/watch?v=n4H0nod_gHY)

Bonjour à tous bienvenue sur cette 15ème séance en html et css.

La dernière fois j'ai fait une petite introduction pour vous expliquer tout simplement comment utiliser ce nouveau langage qui va permettre de faire la mise en forme de nos pages web après avoir vu tout ce qui est structure avec le html et on va reprendre maintenant donc à partir de cette vidéo sur les premières propriétés que nous allons étudier directement en css.

Alors j'ai repris simplement un fonctionnement très simple d'accord un fichier html, un fichier css qui lui est associés et j'ai déjà produit une page en fait qui nous servira.
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
	
	<p>Il est l’un des principaux animaux de compagnie et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.</p>
	
	<p>Source : <a href="https://fr.wikipedia.org/wiki/Chat">ChachaPédia</a></p>
</body>
</html>
```
Là je la complètera au fur et à mesure si nécessaire par rapport à ce que je vous montrerai.

On gardera un petit peu cet exemple là pour vous voyez toutes les choses qu'on peut faire au niveau des propriétés css.

Très rapidement je fais un rappel rapide du code habituel, le lien ici de la feuille css, on fait via une feuille externe, je vous avais expliqué que c'était la meilleure méthode et la plus optimisée, et la plus recommandée en tout cas pour associer du css à une page html.

Après j'ai mis un petit titre, 3 petits
paragraphes avec un lien voilà comme ça c'est très simple à ce niveau-là.

Ca nous produit donc ce genre de contenu d'accord au niveau de la page, très basique au niveau de cet exemple là.
```txt
	Chat
	Le Chat domestique (Felis silvestris catus) est la sous-espèce issue de la domestication du Chat sauvage (Felis silvestris), mammifère carnivore de la famille des Félidés.

	Il est l’un des principaux animaux de compagnie et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.

	Source : ChachaPédia
```
Et on va commencer donc dans cette première vidéo comme vous l'avez vu dans le titre par styliser notre texte avec quelques propriétés et plus exactement on réutilise en fait une propriété général qui en rassemble plusieurs qui vont pouvoir du coup nous permettre de modifier pas mal de choses donc à partir de maintenant tout ce que je vous montre en css concerne vraiment le visuel de vos pages d'accord.

Là où html lui devait se charger de la structure, de la sémantique de nos pages, de l'information ce qui va permettre après de référencer, de produire un bon référencement par la suite de vos pages avec des informations pertinentes.

Le css lui aura juste un but visuel d'accord il n'a aucune incidence au niveau des robots, tout ce qui est analyseur de sites web absolument aucun.

Sauf si bien évidemment, on a un robot qui allais analyser par exemple l'affichage de votre site mais en général les robots se chargent surtout du contenu pour pouvoir l'indexer donc c'est vraiment pour l'utilisateur que là ça va avoir une importance pour que votre site soit évidemment agréable à la navigation et pratique à l'utilisation.

les premières propriétés que nous allons voir sont très très simple on va pouvoir les appliquer sur pas mal de choses, alors on va faire sur des sélecteurs simples parce que moi ici j'ai mis des paragraphes donc on va travailler principalement là dessus pour voir un peu.

Eventuellement tout à l'heure on ajoutera des classes si on veut par exemple appliquer que sur un côté, de toute façon on a vu tout ça, ce qui est 'class', 'id', etc on en a un petit peu parlé donc voilà j'ai fait le tour par rapport à ça et les sélecteurs, il y aura de toute façon une vidéo annexes avec un ensemble de sélecteurs un peu plus détaillés même si on aura l'occasion de toute manière d'en voir suffisamment au niveau du cours pour que vous puissiez être à l'aise avec ça et pouvoir l'utiliser dans vos vrais projets.

Alors on y va on va travailler sur un paragraphe qui est ici, on va lui mettre du coup une classe d'accord que je vais appeler par exemple "modif-p" juste pour qu'on influe en fait directement sur lui.
```html
	<p class="modif-p">
```
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>CSS - Styliser texte (1/2)</title>
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
Donc on va faire 2 classe donc je met que tout les paragraphes de classe p.modif-p on va leur appliquer un style css comme ça on verra la différence en fait entre ce paragraphe là et les autres éventuellement voilà.
```css
	p.modif-p
	{
	
	}
```
Alors ça c'est bon à ce niveau là et on va pouvoir modifier du coup le petit paragraphe qui est ici.
```html
		<p class="modif-p">Il est...
```
D'accord la première chose que je voulais montrer comme propriété qui est assez intéressante c'est la propriété qui va permettre de jouer sur le style en fait de notre texte, de ce qu'on appelle la 'font' d'accord qui va en fait concerner le texte alors on aura d'autres propriété qui s'appelleront text-... quelque chose mais maintenant on va voir surtout des propriétés au niveau de la 'font' donc au niveau de ça on va pouvoir déjà modifier le style du texte.

Le style du texte ça va permettre par exemple de gérer tout ce qui est affichage en italique et attention encore une fois je le répète, là il s'agit vraiment d'un aspect visuel d'accord, tout ce qui est en html, il fallait évidemment pas prendre en compte le résultat visuel que ça pouvait donner.

En revanche en css, là ça a toute son importance.

En utilisant cette petite propriété 'font-style' on va pouvoir lui appliquer un certain nombre de valeurs possibles.

Alors il y a des valeurs qui sont assez universel on peut par exemple trouver la valeur initiale pour quelque chose de basique.

On peut avoir la valeur "inherit" qui permettra de faire hériter un sélecteur par rapport à d'autres.

On a également quelque chose qui permet par exemple de désactiver, on a le "unset" et cetera, c'est des valeurs qui sont assez globale assez générales même générique, j'en parlais pas beaucoup beaucoup puisque en général par rapport à ce qu'on veut faire nous on veut appliquer un style particulier.

On ne veut pas forcément en enlever mais comme on aura besoin de de cas très spécifique pour mettre en application ça on le verra donc nous par exemple ici on va s'occuper de mettre ce paragraphe spécial en italique alors on a le cas par défaut de 'font-style' qui prendrait la valeur "normal" comme ceci.
```css
	p.modif-p
	{
		font-style:italic;
	}
```
D'accord donc là ça va évidemment faire aucun changement si j'actualise d'accord avec F5 donc on voit pas de changement.

Je peux également utiliser le terme "italic" qui va vraiment ici utilisé la font, l'équivalent en fait de la police d'écriture mais la version italique ici et là vous voyez que à l'actualisation ça m'a vraiment changer le texte.
```txt
	Chat
	Le Chat domestique (Felis silvestris catus) est la sous-espèce issue de la domestication du Chat sauvage (Felis silvestris), mammifère carnivore de la famille des Félidés.

	Il est l’un des principaux animaux de compagnie et compte aujourd’hui une cinquantaine de races différentes reconnues par les instances de certification. Dans de très nombreux pays, le chat entre dans le cadre de la législation sur les carnivores domestiques à l’instar du chien et du furet. Essentiellement territorial, le chat est un prédateur de petites proies comme les rongeurs ou les oiseaux. Les chats ont diverses vocalisations dont les ronronnements, les miaulements, les feulements ou les grognements, bien qu’ils communiquent principalement par des positions faciales et corporelles et des phéromones.

	Source : ChachaPédia
```
Voilà on a également un équivalent mais sauf que là au lieu de se baser sur l'écriture "italic", il va en fait simplement pencher l'écriture à partir de la fonte normal d'accord et pour cela on utilisera le terme "oblique" comme ceci.
```css
	p.modif-p
	{
		font-style:oblique;
	}
```
Voilà c'est un équivalent ici au niveau du navigateur, je vais rafraîchir et là pas de différence c'est normal puisque certains navigateurs en fait ne font pas la distinction entre les deux.

Il y a beaucoup de navigateurs qui entre "oblique" et italic ne changent pas, pour ça que par habitude ça je vous le dis on utilise couramment le terme italique, on ne s'embête pas trop avec "oblique" puisqu'on obtient quasiment le même résultat visuel.

Voilà donc si vous voulez mettre du texte en italique visuellement parlant vous utiliserez la propriété font-style avec la valeur italique et là vous aurez ce texte comme ça vous voyez la différence entre ce premier paragraphe et le deuxième d'accord on a vraiment du texte en italique.

	...
	
Ca c'est la 1ere propriété que je voulais montrer donc très facile à utiliser.

La deuxième c'est 'font-variant' peut s'utiliser également avec pas mal de sous balises, on peut 'font-variant' pour caps, 'font-variant' pour numérique etc.

Moi je vais rester sur des utilisations standard parce qu'encore une fois c'est celles qu'on fait le plus c'est très très rare quand même d'avoir besoin de d'utiliser les sous propriété de 'font-variant' donc ce qu'il faut retenir, ce qui est intéressant après si vous voulez aller beaucoup plus loin de plus en détail, vous pourrez toujours aller voir dans la documentation notamment au niveau des normes du w3c.

Et moi dans ce que je vais vous montrez, vous avez comme toujours la possibilité de laisser un normal.
```css
	p.modif-p
	{
		font-variant:normal;
	}
```
Et pouvoir varier donc ici au niveau de la police pour afficher par exemple des petites majuscule d'accord des petites lettres capitales et pour cela on utilisera la valeur 'small-caps' comme ceci.
```css
	p.modif-p
	{
		font-variant:small-caps;
	}
```
Et là si j'actualise voilà la différence vous voyez tout est écrit en fait en lettres capitales mais ce n'est pas non plus en taille par exemple majuscule comme ici `<h1>`, on voit quand même la distinction entre les majuscules et les minuscules, tout est écrit en lettres capitales par contre qu'il conserve bien quand même une différence de taille entre les majuscules et les minuscules au niveau des mots.

Encore une fois je fait un sélecteur sur un paragraphe mais ça peut être sur n'importe quoi.

On pourrait le faire sur un lien en mettant par exemple 'a' tout simplement et du coup avoir ici vous voyez le lien qui se met également ça fonctionne évidemment pour tous.
```css
	a
	{
		font-variant:small-caps;
	}
```
Vous apprendrez que les sélecteurs ça fonctionne vraiment pour tout, on peut le faire également sur notre titre `<h1>` et du coup voyez que "Chat" est modifié d'accord.
```css
	a, h1
	{
		font-variant:small-caps;
	}
```
Ca je ne reviens pas dessus je complique pas les choses et je n'alourdi pas les vidéos puisque ces choses qu'on a déjà vu un petit peu et qu'on va avoir l'occasion de toute façon de voir en détail donc là je par du principe que ça vous l'avez compris pour le moment. Vous choisissez un sélecteur et d'appliquer les propriétés que l'on veut en fonction pour dire que tel élément qu'on a sélectionné, on stylise en fait nos éléments.
```css
	p.modif-p
	{
		font-variant:small-caps;
	}
```
Donc là ce sont les paragraphes qui possède la classe 'modif-p' et comme il n'y en qu'un seul sur notre page web, évidemment ça ne s'applique du coup qu'à un seul cas donc c'est assez rapide à voir.

Voilà pour 'font-variant', a vu 'font-style' on a vu 'font-variant' d'accord il y en a encore d'autres.

On en a maintenant comme on a parlé du texte italique, on pourrait voir comment mettre du texte en gras parce que c'est quelque chose qui est plutôt sympa aussi visuellement on peut utiliser la propriété 'font-weight' comme ceci.
```css
	p.modif-p
	{
		font-weight:;
	}
```
Et là c'est pareil, elle va prendre plusieurs valeurs possibles, on a la valeur 'normal'.
```css
	p.modif-p
	{
		font-weight:normal;
	}
```
Parce que ça peut également servir dans certains cas de dire je repasse par exemple sur un élément html qui par défaut ici le titre `<h1>` est écrit en gras et bien on pourrait très bien dire que maintenant je veux que le `<h1>` en fait non, on enlève le mode gras.
```css
	h1
	{
		font-weight:normal;
	}
```
Et là vous voyez que le titre "Chat" est passé comme ça en 'normal' parce que par défaut les navigateurs ce sont accordés pour dire que un titre `<h1>` est écrit en gras donc voyez ça a un intérêt d'avoir une valeur par exemple à 'normal'.

N'oubliez pas que certains éléments html seront en gras par défaut c'est tout l'intérêt justement à ce moment là d'avoir ça.

Alors du coup là si je fait carrément surtout tout les paragraphes `<p>` tout les paragraphes tout court voilà d'accord on va avoir un autre changement à ce niveau-là.
```css
	p
	{
		font-weight:normal;
	}
```
Alors là on ne voit rien parce que j'ai mis 'normal' d'accord donc pas de changement à ce niveau-là.

Si je veux éventuellement mettre quelque chose en gras, je vais utiliser la valeur 'bold'.
```css
	p
	{
		font-weight:bold;
	}
```
Et là on voit tout de suite la différence avec le texte en gras.

On a une version un peu plus accentuée qui est 'bolder'.
```css
	p
	{
		font-weight:bolder;
	}
```
Alors ça dépend sur certains navigateurs on ne voit pas forcément de distinction, là on ne voit pas de distinction ici sur firefox ou pour certains types de police de caractère, il peut y avoir une différence mais on va entrer dans les détails un petit peu après.

Vous avez une autre possibilité qui est 'lighter'.
```css
	p
	{
		font-weight:lighter;
	}
```
Je vous montre parce que voilà c'est quand même bien pratique, visuellement on ne voit pas de différence avec le mode normal à priori ou alors peut-être une légère, je sais pas trop.

Ici on a une police qui n'a pas énormément de différence au niveau de la taille mais pour certaines polices vous pouvez voir vraiment plusieurs plages d'épaisseurs disponibles et du coup c'est différentes valeurs là que je vous ai montrées aurons quelque chose de différent.

Et justement en parlant de ces valeurs là, comment ça fonctionne cette plage de police eh bien elles peuvent partir de l'épaisseur 100 par défaut, ça c'est la minimale.
```css
	p
	{
		font-weight:100;
	}
```
Ca c'est l'épaisseur minimale pour une police de caractère alors certaines commencent qu'à 400 et d'autres commencent à 200 d'accord mais il faut savoir que le minimum possible c'est 100 et le maximum c'est 900 or selon les polices que vous verez utiliser, plus tard on apprendra par exemple à utiliser des polices de caractères et télécharger via internet ou par exemple les polices de google ou d'autres eh bien vous verrez que certaines polices peuvent proposer par exemple une taille en 400 500 600 parce que ça fonctionne de 100 par 100 en fait 100 200 300 et ce jusqu'à 900.
```css
	p
	{
		font-weight:900;
	}
```
Il y en a d'autres qui ont juste quelques versions, en général la version normale c'est 400, une version un peu plus grande on va avoir 600 et 800 voilà des fois il n'y a que ces trois là et c'est tout donc il y a vraiment eu un modèle fin, un modèle normal et un modèle en gras d'accord.

Dans certains cas vous ne verrez pas différence par contre en 900 évidemment il me le met en plus gras possible d'accord donc ça met logiquement comme si je m'étais bolder ou bold pour le coup, je ne pense pas qu'il y a une différence.
```css
	p							p
	{							{
		font-weight:900;			font-weight:bolder;
	}							}
```
Voilà effectivement, voyé ça correspond à 900 en fait c'est un bolder ou bold par rapport aux navigateurs.

Pour la mise en gras s'est 'font-weight' d'accord tout simplement à retenir très pratique à utiliser.

On passe à autre chose maintenant c'est la taille de la police parce qu'on a vu son épaisseur, on a vu tout ça et maintenant on veut peut-être voir la taille.

Pour la taille on va utiliser 'font-size' très simple également à l'utilisation.
```css
	p.modif-p
	{
		font-size:;
	}
```
On va voir ici plusieurs possibilités, on reviendra dans le détail sur certains types de taille, de dimensions parce que c'est des choses qu'on peut réutiliser dans d'autres propriétés en css donc je reviendrai dessus donc là je vais aller assez vite.

La première c'est le pixel, vous pouvez choisir une taille en pixels par exemple 12px donc vous mettez px à la fin de la valeur numérique et ça va faire une police de 12 pixels.
```css
	p.modif-p
	{
		font-size:12px;
	}
```
Evidemment la limite il n'y en n'a pas vraiment en fait, il y a une limite à un moment donné mais voilà on peux avoir des polices très très très très grandes.
```css
	p.modif-p
	{
		font-size:120px;
	}
```
Vous pouvez choisir une police comme ça fixe en pixels.

On peut choisir également une police en pourcentage genre 70%.
```css
	p.modif-p
	{
		font-size:70%;
	}
```
C'est pareil en fonction de documents car ça va jouer évidemment sur le pourcentage par rapport au document ici par rapport à l'élément où il est donc on voit que le paragraphe `<p>` est dans `<body>` d'accord donc ça va jouer par rapport à ça donc là fait 80 % par rapport à ça.

On peut mettre 120%, on peut mettre évidemment des valeurs beaucoup plus grande genre 100%, 200% et cetera.
```css
	p.modif-p
	{
		font-size:120%;
	}
```
D'accords on peut jouer sur les pourcentages.

Ensuite on peut jouer carrément de manière relative par rapport justement aux éléments que l'on a, l'élément parent et là on va utiliser la notation 'em' ou 'ex' même si de manière générale on utilise plus souvent 'em' mais 'ex' je ne le vois pratiquement jamais donc on va garder 'em' puisque c'est ce qu'on voit le plus souvent et on va choisir par rapport à un élément parent.

Admettons ici mon élément parent pour le "modif-p", c'est `<body>` d'accord je vais dire par exemple je veux qu'il ait la même taille de caractère pour `<body>`.

Si je ne fais aucun changement ça correspondrait à 1em d'accord.
```css
	p.modif-p
	{
		font-size:1em;
	}
```
1em considérer que c'est 100 % de la taille de l'élément parent donc grosso modo vous ne verez aucune différence avec tout le reste de `<body>`, absolument rien par rapport à tout ce qui est géré dans le document.

Par contre si je veux que la moitié, il suffirais de mettre 0.5em.
```css
	p.modif-p
	{
		font-size:0.5em;
	}
```
Attention ce sont des points en informatique toujours, il n'ya pas de virgules et là ça veut dire à 50% voyez par rapport à la taille de caractères de la police de l'élément parent donc pour le reste de html donc là on a une police ici qui fait à peu près la moitié en fait au niveau de la taille de caractères de `<body>`, on peut jouer par rapport ça.

On peut mettre autre chose 0.8, ce qu'on veut pour gérer les valeurs, on peut mettre 2.5 également on peut mettre des valeurs plus grandes aussi c'est tout à fait possible.

Donc je rappelle la notation en pixels 'px', la notation en pourcentage avec le '%', la notation ici qui est relatif par rapport à un élément donc 'em'.
```css
	p.modif-p
	{
		font-size:0.5rem;
	}
```
Si on veut d'ailleurs avoir quelque chose de relatif par rapport à `<html>` donc la balise ici complète on mettra même un petit 'r', on mettra 'rem' et là ça joue carrément par rapport à `<html>` mais il n'y a pas beaucoup de différence parce que je n'ai pas d'autres éléments de toute manière.

Dans mon cas ici ça vous ne voyez pas de différence entre 'em' et 'rem', ça c'est les choses à savoir.

Et ensuite on a des codes donc des valeurs en fait spécifique, sufixes qui vont me permettre de changer la police très rapidement.

On a la valeur "xx-small" d'accord qui veut dire tout simplement très très petit d'accord comme ça.
```css
	p.modif-p
	{
		font-size:xx-small;
	}
```
C'est quand même un peu plus grands que ce qu'on a mis tout à l'heure (0.5rem et 0.5em) ensuite si on retire un x, on a "x-small".
```css
	p.modif-p
	{
		font-size:x-small;
	}
```
D'accord c'est un peu plus grand, ensuite on a "small". Je vous les fait très rapidement parce que ça va vite.
```css
	p.modif-p
	{
		font-size:small;
	}
```
Ensuite on a "medium", "medium" je rappelle c'est moyen voilà.
```css
	p.modif-p
	{
		font-size:medium;
	}
```
Ensuite on va avoir large.
```css
	p.modif-p
	{
		font-size:large;
	}
```
Et ensuite on fait pareil que pour "small", on rajoute un x "x-large".
```css
	p.modif-p
	{
		font-size:x-large;
	}
```
Et enfin "xx-large".
```css
	p.modif-p
	{
		font-size:xx-large;
	}
```
Voilà ça c'est pareil, sur les navigateurs, ils ont dit par exemple que "large" ça correspond à tel taille d'accord donc qu'en 'em', 'px' et cetera ... que "medium" c'est tel taille donc c'est des tailles décider en fait en général par les navigateurs.

On pouvait avoir des différences selon ... c'est pour ça que dans l'idéal on va éviter d'utiliser ces valeurs là.

On va plutôt utiliser des valeurs en pourcentage, en pixels voire même avec 'em' pour avoir des choses relative par rapport au reste du document surtout si plus tard on veut faire des dizaines adaptatives c'est à dire en fonction de la résolution de l'écran donc c'est pas mal à ce niveau là donc nous on va rester simple, on va prendre du pixel ici.
```css
	p.modif-p
	{
		font-size:120px;
	}
```
Voilà on restera sur quelque chose comme ça.

Voilà pour 'font-size' d'accord très simple à utiliser également qui va jouer sur la taille de la police de caractère donc on a vu 'font-style', 'font-variant', 'font-weight', 'font-size' et il nous en reste deux intéressants à ce niveau là.

Un autre qui va concerner notamment les espacement sur la hauteur entre les lignes donc c'est pas font-.. quelque chose mais 'line-height' et ici, même règle on peut mettre "normal" si on veut laisser comme c'est habituellement d'accord.
```css
	p.modif-p
	{
		line-height:normal;
	}
```
On peut mettre une valeur en % genre 25%.
```css
	p.modif-p
	{
		line-height:25%;
	}
```
C'est bien parce que ça se touche à 25% c'est normal d'accord donc c'est vraiment l'espacement comme ça au niveau des lignes, la hauteur en fait des lignes.

On peut mettre des pixels, 25 pixels ok.
```css
	p.modif-p
	{
		line-height:25px;
	}
```
Ici c'est plus espacées, on peut mettre 'em' également comme tout à l'heure 0.8em voilà.
```css
	p.modif-p
	{
		line-height:0.8em;
	}
```
Et cetera et cetera donc toutes les choses que j'ai déjà montrées en fait pour 'font-size' sont applicable ici donc les 'em', 'px', % et cetera vous verrez que c'est des notations que vous retrouverez dans plusieurs types de propriétés donc c'est bien de les connaître d'accord de savoir manipuler le 'em' en pratique comme toujours surtout en html et en css faites des exemples de pages web d'accord.

Entraînez-vous, c'est très simple, en olus très rapide vous faites une page html et vous mettez plein de choses dedans, après vous faites votre feuille css et vous y testé plein de propriété puis vous voyez tout simplement visuellement ce que ça donne au nouveau résultat.

C'est très simple à corriger, à avoir ce que ça donne puisque le résultat est obtenu rapidement et visuellement donc là on n'est pas dans du langage de programmation, on est dans du langage de structures donc de création de pages web donc c'est beaucoup plus rapide et beaucoup plus facile pour se corriger.

Voilà pour 'line-height' d'accord donc pour la hauteur de ligne et on va terminer avec celui qui est quand même important parce que vous avez vu tout à l'heure on travaille toujours sur les mêmes types de police et on a changé sa taille, on a changé l'épaisseur etc on a vu comment mettre en italique mais on n'a pas vu comment changer éventuellement cette police de caractère.

Donc là on va utiliser un font cette fois ci, la propriété 'font-family'.

'font-family' vous allez pouvoir spécifier éventuellement une police de caractère de votre système par contre attention si les gens qui vont sur votre site n'ont pas cette police sur leur pc, il peut y avoir des différentes entre windows, gnu linux, mac os et cetera.

Et bien ce sont d'autres polices par défaut qui seront chargées donc en général on les met éventuellement entre le quotes '..' ou double quotes ".." d'accord quand c'est un nombre par exemple qui a plusieurs mots mais maintenant c'est même plus obligatoire on peut même mettre sans et on met même des polices par défaut à la fin genre par extenple sur windows on aurait arial.
```css
	p.modif-p
	{
		font-family:Arial;
	}
```
D'accord et au final à la fin on met un nom de police en fait qui est géré directement par le web au cas où par exemple qu'Arial ne serait pas disponible pour la personne qui consulte votre site.

Et ces polices là donc je vais vous montrer les codes à connaître parce qu'ils sont quand même vachement intéressant ...

On a "serif", alors "serif" logiquement c'est ce qui est gérée par défaut par le navigateur.
```css
	p.modif-p
	{
		font-family:serif;
	}
```
Voilà donc une police "serif" c'est quoi ? vous voyez c'est une espèce de police avec des empâtements.

Des empattements c'est l'espèces de petits plats comme ça que vous avez sur les bout des lettres en fait.

Voyez le C de Chat ici, il y a une espèce de plat, le h pareil y a un espèce de plat, une petite ligne horizontale et bref si vous regardez bien vous remarquez les empâtements.

Si vous voulez les enlever càd que ça c'est en général une écriture assez littéraire mais si on veut une écriture un peu plus informatique, un peu plus moderne, on va dire qu'on n'en veut pas donc on met "sans-serif".
```css
	p.modif-p
	{
		font-family:sans-serif;
	}
```
Et là regardez la différence si j'actualise voilà on perd l'empattement seulement ici p.modif-p encore une fois puisque je l'ai appliqué que sur ça le css donc au début on est en empattement d'accord ce qu'on trouverais dans un journal et dans p.modif-p on est dans une écriture un peu plus moderne, un peu plus informatique donc automatiquement on perd ces espèces de petits plats.

Alors ça c'est vraiment les plus utilisées d'accord.

Après on a le cas "monospace".
```css
	p.modif-p
	{
		font-family:monospace;
	}
```
"monospace" c'est bien pour ceux qui font de la programmation, de l'informatique c'est une police à chasse fixe c'est à dire qu'elle va conserver les mêmes espaces, les mêmes largeur pour chaque type de caractères, par exemple la lettre i elle prendra autant de place en largeur que la lettre a pourtant la lettre i voyez elle est toute petite en largeur.

Là grâce à la police "monospace" voyez que chaque lettre prend exactement la même taille d'accord donc ça c'est pas mal quand on veut bien présenter le texte pour écrire certains types de choses, ça rappelle un peu l'écriture qu'on avait sur les machines à écrire notamment donc écriture vraiment ici qui fait aussi penser à l'informatique, qui permet de bien conserver la même taille pour chaque chose.

Voyez même ici l'apostrophent ' il fait exactement la même taille que si je sélectionne par exemple un i ou un t ou n'importe quoi c'est vraiment une police à chasse fixe.

Donc ça pas besoin d'avoir une police en particulier sur votre système, vous mettez ces valeurs là ça fonctionnera pareil pour tout le monde donc ça le minimum à faire quand vous mettez quelque chose c'est de mettre une des valeurs que je vous ai montrée "serif", "sans-serif", "monospace".

On a également "cursive" après certaines marges ou non en fonction, il y a certaines qui peuvent ne pas marcher sur certains trucs.
```css
	p.modif-p
	{
		font-family:cursive;
	}
```
"cursive" c'est un peu une écriture un peu scolaire d'accord qui peut par exemple faire des espèces de lien entre les caractère éventuellement mais là firefox ne le fais pas pour le coup mais voilà c'est une police voyez un petit peu plus enfantine j'ai envie de dire donc ça change encore le style.

Et on a d'autres valeurs que personnellement je n'utilise jamais mais bon je vous les donne quand même, il y a "fantasy".
```css
	p.modif-p
	{
		font-family:fantasy;
	}
```
Voilà je ne sais pas si le navigateur va la prendre en compte.

Ca permet de mettre des polices assez exotique, assez particulière et des styles assez particulier d'accord sur les lettres avec je ne sais pas des boucles partout, dans tous les sens.

En plus certains navigateurs comme vous voyez en plus, ils sont désactivés et on avait aussi "system-ui".
```css
	p.modif-p
	{
		font-family:system-ui;
	}
```
C'est pareil ça doit même plus être pris un compte et non c'est même plus prit en compte par contre il met une police "serif" voyez certains navigateurs ne le prennent même plus en compte selon les versions donc ce qui est sûr qui fonctionnent encore : il y a "serif", il a "sans-serif" et "monospace" c'est les trois vraiment à bien connaître, ce sont les trois qui de toute façon seront utiles.

Après encore une fois vous pouvez mettre vos polices à vous donc vous pouvez dire par exemple je veux du "Arial", je veux du "papyrus" sur windows. Et puis si jamais il ne trouve pas et bien en fait je met ça "sans-serif".
```css
	p.modif-p
	{
		font-family:papyrus, arial, sans-serif;
	}
```
Donc par défaut il va chercher la police qui est mise en premier, s'il ne la trouve pas, il va passé comme ça les unes à la suite des autres et sur la fin mettez toujours une police comme ça "sans-serif" on va dire par défaut "sans-serif", "serif" ou "monospace" pour être sûr de charger quelque chose.

Maintenant "papyrus", par contre c'est "calibri" que je dois avoir avec certitude et voyez que àa change en fonction.
```css
	p.modif-p
	{
		font-family:calibri, arial, sans-serif;
	}
```
Voilà ça modifie tout simplement la police de caractères utilisés pour ça que plus tard on verra qu'en css surtout depuis css 3, on peut faire des choses un peu plus poussées au niveau du choix de la police de caractère notamment utiliser des polices par exemple très très particulière ou même qui sont carrément récupérées depuis internet donc il n'y a même pas besoin d'avoir sur son pc, il suffit juste qu'ils aillent sur votre site et ça va lui télécharger la police automatiquement grâce au navigateur si jamais il ne l'a pas donc c'est plutôt sympathique aussi pour avoir des polices d'écriture qui sortent de l'ordinaire au niveau des sites web.

Voilà pour cet ensemble de propriétés que je voulais vous montrer pour cette première vidéo donc on ne voit pas trop trop de choses, on commence doucement parce que c'est déjà pas mal et toutes ces propriétés que je vous ai montrées peuvent être rassemblées en une seule, une meta propriété c'est-à-dire une propriété qui rassemble tout à la fois donc là je vous ai montré dans l'ordre c'est-à-dire 'font-style', 'font-variant', 'font-weight', 'font-size', 'line-height' et 'font-family' ... c'est pas pour rien simplement parce que vous avez la meta propriété qui s'appelle tout simplement 'font'.

Et 'font' prend dans l'ordre tous les éléments qu'on a vu tout à l'heure donc en premier ça va être 'font-style' donc par exemple si je met en italique et bien je met "italic".
```css
	p.modif-p
	{
		font:italic ...
	}
```
Ensuite elle prend 'font-variant' est-ce que je met en "small-caps" ou pas ? mais admettons on est fou.
```css
	p.modif-p
	{
		font:italic small-caps ...
	}
```
Voilà après elle va prendre l'épaisseur donc on peut mettre par exemple "bold".
```css
	p.modif-p
	{
		font:italic small-caps bold ...
	}
```
Après elle va prendre la taille par exemple 20px.
```css
	p.modif-p
	{
		font:italic small-caps bold 20px ...
	}
```
Après elle va prendre la hauteur de ligne donc 20px.
```css
	p.modif-p
	{
		font:italic small-caps bold 20px 20px ...
	}
```
Et ensuite elle prend la police de caractère donc par exemple je vais mettre "Calibri".
```css
	p.modif-p
	{
		font:italic small-caps bold 20px 20px Calibri;
	}
```
Voyez ça prend tous les éléments comme ça à la suite que l'on sépare avec des espaces et tous ces éléments que j'ai donné sont dans l'ordre.

D'ailleurs si vous avez un éditeur assez récent, voyez qu'en passant dessus il vous met en fait dans l'ordre les éléments à prendre en compte donc ça peut vous donner une petite aide si vous ne souvenez plus de l'ordre.

Voilà donc après personnellement moi je l'utilise pas parce que c'est pas forcément lisible surtout qu'on n'utilise pas forcément tout et ça veut dire qu'à chaque fois il va faloir appliquer toutes ces propriétés donc je vous recommande d'utiliser les sous-propriétés, 'font-variant', 'font-variant' et cetera en fonction de ce que vous voulez modifier ça rend les choses plus lisible facilement modifiable parce que là on peut vite oublier en fait à quoi correspond chaque chose et voilà dans quel ordre elles doivent être parce qu'ils en a beaucoup donc c'est mieux d'avoir chaque élément, chaque propriété une à une et mettre la valeur correspondante c'est plus facile à modifier et au moins on sait ce qu'on modifie exactement c'est beaucoup plus lisible je trouve.

Moi personnellement je n'utilise jamais 'font' comme ça tout seul donc les meta propriété à part comme on verra plus tard pour les fonds notamment 'background' que j'utilise effectivement sinon les autres c'est vrai que en général je m'en sers pas parce que je trouve que ça en les choses beaucoup plus illisibles mais après sachez que ça existe que c'est possible.

Vous pouvez tout cumuler avec 'font' même si ce n'est pas forcément recommandé et je vous laisse avec ça pour cette 15ème séance, ce sera donc du coup la première vidéo vraiment où vous avez mis en pratique css encore une fois faites une page web, testez tout ça.

On n'a pas vu énormément de propriétés mais il y en a quand même suffisamment déjà pour voir.

Comme vous l'avez deviné c'est une première partie donc dans la deuxième partie on verra d'autres petites choses concernant les textes notamment par exemple comment mettre du texte avec un souligné, comment gérer tout ce qui est alignement de texte, comment gérer l'alignement verticale, la position, la direction par exemple pour les écritures arabes ce genre de choses donc on verra tout ça la prochaine fois dans la deuxième partie.

En attendant n'hésitez pas à poser des questions si nécessaire et s'il y a des choses qui n'est pas compris par rapport à ça et surtout à vous entraîner pour bien savoir concevoir vos site web et styliser votre texte.

A bientôt tout le monde.

ciao