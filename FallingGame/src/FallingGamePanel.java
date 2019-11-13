import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FallingGamePanel extends JPanel{
	private final int WIDTH = 498, HEIGHT = 600;
	private int speed = 1;
	
	private Timer timer;
	
	private Player player;
	
	private MapGenerator mapGen;
	
	public FallingGamePanel() {
		
		addKeyListener(new DirectionListener());
		timer = new Timer(speed, new ReboundListener());
		
		player = new Player();
		
		mapGen = new MapGenerator();
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		timer.start();
		
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		mapGen.paint(this, page);
		player.paint(this, page);
	}
	private class DirectionListener implements KeyListener{
		public void keyPressed(KeyEvent event) {
			if(event.getKeyCode() == KeyEvent.VK_A) {
				player.moveLeft();
			}
			if(event.getKeyCode() == KeyEvent.VK_D) {
				player.moveRight();
			}
			if(event.getKeyCode() == KeyEvent.VK_W) {
				player.moveUp();
			}
			if(event.getKeyCode() == KeyEvent.VK_S) {
				player.moveDown();
			}
		}
		public void keyTyped(KeyEvent event) {}
		public void keyReleased(KeyEvent event) {
			if(event.getKeyCode() == KeyEvent.VK_A) {
				player.stopLeft();
			}
			if(event.getKeyCode() == KeyEvent.VK_D) {
				player.stopRight();
			}
			if(event.getKeyCode() == KeyEvent.VK_W) {
				player.stopUp();
			}
			if(event.getKeyCode() == KeyEvent.VK_S) {
				player.stopDown();
			}
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
			mapGen.update();
			repaint();
		}
	}
}
	
	

