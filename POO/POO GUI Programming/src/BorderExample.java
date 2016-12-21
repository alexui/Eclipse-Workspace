import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;


public class BorderExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame("my frame");
		
		JPanel panel = new JPanel();
	//	panel.setBorder(new Border("My Panel"));
		panel.setBorder(new LineBorder(new Color(5).darker(), 20));
		panel.setBackground(Color.DARK_GRAY);
		panel.setSize(300, 300);
		frame.setLayout(null);
		
		
		
		JPanel p1 = new JPanel();
		p1.setBounds(40, 20, 300, 200);
		JButton button = new JButton("salut");
		button.setBounds(0, 0, 500, 50);
		button.setSize(300, 70);
		button.setHorizontalAlignment(JButton.LEFT);
		
		p1.setLayout(null);
		p1.add(button);
		
		JPanel p2 = new JPanel();
		p1.setBackground(Color.blue);
		p2.setBackground(Color.white);
		
		JSplitPane  sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, p1, p2);
		sp.setBounds(40, 20, 600, 600);
		sp.setDividerLocation(200);
		sp.setDividerSize(5);
		sp.setEnabled(false);
		//sp.setBorder(new TitledBorder(new LineBorder(Color.black,50), "String", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.BOTTOM));
		//sp.setBorder(new LineBorder(Color.black, 80));
		//sp.setBorder(new EmptyBorder(new Insets(100, 100, 100, 100)));
		//sp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.red, Color.green));
		//sp.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.CYAN,Color.red));
		//sp.setBorder(new MatteBorder(new Insets(40, 20, 40, 20), Color.red));
		//sp.setBorder(new CompoundBorder(new MatteBorder(new Insets(40, 20, 40, 20), Color.red) ,new LineBorder(Color.black, 80)));
		
		panel.setBounds(40, 40, 200, 200);
		frame.setSize(700,700);
		//frame.add(panel);
		frame.add(sp);
		frame.setVisible(true);
	}

}
