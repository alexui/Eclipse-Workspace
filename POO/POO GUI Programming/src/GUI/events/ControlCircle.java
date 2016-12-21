package GUI.events;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlCircle extends JFrame {
	private static final long serialVersionUID = 8971647435260185491L;

	private JButton jbtEnlarge = new JButton("Enlarge");
	private JButton jbtShrink = new JButton("Shrink");
	private CirclePanel canvas = new CirclePanel();

	public ControlCircle() {
		JPanel panel = new JPanel(); // Use the panel to group buttons
		panel.add(jbtEnlarge);
		panel.add(jbtShrink);

		this.add(canvas, BorderLayout.CENTER); // Add canvas to center
		this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame

		jbtEnlarge.addActionListener(new Listener());
		jbtShrink.addActionListener(new Listener());
	}

	/** Main method */
	public static void main(String[] args) {
		JFrame frame = new ControlCircle();
		frame.setTitle("ControlCircle2");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}

	class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println(new java.util.Date(e.getWhen()));
			if (e.getSource() == jbtEnlarge)
				canvas.enlarge();
			else if (e.getSource() == jbtShrink)
				canvas.shrink();
		}
	}
}

class CirclePanel extends JPanel {
	private static final long serialVersionUID = 2613066902885641492L;
	private int radius = 5; // Default circle radius

	/** Enlarge the circle */
	public void enlarge() {
		radius++;
		repaint();
	}

	/** Enlarge the circle */
	public void shrink() {
		radius--;
		repaint();
	}

	/** Repaint the circle */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius,
				2 * radius, 2 * radius);
	}
}