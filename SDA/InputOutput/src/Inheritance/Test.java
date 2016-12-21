package Inheritance;

public class Test {

	public static void main(String[] args) {
		
		A a = new A(2,5);
		a.method1();
		System.out.println(a.a);
		
		B b = new B(1,2,3);
		b.method1();
		
		a.method3();
		b.method3();
	}
}
