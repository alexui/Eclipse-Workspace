import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class BoxLayoutExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Button button = new Button("OK");
		Label label = new Label("Enter your name:");
		TextField field = new TextField("Type name here:");
		Checkbox cb = new Checkbox("Bold");
		
		JPanel panel1 = new JPanel();
		panel1.add(button);
		
		JPanel panel2 = new JPanel();
		panel2.add(label);
		
		JPanel panel3 = new JPanel();
		panel3.add(field);

		
		
		JFrame frame = new JFrame("Test frame.");
		
		BoxLayout box = new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS);
		frame.setLayout(box);
		
		
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
	
	/*	box = new BoxLayout(frame.getContentPane(),BoxLayout.X_AXIS);
		frame.setLayout(box);

		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);*/
		
		frame.setVisible(true);
	}

}
