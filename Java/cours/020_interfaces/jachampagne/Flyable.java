package jachampagne;

@FunctionalInterface
interface Flyable
{
	public void fly(String energy);

    default public void test()
    {
		System.out.println("Test"); 
    }
}