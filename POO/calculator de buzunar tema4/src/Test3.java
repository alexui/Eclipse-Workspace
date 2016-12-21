import java.util.ArrayList;


public class Test3 {

	public class UnaryOperators{
		
		public ArrayList<String> list;
		
		public UnaryOperators(){
			
			list = new ArrayList<String>();
			list.add("sin");
			list.add("log");
			list.add("sqrt");
			list.add("cos");
		}
	}
	
	UnaryOperators o = new UnaryOperators();
	
	public static void main(String[] args) {

		Test3 t = new Test3();
		System.out.println("hello");
		String s = "sino";
		System.out.println(t.o.list.contains(s));
		
	}

}
