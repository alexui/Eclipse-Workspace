import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;




public class BoxLayoutExample2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JButton button = new JButton("OK");
		Label label = new Label("Enter your name:");
		TextField field = new TextField("Type name here:");
		Checkbox cb = new Checkbox("Bold");
		
		button.setHorizontalTextPosition(SwingConstants.LEFT);
		button.setHorizontalAlignment(SwingConstants.RIGHT);
		button.setBounds(0, 0, 90, 500);
		button.setSize(700, 30);
		
		JPanel panel1 = new JPanel();
		panel1.add(button);
		
		JPanel panel2 = new JPanel();
		panel2.add(label);
		
		JPanel panel3 = new JPanel();
		panel3.add(field);

		
		
		JFrame frame = new JFrame("Test frame.");
		
		
		Box box = Box.createHorizontalBox();
		Box.createGlue();
		box.add(panel1);
		
		frame.add(box);
		
		box.add(panel2);
		
		frame.add(box);
		
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		

		
		frame.setVisible(true);
	}

}
