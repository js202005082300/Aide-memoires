# [31. Threads](https://www.youtube.com/watch?v=gYkgvTYSHM8)

+ [Introduction](#Introduction)
+ [Définition d'un thread](#Définition-d-un-thread)
+ [Utilisation de thread](#Utilisation-de-thread)
+ [Élément exécutable](#Élément-exécutable)
+ [Exécuteur de tâches](#Exécuteur-de-tâches)
+ [Service d'exécution](#Service-d-exécution)
+ [Conclusion](#Conclusion)

>

## Introduction
## Définition d un thread

Un thread est un **fil d'exécution**.

Un tâche s'exécute **en parallèle**. Différent d'un traitement séquentiel.

En Java, utilisation de thread de plateforme càd mis à disposition par le système d'exploitation.

Pas de référence au threads utilisateurs ou au threads demon (en traitement de fond).

## Utilisation de thread

```java
import java.lang.Thread;

public class Main extends Thread
{
    public void run()
    {
        System.out.println("Je suis le traitement...");
    }

    public static void main(String args[])
    {
        Main task = new Main();

        task.start();
    }
}
```
```ps1
> javac Main.java
> java Main      
Je suis le traitement...
```

En réalité un Thread est déjà démarré pour exécuter le programme.

Le thead principal main() et un autre run().

### sleep

Afficher un traitement séquentiel en incrémentant un compteur qu'on affiche à chaque itération de la boucle, où chaque Thread s'exécute et fait son traitement. La 1e et la 2e tâche qui se font à chaque itération selon un délais d'attente.

```java
import java.lang.Thread;

public class Main extends Thread
{
    public void run()
    {
        for(int i = 0 ; i < 5 ; ++i)
        {
            System.out.println(i);

            try
            {
                Thread.sleep(1000); //millisecondes
            }
            catch(InterruptedException e){}
        }
    }

    public static void main(String args[])
    {
        Main task1 = new Main();
        Main task2 = new Main();

        task1.start();
        task2.start();
    }
}
```
```ps1
> javac Main.java
> java Main      
0
0
1
1
2
2
3
3
4
4
```

Traitement séquentiel et rapide, bon ici pas trop de distinction car ce sont les mêmes classes qui font la même chose.

### join

Synchroniser un thread avec un autre avec la méthode join() pour ainsi attendre que le 1e Thread soit terminé pour exécuter le suivant.

```java
import java.lang.Thread;

public class Main extends Thread
{
    public void run()
    {
        for(int i = 0 ; i < 5 ; ++i)
        {
            System.out.println(i);

            try
            {
                Thread.sleep(1000);
                // this.join();
            }
            catch(InterruptedException e){}
        }
    }

    public static void main(String args[]) throws InterruptedException
    {
        Main task1 = new Main();
        Main task2 = new Main();

        task1.start();
        task2.start();

        try
        {
            task1.join();
            task2.join();
        }
        catch(InterruptedException e){}

        System.out.println("Tous les traitements sont finis.");
    }
}
```
```ps1
> javac Main.java
> java Main
0
0
1
1
2
2
3
3
4
4
Tous les traitements sont finis.
```

Note : `throws InterruptedException` pour avoir le code le plus correct possible lors du développement.

Voilà une fois que les threads ont finis, ils s'attendent puis on poursuit la suite du programme.

Si une tâche avait 5 itérations et l'autre 10, le message ne se serait pas affiché à les 10.

Voilà pour une méthode sommaire.

## Élément exécutable

Ou des éléments *runable* et on doit implémenter lorsque c'est une interface.

```java
/*
    class MyTask implements Runable
    {
        public void run()
        {

        }
    }

    Thread task = new Thread(new MyTask());
    task.start();
*/
```

Voilà on peut passer en paramètre un traitement à éffectuer, un runable.

## Exécuteur de tâches

Travailler avec un/des exécutables en important `Executors` et `Executor`.

3 possibilités :
- 1 thread qui s'occupe d'une tâche `newSingleThreadExecutor`
- threads dynamiques pour un jeux de threads soit un pool `newCachedThreadPool`
- nombre de threads fixe et non-dynamique `newFixedThreadPool`

```java
import java.util.concurrent.Executors;
import java.util.concurrent.Executor;

/*
    newSingleThreadExecutor
    newCachedThreadPool
    newFixedThreadPool
*/

public class Main
{
    public static void main(String args[])
    {
        Executor ex = Executors.newSingleThreadExecutor();

        // Une expression lambda
        Runnable task1 = () ->
        {
            for(int i = 0 ; i < 5 ; ++i)
            {
                System.out.println(i);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        };

        Runnable task2 = () ->
        {
            for(int i = 5 ; i < 9 ; ++i)
            {
                System.out.println(i);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        };

        ex.execute(task1);
        ex.execute(task2);
    }
}
```
```ps1
> javac Main.java
> java Main
0
1
2
3
4
5
6
7
8
```

Il faudrait faire un join() pour continuer.

Tout à l'heure les éléments se mélangeaient mais ici le traitement est séquentiel car on travaille avec un seul Thread et au niveau du code, task1 est mis en premier.

## Service d exécution

Utiliser un service `ExecutorService` et stopper l'exécution shutdown()

```java
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/*
    newSingleThreadExecutor
    newCachedThreadPool
    newFixedThreadPool
*/

public class Main
{
    public static void main(String args[])
    {
        ExecutorService ex = Executors.newCachedThreadPool(); // traitement dynamique (rapide)

        Runnable task1 = () ->
        {
            for(int i = 0 ; i < 5 ; ++i)
            {
                System.out.println(i);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        };

        Runnable task2 = () ->
        {
            for(int i = 5 ; i < 9 ; ++i)
            {
                System.out.println(i);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        };

        ex.execute(task1);
        ex.execute(task2);

        ex.shutdown(); // stopper les threads proprement
    }
}
```
```ps1
> javac Main.java
> java Main
0
5
1
6
2
7
3
8
4
> java Main
5
0
6
1
7
2
8
3
4
> 
```

Voilà traitement asynchrone, traitement parallèle.

Mettre une valeur fixe `newFixedThreadPool` reviendrait à faire `newSingleThreadExecutor`

Création dynamique de Threads qui peuvent être créé à la volée : `newCachedThreadPool`

### Future

L'intérêt d'utiliser un **ExecutorService** est d'avoir un résultat d'exécution, des `Future` en l'important.

```java
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/*
    newSingleThreadExecutor
    newCachedThreadPool
    newFixedThreadPool
*/

public class Main
{
    public static void main(String args[])
    {
        ExecutorService ex = Executors.newCachedThreadPool(); // traitement dynamique (rapide)

        Runnable task1 = () ->
        {
            for(int i = 0 ; i < 5 ; ++i)
            {
                System.out.println(i);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        };

        Runnable task2 = () ->
        {
            for(int i = 5 ; i < 9 ; ++i)
            {
                System.out.println(i);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        };

        // ex.execute(task1);
        // ex.execute(task2);
        Future<?> fut1 = ex.submit(task1);
        Future<?> fut2 = ex.submit(task2);

        ex.shutdown(); // stopper les threads proprement
    }
}
```
```ps1
> javac Main.java
> java Main
0
5
6
1
7
2
8
3
4
> 
```

Les traitement sont parallèle donc on ne sait pas dans quel ordre, ils se font.

On n'execute plus les tâches mais on les soumets. Selon la généricité, on met `<?>` car on ne connait pas le type de retour.

`Future` est une interface qui permet d'avoir le résultat de différents traitements donc on a accès à quelques méthodes :

```java
/*
    newSingleThreadExecutor
    newCachedThreadPool
    newFixedThreadPool

    isDone(), isCancelled()
    get(), cancel()
*/
```

```java
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Main
{
    public static void main(String args[])
    {
        ExecutorService ex = Executors.newCachedThreadPool(); // traitement dynamique (rapide)

        Runnable task1 = () ->
        {
            for(int i = 0 ; i < 5 ; ++i)
            {
                System.out.println(i);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        };

        Runnable task2 = () ->
        {
            for(int i = 5 ; i < 9 ; ++i)
            {
                System.out.println(i);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        };

        // ex.execute(task1);
        // ex.execute(task2);
        Future<?> fut1 = ex.submit(task1);
        Future<?> fut2 = ex.submit(task2);

        while(!fut1.isDone() || !fut2.isDone()) // tant que le traitement n'est pas finis ...
        {
            System.out.println("On attend...");
            try
            {
                Thread.sleep(500); // 1/2 seconde
            }
            catch(InterruptedException e){}
        }

        if(fut1.isDone() && fut2.isDone())
            System.out.println("YEAH !");

        ex.shutdown(); // stopper les threads proprement
    }
}
```
```ps1
> javac Main.java
> java Main
On attend...
0
5
On attend...
1
On attend...
6
On attend...
2
On attend...
7
On attend...
3
8
On attend...
On attend...
4
On attend...
On attend...
YEAH !
```

Voilà on avait beaucoup moins de fonctionnalité, méthodes avec la tâche Run avec la classe Thread.

On peut également récupérer un résultat sous forme de chaîne de caractères.

```java
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Main
{
    public static void main(String args[])
    {
        ExecutorService ex = Executors.newCachedThreadPool(); // traitement dynamique (rapide)

        Runnable task1 = () ->
        {
            for(int i = 0 ; i < 5 ; ++i)
            {
                System.out.println(i);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        };

        Runnable task2 = () ->
        {
            for(int i = 5 ; i < 9 ; ++i)
            {
                System.out.println(i);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        };

        Future<String> fut1 = ex.submit(task1, "Je suis Jean, j'ai fini"); // 2e argument à récupérer get() ss forme de chaîne
        Future<String> fut2 = ex.submit(task2, "Je suis Marie, j'ai fini");

        while(!fut1.isDone() || !fut2.isDone()) // tant que le traitement n'est pas finis ...
        {
            System.out.println("On attend...");
            try
            {
                Thread.sleep(500); // 1/2 seconde
            }
            catch(InterruptedException e){}
        }

        if(fut1.isDone())
        {
            try
            {
                System.out.println(fut1.get());
            }
            catch(Exception e){}
        }

        if(fut2.isDone())
        {
            try
            {
                System.out.println(fut2.get());
            }
            catch(Exception e){}
        }

        ex.shutdown(); // stopper les threads proprement
    }
}
```
```ps1
> javac Main.java
> java Main
On attend...
0
5
On attend...
1
On attend...
6
On attend...
2
7
On attend...
On attend...
3
8
On attend...
On attend...
4
On attend...
On attend...
Je suis Jean, j'ai fini
Je suis Marie, j'ai fini
```

Future permet de renvoyer un résultat à la fin d'exécution de la tâche. Ensuite on récupère ce qui a été renvoyé.

## Conclusion

Autres notions de vérou, de sémaphore, de mutux et cetera.

Il faut des besoin spécifique pour tout ça !

On vu du traitement asynchrone pour faire du traitement en parallèle.

Utilité pour avoir un Thread qui garde l'affichage d'une fenêtre et un autre gère des calculs, autrement tant que le calcul est en cours, on ne pourrait plus cliquer sur des boutons. Le calcul devrait se terminer pour utiliser l'interface dont l'intérêt de traitements parallèles et asynchrones.

On verra prochainnement les bases de données, les interfaces, le réseau ...

A bientôt pour la suite du cours