import java.util.*;

public class App
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Annee de naisance : ");
			int yearOfBirth = sc.nextInt();
			System.out.println(yearOfBirth);
		}
		catch(InputMismatchException e)
		{
			System.out.println(e.getMessage());
		}
	}
}