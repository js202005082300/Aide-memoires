public class Fruit
{
    private String name;
    public String getName()
    {
        return this.name;
    }

    private int quantity;
    public int getQuantity()
    {
        return this.quantity;
    }

    public Fruit(String name)
    {
        this.name = name;
        this.quantity = 1;
    }

    public Fruit(String name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }
}