package lab6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Tema6p2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws java.io.IOException{
		// TODO Auto-generated method stub

		
		String s1,s2;
		int num = 0;
		//double num1,num2,product;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean cont = true;
		while (cont)
		{
		System.out.print ("Enter an integer:");
		s1 = br.readLine();
		StringTokenizer st = new StringTokenizer (s1);
		s2 = "";
		
		
		System.out.println("Enter f string : ");
		String f = br.readLine();
		try
		{
		int p = Integer.parseInt(f);
		System.out.println("p="+p);
		}
		catch (NumberFormatException n)
		{
			System.out.println("Cannot convert f to int.");
		}
		
		
		while (cont && st.hasMoreTokens())
		{
			try
			{
			s2 = st.nextToken();
			num = Integer.parseInt(s2);
			cont = false;
			}
			catch (NumberFormatException n)
			{
			System.out.println("The value in \"" + s2 + "\" is not an integer");
			}
		}
		}
		System.out.println ("You entered the integer: " + num);

}
}
