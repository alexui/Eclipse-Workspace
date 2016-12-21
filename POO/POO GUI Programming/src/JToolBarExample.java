import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;


public class JToolBarExample {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		JToolBar tb = new JToolBar("my toolbar");

		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		
		tb.add(b1);
		tb.add(b2);
		tb.add(b3);
		tb.setOrientation(JToolBar.HORIZONTAL);
		tb.setAlignmentX(JToolBar.BOTTOM_ALIGNMENT);
		//tb.setFloatable(false);
		
		
		
		frame.add(tb);
		frame.setSize(400,400);
		frame.setVisible(true);
		JOptionPane.showMessageDialog(frame, "This is an error","Error", JOptionPane.ERROR_MESSAGE);
	}

}
