/*
 * JukeBox.java -- A program with a GUI that lets you choose between songs and either play or pause them with buttons or Keys
 * Jason Melnik
 * CSC 120
 * 11/18/2018
 */

import javax.swing.*;

/**
 * @author thall
 *
 */
public class JukeBox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		JFrame frame = new JFrame("Java Juke Box");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new JukeBoxControls());
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
