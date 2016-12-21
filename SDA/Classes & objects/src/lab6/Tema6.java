package lab6;

import java.io.*;
import java.util.*;

public class Tema6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws java.io.IOException 
	{
		// TODO Auto-generated method stub
		
		String s1,s2;
		//double num1,num2,product;
		
		System.out.println("Insert string :");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s1 = br.readLine();
		//s1 = in.nextLine();
		System.out.println ("The line has " + s1.length() + " characters");
		System.out.println ();
		System.out.println ("Breaking the line into tokens we get:");
		
		int numTokens = 0;
		StringTokenizer st = new StringTokenizer (s1);
		while (st.hasMoreTokens())
		{
		s2 = st.nextToken();
		numTokens++;
		System.out.println (" Token " + numTokens + " is: " + s2);
		}
		
			
		br.close();
		
		
	}

}
