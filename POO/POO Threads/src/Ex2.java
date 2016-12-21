import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;


public class Ex2 {


	
	public static void main(String[] args) {

		long mil  = System.nanoTime();
		System.out.println("noroc");
		try {
			SwingUtilities.invokeAndWait(new PrintChar2('d', 20));
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(System.nanoTime()-mil);
		
		SwingUtilities.invokeLater(new PrintInt('d', 20));

		System.out.println("salut");
	}

}
