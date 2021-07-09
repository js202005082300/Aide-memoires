public class App
{
	/*
		String

		StringBuilder / StringBuffer : muable (contenu modifiable)
			> length(), capacity()
			> append(<str>), insert(<index>, <str>)
	*/

	public static void main(String[] args)
	{ 
		StringBuffer sBuffer = new StringBuffer();
		
		sBuffer.append(" tout le monde");
		System.out.println(sBuffer);

		sBuffer.insert(0, "Bonjour");
		System.out.println(sBuffer);
	}
}