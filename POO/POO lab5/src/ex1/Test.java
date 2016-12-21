package ex1;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			Array v = new Array(20);
			v.set(0, 2);
			v.set(1, 3);
			v.set(2, 5);
			v.set(3, 4);
			System.out.println(v.getNr_elem());
			System.out.println(v.toString());
			
			Iterator list = v.createIterator();
			System.out.println(list.hasNext());
			System.out.println(list.next());
			v.set(4, 2);
			v.set(5, 5);
			System.out.println(list.next());
			System.out.println(list.next());
			System.out.println(list.next());
			System.out.println(list.next());
			System.out.println(list.next());
			System.out.println(list.next());

	}

}
