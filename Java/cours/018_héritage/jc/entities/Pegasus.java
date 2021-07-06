package jc.entities;

public class Pegasus extends Horse
//public final class Pegasus extends Horse
{
	public Pegasus(String name)
	{
		super(name);
		//this.mName = name;
		//this.mPosX = 50;
		//this.mPosY = 50;
		this.mPosZ = 100;
	}

	//public void move(int x, int y)
	//{
	//	this.mPosX = x;
	//	this.mPosY = y;
	//	System.out.println("Le Pegase se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");
	//}
	
	//public void move(int x, int y)
	//{
	//	super.move(x, y);
	//	System.out.println("Le pegase se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");
	//}

	
	public void fly(int z)
	{
		this.mPosZ = z;
		System.out.println("Le Pegase s'eleve dans les airs (Z = "+this.mPosZ+")");
	}

	//private String mName;
	//private int mPosX;
	//private int mPosY;
	private int mPosZ;
}