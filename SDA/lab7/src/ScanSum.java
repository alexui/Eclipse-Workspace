import java.io.FileReader;
import java.text.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Locale;

public class ScanSum {

	public static void main(String[] args) throws IOException {

		Scanner s = null;
		double sum = 0;
		try {
			s = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
			s.useLocale(Locale.CANADA);
			while (s.hasNext()) {
				if (s.hasNextDouble())
					sum += s.nextDouble();
				else
					s.next();
			}
		} catch (FileNotFoundException e) {
			System.out.println("unexisting file");
		} finally {
			if (s != null) {
				s.close();
			}
		}
		DecimalFormat df = new DecimalFormat("#.##\n");
		System.out.format("Sum: %.2f%n", sum);
		System.out.print(df.format(sum));
		System.out.format("%1$+09.1f", sum);
	}

}
