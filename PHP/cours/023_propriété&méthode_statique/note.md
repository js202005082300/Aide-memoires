# [23. Propriété et méthode statique](https://www.youtube.com/watch?v=Wd4FDAR9nHg)
03-12-20

Bonjour à tous et bienvenue sur cette formation au langage PHP. 

C'est la 23e séance et nous allons attaquer une petite notion assez simple et assez courte qui ne va pas prendre beaucoup de temps et qui va être assez rapide à voir. 

Nous allons parler des méthodes et des propriétés statiques. 
```php
<?php

class Vehicle
{
	private $_name;
	private $_speed;
	
	public function __construct(string $name, int $speed)
	{
		$this->_name = $name;
		$this->_speed = $speed;
	}
	
	public function move()
	{
		echo 'Le vehicule '.$this->_name.' se deplace a '.$this->_speed.'km/h';
	}
}

//Nous sommes en dehors de la classe
$mycar = new Vehicle('XC450', 650);
$mycar->move();
```
Alors jusqu'à présent si on reprend un petit peu un code comme on avait précédemment, on avait vu que comme pour créer une classe, on avait un ensemble de propriétés qui sont ces variables qui la définissent et un ensemble de méthodes qui permettent de définir les services c'est-à-dire ce qu'elle est capable de faire. 

On instanciait une classe pour pouvoir créer un objet d'accord que l'on stockait du coup dans une variable et à partir de là nous pouvions utiliser ces méthodes.

On avait donc fait notre petit véhicule $mycar, on lui avait spécifié un nom et une vitesse, une petite méthode move() pour indiquer le nom du véhicule et à quelle vitesse il se déplace. 

Au niveau affichage, ça nous donnait donc quelque chose de ce genre là.
```txt
	http://localhost/PHP/cours/023_propri%c3%a9t%c3%a9&m%c3%a9thode_statique/
	Le vehicule XC450 se deplace a 650km/h
```
Ça c'est donc une possibilité. 

Vous avez vu comme je vous l'avais dit, on a une classe, on instancie cette classe pour pouvoir créer des objets et depuis ces objets on accède aux attributs. 

On peut éventuellement les modifier avec les accesseurs comme on les a vu dans la vidéo précédente. 

Et faire appel aux méthodes pour tout simplement utiliser les services de la classe. 

Il y a une autre manière de faire il son devoir passer par le instanciation d'une classe donc sans devoir passer par des objets. 

Admettons qu'un jour vous ayez besoin de faire une petite classe de service, alors une classe de service dans le sens une classe utilitaire par exemple. 

Ça peut être une classe pour la connexion à une base de données, une classe pour l'enregistrement dans un fichier spécifiques bref quelque chose qui serait en fait tout simplement une classe faites pour juste avoir quelques petites fonctions d'accord sans forcément avoir besoin d'une entité. 

On peut pour cela définir des propriétés statiques et ça on va le voir rapidement mais surtout des méthodes statiques et via ce système là nous n'aurons pas besoin de créer d'objet donc nous n'aurons pas besoin d'instancier cette classe.

Alors comment est-ce qu'on va faire ? on va regarder tout simplement plutôt que de prendre ce code on va reprendre un code complet merci et on va voir un petit peu avec un exemple Database. On va simuler un système comme ça c'est-à-dire une classe pour la base de données.
```php
	class Database
	{
		
	}
```
On ne va pas lui définir de constructeur parce qu'on ne va pas créer d'objet. On ne pourra pas instancier cette classe, on instancie pas une classe qui a justement ici des éléments statiques donc ça n'a absolument aucun intérêt de faire un constructeur. 

On va faire simplement une méthode statique en incluant le mot-clé static juste après la visibilité de la méthode donc public et puis static.
```php
	class Database
	{
		public static
	}
```
function et par exemple on aurait connect() qui serait admettons notre connexion à la base de données.
```php
	class Database
	{
		public static function connect()
		{
			
		}
	}
```
On ne va pas vraiment se connecter à une base de données parce qu'on n'en est pas encore là mais on va simplement faire ça, echo 'je me connect…' voilà une simple méthode qui se connecte.
```php
	class Database
	{
		public static function connect()
		{
			echo 'Je me connecte...';
		}
	}
```
À partir de là dès qu'on va vouloir à n'importe quel endroit de notre projet web, vouloir se connecter à la base de données donc en utilisant notre petite classe d'utilitaire qui permet de le faire, qui permet de faire la liaison; au lieu de créer un objet à chaque fois parce qu'on n'est pas forcément obligé de créer un objet à chaque fois pour se connecter à la base de données. On donc peut avoir simplement l'utilisation de la méthode directement ou éventuellement n'avoir qu'une seule instance et de travailler toujours avec cette instance là pour éviter de surcharger le nombre d'objets qui se connecterait à la base de données et d'avoir 15000 connexions simultanées alors qu'on pourrait utiliser la même liaison pour faire toutes ces connexions. 

Là donc pour rester sur du statique donc l'utilisation, l'appel à une méthode statique dans une classe au PHP, on va le faire tout simplement comme ça. Je rappelle déjà qu'on est en dehors de la classe et à partir de là au lieu d'indiquer une variable dans lequel nous allons créer une instance de la classe c'est-à-dire un nouvel objet, on va directement spécifier le nom de la classe Database:: et un opérateur.

Ça :: on en parlera c'est un opérateur de résolution, de portée dont on parlera un petit peu plus tard. Peut être dans une vidéo tutoriel en annexe. Je ne pense pas que je le mettrais dans le cours parce que ce n'est pas obligatoire à connaître parce que pour le reste vous allez l'utiliser assez simplement. 

Ainsi on spécifie cet opérateur là `::` donc avec 2 fois les `:` précédé du nom de la classe en question, Database et ensuite tout simplement le nom de la méthode que vous appelez, connect() d'accord il s'agit juste de ça.
```php
<?php

class Database
{
	public static function connect()
	{
		echo 'Je me connecte...';
	}
}

//En dehors de la classe
Database::connect();
```
Juste ça donc c'est très très simple à utiliser.
```txt
	http://localhost/PHP/cours/023_propri%c3%a9t%c3%a9&m%c3%a9thode_statique/
	Je me connecte...
```
Et là si j'actualise, ça nous s'appelle bien à la méthode statique sans avoir créé une instance de l'objet donc ici il n'y a pas du tout de objet qui a été créé.

On ne pourra donc pas utiliser par exemple la pseudo variable que vous connaissez bien qui est `$this`. 

`$this` existe quand il y a un objet, quand il gagne de classe qui a été instanciés parce que `$this` est une variable qui contient l'objet, l'instance en cours sur laquelle on est en train de travailler, avec laquelle on a éventuellement appeler une méthode. 

Par exemple avec la classe de tout à l'heure Vehicle, `$this` aurait tout simplement été l'objet que nous venons de créer qui appelait la méthode move(). 

Donc ça évidemment dans du statique ce n'est pas possible.
```php
	class Database
	{
		public static function connect()
		{
			echo 'Je me connecte...';
>			$this
		}
	}

	//En dehors de la classe
	Database::connect();
```
Dans du statique ce n'est pas possible, il n'y a eu aucune instanciation donc pas de pseudo variable `$this`. 

Pour éventuellement une propriété statique, ça va être aussi rapide également. 

On aurait par exemple public static et on va mettre un nom qui n'est pas forcément correct mais peu importe ... Admettons qu'ici on veut enregistrer le moteur de notre base de données utilisé donc le SGBD utilisé et on dirait par exemple 'MySQL' par exemple voilà ce genre de chose. 
```php
	class Database
	{
		public static $_sgbd = 'MySQL';
		
		public static function connect()
		{
			echo 'Je me connecte...';
		}
	}

	//En dehors de la classe
	Database::connect();
```
Pour accéder à une propriété statique et attention elle est public, je rappelle que si elle était privée on ne pourrait pas y accéder donc toujours pareil. 

On écrit le nom de la classe Database, l'opérateur spécial de résolution portée `::` et ensuite on appelle la variable tout simplement `$_sgbd;` et comme on veut l'afficher, on fait un petit echo.
```php
class Database
{
	public static $_sgbd = 'MySQL';
	
	public static function connect()
	{
		echo 'Je me connecte...';
	}
}

//En dehors de la classe
echo Database::$_sgbd;
```
```txt
	http://localhost/PHP/cours/023_propri%c3%a9t%c3%a9&m%c3%a9thode_statique/
	MySQL
```
Et là nous avons affiché l'information. 

Voilà comment ça fonctionne. 

Pour le moment vous n'en voyez peut-être pas l'utilité mais dans les projets que vous aurez à faire plus tard quand vous allez arriver sur des choses conséquentes, vous verrez qu'il y a des moments où vous aurez des classes où il n'y a pas beaucoup de méthodes, pas beaucoup d'informations et du coup ça ne vaudra pas le coup d'instancier des objets.

D'accord il y aura des cas où ce ne sera absolument pas utile de le faire puisque là vous voulez absolument utiliser les méthodes de cette classe.

C'est un peu comme si vous faisiez pas de programmation orientée objet mais que vous aviez un simple fichier PHP dans lequel vous mettiez plein de fonctions genre une function A et une function B et cetera et que vous voulez les utiliser. 

L'avantage avec la programmation orientée objet, c'est que vous pouvez rassembler tout ça dans une classe qui définit un petit peu le thème, la catégorie, le domaine des différentes méthodes. 

Ici Database correspond aux bases de données et du coup on peut mettre toutes nos méthodes liées aux bases de données à l'intérieur. 

Et sans avoir besoin d'avoir encore une fois besoin de créer des instances, d'avoir des objets, on appelle tout simplement ces méthodes de manière statique en spécifiant toujours le mot-clé static que ce soit dans les propriétés pour pouvoir accéder aux propriétés, ou que ce soit sur les méthodes dans la définition des méthodes pour pouvoir appeler ces différentes méthodes. 

Voilà tout ce qu'il y avait à savoir en tout cas concernant tout ce qui est en fait static propres aux propriétés et aux méthodes en programmation objet en PHP. 

Ce n'est vraiment pas plus compliqué que ça. 

Vous aurez à un moment donné l'occasion de l'utiliser soit dans vos projets soit de toute manière sur la playlist exercice en PHP. 

Comme vous savez les playlists d'exercices suivent le cours, suivent les notions vues en cours avec une difficulté croissante et qui permettent de revoir un petit peu toutes les notions qui sont abordées sur le cours. 

Vous aurez certainement et je vous proposerai parce que ce n'est pas le moment que je fais cette vidéo mais vous aurez sûrement un exercice qui fera appel à l'utilisation de méthodes ou de propriétés statiques. 

Je vous laisse avec cette petite vidéo. 

On se retrouvera la prochaine fois pour une nouvelle notion qui pour le coup sera un petit peu plus longue parce que nous allons parler d'héritage. 

L'héritage c'est vraiment une des notions les plus importantes en objet, j'espère que ce sera suffisamment clair pour vous en tout cas. 

Si vous avez des questions n'hésitez pas et moi je vous laisse pour la prochaine vidéo sur cette formation au langage PHP. 

À bientôt tout le monde