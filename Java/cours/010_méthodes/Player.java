public class Player
{
	public Player()
	{
		this.mName = "Inconnu";
		this.mLevel = 1;
		System.out.print(this.mName);
		System.out.println(this.mLevel);
	}
	
	public void attack()
	{
		System.out.print(this.mName + " attaque une cible !");
	}
	
	private String mName;
	private int mLevel;
}