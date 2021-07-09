# [21. Polymorphisme](https://www.youtube.com/watch?v=CPxrEntMxsQ)

Bonjour et bienvenue sur cette 21e séance où nous allons parler de polymorphisme.

On a vu précédemment où en tout cas on va pouvoir clore une grosse grosse  partie de ce cours en Java concernant les classes, la construction de classe, le principe d'héritage et les 2 dernières vidéos qu'on a vues à savoir les classes abstraites et les interfaces Pour appliquer pas mal de nouveaux principes au niveau de votre code en programmation orienté objet. 

On va du coup, terminer avec le polymorphisme qui était un petit peu là finalité de l'utilisation de ces classes abstraites et de ces interfaces. 

J'espère que à ce stade de la formation Vous avez bien compris la différence entre les 2 donc quel cas on va se servir d'une classe abstraite et dans quel cas on va se servir d'une interface.

Et là je vais vous montrer ce qui est le polymorphisme, en quoi ça consiste et qu'est-ce que ça va vous permettre de faire au niveau de votre code. 
On va reprendre le même schéma vu précédemment :
```txt
	Vehicule (abstract)		 Flyable	Building (abstract)
		   ^				        ^	^		^
		   |				        |	|		|
Glider ----+-------- Ship --------- +	+---- Cottage 
```
Le même schéma vu précédemment c'est-à-dire les 2 classes abstraites, Vehicle et Building, On va voir des classes concrêtes qui héritent pour chacune de ces classes abstraites donc Ship, Glider et Cottage. 

Et on aura une interface donc toujours pareil Flyable et avec 2 classes concrêtes qui les implémentent. 

Donc on considère dans notre implémentation, dans notre code, quel navire est capable de voler. C'est pour ça qu'il implémente cette interface (Flyable) et à l'instar la chaumière également est capable de voler donc elle implémente cette interface.

En terme de code, j'ai légèrement réduit ce dernier pour le surplus qui n'était pas utile pour cette séance, je remonte très rapidement. 
Vous avez l'interface Flyable.

+ Flyable.java
```java
package jachampagne;

public interface Flyable
{
	public void fly();
}
```
Vous avez l'interface Flyable, pas de souci par rapport à ça.Notre Vehicle, très rapidement.

+ Vehicle.java
```java
package jachampagne;

abstract public class Vehicle // extends Object
{
	protected int mMovementSpeed;

	abstract public void moveXY(int x, int y);
}
```
Notre véhicule, très rapidement. On va par parler des petites méthodes ici `abstract public void moveXY()`. C'est pour avoir un minimum de code quand même, ne pas avoir des classes vide non plus. 

On a tout ça (Ship.java), je rappelle la méthode Fly parce que le navire peut voler. 

+ Ship.java
```java
package jachampagne;

public class Ship extends Vehicle implements Flyable
{
	public Ship()
	{
		this.mMovement = 16;
	}

	public void moveXY(int x, int y)
	{
		System.out.println("Le navire brasse les flots et se déplace en " + x + ", " + y);
	}

	public void fly()
	{
		System.out.println("Le navire est propulse dans les airs");
	}
}
```
Le navire peut voler. Bon je rappelle ça c'est son comportement à lui, je rappelle que le principe de l'interface, c'est de fournir une à API en surcouche où l'on dit que cette API, si tu l'implémente tu vas être du coup capable de faire ceci ceci et cela Mais si tu veux implémenter cette API, il faudra que tu expliques comment tu le fais.

Donc il faudra définir précisément concrêtement le comportement pour chacune des méthodes de l'interface donc ici on en avait qu'une pour rester sur quelque chose d'assez court donc on l'a bien implémenté là.

Et la chaumière, même chose, on lui a implémenté son propre comportement personnel, à elle, dans sa manière de pouvoir voler, d'être capable de voler.

+ Cottage.java
```java
package jachampagne;

public class Cottage extends Building implements Flyable
{
	public Cottage()
	{
       	
    }

    public void build(String material)
    {
       	System.out.print("Constraction du batiment en " + material);
	}

	public void fly()
	{
		System.out.println("La chaumiere s'eleve peu a peu dans les airs");
	}
}
```
Donc ça c'est un mélange, parce qu'il ne faut pas hésiter à mélanger classe abstraite et interface parce que ça a vraiment une utilité différente donc on peut parfaitement les associer tous les 2 et vous allez voir ce que ça permet par la suite. 

Alors le polymorphisme, premier point très important et souvent qui prête à confusion Pour les gens qui débutent en programmation et surtout en programmation orientée objet, c'est que les gens ont a l'impression que le polymorphisme en tout cas l'utilisation de classe abstraite et de l'interface parce que c'est la base de polymorphisme vont lui permettre de gagner du temps en termes de code, de lignes de code, ou de rendre les choses plus pratique au niveau même de la définition des fameuses classes et des interfaces alors que pas du tout. 

Certes au niveau de classe abstraite comme je l'ai expliqué, donc là ces classes abstraites permettent de factoriser le code donc d'éviter la répétition de code entre classes concrêtes étroitement liées entre elles donc on va forcément gagner quelques lignes de code, c'est évident. 

Mais ce n'est pas le principe même du polymorphisme ou en tout cas du polymorphisme et des interfaces qui mène au polymorphisme. 

Le polymorphisme ça va beaucoup plus loin que ça et ça intervient surtout c'est-à-dire que l'utilité même et l'application même du polymorphisme va arriver et va se voir au moment de l'utilisation de vos classes et de ces différentes classes qui soit héritent de classe abstraite, soit implémentent des interfaces.

Cela en fait, lors de l'usage que vous allez voir la puissance est l'utilité du polymorphisme.

Et c'est justement ce que nous allons faire :

Premièrement, on va faire :

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		
    }
}
```
Premièrement on va faire comme si on n'avait pas prévu d'architecture (schéma), prévu d'architecture à base de classe abstraite et interface grosso modo ou en tout cas juste le point basique. 

```txt
	Vehicule (abstract)		 Flyable	Building (abstract)
		   ^				        ^	^		^
		   |				        |	|		|
Glider ----+-------- Ship --------- +	+----	Cottage 
```

déjà si on n'avait pas le lien, ce serait assez compliqué car comme je vous l'avais expliqué il faudrait que toutes les classes concrête aient en fait leurs méthodes implémentées. Il faudrait que véhicule aient toutes les méthodes implémentées parce que ce serait une classe concrête si on prenait un autre exemple, il faudrait tout refaire pour Ship, Glider et cetera et cetera. Donc plein de répétition Le code, pas de chose très pratique et comme je l'avais expliqué sur la séance concernant les interfaces, si on peut se on n'utilise pas d'interface, en gros il faut qu'on mette du coup la capacité de vol dans certaines classes mais il faudrait quand même de l'héritage pour que ça puisse profiter à l'autre donc bref soit on aura de la répétition de code soit on avait très mauvaise conception en fait au niveau du code. 

Et si on veut faire évoluer ce code par la suite, ajouter de nouveaux éléments, on devra tout recommencer, on devra même retouché aux anciennes classes pour ajouter des nouvelles. 

Ce n'est absolument pas intéressant et surtout pas cohérent dans la manière de programmer. Si par exemple demain, Je veux ajouter une moto comme véhicule, si je dois commencer à modifier le code du navire, du planeur ou même du véhicule si on avait une classe abstraite encore une fois. Ce n'est pas bon du tout. Une moto, elle devrait être indépendante, elle va profiter de tout ce que possède un véhicule mais même si elle a des relations étroites avec le navire, on ne devrait pas avoir à toucher au code du navire si on a créé moto.

Qui plus est, si admettons vous en tant que développeur développer justement une classe pour représenter une moto et admettons que c'est un autre développeur qui possède ce code là :
```txt
Glider ----+-------- Ship
```
Si c'est un autre développeur qui possède ce code-là, vous allez faire comment ? Vous allez demander à l'autre développeur ? Tu m'explique comment, navires et cetera je dois modifier ton code ? C'est juste pas possible et impensable.

Du coup on a résolu le problème, je l'ai bien expliqué. C'est pour ça que je fais un petit rappel ici avant de continuer sur la suite du principe même des classes abstraites, des interfaces qui ont permises de résoudre pas mal de problèmes de ce côté là. 

Et voici à l'usage ce que ça va donner.

déjà à partir sur la base même, le minimum qu'on puisse faire grâce aux interfaces et aux classes abstraites pour appliquer un début de polymorphisme, vraiment doucement. 

## 2 navires, 1 planeur et 2 chaumières

Première chose qu'on savait faire, moi j'aimerais par exemple créé par exemple en tant qu utilisateur, Ben je voudrais qu'il y ait 2 navires, un planeur et 2 chaumières. On peut faire ça comme ça.

Au strict minimum si même à la limite on n'avait pas d'interface ou de classe abstraite admettons que ici Vehicle n'existe pas et que building n'existe pas. Comment est-ce qu'on ferait tout cela? 2 navires, un planeur, 2 chaumières ? Eh bien on ferait beaucoup de répétitions de code. 

Donc en gros, je vais le faire rapidement comme ça on modifiera au fur et à mesure Pour que vous voyez petit à petit ce qu'amène les classes abstraites et les interfaces et du coup ce qu'on appelle le polymorphisme et vous allez vite comprendre l'utilité et tout ce que ça va vous faire gagner et tout les bénéfices Que ça va apporter au niveau de votre code. 

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
       }
}
```
Bon j'ai mes deux navires. Qu'est-ce qu'avait demandé le client ? Le client avait demandé un planeur virgule il veut un planeur, donc on lui donne un planeur, pas de problème.

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
    }
}
```
Et les 2 chaumières :

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();
    }
}
```
Pour être plus rapide, on fait du copié-collé, on n'hésite pas.

Comme j'écris suffisamment vite je me permets de ne pas en faire. 

Voilà okay, on a créé des objets on a instancié de ce qu'on voulait. 

Maintenant ton navire, enfin le premier navire je veux qu'il se déplace et je veux ensuite qu'il vol, admettons OK. 

Tu veux faire ça virgule pas de problème. Là encore on part du principe on n'a pas de classe abstraite et pas d'interface, on part vraiment ce principe là. 

Donc le premier, on voulait quoi ? On voulait le déplacer. 

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
    }
}
```
Je vais mettre n'importe quoi `s1.moveXY(145, 85)`, c'est pour l'exemple. 

Ils veulent ensuite le faire voler. Rappelez-vous, j'avais mis une énergie pour les paramêtres de Fly, je le enlever pour ne pas perdre de temps sur cette vidéo. 

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
		s1.fly();
    }
}
```

On va rester comme ça.Pas de problème c'est fait.
Bon le navire numéro 2, on ne fait rien avec. Pas de problème. 
Le Glider, on va le déplacer. 

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
		s1.fly();

		g1.moveXY(169, 26);
    }
}
```
Ensuite comme j'ai déjà écrit une classe abstraite (Vehicle.java > moveXY), ça va utiliser une classe abstraite mais on part du principe qu'il n'y en avait pas donc il aurait fallu écrire du code, répéter du code à droite à gauche partout et partout. 

Et pour cottage, déjà j'avais une répétition ici `Cottage c1/c2 = new Cottage`. On va faire voler les 2 chaumières. C'est deux points Fly.

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
		s1.fly();

		g1.moveXY(169, 26);

		c1.fly();
		c2.fly();
    }
}
```
J'ai pas fait grand chose Si vous regardez bien. je n'ai pas eu grand chose à faire. On n'a pas demandé de crèer grand-chose, on n'a pas demandé beaucoup d'action pourtant ça fait déjà pas mal de code et on voit très vite beaucoup de répétitions aussi. Nous, le principe avec le classe abstraite et notamment les interfaces, on a vu qu'on avait des éléments en fait générique, des fonctionnalités génériques. 

Par exemple le vol, c'est une capacité qu'on a mis au point (Flyable.java). Il y a des éléments qui peuvent partager cette capacité, et qui en plus n'ont pas forcément de lien parce que encore une fois notre chaumière n'est absolument pas liée étroitement avec notre navire pourtant ils ont tous les 2 quand même une fonctionnalité commune qu'on leur a permis d'implémenter qui est le vol. Ceux qui m'embête, c'est que je ne profite pas de tout ça (App.java), c'est-à-dire que sans interface en classe abstraite, je suis obligé pour chaque élément de faire ça : 
```java
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();

		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
		s1.fly();

		g1.moveXY(169, 26);

		c1.fly();
		c2.fly();
```
Et si demain encore une fois on veut crèer une nouvelle classe, on va devoir rajouter tout un tas ... on va devoir déjà modifier, crèer une nouvelle classe. ça c'est déjà une chose, ce n'est pas un souci de crèer une nouvelle classe quand on a une nouvelle entité, ça c'est normal, on le ferait dans tous les cas par contre on va devoir modifier également d'autres classes et dans App.java, On va devoir faire tout un tas d'utilisation, bref on va mélanger plein d'informations et on ne va pas forcément respecter chaque donnée. En gros on va commencer, la chaumière va méler des informations propres navires et inversement alors qu'ils ne sont pas censés faire ça.Ce n'est pas parce que tous les 2 ont la capacité de voller que du coup le navire doit accepter et doit avoir des informations sur la chaumière et inversement. On peut pas commencer à tout mélanger. 

Donc première chose qu'on pourrait faire et ça c'est grâce en classe abstraite, on a un début de polymorphisme et on va s'en servir. On va se servir du principe de polymorphisme lié pour le coup juste à nos classe abstraite donc au lieu de faire ça :
```java
		Ship s1 = new Ship();
		Ship s2 = new Ship();
```
et ça : 
```java
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();
```
Nous ce qu'on a dit et on va au niveau du chemin, c'est en fait que ça :
```txt
Glider ----+-------- Ship
```
... Que ce soit les navires ou les planeurs et éventuellement d'autres classes, il faut toujours penser à l'évolution future que pourrait avoir notre projet, notre code. 
Ce sont quoi en fait ? Ce sont des véhicules. Si on dit que ce sont des véhicules, c'est parlant en termes de code. 

Que dans les véhicules il peut y avoir des navires, il peut y avoir des planeurs et peut-être que dans un an il y aura encore autre chose. 

Voilà ça au niveau du code, je veux le voir apparaêtre et là je ne le vois pas et c'est un peu dommage parce que si on utilise pas, on ne fait pas de polymorphisme alors pourquoi on s'en batte à crèer cette classe (Vehicle.java) qui a par, mettre des éléments là quel factorise. Elle ne servirait qu'à ça, qu'à factoriser du code. C'est un petit peu dommage de faire une classe juste pour factoriser du code, nous on cherche à plus d'avantages plus de bénéfices donc on va rajouter quelque chose donc pour moi tout ça ce sont des véhicules :
```java
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
```
Tout ça ce sont des véhicules. Donc moi ce que je vais faire, ce que j'ai appris en tant que développeur et vous l'avez appris aussi à faire ... à ce stade de la formation vous n'avez pas vu d'autres types de stockage et de collection, On a appris à faire des tableaux Eh bien pour moi ça ce sont des véhicules, pourquoi je ne pourrais pas faire un tableau de véhicule après tout ? je peux faire ça.

Vous savez qu'un tableau généralesment ça ne peut porter qu'un seul type, soit vous faites un tableau d'entiers soit un tableau de chaînes de caractères et pour le class, la règle, il n'y a pas d'exception C'est soit vous allez devoir faire un tableau de navires ou un tableau de planeurs ou un tableau de chaumières mais ça encore une fois ça ne va pas résoudre le problème parce que ça veut dire que je vais devoir faire un tableau pour stocker mes 2 navires, un tableau pour stocker un seul planeur et un tableau pour stocker 2 chaumières. 

## La syntaxe du polymorphisme

### Les Véhicules

Et c'est là notamment qu'intervient la classe abstraite et là on attaque le polymorphisme vraiment au niveau de la syntaxe. 
Vous allez pouvoir faire ceci : 

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Vehicle[] someVehicles = new Vehicle[3];

       Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
		s1.fly();

		g1.moveXY(169, 26);

		c1.fly();
		c2.fly();
    }
}
```
Je met `Vehicle[] someVehicles`, on nomme la variable pour monter qu'il y en a plusieurs et ici, j'en ai 3 donc je vais mettre ceci : `new Vehicle[3]`.

Il y en a peut-être en voyant ça qu'ils vont se dire bah je ne comprends pas : "là tu crèe des véhicules alors que c'est une classe abstraite (abstract public class Vehicle), Tu nous a expliqué avant qu'une classe abstraite on pouvait pas l'instancier.".

Si vous regardez le code, je ne l'ai pas instancier :
```java
	Vehicle[] someVehicles = new Vehicle[3];
```
Je ne l'ai pas instancier, j'ai déclaré un tableau de type Vehicle et là je dis que mon tableau je lui alloue 3 espaces pour pouvoir stocker des véhicules. C'est tout à fait cohérent puisqu'on a vu qu'en termes d'héritage ici (schéma), notre navire c'est un véhicule. C'est absolument vrai. 

Notre planeur c'est un véhicule aussi donc il n'y a pas de problème en termes de code de dire, on va stocker 3 véhicules. Aucun souci. 

Là où par contre ça va changer, c'est à l'instanciations. Ce que vous faites directement ici après la déclaration, pour l'affectation.

Moi je vais le faire à la ligne pour que ce soit beaucoup plus lisible pour vous, je vais faire simplement ceci :

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Vehicle[] someVehicles = new Vehicle[3];

		someVehicle[0] = new Ship();
		someVehicle[1] = new Ship();
		someVehicle[2] = new Cottage();

		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
		s1.fly();

		g1.moveXY(169, 26);

		c1.fly();
		c2.fly();
    }
}
```
Et bien `someVehicle[0]`, c'est mon premier navire. Je fait ça :
```java
	someVehicle[0] = new Ship();
```
On va copier coller pour gagner du temps. Il n'y a quand même pas mal de code à faire sur cette vidéo mine de rien.

et hop pour le 2e et ensuite pour le 3e élément de ce tableau de véhicule, je fait le planeur et là pas de problème. on instancie pas des véhicules parce qu'on ne peut pas. Si vous mettez new Vehicle(), ça ne marchera pas parce que c'est une classe abstraite.

Par contre on dit que là `Vehicle[] someVehicles = new Vehicle[3]` tu réserve 3 emplacements. Imaginez un parking, un garage, ce sera un peu bizarre. Vous dites qu'il y a de la place pour trouver véhicule quelconque. On sait qu'il y a de la place pour 3 véhicules et au moment on a besoin de réserver ces places, là on est obligé de dire concrêtement quel véhicule va occuper chaque place `someVehicle[0] = new Ship()`. C'est pour ça qu'on ne peut pas instance une classe abstraite, une classe abstraite c'est trop vague ça ne veut rien dire en termes de concret. 

Par contre on dit que la première classe on va les réserver pour un navire `someVehicle[0] = new Ship()` qui est véhicule donc c'est bon, La 2e pour un navire aussi, c'est un véhicule et la 3e pour un planeur, c'est un véhicule et c'est bon. ça c'est ce qu'on appelle du surclassement :
```java
		someVehicle[0] = new Ship();
		someVehicle[1] = new Ship();
		someVehicle[2] = new Cottage();
```
En gros ça reviendrait à dire que dans un emplacement de véhicule, tu stock un navire et le véhicule c'est la super classe, c'est la classe parentes d'un navire donc on fait du surclassement ou le terme anglais Upcasting s'il y en a qui s' un petit peu au terme anglais par rapport à ça.Donc les 3 lignes ci-dessus, c'est de Upcasting. 

Et c'est un des premiers principes, c'est du polymorphisme. ça veut dire qu à partir d'un élément générique, notre classe abstraite, on peut réserver un tableau de cette classe abstraite et ensuite on y stock tous les éléments concrets que l'on veut. 

Si demain, j'ai un développeur qui sort une moto. Pas de problème si j'ai besoin d'une moto par exemple ici à la place de `someVehicle[1] = new Ship()` :
```java
		someVehicle[0] = new Ship();
		someVehicle[1] = new Moto();
		someVehicle[2] = new Cottage();intéressent
```
On ferra `new Moto()` et c'est tout, terminé parce que le véhicule ne changera pas, que si j'avais fait un tableau de planeur `Glider[]`, déjà on pourra y stocker que des planeurs, on ne pourrait pas stocker de navires essaye plus tard il y a des motos on pourra encore moins stocker des motos donc ce n'est du coup pas du tout pratique au niveau de l'utilisation Et au niveau de l'application d'un code. De cette manière on utilise le polymorphisme, pour dire que nos véhicules ont un comportement générique et quand on a besoin d'avoir quelque chose de concret, c'est leur comportement concret qui sera appliqué la en l'occurrence c'est leur constructeur précis, spécifique (Ship, Moto, Glider) qui sera appelà pour le stocker. 

Voilà pour la première chose. 

### Les bâtiments

Ensuite on va faire ça pour les bâtiments. Vous avez pigé le principe, on fera ça pareil pour les bâtiments. 

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Vehicle[] someVehicles = new Vehicle[3];

		someVehicle[0] = new Ship();
		someVehicle[1] = new Ship();
		someVehicle[2] = new Cottage();

		Building[] someBuildings = new Building[2];

		someBuildings[0] = new Cottage();
		someBuildings[1] = new Cottage();

		s1.moveXY(145, 85);
       g1.moveXY(169, 26);
       
		s1.fly();
		c1.fly();
		c2.fly();
    }
}
```
Je pense que vous avez pigé le principe, le bâtiment vous ferez ça pareil. `Building[] ..someBuildings égal new Building` et on en met 2 parce que j'en ai fait que 2. Et on fait le même principe :
```java
		someBuildings[0] = new Cottage();
		someBuildings[1] = new Cottage();
```
Et à partir de là, j'ai 2 éléments qui doivent se déplacer :
```java
		s1.moveXY(145, 85);
        g1.moveXY(169, 26);
```
Vous avez appris en informatique, que répéter du code, qu'il faut éviter. Eh bien ça, on va le factorise. On peut factoriser ce genre de chose. 

Et bien ici on ne va pas forcément factoriser parce que ça ne concerne pas tous les éléments. En gros on va changer un petit peu par rapport à ça pour que ça correspond bien évidemment à notre code. 
```java
		someVehicles[0].moveXY(145, 85);
        someVehicles[2].moveXY(169, 26);
```
Pareil, ici on va reprendre le même élément en essayant de pas se tromper par rapport aux noms qu'on avait mis :
```java
		s1.fly();
		c1.fly();
		c2.fly();
```
On fait juste des remplacements pour virer les noms qui n'existent plus par rapport à mon code. 
```java
		someVehicle[0].fly();
		someBuildings[0].fly();
		someBuildings[1].fly();
```
Pour s'y retrouver un peu mieux on va faire les choses comme ça.

Donc on a d'abord lettre véhicule et ensuite on a des cons et voler le premier qui est un navire et les 2 chaumières qui devaient voler. Pas de problème, ça c'était juste de remplacement. 

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Vehicle[] someVehicles = new Vehicle[3];
		Building[] someBuildings = new Building[2];

		someVehicle[0] = new Ship();
		someVehicle[1] = new Ship();
		someVehicle[2] = new Cottage();
		someBuildings[0] = new Cottage();
		someBuildings[1] = new Cottage();

		someVehicles[0].moveXY(145, 85);
       someVehicles[2].moveXY(169, 26);
       
		someVehicle[0].fly();
		someBuildings[0].fly();
		someBuildings[1].fly();
    }
}
```
Donc ça vous voyez c'était un début, ça c'est le bénéfice de votre classe abstraite. Grâce à la classe abstraite Vehicle et votre classe abstraite Building, vous pouvez faire ça.si vous n'avez pas de classe abstraite et que vous essayer de faire ce genre de code son classe abstraite, ça ne marchera pas. 

Vous n'avez qu'a tester de votre côté, vous pouvez essayer et vous comprendrez que sans classe abstraite tout ceci est impossible. Vous serez obligé de crèer encore une fois un tableau pour 2 navires, un tableau pour un planeur et cetera et cetera. Et faire tout un tas d'actions pour chacun Et si demain il y a un nouveau véhicule qui est créé Eh bien il faudra faire un nouveau tableau et cetera et cetera. 

Alors qu'ici on travaille toujours sur le même tableau mais plus tard vous apprendrez à gérer des espaces de stockage dynamique. Donc on pourrait se dire : "tiens maintenant il y a des motos dans mon véhicule c'est bien facile tu agrandis ton garage". C'est quand même plus simple de faire ça que de dire bah tiens on va crèer un tout nouveau garage juste pour les motos mais du coup si on avait besoin d'une petite place pour un navire Ah bah tant pis, il faudra recrèer un tout nouveau garage pour les navires et je pense que vous comprenez un petit peu le problème que ça ferait donc là en termes de coùt, de ressources, utilisation de ressources informatiquement parlant, c'est juste pas possible. Ce n'est pas du tout économe de ce côté-là. 

Donc ça c'est le premier principe et encore une fois le bénéfice de la classe abstraite. 

Nous on va aller plus loin.

Pour le moment, je n'ai pas envie de faire tout de suite déplacer ça :
```java
		someVehicles[0].moveXY(145, 85);
        someVehicles[2].moveXY(169, 26);
```
Je vais juste faire voler tous ces éléments comme ceci : 
```java
		someVehicle[0].fly();
		someBuildings[0].fly();
		someBuildings[1].fly();
```
Je vais avoir un navire et 2 chaumières que je vais vouloir faire voler. 

Il y a un truc pratique qu'on a inclus ici dans notre implémentation, c'est l'interface Flyable. Est-ce qu'il n'y a pas moyen via l'interface d'avoir un bénéfice supplémentaire qui est de dire : ce n'est pas en fait des navires qu'on veut faire voler, ce n'est pas des chaumières que l'on veut faire voler ou je ne sais quoi qu'il y aurait beaucoup plus tard. Encore une fois on pense à l'évolutivité du code. On veut juste faire voler tout ce qui est capable de voler. Je pense que c'est suffisamment clair pour tout le monde. Tout ce qui est capable de voler on va leur dire tu voles. Terminé et sans savoir ce qui peut vraiment voler, indépendamment de sa. 

C'est si t'es capable de voler, tu voles. Si t'es pas capable de toute façon tu ne voleras pas. Ce sera aussi simplement régler. 

Donc grâce à l'interface, on peut aussi bénéficier du polymorphisme et aller encore plus loin. 

## Créer un tableau de notre interface

Donc on va faire tout ça.On va crèer un tableau de notre interface. Tout ça, c'est assez nouveau pour vous. 

On va mettre Flyable[] elements parce que je n'ai pas de nom précis pour ça et je vais dire, on stocke 3 éléments capable de voler.


+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Flyable[] elements = new Flyable[3];

		someVehicle[0] = new Ship();
		someVehicle[1] = new Ship();
		someVehicle[2] = new Cottage();
		someBuildings[0] = new Cottage();
		someBuildings[1] = new Cottage();

		someVehicle[0].fly();
		someBuildings[0].fly();
		someBuildings[1].fly();
    }
}
```
En stock 3 éléments capables de voler. On aura 3 emplacements 3 éléments quelconque, capable de voler. On est d'accord qu'en terme de classe, nos bâtiments sont indépendants des véhicules :
```txt
	Vehicule (abstract)		Flyable	Building (abstract)
		   ^				 ^	^	   ^
		   |				 |	|	   |
Glider ----+-------- Ship ---+	+----Cottage 
```
Nos bâtiments, ils sont indépendants des véhicules.

Pourtant l'interface ici (schéma) comme elle implémente certains véhicules et certains bâtiments implémente cette interface Hé bien On a quelque part, indirectement, un lien entre ces derniers. 

Ils ont un point commun, c'est que le navire et la chaumière peuvent voler et on va se servir de ce point commun dans la syntaxe du langage Java pour faire du polymorphisme et gagner encore ici en ligne de code, on aura moins de lignes de code il y en aura quelque chose qui évolue plus facilement et sans se poser la question Qu'est-ce que tu as comme véhicule ? qu'est-ce que tu as comme bâtiment ?

on sen fiche, nous tout ce qu'on veut savoir ...on sait qu'il y a des éléments qui veulent voler et on veut aller faire voler. Après on se débrouille c'est derrière ce sont des chaumières où peu importe, de toute façon on a expliqué ou un développeur quelconque, extérieur à nous, à implémenter leur comportement à eux, personnel. 

Mais nous on veut juste les faire voler virgule on s'en fiche de savoir comment est-ce que le navire va se débrouiller pour voler. Moi je veux juste le faire voler, je ne veux pas savoir comment ils le font. Je veux juste qu'ils veulent ! 

Donc pour faire ça, on va déjà virer le code ici :
```java
		Vehicle[] someVehicles = new Vehicle[3];
		Building[] someBuildings = new Building[2];
```
Je fais ça et d'ailleurs je vais faire directement pour changer un petit peu là syntaxe, pour que vous ayez les 2 possibilités :
```java
		Flyable[] elements = new Flyable[3];

		someVehicle[0] = new Ship();
		someVehicle[1] = new Ship();
		someVehicle[2] = new Cottage();
```
ou
```java
		Flyable[] elements = {new Ship(), new Cottage(), new Cottage()};
```
Entre accolades, le premier c'est un navire, le 2e c'est une chaumière et le 3e c'est encore une chaumière. Là je le mets directement ici après la déclaration Plutôt que de le faire à la ligne d'après histoire que vous ayez 2 syntaxes possibles pour faire ça.

Première chose et je veux que ces 3 véhicules volent. 

Donc vous voyez ici je me suis amusé presque à tout effacer.

Je vais dire, pour chaque élément qui veulent donc c'est de Flyable, je vais mettre `e` qui sont dans (:) le tableau éléments. Donc ça vous savez faire c'est la boucle for un peu spécial qu'on a vu.

Eh bien ces éléments-là tu vas les faire voler : `e.fly();`

Terminé.

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Flyable[] elements = {new Ship(), new Cottage(), new Cottage()};
		
		for(Flyable e : elements)
			e.fly();
    }
}
```
Voilà, imaginez que ce code là je n'ai pas, imaginez que tous les autres fichiers (Flyable, Cottage, Glider, Ship et Vehicle.java), c'est un autre développeur qui les a. Eh bien je n'ai pas besoin de les avoir ces fichiers, moi tout ce que je voulais ou en tout cas ce que le client voulait, c'était un navire et 2 chaumières et il veut les voler ces 3 éléments. Eh bien voilà juste en faisant ça (code ci-dessus) parce que je sais qu'ils sont dotés de la capacité de vol et qu'il y a une méthode qui s'appelle Fly qui permet de les faire voler, et bien en 3 lignes de code je peux faire voler 3 éléments qui sont dans des classes concrêtes différentes qui n'ont aucun lien étroit, qui appartiennent héritent ou en tout cas qui héritent chacun à leur manière d'une classe abstraite distincte mais qui ont un élément commun C'est à dire l'implémentation d'une interface qui leur donne la capacité de voler. 

Mais grâce à toutes ces relations (schéma) que ce soit de la hiérarchie via l'héritage (Vehicle > Ship ou Building > Cottage) où l'implémentation (Ship > Flyable < Cottage), le profil de cette API viens en surcouche pour la chaumière et le navire. On est capable en moins de code possible et amp quelque chose de beaucoup plus générique, de dire, tu vas voler. 

Et bien évidemment comme il faut toujours montrer que ça marche, on va compiler tout ça :
```powershell
	>javac App.java
	>java App
	Le navire est propulse dans les airs
	La chaumiere s'eleve peu a peu dans les airs
	La chaumiere s'eleve peu a peu dans les airs
```
Donc tous les éléments sont en train de voler sans problème, indépendamment. Demain je veux rajouter un autre navire Eh bien pas de problème, je fais: 
+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Flyable[] elements = {new Ship(), new Ship(), new Cottage(), new Cottage()};
		
		for(Flyable e : elements)
			e.fly();
   }
}
```
Vous voyez une petite modification et terminée. 
```powershell
       >javac App.java
       >java App
       Le navire est propulse dans les airs
       Le navire est propulse dans les airs
       La chaumiere s'eleve peu a peu dans les airs
       La chaumiere s'eleve peu a peu dans les airs
```
Et voilà ça vole. 

Et on s'arrêtera là. C'est tout ce que je voulais vous montrer. C'est ça le polymorphisme, c'est vraiment la finalité de tout ce qu'on a vu précédemment sur les classes abstraites et les interfaces, on a vu qu'il y avait du polymorphisme dans les 2 cas. On va crèer l'idée que plus tard, on va améliorer ce code c'est-à-dire qu'on rajoute autre chose. Allons-y. 

## Ajouter autre chose

Eh bien mes Glider, mes planeurs. Les planeurs, on va partir du principe qu'ils planent mais ne peuvent pas voler qu'ils n'ont pas de système de propulsion, de système pour stabiliser et cetera. 

On va juste dire, on va faire, rajouter la moto qui fait partie, qui va hériter de véhicule.
```txt
	Vehicule (abstract)		    Flyable	  Building (abstract)
		   ^    				 ^	^ ^		^
		   |    				 |	| |		|
Glider ----+-------- Ship -------+	| +--- Cottage 
		   |				    	|
		Moto -----------------------+
```
Moto, elle va hériter de Vehicle comme les autres et je veux qu'elle aussi, elle soit capable de voler.

Donc on y va, on veut crèer une moto. Pareil, ici c'est moi qui travaille tout seul sur le même code mais dites-vous que dans des cas plus réel, on n'est pas forcément un développeur à travailler sur un projet tout seul. Il y a plein d'exemples de projets ou c'est une entreprise complête où il y a 10 20 50 250 personnes qui travaillent sur le même projet donc vous vous doutez bien que les gens ne travaillent pas sur les mêmes fichiers. Chacun a des fichiers à lui et jamais il va avoir besoin d'aller voir ce que fait l'autre donc ces fichiers. C'est important tout fonctionne bien ensemble à la base même si bon Il y a évidemment des bugs comme partout mais on arrive à faire fonctionner tout ce que d'ensemble. 

Donc on y va, on crèe une classe moto, on crèe Moto.java (copie de Ship.java, renommé en Moto.java).

+ Moto.java
```java
package jachampagne;

public class Moto extends Vehicle implements Flyable
{
	public Moto()
	{
		this.mMovementSpeed = 250;
	}

	public void moveXY(int x, int y)
	{
		System.out.println("je vais super vite !!");
	}

	public void fly()
	{
		System.out.println("Plein gaz, la moto decolle et s'en va dans les nuages");
	}
}
```
Ce n'est plus Ship mais Moto.

Elle hérite bien de la classe Vehicle. 

Elle implémente la capacité (Fly) elle est capable de voler par rapport à ça.

La moto se déplace assez vite, allez on est à fond, la moto c'est 250 kilomètres heure. On est fou après c'est pas beaucoup un 250 pour une moto, on a des motos qui vont beaucoup plus vite que ça.

MoveXY provient de Vehicle. Il faut obligatoirement la re-implémenter. Enfin bref on va dire que la moto se déplace : "je vais super vite !!". 

Attention c'est dangereux si vous roulez en vrai sur une moto, ne pas dépasser la limite autorisée sur la route. 

Et pour le vol, la moto elle va voler un peu à sa manière. On dira : "Plein gaz, la moto décolle et s'en va dans les nuages" et cetera et cetera. 

On fait ça et là en tant qu'utilisateur, on se dit Ben là maintenant je veux pouvoir faire voler une moto. 

Et là encore une fois tel que je l'ai montré tout à l'heure, on ajoute une moto :

+ App.java
```java
import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Flyable[] elements = {new Ship(), new Ship(), new Cottage(), new Cottage(), new Moto()};
		
		for(Flyable e : elements)
			e.fly();
    }
}
```

Comme je l'ai montré tout à l'heure, on fait ça `new Moto()`. C'est tout.

Il y a eu besoin de crèer un nouvel élément, terminé.

Je n'ai jamais retouché à la classe véhicule, je n'ai pas eu besoin d'aller voir les autres types de véhicule et je n'ai pas eu besoin non plus de toucher à l'interface Flyable. 

J'ai juste créé mon nouvel élément, la moto. 

J'ai créé ma nouvelle classe, ça il faut bien le faire on ne peut pas l'éviter. On crèe une nouvelle entité, il faut bien crèer le fichier et faire la classe et après là où j'en ai besoin Donc là c'est dans ma méthode main Mais ça peut-être ailleurs Dans un autre code, n'importe où, dans n'importe quel fichier. 

Dés que j'ai envie d'utiliser une moto, voilà comme la moto fait partie des éléments capables de voler, pas de problème ça fonctionne.
On peut produire un code générique et vous voyez sans modifier quoi que ce soit ... je vais exécuter ça :
```powershell
       >javac App.java
	>java App
       Le navire est propulse dans les airs
       Le navire est propulse dans les airs
       La chaumiere s'eleve peu a peu dans les airs
       La chaumiere s'eleve peu a peu dans les airs
       Plein gaz, la moto decolle et s'en va dans les nuages
```
Et voilà, " Plein gaz, la moto decolle et s'en va dans les nuages".

Voilà la moto vol comme le reste des éléments qui sont capables de voler. 

Là c'est le polymorphisme, tout simplement. 

Je pense qu'on va pouvoir s'arrêter là parce que de toute façon on a fait le tour de tout, c'est pour ça que j'avais réparti toutes ces notions a plusieurs vidéos car comme ça on termine la dessus et je trouve que c'était bien de finir cette grosse partie du cours Java sur le polymorphisme pour dire que oui tout ce que vous avez vu avant sur les classes abstraites, les interfaces, l'héritage et cetera vous permet à l'usage, attention ce n'est pas dans les définitions, dans les implémentations dans tous les fichiers mais dans l'utilisation, c'est de la réutilisation de code dans l'utilisation de ces éléments (App.java) et là vous allez gagner du temps en termes de code mais également en terme d'évolution de votre code parce que tel que je voulais montrer avec la moto, je peux faire évoluer mon programme et il y a plein de choses où je n'aurai pas besoin de retoucher. 

Parce que si vous recommencer encore une fois à devoir retoucher tous les véhicules parce que vous ajoutez une moto, c'est un défaut de conception. 

C'est que déjà à la base vous avez mal pensé votre code et qu'il y a un problème de ce côté et peut-être faut-il mettre en place une relation d'héritage, classe abstraite où l'ajout d'une fonctionnalité enfaite, d'un ensemble de fonctionnalités en surcouche c'est-à-dire une interface.

Je vous laisse avec cette partie-là, j'espère que la vidéo était suffisamment explicite, suffisamment détaillée. 

Là pour le coup il y a eu beaucoup beaucoup d'exemples que je vous ai donné sur cette dernière vidéo parce qu'il en fallait. Il y a des notions très rapide très simple à expliquer et il y en a d'autres ou je préfère multiplier le nombre d'exemples et les modifications pour que vous puissiez voir plusieurs scénarios possibles et pour qu à la fin de cette vidéo vous vous dites : "OK c'est bon, j'ai compris, je sais ce qu'est une interface, une classe abstraite, j'ai compris le polymorphisme et si un jour je fais encore en Java, je serai exactement quand est-ce que je dois utiliser et je sais surtout à quoi ça va me servir et ce que ça va m'apporter au niveau de mon code."

A bientôt pour une nouvelle vidéo sur la chaîne et n'hésitez pas à réagir dans les commentaires si vous avez une question ou quoi que ce soit et à partager bien évidemment ce contenu pour d'autres développeurs qui pourrait se mettre comme vous au langage Java. 

Ciao 