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