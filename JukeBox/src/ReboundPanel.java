/*
 * ReboundPanel.java -- This panel is what makes the face bounce around the small rectangle
 * Jason Melnik
 * CSC 120
 * 11/18/2018
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReboundPanel extends JPanel
{
	private final int WIDTH = 300, HEIGHT = 150;
	private final int DELAY = 20, IMAGE_SIZE = 35;

	private static ImageIcon image;
	private Timer timer;
	private int x, y, moveX, moveY;
	
	private static boolean pause = false;
	
	//-----------------------------------------------------------------
	//  Sets up the panel, including the timer for the animation.
	//-----------------------------------------------------------------
	public ReboundPanel()
	{
		
		timer = new Timer(DELAY, new ReboundListener());

		image = new ImageIcon("src/happyFace1.gif");
		
		x = 0;
		y = 40;
		moveX = moveY = 3;

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		timer.start();
	}
	
	public static void setFace(ImageIcon img) {
		image = img;
	}
	
	public static void setPause() {
		pause = !pause;
	}
	
	//-----------------------------------------------------------------
	//  Draws the image in the current location.
	//-----------------------------------------------------------------
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		image.paintIcon(this, page, x, y);
	}

	//*****************************************************************
	//  Represents the action listener for the timer.
	//*****************************************************************
	private class ReboundListener implements ActionListener
	{
		//--------------------------------------------------------------
		//  Updates the position of the image and possibly the direction
		//  of movement whenever the timer fires an action event.
		//--------------------------------------------------------------
		public void actionPerformed(ActionEvent event)
		{
			if (pause == false) {
				x += moveX;
				y += moveY;
	
				if (x <= 0 || x >= WIDTH-IMAGE_SIZE)
					moveX = moveX * -1;
	
				if (y <= 0 || y >= HEIGHT-IMAGE_SIZE)
					moveY = moveY * -1;
	
				repaint();
			}
		}
	}
}
