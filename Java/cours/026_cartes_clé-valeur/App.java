import java.util.TreeMap;
import java.util.Map;
/*
    HashMap : pas de doublons, pas thread-safe, accès direct, valeurs nulles /!\
    TreeMap : pas de doublons, pas thread-safe, accès direct, ordonnée
*/
public class App
{
    public static void main(String[] args)
    {
        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();

        tm.put(3, "Julie");
        tm.put(2, "Luc");
        tm.put(1, null);
        tm.put(10, "Marc");

        for(Map.Entry<Integer, String> ent : tm.entrySet())
        {
            System.out.println("Cle : " + ent.getKey() + " / Valeur : " + ent.getValue());
        }
    }
}