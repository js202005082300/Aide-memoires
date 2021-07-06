public class App
{
	public static void main(String[] args)
	{
		String choice = "y";

		switch(choice)
		{
			case "y":
				/* if(choice == "y") */
				System.out.println("OUI");
				break;
			case "n":
				/* if(choice == "n") */
				System.out.println("NON");
				break;
			default:
				/* if(choice != "y" && choice != "n") */
				System.out.println("Ni oui ni non");
				break;
		}
	}
}