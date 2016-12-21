
import javax.swing.JOptionPane;


public class runAranjamente {


	public static void main(String[] args) {

		String s;
		final int I=0;
		final char C=' ';
		int n=5;
		int k;
		int[] array={1,2,3,4,5};
		char[] charArray = {'a','b','c','d','e'};
		Aranjamente p=new Aranjamente(n,I,array);
	//	System.out.println("Aranjamente de "+n+" luate cate :");
		s=JOptionPane.showInputDialog("Combinari de n luate cate:");
		k=Integer.parseInt(s);
		p.BackTrack(0,k);
		
		System.out.println("Characters:");
		
		Aranjamente c=new Aranjamente(n, C,charArray);
		c.BackTrack(0,k);
		
	}

}
