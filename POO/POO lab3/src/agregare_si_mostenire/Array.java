package agregare_si_mostenire;

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
	
	public static void main(String[] args) {
		
		Stiva s= new Stiva();
		s.push(20);
		s.push(30);
		s.push(32);
		System.out.println(s.toString());
		s.print(s.pop());
		s.print(s.pop());
		s.print(s.pop());
		//s.print(s.pop());
	
	}
}
