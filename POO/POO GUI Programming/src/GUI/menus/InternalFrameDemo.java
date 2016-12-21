package GUI.menus;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class InternalFrameDemo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1968734477084704946L;
	// Create image icons
	private ImageIcon saveIcon = new ImageIcon(getClass().getResource(
			"/save.gif"));
	private ImageIcon openIcon = new ImageIcon(getClass().getResource(
			"/open.gif"));

	private JMenuBar jMenuBar = new JMenuBar();
	private JMenuItem jmiSave = new JMenuItem("Save");
	private JMenuItem jmiOpen = new JMenuItem("Open");

	// Create JDesktopPane to hold the internal frame
	private JDesktopPane desktop = new JDesktopPane();

	public InternalFrameDemo() {

		this.setSize(new Dimension(400, 300));
		this.getContentPane().add(desktop, BorderLayout.CENTER);

		JMenu jMenu = new JMenu("Options");
		jMenuBar.add(jMenu);
		jMenu.add(jmiSave);
		jMenu.add(jmiOpen);

		this.setJMenuBar(jMenuBar);

		jmiSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame internalFrame = new JInternalFrame("Save", true,
						true, true, true);
				internalFrame.setFrameIcon(saveIcon);
				internalFrame.setTitle("Save");
				internalFrame.add(new JLabel(saveIcon, JLabel.CENTER));
				internalFrame.setLocation(20, 20);
				internalFrame.setSize(200, 100);
				internalFrame.setVisible(true);
				desktop.add(internalFrame);
			}
		});

		jmiOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame internalFrame = new JInternalFrame("Save", true,
						true, true, true);
				internalFrame.setFrameIcon(openIcon);
				internalFrame.add(new JLabel(openIcon, JLabel.CENTER));
				internalFrame.setTitle("Open");
				internalFrame.setLocation(20, 20);
				internalFrame.setSize(200, 100);
				internalFrame.setVisible(true);
				desktop.add(internalFrame);
			}
		});
	}

	public static void main(String[] args) {
		JFrame frame = new InternalFrameDemo();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Show Internal Frames");
		frame.setSize(600, 420);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((d.width - frame.getSize().width) / 2,
				(d.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
}