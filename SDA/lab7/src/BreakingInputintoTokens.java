
import java.io.*;
import java.util.Scanner;

public class BreakingInputintoTokens {
    public static void main(String[] args) throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedInputStream(new FileInputStream("xanadu.txt")));
            s.useDelimiter("\n");
        //	s = new Scanner(new File("xanadu.txt"));
        //	s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        }
        catch (FileNotFoundException e)
        {
        	System.err.println(e.getMessage());
        }
        finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
