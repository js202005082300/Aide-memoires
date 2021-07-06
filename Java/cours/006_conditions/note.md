
# [6. Conditions](https://www.youtube.com/watch?v=0rANfWRfc_c)

Bonjour à tous et bienvenue sur la 6e séance en Java où nous allons aborder ensemble les structures conditionnelles.

Donc on va voir en fait comment utiliser certains opérateurs qu'on a vu dernièrement notamment les opérateurs de comparaison donc je vous ai noté ici avec quelques opérateur qui vont permettre de combiner plusieurs tests, d'accord, plusieurs conditions que nous allons vérifier et on va regarder ça comment ça s'utilise en fait au niveau de notre code.
```java
	/*
		== 	égal à
		===	égal et de même type à
		!=	différent de
		< 	strictement inférieur à
		<= 	inférieur ou égal à
		>	strictement supérieur à
		>=	supérieur ou égal à
		
		&&	ET
		||	OU
		
	*/

public class App
{
	public static void main(String[] args)
	{
		
	}
}
```
Alors un test de comparaison on pourrait très bien le faire sans utiliser de structures conditionnelles c'est-à-dire que je pourrais très bien m'amuser à faire une variable booléenne ici en mettant par exemple, je sais pas moi, une valeur, je vais mettre value.
```java
public class App
{
	public static void main(String[] args)
	{
		boolean value = 
	}
}
```
et ensuite on met un test d'accord dans une expression on écrit un test.

Un test ça peut être quoi ? ça peut même simplement par exemple vérifier est-ce que 24 est égal égal à 24 et on fait ça.

```java
public class App
{
	public static void main(String[] args)
	{
		boolean value = (24 == 24);
		System.out.println(value);
	}
}
```
et l'a ensuite on affiche le résultat pour voir un petit peu ce que ça donne.
```powershell
	>javac App.java
	>java App
	true
```
Alors là je vais compiler tout ça et si on teste ça nous retourne la valeur true d'accord qui veut dire vrai pour dire tout simplement bah oui 24 c'est bien égal à 24.

Petit rappel de ce que je vous avais montré rapidement la dernière fois sur la vidéo sur les opérateurs.

On a donc l'opérateur d'égalité (==).
ici petite distinction on a un opérateur qui vérifie et l'égalité et le fait que les données testées sont de même type d'accord parce qu'on pourrait traduire par exemple ici avoir un nombre 24 et une chaîne de caractères donc un texte en fait 24. 
```java
		boolean value = (24 == "24");
```
donc c'est la même valeur ainsi ils sont tous les 2 égaux par contre ils ne sont pas de même type donc ça, ça retournait true ça par contre ça retournerait false puisque là on a une chaîne "24" et là on a un nombre 24 donc ça on aura l'occasion d'en parler de toute façon quand on parlera des chaînes de caractères plus en détail donc on peut faire ce genre de test et après vous retrouvez l'opérateur de différence (!=), OK.

D'ailleurs j'oublie qu'il y a aussi l'opérateur de négation, ok ici.
```java
	/*
		== 	égal à
		===	égal et de même type à
		!=	différent de
		< 	strictement inférieur à
		<= 	inférieur ou égal à
		>	strictement supérieur à
		>=	supérieur ou égal à
		!	inverse de (négation)
		
		&&	ET
		||	OU
		
	*/
```
Voilà l'opérateur différents qui lui est un ! et un égal (!=) pour pas se tromper avec autre chose. L'opérateur égal, c'est double puisque le simple c'est pour l'affectation et les opérateurs arithmétiques que vous retrouver beaucoup en mathématiques : Le inférieur à (<), inférieur ou égal (<=), supérieur à (>), supérieur ou égal (>=) et toujours le égal après c'est important, pas avant, pas vous tromper.

Ca (!) c'est l'opérateur de négation mais on en parlera un petit peu après alors comment faire ces expressions de comparaison en fait au sein d'une structure conditionnelle ? comment que ça se passe ? 

Alors ce qu'on va faire, on va laissé value et pas s'embêter avec ça.

On va mettre les valeurs 24 ici et on va faire un premier test. Tout à l'heure on vérifie, est-ce que en fait 24 est égal à 24 donc en fait est-ce que cette variable qui s'appelle Value à la valeur 24.
```java
public class App
{
	public static void main(String[] args)
	{
		boolean value = 24;
		System.out.println(value);
	}
}
```
Et dans une structure conditionnelle on va utiliser le mot clé IF qui veut dire si en anglais et on va ouvrir des parenthèses et dans ces parenthèses on va mettre le test que l'on veut faire. Nous ce que l'on veut tester c'est est-ce que Value est égal à 24 et si c'est le cas et bien on va l'afficher comme ceci. Donc on mettra par exemple.
```java
public class App
{
	public static void main(String[] args)
	{
		boolean value = 24;
		
		if(value == 24)
			System.out.println("value = 24");
	}
}
```
Alors là, si vous avez un structure conditionnelle c'est, comme pour ce qu'on verra d'ailleurs ce qu'on aura l'occasion d'aborder plus en détail plus tard les classes et les méthodes, des accolades.
C'est à dire qu'on va écrire ça dans des accolades pour montrer où ça commence et où ça se termine.
```java
		if(value == 24)
		{
			System.out.println("value = 24");
		}
```
Petite exception, si vous n'avez qu'une seule instruction comme moi je l'ai ici les accolades sont optionnelles. Vous pouvez les enlever.

Alors si vous avez peur de vous tromper dans votre code vous pouvez mettre tout le temps ça fonctionne à tous les coups, d'accord.

Vous pouvez mettre des accolades même avec une seule instruction il y a aucun problème par contre si vous oubliez les accolades alors vous avez plus d'une instruction là vous aurez des erreurs de compilation.

Donc à vous de voir, moi j'en mets pas puisque je n'ai qu'une seule instruction donc je sais qu'il n'y a pas de problème et on va pouvoir du coup tester.
```java
public class App
{
	public static void main(String[] args)
	{
		boolean value = 24;
		
		if(value == 24)
			System.out.println("value = 24");
	}
}
```
```powershell
	>javac App.java
	App.java:145: error: incompatible types: int cannot be converted to boolean
							boolean value = 24;
											^
```
Alors ça oui il faut repasser sur une integer là hop.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 24;
		
		if(value == 24)
			System.out.println("value = 24");
	}
}
```
```powershell
	>javac App.java
	>java App
	value = 24
```
Voilà okay, donc on rentre dans la condition d'accord comme Value est bien égal à 24, ça rentre à l'intérieur, donc ça vient dans ce qui est ici au niveau de la condition donc ça fait bien l'instruction là qui elle du coup doit afficher Value égal 24 d'accord.

Si ce n'était pas le cas et si je met par exemple ça.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 16;
		
		if(value == 24)
			System.out.println("value = 24");
	}
}
```
```powershell
	>javac App.java
	>java App
```
Et là on voit que ça n'affiche rien d'accord ça veut dire donc que cette instruction a été ignorée parce que cette condition n'est pas vrai. 
```java
		if(value == 24) //-> false
			System.out.println("value = 24");
```
Cette condition en faite va retourner false. Si ça retourne True on fait ce qui est à l'intérieur de la structure, si ça retourne false on ne le fait pas, on l'ignore tout simplement donc voilà comment on peut gérer ces cas-là.

Alors ça c'est le IF d'accord, c'est la partie, on va dire là la condition, la plus simple que l'on peut faire mais on peut également faire plusieurs tests.
On n'est pas obligé de faire une seule vérification là, on peut en combiner d'autres d'accord.
Si on veut le faire alors on peut soit faire ça. Par exemple si le IF n'est pas égale à 24, est-ce qu'il est égal à 16 et du coup on dira ça.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 16;
		
		if(value == 24)
			System.out.println("value = 24");

		if(value == 16)
			System.out.println("value = 16");
	}
}
```
Voyez on met un IF et ensuite à la suite on met un autre IF et cetera et cetera.
Faire ce genre de chose et dans ce cas là, là je teste.
```powershell
	>javac App.java
	>java App
	value = 16
```
Et là, cette partie `System.out.println("value = 24")` sera ignorer puisque ce n'est pas égal à 24 par contre là `value == 16` donc on rentre bien dans le IF d'accord.

Alors ça c'est pas forcément très pratique, voyez on répète le IF à chaque fois. C'est un peu plus long du coup au niveau du code donc il a moyen de raccourcir en combinant ces 2 tests, on peut ici combiner ces 2 vérification là sur un seul IF.

Il suffit de prendre donc ça et d'utiliser la fameux opérateur pour le ET donc celui que je vous ai mis ici. Vous doubler ici le et commercial (&&) et vous faites votre test là et du coup ça fait ça.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 16;
		
		if(value == 24 && value == 16)
			System.out.println("value = 24");
	}
}
```
Par contre là vous perdez le fait de ne plus savoir quelle valeur, euh à quelle valeur ça correspond donc là par exemple on va permettre que c'est égale à 24 parce que si c'est 16, ça va rentrer dedans aussi donc voilà grosso modo comment on peut mettre ensemble les différentes vérifications.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 16;
		
		if(value == 24 && value == 16)
			System.out.println("Oui !");
	}
}
```
```powershell
	>javac App.java
	>java App
```
Donc là évidemment ça ne va pas rentrer dans le IF. Je dit des bétise, ce n'est pas le ET mais le OU pardon alors Value ne peut pas être égal à 16 et à 24 en même temps c'est juste impossible donc évidemment il ne faut pas se tromper voilà.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 16;
		
		if(value == 24 || value == 16)
			System.out.println("Oui !");
	}
}	
```
Donc là s'il est égal à 24 ou égal à 16, ça rentre bien ici, d'accord.
```powershell
	>javac App.java
	>java App
	Oui !
```
Donc on peut faire ces vérifications comme ça.

Qu'est-ce que je peux montrer aussi ? donc ça c'est l'ensemble voilà des différents tests qu"on peut faire au sein d'un même if.

Admettons que ça ne soit pas égale ni à 24 ni à 16, on aimerait par exemple afficher autre chose de mettre par exemple non.

Et bien pour le faire on va utiliser un autre mot clé de ces structures qui est le mot-clé ELSE qui veut dire sinon et là on va dire si ce n'est pas égale à 24 ni égale à 16, tu feras ce qu'il y a dans le ELSE donc il va ignorer en fait cette partie là d'accord.
```java
	System.out.println("Oui !");
```
Par contre il va automatiquement faire ce qu'il y a dans le ELSE donc la on mettre :
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 16;
		
		if(value == 24 || value == 16)
			System.out.println("Oui !");
		else
			System.out.println("Value ne vaut ni 24 ni 16");
	}
}
```
Dans ce cas-là je re exécute le code et là il met oui parce que c'est égal à 16.
```powershell
	>javac App.java
	>java App
	Oui !
```
Par contre si je met une valeur qui n'est ni 24 ni 16, automatiquement, je vais aller dans le ELSE, d'accord.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 25;
		
		if(value == 24 || value == 16)
			System.out.println("Oui !");
		else
			System.out.println("Value ne vaut ni 24 ni 16");
	}
}
```
```powershell
	>javac App.java
	>java App
	Value ne vaut ni 24 ni 16
```
voilà comment ça se passe donc pas obligatoire, c'est pas parce que vous avez un IF que vous devez mettre obligatoirement un ELSE mais ça peut être pas mal.

Quand vous avez tous les tests que vous avez mis avant qui ne sont pas bons et bien on rentre automatiquement dans le ELSE donc ça peut servir comme ça on va dire de cas de secours si jamais les conditions vérifier avant ne sont pas bonnes, donc ça c'est une possibilité.

On a vu le IF, on a vu le IF ELSE qui vont très bien ensemble et vous pouvez également faire d'autres tests là. Par exemple, on peut très bien dire alors if(value < 0), d'accord on va faire ce genre de chose. 
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 25;
		
		if(value < 0)
			System.out.println("value < 0");
		else
			System.out.println("Value ne vaut ni 24 ni 16");
	}
}
```
Et on peut dire sinon mais refaire un test et dans ce cas-là on fera un ELSE IF, c'est-à-dire par exemple il est plus grand que 100.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 25;
		
		if(value < 0)
			System.out.println("value < 0");
		else if(value > 100)
			System.out.println("value > 100");
		else
			System.out.println("Value ne vaut ni 24 ni 16");
	}
}
```
Et sinon bah du coup, dans le cas final et bien on affichera la valeur de value, voilà.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 25;
		
		if(value < 0)
			System.out.println("value < 0");
		else if(value > 100)
			System.out.println("value > 100");
		else
			System.out.println(value);
	}
}
```
Donc en gros si on a une valeur à notre variable qui vaut une valeur inférieure à 0 strictement, on affichera que value est strictement inférieur à 0 sinon si (c'est ce que ça veut dire) valeur est plus grand que 100, on affichera que valeur est plus grand que 100 et sinon ça veut dire que si c'est ni inférieur strictement à 0, ni supérieur strictement à 100 alors on affichera directement la valeur de value.
```powershell
	>javac App.java
	>java App
	25
```
Donc voilà comment ça se combinent en fait ensemble, le IF. On met qu'un seul IF au départ, il y en a toujours qu'un seul. Les ELSE IF, on peut en avoir plein d'accord. Moi j'en ai mis qu'un seul mais on peut très bien en avoir plein d'accord. On peut faire ça.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 25;
		
		if(value < 0)
			System.out.println("value < 0");
		else if(value > 100)
			System.out.println("value > 100");
		else if(value > 1000)
			System.out.println("value > 1000");
		else
			System.out.println(value);
	}
}
```
Les ELSE IF, vous pouvez absolument en mettre autant que vous voulez dans vos conditions il n'y a pas de problème et à la fin on a un seul ELSE, d'accord.

IF, ça il y en a qu'un seul. ELSE, ça y'en a qu'un seul et le ELSE IF ont peut en avoir un ou plusieurs en fonction ou pas du tout bien évidemment c'est pas obligatoire.

Donc dans ce cas là, je fais ça (javac App.java) et je fais ça (java App) et là on obtient la valeur 25 parce que ce n'est pas du coup plus petit que 0 et ce n'est pas plus grand que 100, d'accord donc pour voir ce genre de choses-là.
```powershell
	>javac App.java
	>java App
	25
```
Si jamais, on mettait du coup une valeur plus grand que 100 genre 105 et bien ça va rentrer dans le ELSE IF.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 105;
		
		if(value < 0)
			System.out.println("value < 0");
		else if(value > 100)
			System.out.println("value > 100");
		else
			System.out.println(value);
	}
}
```
Et vous pouvez comme ça gérer les différentes conditions donc le IF, le ELSE IS et le ELSE, vous avez 3 mots clés à connaître pour faire vos structures conditionnelles et qui peuvent se faire. On peut bien évidemment puisque quand vous rentrez à l'intérieur, c'est comme si on faisait ça... si on veut noter avec les accolades pour être sûr. Je vais reprendre cette notation pour vous.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = 105;
		
		if(value < 0)
		{
			System.out.println("value < 0");
		}
		else if(value > 100)
		{
			System.out.println("value > 100");
		}
		else
		{
			System.out.println(value);
		}
	}
}
```

Avec les accolades ça fait ça donc le fait qu'il y ait qu'une instruction, ici, je peux les enlever comme je vous ai dit, elles sont optionnelles quand on n'a qu'une seule instruction et voilà en gros comment se compose la structure.

On peut bien évidemment parce que ici, c'est un peu voyez comme une classe si vous regardez ici les classes méthode on retrouve les mêmes caractères. On peut bien évidemment refaire des IF à l'intérieur. Là vous êtes dans une autre partie de votre code donc il n'y a absolument aucun problème de faire par exemple voilà comme on sait qu'à cet endroit là de notre code, value est forcément inférieur à 0 puisque pour qu'on arrive ici, il faut qu'il soit inférieur 0.
```java
		//...
		if(value < 0)
		{
			if(value
			System.out.println("value < 0");
		}
```
On peut vérifier du coup une valeur qui serait inférieur à 0 du gene -6 et dans ce cas-là ben si ce serait -6, du genre on va faire ça donc si c'est inférieur à 0, on fait ça et si c'est du coup égal à -6, on dira ce genre de chose, d'accord. je peux vous montrer si je met value à -6.
```java
public class App
{
	public static void main(String[] args)
	{
		int value = -6;
		
		if(value < 0)
		{
			System.out.println("value < 0");
			
			if(value == -6)
				System.out.println("value = -6");
		}
		else if(value > 100)
		{
			System.out.println("value > 100");
		}
		else
		{
			System.out.println(value);
		}
	}
}
```
```powershell
	>javac App.java
	>java App
	value < 0
	value = -6
```
Voilà, première fois donc je rappelle on a fait le premier IF, est-ce que value est inférieur à 0 ? oui donc on arrive ici, on affiche cette instruction là `System.out.println("value < 0")`, c'est bien le cas et ensuite voyez, on a un autre IF est-ce que value est égal à -6 ? oui c'est le cas donc on entre dans le `IF System.out.println("value = -6");`

Et du coup il affiche -6. 

Cette partie là est ignorée parce que ce n'est pas supérieur à 100.
```java
		else if(value > 100)
		{
			System.out.println("value > 100");
		}
```
Et cette partie là est ignorée puisqu'on est entré dans le IF.
```java
		else
		{
			System.out.println(value);
		}
```
... au moins une des conditions avant donc si on rentre dans un IF ou un ELSE IF, on ne fera jamais le ELSE donc voilà comment ça se déroule en fait le programme donc très simple hein c'est des choses vraiment très simple. C'est vraiment pas compliqué et si vous comprenez ce système de structures conditionnelles en Java, c'est exactement le même en C, en C++, en PHP, en javascript dans pratiquement tous les langages un petit peu de ce genre. C'est exactement les mêmes mots d'accord, c'est toujours des IF, des ELSE IF ou éventuellement du ELIF ou autre, par exemple en python, on a ELIF à la place donc ça dépend après mais bon c'est le même fonctionnement, c'est toujours toujours le même principe. 

Les opérateurs de comparaison sont rarement différents à quelques exceptions mais sinon on retrouve un peu toujours les mêmes aussi donc le fait d'apprendre les structures conditionnelles dans un langage de programmation, ça vous laissera en réalité apprendre dans plein d'autre donc vous allez gagner énormément de temps si plus tard vous prévoyez d'apprendre d'autres langages de programmation ... Eh bien vous aurez appris beaucoup beaucoup de choses rapidement via un seul langage déjà.

Donc voilà pour cette syntaxe et on va passer sur une dernière pour finir cette vidéo, une dernière structure conditionnelle qui est bien pratique aussi.

Quand on commence à avoir plusieurs IF, et plusieurs ELSE IF et cetera. Moi je dirait quand par exemple vous commencez à en avoir 5, voilà au delà de 5, on peut préférer l'usage d'un switch donc si vous n'en avez pas forcément autant, vous pouvez très bien écrire ça comme ça, ce sera mieux mais quand on commence à en avoir beaucoup ou alors pour des questions de lisibilité du code on préférera utiliser un switch et l'avantage du switch, alors là c'est un avantage en Java, ce n'est pas forcément le cadre d'autres langages notamment le C, c'est que vous allez pouvoir faire le switch et le tester sur des valeurs également littérale.

On n'est pas obligé de tester seulement des valeurs chiffrées, des nombres, on peut également vérifier du texte et ça c'est plutôt pas mal. 

Par exemple alors ici on va faire ça.
```java
public class App
{
	public static void main(String[] args)
	{
		int option = 1;
	}
}
```
... int option et on va mettre 1. Ici on va tester donc un switch donc vous utilisez le mot clé switch sur la variable sur laquelle vous allez faire votre test donc option. On ouvre des accolades donc ça c'est obligatoire par contre et ici on va tester plusieurs cas possible avec le mot-clé case. Donc là c'est dans le cas on l'on va entrer dans ce case là si il est égal par exemple à 1, dans le cas où ça vaut 1 donc en fait qu'est-ce que ça va faire ça comme test ? cette ligne ça revient à dire `if option == 1` car vous voyez on teste, on fait un switch sur option d'accord donc cette variable (option) et en mettant 1 après le case, et bien on fait cette vérification là `if option == 1`. Est-ce que option est égal égal à 1, d'accord ? et si c'est le cas évidemment on va rentrer ... moi je le note comme ça après vous noté comme vous voulez. Moi je note ça parce que je préfère au niveau de la lisibilité. 
```java
public class App
{
	public static void main(String[] args)
	{
		int option = 1;
		
		switch(option)
		{
			case 1:
				/* if(option == 1) */

		}
	}
}
```
et vous faites ce que vous voulez faire donc pareil vous pouvez remettre d'autres IF, vous pouvez appeler des méthodes, vous pouvez faire ce que vous voulez, d'accord.
```java
public class App
{
	public static void main(String[] args)
	{
		int option = 1;
		
		switch(option)
		{
			case 1:
				/* if(option == 1) */
				System.out.println(value);
		}
	}
}
```
C'est une autre partie du programme donc vous pouvez faire tout et n'importe où comme si vous étiez à cet endroit là de votre code. Il y a aucun problème et là, on va mettre "option = 1" tout simplement.
```java
public class App
{
	public static void main(String[] args)
	{
		int option = 1;
		//							<--
		switch(option)
		{
			case 1:
				/* if(option == 1) */
				System.out.println("option = 1");
		}
	}
}
```
Et à la fin comme je veux sortir du switch parce que sinon il risquerait de tester tous les autres cas possible, je vais utiliser un autre mot clé qui s'appelle break. Vous mettez un `break`, un `;` et comme ça voilà.
```java
public class App
{
	public static void main(String[] args)
	{
		int option = 1;
		//							<--
		switch(option)
		{
			case 1:
				/* if(option == 1) */
				System.out.println("option = 1");
				break;
		}
	}
}
```
Ca veut dire bon bah dans le cas où ici option est égal à 1, tu fais ce qui est à l'intérieur `System.out.println("option = 1");` et à la fin avec le mot-clé `break`, tu sors du switch donc ça veut dire que là il va passer après l'accolade fermante ici du switch, d'accord. 

On sort de toute structure pour pas continuer à tester d'autres choses et on n'oublie pas le fameux cas du ELSE, d'accord donc ça voyez c'est des IF. Par exemple si on fait case 2 et bien ce sera un autre IF ou ELSE IF peu importe et dans le cas par défaut donc le fameux sinon le ELSE et bien on va utiliser le mot default. 
```java
public class App
{
	public static void main(String[] args)
	{
		int option = 1;
		//							<--
		switch(option)
		{
			case 1:
				/* if(option == 1) */
				System.out.println("option = 1");
				break;
			case 2
			default
		}
	}
}
```
Donc on dit dans le cas par défaut c'est-à-dire dans tous les case ici ne sont pas validé, bien sûr vous quitter directement si vous avez rien à faire, d'accord, soit vous mettez autre chose.
```java
public class App
{
	public static void main(String[] args)
	{
		int option = 1;

		switch(option)
		{
			case 1:
				/* if(option == 1) */
				System.out.println("option = 1");
				break;
			default:
				System.out.println("option != 1");
				break;
		}
	}
}
```
... donc là, je n'ai qu'un seul test du coup bah j'ai pas grand chose à tester. Mon code est vraiment très petit on ne ferait pas un switch pour si peu de ... pour un seul cas à traiter mais sachez que ça fonctionne, d'accord.
```powershell
	>javac App.java
	>java App
	option = 1
```
Option est égal à 1 donc pas de problème, si je change, par exemple je met 100 comme ça ne rentre plus dans le case, ça va aller au default. Alors je fais ça et voilà on arrive au default.
```java
public class App
{
	public static void main(String[] args)
	{
		int option = 100;

		switch(option)
		{
			case 1:
				/* if(option == 1) */
				System.out.println("option = 1");
				break;
			default:
				System.out.println("option != 1");
				break;
		}
	}
}
```
```powershell
	>javac App.java
	>java App
	option != 1
```
Donc voilà comment ça fonctionne et gros avantage même si bon on n'a pas encore vu les chaînes de caractères c'est qu'on peut tester ici du texte.

Voilà chose qu'on ne peut pas faire par exemple au langage C pour ceux qui ont déjà programmé dans ce langage.

Vous pouvez par exemple avoir ici un String choice, d'accord. et puis là on peut très bien avoir un mot genre yes, y pour yes n pour no et dans ce cas-là on peut très bien tester ça, voilà. Et faire un autre case si on avait autre chose.
```java
public class App
{
	public static void main(String[] args)
	{
		String choice = "y";

		switch(choice)
		{
			case "y":
				System.out.println("OUI");
				break;
			case "n":
				System.out.println("NON");
				break;
			default:
				System.out.println("Ni oui ni non");
				break;
		}
	}
}
```
Donc là (default), ce serrait "Ni oui ni non". Donc là (case "n"), c'est "NON" et ici (case "y") ce serait "OUI". Donc ça ça veut dire quoi ? ça veut dire est-ce que choice, en fait hein même si vous verrez que les vérifications sont un peu bizarre / if(choice == "y") / vous ça.
Là c'est est-ce que choice est égal à "n" / if(choice == "n") / et ici (default) c'est le cas en fait,  cas par défaut, donc c'est le ELSE en fait donc c'est à dire choice est différent de "y" et choice est différent de "n", en gros c'est ça / if(choice != "y" && choice != "n") /. 

```java
public class App
{
	public static void main(String[] args)
	{
		String choice = "y";

		switch(choice)
		{
			case "y":
				/* if(choice == "y") */
				System.out.println("OUI");
				break;
			case "n":
				/* if(choice == "n") */
				System.out.println("NON");
				break;
			default:
				/* if(choice != "y" && choice != "n") */
				System.out.println("Ni oui ni non");
				break;
		}
	}
}
```
C'est à dire que la c'est non égal à "y" `choice != "y"` et ni égale à "n" `choice != "n"` donc c'est bien différent pour les 2.

Et voilà et du coup bah je vais re tester pour finir.
```powershell
	>javac App.java
	>java App
	OUI
```
Alors voilà comme on "y", ça fait bien oui si je remplace par "n", ça va aller dans le case du "n" donc ça va afficher non et si je mets n'importe quoi d'autre, évidemment ça ne passera pas, ça va aller dans le default qui correspond au ELSE "Ni oui ni non". 

Voilà comment ça se passe au niveau des structures conditionnelles donc grosso modo pour résumer vous avez le IF, le ELSE IF et le ELSE donc 3 mots clés à connaître et bien assimilé que vous allez retrouver dans pleins de langages même si dans certain cas le ELSE IF sera un ELIF d'accord donc il sera écrit différemment mais c'est exactement le même fonctionnement peu importe et vous avez le switch pareil qu'on retrouve dans pas mal de langage, pas tous mais on retrouve dans une majorité quand même qui est bien pratique quand on commence à avoir beaucoup de conditions vous voyez que là on peut du coup euh on va dire organiser le code différemment et c'est des fois plus visible comme ça ; de procèder de cette manière plutôt d'avoir plein de IF inbriqués qui peut du coup rendent la lecture beaucoup plus difficile au niveau de votre code surtout s'ils vont revenir dessus après plusieurs mois sans avoir été voilà re lire le code que vous avez fait.

Voilà pour ça j'espère en tout cas que cette vidéo vous a plu.

Pour la prochaine séance nous abordons les boucles qui sont un autre type de structure bien à connaître d'accord qui permet de répéter des instructions ou parfaire des des parcours plus tard comme on le verra dans des systèmes qui permettent de stocker plein d'informations et puis après très vite on passera sur la partie la plus essentielle de Java.

Parce que Java, je le rappelle est un langage objet et donc ici nous avions notre code dans une classe et bien on verra ensemble comment construire une classe, voilà comment est fabriquée une classe ? comment on fait des méthodes et comment on les utilise ? et on rentrera rentre un peu plus dans le détail sur tout ce paradigme objet qui est très très important en fait en informatique et notamment ici pour le langage Java qui est un langage qui utilise justement le paradigme objet.

Je vous dis à bientôt pour la suite de cette formation, j'espère que ça vous a plu puis il y a des petits soucis n'hésitez pas dans les commentaires de la vidéo et j'y répondrai avec plaisir. Si jamais vous bloqué sur quelques petites syntaxe ou des choses que j'ai abordé ici avec vous. 

ciao tout le monde pour la prochaine vidéo