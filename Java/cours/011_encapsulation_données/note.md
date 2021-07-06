# [11. Encapsulation données](https://www.youtube.com/watch?v=zM_Qf07fEyc)

Bonjour tout le monde.

Bienvenue pour cette séance 11 en Java, on va aller un petit peu plus loin avec ce qu'on a vu précédemment concernant les méthodes mais pour parler plus exactement de l'encapsulation des données.

Donc c'est un concept quand même très important en programmation objet qu'on retrouve dans d'autres langages comme le C++ également ou c'est en fait un principe de règles assez strictes qui permettent de rendre le code beaucoup plus cohérent, beaucoup plus intègre en fait dans la manière dont il a été conçu.

On va aller sur un programme très simple donc on retrouve notre méthode main qui est pour le moment vide.
```java
public class App
{
	public static void main(String []args)
	{

	}
}
```
Et j'écrit une autre classe pour changer un petit peu des exemples que je montre un peu sur les vidéos qui s'appelle SoftwareRegistration donc on va simuler, même si c'est un cas très basique ici, un système d'enregistrement de licence d'un logiciel d'accord. Comment on pourrait gérer ça par exemple avec une classe ? je vais vous montrer comment ça se passe.
```java
public class SoftwareRegistration
{

}
```
Alors déjà, le principe d'encapsulation des données, qu'est-ce que ça veut dire ? En gros, en programmation objet, donc là c'est un concept propre à la programmation objet, pas forcément propre qu'à Java d'accord, c'est pas lié directement au langage en question mais à la manière de programmer en objet, c'est de dire tout simplement que chaque classe à quoi va posséder ses propres attributs et on ne veut pas pouvoir manipuler n'importe comment ces attributs à l'extérieur de cette classe. 

En gros ici tout ce qui concerne l'enregistrement en fait de notre logiciel, on veut que ça se passe ...tout ce qui manipulera les attributs de cette classe là, que ça se passe exclusivement dans la classe. Donc en bref, si c'est elle-même qui modifie ses attributs où qui y accède, elle peut le faire sans problàme, elle a tous les droits la dessus.

Par contre si c'est fait depuis l'extérieur de cette classe soit on interdit complàtement tout accès, modification de ces attributs ou alors on contrôlle ces accès, ces modifications en passant par ce qu'on appelle des accesseurs.

Les accesseurs que l'on appelle les getters et les setters, les deux cas sont en fait des méthodes qui vont permettre d'une part l'accès donc je vais mettre accesseur, on va retrouver les getters donc c'est accès à un attribut donc sa lecture en fait et on va avoir les setters donc là c'est modification d'un attribut.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/
}
```
Voilà, on a c'est deux cas là.

Ces méthodes sont évidemment à créer dans la classe en question et liée directement à un attribut particulier alors ici je vais faire ceci, pour le moment ça va rien faire du tout mais on verra par la suite.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration()
	{

	}
}
```
Et là, on va avoir des informations liées donc ici ...alors ce que je vais faire ...encore une fois c'est un code d'exemple, c'était histoire de changer un petit peu mais dans un cas concret, on fera quelque chose de beaucoup plus développée que ça, c'est histoire de vous montrer. Là par exemple, je vais mette voilà une année d'expiration par exemple et du coup est-ce qu'on lui passerais un paramêtre ? on peut le faire pourquoi pas. Donc on lui passeras en fait l'année en tant qu'entier ici pour faire simple.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
	}
	
	private int mExpirationYear;
}
```
Donc en gros, on va faire (App.java) comme ceci que on lui passerais, je ne sais pas moi, bah 2020.
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
	}
}
```
Voilà et du coup je vais mettre un petit message ici (SoftwareRegistration.java) pour qu'on le voit quand même... `...valide jusqu'en ...`, voilà ce genre d'information OK.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	private int mExpirationYear;
}
```
Donc ça pas de problàme, ici on fait évidemment l'affectation de cette variable `expiration` pour un attribut, comme c'est la classe elle-même en plus dans son constructeur qui modifie pour le coup l'attribut, pas de problàme, elle a le droit de le faire, cet attribut lui appartient.

Donc là `private int mExpirationYear`, on n'a pas de contrôlle ou de règles en particulier par rapport à ça.

Du coup, on va exécuter donc ce programme là, on va faire ça.
```powershell
	>javac *.java
	>java App
	Enregistrement du produit, valide jusqu'a :2020
```
Et là voilà enregistrement du produit valide jusqu'en 2020, pas de souci.

Maintenant, on sait faire, on sait créer des objets, gérer les paramêtres pour le constructeur, pas de problàme, ça fonctionne, il n'y a aucun souci là dessus. Donc ça c'est une chose.

Maintenant si je voulais par exemple modifier ...alors on va voir le cas par défaut parce qu'on avait vu d'ailleurs ça ... donc j'ai vu précédemment donc je vais aller assez vite ...et là je rappelle, donc par défaut, je mets sur cette chose là `int mExpirationYear;` ou alors comme ceci `public int mExpirationYear;`.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	int mExpirationYear; // <--
}
```
Donc si on met rien de toute façon c'est comme si vous mettiez public, sans contrôlle des données d'accord, sans encapsulation des données, rien ne m'empècherait de faire un moment donné, ce genre de chose là.
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		
		sr.mExpirationYear = 2050; // <--
	}
}
```
Et du coup même carrément de faire ça.
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		
		sr.mExpirationYear = 2050;
		System.out.println(sr.mExpirationYear);
	}
}
```
On va l'afficher donc on va faire.
```powershell
	>javac *.java
	>java App
	Enregistrement du produit, valide jusqu'a :2020
	2050
```
Et là, je me suis retrouvé donc depuis l'extérieur de ma classe SoftwareRegistration, a modifié l'année d'expiration de mon logiciel à 2050 et du coup le changement a bien été effectué donc c'est assez problàmatique.

Encore une fois parce qu'on n'a rien contrôllà par défaut c'est-à-dire que si à un moment donné n'importe qui depuis l'extérieur de la classe veux modifier un attribut ou simplement le lire alors qu'on n'a peut-être pas envie que l'attribution soit accessible, il pourra le faire parce qu'aucun contrôlle n'aura été effectué.

Donc en programmation objet, pour beaucoup de langage presque la totalité des langages qui permettent de programmer un objet, on va procéder à l'encapsulation des données pour dire bah cette classe ici `SoftwareRegistration`, elle a des attributs `int mExpirationYear;`, ça lui appartient donc elle, elle a l'accès à ces attributs et la modification de plein droit.

Par contre, tout ce qui est extérieur, tout ce qui est étranger à elle, à cette classe `SoftwareRegistration;` on doit soit interdire complàtement l'accès, la modification, on peut le faire, il suffirait simplement de faire tout en private et terminé, cas par défaut.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	--> private int mExpirationYear;
}
```
Là vous allez voir juste avec ce changement là.
```powershell
	>javac *.java
	>java App
	Enregistrement du produit, valide jusqu'a :2020
	2050

	C:\Users\js201\OneDrive\Formations\FormationVideo\Ressources\Java\011_encapsulation_données>javac *.java
	App.java:168: error: mExpirationYear has private access in SoftwareRegistration
					sr.mExpirationYear = 2050;
					  ^
	App.java:169: error: mExpirationYear has private access in SoftwareRegistration
					System.out.println(sr.mExpirationYear);
										 ^
	2 errors
```
Voilà ce que je voulais faire ici, impossible d'accord. On ne peut plus modifier du tout puisqu'on vous dit que `mExpirationYear` est un attribut privé d'accord de la classe SoftwareRegistration et on ne peut pas du coup faire ce genre de chose là.

Par contre, on va et on peut, si on veut contrôller l'accès et la modification. C'est-à-dire plutôt de forcément tout interdit, on peut se dire : "OK, depuis l'extérieur de la classe, tu vas pouvoir modifier cette information mais sous certaines conditions" et dans ce cas-là nous avons créer ces fameux accesseurs qui sont des méthodes un peu particuliére.

Donc c'est pour ça que avant, je vous avais fait le cours sur les méthodes parce qu'il fallait que vous sachiez comment euh qu'est-ce que c'est une méthode et comment créer vos propres méthodes avant de voir évidemment nos accesseur.

Donc généralement, nous avons 2 accesseur donc en fait un getter et un setter pour chaque attribut alors les plus simples à faire et je vais d'ailleurs les mettre ici (SoftwareRegistration.java)... c'est de cette manière, un getter donc au plus simple au plus minimal, c'est grosso modo ça `public`, il retourne le type de l'information en particulier donc là ça `public int`, c'est un type int donc c'est ça que ça va retourner et on lui met le mot get comme ça en minuscule au départ `public int get` et ensuite on met simplement ça le nom de l'attribut `public int getExpirationYear()` en fait en gardant une logique dans la syntaxe. Ca me prend généralement aucun paramêtre un guetteur, il va faire que ça : retourner l'attribut `return this.mExpirationYear;`.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}

	public void setExpirationYear(int expiration)
	{
		this.mExpirationYear = expiration;
	}

	private int mExpirationYear;
}
```
Donc c'est vraiment le plus simple des getters qu'on peut faire par rapport à un attribut.

Et le setter, c'est tout simplement quelque chose qui ne retourne rien, pareil qui vas porter un nom suffisamment explicite mais qui prend par contre une information ici, un peu comme si on faisait une espèce d'autre constructeur, voyez ça prend l'information comme le constructeur mais lié à l'attribut que l'on veut modifier en particulier et du coup bah `this.mExpirationYear = expiration;`.

Voilà pas de problàme donc ça c'est vraiment au plus simple d'ailleurs comme ils sont très courts ici, si on veut gagner quelques lignes, on peut s'amuser sans problàme à faire comme ça.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	public int getExpirationYear(){return this.mExpirationYear;}
	public void setExpirationYear(int expiration){this.mExpirationYear = expiration;}
	private int mExpirationYear;
}
```
...genre vous les mettez carrément ...vous pouvez même vous amuser à les mettre ici (après l'attibut) comme ça à chaque fois que vous créez un attribut en fait vous mettez les accessoires qui vont bien.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	private int mExpirationYear;
	public int getExpirationYear(){return this.mExpirationYear;}
	public void setExpirationYear(int expiration){this.mExpirationYear = expiration;}
}
```
Si après vous avez un autre attribut ici, je ne sais pas quoi... pareil, on ferait ses accesseurs liés mais ça c'est une question d'organisation de votre code.

Vous voyez il n'y a aucune règle qui est imposé, encore une fois c'est vous qui voyez donc je vais remettre tout ça.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}

	public void setExpirationYear(int expiration)
	{
		this.mExpirationYear = expiration;
	}

	private int mExpirationYear;
}
```
Donc ça c'est évidemment le cas par défaut alors ça vrai qu'au final, on s'est embetter à créer pour chaque attribut, 2 methodes supplàmentaires alors qu'au final on pourrait modifier directement là dedans (App.java).
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		
		sr.mExpirationYear = 2050;
		System.out.println(sr.mExpirationYear);
	}
}
```
Donc c'est pas là pour faire joli, c'est simplement pour garder ce principe d'encapsulation des données, ça veut dire que là au lieu de faire cette modification en accédant directement aux infos. 

Voyez là `sr.mExpirationYear = 2050;`, j'ai du coup accès aux noms des attributs sinon j'ai peut-être pas envie forcément de les révéler ici, ailleurs en fait que dans la classe SoftwareRegistration.

Eh bien je sais qu'il va y avoir des accesseurs pour faire ce genre de choses donc de faire en fait ceci, voilà. 
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		
		sr.setExpirationYear(2050);
		System.out.println(sr.mExpirationYear);
	}
}
```
Et là du coup pour la lecture, ce sera l'inverse, on utilisera le getter.
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		
		sr.setExpirationYear(2050);
		System.out.println(sr.getExpirationYear());
	}
}
```
Donc, je passe par les accesseurs, au lieu de faire des accès directs et là évidemment, il n'y aura plus de problàme.
```powershell
	>javac *.java
	>java App
	Enregistrement du produit, valide jusqu'a :2020
	2050
```
Voilà alors là où c'est intéressant, maintenant qu'on a des accesseurs, encore une fois, c'est comme on a vu précédemment par rapport aux méthodes, que l'on pouvait du coup factoriser du code et le jour on a besoin de modifier une méthode, on modifie qu'une seule fois et ça va se répercuter partout.

Et bien, c'est le même principe pour les accesseurs et c'est ça du coup qui est pratique. C'est que le jour où je veux dire par exemple que la date d'expiration, on refuse qu'elle soit modifiée et bien, on peut simplement faire ça.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}

	public void setExpirationYear(int expiration)
	{
		//this.mExpirationYear = expiration;
		return;
	}

	private int mExpirationYear;
}
```
Alors si vous faites ça `return;`, ça veut dire en fait retourne rien, je sais que je vous avez dit que quand on a un void, on n'as pas de return mais en fait si vous faites ça `return;`, c'est tout à fait possible quand vous avez un type de retour `void`.

Voilà en gros, bah là on lui dit : "bah voilà si t'essaye de toute façon d'appeler setExpirationYear()", ça ne marchera pas.

C'est une possibilité donc en gros si je teste mon programme là.
```powershell
	>javac *.java
	>java App
	Enregistrement du produit, valide jusqu'a :2020
	2020
```
Vous voyez qu'il n'y a pas de problàme, ça s'exécute mais le changement ne s'est pas effectuée d'accord.

Ou mieux si on veut carrément interdire bah on met même pas de setter.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}

	private int mExpirationYear;
}
```
Mais par contre la différence c'est que, alors déjà on aura plus ça, setExpirationYear(), cette méthode ne va plus exister donc évidemment il va me dire que cette méthode n'existe pas, voilà.
```powershell
	>javac *.java
	App.java:376: error: cannot find symbol
					sr.setExpirationYear(2050);
					  ^
	  symbol:   method setExpirationYear(int)
	  location: variable sr of type SoftwareRegistration
	1 error
```
setExpirationYear(), il va dire qu'elle n'existe pas et si éventuellement bon on voulait refaire le coup de `sr.mExpirationYear = 2050;` comme on avait tout à l'heure comme ceci et bien ça vous dira la même chose que tout à l'heure c'est-à-dire que l'attribut est privés.
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		
		sr.mExpirationYear = 2050;
		System.out.println(sr.getExpirationYear());
	}
}
```
```powershell
	>javac *.java
	App.java:478: error: mExpirationYear has private access in SoftwareRegistration
					sr.mExpirationYear = 2050;
					  ^
	1 error
```
L'attribut est privé, voilà *has private access* donc on ne peut pas le modifier donc voilà.

A vous de voir si vous voulez que ça génère une erreur en particulier ou alors non, de contrôller l'accès,de dire : "Ben non OK, c'est juste que nous on a fait ça `return;`".
```java
	public void setExpirationYear(int expiration)
	{
		//this.mExpirationYear = expiration;
		return;
	}
```
Et du coup bah si t'essaye de le modifier bah là, on veut pas que tu le modifie, d'accord.

+ class App
```java
		// ...
		sr.setExpirationYear(2050);
```

Alors plus tard on verra qu'on pourrait éventuellement lever une exception où indiquer une erreur pour dire bah non on n'autorise pas sa modification. 

D'accord là, comme on n'a pas encore vu comment gérer les erreurs et on n'a pas du tout vu les exceptions en Java, évidemment pour le moment on ne le verra pas.

...Alors qu'est-ce que j'ai fait encore ? oui attendez je suis parvenue assez loin. Voilà pas de problàme à ce niveau là. Donc pas de modifications qui ont pu être faites, on peut faire ce genre de chose.
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		
		sr.setExpirationYear(2050);
		System.out.println(sr.getExpirationYear());
	}
}
```
Et au niveau du getter c'est pareil, si à un moment donné, vous avez un attribut dans votre classe ...je ne sais pas lequel, vous ne voulez pas qu'on puisse lire une de ces infos, ça peut être par exemple un attribut qu'on va simplement utilisé pour pour faire fonctionner la classe et donc bah qui n'a aucun intérêt depuis l'extérieur. Ben pareil, on peut interdire en fait tout simplement.
```java
	public void setExpirationYear(int expiration)
	{
		return; // <--
	}
```
Donc là, ben le problàme c'est comme c'est censé retourner quelque chose c'est embétant donc le mieux c'est soit de faire bah tout simplement ça, voilà de faire un getter qui ne retourne rien, on fait un simple return.
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	public void getExpirationYear()
	{
		//return this.mExpirationYear;
		return;
	}

	public void setExpirationYear(int expiration)
	{
		//this.mExpirationYear = expiration;
		return;
	}

	private int mExpirationYear;
}
```

Pareil plus tard quand on aura vu les exceptions on pourrait dire bah non on n'autorise pas la lecture. La lecture par exemple est interdite d'accord de cette information ou autre, voilà on a plein de plein de manières de faire.

Mais en gros tout du coup peut être contrôlé là depuis ces méthodes là.
```java
	public void getExpirationYear()
	{
		return;
	}

	public void setExpirationYear(int expiration)
	{
		return;
	}
```
C'est bien plus pratique que, du coup, d'avoir des erreurs ou autres ici que si on avait aucun accesseurs.

Si on n'a aucun accesseurs et que tout est privé, évidemment la compilation ça ne marchera pas mais nous on ne veut pas forcément directement interdire tout.

On veut pouvoir contrôller, en fait, ce qui est fait avec ses attributs depuis l'extérieur donc utilisé pour ça les accesseurs.

La règle, c'est très simple, un attribut et vous avez du coup un getter et un setter par attribut d'accord. Vous avez une nécessité de le faire donc voilà comment ça se passe pour ça.

Alors ça c'était la partie encapsulation des données qui avait quand même son intérêt par rapport à ça.

On va voir maintenant une autre petite chose qui va terminer cette vidéo donc il sera du coup un peu plus courte que celle d'avant sur les méthodes qui concerne notamment des variables de classe donc c'est-à-dire qui ne nécessite pas d'instance.

Une variable de classe ce n'est pas pour le coup un attribut, c'est une variable qui en fait n'appartient pas à une instance en particulier par exemple si je fais un autre, je sais pas moi, si je fais : ... sr2... 2022 ...évidemment ça va se créer ... je vais retourner ça, un entier `this.mExpirationYear` pour getExperirationYear()... et ça setExpirationYear(), je vais pas le modifier pour le coup donc on va laisser comme ça, on exécute que, ok et voilà.
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		SoftwareRegistration sr2 = new SoftwareRegistration(2022);
		
		System.out.println(sr.getExpirationYear());
		System.out.println(sr2.getExpirationYear());
	}
}
```
```java
public class SoftwareRegistration
{
	/
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}

	public void setExpirationYear(int expiration)
	{
		return;
	}

	private int mExpirationYear;
}
```
```powershell
	>javac *.java
	>java App
	Enregistrement du produit, valide jusqu'a :2020
	Enregistrement du produit, valide jusqu'a :2022
	2020
	2022
```
On a créé deux produits et on affiche leur année d'expiration, pas de problàme ça fonctionne. 
Voyez que c'est lié à chaque instance, d'accord. Chaque instance évidemment donc chaque objet a ses propres attributs, ils ont chacune, chacun pardon leurs propres données, elles sont bien séparés. Chaque objet en fait a sa propre durée de vie et ses propres infos.

Moi j'aimerais avoir une variable qui sera partagé de dire bah voilà que SR et SR2, ils aient une variable concourante c'est-à-dire une variable qui soit commune à tous les 2. Ils auront du coup la même valeur pour la variable et ils pourront accéder à la même, d'accord et là comment ça fonctionne bah c'est une variable de classe.

Une variable de classe c'est un peu plus particulier du coup puisqu'elle ne va pas être ici donc avec un simple bah un simple mot clà pour le niveau d'accessibilité, son de retour ou autre mais elle va utiliser comme pour les méthodes de la fonction de la classe principale où on utilisait le mot clà static, on va préciser le mot avec le mot clà static sur attributs pour en faire une variable de classe.

En gros, et bien de faire tout simplement private, on peut mettre public où privé, peu importe je vais mettre private, ça suffit pour ce qu'on va en faire. `static int` et par exemple on va faire mNumberOfRegistrations et là par exemple je lui mette une valeur par défaut en disant ben 5. 
```java
public class SoftwareRegistration
{
	/*
		[Accesseurs]
			getters : acces a un attribut (lecture)
			setters : modification d'un attribut

	*/

	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}

	public void setExpirationYear(int expiration)
	{
		return;
	}
	
	private static int mNumberOfRegistrations = 5;
	private int mExpirationYear;
}
```
Et en gros qu'est-ce que ça simulerait ça de dire, on va pouvoir enregistrer par exemple notre logiciel mais jusqu'à 5 licences. d'accord.

Imaginez par exemple sur un ordinateur, vous avez un logiciel avec un code d'accord et bien votre code il est valide sur 5 ordinateurs, vous pouvez utiliser ce code sur 5 version du logiciel et au bout de 5 évidemment le code ne sera plus valide, d'accord. Vous aurez épuisé le stock de validation disponible. 

Et on va pouvoir faire ça comme ça donc en gros alors on va virer peut-être tout ça setExpirationYear() on n'a pas besoin. Bon ça getExpirationYear(), on verra plus tard.
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{
		this.mExpirationYear = expiration;
		System.out.println("Enregistrement du produit, valide jusqu'a :" + this.mExpirationYear);
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}
	
	private static int mNumberOfRegistrations = 5;
	private int mExpirationYear;
}
```
On va lui dire ça, on va virer ça (le contenu du constructeur). Le problàme c'est qu'on n'a pas encore vu encore une fois les exceptions donc on ne peut pas gérer des cas d'erreurs, peu importe.
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{

	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}
	
	private static int mNumberOfRegistrations = 5;
	private int mExpirationYear;
}
```
Première chose quand on va créer ici notre instance, on va vérifier une chose déjà est-ce que mNumberOfRegistrations est plus grand que zéro d'accord. Si c'est le cas, on va créer notre objet donc on va enregistrer l'information `this.mExpirationYear = expiration;`, d'accord. 
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{
		if(mNumberOfRegistrations > 0)
		{
			this.mExpirationYear = expiration;
		}
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}
	
	private static int mNumberOfRegistrations = 5;
	private int mExpirationYear;
}
```
On va du coup décrémenté le nombre d'enregistrements (mNumberOfRegistrations--) d'accord donc je rappelle hein ça revient encore une fois à faire (-=) moins égale hein d'accord.
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{
		if(mNumberOfRegistrations > 0)
		{
			this.mExpirationYear = expiration;
			mNumberOfRegistrations--;
		}
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}
	
	private static int mNumberOfRegistrations = 5;
	private int mExpirationYear;
}
```
On enlàve 1 en fait à mNumberOfRegistrations OK et puis ensuite on affiche un message éventuellement ...logiciel validé, d'accord ...expiration avec la date qui est indiquée.
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{
		if(mNumberOfRegistrations > 0)
		{
			this.mExpirationYear = expiration;
			mNumberOfRegistrations--;
			
			System.out.println("Logiciel valide (expiration : " + this.mExpirationYear + ")");
		}
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}
	
	private static int mNumberOfRegistrations = 5;
	private int mExpirationYear;
}
```
Et sinon, on n'a pas ce cas là et bien on pourra, on ne l'a pas encore une fois vu, mais on pourra afficher une erreur, lever une exception pour dire "Hé bah non tu as atteint le maximum", en fait donc là on va juste afficher un message.
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{
		if(mNumberOfRegistrations > 0)
		{
			this.mExpirationYear = expiration;
			mNumberOfRegistrations--;
			
			System.out.println("Logiciel valide (expiration : " + this.mExpirationYear + ")");
		}
		else
		{
			System.out.println("Maximum de validations effectuees !");
		}
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}
	
	private static int mNumberOfRegistrations = 5;
	private int mExpirationYear;
}
```
et après on pourrait éventuellement quitter enfin voilà c'est un peu un cas particulier donc ce genre de chose.

Le problàme c'est que là, il ne va pas forcément être content donc en fait on va juste faire ça. Le truc c'est qu'on va quand même créer une instance ici SoftwareRegistration(){ICI}.

Il faudrait ...parce que bon en fait quand on va lever, on verra plus tard, quand on va gérer les exceptions, on pourrait carrément interrompre le programme donc là c'est un peu plus compliqué qu'on n'a pas encore vu ça ...on n'aura pas forcément un cas suffisamment correct par rapport à ça.

Donc en fait, il faudrait retourner autre chose, c'est un peu pas forcément pratique parce qu'il nous manque encore des choses concernant la programmation Java qu'on a pas encore vu à ce stade de la formation.

Voilà en gros comment on pourrait gérer ça d'accord.

Celle-là, pas de problàme on va pouvoir enregistrer l'information pour notre instance de classe SoftwareRegistration, pour notre objet, réduire ce nombre là et on aura du coup ça (App.java).

+ SoftwareRegistration.java
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{
		if(mNumberOfRegistrations > 0)
		{
			this.mExpirationYear = expiration; //	<--
			mNumberOfRegistrations--;		   //   <--
			//...
```

Et ce qui est pratique, bah là c'est privé donc on n'a pas accès depuis ailleurs.

+ SoftwareRegistration.java
```java
private static int mNumberOfRegistrations = 5;	<--
```

Normalement je peux aussi mettre `("Enregistrements restants : " + this.mNumberOfRegistrations);` donc là je peux y accéder, je suis dans la classe donc c'est privé, pas de problàme, il y a accès d'accord.
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{
		if(mNumberOfRegistrations > 0)
		{
			this.mExpirationYear = expiration;
			mNumberOfRegistrations--;
			
			System.out.println("Logiciel valide (expiration : " + this.mExpirationYear + ")");
			System.out.println("Enregistrements restants : " + this.mNumberOfRegistrations);
		}
		else
		{
			System.out.println("Maximum de validations effectuees !");
		}
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}
	
	private static int mNumberOfRegistrations = 5;
	private int mExpirationYear;
}
```
Donc ça veut dire que mon objet SR et SR2 (App.java), ils auront en fait la même variable ici mNumberOfRegistrations, c'est-à-dire qui est par défaut à 5.

Donc dés je vais créer SR, ça va passer à 4 et l'autre ça va passer à 3 mais on va le voir de toute façon.
Après c'est encore une fois comme il y a un cas un peu particulier, normalement ça ne devrait pas poser de problàme mais voilà. 
```powershell
	>javac *.java
	>java App
	Logiciel valide (expiration : 2020)
	Enregistrements restants : 4
	Logiciel valide (expiration : 2022)
	Enregistrements restants : 3
	2020
	2022
```
Voilà donc voyez, on a validé un premier logiciel, on a plus que 4 enregistrements restants. On en enregistre un 2e, il n'en reste plus que 3, voilà.

Evidemment, au bout d'un moment quand on va vouloir en faire d'autres. Alors ça, j'en ai plus besoin de ces informations là, getExpirationYear().
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		SoftwareRegistration sr2 = new SoftwareRegistration(2022);
		
		//System.out.println(sr.getExpirationYear());
		//System.out.println(sr2.getExpirationYear());
	}
}
```
Alors je vais peut-être réduire le nombre qu'il y a. On va mettre genre que 2 maximum.
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{
		if(mNumberOfRegistrations > 0)
		{
			this.mExpirationYear = expiration;
			mNumberOfRegistrations--;
			
			System.out.println("Logiciel valide (expiration : " + this.mExpirationYear + ")");
			System.out.println("Enregistrements restants : " + this.mNumberOfRegistrations);
		}
		else
		{
			System.out.println("Maximum de validations effectuees !");
		}
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}
	
	private static int mNumberOfRegistrations = 2; 	//	<-- 5->2
	private int mExpirationYear;
}
```
Et comme ça, on en fera un 3e qui évidemment ne passera pas (SR3). On lui met 2020 aussi.
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		SoftwareRegistration sr2 = new SoftwareRegistration(2022);
		SoftwareRegistration sr3 = new SoftwareRegistration(2020);
	}
}
```
```powershell
	>javac *.java
	>java App
	Logiciel valide (expiration : 2020)
	Enregistrements restants : 1
	Logiciel valide (expiration : 2022)
	Enregistrements restants : 0
	Maximum de validations effectuees !
```
Voilà vous voyés, à l'exécution donc le premier, il n'en reste plus qu'un. On valide un 2e, il en reste plus que 0 et le 3e moment où on veut enregistrer sa licence, ça ne marche pas puisqu'on a effectué le maximum de validation disponible.

Donc ça montre bien qu'on travaillait bien sur la même variable.

+ SoftwareRegistration.java
```java
private static int mNumberOfRegistrations = 5; //	<--
```
Si ça n'avait pas été le cas et bah ça veut dire que pour chaque instance, elle aurait commencé à 2 donc en fait on aurait du coup un nombre d'enregistrement illimité.

Donc grâce au mot-clà static ici...

+ SoftwareRegistration.java
```java
private static <-- int mNumberOfRegistrations = 5;
```
..au lieu d'avoir un simple attribut, on obtient à la place une variable de classe qui du coup est commune véritablement à toutes les instances que nous allons créer (App.java).

+ App.java
```java
SoftwareRegistration ... = new SoftwareRegistration(...);
```
Voilà donc ça c'est quand même très important et pareil si j'avais fait ça `public`.

+ SoftwareRegistration.java
```java
public <-- static int mNumberOfRegistrations = 5;
```
... je pourrais accéder à l'élément en dehors mais c'est pas propre encore une fois pour la le principe de l'encapsulation donc on ferait simplement `public static int getNumberOfRegistrations()`.

Donc là je le met en statique parce qu'en fait vous allez voir. Alors, je vais faire `return this.mNumberOfRegistrations;`.
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{
		if(mNumberOfRegistrations > 0)
		{
			this.mExpirationYear = expiration;
			mNumberOfRegistrations--;
			
			System.out.println("Logiciel valide (expiration : " + this.mExpirationYear + ")");
			System.out.println("Enregistrements restants : " + this.mNumberOfRegistrations);
		}
		else
		{
			System.out.println("Maximum de validations effectuees !");
		}
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}
	
	public static int getNumberOfRegistrations()
	{
		return this.mNumberOfRegistrations;
	}
	
	private static int mNumberOfRegistrations = 2; 		<-- 5->2
	private int mExpirationYear;
}
```
Maintenant, je peux faire ça.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		
		System.out.println("ENREGISTREMENTS : " + SoftwareRegistration.getNumberOfRegistrations());
		
		SoftwareRegistration sr2 = new SoftwareRegistration(2022);
		SoftwareRegistration sr3 = new SoftwareRegistration(2020);
	}
}
```
C'est toute la différence. Je dit enregistrement et ici je vais dire SoftwareRegistration donc j'appelle le nom de la classe et je vais appeler la méthode statique pour le coup qui va bien `.getNumberOfRegistrations()`.

Donc pas besoin, vous voyez, de créer un objet en fait pour appeler cette méthode, c'est pas obligatoire.

Alors je peux passer par les instances là (sr), ce ne serait pas génant mais bon nous on veut le faire directement depuis ça `SoftwareRegistration`.

Donc là du coup bah chaque fois que je fais ça.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		
		System.out.println("ENREGISTREMENTS : " + SoftwareRegistration.getNumberOfRegistrations());
		
		SoftwareRegistration sr2 = new SoftwareRegistration(2022);
		SoftwareRegistration sr3 = new SoftwareRegistration(2020);
	}
}
```
Voilà donc je peux le faire à chaque nouvelle crçation pour que vous voyez un petit peu ce qui s'est passé à chaque fois, hop alors je peux même le faire avant d'ailleurs avant même la crçation d'un premier projet pour voir un petit peu. 

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		System.out.println("ENREGISTREMENTS : " + SoftwareRegistration.getNumberOfRegistrations());
		
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		System.out.println("ENREGISTREMENTS : " + SoftwareRegistration.getNumberOfRegistrations());
		
		SoftwareRegistration sr2 = new SoftwareRegistration(2022);
		System.out.println("ENREGISTREMENTS : " + SoftwareRegistration.getNumberOfRegistrations());
		
		SoftwareRegistration sr3 = new SoftwareRegistration(2020);
		System.out.println("ENREGISTREMENTS : " + SoftwareRegistration.getNumberOfRegistrations());
	}
}
```
Donc ça faut bien qu'il soit public et statique.

+ SoftwareRegistration.java
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{
		if(mNumberOfRegistrations > 0)
		{
			this.mExpirationYear = expiration;
			mNumberOfRegistrations--;
			
			System.out.println("Logiciel valide (expiration : " + this.mExpirationYear + ")");
			System.out.println("Enregistrements restants : " + this.mNumberOfRegistrations);
		}
		else
		{
			System.out.println("Maximum de validations effectuees !");
		}
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}
	
	public static int getNumberOfRegistrations() <--
	{
		return this.mNumberOfRegistrations;
	}
	
	private static int mNumberOfRegistrations = 2;
	private int mExpirationYear;
}
```
statique pour éviter d'avoir une instance à créer de SoftwareRegistration et public bah pour que ce soit accessible évidemment depuis l'extérieur puisque c'est un getter, je rappelle et là on termine du coup.
```powershell
	>javac *.java
	SoftwareRegistration.java:26: error: non-static variable this cannot be referenced from a static context
					return this.mNumberOfRegistrations;
						   ^
	1 error
```
Alors oui c'est pas THIS parce que encore une fois ce n'est pas un attribut.

+ SoftwareRegistration.java
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{
		if(mNumberOfRegistrations > 0)
		{
			this.mExpirationYear = expiration;
			mNumberOfRegistrations--;
			
			System.out.println("Logiciel valide (expiration : " + this.mExpirationYear + ")");
			System.out.println("Enregistrements restants : " + this.mNumberOfRegistrations);
		}
		else
		{
			System.out.println("Maximum de validations effectuees !");
		}
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}
	
	public static int getNumberOfRegistrations()
	{
		return mNumberOfRegistrations;
	}
	
	private static int mNumberOfRegistrations = 2;
	private int mExpirationYear;
}
```
THIS, on l'utilise pour un attribut. Vous voyez, il faut faire attention moi j'ai fait une petite erreur là, être attentif et voilà.
```powershell
	>javac *.java
	>java App
	ENREGISTREMENTS : 2
	Logiciel valide (expiration : 2020)
	Enregistrements restants : 1
	ENREGISTREMENTS : 1
	Logiciel valide (expiration : 2022)
	Enregistrements restants : 0
	ENREGISTREMENTS : 0
	Maximum de validations effectuees !
	ENREGISTREMENTS : 0
```
Donc on voit par défaut, on a 2 enregistrements. On crée et après un premier enregistrement, il n'en reste plus qu'un donc ça a été confirmée là de toute façon.
```txt
	Logiciel valide (expiration : 2020)
	Enregistrements restants : 1
	ENREGISTREMENTS : 1
```
Ensuite 0 et c'est effectivement le cas.

Voilà, comme ça, vous pouvez y accéder depuis l'extérieur, par rapport à ça et toujours pareil pour garder cette règle de l'encapsulation qui était le but de cette vidéo, ce concept là. 

On met tout en privé.
```java
	...
	private static int mNumberOfRegistrations = 2;
	private int mExpirationYear;
```
On passe par des accesseurs pour y accéder, voilà très important.

Alors là, on aurait pu mettre `SoftwareRegistration` mais là vous pouvez mettre le nom de l'attribut `mNumberOfRegistrations`, ça marche très bien aussi.

+ SoftwareRegistration.java
```java
public class SoftwareRegistration
{
	public SoftwareRegistration(int expiration)
	{
		if(mNumberOfRegistrations > 0)
		{
			this.mExpirationYear = expiration;
			mNumberOfRegistrations--;
			
			System.out.println("Logiciel valide (expiration : " + this.mExpirationYear + ")");
			System.out.println("Enregistrements restants : " + this.mNumberOfRegistrations);
		}
		else
		{
			System.out.println("Maximum de validations effectuees !");
		}
	}

	public int getExpirationYear()
	{
		return this.mExpirationYear;
	}
	
	public static int getNumberOfRegistrations()
	{
		return mNumberOfRegistrations;
		//ou
		//return SoftwareRegistration;
	}
	
	private static int mNumberOfRegistrations = 2;
	private int mExpirationYear;
}
```
Il n'y a pas de problàme pour accéder à une variable de classe.

Et voilà qui clàture du coup cette petite vidéo sur l'encapsulation des données, il y a quand même encore une fois pas mal de choses à voir.

J'espère bien que ça vous a plu, si vous avez des questions par rapport à ça comme d'habitude n'hésitez pas à poser dans les commentaires, à partager la vidéo, liker si vous avez connaissez des gens qui seraient intéressés par la programmation en Java.

On essayera de faire un cours le plus complet possible même si bon Java évolue quand même très très vite donc il y a plein de nouvelles choses qui arrivent mais j'essaierai de proposer quand même un cours assez complet et qu'on va pouvoir complàter tout ça aussi avec pas mal de tutoriels que vous retrouverez du coup en annexe qui pourront rajouter plein de choses au niveau du cours en Java.

Voilà je vous dis à très bientôt pour la prochaine vidéo et on se retrouvera du coup pour de nouveaux contenus sur formation vidéo.

Ciao