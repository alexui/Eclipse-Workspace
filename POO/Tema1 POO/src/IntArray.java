

import java.sql.Array;

public class IntArray {

	private int[] a;
	private int length;
	
	/**
	 * se creaza o structura ce contine un:<br>
	 * {@link Array} de valori de tip {@link Integer};<br>
	 * un {@link Integer} ce retine dimensiunea {@link Array}-ului.<br>
	 * {@link Array} va avea 0 elemente.
	 */
	public IntArray()
	{
		this.a=new int[0];
		this.length=0;
	}
	
	/**
	 * se creaza o structura ce contine un:<br>
	 * {@link Array} de valori de tip {@link Integer};<br>
	 * un {@link Integer} ce retine dimensiunea {@link Array}-ului.<br>
	 * {@link Array} va avea numarul de elemente specificat de parametru.
	 * @param dim
	 */
	public IntArray(int dim)
	{
		this.a=new int[dim];
		this.length=dim;
	}
	
	/**
	 * getter pentru {@link Array} de elemente de tip intreg
	 * @return {@link Array} de tip {@link Integer}
	 */
	public int[] getA() {
		return a;
	}

	/**
	 * realoca vectorul la dimensiunea specificata de parametru
	 * @param dim
	 */
	private void extend(int dim)
	{
		int old_dim=this.length;
		int new_dim=old_dim +dim;
		int[]aux=new int[new_dim];
		System.arraycopy(this.a, 0, aux, 0, old_dim);
		this.a=aux;
		this.length=new_dim;
	}
	
	/**
	 * adauga element la vector
	 * @param elem
	 */
	public void add(int elem)
	{
		int i;
		this.extend(1);
		if(this.length==1)
		{
			this.a[0]=elem;
		}
		else
		{
			for(i=this.length-1;i>0 && a[i-1]>elem ;i--)
				a[i]=a[i-1];
			a[i]=elem;
		}
	}
	
}
