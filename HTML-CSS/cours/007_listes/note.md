# [7. Listes](https://www.youtube.com/watch?v=zKgNS-m572U)
16-01-21

Bonjour à tous bienvenue sur votre séance 7.

Nous sommes sur html css la formation pour le web et aujourd'hui on va faire une vidéo assez courtes d'accord ça fera une petite transition avec les vidéos prochaines qui seront déjà un petit peu plus complexe pour parler des listes d'accord donc on va voir comment faire des listes sur un document html pour une page web.

Vous verrez que c'est assez simple à mettre en place, il y a quelques petites choses à savoir quand même et je voulais vous montrer tout ça dans cette vidéo.

Alors on retrouve deux types de listes d'accords en html donc pour faire vos pages web.

Une liste qui va pouvoir présenter plusieurs éléments comme ça à la suite des autres et une liste qui pourra être ordonnée.

Voilà je vais vous montrer ça et je vous montrerai également en fin de vidéo comment faire des sous liste d'accord comment imbriquer des listes dans des autres parce que c'est quelque chose qui est assez utilisé notamment dans les menus par exemple quand on fait un menu pour un site ça peut être très utile d'avoir ça, d'avoir des menus, des sous menus.

Je vais vous montrer tout cela directement au niveau du code on va commencer par la liste non ordonné celles qui n'a pas vraiment d'ordre au niveau des éléments que vous allez présenter qui va s'appeler 'ul' d'accord.

Vous allez utiliser la balise ul c'est une évidemment une balise ouvrante/fermante et à l'intérieur on va pouvoir y placer les éléments.
```html
	<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Ma page web</title>
	</head>
	<body>
		<ul>
		
		</ul>
	</body>
	</html>
```
La seule balise pour pouvoir passer chaque élément est la balise `<li>` c'est aussi simple que ça accord par exemple mettez un premier élément et un second et encore un autre.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ul>
		<li>Un premier élément</li>
		<li>Un second</li>
		<li>Et encore un autre</li>
	</ul>
</body>
</html>
```
Là je vais actualiser mon code et vous voyez que ça m'affiche cette liste de cette façon.

	* Un premier élément
	* Un second
	* Et encore un autre

Tout simplement donc ça met une espèce de puce en fait au niveau de chaque élément donc c'est ce qu'on appelle une liste à puce tout simplement.

Alors par la suite vous verrez qu'avec le css dans la mise en forme vous pourrez les enlevez, vous pourrez les changer, vous pourrez même appliquer vos propres puces les faire vous même par exemple avec une petite image c'est quelque chose qui est largement modifiable après avec le css.

En tout cas on le fait en css, on ne le fait pas en html puisque faut que ça reste quelque chose de valide et qui soit propre donc ça c'est vraiment très simple d'utilisation.

Alors il faut savoir aussi, petite option je le dis parce qu'il faut savoir que ça existe d'accord parce que ce n'est pas faux ... quand vous êtes par exemple ici vous avez un élément de liste qui précède tout de suite un autre élément de liste ou alors que c'est le dernier comme ici. En bref quand ça fait partie d'une liste comme ici, les éléments `</li>` sont facultatifs càd que vous pourriez très bien écrire les choses comme ça d'accord ça fonctionnerait aussi.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ul>
		<li>Un premier élément
		<li>Un second
		<li>Et encore un autre
	</ul>
</body>
</html>
```
ok pas de soucis au niveau de la validation d'un des pages on en parlera d'ailleurs ça passerait après moi je vous recommande encore une fois parce qu'il y a certains cas où par exemple la balise paragraphe où on peut également omettre la balise de fin.

Moi je vous recommande de les mettre tout simplement parce que ce ne sont pas des balises orpheline d'accord et que si vous prenez l'habitude de ne mettre que l'ouverture et bien dans certains moments où vous êtes obligés de fermer la balise, vous auriez oublié de le faire en pensant que c'est comme la même règle que les balises orpheline. 

Si vous êtes sûrs de ne jamais vous trompez d'accord, de ne pas vous mélanger les pinceaux dans les balises à fermer ou celles qui sont facultatives dans certaines situations, c'est pas dans toutes.

Le mieux pour être sûr que ça fonctionne tout le temps c'est toujours de fermer vos balises.

Au moins ici je sais que ce code-là ça peut être comme ceci ou présenter autrement, ce sera toujours valide parce que les balises sont fermantes alors que si je ne les ferme pas dans certains cas ça marche et dans certains cas on doit pas le faire.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ul>
		<li>Un premier élément</li>
		<li>Un second</li>
		<li>Et encore un autre</li>
	</ul>
</body>
</html>
```
Donc ça peut prêter à confusion vraiment surtout si vous n'êtes pas trop famillié avec le html pour le moment ne vous amusez pas comme ça à laisser des balises non fermé sauf si bien sûr c'est des balises orpheline mais si ce sont des balises comme ici, fermez toujours ces balises pour être sûres comme ça il n'y a pas de doute possible, vous êtes sûr de ne pas vous tromper.

Voilà donc ça c'est très simple d'accord au niveau utilisation, vous avez vu j'ai juste tout simplement présentez les éléments de cette manière et je les mets les uns à la suite des autres, ils n'ont pas d'ordres en particulier puisque ce n'est pas une question d'ordre ici et on peut du coup gérer toutes ces choses-là de cette manière.

Alors il y a certains d'attributs ça je m'adresse surtout à ceux qui ont déjà fait du html, des attributs pour la liste d'accords qui peuvent être par exemple compact d'accord donc il y avait un attribut 'compact' qui pouvais prendre un certain nombre d'éléments.
```html
	<body>
		<ul compact="">
			<li>Un premier élément</li>
			<li>Un second</li>
			<li>Et encore un autre</li>
		</ul>
	</body>
```
Il y avait un attribut également pour le type notamment qui permettait de changer ici le type des puces.
```html
	<body>
		<ul type="">
			<li>Un premier élément</li>
			<li>Un second</li>
			<li>Et encore un autre</li>
		</ul>
	</body>
```
Ces attributs bien évidemment sont obsolète en html 5 et supérieur parce que comme je vous l'ai dit si vous voulez modifier la mise en forme maintenant d'une liste, il faudra le faire avec css et on verra tout ça plus tard.

N'utilisez pas ces attributs compact et type parce qu'ils sont obsolètes d'accord, ils ne sont plus valides et ne doivent pas être utilisés depuis html5 donc ça c'est vraiment important à savoir.

Voilà pour la balise qui n'a pas d'ordre d'accord donc la balise <ul> tout simplement.

Si vous voulez une balise ordonnée d'accord il suffit tout simplement de remplacer ul par ol d'accord c'est vraiment très simple au niveau de la modification à la rigueur je fais juste ça, juste ce remplacement là et hop directement ça modifie et à l'affichage on a des numéros qui se suivent, ce qui est logique puisque on est sencé avoir un ordre d'accord.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol>
		<li>Un premier élément</li>
		<li>Un second</li>
		<li>Et encore un autre</li>
	</ol>
</body>
</html>
```
```txt
	1. Un premier élément
	2. Un second
	3. Et encore un autre
```
Ce qui est logique parce qu'on est censé avoir un ordre donc ça peut être par exemple une étape de recettes de cuisine d'accord.

Ca pourrait être simplement la première étape, je change un peu les termes ici pour voir quand même qu'on a une petite différence, deuxième étape, ... càd qu'il faut vraiment les suivre dans l'ordre.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol>
		<li>Première étape</li>
		<li>Deuxième étape</li>
		<li>Dernière étape</li>
	</ol>
</body>
</html>
```
```txt
	1. Première étape
	2. Deuxième étape
	3. Dernière étape
```
Ici il y a vraiment un ordre a respecter au niveau de la liste voilà quand vous voulez détailer des choses qui doivent être suivies une à une.

Vous allez plutôt utiliser une liste ordonnée comme celle ci.

Cette liste a quelques particularités qu'on va pouvoir utiliser, quelques petites propriétés et notamment quelques petits attributs.

Le premier qui est à savoir c'est l'attribut `reversed` donc voyez je met `<ol...` et juste le mot `reversed`. C'est pas un attribut qui prend une valeur vous mettez juste le nom de l'attribut à l'intérieur. J'actualise et regardez il m'a inversé les numéros d'accord.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol reversed>
		<li>Première étape</li>
		<li>Deuxième étape</li>
		<li>Dernière étape</li>
	</ol>
</body>
</html>
```
```txt
	3. Première étape
	2. Deuxième étape
	1. Dernière étape
```
Donc attention ça n'inverse pas les éléments c'est juste si vous voulez détailler par exemple des choses dans le désordre d'accord donc à ce moment là il faudrait que j'inverse un petit peu ici les choses donc je fasse ceci alors comme ça je ne vous apprends rien alors voilà c'est vraiment pour que la numérotation de la liste ordonné se fasse de manière décroissante ok.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol reversed>
		<li>Dernière étape</li>
		<li>Deuxième étape</li>
		<li>Première étape</li>
	</ol>
</body>
</html>
```
```html
	3. Dernière étape
	2. Deuxième étape
	1. Première étape
```
Donc ça c'est juste la numérotation qui va être décroissant, pas les éléments et c'est d'ailleurs pour ça que l'attribut se met dans ol, dans la balise `<ol>` et pas dans la balise `<li>`.

Ici vraiment ça c'est pour les étapes là alors je vais remettre comme c'était voilà.
```html
	<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Ma page web</title>
	</head>
	<body>
		<ol>
			<li>Première étape</li>
			<li>Deuxième étape</li>
			<li>Dernière étape</li>
		</ol>
	</body>
	</html>
```
Ici donc ça c'est le premier attribut à savoir, l'attribut `reversed` et vous en avez également un autre qui est l'attribut pour savoir où est-ce que vous allez démarrer.

Vous voyez que ma liste démarre à 1 mais peut-être que dans certains cas, dans certaines pages web ou certains contextes, vous aurez besoin de démarrer via un autre numéro.

Pour cela vous utilisez l'attribut `start` tout simplement et vous mettez la valeur de démarrage.

Si je veux démarrer à 10 et bien je fais 10 et là je démarre de 10, 11, 12 et cetera d'accord.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol start="10">
		<li>Première étape</li>
		<li>Deuxième étape</li>
		<li>Dernière étape</li>
	</ol>
</body>
</html>
```
```txt
	10. Première étape
	11. Deuxième étape
	12. Dernière étape
```
Vous pouvez choisir vraiment d'où vous démarrez, ça peut être absolument ce que vous voulez, voilà.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol start="97">
		<li>Première étape</li>
		<li>Deuxième étape</li>
		<li>Dernière étape</li>
	</ol>
</body>
</html>
```
```txt
	10. Première étape
	11. Deuxième étape
	12. Dernière étape
```
Voilà il me semble qu'il y a une limite, j'ai pas vérifié mais je pense qu'il y a une limite du nombre d'éléments qu'on peut avoir en fait dans une liste mais bon en fait c'est un nombre complètement astronomique, c'est plusieurs milliers fin vraiment on pourrait limite en avoir je pense autant qu'on veut.

Je crois même que la limite elle s'applique surtout pour la vidéo suivante qu'on verra c'est à dire sur les tableaux mais je ne suis même pas sûr que sur les listes, qu'il y a vraiment une limite appliqué ... eh bien si regardez.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol start="100000">
		<li>Première étape</li>
		<li>Deuxième étape</li>
		<li>Dernière étape</li>
	</ol>
</body>
</html>
```
```txt
	00000. Première étape
	00001. Deuxième étape
	00002. Dernière étape
```
Si si si voyez ici 100000 et donc on a effectivement une limite qui est vraiment très très grande donc avant que vous ayez cent mille éléments ce qu'on fait jamais.

Voilà on va dire que la limite est grande donc ça c'est un attribut en tout cas à connaître qui permet du coup de démarrer depuis une autre numérotation.

Et justement si vous voulez changer la numérotation, vous en avez également d'autres d'accord càd que vous avez vu que la numérotation est en tout simplement en chiffre, en numérique comme on connaît, 1, 2, 3, etc.

Et vous pouvez commencer également par autre chose alors je vais utiliser l'attribu type cette fois-çi donc là il y a effectivement l'attribut type dans ce genre de cas, qui est utile.
```html
	<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Ma page web</title>
	</head>
	<body>
		<ol type="">
			<li>Première étape</li>
			<li>Deuxième étape</li>
			<li>Dernière étape</li>
		</ol>
	</body>
	</html>
```
Donc utile pas pour la balise `<ul>` mais pour la balise `<ol>`, il est effectivement valide, vous pouvez l'utiliser et vous pouvez mettre simplement juste un a minuscule. Si vous faites ça voilà comment se fera la numérotation avec des lettres en minuscule d'accord alphabétiquement rangé de a à z ce genre de choses.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol type="a">
		<li>Première étape</li>
		<li>Deuxième étape</li>
		<li>Dernière étape</li>
	</ol>
</body>
</html>
```
```txt
	a. Première étape
	b. Deuxième étape
	c. Dernière étape
```
Si vous mettez en majuscules pas de surprise ça va être la même chose mais en majuscules ok.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol type="A">
		<li>Première étape</li>
		<li>Deuxième étape</li>
		<li>Dernière étape</li>
	</ol>
</body>
</html>
```
```txt
	A. Première étape
	B. Deuxième étape
	C. Dernière étape
```
Si vous mettez rien du tout, c'est par défaut et quand c'est par défaut c'est des nombres décimaux donc ça il n'y a pas de surprise ok je pense que là il n'y a pas de souci ça reviendrait à mettre ça si vous ne mettez 1 d'accord ok.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol type="1">
		<li>Première étape</li>
		<li>Deuxième étape</li>
		<li>Dernière étape</li>
	</ol>
</body>
</html>
```
```html
	1. Première étape
	2. Deuxième étape
	3. Dernière étape
```
Si vous mettez `start="1"`, ce serait exactement pareil en fait donc après si vous voulez utiliser ça vous ne mettez rien du tout, ne vous embêtez pas là vous ne mettez rien du tout ça commencera de toute manière de 1.

Et si vous voulez utiliser des chiffres romains, on peut le faire, vous mettez la lettre i et ça démarre avec des chiffres romains en minuscule.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol type="i">
		<li>Première étape</li>
		<li>Deuxième étape</li>
		<li>Dernière étape</li>
	</ol>
</body>
</html>
```
```txt
	i. Première étape
	ii. Deuxième étape
	iii. Dernière étape
```
Et si vous mettez bien sûr en majuscules ça se fera aussi d'accord.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol type="I">
		<li>Première étape</li>
		<li>Deuxième étape</li>
		<li>Dernière étape</li>
	</ol>
</body>
</html>
```
```txt
	I. Première étape
	II. Deuxième étape
	III. Dernière étape
```
Je peux vous en montrer un autre pour qu'on voit le IV.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ol type="I">
		<li>Première étape</li>
		<li>Deuxième étape</li>
		<li>Dernière étape</li>
		<li>Une étape bonus</li>
	</ol>
</body>
</html>
```
```txt
	I. Première étape
	II. Deuxième étape
	III. Dernière étape
	IV. Une étape bonus
```
Voilà donc ça met bien les chiffres romains dans l'ordre donc là vous pouvez en faire pas mal aussi.

Donc ça, ça peut utile quand on écrit des articles, qu'on veux faire des chapitres dans des livres par exemple c'est très utilisé aussi ce type de numérotation.

Vous pouvez le faire avec tout simplement l'attribut type et en mettant la valeur I majusule dans encore une fois une balise ordonné.

Ok ne faites pas ça dans un `<ul>` c'est vraiment dans un `<ol>`, dans une liste ordonnée.

Voilà donc ça c'est les deux petites choses que je voulais vous montrer donc c'est pas très long d'accord comme j'avais dit c'est vraiment qu'il n'y a pas grand chose à voir dans cette vidéo au niveau des listes même si j'ai réservé une vidéo juste pour ça.

Alors il faut savoir qu'en général l'attribut `<li>` comme on le voit ici, vous voyez qu'on peut l'utiliser dans la balise `<ol>`, dans la balise `<ul>` mais on pourra également mais ça on le verra plus tard l'utiliser dans la balise `<menu>`.

On en parlera c'est une des balises qui permet de faire des structures pour nos pages web donc on en parlera un peu plus tard dans la formation donc on reviendra bien évidemment sur les listes, de toute façon on apprendra à les utiliser, on apprendra à faire un menu d'un site parce avec parce que ça sert aussi à ça.

Pas seulement pour lister des éléments donc tout ça évidemment on reviendra dessus tout au long de cette formation, dans les tutos, dans les exercices, etc, etc.

Voilà donc là j'ai fait le tour de ce que je voulais vous montrer à ce niveau là et je vais terminer du coup cette vidéo parce que je vous l'avais dit avec des sous listes d'accord comment faire des sous liste ? Parce que je sais que c'est quelque chose que beaucoup de gens veulent réaliser et qui n'est pas forcément simple au départ donc imaginons par exemple si je fais ceci.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ul>
		<li>Un élément</li>
		<li>Un deuxième élément</li>
		<li>Un dernier élément</li>
	</ul>
</body>
</html>
```
```html
	* Un élément
	* Un deuxième élément
	* Un dernier élément
```
Voilà une liste normal d'accord non ordonnés avec plusieurs éléments qui sont présentés.

Si je veux faire une sous liste admettons pour celui-là pour le deuxième élément, je veux lui mettre des sous éléments et bien vous allez déporter ici la fermeture càd que là, on peut imaginer en fait qu'ici vous avez la fermeture.
```html
	<ul>
		<li>Un élément</li>
		<li>Un deuxième élément
		</li>
		<li>Un dernier élément</li>
	</ul>
```
Si vous voulez au niveau formatage, au niveau présentation dans votre code pour ce soit plus clair pour vous, vous mettez à la ligne c'est comme vous voulez.

Le plus important c'est de bien suivre l'ordre des balises donc vous avez la balise `</li>` ici et avant de fermer ici l'élément d'accord, vous allez insérer une autre liste à l'intérieur donc vous allez refaire un nouveau `<ul>` comme ceci.
```html
	<ul>
		<li>Un élément</li>
		<li>Un deuxième élément
			<ul>
			</ul>
		</li>
		<li>Un dernier élément</li>
	</ul>
```
Donc vous pouvez utiliser les tabulations pour que ce soit plus lisible au niveau du code donc au niveau de la présentation et `<li>` d'accord.
```html
	<ul>
		<li>Un élément</li>
		<li>Un deuxième élément
			<ul>
				<li></li>
			</ul>
		</li>
		<li>Un dernier élément</li>
	</ul>
```
Un sous élément, vous pouvez mettre une balise `<ol>` d'accord évidemment vous pouvez mettre une balise `<ol>` dans une balise <ul> tout à fait possible, Etape 1, Etape 2, Etape 3 et Etape 4 voilà.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ul>
		<li>Un élément</li>
		<li>Un deuxième élément
			<ol>
				<li>Etape 1</li>
				<li>Etape 2</li>
				<li>Etape 3</li>
				<li>Etape 4</li>
			</ol>
		</li>
		<li>Un dernier élément</li>
	</ul>
</body>
</html>
```
```txt
	* Un élément
	* Un deuxième élément
	 	1. Etape 1
	 	2. Etape 2
	 	3. Etape 3
	 	4. Etape 4
	* Un dernier élément
```
Voilà comment ça se présente.

Je suis dans `<ul>`, j'ai un élément en `<li>` tout seul.

Ensuite là j'en ai un autre mais au lieu de fermer tout de suite, j'ai une autre liste à l'intérieur seulement et après je ferme cet élément là.

Ensuite le dernier d'accord donc c'est simple à faire c'est vraiment très très simple et là vous voyez qu'on a bien un sous éléments.

Ce qu'on peut faire éventuellement c'est mettre un type="".
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ul>
		<li>Un élément</li>
		<li>Un deuxième élément
			<ol type="a">
				<li>Etape 1</li>
				<li>Etape 2</li>
				<li>Etape 3</li>
				<li>Etape 4</li>
			</ol>
		</li>
		<li>Un dernier élément</li>
	</ul>
</body>
</html>
```
```txt
	* Un élément
	* Un deuxième élément
	 	a. Etape 1
	 	b. Etape 2
	 	c. Etape 3
	 	d. Etape 4
	* Un dernier élément
```
Voilà ok vous pouvez comme ça faire des sous liste donc imbriquer des listes dans d'autres listes et on pourrait encore le faire, ça n'a vraiment pas beaucoup de limites en tout cas fin il y en aura certainement une mais avec des sous liste, de sous liste, de sous liste ... mais si je voulais je pourrais très bien refaire la même chose donc là vraiment grâce aux tabulations ça permet de rendre les choses bien visible ok.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<ul>
		<li>Un élément</li>
		<li>Un deuxième élément
			<ol type="a">
				<li>Etape 1</li>
				<li>Etape 2</li>
					<ul>
						<li>bla bla</li>
						<li>bla bla</li>
						<li>bla bla</li>
					</ul>
				<li>Etape 3</li>
				<li>Etape 4</li>
			</ol>
		</li>
		<li>Un dernier élément</li>
	</ul>
</body>
</html>
```
```txt
	* Un élément
	* Un deuxième élément
	 	a. Etape 1
	 	b. Etape 2
			# bla bla
			# bla bla
			# bla bla
	 	c. Etape 3
	 	d. Etape 4
	* Un dernier élément
```
Voilà et ça change à chaque fois le type, là ça met des petits carrés, là ça mettait des cercles, des disques, etc donc ça s'est toujours bien évidemment à modifier en css etc et on verra plus tard.

Mais vous pouvez du coup imbriquer sans problème vos listes dans des listes, il n'y a pas de soucis.

Pas de souci donc éviter d'en imbriquer trop d'accord n'en faites pas non plus trop, là c'est le maximum je pense qu'on peut aller.

Après ça commence à devenir compliqué surtout si c'est pour un menu pour un site, si vous faites trop de sous menu vous allez perdre vos internautes donc évidemment éviter d'en faire trop mais il faut savoir que c'est possible et que ça fonctionne et que c'est simple à mettre en place.

D'accord c'est vraiment pas compliqué au niveau des balises à utiliser, vous mettez une balise dans une autre en fait avant de fermer l'élément c'est aussi simple que ça voilà donc c'est ça que je voulais vous montrer.

J'espère que ça vous a plu et que vous avez appris pas mal de petites choses.

Pour la prochaine séance, on verra les tableaux donc il y aura un petit peu plus de balises à voir parce qu'il je ne vais pas forcément tout vous montrer dans la vidéo donc il y aura pas mal d'éléments, peut-être des choses qui vous serviront, d'autres moins.

Mais on verra de toute façon tout ça la prochaine fois, je vous dis à bientôt et n'hésitez pas à utiliser un petit peu ces listes la.

Voir comment vraiment elles fonctionnent dans le détail et on se retrouve la prochaine fois.

A bientôt tout le monde