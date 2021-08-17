# [25. Ensembles](https://www.youtube.com/watch?v=lBa9_JzgBEE)

+ [HashSet](#HashSet)
+ [TreeSet](#TreeSet)

Vidéo 25 qui aborde la suite des différentes collections que j'ai souhaité aborder dans ce cours, avec cette fois-ci des collections basées sur des ensembles. Ce sera l'avant dernière vidéo sur les collections avant de passer à la dernière avec les couples clé valeur pour avoir des collections basées sur des éléments associatifs.

On va aller assez vite parce que vous avez compris qu'on se basait sur des interfaces similaires avec quelques petites distinctions suivant ce que l'on veut faire dans notre programme donc on va forcément avoir son petit peu plus vite sur ces séances qu'il reste pour les collections.

```java
public class Main
{
    public static void main(String []args)
    {

    }
}
```

On part sur un code de base, et nous allons voir 2 collections cette fois.

![Interfaces.PNG](Interfaces.PNG)

Voilà on va en à avoir cette interface `Set` donc on va aborder la classe qui en hérite, qui est la classe `HashSet` et nous allons voir une classe qui est directement implémentée `SortedSet` qui est en fait une spécialisation de cette classe Set pour avoir des éléments triés avec tous les Set.

Ainsi `HashSet` et `TreeSet` sont les 2 classes que nous allons voir qui sont finalement les 2 que nous avons ici.

![Interfaces2.PNG](Interfaces2.PNG)

Attention dans cette petite illustration disponible sur github, j'avais oublié de mettre les classes qu'on a abordées dans le cours concernant les Files.

Ainsi on va regarder HashSet et TreeSet.

On va regarder HashSet avec lequel on va retrouver différents éléments, et TreeSet qui se basera sur un arbre binaire, un arbre rouge noir, avec différents éléments parce qu'on va travailler sur des éléments triés ce qui va avoir de l'intérêt.

```java
/*
    HashSet :
    TreeSet :
*/

public class Main
{
    public static void main(String []args)
    {

    }
}
```

Alors au niveau des ensembles, ce qui est Bon à savoir c'est qu'on n'aura pas d'éléments doublons c'est à dire que dès qu'on travaille, qu'on est basé sur des ensembles, on accepte absolument pas d'éléments en double que ce soit pour les 2 cas HashSet et TreeSet.

```java
/*
    HashSet : pas de doublons,
    TreeSet : pas de doublons,
*/

public class Main
{
    public static void main(String []args)
    {

    }
}
```

Voilà de manière générale, il n'y a pas de doublons et ça c'est la règle générale de tout ce qui est basé sur Set. Voilà c'est très important, si vous ne voulez accepter de doublon, c'est une bonne idée de partir là dessus.

Alors les 2 ne sont pas thread-safe donc les éléments ne sont pas synchronisés mais si on veut des éléments synchronisés c'est à dire qu'avec d'autres classes un peu particulières on pourrait éventuellement parvenir à avoir une collection synchroniser mais ici on n'a pas de classes qui sont faites pour y travailler dans un environnement multi-threadé. Ici on n'a pas des classes pour ça.

```java
/*
    HashSet : pas de doublons, pas thread-safe, 
    TreeSet : pas de doublons, pas thread-safe, 
*/

public class Main
{
    public static void main(String []args)
    {

    }
}
```

Voilà ici la même chose il n'y a pas de distinction entre les 2.

On va avoir ensuite besoin de certains ordres dont les données donc TreeSet est ordonné, c'est comme ça qu'on reconnaît un arbre parce qu'il va y avoir une certaine logique au niveau du tri qui sera fait. On reviendra sur les interfaces qui nous permettront par la suite de comparer des éléments, c'est ce qu'on verra par la suite à l'issu des différentes collections du cours tel qu'on a dit qu'on verrait Comparator & Comparable. HashSet n'est pas ordonné.

```java
/*
    HashSet : pas de doublons, pas thread-safe, pas ordonnée
    TreeSet : pas de doublons, pas thread-safe, ordonnée
*/

public class Main
{
    public static void main(String []args)
    {

    }
}
```

Ensuite TreeSet n'a pas d'accès direct et pour HashSet on aura un accès direct avec une histoire d'accès par indice dans lequel on va travailler par des valeurs…

```java
/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct
*/

public class Main
{
    public static void main(String []args)
    {

    }
}
```

Au niveau de Set, on a directement de l'interface Set, on a HashSet et si on veut que ce soit ordonné, trié on passera sur TreeSet donc là on a beaucoup d'interfaces qui se mélangent c'est à dire qu'ici TreeSet on a une interface d'arbre d'accord puisqu'on travaille sur les arbres binaires, tandis que ici HashSet on va retrouver nos maps qu'on verra dans la prochaine vidéo.

## HashSet

Alors au niveau du code on va travailler sur quelque chose de très simple, on aura le même accès ici si on veut importer des éléments `import java.util.HashSet;`.

```java
import java.util.HashSet;

/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct
*/

public class Main
{
    public static void main(String []args)
    {
        HashSet<Integer> hs = new HashSet<Integer>();

    }
}
```

Voilà on va travailler avec une syntaxe similaire et c'est tout l'avantage d'avoir une syntaxe qui travaille avec le même interface donc on l'a vu hein l'interface Collection où on a accès à toutes les méthodes, et tout et tout toujours utilisable ici sans problème.

Comme ici on va travailler pour HashSet sur finalement une table de hashage, c'est ce qu'il y a derrière mais on verra ça par la suite lorsqu'on verra la prochaine séance.

L'avantage c'est qu'on va gagner énormément de temps puisque que ce soit pour l'ajout d'éléments, la suppression, la récupération, on aura finalement une complexité constante donc on va avoir des opérations très rapides donc si on a besoin de rapidité au niveau de notre programme on va plutôt utiliser un HashSet au lieu d'un TreeSet si notamment ne veut pas de tri qui est généralement opéré plutôt sur tout ce qui est basé sur un arbre binaire parce que on a un équilibrage qui se fait automatiquement avec des algorithmes qui tourne derrière et donc ça change complètement tout ce que nous avons ici.

Ici nous allons donc pouvoir réaliser des opérations très simples et rapides comme on savait déjà le faire lorsqu'on avait ajouté plein d'éléments.

```java
import java.util.HashSet;

/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct
*/

public class Main
{
    public static void main(String []args)
    {
        HashSet<Integer> hs = new HashSet<Integer>();

        hs.add(15);
        hs.add(-4);
        hs.add(388);

    }
}
```

Voilà ça va s'ajouter très vite sans perdre de temps avec des opérations qui ont un coût constant donc ça c'est quand même vachement pratique.

Là par contre ça peut être intéressant qu'on n'avait pas forcément vu avec d'autres collections mais c'est bien d'en parler lorsqu'on va parler de la capacité d'une collection c'est à dire du nombre d'éléments qu'elle peut avoir, et on avait vu qu'elle pouvait virtuellement jouer là-dessus c'est-à-dire qu'au niveau de la création, on peut éventuellement indiquer la capacité. Par défaut la capacité serait de 16, et donc dans tous les cas il faudrait en multiple de 2 parce que c'est plus pratique pour faire des opérations dessus donc si vous pensez que dès le départ vous risquez d'avoir plus que 16 éléments, vous pouvez déjà passer par une capacité un peu plus grande que 16 ce qui permet de prévoir ça.

Ensuite on va voir le niveau de charge, le niveau de charge c'est un nombre qui va de 0 à 1 donc c'est un flottant qui va permettre de vérifier au moment où on arrive à 75% c'est à dire quasiment la totalité de la collection qui est pleine, on va justement agrandir sa capacité donc par défaut c'est géré à cette taille-là, on peut le mettre plus petit ou plus haut, et ça permet comme ça d'optimiser éventuellement parce que souvent quand on travaille avec des collections dans un vrai programme on va travailler avec énormément de valeurs donc souvent quand on a des opérations qui sont un peu lente, des traitements qui sont un peu lents, on va aussi beaucoup jouer là-dessus pour éviter qu'il y ait des agrandissements de capacité qui soit fait de manière trop régulière c'est par exemple on a mis un taux de charge qui est trop bas ou au contraire on a prévu une taille trop grande au début dans notre collection du genre on avait mis par exemple une taille de 100 alors qu'un autre collection ne dépassera jamais les 50 éléments donc ça c'est des choses qu'on peut prévoir à l'avance et on peut s'arranger pour avoir quelque chose qui est assez propre à ce niveau là.

Voilà c'est plutôt classique, donc si on veut pouvoir régler les 2 valeurs par exemple je vais dire que je mets une capacité de 50 et je mets par exemple que le niveau de charge je veux qu'il soit à 60% donc je vais mettre 0.6

```java
        HashSet<Integer> hs = new HashSet<Integer>(50, 0.6);
```
```java
import java.util.HashSet;

/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct
*/

public class Main
{
    public static void main(String []args)
    {
        HashSet<Integer> hs = new HashSet<Integer>(50, 0.6);

        hs.add(15);
        hs.add(-4);
        hs.add(388);

    }
}
```

Voilà donc ici dès que ce sera rempli à 60%, 60% des 50 éléments, la capacité sera agrandie.

Voilà n'oubliez pas que ce sont des collections qui s'agrandissent donc ce n'est pas des tailles figées, on peut parfaitement s'adapter ensuite au nombre d'éléments qui sera ajouté en plus.

Voilà je vous ai montré rapidement mais on peut le faire comme ça.

Voilà on va donc également retrouver tous les éléments add() pour ajouter, remove() pour supprimer tel qu'on l'a déjà vu précédemment, sans problème on va pouvoir gérer toutes ces choses-là.

On aura également la possibilité de vérifier des éléments en faisant par exemple `if(hs.contains(388))` pour vérifier une valeur, du style est ce que ça contient 388.

```java
import java.util.HashSet;

/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct
*/

public class Main
{
    public static void main(String []args)
    {
        HashSet<Integer> hs = new HashSet<Integer>();

        hs.add(15);
        hs.add(-4);
        hs.add(388);

        if(hs.contains(388))
            System.out.println("oui");
    }
}
```
```powershell
> javac Main.java
> java Main.java 
oui
```

Voilà si vous voulez vérifier un élément, vous passez la valeur que vous voulez à la méthode contains() donc si vous travaillez sur une chaîne de caractères il faudra indiquer une chaîne de caractères d'accord puisque de toute façon ça prend un objet donc on peut avoir un type assez générique et ensuite vous faites la vérification de ce que vous voulez.

Alors on a toujours accès aux méthodes d'égalité pour encore comparer des éléments, on peut vider la collection, tout ça on connaît.

On peut vérifier également si la collection est vide.

Pareil il n'y a pas de grand changement par rapport à ce qu'on a vu précédemment donc ça il faut savoir c'est quand même vachement pratique.

Salle folle savoir si on veut accéder aux éléments aura quand même quelque chose d'assez rapide en fonction de ce que l'on veut ou pas, on aura un coût constant. Admettons qu'on veut retirer un élément `hs.remove(388);`.

```java
import java.util.HashSet;

/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct
*/

public class Main
{
    public static void main(String []args)
    {
        HashSet<Integer> hs = new HashSet<Integer>();

        hs.add(15);
        hs.add(-4);
        hs.add(388);

        if(hs.contains(388))
            System.out.println("oui");
        else
            System.out.println("non");
        
        hs.remove(388);

        if(hs.contains(388))
            System.out.println("oui");
        else
            System.out.println("non");
    }
}
```
```powershell
> javac Main.java
> java Main.java 
oui
non
```

Voilà donc ici en ce moment sur une table de hachage ainsi il y a tout un système d'index qui est fait donc on sait facilement retrouver les éléments, ainsi on donne des suppressions qui sont rapides et c'est là tout l'intérêt.

Ici évidemment on n'a plus de oui parce que on a retiré l'élément.

Alors ici je passe assez vite parce que c'est du code qu'on va retrouver assez régulièrement est-ce que encore une fois on va appliquer encore la même chose, et c'est vraiment quand vous en aurez besoin de ce type de collection précisément que vous pousserez un peu plus loin parce que le but de la vidéo ce n'est pas encore une fois de tout énumérer ce qui aurait aucun sens mais c'est plus parmi toute cette liste de classe, d'interface où les gens peuvent se perdre surtout quand il débutes Eh bien en sortir quelques unes et d'aller se pencher sur celle qui nous semble le plus intéressantes parce qu'elle peut servir à faire telle ou telle chose et après encore une fois vous aurez comme ça un petit groupe de classes qui sont utilisables, ou même d'interface parce qu'on peut travailler avec des interfaces au niveau des programmes que l'on fait en Java c'est avec l'expérience que vous serez de mieux en mieux choisir quelles sont les bonnes collections à adopter en fonction des données avec lequel vous voulez travailler.

Ca malheureusement je ne pourrais pas vous apprendre, c'est quelque chose que vous apprendrez en pratiquant, par l'expérience et la pratique.

> TreeSet

Alors nous allons passer assez vite sur TreeSet car je vais revenir sur HashSet.

Il faut savoir que tout ce que vous allez implémenter dans une collection Set que ce soit HashSet ou TreeSet vont devoir ré implémenter les méthodes equals() et hashCode(), pourquoi ? Tout simplement parce que la vérification va se faire de cette manière, comme on ne veux pas de doublon tel que je vous l'avais expliqué, pour vérifier l'unicité d'un élément : on va vérifier le hashCode qui a plus ou moins un code que l'on veut obtenir et qui est un peu l'identifiant de l'information, par exemple.

```java
hs.add(15); // hashCode 1234
hs.add(-4);
hs.add(388);
```

Ainsi automatiquement dès qu'on va vouloir rajouter une information.

```java
import java.util.HashSet;

/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct
*/

public class Main
{
    public static void main(String []args)
    {
        HashSet<Integer> hs = new HashSet<Integer>();

        hs.add(15);
        hs.add(-4);
        hs.add(388);

        if(hs.contains(388))
            System.out.println("oui");
        
        hs.add(-4);

        for(Integer nb : hs)
            System.out.println(nb);
    }
}
```
```powershell
> javac Main.java
> java Main.java   
oui
-4 
388
15 
```

Alors voilà ici on n'a pas d'erreur où d'exception qui peuvent être signalés par contre si on regarde au niveau de l'affichage des différents éléments, on constate que le `-4` que j'ai voulu ajouter après n'a pas été fait, ça a été en fait une opération ici complètement ignorée.

L'avantage c'est aussi ça c'est que on a un coût constant donc automatiquement on va vérifier les hashCode, voir si on n'a pas le hashCode qui existerait déjà dans notre collection. Si c'est le cas, on ne se pose pas la question, on ignore complètement l'opération et on n'ajoute pas l'élément, et éventuellement peut aussi tester les égalités donc on va travailler avec 2 méthodes c'est à dire la méthode hashCode() qu'on retrouve un petit peu à toutes les sauces dans Java, et la méthode de comparaison equals().

Si on travaille avec des entiers et des chaînes de caractères en Java, ce sont des types qui sont déjà intégrés au langage donc ils ont déjà toute leur implémentation donc on va parfaitement pouvoir gérer tout ça mais admettons maintenant qu'on revienne avec l'exemple de tout à l'heure donc Player, je travaille avec des éléments Player et que maintenant je me mets à faire une table hashage de joueurs…

```java
        HashSet<Player> hs = new HashSet<Player>();
```

… Il faudra que dans notre classe, on est réécrit, surchargé ces 2 méthodes :

```java
/*
    HashSet
    ============
    hashCode()
    equals()

    Player
*/
```

Voilà il faudra que ces méthodes soient ré implémenter donc en fait calculer le hashCode pour un joueur `hashCode()` puis enfin comment vont être vérifié l'égalité entre 2 joueurs `equals()` donc ça c'est quelque chose qu'il faudra ré implémenter parce que votre machine ne sait pas par défaut ce qu'est un joueur quand vous créez ce type d'information, ce type de données.

Voilà ça paraît logique parce que encore une fois il faut vérifier les doublons pour interdire l'ajout de doublons dans la collection, c'est très important donc tout ce qui est à base de Set donc d'ensemble ne doit pas accepter de doublons ce qui est la première chose à savoir concernant ce type de collection. Une fois que vous avez compris ça vous avez compris la majorité des choses.

## TreeSet

Voilà nous allons pouvoir passer à une autre partie intéressante qui va nous accompagner lors de la prochaine séance aussi, tout ce qui se base notamment sur les arbres binaires, les arbres black red, red black que vous pouvez recherchez et vous verrez qu'il y a tout un exemple d'algorithmes important sur ces types d'arbres binaires pour pouvoir faire des équilibrages et tout ça, dérotation pour que ce soit bien équilibré, optimiser les parcours, les recherches et cetera.

On va travailler là dessus sur lequel va reposer TreeSet qui reste également un système d'ensemble mais non pas cette fois basée sur une table de hashage mais basée justement sur notre arbre.

Ici il n'y aura pas d'accès direct `hs.add();`, c'est pour ça qu'on n'aura pas de coût constant sur l'ajout et cetera, ce ne sera pas comme ici.

On va déjà emporter notre arbre binaire. 

Voilà donc ici l'avantage c'est qu'en changeant juste un mot, et en laissant le code tel quel, on est bon !

```java
import java.util.TreeSet;

/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct

    HashSet
    ============
    hashCode()
    equals()

    TreeSet
    ============
*/

public class Main
{
    public static void main(String []args)
    {
        TreeSet<Integer> hs = new TreeSet<Integer>();

        hs.add(15);
        hs.add(-4);
        hs.add(388);

        if(hs.contains(388))
            System.out.println("oui");
        
        hs.add(-4);

        for(Integer nb : hs)
            System.out.println(nb);
    }
}
```
```powershell
> javac Main.java
> java Main.java 
oui
-4 
15 
388
```

Voilà on a juste changé le type, en changeant juste un nom, et vous voyez que add() et contains() fonctionne aussi parce que c'est basé sur Set donc pas de problème, puisqu'ils utilisent la même interface donc pas de souci.

Dans ce cas-ci l'élément en plus `-4` n'a également pas été ajouté donc il y a toujours cette histoire.

Alors ici ça va être différent parce que autant pour hashSet(), on va avoir besoin de Ré implémenter equals() et hashCode() mais pour TreeSet puisqu'il ne s'agit pas d'éléments accès direct, puisqu'on travaille sur des arbres, il va falloir utiliser les méthodes compare() et compareTo() c'est à dire celle que nous verrons justement avec les différentes interfaces à l'issue de ces quelques vidéos avec les collections donc il faudra ré implémenter tout ça. C'est toujours le même principe donc si vous avez des joueurs, si vous avez une autre classe que vous avez créé, vous devez ré implémenter ces 2 méthodes compare() et compareTo() qui vont permettre justement de vérifier ce qu'il faut pour ne pas ajouter des éléments en double dans votre ici TreeSet donc ça c'est important.

```java
/*
    TreeSet
    ============
    compare()
    compareTo()
*/
```

Alors là la différence justement c'est que les éléments sont triés :

-4 
15 
388

c'est-à-dire qu'on va avoir des algorithmes qui vont tourner derrière, qui sont faits au fur et à mesure des opérations pour garder les éléments triés donc là ça va suivre un ordre naturel que les algorithmes savent très bien faire, trier des entiers, ça ne pose pas un problème mais ce sera fait.

Alors vous devez comprendre pourquoi parce que quand on va travailler notamment sur des joueurs, tu seras à vous en tant que développeur de dire comment est-ce qu'on trie des joueurs donc on utilise en informatique ce qu'on appelle des éléments discriminants pour dire qu'un joueur est plus petit ou inférieur à un autre pas dans le sens il est moins intéressant à un autre bien évidemment mais plus dans le sens qu'on va avoir des éléments qu'on va choisir arbitrairement, des propriétés d'un objet donc d'une classe joueur qui permettront d'effectuer un tri parce que si on doit avoir ici une collection triée (c'est le but de TreeSet, un ensemble sans élément doublon), c'est à vous d'indiquer arbitrairement quelle règle doit suivre les joueurs pour pouvoir être triées et dire dans quel ordre on doit les mettre, ça peut être par exemple selon leur niveau si on parle de joueur dans un jeu, par rapport aux classes, par rapport au nom voilà ça peut être trié sur plusieurs éléments aussi.

Voilà pourquoi TreeSet sera beaucoup plus long, au niveau des opérations, par rapport à un HashSet. Vous comprenez que derrière on travaille avec un arbre binaire, c'est quelque chose qui est assez lourd en termes de structure de données, on va avoir des rotations qui vont être faites pour pouvoir équilibrer cet arbre et on va faire en sorte que tout soit trié donc forcément il y a beaucoup plus d'opérations même si le code ne change pas beaucoup (on a changé qu'un seul mot) c'est à dire qu'on ne change que le type au niveau du code. Il se passe beaucoup plus de choses derrière au niveau des algorithmes qui sont exécutés par Java, donc la machine, contrairement à HashSet où on avait beaucoup d'accès direct donc on gagne énormément de temps.

Forcément si quelqu'un ne veut pas d'éléments triés, d'éléments ordonnés sur un ordre de tri aura tout intérêt à utiliser HashSet. Si vous êtes en train d'utiliser du TreeSet alors que vous voulez ajouter plein d'éléments, en supprimer, accéder à des éléments, et que vous vous fichez du tri, vous avez malheureusement choisi la mauvaise classe de collection pour votre programme.

Tout ça encore une fois l'expérience vous l'apprendra, la pratique vous la prendra et vous vous rendrez compte très vite qu'en travaillant sur des grosses collections, vous verrez des temps d'exécution très très très différents.

Des fois le simple changement d'un type de collection peut faire gagner plusieurs dizaines de secondes dans l'exécution d'un programme. Là pour le coup on ne parle pas de gagner 0,02 secondes mais non parce que quand au travail sur du tri, quand on travail sur du parcours d'éléments, sur de la recherche, ça peut se jouer en plusieurs dizaines de secondes si vous utilisez finalement les mauvais types donc tout ça il faut vraiment l'apprendre et ça va vous permettre de vous familiariser avec ces différentes choses là.

TreeSet dont le tri est très important, et on va devoir encore une fois ré implémenter compare() et compareTo() si on travaille avec des types de données un peu particulières.

Voilà on a fait le tour sur tout ça.

Pour rappel, je tiens à dire que HashSet ne garantit pas d'ordre d'accord ça peut même changer parce que comment va se baser sur du hashCode, sur des index, sur des éléments associatifs puisqu'on a une table de hashage forcément en fonction des nouveaux éléments que vous allez ajouter, retirer et tout ça et bien à l'ordre qui sera affiché si vous parcourez la totalité de la collection peux changer ! Évidemment donc il y a aucune garantie au niveau de l'ordre, là où TreeSet va ordonner les éléments, les trier suivant ce qu'il est capable de faire donc ça à priori `-4` restera toujours un nombre entier inférieur à `15`, et `15` restera toujours à priori inférieur à `388`. Voilà ça ne risque pas de changer donc bien attention à tout ça, et c'est ça aussi que suivant l'usage que l'on veut, on va plutôt pencher sur tel ou tel type de données donc c'est à vous de le savoir et de prendre tout ça en compte.

On va pouvoir aussi maintenant récupérer différents éléments, l'avantage c'est qu'on va pouvoir travailler avec pas mal de choses par exemple en faisant ceci `System.out.println(hs.first());`

```java
import java.util.TreeSet;

/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct

    HashSet
    ============
    hashCode()
    equals()

    TreeSet
    ============
    compare()
    compareTo()
*/

public class Main
{
    public static void main(String []args)
    {
        TreeSet<Integer> hs = new TreeSet<Integer>();

        hs.add(15);
        hs.add(-4);
        hs.add(388);

        System.out.println(hs.first());
        System.out.println(hs.last());
    }
}
```
```powershell
> javac Main.java
> java Main.java 
-4
388
```

Voilà on a plusieurs accès comme ça first(), last() et encore une fois c'est pareil si vous avez besoin de faire ce genre d'opération HashSet sera plus optimisé.

```java
        HashSet<Integer> hs = new HashSet<Integer>();
```

Alors ici je ne change pas le titre parce que c'est la même chose, je pourrais changer par HashSet et ça représente bien notre avantage d'avoir quelque chose qui implémente des interfaces c'est que au final on peut retrouver toutes les méthodes identiques grâce au polymorphisme bien évidemment les bonnes méthodes seront appelées.

D'ailleurs j'aurais pu faire ça comme ça pour dire que ça part vraiment de cette interface là.

```java
        Set hs = new HashSet<Integer>();
```

Voir même plutôt de SortedSet parce qu'on part plutôt de celle-ci pour TreeSet donc pas de problème.

```java
        SortedSet hs = new TreeSet<Integer>();
```
*(Erreur de compilation avec Set ou SortedSet)*

Voilà on a d'autres méthodes, on a bien sûr first(), last() qu'on connaît bien. On pourrait également récupérer un sous ensemble, on peut récupérer un sous-ensemble d'éléments avec la méthode headSet().


```java
import java.util.TreeSet;

/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct

    HashSet
    ============
    hashCode()
    equals()

    TreeSet
    ============
    compare()
    compareTo()
*/

public class Main
{
    public static void main(String []args)
    {
        TreeSet<Integer> hs = new TreeSet<Integer>();

        hs.add(15);
        hs.add(-4);
        hs.add(388);
        hs.add(1);
        hs.add(-1);
        hs.add(155);
        hs.add(-4220);

        System.out.println(hs.headSet(1));
    }
}
```
```powershell
> javac Main.java
> java Main.java 
[-4220, -4, -1]
```

Voilà comme nous travaillons avec des ensembles, on peut faire de l'extraction c'est à dire que dans l'ensemble on peut extraire des sous-ensemble donc ici headSet() signifie qu'on part de la tête donc on part finalement du début de notre arbre et rappelez-vous qu'ici ils sont triés (TreeSet) et on va s'arrêter finalement à l'élément indiqué en paramètre `(1)` donc finalement cet élément sera exclu.

```java
/*
    from A (inclus) to B (exclu)
*/
```

Ainsi quand on prend une fourchette de valeurs (from A to B) ça signifie que A est inclus tel qu'on le fait beaucoup en mathématiques tandis que le max B est exclue.

Voilà ça suit cette règle là donc ici il suffit de prendre toute la tête de l'ensemble jusqu à la valeur 1 mais exclu, `headSet(1)`.

C'est pour ça que si on prend toute notre valeur qu'on a ici dans l'ensemble `[-4220, -4, -1]` avec 1, non repris.

Voilà on a bien récupéré cet ensemble là.

Si maintenant je fais l'inverse avec la queue, `tailSel()`.

```java
import java.util.TreeSet;

/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct

    HashSet
    ============
    hashCode()
    equals()

    TreeSet
    ============
    compare()
    compareTo()
*/

public class Main
{
    public static void main(String []args)
    {
        TreeSet<Integer> hs = new TreeSet<Integer>();

        hs.add(15);
        hs.add(-4);
        hs.add(388);
        hs.add(1);
        hs.add(-1);
        hs.add(155);
        hs.add(-4220);

        System.out.println(hs.tailSet(1));
    }
}
```
```powershell
> javac Main.java
> java Main.java 
[1, 15, 155, 388]
```

Voilà on récupère l'inverse.

Ici on part de 1, comme je vous ai dit lorsque ça part de quelque part, c'est inclus donc automatiquement le 1 est noté.

Voilà on peut faire ce genre de chose là.

Après on peut faire l'inverse c'est à dire le fameux sous ensemble, d'une valeur A à une valeur B, la méthode s'appelle `subSet()`.

```java
import java.util.TreeSet;

/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct

    HashSet
    ============
    hashCode()
    equals()

    TreeSet
    ============
    compare()
    compareTo()
*/

public class Main
{
    public static void main(String []args)
    {
        TreeSet<Integer> hs = new TreeSet<Integer>();

        hs.add(15);
        hs.add(-4);
        hs.add(388);
        hs.add(1);
        hs.add(-1);
        hs.add(155);
        hs.add(-4220);

        System.out.println(hs.subSet(-4, 388));
    }
}
```
```powershell
> javac Main.java
> java Main.java 
[-4, -1, 1, 15, 155]
```

Voilà donc on a `[-4, -1, 1, 15, 155]` avec la valeur 388 qui est exclu donc le premier paramètres a été inclus dans mon ensemble qu'on a extrait tandis que le 388 a été exclu donc on s'est arrêté juste avant.

Voilà ça c'est plein d'opérations que l'on peut faire que l'on peut faire sur HashSet et TreeSet, encore une fois sur les ensembles d'accord c'est tout ce qui est basé sur SortedSet et Set donc on peut travailler sur tout ça donc n'hésitez pas.

Comme TreeSet implémente l'interface SortedSet, on peut parfaitement travailler là-dessus sans aucun problème donc ça il faut pas il faut s'en servir.

Voilà nous avons fait le tour, encore une fois tout ce qu'on a vu sur les itérateurs et pleins d'autres méthodes qui sont directement implémentées par l'interface Collection, que l'on retrouve dans l'interface Collection, n'hésitez pas à les tester et c'est l'avantage avec ce type de séance, ce qu'il y a plein de choses qui se réunissent ensemble, qui travaille un petit peu avec les mêmes interfaces donc je suis loin à chaque fois de vous montrer ce qu'on a vu sur chaque type de collection donc à vous de le tester de votre côté pour voir mais ici vous voyez quelques petites spécificités supplémentaires en fonction.

Alors pour rappel, pour HashSet on va devoir implémenter hashCode() et equals() si on travaille avec des types particuliers tandis que si on est avec TreeSet, si on travaille avec un type de données particulier, on devra ré implémenter cette méthode compare() et cette méthode-çi compareTo().

```java
/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct

    HashSet
    ============
    hashCode()
    equals()

    TreeSet
    ============
    compare()
    compareTo()
*/
```

Voilà de toute façon ça on va le revoir dans le cours, je vous avais dit que j'avais prévu une vidéo dédiée à ceux-là et on peut faire pas mal de petites choses avec ces méthodes là donc on verra tout ça ensemble.

Voilà on a fait le tour.

Pour la prochaine séance on verra tout ce qui est associatif, on va reprendre un peu ce système parce que vous allez voir qu'on va travailler sur `HashMap` donc une map mais basée sur une table de hashage, et également `TreeMap` donc encore avec l'idée d'arbre binaire avec ces éléments triés basé sur une SortedMap donc on retrouve encore une fois ce même couple de classe que l'on peut utiliser avec autre chose derrière parce qu'on se base sur Map mais en même temps soit on a sur une table de hashage derrière soit on est sur un arbre binaire donc on va retrouver pas mal d'opérations, un peu les mêmes règles que l'on vient de voir.

Finalement on ira assez vite pour la prochaine séance, et ensuite, enfin on aura terminé de faire le tour de ses différentes collections et on verra enfin ces différentes méthodes compare() et compareTo(), compare & comparable, toutes ces interfaces et on va regarder cela plus en détail puisqu'on en parle depuis un petit moment. Forcément arrivé au bout d'un certain moment du cours de la formation, vous avez peut être envie de savoir comment ça se implémentait ça se met en place et à quoi ça sert finalement en programmation ici en Java.

Voilà je vous dis à bientôt, ciao