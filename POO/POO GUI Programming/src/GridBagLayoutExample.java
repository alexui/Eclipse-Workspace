import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class GridBagLayoutExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test frame.");
		
		JButton button = new JButton("OK");
		Label label = new Label("Enter your name:");
		TextField field = new TextField("Type name here:");
		Checkbox cb = new Checkbox("Bold");
		
		
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.add(button);
		
		JPanel panel2 = new JPanel();
		panel2.add(label);
		
		JPanel panel3 = new JPanel();
		panel3.add(field);

		GridBagLayout grid = new GridBagLayout();
		frame.setLayout(grid);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);


	//	grid.columnWeights=new double[] {190,190,190};
	//	grid.columnWidths=new int[] {400,4,4};
	//	grid.rowWeights=new double[] {900,90,90};
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 100;      //make this component tall
	    c.ipadx = 100;
	    c.weightx = 160.0;
	    c.gridwidth = 60;
	    c.weightx=100;
	    c.weighty=100;
	    c.gridx = 0;
	    c.gridy = 1;
	    c.insets = new Insets(50,50,50,50);
	//	grid.setConstraints(frame.getContentPane(), gridOptions);
		frame.getContentPane().add(panel1,c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 100;      //make this component tall
	    c.ipadx = 100;
	    c.weightx = 160.0;
	    c.gridwidth = 60;
	    c.weightx=100;
	    c.weighty=100;
	    c.gridx = 0;
	    c.gridy = 2;
		frame.getContentPane().add(panel3,c);

		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.insets=new Insets(20, 20, 0, 20);
	    c.gridx = 0;
	    c.gridy = 0;
	//	grid.setConstraints(frame.getContentPane(), gridOptions);
		frame.getContentPane().add(panel2,c);
/*		frame.setLayout(grid);
		
		
		frame.getContentPane().add(panel1, gridOptions);
		
	//	frame.add(panel2);
	//	frame.add(panel3);*/
		
		
	
		frame.pack();
		frame.setVisible(true);
	}

}
