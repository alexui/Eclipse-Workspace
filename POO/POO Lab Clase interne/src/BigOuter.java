
public class BigOuter {

	static class Nest{
		void go(){
			System.out.println("Hi");
		}
	}
	
}

class Outer {

	class Nest{
		void go(){
			System.out.println("Hi");
		}
	}
	
}

class Broom{
	static class B2{
		void goB2(){
			System.out.println("Hi2");
		}
		
		static void goB3(){
			System.out.println("Hi3");
		}
	}
	
	public static void main(String[] args) {
		
		BigOuter.Nest n = new BigOuter.Nest();
		n.go();
		
		Outer o = new Outer();
		Outer.Nest p =o.new Nest();
		p.go();
		
		B2 b = new B2();
		b.goB2();
		B2.goB3();

		
	}
}