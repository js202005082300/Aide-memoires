# [Annotations](https://www.youtube.com/watch?v=cno_XpZB8To)

+ [Override](#Override)
+ [Deprecated](#Deprecated)
+ [Documented](#Documented)
+ [unchecked deprecation removal preview](#unchecked-deprecation-removal-preview)
+ [FunctionalInterface](#FunctionalInterface)
+ [SafeVarargs](#SafeVarargs)

Ajouter des informations qui vont servir lors de la compilation.

Exemple concernant l'héritage. Un dragon est une Creature, ce qui fait la relation de l'héritage.

## Override

`Dragon d = new Dragon();` permet d'appeler plus loin la méthode fly() de Dragon au lieu de Creature donc on indique que la méthode fly() est surchargée `@override` pour éviter d'aller chercher une méthode d'une classe parente. On lui indique simplement que c'est la méthode surchargée.

+ App.java
```java
public class App
{
    public static void main(String[] args)
    {
        Dragon d = new Dragon(); // idem à Creature d = new Dragon();
        d.fly();
    }
}
```
+ Creature.java
```java
public class Creature
{
    public void fly()
    {
        System.out.println("Je vole, ou pas...");
    }
}
```
+ Dragon.java
```java
public class Dragon extends Creature
{
    @Override
    public void fly()
    {
        System.out.println("J'ai des ailes, je vole !");
    }
}
```
```Powershell
> javac *.java
> java App
J'ai des ailes, je vole !
```

La bonne méthode est appelée !

## Deprecated

Indiquer à la compilation qu'une fonctionnalité est obsolète.

+ App.java
```java
public class App
{
    public static void main(String[] args)
    {
        Dragon d = new Dragon(); // idem à Creature d = new Dragon();
        d.attack();
    }
}
```
+ Creature.java
```java
public class Creature
{
    public void fly()
    {
        System.out.println("Je vole, ou pas...");
    }

    @Deprecated
    public void attack()
    {
        System.out.println("...");
    }
}
```
+ Dragon.java
```java
public class Dragon extends Creature
{
    @Override
    public void fly()
    {
        System.out.println("J'ai des ailes, je vole !");
    }
}
```
```Powershell
> javac *.java
Note: App.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
> java App    
...
```

Avertissement pour dire qu'un élément est déprécié au niveau de notre bibliothèque. Cela n'empêche pas la compilation.

Cette annotation indique des informations complémentaires au niveau du code.

## Documented

Utiliser annotation de Java pour la documentation.

Voir Playlist Aide sur comment générer de la documentation : [Zeal - documentation hors-ligne](https://www.youtube.com/watch?v=PmgO42dod7E). Autres exemples de générateur de documentation : Doxygen ou Javadoc fonctionnent avec Java.

`Documented` est une annotation pour dire de prendre en compte un élément dans la documentation. La méthode attack() sera prise en compte dans la documentation.

+ Creature.java
```java
public class Creature
{
    public void fly()
    {
        System.out.println("Je vole, ou pas...");
    }

    @Documented
    public void attack()
    {
        System.out.println("...");
    }
}
```

## unchecked deprecation removal preview

Afficher des avertissements sur des éléments obsolètes (`unchecked`), sur des éléments dépréciés et qui vont être retirés de l'API de Java (`deprecation`), sur des éléments qui manque de vérification et potentiellement problématiques (`removal`), sur les previews pour les fonctionnalités à venir (`preview`). Soit 4 termes :

```java
/*
    unchecked
    deprecation
    removal
    preview
*/
```

Par exemple, si on veux que tout ce qui est invertissement `unchecked` soit masqué : `@SuppressWarnings({"unchecked"})`.

+ Creature.java
```java
public class Creature
{
    @SuppressWarnings({"unchecked"})
    public void fly()
    {
        System.out.println("Je vole, ou pas...");
    }

    @Documented
    public void attack()
    {
        System.out.println("...");
    }
}
```

Par exemple, masquer tous les avertissements des éléments obsolètes et des éléments à venir : `@SuppressWarnings({"unchecked", "preview"})`.

+ Creature.java
```java
public class Creature
{
    @SuppressWarnings({"unchecked", "preview"})
    public void fly()
    {
        System.out.println("Je vole, ou pas...");
    }

    @Documented
    public void attack()
    {
        System.out.println("...");
    }
}
```

C'est une annotation de valeurs : SuppressWarnings(). On peut très bien décider de masquer les avertissements si on sait bien ce que l'on fait.

## FunctionalInterface

Exemple des interface fonctionnelle avec une seule méthode abstraite et avec une méthode statique forcément implémentée.

+ Flyable.java
```java
public interface Flyable
{
    public abstract void someMethod();

    public static void oneMethod()
    {
        // code...
    }
}
```

Garantir qu'on a bien une interface fonctionnelle.

+ Flyable.java
```java
@FunctionalInterface
public interface Flyable
{
    public abstract void someMethod();
}
```
+ Dragon.java
```java
public class Dragon extends Creature implements Flyable
{
    @Override
    public void fly()
    {
        System.out.println("J'ai des ailes, je vole !");
    }

    public void someMethod()
    {
        System.out.println("...");
    }
}
```
+ Creature.java
```java
public class Creature
{
    public void fly()
    {
        System.out.println("Je vole, ou pas...");
    }

    public void attack()
    {
        System.out.println("...");
    }
}
```
+ App.java
```java
public class App
{
    public static void main(String[] args)
    {
        Dragon d = new Dragon();
        d.attack();
    }
}
```
```Powershell
> javac *.java
> java App
...
```

Si maintenant je respecte pas la définition d'une Interface càd d'avoir une seule méthode abstraite, un élément nous indiquera que ce n'est pas une interface fonctionnelle.

+ Flyable.java
```java
@FunctionalInterface
public interface Flyable
{
    public abstract void someMethod();
    public abstract void antotherMethod();
}
```
```Powershell
> javac *.java
Dragon.java:1: error: Dragon is not abstract and does not override abstract method antotherMethod() in Flyable
public class Dragon extends Creature implements Flyable
       ^
Flyable.java:1: error: Unexpected @FunctionalInterface annotation
@FunctionalInterface
^
  Flyable is not a functional interface
    multiple non-overriding abstract methods found in interface Flyable      
2 errors
```

Ce n'est pas une interface fonctionnelle car elle a plus d'une méthode abstraite.

Alors une interface fonctionnelle permet de définir une signature méthode, qui va servir ensuite d'argument lorsqu'on abesoin de passer par référence une méthode (d'instance, statique) ou un constructeur ou une expression lambda (càd fonction anonyme).

Garantir qu'on respecte bien les contraites d'une interface fonctionelle.

## SafeVarargs

Méthode qui affiche une ou plusieurs listes.

+ App.java
```java
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void printIntLists(List<Integer>... lists)
    {
        for(List<Integer> l : lists)
            System.out.println(l);
    }
    
    public static void main(String[] args)
    {

    }
}
```
```Powershell
> javac App.java
Note: App.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
```

Voilà une opération non vérifiée qui n'est pas safe donc ajouter `@SafeVarargs` à condition d'avoir vérifié en amont tout ce qu'il faut.

+ App.java
```java
import java.util.ArrayList;
import java.util.List;

public class App
{
    @SafeVarargs
    public static void printIntLists(List<Integer>... lists)
    {
        for(List<Integer> l : lists)
            System.out.println(l);
    }
    
    public static void main(String[] args)
    {

    }
}
```
```Powershell
> javac App.java
>
```

On a masqué cette avertissement pour ne pas l'avoir à chaque compilation.

Ciao tout le monde