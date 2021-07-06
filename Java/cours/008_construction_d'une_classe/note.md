# [8. Construction d'une classe](https://www.youtube.com/watch?v=IZ8wKErw0_Y)
	
Bonjour tout le monde bienvenue pour cette vidéo numéro 8 en Java.
	
On avait terminé la dernière fois avec les structures conditionnelles et les boucles d'accord, on a vu des choses très très simples et il est temps d'attaquer la partie principale de ce langage parce que Java est un langage objet.
	
Donc nous allons voir comment construire une classe et donc créer des objets puisque c'est vraiment tout l'intérêt justement de ce langage.

Donc je vous ai présenter encore une fois les petites notions basiques, on va dire élémentaires qu'on a programmation qu'on retrouve dans d'autres langages. 

Et très vite voilà, je voulais vous amener justement à la création d'une classe parce que pour moi c'est un élément vraiment essentiel à prendre en compte puisque comme vous l'aviez vu déjà précédemment Java est exclusivement construit sur des classes, on ne peut pas créer de programme Java sans utiliser de classe donc je voulais très rapidement revenir là dessus pour vous sachiez un petit peu surtout si c'est votre premier langage de programmation mais en quoi ça consiste, comment on crée ce ce genre de classe et qu'est-ce que c'est en fait, qu'est-ce qu'une classe et à quoi ça sert ?

On va repartir sur un script vide donc App.java, on a juste ce fichier de départ et on va voir un petit peu pour construire cette fois-ci, bien détaillé un petit peu la construction de la classe que nous avions jusqu à présent, d'accord. On va regarder tout ça.

Alors une classe, il faut le voir comme une espèce d'élément d'accord de votre programme qui pourra soit représenter une entité donc ça peut être par exemple pour représenter, j'sais pas, un étudiant, représenter un joueur dans un jeu vidéo, représenter une maison, représenter une ville voyez une entité où représenter une idée d'accord une idée, un concept.

Par exemple, dans un jeu vidéo si on veut gérer une partie son ,on va avoir un gestionnaire de son, on pourrait avoir du coup une classe qui s'occupe justement de la gestion du son, comme on pourrait avoir une classe qui s'occupe de tout ce qui est réseau d'accord, le multijoueur. Une classe pour la sauvegarde des données ou une classe pour tout ce qui est log, utilitaire, ce genre de choses donc il faut vraiment le voir comme ça, soit c'est une entité, soit c'est un concept ou une idée d'accord et ça représente différents éléments comme ça que nous allons séparer par classe. D'accord, vous allez avoir une entité par classe, un concept par classe et cetera.

Alors nous pour Java, comme il nous faut une classe de départ pour démarrer le programme, pour passer par la méthode main que je vais du coup détaillé par la suite.

On obligé de fournir une classe donc moi je l'ai appelé App pour application puisque c'est mon point de départ en fait; d'accord.

J'aurais pu l'appeler main pour dire voilà c'est le point de démarrage, de départ, peu importe vous mettez nom que voulez donc moi j'appelle ça App.

Il faut évidemment que la classe porte le même nom que le fichier et nous allons commencer déjà par un mot que vous avez mis au début sans que je vous l'explique qui va en fait indiquer la portée de votre classe.

La portée c'est tout simplement le niveau d'accès de cette classe.

Vous avez soit la portée public d'accord donc c'est un terme anglais attention qui veut dire que la classe , comme ça l'indique public, donc accessible partout sans restriction.

Vous avez éventuellement le mode d'accès private qui tu veux dire privé et dans ce cas-là la classe ne pourra pas en fait être accessible alors nous évidemment, comme on veut pouvoir lancer notre programme, on va travailler sur du public.

Alors un jour, vous verrez l'intérêt, on expliquera l'intérêt de créer des classes privé. Il y a peut être des gens qui disent : mais quel intérêt en fait ? on l'aborderais éventuellement. Pour le moment, sachez et prenez l'habitude dès le départ de créer évidemment une classe publique donc vous aurez du mal à créer et construire des objets à partir de cette classe là.
```java
	public
```
Ensuite, on indique le mot-clé de classe, évidemment `public class` et le nom de la classe donc moi ça va porter évidemment le ... il faut le même nom que le fichier.

Si votre fichier s'appelle App comme ça avec une majuscule, vous mettez le même nom pour la classe. 

Généralement un fichier, une classe, d'accord. On fait comme ça sinon vous aurez évidemment des erreurs à la compilation donc vous procédez ainsi. Une classe Java par fichier Java, c'est important.

On ouvre les accolades donc voilà ça on connais, pas de souci et là nous sommes à l'intérieur de la classe.
```java
	public class App
	{
		
	}
```
Obligatoirement Java comme d'autres langages de programmation compilé, a besoin d'une fonction ou d'une méthode main qui est le point d'entrée c'est-à-dire quand je vais exécuter mon programme ici la machine virtuelle Java va chercher une méthode main pour pouvoir démarrer le programme.

Si elle n'est pas là (main), vous aurez une erreur donc on est obligé de la mettre pour cette partie là.

Donc ça on va créer la méthode donc la méthode en fait c'est une fonction qui appartient à une classe d'accord à la différence d'une simple fonction.

Mais les fonctions en réalité n'existe pas en Java parce que comme je vous l'ai dit Java est exclusivement fait avec des classes donc on n'a pas de fonction puisque automatiquement tout ce que vous allez faire sera dans une classe donc ce sont des méthodes, il n'y a que le nom qui change le reste est exactement identique donc il y a une porté également pour les méthodes mais c'est pas une vidéo sur les méthodes, on en parlera plus après mais tout simplement voilà public, static donc ça c'est juste parce que c'est pour main, on expliquera aussi par la suite d'accord.
```java
public class App
{
	public static void main(String []args)
	{
		
	}
}
```
Et pour le moment tout ça je vous le le détail pas puisque c'est des choses qu'on verra plus tard, on reviendra sur la méthode main justement pour expliquer comment elle a été créé, pourquoi elle est faite comme ça.

Donc on a cette partie là d'accord et ici bon bah on va faire comme tout ce qu'on faisait avant c'est-à-dire vérifier déjà que tout fonctionne bien, un petit hello, terminé d'accord.
```java
public class App
{
	public static void main(String []args)
	{
		System.out.println("Hello");
	}
}
```
Là je vais compiler tout ça.
```powershell
	>javac App.java
	>java App
	Hello
```
javac App.java voilà okay et ensuite pour éxécuter java et là vous mettez que le nom c'est important. Ne mettez pas le point classe, point java et cetera.

C'est juste le nom tout seul sans extension donc ça fonctionne OK pas de problème à ce niveau-là.

Voilà pour ça, ça c'est le point de départ, c'est le minimum. Maintenant vous savez un petit peu à quoi en quoi ça consiste, on va évidemment bien détailler les classes est-ce qu'on peut trouver ce qu'on peut faire dans une classe dans des vidéos prochaine. 

Là on va juste construire une classe très simple mais bien sûr on verra qu'il y a plein d'autres choses que l'on peut ajouter dans une classe mais ça viendra dans les vidéos qui suiveront. On va pas tout voir que maintenant donc ça cest mon point de départ. 

Moi ça c'est pas suffisant ça c'est juste mon point de départ de mon programme mais je veux créer une classe alors on va créer des chats donc c'est un peu bizarre de dire ça, on va créer des chats mais oui vous êtes un tout puissant et vous allez créé des chats.

Donc on va créer un fichier d'accord donc je vais l'appeler Cat pour les chats point java que nous allons ouvrir. Ici même chose on va créer une classe publique pour représenter nos chats qui porte le même nom que le fichier public class Cat, OK voilà.
```java
public class Cat
{
	
}
```
Là vous avez le départ de votre classe et là comme il s'agit après par la suite de construire donc d'instancier des classes pour créer des objets d'accord, il va falloir que nous ayons un constructeur et le constructeur dans une classe c'est tout simplement une méthode d'accord.

C'est une méthode qui va permettre de construire notre objet.

Un objet c'est tout simplement quelque chose issu d'une classe d'accord qu'on peut créer en fait plusieurs fois donc chaque chat qui seront donc chacun un objet à pas, sera une instance de la classe Cat.

Alors il y a des mots peut-être un peu compliqué mais comme je vais souvent les répéter, souvent les expliquer avec des exemples tout ça, ça finira par rentrer naturellement, ne vous en faites pas si vous êtes un peu perdu avec les termes que j'emploie.

Donc là c'est public, on a un constructeur public sinon on ne pourra jamais l'utiliser donc ça sera un petit peu dommage mais d'autre part, il peut y avoir un intérêt de faire un constructeur privé, on verra ça bien par la suite et peut-être que même, vous avez déjà vu l'intérêt si vous avez suivi d'autres de mes formations sur la chaîne.

Et là on met directement le nom de la classe comme ceci `public Cat()` donc on met une majuscule d'accord c'est important toujours une majuscule, ça par convention de nom de classe, pour les noms de fichiers et du coup pour le constructeur même chose.

+ Cat.java
```java
public class Cat
{
	public Cat()
}
```
On ouvre ça avec des accolades je ne vais pas vous détailler pour le moment qu'est-ce que sont les méthodes et cetera, on verra ça par la suite plus en détail encore une fois.
```java
public class Cat
{
	public Cat()
	{
		
	}
}
```

Et voilà votre objet peut être construit d'accord. 

En tout cas de cette classe Cat, nous allons pouvoir créer des chats alors pour l'indiquer parce que là (App.java) sinon on aura aucun indicatif donc on se rendra pas compte que ça fonctionne, on va l'indiquer avec un petit texte parce que pour le moment on ne fera rien de plus d'accord. C'est vraiment une vidéo assez courte, on va vraiment juste voir la construction d'une classe sans plus. 

On va mettre : je suis un chat et nous allons concaténer, donc pour le moment, vous faites juste ça (+), pareil la concaténation on reviendra dessus par la suite de toute façon avec un mot-clé très particulier qui est une nouveauté donc on n'a pas vu jusqu à présent, qu'on n'avait pas vu avant, qui est le mot-clé `this`.

+ Cat.java
```java
public class Cat
{
	public Cat()
	{
		System.out.println("Je suis un chat " + this);
	}
}
```
Et le mot clé `this`, c'est tout simplement d'accord un terme qui va faire référence à l'objet que vous viendrez de créer d'accord. En fait quand vous allez créer un objet issu d'une classe, vous allez obtenir ce que je disais, une instance d'accord et `this` va tout simplement vous dire quel instance, c'est l'instance en cours, celle qui a, en fait, soit appelé le constructeur pour créer l'objet, soit plus tard comme on le verra, appelé d'autres méthodes.

Donc en fait quand vous allez créer un premier chat, il aura sa propre vie en fait d'accord, sa propre vie à lui donc il sera enfaite dans une zone mémoire. Si on parle en des termes techniques, il sera alloué dans une zone mémoire de votre ordinateur. Si vous créez un 2e chat, ce ne sera pas le même, ce sera un autre.

Donc `this` ici fera référence évidemment à des zones mémoire différents donc des objets différents et du coup si on suit la logique de notre programme, des chats différents d'accord.

Chaque chat sera une entitée bien distincte.

Donc on va mettre ça voilà : `"je suis un chat"` et on mettra du coup l'information comme ceci, ok avec `this`. 

Donc ça, c'est un mot clé à retenir, il faut vraiment le connaître par cœur, on retrouve également dans pas mal d'autres langages parce qu'on va beaucoup beaucoup utilisé et vous en aurez absolument besoin. Donc ça, il faut connaître.

Donc on fait ça et c'est parti, là nous allons donc créer nos chats donc on va le faire dans la méthode main() d'accord, parce que c'est notre point de départ de notre programme donc on sait que tout va se passer ici.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		// <--
	}
}
```
... On ne va pas pour le moment faire sur d'autres fichiers et cetera. On n'a pas encore vu comment hiérarchiser un peu notre programme donc on va partir là dessus.

Pour instancier d'accord une classe donc créer un objet à partir d'une classe, c'est très simple vous mettez le nom de votre classe d'accord, vous choisissez un nom parce que ça va être une variable d'accord.

Ce sera une variable qui sera du coup de type Cat donc un objet en fait que vous voulez. Moi je vais l'appeler miaou, vous mettez un égal puisque nous allons affecter ceci `miaou` et nous allons dire que nous allons créer une nouvelle instance donc on va faire new, le nom de la classe et ici `public Cat(RIEN)`, on le verra plus tard, comme je n'ai rien passé entre parenthèses, aucun paramètre, on verra plus tard qu'on pourra mettre des paramètres ici `public cat(ICI)` et bien je n'en mets pas au niveau de la construction ici de mon objet.

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		Cat miaou = new Cat();
	}
}
```
Et c'est tout là `miaou = new Cat()`, nous avons instancier d'accord, un chat OK.

Donc de classe, un objet de classe chat, qui sera stocké dans une variable qu'on a appelé ici miaou OK.

Donc, on y va. Vous compilé.
```powershell
	>javac App.java
	.\Cat.java:5: error: cannot find symbol
					System.out.printl("Je suis un chat " + this);
							  ^
	  symbol:   method printl(String)
	  location: variable out of type PrintStream
	1 error
```
Alors, j'ai peut-être fait une erreur quelque part. Oui j'ai mis pris printl donc déjà si on invente des noms de méthodes, ça va pas le faire, Ok.

Alors, petite distraction, ça je le dis pour ceux qui ont eu l'habitude de programmer dans d'autres langages comme le C, comme le C++ ou autre vous voyez que nulle part j'indique par exemple dans le fichier App comment accéder au fichier Cat d'accord.

Automatiquement pour Java comme on va compiler l'ensemble de nos fichiers, Java, il saura retrouver les fichiers qui vont bien.

Plus tard quand on travaillera sur des packages pour vraiment changer un peu la hiérarchie donc l'organisation de nos fichiers, on verra qu'il y aura des petites choses à modifier mais là comme tout est dans le même répertoire, ici il n'y aura aucun problème pour Java de tout retrouver donc pas besoin de dire bah voilà trouve le fichier Cat et cetera. Voilà tout fonctionne sans problème.

Par contre à la compilation, il va y avoir un changement. On va mettre javac c'est toujours pareil mais au lieu de mettre le nom App point java sinon on aura compilé que ce fichier là donc on va dire de compiler tous nos fichiers Java donc vous mettez simplement une étoile. Très important, si vous ne mettez pas ça, vous aurez des erreurs et ça marchera pas, terminé, on fais juste ça et ensuite pour l'exécution bah c'est comme si vous n'avez qu'un seul fichier, c'est le fichier qui a la méthode main d'accord, donc c'est le point d'entrée donc vous mettez App. Je fais ça j'exécute et là on voit que ça fonctionne.
```powershell
	>javac *.java
	>java App
	Je suis un chat Cat@3a71f4dd
```
Je suis un chat donc on vous avez le nom de l'objet, vous avez un `@` et ensuite vous avez une adresse mémoire donc en fait c'est l'emplacement mémoire de cet objet d'accord, c'est son identité mais c'est une identité unique qui vous permettra comme ça de les différencier. 

On peut en créer un autre et on va créer un autre chat et vous allez voir qu'il n'aura pas du tout le même identifiant. 

+ App.java
```java
public class App
{
	public static void main(String []args)
	{
		Cat miaou = new Cat();
		Cat miaou2 = new Cat();
	}
}
```
Donc on recompile tout ça, alors oui évidemment `miaou2`, on ne peut pas mettre 2 fois la même variable, c'est logique. 
```powershell
	>javac *.java
	>java App
	Je suis un chat Cat@3a71f4dd
	Je suis un chat Cat@7adf9f5f
```
Et là voilà, vous voyez pas du tout du tout les mêmes emplacements.

Chacun aura sa zone mémoire donc en terme informatique, Windows ici m'a permis donc de stocker en mémoire, fin en tout cas permis à Java de stocker en mémoire et d'allouer des emplacements mémoire pour chacun de ces objets là donc c'est lui qui choisit, c'est pas nous qui gérons ça donc ils sont chacun dans une adresse différente mémoire donc une adresse mémoire différence, ce que nous avons ici et nous au niveau de notre programme, dans la logique de programme, nous avons bien 2 chats différents d'accord.

miaou n'est pas le même chaque miaou2. Ce sont deux chats complètement a part.

Donc plus tard, vous verrez qu'on pourra leur faire faire des choses chacun d'accord.

On pourra faire faire des choses à miaou, que miaou2 ne fera évidemment pas forcément d'accord. 

Ce sont 2 entités, 2 êtres différent. C'est vraiment 2 objets, 2 instance de classe Cat différents, bien distinctes.

Voilà comment on construit un objet en Java, en tout cas comment on construit une classe puisque la classe c'est le point de départ.

Donc voyez le vraiment comme ça, je vais m'arrêter là pour cette vidéo de toute façon, on va voir plein d'autres choses par la suite donc je ne vais pas trop en rajouter ici.

Et si vous voulez vous demander "qu'est-ce qu'une classe ?". 

Une classe c'est tout simplement un modèle d'accord de construction OK, d'une entité, d'une idée ou d'un concept, c'est juste ça. 

Et l'instanciation et bien en fait, c'est le fait de donner vie OK, à cette à cette entité, à ce concept, à cette idée ... de lui donner vie et de créer un objet, on appelle ça un objet en programmation d'où le fait de parler de programmation orientée objet OK.

Voilà le principe, une classe, on construit la classe. Nous avons un constructeur.

+ Cat.java
```java
	public Cat()
	{
		...
	}
```
Ca s'appelle le constructeur de la classe Cat et quand on utilise le constructeur ailleurs, on crée une instance.
```java
	new Cat();
```
Instance qui est bien évidemment stocké dans une variable qui nous permettra de l'utiliser, de lui faire faire des choses, d'accéder à ses propriétés comme on le verra par la suite voilà.

Donc pour les prochaines vidéos, on va parler des propriétés, on va voir les attributs, on va parler des méthodes et cetera et on va voir beaucoup de choses que tout va s'organiser en fait autour de ce principe justement de programmation objet et de classe.

Java est un langage objet donc évidemment vous êtes obligé de manipuler ces choses-là et du coup il faut les connaître.

J'espère en tout cas que cette vidéo vous aura plu, j'ai essayé de faire quelque chose de d'assez courts et très simples au niveau des explications puisqu'on va avoir beaucoup beaucoup à revoir par la suite donc je préférais commencer vraiment doucement pour qu'on est juste ici la création d'une classe directement.

C'est vraiment le strict minimum que vous pouvez faire, c'est une classe `public class Cat`, son constructeur `public Cat()` et même lui, à la limite, le constructeur ne sera même pas obligatoire parce qu'on aura un constructeur par défaut définie par le programme mais nous on voulait quand même avoir quelque chose voilà fait manuellement pour pouvoir par exemple y mettre un petit texte, n'importe quoi.

+ Cat.java
```java
public class Cat
{
	public Cat()
	{
		System.out.println("Je suis un chat " + this);
	}
}
```
... mais c'était surtout aussi pour vous introduire le mot clé `this` qui est absolument connaître.

Je vous dis à bientôt pour une prochaine séance sur Java, n'hésitez pas en cas de questions même si c'est des questions simples qui vous paraissent bêtes encore une fois, n'hésitez pas à les poser en commentaire, je viendrai vous répondre et comme ça on pourra continuer d'avancer comme il faut sur cette formation Java.

A bientôt