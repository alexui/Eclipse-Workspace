package Ex1_2_3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Grep {

	public static void main(String[] args) {

		BufferedReader in =null;
		String s;
		int line_number=0;
		
		if(args.length!=2){
			System.err.println("Usage: java Grep <sursa> <cuvant>");
			System.exit(1);
		}
		
		try{
			in = new BufferedReader(new FileReader(args[0]));
			
			while((s=in.readLine())!=null){
				line_number++;
				if(s.contains(args[1])==true)
				{
					System.out.printf("%4d "+s+"\n",line_number);
				}
			}
			
			in.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
