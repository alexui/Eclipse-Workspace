
public class TestReferinta {

	public void change(int b)
	{
		b=b+2;
		System.out.println("b="+b);
	}
	
	public static void main(String[] args) {
		
		TestReferinta Change = new TestReferinta();
		int a=2;
		Integer b=new Integer(6);
		Change.change(a);
		Change.change(b);
		System.out.println("a="+a+"\nb="+b);
	}
}
