
public class Stiva {
	
	private int indicator=0;
	private int[] Stiva;
	
	public Stiva(int max)
	{
		Stiva = new int[max];
	}
	
	public void push(int element)
	{
		Stiva[indicator]=element;
		indicator++;
	}
	
	public void pop()
	{
		Stiva[indicator]=Stiva[indicator+1];
		indicator--;
	}
	
	public void popCoada()
	{
		int i;
		for(i=0;i<indicator-1;i++)
		{
			Stiva[i]=Stiva[i+1];
		}
		indicator--;
	}
	
	public void afisare()
	{
		int i;
		for(i=0;i<indicator;i++)
			System.out.print(Stiva[i]+" ");
	}
	
}
