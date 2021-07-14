# [11. Fonctions](https://www.youtube.com/watch?v=YCIMh2dH8AI)

Bonjour nous sommes sur la formation PHP et nous continuerons avec cette 11e séance pour aborder le concept des fonctions. 

Les fonctions vous vous en êtes servi jusqu à présent, vous en avez fait usage dans certaines des choses que vous avez abordé sur cette vidéo et là nous allons rentrer dans les détails sur ce type de concept là, vous l'expliquer et voir comment créez vos propres fonctions. 

Cette vidéo sera un peu longue parce qu'il y a vraiment beaucoup beaucoup de choses à voir je n'avais pas forcément envie de faire cette vidéo en 2 parties, ça évitera comme ça d'éparpiller les choses puisque tout est à voir de toute façon pour que vous puissiez après être à l'aise avec les fonctions en PHP. 

On va retourner sur notre code et on va d'abord aborder le principe de la fonction, donc la fonction si on devait donner un schéma comment est-ce qu'elle va fonctionner ? Elle va avoir un nom.
```php
<?php

/*
	- Une fonction possède un nom
*/

$number = 14;
echo gettype($number);
```
Si vous vous souvenez, on faisait un gettype() de `$number` et ça nous permettait d'avoir le type si j'actualise.
```txt
	http://localhost/PHP/cours/011_fonctions/
	integer
```
Voilà ça permet d'avoir le type de notre variable ici. 

Donc une fonction elle possède un nom qui permet de l'utiliser, par exemple ici c'est gettype son nom. 

Elle peut avoir des paramètres ou des arguments, vous appelez ça comme vous voulez. En général on appelle ça plutôt des paramètres, les arguments c'est plutôt quand on a quelque chose comme une commande dans un terminal (cmd quelque chose), suivi d'un espace et suivi de quelque chose avec des options qu'on appelle ça plutôt des arguments mais honnêtement le nom importe peu. Vous pouvez appeler ça des paramètres, des arguments ce que vous voulez.
```php
	/*
		- Une fonction possède un nom
		- Elle peut avoir des paramètres
	*/
```
Donc elle peut avoir des paramètres mais elle n'est pas obligée d'en avoir. On peut avoir des fonctions sans paramètres aussi et on va voir par la suite qu'on peut avoir des fonctions avec des valeurs dite par défaut qu'on leur met si les fonctions n'ont pas été renseigné voir même une infinité de paramètres qui sont passés lors d'un appel de fonction donc ça c'est des choses intéressantes à savoir.

Et une fonction peut retourner un résultat donc une donnée une valeur et cetera. Ce n'est pas obligatoire non plus, une fonction n'est pas obligée de retourner quelque chose.
```php
	/*
		- Une fonction possède un nom
		- Elle peut avoir des paramètres
		- Elle peut retourner un résultat
	*/
```
Donc cette fonction là par exemple si on prend l'exemple de gettype(), c'est une fonction dont le nom est gettype donc ça évidemment il a forcément un nom pour pouvoir l'utiliser. Elle a ici un paramètre qu'elle prend c'est-à-dire une variable, une information, une donnée et elle retourne le type donc son résultat, son retour c'est le type du paramètre qui lui a été donné donc là `$number` comme c'est un int, elle retourne bien integer. 

Si j'avais fait ça.  
```php
<?php

$number = true;
echo gettype($number);
```
Si vous vous souvenez, on faisait un gettype() de `$number` et ça nous permettait d'avoir le type si j'actualise.
```txt
	http://localhost/PHP/cours/011_fonctions/
	boolean
```
Si je fais ça comme ceci vous avez autre chose qui est retourné donc ça montre bien que le résultat quel retourne va dépendre ici de ce qu'on lui a passé en paramètre, elle va travailler avec ça. 

Voilà les choses à savoir vraiment minimum d'accord.

En général, ce qu'il faut savoir aussi au niveau des fonctions ce que les fonctions fonctionnent en développant leur propre contexte mais qu'est-ce que ça veut dire ? quand je suis à cet endroit là de mon code. 
```php
>	$number = true;
	echo gettype($number);
```
Là où j'ai créé la variable `$number`, je suis dans le contexte principal, on peut dire ça c'est-à-dire le contexte du fichier. 

Quand je vais utiliser gettype(), cette fonction là imaginez que c'est une boîte c'est-à-dire que gettype() vous ne savez pas comment il fait la fonction, vous ne savez pas quelle ligne de code il y a à l'intérieur pour qu'elle fasse tout ça c'est-à-dire qu'elle analyse ce qu'on lui passe en paramètre et qu'en fonction de ça elle soit capable de retourner le bon type.

Pourtant ça on n'a pas besoin de le savoir, tout ce qu'on doit savoir c'est le nom de la fonction, quels paramètres elle peut éventuellement prendre et dans quel ordre parce que l'ordre est important aussi, est-ce qu'elle peut retourner s'il y a un retour comme résultat.

À partir du moment où on sait ces 3 informations là, on peut utiliser une fonction et on n'a même pas besoin de savoir qu'est-ce que le développeur de la fonction gettype(), qu'est-ce qu'ils ont mis à l'intérieur de cette fonction pour qu'elle fasse ce qu'on lui demande. 

On s'en fiche enfaite parce qu'on n'a même pas besoin de savoir ce qu'il en est. 

C'est là le principe d'une fonction, imaginais ça comme une boîte qui contient plusieurs lignes de code. Votre fichier c'est un contexte et gettype() possède son propre contexte. 

À partir de ce moment-là ce qu'il faut comprendre, c'est que toutes les variables de chaque contexte sont indépendante, quand je vais ici créer `$number` à l'intérieur peut être … bien que je vais dire une bêtise parce que ce n'est pas le cas même. Mais même si on avait dans gettype() une variable qui possède exactement le même nom `$number` admettons qu'elle créerait une variable `$number` elle serait différente parce qu'elle ne serait pas stocké au même endroit dans la mémoire et elle n'aurait donc pas la même adresse enregistré en mémoire un peu comme une adresse postale qui permettrait de vous envoyer du courrier. Vous n'avez pas la même adresse même si vous êtes 2 personnes vivant à la même adresse ou même vivant dans la même ville. Vous avez des informations permettant de différencier malgré tout d'accord chacun a quand même sa propre identité quoi qu'il en soit. Et bien une variable, une donnée, elle a sa propre identité aussi dans ce contexte est une variable `$number` qui va être créé dans ce contexte là de mon fichier 'index.php' ne serait pas la même chose qu'une variable `$number` qui serait créé dans ce contexte là 'gettype()'.

D'ailleurs quand je vais passer `$number` à la fonction gettype(), ça va créer une copie on dit que c'est un passage par valeur mais on va revenir un petit peu dessus en détail. C'est pour ça que je vous dis que cette vidéo est un petit peu longue parce qu'il y a vraiment beaucoup de choses à retenir donc vraiment soyez attentif et prenez des notes si nécessaire, mettez sur pause et regarder la vidéo en plusieurs fois si vous voulez la voir en plusieurs fois et pas regarder tout d'un coup, vous pouvez ça ne posera pas de problème donc gérer le visionnage de cette vidéo comme vous le voulez histoire de vraiment tout bien assimiler parce que chaque chose que je vais vous dire est importante. Il n'y a rien qui est superflu, tout vous sera utile pour la suite. 

Si vous avez compris cette vidéo là, ça va vous faire énormément gagner du temps par la suite quand on va commencer à faire de l'objet. 

Donc cette partie là ce qu'il faut savoir, c'est qu'ici je fais un passage par valeur.
```php
	$number = true;
>	echo gettype($number);
```
Donc on va créer une copie de `$number` c'est à dire qu'on va créer une nouvelle variable mais elle va porter le même nom sauf que le `$number` qui appartient à gettype() même si elle a le même nom après le `$`, ça ne sera pas la même variable number qu'ici.
```php
>	$number = true;
	echo gettype($number);
```
Après le `$`, ce n'est pas la même variable `$number` qu'ici donc la fonction va utiliser cette copie et en fonction elle va utiliser un résultat et une fois qu'on sort de la fonction gettype(), qu'on fait le retour du résultat, toutes les variables qui ont pu être créées et utilisées dans gettype() sont détruites, y compris les copies qu'on aurait passé par valeur en tant que paramètre pourtant vous voyez que le `$number`-là n'est pas détruit pour autant.
```php
>	$number = true;
	echo gettype($number);
```
Cette variable `$number` n'est pas détruite pour autant parce que ce sont 2 variables différentes donc voilà comment ça fonctionne, imaginer des petites boîtes. 

Chaque fonction est comme une petite boîte qui peut avoir des paramètres ou des variables qu'elle créé elle-même et qui appartiennent qu'à elle et quand on quitte la fonction, qu'on fait un retour de quelque chose donc ça c'est-à-dire qu'on retourne un résultat …
```php
	/*
		- Une fonction possède un nom
		- Elle peut avoir des paramètres
>		- Elle peut retourner un résultat
	*/
```
Tout ce qui a été créé ou passé en paramètre dans cette fonction est détruit donc libérer de la mémoire, ça n'existe plus à ce moment-là donc là variable ici $number dans gettype(), une fois qu'on fait le retour elle sera libéré de la mémoire et il restera que celle là :
```php
>		$number = true;
```
Il n'y aura plus cette copie là qui aura été faite au niveau de l'appel :
```php
>		echo gettype($number);
```
Et ça on va l'expliquer en détail avec des exemples de code et vous allez comprendre pourquoi ça fonctionne comme ça donc la première chose du coup a voir c'est tout ça c'est-à-dire qu'il y a beaucoup d'informations à prendre en compte. 

Au niveau des fonctions utilisées, Eh bien quand vous vous servez d'une fonction notamment en passant par la documentation si vous voulez, on l'a déjà vu en faisant doc php comme recherche et on va aller regarder sur gettype(), on va prendre cet exemple là c'est-à-dire une fonction qu'on a déjà manipulée. 

https://www.php.net/manual/fr/function.gettype.php

Plus tard si vous avez besoin d'aller dans la doc de PHP pour chercher une fonction en particulier, vous voyez vous avez même du coup le français pour ceux qui ont du mal avec l'anglais donc c'est vrai que là doc de PHP là tu es vraiment très bien faites. 

Tout n'est pas traduit à 100 pour 100 mais il y a une grosse majorité qu'il l'est et voilà ce que ça nous dit tout simplement. 

Ça nous donne une description de la fonction.  

Donc son nom déjà c'est quand même le plus important : `gettype`

Ce qu'elle fait : Retourne le type de la variable 

Parce que rappelez vous, une bonne fonction n'est censé faire qu'une seule chose à la fois et ça c'est très important. Ici elle retourne le type d'une variable. 

Ensuite vous avez plein d'informations, vous avez son nom et les paramètres dont elle peut avoir besoin : `gettype ( mixed $var ) : string`

Donc là `mixed` c'est un terme utilisé par la doc de PHP pour dire que ça peut être n'importe quel type parce qu'on a besoin de savoir justement le type de la donnée donc vous pouvez lui passer n'importe quoi, une variable donc là ça s'appelle `$var` parce que le nom on s'en fiche, vous lui passer en fonction mais là vous voyez que moi c'est `$number` mais peut-être que vous dans votre code là variable s'appellera autre chose donc c'est pour ça que c'est un nom générique ici qu'ils mettent. 

Elle va retourner une 'string' donc une chaîne de caractères donc ce que vous voyez affiché là 'boolean' c'est une chaîne, c'est un simple texte que ce soit 'boolean', 'integer' et cetera. 

Voilà partir du moment où vous savez ça, que vous connaissait ce qu'on appelle la signature de la fonction, le prototype de la fonction, vous connaissez son nom et vous avez simplement à l'utiliser en fonction de ce qui est dit et de voir ce qu'elle fait et comment elle fonctionne. 
```php
	gettype ( mixed $var ) : string 			= signature
```
C'est la seule chose qui est nécessaire à savoir pour utiliser les fonctions dites interne donc des fonctions qui ont été créés en PHP et il y en a beaucoup par exemple ici on n'a pas mal de fonctions de gestion de variables sur la droite de la page :  
```txt
	Fonctions de gestion des variables
	boolval
	debug_​zval_​dump
	doubleval
	empty
	floatval
	get_​defined_​vars
	get_​resource_​type
	gettype
	intval
	is_​array
	is_​bool
	is_​callable
	is_​countable
	is_​double
	is_​float
	is_​int
	is_​integer
	...
```
Voilà il n'y a tout ça pour la gestion de variables, on retrouve d'ailleurs les fameuses fonctions qu'on a vu la dernière fois aussi, le is_int() par exemple c'est pareil qui permet de déterminer si une variable de type nombre entier.
```php
	is_int ( mixed $var ) : bool
```
Elle prend une variable en paramètre qu'elle qu'elle soit donc un seul paramètre qui est obligatoire ce paramètre, on est obligé de le renseigner et elle va retourner un booléen et le retour c'est ça.
```txt
	Retourne TRUE si var est un entier, FALSE sinon.
```
Elle vous met TRUE si `$var` est un entier, FALSE sinon donc c'est très simple à comprendre et du coup ça va être très simple à utiliser. 

Voilà comment ça fonctionne au niveau de comment est défini en tout cas il ne fonction. 

Alors une fonction, elle a plusieurs choses, elle peut très bien ne prendre aucun paramètre et on va justement commencé à créer nos propres fonctions d'accord on va faire de la création de fonctions nous-mêmes pour voir comment ça s'agence ensemble. 

Donc je vous ait présenté les fonctions, je vous aime montrer comment utiliser des fonctions déjà existantes donc ce qu'on appelle en général les fonctions internes donc les fonctions qui ont été créée pour PHP ou éventuellement dans d'autres bibliothèques que vous utiliserez mais maintenant nous allons créer les nôtres. 

On va faire la fonction la plus simple qui soit, la fonction la plus simple qui soit elle n'aurait aucun paramètre et elle ne ferait aucun retour donc c'est-à-dire qu'elle aurait juste un nom alors qu'elle va faire des choses à l'intérieur mais elle va jamais demander d'avoir des informations qu'on lui donne et elle ne va jamais rien retourner.
```php
	/*
>		- Une fonction possède un nom
		- Elle peut avoir des paramètres
		- Elle peut retourner un résultat
	*/
```
Elle ne va jamais rien retourner, alors un exemple tout bête, on va l'appeler par exemple la fonction Hello. 

Pour créer une fonction en PHP, il faut mettre le mot clé 'function' en anglais, vous mettez hello() et même si vous ne prenez pas de paramètres avec rien dedans, des parenthèses vide et ensuite on ouvre des accolades, c'est comme pour une condition ou une boucle, vous voyez c'est un contexte et là on se retrouvera dans le contexte de la fonction.
```php
	function hello()
	{
>		
	}
```
Et là nous sommes dans le contexte de la fonction, tout ce qui va être créée là dedans en termes de variables ou les variables qui seraient passés en copie ici seront à la fin supprimer de la fonction. 

Une fois qu'on aura quitté la fonction, elles seront supprimées, elles seront libérer de la mémoire.

Donc voici une fonction très simple où je dis Bonjour.
```php
	function hello()
	{
		echo "Bonjour !";
	}
```
Là j'ai défini, on dit que j'ai fait une définition de fonction. Elle est définie donc elle existe dans mon contexte ici.

Pour l'utiliser on fait tout ce que vous avez déjà appris dernièrement, comment s'appelle la fonction ? hello donc on met hello et on l'appelle donc là je vais faire mon appel de fonction.
```php
	function hello()
	{
		echo "Bonjour !";
	}
	
	//Appel de la fonction
	hello
```
Alors prend t-elle des paramètres ? non donc on met tout simplement des parenthèses vide et on finit par un `;` parce que c'est une fin d'instruction.
```php
	function hello()
	{
		echo "Bonjour !";
	}
	
	//Appel de la fonction
	hello();
```
Comme elle ne retourne rien nous n'avons pas besoin de faire `$result = hello()` et de dire je récupère le retour de la fonction, ça on verra tout à l'heure dans un cas particulier. 

Voilà comment ça fonctionne, j'actualise ici et voilà que la fonction affiche.
```php
<?php

function hello()
{
	echo "Bonjour !";
}

//Appel de la fonction
hello();
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	Bonjour !
```
Et voilà la fonction affiche donc ça c'est une fonction toute bête c'est-à-dire qu'elle affiche simplement Bonjour, elle fait juste ça.

Elle ne prend aucun paramètre et elle ne retourne aucun résultat donc ça c'est des choses à savoir au niveau de PHP pour la création de votre fonction.

Ça c'est le cas pour la fonction la plus simple du monde, aucun paramètre et aucun retour à la fin. 

Au niveau des paramètres dans le cas où on aurait des paramètres précis, on va avoir plusieurs cas alors déjà il peut y avoir qu'un seul paramètre puis en avoir 2, 3 et cetera et même une infinité … et différent cas possible, alors le cas par défaut ça va être un paramètre dit fixe qui est obligatoire, on va lui passer par exemple `$name` donc `hello($name)`. 
```php
	function hello($name)
	{
		...
	}

	//Appel de la fonction
	hello(..);
```
Et on fera tout simplement ce que vous avez déjà appris à faire comme ceci.
```php
	function hello($name)
	{
		echo 'Bonjour '.$name;
	}

	//Appel de la fonction
	hello(...);
```
Elle va prendre un paramètre obligatoire donc vous voyez qu à ce moment-là le fonctionnement va différer et donc on va devoir lui passer une information.
```php
<?php

function hello($name)
{
	echo 'Bonjour '.$name;
}

//Appel de la fonction
hello("Jason");
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	Bonjour Jason
```
Ici une information, j'actualise et voilà comment elle se comporte donc c'est très simple, vous pouvez le transformer comme ça une fonction pour qu'elle ait un fonctionnement différent.

Un paramètre comme ça on peut également le rendre, lui donner une valeur par défaut alors une valeur par défaut va s'écrire comme ceci avec un égal et vous mettez quelque chose entre guillemets par exemple ça.

Elle va prendre un paramètre obligatoire donc vous voyez qu à ce moment-là le fonctionnement va différer et donc on va devoir lui passer une information.
```php
	function hello($name = "Henri")
	{
		echo 'Bonjour '.$name;
	}

	//Appel de la fonction
	hello("Jason");
```
Par exemple ça et là vous allez avoir 2 cas figures soit vous avez renseigné le paramètre qui est demandé mais dans ce cas là ça va afficher sur votre paramètre à vous mais si on en a pas renseigné et bien elle va prendre l'élément qu'on a mis par défaut. 
```php
<?php

function hello($name = "Henri")
{
	echo 'Bonjour '.$name;
}

//Appel de la fonction
hello();
```
Comme on n'a pas renseigné de `$name`, Eh bien par défaut on va lui mettre la valeur "Henri" évidemment ça fonctionnera.
```txt
	http://localhost/PHP/cours/011_fonctions/
	Bonjour Henri
```
Donc ça c'est un passage par valeur avec une valeur par défaut.

D'accord ce sont des choses à savoir.

Alors pourquoi passage par valeur parce que encore une fois comme ceci … alors là on fait d'abord l'appel alors qu'ici on est dans le contexte du fichier autrement on pourrait être dans le contexte de la fonction. Si je fais ça :
```php
<?php

function hello($name)
{
	echo 'Bonjour '.$name;
}

$name = "Jason";
//Appel de la fonction
hello($name);
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	Bonjour Jason
```
On exécute on obtient le même résultat sauf qu'ici on est passé par une variable intermédiaire. 

Encore une fois cette variable `$name` ici qui est définie dans ces 3 lignes donc dans le contexte de mon fichier.
```php
	function hello($name)
	{
		echo 'Bonjour '.$name;
	}

>	$name = "Jason";
>	//Appel de la fonction
>	hello($name);
```
La variable `$name` défini dans le contexte de mon fichier n'est pas la même qu'ici.
```php
>	function hello($name)
	{
		echo 'Bonjour '.$name;
	}

	$name = "Jason";
	//Appel de la fonction
	hello($name);
```
Cette variable `$name` est différente, comment est-ce que je peux vous le montrer et bien Regardez comme ceci, je vais changer `$name` dans la fonction et je vais l'afficher dans mon contexte de fichier.
```php
<?php

function hello($name)
{
	$name = "Julien";
	echo 'Bonjour '.$name.'<br>';
}

$name = "Jason";
//Appel de la fonction
hello($name);
echo $name;
```
Je crée un site variable `$name` Jason. J'appelle ma fonction qui va afficher 'Bonjour…' et ensuite j'appelle le `$name` dans le contexte de mon fichier il regardait ce qu'on obtient.
```txt
	http://localhost/PHP/cours/011_fonctions/
	Bonjour Julien
	Jason
```
On obtient 2 valeurs différentes donc ça montre bien que les 2 variables ici.
```php
	function hello($name)
	{
>		$name = "Julien";
		echo 'Bonjour '.$name.'<br>';
	}

>	$name = "Jason";
	//Appel de la fonction
	hello($name);
	echo $name;
```
Ces 2 variables ne sont pas les mêmes, même si elles ont le même nom c'est une copie précise.

Imaginez que ça
```php
	function hello($name)
	{
		$name = "Julien";
		echo 'Bonjour '.$name.'<br>';
	}
```
…est une petite boîte qui est à part donc tout ce qui est à l'intérieur ne lui appartient qu'à elle et une fois qu'on a quitté cette fonction, la variable `$name` qui contient "Julien" pour le coup a été détruite donc elle n'a absolument rien à voir avec `$name` qui contient "Jason" qu'on affiche tout à la fin. 

Et à l'appel `hello($name)`, le nom qui a été passé ici dans la copie : function `hello($name)` … ce nom `$name` quand il a été passé dans la copie a été changé au moment où on a fait cette ligne là.
```php
	function hello($name)
	{
		$name = "Julien";
>		echo 'Bonjour '.$name.'<br>';
	}

	$name = "Jason";
	//Appel de la fonction
	hello($name);
	echo $name;
```
Changer la valeur de $name donc attention à ça pour ce qu'on appelle la portée des variables.

Ne pensez pas pouvoir modifier une variable qui se trouve ici dans ce contexte-là.
```php
	function hello($name)
	{
		$name = "Julien";
		echo 'Bonjour '.$name.'<br>';
	}

>	$name = "Jason";
	//Appel de la fonction
	hello($name);
	echo $name;
```
Par exemple je vais montrer un cas tout bête et que vous faites comme ceci.
```php
<?php

function modify_variable($var)
{
	$var = "hacked";
}

$var = "OK";
modify_variable($var);
echo $var;
```
Vous voyez je lui passe `$var` en disant que je vais modifier à priori comme le nom est le même, je vais modifier `$var` qui possède au départ "OK" par la valeur "hacked" et après j'essaye de l'afficher, et comme ça de manière naïve on penserait qu'elle prendrait cette valeur là "hacked" et pourtant vous allez voir que non.
```txt
	http://localhost/PHP/cours/011_fonctions/
	OK
```
Alors de manière naïve, on penserait qu'elle prendrait la valeur "hacked" et pourtant vous avez vu que non puisque ici on a créé une copie de `$var` qui appartenait à la fonction, qui était dans la portée de la fonction et quand on arrive à l'accolade fermante de la fonction, cette variable `$var` est détruite donc elle a absolument rien à voir avec le `$var` dans le contexte du fichier donc ça c'est vraiment important et j'insiste bien dessus parce que c'est un club qui rend les choses compliquées au départ quand on a du mal et pour lequel vous êtes sujet à beaucoup d'erreurs en pensant que ce que vous allez modifier dans une fonction va se modifier partout ailleurs et ce ne sont pas des variables globales, ce sont des variables qui appartiennent à leur contexte.

Et chaque fonction à son propre contexte comme si c'était une petite boîte indépendante, comme une petite maison où vous pouvez rentrer par la porte. Vous avez une porte de sortie éventuellement quand on fait un return de quelque chose par contre tout ce qui se passe à l'intérieur reste à l'intérieur dans tous les cas. Si on n'a rien à faire sortir de précis ça restera. 

Là où ça pourrait changer, c'est en faisant éventuellement un retour. 

Si on veut retourner un résultat, on va utiliser le mot 'return' en faisant ça.
```php
	function modify_variable($var)
	{
		$var = "hacked";
			
>		return $var;
	}

	$var = "OK";
	modify_variable($var);
	echo $var;
```
Et à partir du moment vous avez un return, vous avez une porte de sortie dans quelque chose qui peut être éventuellement récupéré. 

Donc vous avez 2 choses possibles, soit vous faites un appel comme je l'ai fait ici.
```php
	echo $var;
```
Et dans ce cas-là vous n'avez rien à modifier parce que ce return dans le contexte de ma fonction c'est-à-dire la variable $var vous allez la perdre parce que vous la récupérez nulle part. 

Par contre si je fais ça et que je dis dans `$var`, je lui affecte le retour de la fonction modify_variable().
```php
	function modify_variable($var)
	{
		$var = "hacked";
			
		return $var;
	}

	$var = "OK";
>	$var = modify_variable($var);
	echo $var;
```
Imaginez une petite flèche entre la copie, la valeur de `$var` va être affecté au `$var` dans le contexte de mon fichier et là pour le coup on aura modifié la donnée.
```php
<?php

function modify_variable($var)
{
	$var = "hacked";
	
	return $var;
}

$var = "OK";
$var = modify_variable($var);
echo $var;
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	hacked
```
Donc là pour le coup on aura modifié le donnée parce qu'on aura en fait fait une récupération d'information qu'on aura affecté dans `$var` dans le contexte de mon fichier. 

Voilà comment on fait un retour, comment on retourne un résultat dans une fonction, ça peut être n'importe quoi : une chaîne de caractères, un nombre, un tableau comme on verra plus tard, un objet même si on veut, voilà on peut retourner vraiment retourner tout et n'importe quoi donc c'est plutôt pratique. 

Ce n'est pas vraiment le cas donc des langages un peu plus bas niveau que PHP donc c'est plutôt sympa à savoir. 

Voilà comment ça se passe pour le return. 

À partir du moment où vous faites un return, la fonction se termine d'accord c'est obligatoire. 

Une fois que vous faites le return, ça veut dire que tu sors de la fonction en retournant quelque chose donc là si tu retournes `$var` donc tu retourne la chaîne de caractères "hacked" et tu quitte la fonction donc c'est pour ça que que dans le contexte du fichier, il faut la récupérer dans quelque chose. 

On peut même d'ailleurs directement faire que ça comme la vie tout à l'heure directement avec gettype() en faisant ça.
```php
<?php

function modify_variable($var)
{
	$var = "hacked";
	
	return $var;
}

$var = "OK";
echo modify_variable($var);
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	hacked
```
Ça fait exactement la même chose parce qu'on lui dit tu affiches modify_variable() de `$var`, et comme elle retourne quelque chose tu affiche enfaite "hacked" c'est exactement ce que montre ce code là donc ça fonctionne aussi. 

Vous n'êtes pas obligé de passer par une variable intermédiaire, vous pouvez procéder comme vous voulez.

Voilà pour le retour de résultats, une petite chose à connaître. 

Alors on va revenir sur les paramètres parce qu'on a vu le cas où on a aucun paramètre, on a vu le cas où on a un paramètre obligatoire, on a vu le cas avec un paramètre et valeur par défaut mais on peut avoir plusieurs paramètres évidemment c'est-à-dire qu'on peut très bien avoir ceci. 
```php
	function ma_fonction($nb1, $nb2)
	{
		return $nb1 + $nb2;
	}
```
Est-ce qu'on peut faire un return de `$nb1 + $nb2` ? On peut retourner un calcul évidemment, le return vous pouvez retourner une expression donc ça peut être une autre fonction.

Vous pouvez par exemple retourner à l'appel à une autre fonction, vous pouvez retourner une valeur en dur, vous pouvez retourner une variable ou encore une fois une expression c'est-à-dire une opération sur plusieurs variables et valeurs. On peut très bien s'amuser à faire ça, c'est tout à fait possible. 
```php
	function ma_fonction($nb1, $nb2)
	{
		return $nb1 + $nb2 * 3;
	}
```
On pourrait faire aussi par exemple une autre fonction.
```php
	function ma_fonction($nb1, $nb2)
	{
		return $nb1 + $nb2 * 3 + une_autre_fonction($nb1);
	}
```
Ça peut se faire évidemment, n'oubliez pas qu'une expression … c'est comme pour ce qu'on a vu la dernière fois sur les conditions, les IF, les boucles, on peut mettre absolument tout ce que l'on veut dedans comme un appel d'une fonction, des valeurs en dur (3) ou des variables (`$nb1`,..) ça fonctionnera évidemment. 

Alors pour le cas de tout à l'heure, on va revenir sur cet ancien cas plutôt que de parler pour l'instant du nombre de paramètres. Je vous avais dit que quand on note une variable en faisant $number par exemple.
```php
	function ma_fonction($number)
	{
		
	}
```
On va créer `$number = 14;`, on va appeler ma_fonction() et on aimerait que ça modifie la variable par 6.
```php
<?php

function ma_fonction($number)
{
	$number = 6;
}

$number = 14;
ma_fonction($number);
echo $number;
```
On a envie de changer `$number` par 6 mais le problème c'est que c'est une copie et comme je vous l'ai dit tout à l'heure ça ne va pas se modifier.
```txt
	http://localhost/PHP/cours/011_fonctions/
	14
```
Voilà ça ne va évidemment pas modifier parce que ça … c'est une copie parce qu'on a fait un passage par valeur ici : `ma_fonction($number)`.
```php
>	function ma_fonction($number)			< Passage par valeur
	{
>		$number = 6;						< Copie
	}

>	$number = 14;
	ma_fonction($number);
	echo $number;
```
Un passage par valeur c'est qu'on passe directement à l'appel de la fonction, on lui donne directement la variable et c'est tout. 

On peut procéder par un autre fonctionnement c'est-à-dire que si on ne veut pas faire un passage par valeur, on peut faire un passage par référence et on en a parlé la dernière fois avec les variables en mettant le petit &, et commercial, l'esperluette comme ceci.
```php
>	function ma_fonction(&$number)			< Prendre l'endroit en mémoire où se trouve $number
	...
```
Là qu'est-ce qu'il va se passer ? au lieu de dire de créer une copie ici.
```php
>	function ma_fonction($number)			< Créer une copie
	...
```
On va enfaite prendre l'endroit en mémoire où se trouve `$number` dans le contexte de mon fichier. 

Et là le fonctionnement sera différent.
```php
<?php

function ma_fonction(&$number)
{
	$number = 6;
}

$number = 14;
ma_fonction($number);
echo $number;
```
```txt	
	http://localhost/PHP/cours/011_fonctions/
	6
```
Vous voyez que ça a bien modifier la variable parce qu'on n'a pas créé une copie de la donnée mais on a fait référence à celle qui existe déjà en mémoire donc ça ce sont vraiment des choses importantes à savoir. 

On parle de 2 passages : passage par valeur et passage par adresse comme on dirait dans un langage bas niveau mais en PHP on dit passage par référence. 

Et pour faire un passage par référence c'est ça, pour ceux qui font du c ça correspondrait à passer un pointeur, c'est un petit peu le même fonctionnement à quelques exceptions près mais dans l'ensemble c'est un peu le même fonctionnement quel l'usage des pointeurs dans un langage comme le c pour ceux qui ont déjà fait de la programmation en c.

Grâce à ça on va effectivement … et là vous voyez qu'on n'a pas besoin de remettre le symbole esperluette à nouveau dans le contexte de la fonction … on va effectivement modifier `$number` dans le contexte du fichier parce que à ce moment-là le `$number`, dans le contexte de ma fonction, est une référence vers `$number` dans le contexte de mon fichier donc ils acceptent tous les 2 la même adresse en mémoire donc effectivement la même variable grâce au passage par référence (&). 

Donc ça attention, vous avez passage par valeur, passage par référence. 

Un passage par valeur fait une copie de l'information.

Un passage par référence se réfère à l'information, et va directement y accéder en mémoire, et là il possède l'adresse où elle se trouve c'est-à-dire l'emplacement donc c'est 2 cas différents. 

Alors c'est vraiment très important ce que je vous donne le niveau des paramètres au PHP.

Depuis PHP 7, on a des nouveautés c'est pour ça que je voulais qu'on programme en PHP 7.

Vous savez qu'un PHP le typage est dit dynamique d'accord il ne sera pas indiqué mais par exemple c'est l'interpréteur qui va déduire les types des informations mais depuis PHP 7 si vous voulez quand vous passez par exemple des paramètres, vous pouvez forcer le typage des informations. 

S'il a par exemple pour `$number`, vous voulez absolument int, un integer, vous allez lui renseigner le type de données en faisant tout simplement comme ça.
```php
	function ma_fonction(int $number)
	{
		$number = 6;
	}

	$number = 14;
	ma_fonction($number);
	echo $number;
```
Alors les types de paramètres je vais vous les noter parce qu'il y a une petite distinction et il ne faut pas faire d'erreur.

Vous allez avoir array pour le tableau, callable pour les fonctions de retour mais on en parlera aussi plus tard. Vous avez bool pour les booléens. Vous avez int pour les entiers. Vous avez float pour les nombres à virgule, les décimaux. Et vous avez string pour les chaînes de caractères.
```php
	/*
		Types de paramètres : 
			array
			callable
			bool		!= boolean
			int 		!= integer
			float
			string
	*/
```
Petite parenthèse, il ne faut surtout pas utiliser boolean.

Boolean notamment pour les types de paramètres dans une fonction. 

Pour int, c'est pareil n'utilisait pas le integer, pourquoi ? parce qu'ils ne seront pas considérés comme des types scalaires … c'est ce qu'on a vu récemment sur les types de variables … mais comme des objets c'est-à-dire qu'un objet … et ça on n'en a pas encore parlé sur cette formation.

Boolean est un objet.

Attention si vous mettez ça integer $number, ça ne se comportera pas du tout de la même manière donc là il va attendre un objet, une instance de la classe integer.
```php
<?php

function ma_fonction(integer $number)
{
	$number = 6;
}

$number = 14;
ma_fonction($number);
echo $number;
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	Fatal error: Uncaught TypeError: Argument 1 passed to ma_fonction() must be an instance of integer, int given, called in ...
```
Voilà on a une exception *TypeError* qui est levée donc évidemment ça ne fonctionnera pas donc attention à utiliser absolument que ces types là quand vous voulez spécifier le type de paramètre d'une fonction, c'est absolument important.
```php
<?php
	/*
		Types de paramètres : 
			array
			callable
			bool		!= boolean
			int			!= integer
			float
			string
	*/

function ma_fonction(int $number)
{
	$number = 6;
}

$number = 14;
ma_fonction($number);
echo $number;
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	14
```
Pas de boolean, pas de integer, c'est bool ou int tout simplement.

En plus ça s'écrit plus vite alors autant faire comme ça. 

Et là évidemment ça fonctionne. 

Alors grâce à ce typage (int) si j'essaye de faire un cast de 14.0.
```php
<?php

function ma_fonction(int $number)
{
	$number = 6;
}

$number = 14.0;
ma_fonction($number);
echo $number;
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	14
```
Voilà il le prend en compte parce que c'est un cast pour le coup mais c'est du coup j'essaie de lui passer n'importe quoi comme une chaîne de caractères évidemment il va mettre un TypeError.
```php
<?php

function ma_fonction(int $number)
{
	$number = 6;
}

$number = "OK";
ma_fonction($number);
echo $number;
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	Fatal error: Uncaught TypeError: Argument 1 passed to ma_fonction() must be of the type int, string given, called in ...
```
Évidemment il me met un TyppeError alors que si je n'avais pas mis en cast.
```php
<?php

function ma_fonction($number)
{
	$number = 6;
}

$number = "OK";
ma_fonction($number);
echo $number;
```	
```txt
	http://localhost/PHP/cours/011_fonctions/
	OK
```
On va mettre un passage par référence tant qu'à faire.
```php
<?php

function ma_fonction(&$number)
{
	$number = 6;
}

$number = "OK";
ma_fonction($number);
echo $number;
```	
```txt
	http://localhost/PHP/cours/011_fonctions/
	6
```
Regardez ça aurait fonctionné mais alors pourquoi est-ce que ça aurait fonctionné ? 

Parce que il s'en fiche à ce moment-là du type de données. On lui dit juste de récupérer une donnée et après tu lui mets la valeur 6. Au début on a une chaîne de caractères avec le mot "OK" à l'intérieur mais maintenant tu remplaces une chaîne de caractère par an entier 6 donc là il s'en fiche des types.

Et c'est pour vous le type est important parce que vous voulez vérifier les données avec lequel vous travaillez, vous pouvez passer le type de paramètre en mettant le petit mot clé (int) qui correspond en fonction de ce que vous voulez. 
```php
<?php

function ma_fonction(int $number)
{
	$number = 6;
}

$number = "OK";
ma_fonction($number);
echo $number;
```
```txt	
	http://localhost/PHP/cours/011_fonctions/
	Fatal error: Uncaught TypeError: Argument 1 passed to ma_fonction() must be of the type int, string given, called in ...
```
Donc là on travaille absolument qu'avec des int et si on ne le fait pas on obtient une erreur donc ça oblige à respecter le type de l'information. 

Si je met en boule et on se sera pareil, il va le prendre automatiquement comme un entier. 
```php
<?php

function ma_fonction(int $number)
{
	$number = 6;
}

$number = true;
ma_fonction($number);
echo $number;
```	
```txt
	http://localhost/PHP/cours/011_fonctions/
	1
```
Vous voyez comme un entier automatiquement parce que un booléen, il peut le caster donc s'il peut caster l'information il va la caster et s'il ne peut pas il va retourner une erreur donc voilà à ce niveau là pour cette partie. 

Alors on a parlé d'un passage par valeur, on a parlé de passage par référence, on a parlé également des arguments qui peuvent avoir des valeurs par défaut comme on l'a vu. 

Attention notamment pour les valeurs par défaut c'est à dire que vous pouvez très bien faire ça.
```php
	function ma_fonction($var1 = "ok", $var2 = "truc")
	{

	}
```
Vous pouvez également faire ça ça fonctionnera aussi, pourquoi ? parce qu'il vous dit que le `$var1` est obligatoire c'est à dire que quand vous allez faire l'appel à votre fonction vous allez obligatoirement lui mettre une info pour `$var1` par contre vous n'êtes pas obligé de mettre quelque chose pour `$var2` puisqu'il y a une valeur par défaut.
```php
	function ma_fonction($var1, $var2 = "truc")
	{
		//du code ...
	}
	
	ma_fonction(14)
```
L'appel de cette fonction peut se faire de 2 manières différentes soit comme ça.
```php
	function ma_fonction($var1, $var2 = "truc")
	{
		//du code ...
	}
	
	ma_fonction(14)
	//ou
	ma_fonction(14, "Bonjour")
```
À la rigueur comme on voit que c'est une chaîne, on peut être plus précis en faisant comme ça.
```php
>	function ma_fonction(int $var1, string $var2 = "truc")
	{
		//du code ...
	}
	
	ma_fonction(14)
	//ou
	ma_fonction(14, "Bonjour")
```
Donc ce type de fonction parce que j'essaie de simplifier un maximum les exemples pour que ce ne soit pas trop compliqué pour vous parce qu'il y a déjà beaucoup de choses avant donc on va rester simple, vous avez un paramètre obligatoire `$var1`, il est obligatoire parce qu'il n'y a pas de valeur par défaut. Et on a un autre paramètre `$var2` qui a dit optionnel. 

À partir du moment vous avez une valeur par défaut qui est donné sur une variable, on considère que c'est un paramètre optionnel. On n'est pas obligé de le renseigner et du coup cette fonction peut être appelée de 2 manières différentes, ça va fonctionner.
```php
	ma_fonction(14)
	//ou
	ma_fonction(6, "Bonjour")
```
On passe le paramètre obligatoire dans tous les cas, on peut mettre n'importe quelle valeur et ça fonctionnera aussi bien sûr (14, 6, …) et le paramètre ici string est optionnel et donc si je ne le passe pas il mettra "truc". Et si je le passe, il mettra ce que j'ai mis "Bonjour" d'accord. 

En revanche je ne pouvais pas faire l'inverse, vous ne pouvez pas faire ça. 
```php
>	function ma_fonction(int $var1 = 6, string $var2)
	{
		//du code ...
	}
	
	ma_fonction(14)
	//ou
	ma_fonction(14, "Bonjour")
```
Vous ne pouvez pas mettre un paramètre optionnel au départ est un paramètre obligatoire derrière, pourquoi ? Tout simplement pour une question d'ordre parce que dans la mesure où vous faites ça …
```php
	function ma_fonction(int $var1 = 6, string $var2)
```
…il ne sera pas dans quel ordre il faut les informations parce que le premier paramètre est optionnel. 

Alors comment sait-il par exemple en passant ça ... 
```php
	ma_fonction(14)
```
… Comment va-t-il savoir quel élément est fonctionnel et quels paramètres avez-vous voulu passer parce que comme le premier argument, l'entier, n'est pas obligatoire qu'est-ce qui nous dit qu'il va pas prendre 14 comme étant la chaîne parce que après tout le 2e argument n'est pas obligatoire comme paramètre. 

Et donc si je teste vous allez voir que ça ne va pas.
```php
<?php

function ma_fonction(int $var1 = 6, string $var2)
{
	//du code ...
}

ma_fonction(14);
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	Fatal error: Uncaught ArgumentCountError: Too few arguments to function ma_fonction(), 1 passed in ...
```
Donc là vous voyez que ça ne va pas, il vous met *ArgumentCountError* parce qu'il y a un nombre d'arguments passé qui n'est pas correct. 

En revanche je reviens sur le code de tout à l'heure, là ça ne pose aucun problème. 
```php
<?php

function ma_fonction(int $var1, string $var2 = "truc")
{
	//du code ...
}

ma_fonction(14);
ma_fonction(6, "bonjour");
```
```txt
	http://localhost/PHP/cours/011_fonctions/
```
Là ça ne lui posera pas de problème, aucune erreur, c'est normal parce qu'il sait qu'il doit obligatoirement avoir un premier paramètre dans tous les cas vous ne pouvez pas faire un appel comme ça. 
```php
	ma_fonction();
```
Ça ce n'est pas possible parce qu'il prend le premier élément obligatoirement donc là on va aussi avoir un problème.
```php
<?php

function ma_fonction(int $var1, string $var2 = "truc")
{
	//du code ...
}
ma_fonction();
ma_fonction(14);
ma_fonction(6, "bonjour");
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	Fatal error: Uncaught ArgumentCountError: Too few arguments to function ma_fonction(), 0 passed in ...
```
Donc ça ce n'est pas possible mais les 2 appels suivant sont tout à fait possibles puisque le 2e paramètre de la fonction est optionnel, facultatif, il n'est pas obligatoire pour faire son appel. Il n'y a que le premier paramètre qui l'est donc attention mais toujours les éléments obligatoires en premier. 

Tous les paramètres obligatoires doivent être mis en premier dans la fonction et les paramètres optionnels même s'il y en a plusieurs même s'il y en a un autre.
```php
	function ma_fonction(int $var1, string $var2 = "truc", string $var3 = "muche")
	{
		//du code ...
	}
	ma_fonction(14);
	ma_fonction(6, "bonjour");
```
Ici vous pouvez les faire aussi parce qu'ils sont optionnels donc il n'y a pas de problème mais il faut qu'ils soient mis à la fin. 

C'est toujours les obligatoires en premier et les paramètres optionnels à la fin. 

Voilà un petit peu ce qu'il faut savoir à ce niveau-là donc ça c'était le point à connaître qui peut servir. 

On va maintenant revenir sur une autre possibilité au niveau des arguments dans le cas où on aurait des paramètres infinis, un nombre de paramètres dit variable c'est-à-dire qu'on ne sait pas combien on peut en avoir. 

Pour ça vous allez mettre le symbole 3 petits points, et ensuite on va mettre par exemple `$lotOfVariables` éventuellement et alors là du coup on va pouvoir l'appeler de plusieurs manières comme ici.
```php
	function ma_fonction(...$lotOfVariables)
	{
		//du code ...
	}
	ma_fonction(1);
	ma_fonction(1, 2);
	ma_fonction(1, 2, 3, 4, 5);
```
On peut mettre 5 et cetera, pas mal de petites choses. 

Alors ce qu'on pourrait faire éventuellement même si on n'a pas vu le foreach(), on pourrait faire éventuellement ceci.
```php
<?php

function ma_fonction(...$lotOfVariables)
{
	foreach($lotOfVariables as $data)
		echo $data;
}
ma_fonction(1);
ma_fonction(1, 2);
ma_fonction(1, 2, 3, 4, 5);
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	11212345
```
Par exemple donc là il va afficher le premier 1, ensuite le 2e 1, 2 et enfin le dernier 1, 2, 3, 4, 5. 

Alors on n'a pas vu la boucle foreach() mais on le verra quand on abordera les tableaux. 

Mais bon en fait qu'est-ce que je lui dis là.
```php
	foreach($lotOfVariables as $data)
		echo $data;
```
Je lui dis pour chaque information de `$loOfVariables` que tu vas stocker du coup dans une variable intermédiaire `$data`, tu affiches `$data` à chaque fois. 

Donc au départ premier appel, il n'y a que un 1 donc il va boucler que sur un seul élément donc il affiche 1. 

Ensuite il a fait un 2nd appel donc il va boucler sur 1 et 2 donc il affiche 12. 

Et au 3e appel, il va boucler sur 1 puis 2 puis 3 puis 4 puis 5 et il les affiche chacun à la suite des autres mais on va la revoir bien en détail la boucle foreach() parce qu'elle va vous servir dans beaucoup beaucoup de choses tout le temps en programmation PHP donc on reviendra dessus. 

Voilà comment fonctionnent les paramètres infini. 

Si d'ailleurs j'essaie d'afficher var_dump() de `$lotOfVariables`. De plus on va mettre en commentaire les autres appels.
```php
<?php

function ma_fonction(...$lotOfVariables)
{
	var_dump($lotOfVariables);
}
ma_fonction(1);
//ma_fonction(1, 2);
//ma_fonction(1, 2, 3, 4, 5);
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	array(1) { [0]=> int(1) }
```
Si on insère 1, on obtient un tableau array() de 1.

Si en revanche je lui passe 1, 2.
```php
<?php

function ma_fonction(...$lotOfVariables)
{
	var_dump($lotOfVariables);
}
//ma_fonction(1);
ma_fonction(1, 2);
//ma_fonction(1, 2, 3, 4, 5);
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	array(2) { [0]=> int(1) [1]=> int(2) }
```
On obtient ça donc on a un entier (1) et un entier (2) c'est effectivement le cas.

Et si je lui passe le dernier, on peut même d'ailleurs changer les types ("ok", 3.14…) parce qu'ici on a permis de type précis, on n'a pas fait ça.
```php
	function ma_fonction(int ...$lotOfVariables)
```
On n'a pas choisi le type de paramètre obligatoire à avoir et donc voilà ce qu'on obtient.
```php
<?php

function ma_fonction(...$lotOfVariables)
{
	var_dump($lotOfVariables);
}
//ma_fonction(1);
//ma_fonction(1, 2);
ma_fonction(1, 2, 3, 4, 5, "ok", 3.14);
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	array(7) { [0]=> int(1) [1]=> int(2) [2]=> int(3) [3]=> int(4) [4]=> int(5) [5]=> string(2) "ok" [6]=> float(3.14) }
```
Voilà donc on a un 1, un 2, un 3, un 4, un 5, string "ok", float 3.14 et cetera. 

Voilà chaque information est passée donc voilà comment ça fonctionne pour les paramètres variables, on ne va pas dire infini parce que ce n'est pas forcément infini mais c'est juste que vous pouvez en avoir de manière variable donc ça peut servir par exemple si on veut faire une somme de nombres en disant simplement que tu fais une somme de nombres en fonction. 

D'ailleurs ça peut être plus logique de faire ça.
```php
	function sum(...$numbers)
	{
		$res = 0;
		
		foreach($numbers as $nb)
			$res += $nb;//$res = $res + $nb
		
		echo $res;
	}
```
Il sait on affichera le résultat total mais grosso modo c'est ça que ça veut dire on a d'abord un résultat qui est égal à 0. Ensuite pour chacun des nombres passé dans la boucle foreach(), on l'enregistre dans une variable intermédiaire `$nb` et on incrémente avec ce que contenait déjà `$res + autre chose` qu'on faisait déjà.

Rappelez vous ça, petite révision, `$res += $nb` revient à faire ça `$res = $res + $nb`. Et à la fin on affiche le résultat. 

On affiche le résultat ce qui fait qu'en faisant ça, `sum(1, 2)`.
```php
<?php

function sum(...$numbers)
{
	$res = 0;
	
	foreach($numbers as $nb)
		$res += $nb;//$res = $res + $nb
	
	echo $res;
}

sum(1, 2);
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	3
```
Ce qui fait qu'en faisant juste ça ça affiche 3, et puis si je fais en mettant plein de nombre comme ça.
```php
<?php

function sum(...$numbers)
{
	$res = 0;
	
	foreach($numbers as $nb)
		$res += $nb;//$res = $res + $nb
	
	echo $res;
}

sum(1, 228, 64, 16, -78, 1, 16.45);
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	248.45
```
Voilà tout un tas de choses, j'actualise et on obtient 248.45.

Voilà un petit peu ce principe de ce type de paramètre comme ça variable (…), c'est à savoir parce que ça pourra vous servir dans pas mal de cas donc pourquoi pas à voir à l'usage.

Voilà j'ai à peu près tout abordé concernant toutes ces choses-là, on a abordé tous les cas possibles pour les paramètres, et même n'avoir aucun paramètre. 

Alors petite information lorsqu'une fonction ne retourne rien, qu'elle n'a pas de return à l'intérieur, en fait elle va retourner null parce que vous savez que null correspond à rien donc on peut le faire. 

Pareil je ne l'ai pas forcément dit mais une fonction en prenant par exemple la fonction is_int() qui vérifie si quelque chose est entier. Prenons un peu le même genre de fonction qui est estPlusGrandQue10(). On lui passe `$nb` et on peut très bien faire ça.
```php
	$number = 14;
	
	function estPlusGrandQue10($nb)
	{
		if($nb > 10)
				return true;
		
		return false;
	}
```
Si c'est plus grand que 10, on retourne true et sinon … on n'est même pas obligé de mettre de else ici parce que dans tous les cas on ne rentrera pas dans le if si ce n'est pas bon … on retourne false voilà. 

Et dans le contexte du fichier on peut faire un test différent, on peut afficher le résultat de estPlusGrandQue10() de `$number` comme ça vous retourner un entier en fonction.
```php
<?php

$number = 14;

function estPlusGrandQue10($nb)
{
	if($nb > 10)
			return true;
	
	return false;
}

echo estPlusGrandQue10($number);
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	1
```
Ça retourne 1 parce qu'effectivement 14 c'est plus grand que 10. 

Là évidemment on peut mettre plusieurs return, ça je le dis parce que c'est en fonction des retours que j'ai eu sur l'ancienne version de la formation PHP où des gens pensaient qu'on pouvait en mettre qu'un seul. 

À partir du moment où votre code il a rencontré un return, il va quitter la fonction et retourner un résultats donc s'il le fait le résultat return true, il ne fera jamais le return false. S'il a fait le return false, c'est que forcément il n'a pas fait le return true. 

On ne peut pas faire de return dans un programme. 

Vous pouvez d'ailleurs vous amuser à faire ça.
```php
<?php

$number = 14;

function estPlusGrandQue10($nb)
{
	return 10;
	echo "bonjour";
	return "ok";
}

echo estPlusGrandQue10($number);
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	1O
```
Vous pouvez vous amuser à faire ça, return "ok" ne s'exécutera jamais jamais jamais puisqu'on fait un return 10, on sera toujours sorti de la fonction avant donc vous pouvez mettre n'importe quoi après le return 10 (bonjour) ça ne changera strictement rien.

C'est toujours le premier à return dans lequel on va, on accède qui prévaut c'est à dire que vous pouvez en avoir plusieurs après ça ne changera rien. 

C'est pour ça quand on a des if, des vérifications d'information, de condition, ça peut être utile d'avoir plusieurs return en fonction de la valeur du test qui a été fait si c'est vrai ou si c'est faux. 

On avait tout ce qu'il faut pour le passage par valeur et par référence très important et ça c'est à retenir, c'est très très important pour la suite aussi. 

On a vu le cas des arguments variables. 

Pour les paramètres je vous ai montré qu'on pouvait gérer le type des paramètres, ça c'est important.
```php
	function estPlusGrandQue10(int $nb)
	{
	
	}
```
On peut également gérer le type du retour, il suffit de mettre : et mettre ce que ça retourne comme ceci.
```php
	function estPlusGrandQue10(int $nb): string
	{
	
	}
```
Même avec un espace ça ne gêne pas, vous l'écrivez comme vous voulez.
```php
	function estPlusGrandQue10(int $nb): string
	function estPlusGrandQue10(int $nb) : string
```
Ça veut simplement dire que cette fonction là va retourner string donc ça pour ceux qui veulent des langages de programmation avec un typage strict mais moi personnellement c'est ce que je préfère parce que c'est mieux aussi à la relecture. 

Quand on lit cette fonction on comprend qu'elle prend un entier donc $nb on sait ce qu'il vaut, on sait ce qu'il va y avoir à l'intérieur et on voit tout de suite juste en lisant cette ligne là, qu'elle va retourner une chaîne de caractères et donc on n'a même pas besoin de regarder dans le code ce qu'elle retourne et cetera parce que juste ici à la lecture des types, on arrive à savoir ce qu'elle doit faire. 

D'ailleurs ici ça ne va pas fonctionner parce qu'on retourne 10 alors qu'on a dit qu'on retourne une chaîne de caractères donc elle va le traiter comme une chaîne de caractères.

On va vérifier que 10 est bien une chaîne de caractères.
```php
<?php

$number = 14;

function ma_fonction(int $nb) : string
{
	return 10;//return "10";
}

echo gettype(ma_fonction($number));
```
Ça veut dire qu'on fait ma_fonction () de `$number` donc on appelle ça `ma_fonction($number)` et ça retourne 10. À partir de ce moment-là on a gettype() de la fonction ma_fonction() qui retourne 10, Eh bien on fait gettype() de 10 donc de ce qu'on a récupéré là.
```txt
	http://localhost/PHP/cours/011_fonctions/
	string
```
Et du coup on obtient le type string donc vous voyez bien qu'en mettant ": string", ça a transformé, casté 10 en ça "10".
```php
	return "10";
```
Ça aura fait sa grâce à ce mot là, string.

Même si vous voyez qu'ici j'ai mis un entier (return 10), grâce à string, il a pu caster ça par contre si à un moment donné j'essaie de faire ça, true.
```php
<?php

$number = 14;

function ma_fonction(int $nb) : string
{
	return true;
}

echo gettype(ma_fonction($number));
```
Là du coup il y aura une erreur parce qu'il va essayer de caster true, et en fait non il ne va pas y avoir d'erreur…
```txt
	http://localhost/PHP/cours/011_fonctions/
	string
```
Oui ce sera un string parce qu'il va l'enregistrer comme un texte "true" donc ça fonctionnera sans problème donc évidemment pas de problème. 

Donc gérer bien les tipe vous pouvez encore le préciser avec un typage strict comme ça `…): string`, vous devez donc mettre `:` après la `)` de la fonction et pour les paramètres vous les mettez à chaque fois avant l'argument  `…int $nb)`.

Donc ça on l'a vu, tout est expliqué par rapport à ça. 

Tout est dit pour ça et normalement j'ai fait le tour, j'ai 2 petites bricoles à vous dire pour cette fin de vidéo qui concerne également les fonctions. 

Vous pouvez avoir une fonction dont on va cacher le nom, et là vous allez me demander à quoi ça peut servir ? et bien moi je vais vous répondre pas grand chose mais ça va servir notamment dans certains code quand vous allez avoir besoin d'exécuter une fonction selon d'autres paramètres. Ainsi on peut stocker l'appel d'une fonction dans une variable. 

Comment allons-nous faire ça? Eh bien très simplement, vous allez par exemple avoir votre fonction dont on va reprendre l'exemple de tout à l'heure.
```php
	function ma_fonction()
	{
		echo "Bonjour !";
	}
```
Et là on va pouvoir faire ça, on fait une variable `$coucou` et on y stock notre fonction et ensuite je fais ça `$coucou()`.
```php
<?php

function ma_fonction()
{
	echo "Bonjour !";
}

$coucou = "ma_fonction";
$coucou();//ma_fonction()
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	Bonjour !
```
Et là vous voyez que ça fonctionne mais pourquoi ça fonctionne ? tout simplement parce qu'il a remplacé `$coucou` par ma fonction donc ça revient à écrire ceci.
```php
	$coucou();//ma_fonction()
```
Elle rajoute bien sûr des parenthèses derrière donc ça correspond à cet appel là, ma_fonction(). 

D'ailleurs si je fais juste comme ça.
```php
<?php

function ma_fonction()
{
	echo "Bonjour !";
}

$coucou = "ma_fonction";
$coucou();//ma_fonction()
ma_fonction()
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	Bonjour !Bonjour !
```
Évidemment ça fonctionne aussi donc vous pouvez utiliser l'un ou l'autre.

Donc en fait on a créé une sorte d'alias c'est-à-dire qu'on a créé une autre écriture pour appeler la fonction qui s'appelle ma_fonction() donc en utilisant `$coucou`. 

Dans ce cas là ce ne sera pas forcément très parlant, très logique mais vous verrez que dans certains cas de figure ça pourra vous être utile d'utiliser ce type de syntaxe, utiliser le nom d'une fonction comme une variable et du coup de pouvoir l'appeler d'une autre manière donc ça peut servir et je vous donne ça en bonus. 

Ce sont des petites choses à connaître qui sont très utiles par la suite. 

Et on termine avec un dernier cas, pareil qui ne sera pas très utilisable pour le moment parce que vous en êtes pas très très loin dans la formation, vous démarrez tout juste. 

Il s'agit des fonctions anonymes. 

Une fonction anonyme ne porte pas de nom, elle va passer par une variable et permet notamment plus tard de faire les fameux call back, vous savez callable. Ce sont les fonctions dites de retour qui sont un peu sur le principe des fonctions de rappel donc des fermetures des closure, ce sont des termes qu'on étudiera de toute façon sur cette formation. 

Comment procéder c'est très simple, comme tout à l'heure on avait ça $coucou, vous mettez directement function() qui n'a pas de nom cette fonction ok. 
```php
	$coucou = function()
```
Vous pouvez également lui mettre des paramètres à cette fonction.
```php
	$coucou = function($nb)
```
Peu importe ça c'est vous qui voyez, ça peut être une fonction anonyme avec ou sans paramètre. 

Vous écrivez ensuite le code que vous avez besoin de faire donc ça vous voyez.
```php
	$coucou = function()
	{
		echo "Bonjour";
	}
```
Et puis du coup il n'y a plus qu'à l'appeler.
```php
<?php

$coucou = function()
{
	echo "Bonjour";
};

$coucou();
```
Comme tout à l'heure c'est la même chose, ça ressemble un petit peu aux fonctions variables qui passe par une variable. 
```txt
	http://localhost/PHP/cours/011_fonctions/
	Bonjour
```
Voilà il ne faut pas oublier le `;` parce que c'est comme si vous créez une nouvelle variable donc il faut un `;` à la fin c'est comme une instruction c'est un petit peu comme si je notais ça lorsque j'ai une instruction très courte et de toute façon les fonctions anonymes sont des fonctions très courtes, elles n'ont pas beaucoup de lignes de code donc on peut faire ça.
```php
<?php

$coucou = function(){echo "Bonjour";};

$coucou();
```
```txt
	http://localhost/PHP/cours/011_fonctions/
	Bonjour
```
Donc voilà comment ça fonctionne et notamment pour ce qu'on appelle les fonctions de rappel donc les fonctions callback, c'est une chose que vous aurez l'occasion d'aborder en web en tout cas. 

C'est sûr qu'un jour vous aurez besoin de faire usage de callback notamment pour ceux qui font du javascript aussi, normalement c'est quelque chose avec lequel vous allez très vite familier puisqu'on s'en sert beaucoup dans certains langages qui manipulent du javascript donc c'est quelque chose à connaître. 

Je tenais donc à l'aborder avec vous parce que ça existe en PHP donc c'est une fonction de rappel et notamment une fonction anonyme parce qu'elle ne porte pas de nom. 

En effet elle s'appelle function() donc elle a vraiment pas de nom c'est ça tout simplement donc ce sont des choses à connaître. 

Et on va en rester là. 

On a pratiquement vu tout ce qui existe en PHP concernant les fonctions, il y a des cas et des choses encore un peu plus complexe encore mais ça reste des cas très spécifiques mais moi personnellement je ne les ai jamais utilisé en PHP mais je ne vois pas vraiment l'intérêt de vous l'enseigner et peut-être que vous vous en servirez jamais mais c'est le même sur probablement que ce sont des choses que vous n'aurez jamais besoin d'étudier non plus donc je n'ai pas jugé utile de le voir ici. 

Vous verrez par vous-même si un jour vous avez vraiment un cas de figure où tout ce que vous avez vu ici ne suffirait pas mais à priori vous devriez être tranquille avec tout ce qu'on a abordé sur cette vidéo. 

J'espère que c'était suffisamment complet normalement oui et la vidéo ici est encore pas mal longue, elle doit durer pas mal de minutes celle là. 

Je vous dis à bientôt pour la suite. 

Là on a vraiment fait toute la partie sur les notions de base qu'on retrouve d'ailleurs dans beaucoup de langages de programmation et on va commencer à aborder d'autres petites choses maintenant.

Voilà on passe un cap donc là dite vous que vous avez vraiment vu la base des bases. 

Et là maintenant, à partir de la prochaine vidéo, on passe sur des choses un poil plus complexe avec de petites nouveautés sur ce langage. 

À bientôt sur cette formation PHP