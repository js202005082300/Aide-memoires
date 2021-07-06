package jachampagne;

public class Glider extends Vehicle
{
	public Glider()
	{
		this.mMovementSpeed = 28;
	}
	public void moveXY(int x, int y)
	{
		System.out.println("Le planeur fend l'air vers " + x + ", " + y);
    }
}