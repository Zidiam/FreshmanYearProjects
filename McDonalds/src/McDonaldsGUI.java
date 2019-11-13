import java.awt.Toolkit;

import javax.swing.JFrame;

public class McDonaldsGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("McDonalds");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new McDonaldsPanel());
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
