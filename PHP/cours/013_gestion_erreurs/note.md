# [13. Gestion erreurs](https://www.youtube.com/watch?v=AP1nR-5QZss)

Bonjour tout le monde bienvenue sur cette séance 13 en PHP. 

Nous allons voir comment gérer nos erreurs en programmation avec différents systèmes qui vont énormément vous servir par la suite et qu'on aura l'occasion de réutiliser dans les séances prochaine qui nous permettront de gérer certains cas d'erreurs qui peuvent survenir pour certains fonctionnement de nos programmes. 

Je tenais à faire cette séance maintenant par rapport au niveau où vous en êtes en PHP. C'est le moment d'aborder ça et par la suite n'hésitez pas à vous servir de tout ce que vous allez voir dans cette vidéo pour les vidéos futures même si je ne reviendrai pas toujours dessus pour ne pas faire des vidéos trop longues à chaque fois. 

N'hésitez pas à chaque fois que vous allez avoir des erreurs qui surviennent dans un programme, à vous servir de tout ce que vous aurez appris ici pour l'appliquer dans toutes les vidéos futures évidemment dans vos projets à vous personnel et professionnel et cetera. 

Alors la gestion d'erreur en PHP est assez simple à comprendre, assez simple à utiliser parce que par défaut vous allez avoir tout un gestionnaire et on retrouve ça un petit peu partout. 

On a un gestionnaire d'erreur qui va se charger en fait d'intercepter tout problème qui pourrait survenir au niveau d'un code pour pouvoir éventuellement vous afficher un message d'erreur, vous affichez un avertissement, afficher une alerte. 

On a ainsi 3 formes principales : on a l'erreur, l'alerte et l'avertissement. 

Grosso modo selon le degré d'importance de l'erreur en question même si on veut employer le terme erreur de manière générale pour que ce soit plus simple. 

Donc par défaut grosso modo on va avoir certaines erreurs qui vont notamment avec la configuration de PHP, on va avoir certaines erreurs qui vont être signalé et d'autres qui ne le seront pas forcément.

Alors on va faire un test très rapide en faisant par exemple un simple echo d'une variable qui n'existe pas.
```php
<?php
echo $number;
```
$number n'existe pas donc logiquement, on devrait donc s'attendre avec beaucoup de logique d'avoir une erreur signalée ici pour nous signaler que cette variable n'existe pas parce qu'on fait un echo de quelque chose que nous n'avons nulle part déclarer ou créer avant.
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	Notice: Undefined variable: number in ...
```
J'actualise ma page et vous voyez que j'obtiens aucune erreur, je ne vois rien qui s'affiche à l'écran. Chez moi c'est dû à mon gestionnaire mais peut être que chez vous c'est différent et que chez vous ça va s'afficher si vous avez fait l'installation comme je vous l'ai montré dans la formation donc logiquement vous devriez avoir la même configuration parce qu'on s'est pas forcément occupé de changer ça mais il est possible que certaines choses ne s'affichent pas. 

Donc pour commencer nous allons utiliser une fonction très pratique en PHP qui est error_reporting() qui va permettre de gérer les types d'erreurs à signaler, à reporter. 

Si on veut admettons désactiver toutes les erreurs, on utiliserait le paramètre 0 c'est-à-dire désactiver tout le gestionnaire d'erreur donc tout le signalement des erreurs. 
```php
	error_reporting(0);
```
Alors pourquoi cette importance de savoir désactiver les erreurs ? Pour 2 choses, quand vous allez travailler sur un projet dit en développement c'est-à-dire que vous êtes en train de développer votre site web, votre application web et cetera on local ou ce genre de choses ou dans différents postes de pré-production donc de développement, vous avez besoin que les erreurs s'affichent. 

L'intérêt en tant que développeur, en tant que programmeur, c'est de pouvoir vérifier toutes les erreurs possibles de votre code pour obtenir quelque chose de fonctionnel donc il est tout à fait bienvenu d'afficher un maximum d'erreurs pour le faire. 

Avec error_reporting() pour afficher le plus d'erreurs possibles on va utiliser le paramètre -1.
```php
	error_reporting(-1);
```
On pourrait également utiliser la constante E_ALL pour Error All ça peut servir aussi et vous pouvez faire ça mais si vous voulez absolument gérer tous les cas d'erreurs possibles en PHP, je vous recommande d'utiliser le paramètre -1.
```php
<?php

error_reporting(-1);

echo $number;
```
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	Notice: Undefined variable: number in ...
```
On voit que d'un coup j'ai une Notice qui s'affiche c'est-à-dire que c'est un avertissement ce n'est pas non plus une erreur très grave. 

Vous avez Notice qui est l'avertissement c'est-à-dire le stade le plus bas de l'erreur, c'est juste un signalement de quelque chose. 

On a ensuite l'alerte, la lettre c'est déjà quelque chose qui a un degré un peu plus haut. 

Et on termine enfin par l'erreur voire même l'erreur fatale dans certains cas comme par exemple quand on veut tenter quelque chose et que ça entraîne une erreur assez importante au niveau de la programmation. 

Donc ici nous avons un simple avertissement pour nous dire Undefined variable c'est-à-dire que là variable non définie, et on nous met en plus le fichier et la ligne du fichier où l'erreur a été relevé. 

Il suffirait alors de créer la variable `$number=4`.
```php
<?php

error_reporting(-1);
$number = 4;
echo $number;
```
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	4
```
À partir de ce moment-là l'erreur n'existe plus parce que nous avons effectivement créé notre variable avant de l'afficher. 

Ça c'est la base n'hésitez pas à le faire dans les prochaines vidéos encore une fois ou dans vos projets et que vous travaillez en développement de passer error_reporting() dans votre projet et je vous rappelle que vous n'avez besoin que le mettre qu'une seule fois. 

L'idéal est d'avoir un fichier de configuration où vous allez mettre error_reporting(-1) et ensuite comme ça ça va se répercuter sur l'ensemble du projet. 

Vous le mettez à -1 comme ça vous êtes sûr que toutes les réserves vont être récupérées. 

L'avantage c'est que à partir du moment vous allez obtenir une application sans erreur, vous aurez beaucoup moins de chance de rencontrer des erreurs ou d'avoir des problèmes par la suite. 

En revanche et c'est là que c'est très très très important, à partir du moment où vous allez basculer votre projet en production donc ça on emploie souvent les 2 termes, on parle de projets en développement ou en production c'est-à-dire que vous allez par exemple mettre votre site en ligne, accessible au public et à l'utilisateur, vous ne devez simplement pas afficher les erreurs. 

Vous ne devez pas afficher les erreurs pour la simple et bonne raison que si par exemple vous avez un pirate désire tenter accéder à une portion de votre site ou à vérifier la structure de votre application, de votre programme. Si vous affichez des erreurs, vous allez tout simplement lui donner des informations qui pourrait lui servir. 

Par exemple pour une connexion à une base de données, on ne va pas afficher un message d'erreur pour dire que la connexion à la base de données qui porte t-elle nom a échoué parce que du coup ça vous indique quelque part que ce nom de base de données existe donc la personne sait déjà que cette base de données est bonne il n'aura plus qu à trouver les informations d'authentification donc il faut vraiment gérer à ce niveau là. 

En développement afficher un maximum d'erreur, ça vous pouvez le faire sans problème parce que l'intérêt du développement c'est de pouvoir tout afficher pour pouvoir corriger un maximum d'erreurs et avoir un programme fonctionnel. 

En revanche dès que vous passez en production et que le site est rendu accessible à l'utilisateur, vous masquez toutes les erreurs et dans ce genre de cas le error_reporting() quand on passe en production, il conviendra de le passer à 0.
```php
	error_reporting(0);
```
Dans ce cas-là n'importe quelle erreur ne sera pas affichée que ce soit des erreurs des avertissements ou des alertes, plus rien ne sera affiché et ça permettra tout simplement de ne rien indiquer a un potentiel pirate. 

Si on a un problème qui survient sur un site en production, on obtiendra tout simplement une page blanche parce que ça ne continuera pas l'exécution du script mais l'erreur sera masquée automatiquement. 

Pour plus de choses alors là c'est ce qui va se passer au niveau PHP, on peut également modifier le fichier php.ini d'accord c'est un fichier de configuration de PHP qui permet de gérer aussi l'affichage ou non des erreurs. On l'avait même vu d'ailleurs sur la configuration, il y avait une ligne qui s'appelait display_errors() et je pense même qu'on l'avait configuré dans les vidéos précédentes pour la mettre à 1 et je vous avais dit qu'en production on devrait la passer à 0. 

Alors plutôt que d'aller modifier directement le php.ini surtout que dans certains cas où vous allez utiliser un hébergeur de site web, vous n'avez pas forcément accès à tous les fichiers de configuration, vous pouvez faire cette modification directement depuis votre script PHP. 

Il suffit juste d'utiliser la fonction ini_set(), de passer l'argument sur lequel vous voulez travailler donc nous c'est le display_errors avec un S et en 2e paramètre la valeur. Si vous mettez 0, vous ne afficher pas les erreurs et si vous mettez 1 vous les affiche.
```php
	ini_set("display_errors", 1);
```
Voilà donc moi en général je mets ces 2 lignes là.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);
```
Je mets ces 2 lignes là quand je travaille en développement comme ça je suis sûr d'afficher un maximum de choses, et à partir du moment où je passe en production, on met 0 partout et comme ça on affichera plus rien.
```php
	error_reporting(0);
	ini_set("display_errors", 0);
```
Ça c'est vraiment la règle les 2 lignes ici que vous pouvez mettre dans vos projets pour pouvoir gérer ça en tout cas pour tout ce qui concerne à l'affichage. 

Comme ici on est en développement on va tout laisser à 1 (et -1) pour vraiment afficher toutes les erreurs. 

Voilà Comment ça va se passer alors on peut avoir pas mal d'erreurs. On peut par exemple avoir un erreur sur un tableau avec un exheded, on essaie d'accéder à un élément qui n'existe pas. 

Ça peut être par exemple.
```php
<?php

error_reporting(-1);
ini_set("display_errors", 1);

$tab = [1, 2];

echo $tab[10];
```
On n'a que 2 éléments donc si on essaie de faire $tab[10], évidemment on n'est plus du tout dans le tableau.
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	Notice: Undefined offset: 10 in ...
```
Voilà donc on obtient également un avertissement qui nous dit tout simplement que Offset donc l'index 10 n'est pas défini. 

On peut avoir évidemment des erreurs beaucoup plus haute voir une alerte, voire une erreur ou bien même encore une erreur fatale en fonction du type d'erreur qui a été rencontré sur votre code. 

Ça c'était la première partie, j'ai pas mal insisté dessus et j'ai pris du temps parce que c'était important. 

Là on parle de sécurité, on va commencer vraiment à intégrer ça parce qu'on ne peut pas développer … apprendre un langage de programmation d'une part et faire de la sécurité d'un autre côté voilà il faut que ça fonctionne ensemble.

Vous ne pouvez pas développer sur un langage de programmation sans penser sécurité, c'est absolument impensable de faire l'un sans l'autre c'est-à-dire que les 2 doivent être fait ensemble donc à partir de maintenant que vous avez appris beaucoup de choses en PHP et que vous avez un certain niveau, on va vraiment vraiment ancrer ça au niveau des vidéos et ça va vraiment être très important. 

Alors on ne le fera pas forcément pour les vidéos suivantes à chaque fois, ce n'est pas sûr que pour les prochaines vidéos je mets toujours ces 2 lignes là en début de fichier mais vous n'hésitez pas à les mettre. 

Comme ça à la moindre erreur, du fait que vous êtes en plus en train d'apprendre, elle sera signalée directement donc n'hésitez pas à travailler comme ça. 

Voilà pour cette partie.

Ça c'est pour la gestion de certaines erreurs donc on a plusieurs types d'erreur comme je vous l'ai dit et ce qui va être intéressant c'est de pouvoir gérer nos propres erreurs à nous c'est-à-dire de créer notre propre gestionnaire. 

Et ça tombe bien, on va utiliser une fonction de rappel. Vous savez la fameuse fonction de callback et comme j'avais vu beaucoup de questions par rapport à ça où les gens se demandaient ce à quoi ça pouvait servir Eh bien du coup c'était l'occasion pour cette séance de voir l'utilisation d'une callback qui va servir dans ce genre de cas. 

Alors par défaut vous voyez qu'on utilise le gestionnaire PHP qui est tout écrit en anglais comme ici.
```txt
	Notice: Undefined offset: 10 in ...
```
Et fonctionne selon un principe et vous pouvez créer votre propre gestionnaire ça ne pose pas de problème si vous voulez vous en servir. Un gestionnaire pour les erreurs dit de l'utilisateur, ça peut servir. 

Pour cela nous allons utiliser une autre fonction qui va s'appeler set_error_handler()
```php
	error_reporting(-1);
	ini_set("display_errors", 1);

	set_error_handler();
```
Comme ceci et elle va prendre en paramètre une fonction de rappel donc c'est à dire une callback tout simplement. 

Une fonction de rappel ça peut être par exemple une fonction anonyme qui va faire juste un certain nombre de choses donc ça peut être une fonction très courte, comme ça peut être une fonction avec pas mal de petits éléments donc nous on va travailler là-dessus.

On va écrire au paramètre en snake_case et pas en camelCase, `$my_error_handler` en dur.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);

	set_error_handler($my_error_handler);
```
D'accord on met mon gestionnaire d'erreurs en dur comme ceci et `$my_error_handler` sera pour le coup une fonction. 

Vous pouvez procéder différemment et juste faire ça, je vous montre.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);

	set_error_handler("my_error_handler");
```
Et créer votre fonction de cette manière.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);
	
	function my_error_handler()
	{
		
	}

	set_error_handler("my_error_handler");
```
Alors ça c'est la première possibilité, vous pouvez faire votre fonction et on va faire tout un tas de choses qu'on va parler un petit peu après et donc vous la enseigner comme ça. 

Ou alors vous créez une fonction dite de rappel donc ça c'est vous qui voyez comme ceci et rappelez vous qu'on n'a pas besoin de nous comme ça et on met bien des points virgules à la fin et finalement vous passer ça en tant que variable.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);
	
	$my_error_handler = function()
	{
		
	}

	set_error_handler($my_error_handler);
```
Et là vous êtes en train de faire une callback, c'est une fonction de rappel tout simplement.

Là c'est vraiment une question de préférence, vous n'êtes pas obligé de procéder comme ça, c'est vous qui voyez. Envoyer absolument de la manière qu'il vous plaît, qui vous plaira par rapport à ça.

Du coup on va laisser comme ça et on va travailler avec notre callback tout de suite on va passer un certain nombre d'informations. Alors cette fonction de gestion d'erreur, vous ne pouvez pas mettre n'importe quoi dedans c'est-à-dire que vous allez devoir utiliser certains paramètres qui ne sont pas obligatoires mais il convient d'utiliser certaines choses. 

Par défaut le gestionnaire d'erreurs PHP a certaines informations intéressantes, il peut avoir par exemple petite erreur qui est survenu, il peut également avoir un message, il peut vous indiquer un fichier et il peut même indiquer la ligne de ce fichier où l'erreur a été rencontrée.
```txt
	Notice: Undefined offset: 10 in <path> on line <n°>
```
Ce serait dommage de faire notre propre gestionnaire d'erreurs sans récupérer ces choses là qui pourrait éventuellement nous servir grosso modo si on veut appliquer un schéma d'exemple. 

Vous allez avoir votre gestionnaire d'erreurs, imaginer une fonction de gestion d'erreur qui va prendre un certain nombre de paramètres certains sont utiles, il y en a qui sont obligatoires et d'autres qui sont optionnelles et je vais vous les présenter quand même.
```php
	/*
		function error_handler()
	*/
```
Je vous les présente parce que je pense que ça pourra toujours vous servir par rapport à ça donc le premier paramètre ça va être le type d'erreur donc ce qu'on appelle en fait le `$errno`. Alors moi j'appelle ça `$errno` parce que c'est le terme général employé, de manière générique, mais évidemment vous savez maintenant que pour les fonctions que la variable vous pouvez l'appeler absolument comme vous voulez d'accord le nom n'a absolument aucune importance. C'est que par habitude on écrit souvent comme ça. 

Le `$errno` c'est tout simplement ce qui va vous dire si l'erreur est une erreur pour le coup, si c'est une alerte ou si c'est un avertissement D'accord donc ça on le verra par la suite.
```php
	/*
		function error_handler($errno,)
	*/
```
On va avoir ensuite le error message que l'on peut appeler par exemple $errmsg ou $errorstr vous appelez ça comme vous voulez qui sera le message d'erreur que nous allons pouvoir gérer à ce niveau-là.
```php
	/*
		function error_handler($errno, $errmsg, )
	*/
```
Ça c'est les 2 paramètres obligatoires.

Ensuite vous pouvez éventuellement, je les mets comme s'ils étaient obligatoires mais vous pouvez avoir le $errfile d'accord donc c'est le fichier où il y a eu une erreur. 
```php
	/*
		function error_handler($errno, $errmsg, $errfile, )
	*/
```
Ensuite le $errline qui est la ligne où il y a eu l'erreur.
```php
	/*
		function error_handler($errno, $errmsg, $errfile, $errline)
	*/
```
Éventuellement vous pouvez préciser $errordata qui sont un petit peu les variables liées au contexte c'est-à-dire au moment où il y a eu une erreur, il y avait un ensemble de fonctions et qui a priori ont fait l'usage de variables donc cela vous permettra d'avoir un tableau qui contient un petit peu les variables utilisées lors du contexte.
```php
	/*
		function error_handler($errno, $errmsg, $errfile, $errline, $errdatas)
	*/
```
Comme on est en PHP 7 autant afficher les types.
```php
	/*
		function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
	*/
```
Voilà Comment ça va se passer grosso modo pour que vous voyez un peu comment les données sont gérées donc ceci c'était le schéma à respecter et vous pouvez vous arrêter là au minimum.
```php
	/*
		function error_handler(int $errno, string $errmsg)
	*/
```
Vous pouvez donc faire une fonction qui contient juste ça c'est-à-dire avoir au minimum un type d'erreur et un message, c'est le minimum à avoir pour un gestionnaire d'erreurs mais vous pouvez aussi avoir le fichier en question `$errfile`, la ligne du fichier `$errline` et pourquoi pas le contexte $errdatas.

Donc nous ce qu'on va faire c'est qu'on va prendre les 4 premier paramètres, on ne va pas prendre le contexte parce que ce n'est pas forcément utile. 

Donc nous on n'en a pas forcément besoin là après libre à vous de l'utiliser si vous en avez besoin pour les exercices si vous voulez et donc on va prendre nos 4 premiers paramètres. 
```php
	error_reporting(-1);
	ini_set("display_errors", 1);

	/*
		function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
	*/
	
	$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
	{
		
	};

	set_error_handler($my_error_handler);
```
On prend donc les 4 premiers paramètres mais encore une fois vous prenez les noms que vous voulez par exemple si vous voulez appeler ça `$type`, `$message`, `$file` … vous mettez les noms que vous voulez, ça n'a absolument aucune importance et ça c'est vous qui voyez. 

Voilà n'oubliez pas et si vous vous rappelez la séance qu'on a vu sur les variables, la séance sur les fonctions, vous savez que les noms c'est vraiment au choix des utilisateurs parce que en terme de programmation ce sont juste des labels ce sont des choses qui seront remplacées après par des emplacements en mémoire donc voilà pour ça. 

À partir de l'homme ce qui va être intéressant dans cette fonction, c'est de traiter le cas d'erreur $errno donc le mieux parce que vous l'avez appris qu'on peut avoir plusieurs cas différents, c'est de faire en switch qui me paraît être un bon choix par rapport à ça sur le type d'erreur ici rencontré, $errno.

De quoi faire switch() de $errno et on va ensuite lui passer plusieurs cas par défaut. On commence par mettre le cas avec une erreur qui n'est pas forcément connue.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);

	/*
		function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
	*/
	
	$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
	{
		switch($errno)
		{
			default:
				echo "Error non reconnue...";
				break;
		}
	};

	set_error_handler($my_error_handler);
```
Après est-ce que vous quittez l'exécution du script ou autre c'est quoi donc ça c'est vous qui voyez. 

Ensuite il va y avoir des constantes prédéfinies d'accord des constantes qu'on n'invente pas mais qui sont au niveau de PHP pour les erreurs intervenues via un système l'utilisateur alors on a : `E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE` donc ça rejoint les 3 modèles que je vous avais dit tout à l'heure d'accord c'est-à-dire le simple avertissement, c'est le plus bas, l'alerte et l'erreur. Ça vous pouvez le gérer comme ça tout simplement et vous faites un case pour chacun.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);

	/*
		function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
		E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
	*/
	
	$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
	{
		switch($errno)
		{
			case E_USER_ERROR:
				echo $errmsg;
				break;
			
			default:
				echo "Error non reconnue...";
				break;
		}
	};

	set_error_handler($my_error_handler);
```
Voilà ici je ne vais afficher que le message :
```php
			case E_USER_ERROR:
				echo $errmsg;
				break;
```
alors ça serait un peu bizarre fait comme ça mais le minimum ce serait ça c'est-à-dire d'afficher un message d'erreur.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);

	/*
		function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
		E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
	*/
	
	$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
	{
		switch($errno)
		{
			case E_USER_ERROR:
				echo $errmsg;
				break;
				
			case E_USER_WARNING:
				echo $errmsg;
				break;
				
			case E_USER_NOTICE:
				echo $errmsg;
				break;
				
			default:
				echo "Error non reconnue...";
				break;
		}
	};

	set_error_handler($my_error_handler);
```
On peut par exemple dire aussi comme ça c'est-à-dire de concaténer suivant l'utilisation des fonctions donc vous voyez ici les paramètres de fonction, vous allez pouvoir du coup les utiliser là où vous voulez donc vous allez pouvoir créer votre propre gestionnaire d'erreur, afficher les messages de la manière que vous voulez. Vous pouvez formater des messages sur un style particulier, les écrire en français ou autre. Vous allez pouvoir gérer ça à votre manière et là c'est vous qui voyez voilà.
```php
<?php

error_reporting(-1);
ini_set("display_errors", 1);

/*
	function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
	E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
*/

$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
{
	switch($errno)
	{
		case E_USER_ERROR:
			echo $errmsg;
			break;
			
		case E_USER_WARNING:
			echo $errmsg;
			break;
			
		case E_USER_NOTICE:
			echo $errmsg;
			break;
			
		default:
			echo "Error non reconnue...";
			break;
	}
};

set_error_handler($my_error_handler);
```
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
```
On actualisé il n'y a pas de problème. 

Le set_error_handler() est bien défini et du coup on peut tester même si ce serait un peu bizarre dans ce cas-ci, echo $number.

```php
<?php

error_reporting(-1);
ini_set("display_errors", 1);

/*
	function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
	E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
*/

$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
{
	switch($errno)
	{
		case E_USER_ERROR:
			echo $errmsg;
			break;
			
		case E_USER_WARNING:
			echo $errmsg;
			break;
			
		case E_USER_NOTICE:
			echo $errmsg;
			break;
			
		default:
			echo "Error non reconnue...";
			break;
	}
};

set_error_handler($my_error_handler);

echo $number;
```
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	Error non reconnue...
```
Voilà ce que nous obtenons.

Alors donc là on a une erreur non reconnue parce que pour lui ça ne rentre pas dans le cas d'une notice, d'un warning ou d'une simple error du coup apparemment il ne le prend pas en compte. 

On va le noter comme ça pour qu'il puisse m'afficher l'erreur en particulier `$errno`.
```php
<?php

error_reporting(-1);
ini_set("display_errors", 1);

/*
	function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
	E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
*/

$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
{
	echo '<p>'.$errno.'</p>';
	switch($errno)
	{
		case E_USER_ERROR:
			echo $errmsg;
			break;
			
		case E_USER_WARNING:
			echo $errmsg;
			break;
			
		case E_USER_NOTICE:
			echo $errmsg;
			break;
			
		default:
			echo "Error non reconnue...";
			break;
	}
};

set_error_handler($my_error_handler);

echo $number;
```
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	8

	Error non reconnue...
```
Voilà il m'affiche l'erreur code 8, ça n'a rien de particulier par rapport à ça parce que c'est un cas c'est précis et ça ne rentre pas dans notre cas. 

Alors ici plutôt que de mettre "erreur non reconnue …", vous pouvez faire simplement ceci.
```php
<?php

error_reporting(-1);
ini_set("display_errors", 1);

/*
	function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
	E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
*/

$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
{
	echo '<p>'.$errno.'</p>';
	switch($errno)
	{
		case E_USER_ERROR:
			echo $errmsg;
			break;
			
		case E_USER_WARNING:
			echo $errmsg;
			break;
			
		case E_USER_NOTICE:
			echo $errmsg;
			break;
			
		default:
			echo 'ERROR : '.$errmsg;
			break;
	}
};

set_error_handler($my_error_handler);

echo $number;
```
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	8

	ERROR : Undefined variable: number
```
Voilà comme ça ça met votre message à vous et bien sûr il n'y a que ce message là parce que lui il est géré par PHP mais ça vous permet de gérer comme ça votre propre message ou bien les choses en fonction. 

Là je ne vais pas provoquer des erreurs plus compliqué parce qu'on ne va pas agrandir le code mais je pense que vous avez compris le principe. 

Ci-après ça relève une erreur de type avertissement, il y a un cas pour le gérer qu'on a vu dans le switch. Si c'est une alerte il se passe quelque chose et si c'est une erreur normal il va se passer autre chose donc vous pouvez comme ça j'ai fait le type de chose que vous voulez faire.

Certains vont se demander à quoi ça peut servir ? Eh bien ça va pouvoir servir à générer des erreurs un peu plus proprement, par exemple dans certains cas vous aurez un message comme quoi vous n'avez pas la possibilité de lever un type d'erreurs dont on aura l'occasion de parler qui sont les exceptions.

Quand on fera l'objet on parlera des exceptions, on en parlera par la suite. 

Évidemment ce genre d'erreurs-là ne sont pas des exceptions.

Par exemple ouvrir un fichier après je fais comme on le verra dans la séance prochaine ne va pas lever d'exceptions si le fichier ne peut pas être ouvert donc c'est plutôt pas mal des fois de gérer les erreurs nous-mêmes. 

Souhaitez-vous utiliser le gestionnaire par défaut qui fonctionne très bien et qui va afficher les choses par défaut ou alors soit vous voulez gérer vous-même et dans ce cas-là ça peut être intéressant d'utiliser votre propre gestionnaire si vous voulez par exemple pouvoir changer un petit peu le formatage, l'affichage où ce que vous voulez à indiquer à l'utilisateur. 

Voilà à quoi que ça peut servir tout simplement. 

C'est recommandé quand on commence à faire des gros projets, utiliser son propre gestionnaire pour pouvoir spécialiser un petit peu plus, personnaliser la gestion des erreurs de votre application, de votre programme, de votre site web. 

Ça peut être intéressant à ce niveau-là.

Voilà au niveau de l'utilisation de ce gestionnaire donc voyez un petit peu maintenant le fonctionnement d'une fonction de callback, c'est tout simple à ce niveau-là c'est-à-dire que ce code là ce que vous voyez ici.
```php
	function(int $errno, string $errmsg, string $errfile, int $errline)
	{
		echo '<p>'.$errno.'</p>';
		switch($errno)
		{
			case E_USER_ERROR:
				echo $errmsg;
				break;
				
			case E_USER_WARNING:
				echo $errmsg;
				break;
				
			case E_USER_NOTICE:
				echo $errmsg;
				break;
				
			default:
				echo 'ERROR : '.$errmsg;
				break;
		}
	};
```
Tout ce code là j'aurais pu le mettre même si ce n'est pas propre du tout, j'aurais pu le mettre comme ça dans set_error_handler(...) même si ce n'est pas propre du tout.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);

	/*
		function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
		E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
	*/

	set_error_handler($my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
	{
		echo '<p>'.$errno.'</p>';
		switch($errno)
		{
			case E_USER_ERROR:
				echo $errmsg;
				break;
				
			case E_USER_WARNING:
				echo $errmsg;
				break;
				
			case E_USER_NOTICE:
				echo $errmsg;
				break;
				
			default:
				echo 'ERROR : '.$errmsg;
				break;
		}
	};);

	echo $number;
```
Même si ce n'est pas propre du tout, j'aurais pu mettre ma fonction anonyme directement à l'intérieur de set_error_handler() c'est-à-dire que c'est une fonction anonyme et qu'elle n'a pas de nom mais là pour des questions de lisibilité à mon avis quand même de faire ça parce que personnellement je ne trouve pas ça lissible. 

Je préfère aller réduire faire ça c'est-à-dire mettre notre fonction anonyme dans une variable et ensuite on applique la définir dans set_error_handler() comme étant notre nouveau gestionnaire d'erreurs donc ça peut être plutôt pas mal. 

Voilà pour cette partie là, je vous ai dit tout ce qu'il fallait au niveau de votre propre gestionnaire. 

Encore une fois retenez bien cette partie là.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);
```
D'ailleurs ici vous voyez que ça génère bien une erreur. 

Encore une fois si vous désactivez tout, une fois que votre site est en production.
```php
<?php

error_reporting(0);
ini_set("display_errors", 0);

/*
	function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
	E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
*/

$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
{
	switch($errno)
	{
		case E_USER_ERROR:
			echo $errmsg;
			break;
			
		case E_USER_WARNING:
			echo $errmsg;
			break;
			
		case E_USER_NOTICE:
			echo $errmsg;
			break;
			
		default:
			echo 'ERROR : '.$errmsg;
			break;
	}
};

set_error_handler($my_error_handler);

echo $number;
```
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	ERROR : Undefined variable: number
```
On a désactivé le gestionnaire de PHP et en revanche comme on précisé notre propre gestionnaire d'erreurs, voyez que même en décidant de ne rien afficher comme on a défini ici (tout à 0), on passe par notre propre gestionnaire donc ça c'est quelque chose qui est tout à fait faisable. 

Maintenant si on veut pouvoir gérer une erreur précise genre par exemple que moi je veux que ça crée une alerte, que ça crée un avertissement, que ça crée une erreur parce que là sinon vous voyez que par défaut, il va à priori toujours passer dans le cas `default:` c'est-à-dire dans pratiquement tous les cas. 

Du coup il est bien de nous même provoquer une erreur, de dire par exemple que ça provoque une erreur quand il se passe tel chose. 

Comment peux-tu me faire ça, admettons nous avons `$number=16` et je fais une condition pour savoir si $number est plus petit que 18 c'est-à-dire que vous êtes d'accord avec moi qu'en PHP on ne peut pas par exemple dire : Eh bien un langage de programmation va devoir générer une erreur c'est une variable qui est par exemple concerne la jeune personne n'est pas au minimum égal ou supérieur à 18 c'est-à-dire que la personne en France parce que c'est pas facilement le cadre de tous les pays, mais pas majeur comprenez bien qu'en termes d'informatique ce n'est pas une erreur quand une variable est égale à 16, évidemment que non.
```php
	$age_personne = 16;
	
	if($age_personne < 18)
		...
```
Mais nous peut-être que dans notre application aura besoin de dire, Eh bien quand il se passe ça et que la personne n'est pas majeur, je veux effectivement, volontairement signaler une erreur et dans ce cas-là vous allez pouvoir la provoquer via une fonction qui va s'appeler trigger_error().
```php
	$age_personne = 16;
	
	if($age_personne < 18)
		trigger_error()
```
Et là voilà comment elle va fonctionner … tout à l'heure nous étions passés par le système qui a provoqué en fait une erreur directement depuis PHP, c'est PHP qui a provoqué une erreur et qui s'est servi de notre gestionnaire. C'est pour ça qu'on est tombé dans le default mais nous maintenant si on veut utiliser notre gestionnaire avec nos propres messages d'erreur, on utilise cette fonction là trigger_error(). Vous lui passez le message et vous lui passez ensuite le code que vous voulez donc c'est à nous de choisir comment on le détermine.
```php
	$age_personne = 16;
	
	if($age_personne < 18)
		trigger_error("Tu n'es pas majeur !", ...);
```
Donc c'est à nous de choisir comment on va le déterminer, est-ce que vous voulez considérer que le fait qu'il ne soit pas majeur soit un simple avertissement ? c'est une alerte ou c'est une erreur ?

Admettons nous on va dire que ça va déclencher une alerte E_USER_WARNING donc c'est vous qui choisissez. C'est à vous de travailler et ce n'est pas PHP qui va le faire à votre place, c'est à vous de décider.
```php
	$age_personne = 16;
	
	if($age_personne < 18)
		trigger_error("Tu n'es pas majeur !", E_USER_WARNING);
```
Alors il y a un alias pour cette fonction là trigger_error(), vous pouvez également utiliser user_error() qui est la même chose. C'est la même fonction sauf qu'elles ont des noms différents donc vous pouvez utiliser user_error() ou trigger_error() si vous voulez. 

L'une ou l'autre c'est exactement la même fonction, c'est ce qu'on appelle un alias d'accord c'est une autre manière de l'écrire.
```php
<?php

error_reporting(0);
ini_set("display_errors", 0);

/*
	function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
	E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
*/

$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
{
	switch($errno)
	{
		case E_USER_ERROR:
			echo $errmsg;
			break;
			
		case E_USER_WARNING:
			echo $errmsg. ' sur le fichier '.$errfile;
			break;
			
		case E_USER_NOTICE:
			echo $errmsg;
			break;
			
		default:
			echo 'ERROR : '.$errmsg;
			break;
	}
};

set_error_handler($my_error_handler);

$age_personne = 16;

if($age_personne < 18)
	trigger_error("Tu n'es pas majeur !", E_USER_WARNING);//alias : user_error()
```
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	Tu n'es pas majeur ! sur le fichier C:\...
```
Et là voilà le message que nous avons. 

Regardez on tombe effectivement bien dans le E_USER_WARNING donc error sur le fichier, et il nous met bien le fichier sur lequel on est. 

Si par exemple on veut la ligne, on utilisera cette variable $errline et cetera. 

Voyez comment du coup on peut se servir de notre gestionnaire grâce à ça. 

Là est tout l'intérêt de vous avoir montré ça dans cette vidéo, c'est évidemment de pouvoir provoquer vos propres erreurs. 

Si vous faites votre propre gestionnaire mais que vous laissez PHP gérer le signalement d'erreur, ce n'est pas très utile. 

L'intérêt ici c'est ce que je voulais vous montrer sur cette fin de vidéo, Eh bien c'est de pouvoir créer ensuite lancer vos propres erreurs via cette fonction trigger_error() ou son alias user_error() pour choisir du coup là où elle va tomber. 

Et automatiquement elle va arriver dans le cas que vous voulez parce que c'est vous qui provoqué ça. 

Et si on a une erreur qui sort d'autre chose, on tombera de toute façon dans le default puisqu'on a prévu ce cas là. 

Après vous êtes libre, vous pouvez choisir d'arrêter le programme. Si on veut choisir de l'arrêter, on peut utiliser la fonction, l'instruction `exit;` comme ceci.
```php		...
		case E_USER_WARNING:
			echo $errmsg. ' sur le fichier '.$errfile;
>			exit;
			break;
```
Alors `exit;` si vous l'écrivez comme ça, c'est comme si vous écriviez `exit();` avec des parenthèses vides.
```php
		...
		case E_USER_WARNING:
			echo $errmsg. ' sur le fichier '.$errfile;
>			exit();
			break;
```
Ou encore que vous écriviez `exit(0);`
```php
		...
		case E_USER_WARNING:
			echo $errmsg. ' sur le fichier '.$errfile;
>			exit(0);
			break;
```
Entre guillemets c'est le code utilisé pour dire qu'on quitte mais que tout s'est bien passé donc le mieux c'est de mettre un code par exemple 1, `exit(1);`
```php
		...
		case E_USER_WARNING:
			echo $errmsg. ' sur le fichier '.$errfile;
>			exit(1);
			break;
```
Vous mettez `exit(1);` voilà ou alors vous mettez `exit 1;` comme ceci c'est vous qui voyez.
```php
		...
		case E_USER_WARNING:
			echo $errmsg. ' sur le fichier '.$errfile;
>			exit 1;
			break;
```
Vous savez c'est comme pour le print ou pour le echo ou comme le return et cetera, vous pouvez mettre des parenthèses ou non. 

C'est vous qui voyez. 

Moi par habitude ça va dépendre, par exemple en général pour le return je ne mets pas de parenthèses mais pour le `exit()` j'en mets.
```php
>			exit(1);
```
Donc là par exemple vous pouvez dire je quitte le programme c'est-à-dire que je ne veux pas continuer l'exécution du programme si on a ici une alerte E_USER_WARNING qui est survenue au niveau de l'exécution du programme. 

Très important le trigger_error() comme ça qui permet de provoquer une erreur en fonction de votre code c'est-à-dire que c'est à vous, vous allez pouvoir gérer vous-même, manuellement les erreurs de votre programme, de votre site web et du coup prévoir des erreurs que PHP ne peut pas prévoir.

Parce que pour PHP, le fait qu'une variable soit inférieure à 18, ce n'est pas une erreur, ça ne pose aucun problème mais par contre si vous voulez faire une division par 0, PHP peut effectivement ne pas être content. 

Tenez par exemple nous pouvons faire ça.
```php
<?php

error_reporting(0);
ini_set("display_errors", 0);

/*
	function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
	E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
*/

$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
{
	switch($errno)
	{
		case E_USER_ERROR:
			echo $errmsg;
			break;
			
		case E_USER_WARNING:
			echo $errmsg. ' sur le fichier '.$errfile;
			break;
			
		case E_USER_NOTICE:
			echo $errmsg;
			break;
			
		default:
			echo 'ERROR : '.$errmsg;
			break;
	}
};

set_error_handler($my_error_handler);

$age_personne = 16 / 0;

echo $age_personne;
```
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	ERROR : Division by zeroINF
```
Voilà si j'essaie de faire une division par 0 donc on tombe automatiquement dans le default. 

Et si j'avais pas utiliser le gestionnaire, faisons ça.
```php
<?php

error_reporting(0);
ini_set("display_errors", 0);

/*
	function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
	E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
*/

$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
{
	switch($errno)
	{
		case E_USER_ERROR:
			echo $errmsg;
			break;
			
		case E_USER_WARNING:
			echo $errmsg. ' sur le fichier '.$errfile;
			break;
			
		case E_USER_NOTICE:
			echo $errmsg;
			break;
			
		default:
			echo 'ERROR : '.$errmsg;
			break;
	}
};

//set_error_handler($my_error_handler);

$age_personne = 16 / 0;

echo $age_personne;
```
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	INF
```
On n'a rien du tout qui s'affiche, ce qui est normal parce que je vous rappelle qu'on a choisi de ne pas afficher les erreurs.
```php
	error_reporting(0);
	ini_set("display_errors", 0);
```
Donc pour afficher les erreurs du gestionnaire de PHP, on met tout à 1 (et -1).
```php
<?php

error_reporting(-1);
ini_set("display_errors", 1);

/*
	function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
	E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
*/

$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
{
	switch($errno)
	{
		case E_USER_ERROR:
			echo $errmsg;
			break;
			
		case E_USER_WARNING:
			echo $errmsg. ' sur le fichier '.$errfile;
			break;
			
		case E_USER_NOTICE:
			echo $errmsg;
			break;
			
		default:
			echo 'ERROR : '.$errmsg;
			break;
	}
};

//set_error_handler($my_error_handler);

$age_personne = 16 / 0;

echo $age_personne;
```
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	Warning: Division by zero in C:\...\index.php on line 975
	INF
```
Et là boum, Division by zero.

Voilà avec le gestionnaire par défaut. 

Pourquoi est-ce que j'ai INF qui traîne quelque part !

Enfin bref je vous ai tout expliqué par rapport à ça. 

Vous avez comme ça la gestion de vos erreurs. 

Alors est-ce qu'on a fait le tour de tout ce que je voulais vous expliquer sur cette vidéo ?

Alors ce n'était pas très compliqué, je vous avais dit que ce n'était pas très compliqué à comprendre, c'est juste beaucoup de fonctions à connaître tel que : error_reporting(), ini_set(), vous avez votre fonction pour faire votre propre gestion de gestionnaire function() ensuite vous l'appliquer avec set_error_handler() tout simplement et c'est déjà pas mal.

Alors vous pouvez également restaurer directement le gestionnaire par défaut en utilisant restore_error_handler(). 

Par exemple une fois que vous avez fini avec votre propre gestionnaire et que vous voulez repasser à l'ancien, vous faites restore_error_handler(); comme ceci. 
```php
	error_reporting(-1);
	ini_set("display_errors", 1);

	/*
		function error_handler(int $errno, string $errmsg, string $errfile, int $errline, array $errdatas)
		E_USER_ERROR | E_USER_WARNING | E_USER_NOTICE
	*/

	$my_error_handler = function(int $errno, string $errmsg, string $errfile, int $errline)
	{
		switch($errno)
		{
			case E_USER_ERROR:
				echo $errmsg;
				break;
				
			case E_USER_WARNING:
				echo $errmsg. ' sur le fichier '.$errfile;
				break;
				
			case E_USER_NOTICE:
				echo $errmsg;
				break;
				
			default:
				echo 'ERROR : '.$errmsg;
				break;
		}
	};

	set_error_handler($my_error_handler);

	$age_personne = 16 / 0;

	echo $age_personne;
	
>	restore_error_handler();
```
Alors c'est une fonction qui retourne toujours true pas de souci. 

D'ailleurs pour info set_error_handler() retourne l'ancien gestionnaire utilisé. 

Si admettons vous voulez le récupérer pour pouvoir le sauvegarder, pour éventuellement le réutiliser c'est par exemple vous avez plusieurs gestionnaires parce qu'on peut avoir plusieurs gestionnaires d'erreurs par branche de votre application web … Eh bien vous pouvez faire ça c'est-à-dire que vous le stocker dans une variable et vous le récupérer comme ça.
```php
	$old_handler = set_error_handler($my_error_handler);
```
Puis après plus tard vous pouvez très bien faire, par exemple vous rappelez la fonction set_error_handler() et puis vous remettez en place l'ancien gestionnaire. 
```php
	$old_handler = set_error_handler($my_error_handler);
	
>	set_error_handler($old_handler);
```
Voyez que vous pouvez commencer à restaurer les choses donc n'hésitez pas à également vous en servir. 

N'oubliez pas que les fonctions set_error_handler() ont toutes des retours en général donc vérifiez toujours. 

Si vous n'êtes pas sûr vous pouvez aller sur la doc de PHP et vous regardez ce que retourne les fonctions et à quoi ça peut vous servir parce que dans certains cas ça peut être pas mal de sauvegarder ou de récupérer dans des variables, les retours de certaines fonctions pour travailler avec plus tard. 

Voilà si vous n'en avez pas besoin, vous n'avez pas besoin de récupérer son retour et vous appelez juste directement. C'est à vous de voir par rapport à ça. 

Voilà je pense que j'ai fait un peu le tour de tout ce que je voulais vous dire donc on a parlé de la gestion d'affichage. 

Alors je vais récapituler pour cette vidéo. 

En développement vous activez un maximum les erreurs, donc vous mettez ça comme ça.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);
```
En production une fois que votre application, votre site disponible à l'utilisateur, vous mettez tout ça à 0 comme ça s'il y a une erreur qui survient, la personne verra une page blanche. 

Et vous aussi vous avez une page blanche qui est arrivée en production, et bien en local, en développement, il suffira de voir et de faire la même manipulation et vous aurez vous l'erreur de votre côté qui s'affichera et vous saurez quel erreur est survenue tout simplement sur le site en ligne. 

Voilà je vous expliqué comment mettre votre propre gestionnaire en place, je vous expliqué les différents types d'erreur utilisateur mais aussi comment appeler une erreur donc avec le trigger_error() ou user_error() son alias, appeler vous. 

Et c'est déjà pas mal. 

Alors oui trigger_error(), je ne l'ai pas dit mais si elle a bien fonctionné elle retourne true et si elle a mal fonctionné elle renvoie false. 

Dans l'idéal quand vous faites un trigger_error(), vérifier qu'elle ne retourne pas false pour être sûr qu'elle a bien pu effectivement déclencher une erreur. Parce que peut être vous allez mettre par exemple, un mauvais nom dans le switch pour un des cas ou bien vous n'allez pas mettre un bon message donc à partir du moment où vous faites votre trigger_error() ici vérifier son retour. 

Vérifier le retour de trigger_error() pour être sûr qu'elle est bien égal à true et non pas à false sinon c'est qu'elle n'aura pas fonctionné donc très important. 

Je ne reviendrais pas tout le temps dessus parce que sinon ça va encore alourdir une fois de plus la vidéo mais à partir de maintenant, à chaque fois que vous utilisez les fonctions qu'elle qu'elle soit, vous vérifiez toujours le retour des fonctions !

Toujours surtout si elles peuvent renvoyer un code d'erreur ou un false ou un null quand elles n'ont pas bien fonctionné et quand il y a eu une erreur. 

C'est important de vérifier d'être sûr que chaque fonction que vous utilisez, elle a fait ce qu'elle devait faire sinon c'est qu'il y a eu un problème est-ce que vous devez gérer ce problème. 

Vous ne pouvez pas laisser le programme se continuer, se poursuivre d'une manière normale s'il y a une erreur qui est survenue au cours de l'exécution. 

Ça je ne le dirais pas tout le temps à chaque fois mais c'est à vous de prendre cette habitude là dès le départ. 

Si vous prenez l'habitude maintenant, vous ferez du très bon code par la suite et vous aurez ces bonnes habitudes tout le temps tout le temps dans tous vos projets et du coup vous ne serez plus embêté. 

Vous n'aurez plus besoin de vous poser la question parce que vous aurez pris l'habitude de toujours contrôler vos fonctions donc ça ne posera aucun problème. 

Alors petit bonus de cette vidéo avant de vous quitter parce que je viens de dire penser tout de suite, c'est au sujet des logs. 

Parce que ça pourrait servir plus tard à gérer un système de log. 

Alors qu'est-ce qu'un système de log ? Eh bien par exemple quand vous avez un site internet ou un jeu en ligne ou n'importe quoi, il est tout à fait recommandé d'avoir un système de log c'est-à-dire qu'on va enregistrer l'activité de tout ce qui s'est passé sur notre site web dans des fichiers. 

Par exemple si quelqu'un à accédé à l'administration, et bien on va l'enregistrer en log comme ça c'est un jour on voit qu'il y a une adresse IP qui n'est pas normal, on pourra se dire que tiens là ce n'est pas l'administrateur qui est arrivé en administration mais peut être un pirate qui a eu les accès alors qu'il n'aurait pas dû les avoir donc ça permet de surveiller, d'avoir un espèce de sentinelle pour surveiller un peu l'activité sur votre site ou sur votre application. 

Ou ça peut être tout simplement dans le cas où il y aurait une très grave erreur sur un programme, et bien vous signaler une erreur genre par exemple en enregistrant dans un fichier ou par exemple en envoyant un mail. 

Vous pouvez envoyer une erreur par e-mail comme ça à l'administrateur donc attention, je pense que c'est logique et que vous l'avez compris, ne vous amusez pas à chaque fois qu'il y a une erreur en PHP à vous envoyer un e-mail sinon vous allez évidemment pourrir votre boîte mail et puis voilà vous aller saturer le truc. 

Imaginer un système en ligne avec une personne qui pourrit volontairement, provoquer des erreurs pour saturer votre boîte mail donc attention. 

Attention le but des log, ce n'est pas de tout envoyer par e-mail. 

Il faut évidemment contrôler ça au maximum mais vous pouvez le faire. 

On va regarder comment ça fonctionne … on enlève tout et je vous montre. 

Il s'agit de la fonction error_log().
```php
	error_reporting(-1);
	ini_set("display_errors", 1);
	
	error_log();
```
Vous appelez quand vous voulez lorsque par exemple dans le gestionnaire nous avions fait le switch tout à l'heure, si à un moment vous voulez signaler par exemple une erreur en particulier dans un log, Eh bien vous appelez la fonction au moment où vous voulez vous en servir. 

Cette fonction prend quelques paramètres de manière très simple, le premier ça va être le message d'accord.

Par exemple "Y'a eu un problème !", et en 2e elle va prendre le type d'erreur ce que l'on veut signaler ou en tout cas le type d'erreur que l'on veut faire pour les log. Si vous mettez un 0, vous allez tout simplement sauvegarder donc indiquer l'erreur dans l'historique de PHP d'accord.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);
	
	error_log("Y'a eu un problème !", 0);
```
Donc ça c'est en général ce qui se fait par défaut. Par défaut c'est ce qui se passe ici et si vous mettez le 1 vous allez pouvoir envoyer un mail.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);
	
	error_log("Y'a eu un problème !", 1, ...);
```
Vous allez pouvoir envoyer un mail à un autre paramètre c'est à dire qu'il va falloir préciser en 3e paramètre l'email donc par exemple.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);
	
	error_log("Y'a eu un problème !", 1, "admin@tiflou.fr");
```
Voilà nous allons envoyer ce message là par e-mail à cette personne mais éventuellement en dernier paramètres vous pouvez spécifier encore les en-têtes. Vous savez que si vous savez envoyer des e-mails qu'on peut avoir des en-têtes pour spécifier l'expéditeur, l'encodage ce genre de chose donc tout ce qui est en tête supplémentaire pourront s'envoyer en 4e paramètre ici.
```php
	error_reporting(-1);
	ini_set("display_errors", 1);
	
	error_log("Y'a eu un problème !", 1, "admin@tiflou.fr", ...);
```
Voilà les en-têtes ne sont pas obligatoires mais ça peut être fait donc ça c'est pour l'envoi de mail. 

Ensuite vous pouvez avoir un fichier, et pour ça vous faites 3 et vous mettez le nom du fichier par exemple "errors.log".
```php
<?php

error_reporting(-1);
ini_set("display_errors", 1);

error_log("Y'a eu un problème !", 3, "errors.log");
```
Et comme ça vous allez pouvoir l'exécuter et il vous enregistrera un fichier ici donc ça peut être pas mal. 

Après on a le 4 mais ça c'est pour les gestionnaires de l'identification ACPI mais ce n'est pas utile et ce sont des choses un peu plus complexes donc je vous épargnerai ça et ça nous intéresse pas à ce stade donc on va garder ces 3 là. 

Le 0 pour l'historique de PHP par défaut. 

Le type 1 quand vous voulez vous envoyer un mail ou envoyer un mail à quelqu'un. 

Et le 3, c'est tout simplement pour le fichier. 

Donc là si j'exécute mon script, on voit qu'il va me produire un fichier errors.log.
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	
	errors.log
		Y'a eu un problème !
```
Et voilà si je le lis, on voit le message Y'a eu un problème !

Si je re exécute, vous voyez qu'il va ajouter le message à chaque fois.
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	
	errors.log
		Y'a eu un problème !Y'a eu un problème !Y'a eu un problème !Y'a eu un problème !
```
Vous voyez qu'ils ajoutent le message à chaque fois donc évidemment il prend en compte, il ne prend pas en compte par défaut les retours à la ligne tout ça mais c'est à vous de le faire. 

Donc on peut spécifier le nombre de lignes, voilà vous pouvez mettre vraiment le message exact et log, c'est comme ça que ça fonctionne. 

Si quelqu'un consulte errors.log, il peut voir comment ça s'est passé donc vous pouvez gérer les retours à la ligne. 

Je pense qu'en mettant "\r\n" ça devrait être bon et ensuite j'actualise 4 fois.
```php
<?php

error_reporting(-1);
ini_set("display_errors", 1);

error_log("Y'a eu un problème !\r\n", 3, "errors.log");
```
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
```
Voilà on va sur errors.log et on voit que tout s'est mis à la ligne en retour à la ligne, j'actualise plein de fois et on voit que ça s'actualise.
```txt
	http://localhost/PHP/cours/013_gestion_erreurs/
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
	Y'a eu un problème !
```
Et voilà ça s'actualise donc vous pouvez comme ça j'irai vos messages d'erreur, vos log directement dans des fichiers ou par mail. 

Attention pour les mails encore une fois, parce que si par exemple vous mettez votre site web en ligne mais que dès qu'il y a telle erreur qui survient, ça m'envoie un mail .. Eh bien il suffit qu'un petit l'utilisateur malin qui veut s'amuser viens à provoquer volontairement une erreur et sature votre boîte mail voir qui pourrait même vous poser des soucis avec votre hébergeur de mails qui pourrait dire par exemple que vous faites du spam ou alors comme votre compte subi du spam, il pourrait limiter l'utilisation de votre boîte mails donc ce serait assez problématique donc attention à ça. 

Je vous préviens quand même avant mais c'est quelque chose qui est tout à fait possible. 

Cette fonction est juste très très pratique quand vous ferez des gros projets en web, vous en aurez besoin parce qu'il faudra à priori créer votre propre gestionnaire d'erreur pour que ce soit bien évidemment beaucoup plus personnalisé à l'utilisation de votre application parce que PHP prévoit des choses dite informatique. 

Il peut par exemple gérer une variable non déclarée, il peut diviser une division par 0, il peut gérer le fait qu'on soit dans un index qui n'existe pas sur un tableau donc ce genre de chose par contre il ne peut pas gérer le fait qu'une personne ne soit pas majeur par rapport à une variable. 

Il ne peut pas gérer le fait qu'une personne soit de sexe masculin ou féminin parce que vous avez besoin de quelque chose en particulier genre par exemple admettons un site e-commerce qui a besoin de sélectionnez des vêtements pour femme ou pour homme donc vous voyez un petit peu les exemples tout ça, un langage de programmation ne peut pas le gérer car ce sont des choses qui sont humaines donc il faudra forcément un gestionnaire d'erreur personnalisé. 

Et cette fonction très pratique pour mettre en place un système de log quand on fera de la programmation objet par la suite, vous pourrez vous amuser à créer votre propre système de log ou d'audit pour tester vos applications et vous assurer de leur fonctionnement optimal en application et en production. 

J'espère que cette vidéo vous a plu, que ça vous a permis encore une fois de voir énormément de choses donc vous voyez qu'on remet en application tout ce qu'on a vu précédemment : les variables, les fonctions, ça nous a permis également de revoir les fonctions de rappel parce qu'il y a eu pas mal de questions là-dessus et c'est quelque chose que les débutants ont général du mal à comprendre où assimiler donc maintenant je pense que vous avez compris un petit peu le principe des callbacks. 

Le callbacks c'est le fait simplement de rappeler, de passer une fonction dans une fonction, de faire un rappel ailleurs tout simplement donc on s'en est servi ici. 

Et puis si évidemment il y a des questions par rapport à ça, il ne faut pas hésiter d'accord et entrainez vous c'est toujours pareil. 

Faites-vous votre petit site web, vos petits scripts PHP et mettez un peu tout ça en place. 

Voilà tester votre petit système de gestion d'erreur.

Provoquer des erreurs volontairement pour voir si tout fonctionne bien, si vous pouvez enregistrer en log et voilà ça se passera bien à ce niveau-là et vous aurez comme ça un truc bien fonctionnel et vous aurez surtout bien compris ce que vous faites. 

À bientôt pour la suite de cette formation PHP. 

La prochaine vidéo ce sera la séance 14 et la séance 14 nous parlerons des fichiers