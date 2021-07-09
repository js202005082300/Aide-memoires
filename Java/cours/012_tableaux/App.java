import java.util.Arrays;

public class App
{
	public static void main(String[] args)
	{
		int[] tab = new int[10];

		Arrays.fill(tab, 15);
		
		for(int el : tab)
			System.out.println(el);
	}
}