package jachampagne;

public class Ship extends Vehicle implements Flyable
{
	public Ship()
	{
		this.mMovementSpeed = 16;
    }
    
    public void moveXY(int x, int y)
    {
    	System.out.println("Le navire brasse les flots et se déplace en " + x + ", " + y);
    }
    
    public void fly(String energy)
    {
    	System.out.println("Je me propulse dans les airs avec du " + energy);
    }
       
}