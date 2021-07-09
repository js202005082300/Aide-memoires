# [13. Chaînes de caractères (1/2)](https://www.youtube.com/watch?v=wvQQ5263pvI)

Bonjour à tous on se retrouve pour la séance 13 avec une notion très très importante en Java et exceptionnellement, je vais séparer en 2 parties alors 2 vidéos parce qu'on va avoir beaucoup beaucoup de choses à aborder et on va parler des chaînes de caractères et notamment pour commencer, en tout cas sur cette partie de la classe String.

Donc on va revenir sur un code très simple c'est-à-dire juste notre méthode main ici.
```java
public class App
{
	public static void main(String []args)
	{
	}
}
```
Et où on avait vu donc avec les types précédents, si vous souvenez un petit peu des types de variables qu'on avait vu sur la vidéo dédiée, on avait abordé pas mal de types primitifs : le int, le float, double et cetera, byte qui permet justement de créer des types de données bien précis.

Et très rapidement, j'avais pu le l'utiliser très rapidement mais sans vous donner de détail puisque je vous avez dit qu'on ferait une vidéo spécialement là dessus.

Nous avons un type un peu particulier qui représente la chaîne de caractères donc je peux très bien par exemple faire ce genre de chose.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		String s = "Hello";
		System.out.println(s);
	}
}
```
Et à partir de là avec un simple petit affichage ici, je peux afficher ma chaîne de caractère.

On va compiler tout ça et voilà d'accord, tout simplement.
```powershell
	>javac App.java
	>java App
	Hello
```
D'ailleurs pour les plus curieux d'entre, vous aurez certainement remarqué que notre méthode main contenait, un petit peu, ce type là "String []args" justement qui est un type particulier.

Alors contrairement au type primitif comme int, float et cetera, vous avez remarqué également que ce type là commence par une majuscule puisqu'il y a en fait derrière, ici, une classe d'accord.

Alors pour les types primitifs, il y a également des classes qu'on peut retrouver également, qui sont objet pour le coup mais on n'en parle pas, on est là pour les chaînes de caractères.
```java
String s = "Hello";
```
Donc au niveau de ce type ici quand on crée en fait ceci, derrière on ne fait pas qu'affecter une valeur comme ça à une variable de type String qui serait du coup un type seulement primitif mais on va en fait instancier, d'accord, un objet de classe String et on va lui donner directement cette valeur `"Hello"`.

Alors si ce type de syntaxe est possible, c'est simplement parce qu'on avait besoin de créer très très souvent des chaînes de caractères en Java et du coup on a eu cette syntaxe raccourci, qui est évidemment une synthèse habituel comme on retrouve avec les types primitifs mais en réalité ça revient tout à fait, vous pouvez le faire de cette manière, à faire ce genre de chose.
```java
String s = "Hello";//String s = new String
```
On fait la déclaration de la variable `String s` est ici `= new String` au niveau de l'affectation, ont fait une new String donc une instanciation de la classe String et on lui passe la valeur en paramètre, voilà.
```java
String s = "Hello";//String s = new String("Hello");
```
Donc vous pouvez très bien faire cette chose là, cette opération là, c'est exactement pareil que ça, d'accord.

C'est simplement que là `new String("Hello");`, on voit que l'instanciation est explicite.

Là `= "Hello";`, on a directement cette affectation mais qui fonctionne puisque, voilà, on a une instanciation qui est fait de manière impliciste.

Et à partir de là, nous obtenons notre objet de classe String, dans notre variable selon le nom qu'on lui a donné. Et on peut bien évidemment la manipuler.

Donc ça c'est du coup très très important, il faut bien le comprendre.

Alors cette classe String au niveau de Java parce qu'il y a beaucoup de points, je pense que c'est nécessaire, enfin moi je vais prendre la peine, c'est pour ça qu'il y a 2 parties, juste pour parler des chaînes de caractères puisque je vais bien prendre le temps de vous expliquer, un petit peu, le fonctionnement de tout ça parce que j'estime qu'il est nécessaire de comprendre comment ça fonctionne derrière pour les utiliser comme il faut, pour avoir un bon usage et comprendre un petit peu leur fonctionnement plutôt que de répéter bêtement les choses et faire du copier-coller de code sans comprendre la signification.

ce qu'il faut retenir de très important, c'est qu'elle est immuable. immuable, ça veut tout simplement dire que le contenu est non modifiable, c'est ça qu'il faut retenir. 

Alors cette classe String, 
```java
/*
	String : immuable (contenu non modifiable)
*/
```
Donc on va toujours toujours travailler avec des données dont le contenu ne peut pas être modifié.

Première chose qui viendrait à l'esprit en faisant ce genre de chose, en gardant cette idée là.
```java
/*
	String : immuable (contenu non modifiable)
*/

public class App
{
	public static void main(String []args)
	{
		String s = "Hello";
		System.out.println(s);
	}
}
```

Si c'est immuable, du coup, la valeur `"Hello"` par exemple est constante, d'accord, ça veut dire qu'on ne peut pas là changer.

Pourtant si je m'amuse à faire ce genre de chose ok.

+ App.java
```java
/*
	String : immuable (contenu non modifiable)
*/

public class App
{
	public static void main(String []args)
	{
		String s = "Hello";
		System.out.println(s);
		s = "Bonjour";
		System.out.println(s);
	}
}
```
Je modifie ici `s = "Bonjour";`, je fait une nouvelle affectation et je réaffiche du coup le résultat.
```powershell
	>javac App.java
	>java App
	Hello
	Bonjour
```
Et là, on se rend bien compte que on a effectivement la valeur qui a changé, et là où il y a éffectivement une distinction, et là où c'est important de comprendre comment ça marche derrière parce qu'on ne le voit évidemment pas ici visuellement. 

Là on a vraiment l'impression que le contenu a été modifié mais en réalité pas du tout. 

Ici au moment où il fait cette nouvelle affectation en réalité 
```java
	s = "Bonjour";
```
...on va créer une nouvelle chaîne de caractères donc une nouvelle chaîne qui, en fait, est une donnée de classe String.

On va lui affecter cette valeur là `"Bonjour"`, d'accord.

Et l'ancienne chaîne, en fait, sera détruite, d'accord.

Elle va être libéré de la mémoire. 

La machine virtuelle va se charger évidemment de tout ce qui est gestion, allocation, libération des ressources en mémoire.

Donc on a véritablement une nouvelle chaîne de caractères qui est faite et ça c'est très très très important parce qu'il y a beaucoup de gens qui ne comprennent pas ou qui ne savent pas ce petit détail là qui est pourtant très essentiel pour savoir utiliser cette fameuse classe String, voilà.

Donc, ça n'oubliez pas, à chaque fois, ce petit point très important qui fait qu'on a, à chaque fois, des nouvelles chaînes dès qu'on a en fait ...dès qu'il est question de modifier, en réalité, le contenu. 

On ne va jamais le modifier comme on ne peut pas le modifier parce que c'est une classe immuable.

Et bien on va créer une nouvelle chaîne à chaque fois ou éventuellement faire une copie mais il y aura toujours une création de nouvelle chaîne.

Alors pourquoi je vous explique ça ? tout simplement parce que ça va sous-entendre du coup... ça va soulever quelques questions au niveau des performances, d'accord, du programme.

On se doute bien que si on s'amuse, par exemple, à modifiée 1000 fois un objet de classe String en Java, on va du coup créer 1000 chaînes de caractères donc en termes d'optimisation mémoire c'est pas forcément le plus idéal.

Donc il faut savoir comment ça fonctionne et comme ça on sait comment l'utiliser.

Donc ça c'est le point que je voulais aborder avec vous.

Alors cette chaîne de caractères, on va pouvoir la manipuler de plusieurs manières, vous savez que par exemple quand on fait un entier tout simplement, on peut utiliser certains opérateurs comme l'opérateur plus. 
```java
/*
	String : immuable (contenu non modifiable)
	+
*/
```
Je prend cette exemple là parce que c'est celui qui va être le plus parlant, qui permet notamment de faire des additions.

On a pas mal d'opérateurs, comme ça, arithmétique qui nous permettent de faire des additions, des soustractions, des multiplications, des divisions puis on a même le modulo qu'on avait abordé précédemment.

Pour les chaînes de caractères puisque nous avons un type particulier, il a été défini, quand c'est nécessaire bien évidemment, d'autres comportements avec certains opérateurs et le comportement qui a été redéfini, du coup, pour l'opérateur plus avec les chaînes de caractères parce qu'on trouverait bizarre de dire : "tu fais l'addition de chaînes de caractère"... ça veut rien dire, on ne va pas faire un calcul sur quelque chose qui n'est pas un nombre, ça n'a absolument aucun sens.

On a réutilisé en fait cet opérateur plus pour effectuer des concaténations.

Donc tout simplement, faisons par exemple ce genre de choses.
On va refaire une nouvelle chaîne ici, comme ceci String `s2 = "tout le monde";`

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		String s = "Bonjour";
		String s2 = "tout le monde";
	}
}
```
Comme ceci, je peux sans problème concaténer des valeurs différentes et là je vais faire ça 
```java
	System.out.println(s + //...
```
J'utilise donc le fameux opérateur plus, d'accord je vais mettre ici un espace, d'accord
```java
	System.out.println(s + " " //...
```
Donc je vais mettre ici un espace, une valeur en dur dans le code et on va concatener avec s2, voilà.

+ App.java

```java
/*
	String : immuable (contenu non modifiable)
*/

public class App
{
	public static void main(String []args)
	{
		String s = "Bonjour";
		String s2 = "tout le monde";
		System.out.println(s + " " + s2);
	}
}
```
```powershell
	>javac App.java
	>java App
	Bonjour tout le monde
```
En faisant une nouvelle compilation et une nouvelle exécution, on a la totalité, donc les 2 chaînes qui ont été concatener et même l'espace, l'espace entre `"Bonjour"` et `"tout le monde"`.

Donc on a véritablement cette chose qui est faîte, deux chaînes de caractères, on concatène ici avec une valeur en dur `" "` (espace) dans le printeln(). 

Donc voilà une possibilité, voilà en tout cas un usage de cet opérateur plus pour le coup. 

Alors cet opérateur plus, c'est ça, de toute façon, il va falloir vous habituer sur cette formation, autant c'est pas forcément le cas sur d'autres, mais on dit que Java est un langage très verbeux, c'est-à-dire et bah en fait Java, tout est explicité au niveau de la syntaxe, au niveau de tout ce qu'on marque en fait par rapport à comment on manipule le langage.

Et du coup, moi je vais pas vous faire utiliser, en fait, des classes, des objets ou des méthodes sans vous expliquer comment elles fonctionnent et comment ça marche derrière, en fait, derrière en interne puisqu'encore une fois, pour des questions en fait, de bonne utilisation de ces différents classes et plus tard de performance quand vous aurez acquis une certaine expérience et une certaine pratique dans le langage, vous poserez des questions de ... je ne veux pas obtenir un programme qui prenne peut-être 10 fois plus de temps pour réaliser la même opération alors qu'à côté je pourrais faire 10 fois moins de temps et avoir quelque chose de plus optimisé. 

Et on sait que Java très vite, on peut optenir des programmes très lourd et très lent, si justement on utilise même les choses parce qu'il y a énormément énormément de classe et malheureusement bah l'inconvénient de ça, c'est que comme il y en a tellement tellement, on ne sait pas toujours quand utiliser telle ou telle classe et après on se mélange un peu et on a des très mauvais usage qui sont faits par la suite.

Donc il faut prendre l'habitude, c'est pour ça que les vidéos sont pas mal longue, pas mal détaillé en Java parce que je vais vraiment vous expliqué tout dans le détail et y compris ce qui se passe un peu en interne qu'on ne voit pas forcément visuellement quand on exécute nos programmes.

Alors au niveau de String comme j'ai expliqué ici.
```java
public class App
{
	public static void main(String []args)
	{
		String s = "Bonjour";
		String s2 = "tout le monde";
		System.out.println(s + " " + s2);
	}
}
```
On a donc cette opération `s + " " + s2` qui est un peu lourde, en fait, en termes d'exécution c'est-à-dire qu'à l'exécution ici, on va voir des concaténations qui ne sont pas forcément pratique et qui, si on doit s'amuser notamment à concatener beaucoup beaucoup de chaînes de caractères, c'est quelque chose qui serait vraiment très lourd.

Alors heureusement on a la machine virtuelle de Java qui quand, en tout cas quand le compilateur va compiler en byte code le programme, va faire certaines optimisations.

En gros, il va modifier certaines parties du code pour dire : "bah toi, t'as utilisé par exemple tel classe, bah moi en fait j'ai autre chose de mieux pour optimiser le code".

Donc malgré tout, on peut quand même grâce à la compilation obtenir un code un peu plus optimisé.

Après évidemment il ne faut pas oublier que c'est quelque chose qui est automatique qui s'occupe de ça et l'idéal bien sûr c'est de maîtriser au départ le code qu'on fait et les objets également ... en tout cas, les classes que l'on utilise pour obtenir bien sûr quelque chose qui soit le plus efficace possible.

Donc ça on verra dans la 2e partie, on verra qu'en réalité bah le compilateur Java peut effectuer des remplacements par rapport à ça (+) parce que en termes de coût, en termes de consommation de ressources et cetera et bien cette concaténation par cet opérateur, c'est une opération qui est très lourde.

Mais nous comme on n'avait pas encore ... Bon je garde ça pour la 2e partie parce que ça va faire appel à d'autres classes que la classe String, on va utiliser une des méthodes parce que comme je l'ai dit, String est une classe donc évidemment, comme on a ici des objets.
```txt
	s et s2
```
D'accord, on a des classes qui sont instanciés sous forme, pour obtenir des objets, on va pouvoir utiliser tout un tas de méthodes.

Et la première méthode tout simplement, c'est de faire... sur cette cette chaîne là, j'utilise une méthode que je vais appeler concat().

D'accord donc concat(), c'est la méthode bien sûr, telle qu'elle s'appelle, et je vais faire s2.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		String s = "Bonjour";
		String s2 = "tout le monde";
		System.out.println(s2);
	}
}
```
D'ailleurs je vais peut-être faire carrément ... peut-être même mettre l'espace aussi parce que ça évietra d'avoir quelque chose comme ça.

+ App.java

```java
public class App
{
	public static void main(String []args)
	{
		String s = "Bonjour";
		String s2 = "tout le monde";
		System.out.println(s.concat(" ").concat(s2));
	}
}
```
```powershell
	>javac App.java
	>java App
	Bonjour tout le monde
```
voilà donc on revient au même résultat que précédemment sauf qu'ici on n'utilise pas le fameux opérateur plus d'accord mais on utilise cette méthode là "concat()".

Comme vous le voyez, je tenais à vous le montrer, on peut parfaitement cumuler les choses ici, d'accord, puisque on traite en fait le même objet d'accord donc une fois qu'on utilise concat() sur s, on continue en fait de garder cette fameuse instance s et du coup, à la volée d'accord dans la dans la foulée, on peut directement utiliser une autre méthode, il n'y a pas de problème.
```java
	s.concat(" ").concat(s2)
```
Donc ici on concatène en fait à s, un espace blanc et la chaîne s2 et on obtient ce genre de choses.
```txt
	Bonjour tout le monde
```
Donc si vous voulez comme ça faire des concaténations beaucoup plus longue, il mieux, en tout cas pour la classe String sans parler d'autres classes qu'on va voir dans la 2nde partie du cours, utiliser la méthode concat() à la place de l'opérateur plus.

D'accord donc ça c'est à savoir. Je vais toujours noter ici.  On va faire ça. Je vais juste mettre le nom des méthodes voilà.
```java
	/*
		String : immuable (contenu non modifiable)
			> concat() -> plus rapide que "+"
	*/
```
Et ça, concat(), est plus rapide que l'opérateur plus en fait par rapport à la concaténation qui est à connaître.

On va voir pas mal d'autres méthodes aussi, je ne vais évidemment pas toutes les énumérer, ça n'aurait aucun sens. Le but n'est pas de vous énumérer tout ce qui existe en Java, il y a tellement tellement de choses.

Le but est de vous présenter, en tout cas, ce qui est essentiel, ce qui me vient en tête par rapport aux choses qu'on est souvent amené à manipuler et à faire avec des chaînes de caractères.

La première chose qui me vient en tête et qui est logique, c'est tout simplement la taille d'une chaîne c'est-à-dire le nombre de caractère qu'elle possède et pour ça nous avons tout simplement la méthode length() :
```java
	/*
		String : immuable (contenu non modifiable)
			> concat() -> plus rapide que "+"
			> length()
	*/
```
J'enleve ça `s2` et je vais juste faire ici `println(s.length())`.

+ App.java
```java
/*
	String : immuable (contenu non modifiable)
		> concat() -> plus rapide que "+"
		> length()
*/
public class App
{
	public static void main(String []args)
	{
		String s = "Bonjour";
		System.out.println(s.length());
	}
}
```
Alors, il ne s'agit pas d'une instruction comme pour les tableaux d'accord. Il n'y aurait pas de parenthèses, on a vraiment bien une méthode donc on ne peut pas les parenthèses par rapport à ça, très important.
```powershell
	>javac App.java
	>java App
	7
```
Et ici ça me retourne tout simplement le chiffre 7. 7 c'est le nombre de caractères que j'ai dans cette chaîne s.

voilà donc length(), c'est à connaître et c'est important, il faut bien retenir quand même cette méthode là qui est une des méthodes que vous avez le plus utilisé.

Maintenant comme tout à l'heure, je parlais justement du fait que String était une classe immuable, on va aborder quelques méthodes qui justement vont avoir ...vous serez amené, à la base, à modifier le contenu de la chaîne et qui vont du coup avoir ce principe de créer une nouvelle chaîne de caractères parce que le contenu doit être modifié.

Donc on ne peut pas le faire puisque String est immuable par défaut. 

Eh bien, on va du coup créer une nouvelle chaîne à chaque fois pour pouvoir opérer les changements qu'on a voulu.

Alors moi ce qui me vient en tête, par exemple, c'est ce genre de méthode toUpperCase(), toLowerCase() qui permettent, ça on a souvent besoin de le faire aussi, de tout passer en majuscule, tout passer en minuscule ou ce genre de chose.

+ App.java
```java
/*
	String : immuable (contenu non modifiable)
		> concat() -> plus rapide que "+"
		> length()
		> toUpperCase(), toLowerCase()
*/
public class App
{
	public static void main(String []args)
	{
		String s = "Bonjour";
		System.out.println(s.toUpperCase());
	}
}
```
Donc par exemple en faisant ça. Je vais assez vite parce qu'évidemment c'est des choses très simples voilà. C'est tout simplement du remplacement de ce que je fais dans mon println() et ça passe tout en majuscules. 
```powershell
	>javac App.java
	>java App
	BONJOUR
```
Et en réalité, je ne devrais pas dire ça. C'est pas que ça passe toute ma chaîne en majuscules, non. C'est qu'encore une fois, ça crée une nouvelle instance en fait de String et celle-ci... il prend, en fait, de cette valeur là et il en fait quelque chose en majuscules.

Donc encore une fois, en réalité, là au cours de l'exécution du programme, il y aura eu 2 chaînes de caractères même si pourtant quand on regarde dans mon code, je n'ai qu'une seule qui a été déclaré et du coup qui a été instancié.

Donc très important, encore une fois, n'oubliez pas la classe String immuable.

Donc à partir de moment, où on a le contenu qui va être modifié, on a en réalité la création d'une nouvelle chaîne de caractères. Ca c'est très important et c'est vraiment ... bah il faut le retenir en fait. C'est une notion très essentiel là-dessus.

On a d'autres également, si par exemple vous avez plein d'espace éventuellement dans une chaîne, vous pouvez utiliser la petite méthode trim() qui va virer tous ces fameuses espaces, aussi bien avnt et après. 

Donc en gros, si je le fais pas. On peut montrer ça ici. Si je fais juste ça. 

+ App.java
```java
/*
	String : immuable (contenu non modifiable)
		> concat() -> plus rapide que "+"
		> length()
		> toUpperCase(), toLowerCase(), trim()
*/
public class App
{
	public static void main(String []args)
	{
		String s = "   Bonjour          ";
		System.out.println(s);
	}
}
```
```powershell
	>javac App.java
	>java App
	   Bonjour
```
Tous les espaces, on ne voit pas ceux d'après mais évidemment tous les espaces sont conservés et bien sûr, si je fais juste l'usage de cette petite méthode trim(), on aura tout les espaces qui sont retirés.

+ App.java
```java
/*
	String : immuable (contenu non modifiable)
		> concat() -> plus rapide que "+"
		> length()
		> toUpperCase(), toLowerCase(), trim()
*/

//public class App
//{
//	public static void main(String []args)
//	{
//		String s = "   Bonjour          ";
//		System.out.println(s.trim());
//	}
//}
```
```powershell
	>javac App.java
	>java App
	Bonjour
```
Tout les espaces qui sont retirés donc c'est le genre de méthode qui est très pratique et pareil, comme il s'agit d'une nouvelle chaîne parce ce que le contenu a changé.

Création d'un nouvelle objet de classe trim(), toujours pareil.

Voilà, c'est exactement toujours le même principe.

Voilà on peut également faire du remplacement donc c'est le replace() donc en gros ça prend la chaîne que vous voulez de départ pas et que vous remplacer par autre chose, d'accord.

Donc ça, c'est à vous de voir, je ne sais pas, par exemple, on peut faire. On peut mettre ce genre de chose `"baba"` par exemple et puis en fait replace() de ça `"a"` par `"o"`.

+ App.java
```java
/*
	String : immuable (contenu non modifiable)
		> concat() -> plus rapide que "+"
		> length()
		> toUpperCase(), toLowerCase(), trim(), replace(<old>,<new>)
*/

//public class App
//{
//	public static void main(String []args)
//	{
//		String s = "baba";
//		System.out.println(s.replace('a', 'o'));
//	}
//}
```
```powershell
	>javac App.java
	>java App
	bobo
```
Encore une fois, je ne vais pas tout vous montrer non plus mais c'est histoire de vous montrer rapidement, voilà, on remplace tout les a par des o.

Comme je sais que le remplacement dans une chaîne de caractère, c'est quelque chose qui revient très souvent aussi.

Au moins sachez qu'il y a des méthodes et il y en a plein d'autres.

Encore une fois en Java comme il y a énormément de choses qui existent, avant de créer une méthode d'accord, vérifiez dans la documentation de Java si ça n'existe pas déjà. Il y a de fortes chances que l'opération que vous voulez faire, comme c'est quelque chose d'assez récurrent, ça existe déjà de manière officielle dans Java donc il suffit d'allé voir la documentation et vous trouverez la méthode qui va bien.

Et si vraiment ça n'existe pas, vous pourez la développer mais franchement dans quand même une grande majorité des cas, vous trouverez une fonction toute faite déjà dans la documentation pour réaliser l'opération que vous voulez.

Voilà donc ça, c'est un point quand même très important par rapport à ça.

Est-ce que je peux vous montrer d'autres petites méthodes ? Ah oui, il y en a une qui est très important... ça aussi ça j'y pense parce que c'est quelque chose, en fait, qui va permettre de pas vous mélanger avec les tableaux parce qu'il y a des langages de programmation, je pense notamment au langage c ou on sait très bien que une chaîne de caractères pour ceux qui ont déjà programmé ou qui programme sur ce langage. Vous savez qu'une chaîne de caractères, c'est un tableau de caractères, d'accord.

Du coup, quand on crée une chaîne de caractères, on pourrait très bien accéder à n'importe quel caractère de cette chaîne via son indice, par exemple, ici on pourrait dire bah `"s"` en fait. Si je dois accéder, par exemple, aux premier caractère et bien je serais tenté de faire ce genre de chose, d'accord.
```java
public class App
{
	public static void main(String []args)
	{
		String s = "baba";
		System.out.println(s[0]);
	}
}
```
En langage c, par exemple, on pourrait tout à fait accéder à un caractère d'une chaîne en faisant ce genre d'accès là.

Pourtant si j'essaie de le faire en Java.
```powershell
	>javac App.java
	App.java:502: error: array required, but String found
					System.out.println(s[0]);
										^
	1 error
```
Voilà comme ça, il y a une erreur, normal. On ne peut pas le faire tout simplement parce que c'est un tableau qui est requis et que là on a une chaîne de caractères qui a été trouvée.

Et heureusement, au niveau de Java, il y a vraiment voilà, tout a été pensé par rapport à ça, nous avons une méthode qui permet d'avoir un peu cet équivalent qui s'appelle charAt(). Je vais mettre ça comme ça `replace(<old>,<new>), chartAt(<index>)...`, c'est juste pour dire que ça prend des paramètres.

Donc au lieu de faire comme ça, entre crochets zéro [0], je fais simplement charAt(0).

+ App.java
```java
/*
	String : immuable (contenu non modifiable)
		> concat() -> plus rapide que "+"
		> length()
		> toUpperCase(), toLowerCase(), trim(), replace(<old>,<new>)
		> chartAt(<index>)
*/

public class App
{
	public static void main(String []args)
	{
		String s = "bonjour";
		System.out.println(s.charAt(0));
	}
}
```
```powershell
	>javac App.java
	>java App
	b
```
`s.charAt(0)` qui est donc bien en fait l'indice et encore une fois, ça commence à 0 comme très souvent informatique par rapport aux caractères. 

Le caractère 0 d'indice 0 est le premier, en fait, de la chaîne et là, pas de problème, c'est bien retourner, voilà.

Donc très important par rapport à ça, c'est les méthodes comme ça qui sont vraiment à connaître et il y en a encore une fois plein plein d'autre donc n'hésitez pas à les consulter la documentation concernant cette classe String parce qu'il y a vraiment plein plein de choses que vous pouvez voir.

Qu'est-ce que nous avons aussi ? qu'est-ce qu'il fait souvent ? ... on a vu bon après, il y a par exemple pour splitter mais c'est une autre classe, ça donc on en parle un peu dans la 2nde partie. Je ne pense pas que je vous montrerai la. On verra si je fais ça à la fin de la vidéo, peu importe.

Mais par contre, oui c'est les extractions, voilà. Extraction du genre récupérer une sous-chaîne dans une chaîne, ça c'est quelque chose qu'on fait pas mal aussi.

Et on va la voir tout simplement. Alors, je vais noté ici, substring(). Alors attention, c'est tout marqué en minuscules. Je le dis parce que dans certain langage, souvent ça "substring", c'est considéré comme 2 mots donc ça s'écrit plutôt comme ça "subString" donc là attention de pas vous faire avoir. Tout en minuscule sinon vous aurez des problèmes. Et là,en fait, on va simplement passer l'index d'accord, où l'on commence en fait, et puis le nombre, je vais mettre "nb".
```java
/*
	String : immuable (contenu non modifiable)
		> concat() -> plus rapide que "+"
		> length()
		> toUpperCase(), toLowerCase(), trim(), replace(<old>,<new>)
		> chartAt(<index>)
		> substring(<index>, <nb>)
*/
```
Donc par exemple si je veux récupérer `"bon"`, d'accord, je vais simplement faire `substring(0, 3)` donc si je me trompe parce que des fois sur certains langages substring() fonctionne différemment donc ça peut m'arriver de me mélanger quand on manipule pas mal de langage de programmation, ça arrive que des fois on se trompe un petit peu dans les paramètres mais logiquement pour Java c'était ça.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		String s = "bonjour";
		System.out.println(s.substring(0, 3));
	}
}
```
Elle prend à partir de cet indice là, le nombre de caractères qu'on veut récupérer donc normalement... 
```powershell
	>javac App.java
	>java App
	bon
```
Et voilà donc c'est bien ça, c'est bien 0 et 3.

Donc 0 bon c'est c'est l'indice où on commence, le premier caractère et on récupère au total 3 caractères.

Donc c'est bien les 3 premiers parce qu'on commence du début en mettant 0, voilà.

Donc pour faire une extraction de chaîne très pratique aussi. On s'en sert quand même pas mal, substring(), substr() dans certains autres langages de programmation. Bref c'est toujours le même principe et je pense que je vais m'arrêter là. 

Encore une fois, il y a plein d'autres méthodes mais je ne vais pas non plus toutes les faire, en tout cas les méthodes vraiment concernant les chaînes de caractères c'est-à-dire ce qui permet directement de faire ces choses là.

Maintenant, il a d'autres opérations qu'on n'a pas vu, très rapidement, et que vous serez aussi amené c'est-à-dire qu'on sait par exemple comparer, d'accord, vérifier des conditions sur des nombres mais comment on compare 2 chaînes de caractères ?

En gros, si j'ai ça.
```java
public class App
{
	public static void main(String []args)
	{
		String s = "Bonjour";
		String s2 = "Hello";
	}
}
```
Comment je peux vérifier ou non l'égalité de ces 2 chaînes ? Moi, je vais le faire d'ailleurs là dedans.


Parce qu'évidement lorsqu'on vérifie une égalité ou autre, ça retourne un booléen donc je ne vais pas m'embêter à faire un IF.

Vous pouvez faire un IF si vous voulez.

On pourrait être tenté du coup de faire ce genre de chose, de dire `s == s2`, d'accord.
```java
public class App
{
	public static void main(String []args)
	{
		String s = "Bonjour";
		String s2 = "Hello";
		System.out.println(s == s2);
	}
}
```
Le problème c'est qu'il faut faire attention avec les chaînes de caractères parce que l'on ne va pas s'occuper de leur valeur, on va s'occuper en fait de la donnée sur laquelle elle pointe, en fait d'accord.

Donc c'est... n'oubliez pas que ce sont des objets, donc vous n'allez pas forcément avoir le comportement, le résultat attendu.

Donc pour comparer, en réalité, des chaînes, on va utiliser certaines méthodes particulières. Alors, on n'a pas encore parlé d'héritage qui est une notion qu'on va voir sur la formation mais un tout petit peu plus tard mais en gros ce qu'il faut comprendre c'est que comme toutes ces classes String et cetera sont en fait des classes qui permettent d'avoir des objets, de manipuler des objets en Java, nous avons imaginé une super classe, d'accord, un  classe mère, qui s'appelle Object, il y en a même une où c'est Objects avec un s, qui propose plusieurs méthodes.

Et toutes les classes qui héritent en fait de cette super classe peuvent utiliser également ces méthodes, d'accord, elle les possède mais vous verez ce principe, ça s'appelle l'héritage et on en parlera un petit peu plus tard.

Donc en gros, on a pas mal de méthodes qu'utilisent tous les objets en Java et comme String est un type d'objet en Java, elle peut évidemment utiliser ce genre de méthode.
Donc on en a 2 d'accord qui sont à retenir. La première equals().
Il y a plein d'autres encore une fois, il n'y en a pas que 2 mais moi je vous en vous en donne 2 parce que c'est quand même pas mal de voir celle-ci.
```java
public class App
{
	public static void main(String []args)
	{
		String s = "Bonjour";
		String s2 = "Hello";
		System.out.println(s.equals(s2));
	}
}
```
equals() qui va tout simplement comparer les 2 chaînes. Est-ce qu'elles sont égales ou non ou vrai ou faux ?
Donc là, voyez, on met la chaîne, la première qu'on veut et on utilise dessus la méthode equals() et elle prend en paramètre l'autre chaîne.
```powershell
	>javac App.java
	>java App
	false
```
Et la simplement par cette comparaison (javac *.java > java App) ça retournera false ou true en fonction du résultat qui a été donné.
```java
//public class App
//{
//	public static void main(String []args)
//	{
//		String s = "Bonjour";
//		String s2 = "Bonjour";
//		System.out.println(s.equals(s2));
//	}
//}
```
On regarde ce que ça donne et donc sans surprise.
```powershell
	>javac App.java
	>java App
	true
```
Donc ça c'est un premier cas à connaître.

On a également une autre méthode qui s'appelle compareTo() et ça c'est un cas un peu particulier, très important.

Donc je vais noter ici, equals(), compareTo(). Ici, pareil, ça prend `<str>`.
```java
/*
	String : immuable (contenu non modifiable)
		> concat() -> plus rapide que "+"
		> length()
		> toUpperCase(), toLowerCase(), trim(), replace(<old>,<new>)
		> chartAt(<index>)
		> substring(<index>, <nb>)
		> equals(<str>), compareTo(<str>)
*/
```
Après bien évidemment comme d'habitude, vous pouvez mettre en pause la vidéo quand vous voulez, prendre des notes ou pas, noter sur un cahier, sur un ordinateur. Vous vous débrouiller, là-dessus, c'est vous qui gérer votre prise de note ou non en fonction de ce que vous avez besoin de retenir et cetera.

Aussi le fait de réécrire, ça vous permet de mieux assimiler et je vous le conseille quand même ça peut pas mal aider.

Voilà pour ça et du coup donc cette comparaison compareTo(), ça c'est pareil, si vous venez du langage C et bah c'est une méthode dont vous allez comprendre le fonctionnement donc je vous l'explique.

Qu'est-ce qu'il va se baser en fait par rapport à la ... comment dire ... c'est pas vraiment un lexique, on va dire que lexicalement parlant, en fait, on a un certain ordre au niveau des mots.

Et d'ailleurs, ça va peut-être être pratique si... voilà je démarre un navigateur, on va regarder ça. On va charger une table ascii. 

Voilà on va prendre n'importe quel truc. bah celui, le premier qui vient, peu importe.

[http://www.table-ascii.com/](http://www.table-ascii.com/)  

Je vais vous agrandir peut-être la plage parce que sinon pour vous ça va être un peu galère, voilà.

Et en gros donc la table ascii parce que c'est des fois un terme que j'emploi sur certaines vidéos et j'ai remarquer que chez certaines personnes, ce n'est pas forcément évident comme ça oralement de dire ...donc voilà comment ça s'écrit, ascii.

Et cette table, en fait, tout simplement parce que vous savez donc on va faire une petite parenthèse mais qui est important.

Alors l'ordinateur, vous savez qu à la base c'est du binaire, des 0 et des 1.

Un ordinateur tout ce qu'il sait faire, c'est des calculs, d'accord.

On lui a permis d'avoir certaines opérations élémentaires où il va en fait stocker des informations, faire des additions, ce genre de choses et il ne sait faire que ça.

Donc si un ordinateur ont commence à lui parler de caractère comme un a, un b, un c et cetera. Pour lui, en fait, bah ça n'existe pas, d'accord. Il n'y a pas de caractère comme nous, d'accord, il n'y a pas d'alphabet.

Lui a part des 0 et des 1... Et donc faire des calculs avec des nombres, il ne sait rien faire d'autre, du coup cette table ascii, en fait, permet de coder pas mal de caractère et notamment c'est ça qui nous intéresse, les fameux caractères de l'alphabet.

Donc en gros, vous savez donc sur un codage selon différentes valeurs, en fait, d'accord. Ca c'est, en fait, le numéro, si vous voulez, du code en l'occurrence qui va donc 0 ici à 127.

On trouve pas mal de choses. Après c'est la table ascii étendue mais ça nous intéresse pas ici.

Et par exemple, on va pouvoir, si vous voulez, récupérer en fait donc avoir une comparaison avec cette méthode compareTo() par rapport à l'endroit où se trouve, en fait, ces chaînes concernant la table ascii donc par rapport, en fait, à ce lexique là [http://www.table-ascii.com/](http://www.table-ascii.com/).

Donc en gros si je note ceci et je compare les 2.

Et bien cette méthode compareTo() va retourner 0.
```java
public class App
{
	public static void main(String []args)
	{
		String s = "a";
		String s2 = "a";
		System.out.println(s.compareTo(s2));
	}
}
```
```powershell
	>javac App.java
	>java App
	0
```
Donc encore une fois, si vous connaissez la fonction strcmp() en langage c, par exemple, vous savez un petit peu comment fonctionne ce genre de fonction.

Comme pour cette fonction en Java et compareTo() pour cette méthode là, elle va retourner 0 si on a les mêmes chaîne, d'accord si elles sont égales, pas de problème.

Par contre regarder, si je fais ce genre de chose.
```java
public class App
{
	public static void main(String []args)
	{
		String s = "A";
		String s2 = "a";
		System.out.println(s.compareTo(s2));
	}
}
```
Là automatiquement, ça va me retourner un nombre négatif et pas n'importe quel nombre négatif. 
```powershell
	>javac App.java
	>java App
	-32
```
ça me retourne moins 32 et ça bon pareil, j'aurais pu très bien ne pas vous l'expliquer mais voilà, il y a des gens aussi qui aime bien comprendre absolument tout ce qu'ils font en programmation dans le moindre détail.

Donc je vais vous l'expliquer. 

Maintenant la table ascii, vous avez tout simplement ces caractères qui sont codées quelque part alors les majuscules d'accord, les lettres de notre alphabet en majuscules arrive au départ.
```java
String s = "A"; //65
String s = "a"; //97
```
En gros celles-ci `"A"`, elle est codée... son code ascii, c'est 65 en base 10 donc décimal et le `"a"` minuscule donc ça c'est 2 choses ... si vous voulez retenir la table ascii, pas besoin de forcément retenir tout par coeur, ça n'a aucun intérêt... c'est 97.

Et du coup, cette méthode compareTo() et bien elle va comparer, en fait, le code ascii, d'accord, de chacun.

Donc si le code ascii, par exemple, de s2 est avant s bah ça va retourner, en fait, un nombre négatif.

Si c'est égaux, bah ça veut dire qu'on a vraiment le même caractère parce qu'on aurait le même code ascii.

Et si c'est l'inverse c'est-à-dire que si s2 était plus petit que s et bien on aurait quelque chose de positif.

Donc comment il faut le voir si on veux comprendre pourquoi ici, on a du coup moins 32... bah c'est très simple, il suffit de prendre une calculette si vous avez peur de vous tromper.

Et en gros qu'est-ce qu'on a dit ? tu compares s à s2 donc tu compares le code de s à s2 donc on fait simplement une soustraction donc 65 mois 97 et on tombe bien sur moins 32 (65-97=-32).

Ce qui veut dire que dans la table ascii donc lexicallement parlant, le caractère `"A"` en majuscule parce que c'est... attention les majuscules et les minuscules, c'est bien différent programmation ... arrive avant le caractère `"a"` minuscule.

Et si on se réfère justement à la table ascii qu'encore une fois vous n'avez pas besoin d'apprendre par-cœur, c'est pas grave du tout.

Et bien vous voyez que le caractère en majuscule arrive bien ... donc est bien codé avec la valeur 65 donc c'est son code et le `"a"` minuscule après et il est 97, voilà.

Donc ça en fait cet ordre là qui est suivie et qui du coup explique un petit peu le retour de cette méthode compareTo(), c'est pour ça que je tenais à vous l'expliquer quand même dans la vidéo, c'était important.

Et je vais évité d'épingler ma calculette, voilà.

Donc c'est quelque chose que je voulais vous expliquer pour vous compreniez un peu pourquoi ce retour, en fait, de cette méthode, et la différence entre ces 2 là...

`equals(<str>)` retourne un booléen et `compareTo(<str>)` retourne un nombre en fonction évidemment du placement, d'accord, de la différence entre les chaînes que vous vérifiez par rapport à leur code dans la table ascii.

Maintenant, vous savez un petit peu à quoi ça correspond et au moins vous serez utiliser ces deux méthode comme il faut en fonction de ce que vous voulez exploiter derrière.

Et je pense qu'on va s'arrêter là, ça fait quoi, ça va faire une petite demi heure voilà que je suis en train d'enregistrer cette vidéo donc ça suffit largement par rapport à ça.

Je voulais en tout cas dans cette première partie que vous voyez cette classe String. 

Maintenant vous allez pouvoir l'utiliser.

Donc ce qu'il faut retenir encore une fois, c'est que la classe String est immuable d'accord.

A partir du moment où on cherche à modifier le contenu, d'accord, d'une chaîne de caractères String, on va créer une nouvelle chaîne donc évidemment ça va avoir un certain coup parce que à chaque modification on crée une nouvelle chaîne donc c'est une opération supplémentaire.

Donc vous verrez que par la suite bah quand on a de trop nombreuses opérations, on a évidemment des classes en Java qui vont être beaucoup plus optimisé que cette fameuse classe String.

Pour autant, ça ne veut pas dire qu'il ne faut absolument pas l'utiliser, d'accord, attention de pas tomber dans l'extrême inverse.

Il faut bien sûr, savoir l'utiliser mais justement bah quand t'apprend à maîtriser les différents classes qui existent, on sait utiliser quel cas, dans quel contexte, pour quelle situation et c'est comme ça justement, qu'on devient, en tout cas à mon sens, un bon développeur.

Voilà pour cette partie, on s'arrêtera là dessus.

N'hésitez pas encore une fois a voir la documentation de la classe String si vous vous intéressez a plein d'autres méthodes ou autre.

Je suis loin de vous avoir tout bah vous avoir fait la présentation, un petit peu, de toutes les méthodes qu'elle posséde et tous les constructeurs également qu'elle propose parce qu'il y a pas mal d'autres constructeurs aussi disponibles pour cette cette classe String.

Et on va s'arrêter là, pour cette première partie.

On se retrouvera pour la 2nde partie des chaînes de caractères en Java avec d'autres classes. On verra logiquement 2 ou 3 cases donc la classe que je voulais vous montrer ... je vous avez dit qu'on verrait peut-être en fin de vidéo, je vais le garder pour la 2nde partie, c'est pas bien grave. C'est pas très long de toute façon à expliqué et ça nous permettra de faire des split donc en fait de séparer, comme ça, une chaîne en plusieurs morceaux.

On regardera ça en détail pour la 2e partie aussi.

Je vous dis à bientôt pour la prochaine séance sur ce cours Java.

Ciao tout le monde