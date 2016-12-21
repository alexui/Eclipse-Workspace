package lab6;

public class tema7 {
		
	
	public static void main(String[] args)
	{
		IdentifyMyParts a = new IdentifyMyParts();
		IdentifyMyParts b = new IdentifyMyParts();
		a.y = 5;
		b.y = 6;
		a.x = 89;
		b.x = 79;
	//	IdentifyMyParts.x = 8;
		System.out.println("a.y = " + a.y);
		System.out.println("b.y = " + b.y);
		System.out.println("a.x = " + a.x);
		System.out.println("b.x = " + b.x);
		System.out.println("IdentifyMyParts.x = "+IdentifyMyParts.x);
	}
}
