# [26. Interface](https://www.youtube.com/watch?v=3APJu3DjbHQ)
09-12-20

Bonjour à tous et bienvenue pour cette 26e séance en PHP. 

La dernière fois nous avons parlé des classes abstraites et nous allons aborder une autre notion qui est pas mal hein comprises des gens qui apprennent la programmation et notamment la programmation orientée objet c'est-à-dire à savoir les interfaces. 

Et je vais vous expliquer un petit peu par la suite la différence qu'il y a entre les classes abstraites et les interfaces parce que c'est une confusion récurrente chez les développeurs de savoir quand utiliser l'un ou quand utiliser l'autre et à quoi servent les 2 et quelles sont effectivement leur différence.

On va venir sur un code très simple et on va revenir déjà sur le principe de la classe abstraite très rapidement pour faire le point. 

Une classe abstraction prend tout ce qui a pu être vu précédemment, c'est tout simplement une classe qui ne s'instancie pas, c'est un point très simple en termes de syntaxe.
```php
	/*
		Classe abstraite : classe qui ne s'instancie pas
	*/
```
Très simple en terme de syntaxe mais c'est surtout une manière de factoriser du code. 

Factoriser du code vous savez c'est quand on a de la répétition de code, pour éviter cela on va tout simplement rassembler les répétitions de code au sein de quelque chose, une fonction quand on fait du procédural, du fonctionnel ou autre mais pour le coup de la programmation objet, on fera une classe dans lequel on utilisera des méthodes et on travaillera avec des attributs.
```php
	/*
		Classe abstraite : 	classe qui ne s'instancie pas
							factoriser du code
	*/
```
Ça permet vraiment de factoriser du code cette classe abstraite, et vous avez compris le principe, nous avons des méthodes abstraites qui obligent dans les classes qui étendent cette classe abstraite à implémenter ces méthodes. 

Je ne reviens pas dessus parce que c'est ce qu'on a vu dans la vidéo précédente. 

Si ce n'est pas encore clair pour vous n'hésitez pas à revenir dans la vidéo d'avant concernant les classes abstraites. 

Grosso modo c'est donc ça, une classe abstraite ça va permettre de factoriser du code tout simplement. 

Pour rester sur quelque chose d'assez simple. 

Pour l'interface c'est ce que nous allons voir dans cette vidéo aujourd'hui, c'est tout simplement ce qui va représenter une API. Je vais m'expliquer là dessus vous allez comprendre que c'est pour définir un contrat de service.
```php
	/*
		Classe abstraite : 	classe qui ne s'instancie pas
							factoriser du code
		
		Interface		 :	API
							définir un "contrat de services"
	*/
```
Alors j'emploi volontairement ce terme parce que c'est un terme qu'on peut retrouver pas mal sur internet, je sais qu'il y a beaucoup de développeurs qui l'emploient et ce n'est pas pour rien parce que c'était un petit peu resté comme ça par habitude chez les développeurs. 
```php
	/*
		Classe abstraite : 	classe qui ne s'instancie pas
							factoriser du code
		
		Interface		 :	API
>							fournit un "contrat de services"
	*/
```
On parle de contrat de services, on peut même dire carrément que ça fournit un contrat de service alors qu'est-ce que ça veut dire ? Ça veut tout simplement dire que nous allons créer quelque chose un peu comme une classe abstraite mais là il s'agira d'une interface et nous allons en faire une, vous allez voir.  

Je vous montre avec du code  et par convention on commence avec un i majuscule ou minuscule c'est ce que vous voulez mais moi je vais mettre un i majuscule parce que les classes commencent généralement par un i majuscule et vous suivez en fait le nom que vous avez pour votre interface. 
```php
	interface I
```
Alors pourquoi peut-on faire une interface ? On peut faire une interface pour des articles puisqu'on travaille sur du site web voilà.
```php
	interface IArticle
```
Voilà donc une interface i donc IArticle. 

On a ça et donc à l'intérieur d'une interface, la règle à respecter c'est de définir des méthodes qui seront évidemment public parce qu'on va avoir besoin de travailler avec elle vous verrez pourquoi, et on ne les implémente pas. C'est vraiment comme une API c'est à dire qu'on a une fiche imaginé, et que vous passiez une espèce de fiche, imaginez par exemple un menu dans un restaurant, on vous passe tout ça et vous avez la liste de tout ce qui est disponible. 

Là c'est pareil, une interface en va déterminer tout ce que l'on peut faire avec un article. 

Prenons l'exemple d'un article de blog admettons et on va créer du coup quelques méthodes. 

On va par exemple pouvoir dire write() d'accord ce genre de chose.
```php
	interface IArticle
	{
		public function write()
	}
```
Alors ça peut même être save() pour sauvegarder un article, on va dire par exemple qu'il y a un auteur et un contenu.
```php
	interface IArticle
	{
		public function save($author, $content);
	}
```
Alors je ne me embête pas sur les variables mais bon ce sont des méthodes donc on peut évidemment avoir des variables ou des paramètres, pas de problème.

On va avoir par exemple une fonction delete() sans forcément passer quoi que ce soit de précis. 
```php
	interface IArticle
	{
		public function save($author, $content);
>		public function delete();
	}
```
On va avoir une fonction create().
```php
	interface IArticle
	{
>		public function create();
		public function save($author, $content);
		public function delete();
	}
```
Alors qu'est-ce qu'on peut faire aussi avec un article ? Eh bien on peut par exemple avoir le nombre de commentaires par exemple ce genre de chose.
```php
	interface IArticle
	{
>		public function getNBComments();
		public function create();
		public function save($author, $content);
		public function delete();
	}
```
Enfin bref vous prenez des méthodes comme ça et là vous dites tout ce que vous pouvez faire. 

Juste en voyant ça et je vous le dis si on écrivait sur une fiche dans des termes un peu plus français ces différentes méthodes on aurait l'ensemble des services d'accord donc le contrat de services que propose cette interface. 

Et là où c'est intéressant c'est que au niveau d'une classe en PHP pour le coup mais on retrouve les interfaces dans beaucoup de langages, ça concerne vraiment la programmation objet, c'est une notion de la programmation objet et pas forcément que de PHP, ce qu'on va créer une classe par exemple quelque chose pour gérer, gérer n'importe quoi genre BlogArticle.
```php
	interface IArticle
	{
		public function getNBComments();
		public function create();
		public function save($author, $content);
		public function delete();
	}
	
>	class BlogArticle
```
Et on ne va donc pas étendre ici puisqu'il ne s'agit pas d'une classe mais d'une interface mais nous allons implémenter l'interface donc ici IArticle.
```php
	interface IArticle
	{
		public function getNBComments();
		public function create();
		public function save($author, $content);
		public function delete();
	}
	
>	class BlogArticle implements IArticle
	{
		
	}
```
Et là vous avez obligation par rapport à une interface d'implémenter toutes les méthodes de l'interface, c'est obligé. Vous ne pouvez pas vous dire qu'on en fait quelques-unes et pas à d'autres. 

Vous êtes obligé parce que vous voyez que dans l'interface vous n'avez rien, on a aucune implémentation et donc c'est pour ça que le mot-clé implements vous l'indique. 

implements, ça veut simplement dire que la classe BlogArticle va implémenter les services que propose IArticle notre interface.

Vous allez donc vous amuser à faire toutes vos méthodes et vous allez évidemment implémenter ce qu'il se passe. Vous allez avoir une erreur et je vais vous montrer qu'on ne va pas le faire pour tous et bien que je remplisse avec du code inutile mais c'est pour que vous voyiez. On peut retourner un nombre fictif. Quand vous êtes dans une classe vous pouvez également faire des attributs. Vous pouvez très bien créer des propriétés d'attribut sans aucun problème c'est à dire que vous êtes dans une classe standard c'est exactement le même fonctionnement, je ne reviens pas dessus … vous pouvez faire votre constructeur enfin bref et vous allez donc voir un petit peu le principe de l'interface.
```php
<?php

interface IArticle
{
	public function getNBComments();
	public function create();
	public function save($author, $content);
	public function delete();
}

class BlogArticle implements IArticle
{
	public function getNBComments()
	{
		return 15;
	}
	
	public function create()
	{
		echo 'Create()';
	}
	
	public function save($author, $content)
	{
		echo $content;
	}
	/*
	public function delete()
	{
		echo 'suppression...';
	}
	*/
}
```
Alors d'ailleurs si j'oublie d'implémenter une des parties. Voyez que j'implémente que 3 des méthodes de l'interface ensuite j'actualise.
```txt
	http://localhost/PHP/cours/026_interface/
	Fatal error: Class BlogArticle contains 1 abstract method and must therefore be declared abstract or implement the remaining methods (IArticle::delete) in C:\...\index.php on line 167
```
Vous voyez il nous met que BlogArticle contient une méthode abstraite, qui est abstraite au niveau de l'interface,  qui n'a pas été implémentée et d'ailleurs vous voyez qu'on vous le dit il s'agit de la méthode delete() et effectivement on voit qu'elle n'a pas été implémentée. 

Vous êtes donc obligé de toutes les implémenter parce que l'interface n'est pas fait pour ça. 

Pour l'interface imaginer quelque chose de très haut niveau, c'est vraiment une API d'accord on peut appeler ça comme ça et qui vous dit si vous voulez utiliser mon système d'article, voilà tout ce que tu peux faire avec : tu peux récupérer un nombre de commentaires, tu peux en créer, tu peux en sauvegarder et tu peux en supprimer. 

Voyez qu'on n'a pas besoin de savoir comment c'est fait on s'en fiche. 

Et nous en tant que développeur ici, utilisateur de l'interface, on l'implémente. 

On va lui dire tiens voilà, on récupère ça et on gère la récupération et la création de commentaire de telle ou telle manière et cetera. 

Et alors ici il n'y aura pas de problème.
```php
<?php

interface IArticle
{
	public function getNBComments();
	public function create();
	public function save($author, $content);
	public function delete();
}

class BlogArticle implements IArticle
{
	public function getNBComments()
	{
		return 15;
	}
	
	public function create()
	{
		echo 'Create()';
	}
	
	public function save($author, $content)
	{
		echo $content;
	}
	
	public function delete()
	{
		echo 'suppression...';
	}
}
```
```txt
	http://localhost/PHP/cours/026_interface/
```
Après il suffit de faire quelque chose de très simple. 

On va faire `$test = new BlogArticle();` et après du coup on n'a plus qu'a faire par exemple `$test->create();`
```php
<?php

interface IArticle
{
	public function getNBComments();
	public function create();
	public function save($author, $content);
	public function delete();
}

class BlogArticle implements IArticle
{
	public function getNBComments()
	{
		return 15;
	}
	
	public function create()
	{
		echo 'Create()';
	}
	
	public function save($author, $content)
	{
		echo $content;
	}
	
	public function delete()
	{
		echo 'suppression...';
	}
}

$test = new BlogArticle();
$test->create();
```
```txt
	http://localhost/PHP/cours/026_interface/
	Create()
```
D'accord et ça fonctionne, il n'y a absolument aucun problème à ce niveau-là. 

Voilà tout y est au niveau de l'interface. 

Là je vous aide grosso modo donner la différence par rapport à ça.
```php
	/*
		Classe abstraite : 	classe qui ne s'instancie pas
							factoriser du code
		
		Interface		 :	API
							fournit un "contrat de services"
	*/
```
Je vous ai donné la différence par rapport à ça mais au final on pourrait se dire qu'on pourrait très bien faire pareil avec une classe abstraite. 

Et c'est vrai on pourrait très bien mettre que des méthodes abstraites rappelez vous en mettant des abstract. 

Je vais d'ailleurs vous remontrer le code en mettant que des classes abstraites pour que vous voyiez un petit peu genre un article abstrait et on pourrait faire exactement ça.
```php
>	abstract class AbstractArticle
>	{
>		abstract public function getNBComments();
>		abstract public function create();
>		abstract public function save($author, $content);
>		abstract public function delete();
>	}

	interface IArticle
	{
		public function getNBComments();
		public function create();
		public function save($author, $content);
		public function delete();
	}

	class BlogArticle implements IArticle
	{
		public function getNBComments()
		{
			return 15;
		}
		
		public function create()
		{
			echo 'Create()';
		}
		
		public function save($author, $content)
		{
			echo $content;
		}
		
		public function delete()
		{
			echo 'suppression...';
		}
	}

	$test = new BlogArticle();
	$test->create();
```
Il y a 2 coup pareil en faisant une classe ici qui pour le coup ferait un extends Parce que vous pouvez avoir une place qui en étend une autre et qui implémente l'interface, vous pouvez mélanger les 2 il n'y a aucun problème faisons comme ceci.
```php
>	abstract class AbstractArticle
>	{
>		abstract public function getNBComments();
>		abstract public function create();
>		abstract public function save($author, $content);
>		abstract public function delete();
>	}

	interface IArticle
	{
		public function getNBComments();
		public function create();
		public function save($author, $content);
		public function delete();
	}

>	class BlogArticle extends AbstractArticle implements IArticle
	{
		public function getNBComments()
		{
			return 15;
		}
		
		public function create()
		{
			echo 'Create()';
		}
		
		public function save($author, $content)
		{
			echo $content;
		}
		
		public function delete()
		{
			echo 'suppression...';
		}
	}

	$test = new BlogArticle();
	$test->create();
```
Voilà vous voyez donc c'est ça et là si on serait obligé de redéfinir ça. 

On reviendrait du coup au même truc que l'interface mais vous allez vous demander au final à quoi ça peut servir. 

Alors là où c'est intéressant et on l'avait dit précédemment, ce que vous avez appris vous ne pouvez pas avec une classe abstraite enfin au niveau de l'héritage en ce qui concerne la vidéo sur l'héritage, on ne peut pas faire d'héritage multiple. 

Par exemple si on crée, très rapidement, une classe A, une classe B avec tout un tas de choses, je ne pourrais pas faire d'héritage multiple qui consiste à faire une classe OtherClass qui étend par exemple la classe A et la classe B.
```php
	/*
		class A{}
		class B{}
		
		class OtherClass extends A, B
	*/
```
Ceci est impossible. 

On ne peut pas faire d'héritage multiple à part dans certains langages particuliers mais c'est très déconseillé parce que ça mène après à très très gros conflits au niveau de la compilation et de l'exécution bref ça amène à pas mal d'erreurs de programmation. 

Ainsi dans l'idéal on évite vraiment l'héritage multiple. 

Eh bien justement les interfaces ont été conçues pour fonctionner d'une certaine manière comme la classe abstraite mais elles vont pouvoir permettre de faire de la multiple implémentation cette interface. 

Ce qui veut dire que je peux créer par exemple IAuthor pour un auteur dans lequel on ne va pas mettre grand chose avec une méthode pour gérer le profil de l'auteur donc on prend que profile() dans notre interface IAuthor. 
```php
	interface IArticle
	{
		public function getNBComments();
		public function create();
		public function save($author, $content);
		public function delete();
	}
	
>	interface IAuthor
>	{
>		public function profile();
>	}

	class BlogArticle implements IArticle
	{
		public function getNBComments()
		{
			return 15;
		}
		
		public function create()
		{
			echo 'Create()';
		}
		
		public function save($author, $content)
		{
			echo $content;
		}
		
		public function delete()
		{
			echo 'suppression...';
		}
	}

	$test = new BlogArticle();
	$test->create();
```
Et du coup on sera obligé évidemment d'implémenter ça là dedans. Alors on vire la classe abstraite et on peut sans problème implémenter plusieurs interfaces. Simplement de se dire que ma classe qui va gérer un article de blog, elle a besoin d'implémenter 2 API's, 2 types de contrat. Un contrat qui fournit des services à l'article en lui même mais vous avez vu que l'article va manipuler également des auteurs donc on a peut-être besoin d'implémenter l'API, implémenter les services liés à un auteur. 

Et du coup, on peut sans problème faire implements une interface, une deuxième, une troisième et cetera.
```php
	interface IArticle
	{
		public function getNBComments();
		public function create();
		public function save($author, $content);
		public function delete();
	}
	
	interface IAuthor
	{
		public function profile();
	}

	class BlogArticle implements IArticle, IAuthor
	{
		public function getNBComments()
		{
			return 15;
		}
		
		public function create()
		{
			echo 'Create()';
		}
		
		public function save($author, $content)
		{
			echo $content;
		}
		
		public function delete()
		{
			echo 'suppression...';
		}
	}

	$test = new BlogArticle();
	$test->create();
```
On peut faire de l'implémentation multiple là on ne peut pas faire de l'héritage multiple voilà. 

C'est ça qu'il faut comprendre, c'est que du coup une classe peut implémenter plusieurs interfaces alors qu'une classe ne peut qu'étendre une seule autre classe voilà.
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
Grosso modo et ça c'est le petit conseil que je vous donne pour les débutants c'est à dire que quand vous allez avoir de l'expérience vous allez programmer, je voudrais que les contextes d'usage sont un petit peu différent, sont un peu plus subtil que ça mais dans la mesure où vous êtes débutant, vous ne savez pas toujours quand utiliser…

Si vous voulez une règle très simple, de vous dire quand j'utilise une classe abstraite, quand j'utilise une interface : Une classe abstraite vous l'utilisez pour factoriser du code. Si vous avez besoin de factoriser du code vous utilisez une classe abstraite d'accord. Et vous vous servez des interfaces si vous prévoyez par la suite d'avoir des classes qui peuvent se servir de plusieurs entitées c'est-à-dire nos fameuses interfaces

Si à un moment vous avez besoin d'une classe particulière qui aurait besoin d'utiliser 23 choses à la fois, et bien c'est 2, 3 choses dont je parle faites en des interfaces plutôt que des classes abstraites comme ça vous pourrez faire ces fameuses implémentations multiples sans problème. 

Dites-vous que c'est une API, encore une fois penser au menu dans un restaurant. 

Un menu de restaurant c'est une interface et après avec l'entité par exemple cuisinier. 

Le cuisinier va implémenter les recettes du menu si vous comprenez un petit peu l'analogie, il va implémenter ça utiliser justement tout ce qui est disponible. 

Donc vous en ayant une interface comme ceci.
```php
	interface IArticle
	{
		public function getNBComments();
		public function create();
		public function save($author, $content);
		public function delete();
	}
```
En ayant une interface comme ceci je n'avais pas besoin de savoir comment on crée un article, comment on le sauvegarde d'accord c'est juste pour dire quel service elle propose, qu'est-ce qui est disponible sur cette interface. 

C'est ce qu'on appelle une API quand on veut rester sur des termes assez particuliers. 

Par exemple vous avez peut-être les services que vous utilisez tous les jours comme youtube, comme Google, comme Facebook, Twitter, et cetera. Ces derniers proposent des API et qu'est-ce que ça veut dire ? Ça veut dire qu'ils vous proposent une interface haut niveau, une abstraction quelque chose de très haut niveau que les gens peuvent réutiliser comme ça ça vous permet par exemple d'afficher les tweets de votre compte Twitter sur votre site web pourtant Twitter ne vous appartient pas ce n'est pas votre site à vous. 

Malgré ça grâce à une API qui est fournie par Twitter, vous pouvez si vous voulez diffuser vos tweets sur votre site web de manière dynamique comme vous pourriez gérer directement Facebook sur votre site ou afficher les vidéos d'une chaîne youtube en particulier sur votre site également en utilisant l'API youtube. 

Voilà ça peut être ça pour tout un tas de services, tous les services web de toute façon Amazon, twitch, youtube, Google et cetera même à priori discord maintenant, vous avez une à payer pour un petit peu tout et n'importe quoi. 

Et c'est ce principe là, c'est souvent un mot API que les gens ne comprennent pas, qu'est-ce qu'une API et cetera ? on a l'impression que c'est compliqué à expliquer mais non c'est simplement ça, c'est un contrat de service tout simplement. 

Ont fourni des services, des fonctionnalités et après évidemment il faut que derrière ce soit implémenté mais nous on a juste besoin de savoir qu'est-ce qu'on peut faire avec cette fameuse API. 

Voilà qu'est-ce qu'il est possible de faire ? 

On peut s'amuser à faire une interface pour youtube, si vous voulez on va faire et je donne un exemple très très très simpliste. 

On peut par exemple imaginer getVideo() et puis en fonction d'une url on pourrait récupérer une vidéo. 
```php
	interface IYoutube
	{
		public function getVideo();
	}
```
Après ça peut être pareil, il y a bien sûr les accesseurs et tout ça. 

Après ça peut être les subscribers(), les abonnés d'une chaîne et cetera et cetera, vous voyez c'est une API pour diffuser ce genre de chose.
```php
	interface IYoutube
	{
		public function getVideo();
		public function subscribers();
	}
```
Ensuite pour Twitter ce serait last tweet ou quelque chose comme ça. 

Bref comprenez le principe grâce à ça et c'est vraiment pas plus compliqué, voilà en tant que débutant si vous ne savez pas quand utiliser l'un ou l'autre encore une fois utiliser la classe abstraite quand il s'agit de factoriser du code pour après implémenter ça dans une classe fille, utiliser les interfaces quand vous voulez faire des implémentations multiples dans certaines classes tout simplement pour fournir des fonctionnalités. 

Par exemple vous voulez développer un forum et bien faites-vous une interface pour le forum avec publier un message, éditer un message, lire le profil d'un membre ou ce genre de chose et après comme ça au niveau de votre code concret vous pourrez implémenter cette interface lié à votre forum d'accord aux fonctionnalités de votre forum et ainsi de suite. 

Pour la classe abstraite c'est encore autre chose, c'est plus vraiment pour factoriser du code que de fournir une API voilà quelque chose de haut niveau avec tout un ensemble de services. 

Voilà la différence et après pour le reste de toute façon c'était l'utilisation, avec l'expérience et la pratique que vous arriverez véritablement le mieux à déterminer quel est le mieux à utiliser selon le contexte de développement où vous êtes. 

Dans un cas vous serez tout de suite qu'il faut utiliser une interface et dans un autre cas vous dirais que là il faut utiliser une classe abstraite. 

Et pour la prochaine vidéo si vous voyez que ni l'interface ni la classe abstraite ne vous permet de faire ce que vous aimeriez faire, vous verrez dans la vidéo prochaine qu'on va parler d'une autre nation qu'ici par contre propre à PHP c'est-à-dire que ce n'est pas une notion qui est liée à la programmation objet. 

C'est le langage PHP, les créateurs de PHP qui ont intégré cette autre fonctionnalité au langage qui permet entre guillemets de combler les petits manques des interfaces et des classes abstraites. 

C'est une 3e catégorie qui permet un petit peu de combler les lacunes de ces 2 là même si on peut déjà couvrir presque tous les cas différents avec les classes abstraites et les interfaces. 

Je pense que j'ai fait le tour de ce que je voulais vous montrer par rapport à ça. 

Je vous ai tout dit. 

Alors je rappelle que je vous avais dit que toutes les méthodes doivent être public.
```php
	interface IArticle
	{
		public function getNBComments();
		public function create();
		public function save($author, $content);
		public function delete();
	}
```
Toutes les méthodes doivent être publiques ce qui paraît logique parce que on doit les implémenter. 

Si on les met en privé il va y avoir des petits problèmes. 

Alors ce que je n'ai pas dit aussi j'en profite ça peut être une petite parenthèse c'est que des fois on peut avoir un constructeur si un jour vous récupérez par exemple le code de quelqu'un, sur un site ou une bibliothèque. 

Si vous voyez un constructeur dans une interface, ne soyez pas choqué et ne vous dites pas que c'est une erreur, c'est juste que dans certains cas, et certains usage de design patterns, de patrons de conception, je pense notamment à Factory si ça parle à des gens parmi vous, Eh bien on peut des fois à avoir besoin de définir un constructeur dans une interface. 

Ça peut arriver mais c'est évidemment beaucoup beaucoup plus rare, il faut juste savoir que ça existe. 

Alors aussi bien sûr on peut bien évidemment définir des constantes pour les interfaces. 

C'est par exemple on est on peut définir une constante pour je ne sais quoi, par exemple on peut définir le nombre d'articles par page pour ceux qui gèrent l'affichage du nombre d'articles sur une page.
```php
	interface IArticle
	{
>		const NB_ARTICLES_PAR_PAGE = 10;
		
		public function getNBComments();
		public function create();
		public function save($author, $content);
		public function delete();
	}
```
Alors par exemple si on met 10 mais ça veut dire qu'on ne peut pas le changer normalement même si ça c'est quelque chose qu'on peut changer sur un vrai site web mais nous admettons on va dire que ce sera 10 et qu'on ne le changera jamais ça.

Alors une constante définie dans une interface, pour y accéder si par exemple on veut y accéder en dehors d'une interface ou dans une classe … 

Pour y accéder vous faites tout simplement le nom de l'interface IArticle suivi du fameux opérateur de résolution de portée dont on avait déjà parlé :: et l'accès à la constante comme ça. 
```php
<?php

interface IArticle
{
	const NB_ARTICLES_PAR_PAGE = 10;
	
	public function getNBComments();
	public function create();
	public function save($author, $content);
	public function delete();
}

echo IArticle::NB_ARTICLES_PAR_PAGE;
```
Voilà et nous avons accès à la constante. 
```txt
	http://localhost/PHP/cours/026_interface/
	10
```
Alors ça c'est pratique et vous voyez c'est la même chose on n'a rien instancier. 

Il n'y a pas d'instanciation pour une interface évidemment, on n'a même pas eu besoin de créer une classe ici qui implémente l'interface c'est juste qu'elle a une constante donc c'est une valeur qui ne bougera pas sans aucun problème. 

On peut donc y accéder comme si c'était un attribut statique comme on l'avait vu sur les classes quand on fait un attribut, notamment mais pas comme un attribut statique parce que ça n'existe pas mais par exemple pour l'accès à une méthode statique quand on faisait un public static function et cetera. 

Vous voyez qu'on peut accéder en mettant le nom de la classe, les `::` et le nom de la méthode et là c'est pareil pour l'interface. 

Pour l'interface vous pouvez faire des attributs statiques et vous y Accédez de cette manière.
```php
	echo IArticle::NB_ARTICLES_PAR_PAGE;
```
Très pratique et vous verrez que dans certains cas, ça fait vraiment vraiment pas mal avancer les choses et ça peut résoudre beaucoup beaucoup de soucis que vous pourriez avoir un programmation donc n'hésitez pas à vous servir de cette fonctionnalité car c'est très intéressant. 

Voilà pour les interfaces, je vous dis voilà on était revenu sur les classes abstraites mais je pense qu'on a fait le tour. 

Retenez donc tout ce que je vous ai dit mais je ne vais pas le répéter encore une fois c'est-à-dire dans quel cas utiliser la classe abstraite et dans quel cas utiliser les interfaces. 

Après ce qui vous permettra de choisir le bon choix entre les 2, c'est la pratique et l'expérience, c'est avec le recul c'est avec tout ça au fur et à mesure que vous ferez des projets en PHP ça deviendra naturel et vous serez automatiquement voir une classe abstraite dans telle représentation, voir une interface dans telle représentation ça deviendrait tout à fait habituel. 

Je vous dis à bientôt pour la prochaine vidéo donc là on avait vu les classes abstraites et les interfaces, on va voir maintenant une autre fonctionnalité, une nouvelle fonctionnalité propre à PHP, qui est intégré dans le PHP et qui permet de faire encore d'autres choses et d'autres petites subtilités. 

C'est d'ailleurs un petit peu plus complet que les classes abstraites et les interfaces, il faudra une vidéo un petit peu plus longue je pense mais j'espère que ça vous intéressera et que ça vous plaira. 

Je voudrais à la prochaine pour la prochaine vidéo en PHP. 

Ciao tout le monde