public enum Color
{
    RED("Rouge", "FF0000"),
    GREEN("Vert", "00FF00"),
    BLUE("Bleu", "0000FF");

    private String name;
    private String hexValue;

    private Color(String name, String hexValue)
    {
        this.name = name;
        this.hexValue = hexValue;
    }

    public String toString()
    {
        return this.name;
    }
}