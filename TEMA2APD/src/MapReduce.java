import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MapReduce {

	int D; //dimensiunea fragmentelor
	float X;//prag de similitudine
	int ND;//numarul de documente
	ArrayList<String>files; //fisierele de intrare
	
	String inputFile,outputFile;
	int NT; //number of threads
	
	FileInputStream is;
	
	//citeste date din fisier
	void readInput(String name){
		try {
			is = new FileInputStream(name);
			
			Scanner scan= new Scanner(is);
			D = scan.nextInt();
			X = scan.nextFloat();
			ND = scan.nextInt();
			
			scan.nextLine();
			files = new ArrayList<String>();
			for(int i=0;i<ND;i++)
				files.add(scan.nextLine());
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void writeOutput(String name){
		
	}
	
	public static void main(String[] args) {
		
		MapReduce mr = new MapReduce();
		//mr.NT = Integer.parseInt(args[0]);
		//mr.inputFile = args[1];
		//mr.outputFile = args[2];
		
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println(processors);
	}
}
