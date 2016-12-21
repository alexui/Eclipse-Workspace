package GUI.menus;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class ToolBarDemo extends JFrame {
	private static final long serialVersionUID = -4214376701680041367L;

	private JButton jbtNew = new JButton(new ImageIcon(getClass().getResource(
			"/new.gif")));
	private JButton jbtOpen = new JButton(new ImageIcon(getClass().getResource(
			"/open.gif")));
	private JButton jbPrint = new JButton(new ImageIcon(getClass().getResource(
			"/print.gif")));

	public ToolBarDemo() {
		JToolBar jToolBar1 = new JToolBar("My Tool Bar");
		jToolBar1.setFloatable(false);
		jToolBar1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jToolBar1.add(jbtNew);
		jToolBar1.add(jbtOpen);
		jToolBar1.add(jbPrint);

		jbtNew.setToolTipText("New");
		jbtOpen.setToolTipText("Open");
		jbPrint.setToolTipText("Print");

		jbtNew.setBorderPainted(false);
		jbtOpen.setBorderPainted(false);
		jbPrint.setBorderPainted(false);

		add(jToolBar1, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		JFrame frame = new ToolBarDemo();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("ToolBarDemo");
		frame.setSize(400, 320);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
