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