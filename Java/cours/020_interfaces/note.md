# [20. Interfaces](https://www.youtube.com/watch?v=M0hkhOoOIHg)

Bonjour bienvenue sur la séance 20 pour parler des interfaces en Java, une séance qui fait suite très directement avec les classes abstraites. Notion qu'on a vu précédemment et on va compléter un petit peu en fait tout ce qu'on a vu concernant les classes abstraites pour vous parler un petit peu des interfaces et voir un petit peu ce qui est différent de la classe abstraite parce que vous verrez qu'il n'y a pas forcément énormément de choses donc on peut du coup souvent confondre les 2. Et on verra comme ça un petit usage, je vous montrerais un usage des interfaces que l'on peut retrouver.

On va partir sur un code un peu spécifique par rapport à ça :

+ App.java
```java
import jachampagne.*;

public class App
{
	public static voir main(String[] args)
   {
		Cottage c = new Cottage();
		c.build("bois");
		
		Ship s = new Ship();
		Glider g = new GLider();
		s.moveXY(146, 97);
		g.moveXY(88, 23);
	}
}
```
On part sur un code un peu spécifique par rapport à ça que je vais vous détailler très simplement et puis je vais même faire un petit schéma pour que vous puissiez comprendre. 

Donc en gros, je vais vous montrer comme ça.
```txt
	Vehicule (abstract)			Building (abstract)
		    ^						^
		    |						|
Ship ------------- Glider			Cottage
```

Nous avons une classe abstraite qui représente un véhicule et de cette classe abstraite nous avons étendue deux classes, donc crèer deux classes, une qui représente un navire et notre qui va représenter un planeur. Ce sont des sortes de véhicules qui retrouve comme ça ce lien, Cette hiérarchie lié à l'héritage justement.
Et de l'autre côté, là on n'est pas du tout avec quelque chose lié étroitement véhicules, c'est vraiment autre chose. Nous avons une classe, pareil, qui est abstraite qui représente un bâtiment une construction fait (Building).
Et issu de ça, J'en ai fait qu'une seule parce que je n'allais pas faire 300 fichiers de classe différente mais je voulais juste en faire quelques-uns pour l'exercice pour que vous ayez un exemple suffisamment parlant.
Et on a un cottage qui représentera une chaumière, une sorte de bâtiment enfaite tout simplement qui est ici concret. 
Voilà un petit peu ce que ça représente en termes de schéma ce que ça représente. 
Donc on a se classe là (Ship et Guilder), 2 classes étroitement liées via héritage sur une classe abstraite et à côté une classe toute seule (Cottage) mais j'aurais pu en crèer 2, 3, 4, plein d'autres si j'avais voulu pour compléter un peu plus. 
Donc en termes de code, ça se prèsente comme ça :

+ App.java
```java
import jachampagne.*;

public class App
{
	public static voir main(String[] args)
    {
		Cottage c = new Cottage();
		c.build("bois");
		
		Ship s = new Ship();
		Glider g = new GLider();
		s.moveXY(146, 97);
		g.moveXY(88, 23);
	}
}
```
Donc pour véhicule : 
+ Vehicle.java
```java
package jachampagne;

abstract public class Vehicle
{
	protected int mMovementSpeed;
	abstract public voir moveXY(int x, int y);
}
```
Donc pour le véhicule, je vais aller très très vite parce que ce sont des choses qu'on a déjà vu plein de fois et voilà maintenant au niveau des classes abstraites, on l'a abordé aussi mais en gros ici notre véhicule possède qu'un seul état, donc ici un seul attribut qui est une vitesse de déplacement et on indique après, une méthode abstraite, c'est le cas parce qu'on ne l'implémente pas ici. Cette méthode va permettre de déplacer ce véhicule a une position XY.

De là notre navire :

+ Ship.java
```java
package jachampagne;

public class Ship extends Vehicle
{
	public Ship()
	{
		this.mMovementSpeed = 16;
    }
    
    public void moveXY(int x, int y)
    {
    	System.out.println("Le navire brasse les flots et se déplace en " + x + ", " + y);
    }
}
```

De là notre navire, quand on crèe un bateau, il a une vitesse par défaut qui est indiquée Et moi je me suis décidée pour l'exemple que la vitesse de déplacement, c'est du kilomètre par heure et comme un bateau se déplace en noeuds, ici on aurait quelque chose qui se déplace aux alentours de 9 noeuds ça correspond à grosso modo pour ceux qui seraient curieux, à du 16 kilomètres heure à peu près.

Et ensuite le déplacement, pour faire quelque chose de très simple pour notre exemple ici, j'ai simplement un texte qui indique que le navire voilà brasse les flots, se déplace et il affiche les coordonnées.

Pour le planeur : 

+ Glider.java
```java
package jachampagne;

public class Glider extends Vehicle
{
	public Glider()
	{
		this.mMovementSpeed = 28;
	}
	public void moveXY(int x, int y)
	{
		System.out.println("Le planeur fend l'air vers " + x + ", " + y);
    }
}
```

Pour le planeur, évidemment donc lui, au niveau de la construction il a une autre vitesse de déplacement, donc lui il se déplace plus vite, à 28 kilomètres heure donc voilà c'est un planeur propulsé, très rapide.

Et pareil, comme dans Vehicule.java, au niveau des véhicules, nous avions une méthode abstraite "abstract public voir moveXY(int x, int y)", elle doit être obligatoirement implémenté dans les classes concrêtes puisque ici notre planeur ne se déplace pas pareil. 

Et naturellement comme ici un planeur et un navire sont étroitement liés par le fait qu'ils ont ici un même état, c'est-à-dire notamment leur vitesse de déplacement "mMovementSpeed". Voilà c'est un élément commun à ces deux classes et notamment au moyen de se déplacer. Donc on a une classe abstraite et ensuite on crèe comme ça des classes concrête (voir schéma). Donc ça c'est le principe et ce qu'on avait vu précédemment de la classe abstraite. Encore une fois ça permet de factoriser du code quand on trouve des liens étroits entre plusieurs classes et des éléments communs, C'est à ça que sert une classe abstraite et c'est à ça qu'elle doit servir. 

Pour le Building :

+ Building.java
```java
package jachampagne;

abstract public class Building
{
	abstract void build(String material);
}
```
A côté, pour building donc ici pour représenter un bâtiment une construction, J'ai quelque chose de plus court, c'est simplement une méthode abstraite pour construire un bâtiment et qui indiquera et là il aurait fallu éventuellement faire une autre classe encore à part mais je ne voulais pas trop en rajouter donc j'ai mis à la place une chaîne de caractères pour dire que voilà je construis un bâtiment "build" selon un type de matériau "String material".

Et pour la chaumière :

+ Cottage.java
```java
package jachampagne;

public class Cottage extends Building
{
	public Cottage()
    {
    	System.out.println("Parcelle en place...");
    }
    public void build(String material)
    {
    	System.out.println("Construction du batiment en " + material);
    }
}
```
Et pour la chaumière, donc ce qui représente une chaumière. Donc on a le constructeur avec une parcelle qui se met en place comme si on construisait la mise en place de la parcelle et on implémente la méthode qui à la base est abstraite par rapport à un certain type de matériau donc ça permettra de construire le bâtiment en bois, en pierre et cetera de cette manière. 

J'espère qu'ici c'est clair jusqu'à prèsent, s'il y a des choses qui ne sont déjà pas clair à partir de là, vous revenez sur la vidéo d'avant concernant la construction d'une classe, les classes abstraites, les attributs, les méthodes, il faut revoir toutes ces choses-là s'il a tout de suite vous êtes déjà perdu. 

Et maintenant, il faut imaginer que c'est la reprèsentation de mon projet et moi j'ai envie de faire un truc, on est d'accord qu'ici en planeur c'est quelque chose qui peut planer donc en gros c'est quelque chose qui peut voler, qui a possibilité de se déplacer dans les airs. 
Donc on pourrait se dire naturellement, ici je vais permettre à mon planeur de voler tout simplement (fly).

+ Glider.java
```java
package jachampagne;

public class Glider extends Vehicle
{
	public Glider()
	{
		this.mMovementSpeed = 28;
	}
	public void moveXY(int x, int y)
	{
		System.out.println("Le planeur fend l'air vers " + x + ", " + y);
    }
	public void fly()
    {
       	//il vole...
    }
}
```
On ne sait pas comment mais en gros, il vole d'une certaine manière. C'est un peu embêtant, maintenant, plus tard, dans une évolution future, je pourrais avoir un autre véhicule genre en avion, quelque chose qui représenterait un avion Virgule quelque chose qui représenterait un vaisseau spatial ou une soucoupe volante où je-ne-sais-quoi il faudrait forcément lui permettre de voler donc qu'est-ce qu'on s'amuserait à faire ? Eh bien on serait en train de crèer une classe concrête qui devrait voler aussi mais on a une répétition de code. 

Vous voyez il y aura le problème parce qu'on aurait ici la répétition du code Fly pour ça (Glider.java) et on aurait une répétition ailleurs.

La logique de la classe abstraite voudrais que quand on a comme ça des choses communes, des liens étroits en fait, on utilise cette fameuse classe abstraite donc on serait tenté de se dire bah que dans la classe abstraite qui représente un véhicule (Vehicule.java), on va faire fly() : 

+ Vehicle.java
```java
package jachampagne;

abstract public class Vehicle
{
	protected int mMovementSpeed;

	abstract public voir moveXY(int x, int y);
	abstract public void fly();
}
```
On y fait fly(), on s'en fiche comment il vole mais là en terme d'implémentation, là où on essaie de résoudre un problème, on en a ajouté un nouveau c'est-à-dire que là on considère (Vehicule.java) que tous nos véhicules que nous allons concrêtement crèer, devront implémenter une méthode pour se déplacer donc ça OK ils devront implémenter une méthode pour voler. Le problème, on va partir du principe que nos navires, nos bateaux vont voler, c'est un petit peu embêtant car si nous on veut des bateaux normaux qui se déplacent sur les eaux, on ne veut pas des bateaux qui veulent. On n'est pas dans Petter Pan. C'est un petit peu embêtant par rapport à ça.Donc là on voit tout de suite qu'il y a un problème dans la conception d'une implémentation ce n'est pas possible, on ne peut pas faire comme ça (retirer abstract public void fly()).

+ Vehicle.java
```java
package jachampagne;

abstract public class Vehicle
{
	protected int mMovementSpeed;

	abstract public voir moveXY(int x, int y);
}
```
Autre possibilité, autre scénario. Tout ce qu'on vient de faire on peut l'oublier. On prend un autre scénario, que ce soit quelqu'un de l'extérieur, que vous travaillez pour un client ou même vous-même, vous êtes sur un jeu et on peut dire que cela ce sont des classes pour un jeu vidéo, admettons. Et vous voulez justement vous tapez le délire et Ben tiens, le planeur, on est d'accord, il vole et puis éventuellement mais là je n'ai que deux classes mais imaginer qu'il pourrait y en avoir beaucoup plus, on pourrait avoir plein d'autres types de véhicules, tout ça.Puis là je me dis, après tout faire un navire volant, ça peut-être sympa, ça peut-être cool comme idée et même sans parler de ça, juste le planeur, le planeur ça vol. On peut faire un planeur qui veulent, un planeur autopropulsé qui du coup ne ferait pas que de planer mais volerait vraiment et on peut se taper le délire de se dire aussi que j'aimerais bien dans mon jeu me faire une maison, une construction qui est dans les airs, une construction volante qui pourrait se déplacer dans les airs donc moi ici ma chaumière j'aimerais qu'elle puisse voler. 

Alors il y aura peut-être d'autres types d'habitation, des chalets, des manoirs mais je ne veux pas qu'ils volent mais la chaumière que je représente ici avec la classe Cottage, j'ai envie qu'elle vol.

J'ai envie que Cottage vole comme un Glider autopropulsé pourrait voler. 

On pourrait d'ailleurs faire une classe spécialisée pour dire que le Glider, le planeur, il ne fait que planer tel quel, et on crèe une version plus spécifique avec un planeur avec un système de propulsion mais on ne va pas non plus trop compliquer, on va dire l'exemple (Schéma). 

Donc là il y a autre chose, mon planeur, je veux qu'il vole et éventuellement le navire, et je veux que ma chaumière, elle vol sauf qu'on a bien vu et en tout cas on le voit ici au niveau du schéma que ce sont 2 choses séparées, ce sont 2 choses indépendantes donc évidemment et c'est le principe de tout ce que je vous ai expliqué concernant la classe abstraite, il ne serait absolument pas possible et absolument pas cohérent d'un point de vue lien étroit de se dire : 
```txt
    FlyingElement
    ^		^
    |		|
Ship		Cottage
```
En gros, par exemple, on aurait FlyingElement pour dire qu'on a un élément fait quelque chose qui vol, un truc comme ça.Et après on aurait un truc du genre, on va prendre le navire et au même niveau on va avoir notre chaumière et alors ici pas de problème on se dit qu'on va faire une classe abstraite. 

FlyingElement, ce sera une classe abstraite. On pourrait se dire ça, après tout il y a un élément commun Est-ce qu'on voudrait que tous les 2 vollent donc pourquoi est-ce qu'on ne pourrait pas faire ça.

Le problème, c'est que Cottage, une chaumière par rapport à la reprèsentation :
```txt
	Vehicule (abstract)			Building (abstract)
		    ^						^
		    |						|
Ship ------------- Glider			Cottage
```
En tout cas par rapport à cette reprèsentation, ce ne sont pas des choses étroitement liées. On est parfaitement d'accord pour se dire qu'une chaumière c'est carrément différent d'un navire dans ce cas là. 

Et si on commence a tout liés, on va se retrouver avec toutes les classes de notre projet qui seront absolument toutes liées ensemble. Et ce ne serait absolument pas du tout cohérent parce qu'on pourrait trouver si on veut, si on chipotte, on pourrait trouver des liens en tout. On pourrait par exemple trouver un lien Entre un planeur et une chaumière, entre une construction et un véhicule, si on veut on peut le trouver. 

On peut toujours trouver un lien quelconque, pas forcément cohérent mais il y a toujours moyen de trouver un lien.

Donc ce n'est pas possible parce que la classe encore une fois abstraite permet elle doit servir à factoriser du code, encore une fois quand il y a des classes qui sont étroitement liés. 

Là pour moi la chaumière, ce n'est pas étroitement lié à un navire, ce n'est pas étroitement lié à un planeur donc la solution de la classe abstraite ne va pas. 

Et c'est là qu'intervient le sujet de cette séance, les interfaces. 

En gros je vais déjà faire un petit schéma pour vous montrer en quoi ça consisterait simplement. Je vais fournir ce qu'on appelle un contrat, c'est le terme qu'on emploie généralesment quand on parle d'interface. 

Quand on parle d'interface, on parle de contrat, moi je n'aime pas spécialement ce mot parce que je trouve qu'expliquer ça à quelqu'un qui débute en lui disant bah tiens voilà "une interface c'est un contrat", je pense qu'il y a plein de gens qui ne vont pas forcément comprendre. 

Donc on va développer un peu plus cela mais le contrat c'est un peu quoi ? Ben moi, l'interface je préfère dire, l'interface est un petit peu comme la carte d'un menu dans un restaurant.

En gros on vous fournit une carte, et en gros il y a tout un tas de choses qui sont indiquées là-dessus. Et quand on va dans un restaurant vous comprenez un petit peu le principe non, Vous pouvez demander n'importe quoi de ce qui est indiqué sur votre carte et il y a un cuisinier qui va cuisiner le plat. Donc si vous voulez un pavé de boeuf, si vous voulez une salade, il le fera et cetera.

Donc il y a un contrat engagement, bah tiens on vous fournit une liste de choses et vous choisissez là-dedans et on va pouvoir nous en faire quelque chose et vous fournir ceci. Donc il y a un contrat. 

Donc comment ça se fait en termes d'informatique de programmation ? Parce que là c'est un peu plus autre chose. Vous avez certainement déjà entendu parler vous avez déjà entendu le nom d'API, A.P.I. Si on emploie le terme anglais qui est en fait une simple interface qui des fois ça a l'air d'un mot compliqué mais pas du tout. 

Une API, en fait, c'est une interface, C'est un contrats. En gros on va vous dire ici elle a pour rejoindre l'exemple de ce que je voulais faire( schéma). Moi je veux faire une interface donc voyez je fais une grosse interface (schéma d'un carré). 

Je vais appeler cette interface volante, Flyable. Je vais dire voilà, je fournis un contrat qui dit voilà on va pouvoir avoir quelque chose de volant mais encore une fois lorsque vous allez dans un restaurant pour une carte, quand vous voyez marquer pavé de saumon, tagliatelles et cetera. Vous ne savez pas comment cuisinier va préparer et à la rigueur vous vous en fichez. Vous vous allez payer votre menu. Vous voulez votre pavé de saumon et votre tagliatelles, peu importe comment le cuisinier le prépare, il faut que ce soit bon, il faut que ce soit frais parce que c'est quand même mieux dans un resto est terminée. Vous ne vous occupez pas de la manière dont le cuisinier va en fait implémenter la recette. Vous vous savez juste qui peut vous faire un pavé de saumon Avec des tagliatelles comme menu et c'est tout. 

Moi je vous fournis une API, on va crèer puisqu'on a le développeur ici, on va crèer une interface en Java puisqu'on parle de Java qui est en fait une API pour crèer quelque chose de volant, on ne sait pas quoi. C'est juste une interface comme ça : 
```txt
+--------------------------------------------+
|								             |
|			Flyable				             |
|								             |
+--------------------------------------------+
```
Volant, on a une interface comme ça et cette interface.

Cette interface elle sera complètement à part, elle va avoir tout un tas de chose mais là on ne parle pas vraiment de code, on schématise juste un peu la chose. Tout élément qui aura besoin d'implémenter ça (Flyable) comme fonctionnalité c'est à dire que tu aurais besoin de voler, d'être volant, et bien on va lui dire tu vas l'implémenter. 

C'est bien parce que c'est exactement ce que j'ai donc si je voulais schématiser en gros, je dirais qu'ici ma chaumière (Cottage), je veux qu'elle puisse voler donc elle va implémenter mon interface Flyale.
```txt
	Vehicule (abstract)		Flyable	    Building (abstract)
		        ^			      ^	    ^
		        |			      |	    |
    Glider ------------- Ship	  +----	Cottage 
```
On implémente l'interface Flyable, attention ce n'est pas de l'héritage, c'est de l'implémentation mais comme ici je ne veux pas forcément faire des flêches différentes comme de toute façon je vous parle en même temps que je fais les flêches, vous comprenez bien ce que je veux dire. 

Et là pareil, mon navire il fait ça.

```txt
	Vehicule (abstract)		Flyable	    Building (abstract)
		        ^			    ^ ^		^
		        |			    | |		|
    Glider ------------- Ship --+ +---- Cottage 
```
Donc Flyable, c'est vraiment une interface donc une surcouche d'abstractions, ça veut dire on te dit juste qu'on va faire voler, il y a une interface pour permettre le vol mais sans forcément se poser la question de comment on va le faire parce qu'on est d'accord qu'on ne fera pas voler un bâtiment. Comment on va faire voler un navire et on s'en fiche puisque c'est dans la classe du navire qu'on va implémenter cette interface. 

Qu'est-ce qu'on va dire sur le navire ? pour voler ? pour être quelque chose de volant, il va le faire de telle manière et la chaumière, elle va le faire de telle manière et si un jour parce que c'est important la programmation objet encore une fois permet de ça, elle sert à réutiliser le code et faire évoluer le code. Et si un jour, que ce soit vous en tant que développeur ou n'importe qui en tant que développeur qui viendrait à reprendre votre code, ce dit bah moi, ça y est je veux faire une voiture ; admettons il fait une nouvelle classe voiture je veux qu'elle puisse être une voiture volante, et bien il fera pareil : "ma voiture, elle va implémenter cette interface Flyable." 

Et il dirait lui dans son code, vous voyez il n'a pas besoin de retoucher au code dans l'interface Flyable ou du code dans Vehicule ou je ne sais quoi. C'est juste lui dans son propre code sans avoir à casser le reste sans même savoir à la rigueur ce qu'il y a dans le reste du code. Il dira : "Ben moi, voilà,  ma voiture elle vole." et comment elle vol? "Et bien, de telle manière." Et il le fera dans sa propre implémentation. 

Voilà le principe d'une interface, c'est une couche d'abstraction qui établit en fait un contrat et qui du coup vous pouvez implémenter dans n'importe quelle classe, n'importe quelle entité, concept et cetera dans votre code, qui aurait besoin d'utiliser en fait cette fonctionnalité, de se servir de cette API. 

Ici l'API, c'est le fait d'avoir quelque chose de volant, c'est un petit peu quelque chose de compliqué à expliquer parce que volant c'est un terme un peu spécial. Pourquoi est-ce que j'ai marqué Flyable de telle sorte comme ça ? 
```txt
+--------------------------------------------+
|								             |
|			Flyable				             |
|								             |
+--------------------------------------------+
```
Pourquoi est-ce que j'ai marqué Flyable de telle sorte comme ça ? Parce que j'avais utilisé un petit peu ce principe, parce que si on regarde la doc de Java, vous allez retrouver par exemple : une classe qui s'appelle, c'est une interface en réalité mais c'est un petit peu une classe un peu spéciale en fait les interfaces, je pense que vous avez un petit peu pigé le truc. Et donc ici on a une interface à Java qui s'appelle Comparable :

[https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)  

Et donc Comparable, juste par le nom, je pense que vous avez compris à quoi allait servir cette interface. Je pense que vous avez bien compris que ça allait permettre de comparer des éléments, des choses. On n'a pas encore vu les template, tout ça, on en a pas encore parlà sur ce cours mais en gros ça veut dire que cette interface, elle va permettre de comparer des éléments de n'importe quel type et on ne sait pas à l'avance quels seront ces types mais c'est pas grave. 

Et si on veut un peu plus loin dans cette doc, on va trouver par exemple une classe, par exemple la classe double pour les nombres à virgule, Calendar, Byte, Vous voyez on retrouve un petit peu tous les types de données, qu'est-ce qu'on retrouve aussi ? On retrouve Year, Date, On retrouve des choses concernant la manipulation date. On a time par exemple, ce genre de chose. 

Et du coup dans ces classes qui vont implémenter les interfaces, on dira et bah voilà un temps on va le comparer de telle manière mais le temps virgule on ne va pas le comparer comme des annexes, on ne va pas non plus le comparer comme un nombre, un Byte, on va pas le comparer comme un double, on va pas le comparer comme un calendrier, on va pas le comparer comme un caractère et cetera et cetera et cetera. 

Et peu importe, nous tout ce qu'on veut savoir, c'est juste qu'il y a une API qui nous dit que l'on va pouvoir ajouter une fonctionnalité à n'importe quelle classe que l'on veut pour lui permettre comme ça de comparer des éléments. Voilà le principe donc ça c'est un exemple suffisamment parlant et en Java. 

Dans d'autres langages pour indiquer le nom d'une interface, on met souvent I majuscule devant ici en Java vous remarquerez que les interfaces ont souvent le terme "able" à la fin, quelque chose comme ça en able. C'est un objectif pour dire comparable, clonable, réalisable, readable pour dire lisible par exemple et on retrouve toujours un petit peu ce terme-là. 

Pour qu'on reste un petit peu dans les conventions de nommage de Java, nous avons appelà notre interface Flyable pour dire volant, c'est un objectif par rapport à ça.

## Interface en termes de code

Voilà ça ce sont des explications, c'est le schéma c'est bien beau Mais maintenant en termes de code comment est-ce que ça se met en place. Comment est-ce qu'on met en place cette interface ? 

Maintenant vous savez qu'il faut faire comme ça et cette interface va permettre de corriger le problème qu'on avait montré tout à l'heure, la fameuse méthode abstraite Fly qui du coup n'irai pas du tout parce que ça nous obligerait à rendre tous nos véhicules volants. En gros, si vous faites une moto il faudrait quel vol, si vous faites une voiture il faudra quel vol et ce n'est pas du tout ce qu'on veut.

Donc on va faire une interface. 

Donc une interface en fait c'est comme une classe quelque part, on ne va pas trop s'embêter là-dessus. 

Comment est-ce que je peux faire ça ? 

On va crèer notre fichier qu'on va appeler Flyable.java

Vous voyez je le mets dans le fichier de classe, je laisse ça là-dessus, toujours dans mon package.
```java
       package jachampagne;
```
Et à partir de là, il va y avoir des petits changements en termes de syntaxe.

Donc là on attaque vraiment la syntaxe :

+ Flyable.java
```java
package jachampagne;

interface Flyable
{
	
}
```

On n'est pas sur le terme classe parce qu'il faut bien les différencier. 

déjà une interface, il faut savoir que il y a en terme de syntaxe, des règles importantes.

une interface c'est, en terme de syntaxe seulement, pas dans le comportement dans la manière dans lequel on doit s'en servir, c'est pour ça qu'on ne doit pas confondre les 2 mais juste en terme de syntaxe pure Et bien une interface est simplement une classe abstraite dans toutes les méthodes sont abstraites d'accord c'est-à-dire qu'il n'y a pas de méthode qui serait déjà implémenté où ce genre de chose même s'il y a une petite exception depuis la version 8 de Java mais on va en parler sur la séance.

En gros tout est public et tout est abstrait par défaut donc vous n'avez pas besoin de mettre le mot-clà abstract pour méthode et vous n'avez pas besoin non plus mais vous pouvez toujours le mettre à titre indicatif, le mot clà publique. 

Moi par exemple je ne mettrais que le mot public, C'est assez rare qu'on met le mot clà abstract dans les interfaces mais si vous voulez le mettre il n'y a pas de problème. Si pour vous c'est plus compréhensible de faire comme ça pour être sûr que vous comprenez bien les choses, mettez le il n'y a aucun problème avec ça.

Et comment ça fonctionne ? Eh bien dans cette interface je vais dire que on aura différentes choses, différentes méthodes, différents comportements qui vont permettre de faire voler, on ne sait pas quoi mais au final on pourra faire voler une chaumière (Cottage), un navire (Ship), peut-être une moto, ce qu'on veut en fait, peu importe. 
Donc moi je vais rester sur quelque chose de très simple parce que pour le moment je ne vais pas faire non plus 15 milles exemples mais je vais juste dire que j'ai une méthode Fly. 

+ Flyable.java
```java
package jachampagne;

interface Flyable
{
	public void fly(String energy);
}
```
J'ai donc une méthode Fly et par exemple je vais utiliser une chaîne de caractères parce que je ne vais pas crèer une autre classe non plus mais genre quelque chose qui représenterait une énergie pour pouvoir voler et c'est tout, mon interface est terminée.

Mon interface est terminée, alors une interface pour information c'est, comme une classe abstraite peut étendre une autre classe abstraite comme je l'avais déjà dit sur la séance précédente. Une interface peut étendre une autre interface pour cela il faudra utiliser comme pour la classe le mot-clà "extends"

+ Flyable.java
```java
package jachampagne;

interface Flyable extends ...
{
	public void fly(String energy);
}
```
Donc voilà si vous avez une hiérarchie d'interfaces comme on aurait une hiérarchie de classes, vous utilisez comme pour les classes, le mots clés extends. par contre dés qu'une classe doit utiliser une interface donc l'implémenter obligatoirement, il faudra utiliser le mot clà "implements".

Donc ça c'est simple même si ce sont des mots-clés anglais, c'est facilement lisible même pour nous français, francophone, c'est facile d'utiliser ce terme là. 

Maintenant comment j'implémente cette interface ? Comment je peux rendre mon navire volant ? Regarder c'est très très simple en termes de code, c'est juste ça.

On met d'abord tout ce qui est extension d'abord, c'est important il faut toujours mettre l'extension d'une classe. D'ailleurs en Java et puisqu'il y a des langages qui font un peu exception Mais on ne peut pas faire d'héritage multiple c'est-à-dire qu'une classe peut en étendre qu'une seule. On ne peut pas avoir une classe qui hérité de 2 ou 3 ou 4 ou plus de classe, il n'y en a qu'une seule. 

Par contre et c'est aussi l'avantage de l'interface, c'est une classe elle peut implémenter autant d'interfaces que vous voulez donc on peut faire de l'implémentation multiple d'interfaces et on les met toujours en dernier, donc on fait :

+ Ship.java
```java
package jachampagne;

public class Ship extends Vehicle implements Flyable
{
	public Ship()
	{
		this.mMovementSpeed = 16;
    }
    
    public void moveXY(int x, int y)
    {
    	System.out.println("Le navire brasse les flots et se déplace en " + x + ", " + y);
    }
}
```
Donc là, on mais implements Flyable. s'il y en avait d'autres on en mettre d'autres, on mettra une virgule puis autre chose, n'importe quelle autre interface comme ça vous les séparés par des virgules et c'est tout. 

Là c'est la syntaxe (implements Flyable) pour dire mon avis va implémenter l'interface Flyable par contre comme ça, envoyer que rien n'est implémenté (Flyable.java) :

+ Flyable.java
```java
package jachampagne;

interface Flyable
{
	public void fly(String energy);
}
```
Vous voyez que rien n'est implémenté, c'est le principe d'une interface, il n'y a aucune implémentation Ici (Flyable.java). On verra encore une fois qu'il y a une petite exception pour terminer la vidéo.

Eh bien il va falloir l'implémenter. Donc ici c'est bien, tu as dit que tu voulais que ton navire vole, maintenant il faudrait que tu nous expliques comment il vole ? Quand je dis qu'il faudrait que tu nous expliques, c'est le compilateur, il va avoir besoin De dire comment est-ce qu'on va faire voler le navire.

Donc comme pour une classe abstraite, où on aurait pour le coup une classe concrête où Il faudrait implémenter les méthodes abstraite, ici (Ship.java), implémente la méthode abstraite de l'interface pour dire Ben voilà le navire il va voler comme ça.

Donc on va mettre un petit texte simple pour faire quelque chose de pas trop compliqué. par exemple on va mettre, je me propulse dans les airs et cetera.

+ Ship.java
```java
package jachampagne;

public class Ship extends Vehicle implements Flyable
{
	public Ship()
	{
		this.mMovementSpeed = 16;
    }
    
    public void moveXY(int x, int y)
    {
    	System.out.println("Le navire brasse les flots et se déplace en " + x + ", " + y);
    }
    
    void fly(String energy)
    {
    	System.out.println("Je me propulse dans les airs avec du " + energy);
    }
       
}
```
Donc on est très, je me propose dans les airs avec du et on mettrait tout simplement le nom de l'énergie. Je fais très très simple internet exemple pour le code. Je ne vais pas en faire plus je pense qu'un texte est suffisamment explicite pour ça.

Et voilà c'est bon, vous avez implémenté le vol pour votre véhicule. Et voyez, je n'ai jamais eu besoin de toucher à Vehicle.java, ni à quoi que ce soit. 

C'est juste que si j'ai un élément ou je dis celui-là, cet élément-là, cette classe, je veux qu'elle puisse voler que mon navire puisse voler Eh bien c'est lui (Ship.java) que je modifie. 

Et si à un moment donné on a besoin de rajouter d'autres possibilités (Flyable.java) Eh bien on rajoutera une autre méthode. Je ne sais pas, on pourra dire par exemple boost, un truc qui permettrais de booster la vitesse :

+ Flyable.java
```java
package jachampagne;

interface Flyable
{
	public void fly(String energy);
	public void boost(int x);
}
```
Et puis par exemple, on pourrait rajouter un multiplicateur de vitesse, quelque chose pour vous dire tiens je boost par 2, par 3, par 10 et cetera. 

Et à partir de là, en changeant l'interface, il faudrait évidemment l'implémenter (Shipt.java), alors ton navire comment est-ce qu'il se boost, comment est-ce qu'il boost sa vitesse? Et si tu veux que ta chaumière vole, comment est-ce qu'elle boosterait stress à vitesse ? D'accord c'est important. à partir du moment où vous avez différentes méthodes, il faut comme pour les classes abstraites, obligatoirement, qu'est-ce qui les implémente, implémente également toutes ces méthodes. 

Donc s'il y a 10 méthodes dans votre interface, il faudrait implémenter 10 méthodes dans chaque classe qui implémente cette interface, très important. De toute façon si vous ne le faites pas vous aurez une erreur à la compilation. Java vous le rappellera très très vite.

+ Flyable.java
```java
package jachampagne;

interface Flyable
{
	public void fly(String energy);
}
```
C'est pas tout c'est pas fini, ici il faut pareil. On fait un copier coller de Ship.java à Cottage.java. 
```java
       void fly(String energy)
       {
       	System.out.println("Je me propulse dans les airs avec du " + energy);
       }
```
On aime bien faire un copier coller en informatique parce que je veux que Cottage.java l'utiliser aussi. Donc très simple aussi, regarder je veux que ma chaumière vole et bien je lui implémente l'interface pour voler (implements Flyable). 

+ Cottage.java
```java
package jachampagne;

public class Cottage extends Building implements Flyable
{
	public Cottage()
    {
    	System.out.println("Parcelle en place...");
    }
    public void build(String material)
    {
    	System.out.println("Construction du batiment en " + material);
    }
    void fly(String energy)
    {
    	System.out.println("Je me propulse dans les airs avec du " + energy);
    }
}
```
Elle implémente l'interface pour voler à la classe Cottage. On l'a propulsé dans les airs avec quelque chose, on verra comment. 

Du coup (App.java), on va peut-être juste enlever ces exemples là (voir précédent).

+ App.java
```java
import jachampagne.*;

public class App
{
	public static voir main(String[] args)
     {
		Cottage c = new Cottage();
		Ship s = new Ship();
	}
}
```
Et on va les faire voler, on va faire voler notre chaumière. Vous voyez très simple.

+ App.java
```java
import jachampagne.*;

public class App
{
	public static void main(String[] args)
   {
		Cottage c = new Cottage();
		Ship s = new Ship();

		c.fly("Carbone");
		s.fly("Mana");
	}
}
```
on va faire voler notre chaumière. Vous voyez très simple. On va faire c.fly(""). Ensuite en termes de nom pour l'énergie, ok allez on va dire au carbone, c.fly("Carbone"). Et le navire, on a qu'a dire, lui son énergie c'est de la magie s.fly("Mana"), Comme dans les jeux vidéo la mana c'est de la magie. 

C'est quelque chose de magique, c'est la mana qui lui permet de voler. 

Et vous voyez c'est tout, juste ça.

J'ai pas eu besoin moment de dire Eh bien dire que le véhicule à un moment donné il va devoir changer car comme Ship est une sorte de véhicule donc du coup il faut bien indiquer que véhicule peut voler, et bien non car tout nos véhicules, on ne veut pas qu'il vol.

Donc il n'y a aucune raison de toucher à ça mais comme il y a des cas, des exceptions où on veut que ça vole et bien il y a des caves on passe par une interface. 

Et on n'a plus du coup ce problème qu'on avait avec les classes abstraites. Et n'oubliez pas une classe peut implémenter plusieurs interfaces. ça veut dire que vous pouvez du coup, rajouter plein de fonctionnalité à vos classes en implémentant tout un tas d'interfaces comme vous le voulez, ça peut-être vraiment pour plein de choses. 

Donc on va quand même compiler pour montrer que ça marche. 

Et voilà, j'ai fait une bêtise bien évidemment. 

```powershell
	>javac App.java

--------------------------------------------------------------------

App.java:568: error: fly(String) is not public in Cottage; cannot be accessed from outside package
                c.fly("Carbone");
                 ^
App.java:569: error: fly(String) is not public in Ship; cannot be accessed from outside package
                s.fly("Mana");
                 ^
.\jachampagne\Cottage.java:13: error: fly(String) in Cottage cannot implement fly(String) in Flyable
    void fly(String energy)
         ^
  attempting to assign weaker access privileges; was public
.\jachampagne\Ship.java:15: error: fly(String) in Ship cannot implement fly(String) in Flyable
    void fly(String energy)
         ^
  attempting to assign weaker access privileges; was public
4 errors

--------------------------------------------------------------------
```

C'est quoi `fly(String) is not public` ? 

Qu'est-ce que j'ai mis comme bêtise ? 

Mais oui voilà, on a copier coller :

+ Cottage.java et Ship.java
```java
    void fly(String energy)
    {
    	System.out.println("Je me propulse dans les airs avec du " + energy);
    }
```
Il faut public devant :
```java
    public void fly(String energy)
    {
    	System.out.println("Je me propulse dans les airs avec du " + energy);
    }
```
C'est n'importe quoi, vous voyez c'est le Copié-collé. Faites attention parce que quand il y a déjà une faute dans ce que vous copié-collé, dommage! 
```powershell
	>javac App.java
       >java App
       Parcelle en place...
       Je me propulse dans les airs avec du Carbone
       Je me propulse dans les airs avec du Mana
```
Et voilà, la personne en place c'est la construction de la chaumière. Je me propulse dans les airs avec du carbone donc ça c'est la chaumière qui est en train de voler et la dernière ligne c'est le navire.

Et là ça fonctionne, tout vol. Pas de problème ! 

Et si demain je veux rajouter un nouveau bâtiment ou un nouveau véhicule et je veux qu'ils volent, Eh bien pas de problème. C'est-à-dire que s'il n'y a rien qui change par rapport à la manière de voler, en tout cas ce contrat, cette interface (interface Flyable).

Eh bien je crèe une classe concrête qui hérite de la classe abstraite qui a des liens avec s. Si c'est un véhicule il faut que ça hérites de véhicules. Si c'est une sorte de bâtiments, il faut que ça hérites de building. Et si je veux que ça vole, j'implémente tout simplement l'interface Flyable (Fyable.java). Et c'est tout, terminé !

J'ai pas eu besoin de toucher quoi que ce soit d'autres par rapport à ça.

Voilà si vous avez compris ce que j'ai dit jusqu à prèsent parce que je sais que la vidéo pour le cours va être un peu longue parce qu'il y a beaucoup de choses à expliquer. Vous avez déjà compris 99 pour 100 2 interfaces en programmation de manière générales, y compris sur d'autres langages. Parce que le principe encore une fois ce sont des notions élémentaire qui fonctionne de la même manière sur d'autres langages. Après ce qui va changer selon le langage, c'est la syntaxe où comment fonctionne des fois les accès ou autre dans le langage à l'autre. 

Donc ça fait attention Selon le langage de programmation, il y a des choses qui différent mais la notion elle est là : à quoi sert une interface ? C'est ce que je viens de vous dire, c'est exactement pareil pour le c plus plus ou d'autres langages qui par avoir des interfaces. Tout est a fait pareil, il n'y a vraiment pas de différence de ce côté là. 

Du coup, du coup du coup, par exemple on va repartir sur l'exemple de Java, Java possède pas mal d'interface comme par exemple pour copier des objets, copier des éléments pour les comparer j'appelle pour tout ça. Et dés qu'on veut avoir une classe et c'est comme ça que ça fonctionne ... que le langage Java est conçu comme ça avec plein d'interface, plein de classe abstraite et du coup tout est fait, toute la logique du langage, avec toutes les classes que vous allez utiliser du langage sont construites de cette manière. 

Donc si à un moment donné vous voulez par exemple pouvoir comparer des éléments d'une classe que vous avez créée, Eh bien il faudra tu vas te faire votre propre interface si c'est bien quelque chose de spécifique sinon tout simplement implémenter l'interface de Java (Interface Comparable), et c'est tout.

[Interface Comparable](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)  

Interface qui permettra à la place du T, de comparer des dates, des maisons, des navires voilà on peut comparer plein de choses Parce que évidemment en termes de code pur "comparer des bateaux", ce n'est pas si simple que ça, ça c'est vraiment humain, il faut réflèchir humainement parlant à comment est-ce qu'on compare de navires? 

OK pour ça, un autre élément aussi parce que je vous avais dit qu'une interface en termes de syntaxe pure, c'est une classe abstraite mais qui ne possède que des choses abstraites donc en gros il n'y aura jamais de implémentation de quoi que ce soit.

Dans tous les cas une interface ne se instancie pas, ce n'est pas une classe en plus dans ce cas là, il n'y a évidemment pas de constructeur dans une interface. Comme dans une classe abstraite, on ne fait pas d'instances d'une interface, évidemment pas. 

Par contre il y a un élément très important, comme on avait vu que la classe abstraite permet de factoriser du code c'est-à-dire comme quand on a des éléments communs avec des classes étroitement liée, en crèer une abstraction Pour faire justement cette fameuse classe abstraite et on pouvait utiliser justement des éléments non statiques, on pouvait utiliser des choses qui ne sont pas constantes, on peut par exemple avoir des attributs protégés où ce genre de chose. 

Par contre vous voyez que je l'ai fait ici, protected, pas de problème (Vehicule.java).

Par contre, pour l'interface (Flyable.java) :

+ Flyable.java
```java
package jachampagne;

interface Flyable
{
	public void fly(String energy);
}
```
Par contre, pour l'interface (Flyable.java), c'est public donc on ne peut pas faire un attribut privé, on ne peut pas faire un attribut protected même si c'est comme une classe, ce n'est pas complètement comme une classe. En termes de syntaxe, ce n'est pas du tout pareil et au niveau comportement non plus donc il y a bien une différence entre classe abstraite et interface. Ce n'est absolument pas la même chose.  

Par contre même si on ne peut pas utiliser de mots d'accès (public, private, protected), On peut quand même, dans une interface utiliser des méthodes statiques parce qu'une interface de toute façon, ça ne s'instancie pas.

Donc on pourrait indiquer, pour le coup ce n'est pas forcément intéressant, mais on peut par exemple avoir public ... :

+ Flyable.java
```java
package jachampagne;

interface Flyable
{
	public

	public void fly(String energy);
}
```
On peut mettre par exemple public parce que personnellement je préfère le mettre et avoir, je ne sais pas, Flyable ... mais là c'est parce que pour le coup, mon véhicule, j'ai mis une vitesse :

+ Vehicle.java
```java
package jachampagne;

abstract public class Vehicle
{
	protected int mMovementSpeed;

	abstract public void moveXY(int x, int y);
}
```
Pour mon véhicule, j'ai mis une vitesse mais ça (mMovementSpeed), on pourrait se dire que c'est la vitesse de déplacement du véhicule en normal et là, on pourrait par exemple dire. On aurait admettons un int suivi d'un flySpeed :

+ Flyable.java (erreur)
```java
package jachampagne;

interface Flyable
{
	public int flySpeed =

	public void fly(String energy);
}
```
Non, ce n'est pas comme ça, ce serait plutôt "public static final int" ou "public final int" parce qu'on peut avoir un élément final parce que c'est une constante en fait, voilà c'est "public final int" et on aurait, je ne sais pas, une vitesse de vol pour tous les éléments... je n'ai franchement pas d'idée ... on va mettre 20, allez 20 kilomètres heure.

+ Flyable.java
```java
package jachampagne;

interface Flyable
{
	public final int flySpeed = 20;

	public void fly(String energy);
}
```
on va mettre 20, allez 20 kilomètres heure, ça va vite, 20 kilomètres heure, ça va vite, c'est déjà pas mal.

Et voilà, on peut bien évidemment mettre des éléments, des constantes, rappelez-vous le mot-clà final, on l'a déjà emporté dans la séance précédente.
On peut avoir des éléments statiques sans problème, même de méthode.

On peut faire des méthodes statiques qui permettent comme ça de passer par l'interface comme vous l'avez vu avec la classe, les classes qui ont des méthodes statiques. 

+ Flyable.java
```java
package jachampagne;

interface Flyable
{
	public final int flySpeed = 20;

	public static void fly(String energy);
}
```
On peut faire des méthodes statiques qui permettent comme ça de passer par l'interface comme vous l'avez vu avec la classe, les classes qui ont des méthodes statiques, sans crèer d'instance de quoi que ce soit. 

Donc Flyable, on utilisera la méthode statique, je ne reviens pas dessus on en a déjà parlà tout ce qui était méthode statique. C'est la même chose pour les interfaces. Tout ce que vous savez sur la méthode statique fonctionne pareil pour les interfaces mais c'était quand même bien de le rappeler et pourquoi c'est important ? parce que avant Java 8, Java 7 et les versions antérieures, on ne pouvait pas faire une méthode statique dans une interface c'est pour ça que j'en ai parlà mais de toute façon vous êtes au minimum sur Java 8, voir même Java 10 parce que je ne vous avais dit de ne pas partir sur une version qui date de 5 ou 10 ans. Faut pas non plus déconner donc vous avez quand même une version un minimum récente et c'est pour ça qu'il y a ces petites choses à prendre en compte. 

+ Flyable.java
```java
package jachampagne;

interface Flyable
{
	public final int flySpeed = 20;

	public void fly(String energy);
}
```
Normalement j'ai fait le tour, il n'y a qu'une dernière chose dont je dois encore vous parler pour la fin de la vidéo mais je regarde si je n'ai pas oublié autre chose de ce que je voulais vous dire, les éléments, on a parlà de ça et cetera. On a fait le tour de tout donc c'est bien. 

Parfait parfait donc on va pouvoir terminer avec ce que je voulais vous dire. Ah non, il y a un petit point que je voulais vous dire, Que je n'ai pas noté en plus, c'est quand même important parce que c'est arrivé aussi avec Java vite 8 si je ne dis pas de bêtises.

## Interface fonctionnelle

Il y avait la notion d'interface fonctionnel c'est-à-dire qu'avec Java 8, on a inclus, on a introduit en tout cas ce qu'on appelle les interfaces fonctionnelles. 

Et l'interface fonctionnelle, c'est très simple, c'est une interface qui ne qu'une seule et unique méthode abstraite. 

En gros, moi ce que j'ai fait si vous voulez savoir ça.

+ Flyable.java
```java
package jachampagne;

interface Flyable
{
	public void fly(String energy);
}
```
Donc du coup je regarde puisqu'on a modifié des trucs apparemment c'est bon.
Il n'y a pas le mot-clà abstract, je rappel. j'aurais même pu mettre comme ça :

+ Flyable.java
```java
package jachampagne;

interface Flyable
{
	void fly(String energy);
}
```
J'aurais pu mettre ça comme ça (sans public) parce que de toute façon dans une interface c'est public qu'on le veuille ou pas, c'est comme ça.

Mais ici comme il n'y a qu'une seule méthode abstraite dans mon interface, on dit que c'est une interface fonctionnelle. 

Et d'ailleurs souvent on peut utiliser, ça me fera parce que c'est pas fait au moment où je fait la vidéo mais on abordera pas mal de notation comme ça (@FunctionalInterface).

+ Flyable.java
```java
package jachampagne;

@FunctionalInterface
interface Flyable
{
	public void fly(String energy);
}
```
On verra pas mal de notation comme ça (@FunctionalInterface), ouvrez qu'en Java on a des notations comme ça avec un @ et on a un mot précis suivant des endroits du code avec des choses bien spécifiques pour indiquer des choses au compilateur. 

je n'ai pas fait au moment où cette vidéo est faite, la vidéo le tuto n'a pas été fait mais de toute façon vous aurez un tutos sur tous ces éléments là, c'est petit mot que l'on peut mettre à droite à gauche pour indiquer tout un tas de choses au compilateur et vous verrez de quoi il retourne bien en détail dans ce tutoriel. 

FunctionalInterface, Pour dire simplement que là on a une interface fonctionnelle et ça permet simplement après au compilateur, à la compilation, de voir que si jamais on s'est gouré quelque part, il vous dira : "bah hein tu t'es trompé, ton interface fonctionnelle n'est pas vraiment fonctionnelle donc il y a quelque chose qui ne va pas ". 

en gros si vous voulez par exemple vous dire : "je veux absolument faire une interface fonctionnelle " Eh bien en utilisant ce genre de terme (FunctionalInterface), ça permet de forcer à avoir effectivement une interface fonctionnelle. Je ne rentre pas tellement dans les détails parce qu'on le verra bien à part dans une autre vidéo dédié notamment pour ces choses-là, notamment les mots : override et cetera. 

On l'abordera aussi donc ce genre de tutoriel là. 

Donc en gros c'est ça puisqu'on parle simplement de méthode abstraite, rien n empêcherait de faire aussi pour une interface fonctionnelle, des méthodes statiques parce qu'une méthode statique peut-être utilisé sans utiliser une classe qui implémente et sans instancier quoi que ce soit. 

Rappelez-vous, une méthode statique c'est juste "tu mets le nom de l'élément en question, tu mets 2 petits points et le nom de ta méthode, voilà et tu peux l'appeler sans problème". ça fonctionne évidemment de cette manière donc il faut bien le prendre en compte. 

## Les méthodes par défaut

Nous avons également un autre cas qui est arrivé. Je vais terminer cette séance, on va terminer cette séance avec ça concernant les méthodes par défaut. ça a été également introduit, j'espère ne pas me tromper de ce que je me souviens Mais si je me trompe pour ceux qui font déjà du Java, si je me suis gouré dans le numéro de version, Vous pourrez éventuellement me faire le retour dans les commentaires, n'hésitez pas mais pareil il me semble qu'avec Java 8, on a aussi introduit en plus de pouvoir utiliser des méthodes statiques dans les interfaces... on a vu aussi les interfaces fonctionnelles, ce nouveau concept on va dire. On a aussi la possibilité de faire des méthodes par défaut. 

La méthode par défaut c'est assez simple aussi, On va faire, on va mettre n'importe quoi. On fait "default public void test()".

+ Flyable.java
```java
package jachampagne;

@FunctionalInterface
interface Flyable
{
	public void fly(String energy);
       default public void test();
}
```
C'est vraiment juste pour tester pour vous montrer comment ça marche. 
En gros on va voir ça exceptionnellement parce que c'est une méthode par défaut, je vais pouvoir implémenter dans l'interface. 

+ Flyable.java
```java
package jachampagne;

@FunctionalInterface
interface Flyable
{
	public void fly(String energy);

    default public void test()
    {
		System.out.println("Test"); 
    }
}
```
je vais pouvoir implémenter dans l'interface. Avant à l'époque ça n'existait pas. Il y a même des langages d'ailleurs, c'est pour ça que je vous dis que c'est différent, il y a d'autres langages de programmation avec du paradigme objet qui ne permettent pas de faire ça donc ça c'est vraiment propre à Java. Java permet de faire des méthodes par défaut, ce qu'on n'aurait pas forcément dans tous les langages qui permettent de faire de la programmation Objet donc attention ici c'est une exception où les méthodes par défaut dans une interface ne fonctionnera pas dans tous les langages la programmation orientée objet qui permettent d'utiliser les interfaces, attention. 

Donc ici en gros on a ça, on utilise ce mot clà default qui veut dire ben j'implémente mais exceptionnellement, c'est une exception, j'implémente du code dans une interface, chose qui avant Java encore une fois  si je ne me trompe pas, ne permettait pas de le faire. 

Et comment ça fonctionne bien tout simplement, si la classe qui implémente notre interface, redéfinisse donc implémente cette méthode test et bien elles utiliseront leur propre méthode de test et sinon C'est cette implémentation là :
```java
    default public void test()
    {
		System.out.println("Test"); 
    }
```
Eh bien c'est cette implémentation là qui sera exécuté par défaut, c'est tout c'est juste ça.

C'est par exemple je fais c.test() et s.test() :

+ App.java
```java
import jachampagne.*;

public class App
{
	public static void main(String[] args)
    {
		Cottage c = new Cottage();
		Ship s = new Ship();

		c.fly("Carbone");
		s.fly("Mana");

       c.test();
       s.test();
	}
}
```
Si je fais c.test() et s.test(), comme là elles ont toutes les 2, pas implémenté cette méthode, Ben ils appelleront ça va afficher test pour les 2.

Donc on va faire un cas à part pour Cottage.java :

+ Cottage.java
```java
package jachampagne;

public class Cottage extends Building implements Flyable
{
	public Cottage()
    {
    	System.out.println("Parcelle en place...");
    }
    public void build(String material)
    {
    	System.out.println("Construction du batiment en " + material);
    }
    public void fly(String energy)
    {
    	System.out.println("Je me propulse dans les airs avec du " + energy);
    }
	public void test()
	{
		System.out.println("Mon test à moi !");
	}
}
```
Donc on va faire un cas à part pour `Cottage.java`. L'autre disait "test" et si on va mettre "mon test à moi". Vous voyez c'est très Possessive cette classe donc du coup elle fait son propre test.

Donc un compile tout ça ici on n'a pas fait d'erreur. 
```powershell
	>javac App.java
	>java App
	Parcelle en place...
	Je me propulse dans les airs avec du Carbone
	Je me propulse dans les airs avec du Mana
	Mon test a moi !
	Test
```
On compile tout ça, on voit qu'on n'a pas fait d'erreur, on voit que la chaumière qui a implémenté la méthode test(), utilise sa propre méthode et là pour le coup du navire comme il n'a pas implémenté cette méthode et comme elle est marquée comme étant par défaut (Flyable.java) grâce au mot-clà default. Si il n'y est pas vous aurez une erreur évidemment parce qu'il faut bien tout implémenter dans une interface si ce n'est pas une méthode par défaut mais là comme s'en est une Eh bien ce sera cette méthode qui sera utilisée du coup pour le navire.

Et voilà la méthode par défaut comme son nom l'indique, default public void test() donc c'est une méthode par défaut. 

Voilà je vais terminer avec ça, c'est un petit bonus. J'aurais pu ne pas vous en parler mais je tenais à vous en parler parce que c'est arrivé avec Java 8 normalement et du coup c'est toujours bien de savoir qu'il y a ça, que vous ne soyez pas surpris si un jour vous tombez dessus en vous disant et Ben mince que j'ai toujours entendu que dans une interface, on implémentait rien est bien là, il y a de l'implémentation Donc je ne comprends plus !

Donc c'est un c'est embêtant, c'est assez confus.

donc là en tout cas vous avez cet exemple et c'est assez simple à voir parce que là dessus, le langage Java et très verbeux c'est-à-dire qu'on a des mots pour indiquer tout. 

Donc ici (Flyable.java) :

+ Flyable.java
```java
package jachampagne;

@FunctionalInterface
interface Flyable
{
	public void fly(String energy);

    default public void test()
    {
		System.out.println("Test"); 
    }
}
```
Donc ici `public void fly(String energy)`, On comprend que ce n'est pas implémenté mais là `default public void test()`, on comprend que ça l'est parce qu'il y a ce petit mot clà magique, le default, qui nous indique que c'est une méthode par défaut.

Et je vais en terminer la, ça fait 40 minutes de vidéo, on aura bien fait tôt concernant les interfaces, j'espère que ça vous a permis de bien comprendre cette nouvelle notion. 

Ca vous permet aussi de bien là compléter avec les classes abstraites d'accord parce que le principe pour moi en tout cas c'est que vous ayez bien compris quand utiliser l'un et quand utiliser l'autre. 

Si on peut résumer le plus simplement même si ce n'est pas exhaustif, encore une fois la classe abstraite, vous avez des classes qui ont des liens étroits et donc des éléments communs. Vous pouvez les hiéarchiser via une classe abstraite et comme vous avez des classes qui peuvent être complètement indépendantes, vous pourriez avoir besoin de leur apporter des fonctionnalités bien précises sans qu'elles aient, elle-même c'est classe la des liens entre elles. Eh bien on va te passer par une interface. 

N'oubliez pas une interface pour revenir au schéma, c'est un contrat qui vous dit je propose une API, donc un ensemble de fonctionnalités tout simplement mais sans forcément savoir comment je vais le faire. 
```txt
	Vehicule (abstract)		Flyable	Building (abstract)
	        ^				      ^ ^		^
	        |				      | |		|
Glider ------------- Ship --------+	+----	Cottage 
```
Sans forcément savoir comment je vais le faire et tous ceux qui veulent l'utiliser, Eh bien ils vous diront comment ils implémentent ça, comment est-ce qu'on peut voler. 

C'est un petit peu comme si vous vous disiez que je veux que telle chose fasse telle chose et après vous demandez à quelqu'un de se débrouiller pour que ça fonctionne. Vous n'avez pas besoin de savoir comment il le fait tant que ça le fait, c'est ça l'interface. Interface c'est vraiment un contrat qui engage donc la classe qui implémente (Cottage.java) à devoir implémenter ce que possède l'interface (Flyable.java).

Si vous avez compris tout ce que j'ai dit sur cette vidéo, sur la vidéo concernant la classe abstraite, vous aurez compris pratiquement tout là-dessus et ça permettra aussi de terminer sur ce gros passage de secours Java avec la prochaine séance concernant le polymorphisme c'est-à-dire que tout ce qu'on a vu là sur les classes abstraites les interfaces permettre de faire du polymorphisme. 

Ce sera le sujet de la prochaine séance et vous allez voir c'est très très pratique ça fait gagner beaucoup de lignes de code ensuite pour le développeur.

Du coup, je vous laisse avec cette fin de vidéo j'espère que ça vous a plu. On se retrouvera pour la prochaine séance pour le polymorphisme. 

Et s'il y a des questions comme d'habitude, n'hésitez pas à les laisser dans les commentaires. 

A bientôt tout le monde.
