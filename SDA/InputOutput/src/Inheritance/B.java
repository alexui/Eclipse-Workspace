package Inheritance;

public class B extends A {

	private int c;
	public B(int a, int b, int c) {
		super(a, b);
		this.c=c;
	}

	@Override
	public void method1(){
		System.out.println("New Method1");
	}
	
	
	public void method2Reloaded(){
		System.out.println("New Method1");
	}
	
	@Override
	public int getIntVal(int y){
		return super.a-y;
	}
}
