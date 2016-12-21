
public class B extends Abstr{

	private String s = "Bau";
	private int d =3;
	private Abstr a;
	
	public B(){
		
	}
	
	public B(int d,String s){
		
		this.d=d;
		this.s=s;
	}
	
	public Abstr change()
	{
		a=new A();
		return a; 
	}
	
	public void print()
	{
		System.out.println("d="+this.d+" s="+this.s);
	}
}
