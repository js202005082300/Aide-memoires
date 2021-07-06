/*
Java #18 - héritage

Bonjour à tous et bienvenue sur ce cours de Java. 
Comme promis nous allons aborder une autre notion du langage et plus particulièrement de la programmation orientée objet, puisque nous allons parler d'héritage.
J'en avais légèrement parlé dans les vidéos précédentes avec toutes les notions que l'on a déjà abordées jusqu'à présent, je vous expliquais que ce principe, cette notion d'héritage était déjà présente par rapport aux différentes classes que nous avons utilisé jusqu'à présent notamment pour la chaîne de caractères, tout ce qui est lecture de données et ce genre de chose.
Je vais vous montrer au travers d'un code et au travers de pas mal d'exemples pour pouvoir illustrer ce principe là et que vous voyez à quoi ça sert et comment ça se présente et comment on met en place un système d'héritage au niveau de notre code.
Alors l'héritage en programmation, c'est un petit peu comme l'héritage entre des personnes, c'est pour créer en fait une relation entre différentes classes. Nous allons voir comment.
Nous allons repartir d'un exemple de départ très simple :
*/
//import jc.entities.*;
//
//public class App
//{
//	public static void main(String[] args)
//	{
//		Horse h = new Horse("Guero");
//		h.move(167, 428);
//		
//		Pegasus p = new Pegasus("Titanus");
//		p.move(33, 146);
//		p.fly(466);	
//	}
//}
/*
Déjà en termes de fichier, on a d'abord un fichier pour l'application App.java, C'est une simple classe habituelle avec la méthode main.
Et j'ai 2 classes, une classe pour représenter un cheval et une classe pour représenter un Pégase.
Toutes les choses qui sont marqués ici ne sont que des notions qui ont déjà été vues. s'il y a des parties au niveau de ce code que vous ne comprenez pas, il faudra penser à revenir sur les anciennes vidéos parce que ce sont que des choses qui ont été abordées dans la vidéo précédente et que normalement vous êtes censé savoir-faire est censé avoir assimilé.
Pour montrer vite fait au niveau de l'architecture ou en tout cas au niveau de l'organisation des fichiers, j'ai simplement fait un package entities et j'ai mis mes 2 classes dedans.
Ici les sous dossiers j'aurais pu très bien m'en passer mais puisqu'on a appris à utiliser des package, ça ne faisait pas de mal de faire un petit rappel là-dessus, la syntaxe tout ça. 
Voilà pour cette partie. 

Horse.java
==========

Comment ça se présente? En gros, nous avons une classe qui va représenter une entité, un cheval (Horse) avec un constructeur très très simple :

	public Horse(String name)
	{
		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;
	}
On peut créer des instances de ce cheval en mettant tout simplement un nom et il va avoir une position Avec des coordonnées XY.
on peut imaginer par exemple un cheval positionné sur une interface à 2 dimensions et du coup cette interface 2 dimensions pour le positionner, on aura du coup sa position en x et en y. 

à partir de là la seule chose qui est capable de faire ce cheval, c'est de se déplacer. 

	public void move(int x, int y)
	{
		this.mPosX = x;
		this.mPosY = y;
		System.out.println("Le cheval se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");
	}

Il possède une méthode move() Qui lui permet de se déplacer avec une autre coordonnée par rapport à XY et on affiche un petit message pour s'assurer qu'on a bien fait le changement au niveau des attributs qui sont disponibles ici :

	private String mName;
	private int mPosX;
	private int mPosY;

Mais à la rigueur, on n'a même pas besoin de les voir pour comprendre comment fonctionne cette classe.

Pegasus.java
============

Pour le pégase, on se retrouve un petit peu avec la même chose, avec un nom pour le constructeur :

	public Pegasus(String name)
	{
		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;
		this.posZ = 100;
	}

… Mais nous avons une nouvelle coordonnée qui arrive, la coordonnée, la position en Z. 

Ce pégase peut également se déplacer donc à terre de manière terrestre, en XY, mais il peut aussi voler. 

	public void fly(int z)
	{
		this.mPosX = z;
		this.mPosY = y;
		System.out.println("Le Pegase s'eleve dans les airs (Z = "+this.mPosZ+")");
	}

Mais à partir du moment où il vole, il va commencer à prendre de l'altitude elle se déplaçer sur cette coordonnée Z donc lui il sera sur un environnement en 3 dimensions.

Donc il peut se déplacer en 2 dimensions mais il peut également prendre de l'altitude et voler contrairement au cheval.

Donc voilà comment se représente ce code, au niveau de ma méthode main, j'ai tout simplement créé une instance de cheval :

	Horse h = new Horse("Guero");

Je l'ai fait se déplacer avec la méthode qu'on a ici move() : 

       h.move(167, 428);

J'ai fait la même chose pour un pégase :

	Pegasus p = new Pegasus("Titanus");
	p.move(33, 146);
	p.fly(466);

C'est-à-dire se déplacer et voler tout simplement.
Encore une fois, tout ça c'est juste du rappel, ça permet encore une fois, j'en ai profité avec cet exemple de code pour faire pas mal de rappels sur la syntaxe et pas mal de choses qu'on a vu précédemment, la création de classe, les attributs, les méthodes et l'utilisation de package, d'organiser tout ça sous forme de package.

Pour l'héritage voilà du coup le schéma qu'on obtiendrait au niveau de Cette organisation.

			Object
				^
				|
	Horse ------+------ Pegasus
	move()				move()
						fly()
	
Au niveau de Java, on va utiliser pas mal d'objets d'ailleurs vous l'avez vu on a utilisé pas mal de classe StringBuilder, StringBuffer.
On avait pas mal d'exemples comme ça et au niveau de Java comme c'est un langage qui utilise le paradigme objet, toutes classes de ce type héritent… c'est-à-dire qu'elle appartient à une classe qui est au-dessus de toutes, tout simplement la classe object.
On l'a représenté ici parce que c'est la classe de Java d'ailleurs si on consulte la documentation officielle, vous verrez qui si vous aller faire rechercher une classe de la documentation, on vous indiquera qu'elle spécialise, qu'elle s'étend par rapport à cette classe object qui est vraiment la classe de départ pour toutes.
Donc comment est-ce qu'il faut le comprendre ? C'est simplement de dire que les classes qui appartiennent à Java héritent de cette classe et vous aussi.
Quand vous allez en fait créer une classe, même si dans votre code vous ne l'indiquez pas, nulle part on a dit qu'on étend ou qu'on a une classe qui héritent de object, elle se fait automatiquement, implicitement au niveau de la compilation.
Java tout simplement rajouté la spécialisation depuis cette classe object donc voilà comment on peut représenter cela sous forme de schéma c'est-à-dire de dire que nos classes ici Horse et Pegasus sont en fait des classes qui héritent de object.
Donc tout ce que possède cette classe object, qui est une classe de Java, nos classes à nous pourrons en tout cas les utiliser que ce soit les attributs, elles ont les mêmes attributs et les mêmes méthodes.
Il faut imaginer que Object est une classe mère et que toutes les classes fille possède tout ce que la mère c'est-à-dire ses attributs, son comportement, ses méthodes c'est-à-dire les services qu'elle peut faire.
Voilà c'est une chose très importante.

Voilà la relation que l'on aurait non Sans parler de cet héritage là. Pour le moment cet héritage là nous ne nous intéresse pas parce qu'il faut que vous sachiez que au niveau de Java quand vous créez une classe tout ce temps à partir de objects à chaque fois que vous créez une nouvelle classe, parce qu'on abordent le sujet sur l'héritage.

Mais nous ce qui nous intéresse, c'est qu'on n'a pas vraiment de relation d'héritage entre un cheval et un pégase pourtant on se rend très vite compte rien que au niveau du code qu'un cheval et qu'un pégase par rapport à la représentation (Horse.java et Pegasus.java) que l'on a faites sont assez similaires.

On pourrait très bien se dire qu'en fait un pégase est une sorte de cheval mais qui a des choses en plus. Donc il peut tout faire et possède le comportement d'un cheval à la différence que lui en plus de ça, il peut voler. C'est une petite chose qu'il a en plus, supplémentaire.

Donc moi j'aimerais changer cette relation et c'est là que va intervenir justement ce principe d'héritage de ne pas dire que je crée des chevaux, un cheval à part et je crée un pégase à part mais je veux pouvoir créer un cheval et si je crée un pégase je veux que mon pégase, ce soit un super cheval. En gros, c'est un cheval qui a pas mal de choses y compris des méthodes et éventuellement un comportement en plus du cheval que lui n'aurait pas.

Au niveau du schéma, je vais obtenir tout simplement :

			Object
				^
				|
			Horse
			move()				
				^
				|
			Pegasus
			move()
			fly()

En gros voilà le genre de schéma qu'on aimerait avoir.
Alors il faut fonctionner véritablement peut-être à l'envers de ce que vous pourriez penser en termes de logique, vous seriez peut-être tenté de vous dire comme le pégase a plus de choses, c'est qu'il serait mieux que le cheval entre guillemets donc il serait au-dessus.
Il faut fonctionner différemment, plus vous allez en haut et plus vous avez les entités les plus basiques Et plus on descend dans l'arbre de l'héritage et plus les classes qui en sortent en bas sont spécialisés, possède de plus en plus de choses donc en gros ici Horse à tout ce que possède object et ici Pegase aura tout ce que possède Horse qui lui-même possède déjà tout ce qu'a object.
Donc pégase possède d'ores et déjà bien tout object. Donc il y a vraiment comme ça un principe de hiérarchie ou plus vous allez comme ça au plus bas dans les classes et plus elle possède tout ce qu'on les classe en haut dont elles dépendent et comme on va créer cette relation au niveau du code parce que maintenant on vient d'expliquer le principe, le schématisé maintenant, il faut voir au niveau du code Java comment est-ce qu'on va représenter ça en termes de syntaxe. 

Représentation au niveau des classes
====================================

C'est très simple, on va garder nos 2 fichiers de classe par contre au niveau du pégase on va dire qu'il étend, "extends". On va utiliser ce mot clé là au niveau de la définition de la classe :

	package jc.entities;

       public class Pegasus extends Horse
       {
		public Pegasus(String name)
		{
			…
Va utiliser ce mot clé pour étendre notre classe cheval et là il va y avoir pas mal de petits changements au niveau de cette notation Et également pas mal de choses qui vont changer. 

Premièrement comme on l'a indiqué dans le schéma, du coup, on peut enlever la méthode move() parce que implicitement à partir du moment où on a cette relation d'héritage, on sait que pegasus possède la capacité de se déplacer de manière terrestre c'est à dire avec move() donc ici pas besoin quelque part de le refaire donc pour l'instant on va mettre se bloque entre commentaire au niveau du pégase.

//public void move(int x, int y)
//{
//	this.mPosX = x;
//	this.mPosY = y;
//	System.out.println("Le Pegase se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");
//}

Je vais vous expliquer pourquoi je le commente et je ne supprime pas tout simplement parce qu'on va revenir un petit peu dessus après.
alors comment ça se passe ? On est d'accord que le cheval, il demande simplement un nom, il va se construire suivant un nom et plus loin on a passé des valeurs brutes pour la position XY, et On voit que ces informations sont dans le bloc :

	public Horse(String name)
	{
		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;
	}
Ensuite on voit que les attributs sont passés en privé, le problème c'est que s'ils sont privés, ça on en avait parlé, ils vont en fait être privé suivant la classe c'est-à-dire que la classe gardera ses attributs pour elle mais nous on veut pouvoir comme ça pouvoir créer cette relation :

			Horse
			move()				
				^
				|
			Pegasus
			move()
			fly()

Véritablement créer cette relation d'héritage. Donc un cheval, pour nous ce n'est pas choquant qu'un pégase et accès aux attributs du cheval puisqu'il est censé lui-même les avoir. Notre pégase doit avoir les coordonnées XY et un nom que possède de base le cheval.

Donc plutôt que d'utiliser le mot clé private, on va introduire un nouveau mot-clé par rapport à l'accès aux attributs. On avait vu private, on avait vu public, J'en avais parlé concernant les méthodes notamment, y compris le constructeur ou les classes ici. Et le nouveau mot clé qui va être introduit est protected.

protected c'est tout simplement le même niveau d'accès que private sauf qu'on va permettre d'ouvrir l'accès aux classes qui font partie comme ça d'une hiérarchie d'héritage.

Donc c'est privé sauf pour les classes qui héritent entre les autres, qui ont comme ça un lien d'héritage, une relation d'héritage entre elles. Donc on va le mettre pour tous les attributs parce qu'on veut que notre pégase et ces 3 informations là :

Horse.java

	protected String mName;
	protected int mPosX;
	protected int mPosY;

Du coup pas besoin ici de faire de la redondance, c'est-à-dire que comme pegasus possède tout ce qu'a le cheval donc toutes ces informations suivantes peuvent être enlevées :

Pegasus.java

	//private String mName;
	//private int mPosX;
	//private int mPosY;
	private int mPosZ;

On garde simplement l'attribut que lui en plus parce qu'on est bien d'accord que le cheval n'a pas de coordonnée Z mais pour le pégase on met juste cette information-là : 

	private int mPosZ;

Et au niveau de cette création, au niveau de construction on a un petit peu la même chose : 

Pegasus.java

		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;

Ca on niveau de la construction dans Pegasus.java, on le fait déjà dans Horse.java, au niveau de la création du cheval, au niveau de son  constructeur.

En gros ce que l'on va faire au niveau du code, quand vous allez instancier au niveau de la programmation… Quand on va créer un pégase, en réalité, on va appeler le constructeur de cheval qui va créer en fait toute la partie cheval et ensuite on ajoutera éventuellement ce qui permet la construction d'un pégase puisqu'en fait un pégase se construit en partie suivant la construction d'un cheval.

j'essaie d'être assez clair, c'est pas évident de trouver les bons mots  pour l'expliquer mais heureusement avec le code et le schéma, on peut le faire comprendre. 

En gros, on va pas dire que tu crées un cheval qui possède une coordonnée XY et un nom et ensuite tu crées le pégase qui aura un nom et les coordonnées XY Sinon on aurait 2 instances ou en tout cas 2 animaux différents donc ça n'irait pas.

on dit simplement que notre pégase possède une partie des choses d'un cheval c'est à dire un nom, une coordonnée x et une coordonnée y donc on va utiliser le constructeur de cheval puisqu'il créé déjà tout ça mais par contre comme le pégase a besoin d'une coordonnée Z, on l'ajoutera en plus.

Donc c'est très simple pour faire tout ça, vous voyez qu'on a déjà toutes les informations : 

Horse.java

	public Horse(String name)
	{
		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;
	}

Eh bien il suffit tout simplement non pas de passer tout le code ci-dessus mais d'utiliser le mot super(); qui va tout simplement faire référence au constructeur supérieur.

Pegasus.java

	public Pegasus(String name)
	{
		super();
		//this.mName = name;
		//this.mPosX = 50;
		//this.mPosY = 50;
		this.mPosZ = 100;
	}

Super, ça veut dire supérieur. super ça veut dire en fait que quand on utilise super pour le pégase, ça signifie que tu vas utiliser le constructeur sur la classe qui vient tout juste au-dessus donc la classe parente, donc il va utiliser le constructeur pour le cheval et on lui passe le nom.

Pourquoi est-ce qu'on lui passe le nom ? Parce que je rappelle que pour construire un cheval, on a besoin d'un nom :
	
       public Horse(String name)

On a besoin d'un homme pour construire un cheval, c'est très important.
Et les positions XY, on ne le donne pas parce qu'on les met dans le block Horse, arbitrairement, on ne les fait pas passer en paramètre pour avoir quelque chose de dynamique.

Donc on a juste 2 instructions pour le constructeur de pegasus :

Pegasus.java

	public Pegasus(String name)
	{
		super();
		this.mPosZ = 100;
	}

donc même si on a l'impression Que ce n'est pas présent pour le code, à la fin notre pégase il aura bien un nom, une position en x, une position en y et une position en z.

c'est juste que pour la position en tête on l'a fait directement ici et pour le reste des informations, comme un cheval et déjà construit avec ces informations-là, on passe par son constructeur.

ça évite de répéter le code et ça évite comme ça d'avoir des choses toutes mélangées. 

Dans Pegasus.Java, on peut laisser l'attribut en private parce que je ne vais pas créer, je ne vais pas étendre la classe pégase, en gros.

Quand je dis que je ne vais pas étendre la classe pégase, je veux dire qu'il n'y aura rien qui va se spécialiser par rapport à un pégase. Elle sera en fait une classe terminale, il n'y aura rien de plus.

On verra d'ailleurs qu'il y ait il y a des petits mots clés pour dire qu'une classe n'est pas étandable. On peut utiliser un certain mot-clé en Java pour faire ça.

Donc là on a du coup un meilleur comportement.

On a géré au niveau de la construction des objets et notamment au niveau des attributs et on va passer maintenant au niveau des méthodes.

Horse.java
----------

	public void move(int x, int y)
	{
		this.mPosX = x;
		this.mPosY = y;
		System.out.println("Le cheval se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");
	}

App.java
--------

public class App
{
	Horse h = new Horse("Guero");
	h.move(167, 428);
	
	Pegasus p = new Pegasus("Titanus");
	p.move(33, 146);
	p.fly(466);
}

Ici, on voit que mon pégase au niveau de App.java, à un moment, on utilise la méthode move().
C'est pour ça qu'on a commenté la méthode move() de Pegasus.App parce que on a pas besoin de la réécrire parce que quand on va vouloir écrire que le Pégase utilise la méthode move(), qu'est-ce qu'il va se passer ?

Le langage vas chercher une méthode move() au niveau de Pegasus.java et s'il n'en trouve pas, on va voir si ta classe mère en a une donc il va remonter à la classe mère comme si il faisait un super et il va chercher une méthode move() pour Horse :

			Horse
				move()				
				^
				|
			Pegasus
				fly()

Et également, s'il n'y avait pas de méthode move(), il y aurait une erreur mais là il va la trouver donc il va utiliser la méthode move() de Horse.java
Par contre si on veut faire déplacer le pégase différemment, là du coup il faudra réécrire la méthode et on fera du coup une redéfinition, On va redéfinir la méthode move() pour dire que notre pégase peut se déplacer comme un cheval mais il va faire différemment donc du coup on réécrit la méthode, donc il faut pas qu'on ait le même code.
Si vous avez le même code dans la classe Horse et Pegasus alors ça n'ira pas, ça ne servira à rien de refaire une redéfinition, autant supprimer la méthode move() dans la classe Pegasus.
Par contre si le code dans la méthode move() de la class Pegasus diffère de ce que vous avez dans la classe mère, vous pouvez faire une redéfinition mais il faudra le réécrire.
Rem. On constate que le texte est un petit peu différent dans la méthode move() dans le fichier Horse.java parce qu'on précise cheval (même pour Pégase maintenant) dans println() donc c'est pas génial, j'aurais dû utiliser une information pour ça parce que du coup on va avoir pour pégase, la phrase avec le cheval se déplace alors que c'est un pégase. Je n'aurais pas dû mettre mon texte ici mais on va laisser comme ça et en effet puisqu'il s'agit de code identique, nous ne devrions pas refaire une redéfinition Mais on va laisser. On peut néanmoins remplacer par « l'animal se déplace » parce que nous aurions dû sortir le texte pour ne pas l'avoir dans le bloc Move. 

//System.out.println("Le cheval se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");

System.out.println("L'animal se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");

En effet, on veut éviter à refaire une redéfinition dans pegasus.java
Donc nos méthodes move(), fly() avec le cheval qui ne peut pas voler mais pégase pas de problème il pourra l'utiliser donc il faut bien comprendre que quand on fait un move() dans App.java, c'est pas quelque chose qui appartient directement au pégase, ça appartient à sa classe mère donc la classe Cheval, Horse, mais comme il en hérites, comme la classe Pegase étend la classe Cheval, Horse, et bien il peut utiliser les classes de Horse, il n'y a aucun problème par rapport à ça.

On va procéder à un test maintenant, on aurait pu tester le code avant mais ce n'est pas grave. Normalement si on a bien importé les package, c'est bon ça devrait fonctionner…

	>javac App.java
	>java App
	L'animal se deplace (X = 167, Y = 428)
	L'animal se deplace (X = 33, Y = 146)
	Le Pegase s'eleve dans les airs (Z = 466)
	
« L'animal se déplace », c'est le déplacement du cheval donc le premier move() dans main :

	Horse h = new Horse("Guero");
	h.move(167, 428);

Ensuite on a créé un pégase qu'on fait déplacer en 33/146.
Et après on voit qu'on le fait voler.

	Pegasus p = new Pegasus("Titanus");
	p.move(33, 146);
	p.fly(466);	

Donc le pégase s'élève dans les airs, z égal 466.
Voilà on a donc véritablement cette relation qui se fait : 


On n'a plus cette fois-ci 2 classes qui sont indépendantes, on a une relation d'héritage pour dire que le pégase est une sorte de cheval. 
Et si vous êtes capable de dire quand vous avez un code qu'une classe est une sorte d'une autre classe, c'est que généralement dont 99 pour 100 des cas, vous allez pouvoir créer, définir une relation d'héritage.

			Horse
				move()				
				^
				|
			Pegasus
				fly()

Un autre exemple ce serait de dire qu'un véhicule volant et une sorte de véhicule, si par exemple vous avez fait une classe véhicule, une classe véhicule volant, ben tout de suite on comprend que véhicule volant va étendre véhicule pour ce genre de choses.

ou par exemple dans un jeu vidéo, vous avez un combattant et puis vous avez un magicien. Si votre magicien est une sorte de combattant et bien magicien est une classe qui va étendre la classe combattant. voilà un petit peu le principe et ça fonctionne pour tout.

Et là ça représente des entités, l'héritage, c'est-à-dire que vous voyez des choses bien définies mais on n'est pas obligé de représenter les entités, ça peut être des concepts, des idées où ce genre de chose. 
Par exemple si vous voulez développer un lecteur audio, vous pourriez avoir une classe pour la partie gestion du son Ou alors pour la partie ensuite au niveau des différents états du son. On n'est pas obligé d'avoir que des entités. On peut avoir par exemple pour un jeu aussi, on aurait une classe qui va gérer le réseau, on peut avoir une classe qui va gérer tout ce qui est enregistrement dans des fichiers pour faire des sauvegardes, une classe pour gérer du classement, une classe pour gérer le multijoueur. 

Bref on n'est pas obligé d'avoir forcément une classe qui représenterait une entité qu'on pourrait concrétiser réellement : on crée un joueur, on crée une maison, on crée une voiture. On voit pas forcément une classe pour ce genre de chose, on l'avait d'ailleurs expliqué sur la vidéo pour la construction d'une classe, on peut vraiment créer plein d'autres choses et après dès que vous voyez qu'une relation peut se faire entre 2 classes, il n'y a pas de problème par rapport à ça.

Petite indication par contre, on ne peut pas dire qu'une classe étant plusieurs classes à la fois. Par exemple il ne serait pas possible ici de de créer une autre classe : 

					Object
^
       -----------|-----------
       ^				^
       |				|
			Horse				Autre classe
			move()				
			^
			|
			Pegasus
			fly()

… Donc il ne serait pas possible de créer une autre classe et de dire que pégase et une classe spécialisée de Horse et d'une autre en même temps, ce qu'on appelle l'héritage multiple en programmation. Il y a des langages qui le proposent meilleur Java on ne peut pas par contre plus tard on verra, on aura une vidéo dédiée sur ce qu'on appelle les interfaces qui permet un petit peu si vous voulez dire qu'une classe implémente, donc là on ne parle pas d'étendre mais d'implémentation.
Et une classe pourra appeler monter plusieurs interfaces à la fois donc c'est un petit peu un système qui évite tout simplement de faire l'héritage multiples parce que ça peut poser beaucoup de problèmes au niveau du code par contre avec les interfaces vous verrez qu'on peut faire des implémentations multiples mais on fera une vidéo dessus et on reviendra dans le détail pour parler des interfaces plus tard.
Voilà pour tous ceux qui étaient au niveau de l'héritage. 
Nous n'avons pas encore fait le tour de tout ce que l'on voulait aborder mais en gros vous savez comment créer une classe, dit une classe mère, la superclasse si vous voulez donc ici c'était Horse, vous savez comment créer une de ces classe fille donc éventuellement une classe fille donc ici c'est notre classe Pegasus. À partir de là, on a vu qu'on pouvait accéder aux choses de la classe au-dessus avec super(). 

Si on veut par exemple forcer, Si on a fait par exemple move dans Horse et ensuite admettons qu'on ai redéfini la classe move dans Pegasus. On pourrait dire qu'un cheval n'affiche pas les infos et ensuite de dire que pégase va appeler la méthode move() de Horse et après il affiche quand même le message « Le pégase se déplace » :

Horse.java

	public void move(int x, int y)
	{
		this.mPosX = x;
		this.mPosY = y;
	}

Pegasus.java

	public void move(int x, int y)
	{
		super.move(w, y);
System.out.println("Le pégase se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");
	}

Donc on dira ici que c'est le pégase qui se déplace.
et du coup, on part du principe que pour le cheval on n'affiche rien et ensuite quand on utilise cette méthode move() redéfinie, on dit tu vas utiliser tout, tu vas faire un appel à la méthode move() de la classe parente donc on utilise encore une fois le mot-clé super. On peut le faire comme ça pour appeler une méthode d'une classe parente et ensuite on a rajouté autre chose dans cette méthode pour afficher du texte.
donc on peut tout à fait utiliser ça, super peux permettre d'appeler en utilisant tout seul le constructeur de la classe parente mais si vous mettez super suivi d'un point et suivi d'un autre méthode, ben ça va chercher une méthode dans la classe parente.
Encore un nouveau mot-clé là.

On avait This, this qui fait référence à l'instance courante lorsqu'on avait vu la construction d'une classe. et maintenant nous avons un nouveau mot-clé, super, qui permet d'accéder à une information Du constructeur ou une méthode autre que le constructeur d'une classe parentes lorsqu'il y a une relation d'héritage.

J'essaie encore de rien oublier parce qu'il y a encore une fois il y a tellement de choses qu'il faudra aborder, il va y avoir pas mal de d'autres vidéos qui vont réutiliser l'héritage. On va voir d'autre chose, notamment on va parler des interfaces, on va parler des classes abstraites et on parlera du polymorphisme. Ce sera sur d'autres vidéos parce que si on avait tout mis en une seule vidéo, on aurait une vidéo de 4h pour parler de tout ça.

Le mot clé instanceof
=====================

Sur quoi peut-on terminer, on peut également vérifier puisque on crée différentes instances de quelque chose dans App.java :

import jc.entities.*;

public class App
{
	public static void main(String[] args)
	{
		Horse h = new Horse("Guero");
		h.move(167, 428);
		
		Pegasus p = new Pegasus("Titanus");
		p.move(33, 146);
		p.fly(466);	
	}
}

Pour vérifier différentes instances de quelque chose, il y a un petit mot clé très pratique en Java si par exemple à un moment donné vous avez besoin de vérifier si un objet est propre à une instance particulière. En gros, par exemple, ci-dessus, est-ce qu'on a bien un pégase et pas autre chose ? 

Ce mot clé est instanceof qui est très simple à utiliser. 
Vous pouvez par exemple vous en servir dans une condition Et vous pouvez par exemple faire ceci :
*/

import jc.entities.*;

public class App
{
	public static void main(String[] args)
	{
		Horse h = new Horse("Guero");
		h.move(167, 428);
		
		Pegasus p = new Pegasus("Titanus");
		p.move(33, 146);
		p.fly(466);	

		if(p instanceof Pegasus)
			System.out.println("C'est un pegase");
	}
}

/*
On teste si p est de l'instance pégase.
On a p qui est l'objet donc la variable qui contient notre objet suivi de instanceof et enfin le nom de la classe en question.
Si cette variable p est bien d'une instance de cette classes, de la classe pegasus et bien évidemment l'expression sera valide donc vous pourrez rentrer dans une condition.
Très pratique.
je vous donne ce petit mot clé parce que je ne pense pas que je vous l'avais donné dans une vidéo précédente donc tant que j'y pense autant que je vous le donne comme ça au moins ce sera fait et ça peut servir dans pas mal des cas et on s'en servira un peu plus lorsqu'on abordera le polymorphisme, comme ça il sera vu en avance.

Voilà pour ça, sur quoi peut-on terminer ?
Tout à l'heure je vous avais dit que pour le cas du pégase dans le schéma et on terminera cette séance avec ça, je veux en fait ne pas pouvoir permettre à l'utilisateur de dire que je vais créer une classe qui étend pégase.

Le mot clé final
================

Et pour ça nous avons un autre mot-clé qui est final.
Et final s'utilise de plein de manières. 
On peut déjà l'utiliser pour dire qu'une classe sera finale. 
Une classe finale donc avec le mot-clé final veut dire en fait qu'elle n'est non étandable, on ne pourra pas en fait créer une classe fille 2 celle-ci, qui va étendre cette classe-là.
Par exemple pour mon pégase, je peux mettre ce mot clé avant le mot-clé class et ça veut dire que je ne pourrais jamais, je ne pourrais pas m'amuser à faire une nouvelle classe qui s'appellera SuperPegasus.
En gros, je ne peux pas m'amuser à faire.

SuperPegasus.java

package jc.entities;

public class SuperPegasus extends Pegasus
{
	
}

Je ne pourrais pas du coup dire que j'ai une classe qui étend Pegasus puisque cette classe est final :

Pegasus.java
	
       public final class Pegasus extends Horse{}

Il est indiqué final donc elle est finale, elle ne peut pas être étendue ce qui est très important. Si vous voulez empêcher la possibilité d'étendre une classe, il faudra utiliser ce mot clé et du coup il sera impossible de l'éteindre.

final pour une méthode
----------------------

On peut également utiliser ce mot clé pour une méthode.
Admettons ici au niveau du cheval :

	public void move(int x, int y)
	{
		this.mPosX = x;
		this.mPosY = y;
	}

Au niveau du cheval, on dit que cette méthode move() et final, c'est à dire empêcher que les classes filles redéfinissent cette méthode. Autrement dit on va empêcher le fonctionnement de cette méthode dans les classes filles.
Pour rappel lorsqu'on avait fait le test tout à l'heure cela donnait :

Le pegase se deplace (X = 33, Y = 146)
Le Pegase s'eleve dans les airs (Z = 466)
C'est un pegase

Vous voyez, dans la première ligne, le pégase utilisait sa méthode à lui avec la phrase « le pégase se déplace ». Si je veux empêcher ça, je peux le faire ici :

Horse.java

	public final void move(int x, int y)
	{
		this.mPosX = x;
		this.mPosY = y;
	} 

Ensuite on va recompiler Et il y a une exception qui est levée :

Exception in thread "main" java.lang.VerifyError: class jc.entities.Pegasus overrides final method jc.entities.Horse.move(II)V
       at …

C'est normal qu'il y ait une exception, tout simplement parce qu'on essaie d'overrides, donc on essaie en fait de redéfinir une méthode finale mais c'est pas possible. 
Donc évidemment, on empêche absolument ça et donc là on saura qu'on ne peut pas redéfinir cette méthode dans Pegasus.java

	" Supprimer la méthode move() de pegasus. "

Donc on sera obligé de Ré utiliser la méthode dans la classe parentes et là évidemment il n'y aura plus de problème il a du coup vous constatez qu'on utilise la méthode move() du cheval Et non pas une qu'on aurait redéfini. 

Final pour un attribut 
-----------------------

On peut également l'appliquer pour un attribut si à un moment donné vous avez besoin d'avoir un attribut bien précis.
On aurait par exemple :

Horse.java

	protected final int SomeData = 14;

On déclarer un attribut, peu importe, avec une valeur parce que c'est quelque chose qui ne pourra pas bouger, tu ne pourras pas changer. Par exemple on aura une valeur, on met ici n'importe quoi pour l'exemple mais sachez qu'on peut utiliser final comme ça. 

On peut également s'en servir, par exemple dans la création de valeurs. 
Par exemple on voit qu'ici dans ce code :

	public final void move(int x, int y)
	{
		this.mPosX = x;
		this.mPosY = y;
	} 

On voit dans ce code qu'on ne modifie pas X et Y, jamais, jamais je ne modifie la valeur de X et Y donc rien ne m'empêcherait de dire ceci :

	public final void move(final int x, final int y)
	{
		this.mPosX = x;
		this.mPosY = y;
	}

Je ne modifie pas les valeurs de ces attributs-là donc on peut les indiquer final aussi.

Et enfin on peut également localement, au sein d'une méthode, si on avait besoin à un moment donné de créer une variable qu'on ne va jamais modifier :

	public final void move(final int x, final int y)
	{
		final int OTHER_COORD = 178;

		this.mPosX = x;
		this.mPosY = y;
	}

En gros c'est un petit peu comme si on levait une constante. On pourrait même la mettre en majuscule pour dire voilà qu'une fois qu'elle est déclarée, on ne pourra pas modifier ça. Donc puisqu'elle est final, on ne pourra pas là modifier. C'est une manière d'indiquer, c'est pour ajouter de la lisibilité au code pour indiquer qu'on fait ces informations-là Ne pourront pas être modifiés donc on ne changera pas leurs valeurs Donc elles sont final aussi. on utilise du coup le mot-clé final.

Donc voilà pleins de cas possible. On peut utiliser final pour une classe, pour l'empêcher d'être étendu. On peut l'utiliser sur une méthode pour l'empêcher d'être redéfinie et sur des paramètres de méthode ou même pour une variable en local pour l'empêcher tout simplement d'être modifié, pour indiquer qu'elle est final donc non modifiable. 

C'est un petit peu comme un const en C++ si vous faites de la programmation Objet. Vous savez quand programmation objet commencer plus vous pouvez utiliser le mot-clé const notamment pour faire ce genre de choses donc ici c'est un petit peu pareil donc là ici on a final qui est propre des exemples comme ça. 

Que faire avec cet héritage ?
-----------------------------

Alors que faire avec cet héritage pour terminer cette vidéo ? vous voyez que vous pouvez créer et quand vous créerez plein de classe au niveau de vos projets donc au niveau de votre programme, vous pouvez créer des relations d'héritage mais là où c'est génial aussi, ce que vous allez pouvoir sans problème prendre une classe de Java tel qu'on avait vu avec StringBuilder, rappelez-vous c'était une classe de Java qu'on avait déjà utilisé. Rien ne m'empêche, c'est tout à fait possible, sauf si bien sûr la classe c'était marqué final car rappelez-vous qu'une classe finale ne peut pas être étendu mais je peux par exemple créer ma classe à moi comme ceci :

MyStringBuilder.java

On prend ici un exemple tout simple avec MyStringBuilder.java
Il faudra bien sûr faire les importes nécessaire pour StringBuilder
De toute façon ce n'est pas pour compiler le code donc c'est pour montrer en gros.
donc ici il faudrait faire le import pour avoir tout ce qu'il faut :

MyStringBuilder.java

//import…

public class MyStringBuilder extends StringBuilder

Et on dirait simplement la classe et bien sûr vous pouvez étendre une classe native de Java, il n'est pas obligé que ce soit une classe à vous.
C'est pour dire qu'on va partir de la classe StringBuilder de Java :

MyStringBuilder.java

//import…

public class MyStringBuilder extends StringBuilder
{
	
}

Donc on repart de la classe StringBuilder de Java tels que les faites et éventuellement redéfinir certaines méthodes pour changer ce comportement, comment elle fonctionne. Vous pouvez faire ça et c'est justement tout le principe, rappelez-vous ce que je vous avais expliqué concernant l'encapsulation et tout ça, on avait pas besoin de savoir comment a été construit une classe. ce que l'on veut juste savoir c'est les méthodes qu'elles possèdent, ce qu'elles nous permettent de faire cette classe là. Et après on peut sans problème l'étendre si on veut pour changer le comportement d'une classe, pour créer une classe qui fonctionne un peu différemment mais qui se base quand même sur un modèle existant donc voilà comment on peut faire ça.

Et d'ailleurs pour terminer la séance, rappelez-vous de tout ce qui concernait les exceptions qu'on avait vu précédemment, Eh bien vous pourrez éventuellement créer une classe. Par exemple vous avez besoin de gérer un certain type de données particulières, par exemple ici on peut dire les coordonnées. On a des coordonnées précises :

Horse.java

	public Horse(String name)
	{
		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;
	}

… Et on pourrait par exemple dire, que par exemple on demande une coordonnée x et si cette coordonnées x est plus petite que 0 alors elle ne sera pas bonne peu importe la raison :

Horse.java

	public Horse(String name, int x)
	{
		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;
	}

… Peu importe la raison, On pourrait très bien dire :

Horse.java

	public Horse(String name, int x)
	{
		this.mName = name;

		if(x < 0)

		this.mPosX = 50;
		this.mPosY = 50;
	}

En gros si x est plus petit que 0, on dira de lever une exception et ça on ne l'avait pas forcément montré précédemment mais ce n'est pas grave puisqu'on voulait le garder pour ici comme on devait aborder l'héritage, c'était mieux d'attendre l'explication concernant l'héritage pour voir ça. Donc au lieu d'attendre la levée d'une exception Faites par une classe en Java automatiquement, évidemment vous pouvez vous-même manuellement lever une exception. Donc le plus simple et le plus générique, cette faire : 

Horse.java

	public Horse(String name, int x)
	{
		this.mName = name;

		if(x < 0)
			throw new Exception("La valeur de X est incorrecte");

		this.mPosX = 50;
		this.mPosY = 50;
	}

on fait donc ceci et on dit voilà un message qui serait explicite par rapport à ça. Et nous levons donc une exception. Dans l'idéal on devrait faire également ceci (throws Exception) :

Horse.java

	public Horse(String name, int x) throws Exception
	{
		this.mName = name;

		if(x < 0)
			throw new Exception("La valeur de X est incorrecte");

		this.mPosX = 50;
		this.mPosY = 50;
	}

Et là où c'est vraiment intéressant, ce que vous voyez c'est un petit peu trop générique :

	Exception("La valeur de X est incorrecte");

C'est un petit peu trop générique, un petit peu trop vague, j'en avais parlé précédemment rappelez-vous sur les exceptions. J'avais commencer un petit peu à parler d'héritage en disant qu'une exception c'est un petit peu trop vague, ça peut tous être comme exception " Exception ", Ça peut concerner un fichier, ça peut concerner une structure de données, ça peut concerner l'environnement d'exécution, Ça peut concerner une variable, et cetera et cetera. Enfin tellement des choses que c'est beaucoup trop vague. 

Eh bien rien ne nous empêcherait encore une fois, par exemple, afficher qui s'appellerait HorseException.java

Pour dire voilà qu'on a une classe pour gérer les exceptions propres au cheval même si ça semble un peu bizarre dit comme ça, on peut tout à fait faire ça et dire Que cette classe étends la classe Exception du langage Java :

HorseException.java

//import…

public class HorseException extends Exception
{
	//getMessage()
	//printStackTrace()
}

Voilà cette classe d'exception qu'en étends, ce n'est pas moi qui l'ai créé, c'est Java qui l'a créé mais on est dans cette classe et du coup, on pourra redéfinir tout un tas de choses. rappelez-vous que les exceptions notamment 2 méthodes très pratique parmi tant d'autres, qui sont getMessage(), que vous pouvez redéfinir si vous voulez, et printStackTrace(), Soit vous laisser le comportement tel qu'elles ont par défaut sans problème si vous voulez notamment changer la méthode getMessage() pour qu'elle affiche quelque chose de bien particulier concernant ainsi notre cheval et bien vous pouvez le faire aussi. 

Et à partir de là au lieu de faire "throw new Exception", on aurait simplement : 

Horse.java

	public Horse(String name, int x) throws HorseException
	{
		this.mName = name;

		if(x < 0)
			throw new HorseException("La valeur de X est incorrecte");

		this.mPosX = 50;
		this.mPosY = 50;
	}

On aurait simplement ceci c'est-à-dire que notre constructeur pourrait lever éventuellement une HorseException, notre exception à nous, notre classe à nous et dans la condition on écrirait throw new HorseException.

Voilà si vous avez compris ce que j'ai dit et je m'excuse par avance parce que c'est vraiment pas évident à expliquer et en plus de ça on a parlé d'héritage sur pas mal d'autres formations on en a parlé on C++ et Python. Et c'est vrai lorsqu'on parle des mêmes notions, qu'on répète un peu les mêmes notions mais sur pleins de langages différents, du coup on essaie de pas tout dire de la même manière mais je peux pas non plus réinventer des nouveaux mots à chaque fois. Voilà c'est pas toujours évident de l'expliquer mais si vous avez compris toutes mes explications et bien tant mieux.

Si c'est pas suffisamment clair, n'hésitez pas à revoir la vidéo un peu plus lentement aussi parce qu'on a parlé assez vite pour pas que ça traîne trop en longueur.

Et c'est vraiment vous bloquer sur des choses bien spécifiques, n'hésitez pas à poser des questions dans les commentaires parce que c'est très important de comprendre ça.

Et si vous comprenez un petit peu ce principe d'héritage, vous aurez compris énormément de choses pour la suite et ça va grandement vous faciliter la vie quand vous allez justement travailler sur de vrais projets. 

Voyez un peu le principe et surtout l'utilité de l'héritage, c'est que à partir de là on peut réutiliser du code et c'est justement tout le principe de la programmation objet. Du fait que nous travaillons avec des classes et bien ces classes et ça rejoint tout ce qu'on avait dit, on se fiche de savoir comment est-ce qu'elles ont été faites c'est-à-dire que là, je n'ai pas besoin d'aller voir dans le code Java pour voir comment sont faites la classe de Java. Je peux sans problème ici créer ma propre classe d'exception :

HorseException.java

//import…

public class HorseException extends Exception
{
	//getMessage()
	//printStackTrace()
}

On peut créer ainsi notre propre classe d'exception Sans même savoir comment a été écrite cette classe Exception qui est native de Java, juste , à partir du moment où je connais les méthodes getMessage() et printStackTrace() et ça on le trouve dans la documentation, Il n'y a pas besoin de les apprendre par cœur.

Eh bien je peux redéfinir tous les comportements que je veux et je peux ainsi avoir une classe qui va utiliser toute la puissance d'une classe native de Java mais qui sera adapté à une partie bien spécifique de mon programme parce que bien évidemment vous comprenez bien que le langage Java ne gère pas d'exception pour un cheval sinon il faudrait créer 15000 scénarios différents, il y aurait des millions et des millions de classes d'exception différentes Et le pire de ça même avec des millions et des millions, il en manquerait. 

Vous n'aurez jamais la totalité des choses puisqu'il existe en fait une infinité de possibilités. du coup voilà, vous pouvez faire ça en tant que développeur c'est-à-dire étendre des classes, que ce soit des classes native du langage (Exception) ou même vos propres classes et du coup avoir comme ça des relations, une hiérarchie bien spécifique à votre projet.

voilà je pense qu'on a fait un petit peu le tour par rapport à tout ça.

alors on n'aura pas mal d'autres choses, c'est-à-dire que toute cette partie concernant l'héritage va introduire d'autres notions très importante en programmation objet qu'on verra bien sûr dans d'autres séances.

on va s'arrêter là parce que la vidéo a été suffisamment longue pour un peu plus d'une demi-heure de vidéo donc c'est pas mal comme ça.

n'hésitez pas si vous avez des questions ou des petits soucis par rapport à ça et surtout entraînez-vous. 

L'avantage c'est qu'avec l'héritage, vous avez vraiment moyen de vous exercer, de faire votre petit programme.

Voyez qu'ici on a développé quelque chose de très simple, de simuler des personnages qu'on pourrait déplacer, tout ça.

Même s'il n'y a pas d'interface graphique, ce n'est pas grave, à partir du moment où vous avez une console, vous pouvez simuler le déplacement juste avec du texte. D'accord, vous ne verrez peut-être pas des animations ou de choses visuelles mais c'est exactement tout pareil. 

La seule différence est qu'il n'y a pas de surcouche graphique et vous pouvez simuler parfaitement tout un tas de choses comme ça au niveau de votre programme donc n'hésitez pas à vous entraîner comme ça vous comprendrez bien ce principe d'héritage. Vous pouvez toujours réutiliser ce principe de schéma même s'il n'y a pas forcément grand-chose à montrer 

			Horse
				move()				
				^
				|
			Pegasus
				fly()

Voilà même s'il n'y a pas grand-chose à montrer, si vous avez compris que tout ce qu'est une classe étendue concerne en fait sa classe parente Eh bien au moins vous aurez compris pas mal de choses par rapport à ce concept d'héritage en programmation orientée objet.

je vous dis à bientôt pour la prochaine séance de Java. 

Je pense que la prochaine fois nous parlerons de classe abstraite.

en tout cas on va aller un peu plus loin sur l'utilisation de l'héritage et des différentes classes en Java.

ciao.
*/
