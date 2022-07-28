public enum Color
{
    GREEN("Vert"), RED("Rouge"), WHITE("Noir");

    private String name;

    private Color(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return this.name;
    }
}