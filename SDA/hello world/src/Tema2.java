import java.util.Scanner;


public class Tema2 {

	//private static Scanner in;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int i=0,n;
		Scanner in = new Scanner(System.in);
		do
			{
			System.out.print("introduceti numar: ");
			n=in.nextInt();
			i++;
			}
		while((n<0 || n>10) && i<3);
		
		in.close();
		
	}
}
