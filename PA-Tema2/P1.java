import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class P1 {

	ArrayList<Integer> primes;

	public int getMaxPitiPrime(Long number){
		
		ArrayList<Integer> digits = new ArrayList<Integer>();
		
		while(number!=0){
			digits.add(new Integer((int) (number%10)));
			number/=10;
		}
		
		Integer res = new Integer(0);
		
		res = doBKT(res,digits);
		
		return res;
			
	}
		
	public static ArrayList<Integer> makeListCopy(ArrayList<Integer> cells) {

	        ArrayList<Integer> result = new ArrayList<Integer>();
	        for (Integer c : cells) {
	            result.add(new Integer(c.intValue()));
	        }
	        return result;
	}
	
	public boolean isPitiPrime(int n){
		
		if(Collections.binarySearch(primes, n)>=0)
			return true;
		return false;
	}
	
	public Integer doBKT(Integer result, ArrayList<Integer> cells){
		
		int max = result;
		
		boolean[] marked = new boolean[11];
		for(int i=1;i<11;i++)
			marked[i]=false;

		for(Integer c:cells){
			int temp;
			temp = result*10+c;
			if(isPitiPrime(temp) && !marked[c]){		
								
				ArrayList<Integer> cells_copy = makeListCopy(cells);
				cells_copy.remove(new Integer(c));
				marked[c]=true;
				
				int k = doBKT(temp,cells_copy);
				
				if(k>max)
					max=k;
			}
			
		}
		return max;
			
	}

	public void loadPitiPrimes(String filename){
		Scanner scanner = null;

		try {

			scanner = new Scanner(new File(filename));
			while(scanner.hasNext()){
				int i = scanner.nextInt();
				primes.add(i);
			}
						
				//pozitia 0 nu se completeaza
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
		
		P1 p = new P1();
		p.primes = new ArrayList<Integer>();
		p.loadPitiPrimes("prime.txt");
		
		
		Scanner scanner = null;
		PrintWriter pw=null;
		try {
			pw = new PrintWriter(new File ("pitiprim.out"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {

			scanner = new Scanner(new File("pitiprim.in"));
			
				int n = scanner.nextInt();
				//System.out.println(n);
				for(int i=0;i<n;i++){
					Long val = scanner.nextLong();
					//System.out.println(val);
					pw.print(p.getMaxPitiPrime(val));
					//System.out.println(p.getMaxPitiPrime(val));
					pw.println();
				}	
				
				//pozitia 0 nu se completeaza
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/* trebuie sa inchidem buffered reader-ul */
			try {
				if (scanner != null) scanner.close();
				if (pw!=null) pw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
