
class A {
	private int x = 5;

	private void hidden() {
		System.out.println("hidden from A");
		System.out.println(x);
	}

	public void show_hidden() {
		hidden();
	}

	public String getName() {
		return " " + x;
	}
}

class B extends A {
	public int x = 10;

	public void hidden() {
		System.out.println("hidden from B");
		System.out.println(x);
	}

	public String getName() {
		return " " + x;
	}
}

public class MyClass {

	private int id;

	public MyClass(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		MyClass newObj = (MyClass) obj;
		return newObj.id == id;
	}

	public String printInfo(A a) {
		return "A " + a.getName();
	}

	public String printInfo(B b) {
		return "B " + b.getName();
	}

	public static void main(String[] args) {
		MyClass class1 = new MyClass(3);
		MyClass class2 = new MyClass(new Integer(3));

		if (class1.equals(class2))
			System.out.println("Obiectele sunt egale");
		else
			System.out.println("Obiectele difera");

		B b = new B();
		b.show_hidden();
		b.hidden();

		System.out.println("Ex 2:");

		A a1 = new A();
		B b1 = new B();

		System.out.println(class1.printInfo(a1) + "; " + class1.printInfo(b1));
	}
}
