package LAB02;


public class Main {
	// Exercitiul 3
	
	// Metoda pt care masuram timpul( parametrul primitiv este boolean) 
	public static void f(boolean primitiv) {
		int x;
		Integer y;
		int i;
		for(i=0; i<10000; i++) {
			if(primitiv == true)
				x = 2 + 3;
			else 
				y = new Integer(2 + 3);
				
		}
	}
	
	// Masuram diferenta de viteza intre new Integer(2 + 3) si 2 + 3
	// primitiv -> operatia este primitiva sau nu
	public static long run(boolean primitiv) {
		long start = System.nanoTime();
		f(primitiv); 
		return System.nanoTime() - start;
	}
	
	// Exercitiul 4 
	
	// Masurarea consumului de memorie 
	public static void showUsedMemory() {
		long usedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println(usedMem);
	}
	
	// Verificam diferenta de memorie utilizata intre a folosi String literal "abc" 
	// si String obtinut prin constructor new String("abc")
	public static void Mem() {
		int N = 10000;
		String[] st  = new String[N]; // vector de string-uri 
		
		System.out.println("Before: ");
		showUsedMemory();
		for (int i = 0; i < N; i++) {
			st[i] = "abc";
		}
		System.out.println("After literal: ");
		showUsedMemory();
		
		for (int i = 0; i < N; i++) {
			st[i] = new String("abc");
		}
		System.out.println("After obiecte");
		showUsedMemory();
		
	}
	
	public static void main(String[] args) {
		// Apel ex 3
		System.out.println("Apel ex3:");
		System.out.println("Executia pentru 2 + 3 este : " + run(true));
		System.out.println("Executia pentru new Integer(2 + 3) este : " + run(false));
		
		// Apel ex 4
		System.out.println("Apel ex4: ");
		System.out.println("Memoria utilizata este: ");
		Mem();
		
	}

}
