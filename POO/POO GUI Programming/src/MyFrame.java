import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MyFrame{

	public static void main(String[] args) {

		JFrame frame = new JFrame("Test Frame.");
		frame.setSize(new Dimension(400, 600));
//		frame.setSize(400, 900); 
		//frame.setLocation(70, 100);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(0x9932cc));
		frame.getContentPane().setPreferredSize(new Dimension(100,100));
		
//		frame.pack();
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setMaximumSize(new Dimension(700,700));
		
		//Adding components
		
		JButton b = new JButton("OK");
		b.setBackground(Color.cyan);
		b.setSize(400, 400);
	//	frame.add(b);
		frame.getContentPane().add(b);
		frame.setVisible(true);
	}

}
