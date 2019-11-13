/*
 * Rebound.java -- A program that makes a face jump around an inclosed box and can pause or play the motion and can change the faces
 * Jason Melnik
 * CSC 120
 * 11/18/2018
 */
import javax.swing.*;
import java.awt.*;

public class Rebound
{
	//-----------------------------------------------------------------
	//  Displays the main frame of the program.
	//-----------------------------------------------------------------
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Rebound");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ReboundPanel rebound = new ReboundPanel();
		ReboundControls controls = new ReboundControls(rebound);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(rebound);
		panel.add(controls);
		
		frame.getContentPane().add(panel);
		
		
		
		
		frame.pack();
		frame.setVisible(true);
	}
}
