# [22. Encapsulation des données](https://www.youtube.com/watch?v=vrGedfJXUNo)
02-12-20

Bonjour à tous nous en sommes à la vingt-deuxième séance sur cette formation PHP et la dernière fois je vous avais dit que nous allions travailler un petit peu sur les accesseurs c'est-à-dire la manière de pouvoir accéder ou travailler directement avec les attributs de notre classe. 

Alors j'ai un petit peu modifié le code qu'on avait précédemment.
```php
<?php

class Vehicle
{
	private $_name;
	private $_speed;
	
	public function __construct(string $name, int$speed)
	{
		$this->_name = $name;
		$this->_speed = $speed;
	}
	
	public function move()
	{
		echo 'Le Vehicule '.$this->_name.' se deplace a '.$this->_speed.'km/h';
	}
}

$obj1 = new Vehicle('XC450', 650);
$obj1->move();
```
J'ai toujours gardé notre classe véhicule mais j'ai juste remplacé power par speed pour la vitesse du véhicule donc on peut par exemple imaginer des vaisseaux spatiaux ce genre de choses, je vais modifier un petit peu la méthode move() en rajoutant un petit peu de texte tout simplement et en affichant directement la vitesse `$this->_speed` du coup on obtient en résultat ce genre de choses.
```txt
	http://localhost/PHP/cours/022_encapsulation/
	Le Vehicule XC450 se deplace a 650km/h
```
On a le nom du véhicule et on a du coup la vitesse à laquelle il se déplace. 

On va partir de ça et on va regarder un petit peu comment fonctionne ce principe des accesseurs. 

Alors les accesseurs je vais vous noter pour les gens qui veulent avoir le nécessaire sous la main donc on parle d'accessoires enfaite pour 2 choses. 

Pour les accesseurs on va retrouver ce qu'on appelle le getter qui permettent de lire l'information donc lire un attribut donc c'est vraiment un accès.

Et on a le setter qui lui va modifier un attribut voilà.
```txt
	/*
		Accesseurs : getter (lire un attribut)
					 setter (modifier un attribut)
	*/
```
Voilà est ça le getter et le setter quand on veut généraliser on parle des accesseurs d'accord. 

Tout cela consiste en tout cas par le principe d'encapsulation au niveau de nouveaux attributs. 

On va reprendre ici le schéma concernant nos classes.

![classes&objets.png](classes&objets.png)

<!--
	+---------------------------------------------------------------------------+
	|																			|
	|	+-------------------+							+-------------------+	|
	|	| Vehicule			|							| Guerrier			|	|
	|	| 					|							| 					|	|
	|	| - tournerDroite()	|							| - seDeplacer()	|	|
	|	| - tournerGauche()	|							| - attaquer()		|	|
	|	| - freiner()		|							| 					|	|
	|	| 					|							| piecesOr			|	|
	|	| nombrePlaces		|							| pointsDeVie		|	|
	|	| typeCarurant		|							| 					|	|
	|	+-------------------+							+-------------------+	|
	|	                                                                        |
	|							+-------------------+							|
	|							| Habitation		|							|
	|							| 					|							|
	|							| - vendre()		|							|
	|							| - acheter()		|							|
	|							| - allerA()		|							|
	|							|					|							|
	|							| nombrePieces		|							|
	|							| prixVente			|							|
	|							+-------------------+		Application			|
	|                                                                           |
	+---------------------------------------------------------------------------+
-->
Concernant les classes je vous avais expliqué que la classe vous pouvez la considérer comme étant une entité propre d'accord. 

On peut avoir une classe pour un guerrier, une classe pour une habitation, une classe pour un véhicule et cetera et cetera. 

Dans la terre des choses par rapport à ce que l'on développent dans cette manière de programmer en objet, on va respecter en fait le partage des différentes entités et de ne pas pouvoir comme ça accéder n'importe comment aux différentes informations de celle-ci. 

Alors de manière générale sauf cas précis, sauf des cas spécifiques, les méthodes d'accord ce que permettent de faire les objets sont accessibles publiquement d'accord. 

Je vous avais expliqué précédemment qu'on utilise le mot clé public pour dire que nos méthodes y compris le constructeur sont publics. 

Il peut y avoir des cas où nos méthodes sont privées, ou des cas où même le constructeur peut être privé quand on parle notamment design pattern Singleton.

Mais ça on aura l'occasion d'en parler sur d'autres vidéos et même d'autres formations pour ceux que ça intéresse. 

Et au niveau des attributs, je vous ai dit que généralement on passe les attributs en privé. 

Et je vous ai parlé rapidement du mot-clé protected donc protégé qu'on abordera lorsqu'on parlera d'héritage au niveau de cette programmation objet. 

Nous ce qui nous intéressé surtout c'est par défaut ces attributs qui sont de manière générale privé ça veut dire qu'ils appartiennent de manière privée au véhicule d'accord ce sont ces informations à lui. 

Mais si on veut accéder, nous par exemple ici `$obj1->move()` où j'ai utilisé une méthode donc pas de problème, le constructeur et la méthode move() sont en public en dehors de la classe parce que je rappelle que à partir d'ici à cet endroit nous sommes en dehors de la classe.
```php
	class Vehicle
	{
		private $_name;
		private $_speed;
		
		public function __construct(string $name, int$speed)
		{
			$this->_name = $name;
			$this->_speed = $speed;
		}
		
		public function move()
		{
			echo 'Le Vehicule '.$this->_name.' se deplace a '.$this->_speed.'km/h';
		}
	}
	
	//Nous sommes en dehors de la classe
	$obj1 = new Vehicle('XC450', 650);
	$obj1->move();
```
Ça c'est important. 

Après un peu PHP ça se voit beaucoup mieux compétent parce qu'on voit qu'il y a des accolades donc on arrive à facilement identifier où s'arrête la classe.

Ainsi c'est plus simple pour l'esprit de se rendre compte là où ça se termine. 

Là donc nous sommes en dehors de la classe donc tout ce qui est public pas de problème. 

Par contre si j'essaye de faire un petit echo de mon objet $obj1 et que j'essaie d'accéder par exemple à son attribut _name; et ensuite je vais actualiser. 
```php
<?php

class Vehicle
{
	private $_name;
	private $_speed;
	
	public function __construct(string $name, int$speed)
	{
		$this->_name = $name;
		$this->_speed = $speed;
	}
	
	public function move()
	{
		echo 'Le Vehicule '.$this->_name.' se deplace a '.$this->_speed.'km/h';
	}
}

//Nous sommes en dehors de la classe
$obj1 = new Vehicle('XC450', 650);
$obj1->move();
echo $obj1->_name;
```
```txt
	http://localhost/PHP/cours/022_encapsulation/
	Le Vehicule XC450 se deplace a 650km/h
	Fatal error: Uncaught Error: Cannot access private property Vehicle::$_name in C:\Users\...\index.php:155 Stack trace: #0 {main} thrown in C:\Users\...\index.php on line 155
```
Et là du coup il nous met qu'on n'a pas le droit d'accéder à une propriété donc à un attribut privé du véhicule et notamment son attribut `$_name`. 

Alors même si le message est en anglais il est parfaitement compréhensible sans problème et on se rend bien compte du souci qu'il y a tout simplement par ce principe d'encapsulation. 

C'est à dire imaginer encore une fois que chaque entité, chaque classe représente une sorte de boîte dans lequel tout est fermé et vous avez un ensemble de manettes que vous pouvez actionner pour utiliser ces méthodes qui elles sont public. 

En revanche les infos donc les attributs ce qui définit la classe, elles ne sont pas accessibles depuis l'extérieur de celle-ci. 

Alors pour cela qu'est-ce que nous allons faire ? Est-ce que vous avez compris ce que je vous ai dit jusqu à présent et notamment le principe que de manière générale les méthodes sont publics. 

Eh bien nous allons utiliser des méthodes qui vont faire un petit peu la médiation c'est-à-dire qu'ils vont être un peu l'intermédiaire entre l'extérieur de la classe et l'accès aux attributs et c'est pour ça que nous allons avoir des méthodes spécifiques pour ça. 

Alors ces méthodes de manière habituelle on va leur donner les nombres précis. 

Pour le getter, on va lui donner le nom de get suivi le nom de l'attribute donc sous cette forme getAttribut, et en général pour les setters, on va mettre setAttribute.
```php
	/*
		Accesseurs : getter (lire un attribut)		-> getAttribute
					 setter (modifier un attribut)	-> setAttribute
	*/
```
Alors vous pouvez les appeler comme vous voulez parce que comme c'est une méthode vous pouvez mettre le nom que vous voulez mais pour vous pour une question de lisibilité, vous pouvez utiliser ces termes là. 

Donc si je veux avoir des accesseurs pour mon attribut `$_name`, comment est-ce que je vais faire ? Eh bien je vais tout simplement créer les accessoires de cette manière. 

public function .. je crée une méthode et je vais l'appeler getName() et ne prend évidemment rien en paramètre, qu'est-ce qu'elle fait le plus simplement du monde ? Elle retourne la valeur de l'attribut.
```php
		public function getName()
		{
			return $this->_name;
		}
```
Alors on pourrait se dire que du coup ça ne sert à rien de faire ça parce qu'on passe par une méthode et au final on fait que retourner la valeur de l'attribut mais bien si justement Parce qu'on n'y accède pas directement. 

C'est au sein de la classe qu'on a une méthode qui elle va se charger d'accéder à l'attribut donc vous quand vous utilisez dans votre code et c'est ce que nous allons faire donc au lieu de faire `$obj1->_name;` on va faire faire `$obj1->getName();`
```php
	echo $obj1->_name;
	--> echo $obj1->getName();
```
Vous voyez pas une seule fois j'écris au sujet de l'attribut. 

Je n'ai même pas besoin de savoir comment s'appelle l'attribut dans la classe, j'aurais pu le nommer autrement que `$_name`. Et comme c'est la méthode ici qui le fait, getName(). Nous tout ce qu'on fait c'est qu'on a utilisé cette méthode là, getName(). 

Et là évidemment si j'actualise.
```php
<?php

class Vehicle
{
	private $_name;
	private $_speed;
	
	public function getName()
	{
		return $this->_name;
	}
	
	public function __construct(string $name, int$speed)
	{
		$this->_name = $name;
		$this->_speed = $speed;
	}
	
	public function move()
	{
		echo 'Le Vehicule '.$this->_name.' se deplace a '.$this->_speed.'km/h';
	}
}

//Nous sommes en dehors de la classe
$obj1 = new Vehicle('XC450', 650);
echo $obj1->getName();
```
```txt
	http://localhost/PHP/cours/022_encapsulation/
	XC450
```
On a bien le nom du véhicule qui apparaît d'accord donc pas de problème à ce niveau-là. 

Alors ça c'est encore une fois le getter par défaut, c'est le moins que l'on puisse faire. 

Mais dans certains cas, on pourrait très bien dire que nous non on ne veut pas récupérer le nom du véhicule ou alors on veut le récupérer sous certaines conditions. 

Et comme il s'agit ici d'une méthode donc d'une fonction de classe, vous pouvez mettre sans problème des conditions. 

Par exemple, je ne sais pas pour quelle raison on pourrait par exemple dire qu'on voudrait interdire l'accès à `$_name` au lieu de le retourner, on pourrait simplement dire "Nom impossible à recuperer". Je ne mets pas les actions parce qu'on n'est pas avec du HTML et pour éviter les petits problèmes de codage `''` au lieu de `""`.
```php
<?php

class Vehicle
{
	private $_name;
	private $_speed;
	
	public function getName()
	{
		echo 'Nom impossible a recupere';
	}
	
	public function __construct(string $name, int$speed)
	{
		$this->_name = $name;
		$this->_speed = $speed;
	}
	
	public function move()
	{
		echo 'Le Vehicule '.$this->_name.' se deplace a '.$this->_speed.'km/h';
	}
}

//Nous sommes en dehors de la classe
$obj1 = new Vehicle('XC450', 650);
echo $obj1->getName();
```
```txt
	http://localhost/PHP/cours/022_encapsulation/
	Nom impossible a recupere
```
Et là du coup avec l'intermédiaire c'est la méthode qui fait le travail. 

De manière générale encore une fois, dans la majorité des cas, on se contente avec le getter de simplement retourner l'attribut voilà. 
```php
	public function getName()
	{
		return $this->_name;
	}
```
Le getter ne fait en général pas plus que ça. 

Par contre pour le setter, on va faire la même chose setName() qui va prendre en paramètre le nouveau nom donc on va mettre string $name donc pas besoin de s'embêter sur le nom de la variable et voilà.
```php
	public function setName(string $name)
	{

	}
```
Et là c'est pareil, par défaut qu'est-ce qu'on va faire ? on fera ceci  
```php
	public function setName(string $name)
	{
		$this->_name = $name;
	}
```
Si vous Regardez bien le code vous voyez que c'est exactement la même chose que ce qui est fait dans le constructeur. 

Et le mieux pour setName() c'est qu'on peut du coup afficher certains filtres d'accord de contrôler le nom qui a été passé en paramètre `$name` pour être sûr ensuite d'avoir un nom stocké ici de manière valide. 

Admettons par exemple que je veux que le nom ne dépasse pas 25 caractères, Eh bien je peux par exemple faire ça où on va utiliser strlen() qui est une fonction qui retourne la longueur d'une chaîne pour ceux qui se posent la question et donc si `strlen($name)` est plus grand que 25, on leverait une exception mais comme on n'a pas encore vu les exceptions, On va mettre `echo 'ERREUR : Nom de vehicule trop long'`
```php
	public function setName(string $name)
	{
		if(strlen($name) > 25)
			echo 'ERREUR : Nom de vehicule trop long';
		$this->_name = $name;
	}
```
Enfin bref vous mettez un message quel qu'il soit. 

Et sinon, on va effectivement stocker le nouveau nom.
```php
	public function setName(string $name)
	{
		if(strlen($name) > 25)
			echo 'ERREUR : Nom de vehicule trop long';
		else
			$this->_name = $name;
	}
```
Pour le coup on va faire getName(), on va le réafficher si j'essaye de faire `$obj1->setName('');` en changeant de nom et que je mets un autre nom 'XF220' par exemple et si je test.
```php
<?php

class Vehicle
{
	private $_name;
	private $_speed;
	
	public function getName()
	{
		return $this->_name;
	}

	public function setName(string $name)
	{
		if(strlen($name) > 25)
			echo 'ERREUR : Nom de vehicule trop long';
		else
			$this->_name = $name;
	}
	
	public function __construct(string $name, int$speed)
	{
		$this->_name = $name;
		$this->_speed = $speed;
	}
	
	public function move()
	{
		echo 'Le Vehicule '.$this->_name.' se deplace a '.$this->_speed.'km/h';
	}
}

//Nous sommes en dehors de la classe
$obj1 = new Vehicle('XC450', 650);
echo $obj1->getName();
$obj1->setName('XF220');
echo $obj1->getName();
```
```txt
	http://localhost/PHP/cours/022_encapsulation/
	XC450XF220
```
Voilà on a bien le XC450 au départ et le nom a bien changé. 

Par contre si j'essaye effectivement de faire un nom à rallonge, plus que 25 caractères évidemment la modification ne se fera pas.
```php
<?php

class Vehicle
{
	private $_name;
	private $_speed;
	
	public function getName()
	{
		return $this->_name;
	}

	public function setName(string $name)
	{
		if(strlen($name) > 25)
			echo 'ERREUR : Nom de vehicule trop long';
		else
			$this->_name = $name;
	}
	
	public function __construct(string $name, int$speed)
	{
		$this->_name = $name;
		$this->_speed = $speed;
	}
	
	public function move()
	{
		echo 'Le Vehicule '.$this->_name.' se deplace a '.$this->_speed.'km/h';
	}
}

//Nous sommes en dehors de la classe
$obj1 = new Vehicle('XC450', 650);
echo $obj1->getName();
$obj1->setName('XF22000000000000000000646484151168890000');
echo $obj1->getName();
```
```txt
	http://localhost/PHP/cours/022_encapsulation/
	XC450ERREUR : Nom de vehicule trop longXC450
```
Évidemment la modification ne se fera pas d'accord. 

J'obtiens tout simplement l'erreur par rapport au nom de véhicule trop long et on se rend bien compte à la fin que le nom n'a pas changé. 

Voilà à quoi peut servir le setter c'est à dire de contrôler de filtrer tout simplement la validité ou non donc comment on veut que l'information soit stocké. 

Est-ce qu'on veut que l'annonce ait une certaine longueur ? est-ce qu'on veut qu'il contienne certains caractères précis ou autre ?

Et vous savez qu'en web ça peut être très utile quand vous allez vouloir valider des formulaires, des champs de formulaire. 

Vous pourrez vous servir d'une classe comme ça qui contrôlera un petit peu les attributs pour les éléments de votre formulaire donc c'est très très utile. 

Alors dans l'idéal, aussi ce que l'on peut faire, vous voyez au niveau du constructeur on s'amuse à faire ça.
```php
	public function __construct(string $name, int$speed)
	{
>		$this->_name = $name;
>		$this->_speed = $speed;
	}
```
Là c'est pareil au niveau du constructeur on ne vérifie pas la longueur du nom et cetera donc vous pouvez à ce moment-là plutôt que de faire ceci, et bien d'appeler la méthode setName() à ce moment là et il faudrait faire aussi normalement la méthode pour la vitesse  donc il faudrait normalement setSpeed() de `$speed`.
```php
	public function __construct(string $name, int$speed)
	{
>		$this->setName($name);
>		$this->setSpeed($speed);
	}
```
Il fera également la méthode qui va bien setName() et setSpeed() et le getter aussi correspondant.

En général donc pour chaque attribut pour obtenir les choses vous avez un getter et un setter. 

Le minimum qu'il faut c'est le getter qui ne fait que retourner la valeur de l'attribut. 

Le setter ne fait que la modifier. 

Voilà ça c'est le code minimal à mettre pour l'un et l'autre.
```php
	public function setName(string $name)
	{
>			$this->_name = $name;
	}
```
Voilà ça tient vraiment à une seule instruction, c'est vraiment le minimum et bien sûr vous pouvez faire des choses un peu plus poussées si vous avez par exemple besoin de vérifier des valeurs particulières vous n'êtes pas obligé de faire que ça mais c'est tout à fait possible bien évidemment de travailler que là dessus et là vous allez pouvoir voir que ça peut même tenir sur une seule ligne si on ne veut pas en rajouter trop.
```php
	class Vehicle
	{
		private $_name;
		public function getName(){ return $this->_name; }
		public function setName(string $name){ $this->_name = $name; }		
		
		private $_speed;

		public function __construct(string $name, int$speed)
		{
			$this->_name = $name;
			$this->_speed = $speed;
		}
		
		public function move()
		{
			echo 'Le Vehicule '.$this->_name.' se deplace a '.$this->_speed.'km/h';
		}
	}

	//Nous sommes en dehors de la classe
	$obj1 = new Vehicle('XC450', 650);
	echo $obj1->getName();
	$obj1->setName('XF22000000000000000000646484151168890000');
	echo $obj1->getName();
```
Voilà on aura par exemple les accesseurs liés aux attributs comme ça vous arriverez à vous y retrouver.

Voilà donc comment fonctionne ce principe d'encapsulation.

Alors on aura l'occasion d'en parler plus en détail parce que c'est quelque chose qui va peut nous suivre tout au long de cette programmation orienté objet en PHP. 

J'en parle également avec les autres langages de programmation que j'enseigne sur la chaîne mais en tout cas ce qu'il faut comprendre à la base c'est vraiment de garantir l'intégrité de données et surtout le non accès depuis l'extérieur de manière incorrecte c'est-à-dire qu'on ne va pas directement accéder à l'élément, on va passer pour cela par des méthodes c'est-à-dire des getters et des setters pour pouvoir travailler avec nos attributs soit pour les lire où soit pour les modifier. 

Et vous avez compris un petit peu le principe, on peut du coup appliquer des filtres, on peut valider les données avant de les enregistrer donc ça peut être très très pratique à ce niveau-là. 

Écoutez comme je vous avais dit que c'était une vidéo courte, c'est effectivement le cas parce qu'il n'y a pas grand chose à dire de plus pour ce principe d'accesseur.

Il faudra apprendre à les mettre en pratique comme il faut et avoir dans un cas concret l'utilité qu'ils ont parce que je vous dis que les accessoires qui font juste un return ou une modification, il n'y a pas grand chose de plus mais c'est bien de le faire. 

Ça doit être un automatisme, c'est comme en c++, des langages comme ça c'est strict dans la manière d'accéder aux éléments, on ne permet pas la lecture et la modification des attributs en dehors des classes. 

Ça c'est une règle en PHP à respecter comment le respecter également en c++ mais en python c'est différent pour ceux qui suivent ma formation python, vous aviez vu que la philosophie autour du langage python été légèrement différente concernant l'accès aux attributs. 

Mais pour PHP comme pour c++ par exemple on a effectivement cette règle à respecter c'est-à-dire de passer par des accesseurs. 

Ça rajoute donc du code mais pensez y à chaque attribut de faire un getter, un setter pour chacun.

Il faudrait également pareil pour $speed. 

On pense donc à le faire pour chacun des attributs de notre classe pour garantir cette encapsulation des données. 

Voilà j'espère que c'était suffisamment clair et comme je vous l'avais dit ce n'était pas trop trop long parce qu'il n'y avait pas grand chose à dire, on a fait quand même pas mal le tour. 

N'hésitez pas à vous en servir bien évidemment, à mettre, à rajouter ces petits accesseurs si vous êtes en train de vous entraîner et vous exercez à la création de classes en PHP. 

S'il y a des questions par rapport à ça n'hésitez pas à les poser, n'hésitez pas à laisser un petit like sur la vidéo, j'en profite en passant pour le dire si ça vous a plu. 

Et on se retrouvera du coup pour la suite, on a encore beaucoup beaucoup de choses à voir sur cette programmation objet en PHP. 

À bientôt tout le monde