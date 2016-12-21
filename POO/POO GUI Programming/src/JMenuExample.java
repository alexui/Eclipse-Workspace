import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLayer;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;


public class JMenuExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Action exitAction = new AbstractAction() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		};
		
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		
		JMenuBar mb = new JMenuBar();
		frame.setJMenuBar(mb);
	
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		
		JLayer l = new JLayer();
		l.setSize(2, 0);
		mb.add(b1);
		mb.add(b2);
		mb.add(b3);
		
		JMenu filemenu = new JMenu("File",false);
		JMenu helpmenu = new JMenu("Help",true);
		mb.add(filemenu);
		mb.add(helpmenu);
		
		JMenuItem open =new JMenuItem("open");
		JMenuItem new_ =new JMenuItem("new");
		JMenuItem exit =new JMenuItem(exitAction);
		exit.setActionCommand("exit");
		exit.setText("exit");
		exit.setAccelerator(KeyStroke.getKeyStroke('e'));
				
		filemenu.add(new_);
		filemenu.add(open);
		filemenu.addSeparator();
		filemenu.add(new JMenuItem("print"));
		filemenu.add(exit);
		filemenu.addSeparator();		
		
		
		JMenu softwarehelp = new JMenu("Software");
		JMenu hardwarehelp = new JMenu("Hardware");
		helpmenu.add(softwarehelp);
		helpmenu.add(hardwarehelp);
		helpmenu.add(new JCheckBoxMenuItem("alex"));
		
		JMenu colorHelp = new JMenu("Color");
		helpmenu.add(colorHelp);
		JRadioButtonMenuItem blue = new JRadioButtonMenuItem("blue");
		JRadioButtonMenuItem red = new JRadioButtonMenuItem("red");
		JRadioButtonMenuItem green = new JRadioButtonMenuItem("green");
		ButtonGroup bg = new ButtonGroup();
		bg.add(blue);
		bg.add(red);
		bg.add(green);
		colorHelp.add(blue);
		colorHelp.add(red);
		colorHelp.add(green);

		helpmenu.setMnemonic('H');
		//filemenu.setMnemonic('F');
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		new_.setAccelerator(KeyStroke.getKeyStroke('n'));
		
		JPanel panel= new JPanel();
		panel.setBackground(Color.white);
		frame.add(panel);
		
		JPopupMenu pm = new JPopupMenu();
	//	pm.add(open);
	//	pm.add(new_);
		frame.add(pm);
//		pm.show(panel, 90, 90);

		
		frame.setVisible(true);
	}

}
