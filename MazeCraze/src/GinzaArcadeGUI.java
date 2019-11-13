import java.awt.Toolkit;

import javax.swing.JFrame;

public class GinzaArcadeGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("GinzaEscape");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new GinzaArcadePanel());
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
