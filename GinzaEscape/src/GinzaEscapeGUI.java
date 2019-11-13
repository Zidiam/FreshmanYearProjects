import java.awt.Toolkit;

import javax.swing.JFrame;

public class GinzaEscapeGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("GinzaEscape");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new GinzaEscapePanel());
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
