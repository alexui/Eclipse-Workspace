
public class runPermutari {

	
	
	public static void main(String[] args) {
		
		final int I=0;
		final char C=' ';
		int n=5;
		int[] array={1,2,3,4,5};
		char[] charArray = {'a','b','c','d','e'};
		Permutari p=new Permutari(n,I,array);
		p.BackTrack(0);
		
		System.out.println("Characters:");
		
		Permutari c=new Permutari(n, C,charArray);
		c.BackTrack(0);
		
	}

}
