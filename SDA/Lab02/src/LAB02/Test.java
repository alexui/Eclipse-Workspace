package LAB02;


public class Test {
	private int x;
	private static int y;
	
	//Constructor care primeste 2 nr intregi si initializeaza cele 2 campuri ale clasei
	public Test(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void afis() {
		System.out.println(x + " " + y);
	}
	
	public static void main(String[] args) {
		Test t1, t2;
		System.out.println("EX 7:");
		t1 = new Test(3,6); // x=3, y=6
		t2 = new Test(5,12); //x=5, y=12
		t1.afis();
		t2.afis();
		// Concluzie: y este acelasi pt ambele instante(obiecte), deoarece fiind static nu depinde de instanta
	}

}
