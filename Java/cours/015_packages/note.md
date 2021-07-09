# [15. Packages](https://www.youtube.com/watch?v=8xVLSfM5UhY)

Bonjour bienvenue pour cette 15e séance en Java.

La dernière fois nous avions abordé énormément de classe Si vous vous souvenez Concernant les chaînes de caractères.

On a d'ailleurs eu 2 parties sur cette notion très importante Parce qu'il y a des manipulations bien précises à faire en fonction du type de données que l'on veut gérer et de quelle manière on veut le gérer.

On a parlé de monothreader, multithreader, et cetera.

Et là on va faire une petite pause et revenir sur quelques notions propres à la programmation orientée objet qu'on verra par la suite.

et là une petite pause avec cette vidéo concernant les paquets et c'est propre ici à Java puisqu'on va voir comment créer des modules ou des package, on peut leur donner le nom que l'on veut.

ce serait l'équivalent des modules pour ceux qui programment en Python Pour avoir différentes classes que l'on peut organiser de la manière que l'on veut au sein d'un projet.

la vidéo sera assez courte, il n'y aura pas grand-chose à apprendre Mais c'est quand même un passage important car on verra par la suite et on l'a vu dans la vidéo sur les chaînes de caractères qu'on a importé des paquets propre à Java quand on utilise certains objets.

Notamment lorsqu'on se souvient de Stringbuilder et cetera, on avait comme ça des imports à faire.

De départ nous avons un seul fichier, notre seul fichier Java, et par la suite je veux créer un Package.

Un package c'est tout simplement un répertoire, un dossier que vous allez créer et qui va contenir une ou plusieurs classes. Généralement quand on fait un package c'est dans l'idée d'inclure une ou plusieurs classes.

Après nous allons voir comment faire au niveau du nommage des package en question Mais là on va rester sur quelque chose d'assez simple. 

## Faire un package

Moi j'aimerais tout simplement faire un package. On commence par faire un import, ce serait tout simplement de pouvoir faire un paquet qui s'appellerait mypackage, pour garder un truc très simple au départ.
On fait un point et on dit alors que j'inclus toutes les classes qu'il contient en mettant un point et une étoile. Et on termine avec un ; 
```java
public class App
{
	Public static void main(String[] args)
	{
		
	}
}
```
Une * pour dire qu'on inclut Absolument toutes les classes que contient ce répertoire mypackage. 
A partir de là où se situe mon fichier je vais pouvoir créer mon répertoire directement.

Au niveau des noms, tout ce qui est nommage, on ne va pas voir tout ce qui est nommage conventionnel, On en parlera un petit peu après. 
 
Mais quand vous avez ce genre de chose vous devez tout écrire de préférence en minuscule, pas de caractères spéciaux, pas d'espace, pas de caractères accentu�s, et cetera. 
Et si vous utilisez un mot qui est utilisé par Java où qui est réservé par Java, vous pouvez exceptionnellement le faire à condition de le faire suivre avec un underscore :
```java
	Import mypackage.*;
```
Si par exemple vous utilisez le mot package ou encore une fois comme class par exemple ou public, c'est-à-dire des mots qui font partie de la syntaxe du langage Java, Il faudra à ce moment-là rajouté un underscore à la suite. Après dans l'idéal c'est de carrément ne pas utiliser des mots réservés Ou bien rajouter quelque chose devant.
par exemple comme package est un mot réservé, vous mettez un petit MY devant et comme ça vous n'aurez pas de problàme. 

## Créer une autre classe dans le répertoire mypackage

On crée une autre classe. Ok on va utiliser un exemple qu'on utilise dans d'autres cours, on va faire par exemple un `player.java` qui serait par exemple de quoi représenter un joueur et on aurait par exemple item.java pour représenter un objet. On fait donc ces 2 classes là. 
A partir du moment où on a une classe qui fait partie d'un package, il s'agit tout simplement ici de ne pas faire un import, de ne pas mettre un import évidemment. 
Import, c'est pour utiliser en important, en ajoutant dans App.java, Le package en question.
Mais dans `Player.java`, on dit qu'il en fait partie.
Donc on met package dans `Player.Java` et on remet du coup le nom, mypackage. 
```java
package mypackage;
```
On le met pour les deux et ensuite on ajoute une classe à Player.java.
```java
public class Player
{
	public class Player()
	{
		System.out.println("Player instancie !");
       }
}
```
Cette classe porte le même nom que le fichier. Ensuite on va faire quelque chose de très simple pour le constructeur. Le but étant de voir que ça a bien été construit, on affiche `"Player instancie !"`.

Ensuite on fera juste un copier-coller de `public class Player{}` pour `Item.java`. 
```java
package mypackage;

public class Item
{
	public class Player()
	{
		System.out.println("Item instancie !");
	}
}
```
En espérant que `item.java` ne soit pas en nous réservé. 

## Inclusion de la classe Player

Pour l'instant, nous allons juste inclure la classe Player du package.
Du coup on fait à Player.
```java
import mypackage.Player;

public class App
{
	public static void main(String[] args)
	{
		Player p = new Player();
		Item it = new Item();
	}
}
```
Dans le constructeur par défaut, on n'avait rien mis. 
Et du coup on fait ce genre de chose: 
```java
		Player p = new Player();
		Item it = new Item();
```
A partir de là, nous allons directement compiler ce code. 
Pour compiler, on écrit: 
```java
	javac App.java
```
On compile le fichier App.java qui après sera capable d'aller rechercher les autres packages puisqu'on fait tous les imports nécessaires.
On compile mais on se rend compte qu'on a un souci: 
```powershell
  		symbol:   class out
  		location: class System
		App.java:99: error: cannot find symbol
                Item it = new Item();
                ^
  		symbol:   class Item
  		location: class App
		App.java:99: error: cannot find symbol
  		Item it = new Item();
```
On se rend compte que Item n'est pas trouvé.
Encore une fois, si je veux éventuellement n'inclure que ces 2 classes Et admettons que j'avais dans mon package une dizaine de classes, il faudrait bien évidemment faire ce genre de choses: 
```java
	import mypackage.Player;
	import mypackage.Item;
```
Et si on veut tout inclure où éviter de faire des inclusions comme ci-dessus unique, Encore une fois on passe par le symbole étoile, l'astérisque, pour pouvoir faire l'inclusion totale: 
```java
	import mypackage.*;
```
On revient sur notre code et on compile :
```java
import mypackage.*;

public class App
{
	public static void main(String[] args)
	{
		Player p = new Player();
		Item it = new Item();
	}
}
```
On compile javac App.java et on exécute java App
On exécute notre fichier et on remarque que nos 2 constructeurs ont bien été instancié. On a les 2 constructeurs qui ont été appelàs, on a bien réussi à trouver nos 2 classes quoi. 

Donc voilà comment fonctionne la crçation d'un package. 

C'est très simple et l'utilisation est très simple aussi.

## Portée des classes 

On va revenir sur la portée des classes, Il y a des choses qu'on n'avait pas forcément précisé où notamment on avait dit qu'on reviendrait sur certaines choses. Quand on utilisait en fait le mot clà public, On se disait que c'était accessible de partout Et au niveau du package il y a un type de portée à prendre en compte.
En gros si je mets ce mot clà public pour la class ou autre pour d'autres éléments, ça signifie public pour tout. ça veut dire pour tout ce qui fait partie à la fois du package Mais aussi tout ce qui est à l'extérieur. 
En revanche si je m'amuse à faire ce genre de chose : 
```java
public class Player > class Player

package mypackage;

class Player
{
	public Player()
	{
		System.out.println("Player instancie !");
	}
}
```
Dans ce cas, en réalité je n'aurais pas vraiment une classe privée. J'aurai une classe qui sera public seulement pour le package Mais pas depuis l'extérieur. Donc tout ce qui fait partie du Package pourra se servir de cette classe mais tout ce qui n'en fait pas partie, ne pourra pas par rapport justement à cette histoire de portée. 

Donc si on veut quelque chose de vraiment accessible partout, On mettra évidemment la classe public.

Sinon C'est une portée visible uniquement pour le package Seulement. Donc attention à ça. 
Si des fois vous avez des petites erreurs où vous avez des accès qui ne fonctionnent pas, ce sera très certainement un problàme comme ça où l'on oubliera de spécifier la portée de notre classe Ou d'une méthode Ou d'un attribut d'une classe. Donc très important. 
Pareil si par exemple vous avez une classe publique et qu'on définit un élément ici qui aurait juste une valeur ;
```java
package mypackage;

public class Player
{
	
	int data;

       public Player()
	{
		System.out.println("Player instancie !");
	}
}
```
"int data" puis sans spécifier de portée, même chose cet élément-là ne pourra pas être modifié et ne pourra pas être accessible depuis l'extérieur du package. Très important, il faut gérer la portée par rapport à ça. 

Il faut bien prendre en compte tout ce qui est porté lié aux membres, aux classes, aux méthodes, et cetera, Pour que tout soit accessible en fonction soit pour le package soit pour l'extérieur du paquet.

A nous de bien gérer cela et de vérifier encore une fois l'encapsulation des données Comme on l'avait déjà vu précédemment.

## Convention de nommage

On va revenir maintenant sur la convention de nommage. 
```java
import mypackage.*;

public class App
{
	public static void main(String[] args)
	{
		Player p = new Player();
		Item it = new Item();
	}
}
```
`import mypackage.*;` ça c'est quand on veut par exemple faire un package très simple. 
On a peut être déjà vu en Java lorsqu'on veut importer des choses, on a ce genre de format : 
```java
	import java.util.*;
```
En général, on évite de faire un étoile parce que dans les classes utilitaires on en a quand même beaucoup Donc ça peut charger plein de fichiers inutiles Donc en général on est plutôt en nombre précis. 
Donc là on avait un nom du genre: 
```java
	import java.util.SomeClasse;
```
Et du coup on utilisait Stringbuilder ou autre en fonction.
Du coup on voit ici qu'il y a plusieurs noms séparés par des points et en fait en termes déjà hiéarchie, c'est simplement des sous package et qui sont repr�sentées au niveau de notre explorateur par des sous dossiers. 
Donc si on veut faire ce genre de choses, il y a une convention en Java qui est très utilisée qu'on retrouve un petit peu partout, c'est en gros avoir une extension de domaine c'est-à-dire comme pour les sites web .com, .fr, .Org et cetera.
Par exemple mettons fr. :
```java
	/*
		fr.
	*/
```
Donc on met fr, on peut mettre ensuite un nom de domaine, ça peut par exemple être notre nom, prénom où ce que vous voulez, ça peut être un nom de site ou n'importe quoi, c'est un identificateur. 
```java
	/* 
		fr.jachampagne
	*/ 
```
On peut mettre par exemple son pseudonyme et ensuite on peut mettre éventuellement le nom du package :
```java
	/*
		fr.jachampagne.mypackage
	*/  
```
Par exemple le fameux package qu'on avait où directement dans fr.jachampagne, j'aurais toute mes classes. Et du coup à ce moment là je pourrais juste garder :
```java
	/*
		fr.jachampagne
	*/  
```
et du coup je ferais un import de fr.jachampagne :
```java
	import fr.jachampagne.*;
```
Si je ne veux pas encore avoir d'autres parties et que je veux tout mettre dans fr.jachampagne
et au niveau hiéarchie, le changement se fera de cette manière. Donc au lieu d'avoir : 
```txt
C:.
|   App.class
|   App.java
|
|___mypackage
        Item.class
        Item.java
        Player.class
        Player.java
```
On va appeler notre répertoire fr et dans fr, on va justement avoir le domaine et on ajoute nos classe dans le domaine en virant les .class
```txt
C:.
|   App.class
|   App.java
|
|___fr
    |___jachampagne
            Item.java
            Player.java
```
Et le changement va bien sûr s'opérer dans les fichiers Item.java et Player.java où le paquet deviendra tout ça : fr.jachampagne

Il faut vraiment partir du point racine, là où on a notre fichier App.java Et ensuite chacun des sous dossiers qui doit bien sûr être évidemment renseigné. 

Donc pour l'import, on a ce format là :
```java
       import fr.jachampagne.*;
```
Et du coup on a accès au répertoire jachampagne Et donc si on met étoile, il est logique qu'on importe tout ce qu'il y a dans ce dossier. Sinon on met le nom du fichier, de la classe en particulier qui sera évidemment identique au nom de la classe qu'il y a à l'intérieur.

Et dans les classes à l'intérieur du package, on indique bien le mot clà package, Tout le chemin aussi. Donc ça c'est important sinon on risque d'avoir des erreurs à la compilation. Donc si on a des erreurs par rapport à un package inaccessible, une classe qui n'est pas trouvée, c'est qu'a priori on s'est trompé dans un de ces chemins donc attention par rapport à ça.

Et du coup ici je peux refaire une nouvelle compilation, une nouvelle exécution. 

+ App_fr.java
```java
import fr.jachampagne.*;

public class App
{
	public static void main(String[] args)
	{
		Player p = new Player();
		Item it = new Item();
	}
}
```
Une nouvelle compilation et une nouvelle exécution et on voit que ça fonctionne avec ce principe-là.

Donc tout simplement, ça c'est plus conventionnel au niveau de Java. On retrouvera plus souvent ce genre de choses. Pareil si on passe par un environnement de développement Qui permet de créer un package automatiquement en quelques clics, généralement il nous propose des noms de ce genre aussi parce que ça nous fait la crçation des répertoires et tout ça.

donc voilà, soit on utilise cette méthode conventionnelle soit on peut simplement avoir juste un dossier, un répertoire qui contiendra nos classes Et dans ce cas on fait ce qu'on a vu au début de la vidéo. 

Donc voilà nous aurons vu la manière standard et la manière conventionnelle en fonction de ce que l'on veut faire. 

Donc voilà pour tous les points qu'on aura voulu aborder durant cette vidéo, encore une fois le plus important là-dedans c'est de pouvoir organiser nos différents fichiers lorsqu'on aura un projet assez conséquent donc c'est là où c'est intéressant de ne pas avoir tout dans un seul fichier et encore une fois de ne pas avoir toutes les classes dans un seul répertoire ou tout est mélangé.

On va pouvoir organiser comme ça notre projet au sein de plusieurs package et sous package éventuellement.

Et après au niveau de la portée , de bien prendre en compte chaque portée pour essayer un maximum de respecter encore une fois le encapsulation Des données et bien garder chaque chose, de permettre l'indépendance de chaque package et puis qu'un package ne puisse pas communiquer avec un autre ou en tout cas qu'on limite un maximum ça pour encore une fois bien protéger la cohérence et l'intégrité des données.

Vous voyez c'était quelque chose de très simple à prendre en main Par rapport aux vidéos précédentes, la prochaine fois on va parler de pas mal de notion, on va parler d'héritage, on va parler de polymorphisme, on va également aborder les exceptions parce que ce sont des choses que l'on doit connaêtre, que l'on va devoir apprendre de manière générale et aussi ici en Java parce qu après on va revenir en fait sur de la saisie utilisateur et sur d'autres choses comme ça qui nécessitent au moins de comprendre ce qu'est l'héritage et ce que sont les exceptions, c'est pour ça que ces vidéos vont être vus avant de voir comment saisir des données plus tard pourquoi pas, manipuler des fichiers.

Donc on regardera tout ça un petit peu au niveau de ce cours.

A bientôt pour la prochaine séance.