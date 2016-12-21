import java.util.Scanner;


public class insert {

	/**
	 * @param args
	 * 
	 * 
	 */
	public static void selectionSort(angajat a[],int nElems)
	{
	int[] index = new int[7];
	int out, in, min;
	for(out=0; out<nElems-1; out++) // outer loop
	{
	min = out; // minimum
	for(in=out+1; in<nElems; in++) // inner loop
	if(a[in].salariu < a[min].salariu ) // if min greater,
	min = in; // we have a new min
	index[out]=min;
	} // end for(outer)
	} // end selectionSort()
	
	/*private static void swap(angajat a[],int one, int two)
	{
	angajat temp = a[one];
	a[one] = a[two];
	a[two] = temp;
	}*/
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int i;
		
		String nume , prenume;
		int varsta;
		double salariu; 
		
		angajat[] v = new angajat[7];
		System.out.println("Introduceti angajati: ");
/*		for (i=0;i<3;i++)
		{
			System.out.println("Introduceti date pentru angajat["+i+"]:");
			System.out.print("nume: "); nume=in.next(); 
			System.out.print("prenume: "); prenume=in.next(); 
			System.out.print("varsta: "); varsta=in.nextInt(); 
			System.out.print("salariu: "); salariu=in.nextDouble(); 
			v[i]= new angajat(nume,prenume,varsta,salariu);
			
		}
		*/
		
		v[0]= new angajat("Budau","Alex",19,245);
		v[1]= new angajat("Radu","Iuliana",6,98);
		v[2]= new angajat("Budau","George",15,95);
		v[3]= new angajat("Radu","Robert",25,245);
		
		System.out.println("Angajati introdusi: ");
		for (i=0;i<4;i++)
		{
			System.out.println("Angajat :"+i+": ");
			System.out.println("nume "+ v[i].nume);
			System.out.println("prenume :"+v[i].prenume);
			System.out.println("varsta :"+v[i].varsta);
			System.out.println("salariu :"+v[i].salariu);
		}
		
		selectionSort(v,7);
		in.close();
		
	}

}
