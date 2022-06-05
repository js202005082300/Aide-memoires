# [27. Énumérations](https://www.youtube.com/watch?v=7cdTn1bvNJc)

+ [Introduction](#Introduction)
+ [Créer une énumération](#Créer-une-énumération)
+ [Enrichir l'énumération avec un constructeur](#Enrichir-l-énumération-avec-un-constructeur)
+ [Comparer des énumérations](#Comparer-des-énumérations)
+ [Méthodes des énumérations](#Méthodes-des-énumérations)
+ [Lister les éléments d'une énumération](#Lister-les-éléments-d-une-énumération)
+ [Conclusion](#Conclusion)

## Introduction

Une énumération permet d'avoir une liste finie d'éléments.

On va définir un type de données qui peut prendre plusieurs valeurs différentes (par exemple, définir un niveau d'erreur ou une couleur).

+ App.java
```java
public class App
{
    public static void main(String[] args)
    {

    }
}
```

## Créer une énumération

Alors en Java, une énumération est une classe.

+ Color.java
```java
public enum Color
{
    RED,
    GREEN,
    BLUE;
}
```

Ainsi une liste finie d'éléments de couleur.

On déclare une couleur de ce type avec `Color.` comme et pcq on a accède à un élément statique.

+ App.java
```java
public class App
{
    public static void main(String[] args)
    {
        Color c = Color.RED;
    }
}
```
+ Color.java
```java
public enum Color
{
    RED,
    GREEN,
    BLUE;
}
```

Nous ne sommes pas forcé d'étendre nous-même la classe Enum.

```java
public enum Color extends Enum
{}
```

`enum` étant une classe, on a tout un tas de fonctionnalités.

`enum` est une classe finale donc elle ne peut pas être étendue.

Comme on ne peut pas créer d'autres instances de celle-ci, le constructeur se privé. Lors de la déclaration de cette énumération fait appel au constructeur mais nous ne pouvons pas créer d'instance de cette classe comme on ferait un constructeur public.

## Enrichir l énumération avec un constructeur

Ici on donne plus d'indications.

+ Color.java
```java
public enum Color
{
    RED("Rouge", "FF0000"),
    GREEN("Vert", "00FF00"),
    BLUE("Bleu", "0000FF");
}
```

On va définir un constructeur pour associer les bonnes valeurs en fonction de ce qui est appelé.

Pour cela, on définit le constructeur privé d'une couleur qui va attendre deux chaînes en paramètres qu'on met dans des attributs.

+ Color.java
```java
public enum Color
{
    RED("Rouge", "FF0000"),
    GREEN("Vert", "00FF00"),
    BLUE("Bleu", "0000FF");

    private String name;
    private String hexValue;

    private Color(String name, String hexValue)
    {
        this.name = name;
        this.hexValue = hexValue;
    }
}
```

C'est comme on fait d'habitude pour une classe à part le constructeur privé et les éléments de notre énumération.

Lorsqu'on utilise `Color c = Color.RED;`, le constructeur est appelé et va bien sûr affecté les deux valeurs à nos deux attributs.

## Comparer des énumérations

Une énumération est stockée qu'une seule fois en mémoire donc pour cela qu'on ne peut pas créer de nouvelles instances et ainsi pas de problème de collision de conflit donc on va pouvoir facillement **comparer** des énumérations donc avec un simple `==` comme pour des entiers. Pas besoin de passer par d'autres méthodes pour faire de la comparaison.

+ Color.java
```java
public enum Color
{
    RED("Rouge", "FF0000"),
    GREEN("Vert", "00FF00"),
    BLUE("Bleu", "0000FF");

    private String name;
    private String hexValue;

    private Color(String name, String hexValue)
    {
        this.name = name;
        this.hexValue = hexValue;
    }
}
```
+ App.java
```java
public class App
{
    public static void main(String[] args)
    {
        Color c = Color.RED;
        Color c2 = Color.RED;

        if(c == c2)
            System.out.println("Same");
    }
}
```
```powershell
> javac App.java
> java App      
Same
```

Voilà pour la comparaison des énumérations car elle est stockée qu'une fois en mémoire, on dit que les rouges sont identiques.

## Méthodes des énumérations

Alors les énumérations héritent de la classe Object.

Une méthode pour récupérer les valeurs.

+ Color.java
```java
public enum Color
{
    RED("Rouge", "FF0000"),
    GREEN("Vert", "00FF00"),
    BLUE("Bleu", "0000FF");

    private String name;
    private String hexValue;

    private Color(String name, String hexValue)
    {
        this.name = name;
        this.hexValue = hexValue;
    }

    public String toString()
    {
        return this.name;
    }
}
```
+ App.java
```java
public class App
{
    public static void main(String[] args)
    {
        Color c = Color.RED;
        
        System.out.println(Color.valueOf("BLUE"));
        System.out.println(c);
    }
}
```
```powershell
> javac App.java
> java App
Bleu
Rouge
```

Voilà une petite méthode toString() qui permet d'extraire la valeur.

## Lister les éléments d une énumération

Chaque élément est déclaré selon un ordre d'énumération.

+ Color.java
```java
public enum Color
{
    RED("Rouge", "FF0000"), // 0
    GREEN("Vert", "00FF00"), // 1
    BLUE("Bleu", "0000FF"); // 2

    private String name;
    private String hexValue;

    private Color(String name, String hexValue)
    {
        this.name = name;
        this.hexValue = hexValue;
    }

    public String toString()
    {
        return this.name;
    }
}
```
+ App.java
```java
public class App
{
    public static void main(String[] args)
    {
        //Color c = Color.RED;
        
        System.out.println(Color.RED.ordinal());
        System.out.println(Color.RED.name());
    }
}
```
```powershell
> javac App.java
> java App
0
RED
```

Pas besoin d'écrire `Color c = Color.RED;` parce que c'est enregistré statiquement en mémoire donc on va faire appel à la méthode ordinal() pour connaître le numéro d'identification de cette valeur.

Indiquer tout ce que nous avons avec une boucle.

+ App.java
```java
public class App
{
    public static void main(String[] args)
    {
        for(Color c : Color.values())
            System.out.println(c);
    }
}
```
```powershell
> javac App.java
> java App
Rouge
Vert
Bleu
```

## Conclusion

Retenir qu'il y a une classe dérrière une énumération.

`enum` est une classe Final donc qui ne peut pas être étendue.

On peut lui indiquer un constructeur privée.

On peut lui ajouter des attributs et pour chaque valeurs, on peut spécifier des arguments `RED("Rouge", "FF0000"),` par exemple, ainsi les paramètres du constructeur...

Comme on a ceci `Color c = Color.RED;` qui est statique, on peut faire des comparaison.

Par exemple,
```java
public class App
{
    public static void main(String[] args)
    {
        c == c2
    }
}
```

En plus, on peut s'en servir dans un switch, toute structure conditionnelle.

Á bientôt