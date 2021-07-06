# [4. Variables et constantes](https://www.youtube.com/watch?v=ilJGviAXoTM)

+ [Les types primitifs](#Les-types-primitifs)
+ [](#)
+ [](#)
+ [](#)
+ [](#)
+ [](#)

Bonjour à tous, bienvenue pour cette séance 4 sur la formation Java où nous allons aborder une des premières notions très importantes en programmation que ce soit en Java d'ailleurs ou dans d'autres langages pour parler des variables.

Alors les variables c'est tout simplement un terme utilisé qui va désigner un emplacement mémoire que nous avons réservé pour y stocker des données.

## Les types primitifs

Dans la vidéo précédente, je vous avais montré un petit peu ce tableau :
```txt
    TYPE PRIMITIF | TYPE "OBJET" ASSOCIE | PLACE EN MEMOIRE | FOURCHETTE DE VALEURS (MIN&MAX)
    boolean        Boolean        1 octet        true (1) | false (0)
    byte        Byte        1 octet        -128 à 127
    char        Character     2 octets    Unicode (65536 caractères disponibles)
    short        Short        2 octets    -32768 à 32768
    int            Integer        4 octets    -2 147 483 648 à 2 147 483 647
    long        Long        8 octets    -2^63 à 2^63 -1
    float        Float        4 octets    1,4x10^-45 à 3,4x10^38
    double        Double        8 octets    4,9x10^-324 à 1,7x10^308
```
Je vous avais montré un petit peu ce tableau et on avait parlé des types de données donc j'avais fait toute une vidéo là dessus pour montrer tous les types que nous pouvons utiliser en Java et très vite nous apprendrons également utiliser des objets d'accord qui sont associés à ces types.

Ca ce sont les types primitifs qui sont disponibles comme ça par défaut et on pourra bien évidemment travailler directement sur des objets et notamment sur l'objet String qui permettra de manipuler des chaînes de caractères.

Comment ça va se passer ?
```java
public class MainApp
{
    public static void main(String[] args)
    {

    }
}
```
Et bien au niveau de nos programmes, d'accord au niveau du code, il va bien falloir que nous manipulons des données c'est-à-dire que si nous avons rien pour enregistrer, stocker même si c'est temporaire des informations pour pouvoir les utiliser, on ne pourra absolument rien faire.

On pourrait simplement que se contenter d'afficher des choses directement en dur par exemple euh dans un affichage comme ceci, d'accord, par exemple afficher un nombre :
```java
public class MainApp
{
    public static void main(String[] args)
    {
        System.out.println("14");
    }
}
```
Par exemple afficher un nombre, ce genre de choses et on n'irait pas bien loin d'accord. On afficherait toujours une chaîne avec quelque chose. On ne pourrait pas véritablement travailler avec des données, travailer avec des informations. Des informations que l'on peut récupérer par l'utilisateur depuis un fichier, depuis un site, depuis une base de données. Bref tout un tas de données que l'on peut récupérer à droite et à gauche.

Et c'est pour ça je vous avais dit que ces types là (Tableau des types primitifs) allait nous servir d'accord pour pouvoir manipuler des variables.

On emploie ce terme de variables tout simplement puisque nous allons stocker des données dans des espèces de petite ou simplement vous allez voir des labels, en fait des étiquettes.

C'est-à-dire qu'on va donner un nom à nos variables.

Ca va réserver un espace en mémoire sur le système donc après c'est Windows ou Linux ou Mac et cetera qui gèrera cette gestion de la mémoire.

Et à partir de là, on pourra toujours modifier éventuellement les valeurs de nos variable, donc les faire varier. D'où ce termes de variables justement pour cette notion là.

Alors Comment ça va se passer ? c'est très simple, pour ceux qui viennent du c du c++ ou des langages assez similaires, tout ce que vous allez revoir là, c'est grosso modo la même chose que ce que vous avez vu dans d'autres langages donc vous allez pas apprendre grand chose de plus si ce n'est pour les constantes ce que nous allons voir une autre partie sur la fin de la vidéo concernant les constantes, par contre, si Java est vraiment votre premier langage de programmation ou que vous venez de python avant ou d'un autre langage un peu plus exotique, évidemment là vous allez apprendre des petites choses en plus.

La première chose à faire, c'est de savoir que Java évidemment est un langage qu'on dit fortement typé c'est-à-dire qu'il y a des langages où vous pouvez créer des variables sans forcément dire quel type de données vous souhaitez stocker à l'intérieur. Je pense par exemple au langage python, au langage PHP.

A partir de là c'est l'interpréteur de python ou de PHP qui va déduire le type de données à réserver en mémoire en fonction de ce que vous avez mis à l'intérieur de votre variante.

Pour Java, c'est beaucoup plus beaucoup plus strict comme pour le C par exemple, on va devoir justement spécifier le type.

Si on veut stocker un nombre par exemple, un tout petit tout petit nombre du genre 15, et bien il devra dire voilà éventuellement qu'on veut stocker dans une variable de type byte, d'accord, avec ce type ici.
```txt
    TYPE PRIMITIF | TYPE "OBJET" ASSOCIE | PLACE EN MEMOIRE | FOURCHETTE DE VALEURS (MIN&MAX)
    byte        Byte        1 octet        -128 à 127
```
Si on veut utiliser un grand nombre flottant, on pourra par exemple dire qu'on utilise le type double.
```txt
    TYPE PRIMITIF | TYPE "OBJET" ASSOCIE | PLACE EN MEMOIRE | FOURCHETTE DE VALEURS (MIN&MAX)
    double        Double        8 octets    4,9x10^-324 à 1,7x10^308
```
Dire qu'on utilise le type double et à partir de là, Java sera capable de réserver l'espace nécessaire par rapport au type choisi.

## Créer une variable

Donc la première chose à faire pour créer une variable, donc on va parler de déclaration de variable, c'est de choisir le type que l'on veut.

Nous, on va stocker par exemple un petit nom alors on va pas forcément cette utiliser un byte parce que ce nombre pourrait être amenée à grandir et on va, par convention et surtout par habitude, utiliser le type Integer parce que c'est utiliser, on va dire, de manière courante.

Donc on va mettre ce type là tout simplement.
```java
public class MainApp
{
    public static void main(String[] args)
    {
        int
    }
}
```
Et là nous allons donner un nom à notre variable, c'est-à-dire que le programme a besoin d'un nom tout simplement. On ne peut pas lui donner, par exemple, des adresses mémoire ou autre, ce serait absolument trop complexe à manipuler pour le programmeur.

Donc on va lui donner un nom, on va la nommer et le nommage de variable est assez simple ce qu'on retrouve un peu le même partout et je vais vous le mettre en commentaire ici pour vous puissiez vous en souvenir.
```java
/*
- Pas de caractères spéciaux, pas d'espaces
- Commence par une lettre ou underscore (_)
*/
```
Donc un hommage de variables déjà c'est pas de caractères spéciaux, d'accord, les accents, les caractères genre dollars, pour cent et cetera, pas d'espace, OK.

Ca commence obligatoirement par une lettre ou underscore, d'accord, underscore, c'est le tiret du bas, celui là, que j'ai mis entre parenthèses la. Et bien sûr, on respectera ça et après ça peut éventuellement respecter une convention de nommage.

Les conventions de nommage c'est la convention dite camelCase, camelCase, ça veut dire qu'on va écrire comme ça. Si on veut par exemple constituer un nom de variable de plusieurs mots, par exemple, "uneVariable" comme ce sont 2 mots et bien en camelCase donc c'est un un terme à désigné pour une certaine syntaxe, une certaine manière d'écrire le nom, le nommage.

On va l'écrire comme ceci, ça c'est ce qu'on appelle la syntaxe camelCase.
```java
/*
- Pas de caractères spéciaux, pas d'espaces
- Commence par une lettre ou underscore (_)

uneVariable
*/
```
On a la syntaxe PascalCase qui s'écrirait comme ça.
```java
/*
- Pas de caractères spéciaux, pas d'espaces
- Commence par une lettre ou underscore (_)

uneVariable
UneVariable
*/
```

Vous voyez qu'on met une majuscule à chaque début de mot (PascalCase) alors que celui-là (camelCase), on met pas de majuscule au début mais après à chaque nouveau mot on remet une majuscule tout le temps, à chaque fois (uneVariableUnPeuLongue).
```java
/*
- Pas de caractères spéciaux, pas d'espaces
- Commence par une lettre ou underscore (_)

uneVariableUnPeuLongue
UneVariable
*/
```

uneVariableUnPeuLongue : Il n'y a que pour le premier mot où on laisse tout en minuscule et après vous mettez une majuscule pour chaque. Ça c'est camel case.

UneVariable : ça c'est pascal case. Pascal est un langage de programmation.
```java
/*
- Pas de caractères spéciaux, pas d'espaces
- Commence par une lettre ou underscore (_)

uneVariableUnPeuLongue (camel case)
UneVariable (Pascal case)
*/
```

Et on va avoir ensuite, une variable avec un underscore et là on appelle ça le snake case. snake pour serpent puisque ça peut faire penser à un serpent par rapport au underscore dont ce nom de snake case.
```java
/*
- Pas de caractères spéciaux, pas d'espaces
- Commence par une lettre ou underscore (_)

uneVariableUnPeuLongue (camel case)
UneVariable (Pascal case)
une_variable (snake case)
*/
```
Donc ça, c'est grosso modo, les 3 conventions de nommage standard qui existe en programmation en informatique.

Il y en a d'autres, on pourrait même en inventé nous-mêmes mais ça ce sont les 3 standard et selon les langages, chacun adopte un petit peu sa notation.

On va retrouver une_variable en python. Le Pascal case, on va le trouver en langage Pascal et par exemple en langage Csharp, le langage de Microsoft et uneVariableUnPeuLongue on va le retrouver en C, en C++ et en Java.

Donc je vous invite évidemment à écrire vos variables et vos fonctions, d'accord, les méthodes tout ce qu'on verra plus tard, un peu de cette manière uneVariableUnPeuLongue (camel case), d'accord, parce que c'est une question d'habitude et que les gens ont pris cette habitude là.

Vous voyez que les noms des classes sont marqués en Pascal case d'accord, donc là on se rend bien compte "MainApp".
```java
public class MainApp{...}
```
Il y a un M et un A majuscule mais pour les variables essayer d'adopter ce type de nom `uneVariableUnPeuLongue` (camel case)

Donc on va choisir un nom tout simplement, donc par exemple si on veut l'âge de l'utilisateur on va mettre ça comme ça, d'accord.
```java
public class MainApp
{
    public static void main(String[] args)
    {
        int ageUtilisateur
    }
}
```
Et là, on va utiliser un opérateur et les opérateurs, on les verra dans une prochaine vidéo, bien en détail, qui est un opérateur dit d'affectation donc on va affecter une valeur à cette variable là qui est de type integer, d'accord en entier, et on peut par exemple mettre 25. On termine par un ; comme pour n'importe quelles instructions et vous venez de déclarer ici et initialiser votre variable à 25, d'accord, donc une variable à l'utilisateur de type int qui est intialiser à 25.
```java
public class MainApp
{
    public static void main(String[] args)
    {
        int ageUtilisateur = 25;
    }
}
```
ça pareil, je vous le recommande quand vous créez une variable, quand vous déclarez une variable, essayer de l' initialiser au départ, toujours avec une valeur.

Si vous voulez une valeur par défaut mettez par exemple 0 pour après éventuellement la changer.
```java
    int ageUtilisateur = 0;
```
Eviter de faire juste une simple déclaration comme ceci pour ne pas vous retrouver avec n'importe quoi.
```java
    int ageUtilisateur;
```
Encore une fois, par habitude, c'est de toujours initialiser dé qu'on déclare une variable comme ça, au moins, on est sûr qu'il n'y a pas de problème à ce niveau là.

Donc voilà, pour Java essayé d'adopter cette écriture là `uneVariableUnPeuLongue` (camel case)

C'est le mieux et comme ça tout le monde s'y retrouve.

Donc là, à partir de là, évidemment au niveau de la machine virtuelle, elle sera capable par rapport au nom que vous avez donné de retrouver en mémoire, d'accord, une zone mémoire où vous avez stocké le nombre, ici, que vous avez affecté et à partir de là on va pouvoir travailler avec.

Donc ça c'est une déclaration toute simple avec un premier opérateur (=) que vous découvrez mais vous en avez déjà utilisé d'autres en fait si on vous en rendre compte. On aura l'occasion de les aborder, ici, un opérateur d'affectation (=).

On a cet opérateur là, par exemple, les crochets [] mais on en parlera plus tard quand on abordera les tableaux et les parenthèses () aussi qui sont des des opérateurs un peu particulier.

Voilà pour ça.

Donc très important, là vous avez appris comment déclarer une variable, comment la nommer (ageUtilisateur), quel type enfin comment il faut déterminer un type, définir un type pour cette variable (int) et faire une affectation à cette variable (=).

## Afficher la valeur d'une variable

Donc à partir de là, je peux sans problème afficher la valeur d'une variable. Pour afficher la valeur d'une variable ça va être tout simplement via la même méthode qu'on avait déjà vu avant donc println() ici mais comme il s'agit pas d'un texte d'accord c'est-à-dire que si vous faites ceci comme on l'a vu jusqu'à présent.
```java
public class MainApp
{
   public static void main(String[] args)
   {
       int ageUtilisateur = 0;
       System.out.println("ageUtilisateur");
   }
}
```
Là on va aller directement allez exécuter votre programme.
```powershell
    >javac MainApp.java
    >java MainApp
    ageUtilisateur
```
Si je fais ça, on se rend compte que ça fiche ageUtilisateur, ce qui est logique puisque je vous expliqué tout au départ que là, on demande d'afficher un texte, une chaîne.
A partir de moment où l'on met ces doubles guillemets, ici, de chaque côté "ageUtilisateur", tout ce qui sera à l'intérieur sera considéré comme étant du texte, une chaîne.

Donc c'est effectivement le comportement que l'on attend et du coup ce qui s'affiche là.
Pour avoir cette variable, d'accord, il suffit simplement de retirer les doubles guillemets tout logiquement.

```java
public class MainApp
{
   public static void main(String[] args)
   {
       int ageUtilisateur = 0;
       System.out.println(ageUtilisateur);
   }
}
```
Et là on aura évidemment le contenu donc c'est pas à vous voyez de chercher la valeur, c'est Java qui va se débrouiller il nous affiche bien la valeur de 0, OK.
```powershell
    >javac MainApp.java
    >java MainApp
    0
```
Donc là on va pouvoir c'est un problème changer la valeur d'une variable. Il y a absolument aucun problème. On peut très bien, à un moment donné juste après cet affichage là, de dire ageUtilisateur, je lui affecte autre chose.
```java
public class MainApp
{
    public static void main(String[] args)
    {
        int ageUtilisateur = 0;
        System.out.println(ageUtilisateur);

        ageUtilisateur
    }
}
```
Vous voyez que je met pas le type tout simplement parce que là c'était pour la déclaration, la création de la variable.
Maintenant qu'elle est créé, je n'ai évidemment plus besoin de spécifier son type. Je dis juste ageUtilisateur, je vais maintenant lui affecter une autre valeur 24 et là je peux refaire un affichage après cette modification.
```java
public class MainApp
{
   public static void main(String[] args)
   {
       int ageUtilisateur = 0;
       System.out.println(ageUtilisateur);

       ageUtilisateur = 24;
       System.out.println(ageUtilisateur);
   }
}
```
Donc on recommence comme ça, on pseudo-compile.
```powershell
	>javac MainApp.java
	>java MainApp
	0
	24
```
On pseudo-compile et voilà on vois que la valeur à bien changé donc ça c'est tout simplement le principe des variables, d'accord, avec modifications par affectation , d'accord.

On affecte une nouvelle valeur quand on veut modifier la valeur d'une variable et vous verrez plus tard qu'on pourra par exemple demander à l'utilisateur de rentrer quelque chose au clavier et stocker ce que l'utilisateur à saisi au clavier dans une variable, c'est justement le principe.

Là vous vous rendez bien compte que sans variables, on serait énormément bloqué sur nos programmes.

On pourrait tout simplement pas manipuler des valeurs utilisateurs ou des valeurs issues d'un fichier ou autre parce qu'on aura absolument rien pour sauvegarder.

Alors ça c'est le premier point qu'il fallait savoir, comment gérer un petit peu tout ça.

On verra des constantes sur la fin, d'accord, j'en parlais sur la fin de la vidéo parce que ça ne va pas être trop long.

## La portée des variables

Mais ce qui est important maintenant, c'est de parler de portée des variables, ça c'est très important parce que c'est une difficulté que rencontrent beaucoup les programmeurs en général alors que le principe est vraiment très simple.

Une variable de manière générale, quel que soit le langage, elle tient à sa portée dans l'endroit où elle a été créée, l'endroit où elle a été déclaré.

Là vous voyez que j'ai déclaré ma variable dans ma méthode main, d'accord, ici qui est la méthode de ma classe MainApp.
```java
public class MainApp
{
    public static void main(String[] args)
    {
        int ageUtilisateur = 0;
        System.out.println(ageUtilisateur);

        ageUtilisateur = 24;
        System.out.println(ageUtilisateur);
    }
}
```
Donc automatiquement comme je l'ai déclaré ici.
```java
	int ageUtilisateur = 0;
```
Une fois que je vais quitter cette méthode, d'accord, que je vais arriver à l'accolade de fin.
```java
    public static void main(String[] args)
    {
        int ageUtilisateur = 0;
        System.out.println(ageUtilisateur);

        ageUtilisateur = 24;
        System.out.println(ageUtilisateur);
    } // <----
```
Cette variable n'existe plus, d'accord.
Java va tout simplement libérer la mémoire donc va détruire cette variable.
Il sera impossible de l'utiliser ailleurs donc si je m'amusais par exemple a créé ici une autre méthode comme on le verra plus tard, d'accord.
```java
public class MainApp
{
    public static void main(String[] args)
    {
        int ageUtilisateur = 0;
        System.out.println(ageUtilisateur);

        ageUtilisateur = 24;
        System.out.println(ageUtilisateur);
    }
	
	public void autreMethode()
	{
		
	}
}
```
Je sais pas, par exemple, je faisais "public void autreMethode()". Bon je met un nom en français, je devrait mettre un nom en anglais mais bon peu importe, comme ceci.
```java
	public void autreMethode()
	{
		
	}
```
Puis qu'à un moment donné, il me prend l'envie d'appeler ma méthode.
```java
public class MainApp
{
    public static void main(String[] args)
    {
        int ageUtilisateur = 0;
        System.out.println(ageUtilisateur);

        ageUtilisateur = 24;
        System.out.println(ageUtilisateur);
		
		autreMethode();
    }
	
	public void autreMethode()
	{
		
	}
}
```
Tout ça bon évidemment, vous n'avez pas encore appris, on le verra plus tard mais je vous le montre rapidement.
Si là je m'amuse à faire, rien que ça en fait tout simplement.
```java
public class MainApp
{
   public static void main(String[] args)
   {
       int ageUtilisateur = 0;
       System.out.println(ageUtilisateur);

       ageUtilisateur = 24;
       System.out.println(ageUtilisateur);
		
		autreMethode();
   }
	
	public void autreMethode()
	{
			System.out.println(ageUtilisateur);
	}
}
```

On va l'exécuter même si vous n'avez pas vu encore la création de méthode, on n'a pas encore été plus loin dans la création de classe, la construction de classe mais on le verra plus tard.
```powershell
	MainApp.java:417: error: non-static method autreMethode() cannot be referenced from a static context
					autreMethode();
					^
	MainApp.java:422: error: cannot find symbol
							System.out.println(ageUtilisateur);
											   ^
```
Vous voyez qu'il vous dit tout simplement qu'il ne trouve pas. Il n'arrive pas à trouver la variable ageUtilisateur. Pour lui il n'existe pas ici donc c'est tout à fait normal.

Donc là, à partir de cet endroit là. 
```java
	public void autreMethode()
	{
			System.out.println(ageUtilisateur);
	}
```
A partir de cet endroit là, vous comprenez bien qu'il y a une histoire de portée, de localité, en fait, des variables, OK.

Une variable va exister donc sa durée de vie tient sur l'endroit où elle a été déclarée donc ce qu'on appelle des contextes.
```java
	public static void main(String[] args)
	{
		// ...
	}
```
Donc là, c'est le contexte de la méthode c'est-à-dire, tout l'endroit où vous avez votre méthode et une fois qu'on quitte cette méthode main de toute façon, la variable est automatiquement libéré.

Alors contrairement à d'autres langages par exemple comme le C où le C++ quand on va manipulé par exemple des données dynamique, vous verrez qu'ici il n'y a pas besoin de vous le chargez forcément de libérer vous-mêmes la mémoire quand on manipulera des types de données un peu complexe.

Java pour c'est ce qu'on appelle un ramasse-miettes, un garbage collector, c'est-à-dire qu'il va lui-même se charger de supprimer et de libérer la mémoire proprement comme vous le feriez en python.

En python, vous pouvez créer des types de variables que vous voulez des listes, des tableaux, fin des tuples, vous pouvez mettre absolument n'importe quoi, des dictionnaires, des nombres, des chiffres, tout ça et automatiquement jamais vous êtes occuper de vous-même libérer la mémoire en python.

En java, c'est exactement la même chose, c'est un ramasse-miettes qui s'exécute quand il faut donc c'est lui qui gère automatiquement. On peut éventuellement gérer un ramasse-miettes si on veut mais c'est quand même pour des cas très très spécifique et un peu plus complexe mais sinon java s'occupe de tout ce qui est libération mémoire.

Donc vous, vous créer des variables, vous leurs affecter des valeurs, vous les modifier, vous travailler avec, vous les utiliser, vous affichez leur contenu et de toute façon le programme se chargera de libérer la mémoire comme il faut.

Voilà donc très important, la portée de variable. 
Enfin, je pense pas que ce soit compliqué en tout cas à comprendre qu'une variable et bien elle n'existe qu à l'endroit où elle a été créée et l'endroit où elle a été créée, ici, on le voit bien grâce aux accolades.
```java
public class MainApp
{
    public static void main(String[] args)
    { // <--
        int ageUtilisateur = 0;
        System.out.println(ageUtilisateur);

        ageUtilisateur = 24;
        System.out.println(ageUtilisateur);
    } // <--
}
```
Ca nous aide énormément comme indicateur visuel, ça a été créé dans cette méthode "main(){}"

A partir du moment où on n'est plus dans la méthode main, toutes les autres méthodes ou tout les autres endroits de notre programme n'auront pas accès en fait à cette variable ageUtilisateur.

On verra, il y a des moyens éventuellement de transmettre des données d'une méthode à l'autre il y a des retours, il y a des fonctions et cetera. On verra tout ça.

## Constante

Voilà pour le principe des variables, tout ce qui me semblait important à connaître et on va terminer cette vidéo avec une variable un peu particulière qui est dite une constante.

Une constante, ça semble être l'inverse d'une variable c'est-à-dire une donnée qui ne peut pas changer, d'accord.

Quelque chose qui est constant, c'est quelque chose qui ne peut pas justement varier.

### Créer une variable constante

Comment on va créer une variable constante ? 
Donc on va créer en fait une constante.
Il y a 2 petites choses à savoir :

Première chose, on va utiliser le mot clé final.
```java
public class MainApp
{
    public static void main(String[] args)
    { 
		final
    }
}
```
Alors ça c'est la petite nouveauté puisque c'est pas un mot-clé qu'on retrouve dans d'autres langages de programmation.

En général dans les autres langages comme le C, ça va être le mot-clé const qu'on retrouve assez souvent.

Pour Java, c'est différent, le mot clé est final et vous comprendrez plus tard pourquoi. C'est très très lié au fait que Java est un langage qui utilise principalement et exclusivement le paradigme objet. On utilisera final pour d'autres cas que les variables pour créer des constantes.

Donc vous mettez final, vous mettez le type, d'accord, ça ne change pas, vous mettez le nom de votre variable comme d'habitude sauf que la différence ici c'est qu'une constante par convention, d'accord, par rapport à des programmeurs, on va toujours l'écrire en majuscule, d'accord. ça permet comme ça pour nous de la retrouver.
```java
		final int NUMBER
```
NUMBER, c'est peut-être un mot réservé donc on va éviter. On va mettre NUMB plus tôt. Ah non, d'accord, je pense que mon éditeur me le met automatiquement en couleur violet quand c'est une constante.

Hop comme ça voilà, NUMBER et on lui met une valeur 26.
```java
		final int NUMBER = 26;
```
Donc pareil, je peux m'amuser à faire la même chose et cetera.
```java
public class MainApp
{
   public static void main(String[] args)
   { 
		final int NUMBER = 26;
		
		System.out.println(NUMBER);
   }
}
```
Donc là, j'affiche ça comme ça, d'accord.
Voilà c'est aussi simple, l'affichage ne change absolument rien, pas de problème.
```powershell
>javac MainApp.java
>java MainApp
26
```
Par contre si j'essaye à un moment donné de faire "NUMBER=14", admettons puis je veux réafficher la nouvelle valeur de NUMBER, là je vais avoir évidemment un problème.
```java
public class MainApp
{
    public static void main(String[] args)
    { 
		final int NUMBER = 26;
		System.out.println(NUMBER);
		NUMBER = 14;
		System.out.println(NUMBER);
    }
}
```
```powershell
	MainApp.java:557: error: cannot assign a value to final variable NUMBER
					NUMBER = 14;
					^
	1 error
```
Voyez il me note "error: cannot assign a value to final variable NUMBER", on peut tout simplement pas asigner, pour faire une affectation d'une valeur, pour une variable qui est déclaré en finale.

Donc une variable final, c'est une, en Java, une constante.
Donc voyez, on arrive bien à la différencier d'ailleurs voilà.
Je vois qu'il l'a mis comme ça maintenant(NUMBER en blanc non identifié par l'éditeur alors l'éditeur la mettais en violet tout à l'heure). Peu importe.

Voyez que du coup, en mettant en majuscule, c'est plus facile à utiliser et si c'est plusieurs mots dans votre constante là, vous mettez tout simplement un underscore comme ceci, voilà.

Du coup, ça deviendrait ça, plus facile à reconnaître.
J'ai l'impression que l'éditeur gère mal les couleurs pour les constantes mais bon peu importe, c'est pas grave.

Donc voilà comment ça fonctionne pour une constante.

Donc une constante, par exemple, ça peut être en math la valeur de PI. Ca peut-être si on veut une valeur, par exemple, de PI qui soit évidemment à peu près approximativement, on va mettre juste 3,14 sans mettre plus de décimales, on ferait ceci.
```java
public class MainApp
{
    public static void main(String[] args)
    { 
		final float PI = 3.14;
    }
}
```
On ferrait ceci parce qu'on ne va pas dire du jour au lendemain, dire que PI fait 6 point quelque chose, d'accord. C'est 3 14 et cetera.

Donc voilà, comment on va gérer un petit peu les constante en Java; le mot-clé final et par convention, on écrit le nom tout en majuscules.

Comme ça, on sait différencier une variable d'une constante quand on programme et quand on relit son code.

Et je vais vous laisser avec ça, c'est tout ce que je voulais aborder, avec vous avec les variables mais déjà pas mal mine de rien à voir.

Vous avez vu comment afficher donc des variables, vous avez vu comment les créer, comment leur réaffecter des valeurs, comment éventuellement les modifier et on verra qu'on peut faire pas mal d'autres choses avec les variables, avec des opérateurs qu'on abordera d'ailleurs dans la prochaine séance.

On a beaucoup d'opérateurs à voir. On ne les verra pas tous mais on verra déjà ceux pour faire des calculs, ceux pour faire des incrémentations, pour faire des comparaisons de de valeur justement et ça permettra déjà d'aborder énormément de notions mine de rien.

Donc on prendra le temps de regarder ça dans la prochaine séance.

S'il y a des questions comme d'habitude, n'hésitez pas à les poser en commentaires. 

N'hésitez pas aussi à faire vos premiers programmes même si évidemment on commence très doucement et qu'on ne voit pas grand grand chose.

Donc vous avez pas non plus l'occasion de faire des gros gros programmes tout de suite mais n'hésitez pas quand-même à bien comprendre ces principes, à bien voir comment ça fonctionne au niveau des variables, au niveau de la portée des variables, de leur accès, le fait qu'on puisse y accéder ou non en fonction de l'endroit où on se trouve dans le programme et je vous dis à bientôt du coup pour la prochaine séance où nous aborderons les opérateurs.

A bientôt tout le monde