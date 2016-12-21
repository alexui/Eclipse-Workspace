import java.io.*;

public class RabinKarpTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws java.io.IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce pattern: ");
		String pattern = br.readLine();
		System.out.println("Your pattern: "+pattern);
		System.out.println("Introduce text: ");
		String text = br.readLine();
		System.out.println("Your text: "+text);

		
		RabinKarp sort = new RabinKarp(pattern,256);
		System.out.println("hash: "+sort.hash("12"));
		System.out.println("Search result: "+sort.search(text));
		br.close();

	}

}
