package GUI.menus;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PopupMenuDemo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1083981843393444571L;
	private JPopupMenu jPopupMenu1 = new JPopupMenu();
	private JMenuItem jmiNew = new JMenuItem("New", new ImageIcon(getClass()
			.getResource("/new.gif")));
	private JMenuItem jmiOpen = new JMenuItem("Open", new ImageIcon(getClass()
			.getResource("/open.gif")));
	private JMenuItem jmiPrint = new JMenuItem("Print", new ImageIcon(
			getClass().getResource("/print.gif")));
	private JMenuItem jmiExit = new JMenuItem("Exit");
	private JTextArea jTextArea1 = new JTextArea();

	public PopupMenuDemo() {
		jPopupMenu1.add(jmiNew);
		jPopupMenu1.add(jmiOpen);
		jPopupMenu1.addSeparator();
		jPopupMenu1.add(jmiPrint);
		jPopupMenu1.addSeparator();
		jPopupMenu1.add(jmiExit);
		jPopupMenu1.add(jmiExit);

		add(new JScrollPane(jTextArea1), BorderLayout.CENTER);
		jTextArea1.setComponentPopupMenu(jPopupMenu1);

		jmiNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process New");
			}
		});
		jmiOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process Open");
			}
		});
		jmiPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process Print");
			}
		});
		jmiExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		JFrame frame = new PopupMenuDemo();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("PopupMenuDemo");
		frame.setSize(400, 320);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
