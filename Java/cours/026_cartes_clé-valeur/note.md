# [26. Cartes (clé-valeur)](https://www.youtube.com/watch?v=l1pXrZByaAM)

> [collections-classes.md](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/Java/collections-classes.md)
> [collections-interfaces.md](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/Java/collections-interfaces.md)

+ [HashMap](#HashMap)
+ [TreeMap](#TreeMap)

Dernière séance pour faire le tour de pas mal d'interfaces et de classes de collections avec ce langage de programmation. C'est la dernière vidéo sur le sujet et on va terminer sur quelques classes qui vont travailler sur un système de cartes donc un système associatif, un couple clé valeur et on va retrouver les 2 structures internes que nous avions précédemment c'est-à-dire la structure en table de hashage donc on va avoir HashMap et une structure sous forme d'arbres qui sera TreeMap donc ce sont les 2 classes que nous allons voir aujourd'hui.

```java
/*
    HashMap :
    TreeMap :
*/
public class App
{
    public static void main(String[] args)
    {
        
    }
}
```

Voilà ça viendra compléter ce qu'on a vu déjà au niveau du cours, ce qui ne fera un bon bagage de collections à utiliser en fonction des besoins, et vous aurez également tout ce qu'il faut si vous voulez vous vous intéressez aux autres classes, ou autres interfaces, ou interface spécialisée que nous n'aurions pas vu en cours (il y en a encore un petit peu d'autres comme je vous ai dit) donc vous pouvez regarder un petit peu de ce côté-là.

Alors ici on va retrouver certaines spécificités, et on va les noter dès le début comme on a fait dans la vidéo précédente comme ça ce sera clair. Comme pour les interfaces donc les ensembles nous n'acceptons pas les doublons, ce n'est pas thread-safe (on a eu pas mal d'éléments thread-safe au début avec notamment la Pile, Stack et cetera, et après très vite on a obtenu des classes, des collections qui ne le sont pas, qui peuvent être utilisés tels quels, et après encore une fois tout ce qui est accès et concurrence, c'est autre chose mais encore une fois ici ce n'est pas multi-threadé donc on a d'autres collections pour ça si besoin). Voilà 2 éléments, 2 particularités finalement que nous avons et qui sont importantes.

```java
/*
    HashMap : pas de doublons, pas thread-safe, 
    TreeMap : pas de doublons, pas thread-safe, 
*/
```

Une autre chose qui est importante c'est l'accès direct parce qu'on va travailler sur un ensemble de clés et de valeurs donc on va pouvoir faire un accès à partir de la clé, ou éventuellement un accès à partir de la valeur donc forcément ici on aura de lecture assez rapide mais après on va avoir des particularités qu'on va retrouver entre les 2 classes ici (HashMap et TreeMap) comme la séance précédente, rappelez-vous, la table de hashage était plus rapide que l'arbre parce que l'arbre va opérer un sens de tri donc on va être en fait ordonné d'accord c'est une collection qui va être ordonné.

```java
/*
    HashMap : pas de doublons, pas thread-safe, accès direct,
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
```

Alors le HashMap ne sera pas ordonnée comme pour les éléments précédents dans les séances précédentes lorsqu'on avait vu HashSet et TreeSet c'est-à-dire que le HashMap affichera les éléments dans le désordre car son but n'est pas de trier les éléments, c'est pour ça que HashMap sera également plus rapide que TreeMap, là où l'arbre aura tout un tas d'algorithmes en interne qui vont équilibrer l'arbre et qui vont garder l'ordre naturel éventuellement des éléments ou alors bien sûr un ordre que vous avez choisi vous-même arbitrairement avec des choses que nous verrons dans les prochaines vidéos pour effectuer des comparaisons entre les différents éléments d'un type plus complexe que les types natifs donc ça il faut prendre toutes ces informations là on compte.

On en a enquête ordonnée et l'autre qui ne l'est pas, HashMap ne l'est pas donc je ne l'indique pas, très important.

Ensuite on va avoir une autre particularité au niveau des valeurs nulles c'est à dire que pour un TreeMap il n'y a pas de valeur nulle mais pour HashMap on peut accepter des valeurs nulles dont on va parler parce que c'est un cas un peu particulier.

```java
/*
    HashMap : pas de doublons, pas thread-safe, accès direct, valeurs nulles /!\
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
```

Attention aux valeurs nulles donc il va y avoir une petite particularité sur ce dernier point.

Voilà pour toutes les informations différentes de départ, et on va pouvoir commencer à regarder comment on met tout ça en place.

Alors au niveau de la syntaxe, il ne va pas y avoir grand-chose de nouveau, on va surtout essayer de voir d'autres méthodes, d'autres méthodes qu'on n'a pas forcément vu avec d'autres types de classes, d'autres implémentations d'interfaces.

## HashMap

On va commencer avec HashMap qui est le plus rapide par rapport à ce que l'on veut qui ne va pas suivre d'ordre en particulier.

On va créer une HashMap directement donc ici on aura notre fameuse interface map `Map` tel qu'on l'avait vu sur les graphiques qu'on a vu dans d'autres séances, et vous pouvez toujours vous référer à la doc si vous voulez sachant que sur internet vous trouverez des schémas complets avec toutes les interfaces, les classes et savoir comment se fait la hiérarchie au niveau héritage et implémentation, spécialisation ainsi on peut tout retrouver d'un seul coup d'œil donc ici on va directement créer une `HashMap` et dans ce cas c nous allons avoir un couple de type c'est-à-dire un type pour la clé et un type pour la valeur donc ici admettons on va prendre quelque chose de très simple c'est à dire 2 chaînes de caractères `HashMap<String, String>`.

```java
/*
    HashMap : pas de doublons, pas thread-safe, accès direct, valeurs nulles /!\
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        HashMap<String, String> hm = new HashMap<String, String>();
    }
}
```

Alors ici je ne vais pas indiquer de capacité ou de niveau de charge en paramètres, je vais laisser par défaut. Si vous vous souvenez, on en avait parlé, normalement pour la capacité de base, par défaut, c'est 16, et le niveau de charge c'est 0.70 ou 0.75 en gros le moment où la collection va être éventuellement agrandie si elle atteint 75% de sa capacité maximale. Et bien sûr ce sont des collections qui s'agrandissent en fonction des besoins, ce ne sont pas bien sûr des structures à taille fixe comme on le faisait avec les tableaux un peu plus au début de cours.

Ainsi dans les collections, on a des choses qui sont parfaitement extensibles bien évidemment c'est tout l'intérêt de leur usage.

On fait donc ça et maintenant on va ajouter différents éléments, pour ça on va utiliser une méthode qui est put() qu'on va utiliser tel quel donc c'est toujours pareil, on va appliquer la méthode sur notre collection `hm` ainsi on appelle la méthode et on va passer 2 arguments à savoir la clé et ensuite la valeur. Ici je vais utiliser des noms sous forme de chaîne parce que c'est plus pratique d'après moi.

```java
/*
    HashMap : pas de doublons, pas thread-safe, accès direct, valeurs nulles /!\
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        HashMap<String, String> hm = new HashMap<String, String>();

        hm.put("1", "Marc");
        hm.put("2", "Luc");
        hm.put("15", "Marie");
        hm.put("3", "Julie");
    }
}
```

Pour parcourir au plus simple (bien que ce soit appelle complexe) mais avant d'aborder les parcours, on a toujours les mêmes méthodes même si on ne reviendra pas dessus c'est à dire pour supprimer un élément avec remove(), la taille de la collection, le nombre d'éléments avec size() donc classique on ne reviendra pas sur les mêmes méthodes. Alors envahi c'est de voir des choses un petit peu différentes ici.

Alors maintenant va déjà pouvoir faire facilement un accès parce que rappelez-vous qu'on a marqué `accès direct` c'est-à-dire qu'on a un accès direct aux différents éléments à partir d'une valeur d'accord on va pouvoir récupérer quelque chose. Je vais donc pouvoir faire `hm.get("15")` pour récupérer la valeur en passant par la clé.

+ App.java
```java
import java.util.HashMap;
/*
    HashMap : pas de doublons, pas thread-safe, accès direct, valeurs nulles /!\
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        HashMap<String, String> hm = new HashMap<String, String>();

        hm.put("1", "Marc");
        hm.put("2", "Luc");
        hm.put("15", "Marie");
        hm.put("3", "Julie");

        System.out.println(hm.get("15"));
    }
}
```
On compile...
```powershell
> javac App.java
> java App
Marie
```

Voilà on indique ici la clé avec get() tout simplement il récupère la valeur.

Si je note la valeur "Julie".

+ App.java
```java
import java.util.HashMap;
/*
    HashMap : pas de doublons, pas thread-safe, accès direct, valeurs nulles /!\
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        HashMap<String, String> hm = new HashMap<String, String>();

        hm.put("1", "Marc");
        hm.put("2", "Luc");
        hm.put("15", "Marie");
        hm.put("3", "Julie");

        System.out.println(hm.get("Julie"));
    }
}
```
```powershell
> javac App.java
> java App
null
```

Voilà on récupère une valeur null donc il faut vraiment partir sur la clé, merci on a déclaré et à partir de là on va récupérer la valeur qui correspond.

Voilà c'est encore une fois ce qu'on appelle un système associatif, c'est pour ça que l'accès est direct donc pas de problème à ce niveau-là.

On indiquait également qu'il n'y avait pas de doublon mais en réalité on peut avoir des doublons pour les valeurs avec HashMap c'est à dire que si je mets 2 fois "Julie", ça marchera et c'est pour ça qu'ici le get() ne se fait qu'en fonction de la clé parce qu'on peut avoir des valeurs identiques.

+ App.java
```java
import java.util.HashMap;
/*
    HashMap : pas de doublons, pas thread-safe, accès direct, valeurs nulles /!\
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        HashMap<String, String> hm = new HashMap<String, String>();

        hm.put("1", "Julie");
        hm.put("2", "Luc");
        hm.put("15", "Marie");
        hm.put("3", "Julie");

        System.out.println(hm.get("1"));
    }
}
```
```powershell
> javac App.java
> java App
Julie
```

Voilà donc on va pouvoir noter qu'il n'y a pas de doublon avec HashMap sauf pour les valeurs.

```java
/*
    HashMap : pas de doublons (sauf valeur), pas thread-safe, accès direct, valeurs nulles /!\
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
```

Uniquement la valeur peut être un doublon parce que l'index, l'association se fait avec les clés d'accord c'est le couple clé valeur qui est important par contre on ne pourrait pas faire 2 fois le même index par exemple index, clé 3 et valeur "Julie".

+ App.java
```java
import java.util.HashMap;
/*
    HashMap : pas de doublons (sauf valeur), pas thread-safe, accès direct, valeurs nulles
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        HashMap<String, String> hm = new HashMap<String, String>();

        hm.put("3", "Julie");
        hm.put("2", "Luc");
        hm.put("15", "Marie");
        hm.put("3", "Julie");

        System.out.println(hm.get("1"));
    }
}
```
```powershell
> javac App.java
> java App
null
```

Voilà ici ça ne marchera pas donc on ne peut pas s'amuser à avoir 2 fois `"3", "Julie"` parce qu'on n'est pas censé avoir des éléments doublons tandis que si je fais 2 fois la même clé `3` mais avec des valeurs différentes, là on va récupérer une valeur un peu arbitraire parce qu'ils ont la même clé (mais ici ça retourne null).

+ App.java
```java
import java.util.HashMap;
/*
    HashMap : pas de doublons (sauf valeur), pas thread-safe, accès direct, valeurs nulles
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        HashMap<String, String> hm = new HashMap<String, String>();

        hm.put("3", "Julie");
        hm.put("2", "Luc");
        hm.put("15", "Marie");
        hm.put("3", "Marc");

        System.out.println(hm.get("1"));
    }
}
```
```powershell
> javac App.java
> java App
null
```

Je demande récupérer l'élément qui a la clé 3, ça n'aurait pas été sûr de toujours avoir celui que l'on veut, celui qu'on attend, donc il faut ne pas accepter des doublons à ce niveau-là sauf pour les valeurs où ça ne posera pas problème.

Attention à cela donc gardez des éléments uniques au niveau des clés et après au niveau des valeurs ça dépendra de nos besoins au niveau de notre programme.

Voilà pour la récupération d'éléments.

On peut aussi bien sûr faire des vérifications ce qui est toujours intéressant sur une collection par exemple si on a besoin de faire des recherches donc pareil avec les méthodes containsKey() et containsValue().

Ici dans mon cas c'est mieux te faire des recherches sur des valeurs donc de demander si on a par exemple une "Marie" dans la liste des personnes qu'on a ici, si c'est le cas la personne sera trouvée !

+ App.java
```java
import java.util.HashMap;
/*
    HashMap : pas de doublons (sauf valeur), pas thread-safe, accès direct, valeurs nulles
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        HashMap<String, String> hm = new HashMap<String, String>();

        hm.put("3", "Julie");
        hm.put("2", "Luc");
        hm.put("15", "Marie");
        hm.put("1", "Marc");

        if(hm.containsValue("Marie"))
            System.out.println("Trouvee !");
    }
}
```
```powershell
> javac App.java
> java App
Trouvee !
```

Voilà pas de problème à ce niveau-là, si je me cherche moi-même "Jason", inconnu au bataillon !

voilà ça fonctionne sans problème maintenant on peut travailler avec des clés, containsKey() et attention ici on doit mettre des doubles guillemets parce que la clé est également une chaîne de caractères.

+ App.java
```java
import java.util.HashMap;
/*
    HashMap : pas de doublons (sauf valeur), pas thread-safe, accès direct, valeurs nulles
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        HashMap<String, String> hm = new HashMap<String, String>();

        hm.put("3", "Julie");
        hm.put("2", "Luc");
        hm.put("15", "Marie");
        hm.put("1", "Marc");

        if(hm.containsKey("1"))
            System.out.println("Trouvee !");
    }
}
```
```powershell
> javac App.java
> java App
Trouvee !
```

Par contre si j'avais mis un Integer, je n'aurai pas besoin de mettre des doubles guillemets.

```java
import java.util.HashMap;

public class App
{
    public static void main(String[] args)
    {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        hm.put(1, "Julie");

        if(hm.containsKey(1))
            System.out.println("Trouvee !");
    }
}
```
```powershell
> javac App.java
> java App
Trouvee !
```

Voilà ça fait une petite révision avec le début du cours concernant les types de données et les variables donc je ne reviens pas dessus.

Maintenant on va passer au parcours, puis on verra TreeMap même si c'est un peu la même chose.

Pour le parcours, pas d'ordre, on ne va pas mettre les éléments dans l'ordre pour le parcours mais on va pouvoir récupérer un ensemble des éléments à parcourir, par exemple on peut utiliser une simple boucle for() et utiliser la méthode keySet() qui va retourner l'ensemble des clés sous forme d'ensembles.

+ App.java
```java
import java.util.HashMap;
/*
    HashMap : pas de doublons (sauf valeur), pas thread-safe, accès direct, valeurs nulles
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        HashMap<String, String> hm = new HashMap<String, String>();

        hm.put("3", "Julie");
        hm.put("2", "Luc");
        hm.put("15", "Marie");
        hm.put("1", "Marc");

        for(String k : hm.keySet())
            System.out.println(k);
    }
}
```
```powershell
> javac App.java
> java App
1
2
3
15
```

Voilà il récupère les différentes clés et nous les retourne dans l'ordre mais encore une fois ce n'était pas son but, on dirait qu'il a réussi à trouver un ordre par rapport au niveau des clés donc là ce n'est pas encore très dérangeant parce qu'on fait un parcours des clés mais peut être qu'en fonction du type que l'on a pour la clé, ce ne sera pas toujours ordonné mais attention :warning:  dans le cadre de HashMap, notre collection n'est pas triée et elle ne vous donne pas la garantie de trier vos éléments donc si vous avez la chance d'avoir vos éléments triés en fonction de ce que vous parcourez ne considérez pas que ça fait partie de son fonctionnement général mais pour ça on passera par les arbres qui eux vont avoir un tri.

/!\ Ce n'est pas pour rien que ce type de collection TreeMap est plus long parce que justement il y a intriquée fait pour que les éléments restent bien ordonnée donc c'est ça qui est important surtout.

Voilà on va maintenant passer à l'autre parce qu'ici il n'y a pas grand chose de plus à vous dire, après tout le reste ce sont surtout des méthodes qu'on a déjà vu qui sont parfaitement applicables avec toutes ces classes qui sont spécialisées, qui implémente certaines interfaces et qui ont des interfaces qui elle-même héritent d'interfaces plus général comme Collection que possèdent finalement toutes ces structures que l'on a vu donc on peut parfaitement utiliser leurs méthodes à chaque fois donc je ne reviendrai pas là-dessus.

## TreeMap

TreeMap, c'est le même principe sauf que cette fois on ne passe pas par une table de hashage mais par un arbre binaire, et automatiquement ici on va avoir un ordre pour nos éléments.

+ App.java
```java
import java.util.TreeMap;
/*
    HashMap : pas de doublons (sauf valeur), pas thread-safe, accès direct, valeurs nulles
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();

        tm.put(3, "Julie");
        tm.put(2, "Luc");
        tm.put(15, "Marie");
        tm.put(10, "Marc");

        System.out.println(tm.get(10));
    }
}
```
```powershell
> javac App.java
> java App
Marc
```

Voilà on a donc bien un couple d'entiers et de chaînes de caractères, on récupère bien "Marc" avec l'entier 10 donc on a à nouveau les méthodes classiques sans souci.

Alors ici c'est bien de savoir qu'on va avoir un tri, on ne peut pas avoir de doublon ça c'est important aussi. Alors je ne vous ai pas dit mais il aurait fallu parler aussi des valeurs nulles mais on verra ça après.

Alors si on veut un tri sur les valeurs, évidemment il ne faut pas avoir de valeur double puisqu'on puisse trier chaque élément donc l'unicité de chaque élément est importante.

On peut accepter par contre des valeurs nulles mais seulement pour les valeurs, par exemple, je peux ajouter une valeur null.

+ App.java
```java
import java.util.TreeMap;
/*
    HashMap : pas de doublons (sauf valeur), pas thread-safe, accès direct, valeurs nulles
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();

        tm.put(3, "Julie");
        tm.put(2, "Luc");
        tm.put(15, null);
        tm.put(10, "Marc");

        System.out.println(tm.get(10));
    }
}
```
```powershell
> javac App.java
> java App
Marc
```

Voilà on récupère bien la valeur sans problème.

Attention pour HashMap, on peut avoir de valeur null soit au niveau des clés ou soit au niveau des valeurs mais attention si vous avez une clé nulle, vous ne pourrez en avoir qu'une seule parce que n'oubliez pas que les clés sont des éléments uniques parce que pour HashMap, on peut avoir une clé qui vaut null. Et les valeurs, comme pour TreeMap, vous pouvez très bien avoir plusieurs valeurs qui sont nulles. Par exemple on peut très bien avoir une liste d'étudiants ainsi l'association clé valeur se fait entre le nom de l'étudiant et sa note.

```java
// String, float
```

Ainsi par exemple vous pouvez dire que le nom de l'étudiant départ vous l'avez vu, et comme il n'a pas encore passé l'examen, on peut très bien dire que la note n'existe pas.

```java
// String, float
// Marc, null
```

Voilà on peut mettre ça et par la suite la note seront ajoutées à chaque étudiant une fois que l'examen sera passé. On peut ainsi avoir toute notre collection avec la liste de tous les noms des étudiants mais avec des notes qui sont toutes affectées à nul parce qu'on ne les a pas encore tout simplement. On peut imaginer ça mais avec la particularité où HashMap peut avoir une seule de ces clées affectée à nulle mais après attention il faut encore en avoir l'usage, il faut que ce soit voulu et volontaire et que vous ayez besoin d'avoir une clé qui vaut nul en plein milieu de dire par exemple que dans un HashMap on a `tm.put(null, "");` voilà par exemple mais bien dans un HashMap et non dans un TreeMap parce que ça ne marcherait pas.

Alors maintenant au niveau de notre arbre ici, on va avoir un système d'entrée c'est à dire que pour gérer l'unicité des différents éléments, il ne va pas seulement se contenter de penser aux clés et aux valeurs mais de considérer tout ça comme une entrée.

```java
tm.put(3, "Julie"); // entrée
```

Voilà tout ceci sont des entrées, des enregistrements pour être précis peu importe et j'avais prévu quelque chose pour avoir ce type d'information au niveau de notre interface Map, on va donc avoir notamment Map.Entry() mais alors comment est-ce qu'on va travailler avec ça ?

On va déjà importer `import java.util.Map;` et comme on a abordé pas mal de systèmes de collection, j'essaie de changer un petit peu les systèmes d'itération à chaque vidéo parce que je sais que comme j'allais présenter pas mal de types de collection et que ça allait être pas mal répétitif, j'ai essayé de varier un petit peu les exemples et les méthodes utilisées pour ne pas avoir l'impression d'avoir revu certaines choses sur les différentes vidéos comme ça on a pu profiter d'avoir vu des choses différentes.

On va donc passer par l'interface `Map` et utiliser la méthode `Entry()` qui va indiquer comment est conçu notre entrée et nous ici ce sera en couple entier et chaîne de caractères et après notre entrée c'est toute la partie qui suit `ent : ` et donc sur quoi on va le faire ? On le fait sur notre collection `tm` et on va utiliser non pas une méthode qui va nous retourner toutes les clés mais une méthode qu'on n'a pas encore vu qui fait la même chose mais qui s'appelle values() `tm.values()` avec un S c'est important mais on va le faire sur l'ensemble des clés valeurs qui s'appelle tout simplement entrySet() `tm.entrySet()`.

+ App.java
```java
import java.util.TreeMap;
import java.util.Map;
/*
    HashMap : pas de doublons (sauf valeur), pas thread-safe, accès direct, valeurs nulles
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();

        tm.put(3, "Julie");
        tm.put(2, "Luc");
        tm.put(15, null);
        tm.put(10, "Marc");

        for(Map.Entry<Integer, String> ent : tm.entrySet())
        {
            System.out.println("Cle : " + ent.getKey() + " / Valeur : " + ent.getValue());
        }
    }
}
```

À partir de là on a accès à 2 méthodes particulières pour avoir la clé `getKey()` d'accord donc on a des accesseurs très simple, et ensuite pour avoir la valeur on a `getValue()` sans S parce que c'est une valeur et pas l'ensemble des valeurs cette fois-ci.

```powershell
> javac App.java
> java App
Cle : 1 / Valeur : null
Cle : 2 / Valeur : Luc
Cle : 3 / Valeur : Julie
Cle : 10 / Valeur : Marc
```

Voilà 1, 2, 3, 10 et donc cette fois-ci tout est trié, il c'est normal (c'est voulu cette fois-ci !). N'oubliez pas qu'en travail sera un arbre donc l'arbre est équilibré, trié et on a donc une garantie que l'ordre soit respecté. Vous avez une garantie de l'ordre dans les différents éléments en fonction de l'ordre que vous voulez adopter. Alors ici c'est normal !

C'est le même discours que précédemment, si vous voulez quelque chose de rapide où l'ordre des éléments n'a pas d'importance, utiliser une HashMap par contre si l'ordre a de l'importance même si cela implique que ce sera plus long au niveau des calculs et tout ça, utiliser TreeMap tout simplement bien sûr si vous avez besoin d'une de ces 2 collections et que vous hésitez.

Voilà l'ordre de l'importance pour la TreeMap et non pour HashMap sachant que pour le reste c'est pratiquement toutes identiques, en plus pour les 2 on a un accès direct donc c'est rapide à ce niveau-là en tout cas. Pas de doublon sauf pour les cas particuliers bien évidemment tel qu'on en parlait, pas thread-safe et cetera.

```java
/*
    HashMap : pas de doublons (sauf valeur), pas thread-safe, accès direct, valeurs nulles
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
```

Alors on avait parlé également des valeurs nulles, ce qui signifie qu'on va jusqu à une clé "null" éventuellement plusieurs valeurs "null". On peut avoir plusieurs valeurs mais une seule clé "null".

```java
/*
    HashMap : pas de doublons (sauf valeur), pas thread-safe, accès direct,
              valeurs nulles (jusqu'à une clé "null" et éventuellement plusieurs valeurs "null")
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
```

Et pour TreeMap, c'est seulement des valeurs "null" donc seulement pour les valeurs et pas les clés.

```java
/*
    HashMap : pas de doublons (sauf valeur), pas thread-safe, accès direct,
              valeurs nulles (jusqu'à une clé "null" et éventuellement plusieurs valeurs "null")
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée, données nulles (seulement les valeurs)
*/
```

Voilà on a fait le tour.

On ne va pas revenir sur les méthodes qu'on a déjà vu, on a pul() pour rajouter nos éléments, remove() pour les retirer, on a de quoi vérifier la capacité de notre collection, on a de quoi récupérer la clé, récupérer la valeur. On peut récupérer l'ensemble des clés.

Voilà on peut récupérer l'ensemble des clés, on peut récupérer une collection parce que c'est comme ça que ça fonctionne pour d'autres interfaces pour les valeurs, on peut carrément récupérer l'ensemble des entrées `entrySet()` Pour avoir le couple d'un coup et pas seulement que les clés ou que les valeurs ce qui vous donne accès, par rapport à Entry, à d'autres méthodes `getKey()` et `getValue()`.

Voilà on a pigé un peu le truc, les parcours ce classique et après l'usage de l'une ou l'autre des collections se fera en fonction de nos besoins.

On va s'arrêter là, on a terminé avec ces différentes collections même si on n'a pas trop insisté sur le multi-threadé qu'on verra sûrement en annexe dans certains tutoriel en Java si nécessaire parce que c'est quand même pour des cas particuliers mais en tout cas maintenant vous avez largement une liste, j'ai rajouté un tableau mise à jour pour avoir les différentes collections et classes que nous avons vu avec chacune leur spécificité avec un résumé de tout, et à l'usage vous verrez ce qui est le plus intéressant à utiliser pour vos besoin au niveau de votre programme.

> [collections-classes.md](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/Java/collections-classes.md)
> [collections-interfaces.md](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/Java/collections-interfaces.md)

Je vous invite également à aller voir la doc.

> [Doc de Java](https://docs.oracle.com/en/java/javase/index.html)

Voilà vous voudrez peut être d'autres classes que nous n'avons pas vu particulièrement notamment sur les Files où il y a plein d'autres éléments que nous n'avons pas vu donc n'hésitez pas à regarder parce que ça peut être encore plus pertinent peut être pour certains selon l'usage que vous aurez besoin dans votre programme.

Nous on s'arrêtera ici au niveau du cours parce qu'on en a vu bien plus que ce qui était nécessaire et pour la prochaine séance nous allons voir comment comparer, pour voir comment indiquer arbitrairement un ordre de tri, un ordre pour des types particuliers voilà des types qui ne sont pas natifs, primitifs du langage qu'on garde pour la séance 27.

Entraînez-vous, on aura la petite vidéo de transition sur Comparable & Comparator qui va suivre, et après on passe à un autre chapitre de ce cours Java avec d'autres choses très intéressantes.

Bonne soirée, ciao