# [Variables](https://www.youtube.com/watch?v=XFYqxcChwO4)
17-02-21

On aborde des variables et plus exactement des propriétés personnalisées et pas des variables comme on le vois dans les langages de programmation mais réellement des propriétés sur lequel on va pouvoir appliquer une valeur et réutiliser au sein de nos feuille de style.

Par défaut on est quand même amenés à réutiliser des valeurs communes sur plusieurs propriétés au sein d'une feuille de style.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>MonIncroyableSiteWeb</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<h1>Variables CSS (propriétés personnalisées)</h1>

	<p>Lorem ipsum dolor sit amet, <a href="#">consectetur adipisicing elit</a>. Sed, blanditiis, distinctio, dicta iusto cum possimus ut id nulla quo facere dolores magnam ullam nihil veritatis impedit mollitia saepe. Nobis, voluptates.</p>
</body>
</html>
```

```css
body
{
	background-color:#EEE
	margin:auto;
	width:1200px;
}

h1, a
{
	color:#da5c5c;
}
```
Pour optimiser, on vient à rassembler les sélecteurs mais on serra amenner à avoir des répétitions de valeurs, ce n'est pas forcément le cas de la propriété c'est surtout le fait qu'on est des valeurs qui se répète ce qui n'est pas forcément pratique.

En plus de ça quand on travaille par exemple sur des couleurs, on a des valeurs héxadécimales ou des valeurs RGBA() qui ne sont pas forcément significative. Moi j'aimerais pouvoir nommer #da5c5c comme un rouge particulier et pour cela on va pouvoir passer par des propriétés personnalisées qui sont en fait un peit système de variables que vous avez en css.

Certains connaissent peut être des système de pré-processing comme l'as ou sas qui permettent justement via une compilation de pouvoir utiliser des variables et pas mal d'autres fonctionnalités.

Si vous voulez ce principe de variable en CSS reprend justement une des fonctionnalité qui existe de ces système de pré-processeur c'est à dire l'utilisation de propriété personnalisés.

Vous n'aurez pas besoin de compiler quoi que ce soit au niveau du fichier mais ce serra directement utilisable dans le CSS.

Si on veut définir des variables de manière général, on peut utiliser le sélecteur :root dans le quel on définit tout un tas de variables, de propriétés personnalisées, précédée par deux tirets tout simplement et puis on lui donne un nom et on lui met une valeur #da5c5c que l'on passe dans la valeur var().

```css
:root
{
	--main-red-color:#da5sc5c;
}

body
{
	background-color:#EEE
	margin:auto;
	width:1200px;
}

h1, a
{
	color:var(--main-red-color);
}
```
Pas mal d'avantages à ça, c'est que premièrement on gagne en lisibilité comme dans les langages de programmation. On comprend que --main-red-color est notre couleur rouge principale.

En plus où cette couleur ne va plus, je peux la changer facilement et bien évidemment la valeur serra affectée partout dans le code.

C'est plus pratique et humainnement parlant beaucoup plus lisible que de voir une valeur héxadécimale qui ne veut pas dire grand chose.

Idem avec une marge par défaut.
```css
:root
{
	--main-red-color:#da5sc5c;
	--default-margin:16px;
}

body
{
	background-color:#EEE
	margin-left:var(--default-margin);
	margin-right:var(--default-margin);
	width:1200px;
}

h1, a
{
	color:var(--main-red-color);
}
```
Attention c'est vraiment pas un principe de variable comme dans un langage de programmation où on peut tout utiliser n'importe où mais là il s'agit d'une propriété personnalisée càd que ça va suivre les mêmes règles et les mêmes contraintes que ce système CSS Cascading Style Sheet qui signifie tout simplement des propriétés déscendantes donc en gros qui vont être contraintes par rapport au parents, par rapport aux propriétés enfants et cetera donc faut prendre en compte tout ça et ça rejoint un peu toutes les règles de ce vous avez vu en css notamment sur le cours.

Voilà le jour où je veux changer ça je n'ai plus qu'à changer la valeur de ma propriété personnalisée et ça va évidemment tout impacter.

Nos variables avec deux tirets dans un sélecteur :root si vous voulez entre guillemet que ce soit des propriétés globales qui peuvent être utilisées partout mais vous pouvez bien sûr les definir dans body et du coup tout ce qui hérite, qui est un enfant en fait de body pourra utiliser ces variables.
```css
:root
{

}

body
{
	--main-red-color:#da5sc5c;
	--default-margin:16px;
	background-color:#EEE
	margin-left:var(--default-margin);
	margin-right:var(--default-margin);
	width:1200px;
}

h1, a
{
	color:var(--main-red-color);
}
```
Voilà il y a bien cette histoire d'héritage ou non comme on retrouve en css.

Mais voilà si on veux quelque chose d'assez globales on le met dans :root.

On peut également prévoir une valeur par défaut si notre fichier n'arrive pas ici n'arrive pas à interprêter la valeur de cette propriété personnalisé, on peut également lui passer une valeur et si ça fonctionne pas je peux lui passer directement une valeur par défaut.
```css
:root
{
	--main-red-color:#da5sc5c;
	--default-margin:16px;
}

body
{
	background-color:#EEE
	margin-left:var(--default-margin);
	margin-right:var(--default-margin);
	width:1200px;
}

h1, a
{
	color:var(--main-red-color, #da5sc5c);
}
```
On peut très bien repasser une var() en valeur par défaut puis mettre plusieurs valeurs par défaut.
```css
:root
{
	--main-red-color:#da5sc5c;
	--default-red-color:red;
	--default-margin:16px;
}

body
{
	background-color:#EEE
	margin-left:var(--default-margin);
	margin-right:var(--default-margin);
	width:1200px;
}

h1, a
{
	color:var(--main-red-color, var(--default-red-color, blue));
}
```
Voilà il faut toujours avoir deux valeurs par var() et on peut comme ça les cumuler mais par contre jamais 3 valeurs.

Ensuite attention ces propriétés sont soumises aux mêmes règles et contraintes qu'en CSS, on ne pourra pas appliquer une couleur à un font-size ...

	!! font-size:var(--main-red-color); !!

Mais alors si un font-size qui est définit dans un élément parent c'est cette valeur qui serra appliquée par défaut à la place de cette variable incompatible pour le coup.

Et si rien n'a été défini sur un élément parent ce serra simplement la valeur initial qui serra appliquée.

Par défaut, par exemple, les paragraphe sont toujours en noir, les liens en bleu et soulignés, et cetera.

Voilà pour le système de CSS avec ce système de déscendance entre les différents éléments que nous avons.