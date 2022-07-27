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

    private int color;
    public int getColor()
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
        Vegetable v = new Vegetable("Endive", Color.WHITE);
        Basket bsk = new Basket(f);
    }
}
```

8


## Générique à plusieurs types paramétrés
## Types bornés avec les génériques
## Précisions sur les génériques
## Générique pour n importe quel type d objet
## Limites de la généricité
## Conclusion