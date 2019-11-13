import java.awt.Toolkit;

import javax.swing.JFrame;

/*
 * Project6_1.java -- Displays a window with a button that when clicked will display a number between 1 - 100
 * Jason Melnik
 * CSC 120
 * 11/07/2018
 */
public class GinzaPlatform{
	public static void main(String[] args) {
		JFrame frame = new JFrame("GinzaPlatform!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\PlatForm_Resources\\Images\\GP.png"));
		
		frame.getContentPane().add(new GinzaPanel());
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
