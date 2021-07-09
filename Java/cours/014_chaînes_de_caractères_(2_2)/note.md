# [14. Chaînes de caractères (2/2)](https://www.youtube.com/watch?v=EphmNLfZ2hM)

Bonjour, on se retrouve pour la 2e partie sur les chaînes de caractères en Java.

Dans la vidéo précédente on avait abordé la classe String et on avait également vu beaucoup beaucoup de méthodes qui vous permettait de faire pas mal de manipulations et d'opérations avec les chaînes de caractères.

Alors le rappel et là chose qu'il fallait évidemment retenir c'était que la classe String est une classe qui manipule du coup les données immuables donc en gros le contenu ne peut pas être modifié pour notre chaîne de caractères et si modification, il devait y avoir en réalité, on va créer une nouvelle chaîne de caractères donc ça c'était le point très très important.

Et on va profiter de cette 2e partie en fait pour voir pas mal d'autres classes pour manipuler justement des chaînes de caractères notamment bah une classe que je voulais ...j'aurais pu aborder dans la première partie mais comme il y avait quand même beaucoup beaucoup de notions, on va démarrer du coup cette vidéo avec cette fameuse classe.

Alors, il nous restait une opération a voir concernant les chaînes de caractères qui était quand même très utilisé en programmation, c'est la possibilité pour ceux qui viennent de python, par exemple d'utiliser un split c'est-à-dire de split une chaîne de caractères en plusieurs morceaux.

Ou si vous venez, par exemple, de PHP, la fameuse fonction explode() qui contient...qui fonctionne un peu de la même manière.

Alors pour faire ça en Java, on a une classe qui est très pratique qu'il va falloir importer.

Encore une fois, on va avoir une vidéo dédiée sur la fameuse ligne là, que je vais écrire qui concerne les paquets et je vous apprendrez même à faire vos propres package mais on aura une vidéo spécialement là-dessus, voilà.
```java
import java.util.StringTokenizer;
public class App
{
	public static void main(String[] args)
	{

	}
}
```
On va donc importer `java.util.StringTokenizer` donc personnellement je préfère importer seulement les choses nécessaires, pas faire par exemple d'étoiles, vous verrez plus tard qu'on peut faire ce genre de choses `java.util.*` pour dire que tout ce qui est dans util, en fait, on l'importe mais personnellement je préfère toujours importer juste le strict minimum pour pas avoir comme ça à charger tout un tas de de classe qu'on utilisera peut-être jamais.

Pourquoi faire ce genre de chose ...et cette fameuse classe StringTokenizer va nous permettre justement de splitter une chaîne de caractères alors déjà on va faire une chaîne très simple comme ceci.
```java
import java.util.StringTokenizer;
public class App
{
	public static void main(String[] args)
	{
		String s = ""
	}
}
```
Et on va par exemple... vous savez, par exemple, on va faire une espèce de url, en fait, donc  qui suit un certain protocole c'est-à-dire que chaque morceau de l'url est séparé par des slash donc par exemple, on pourrait dire bah news slash puis ici un titre de la news, pas de souci, et par exemple après l'identifiant de la news en question, voilà ce genre de choses.
```java
import java.util.StringTokenizer;
public class App
{
	public static void main(String[] args)
	{
		String s = "news/titre-de-la-news/14";
	}
}
```
On fait ça et là pour StringTokenizer, on va en créer un ici, on va l'instancier :
```java
import java.util.StringTokenizer;
public class App
{
	public static void main(String[] args)
	{
		String s = "news/titre-de-la-news/14";
		StringTokenizer st = new StringTokenizer();
	}
}
```
Donc vous allez voir que c'est très très simple à l'usage alors cette classe, à la base, elle a été conçue en fait pour pouvoir manipuler des expressions rationnelles, d'accord, avec pas mal de d'opérations donc c'est une classe très puissante qui permet de faire vraiment beaucoup de choses mais on peut du coup s'en servir justement pour faire ce fameux split sur nos chaînes de caractères.

On va faire ceci et avec cette simple instanciation, en réalité, on lui a dit en fait de séparer, de splitter, en fait, cette chaîne là mais suivant un délimiteur qu'on retrouve de manière très récurrente en programmation qui est l'espace, le retour à la ligne, le retour chariot, ce genre de choses.

Alors d'ailleurs, peut-être, même si je ne passe la chaîne en premier argument, ça ne risque pas de fonctionner.
```java
import java.util.StringTokenizer;
public class App
{
	public static void main(String[] args)
	{
		String s = "news/titre-de-la-news/14";
		StringTokenizer st = new StringTokenizer(s);
	}
}
```
Donc avec ce type d'appel, d'accord, au constructeur, il va explode, il va split cette chaîne suivant des espaces, retour à la ligne, retour chariot, ce genre de choses.

Le problème, c'est que nous, ici, nous avons des slashs donc il faut lui passer le délimiteur que nous voulons, qui est un peu spécifique comme 2e argument. Donc je vais lui passer de cette manière, tout simplement et ici je vais pouvoir du coup récupérer toutes les informations que je veux.
```java
import java.util.StringTokenizer;
public class App
{
	public static void main(String[] args)
	{
		String s = "news/titre-de-la-news/14";
		StringTokenizer st = new StringTokenizer(s, "/");
	}
}
```
A partir de là, notre fameux objet, ici, dans cette variable st qui est du coup de classe StringTokenizer va permettre d'utiliser pas mal de méthodes de cette classe pour manipuler un petit peu tout ça.

Alors pour faire franchement le plus simple, on fait une boucle.

On fait une boucle, vous dites tant qu'il y a en fait "hasMore" alors l'avantage de Java c'est que généralement les noms des méthodes sont pensés, d'accord, il y a des conventions de nommage qui permettent du coup de retrouver un petit peu le même schéma, en fait, dans le nommage.
```java
import java.util.StringTokenizer;
public class App
{
	public static void main(String[] args)
	{
		String s = "news/titre-de-la-news/14";
		StringTokenizer st = new StringTokenizer(s, "/");

		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
	}
}
```
C'est souvent has... quelque chose, his... quelque chose ou directement un nom donc c'est quand même très très facile après à retenir.

Donc `hasMoreTokens` donc le Tokens, en fait, c'est les bouts, d'accord, les morceaux, les parties, en fait, ici de notre chaîne.

Donc tant qu'il existe des morceaux, en fait, à récupérer...

Alors, je n'ai pas besoin d'accolades parce que j'ai qu'une seule instruction là, on va s'en passer, on va juste faire un affichage.

Et qu'est-ce que nous allons afficher tout simplement, c'est st et nous allons retourner le prochain morceau donc le prochain Tokens, donc nextToken().
```java
import java.util.StringTokenizer;
public class App
{
	public static void main(String[] args)
	{
		String s = "news/titre-de-la-news/14";
		StringTokenizer st = new StringTokenizer(s, "/");

		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
	}
}
```
Voilà une fois qu'on fait ça st.nextToken(), on va pouvoir compiler ce code déjà et ensuite l'exécuter.
```powershell
	>javac App.java
	>java App
	news
	titre-de-la-news
	14
```
Et vous voyez qu'on récupère bien chacune des parties, ici, du coup de notre url, d'accord, de notre chaîne de caractères suivant ce délimiteur donc le fameux slash.

Petite option également possible, si jamais vous avez besoin de récupérer également les délimiteurs, vous pouvez passer un autre argument, ici en 3e, qui est un booléen. Vous mettez true, tout simplement et là, vous allez récupérer également les délimiteurs.
```java
import java.util.StringTokenizer;
public class App
{
	public static void main(String[] args)
	{
		String s = "news/titre-de-la-news/14";
		StringTokenizer st = new StringTokenizer(s, "/", true);

		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
	}
}
```
```powershell
	>javac App.java
	>java App
	news
	/
	titre-de-la-news
	/
	14
```
Voilà, vous voyez on a news, on a le slash, l'autre morceau, le slash et 14 donc tout est récupéré icim.

C'est la petite différence, ce paramètre est optionnel, vous pouvez l'utiliser comme ça, de cette manière.

Voilà du coup pour l'utilisation de StringTokenizer et si vous voulez évidemment en savoir plus parce qu'encore une fois il y a toujours plein plein de méthodes, vous pouvez aller voir sur la documentation de Java.

Et bah comme je dis temps-en-temps, vous pouvez aller vous renseigner sur la documentation, je profite de cette vidéo pour vous dire bah où trouver cette fameuse documentation en Java parce qu'il y a plusieurs versions justement de Java donc ce qu'on appelle le JDK qui est en fait l'environnement de développement pour Java.

Alors le plus simple déjà pour savoir sur quel environnement vous tourner, vous faites simplement la commande Java : java --version.
```powershell
	>java --version
	java 14.0.1 2020-04-14
	Java(TM) SE Runtime Environment (build 14.0.1+7)
	Java HotSpot(TM) 64-Bit Server VM (build 14.0.1+7, mixed mode, sharing)
```
... et ça va vous retourner un numéro de version donc moi par exemple, on voit que j'ai la version 10, d'accord de 2018.

On a bien évidemment des versions, comment dire, plus récentes et des versions plus anciennes en fonction.

Moi je vous recommande au minimum d'être au moins sous le JDK 8, c'est vraiment voilà le strict minimum et dans l'idéal au moins sous JDK 10, actuellement au moment où je fait cette vidéo, il y a la version 12 donc voyez qu'il y a quand même pas mal de marge donc essayer quand même de prendre pas forcément la toute dernière, c'est pas forcément obligatoire mais pas une version trop ancienne non plus sinon il y a pas mal de fonctionnalités auxquelles vous n'aurez pas accès.

Dans tout les cas, au niveau des vidéos, comme vous voyez, je suis en version 10 donc je ne vais pas, de toute façon, je pense pas mettre à jour mon JDK entre temps au niveau de la formation, on verra.

Et si vraiment, à un moment donné, je venais à utiliser quelque chose qui fonctionne par exemple en JDK 11, JDK 12 ou autres, Eh bien évidemment, je vous le précserais, voilà pour que vous ne soyez pas surpris.

Donc si vous voyez qu'à un moment donné, moi dans une vidéo, en faisant exactement le même code que moi, vous avez quelque chose qui ne marche pas bah c'est peut-être voilà, en tout cas, que vous avez pas une version à jour par rapport à ça.

Alors comment retrouver justement cette documentation en Java très rapidement, avant de passer à la suite ... donc vous allez par exemple sur votre navigateur.

Vous pouvez donc noter ce chemin là, d'accord, qui est le chemin, on va dire, le plus général, en fait, pour la documentation Java.

Donc docs avec un s, point oracle point com slash en slash javase et du coup, il y a une page index point html.

[https://docs.oracle.com/en/java/javase/](https://docs.oracle.com/en/java/javase/)  

Et de là vous pouvez retrouvez les différentes documentations suivant votre version.
	
Donc si vous prenez la version la plus à jour, ça va moins poser problème que si, par exemple, vous prenez une trop ancienne alors vous êtes sur un langage plus récent.

Donc moi, par exemple, je peux prendre JDK 10 et du coup, ici, je suis redirigé vers la version de ma documentation.

[https://docs.oracle.com/en/java/javase/14/index.html](https://docs.oracle.com/en/java/javase/14/index.html)  

Une fois que vous êtes sur ce genre de page là. Encore une fois, selon le moment où vous allez regarder cette vidéo, ça aura peut-être changé le site enfin je n'en sais rien, c'est pas moi qui tiens le site d'Oracle mais c'est l'histoire de vous, on va dire, de vous aiguiller un petit peu. 

Vous cherchez donc de quoi retrouver l'API documentation, d'accord.

[https://docs.oracle.com/en/java/javase/14/docs/api/index.html](https://docs.oracle.com/en/java/javase/14/docs/api/index.html)  

Et à partir de là, vous avez du coup toute la partie qui nous intéresse et là on peut faire des fameuses recherche donc on peut par exemple s'amuser, si on veut pas évidemment s'embêter à chercher tout à la main, faire comme ceci (barre de recherche) et voyez qu'on retrouve d'ailleurs StringTokenizer avec même le paquet et tout qui va bien.

Je vais faire ça `SEARCH StringTokenizer` moi.

Voilà il me l'a retourne donc vous avez plein d'informations évidemment, on vous dit que c'est une classe et cetera, et vous allez retrouver du coup tout ce qu'il faut. Voyez les constructeurs, les méthodes donc il y en a pas mal et puis bien évidemment voilà toute la documentation bien détaillé pour tout ça donc il y a vraiment tout ce qu'il faut donc n'hésitez pas à prendre l'habitude dès maintenant à utiliser la documentation de Java parce qu'il y a forcément des méthodes que je ne montrerai pas en vidéo, vu le nombre qu'il y a et quand vous aurez justement, un petit peu, navigué sur la documentation, vous comprendrez ce que je voulais dire voilà quand je disais qu'il y avait des centaines, des centaines de pages ne serait-ce que juste pour détailler en faites pour d'écrire toute cette documentation et toutes les classes disponibles en Java.

Il y a vraiment énormément énormément de contenu voilà donc ça on passe, c'est histoire de vous montrer ça, là dessus et vous avez du coup, bah voyez que cette simple classe StringTokenizer, la possibilité de faire ce genre d'opération.

==============

Donc on va passer à la suite et la partie justement qui faisait du coup, qui était vraiment le thème de cette 2nde partie sur les chaînes de caractères c'est-à-dire à savoir manipuler d'autres classes pour avoir des opérations un peu plus souples sur nos chaînes de caractères.

Donc là où on avait la classe String qui encore une fois immuable. Nous avons possibilité surtout si vous êtes amené à modifier très souvent le contenu d'une chaîne de caractères, utilisé des classes où pour le coup, le contenu n'est pas immuable, il est modifiable.

Et pour ça nous en avons 2, à savoir.
```java
public class App
{
	/*
		StringBuilder / StringBuffer
	*/

	public static void main(String[] args)
	{

	}
}
```
Je vais mettre ici. Encore une fois, vous gérer pour prendre note, si vous voulez prendre vos notes d'accord. Moi, je note temps en temps quelques trucs mais encore une fois je ne note pas tout non plus.

A la rigueur, tout ce que je vous note ici en commentaire, je ne serais absolument pas obligé de le faire.

Après moi, honnêtement, je le fais surtout pour moi aussi pour être sûr qu'au cours de la vidéo, je n'oublie pas la moitié de ce que je voulais vous dire donc voilà.

Une fois qu'on a tout ça StringBuilder / StringBuffer. On va pouvoir utiliser ces classes. 

Alors déjà première nouvelle, c'est que ces 2 classes, encore une fois, même si vous avez regarder dans la documentation, vous allez voir qu'elles auront les mêmes méthodes et le même fonctionnement, ça veut dire qu'en gros en apprenant à utiliser une, vous aurez automatiquement appris à utiliser la 2nde, donc ça c'est quand même bien pratique.

Mais du coup ça, surtout quand on débute parce qu'au début, on ne comprend pas, et bien on ne sait pas dans quel cas il faut utiliser StringBuilder, dans quel cas il faut utiliser StringBuffer. 

Et pire encore, comme langage Java, évidemment évolue très vite qu'il y a des nouvelles versions à chaque fois, et bien selon l'évolution du langage, il y a des choses, par exemple, qui pouvait être vrai, des arguments qui était vrai à l'époque mais qu'ils ne le seraient plus aujourd'hui ou inversement, qui était faux à l'époque qui deviennent véridique aujourd'hui.

Donc c'est pour ça que c'est compliqué, qu'il faut vraiment se tenir un maximum à jour parce que quand il y a un langage, comme ça, qui évolue rapidement et, on va dire, vraiment pour l'ajout ou la modification de pas mal de fonctionnalités, c'est bien de toujours se renseigner un maximum parce que les choses peuvent pas mal bouger.

En tout cas, ce que je veux vous dire là, donc c'est quelque chose qui est bien à jour par rapport à ça et on va voir un petit peu la différence entre ces 2 classes même si elle fonctionne pareil, même si elle possède un peu les mêmes méthodes et de voir un petit peu dans quel cas vous allez utiliser StringBuilder et dans quel cas vous utiliserez StringBuffer.

Pour commencer, on ne va pas trop se prendre la tête, on va juste faire StringBuilder dans main, je vais l'appeler comme ça `sBuilder` et je vais créer ici une nouvelle instance, StringBuilder() et je ne vais rien passer.
```java
public class App
{
	/*
		StringBuilder / StringBuffer
	*/

public static void main(String[] args)
	{
		StringBuilder sBuilder = new StringBuilder();
	}
}
```
Je ne vais même pas passer quoi que ce soit pour le moment en paramètres, on verra par la suite, voilà.

A partir de là pour ces 2 là, encore une fois elles sont muable, contenu modifiable, voilà ça c'est à retenir très important.

contrairement à String qui est immuable, très importante. Donc ici, on va véritablement travailler sur le contenu lui-même et non pas créer de nouvelles chaînes de caractères. 
```java
	/*
		StringBuilder / StringBuffer : muable (contenu modifiable)
	*/
```
Et première méthode, évidemment très pratique qu'on retrouve et qui est logique, comme on avait pour la classe String, c'est la méthode length(), d'accord, qui je le rappelle, pour String, en tout cas, à la base, calcule le nombre d'éléments donc en fait la taille de la chaîne.
```java
	/*
		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length()
	*/
```
Mais là, il va falloir faire attention pour ces 2 classes là (StringBuilder / StringBuffer) parce que il y a une petite particularité.

Alors on va faire `sBuilder.length()`, souvent quand on parle de taille, il y a des gens qui se disent : "mais du coup la taille, en fait, pour une String, en fait bah c'est le nombre de caractères donc en fait bah c'est la la taille en fait ... ce qu'elle peut, ce qu'elle contient comme caractère". Effectivement, c'est ce genre de chose, donc on ne fait pas, en fait, de distinction et vous allez comprendre pourquoi par la suite.
```java
public class App
{
	/*
		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length()
	*/

	public static void main(String[] args)
	{
		StringBuilder sBuilder = new StringBuilder();

		System.out.println(sBuilder.length());
	}
}
```
Donc là, si je fais, voilà.
```java
	>javac App.java
	>java App
	0
```
Voilà, on obtient 0 effectivement, il n'y a aucun caractère parce que j'ai rien enseigné du tout ici `new StringBuilder()` à la construction donc à l'instanciation donc ça m'indique 0 caractère.

Alors là où il faut faire attention, c'est que pour String, length(), en fait, elle joue 2 rôles c'est-à-dire que length() pour la classe String qu'on avait vu dans la première partie, elle veut tout simplement dire qu'on a 0 caractère. Elle dirait voilà, il y a 0 caractère.

Mais, en fait, il y a une capacité de 0 c'est-à-dire que notre chaîne qui a été créé, à ce moment-là, elle fait 0 parce que je rappelle, encore une fois, String est immuable donc à partir du moment où on va créer par exemple, avec String, une chaîne vide, hé bien si la chaîne vide contient 0 caractère, la capacité de la chaîne c'est-à-dire ce qu'elle peut contenir sera également 0.
```java
	/*
		String
		
		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length()
	*/
```
La capacité de la chaîne sera également de 0 puisque si on cherche, à un moment donné, à modifier la valeur, encore une fois, comme c'est immuable, on va créer une nouvelle chaîne.

Par contre pour ces 2 classes là (StringBuilder / StringBuffer), on va avoir une différence entre la longueur c'est-à-dire le nombre de caractère que possède la chaîne c'est-à-dire ce qu'elle a effectivement comme caractère, ce qu'elle contient et sa capacité.

La capacité, en fait, bah c'est l'espace qu'elle a de disponible.

Et pour ça, nous avons sur ces 2 classes, une méthode qui s'appelle capacity().
```java
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
	*/
```
Et là où c'est intéressant donc on va mettre ça ici.
```java
public class App
{
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
	*/

	public static void main(String[] args)
	{
		StringBuilder sBuilder = new StringBuilder();

		System.out.println(sBuilder.capacity());
		System.out.println(sBuilder.length());
	}
}
```
C'est qu'en faisant ça. On peut même, d'ailleurs, reprendre ... pareil pour length() tant qu'affaire, on garder l'autre.

Je fais, un coup, de compilation.
```powershell
	>javac App.java
	>java App
	16
	0
```
Et vous remarquez que pour la capacité, nous avons 16 donc là on a une grosse différence.

Là où String, ben on aurait la même chose, en fait, voilà si on faisait la capacité pour une String, ce sera la même chose que length(). Elle aurait la même valeur pour ces 2 méthodes mais pour StringBuilder / StringBuffer, on a bien une différenciation.

Par défaut, donc ça `StringBuilder sBuilder = new StringBuilder();`, c'est tel que ça a été decidé par rapport au compilateur, par rapport à tout ça pour Java. Et quand vous créez ici `= new StringBuilder();` une StringBuilder ou une StringBuffer parce que, je rappelle, tout ce que je vous montre la, c'est valable pour les des 2 classes, c'est exactement les mêmes méthodes pour les 2.

Et bien la capacité donc c'est un compromis qui a été décidé de 16 emplacements. En gros, on va allouer l'équivalent, enfin de quoi stocker 16 caractères en mémoire.

Donc voilà, comme ça, c'est pas trop peu parce que si on avait demandé que deux au départ, dés la moindre création de chaînes, de modifications, il faudra à nouveau réallouer de la mémoire donc ça va refaire pas mal d'opérations inutiles.

Et si par défaut, on dit bah, vas-y j'alloue 1000 caractères en mémoire. Si ça se trouve, vous allez en utiliser que 25 et du coup bah vous allez gaspiller les ressources mémoire et c'est absolument pas ce qu'on veut en programmation.

Donc 16, ça paraissait, par rapport à ceux qui, du coup, s'occupe du langage Java, un bon compromis.

C'est pas trop peu mais c'est pas non plus énorme, voilà c'est pas une capacité énorme.

Et du coup bah en fonction évidemment, la capacité va changer en fonction de ce que va contenir notre fameuse StringBuilder ou StringBuffer, d'accord, il y aura ce genre de choses là. Alors comment on fait ?

Bah déjà si je fais ça et je mets directement ici le texte à la création.
```java
public class App
{
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
	*/

	public static void main(String[] args)
	{
		StringBuilder sBuilder = new StringBuilder("Bonjour tout le monde");

		System.out.println(sBuilder.capacity());
		System.out.println(sBuilder.length());
	}
}
```
```powershell
	>javac App.java
	>java App
	37
	21
```
Nous obtenons ceci donc là, on voit bien, du coup, d'autres choses qui se passent. 

On voit que la capacité est de 37 place, d'accords, c'est-à-dire qu'il y a 37 caractères disponibles en mémoire mais pour le moment il n'y en a que 21 qui sont occupés donc il y a forcément toujours, malgré tout, ça on ne pourra rien y faire parce que ça fonctionne un peu comme des tampons, vous voyez comme des emplacements pris en fait, par bloc et on voit bien qu'au final bah le nombre de caractère effectif, qu'il y a vraiment dans la chaîne est plus petit, voilà.

Pour que ça tombe vraiment égal, il faudra vraiment avoir un sacré coup de bol. 

Mais on a forcément, du coup, la place. On est sûr, au moins, qu'on a suffisament de place pour stocker cette fameuse chaîne là donc ça, c'est une première possibilité à la création de notre chaîne ici.
```java
	StringBuilder sBuilder = new StringBuilder("Bonjour tout le monde");
```
Du coup rien, n'empêche, n'importe comment, évidemment de pouvoir après, changer les valeurs et en fonction évidemment la capacité changera puisque c'est Java qui va s'occuper d'adapter tout ça au niveau gestion de mémoire.

Maintenant, nous on va juste faire ça c'est-à-dire tu crées un Builder et demander, par la suite, d'ajouter des choses.

+ App.java
```java
public class App
{
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
	*/

	public static void main(String[] args)
	{
		StringBuilder sBuilder = new StringBuilder("Bonjour tout le monde");

		System.out.println(sBuilder.capacity());
		System.out.println(sBuilder.length());
	}
}
```

C'est-à-dire que là, j'ai fait ça, pas de problème, on va d'ailleurs l'enlever.

+ App.java
```java
public class App
{
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
	*/

	public static void main(String[] args)
	{
		StringBuilder sBuilder = new StringBuilder();
	}
}
```
Et ici, pour mon Builder ici, je vais utiliser une méthode qui est append() donc ça on va la noter. On verra une autre après. Et append(), je vais lui par exemple ceci `"Bonjour"`.

+ App.java
```java
public class App
{
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
			> append(), 
	*/

	public static void main(String[] args)
	{
		StringBuilder sBuilder = new StringBuilder();

		sBuilder.append("Bonjour");
	}
}
```
Alors, on peut peut-être même s'amuser ...on va laisser comme ça, on va pas forcément s'embêter...

On va faire println() sur sBuilder voilà.

+ App.java
```java
public class App
{
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
			> append(), 
	*/

	public static void main(String[] args)
	{
		StringBuilder sBuilder = new StringBuilder();

		sBuilder.append("Bonjour");
		
		System.out.println(sBuilder);
	}
}
```
Et du coup, si je refais un autre append() par la suite avec par exemple un petit espace `" tout le monde"`, voilà. On peut faire ce genre d'opération là.

+ App.java
```java
public class App
{
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
			> append(<str>), 
	*/

public static void main(String[] args)
	{ 
		StringBuilder sBuilder = new StringBuilder();

		sBuilder.append("Bonjour");
		System.out.println(sBuilder);
		
		sBuilder.append(" tout le monde");
		System.out.println(sBuilder);
	}
}
```
Vous voyez append(), ça fonctionne un peu alors ça c'est pareil, je fais référence à ceux qui programme déjà dans d'autres langages, et bien c'est un peu comme si on avait une liste et qu'on disait bah à la fin de cette liste, tu rajoute d'autres éléments.

Et bien là, imaginer une longue chaîne de caractères et on dit : "à la fin de cette chaîne, tu rajoute là, pour le coup, de nouveaux caractères. Tout ce que j'ai mis ici en paramètre de cette méthode".

Donc ça fonctionne exactement comme ça, on le met à la fin, on le met à la suite et du coup ça s'ajoute et si Java voit qu'il n'y a plus assez de place en termes de capacité, d'accord, par rapport à la méthode capacity().

Et bien, il va réallouer un bloc d'espace supplémentaire, voilà, pour que ça puisse accueillir en fait le nouveau complément, en fait, que vous venez d'ajouter ici en fin de chaîne.

Donc là je fais ça et voilà comment ça se passe, d'accord.
```powershell
	>javac App.java
	>java App
	Bonjour
	Bonjour tout le monde
```
Le append() fonctionne de cette manière. 

On peut aussi, très important, puisque rappelez vous de la fameuse méthode charAt() qu'on avait pour String qui permettait en fait de dire : "je vais récupérer le caractère à tel indice", on peut aussi dire : "je vais ajouter un morceau vraiment à un certain endroit particulier".

Donc en gros, j'ai fait append() mais j'ai mis par exemple ça mais on va inverser comme ceci.

+ App.java
```java
public class App
{
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
			> append(<str>), 
	*/

	public static void main(String[] args)
	{ 
		StringBuilder sBuilder = new StringBuilder();
		
		sBuilder.append(" tout le monde");
		System.out.println(sBuilder);

		sBuilder.append("Bonjour");
		System.out.println(sBuilder);
	}
}
```
Et là, du coup, là ici, le "Bonjour" vient après. On est d'accord si je fais ce type d'opération. On va obtenir ça.
```powershell
>javac App.java
>java App
 tout le monde
 tout le mondeBonjour
```
Ce n'ai pas ce qu'on voulait, nous on veut que "Bonjour" soit au début donc on peut, du coup, ici dire de faire un insert().

+ App.java
```java
public class App
{
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
			> append(<str>), 
	*/

	public static void main(String[] args)
	{ 
		StringBuilder sBuilder = new StringBuilder();
		
		sBuilder.append(" tout le monde");
		System.out.println(sBuilder);

		sBuilder.insert("Bonjour");
		System.out.println(sBuilder);
	}
}
```
Et comme je veux le mettre tout au début de la chaîne bah c'est l'indice 0 et je fais ceci insert(<index>, <str>) donc ça prend l'index et ensuite ça prend bien sûr la chaîne.

+ App.java
```java
public class App
{
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
			> append(<str>), insert(<index>, <str>)
	*/

	public static void main(String[] args)
	{ 
		StringBuilder sBuilder = new StringBuilder();
		
		sBuilder.append(" tout le monde");
		System.out.println(sBuilder);

		sBuilder.insert(0, "Bonjour");
		System.out.println(sBuilder);
	}
}
```
Voilà, on test tout ça.
```powershell
>javac App.java
>java App
 tout le monde
Bonjour tout le monde
```
Et voilà, comment ça fonctionne, tout est bien ajouté au début.

Donc là, on peut ajouter pour ajouter de la chaîne de caractère avec StringBuilder ou StringBuffer, c'est le même fonctionnement.

Vous avez les méthodes append() et insert() qui permettre de faire ça donc insert() pour  ajouter, en fait, à un endroit bien spécifique donc ça vous permet vraiment de choisir exactement où vous voulez placer votre chaîne ici et le append() ça met toujours à la fin, ça complète en fait à la suite tout simplement.

Donc voilà comment ça s'utilise et il y a comme ça pas mal de méthodes que vous allez pouvoir, du coup, utiliser.

Moi je pense que c'est déjà pas mal, voilà ces méthodes là pour vous.

Encore une fois, si vous voulez avoir d'autres méthodes pour faire d'autres manipulations, vous aurez largement le loisir de voir tout ça mais on va se contenter de ce qui a déjà ici.

Alors vous voyez que du coup l'utilisation est très simple c'est-à-dire que là, pour vous montrer tout simplement. Je fais ça. Je remplace StringBuilder par StringBuffer. On met quand même un nom plus explicite (sBuilder > sBuffer), même si ça j'aurais pû le laisser, ça ne change rien, ce n'est qu'un nom de variable. 

+ App.java
```java
public class App
{
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
			> append(<str>), insert(<index>, <str>)
	*/

	public static void main(String[] args)
	{ 
		StringBuffer sBuffer = new StringBuffer();
		
		sBuffer.append(" tout le monde");
		System.out.println(sBuffer);

		sBuffer.insert(0, "Bonjour");
		System.out.println(sBuffer);
	}
}
```
Et regarder.
```powershell
	>javac App.java
	>java App
	 tout le monde
	Bonjour tout le monde
```
Et voilà, et vous voyez qu'on obtient exactement le même résultat que ce soit un StringBuilder, un StringBuffer, encore une fois, ce sont le même fonctionnement, les mêmes méthodes, tout pareil.

Donc vous avez appris du coup là, en un coup, à travailler avec 2 classes différentes. Pour ça, ça fait quand même plaisir et ça fait gagner pas mal de temps par rapport à ça.

Alors nous ce qui va nous intéresser du coup et je pense terminer cette 2e partie sur les chaînes de caractères avec ça, c'est dans quel cas, en fait, on utilise l'une ou l'autre des classes.

Parce que qu'est-ce qui est important ? et vous avez peut-être si un jour vous avez déjà programmé en Java ou que vous programmé en Java, peut-être que vous utilisez que StringBuffer ou vous avez vu qu'on utilisait ça et pas ça ou inversement.

Et du coup, après c'est vrai, on ne sait plus trop parce que si sur une source on voit qu'il faut utiliser Builder et sur l'autre Buffer mais on ne sait plus vraiment ce qu'il faut faire.

Donc le mieux évidemment, c'est d'avoir des explications, encore une fois comme pour String dans la vidéo précédente, de savoir qu'est-ce qui se cache derrière, comment ça fonctionne derrière et du coup après on sait ce qu'on fait, il y a une logique, il a du bon sens en fait dans notre manière de programmer.

Alors en gros, ce qu'il faut retenir, c'est que par défaut, de toute façon ça va être le cas dans une majorité de vous vos développement et de vos projets, vous allez travailler en fait en monothreadé c'est-à-dire que vous allez avoir un seul Thread, en fait, qui va exécuter votre programme.

Et dans ce cas là, on va, du coup, avoir un certain type de fonctionnement à opérer.

Dans notre cas, on peut être en multithreadé donc un programme multithreading et pareil, il va y avoir pas mal d'autres choses qui vont intervenir et en Java comme dans pas mal d'autres langages, on a des classes qui sont dite, comment dire, threadsafe et il y a des classes qui ne le sont pas.

Et il y a également des classes qui sont synchroniser, synchrones et il y a des classes qui sont asynchrone alors qu'est-ce que ça veut dire ?

Il y en a peut être pour qui ça parle parce que vous avez peut-être déjà programmé dans d'autres langages mais il y en a sûrement, une bonne majorité d'entre vous, qui ne savent absolument pas à quoi ça correspond.

Mais en gros, voilà, ce que ça veut dire.

Alors déjà quand on est en Monothreadé donc je vais faire un truc, une explication assez détaillé aussi pour que vous puissiez comprendre.

Alors déjà, on manipule un seul thread, d'accord.
```java
/*
	Monothreadé : 1 seul thread
*/
```
Et un Thread pour pas faire trop compliqué, imaginé, en fait, que nous avons imaginé une autoroute, d'accord, des voies en fait sur la route.

bah un thread, ça représente une route, ça veut dire voilà toute l'exécution de votre programme va se dérouler sur une seule route donc tout va se faire dans l'ordre, en fait, bah imaginé des voitures sur une route, comme il y a qu'une seule voie, bah tout va se faire, en fait, dans l'ordre d'arrivée des voitures.

On ne peut pas Commencer à sauter par-dessus les autres voitures, on n'est pas dans un K2000 et enfin du coup, tout va se suivre, en fait, dans un même ordre. Donc ça c'est du Monothreadé.

Quand on a du Multi-threadé, Multi-threading, le terme anglais, le terme français, peu importe . On en a plusieurs, ça peut être 1 aussi mais ça peut être aussi plusieurs.
```java
/*
	Monothreadé : 1 seul thread
	
	Multi-threadé : plusieurs threads
*/
```
Et dans ce cas là, nous avons donc plusieurs routes et du coup, il peut y avoir plusieurs, en fait, voitures qui passent, en fait, au même endroit mais sur des voies différentes, d'accord, mais qui se suivent, qui se double et cetera.

Donc il y a eu quelque chose en fait qui est synchroniser ou non donc là où il y a une différence en fait entre nos deux classes, c'est qu'il y en a une qui va travailler, qui sera vraiment faites pour travailler dans un environnement Monthreadé et c'est le cas de StringBuilder, d'accord. Donc, je vais le mettre ici.
```java
/*	
	StringBuilder
		Monothreadé : 1 seul thread
	
	Multi-threadé : plusieurs threads
*/
```
Et nous en avons une qui est vraiment conçu pour travailler dans du multij-threadé et c'est évidemment StringBuffer.
```java
/*
	StringBuilder (asynchrone)
		Monothreadé : 1 seul thread
	
	StringBuffer
		Multi-threadé : plusieurs threads
*/
```
Voilà la différence, d'accord.

Alors ensuite par rapport à ça (StringBuilder), je vais mettre asynchrone évidement parce que l'inverse de ce qui est synchroniser, c'est asynchrone et ici, du coup, cette classe est synchronisée et elle est bien évidemment thread-safe.
```java
/*
	StringBuilder (asynchrone)
		Monothreadé : 1 seul thread
	
	StringBuffer (synchroniée, thread-safe)
		Multi-threadé : plusieurs threads
*/
```
Alors, j'emploi, comment dire, volontairement ces termes un peu anglais ou autre parce que vous allez devoir vous y habituer et évidemment quand vous ferez des projets un peu plus conséquent, des choses d'un certain niveau, vous allez forcément rencontrer ces termes.

Et en tant que programmeur, vous êtes forcément obligé de les rencontrer et un jour les manipuler et comprendre, en tout cas, ce qu'ils veulent dire.

En gros, voilà, comment il faut comprendre les choses StringBuffer comme il est prévue pour travailler dans un environnement en multi-threadé, multi-threading, elle va se synchroniser.

Imaginez par exemple donc 2 thread d'accord donc on peut imaginer que notre programme fonctionne sur 2 threads et par exemple un thread va entamer une opération, il va donner la main ensuite au 2e thread mais il va devoir attendre que le 2e thread ait terminé son traitement pour continuer le sien comme un travail à la chaîne en fait.

Par exemple, je prends une tartine, je lui mets du beurre et puis je te la passe, il faut que tu mettes de la confiture mais j'attends, ben voilà toi forcément pour mettre la confiture, il faut que moi, j'ai mis le beurre sur la tartine ou ce genre de choses.

Donc il y a cette histoire de synchronisation, et évidemment bah cette synchronisation qu'est-ce que ça fait ? ça crée de l'attente parce que les différents threads doivent se mettre d'accord ensemble et doivent travailler de manière synchronisée comme de la danse, comme des danseurs qui font une chorégraphie synchronisée. 

Enfin je pourrais prendre tellement d'exemples pour voilà, pour illustrer ce que je vous dis parce que ça fonctionne un peu partout, les voitures, la danse, le travail à la chaîne, peu importe, à l'usine. C'est exactement ce même principe.

Et thread-safe, ça veux simplement dire que évidemment, ça assure, en fait, la cohérence et, en fait, l'ordre de l'exécution des données comme les threads sont censés travailler ensemble, d'accord, de manière synchroniser, on s'assure bah par exemple qu'on commence pas à mettre la confiture avant le beurre sur la tartine, si on veut faire des tartines beurre confiture. Je pense que vous comprenez un petit peu ce que je veux dire.

Et du coup, StrindBuilder, elle n'est pas du tout ça, elle n'est pas thread-safe c'est-à-dire qu'il y a aucune garantie par rapport à ça mais on s'en fiche, on travaille en monothreadé donc pas besoin.

Et comme elle n'est pas prévue justement pour du multi-threading, évidemment elle est asynchrone donc tout se passe en fait dans un seul thread et c'est justement ce que nous voulons, d'accord.

Donc si vous êtes amenés, c'est ça qu'il faut retenir, à travailler dans un programme multi-threading, vous utiliserez StringBuffer parce qu'elle est prévue pour ça et de toute façon, pour garantir encore une fois, le bonne exécution entre les différences threads et la synchronisation donc on est obligé d'avoir ces garanties là et forcément on doit se servir de ça donc ça va forcément avec moins performant mais de toute façon on n'a pas le choix.

Toute façon à partir du moment où on est dans du Multi-threading, forcément on perd un peu en performance parce qu'il y a ce principes de synchronisation des opérations et cetera pour tout ce qui se passe dans le bon ordre, encore une fois, comme une recette de cuisine où alors on fait pas la recette dans le désordre, il y a un ordre à suivre, bah c'est exactement pareil. 

Et si on fait la recette de cuisine à plusieurs personnes, il faut que chacun se synchronise pour que tout soit fait comme il faut .

Et StringBuilder, ben c'est ce que vous allez, du coup, devoir et ce que je vous recommande évidemment d'utiliser parce qu'il est clair que dans la majorité des cas, si ce n'est peut-être même la quasi-totalité des projets sur lesquels vous travaillerez, vous serez en monothreadé donc n'utiliser absolument pas StringBuffer pour travailler sur un environnement monothreadé.

Vous allez en fait réduire drastiquement et énormément, c'est-à-dire que là on ne parle pas de une mili-seconde de différence dans le traitement. Vous avez qu'à faire des tests, par exemple, de pas mal d'opérations sur les chaînes de caractères, de votre côté, ça vous permettra comme ça, vous même, de faire, on va dire, de manière très basique ce qu'on appelle du profiling c'est-à-dire qu'on analyse, en fait un petit peu, les temps d'exécution, voilà l'efficacité, tout ça, des algorithmes et des différents codes que l'on fait, et vous verrez la différence, ne serait-ce qu'entre StringBuilder et StringBuffer, là on peut avoir des différences de plusieurs même seconde selon certains traitements.

Donc on ne parle pas de différence négligeable où, du coup, on s'en fout on peut utiliser une autre, peu importe, non non. 

C'est, encore une fois, il y a véritablement une différence ici donc dés le départ, il faut prendre l'habitude d'utiliser la bonne classe en conséquence.

Et d'ailleurs parce que comme je vous l'avez dit, il y a énormément, en fait, dans la documentation de Java, ne serait-ce que pour l'utilisation du langage, elle tient sur plusieurs centaines de centaines de pages mais la JVM, la machine virtuelle Java, c'est pareil, parce que aussi bien le compilateur que la machine qui exécute ensuite le bytecode, elle fait tout un tas d'optimisations ou autre alors même si évidemment au fil de l'avancée du langage, des nouvelles versions et des optimisations qui sont faites et donc des remplacements c'est-à-dire que même le compilateur, par exemple, bah moi si je fais ça... si je fait ça, je peux vous dire direct, en plus, je suis en JDK 10.

+ App.java
```java
public class App
{
	/*	
		StringBuilder (asynchrone)
			Monothreadé : 1 seul thread
		
		StringBuffer (synchroniée, thread-safe)
			Multi-threadé : plusieurs threads
	*/

	public static void main(String[] args)
	{ 
		StringBuffer sBuffer = new StringBuffer();
		
		sBuffer.append(" tout le monde");
		System.out.println(sBuffer);

		sBuffer.insert(0, "Bonjour");
		System.out.println(sBuffer);
	}
}
```
Ca (main), je suis sûr que quand le compilateur, il compile en fait ce code là, le StringBuffer ici (StringBuffer sBuffer = ...), il le remplace automatiquement par un StringBuilder, ça c'est clair et net qu'il fait ce genre de remplacement.

Alors après, est-ce que, du coup, on peut se dire : "bah comme le compilateur, il fait des remplacements, il fait des optimisations, on peut du coup être feignant et utiliser bah n'importe quoi et tant pis" ? 

Absolument pas, ça c'est encore une fois, alors c'est mon point de vue mais je trouve que c'est une très très mauvaise manière de penser c'est-à-dire de se dire : "comme le compilateur, ils corrigent les erreurs humaines et il s'occupe d'optimiser, de réparer un petit peu bah voilà de limiter la casse, on peut se permettre de faire n'importe quoi".

Honnêtement, si vous voulez faire n'importe quoi, il ne faut pas faire de programmation, clairement.

Donc dès le début, il faut prendre l'habitude d'être le plus rigoureux possible, pas non plus tomber dans l'extrême d'avoir le code le plus parfait, le plus optimisé mais de ne pas faire n'importe quoi, de ne pas gaspiller de la mémoire en se disant : "de toute façon, on a des ordinateurs très puissants maintenant donc on s'en fout", ça s'est très très mal pensé et c'est foncé droit dans le mur.

Donc dés le début, on utilise tout ce qu'il faut et qui plus est, en Java et ça vraiment son importance, plus en Java que dans d'autres langages, et c'est pour ça qu'on dit des fois que Java est pas un langage très rapide, que c'est très lent, c'est pas très performance, c'est parce que souvent les développeurs ne savent pas utiliser ce langage là et programme honnêtement n'importe comment ... parce que selon la version, en fait, de Java que vous utilisez et bien, il y a certaines optimisations, que le compilateur, va faire et d'autres qu'il ne fera pas.

Par exemple, sur JDK 8, il y a plein d'optimisation que le compilateur ne fait pas et que peut-être maintenant il fait avec JDK 10, ou qu'il fait peut-être même avec JDK 12.

Donc on s'attend et je l'espère en tout cas à ce que plus le langage évolue, plus il y a d'optimisation, plus du coup on obtient quelque chose de performant mais rien ne le garantie déjà et il peut y avoir des choses qui fonctionnaient par exemple sur la version x et qui ne fonctionnera pas forcément donc qui ne fonctionneront plus sur la version x+1.

Donc on peut pas, en tout cas, se dire : "c'est bon le compilateur, il va se charger de faire des optimisations donc moi je peux faire n'importe quoi".

Parce que votre code optimisé aujourd'hui, rien ne vous dit qu'avec la prochaine version de Java, il le sera toujours.

Donc vraiment, j'insiste, c'est pour ça que je prends bien le temps de vous expliquer tout ça. Ne soyez pas fénéant, voilà encore une fois, on entend souvent, le programmeur est fénéant et cetera.

Voilà, il y a fénéant et fénéant, le programmeur, c'est quelqu'un qui réalisent des codes pour éviter de répéter certaines tâches qui sont normalement faites pour une machine. C'est pas de la fénéantise dans le sens, je fais n'importe quoi et je me dis de toute façon, aujourd'hui on a des super technologie, on a des ordinateurs qui vont super vite parce que regarder, on est en 2019 au moment où je fait cette vidéo et quand vous lancez des gros gros programmes informatique, ça prend plusieurs plusieurs secondes pour ne serait-ce que se lancer et ça déjà voilà, posez vous des questions, vous vous demanderez peut-être est-ce que c'est normal en fait avec les machines qu'on a aujourd'hui, la quantité de mémoire, tout ça est-ce que c'est normal de devoir attendre 10 seconde, dès fois, avant de démarrer un environnement de développement ?

Peut-être que si les développeurs était un peu plus rigoureux à l'époque, et bien, on aurait des environnements de développement qui démarrait comme ça instantanément, voilà.

Vous, donc comme vous êtes là, l'avantage c'est que vous n'avez pas ces mauvaises habitudes, peut être, vous êtes en train d'apprendre ce langage donc prenez les bonnes habitudes dés maintenant et puis ben si un jour, en plus, vous transmettez vos connaissances, vos compétences à quelqu'un, des débutants aussi, ben au moins vous leur transmetterez de bonnes choses et ces gens-là deviendront de très bons développeurs parce qu'ils auront cette rigueur qui est, à mon sens très importante, voilà.

Voilà l'excuse de dire : "nos ordinateurs sont très puissants donc on peut se permettre de gaspiller de la mémoire ou de faire n'importe quoi", personnellement, après c'est mon avis, ça n'engage que moi, je ne suis absolument pas d'accord avec ça.

Si vous voulez faire, honnêtement, voilà n'importe quoi en programmation, ne faites pas de programmation, faites autre chose mais ne faites pas ça.

C'est un domaine qui demande un minimum de de rigueur, un minimum de compétence, c'est pour ça que c'est pas évident de prime abord et tant mieux, tant mieux c'est comme pour les grands médecins, on n'a pas envie que n'importe qui, comme ça, n'importe quelle personne random devienne médecin en claquant des doigts mais la programmation, c'est pareil.

Tout le monde peut se mettre à programmer, tout le monde peut devenir développeur mais pour devenir bon développeur, ça demande du travail, de la pratique et ça demande évidemment pas mal de recul aussi et d'avoir un minimum de rigueur dans ce que l'on fait.

Voilà donc après cette très très longue parenthèse mais très nécessaire aussi, j'espère que maintenant, vous avez bien compris comment ça fonctionnait, d'accord.

## Ce qu'il faut retenir
```java
/*
	StringBuilder (asynchrone)
		Monothreadé : 1 seul thread
	
	StringBuffer (synchroniée, thread-safe)
		Multi-threadé : plusieurs threads
*/
```
Ce qu'il faut vraiment retenir dans cette partie, outre ce qu'on a vu avec StringTokenizer tout à l'heure, c'est que là on travail... ça (StringBuilder) c'est ce que vous avez utilisé globalement, d'accord, très très souvent pour travailler en Monothreadé donc il n'y a pas d'histoire de thread-safe et il n'y a pas d'histoire de synchronisation.

Et si vous êtes un jour vraiment amené à travailler en multi-threadé, évidemment, vous utiliserez plutôt StringBuffer parce que de toute façon, dans ce cas-là, vous avez un besoin de garantie donc utiliser StringBuilder, c'est prendre le risque, des fois, d'avoir des comportements inattendus donc il faut bien veiller à ces deux choses là.

Voilà pour ces petites particularités et je vais terminer aussi, par exemple, alors c'est un petit bonus aussi, n'hésitez pas par exemple, vous voyez quand on faisait avec la classe String, quand on avait ce genre de de choses. Je vais virer mes commentaires, ça prend de la place, voilà.

+ App.java
```java
public class App
{
	public static void main(String[] args)
	{ 

	}
}
```
Par exemple quand on faisait ce sont de choses là. Qu'est-ce qu'on faisait ? qu'est-ce qu'on peut faire ? On va faire ça.

+ App.java
```java
public class App
{
	public static void main(String[] args)
	{ 
		String s = "a";
		String s2 = "b";
	}
}
```
Et puis ce genre de chose et puis derrière on va faire par exemple.

+ App.java
```java
public class App
{
	public static void main(String[] args)
	{ 
		String s = "a";
		String s2 = "b";
		
		String res = s + s2;
	}
}
```
`s + s2`, rappelez vous, on faisait de la concaténation, d'accord, ce genre de choses.

Ou alors comme je vous avais montré, un peu plus efficace, on a ça.

+ App.java
```java
public class App
{
	public static void main(String[] args)
	{ 
		String s = "a";
		String s2 = "b";
		
		String res = s.concat(s2);
	}
}
```
Alors ça, je vais revenir du coup parce que j'en avais parlé, il faut savoir qu'à l'époque, par exemple, quand je vous avais dit que la méthode concat() était plus rapide que l'opérateur + pour faire de la concaténation, bah ça, c'est un très bon exemple que, du coup, je vous donne parce qu'il y a une époque où justement avec des anciennes versions de la machine virtuelle où dans certains contextes même dans certains algorithmes très très très spécifique où c'était l'inverse, l'opérateur + était, en fait, plus rapide mais comme la machine virtuelle bah a pas mal évolué et a ajouté pas mal d'optimisation et bien aujourd'hui concat() est plus rapide et évidemment, quand on travaille avec StringBuffer, StringBuilder, on a des choses beaucoup plus rapide aussi que ça.

En gros bah aujourd'hui, ça vaudrait le coup de vérifier en Java, par exemple, en faisant un simple + ou genre en faisant s + s2.
```java
	String res = s + s2;
```
Il y a très fort à parier, au fait, que le compilateur Java nous fasse par exemple quelque chose comme ça.

+ App.java
```java
public class App
{
	public static void main(String[] args)
	{ 
		String s = "a";
		String s2 = "b";
		
		String sb = new StringBuilder;
	}
}
```
Et du coup, je pens que vous avez compris que par exemple la méthode append(), en fait là, ça fait de la concaténation, je pense. Il n'y a pas besoin de le dire explicitement et là, on a du coup ceci.

+ App.java
```java
public class App
{
	public static void main(String[] args)
	{ 
		String s = "a";
		String s2 = "b";
		
		String sb = new StringBuilder(s);
	}
}
```
et puis, en fait, on fait ça, tout simplement d'accord.

+ App.java
```java
public class App
{
	public static void main(String[] args)
	{ 
		String s = "a";
		String s2 = "b";
		
		String sb = new StringBuilder(s).append(s2);
	}
}
```
Et après, donc ça je ne l'ai pas dit parce qu'on n'a pas encore parlé d'héritage et cetera en Java mais pour avoir l'affichage, en fait, on utilise la méthode toString() qui est une méthode qui appartient à tous les objets, tous les objets peuvent l'utiliser.

+ App.java
```java
public class App
{
	public static void main(String[] args)
	{ 
		String s = "a";
		String s2 = "b";
		
		String sb = new StringBuilder(s).append(s2).toString();
	}
}
```
Et en gros, on obtient en fait la même opération de faire, en fait, par exemple, `sb = s + s2` ou `s.concat(s2)`, la méthode concat() et cetera.

+ App.java
```java
public class App
{
	public static void main(String[] args)
	{ 
		String s = "a";
		String s2 = "b";
		
		String sb = new StringBuilder(s).append(s2).toString(); //sb = s + s2
	}
}
```
Donc voilà, donc ça c'est le genre de chose que le compilateur Java va modifier. Si lui dans le code, il voit ça "sb = s + s2" surtout avec là par exemple JDK8, JDK10 ou évidemment supérieur, ça il est clair que vous mettez ça dans un code aujourd'hui, surtout s'il y a plusieurs concaténation par exemple comme ça.
```java
	//sb = s + s2 + s3
```
Ca, je suis pratiquement sûr à 100% que ce genre de code par le compilateur est remplacé par un StringBuilder et qui fout comme ça des append(), à la suite pour faire la concaténation parce que ça `StringBuilder(s).append(s2).toString()` évidemment, c'est bien plus performant, c'est asynchrome, on ne perd pas de temps, il y a beaucoup moins d'opérations, en fait, qui se passe.

Et c'est ce que un compilateur va toujours chercher à faire avec ses optimisations.

Voilà et je pense que j'ai été pas mal dans le détail. On est à combien ? On a 34 minutes de vidéo donc ça va, au moins, j'ai bien répartis mes 2 parties sur ces chaînes de caractères.

Donc j'espère que vous avez beaucoup de détails, beaucoup d'éléments donc c'est pour ça que j'avais vraiment fait 2 parties pour cette notion là.

Comme vous voyez, j'ai bien pris le temps de tout détailler, je vous ai parler un peu de la documentation, je vous ai parler un petit peu de ce qui se passait derrière ces différentes classes et de comment il faut un petit peu réfléchir.

Après, je vous dit moi, c'est mes conseils d'accord ... voilà je ne peux pas faire mieux. C'est comme ça que j'ai appris à programmer, c'est comme ça que j'estime, en tout cas, pouvoir un minimum bien programmer, pas faire n'importe quoi, parce que je suis très très curieuse de tout ce que j'utilise et quand je me sert d'une classe, d'une méthode et cetera ... et bien je ne les utilise pas bêtement en me disant : "ça, ça fait si, on m'a dit que ça faisait ça ou j'ai vu que dans la doc ça faisait ça donc j'utilise bêtement". Non, c'est vraiment comprendre comment ça marche sans tomber dans l'extrême de savoir exactement à la seconde, le temps que ça prend à l'exécution et cetera parce que ça rime à rien mais de savoir Ben voilà tel chose est-elle vraiment efficace ? Est-ce que ce code là, est-ce que c'est vraiment de cette manière là qu'il faut le faire ? Est-ce que dans tel contexte, c'est la meilleure solution ? 

Et Java, c'est l'inconvénients de son atout, comme c'est un langage qui plein plein de classes, plein de méthodes donc il est très riche et bien l'inconvénient de ce genre de langage, c'est que du coup, il y a tellement de choses qu'au final, c'est comme si vous aviez 15000 plats dans un resto, ben on ne sait plus le quel prendre et c'est bien ça le problème.

C'est ça qui fait que c'est très dur d'apprendre le langage Java, par rapport à ça en fait. Si il y a vraiment une difficulté au langage Java, c'est celle-là, okay. C'est quel classe, quel chose utiliser, dans quel contexte ? comment ? pourquoi ? et comment ça fonctionne dérrière ?

Donc moi évidemment, dans ce cours là, je prendrais bien sûr le temps de vous détailler chacune des choses. Voilà, j'ai pas pour habitude de vous balancer tout un tas de choses, de vous énumerer des méthodes, machin sans vous expliquer comment ça fonctionne un minimum pour que vous puissiez avoir un maximum d'outils derrière et puis après bien sûr c'est votre pratique du langage, la création de programmer des projets ou autres qui vous permettront de véritablement assimiler tout ça, bien comprendre et vous perfectionner.

S'il y a des questions, n'hésitez pas évidemment, je suis toujours présent dans les commentaires. Il ne faut pas hésiter parce que je sais que c'était 2 vidéos pas très très facile mais le problème, c'est que bah les suivantes, ça va être un peu pareil.

Entre 2 vidéos, c'est ce que j'essaie de faire, en fait, comme il y a des vidéos comme ça très détaillé, j'ai essayé entre 2, en fait, de vous faire des vidéos un petit peu plus cool, histoire de faire des pauses.

Donc par exemple, on aura une vidéo où on va parler des fichiers, qui sera un petit peu du même acabit que ça, c'est une vidéo qui va être assez lourde avec plein d'explications.

Et quand on va aborder les vidéos sur l'héritage ou voilà les packages, ça c'est des vidéos qui vont franchement être très très simple à faire, très rapide, ça va être cool.

Et ça donc voilà, l'histoire des packages en Java, ça s'apprend très vite, c'est très simple à comprendre donc là vous pourrez souffler un petit peu.

Je vous dis à bientôt pour la prochaine séance puis j'espère que cette formation, en tout cas, vous plaît et vous continuez comme ça de progresser sereinement.

A bientôt