package GUI.events;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationDemo extends JFrame {
	private static final long serialVersionUID = -5329203657482399511L;

	public AnimationDemo() {
		// Create a MovingMessagePanel for displaying a moving message
		this.setLayout(new GridLayout(2, 1));
		add(new MovingMessagePanel("Object Oriented :)", 1000));
		add(new MovingMessagePanel("Programming!", 500));
	}

	/** Main method */
	public static void main(String[] args) {
		AnimationDemo frame = new AnimationDemo();
		frame.setTitle("AnimationDemo");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(280, 100);
		frame.setVisible(true);
	}

	// Inner class: Displaying a moving message
	static class MovingMessagePanel extends JPanel {
		private static final long serialVersionUID = 4112128353044173243L;

		private String message = "Welcome to Java";
		private int xCoordinate = 0;
		private int yCoordinate = 20;

		public MovingMessagePanel(String message, int delay) {
			this.message = message;

			// Create a timer
			Timer timer = new Timer(delay, new TimerListener());
			timer.start();
		}

		/** Paint message */
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (xCoordinate > getWidth()) {
				xCoordinate = -20;
			}
			xCoordinate += 5;
			g.drawString(message, xCoordinate, yCoordinate);
		}

		class TimerListener implements ActionListener {
			/** Handle ActionEvent */
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		}
	}

}
