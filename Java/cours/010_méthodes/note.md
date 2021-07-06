# [10. Méthodes](https://www.youtube.com/watch?v=FkB7N0w81Dk)
	
Bonjour à tous,

Bienvenue sur ce cours de programmation en Java pour la séance 10, nous allons aborder les méthodes donc ce sera une grosse vidéo, comparé à la précédente sur les attributs qui vont englober pas mal de choses.

On va revenir sur un code très simple pour le coup alors j'ai viré la la classe Cat qu'on avait fait la dernière fois. On va voir un petit peu ici ce qui va changer. 
```java
public class App
{
	public static void main (String []args)
	{

	}
}
```
Première chose que nous allons voir donc nous allons parler parce que c'est le titre de la vidéo, des méthodes.

Une méthode comme j'avais dit la dernière fois, c'est une fonction en fait donc c'est un nom que l'on donne à une fonction concernant la programmation orientée objet parce que Java comme je l'avais dit, on est obligé de programmer avec des objets.

On ne pourrais pas faire un programme Java en fait sans utiliser d'objet parce que le programme principal que nous avons, en tout cas, le minimum c'est déjà une classe d'accord donc ici (App) et ensuite la méthode main.

Donc ceci `public static void main (string []args)` est une méthode comme j'avais pu le dire d'ailleurs sur la première vidéo à laquelle nous avions commencé à faire justement notre premier programme.

Donc par défaut quand nous allons en fait exécuter notre programme, la machine virtuelle va chercher dans notre classe principale celle-ci `public class App` donc c'est-à-dire qu'on n'a pas besoin de l'instancier nous-même, maintenant que vous savez un petit peu en quoi ça consiste un peu l'instanciation d'une classe pour créer un objet et vous avez remarqué, nulle part en fait on s'est amusé par exemple à faire je sais pas moi, à faire ce genre de chose.
```java
	App a = new App();
```
... à faire new et ensuite appeler notre application App() d'accord. La machine virtuelle va automatiquement chercher notre classe renseigner qui contient justement notre méthode main ici qui est notre point d'entrée de notre programme donc elle est un petit peu particulière du coup cette classe App que j'ai ici, ...
```java
public class App
{
	public static void main (String []args) <--
	{

	}
}
```
... parce que c'est notre classe principale au lancement de notre programme et elle contient donc cette fameuse méthode que je rappelle et avec un niveau d'accessibilité public.

Elle a un mot-clé statique mais ça justement, on va en parler parce que ça va être justement ce principe là, un type de retour mais on va voir un petit peu, d'accord, c'est-à-dire qu'ici `void` ne retourne rien, elle ne retourne aucune information quant elle est terminée cette méthode là.

Son nom (main) et entre parenthèses, elle peut contenir, ce n'est pas obligatoire, des paramètres et ça c'est pareil, on aura l'occasion d'en parler quand on abordera notamment les tableaux par la suite. Alors voilà comment ça se passe.

Pour cette classe principale, ici `public class App`, vous allez pouvoir bien évidemment, faire tout un tas de choses donc dans le main par exemple ici.
```java
public class App
{
	public static void main (String []args)
	{
	//	<--
	}
}
```
Faire tout un tas de chose dans le main par exemple comme utiliser des méthodes, on en a d'ailleurs déjà fait, on s'est déjà amusé par exemple à afficher quelque chose à l'écran en faisant ceci.
```java
public class App
{
	public static void main (String []args)
	{
		System.out.println("Hello Word !");
	}
}
```
on a donc appelé println d'accord pour faire un affichage à l'écran suivi d'un retour à la ligne dans la console.

A partir de là, j'en ai qu'un donc là on va faire juste ça `javac App.java` et là je fais ça `java App` et on pouvait afficher quelque chose à l'écran d'accord.
```java
	>javac App.java
	>java App
	Hello Word !
```
On se contente en fait d'utiliser des méthodes qui appartiennent à Java qui sont donc native d'accord.

On les utilise et ça fonctionne très bien. Chaque méthode permet de faire quelque chose en particulier et on va en apprendre plein, et on va utiliser vraiment plein. On va en avoir ensuite qui sont liées aux chaînes de caractères, on en aura par rapport au tableau et on aura pour pas mal d'autres types de classes pareil qui sont natives à Java.

D'ailleurs la classe chaîne de caractères String est une classe de Java d'accord, qui permet de manipuler des chaînes de caractères qui possède ses propres méthodes et on le verra ça dans une vidéo prochainement.

Donc ça c'est l'utilisation, on va dire simple d'accord, de nos méthodes.

On peut on peut sans problème utiliser des méthodes comme ceci mais nous ce qui nous intéresse pour ne pas avoir seulement qu'à utiliser des méthodes, c'est de pouvoir également en créer.

Maintenant la première question à se poser c'est quel intérêt en fait de faire des méthodes, ce qu'on appelle donc des fonctions liées à la programmation objet. Est-ce qu'on ne pourrait pas programmer en fait sans utiliser une méthode ? alors on pourrait mais simplement ça poserait de nombreux soucis, le premier d'abord c'est la répétition de code. Admettons qu'un moment donné, je sais pas moi, je veux répéter alors là j'ai pas forcément grand-chose, mais par exemple je vais faire tout un tas d'instructions, tout un tas de choses dans mon programme et à un moment donné, je dois répéter certaines parties de mon code, alors ça peut être, je sais pas moi, on peut faire ... qu'est-ce qu'on peut faire ? On peut mettre par exemple ceci.
```java
public class App
{
	public static void main (String []args)
	{
		int age = 0;
		System.out.println(age);
		age = 15;
		System.out.println(age);
	}
}
```
Comme ça ensuite on va mettre, je sais pas, age égal 15 et ont répéterait du coup ceci `println(age)`.

Voilà, si par exemple, dans un autre partie de mon programme, j'avais besoin de faire ces choses-là c'est-à-dire par exemple de passer âge égal à 15 et ensuite de refaire un affichage, je vais répéter du code. Admettons ailleurs en fait à un autre moment dans le programme, donc là on peut imaginer qu'on a pas mal d'autres choses, entre temps, et à un moment donné on doit refaire cette manipulation pour je ne sais qu'elle raison, du coup on aurait de la répétition de code.
```java
public class App
{
	public static void main (String []args)
	{
		int age = 0
		
		System.out.println(age);
		age = 15;
		System.out.println(age);
		
		//pas mal de choses...
		age = 15;
		System.out.println(age);
	}
}
```
Donc ça c'est la première règle déjà, la première chose qui doit vous interpeller, c'est que si vous avez du code qui se répète dans votre programme, vous devez tout de suite vous dire, je dois pouvoir factoriser ça dans une méthode.

Factoriser, ça veut simplement dire bah au lieu de faire ça de manière répétitive.
```java
		age = 15;
		System.out.println(age);
```
Voyez en plus, c'est à 2 endroits différents et ça pourrait être dans un programme réel, être à 10 20 50 endroits différents, on va mettre ça dans une méthode et pour utiliser, en tout cas créer notre propre méthode et bien on va le faire ici dans notre classe principale.
```java
public class App
{
	public static void main (String []args)
	{
		int age = 0
		
		System.out.println(age);
		age = 15;
		System.out.println(age);
		
		//pas mal de choses...
		age = 15;
		System.out.println(age);
	}
	
	// <--
}
```
Donc la règle très simple par rapport à la classe principale de notre programme en Java, c'est d'avoir une méthode qui est statique justement parce que ici on n'a pas instancier en fait voilà encore une fois on n'a pas un instancier cette classe App donc on ne peut pas enfaite faire de méthodes qui ne sont pas statiques sinon bah évidemment, on ne pourra pas les appeler.

Donc la règle ici, c'est pour la classe principale, on fait des méthodes automatiquement statique et public bien évidemment pour pouvoir les exécuter, c'est quand même plus pratique.

Donc on va faire public static.
```java
public class App
{
	public static void main (String []args)
	{
		int age = 0
		
		System.out.println(age);
		age = 15;
		System.out.println(age);
		
		//pas mal de choses...
		age = 15;
		System.out.println(age);
	}
	
	public static
}
```
Ici bon on a pas vraiment aucune information à retourner, de toute façon, on n'a pas encore vu ça, on va le voir dans la vidéo donc on fait void et puis on va mettre par exemple, je ne sais pas moi, euh ben on va mettre, par exemple, `prog` voilà parce que j'ai vraiment aucune autre information.
```java
public class App
{
	public static void main (String []args)
	{
		int age = 0
		
		System.out.println(age);
		age = 15;
		System.out.println(age);
		
		//pas mal de choses...
		age = 15;
		System.out.println(age);
	}
	
	public static void prog()
	{
		
	}
}
```
Et les parties répétées du coup, j'ai plus qu à les mettre là, voilà.
```java
public class App
{
	public static void main (String []args)
	{
		int age = 0
		
		System.out.println(age);
		age = 15;
		System.out.println(age);
		
		//pas mal de choses...
	}
	
	public static void prog()
	{
		age = 15;
		System.out.println(age);
	}
}
```
Du coup à chaque moment, où j'ai besoin d'exécuter ces instructions, ben je n'ai plus qu'à fait à faire appel à la méthode.
```java
public class App
{
	public static void main (String []args)
	{
		int age = 0
		
		System.out.println(age);
		age = 15;
		System.out.println(age);
		
		//pas mal de choses...
		prog();
	}
	
	public static void prog()
	{
		age = 15;
		System.out.println(age);
	}
}
```
Donc ça, on utilise une méthode donc ça vous savez le faire donc il suffit de faire ça. Je vais mettre cette partie là.
```java
public class App
{
	public static void main (String []args)
	{
		int age = 0
		System.out.println(age);
		
		prog();
		//pas mal de choses...
		prog();
	}
	
	public static void prog()
	{
		age = 15;
		System.out.println(age);
	}
}
```
En gros, on va avoir çà. Donc là, on ne fait plus que répéter du coup, parce qu'il faut bien répéter, ça on n'a pas le choix pour le coup, répéter l'appel à la méthode pour dire Ben dès qu'on va vouloir passer âge à 15, alors là évidemment, ça ne marchera pas parce que j'accède à une variable ici qui n'est pas accessible donc mon exemple n'est pas bon du tout.

Alors ce qu'on va faire en fait, parce que là évidemment ça ne marchera pas. On va mettre `"Bonjour"` et puis par exemple, on va refaire un affichage en fait. On ne peut pas faire plus grand chose parce qu'on n'as pas vu grand chose en programmation Java donc admettons que voilà, on veut répéter ces choses-là.
Du coup tout ceci (int age et cetera), on l'enlève parce qu'on s'en fiche un peu.
```java
public class App
{
	public static void main (String []args)
	{
		prog();
		//pas mal de choses...
		prog();
	}
	
	public static void prog()
	{
		System.out.println("Bonjour");
		System.out.println("Comment allez vous ?");
	}
}
```
Voilà donc on peut imaginer qu'on va chez ces 2 textes et puis un moment donné par mon a plein d'autres choses qui se passent dans le programme et on veut un moment refaire cet affichage là, identique, donc on va ré appeler la méthode.

Donc là, première chose pratique donc déjà pour je vais re compiler tout ça.
```powershell
	>javac App.java
	>java App
	Bonjour
	Comment allez vous ?
	Bonjour
	Comment allez vous ?
```
Voyer que ça s'affiche sans problème donc ça c'est la première chose, c'est déjà on évite de répéter du code parce qu'il y a qu'un seul endroit au final où nos instructions sont écrites, ensuite à chaque endroit où on a besoin évidemment de faire référence à ça (prog), on appelle la méthode qui va bien d'accord par rapport à son nom, terminé et ça fonctionne. 

Autre avantage de ça, c'est que le jour où vous voulez modifier le texte par exemple afficher là.
```java
		System.out.println("Bonjour");
		System.out.println("Comment allez vous ?");
```
Vous n'aurez pas besoin de le faire à x endroit différent c'est-à-dire que là si on avait la répétition de code si vous l'avez répété 10 fois mais le jour où vous allez vouloir modifier une partie, vous allez devoir modifier 10 fois alors même si avec les éditeurs, on peut faire du remplacement d'un coup en fait d'un endroit à un autre, c'est quand même pas pratique et encore une fois parce qu'on a du code qui est répété.

La l'avantage, c'estque le jour où je vais rajouter par exemple une autre ligne, on va faire ça hop. Ce n'est pas du texte très inspiré mais peu importe.
```java
public class App
{
	public static void main (String []args)
	{
		prog();
		//pas mal de choses...
		prog();
	}
	
	public static void prog()
	{
		System.out.println("Bonjour");
		System.out.println("Comment allez vous ?");
		System.out.println("Moi bien");
	}
}
```
Et automatiquement bah les modifications qui ont été faites là vont bien naturellement se répéter et se répercuter en fait ici.
```java
	// ...
	public static void main (String []args)
	{
		prog(); <--
		//pas mal de choses...
		prog(); <--
	}
```
Donc là j'ai plus qu'a re compiler mon programme.
```powershell
	>javac App.java
	>java App
	Bonjour
	Comment allez vous ?
	Moi bien
	Bonjour
	Comment allez vous ?
	Moi bien
```
Et voyez, tout a été modifié directement donc on n'a plus qu'un seul endroit à modifier et c'est bien plus pratique donc ça permet en fait d'organiser un peu mieux notre programme.

En gros donc plutôt que d'avoir voilà du coup de répéter qui serait mélangé dans tout et n'importe quoi parce qu'il y a encore une fois rappelez-vous que dans un vrai programme, vous n'aurez pas que 5, 10 lignes évidemment, vous en aurez des centaines, des milliers, des dizaines, de centaines de milliers donc il va falloir organiser ce code là.

Là l'avantage c'est que vous allez pouvoir avoir des méthodes qui font un certain nombre de choses et pareil une autre règle qui est intéressante et qui je pense qu'ils faut la suivre un maximum, c'est de se dire qu'une méthode ou une fonction quel que soit le langage de programmation d'ailleurs ne doit faire qu'une seule chose à la fois.

Imaginez par exemple un programme, je sais pas par exemple un programme graphique qui va afficher une fenêtre, qui va ensuite charger une image et ensuite va positionner cette image et après par exemple va l'animer. On ne va pas s'amuser à faire une fonction qui ferait tout ça, on aurait une méthode qui ferait , par exemple je sais pas moi, loadWindow() d'accord.
```java
public class App
{
	public static void main (String []args)
	{
		prog();
		//pas mal de choses...
		prog();
	}
	
	public static void loadWindow()
	{
		
	}
}
```
Elle changerait notre fenêtre, qui ferait donc tout un tas de choses, on peut imaginer et ensuite on aurait du coup une autre méthode. Je ne met pas trop de choses de retour (void) car pour l'instant, on s'en fiche un peu. loadSprite(), l'image de notre jeu et puis après par exemple de quoi animer le sprite animateSprite().
```java
public class App
{
	public static void main (String []args)
	{

	}
	
	public static void loadWindow()
	{
		
	}
	
	public static void loadSprite()
	{
		
	}

	public static void animateSprite()
	{
		
	}
}
```
Et du coup dans notre programme, quelque part, dés qu'on aurait besoin de charger notre fenêtre, on auraplus qu'à appelé notre loadWindow() et après au moment où on a besoin de charger une image bon on la charge et puis à chaque moment, où on a besoin de l'animer par exemple après l'appui d'une touche ou je ne sais quoi et bien, on animera à ce moment-là le sprite.
```java
public class App
{
	public static void main (String []args)
	{
		loadWindow();
		loadSprite();
		
		animateSprite();
	}
	
	public static void loadWindow()
	{
		//du code...
	}
	
	public static void loadSprite()
	{
		
	}

	public static void animateSprite()
	{
		
	}
}
```
L'avantage encore une fois, c'est que on sait automatiquement ce que fait notre code juste en lisant les noms des méthodes, ça auto documente notre code. Ca c'est très important plutôt que de devoir commenter en disant bah que ce code là, charge une fenêtre.

Logiquement si vous mettez des noms suffisamment explicite, vous avez auto documenter votre code et ça c'est très très très important quand on fait des codes assez conséquant, de bien donner des noms explicites que ce soit pour les méthodes, les classes et tout ce qui est variable et notamment paramètres et tout ça, pour pouvoir un maximum auto documenté votre code.

Si vous êtes obligé d'écrire 15000 commentaires sur du code, c'est que vous avez mal écrit à la base et là c'est un gros problème logiquement un code qui est bien écrit doit être un minimum documenté par exemple les algorithmes un peu complexe ou les opérations justement les instructions qui ne sont pas forcément très lisible au départ et que vous avez besoin de commenter pour les comprendre rapidement, si un jour vous revenez sur votre code après plusieurs mois, plusieurs années mais c'est tout.

Donc là, on va voir ce genre de choses et la pareil, on retrouve le principe de la modification rapide c'est-à-dire bah le jour par exemple où je veux charger mon image par exemple d'une autre manière en utilisant d'autres choses ... Eh bien je n'aurais que cette méthode loadSprite() à modifier et automatiquement ça va se répercuter partout où je l'aurais utilisé et ça c'est très pratique, ça évite évidemment de la répétition de code et de devoir modifier à 10, 20, 50 endroits différents.

Donc voilà l'intérêt d'utiliser des méthodes ou des fonctions, on est vraiment obligé de s'en servir pour pouvoir rendre le code mieux organisés, plus modulaire aussi et beaucoup plus efficace pour éviter la répétition inutile d'instructions. Voilà un petit peu comment ça fonctionne. 

Donc la règle à retenir, c'est des méthodes statiques pour tout ce qui concerne notre classe principale ici d'accord.
```java
public class App
{
	public static ...
}
```
Donc ça c'est une règle obligatoire en public et après on a ce genre de choses-là.
```java
	public static void loadWindow()
	{
		//du code...
	}
	
	public static void loadSprite()
	{
		
	}

	public static void animateSprite()
	{
		
	}
```
Donc ça, c'est un cas de méthode. Alors j'essaye de rien oublié, j'avais de toute façon noter quelque chose que je devais aborder avec vous pour ne pas oublier parce qu'il y a beaucoup de choses dans cette vidéo.

Donc je vous ai présenter les méthodes.

Je vous ai montré donc comment en créer une avec le mot-clé statique très important et ensuite on va pouvoir regarder un petit peu tout ce qui est création d'une méthode un peu plus enrichie, donc on verra ça par la suite. On va le voir d'ailleurs même tout de suite, ici. On va aller là et on va créer un autre type de méthode, alors.
```java
public class App
{
	public static void main (String []args)
	{

	}
}
```
L'autre type de méthode qui va nous intéresser ici, c'est une méthode déjà qui peut retourner une information, d'accord, mais comment faire une méthode qui a une valeur de retour ?

C'est très simple donc on fait public static par exemple, je vais mettre getNumberTwo() alors c'est évidemment une méthode qui est inutile mais encore une fois c'est vraiment pour vous comprenez le principe.
```java
public class App
{
	public static void main (String []args)
	{

	}
	
	public static int getNumberTwo()
	{
		
	}
}
```
Alors ça c'est pareil je vais prendre le temps de bien expliquer parce que sur d'autres cours c'est souvent quelque chose qui est assez mal compris pour les gens qui débutent parce qu'il y a en fait le retour de fonction.

Les gens ne comprennent pas forcément donc je vais essayer de l'expliquer encore d'une autre manière pour vous que vous ayez toujours différentes explications selon le cours que vous suivez.

Alors là, le principe en fait c'est ceci. 
```java
public class App
{
	public static void main (String []args)
	{

	}
	
	public static int getNumberTwo()
	{
		return 2;
	}
}
```
Déjà je vois que j'ai oublié le type de retour (int), bravo ! on oublie la moitié des choses voilà.

Donc toujours le mode accessibilité (public), le mot clé static, important parce qu'on est dans la classe principale du programme où il y a la méthode main et le type de retour (int). Vous savez maintenant ce que sont les types de variables, des données, on a vu ça dans une vidéo bien avant donc ça veut dire simplement que cette méthode getNumberTwo, elle va retourner un entier donc automatiquement, la compilation au niveau de java , va attendre ... le compilateur, forcément à un moment donné que nous retournons un entier donc celle qu'il y a ici parce que c'est ce que je fais au plus simple je fais return 2 puisque j'ai appelé ma méthode getNumberTwo(), on retourne le nombre Two donc c'est histoire d'être assez cohérent et là le truc qui est pratique, bah c'est qu'au final, j'ai plus qu'a faire ça, alors que vous pouvez passer par l'intermédiaire mais c'est pas obligatoire, en faisant ceci. Donc j'appelle voyez ma méthode dans la méthode println() et là.
```java
public class App
{
	public static void main (String []args)
	{
		System.out.println(getNumberTwo());
	}
	
	public static int getNumberTwo()
	{
		return 2;
	}
}
```
```powershell
	>javac App.java
	>java App
	2
```
Au final, en faisant juste ça, je vais bien avoir le nombre 2 qui est affiché.

On aurait pu bien sûr dire number et décalé ici la récupération pour faire en 2 étapes en fait. On fait ça `int number ...` et ensuite c'est le number qu'on affiche.
```java
public class App
{
	public static void main (String []args)
	{
		int number = getNumberTwo();
		System.out.println(number);
	}
	
	public static int getNumberTwo()
	{
		return 2;
	}
}
```
Mais maintenant vous avez compris là normalement le principe des variables donc vous savez que c'est équivalent, c'est juste qu'on passe par une varianble intermédiaire donc c'est exactement la même chose.

Donc voilà le principe, nous avons return qui est une instruction d'accord, c'est une instruction un peu particulière donc c'est pas une méthode, c'est vraiment une instruction qui dit : "tu vas retourner quelque chose" et ça fait pas que retourner une valeur, ça arrête en fait la méthode c'est-à-dire à partir du moment où il y a un return qui est exécuté, on termine la méthode même si on avait par exemple un autre code après d'accord genre ceci.
```java
public class App
{
	public static void main (String []args)
	{
		int number = getNumberTwo();
		System.out.println(number);
	}
	
	public static int getNumberTwo()
	{
		return 2;
		return 3;
		
		System.out.println("OK");
	}
}
```
Vous allez voir que ça ne va strictement rien changer. D'ailleurs je pense qu'il ne va pas être content. 
```powershell
	>javac App.java
	>java App
	2

	C:\Users\js201\OneDrive\Formations\FormationVideo\Ressources\Java\010_méthodes>javac App.java
	App.java:652: error: unreachable statement
					return 3;
					^
	App.java:654: error: unreachable statement
					System.out.println("OK");
					^
	2 errors
```
euh oui je pense que de toute façon Java, il y a des langages qui acceptent ça mais de ce que je me souviens Java n'aime pas qu'on fasse par exemple plusieurs return comme ça parce qu'en fait on n'a pas par exemple gérer des conditions.

Donc en gros, de toute façon vous voyez que ça ne marche même pas.

Vous avez des erreurs de compilation qui vous dit que de toute manière, il manque des infos ou alors il y a tout simplement trop de return ici donc ça ne va pas donc on ne peut pas faire ça.

En gros à partir du moment où il a exécuté celle là `return 2;`, on sort directement de la méthode donc on se retrouve ici à nouveau dans la méthode main.

Donc bah tout ce qui est fait après en fait ne serait pas exécuté.

Alors bien évidemment, on peut avoir plusieurs return en fonction des conditions par exemple, on va avoir je ne sais pas moi, on va mettre genre getNumber(), vous allez voir. On peut faire ceci donc on change un petit peu, voilà et puis on peut dire ceci alors c'est un peu bizarre aussi mais j'sais pas moi, je peux mettre ça comme ça.

On va mettre un boolean, je ne sais pas forcément comment on va l'appeler bon peu importe comme par exemple ce genre de chose `info` et du coup on fera ça `if(info)` donc si c'est vrai ainsi si info est égal à 1 donc à true et on va faire par exemple `return 1` et sinon on peut faire `return 0;` (ne pas oublier le ;).
```java
public class App
{
	public static void main (String []args)
	{
		int number = getNumber();
		System.out.println(number);
	}
	
	public static int getNumber()
	{
		boolean info = 1;
		
		if(info)
			return 1;
		else
			return 0;
	}
}
```
Et du coup en fonction de la valeur qu'a pris ici là variable...
```powershell
	>javac App.java
	App.java:698: error: incompatible types: int cannot be converted to boolean
					boolean info = 1;
								   ^
```
Alors oui évidemment, il n'est pas content voilà donc c'est bien un entier que je retourne.
C'est parce que j'avais mit le 1 ici et c'est ça qu'il n'aime pas. 
```java
public class App
{
	public static void main (String []args)
	{
		int number = getNumber();
		System.out.println(number);
	}
	
	public static int getNumber()
	{
		boolean info = true; //remplacement 1 --> true
		
		if(info)
			return 1;
		else
			return 0;
	}
}
```
```powershell
	>javac App.java
	>java App
	1
```
Donc là, vous voyez qu'il affiche 1 puisque c'est égal à true et là si c'était false.
```java
public class App
{
	public static void main (String []args)
	{
		int number = getNumber();
		System.out.println(number);
	}
	
	public static int getNumber()
	{
		boolean info = false;
		
		if(info)
			return 1;
		else
			return 0;
	}
}
```
```powershell
	>javac App.java
	>java App
	0
```
Si c'était à false, il va aller dans le ELSE donc il va retourner autre chose.

Donc dans ce cas là, je peux avoir plusieurs return mais ça veut dire dans tous les cas qu'il ne pourra pas exécuter les 2. Il va pouvoir en exécuter qu'un seul des 2 donc à ce moment-là, ça ne pose pas de souci.

Par contre, si on faisait dans une méthode, une instruction où il devrait exécuter plusieurs return, pas possible, parce qu'à partir du moment où il en a fait un comme je vous ai dit, on sort de la méthode donc c'est plus possible d'exécuter la suite.

Donc voilà en quoi ça consiste, ça veut dire simplement, tu retourne une donnée et là donnée, elle est de quel type ? ben tu type que vous avez renseigné ici.
```java
	public static --> int <-- getNumber()
	{
		
	}
```
Donc par exemple ici, je ne peux pas m'amusé à retourner une chaîne de caractères où ce genre de chose.
```java
		if(info)
			return "ok";
		else
			return "pas ok"
```
Sinon à ce moment-là il faudrait mettre ce genre de choses et là pareil, il va faire autre chose genre `"pas ok"` comme ça d'accord. Il faut vraiment respecter le type ici qui vous est retournez donc attention à ça par rapport au type de retour.
```java
public class App
{
	public static void main (String []args)
	{
		int number = getNumber();
		System.out.println(number);
	}
	
	public static String getNumber()
	{
		boolean info = false;
		
		if(info)
			return "ok";
		else
			return "pas ok"
	}
}
```
Donc voilà ce qu'on peut faire, si vous n'avez rien à retourner dire, si il n'y a aucune instruction return dans votre programme comme on l'a vu jusqu à présent et bien évidemment, comme pour la méthode main, on dira que le type de retour est void. En fait ça veut dire rien, rien du tout.
```java
public class App
{
	public static void main (String []args)
	{
		int number = getNumber();
		System.out.println(number);
	}
	
	public static void getNumber()
	{

	}
}
```
...mais il faut vraiment indiquer explicitement que cette méthode ne retourne rien comme ça au moins Ben À la lecture, on arrive bien identifier justement s'il y a quelque chose qui est retourné ou non.

Donc voilà pour cette partie là.

Passons à une autre séquence maintenant concernant les paramètres c'est-à-dire que l'inverse.

Donc une méthode comme je l'ai dit, peut retourner quelque chose ou non mais une méthode peut aussi prendre des paramètres ou non. 

On va faire ça.
```java
public class App
{
	public static void main (String []args)
	{
		say("Hello !");
	}
	
	public static void say()
	{

	}
}
```
Je veux une méthode qui prend comme paramètre ici say(ICI), une chaîne de caractères donc on l'avait appelé say(), elle ne retourne rien puisqu'on ne veux pas qu'elle retourne quoi que ce soit en particulier, on n'en a pas forcément besoin. Par contre, elle va prendre en paramètre un message et ce qu'elle va faire ici, alors ça n'a aucun intérêt encore une fois comme exemple dans un cas réel parce qu'on a une fonction, une méthode ici qui ne fait qu'un affichage donc ça serait quand même très peu pour avoir besoin de faire une méthode pour ça.
```java
public class App
{
	public static void main (String []args)
	{
		say("Hello !");
	}
	
	public static void say(String msg)
	{
		System.out.println(msg);
	}
}
```
Et en gros, elle va afficher le message voilà. Donc on peut faire ça.
Et là évidemment, si on compile tout ça et qu'on exécute, ça fonctionne.
```powershell
	>javac App.java
	>java App
	Hello !
```
On lui a passé en fait en paramètre une information, on dit en fait que cette méthode say(), elle a besoin d'un paramètre qui est de type String, donc une chaîne de caractères et que nous allons stocker temporairement dans une variable qui s'appellera MSG.

Cette variable aura comme durée de vie et bien la méthode d'accord. Comme pour ce qu'on a vu ici dans les variables dans main. Quand je vous crée une variable dans le main, si je fais ça `int age...` par exemple.
```java
public class App
{
	public static void main (String []args)
	{
		int age = 0;
		say("Hello !");
	}
	
	public static void say(String msg)
	{
		System.out.println(msg);
	}
}
```
Cette variable `int age`, n'existe que dans main et elle va être détruite à la fin de la méthode main.

Du coup cette variable MSG que j'ai affiché là.
```java
	public static void say(String msg)
	{
		System.out.println(msg); <--
	}
```
Elle n'existe pas dans main d'accord. C'est bien séparé.

D'ailleurs si j'essaye de faire... alors on va faire ça, l'affichage ici dans main.
```java
public class App
{
	public static void main (String []args)
	{
		say("Hello !");
		System.out.println(msg);
	}
	
	public static void say(String msg)
	{
		System.out.println(msg);
	}
}
```
Vous allez voir qu(à la compilation, la machine ne va pas être très contente.
```powershell
	>javac App.java
	App.java:904: error: cannot find symbol
					System.out.println(msg);
									   ^
	  symbol:   variable msg
	  location: class App
	1 error
```
Voilà, tout simplement, il me dit voilà tout simplement que la variable MSG ici, en fait il ne la trouve pas d'accord.

`cannot find symbol` donc il ne trouve pas cette variable. Elles sont bien séparés d'accord.

Cette variable ici `msg` n'existe que dans son contexte dans cette méthode et pas ailleurs. 

Si vraiment vous voulez récupérer cette information éventuellement, on pourrait faire ce genre de choses, ce qui pour le coup est assez bizarre. On dirait ça donc on affiche le message et ensuite return MSG et du coup ici, dans main, on fait `String msg = say("Hello !")` et on récupère donc on peut très bien faire ça.
```java
public class App
{
	public static void main (String []args)
	{
		String msg = say("Hello !");
		System.out.println(msg);
	}
	
	public static String say(String msg)
	{
		System.out.println(msg);
		return msg;
	}
}
```
On peut très bien faire ça, dire que dans une varibale, on lui affecte un appel de méthode. 
Qu'est-ce que ça va faire alors ?
```powershell
	>javac App.java
	>java App
	Hello !
	Hello !
```
C'est ça d'accord. Donc là, ça a fait ça, je vous montre un petit peu ici.
Donc ici on déclare une variable MSG, on va lui affecter un appel à une méthode.
```java
	String msg = say("Hello !");
```
Donc on appelle cette méthode, elle prend en paramètre une chaîne de caractères. On l'a bien indiqué donc c'est bon il n'y aura pas d'erreur.
```java
	public static String say(String msg){}
```
Dans cette méthode, qu'est-ce qu'on fait ? On affiche sur la console le contenu de la MSG qui était `"Hello !"` ou avec un !, donc c'est effectivement affiché.

Ensuite on return MSG.

Donc on revient, donc on quitte cette méthode say(), on reviens dans main ici.
```java
	public static void main (String []args)
	{
		String msg = say("Hello !"); <--
		System.out.println(msg);
	}
```
Du coup le contenu de MSG qui était là `return msg;`, on la stocké dans cette variable MSG alors j'aurais pu mettre un autre nom (msg --> message), attention c'est vraiment quelque chose de différente voilà.
```java
public class App
{
	public static void main (String []args)
	{
		String message = say("Hello !");
		System.out.println(message);
	}
	
	public static String say(String msg)
	{
		System.out.println(msg);
		return msg;
	}
}
```
Voilà ça fonctionne aussi, je peux refaire ça.
```powershell
	>javac App.java
	>java App
	Hello !
	Hello !
```
c'est exactement la même chose d'accord parce qu'on a vraiment 2 variables distinctes.

Donc `return msg` c'est comme si j'avais dit : "bah grâce au return, ce que t'as mis là dedans, cette variable `msg`, tu va le stocker dans cette variable là `message` d'accord parce que vous voyez, elle est affecter `= say()`.

Donc en faisant ça, c'est comme si je disais ça en fait.
```java
	String message <-- say("Hello !");
```
Ce que retourne la méthode say(), tu le mets dans `message` qui est de type String, ça revient exactement à ça.

Et du coup bah comme ici après, on affiche message mais on a bien à nouveau le `"Hello !"` qui est affiché donc il n'y a pas de problème.

Ca veut dire qu'en plus, si on s'était amusé entre temps à faire ça.
```java
public class App
{
	public static void main (String []args)
	{
		String message = say("Hello !");
		System.out.println(message);
	}
	
	public static String say(String msg)
	{
		System.out.println(msg);
		msg = "World !";
		return msg;
	}
}
```
Voilà par contre, on aurait changé le message.
```powershell
	>javac App.java
	>java App
	Hello !
	World !
```
Puisqu'on a retourné ici de msg, ce n'est plus ce qu'on a passé en paramètre parce qu'on l'a modifié entre-temps mais comme on n'a pas encore vu tout ce qui est manipulation sur les chaînes de caractères dans le détail, on aura évidement, une vidéo spécialement pour ça donc on verra ça plus tard mais voilà en gros comment il faut comprendre.

J'ai bien pris le temps d'insister, ça rallonge un peu la vidéo mais c'est important parce que j'ai vu pas mal de gens qui galeraient avec ç&, pas comprendre justement ce principe d'une fonction, d'une méthode qui retourne quelque chose, qui est une info et j'ai vu beaucoup de gens faire des erreurs sur comment récupérer cette information là.

Ce n'est pas obligatoire d'avoir une méthode qui retourne quelque chose mais comrpenez que c'est le seul moyen en fait de passer des informations d'une méthode par exemple à une autre parce que ce qui existe dans say() ne peut pas exister dans main et inversement.

Le seul moyen de récupérer une info bah ici c'est de la passer en paramètre, d'accord, on peut très bien par exemple encore une fois faire ça aussi et pareil, vous êtes censé comprendre qu'on peut faire ça voilà.
Et ici du coup de dire que message c'est ça `message=say(message);`.
```java
public class App
{
	public static void main (String []args)
	{
		String message = "Hello !";
		
		message = say(message);
		System.out.println(message);
	}
	
	public static String say(String msg)
	{
		System.out.println(msg);
		msg = "World !";
		return msg;
	}
}
```
On peut également faire ça d'accord.
```powershell
		String message = "Hello !";
		
		message = say("Hello !");
```
Ca c'est juste qu'en fait, je passe par des choses intermédiaire, pareil, c'est exactement le même principe que je fasse l'appel direct où je passe par une variable, c'est tout pareil.

Si vous avez compris le cours que j'avais fait sur les variables logiquement ça vous devez parfaitement comprendre ce que je vous montre ici. Et ensuite on modifie l'info, on la récupère `return msg`, ça bien été modifié dans message `message = say(message);` et ici du coup on a effectivement `"World"` qui a été modifié.

Donc je peux recompiler, on verra que le changement que j'ai fait n'a aucune changement sur le résultat final, c'est exactement la même chose.
```powershell
	>javac App.java
	>java App
	Hello !
	World !
```
Voilà pour ça donc on a vu le principe des paramètres d'une méthode, on a vu comment elle peut retourner ou non quelque chose et on va rajouter un petit complément, c'est que évidemment une méthode peut prendre plusieurs paramètres. Donc il faudra qu'il soit précisé dans l'ordre.

Donc en gros par exemple, j'ai besoin ici d'un entier mais il faudra évidemment que l'appel ici, je le passe dans cet ordre là, d'accord.
```java
	String message = "Hello !";
	message = say(message, 2);
	//...
	public static String say(String msg, int nb)
```
Il faut que lors de l'appel, les paramètres que vous donnez, que ce soit des variables (message) ou des valeurs en dur (2) comme je le fais là. C'est que là en fait, je le passe par une variable et là je mets directement à la valeur en dur c'est-à-dire que je l'écris dans le code. Je ne pense pas par une variable, il faut qu'il soit dans le même ordre qu'ici évidemment.
```java
	public static String say(String msg, int nb)
```
Ici on va parler de la signature de la méthode qui dit bah cette méthode en premier, c'est important, elle prend une chaîne de caractères et en 2e elle prend un entier et pas l'inverse. Voilà comment ça fonctionne.

Alors petite particularité contrairement à d'autres langages par exemple comme le C++ ou le Python, on ne peut pas avoir d'arguments optionnels, on ne peut pas par exemple s'amuser à dire bah on fait ça.
```java
	public static String say(String msg, int nb=1)
```
Et du coup bah si le nombre ici, on ne propose pas en fait de nombres à l'appel et bah du coup, il y aura la valeur 1 qu'y sera mis par défaut.

Ce genre de chose d'accord, les paramètres avec des valeurs optionnel n'existe pas en Java.

Alors il y a des moyens de bricoler plus ou moins ça mais sachez que comme ça de manière, on va dire syntaxique, il n'y a pas moyen de le faire.

## Surcharge de méthode

Par contre il y a une chose très importante et qui là dû peut servir, c'est la surcharge de méthode.

La surcharge de méthode, ce qui est pratique et bien c'est qu'en fonction des informations que nous allons passer, la machine virtuelle à l'exécution pourra exécuter une ou autre méthode en fonction des paramètres que vous lui donnez.

Alors on va regarder un truc très simple je pense que c'est l'exemple qui est repris très souvent quand on parle de la surcharge de méthode en Java.
```java
public class App
{
	public static void main (String []args)
	{

	}
}
```
On va faire simplement ceci par exemple je vais donner 2, 5. 
```java
public class App
{
	public static void main (String []args)
	{
		sum(2, 5);
	}
}
```
Alors, je ne vais pas passer par des variables intermédiaires, on va faire juste ça comme ça.
voilà donc je vais pouvoir faire ça `System.out.println(sum(2, 5));` et aussi pouvoir faire ça `System.out.println(sum(2.3, 5.6));`.
```java
public class App
{
	public static void main (String []args)
	{
		System.out.println(sum(2, 5));
		System.out.println(sum(2.3, 5.6));
	}
}
```
On est d'accord qu'en termes de type de données, c'est différent. 
Ici (2, 5) nous avons des entier et ici (2.3, 5.6) nous avons des flottant.
vous savez que Java a 2 types différents pour ça d'accord, on pourrait sans problème se dire bon bah ça `sum(2, 5)` en fait c'est équivalent à 2.0, on pourrait sans problème traduire cette information en flottant sans perdre de l'information par contre ça `sum(2.3, 5.6)`, le convertir en entier, on perdrait la partie décimale donc là c'est assez embêtant donc ce qu'on peut faire en Java, très pratique c'est faire de la surcharge de méthode.

Comment ça fonctionne ? bah c'est très simple, vous faites comme on a vu, comme ceci.
```java
public class App
{
	public static void main (String []args)
	{
		System.out.println(sum(2, 5));
		System.out.println(sum(2.3, 5.6));
	}
	
	public static
}
```
Et je peux dire que j'ai une première méthode, je veux pouvoir faire l'addition d'entiers donc elle va forcément retourner un résultat entier.

Donc int sum(), elle prend un nombre a de type entier et un nombre b de type entier, et cette méthode, elle fait simplement A + B.
```java
public class App
{
	public static void main (String []args)
	{
		System.out.println(sum(2, 5));
		System.out.println(sum(2.3, 5.6));
	}
	
	public static int sum(int a, int b)
	{
		return a + b;
	}
}
```
Ensuite, je fait une autre méthode pareil mais qui elle pour le coup, retourne un float d'accord, on pourrait mettre un double mais bon peu importe on va mettre float, et je lui donne le même nom `sum()`.

(par contre pourquoi il me prend pas ... Ah parce que des fois, il est un peu bizarre l'éditeur voilà, tant qu'il n'y a pas les parenthèses, il ne change pas la couleur parce que je ne me suis quand même pas gourré. Je fait gaffe parce que des fois entre tout les langages de programmation, les noms pour les types de données ne sont pas forcément tous identiques donc des fois, je pourrais me tromper donc je préfère vérifier avant. float est bien en Java, il n'y a pas de problème.)

Et on fait ça.
```java
public class App
{
	public static void main (String []args)
	{
		System.out.println(sum(2, 5));
		System.out.println(sum(2.3, 5.6));
	}
	
	public static int sum(int a, int b)
	{
		return a + b;
	}
	
	public static float sum(float a, float b)
	{
		
	}
}
```
Alors évidemment comme pour une variable logiquement on ne devrait pas pouvoir avoir des méthodes qui portent le même nom d'accord sinon bah évidemment ça entrait en conflit comme pour des variables on ne peut pas dans un même endroit par exemple faire ça et puis ensuite de faire ça.
```java
public class App
{
	public static void main (String []args)
	{
		int a = 5;
		int a = 14;
		System.out.println(sum(2, 5));
		System.out.println(sum(2.3, 5.6));
	}
	
	public static int sum(int a, int b)
	{
		return a + b;
	}
	
	public static float sum(float a, float b)
	{
		
	}
}
```
...il y aurait un problème parce qu'on a une double déclaration d'une variable qui existe déjà donc ça n'est pas possible.

Par contre pour les méthodes, on peut et on aura du coup une surcharge. Pourquoi on peut ? parce que si on regarde la signature de ces méthodes, elles sont différentes. 
```java
	public static int sum(int a, int b)
	public static float sum(float a, float b)
```
Elles ont peut être le même nom mais elles ne prennent pas... elles ne renvoient pas la même chose ou elles ne prennent pas les mêmes paramètres et elle bah c'est carrément les 2 qui change c'est les paramètres sont différents et en plus le type de retour est différent.

Donc comment ça va se passer ? quand on va appeler ici la méthode sum().
```java
		System.out.println(sum(2, 5));
							^
```
Voyez là, on n'a pas d'indicateur de celle qu'on veut appeler en particulier. C'est Java donc la machine virtuelle à l'exécution qui va dire bah là tu me passes des informations comme ça est-ce que le 2 et le 5 c'est plus proche de entier au plus proche de flotant ? Et en fonction, il appellera la bonne méthode. 

Et ici 2,3 et 5,6 est-ce que c'est plutôt des entiers où est-ce que c'est plutôt des flottant et du coup l'exécution, on va tester.
```java
public class App
{
	public static void main (String []args)
	{
		System.out.println(sum(2, 5));
		System.out.println(sum(2.3, 5.6));
	}
	
	public static int sum(int a, int b)
	{
		return a + b;
	}
	
	public static float sum(float a, float b)
	{
		
	}
}
```
```powershell
	>javac App.java
	error: no suitable method found for sum(double,double)
					System.out.println(sum(2.3, 5.6));
									   ^
```
Alors qu'est-ce qu'il dit ? `no suitable method found`, pourquoi ? qu'est-ce qui ne va pas ? peut-être qu'il n'est pas content, préférerais les double, on va lui passer des double ici mais non, c'est surtout qu'il manque le retour. 

Voilà par contre comme il a peur qu'il y ait des pertes d'informations, il préfère qu'on passe DOUBLE pas de problème. On fait ça, voilà.
```java
public class App
{
	public static void main(String []args)
	{
		System.out.println(sum(2, 5));
		System.out.println(sum(2.3, 5.6));
	}
	
	public static int sum(int a, int b)
	{
		return a + b;
	}
	
	public static double sum(double a, double b)
	{
		return a + b;
	}
}
```
```powershell
	>javac App.java
	>java App
	7
	7.8999999999999995
```
Voilà, ici on a du coup on a un calcul qui est très précis `7.8999999999999995` par rapport à ça.

Et là évidemment, on a un calcul qui est fait sur des entiers `7` donc c'est automatiquement Java qui s'est occupé d'appeler la bonne méthode donc ça c'est ce qu'on appelle la surcharge de méthode.

Vous mettez le même nom mais vous passez pas les mêmes types de données d'accord, ça ne renvoie pas forcément le même type de données et du coup bah c'est Java qui choisira un petit peu quelle méthode il appelle en fonction donc des cas d'accord. 

C'est au cas par cas, il va analyser les données que vous donnez et que vous passez et il saura du coup quelle méthode appeler au mieux alors c'est pas, comment dire, ça ne peut pas me présenter aucune erreur à 100%, donc faut faire attention, faut avoir vraiment des méthodes qui sont quand même différente dans les données qu'elles gèrent pour que évidemment Java puisse ne pas se tromper en fonction.

Donc c'est sur des nombres comme ça, généralement il s'en sort bien mais il faut faire attention voilà qui n'est pas non plus trop de similitudes pour que bien évidemment, vous vous attendiez à ce que telle méthode soit utilisée et en résultat, on se rendrait compte que bah c'est pas le cas du tout.

Mais il faut bien choisir par rapport à ça et voilà en tout cas une possibilité justement par rapport à la surcharge de méthode en Java.

Voilà donc on a fait déjà le tour sur les méthodes on a vu comment utiliser les méthodes comme on l'a toujours fait donc maintenant vous savez ce qu'est println() et cetera dans le détail, que ce n'est pas juste là pour faire joli, c'est pas une simple instruction, c'est réellement l'appel d'une méthode avec des objet d'accord mais ça on en parlera plus tard, les package, les objets et cetera.

Et on peut du coup appeler tout un tas de méthodes donc on les reconnaît facilement avec des parenthèses ici.
```java
	...main()
	System.out.println()
	sum(int a, int b)
	sum(double a, double b)...
```
...et de créer vos propres méthodes avec ou sans paramètres, avec ou sans valeur de retour, sans donnée en fait qui est retournée quand on termine en fait cette méthode donc ça c'est un premier point.

Maintenant on revient parce que encore une fois Java est un langage qui permet de programmer en objet, qui nécessitent de programmer un objet donc on va adapter ce fonctionnement maintenant aux méthodes lié à une classe qui sont quand même assez particulières et notamment une méthode qui est très importante qui est le constructeur qui vous allez voir un peu comment ça fonctionne.

Alors ici on va virer tout ça, je vous avais dit que cette vidéo était un peu longue puisqu'il a vraiment plein de choses mais c'est très important et ensuite on va aller dans le dossier Java ici et alors on va créer Player.java, ça c'est un exemple que je prends très souvent dans mes vidéos.

Player.java, voilà okay et ensuite du coup on fait, je rappelle le constructeur est un cas particulier, il n'y a pas de type de retour par rapport à lui parce que c'est une méthode un peu à part.

+ Player.java
```java
public class Player
{
	public Player()
	{
		
	}
}
```
Mais il va y avoir quelque chose de très intéressant c'est-à-dire moi je vais pouvoir faire ça. Dire là, j'en crée un premier comme ceci, je lui passe aucune information d'accord.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		Player p1 = new Player();
	}
}
```
et je veux pouvoir en créer un autre, où je veux pouvoir lui passer obligatoiremnet un nom.
```java
public class App
{
	public static void main(String []args)
	{
		Player p1 = new Player();
		Player p2 = new Player("Jason");
	}
}
```
et je vais lui en passer un autre où je dois lui passer un nom et par exemple un niveau de joueur, ce genre de chose.
```java
public class App
{
	public static void main(String []args)
	{
		Player p1 = new Player();
		Player p2 = new Player("Jason");
		Player p3 = new Player("Jason", 1);
	}
}
```
Et ça va pouvoir fonctionner tout ça donc là ça va être très intéressant puisqu'on va pouvoir déjà bon surcharger notre constructeur qui en fait une méthode, c'est une méthode comme une autre, par rapport à ce comportement là. -->
```java
public class Player
{
	public Player()
	{
		
	}
}
```
Et du coup, on va pouvoir un petit peu avoir ce principe en fait de simuler un petit peu des caractères optionnels parce que là, en gros, on lui dit bah t'es pas obligé en fait de passer des informations quand tu instancie un joueur. Si tu lis pas ces 2 informations là `("Jason", 1)` et bah pas de souci, si tu lis qu'un nom, bah il se débrouillera pour le niveau parce qu'on voudra que nos joueurs ait un niveau obligatoirement et si tu lui passe rien et bien, on va affecter un nom de joueur par défaut et une valeur pour le niveau par défaut.

Rt du coup pour faire ça mais on va devoir écrire 3 constructeurs dont 3 méthodes pour faire marcher justement cette surcharge de méthode comme on l'a vu tout à l'heure.

Alors si on n'a rien, alors déjà on a toutes les informations là d'ailleurs.

Petite parenthèse, j'avais une petite bêtise dans le dans le cours précédent. Je vous avez dit qu'ici au niveau des attributs, pour une classe, si on avait par exemple juste ça `String mName;`.
```java
public class Player
{
	public Player()
	{
		
	}
	
	String mName;
}
```
Si on a juste ça `String mName;`, l'attribut est privée par défaut alors pas en Java justement, c'est pour ça que Java est un petit peu compliqué par rapport à ça, c'est tout l'inverse Java par défaut, si vous ne mettez aucun mot-clé pour l'accessibilité, tout est les publics. Ce qui n'est pas forcément le cadre d'autres langages.

Il y a d'autres langages quand on met rien, c'est en privé par défaut. Pour Java c'est en public par défaut donc très important de ne pas oublier le mot clé comme ceci.
```java
public class Player
{
	public Player()
	{
		
	}
	
	private String mName;
}
```
Je m'étais trompée, je vous avais dit que c'était plus privé par défaut, non pas en Java, c'est public. 
Donc là on fait ça `private String mName;` et ensuite on va avoir du coup un mLevel, ces 2 informations là.
```java
public class Player
{
	public Player()
	{
		
	}
	
	private String mName;
	private int mLevel;
}
```
Donc on va avoir 3 constructeurs en gros ça, donc le premier qui demande un nom et un autre qui va demander le nom du joueur et un niveau voilà.
```java
public class Player
{
	public Player()
	{
		
	}
	
	public Player(String name)
	{
		
	}
	
	public Player(String name, int level)
	{
		
	}
	
	private String mName;
	private int mLevel;
}
```
Et là vous allez voir du coup l'utilité en fait de cette surcharge de méthode qui fonctionne très bien pour le constructeur parce que vous aller voir du coup ces 3 instanciation vont marcher sans problème.

Donc là si j'ai toutes les infos Ben c'est toujours très simple, là c'est juste de l'affectation en gros, on va prendre l'habitude de mettre le THIS comme ça voilà c'est beaucoup plus explicite surtout au niveau de la coloration et on fait ceci, pas de problème. 
```java
public class Player
{
	public Player()
	{
		
	}
	
	public Player(String name)
	{
		
	}
	
	public Player(String name, int level)
	{
		this.mName = name;
		this.mLevel = level;
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	private String mName;
	private int mLevel;
}
```
Et la du coup on va afficher this.mName + ' - ' + this.mLevel
Je sais qu'encore une fois, on n'a pas vu grand-chose sur tout ce qui est manipulation de chaîne mais il va y avoir encore une fois une vidéo dessus donc on verra tout ça dans le détail voilà.
On va le répéter du coup ici puisque toute façon, histoire de voir qu'on est bien passé par chacune des méthodes en particulier.
```java
public class Player
{
	public Player()
	{
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	public Player(String name)
	{
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	public Player(String name, int level)
	{
		this.mName = name;
		this.mLevel = level;
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	private String mName;
	private int mLevel;
}
```
Et puis là `Player(String name)`, le nom pas de souci, on l'a donné mais comme on n'a pas passé ici de choses pour le niveau et bien plutôt que de faire ce qu'on pourrait faire dans d'autres langages de programmation c'est-à-dire par exemple genre ceci `int level=1`. 
```java
public class Player
{
	public Player()
	{
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	public Player(String name, int level=1)
	{									^
		this.mName = name;
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	public Player(String name, int level)
	{
		this.mName = name;
		this.mLevel = level;
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	private String mName;
	private int mLevel;
}
```
`int level=1`, ça on ne peut pas le faire en java, pas de problème, on va le faire directement là, bah comme on n'a passé aucun niveau et bien par défaut, on le met à 1, ce genre de choses `this.level = 1;`.
```java
public class Player
{
	public Player()
	{
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	public Player(String name, int level=1)
	{									^
		this.mName = name;
		this.mlevel = 1;
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	public Player(String name, int level)
	{
		this.mName = name;
		this.mLevel = level;
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	private String mName;
	private int mLevel;
}
```
D'ailleurs ici on va peut-être le mettre autrement, voilà.
```java
Player p3 = new Player("Jason", 1); --> Player p3 = new Player("Jason", 5);
```
```java
public class App
{
	public static void main(String []args)
	{
		Player p1 = new Player();
		Player p2 = new Player("Jason");
		Player p3 = new Player("Jason", 5);
	}
}
```
Et ensuite si on n'a rien comme information ici. On met un nom `"Inconnu"` et ici un niveau ici de 1, voilà pour tout.
```java
public class Player
{
	public Player()
	{
		this.mName = "Inconnu";
		this.mLevel = 1;
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	public Player(String name, int level=1)
	{									^
		this.mName = name;
		this.mlevel = 1;
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	public Player(String name, int level)
	{
		this.mName = name;
		this.mLevel = level;
		System.out.print(this.mName + ' - ' + this.mLevel);
	}
	
	private String mName;
	private int mLevel;
}
```
Donc là 3 constructeurs donc 3 méthodes qui vont utiliser le principe de la surcharge en fonction des paramètres ici (App.java) que nous donnons ou pas.

Donc du coup, on va pouvoir créer des joueurs sans aucun paramètre ou des joueurs avec la totalité des paramètres ou que celui là `"Jason"`.

Par contre je n'ai pas fait une méthode qui me prendrait par exemple que le level. Il faudrait faire une autre méthode où on a en fait que `int level` mais bon là pour le coup, pas forcément utile.

Donc à partir de là, je n'ai plus qu'a exécuter tout ça.

Alors oui c'est normal, il faut maintenant compiler plusieurs fichiers Java. Tout à l'heure, j'en avais qu'un seul.

[Erreur de compilation] ...pourquoi j'ai oublié quelque chose... qu'est-ce que j'ai fait comme bêtise, je suis allé trop vite sur quelque chose ...okay c'est normal, j'ai déjà un truc en trop. On va y arriver à force donc on exécute et voilà comment ça marche alors là bon vous voyez que sans problème.
```java
System.out.print(this.mName + ' - ' + this.mLevel); --> 
System.out.print(this.mName);
System.out.println(this.mLevel);
```
```java
public class Player
{
	public Player()
	{
		this.mName = "Inconnu";
		this.mLevel = 1;
		System.out.print(this.mName);
		System.out.println(this.mLevel);
	}
	
	public Player(String name)
	{
		this.mName = name;
		this.mlevel = 1;
		System.out.print(this.mName);
		System.out.println(this.mLevel);
	}
	
	public Player(String name, int level)
	{
		this.mName = name;
		this.mLevel = level;
		System.out.print(this.mName);
		System.out.println(this.mLevel);
	}
	
	private String mName;
	private int mLevel;
}
```
```powershell
	>javac *.java
	>java App
	Inconnu1
	Jason1
	Jason5
```
Alors oui d'ailleurs j'ai mis un print (au lieu de println), ici j'aurais pu mais... c'est pas grave, il m'as colé la variable mais c'est pas gênant donc on voit encore une fois, si on suit les appelles ici, il y a eu en tout cas les instanciations.

Quand je ne passe rien, il a bien mis le nom par défaut et le niveau par défaut.
Si je passe un nom, il a mis le nom que j'ai choisi mais il a mis le niveau par défaut.
Et si je passe les 2 informations, évidemment les 2 informations sont bien complétées au niveau des attributs de la classe.

Voilà donc ça c'est tout à fait un cas d'utilisation du principe donc de la surcharge de méthode, de pouvoir comme ça, avoir ce principe de au final de paramètre optionnel, on peut le gérer de cette manière là.

Et pour un constructeur, c'est pratique parce que généralement, on va faire dans ce qu'on appelle le constructeur par défaut, donc un constructeur par défaut, il n'y a aucun paramètre, on va remplir ça rapidement.

Vous verrez quand vous aurez besoin de faire des tests ou autre, de créer bah plein d'instanciations. Avec ce constructeur là `public Player()`, ça amène des informations justement par défaut pour éviter de devoir noter manuellement et ensuite généralement on fait un constructeur complet.
```java
public class Player
{
	public Player()
	{
		this.mName = "Inconnu";
		this.mLevel = 1;
		System.out.print(this.mName);
		System.out.println(this.mLevel);
	}
	
	public Player(String name, int level)
	{
		this.mName = name;
		this.mLevel = level;
		System.out.print(this.mName);
		System.out.println(this.mLevel);
	}
	
	private String mName;
	private int mLevel;
}
```
Voilà c'est rare qu'on en fasse plus que ça. Généralement on fait au minimum c'est 2 là, un par défaut et un avec tous les paramètres nécessaires pour compléter les attributs de notre classe. 
```java
public class App
{
	public static void main(String []args)
	{
		Player p1 = new Player();
		Player p3 = new Player("Jason", 5);
	}
}
```
Voilà un petit peu comment fonctionne cette surcharge de méthode.

Alors je regarde un petit peu sur mon papier si j'ai rien oublié, on verra également tout ce qui est paramètres variables d'accord dans une méthode, on peut faire ça aussi mais comme ça fait appel à des tableaux et qu'on n'a pas encore vu les tableaux donc j'aborderai, je pense, les paramètres variables pour une méthode quand on abordera la vidéo concernant les tableaux.

Et je crois qu'on a fait le tour voilà bah je pense que tout est dit par rapport à ça.

On a fini cette vidéo et par rapport à tout ce que je voulais vous montrer donc faut pas hésiter, vraiment les choses importantes à ça... pas hésité vraiment à vous servir de cette surcharge quand vous avez besoin comme ça de plusieurs méthodes qui manipulent des types de données différents et dans le cas ici d'une classe en particulier d'avoir ça.

Alors pour terminer pour finir, quand on veut créer par exemple une méthode ici, au niveau de notre personnage, alors notre joueur donc on va faire genre juste ça. Je vais rester sur notre constructeur par défaut. Je vais virer celui là, voilà. 
```java
public class Player
{
	public Player()
	{
		this.mName = "Inconnu";
		this.mLevel = 1;
		System.out.print(this.mName);
		System.out.println(this.mLevel);
	}
	
	private String mName;
	private int mLevel;
}
```
Si à un moment donné bah je vais lui faire faire une action d'accord et bien là comme on n'est plus dans la classe principale comme on veut faire une méthode qui appartient à notre classe principale, ici joueur, on n'a plus qu'à la créer tout simplement sans le mot-clé statique.

Le mot-clé statique en fait ça veut simplement dire d'avoir une méthode qui serait accessible et qui utilisable sans créer de joueur mais nous on ne veut pas, par exemple, pouvoir faire attaquer un joueur qui n'aurait pas été créé, ça n'aurait aucun sens.

Donc on dit simplement, alors c'est une méthode qui ne va rien retourner mais elle va permettre d'attaquer, elle va rien prendre et par exemple on dira, alors on va simuler une attaque évidemment sans rien faire vraiment. Et on va dire du coup `this.mName + " attaque une cible !"`, ce genre de chose d'accord.
```java
public class Player
{
	public Player()
	{
		this.mName = "Inconnu";
		this.mLevel = 1;
		System.out.print(this.mName);
		System.out.println(this.mLevel);
	}
	
	public void attack()
	{
		System.out.print(this.mName + " attaque une cible !");
	}
	
	private String mName;
	private int mLevel;
}
```
Et du coup, une fois que notre joueur est créé. 

Pour faire l'appel et bien, c'est la variable en question, un points d'accord, c'est comme en fait ça `out.println`, vous voyez c'est un petit peu le même principe sauf que bon `out` ça appartient à un paquage en fait qui s'appelle `System`, c'est pour ça qu'on écrit tout ça `System.out.println` mais ça on en l'occasion de parler des packages plus tard.
```java
public class App
{
	public static void main(String []args)
	{
		Player p1 = new Player();
		p1.attack();
	}
}
```
Donc là, on dit p1, bien tu lui appelle sa méthode attack() donc là c'est logique parce que c'est une instance à `Player` donc il peut appeler une méthode qui appartient à cette classe.

On a créé un joueur donc à partir de ce moment-là, le joueur peut sans problème attaquer. C'est beaucoup plus logique comme ça.
```powershell
	>javac *.java
	>java App
	Inconnu1
	Inconnu attaque une cible !
```
Voilà inconnus attaquent une citoyenne, ça prend bien son paramètre, les attributs qu'on lui a donné donc voilà comment ça fonctionne.

Le mot-clé static quand vous voulez créer des méthodes dans la classe principale de votre programme (App.java) donc en fait la classe où vous avez la méthode main, vous créer des méthodes uniquement statique et par contre pour vos autres classes, vous créez des méthodes sans mot clé static sauf si vous vouliez éventuellement pouvoir appeler une méthode sans créer de joueur mais il faut en avoir encore une fois l'utilité. On peut le faire mais voilà dans la majorité des cas, vous vous contenterez de ça donc vous mettez directement ici (Player.java) une méthode (attack()) sans le mot-clé static. 

C'est tout ce qu'on a vu précédemment ici (Player.java) mais sauf que là on enlève juste le mot-clé static et ça fonctionne. 

Voilà un petit peu, j'ai vais vous laissé avec cette fin de vidéo, j'espère que c'était suffisamment explicite parce que pas forcément simple de tout expliquer parce qu'il y a plein de petits détails mais je n'ai rien rien oublier pour vous et pas forcément passer à côté de certaines choses puisque tout ce que vous aurez vu là et compris là mais évidemment ça ne va pas vous handicaper pour la suite ... et vu toutes les choses qu'il y aura à voir par la suite justement, c'est bien de pouvoir clarifier ces parties là pour commencer.

N'hésitez pas si il y a des questions, en tout cas, dans les commentaires liés à la vidéo encore une fois, je le rappelle et puis voilà Ben on se retrouvera du coup pour la prochaine séance sur ce cours de programmation en Java.

A bientôt tout le monde