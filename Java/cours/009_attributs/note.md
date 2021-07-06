# [9. Attributs](https://www.youtube.com/watch?v=48wGbUfFtfM)
	
Bonjour à tous, bienvenue sur cette 9e séance Java.

La dernière fois on avait vu comment construire une classe et on a vu d'ailleurs quelque chose d'assez minimaliste puisque le but était tout simplement de créer une classe avec le moins de code possible d'accord donc ça revenait tout simplement ... on va reprendre le code qu'on a vu précédemment ... à avoir alors ici, un fichier d'accord que j'ai nommé dont Cat le nom de ma classe d'accord.

+ Cat.java
```java
public class Cat //<--
{
	public Cat()
	{
		System.out.println("Je suis un chat " + this);
	}
}
```
C'est le même nom ici que le fichier avec une majuscule très important et ensuite un constructeur donc un constructeur qui est une méthode un peu particulière qu'on aura évidemment l'occasion de revenir et d'expliquer un peu plus en détail quand on abordera justement les méthodes.

Les méthodes, je rappelle ce sont simplement des fonctions propres à une classe d'accord. C'est juste un autre nom en faite pour différencier des simples fonctions qu'on aurait dans un langage qui manipulent notamment, qui fait de la programmation procédurale alors que Java, on rappel, c'est un langage où on peut faire que de l'objet, on ne peut pas programmer autrement qu'en programmation objet.

Alors à partir de là donc on avait notre petit constructeur qui est ... mais pour le moment, on n'a pas parlé encore des histoires d'accessibilité et tout ce qui est encapsulation mais on en parlera aussi prochainement sur la formation donc on avait tout mis en public, pour dire voilà, notre classe de toute façon est accessible publiquement, donc ici.

+ Cat.java
```java
--> public class Cat
{
	public Cat()
	{
		System.out.println("Je suis un chat " + this);
	}
}
```
Evidemment le constructeur comme on doit pouvoir construire des chats en l'occurrence ici.

+ Cat.java
```java
public class Cat
{
	public Cat() //<--
	{
		System.out.println("Je suis un chat " + this);
	}
}
```
Construire des chats n'importe où donc par exemple dans mon fichier là.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		Cat c = new Cat();
	}
}
```
Pour pouvoir faire ce genre de chose d'accord, créer une nouvelle instance de la classe donc un objet qui sera stocké dans cette variable qui s'appelle C et bien on doit évidemment avoir notre constructeur public et à partir de là, on affichait un texte, rappelez-vous, très importants on utilisait le petit `this` qui permet en fait d'indiquer l'instance courante donc l'adresse en fait lié à l'instance en cours, celle qui est en train justement d'être utilisé.

+ Cat.java
```java
public class Cat
{
	public Cat()
	{
		System.out.println("Je suis un chat " + this); //<--
	}
}
```
On va rajouter des petites choses puisque là, il s'agit dans cette vidéo de voir et d'apprendre un petit peu qu'est-ce que sont les attributs.

Les attributs, grosso modo, pour la classe, je rappelle très rapidement, que ça représente en fait un modèle d'accord, un moule si vous voulez pour fabriquer quelque chose. Ca peut-être une entité, ici c'est le cas. Un chat, on peut représenter ça comme étant une entité, ça peut être un concept, ça peut être une idée, ça peut être vraiment voilà tout un tas de choses comme ça mais qui représente d'accord, pour représenter en fait et constitué un modèle de fabrication.

Notre classe est un modèle justement de fabrication. Son constructeur va permettre de la construire et une classe peut alors, c'est absolument pas obligatoire mais on va quand même retrouver ça dans la majorité des cas, avoir ce qu'on appelle des attributs.

Les attributs, c'est tout simplement un nom différent pour des variables donc vous savez ce qu'est une variable maintenant. On a fait une vidéo là dessus donc vous savez parfaitement ce que c'est mais un attribut, c'est tout simplement une variable qui appartient à une classe voilà.

Alors là c'est un cas particulier car comme je vous l'ai dit Java manipule forcément des classes tout le temps même pour une application la plus basique donc on pourrait dire bah en fait ça c'est pas vraiment une variable `Cat c` donc du coup c'est un attribut aussi d'accord. 

C'est un attribut ainsi de la classe App d'accord.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		Cat c = new Cat(); //c, attribut de la classe App
	}
}
```
Vous voyez c'est un peu particulier mais quand elle `c` est faites ici au sein d'une méthode main() donc une fonction de classe, on parle plus généralement de variable.

Par contre là vous allez voir un petit peu la différence c'est-à-dire qu'on va pas créer nos variables ici dans des méthodes en particulier, on va le faire en dehors.

Alors en Java généralement les gens déclarent leurs attributs au début de la classe mais dans d'autres langages on les met plutôt en bas, pourquoi ? parce que ce qui nous intéresse quand on va surtout re travailler donc réutiliser des classes par exemple que nous n'avons pas nous-mêmes développé... la première chose qui nous intéresse le plus sur une classe, c'est pas tellement les attributs quel a puisqu'on va faire que les manipuler, vous allez voir. C'est surtout ses méthodes c'est-à-dire ce qu'elle sera capable de faire cette classe, les services qu'elle propose.

Donc moi par habitude je les met en bas et vous pouvez bien évidemment les mettre en haut donc avant toutes les méthodes, il n'y a aucun problème, je vous imposerais jamais l'un ou l'autre encore une fois vous êtes libre d'accord.

Voilà c'est vous qui voyez selon vos préférences et pour que vous soyez en fait à l'aise avec votre manière d'écrire votre code.

A partir de là il y a quelques infos importantes. Comme n'importe quelle variable donc un attribut pour une classe va avoir un type. 

Moi par exemple, j'aimerais que mes chats ait un nom d'accord. 

Donc on va utiliser le type String. Pour le moment, on n'en a pas parlé du type d'ailleurs, vous verrez que c'est un cas un peu particulier mais on aura une vidéo sur les chaînes de caractères encore une fois.

+ Cat.java
```java
public class Cat
{
	public Cat()
	{
		System.out.println("Je suis un chat " + this);
	}
	
	String // <--
}
```
Voilà pour voir un petit peu ça en détail, vous verrez que c'est un cas particulier aussi.

Et on va mettre un nom. Alors pareil, c'est juste une question d'habitude, c'est pas une règle obligatoire, imposée et cetera.

Moi tout ce qui est attribué donc ce qu'on appelle en fait des variables membre, d'accord, membre d'une classe. Je met un petit m minuscule devant, pour dire member bah en faite pour savoir voilà que c'est un attribut liée à une classe et ensuite je commence par une majuscule avec le nom de la variable donc de l'attribut que je veux. 

Comme je veux un nom bah je vais mettre ça `mName`. 

+ Cat.java
```java
public class Cat
{
	public Cat()
	{
		System.out.println("Je suis un chat " + this);
	}
	
	String mName;
}
```
Comme ceci mName d'accord, memberName. Vous pouvez mettre un underscore si vous voulez, peu importe. Vous pouvez mettre juste ça `mName`, c'est vous qui voyez personnellement je vous en impose encore une fois rien du tout, c'est vous qui choisissez un petit peu tant que le nom est explicite.

Là `mName`, on comprend bien que c'est un nom lié au chat donc c'est le nom du chat, pas de problème à ce niveau là.

Et on va lui mettre un âge tout simplement, voilà.

+ Cat.java
```java
public class Cat
{
	public Cat()
	{
		System.out.println("Je suis un chat " + this);
	}
	
	String mName;
	int age;
}
```
Alors quand on écrit ce code par défaut, en tout cas pour des attributs donc voyez ils sont dans la classe mais ils sont dehors de toute méthode, ils sont vraiment mis directement à l'intérieur de la classe.

Le droit en fait donc le niveau d'accessibilité en fait de ces attributs sera par défaut en private donc en privé.

+ Cat.java
```java
public class Cat
{
	public Cat()
	{
		System.out.println("Je suis un chat " + this);
	}
	
	private String mName;
	int age;
}
```
Alors moi pareil, pour une question de préférence, généralement je préfère noter.
```java
	private String mName;
	private int age;
```
Je préfère toujours en fait que les infos sont indiquées surtout quand on a beaucoup beaucoup de code à re lire ou autre au moins on est sûr que là on a explicitement dit que l'on voulait ces attributs à privé, je préfère ça plutôt que de laisser par défaut euh la machine virtuelle le faire mais c'est vous qui voyez encore une fois.

Donc pour le moment, je ne vous expliquerai pas pourquoi, il est nécessaire, en tout cas préférable de mettre les attributs en privé et pas en public ou autre. On verra ça par la suite en tout cas retenez que pour le moment, vous les mettez en private donc soit vous indiquer explicitement le nom d'accord le niveau d'accessibilité. Soit vous mettez rien du tout et ça mettra en private aussi.

A partir de là, c'est le constructeur que nous allons modifier. Le constructeur donc on verra plus tard avec les méthodes, on va lui donner des paramètres quand on va ici construire un chat, je veux pouvoir lui dire mais en premier paramètre donc ça on verra plus tard ce que sont les paramètres d'une méthode d'accord mais bon le constructeur fonctionne un peu pareil... 

On va lui donner un nom par exemple, on va lui donner un âge d'accord. je vais donner ces 2 informations là, en premier une chaîne de caractères qui représentera le nom et ensuite l'âge.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		Cat c = new Cat("Kito", 1);
	}
}
```
+ Cat.java
```java
public class Cat
{
	public Cat()
	{
		System.out.println("Je suis un chat " + this);
	}
	
	private String mName;
	private int age;
}
```
Donc ça c'est bien quand je vais créer comme ça un chat, je vais instancier en fait une classe, la classe Kat dans un objet pour fabriquer un objet. 

J'ai ces infos `("Kito", 1)` mais comment je stocke en fait ces informations-là au niveau de mon instance donc au niveau de cet objet-là `c` c'est-à-dire que ce soit stocké dans cette variable pour par la suite ne pas perdre ces informations-là `("Kito", 1)`.

Eh bien nous allons tout simplement affecté aux attributs de la classe donc ce qu'on va faire tout simplement ... alors déjà ici `("Kito", 1)`, comme on n'a passé en fait en premier la chaîne de caractères pour le nom et ensuite l'âge, on modifie le constructeur.

On dit le constructeur, il a besoin de quoi ? il a besoin d'un nom donc vous pouvez mettre un nom simple, pas obligé de mettre un `m`, encore une fois, c'est un simple paramètres et ensuite l'âge.

+ Cat.java
```java
public class Cat
{
	public Cat(String name, int age)
	{

	}
	
	private String mName;
	private int age;
}
```
Et du coup ici `Cat(){ICI}`, on n'a plus qu'a faire ceci, voilà.

+ Cat.java
```java
public class Cat
{
	public Cat(String name, int age)
	{
		mName = name;
		mAge = age;
	}
	
	private String mName;
	private int age;
}
```
Ou alors vous pouvez bien sûr faire cela. Encore une fois, plus explicite, ça veut dire en fait que pour cette instance courante d'accord, l'objet qu'on est en train de créer, pour son attribut `mName`, on lui affecte la valeur qu'on a passé ici `name`.

+ Cat.java
```java
public class Cat
{
	public Cat(String name, int age)
	{
		this.mName = name;
		this.mAge = age;
	}
	
	private String mName;
	private int age;
}
```
Et d'ailleurs c'est souvent mieux de mettre le `this`, vous voyez que sa colore en fait, ça permet comme ça de mieux retrouver les termes, donc on peut faire ça de cette manière. Si vous ne mettez pas bah, ça ne va pas faire de coloration donc c'est peut-être moins lisible donc pareil c'est des questions de préférence, il y en a qui mettrons `this` parce que pour eux, ils savent vraiment qu'ils ont à faire à un attribut ici, donc quelque chose qui appartient à l'instance.

Si vous ne mettez pas des fois, c'est moins explicite mais encore une fois, c'est pas grave si vous ne mettez pas, c'est pas grave si vous mettez, c'est vous qui voyez.

Une fois qu'on a ça d'accord donc on a le constructeur qui est définit comme ça.
```java
	public Cat(String name, int age)
	{
		this.mName = name;
		this.mAge = age;
	}
```
Les attributs sont bien enregistrés logiquement toutes les infos y sont.

On va d'ailleurs vérifier qu'elles ont bien été enregistrées en faisant println, et qu'est-ce qu'on va passer comme information ? on va juste passer ça en fait `this.mName + " - " + this.mAge`. Je remet le `this` encore une fois, je rappelle qu'il n'est pas obligatoire mais c'est quand même mieux de le mettre voilà.

+ Cat.java
```java
public class Cat
{
	public Cat(String name, int age)
	{
		this.mName = name;
		this.mAge = age;
		
		System.out.println(this.mName + " - " + this.mAge);
	}
	
	private String mName;
	private int age;
}
```
Donc on va en fait lire les 2 informations alors là `private String mName` comme je ne va pas encore une fois rentré dans les détails concernant l'encapsulation. privé, en fait, pour faire simple au départ, ça veut simplement dire que ce qui était privée est accessible que dans la classe ou ça été définit c'est-à-dire que ici un attribut qui est déclaré en privé ne pourra être accessible que dans la classe donc il n'y a que la classe Cat qui aura en fait accès à ces attributs privés donc je peux sans problème  directement ici les appeler d'accord.
```java
		System.out.println(this.mName <-- + " - " + this.mAge);
```
... les appeler, en faire référence. Comme ils sont privés, ils lui appartiennent donc lui il peut les appeler, il peut en tout cas les lire ou même éventuellement les modifier, si on voulait, aucun problème par rapport à ça.

D'ailleurs là, on a fait une modification des attributs, on a modifié leurs valeurs. Ca on peut le faire.
```java
		this.mName = name;
		this.mAge = age;
```
Si par contre, c'était depuis une autre classe, on ne pourrait évidemment pas modifier ça puisque c'est en privé `private`.

On rentrera un peu plus dans les détails concernant justement tout ce qui est l'accessibilité, on va dire l'encapsulation des données.

Donc une fois que ça c'est fait.
On compile tout ça.
```powershell
	>javac *.java
	Cat.java:6: error: cannot find symbol
					this.mAge = age;
						^
	  symbol: variable mAge
	Cat.java:8: error: cannot find symbol
					System.out.println(this.mName + " - " + this.mAge);
																^
	  symbol: variable mAge
	2 errors
```
Alors j'ai fait, j'ai oublié quelque chose, qu'est-ce que j'ai oublié ?
Regarder, j'ai mis n'importe quoi.
```java
	private int age; --> private int mAge;
```
+ Cat.java
```java
public class Cat
{
	public Cat(String name, int age)
	{
		this.mName = name;
		this.mAge = age;
		
		System.out.println(this.mName + " - " + this.mAge);
	}
	
	private String mName;
	private int mAge;
}
```
J'avais oublié le petit m, c'est pas grave, ici on fait ça et voilà.
```powershell
	>javac *.java
	>java App
	Kito - 1
```
Et ça on récupère bien le mon et l'âge du chat, voilà tout simplement.

Donc on peu après du coup en créer encore une fois plusieurs. On peut très bien faire ça.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		Cat c = new Cat("Kito", 1);
		Cat c2 = new Cat("Felix", 5);
	}
}
```
Et ça va être exactement la même chose.
```powershell
	>javac *.java
	>java App
	Kito - 1
	Felix - 5
```
Voilà toutes les informations seront récupérés donc, en tout cas, tout au long de l'exécution d'accord. 

Encore une fois, ce sont des variables comme je vous l'avais expliquer. On déclare une variable ici `c`,  on instancie un objet de classe Cat dans celle-ci `c` donc on obtient objet. Evidemment à la fin, ici de la méthode quand on va sortir ici de la méthode main, évidemment les variables sont détruites donc les objets sont voilà détruit également.
```java
public class App
{
	public static void main(String []args)
	{
		Cat c = new Cat("Kito", 1);
		Cat c2 = new Cat("Felix", 5);
	} // <--
}
```
Donc on aura évidemment euh leur durée de vie va en fait être dans ce contexte; ça va durer de leurs déclarations jusqu'à la fin en fait de la méthode où ils ont été déclarés.

Bon voilà comment que ça se passe donc là on peut créer évidemment autant de chats que l'on veut. On peut faire des instanciation au niveau de cette classe pour avoir des objets, il n'y a aucun problème et toutes les informations seront là dedans `c` et `c2`.

Alors d'ailleurs justement, je vais vous montrer une petite chose à faire. Si je fais ça.

Ca ferra un petit peu la transition pour la prochaine vidéo. Par exemple si je fais `System.out.println(c.mName)`
```java
public class App
{
	public static void main(String []args)
	{
		Cat c = new Cat("Kito", 1);
		Cat c2 = new Cat("Felix", 5);
		
		System.out.println(c.mName);
	}
}
```
On aimerait faire ceci de dire bah tu prends cette instance, ce chat là et tu lis, tu affiches en fait son nom d'accord, rappelez vous c'est un peu près ce qu'on a fait là.

+ Cat.java
```java
		//...
		System.out.println(this.mName + " - " + this.mAge);
```
Sauf qu'ici au lieu de mettre le nom de variable `c.mName` parce qu'on n'en a pas on a dit `this`, c'est lui-même d'accord.
```java
	this.mName
```
Voyez, si vous avez compris `this`, c'est lui-même et là (App.java) bah comme c'est une variable qui fait référence, on n'a pas de `this` depuis l'extérieur mais le nom de la variable en question. 

Donc logiquement, si il n'y avait pas des histoires d'encapsulation, ce code devrait fonctionner et là pourtant si je fais ça.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		Cat c = new Cat("Kito", 1);
		Cat c2 = new Cat("Felix", 5);
		
		System.out.println(c.mName);
	}
}
```
+ Cat.java
```java
public class Cat
{
	public Cat(String name, int age)
	{
		this.mName = name;
		this.mAge = age;
		
		System.out.println(this.mName + " - " + this.mAge);
	}
	
	private String mName;
	private int mAge;
}
```
```powershell
	>javac *.java
	App.java:452: error: mName has private access in Cat
					System.out.println(c.mName);
										^
	1 error
```
On va avoir un problème, on met simplement qu'il va y avoir une erreur. On met que `mName has private access in cat` tout simplement en fait bah c'est un attribut qui est privé donc on ne peut pas y accéder depuis l'extérieur.

Ici ma classe App d'accord qui est l'application principale, c'est une classe qui est externe à la classe Cat donc elle ne peut absolument pas accéder à un attribut privé, quand je parle d'accès, je parle de lecture et modification ben c'est changer en fait la valeur de l'attribut, en gros c'est ça.

Donc voilà pourquoi on ne peut évidemment pas faire ça et vous verrez plus tard, on utilisera des méthodes qui s'appelle des accesseurs, des GETTER et des SETTER qui permettront justement de contrôler la manière dans ton lis et on éventuellement on modifie les attributs qui sont pris. Il faudra pour cela passer par des méthodes pour faire ça.

Donc c'est des choses qu'on retrouve dans pas mal de langage de programmation, en C++ notamment, en python beaucoup moins parce que python a une autre philosophie autour de l'encapsulation des données mais Java, C++, Csharp et cetera sont assez pas similaire concernant justement l'encapsulation des données. 

En gros, les attributs sont privés et on interdit la modification où l'accès direct aux attributs depuis l'extérieur d'une classe d'accord donc ça c'est des petits trucs comme ça et ça c'est des choses en fait qu'il faudra justement respecter, des conventions et des normes à respecter au niveau de ces langages de programmation.

Voilà pour ça, je pense qu'on va s'arrêter là c'est des vidéos très courte comme vous l'avez vu parce qu'il y a vraiment beaucoup beaucoup de choses.

C'est pas non plus pratique le Java parce que je pourrais encore une fois abordé plein d'autres choses. Par exemple, j'aurais pu directement aborder les méthodes et puis commence à aborder les accesseurs et vous parler des chaînes de caractères, de la lecture de données fin, il y a vraiment tout qui se mêle.

Donc c'est pas forcément évident de faire un cours pour chaque, un cours progressif parce qu'en fait l'ordre dans lequel j'ai fait mes vidéos pour la plupart, j'aurais pu les faire dans un autre ordre.

Honnêtement voilà elles aurait pu être faites dans un autre ordre mais bon comme il faut de toute façon voir les choses une à une, voilà peu importe l'ordre dans lequel s'est fait.

Tant que c'est fait, on va dire, voilà que chaque chose vu avant puisse vous servir par la suite.

Donc là, on a vu comment construire une classe précédemment. 

Là je vous ai montré comment étoffer un peu votre constructeur et manipuler donc des attributs, avoir des attributs pour cette classe donc ça va permettre un petit peu de compléter.

Pour la prochaine vidéo, pour la prochaine séance en tout cas parce ce que ça a été très très court, on verra justement les méthodes, on va commencer à en parler donc je rappelle ce sont des fonctions.

Alors vous allez voir comment créer vous-même vos méthodes et comment ça fonctionne, comment utiliser les paramètres, comment on retourne des valeurs et cetera, comment on appelle des méthodes et cetera même si on a quand même déjà pas mal manipulé mine de rien ... pas trop de choses en même temps si on veut commencer à programmer, il faut bien manipuler des méthodes, on ne peut pas faire sans.

Mais on regardera comme ça, la prochaine fois bien en détail et on parlera de l'encapitulation.

Justement on reviendra sur cette histoire d'accessibilité des attributs et on commencera à faire nos premiers accesseur pour voir un petit peu comment on gère justement l'accès de la modification de nos attributs depuis l'extérieur, éventuellement d'une classe.

Voilà, si il y a des questions, n'hésitez pas pour cette vidéo et moi je vous dis à bientôt pour la prochaine séance en Java.

Ciao tout le monde.