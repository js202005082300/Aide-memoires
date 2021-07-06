public class App
{
	public static void main(String []args)
	{
		System.out.println("ENREGISTREMENTS : " + SoftwareRegistration.getNumberOfRegistrations());
		
		SoftwareRegistration sr = new SoftwareRegistration(2020);
		System.out.println("ENREGISTREMENTS : " + SoftwareRegistration.getNumberOfRegistrations());
		
		SoftwareRegistration sr2 = new SoftwareRegistration(2022);
		System.out.println("ENREGISTREMENTS : " + SoftwareRegistration.getNumberOfRegistrations());
		
		SoftwareRegistration sr3 = new SoftwareRegistration(2020);
		System.out.println("ENREGISTREMENTS : " + SoftwareRegistration.getNumberOfRegistrations());
	}
}