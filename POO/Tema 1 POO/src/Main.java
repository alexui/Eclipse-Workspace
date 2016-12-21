/**
 * 
 * Clasa Main
 * 
 * @author Andru
 *
 */
public class Main {
	
	/**
	 * 
	 * Metoda main
	 * 
	 * @param args
	 * Argumentele primite de program
	 */
	public static void main(String[] args) {
		Dictionary d = new Dictionary(args[0]);
		System.out.println("Avem " + d.getnumEntries() + " intrari in dictionar");		
	}

}
