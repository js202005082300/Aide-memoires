import java.util.Stack;
import java.util.ListIterator;

public class Main
{
	public static void main(String[] args)
	{
		Stack<Cat> group = new Stack<Cat>();

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Pilou");
		Cat c3 = new Cat("Popy");

		group.push(c1);
		group.push(c2);
		group.push(c3);

		ListIterator<Cat> lit = group.listIterator();

		while(lit.hasNext())
			lit.next().meow();
		
		group.peek().meow();
	}
}