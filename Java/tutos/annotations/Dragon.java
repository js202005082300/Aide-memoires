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