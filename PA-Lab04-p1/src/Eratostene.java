import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Eratostene {

	int MAXSIZE=80000002;
	char[] p = new char[MAXSIZE];
	char[] q = new char[MAXSIZE];
	
	//p[i] == 0 daca i este prim
	public int PRIM(int n) {
	  int i, j, nr = 0;
	  p[1]=1;
	  for (i = 2; i <= n; ++i) {
	    if (p[i] == 0) {
	      nr++;
	      for (j = i + i; j <= n; j += i) {
	        p[j] = 1;
	      }
	    }
	  }
	  return nr;
	}
	
	//p[i] == 0 daca i este prim
	public int PITIC(int n) {
	  int i, j, nr = 0;
	  q[1]=1;
	  for (i = 2; i <= n; ++i) {
	    if (q[i] == 0) {
	    	
	    	//test numar pitic
	    	int x=i;
	    	boolean pitic =true;
	    	while(x!=0)
	    	{
	    		if(q[x]!=0){
	    			pitic=false;
	    			break;
	    		}
	    		x = x/10;
	    	}
	    	
	    	if(pitic)
	    		nr++;
	    	else 
	    		q[i]=1;
	    	
	      for (j = i + i; j <= n; j += i) {
	        q[j] = 1;
	      }
	    }
	  }
	  return nr;
	}

	public static void main(String[] args) {

		System.out.println("--Eratostene's Sieve--");
		System.out.print("Type a number: ");
		Scanner s = new Scanner(System.in);
		
		Eratostene e = new Eratostene();
		int n = s.nextInt();
		//System.out.println("Prime numbers found: "+e.PRIM(n));
	/*	System.out.println("The folowing numbers are prime:");
		for(int i =2;i<=n;i++)
		{
			if(e.p[i]==0)
				System.out.print(i+" ");
		}
		System.out.println();*/
		try {
			PrintWriter pw = new PrintWriter(new File("prime.txt"));
			System.out.println("PitiPrime numbers found: "+e.PITIC(n));
			System.out.println("The folowing numbers are piti-prime:");
			for(int i =2;i<=n;i++)
			{
				if(e.q[i]==0){
					System.out.print(i+" ");
					pw.print(i);
					pw.println();
				}
			}
			pw.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*System.out.println();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(9);
		numbers.add(8);
		numbers.add(9);
		System.out.println(numbers);
		numbers.remove(new Integer(9));
		System.out.println(numbers);*/

	}

}
