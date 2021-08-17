import java.util.TreeSet;

/*
    HashSet : pas de doublons, pas thread-safe, accès direct
    TreeSet : pas de doublons, pas thread-safe, ordonnée, pas d'accès direct

    hashCode()
    equals()
*/

public class Main
{
    public static void main(String []args)
    {
        TreeSet<Integer> hs = new TreeSet<Integer>();

        hs.add(15);
        hs.add(-4);
        hs.add(388);
        hs.add(1);
        hs.add(-1);
        hs.add(155);
        hs.add(-4220);

        System.out.println(hs.subSet(-4, 388));
    }
}