/*
	Java #19 - classes abstraites
	
	Bienvenue sur cette formation en langage Java pour la séance 19. 
on va continuer un petit peu sur les notions qu'on avait vu précédemment et là sur la vidéo, je vous l'avais dit, vous allez avoir pas mal de séance sur des notions très liés mais que j'ai évidemment séparé les notions par vidéo pour que ce soit plus facile pour vous mais vous allez quand même retrouver pas mal de choses qui sont en lien chacune avec les autres qui vont vous permettre comme ça d'avancer un petit peu. 
Pour cette vidéo, nous avons parlé des classes abstraites alors vous savez ce qu'est une classe, vous savez comment construire une classe en Java, comment utiliser des attributs, faire des méthodes et cetera. 
On a même abordé l'héritage, notion très très importante de la programmation Et à partir de tout ça on va pouvoir intégrer une autre notion un peu particulière mais qui a besoin d'être connu et qui concerne des classes abstraites.
*/

//import jachampagne.* ;
//public class App
//{
//	public static void main(String[] args)
//	{
//
//	}
//}

/*
Alors une classe abstraite… Alors on a une classe générale particulière comme on sait le faire habituellement qui est une classe bien précise, une classe concrète qui représente qui représente en fait quelque chose: une entité, un concept, une idée ou n'importe quoi et on sait exactement ce que l'on veut représenter. 	
Si on prend un exemple tel qu'on a pu l'aborder dans d'autres vidéos, si on cherchait par exemple une classe pour représenter un certain type d'animal comme un chien, on ferait une classe pour le chien Il en aurait comme ça ses différents états et son comportement donc ces attributs, ces méthodes, pas de problème par rapport à ça.
Maintenant si au cours de mon projet, un programme que je veux réaliser, j'ai un peu une certaine idée générale de ce que je veux faire intervenir dans le programme et la du coup on va créer un exemple pour pouvoir en fait créer des espèces, des êtres vivants, on peut prendre cet exemple. 


On est d'accord qu'un être vivant est une notion très abstraite, qui est très vague. Un être vivant finalement ça englobe énormément de choses donc si je disais que là dans un programme, j'ai besoin de pouvoir créer des êtres vivants. C'est très voire même trop général pour pouvoir faire quelque chose pourtant je veux quand même au niveau du code, je veux représenter un être vivant de manière abstraite mais je veux quand même en avoir une représentation. 

Pour ça on va créer une classe abstraite, la classe abstraite c'est très simple, on va créer un fichier de toute façon comme on le fait habituellement, on va l'appeler du coup avec le nom de mon espèce vivante donc on va l'appeler LivingSpecies. 

LivingSpecies.java

package jachampagne;

On écrit package en changeant le nom mais ça ne change pas grand-chose, c'est pour réviser l'usage de package en Java. 
Et là avec une classe qu'on aurait concrète au départ, on ferait : 

package jachampagne;

public class LivingSpecies
{

}

Et ensuite à l'intérieur de public class Livingspecies{}, on aurait notre constructeur, éventuellement des attributs privé ou protégé si on veut faire de l'héritage, des méthodes et cetera et cetera. 

Le problème et on l'avait dit, c'est que pour moi c'est quelque chose de très vague c'est à dire que je n'ai pas envie concrètement de dire ce que c'est qu'une espèce vivante parce que on a dit tout à l'heure c'est quelque chose de très général et quelque chose qui englobe tout un tas d'être vivant potentiel. Donc je veux que ça reste abstrait et pour ça nous avons le mot-clé abstract qui va permettre de transformer cette classe de manière abstraite : 

package jachampagne;

abstract public class LivingSpecies
{

}

une classe abstraite, alors ce n'est pas forcément, il va y avoir des exceptions et c'est vrai que j'avais à quelques exceptions là dessus, c'est généralement une classe qui a au moins une de ces méthodes qui est aussi abstraite. Il y a certains langages qui obligent à rendre votre classe abstraite et vous verrez que dans certains langages vous pourrez compiler même si au final vous n'avez aucune méthode abstraite et que votre classe l'est. Donc faut faire attention des fois, il peut y avoir des petites particularités propre langage mais dans l'idée, dans le principe même, une classe est abstraite dès lors, doit être en tout cas indiqué, pour le développeur en tout cas c'est un indicateur très important … Abstraite à partir du moment où l'une de ces méthodes au minimum est abstraite aussi. 

Alors pourquoi cette importance de savoir ça, tout simplement que cette classe abstraite, on va jamais pouvoir l'instancier, on va jamais en fait pouvoir créer des objets d'espèces vivantes parce que encore une fois, nous dans l'idée, on veut avoir quelque chose qui représente ça mais on ne veut pas commencer à créer des espèces vivante parce que c'est beaucoup trop vague, comment peut-on déterminer le comportement d'une espèce vivante ? Encore une fois c'est trop vague on ne peut pas se représenter ça.

Donc en termes de code, on va mettre protected String et le nom mName :

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;
}

On va dire qu'on veut quand même représenter, dans l'idée que l'on veut se représenter nous de l'espèce vivante, elle aura un nom. Donc ça il n'y aura pas de problème là dessus, elle aura un nom. 

On va implémenter une méthode, on va l'implémenter comme si on avait une classe normale, une classe concrète, Une méthode qui permettra de savoir qui, qui suis-je, qui est cette espèce vivante donc on va faire simplement :

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{

    }
}


en fait ce sera un genre d'accesseur, une sorte d'accesseur, un getteur sauf qu'on va pas l'appeler get quelque chose mais on va dire simplement public String whoAmI() Et du coup je vais simplement lui dire de faire un return mName :

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{
		return mName;
    }
}

On fait un return mName pour dire qu'une espèce quelconque, on verra plus tard, voudra savoir qui est-elle Eh bien on retournera son nom. C'est le moyen de s'identifier, on considère cela comme ça. 

Est à côté, ben pour moi une espèce vivante ça peut faire pas mal d'autre chose. Ça peut par exemple … voilà ici au début on va mettre void parce qu'on ne sait pas ce que ça a besoin comme information En termes de code donc pour moi ça ne retourne rien (void), Ça ne prendra aucun paramètre et ça va avoir un nom, par exemple manger (eat) : 

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{
		return mName;
       }
       public void eat()
}


       une espèce vivante dans la représentation que l'on se fait, peux manger mais ça ce n'est pas suffisant parce que si on fait juste public void eat(), on est obligé d'implémenter, on est obligé d'implémenter notre méthode :

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{
		return mName;
       }
       public void eat()
       {
       
       }
}

On est obligé d'implémenter mais comme on avait dit une classe est abstraite à partir du moment ou une au minimum de ces méthodes est abstraite aussi donc on va réutiliser ce mot-clé pour une méthode et alors cette méthode ici n'a pas besoin d'être implémentée, on ne le fait pas et on la laisse tel quel. 

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{
		return mName;
	}
	abstract public void eat();
}

Alors on pourrait mettre à la place de void, un type de retour, et des valeurs si on voulait en paramètres ..eat(…) Mais si vous n'êtes pas capable de vous dire tout de suite, concrètement, ce qu'il y aurait et bien vous mettez rien en paramètre. Vous mettez void et rien entre parenthèses.
Et on peut éventuellement écrire d'autres choses, on va pas forcément en faire plein parce que par la suite vous allez voir ça va rajouter pas mal de travail. Mais en gros on peut dire speak(), parler :

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{
		return mName;
    }
    abstract public void eat();
    abstract public void speak();
}

On peut dire speak pour parler bien que ce soit un peu bizarre mais bon pourquoi pas. Et ça c'est ma classe abstraite, c'est ma représentation très vague très abstraite, c'est le cas de le dire, d'une espèce vivante. Une espèce vivante qui peut manger. On le voit, on le voit tout de suite, elle peut manger (eat), elle peut parler (speak), elle peut s'identifier (whoAmI) d'une certaine manière et la seule information que la manière vague c'est un nom (mName). 

Donc ça c'est notre classe et bienvenue évidemment comme c'est abstrait, on ne peut pas, très important, faire ceci (LivingSpecies ls = new LivingSpecies) :

App.java
--------
*/
//import jachampagne.*;
//
//public class App
//{
//	public static void main(String[] args)
//	{
//		LivingSpecies ls = new LivingSpecies();
//	}
//}
/*
Donc on ne peut pas faire "LivingSpecies ls = new LivingSpecies" et dire qu'on crée une instance de la classe LivingSpecies, Déjà parce qu'on n'a pas défini de constructeur et en plus elle est abstraite donc si vous essayez de créer une instance, de toute manière et on peut bien évidemment tester pour voir, on va vous dire que : 

	App.java:172: error: LivingSpecies is abstract; cannot be instantiated
                LivingSpecies ls = new LivingSpecies();
				
On va vous dire que LivingSpecies is abstract donc vous ne pouvez pas l'instancier tout simplement Donc ça c'est un moyen de voir qu'elle est abstraite et qu'on ne créé pas une instance d'une classe abstraite.

donc du coup vous vous dites peut être que si on a une classe qu'on ne peut pas instancier, à quoi nous sert elle ? Parce qu'on a fait une classe qui normalement, on a appris qu'une classe permettait d'avoir un modèle de construction, de fabrication de quelque chose mais au final si on ne peut pas le construire sur quelque chose Ben elle sert un peu à rien cette classe. 

il ne faut pas voir cela comme quelque chose qui nous ferait gagner du temps On nous apporté des fonctionnalités là au niveau de nos classes mais c'est surtout quand vous allez les utiliser c'est classe que vous allez gagner beaucoup de temps et apporter plein de fonctionnalités très intéressant en terme de code pour l'usage de classe, pas dans le code même des classes . Et ça c'est quelque chose qu'on verra dans une séance prochaine quand on parlera notamment du polymorphisme. Il faut également qu'on parle des interfaces, ces 2 notions. 

Pour la prochaine séance, on parlera, je peux vous le dire, des interfaces et la séance d'après on abordera le polymorphisme qui est très relié justement très lié aux classes abstraites, aux interfaces qui sont bien souvent 2 notions qui sont énormément confondues par les développeurs qui sont en train d'apprendre donc on aura l'occasion de faire le tour de tout ça. 

Donc là pour pas trop mélanger, pour ne pas en faire trop d'un coup, il faut comprendre que on ne peut pas faire :

	LivingSpecies ls = new LivingSpecies();

On ne peut pas faire ça, c'est une classe abstraite, on ne peut l'instancier. On ne se pose même pas la question. 

Maintenant de cette classe abstraite, il faut en avoir quelque chose de concret. C'est-à-dire que à partir de ça maintenant, vous allez pouvoir créer des classes concrètes, des espèces vivantes concrètes qui auront du coup des informations bien concrètes, elles aussi. Donc ça c'est très important. 

Première chose qu'on va faire, donc je ne vais créer qu'une seule classe, je ne vais pas en faire plusieurs des classes concrètes parce que on ne va pas faire un code qui prend 15 ans. Je vais tout simplement faire un tigre :

	Tiger.java

	package jachampagne;

On insère le même paquet, on fait un copier coller de LivingSpecies pour gagner un peu de temps. Ici on pourrait faire une classe abstraite qui hérite d'une autre classe abstraite, on peut tout à fait faire ça, on peut créer une hiérarchie de classes abstraites, il n'y a aucun problème mais ici on va vraiment nous, parce qu'on ne va pas faire trop trop de code, faire une classe concrète directement, donc : 

package jachampagne;
	
public class Tiger extends LivingSpecies
{

}

On fait public class Tiger Qui étend notre classe abstraite LivingSpecies, je rappelle que cet héritage est parfaitement normal, parfaitement logique parce qu'on peut dire qu'un tigre est une sorte d'espèces vivantes. On comprend tout de suite qu'il y a une relation d'héritage. J'ai fait ma classe abstraite pour ça sinon alors pour le coup servi à rien.

Et maintenant comment ça marche en termes d'objets concrets parce qu'ici on a une classe concrète ? et Ben déjà on va pouvoir la construire, on va pouvoir fabriquer des tigres, ça c'est important :

package jachampagne;
	
public class Tiger extends LivingSpecies
{
	public Tiger()
	{
       
       }
}

Le tigre, comme il est ici, précis, je ne vais pas lui donner un nom en particulier, je vais simplement dire que le nom de la classe abstraite, rappelez-vous qu'on a fait un attribut protégé dans LivingSpecies.java soit "protected String mName", donc on l'a hérité bah je vais dire c'est un tigre tout simplement.

package jachampagne;
	
public class Tiger extends LivingSpecies
{
	public Tiger()
	{
		mName = "Tigre";
    }
}

On dira juste que quand on crée un tigre, son nom c'est tigre, voilà on ne va pas cherché plus loin pour le moment. 

Cette méthode whoAmI (LivingSpecies.java), voyez que comme la class Tiger en hérite, on va tester et va faire 

	Tiger ti = new Tiger();
	ti.whoAmI();
	
C'est logique parce qu'encore une fois, c'est juste de l'héritage comme on l'a vu précédemment (Tiger extends LivingSpecies).
Pas de surprise sauf que là il y a une petite nouveauté avec l'abstraction Et là vous allez voir que ce n'est pas suffisant. 

App.java
--------

*/
//import jachampagne.*;
//
//public class App
//{
//	public static void main(String[] args)
//	{
//		//LivingSpecies ls = new LivingSpecies();
//		Tiger ti = new Tiger();
//		ti.whoAmI();
//	}
//}
/*
LivingSpecies.java
------------------

package jachampagne;

abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{
		return mName;
    }
    abstract public void eat();
    abstract public void speak();
}

Tiger.java
----------

package jachampagne;
	
public class Tiger extends LivingSpecies
{
	public Tiger()
	{
		mName = "Tigre";
	}
}

Et là vous allez voir que ce n'est pas suffisant, je vais vous la recompiler et là il me dit que Tiger n'est pas abstrait, n'est pas une classe abstraite Et toi du coup pensez à override c'est-à-dire à écrire, à implémenter pour le coup, les méthodes de la classe abstraite.

	error: Tiger is not abstract and does not override abstract method 	speak() in LivingSpecies
	public class Tiger extends LivingSpecies
	       ^

Ça veut dire en gros, il y a 2 méthodes abstraite eat() et speak() dans ma classe abstraite , qui le sont aussi, qui sont non implémenté du coup par définition. 

Et autant pour une espèce vivante comme c'était une classe abstraite (LivingSpecies), on n'avait pas besoin De préciser comment un être vivant mange et comment il parle parce que ça peut être différent celon l'animal en question Ou les êtres vivants en question Parce qu'il n'y a pas que des animaux dans les êtres vivants par contre pour un tigre on va être obligé de l'implémenter Parce que le tigre il ne va pas manger et parler n'importe comment, communiquer n'importe comment. Nous aurions pu mettre communiquate et au lieu de speak mais peu importe.



À partir du moment où vous avez des méthodes ici abstraite dans votre classe abstraite…

    abstract public void eat();
    abstract public void speak();

… dès que vous avez une classe concrète concrète qui en hérite, vous devez obligatoirement, ça permet en plus de ne pas faire l'erreur parce que vous voyez sinon ça ne compile pas. Donc ça vous force, et ça évite les oublis, ça vous force à implémenter les fameuses méthodes abstraites.

Donc je reprends le code "public void eat()" et je l'implémente dans la classe Tiger :

Tiger.java
----------

package jachampagne;
	
public class Tiger extends LivingSpecies
{
	public Tiger()
	{
		mName = "Tigre";
	}

	public void eat()
       {
       	
       }
}

Ça peut éventuellement retourner autre chose que void, Comme ça peut prendre pour le coup des paramètres puisqu'on va pour le coup l'implémenter on peut changer un petit peu la signature par contre on garde le même nom de la méthode.

On fait pareil avec speak(), on copie public void speak(). On ne fera pas de modification ici …

package jachampagne;

public class Tiger extends LivingSpecies
{
	public Tiger()
	{
		mName = "Tigre";
	}

	public void eat()
       {
       	
       }
       
       public void speak()
       {
       
       }
}

Et donc l'implémentation est obligatoire. On est dans une classe concrète, on doit implémenter absolument toutes les méthodes abstraites de la classe parente. Je n'ai pas besoin d'autres attributs donc je n'en rajoute pas. On pourrait mettre d'autres choses par exemple comme l'âge d'un tigre ou n'importe quoi d'autre mais je ne m'embête pas.

Alors comment on l'avait dit, une classe abstraite peut hériter d'une autre classe abstraite. En effet, j'aurais pu aller plus loin En disant je fais une classe concrète par exemple pour un homme et côté je fais une autre classe abstraite qui est un animal. Et ensuite de animal je crée des espèces d'animaux concrets donc en gros on aurait LivingSpecies, classe abstraite, on aurait en héritage, une classe animal et ensuite au aurait plein de classes concrètes de Animal comme chat, dauphin, lion Et cetera. Et l'homme serait une autre classe mais directement concrète héritant de cette classe abstraite LivingSpecies. 

Voilà on peut faire ce genre de hiérarchie.

Voilà pour éviter de faire trop de code et pour éviter que ce soit trop long pour la suite, on va se contenter de ça est-ce que le principe sera suffisamment explicite de cette manière.

Donc voilà on va implémenter ça.
Même si on n'a rien mis dans le code, il considère quand même que c'est implémenté. Même si ça ne fait rien, de toute manière ça ne retourne rien. Pour lui c'est suffisant :

Tiger.java
----------
…
	public void eat()
       {
       	
       }
       
       public void speak()
       {
       
       }
…

L'information, il faut l'afficher avec System.out.println(ti.whoAmI()).

App.java
--------

*/
//import jachampagne.*;
//
//public class App
//{
//	public static void main(String[] args)
//	{
//		//LivingSpecies ls = new LivingSpecies();
//		Tiger ti = new Tiger();
//		//ti.whoAmI();
//		System.out.println(ti.whoAmI());
//	}
//}
/*
On va afficher directement le contenu. 
	javac App.java
	java App
Pas de problème au niveau de l'héritage, on récupère bien le retour de la méthode whoAmI() qui a été implémentée dans la classe LivingSpecies et donc si je voulais la changer dans tigre, on a déjà vu comme ça comment redéfinir des méthodes, on pourrait le faire si on veut changer la manière dont on s'identifient pour le tigre où spécifiquement pour le tigre. 

Moi vu que je n'ai pas envie que ça change, c'est pour ça que je l'ai mis dans la classe LivingSpecies pour dire peu importe l'espèce vivante dès qu'elle utilisera whoAmI(), elle retournera ce qu'elle doit retourner.
Sergent vous créez une nouvelle classe dans votre programme même si c'est 5 mois 6 mois ou un an plus tard dans votre programme et que spécialement pour cette classe vous dites non, celle-là je veux que whoAmI, elle fasse autre chose Eh bien vous pouvez redéfinir cette méthode. Aucun problème spécifique dans la classe que vous venez de créer.

Encore une fois n'oubliez pas, ça va chercher une méthode dans la classe la plus proche donc l'actuel si elle n'existe pas on va remonter dans les classes parentes jusqu à en trouver une. Et s'il n'y en a vraiment pas du tout, alors là il y aura il y aura un problème lorsque vous essayez d'appeler une méthode qui n'existe pas mais ça c'est encore autre chose. 

Ensuite on va dire comment le tigre mange mais là on ne va pas s'embêter on va juste mettre un petit texte encore une fois pour simuler ça. On va mettre par exemple « je mange de la viande » Et pour la méthode speak, on va dire « je rougis … ». 

Tiger.java
----------
…
	public void eat()
       {
       	System.out.println("Je mange de la viande…");
       }
       
       public void speak()
       {
       	System.out.println("Je rugis…");
       }
…

Nb. C'est le lion qui régit n'est pas le tigre mais je ne sais plus le terme exact en tête mais ce n'est pas grave. 

Alors là du coup on peut se représenter, parce que voilà un tigre mange d'une certaine manière il communique d'une certaine manière. Il a un nom bien spécifique, c'est quelque chose de concret encore une fois. Encore une fois ce qui est concret, on peut poser des noms des choses dessus. Encore une fois on était dans quelque chose d'abstrait, ça ne voulait pas dire grand-chose donc on avait quand même besoin d'une représentation. 
Alors tout de suite vous allez peut-être vous dire que ça sert à rien qu'on aurait pu directement faire une classe Tiger et terminer mais quand on abordera la vidéo plus tard sur le polymorphisme parce que cette vidéo est une introduction pour ce qu'on abordera concernant le polymorphisme quand vous aurez également vu les interfaces. 

Donc c'est pour le moment vous ne voyez pas trop l'intérêt de se servir de classe abstraite, c'est normal c'est parce que je ne veux pas avoir déjà les interfaces de toute façon est le polymorphisme maintenant. On regardera ça dans la vidéo prochaine. 

C'est parfaitement normal c'est pour l'instant vous n'en voyez pas forcément les utilités, c'est logique je ne peux pas te voir tout de suite et je ne veux pas voir tout voir tout de suite avec vous.

Donc on a déjà ça comme comportement :

Tiger.java
----------

package jachampagne;
	
public class Tiger extends LivingSpecies
{
	public Tiger()
	{
		mName = "Tigre";
	}

	public void eat()
    {
    	System.out.println("Je mange de la viande…");
    }
    
    public void speak()
    {
    	System.out.println("Je rugis…");
    }
}

Donc on a déjà ça comme comportement déjà premier avantage que vous pouvez voir, c'est encore une fois, on part en tant que développeur d'une représentation. Et ce qui est pratique et qu'il faut penser qu'un jour, et là il faut penser qu'on n'est pas forcément seul ou que votre code peut être réutilisé parce qu'un principe de la programmation objet est la réutilisation de code. C'est un des arguments important par rapport à ce type de paradigme Eh bien si un jour une personne veut réutiliser votre code et qu'il veut créer une espèce vivante et bien ce qu'il va faire, c'est qu'il va créer sa petite classe genre par exemple Dog pour créer un chien L'automatique mens il essaie de rien mettre ou qu'il fait ses petits trucs à lui, il va vouloir compiler le code et ça lui mettra justement les messages pour dire " et là il faut que tu nous expliques Comment communique ton chien t comment il mange ? ". Automatiquement il se dira, il saura qui doit implémenter ces méthodes là :

    abstract public void eat();
    abstract public void speak();

Si on n'avait pas d'histoire d'abstractions déjà, Eh bien il n'y aurait pas forcément d'erreur pour beaucoup de choses et ça ne poserait pas de problème. Il aurait des animaux, il aurait un chien Qui n'a pas de comportement pour manger communiquer et sauf que si un jour, on dit qu'on a toutes nos espèces vivantes et ici on va faire une légère petite intro polymorphisme Et on dit toutes les espèces vivantes qu'on a, peu importe Ce qu'elles sont, on veut les faire parler tout de suite et le problème est que si le chien qui héritent pourtant des espèces vivantes. on n'a pas expliqué comment il est ce qu'il communiquait Eh bien on va avoir tous les animaux qui vont pouvoir communiquer ou qu'ils vont pouvoir manger et le chien quant à lui ne pourra pas manger, ne pourra pas communiquer.

Vous voyez il va manquer quelque chose, il va manquer un comportement et c'est quand même assez dommage puisqu'à la base il était censé pouvoir manger communiquer puisque c'est dans la classe abstraite.

Donc là l'avantage d'une classe abstraite, pour le coup c'est à ça que ça sert, c'est que si on veut créer quelque chose de concret automatiquement à la compilation il y aura des erreurs si vous oubliez, si vous ne pensez pas implémenter les méthodes abstraites.

Cela force en fait le développeur ou l'utilisateur de votre code et vous-même, ça peut être vous-même aussi bien sûr en plus monter dans la classe concrète ce qui était abstrait dans la classe parente voilà. il n'y a pas d'oubli comme ça de ce côté et ça va bien sûr avoir plein d'avantages concernant le polymorphisme comment on le verra pendant la prochaine séance mais celle d'après.

Grosso modo pour les classes abstraites, je pense que je vous expliqué pas mal de choses par rapport à ça. je regarde sur la note.

Donc les méthodes abstraites, je vous en ai parlé. L'instanciation on en a parlé. Pour les interfaces on verra plus tard. Ce n'est pas le problème par rapport à ça. Donc du coup on a fait tours et c'est tant mieux.

Comme je ne peux pas encore vous donner trop d'éléments tout de suite par rapport à ça parce qu'on n'a pas encore parlé des interfaces, on n'a même pas encore abordé le polymorphisme, tout ça.

mais en gros c'est l'ultime dans le sens, on peut factoriser du code et ça c'est un élément très important c'est-à-dire que si vous demandez et ben dans quel cas, il faut utiliser une classe abstraite Eh bien dans le cas où vous avez différentes classes qui peuvent avoir des liens c'est-à-dire que si je crée un tigre, si je crée un chien, Si je crée un dauphin … On est d'accord que c'est des classes qui sont liées entre elles, elles ont des choses communes c'est classe-la.

On peut dire qu'un dauphin il mange, un tigre il mange, un chien il mange et cetera. On trouve déjà des comportements communs éventuellement des propriétés des états communs aussi, il peut avoir un nom et cetera.

on peut imaginer qu'ils ont un nom, on peut imaginer qu'il y a un âge, on peut imaginer qu'ils aient un plat préféré, régime alimentaire spécifique. Voilà on retrouve plein d'éléments communs, c'est pas comme si on avait une voiture et un tigre. Là c'est bizarre de se dire, on va faire une classe abstraite d'accord.

Et de cette classe abstraite, on va être dans 2 classes concrètes en disant qu'on va créer des tigres à partir d'espèces vivantes et des voitures.

Là pour le coup on se rend compte qu'il n'y a pas vraiment de liens Et du coup ça ne va pas. Donc si vous trouvez qu'il y a des classes comme ça avec des liens, avec des choses communes et que vous pourriez du coup avoir de la répétition de code. 

En gros je n'ai pas forcément envie, admettons, on va le faire avec la classe Lion :


Lion.java
----------

package jachampagne;
	
public class Lion extends LivingSpecies
{
	public Lion()
	{
		mName = "Lion";
	}

	public void eat()
    {
    	System.out.println("Je mange de la viande…");
    }
    
    public void speak()
    {
    	System.out.println("Je rugis…");
    }
}

Donc là c'est un cas un peu particulier mais en gros, ce que l'on peut faire et là il a fallu que je fasse une classe, par exemple notre classe abstraite. En gros il aurait fallu que je fasse une autre classe abstraite Feline ou un truc comme ça.

On va virer LivingSpecies.java, et le remplaçait par Feline, qui est avec E justement à la fin. On aurait pu aussi le mettre en français mais bon Comme j'ai l'habitude d'écrire le code en anglais, le texte en français mais le code en anglais, on va garder ça comme ça et donc le nom est OK et on ne va pas garder le même comportement mais on va dire qu'on va virer la méthode whoAmI()

LivingSpecies devient Feline.java
---------------------------------

package jachampagne;

abstract public class Feline
{
	protected String mName;

    	abstract public void eat();
    	abstract public void speak()
	{
       	System.out.println("Roaaarr !!");
       }
}

Et on va du coup implémenté la méthode speak() et du coup il fait "Roaaarr !!", juste faire un bruit comme ça par rapport à l'animal. 

En gros on part du principe que tout nos Félins un comportement commun, C'est-à-dire que pour communiquer Eh bien ils rougissent, ils crient, il pousse un grognement, un truc comme ça, peu importe et on le représente comme ça via du texte "Roaaarr !!".

Il va donc y avoir des changements à faire par rapport au félin pour le coup, il va y avoir des petits changements.

Qu'est-ce qui pourrait être différent pour le lion ? Parce qu'ils sont très liés le lion et le tigre, ce n'est peut-être pas les meilleurs exemples mais ce n'est pas bien grave. On peut prendre néanmoins sleep() à la place de eat().

On va dire qu'un lion ça dort beaucoup, on va dire "je dors 16h par jour …" Et on va partir sur le fait que le tigre dort un peu moins qu'un Lion, on va partir là-dessus :

Lion.java
---------

package jachampagne;
	
public class Lion extends Feline
{
	public Lion()
	{
		mName = "Lion";
	}
	abstract public void sleep()
	{
		System.out.println("Je dors 16h par jour…");
	}
    	abstract public void speak()
	{
       System.out.println("Je rugis…");
       }
}

Tiger.java
----------

package jachampagne;
	
public class Tiger extends Feline
{
	public Tiger()
	{
		mName = "Tigre";
	}

	public void sleep()
    {
    	System.out.println("Je dors moins qu'un Lion");
    }
    
    public void speak()
    {
    	System.out.println("Je rugis…");
    }
}

En résumé de ce que j'ai fait, j'ai fait une classe féline pour les félins, abstraite, et je dis que j'ai 2 classes concrètes Lions.java et Tiger.java. Donc une qui représente un lion et une autre qui représente un tigre pour résumer un petit peu les petits changements qu'on vient de faire dans la vidéo. 

Donc ils dorment chacun différemment, c'est pour ça qu'ici, j'ai vraiment une méthode abstraite sleep() par rapport à speak(). Alors pour le coup speak() dans Feline.java n'est pas abstraite :

Feline.java
-----------

package jachampagne;

abstract public class Feline
{
	protected String mName;

	//public String whoAmI()
	//{
	//	return mName;
    //}
    //abstract public void eat();
	
	abstract public void sleep();
	
    public void speak()
	{
		System.out.println("Roaaarr !!");
	}
}

Donc la méthode speak n'est pas abstraite pour le coup donc on fait comme ci-dessus et pour dire simplement, je considère simplement que tous les félins dormiront absolument différemment donc il faut absolument implémenter ça pour chacun. Bah du coup le lion, concrètement il dort d'une manière bien précise, le tigre il dort aussi à sa manière mais de manière précise également.

Donc une implémentation différente par classe concrète par contre pour moi dans ce cas-ci en tout cas, le lion et le tigre, bien ils rugissent en fait c'est-à-dire que quand je l'ai fait parler, ils rugissent.

Du coup si je voulais produire ça, vous voyez que j'ai une répétition de code entre les 2 classes concrètes et on sait pour la répétition de code en informatique, faut absolument éviter donc c'est un argument suffisant, c'est une raison un motif suffisant pour dire que ce que j'ai mis là :

	public void speak()
	{
       System.out.println("Je rugis…");
    }

Pour dire que ce que j'ai mis là, je le factorise c'est-à-dire que au lieu de le répéter à x endroit parce que là dites-vous que je n'ai qu'un lion et un tigre mais rien n'empêche demain de faire une panthère, un puma, un léopard, un Jaguar, un guépard si je veux tous les faire rugir on va avoir je ne sais combien de méthodes répétés.

Feline.java
-----------

package jachampagne;

abstract public class Feline
{
	protected String mName;

	//public String whoAmI()
	//{
	//	return mName;
    //}
    //abstract public void eat();
	
	abstract public void sleep();
	
    //public void speak()
	//{
	//	System.out.println("Roaaarr !!");
	//}
	
	public void speak()
	{
       System.out.println("Je rugis…");
    }
}

Tiger.java
----------

package jachampagne;
	
public class Tiger extends Feline
{
	public Tiger()
	{
		mName = "Tigre";
	}

	public void sleep()
    {
    	System.out.println("Je dors moins qu'un Lion");
    }
    
    //public void speak()
    //{
    //	System.out.println("Je rugis…");
    //}
}

Lion.java
---------

package jachampagne;
	
public class Lion extends Feline
{
	public Lion()
	{
		mName = "Lion";
	}

	public void sleep()
    {
    	System.out.println("Je dors 16h par jour…");
    }
    
    //public void speak()
    //{
    //	System.out.println("Je rugis…");
    //}
}


Et là il n'y a qu'une ligne dans notre méthode mais imaginer des méthodes beaucoup plus longues, la répétition n'est juste pas possible donc on dit simplement que voilà que tous mes félins rugissent comme ça.

Et si mon félin doit effectivement rugir comme je l'ai marqué dans Felin.java, on laisse tel quel, parce que c'est implémenté dans la classe abstraite "abstract public class Feline" donc pas de problème.

On va d'ailleurs faire un Tiger ti et un Lion li.
*/
import jachampagne.*;

public class App
{
	public static void main(String[] args)
	{
		//LivingSpecies ls = new LivingSpecies();
		Tiger ti = new Tiger();
		ti.speak();
		//ti.whoAmI();
		//System.out.println(ti.whoAmI());
		Lion li = new Lion();
		li.speak();
	}
}
/*
Donc voilà, un Tiger ici, on va dire que ti va speak(), je met ti encore une fois comme terme enfin peu importe.
Ensuite Lion li qui va speak aussi.
Je fait ça pour histoire que vous aillez un peu de visuel en terme de code.
	>javac App.java
	>java App
		Je rugis...
		Je rugis...
On voit que les deux rugissent Il a du coup on ne pourrait même pas savoir qui est le lion et qui a le tigre juste en regardant le terminal. Ils se comportent de la même manière pour communiquer, pas de problème. 
Pas de répétition de code, l'abstraction ici, la fameuse classe abstraite que je viens de faire (abstract public void class Feline) m'a permis de factoriser du code pour ne pas à avoir à le répéter dans les différentes classes concrètes.

Et si un moment donné, je veux créer un puma Qui serait une autre classe concrète mais qu'exceptionnellement celle-là je ne veux pas qu'elle communique pareil, et bien dans la classe de Puma, je réécrirai "public void speak()" comme je l'ai mis là et je mettrais autre chose dans l'implémentation Et ça fera une redéfinition de la méthode Même une surcharge pour le coup pour dire : "… que non puisque tu es un Puma, tu ne vas pas rugir, tu ne vas pas speak, communiquer comme un Felin de manière abstraite, de manière générale, mais comme toi tu sais faire comme toi t'es un peu particulier, le Puma, donc tu vas rugir autrement, tu vas tu vas communiquer autrement.".

Donc voilà le principe et dans quel cas on utilise une classe abstraite. Une classe abstraite est fait à la base pour factoriser du code par rapport à des classes concrètes qui sont étroitement liés. C'est des termes souvent qu'on emploie dans le sens où elles ont des liens ensemble, elles peuvent avoir des choses communes.

Et ça c'est, il suffit de vous poser la question. Encore une fois c'est dans un jeu vidéo, vous créez un guerrier, un mage, vous créez un voleur ou n'importe quoi. On trouve naturellement, juste en se posant la bonne question Tout un tas de choses qui sont communes à ces entités là pour le coup. 

Donc naturellement, tout de suite on comprend qu'on peut faire une classe abstraite qui représenterait par exemple un combattant, un personnage de jeu ou n'importe quoi qui aurait tous les éléments communs à cela et si les gens doivent faire certains trucs spécifiques comme par exemple leur manière de se battre, de se défendre, de se soigner, Eh bien on a fait des classes abstraites et chaque classe concrète devrait implémenter à sa manière son propre comportement et voilà un petit peu l'intérêt.

il y a plein d'autres intérêts, d'autres utilité de la classe abstraite mais ça on le verra encore une fois lorsqu'on abordera le polymorphisme, cela qu'on terminera sur un dernier point essentiel de ça, et de l'utilité de se servir des classes abstraites.

s'il n'y avait pas besoin de classe abstraite, des interfaces, Eh bien on ne serait jamais embêté à inventer ce genre de chose en programmation objet.

Donc il y a vraiment des avantages à tout ça, dites-vous qu'il y a vraiment des avantages à ça il vous le verrez par la suite en tout cas. 
Voilà nous avons fait le tour, je vous ai tout dit.
Si vous trouvez que je n'ai pas assez détaillé, il vous manque des éléments pour bien comprendre ce concept de classe abstraite, n'hésitez pas à le faire savoir dans les commentaires. Il ne faut surtout pas hésiter à poser des questions si ce n'est pas assez explicite pour vous.
Voilà on ne peut pas faire une explication parfaite et ce n'est pas évident à expliquer.
Parce que moi dans ma tête je sais très bien ce que c'est qu'une classe abstraite. Je connais bien les concepts, il n'y a pas de problème, je sais les employer mais après pour l'expliquer avec des mots simples et que ça rentre dans la tête de tout le monde, ce n'est pas forcément aussi facile pour le coup.
Ça peut être des fois trop abstrait au niveau des explications donc s'il y a besoin d'être un peu plus explicite, un peu plus grand concret dans mes explications n'hésitez pas à le mentionner dans les commentaires.
Partagez likez la vidéo.
Dans la prochaine séance nous parlerons des interfaces. C'est une notion très importante comme la classe abstraite mais c'est autre chose et souvent les gens ont tendance à mélanger un petit peu les 2 donc là je vous réserve du coup la prochaine séance pour parler des interfaces et je vous dis à bientôt pour la prochaine vidéo en Java.

*/
