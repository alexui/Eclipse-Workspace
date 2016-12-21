package LAB02;


public class Punct {
	
	//private float x;
	//private float y;
		float x;
		float y;
	
	
	// Constructor ce primeste cele 2 nr reale(float) ce reprezinta coordonatele
	public Punct(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	// O metoda changeCoords ce primeste 2 nr reale si modifica cele 2 coordonate ale punctului
	public void changeCoords(float x, float y) {
		this.x = x;
		this.y = y;
		
	}
	
//	public void showPoint() {
//		System.out.println(this);
//	}
	
	
	// O functie de afisare a unui punct: "(x,y)"
	public String afisCoords() {
		return ("(" + x + "," + y + ")");
	}
	
	public static void main(String[] args) {
	Punct p;
	p = new Punct(3,5);
	p.changeCoords(4,9);
	//p.showPoint();
	System.out.println(p.afisCoords());
	}

}
