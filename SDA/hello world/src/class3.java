import java.util.Scanner;

public class class3 {

	/**
	 * @param args
	 */
	public static void main(String[] args){

		double a=1,z=12.5683;
		double b = 6.2;
		double c = a + b;
		int s=78;
		long g;

		float d = 0.5f;
		int e = 7;
		int f = (int)d + e;
		
		String m = String.valueOf(s);
		System.out.println(m);
		
		
		Scanner in = new Scanner(System.in);
		String sir = in.nextLine();
		System.out.println(sir);
		in.close();
		
		g=(long)(z);
		System.out.println("g="+g);

		System.out.println("c = " + c);
		System.out.println("f = " + f);
	}
}

