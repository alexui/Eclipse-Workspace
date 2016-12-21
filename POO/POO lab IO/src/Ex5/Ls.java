package Ex5;

import java.io.File;

public class Ls {

	public static void list(File path,int tabs)
	{
		int i;
		for(i=0;i<tabs;i++)
			System.out.print("\t");
		
		if(path.isFile()==true)
		{
			System.out.println(path.getName()+" "+path.getTotalSpace());
		}
		if(path.isDirectory()==true)
		{
			System.out.println(path.getName());
			for(i=0;i<path.list().length;i++){
				list(path.listFiles()[i],tabs+1);
			}
		}
	}
	
	public static void main(String[] args) {

		
		if(args.length !=1){
			System.err.println("Usage: java Ls <sursa>");
			System.exit(1);
		}
		
		File path = new File(args[0]);
		if(path.exists()==false){
			System.err.println("Error.Unexisting file.");
			System.exit(1);
		}
		
		list(path,0);
	}

}
