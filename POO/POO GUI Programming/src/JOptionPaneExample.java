import javax.swing.JButton;
import javax.swing.JOptionPane;


public class JOptionPaneExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JButton button = new JButton("sal");
		JOptionPane jop = new JOptionPane();
		String string = jop.showInputDialog("Enter input :");
		jop.showMessageDialog(button,string);
	}

}
