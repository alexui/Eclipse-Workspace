import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class FrameExample {

	public static void main(String[] args) {

		JButton button = new JButton("sal");
		button.setSize(100, 100);
		JLabel label = new JLabel("Enter your name:");
		JTextField field = new JTextField("Type name here:");
		JCheckBox cb = new JCheckBox("Bold");
		JRadioButton rb = new JRadioButton("Red");
		JComboBox<String> cbox = new JComboBox<String>(new String[]{"red","blue","green"});
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(9, 0, 0));
		panel.add(cb);
		
		JFrame frame = new JFrame();
		JFrame frame2 = new JFrame();
		panel.setBackground(Color.blue);
		
		frame.add(cb);
	//	frame2.add(frame); 	nu se poate adauga frame in frame
	//	frame.add(button);
	//	frame.add(field);
		
		
		frame.setSize(200,200);
		frame2.setSize(400, 400);
		frame2.setVisible(true);
		frame.setVisible(true);
	}

}
