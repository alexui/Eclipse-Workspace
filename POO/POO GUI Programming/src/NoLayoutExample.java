import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;




public class NoLayoutExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JButton button = new JButton("OK");
		JLabel label = new JLabel("Enter your name:");
		JTextField field = new JTextField("Type name here:");
		JCheckBox cb = new JCheckBox("Bold");
		
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setSize(700,600);
		
		JPanel panel1 = new JPanel();
		panel1.add(button);
		panel1.setSize(500,500);
		panel1.setBounds(1, 1, 90, 100);
		
		JPanel panel2 = new JPanel();
		panel2.add(label);
		panel2.setBounds(90, 6, 100, 30);
		
		JPanel panel3 = new JPanel();
		panel3.add(field);
		panel3.setBounds(9, 60, 300, 300);	
		
		JFrame frame = new JFrame("Test frame.");
		frame.setLayout(null);
		
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		
		frame.setVisible(true);
		
	}

}
