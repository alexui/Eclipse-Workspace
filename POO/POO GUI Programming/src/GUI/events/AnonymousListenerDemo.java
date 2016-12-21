package GUI.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnonymousListenerDemo extends JFrame {
	private static final long serialVersionUID = -667478805776126635L;

	public AnonymousListenerDemo() {
		// Create four buttons
		JButton jbtNew = new JButton("New");
		JButton jbtOpen = new JButton("Open");
		JButton jbtSave = new JButton("Save");
		JButton jbtPrint = new JButton("Print");

		// Create a panel to hold buttons
		JPanel panel = new JPanel();
		panel.add(jbtNew);
		panel.add(jbtOpen);
		panel.add(jbtSave);
		panel.add(jbtPrint);

		add(panel);

		// Create and register anonymous inner class listener
		jbtNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process New");
			}
		});

		jbtOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process Open");
			}
		});

		jbtSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process Save");
			}
		});

		jbtPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process Print");
			}
		});
	}

	/** Main method */
	public static void main(String[] args) {
		JFrame frame = new AnonymousListenerDemo();
		frame.setTitle("AnonymousListenerDemo");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
