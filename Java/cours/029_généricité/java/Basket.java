public class Basket<E>
{
    private E item;
    public E getItem()
    {
        return this.item;
    }

    public Basket(E item)
    {
        this.item = item;
    }
}