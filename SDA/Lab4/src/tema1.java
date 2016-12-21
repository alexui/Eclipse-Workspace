import java.util.Scanner;

public class tema1 {

	/**
	 * @param args
	 */
	private static Scanner in;
	
	public static void main(String[] args) {
		
		System.out.println("Insert cardnumber:");
		in = new Scanner(System.in);
		String cardnumber=in.nextLine();
		System.out.println(cardnumber);
		int i;
		String before,after;
		
		for(i=0;i<cardnumber.length();i++)
		{
			if(cardnumber.charAt(i)==' ' || cardnumber.charAt(i)=='-')
			{
				before=cardnumber.substring(0,i);
				after=cardnumber.substring(i+1);
				cardnumber=before+after;
				i--;
			}
		}
		
		System.out.println(cardnumber);
	}

}
