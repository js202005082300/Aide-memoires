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