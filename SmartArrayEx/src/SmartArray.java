
public class SmartArray {
	
	private int[] IntString;
	private int nElems=0;
	
	public SmartArray(int M[])
	{
		nElems=M.length;
		IntString=new int[M.length+1];
	//	int i;
		System.arraycopy(M, 0, IntString,0, nElems);
	/*	for(i=0;i<nElems;i++)
		{
			IntString[i]=M[i];
		}*/
	}
	
	public void ShowSmartArray()
	{
		int i;
		for(i=0;i<nElems;i++)
		{ System.out.printf("%d,",IntString[i]);} System.out.println();
	}
	
	public int GetNumarElemente()
	{ return nElems;}

	
	public void Add(int element)
	{
		IntString[nElems]=element;
		nElems++;
	}
	
	private void MoveToLeft(int i)
	{
		for(;i<(nElems-1);i++)
		{
			IntString[i]=IntString[i+1];
		}
		nElems--;
	}
	
	public void Delete(int element)
	{
		int i;
		for(i=0;i<nElems;i++)
		{
			if(IntString[i]==element)
			{
				MoveToLeft(i);
			}
		}
	}
	
	public void Pairs()
	{
		int i,j;
		for(i=0;i<nElems;i++)
		{
			for(j=0;j<nElems;j++)
				if(IntString[i]+IntString[j]==0)
					System.out.printf("{%d,%d} ; ", IntString[i],IntString[j]);
					
		}
		System.out.println();
	}

	public void ZeroSum()
	{
		int n;
		int[] stiva;
		if(nElems<2) return; 
		for(n=2;n<=nElems;n++)//stiva poate avea minimum 2 elemente si maximum nElems
		{
			stiva=new int[n+1]; 
			BackTrack(stiva,0,0,n);
		}
	}
	
	private void BackTrack(int[] stiva,int k,int index,int n) //k nivelul stivei, index avanseaza in vector, n numarul de elemente din stiva
	{
		int i;
		for(i=index;i<nElems;i++)
		{
			stiva[k]=IntString[i];
			if(k==(n-1)) // daca s-a umplut stiva
				{if(Zero(stiva,n)==1) // verifica daca suma elementelor este zero
					ShowArray(stiva,n);}
			if(k<(n-1))
				BackTrack(stiva,k+1,index+i+1,n); // recursivitate
		}
	}
	
	private int Zero(int[] array,int n)
	{
		int i,s=0;
		for(i=0;i<n;i++)
			s+=array[i];
		if(s==0) return 1; 
		else return 0;
	}
	
	private void ShowArray(int[] array,int n)
	{
		int i;
		for(i=0;i<n;i++)
			System.out.printf("%d, ",array[i]);
		System.out.println();
	}
	
}