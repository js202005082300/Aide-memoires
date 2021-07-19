# [6. Formatage technique](https://www.youtube.com/watch?v=ce2mpuSTz0E)
16-01-20

6ème séance sur HTML/CSS.

Nous allons aborder ici des balises un peu plus techniques.

Cette séance ne servira pas à la plupart d'entre nous parce que les balises que nous allons aborder sont vraiment très spéciques.

Elles ne conviennent que dans certains cas.

On verra en fonction, dans tous les cas, c'est important de les connaître également, de les apprendre, de savoir qu'elles existent pour les utiliser si besoin.

On verra ces balises avec de petits exemples pour qu'on puisse comprendre leurs utilités.

## La balise de `<code></code>`

La première balise concerne tous ceux qui font de la programmation.

Si on programme notamment et qu'on suit une formation en informatique sur la chaîne, c'est le genre de balise qui peut avoir son intérêt lorsqu'on veut présenter du code.

La balise s’appelle tout simplement code. Ce n'est pas compliqué à ce niveau-là.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<code></code>
</body>
</html>
```
On peut très bien aussi l'avoir dans un paragraphe, dire bonjour et ce genre de chose.

Entre les balises code, ça va utiliser une police d'écriture différente c'est-à-dire une police monospace qui gère la même taille peut importe le caractère.

On peut alors écrire le code que l'on veut comme du langage C.

Ensuite quand on actualise, le code va être légèrement différent.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<p>Dire bonjour : <code>printf("Hello world");</code></p>
</body>
</html>
```
```txt
	Dire bonjour : printf("Hello world");
```
On verra plus tard que CSS peut faire la mise en forme et présenter le code d'une autre manière, avec une couleur, etc.

Permet de différencier ce qui est du simple texte avec du code informatique.

C'est vraiment l'utilité de la balise code.

Elle sert vraiment à mettre en évidence un code de langage informatique ou de langage de programmation.
	
Tant qu'on reste sur du code informatique 
	
## La balise `<kbd></kbd>`

Balise très utile pour mettre en évidence des saisies au clavier.

Ça peut être utile lorsqu'on veut donner un raccourci à quelqu'un, ce genre de chose.

Un raccourci pour enregistrer un document tel qu'on l'a vu dans la formation GNU Linux.

Par exemple si on avait fait sur un tutoriel écrit, on aurait pu écrire ce genre de chose :
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<p>Enregistrer le document avec le raccourci : <kbd>ctrl + S</kbd></p>
</body>
</html>
```
```txt
	Enregistrer le document avec le raccourci : ctrl + S
```
Ainsi on aurait utilisé la balise KBD pour Keyboard tout simplement dans laquelle on met par exemple ctrl + S.

Si on actualise, ça change un peu l'écriture.

Et même chose, on pourra changer la mise-en-forme avec du CSS pour avoir un effet visuel un peu plus différent et que ce soit un peu jolie.

En tout cas ça change la police d'écriture et on peut bien préciser au niveau sémantique, que là on a vraiment une saisie utilisateur ou bien pour présenter des touches du clavier.

Ça permet de voir qu'il faut utiliser la touche ctrl + S pour enregistrer un document.

Voilà pour une balise encore très utile qui va servir aux informaticiens où aux gens qu'ils veulent expliquer les choses en informatique.

Ça ne concerne pas évidemment tout le monde.

Ainsi cette vidéo est là pour toutes les petites balises qu’ils restent à voir.

## La balise `<meter></meter>`

On a ensuite la balise `<meter></meter>` qui va permettre de représenter des valeurs numériques, des valeurs fractionnaires, ce genre de chose.

Elle est déjà un peu plus compliquée à l'utilisation parce qu'on peut utiliser pas mal d'attributs.

Si par exemple, on veut représenter une valeur en pourcentage, on met cela dans un paragraphe pour montrer que ça peut s'intégrer dans une phrase :
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<p>Valeur en pourcentage : <meter value="0.25">25%</meter></p>
</body>
</html>
```
```txt
	Valeur en pourcentage : =====-----------------
```
On peut ainsi l'écrire comme ceci, en mettant l'attribut qui vaut 25 pour cent (0.25).

Pareil, on actualise et le navigateur nous met comme une barre de progression.

Mais ici c'est vraiment pour préciser une valeur numérique, ce n'est pas pour préciser une progression de quelque chose, c'est pour donner une valeur métrique, c'est-à-dire une valeur qui peut être fractionnaire, une valeur scalaire.

Peu importe, en tout cas quelque chose qui est numérique.

On peut également y mettre autre chose comme attribut, il faut savoir que cette balise a plusieurs attributs.

On le marque ici même si on sait que dans la vidéo, on peut récupérer le PDF pour sa troisième édition avec toutes les balises qu'on vu dans les vidéos plus celle dans cette vidéo.

On peut tout retrouver tout dans le PDF mais comme il n'y a pas non plus énormément d'exemples, on peut également prendre en note dans les vidéos si ça nous intéresse.
	
## Les attributs de la balise <meter></meter>
```html
<!--
	<meter></meter> prend plusieurs attributs, elle a :
	
		value=""	, qui est la valeur.
		min=""		, qui est la valeur minimale.
		max=""		, qui est la valeur maximale.
		high=""		, seuil où la valeur devient dite "haute", où elle a une valeur haute.
		low=""		, seuil où la valeur devient "basse", quand elle est considérée comme basse.
		optimum=""	, seuil ou la valeur est optimal.
-->
```
Voilà si par exemple, on veut faire un objectif, ce genre de chose.

Encore une fois, pas forcément pour faire une barre de progression mais juste pour donner une valeur précise.
	
On pourrait faire :
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<p>Température du corps : <meter value="37" optimum="37.4">37 degrés</meter></p>
</body>
</html>
```
```txt
	Température du corps : =======================
```
On met par exemple que la valeur actuelle est la valeur 37.

Mais on pourrait dire que la valeur optimum est 37,4 si on ne dit pas de bêtises.

On pourrait mettre ensuite une valeur minimale avec l'attribut `min=""`.

`high=""` se serrait du coup là où la valeur devient haute, c'est à dire où c'est trop chaud en température et `low=""` quand c'est trop bas.

La du coup, entre ces balises `<meter></meter>`, on peut mettre la valeur "37 degré" en texte, on peut mettre ce que l'on veut entre les parenthèses.

Le but c'est de préciser quelque chose.
	
Evidement lorsqu'on actualise, on ne voit pas la valeur mais il faut savoir que c'est histoire de sémantique, tout ce qui va analyser notre page, va bien pouvoir récupérer l'information.
	
C'est vraiment un cas spécifique, si ça tombe, on n’utilisera jamais ce type de balise mais c'est bien de la connaître. Ça peut servir si on manipule des valeurs scalaires, des valeurs fractionnaires, ce genre de choses.

C'est le genre de balise qui pourrait nous intéresser, surtout qui nous serra utile.
	
Voilà pour tout ce qui est un peu numérique.	

## La balise `<output></output>`

Maintenant, on reste dans le numérique et on va revenir sur un peu de l'informatique avec la balise `<output></output>`.

On a vu tout à l'heure avec la balise `<code></code>` comment présenter du langage machine.

On a vu également pour keyboard `<kbd></kbd>`, la saisie d'un utilisateur.

Mais maintenant, on va pouvoir à l'inverse, afficher le résultat d'un calcul.

Ça peut être un calcul mathématique et on va pouvoir aussi pourquoi afficher le résultat d'une action.

Ça peut être une action d'un utilisateur, une action automatique.

On peut ainsi utiliser cette fameuse balise `<output></output>` si par exemple on avait un calcul tout bête :
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<p>2 + 4 = <output>6</output></p>
</body>
</html>
```
```txt
	2 + 4 = 6
```
Par exemple, si on avait 2+4, on peut très bien faire <output>6</output>.

C'est un peu bête comme exemple mais c'est parfaitement correct, sémantiquement parlant.
	
Cette balise permet de montrer ici qu'on a une sortie.

La balise `<output>` et la balise `<meter>` qu'on a présenté juste avant, ce sont des balises qu'on va surtout avoir l'utilité quand on va utiliser les formulaires.

Il y a ainsi une vidéo spécialement pour les formulaires dans la formation.

On ne reviendra pas sur cette balise pendant la vidéo sur les formulaires, c'est assez simple à utiliser.
	
On garde la vidéo sur les formulaires pour voir ce qu'il y a de plus important à savoir sur les formulaires mais il faut savoir que ces balises, on vraiment leur utilité surtout dans des formulaires.
	
Utiliser la balise `<output></output>` en dehors d'un formulaire, ça se fait pas très très souvent.
	
Voilà il faut savoir qu'elle existe, on s'en sert pour le résultat d'un calcul, le résultat d’une action, ce genre de chose et pourquoi le résultat d'un programme même si on verra plus loin qu'il y a quelque chose d'un peu plus propre pour cela quand on parle de programme informatique.
	
`<output></output>` et `<meter></meter>`, il faut retenir qu’on les utilise beaucoup dans les formulaires et en dehors, c'est déjà beaucoup plus rare.

## La balise `<pre></pre>`

Une autre balise qui sera beaucoup plus utilisé, on va en avoir besoin, un peu comme la balise code parce qu'elle peut s'utiliser de pair avec celle-ci.

Cette balise va permettre de produire du texte préformater.
	
Quelle est la différence entre du texte préformater et du texte qui n'en est pas ?

Pour rappel, si on fait :
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	Bonjour tout le monde.
	
	Ceci est une 		nouvelle phrase.
</body>
</html>
```
```txt
	Bonjour tout le monde. Ceci est une nouvelle phrase.
```
On écrit Bonjour tout le monde. On fait ensuite un saut de ligne et on écrit une nouvelle phrase contenant un saut de tabulation.

Si on actualise, on constate que tout est à la suite.

On l'avait expliqué au début de la formation que l'éditeur, le langage HTML ne va pas prendre en compte les sauts de lignes, ce genre de choses.

Il faudrait mettre des balises `<br>` et pour les tabulations, il faudrait se débrouiller autrement donc il ne va pas gérer le texte tel qu'il est présenté ici.
	
En revanche, si on utilise la balise `<pre></pre>` et qu'on actualise, le navigateur gère absolument le texte tel qu'il est dans le document.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<pre>
	Bonjour tout le monde.
	
	Ceci est une 		nouvelle phrase.
	</pre>
</body>
</html>
```
```txt
	Bonjour tout le monde.
	
	Ceci est une 		nouvelle phrase.
```
Le navigateur gère maintenant les retours à la ligne et les tabulations.

Tout est affiché tel quel dans le document.
	
D'ailleurs, on constate également qu'il y a une petite tabulation à gauche.

C'est tout simplement par ce que les balises sont indentées.
	
Il suffit alors de supprimer l'indentation pour que le texte se remet sur la gauche.
	
Tout est géré, les espaces blancs, les tabulations, etc.
	
Le pré-formatage du texte démarre après la première balise `<pre>`.
```html
		<pre>Bonjour tout le monde.
		
		Ceci est une 		nouvelle phrase.</pre>
```
Tout ce qui sera à l'intérieur des balises : les retours à la ligne, les tabulations, les retours chariot ou autre sera effectivement interprété par HTML et du coup affiché tel qu'on l'a vu.
	
Au niveau du code source, on retrouve également la même chose.
	
Ça peut être utile notamment quand on fait des programmes informatiques.

Par exemple, on va utiliser la balise `<code></code>` et on va utiliser la balise `<pre></pre>` comme ça on va préformater le code.
	
C'est-à-dire que si on met des tabulations dans un programme informatique, on voit que de cette manière grâce à ces balises-là, le navigateur va pouvoir garder nos tabulations tels qu'elles ont été écrites.
	
Parce que, si on fait :
```html
		<code>if(age > 18)
		{
			printf("Tu es majeur\n");
		}</code>
```
Et si on actualise le navigateur met tout à la suite.

Encore une fois, le navigateur ne prendra pas tous les espaces en compte.

Le mieux est encore de préformater le code que l'on a et du coup, il gérera automatiquement l'indentation :
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
<pre><code>if(age > 18)
{
	printf("Tu es majeur\n");
}</code></pre>
</body>
</html>
```
```c
	if(age > 18)
	{
		printf("Tu es majeur\n");
	}
```
Et maintenant, on constate qu'il va gérer automatiquement l'indentation.

`<pre></pre>` et `<code></code>` sont des balises qui s'utilisent beaucoup ensemble. Elles sont utilité pour les informaticiens. Ces balises-là sont à connaître par qu’elles nous survireront beaucoup.

## La balise `<ruby></ruby>`

Ensuite, on va venir sur des balises un peu particulières hors du domaine informatique. On va surtout s'intéresser au domaine écriture.
	
Si par exemple, on a besoin de manipuler des langues d’Asie orientale notamment, du japonais, du chinois, etc. Ça peut être intéressant d'utiliser ce genre de balise.
	
Ces balises fonctionnent ensemble.
	
On utilise une balise qui s'appelle `<ruby></ruby>` mais attention ça n'as rien à voir avec le langage de programmation Ruby.

C'est juste pour spécifier la prononciation d’Asie orientale.

Souvent dans les livres pour enfants, on écrit des caractères et s’ils sont trop compliqués, on écrit une prononciation dans un certain type d'écriture. Par exemple le Romaji lorsqu'on est en Japonais pour pouvoir montrer la prononciation aux enfants.
	
Donc c'est quelque chose de très utilisé.

Et le HTML a inclut des balises pour gérer ça.

Comment es qu'il font ça ? On met par exemple l'ensemble de caractères : ありがとう

Si on actualise, ils seront affiché sans problèmes puisqu'on est en UTF-8 ce qui permet ainsi de gérer tous les caractères de toutes les langues.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
    <ruby>
		ありがとう
    </ruby>
</body>
</html>
```
```txt
	ありがとう
```
Le japonais ci-dessus est géré également.

ありがとう, aligato qui veut dire merci en japonais.

Ici on affiche tout simplement les caractères, les kanas de ce mot.

Le problème est que l'on voudrais affiché la prononciation en romanji.
	
## La balise `<rt></rt>`

On peut le faire avec un ensemble de balises, on va utiliser la balise `<rp></rp>`

Mais on parlera d'habord de la balise `<rt></rt>`.

On écrira alors :
```html
		<ruby>
			ありがとう <rt>Arigatô</rt>
		</ruby>
```
Ca peut s'écrire Arigatô ou Arigatau en romanji mais ce n'est pas un cours sur le japonais.

Si on se trompe pas au niveau des mots, Arigatô est affiché au dessus.
	
Mais pour bien faire, il faut séparer chaque partie.

La bonne manière de faire est de mettre un caractère et ensuite mettre la prononciation entre balises.

C'est pour l'utiliser plus corectement. Ce sera plus exacte, autrement ça n'as pas d'intérêt.

Il faut l'écrire comme ça :
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
    <ruby>
        あ <rt>A</rt>
        り <rt>RI</rt>
        が <rt>GA</rt>
        と <rt>TO</rt>
        う <rt>U</rt>
    </ruby>
</body>
</html>
```
```txt
	ARIGATOU
	ありがとう
```
Ca se met ainsi de manière très pratique pour avoir la prononciation visible.

La prononciation est mise au dessus de chaque caractère et ça permet de faciliter la lecture. C'est plutôt sympa d'avoir ce type d'écriture.

Ca a vraiment son utilité.

## La balise `<rp></rp>`

La balise `<rp></rp>` sert notamment lorsqu'on veut mettre ces prononciations entre parenthèse.

Si on a besoin d'inscrire un caractère et que l'on met des parenthèses :
```html
		あ (<rt>A</rt>)
```
Ce n'est pas forcément très propre, ça va nous le mettre dans le texte donc ça ne va pas.

Pour ça, on utilise une balise `<rp></rp>`.

Il faut entourer la parenthèse avec `<rp></rp>`.
```html
		う <rp>(</rp><rt>U</rt><rp>)</rp>
```
Automatiquement on aura plus la parenthèse.

On l'aura pas non plus à l'affichage dans le navigateur.

Ce n'est pas une question de visuel, c'est une question de sémentique pour les moteurs qui vont analyser le code source veront les parenthèses et veront qua ça correspond à de la prononciation.

C'est vraiment encore une fois pensez sémantique.

Ne pas penser à ce qui se voit visuellement, ça c'est réservé au CSS. Ce n'est pas du HTML.
	
Pour nous même, on ne verra pas de différence par contre la différence est au niveau sémantique, à l'analyse de la page.

Donc si on veut mettre des parenthèse pour la prononciation, on utilise à chaque fois `<rp></rp>` pour les parenthèses.
	
Cependant la prononciation à utiliser s'utilise avec les balises `<rt></rt>`.

Et chaque caractère, tout cet ensemble, se met bien entre balises `<ruby></ruby>`.

Ca n'a rien avoir avec le langage de programmation qui s'appelle Ruby.

C'est juste pour afficher la prononciation de caractères d'Asie orientale ou de langues qui viennent d'Asie.
	
Ainsi on fait une vidéo pour toutes ces balises là même si nous ne seront pas beaucoup à l'utiliser. 

C'est bien d'en parler pour savoir que ça fonctionne en HTML mais après on ne serra pas beaucoup à l'utiliser.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
    <ruby>
        あ (<rt>A</rt>)
        り <rt>RI</rt>
        が <rt>GA</rt>
        と <rt>TO</rt>
        う <rp>(</rp><rt>U</rt><rp>)</rp>
    </ruby>
</body>
</html>
```
```txt
	A  RIGATOU
	あ()りがとう
```

## La balise `<samp></samp>`

Ainsi on a fait le tour de toutes ces balises et nous terminerons cette petite séance assez courte avec de petites balises qui serviront quand même un peu plus.
	
Donc on vient sur des balises informatiques notamment.

On avait vu la balise `<code></code>` pour écrire un langage informatique ou un langage de programmation. 

Maintenant on va voir une balise pour produire un résultat.

Si par exemple, on voilait faire :
```html
		<code>printf("Hello World !");</code>
```
Pour notre exemple, on va l'afficher comme ça :
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<p>Ce code : <code>printf("Hello World !");</code></p>
	<p>va afficher -><samp>Hello World</samp></p>
</body>
</html>
```
```txt
	Ce code : printf("Hello World !");

	va afficher ->Hello World
```
Nous utiliserons la balise <samp></samp> qui va afficher du coup un résultat de programme pour notre exemple en langage C.

Voilà ça permet d'afficher en sortie ce que ferait un programme.

Elle est utile pour l'informaticien et/ou le développeur.

Si c'est juste pour afficher du texte simple, on n'utilise pas ce genre de balise.

C'est vraiment pour la sortie d'un programme informatique qu'elle a été conçue et mise dans le standard.

## La balise `<time></time>`
	
On va voir la balise pour les temps maintenant.

Au niveau des temps, ça peut être vachement utile quand on a besoin d'afficher une date ou d'afficher une heure, d'afficher une durée.

Il y a une balise qui a été conçue pour cela.

HTML a pensez faire des balises pour un petit peu toutes les types d'informations.

D'ailleurs dans les années qui viennent, il y en aura plein de nouvelles pour pleins d'autres types d'informations, ils en rajoutent de toute façon de plus en plus.

Admettons qu'on écrive :
```html
		<p>Début du concours le 25 Janvier 2018</p>
```
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<p>Début du concours le 25 Janvier 2018</p>
</body>
</html>
```
```txt
	Début du concours le 25 Janvier 2018
```
C'est pas mal d'avoir ça mais sémantiquement si on veut avoir quelque chose d'encore plus pertinent, on peut entourer cette date "25 Janvier 2018" de la balise toute simple `<time></time>` :
```html
		<p>Début du concours le <time>25 Janvier 2018</time></p>
```
C'est déjà pas mal, ça indique qu'on a déjà un temps.

Même si ça peut porter à confusion car dans le mot time, il n'y a pas forcément une question de date.

Déjà là sémantiquement on a déjà quelque chose d'un peu plus correcte au niveau de l'analyse de la page.
	
### L'attribut datetime=""

Et si on veut être encore plus précis, on peut utiliser un attribut `datetime=""`.

Le `datetime=""`, dans les langage de programmation, prend un certain format de date.

Le `datetime=""` peut être de plusieurs manières :
		
+ On peut les énumérer, ça peut être l'Année, le mois, le jour. 
+ On peut aussi afficher les 3 à la fois.
+ On peut également afficher Date + heure.
	
Si par exemple, on veut juste afficher l'année :
```html
		<p>Début du concours le <time datetime="2018">25 Janvier 2018</time></p>
```	
Aucun changement au niveau de l'affichage, c'est bien sûr au niveau sémentique que ça a un intérêt.
	
Si je veux afficher l'année et le mois, j'affiche les quatre chiffres de l'année, un tiret, les deux chiffres du mois.

On met à l'envers, ce n'est pas en français. C'est une date type anglais.

On commence par l'année, on fait les mois et ensuite on fait les jours.

Et la, on a quelque chose de bien précis au niveau du datetime.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<p>Début du concours le <time datetime="2018-01-25">25 Janvier 2018</time></p>
</body>
</html>
```
```txt
	Début du concours le 25 Janvier 2018
```
Si on veux mettre une heure, le plus simple, c'est de mettre un espace.

Ensuite l'heure, deux points, les minutes et puis deux points et les secondes.
```html
		<p>Début du concours le <time datetime="2018-01-25 13:25:04">25 Janvier 2018</time></p>
```
Ca c'est une heure vraiment précise avec la date.

L'heure exacte de l'évennement qui correspondrait à "25 Janvier 2018".

Entre les balises, on met le texte que l'on veut.

Et comme on a bien spécifier l'attribut `datetime=""`, on a quelque chose de très précis.

Les analyseurs de page web vont pourvoir récupérer la date, la parser, l'utiliser, la collecter et du coup gérer au niveau référencement l'indexation de notre site pour mieux le gérer au niveau d'un calendrier, gérer des actualités, etc.
	
Ca peut avoir beaucoup d'intérêts si on a un site bien réferencé, qu'on puisse collecter ce genre de date pour pouvoir rendre nos informations beaucoup plus pertinente.
	
Dans `datetime=""`, on mettra bien en évidence une date précise pour un évennement, ce genre de chose.
	
Si on a juste besoin de mettre en évidence une date, un temps, une période, il faut utiliser la balise `<time></time>`, elle est vraiment très utile.

## La balise `<var></var>`

On terminera avec une dernière balise pour tout ceux qui font un peu de math, de l'informatique, pour afficher des variables.
	
- En informatique :

Ca peut être des variables en informatique et ça peut être par exemple lorsqu'on veux faire l'affectation d'une variable :
```html
		<p>Informatique : <var>x = 14</var></p>
```
Mais pour être plus précis, on pourrait mettre chaque chose de façon séparé de façon à ce que le égal ne soit pas compris dedans :
```html
		<p>En informatique : <var>nombre</var> = <var>14</var></p>
```
Ca change un peu les valeurs à l'affichage.

On peut mettre aussi le égal avec, peu importe.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<p>En informatique : <var>nombre</var> = <var>14</var></p>
</body>
</html>
```
```txt
En informatique : nombre = 14
```

- En mathématique :
	
Et en mathématique, on peut par exemple représenter X².

On met x au carré avec lequel on met une balise `<sup></sup>` qu'on a vu la dernière fois.

On fait + 5, ce genre de chose.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>  
	<p>Mathématiques : <var>x<sup>2</sup></var> + 5 = 13</p>
</body>
</html>
```
```txt
Mathématiques : x2 + 5 = 13
```
A l'affichage, on constate que ça met bien un formatage précis pour une expression mathématique.

Pour mettre ainsi, un expression mathématique donc des valeurs particulières ou une variable dite en informatique.

Ca peut être utile pour ça.

Ca c'est des choses pareils, on ne verra pas forcément l'utilité mais c'est bien de savoir qu'elle existe.

Si on veut afficher une expression mathématique ou une variable, on peut le faire avec ce type de balises. Elles servent à ça, à mettre en évidence ce genre de portion de texte, donc si on veut rendre les choses plus cohérentes, sémantiquement plus correct, on peut utiliser cette balise là.
	
Et voilà, on doit avoir tout vu.

C'est le but de la formation, c'est-à-dire savoir créer de vrai site web avec quelque chose de sémantiquement correct.

Après on apprendra à mettre ça en forme, gérer sur toutes les résolutions pour quelque chose d'assez global, qui nous permettra de faire un peu tout et n'importe quoi.
	
Ensuite ça nous permettra de nous lancer dans la programmation web avec des langages comme Javascript, PHP, on peut même coupler les deux, c'est même le mieux.
	
On verra tout ça au cours de ces formations et dans les vidéos à venir surtout.
	
Refaire pas mal d'exemples et à revoir tout ça...
	
Dans les prochaines séances, on va sortir du formatage de texte pour voir des choses un peu plus complexes en HTML.