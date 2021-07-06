# [5. Opérateurs](https://www.youtube.com/watch?v=OgPU8mFAgro)

Bonjour à tous nous nous retrouvons pour cette 5e vidéo en Java pour faire la suite, un petit peu, de ce que nous avions vu précédemment concernant les variables et les constantes, pour aborder les opérateurs.

Alors les opérateurs, on en a vu quelques-uns précédemment.
On va avoir aussi des nouveaux et il y en a qui seront utilisées que nous allons beaucoup beaucoup exploité dans des vidéos qui suivront par la suite.

Alors on va retourner sur un code ici.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		
	}
}
```

Donc un code vraiment minimal, d'accord, avec notre classe principale et notre méthode main qui permet directement d'avoir notre point d'entrée, je rappelle, pour notre programme.

On avait vu précédemment, un premier opérateur qui va être important de souligner c'est l'opérateur d'affectation.

J'ai préparé une petite note ici.
```java
	/*
		[NOTES]
		= Affectation
		
	*/
```

Donc celui-là, le égal (=) c'est notre opérateur d'affectation.
Quand on fait par exemple une variable age ici, une valeur dite en dur c'est-à-dire qu'on note voilà vraiment un nom directement. On effectue une affectation, ça reviendrait grosso modo à dire à ma variable age, tu met en fait la valeur 24 (age <- 24).
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int age = 24; // age <- 24
	}
}
```
Voilà et âge est une étiquette donc un nom pour nous, qui est humainement humainement compréhensible, qui correspond en réalité à une adresse en mémoire et l'adresse en mémoire c'est le compilateur qui lui saura stocker l'information en mémoire et nous on manipule des noms qui sont beaucoup plus pratique pour nous pour pouvoir savoir à quoi ça fait référence en mettant des nombres assez explicite en tout cas.

Voilà à partir de là et on a vu bien évidemment d'après il nous suffit tout simplement, si on veut , d'afficher la variable comme ceci.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int age = 24; // age <- 24
		System.out.println(age);
	}
}
```
```powershell
	>javac MainApp.java
	>java MainApp
	24
```
Et là nous avons, du coup, automatiquement l'affichage de notre variable.
Donc ça opérateur d'affectation, on l'a déjà vu jusqu à présent, on connaît bien.

On va en voir un petit nouveau qui va vous êtes très très utile qui concerne, qui permet en tout cas de concaténer aussi bien du texte, encore des chaînes de caractères avec le contenu d'une variable.

Si par exemple, au lieu d'afficher directement une information ici (24) qui voilà, on ne sait pas forcément à quoi ça fait référence.

On préfèrera afficher un texte suivi de la valeur de la variable, on pourra procéder de cette manière. 

Alors ça va être très simple à mettre en place, la partie qui est de la chaîne de caractères du simple texte, d'accord, qui va être affiché tel quel, on le met dans des doubles guillemets, d'accord, double côte comme ceci. On met, par exemple, "Tu as " quelque chose et on entour donc la suite du texte comme ceci.
Je met des espaces puisqu'il faut évidemment pas que la valeur de la variable soit coller.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int age = 24;
		System.out.println("Tu as "age " ans");
	}
}
```
Alors ici ça n'a évidemment aucune importance, tout ce qui se trouve en dehors, ici, des 2 chaînes de caractères donc on en a une, ici, `"Tu as "` et une 2e là `" ans"`. 
Vous pouvez tout coller ensemble, vous pouvez mettre des espaces, peu importe, moi je mets des espaces habituellement et vous faites comme vous voulez.

Et pour concaténer donc ces 3 valeurs c'est-à-dire "tu as " avec un espace, il y a bien un espace ici. La valeur, ce que contient la variable age. On ne veux pas avoir à écrire le mot age et ensuite un espace et le mot ans avec un S `" ans"`.
On utilisera le symbole plus et le symbole plus va permettre de faire la concaténation de tout ça. 

```java
public class MainApp
{
	public static void main(String[] args)
	{
		int age = 24;
		System.out.println("Tu as " + age + " ans");
	}
}
```

Donc je recompile et voilà là concrétisation se fait aussi bien avec les chaînes de caractères et la variable pour récupérer tout simplement sa valeur.
```powershell
	>javac MainApp.java
	>java MainApp
	Tu as 24 ans
```
Donc ça c'est le petit opérateur à connaître pour la concaténation.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
	*/
```
Voilà, deux opérateurs très simple l'affectation et la condamnation.

C'était les premières choses que je voulais vous montrer.

Maintenant on va aborder des opérateurs que vous connaissez parfaitement puisque vous les avez manipulé à l'école, vous les utiliser même peut-être très régulièrement, un petit peu tous les jours par habitude tout simplement.

## Les opérateurs arithmétiques

Ce sont les opérateurs qui permettent de faire des calculs, les opérateurs arithmétiques.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / %
	*/
```
Donc on l'oppérateur plus (+) que nous allons ici réutiliser pour faire les additions, les sommes, on aura donc l'opérateur moins (-) donc c'est le tirer du 6 sur votre clavier pour faire des soustractions, on utilisera l'astérisque (*) donc la petite étoile pour effectuer des multiplications et le slash (/) pour faire des divisions.

On a également avec ça un autre opérateur que vous ne connaissez peut-être pas qui est très utilisé en informatique mais qu'on utilise beaucoup moins quand même on va dire dans le quotidien qui est l'opérateur modulo (%) représenté par le symbole pour cent.

L'opérateur modulo, c'est très simple, dans la division ici (/), on vous faisait effectué une division euclidienne donc ça vous retourne son résultat et bien le modulo (%), c'est l'inverse dire que ça vous donne pas en fait ...l'inverse, c'est pas vraiment l'inverse mais ça ne vous retourne pas le résultat d'une division euclidienne mais le reste, s'il y a un reste à cette division.

Par exemple, tout bête.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int result = 5 / 2;
		System.out.println(result);
	}
}
```
Si je fais 5 divisé par 2 comme ceci.
Alors on va manipuler évidemment des entiers donc on aura que la partie entière mais peu importe, on va pas manipuler des flottant.
```powershell
	>javac MainApp.java
	>java MainApp
	2
```
Voilà on obtient 2, ce qui est logique.

5 divisé par 2, c'est 2 fois 2, 4 mais par contre voyez aucune aucune information sur le reste de la division.

Et en revanche si on récupère le modulo de cette division euclidienne là, on aura son reste et le reste c'est bien 1 puisque de 4 pour aller à 5 il vous suffit d'ajouter 1 tout simplement.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int result = 5 % 2;
		System.out.println(result);
	}
}
```
```powershell
	>javac MainApp.java
	>java MainApp
	1
```
Donc voilà, petit opérateur, un peu nouveau. Je vais assez vite dessus, c'est des choses que vous savez faire, je pense, au niveau des calculs.

Donc pour faire ses calculs vous avez vu je les met directement dans l'expression ici (5%2).
```java
	int result = 5 % 2;
```
C'est-à-dire que je vais dire, le résultat de ce calcul, tu vas l'affecter en mémoire, donc dans l'adresse , en fait, qui est représenté par ma variable "result", tout simplement.

Donc ça "5 % 2", c'est ce qu'on appelle une expression.
Une expression comme on a déjà vu, ça peut être une valeur en dur, une simple valeur comme ceci (2).
Ca peut être toute une suite d'opérations et de calcul avec des opérateurs.
Ca pourrait être comme on le verra plus tard, le retour d'une méthode et ça pourrait voilà tout un tas d'autres choses. 
Et également d'autres variables on peut très bien faire également comme ceci, ça on connaît bien, et dire que result, c'est tout simplement on affectent la valeur de number à result.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int number = 4;
		int result = number;
		System.out.println(result);
	}
}
```
```powershell
	>javac MainApp.java
	>java MainApp
	4
```
on se retrouve bien sûr avec la même chose d'accord puisque number on lui affecté la valeur de 4 en dur et comme on dit que result, on lui affecter la valeur de number contenu dans cette variable là (number), on retrouve 4 aussi.

Donc ça très simple, ce sont les opérateurs arithmétique, ce sont donc les opérateurs de calcul. Je ne veux pas leur donner un nom, vous les connaissez suffisament comme ça.

Et on va passer à d'autres petits opérateurs donc cette vidéo est assez courte. On va aller assez vite quand même dessus mais je voulais faire une vidéo juste sur la la question des opérateurs et des opérateurs que nous allons utiliser pour les comparaisons. 

D'ailleurs, je l'ai pas mentionné mais bon je pense que vous l'avez compris aussi, on retrouve les parenthèses, d'accord, pour par exemple la priorité des opérateurs.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
	*/
```
Petit rappel de mathématique, très rapide.
Quand vous faites par exemple ce calcul là.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int result = 4 + 5 * 2;
		System.out.println(result);
	}
}
```
4 plus 5 fois 2.

Je rappelle que la multiplication et là division y compris le modulo en informatique sont prioritaires par rapport à l'addition et là soustraction, d'accord. 

C'est-à-dire que là vous ne devez pas faire ce calcul en premier (4+5), vous devez faire la multiplication (5*2), le 5 fois 2 qui vous donne 10 et ensuite seulement vous ajoutez 4 à 10 pour avoir 14. Sinon, vous faites 9 fois 2 égal 18 donc là vous n'aurez pas le même résultat.

Donc évidemment la priorité des opérateurs en mathématiques, en arithmétique, se retrouve bien sûr en informatique.

Si par contre je veux forcer le calcul ici (4+5) comme en mathématiques aussi, on peut bien sûr utiliser des parenthèses qui vont du coup changer l'ordre de priorité des opérations parce que la parenthèse est prioritaire par rapport aux opérateurs de calcul.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int result = (4 + 5) * 2;
		System.out.println(result);
	}
}
```
Donc c'est ça qui sera fait en premier (4+5) et ensuite ce résultat là qui est englobant, en fait, va être multiplié par 2.

Donc pareil en informatique vous pouvez vous servir de ces opérateurs là il n'y a absolument aucun problème.

Voilà comment ça se passe.

Passons aux opérateurs de comparaison, pareil, ce sont des opérateurs de mathématiquement mais on va les noter rapidement, on va les utiliser plus en détail dans d'autres vidéos. Là je voulais les énumère juste rapidement mais il y a des petites subtilités en informatique.

On a vu que l'opérateur égal (=) sert à l'affectation et comme on parle de comparaison, de test ou ce genre de chose, si on veut utiliser un opérateur d'égalité, vérifier, par exemple, qu'une valeur est égale à autre chose. Comment allons-nous faire ? existe-t-il... va-t-on utiliser le égal aussi ? alors non parce que sinon on effectuerait une affectation et du coup ça ne va pas donc en informatique, le problème est très vite résolu en doublant le égal (==), voilà ça c'est un opérateur d'égalité. OK, c'est le l'opérateur double égal.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		==
	*/
```
Si on veut également vérifier le type de 2 informations donc je vous dis ça, je vous les énumère rapidement. On les verra plus en détail dans une autre vidéo, On triple le égal (===).
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== ===
	*/
```
Donc on vérifie à la fois la valeur de 2 variables, par exemple, deux expressions mais également le type de la formation, d'accord, par exemple, si on fait ça. Si on test 14 et ceci "14" avec un double égale, donc voilà je fais ça comme ça, je note ça comme ça.
```java
	// 14 == "14"
```
Si on faisait cette vérification là comme on le verra plus tard quand on fera des conditions avec le double égal, ça fonctionnera parce que ça pour lui c'est 14 et ça "14" c'est 14.

Par contre à partir du moment où je vérifie, je fais une vérification du type, là on a une chaîne de caractères "14" et là on a un nombre 14 donc évidemment ça ne passera plus, le test ne sera pas validé.

Vous voyez qu'on a on a un petit différence, comme ça, mais on le verra évidemment plus tard.

On a le symbole différent donc pour dire "différent de" pour faire une différence donc l'inverse de l'égalité on met un !=, OK.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== === !=
	*/
```
Et ensuite on a le symbole mathématique vous connaissez très bien le inférieur à (<), le inférieur ou égal à (<=) donc on met toujours le égal après.

On a le supérieur à (>), supérieur ou égal à (>=) donc ça c'est des choses que vous connaissez en mathématiques donc logiquement voilà ça vous posera un problème informatique aussi.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== === != < <= > >=
	*/
```
Et je termine avec quelques petits opérateurs un peu particulier mais que nous allons voir pour l'incrémentation et ça je vous montrerais au niveau de la vidéo parce que c'est intéressant donc on aura notamment l'opérateur beaucoup plus pour tout ce qui est positif c'est-à-dire que là quand vous mettez une valeur positive comme là.
```java
	int result = 14;
```
On pourrait très bien mettre un plus devant, voilà.
```java
	int result = +14;
```
On ne le fait pas par habitude parce que c'est comme ça, c'est par convention. C'est très rare qu'on met un plus devant une valeur positive mais sachez que vous pouvez le faire si vous le voulez.

Par contre si on veut mettre moins 14, on mettra naturellement le moins, OK. Donc ça a pas de problème.
```java
	int result = -14;
```
Et si on veut l'nverse, ça fonctionnera pas donc on va le faire sur un boolean, vous savez ce que c'est. Si je fais par exemple myvar. Si je met ça, true.
```java
	boolean myvar = true;
```
On va tester mais enfin on aurait pu laisser le nom qu'on avait, ne genaît pas, c'est pas grave hop. Voilà si je fais ça, on voit bien que ça nous donne le résultat true.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		boolean myvar = true;
		System.out.println(myvar);
	}
}
```
```powershell
	>javac MainApp.java
	>java MainApp
	true
```
Si je fais ça, on voit bien que ça nous donne le résultat true parce que c'est ce que contient en fait cette variable.

Si je veux l'inverse et on mettra tout simplement un petit ! et là quand on va avoir une averse de true automatiquement ça va me rendre false, voilà.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		boolean myvar = !true;
		System.out.println(myvar);
	}
}
```
```powershell
	>javac MainApp.java
	>java MainApp
	false
```
Donc ça c'est aussi à connaître, l'opérateur d'inversion en fait, celui là, c'est l'opération en fait de négation donc c'est l'inverse. La négation de quelque chose. on mettra juste un !

Alors voilà là je suis allé assez vite parce qu'encore une fois ça on va aller voir plus tard. On va vraiment les manipuler un peu plus tard donc je voulais juste vous les énumérer pour la vidéo mais sans forcément qu'on les mettre en pratique puis c'est quand même relativement simple et après tout ça "+ - * / % ()", vous connaissez, c'est des mathématiques.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== === != < <= > >=
	*/
```
Donc là, je suis pas là pour faire un cours de mathématiques élémentaires vous savez déjà manipuler tout ça.

## incrémentation et décrémentation

Nous ce qui nous intéressé maintenant, ça va être des opérateurs, donc on va travailler sur des expressions pour tout ce qui est incrémentation et décrémentation et là je pense que même si vous avez fait beaucoup de maths, c'est pas quelque chose qui vous parle en tout cas vous avez sûrement manipuler en mathématique.

Donc l'incrémentation, la décrémentation, c'est tout simplement l'ajout de d'une valeur à une autre ou le retrait donc une soustraction et pour ça nous avons plusieurs possibilités. 

Alors je vais prendre un exemple très simple, du genre des points d'expérience par exemple dans un jeu vidéo. Si on prend cet exemple-là, on a un personnage qu'on fait progresser dans un 
environnement et au fur et à mesure de sa progression, il gagne des points d'expériences ce qui lui permet de monter de niveau alors je pense que l'exemple parle à tout le monde donc on va faire par exemple.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int experience = 0;
		System.out.println(experience);
	}
}
```
int, on va mettre expérience. On va faire ça comme ça. Donc au départ, il a 0. Je vais peut-être l'afficher, voilà.

Il a 0, il effectue donc une progression, d'accords, dans le jeu et à un moment donné son expérience augmente. On est parfaitement d'accord.

Et je vous montre ici très rapidement que si je fais ça. Par exemple, il a gagné pas moins de 10 points d'XP en faisant voilà une certaine progression.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int experience = 0;
		experience = 10;
		System.out.println(experience);
	}
}
```
Si on met ça alors au niveau du, on va dire, du visuel si on fait un affichage, on va avoir l'impression qu'effectivement, nous avons gagné 10 points d'expérience parce que au départ on part de 0 et après on arrive à 10 comme on le voit ici dans l'affichage de la console.
```java
	>javac MainApp.java
	>java MainApp
	10
```
On peut se dire que oui, on a effectivement gagné 10 points d'expérience mais admettons plus tard, il gagne maintenant 100 points d'expérience. 

Qu'est-ce qu'on fait alors, on fait ça, d'accord ?
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int experience = 0;
		System.out.println(experience);
		experience = 10;
		System.out.println(experience);
		experience = 100;
		System.out.println(experience);
	}
}
```java
```powershell
	>javac MainApp.java
	>java MainApp
	0
	10
	100
```
Et là, on se renconte qu'il y a un problème, on passe de 10 à 100 alors qu'on a gagné 100.

Là au final, on n'a gagné que 90 donc on a perdu toute l'expérience gagnée d'avant et ça évidemment, c'est absolument pas possible.

Donc on va avoir besoin de dire : "Et bien tu conserve tout ce que tu avais avant mais tu ajoutes quelque chose de nouveau mais on veut absolument pas perdre ce qui avant." 

C'est comme s'il y avait de la monnaie, c'est exactement pareil et je mettais de la monnaie, genre en pièces d'or, n'importe quoi.
comment je peux mettre... goldCoins, voilà.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int goldCoins = 0;
		System.out.println(goldCoins);
		goldCoins = 10;
		System.out.println(goldCoins);
		goldCoins = 100;
		System.out.println(goldCoins);
	}
}
```
```powershell
	>javac MainApp.java
	>java MainApp
	0
	10
	100
```
Si je fais ça, c'est évidemment la même chose. C'est même plus parlant d'ailleurs, voilà.

On avait 10 pièces d'or, on en gagne 100 et on se retrouve à 100 alors qu'on devrait à 110. On a perdu 10 pièces d'or dans l'histoire, c'est peut-être pas cool, non plus.

Donc pour cette partie là, on va effectuer une incrémentation et on a du coup plusieurs opérateurs qui seront, en tout cas, qui vont nous permettre de raccourcir les écritures, ou alors une simple affectation très simple avec un calcul que vous êtes tout à fait capable de faire avec les opérateurs arithmétiques.

Ici, qu'est-ce que ça veut dire ? ça veut dire que ... alors là on peut dire "Gain de 10 pièces d'or" ... je vais mettre un commentaires pour qu'on comprenne bien. 
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int goldCoins = 0;
		System.out.println(goldCoins);
		goldCoins = 10;//Gain de 10 pièces d'or
		System.out.println(goldCoins);
		goldCoins = 100;//Gain de 10 pièces d'or
		System.out.println(goldCoins);
	}
}
```
Qu'est-ce que ça veut dire ? Et bien ici on part de 0 très bien mais là ...
```java
	goldCoins = 10;
```
... Je ne vais pas faire une affectation d'une nouvelle valeur en brut, je vais faire une affectation, en fait, de ce qu'on avait précédemment en pièce d'or, plus ce qu'on y ajoute donc je vais plutôt faire ceci. 
```java
	goldCoins = goldCoins + 10;//GAin de 10 pièces d'or
```
Donc c'est ça l'expression, les pièces qu'on a actuellement, les pièces d'or qu'on a actuellement et un simple calcul où on ajoute ce qu'on vient de gagner et tout ceci (goldCoin + 10) on l'affecte à la variable (goldCoin).

Donc on va remplacer l'ancienne valeur de goldCoins par une nouvelle, à laquelle, on aura rajouté ici + 10 et on va faire exactement la même chose en dessous.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int goldCoins = 0;
		System.out.println(goldCoins);
		goldCoins = goldCoins + 10;//Gain de 10 pièces d'or
		System.out.println(goldCoins);
		goldCoins = goldCoins + 100;//GAin de 10 pièces d'or
		System.out.println(goldCoins);
	}
}
```
```powershell
	>javac MainApp.java
	>java MainApp
	0
	10
	110
```
Et là, bien sûr, on corrige le soucis qu'on avait tout à l'heure c'est-à-dire de perdre des pièces donc on passe bien à 110 au lieu de 100. On n'a pas perdu de pièces d'or dans... encore une fois, dans la progression.

Donc ça c'est une écriture, voyez, un petit peu longue pas forcément très pratique qui peut amener des erreurs ou autres.
```java
goldCoins = goldCoins + 10;
```
En informatique, il y a des écritures un peu plus raccourcis qui permettent de faire ça. 
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== === != < <= > >=
		
		+= -= *= /= %=
	*/
```
On va retrouver, quand il s'agit d'ajouter quelque chose, le plus égal (+=).
On a le moins égal donc c'est le retrait.
On a le astérisque égal pour la multiplication et la division par un slash égal et le modulo égal.

Donc ça revient à faire quoi tous ces trucs-là ? c'est de dire tout simplement qu'au lieu de faire A, par exemple, égal A plus X, et bien on fera A plus égal X, okay. 

Si on veut faire A égal mmoins x c'est à dire qu'on a perdu l'argent par exemple donc on fera A moins égal X.

Donc voyez en fait on enlève tout simplement le A qu'on répète ici A = A - x, on fait ça A -= x.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== === != < <= > >=
		
		+= -= *= /= %=	----> 	A = A + x
								A += x
								
								A = A - x
								A -= x
	*/
```

C'est vraiment juste ça en fait l'écriture raccourci, tout simplement.

Donc voilà ces différents opérateurs raccourci qui vous permettront de gagner un petit peu de temps dans les syntaxes que vous l'avez.

Donc ici, je fais ça. Je fais pareil voilà ce que j'obtient.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int goldCoins = 0;
		System.out.println(goldCoins);
		goldCoins += 10;//Gain de 10 pièces d'or
		System.out.println(goldCoins);
		goldCoins += 100;//GAin de 10 pièces d'or
		System.out.println(goldCoins);
	}
}
```
```powershell
	>javac MainApp.java
	>java MainApp
	0
	10
	110
```
C'est évidemment le même résultat que ce qu'on avait plus haut, d'accord.
Les 2 écritures sont tout à fait juste, c'est à vous de choisir celle que vous voudrez : l'écriture raccourci ou non, donc voilà.

Donc ça, c'est à connaître, un des petits opérateurs pratique pour tout ce qui est incrémentation décrémentation.

Maintenant en informatique, nous avons une des incrémentations un peu particulière par exemple quand on veut ajouter un où retirer un.

Je ne sais pas, par exemple, vous voulez lire un fichier, vous verrez plus tard, on apprendra pas mal de choses comme ça. Pour lire un fichier, on va par exemple lire chacune des lignes, la première ligne, la 2e, la 3e, la 4e, on a une histoire d'incrémentation de 1. Ligne 1, on rajoute 1, ça fait ligne 2, on rajoute 1, ligne 3 et cetera.

Une imprimante qui va imprimer des pages, pareil, elle va imprimer une page 1, une page 2, page 3 et cetera. 

On a souvent en informatique comme ça une histoire d'incrémentation ou l'inverse une décrémentation de 1, toujours plus 1, plus 1, plus 1, moins 1, moins 1, moins 1.

Donc pour ça, plutôt pareil de faire ceci. A égal A moins 1 ou de faire A égal A  plus 1.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== === != < <= > >=
		
		+= -= *= /= %=
		
		A = A - 1
		A = A + 1
	*/
```
Ou même A plus égal 1 ou A moins égal 1, voilà.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== === != < <= > >=
		
		+= -= *= /= %=
		
		A = A - 1
		A = A + 1
		
		A += 1
		A -= 1
	*/
```
Donc plutôt que de faire toutes ces choses là, on peut plus rapidement faire A plus plus ou alors plus plus A, A moins moins ou bien A moins moins.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== === != < <= > >=
		
		+= -= *= /= %=
		
		A++ | ++A
		A-- | --A
	*/
```
On comme ça une incrémentation donc ça c'est pour faire ... alors on ne peut pas faire par exemple, il n'y a pas une syntaxe qui existent pour faire plus 2, moins 2, plus 3, moins 3.

Si vous voulez si vous voulez faire plus 2, moins 2, plus 3, moins 3, plus 4 et cetera, il faut utiliser ces opérateurs (+= -= *= /= %=) obligatoirement, en tout cas, c'est deux là (+= -=) pour faire du plus ou du moins.

C'est seulement pour ajouter un où retirer un et là vous allez remarquer qu'il y a 2 syntaxes différentes, il y a une syntaxe où l'on met l'opérateur après le nom de la variable (A++) et un autre où on le met avant (++A), d'accord. Ca c'est ce qu'on appelle l'opérateur de post incrémentation (A++) et ça c'est l'opérateur de pré incrémentation (++A). Ca (A--) c'est post-décrémentation et ça (--A) c'est pré décrementation. Je vais mettre comme ça je vais écrire rapidement.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== === != < <= > >=
		
		+= -= *= /= %=
		
		A++ post-incrémentation
		++A pré-incrémentation (celui là c'est l'inverse de A++)
		A-- post-décrémentation 
		--A pre-décrémentation
	*/
```

Et la différence, vous allez très vite la comprendre, elle tient pour des raisons de performance oui, non parce que ça va quand même changer maintenant avec la capacité de nos compilateur actuelle et des outils qui permettent quand même de corriger beaucoup de choses mais en gros ça va dépendre de l'ordre dans laquelle nous effectuons les opérations.

On sait qu'une affectation, c'est une instruction d'accord.
L'affectation, c'est une instruction qui est faite en informatique, la concaténation, pareil, l'addition aussi. Toutes ces choses là, ce sont des instructions.
```txt
		A = A + 1
		A += 1
```
Bien quand on fait ça, par exemple, A plus plus (A++) ou même plus plus A (++A), on va prendre cet exemple. On a dit que c'était une écriture raccourci pour éviter de devoir faire ça, A égal A plus 1 (A=A+1) ou de faire A plus égal 1 (A+=1), ce qui sera un peu plus long.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== === != < <= > >=
		
		+= -= *= /= %=
		
		A = A + 1
		A += 1
		
		A++ post-incrémentation
		++A pré-incrémentation
		A-- post-décrémentation 
		--A pre-décrémentation
	*/
```
Mais là quand on regarde bien en fait, on n'a pas qu'une seule instruction qui est faite, on n'a pas qu'un seul calcul. On a quoi ? On a une somme qui est faite (A+1) et ensuite on a une affectation (=). C'est comme si je faisais ça en fait. Je peux mettre des parenthèses ce serait pareil.
```txt
		A = (A + 1)
		A += 1
```
Je fais ça. Ca tombe bien, la post incrémentation, c'est quoi ?
La post incrémentation, en fait, c'est que nous allons faire l'affectation, d'accord, c'est-à-dire que nous allons faire une copie de notre variable ici A (A = A), que nous allons affecter là (A_).
```txt
		A_ = A + 1
```
Et on va, à ce résultat ensuite ajouter plus 1.

D'accords, il y a 2 choses qui vont se faire en 2 temps.

En revanche, la pré incrémentation, on va d'abord incrémenter A de 1 (A + 1) donc c'est comme si on avait mis la priorité à l'incrémentation d'abord pour ça qu'on parle de près, c'est avant. Près incrémentation donc en fait avant l'affectation
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== === != < <= > >=
		
		+= -= *= /= %=
		
		A = (A + 1)
		
		A++ post-incrémentation
		++A pré-incrémentation
		
		A-- post-décrémentation 
		--A pre-décrémentation
	*/
```
Donc on ajoute un à la variable A et ensuite on affecte tout ça comme valeur pour la variable A, comme nouvelle valeur.

Et c'est pareil pour la post-décrémentation, près-décrémentation.

En post-décrémentation on va d'abord faire une copie pour affecter une valeur et ensuite on retire un.

En prés-décrémentation, on va d'abord retirer un et ensuite on fait l'affectation.

Voyez c'est l'ordre dans lequel on fait les calculs.

Post, on fait toujours l'incrémentation oo la décrémentation après.

Alors que pré, on fait d'abord l'ajout ou le retrait de 1 et ensuite on affecte, ça fait vraiment dans cet ordre là.

Pourquoi en tout cas cette différence ? Qu'est-ce qui change en fait dans l'un ou dans l'autre ? 

Alors pour la manipulation de type qu'on connaît de variables comme par exemple des entiers ou autre, au niveau des différences en termes de performance au autre, il n'y en pas vraiment, d'accord.

Tout simplement parce qu'encore une fois les outils d'aujourd'hui sont suffisamment puissant, sont suffisamment optimisé pour gérer tous ces cas là.

Mais là où ça pourrait devenir différent alors soit parce qu'on utilise un compilateur vraiment pas optimisé donc c'est-à-dire un vieux truc ou alors que vous manipulez des données un peu plus complexe, un peu plus grosse ... là où ça va se jouer, c'est la différence entre les 2, pourquoi ?

Tout simplement parce que ici (A++), vous allez copier, d'accord, vous allez faire votre copie, en fait, de données.

Et si admettons que vous avez, je sais pas moi, une l'énorme quantité de données à copier et bien ça va évidemment ralentir les performances, donc ça va réduire les performances de votre programme.

Donc en général quand on veut faire des incrémentations sur des données un peu complexe, on vous dira très souvent et c'est tout à fait tout à fait vrai là dessus, tout à fait justifié d'utiliser la pré-incrémentation ou la pré-décrémentation parce que nous allons faire le calcule d'abord et ensuite nous allons affecter, si évidemment il y a une affectation à faire, sinon si il n'y en a pas on fera juste ça.
```txt
		A++ post-incrémentation
		++A pré-incrémentation
		
		A-- post-décrémentation 
		--A pre-décrémentation
```
Mais dans la post-incrémentation ou la post-décrémentation, on fait vraiment une copie des données et ensuite on incrémente ou on décrémente donc ça pourrait du coup posé pas mal de soucis.

Alors je peux vous montrer sur un exemple pour envoyer un petit peu, la différence en fait entre ces deux notations. On va mettre le plus plus moins moins et on terminera la vidéo avec ça.
```java
	/*
		[NOTES]
		= Affectation
		+ Concaténation
		
		+ - * / % ()
		== === != < <= > >=
		
		+= -= *= /= %=
		
		A = (A + 1)
		
		++ --
	*/
```
Je ne voulais pas forcément vous montrer d'autres trucs normalement donc on verra déjà avec ça.

Alors qu'est-ce que je peux mettre comme exemple ?

on va prendre deux variables, on va mettre nb1 = 1, ce genre de chose. int nb2 et on va mettre nb1++. Voyez dans nb2, je met nb1++ donc je fais une post-incrémentation et on va afficher les 2.

C'est bien d'en parler parce que ce soit quelque chose qui peut par fois posé un peu de problème pour ceux qui démarrent en programmation donc je pense que c'est bien de le voir dès le début comme ça le problème sera vite réglé. Vous pourrez comme ça ne pas être bloqué par rapport à ça et bien avancée pour la suite.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		int nb1 = 1;
		int nb2 = nb1++;
		
		System.out.println(nb1);
		System.out.println(nb2);
	}
}
```
Donc voilà je vais afficher nb1, nb2. C'est tout simplement ce que je vais faire. 
```powershell
	>javac MainApp.java
	>java MainApp
	2
	1
```
Donc on regarde ce qui se passe et là on se rend compte que nb1, il est égal à 2, d'accord, alors que nb2 est resté à 1.

Et donc là déjà, ça c'est une chose, okay.
euh oui donc voilà, on va laisser cet exemple là. 
Maintenant ce que je vais faire, je vais changer les opérateurs, je laisserais comme ça dans la console, on verra la différence.

On va refaire une compilation et une éxécution pour voir ce qui a bougé.

```java
public class MainApp
{
	public static void main(String[] args)
	{
		int nb1 = 1;
		int nb2 = ++nb1;
		
		System.out.println(nb1);
		System.out.println(nb2);
	}
}
```
```powershell
	>javac MainApp.java
	>java MainApp
	2
	2
```
Et on se rendre compte que les 2 ont exactement la même chose donc voilà aussi une différence très importante entre la post- incrémentation et la pré-incrémentation.

Lorsque l'on faisait ça.
```java
		int nb1 = 1;
		int nb2 = nb1++;
```
On avait ce code là, on a eu ce résultat là.
```txt
		2
		1
```
nb1 est égal à 2 et nb2 est égal à 1, tout simplement.
Pourquoi parce que lorsqu'on fait ce calcul;on a effectivement affecté donc nb1 à nb2 donc regarder nb1 est égal à 1 donc nb2, du fait qu'on retrouve 1 pour nb2, c'est normal.
Voilà on dit à nb2, tu mets 1 donc on retouve bien 1.

Par contre, après on a fait une incrémentation de nb1. D'accord c'est une post-incrémentation, elle est venu après l'affectation, d'accord.

On n'a pas dit en fait tu mets 1 plus 1 dans nb2, non on a dit tu mets 1 dans nb2 et ensuite tu incrémente nb1 de 1 et du coup on retrouve en toute logique nb1 est égal à 2.

Il y a eu 2 calculs qui ont été fait. Il y a une affectation c'est comme si en fait on avait fait ça.
```java
	int nb2 = nb1++; //nb2 = nb1 puis nb1 += 1
```
Ce n'est pas facile à expliquer dans une vidéo, c'est pour ça que je voudrais pas vous embrouiller.
Ca en fait c'est comme si on avait fait ça (nb2 = nb1 puis nb1 += 1). nb2 égal nb1, OK donc on voit que nb1 est égal à 1 donc pas de souci puis on a fait nb1 += 1, voilà. Et là je pense que vous comprenez du coup encore mieux pour qu'on a du coup ce résultat là.

Comme on a augmenté nb1 de 1, on le retrouve à 2 par contre voyez nb2 égal nb1 à son état de départ quand il était égal à 1, voilà.

Et en revanche quand on fait la pré-incrémentation et bien on dit tout simplement d'incrémenter, d'accord, ce qu'on a ici à droite donc nb1 (++nb1), donc on va faire en fait 1+1, on fait ce petit calcul là et ça on le met dans une nb2.
```java
	int nb2 = ++nb1; //nb2 <- (1+1)
```
Donc le 1 + 1, c'est quoi en fait ? c'est deux nb1. On a dit à nb1 qui est égal du coup à +=1 donc à lui-même, puis on a dit nb2 = nb1. 
```java
	int nb2 = ++nb1; //nb1 += 1 puis nb2 = nb1
```
Comme nb1 était déjà égal à 2 avant, c'est pour ça qu'une fois qu'on fait c'est pré-incrémentation (++nb1), nb2 est aussi égal à 2 et on retrouve du coup les mêmes valeurs, donc voilà.

Ca c'est vraiment important parce que vous voyez qu'en fonction de l'ordre dans lequel on fait l'incrémentation où la décrémentation, c'est la même chose pour la décrémentation, on va pas obtenir le même résultat à la fin pour les 2 variables. Faites attention à ça de ne pas vous tromper si vous voulez être sûr d'avoir les mêmes choses à l'arrivée faites la pré-incrémentation ou la pré-décrémentation et sinon si il n'y a pas d'histoire, par exemple, de manipulation de données complexes ou autre, vous pouvez utiliser la post-incrémentation ou post-décrémentation sans souci.

Donc faites attention, soyez vigilants quand même quand vous manipulez ces opérateurs là d'être sûr d'avoir bien le résultat que vous attendiez et pas autre chose et si vous voyez qu'il y a des différences dans vos résultats de 1 ou un écart de 1, c'est qu'à priori vous avez fait une erreur justement sur l'ordre comme ça de l'incrémentation et c'ést peut être ça que vous avez à corriger dans votre code.

Voilà donc je voulais en tout cas ... bon j'ai pris pas mal de temps quand même j'avoue à expliquer ça mais comme je dit c'est un problème qu'on retrouve beaucoup beaucoup pour ceux qui apprennent l'informatique et la programmation, qui galère énormément avec ça.

Donc je pense que c'est bien de voir ça dès le début dès le début de votre apprentissage d'un langage plutôt que d'attendre après x heures ou vous avez étudié justement un langage avant de vous dire : " Ah au faite, il faut faire attention à ça". Comme ça, je pense que dès qu'on le voit dès le départ et bah ça nous évite de faire des erreurs plus tard et de prendre des mauvaises habitudes.

Et voilà bah je pense que pour les opérateurs, on va s'arrêter. Je regarde un petit peu si je n'ai pas oublié en tout cas de ceux que je voulais vous montrer là.

Il y a évidemment plein d'autres opérateurs mais pour ceux que vous aurez vraiment l'utilité, ils sont présentés ici après voilà les autres c'est des choses pas forcément utile par rapport à ce que nous allons faire sur la formation. Et puis de toute façon, on va en manipuler beaucoup, les opérateurs de comparaison notamment, on verra un peu comment ça se passe.

Alors je ne l'ai pas montré dans la vidéo parce que je ne pouvais pas tout montrer non plus complètement au détail un par un, mais bien évidemment, je vais pas tout enlever, on va terminer avec ça, vous pouvez  tester les opérateurs de comparaison, ici dans une expression, vous faites ça et vous dites par exemple 14 est-il plus petit que 25 et là si je teste ce programme.
```java
public class MainApp
{
	public static void main(String[] args)
	{
		boolean result = 14 < 25;
		System.out.println(result);
	}
}
```
```powershell
	>javac MainApp.java
	>java MainApp
	true
```
Un booléen parce qu'on fait des tests de comparaison donc ça va retourner vrai au faux.
Hop là juste en faisant ça, ça peut du coup faire des tests de comparaison ici.
Une expression, on fait un test de comparaison qu'on stocke dans une variable donc un booléen, True ou false en fonction.
Voilà donc 14 est bien plus petit 25 donc on a true.

Voilà donc ça c'était la petit détail de fin pour cette vidéo que je voulais vous montrer.

Je vais vous laisser avec ça, on continuera de toute façon pour la suite, on va voir beaucoup de choses, on va manipuler évidemment tous ces opérateurs là. Je voulais vraiment vous en montrer pas mal, montrer très rapidement comment ils fonctionnaient et faire des prévisions au niveau des opérateurs arithmétique que normalement vous savez manipuler sauf voilà exception pour le modulo qui est surement nouveau pour la grande majorité d'entre vous et je vous dis à bientôt pour la prochaine séance en Java.

ciao