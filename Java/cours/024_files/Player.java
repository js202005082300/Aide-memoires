public class Player
{
    public Player(String name, int level)
    {
        this.name = name;
        this.level = level;
    }

    public void hello()
    {
        System.out.println(this.name + " dit bonjour !");
    }

    /*---------------------------------------------------------*/

    private String name;
    public String getName(){return this.name;}

    private int level;
}