/*
Java #12 - tableaux

Bonjour à tous et bienvenue sur cette séance 12 en Java.

On avait fait une bonne parenthèse sur le début, en tout cas des notions, à voir en programmation objet puisque Java est un langage qui permet de programmer justement un objet où toutes les données que nous manipulons sont des objets et du coup, je voulais aborder très tôt sur la formation ces premières notions d'accord : Qu'est-ce qu'une classe ? Comment on pouvait créer justement des objets ? manipuler des méthodes ? Comment fonctionnaient des attributs et notamment l'encapsulation des données qui était à un point très très important.

Donc tout ça étaient nécessaire, en tout cas au départ, même si on n'a pas encore tout vu. 

On reviendra sur la programmation objet pur par la suite mais là on va passer, faire une autre une autre parenthèse en tout cas sur des éléments très très important que maintenant vous allez pouvoir comprendre puisque vous avez vu tout ça.

Et là nous allons parler des tableaux.

Alors les tableaux c'est un cas donc très particulier puisque vous allez voir que c'est une autre manière en fait de manipuler des données et on a du coup certains outils qui vont pas mal nous servir et je vais vous illustrer ça pour que vous puissiez bien comprendre le fonctionnement d'un tableau.

Alors évidemment, si vous venez d'un autre langage de programmation du C, du javascript, tout ça... Vous savez déjà grossièrement, en tout cas et j'espère, comment fonctionne un tableau. Qu'est-ce que c'est ? Comment c'est représenté en mémoire ? tout ça.

Mais comme je part évidemment du principe que vous n'avez jamais programmé encore, que Java est votre premier langage.

On expliquera un petit peu tout ça parce que ça me semble nécessaire de comprendre comment que ça fonctionne en mémoire pour pouvoir piger la suite.

Alors déjà Java, il y a un point qui est essentiel à comprendre, c'est que c'est un langage et je l'avais déjà dit qui n'est pas par exemple aussi bas niveau que le langage C c'est-à-dire que nous n'avons pas besoin, il n'y a pas une rigueur en fait qui est demandé, dans la gestion en fait de la mémoire.

Quand vous manipulez données, vous dites simplement : "je crée une donnée de tel type et je veux travailler avec, terminé".

C'est la machine virtuelle de Java qui va s'occuper de communiquer avec votre système d'exploitation pour faire le nécessaire que ce soit de l'allocation de mémoire c'est-à-dire pour pouvoir réserver des places en mémoire sur le système et ensuite s'occuper de leur libération pour éviter le gaspillage de ressources ou pire encore les fuites de mémoire. Donc tout ce genre de choses.

Là où dans d'autres langages, on aurait besoin de dire : "bah j'ai besoin de réserver tel place en mémoire et là j'ai besoin de libérer, de le faire manuellement".

Donc en Java, on n'a pas besoin de s'occuper de ça mais pour les tableaux comme je sais que c'est souvent source d'erreur quand on est débutant et qu'on apprend les tableaux.

Je vois beaucoup beaucoup de gens qui se trompent dans la manipulation des tableaux parce qu'en réalité ils n'ont pas compris ce que c'était et comment ça fonctionnait.

Même si Java est un langage plus haut niveau que le C, à mon sens il me paraît important de savoir comment ça fonctionne, comment s'est représenter en mémoire même si là on est quand même sur de la représentation bas niveau pour savoir comment ça se manipule et du coup éviter pas mal d'erreurs.

Alors on va déjà revenir sur un point très important jusqu'à présent qui est déjà le fonctionnement en mémoire d'une variable d'accord. 

Même si j'avais expliqué certaines choses on va revenir là dessus.

En gros quand je fais ceci.

public class App
{
	public static void main(String[] args)
	{
		int data = 14;
	}
}

Vous voyez au niveau de Java, pas de souci, vous créez ici donc une variable de type int, on lui en fait la valeur 14 et on peut ensuite la manipuler, pas de problème, aucun problème au niveau de Java.

Qu'est-ce qui se passe en mémoire réellement ? donc j'ai repris en tout cas un schéma que j'avais fait sur la vidéo hacking numéro 6 où évidemment j'explique beaucoup plus en détail tout ce qui est aspect système, matériel et cetera. Et là notamment une vidéo sur le fonctionnement, un peu plus détaillée de la mémoire.

Donc voilà un schéma simplifié qui peut représenter du coup la mémoire avec son système d'adressage.

HACKING #6 - FONCTIONNEMENT DE LA MEMOIRE
-----------------------------------------
Représentation de la mémoire d'un programme (schéma ULTRA SIMPLIFIE):

					0x000000
				+---------------+	ADRESSES BASES
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
	Mémoire		+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+	ADRESSES HAUTES
					0xFFFFFF


En gros, vous pouvez ou imaginer que cette mémoire donc chacune des cases en fait qu'il y en mémoire possède une adresse d'accord.

Imaginez un petit peu comme des maisons d'accord où chaque maison aurait sa propre adresse postale d'accord, avec son numéro de rue ou ce genre de choses mais peu importe, chacune sa propre adresse pour pouvoir du coup délivrer le courrier en fait à chacune des maisons.

Donc en gros, on a cette représentation en mémoire d'accord et quand on a créé ici notre petite variable de type int, Java, c'est pas alors Java qui va dire : "Ben je vais stocker ça à tel endroit en mémoire d'accord", il va demander l'autorisation au système d'exploitation puisque c'est lui en fait le chef d'orchestre et qui décide oui ou non s'il a déjà un emplacement mémoire et si oui où est-ce qu'il le stock pour allouer la mémoire.

Donc en gros, on lui dit : "Oh là j'ai un entier que j'aurais besoin, en fait, d'avoir en mémoire pour stocker cette valeur de 14". Il va interroger le système d'exploitation donc moi ici en l'occurence, ici c'est Windows mais c'est pareil pour Linux, pour MacOS, peu importe, c'est exactement la même chose et le système en fonction va chercher un emplacement mémoire correspondant.

Donc il sait la taille que fait un integer donc un int en mémoire d'accord, un nombre d'octets et cetera et s'il trouve une place de libre, il va dire : "bah voilà à tel endroit je vais stocker du coup ...". Il va rien dire mais il va stocker en mémoire à tel endroit donc par exemple ici.

					0x000000
				+---------------+	ADRESSES BASES
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|	X  14		|
	Mémoire		+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+	ADRESSES HAUTES
					0xFFFFFF

Je mets ta variable d'accord dans un emplacement mémoire et puis du coup, on va stocker tout simplement la valeur, voilà.

Donc cette donnée aura une adresse puis ça nous importe peu puisque encore une fois, on n'a pas besoin de manipuler les adresses mais il faut comprendre qu'il y a une adresse qui est représentée en fait pour cette case bien précisé d'accord, pour cette maison si je reprends mon analogie avec les maisons et on va stocker la valeur 14, voilà, à partir de là.

Donc du coup, au niveau du langage en lui-même, la syntaxe, vous manipuler des variables c'est-à-dire qui possède des noms mais en réalité pour Java mais même pour le langage, lui enfaite "data", c'est simplement une étiquette, en fait, où derrière se cache une adresse.

Donc par exemple peut-être que derrière "data", en fait il y a une adresse, je sais pas moi, sous cette forme "0x154200", je mets n'importe quoi d'accord qui du coup est l'emplacement mémoire en fait de cette valeur 14 donc lui, il va pouvoir du coup en ayant cette adresse dans son annuaire, va en fait pouvoir retrouver éventuellement la donnée qu'on pourra manipuler. Voilà en gros.

public class App
{
	public static void main(String[] args)
	{
		int data = 14; //0x154200
	}
}

Mais nous, comme c'est évidement très compliqué, voilà on va dire assez assez confus de manipuler des adresses comme ça, d'accord.

Imaginer tout un tas d'adresses différentes avec juste des chiffres, on finirait par se mélanger en plus, au niveau lisibilité humainement parlant, pour nous, ça ne représente pas grand chose.

On utilise du coup des étiquettes et c'est le principe de variables que j'avais déjà expliqué.

Du coup quand on sort du contexte donc ici par exemple de la méthode (main), cette donnée est libérée de la mémoire, pareil c'est pas à nous de dire : " bah là maintenant, il faut libérer de la mémoire". Cs'est la machine virtuelle qui voit avec le système d'exploitation pour que ce soit fait et du coup la libération se fait la donnée est supprimées de la mémoire et cet espace devient à nouveau libre pour servir à d'autres choses puisqu'il faut comprendre aussi bien évidemment que votre mémoire, elle est utilisée par plein de choses, elle n'est pas utilisée que pour votre programme Java. Elle est également utilisée pour votre système qui tourne, pour l'interface du système, votre explorateur de fichiers, les pilotes qui gèrent également votre souris et cetera et cetera.

					0x000000
				+---------------+	ADRESSES BASES
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
	Mémoire		+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+	ADRESSES HAUTES
					0xFFFFFF
Donc tout est géré là dedans donc c'est au système c'est parfaitement logique en fait.

C'est le système d'exploitation qui décide où il stocke les données en mémoire. 

Ca je l'indique bien et je prends du temps pour l'expliquer parce que je vois beaucoup de gens qui pensent que c'est le langage de programmation en fait qui décide lui-même, qui dit bah tiens je stoque ça à tel endroit, tel endroit, pas du tout.

Et pareil, j'ai déjà eu des questions où on me disais est-ce qu'on peut choisir l'endroit ? En gros, est-ce qu'on peut dire : "je veux stocker tel donnée a tel adresse" ? bien évidemment que non. 

D'accord, c'est le système qui voit l'espace libre en fonction du type de donnée à stocker et qui gère lui-même et après il retourne ça au langage de programmation et sous la forme de nos variables on peut facilement du coup accéder à ces éléments.

Pareil si on parle des pointeurs qu'on retrouve dans d'autres langages de programmation donc voilà comment ça fonctionne en tout cas au niveau des variable et cette explication va permettre d'introduire du coup le fonctionnement des tableaux. 

Il va falloir comprendre parce qu'on pourrait s'imaginer du coup alors quand par exemple je fait une autre variable comme ça.

public class App
{
	public static void main(String[] args)
	{
		int data = 14;
		int data2 = 8;
	}
}

On va passer au tableau parce que je ne veux pas aller trop vite non plus.

Pareil, on va demander au système d'allouer un nouvelle espace ici, je vais remettre ce que j'avais voilà (14) et donc pour stocker le 8, il va chercher un autre emplacement en mémoire. Il va dire : "bah tiens par exemple cette case là hop, j'ai une place" et il va stocker du coup la valeur de 8 à cette adresse d'accord.

					0x000000
				+---------------+	ADRESSES BASES
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|	X  14		|
	Mémoire		+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|	X  8		|
				+---------------+
				|				|
				+---------------+	ADRESSES HAUTES
					0xFFFFFF

Vous voyez que c'est des adresses en fait qui sont prises alors aléatoirement pas vraiment puisque le système a choisi des emplacements libres mais en fait bah c'est un peu près partout où il peut trouver de la place donc il aurait pu très bien être juste à côté comme il peut être très très loin dans une adresse beaucoup plus haute, une adresse beaucoup plus basse, peu importe c'est le système de toute façon qui décide et limite on n'a même pas besoin de se soucier de où elles sont.

Donc ça c'est un cas, en tout cas, quand on manipule des variables.

Là où le tableau va changer la donne mais c'est très important donc on va voir déjà au niveau syntaxe comment on va déclarer un tableau.

On va dire par exemple donc je fais un "int", je vais faire "tab", je vais mettre des crochets "[]" d'accord et ici, je vais indiquer que je veux donc un tableau de 3 cases d'accord.

public class App
{
	public static void main(String[] args)
	{
		int tab[] = new int[3];
	}
}

Donc je veux un tableau qui permettra de stocker 3 données de type int, donc voilà là syntaxe nous avons.

int, on indique le nom de la variable, des crochets et ensuite à l'affectation, on met un new, le type qu'on veut donc il faut que ce soit évidemment ici le même (int et int) et entre crochets, le nombre de données qu'on voudra de ce type-là d'accord.

Alors le crochet, on peut également le mettre ici d'accord, juste après le type donc en fait avant le nom.

public class App
{
	public static void main(String[] args)
	{
		int[] tab = new int[3];
	}
}

La seule différence c'est que si vous faites ça "int[]" de cette manière là, vous pouvez du coup créer plein de tableaux comme ça sur la même ligne voilà.

public class App
{
	public static void main(String[] args)
	{
		int[] tab = new int[3];
		
		//int[] tab, tab2;
	}
}

tab et tab2, ce sont des tableaux parce que j'ai placé les crochets là "int[]".

Par contre si je place les crochets à côté du nom et que je fais du coup ça.

public class App
{
	public static void main(String[] args)
	{
		int[] tab = new int[3];
		
		//int[] tab, tab2;
		//int tab[], tab2;
	}
}

Et bien on comprend très bien que là le tableau, c'est juste tab, ça c'est simplement une variable de type int mais ça permet du coup, vous voyez quand on a des choses de même type, de les faire sur une seule ligne, tableau ou pas tableau, d'accord ça fonctionne très bien.

Donc à voir en fonction, d'accords, de ce que vous voulez faire mais ici avec les crochets là "int[] tab, tab2;", tous seront des tableaux et avec cette syntaxe là "int tab[], tab2;" c'est seulement celui où les crochets sont à côté du nom.

		//int[] tab, tab2;
		//int tab[], tab2;

Donc attention un petit peu aux différentes syntaxes là et de ne pas vous tromper, voilà pour ça.

Donc là, on déclare, on dit simplement : "j'ai besoin, je déclare un tableau de 3 int, d'accord mais pour lesquels, on n'a pas mis de données dedans donc pareil, ça va interroger le système et là ou un tableau est un cas spécifique d'accord au niveau stockage mémoire et c'est pour ça que je vous l'explique ici avec une illustration. C'est que le système ne va pas dire : "bon bah je vais te réserver une case là puis je réserver une case là et une case là". 

Non, il va chercher obligatoirement l'emplacement nécessaire pour pouvoir stocker 3 entiers à la suite des autres donc on dit en fait de manière contigue voilà.

Les données sont stockées de manière contigue en mémoire voilà donc ça, c'est en fait notre tab de 3 éléments. 

					0x000000
				+---------------+	ADRESSES BASES
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|	X			|     |
				+---------------+     |
				|	X			|     | tab[3]
	Mémoire		+---------------+     |
				|	X			|     |
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|	X  8		|
				+---------------+
				|				|
				+---------------+	ADRESSES HAUTES
					0xFFFFFF

Voilà et pour le moment, ils contiennent soit rien, ils peuvent convenir 0, ils peuvent contenir n'importe quelle valeur. Peu importe, on a des valeurs non définies puisqu'on n'a rien initialiser, on a juste dit : "tu réserve cet emplacement en mémoire, voilà".

Alors on peut changer ceci, c'est-à-dire qu'on n'est pas obligé de juste déclaré le tableau et terminé. 

		int[] tab = new int[3];

On peut également initialiser déjà des valeurs. En gros, on ne met pas ici de nombre et on indique entre des accolades les valeurs par exemple que l'on veut.

public class App
{
	public static void main(String[] args)
	{
		int[] tab = new int[]{1, 2, 3};
	}
}

Et ça, au niveau de la syntaxe, le langage comprendra qu'on veut effectivement 3 entiers et où chacun ont pour valeur 1, 2 et 3.

					0x000000
				+---------------+	ADRESSES BASES
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|	X	1		|     |
				+---------------+     |
				|	X	2		|     | tab[3]
	Mémoire		+---------------+     |
				|	X	3		|     |
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|	X  8		|
				+---------------+
				|				|
				+---------------+	ADRESSES HAUTES
					0xFFFFFF

Ils seront du coup stockées dans l'ordre d'accord, ils ne seront pas mélangés, ils seront vraiment stocker dans l'ordre où vous les avez déclaré puisque les données, je rappelle, sont stockées de manière contiguë et c'est ça qui est important, en fait, dans un tableau et c'est pour ça que je voulais vous l'illustré et que je voulais vous donner toutes les explications ....on va dire un peu supplémentaire au niveau de la mémoire, c'est très important, voilà.

Donc en gros les données sont stockées comme ça. On aura pas du coup, le 1 stocké là et puis le 2 stocké là et puis le 3 stocké, je ne sais pas où. 

C'est les unes à la suite des autres, c'est vraiment un espace qui se suit en mémoire donc très important donc si ici, c'était l'adresse 100 (X 1) et ben là, on aurait l'adresse 101 (X 2) et là l'adresse 102 (X 3) d'accord.

C'est des maisons en fait qui aurait des adresses qui se suivent directement donc on a toutes nos 3 données qui sont là et ça, si vous avez bien pigé tout ce que j'ai dit jusqu'à présent et bien ça vous évitez bon nombre d'erreurs dans la manipulation des tableaux parce que maintenant vous savez comment un tableau est représenté en mémoire donc le reste, vous n'avez pas besoin de vous en soucier pour langage Java puisque c'est lui qui va s'occuper de tout ce qui est libération, tout ça.

Donc c'était la seule chose à savoir en termes de représentation mémoire concernant le langage Java pour les tableaux mais par contre pour ensuite la manipulation, ça va énormément vous aider.

Alors pareil au niveau de sa syntaxe quand on a initialisé des valeurs, on peut même se passer d'écrire ceci "new int[]". Alors on peut mettre directement cela là.

public class App
{
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3};
	}
}

En gros, le "new int", on le met soit quand on veut bah simplement déclaré le tableau avec un certain nombre de cases sans mettre des valeurs précises, d'accord.

Ou alors, on le met pour dire par exemple voilà qu'on met les valeurs mais on l'indique directement donc en gros on fait ça comme je vous expliqué tout à l'heure et on met rien entre les crochets.

public class App
{
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3};
	}
}

L'un ou l'autre donc c'est vous qui voyez. Il y a plusieurs syntaxes et ça, c'est aussi un petit inconvénient des fois pour pour beaucoup en Java, parce que c'est un langage très verbeux c'est-à-dire qu'il est très, en fait, explicite dans certains syntaxe, dans les mots clés, dans tout ça où il y a beaucoup beaucoup d'informations ne serait-ce que dans le code et du coup bah il y a plusieurs manières en fait de voilà déclarer les données, tout ça donc peu importe. Vous pouvez voir, il n'y a pas de problème.

Donc si je résume, on va quand même résumé rapidement.

/
	int tab[] / int[] tab
/

on peut faire un "int tab[]" d'accord, ou on peut faire un "int[] tab" mais là du coup ça change quand on a plusieurs données donc attention. 

Ca c'est deux syntaxes qui ne sont pas vraiment les mêmes en réalité, elles n'ont pas le même comportement si vous avez plusieurs qui se suivent sur la même ligne donc faut faire gaffe.

Du coup bah ça, on peut le faire comme ça. Bon je ne met pas les points-virgule.

/
	int tab[] / int[] tab
	int tab[] = {1, 2, 3}
/

On peut avoir également comme ça "new int[3]".

/
	int tab[] / int[] tab
	int tab[] = {1, 2, 3}
	int tab[] = new int[3]
/

Comme ça mais du coup, aucune valeur initialisée. D'accord, c'est juste une déclaration, et on peut bien sûr avoir ce qu'on avait tout à l'heure ceci "new int[]{1, 2, 3}".

/
	int tab[] / int[] tab
	int tab[] = {1, 2, 3}
	int tab[] = new int[3]
	int tab[] = new int[]{1, 2, 3}
/

Vous voyé plein de manières en fait de gérer un petit peu cette déclaration et éventuellement l'initialisation du tableau.

"int tab[] = new int[3]" donc ça, ça déclare simplement.

Si je mets bien sûr que je vais pas montrer. Si bien sûr je fais juste cette chose là "int tab[]" puis je mets pas point-virgule directement c'est aussi une simple déclaration bien évidemment. Donc il n'y a aucune initialisation.

Et là "int tab[] = {1, 2, 3}", c'est initialisé avec des valeurs et là pareil "int tab[] = new int[]{1, 2, 3}". Voilà donc ça c'est des syntaxes équivalentes.

Voilà un petit peu pour ça donc je vous laisse mettre en pause si vous voulez récupérer toutes les informations que j'ai mis en commentaire là, comme vous voulez.

Et maintenant pour la suite donc des choses, maintenant qu'on a compris comment ça fonctionne en mémoire un petit peu ce tableau, on va pouvoir travailler avec.

En gros pour afficher donc par exemple le premier élément du tableau, alors déjà on pourrait être tenté, je pensais que si on connaît rien des tableaux, qu'on le découvre, on pourrait se dire : "Une variable, comment l'afficher ? bon mettez son nom.
*/
//public class App
//{
//	public static void main(String[] args)
//	{
//		int[] tab = {1, 2, 3};
//		
//		System.out.println(tab);
//	}
//}
/*
Donc on pourrait se dire : "tiens je vais juste faire ça, je vais faire un println de tab, après tout ça paraîtrait logique.

on fait ça. hop on voit que la commande a l'air de marcher et on fait ceci et on a quelque chose de bizarre.

	>javac App.java
	>java App
	[I@7a81197d

En réalité ça nous a retourné une adresse, d'accord. 

Nous, on ne veut pas ceci c'est-à-dire on a l'adresse du tableau donc c'est bien, on a une information qui nous intéresse pas.

Nous on va accéder aux éléments donc ce tableau, vous avez remarqué qu'il y a une syntaxe particulière pour la connaître, ce sont des crochets et bien on va pouvoir accéder à ces différents éléments sauf qu'en informatique, il y a souvent ce cas là ou le premier élément de quelque chose commencera à l'indice d'accord, à l'index 0.

Donc si on veut accéder aux 1 {1} ici qui est le premier élément de notre tableau, il faudra accéder à table de 0 et pour ça vous voyez, on utilise des crochets et on met l'indice à l'intérieur donc tab[0], c'est le premier élément, tab[1], ce sera le deuxième, tab[2], ce sera le 3e d'accord et cetera.

Pour accéder au énième élément en fait il faut mettre l'indice n-1, tout simplement pour pas se tromper.

*/
//public class App
//{
//	public static void main(String[] args)
//	{
//		int[] tab = {1, 2, 3};
//		
//		System.out.println(tab[0]);
//	}
//}
/*
Et du coup voilà effectivement si je fais ça, on accède bien à l'élément, pas de problème.

	>javac App.java
	>java App
	1

Alors maintenant si on veut afficher par exemple tous les éléments du tableau. En gros, on appelle ça un parcours.

On veut parcourir le tableau pour afficher tous les éléments.

L'avantage déjà c'est qu'on sait que grâce à cette représentation en mémoire, le fait que le tableau ...tous les espaces enfin toutes les valeurs soient mises les unes à la suite des autres, comme je vous ai dit du coup les indices se suivent.

					0x000000
				+---------------+	ADRESSES BASES
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|	X	1		|     |
				+---------------+     |
				|	X	2		|     | tab[3]
	Mémoire		+---------------+     |
				|	X	3		|     |
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|				|
				+---------------+
				|	X  8		|
				+---------------+
				|				|
				+---------------+	ADRESSES HAUTES
					0xFFFFFF

Donc très simplement, on sait automatiquement qu'à tab[1], on aura forcément l'élément qui suit juste derrière.

On est sûr de ne pas retomber par exemple à une autre zone en mémoire qui net serait pas autorisée.

*/
//public class App
//{
//	public static void main(String[] args)
//	{
//		int[] tab = {1, 2, 3};
//		
//		System.out.println(tab[0]);
//		System.out.println(tab[1]);
//		System.out.println(tab[2]);
//	}
//}
/*
	>javac App.java
	>java App
	1
	2
	3

Et dans ce cas-là, sans surprise, on arrive bien évidemment à afficher tous les éléments, d'accord.

Et si par contre je m'amuse à afficher un index qui est en dehors du tableau comme ici, voilà.
*/
//public class App
//{
//	public static void main(String[] args)
//	{
//		int[] tab = {1, 2, 3};
//		
//		System.out.println(tab[0]);
//		System.out.println(tab[1]);
//		System.out.println(tab[2]);
//		System.out.println(tab[3]);
//	}
//}
/*
	>javac App.java
	>java App
	1
	2
	3
	Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
			at App.main(App.java:562)

Alors on aura ceci "ArrayIndexOutOfBoundsException" donc on aura une exception. On n'a pas encore vu ce que c'était en Java, on n'a pas abordé les exceptions encore mais en gros c'est une erreur qui vous indique que l'index est en fait étant dehors de l'emplacement réel en fait de notre tableau.

Donc en fait là on essaie d'accéder à une zone mémoire qui n'appartient pas à notre tableau.

Si ça se trouve, c'est peut être une zone mémoire qui est utiliser là par le système, par l'éditeur de code, on ne sait pas donc évidemment on nous l'interdit donc automatiquement le programme plante est une exception est lever.

Mais on verra les exceptions plus tard donc attention à ce niveau là.

Alors déjà là si vous avez bien assimilé toutes les vidéos précédentes, il devrait y avoir une chose qui vous choque c'est-à-dire que on s'amuse à répéter du code pour parcourir un tableau.

Donc logiquement, vous avez dû vous dire, il y a certainement moyen de faire une boucle puisque c'est à ça que ça sert une boucle, ça permet de répéter des opérations ça permet de factoriser du code pour éviter sa répétition ou, et c'est là que cà a un intérêt, de parcourir justement certaines structures de données comme par exemple ici en l'occurrence les tableaux.

Et pour se faire, nous allons donc utiliser une boucle très simplement pour parcourir ce dernier.

Alors on va simplement faire une boucle for d'accord très simplement. On va créer une variable directement dans le for car elle servira que pour lui en la faisant partir de 0.

	for(int i = 0 ;

Pourquoi 0 parce que c'est ce qui va servir d'indice pour notre tableau, d'accord.

	for(int i = 0 ; i < tab.length

Le tableau commece à tab[0] et bien en utilisant i comme indice du tableau c'est-à-dire qu'il sera dynamique, on peut du coup travailler là dessus.

Ensuite on va dire tant que lui est plus petit, différent, vous voyez comme vous voulez que la taille du tableau c'est-à-dire le nombre d'éléments, je rappelle qu'on ne devra surtout pas dépasser l'index et bien ça, vous avez une petite instruction très simple, vous mettez votre tableau, un point et length "tab.length".

"tab.length", vous retourne tout simplement la taille que vous avez ici "{1, 2, 3}", d'accord.

Tant que c'est plus petit que 3, pas de problème par rapport à ça.

for(int i = 0 ; i < tab.length ; ++i)

Et du coup on incrémente notre compteur donc l'intervale qui sert de compteur, qui du coup va incrémenté l'indice que nous allons utiliser.

public class App
{
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3};
		
		for(int i = 0 ; i < tab.length ; ++i)
	}
}

Et pourquoi, on a utilisé ce petit i, tout simplement pour faire ça c'est-à-dire que pour éviter la répétition qu'on avait tout à l'heure, on met ici System.out.println(tab[i]).
*/
//public class App
//{
//	public static void main(String[] args)
//	{
//		int[] tab = {1, 2, 3};
//		
//		for(int i = 0 ; i < tab.length ; ++i)
//			System.out.println(tab[i]);
//	}
//}
/*
Au lieu de faire tab[0], tab[1], tab[2], et cetera et bien notre indice est dynamique et c'est la variable i, tout simplement. 

Voilà comment on parcours un tableau le plus simplement du monde avec une boucle for.

Du coup, si je m'amuse à faire ça.

	>javac App.java
	>java App
	1
	2
	3

On parcours tous les éléments. On ne dépasse pas du tableau d'accord puisque on s'assure grâce à ça "i < tab.length" de ne pas dépasser, pas de problème.

Et on affiche bien tous les éléments mais encore une fois en 2 ligne, voilà au lieu d'avoir des répétitions de code pas possible.

C'est beaucoup plus rapide et beaucoup plus optimisé. Voilà comment ça se passe. 

Donc ça c'est un autre élément à savoir length, d'accord. Cette petite instruction vous permet en fait de récupérer la taille d'un tableau donc très très pratique par rapport à ça. Il faut absolument le connaître.

=============

Voilà pour cette partie là, on a également maintenant parce que quand on parle de parcours, ça c'est encore une chose qu'on n'a pas forcément vu avant mais qui va pouvoir du coup maintenant s'ajouter donc aux autres boucles que vous avez vu, une boucle qui est vraiment prévu justement pour le parcours d'un tableau.

Par exemple, c'est-à-dire plutôt que de faire ce genre de boucle là qui ajoute pas mal d'éléments, on a quelque chose de plus simple.

Donc équivalent à cet exemple que vous avez ici...

		for(int i = 0 ; i < tab.length ; ++i)
			System.out.println(tab[i]);

... vous pouvez en gros faire ceci alors je vais le laisser comme ça, vous verez un petit peu la différence, vous verez que c'est exactement la même chose.

On utilise la boucle for, on déclara un élément donc par exemple moi je vais l'appelé "el", on va rester simple comme ça et en fait on va mettre ":" et on va indiquer le nom du tableau.

public class App
{
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3};
		
		for(int i = 0 ; i < tab.length ; ++i)
			System.out.println(tab[i]);
		
		for(int el : tab)
	}
}

Qu'est-ce que ça veut dire ? bah ça va simplement dire que pour chaque élément de tab que tu vas stocker temporairement donc successivement pour chaque itération de la boucle dans une variable que tu appelleras "el" qui doit bien sûr être du même type que le tableau sinon on aurait du petit problème pour la lecture des données.

Et dans ce cas-là, on fait ça.
*/
//public class App
//{
//	public static void main(String[] args)
//	{
//		int[] tab = {1, 2, 3};
//		
//		for(int i = 0 ; i < tab.length ; ++i)
//			System.out.println(tab[i]);
//		
//		for(int el : tab)
//			System.out.println(el);
//	}
//}
/*
On n'a plus de i, on n'a plus d'autre chose, on a simplement ça.

D'accord, ça va automatiquement parcourir.

En fait, à chaque fois qu'on va avoir une itération, on va récupérer chaque indice d'accord du tableau et au lieu de tab[0] au départ, on va le stocker dans la variable ici "el".

Donc on l'affiche effectivement, ensuite ça va itérer de 1 donc on va passer à tab[1], tab[1] va être stocké temporairement dans "el" et du coup on peut l'afficher et ainsi de suite et ainsi de suite.

Donc évidemment d'une manière un peu plus simple ici, un peu plus optimisé, on a un parcours du tableau qui se fait aussi.

	>javac App.java
	>java App
	1
	2
	3
	1
	2
	3

Donc c'est un peu l'équivalent de la boucle foreach qu'on retrouve par exemple en PHP, pour ceux qui ont déjà fait ou qui font du PHP. C'est exactement le même fonctionnement mais beaucoup plus optimisé donc si vous devez parcourir un tableau utiliser de préférence ce type de boucle là, qui est vraiment bien pratique. 

En plus on peut du coup utiliser un nom, d'accord, très pratique par exemple on peut mettre par exemple "number", voilà simplement.

public class App
{
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3};
		
		for(int i = 0 ; i < tab.length ; ++i)
			System.out.println(tab[i]);
		
		for(int number : tab)
			System.out.println(number);
	}
}

"number" qui voudrait dire du coup pour chaque nombre de type entier dans tab qu'est-ce que tu fais ? là tu affiches pour ce fameux nombre, d'accord, successives que tu récupère à chaque fois, à chaque itération en fait on récupère ce nombre.

Et voilà on a bien le parcours qui est fait.

Donc ça c'est très important, c'est des choses à connaître, des choses qu'on retrouvera dans avec d'autres systèmes en fait comme ça pour stocker notamment ce qu'on appelle des collections.

Vous verez qu'il y a des collections qu'on va retrouver en Java qui un peu comme les tableaux, va permettre de stocker plein de données qui se suivent ou autres et de faire beaucoup d'opérations dessus. Voilà pour ça.

========

Est-ce qu'on va continuer ... je vais rajouter un petit bonus pour cette vidéo parce qu'on a vu, en gros ce qu'il y avait en tout cas a voir au minimum pour les tableaux et l'essentiel, il y avait pas mal de chose là dessus. 

Et on va maintenant aborder un autre passage c'est-à-dire les tableaux à deux dimensions parce que je sais qu'il y a des gens qui vont certainement me le demander comme je sais que vous manipulez ça dans pas mal d'autres langages de programmation.

On va le voir aussi dans cette vidéo quand on va faire un tableau à 2 dimensions pour ce que l'on appelle plus communément une matrice ou qui peut représenter en fait un tableau qui a plusieurs lignes, plusieurs colonnes par exemple.

Imaginer on veut représenter un damier dans un jeu, on va représenter voilà n'importe quoi en fait qui ai deux dimensions, on va utiliser justement un tableau à deux dimensions pour faire ça.

Et le tableau à deux dimensions, c'est souvent pareil, quelque chose qui est des fois très mal compris par les gens qui apprennent et pourtant c'est très très simple. C'est exactement le même principe.

public class App
{
	public static void main(String[] args)
	{
		int[][] tab;
	}
}

Donc on va faire ça déjà, on va déclarer de cette manière donc on va le mettre à côté du type "[][]" donc on met double crochet d'accord parce que c'est un tableau à 2 dimensions, encore une fois. On va lui laisser le nom ici "tab" et on va lui mettre des valeurs. Pour le moment on va lui mettre des valeurs.

Voilà pour le moment on va lui mettre des valeurs pour montrer un peu comment c'est représenté au niveau Java.

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = {};
	}
}

Donc ça "{}", c'est les crochets qui représentent en fait, si vous voulez, une première partie et on va dire, en fait, pour chaque ligne... alors c'est un peu bizarre de dire des lignes, des colonnes d'un tableaux car pour la mémoire, il n'y a pas du tout cette histoire de ça. 

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = {};
	}
}

C'est en gros, il faut imaginer qu'un tableau à 2 dimensions en fait, c'est un tableau où chacun de ces éléments sont aussi des tableaux, voilà il faut vraiment le voir plutôt comme ça, d'accord, histoire de représenter les choses.

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = {{}, {}};
	}
}

Donc là, comme on a quelque chose de très simple, en gros, je vais faire {1, 2, 3} par exemple comme ceci et dans le 2e tableau, je vais faire ça {4, 5, 6}.

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = {{1, 2, 3}, {4, 5, 6}};
	}
}

Vous voyez que du coup pour tab[0], on a ce tableau là qui possède 3 éléments {1, 2, 3} et pour tab[1], on aura cet élément là {4, 5, 6} d'accord.

Donc ça c'est important, on a un tableau, du coup, de deux lignes enfin si on devait représenter un tableau de deux dimensions visuellement, on dirait qu'il y a 2 lignes, 3 colonnes. Première ligne {1, 2, 3}, 2e ligne {4, 5, 6}.

Et première colonne "1 et 4", 2e colonne "2 et 5" et cetera. Je pense que vous comprenez un petit peu la logique. 

D'ailleurs, on pourrait, si on veut, nous le représenter de cette manière si on veux que visuellement ce soit plus parlant.

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = 
		{
			{1, 2, 3}, 
			{4, 5, 6}
		};
	}
}

Et là on comprend tout de suite qu'on a une matrice pour ceux qui ont déjà fait des matrices, qui en on déjà manipuler, on arrive très vite à se le représenter de cette manière. Voilà en gros, ce que nous avons.

Alors ça, c'est pareil, on pourrait dire mais du coup comment ça fonctionne. Et bien en mémoire, voilà encore une fois, c'est exactement la même chose, c'est en gros, nous avons pour chaque élément de notre tableau, on va avoir d'autres tableaux, d'accord, c'est-à-dire qu'on aura un élément précis qui sera stocké, on aura un tableau et pour le 2e tableau on aura un autre, d'accord.

C'est vraiment en fait des tableaux contenus dans un, d'accord.

là (main), on avait tout simplement un simple tableau qui stockait des entiers et là on a un tableau, OK, où chacune de ces cases est également un tableau qui contient des éléments de type int, voilà.

C'est pour ça que c'est bien de mettre souvent les crochets plutôt à côté du type parce qu'on peut lire en fait de droite à gauche. 

int[][] tab

On dit tab est un tableau "[]" de tableau "[][]" de type "int" , voilà de données de type int.

Vous voyez en lisant de droite à gauche, on arrive bien à trouver cette logique donc n'hésitez pas à gardé cette syntaxe si des fois vous avez peur pas vous tromper et bah comme ça ...

		int[][] tab = 
		{
			{1, 2, 3}, 
			{4, 5, 6}
		};

...ça vous permet de lire de manière logique un petit peu comment sont organisées les données.

Alors maintenant qu'on a ça, comment on manipule ce type de tableau.

Alors pareil, je ne l'ai pas montrer parce que, je pense oui vous pourrez le trouver tout seul. 

Si je veux simplement déclaré ce genre de de matrice là sans l'initialiser, comment je fais ça ? mais évidemment, je peux faire ça de cette manière. 

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = 
		{
			{1, 2, 3}, 
			{4, 5, 6}
		};
	}
	
	//int[][] tab = new int[][]
}

je fais un "new int" et puis je fais "[2][3]" d'accord.

Première dimension, c'est le nombre de lignes entre guillemets donc c'est une ligne {1, 2, 3}, deux ligne {4, 5, 6} en gros et ça "[3]" c'est le nombre de colonnes donc là il y en a une :

			{1, 
			{4, 

il y a celle-là :

				 2, 
				 5, 

Et puis, il y a celle-là.
					3},
					6}

Donc 3, voilà comment se présenter ces informations là éventuellement.

Maintenant qu'on a vu ça d'accord, pour afficher déjà un élément, comment on affiche un élément ? Ben comme on a 2 dimensions, je pense que ça devrait être assez simple pour vous à deviner.

En gros, si je veux afficher alors cet élément, le 5 par exemple, comment on va l'afficher ? 

On est d'accord que notre tableau, cette partie là {1, 2, 3}, c'est tab[0], d'accord. C'est le premier élément en réalité même si c'est un autre tableau, c'est le premier élément. Ca c'est tab[1].

Donc moi je veux accéder au 5, d'accord donc déjà je sais que la ligne qui correspond à la première dimension, c'est l'indice 1 puisqu'on a dit que c'était tab[1][]. On a dit que la 2e dimension, la deuxième ligne, c'est l'indice n-1 et donc 2-1, ça fait bien 1, "tab[1][]".

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = 
		{
			{1, 2, 3}, 
			{4, 5, 6}
		};
		System.out.println(tab[1][]);
	}
}

Et 5, c'est le 2e élément donc du coup bah c'est l'indice 1 aussi d'accord "tab[1][1]".
*/
//public class App
//{
//	public static void main(String[] args)
//	{
//		int[][] tab = 
//		{
//			{1, 2, 3}, 
//			{4, 5, 6}
//		};
//		
//		System.out.println(tab[1][1]);
//	}
//}
/*
Et là, si je vais afficher ça.

	>javac App.java
	>java App
	5

on tombe bien sûr le 5.

Donc vous voyez c'est très simple pour retrouver via l'indice, encore une fois, parce que les données en mémoire sont stockées de manière contiguë donc avec un simple jeu d'indice, on arrive très facilement à retrouver l'information que l'on veut et comment on parcourt ce type de données qui est un peu plus complexe, d'accord.

On a un tableau dans un tableau donc comment mon parcours ça ?
Eh bien, c'est aussi simple, en fait, vous avez plusieurs petites manières donc une manière très simple c'est-à-dire le tableau, le fameux for qu'on a déjà vu, qui va être doubler tout simplement parce qu'il faut un premier for pour parcourir la première dimension et ensuite comme chaque première dimension du tableau est également un autre tableau, il faut une 2e boucle.

En gros, une première boucle qui dit j'accède au premier élément mais ici il y a un tableau {1, 2, 3} donc il faut bien une boucle pour lire tout ça et ensuite on itèra la première boucle qui arrivera du coup là {4, 5, 6} et l'autre, la 2e boucle ira à nouveau lire tous ces éléments et ainsi de suite, d'accord.

C'est pour ça qu'on a deux boucles, ça il faut bien le comprendre donc en gros une boucle par dimension si voilà vous voulez pas vous perdre.

Donc là, on fait un "for(int i = 0", là il y a une petite particularité, vous allez très vite comprendre pourquoi.

"for(int i = 0 ; i < tab.length", tant que i est plus petit que tab.length, okay.

Et on fait ça "for(int i = 0 ; i < tab.length ; ++i)".

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = 
		{
			{1, 2, 3}, 
			{4, 5, 6}
		};
		
		for(int i = 0 ; i < tab.length ; ++i)
			
	}
}

Ensuite dans ce for(), on en a un autre. On lui dit cette fois ci, on va créer un "j", généralement quand on fait des compteurs dans une boucle, on les appelle i, j, k et cetera, on ne s'embête pas à mettre des noms explicites.

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = 
		{
			{1, 2, 3}, 
			{4, 5, 6}
		};
		
		for(int i = 0 ; i < tab.length ; ++i)
			for(int j = 0 ;
	}
}

Et lui, c'est 0 aussi d'accord, parce que je rappelle que ça commence à l'indice 0, pareil pour l'autre dimension.

Par contre j, qu'est-ce qu'on veut qu'il parcourt ? On ne veux pas qu'il parcourt le premier tableau, d'accord. 

Non, il est déjà dans les sous-tableau, dans les tableaux contenus dans tab donc, en fait, on va dire que l'on veut s'arrêter à tab[i].length.

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = 
		{
			{1, 2, 3}, 
			{4, 5, 6}
		};
		
		for(int i = 0 ; i < tab.length ; ++i)
			for(int j = 0 ; j < tab[i].length
	}
}

En gros, on ne veut pas la taille du tableau complet ici, on veut la taille de ce tableau là {1, 2, 3} donc ça c'est "tab[i].length" et ça {4, 5, 6}, c'est aussi "tab[i].length".

Et là du coup (++j) et ensuite, on fait comme tout à l'heure. Donc là, on affichera du coup tab[i][j], c'est l'information là qu'on va avoir.

Donc, on va faire comme ceci simplement.
*/
//public class App
//{
//	public static void main(String[] args)
//	{
//		int[][] tab = 
//		{
//			{1, 2, 3}, 
//			{4, 5, 6}
//		};
//		
//		for(int i = 0 ; i < tab.length ; ++i)
//			for(int j = 0 ; j < tab[i].length ; ++j)
//				System.out.println(tab[i][j]);
//	}
//}
/*
Je prend encore une fois du temps parce que c'est quelque chose qu'on manipule très souvent les tableaux à deux dimensions, voilà.

Peut-être que vous faites des études, que vous allez avoir besoin d'en utiliser en Java donc vous saurez comment ça fonctionne.

	>javac App.java
	>java App
	1
	2
	3
	4
	5
	6

Et là, vous voyez tous les éléments se suivent, on parcourt tout.

Première dimension là {1, 2, 3}, 2e dimension {4, 5, 6} donc avec nos 2 boucles.

=============

Et on peut bien sûr simplifier tout ça avec ce qu'on a vu précédemment donc c'est-à-dire la fameuse boucle foreach.

Donc en fait, on fait juste ceci.

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = 
		{
			{1, 2, 3}, 
			{4, 5, 6}
		};
		
		for(int i = 0 ; i < tab.length ; ++i)
			for(int j = 0 ; j < tab[i].length ; ++j)
				System.out.println(tab[i][j]);
			
		for(int[]
	}
}

Je vais mettre ça "for(int[]" par exemple. 

Alors voyez, je dis c'est un tableau ici "for(int[]" parce qu'en fait, on récupère des tableaux, je rappelle, ici ça stocke ce tableau là {1, 2, 3} qui en stocke d'autres.

Donc c'est pour ça qu'on dit que notre élément intermédiaire, c'est un tableau.

Donc je vais mettre par exemple i, notre tab "for(int[] i : tab)" OK.

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = 
		{
			{1, 2, 3}, 
			{4, 5, 6}
		};
		
		for(int i = 0 ; i < tab.length ; ++i)
			for(int j = 0 ; j < tab[i].length ; ++j)
				System.out.println(tab[i][j]);
			
		for(int[] i : tab)
			for
	}
}

Et ensuite ici comme on récupère juste des entiers c'est-à-dire qu'une fois qu'on est dans les sous-tableaux, ils contiennent que des entiers sinon si il contenait d'autres tableaux bon aurait 3 dimensions.

En fait on aura un tableau tridimensionnelle donc là c'est encore autre chose donc on pourrait tout à fait le manipuler, après si vous avez compris la logique pour le tableau à deux dimensions, vous pouvez faire un tableau à 16 dimensions si ça vous amuse, il n'y a pas de problème. Ca serait inutile mais pourquoi pas. 

Et du coup, on va mettre pour number parce qu'on a des nombres et ça du coup, c'est de i, OK.

public class App
{
	public static void main(String[] args)
	{
		int[][] tab = 
		{
			{1, 2, 3}, 
			{4, 5, 6}
		};
		
		for(int i = 0 ; i < tab.length ; ++i)
			for(int j = 0 ; j < tab[i].length ; ++j)
				System.out.println(tab[i][j]);
			
		for(int[] i : tab)
			for(int number : i)
	}
}

Et là, System.out.println de number.
*/
//public class App
//{
//	public static void main(String[] args)
//	{
//		int[][] tab = 
//		{
//			{1, 2, 3}, 
//			{4, 5, 6}
//		};
//			
//		for(int[] i : tab)
//			for(int number : i)
//				System.out.println(number);
//	}
//}
/*
Et si j'ai pas fait de bétises, comme je m'enregistre, je peux faire des fautes d'inatention sur le code, ça arrive des fois vous me laisser des commentaires en me disant bah tiens tu t'es gouré à tel endroit, ça m'arrive et voilà.

	>javac App.java
	>java App
	1
	2
	3
	4
	5
	6

Et là, on a bien tous les éléments qui sont affichées, pareil à la suite mais avec quelque chose d'un peu plus optimisé pour le coup.

Donc 2 dimensions, deux boucles, pas de problème par rapport à ça.

Voilà pour tout ce qui est "fonctionnement des tableaux". Qu'est-ce qu'un tableau ? comment il est représenté en mémoire donc ça je vous dit c'était très important de vous l'expliquer pour vous puissiez justement éviter pas mal d'erreurs par rapport à ça.

Comment on accède aux éléments ? Comment on les modifie ? Comment on les lis avec le parcours d'un tableau et de 2 manières différentes ?

On a fait une bonne parenthèse sur les tableaux à 2 dimensions de parce que vous avez très certainement un jour devoir en manipuler.

================

Et on va voir maintenant un autre point aussi qui est important.

J'avais dit que la vidéo occuperait pas mal de temps, il y a beaucoup de choses à voir. 

Comment on va travailler avec ces tableaux dans des méthodes d'accord ? Comment on peut les employer ? Parce que vous allez rarement travailler avec des tableaux seulement dans une seule méthode.

En gros de dire, j'ai un tableau, d'accord. 

public class App
{
	public static void main(String[] args)
	{
		int[] tab = {};
	}
}

Je vais mettre des données ici.

public class App
{
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3, 4, 5};
	}
}

Et je veux faire une méthode qui va me l'afficher ce tableau là.

public class App
{
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3, 4, 5};
		printTab(tab);
	}
}

Et ça c'est souvent aussi quelque chose qui revient donc pour ça que je prends les devants par rapport à cette vidéo pour vous montrer comment faire tout simplement.

Donc là, comme on est dans la la classe qui contient notre méthode main, on va faire une méthode statique évidemment parce qu'on aurait fait une méthode simple si on travaillait dans une autre classe.

On fait "public static void printTab()".

public class App
{
	public static void printTab()
	{
		
	}
	
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3, 4, 5};
		printTab(tab);
	}
}

Et comme on récupère en paramètre le tableau. Ben tout simplement voyez ici la méthode main, elle a un tableau "String[] args" qui est un tableau, en fait, sur des données de type String, des chaînes de caractères.

D'ailleurs, on aurait une vidéo dédiée plus tard là dessus.

Et bien vous faites la même chose. Vous dites simplement j'attends un tableau voilà. Donc j'attends t, j'aurais un élément t qui sera ce que j'attends donc un tableau avec des données de type int, tout simplement.

public class App
{
	public static void printTab(int[] t)
	{
		
	}
	
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3, 4, 5};
		printTab(tab);
	}
}

Et là, on re fait tout ce qu'on a fait tout à l'heure c'est-à-dire on a simplement : for(int element : t)
									System.out.println(element);
C'est tout.
*/
//public class App
//{
//	public static void printTab(int[] t)
//	{
//		for(int element : t)
//			System.out.println(element);
//	}
//	
//	public static void main(String[] args)
//	{
//		int[] tab = {1, 2, 3, 4, 5};
//		printTab(tab);
//	}
//}
/*
Et terminée, ça s'affiche.

	>javac App.java
	>java App
	1
	2
	3
	4
	5

Voilà donc c'est aussi simple que ça, d'accord.

Si c'est une simple variable attendu alors vous mettez le nom de la variable enfin le type et le nom "int t". Si c'est un tableau, vous rajoutez des crochets "int[] t", voilà.

Là "int[] t" ou après "int t[]", peu importe, encore une fois, personnellement, je conseille plutôt de les mettre avant comme je l'ai expliqué tout à l'heure, ça évite comme ça de mélanger les choses et à la lecture c'est mieux. 


Quand on lis de droite à gauche "int[] t", on arrive à comprendre "tab" est un tableau "[]" pour des données de type "int".

"t" est un paramètre attendu qui est un tableau "[]" pour des données de type "int" et cetera.

On arrive facilement à lire les choses en fait. 

Voilà pour ça, en tout cas pour tout ce qu'on a vu concernant justement ces tableaux ici.

========

Et on va terminer donc on pourrait s'arrêter là mais bon je vais rajouter un petit peu parce ce que je sais que vous aimez bien souvent avoir plein plein d'éléments pour avoir un maximum d'informations et de choses à finaliser puisque j'avais dit en Java et ça je ne vais pas forcément le répeter dans toutes mes vidéos mais il faudra bien de retenir.

Comprenez que nous avons un objet c'est-à-dire qu'en fait nous avons une classe en Java d'accord qui s'appelle "Objects", donc du coup le nom est très simple alors, comme ceci, OK.

/
	Objects
/

public class App
{
	public static void printTab(int[] t)
	{
		for(int element : t)
			System.out.println(element);
	}
	
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3, 4, 5};
		printTab(tab);
	}
}

Et qui en fait contient ...qui en fait représente un objet quel qu'il soit en Java.

Du coup, nos tableaux, ce sont également des objets, d'accord.

Nous avons des fois des types primitifs comme int ou autre qui sont des cas particulier mais on verra par exemple plus tard, c'est pour ça que je voulais qu'on aborde la programmation objet donc qu'on voit qu'est-ce qu'une classe et cetera.

Parce que quand on va aborder la vidéo notamment sur les chaînes de caractères donc la classe String, vous verez qu'il y a pas mal de choses qu'on peut faire dessus.

Et notre tableau du coup, il hérite d'Objects et Objects bah c'est une classe qui possède pas mal de méthodes qu'on peut utiliser du coup pour tout ce qui en hérite.

On n'a pas encore parlé d'héritage mais en gros ce qu'il faut comprendre parce qu'on aura bien-sûr pas mal d'éléments là dessus... concernant ça, c'est qu'une classe qui hérite d'une autre et bah elle peut faire tout ce que sa classe mère, dont elle hérite, est capable de faire que ce soit en termes de méthode ou éventuellement les attributs qu'elle possède.

Donc en gros, cette classe Objects, elle a certaines méthodes comme par exemple le fait de vérifier des égalités. Elle a par exemple une méthode equals qui permet de vérifier l'égalité entre 2 objets quel qu'il soit.

/
	Objects : equals
/

public class App
{
	public static void printTab(int[] t)
	{
		for(int element : t)
			System.out.println(element);
	}
	
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3, 4, 5};
		printTab(tab);
	}
}

Et on a aussi une méthode qui est pas mal connue qui toString qui permet en fait de faire un affichage sous forme de chaîne de caractères pour une classe donc en fait elle prend en paramètre pareil un objet quel qu'il soit et essaie d'afficher des informations sur ce dernier.

/
	Objects : equals, toString
/

public class App
{
	public static void printTab(int[] t)
	{
		for(int element : t)
			System.out.println(element);
	}
	
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3, 4, 5};
		printTab(tab);
	}
}

D'ailleurs, on pourrait s'amuser, juste comme ça pour voir un petit peu. On a fait notre tableau ici.

public class App
{
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3, 4, 5};

	}
}

Voilà et on va faire et alors normalement est-ce qu'il le prend directement ... "tab.toString();"
*/
//public class App
//{
//	public static void main(String[] args)
//	{
//		int[] tab = {1, 2, 3, 4, 5};
//		tab.toString();
//	}
//}
/*
"tab.toString();", d'accord donc on utilise pour tab, la méthode toString(), c'est ça qui est important à comprendre.

	>javac App.java
	>java App

Et là évidemment, on a rien alors apparemment afficher tout simplement que j'ai oublié ...
*/
//public class App
//{
//	public static void main(String[] args)
//	{
//		int[] tab = {1, 2, 3, 4, 5};
//		System.out.println(tab.toString());
//	}
//}
/*
Voilà donc on affiche évidemment son adresse d'accord.
	>javac App.java
	>java App
	[I@7a81197d
On a un petit peu ce qu'on avait tout à l'heure quand on faisait simplement un println de tab. 

Et donc il y a des méthodes comme ça qui pour le coup ne servent pas beaucoup mais on a des méthodes en fait d'objets, d'accord, qui évidemment tout ce qui en héritent, peuvent utiliser.

Mais là où c'est intéressant, si je vous dit ça, ce n'est pas encore une fois pour faire joli, c'est parce que nous avons également d'autres ... alors soit des classes, soit éventuellement des interfaces.

On n'a pas encore non plus parler des interfaces en Java, c'est une notion qu'on va largement aborder parce qu'elle est très très importante et très utile en programmation objet.

Mais en gros, on va avoir accès à pas mal d'éléments.

Alors on a une classe Array, tout simplement, qui s'appelle donc comme ceci.

Alors déjà, on doit l'importer donc en gros, on doit faire un import.

import

public class App
{
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3, 4, 5};

	}
}

On n'a pas encore parlé des paquets tout ça, on en parlera, tout ça. Ce qui est un peu embêtant c'est que tout se confond, toutes les notions se mélangent et cetera.

Et le problème, c'est que dès que je vais vous parler d'un truc Ben je ne peux pas forcément tout de suite parce que on n'a pas encore vu tel ou tel chose.

Mais en gros, on importe java.util.Array et nous avons ce genre de choses-là.

import java.util.Array;

public class App
{
	public static void main(String[] args)
	{
		int[] tab = {1, 2, 3, 4, 5};

	}
}

Donc on a en fait des paquets différents, on expliquera, on a un truc qui est "util" et dedans on a "Array" qui est une classe qu'on peut utiliser, d'accord.

Mais nous, alors dans cette classe, on a pas mal de choses par exemple, on peut créer un certain tableau particulier donc en utilisant Array, d'accord.

On peut faire une nouvelle instance de ce dernier, on peut y récupérer des données, on peut ajouter des données, on peut récupérer la taille et cetera.

Donc ça ne nous intéresse pas tellement pour le coup mais on a également "Arrays" avec un s et là du coup c'est autre chose, c'est tout simplement la possibilité d'utiliser certaines méthodes donc, pareil, pour de l'égalité, on peut par exemple remplir un tableau avec certaines valeurs. On peut faire vraiment beaucoup de choses.

En gros, par exemple, si on fait, on terminera bien sûr avec ça, par exemple si je vais faire "int[] tab = new int[10];" comme ceci.

import java.util.Arrays;

public class App
{
	public static void main(String[] args)
	{
		int[] tab = new int[10];
	}
}

Je peux m'amuser à faire "Arrays" donc voilà je passe par là, je fais un point parce que c'est une classe en fait un peu utilitaire c'est pour ça que ça s'appelle "util" ce truc là "java.util".

import java.util.Arrays;

public class App
{
	public static void main(String[] args)
	{
		int[] tab = new int[10];

		Arrays.
	}
}

C'est une classe utilitaire et permet de faire pas mal de méthodes statiques donc on n'a pas besoin de créer une instance de Arrays, on dit simplement : "pour telle classe, t'utilise telle méthode statique" donc ça c'est des choses que j'ai déjà expliqué avant.

Et par exemple on lui dit "fill, tu va lui passer le tableau et comme c'est un tableau d'entier, tu vas remplir ça avec 15, par exemple avec des 15".

import java.util.Arrays;

public class App
{
	public static void main(String[] args)
	{
		int[] tab = new int[10];

		Arrays.fill(tab, 15);
	}
}

Et ensuite du coup pour chaque élément donc "for(int el : tab)", tu va faire un "System.out.println(el);". 
*/
import java.util.Arrays;

public class App
{
	public static void main(String[] args)
	{
		int[] tab = new int[10];

		Arrays.fill(tab, 15);
		
		for(int el : tab)
			System.out.println(el);
	}
}
/*
	>javac App.java
	>java App
	15
	15
	15
	15
	15
	15
	15
	15
	15
	15

Et voilà, tout a été rempli avec des 15, d'accord.

Donc nos 10 éléments ont été remplis avec des 15.

Donc on a pas mal, comme ça, de méthodes utilitaires très pratique. Je vous montrerai vraiment pas tout. Comme je vous l'ai dit, Java est certainement un des langages les plus complets c'est-à-dire qu'il y a plein plein de classes, des interfaces, des données qu'on peut manipuler et je pourrais faire 300 vidéos en fait de cours Java qu'on n'aurait pas fait le tour en fait de tout ce qui est disponible et tout ce qu'il est possible de faire.

Donc il faut prendre l'habitude d'aller voir la documentation Java, il y a pas mal de choses par rapport à ça, vous trouvez comme ça plein d'exemples, pleins de méthodes, plein de choses que je n'aborderais pas forcément en vidéo parce que je peux malheureusement pas tout aborder, il y a trop trop de choses.

Il y a certainement des choses qui ne sont pas utiles à l'heure actuelle, en tout cas tout de suite et qui vous serviront peut-être plus tard mais n'hésitez pas justement a voir sur cette classe Arrays qui permet du coup de me trouver pas mal de méthodes très utile.

On pourra par exemple aussi trier des éléments avec une méthode "sort", or pareil avec certaines choses mais même chose comme il faut avoir besoin d'avoir vu certaines interfaces pour pouvoir par exemple utiliser des bon systèmes de comparaison de valeurs qu'on expliquera plus tard.

Même chose voilà, vous trouvez pas mal de méthodes pour ça et on aura l'occasion de revenir dessus parce qu'on n'a pas encore vu comme j'ai dit les interface, les classes abstraites, l'héritage tout ça donc je peux malheureusement pas vous en parler tout de suite.

Mais ne vous en faites pas, c'est prévu pour le cours et on aura beaucoup beaucoup de choses à voir.

Je pense qu'on va s'arrêter là, la vidéo, si je regarde ça fait 38 minutes que je suis en train d'enregistrer.

Donc ça fait pas mal, on aura une bonne vidéo d'une quarantaine de minutes sur les tableaux en Java, on aura vu beaucoup beaucoup de choses.

Evidemment, on va avoir plein d'autres collections en Java d'accord.

On verra par exemple les listes, les piles, les files et cetera.

Il y a plein plein de choses intéressantes qu'on peut voir aussi mais là au niveau des tableaux, on a je pense vu suffisamment de choses, d'accord sur comment gérer un petit peu la création de tableaux, l'initialisation, comment c'est en mémoire, comment on récupère les tailles, comment on les affiches, comment on les parcours et cetera.

Donc vous avez normalement largement, largement de quoi faire avec tout ça.

S'il y a des questions, surtout n'hésitez pas d'accord, n'hésitez pas et j'espère que ces applications, en tout cas notamment, schématique là, vous aurez pas mal aidé à comprendre.

Voilà comprendre qu'est-ce qu'un tableau en réalité, qu'on n'appelle pas ça un tableau juste pour faire joli, c'est tout simplement pour cette idée, c'est vraiment ce qu'il faut retenir je pense, là dessus de cette organisation contiguë, en fait, des données c'est-à-dire qui se suivent les unes à la suite des autres en mémoire et même si en Java on ne se soucie pas trop de comment gérer la mémoire parce que c'est un langage beaucoup plus haut niveau que d'autres, c'est quand même bien de savoir qu'un tableau fonctionne de cette manière parce que du coup au niveau manipulation, on évite pas mal d'erreurs.

Je vous dis à bientôt pour la prochaine séance, n'hésitez pas à liker et partager la vidéo si ça vous a plu et que ça peut intéresser d'autres personnes qui voudraient éventuellement apprendre Java aussi et on se retrouve du coup pour la prochaine vidéo sur ce cours.

Ciao tout le monde 



*/