import java.util.*;


public class SmartArrayRun {
	
	public static void main(String args[])
	{
		int i,n,nr,element;
		int[] M;
		Random r = new Random();
		Scanner scan=new Scanner(System.in);
		//n=(int)(Math.random()*20);
		
		n=r.nextInt(80-60+1)+60; //creere tablou M
		M=new int[n+1];
		for(i=0;i<n;i++)
			M[i]=r.nextInt(10-(-10)+1)-10;
		
		SmartArray a = new SmartArray(M); //instantiere obiect
		nr=a.GetNumarElemente();
		System.out.println(nr);
		a.ShowSmartArray();
		
		element=r.nextInt(10-(-10)+1)-10; //adaugare element
		a.Add(element);
		System.out.println("vector dupa inserare:");
		a.ShowSmartArray();
		
	/*	System.out.print("introduceti element de eliminat: "); //eliminare element
		element=scan.nextInt();
		a.Delete(element);
		System.out.println("vector dupa eliminare:");
		a.ShowSmartArray();*/

	//	a.Pairs();
		
		System.out.print("Apasati 1 pentru generarea de vectori ZeroSum : "); //zerosum
		element=scan.nextInt();
		if(element==1)
			a.ZeroSum();
		scan.close();
	}

}
