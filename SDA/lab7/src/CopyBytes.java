
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                {
                	System.out.print(c); System.out.print('!');
                	out.write(c);
         
                }
            }
        } 
        catch (FileNotFoundException e){
        	System.err.println("File not found.");
        	System.err.println(e.getMessage());
        }
        catch (IOException e)
        {
        	System.err.println(e.getMessage());
        }
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

