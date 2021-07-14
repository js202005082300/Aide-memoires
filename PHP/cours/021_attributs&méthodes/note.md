# [21. Attributs et méthodes](https://www.youtube.com/watch?v=YCeS-4Z_wSk)
02-12-20

Bonjour à tous et bienvenue sur cette formation en PHP. 

En attaque la séance XXI avec les attributs et les méthodes. 

J'espère que vous avez bien compris ce qu'on a vu précédemment concernant les classes et objets.

Voilà parce qu'il va y avoir pas mal de notions qui vont arriver sur les prochaines séances et qui vont devoir être assimilés pour bien suivre les prochaines. 

N'hésitez donc pas à revenir sur les vidéos si nécessaire, et a posé des questions en commentaire si jamais vous êtes bloqué quelque part.

On va regarder avec le code qu'on avait précédemment.
```php
<?php

class Vehicle
{
	public function __construct()
	{
		echo 'Je suis construit';
	}
}

$obj1 = new Vehicle();
```
```txt
	http://localhost/PHP/cours/021_attributs&m%c3%a9thodes/
	Je suis construit
```
Avec ce qu'on avait précédemment c'est-à-dire comment est-ce qu'on définit notre classe, comment on va instancier notre objet. 

Alors voilà j'ai repris la même chose tout simplement avec l'objet qui se construit ici.

Nous allons voir maintenant comment définir nos attributs et nos méthodes, et on va noter très rapidement j'en avais parlé de manière brève dans la vidéo précédente mais je vais le redire ici.

Un attribut, ou propriété, parce que PHP pour le coup ne fait pas la différence entre les 2 ce qui est le cas dans certains langages mais pas pour PHP. Un attribut est une variable appartenant à une classe voilà ça ne sert à rien de chercher compliqué. 
```php
	/*
		Attribut (ou propriété)	: variable appartenant à une classe
	*/
```
Est une méthode c'est une fonction, ou procédure éventuellement, appartenant à une classe voilà.
```php
	/*
		Attribut (ou propriété)	: variable appartenant à une classe
		Méthode					: fonction appartenant à une classe
	*/
```
Alors ça pourrait paraître complexe mais au niveau de leur définition c'est ça. 

Si vous avez compris qu'un attribut c'est une variable qu'on va définir dans une classe, et qu'une méthode c'est une fonction que nous allons écrire dans une classe. Vous avez tout compris au niveau des attributs et des méthodes en PHP, c'est aussi simple que ça. 

Pour le coup le constructeur est une méthode particulière programmation en programmation objet, en PHP. C'est pour ça qu'on lui indique un double underscore et donc il ne faut pas écrire vos méthodes de cette manière parce que c'est PHP qui se réserve cette notation pour identifier ce qu'on appelle les méthodes spéciales et le constructeur en fait partie. 

Ce sont des choses à savoir et d'ailleurs le destructeur également en fait partie comme on l'a vu la dernière fois. 

Tout ça ce sont des choses particulières. 

Jusqu à présent un objet, on créait des instances de notre classe pour faire nos objets. 

Alors ça passe par le constructeur mais le constructeur ne fait pas grand chose à part afficher 'Je suis construit'.

Nous on aimerait que notre véhicule ait des spécificités d'accord qu'il est justement des attributs qui permet de déterminer un peu ce qu'il possède. Ce que possède donc ce véhicule. 

Alors on va faire un attribut très simple pour commencer et on va utiliser le mot clé public je vais vous expliquer à quoi correspondent tous ces mots clés qu'on met à chaque fois au début. 
```php
	class Vehicle
	{
		public ...
		
		public function __construct()
		{
			echo 'Je suis construit';
		}
	}

	$obj1 = new Vehicle();
```
Là on va utiliser une variable et ce que je vous conseille pour les attributs de classe, c'est de mettre un petit underscore au début du non parce que je trouve que c'est beaucoup plus pratique il se permettra de bien différencier les choses surtout si vous avez des noms assez identiques et là je vais mettre `$_name`.
```php
	class Vehicle
	{
		public $_name;
		
		public function __construct()
		{
			echo 'Je suis construit';
		}
	}

	$obj1 = new Vehicle();
```
Alors ce qu'il faut comprendre pour être simple parce qu'on va parler de lisibilité en programmation objet par la suite et sur cette vidéo mais il faut comprendre que le mot clé public veut simplement dire que toutes les informations déclarés public dans notre classe seront accessibles depuis l'extérieur de cette classe. 

En réalité public veut même dire que c'est accessible partout. 

Imaginez que tout ce qu'il y a là c'est une sorte de boîte.
```php
	+---------------------------------------+
	|	class Vehicle						|
	|	{									|
	|		public $_name;					|
	|										|
	|		public function __construct()	|
	|		{								|
	|			echo 'Je suis construit';	|
	|		}								|
	|	}									|
	+---------------------------------------+
```
D'accord une boîte fermée pour notre classe Vehicle, Eh bien tout ce qui est en public nous permet d'ouvrir une porte vers ces éléments là c'est-à-dire que depuis l'extérieur de ma classe ici.
```php
	class Vehicle
	{
		public $_name;
		
		public function __construct()
		{
			echo 'Je suis construit';
		}
	}
>
>	$obj1 = new Vehicle();
```
Ici je suis à l'extérieur de ma classe. 

Eh bien je vais pouvoir accéder à l'atribut `$_name` pourquoi ? parce qu'il est déclaré public et je vais pouvoir bien évidemment construire mon objet __construct() donc créer une nouvelle instance parce que le constructeur et public. 

Je le dis parce que dans certains cas le constructeur pourrait être privé mais ça on verra par la suite, on utiliserait une autre méthode, une autre fonction qui elle se public par laquel nous passerions mais c'est des choses qu'on aura peut-être l'occasion d'aborder que ce soit sur cette formation PHP ou d'autres formations plus liées à l'algorithme.

Voilà pour ça. 

On va donc utiliser que ce terme là pour le moment, public. 

Et on verra qu'il n'y a pas que le public, il y a évidemment d'autres cas particulier. 

Pour le moment on considère que tout est public, que tout est accessible partout ce qui est évidemment une très mauvaise idée dans un cas réel et à la fin de cette vidéo vous apprendrez de toute façon à faire une classe propre avec une bonne visibilité, appliqué correctement à chacun des éléments de votre classe. 

Ce que nous allons donc faire à partir de là, au niveau de notre constructeur parce que echo de 'je suis construit' on s'en fiche un petit peu, on va permettre de définir un nom à notre véhicule au moment où on va créer un objet. 

Alors ici n'hésitez pas à vous en servir surtout depuis l'arrivée de PHP 7, à définir des types de variables donc voilà moi je veux que ce soit une chaîne de caractères et je vais définir $name qui sera bien alors on fait ça comme ceci.
```php
	class Vehicle
	{
		public $_name;
		
		public function __construct(string $name)
		{
			echo 'Je suis construit';
		}
	}

	$obj1 = new Vehicle(...);
```
Alors le constructeur prendra une variable, ça fonctionne comme une fonction et comme vous avez pu le voir en programmation procédurale dernièrement au PHP. 

J'utilise bien évidemment toutes les nouveautés des dernières versions du langage PHP ici en donnant notamment un typage pour mes fonctions et je trouve que c'est bien mieux de procéder comme ça. On sait à quoi on a affaire directement au niveau du constructeur. 

Ensuite comment on attend une chaîne de caractères en dehors de ma classe, je vais le préciser au niveau du constructeur.
```php
	class Vehicle
	{
		public $_name;
		
		public function __construct(string $name)
		{
			echo 'Je suis construit';
		}
	}

	$obj1 = new Vehicle('Mon bolide');
```
Alors comme pour les fonctions, ça utilise les mêmes règles. 

Si vous voulez donner un nom par défaut quand il n'est pas précisé, vous pouvez faire comme on a vu sur la vidéo sur les fonctions en lui donnant une valeur par défaut par exemple ce genre de chose.
```php
	class Vehicle
	{
		public $_name;
		
		public function __construct(string $name = 'Undefined')
		{
			echo 'Je suis construit';
		}
	}

	$obj1 = new Vehicle('Mon bolide');
```
Ce que vous voulez d'accord il n'y a pas de problème. 

Tout ce que vous avez pu voir sur les fonctions est applicable sur les méthodes parce que les méthodes sont simplement des fonctions de classe. 

Même si la méthode du constructeur est un petit peu particulière mais elle suit un peu les mêmes règles aussi. 

Et là nous allons stocker dans notre classe, avec la fameuse pseudo variable `$this`, vous faites le symbole de flèche `->` et l'attribut en question donc l'attribut il ne faut pas répéter le dollar puisque le dollar est déjà là, sur le `$this`.

Vous prenez tout le nom de l'attribut sauf le dollar `$` comme ceci. Et vous lui affecté la variable `$name` tout simplement.
```php
	class Vehicle
	{
		public $_name;
		
		public function __construct(string $name = 'Undefined')
		{
			$this->_name = $name;
		}
	}

	$obj1 = new Vehicle('Mon bolide');
```
Voilà pourquoi je mets des underscores sur les attributs de classe, vous n'êtes pas obligé de le faire mais moi je le fais parce que je trouve que c'est beaucoup plus pratique c'est à dire que si là on a utilisé le même nom `$name` et `$_name` Eh bien on voit que `$name` est une variable à elle seule alors que là `$_name` comme j'ai mis un underscore j'arrive moi visuellement à comprendre que c'est un attribut de ma classe surtout par le mot-clé `$this`. 

Encore une fois un seul dollar parce que là on peut imaginer que c'est comme si on avait ça c'est à dire que le dollar entour tout ça. 
```php
	$this->_name = $name;
	$(this->_name) = $name;
```
Voilà le dollar entoure tout ça, c'est pour ça qu'on n'a pas besoin de mettre 2 fois le dollar et si vous faites `$this->$_name` vous aurez de toute façon une erreur, et ça c'est l'erreur que font souvent les gens quand ils débutents en PHP, en objet. 

Vous avez juste donc à faire ça.

Il y à partir de là comme mon attribut est public, je peux y accéder en dehors de la classe.

On verra que ce n'est pas bien de faire comme ça mais là pour l'exemple pour démarrer, on va faire ça donc on dit quel objet avec lequel nous voulons travailler, lequel nous voulons travailler, lequel nous voulons utiliser et ensuite la flèche c'est toujours pareil dès qu'on va vouloir accéder à un attribut ou utiliser une méthode de notre objet ce sera toujours la flèche à faire et ensuite l'attribut en question et moi c'est `$_name`.
```php
<?php

class Vehicle
{
	public $_name;
	
	public function __construct(string $name = 'Undefined')
	{
		$this->_name = $name;
	}
}

$obj1 = new Vehicle('Mon bolide');
echo $obj1->_name;
```
Et bien sûr pour l'afficher on va faire ça dans un echo sinon on afficherait rien du tout.

Ça veut dire affiche pour `$obj1`, son attribut `_name` donc à lui, c'est vraiment que à lui. 

J'actualise ma page et on retrouve bien le nom de mon objet.
```txt
	http://localhost/PHP/cours/021_attributs&m%c3%a9thodes/
	Mon bolide
```
On actualise la page et on retrouve bien le nom de l'objet. 

Alors l'avantage de ça cette qu'on va pouvoir … je vais remettre un petit peu de HTML pour faire un retour à la ligne et on ferme la balise PHP, `?>`.

Ensuite je recrée exactement le même code sauf que je crée une nouvelle variable `$obj2`, un nouveau véhicule mais là 'Mon aure bolide' et là maintenant, on va avoir quelque chose de visuel pour se rendre compte que nos 2 objets sont différents.
```php
<?php

class Vehicle
{
	public $_name;
	
	public function __construct(string $name)
	{
		$this->_name = $name;
	}
}

$obj1 = new Vehicle('Mon bolide');
echo $obj1->_name.'<br>';

$obj2 = new Vehicle('Mon autre bolide');
echo $obj2->_name.'<br>';
```
Vous voyez je refais exactement la même chose sauf que si je crée une nouvelle instance qui du coup a un autre nom `$obj2`. 

Et sur ce nouvel objet français, j'appelle l'attribut `$_name` pour l'afficher.
```txt
	http://localhost/PHP/cours/021_attributs&m%c3%a9thodes/
	Mon bolide
	Mon autre bolide
```
Voyez on arrive bien à identifier 2 objets différents parce qu'ils sont encore une fois indépendants. 

Si on voulait modifier l'attribut `$_name` comme il est public, c'est pour ça que ce n'est pas propre du tout, on pourrait le faire également en dehors de la classe. 

À n'importe quel moment je peux dire pour mon objet `$obj1` par exemple ici, et bien cette fois-ci l'attribut `$_name` devient "Bouveau nom" par exemple. C'est un peu bizarre comme nom de véhicule mais admettons. On pourrait du coup afficher un nouveau nom et ensuite j'actualise.
```php
<?php

class Vehicle
{
	public $_name;
	
	public function __construct(string $name)
	{
		$this->_name = $name;
	}
}

$obj1 = new Vehicle('Mon bolide');
echo $obj1->_name.'<br>';

$obj2 = new Vehicle('Mon autre bolide');
echo $obj2->_name.'<br>';

$obj1->_name = 'Nouveau nom';
echo $obj1->_name.'<br>';
```
```txt
	http://localhost/PHP/cours/021_attributs&m%c3%a9thodes/
	Mon bolide
	Mon autre bolide
	Nouveau nom
```
Vous voyez que ça a changé donc ça évidemment ce n'est pas à faire et vous allez comprendre très vite pourquoi, pourquoi on n'est pas censé accéder aux attributs et encore moins les modifier en dehors de la classe. 

Ce comportement c'est à dire cette chose là : public, devrait être réservé pour la classe. 

En programmation, on estime pour des langages comme PHP ou c++, python c'est un petit peu plus particulier. On n'est pas dans un cours python et vous avez la formation si nécessaire sur la chaîne. 

On va toujours respecter la règle qui dit que les attributs seront toujours privés ça veut dire que ce qui est privé et on va utiliser le mot clé private donc à partir de maintenant on va le faire. 

Là d'un coup c'est juste en changeant ce mot-clé j'actualise, boum j'aurais plein d'erreurs fatales.
```php
class Vehicle
{
	private $_name;//<----
	
	public function __construct(string $name)
	{
		$this->_name = $name;
	}
}

$obj1 = new Vehicle('Mon bolide');
echo $obj1->_name.'<br>';

$obj2 = new Vehicle('Mon autre bolide');
echo $obj2->_name.'<br>';

$obj1->_name = 'Nouveau nom';
echo $obj1->_name.'<br>';
```
```txt
	http://localhost/PHP/cours/021_attributs&m%c3%a9thodes/
	Fatal error: Uncaught Error: Cannot access private property Vehicle::$_name in C:\...\index.php:325 Stack trace: #0 {main} thrown in C:\...\index.php on line 325
```
Boum j'ai plein d'erreurs fatales tout simplement parce que j'essaye d'accéder "cannot access private property" soit j'essaie d'accéder à un attribut privé ce qui est interdit donc on ne peut plus faire ce genre de choses et on verra par la suite comment on peut du coup par la suite modifier ou accéder à des attributs par rapport à des attributs qui sont à la base privé.

Alors ça c'est le modèle d'exemple à suivre. 
```php
	class Vehicle
	{
		private $_name;
		
		public function __construct(string $name)
		{
			$this->_name = $name;
		}
	}

	$obj1 = new Vehicle('Mon bolide');
```
Les attributs sont en privé dans certains cas vous aurez peut-être besoin de les mettre en public maison 99,9999% ce sera du privé et on aura tout ceci. 

Privé ça ne veut pas dire qu'on ne peut pas y accéder du tout, ça veut simplement dire que ce n'est pas accessible en dehors de la classe c'est à dire qu'à cet endroit-là de mon fichier je ne peux pas accéder directement en tout cas à mon attribut `$_name`. 
```php
	class Vehicle
	{
		private $_name;
		
		public function __construct(string $name)
		{
			$this->_name = $name;
		}
	}
>
>	$obj1 = new Vehicle('Mon bolide');
```
Par contre la classe elle-même, elle a le droit de faire ça, public function `__construct(string $name)`… on est à l'intérieur de la classe donc le constructeur peut être cédé à ce qu'il veut, il n'y a aucun problème. Il a tous les droits là-dessus donc voilà comment ça fonctionne. 

Alors par la suite ce que nous verrons, nous ferons en fait des méthodes ce qu'on appelle des accesseurs donc des guetters pour accéder ou setters pour modifier nos différents attributs.

Et ces méthodes là seront publiques, vous verrez la différence et en quoi ça consiste. 

On verra ça dans une prochaine vidéo je ne pense pas faire ça maintenant parce que ça va faire un petit peu long pour cette séance là mais on verra ça par la suite. 

Je pense que je ferais une séance sur les accesseurs, juste là dessus. 

Vous donc juste que vous avez à comprendre pour le moment, c'est que les attributs vous les écrivez en privé il vous les déclarer private.

Et les méthodes, de manière générale sauf cas, exception, on les déclarent en général tout le temps public parce que les méthodes cas des services que proposent la classe donc il faut bien qu'on puisse les utiliser en dehors de la classe sinon on pourrait pas faire grand chose avec. 

Voilà comment ça fonctionne. 

Vous savez comment définir les attributs, comment définir les propriétés. 

Vous savez via le constructeur comment renseigner l'information, $this donc très pratique. 

Et maintenant nous allons voir tout simplement comment définir une méthode, comment créer une méthode. 

Alors il existe un autre mot-clé en plus de public et private qui est protected. 

Et protected on l'abordera quand on parlera d'héritage, vous verrez que c'est un cas particulier. 

En fait l'héritage permettra de créer des classes qui héritent d'une classe mère, on peut dire ça. 

Et protected permettra en fait l'accès aux éléments aussi bien pour la classe fille que pour la classe mère.

D'accord elles pourront en fait communiquer entre elles puisqu'elles font partie entre guillemets de la même famille donc le mot clé protected servira dans ce genre de cas. 

Mais pour tout de suite on va juste se contenter de c'est 2 là : public et private. 

private c'est accessible que dans la classe donc Vehicle et public c'est accessible partout même en dehors donc même ici.
```php
	/*
		Attribut (ou propriété)	: variable appartenant à une classe
		Méthode					: fonction appartenant à une classe
	*/

	class Vehicle
	{
		private $_name;
		
		public function __construct(string $name)
		{
			$this->_name = $name;
		}
	}
>
>	$obj1 = new Vehicle('Mon bolide');
```
Il est par définition un attribut on le fait généralement privé il méthode on l'a fait généralement public. 

Comment donc faire une méthode ? vous savez le petit echo qu'on a fait tout à l'heure on peut le faire ici. 

On utilise le mot clé publique parce que je veux que ce soit en dehors de ma classe, ensuite on utilise le mot clé function et ont défini un nom. Vous pouvez comme n'importe quelle fonction PHP mettre des paramètres et cetera, ça suit exactement les mêmes règles que tout ce que vous avez vu sur les fonctions et l'on peut dire par exemple `'hello :) !';`
```php
	class Vehicle
	{
		private $_name;
		
		public function __construct(string $name)
		{
			$this->_name = $name;
		}
		
>		public function hello()
		{
			echo 'hello :) !';
		}
	}

	$obj1 = new Vehicle('Mon bolide');
```
Voilà comment on définit une méthode. 

Pour utiliser la méthode c'est comme ce qu'on a vu tout à l'heure sur l'attribut, vous choisissez l'objet sur lequel vous voulez travailler, lequel vous voulez utiliser, la fameuse flèche et le nom, non pas celui de l'attribut mais celui de la méthode et après vous appelez ça comme une fonction normale donc avec des parenthèses. 

Si elle a des arguments ce sera comme pour le constructeur, il faudra les renseigner et cetera et ensuite j'actualise.
```php
<?php

class Vehicle
{
	private $_name;
	
	public function __construct(string $name)
	{
		$this->_name = $name;
	}
	
	public function hello()
	{
		echo 'hello :) !';
	}
}

$obj1 = new Vehicle('Mon bolide');
$obj1->hello();
```
```txt
	http://localhost/PHP/cours/021_attributs&m%c3%a9thodes/
	hello :) !
```
On a notre petit objet véhicule qui dit Bonjour. 

On pourrait faire tout un tas de choses, on peut du coup imaginer move() et là du coup … alors par contre les accents, il ne va peut être pas aimer parce que je ne suis pas en encodage utf 8. Et on dit que le véhicule se déplace …
```php
<?php

class Vehicle
{
	private $_name;
	
	public function __construct(string $name)
	{
		$this->_name = $name;
	}
	
	public function move()
	{
		echo 'Le vehicule se deplace...';
	}
}

$obj1 = new Vehicle('Mon bolide');
$obj1->move();
```
```txt
	http://localhost/PHP/cours/021_attributs&m%c3%a9thodes/
	Le vehicule se deplace...
```
Je fais une méthode move() et là hop on pourra faire tout un tas de choses pour interagir. 

Si à un moment donné la méthode la move() avait besoin d'accéder à `$_namenoise`, Eh bien je peux évidemment faire ceci `$this->_name` n'oubliez pas que comme c'est privé tous les éléments à l'intérieur de la classe peuvent accéder aux éléments privés d'elle même donc on fait ça et au lieu de dire le véhicule on va dire plutôt juste ceci ' se deplace…'.
```php
<?php

class Vehicle
{
	private $_name;
	
	public function __construct(string $name)
	{
		$this->_name = $name;
	}
	
	public function move()
	{
		echo $this->_name.' se deplace...';
	}
}

$obj1 = new Vehicle('Mon bolide');
$obj1->move();
```
```txt
	http://localhost/PHP/cours/021_attributs&m%c3%a9thodes/
	Mon bolide se deplace...
```
Et là du coup c'est mon bolide qui se déplace d'accord celui qu'on a créé avec le nom. 

Voilà c'est très pratique on peut du coup appeler les attributs et on peut faire tout un tas de choses. 

On peut également modifier comme on l'a fait dans le constructeur la valeur d'un attribut puisqu'on est dans la classe donc on a le droit d'accéder à un attribut privé. 

Voilà comment ça fonctionne pour la définition d'un attribut, la définition de méthode. 

Vous voyez c'est très simple et je vous ai du coup abordé la visibilité des choses. 

Toujours pareil simplement que l'utilisateur celui qui va se servir de votre classe, vous n'avez pas forcément envie qu'ils accèdent n'importe comment aux attributs ou qui les modifie n'importe comment. 

Par la suite donc vous verrez avec les accesseurs, on pourra dire de quelle manière on accède aux attributs et de quelle manière on peut les modifier par exemple `$_name` ça nous permettrait veiller à setter dont on parlera la prochaine fois, et bien de dire que le nom d'un véhicule ne doit pas dépasser 25 caractères ou alors on ne doit pas mettre n'importe quoi dedans, ça ne doit pas être un numéro. 

Vous voyez qu'on va pouvoir appliquer une espèce de filtre de vérification pour s'assurer que les données sont cohérentes, sont correctes par rapport à ce que nous voulons. 

C'est pour ça que par habitude et par définition au niveau de la programmation objet, les attributs seront privés, et les méthodes seront public voilà. 

Si vous avez peur des fois de vous tromper, fais tout le temps ça, tout le temps les attributs en privé et toutes les méthodes en public et il n'y aura pas de problème au niveau de la visibilité dans la programmation objet donc au niveau de vos classes. 

Il a de l'extérieur, la seule chose que vous pouvez appeler avec vos objets ce seront les méthodes. 

Donc il n'y a pas de problème à ce niveau-là. 

Eh bien écoutez je pense qu'on peut s'arrêter là pour cette vidéo, pareil elle n'était pas très très longue. 

On commence doucement, vous voyez comprends vraiment bien autant même s'il y a quand même beaucoup de choses à voir pour ceux qui n'ont jamais programmé un objet. 

Pour vous ça doit quand même être assez nouveau et il doit y avoir beaucoup d'informations à assimiler. 

Pour les autres vous allez quand même gagner pas mal de temps mine de rien. 

Alors est-ce qu'on fera ça dans la prochaine séance ? je ne sais pas mais je pense que oui parce que c'est important, on verra dans la prochaine séance au niveau des accesseurs et comment travailler avec nos attributs privé depuis l'extérieur de nos classes. 

On regardera donc tout ça en détail, vous verrez comment on fait. 

Ce sera très simple, la vidéo ne sera pas forcément très longue non plus mais c'est quelque chose de très important à connaître donc on regardera ça plus en détail dans une prochaine vidéo. 

J'espère que ça a été clair pour vous maintenant que vous savez comment fonctionnent ces attributs, comment fonctionnent ces méthodes. 

Alors je ne l'ai pas évidemment montré en exemple mais je pense que vous l'avez compris. 

Si vous voulez par exemple définir un exemple genre puissance, ce genre de chose `int $puissance` mais c'est assez bizarre de dire comme ça donc on va dire `int $power` même si ça reste bizarre pour une voiture mais peu importe et vous faites ça `private $_power;`
```php
	class Vehicle
	{
		private $_name;
>		private $_power;
		
>		public function __construct(string $name, int $power)
		{
			$this->_name = $name;
>			$this->_power = $power;
		}
		
		public function move()
		{
			echo $this->_name.' se deplace...';
		}
	}

	$obj1 = new Vehicle('Mon bolide');
	$obj1->move();
```
Pour déterminer par exemple une puissance de votre véhicule, vous n'êtes pas obligé d'avoir qu'un seul attribut évidemment pour la classe donc je ne l'ai pas montré directement mais je pense que ça semble logique et après il faudra construire un objet comme ça … ce sera évidemment comme ça.
```php
	class Vehicle
	{
		private $_name;
>		private $_power;
		
>		public function __construct(string $name, int $power)
		{
			$this->_name = $name;
>			$this->_power = $power;
		}
		
		public function move()
		{
>			echo $this->_name.' se deplace...';
		}
	}

>	$obj1 = new Vehicle('Mon bolide', 650);
	$obj1->move();
```
Voilà c'était assez simple comme vidéo en tout cas re si vous avez des questions n'hésitez pas à les poser si nécessaire pour que je puisse vous aider, et on verra dans la prochaine séance comment définir des méthodes spéciales qui seront en fait ici des accesseurs qui nous permettront même en dehors de la classe d'accéder ou même de modifier nos différents attributs privés de nos classes. 

Je vous dis à bientôt pour la suite de cette formation PHP