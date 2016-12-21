
public class class2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello, World");
		int a=6,i;
		int b=12,s=a+b;
		float c=4.567f,k=6.5690f;
		long d=567L,e=890L,f;
		short p=4,n=14;
		double v=56.8908d,u=52.1234,jj,w;
		
		System.out.println("Suma numerelor a si b este: "+ s);
		System.out.println("Suma numerelor c si k este: "+ (c+k));
		System.out.println("Diferenta numerelor d si e este: "+ (d-e));
		System.out.println("n/p este: "+ (n/p));
		System.out.println("Produsul numerelor v si u este: "+ (v*u));
		System.out.println("Suma numerelor c si k convertita la int este: "+ (int)(c+k));
		
		jj=d+e-a-2*p;
		f=d+e-a-2*p;
		System.out.println("jj="+ jj);
		System.out.println("f="+ f);
		w=v+c+a;
		System.out.println("w="+ w);
		
		int[] vector;
		vector=new int[20];
		vector[0]=5;
		vector[1]=4;
		vector[2]=6;
		vector[3]=12;
		System.out.println("min="+Math.min(12,35));
		for(i=0;i<4;i++)
		{
			System.out.print(vector[i]+ " ");
		}
		
		char character='s';
		System.out.println("char="+ character);
	}

}
