import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;


public class JMenuBarExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		
		JMenuBar mb = new JMenuBar();
		frame.setJMenuBar(mb);
	
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		
	
		mb.add(b1);
		mb.add(b2);
		mb.add(b3);
		frame.setVisible(true);

	}

}
