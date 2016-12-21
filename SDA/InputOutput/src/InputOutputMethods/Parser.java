package InputOutputMethods;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Parser {



	/**
	 * @param args
	 */
	public static void main(String[] args) {

			BufferedInputStream in = null;
			FileWriter out=null;
		
			try {
				 in= new BufferedInputStream(new FileInputStream("inputt.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Error");
				e.printStackTrace();
				Scanner scan = new Scanner(System.in);
				
				do{
				System.out.println("File name: ");
				
				try {
					in = new BufferedInputStream(new FileInputStream(scan.next()));
				} catch (FileNotFoundException e1) {
					System.out.println("Nume incorect. Reintroduceti.");
				}
				}while(in==null);
				scan.close();
			}
			
			try {
				 out= new FileWriter("output.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(in != null && out!=null)
			{
				Scanner scan = new Scanner(in);
				scan.useDelimiter("[: ]|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
				String s;
				while(scan.hasNext())
					{
						s= scan.next();
						System.out.println(s);
						try {
							out.write(s);
							out.write("\n");
							out.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				scan.close();
			}
		
		/*FileParser in = new FileParser("test01");
		in.open();
		String s;
		while((s=in.getNextWord()) != null)
			System.out.println(s);*/
	}

}
