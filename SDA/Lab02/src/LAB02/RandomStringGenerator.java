package LAB02;

import java.util.Random;
 // Generare de String-uri aleatoare

public class RandomStringGenerator {
	
	private int lg;
	private char[] alfabet;
	
	// Constructor care primeste lungimea sirului si alfabetul sub forma de String
	public RandomStringGenerator(int lg, String alfabet ) {
		this.lg = lg;
		this.alfabet = alfabet.toCharArray();
	}
	
	// O metoda next() care va returna un nou String(aleator), folosind lungimea si alfabetul
	// primite de constructor. Se iau caractere random din alfabet si se concateneaza la output.
	 
	public String next() {
		if (this.lg > 0 && this.alfabet != null) {
			String out = "";
			Random gt = new Random();
			int i;
			for (i = 0; i < lg; i++)
				out += alfabet[gt.nextInt(alfabet.length)];
			return out;
		}
		return null;
	}
	

	
	public static void main(String[] args) {
		RandomStringGenerator myGen = new RandomStringGenerator(5, "algahbet");
		System.out.println("Apel ex 5: ");
		System.out.println("String-uri generate random: ");
		System.out.println(myGen.next());
		System.out.println(myGen.next());
		
	}

}
