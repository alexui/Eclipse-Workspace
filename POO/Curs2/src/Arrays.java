import java.lang.reflect.Array;


public class Arrays {

	public static void main(String[] args) {
		
		int[] v=new int[20];
		int[] w={1,2,3,4};
		int i=0;
		for(;i<w.length;i++)
			Array.setInt(v, i, w[i]);
		System.out.println("v[0]="+v[0]+v[1]);
	}
	
}
