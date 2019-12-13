//********************************************************************
//  Rebound.java       Java Foundations
//
//  Demonstrates an animation and the use of the Timer class.
//********************************************************************

import javax.swing.*;

public class ReboundRevamped
{
	//-----------------------------------------------------------------
	//  Displays the main frame of the program.
	//-----------------------------------------------------------------
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Rebound");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new GamePanel());

		frame.pack();
		frame.setVisible(true);
	}
}
