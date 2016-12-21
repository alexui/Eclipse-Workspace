package ex4;

import java.util.ArrayList;

public class Array implements Observed{

	private int[] a;
	private int dim;
	private int nr_elem;
	private int nr_Obs;
	private ArrayList<ListObserver> observers = new ArrayList<ListObserver>();
	
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
	
	public class add implements ListEvent{ //note: cand se adauga un element se notifica toti observatorii curenti
		
		private int val;
		private long duration;
		private int[] list;
		
		public add (int val)
		{
			this.val=val;
			long t = System.nanoTime();
			set(nr_elem, val);
			this.duration=System.nanoTime()-t;
			
			this.list= new int[nr_elem];
			System.arraycopy(a, 0, list, 0, nr_elem);
		}
		
		@Override
		public int getElement()
		{
			return this.val;
		}
		
		@Override
		public int[] getList()
		{
			return list;
		}
		
		@Override
		public long getDuration()
		{
			return this.duration;
		}
	}
	
	public class remove implements ListEvent{
		
		private int val;
		private long duration;
		private int[] list;
		
		public remove ()
		{
			this.val=a[nr_elem-1];
			long t = System.nanoTime();
			decNr_elem();
			a[nr_elem]=0;
			this.duration=System.nanoTime()-t;
			this.list= new int[nr_elem];
			System.arraycopy(a, 0, list, 0, nr_elem);
		}
		
		@Override
		public int getElement()
		{
			return this.val;
		}
		
		@Override
		public int[] getList()
		{
			return this.list;
		}
		
		@Override
		public long getDuration()
		{
			return this.duration;
		}
	}
	
	 	//clasa anonima
	
		public ListObserver getObserver(){
			
		return new ListObserver() {
			
			
			@Override
			public boolean elementRemoved(ListEvent e) {
				
				if(e instanceof remove)
					return true;
				return false;
			}
			
			@Override
			public boolean elementAdded(ListEvent e) {

				if(e instanceof add)
					return true;
				return false;
			}

		};
		
		}
	
	
	protected final int Error=-1;
	
	public int getNr_elem() {
		return nr_elem;
	}
	
	private void incNr_Elem(){
		
		if(nr_elem==dim) return;
		this.nr_elem++;
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
	
	private void set(int pos,int val)
	{
		if(pos>=this.dim)
			return;
		a[pos]=val;
		incNr_Elem();
	}
	
	private void decNr_elem()
	{
		if(nr_elem==0) return;
		this.nr_elem--;
	}
	
	public String convertToString()
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
	
	

	@Override
	public void registerObserver(ListObserver o) {
		
		this.observers.add(o);
		this.nr_Obs++;
	}
		
	
	public int getNrObs()
	{
		return this.nr_Obs;
	}
	
	public ArrayList<ListObserver> getAllObservers()
	{
		return this.observers;
	}
	
}
