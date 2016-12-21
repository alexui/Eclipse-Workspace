
public class Test2 {



	public static void main(String[] args) {

		Vector v = new Vector();
		int b[] = {1,2,3};
		v.setVector(b);
		System.out.println(v.toString());
		b[0]=10;
		System.out.println(v.toString());

	}

}
