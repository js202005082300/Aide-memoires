# [17. Exceptions](https://www.youtube.com/watch?v=UEISfoJaOyk)

Bonjour sur ce cours Java. Nous arrivons avec la séance 17 pour parler des exceptions Pour faire suite directement avec ce qu'on avait terminé dans la séance précédente, avec la lecture de données au clavier.
Les exceptions, c'est tout simplement une manière dans quelque langage à paradigme objet, à technologie orientée objet, à programmation orientée objet pour pouvoir gérer des erreurs qui pourrait arriver, qui pourrait être levé au cours de l'exécution d'un programme et pouvoir les gérer, les traiter. On va regarder comment on peut faire ça en Java.
Vous verrez que c'est très très simple, c'est aussi très important de prendre en compte tout ça lors de développement de nos applications, de nos programmes, de bien gérer les exceptions qui peuvent survenir au cours de l'exécution. 

## Rappel de Scanner

Pour cela on va reprendre un code assez similaire à ce qu'on a vu précédemment pour l'utilisation de scanner. On demande une date de naissance, qui est une information du coup bien précises et on veut la stocker dans une variable de type entier (integer). 

Du coup on fera appel à la méthode nextIn() et à partir de là on affichera tout simplement cette date de naissance.

```java
import java.util.Scanner;

public class App
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Annee de naisance : ");
		int yearOfBirth = sc.nextInt();
		System.out.println(yearOfBirth);
	}
}
```

Jusqu'à présent ce qu'on avait vu et notamment dans la séance précédente qu'il y avait un risque que cette donnée ne soit pas bonne. C'est d'ailleurs pour ça que scanner est un peu plus longue parce que c'est une méthode qui va lire une donnée et qui va ensuite effectuer des conversions via des contrôles, des vérifications et cetera pour le type de données que nous voulons parser, que nous voulons récupérer.

Tant que je rentre en tout cas une donnée qui va bien, il n'y a pas de problàme, la donnée sera évidemment lu, stocké et on pourra l'afficher :
```txt
       Annee de naisance : 1994
       1994
```
Et à partir du moment où on rentre autre chose qu'un entier, on aura une exception qui sera lever :
```powershell
	Annee de naisance : jason
       Exception in thread "main" java.util.InputMismatchException
```
Notamment une exception ici : `InputMismatchException` qui appartient au paquet `java.util`

Attention il faudra penser lorsque vous travaillez avec certaines choses de ne pas oublier d'importer les bons package si vous voulez.

A partir de là, en tant qu'utilisateur, si on a ce genre de résultats à l'exécution, à l'utilisation d'un programme que ce soit un jeu ou une application Pour un site ou pour n'importe quoi, ce n'est évidemment pas logique et pas du tout cohérent et acceptable. On ne peut pas laisser ce genre de choses-là à l'utilisateur, c'est aux développeurs de gérer ces exceptions c'est-à-dire que si on risque une exception soit lever dans un programme, il faut absolument la gérer. 
Quand on n'a vraiment pas besoin de gérer une exception et qu'on a une bonne raison de le faire, simplement laisser des exceptions se lever sans être traiter plutôt que de laisser par défaut.

Et généralement, le compilateur, on avait vu dans la vidéo précédente pourra nous indiquer qu'une exception pourra être lever, qu'elle n'est ni capturé, on verra en quoi ça consiste après, où alors que vous n'indiquez pas simplement qu'une partie de notre code peut lever une exception.

C'est pour ça qu'on s'était amusé à faire : throws Exception et on avait dit du coup que ça ferait un peu la transition avec ce que nous allons voir prochainement. C'est un petit peu le sujet ici.

throws Exception est un petit peu la méthode de secours et pas forcément la meilleure, de dire que voilà cette méthode main ici, il est possible qu'à un endroit au cours de l'exécution, làve une exception, elle 'throws' une 'Exception', mais ça ça ne nous intéresse pas. On veut pouvoir gérer justement ces exceptions qui risque d'être potentiellement levé.

## Le bloc try catch

Et pour se faire nous allons découvrir un nouveau bloc très simple d'instruction, qui est le bloc try catch qui va permettre de gérer un certain nombre d'opérations et au cours de cette différentes opérations si une exception est lever, généralement on le fait quand on sait qu'il y a un risque que ça arrive.

Si vous savez qu'il y a une partie de votre code et vous savez qu'il n'y a aucun risque qu'une exception soit lever, ça ne sert à rien de mettre un bloc try catch.

Et dans ce cas-là, on va laisser certaines opérations, si une exception est levée, on traitera l'exception qui a été levée. Et si il n'y en a pas l'exception continuera.
ça fait un peu penser au bloc if else, ou par exemple, on a une condition, une expression qui est vérifiée, si elle est valide ça va et si elle ne l'est pas, on va passer dans le bloc, dans la partie du else et ça rejoint un petit peu ce genre de choses-là.

Ici la partie un petit peu sensible, la partie qui nous intéresse ou en tout cas qu'on veut contrôler c'est : 
```powershell
	System.out.print("Annee de naisance : ");
	int yearOfBirth = sc.nextInt();
	System.out.println(yearOfBirth);
```
C'est-à-dire qu'on va demander une info, attendre sa saisie et l'afficher. C'est-à-dire qu'elles sont un petit peu dépendant. ça sert à rien d'afficher un texte qui demande l'année de naissance si vous ne demandez rien derrière Comme en même temps on ne peut pas simplement derrière demander une saisie si la personne ne sait pas ce qu'il doit saisir et en même temps on ne pourra jamais afficher une date de naissance si elle n'a pas été saisie et afficher une date de naissance qui ne serait pas correct. Vous voyez donc que ces 3 instructions, ces lignes de code, sont assez dépendantes les unes des autres, son cohérentes entre elles donc elles font partie d'un bloc homogène, elles vont ensemble et c'est cette partie-là qui est sensible de notre code.

c'est cette méthode nextInt() qui dans certains cas, pas tout le temps merci on fait pas que ce soit volontaire où involontaire, la saisie d'une donnée qui est correcte, qui est valide, une exception sera toujours lever et notamment InputMismatchException.

Dans ce cas, nous allons mettre cette partie-là dans un bloc try catch :
```java
import java.util.Scanner;

public class App
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
       try
       {
			System.out.print("Annee de naisance : ");
			int yearOfBirth = sc.nextInt();
			System.out.println(yearOfBirth);
       }
       catch()
	}
}
```
Voilà comment ça se fait, tout simplement comme pour les if else ou les boucles, on utilise des accolades avec notre try. ça ce sera la partie qu'on va essayer, try pour essayer, c'est-à-dire la partie des opérations que nous allons tenter d'effectuer au niveau du programme. 

Et ensuite un bloc minimum, il nous en faut au moins un, un premier catch avec le titre d'exception qui peut arriver.

Comment fait-on Lorsqu'on utilise tout un tas de méthodes qu'on ne connaît forcément pas coeur mais qu'on est en train de les découvrir, comment on fait Pour savoir dans les méthodes qu'on utilise, déjà est-ce qu'il y a des méthodes qui peuvent être levées et si oui lequel, comment elles s'appellent ? Par exemple, InputMismatchException, ça n'a aucun intérêt de l'apprendre par coeur et en plus il existe tellement de type d'exception différents pour chaque classe, chaque méthode et cetera, que ça n'aurait aucun intérêt, une perte de temps et ça finirait de toute façon à devenir impossible de tout connaêtre et de se souvenir de tout ça c'est pour ça qu'il faut absolument encore une fois prendre l'habitude de nous réfèrer à la documentation, la javadoc. 

Par exemple si on veut des informations sur InputMismatchException, on le fait suivre de javadoc dans notre moteur de recherche et on retombera sur la documentation Officiel qui nous donnera toute l'information dessus.

ou bien alors vous Notez tout simplement un nom de méthode comme nextInt() Et sur la documentation en Java, vous indiquera clairement quel type d'exception exact, avec les noms exacts, peut lever, peut générer l'usage de ce genre de méthode, tout simplement. 

A partir de là, vous pouvez déjà traiter dans votre code les choses comme il faut. 

A l'exécution, on a `java.util.InputMismatchException` donc du coup on va l'ajouter.
```java
	import java.util.Scanner;
	import java.util.InputMismatchException;
```
La du coup exceptionnellement comme on est sur le même package, on peut encore une fois raccourcir tout ça en mettant une étoile. Donc on l'a écrit manuellement pour que ce soit lisible au niveau de la vidéo.
```java
	import java.util.*;
```
Mais ici on rajoute une étoile pour pas s'amuser à rajouter tout à chaque fois surtout s'il y avait d'autres types d'exceptions à ajouter, on va éviter de le faire parce que là on va commencer à avoir beaucoup de imports. Donc on peut s'amuser à importer de cette manière-là.

A partir de cette partie, on peut du coup dire je prévois de capturer au niveau de mon code, ce type d'exception: 
```java
	catch(InputMismatchException)
```
On va le englober dans une variable et par convention on l'appelle généralement `e`. On l'appelle comme on veut, on met absolument le nom que l'on veut. 
```java
	catch(InputMismatchException e)
```
C'est juste un nom de variable, on est libre de choisir, et nous avons du coup ce nouveau bloc de code.

encore une fois on retrouve un petit peu ce genre de comportement qu'on avait avec un bloc if else qu'on a déjà vu avant. 

en gros on fait : 
```java
	System.out.print("Annee de naisance : ");
	int yearOfBirth = sc.nextInt();
	System.out.println(yearOfBirth);
```
Et si tout se passe bien, toute la partie du catch ou des catch parce vous verrez qu'on peut en avoir plusieurs, sera parfaitement ignoré. On passera à la suite du code par contre si un certain type d'exception est élevé, le compilateur, durant l'exécution c'est-à-dire la machine virtuelle plus exactement de Java verra quel type a été levée Il va ensuite sauter directement au cash qui correspond avec le type d'exception.

Donc dans notre cas-ci il y a un InputMismatchException Qui a été lever, il va trouver un catch qui possède justement ce type là donc il va entrer dans ce bloc de code et effectuer certaines choses.

Donc le minimum à faire si on ne veut pas vraiment trop s'arrêter, c'est de préciser quelque chose pour l'utilisateur qui soit cohérent par rapport à ce qui est arrivé. En gros ici, à la date de naissance est invalide ou incorrecte.
```java
import java.util.*;

public class App
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Annee de naisance : ");
			int yearOfBirth = sc.nextInt();
			System.out.println(yearOfBirth);
		}
		catch(InputMismatchException e)
		{
			System.out.println("La date de naissance est incorrecte.");
		}
	}
}
```
Donc vous voyez ici qu'il y a une variable pour l'exception, on ne s'en sert pas mais on va revenir dessus. là on ne s'en sert pas mais il faut quand même englober l'exception dans une variable `e`.

Donc on fait ça et maintenant on passe à nouveau à l'exécution Qui est un peu plus correct.

Encore une fois si on saisit une date de naissance valide il n'y aura pas de problàme :
```powershell
	Annee de naisance : 1991
	1991
```
Si par contre je saisi autre chose qu'une donnée qui puisse être converti en entier. Cette fois-ci on n'aura plus tous ces messages bizarres et on a quelque chose de bien plus cohérent et compréhensible pour l'utilisateur, "La date de naissance est incorrecte".
```powershell
	Annee de naisance : jason
	La date de naissance est incorrecte.
```
Le programme est bien évidemment arrété parce qu'on n'a rien d'autre après, je n'ai pas autre chose de fait de toute façon Et nous avons cette partie là. 

Voilà comment ça fonctionne.

on peut également avoir plusieurs types d'exceptions, on pourrait avoir plus 5 - 6 lignes de code Dans le bloc try les 2 lignes qui pourraient lever chacune 2 exceptions différentes mais comment on fait pour traité ce cas ? Eh bien il suffit de cumuler les catch.

### Cumuler les catch

Par exemple on peut mettre un autre nom, `RuntimeException`, Mais ça on l'utilisera pas. c'est une partie assez générale du coup c'est pas forcément une bonne idée. Bref mettons un nom qui n'existe pas pourquoi nous embrouiller. En gros on aura un autre type d'exception `OtherExeption` et qui serra traiter dans ce nouveau bloc.
```java
import java.util.*;

public class App
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Annee de naisance : ");
			int yearOfBirth = sc.nextInt();
			System.out.println(yearOfBirth);
		}
		catch(InputMismatchException e)
		{
			System.out.println("La date de naissance est incorrecte.");
		}
		catch(OtherExeption e)
		{
			
		}
	}
}
```
Donc qu'est-ce qui va se passer ? Certaines lignes de code vont être faites, certaines opérations, et il y a un moment donné un risque InputMismatchException qu'il soit levé et dans ce cas-là on va faire ce qu'il y a dans le catch :
```java
	catch(InputMismatchException e)
    {
		System.out.println("La date de naissance est incorrecte.");
	}
```
Si ça n'arrive pas, tant mieux et en admettant une autre ligne, une autre opération qui va lever OtherExeption, mais de toute façon c'est un mot qui n'existe pas on vient de l'inventer, et dans ce cas-là on rentrera dans ce bloc catch 
```java
	catch(OtherExeption e)
	{
		
	}
```
C'est-à-dire qu'on ne va pas tous les faire, c'est en fonction du type d'exception qui aura été lever et donc on les traite comme ça. On met les plus potentiels en premier et on met les autres après, sur la fin .
```java
	catch(Exception e)
	{
		
	}
```
Généralement si vous avez un type d'exception bien spécifique, on le met d'abord et on termine avec la classe exception Quel temps fait une classe générale mais on en parlera dans une prochaine vidéo quand on abordera notamment l'héritage et on verra notamment qu'il y a des familles de classes en programmation objet c'est-à-dire que vous avez des classes qui peuvent permettre de créer d'autres classes qui sont un peu plus spécialisés et qui possède tout ce que les autres ont. 

Donc par exemple ici "InputMismatchException", est une sorte d'exception comme "Exception". C'est un peu imaginer un enfant, un type d'exception qui est enfant de cette classe qui est très générale, qui est un peu abstraite un peu vague. Une exception ça veut tout dire et rien dire, c'est trop vague pour savoir quel type précis mais ça existe aussi.
les types plus précis d'abord et on termine ensuite par quelque chose de général, en gros.

Quand vous mettez " Exception ", c'est un type qui existe pour le coup en Java. ça veut dire tout ce qui est un type d'exception Que tu n'as pas encore indiqué avant dans un catch en particulier donc on ne rentrera jamais dans ce bloc :
```java
	catch(Exception e)
	{
		
	}
```
Si on a une InputMismatchException puisqu'on l'a marqué au-dessus, par contre si c'est une arithmétique donc si c'est une IO exception, si c'est une `NullPointerException`, ou n'importe quoi d'autre, ça rentrera dans `catch(Exception e){}` Puisque ça ne concerne pas le `InputMismatchException`. Je ne sais pas si vous comprenez un petit peu ce que je veux dire mais voilà en gros comment on traite les choses.

Donc ça c'était Donc ça c'est un cas et ça ne sert à rien de vous donner un exemple qui peut avoir plusieurs levés d'exception mais en gros voilà comment on peut les accumuler.

Et maintenant, on peut aussi songeré c'est lequel lorsqu'on veut écrire un fichier, on veut tenter d'ouvrir un fichier ou alors on a un fichier déjà ouvert, on travaille dessus et quand on a par exemple une erreur, une exception survient, on n'a pas envie de quitter le programme sans fermer le fichier donc il faudra dire que si il y a une exception qui est levé, il y a quand même des choses, des opérations qu'on veut faire malgré l'exception qui a pu être levé et du coup capturé. 

Et pour sa, on aura un autre type de bloc qui s'appelle finally :
```java
	finally
	{
		
	}
```
Bloc qui veut dire que peu importe qu'il y ait une exception ou pas de lever bref dans tous les cas quoi qu'il arrive, quel que soit le scénario au moment de l'exécution du programme, on fera ce qu'il y a dans le bloc finally{}.

On va juste faire un affichage pour voir que c'est le cas :

```java
import java.util.*;

public class App
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Annee de naisance : ");
			int yearOfBirth = sc.nextInt();
			System.out.println(yearOfBirth);
		}
		catch(InputMismatchException e)
		{
			System.out.println("La date de naissance est incorrecte.");
		}
		finally
		{
			System.out.println("ok");
		}
	}
}
```
Vous verrez que peut importe exception ou pas, le mot ok serra affiché.
Si jamais une donnée valide, le ok bien afficher.
```powershell
	Annee de naisance : 1991
	1991
	ok
```
Si je mets une donnée non valide qui va lever une exception InputMismatchException, on voit que le ok est quand même affiché. Voilà comment ça fonctionne. 
```powershell
	Annee de naisance : ezefzf
	La date de naissance est incorrecte.
	ok
```
Donc si vous avez absolument besoin de faire quelque chose peu importe ce qu'il se passe avant, vous utilisez un bloc finally. C'est logique il n'y a qu'un seul bloc finally dans toute une structure comme : 
```java
	try
	{
		System.out.print("Annee de naisance : ");
		int yearOfBirth = sc.nextInt();
		System.out.println(yearOfBirth);
	}
	catch(InputMismatchException e)
	{
		System.out.println("La date de naissance est incorrecte.");
	}
	catch(IOException e)
	{
		
	}
	catch(Exception e)
	{
		
	}
	finally
	{
		System.out.println("ok");
	}
```
On a un seul try, on peut avoir plusieurs catch avec différents types d'exceptions à la suite. Voilà c'est tout à fait un format possible pour traiter des exceptions c'est-à-dire qu'on a un cas bien précis InputMismatchException, autre cas IOException bien précis et si on a ni l'un ni l'autre, C'est-à-dire un autre mais qu'on ne veut pas forcément encadrer où traiter Un type bien spécifique d'exception, on dit alors que tous les autres types on les traitera dans Exception De la même manière, tout le monde sera logé à la même enseigne et dans tous les cas qu'on soit passé par les catch ou non, on fera ce qu'il y a dans le bloc finally. Voilà comment il faut comprendre cela, c'est très simple c'est juste qu'il y a de la syntaxe à connaêtre, que vous apprenez en plus mais il n'y a vraiment rien de compliqué à l'utilisation des exceptions mais il faut absolument le faire parce que sans ça on peut avoir du coup des erreurs qui arrivent sur notre programme et si elles ne sont pas traitées Ben tant pis. Le programme s'arrêtera et on pourra plus rien y faire ce qui est un peu dommage pour l'utilisateur quand même donc on gérera tout ça.
voilà pour cette partie.

## printStackTrace() et getMessage()

Alors comment fonctionnent ces exceptions ? parce qu'on avait dit qu'il n'y a juste syntaxe à connaêtre, le try catch, finally et cetera. Le fait de savoir ici qu'il y a une petite variable `e` et cette variable justement permet via son type InputMismatchException par exemple d'utiliser quelque méthode particulière que je vais vous en donner 2 qui sont les plus utilisés, et il en existe quelques autres mais celles-là sont vraiment les plus importantes.

Rappelez-vous tout à l'heure lorsqu'on n'avait pas l'exception, on avait tout un tas de ligne qui était affiché, c'est ce qu'on appelle en fait une pile, une pile signifie qu'on a plusieurs informations empiler qui a dit qu'un petit peu toutes les erreurs qui ont pu arriver c'est-à-dire par exemple qu'on a eu un petit problàme qui a pu en entraîner un autre qui en a entraîné un autre qui en a entraîné un autre. 

Donc chaque partie s'enchaîne et ça forme comme ça une pile d'erreur dans laquelle on peut remonter, on peut retrouver l'origine du problàme et ça lorsqu'on traite l'exception On a plus cette pile qui est affichée.
Mais si vous avez absolument besoin malgré tout de l'afficher Eh bien on peut le faire. 

### printStackTrace()

Pour revenir encore sur ce qu'on avait tout à l'heure on va utiliser la variable `e` et appelez la méthode printStackTrace() avec une majuscule encore une fois à chaque nouveau mot du nom de la méthode et ça elle affiche directement le résultat.
```java
import java.util.*;

public class App
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Annee de naisance : ");
			int yearOfBirth = sc.nextInt();
			System.out.println(yearOfBirth);
		}
		catch(InputMismatchException e)
		{
			e.printStackTrace();
		}
	}
}
```
On fait javac App.java et java App et on met une donnée qui ne va pas :
```powershell
Annee de naisance : zzef
java.util.InputMismatchException
        at java.base/java.util.Scanner.throwFor(Scanner.java:939)
        at java.base/java.util.Scanner.next(Scanner.java:1594)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        at App.main(App.java:354)
```
Et voilà on retrouve exactement l'affichage de tout à l'heure, ça c'est la fameuse pile qui nous dit que par exemple ici tout en bas de la pile :
```powershell
	at App.main(App.java:354)
```
Dans le fichier `App.java`, ligne 354, Il y a eu un problàme qui du coup faisait référence, s'était enchaîné à `java.util.Scanner.nextInt`.

ça semble plutôt cohérent car le nextInt est en fait un next.

java.util.Scanner.next est une partie globale c'est-à-dire qu'on attend une donnée et après on a un parse en Int `nextInt`. On retrouve un petit peu le fonctionnement de scanner, on comprend qu'il y a une lecture et ensuite un parse `at java.base/java.util.Scanner.nextInt(Scanner.java:2258)`.

Et là on prend un petit peu les informations à l'envers, le parse en Int `nextInt` et avant tout une lecture next. Et ensuite, on a une histoire throwFor, où throw qui fait penser à lever de throwException, ce qu'on avait avant qui va du coup entraîner à c'est-à-dire que la lecture ici, le parse n'as pas marché. Comme le parse n'a pas marché et ben ça a été du coup, remonté à la lecture, qui a été remonté du coup au gestionnaire des exceptions qui a justement levé une exception InputMismatchException.

On a donc une pile comme ça qui permet d'avoir l'historique de tous les problàmes qu'il y a eu depuis le départ et c'est une ligne de code qui entraînait tous ses soucis. C'est pour ça que c'est important de traiter ses exceptions.

### getMessage()

Dans certains cas, vous pouvez avoir une exception qui génère un message, ça peut arriver même si ici ce n'est pas forcément le cas, ici on aurait un message null.

Mais quand on a un message qui peut être génèré on peut le récupérer avec la méthode getMessage().
```java
	e.getMessage();
```
Et ça par contre comme ça retourne une chaîne de caractères, il faut afficher le retour de cette méthode, le faire dans un petit println :
```java
	System.out.println(e.getMessage());
```
Ce n'est pas forcément utile, mais on peut bien sûr concaténer ou utiliser un Stringbuilder où StringBuffer, ce que l'on veut pour concaténer notre message avec le message qui a été retourné :
```java
	System.out.println("ERREUR : " + e.getMessage());
```
```java
import java.util.*;

public class App
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Annee de naisance : ");
			int yearOfBirth = sc.nextInt();
			System.out.println(yearOfBirth);
		}
		catch(InputMismatchException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
```

Donc 2 méthodes, getMessage() et printStackTrace(), Qui permet soit de récupérer le message lié à l'exception Ou alors récupérer toute la pile des soucis qui ont pu arrivé par rapport à cette exception Et qui permettent souvent d'arriver à la source du problàme, retrouver un petit peu la ligne de code concernée et de faire ainsi un peu de débogage .

voilà pour sa, je pense que tout est dit ici et on va terminer avec une information un peu importante qui va pour le coup faire la transition avec la séance suivante c'est-à-dire la hiéarchie d'exceptions. Comme je vous ai parlà de InputMismatchException, je vous ai dit qu'il y avait la classe Exception qui est beaucoup plus général et vous ne savez pas ce que c'est encore l'héritage, on n'a pas encore par là de toute cette notion. On en parlera dans la prochaine séance et on verra un petit peu comment ça s'organise en gros. 

Je vous ai fait un petit schéma.
```txt
				Throwable
					|
	Error ----------+---------- Exception
	AssentionError				DataFormatException
	IOError						IllegalClassFormatException
	ThreadDeath					IOException
	VirtualMachineError			NotBoundException
	...							
								...
	
			RuntimeException
					|
				ArithmeticException
				BufferOverflowException
				IndexOutOfBoundsException
				NullPointerException
				...
```

On a une classe générale qui s'appelle Throwable qui est une classe un peu vague c'est-à-dire que si on prend juste le terme de cette classe, elle ne veut pas dire grand chose. C'est trop vague, trop imprécis pour comprendre en quoi elle consiste.

Du coup vous verrez dans la prochaine séance, on va aborder l'héritage qui permet de faire une hiéarchie, une famille de classe et qui les relie entre elles. 
ça, ce schéma, c'est un moyen de schématiser l'héritage en programmation Objet.

on a plus bas une classe Error et Exception, On retrouve cette fameuse classe général dont je vous ai parlà qui héritent de Throwable.

Ca veut dire que Exception est une sorte de Throwable, une classe Throwable donc elle possède tout ce que à cette classe Throwable, avec des choses en plus.
elle est déjà un petit peu plus précise que Throwable mais pas suffisamment pour autant donc on a aussi de cette classe Exception, très général donc je ne vais pas parler des erreurs ça ne nous intéresse pas ici.

on a plein de classe Exception, un peu plus spécialisé, un peu plus précise encore donc on voit qu'on a par exemple pour les entrées et les sorties IOException, on en a pour l'environnement d'exécution RuntimeException, on en a pour le format de données DataFormatException et cetera et cetera.

si je prends l'exemple de RuntimeException, c'est une classe aussi de Java Eh bien on voit que elle aussi comme elle est un peu vague, elle a également des classes qui héritent, qui sont plus spécialisés et notamment ces dernières: 
```txt
			RuntimeException
					|
				ArithmeticException
				BufferOverflowException
				IndexOutOfBoundsException
				NullPointerException
				...
```
je vous en ai mis plein ArithmeticException, BufferOverflowException et cetera et cetera.

plus on descend dans l'arbre, dans la hiéarchie et plus les choses se précisent, se spécialisent et plus on monte vers le haut et plus on a des choses beaucoup plus vague, beaucoup moins explicite on va dire. C'est vague, c'est abstrait, on ne sait pas trop ce que ça signifie et qu'est-ce qui se cache derrière et ça c'est le principe de l'héritage, c'est le principe des classes abstraites, de tout ce qui est polymorphisme.

On en parlera, on aura pas mal de nouvelles notions qui vont arriver et de la séance prochaine on parlera justement de l'héritage.
ce sera donc beaucoup plus clair pour vous d'expliquer ce genre de choses-là.

Et justement que l'on avait cette fameuse erreur :
```java
	java.util.InputMismatchException
```
Si je veux savoir où est-ce qu'elle se trouve dans la famille, la hiéarchie des exceptions, je vous ai fait un petit schéma pour vous montrer comment ça ce passe.
```txt
			Throwable
				^
			Exception
				^
		RuntimeException
				^
		NoSuchElementException
				^
		InputMismatchException
```
On a Throwable, Throwable c'est la classe mère, c'est elle qui est au-dessus de tout le monde au niveau des exceptions, tout ce qui concerne les exceptions ou les erreurs, ça englobe également les erreurs. on a juste Throwable.

ça signifie concrêtement que ça ne signifie rien concrêtement, c'est abstrait c'est vague.

On ne peut pas vraiment dire grand-chose de manière concrète, c'est très très abstrait, très général.

Dans Throwable, on a les exceptions, il y a d'autres choses mais on ne les montre pas ici et dans Exception, On peut se spécialiser en RuntimeException.

Et RuntimeException possède d'autres sous-classes tel que NoSuchElementException, et elle possède une sous classe qui est InputMismatchException.

Vous voyez il y a vraiment cette hiéarchie, cette famille de différentes choses et donc évidemment, tout ce que peut faire Throwable, InputMismatchException peut le faire aussi. 

En gros cette classe Throwable, qui est la plus haute, possède les fameuses méthodes tel que getMessage() et printStackTrace() et cetera.

Et comme Throwable, elle a ses méthodes définies, Exceptions, comme elle en hérite, elle peut les utiliser aussi.

RuntimeException aussi puisqu'elle hérité de tout ce qui est Exception, Qui elle-même a tout ce que a Throwable. Et ainsi de suite, ainsi de suite.

je ne vais pas trop m'étaler là dessus parce que c'est ce qu'on verra dans la prochaine vidéo de plus en détail, plus précisément.

mais voilà le principe de l'héritage et comme ça ça fait la transition avec la prochaine séance.

j'espère que c'était suffisamment complet, j'essaie de vous expliquer au mieux pour que vous ayez un maximum d'éléments concernant les exceptions.

Donc la règle avec les exceptions, peu importe le langage de programmation d'ailleurs, c'est de vérifier chaque méthode, chaque classe où chaque chose qui peut éventuellement lever une exception, Encore une fois tout indiqué dans la documentation.

Vous n'avez pas besoin de le deviner ou de l'inventer où d'apprendre par coeur, vous utilisez une méthode donc regarder dans la doc, est-ce qu'elle peut lever des exceptions? Si oui quel type? Et gérer vos exceptions. 

Il n'y a rien de plus mauvais en programmation qu'un développeur qui utilise un langage utilise tout un tas de choses qui làve des exceptions et ne les gèrent, et ne les traite jamais.

C'est comme ça qu'on a des programmes qui coupe et qu'on n'en fait rien.

Comme on ne fait rien on ne peut absolument rien contrôler et c'est un peu dommage.

c'est l'avantage des langages objets qui proposent des exceptions, C'est quelque chose qui n'existe pas forcément dans d'autres langages de programmation Donc servez-vous en ce n'est pas là pour ajouter du code inutilement, c'est vraiment la pour gérer tout un tas d'erreurs, tout un tas d'exceptions qui peuvent arriver au cours de vos programmes et de l'exécution de vos programme.

N'hésitez pas à faire des commentaires ou à partager les vidéos. 

Je vous laisse avec cette petite séance pour la prochaine vous savez ce qui vous attend où nous parlerons d'héritage et de polymorphisme. 

Ciao tout le monde