import javax.swing.JFrame;
import javax.swing.JInternalFrame;


public class JInternalFrameExample {

	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		JInternalFrame int1 = new JInternalFrame("Internal frame 1");
		int1.setSize(200, 200);
		int1.setVisible(true);
		
		JInternalFrame int2 = new JInternalFrame("Internal frame 2");
		int2.setSize(200, 200);
		int2.setVisible(true);
		
		frame.add(int1);
		frame.add(int2);
		
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}
