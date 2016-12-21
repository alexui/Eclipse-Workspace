
public class IntTest {// datele primitive se transmit prin valoare

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IntClass a=new IntClass();
		Integer b = new Integer(2);
		a.setA(b);
		System.out.println(a.getA());
		a.changeA();
		System.out.println(a.getA());
		b=9;
		System.out.println(a.getA());

		System.out.println("Integer");
		b = new Integer(2);
		IntegerClass c = new IntegerClass();
		c.setA(b);
		System.out.println(c.getA());
		c.changeA();
		System.out.println(c.getA());
		b = new Integer(9);
		System.out.println(c.getA());
		c.a=1;
		System.out.println(c.getA());
	}

}
