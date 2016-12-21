
import java.util.Scanner;

public class problema1 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double[] v = new double[11];
		QuickSort sort1 = new QuickSort(5);
		ArraySel sort2 = new ArraySel(5);
	
		for (int i=0;i<10;i++)
		{
			System.out.println("Introduceti v["+i+"]:");
			v[i]= in.nextDouble();
			if(i<5)
				sort2.insert(v[i]);
			else 
				sort1.insert(v[i]);			
		}
	
		
		System.out.println("Vector nesortat: ");
		for (int i=0;i<10;i++)
		{
			System.out.println("v["+i+"]: "+v[i]);
		}
		
		sort2.selectionSort();
		sort1.quickSort();
		System.out.println("Vector sortat: ");
		sort2.display();
		sort1.display();
			
		in.close();
	}
	
	

}
