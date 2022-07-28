# [29. Généricité](https://www.youtube.com/watch?v=QWn_KHeUKfA)

+ [Introduction](#Introduction)
+ [Qu'est-ce que la généricité ?](#Qu-est-ce-que-la-généricité)
+ [Code de départ](#Code-de-départ)
+ [Création d'une classe générique](#Création-d-une-classe-générique)
+ [Utilisation de la classe générique](#Utilisation-de-la-classe-générique)
+ [Générique à plusieurs types paramétrés](#Générique-à-plusieurs-types-paramétrés)
+ [Types bornés avec les génériques](#Types-bornés-avec-les-génériques)
+ [Précisions sur les génériques](#Précisions-sur-les-génériques)
+ [Générique pour n'importe quel type d'objet](#Générique-pour-n-importe-quel-type-d-objet)
+ [Limites de la généricité](#Limites-de-la-généricité)
+ [Conclusion](#Conclusion)

>

## Introduction

La généricité c'est la manière de pouvoir créer des types et des méthodes génériques (notions déjà abordés lorsqu'on a vu les collections).

Ici nous remplissons une liste de type `String` entre chevrons à l'intérieur de l'opérateur diamant `<>`.

A partir de cette même classe, on la possibilité de créer une liste pour contenir autre chose en remplacant `<String>` par autre chose (ça pourrait être des entiers avec le type `Integer` au lieu de int ou tout autre classe créé dans notre programme).

On avait abordé tout cela dans le châpitre sur les collections.

+ App.java
```java
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        List<String> characters = new ArrayList<>();

        characters.add("Heizou");
        characters.add("Amber");
        characters.add("Zhongli");
        characters.add("Velan");
        characters.add("Raiden");

        for(String name : characters)
            System.out.println(name + " est prêt !");
    }
}
```
+ Fruit.java (une classe pour représenter des fruits avec deux accesseurs et deux constructeurs)
```java
public class Fruit
{
    private String name;
    public String getName()
    {
        return this.name;
    }

    private int quantity;
    public int getQuantity()
    {
        return this.quantity;
    }

    public Fruit(String name)
    {
        this.name = name;
        this.quantity = 1;
    }

    public Fruit(String name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }
}
```
+ Vegetable.java (une autre classe pour représenter des légumes avec deux accesseur, un constructeur et la méthode toString)
```java
public class Vegetable
{
    private String name;
    public String getName()
    {
        return this.name;
    }

    private Color color;
    public Color getColor()
    {
        return this.color;
    }

    public Vegetable(String name, Color color)
    {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString()
    {
        return this.name + " de couleur : " + this.getColor();
    }
}
```
+ Color.java (une énumuration pour les couleurs qui vont notamment servir pour les légumes)
```java
public enum Color
{
    GREEN("Vert"), RED("Rouge"), WHITE("Noir");

    private String name;

    private Color(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return this.name;
    }
}
```

Alors la généricité permet notament de rendre le code plus sécurisé.

## Qu est ce que la généricité
## Code de départ
## Création d une classe générique

Par la suite, je veux créer une classe qui va permettre de créer un panier et ce panier pourra contenir des fruits, des légumes et voir d'autres classes à l'avenir.

Pour cela, nous allons créer notre classe qui va représenter le panier et on la rendre générique.

On crée un nouveau fichier pour représenter notre classe de panier, nommé Basket.java

+ Basket.java
```java
public class Basket
{
    private Fruit item;
    public Fruit getItem()
    {
        return this.item;
    }

    public Basket(Fruit f)
    {
        this.item = f;
    }
}
```
+ App.java
```java
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        Fruit f = new Fruit("Cerise", 15);
        Basket bsk = new Basket(f);
    }
}
```

## Utilisation de la classe générique

Alors pour utiliser cette classe pour cette fois-çi faire un panier de légume, j'aurais été obligé de faire une autre classe ou de faire appel à de l'héritage bref pas pratique.

L'intérêt est de rendre la class Basket générique pour changer son comportement.

On va utiliser l'opérateur diamant `<>` et on indique l'élément que l'on veut, par convention, avec un `T` majuscule ou un `E` mais selon les langages de programmation comme lorsqu'on travaillait sur les cartes au niveau des collections avec *K* pour les clefs et *V* pour leur valeur.

+ Basket.java
```java
public class Basket<E>
{
    private E item;
    public E getItem()
    {
        return this.item;
    }

    public Basket(E item)
    {
        this.item = item;
    }
}
```

Voilà on ne fait plus un panier de `Fruit` mais de cet élément `E` donc on définit un élément mais on ne sait pas trop quel est ce type. On ne fait plus un panier de Fruit mais un panier de cet élément E. Nous allons préciser ce type durant l'instanciation.

Voilà pour notre classe générique.

L'intérêt est de pouvoir créer des panier de quelque chose.

Ici on crée notre panier de fruit et sachez qu'une fois que c'est compilé 

+ App.java
```java
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        Fruit f = new Fruit("Cerise", 15);
        Basket<Fruit> bskf = new Basket(f);
        System.out.println(bskf.getItem().getName());

        Vegetable v = new Vegetable("Endive", Color.WHITE);
        Basket<Vegetable> bskv = new Basket(v);
        System.out.println(bskv.getItem().getName());
    }
}
```
```ps1
> javac *.java
Note: App.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
> java App
Cerise
Endive
```

Voilà on a un simplement un avertissement qui n'empêche pas la compilation.

Entre chevron, on passe le type du panier de fruit : `Basket<Fruit>`.

Une fois que le code est compilé par la machine virtuelle de Java, il n'y a plus de trace de généricité.

Pour améliorer le concept du panier Basket.java, placer une liste à la place de `private E item;`, une liste qui fera office de panier pour y insérer les différents éléments. Le panier pourrait être une liste au niveau de ses attributs.

Créons maintenant une classe Drink.java

+ Drink.java
```java
public class Drink
{
    private String name;
    public String getName()
    {
        return this.name;
    }

    public Drink(String name)
    {
        this.name = name;
    }
}
```
+ App.java
```java
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        Drink dr = new Drink("Eau gazeuze");

        Basket<Drink> bdr = new Basket(dr);
        System.out.println(bdr.getItem().getName());
    }
}
```
```ps1
> javac *.java
Note: App.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
> java App    
Eau gazeuze
```


## Générique à plusieurs types paramétrés

On peut placer plusieurs paramètres au niveau de notre constructeur `public class Basket<E1, E2>` donc créer un attribut E1 `private E item;` puis un attribut E2.

+ Basket.java
```java
public class Basket<E1, E2>
{
    // private E item;
    // public E getItem()
    // {
    //     return this.item;
    // }

    public Basket(E1 item, E2 item2)
    {
        // this.item = item;
    }
}
```

E1 et E2 sont des types qui seront spécifiés après entre chevrons `Basket<Drink> bdr = new Basket(dr);`

Voir la doc [Interface List<E>](https://docs.oracle.com/javase/7/docs/api/java/util/List.html) car on peut faire de la généricité avec les interface et par convention la lettre E pour les éléments. On peut avoir une liste de chaînes de caractères, de personnes, d'entiers, et cetera.

## Types bornés avec les génériques

On peut trouver ce type de syntaxe-là `addAll(Collection<? extends E> c)` donc avec `?` qui est un wildcard pour indiquer 'tout élément' donc n'importe quel élément et avec le `extends` il indique n'importe quel élément de type E ou une de ses sous-classes parce que extends signifie une extension de classe donc de l'héritage donc toute classe de ce type `E` ou une sous-classe de celle-ci peut être ajouté via cette méthode addAll().

``super` signifie dans `sort(Comparator<? super E> c)` qu'on récupère tout élément de cette classe ou un élément parent.

On pourrait décider de dire que Basket n'accepte que des éléments de Vegetable et tout ce qui l'étend : `public class Basket<? extends Vegetable>` càd tout ce qui est de la classe Vegetable ou tout ce qui l'étend, une sous-classe.

Voilà avec la généricité, on peut travailler avec les différentes bornes.

## Précisions sur les génériques

Attention si la classe B dérive de la classe A, avec la généricité les éléments sont indépendant, on ne peut pas retrouver cet héritage. Il faut distinguer un type de paramètre avec cette notion de généricité.

```java
/*
    A ---> B
    List<A> ---> List<B>
*/
```

Ainsi quand la compilation est faite, il n'y a plus de trace de cette généricité qui est remplacé partout, le `<E>` est remplacé au niveau de notre code.

## Générique pour n importe quel type d objet

Pour afficher l'ensemble de mes liste, de fruits, et de légumes.

+ Vegetable.java
```java
// On enlève la couleur pour le test car on en a pas besoin

public class Vegetable
{
    private String name;
    public String getName()
    {
        return this.name;
    }

    private Color color;
    public Color getColor()
    {
        return this.color;
    }

    public Vegetable(String name)
    {
        this.name = name;
        this.color = color.GREEN; // this.color = color;
    }

    @Override
    public String toString()
    {
        return this.name + " de couleur : " + this.getColor();
    }
}
```
+ App.java
```java
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void printList(List<?> li)
    {
        for(Object o : li)
            System.out.println("> " + o);
    }
    
    public static void main(String[] args)
    {
        Fruit f1 = new Fruit("Cerise");
        Fruit f2 = new Fruit("Myrtille");
        Fruit f3 = new Fruit("Banane");

        List<Fruit> lf = new ArrayList<>();
        lf.add(f1);
        lf.add(f2);
        lf.add(f3);

        //-------------------------------------------------------------

        Vegetable v1 = new Vegetable("Choux");
        Vegetable v2 = new Vegetable("Endive");
        Vegetable v3 = new Vegetable("Poireau");

        List<Vegetable> lv = new ArrayList<>();
        lv.add(v1);
        lv.add(v2);
        lv.add(v3);

        printList(lf);
        printList(lv);
    }
}
```
```ps1
Console> javac *.java
Console> java App
> Fruit@6b884d57
> Fruit@38af3868
> Fruit@77459877
> Choux de couleur : Vert
> Endive de couleur : Vert 
> Poireau de couleur : Vert
```

On utilise le fameux opérateur wildcard `?` pour indiquer les élément de tout `public static void printList(List<?> li)`

On affiche bien les instances de chaque Fruit, les objet, puis pour les légumes on affiche ce que j'ai redéfinit pour toString().

Voilà on peut utiliser la généricité pour afficher nos éléments.

## Limites de la généricité

La généricité est source d'erreur parce que cela opère au niveau de la compilation et passer la compilation il n'y a plus de généricité.

Par exemple, ce qui fonctionne sans généricité ne fonctionnerons pas avec la généricité, on ne peut pas le faire avec les type primitif comme on le ferait avec les liste :

```java
List<int> lf = new ArrayList<>(); // ne fonctionne pas
// List<Fruit> lf = new ArrayList<>();
List<Integer> lf = new ArrayList<>(); // fonctionne avec l'équivalent de int
```

On ne peut pas faire non plus d'exception avec un typage générique, ça ne fonctionne pas non plus.

On ne peut pas avoir d'attribut statique qui serait générique parce que ceci va être opéré au niveau de la compilation donc ca ne peut pas marcher.

```java
private E item // Oui on peut
private static E item // Non on ne peut pas
```

On aura pas non plus de support pour les sous-types càd que si on a une relation d'héritage entre A et B, on a pas de relation d'héritage entre une liste d'élément A et une liste d'élément B car l'héritage ne fonctionne pas.

## Conclusion

On risque d'avoir des erreurs au début avec la généricité alors qu'avec du code classique ça aurait fonctionné lorsqu'on va essayer de rendre le code générique.

La généricité est utilisé notamment dans les collections et ça grâce à ça qu'on a pu utiliser les listes, des wildcards et cetera de pleins de types différents à chaque fois dans les séances précédentes.

On pourrait avoir pleins d'exemples losrqu'on applique la généricité dans un code classique.

Ciao

