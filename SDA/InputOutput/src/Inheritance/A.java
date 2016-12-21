package Inheritance;

public class A {

	protected int a;
	public int b;
	
	public A(int a,int b){
		this.a=a;
		this.b=b;
	}
	
	public void method1(){
		System.out.println("Method1");
	}
	
	private void Method2(){
		System.out.println("Method2");
	}
	
	public int getIntVal(int x)
	{
		return a+x;
	}
	
	public void method3(){
		System.out.println("method3");
	}
}
