
public class OInstanta {

	private int i;
	private OInstanta()
	{
		this.i=2;
	}
	private static final OInstanta INSTANTA =new OInstanta();
	
	static int getInst()
	{
		return INSTANTA.i;
	}
	
	public static void main(String args[])
	{
		int a=OInstanta.getInst();
		System.out.println(a);
		Cell c = new Cell();
		c.a=122;
		c.b=222;
		Cell myc = c;
		System.out.println(myc.a);
		myc.a=2221;
		System.out.println(myc.a);
		System.out.println(c.a);

	}
}
