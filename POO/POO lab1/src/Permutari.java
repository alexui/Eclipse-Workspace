import java.lang.reflect.Array;



public class Permutari {

	private int n; //dimensiune
	private Stiva[] st;
	private int[] values; 
	private char[] characters;
	private final int I=1,C=2;
	
	public Permutari(int n,int type,int[] array) {
		this.n = n;
		st = new Stiva[n];
		for(int i=0;i<n;i++)
			st[i]=new Stiva(type);
		values = new int[n];
		this.setValuesArray(array);
	}
	
	public Permutari(int n,char type,char[] array) {
		this.n = n;
		st = new Stiva[n];
		for(int i=0;i<n;i++)
			st[i]=new Stiva(type);
		characters = new char[n];
		this.setCharactersArray(array);
	}
	
	private void setValuesArray(int[] array)
	{
		int i;
		for(i=0;i<n;i++)
		{
			Array.setInt(values, i,array[i]);
		}
	}
	
	private void setCharactersArray(char[] array)
	{
		int i;
		for(i=0;i<n;i++)
		{
			Array.setChar(characters, i,array[i]);
		}
	}
	
	public int getN() {
		return n;
	}
	
	public void setN(int n) {
		this.n = n;
	}
	
	public int[] getValues() {
		return this.values;
	}
	
	public char[] getCharacters() {
		return this.characters;
	}
	
	private boolean Condition(Stiva[] st)
	{
		int i,j;
		for(i=0;i<st.length-1;i++)
		{
			for(j=i+1;j<st.length;j++)
				switch(st[j].Type())
				{
				case I: if(st[i].getD()==st[j].getD()) return false;	break;
				case C: if(st[i].getC()==st[j].getC()) return false;	break;
				default: return false;
				}
		}
		return true;
	}
	
	private void printArray(Stiva[] array)
	{
		int i;

		for(i=0;i<array.length;i++)
		switch(array[i].Type())
			{
			case C: System.out.format("%c ",array[i].getC()); break;
			case I: System.out.format("%d ",array[i].getD()); break;
			default: return;
			}
		System.out.println();
	}
	
	public void BackTrack(int level)
	{
		int i;
		for(i=0;i<this.n;i++)
		{
			switch(st[i].Type())
			{
			case I:	this.st[level].setD(this.values[i]); break;
			case C: this.st[level].setC(this.characters[i]); break; 
			default: return;
			}
			if(level==n-1)
			{
				if(this.Condition(st)==true)
				{
					this.printArray(st);
				}
			}
			else this.BackTrack(level+1);
		}
	}
	
}
