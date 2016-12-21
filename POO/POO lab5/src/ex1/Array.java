package ex1;

public class Array {

	private int[] a;
	private int dim;
	private int nr_elem;
	
	protected final int Error=-1;
	
	public Array()
	{
		a = new int[10];
		this.nr_elem=0;
		this.dim=10;
	}
	
	public Array(int n)
	{
		a = new int[n];
		this.dim=n;
		this.nr_elem=0;
	}
	
	public int getNr_elem() {
		return nr_elem;
	}
	
	protected void incNr_Elem(){
		
		if(nr_elem==dim) return;
		nr_elem++;
	}
	

	public int getDim() {
		return dim;
	}

	public int get(int pos)
	{
		if(pos>=this.nr_elem || pos<0)
			return Error;
		return a[pos];
	}
	
	public void set(int pos,int val)
	{
		if(pos>=this.dim)
			return;
		a[pos]=val;
		this.nr_elem++;
	}
	
	public void decNr_elem()
	{
		if(nr_elem==0) return;
		this.nr_elem--;
	}
	
	public String toString()
	{
		String s = "";
		int i;
		for(i=0;i<this.nr_elem;i++)
			s=s+a[i]+" ";
		return s;
	}
	
	protected void print(int val)
	{
		if(val==Error)
			System.err.println("Error");
		else System.out.print(val+" ");
	}
	
	public void realloc(int new_dim)
	{
		int[] aux = new int[new_dim];
		int old_dim=this.dim;
		int pr_length=Math.min(old_dim, new_dim);
		System.arraycopy(a, 0, aux, 0, pr_length);
		a=aux;
	}
	
	public Iterator createIterator()
	{
		class InnerIterator implements Iterator //folosim o clasa nestatica pentru a avea acces la unele metode din clasa parinte
		{
			int index = 0;
			private int Nr_elem_inner = getNr_elem();
			@Override
			public boolean hasNext() {
				
				if(getNr_elem()==0 || index==Nr_elem_inner)
					return false;
				return true;
			}

			@Override
			public int next() {
				
				if(Nr_elem_inner!=getNr_elem())
					return -1;
				
				if(this.hasNext()){
					
					this.index++;
					return get(index-1);
				}
				
				else 
					return 0;
			}
		}
		
		return new InnerIterator();
	}
	
}
