# [12. Tableaux](https://www.youtube.com/watch?v=vZs202lVwJQ)

Bonjour tout le monde, il est temps dans cette 12e séance en PHP d'aborder un nouveau concept de programmation. 

Ici un nouveau type disponible en PHP qui représente des tableaux. 

Comme on avait vu dernièrement des types scalaires comme le integer, la chaîne de caractères, le float, le booléen, on avait évoqué quelques noms de type composé d'accord on en avait parlé dans la vidéo sur les types de données et le tableau on devait justement rentrer en détail là-dessus en faisant une vidéo. 

Le tableau est un type composé en PHP c'est vraiment bien hâte à retenir et ça vous aidera à comprendre tout ce que vous verrez par la suite et tout ce que vous pourrez éventuellement manipuler avec les tableaux donc c'est à retenir et bien à assimiler à ce niveau-là avec ce que je vais vous montrer dans cette vidéo.

On va regarder comment c'est créer un tableau et vous allez voir que c'est assez simple. 

Alors comment fonctionne un tableau en PHP ? Il faut imaginer en fait une espèce de représentation de données vous allez avoir un ensemble de clés d'accord. 

Une clé c'est une sorte de identifiant, on verra ça pourra être un nom ou bien une chaîne de caractères  auquel on pourra associer une valeur, et une valeur ça pourra être absolument n'importe quoi, n'importe quel type, y comprit un autre tableau comme on le verra un peu plus tard. 

Vous avez en fait ce fonctionnement de couple, clé et valeur, que nous allons pouvoir stocker dans un tableau qui sera tout simplement représenté par une variable PHP comme on l'a vu dernièrement. 

On va donc créer notre tableau, on va faire par exemple un tableau d'entiers $tab_integers et on va créer un tableau vide pour commencer donc voilà la syntaxe primaire.
```php
	$tab_integers = array(); //Tableau vide
```
La syntaxe primaire c'est-à-dire la syntaxe historique de PHP pour pouvoir créer un tableau vide que je vous montre ici en utilisant le mot array() avec des parenthèses et on termine évidemment l'instruction avec un `;`

ça c'est donc la syntaxe historique qu'on peut retrouver encore maintenant et qui est tout à fait valide. 

À partir de PHP 5.4 même si là actuellement nous travaillons avec la version PHP 7 comme je vous l'avais dit en début de vidéo sur l'introduction, vous pouvez depuis PHP 5.4, utiliser une autre syntaxe qui est tout simplement l'utilisation de crochet.
```php
	$tab_integers = array(); //Tableau vide
	$tab_integers = []; //Autre syntaxe
```
Alors moi au quotidien j'utilise toujours cette syntaxe là, [].

Dans ma vidéo j'utiliserai toujours cette syntaxe là aussi évidemment mais si évidemment vous préférez utiliser la syntaxe plus ancienne `array()`, vous pouvez le faire ça ne pose aucun problème. 

Il n'y a pas une syntaxe qui est mieux que l'autre, c'est vraiment une question de préférence et de choix, vous choisissez démarre pour la vidéo j'utiliserai celle ci `[]` un peu plus courte et puis on comprend très bien qu'avec des crochets nous sommes dans un tableau donc moi elle ne pose aucun problème du tout, elle me paraît très bien. 
```php
	$tab_integers = []; //Autre syntaxe
```
On vient donc de créer ce tableau vide, et on va vérifier qu'on a bien obtenu le type dont on parlait en utilisant notre petite fonction gettype() comme on l'avait déjà vu maintenant plein de fois et on actualise. 
```php
<?php

$tab_integers = []; //Autre syntaxe

echo gettype($tab_integers);
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	array
```
Vous voyez qu'on a bien le type array qui est rendu, c'est effectivement ce type composé là. 

Alors ça c'est important à bien comprendre que le tableau en PHP s'agit d'un type  et non pas d'une structure de données, ou un objet, une classe bref c'est vraiment un type composé qui appartient et qui est disponible en PHP. 

Voilà comment ça fonctionne. 

Nous allons maintenant parce que là on vient de faire un tableau vide donc ça n'a évidemment aucun intérêt, et nous allons pouvoir ajouter un ensemble d'informations. En général je le mets comme ça pour que vous ayez une représentation du code et que ce soit propre.
```php
	$tab_integers = 
	[
	
	];

	echo gettype($tab_integers);
```
Ainsi vous pouvez mettre votre crochet comme ça, ou bien vous pouvez laisser array vous pouvez laisser les parenthèses de cette manière à la place d'avoir des crochets comme ceci.
```php
	$tab_integers = array
	(
	
	);

	echo gettype($tab_integers);
```
Vous pouvez mettre des parenthèses comme ça à la place des crochets avec array, c'est à vous de voir mais moi j'écris ça comme ça et on va pouvoir passer à l'intérieur un ensemble de données.
```php
	$tab_integers = 
	[
		...
	];

	echo gettype($tab_integers);
```
Alors par défaut la clé en tout cas est optionnelle. En PHP vous n'êtes pas obligé de renseigner la clé, par exemple on va d'ailleurs le montrer en faisant ceci.
```php
	$tab_integers = 
	[
		10, 11, 12, 13, 14, 15
	];

	var_dump($tab_integers);
```
On sépare ainsi toutes les valeurs par des virgules donc vous pouvez ainsi le mettre tout ensemble séparés par des virgules mais vous pouvez aussi les mettre à la ligne, ça ne pose aucun problème mais sachez que la dernière virgule est optionnelle.
```php
	$tab_integers = 
	[
		10,
		11,
		12,
		13,
		14,
		15
	];

	var_dump($tab_integers);
```
D'accord vous n'êtes pas obligé de la mettre même si en général les développeurs la mettre par habitude parce que ça permet comme ça de facilement ajouter éventuellement une autre donnée par la suite donc vous pouvez très bien écrire les choses sans ou avec une virgule à la fin mais c'est pareil c'est pour qui voyez.

On va ensuite afficher le contenu c'est-à-dire qu'on va faire un var_dump() comme on avait déjà vu qui affichera les informations d'une variable et voyons un petit peu ce que ça me donne.
```php
<?php

$tab_integers = 
[
	10,
	11,
	12,
	13,
	14,
	15
];

var_dump($tab_integers);
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	array(6) { [0]=> int(10) [1]=> int(11) [2]=> int(12) [3]=> int(13) [4]=> int(14) [5]=> int(15) }
```
Voilà comment ça se passe.

On voit qu'on a ce fameux couple de clé valeur, `[0]=>int(10)`.

D'ailleurs plutôt que d'utiliser var_dump(), je vais utiliser print_r() qui va en fait mieux afficher les données, je vous recommandé même d'utiliser un petit peu de HTML en faisant ça, en utilisant la balise `<pre>` qui va formater en fait l'affichage et on n'oublie pas de fermer la balise `</pre>` et on oublie pas de fermer la valise PHP parce qu'on a du HTML, `?>`.
```php
<?php

$tab_integers = 
[
	10,
	11,
	12,
	13,
	14,
	15
];

echo '<pre>';
print_r($tab_integers);
echo '</pre>';

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	Array
	(
		[0] => 10
		[1] => 11
		[2] => 12
		[3] => 13
		[4] => 14
		[5] => 15
	)
```
Vous pouvez faire ça si vous pensez que var_dump() n'est pas assez pratique pour la lecture, vous pouvez faire ces 3 petites lignes là entouré de la balise `<pre></pre>` via un echo, et vous utilisez print_r() sur la variable.

Voilà la différence simplement, c'est qu'on aura du coup un affichage un peu mieux présenté et beaucoup plus lisible à l'œil nu donc là on se rend bien compte du fonctionnement de couple clé valeur. 

Donc par défaut comme je n'ai pas spécifié de clé ici, il a choisi des index par défaut. 

En informatique on sait que les index en général pour les tableaux ou pour les données commencent toujours par 0 et c'est effectivement ce qu'il a fait. 

On voit que ça commence par 0 auquel il a appliqué la valeur 10.

Pour l'indice 1, il a appliqué la valeur 11. 

Pour 2, 13 et pour 3, 14 et cetera et cetera. 

Je peux éventuellement spécifier des clés moi-même, je peux très bien le faire. 

Par exemple si j'avais voulu qu'il commença à 1, j'aurais pu faire ceci. 
```php
	$tab_integers = 
	[
		1 => 10,
		11,
		12,
		13,
		14,
		15
	];

	echo '<pre>';
	print_r($tab_integers);
	echo '</pre>';
```
On utilise le symbole de flèche `=>` c'est-à-dire le égal et un symbole supérieur à ou le chevron fermant. 

D'ailleurs je n'ai pas besoin de spécifier les autres, ça ne sert à rien de faire ça.
```php
	$tab_integers = 
	[
		1 => 10,
		2 => 11,
		12,
		13,
		14,
		15
	];

	echo '<pre>';
	print_r($tab_integers);
	echo '</pre>';
```
Ça ne sert à rien de faire ça tout simplement parce que en ayant juste cette ligne là `1=>10`, il va comprendre que la clé pour la valeur 10 est 1. Et ensuite comme ça n'a pas été spécifié pour la valeur 11, il va reprendre incrémenter automatiquement à partir du dernier index, la dernière clé qui a pu être trouvée et donc là il va incrémenté à partir de 1.
```php
<?php

$tab_integers = 
[
	1 => 10,
	11,
	12,
	13,
	14,
	15
];

echo '<pre>';
print_r($tab_integers);
echo '</pre>';

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	Array
	(
		[1] => 10
		[2] => 11
		[3] => 12
		[4] => 13
		[5] => 14
		[6] => 15
	)
```
Donc là il va incrémenter à partir de 1, et là du coup ça part bien de 1 c'est-à-dire 1, 2, 3, 4, 5, 6.

On peut très bien faire comme ça. 

On peut très bien mettre n'importe quoi, on peut mettre soit un nombre comme on vient de le faire ici mais on peut aussi mettre une chaîne de caractères et voilà ce qui arrive quand on actualise.  
```php
<?php

$tab_integers = 
[
	1 => 10,
	"ok" => 11,
	12,
	13,
	14,
	15
];

echo '<pre>';
print_r($tab_integers);
echo '</pre>';

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	Array
	(
		[1] => 10
		[ok] => 11
		[2] => 12
		[3] => 13
		[4] => 14
		[5] => 15
	)
```
On actualise et voilà ce qu'il se passe.

Là automatiquement comme c'est généré `[1] -> [ok] -> [2]`, il reprend depuis la dernière clé sous forme de nombres d'entier qu'il a pu trouver et ça se décale comme ça. 

Admettons si je m'amuse à un moment donné à faire ça.
```php
<?php

$tab_integers = 
[
	1 => 10,
	"ok" => 11,
	10 => 12,
	13,
	14,
	15
];

echo '<pre>';
print_r($tab_integers);
echo '</pre>';

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	Array
	(
		[1] => 10
		[ok] => 11
		[10] => 12
		[11] => 13
		[12] => 14
		[13] => 15
	)
```
Si vous avez compris, la clé pour la valeur 13 sera à partir de ce dernier index `[10]` donc ce sera à partir de `[11]` d'accord donc 10 11 12 13.

On va au niveau du résultat comme je l'ai spécifié [10] ici et comme là il n'y a pas de clé pour ces 3 valeurs 13,14 ,15 Eh bien il va les généré automatiquement et comme la dernière clé la plus grande qu'il a trouvé dans le tableau c'était `[10]`. Eh bien ici ce sera `[11]`, `[12]` et `[13]`.

Ça explique pourquoi nous avons ces ensembles là donc voilà comment ça fonctionne mais on peut également mettre n'importe quoi si on veut comme des chaînes de caractères, des nombres à virgule, on peut même y mettre des fonctions sans problème.
```php
<?php

$tab_integers = 
[
	1 => 10,
	"ok" => 11,
	10 => 12,
	"Bonjour",
	date("Y-m-d"),
	3.164
];

echo '<pre>';
print_r($tab_integers);
echo '</pre>';

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	Array
	(
		[1] => 10
		[ok] => 11
		[10] => 12
		[11] => Bonjour
		[12] => 2020-11-23
		[13] => 3.164
	)
```
Voilà ça fonctionne tout à fait, ça peut prendre n'importe quelle valeur que ce soit un type précis, que ce soit un retour de fonction parce que ici il y a la fonction date() que l'on n'a jamais vu mais qui est très simple qui est tout simplement retourner une date sous ce format *Y-m-d*. 

date() retourne quelque chose et retourne quelque chose que je peux la mettre comme valeur dans mon tableau sans problème.

On peut vraiment tout gérer comme ça. L'avantage c'est ça. 

Ce qu'il faut reconnaître ou en tout cas ce qu'il faut se souvenir en tout cas, c'est que un tableau en PHP est un type composé, c'est un type de données comme 10 est un type integer, "bonjour" est un type string et 3.164 est un type float. D'accord c'est exactement de la même manière. 

Vous pouvez pour les clés qui sont optionnels mais que si vous les renseignez, mettre un entier donc un integer et donc si vous mettez un float comme clé, ce sera évidemment tronqué par exemple si vous mettez 3.164 comme clé de tableau, il prendra pour indice le 3 en supprimant la partie décimale. Si vous mettez true, la valeur true, il la remplacera par 1 parce qu'un booléen peut se caster en entier donc il va réussir à déduire la valeur. Et on peut mettre une chaîne de caractères bien évidemment comme on l'a fait ici pour "ok", vous voyez que ici on obtient la clé `[ok]` pour une de nos informations donc c'est plutôt bien à savoir. 

À partir de là ce que nous allons pouvoir retenir, c'est comment traiter maintenant ces données. Vous savez comment créer un tableau, vous savez comment gérer les différentes clés, les différents types qu'elles peuvent prendre et vous savez gérer les valeurs. 

D'ailleurs je l'avais dit aussi on peut mettre un tableau en tant que valeur, on peut tout à fait faire ça.
```php
<?php

$tab_integers = 
[
	1 => 10,
	"ok" => [5, 4, 3],
	10 => 12,
	"Bonjour",
	date("Y-m-d"),
	3.164
];

echo '<pre>';
print_r($tab_integers);
echo '</pre>';

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	Array
	(
		[1] => 10
		[ok] => Array
			(
				[0] => 5
				[1] => 4
				[2] => 3
			)

		[10] => 12
		[11] => Bonjour
		[12] => 2020-11-23
		[13] => 3.164
	)
```
Ça ne pose pas de problème 5, 4, 3 comme ceci et c'est pour ça que je voulais prendre le print_r() pour le formatage parce que là vous voyez que c'est beaucoup plus lisible à la lecture pour les données donc on se rend bien compte qu'à l'indice "ok" donc la clé `[ok]`, la valeur est un tableau lui-même aussi qu'il contient à chaque fois un couple de clé valeur pour chaque chose donc ça c'est important à savoir et ça nous permet de bien manipuler les informations donc ce sont des choses à bien connaître ici en PHP. 

Voilà pour ces informations là, je pense que tout a été dit au niveau de la création des informations pour nos tableaux donc on peut bien évidemment faire des tableaux à 2 dimensions où il suffirait simplement pour chaque indice, de créer un nouveau tableau. 

Si vous mettez un tableau en valeur à chaque fois, Eh bien vous aurez un tableau à 2 dimensions et si en plus vous remettez un tableau dans un autre tableau même si ce ne serait pas lisible pour le coup. Je vous montre que ce serait possible avec ça fonctionnerait…
```php
<?php

$tab_integers = 
[
	1 => 10,
	"ok" => [5, 4, ["a", "b", "c"]],
	10 => 12,
	"Bonjour",
	date("Y-m-d"),
	3.164
];

echo '<pre>';
print_r($tab_integers);
echo '</pre>';

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	Array
	(
		[1] => 10
		[ok] => Array
			(
				[0] => 5
				[1] => 4
				[2] => Array
					(
						[0] => a
						[1] => b
						[2] => c
					)

			)

		[10] => 12
		[11] => Bonjour
		[12] => 2020-11-23
		[13] => 3.164
	)
```
Voilà je vous montre que c'est possible et que ça fonctionne. 

Voilà on peut avoir un tableau dans un tableau dans un tableau donc on peut faire des tableaux de dimensions variables comme on veut, ça ne poserait évidemment aucun souci donc vous pouvez associer ça de la manière dont vous voulez. 

Donc ça c'est bon pour la création alors il faut bien comprendre ce système de tableau pour ne pas se mélanger. Je vous ai parlé des clés et là génération automatique, et les clés sont évidemment optionnelles. Vous pouvez générer un tableau en mettant juste les valeurs et c'est PHP qui va générer les clés, ou alors vous faites vous-même votre tableau associatif en choisissant un groupe de clé valeur à chaque fois donc ça peut être pratique, vous pouvez très bien faire ça. 

Admettons prenons un exemple le tableau qui nous parlerait bien `$tab_population_villes`, un exemple parce que je ne suis pas forcément très bien inspiré, un exemple logique. On peut faire par exemple un tableau qui recense pour chaque ville le nombre d'habitants alors évidemment je ne vais pas mettre de vraies valeurs et soyez rassuré si vous voyez que je mets 14 habitants dans une ville comme Paris, ce n'est évidemment pas des valeurs réelles et on peut très bien noté comme ceci.
```php
<?php

$tab_population_villes = 
[
	"Paris" => 14000,
	"Orléans" => 8,
	"Clermont-Ferrand" => 146
];

echo '<pre>';
print_r($tab_population_villes);
echo '</pre>';

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	Array
	(
		[Paris] => 14000
		[Orléans] => 8
		[Clermont-Ferrand] => 146
	)
```
Et du coup ça suit parfaitement cette logique là donc vous voyez un petit peu … il y en a peut-être parmi vous qui vont se poser la question, à quoi ça peut servir ? comment est-ce qu'on peut venir à l'idée d'utiliser un tableau pour tel agencement d'informations. Voilà donc un exemple, On voudrait par exemple se dire qu'on a un ensemble de clé valeur d'accord. 

À chaque clé est associé une valeur précise donc là on pourrait dire que pour chaque ville, on a un nombre d'habitants à donner. 

Et du coup c'est très pratique parce que ce système est créé de cette façon là, on a évidemment et vous vous en doutez des fonctions de PHP prédéfinies donc il existe en natif de PHP qui vont permettre de travailler sur nos tableaux.

On va par exemple pouvoir récupérer toutes les clés, récupérer les valeurs, faire des recherches dans les tableaux, on va pouvoir diviser, on va pouvoir fusionner 2 tableaux en 1, on va pouvoir les trier enfin bref on va pouvoir faire tout un tas de choses mais ça on le verra à la fin de cette séance. 

Voilà comment ça se passe, alors maintenant qu'on sait comment créer un tableau, comment on crée un tableau associatif c'est comme ça qu'on appelle, quand on a un ensemble définit de clé valeur, on parle de ce tableau associatif parce qu'on associe de valeur à chaque clé, un couple clé valeur comme je l'ai dit. 

Voilà pour ça. 

On va déjà voir comment afficher les données d'un tableau parce que là on a vu comment faire avec un print_r() ou un var_dump(), qui est fait pour afficher les informations d'une variable mais pas pour vraiment afficher les informations d'un tableau en particulier. 

Donc ce tableau là pour l'exemple, on peut faire ce genre de choses en mettant le nom du tableau et on choisit la clé particulier donc c'est par exemple je vais afficher le nombre d'habitants de Orléans. Eh bien je vais tout simplement dire affiche-moi à ce tableau là la valeur qui correspond à cette clé ici `[Orléans]` et enfin j'actualise.
```php
<?php

$tab_population_villes = 
[
	"Paris" => 14000,
	"Orléans" => 8,
	"Clermont-Ferrand" => 146
];

echo $tab_population_villes["Orléans"];

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	8
```
J'actualise nous avons bien la valeur vide retourné donc vous mettez le nom du tableau donc en tant que variable, suivi de crochets et entre guillemets que ce soit des doubles "Orléans" ou des simples 'Orléans' d'ailleurs peu importe c'est vous qui voyez bref vous spécifiez l'information. 

Attention de bien mettre les guillemets parce que si vous faites ça.
```php
	echo $tab_population_villes[Orléans];
```
Si vous faites ça, ça va fonctionner parce qu'il va prendre Orléans comme une constante ou alors éventuellement une variable.

Si par exemple on avait une autre variable … des fois ça pourrait servir on pourrait avoir par exemple ceci.
```php
<?php

$tab_population_villes = 
[
	"Paris" => 14000,
	"Orléans" => 8,
	"Clermont-Ferrand" => 146
];

$nom_ville = "Paris";

echo $tab_population_villes[$nom_ville];

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	14000
```
Voilà donc on a fait des choses propres et si effectivement vous avez ce cas-là vous pouvez faire ça sans mettre de doubles guillemets parce que vous savez que si vous faites ça `["$nom_ville"]` ce ne sera pas forcément bon. Comme ça `[$nom_ville]` ce sera géré parce que ça fonctionne pour les variables mais par contre si vous faites ça `['$nom_ville']` il va essayer de vous cherchez un texte qui s'appelle comme ceci et là on ne retourne rien parce que évidemment ça n'existe pas donc si c'est une variable ou une constante, vous n'avez pas besoin de guillemets évidemment et là vous voyez que ça retourne bien 14000 ça fonctionne parce qu'il a remplacé la variable par Paris donc là il n'y a pas de surprise.

Mais sinon si on veut marquer en dur, on n'hésite pas à faire ça.
```php
<?php

$tab_population_villes = 
[
	"Paris" => 14000,
	"Orléans" => 8,
	"Clermont-Ferrand" => 146
];

$nom_ville = "Paris";

echo $tab_population_villes["Clermont-Ferrand"];

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	146
```
Et donc voilà comment on affiche une information d'un tableau. 

Au lieu d'utiliser les crochets même si on le voit quand même très rarement mais moi personnellement je le fais que très rarement ou presque jamais, on peut aussi utiliser des accolades comme ceci.
```php
<?php

$tab_population_villes = 
[
	"Paris" => 14000,
	"Orléans" => 8,
	"Clermont-Ferrand" => 146
];

$nom_ville = "Paris";

echo $tab_population_villes{"Clermont-Ferrand"};

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	Deprecated: Array and string offset access syntax with curly braces is deprecated in ...
```
Mais je n'ai jamais vu de code qui utilisait cette syntaxe là et donc voilà personne s'en sert même si d'ailleurs on voit que ça fonctionne sans soucis (ne fonctionne plus en 2020) !

Bon du coup c'est une syntaxe qui existait et qui maintenant ne fonctionne plus, encore une fois p était soi-disant un langage assez historique mais cette fois-ci ça ne fonctionne plus. Jusqu à la réalisation de la vidéo, PHP gardait la rétrocompatibilité avec les anciennes manières de noter le code donc si vous tombez un jour sur du code qui contient cette syntaxe ne soyez pas choqué, c'était fonctionnel jusqu'à aujourd'hui. 

Mais je vous le dis clairement, comme avec cette nouvelle syntaxe on utilise des crochets et même dans beaucoup d'autres langages comme le c et le c++, le Java et cetera, même C Sharp bref tous les langages de programmation pratiquement, ils ont pris l'habitude de se servir des crochets voir éventuellement après pour l'accès aux données même si par exemple en c pour créer un tableau on utiliserait les accolades mais on ne va pas se mélanger. 

En général quand on veut accéder à une information dans un tableau, dans pratiquement tous les langages de programmation on va se servir des crochets et dans les crochets on met l'indice donc la clé correspondant à la valeur qu'on veut récupérer. 

Voilà comment on veut afficher une information. 

Si on veut modifier une information parce que évidemment on peut le faire, ça va être exactement la même chose c'est simplement que au lieu d'afficher on va dire pour ce tableau là à la clé/indice "Clermont-Ferrand", et bien tu vas maintenant affecter non pas la valeur du tableau mais tu vas affecter autre chose d'accord et après pourquoi pas l'afficher évidemment.
```php
<?php

$tab_population_villes = 
[
	"Paris" => 14000,
	"Orléans" => 8,
	"Clermont-Ferrand" => 146
];

$nom_ville = "Paris";

$tab_population_villes["Clermont-Ferrand"] = 17800;
echo $tab_population_villes["Clermont-Ferrand"];

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	17800
```
Faisons les choses un peu plus correctement, on affiche et on voit que la valeur a bien été changée. 

Donc pour modifier la valeur d'un tableau il faut juste faire ça, spécifiez le nom du tableau ainsi que la clé sur laquelle vous voulez faire la modification et vous affecter tout simplement une nouvelle valeur. 

Et ça peut encore une fois c'est tout à fait logique n'importe quel type de données, n'oubliez pas que la valeur dans un tableau ça peut être n'importe quoi un autre tableau, un objet, un retour de fonction, un nombre, une chaîne de caractères donc en bref ce que vous voulez. 
```php
	$tab_population_villes = 
	[
		"Paris" => 14000,
		"Orléans" => 8,
		"Clermont-Ferrand" => 146
	];

	$nom_ville = "Paris";

	$tab_population_villes["Clermont-Ferrand"] = [1, 2, 3];
	echo $tab_population_villes["Clermont-Ferrand"];
```
Il n'y a que pour la clé d'un tableau où vous allez devoir soit mettre un entier soit une chaîne de caractères donc là c'est que l'un ou l'autre on ne peut pas mettre par exemple une fonction ici en tant que clé.
```php
	"une_fontion" => ... !
```
Ce serait complètement incohérent ce serait complètement bizarre de mettre une fonction en tant que clé donc voilà comment ça se fonctionne à ce niveau là pour ces données-la. 

Maintenant que vous savez afficher, il y a peut-être des cas vous aurez besoin de parcourir le tableau. 

Admettons que je veux afficher toutes les informations mais plus proprement qu'avec un print_r() ou un var_dump() qui normalement est fait pour afficher les informations d'une variable, en effet il n'est pas fait juste pour les tableaux. 

Je vous avais dit qu'avec les boucles il y avait une méthode pour le faire soit avec le for soit avec le foreach. 

Alors la boucle for, ce qu'il faudrait faire normalement mais je ne vais même pas vous montrer l'exemple comme ça ça vous évitera de prendre de mauvaises habitudes où d'apprendre des choses qui ne sont pas forcément optimisé. On aurait fait une boucle for pour dire qu'on part du premier indice du tableau et ensuite on incrémente l'indice pour arriver jusqu à la fin du tableau. 

Sauf que dans certains cas, que vous voyez que j'ai ce genre de cas-là "Clermont-Ferrand", Je ne pourrais pas utiliser la boucle for si par exemple je n'ai pas un simple entier. 

On peut incrémenter un entier mais par contre incrémenté de chaîne de caractères surtout ici c'est juste pas possible donc autant que je vous donne une méthode qui fonctionnera à tous les coups qui de toute façon est faites pour ça qui est la fameuse boucle foreach dont on avait parlé rapidement. 

Je vous avais dit que la boucle foreach servait vraiment pour parcourir des tableaux donc si vous voulez faire un parcours de tableau utiliser tout le temps foreach, elle est vraiment fait pour ça donc je ne vois pas honnêtement l'intérêt d'utiliser la boucle for. 

Alors que de toute façon la boucle for ne va fonctionner que pour un tableau pour lequel vous auriez des clés de sous forme d'entiers qui peuvent être incrémentés d'accord qui peuvent être itéré mais dans notre cas ici ça ne fonctionnerait pas. 

Alors comment fonctionne la boucle foreach(), on va dire que pour chaque valeur de notre tableau que nous allons considérer (as) comme étant autre chose est par exemple on peut mettre `$data` par exemple parce que j'ai forcément cherché un nom assez générique. 

Donc pour chaque couple clé valeur de mon tableau, nous allons stocker dans `$data`. Alors si je fais juste ça et que je fais ensuite un echo de `$data`, voilà ce que je vais avoir.
```php
<?php

$tab_population_villes = 
[
	"Paris" => 14000,
	"Orléans" => 8,
	"Clermont-Ferrand" => 146
];

$nom_ville = "Paris";

foreach($tab_population_villes as $data)
	echo $data;

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	140008146
```
Alors évidemment les données sont mises comme ça c'est normal mais on va utiliser du HTML pour mettre ça à la ligne.
```php
<?php

$tab_population_villes = 
[
	"Paris" => 14000,
	"Orléans" => 8,
	"Clermont-Ferrand" => 146
];

$nom_ville = "Paris";

foreach($tab_population_villes as $data)
	echo '<p>'.$data.'<p>';

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	14000

	8

	146
```
Voilà donc vous voyez 14000, 8, 146. 

Ça correspond bien ça par contre on n'a que la valeur, on n'a pas évidemment la clé, ça c'est la syntaxe par défaut. Si vous aviez par exemple un tableau pour lequel vous vous en foutez des clés, des fois ça peut arriver. Genre par exemple on va faire une liste de numéros, on s'en fiche des clés parce que ils vont aller de 0 à la taille du tableau -1 donc on s'en fiche de ça.

Moi dans mon cas comme on voit que mon tableau est associatif et que j'ai mis des clés particulières, je veux les 2 informations ensemble parce qu'elles sont tout à fait cohérentes.
```php
	"Paris" et 14000
```
Je ne veux pas juste ça 14000 parce qu'on ne saurait pas à quoi ça correspond donc pour le faire il suffit de préciser l'associativité en mettant par défaut et par habitude on écrit `$k` pour la key, la clé. On met la fameuse flèche `=>`, et on met `$v` pour value donc ça c'est par habitude.
```php
	foreach($tab_population_villes as $k => $v)
```
Vous pouvez mettre le nom que vous voulez, vous pouvez mettre un nom complet si vous voulez, c'est vous qui voyez.
```php
	foreach($tab_population_villes as $key => $value)
```
Et là il suffira d'afficher.
```php
<?php

$tab_population_villes = 
[
	"Paris" => 14000,
	"Orléans" => 8,
	"Clermont-Ferrand" => 146
];

$nom_ville = "Paris";

foreach($tab_population_villes as $key => $value)
	echo '<p>'.$key.' / '.$value.'<p>';

?>
```
```txt
	http://localhost/PHP/cours/012_tableaux/
	Paris / 14000

	Orléans / 8

	Clermont-Ferrand / 146
```
Et voilà on a à chaque fois à la fois la clé et la valeur formatés comme on le veut donc ça c'est très pratique et ce type de parcours va énormément servir quand par exemple on va récupérer des informations d'une base de données ou d'un fichier où ce genre de chose. 

L'avantage c'est que si vous stockez après dans un tableau que vous voulez parcourir, Eh bien avec une simple boucle foreach Peu importe le fonctionnement de votre tableau que ce soit un simple tableau avec des clés par défaut ou alors des clés très précises qui en font un tableau associatif précis, Eh bien grâce à ça vous allez pouvoir travailler avec. 

Soit vous mettez qu'une seule variable après le as et il va prendre que la valeur, soit vous avez besoin de récupérer les 2 … donc vous ne pouvez pas récupérer que les clés en faisant comme ça … c'est soit vous récupérez que les valeurs, souhaitez-vous récupérer le couple clé valeur en écrivant comme ça … as `$key => $value`. 

Et encore une fois le nom que vous mettez `$k` ou `$key` … c'est vous qui choisissez, ça va créer en fait des variables à chaque itération de boucle et tant que c'est noms-là reste effectivement les noms que vous mettez dans echo pour exploiter les informations, ça ne posera pas de problème vous pouvez mettre absolument n'importe quoi comme nom de variable ici, `$key` et `$value`. 

Voilà comment ça fonctionne pour parcourir des données sur un tableau. 

Maintenant qu'on a vu tout ça, elle va terminer pour la fin de cette vidéo avec quelques fonctions usuelles parce qu'il y a évidemment quelques petites fonctions à connaître mais plutôt que de vous en proposer plusieurs et de faire des exemples dessus parce que ça va dépendre de l'utilisation que vous aurez des tableaux, je vais vous en révéler quelques-unes qui à mon sens sont très très intéressante qu'on utilise assez souvent pour les tableaux et après je vais vous faire évidemment référer à la documentation PHP où vous allez trouver vraiment la liste complète. 

Donc au niveau des fonctions qui peut être à mon sens utile, je vais en noter quelques-unes je vais en noter très peu parce qu'il y en a vraiment beaucoup et vous allez très vite le voir.
```php
	/*
		Fonctions usuelles pour les tableaux :
			> array_push()
			> array_pop() ou array_shift()
			> in_array()
	*/
```
Ce qu'il faut pas me retenir c'est que vous allez avoir beaucoup beaucoup de fonctions utilisable via des tableaux et autant je vais vous montrer sur la documentation. 

Quand vous avez besoin de savoir les fonctions disponibles, vous allez sur la documentation via ce lien.

https://www.php.net/manual/fr/ref.array.php

Vous avez le lien ici et là vous avez toutes les fonctions disponibles pour le tableau, et tient d'ailleurs explode() est également très utilisé aussi. 

explode() permet de couper permettre pas mal d'information donc c'est vrai qu'elle est très utilisée comme fonction sur le tableau. 

is_array(), on la connaissait la fameuse fonction qui vérifie le type comme on avait vu is_int(), is_string() et cetera donc vous voyez que vous avez la même pour ça. 

Sur cette page vous avez tout un ensemble de fonctions.

```txt
	Sommaire
	array_change_key_case
	array_chunk
	array_column
	array_combine
	array_count_values
	array_diff_assoc
	...
```
Vous avez tout un ensemble de fonctions disponibles et vous voyez qu'il n'y en a pas mal. 

Toutes ces fonctions là sont souvent reconnaissable par array_... quelque chose, et vous en avez d'autres qui vont vous permettre de faire pas mal de petites choses également comme par exemple retourner la clé d'un tableau key(), faire des petits tri et ce genre de chose, compter le nombre d'éléments normalement c'est count() qui compte le nombre d'éléments dans un tableau. 

On peut d'ailleurs avoir son alias qui est sizeof() mais voilà moi je les utilise tout le temps count() même si c'est vrai que je l'avais un petit peu oublié. 

Vous avez du coup beaucoup de fonctions donc si vous avez besoin de savoir une fonction vous voyez qu'en plus là doc est en français si vous voulez et en plus le nom est suffisamment explicite avec la description suivant ce que vous voulez faire. 

Vous allez retrouver comme ça toute l'information. 

Alors grosso modo array_push() il va permettre de gérer le tableau comme étant une pile c'est-à-dire qu'il va ajouter un élément à la fin du tableau comme si vous utilisez une structure de données de pile pour ceux qui connaissent. 

array_pop() va retirer la première valeur du tableau donc par devant.

array_shift() va retirer la valeur il parle au début donc tout simplement dans l'autre sens. 

Et in_array() et simplement une fonction qui va permettre de vérifier si une valeur est contenue dans le tableau, et va retourner true ou false en fonction si la valeur a été trouvée ou non. 

On a également array_search() qui est pas mal utile quand on veut chercher des informations, rechercher la clé associée à la première valeur et donc ça peut servir aussi. 

Vous avez également des fonctions pour fusionner tel que array_combine() qui va permettre de créer un tableau à partir de 2 autres tableaux. 

On a également la séparation, array_chunk() qui permet de séparer un tableau en tableau de taille inférieure. 

Bref beaucoup beaucoup de fonctions, je ne vais pas vous montrer des exemples dessus parce qu'il y en a énormément et que ça ne servirait pas forcément. 

Alors c'est très simple à utiliser quand vous avez besoin d'y aller, vous sélectionnez la fonction que vous voulez par exemple array_keys().

https://www.php.net/manual/fr/function.array-keys.php

Ensuite pour lire la doc c'est très simple, vous avez la description comme d'habitude. Vous avez le nom de la fonction comme vous l'avez appris dans la vidéo sur les fonctions précédemment ainsi que les paramètres qu'elle peut prendre avec éventuellement les paramètres optionnels qui sont généralement indiqués entre crochet, par exemple
```php
	array_keys ( array $array , mixed $search_value [, bool $strict = FALSE ] ) : array
	
	--> [, bool $strict = FALSE ]
```
Vous avez également ce qu'elle retourne. 

Et on vous explique tout, les paramètres, qu'est-ce qu'elle retourne et en plus on vous met des exemples et souvent vous avez des commentaires des gens pour apporter des compléments d'information donc je pense qu'on ne peut pas faire plus complet à ce niveau-là donc prenez l'habitude de consulter la doc. 

C'est normal pour un développeur de consulter les documentations d'un langage. 

L'intérêt n'est pas non plus de tout retenir par cœur même si bien évidemment de manière naturel vous à finir par retenir des fonctions et d'autres choses au fur et à mesure. 

Alors c'est normal on peut pas tout retenir par cœur, c'est impossible. Il suffit de ne pas utiliser un langage pendant quelques mois, pendant quelque temps et puis il y a des choses que vous allez oublier c'est parfaitement normal. 

On n'est pas des robots et on ne peut pas tout retenir comme ça complètement et puis restitué la formation dans la seconde. 

N'ayez pas peur de vous servir de la documentation. 

Ne pas se servir de la documentation en programmation, ce n'est pas être un bon développeur et je vous le dis clairement. 

S'imaginer qu'on peut tout retenir de tête ce n'est pas possible ou alors vous allez devoir recréer des fonctions alors qu'elles existent déjà ils seront de toute façon beaucoup plus optimisé est-ce que vous vous doutez bien que ces fonctions là, on été pas mal modifiées et testées pour essayer d'avoir quelque chose le plus optimal possible même si elles ne sont pas parfaites. 

C'est comme tout mais il y a quand même plus de chance qu'à priori ça fonctionne la soient plus optimisée que les vôtres qu'est-ce qui vous amusé à les refaire vous-même en pensant que la foi qui sera en question n'existe pas de manière native. 

Donc pensez à consulter la documentation. 

Et vous avez également cette page là.

https://www.php.net/manual/fr/array.sorting.php

Cette page par des tris sur les tableaux avec les différents tris sur quoi ils se font, est-ce qu'ils se font sur la valeur ou sur les clés parce qu'on peut faire sur l'un ou l'autre. Ils se font également sur l'association des clé valeur, l'ordre de tri et cetera. Et on vous met la fonction qui correspond.
```txt
	+-----------+-----+-------------+--------+-----------+
	| Nom de la	| Tri | Association	| Ordre  | Fonctions |
	| fonction	| par | clé-valeur	| de tri | associé	 |
	+-----------+-----+-------------+--------+-----------+
```
Ça peut être très pratique aussi et si vous avez besoin de faire du tri de tableau parce que je sais que ça peut servir donc vous voyez qu'il y en a vraiment plusieurs disponibles. 

Donc n'hésitez pas à consulter ces 2 pages pour le tableau et tout est expliqué à ce niveau-là et comme ça vous allez pouvoir manipuler tout un tas d'informations.

Alors j'espère que ça a été suffisamment clair, c'est assez simple et ce n'est pas très compliqué à comprendre, je pense avoir été suffisamment explicite et d'avoir bien parlé sur ce nouveau type en tout cas ce type composé en PHP qui va énormément vous servir. C'est quelque chose qu'on manipule beaucoup. 

Alors attention comme pour les autres langages un tableau peut stocker énormément de quantité de données donc attention par exemple à ne pas faire un tableau qui va contenir 100000 informations parce que vous vous doutez bien que plus un tableau va être grand, et plus il va être lourd à gérer en termes d'exécution et en termes de ressources donc dans certains cas ne vous servez pas d'un tableau pour stocker des choses qui peuvent être mises dans un fichier voir dans une base de données comme on le verra plus tard d'accord. 

Les tableaux peuvent être utiles pour pas mal de choses mais ça a aussi un coût en terme d'exécution de manipuler des tableaux donc faites attention à ça, il y a des fois des choses qui sont plus rapides à faire si on fait des tests simples plutôt que d'utiliser par exemple des fonctions donc c'est à vous de vérifier et apprendre à optimiser un maximum vos programmes. 

Voilà s'il y a des questions par la suite concernant ces tableaux, n'hésitez à poser vos commentaires.

S'il y a des choses que vous voulez faire en particulier, allez-y et testez vos programmes et en plus avec les tableaux, l'avantage c'est qu'on peut faire plein de petits exercices mais moi évidemment parce que ce n'est pas fait au moment où je fais cette vidéo, je proposerai des exercices dans la playlist des exercices en PHP. Il y aura évidemment pas mal d'exercice que je vous proposerais qui vont permettre de manipuler des tableaux parce qu'on peut faire beaucoup de choses avec donc ça laisse vraiment l'occasion de s'exercer à énormément de types de programmes différents pour bien assimiler cette notion. 

Je vous dis à bientôt pour la suite de cette formation et la prochaine vie de nous aborderons autre chose en PHP. 

À bientôt tout le monde