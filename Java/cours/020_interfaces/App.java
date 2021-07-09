import jachampagne.*;

public class App
{
	public static void main(String[] args)
    {
		Cottage c = new Cottage();
		Ship s = new Ship();

		c.fly("Carbone");
		s.fly("Mana");

       c.test();
       s.test();
	}
}