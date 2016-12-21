import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Choosers {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("frame");
		Color color = JColorChooser.showDialog(frame, "Color", Color.gray);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JColorChooser cc = new JColorChooser(color);	
		JFileChooser fc = new JFileChooser();
		
		JPanel pane1 = new JPanel();
		pane1.add(fc);
		
		JPanel pane2 = new JPanel();
		pane2.add(cc);
		frame.add(pane1);
		frame.add(pane2);
		frame.setSize(400,400);
		frame.setVisible(true);

		//fc.showOpenDialog(frame);
		fc.showSaveDialog(frame);
		
	}

}
