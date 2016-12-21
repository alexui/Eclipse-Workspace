package LAB02;

public class Poligon {
	private Punct[] points;

	// Constructor ce aloca spatiu pentru n puncte(n = nr de puncte)
	public Poligon(int nr) {
		points = new Punct[nr];
	}
	
	// Constructor ce primeste un vector de coordonate (se presupune ca sunt 6)
	// v = vector de coordonate
	public Poligon(float[] v) {
		this(3);
		int i;
		for(i=0; i<6; i+=2) {
			points[i/2] = new Punct(v[i], v[i+1]);
		}	
	}
	
	// Afisare a coordonatelor triunghiului 
	public String afisare() {
		String out = " ";
		int i; 
		for(i=0; i<points.length; i++) {
			//out+=points[i];
			out = out + points[i].x + points[i].y; 
		}
		return out;
	}
	
	public static void main(String[] args) {
		Poligon tr;
		float v[]={1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f};
		tr = new Poligon(v);
		System.out.println(tr.afisare());

	}

}
