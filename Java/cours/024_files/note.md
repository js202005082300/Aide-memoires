# [24. Files](https://www.youtube.com/watch?v=TLPqZ6QOeBo)

Séance 24 pour continuer ce que nous avons vu sur les collections de type files avec principalement deux classes que nous verrons au cours de cette séance.

```java
public class Main
{
    public static void main(String []args)
    {

    }
}
```

Nous allons commencer par 2 exemples en passant par l'interface Queue et Deque pour avoir tout simplement une file standard, et une file avec un système doublement chaînée donc on travaillera comme ça sur une classe de chaque interface pour voir un petit peu ce que ça donne.

Le premier exemple est de travailler sur une file de priorité en important `import java.util.PriorityQueue;` et à partir de là, on va la créer simplement rester sur quelque chose de très simple c'est-à-dire des entiers concrets directement pour faire une file vide.

```java
import java.util.PriorityQueue;

public class Main
{
    public static void main(String []args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    }
}
```

Voilà notre file vide, on va pouvoir donc travailler avec celle-ci. Une file, c'est toujours le même principe, c'est à dire qu'en respectant un certain ordre donc le premier élément inséré donc le premier entré est le premier sorti donc la structure de données FIFO.

On a ensuite un ordre naturel qui va être respecté au niveau de la structure de données, ce type de connexion qu'il ne garantit pas non plus en ordre précis auquel vous pourriez vous attendre parce que vous allez parcourir cette structure, l'ensemble de notre collection que l'on va voir très rapidement.

On va commencer par ajouter des éléments classiques avec des méthodes que l'on connaît bien, qui sont les méthodes de la collection qui sont des choses héritées qu'on peut parfaitement utiliser. Par exemple on va ajouter certaines valeurs mais pas une valeur nulle, il ne peut pas y avoir d'éléments nul qui soit inséré sinon on aura une exception qui sera levé.

+ Main.java
```java
import java.util.PriorityQueue;

public class Main
{
    public static void main(String []args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(155);
        pq.add(8);
        pq.add(0);
        pq.add(null);
        pq.add(-14);
        pq.add(365);
    }
}
```
```powershell
> javac Main.java
> java Main
Exception in thread "main" java.lang.NullPointerException
        at java.base/java.util.PriorityQueue.offer(PriorityQueue.java:326)
        at java.base/java.util.PriorityQueue.add(PriorityQueue.java:312)  
        at Main.main(Main.java:12)
```

Voilà j'ai exécuté on obtient bien une `NullPointerException` qui est tout simplement provoquée par `pq.add(null);` c'est à dire le fait de vouloir ajouter un élément nul ce qui n'est pas possible avec ce type-là donc on va les enlever et à la place on va rajouter une valeur identique `8` à une autre, ce qui est parfaitement possible parce qu'on peut ajouter des doublons.

Et là sans la valeur `null`, ça fonctionne.

+ Main.java
```java
import java.util.PriorityQueue;

public class Main
{
    public static void main(String []args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(155);
        pq.add(8);
        pq.add(0);
        pq.add(8);
        pq.add(-14);
        pq.add(365);
    }
}
```
```powershell
> javac Main.java
> java Main
```

Voilà pas de problème avec ce type de file, il n'y a pas d'erreur dans ce cas çi.

Nous allons pouvoir parfaitement enlever des éléments avec la méthode remove() mais pensez à toujours bien vérifier parce que quand vous avez une méthode qui peut générer une exception, de toujours mettre ça dans un bloc try catch pour vérifier et traiter les éventuelles exceptions.

Ainsi quand vous savez qu'une méthode peut lever une exception, il faut que ce soit traité.

Alors en résumé, on ne peut pas ajouter des éléments nuls, on peut ajouter des doublons, et il n'y a pas non plus d'histoire d'accès direct d'accord on avait vu certaines connexions dans la séance précédente avec un accès direct ce qui est beaucoup plus rapide pour la lecture.

Ici on n'a évidemment pas d'accès direct, on a un élément chaîne et donc il n'y a pas d'accès par un indice ou par une valeur bien précise d'accord on va devoir gérer la file tel quel et on n'a pas d'accès direct.

Alors ce n'est pas orienté non plus pour être utilisé en concurrence c'est à dire dans un environnement multi-threadé.

On note.

```js
/*
    PriorityQueue : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/
```

Alors pour PriorityQueue, la connexion est ordonnée, elle accepte les doublons, en revanche elle refuse des valeurs nulles et par contre ce n'est pas thread-safe pour dire que ce n'est pas fait pour du multi-threads donc il n'y a pas de gestion de la concurrence, de la synchronisation. Ça c'est important il faut savoir et de toute façon la classe que l'on verra par la suite, ce sera exactement pareil c'est à dire que ce ne sera pas thread-safe.

On n'aura donc pas pour les classes de cette séance de multi-threadés.

## PriorityQueue

On va voir maintenant d'autres méthodes qui vont pas mal être pratique ici et notamment une méthode pour récupérer l'élément qui est le plus petit, si je reprends mon exemple, on a ajouté les éléments dans un certain ordre donc à la base on peut avoir des connexions qui sont ordonnées dans ce sens c'est à dire que ça va respecter l'ordre d'insertion donc le premier élément inséré sera le premier élément à affiché en cas de parcours de la connexion mais ici comment on va respecter un certain ordre naturel au niveau de l'insertion, au niveau de l'ajout des éléments, il est possible qu'on se retrouve à la fin essai même très probable que ça arrive avec un ordre qui va être différent de l'ordre dans lequel j'ai inséré ces éléments.

D'ailleurs on peut s'amuser à les afficher avec un itérateur donc on va utiliser un itérateur standard parce qu'on n'a pas d'itérateur de liste puisqu'on ne travaille pas sur une liste, donc on va rester sur quelque chose de très simple `Iterator it = pq.iterator();` c'est à dire que j'applique ma méthode iterator() sur ma collection ensuite on va faire quelque chose de classique c'est à dire que tant qu'il y a un élément qui existe après `it.hasNext()`, que littérateur peut atteindre, on va directement l'afficher.

Vous allez voir qu'on va peut être avoir un ordre différent avec la valeur négative que l'on vient de mettre (-14) qui va automatiquement afficher un ordre différent.

+ Main.java
```java
import java.util.PriorityQueue;
import java.util.Iterator;

/*
    PriorityQueue : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(155);
        pq.add(8);
        pq.add(0);
        pq.add(8);
        pq.add(-14);
        pq.add(365);

        Iterator it = pq.iterator();

        while(it.hasNext())
            System.out.println(it.next());
    }
}
```
```powershell
> javac Main.java
> java Main
-14
0
8
155
8
365
```

Et voilà toujours saoul ont le même principe, le premier rentré et le premier sorti donc logiquement c'est le premier que j'ai rentré dans mon code était 155, ça devrait être logiquement la première valeur donc celle qui est en début de fil et vous voyez qu'ici quand on décide de parcourir toute la collection, on a un ordre complètement différent.

Alors on pourrait s'attendre à avoir un ordre rangé du plus petit au plus grand, donc ce serait moins étonnant d'avoir -14 tout au début idem pour le 365 tout à la fin par contre vous voyez que le 8 (nos 2 valeurs en double) sont un peu de manière aléatoire mais on a sans problème à 155 entre 2 valeurs de 8 donc ici attention on n'a pas un ordre bien précis.

En effet ici c'est un ordre naturel qui a été choisi, le problème c'est que l'ordre naturel ne garantit absolument pas l'ordre dans lequel vous aurez vos éléments dans ce type de collection.

Alors ici le but n'est pas d'avoir quelque chose qui respecte l'ordre d'insertion car on a vu d'autres collections pour faire ça.

Alors on verra par la suite quand on aura fait le tour des collections que je veux vous montrer, on verra comment travailler avec des éléments notamment pour faire de la comparaison entre éléments, comment est-ce qu'on peut gérer des ordres, que ce soit des ordres naturels ou même des ordres un peu plus quelconques au niveau de nos différents éléments de collection. On fera ça après les séances sur les différents types de collection que je vais vous montrer parce que ce sera une vidéo qui va concerner toutes les choses que l'on aura vu avant donc c'est quelque chose que l'on verra après plutôt que d'aborder ça pendant qu'on voit les collections. Je parle notamment ici des interfaces **comparable and comparator** qu'on regardera juste après les collections donc ne soyez pas étonné si on ne les aborde pas pour le moment.

Voilà donc ici on a eu un ordre naturel qui a été décédé mais ça aurait pu être autre chose.

On va enlever cette partie qu'on abordera avec un exemple sur cette collection quand on implémentera une méthode de comparaison, d'éléments pour pouvoir avoir un ordre du plus petit au plus grand pour des nombres et on verra également pour comparer des choses aussi.

```java
import java.util.PriorityQueue;

/*
    PriorityQueue : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(155);
        pq.add(8);
        pq.add(0);
        pq.add(8);
        pq.add(-14);
        pq.add(365);
    }
}
```

Alors maintenant si j'essaie de travailler avec des éléments qui ne sont pas comparables de manière naturel c'est à dire que jusqu'ici le langage était capable de s'en sortir c'est à dire de respecter un ordre naturel mais maintenant si je travaille avec quelque chose qui n'implémente pas (parce que maintenant vous savez ce qu'est une interface), qui ne implémente pas dans cette interface de comparaison que l'on verra un petit peu plus tard donc automatiquement ça ne fonctionnera pas.

Alors nous avons une autre classe sur le côté qui a été préparée préalablement c'est à dire une classe Player avec simplement des attributs et une petite méthode vite fait.

+ Player.java
```java
public class Player
{
    public Player(String name, int level)
    {
        this.name = name;
        this.level = level;
    }

    public void hello()
    {
        System.out.println(this.name + " dit bonjour !");
    }

    /*---------------------------------------------------------*/

    private String name;
    public String getName(){return this.name;}

    private int level;
}
```

Voilà on a très simplement une classe Player avec quelques attributs, une méthode vite fait et un accesseur pour voir rapidement donc on ne va pas se soucier du code qu'il y a ici mais c'est juste pour dire que au lieu de faire une file de priorité d'entiers, on va faire une file de priorité de joueurs, `PriorityQueue<Player> pq = new PriorityQueue<Player>();`.

```java
import java.util.PriorityQueue;

/*
    PriorityQueue : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        PriorityQueue<Player> pq = new PriorityQueue<Player>();

        /*
        pq.add(155);
        pq.add(8);
        pq.add(0);
        pq.add(8);
        pq.add(-14);
        pq.add(365);
        */
    }
}
```

Voilà on va faire une file de priorité de joueurs, au lieu d'entiers, mais pour le langage la contrainte de respecter un ordre naturel de ça n'est pas possible. Le langage n'est pas capable de comparer des joueurs. Autant il est capable de comparer des nombres, des chaînes de caractères ça va encore mais pour des joueurs c'est beaucoup plus compliqué.

À partir de là c'est j'essaie d'ajouter un nouveau joueur.

```java
import java.util.PriorityQueue;

/*
    PriorityQueue : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        PriorityQueue<Player> pq = new PriorityQueue<Player>();

        /*
        pq.add(155);
        pq.add(8);
        pq.add(0);
        pq.add(8);
        pq.add(-14);
        pq.add(365);
        */

        pq.add(new Player("Jason", 25));
        pq.add(new Player("Yufi", 18));
    }
}
```
```powershell
> javac Main.java
> java Main      
Exception in thread "main" java.lang.ClassCastException: class Player cannot be cast to class java.lang.Comparable (Player is in unnamed module of 
loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
        at java.base/java.util.PriorityQueue.siftUpComparable(PriorityQueue.java:644)
        at java.base/java.util.PriorityQueue.siftUp(PriorityQueue.java:640)
        at java.base/java.util.PriorityQueue.offer(PriorityQueue.java:331)
        at java.base/java.util.PriorityQueue.add(PriorityQueue.java:312)
        at Main.main(Main.java:22)
```

Automatiquement on a une petite erreur à l'exécution qui me dit que je ne peux tout simplement pas ajouter ces éléments-là puisqu'ils n'implémentent pas cette interface Comparable qui me permet de comparer ces différents éléments donc obligatoirement avec ce système là `PriorityQueue`, ce fils de priorité, vous pouvez créer seulement un ensemble de collection avec des éléments qui peuvent être comparables donc on va dire des types natifs.

On ne pourra comparer que des types natifs mais à partir du moment où vous allez vouloir comparer des types un peu plus complexes, vous devrez sûrement implémenter cette interface-là pour montrer, pour expliquer au niveau de votre code comment vous comparez votre type et nous ici en l'occurrence on compare des joueurs donc ça on le verra quand on aura fait un petit peu le tour des collections.

Il y aura une vidéo sur les comparateurs, et on reviendra sur nos exemples, et vous verrez qu'on arrivera à ce moment-là à gérer une file de priorité de joueurs, et même à respecter un ordre tel que nous l'avons décidé donc on dira comment comparer les choses, et comment gérer un ordre bien spécifique tel que nous le voulons nous en tant que développeur et par tel que le ferait la machine virtuelle. Ainsi ce genre de cas ici n'est pas possible donc on est obligé de revenir sur un exemple de tout à l'heure.

```java
import java.util.PriorityQueue;

/*
    PriorityQueue : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(155);
        pq.add(8);
        pq.add(0);
        pq.add(8);
        pq.add(-14);
        pq.add(365);
    }
}
```

## La méthode peek

Maintenant non ce qui peut être intéressant avec un fil de priorité, c'est avoir l'élément qui est en attente c'est-à-dire en attente d'être retiré de cette file.

Une fois que les éléments ont été mis dans un ordre, dans la structure, on peut finalement accéder à l'élément qui est en début de file parce qu'on est toujours sur ce système où on part par la fin parce qu'on a commencé par la fin et selon l'ordre qui a été établi c'est celui qui sera retiré en premier. C'est pour ça que c'est important par la suite de choisir le modèle de comparaison que l'on veut pour les différents éléments pour qu'on ait ensuite l'ordre qu'on attend et que l'on veut au niveau de notre connexion. Ainsi Pour ce faire je vais utiliser la méthode peek().

```java
import java.util.PriorityQueue;

/*
    PriorityQueue : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(155);
        pq.add(8);
        pq.add(0);
        pq.add(8);
        pq.add(-14);
        pq.add(365);

        System.out.println(pq.peek());
    }
}
```
```powershell
> javac Main.java
> java Main      
-14
```

Si je ré exécute le code ici, on retrouve le premier élément qui s'est ordonné, qui s'est remis au début de notre structure donc on l'a vu tout à l'heure que -14 s'était mis au début donc forcément c'est celui-là qu'on a retourné.

## La méthode poll

Si maintenant on veut retirer l'élément qui est finalement le premier qui doit en sortir, on peut utiliser la méthode poll().

La méthode poll() va afficher les éléments qui est en attente et elle va le retirer, voyez ce que ça fait quand on fait les 2 méthodes à la suite, poll() et peek().

```java
import java.util.PriorityQueue;

/*
    PriorityQueue : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(155);
        pq.add(8);
        pq.add(0);
        pq.add(8);
        pq.add(-14);
        pq.add(365);

        System.out.println(pq.poll());
        System.out.println(pq.peek());
    }
}
```
```powershell
> javac Main.java
> java Main      
-14
0
```

Voilà on a retiré le -14 qui est affiché avec poll() c'est à dire qu'on affiche l'élément puis on le retire de la collection, de notre fil prioritaire et du coup l'élément qui a finalement premier devient 0 avec ce qu'on a récupéré avec peek().

Voilà on peut comme ça retirer des éléments.

Ainsi on va utiliser ces méthodes là en faisant principalement de l'ajout add(), on va utiliser poll() pour enlever un élément et éventuellement l'afficher parce que c'est aussi à ça que ça sert.

On peut directement afficher l'élément avec la méthode element() qui fonctionne un peu comme peek() qui permet également de récupérer l'élément en cours donc l'élément qui est en attente.

Voilà je pense que pour PriorityQueue, on a fait un peu le tour de ce qui peut nous servir.

Bien évidemment n'oubliez pas avec tout ce qu'on a vu précédemment sur les différentes interfaces, comme ce sont des classes qui implémentent d'accord qui sont soit des sous-classes d'autres classes et qui implémente des interfaces, vous pouvez bien évidemment utiliser beaucoup de méthodes de ces interfaces.

Ainsi je ne vais donc pas revenir sur StringBuffer.capacity(), soort(), et cetera voilà donc la possibilité de trier ou avec la transformation en tableau avec toArray().
`
L'avantage pour ces séances c'est que même si je ne vous montre pas à nouveau tout à chaque fois pour chaque collection parce que ça répéterait à chaque fois les mêmes choses et au bout d'un moment c'est bon on a compris mais vous pouvez vous par contre vous exercer et vous entraîner pour bien comprendre encore une fois comment ça marche.

De toute façon je vous avais déjà expliqué que le principe de toutes ces collections, c'est de savoir quel type de collection utiliser en fonction de ce qu'on veut faire en particulier. Est ce qu'on veut travailler sur des éléments synchroniser ou non ? Est ce qu'on veut des lectures rapides où surtout beaucoup d'insertion ? Est ce qu'on veut accepter les doublons ou pas ? Est ce qu'on veut ordonner des éléments ? Est ce qu'on veut les trier ? Et cetera.

En fonction de ça, vous apprendrez à choisir les bonnes collections parce qu'il y en a beaucoup, et même si on veut en voir pas mal au niveau du cours, il y en a plein qu'on ne verra pas et qu'on découvrira sûrement par la suite d'un autre côté en continuant de progresser et de se perfectionner en Java.

Voilà pour cette collection-ci, et on va pouvoir passer à une autre collection.

Voilà ça c'était vraiment l'essentiel avoir pour cette fil te priorité.

## ArrayDeque

Maintenant on va voir pour un élément doublement chaîné donc qui est un peu comme un tableau mais qui fonctionne sur ce principe de fil aussi qui est ArrayDeque qui signifie tout simplement tableau doublement chaînée même si par principe c'est tout simplement quelque chose qui implémente l'interface Deque donc c'est très important.

```java
import java.util.ArrayDeque;

/*
    PriorityQueue   : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
    ArrayDeque      : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        ArrayDeque<Integer> adq = new ArrayDeque<Integer>();
    }
}
```

Voilà ArrayDeque est également ordonnée, ça va respecter un certain ordre et ne pas mettre les éléments n'importe où, et plus tard lorsqu'on verra tout ce qui est basé sur les Maps c'est à dire tout ce qui est associatif, on aurait évidemment des éléments qui vont être bien rangés, ordonné d'une certaine manière mais suivant le type de collection, l'ordre sera différent donc ça peut être ordre d'insertion, ordre naturel et cetera.

Pareil, ça va également accepter les doublons et refuser les valeurs nulles et ce n'est pas thread-safe.

Voilà c'est le même principe que ce qu'on a vu tout à l'heure, il n'y a pas de différence au niveau de chacune des files.

Ainsi on a tout l'avantage de la liste doublement chaînée y compris l'usage qu'on va pouvoir en avoir, alors ici on a le terme `ArrayDeque` c'est à dire qu'on mélange le mot *Array* pour tableau, et *Deque* pour une file doublement chaînée mais en même temps vous allez voir qu'on peut parfaitement l'utiliser pour une liste chainée ou même une Pile parce que nous allons profiter de beaucoup de nos méthodes qui nous permet d'utiliser ce type là pour pouvoir travailler sur d'autres types de structure en fonction de nos besoins.

Alors nous allons voir quelques petites choses assez simples, et présenter certaines de nos méthodes qui peuvent générer une exception si par exemple il y a une erreur ou bien que la structure est vide donc voilà je ne vais pas encore forcément vérifier tous avec des try catch mais il faudra faire attention à ce niveau-là.

Alors ici comme on est sur quelque chose de doublement chaînée, on va pouvoir ajouter où retirer des éléments depuis le début ou depuis la fin donc plutôt d'utiliser des méthodes génériques comme `add`, `remove` et cetera, Eh bien on aura plutôt intérêt à utiliser des méthodes comme `adq.addFirst()`.

Alors on importe l'ittérateur pour afficher.

+ Main.java
```java
import java.util.ArrayDeque;
import java.util.Iterator;

/*
    PriorityQueue   : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
    ArrayDeque      : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        ArrayDeque<Integer> adq = new ArrayDeque<Integer>();

        adq.addFirst(4);
        adq.addFirst(15);
        adq.addLast(0);

        Iterator it = adq.iterator();

        while(it.hasNext())
            System.out.println(it.next());
    }
}
```
```powershell
> javac Main.java
> java Main      
15
4
0
```

Voilà nous avons donc bien 15, 4 et 0 donc ça a rajouté 4 au tout début de notre file, sans problème, ensuite on a dit d'ajouter 15 dont 15 va passer devant, et ensuite comme on ajouter 0 à la fin, voilà donc là ça respecte bien l'ordre d'insertion.

On peut mettre ainsi les éléments comme on veut en les rangeant du plus petit au plus grand ou l'inverse, sans respecter ainsi l'ordre dans lequel vous insérez les éléments et c'est du coup beaucoup plus pratique, ça va être du coup beaucoup plus rapide aussi.

C'est par exemple on devait travailler avec une **Linked List**, une liste chaînée, Eh bien vous aurez quelque chose de plus rapide avec `ArrayDeque`. Ainsi ce sera plus rapide pour beaucoup beaucoup de raisons, ainsi on peut se référer à la séance précédente et on verra pourquoi avec des tests on a quelque chose de beaucoup plus efficace ici.

D'ailleurs pour la Pile (je spoil en avance), la Pile sera également plus efficace avec `ArrayDeque`, tout simplement parce qu'ici ce n'est pas thread-safe alors que vous savez que Stack est thread-safe donc forcément comme il y a un besoin de synchronisation pour travailler dans un environnement multi-threadé, automatiquement avec `ArrayDeque` comme il n'y a pas de cette spécificité, vous aurez des méthodes qui sont beaucoup plus rapides.

Ainsi on peut parfaitement utiliser cette collection, qui est très intéressant comme type parce qu'on peut l'utiliser comme une File, on peut faire de la liste chaînée avec et on peut également s'en servir comme une Pile. Ainsi on pourra avoir des équivalents, par exemple `AddFirst()` va devenir notre équivalent pour ajouter en fait nos éléments d'accord pour faire un Push, et on verra également la méthode `removeFirst()` qui elle va tout simplement permettre de faire en Pop donc avec le mot-clé First pour l'élément qui est au sommet donc on peut parfaitement utiliser `ArrayDeque` comme une Pile.

Après vous l'aurez compris, si on veut la lire, on a comme une liste doublement chaînée avec ce type `ArrayDeque` donc on peut rajouter en fin `addLast()` mais on peut également rajouter au début `addFirst()`, et on peut également parcourir dans les 2 sens donc ça va pas mal pratique. On pourra mettre des itérateurs, avec les itérateurs on pourra faire des parcours dans les 2 sens.

Pour removeFirst(),

+ Main.java
```java
import java.util.ArrayDeque;
import java.util.Iterator;

/*
    PriorityQueue   : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
    ArrayDeque      : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        ArrayDeque<Integer> adq = new ArrayDeque<Integer>();

        adq.addFirst(4);
        adq.addFirst(15);
        adq.addLast(0);
        adq.removeFirst();

        Iterator it = adq.iterator();

        while(it.hasNext())
            System.out.println(it.next());
    }
}
```
```powershell
> javac Main.java
> java Main
4
0
```

Voilà on a retiré l'élément qui était au début c'est à dire 15 qui était passé par devant 4 parce qu'il a été appelé après donc on peut supprimer comme ça.

On a également l'inverse removeLast().

On peut également accéder aux éléments en faisant un getFirst().

+ Main.java
```java
import java.util.ArrayDeque;
import java.util.Iterator;

/*
    PriorityQueue   : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
    ArrayDeque      : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        ArrayDeque<Integer> adq = new ArrayDeque<Integer>();

        adq.addFirst(4);
        adq.addFirst(15);
        adq.addLast(0);
        adq.removeFirst();

        Iterator it = adq.iterator();

        while(it.hasNext())
            System.out.println(it.next());

        System.out.println(adq.getFirst());
    }
}
```
```powershell
> javac Main.java
> java Main
4
0
4
```

Voilà, on retourne bien 4.

Alors attention toutes ces méthodes addFirst(), removeFirst(), getFirst() sont des méthodes qui peuvent lever une exception :warning: !

voilà donc normalement utilisé à chaque fois un bloc try catch si vous voulez vous en servir parce que si ça l'est une exception il faut traiter cette dernière, et ici je ne le fais pas pour pas rajouter plein de code et donc prendre le risque de se perdre dans toutes les vérifications alors que c'est ça qui concerne les collections directement. De toute façon maintenant on considère que ça fait partie des choses acquises en ce qui concerne toutes les ce qui est la vérification des exceptions donc ce n'est pas parce qu'on le rappelle pas à chaque vidéo que ça veut dire qu'il ne faut plus y penser. Assez considérer que tout ce qui a été vu avant, fait partie des acquis donc doit être mis en application à chaque fois ainsi ça doit être le réflexe dans un langage comme Java que dès qu'on travaille avec une méthode, une classe et cetera, on regarde où il peut y avoir des exceptions, regarde également la ou il peut y avoir des erreurs retournées (ce qui peut être des simples valeurs et on vérifie toujours tout ça). 

On vérifie également les codes de retour quand c'est juste une valeur qui est retournée, on met dans un bloc try catch quand on sait qu'il peut y avoir une exception qui est levée donc ça c'est un automatisme à avoir et si on ne l'a pas, on programmera de la mauvaise manière et ce n'est évidemment pas le but de ce cours.

Voilà tout ça lève des exceptions.

Après on a des méthodes qui vont plutôt retourner une valeur si par exemple la collection est vide donc ça retournera nul, on peut éventuellement vérifier ça et C'est d'ailleurs pour ça que ça n'accepte pas des valeurs nulles parce que ce sera un petit peu la confusion entre on a retourné une valeur nulle qui était contenu dans la collection ou en fait nul c'est le retour d'une méthode pour dire que je retourne null parce que la collection est vide donc je ne vais pas te demander de récupérer un élément d'une collection qui est vide !

Voilà pour ça.

On a également d'autres méthodes tel que `offerFirst()` qui va permettre d'ajouter un élément donc là c'est pareil on met un petit peu ce que l'on veut.

```java
adq.offerFirst();
```

+ Main.java
```java
import java.util.ArrayDeque;
import java.util.Iterator;

/*
    PriorityQueue   : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
    ArrayDeque      : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        ArrayDeque<Integer> adq = new ArrayDeque<Integer>();

        adq.offerFirst(14);

        Iterator it = adq.iterator();

        while(it.hasNext())
            System.out.println(it.next());
    }
}
```
```powershell
> javac Main.java
> java Main
14
```

Voilà ici on va ajouter un élément, et ça ça va retourner nul c'est à dire que ça ne va pas déclencher d'exception ce genre de méthode `offerFirst()`, on a également la même chose avec `offerLast()` qui fonctionne salon le même principe.

On a également ce qu'on avait vu tout à l'heure avec `pollFirst()` qui va simplement récupérer le dernier élément et le supprimer, et on à l'inverse avec `pollLast()`. On a également `peekFirst()` qui va afficher le premier élément et on a `peekLast()` qui va afficher le dernier élément parce qu'on peut encore une fois accepter du fait que c'est un élément d'une liste doublement chaînée, on peut passer par le début et par la fin donc les accès sont beaucoup plus pratique à ce niveau-là même si on n'a pas d'accès direct, on peut accéder directement au premier élément et au dernier élément très rapidement avec ces méthodes.

```java
adq.offerFirst();
adq.offerLast();

adq.pollFirst();
adq.pollLast();

adq.peekFirst();
adq.peekLast();
```

On peut également travailler sur des occurrences, et pareil des 2 côtés, où admettons on ajoute des éléments dans l'ordre et qu'on vire une occurrence.

+ Main.java
```java
import java.util.ArrayDeque;
import java.util.Iterator;

public class Main
{
    public static void main(String []args)
    {
        ArrayDeque<Integer> adq = new ArrayDeque<Integer>();

        adq.addLast(14);
        adq.addLast(-84);
        adq.addLast(155);
        adq.addLast(4);

        adq.removeLastOccurrence(4);

        Iterator it = adq.iterator();

        while(it.hasNext())
            System.out.println(it.next());
    }
}
```
```powershell
> javac Main.java
> java Main
14
-84
155
```

Voilà donc on retirent la dernière occurrence de 4 donc il va parcourir chaque élément, il va le rencontrer une première fois jusqu'à la dernière fois où il va le rencontrer. Il va passer par la fin en fait parce que rappelez vous que c'est une liste avec double chaînage donc automatiquement en passant par la fin, il sait que c'est la dernière occurrence parce que le début de la liste c'est le début. On parle de liste mais en fait c'est une file donc il faut faire attention même si on peut avoir le comportement d'une liste par rapport aux méthodes qui sont disponibles parce que simplement beaucoup d'interfaces, simplement que ça étend beaucoup de classes qu'on peut retrouver.

Voilà il y a plein d'autres méthodes, C'est toujours la même chose, `add`, `remove`, `size`, `capacity` et cetera donc aucune nouveauté ici.

Ensuite si vous voulez avoir un comportement comme une Pile, vous utilisez `addFirst()`, `removeFirst()` qui sont l'équivalent d'un push et d'un pop, et si vous voulez le sommet de la pile `peekFirst()` donc avec ces 3 méthodes, vous utilisez `ArrayDeque` comme une Pile, et comme ce n'est pas encore une fois thread-safe ce sera plus rapide que d'utiliser la collection stack.

La collection stack qui est par contre prévu pour travailler dans un environnement multi-thread.

:warning: Quelle est la meilleure collection pour faire une Pile en Java ? c'est Stack, qui signifie Pile, tel qu'on pourrait se dire mais en fait non ça dépend. Ça dépend de l'environnement dans lequel vous l'utilisez. **ArrayDeque n'indique pas le terme Pile, sera beaucoup plus pratique pour faire une Pile dans un environnement mono-threadé**.

Voilà attention à ce niveau là et n'hésitez pas à tester tout ça pour voir un petit peu ce que ça donne sur quelque chose d'un peuple complet.

C'est bon et donc en pas s'arrêter là, on aurait pu montrer autre chose avec la possibilité d'avoir des types un peu plus complexes mais vous voyez que je n'ai pas travaillé comme la dernière fois lorsqu'on avait fait une classe Cat où on avait une collection avec l'ajout de petits chats mais si on peut pas parce qu'il va falloir voir comment ajouter des éléments (surtout pour la file des priorités, c'est surtout là que c'est important) même si j'aurais pu ajouter des Player mais on l'a vu déjà la dernière fois avec les listes donc je ne vais pas répéter quasiment le même code où il y aura juste le nom ici qui change parrapport à ArrayList vers LinkedList comme on l'a vu.

```java
ArrayList<Cat> group = new ArrayList<Cat>();
//-->
LinkedList<Cat> group = new LinkedList<Cat>();
```

Voilà ça on le sait déjà donc il y a pas mal de répétitions à savoir sur cette séance mais c'est pour ça que j'apporte quand même les types l'essentiels qui sont vraiment importants à connaître au minimum pour qu'on puisse par la suite s'intéresser aux autres.

Après ça va être l'expérience et la pratique qu'on sera quel type utiliser selon les besoins et selon le contexte, ainsi c'est le travail à faire en tant que développeur.

Nous verrons d'autres types de collections dans les séances prochaines, on doit encore parler mais ensemble et tout ce qui est associatif donc il y aura à priori 2 séances, et à la suite de ces deux séances, on aura la séance sur les interfaces Comparable et Comparator en Java.

Ce ne sera pas d'essence très très long mais c'est vraiment très important à savoir, donc il ne faut pas passer à côté de ça en Java c'est important pour avoir ça en main pour pouvoir comparer des types complexes que vous créez dans votre programme.

À bientôt, ciao