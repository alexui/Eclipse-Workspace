package Alg_BMH;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class BMH_search {
	
	public final int NOT_FOUND=-1;
	public int lineFound=0;
	
	private final int DIM_ALPH=127;
	private int n;
	private int m;
	private String FileName;
	private String text;
	private String pattern;
	private int[] shift=new int[DIM_ALPH];
	private BufferedReader in;
	
	public BMH_search(String pattern,String FileName)
	{
		try {
		in= new BufferedReader(new FileReader(FileName));
		m=pattern.length();
		this.pattern=pattern;
		this.FileName=FileName;
		makeShift();
		
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
		}
	}
	
	public String getFileName() {
		return FileName;
	}

	public int getLineFound() {
		return lineFound;
	}
	
	private void makeShift()
	{
		int i;
		for(i=0;i<DIM_ALPH;i++)
		{
			shift[i]=this.m;
		}
		for(i=0;i<this.m-1;i++)
			shift[this.pattern.charAt(i)]=m-1-i;
	}
	
	
	//Algoritmul Boyer Moore Horsepool
	public int search() throws IOException
	{
		while((this.text=in.readLine()) != null)//add
		{
		this.n=this.text.length();
		this.lineFound++;//add
		int i,j;
		int jump=0;
		for(i=this.m-1;i<this.n;i=i+jump)
		{
			j=this.m-1;
			while(this.pattern.charAt(j)==this.text.charAt(i-(this.m-1)+j))
				{
				j--; 
				if(j<0)
					return i-(this.m-1); //pozitia de inceput
				}
			jump=shift[this.text.charAt(i)]; //calculeaza saltul - rightmost occurrence of that letter in the pattern
		}
		}
		return NOT_FOUND;
	}

	
}