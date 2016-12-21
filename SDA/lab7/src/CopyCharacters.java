
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException  {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
            	{
            		outputStream.write(c);
            		outputStream.write('!');
            		System.out.print(c);
            		System.out.print('!');
            	}
            		
            	//outputStream.write(""+2+5);
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
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
