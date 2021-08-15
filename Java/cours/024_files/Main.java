import java.util.PriorityQueue;

/*
    PriorityQueue : ordonnée, accepte doublons, refuse valeurs nulles, PAS thread-safe
*/

public class Main
{
    public static void main(String []args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(155);
        pq.add(8);
        pq.add(0);
        pq.add(8);
        pq.add(-14);
        pq.add(365);

        System.out.println(pq.poll());
        System.out.println(pq.peek());
    }
}