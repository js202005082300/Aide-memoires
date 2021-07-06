# [3. Types de données](https://www.youtube.com/watch?v=7Buk7i_RGok)

+ [Types de données](#Types-de-données)
+ [Type de données vues](#Type-de-données-vues)
+ [Les caractères spéciaux](#Les-caractères-spéciaux)
	
## Types de données

Dans cette vidéo, nous allons parlé des types de données que l'on va pouvoir manipuler avec ce langage dans cette vidéo qui ne sera pas très longue mais qu'il faut faire pour aborder tout les types de données que nous allons manipuler pour que dans la suite, le prochaine séance, nous aborderons la notion très importante en programmation qui concerne les variables.

Tout les types de données ont été récapitulé dans un tableau afin de voir tout les types de données qu'il y a. On ne les manipulera pas tous au départ de toute manière.
```txt
TYPE PRIMITIF | TYPE "OBJET" ASSOCIE | PLACE EN MEMOIRE | FOURCHETTE DE VALEURS (MIN&MAX)
boolean		Boolean		1 octet		true (1) | false (0)
byte		Byte		1 octet		-128 à 127
char		Character 	2 octets	Unicode (65536 caractères disponibles)
short		Short		2 octets	-32768 à 32768
int			Integer		4 octets	-2 147 483 648 à 2 147 483 647
long		Long		8 octets	-2^63 à 2^63 -1
float		Float		4 octets	1,4x10^-45 à 3,4x10^38
double		Double		8 octets	4,9x10^-324 à 1,7x10^308
```
Voici les type de données qui sont disponibles et qu'on peut manipuler avec ce langage dans le tableau ci-dessus.

Grosso modo, nous avons des types spéciales que nous connaissons pas si nous n'avons jamais programmé de notre vie. Par exemple, le type booléen. 

Un booléen c'est tout simplement une donnée qui peut prendre deux valeurs. Elle peut prendre la valeur vrai, true en anglais qui correspond au chiffre 1. Ou bien false pour faux qui correspond au chiffre 0 donc on utilisera ce que l'on appelle des types primitifs et parmi ces types primitifs nous avons justement ce type boolean qui manipulera ça.
	
Pour chacun des types de ce tableau, on a le type "objet" associé puisque Java est un langage objet qui utilise exclussivement ce paradigme là et on verra que l'on va pouvoir utiliser des classes associées au type primitif pour manipuler tout un tas de choses.

Dans les prochaines vidéos, nous allons voir comment créer notre première classe en Java et comment manipuler tout ça, des attributs, écrire des méthodes ou ce genre de choses. 

Voilà donc grosso modo, les types que nous avons besoin de connaître.

Le type byte, c'est vraiment si on veut stocker un très petit nombre. On voit que le nombre sur la fourchette de valeurs peut être de -128 à 127. Si par exemple, on veut stocker le nombre 10, qu'on veut stocker un nombre qui n'ira jamais en dessous de -128 et au delà de 127, on peut utiliser ce type byte ici.

La place en mémoire, c'est tout simplement l'occupation, la place qu'il va prendre dans notre mémoire vive. On a des barettes de RAM sur notre ordinateur et dans ces barettes mémoires, on a peut être 4, 8, 16, 32 Giga de RAM ou peut être même moins que 4. On a donc un certains nombre de place, vous obtenez des gigas. Par exemple 4 giga de RAM, nous avons 4 giga octets de mémoire, c'est à dire que l'on a 4.000 méga octets de mémoire et donc beaucoup plus d'octet en mémoire.

Sous la colonne "PLACE EN MEMOIRE", on a la place e mémoire qu'occupe chacun de ces types. Ce n'est pas énorme du tout par rapport aux ordinateurs actuels avec les mémoires que nous avons mais à l'époque c'était très important.

Pour autant, il est recommandé de toujours gardé cette habitude de choisir le type qui prendra le moins de place possible en mémoire. En effet si un jour, on est amené à travailler sur des systèmes embarqués, des systèmes qui auront que quelques méga octets, voir kilo octets e mémoire vive. A ce moment là, le fait de considérer, de compter chaque octet utilisé au niveau de la mémoire sera important.
	
Pour revenir sur les types que l'on avait dit : 
    + le type booléen ;
    + le type byte pour stocker un tout petit entier. Un nombre entier mais vraiment assez petit. 

On a d'autres types de variables pour stocker d'autres nombres, on a le short qui prend un peu plus de place donc deux octets qui peut déjà stocker un nombre un peu plus grand.

Mais si par exemple, on veut stocker le nombre 1.000.000 ce serait impossible de stocker dans un short. Il y aurait un débordement mémoire, un débordement de capacité par rapport à ce type primitif.

On serra à ce moment là obligé d'utiliser un type un peu plus grand comme par exemple le int. On voit que le int, on peut stocker des nombres un peu plus grand. 

Et ainsi de suite, le long.

Et on a les deux autres types float et double pour les nombre réel. Tout ce qui est nombre à virgule, les nombre décimaux.

Et en fonction du nombre que l'on veut, de la fourchette de valeurs que l'on veut et qui soit disponibles, il occuperont 4 ou 8 octets en fonction.

Nous avons ensuite un type particulier qui est le char, le caracter, qui permet de stocker un caractère Unicode.

Un caractère Unicode est par exemple une lettre, la lettre A majuscule, la lettre b minuscule ou ce genre de chose. On a pour ça la table ASCII ou tout simplement une table Unicode qui permet de retrouver les fameux 65536 caractères disponibles comme ça, on sait quel caractère on peut stocker dans un char. En créant une seule donnée de type char comme on le verra dans la vidéo prochaine, on pourra stocker un seul charactère.
	
Il y a également un type qui n'est pas dans le tableau, le type pour manipuler des chaînes de caractères, des mots, des phrases, tout un ensemble de mots. On ne le note pas ici car on le verra un peu plus tard. Notamment les types objets, c'est à dire qu'il n'a pas de type primitif, de type pour gérer des données sous forme de chaîne de caractères. Il a simplement un type objet qui s'appelle string. On le verra un peu plus tard.

Voilà pour les types de données.

Pour éviter de se perdre et voir ce que l'on peut manipuler en fonction et qu'on a besoin de manipuler un boolean, soit quelque chose qui serra soit égale à vrai ou faux comme un espèce d'intérrupteur on/off, on utilisera ce type.

Si on veut un caractère unique, on utilisera évidemment ce type là.

La majeur partie du temps lorsqu'on veut manipuler un type entier, on utilisera un int qui offre une plage de valeurs assez grande et il n'y a pas forcément besoin sauf dans des cas très spécifiques d'utiliser le type long.

Et dans des cas où l'on veut des valeurs décimales, on utilisera le float ou alors le double.

On arrive quand même à voir dans quel cas d'utilisation, on arrivera à avoir un type ou un autre.

Ca c'est des choses à connaître.

Nous allons maintenant passer au code source et une petite console PowerShell et on exécute rien pour le moment.

```java
class MainApp
{
	public static void main(String[] args)
	{
		System.out.println("Bonjour tout le monde ! :)");
	}
}
```

En réalité, quand on a une classe MainApp comme ici précédemment.
En fait cette classe a une portée, une accessibilité qui est public. Ce n'est pas tout à fait pareil d'avoir class ou public class mais à quelques équivalent prèt.

On va prendre l'habitude de toujours spécifier les choses en fonction de ce que l'on veut faire.

Comme ici, notre class MainApp est public, on doit pouvoir y accéder pour démarrer notre programme, ainsi on mettra explicitement le terme public avant :

```java
public class MainApp
{
	public static void main(String[] args)
	{
		System.out.println("Bonjour tout le monde ! :)");
	}
}
```

Il faut prendre l'habitude dés maintenant de mettre le terme public class devant notre class principale pour avoir notre méthode main. 

Voyons maintenant les types de notations. Il y a moyen de noter différentes valeurs. On verra plutard que pour manipuler des données et notamment des noms en Java. On a plusieurs notations simples. 

On peut noter :

1. un nombre entier tel que 14 par exemple. On peut aussi le noter avec des unités de milliers 18 666 ou bien 100 000.

Par défaut on les noteraient sans aucun espace 18666 ou 100000. Au niveau du code, on va noter ces nombres en durs, de cette manière. Mais Java propose une notation avec des séparateurs pour les milliers.
	
Par exemple, quand on a un nombre qui est très très grand, c'est difficile à lire : 10000000000000000000000. C'est plus compliqué à lire car on sait pas exactement combien on a de zéros.
	
Il est possible, tel qu'on verra dans le prochaine vidéo quand on manipulera des variables, de mettre un séparateur dans la notation des nombres. Tous les 3 chiffres, tout simplement, à partir des milliers, on peut mettre un petit underscore _. 
    
Et là on arrive à lire très vite le nombre :

	10_000_000_000_000_000_000_000

C'est beaucoup plus facile à lire que si on avait aucun séparateur. Par exemple, 18666 devient 18_666 et 14 reste 14.
	
Voilà pour ce qui est une notation très pratique.
	
Ici il était préférable de séparé cette partie de celle sur les variables. Nous voyons ainsi cette vidéo sur les types de données et la prochaine vidéo sur les variables et les constantes.
	
Nous avons également différentes bases mais cela on s'en doute.
	
On a :
	
1. Les bases numérique. C'est à dire qu'au niveau des nombres nous avons des bases dont une que l'on connait bien c'est la base décimale. On a :
    + `décimale (10 -> 0 à 9)` La base décimale, c'est la base 10, ce sont les nombres qui vont de 0 à 9. C'est ce qu'on utilise en mathématique lorsque l'on compte.	
	+ `binaire (2 -> 0 à 1)` La base binaire, c'est le langage de la machine. Un ordinateur ne comprend que cette base. C'est une base dites en base 2. Et la base 2, c'est 0 et 1. Il n'y a que c'est 2 chiffres possible.
	+ `octale (8 -> 0 à 8)` La base octale, c'est la base 8 et la base 8 c'est de 0 à 7.
	+ `hexadécimale (16 -> 0 à F)` Enfin la base hexadécimale, qui est une base 16 qui elle va de 0 à F.
			
Voilà pour l'ilustration de chacune des bases numériques, en tout cas standard. On peut avoir une base 3, un base 20, une base 46, on pourrait trouver et inventer une base pour n'importe quoi.
	
Il existe même d'ailleurs d'autres bases plus spécifiques dans certains autres domaines d'application en math, en art, etc.
	
Ici ce sont les bases standards.
	
Et ces bases, les langages de programmation et Java en l'occurence a prévu des notations spéciales pour ces types là.
	
Quand on manipule la base décimale, celle qu'on utilise tous les jours sans s'en rendre compte, on écrira des choses comme 10_000_000_000_000_000_000_000 sans problème. On note rien de particulier, on note le nombre et c'est terminé.
	
On est même pas obligé d'utiliser de séparateur, on note 18666 tout les chiffres collées côtes à côtes.
	+ `binaire -> 0b` 
    Mais si à un moment, on a besoin de noter une valeur en binaire, il faudra la faire précéder du préfixe 0b. Ce préfixes en informatique va tout simplement indiqué que tout ce qui va après est une valeur binaire.
	
Et la du coup on peut noter une valeur binaire tel que :
		
    binaire -> 0b11001111, ce genre de chose.
		    
Tandis que si on note juste ça : 11001111, pour Java ce sera juste un entier. C'est à dire qu'il va le séparer comme ceci :

    11_001_111 soit à Onze millions mille cent onze.
		
Ainsi 0b11001111 et 11_001_111 ne sont pas du tout la même chose. 
		
Donc si on veux manipuler un nombre binaire, on ajoutera le préfixe 0b devant.
		
On les manipulera dans la vidéo prochaine.
		
	+ `0755`

Pour un octale, au lieu de 0b, on va tout simplement mettre un zéro et par exemple 3 chiffres qui désigneront une valeur octale : 0755 si par exemple on met un système de permission sur un fichier sur le système GNU Linux, on noterais donc les choses de cette manière (0755). Si je met juste 755, ça devient un décimale au lieu de 0755 en octale. Donc on met ce petit préfixe 0 au départ et automatiquement, Java le reconnaître comme étant un nombre en base octale. 
	
	+ `0xAF55`

Si On veut travailler en hexadécimale, on a juste a mettre 0x.

0x et ensuite tout en majuscule. On note même les lettres de la base hexadécimale en majuscule par convention.
		
Toute ces valeurs, toutes ces mutations sont utilisable avec tout les types de données. 
	
Si un jour, on veut stocker une valeur hexadécimale dans un int ou autre en fonction, on pourra gérer ça sans problème. Bien sûr, il y a des types particulier comme le char ou boolean qui manipule d'autres choses et le string dont on parlera plutard lorsqu'on verra les chaînes de caractères est un type particulier aussi.
	
Voilà les choses qui semblaient importantes pour tout ce que nous allons voir. Ainsi on se posera beaucoup moins de questions quand on utilisera tous ces types de données, ces notations numériques, au niveau de nos programme et peut être qu'on en aura besoin dans certains projets professionnels ou personnels ou à l'école si on étudie le Java à l'université.
	
Voilà nous aurons vu les types.
	
On est pas obligé de tout connaître par coeur, on arrivera très vite à les retenir puisque dans les autres langages de programmations comme le C ou le C++, on retrouve grosso modo presque tous les mêmes types à part le byte qui est un char en C, C++ ce qui est un peu différent. Sinon pratiquement tous les types existent suivant les langages. Le boolean dépend des langages sinon le int est tout à fait répendu partout. Le short, le long, etc. 
	
Ca se sont les types de données à connaître en Java. On a le type objet associé à connaître mais on reviendra dessus, ainsi que la place que ça occupe en mémoire, ainsi que les valeurs minimales à maximales que l'on peut stocker dans ce type.
	
Si l'on veut par exemple stocker le nombre 2 millions, il ne faut pas utiliser un type short car au niveau de la fourchette de valeurs. Il ne passe pas. Il est en dehors de la fourchette de valeurs. Nous devrons plutôt le type int qui est le plus petit à utiliser, celui qui prend le moins d'espace en mémoire pour stocker le nombre 2 millions et quelques.
	
Penser toujours à cela. Ce n'est bien évidement pas à connaître par coeur les fourchettes de valeurs. Après ces fourchettes ne changent d'un langage à l'autre parce que les types par rapport à l'adressage en mémoire, puisque la mémoire vive est adressée de la même manière, en général, les langages de programmation utilise la même	fourchette de valeurs. Ce qui est parfaitement logique parce que un octet restera toujours un octet quelque soit l'ordinateur. 
	
Donc les espaces d'adressage sont gérés de la même manière.
	
Inutile de l'apprendre par coeur, juste de se faire à l'idée des valeurs approximatives. Et on serra très rapidement et très facilement utiliser les bons types de données.
	
## Type de données vues
	
Ca s'était la première chose, voir les types de données en Java. Ensuite, il faut savoir qu'il existe 4 types de bases standards :
```txt
		bases numériques : 	décimales 		(10 -> 	0 à 9)
							binaire 		(2 	-> 	0 à 1)
							octale			(8 	->	0 à 7)
							hexadécimale	(16	->	0 à F)
```
Dans la mesure où les apprend et qu'on ne les a jamais aprris avant.
	
Sur la formation hacking, il y a des séances au sujet des diffèrentes bases et faire des conversions l'unes à l'autres. On parle justement des différentes bases numériques.
	
Après on a les notations avec les petit séparateurs pour les milliers (100_000_000_000) :
```txt
		Nombre entier :	14
						18666
						100_000_000_000
```
Enfin les fameuses notations en fonction de la base que l'on veut manipuler : décimale, octale et binaire.
```txt
		binaire ->	0b11001111
					0755
					0xAF55
```
Il n'y a pas grand chose à voir de plus pour les notations possibles.

## Les caractères spéciaux
	
Maintenant comme on avait parlé de caractères Unicodes, on va voir qu'il y a des caractères spéciaux à manipuler dans les langages de programmation.
	
Le gros avantage si on les voit en Java et que c'est le premier langage que l'on apprend en programmation, ces caractères spéciaux sont les mêmes pour le C, le C++, le C# et pour tout un tas d'autres langages, on trouve les mêmes caractères spéciaux parce que tous les langages se sont mis d'accord pour les utiliser.
	
Ces caractères spéciaux, on va les noter pour terminer cette séance sont très simple, on a :
```txt
		\n : nouvelle ligne. C'est un retour à la ligne.
		\t : tabulation
		\r : retour chariot
		\b : retour arrière (back-space)
```	

A voir en test la différence entre \r et \b. Il faudra exécuter notre programme pour le voir.

Et on a d'autres spécifiques :
```txt
		\f : nouvelle page (pour simuler l'éffacement de la console)
```
Si par exemple, on note ce caractère " ' "et qu'on ne veut pas qu'il soit prit en compte dans la chaîne comme on avait vu la dernière fois avec la simple quote. On peut la protéger avec un anti-slash :
```txt
		\'
```
On peut faire la même chose pour l'antislash et la double quottes.
```txt
		\"
```
Il d'autres cas spécifiques si par exemple on veut noter un nombre octale :
```txt
		\077
```
Voilà, on peut le noter de cette manière. C'est une manière de le faire si on veut noter cette notation.
	
Si on veut noter un nombre hexédécimale, on peut très le noter ainsi :
```txt
		\xAF
```
Et également noter en UTF-16 mais là on sort du cadre de la vidéo et même du cadre du langage Java.
	
On en aura à priori pas besoin. Si un jour c'est le cas, on ira voir dans la documentation Java en fonction si on a nécessité d'utiliser ces caractères spéciaux.
	
Voilà il faut savoir que ces caractères spéciaux existent et qu'ils sont très utiles au niveau de l'affichage.
		
```java
public class MainApp
{
	public static void main(String[] args)
	{
		System.out.println("\tBonjour tout le monde ! :)\n");
	}
}
```

On avait vu que println, cette méthode de l'objet out, qui est dans la classe System.
	
Si jamais, on ne comprend pas, on va l'expliquer prochainnement.
	
On pourra donc utiliser des caractères spéciaux.
	
C'est caractères spéciaux doivent être mis dans le texte, c'est-à-dire à l'intérieur des doubles quottes.
	
Il ne faut pas par exemple mettre un anti-slash n après :
```txt
		FAUX : "Bonjour tout le monde ! :)" \n
```
On le met à l'intérieur.

Si j'exécute le programme tel qu'il est là, on fait :
```powershell
		javac MainApp.java
```	
Ce qui va créer une pseudo compilé. On aura pré-compilé le programme en byte code, le fichier source.
	
A partir de là, tout ce qui a été pré-compilé dans un fichier .class, nous allons pouvoir le faire exécuter par la machine virtuelle avec la simple commande java :
```powershell
		java MainApp
```
La machine virtuelle démarre et exécute le programme.

Dans notre cas, il y a eu un retour à la ligne grâce à la méthode println.
	
Si on veux ajouter un retour à la ligne, on peut très bien faire \n en plus :
```java
		System.out.println("Bonjour tout le monde ! :)");
		
		System.out.println("Bonjour tout le monde ! :)\n");
```
On pré-compile :
```powershell
		javac MainApp.java
```
Et on exécute :
```powershell
		java MainApp
```
On voit qu'un nouveau retour à la ligne a été mis. 
	
Si on veut une tabulation, on fait pareil :
```powershell
		System.out.println("\tBonjour tout le monde ! :)\n");
```	
On met un antislah t à l'endroit où veux le faire.

Dans notre cas, la tabulation se ferra avant la phrase.
	
Il est recommandé d'essayer tout les caractères spéciaux et ainsi voir comment ils se comportent et présenter nos affichages en consoles avec ces dernières.
	
L'important est de bien maitriser ces types de données car on va les manipuler avec des variables prochainnement.
	
On va pouvoir stocker des données car si on a rien pour stocker des données, on ne pourra pas faire grand chose au niveau de notre programme. C'est une notion très importante en programmation si le Java est le premier cours que l'on suit en informatique.
	
Et on apprendra à manipuler tout ça avec nos différent types de données, les différentes notations que nous avons vues et on verra comment afficher et travailler avec ces variables.