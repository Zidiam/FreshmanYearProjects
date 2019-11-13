import javax.swing.JFrame;

public class DefaultGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Default Panel!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new DefaultPanelGUI());
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
