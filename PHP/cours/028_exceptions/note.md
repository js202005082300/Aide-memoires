# [28. Exceptions](https://www.youtube.com/watch?v=ePFxa2VcCoE)
12-12-2020

Bonjour tout le monde et bienvenue sur cette séance 28 sur le cours PHP. 

On avait vu dans la séance 13 comment gérer les erreurs via ce langage et on n'avait évidemment pas abordé la chose avec le paradigme objet. 

On avait vu comment ça se passait au niveau procédural, avec du PHP procédural mais il faut savoir que PHP intègre en natif une classe qui va permettre de gérer nos erreurs que l'on appelle en tout cas les exceptions. 

Alors les exceptions qu'est-ce que c'est ? c'est une classe qui définit tout un tas d'erreurs qui peuvent survenir au niveau d'un code et qui vont permettre de les traiter par la suite. 

Alors on va déjà regarder comment est-ce qu'on peut en produire, comment est-ce qu'on peut produire une exception au niveau de notre code. 

Alors une exception ça peut intervenir dans plusieurs cas. 

Il existe en réalité plusieurs types d'erreurs, comme il existe plusieurs types d'exceptions. 

On peut avoir par exemple une exception qui va se produire quand vous allez tenter de faire une division par 0. 

Alors on peut faire l'exemple ici. On va faire par exemple `$res = 15/0;`
```php
<?php

$res = 15/0;

echo $res;
```
```txt
	http://localhost/PHP/cours/028_exceptions/
	Warning: Division by zero in C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\apache\htdocs\PHP\cours\028_exceptions\index.php on line 24
	INF
```
Nous obtenons donc comme vous voyez un warning pour le coup division by 0. 

On peut également avoir par exemple un tableau qui contient certains éléments genre on va avoir un tableau de 3 cases et on essaie d'accéder à l'élément d'indice 10 qui évidemment n'existe pas.
```php
<?php

$tableau = [1, 2, 3];

echo $tableau[10];
```
```txt
	http://localhost/PHP/cours/028_exceptions/
	Notice: Undefined offset: 10 in C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\apache\htdocs\PHP\cours\028_exceptions\index.php on line 38
```
Voilà on a un Out of range c'est à dire qu'on va dépasser en fait l'index donc là il nous dit que l'offset, l'index n'existe pas.

Et on peut avoir tout un tas de choses. Alors ici ce sont des erreurs (warning) ou juste des avertissements (notice) ce genre de chose, il n'y a pas forcément ici d'exception mais dans certains cas avec certains objets particuliers ou autre, on va avoir des exceptions qui vont être produites avec notre code. 

Ça peut être des exceptions plus tard quand on verra qu'on manipulera des bases de données, on aura peut être un échec de connexion à une base de données dans le cas où on n'arrive pas à trouver une base de données, on pourra éventuellement avoir une exception par rapport à ça. 

Alors ce principe d'exception est très intéressant parce qu'encore une fois c'est de l'objet, c'est de la programmation objet et ça va vous permettre de comprendre un des avantages de ce type de paradigme contrairement au paradigme procédural c'est justement la possibilité de réutiliser du code. 

On va voir par la suite un petit peu tout ce que ça va pouvoir nous apporter alors là grosso modo on a vu qu'est-ce que c'était qu'une exception mais on va voir comment on peut provoquer nous-mêmes une exception parce que c'est évidemment quelque chose que nous pouvons faire.

Alors ce qu'on va faire pour ça c'est utiliser un bloc que l'on appelle un bloc ce que l'on appelle le try catch. Qu'est-ce que le try catch ?

Vous allez définir ici un bloc try.
```php
	try
	{
		
	}
```
try qui veut simplement dire qu'on va essayer de réaliser une opération, quelque chose d'un peu sensible qui pourrait éventuellement soulever une erreur donc on va le tenter. 

On va faire par exemple mais je ne sais pas si ça lèverait une exception pour le coup mais on va quand même regarder et on verra bien même si je ne pense pas que ça lève une exception tel que se définit par défaut.
```php
	try
	{
		$res = 15 / 0;
		echo $res;
	}
```
Et ensuite nous devons capturer l'exception que nous voulons. Il y a des exceptions avec des types particuliers, vous avez par exemple Division By Zero Error, vous avez ensuite l'exception de base qui est tout simplement le terme Exception comme ceci.
```php
	try
	{
		$res = 15 / 0;
		echo $res;
	}
	catch(Exception $e)		catch(TypeError $e)		catch(ParseError $e)
	{						{						{
		
	}						}						}
```
Voilà la capture dans une variable `$e` et on voyait que ça se met en jaune dans l'éditeur. 

`$e` est donc là variable qui va récupérer l'exception.

Alors Exception est le type de base mais on peut avoir des fois le TypeError ou on aura aussi un `ParseError $e` cetera et cetera, vous n'avez pas besoin de les connaître par coeur. Vous regarder dans la documentation si vous voulez avoir les différents types qui existent mais ce n'est pas forcément utile de les connaître.

Le truc c'est qu'en mettant déjà `Exception $e`, on va déjà capturer tous les types d'exceptions qui peuvent survenir au niveau de ce code c'est-à-dire que si `$res=15/0;` génère une exception, lève une exception tel qu'on va le voir par la suite, on sait qu'on va pouvoir la capturer dans le bloc Exception ici global. 

À partir de là, la classe Exception possède quelques méthodes comme par exemple la méthode `getMessage();` qui affiche le message d'erreur qui est intervenu. 
```php
	try
	{
		$res = 15 / 0;
		echo $res;
	}
	catch(Exception $e)
	{					
		$e->getMessage();
	}	
```
On peut retrouver aussi getFile() pour avoir le fichier où il n'y a eu l'erreur. On va avoir getLine(), la ligne où il y a eu l'erreur du fichier et aussi getCode() éventuellement et ça ce sont les accesseurs sur tel qu'on les a déjà vu en PHP.
```php
	try
	{
		$res = 15 / 0;
		echo $res;
	}
	catch(Exception $e)
	{					
		$e->getMessage();
		//getFile(), getLine(), getCode()
	}					
```
Ce sont les getters et les setters mais là pour le coup les getters qui nous permet de récupérer les différentes informations de l'exception. 

C'est donc une classe très simple si vous voulez voir comment est constitué la classe Exception, pareil dans le Manuel de PHP, elle n'a pas grand chose en propriétés et méthodes. Elle est assez simple à comprendre et tout à fait clair. 

On fait donc ce genre de choses et on a le code minimal.
```php
<?php

try
{
	$res = 15 / 0;
	echo $res;
}
catch(Exception $e)
{					
	$e->getMessage();
}
```
On a le code midi de mal c'est-à-dire qu'on teste un code try et qu'il y a une petite possibilité que la division ne marche pas mais ici on a un code en dur 15/0 donc là on vérifie la chose mais imaginez qu'on ait demandé un calcul par un utilisateur. 

Eh bien si l'utilisateur est amené a tenté une division par 0, on doit pouvoir prévoir ce cas d'erreur possible donc on le prévoit grâce à `catch(Exception $e)`, catch() tout simplement pour capturer. 

C'est-à-dire que `$res=15/0;` pourrait lever une erreur ou une exception et une fois qu'une exception est lever, vous allez voir qu'il faut la récupérer. 

Si on ne la récupère pas ça ne sert à rien, on ne va pas traiter l'erreur donc nous on la récupère avec catch() et on affiche le message éventuel. 

Alors ici je ne suis pas sûr que ça lève une exception.
```php
	http://localhost/PHP/cours/028_exceptions/
	Warning: Division by zero in C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\apache\htdocs\PHP\cours\028_exceptions\index.php on line 125
	INF
```
Alors on mettre `echo 'ERREUR<br>'` pour voir s'il passe dedans.
```php
<?php

try
{
	$res = 15 / 0;
	echo $res;
}
catch(Exception $e)
{					
	echo 'ERREUR<br>';
	$e->getMessage();
}
```
```txt
	http://localhost/PHP/cours/028_exceptions/
	Warning: Division by zero in C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\apache\htdocs\PHP\cours\028_exceptions\index.php on line 125
	INF
```
Alors évidemment il ne rentre pas dedans. 

Il nous prend juste comme un avertissement et pas comme une exception. 

Du coup on va peut être le traité nous-mêmes parce que je ne vais pas réussir à lever une exception ici parce que au stade Van en est au niveau de la formation, on n'a pas encore vu beaucoup d'objets que l'on a manipulé mais autant pour les bases de données, on pourra lever des exceptions volontairement et facilement mais ici c'est un petit peu plus complexe. 

Ce n'est pas que c'est plus complexe mais c'est qu'il y a plein de choses que vous n'avez pas encore vu un peu PHP que je ne peux pas vous montrer. 

Ce qu'on va donc faire c'est qu'on va lever nous-mêmes l'exception c'est-à-dire que au lieu d'attendre que PHP lève une exception lui-même, on va le faire manuellement et de toute façon c'est quelque chose qui est bien à savoir. 

Par exemple on va avoir une variable ici, `$age` et on va par exemple dire si l'âge est plus petit que 18, Eh bien on va lever une exception et nous comme on ne veut pas lever une exception en particulier, on va donc lever une exception générale avec le mot-clé throw qui veut dire lever une nouvelle, new parce qu'on crée une nouvelle instance de Exception et rappelez-vous que c'est une classe. 
```php
	$age = 19;
	
	try
	{
		if($age < 18)
			throw new Exception(...);
	}
	catch(Exception $e)
	{					
		echo $e->getMessage();
	}
```
On crée une instance de la classe Exception donc on crée un objet et ici on peut lui passer dans le constructeur le message d'erreur par exemple 'Tu n\'es pas majeur' ce genre de chose.
```php
<?php

$age = 19;

try
{
	if($age < 18)
		throw new Exception('Tu n\'es pas majeur');
}
catch(Exception $e)
{					
	echo $e->getMessage();
}
```
Et là automatiquement si le try ici lève une exception, ça va rentrer dans le catch() automatiquement parce que vous voyez qu'on a le même type Exception et ça c'est le type général donc on capture toutes les exceptions possibles, on les stocks dans `$e`.

$e la variable qui va stocker l'instance de l'exception qui aurait été levé et du coup après comme un simple objet comme vous l'avez appris dans les vidéos précédentes, on peut utiliser les méthodes de notre objet donc pas de souci.

Alors là pour le coup il ne va rien se passer.
```txt
	http://localhost/PHP/cours/028_exceptions/
```
Pour le coup il ne va rien se passer parce que vous voyez que `$age` est bien supérieur à 18 mais par contre si je mets 17.
```php
<?php

$age = 17;

try
{
	if($age < 18)
		throw new Exception('Tu n\'es pas majeur');
}
catch(Exception $e)
{					
	echo $e->getMessage();
}
```
```txt
	http://localhost/PHP/cours/028_exceptions/
	Tu n'es pas majeur
```
Et là vous voyez qu'on a le message de l'exception tout simplement. 

On pourrait même également afficher le fichier, getFile().
```php
<?php

$age = 17;

try
{
	if($age < 18)
		throw new Exception('Tu n\'es pas majeur');
}
catch(Exception $e)
{					
	echo $e->getMessage();
	echo $e->getFile();
}
```
```txt
	http://localhost/PHP/cours/028_exceptions/
	Tu n'es pas majeurC:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\apache\htdocs\PHP\cours\028_exceptions\index.php
```
Voyez on retrouve carrément le chemin vers le fichier, index.php celui qu'on est en train d'exécuter. 

Voilà c'est vachement intéressant, très utile parce que vous verrez par la suite qu'il faudra vous servir tout le temps soit de la gestion des erreurs comme vous l'avez vu dans la vidéo numéro 13 ou alors si vous travaillez dans le paradigme objet d'utiliser les exceptions mais au moins l'un des 2. 

L'intérêt dans un vrai programme, un vrai projet c'est de gérer ces erreurs et éventuellement les exceptions qui peuvent intervenir.

Alors là où c'est intéressant encore une fois parce que maintenant vous avez vu ce que c'était qu'une exception, vous avez vu comment ça pouvait se produire même si je n'ai pas beaucoup d'exemples à vous montrer parce que encore une fois on n'a pas trop vu de classes natives en objet en PHP ce qui n'est pas forcément pratique pour vous montrer des exemples concrets mais on aura l'occasion de le voir avec le prochain chapitre en PHP. 

Ne vous en faites pas on reviendra dessus à ce moment-là.

Et si je vous ai montrer comment gérer, capturer une exception avec ce fameux bloc try catch et comment manuellement lever une exception. 

Alors le try catch comment ça se passe encore une fois, dans le bloc try on essaye de faire quelque chose qui est susceptible de lever une exception ou alors on le fait nous manuellement et dans un bloc catch on capture tout ce qu'il y a. 

Par exemple si vous voulez capturer un autre type, qu'on voudrait capturer par exemple le TypeError ce genre de chose, on peut très bien les cumuler comme ça.
```php
	$age = 17;

	try
	{
		if($age < 18)
			throw new Exception('Tu n\'es pas majeur');
	}
	catch(TypeError $e)
	{
		
	}
	catch(Exception $e)
	{					
		echo $e->getMessage();
		echo $e->getFile();
	}
```
Sinon le bloc try à un moment donné une TypeError qui levé, Eh bien on rentrera dans le bloc `catch(TypeError $e){}` et si c'est pas le cas on va continuer continuer généralement sur la fin on met le bloc général `catch(Exception $e){}` pour capturer tout ce qu'il y aurait, tout ce qui serait passé au travers avant. 

Vous voyez donc que vous pouvez cumuler comme ça les catch() les uns à la suite, et vous mettez dans le dernier catch() le Exception général comme ça vous capturez tous les types d'exceptions éventuellement. 

Alors TypeError n'est pas un type d'exception mais c'est un type d'erreur. 

Pour les exceptions pourraient par exemple avoir au niveau des bases de données, PDOException.
```php
	$age = 17;

	try
	{
		if($age < 18)
			throw new Exception('Tu n\'es pas majeur');
	}
>	catch(PDOException $e)
	{
		
	}
	catch(Exception $e)
	{					
		echo $e->getMessage();
		echo $e->getFile();
	}
```
On verra plus tard, on pourra capturer ça et ce qui n'est pas du PDOException, on le capture avec le reste. 

On a également un autre bloc qu'on n'a pas vu qui va lui s'exécuter peu importe ce qu'il se passe, qu'il y ait une exception levé ou non donc en bref qu'il y a eu un problème avec le code ou pas avec finally.

finally ça veut dire finalement dans tous les cas, peu importe ce qu'il se passe avec le code, tu exécutes ce qu'il y a dans ce bloc là.
```php
	$age = 17;

	try
	{
		if($age < 18)
			throw new Exception('Tu n\'es pas majeur');
	}
	catch(Exception $e)
	{					
		echo $e->getMessage();
	}
	finally
	{
		
	}
```
Alors ça peut servir à quoi ? Imaginez un fichier, vous venez d'ouvrir un fichier il faut tenter de faire je ne sais pas quoi dessus un traitement sur le fichier, salut une exception que vous mettez ici.
```php
	$age = 17;

	try
	{
		if($age < 18)
			throw new Exception('Tu n\'es pas majeur');
	}
	catch(Exception $e)
	{					
>		echo $e->getMessage();
	}
	finally
	{
		
	}
```
Donc l'exception vous la mettez ici, vous indiquez un message d'erreur il vous a prêté à quitter le programme ou arrêter l'exécution. 

On a appris qu'un fichier doit être fermé, afficher les qualités ouvert doit être absolument être fermé donc il faudra dans tous les cas qu'il y ait eu une erreur quand on a voulu écrire dans le fichier ou non, ou pas, qu'il soit fermé donc on mettra par exemple la fermeture du fichier dans le finally. 

Comme ça même s'il y a eu une erreur quand on a voulu travailler dans le fichier, dans la mesure où il a pu être ouvert, on est obligé de le fermer dans tous les cas qu'il y ait une erreur après ou pas. 

Voilà à quoi sert ce bloc finally mais pareil je n'ai pas forcément un exemple très concret mais de toute façon avec tout ce qu'on va voir par la suite avec PHP même dans les tutos ou dans des projets, de toute façon on mettra vraiment en application ça. 

Vous verrez par exemple quand on attaquera les bases de données, on utilisera les exceptions parce qu'il faudra absolument s'en servir. 

Ce sera le bon moment pour mettre ça en application au niveau du cours donc là je vous montre rapidement comment ça fonctionne mais si vous voulez voir ça dans un cas concret, on le mettra en application lorsqu'on abordera le dernier chapitre du cours c'est-à-dire celui sur les bases de données donc on verra tout ça avec la gestion des bases de données. 

Voilà tout ce qu'on a vu grosso modo et j'en viens en dernier point qui me semble important et qui concerne tout ce qui est le paradigme objet, quels avantages y a-t-il à programmer en objet par rapport à l'impératif ou autre ?

C'est la réutilisation du code. 

Vous avez vu que par défaut on a des types d'exceptions par exemple la division par 0 lorsqu'on déborde d'un tableau ou autre ou d'une connexion lorsqu'on a une exception générale mais imaginez qu'un jour vous voulez faire une gestion d'utilisateur et que vous voulez valider, filtrer le type d'e-mail d'un utilisateur. Et dans ce cas-là si l'email n'est pas valide, vous voulez gérer un type d'exception sauf que PHP n'a pas créé un type d'exception pour les e-mails sinon si vous imaginez que les créateurs du langage se serait amusé à faire ça, ils ont recréé des milliers et des milliers de classes d'exceptions pour chaque qu'a possible. 

Et de toute façon ça n'aurait peut-être pas collé avec tout le monde parce que peut-être vous ne voulez pas valider des e-mails vous comme le ferait un autre développeur donc ce serait juste ingérable. 

C'est là qu'intervient un des avantages de la programmation objet, c'est la réutilisation du code. 

C'est-à-dire que à partir du moment où vous avez une classe et on l'a vu sur le court sur l'héritage, vous pouvez étendre des classes. 

Ce que je ne vous est pas forcément dit, c'est que vous pouvez et ça paraît logique, étendre des classes que vous n'avez pas vous-même développé donc Exception est une simple classe en PHP. 

Vous pouvez créer votre classe fille qui gère un certain type d'exception particulier qui étend la classe générale. 

On va donc faire pour ça, je vais mettre un nom explicite MyExceptionClass qui étend la classe principale.
```php
	class MyExceptionClass extends Exception
	{
		
	}

	$age = 17;

	try
	{
		if($age < 18)
			throw new Exception('Tu n\'es pas majeur');
	}
	catch(Exception $e)
	{					
		echo $e->getMessage();
	}
	finally
	{
		
	}
```
L'avantage est sa vous l'avez vu sur la vidéo sur l'héritage si vous ne l'avez pas compris il faut retourner sur cette vidéo parce que c'est très important, tout ce qui est les méthodes, les attributs tout ce qui est dans la classe Exception en tout cas ce qui est en protected ou public sera accessible ou utilisable par ma classe à moi. 

L'avantage c'est qu'ici la méthode getMessage(), je vais pouvoir l'utiliser ici et le mieux c'est que je vais pouvoir redéfinir un constructeur différent ou carrément ajouter une nouvelle méthode, je pourrais par exemple ajouter show_email_error_message() pour gérer un message particulier sur une erreur sur une e-mail d'accord.
```php
	class MyExceptionClass extends Exception
	{
>		public function show_email_error_message();
	}

	$age = 17;

	try
	{
		if($age < 18)
			throw new Exception('Tu n\'es pas majeur');
	}
	catch(Exception $e)
	{					
		echo $e->getMessage();
	}
	finally
	{
		
	}
```
Dans ce cas là Comment ça va fonctionner au niveau du code ? 

Admettons combien d'utilisateurs sur un formulaire, et l'utilisateur à saisi un e-mail que vous allez récupérer ça dans une variable `$email`. Je mets un exemple ici.
```php
	class MyExceptionClass extends Exception
	{
		public function show_email_error_message();
	}
	
	//Formulaire
	$email = '';
```
Par exemple ce genre de chose et admettons que vous voulez traiter le mail. 

Par exemple vous faites un test avec des fonctions ou pas pour vérifier ça peut être par exemple les fonctions comme filter_var() qui permet notamment de valider un mail éventuellement. 

Voilà par exemple,
```php
	class MyExceptionClass extends Exception
	{
		public function show_email_error_message();
	}
	
	//Formulaire
	$email = 'ton@mail.com';
	
	if(filter_var($email, FILTER_VALIDATE_EMAIL))
		...
```
En bref si ça valide, on pourra dire que c'est bon et admettons que ça ne valide pas la syntaxe de l'email, on peut lever notre exception, on peut faire un `throw new MyExceptionClass('E-mail incorrect')` en mettant un message par exemple.
```php
	class MyExceptionClass extends Exception
	{
		public function show_email_error_message();
	}
	
	//Formulaire
	$email = 'ton@mail.com';
	
	if(filter_var($email, FILTER_VALIDATE_EMAIL))
		throw new MyExceptionClass('E-mail incorrect');
```
Et vous pouvez ensuite gérer vos propres méthodes, ce qu'il se passe. 

Alors ce qu'on peut faire du coup toujours pareil, on va faire un try et mettre ça proprement dans quelque chose donc on va faire le test de l'email qu'on récupère avant.
```php
	class MyExceptionClass extends Exception
	{
		public function show_email_error_message();
	}
	
	//Formulaire
	$email = 'ton@mail.com';
	
	try
	{
		if(filter_var($email, FILTER_VALIDATE_EMAIL))
			throw new MyExceptionClass('E-mail incorrect');
	}
```
Et là comme on a levé une exception avec try, je peux évidemment faire catch() avec ma propre exception.
```php
	class MyExceptionClass extends Exception
	{
		public function show_email_error_message();
	}
	
	//Formulaire
	$email = 'ton@mail.com';
	
	try
	{
		if(filter_var($email, FILTER_VALIDATE_EMAIL))
			throw new MyExceptionClass('E-mail incorrect');
	}
	catch(MyExceptionClass $e)
	{
		
	}
```
Et comme ça il reste de la classe Exception native de PHP, je peux évidemment soit utiliser ma méthode à moi, vous savez la nouvelle méthode.
```php
	class MyExceptionClass extends Exception
	{
		public function show_email_error_message();
	}
	
	//Formulaire
	$email = 'ton@mail.com';
	
	try
	{
		if(filter_var($email, FILTER_VALIDATE_EMAIL))
			throw new MyExceptionClass('E-mail incorrect');
	}
	catch(MyExceptionClass $e)
	{
		echo $e->show_email_error_message();
	}
```
Et là pour le coup comme je n'ai rien mis dans show_email_error_message(), elle va ne rien faire donc ce n'est pas intéressant mais on peut évidemment utiliser toutes les méthodes dont elle a hérité depuis la classe mère voilà.
```php
	class MyExceptionClass extends Exception
	{
		public function show_email_error_message();
	}
	
	//Formulaire
	$email = 'ton@mail.com';
	
	try
	{
		if(filter_var($email, FILTER_VALIDATE_EMAIL))
			throw new MyExceptionClass('E-mail incorrect');
	}
	catch(MyExceptionClass $e)
	{
		//echo $e->show_email_error_message();
		echo $e->getMessage();
	}
```
Ça c'est très important, d'une classe de base en PHP vous pouvez écrire vos propres classes étendues, spécialisées c'est-à-dire qu'elle possède tout ce que a la classe mère avec des choses en plus. 

Et ça si vous ne l'aviez pas compris jusqu à présent, C'est ainsi la vidéo qui va permettre de passer un peu le cap, c'est un des avantages de la programmation objet. C'est le fait de pouvoir réutiliser du code parce qu'on est bien d'accord qu'un code doit être au maximum générique, un maximum réutilisable parce qu'on ne pourra pas toucher tous les cas possible. 

Il était impossible pour le créateur d'un langage de se dire qu'on va faire un type d'exception pour la validation d'un e-mail, la validation d'un code postal en France, la validation d'un code postal en Amérique. 

Enfin vous imaginez s'il fallait gérer un type d'exception pour chaque cas possible, il faudrait vraiment des milliers des milliers de milliers de classe. 

Et en plus en utilisant une classe précise par rapport à une donnée précise, pas sûr que ça rentrerait dans vos exigences à vous en tant que développeur. 

L'avantage là c'est qu'on a une classe générale qui s'utilise très facilement Exception, on peut créer notre classe qui étend cette dernière MyExceptionclass et choisir qu'est-ce qu'on fait avec, qu'est-ce qu'on spécialisent, qu'est-ce qu'on vérifie ? bref ce genre de chose. 

Et on garde du coup toute la puissance et toute l'utilisation le système d'exception en PHP. 

Et c'est là que c'est tout à fait intéressant. 

Voilà pour cette séance et je pense qu'on a fait le tour. 

Je vous dis on n'a pas vu grand grand chose parce que c'est très simple, c'est vraiment très simple à aborder. 

C'est juste à mettre en place. 

Alors la petite astuce, le petit conseil par rapport à ça, c'est qu'à partir du moment où vous manipuler des objets ou autres parce que là quand vous ne manipulez pas des objets, vous gérez des erreurs donc ça vous pouvez vous en remettre la gestion des erreurs telle qu'on faisait dans la vidéo 13. 

Ça ne veut pas dire qu'une fois que vous avez vu les exceptions, tout ce que vous avez vu dans la séance 13 n'est pas à faire mais au contraire les 2 reste tout à fait valide et doivent être utilisé en complément par contre dès que vous allez commencer à manipuler des objets en PHP et bien ces objets en général selon les cas et selon les méthodes peuvent lever des exceptions. 

Quand vous voyez donc il y a possibilité en consultant les Manuel des méthodes que vous utilisez tout ça, il n'y a pas besoin d'apprendre par cœur, il n'y a pas de Secret, il faut connaître les retours des méthodes et il faut connaître les retours des fonctions pour savoir ce qu'elles peuvent générer. 

Quand vous voyez qu'il y a une méthode qui peut lever un certain type d'exception lorsque c'est marqué dans la doc que ça peut lever un certain type d'exception, et que vous avez récupéré une bibliothèque externe en PHP où le développeur a marqué que telle méthode peut lever tel type d'exception s'il y a eu tel problème. 

Eh bien à ce moment-là quand vous utilisez cette méthode en particulier ou ce traitement particulier, vous mettez ça dans un bloc try catch. 

Vous mettez la partie sensible qui risque d'entraîner une erreur dans le bloc try comme ça en cas de lever d'exception, vous êtes sûr de la capturer et de traiter l'erreur, et ça c'est évidemment très important de traiter les erreurs dans un programme et de ne pas les laisser comme ça n'importe comment et d'avoir comme ça un programme se serait planté sans qu'on gère l'erreur qui a pu survenir donc ça c'est très très très important. 

Vous avez du coup maintenant 2 vidéos sur son cours PHP pour gérer vos erreurs. 

La séance numéro 13 pour tout ce qui est procédural et vous avez du coup cette séance numéro 28 qui gère tout ce qui est propre à l'objet parce que l'exception est un objet. 

L'exception est une classe en PHP que vous pouvez évidemment étendre sans problème. 

Alors si par exemple vous n'avez pas de gestion des exceptions, le PHP comme pour la gestion d'erreur qu'on avait vu sur la séance 13, va utiliser votre gestionnaire par défaut s'il y en a un qui est défini. 

Si vous voulez définir un gestionnaire par défaut c'est-à-dire quelque chose qui serait un minimum c'est-à-dire que plutôt que de ne rien définir c'est toujours mieux de définir quelque chose au minimum. 

Vous pouvez très bien vous faire une petite fonction ce qui serait un peu bizarre et pas forcément très propre mais bon admettons je vous faites par exemple une classe pour gérer plus tard les erreurs dans votre projet, vous faites une fonction show_error() et vous mettez par exemple votre exception $ex et puis vous voulez qu à chaque fois qu'il y a une exception par exemple ça vous affichera un gros message ERREUR en majuscule comme ça et du coup on afficherait ça de cette manière.
```php
	function show_error($ex)
	{
		echo 'ERREUR : '.$ex->getMessage();
	}
```
Voilà on affiche ça de cette manière c'est-à-dire qu'on affiche toujours ça ou éventuellement un numéro de ligne, que ça vous fasse un tableau qui vous affiche le message d'erreur et puis le fichier, la ligne et cetera. 

Enfin bref vous gérez le formatage que vous voulez et après vous définissez le gestionnaire d'exceptions par défaut avec la fonction set_exception_handler() et à l'intérieur vous mettez tout simplement le nom de votre fonction.
```php
	function show_error($ex)
	{
		echo 'ERREUR : '.$ex->getMessage();
	}
	
	set_exception_handler('show_error');
```
Voilà comme ça s'il n'y a rien qui est géré. 

On va le faire ici et on va lever une exception pour tester, on va faire un test de base avec par exemple "Utilisateur introuvable" et normalement si je ne suis pas gouré dans la syntaxe il devrait utiliser ma fonction.
```php
<?php

function show_error($ex)
{
	echo 'ERREUR : '.$ex->getMessage();
}

set_exception_handler('show_error');

throw new Exception("Utilisateur introuvable");
```
Là vous voyez Exception() comme je ne définit aucune classe particulière ou autre, comme je n'ai pas fait de bloc try catch c'est-à-dire que je n'ai pas géré et capturé mon exception, il va essayer d'utiliser le gestionnaire par défaut défini. 

Ici ça tombe bien parce que j'en ai fait un avec set_exception_handler() donc on va dire que ça limite la casse même si évidemment le plus propre c'est de faire un bloc try catch pour gérer nos exceptions. 

Ceci c'est le minimum à faire si vous voulez pas gérer vos exceptions même si ça reste mieux à l'usage donc ici voilà.
```txt
	http://localhost/PHP/cours/028_exceptions/
	ERREUR : Utilisateur introuvable
```
Là donc il n'y a pas de problème et vous voyez qu'il récupère directement ça en utilisant mon gestionnaire par défaut. 

Ci-après il n'y a pas de gestionnaire défini par défaut, vous aurez évidemment quelque chose de moins propre.
```php
<?php

function show_error($ex)
{
	echo 'ERREUR : '.$ex->getMessage();
}

//set_exception_handler('show_error');

throw new Exception("Utilisateur introuvable");
```
```txt
	http://localhost/PHP/cours/028_exceptions/
	Fatal error: Uncaught Exception: Utilisateur introuvable in C:\...\index.php:785 Stack trace: #0 {main} thrown in C:\...\index.php on line 785
```
On va se retrouver avec des messages bizarres notamment une erreur fatale qui vous dit Uncaught Exception et ça pas besoin de parler l'anglais pour savoir ce que ça veut dire, c'est tout simplement une exception qui n'a pas été capturée voilà. 

On vous met quand même le message "utilisateur introuvable" et le numéro de ligne. On vous met tout un tas de lignes bizarre toutes les informations d'un coup mais c'est peut être mieux dans votre cas d'avoir des informations compréhensibles parce que là tout est mélangé on voit un #0 {main} … bref tout est mis un petit peu n'importe comment l'un à la suite des autres donc c'est bien des fois de gérer ça correctement. 

Ça c'était la petite astuce pour la fin pour définir un gestionnaire par défaut. 

Vous créez votre petite fonction et vous les définissez là sans problème avec set_exception_handler().

Je crois qu'on l'avait déjà fait dans la gestion des erreurs, on avait fait directement ça avec une closure c'est-à-dire qu'on avait mis une fonction à l'intérieur c'est-à-dire que au lieu de mettre le nom de la fonction 'show_error', on avait directement définit la fonction dans le paramètre à l'intérieur de set_exception_handler(). 

Mais bon ça revient exactement au même sauf qu'ici on le fait en 2 étapes au lieu de tout mettre en une fois.
```php
	function show_error($ex)
	{
		echo 'ERREUR : '.$ex->getMessage();
	}

	set_exception_handler('show_error');
```
Voilà du coup on va s'arrêter là et je pense que je vous ai tout dit au stade vous en êtes au niveau de ce cours PHP.

Si vous n'avez pas encore compris la mise en application dans quelqu'un ça peut être utile parce que je n'ai pas pu vous montrer une vraie lever d'exception faites par PHP, on le verra dans le prochain chapitre et on va bientôt attaquer le prochain et le dernier chapitre de ce cours en PHP sur les bases de données. 

Et les bases de données on va mettre en place la gestion des exceptions et donc on sera obligé de le faire et vous verrez pourquoi. 

Vous aurez donc un cas concret et réel d'une lever d'exception qui peut survenir directement via PHP c'est-à-dire que c'est lui qui lèvera directement l'exception lui-même. 

Ce n'est pas nous qui iront directement faire un `throw new Exception()` comme ça comme on l'a fait ici. 

Voilà je vous laisse sur cette fin et je vous dis à bientôt pour la suite. 

La prochaine fois on aborde la dernière vidéo avant de passer à ce nouveau chapitre concernant les expressions rationnelles, c'est un point qui me semble très important PHP. 

A la base j'aurait pu le mettre sous forme de tutoriel mais comme c'est quelque chose qu'on a très très souvent besoin en web, Eh bien je trouvais plus logique de le mettre directement dans le cours plutôt que de le mettre en simple tutoriel en annexe. 

Ce sera la dernière vidéo de cet avant-dernier chapitre avant d'attaquer le dernier chapitre de ce cours encore une fois sur les bases de données. 

Et après on aura terminé avec ce cours PHP et vous aurez fait le tour de ce langage là au niveau du cours en tout cas. 

Il y aura toujours des choses qui seront ajoutées par la suite dans les tutoriels et les exercices. 

Vous avez des playlists d'exercice qui sont complétés au fur et à mesure qui permet de revoir et de mettre en application tout ce que vous avez vu sur ce cours de manière progressive avec une difficulté croissante. 

Je vous dis à bientôt pour la prochaine vidéo en PHP et à bientôt sur la chaîne formation vidéo. 

Ciao tout le monde