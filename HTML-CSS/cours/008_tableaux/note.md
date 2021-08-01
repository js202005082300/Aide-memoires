# [8. Tableaux](https://www.youtube.com/watch?v=yTp_qgvM1LU)
16-01-21

Salut tout le monde, bienvenue sur la formation html css dans cette séance numéro 8 nous allons voir les tableau.

Les tableaux c'est un concept à bien connaître quand vous faites des pages web qui est d'ailleurs et qui a été beaucoup même dans le passé utilisé à mauvais escient pour notamment faire par exemple la mise en page des sites internet qui étaient un petit peu embêtant parce que ce n'est pas fait pour ça.

Sans surprise et vous devez le savoir, un tableau ça va vraiment vous permettre de redonner d'accord d'organiser tout un tas d'informations càd que vous avez beaucoup d'informations, beaucoup de contenu que vous ne pourriez pas lister sous forme de liste tout simplement ou alors présentés dans des paragraphes d'accord dans du simple texte, vous pouvez vous servir d'un tableau d'accord.

A quoi je pense ? eh bien ça peut être par exemple des données de comptabilité, ça peut être par exemple si vous voulez faire un comparatif entre deux produits, ça peut être pour présenter plusieurs informations comme ça d'accord d'un cas à l'autre.

Vous pouvez comme ça faire des comparaisons, ça peut être utilisé dans les mathématiques, ça peut vraiment servir un peu partout en fait.

On peut avoir des tableaux dans tous types d'articles, tous types de contenus.

Je penserai par exemple à un site qui présente des jeux vidéo et d'ailleurs on va utiliser cet exemple pour la vidéo qui présenterait des jeux vidéos avec différentes point de comparaison : la date de sortie, le prix, ce genre de chose.

On pourrait tout à fait utiliser un tableau pour ça et je pense que c'est l'exemple que je prendrais d'ailleurs pour que ce soit assez clair pour tout le monde.

Alors ce qu'il faut savoir c'est qu'il y a plusieurs éléments pour les tableaux donc la vidéo sera un petit peu longue mais parce que je veux encore une fois tout voir dans une seule vidéo.

Je ne vais pas vous faire 3, 4 vidéos juste pour parler des tableaux ça n'a pas de sens.

Il y a pas mal de balises qui sont facultatifs pour lesquels vous pouvez sans problème passer outre quand vous faites des tableaux.

Il y en a évidemment qui sont obligatoire sinon vous n'aurez pas de tableau donc la première chose à savoir évidemment c'est que pour faire votre tableau, il va falloir le mettre dans les balises `<table></table>`.
```html
	<!doctype html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Ma page web</title>
	</head>
	<body>
		<table>
		
		</table>
	</body>
	</html>
```
D'accord là on a démarré un tableau alors évidemment rien dedans et on va voir ça par la suite.

Un tableau il peut avoir et ce de manière facultative d'accord ce n'est pas obligatoire il peut avoir un titre d'accord pour cela on va utiliser la balise `<caption>` comme ceci.
```php
	<!doctype html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Ma page web</title>
	</head>
	<body>
		<table>
			<caption></caption>
		</table>
	</body>
	</html>
```
Là on va mettre le titre et ça peut être par exemple "Listing de jeu vidéo".
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
	</table>
</body>
</html>
```
On va mettre des noms parlant pour l'exemple comme ça ce sera clair donc là j'actualise déjà on a ce genre de choses.
```txt
	Listing 
	de jeu 
	vidéo
```
Alors pour le moment la présentation est bizarre mais c'est pas grave.

N'oubliez pas que le html c'est vraiment le contenu d'accord, c'est le fond et pas la forme d'une page web d'accord tout ça on le verra avec css.

Donc `<caption>` est facultatif, le titre d'un tableau vous n'êtes pas obligé d'en mettre un.

Si vous en avez besoin d'en mettre un, que vous voulez le présenter vous pouvez le faire et vous utilisez ça.

Vous verrez même qu'avec CSS vous pourrez le placer au bas du tableau, en bas du tableau bref géré évidemment l'endroit, la position de ce titre.

Par défaut c'est navigateur qui va un petit peu décidé où est-ce qu'il l'affiche, en général ces en haut.

Là on a notre titre qui est affiché à ce niveau là.

Donc c'est un élément facultatif ok je le rappelle le `<caption>` est facultatif.

Je rappelle aussi dans la description de la vidéo comme pour les autres, vous pouvez retrouver le pdf d'accord qui est le mémento des petites balises html que l'on voit tout au cours des vidéos de cette formation que je vous présente rapidement après bien évidemment les explications sont dans les vidéos.

Le pdf il est juste là pour vous faire un listing dans un tableau justement de toutes ces balises pour que vous puissiez les retrouver facilement si par exemple vous avez oublié quelque chose, que vous avez un petit trou de mémoire mais tout n'est évidemment pas détaillé dans le pdf, vous avez vraiment juste un listing des balises.

Donc là on a le titre.

Ensuite on peut avoir, alors ce n'est pas obligatoire mais on peut avoir un ensemble si vous voulez d'en-têtes d'accord.

L'en-tête va être indiqués avec les balises `<thead>`.
```html
	<!doctype html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Ma page web</title>
	</head>
	<body>
		<table>
			<caption>Listing de jeu vidéo</caption>
			<thead>
			</thead>
		</table>
	</body>
	</html>
```
On va avoir ensuite pareil soit vous avez directement des informations dans un tableau, soit vous voulez utiliser par exemple utiliser une en-tête de tableau ou autre et vous allez pour cela utiliser `<tbody>` qui est le corps d'un tableau et vous auriez éventuellement pareil c'est facultatif le pied du tableau `<tfoot>`.
```html
	<!doctype html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Ma page web</title>
	</head>
	<body>
		<table>
			<caption>Listing de jeu vidéo</caption>
			<thead>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
			</tfoot>
		</table>
	</body>
	</html>
```
Voyez on a 3 éléments donc si vous voulez un tableau vraiment très complet, il y aura tout ça comme type de balise grosso modo un titre, une en-tête `<thead>`, le corps du tableau `<tbody>` et le pied du tableau `<tfoot>` d'accord ce sera présenté de cette manière là.

Vous pouvez très bien virer tout ça et directement passer au tableau, tout ça on va le revoir après d'accord on le verra au fur et à mesure donc je peux présenter les éléments de mon tableau.

Un tableau ça fonctionne par lignes et colonnes tout simplement avec des cellules comme vous pouvez trouver par exemple sur un tableur comme vous connaissez excel ce genre de choses, vous pouvez utiliser donc des cellules et c'est ce que nous allons faire.

Chaque ligne d'accord que vous allez décider de représenter va se faire avec la balise `<tr>` voilà tout simplement donc avec des `<tr>` vous allez créer une ligne.
```html
	<!doctype html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Ma page web</title>
	</head>
	<body>
		<table>
			<caption>Listing de jeu vidéo</caption>
			<tr>
			</tr>
		</table>
	</body>
	</html>
```
Donc là je choisis une ligne de tableau et à l'intérieur vous pouvez choisir le nombre de colonnes grâce à la balise `<td>` d'accord pour une colonne donc ça va être par exemple colonne 1, colonne 2, colonne 3 donc on va faire vraiment des noms comme ça au hasard après on fera des choses un peu plus correcte, de toute façon je vais prendre un peu le temps sur cette vidéo et là j'actualise voyez.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<tr>
			<td>Colonne 1</td>
			<td>Colonne 2</td>
			<td>Colonne 3</td>
		</tr>
	</table>
</body>
</html>
```
```txt
		Listing de jeu vidéo
	Colonne 1	Colonne 2	Colonne 3
```
J'actualise et là vous voyez que le titre c'est bien mis sur une ligne et là voyez que chaque élément c'est bien mis en dessous donc le titre c'est bien mis en haut et on a chaque élément ici qui sont tous sur la même ligne.

Si je veux faire une seconde ligne évidemment je recrée un autre `<tr>` à la suite et je peux remettre éventuellement ceci, (ligne 2) ce genre de choses donc n'oubliez pas vraiment d'imbriquer les choses comme ça.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<tr>
			<td>Colonne 1</td>
			<td>Colonne 2</td>
			<td>Colonne 3</td>
		</tr>
		<tr>
			<td>Colonne 1 (ligne 2)</td>
			<td>Colonne 2 (ligne 2)</td>
			<td>Colonne 3 (ligne 2)</td>
		</tr>
	</table>
</body>
</html>
```
```txt
Listing de jeu vidéo
Colonne 1			Colonne 2			Colonne 3
Colonne 1 (ligne 2)	Colonne 2 (ligne 2)	Colonne 3 (ligne 2)
```
J'actualise et la voilà ça se met bien à la suite donc chaque ligne donc là on peut voir qu'on a deux lignes d'accord parce qu'on a deux fois des `<tr>` comme ça et pour chaque ligne on a trois colonnes parce qu'évidemment faut le même nombres de colonnes même si vous verrez qu'après on peut mettre moins de colognes sur certaines lignes si on veut avec certains attributs.

Là grosso modo ça c'est la base d'accords ça c'est vraiment même en enlevant à la rigueur cet élément là si on veut vraiment un tableau minimal c'est ce genre de choses là.
```html
		<table>
			<tr>
				<td>Colonne 1</td>
				<td>Colonne 2</td>
				<td>Colonne 3</td>
			</tr>
			<tr>
				<td>Colonne 1 (ligne 2)</td>
				<td>Colonne 2 (ligne 2)</td>
				<td>Colonne 3 (ligne 2)</td>
			</tr>
		</table>
```
Au minimal, on a ce genre de chose, `<table></table>` et `<tr></tr>` pour faire des lignes `<td></td>` pour faire des colonnes ça c'est vraiment le strict minimum qu'on peut avoir dans un tableau, ok pour présenter plein d'éléments comme ça.

Après on peut comme je le disais facultativement avoir un titre donc là je vais le remettre alors pas de soucis et on peut redonner les informations plus correctement.

On peut notamment avoir des informations en tête et nous on va s'en servir là par rapport à ce que je veux faire.

Donc moi ce que je vais faire donc `<tr>`, je ne vais pas changer le première ligne puisque ma première ligne sera l'en-tête, je vais changer `<td>` par `<th>` d'accord on va changer tout ça par `<th>`.
-->
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<tr>
			<th>Colonne 1</th>
			<th>Colonne 2</th>
			<th>Colonne 3</th>
		</tr>
		<tr>
			<td>Colonne 1 (ligne 2)</td>
			<td>Colonne 2 (ligne 2)</td>
			<td>Colonne 3 (ligne 2)</td>
		</tr>
	</table>
</body>
</html>
```
```txt
Listing de jeu vidéo
Colonne 1			Colonne 2			Colonne 3
Colonne 1 (ligne 2)	Colonne 2 (ligne 2)	Colonne 3 (ligne 2)
```
Ici et là ça devient des colonnes d'en-têtes et ok donc vous voyez que au niveau visuel il vous les met en gras.

Encore une fois, ne tenez pas rigueur, n'oubliez pas que tout cela se mettra en forme avec le CSS mais là grosso modo au niveau des programmes qui irons analyser votre page, quand ils vont analyser le code de votre page ils vont voir les `<th>` donc ils seront que ce sont des en-têtes, c'est ça qui est important en fait.

Pour eux l'aspect visuel n'a évidemment aucune importance parce qui est important c'est le langage html utilisé d'accord les balises qui elles sont beaucoup plus pertinentes au niveau indexation, au niveau analyse de vos pages.

Voilà donc faut utiliser les choses correctement.

Alors là on va faire quelque chose comme j'avais un listing de jeux vidéo et bien on va dire que le premier élément c'est le nom, deuxième élément c'est le type admettons le genre de jeu et le prix.
```html
	<table>
		<caption>Listing de jeu vidéo</caption>
		<tr>
			<th>Nom</th>
			<th>Genre</th>
			<th>Prix</th>
		</tr>
		<tr>
			<td>Assassin's Creed</td>
			<td>Action-aventure</td>
			<td>69.99€</td>
		</tr>
	</table>
```
Alors les informations que je vais mettre sont  complètement fictives d'accord je ne vais pas mettre les vrais infos de vrais jeux vidéo, je mets des informations comme ça parce que je ne connais pas par coeur les prix des jeux vidéo et forcément les types mais c'est juste pour que vous ayez des exemple parlant.

Et ensuite du coup je pourrais avoir des choses avoir des informations sur Assassin's Creed donc par exemple je peux mettre un exemple complètement au hasard comme ça voilà d'accord.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<tr>
			<th>Nom</th>
			<th>Genre</th>
			<th>Prix</th>
		</tr>
		<tr>
			<td>Assassin's Creed</td>
			<td>Action-aventure</td>
			<td>69.99€</td>
		</tr>
	</table>
</body>
</html>
```
```txt
	Listing de jeu vidéo
	Nom					Genre			Prix
	Assassin's Creed	Action-aventure	69.99€
```
Voilà je peux lister plein d'éléments alors évidemment quand on fait un tableau on n'a pas qu'une seule ligne d'élément, on en a plusieurs.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<tr>
			<th>Nom</th>
			<th>Genre</th>
			<th>Prix</th>
		</tr>
		<tr>
			<td>Assassin's Creed</td>
			<td>Action-aventure</td>
			<td>69.99€</td>
		</tr>
		<tr>
			<td>Rocket League</td>
			<td>Sport</td>
			<td>24.99€</td>
		</tr>
	</table>
</body>
</html>
```
```txt
	Listing de jeu vidéo
	Nom					Genre			Prix
	Assassin's Creed	Action-aventure	69.99€
	Rocket League		Sport			24.99€
```
Voilà grosso modo enfin vous comprenez un peu le principe d'accord, on a des en-têtes et on a des éléments comme ça à présenter donc là on voit que le tableau, il se prête tout à fait à ce genre d'exercice d'accord.

C'est tout à fait logique d'utiliser un tableau pour présenter des infos comme ça sinon il aurait fallu que dans des paragraphes que je dise voilà le jeu Assassin's Creed action-aventure est à 69,99€. Voyez c'est pas forcément clair là un internaute qui va lire les infos il a tout sous les yeux c'est parfaitement compréhensible pour un être humain et pour la machine, le système qui va analyser votre page va bien comprendre aussi et pourra du coup indexé, vous référencer proprement puisque votre contenu ici de vos pages est parfaitement cohérent et sémantiquement correct donc c'est ça qu'il faut bien retenir.

Alors là si je veux améliorer un peu les choses, `<th></th>` comme ce sont des en-têtes que je peux mettre dans la balise de tout à l'heure qu'on avait vu qui est la balise rappelez-vous `<thead>` et je met les balises `<th>` à l'intérieur donc comme ceci voilà.
```html
	<table>
		<caption>Listing de jeu vidéo</caption>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Genre</th>
				<th>Prix</th>
			</tr>
		</thead>
		...
	</table>
```
Donc je peux juste me contenter de ça d'accord et si je veux faire encore plus proprement je peux dire que le reste c'est le corps du tableau donc je mets ça dans `<tbody>`.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Genre</th>
				<th>Prix</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Assassin's Creed</td>
				<td>Action-aventure</td>
				<td>69.99€</td>
			</tr>
			<tr>
				<td>Rocket League</td>
				<td>Sport</td>
				<td>24.99€</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
```
```txt
	Listing de jeu vidéo
	Nom					Genre			Prix
	Assassin's Creed	Action-aventure	69.99€
	Rocket League		Sport			24.99€
```
Donc là on complète un petit peu avec des choses un peu plus compléte tout simplement voilà comme ça on différencie encore un peu plus, ça ne changera rien c'est juste au niveau sémantique que ça va être un petit peu plus étoffé.

Là on voit vraiment que tout ça c'est la partie en-tête.
```html
		<thead>
			<tr>
				<th>Nom</th>
				<th>Genre</th>
				<th>Prix</th>
			</tr>
		</thead>
		...
```
Et tout ça c'est le corps du tableau d'accord comme ça on différencie parfaitement les deux.
```html
		...
		<tbody>
			<tr>
				<td>Assassin's Creed</td>
				<td>Action-aventure</td>
				<td>69.99€</td>
			</tr>
			<tr>
				<td>Rocket League</td>
				<td>Sport</td>
				<td>24.99€</td>
			</tr>
		</tbody>
```
Donc ça c'est des petites choses à savoir qu'ils sont utiles après on peut avoir un pied de tableau, c'est très rarement utilisé honnêtement moi je crois que je l'utilise jamais dans mes pages web. J'ai jamais vraiment besoin d'utiliser le `<tfoot>` pour faire un pied de tableau mais ça peut servir si vous avez besoin par exemple de préciser des informations.

D'ailleurs vous pouvez très bien dans `<tfoot>`, mettre exactement la même chose que ça, `<thead>`.
```html
			<tr>
				<th>Nom</th>
				<th>Genre</th>
				<th>Prix</th>
			</tr>
```
Alors c'est bizarre parce que dernière du coup je vais utiliser des `<th>` on peut garder <th> à la rigueur c'est pas un souci voilà je pourrais très bien faire ceci pour pouvoir lire de haut en bas et de bas en haut.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Genre</th>
				<th>Prix</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Assassin's Creed</td>
				<td>Action-aventure</td>
				<td>69.99€</td>
			</tr>
			<tr>
				<td>Rocket League</td>
				<td>Sport</td>
				<td>24.99€</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<th>Nom</th>
				<th>Genre</th>
				<th>Prix</th>
			</tr>
		</tfoot>
	</table>
</body>
</html>
```
```txt
	Listing de jeu vidéo
	Nom					Genre			Prix
	Assassin's Creed	Action-aventure	69.99€
	Rocket League		Sport			24.99€
	Nom					Genre			Prix
```
Pour pouvoir lire de haut en bas et de bas en haut même si bon ça pas forcément d'intérêt mais sachez que vous pourriez faire ce genre de choses ou ajouter des informations supplémentaires.

Moi je ne le mets pas parce que c'est quand même assez rarement utilisé.

Le but c'est de montrer ce qui est le plus utilisé en html quand on fait des tableaux.

Grosso modo je résume, on a notre titre, on a toute la partie en tête d'accord voyez c'est toute une structure à elle toute seule et une partie qui est le corps du tableau avec les informations que l'on voulait.

Vous pouvez sans problème faire un tableau à double entrée.

Double entrée ça veut dire en fait à double en tête càd que là vous voyez que j'ai utilisée par exemple le nom du jeu est au même niveau que le genre et le prix mais je pourrais très bien dire en fait que le nom c'est également une entrée en fait du tableau.

Dans ce cas je vais virer ça 'Nom' donc imaginez une case vide donc je met un petit slash pour dire voilà c'est une case vide et ça je vais le transformer en `<th>`. Vous allez voir du coup la modification est assez rapide, il suffit de faire comme ça.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<thead>
			<tr>
				<th>/</th>
				<th>Genre</th>
				<th>Prix</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>Assassin's Creed</th>
				<td>Action-aventure</td>
				<td>69.99€</td>
			</tr>
			<tr>
				<th>Rocket League</th>
				<td>Sport</td>
				<td>24.99€</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
```
```txt
	Listing de jeu vidéo
	/					Genre			Prix
	Assassin's Creed	Action-aventure	69.99€
	Rocket League		Sport			24.99€
```
Et là hop tout simplement, voyez vous mettez qu'un seul `<th>`, le tout premier et ensuite les autres colonnes ça reste normal, elles restent normales, et là voilà on différencie bien du coup les entrées donc c'est un tableau à double entrée en fait.

On voit par exemple que pour assassin's creed, son genre c'est Action-aventure, son prix c'est 69.99. Puis pour Rocket League, son genre c'est Sport et son Prix etc.

Vous pouvez avoir plusieurs informations comme ça qui sont rangés dans votre tableau, c'est des choses qui sont tout à fait possibles.

Ok maintenant si je peux présenter une autre information alors admettons que le prix des jeux soit le même d'accord, je dit tiens finalement les deux jeux là ont le même prix hé bien je n'ai pas forcément besoin de le répéter plusieurs fois, je peux très bien mettre le même prix pour les deux.

Je peux pour cela spécifier qu'une cellule fait plusieurs lignes ou plusieurs colonnes ok donc on a un attribut pour ça.

Si vous voulez qu'une cellule fasse plusieurs lignes, vous allez utiliser l'attribut 'rowspan' pcq  par exemple je veux que le prix de 24,99 ce soit le même pour les deux jeux donc je vais dire que le prix en fait ne ce met pas que sur une ligne mais il va se mettre sur les deux d'accord donc ici je vais changer et je vais mettre 24,99. Je fait `<td>` et je fait `<rowspan>` d'accord ça c'est pour les lignes et je vais mettre 2 d'accord voilà.
```html
		<tbody>
			<tr>
				<th>Assassin's Creed</th>
				<td>Action-aventure</td>
>				<td rowspan="2">24.99€</td>
			</tr>
			<tr>
				<th>Rocket League</th>
				<td>Sport</td>
			</tr>
		</tbody>
```
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<thead>
			<tr>
				<th>/</th>
				<th>Genre</th>
				<th>Prix</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>Assassin's Creed</th>
				<td>Action-aventure</td>
				<td rowspan="2">24.99€</td>
			</tr>
			<tr>
				<th>Rocket League</th>
				<td>Sport</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
```
```txt
	Listing de jeu vidéo
	/					Genre			Prix
	Assassin's Creed	Action-aventure	24.99€
	Rocket League		Sport			
```
Là vous ne voyez pas les traits en fait qui permettent de bien distinguer le tableau parce que certains navigateurs par défaut ne les mettent pas alors peut-être que vous utilisez un autre navigateur et que vous, il vous affiche le contour du tableau mais moi ici sur chrome il ne le fait pas et je ne vais pas vous le montrer parce que c'est du css et qu'on l'a pas encore vu dans la formation donc imaginez simplement comme des cellules, comme un tableur, vous avez ici donc une case qui a tout ce prix-là et qui du coup est intégré dans les cases ici aussi bien pour les deux jeux, vous avez du coup le même prix. Il suffit du coup d'utiliser l'attribut rowspan pour faire ce genre de choses ok.

Si je veux faire l'inverse c'est à dire faire une colonne qui a plus d'un seul espace d'accord je vais utiliser 'colspan', admettons ici au lieu d'avoir Genre et Prix, je pourrais avoir Infos.
```html
		<thead>
			<tr>
				<th>/</th>
				<th>Infos</th>
			</tr>
		</thead>
```
Ici on vois dans tous les cas qu'on a 3 colonnes dans le tableau donc là ça ne va pas aller. Si je n'ai que deux colonnes regardez ce qu'il va se passer.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<thead>
			<tr>
				<th>/</th>
				<th>Infos</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>Assassin's Creed</th>
				<td>Action-aventure</td>
				<td>24.99€</td>
			</tr>
			<tr>
				<th>Rocket League</th>
				<td>Sport</td>
				<td>24.99€</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
```
```txt
Listing de jeu vidéo
	/					Infos
Assassin's Creed	Action-aventure	24.99€
Rocket League		Sport			24.99€
```
Ca donne des choses bizarres donc là vous avez l'impression que c'est correct au niveau du tableau. 

Alors ce que je fait ici n'est pas propre et surtout que le csss on va éviter de mettre directement dans les pages html mais je vous montre ici parce qu'il faut que je fasse les choses rapidement pour vous compreniez.
```html
	<style>
		table{border-collapse:collapse;}
		th,td{border:1px solid #000;padding:5px;}
	</style>
```
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
	<style>
		table {border-collapse:collapse;}
		th,td {border:1px solid #000;padding:5px;}
	</style>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<thead>
			<tr>
				<th>/</th>
				<th>Infos</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>Assassin's Creed</th>
				<td>Action-aventure</td>
				<td>24.99€</td>
			</tr>
			<tr>
				<th>Rocket League</th>
				<td>Sport</td>
				<td>24.99€</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
```
```txt
Listing de jeu vidéo
+-------------------+-------------------+
| 	/				|	Infos			|
+-------------------+-------------------+-----------+
| Assassin's Creed	|	Action-aventure	|	24.99€	|
+-------------------+-------------------+-----------+
| Rocket League		|	Sport			|	24.99€	|
+-------------------+-------------------+-----------+
```
Ok donc là c'est beaucoup plus clair d'accord vous arriverez mieux à distinguer donc ça ne faites pas attention à ce code `<style>` ok on s'en fiche de cette partie là.

Et il ne faut certainnement pas reproduire ça parce que là je le fais comme ça mais on apprendra à faire les choses proprement plus tard dans CSS.

Voyez le problème c'est que info comme vous le voyez ici est associé à la 2e colonne alors moi je voulais qu'infos soit associé à l'ensemble donc c'est un peu embêtant.

Du coup il suffit juste de dire que le `<th>` ici d'accord il prend une taille précise de nombre de colonnes donc c'est pas 'rowspan mais c'est 'colspan' et là voyez qu'il en prend 2.
```html
		<thead>
			<tr>
				<th>/</th>
				<th colspan="2">Infos</th>
			</tr>
		</thead>
```
Et quand j'actualise l'information ici est bien mise comme il faut voilà.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
	<style>
		table {border-collapse:collapse;}
		th,td {border:1px solid #000;padding:5px;}
	</style>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<thead>
			<tr>
				<th>/</th>
				<th colspan="2">Infos</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>Assassin's Creed</th>
				<td>Action-aventure</td>
				<td>24.99€</td>
			</tr>
			<tr>
				<th>Rocket League</th>
				<td>Sport</td>
				<td>24.99€</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
```
```txt
Listing de jeu vidéo
+-------------------+-------------------------------+
| 	/				|				Infos			|
+-------------------+-------------------+-----------+
| Assassin's Creed	|	Action-aventure	|	24.99€	|
+-------------------+-------------------+-----------+
| Rocket League		|	Sport			|	24.99€	|
+-------------------+-------------------+-----------+
```
Voilà comme ça vous pouvez faire des cellules avec des tailles différentes suivant le nom que vous avez.

Essayez de garder la forme qu'il faut au niveau de tableau surtout au niveau informations pour que ce soit clair comme ça là on voit que les infos concernent aussi bien Genre que Prix. 

Ca c'est des petites choses à savoir, je vais essayer de ne pas oublier pcq il y a beaucoup de choses à savoir donc j'essaie de faire un petit peu le tour de toutes les choses qui sont intéressantes à voir.

On a également vu quelque chose qui servira surtout à css, j'en parle très rapidement d'accord c'est un autre type de balises mais qui servira surtout quand on va vouloir appliquer un style aux éléments de notre tableau donc je vais refaire quelque chose de simple.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
	<style>
		table {border-collapse:collapse;}
		th,td {border:1px solid #000;padding:5px;}
	</style>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Genre</th>
				<th>Prix</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Assassin's Creed</td>
				<td>Action-aventure</td>
				<td>24.99€</td>
			</tr>
			<tr>
				<td>Rocket League</td>
				<td>Sport</td>
				<td>24.99€</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
```
```txt
				Listing de jeu vidéo
+-------------------+-------------------+-----------+
| 	Nom				|		Genre		|	Prix	|
+-------------------+-------------------+-----------+
| Assassin's Creed	|	Action-aventure	|	24.99€	|
+-------------------+-------------------+-----------+
| Rocket League		|	Sport			|	24.99€	|
+-------------------+-------------------+-----------+
```
Voilà ce genre de chose ok donc on revient à un tableau tout à fait standard que du coup vous comprenez mieux avec le listing que j'ai fait là donc au niveau des bordures tout ça donc ça encore une fois on le ferra en css, on le ferra proprement et pas directement dans l'html même si on se sert de CSS comme je le fais au début.

Et là on va pouvoir donc avoir certaines infos qui vont s'ajouter donc notamment ici par exemple on va utiliser la balise `<colgroup>` voilà ce genre de choses et on va y mettre un certain nombre d'éléments.
```html
	<table>
		<caption></caption>
		<colgroup>
>		
		</colgroup>
		<thead>
		</thead>
		<tbody>
		</tbody>
	</table>
```
Voyez que la grosso modo j'ai 3 colonnes c'est à dire qu'on va pouvoir interagir sur 3 colonnes alors ce que je peux faire par exemple sur la première colonne c'est de faire ce genre de choses mais là ça va être beaucoup du CSS donc je vais vraiment passé très vite dessus et on y reviendra de toute manière en faisant ceci class en mettant par exemple "styleColonne1", etc.
```html
	<table>
		<caption></caption>
		<colgroup>
>			<col class="styleColonne1">
>			<col class="styleColonnes2Et3" span="2">
		</colgroup>
		<thead>
		</thead>
		<tbody>
		</tbody>
	</table>
```
Alors ce genre de chose signifie que je vais définir un attribut donc un nom de class ici pour la première colonne càd qu'on a 3 colonnes dans le tableau et que `<col class="styleColonne1">` va s'appliquer à la 1ere colonne.
```txt
	+-------------------+
	| 	Nom				|
	+-------------------+
	| Assassin's Creed	|
	+-------------------+
	| Rocket League		|
	+-------------------+
```
Donc ça plus tard en CSS ça veut dire qu'on pourra appliquer une mise en forme spéciale pour toute cette colonne là donc ça peut être une couleur de fond, un changement de la police, tout mettre en gras, ce genre de chose par exemple.

Imaginez que toute cette colonne là on peut appliquer le même style css donc la mise en forme et qu'on verra ça plus tard.

Et ici `<col class="styleColonnes2Et3" span="2">` je crée une autre classe donc je mets un nom "styleColonnes2Et2" mais je met absolument le nom que je veux mais on verra ça plus tard et grâce au mot `span="2"` et ben je lui dis que ça du coup c'est appliqué sur deux colonnes à la suite donc comme on c'est déjà occupé de la première et bien on le fait du coup sur les deux qui restent donc Genre et Prix.
```txt
						+-------------------+-----------+
						|		Genre		|	Prix	|
						+-------------------+-----------+
						|	Action-aventure	|	24.99€	|
						+-------------------+-----------+
						|	Sport			|	24.99€	|
						+-------------------+-----------+
```
Donc ic on pourra appliquer un style CSS grâce à cette classe sur deux autres colonnes donc comme il y en a que 3 c'est ça.

S'il y avait une quatrième colonne donc je vais mettre un truc au pif, on change pas les prix évidemment c'est juste pour l'exemple vite fait.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
	<style>
		table{border-collapse:collapse;}
		th,td{border:1px solid #000;padding:5px;}
	</style>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<colgroup>
			<col class="styleColonne1">
			<col class="styleColonnes2Et3" span="2">
		</colgroup>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Genre</th>
				<th>Prix HT</th>
				<th>Prix TTC</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Assassin's Creed</td>
				<td>Action-aventure</td>
				<td>24.99€</td>
				<td>24.99€</td>
			</tr>
			<tr>
				<td>Rocket League</td>
				<td>Sport</td>
				<td>24.99€</td>
				<td>24.99€</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
```
```txt
						Listing de jeu vidéo
+-------------------+-------------------+-----------+-----------+
| 	Nom				|		Genre		| Prix HT	| Prix TTC	|
+-------------------+-------------------+-----------+-----------+
| Assassin's Creed	| Action-aventure	| 24.99€	| 24.99€	|
+-------------------+-------------------+-----------+-----------+
| Rocket League		| Sport				| 24.99€	| 24.99€	|
+-------------------+-------------------+-----------+-----------+
```
Voilà par exemple ce genre de choses comment ça ce serait appliqué ? eh bien ça `<col class="styleColonne1">` ça va s'appliquer pour la première colonne.
```txt
	+-------------------+
	| 	Nom				|
	+-------------------+
	| Assassin's Creed	|
	+-------------------+
	| Rocket League		|
	+-------------------+
```
Et ça `<col class="styleColonnes2Et3" span="2">` ça va s'appliquer pour la colonne 2 et 3 donc ici il n'y aurait rien d'appliquer pour la dernière d'accord c'est vraiment en fonction donc le span ici ça prend en compte.

Si je fais que ça.
```html
		<colgroup>
			<col class="styleColonne1">
		</colgroup>
```
ca va juste appliquer une classe sur la première colonne et celles-là ne seront pas modifiées du tout.
```txt
						+-------------------+-----------+-----------+
						|		Genre		| Prix HT	| Prix TTC	|
						+-------------------+-----------+-----------+
						| Action-aventure	| 24.99€	| 24.99€	|
						+-------------------+-----------+-----------+
						| Sport				| 24.99€	| 24.99€	|
						+-------------------+-----------+-----------+
```
On va pas rien appliqué du tout ok donc il faut vraiment le lire dans cette ordre-là, si je veux faire un style, une mise en forme différente pour chaque colonne et donc si mon tableau a quatre colonnes je dois créer quatre balises `<col>` de cette manière d'accord avec 4 noms de classe différents si je veux mettre un style différent.
```html
		<colgroup>
			<col class="styleColonne1">
			<col class="styleColonne2">
			<col class="styleColonne3">
			<col class="styleColonne4">
		</colgroup>
```
S'il y a dix colonnes il faudrait que je fasse dix fois ça ou alors en tout cas pour appliquer un style différent.

Si je veux un style différent sur les 10 colonnes, il faudrait éffectivement 10 balises `<col class="">` avec un nom de classe unique pour chacune voilà donc ça je passe très vite là dessus, on le verra surtout avec le CSS parce que ici ça n'a vraiment aucun intérêt de l'utiliser mais je voulais juste que vous sachiez parce que ça fait partie des tableaux donc ça reste du html ce n'est pas du CSS au niveau des balises donc ça on le verra plus tard.

Alors on a fait le tour des titres, on parlé des différentes balises d'en-tête `<thead>`, de corps `<tbody>`, de pied de tableau `<tfoot>`, on a fait le tour un petit peu de tout ça.

Alors je peux vous dire aussi qu'il y a évidemment certains attributs qui sont obsolètes mais après si je vous les présente pas dans la vidéo c'est qu'après il ne faut pas les utiliser.

Je pense aux attributs comme align, bgcolor, charoff et il y a valign qui permet de gérer l'alignement d'un tableau, l'alignement vertical ou la couleur de fond c'est évidemment des choses qui font partie de la mise en forme et qu'on fera en css ne faites pas ça en css, ne faites pas ça en HTML, vous pourriez trouver peut-être des vieux tuto ou des vieux livres avec marqué par exemple du truc comme ça, `bgcolor=""` avec un code héxadécimale qui change la couleur de fond du tableau, ce n'est pas valide en html maintenant.
```html
	<table bgcolor="">
		<caption></caption>
		<colgroup></colgroup>
		<thead></thead>
		<tbody></tbody>
	</table>
```
Surtout ne le faites pas, vous modifierez en css d'accord en html vous restez vraiment sur le contenu, sur le fond.

La forme ça se fera, je sais que je dis souvent en css parce que c'est comme ça que c'est valide donc vraiment ici n'utilisez pas ce genre d'attributs.

Petit point particulier à savoir sur les titres d'accord sur `<caption>` par exemple on utilise cette balise là par contre dans certains cas il faudra utiliser une autre balise mais on en parlera quand on fera la vidéo sur ce qui concerne les médias, je pense aux images, aux vidéos, aux musiques en html.

Vous verrez que dans certains cas, il ne faut pas utiliser cette balise là si votre tableau est présenté dans un autre type de balise mais là comme nous comme on l'a mit directement dans la page comme ça on peut utiliser `<caption>` sans problème, il n'y a pas de souci d'accord c'est un cas particulier mais on en parlera beaucoup plus tard.

Voilà je vous ai tout dit au niveau des colonnes, `<colgroup>`, etc, je suis passé assez vite dessus puisque encore une fois ça surtout son intérêt avec le css.

Qu'est ce que je peux vous dire d'autre également ? alors oui pour les en-têtes comme ça `<th></th>` vous pouvez faire des abréviations aussi ça c'est important à savoir, par exemple vous pouvez définir des abréviations sur des noms ici assez développée et je peux très bien les abréger avec un attribut qui est 'abbr' et mettre ce genre de chose.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
	<style>
		table {border-collapse:collapse;}
		th,td {border:1px solid #000;padding:5px;}
	</style>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<thead>
			<tr>
				<th abbr="nom">Nom du jeu</th>
				<th abbr="genre">Genre et type</th>
				<th abbr="prix">Prix de vente</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Assassin's Creed</td>
				<td>Action-aventure</td>
				<td>24.99€</td>
			</tr>
			<tr>
				<td>Rocket League</td>
				<td>Sport</td>
				<td>24.99€</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
```
```txt
				Listing de jeu vidéo
+-------------------+-------------------+---------------+
| 	Nom	du jeu		|	Genre et type	| Prix de vente	|
+-------------------+-------------------+---------------+
| Assassin's Creed	|	Action-aventure	|	24.99€		|
+-------------------+-------------------+---------------+
| Rocket League		|	Sport			|	24.99€		|
+-------------------+-------------------+---------------+
```
C'est bien à savoir, ça peut être utile dans certains cas d'accord.

Toujours au niveau de ce qui va analyser votre page d'accord vous aurez des abréviations.

Sachez que c'est possible à utiliser et que c'est parfaitement valide donc ça peut avoir son utilité à ce niveau là surtout quand vous avez par exemple des navigateurs qui sont juste textuel càd qui ne présente pas les informations de manière moderne comme le ferais chrome, firefox, safari, opera, etc.

Voilà donc du coup donc ça c'est à savoir, l'abréviation parce que je ne voulais pas que vous l'oubliez je voulais vraiment vous en parler.

Il n'y a pas pas de grand chose après on a vraiment fait le tour de ce qui était très très important.

Vous avez certaines choses également qui vont vous permettre de ranger les éléments par exemple des fois de modifier les ordres ou autre mais pas forcément en html, on fait beaucoup après avec un langage de programmation je pense notamment à javascript qui va permettre par exemple en fait de définir des identifiants sur votre tableau et de travailler dessus, par exemple de dire bah tiens à partir des identifiants tu peux faire un tri de mon tableau et cetera de manière dynamique donc ça c'est des choses qu'on verra surtout avec les langages de programmation de manière dynamique.

Nous ici on reste sur du statique puis c'est comme ça qui est conçu de tenir le html.

Ce qui peut servir et ça c'est un petit peu une transition, ce qui servira également pour quand vous ferez plus tard du javascript avec même du php dans certains cas, c'est définir des identifiants par exemple pour vos champs ici d'accord si par exemple si je mets un identifiant donc c'est un attribut d'accord genre "monJeu", "genreJeu" et "prixJeu" d'accord un identifiant.
```html
		<thead>
			<tr>
				<th id="monJeu">Nom du jeu</th>
				<th id="genreJeu">Genre et type</th>
				<th id="prixJeu">Prix de vente</th>
			</tr>
		</thead>
```
Vous pouvez également dire dans vos cellules donc ça n'a aucune utilité visuellement mais plus tard vous verrez qu'avec un langage de programmation ça aura son utilité, vous pouvez dans les balises `<td></td>` définir à quel en-tête correspond l'information, assassin's creed par exemple ici correspond à l'en-tête nom du jeu donc "nomJeu" et donc vous reprenez le même nom sauf que l'attribut s'est pas id mais c'est headers avec un s attention ne vous tromper pas puis vous mettez ceci.
```html
	<table>
		<caption>Listing de jeu vidéo</caption>
		<thead>
			<tr>
				<th id="monJeu">Nom du jeu</th>
				<th id="genreJeu">Genre et type</th>
				<th id="prixJeu">Prix de vente</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td headers="monJeu">Assassin's Creed</td>
				<td headers="genreJeu">Action-aventure</td>
				<td headers="prixJeu">24.99€</td>
			</tr>
			<tr>
				<td headers="monJeu">Rocket League</td>
				<td headers="genreJeu">Sport</td>
				<td headers="prixJeu">24.99€</td>
			</tr>
		</tbody>
	</table>
```
Et du coup on retrouve les identifiants avec chaque en-tête a un identifiant et chaque cellule ici est liée à un identifiant donc encore une fois au niveau html pure ça n'a aucun intérêt, je vous le dis clairement pas comtre plus tard quand vous ferez de la programmation avec javascript, que vous ferait un peu de php tout ça ça aura un intérêt parce que vous verrez que vous pourrez sélectionner des cellules suivant l'identifiant auxquels elles sont liées et faire des modifications. C'est vraiment de la programmation donc vous pourrez faire des choses beaucoup plus poussés et là ça aurait un intérêt d'utiliser des identifiants de cellules ou ce genre de choses donc je voulais vous montrer parce qu'il faut le savoir, fait savoir que ce sont des attributs tout à fait utiliser donc n'hésitez pas.
```html
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ma page web</title>
	<style>
		table {border-collapse:collapse;}
		th,td {border:1px solid #000;padding:5px;}
	</style>
</head>
<body>
	<table>
		<caption>Listing de jeu vidéo</caption>
		<thead>
			<tr>
				<th id="monJeu">Nom du jeu</th>
				<th id="genreJeu">Genre et type</th>
				<th id="prixJeu">Prix de vente</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td headers="monJeu">Assassin's Creed</td>
				<td headers="genreJeu">Action-aventure</td>
				<td headers="prixJeu">24.99€</td>
			</tr>
			<tr>
				<td headers="monJeu">Rocket League</td>
				<td headers="genreJeu">Sport</td>
				<td headers="prixJeu">24.99€</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
```
```txt
				Listing de jeu vidéo
+-------------------+-------------------+---------------+
| 	Nom	du jeu		|	Genre et type	| Prix de vente	|
+-------------------+-------------------+---------------+
| Assassin's Creed	|	Action-aventure	|	24.99€		|
+-------------------+-------------------+---------------+
| Rocket League		|	Sport			|	24.99€		|
+-------------------+-------------------+---------------+
```
L'attribut id alors tout dépend de quand est ce que vous regardez cette séance là mais j'ai fait un tutoriel sur tout ce qui est balises, attributs universels.

Les attributs universels j'en ai déjà parlé dans une vidéo précédente, c'est des attributs que vous pouvez utiliser sur toutes les balises html qui existent d'accord il y a notamment l'attribut 'title' dont je vous avais parlé et pas mal d'autres qui sont utilisables par tout.

L'attribut 'class' qu'on a vu tout à l'heure dans la balise `<col>`, pareil c'est un attribut universel donc id, class ce sont des attributs compatibles sur toutes les balises html donc il y a un tuto sur ces attributs donc n'hésitez pas a allez le voir s'il est déjà disponible en ligne pour apprendre aussi ça en plus, ça vous fera un petit complément à cette formation donc dans la playlist des tutoriels de html-css bien évidemment.

Voilà et j'ai fait le tour de tout ce que je voulais vous parler, je pense que c'est suffisamment bon déjà et si après j'ai oublié des petites choses c'est pas grave.

Plus tard quand on avancera avec css, on pourra revenir sur les tableaux bien évidemment pour faire des choses un peu plus propre donc ne je m'inquiète pas pour ça là j'ai dit vous ai dit tout ce qui était vraiment important il faut savoir voilà que les attributs encore une fois comme bgcolor, align et cetera pour centrer un tableau ce genre de choses ne sont pas des attributs valide, ils sont obsolètes donc ne les utiliser plus. Servez vous de ce que je vous ai montré dans la vidéo et encore une fois n'oubliez pas que certaines balises sont facultatives `<tbody>`, `<thead>`, `<caption>` ... si vraiment vous n'avez pas l'utilité, vous n'êtes pas obligé de vous en servir.

Vous pouvez juste utilisé `<tr><td>` et `<tr><th>` ça fonctionnera aussi sans problème tant que tout bien évidemment est présent dans la balise `<table>` il n'y aura pas de souci.

Je vous laisse avec ça je vous dis à très bientôt pour la prochaine vidéo ce sera du coup si je me trompe pas la séance 9.

On attaquera d'autres petites choses on va commencer à parler de pas mal de choses importantes et un peu plus complexe aussi au niveau de ce langage informatique.

Je vous laisse avec ça je vous dis à bientôt.

N'hésitez pas à poser des questions parce que les tableaux sont pas forcément évident à comprendre, si vous vouliez par exemple vous entraîner ici de faire des tableaux un peu complexe par exemple des tableaux ici avec comme je le dis des cellules qui sont sur plusieurs colonnes ou des cellules sur plusieurs lignes.

Essayez de faire des choses un petit peu complexes comme exercice si vous voulez après il y aura des exercices proposés ou déjà proposés sur la chaîne pour voir un petit peu tout ça en pratique mais déjà de votre côté vous pouvez déjà voir pas mal de choses sur les tableaux il y a moyen de faire pas mal de petits exercices donc je vous en donne éventuellement dans cette fin de vidéo.

Essayez de vous entraîner à faire plein de tableaux compliqués d'accord, des tableaux très court, des tableaux avec beaucoup d'informations,  des tableaux comme je vous le dis avec des cellules qui sont sur plusieurs lignes ou plusieurs colonnes, des tableaux à double entrée d'accord avec double en-têtes, voire même triple en-têtes par exemple de mettre des en tête en haut, à gauche et même sur la dernière cellule à droite. Vous pouvait faire ce genre de choses c'est très simple si vous avez bien suivi cette vidéo vous aurez tout compris et vous saurez le faire sans problème donc je m'inquiète pas pour ça et si bien évidemment vous avez des questions n'hésitez pas à les poser sur cette vidéo, à réagir, commenter, partager comme d'habitude, ça me fera toujours plaisir et ça va vraiment m'aider au niveau de mon travail et moi je vous dis à la prochaine pour la séance neuf sur cette formation html-css