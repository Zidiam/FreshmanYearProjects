/*
 * GCDandBlurbGUI.java -- Runs a GUI in which you can input two numbers to find the greatest common diviser or you can enter the amount of words you want to be created in Blurb
 * Jason Melnik
 * 9/12/2019
 */
import javax.swing.JFrame;
public class GCDandBlurbGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Greatest Common Divider Calculator and Blurb Word Maker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new GCDandBlurbPanel());
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
