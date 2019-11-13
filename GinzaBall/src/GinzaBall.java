/*
 * GinzaBall.java -- Arcade game with a ball
 * Jason Melnik
 * 11/5/2018
 */
import javax.swing.JFrame;
public class GinzaBall {
	public static void main(String [] args) {
		JFrame frame = new JFrame("GinzaBall!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new GinzaBallPanel());
		frame.pack();
		frame.setVisible(true);
	}
}