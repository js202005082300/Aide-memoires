package jachampagne;

public class Cottage extends Building implements Flyable
{
	public Cottage()
    {
    	System.out.println("Parcelle en place...");
    }
    public void build(String material)
    {
    	System.out.println("Construction du batiment en " + material);
    }
    public void fly(String energy)
    {
    	System.out.println("Je me propulse dans les airs avec du " + energy);
    }
	public void test()
	{
		System.out.println("Mon test a moi !");
	}
}