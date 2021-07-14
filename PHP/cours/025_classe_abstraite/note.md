# [25. Classe abstraite](https://www.youtube.com/watch?v=Wh0aRwvZigc)
08-12-20

Bonjour et bienvenue sur la 25e séance en PHP.

On va parler d'abstraction de classe et avant toutes choses on va faire une petite parenthèse sur un petit élément que j'ai oublié d'aborder avec vous dans la vidéo précédente concernant l'héritage et qui était très important à savoir pour la suite. 

Alors on va revenir très rapidement dessus, je vais vous refaire un petit code ici rapidement. 

On va créer une classe mère pour reprendre un peu les exemples qu'on avait précédemment. Alors je ré-écrit tout avec vous comme ça, ça fera des petites révisions sur les vidéos précédentes.
```php
	class Mere
	{
		public function __construct($name)
	}
```
On a donc une classe mère.

On définit son constructeur public. 

Ensuite elle a comme information un nom, `$name` que l'on va stocker dans un attribut `$_name` que l'on va créer au-dessus de notre constructeur et on va le mettre en protected car on va faire une classe fille.
```php
	class Mere
	{
		protected $_name;
		
		public function __construct($name)
		{
			$this->_name = $name;
		}
	}
```
Voilà on a `protected $_name`. On a le constructeur qui stock dans name. 

Et on a ensuite une petite méthode toute simple hello() qui dit tout simplement qu'elle est la mère et qui va donner le nom en même temps comme ça on aura les informations.
```php
<?php

class Mere
{
	protected $_name;
	
	public function __construct($name)
	{
		$this->_name = $name;
	}
	
	public function hello()
	{
		echo 'Coucou, je suis la Mere : '.$this->_name;
	}
}

$mama = new Mere('Katie');
$mama->hello();
```
Voilà ça c'est la base et maintenant si je test.
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Coucou, je suis la Mere : Katie
```
Voilà on teste ça et je vais un peu vite parce que ça c'est de la révision toute simple. 

On a donc l'appel à la méthode et le nom qui est bien mis donc pas de problème. 

Ça c'est ce qu'on avait déjà vu. 

Alors maintenant on crée une classe fille qui est une extension de la classe Mere.
```php
	class Mere
	{
		protected $_name;
		
		public function __construct($name)
		{
			$this->_name = $name;
		}
		
		public function hello()
		{
			echo 'Coucou, je suis la Mere : '.$this->_name;
		}
		
>		class Fille extends Mere
		{
			
		}
	}

	$mama = new Mere('Katie');
	$mama->hello();
```
On va surcharger le constructeur pour ajouter des éléments en plus donc elle prend tous les éléments de la classe mère `$name` et autre chose `$otherName` et donc voilà moi je veux simplement le mettre un autre non je ne vais pas chercher plus loin.
```php
		class Fille extends Mere
		{
>			private $_otherName;
			
>			public function __construct($name, $otherName)
			{
				
			}
		}
```
Il a on appelle le constructeur par an c'est-à-dire ce qu'on avait vu précédemment, `parent::`, avec les éléments qu'il est censé prendre `$name`. Et ici, il prend `$otherName`.
```php
		class Fille extends Mere
		{
>			private $_otherName;
			
>			public function __construct($name, $otherName)
			{
				parent::__construct($name);
				$this->_otherName = $otherName;
			}
		}
```
On réécrit également notre méthode hello() parce qu'on ne veut pas qu'elle dise qu'elle est la mère parce qu'elle n'est pas la mère. On crée ensuite la fille et même chose, elle dit hello().
```php
<?php

class Mere
{
	protected $_name;
	
	public function __construct($name)
	{
		$this->_name = $name;
	}
	
	public function hello()
	{
		echo 'Coucou, je suis la Mere : '.$this->_name.'<br>';
	}
}

class Fille extends Mere
{
	private $_otherName;
	
	public function __construct($name, $otherName)
	{
		parent::__construct($name);
		$this->_otherName = $otherName;
	}
	
	public function hello()
	{
		echo 'Je suis la Fille : '.$this->_name.' '.$this->_otherName.'<br>';
	}
}

$mama = new Mere('Katie');
$mama->hello();

$fifille = new Fille('Maude', 'Lanissie');
$fifille->hello();
```
Voilà donc ça c'est de la révision de ce qu'on a vu précédemment, une classe mère et une classe fille qui étend. On prend le constructeur et on fait appel au constructeur parent `parent::…` et on lui donne un nouvel attribut en plus `$_otherName` donc elle est spécialisée par rapport à la classe mère et on a redéfini la méthode hello() pour que la fille ne disent pas helo de la même manière que la mère. 

Si j'actualise on obtient donc ça.

Alors toujours les petites balises pour le retour à la ligne et comme on a du code HTML on ferme la balise PHP.
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Coucou, je suis la Mere : Katie
	Je suis la Fille : Maude Lanissie
```
Voir je suis là mère Katie, je suis là fille Maude donc pas de problème. 

Voilà on voit la formation complète.

On voit les 2 comportements différents. 

Ça c'est ce qu'on avait vu au niveau de l'héritage. Je vous avais même dit qu'on peut très bien créer par exemple une classe PetiteFille qui va éteindre la classe Fille. 
```php
<?php

class Mere
{
	protected $_name;
	
	public function __construct($name)
	{
		$this->_name = $name;
	}
	
	public function hello()
	{
		echo 'Coucou, je suis la Mere : '.$this->_name.'<br>';
	}
}

class Fille extends Mere
{
	private $_otherName;
	
	public function __construct($name, $otherName)
	{
		parent::__construct($name);
		$this->_otherName = $otherName;
	}
	
	public function hello()
	{
		echo 'Je suis la Fille : '.$this->_name.' '.$this->_otherName.'<br>';
	}
}

class PetiteFille extends Fille
{
	
}

$mama = new Mere('Katie');
$mama->hello();

$fifille = new Fille('Maude', 'Lanissie');
$fifille->hello();

?>
```
Si j'actualise mon code sans même créer de nouvelles instances de quoi que ce soit, pas de problème, il n'y aurait pas d'erreur.
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Coucou, je suis la Mere : Katie
	Je suis la Fille : Maude Lanissie
```
Sans on va pouvoir l'empêcher c'est-à-dire qu'on a un mot-clé en PHP qui est le mot-clé final et c'est ça dont je vous avais parlé dans la vidéo précédente qui va nous permettre de dire au bout d'un moment Eh bien on arrête cet héritage. 

C'est un peu comme si par exemple ici je reprends mon schéma de la dernière fois.

![schéma_02.JPG](schéma_02.JPG)
<!--
	+---------------+							+---------------+
	|Gestionnaire	|							|Carte			|
	+---------------+							+---------------+
	|init()			|							|id				|
	|launch()		|							|nom			|
	|update()		|							|description	|
	|free()			|							|				|
	+---------------+							+---------------+
			^											^
			|											|
			+-------------------+						|
			|					|						|
	+---------------+ +-----------------+		+---------------+
	|GestionnaireSon| |GestionnaireImage|		|CartePiege		|
	+---------------+ +-----------------+		+---------------+
	|mute()			| |refresh()		|		|effet			|
	|pause()		| |rotate()			|		|dureeEffet		|
	|next()			| |zoomIn()			|		|				|
	|back()			| |zoomOut()		|		|				|
	+---------------+ +-----------------+		+---------------+
-->
Là on a la classe mère Gestionnaire, une classe fille GestionnaireSon mais on ne veut pas que quelque chose hérite de  GestionnaireSon ou GestionnaireImage. Ce sont en fait les classes le plus en bas de l'héritage donc c'est ce qu'on appelle en fait les classes finales. 

Pour faire ça, il suffit tout simplement donc c'est très simple d'indiquer le mot-clé final au début de la définition de la classe ici.

Ça veut simplement dire que la classe fille est une classe finale et qu'elle ne pourra pas être étendue. 
```php
<?php

class Mere
{
	protected $_name;
	
	public function __construct($name)
	{
		$this->_name = $name;
	}
	
	public function hello()
	{
		echo 'Coucou, je suis la Mere : '.$this->_name.'<br>';
	}
}

final class Fille extends Mere
{
	private $_otherName;
	
	public function __construct($name, $otherName)
	{
		parent::__construct($name);
		$this->_otherName = $otherName;
	}
	
	public function hello()
	{
		echo 'Je suis la Fille : '.$this->_name.' '.$this->_otherName.'<br>';
	}
}

class PetiteFille extends Fille
{
	
}

$mama = new Mere('Katie');
$mama->hello();

$fifille = new Fille('Maude', 'Lanissie');
$fifille->hello();

?>
```
Alors si j'actualise ma page, généreux qui me dit tout simplement que PetiteFille ne peut pas hériter d'une classe finale qui est la classe Fille.
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Fatal error: Class PetiteFille may not inherit from final class (Fille) in C:\...\index.php on line 286
```
Voilà donc on ne peut plus faire de classe qui étende ouais la classe fille grâce à ça.

C'est une possibilité de faire un final sur une classe complète mais on peut également le faire sur une méthode. 

C'est par exemple ici je veux dire que la classe mère possède une méthode hello() que je n'ai pas envie de pouvoir redéfinir dans les classes filles c'est-à-dire que tout le monde dira que c'est une mère même si c'est une fille. 

Eh bien je me final au début de la définition de la méthode et non plus de la classe. 
```php
<?php

class Mere
{
	protected $_name;
	
	public function __construct($name)
	{
		$this->_name = $name;
	}
	
	final public function hello()
	{
		echo 'Coucou, je suis la Mere : '.$this->_name.'<br>';
	}
}

class Fille extends Mere
{
	private $_otherName;
	
	public function __construct($name, $otherName)
	{
		parent::__construct($name);
		$this->_otherName = $otherName;
	}
	
	public function hello()
	{
		echo 'Je suis la Fille : '.$this->_name.' '.$this->_otherName.'<br>';
	}
}

class PetiteFille extends Fille
{
	
}

$mama = new Mere('Katie');
$mama->hello();

$fifille = new Fille('Maude', 'Lanissie');
$fifille->hello();

?>
```
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Fatal error: Cannot override final method Mere::hello() in C:\...\index.php on line 334
```
Alors je fais une erreur pour dire qu'on ne peut pas surcharger (ovveride), je ne peux pas redéfinir réécrire la méthode finale de la classe mère qui s'appelle hello(). 

Du coup cette méthode hello() de la classe fille ne sert plus à rien et donc les filles diront qu'elles sont des mères également. 
```php
<?php

class Mere
{
	protected $_name;
	
	public function __construct($name)
	{
		$this->_name = $name;
	}
	
	final public function hello()
	{
		echo 'Coucou, je suis la Mere : '.$this->_name.'<br>';
	}
}

class Fille extends Mere
{
	private $_otherName;
	
	public function __construct($name, $otherName)
	{
		parent::__construct($name);
		$this->_otherName = $otherName;
	}
}

class PetiteFille extends Fille
{
	
}

$mama = new Mere('Katie');
$mama->hello();

$fifille = new Fille('Maude', 'Lanissie');
$fifille->hello();

?>
```
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Coucou, je suis la Mere : Katie
	Coucou, je suis la Mere : Maude
```
Vous voyez tout le monde dit qu'elle est la mère et même la fille. 

On ne peut donc pas redéfinir la méthode hello() grâce à ça. 

C'était la petite parenthèse, c'était la petite chose que j'avais oubliée et qui était quand même très importante. 

Voilà ce principe là concernant l'héritage et maintenant que c'est vu, on va passer véritablement au thème de cette vidéo c'est-à-dire l'abstraction de classe vidéo qu'on va voir comment créer une classe abstraite, on verra également comment avoir des méthodes abstraites et à quoi ça consiste. 

On avait dit dans la vidéo précédente si je reprends mon schéma, qu'on avait … et j'avais même dit le mot abstrait à un moment donné, je vous avais dit que la classe Carte que c'est un peu une classe abstraite sans forcément entrer dans le détail de ce qu'on entendait par abstrait quand on parle de programmation orientée objet. 

Une classe abstraite c'est tout simplement une classe qui est un peu vague c'est-à-dire qu'on a défini des informations et des propriétés et éventuellement des méthodes surtout mais on ne sait pas comment ça va se passer, comment elle va fonctionner.

![schéma_02.JPG](schéma_02.JPG)
<!--
	+---------------+							+---------------+
	|Gestionnaire	|							|Carte			|
	+---------------+							+---------------+
	|init()			|							|id				|
	|launch()		|							|nom			|
	|update()		|							|description	|
	|free()			|							|				|
	+---------------+							+---------------+
			^											^
			|											|
			+-------------------+						|
			|					|						|
	+---------------+ +-----------------+		+---------------+
	|GestionnaireSon| |GestionnaireImage|		|CartePiege		|
	+---------------+ +-----------------+		+---------------+
	|mute()			| |refresh()		|		|effet			|
	|pause()		| |rotate()			|		|dureeEffet		|
	|next()			| |zoomIn()			|		|				|
	|back()			| |zoomOut()		|		|				|
	+---------------+ +-----------------+		+---------------+
-->
Une classe abstraite en programmation, c'est une classe qu'on ne va pas pouvoir instancier. 

Là aussi je reprends donc mon exemple ici, je créé ma classe de manière abstraite donc je fais abstract class Mere … alors je vais virer le constructeur et les propriétés parce qu'on s'en fiche pour l'exemple là et ma fonction hello(), Regardez je vais juste faire ça sans faire d'implémentation, je définis juste la méthode.
```php
>	abstract class Mere
	{	
>		public function hello();
	}

	class Fille extends Mere
	{
		private $_otherName;
		
		public function __construct($name, $otherName)
		{
			parent::__construct($name);
			$this->_otherName = $otherName;
		}
	}

	$mama = new Mere('Katie');
	$mama->hello();

	$fifille = new Fille('Maude', 'Lanissie');
	$fifille->hello();
```
Et pour que ce soit abstrait, on va mettre un abstract ici et comme ça va être spécifié par la suite, on va mettre protected.
```php
<?php

abstract class Mere
{	
	abstract protected function hello();
}

class Fille extends Mere
{
	private $_otherName;
	
	public function __construct($name, $otherName)
	{
		parent::__construct($name);
		$this->_otherName = $otherName;
	}
}

$mama = new Mere('Katie');
$mama->hello();

$fifille = new Fille('Maude', 'Lanissie');
$fifille->hello();
```
Voilà si vous avez une méthode qui est abstract, il faudra avoir une classe cat abstract donc en général elle n'utilise les 2 paires. 

On a donc notre classe abstraite qui ne pourra pas être instancié c'est-à-dire qu'on ne va plus pouvoir créer des objets de classe mère. Vous allez voir que ça ne marchera plus.

Et en plus de ça la méthode hello() comme elle n'a pas été implémentée, on dit simplement qu'une mère est capable de dire hello() donc c'est une classe un peu vague dont on sait ce qu'elle est capable de faire mais on ne sait pas comment. 

Là évidemment si j'essaye d'exécuter ma page, je vais avoir plein de problèmes.
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Fatal error: Class Fille contains 1 abstract method and must therefore be declared abstract or implement the remaining methods (Mere::hello) in C:\...\index.php on line 474
```
Je vais avoir plein de problèmes parce que on me dit tout simplement que j'essaye ici d'utiliser une méthode abstraite alors qu'elle n'a pas été implémentée donc peu importe ici on va passer ça pour le moment à ce niveau là. 

D'ailleurs si je fais juste ça.
```php
abstract class Mere
{	
	protected function hello();
}

class Fille extends Mere
{
	private $_otherName;
	
	public function __construct($name, $otherName)
	{
		parent::__construct($name);
		$this->_otherName = $otherName;
	}
}

$mama = new Mere('Katie');
$mama->hello();

$fifille = new Fille('Maude', 'Lanissie');
$fifille->hello();
```
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Fatal error: Non-abstract method Mere::hello() must contain body in C:\...\index.php on line 499
```
Là vous le voyez tout simplement que la méthode hello() n'a pas d'implémentation et c'est pour ça qu'on parle de body.

Alors nous on est abstract, on ne peut donc plus créer d'objet Mere parce qu'on ne veut pas le faire. Voilà 

c'est comme si dans notre jeu on voulait dire qu'on ne créera jamais de Carte simple.

C'est juste qu'on s'en sert pour avoir un modèle simple, un modèle de départ, un modèle un peu vague et ensuite toutes les cartes de notre jeu seront des spécialisations tel qu'une carte monstre, une carte elfique, une carte piège, une carte magique, une carte fusion si je prends un peu l'exemple du jeu de cartes Yu-Gi-Oh ou les cartes terrains dans Magic et cetera et cetera. 

On peut donc refaire ce genre de choses. 

On va travailler du coup qu'avec des classes concrètes.

On enlève tout dans la classe fille y compris le constructeur et en ayant une méthode abstraite, on va forcer la redéfinition de cette méthode dans la classe fille. 

C'est à dire que là pour le coup si je fais juste ça, est-ce qu'il me affichera normalement une erreur  ?

Normalement oui et voilà.

Notez qu'on n'a pas une méthode abstraite tu n'as pas été redéfini donc on est obligé de le faire, alors soit on remet la même visibilité protected function hello().
```php
	abstract class Mere
	{	
		abstract protected function hello();
	}

	class Fille extends Mere
	{	
>		protected function hello()
		{
			
		}
	}
```
Alors il faut soit mettre la même 'protected', soit vous mettez une visibilité un peu moins stricte donc en général 'public'.
```php
	abstract class Mere
	{	
		abstract protected function hello();
	}

	class Fille extends Mere
	{	
>		public function hello()
		{
			
		}
	}
```
Et ensuite on dit comment la fille va dire Hello tout simplement.

Et au niveau de l'instanciation, `$obj = new Mere();`
```php
<?php

abstract class Mere
{	
	abstract protected function hello();
}

class Fille extends Mere
{	
	public function hello()
	{
		echo 'Hello, je suis la Fille';
	}
}

$obj = new Mere(); 
```
Et donc évidemment si je fais ça, je ne peux pas le faire je n'ai pas le droit.
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Fatal error: Uncaught Error: Cannot instantiate abstract class Mere in C:\...\index.php:587 Stack trace: #0 {main} thrown in C:\...\index.php on line 587
```
Évidemment je ne peux pas, je n'ai pas le droit 'Cannot instatiate abstract class Mere'. On n'a pas le droit de instancier une classe abstraite mais par contre je peux faire une classe fille.
```php
abstract class Mere
{	
	abstract protected function hello();
}

class Fille extends Mere
{	
	public function hello()
	{
		echo 'Hello, je suis la Fille';
	}
}

$obj = new Fille(); 
```
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
```
Là il n'y a pas de problème, et je peux appeler évidemment sa méthode hello() qui était pour le coup très vague très abstraite au niveau de la classe mère parce qu'on ne savait pas ce qu'elle faisait par contre pour la fille on sait comment elle fait hello().
```php
<?php

abstract class Mere
{	
	abstract protected function hello();
}

class Fille extends Mere
{	
	public function hello()
	{
		echo 'Hello, je suis la Fille';
	}
}

$obj = new Fille();
$obj->hello();
```
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Hello, je suis la Fille
```
La fille dit ça quand elle utilise la méthode hello().

Voilà comment ça fonctionne pour ce principe d'abstraction. 

Ce n'est pas forcément évident à comprendre et pourtant ça a toute son importance c'est-à-dire que vous imaginez plusieurs entités dans une application et là pour le coup Carte pourrait être une classe abstraite et ici Gestionnaire pareil.

![schéma_02.JPG](schéma_02.JPG)
<!--
	+---------------+							+---------------+
	|Gestionnaire	|							|Carte			|
	+---------------+							+---------------+
	|init()			|							|id				|
	|launch()		|							|nom			|
	|update()		|							|description	|
	|free()			|							|				|
	+---------------+							+---------------+
			^											^
			|											|
			+-------------------+						|
			|					|						|
	+---------------+ +-----------------+		+---------------+
	|GestionnaireSon| |GestionnaireImage|		|CartePiege		|
	+---------------+ +-----------------+		+---------------+
	|mute()			| |refresh()		|		|effet			|
	|pause()		| |rotate()			|		|dureeEffet		|
	|next()			| |zoomIn()			|		|				|
	|back()			| |zoomOut()		|		|				|
	+---------------+ +-----------------+		+---------------+
-->
Rappelez-vous dans la vidéo précédente je vous avais dit que le gestionnaire de base, c'est un gestionnaire de quoi ? On ne sait pas. Comment il démarre ? On ne sait pas. Comment il se met à jour? On ne sait pas. 

Comme on ne sais pas quoi ce qu'il gère, Eh bien on ne voit pas trop comment il peut fonctionner. 

C'est comme si quelqu'un vous disait, t'as quoi comme voiture ? et qu'il vous répond qu'il a une voiture, ça ne va pas beaucoup vous aider. 

Quelqu'un qui a un problème informatique et vous lui demander ce qu'il a comme ordinateur ou comme téléphone, et il ne vous dit pas le modèle, il ne vous dit pas la marque, bref il ne vous dit pas ce qu'il a donc ce n'est pas assez concret c'est trop abstrait. 

Et comme c'est trop abstrait, c'est trop vague et on n'est pas capable d'avoir des choses concrètes. 

Imaginez un petit peu ce principe, ça gestionnaire ce serait une classe abstraite c'est à dire qu'on ne va jamais créer l'objet de cette classe, on ne va jamais évidemment appeler une méthode de cette classe et on va tout spécialiser redéfinir dans les classes filles et créer des classes concrètes qui elles pour le coup veulent dire quelque chose.

Un gestionnaire d'image, on sait ce qu'il va gérer. 

Un gestionnaire de son également. 

Une carte piège on sait ce que c'est alors qu'une simple carte c'est un peu vague, un peu abstrait on ne sait pas trop. 

C'est simplement ça le principe d'abstraction de classe en PHP qui est un principe encore une fois lié à la programmation orientée objet qu'on ne retrouve pas forcément dans tous les langages de programmation qui utilise le paradigme objet et c'est donc pour ça que je le dis mais ça fait partie des notions de la POO. 

D'accord ce n'est pas lié à PHP, vous pouvez faire de l'abstraction de classe en python, en c++ ou en Java, ça fonctionne évidemment dans ses autres langages de programmation donc c'est à savoir. 

C'est un concept très important. 

C'est juste ça à savoir au niveau du principe, ce que vous avez une classe abstraite qui a des méthodes abstraites que vous allez définir de cette manière.
```php
	abstract class Mere
	{	
>		abstract protected function hello();
	}

	class Fille extends Mere
	{	
		public function hello()
		{
			echo 'Hello, je suis la Fille';
		}
	}

	$obj = new Fille();
	$obj->hello();
```
La classe abstraite que vous allez définir de cette manière et ensuite dans les classes Fille qui étendent cette classe abstraite, vous redéfinissez obligatoirement les méthodes abstraites. 

C'est obligatoire là pour le coup, vous n'avez pas le choix et vous ne pouvez pas vous dire que je ne le fais pas et qu'on utilisera la méthode de la classe mère parce qu'elle n'a aucune implémentation donc elle ne sait rien faire. 

Vous êtes obligé de redéfinir la chose donc ça c'est important. 

Maintenant prenons l'exemple nous aurions par exemple parler() dans lequel on passerait un argument $message et vous voyez que je reprends l'exemple en faisant une implémentation dans la classe fille.
```php
	abstract class Mere
	{	
>		abstract protected function parler($message);
	}

	class Fille extends Mere
	{	
>		public function parler($message)
		{
			echo 'Hello, je suis la Fille';
		}
	}

	$obj = new Fille();
>	$obj->parler();
```
Et en fait ce qu'elle dirait tout simplement c'est le message. 

Et du coup je pourrais à chaque fois dire autre chose.
```php
<?php

abstract class Mere
{	
	abstract protected function parler($message);
}

class Fille extends Mere
{	
	public function parler($message)
	{
		echo $message.'<br>';
	}
}

$obj = new Fille();
$obj->parler('Bonjour');
$obj->parler('Comment vas-tu ?');

?>
```
J'actualise et voilà comment ça se passe.
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Bonjour
	Comment vas-tu ?
```
Voilà comment ça se passe okay. 

Ça c'est une possibilité c'est-à-dire qu'on a fait encore une fois notre méthode abstraite parler() dans la classe mère. 

On l'a ensuite redéfini dans la classe fille, et on est capable d'utiliser la classe fille sans problème. 

La classe fille le fait de manière concrète, elle parle de manière concrète. Là où la classe mère parlerait mais on sait pas trop comment parce que c'est une classe un peu trop vague. 

Ce que l'on peut faire aussi au niveau de l'abstraction ce qui est bien un savoir, c'est que vous pouvez dans la redéfinition sachant que vous êtes obligé d'avoir la même signature donc le même nom de méthode 'parler' avec les mêmes arguments `$message` mais vous pouvez également passer des arguments optionnels. 

C'est donc obligatoire, vous ne pouvez pas par exemple juste faire ceci.
```php
<?php

abstract class Mere
{	
	abstract protected function parler($message);
}

class Fille extends Mere
{	
	public function parler($message, $param)
	{
		echo $message.'<br>';
	}
}

$obj = new Fille();
$obj->parler('Bonjour', 8);
$obj->parler('Comment vas-tu ?', 14);

?>
```
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Fatal error: Declaration of Fille::parler($message, $param) must be compatible with Mere::parler($message) in C:\...\index.php on line 773
```
Là vous aurez une erreur, on va vous dire simplement que ça ne correspond pas à la signature que ce n'est pas compatible avec la méthode parler($message) que vous avez ici. 

Il faut obligatoirement un paramètre optionnel est un paramètre optionnel vous l'avez déjà vu dans la vidéo sur les fonctions si vous vous en souvenez, il suffit de mettre un = et une valeur par défaut. 

Et là pas de problème ça fonctionnera. 
```php
<?php

abstract class Mere
{	
	abstract protected function parler($message);
}

class Fille extends Mere
{	
	public function parler($message, $param = 10)
	{
		echo $message.'<br>';
	}
}

$obj = new Fille();
$obj->parler('Bonjour', 8);
$obj->parler('Comment vas-tu ?', 14);

?>
```
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Bonjour
	Comment vas-tu ?
```
Et là il n'y aura pas d'erreur. 

Alors qu'est-ce que ça va changer ? 

Alors admettons voici un exemple pas du tout intéressant mais ce n'est pas grave, je vais mettre un message puis un espace et s'amuser à afficher le paramètre.
```php
<?php

abstract class Mere
{	
	abstract protected function parler($message);
}

class Fille extends Mere
{	
	public function parler($message, $param = 10)
	{
		echo $message.' | '.$param.'<br>';
	}
}

$obj = new Fille();
$obj->parler('Bonjour', 8);
$obj->parler('Comment vas-tu ?', 14);

?>
```
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Bonjour | 8
	Comment vas-tu ? | 14
```
Et là vous voyez que la valeur passe.

Si je n'indique rien évidemment ça prendra la valeur par défaut c'est pour ça qu'on parle vraiment de paramètres optionnels, c'est obligatoire vous êtes obligé de mettre un = quelque chose, une valeur par défaut, un texte, une chaîne, un chiffre où ce genre de chose mais c'est obligatoire.
```php
<?php

abstract class Mere
{	
	abstract protected function parler($message);
}

class Fille extends Mere
{	
	public function parler($message, $param = 10)
	{
		echo $message.' | '.$param.'<br>';
	}
}

$obj = new Fille();
$obj->parler('Bonjour');
$obj->parler('Comment vas-tu ?');

?>
```
```txt
	http://localhost/PHP/cours/025_classe_abstraite/
	Bonjour | 10
	Comment vas-tu ? | 10
```
C'est obligatoire il faut vraiment un paramètre optionnel sinon vous aurez l'erreur de compatibilité par rapport à la redéfinition de la méthode. 

Et du coup je pense aux avoir dit tout ce qu'il y avait à savoir, tout ce qui était important au niveau de cette abstraction de classe en PHP en tout cas. 

Il n'y a pas grand chose à retenir, vous voyez que c'est assez simple, juste savoir qu'on a encore une fois une classe abstraite c'est à dire la classe mère avec le mot clé abstract. 

On définit aussi les méthodes avec le mot-clé abstract aussi, et on les met éventuellement en protected et ensuite dans les classes Fille on les redéfini en public et puis voilà on implémente tout simplement la méthode. 

Et chaque classe fille différente aura sa méthode à elle de parler() par exemple et on pourra l'utiliser simplement comme vous l'avez fait jusqu'à présent avec ce langage PHP. 

Et on s'arrêtera là pour cette petite vidéo qui était un petit peu plus courte que la vidéo précédente il me semble mais il y avait quand même pas mal de choses à indiquer pour que vous puissiez le comprendre pour la suite.

On continue comme ça d'avancer sur cette programmation orientée objet en PHP.

Comme vous voyez il y a beaucoup de notions à connaître mais qui vont vous aider pas mal dans d'autres langages d'ailleurs et qui vont vous permettre de programmer autrement comme ça vous pourrez associer ça avec la programmation dites procédurale en PHP. 

Et vous obtiendrez des applications riches et vraiment très robuste avec ce langage là. 

Si besoin n'hésitez pas comme d'habitude à me laisser des commentaires, poser des questions, me contacter si vous avez besoin d'aide ou que vous voulez des réponses aux problèmes que vous pouvez rencontrer durant cette formation. 

Toujours pareil même si je ne le dis pas tout le temps partager un maximum des vidéos si vous êtes sur les réseaux sociaux n'hésitez pas à partager et à faire connaître ça un maximum de gens pour que ça puisse profiter à tout le monde pour des personnes qui voudraient aussi se lancer dans la programmation. 

Et moi je vous dis à bientôt pour la prochaine vidéo. 

On se retrouvera pour la suite. 

On devrait commencer à aborder pas mal de choses, on va parler d'interface, on va parler de traits, on va parler d'exception, bref il nous reste encore quelques petites vidéos et après on devrait passer justement à tout ce qui est gestion des bases de données avec PHP. 

Ça devrait être intéressant aussi je pense. 

À bientôt tout le monde pour la prochaine vidéo en PHP