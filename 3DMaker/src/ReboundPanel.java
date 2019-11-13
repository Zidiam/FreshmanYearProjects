import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class ReboundPanel extends JPanel{
	private static final int D_W = 450;
    private static final int D_H = 450;
    private static final int movementX = 1;
    private ArrayList<Cube> cubeList;
    private int speed = 75;
    private int z;
	private Timer timer;
	
	public ReboundPanel() {
		z = 0;
		cubeList = new ArrayList<Cube>();
    	Cube cube = new Cube(125, 125, z, 200);
        cubeList.add(cube);
		
		addKeyListener(new DirectionListener());
		timer = new Timer(speed, new ReboundListener());
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(D_W, D_H));
		setFocusable(true);
		timer.start();
		
	}
	
	private class DirectionListener implements KeyListener{
		public void keyPressed(KeyEvent event) {
			if(event.getKeyCode() == KeyEvent.VK_A) {
				for(Cube cube : cubeList) {
					cube.shiftLeft(movementX);
				}
			}
			
			if(event.getKeyCode() == KeyEvent.VK_D) {
				for(Cube cube : cubeList) {
					cube.shiftRight(movementX);
				}
			}
			
			if(event.getKeyCode() == KeyEvent.VK_W) {
				z ++;
				for(Cube cube : cubeList) {
					cube.setZ(z);
				}
			}
			
			if(event.getKeyCode() == KeyEvent.VK_S) {
				z--;
				for(Cube cube : cubeList) {
					cube.setZ(z);
				}
			}
			
			repaint();
		}
		public void keyTyped(KeyEvent event) {}
		public void keyReleased(KeyEvent event) {}
	}
	 public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        for(Cube cube : cubeList) {
	        	cube.drawCube(g);
	        }
	    }
	 
	 private class ReboundListener implements ActionListener
		{
			//--------------------------------------------------------------
			//  Updates the position of the image and possibly the direction
			//  of movement whenever the timer fires an action event.
			//--------------------------------------------------------------
			public void actionPerformed(ActionEvent event)
			{
				System.out.println(z);
			}
		}

    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }
	
}