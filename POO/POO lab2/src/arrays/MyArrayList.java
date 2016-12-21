package arrays;

public class MyArrayList {
	
	private float[] a;
	private int dim;
	private int nr_elem;
	
	public MyArrayList()
	{
		a = new float[10];
		this.nr_elem=0;
		this.dim=10;
	}
	
	public MyArrayList(int n)
	{
		a = new float[n];
		this.dim=n;
		this.nr_elem=0;
	}
	
	private float[] ResizeArray(float[] array,int new_dim)
	{
		float[] new_array = new float[new_dim];
		int old_dim=array.length;
		int preserveLength = Math.min(old_dim, new_dim);
		System.arraycopy(array, 0, new_array, 0, preserveLength);
		return new_array;
	}
	
	public void add(float value)
	{
		if(this.nr_elem==this.dim)
			{
			this.dim*=2; 
			this.a=this.ResizeArray(a, dim);
			}
			 
		a[this.nr_elem]=value;
		this.nr_elem++;
	}
	
	public boolean contains(float value)
	{
		int i;
		for(i=0;i<this.nr_elem;i++)
			if(a[i]==value)
			  return true;
		return false;
	}
	
	private void moveToLeft(float[] a,int index)
	{
		int i;
		for(i=index;i<a.length-1;i++)
			a[i]=a[i+1];
	}
	
	public void remove(int index)
	{
		if(index<0 || index>=nr_elem)
		{
			System.err.println("Index invalid.");
			return;
		}
		this.moveToLeft(this.a, index);
		this.nr_elem--;
		a=this.ResizeArray(a,nr_elem);
	}
	
	public float get(int index)
	{
		if(index<0 || index>=nr_elem)
		{
			System.out.println("Index invalid.");
			return Float.NaN;
		}
		else return this.a[index];
	}
	
	public int size()
	{
		return this.nr_elem;
	}
	
	public String toString()
	{
		String s = "";
		int i;
		for(i=0;i<this.nr_elem;i++)
			s=s+a[i]+" ";
		return s;
	}

}
