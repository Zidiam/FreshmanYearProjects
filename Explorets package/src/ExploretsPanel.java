import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExploretsPanel extends JPanel{
	private final int WIDTH = 1008, HEIGHT = 504;
	private int speed = 75;
	
	private Timer timer;
	
	private Player player;
	
	private Map1 map1;
	
	private MenuScene menu;
	
	
	public ExploretsPanel() {
		menu = new MenuScene();
		
		map1 = new Map1();
		
		player = new Player();
		
		addKeyListener(new DirectionListener());
		timer = new Timer(speed, new ReboundListener());
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		timer.start();
		
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
        
		page.setColor(Color.CYAN);
		map1.paint(this, page);
		page.setColor(Color.BLACK);
		
		player.paint(this, page);
	}
	private class DirectionListener implements KeyListener{
		public void keyPressed(KeyEvent event) {
			if(event.getKeyCode() == KeyEvent.VK_W) {
				player.setUp(true);
			}
			if(event.getKeyCode() == KeyEvent.VK_S) {
				player.setDown(true);
			}
			if(event.getKeyCode() == KeyEvent.VK_A) {
				player.setLeft(true);
			}
			if(event.getKeyCode() == KeyEvent.VK_D) {
				player.setRight(true);
			}
			repaint();
		}
		public void keyTyped(KeyEvent event) {}
		public void keyReleased(KeyEvent event) {
			if(event.getKeyCode() == KeyEvent.VK_W) {
				player.setUp(false);
			}
			if(event.getKeyCode() == KeyEvent.VK_S) {
				player.setDown(false);
			}
			if(event.getKeyCode() == KeyEvent.VK_A) {
				player.setLeft(false);
			}
			if(event.getKeyCode() == KeyEvent.VK_D) {
				player.setRight(false);
			}
			repaint();
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
			
			repaint();
		}
	}
}
	
	

