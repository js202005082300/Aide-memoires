# [7. Boucles](https://www.youtube.com/watch?v=ws0JqA7bPN0)
	
Bonjour tout le monde on se retrouve sur le cours Java pour la 7e séance où nous allons aborder comme je l'avais dit dans la précédente, les boucles donc c'est une autre notion très très importante en programmation que vous retrouverez dans tous les langages.
	
Alors on va regarder ça directement avec une mise en une mise en forme de code très simple pour que vous puissez bien assimiler ce genre de notions là.

Alors précédemment on avait parlé des conditions d'accord comme vous avez vu des tests, pour vérifier donc des test d'égalité, de différence ou des comparaisons tout simplement entre par exemple une variable et une valeur ou deux valeurs ou deux variables bref, on peut faire des tests un petit peu sur tout et n'importe quoi.

Vous voyez en fonction du résultat de ce test si ça retourne vrai donc true ou faux false, on exécutait ou non la partie de la structure.

Une boucle ça va être un petit peu le même système donc ça va en fait au lieu de dire bien, on fait simplement un test, on va dire de répéter une suite d'opérations tant que le test que nous voulons vérifier vaut vrai, d'accord.

Pour vous montrer ça et bien on peut faire par exemple, ce genre de chose. 
Par contre, on va peut être pas répété 15000 fois... on va mettre une variable qu'on va appeler i donc le nom de la variable i est utilisé comme compteur. On utilise souvent le nom i, j, k et cetera pour un compteur, c'est on va dire les seuls cas où vraiment on va pas donner de nom explicite à la variable puisque c'est admis en fait en programmation quand on a une variable i, j, k, ce sont des compteurs pour parcourir quelque chose et vous allez comprendre pourquoi.

ici on va faire ça, on va mettre par exemple i à 0 d'accord, et on va faire une première boucle qui va dire tout simplement `while(i !=10)` d'accord. Alors là comme pour les IF avec une seule instruction pas obligé de mettre les accolades et moi je vais les mettre pour vous comme ça voilà on sera sûr et on peut dire d'exécuter un certain nombre de choses par exemple println et pourquoi pas afficher la valeur de i d'accord.
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 0;
		
		while(i != 10)
		{
			System.out.println(i);
		}
	}
}
```
```powershell
	>javac App.java
	>java App
	0
	0
	...
```
Alors si je fais cette exécution de programme, voilà.

Là vous voyez que le programme donc je suis obligé de l'arrêter moi-même au clavier dans un `CTRL + C` dans le terminal sinon vous voyez que le programme s'exécute sans interruption d'accord. 

Il m'a affiché 0 plein de fois et il aurait pu tourner comme ça indéfiniment puisque je suis dans ce qu'on appelle une boucle infinie tout simplement puisque je lui dis ça.

Je déclare et j'initialise une variable i à 0 et lui dit que tant que ma variable i est différent de 10 t'affiche la valeur de cette variable.

Et comme effectivement bah 0 c'est toujours différent de 10, là vous voyez qu'on a une boucle infinie. 

Ca s'exécutera tout le temps donc là on va simplement incrémenter notre variable de i à chaque tour en faisant comme on l'a vu précédemment un i++ ou i+=1 d'accord bref comme on veut. On va faire un i++. 
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 0;
		
		while(i != 10)
		{
			System.out.println(i);
			i++;
		}
	}
}
```
On va faire ce genre de chose et là on va réexécuter le programme, on va plutôt d'ailleurs re compiler avant c'est mieux.
```powershell
	>javac App.java
	>java App
	0
	1
	2
	3
	4
	5
	6
	7
	8
	9
```
... et là vous voyez qui m'affiche donc de 0 à 9 d'accord et après le programme s'arrête bien cette fois-ci. Tout simplement parce que au moment où i arrive à la valeur 10, on ne fait plus le while d'accord.

Alors comment ça se passe une boucle histoire de montrer un petit peu le mécanisme contrairement à IF ou à ELSE qui va se faire qu'une seule fois et après terminé.

On arrive au while, on test, on fait cette vérification là `(i != 10)`, est-ce que au premier moment, i est différent de 10 ? oui puisque i est égal à 0 donc on rentre dans la boucle et on fait ce qui est demandé, on affiche la valeur de i donc c'est bien ça le 0 et ensuite on incrémente i de 1 donc i va obtenir la valeur 1. Une fois qu'on arrive là on revient à la boucle d'accord, au début.
```java
		while(i != 10)
		{
			System.out.println(i);
			i++;
		} // <--
```
On refait le test à chaque fois donc est-ce que 1 (parce que i, je rappelle qu'il est égal à 1 maintenant) est différent de 10 ? oui donc on retourne dans la boucle, on ré affiche la valeur, on incrémente un nouveau i de 1 donc ça passe à 2 et on recommence la boucle depuis le début. Est-ce que 2 différent de 10 ? oui, on refait et cetera et cetera jusqu'au dernier moment on va arriver à est-ce que i est égal à 10, est différent de 10 ? non, ça va retourner false. Dans ce cas-là, on va ignorer le while et passer à la suite du programme donc c'est pour ça que ça s'arrête à 9 et pas à 10 puisque j'ai commencé à 0, d'accord.

Si j'avais commencé à 1, déjà bon là ça aurait été plutôt 11 `(i != 10)`
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 1;
		
		while(i != 11)
		{
			System.out.println(i);
			i++;
		}
	}
}
```
```powershell
	>javac App.java
	>java App
	1
	2
	3
	4
	5
	6
	7
	8
	9
	10
```
Là on aurait eu bien sûr, les valeurs de 1 à 10 d'accord puisque là c'est différent strictement donc à partir du moment où l'on a la même valeur, on va ignorer la boucle, on ne fera pas ce qu'il y a à l'intérieur donc ça c'est un petit peu la condition que nous avons d'accord, le while.

Alors je vais reprendre ce que j'ai mit au début c'est-à-dire ça. 
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 0;
		
		while(i != 10)
		{
			System.out.println(i);
			i++;
		}
	}
}
```
```powershell
	>javac App.java
	>java App
	0
	1
	2
	3
	4
	5
	6
	7
	8
	9
```
Et voilà comment on fait une simple boucle par rapport à ça et on n'oublie pas d'incrémenter parce que si vous n'incrémenter pas ce qui vous permet d'arrêter en fait la boucle, elle va tourner indéfiniment donc en général, c'est souvent le test que l'on fait ici, voilà donc ça c'est important à savoir euh pour cette partie.

Ce qu'on peut faire aussi, je peux vous montrer pour la boucle avant de passer aux autres syntaxe qui existe, c'est arrêter la boucle à un certain momen, comment es qu'on peut faire ça ? Vous vous souvenez sûrement du mot-clé break que nous avons utilisé la dernière fois pour le switch dans la vidéo précédente et bien le break permet de dire d'interrompre une structure donc une structure conditionnelle ou une structure de boucle donc là si je fais un break directement. Je peux m'amuser à faire ça.
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 0;
		
		while(i != 10)
		{
			System.out.println(i);
			break;
		}
	}
}
```
Qu'est-ce que nous allons obtenir donc on va tester ensemble pour que vous voyez un petit peu.
```powershell
	>javac App.java
	>java App
	0
```
On a 0 et ça se termine parce que le break veut dire tout simplement tu interrompt ce que t'était en train de faire sur la boucle et tu passes à la suite donc en bref tu arrives directement là au niveau du code.
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 0;
		
		while(i != 10)
		{
			System.out.println(i);
			break;
		}
	//	<---
	}
}
```
Donc il sera rentré une première fois dans la boucle parce que le test là `(i != 10)` était vrai d'accord.
0 est bien différent de 10, il a affiché, on a fait le break donc on sort de la boucle, c'est véritablement une sortie et dans ce cas-là le programme se termine donc on n'a que le 0 mais on peut très bien faire ceci, dans notre boucle, on dit à un moment donné si i égal égal à 5 dans ce cas-là tu sors et là du coup la boucle va se répéter jusqu à ce que i soit égal à 5. 
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 0;
		
		while(i != 10)
		{
			System.out.println(i);
			if(i == 5)
				break;
		}
	}
}
```
On va faire ça, alors c'est normal que c'est ça (boucle infinie) puisque je n'ai pas l'incrémentation.
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 0;
		
		while(i != 10)
		{
			System.out.println(i);
			if(i == 5)
				break;
			i++;
		}
	}
}
```
Toujours pareil, boucle infinie si on oublie l'incrémentation à chaque fois et voilà d'accord.
```powershell
	>javac App.java
	>java App
	0
	1
	2
	3
	4
	5	
```
Donc ça fait 012345 et après automatiquement ça quitte et là ça affiche 5, ce qui est normal puisque on a fait la vérification après. Si on affiche la valeur de i et après seulement s'il est égal à 5, on quitte.

Si par contre j'ai mis mon test avant et ensuite je faisais ça.
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 0;
		
		while(i != 10)
		{
			if(i == 5)
				break;
			
			System.out.println(i);
			i++;
		}
	}
}
```powershell
	>javac App.java
	>java App
	0
	1
	2
	3
	4
```
Voilà alors évidemment l'affichage sera un peu différent, on ira au 4 puisqu'on a dit qu'on quitte avant même d'afficher quoi que ce soit donc quand c'est égal à 5 comme on quitte la boucle et bien voyez tout ce qui vient après est ignorer puisque on interrompt réellement la boucle et on passe à la suite donc on affiche pas ce qu'il y avait dans le reste de la boucle donc voilà.

Il y a une autre un autre mot-clé aussi, une autre instruction par rapport aux boucles pour le coup qui ne fonctionne pas pour le reste mais pour les boucles qui permet de dire de revenir au début donc par exemple ce qu'on peut dire et bien c'est que si ... alors on va peut-être faire i++ à chaque fois sinon ça va poser problème et de faire ça (i++ au début de la boucle) et de dire bah si le i est égal à 5, tu fais un continue.
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 0;
		
		while(i != 10)
		{
			i++;
			
			if(i == 5)
				continue;
			
			System.out.println(i);
		}
	}
}
```
continue, ça veut dire quoi ? ça veut dire tu continue la boucle, ça veut dire qu'on va ignorer ce qui vient après ici et on revient au début de la boucle.

Et la différence c'est qu'il va se passer ça.
```powershell
	>javac App.java
	>java App
	1
	2
	3
	4
	6
	7
	8
	9
	10
```
Ca m'affiche 1234 et là au lieu de m'afficher 5 comme i est égal à 5 ... voilà on a dit continue donc ça veut dire : reviens au début de la boucle.

Donc il aura ignorer tout le reste et du coup il n'aura pas eu le temps d'afficher le 5 donc, ça passe de 46789 10 et cetera, voilà.

Donc ça c'est un mot-clé à connaître aussi par rapport aux boucle. Vous avez le break pour interrompre une boucle ou interrompre un switch d'accord, un cas dans un switch et le continue pour les boucles qui veut dire de retraiter une nouvelle itération.

Donc à chaque fois qu'on passe comme ça dans la boucle, on revient au début, on appelle ça une itération d'accord.

Et là à chaque itération de la boucle et bien on fait une incrémentation de i `i++`, on fait ce test `i == 5` et ça `println(i)`.

Ca c'est le code qui correspond à une itération de boucle qui sera répéter donc itéré, réitéré autant de fois que cette condition là `i == 5` est vrai jusqu'à ce qu'elle devienne fausse. Elle deviendra fausse par rapport à ce que vous faites justement dans ce code là.

Voilà comment ça se passe pour une boucle while.

On a une petite variante qui permet de ... alors là.
```java
	while(i != 10) 
```
Vous voyez que on fait le test dès le départ, si le test est faux par exemple là on a déjà i égal 10.
```java
	int i = 0;
```
Je pense que sans surprise vous avez bien compris parce que vous connaissez bien vos conditions. Si je fais ça.
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 10;
		
		while(i != 10)
		{
			i++;
			
			if(i == 5)
				continue;
			
			System.out.println(i);
		}
	}
}
```
```powershell
	>javac App.java
	>java App
```
Si je fait ça, je n'exécute rien puisque dès le départ i est égal à 10.

Là est-ce qu'il est différent de 10 ? non parce qu'il était égal donc on ignore directement la boucle.
Il ne se passe rien, on peut faire cette boucle à l'envers c'est-à-dire de dire ... je vais changer ça while(), on va le prendre et je vais le mettre à la suite, voilà. On met un ; d'accord et ici (avant) on va commencer par un do, qui veut dire "faire". 
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 10;
		
		do
		{
			i++;
			
			if(i == 5)
				continue;
			
			System.out.println(i);
		}
		while(i != 10);
	}
}
```
Ca veut dire tu fais tout ce qu'il y a là tant que i est différent de 10.
```java
			i++;
			
			if(i == 5)
				continue;
			
			System.out.println(i);
```
donc là on va faire au minimum une fois ce qu'il y a dans la boucle quoi qu'il arrive d'accord parce que le test est fait après et ensuite seulement on fait le test.
Et là la différence c'est ça.
```powershell
	>javac App.java
	>java App
	11
	12
	13
	14
	15
	16
	...
```
Alors là évidemment on a un nombre qui va pas, puisque y est égal à 10 et voilà du coup après ça sort.

On va mettre plutôt comme ça `(int i = 1)`.
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 1;
		
		do
		{
			i++;
			
			if(i == 5)
				continue;
			
			System.out.println(i);
		}
		while(i != 10);
	}
}
```
```powershell
	>javac App.java
	>java App
	2
	3
	4
	6
	7
	8
	9
	10
```
Voilà d'accord, i était égale à 1 et il est passé directement à 2 parce qu'on l'a incrémenté donc la valeur qu'on affiche c'est le 2. On affichera jamais le 1 puisqu'il était égal à 1 au départ donc si je reprends la valeur `int i = 0`. On fera ça du coup comme ça.
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 0;
		
		do
		{
			i++;
			
			if(i == 5)
				continue;
			
			System.out.println(i);
		}
		while(i != 10);
	}
}
```
```powershell
	>javac App.java
	>java App
	1
	2
	3
	4
	6
	7
	8
	9
	10
```
Donc là on a i égal 0. Dès le début de la boucle, on l'incrémentale de 1 donc il passe à 1. Est-ce qu'il est égal à 5 ? non et du coup là on l'affiche. Donc on affiche bien le 1 et après on fait le test seulement. Est-ce que i qui est égal à 1, je rappelle, parce qu'il a été incrémenté, différent de 10 ? oui donc là on revient au début du do{}while. 

Donc c'est ce que l'on appelle une boucle DO WHILE d'accord. Vous avez la boucle WHILE et vous avez la boucle DO WHILE donc la différence c'est que dans un DO WHILE la partie qui est dans le DO sera toujours faite au moins une fois alors que tout ce qu'on a vu tout à l'heure bah si dès le départ votre condition là `while(i != 10)` n'est pas vrai et bien vous avez vu on ignorait complètement la boucle.

Là c'est impossible d'ignorer complètement la boucle, on va au minimum faire le DO ici une seule fois toujours une seule fois.
```java
		do
		{
			i++;
			
			if(i == 5)
				continue;
			
			System.out.println(i);
		}
```
Donc voilà la petite distinction, si un jour vous avez besoin véritablement de faire au moins une fois ce qu'il y a dans la boucle et après seulement d'effectuer le test, utiliser une boucle DO WHILE.

Si par contre vous voulez dès le début faire le test, il faut utiliser une boucle WHILE standard comme on l'a déjà vu.

Alors pareil je n'ai pas dit mais c'est logique aussi parce que là c'est comme pour le IF, vous pouvez bien évidemment faire plusieurs vérifications avec le && ou le || comme on l'a vu pour les structures conditionnelles.

Je ne l'ai pas montré en exemple mais on l'a déjà fait sur la vidéo précédente, vous pouvez bien sûr faire la même chose, tout entre parenthèses donc c'est comme pour un IF comme pour un ELSE IF. Vous mettez autant de tests que vous voulez avec de des &&, des || en fonction et tant que ça retournera vrai, la boucle sera exécuté. Une fois que ça devient false, la boucle ne l'est plus, n'est plus exécuté.

Voilà pour cette partie là et on passera maintenant à la dernière boucle qui est très importante et qu'il le sera encore plus quand par exemple on va aborder les tableaux et qu'on voudra parcourir les valeurs d'un tableau. 

Un tableau pour pour faire rapide, c'est tout simplement un ensemble de plusieurs données d'accord par exemple un tableau de nombres, un tableau de chaînes de caractères, ce genre de choses donc au lieu d'avoir ici une seule variable qui contient qu'une valeur, on pourra par exemple avoir plus tard un tableau d'entiers donc un tableau qui aura du coup plusieurs nombres à l'intérieur et on pourra parcourir ces nombres un par un pour tous les afficher.

Donc pour cela on utilisera un certain type de boucle mais là on va quand même le montré aussi, qui est la boucle for et la boucle for d'ailleurs je peux enlever ici l'initialisation, elle n'est plus obligatoire. 

Elle va prendre 3 choses alors les accolades toujours.
```java
public class App
{
	public static void main(String[] args)
	{
		int i;
		
		for()
		{
			
		}
	}
}
```
3 choses importantes.
Le premier c'est l'initialisation à une valeur donc par exemple i égal 0 c'est-à-dire que là i commence à 0, d'accord. D'ailleurs voyez qu'ici, je n'ai pas mis d'initialisation alors on pourrait le mettre. On pourrait très bien faire ça `(int i = 1)` mais on s'en fiche puisque une fois qu'on fait le for, on passe le i a 0 peu importe.

On va mettre ça comme ça.
```java
public class App
{
	public static void main(String[] args)
	{
		int i;
		
		for(i = 0)
		{
			
		}
	}
}
```
Vous mettez un point-virgule pour séparer et ici ça va être la condition d'arrêt c'est-à-dire que la boucle on va l'exécuter tant que. C'est ce qu'on a fait tout à l'heure, tant que `i != 10`, d'accord, point-virgule et ensuite c'est ce qui va permettre d'atteindre en fait le point d'arrêt c'est-à-dire qu'est-ce qu'on va faire jusqu à atteindre ce point d'arrêt bah nous ce qu'on a fait tout à l'heure, si vous vous souvenez, on a fait incrémenter i de 1 donc vous mettez ici i++.
```java
public class App
{
	public static void main(String[] args)
	{
		int i;
		
		for(i = 0 ; i != 10 ; i++)
		{
			
		}
	}
}
```
Vous voyez c'est une notation beaucoup plus pratique et beaucoup plus rapide pour traiter tous les cas, il n'y aura plus besoin de mettre le `i++`, ici dans le for.
```java
		for(i = 0 ; i != 10 ; i++)
		{
			i++;
		}
```
Il est déjà ici dans tout le test à faire, d'accord.

Donc ça `(i++;)`, on a plus à le faire sinon là vous allez l'incrémenter 2 fois le i, vous pouvez le faire mais ça va être +2 à chaque fois au lieu de +1 mais nous on le fait là.
```java
	for(i = 0 ; i != 10 ; i++)
```
Donc je rappelle, l'initialisation c'est la première partie point-virgule, le point d'arrêt donc la condition à vérifier qui arrêtera la boucle point-virgule l'incrémentation (i++) où là décrémentation (i--) bien sûr à faire. On peut très bien faire l'un ou l'autre, il n'y a pas de problème ou faire i = i+1 ou voilà on peux augmenté i de +2 ou -2 à chaque fois sans problème. C'est le test que vous voulez à chaque fois pour augmenter le compteur. 

Donc on va garder l'exemple de tout à l'heure en faisant juste ça. On afficherait i.
```java
public class App
{
	public static void main(String[] args)
	{
		int i;
		
		for(i = 0 ; i != 10 ; i++)
		{
			System.out.println(i);
		}
	}
}
```
```powershell
	>javac App.java
	>java App
	0
	1
	2
	3
	4
	5
	6
	7
	8
	9
```
Comme pareil, une seule instruction, les accolades sont optionnelles quand il y a qu'une seule instruction mais moi je laisse, ça change pas, de toute façon ça ne va pas gêner l'exécution du programme et si je fais ça, on obtient en fait la même chose que ce qu'on avait tout à l'heure. C'est exactement la même chose que de faire ceci.
```java
public class App
{
	public static void main(String[] args)
	{
		int i = 0;
		
		while(i != 10)
		{
			System.out.println(i);
			i++;
		}
		
		for(i = 0 ; i != 10 ; i++)
		{
			System.out.println(i);
		}
	}
}
```
sauf que là (WHILE), il faut incrémentation et du coup bah i est égal à 0 à ce moment-là parce que le WHILE, voyez on initialise i et on l'incrémente.
```powershell
	>javac App.java
	>java App
	0
	1
	2
	3
	4
	5
	6
	7
	8
	9
	0
	1
	2
	3
	4
	5
	6
	7
	8
	9
```
Donc on a la même exécution d'accord, voilà. On arrive de 0 à 9 et de 0 à 9 mais avec 2 syntaxes différentes le WHILE ou le FOR qui prend directement en compte l'incrémentation que vous voulez faire en faite donc ça évidemment c'est utile dans certains cas, vous verrez d'accord, plus que d'autres surtout pour du parcours, on utilise beaucoup plus pour du parcours mais sachez que voilà ça peut s'utiliser comme ça, il n'y a pas de problème non plus. 

Donc c'est la syntaxe que je voulait vous montrer, pareil une syntaxe que l'on retrouve dans beaucoup beaucoup de langages de programmation PHP, le C, le C++, Javascript et cetera et cetera. Tous emploi justement cette même syntaxe, le FOR, des parenthèses, l initiation (i=0), point-virgule, la condition d'arrêt point-virgule et ce que l'on veut faire incrémenter, décrémenter et cetera en fonction.

Donc gardez bien tout cela à l'esprit car ça vous apprendre énormément de choses en fait en très peu de temps et ce sont des notions à connaître.

Vraiment les boucles faut vraiment les connaître parce que ça vous servira beaucoup beaucoup dans un code, je peux vous donner un exemple d'application très simple vous demander à l'utilisateur par exemple un pseudonyme pour une application, un site web ou n'importe quoi et vous voulez que le pseudonyme correspondent à des critères particuliers, par exemple il ne doit pas dépasser 25 caractères et là vous pourrez dire : tant que le pseudonyme de l'utilisateur, tant que la taille du pseudonyme d'utilisateur est plus grand que 25 et bien je redemande à l'utilisateur, en fait de saisir un identifiant valide d'accord.

Donc voyez on a une condition ici, on a un cas de boucle. On va boucler sur la demande à l'utilisateur d'un pseudonyme tant que... (d'accord vous savez ce que ça veut dire hein le WHILE, ça veut dire tant que)... Eh bien le pseudo de l'utilisateur, sa taille en tout cas sera supérieur par exemple au 25 caractères que l'on exige, voilà au maximum.

Donc voilà un cas d'applications très simple pour l'utilisation d'une boucle ou alors parcourir. Dire un fichier, on le parcours et tant qu'on n'est pas arrivé à la fin du fichier et bien on lit tout ce qui est à l'intérieur pour pouvoir l'afficher plus tard voilà.

Donc on retrouve bien évidemment ce principe de boucle qui est en fait un système pour parcourir aussi en programmation dans beaucoup beaucoup de cas d'applications que vous aurez de toute façon l'occasion de découvrir quand vous programmerez, quand vous ferez des vrais programmes et vous mettrez ça en application sur des choses un peu plus concrètes.

Voilà pour cette vidéo je vais m'arrêter là, je ne voulais pas voir plus que ça avec vous.

Il n'y avait pas grand grand chose.

Pour la prochaine séance on va aborder vraiment une grosse grosse partie comme je l'avais annoncé de Java notamment tout le fameux principe des classes, des méthodes, toute la partie objet d'accord d'un langage de programmation.

Java est un langage objet, d'accord qui utilises vraiment ce paradigme là. On ne pourrait pas faire sans d'ailleurs comme vous l'avez vu.

Et on va regarder ça un petit peu ça dans le détail, comment on peut construire justement ces fameux objets ? comment on peut créer des classes, des méthodes, des attributs tout ce genre de choses dans la vidéo prochaine et dans celles qui vont suivre derrière de toute façon.

Vous verrez que l'on va passer voilà, on va passer un cap supérieur.

Donc là on a vraiment vu les bases des bases, vraiment les notions absolument élémentaires en programmation que ce soit en Java ou un autre langage peu importe.

Et là, on va passer sur des choses un peu plus complexes pour la prochaine séance donc n'hésitez pas à bien revoir ces vidéos, si ce n'est pas suffisamment clair pour vous, à poser des questions dans les commentaires si vous êtes bloqué sur certains points qui sont quand même très essentiel pour la suite et après vous serez même beaucoup plus serein pour attaquer les prochaines vidéos notamment quand on va aborder justement cet aspect classe, méthode et cetera.

Je vous dis à bientôt pour la prochaine vidéo et on se retrouve donc pour un prochain cours en tout cas en Java.

tchao