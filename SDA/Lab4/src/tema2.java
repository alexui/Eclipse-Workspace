import java.util.Scanner;
import java.util.Random;

public class tema2 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
	Random generator = new Random();
	Scanner in=new Scanner(System.in);
	int number = generator.nextInt(10)+1;
	int i,guess=0;
	for(i=0;i<3 && guess!=number;i++)
		{
		System.out.println("try to guess the number: ");
		guess = in.nextInt();
		}
	if(guess==number) 
		System.out.println("You guessed the number");
	else
		System.out.println("Sorry the number was "+number);
	in.close();
	}

}
