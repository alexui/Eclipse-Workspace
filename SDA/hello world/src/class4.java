
public class class4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	int p[]=new int[100];
	int q[]=new int[100];
	int i,j,n=8;
	p[0]=1;
	for(i=0;i<n;i++)
	{
		
		for(j=1;j<i+1;j++)
			q[j]=p[j]+p[j-1];
		q[i]=1;
		for(j=0;j<i+1;j++)
		{
			System.out.print(q[j]+" ");
			p[j]=q[j];
		}
		System.out.println();
	}

	}

}
