package jachampagne;

public class Cottage extends Building implements Flyable
{
	public Cottage()
	{
       	
    }

    public void build(String material)
    {
       	System.out.print("Constraction du batiment en " + material);
	}

	public void fly()
	{
		System.out.println("La chaumiere s'eleve peu a peu dans les airs");
	}
}