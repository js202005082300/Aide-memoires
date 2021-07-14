# [9. Conditions](https://www.youtube.com/watch?v=m2LT_aPPuvk)

Bonjour à tous et bienvenue sur la séance 9 au langage PHP et on va attaquer sur les structures de contrôle, à commencer par les conditions donc il va y avoir pas mal de choses à voir sur cette vidéo, je vous invite d'ailleurs à ne pas hésiter à mettre en pause n'importe quand, à prendre des notes de votre côté même si je vais afficher certaines choses en commentaire comme je le fais habituellement. 

Si vous avez besoin de noter plus de choses pour mieux assimiler les notions qui sont vues éventuellement les fonctions, les différentes syntaxes que nous allons aborder, n'hésitez pas à le faire, c'est super important. Ça fait encore une fois partie des notions basiques de langage ou de d'autres langages de programmation d'ailleurs donc c'est vraiment ce qui est à connaître en premier parce que si vous bloquez à ce niveau là, on arriverait évidemment pas à assimiler tout ce que nous verrons par la suite donc c'est bien à connaître. 

Alors au niveau des conditions, comme j'en avais parlé un petit peu précédemment, ça va nous permettre de faire des tests à partir de données que nous avons. 

Alors les données ça peut être des données les critères en dur par exemple quand j'écris simplement une chaîne de caractères comme ceci "Bonjour", c'est une valeur dites en dur. Je peux écrire aussi sous forme de nombres 14, ou même encore un nombre flottant 3.11. On peut également noter un booléen true et cetera et cetera.  
```php
	"Bonjour"
	14
	3.11
	true
```
On a appris dernièrement qu'il existe la notion de variable qui nous permet de manipuler des données en les stockant, on les stocks en temps que l'exécution du programme était effective. Une fois que le programme était terminé, les variables sont détruites donc les données sont perdues. 

Si vous voulez éventuellement sauvegarder des données, il faudrait éventuellement passer par des fichiers ou une base de données éventuellement mais ce sont des choses que l'on verra par la suite sur cette formation. 
```php
	$number = 14;
```
Donc là je fais une petite variable et je lui affecte comme on l'a vu précédemment une valeur en dur donc ici il y a la valeur 14 que je affecté à la variable `$number`. 

À partir de là nous allons pouvoir faire tout un tas de vérifications, de tests.

Le plus simple des tests qui existent est la condition en `if` donc `if` c'est simplement le mot anglais qui veux simplement dire SI d'accord donc on va juste noter if() et entre parenthèses on va lui passer une expression à vérifier. Si cette expression est vraie, on rentrera dans le `if` donc on va mettre des accolades comme ceci.
```php
	$number = 14;
	
	if()
	{
		
	}
```
On va rentrer à l'intérieur du `if` pour exécuter un certain nombre d'instructions d'accord de traitement en fonction de ça. 

La plus simple des vérifications que l'on peut faire c'est un test d'égalité on va faire tout simplement comme ceci.
```php
	$number = 14;
	
	if($number == 14)
	{
				
	}
```
Alors là je vais commencer à vous noter quelques petites choses au niveau des opérateurs dit de comparaison donc on en avait parlé sur la vidéo sur les opérateurs, je vous avais dit qu'il y avait des opérateurs de comparaison que nous allions voir justement quand on allait aborder les conditions donc c'est le moment maintenant. Et l'un de ces opérateurs et le ==.
```php
	/*
		Opérateurs de comparaison :
			==
	*/
```
Alors pour ceux qui auraient suivi la logique de ce que nous avons vu jusqu à présent, vous avez sûrement compris pourquoi est-ce qu'on double le signe =. On double le signe = pour dire justement que c'est une égalité parce que vous avez compris qu'il existait déjà l'opérateur simple = qui est réservé pour l'affectation donc si on fait ça.
```php
	if($number = 12)//...
```
On ne va pas vérifier une égalité, nous allons affecter la valeur 12 à la variable $number et on n'aura pas du tout fait de test comme on l'attendait donc il faut vraiment doubler le égal pour faire une vérification d'égalité.

Alors comment est-ce que ça fonctionne ? si cette expression `$number==14` est vrai c'est-à-dire que soit ça retourne vrai donc true la valeur 1, soit ça retourne faux false la valeur 0, Eh bien on aura un comportement qui va se passer en fonction du résultat obtenu. 

Si la condition est vraie, on va rentrer à l'intérieur donc ici en l'occurrence.
```php
	$number = 14;
	
	if($number == 14)
	{
>				
	}
```
Si elle n'est pas vrai, on va ignorer toutes les instructions qui seront dans le `if` voilà. 

Par exemple moi ici je peux faire un simple echo.
```php
<?php

$number = 14;

if($number == 14)
{
	echo "Number vaut 14";
}
```
Ce genre de chose et je vais sur mon navigateur en appuyant sur F5 pour actualiser et on voit bien que ça affiche mon echo.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Number vaut 14
```
Et on voit bien que ça m'affiche "Number aux 14", c'était effectivement le cas l'égalité `$number == 14` est vérifiée d'accord parce que c'est bien égal à 14 ici `$number = 14`. 

Voilà une manière ici de procéder, on peut affiner un petit peu plus cette vérification donc ce test d'égalité par rapport au type. Si vous voulez également vérifier que 2 données sont de même type par exemple ici que `$number` est à la fois égal à 14 mais en plus du même type que 14, on peut tripler le symbole. Au lieu de mettre un simple égal, on va mettre 3 fois le symbole égal. 
```php
<?php

	/*
		Opérateurs de comparaison :
			==, ===
	*/

$number = 14;

if($number === 14)
{
	echo "Number vaut 14";
}
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Number vaut 14
```
Et là on vérifie à la fois que tout est du même type donc là tout va fonctionner parce que c'est effectivement du même type, pourquoi parce que vous savez qu'on peut PHP comme je vous l'ai expliqué, c'est un typage de dynamique. Un typage qui est d'ailleurs déduit par l'interpréteur PHP donc quand vous faites ça `$number=14` en écrivant cette variable en mettant 14 tout seul comme ça, lui il en déduit que c'est un entier, un integer, un int. Si vous aviez mis 14.0, il aurait dit que c'est un float d'accord il en aurait déduit autre chose. Si vous aviez mis "14", il en aurait fait une chaîne de caractères et d'ailleurs si je le mets en chaîne de caractère et que je vérifie avec 14 sous forme d'entier vous allez voir que là étonnamment la condition ne fonctionne plus.
```php
<?php

$number = "14";

if($number === 14)
{
	echo "Number vaut 14";
}
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
```
Ça ne fonctionne plus et c'est logique parce qu'ils ne sont plus de même type, ici `$number="14"` on a un type string alors que ici ce que j'ai marqué en dur `if($number===14)` est un type integer, int donc vous pouvez vérifier à la fois le type et l'égalité de cette manière. C'est ce qu'on appelle en fait l'identité, si on rentre ici dans le `if`, ça veut dire que $number sera identique à 14, identique en tant que valeur (même valeur) et identique en terme de type d'accord (même type), il faut que c'est 2 conditions soient validées donc c'est à connaître à ce niveau-là. 

Si je fais juste ça.
```php
<?php

$number = "14";

if($number == 14)
{
	echo "Number vaut 14";
}
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Number vaut 14
```
Voilà si je fais juste ça ça fonctionne parce que il va traiter ici $number comme étant un nombre, et là comme il est capable de caster automatiquement une chaîne de caractères "14" en nombre 14 puisqu'il n'y a rien d'autre, il n'y a pas de lettre parce que si j'avais fait "14a" ça aurait été un peu compliqué.
```php
<?php

$number = "14a";

if($number == 14)
{
	echo "Number vaut 14";
}
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Number vaut 14
```
Voilà ce serait un peu compliqué mais vous voyez qu'il va le traiter quand même parce qu'il ignore la partie chaîne de caractères d'accord mais à partir de là du moment où il trouve 14, il n'y a pas de problème à ce niveau là. 

Donc voilà comment ça se passait pour l'opération ou en tout cas l'opérateur de comparaison pour vérifier une égalité.
```php
	$number = 14;

	if($number == 14)
	{
		echo "Number vaut 14";
	}
```
À l'inverse on va pouvoir également vérifier une différence, alors je vais aller assez vite sur certains opérateurs et beaucoup moins pour d'autres parce qu'il y en a qui sont un peu plus complexe à comprendre et notamment ceux qui vont suivre. 

On a l'opérateur de différence qu'il fasse noter comme ceci `!=` tout simplement parce qu'en informatique si on peut noter une différence de quelque chose, il faut bien qu'on ait un symbole. On pourrait par exemple faire un égal barré ouais comme on peut des fois le faire en mathématiques à l'écrit donc là on utilise un ! suivi du symbole égal.
```php
	/*
		Opérateurs de comparaison :
			==, ===, !=
	*/
```
Donc en faisant ceci. Si $number est différent de 20, dans ce cas là, on va mettre OK, ce genre de chose et comme 14 c'est bien différent de 20, on va rentrer dans le `if` évidemment.
```php
<?php

$number = 14;

if($number != 20)
{
	echo "OK";
}
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	OK
```
Si en revanche on met la même valeur, comme on ne rentre pas dans le `if`, on continue l'exécution du programme.
```php
<?php

$number = 14;

if($number != 14)
{
	echo "OK";
}
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
```
Et bien on continue l'exécution du programme, c'est comme si vous aviez mis le `if` entre commentaires mais pas vraiment parce qu'il y aura quand même fait le `if`, le test quand même mais comme il voit que `$number=14`, Eh bien il ignore tout ce qui a été mis entre les accolades donc ça c'est important à savoir. 

D'ailleurs petite astuce si jamais vous n'avez qu'une seule instruction au sein d'une condition, vous n'êtes pas obligé de mettre les accolades, elles sont facultatives. On peut très bien écrire ça comme ça.
```php
<?php

$number = 14;

if($number != 14)
	echo "OK";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
```

Après je le recommande de mettre des accolades parce que vous allez voir un petit peu plus tard dans la vidéo lorsqu'on a des instructions imbriquées, enfin des conditions imbriquées, ça peut devenir très vite illisible donc pour les débutants surtout et même pour les autres d'ailleurs de manière générale, moi je vous recommande toujours toujours les mettre comme ça votre code sera lisible, et ça c'est une astuce que je donne assez souvent. Je le répète dans les cours que je donne sur la chaîne, c'est en terme de programmation, le bon programmeur ce n'est pas forcément celui qui va écrire un code ans le moins de lignes possibles … ça c'est une fausse idée, ce n'est pas parce que vous écrivez un programme en 5 lignes au lieu de 10 que vous êtes un bon développeur, c'est celui qui produira un code qui est compréhensible, lisible et surtout si vous le reconsulter après plusieurs mois, plusieurs années d'accord. 

Il ne suffit pas de croire que parce que vous avez vu votre code en une seule ligne que vous êtes un bon programmeur du coup, ça c'est strictement faux. Si votre code est devenu illisible ou qu'il est très compliqué à comprendre ou qui nécessitent de faire tout un tas de commentaires, vous n'êtes pas un bon programmeur. 

Le bon programmeur c'est celui qui produit un code et que si vous passez à un autre programmeur, il est capable de le comprendre rapidement même s'il ne comprend pas l'algorithme qui est derrière c'est-à-dire la logique. Il sera au moins capable de lire le code et de l'identifier facilement au niveau des variables et cetera d'où l'intérêt de bien nommer ces variables, d'où l'intérêt comme je vous l'ai dit de bien aérer son code, d'avoir quelque chose de suffisamment bien présenté, bien mis en page pour que ce soit beaucoup plus lisible. C'est ça qui prévaut sur l'application ou en tout cas le développement d'un programme. 

Alors on va les mettre ici, nos accolades, et on va pouvoir du coup procéder à la vérification. 
```php
	$number = 14;

	if($number != 14)
	{
		echo "OK";
	}
```
Il y a un autre opérateur de comparaison qui est important et celui-là est un petit peu plus compliqué à assimiler, c'est l'opérateur comme ceci !== qui va fonctionner sur le type également. 
```php
	/*
		Opérateurs de comparaison :
			==, ===, !=, !==
	*/
```
Comme celui là === vérifier à la fois légalité et le même type entre 2 valeurs. Celui là !== la procéder un peu de la même façon avec une petite exception que je vais vous montrer. 

Déjà on va tester ça.
```php
<?php

$number = 14;

if($number !== 14)
{
	echo "OK";
}
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
```
On voit que ça ne valide pas d'accord parce que cet opérateur !== en réalité va vérifier 2 choses.

Mais déjà on va le noter comme ça.
```
	/*
		Opérateurs de comparaison :
			== 	(égal à)
			=== (identique à : en valeur ET en type)
			!= 	(différent de)
			!== (différent de OU pas de même type)
	*/
```
Alors pour !== c'est-à-dire qu'il va prendre que l'une ou l'autre des conditions, il n'a pas forcément besoin d'avoir les 2 donc comment est-ce que ça va fonctionner dans certains cas et ici 14, on avait forcément le même type et la même valeur donc forcément ça ne rentre pas dans la condition, c'est logique. 

Par contre à partir du moment où je fais ça.
```php
<?php

$number = "14";

if($number !== 14)
{
	echo "OK";
}
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	OK
```
À partir du moment où je fais ça là on va rentrer dans la condition, pourquoi ? 

Parce que cet opérateur de comparaison va vérifier, et valide donc ça validera cette expression $number !== 14 dans 2 cas possible soit on a une différence dans la valeur. Je veux mettre d'ailleurs différence de valeur OU différence de type donc si ils ne sont pas égaux OU qu'il ne sont pas identique.
```php
	/*
		Opérateurs de comparaison :
			== 	(égal à)
			=== (identique à : en valeur ET en type)
			!= 	(différent de)
>			!== (différence de valeur OU différence de type)
	*/
```
Voilà j'essaie d'être suffisamment clair pour vous mais vous pouvez très bien le noter d'une autre manière, noter avec des mots qui vous vous parle parce que c'est évidemment différent d'une personne à une autre  donc vous Notez ce que vous voulez, vous n'êtes pas obligé de me noter exactement comme moi ou faire une capture d'écran, ce n'est vraiment pas obligatoire. Vous Notez ce qui vous vous dit quelque chose, vous parle et ce qui vous permettra ensuite de vous relire, de réviser et de bien comprendre les notions que je vous présente. 

Donc c'est ça en fait soit on a une différence de valeur et dans ce cas là l'expression `$number!==14` avec cet opérateur de comparaison est validé, soit on a une différence de type et c'est validé. 

Donc dans notre cas on n'a pas de différence de valeur OK vous voyez que c'est égal `"14"==14` par contre vous voyez qu'on a une différence de type, $number est une chaîne de caractères une string, alors qu'ici le 14 écrit en dur est un integer un entier donc comme il y a au moins la différence de type, évidemment ça valide la condition donc on entre dedans et on affiche bien le OK voilà.

Voilà c'est tout simplement comme ça qu'il faut comprendre donc ça fait attention parce que quand on veut bien faire du code c'est à dire de faire de bonnes vérifications, on a tendance à bien vérifier le type parce que la plupart du temps quand on fait des vérifications d'égalité, je dirais dans 99% des cas, on a besoin d'avoir le même type donc c'est propre c'est beaucoup plus optimisé d'utiliser cet opérateur === plutôt que celui-là == seulement. 

Et des fois on a tendance à vouloir faire l'extrême inverse c'est-à-dire d'utiliser !== plutôt que != alors que ça ne fonctionne pas du tout pareil que l'égalité, autant l'égalité === ça s'y prête bien parce qu'il faut les 2, il y a un ET comme le fameux AND qu'on a vu comme opérateur dans la vidéo précédente donc il faut que les 2 conditions soit valide pour valider l'ensemble de l'expression alors que ici pour la différence !== c'est l'un ou l'autre donc on n'est pas obligé d'avoir les 2 donc attention à ça quand vous utilisez cet opérateur là. 

Pour le coup j'insiste bien, parce que je vois beaucoup beaucoup d'erreurs en PHP même dans des projets, des scripts, ou des gros programme framework dit professionnel où l'on voit cette erreur là. 

Il y a des fois des erreurs incompréhensibles et quand on regarde dans le code on se rend compte que les développeurs ont utilisés cet opérateur là !== alors qu'il devait simplement utiliser l'opérateur de différence != mais en pensant bien faire ils ont oublié qu'il y avait l'un ou l'autre donc c'était un OU au niveau de la vérification, et comme l'un des 2 est validé pas de bol c'est rentré dans la condition alors qu'ils avaient prévu que ça ne rentre pas et là dommage. 

Donc attention c'est surtout la valeur qui vous intéresse, vous faites simplement ça != et après je vais vous montrer sur la fin de la vidéo qu'il y a également des fonctions qui permet de vérifier le type d'une variable donc si vous voulez absolument vérifier que c'est différent en valeur ET différents en type, vous serez obligé de faire quelque chose d'un peu plus complet que ça autrement plus complet que l'utilisation de ce simple opérateur !==. Il faudra donc faire ça and qu'on avu dernièrement, rappelez-vous, et en faisant par exemple une fonction précise dont je vais en parler en fin de vidéo qui vérifiera par exemple que $number est bien un outil comme 14 l'est aussi.
```php
	$number = "14";

	if($number != 14 and ...)
	{
		echo "OK";
	}
```
D'accord, on pourra faire ce genre de vérification.

On verra ça un peu plus tard. 

Alors je ne l'ai pas dit mais évidemment vous pouvez faire plusieurs … je me dis non pas du tout optimisé bien nommé mais ça c'est parce que le code est tout petit pour le coup donc ce n'est pas un problème et évidemment comme on l'a vu précédemment Vous pouvez très bien faire ceci avec AND.
```php
	$nb1 = "14";
	$nb2 = 8;

	if($number != 14 and $nb2 == 8)
	{
		echo "OK";
	}
```
Et même plus exactement pour être plus précis le fameux `&&`.
```php
	$nb1 = "14";
	$nb2 = 8;

	if($number != 14 && $nb2 == 8)
	{
		echo "OK";
	}
```
Le fameux && donc ça je ne reviens pas dessus parce qu'on l'a vu dans la vidéo sur les opérateurs qui était exclusivement dédié à ça donc tout ce qu'on a vu avant c'est-à-dire le fameux &&, le and ou le or ou encore les || ou le xor, ça fonctionne évidemment dans les conditions parce que je vous ai dit que ces opérateurs fonctionnaient dans les expressions.

	$nb1 = "14";
	$nb2 = 8;

	if($number != 14 xor $nb2 == 8)
	{
		echo "OK";
	}

D'ailleurs quand on fait ça en faisant juste un égal ==, on le fait directement dans la condition `$number == 14`.
```php
	$number = 14;

	if($number == 14)
	{
		echo "OK";
	}
```
Si pour vous ça complique les choses, ce n'est pas grave du tout, ce n'est pas être un mauvais programmeur encore une fois que de faire ça `$result =…` vous avez le droit de faire un test de comparaison donc une expression de comparaison ici.
```php
	$number = 14;
	$result = $number == 14;

	if()
	{
		echo "OK";
	}
```
Ça ne pose aucun problème et après du coup vous tester ça `$result` parce que de toute façon une comparaison, elle va soit forcément souhaite retourner true, souhaite elle va retourner false dans ce cas là en tout cas donc à partir du moment où vous faites ça c'est la même chose.
```php
<?php

$number = 14;
$result = $number == 14;

if($result)
{
	echo "OK";
}
```
Si $result a bien renvoyé true, vous voyez que le OK s'affiche.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	OK
```
On peut faire et il y a plein de personnes qui ne savent pas en PHP ou même dans d'autres langages Qui pense que faire des comparaisons comme ça `$number==14` ce n'est possible que dans des `if` ou dans les bouts comme on le verra dans la vidéo prochaine mais non vous pouvez très bien faire ça à l'intérieur. N'oubliez pas que ce sont des opérateurs de comparaison. 

Un opérateur s'utilise dans une expression, et une expression peut tout à fait l'affecté à une variable et du coup on passe par une variable intermédiaire mais en général quand on veut éviter de faire ça parce qu'on n'a pas forcément besoin de créer une variable intermédiaire pour chaque chose. Eh bien plutôt que de faire ça, on prend cette partie là `$number==14` donc on prend carrément l'expression complète et on la vérifie directement ici (dans `if`) parce qu'on n'a pas envie de créer une variable à chaque fois qu'on fait un test sinon ça augmenterait le nombre de variables de manière inutile. 
```php
	$number = 14;

	if($number == 14)
	{
		echo "OK";
	}
```
Une variable intermédiaire dans certains cas ça peut être utile mais pas tout le temps donc les gens ont pris l'habitude de faire comme ça (dans `if`) mais c'est dangereux aussi parce que à force de prendre des habitudes dans tout, et bien des fois les gens oublient des choses en informatique de manière générale et ils pensent que telle chose est obligatoire, obligatoirement à faire ici alors que non.
```php
	If(ici)
	{}
```
Ça reste une expression, j'insiste bien si je devais noter un schéma imaginé que ça s'écrit comme ça `if(<expression>)` donc quand j'écris des choses entre chevrons c'est que c'était chose à remplacer. Et puis vous allez avoir ça *//Code si expression vraie...* donc tout ce se fait en dessous de ce commentaire là.
```php
	/*
		Opérateurs de comparaison :
			== 	(égal à)
			=== (identique à : en valeur ET en type)
			!= 	(différent de)
			!== (différence de valeur OU différence de type)
		
		if(<expression>)
		{
			//Code si expression vraie...
		}
	*/
```
Voilà cette expression elle peut également être noté dans une variable ici : `$variable = <expression>;`
```php
	/*
		Opérateurs de comparaison :
			== 	(égal à)
			=== (identique à : en valeur ET en type)
			!= 	(différent de)
			!== (différence de valeur OU différence de type)
		
		$variable = <expression>;
		
		if(<expression>)
		{
			//Code si expression vraie...
		}
	*/
```
Et une `<expression>` peut contenir tout ce qu'on a vu dernièrement c'est à dire des opérations, des +, des -, des parenthèses, des *, des puissances, des symboles un peu de n'importe quoi comme on l'a vu, tous les opérateurs arithmétiques et cetera peuvent fonctionner là dedans <expression>. On peut même utiliser des fonctions et utiliser des retours de fonctions temps des calculs. Vous verrez que tout fonctionne comme ça. 

Une `<expression>` c'est un ensemble de toute chose en programmation, ça peut être des valeurs en dur comme ici `$number=14`, ça peut être d'autres variables par exemple on peut très bien faire ça.
```php
	$var = 6;
	$number = 14 + $var;
```
Je fais un petit rappel très rapide mais parce que je veux vraiment bien insister là-dessus parce que je vous dis que je vois énormément de programmeurs qui ont pourtant de l'expérience qui ont oublié toutes ces choses-là, ou alors qu'il ne l'on peut être jamais su parce qu'on leur a appris directement les choses d'une manière sans leur expliquer pourquoi on mettait tout le temps les expressions ici.
```php
	If(ici)
	{}
```
Et les gens pensent du coup qu'on ne peut faire que comme ça alors que non. 

Voilà on peut très bien faire ceci.
```php
	$var = 6;
	$number = 14 + $var;
```
On peut également comme on l'a vu et comme on le verra même plus tard, faire un retour de fonction c'est à dire qu'on peut par exemple coupler avec une fonction qui prend autre chose et cetera.
```php
	$var = 6;
	$number = 14 + $var + uneFonction($var);
```
Voilà une expression peut être aussi complète que tout ça, avec des valeurs en dur, des variables qui contiennent eux-mêmes des valeurs et des fonctions que l'on appelle qui vont retourner un résultat parce que c'est un petit peu l'intérêt ici, et ce résultat qui sera retourné sera forcément une valeur de quelque chose soit un entier, une chaîne ou autre donc c'est logique de faire ce genre d'expression là en utilisant des opérateurs.
```php
	14 + $var + uneFonction($var)
```
Voilà retenez le parce qu'il y a énormément de gens encore une fois qu'ils ont oublié ou qu'ils ne le savent pas, qu'ils pensent vraiment que c'est une condition que c'est obligatoirement des opérateurs de comparaison et que c'est dans le `if` et qu'on ne peux pas le faire avant alors que si. 

C'est absolument impensable de croire qu'on ne pourrait pas le faire ailleurs voilà. 

Et par habitude, c'est vrai qu'on le fait souvent comme ça `if($number == 14){…` comme ça on n'a pas besoin d'utiliser de variables intermédiaires. 

Voilà du coup pour nos opérateurs de comparaison. 

On en a d'autres aussi, et je vais aller beaucoup plus vite, ce sont les opérateurs que vous avez vu après en mathématiques donc niveau primaire donc si vous n'êtes pas au point avec ça il faudra revoir vos cours de maths ou éventuellement aller sur internet si vraiment ce n'est pas clair. Après je pense que tout le monde sans exception, vous êtes OK avec ça sauf si vous avez 4 ou 5 ans et que vous suivez une formation en informatique mais ce serait quand même fort étonnant parce que la plupart ne serait probablement pas lire à cet âge donc ça devrait aller normalement et vous avez donc ces opérateurs : Le inférieur à `<`, le supérieur à `>`. On a ensuite le inférieure OU égal à `<=` donc là encore une fois c'est l'un ou l'autre, il ne faut pas forcément que les 2 soient valides.
```php
	/*
		Opérateurs de comparaison :
			== 	(égal à)
			=== (identique à : en valeur ET en type)
			!= 	(différent de)
			!== (différence de valeur OU différence de type)
			< 	(inférieur à)
			>	(supérieur à)
			<=	(inférieur OU égal à)
			>=	(supérieur OU égal à)
	*/
```
Ok on a enfin supérieur OU égal à `>=` donc si les 2 le sont, les 2 le sont donc même si là c'est aura du mal à être à la fois supérieur et égal, ce n'est pas possible dans ce genre de cas. Inférieur ou égal une valeur, ce n'est pas possible non plus donc forcément ce sera obligatoirement que l'un ou que l'autre parce que si c'était le cas ce serait simplement bizarre. Par exemple 14 ne peut pas être à la fois égal à 14 et inférieur à 14, ce n'est pas logique donc c'est automatiquement en toute logique l'un ou l'autre. Et ça s'écrit dans ce sens <= et >=, on écrit pas le égal avant parce que ça ne se fait pas. C'est vraiment toujours le symbole d'infériorité et de supériorité avant, et le égal après, ensuite tout le temps voilà. 

Il n'y a pas 15000 possibilités, la syntaxe est vraiment comme ceci <= et >=, et pas autrement donc là pour le coup il n'y a pas d'autres syntaxes possibles. 

Voilà pour les opérateurs de comparaison.

Donc il n'y en a pas beaucoup à connaître, et ça peut évidemment se coupler avec les opérateurs qu'on a déjà vu dans la vidéo précédente c'est à dire le AND qui est équivalent à && et comme on l'a vu plus en détail parce que ce n'est pas tout à fait équivalent sur la priorité des opérations à quelques exceptions près. On avait le fameux OR avec le ||. Et le OU exclusif qui est un cas particulier aussi mais je ne reviens pas dessus, on a tous vu dans la vidéo d'avant voilà.
```php
	/*
		Opérateurs de comparaison :
			== 	(égal à)
			=== (identique à : en valeur ET en type)
			!= 	(différent de)
			!== (différence de valeur OU différence de type)
			< 	(inférieur à)
			>	(supérieur à)
			<=	(inférieur OU égal à)
			>=	(supérieur OU égal à)
			
			and -> &&
			or	-> ||
			xor
	*/
```
Donc ça c'est pour les opérateurs de comparaison que je vous avais promis que nous verrions, alors ils sont tous ici a quelques petites exceptions parce que j'en ai quelques-uns que l'on peut noter. 

Le langage PHP comme je vous l'avais dit est un langage assez ancien, qui était un langage historique et qui a évolué énormément en termes de syntaxe et de fonctionnalité, et les développeurs n'ont pas forcément voulu faire disparaître les anciennes syntaxe d'époque pour éviter par exemple que quelqu'un qui ai un vieux code, se retrouve avec un code qui ne marche plus du jour au lendemain. 

Alors il y a des choses qui ont disparu, il y a des choses qui sont devenu obsolète, qui ont été retirés du langage évidemment sinon on aura encore du vieux code d'il y a 20 ans sinon ce sera assez problématique mais certaines syntaxe qui ne sont pas jugées dérangeantes sont restés notamment pour l'opérateur de différence. Vous pouvez de temps en temps Retrouvez cet opérateur là à la place <> (plutôt que !=). 

Et ceux qui font d'autres langages de programmation, notamment beaucoup de langage mathématique ou qui font de la base de données, je pense à Oracle par exemple, il est possible que vous ayez déjà croisé cet opérateur là qui signifie différent de. 

Alors moi évidemment sachant qu'en plus c'est ici une formation sur PHP 7, et peut-être même que vous aurez une version supérieure au moment vous verrez ce cours. Évidemment je vous conseille d'utiliser toujours cette syntaxe ici !=.
```php
	/*
		Opérateurs de comparaison :
			== 	(égal à)
			=== (identique à : en valeur ET en type)
>			!= 	(différent de) <>
			!== (différence de valeur OU différence de type)
			< 	(inférieur à)
			>	(supérieur à)
			<=	(inférieur OU égal à)
			>=	(supérieur OU égal à)
			
			and -> &&
			or	-> ||
			xor
	*/
```
Alors je vous conseille toujours d'utiliser cette syntaxe != parce que presque tous les langages de programmation fonctionne avec elle donc là les 2 sont valides mais utiliser de préférence celle ci != mais c'est bien de savoir que celle-là <> marche existe aussi. Ce n'est pas une invention sorti du chapeau, ça existe également en PHP. 

Et on termine avec un dernier opérateur de comparaison en particulier, qui est tout nouveau et qui est arrivé avec PHP 7. Alors il faut savoir que cette formation est fait avec PHP 7, je vous ai dit au début que si vous choisissez volontairement l'apprendre PHP dans une version antérieure au moins antérieure à la version 7.0, vous faites comme vous voulez par contre il faudra vous adapter à ce cours avec au minimum PHP 7 ou une version supérieure mais pas en dessous. 
```txt
<=>
```
Sachez que cet opérateur est arrivé avec PHP 7 et que si vous avez pas au minimum PHP 7 ça ne fonctionnera pas. Alors il faut savoir qu'il va permettre de vérifier les 3 test ici.
```php
	/*
		Opérateurs de comparaison :
			== 	(égal à)
			=== (identique à : en valeur ET en type)
			!= 	(différent de) <>
			!== (différence de valeur OU différence de type)
			< 	(inférieur à)
			>	(supérieur à)
			<=	(inférieur OU égal à)
			>=	(supérieur OU égal à)
>			<=> (supérieur à, ou égal à ou inférieur à ?)
	*/
```
Et donc ici il pose la question pour savoir si c'est un des 3, c'est pour ça que je met un petit ? à la fin donc si c'est égal ça va retourner 0 (si A == B). Si la 1ère donnée `$number` est plus petite que la 2e donc on va dire que la valeur A est plus petite que la valeur B, ça va retourner un nombre négatif et généralement c'est -1 (si A < B). On part du principe que même si on peut faire des conditions sur plusieurs membres, on va partir du principe qu'on fait simplement un test comme ceci donc si A == B, ça va retourner 0. Si A < B, ça va retourner -1. Et si ont à l'inverse donc ça va retourner 1 si on a pour le coup A > B.
```php
	/*
		Opérateurs de comparaison :
			== 	(égal à)
			=== (identique à : en valeur ET en type)
			!= 	(différent de) <>
			!== (différence de valeur OU différence de type)
			< 	(inférieur à)
			>	(supérieur à)
			<=	(inférieur OU égal à)
			>=	(supérieur OU égal à)
			<=> (supérieur à, ou égal à ou inférieur à ?)	-> 0  (si A == B)
															-> -1 (si A < B)
															-> 1  (si A > B)
	*/
```
Dans ce genre de cas comment est-ce que ça peut fonctionner ? Et bien tout simplement comme ceci, admettons ceci et passons par une variable intermédiaire pourquoi pas pour faire notre teste dedans. Et moi ensuite pour être plus rapide j'affiche le résultat comme ça.
```php
<?php

$var1 = 14;
$varB = 8;

$result = $var1 <=> $varB;
echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	1
```
Et voilà, il a du coup on retourne 1 pour dire que `$var1` est plus grands que $varB. Si c'est égal ça va retourner 0.
```php
<?php

$var1 = 8;
$varB = 8;

$result = $var1 <=> $varB;
echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	0
```
Et si c'est plus petit ça va retourner -1.
```php
<?php

$var1 = 5;
$varB = 8;

$result = $var1 <=> $varB;
echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	-1
```
Voilà ça peut servir éventuellement il vous pouvez très bien faire un `if` comme ceci mais on ne va pas mettre accolade parce qu'il n'y a qu'un seul instruction encore une fois.
```php
<?php

$var1 = 5;
$varB = 8;
$result = $var1 <=> $varB;

if($result)
	echo "ok";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	OK
```
Ça fonctionne si c'est égal à -1 même s'il ne correspond à rien !

Si c'est égal à 0 (Faux).
```php
<?php

$var1 = 8;
$varB = 8;
$result = $var1 <=> $varB;

if($result)
	echo "ok";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
```
Si je mets $var1=10 ça fonctionne quand on a 1 (Vrai).
```php
<?php

$var1 = 10;
$varB = 8;
$result = $var1 <=> $varB;

if($result)
	echo "ok";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	OK
```
Voilà ça valide parce que ça va retourner 1, et 1 ça correspond à true donc en faisant ça c'est vrai. 

Le 0 ça correspond à false. 

Par contre -1, non donc attention pour ça vous ne pouvez pas faire un test booléen sur ce type d'opération là. 

0 va correspondre à false. 

1 va correspondre à true.   

Mais le -1, pour le coup ici il ne va correspondre à rien donc ça pourrait poser de problème donc attention ce niveau-là à l'utilisation de cet opérateur là mais il y aura beaucoup de cas où vous n'en aurez jamais besoin. 

Alors c'est tout nouveau, moi j'ai découvert ça avec la sortie de PHP 7 et ça n'existait pas avant surtout dans les projets que je gère en PHP, je n'ai pas en tête un exemple ou une partie d'un code où ça pourrait m'être utile parce que tous déjà fonctionne très bien sans sinon ça va vraiment être pour des cas très spécifique mais je voulais vous présenter parce qu'il fait partie des nouveautés avec PHP 7, et il est à connaître évidemment. 

C'est pareil ce n'est pas un opérateur inventé, il existe bien à partir de PHP 7, voilà pour ces opérateurs. 

On revient maintenant que je vous ai présenté tous les opérateurs de comparaison, et que maintenant ça fait bien que j'ai pris du temps là-dessus comme ça tout est dit et maintenant on n'a plus qu'a avancé sur les différentes, les premières structures de contrôle pour pouvoir faire des conditions donc on va revenir sur notre code de départ comme ceci.
```php
	$number = 10;
	
	if($number == 10)
		echo "OK";
```
Vous pouvez sans problème, et ça je me base par rapport à l'ancienne formation parce que ça vous savez que c'est une nouvelle formation PHP. J'en avais fait une ancienne à l'époque sur ma chaîne que j'ai enlevé pour faire quelque chose de plus à jour avec du coup PHP 7 avec encore plus de vidéos qu'avant et encore plus de contenu pour toujours améliorer ça. Et je me base beaucoup sur les commentaires et les questions que j'avais eues pour améliorer évidemment le nouveau cours, il y a une question qui revient souvent c'est sur l'imbrication des conditions. Les gens n'avaient pas forcément compris que logiquement vous pouviez dans une condition en mettre une autre. 

Du coup je vais en profiter pour vous montrer ça sur cette vidéo puisque vous pouvez sans problème faire ceci où on va vérifier que `$number>0`, et si il est plus grand que 0 on rentre également dans le `if`. Et dans le `if`, je peux mettre un autre directement. Et alors cette fois-ci est-ce que `$number>5`. Et si c'est le cas est-ce que `$number>10`. Et si c'est le cas, j'affiche "Plus grand que 10" d'accord.
```php
<?php

$number = 10;

if($number > 0)
	if($number > 5)
		if($number > 10)
			echo "Plus grand que 10";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
```
On va laisser comme ça et là on voit que ça n'affiche rien, logique parce qu'il est tout à fait égal à 10. 

En revanche si je mets juste après, 11.
```php
<?php

$number = 11;

if($number > 0)
	if($number > 5)
		if($number > 10)
			echo "Plus grand que 10";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Plus grand que 10
```
Ça fonctionne. 

Et là ça peut devenir tout de suite plus compliqué. Je vais vous montrer un exemple tout bête et d'abord je vais afficher ça "Suite du programme…".  Alors je peux aussi mettre un peu avant "Plus grand que 0", je vais mettre du texte un peu plus compréhensible pour aider à comprendre le cheminement et donc on affichera encore "plus grand que 5".
```php
<?php

$number = 11;

if($number > 0)
	if($number > 5)
		if($number > 10)
			echo "Plus grand que 10";
		
		echo "Plus grand que 5";
	
	echo "Plus grand que 0";

echo "Suite du programme";
```
Enfin voilà voir un exemple de code qui devient très vite illisible avec juste des petits echo. Très vite illisible si encore une fois on pense être un bon programmeur en réduisant au maximum le nombre de lignes de code, en minimisant le code, et dire je suis un bon programmeur parce que je l'écris en moins de lignes possibles sauf que ici le code est dégueulasse et il est absolument pas lisible et pas compréhensible. Si je passe ce code là à quelqu'un, il va forcément lui falloir quelques minutes … bon là il est tout petit donc ça sera plus simple … mais imaginez sa sur un vrai code avec plein de système d'instruction, il faudra certainement pas mal de temps pour comprendre à quoi correspond chaque choses, et encore là, le texte aide quand même pas mal donc on s'en sort plutôt bien.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Plus grand que 10Plus grand que 5Plus grand que 0Suite du programme
```
D'ailleurs là vous voyez qu'il vous affiche Plus grand que 10Plus grand que 5Plus grand que 0Suite du programme donc peut être que la personne qui va voir ce code va se dire mais pourquoi il affiche les 4. Je ne comprends pas, il ne devrait pas y avoir des tabulations des fois, alors pourquoi est-ce qu'ils affichent le 4 alors que je pensais qu'il allait m'afficher que ça Plus grand que 10 ... Alors pourquoi est-ce qu'il n'affiche pas que ça ?

Parce qu'il y a des choses qui sont en dehors de certaines conditions des `if`. 

Et donc si on veut améliorer la lisibilité, encore une fois je vous recommande tout le temps d'utiliser des accolades même si vous jugez que ce n'est pas forcément utile, vous allez largement améliorer la lisibilité de votre code en faisant ça. On peut même d'ailleurs d'en mettre pour le dernier mais ainsi on va mieux comprendre.
```php
	$number = 11;

	if($number > 0)
	{
		if($number > 5)
		{
			if($number > 10)
				echo "Plus grand que 10";
			
			echo "Plus grand que 5";
		}
		
		echo "Plus grand que 0";
	}
	
	echo "Suite du programme";
```
Voilà déjà ici on comprend beaucoup mieux, on comprend que si `$number>0`, on rentre dans le prochain `if` et on voit tout mon bloc lien à mon premier `if`.
```php
		$number = 11;
	+-------------------------
	|	if($number > 0)
	|	{
	|		if($number > 5)
	|		{
	|			if($number > 10)
	|				echo "Plus grand que 10";
	|			
	|			echo "Plus grand que 5";
	|		}
	|		
	|		echo "Plus grand que 0";
	|	}
	+-------------------------
		echo "Suite du programme";
```
Vous voyez que tout de suite c'est beaucoup plus lisible en code donc on voit que si on ne rentre pas du tout dans le premier `if` c'est-à-dire que si `$number=-1` est une valeur négative. Il n'y aura pas de problème parce qu'on voit que le dernier echo sera affiché dans tous les cas.
```php
<?php

$number = -1;

if($number > 0)
{
	if($number > 5)
	{
		if($number > 10)
			echo "Plus grand que 10";
		
		echo "Plus grand que 5";
	}
	
	echo "Plus grand que 0";
}

echo "Suite du programme";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Suite du programme
```
Le dernier echo sera affiché dans tous les cas parce qu'il est complètement en dehors de toute la structure conditionnelle donc c'est logique qu'on affiche ça. 

À partir du moment où c'est plus grand que 0, il va afficher les 2 lignes.
```php
<?php

$number = 1;

if($number > 0)
{
	if($number > 5)
	{
		if($number > 10)
			echo "Plus grand que 10";
		
		echo "Plus grand que 5";
	}
	
	echo "Plus grand que 0";
}

echo "Suite du programme";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Plus grand que 0Suite du programme
```
On comprend aussi qu'il affiche les 2 echo puisqu'il est rentré ici `if(number>0)`. Mais il n'a pas réussi à rentrer là `if($number>5)` parce qu'il n'est pas plus grand que 5 et donc il n'est forcément pas plus grand que 10 donc il va afficher "Plus grand que 0" parce qu'on est à l'intérieur de `if($number>0)` mais en dehors de `if($number>5)`. Et il affiche évidemment le echo qui est en dehors de tout d'où le fait d'avoir ça.
```txt
	Plus grand que 0Suite du programme
```
Et ainsi de suite, ainsi de suite. 

Et si on veut mettre toutes les accolades, on peut également le faire comme ça on comprendra bien le code au niveau de la lecture.
```php
	$number = 1;

	if($number > 0)
	{
		if($number > 5)
		{
			if($number > 10)
			{
				echo "Plus grand que 10";
			}
			
			echo "Plus grand que 5";
		}
		
		echo "Plus grand que 0";
	}

	echo "Suite du programme";
```
Et là on comprend bien le code au niveau de la lecture. 

Ça rajoute des lignes, ça fait un peu plus de lignes de code mais au moins on arrive facilement à lire et si vous passez le programme à quelqu'un qui connaît évidemment les conditions PHP sinon ce serait problématique, il est capable de comprendre chaque chose et à quoi ça correspond grâce aux accolades. 

En plus les éditeurs de code maintenant, ils arrivent à veux fermer automatiquement les structures (développer avec +, réduire avec -) et tout seul grâce aux accolades sinon il n'arrive pas à le faire sauf si évidemment ils sont très à jour et qu'ils arrivent à le détecter mais la plupart du temps ça déconne donc c'est mieux d'avoir des accolades, ils sont capables comme ça de fermer à chaque fois toutes les structures sous forme d'accolade, très pratique pour relire son code donc c'est plutôt sympa à utiliser. 

N'hésitez pas à privilégier ce genre de synthèse soleil qui sont beaucoup plus lisibles à la relecture mais imaginez faire un programme en PHP et devant le relire 6 mois ou un an plus tard. Si vous n'êtes pas capable de vous relire ça risque d'être très problématique pour maintenir quelque chose et d'avoir un code qui soit propre et optimiser. C'est comme ça qu'on crée des bugs, c'est comme ça aussi qu'on a des programmes qui sont bourré bourré d'erreurs parce qu'on pense être un bon programmeur en écrivant le moins de lignes possibles, en même temps les `if` comme ça.
```php
	$number = 1;

	if($number > 0)
		echo "OK";
```
On peut très bien écrire comme ça, on met directement tout à la ligne c'est-à-dire qu'on peut faire ça.
```php
<?php

$number = 1;

if($number > 0) echo "OK";
```
On peut même mettre un petit espace avant le echo histoire de dire … et vous allez voir que ça fonctionne.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	OK
```
Ça fonctionne mais ce n'est pas lisible, alors oui ce n'est qu'une petite ligne donc ça passe mais si vous rajoutez comme ça plein de lignes partout, ça va vite devenir très compliqué donc il faut faire gaffe à ce niveau là. 

Voilà ça c'était un petit rappel, en tout cas un petit conseil concernant les bonnes méthodes de programmation après à mon humble avis mais après vous en faites ce que vous voulez, voulez appliquer ou non c'est votre choix mais ce sont les conseils que je peux vous donner. Et surtout dans ce genre de cas où on peut avoir des conditions assez imbriqués, assez complexe par la suite. 

Alors plutôt que de faire plusieurs `if` comme on a pu le voir, on peut très bien faire des `if` comme ceci mais sans les imbriquer ce qui est tout à fait possible. 
```php
	$number = 1;

	if($number > 0)
		echo "OK";
	if($number > 5)
		echo "OK";
```
Voilà on peut faire les `if` sans les imbriquer à la différence qu'ici comme c'est à chaque fois en dehors, on va toujours tout vérifier c'est-à-dire qu'est-ce que le programme va faire pour `$number1` ? il va d'abord faire ça, est-ce que `$number` est plus grand que 0 ? oui ouais du coup il va afficher "OK" mais là il va quand même faire `if($number>5)` aussi d'accord parce que comme le `if` est en dehors de tout, et bien il va le faire donc si vous faites des `if` non imbriquées et que par exemple il y en a 10, il fera les 10 à la suite et donc évidemment ça va prendre beaucoup plus de temps que si vous n'en faisiez que 1 parce qu'ils étaient imbriquées donc il faut faire gaffe aussi à ce niveau là. 

Du coup qu'est-ce qu'on peut faire ? on peut éventuellement privilégier ce type de syntaxe `elseif`, qui s'écrit aussi avec un espace `else if`. En tout cas l'un ou l'autre ça fonctionne mets-moi éventuellement je vous recommandé de ne pas en mettre (elseif) car vous verrez plus tard quand on fera notamment de l'intégration avec du HTML. Vous verrez que cette syntaxe `elseif` fonctionne en HTML mets pas celle là `else if`. 

À la rigueur prenez l'habitude dès le départ de tout attaché `elseif` et au moins vous serez sûr que ça fonctionne à tous les coups. 
```php
	$number = 1;

	if($number > 0)
		echo "OK";
	elseif($number > 5)
		echo "OK";
```
Et là qu'est-ce qu'il fait ? Si on rentre dans le `if($number>0)` donc si ça valide cette condition là, on affiche le premier "OK" et on ne fera pas le `elseif(..)` d'accord c'est-à-dire qu'une fois qu'on a fait la première partie, on sort complètement de la structure conditionnelle mais par contre si `if($number>0)` n'est pas validé "alors si" donc il va aller sur le 2e. Il va essayer de tester la 2e expression et cetera et cetera.

Et vous pouvez mettre une expression qui sera fait dans tous les cas par défaut avec un `else`, elle sera fait dans tous les cas. Pour être plus exact elle sera fait si aucun des cas avant n'a été validé donc là on va mettre "Pas ok" c'est-à-dire que si ni la première expression n'est vrai et que ni la 2nde expression est vrai, alors d'où le mot else en anglais, on rentre dans le `else` et on affiche "Pas ok".
```php
<?php

$number = 1;

if($number > 0)
	echo "OK";
elseif($number > 5)
	echo "OK";
else
	echo "Pas ok";
```
Alors là je n'ai pas d'accolades parce qu'on a vraiment qu'une seule instruction à chaque fois même si encore une fois vous pouvez en mettre ça ne pose pas de problème et se sera beaucoup plus lisible.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	OK
```
Et là on obtient ça "OK" parce que c'est plus grand que 0. 

Voilà on va faire comme ça, si c'est c'est ni plus grand que 0, ni plus petits que 0, ça veux dire que c'est égal.
```php
<?php

$number = 1;

if($number > 0)
	echo ">0";
elseif($number < 0)
	echo "<0";
else
	echo "=0";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	>0
```
Là il nous met plus grand que 0 et c'est effectivement le cas parce que c'est 1. 

Si on met moins 11, il va en toute logique vous afficher plus petite 0.
```php
<?php

$number = -11;

if($number > 0)
	echo ">0";
elseif($number < 0)
	echo "<0";
else
	echo "=0";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	<0
```
Si on met 0, on va ni valider la première condition, ni valider la 2nde condition donc on va aller dans le `else` et il va nous afficher que c'est égal à 0.
```php
<?php

$number = 0;

if($number > 0)
	echo ">0";
elseif($number < 0)
	echo "<0";
else
	echo "=0";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	=0
```
Ce qui est bien le cas quand on regarde la valeur de $number donc vous pouvez très bien avoir ce type de structure là. 

Le minimum c'est d'avoir un `if` parce que si vous n'avez pas de `if` du tout, Eh bien vous n'avez pas de conditions c'est logique c'est comme ce qu'on avait précédemment. 

Si vous voulez un code avec un `if` et un cas où le `if` n'est pas validé, vous faites ça.

`if` sinon voilà donc un cas où c'est plus grand que 0, et en toute logique si ce n'est pas plus grand 0, c'est en toute logique plus petit ou égal à 0 parce que c'est la seule possibilité si ça n'a pas validé ça en termes de logique.
```php
<?php

$number = 0;

if($number > 0)
	echo "> 0";
else
	echo "<= 0";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	<= 0
```
C'est la seule possibilité si ça n'a pas validé ça en termes de logique, et vous pouvez faire plusieurs `if` avec des `elseif`, `elseif`, `elseif`, … autant que vous voulez avec à chaque fois des conditions d'accord on vérifie une expression dans le `if`, on vérifie une expression dans les `elseif` puisqu'on redemande une condition par contre pour le `else`, il n'y en a pas d'accord c'est logique et attention à ça. 

On ne fait pas de `else` avec une vérification de quelque chose. 

Le `else` c'est si toutes les conditions d'avant n'ont pas été validé, alors … c'est ce qu'il signifie, `else` en anglais … en fait ce qu'il y a là donc pas besoin de vérifier quoi que ce soit. C'est le cas où tout ce qui était avant n'était pas validé.

Ça c'était toute la structure, ça a pris un peu de temps à tout vous expliquer mais c'était important, toute la structure conditionnelle avec le `if`, le `elseif` et le `else` qui était évidemment à connaître. 

C'était la première que vous deviez apprendre au niveau des structures conditionnelles. 

Maintenant une 2e qui peut être intéressante, admettons que je veux vérifier plusieurs valeurs d'égalité de `$number` genre je veux vérifier si `$number` est égal à 1, est-ce que $number est égal à 2, est-ce qu'il est égal à 3 et cetera et cetera. 

Avec ce que vous avez appris, le seul moyen que vous avez grosso modo de le faire, c'est de faire ça.
```php
	$number = 1;
	
	if($number == 1)
		echo "1";
	elseif($number == 2)
		echo "2";
	// etc.
	else
		echo "Pas valide";
```
Ça c'est un peu long d'accord si vous avez beaucoup de conditions vérifier comme ça … je dirais un ordre d'idée à partir de 5. Quand vous arrivez à 5 `if` ou plus, il est mieux d'utiliser une autre structure de condition. Si vous en avez que 3, vous pouvez très bien fonctionner avec des `if` et ça ira, ça reste tout à fait raisonnable et correct mais si vous commencer à atteindre les 5 conditions comme ça qui se suivent voir plus, vous avez une structure que l'on appelle le switch qui est prévu pour ça.
```php
	$number = 1;
	
	switch()
	{
		
	}
```
C'est pas que c'est forcément mieux ou moins bien, c'est juste que c'est plus optimisé pour tout un ensemble de vérification d'égalité à faire. 

Le switch fonctionne absolument que pour des égalités donc c'est-à-dire vérifier que quelque chose est égal à autre chose.

Pour travailler dessus, vous mettez switch() sur la variable testé donc il ne s'agit pas de vérifier une inégalité ou une différence tout ça, c'est vraiment pour l'égalité.
```php
	$number = 1;
	
	switch($number)
	{
		
	}
```
Et dans ce genre de cas on va avoir plusieurs possibilités. Pour définir énumérer les possibilités que vous voulez, vous avez utilisé le mot clé `case` qui veut dire 'cas', où dans Leclerc par exemple où `$number` est égal  à 1 donc vous mettez `case 1` donc dans le cas où ça ça vérifie l'égalité de `$number == 1`. On met : et on écrit ce qu'on va faire comme traitement.
```php
	$number = 1;
	
	switch($number)
	{
		case 1:
	}
```
Donc vous pouvez mettre directement les traitements à la suite par exemple comme ceci.
```php
	$number = 1;
	
	switch($number)
	{
		case 1:echo "1";
	}
```
Moi je vous recommandé d'aller à la ligne avec une petite tabulation et voilà.
```php
	$number = 1;
	
	switch($number)
	{
		case 1:
			echo "1";
	}
```
On sait que c'est à l'intérieur du case, une fois que vous avez fini vous pouvez traiter un autre cas que vous pouvez écrire comme ça, présenter les switch comme ça et pour ma part je trouve ça bien lisible et cetera. On va s'arrêter à 3 ce sera pas mal.
```php
	$number = 1;
	
	switch($number)
	{
		case 1:
			echo "1";
		
		case 2:
			echo "2";
			
		case 3:
			echo "3";
	}
```
Et après c'est mieux de gérer un cas par défaut. Si c'est ni égal à 1, ni égal à 2, ni égal à 3 donc le fameux `else` qu'on aurait par exemple, vous mettez le mot clé 'default:' et ça je vous recommande de le mettre toujours dans un switch, toujours gérer un cas par défaut si jamais aucune de vos égalité n'est vérifié.
```php
	$number = 1;
	
	switch($number)
	{
		case 1:
			echo "1";
		
		case 2:
			echo "2";
			
		case 3:
			echo "3";
		
		default:
			echo "Pas validé";
	}
```
Alors si c'est une valeur que vous pouvez traiter, vous faites un traitement particulier sinon vous dites simplement que ce n'est pas une valeur que vous vouliez, une valeur que vous attendiez, vous avez un message d'erreur et bref vous faites ce que vous voulez. 

Le problème c'est qu'en écrivant juste cette syntaxe là, le switch va vérifier le cas où c'est 1, faire le echo. Ensuite il va vérifier si c'est égal à 2, ensuite il va vérifier si c'est égal à 3, ensuite il va faire le default c'est à dire qu'il va tout faire et du coup ce n'est pas propre. 

C'est un petit peu comme ce qu'on a fait tout à l'heure, comme si on faisait ça (je vous remonte son équivalent). Et directement on refait une autre condition et cetera et cetera.
```php
	if($number == 1)
		echo "1";
	if($number == 2)
		echo "2";
```
Au lieu de faire le fameux `elseif`.
```php
	if($number == 1)
		echo "1";
	elseif($number == 2)
		echo "2";
```
Là il ne va faire que l'un ou l'autre donc il ne fera forcément que une seule des deux conditions. Il ne va jamais affiché 1 et en même temps 2.

Ce qui va afficher un et il sort. Soit il vient dans elseif et du coup il va afficher 2 parce que ça valide. Soit il veut afficher aucun des 2 parce que c'est ni égal à 1 ou égal à 2 donc éventuellement on va se servir d'un `else`.
```php
	if($number == 1)
		echo "1";
	elseif($number == 2)
		echo "2";
	else
```
Alors que là switch que j'ai actuellement correspond à ça.
```php
	if($number == 1)
		echo "1";
	if($number == 2)
		echo "2";
```
C'est-à-dire qu'ici il va afficher que un seul des 2 echo mais par contre il va tester les 2 conditions et du coup ça demande un petit peu plus de temps d'exécution, ce n'est pas forcément optimisé donc pour éviter ça on part du principe qu à partir du moment où on est rentré dans un cas c'est-à-dire que comme ça vérifie une égalité, vous êtes d'accord que si $number est égal à 1, il ne peut pas être égal à 2 ni à 3 ni à autre chose. Il est soit égal à 1 et c'est tout. Il est égal qu'à une seule valeur possible donc vous allez devoir sortir de la structure, interrompre la structure et pour ça vous allez utiliser un petit mot clé en PHP qu'on retrouve dans pas mal d'autres langages aussi qui est le mot break.

Break et une instruction terminer par un ; et ça il faut le mettre à chaque fois, à chaque fin de cas et donc default également et dans le cadre du default vous pouvez directement mettre un juste un break pour dire que si ça correspond à rien, eh bien on sort du switch, terminé.
```php
<?php

$number = 1;

switch($number)
{
	case 1:
		echo "1";
		break;
	
	case 2:
		echo "2";
		break;
		
	case 3:
		echo "3";
		break;
	
	default:
		echo "Pas validé";
		break;
}
```
On ne fait rien d'autre et dans ce cas là, vous allez traiter qu'un seul cas.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	1
```
Ok voyez le 1.

Par exemple, si je supprime le premier break.
```php
<?php

$number = 1;

switch($number)
{
	case 1:
		echo "1";
	
	case 2:
		echo "2";
		break;
		
	case 3:
		echo "3";
		break;
	
	default:
		echo "Pas validé";
		break;
}
```
On ne fait rien d'autre et dans ce cas là, vous allez traiter qu'un seul cas.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	12
```
En plus de traiter plusieurs cas, il induit le code en erreur c'est-à-dire que là il considère du coup que $number est égal à 2 alors que ce n'est pas le cas. Vous voyez en plus ça crée des résultats inattendus ce qu'on appelle des comportements inattendus c'est-à-dire que le code peut produire un résultat qui est imprévissible et là il vous met que c'est 1 et 2 en même temps.

C'est comme s'il vous disait que $number était à la fois égal à 1 et égal à 2 alors que ce n'est pas possible, c'est forcément l'un ou l'autre, ça ne peut pas être les 2 d'où l'intérêt encore une fois de bien mettre le break sinon vous allez avoir des comportements assez bizarres dans vos programmes et vous allez vous arracher les cheveux sans comprendre d'où vient l'erreur donc attention à l'utilisation …  Ça c'est tout nouveau aussi, on va d'ailleurs le voir dans la vidéo prochaine avec l'autre type de structures de contrôle et avec un autre mot qui sera bien utile donc c'est à connaître le break pour interrompre c'est-à-dire casser la structure en cours donc ici le switch.

Voilà vous avez vu la structure en `if`, vous avez vu la structure de contrôle en switch qui correspond à un ensemble de plusieurs `if` et un `else` à la fin de préférence pour que ce soit propre et nous allons voir quelques-unes qui peuvent être intéressantes, pas obligatoire.

Tout ce que je vous montre à partir de maintenant n'est vraiment pas obligatoire mais c'est bien de le savoir aussi parce que ça peut raccourcir en tout cas, en tout cas faciliter votre développement et des fois rendre les choses un peu plus visibles dans certains cas avec notamment l'utilisation d'un ternaire. 

Alors comment fonctionne un ternaire ? par exemple admettons un jeu vidéo, on utiliserait par exemple un boulléen pour dire que le jeu est lancé ou pas donc il est à true ou false. Alors on ferait ce genre de vérification … admettons on met un message juste par défaut et si le jeu est lancé donc je rappelle que j'ai 2 syntaxe sont équivalente.
```php
	$jeu_lance = true;				$jeu_lance = true;
	$message = '';					$message = '';
	
	if($jeu_lance == true)			if($jeu_lance)
```
C'est exactement la même chose, c'est l'un ou l'autre pourquoi parce que si vous mettez tout court la variable, le `if` rappelez vous soit il se valide, soit il ne se valide pas. Il se valide si le test qui est fait est égal à true, il se valide si le teste qui est fait est égal à false.

Et comme l'a on l'a déjà un booléen dans la variable, vous n'êtes pas obligé de noter ça comme ça. Là effectivement c'est une histoire d'optimisation c'est-à-dire qu'un débutant va noter ça comme ça `if($jeu_lance == true)` mais quelqu'un qui a un petit peu d'expérience en informatique, il va noter ça directement comme ça `if($jeu_lance)` donc apprenez dès le début à prendre les bonnes habitudes. Quand vous avez une variable booléenne, vous n'avez pas besoin de noter l'opération d'égalité.

Vous êtes soit comme ça pour vérifier si c'est égal à True.
```php
	if($jeu_lance)
```
Et si vous voulez vérifier l'inverse, vous mettez un !.
```php
	if(!$jeu_lance)
```
Pour dire que c'est l'inverse de true donc là en l'occurrence false. 

Là on fait ça.
```php
<?php

$jeu_lance = true;
$message = '';

if($jeu_lance)
	$message = "Le jeu est en route...";
else
	$message = "Le jeu est eteint.";

echo $message;
```
Je veux éviter encore une fois les accents parce qu'on ne travaille pas sur les encodages, là on est juste en PHP. On n'a pas fait de page web, c'est juste un script PHP donc voilà comment ça se passe. 

Je teste et j'actualise.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Le jeu est en route...
```
Voilà donc il m'affiche que le jeu est en route parce que c'est le cas. `$jeu_lance = true` donc c'est normal que la condition est validé et ensuite il affecte la valeur "Le jeu est en route..." à `$message` et du coup dans tous les cas j'affiche la valeur parce que je suis sûr qu'il y aura au moins quelque chose de enregistrer dans $message parce que en faisant un `if` … `else` … avec une affectation sur la même variable dans les 2 cas, c'est obligé qu'il y aura soit le premier message soit le 2e message comme valeur affectée, obligatoirement, c'est impossible qu'il y ait aucun des 2.

Parce qu'on fait une vérification binaire d'accord sur une variable donc automatiquement ça fonctionne et si jamais d'ailleurs 1, rappelez-vous pour les booléens, c'est la même chose je rappelle.
```php
<?php

$jeu_lance = 1;
$message = '';

if($jeu_lance)
	$message = "Le jeu est en route...";
else
	$message = "Le jeu est eteint.";

echo $message;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Le jeu est en route...
```
Si jamais 0 ça correspond à false donc on va voir l'inverse, le jeu est éteint.
```php
<?php

$jeu_lance = 0;
$message = '';

if($jeu_lance)
	$message = "Le jeu est en route...";
else
	$message = "Le jeu est eteint.";

echo $message;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Le jeu est eteint.
```
Et cetera.

Ça c'est une syntaxe qui peut être un petit peu lourde dans certains cas même si elle est simple ici, le fait d'affecter quelque chose là, certains vont peut-être vouloir écrire cela un peu plus rapidement. 

Si vous voulez le faire plus rapidement vous pouvez utiliser ce qu'on appelle, un ternaire, une structure ternaire. Pour ce faire c'est très simple, la variable qui va recevoir le résultat ternaire, vous la mettez au départ `$message` et vous allez faire une affectation suivant une condition. La condition c'est ça, vous lui passer la valeur entre parenthèses et moi ça va juste être ça `$jeu_lance`.
```php
	$jeu_lance = 0;
	$message = '';

	$message = ($jeu_lance) ...

	echo $message;
```
On peut faire une condition genre une égalité, une vérification avec un nombre.
```php
	$jeu_lance = 0;
	$message = '';

	$message = ($jeu_lance == 14)

	echo $message;
```
On peut faire également >= à quelque chose `$jeu_lance >= 14`, ça fonctionne mais dans mon coeur particulier je vérifie juste un true `$jeu_lance` mais bien évidemment vous pouvez utiliser n'importe quel type d'opérateur de comparaison dans un ternaire c'est juste qu'il va se passer de cette manière. On met un ? Juste après le ? vous écrivez la valeur que va prendre le message dans le cas où la condition est validée donc dans le cas où cette condition `$jeu_lance` vaudra true donc moi ça va être ça.
```php
	$jeu_lance = 0;
	$message = '';

	$message = ($jeu_lance == 14) ? "Jeu en route"

	echo $message;
```
Vous mettez ensuite : et moi je vais mettre un petit espace pour que ce soit un peu plus lisible à lire plutôt que de faire ça tout collé. C'est juste que c'est une question de lisibilité encore une fois, j'ai écrit le message "Jeu éteint" et le `;` à la fin parce que c'est une instruction.
```php
<?php

$jeu_lance = 0;
$message = '';

$message = ($jeu_lance == 14) ? "Jeu en route" : "Jeu eteint";

echo $message;
```
Donc voyez même dans une affectation de variable, on peut écrire tout ça comme expression et en plus on peut utiliser des opérateurs de comparaison, des opérateurs arithmétiques voilà des opérateurs de plein de calcul, des retours de fonctions mais également cette nouvelle chose que vous venez d'apprendre qui s'appelle un ternaire.

Pourquoi ternaire ? parce qu'on a 3 choses c'est-à-dire une expression à vérifier `$jeu_lance` donc une condition, son résultat si c'est vrai "Jeu en route" ou sans résultat si c'est faux "Jeu eteint" donc en analogie "Jeu en route" est ce qui arrive si on rentre dans le `if` et ça "Jeu eteint" est ce qui arrive si on rentre dans le `else` d'accord mais on a raccourci du coup l'écriture.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Jeu eteint
```
On obtient ça 'Jeu eteint' parce que je rappelle que c'est égal à 0. 

Si je met true. D'ailleurs, je peux même virer le message, je n'ai pas besoin de le créer avant.
```php
<?php

$jeu_lance = true;

$message = ($jeu_lance == 14) ? "Jeu en route" : "Jeu eteint";

echo $message;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Jeu en route
```
Là ça va être égal à 'Jeu en route' parfaitement logique si on lit tout ça d'accord.

Voilà comment fonctionne un ternaire donc encore une fois ce n'est pas obligatoire à connaître, même si un jour vous n'utilisez jamais de ternaire dans votre vie, vous ne serez pas un mauvais programmeur. Ce n'est pas une obligation du tout mais c'est bien de savoir que ça existe étant certain cas peut être que vous préférez utiliser cette syntaxe-là qui sera peut-être plus lisible dans certains cas de figure en programmation.

Par contre si vous pensez que le ternaire va faire perte en lisibilité votre code, garder la structure `if` … `else` … encore une fois.

Ne cherchez pas à vouloir produire un code encore plus compliqué, en vous disant que vous serez un meilleur programmeur si vous faites un code qui parait plus complexe. On n'est pas là pour se la péter, faites un code qui est lisible pour vous plus tard, si vous retournez dessus, si vous revenez lire ou retravailler sur un code, il faut qu'il soit compréhensible rapidement. Il faut que en quelques secondes vous sachiez ce que vous êtes en train de faire donc là pour l'exemple que j'ai là c'est évidemment très simple, pas besoin de mettre un `if` … `else` … c'est très lisible comme syntaxe.
```php
	$message = ($jeu_lance == 14) ? "Jeu en route" : "Jeu eteint";
```
Par contre dans certains cas vous verrez que le ternaire peut compliquer la lecture du code donc dans le cas où cela compliquerait on va préférer faire un `if` … `else` … qui sera évidemment beaucoup plus lisible. 

Voilà pour ça au niveau du ternaire.

On termine avec une dernière petite structure toute nouvelle aussi qui est arrivé récemment en PHP qui va permettre de vérifier l'existence ou non d'une variable donc dernièrement par rapport à ce qu'on a vu précédemment, je vous avais dit qu on faisait par exemple ceci.
```php
	$maVariable = "ok";
```
On settait une variable c'est-à-dire qu'on faisait un set de la variable c'est-à-dire qu'on la créait, on la définissait, et je vous avait dit qu'avec la fonction unset() ... sans rentrer dans les détails sur les fonctions puisqu'on aura une vidéo bientôt sur les fonctions de manières générales.

En faisant ça.
```php
	$maVariable = "ok";
	
	unset($maVariable);
```
En faisant ça, on unsetait la variable donc on a enlevait sa définition  donc en réalité, on nous disait que cette variable était égal à null, une variable qui est égal à null c'est une variable qui n'existe plus. En PHP c'est comme ça que c'est décidé.

On peu du coup enlever la définition d'une variable, on peut par exemple vérifier que la variable existe grâce à la fonction isset() en faisant ceci.
```php
	$maVariable = "ok";
	
	isset($maVariable);
```
Donc là on ne fait pas un test sur sa valeur, on s'en fou, vérifie juste si cette variable $maVariable existe, et c'est vrai que si je l'avais abordé précédemment, ça n'aurait pas eu d'intérêt mais là comme on a vu les conditions. Regardez vous pouvez faire ça dans un `if`.
```php
 	$maVariable = "ok";
	
	if(isset($maVariable))
		echo "Elle existe";
	else
		echo "Elle n'existe pas";
```
Et du coup elle existe ou non. On n'aurait même pu faire ça dans un ternaire . Et oui, on peut tout faire dans un ternaire.

Je rappelle la syntaxe correspondante, on pourrait même faire un echo d'un ternaire bien que je suis un peu bizarre. C'est un peu bizarre de faire ceci. Pour vous dire qu'on peut faire également un code qui devient très vite moins lisible.
```php
	echo (isset($maVariable) ? "Elle existe" : "Elle n'existe pas");
```
Voilà on aurait pu faire ça donc là ça deviendrait vite illisible et en plus si on veut entourer le echo, on aurait pu mettre des parenthèses au echo.
	
Mais voilà n'essayez pas de faire des codes … parce que personnellement ce ternaire là je ne le trouve pas très lisible parce qu'il peut y avoir pas mal de parenthèses et on risque d'en oublier ou en mettre de trop bref pas top.

Donc on va préférer mettre ce que j'ai mis au dessus. Là c'est tout de suite beaucoup plus lisible au niveau de la syntaxe.
```php
<?php

$maVariable = "ok";

if(isset($maVariable))
	echo "Elle existe";
else
	echo "Elle n'existe pas";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Elle existe
```
Là variable est définie et du coup elle existe. 

Si par contre, je refais ce test là, après un unset() de ma variable, vous allez voir qu'elle n'existe plus.

```php
<?php

$maVariable = "ok";

if(isset($maVariable))
	echo "Elle existe";
else
	echo "Elle n'existe pas";

unset($maVariable);

if(isset($maVariable))
	echo "Elle existe";
else
	echo "Elle n'existe pas";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Elle existeElle n'existe pas
```
Automatiquement il nous met qu'elle existe, on fait un unset() et après du coup elle n'existe pas. 

Donc isset() est une fonction très important de PHP, je vous la donne dès maintenant. On aurait pu attendre un petit peu avant de vous la donner mais je vous la donne maintenant parce que vous allez voir qu'elle va vous servir beaucoup quand on va travailler sur des formulaires, travailler avec des données. C'est indispensable en terme de sécurité, en termes de bases de données et tout ce que nous allons faire en PHP sur le web de manière générale, on va l'utiliser tout le temps donc s'il y a bien une fonction à retenir par cœur par cœur en PHP, c'est celle-là, isset() pour dire est défini. Est-ce que ma variable est définie ? est-ce que ma variable existe ? et cetera. Elle va retourner true si elle existe et false si elle n'existe pas tout simplement. 

Cette vérification là de faire ça, juste de faire ça ...
```php
	$maVariable = "ok";
	
	if(!isset($maVariable))
		echo "Elle n'existe pas";
```
... Alors cette aide syntaxe vous pouvez si vous voulez la raccourcir donc l'écrire d'une autre manière avec un opérateur assez particulier en PHP qui est le double ? (??). Il ressemble un peu à un ternaire mais pas tout à fait mais alors comment est-ce que ça va fonctionner ? On va noter par exemple `$res` et cette variable va prendre `$maVariable ?? "Elle n'existe pas";`
```php
<?php

$maVariable = "ok";

if(!isset($maVariable))
	echo "Elle n'existe pas";

$res = $maVariable ?? "Elle n'existe pas";
echo $res;
```
Alors ça qu'est-ce que ça va afficher dans le cas … même si je suis d'accord que ce n'est pas très concret comme exemple donc vous n'allez peut-être pas forcément comprendre l'utilité de faire ce genre de synthèse, ça veut simplement dire qu'on vérifie si $maVariable existe donc si elle est "set" donc si elle est "isset" comme dans notre cas. 

Si `$maVariable` existe, ce qu'elle contient va être stocké dans `$res` c'est-à-dire que si `$maVariable` existe, `echo $res` va afficher OK. Sinon si elle n'existe pas grâce à cet opérateur là ?? qui est un opérateur de vérification de l'unité donc de variables qui existent ou non, ça affichera ce qu'il y a après les points d'interrogation "Elle n'existe pas".

J'actualise et ça affiche OK.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	OK
```
En revanche si je fais un unset() juste avant, elle n'existe pas.
```php
<?php

$maVariable = "ok";

unset($maVariable);

$res = $maVariable ?? "Elle n'existe pas";
echo $res;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Elle n'existe pas
```
Elle n'existe pas donc voilà Comment ça va fonctionner, c'est une petite syntaxe raccourci `$maVariable ?? "Elle n'existe pas";` C'est à dire une petite version raccourcie qu'est arrivé avec les dernières versions de PHP 7 qui peut être utile à connaître Alors voilà par exemple personnellement je ne m'en suis jamais servi et honnêtement je ne pense pas m'en servir un jour non plus. 

À chaque fois que vous avez quelque chose de nouveau dans un langage, de nouvelles fonctionnalités et tout ça, n'est pas une raison pour absolument s'en servir alors que peut être oui dans certains cas. En effet ça peut être intéressant par exemple pour améliorer les performances, ça rend le code plus compréhensible, plus logique, plus lisible et cetera donc plein de qualité et plein d'avantages différents mais dans certains cas c'est juste une autre façon d'écrire du code et des fois ça peut apporter des inconvénients et des défauts donc ce n'est pas une syntaxe à utiliser à tout prix. 

Si vraiment vraiment ça vous arrange dans certains cas parce qu'elle est quand même courte à écrire mais personnellement je préférerais toujours utiliser la fonction isset() alors qu'ici on ne l'utilises pas mais d'une certaine manière cet opérateur ?? fait lui-même la vérification de l'existence de la variable $maVariable donc il va en fait faire lui-même le isset() même si dans le fond vous n'allez pas vraiment raccourcir l'exécution de votre programme puisque c'est juste que tout est caché mais en réalité c'est utilisé quand même. 

Au moins on utilisant isset(), on arrive à lire et à comprendre le code, comprendre si cette variable existe ou non comme on l'a fait tout à l'heure. 

Personnellement je n'utilise pas cette syntaxe à parce que je la trouve beaucoup moins lisible encore une fois plutôt que celle de tout à l'heure avec la fonction isset() mais je tenais quand même à vous le montrer parce qu'il faut le connaître vu qu'on travaille avec PHP 7 et toutes les syntaxes qui existent dans ce langage. 

Et on termine du coup avec ces structures conditionnelles. 

Je résume, on a vu le `if` avec éventuellement `if` … `else` … on a vu le switch, on a vu les ternaires, on a vu également cette syntaxe un peu particulière (… ?? …). Nous avons vu tous les opérateurs de comparaison qui sont bien sûr à connaître.
```php
	/*
		Opérateurs de comparaison :
			== 	(égal à)
			=== (identique à : en valeur ET en type)
			!= 	(différent de)
			!== (différence de valeur OU différence de type)
			< 	(inférieur à)
			>	(supérieur à)
			<=	(inférieur OU égal à)
			>=	(supérieur OU égal à)
			<=> (supérieur à, ou égal à ou inférieur à ?)	-> 0  (si A == B)
															-> -1 (si A < B)
															-> 1  (si A > B)
	*/
```
On termine très rapidement et j'en avais parlé dans la vidéo précédente sur des fonctions pour vérifier les types, on avait dit qu'on en parlait plus tard parce que ce n'était pas forcément utile de le faire parce que c'est à utiliser dans des conditions notamment les fonctions qui vérifient un type particulier. Par exemple je vais faire ça.
```php
	$number = 14;
	
	if(...)
		echo "C'est un entier";
```
Comment vérifier que $number est un entier ? On va utiliser la fonction is_int() de $number.
```php
<?php

$number = 14;

if(is_int($number))
	echo "C'est un entier";
```
Si la condition est validé c'est que c'est un entier.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	C'est un entier
```
D'accord parce que évidemment is_int() vérifie que là variable qu'on lui donne est un entier de type mais si en revanche ça devient "14" ça ne valait plus parce que c'est un string.
```php
<?php

$number = "14";

if(is_int($number))
	echo "C'est un entier";
```
Si la condition est validé c'est que c'est un entier.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
```
Alors je vous donne ces fonctions qui sont super importantes dans cette vidéo. Je les note ci-dessous sachez simplement que usuel ça signifie utile pour lequel vous avez : 
```php
	/*
		Opérateurs de comparaison :
			== 	(égal à)
			=== (identique à : en valeur ET en type)
			!= 	(différent de)
			!== (différence de valeur OU différence de type)
			< 	(inférieur à)
			>	(supérieur à)
			<=	(inférieur OU égal à)
			>=	(supérieur OU égal à)
			<=> (supérieur à, ou égal à ou inférieur à ?)	-> 0  (si A == B)
															-> -1 (si A < B)
															-> 1  (si A > B)
		Fonctions usuelles :
			is_bool()
			is_int()	->	is_integer()
			is_float()	->	is_double()
			is_string()
	*/
```
Vous avez is_int() ou is_integer() qui est un alias. Ils ont exactement les mêmes fonctions sauf qu'ils ont créé cette syntaxe également pour ceux qui préfèrent écrire le mot en entier mais moi je conseille d'utiliser celle-là is_int() plus courte et on la comprend très bien et vous pouvez utiliser is_integer() éventuellement. Alors ici c'est surtout pour les types scalaires, on abordera d'autres types comme les types composés mais comme on n'a pas encore parlé, je n'en parlerai pas dans cette vidéo. Alors on a aussi le is_bool(), alors il n'y a pas de is_booleen pour le coup c'est pour ça que je vous dis utilisé à la rigueur les syntaxes courtes parce que dans certains cas il n'y a pas de syntaxes longues. is_int() ou is_integer() éventuellement. is_float() ou bien la syntaxe historique qui est un peu plus enceinte comme on en avait parlé dans les vidéos d'avant c'est-à-dire le is_double(). Et finalement le is_string() pour la chaîne de caractères. Voilà pour les 4 types scalaires. 

Plus tard on aura également la même fonction, le is_array() pour vérifier un tableau, le is_object() pour un objet donc une instance de classe et cetera et cetera. is_collable() Pour une fonction de rappel aussi ça existe. 

Voilà donc les 4 à connaître.
```php
			is_bool()
			is_int()	->	is_integer()
			is_float()	->	is_double()
			is_string()
```
Ce n'est même pas utile de nous embêter avec les versions longues en plus donc on va travailler juste avec ces 4 là.
```php
			is_bool()
			is_int()
			is_float()
			is_string()
```
Rappelez vous au sujet de la vérification avec !==, opérateur qui ne vérifiait qu'un seul des 2 :
```txt
	!== (différence de valeur OU différence de type)
```
Si vous voulez vérifier à la fois que c'est différent de en valeur ET différent de type, vous pouvez tout simplement faire ça, et je terminerai d'ailleurs avec cet exemple là qui va être différent en valeur et différent en type et donc si je m'amusais à faire ceci.
```php
<?php

$nb1 = 14;
$nb2 = "8";

if($nb1 !== $nb2)
	echo "Completement different";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Completement different
```
D'accord donc là ça fonctionne parce que c'est le cas mais par contre à partir du moment où le type est le même donc juste le type.
```php
<?php

$nb1 = 14;
$nb2 = 8;

if($nb1 !== $nb2)
	echo "Completement different";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Completement different
```
Ca fontionne aussi !

Pourquoi est-ce qu'il me le met et qu'il le prend en compte ?

Alors là, c'est plutôt ça que je voulais montrer. Ici on a la même valeur mais on n'a pas le même type.
```php
<?php

$nb1 = 14;
$nb2 = "14";

if($nb1 !== $nb2)
	echo "Completement different";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Completement different
```
Il nous dit que c'est complétement différent alors que ce n'est pas vrai. Ce n'est pas complétement différent parce que la valeur est la même.

Donc le meilleur moyen de vérifier tout complètement, c'est de faire juste une différence donc là on va vérifier l'égalité de valeur && vérifier ça is_int() de $nb1 && is_int() de $nb2 voilà.
```php
<?php

$nb1 = 14;
$nb2 = "14";

if($nb1 == $nb2 && is_int($nb1) && is_int($nb2))
	echo "Tout pareil";
else
	echo "Completement different";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Completement different
```
Si on a `$nb1` qui est égal à `$nb2 && $nb1` est un entier `&& $nb2` est un entier, on est d'accord que ça veut dire qu'ils ont absolument tout pareil pour la valeur et le type.

Donc si on ne rentre pas dans cette condition c'est tout l'inverse, ça veut dire qu'ils ont à la fois pas la même valeur et pas le même type qu'ele qu'il soit, que ce soit un qui soit int et l'autre bool, ou alors qu'ils soient tout les deux bool, ou alors un float et un int et cetera. C'est pour ça que je fait la condition à l'inverse parce qu'il n'y a pas qu'un seul type qui existe, il y en a plusieurs sinon c'est compliqué pour tout traité.

Comme moi je ne passe que par une seule fonction, on est obligé de faire à l'envers la vérification. 

Et bien là effectivement, il va nous mettre complètement différents.

Effectivement il nous met que c'est complètement différent parce qu'on voit qu'ici on n'a pas tous qui est pareil, ils sont du coup complètement différent en traitant les 2. 

Après si je mets le même type et la même valeur, ce sera évidemment tout pareil.
```php
<?php

$nb1 = 14;
$nb2 = 14;

if($nb1 == $nb2 && is_int($nb1) && is_int($nb2))
	echo "Tout pareil";
else
	echo "Completement different";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Tout pareil
```
Et voilà c'est évidemment tout pareil donc on peut vérifier comme ça pour vérifier les 2 choses. 

Si vous voulez vérifier qu'ils sont à la fois de valeurs différentes et de types différents, il faudra du coup faire le test sur les 2 choses donc faire le test sur leur différence `($nb1 == $nb2)` et ensuite les tests sur leurs types.

Alors on peut améliorer. On va passer par une variable intermédiaire parce que le code-là est déjà un peut illible.
```php
	if($nb1 == $nb2 && is_int($nb1) && is_int($nb2))
		...
	-->		$nb1 = 14;
			$nb2 = 14;
			
			$result =...
			
			if($result)
				echo "Différents en valeur ET en type";
```
Oublié ce que j'ai dit un petit peu avant sur les petits tests, c'est pas que ce n'est pas bon mais c'est juste que ce n'est pas forcément complet et c'est peut-être pas forcément le plus simple donc on va faire plus simple. 

On va déjà vérifier le test de différence, il faut que les 2 soient différents, que `$nb1 != $nb2`. Ca ça va être fait tout seul d'un coté.
```php
	$nb1 = 14;
	$nb2 = 14;
	
	$result = ($nb1 != $nb2)...
	
	if($result)
		echo "Différents en valeur ET en type";
```
Et `&&` en même temps, on veux vérifier que gettype() ... on va utiliser cette fonction-là qui serra beaucoup plus éfficace parce que on ne sait pas quel type ça peut être parce que ça peut être plusieurs type différent donc je ne vais pas tester chacun des types sinon on n'a pas finis mais que `gettype($nb1)` est différent du type (d'où l'utilité de cette fonction) de `$nb2`.
```php
<?php

$nb1 = 14;
$nb2 = 14;

$result = ($nb1 != $nb2) && (gettype($nb1) != gettype($nb2));

if($result)
	echo "Différents en valeur ET en type";
```
Voilà des fois voyez qu'ils y a plusieurs manière de faire les choses mais des fois ils y a des manières beaucoup plus éfficaces que d'autres.

Cette manière me semble beaucoup plus sympa.

Donc là, on vérifie à la fois la différence de valeurs `($nb1 != $nb2)` et la différence de type `(gettype($nb1) != gettype($nb2))` donc si c'est 2 conditions sont valides, obligatoirement grâce au &&, il faut absolument que les 2 soient validés. Ensuite ça va retourner true.

Si $result est bien égale à true, ça soulignera bien le fait qu'ils sont de différentes valeurs et entier sinon soit ils sont pareil en valeur ou alors ils sont pareil en type.

Et alors là je fait F5 et du coup.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
```
ET du coup voit que ça ne rentre pas.

Si je fait ça, ça ne devrait pas rentrer non plus.
```php
<?php

$nb1 = 14;
$nb2 = "14";

$result = ($nb1 != $nb2) && (gettype($nb1) != gettype($nb2));

if($result)
	echo "Différents en valeur ET en type";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
```
Ca ne rentre pas non plus parce qu'ils n'ont pas le même type mais ils ont la même valeur donc il faut absolument que je change tout et le type, et la valeur pour que ça valide la condition.
```php
<?php

$nb1 = 14;
$nb2 = "8";

$result = ($nb1 != $nb2) && (gettype($nb1) != gettype($nb2));

if($result)
	echo "Différents en valeur ET en type";
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/009_conditions/
	Différents en valeur ET en type
```
Donc si vous voulez éventuellement avoir … plus tard quand on verra les fonctions, un jour je vous ferai une fonction qui vérifie à la fois le type et la valeur de quelque chose. on peut donc mettre ce genre code à l'intérieur d'une fonction, de faire par exemple simplement un return dans une fonction.
```php
	// return ($nb1 != $nb2) && (gettype($nb1) != gettype($nb2));
```
Je le mets ici en commentaire parce que ce sont des choses que vous n'avez pas encore vu mais on aurait une fonction qui aurait simplement cette ligne. Elle prendrait simplement 2 paramètres mais on parlera plus tard des fonctions dont on parlera dans la vidéo suivante. 

On va aborder les fonctions si c'est suffisant par rapport à la progression que je veux faire dans cette formation et on dira simplement de retourner le résultat de ça.
```php
	($nb1 != $nb2) && (gettype($nb1) != gettype($nb2));
```
Et du coup on aura une petite fonction à nous qu'on aura créé qui permettra de vérifier que 2 variables par exemple sont à la fois différente en valeur et entier donc ça peut être sympa à tester ça.

Voilà voilà je vous laisse du coup avec cette grande vidéo sur les conditions qui est encore une fois une notion très importante à connaître en programmation ici en PHP.

On se retrouve la prochaine fois pour une nouvelle structure de contrôle à savoir les boucles voilà ce sera la prochaine vidéo sur ce cours en PHP.

À bientôt tout le monde, bon codage