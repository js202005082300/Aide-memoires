import java.util.Scanner;

public class App
{
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Acceder a quel niveau ?");
		int game_level = sc.nextInt();

		System.out.println(game_level);
	}
}