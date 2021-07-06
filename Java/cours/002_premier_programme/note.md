# [2. Premier programme](https://www.youtube.com/watch?v=cvpkw2ZN4Ps)

```java
/* Titre: JavaScript #2 - hello world !
 * Date: 27-02-20 | Revision: --
 * Compiler: -
 * Interpreter: -
 * Author: Samuel Jacquet
 */
```

+ [Introduction](#Introduction)
+ [Créer un fichier source en Java](#Créer-un-fichier-source-en-Java)
+ [La signature de "main"](#La-signature-de-main)
+ [L instruction](#L-instruction)
+ [rem - Les commentaires](#rem---Les-commentaires)
+ [Créer le pseudo-code](#Créer-le-pseudo-code)
+ [Exécuter](#Exécuter)
+ [Fin](#Fin)

## Introduction
	
Sur cette séance de Java #2, nous allons créer nos premiers programmes dans cette séance.
Nous verons en détails le code que nous allons écrire et le programme qu'il va produire.
Nous allons voir en détails lors de la création d'un premier script.

Dans la séance précédente, nous avons vu comment installer notre machine virtuelle.
Nous avons vu quel est la différence entre langage compilé (C, C++ par exemple) et un langage qui est pseudo-compilé comme
le Java qui était ensuite éxécuté sur une machine virtuelle sachant que l'avantage est que la machine virtuelle étant la
-même peu importe le système d'exploitation, on avait pas besoin de recompiler notre version en changeant d'OS.

A partir du même code-source, ou à partir du même pseudo-code, du même programme qui a été pseudo-compilé, on peut
l'éxécuter quelque soit le système d'exploitation via la macihine virtuelle et qu'il soit automatiquement géré sur 
n'importe quel système pour produire un programme portable. C'est un avantage que le langage Java possède par rapport au
au langage compilé.

## Créer un fichier source en Java

Pour créer un fihcier source enJava, on part d'un fichier txt comme on le fait habituellement par ce que c'est un fichier 
qui n'a pas de problème au niveau des conversions.

Ensuite on va lui donner un nom qui va porter le nom de classe du fichier parce que Java est un langage directement objet.
Notre approche au niveau du cours sera une approche directement objet. On ne va pas aborder Java en tant que langage 
procédurale puisque ce n'est pas possible même si on crée le programme le plus petit, Java est déjà un programme objet.

Comme la classe sera écrite en majuscule pour la première lettre du nom en majuscule, on va nommer le fichier comme le
nom de la classe pour ne pas s'en mêler les pinceaux.

La classe sera appelé "MainApp" pour application principale et on lui ajoute l'extension ".java". Ensuite, on l'ouvre
avec l'éditeur de code souhaité (Visual Code, Sublime Text, NotepadPlusPlus, Atom, Brackets) ou même via un environnement
de développement comme Eclipse, Netbeans, etc. 

A partir de là, on va commencer à écrire notre classe. Java a besoin, quelque soit le programme (ici on va faire le 
programme le plus petit qui existe), de créer une classe.

Si on vient d'un langage de programmation objet et que l'on connaît d'autres langages de programmation objet, on a 
suivi le cours sur Python par exemple, on sait peut être ce qu'est une classe mais on part du principe que Java est peut
être le premier langage de programmation que l'on apprend, c'est pourquoi on a besoin de savoir c'est une classe.

Une classe représente une entité, par exemple une classe qui représenterait un être humain, un animal, ce genre de chose
mais ça peut aussi représenter un concept, une idée. Donc ici, la classe Humain est un concept, une application.

```java
class MainApp_001
{
	
}
```

On commence par utiliser le mot clé "class" tout simplement et on va lui donner un nom "MainApp" comme le nom du fichier. 
Comme pour le langage C ou C++, on urilise le principe des accolades. Le langage Java utilise ce principe là. Autant en
Python, on va jouer sur l'indentation, sur les tabulations, ce genre de chose mais pour Java, c'est comme pour le
langage C, C++, JavaScript, PHP. Si on a l'habitude de ces langages et qu'on a l'habitude de ces langages, on utilisera
le principe des accolades.

A partir de là, lorsque notre classe est créé, il va faloir une fonction, appelé une méthode quand on parle de fonction 
à l'intérieur d'une class.

On va créer une méthode spéciale qui est obligatoire puisqu'elle est le point d'entrée de notre programme, c'est-à-dire
que nous allons exécuter notre programme et Java va rechercher absolument cette méthode là qui aura une signature 
particulière, une signature c'est tout simplement la manière de l'écrire.

```java
class MainApp_002
{
	public static void main(String[] args)
	{
		
	}
}
```

On lui passe simplement un mot clé "public" puis un autre "static" qu'on expliquera.

Ensuite le type de retour de la méthode, c'est-à-dire ce qu'elle renvoie comme information, ce qu'on abordera lorsqu'on
vera les fonctions, les méthodes pour voir comment ça fonctionne si on programme bien-sûr pour la première fois en 
langage Java.

Mais ici puisqu'on a rien qui se retourne, on va mettre le mot clé "void" suivi du nom de la méthode "main".

Enfin, on lui passe les paramètres, notamment un qui s'appelle "args" de type "String" suivi de crochet "[]".

Et comme quand on crée une nouvelle méthode, on crée des accolades.

```java
class MainApp_003
{
	public static void main(String[] args)
	{
		System.out.println("Bonjour tout le monde ! :)");
	}
}
```
A l'intérieur de ces accolades, on fait le fameux "Hello world" avec une écriture "System.out.println()" que nous allons expliquer. Puis on ajoute un petit message "Bonjour tout le monde ! :)" et un point-virgule pour terminer pour terminer l'inctruction.
	
Voilà grosso modo comment ça marche 
	
Pour expliquer ce programme très rapidement parce qu'il est très simple :
	
+ On a la définition de la classe "class MainApp{}" donc quand on va créer plus tard un objet, on va prendre automatiquement le nom de la classe. C'est-à-dire que si mon fichier, je l'avais appelé autrement que "MainApp", dans tout les cas le programme que j'aurais obtenu à la fin, qui aurait été pseudo-compilé possèdera le nom de la classe et là automatiquement "MainApp". Par habitude, il est recommandé d'appelé le fichier source de la même manière comme ça, on sait à quel classe ça fait référence.
		
+ Ensuite nous avons une signature très importante "public static void main(String[] args){}", c'est-à-dire que la fonction "main", signifie principale pour ceux qui connaissent le langage C ou le C++, est la fonction de départ du programme. On ne peut pas créer un programme sans avoir créé au minimum cette fonction, cette méthode dans notre programme en Java puisqu'à l'exécution, il va automatiquement démarrer par cette méthode et chercher "main". Elle s'appelle "main" tout en minuscule, il n'y a pas de majuscule et elle prend un certain paramètre précis, "args" c'est les paramètres que nous allons passer quand on va compiler notre programme, quand on va en tout cas l'exécuter pour éventuellement lui passer des arguments et comme nous n'allons pas lui passer des arguments sur les séances à suivre, on est forcé de le mettre car Java va devoir reconnaître cette signature là.
		
+ C'est-à-dire que si on ne met rien comme argument, qu'on ne passe pas du tout l'argument. Il y aura une erreur à l'exécution parce que Java ne reconnaîtra pas la fonction "main" qui l'attend. Donc la signature "String[] args" qui l'attend.
		
## La signature de main

Pour ceux qui ont vu le langage C , le C++, si on n'utilise pas les arguments de la fonction "main", on peut quand même les passer en mettant un "void" en C et rien du tout en C++. Pour Java, c'est différent comme il recharge vraiment la signature, on est obligé de le mettre même si on ne va pas l'utilité.

Le type de retour c'est <rien du tout> donc on est obligé de mettre "void". On verra ça en détails quand on abordera les méthodes.

"static" c'est par rapport à la portée, c'est le moyen d'accès à cette méthode. Comme ici c'est la méthode principale, d'entrée, on met static pour dire qu'elle est accèssible ici. On abordera les principes de portée des fonctions ou des attributs par la suite.

"public" c'est simplement le domaine d'accèssibilité. C'est-à-dire qu'elle est accessible depuis partout, depuis l'extérieur de la classe. C'est un peu ce que ne voulons car c'est la machine virtuelle qui va exécuter le programme et qui va donc y accéder. Si ce n'était pas public, on aurait des soucis.

Pour l'instant, nous avons juste à retenir que la fonction "main" porte cette signature :
```java
	public static void main(String[] args){}
```
C'est-à-dire "public", "static", "void", "main" et comme arguments "args" qui est de type "String[]", on expliquera ce que ce sont les crochets quand on abordera notamment les tableaux.

## L instruction

Ensuite à l'intérieur de cette méthode, nous avons avons une simple instruction. Un instruction se termine par un ";".

C'est comme ça qu'on la reconnait rapidement. Ca rappelle d'autres langages comme le C ou le C++ par exemple. 

```java
	System.out.println("Bonjour tout le monde ! :)");
```
Notamment ici, 2 choses, on voit le mot "System" qui commence généralement par une majuscule. Quand on a à faire à une classe, par convention, on la démarre avec une majuscule.

"System" est une classe native de Java. C'est une classe qui existe nativement, au départ dans le langage.

## rem - Les commentaires

C'est très lorsqu'on programme déjà dans d'autres langages. Pour ceux qui qui ne savent pas, les commentaires sont des parties de codes qui ne seront pas exécuter, ni même interprêter, ni autre. C'est simplement pour le développeur pour quand on lit le code source, pemet de nous aider. Ca permet de dire ce que fait une fonction, noter ce que font cetaines instructions avant qu'elles deviennent complexes.

Il y a deux types :
+ le commentaire sur une seule ligne avec un double slash, qui doit être absolument sur une seule ligne.
+ le commentaire sur plusieurs lignes qui est un slash étoile et qui termine par l'inverse étoile slash.

```java
//Un commentaire sur une seule ligne.
/*
Un commentaire
sur plusieurs ligne
*/
```

Voici donc les deux types de commentaires, très utile pour décrire notre code, et nous aider.

C'est les même que dans d'autres langages de programmations qui sont pas différent au niveau de la syntaxe.

C'est assez similaire d'un langage à l'autre.

```java
	//...
	
	System.out.println("Bonjour tout le monde ! :)");
```

"System" est une classe native et porte un nom qui est suffisament explicite. "System", c'est-à-dire qu'elle est liée au système. 
	
Ensuite, un attribut "out" tel qu'on le verra mais c'est simplement une variable qui appartient à une classe.
	
Quand on créera une variable dans une classe, on appelle ça un attribut, c'est simplement pour différencier les deux. Quand on a une simple variable, on parle de variable dite procédurale dans un langage procédurale, voir même impératif. Et quand on a une variable dans une classe, on parle d'attribut.
	
La classe "System" a une variable qui s'appelle "out", qui est d'un type précis "PrintStream" mais on ne va pas rentrer dans les détails, c'est un autre type de classe. 
	
Donc dans la classe "System", nous avons cette attribut "out" et pour cet attribut là qui lui même appartient à notre classe, on utilise des fonctions de cette classe.
	
Parmi ces fonctions disponibles, nous allons en utiliser une qui s'appelle "println" qui signifie simplement d'afficher quelque chose sur la sortie, à l'écran, la console, le terminal, l'invite de commande. "ln" pour "line" à la fin signifie simplement que ça fait un retour à la ligne à la fin.

```java
	..("Bonjour tout le monde ! :)");
```

Entre parenthèse, on met simplement des doubles guillemets pour préciser que nous allons utiliser une chaîne de charactères ou un texte. On pourrait mettre également de simple quottes :

```java
	..('Bonjour tout le monde ! :)');
```

mais si on a de simple quotte à l'intérieur, ça va simplement couper la chaîne mais pour ne pas être embêté au départ, le mieux est de mettre de double guillemets. Il faut tout mettre entre parenthèse pour les fonctions "println()".
	
C'est le point-virgule qui termine l'instruction ";". 
```java
	println("Bonjour tout le monde ! :)");
```	

"println()" est une fonction. On remarque bien qu'il y a un nom, des parenthèses et prend des choses à l'intérieur.

Et ça ressemble à "main()" qui est pareil, c'est une méthode, un fonction qui appartient à une classe et qui a éventuellement des paramètres aussi, de différents type aussi. Ici, on a un tableau avec une variable "String[] args" alors qui ici, on a une valeur en brute "Bonjour tout le monde ! :)", on note directement le texte. 
	
Nous reviendrons sur tout ça au cours de la formation, tout dans le détail. On pourra expliquer ce code nous même au cours de la formation.
	
## Créer le pseudo-code
	
Maintenant, nous allons créer le pseudo-code de tout ça pour pouvoir ensuite le faire exécuter par la machine virtuelle de Java. 
	
Nous allons directement à l'endroit du fichier :
	
```powershell
		CD C:.
		CLS
		LS			(sous Windows PowerShell)
		DIR			(sous un invite de Windows standard)
```

On vérifie qu'on a bien notre fichier dans la liste de notre répertoire (LS ou DIR).
	
On vérifie qu'on a bien l'extension ".java" et pas autre chose.
	
Si ce n'est pas marqué ".java", c'est qu'on a pas afficher l'extension des fichiers sur notre système. 
	
Une fois qu'on est là, on fait comme dans la vidéo précedente, on vérifie que l'outil est bien installé.
	
On utilise la commande avec "javac" (avec un c à la fin) et ensuite, on met le nom du fichier.

```powershell
	javac MainApp.java
```

Ainsi un fichier MainApp.class est apparu (on l'affiche avec LS). Il n'a pas prit le nom du fichier source. Il a prit le nom de la classe que l'on a mit dans le code.
	
Si on l'appelle "truc", le fichier s'appelera "truc.class". Ce n'est pas lié au nom du fichier mais pour ne pas se perdre, on le nomme de la même façon comme ça on sait que dans ce fichier, un classe porte ce nom "MainApp".
	
C'est un choix que l'on fait pour que ce soit plus facile de s'y retouver notamment lorsqu'on a plusieurs fichiers sources.
	
## Exécuter
	
Maintenant, on va pouvoir exécuter avec la commade Java. Normalement, javac, java ont dû être installé correctement. 

On a vu dans la séance précédente comment installer javac. Si ce n'est pas le cas, il faut le faire.
	
Nous devons simplement noter le nom du fichier sans le ".class". Automatiquement, il va chercher un fichier qui a l'extention "class" à la fin. On écrit la commande :

```powershell
	java MainApp_003
```

La machine virtuelle démarre. C'est peut être long à la première exécution car il faut exécuter la machine virtuelle pour la première fois et après les autres fois, ça va beaucoup plus vite à l'exécution.
	
Ainsi le programme s'affiche à l'écran sur mon invite de commande PowerShell, le terminal, peu importe le nom donné.
	
Voilà comment ça fonctionne pour ce programme minimal en Java, pour notre premier programme créé.
	
Donc, il faut bien comprendre qu'on va travailler avec ce principe de classe et ce principe d'objet.
	
Si on a pas encore de programmation objet, il faut regarder dans la playlist "Aide", la vidéo sur le "paradigme de la programmation objet". Cette vidéo est recommandé pour maintenant ou pour plus tard pour ainsi comprendre ce principe. Qu'est-ce que la programmation objet ? Qu'est-ce qu'une classe ? Le concept général peut s'impliquer à n'importe quel langage. Cette vidéo est recommandé et serra utile pour cette formation.
	
De toute façon, nous reviendrons la-dessus car nous allons aborder toutes ces notions avec ce langage parce qu'elles son un peu particulière. C'est-à-dire que là où nous avons d'autres langages, nous pouvions travailler directement en procédurale sans forcément créer de classe alors qu'en Java, le moindre petit problème que nous voulons faire, nous sommes obligé de créer une classe. Si je ne fait pas de classe, il y a tout simplement un problème à l'exécution, ça ne marchera pas.
	
Donc nous devons avoir cette classe minimal :

```java
class MainApp_003
{
	public static void main(String[] args)
	{
		System.out.println("Bonjour tout le monde ! :)");
	}
}
```
... avec la fonction "main()" qui est le point d'entrée du programme.
	
Ensuite, on met ce que l'on veut à l'intérieur et nous allons apprendre beaucoup de choses par rapport au langage Java que nous allons pouvoir manipuler dans nos programme.
	
## Fin
	
Nous ne pourrons tout voir car Java est immense en terme de possibilités, de fonctionnalités, présentent même en natif par défaut dans Java. On essayera de voir un maximum de chose.
	
Si c'est le premier langage de programmation que l'on aborde, il n'est pas conseillé parce que le paradigme objet est compliqué au départ même si on peut apprendre la programmation avec un premmier langage qui est objet.
	
Ce n'est pas une contrainte ou un obstacle, on peut très bien apprendre comme ça mais simplement que le langage Java est un langage très complet avec enormenent de choses, qui est assez verbeux dans le sens ou chaque chose que nous allons faire est noté.
	
Pour une petite méthode, on a plusieurs mots : 

```java
	public static void main(String[] args){}
```

On a "public", "static", "void", "main" donc pour le moindre petit programme, on a déjà pas mal de mots clés présents.
	
Ce n'est pas forcément l'idéal si c'est le premier langage que l'on apprend si on a toute fois avoir des difficultés pour quelque chose de nouveau. 
	
Si on cours des vidéos, on galère trop, il est recommandé de s'orienter vers un langage plus accèssible comme Python ou un langage plus procédurale comme le C ou il y aura toute la partie objet en moins. Ce sera complexe mais il y aura tout un paradigme en moins qui permettra d'aborder les choses plus naturellement.
	
Il ne faut pas s'embêté si on voit que c'est trop compliqué plutôt que de forcer les choses alors qu'il y a des moment où il suffit de le voir autrement. 
	
Si on aime la difficulté, qu'on est patient et motivé, sans problème, on peut découvrir la programmation informatique avec le langage Java mais ce n'est pas forcément le premier langage qu'on recommande à l'apprentissage.
	
Selon les capacités de chacuns.