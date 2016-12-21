import java.io.File;
import java.util.Scanner;

public class MaxSequence {

		
	public static int[] v ;
	
	
	public static Sequence maxSequence(int[]v, int lower,int upper){
		
		int m = lower + (upper-lower)/2;
		
		if(lower>upper)
			return null;
		if(lower==upper)
			return new Sequence(lower, upper);
		
		Sequence leftSeq = maxSequence(v, lower, m-1);
		Sequence rightSeq = maxSequence(v,m+1,upper);
		System.out.println(v[m]);
		int i,sum =v[m],left=m,right=m;
		for(i=m-1;i>=lower;i--)
		{
			if(sum+v[i]>sum){
				sum+=v[i];
				left =i;}
			else break;
		}
				
		for(i=m+1;i<=upper;i++)
		{
			if(sum+v[i]>sum){
				sum+=v[i];
				right =i;
			}
				
			else break;
		}
		
		Sequence middleSeq = new Sequence(left,right);

		return maxSequence(maxSequence(leftSeq,rightSeq),middleSeq) ;
	}
	
	private static Sequence maxSequence(Sequence s1,Sequence s2){
		
		if(s2==null) 
			return s1;
		else if(s1==null)
			return s2;
		else if (s1.getSum(v)>=s2.getSum(v))
			return s1;
		else if(s2.getSum(v)>=s1.getSum(v))
			return s2;
		else return null;
	}
	
	private static void readData ( String filename ) {
		Scanner scanner = null;

		/* you should use try-catch for proper error handling! */
		try {

			scanner = new Scanner(new File(filename));

			/* read the array in which to look for data */
				String p = (scanner.nextLine());			// array length
				int n=Integer.valueOf(p);
				v = new int[n];
				for (int j=0;j<n;j++) {
					v[j] = Integer.valueOf(scanner.nextLine());
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/* trebuie sa inchidem buffered reader-ul */
			try {
				if (scanner != null) scanner.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {

		readData("date2.txt");
		System.out.println("Afisare vector:");
		
		for(int i=0;i<v.length;i++)
			System.out.printf("%d ",v[i]);
		System.out.println();

		System.out.println("Max sequence sum:");
		Sequence seq = maxSequence(v, 0,v.length-1);
		System.out.println("Max sequence sum: "+seq.getSum(v));
		System.out.println("Sequence: "+seq.getSequence(v));
	}

}
