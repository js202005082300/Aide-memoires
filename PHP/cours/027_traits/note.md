# [27. Traits](https://www.youtube.com/watch?v=ZIqKnK37y9A)
10-12-20

Bonjour et bienvenue sur ce cours PHP. 

Nous nous retrouvons aujourd'hui pour la 27e vidéo, ça commence à bien avancer sur cette formation PHP, pour aborder une autre notion et vous l'avez vu dans le titre. 

Ça va peut être parler à certains et à d'autres pas du tout, ça parle de trait.

Alors qu'est-ce qu'un trait en PHP ?  C'est bizarre comme terme mais pourtant ça a toute une utilité. 

Vous allez voir ça permet de répondre à certaines problématiques qu'on ne peut pas forcément résoudre avec la classe abstraite ou les interfaces. 

Alors je m'excuse par avance de ne pas pouvoir tout aborder sur les traits, on pourrait faire 3 ou 4 vidéos là-dessus donc ce qu'on va faire c'est qu'on va aborder pas mal de choses avec ça mais après il faudra vraiment pouvoir mettre tout ce qu'on aura vu en pratique, tout ce qu'on aura rapidement expliqué parce qu'on ne pourra pas tout détailler et vous arriverez encore une fois à bien assimiler les choses par rapport à ça. 

Maintenant si vous n'en voyez pas l'utilité personnelle ce n'est pas grave, on peut très bien programmer sans utiliser de trait en PHP personnellement j'en ai jamais eu l'usage, jamais eu le besoin dans mes développements en PHP et pourtant j'en ai fait beaucoup. 

Mais pourtant j'arrive facilement à me dépatouiller avec les classes abstraites ou les interfaces donc je n'ai jamais vraiment besoin d'utiliser ça mais sachez que ça peut être utile dans des cas spécifiques.

On va donc regarder ça et nous reprenons les commentaires de ce que nous avions dit précédemment concernant les classes abstraites et les interfaces. 
```php
	/*
		Classe abstraite : 	classe qui ne s'instancie pas
							factoriser du code
							une classe ne peut qu'étendre une seule autre classe
		
		Interface		 :	API
							fournit un "contrat de services"
							une classe peut implementer plusieurs interfaces
	*/
```
Et on va évidemment avoir un nouveau point, ce n'est pas quelque chose de propre à la programmation objet de manière générale c'est-à-dire qu'on n'a pas le principe de trait en c++ et en Java ou autre, c'est vraiment propre à PHP. 

On peut trouver des trucs un peu différent où équivalent sur d'autres langages mais en ce qui concerne la notion de traits, vous êtes vraiment sûr du PHP. 

D'accord n'essayez pas de trouver ça ailleurs, voilà le trait en lui-même ça n'a rien à voir avec la programmation objet c'est une fonctionnalité de PHP qui répond à des besoins qu'on peut retrouver en programmation objet. 

Alors au niveau des petites règles, des petites choses que l'on peut dire sur cette notion de trait parce que c'est vrai que c'est un nom un peu bizarre, qu'est-ce que ça permet te faire ? 

Voilà on se dit qu'on a des interfaces, des classes abstraites, on a quand même pas mal de choses mais alors qu'est-ce que c'est qu'un trait ? Le trait va permettre la réutilisation de code.
```php
		Trait			 :	Ré-utilisation de code
```
Alors ça va peut-être parler à certains et beaucoup moins à d'autres mais en gros on va pouvoir gérer de la réutilisation de code dans des classes indépendantes et je vais garder ce terme là parce que c'est important. 
```php
	/*
		Classe abstraite : 	classe qui ne s'instancie pas
							factoriser du code
							une classe ne peut qu'étendre une seule autre classe
		
		Interface		 :	API
							fournit un "contrat de services"
							une classe peut implementer plusieurs interfaces
		
		Trait			 :	Ré-utilisation de code, dans des classes indépendantes
	*/
```
En gros vous allez avoir un endroit précis donc le fameux trait qui va contenir du code et on pourra se servir de ce code, le réutiliser dans plusieurs classes distinctes, qui n'ont pas forcément de rapport les unes avec les autres et qui ne sont pas dépendantes les unes des autres mais on pourra réutiliser ce code mais ça c'est une particularité et on va voir au niveau au code ce que ça donne. 

Là je vous donne quelques définitions, quelques petites règles d'usage qui sont je pense intéressant à savoir surtout quand on se forme à la programmation. 

Alors à quoi ça peut faire penser également ? alors un trait vous allez voir très vite qu'un trait c'est similaire à une classe, très similaire même par contre par rapport à l'interface qui a des règles assez strictes. 
```php
	/*
		Classe abstraite : 	classe qui ne s'instancie pas
							factoriser du code
							une classe ne peut qu'étendre une seule autre classe
		
		Interface		 :	API
							fournit un "contrat de services"
							une classe peut implementer plusieurs interfaces
		
		Trait			 :	Ré-utilisation de code, dans des classes indépendantes
							Similaire à une classe
	*/
```
Vous allez voir que le trait est quand même très similaire à une classe. 

Et il va permettre de grouper des fonctionnalités c'est à dire que le trait quand on va le définir, vous allez voir que ça va grouper tout un tas de choses.
```php
	/*
		Classe abstraite : 	classe qui ne s'instancie pas
							factoriser du code
							une classe ne peut qu'étendre une seule autre classe
		
		Interface		 :	API
							fournit un "contrat de services"
							une classe peut implementer plusieurs interfaces
		
		Trait			 :	Ré-utilisation de code, dans des classes indépendantes
							Similaire à une classe
							Grouper des fonctionnalités
	*/
```
Évidemment comme pour une interface il n'y a pas d'instanciation d'un trait. 
```php
	/*
		Classe abstraite : 	classe qui ne s'instancie pas
							factoriser du code
							une classe ne peut qu'étendre une seule autre classe
		
		Interface		 :	API
							fournit un "contrat de services"
							une classe peut implementer plusieurs interfaces
		
		Trait			 :	Ré-utilisation de code, dans des classes indépendantes
							Similaire à une classe
							Grouper des fonctionnalités
							Pas d'instanciation d'un trait
	*/
```
Voilà on instancie pas, on ne va pas créer d'objet à partir d'un trait comme on ne créera pas d'objets d'une classe abstraite ni d'une interface

Comme ça là dessus ils sont à peu près d'accord les 3, pas de problème on sait qu'on ne va pas créer un objet d'un trait, d'une interface ou d'une classe abstraite, on créera ça à partir d'une classe standard, une classe concrète. 

Voilà pour ces petites règles d'usage, après on verra que le trait permet de faire pas mal d'autres choses aussi mais on verra ça en terme de exemple et ce sera beaucoup plus parlant pour vous.

Nous allons créer un trait en prenant le k que je vous expliquais :  
```txt
>							Grouper des fonctionnalités
```
Ça groupe des fonctionnalités d'accord  ça va donc ressembler, répertorier un ensemble de fonctionnalités. 

Je vais donc créer un trait avec le mot-clé trait très simple, il est vrai que PHP ne s'est pas compliqué la vie pour ça et on va y mettre un ensemble de choses que l'on peut faire.
```php
	trait
```
Alors qu'est-ce que ça peut être ? Par exemple sur un site web, quand vous commencez à faire des sites assez complet, vous avez besoin de gérer ce qu'on appelle un routage, routing si on emploie le terme anglais, pour notamment le principe des url. 

En bref l'utilisateur va demander une url ou faire envoyer une url, et à partir de là vous devez lui restituer la bonne page web qui correspond à votre url d'accord. 

On pourrait donc très bien avoir un trait qui va gérer, qui va regrouper toutes les fonctionnalités par exemple lié au routing voilà on peut se dire ça. 

Alors voilà je prends cet exemple là parce que je n'ai pas forcément de exemple plus parlant et moi c'est celui qui me parle mieux donc je pense que ça vous parlera beaucoup surtout quand on commencera à faire des sites web assez complexes en PHP. 

On va donc avoir, je ne pense pas qu'il y a forcément des règles au niveau des traits en particulier parce que moi je dis que je m'en suis pas servi énormément et de ce que j'avais appris à l'époque sur les traits, il n'y avait pas forcément de standards ou de choses comme ça. 

Vous pouvez donc très bien utiliser un T_ ou n'importe quoi si vous voulez utiliser une lettre pour les indiquer. 

Vous faites comme vous voulez, c'est vous qui voyez en fonction de ça. 

Elle peut mettre par exemple, et on va prendre tr_ qu'on va utiliser ou même plutôt un t_ minuscule et on va mettre Routing.
```php
	trait tRouting
	{
		
	}
```
Voilà on ouvre des accolades et on définit un trait qui va regrouper des fonctionnalités. 

Alors pour lui qu'est-ce que ça va être ces fonctionnalités ? Pour lui ça va être des fonctions et vous voyez que je ne vais pas mettre de public et cetera parce qu'on n'est pas dans une classe. 
```php
	trait tRouting
	{
		function
	}
```
Attention c'est similaire à une classe mais ce n'est pas une classe sinon on aurait utilisé le mot clé class. 

Et là ça aurait posé des problèmes. 

On va donc simplement émettre des fonctions. 

D'accord en groupe des fonctionnalités donc on groupe des fonctions. 

Alors la fonction ça peut être parse() quand il s'agit de parser une url  par exemple. On va mettre ce genre de choses là et bien évidemment on va pas mettre un vrai passeur, ça paraît logique.
```php
	trait tRouting
	{
		function parse()
		{
			echo 'parsing...';
		}
	}
```
On ne va pas faire un vrai parseur ce qui paraît logique. 

Pi on peut encore avoir autre chose comme une fonction get() et cetera et cetera.
```php
	trait tRouting
	{
		function parse()
		{
			echo 'parsing...';
		}
		
		function get($req)
		{
			echo 'get function';
		}
	}
```
On prévoit donc des fonctionnalités lié au routage, au routing, ici au niveau de notre application qui serviront par la suite. 

Et à un moment donné au niveau de notre développement de site web, pour le routage, pour le routing, on va créer des classes pour tout en quelque chose au niveau de notre site. 
```php
	trait tRouting
	{
		function parse()
		{
			echo 'parsing...';
		}
		
		function get($req)
		{
			echo 'get function';
		}
	}
	
	class
```
Alors je n'ai pas forcément pareil d'exemples qui seraient très parlant sinon il faudrait vraiment développer et implémenter ces choses-là mais on pourrait imaginer une classe par exemple qui va gérer les modules genre les modules de notre site, ModuleManager.
```php
	trait tRouting
	{
		function parse()
		{
			echo 'parsing...';
		}
		
		function get($req)
		{
			echo 'get function';
		}
	}
	
	class ModuleManager
	{
		
	}
```
Et ce module comme toute partie du site, il utilise le principe des urls parce que pour accéder au module, vous allez passer par des url. 

Vous savez qu'un site web tout fonctionne par ces urls d'accord donc ça il n'y a absolument pas de problème. 

Il va donc avoir besoin d'utiliser les fonctionnalités du routing donc les fonctionnalités du trait que nous avons défini et pour se faire vous avez tout simplement utilisé le mot clé use. Et vous mettez le nom du trait avec un `;` à la fin.
```php
	trait tRouting
	{
		function parse()
		{
			echo 'parsing...';
		}
		
		function get($req)
		{
			echo 'get function';
		}
	}
	
	class ModuleManager
	{
>		use tRouting;
	}
```
Imaginez que ça ce serait une espèce de module, comme si c'était une bibliothèque même si ce n'est pas forcément le bon terme employé mais vous pouvez imaginer que ça propose des fonctionnalités comme si c'était isoler dans un fichier qui possède plein de fonctions.
```php
>	trait tRouting
>	{
>		function parse()
>		{
>			echo 'parsing...';
>		}
>		
>		function get($req)
>		{
>			echo 'get function';
>		}
>	}
	
	class ModuleManager
	{
		use tRouting;
	}
```
Et vous dites que mon module manager, il va avoir besoin d'utiliser les fonctionnalités du routing donc je dis utilise le trait que j'ai défini ici, tRouting.
```php
>		use tRouting;
```
Et on va pouvoir comme ça travailler dessus. 

À partir de là on va pouvoir utiliser les différentes méthodes. 

Il n'y aura absolument pas de problème. 

Ça c'était l'exemple bateau qu'on a fait.

On va donc créer une instance, on va faire comme dans les vidéos précédentes $test ensuite vous voyez qu'ici on ne va pas mettre de constructeur pour raccourcir le code. 

Du coup l'instanciations est très rapide à faire.
```php
	trait tRouting
	{
		function parse()
		{
			echo 'parsing...';
		}
		
		function get($req)
		{
			echo 'get function';
		}
	}
	
	class ModuleManager
	{
		use tRouting;
	}
	
	$test = new ModuleManager();
```
Et là regardez comme `$test` utilise le trait, je peux me servir des fonctions que j'ai dans tRouting. 

Je peux donc sans problème faire ça.
```php
	trait tRouting
	{
		function parse()
		{
			echo 'parsing...';
		}
		
		function get($req)
		{
			echo 'get function';
		}
	}
	
	class ModuleManager
	{
		use tRouting;
	}
	
	$test = new ModuleManager();
>	$test->parse();
```
`$test->parse();` … voilà il va cherché une méthode parse() dans la classe ModuleManager, il n'en trouve pas mais il voit qu'il utilise un trait et il va accéder dans le trait et il va voir qu'il y a une fonction tout simplement parse() donc il va pouvoir réutiliser ce code. 

Voyez c'est bien de la réutilisation de code.
```php
	/*
		Classe abstraite : 	classe qui ne s'instancie pas
							factoriser du code
							une classe ne peut qu'étendre une seule autre classe
		
		Interface		 :	API
							fournit un "contrat de services"
							une classe peut implementer plusieurs interfaces
		
>		Trait			 :	Ré-utilisation de code, dans des classes indépendantes
							Similaire à une classe
							Grouper des fonctionnalités
							Pas d'instanciation d'un trait
	*/
```
C'est de la ré-utilisation de codes dans des classes indépendantes parce que ModuleManager est évidemment indépendant de tRouting, il se sera indépendant éventuellement d'autres classes. 

Ça fonctionne donc sans problème.
```php
trait tRouting
{
	function parse()
	{
		echo 'parsing...';
	}
	
	function get($req)
	{
		echo 'get function';
	}
}

class ModuleManager
{
	use tRouting;
}

$test = new ModuleManager();
$test->parse();
```
```txt
	http://localhost/PHP/cours/027_traits/
	parsing...
```
Donc là pas de problème ça fonctionne. 

Admettons qu à un moment donné j'ai une classe qui va gérer par exemple mes templates, vous savez pour afficher de HTML par exemple quand vous gérez vos pages web. Vous verrez quand vous allez faire des sites beaucoup plus complexes, vous utiliserez un système de templates pour que ce soit beaucoup plus rapide et générer de manière dynamique. 

Pareil on peut donc dire que j'ai une classe qui gère mes templates voilà c'est un exemple très bateau mais c'est pour expliquer ça.
```php
	trait tRouting
	{
		function parse()
		{
			echo 'parsing...';
		}
		
		function get($req)
		{
			echo 'get function';
		}
	}

	class ModuleManager
	{
		use tRouting;
	}
	
>	class Template
	{
		
	}

	$test = new ModuleManager();
	$test->parse();
```
Le template encore une fois, il a besoin d'utiliser les url de votre site web donc de manière logique il va se servir des fonctionnalités de routage use tRouting;
```php
	trait tRouting
	{
		function parse()
		{
			echo 'parsing...';
		}
		
		function get($req)
		{
			echo 'get function';
		}
	}

	class ModuleManager
	{
		use tRouting;
	}
	
	class Template
	{
>		use tRouting;
	}

	$test = new ModuleManager();
	$test->parse();
```
Et à partir de là si à un moment donné j'ai besoin d'utiliser, faire une vue pour HTML via mon système de template et bien je vais faire mon template().
```php
	$html = new Template();
```
Et `$html` peut évidement avec un url 'news/mon-remier-article' dont on s'en fiche parce qu'on ne l'affiche pas.
```php
	$html = new Template();
	$html->get('news/mon-remier-article');
```
On ne l'affiche pas mais on peut faire ça.
```php
	function get($req)						function get($req)
	{										{
		echo 'get function';		=>			echo $req;
	}										}
```
Au pire voilà et on utilise la fonction get() à partir de mon objet `$html` qui de toute façon se sert du trait, use tRouting.
```php
<?php

trait tRouting
{
	function parse()
	{
		echo 'parsing...';
	}
	
	function get($req)
	{
		echo $req;
	}
}

class ModuleManager
{
	use tRouting;
}

class Template
{
	use tRouting;
}

$test = new ModuleManager();
$test->parse();
echo '<br>';
$html = new Template();
$html->get('news/mon-remier-article');

?>
```
```txt
	http://localhost/PHP/cours/027_traits/
	parsing...
	news/mon-remier-article
```
Vous voyez qu'on a des classes indépendantes, elles sont complètement indépendantes. 

On a Template qui gère quelque chose et ModuleManager qui gère autre chose mais elles sont capables d'utiliser les fonctionnalités groupées du traite tRouting. 

Ça permet donc de réutiliser du code. 

On n'a pas besoin de se dire qu'on va faire quelque chose d'autre par rapport à ça. 

Voilà le principe c'est-à-dire de la réutilisation de code dans des classes indépendantes.
```php
	/*
		Classe abstraite : 	classe qui ne s'instancie pas
							factoriser du code
							une classe ne peut qu'étendre une seule autre classe
		
		Interface		 :	API
							fournit un "contrat de services"
							une classe peut implementer plusieurs interfaces
		
>		Trait			 :	Ré-utilisation de code, dans des classes indépendantes
							Similaire à une classe
							Grouper des fonctionnalités
							Pas d'instanciation d'un trait
	*/
```
Alors c'est un exemple qui n'est pas forcément le plus parlant mais voici en tout cas un exemple qui vous montre à quoi ça peut servir. 

Ça permet vraiment de grouper les fonctionnalités. 

Alors ici on a quelque chose d'assez spécifique tRouting mais on pourrait très bien avoir un trait qui gère de quelque chose d'un peu plus global. 

Et cette globalité, toutes ces fonctionnalités globales, chaque fois qu'on aura une classe qui peut avoir la nécessité de se servir de ces fonctionnalités, on dira on mettra un petit use pour dire que voilà on a besoin d'utiliser ça. 

C'est donc une possibilité parmi tant d'autres encore une fois. 

Ce n'est pas la seule après c'est pareil pour les traits parce que ce n'est pas forcément une notion qui paraît simple au départ. 

Autant les interfaces et les classes abstraites on arrive très vite à assimiler au départ. 

Pour les traits, il faut un cas concret pour le mettre en application mais tant que vous ne serez pas arrivé là, vous n'arriverez peut-être pas forcément à voir dans quel cas ça peut être utile. 

C'est pour ça que je dis encore une fois peut-être que vous n'en aurez jamais besoin, peut être que jamais vous n'aurez la nécessité de vous en servir et ce n'est pas grave. 

Ce n'est pas parce que en PHP il est possible de faire des treks on est obligé de s'en servi. 

D'accord si vous n'en avez jamais besoin, ce n'est pas grave du tout. 

Si vous pouvez vous en passer c'est très bien. 

Il faut savoir qu'avant PHP 5.4 parce que je pense que c'est arrivé à ce moment-là si je ne dis pas de bêtises ça n'existe pas. 

Les gens qui faisaient du PHP avant cette version, se débrouillait très bien sans, ça ne posait aucun souci. 

Ne vous sentez pas obligé de vous servir de ça parce que ça existe. 

S'il fallait obligatoirement se servir de toutes les fonctionnalités d'un langage, on aurait dû code absolument infâme, ce serait de n'importe quoi. 

Utiliser les choses correctement et consciemment tout en sachant pourquoi vous vous en servez et si c'est le meilleur moyen selon vous de répondre au problème donné en informatique est-ce que vous avez, de trouver une solution au problème informatique. 

Sinon si vous n'en voyez pas l'usage et l'intérêt, ou le besoin, et bien faites autre chose. 

Si vous pouvez faire une interface pour résoudre votre problème, utiliser une interface et ne vous embêtez pas avec ça mais je tenais en parler parce que à mon sens c'est une notion qui est importante de connaître même si on n'est pas obligé de l'utiliser. 

C'est bien en tant que développeur PHP de se dire que je suis développeur en PHP et je sais ce que c'est un trait en PHP parce que un développeur actuellement en PHP qui ne sait pas ce que c'est, c'est un peu problématique donc c'est bien de savoir que ça existe et dans quel cas ça peut être utile. 

Voilà ça c'était un simple exemple, le plus simple du monde que je peux donner. 

Je ne peux absolument pas faire plus simple pour le coup par rapport à ça concernant çà. 

Chose intéressante qu'on peut faire aussi, on peut changer la visibilité.

Alors c'est pareil il faudra voir dans un cas concret des fonctions c'est à dire que ici on peut très bien dire public function comme ça.
```php
	trait tRouting
	{
>		public function parse()
		{
			echo 'parsing...';
		}
		
>		public function get($req)
		{
			echo $req;
		}
	}

	class ModuleManager
	{
		use tRouting;
	}

	class Template
	{
		use tRouting;
	}

	$test = new ModuleManager();
	$test->parse();
	echo '<br>';
	$html = new Template();
	$html->get('news/mon-remier-article');
```
Voilà public function pour les fonctions parse() et get() et on peut très bien dans une partie alors il faut voir dans quel cas ça peut être utile de le faire. Il faut vraiment trouver un cas spécifique de se dire que j'utilise le trait ici, `use tRouting` mais par contre je vais faire `{parse as}` donc on utilise le mot clé `as` et je vais le mettre dans une autre propriété de visibilité `{parse as protected};`
```php
	trait tRouting
	{
>		public function parse()
		{
			echo 'parsing...';
		}
		
>		public function get($req)
		{
			echo $req;
		}
	}

	class ModuleManager
	{
		use tRouting;
	}

	class Template
	{
>		use tRouting {parse as protected};
	}

	$test = new ModuleManager();
	$test->parse();
	echo '<br>';
	$html = new Template();
	$html->get('news/mon-remier-article');
```
On le met dans une autre propriété de visibilité c'est-à-dire que ce n'est plus quelque chose de public mais c'est quelque chose qui passe en protected. 

Ça veut dire qu à ce moment-là je pourrais faire une classe fille qui étend Template et qui pourra utiliser parse() ici.
```php
	class Template
	{
>		use tRouting {parse as protected};
	}
```
Si ça devient par contre private, on ne pourra plus.
```php
	class Template
	{
>		use tRouting {parse as private};
	}
```
Vous voyez un petit peu le principe mais ça je ne reviens pas sur la visibilité parce qu'on en a parlé en ce qui concerne les accesseurs et tout ça. C'est quelque chose qu'on n'a pas mal abordé sur cette formation mais sachez que c'est possible. 

On peut évidemment s'amuser en faisant autre chose par exemple en spécifiant d'autres noms mais ce n'est pas forcément utile, on pourrait faire du renommage de fonctionnement méthode mais ce n'est pas ce qu'il y a forcément de plus utile ou de plus intéressant mais en tout cas sachez que vous pouvez faire ça. 

Vous pouvez changer la visibilité comme ça au niveau des méthodes du trait donc ça c'est une chose. 

On va terminer cette vidéo et ça ne sert à rien que je passe des années dessus et en tout cas à votre stade de rentrer dans des détails et tout voir dessus parce que ça ne servira à rien mais je veux vraiment me contenté de ce qui est important à savoir, et le reste vous comprendrez vous assimilerez en utilisant cette notion. 

Encore une fois il n'y a pas de raccourci, on est obligé de s'en servir pour vraiment voir l'utilité que ça peut avoir sinon vous faites comme certain. 

Comme moi par exemple dans mes développements actuels, ça changera peut-être un jour mais jusqu à présent avec les interfaces et les classes abstraites, j'arrivais à résoudre tous les problèmes que je pouvais avoir au niveau de mes développements en PHP.

Peut-être qu'un jour je serai confronté à un souci où je serai obligé de me servir d'un trait pour avoir quelque chose de convenable peut-être voilà. 

Alors il faut savoir qu'un trait peut utiliser d'autres traits. 

On peut très bien si vous avez compris un peu le principe si on fait un usage de fonctionnalité simplement. 

Vous pouvez sans problème mais ça paraît logique où je crée par exemple un autre trait, tOther et dans celui-là vous dites que vous utilisez tRouting.
```php
	trait tRouting
	{
		public function parse()
		{
			echo 'parsing...';
		}
		
		public function get($req)
		{
			echo $req;
		}
	}

>	trait tOther
	{
		use tRouting;
	}

	class ModuleManager
	{
		use tRouting;
	}

	class Template
	{
		use tRouting {parse as protected};
	}

	$test = new ModuleManager();
	$test->parse();
	echo '<br>';
	$html = new Template();
	$html->get('news/mon-remier-article');
```
Et après vous définissez les autres choses, les autres fonctions et cetera.
```php
	trait tOther
	{
		use tRouting;
		
		function ...
	}
```
Voilà ça je l'avais dit en début de vidéo que j'allais aller très rapidement sur les explications à la fin parce que ça ne sert à rien de vous donner tous les détails. 

Il faudrait faire un vrai projet pour se rendre compte de l'utilité mais vous pouvez. 

Un trait peut t'utiliser d'autres traits sans aucun problème. 

Un trait peut également faire une référence à une classe c'est à dire que ça c'est au niveau de l'utilisation, au niveau des déclarations, des instanciations. 

Si on a par exemple une classe définie avant un trait et on a ensuite un trait qui a un usage, on pourrait très bien à l'intérieur d'une fonction fait référence à une classe parentes il se serait un peu bizarre de dire qu'un trait a une classe parente mais on peut faire ce genre de choses, faire une référence en utilisant le fameux mot clé `parent::` et l'opérateur de résolution portée.
```php
	trait tRouting
	{
		public function parse()
		{
			echo 'parsing...';
		}
		
		public function get($req)
		{
			echo $req;
		}
	}

	trait tOther
	{
>		function someFunction()
		{
>			parent::
		}
	}

	class ModuleManager
	{
		use tRouting;
	}

	class Template
	{
		use tRouting {parse as protected};
	}

	$test = new ModuleManager();
	$test->parse();
	echo '<br>';
	$html = new Template();
	$html->get('news/mon-remier-article');
```
Voilà `parent` avec l'opérateur de résolution de portée `::` et puis utiliser quelque chose. 

Par exemple on aurait une méthode de classe très particulière, Eh bien voilà on utilise la méthode de la classe et cetera.
```php
	trait tOther
	{
		function someFunction()
		{
			parent::myMethod();
		}
	}
```
Alors ça c'est possible mais pareil c'est à voir à l'usage parce que là comme ça avec ce que je vous met en code, ce n'est pas forcément très parlant parce que je ne peux pas vous montrer ça en détail avec le peu de code qu'il y a ici pour les exemples mais il faut savoir que c'est possible. 

Et ensuite, et ça ça rejoint ce qu'on avait dit donc ça c'est important mais par contre là je vais prendre le temps d'un petit peu l'expliquer. 

Pourquoi est-ce qu'un trait est similaire à une classe ? Tout simplement parce que dans un très mais avant on va raccourcir le code.
```php
	trait tRouting
	{
		public function parse()
		{
			echo 'parsing...';
		}
	}

	class ModuleManager
	{
		use tRouting;
	}

	$test = new ModuleManager();
	$test->parse();
```
Alors un trait peut contenir sans problème des variables, on peut lui faire des variables et ça ne posera pas de problème parce que ça fonctionne un peu comme une classe. 

On peut avoir des attributs pas de souci. 

On peut faire également des méthodes statiques.
```php
	trait tRouting
	{
>		public static function parse()
		{
			echo 'parsing...';
		}
	}

	class ModuleManager
	{
		use tRouting;
	}

	$test = new ModuleManager();
	$test->parse();
```
Et après pareil de la même manière vous faites votre utilisation de manière statique.
```php
	trait tRouting
	{
>		public static function parse()
		{
			echo 'parsing...';
		}
	}

	class ModuleManager
	{
		use tRouting;
		
>		tRouting::parse();		
	}

	$test = new ModuleManager();
	$test->parse();
```
Comme pour une classe, dans une classe on peut faire des méthodes statiques, et bien dans un trait on peut faire des méthodes statiques aussi.

On peut faire également des méthodes abstraites, `abstract public function truc();`
```php
	trait tRouting
	{
		public static function parse()
		{
			echo 'parsing...';
		}
		
>		abstract public function truc();
	}

	class ModuleManager
	{
		use tRouting;
		
		tRouting::parse();		
	}

	$test = new ModuleManager();
	$test->parse();
```
truc() évidemment on implémente rien et ça obligera à toute classe qui utilise le trait d'implémenter cette fameuse méthode qui était abstraite à la base. 
```php
	trait tRouting
	{
		public static function parse()
		{
			echo 'parsing...';
		}
		
>		abstract public function truc();
	}

	class ModuleManager
	{
		use tRouting;
		
>		public function truc()
		{
			
		}
	}

	$test = new ModuleManager();
	$test->parse();
```
Vous voyez que ça mélange un petit peu la notion de classe mère, d'héritage alors qu'il n'y a pas d'extension ici on n'a pas quelque chose qui est étend un trait du tout. On a juste un usage, use.
```php
	class ModuleManager
	{
>		use tRouting;
		
		public function truc()
		{
			
		}
	}
```
Ca mêle un peu les fonctionnalités des classes, s'emmêle un peu des fonctionnalités on va dire des simples fonctions c'est à dire le fait de modulariser notre code et de grouper tout simplement. 

Ça je pense que c'est la chose la plus importante, il y a 2 règles très importantes sur les traits si on veut ne pas se perdre c'est qu'un trait va grouper des fonctionnalités et je pense que c'est suffisamment parlant et il permet de réutiliser du code dans des classes indépendantes.
```php
	/*
		Classe abstraite : 	classe qui ne s'instancie pas
							factoriser du code
							une classe ne peut qu'étendre une seule autre classe
		
		Interface		 :	API
							fournit un "contrat de services"
							une classe peut implementer plusieurs interfaces
		
>		Trait			 :	Ré-utilisation de code, dans des classes indépendantes
							Similaire à une classe
>							Grouper des fonctionnalités
							Pas d'instanciation d'un trait
	*/
```
Voilà je crois que ça c'est le plus important. 

Le fait que ça ne s'instancie pas et que ce soit au similaire à une classe, voilà ce sont des choses logiques mais ça c'est vraiment le plus important c'est-à-dire qu'on groupe des fonctionnalités.
```txt
>							Grouper des fonctionnalités
```
Au groupe des fonctionnalités et dans les classes indépendantes et on peut réutiliser ce code parce qu'il sert à ça, on va réutiliser ce que propose le trait plus ou moins des services parce que c'est un petit peu ce principe là. 

Voilà et on en terminera avec ça parce que ça sert à rien que je continue comme ça on aurait pu faire plein plein de vidéos là-dessus avec plein d'exemples de plusieurs centaines de lignes pour avoir vraiment des choses très concrètes mais ce n'est évidemment pas forcément le thème dans un cours d'apprentissage, ça vous perdrais et vous vous embrouillez plus qu'autre chose donc n'hésitez pas à pratiquer et mettre ça en pratique, un jour vous forcerez à utiliser un trait pour voir pour dire que maintenant je comprends et je vois maintenant qu'est-ce que ça m'a permis de résoudre comme problème cette notion en PHP. 

Et dites-vous qu'il y a plein de langage pour lequel ça n'existe pas d'accord les traits propre en PHP et les autres langages qui n'ont que les classes abstraites, les interfaces voir des fois que des classes abstraites. Il y en a certains qui n'ont pas d'interface et ils s'en sortent très bien. 

On peut très bien programmer un objet sans forcément avoir toutes ces fonctionnalités, c'est juste que PHP les à toutes et également créer cette notion de trait donc c'est un peu plus riche à ce niveau-là et tant mieux. 

Ça permet d'avoir un petit peu plus de choix pour les développeurs PHP donc n'hésitez pas à vous en servir si nécessaire. 

On se dit à bientôt pour la suite de la formation, j'espère que ça vous aura plu, s'il y a des questions ou des remarques n'hésitez pas à laisser des commentaires et entraînez-vous. 

Mettez vraiment ça en pratique, n'hésitez pas quand ce sera le cas parce que là ce n'est pas le cas au moment où je fais cette vidéo à consulter les exercices qu'il y a et qu'il y aura en PHP qui permettront un peu de mettre en pratique permet de choses.

Et comme ça vous pourrez vous perfectionner et vous exercer là-dessus pour bien progresser dans ce langage PHP qui comme le voyez possède tout un tas de fonctions assez intéressantes et tout un tas de choses à apprendre.

À bientôt, à la prochaine pour une prochaine vidéo