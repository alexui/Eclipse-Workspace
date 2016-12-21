package Ex1_2_3;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileInputStream in=null;
		FileOutputStream out=null;
		
		
		if(args.length!=2){
			System.err.println("Usage: java Cp <sursa> <destinatie>");
			System.exit(1);
		}
		
		File source = new File(args[0]);
		if(source.exists()==false)
		{
			System.err.println("Error.Unexisting file.");
			System.exit(1);
		}
		else
		{
			try {
				in = new FileInputStream(source.getAbsolutePath());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		File dest = new File(args[1]);
		if(dest.exists()==false || dest.isDirectory()==false)
		{
			System.err.println("Error.Unexisting destination.");
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.exit(1);					
		}
		
		File copy = new File(args[1]+"\\"+args[0]);
		System.out.println(args[1]+"\\"+args[0]);
		try {
			copy.createNewFile();
			out = new FileOutputStream(copy.getAbsolutePath());
	
			int c;
			while((c=in.read())!=-1)
			{
				out.write(c);	
			}
	
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{	
			try {
				if(out!=null)
					out.close();
				if(in!=null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}

}
