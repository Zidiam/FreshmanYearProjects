//********************************************************************
//  ReboundPanel.java       Java Foundations
//
//  Represents the primary panel for the Rebound program.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class ReboundPanel extends JPanel
{
	private final int WIDTH = 768, HEIGHT = 512;
	private final int DELAY = 20, IMAGE_SIZE = 35;

	private Ball []balls;
	private Timer timer;
	
	private Matrix xforms;
	
	private boolean rotation = true;
	
	private double[][] transformation;
	
	private Matrix matrix = new Matrix();
	
	Random rand = new Random();
	
	//-----------------------------------------------------------------
	//  Sets up the panel, including the timer for the animation.
	//-----------------------------------------------------------------
	public ReboundPanel()
	{

		
		timer = new Timer(DELAY, new ReboundListener());

		balls = new Ball[10000];
		for (int i = 0; i < 10000; i++)
			balls[i] = new Ball(rand.nextInt(WIDTH), rand.nextInt(HEIGHT), "src//happyFace.jpg");

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		
		timer.start();
	}

	//-----------------------------------------------------------------
	//  Draws the image in the current location.
	//-----------------------------------------------------------------
	public void paintComponent(Graphics page)
	{
		Graphics2D page2d = (Graphics2D) page;
		super.paintComponent(page2d);
		for (Ball ball : balls)
			ball.paintMe(this, page2d);
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
			if (rotation == true){
				rotation = false;
				
				TransMatrix t = new TransMatrix(WIDTH/2, HEIGHT/2);
				TransMatrix nt = new TransMatrix(-WIDTH/2, -HEIGHT/2);
				RotMatrix rm = new RotMatrix(Math.PI/(rand.nextInt(100) + 100));
				
				double[][] translation = t.getTransMatrix();
				double[][] negtranslation = nt.getTransMatrix();
				double[][] rotation = rm.getRotMatrix();
				
				transformation = matrix.matrixMultiply(matrix.matrixMultiply(translation, rotation), negtranslation); 
				
			}
			for (Ball ball : balls) {
				double[] vector = {ball.x, ball.y, 1};
				double[] location = matrix.vectorMultiply(vector, transformation);
				ball.x = location[0];
				ball.y = location[1];
			}
			repaint();
		}
	}
}
