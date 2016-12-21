
public class ArithmeticE{

	
	int a;
	public void metoda(int b) {
	a=b;
	int c= 10;
	for(int d=0; d< 10; d++) {
	c--;
	}
	try {
	a= b/c;
	} catch(ArithmeticException e) {
	System.err.println(e.getMessage());
	}
	}
	
}

	
