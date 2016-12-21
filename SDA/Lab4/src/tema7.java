import java.util.Scanner;

public class tema7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Insert a sentence which ends with'.':");
		Scanner in = new Scanner(System.in);
		String input = new String();
		do
		{
		input = in.next();
		Word w = new Word(input);
		int syllables = w.NumberOfSyllables();
		System.out.println(input+" : "+syllables);
		}
		while(!input.endsWith("."));
		in.close();
		
	}

}
