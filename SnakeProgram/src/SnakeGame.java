import java.awt.Toolkit;

import javax.swing.JFrame;

/*
 * Project6_1.java -- Displays a window with a button that when clicked will display a number between 1 - 100
 * Jason Melnik
 * CSC 120
 * 11/07/2018
 */
public class SnakeGame{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Snake game!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new SnakeGamePanel());
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\GinzaSnakeIco.png"));

		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
