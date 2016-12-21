import java.util.Scanner;
import java.util.Random;

public class tema5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int n,i,value;
		int[] v;
		v = new int[6];
		Scanner in = new Scanner(System.in);
		Random dice = new Random();
		
		System.out.println("Insert number of attempts:");
		n = in.nextInt();
		for(i=0;i<n;i++)
		{
			value = dice.nextInt(6)+1;
			v[value-1]++;
		}
		
		System.out.println("The values of the dice are the following:");
		for(i=0;i<v.length;i++)
			System.out.printf("%4d",i+1);
		System.out.println();
		for(i=0;i<v.length;i++)
			System.out.printf("%4d",v[i]);
		
		in.close();
	}

}
