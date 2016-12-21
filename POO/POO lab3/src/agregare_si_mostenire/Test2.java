package agregare_si_mostenire;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Stiva s= new Stiva(3);
		s.push(20);
		s.push(30);
		s.push(32);
		System.out.println(s.toString());
		s.print(s.pop());
		s.print(s.pop());
		s.print(s.pop());
		System.out.println("frate");
		
		Stiva t= new Stiva(5);
		t.push(3);
		t.push(2);
		t.push(4); t.push(4); t.push(4); t.push(4);
		System.out.println(t.toString());
	}

}
