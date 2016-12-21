package ex2_3;

public abstract class AbstractContainer implements Container{
	
	private int size;
		
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty() // verifica daca containerul este gol
	{
		return this.size()==0;
	}

}
