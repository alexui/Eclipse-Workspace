package Ex4;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Wc {


	public static void main(String[] args) {

		DecryptInputStream in=null;
		BufferedReader input=null;
		int wordcount=0;
		int number_of_lines=0;
		
		if(args.length!=1 && args.length !=2){
			System.err.println("Usage: java Wc <sursa> sau java Wc -l <sursa>");
			System.exit(1);
		}
		
		if(args.length==1){
		
					File source = new File(args[0]);
					
					
						try {
							in = new DecryptInputStream(new FileInputStream(source.getAbsolutePath()));
							while((in.read())!=-1)
							{
								wordcount++;
							}
							in.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
							System.exit(1);
						} catch (IOException e)
						{
							e.printStackTrace();
						}
					
					
					System.out.println(wordcount);
				}
		
		else
		{
			if(args[0].equalsIgnoreCase("-l")!=true){
				System.err.println("Usage: java Wc <sursa> sau java Wc -l <sursa>");
				System.exit(1);
			}
			
			File source = new File(args[1]);
			
				try {
					input = new BufferedReader(new FileReader(source.getAbsolutePath()));
					while(input.readLine()!=null)
					{
						number_of_lines++;
					}
					input.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					System.exit(1);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			
			System.out.println(number_of_lines);
		}
	}
	
	
}
