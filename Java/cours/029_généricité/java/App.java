import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void printList(List<?> li)
    {
        for(Object o : li)
            System.out.println("> " + o);
    }
    
    public static void main(String[] args)
    {
        Fruit f1 = new Fruit("Cerise");
        Fruit f2 = new Fruit("Myrtille");
        Fruit f3 = new Fruit("Banane");

        List<Fruit> lf = new ArrayList<>();
        lf.add(f1);
        lf.add(f2);
        lf.add(f3);

        //-------------------------------------------------------------

        Vegetable v1 = new Vegetable("Choux");
        Vegetable v2 = new Vegetable("Endive");
        Vegetable v3 = new Vegetable("Poireau");

        List<Vegetable> lv = new ArrayList<>();
        lv.add(v1);
        lv.add(v2);
        lv.add(v3);

        printList(lf);
        printList(lv);
    }
}