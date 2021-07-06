/*
Java #23 - collections en liste
Bonjour à tous bienvenue pour cette 23e séance en Java. 
La dernière fois nous avions fait une introduction assez rapide sur les collections dans ce langage de programmation.
Nous allons aborder ensemble quelques exemples de classes que vous allez pouvoir utiliser. 
Je vais vous montrer un petit peu de code sur ces dernières, je vous expliquerai, on passera un bon petit moment pour en parler, sur les spécificités de chaque classe de collection en Java pour savoir dans quel contexte plutôt utiliser l'une que l'autre parce que c'est généralement le genre d'erreur que l'on va très très souvent donc c'est bien de partir là-dessus pour que vous sachiez que dans tel contexte, vous utiliserez plutôt telle collection Et dans un autre contexte plutôt une autre. 
On va partir sur un exemple ou en tout cas sur un code très très simple, très basique, je veux agrandir mon éditeur pour que vous ayez quelque chose de suffisamment grand. Je vous montre ça rapidement, très rapidement. 
Main.java
-------------
public class Main
{
	public static void main(String[] args)
	{
		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
}
}
Cat.java
----------
public class Cat
{
	private String mName;
	public Cat(String name)
	{
		this.mName = name;
	}
	public void meow()
	{
		System.out.println(this.mName + ": Meow !");
	}
}
Je vous montre ça rapidement très très rapidement, une simple classe Cat avec un attribut mName "private String mName", un constructeur ici "public Cat(String name)". Et une méthode meow() qui fait simplement afficher le nom du chat et qui le fait miauler.

Au niveau de notre classe ici main, J'ai instancié et au travers de 3 variables, 3 chats.  Nous avons donc 3 chats qui existent maintenant toutdoux, papi et maki.

À partir de là on va pouvoir aborder ensemble tout ça. 

Petit rappel 
==========

Petit rappel, précédemment je vous avais montré quelques schémas sur la vidéo d'introduction. Ça a été mis bien sûr sur le github puisque que je vous en avais parlé donc vous avez tout dans le dépôt FormationVideo/ressources/Java.
Et ensuite vous trouver Collection - Interface avec ce petit schéma que je vous avais montré et ce qui va être intéressant aussi, c'est la partie Collection - Classes parce que vous allez retrouver un petit peu l'ensemble des classes, une bonne partie de l'ensemble que nous allons voir et notamment un tableau qui nous indiquera tout un tas d'éléments qui sont spécifiques à chacune des classes. 
Je vais résumer très très rapidement comme ça m'évitera de revenir dessus et on en parlera ensuite par après. 

Collection - Classes
-------------------------

Il y a certaines collections qui sont ordonnées à ne pas confondre avec une affaire de tri, le fait de trier les données, mais ce sera une affaire de données qui seront ordonnées, bien organisé.
Il y a certaines collections qui peuvent accepter ou non les doublons, la présence ou non de valeurs identiques. 
L'accès direct, je vais en parler par la suite, c'est le fait qu'en lecture de pouvoir accéder à l'élément directement ou alors en effectuant un parcours pour le trouver. 
Le fait d'accepter ou non des valeurs nulles, ça c'est très important aussi de le savoir. 
Et le fait de savoir si la collection permet de travailler dans un environnement Thread-safe ou non. C'est-à-dire thread-safe, c'est pour travailler dans du multi-threadé et quand ce n'est pas thread-safe, c'est tout simplement sur du mono-threadé, avec un multicoeur. 
Donc ça c'était pour les différents éléments que je voulais vous donner, vous avez tout sur le github si besoin Comme ça vous pourrez le consulter comme bon vous semble. 

Par rapport à ça, nous allons voir ensemble 4 des classes que je vous ai montrées. 
4 qui sont quand même assez importantes, je vais d'ailleurs les mettre ici en commentaire comme ça vous aurez quelques notes, voilà : 

	/
		ArrayList	:
		LinkedList 	:
		Vector		:
		Stack		:
	/

Nous allons voir ArrayList, Vector, LinkedList et un cas un peu particulier qui est Stack.
Stack est d'ailleurs une classe spécialisée de Vector, Stack hérite de Vector, pour information. Ça c'est bien de le savoir aussi.  
Donc c'est un Vector mais un peu plus spécialisé. 
Voilà comment ça fonctionne. 
Pour faire simple, pour résumer un petit peu, ces 4 classes permettre de travailler avec des informations ordonnées, d'accord. 
Elles acceptent aussi de travailler avec des doublons I elles acceptent également les valeurs nulles. 
Très important car c'est plus tard vous travaillez avec des données qui pourrait éventuellement être nulles, si vous travaillez avec une collection qui ne les acceptent pas, vous aurez bien évidemment des problèmes au niveau votre programmation. Attention à ce niveau mais ça ce sont les particularités de ces 4 là. 
Donc informations ordonnées, acceptent les doublons et acceptent les valeurs nulles. 
Donc ça c'est quelque chose reconnaître. 
Pour la suite, on va de toute façon résumé pour la suite et on verra un petit peu ce qu'il en est. 

On y va, donc ici j'ai 3 chats qu'on a instanciés là et nous allons créer un ensemble. 

Main.java
-------------
public class Main
{
	public static void main(String[] args)
	{
		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
	}
}

Souvenez vous précédemment virgule on avait vu ensemble dans les premières vidéos du cours, les tableaux. Les tableaux, si vous vous souvenez, ça fera une petite piqûre de rappel, permettent de stocker des informations de manière fixe c'est à dire que nous avons un conteneur , une sorte de connexion, on peut l'appeler comme ça mais on va éviter ce terme là  pour ne pas trop vous embrouiller qui est à taille fixe. 
On va dire par exemple qu'on réserve 4 emplacements pour stocker 4 instances de chat, de Cat, et on ne pourra pas en stocker en plus. Si on veut en stocker une 5e, et bien dommage, on avait un container à taille fixe, il va falloir créer un nouveau container à partir de là. 
Pour pallier à ce problème qui n'en est pas forcément un Parce que dans certains cas ça peut être utile et même recommandé de travailler avec des conteneurs à taille fixe. 
On a besoin éventuellement d'avoir un conteneur, en tout cas une connexion, un conteneur à taille dynamique c'est-à-dire qu'il peut évoluer au fur et à mesure de l'exécution du programme. 
De se dire, peut être qu'au départ, on aura 3 emplacements mais peut être que au cours de l'exécution va devoir passer à 5 à 6 à 10 et cetera. 
Il faut que nous ayons un containeur dynamique et pour cela il y a des classes ici et en l'occurrence ces 4 là : 
	/
		ArrayList	:
		LinkedList 	:
		Vector		:
		Stack		:
	/
Et en l'occurrence ces 4 là qui vont implémenter l'interface List donc cette interface (schéma collection interface) qui elle-même hérite de collection. Très important à ce niveau là. 
Donc ça les 4 classes que je vous montre appartient à ça, à List. 

Interfaces
==========
 
+--------------------------+		+-----------+
|       Collection         |		|   Map     |
+------+-----------+-------+		+-----------+
| List |    Set    | Queue |		| SortedMap |
+------+-----------+-------+		+-----------+
       | SortedSet | Deque |
       +-----------+-------+
Ces classes appartiennent à list sur lequel nous allons nous intéresser pour le moment. 
À partir de là, différents éléments vont pouvoir être utilisés. 
Pour faire très simple, histoire de ne pas trop vous perte à ce niveau-là, ArrayList, vous pouvez le voir comme les tableaux, ce sont les tableaux mais dynamique en Java. D'accord, pour faire très très simple, voilà comme ça fonctionne. 
Ça reprend notamment tout un tas de propriété comme l'accès direct, ce genre de choses, comme je vous l'avais d'ailleurs indiqué. 
En exemple assez similaire, nous avons Vector mais Vector va permettre de travailler dans un environnement multi-thread. C'est à dire qu'il est thread-safe. 
Donc ici on va avoir :

	/
		ArrayList	:	mono-thread
		LinkedList 	:
		Vector		:	multi-thread
		Stack		:
	/

D'accord, très important. 

	/
		ArrayList	:	mono-thread, accès direct,
		LinkedList 	:
		Vector		:	multi-thread, accès direct,
		Stack		:
	/

Ce qui est important aussi de savoir, c'est qu'on va avoir pour ces deux-là un accès direct aux informations comme je l'ai dit, ils sont assez similaires sachant qu'ici on va avoir surtout une distinction entre mono-thread et multi-thread finalement. Dans tel cas, on utilise l'un ou l'autre. Si on est sur du mono-threadé, on va plutôt utiliser ArrayList sinon on utilisera un Vector. Donc évitez d'utiliser un Vector dans un programme quelconque Et je pense qu'en majorité vous allez être sur un environnement mono-thread sinon vous allez tout simplement perdre en performance, donc vous allez plutôt travailler là-dessus, ça c'est à savoir.
Ici nous n'avons pas d'accès en direct et au niveau de la Stack non plus c'est-à-dire que pour chercher une information, il va falloir parcourir le conteneur, parcourir la Collection jusqu'à trouver la valeur que nous voulons lire. Ce n'est pas un accès direct avec un indice comme on a dans les tableaux, donc ça c'est des informations à prendre en compte.
Pour la suite on va faire un petit peu au fur et à mesure et je vous donnerai des commentaires pour vous donner de plus amples informations sur ces différentes classes. 

ArrayList
=========
On va commencer par ArrayList donc je vais faire ici en gros un tableau, un simple tableau dynamique pour pouvoir y stocker ici les chats (Main.java). 

Main.java
---------

public class Main
{
	public static void main(String[] args)
	{
		ArrayList

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
	}
}

Vous indiquez d'abord le nom de la classe (ArrayList). Comme c'est une classe particulière qui n'est pas présente de base, il faut l'importer, c'est notamment dans java.util, il y a beaucoup de choses dans la classe utilitaire de Java. Et ici on va mettre directement java.util.ArrayList.

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
	}
}

Encore une fois, je vous ai donné l'habitude d'importer que le strict nécessaire pour vos programmes. On pourrait très bien faire : 

	import java.util.*;

On pourrait très bien faire .* mais ça veut dire qu'on n'apporte absolument tout. Personnellement je préfère importer seulement ce dont on a besoin Et en plus ça permet de voir directement le nom de manière plus explicite et identifier ce dont on a importé directement au niveau de notre programme. Je trouve personnellement que c'est beaucoup plus lisible beaucoup plus clair. 

À partir de là nous allons devoir indiquer entre chevrons le type de données que nous allons pouvoir stocker là-dedans et là c'est aussi encadreur assez fréquent que l'on retrouve en Java puisqu'on ne va pas pouvoir utiliser des types primitifs. Rappelez-vous les primitifs se sont int, float, double et cetera et ceter. Tout ceux qui s'écrivent notamment en minuscules. 
Ces types primitifs ne fonctionnent pas, vous devrez travailler directement avec les classes correspondantes si besoin. 
On peut travailler avec Float, Boolean, Integer, pourquoi pas avec String. On peut parfaitement faire une ArrayList de chaîne de caractères et nous, c'est l'intérêt de la vidéo, c'est de faire ça au niveau de nos chat "ArrayList<Cat>".

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat>

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
	}
}

On met un nom, je vais appeler cela un groupe "group" et on va faire "new ArraList<Cat>()". Ici au niveau de notre constructeur, on indique aucun argument. Vous verrez que pour certaines classes, il y a un argument qui peut être assez intéressant à utiliser au niveau de l'appel au constructeur mais on abordera, en fait c'est ici qu'on pourra le voir. Je confondais avec LinkedList, mais effectivement ArrayList, on va pouvoir passer un argument éventuellement. 

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat> group = new ArrayList<Cat>();

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
	}
}

Au niveau des collections il va y avoir 2 informations à prendre en compte qui sont très importantes. Vous allez avoir la capacité qui finalement se distingue (!=) de la taille. 

	/
		ArrayList	:	mono-thread, accès direct,
		LinkedList 	:
		Vector	:	multi-thread, accès direct,
		Stack		:

		Capacité != Taille
	/


La capacité c'est le nombre d'emplacement disponible pour votre collection. Par exemple si je fais ça :

	ArrayList<Cat> group = new ArrayList<Cat>(5);

J'indique ici que je créé une ArrayList qui possède une capacité de 5, qui va pouvoir accepter finalement 5 chats mais n'oubliez pas ce sont des collections dynamiques c'est-à-dire que si à un moment donné, j'en ai déjà 5 et que je vais en ajouter un 6e, automatiquement ça va fonctionner c'est dynamique c'est-à-dire que la machine virtuel va voir pour allouer un espace supplémentaire pour pouvoir ajouter un nouveau chat et automatiquement comme il y a une nouvelle allocation à faire, il y a des traitements supplémentaires. 

Là où il est intéressant parfois de préciser la capacité au départ au niveau du constructeur, ça va être tout simplement au cas par cas.

Admettons ici que vous savez au niveau de l'exécution de votre programme, qui si votre groupe "group", il sera au minimum de 10, ça veut dire que vous savez qu'il y aura au minimum 10 chats à stocker Eh bien ce sera plus intéressant de faire ceci "<Cat>(10)" : 

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat> group = new ArrayList<Cat>(10);

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
	}
}

Il est plus intéressant de faire ceci, tout simplement parce que vous allez éviter de faire des traitements supplémentaires inutiles. Si vous ne mettez rien, ça va prendre une taille par défaut. Ça va prendre 1, Ce genre de chose. Et lorsque vous allez vouloir ajouter le 2e, ça va faire une allocation supplémentaire, le 3e une allocation supplémentaire et cetera et cetera. 
On va enfaite rajouter des traitements supplémentaires pour la location Qui vont permettre d'agrandir la capacité de notre collection. 
Alors dès le départ on aurait pu dire bon On sait qu'il y en aura au moins 10 donc on peut faire ça "<Cat>(10)", d'accord il n'y a pas de problème là dessus. 
Attention, la capacité c'est toujours supérieur (>), je met l'inverse, ce serra mieux (Taille <= Capacité). La taille est toujours inférieure ou égale à la capacité. 

	/
		ArrayList	:	mono-thread, accès direct,
		LinkedList 	:
		Vector		:	multi-thread, accès direct,
		Stack		:

		Taille <= Capacité
	/


La taille c'est le nombre d'éléments que vous avez effectivement dans votre collection La capacité, c'est le nombre d'emplacement qu'elle peut accepter au maximum. 
Donc quand on aura ajouté nos 3 chats, la taille ce sera 3 et la capacité ce sera 10 si on prend l'exemple ici.

add()
=====

Et nous allons les ajouter, à partir de là comment on travaille sur notre interface de liste ArrayList. ArrayList Implémente notre interface de liste, on va avoir accès à tout un tas de méthodes et la méthode pour ces collection-là qui implémente List, c'est la méthode add(). Donc c'est très facile à faire, on fait "group.add" : 

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat> group = new ArrayList<Cat>(10);

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");

		group.add(c1);
		group.add(c2);
		group.add(c3);
	}
}

C'est très facile à faire, on aurait pu faire une boucle, éventuellement mais bon cette histoire que vous comprenez bien. On ajoute les 3 éléments et après comme on avait déjà vu comment faire dans la séance précédente. On fait une petite boucle foreach, donc on va faire chat sur group :

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>(10);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		for(Cat c : group)
//			c.meow();
//	}
//}
/*
On fait une petite boucle foreach, et on fait chat sur group et comme la méthode meow(), print directement, donc pour chaque chat on appelle la méthode meow(). J'espère que là vous avez bien pigé le principe, c'est vraiment très très simple. Normalement là vous ne devez pas être perdu si vous ne comprenez pas l'usage, les instanciations, l'usage de méthodes, la boucle foreach, ce que vous avez alors beaucoup beaucoup d'autres choses à revoir sur les vidéos précédentes. 

On y va, on fait une petite compilation Il a vouvoyé chacun des chats Toudoux, Popy, Maki, effectivement ça appelle bien la méthode, ça fonctionne, OK.

	>javac Main.java
	>java Main
	Toudoux: Meow !
	Popy: Meow !
	Maki: Meow !

OK pas de problème à ce niveau-là. Ça appelle bien la méthode, pratique au niveau de ces informations. 
Ce qui est génial et c'est là tout l'intérêt de toujours pareil, des classes, du polymorphisme, des interfaces, tout ça que Java utilise à foison, il y a beaucoup beaucoup de classe, beaucoup d'interface qui sont utilisés, implémenté et cetera pour pouvoir le code le plus simple possible c'est-à-dire qu'on travaille toujours au niveau des interfaces. D'ailleurs ici j'ai mis ArrayList "ArrayList<Cat>...", J'aurais pu carrément passer par un autre nom, un nom beaucoup plus abstrait pour faire ce genre de choses et préciser un peu plus au niveau du constructeur mais bon ça, c'est un détail, ce n'est pas tellement le problème.
L'avantage ici c'est qu'on va pouvoir faire tout un tas de choses comment passe virgule on implémente la même interface "import java.util.ArrayList;", on sait automatiquement que tous ceux qui implémente cette interface de liste possède les méthodes de cette interface qui elles sont marquées, c'est comme un contrat, rappelez-vous les interfaces qui disent voilà que si tu implémente tes interfaces, tu as forcément toutes les méthodes qui sont implémentées de cette interface. 

Donc ici admettons si je passe bientôt sur un environnement multi-thread, Eh bien ici je vais simplement remplacer ma ArrayList par Vector.

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		Vector<Cat> group = new ArrayList<Cat>(10);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		for(Cat c : group)
//			c.meow();
//	}
//}
/*
Et ce qui est bien, petite recompilation, ça fonctionne.

	>javac Main.java
	>java Main
	Toudoux: Meow !
	Popy: Meow !
	Maki: Meow !

Ça fonctionne, vous voyez que je n'ai pas touché au reste du code, c'est les mêmes méthodes tout pareil. 
C'est juste le nom de la classe qui change mais c'est le même fonctionnement. 
C'est pour ça que les débutants, les gens qui débutent et cetera se mélange parce qu'ils se disent "je ne comprends pas" car finalement ils voient que ces 2 classes sont la même chose et font la même chose Ben au final ils se disent qu'ils ont fait une classe de trop en Java. 
Non, ils n'ont pas fait une classe en trop en Java, elles ont chacune leur spécificité et il faut les connaître. 
ArrayList, c'est du mono-thread et Vector, c'est pour du multi-thread. 
Moi dans mon cas, c'est du mono-thread donc évidemment utiliser un Vector ici n'est vraiment pas une bonne idée. 
Donc on revient sur ArrayList. 

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat> group = new ArrayList<Cat>(10);

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");

		group.add(c1);
		group.add(c2);
		group.add(c3);

		for(Cat c : group)
			c.meow();
	}
}

Okay, donc ça c'est très simple. 
Ce qu'on va pouvoir faire aussi, très rapidement je vais aller assez vite. 
Donc tout ce que je vous ai montré, c'est pour tout ces éléments comme ça et notamment en accès directe pour ArrayList et Vector, on peut afficher un élément en particulier. Une fois qu'on a ajouté tout ça (retiré la boucle foreach). 

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat> group = new ArrayList<Cat>(10);

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");

		group.add(c1);
		group.add(c2);
		group.add(c3);

	}
}

Une fois qu'on a ajouté tout ça, on peut par exemple dire "System.out.println()" et de faire un group.get() et tu m'affiche par exemple l'élément à l'indice 0, ça va afficher une chose un peu bizarre comme on avait vu précédemment, souvenez-vous. 
Ça a marqué Cat@ et une adresse.

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>(10);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//		
//		System.out.println(group.get(0));
//	}
//}
/*
Voilà, vous voyez cat@ et une adresse. 

	>javac Main.java
	>java Main
	Cat@5ca881b5

Donc il a bien accédé à l'élément d'où encore une fois ce fameux accès direct. On met en index comme le tableau à taille fixe qu'on avait précédemment, on accède à l'élément rapidement. Pas de parcours à faire, on demande d'accéder directement à cet index, c'est un appel direct c'est très très rapide et c'est vraiment fait pour ça. 
C'est aussi ce côté important, c'est que ce fameux ArrayList est justement optimisé pour la lecture, d'accord et ça il faut vraiment vraiment y prêter attention. Je vais vous noter ici si vous avez bien compris, c'est la même chose aussi pour Vector parce que c'est de l'accès direct.

	/
		ArrayList	:	mono-thread, accès direct, optimisé pour la lecture
		LinkedList 	:
		Vector	:	multi-thread, accès direct, optimisé pour la lecture
		Stack		:

		Taille <= Capacité
	/

Forcément à contrario on n'aura pas la même chose avec LinkedList et Stack. Ces 2 là n'étant pas en accès direct, ils ne sont absolument pas optimisés pour de la lecture. 
Par contre, on va le voir un peu ici, elles sont optimisées pour l'écriture, on va mettre plutôt insertions rapides, ce sera plus logique. 

	/
		ArrayList	:	mono-thread, accès direct, optimisé pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, accès direct, optimisé pour la lecture
		Stack		:	

		Taille <= Capacité
	/

Les Stack, on va en parler un peu, c'est un cas particulier.
Voilà, qu'est-ce qu'on a comme méthode aussi ? Parce que je vous en avais montré plein. On a la méthode remove qui permet de retirer des éléments, qu'est-ce qu'on peut faire ? Après au niveau du parcours je vais vous montrer aussi quelque chose mais on va rester sur quelque chose d'assez simple que vous saviez faire déjà (remettre la boucle foreach).   

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat> group = new ArrayList<Cat>(10);

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");

		group.add(c1);
		group.add(c2);
		group.add(c3);

		for(Cat c : group)
			c.meow();
	}
}

remove()
========

Et hop, pareil ici on va enlever un élément. Comme c'est pour de l'accès, si on fait remove().
Si on fait remove de 1, c'est censé enlever Popy, je crois. 

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>(10);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		for(Cat c : group)
//			c.meow();
//
//		group.remove(1);
//
//		for(Cat c : group)
//			c.meow();
//
//	}
//}
/*
Voilà l'affichage et Popy a disparu. Désolé Popy, ne vous inquiétez pas il va bien.

	>javac Main.java
	>java Main
	Toudoux: Meow !
	Popy: Meow !
	Maki: Meow !
	Toudoux: Meow !
	Maki: Meow !


On a pas mal de méthode et je vous invite comme toujours parce que je ne peux bien évidemment pas tout vous énumérer et surtout que ça ne servira à rien de vous énumérer tout ce qui existe comme méthodes issues de la documentation. Vous avez une documentation Java et vous allez retrouver tout un tas de méthodes qui sont disponibles. 

Après il y a les méthodes pour récupérer l'index, pour dire un tien à quel index est situé lui. Bref on a plein de méthodes qui sont utiles à ce niveau-là. 

Vous avez toutes les méthodes qui sont bien sûr assez générique c'est-à-dire propre à ces 4 classes, notamment add() que vous allez retrouver, addAll(), c'est par exemple, va pas toutes les voir surtout que j'en avais apporté quelques-unes dans la vidéo d'introduction précédente.

	/
		ArrayList	:	mono-thread, accès direct, optimisé pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, accès direct, optimisé pour la lecture
		Stack		:	insertions rapides

		Taille <= Capacité

		add(), addAll(), remove()
		clear(), size()
	/


add(), ça c'est pour ajouter un élément précis.
addAll(), C'est si vous voulez carrément ajouter une collection dans une autre. Si vous avez plusieurs collections que vous voulez fusionner et cetera. Ça peut être pas mal pratique. 
remove(), qui est évidemment générique c'est-à-dire propre à ces 4 classes. 
clear(), qui permet d'effacer et cetera. 

D'ailleurs si je fais un clear() pour éffacer quelque chose qui n'existe plus. 

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>(10);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		for(Cat c : group)
//			c.meow();
//
//		group.clear();
//
//		for(Cat c : group)
//			c.meow();
//
//	}
//}
/*
Voilà pas de problème par rapport à ça.

	>javac Main.java
	>java Main
	Toudoux: Meow !
	Popy: Meow !
	Maki: Meow !

Pareil, petite parenthèse, Ben vous voyez que les vidéos sont de plus en plus longues à mesure qu'on avance dans les notions, je ne fait pas forcément vérification de tout ce qui se passe mais comme je voulais expliquer notamment sur la vidéo sur les exceptions, je voulais dire à partir du moment vous manipulez des classes n'importe quoi en fait notamment des appels de méthode qui peuvent éventuellement déclencher des exceptions et ça bah le seul moyen de le savoir ce n'est pas le deviner, c'est encore une fois se renseigner au niveau de la documentation. 
Vous isoler ça (les group.add) dans un bloc try catch pour traiter les erreurs éventuelles qui pourrait se produire. 

Donc là évidemment il n'y a aucun bloc try catch qui a été fait là mais il faudra le faire parce que si par exemple j'essaie de retirer un élément qui n'existe pas Ben automatiquement on se doute bien que ça ne va pas le faire. Bah c'est par exemple je veux dire tire moi l'élément d'indice 10. Je sais qu'il n'y a pas d'éléments d'indice 10 parce qu'on n'a pas autant de choses.

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>(10);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		for(Cat c : group)
//			c.meow();
//
//		group.remove(10);
//
//		for(Cat c : group)
//			c.meow();
//
//	}
//}
/*
	>javac Main.java
	>java Main
	Toudoux: Meow !
	Popy: Meow !
	Maki: Meow !
	Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 10 out of bounds for length 3

Il a forcément une grosse exception qui a été générée qui n'est absolument pas traitée donc attention Même si vous voyez que je ne le fais pas en vidéo parce que ça rallongerait énormément énormément, tout ce que je vous ai dit précédemment sur les choses à faire et cetera et cetera. Eh bien ce n'est pas parce qu'on aborde d'autres notions que ce n'est plus à expliquer.

C'est toujours le cas, lorsque vous travaillez ici avec le code, différentes interfaces de classe de Java, s'il y a possibilité que des exceptions soient générés, il faut les prendre en compte et les traiter. 

Minimum c'est un bloc try catch sur la capture d'exception, Vraiment la plus globale si vous voulez et bien sûr dans le meilleur des cas de faire des choses beaucoup plus précises, d'affiner les exceptions que vous capturez alors ça c'est à vous de le faire sur vos vrais programmes, de ne pas vous contenter de faire des appels de méthode où l'on vérifie rien du tout donc attention à ça. 

Après il y a plein de méthodes, Par exemple il y a une méthode pour transformer une collection en tableau c'est-à-dire en Array en taille fixe en Java ou l'inverse, on peut passer d'un tableau en taille fixe à une collection. 

capacity() et size()
====================

Il n'y a pas mal de choses comme ça "toArray()" et autres. On a size() qui va être pas mal utile notamment. 

On va faire genre, capacité de 5 éléments et on va en ajouter 2.
C'est ça que je cherche à faire et on peut faire :

       System.out.println("Capacite : " + group.capacity());

Ce qui est bien c'est que les noms sont suffisamment clairs, capacity(), on peut pas faire plus simple plus explicite. C'est quand même bien choisi au niveau du nommage. On se retrouve bien et l'avantage c'est qu'on va retrouver le même dommage d'une collection à l'autre. Ça c'est quand même bien pratique. 
Et là c'est size() :

       System.out.println("Taille : " + group.size());

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>(5);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		//Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		//group.add(c3);
//
//       	System.out.println("Capacite : " + group.capacity());
//       	System.out.println("Taille : " + group.size());
//
//
//	}
//}
/*
	>javac Main.java
	Main.java:721: error: cannot find symbol
			System.out.println("Capacite : " + group.capacity());
													^
	  symbol:   method capacity()
	  location: variable group of type ArrayList<Cat>
	1 error

Qu'est-ce que j'ai fais ? Ça n'a pas été capacity.
Pourtant je suis bien sûr une ArrayList. 
Ça devrait fonctionner...
Peut-être que je suis juste sur Vector.capacity

Main.java
---------
*/
//import java.util.Vector;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		Vector<Cat> group = new Vector<Cat>(5);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		//Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		//group.add(c3);
//
//       	System.out.println("Capacite : " + group.capacity());
//       	System.out.println("Taille : " + group.size());
//	}
//}
/*
Peut-être sur Vector.capacity, éffectivement...

	>javac Main.java
	>java Main
	Capacite : 5
	Taille : 2

Vous voyez capacité de 5 et taille de 2, okay. Ça c'est important.
Je vous confie quand même que dans tous les cas Vector et ArrayList sont les deux éléments où l’on peut mettre une capacité au niveau du constructeur.

	/
		ArrayList	:	mono-thread, accès direct, optimisé pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, accès direct, optimisé pour la lecture
		Stack		:	LIFO

		add(), addAll(), remove()
		clear(), size()
	/


Ce qui ne sera pas le cas pour LinkedList et Stack, Notamment ici les collections que l'on parcourt. 
J'essaierai de vous montrer pourquoi Vector plutôt que ArrayList. 
J'essaie de vous passer en revue ce qui peut être un petit peu intéressant. 
Après il y a peut-être le tri. Le tri je vais peut-être le garder, on en parlera en détail surtout en annexe dans les tutos Parce qu'il y a pas mal de choses à aborder concernant le tri.
Ça fait également appel aux interfaces qui sont implémentées, après on a une méthode qui fait un tri naturel qui s'appelle sort() mais ça éventuellement je peux vous montrer.

sort()
======

Ça je peux vous montrer pour trier différents éléments parce qu'on a des chaînes de caractères. Ça va être trié là-dessus, ça va faire un tri naturel. 
On fait un petit import de Collections avec un s :

	import java.util.Collections;

Et on fait un petit Collections.sort().
Il y a énormément de choses à aborder sur une seule vidéo. 
Ça devient assez complet virgule il y a énormément d'informations mais j'essaie de vous en passer un maximum sans pour autant vous noyer dans les méthodes différentes parce qu'il en existe par dizaines et ça ne serait pas forcément utile de toutes les énumérer. 
Il faut aussi remplacer Vector par ArrayList. 
On change 15000 fois moi aussi. On va faire les choses proprement, on va reprendre ce qu'on avait au début. 
On vire l'histoire de capacité, on s'en fiche. 
//Il faut que j'importe le comparateur aussi java.util.Comparator. 
Non, il me semblait bien que le comparateur n'avait rien à voir.

Main.java
---------
*/
//import java.util.ArrayList;
//import java.util.Collections;
////import java.util.Comparator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		Collections.sort(group);
//
//		for(Cat c : group)
//			c.meow();
//	}
//}
/*

	>javac Main.java
	Main.java:819: error: no suitable method found for sort(ArrayList<Cat>)
                Collections.sort(group);
Alors qu'est-ce que j'ai fait ? 
On va faire ça sur une liste chaînée ? Non On va garder comme ça. 
Ne vous inquiétez pas, c'est normal, voilà il ne sait absolument pas comment trier les chats. 
On ne lui a pas dit comment trier des chats donc ça justement on réservera cette partie-là en annexe au niveau des tuto parce qu'il faudra bien faire une vidéo complète ne serait-ce que sur la comparaison d'objets en Java. 
Donc vous oubliez ce que je viens de faire, jusque-là par contre ce qu'on va faire, on va créer un ensemble de chaînes "String c..." pour s'assurer que l'autre le tri se fait bien. 
Parce qu'après il faut passer par une interface comparatrice, enfin tout un tas de choses et ça ferait trop de choses à voir dans une seule vidéo donc je préfère garder ça en annexe pour avoir une vidéo complète ne serait-ce que sur le sujet. C'est pareil c'est souvent très problématique mais là évidemment nous n'aurons plus de chat mais des chaînes.
Et les chaînes, on a plus qu'à faire :
		for(String c : group)
			System.out.println(c);

Main.java
---------
*/
//import java.util.ArrayList;
//import java.util.Collections;
////import java.util.Comparator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<String> group = new ArrayList<String>();		
//		//ArrayList<Cat> group = new ArrayList<Cat>();
//
//		String c1 = "C";
//		String c2 = "A";
//		String c3 = "B";
//
//		//Cat c1 = new Cat("Toudoux");
//		//Cat c2 = new Cat("Popy");
//		//Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		Collections.sort(group);
//
//		for(String c : group)
//			System.out.println(c);
//	}
//}
/*
	>javac Main.java
	>java Main
	A
	B
	C

Voilà, vous voyez qu'on a inséré d'abord C puis A, puis bien B Et avec Collection.sort, on a opéré un tri naturel. C'est assez simple, j'avais assez faire un tri sur des chaînes de caractères de manière lexicographique et nous trie ça en tout cas visuellement par ordre alphabétique. Pas de problème à ce niveau-là. 

Par curiosité, en passant "a", "A" et "a", on retourne "A", "a", "a".
C'est bien c'est que c'est lexico. 
Très bien donc ça on reviendra dessus, ne vous inquiétez pas si vous avez besoin de faire du tri, vous trouverez, ce n'est pas encore le cas au moment où je fais cette vidéo mais il y aura une vidéo bien sûr en tutoriel sur tout ce qui est comparaison d'objets en Java pour effectuer du tri parce que ça demande tout un tas de vérification pour des types particuliers. 

OK donc comme vous l'avez vu ArrayList, très pratique. Vector pour la lecture et en gros pour faire simple, évidemment avec leur pratique l'expérience, vos choix sont peut-être un peu plus réfléchi mais au départ quand on ne sait pas trop quoi choisir, si on est dans un besoin de faire beaucoup de lecture, beaucoup de lecture de données, le choix va se faire principalement pour tout ce qui est issue de l'interface List entre ces 2 classes.
Et après si vous êtes dans un environnement multi-thread, vous choisissez Vector et si vous êtes dans un environnement mono-thread, vous choisissez ArrayList. 

Honnêtement si vous ne pouvez pas vous tromper, le choix est vite fait. Pas de problème à ce niveau-là. 

Liste chainée
=============

Maintenant il n'y a pas forcément besoin de faire beaucoup de lecture mais qu'il y a besoin de faire beaucoup d'insertion, C'est là que la liste chaînée entre en jeu. Et qu'elle se montre beaucoup plus efficace à ce niveau-là. Alors pourquoi ? On va regarder ça. 

Je vous avais montré la méthode get() pour accéder à un élément, inutile de préciser que get(), on évitera sur une liste chaînée tout simplement parce que on va devoir parcourir tout un tas de choses. On va éventuellement recherchez un élément bien précis, on verra de toute façon que suivant l'environnement, utiliser get() n'est pas forcément l'idéal.

Utiliser get() pour parcourir n'est peut-être pas le mieux et vous allez comprendre pourquoi. 

Qu'est-ce que je voulais vous montrer aussi ? Voilà il fallait qu'on parle aussi des itérateurs dans cette vidéo. Il faut qu'on la porte maintenant. Je ne peux pas trop faire attendre avec ça car plus on va attendre et plus ça va être compliqué. Donc va falloir qu'on l'aborde là. Ça va faire une vidéo un peu longue mais de toute façon il le faut, c'est important. On ne peut pas passer à côté de certaines choses essentielles. 

Okay on va faire ça. On va virer cette partie là :

	import java.util.ArrayList;
       import java.util.Collections;
       
Les listes chaînées :

	import java.util.LinkedList;

Ça il faut qu'on va m'en parler un petit peu. On ne peut pas passer à côté non plus. Et on terminera rapidement sur la pile à la fin. Ce sera assez court.



	/
		ArrayList	:	mono-thread, accès direct, optimisé pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, accès direct, optimisé pour la lecture
		Stack		:	LIFO

		add(), addAll(), remove()
		clear(), size()
	/

On met nos petit chat "<String> --> <Cat>".
On remet comme avant "String c1 = "C"; --> Cat c1 = new Cat("Toudoux");".
En c2, on va mettre Pilou, peu importe les noms.
En c3, c'était Popy. 
On vire Collections.sort(group).
On remplace les String par Cat.
Pour la boucle foreach "System.out.println(c); --> c.meow();"

Main.java
---------
*/
//import java.util.LinkedList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		LinkedList<Cat> group = new LinkedList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		for(Cat c : group)
//			c.meow();
//	}
//}
/*
	>javac Main.java
	>java Main
	Toudoux: Meow !
	Pilou: Meow !
	Popy: Meow !

OK on est revenu au.de départ sauf qu'on a remplacé par une liste chaînée. 
La liste chaînée comme je viens de vous l'indiquer, son intérêt c'est les insertions rapides. Très très rapide à ce niveau-là parce qu'elle est faites pour ça. 
Il faut la voir pour ceux qui ne seraient pas ce que c'est qu'une liste chaînée. En gros, c'est un ensemble, imaginez une chaîne par exemple une chaîne de vélo, vous avez plusieurs maillons donc l'avantage c'est qu'on peut séparer par exemple deux maillons entre eux à n'importe quel endroit. On peut ajouter des éléments au début, à la fin de cette chaîne, et carrément en plein milieu à n'importe quel endroit en fait. 
On coupe simplement 2 maillons et on ajoute un nouveau maillon entre ces 2 là qu'on vient de couper. 
Et on peut comme ça insérer un nouvel élément. 
C'est pour ça que les insertions sont très rapides à ce niveau-là, la où pour un ArrayList ou un Vector, il faudrait pour le coup faire un parcours d'éléments en fonction, faire des décalages de valeur et cetera dans la collection et peut être sûrement d'ailleurs une ré allocation de mémoire pour pouvoir avoir un espace supplémentaire pour l'insertion. 
Bref ce n'est pas forcément le plus optimisé ArrayList et Vector, pour faire de l'insertion de données. 
Donc si vous devez faire beaucoup beaucoup d'insertion et qu'il n'y a pas besoin de faire beaucoup de lecture, évidemment travailler plutôt avec une liste chaînée. Ça c'est beaucoup, la partie qui sera la plus intéressante. 

À partir de là, on ré exécute à nouveau :

Vous voyez que ça fonctionne: 

	>javac Main.java
	>java Main
	Toudoux: Meow !
	Pilou: Meow !
	Popy: Meow !

J'ai pas changé c'est le même code que tout à l'heure, c'est encore add(), la même boucle l'avantage, on a juste changé LinkedList (ArrayList --> LinkedList) et le code fonctionne. 
Encore une fois, le fait que ça implémente l'interface List, me permet en fait au travers de 4 classes différentes d'utiliser les mêmes méthodes de travail et un peu de la même manière sauf que bien évidemment ces classes ont des spécificités différentes. 

	/
		ArrayList	:	mono-thread, accès direct, optimisé pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, accès direct, optimisé pour la lecture
		Stack		:	LIFO

	/


Donc ça, ça nous fait gagner un temps considérable et c'est super super important. 

Là où ça va être utile et après on terminera, on parlera des itérateurs, vous allez comprendre pourquoi parce que c'est quand même important de l'aborder, c'est très très puissant à ce niveau-là. 

Au niveau de la liste chaînée puisque c'est une collection un peu particulière, on va avoir accès à certaines méthodes qui pour le coup vont pas mal nous servir. 

On va pouvoir notamment parce que là finalement on fait add(), on ajoute les éléments tels quels, de dire enfin je veux ajouter l'élément en début de la liste c'est à dire que finalement je fais ça "Group.add(c1); --> Group.addFirst(c1);"
On y va, je ne veux pas que la vidéo dure 2h.

Main.java
---------
*/
//import java.util.LinkedList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		LinkedList<Cat> group = new LinkedList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.addFirst(c1);
//		group.addFirst(c2);
//		group.addFirst(c3);
//
//		for(Cat c : group)
//			c.meow();
//	}
//}
/*
	>javac Main.java
	>java Main
	Popy: Meow !
	Pilou: Meow !
	Toudoux: Meow !

Et là on voit ils sont ajoutés dans cet ordre-là. 
Donc c'est plutôt pas mal.
Vous voyez on a ajouté Toudoux en premier.
Comme on a dit qu'on ajoutait en premier ensuite et bien Pilou à été mis devant Toudoux.
Et ensuite Popy qui a été le dernier inséré mais en passant par le devant de la liste et bien se retrouve à être le premier. 

On a Last qui existe mais on a toujours add(), vous savez que c'est la méthode générique mais si vous voulez utiliser une méthode spécifique à la liste chaînée (LinkedList), vous avez addFirst(), addLast() et cetera. 

On a également la même chose pour remove(), removeFirst(), removeLast(), bref je ne vais pas vous faire un dessin, C'est très très simple à utiliser. 

Et pour get(), pareil. 

	Group.getFirst(c1);

Si vous voulez accéder au premier élément ou au dernier, si vous faites un getFirst() pour avoir un premier élément ou bien getLast(), ça va très vite parce que automatiquement on a un pointeur qui arrive dessus donc ça va très très vite à ce niveau-là.  

Donc ça ce sont des méthodes qui permettent de travailler rapidement et qui sont conçus pour ça. 

Maintenant comment va avoir besoin De faire du parcourt, on va optimiser un petit peu. 

Ce que je vais vous montrer ici n'est pas propre qu'à la liste chaînée, ça fonctionne pour n'importe quelle collection Et vous allez même dans les prochaines vidéos quand on abordera d'autres collection de Java, on pourra parfaitement utiliser ces exemples là aussi. 

Les itérateurs
==============

Il existe pour l'interface liste la possibilité d'utiliser un List d'itérateurs.
Bien évidemment vous ne savez pas ce que c'est qu'un itérateur. 
Un ittérateur va vous permettre de parcourir une collection c'est à dire qu'on a un conteneur qui contient des informations et on va lui permettre en fait de parcourir ces éléments. 

Pour ceux qui viennent d'autres langages, vous pouvez voir ça un petit peu comme un pointeur ou en curseur. 

Si vous faites de la base de données vous avez probablement déjà entendu parler des curseurs et bien c'est un petit peu le même principe. 

C'est un petit peu le même principe, on va avoir un élément, on va lui dire de se fixer sur notre collection Ici "group" en l'occurrence et il va pouvoir par exemple se fixer dès le premier élément de la collection, il va pouvoir se déplacer là-dedans, il va pouvoir ensuite indiquer les éléments que l'on veut, vérifiez s'il existe des éléments après et cetera et cetera. 

Bref un itérateur est parfaitement conçu pour ici le parcours dans une collection Et vraiment optimisé pour cela donc on va préférer utiliser un itérateur plutôt que de faire cette fameuse boucle foreach "for(Cat c : group) c.meow();" Qu'on faisait jusqu à présent ici pour les collections. 

Ici (Main.java), on a un cas particulier, Alors on pourrait utiliser un itérateur générique qui est tout simplement iterator. Nous comme on travaille sur des classes qui implémente l'interface List, que je ne dise pas de bêtises, on va utiliser un ListIterator. Il est vraiment conçu, optimisé pour ça donc autant en profiter. 

Donc on y va, déjà on n'oublie pas de l'importer : 

	import java.util.ListIterator;

On le crée ici (ListIterator avant For) et là, il y a différentes informations à prendre en compte. Déjà le type, moi c'est un itérateurs sur chat <Cat> (ListIterator<Cat>) puisqu'on va travailler là-dessus. 
On va l'appeler "lit", comme ListIterator.
Il ce que l'on va faire puisqu'il est à fixer sur une collection, Notre collection c'est group, on fait ça "ListIterator<Cat> lit = group"
On met un point ListIterator<Cat> lit = group.
Et attention il ne faut pas se gourer avec les minuscules majuscules, c'est l'appel à une méthode donc il n'y a pas de l majuscule au début de listIterator " ListIterator<Cat> lit = group.listI..."
Ne confondez pas avec l'appel d'une classe "ListIterator<Cat>..."
Et voilà "ListIterator<Cat> lit = group.listIterator();" 
Et là c'est bon, Nous avons notre itérateurs "lit" sur notre collection "group" qui est je rappelle, une liste chaînée.
Et là on va pouvoir changer la partie de la boucle foreach. 
On va pouvoir changer cette partie-là, notamment en l'occurrence ça "c.meow();". 
Pour le faire, c'est vraiment très très simple à ce niveau-là. 
On va vérifier déjà s'il existe un autre élément. 
Donc on va faire simplement :

	if(lit.hasNext());

"lit.hasNext());", si l'ittérateur trouve un élément suivant et si c'est le cas, on le fait "lit.next();" :

	if(lit.hasNext())
		lit.next();

" lit.next();", on le fait sur l'ittérateur "lit" et pas sur "c".
Donc "lit.next" Et ici à partir de là, on a notre instance de chat.
Encore une fois ici il ne faut pas se tromper, on ne travaille pas sur des simples chaînes de caractères ou autres, on travaille ici sur des instances. 

Donc ici si je fais :

If(lit.hasNext())
	System.out.println(lit.next());

C'est next(), comme ça, parce que c'est une méthode. 
On va faire ça comme ça. 
Comme ça en plus si j'ai fait des erreurs dans le code, au moins voilà, j'ai peut-être fait des bêtises. Je pense pas mais on sait jamais. 

Main.java
---------
*/
//import java.util.LinkedList;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		LinkedList<Cat> group = new LinkedList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.addFirst(c1);
//		group.addFirst(c2);
//		group.addFirst(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		if(lit.hasNext())
//			System.out.println(lit.next());
//	}
//}
/*
Voilà vous voyez qu'on récupère bien notre instance de chat. 

	>javac Main.java
	>java Main
	Cat@24d46ca6

Et à partir de là on appelle la méthode meow() que j'avais fait spécialement :

		if(lit.hasNext())
			System.out.println(lit.next().meow());

Main.java
---------
*/
//import java.util.LinkedList;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		LinkedList<Cat> group = new LinkedList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.addFirst(c1);
//		group.addFirst(c2);
//		group.addFirst(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		if(lit.hasNext())
//			System.out.println(lit.next().meow());
//	}
//}
/*
Et là, il n'est pas content parce que Je le fais dans un println() alors que ça fait déjà un println().  

>javac Main.java
Main.java:1180: error: 'void' type not allowed here
                        System.out.println(lit.next().meow());

Main.java
---------
*/
//import java.util.LinkedList;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		LinkedList<Cat> group = new LinkedList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.addFirst(c1);
//		group.addFirst(c2);
//		group.addFirst(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		if(lit.hasNext())
//			lit.next().meow();
//	}
//}
/*
	>javac Main.java
	>java Main
	Popy: Meow !

Et voilà, Popy !
Évidemment ce n'est pas un if. Je ne sais pas pourquoi j'ai dit if, c'est un while. 

Main.java
---------
*/
//import java.util.LinkedList;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		LinkedList<Cat> group = new LinkedList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.addFirst(c1);
//		group.addFirst(c2);
//		group.addFirst(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		while(lit.hasNext())
//			lit.next().meow();
//	}
//}
/*
	>javac Main.java
	>java Main
	Popy: Meow !
	Pilou: Meow !
	Toudoux: Meow !

Et voilà, nous avons notre parcours, ça fait le même résultat mais nous passons par un ListIterator, beaucoup plus optimisé et bien plus pratique. 
Alors on peut faire plein d'autres choses avec les itérateurs mais gardez en tête que c'est fait principalement pour ça, pour parcourir ici en Java notamment des collections. D'accord, on a plusieurs éléments, on va pouvoir les parcourir de manière optimisée tel un curseur, tel un pointeur, bref employer les noms que vous voulez mais faites attention surtout qu'en informatique ou bien dans d'autres langages, on différencie bien chacun. 
Donc là, c'est un itérateur et ça sert à ça et vous allez peut être en manipuler si vous faites d'autres langages de programmation. 
Donc très pratique, très optimisé, très rapide, très puissant, vraiment fait pour ça. 
Un petit ListIterator, encore une fois sur le type d'élément qu'il s'agit "<Cat>". C'est relié à ça "lit".
Et là vous passez directement votre collection "group" et vous appeler la méthode "listIterator()" et voilà.
Et à partir de là, vous avez 2 méthodes à connaître vraiment : hasNext() et next(). 

Avant de terminer la vidéo avec la stack, on recherche ListIterator<E> :

	https://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html

Vous voyez, on retrouve tout un tas d'éléments (Method Summary). hasNext(), ça c'est ce qui nous intéressé, next() et cetera, previous(), remove(), et cetera. 

Attention (remove) par contre à ne pas faire n'importe quoi au niveau de l'ittérateur parce que ça fonctionne par itération. On est dans des itérations, dans une boucle donc attention à ne pas supprimer des choses n'importe comment. Et cetera. 

Après vous pouvez toujours tester, manipuler un peu les itérateurs au voir comment ça se passe, comment ça se comporte mais vous verrez un peu certaines choses et de toute manière, on aura l'occasion de les aborder bien encore par la suite donc c'est la première mais ce n'est pas la dernière fois que nous les utilisons au niveau du cours ou en tout cas au niveau du code que je vous montre. 

Stack()
=======

Voilà et on va terminer enfin avec ce conteneur, cette collection un petit peu particulière qui est une collection sous forme de pile (Stack). 

	/
		ArrayList	:	mono-thread, accès direct, optimisé pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, accès direct, optimisé pour la lecture
		Stack		:	LIFO

	/

Pareil si vous n'avez jamais programmé de pile, fait des piles dans un autre langage de programmation.
La pile, c'est tout simplement une structure assez particulière qui dit qu'on ne peut insérer des éléments que au début, c'est à dire qu'on insère des éléments par le haut. On peut imaginer une pile d'assiettes si vous voulez vous représenter ça visuellement donc forcément si on veut ajouter une assiette à la pile, on l'ajoute par en haut. Pas par en bas voilà on adores les pari risqué.
Et si on veut retirer une assiette, on retire par le haut donc on parle de structure en LIFO, C'est-à-dire last in first out. 
Le dernier élément qui est inséré sera le premier élément qui sera retiré. 
Voilà donc si vous avez besoin de ce genre de structure, vous pouvez utiliser une stack. 
C'est vraiment fait pour ça. 
Stack est thread-safe comme Vector, même chose. Donc voilà ça c'est une information à connaître. 


Donc ça c'est une information à connaître, c'est également comme les 3 autres, des données qui sont ordonnées, qui acceptent les doublons, qui acceptent les valeurs nulles, pas de problème. 

Je peux très bien par exemple ici (group.addFirst(null)), faire un null qui sera accepté. 

		group.addFirst(c1);
		group.addFirst(null);
		group.addFirst(c3);

Null, est acceptée par ces 4 là. Pas de souci à ce niveau-là. 
Stack comment va-t-on pouvoir présenter ça ?
Parce qu'on va montrer vite fait quelque méthode c'est quand même intéressant de le voir.
On prend place tout dans notre code (LinkedList --> Stack).
Donc on a créer les différents chats :

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Pilou");
		Cat c3 = new Cat("Popy");

Ensuite, ici, on a des méthodes particulières parce qu'on n'ajoute pas n'importe comment (on remplace group.addFirst(c1)).

Si vous voulez ajouter un élément, c'est la méthode push(). Si vous voulez retirer l'élément du haut, c'est la méthode pop(), qui permet d'ailleurs de récupérer l'élément qui a été retiré. 

Si vous voulez accéder à l'élément qui est le plus en haut, au sommet de la pile, c'est peek(). Il retrouve la même chose, on peut faire de la recherche et cetera. C'est comme ça qu'au niveau de recherche, attention comme c'est une structure comme LinkedList sans accès direct, il y aura un parcours qui sera effectué pour faire la recherche. Donc ce n'est pas forcément le top pour la lecture. Encore une fois, vous avez bien compris que pour la lecture, ArrayList et Vector okay. 

Pour LinkedList et Stack, faire beaucoup de lecture n'est pas l'idéal. Et on ne les utilise généralement pas pour ça de toute manière. 

Donc ici on va faire "group.push()" et on va ajouter c1 "group.push(c1)" Et faire la même chose pour C2, C3.

       group.push(c1);
       group.push(c2);
       group.push(c3);
  
Vous voyez, je ne change pas beaucoup code, à par ici pour le coup.
On ne fait plus de add(), on fait un push() parce que ça fonctionne au niveau de la pile.
Et là normalement ça doit être bon. 


Main.java
---------
*/
//import java.util.LinkedList;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		Stack<Cat> group = new Stack<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//       group.push(c1); //group.addFirst(c1);
//       group.push(c2); //group.addFirst(c2);
//       group.push(c3); //group.addFirst(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		while(lit.hasNext())
//			lit.next().meow();
//	}
//}
/*

>javac Main.java
Main.java:1350: error: cannot find symbol
                Stack<Cat> group = new Stack<Cat>();
                ^
  symbol:   class Stack
  location: class Main
Main.java:1350: error: cannot find symbol
                Stack<Cat> group = new Stack<Cat>();
                                       ^
  symbol:   class Stack
  location: class Main
2 errors

Du coup, qu'est-ce que j'ai fait ?
Oui en effet, Stack il ne connait pas (LinkedList --> Stack).
	
	import java.util.Stack;

Main.java
---------
*/
//import java.util.Stack;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		Stack<Cat> group = new Stack<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//       group.push(c1); //group.addFirst(c1);
//       group.push(c2); //group.addFirst(c2);
//       group.push(c3); //group.addFirst(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		while(lit.hasNext())
//			lit.next().meow();
//	}
//}
/*
	>javac Main.java
	>java Main
	Toudoux: Meow !
	Pilou: Meow !
	Popy: Meow !

Hop et ça fonctionne, très rapide. 
Quelques petits remplacements, on travaille également avec un ListIterator "ListIterator<Cat>...". Aucun problème. 
Si je veux récupérer, pareil, le sommet.

	System.out.println("Sommet : " + group.peek());

Main.java
---------
*/
//import java.util.Stack;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		Stack<Cat> group = new Stack<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.push(c1);
//		group.push(c2);
//		group.push(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		while(lit.hasNext())
//			lit.next().meow();
//		
//		System.out.println("Sommet : " + group.peek());
//	}
//}
/*

	>javac Main.java
	>java Main
	Toudoux: Meow !
	Pilou: Meow !
	Popy: Meow !
	Sommet : Cat@63961c42

Je vous montre rapidement et voilà, je rappelle qu'on récupère l'instance puisque on stock une collection d'instances de Cat évidemment. 
Donc à voir à ce niveau-là.
J'aurais pu faire également un meow() pour afficher directement.
Forcement System.out.println("Sommet : " + group.peek().meow()); ne fonctionne pas car println() à nouveau.
et ça non plus "Sommet : " + group.peek().meow().
On fait donc group.peek().meow();

Main.java
---------
*/
import java.util.Stack;
import java.util.ListIterator;

public class Main
{
	public static void main(String[] args)
	{
		Stack<Cat> group = new Stack<Cat>();

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Pilou");
		Cat c3 = new Cat("Popy");

		group.push(c1);
		group.push(c2);
		group.push(c3);

		ListIterator<Cat> lit = group.listIterator();

		while(lit.hasNext())
			lit.next().meow();
		
		group.peek().meow();
	}
}
/*
	>javac Main.java
	>java Main
	Toudoux: Meow !
	Pilou: Meow !
	Popy: Meow !
	Popy: Meow !

Forcement System.out.println("Sommet : " + group.peek().meow()); ne fonctionne pas car println() à nouveau.
Je n'aurais pas dû mettre de système println() dans la méthode. 
Ça aurait évité quelques soucis mais vous voyez c'est bien Popy, donc ok.
Tout va bien virgule pas de problème.

Donc voyez, Toudoux en premier avec push(c1) donc c'est celui qui va se retrouver en bas, après ensuite c'est bien Pilou qui est le 2e et du coup, c'est bien Popy Qui est au sommet de la pile donc c'est normal lorsqu'on fait l'appel à peek(), c'est bien Popy qui nous est retourné.

C'est bien Popy qui nous est retourné parce que c'est lui qui est au sommet de notre stack. 

Donc c'est parfaitement logique, tout fonctionne à ce niveau-là. 

Est-ce que j'ai d'autres choses à voir ? 

On peut vérifier aussi si une pile vide avec empty mais ce sont des méthodes qui sont disponibles dans pas mal d'autres cas donc on peut vérifier ça.

	/
		ArrayList	:	mono-thread, accès direct, optimisé pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, accès direct, optimisé pour la lecture
		Stack		:	LIFO, multi-thread

		isEmpty() empty()

	/


Donc de manière générale c'est isEmpty() notamment pour vérifier si une collection est vide ou non Mais c'est vrai que pour les pilles, on a la méthode empty() tout simplement.

Parfois on a des petites choses comme ça en doublon Selon le cas, et selon ce qui est réutiliser ou pas car je rappelle que Stack et une classe spécialisée de Vector. D'accord, ça c'est important de le savoir. 

Ce qui permet d'ailleurs de retenir qu'elles sont toutes les 2, un environnement multi-thread parce que l'une est spécialisé de l'autre.

Okay, je pense que j'ai fait tout de tout ce que je voulais vous dire.

On a abordé ces 4 classes de l'interface List, qui implémentent l'interface List. Je vous ai donné chaque spécificité qui me semblait intéressant pour chacune. 

Je vous ai montré bien que ce n'était pas forcément prévu mais finalement on a vu du code sur le 4. Je n'avais pas forcément prévu de montrer du code sur les 4 classes mais on l'a fait.

Ça aura fait une vidéo un peu longue mais de toute façon Mais comme c'est une vidéo on peut la mettre en pause la regarder en plusieurs fois sur toute la semaine si vous voulez, c'est sur youtube ça ne va pas disparaître donc tout va bien. 

On a vu les itérateurs, on a parlé vite fait de tout ce qui est tri oui mais pas trop parce que je vous ai dit qu'il y aurait une vidéo spécifique là dessus parce qu'il y a beaucoup de choses à dire sur le tri, tout ce qui est comparaison de données en Java. 

Et voilà je pense que j'ai abordé tout ce que je voulais pour ces 4 classes donc vous voyez, une vidéo pour 4 classes. 

Évidemment si vous avez compris pour la prochaine séance, nous aborderons une autre interface avec d'autres classes qui implémente cette interface pour que vous voyez un petit peu comment on va travailler avec elle j'irai forcément un petit peu plus vite pour le prochain Collection parce que là c'est la première fois pour beaucoup que vous les voyez donc c'était bien de prendre un petit peu le temps de les aborder avec vous mais pour les autres bien sûr tout ce qui est ajout d'élément, itérateurs, tout ça, on ira beaucoup plus vite. 

Ce ne sera plus nouveau donc on pourra se permettre d'aller un peu plus vite au niveau des explications. 

S'il y a des questions n'hésitez pas parce que je pense qu'il y en aura parce que pour certains ça va peut-être paraître tout évident mais pour d'autres ça va peut-être paraître comme de la grande confusion autour de cette vidéo donc s'il y a des questions n'hésitez pas parce qu'il y a vraiment beaucoup de choses à voir là-dessus. 

Ça fait une grosse séance à digérer donc n'hésitez pas encore une fois entraîner, à faire du code, faire un petit programme et cetera.

En plus vous avez beaucoup de classe que vous allez pouvoir manipuler avec tout ce qu'on avait jusqu'à présent sur le cours Java, vous avez vu énormément de choses donc vous avez moyen d'utiliser tout un tas de données, de type de données, de classe différente de Java, faire la gestion d'exception et cetera, des listes bref.

Plein de manipulations possibles à faire, plein d'exemples de programme pour vous exercer donc n'hésitez pas pour vous entraîner, comprendre un peu ce que vous faites s'il vous bloqué sur quelque chose et que vous avez besoin d'aide donc n'hésitez pas à poser des questions en commentaire. 

Je vous dis à bientôt pour la prochaine séance où l'on abordera une autre interface et on continuera sur ces collections en Java.

Ciao tout le monde
*/


