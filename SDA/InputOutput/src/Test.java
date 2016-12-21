
public class Test {

	public static void main(String[] args) {
		
		Abstr obj = new A();
		obj.print();
		
		Abstr obj2= new B();
		obj2.print();
		
		obj2=((B)(obj2)).change();
		obj2.print();
	}
	
}
