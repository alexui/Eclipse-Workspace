package GUI.events;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveMessageDemo extends JFrame {
	private static final long serialVersionUID = -3447611318011377279L;

	public MoveMessageDemo() {
		// Create a MovableMessagePanel instance for moving a message
		MovableMessagePanel p = new MovableMessagePanel("Welcome to Java");

		// Place the message panel in the frame
		setLayout(new BorderLayout());
		add(p);
	}

	/** Main method */
	public static void main(String[] args) {
		MoveMessageDemo frame = new MoveMessageDemo();
		frame.setTitle("MoveMessageDemo");
		frame.setSize(200, 100);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// Inner class: MovableMessagePanel draws a message
	static class MovableMessagePanel extends JPanel {
		private static final long serialVersionUID = 6034622748052065959L;

		private String message = "Welcome to Java";
		private int x = 20;
		private int y = 20;

		/** Construct a panel to draw string s */
		public MovableMessagePanel(String s) {
			message = s;
			addMouseMotionListener(new MouseMotionListener() {
				/** Handle mouse-dragged event */
				public void mouseDragged(MouseEvent e) {
					// Get the new location and repaint the screen
					x = e.getX();
					y = e.getY();
					repaint();
				}

				/** Handle mouse-moved event */
				public void mouseMoved(MouseEvent e) {
				}
			});
		}

		/** Paint the component */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString(message, x, y);
		}
	}
}
