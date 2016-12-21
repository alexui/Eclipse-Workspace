package arrays;

public class testMyArrayList {

	public static void main(String[] args) {

		MyArrayList v = new MyArrayList();
		v.add(3); 
		v.add(5); 
		v.add(4);
		System.out.println(v.toString());
		System.out.println(v.get(0));
		System.out.println(v.get(1));
		System.out.println(v.get(2));
		System.out.println(v.get(3));
	}

}
