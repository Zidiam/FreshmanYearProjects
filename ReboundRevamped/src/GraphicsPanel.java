//********************************************************************
//  ReboundPanel.java       Java Foundations
//
//  Represents the primary panel for the Rebound program.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GraphicsPanel extends JPanel
{
	public final int WIDTH = 768, HEIGHT = 512;
	public final int DELAY = 20;
	public double elasticity = 1;
	
	public final double ACC_G = .5; //pixels per delay-time
	private Timer timer;
    
	private JavaBall ball;
	
	private JavaBall []ballArr;
	
	private GamePanel env;
	private int score;
	
	public int getScore() {
		return score;
	}

	//-----------------------------------------------------------------
	//  Sets up the panel, including the timer for the animation.
	//-----------------------------------------------------------------
	public GraphicsPanel(GamePanel env)
	{
		this.env = env;
		score = 0;
		timer = new Timer(DELAY, new ReboundListener());
		
		addMouseListener(new PopBalloonListener());
		ball = new JavaBall(this, 20, 30, 5, 3);
		
		ballArr = new JavaBall[5];
		
		for(int i = 0; i < 5; i++)
			ballArr[i] = new JavaBall(this);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		timer.start();
	}

	//-----------------------------------------------------------------
	//  Draws the image in the current location.
	//-----------------------------------------------------------------
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		for(JavaBall b : ballArr)
			b.paint(page);
		
		ball.paint(page);
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
			for(JavaBall b : ballArr)
				b.update();
			ball.update();

			repaint();
		}
	}
	
	private class PopBalloonListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			for(JavaBall b : ballArr) {
				if(b.contains(x, y)) {
					score++;
					b.setAlive(false);
				}
			}
			env.repaint();
		}
	}
}
