# [20. Classes et objets](https://www.youtube.com/watch?v=xUT49vXBcuc)
01-12-20

Bonjour c'est un plaisir de vous retrouver sur cette formation en langage PHP. 

Avec cette séance 20 nous allons attaquer les premières notions de ce nouveau paradigme que vous allez aborder avec ce langage pour le web. 

Et nous allons commencer par parler des classes et des objets, j'ai mis ces 2 termes là dans le titre parce que ce sont 2 choses importantes pour démarrer. 

Et nous allons voir comment ça fonctionne. 

Jusqu'à présent tout ce que vous avez vu en procédural, c'était simplement la définition de plusieurs fonctions. 

Vous aviez vu que vous pouviez factoriser c'est-à-dire rassembler du code répété dans votre programme au sein de fonction et qu'ensuite il suffisait simplement de faire des appels à ses fonctions quand vous en avez besoin pour faire tout un tas de choses donc ça c'est une manière de procéder. 

C'est alors un des paradigmes que propose le PHP. 

Comme je l'ai dit j'ai fait une vidéo sur ma chaîne qui parle des différents paradigmes en programmation et si c'est un sujet qui vous intéresse, vous pouvez les retrouver dans la playlist aide générale. 

Alors pour les autres on va aborder cela en PHP et on va voir un petit peu comment ça fonctionne, et déjà on va définir très simplement parce que je pars toujours du principe que mon cours s'adresse à des débutants chaque type de formation vous n'en ayez jamais vu d'autres avant. 

Admettons par exemple que PHP est votre premier langage de programmation donc c'est vraiment accessible pour tout le monde et ceux qui connaissent évidemment déjà les notions, vous avancerez tout simplement plus vite que les autres et ce ne sera pas gênant pour personne. 

Alors une classe pour faire très simple, pour donner un exemple très parlant et illustré au minimum parce que ça ne sert à rien de se compliquer dans les schémas ou autre, vous pouvez représenter ça par un ensemble d'entités c'est-à-dire qu'une classe va définir en fait une entité au sein de votre application.

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
Dans un jeu vidéo ça pourrait être par exemple un guerrier, le fameux guerrier est donc le personnage qui serait une des entités de notre jeu vidéo comme il pourrait y avoir une entité pour les monstres, ensuite une autre classe pour les donjons, une classe pour les objets de votre inventaire, les armes et ce genre de choses. 

Dans d'autres systèmes, dans un système mobilier, on pourrait avoir une classe pour gérer nos habitations, gérer des logements. 

Dans un hôpital on pourrait par exemple avoir de quoi gérer des classes différentes pour ceux qui définit les médecins, pour ce qui définiraient les patients, une classe pour définir les établissements, une classe pour définir les services et cetera et cetera. 

Alors j'ai mis également un exemple pour le véhicule qui pareil définit une entité qui représente ce fameux véhicule.

Alors voilà comment va fonctionner la programmation objet.

On va avoir une sorte de boîte, on peut dire ça c'est à dire que vous avez une représentation de tout un tas de choses définir qui sont définis à l'intérieur c'est-à-dire qu'il y a un premier développeur qui a créé cette classe d'accord. 

Il a donc écrit du code et il a produit des fonctions donc des fonctions de classe qu'on appelle des méthodes, et on verra cela dans une prochaine vidéo. Je pense que ce sera pour la séance. 

Et les informations de cette classe qui sont en fait des simples variables comme vous savez déjà les faire mais en objet on appelle cela des attributs ou des propriétés dans le cadre de PHP, l'un ou l'autre c'est la même chose en PHP. 

Voilà je le dis parce que dans certains d'autres langages ce n'est pas forcément le cas.

Voilà on a donc des méthodes et des attributs mais ce qu'il faut comprendre grosso modo, encore une fois la classe c'est l'entité représenté, c'est un petit peu le modèle qu'elle doit suivre. 

Elles ont fait des méthodes qui sont en fait ces services c'est-à-dire ce qu'elle propose, ce qu'elle nous permet de faire et elle a ses attributs c'est-à-dire ses spécificités en fait. 

On voit tout de suite qu'un guerrier ses spécificités c'est les piecesOr qu'il possède et des pointsDeVie.

Qu'est-ce qu'il est capable de faire ce guerrier là si on s'en tient au schéma qu'on a représenté, il est capable de seDeplacer() c'est un des premiers services qu'il offre il est capable de attaquer(). 

Alors s'il y avait vraiment que ça dans cette classe guerrier, on se rendrait compte qu'il manque déjà pas mal de choses. On pourrait voir qu'il ne peut pas se défendre, il ne peut pas se soigner, il ne sait pas faire grand chose. 

Là par exemple le véhicule, il ne peut pas démarrer, il ne peut pas être stoppé, enfin voilà il manquerait évidemment des choses mais pour simplifier le schéma j'ai évidemment mis que quelques méthodes, quelques attributs d'exemple pour comprendre. 

Voilà Comment ça va se passer. 

On a un premier développeur qui va créer cette classe Guerrier et vous dans certains cas vous allez être l'utilisateur parce qu'on pense souvent que l'utilisateur c'est celui qui va utiliser votre site web, votre application web mais ce n'est pas dans ce cas-là que je parle de l'utilisateur mais je parle de l'utilisateur de la classe c'est-à-dire que vous en tant que développeur, vous allez utiliser par moment et ça va m'arriver très souvent d'utiliser des classes créées par d'autres développeurs. Et donc vous serez un utilisateur de sa classe. 

Vous verrez qu'on fera plus tard quand on va gérer les bases de données, vous le ferez peut-être quand vous gérerez tout un tas d'autres choses. 

Vous allez récupérer des classes déjà existantes et vous n'aurez pas besoin d'aller voir dans le code de cette classe, comment elles ont été conçues mais tout ce que vous aurez besoin de savoir au niveau de la documentation de la classe c'est ça c'est-à-dire les services qu'elle propose donc ses méthodes et éventuellement les spécificités donc ce qui la définit donc c'est à dire les attributs. 

À partir de là vous pourrez utiliser la classe véhicule, là vous pourrez utiliser le guerrier et là vous pourrez même utiliser l'habitation. 

Voilà grosso modo comment ça se définit d'accord. 

C'est pour ça que j'insiste bien parce que souvent on pense que l'utilisateur, on pense tout le temps à l'utilisateur final celui qui se sert du site web ou de l'application mais nous on parle ici de l'utilisateur dans le cas du développeur. 

Vous avez celui qui va créer la classe et vous avez celui qui va s'en servir pour d'autres développements. 

Vous ici vous aurez les 2 rôles, un certain moment vous avez utilisé les classes qui existent déjà au PHP qui ont été faites par plein d'autres développeurs donc vous allez vous servir pour faire vos propres développements, vos propres sites web et cetera.

Et vous allez vivement créer vos propres classes à vous complètement qui seront peut être basé sur aucune autre classe, qui partiront de rien pour définir vos propres entités.

Voilà en tout cas Comment ça va se passer en PHP. 

Voilà ici je vous expliqué grosso modo même si on prend le temps et que ça rallonge un petit peu la vidéo mais ce n'est pas grave parce qu'il faut encore une fois bien prendre le temps de tout détailler. 

On va voir comment en PHP nous définissons, comment nous allons créer une classe. 

Nous sommes donc ici le développeur original vraiment celui qui est à l'origine de tout c'est-à-dire ici ou nous allons créer une classe qui ne part rien. 

On ne va pas utiliser une autre classe existantes c'est-à-dire qu'on va créer la nôtre à nous. 

Pour cela nous utilisons le mot-clé class et nous allons donner un nom à cette classe, le nommage c'est comme pour les variables ou comme beaucoup de choses c'est-à-dire pas de caractères accentués, pas de caractères spéciaux pas d'espace mais par contre la petite règle qui est importante à connaître c'est de mettre une majuscule au début du nom de la classe et renouveler la majuscule à chaque fois que vous avez un nouveau mot (camelCase) par exemple MyClass que vous écrirez comme ça.
```php
	class MyClass
```
Vous voyez combien une majuscule à chaque début de nouveaux mots, c'est beaucoup plus lisible, très simple et surtout ça suit un petit peu les normes de PHP. 

Déjà que PHP à des normes qui diffèrent selon qu'on programme en procédural ou en objet qui peut être assez déroutant parce que c'est un langage qui a énormément évolué et qui du coup a changé pas mal de direction et du coup on retrouve des syntaxes parfois un petit peu bizarre ce qui peut être un peu déroutant, ce qui peut gêner certains parce que des fois on écrit comme çi et que des fois on voit que c'est écrit comme ça. 

Vous prenez donc cette habitude là, une majuscule au début du nom de la classe il a chaque nouveau mot si c'est par exemple une classe qui possède plusieurs mots, vous mettez une majuscule à chaque fois.

Nous on va donc reprendre l'exemple de tout à l'heure, voyez l'exemple ici du véhicule sur le schéma.
```txt
	+-------------------+
	| Vehicule			|
	| 					|
	| - tournerDroite()	|
	| - tournerGauche()	|
	| - freiner()		|
	| 					|
	| nombrePlaces		|
	| typeCarurant		|
	+-------------------+
```
On va par contre le noter ici en anglais Vehicule ce qui est mon petit conseil c'est-à-dire qu'il faut mieux privilégier des noms anglais pour vos variables, vos fonctions, vos méthodes, vos classes et cetera. 

Comme le langage est déjà en anglais ça évitera de mélanger les langues, après bien sûr pour tout ce qui est texte affichage, là vous mettez la langue que vous voulez. 

Mais le petit conseil là comme je le dis assez souvent, c'est d'écrire le code en anglais comme ça vous ne mélangez pas les choses ça c'est beaucoup plus unifié, et après ça me dérange pas d'avoir du code en français si vous êtes plus à l'aise comme ça, n'hésitez pas à le faire. 

Alors là on fait ça et on va définir notre classe et ce sera terminé.
```php
	class Vehicle
	{
		
	}
```
Voilà on fait ça on a défini notre classe et c'est terminé. 

La classe est définie.

Alors là évidemment elle ne possède rien, on n'a pas créé comme on verra plus tard des méthodes, on ne lui a pas défini ses spécificités c'est-à-dire ses attributs mais on verra ça de toute façon dans la prochaine séance donc on ne va pas l'aborder tout de suite. 

On pourrait instancier c'est-à-dire créer un objet de cette classe donc le terme objet intervient à ce moment-là. 

Alors la classe c'est d'abord le modèle qui nous dit comment est composé un véhicule.
```php
	+-------------------+
	| Vehicule			|
	| 					|
	| - tournerDroite()	|
	| - tournerGauche()	|
	| - freiner()		|
	| 					|
	| nombrePlaces		|
	| typeCarurant		|
	+-------------------+
```
Sauf qu'ici nous nous avons fait un véhicule très très simple pour le coup, parce qu'elle n'a rien de précis. 

Ensuite on va dire tu vas créer une version concrète de ce véhicule qu'on va stocker en fait dans une variable qui sera, stockera, représenteras notre premier objet. 

Je peux par exemple l'appeler `$obj1` avec lequel je vais utiliser le mot clé new pour dire une nouvelle instance de ma classe donc avec le nom de la classe, on suit le même principe. 

Comme pour le moment il n'y a rien comme information, on va juste mettre des parenthèses vide et terminer par un ; 
```php
<?php

class Vehicle
{
	
}

$obj1 = new Vehicle();
```
Et là je peux évidemment essayer de vous montrer quelque chose mais vous ne verrez rien d'afficher puisqu'on a fait absolument rien.
```txt
	http://localhost/PHP/cours/020_classes&objets/
```
En réalité, PHP qu'est-ce qu'il a fait ?

Il a construit notre objet, ici il a construit une instance en créant un objet lui-même. 

Alors si je fais `$obj2` comme ceci.
```php
<?php

class Vehicle
{
	
}

$obj1 = new Vehicle();
$obj2 = new Vehicle();
```
```txt
	http://localhost/PHP/cours/020_classes&objets/
```
Voilà je crée un autre objet d'accord. 

Ils auront été construits sur le même schéma `new Vehicle();`, sur le même moule, on peut dire sur le même modèle mais ils seront évidemment différents.

L'objet qui est ici `$obj1` dans la mémoire de l'ordinateur n'est pas du tout au même endroit que cet objet là `$obj2`. Ils sont vraiment complètement distincts. 

C'est comme si on avait 2 êtres humains, à moins que ce soit des clones et c'est un cas particulier mais on n'est pas là pour parler de ça. 

Voilà vous créez 2 êtres humains différents donc ces 2 personnes à part complètement distinctes et rien à voir l'une avec l'autre, là c'est pareil. 

Chaque objet est évidemment indépendant de l'autre, indépendamment l'un de l'autre. 

Vous pourrez faire un truc avec le premier objet comme véhicule, `$obj1` par exemple le faire démarrer. 

Et celui là `$obj2`, on pourrait par exemple le faire tourner à gauche, ou bref accéder à une information de cet objet. 

Voyez qu'on aura des choses différentes. 

Alors là c'est bien beau mais pour l'instant il fait pas grand chose avec ce type de programmation pour le moment.

On a créé et défini une classe qui ne fait rien, on a instancier cette classe pour pouvoir former un objet.

Une instance de classe donc un objet mais on a rien du tout. 

Pour cela il va falloir définir ce qu'on appelle un constructeur. 

Le constructeur c'est simplement une fonction dans une classe qui possède un en particulier qui est construct qui va dire comment tu dois construire, comment tu dois créer un objet de classe Vehicle pour le coup.

Pour ça, vous allez noter et vous n'avez pas forcément besoin de comprendre ce que j'écris là parce que ce sont des choses que nous allons voir par la suite. 

D'abord le mot clé public, on expliquera pourquoi il y a un mot clé public ne vous inquiétez pas on verra ça dans la prochaine séance je pense. 
```php
	class Vehicle
	{
		public ...
	}

	$obj1 = new Vehicle();
```
On souhaite on écrit ça comme une fonction comme on le faisait en procédural, function et ensuite on met un nom en particulier précédé de 2 underscores, construct en minuscule et des parenthèses parce qu'on ne va rien mettre comme information. 
```php
	class Vehicle
	{
		public function __construct()
		{
			...
		}
	}

	$obj1 = new Vehicle();
```
On verra plus tard comment faire des attributs mais encore une fois ce sera pour la prochaine vidéo. 

On ouvre des accolades tout comme une fonction procédurale comme vous avez toujours eu l'habitude de le faire jusqu à présent et ici on peut laisser un petit message genre 'Je suis construit !' et on termine avec un ; 
```php
<?php

class Vehicle
{
	public function __construct()
	{
		echo 'Je suis construit !';
	}
}

$obj1 = new Vehicle();
```
Là si j'actualise, il va se passer quelque chose.
```txt
	http://localhost/PHP/cours/020_classes&objets/
	Je suis construit !
```
PHP accède à mon constructeur et fait simplement ce que le constructeur à défini. 

Notre constructeur qu'est-ce qu'il fait pour le coup ? Il affiche simplement un petit texte. 

Alors si je fais un nouvel objet comme on l'a déjà vu tout à l'heure, on va définir une autre instance donc on va rappeler une 2e fois le constructeur et cetera.
```php
<?php

class Vehicle
{
	public function __construct()
	{
		echo 'Je suis construit !';
	}
}

$obj1 = new Vehicle();
$obj2 = new Vehicle();
```
```txt
	http://localhost/PHP/cours/020_classes&objets/
	Je suis construit !Je suis construit !
```
Voilà ça c'est une chose à savoir, très importante même si ici le constructeur est très simple. 

Vous allez voir que c'est de là que tout va partir pour la définition et la création d'objets à partir d'une classe, à partir de leur modèle. 

À l'inverse des constructeurs, c'est bien d'en parler même si les gens qui parlent de PHP ont tendance à l'oublier ou qui tout simplement n'en ont jamais entendu parler.

Moi je vais peut-être quand même vous en parler parce que c'est important selon moi.

C'est que comme vous avez le constructeur, vous avez également un destructeur.

Alors par défaut lorsque tout à l'heure nous n'avons rien défini, c'est PHP qui a créé lui-même un constructeur c'est-à-dire il ne faut pas croire qu'il n'a rien créé du tout il l'a fait à notre place puisque toutes ces lignes-là n'était pas là.
```php
	class Vehicle
	{
>		public function __construct()
>		{
>			echo 'Je suis construit !';
>		}
	}

	$obj1 = new Vehicle();
	$obj2 = new Vehicle();
```
Comme toute ces lignes-là n'étaient pas là, PHP a construit lui-même un constructeur qui ne faisait rien mais il y a quand même eu construction de l'objet. 

Et à la fin de notre application quand on a terminé l'utilisation ici à la fin du programme les objets seront détruits.
```php
	class Vehicle
	{
		public function __construct()
		{
			echo 'Je suis construit !';
		}
	}

	$obj1 = new Vehicle();
	$obj2 = new Vehicle();<---
>
```
Les objets sont d'ailleurs détruits à l'inverse de l'ordre où ils ont été créés c'est à dire qu'ici comme j'ai créé `$obj1` et ensuite `$obj2`, c'est `$obj2` qui sera détruit en premier et `$obj1` qui sera détruit en dernier. 

D'accord ça se fait en fait un autre inverse. 

Cela en PHP, je vous le dis clairement contrairement à d'autres langages tout ce qui est destructeur donc destruction d'objets, on ne le gère pas nous-mêmes. 

D'accord on laisse PHP le faire parce que PHP est un langage beaucoup plus au niveau que par exemple que le c++.

Ça veut dire qu'il va pouvoir lui-même libérer de la mémoire proprement, faire la suppression des données et la libération de mémoire comme il faut. 

On n'a pas besoin de s'en occuper, c'est pas un langage aussi bas niveau que le c ou le c++ par exemple. 

On ne s'occupe donc pas trop de ça. 

Dans certains moments, on a peut être besoin de faire quelques manipulations précise lorsqu'on détruit un objet. 

Si donc un jour ça arrive, si un jour vous avez besoin de faire quelque chose au moment où on détruit l'objet, vous pouvez définir la méthode dont on parlera plus tard pour le destructeur et c'est la même chose que pour construct() sauf que c'est destruct() tout simplement.
```php
	class Vehicle
	{
		public function __construct()
		{
			echo 'Je suis construit !';
		}
		
		public function __destruct()
		{
			
		}
	}

	$obj1 = new Vehicle();
	$obj2 = new Vehicle();
```
Voyez qu'on met encore une fois 2 underscores soit 2 tirets du bas. 

Vous voyez que ce sont des méthodes qui ont un nom spécial, ça vous voyez que ce n'est pas à faire vous-même. 

Le double underscores, c'est pour utiliser les méthodes spéciales pour PHP. 

Et ici on peut mettre 'Je suis détruit !', j'actualise.
```php
<?php

class Vehicle
{
	public function __construct()
	{
		echo 'Je suis construit !';
	}
	
	public function __destruct()
	{
		echo 'Je suis détruit !';
	}
}

$obj1 = new Vehicle();
$obj2 = new Vehicle();
```
```txt
	http://localhost/PHP/cours/020_classes&objets/
	Je suis construit !Je suis construit !Je suis détruit !Je suis détruit !
```
Construit et construit, on voit que les appels au constructeur se font tout seul.

Alors là vous voyez que je n'ai pas fait une seule fois, je n'ai jamais fait ce genre de choses.
```php
	class Vehicle
	{
		public function __construct()
		{
			echo 'Je suis construit !';
		}
		
		public function __destruct()
		{
			echo 'Je suis détruit !';
		}
	}

>	$obj1 = __construct();
	$obj2 = new Vehicle();
```
C'est à vous de instancier vous-même avec le mot clé new suivi du nom de la classe Vehicle(), ensuite ça va tout seul, PHP va chercher tout seul la méthode __construct(). C'est pour ça qu'elle doit être faite c'est mieux parce qu'une classe son constructeur c'est bizarre, ça peut exister mais dans des cartes très très très très spécifiques, très restreint. 

Et le destructeur dans la plupart du temps, dans la majorité des cas, on en fait même pas. On ne le définit pas mais si vous aviez besoin de faire quelque chose en particulier seulement à l'instant où l'objet est détruit. 

Eh bien à partir du moment où va appeler le destructeur que vous avez défini, il fera ce que vous avez ordonné de faire dans cette méthode __destruct(). 

Sinon il va simplement libérer la mémoire, détruire les objets comme un grand et vous n'aurez pas besoin de vous en soucier. 

Alors ça c'est à vous de voir. 

Mais ça dans la majorité des cas vous n'en ferez jamais :
```php
	public function __destruct()
	{
		echo 'Je suis détruit !';
	}
```
D'accord c'est assez rare mais c'est quand même bien de le savoir. 

C'est bien de savoir que nous avons des constructeurs à définir ou on peut redéfinir donc réécrire le constructeur. 

Au lieu que euh son système de destruction par défaut qui est très simple pour le coup même s'il libère la mémoire et ça c'est beaucoup plus complexe en tout cas mais on peut définir d'autres choses, un comportement différent en définissant notre propre méthode pour le destructeur. 

Voilà comment ça se passe à ce niveau là. 

Alors ce qu'il faut savoir, c'est qu'au moment où on va créer cet objet :
```php
>	$obj1 = new Vehicle();
```
Ce qu'il faut savoir c'est qu'au moment où on va créer cet objet par exemple à un certain moment on va définir certaines choses pour le véhicule genre en aura … et je vais le noter là parce que ce n'est pas le sujet de la vidéo ... notre fameuse méthode pour tourner à droite.

Vous voyez, je ne l'écrit même pas et je met un nom comme ceci.
```php
	class Vehicle
	{
		public function __construct()
		{
			echo 'Je suis construit !';
		}

>		/* tournerADroite() */

	}

	$obj1 = new Vehicle();
	$obj2 = new Vehicle();
```
Vous vous dites peut-être qu'à un moment donné comment je vais dire à l'objet `$obj2` d'aller tourner à droite Parce que la classe elle faut bien qu'elle soit capable de savoir quel objet fait quoi. 

Pour cela plus tard on définira l'objet qui permet d'utiliser l'information c'est-à-dire que si on veut le faire avec `$obj2`, on utilisera notre variable c'est pour ça qu'on stockent les objets dans des variables pour pouvoir les identifier. 

Nous en termes de code on sait que `$obj1` correspond au premier objet et ça `$obj2` correspond au 2e comme ça on ne se mélange pas. 

Et au niveau de la classe en elle-même, elle va créer une pseudo variable automatiquement qui s'appelle `$this`, je vais vous le noter là.
```php
	class Vehicle
	{
		/*
>			$this
		*/		
		public function __construct()
		{
			echo 'Je suis construit !';
		}

		/* tournerADroite() */

	}

	$obj1 = new Vehicle();
	$obj2 = new Vehicle();
```
`$this` représente l'instance courante c'est à dire que si à un moment donné je dit `$obj2`, tu vas utiliser une des méthodes de ma classe comme on le verra dans la vidéo prochaine. Eh bien on va permettre, PHP en tout cas va pouvoir identifier à quel objet ça correspond en mémoire parce que pour lui `$obj1` et `$obj2` ne veulent rien dire, il ne sait pas ce que c'est. 

Grâce à `$this`, PHP est capable de savoir en mémoire, de retrouver en fait l'endroit de l'objet en question et du coup il saura à quel objet ça correspond grâce à cette variable spéciale qui est `$this`. 

Vous verrez qu'on va l'utiliser pas mal de fois au sein des classes.

Admettons que ici j'ai la fameuse méthode tournerADroite() par exemple.

Eh bien dès que j'ai mon constructeur, si admettons dans mon constructeur je dit directement je veux tourner à droite ce qui serait bizarre dans un cas concret mais c'est pour comprendre l'exemple … 

Eh bien on utilisera la fameuse variable `$this`, un symbole de flash qu'on verra dans la vidéo prochaine et on dira tout simplement tu vas tourner à droite.
```php
	class Vehicle
	{
		/*
>			$this
		*/		
		public function __construct()
		{
			echo 'Je suis construit !';
			$this->tournerADroite();
		}

		/* tournerADroite() */

	}

	$obj1 = new Vehicle();
	$obj2 = new Vehicle();
```
Et vous vous n'avez pas besoin de vous soucier de qu'est-ce qui va tourner à droite parce que ce sera automatiquement l'objet qui a été ici instancier donc celui qui est appelant. 

Ça veut dire que dès que je vais faire `$obj1`, qu'on va le construire, le `$this` correspondras à `$obj1` donc c'est lui qui va tourner à droite. 

Et pour le cas de `$obj2`, quand on va l'instancier, PHP va arriver au constructeur et il sera que `$this` correspond à `$obj2`.

voilà grâce à cette petite variable un peu spéciale pour le coup on peut PHP, on est capable de faire référence à l'objet courant donc l'instance en cours c'est-à-dire celle sur lequel nous sommes en train de travailler, l'instance en cours d'utilisation. 

Alors ça je tenais à en parler parce qu'on va revenir en détail dessus très souvent mais je tenais à l'introduire dès le départ parce que c'est mieux d'en parler tout de suite et maintenant de la première vidéo quand on commence à faire de l'objet plutôt que d'en parler dans 3 ou 4 vidéos plus tard et que vous soyez paumé. 

C'est bien de voir ça rapidement parce que vous allez l'utiliser très souvent. 

Je tenais voilà à l'aborder assez vite pour que ce soit vu ensemble. 

Alors tout ce qui est attributs et méthodes on en parlera dans la vidéo prochaine donc vous n'aurez pas de souci à vous faire là-dessus. 

Voilà on a vu comment définir une classe qui représente encore une fois le modèle d'identité, comment ça fonctionne. 

On a vu comment la construire cette classe, et construire notamment son instance c'est-à-dire un objet grâce au constructeur. 

On a parlé vite fait du destructeur. 

On a parlé de la variable `$this` très importante qu'on aura l'occasion d'utiliser plus en détail la prochaine fois. 

Et on va voir d'autre manière de instancier un objet parce que c'est un peu la fin de cette vidéo donc on va faire ça très rapidement pour cette séance. 

Alors ça c'est la méthode standard, new Vehicle(), la plus simple qu'on puisse connaître. 

Mais il faut savoir qu'on peut PHP par rapport à ce que l'on peut faire…

Alors ici il s'agit d'une petite astuce qui dans certain cas pourra vous servir, vous pourriez très bien par exemple définir genre mettre `$name` simplement dans lequel vous mettez le nom de votre classe 'Vehicle' ceci admettons.
```php
	class Vehicle
	{
		/*
			$this
		*/		
		public function __construct()
		{
			echo 'Je suis construit !';
		}
	}

	$obj1 = new Vehicle();
	$obj2 = new Vehicle();
	
	$name = 'Vehicule';
```
Et PHP permet de faire cette chose là … je le dis parce que ce n'est pas forcément le cas dans d'autres langages de programmation où on peut faire de l'objet. 

Vous pouvez très bien créer un nouvel objet new et ensuite faire ceci `$name();`
```php
	class Vehicle
	{
		/*
			$this
		*/		
		public function __construct()
		{
			echo 'Je suis construit !';
		}
	}

	$obj1 = new Vehicle();
	$obj2 = new Vehicle();
	
	$name = 'Vehicule';
>	$obj3 = new $name();
```
Je ne sais pas si vous comprenez un petit peu le principe. 

En bref il a remplacé `$name` par le contenu de notre variable et on voit que c'est 'Vehicle' d'accord. 

On arrive à comprendre qu'en réalité ça va faire new de Vehicle();
```php
	class Vehicle
	{
		/*
			$this
		*/		
		public function __construct()
		{
			echo 'Je suis construit !';
		}
	}

	$obj1 = new Vehicle();
	$obj2 = new Vehicle();
	
	$name = 'Vehicule';
>	$obj3 = new $name();//new Vehicle();
```
Ça je le dis parce que c'est important et c'est pour ça que j'en parle ici parce que ce n'est pas forcément possible, on ne peut pas forcément faire ça dans d'autres langages de programmation qui permet de programmer en objet. 

PHP le permet et des fois ça aide pas mal. 

Quand par exemple on a besoin de gérer la construction ou l'instanciation de classe de manière dynamique sans forcément connaître le nom parce qu'il a été passé par un fichier ou je ne sais quoi, Eh bien on peut récupérer ce nom dans une variable et puis ensuite en faisant un `new $` suivi du nom de la variable en question qui a récupéré le nom 'Vehicle', on peut gérer des instances de classe donc nos objets de manière dynamique. 

C'est quand même vachement pratique. 

Voilà pour cette instanciation. 

Il y a également d'autres manières, on peut également faire des instanciation via un mot-clé static.

Ensuite tout ce qui est static, on n'en a pas forcément parler. 

Et c'est pareil, ce sont des cas assez rare donc je dispenserai cette partie là en tout cas. 

On aura peut-être l'occasion de l'aborder par la suite mais ce sont vraiment des cas particulier.

Alors ça ce sont vraiment ce qu'il y a à retenir c'est-à-dire le mot clé new pour créer une nouvelle instance et si vous avez besoin de gérer vos instances de manière dynamique, sachez que vous pouvez le faire avec des variables. 

Si vous avez tout compris sur la notion et je laisse pas pour vous à ce stade de la formation sur les variables en PHP, vous pouvez donc faire comme ça et ça fonctionnera aussi.
```php
	$name = 'Vehicule';
>	$obj3 = new $name();//new Vehicle();
```
Et je pense qu'on va pouvoir s'arrêter là pour cette première séance, ce n'était pas trop trop long.

Je ne pense pas avoir passé trop de temps pour vous expliquer cela mais voilà je préfère prendre le temps parce que c'est important. 

Soyez aussi à l'aise pour la suite parce qu'il va y avoir beaucoup beaucoup de choses, beaucoup de notions et ça va devenir beaucoup plus complexe que ce que vous avez vu jusqu à présent. 

Alors si vous avez déjà pas mal galéré avec le procédural, n'hésitez pas à le revoir parce que c'est un paradigme très important PHP aussi. 

Et là on va avoir beaucoup de notions objet, et si c'est la première fois que vous programmez en objet, vous allez évidemment galérer un petit peu au début et vous allez certainement être un peu confus dans certaines explications. 

Vous allez vous mélanger un petit peu les pinceaux, ce qui est normal et je vous rassure. 

Et après quand vous aurez bien assimilé ces notions, Eh bien quand vous étudierez d'autres langages de programmation qui permettent de programmer un objet vous allez retrouver un peu les mêmes choses c'est-à-dire le système de classe, d'objet, d'instanciation, les attributs, les méthodes, l'héritage, toutes ces choses-là que je vous ai citées dans la vidéo précédente. 

Vous les Retrouvez un petit peu partout et du coup vous allez énormément gagné en rapidité d'assimilation et de compréhension pour les différents langages que vous aurez peut être envie d'étudier. 

En tout cas je vais m'arrêter là pour cette séance. 

J'espère que ça a été suffisamment clair. 

Toujours pareil, s'il y a besoin vous avez les commentaires sous la vidéo youtube pour poser des questions, pour donner des remarques ou si vous avez besoin d'aide parce que vous avez testé un petit code et qu'il y a des choses qui ne fonctionnent pas comme vous l'auriez attendu. 

N'hésitez pas à me demander comme d'habitude je lis tous les commentaires partout sur la chaîne donc je répondrai évidemment à vos questions, à vos interrogations donc n'hésitez pas à le faire.

on se retrouve du coup pour la suite et la prochaine séance on commencera à parler des attributs des méthodes, je pense que ce sera le moment d'aborder ça. 

Et vous allez voir qu'on va pouvoir justement comme le montre le modèle, on va pouvoir définir ces attributs là, les infos et définir les services de nos classes c'est-à-dire les méthodes. 

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
Et on verra comment on fait ça en PHP. 

C'est très très simple si vous avez compris les fonctions et les variables dans la vidéo précédente donc au début de la formation. 

Vous allez voir que c'est grosso modo la même chose. 

Après il y aura une autre notion concernant la visibilité des éléments de notre classe, et là c'est une petite chose un petit peu nouvelle qui est très importante et je pense que c'est même une des choses les plus importantes en objet. 

On aura l'occasion de l'aborder par la suite donc ne vous en faites pas, on verra tout ça dans le détail. 

À bientôt du coup pour la séance 21 en PHP