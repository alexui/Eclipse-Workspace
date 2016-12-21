
public class A extends Abstr{

	private int a = 3;
	private int b=4;
	
	public A(){
		
	}
	
	public A(int a,int b){
		
		this.a=a; this.b=b;
	}
	
	public void print()
	{
		System.out.println("a="+this.a+" b="+this.b);
	}
}
