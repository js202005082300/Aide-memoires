/* 
Java #16 - lecture au clavier
Bonjour bienvenue sur la séance 16 en Java.
Il est temps pour nous d'aborder la saisie ou du moins la lecture de données Et en l'occurrence la saisie de données par l'utilisateur au clavier.
Nous allons voir quelques classes et quelques petits outils que nous allons utiliser pour réaliser ce genre d'opération là sur notre code.
On aborde la lecture au clavier seulement maintenant ce qui change des autres formations où l'on abordait la saisie de données assez tôt Mais ici Java est un langage qui possède pas mal de classes et de notions sous-jacentes. il fallait qu'on les abordent avant de passer à la lecture de données.
On va revenir sur un code très sobre pour le coup où l'on retrouve pour le coup Notre classe principale et notre méthode statique main() pour le point d'entrée de notre programme.
public class App
{
	public static void main(String[] args)
	{	
}
}
2 classes pour lire des données
=========================
Et à partir de là nous allons parler de 2 classes principales, De 2 manières pour pouvoir justement lire des données sur un flux d'entrée normalement le clavier.
On demande à l'utilisateur une information au clavier.
Pour rappel, comme on avait vu dernièrement pour tout ce qui est chaîne de caractères, on a parlé de Stringbuilder et Stringbuffer. Il y avait des différences sur le fonctionnement et le contexte d'utilisation de ces différentes classes. 

BufferedReader
==============

Ici on va retrouver un peu la même chose. On va avoir un cas où on va avoir une classe qui va travailler uniquement avec des chaînes de caractères. Vous savez ce que c'est une chaîne de caractères on a fait une vidéo en 2 parties là-dessus. Ce sera d'ailleurs plus simple pour poursuivre à présent. Et ce genre de données va juste se charger de faire de la lecture, on va lire les données et on va utiliser pour cela, la classe qui s'appelle BufferedReader : 
public class App
{
	public static void main(String[] args)
	{	
		BufferedReader br;
	}
}
Où l'on appelle par exemple ici br pour rester simple dans le terme ici.
BufferedReader va permettre de lire des chaînes de caractères, donc de type String comme ici String[] args.
Il ne fera rien d'autre que de la lecture de données de ce genre-là. 
C'est quelque chose qui est synchroniser c'est-à-dire qui est thread-safe, terme qu'on a employé lorsqu'on avait parlé des chaînes de caractères.
Mais vous allez voir ici, l'exception voudra que cette méthode ci Soit plus rapide que la suivante, celle que nous verrons en 2e partie de la vidéo. On expliquera pourquoi. 
Ça c'est la première partie, lecture de chaînes de caractères, thread-safe donc c'est synchronisé.

Scanner
=======

On va voir un 2e objet dont on parlera par la suite qui est Scanner qui lui n'est pas thread-safe donc il est asynchrone. 
public class App
{
	public static void main(String[] args)
	{	
		BufferedReader br;
		Scanner sc;
	}
}
L'utilisation de scanner sera plus lente. Cette classe est plus lente que BufferedReader, tout simplement parce qu'en plus d'avoir de la lecture …

BufferedReader vs Scanner
=========================

/
	BufferedReader -> 	synchrone
					thread-safe
					lecture de chaîne de caractères 

/
On va avoir BufferedReader qui est donc synchrone et comme il est synchrone il est thread-safe. On ne reviendra pas sur ce détail là puisqu'on les a expliqué précédemment. Il faudra revenir sur les vidéos précédente pour savoir à quoi ça fait référence. Mais voilà il n'y a qu'une lecture de chaîne de caractères.
Voilà pour le premier cas, celui qu'on va voir au début de la vidéo. 

Pour l'autre, scanner, on va avoir quelque chose d'asynchrone.

/
	BufferedReader -> 	synchrone
					thread-safe
					lecture de chaîne de caractères 

	Scanner -> 		asyncrhome
				not thread-safe
					lecture de données + parsing

/
Qui du coup n'est pas thread-safe. Il y a du coup ici une lecture de données de n'importe quel type que ce soit chaîne de caractères, un int, un short, un booleen, et cetera. Plus éventuellement un parsing, parsing des données. Du coup 2 étapes, pour ce qui est de l'étape du parsing est une opération très coûteuse. Et donc ça rend l'usage de cette classe Scanner beaucoup plus lente que BufferedReader.
Même si on nous avait expliqué précédemment Que quand on a des classes avec par exemple une différence que l'une est synchrone et l'autre asynchrone, généralement la classe qui est asynchrone sera plus rapide.
Si on travaille dans un environnement multi-threadé, elle n'a pas besoin d'attendre la finalisation des tâches d'un thread pour qu'un autre thread puisse continuer à travailler. 
On n'a pas comme ça de thread-safe, donc tout se fait de manière asynchrone et tout travaille beaucoup plus vite. 
L'exception qui fait que pour le coup c'est inversé, C'est ça qui est important ce qu'il faut savoir qu'il y a une étape supplémentaire. 
On ne se cherche pas de lire une chaîne de caractères sans se poser de questions, on va lire n'importe quel type de données et en plus de çà, on aura la possibilité de parser les données.
Parce que les données ça peut être tout simplement le fait, de vérifier le type de données qui est lu, par exemple lire en entier ce n'est pas comme lire une chaîne de caractères ou un booléen et en plus on peut travailler avec des expressions rationnelles . Par exemple vérifier qu'un mot contient un certain nombre de caractères précis ou par exemple l'exactitude d'une adresse IP ou d'une adresse mail , d'une adresse ou d'un code postal pour avoir un format bien spécifique et correct par rapport à la saisie qui est faite .
Tout ça représente pas mal d'opération Et de vérifications supplémentaires de toute cette partie que l'on appelle le parsing qui va faire de la vérification, qui va modifier certaines données et faire des contrôles dessus.
Tout ça est coûteux, rajoute des opérations complémentaires et rend la classe plus lente .
C'est très important en Java comme il y a beaucoup de classe possible, il est préférable de nous expliquer le fonctionnement de chacune en fonction du contexte qu'il faut. On ne va pas s'amuser à utiliser scanner si on n'a pas besoin de lire autre chose que des chaînes de caractères et qu'il n'y a pas de parking à faire. ce serait un petit peu dommage d'utiliser ce genre de classe.

La classe BufferedReader
========================

On va d'abord commencer par celle-ci. On utilise BufferedReader qui lit les chaînes de caractères.
Donc tout sera lu comme une chaîne de caractères.

public class App
{
	public static void main(String[] args)
	{	
		BufferedReader br;
	}
}
Si vous venez d'un autre langage de programmation tel que python. Par exemple python lorsqu'on fait appel à la fonction input() pour la saisie de données justement au clavier, tout est considéré comme étant une chaîne de caractères. buffer Reader c'est un peu pareil, il considère que toute saisie qui sera faites même si la personne entre sur son clavier à un nombre sera considéré comme étant une chaîne de caractères de ce nombre et non pas comme un nombre arithmétique avec lequel on pourrait faire des calculs, toujours ce genre de choses.
Ce sera beaucoup plus rapide parce qu'on va juste avoir de la lecture de chaîne de caractères, on peut mettre un String : 
/
	BufferedReader -> 	synchrone
					thread-safe
					lecture de chaîne de caractères (String)

	Scanner -> 		asyncrhome
				not thread-safe
				lecture de données + parsing

/
Lecture d'un String sans faire de conversion, sans devoir contrôler, De contrôle pour faire des conversions type puisqu'on travaillera directement avec des chaînes de caractères. 
Comment ça se passe en termes de code? Ça va être très très simple. La première chose on va créer notre constructeur, on va instancier notre classe et en paramètres, elle va avoir besoin d'un Reader, c'est une metaclass, c'est une très très grande classe de Java. 

	BufferedReader br = new BufferedReader();

Quand on abordera la vidéo sur l'héritage virgule on reviendra en détail là-dessus. C'est-à-dire les classes les sous-classes et cetera. 
On va avoir besoin ici d'une classe pour la lecture c'est-à-dire où ce que ce buffer de lecture va-t-il lire ? Par défaut il ne sait pas vraiment où est-ce qu'il doit lire et on peut lire sur pas mal de choses, un périphérique d'entrée, un flux bien particulier est un fichier. Bref il y a plusieurs types de flux et d'entrées disponible.
Et nous on veut lire justement sur notre clavier. Pour faire ça on va avoir besoin d'un Reader et notamment de Reader particulier qui est le InputStreamReader, un lecteur pour le flux d'entrée et ça tombe bien parce que notre clavier est un périphérique d'entrée donc il permet de saisir dans le flux d'entrée.
Alors déjà on va ajouter cette première classe et maintenant qu'on sait ce que c'est un package qu'on a vu dans une vidéo un petit peu avant, Il devient plus facile maintenant de pouvoir expliquer le import de certaines classes Parce que BufferedReader n'est pas compris par défaut dans un code en Java. Il faut l'importer nous même. 
Donc on commence par faire un importe java.io et ici pour le coup, on met BufferedReader.
Et pour la partie concernant le lecteur, le fameux InputStreamReader, c'est dans le même package.

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App
{
	public static void main(String[] args)
	{	
		BufferedReader br = new BufferedReader();
	}
}

Pour rappel on peut mettre une étoile si on veut importer tout ce qu'il y a dans IO mais on ne le fait pas parce qu'on préfère importer seulement ce dont on a besoin. Et surtout plutôt éviter d'importer 20 ou 50 classes si au final on utilise que 2 classes. ça c'est vous qui voyez En fonction de vos préférences.
À partir de là on va avoir besoin d'un InputStreamReader, On va créer l'instance directement à l'intérieur de BufferedReader. vous savez ce que c'est une méthode, une fonction. Comment fonctionnent les paramètres ou les arguments quand on fait ici des d'instanciations mais nous on va le faire avec une étape supplémentaire pour que ce soit plus lisible au niveau de la vidéo. 
Donc on fait un InputStreamReader :

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App
{
	public static void main(String[] args)
	{	
		InputStreamReader isr = new InputStreamReader();
       BufferedReader br = new BufferedReader();
	}
}

On fait notre InputStreamReader que l'on va appeler ISR Et on va l'instancier comme ceci : = new InputStreamReader();
Et lui ne prend pas un Reader ici comme argument lorsqu'on va faire l instanciation Mais il attend comme donnée tout simplement un flux que l'on veux. Et le flux que l'on veut, on en connaît un qui est déjà pas mal qui est Systeme.out 
Rappelez vous quand on utile Systeme.out et qu'on fait ensuite un println("Hello") pour afficher un message.

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App
{
	public static void main(String[] args)
	{	
		InputStreamReader isr = new InputStreamReader();
       BufferedReader br = new BufferedReader();
       
       System.out.println("Hello ")
	}
}
… Et bien vous avez l'inverse, au lieu de Systeme.out, on a system.in Qui est le flux de base, le flux standard pour l'entrée. Alors on fait ça, attention il y a une majuscule à System. Très important.

	InputStreamReader isr = new InputStreamReader(System.in);

Et du coup mon buffer, va prendre cette information.

       BufferedReader br = new BufferedReader(isr);

Il va utiliser ce lecteur de flux d'entrée : 

	InputStreamReader isr = new InputStreamReader(System.in);

… lors de la création du constructeur, l'appel au constructeur de cette classe pour pouvoir être utilisé.
C'est très simple mais voyez comme ce que l'on dit du langage Java, ce que c'est un langage très verbeux c'est à dire que dès qu'on va vouloir utiliser quelque chose en particulier, on doit tout renseigner en fait. Il n'y a pas forcément des usages implicites qui sont faits, c'est là qu'on voit qu'on a besoin d'un certain type de données en particulier :

	(isr);

Un type de données particulier pour le buffer, et bien on doit créer cette donnée là.

Alors soit on fait comme ça de manière intermédiaire, soit on fait directement ça :

BufferedReader br = new BufferedReader(new InputStreamReader());

Si vous n'avez pas encore compris ça, ce qu'il y a des choses que vous n'avez pas encore compris au niveau de la programmation objet et qu'il faudra revenir dessus. 
Ce qu'on vient d'écrire ici, c'est exactement la même chose bien que ce soit peut-être un peu moins lisible mais il est recommandé de faire en 2 étapes : 

	InputStreamReader isr = new InputStreamReader(System.in);
       BufferedReader br = new BufferedReader(isr);

Une fois qu'on a notre buffer qui est prêt, on va pouvoir tout simplement commencer à l'utiliser. 

On rappelle que tout est chaîne de caractères quoi qu'il arrive, peu importe l'information que l'on va demander, ce sera à stocker dans une chaîne de caractères obligatoirement.

       System.out.print("Comment t'appelles-tu ?");

Donc on fait la fameuse question comment t'appelles-tu? On va rester sur quelque chose notre simple. On va faire un simple print sans retour à la ligne.
	
       String name = br.(...)

On prépare ensuite la donnée String name et on va le stocker dans br.
On va utiliser une méthode par rapport à la lecture.
Pour ça nous en avons quelques unes :
- on a read() qui va lire un caractère 
- On a readLine(), avec un L majuscule pour tout simplement lire un mot complet par rapport à ce que l'on récupère, pour une chaîne.
De toute façon il travaille toujours sur des chaînes de caractère composé que d'un seul caractère read() ou d'une chaîne composée de plusieurs caractères readLine(). Mais ça reste la même chose.
Ensuite on peut ignorer certains caractères, pour une raison ou une autre ignorer un certain nombre de caractères, on peut le faire. Il y a un certain nombre de caractères à passer dans la méthode skip(). Par exemple, skip(N) ignore N caractères.

/
	BufferedReader -> 	synchrone
						thread-safe
						lecture de chaîne de caractères (String)
		- read() : lire un caractère
		- readLine() : lire une chaîne
		- skip(N) : ignore N caractères

	Scanner -> 	asyncrhome
				not thread-safe
				lecture de données + parsing
/
Ici quelques méthodes utiles, qu'on a souvent besoin en programmation et il y en a forcément d'autres mais celle là en tout cas sont les principales.

Donc ici on veut récupérer un nom au complet, donc on va faire simplement un readLine() et à la fin on va l'afficher, on affichera directement name avec la méthode println().

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App
{
	public static void main(String[] args)
	{	
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
       
		System.out.print("Comment t'appelles-tu ?");
		String name = br.readLine();
       
		System.out.println(name);
	}
}

On compile javac App.java et là on va avoir un message d'erreur :

	error: unreported exception IOException; must be caught or declared 	to be thrown
                String name = br.readLine();
                                         ^

… qui veut tout simplement dire que notre méthode ici readLine() peut éventuellement lever une exception mais on ne sait pas à ce stade de la formation ce que c'est mais ça tombe bien parce que ça fera la transition avec la prochaine séance. Il dit qu'on va devoir capturer cette exception Ou alors déclaré que notre code peut éventuellement lever une exception. Ça ne veut pas dire qu'il a fait, Ça veut tout simplement dire que c'est un risque potentiel qui arrive ainsi à la compilation Java, on nous prévient que cette méthode ne va pas forcément faire ou récupérer la donnée que nous attendons et elle peut dans ce cas-là lever une exception.

Sans entrer dans les détails, une exception Une exception va permettre notamment de soulever une erreur au niveau de notre programme et c'est ce que nous verrons dans la prochaine vidéo. pour le moment qu'on n'a pas encore abordé cela, on va juste s'occuper d'ajouter throws et Exception avec un E majuscule.
*/

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class App
//{
//	public static void main(String[] args) throws Exception
//	{	
//		InputStreamReader isr = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(isr);
//       
//		System.out.print("Comment t'appelles-tu ? ");
//		String name = br.readLine();
//       
//		System.out.println(name);
//	}
//}

/*
throws Exception, C'est simplement une petite indication pour dire que ma méthode statique main, Elle peut éventuellement dans son code un moment donné lever une exception C'est-à-dire il peut y avoir une erreur qui survient lors de l'exécution Du programme. Ça peut arriver et notamment à cause de cette méthode readLine().

Donc juste avec ça on va pouvoir éviter le petit warning et on va pouvoir recompiler et même tester notre programme. 

	>javac App.java
	>java App
	Comment t'appelles-tu ? Samuel
	Samuel

On test notre programme, on met l'information et celle-ci est bien récupérée.
Comme tout est considéré comme étant une chaîne de caractères, Pour rappel si on met un nombre: 

	Comment t'appelles-tu ? 64949
	64949

… Ce sera récupéré comme une chaîne de caractères, ça fonctionnera aussi. 

Notion de tampon
================

Autre information aussi très importante, dès qu'il y a une lecture, on a une histoire de mémoire tampon, de buffer et ce buffer a aussi une petite différence.

/
	BufferedReader -> 	synchrone
					thread-safe
					lecture de chaîne de caractères (String)
					tampon de 8192 caractères
		- read() : lire un caractère
		- readLine() : lire une chaîne
		- skip(N) : ignore N caractères

	Scanner -> 	asyncrhome
			not thread-safe
			lecture de données + parsing
			tampon de 
/

Si on ne se trompe pas, le tampon de BufferedReader est un peu plus important parce que ici on est sur de la simple lecture et non pas sur du parsing. Pour BufferedReader le tampon est de 8192 caractères Donc ça ce n'est pas une valeur prise par hasard, tout simplement des multiples comme on le retrouve beaucoup en informatique. Si on voit la taille de notre mémoire vive, de notre disque dur et cetera, Ça fait 8 16 32 64 128 256 512 1024 2048 4096 8192 et cetera. 

Donc ils ont choisi arbitrairement cette taille pour se dire on créera un nouveau tampon, un nouveau buffer, si le nombre de caractères entrés dépasse cette longueur de 8192 caractères.

Donc ça laisse quand même pas mal de marge avant de remplir le premier tampon de lectures, donc 8192.

Or scanner on peut le noter là mais on verra son utilisation après. lui c'est un tampon par contre 1024 caractères, un peu plus petit.

Conc en gros si on atteint les 1024 caractères, un 2e tampon est créé et cetera et cetera.

Ca aide de créer un tampon de 1 caractère et du coup de faire imaginer plein d'opérations de création de tampon par caractère lu, Parce qu'il serait évidemment très très coûteux. C'est souvent un problème sans en être un mais il y a une chose sur lequel il faut pas mal réfléchir quand on fait de la programmation Ou quand quelqu'un crée un langage, de se dire que au niveau des tampons de lecture, quelle taille je choisie ? 

Parce que si on prend trop grand, ce sera peut être trop en mémoire réservée. Si on prend trop petit, il faudra créer plus souvent des tampons et ça va demander pas mal d'opérations coûteuses. Il faut essayer de trouver le juste milieu.

voilà par rapport à la formation sur la taille de tampon Pour BufferReader.

À partir d'ici nous pouvons lire n'importe quel type de données qui sera encore une fois considéré comme une chaîne de caractères. N'essayez pas de faire un read ou un readLine Dans une donnée de type int, ça ne marchera pas. Vous aurez une erreur par rapport ici au type :

       String name = br.readLine(); -> OK
       int name = br.readLine(); -> NOK

On ne peut pas convertir, on ne peut pas caster notre chaîne en entier. 
Ca ne peut pas aller si on attend un entier et qu'on essaye de passer une chaîne de caractères.
Dans quel cas utiliser cette méthode là ? Je vous l'ai dit tout est indiqué en commentaire, BufferedReader est utilisé si on veut lire de la chaîne de caractères sans avoir besoin de vérifier un type particulier, donc juste pour de la lecture. Si on veut juste lire de la chaîne de caractères, la solution et c'est du coup la plus rapide des 2 présenté dans cette séance, c'est BufferedReader. C'est pour ça qu'on la présente en premier.

La classe Scanner
=================

Maintenant si on a besoin de vérifier un type précis et qu'on a besoin de récupérer une donnée, absolument un nombre, et qu'on ne veut pas que ce soit une chaîne mais juste un nombre arithmétique qui permettra et qui servira dans la base d'un calcul admettons. On utilisera plutôt la classe scanner.

Cette classe Scanner va dans java.util qui regroupe toutes les classes utilitaires de Java, qui sont toutes stockées dans java.util
On a pas mal de classe là dedans. 

       import java.util.Scanner;

Pour Scanner l'utilisation est très simple. Donc ça va aller très vite.
On a encore une fois toutes les informations utiles, scanner et asynchrone, du coup ce n'est pas thread-safe par contre c'est beaucoup plus lourd à l'usage que BufferedReader Parce qu'il y a une lecture de données avec vérification du type en fonction de la méthode utilisée et un parking puisqu'il va falloir contrôler justement, faire des conversions par rapport à ça. Le tampon est plus petit, on vient de le dire tout à l'heure donc on ne reviendra pas là-dessus. 

Ici l'usage est un petit peu plus court, on fait simplement : 

public class App
{
	public static void main(String[] args) throws Exception
	{	
		Scanner sc = new Scanner();
	}
}

Scanner() Va directement prendre le feu sur lequel on veut travailler Donc pas besoin de passer par InputStreamReader ou autre. Il prend un Input String Directement en paramètre, il attend un argument pour le constructeur. et on fait ceci :

public class App
{
	public static void main(String[] args) throws Exception
	{	
		Scanner sc = new Scanner(System.in);
	}
}

À partir de là il y a plusieurs possibilités de lecture parce qu'on avait dit qu'il y avait plusieurs méthodes éventuelles par rapport au type de données que nous voulons lire et ça c'est très important.

/
	BufferedReader -> 	synchrone
					thread-safe
					lecture de chaîne de caractères (String)
					tampon de 8192 caractères
		- read() : lire un caractère
		- readLine() : lire une chaîne
		- skip(N) : ignore N caractères

	Scanner -> 	asyncrhome
			not thread-safe
			lecture de données + parsing
			tampon de 
		- nextLine()
		- nextChar()
		- nextByte()
		- nextFloat()
		- nextDouble()
		- nextInt()
		- nextBoolean()
/

On peut lire éventuellement une simple chaîne donc on peut très bien dire tu lis la chose comme étant une chaîne, il peut attendre un booléen, un entier ou n'importe quoi. 
On va avoir en gros plein plein plein de méthode c'est-à-dire nextLine() au plus simple, au plus standard. On a également nextChar(), nextByte(), nextFloat(), nextDouble(), nextInt(), et cetera et cetera. Histoire de comprendre le principe. 
C'est pour ça que cette classe est un peu plus gourmande à l'utilisation et sera plus lente parce qu'en plus de faire de la lecture de données, il faut qu'elle vérifie également le type de données qu'on lui donne et si la donnée attendue n'est pas bonne, une erreur sera soulevée, donc justement une exception Qui interviendra à ce moment-là.

On enlève throws Exception, on verra si on le remet après.
Ensuite du coup qu'est-ce que je peux faire ? Je vais faire un println() Et on demande par exemple:« acceder a quel niveau ?». 

public class App
{
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Acceder a quel niveau ?");

	}
}

Si on était dans un jeu, ce ne serait pas forcément quelque chose qui servirait comme calcul, ce ne serait pas vraiment une valeur qui serait arithmétique peu importe. On va dire qu'on attend absolument un nombre et pas autre chose et ensuite on affichera du coup game_level.

Du coup ici on pourra dire sans problème qu'on attend un entier. Donc j'écrit simplement nextInt(). Donc ici c'est une méthode qui a comme opération une lecture et du contrôle de la vérification, donc du parsing.
Donc elle va parser les données pour s'assurer que en faisant la conversion nécessaire, que là donnée est bien valide, un entier et pas autre chose. Donc il y a plus d'opérations, plus gourmand du coup à l'utilisation.
Si nous n'avons rien oublié nous allons pouvoir l'utiliser …
*/

import java.util.Scanner;

public class App
{
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Acceder a quel niveau ?");
		int game_level = sc.nextInt();

		System.out.println(game_level);
	}
}

/*

On compile, on exécute, On demande quel niveau, on l'inscrit tant que ça reste un entier alors pas de problème mais si ça finit par dépasser la taille d'un entier au niveau du langage, on aura une exception de lever :

	>java App
	Acceder a quel niveau ?
	999999999999999776
	Exception in thread "main" java.util.InputMismatchException: For 	input string: "999999999999999776"
        	at java.base/java.util.Scanner.nextInt(Scanner.java:2264)
        	at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        	at App.main(App.java:425)

… Une exception de lever, InputMismatchException.
comme on a pas encore abordé des exceptions, en rentre pas encore dans les détails là dessus. On le verra dans la prochaine séance. 
On a une erreur qui est indiquée , une exception qui est lever et qui provoque l'arrêt du programme. 
Donc très important, on verra que les exceptions sont absolument utiles, il faut s'en servir et c'est pour ça qu'on va faire une vidéo dédiée à ça pour la prochaine séance de secours de Java. 
Donc si on écrit :

	Acceder a quel niveau ?
	64
	64

Comme ça ça marche et si on écrit une chaîne :

	Acceder a quel niveau ?
	Jason
	Exception in thread "main" java.util.InputMismatchException

Toujours pareil une exception sera lever.
vous voyez il y a une opération supplémentaire de vérification de données donc si un jour vous avez besoin d'avoir un type de données bien précis, utiliser scanner, elle est fait pour ça. 
Si c'est juste de la lecture toute bête, ne vous embêtez pas avec ça, votre programme sera beaucoup plus lent, utiliser de préférence BufferReader et ce sera beaucoup plus efficace dans ce cas-là même si elle est synchrone et généralement pour beaucoup d'autres cas, Quelque chose qui est synchrones sera généralement beaucoup plus lent une classe qui travaille de manière asynchrone donc attention prenez cette habitude aussi surtout en Java parce que le langage est très complet, il y a beaucoup de classes disponibles, de méthode,de choses disponibles. du coup on ne sait pas toujours quoi utiliser dans quel contexte donc prenez l'habitude avec la documentation De vous renseigner de voir un peu comment et composer une classe, de quelle manière elle est utilisée, comment elle fonctionne derrière et après ce long contexte d'utilisation , ce long la partie de notre programme bien précises, bien spécifique, Vous serez s'il vaut mieux utiliser telle classe ou telle classe. 
Il n'y a malheureusement pas de classe toute faite il fonctionnera tout le temps dans le meilleur des cas, dans tous les contextes d'usage, c'est vraiment cas par cas. c'est à nous en tant que développeur de savoir dans quel cas on va utiliser ça et dans quel cas on va utiliser ça. 
Sur cette séance , je voulais juste qu'on voit de la lecture de données. On a BufferedReader, on a scanner et on sait maintenant les différences entre les 2. ça nous donne déjà pas mal d'indices sur l'usage que l'on peut en faire avec l'une ou avec l'autre. N'hésitez pas à faire pas mal de programme pour vous entraîner et n'hésitez pas à le coupler avec tout ce que vous avez vu sur les chaînes de caractères, ça peut être pas mal utile parce qu'ici on ne s'est pas amusé à utiliser du StringBuilder ou du StringBuffer pour faire certaines choses Ou des concaténations et vous pouvez bien évidemment coupler tout ce que vous avez vu précédemment pour vous entraîner, pour vous exercer avec ce langage Java.
on se retrouve pour la prochaine séance où on abordera les exceptions. Ça fait du coup une bonne transition avec la prochaine séance concernant les exceptions virgules pour voir comment gérer les erreurs en Java. A bientôt.

*/



