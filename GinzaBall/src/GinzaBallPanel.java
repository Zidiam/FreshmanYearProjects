import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GinzaBallPanel extends JPanel{
	private final int WIDTH = 250, HEIGHT = 492;
	private final int JUMP = 1;
	private int speed = 25;
	
	private final int IMAGE_SIZE = 12;
	
	private ImageIcon ballImg, spaceImg, wallImg;
	
	private Timer timer;
	
	private int x, y, points, wallTimer, ballTimer, wallCounter, ballCounter, downTimer, downCounter;
	
	private boolean left, right, down, gameOver = false;
	
	private Random rand = new Random();
	
	private Point ballCord = new Point();
	private Point wallCord = new Point();
	private Point spaceCord = new Point();
	private Point endCord = new Point();
	
	private ArrayList<Point> wallCords = new ArrayList<Point>();
	private ArrayList<Point> spaceCords = new ArrayList<Point>();
	
	public GinzaBallPanel() {
		endCord.setLocation(0, 444);

		addKeyListener(new DirectionListener());
		timer = new Timer(speed, new ReboundListener());
		
		ImageLoader();
		
		x = y = wallCounter = ballCounter = downCounter = 0;
		wallTimer = 20;
		ballTimer = 1;
		downTimer = 1;
		y = 35;
		
		ballCord.setLocation(x, y);
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		timer.start();
		
		level();
		
	}
	
	public void level() {
		//walls
		int counter = 48;
		for(int i = 0; i <= (HEIGHT/48); i++) {
			Point temp = new Point(0, counter);
			counter += 48;
			wallCords.add(temp);
		}
		
		//space
		counter = 48;
		for(int i = 0; i <= (HEIGHT/48); i++) {
			int random = rand.nextInt(WIDTH-24);
			Point temp = new Point(random, counter);
			counter += 48;
			spaceCords.add(temp);
		}
	}
	
	public void ImageLoader() {
		ImageIcon test = new ImageIcon("src\\ballImg.png");
		Image img = test.getImage();
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(img, 0, 0, IMAGE_SIZE, IMAGE_SIZE, null);
		ballImg = new ImageIcon(bi);
		
		test = new ImageIcon("src\\spaceImg.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 24, 24, null);
		spaceImg = new ImageIcon(bi);
		
		test = new ImageIcon("src\\wallImg.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, WIDTH, 24, null);
		wallImg = new ImageIcon(bi);
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		for(int i = 0; i < wallCords.size(); i++) {
			wallImg.paintIcon(this, page, wallCords.get(i).x, wallCords.get(i).y);
			spaceImg.paintIcon(this, page, spaceCords.get(i).x, spaceCords.get(i).y);
		}
		
		if(wallCords.get(0).getY() + 24 <= 0) {
			wallCords.remove(0);
			wallCords.add(new Point(0, 504));
			
			spaceCords.remove(0);
			int random = rand.nextInt(WIDTH-24);
			spaceCords.add(new Point(random, 504));
		}
		ballImg.paintIcon(this, page, ballCord.x, ballCord.y);
	}
	private class DirectionListener implements KeyListener{
		public void keyPressed(KeyEvent event) {
			switch(event.getKeyCode()) {
			case KeyEvent.VK_A:
				left = true;
				right = false;
				break;
			case KeyEvent.VK_D:
				left = false;
				right = true;
				break;
			}
			repaint();
		}
		public void keyTyped(KeyEvent event) {}
		public void keyReleased(KeyEvent event) {}
	}
	
	private class ReboundListener implements ActionListener
	{
		//--------------------------------------------------------------
		//  Updates the position of the image and possibly the direction
		//  of movement whenever the timer fires an action event.
		//--------------------------------------------------------------
		public void actionPerformed(ActionEvent event)
		{
			if (gameOver == false){
				counter();
				checkCollision();
				move();
				repaint();
			}
		}
	}
	
	private void checkCollision() {
		for(int i = 0; i < wallCords.size()-1; i++) {
			if(spaceCords.get(i).getY() == ballCord.getY() + IMAGE_SIZE &&
					spaceCords.get(i).getX()  - IMAGE_SIZE/2<= ballCord.getX() && 
					spaceCords.get(i).getX() + 24 >= ballCord.getX() + IMAGE_SIZE/2) {
				down = true;
				break;
			}
			else if(wallCords.get(i).getY() == ballCord.getY() + IMAGE_SIZE) {
				down = false;
				break;
			}
			else
				down = true;
		}
	}
	
	private void counter() {
		wallCounter ++;
		ballCounter ++;
		downCounter ++;
	}
	
	private void move() {
		if(downCounter >= downTimer) {
			downCounter = 0;
			if(down == true) {
				y += JUMP;
				Point temp = new Point(x, y);
				ballCord.setLocation(temp);	
			}
		}
		
		
		if(wallCounter >= wallTimer) {
			wallCounter = 0;
			for(int i = 0; i < wallCords.size(); i++) {
				wallCords.get(i).setLocation(0, wallCords.get(i).y - JUMP);
				spaceCords.get(i).setLocation(spaceCords.get(i).getX(), spaceCords.get(i).y - JUMP);
			}
			if(down == false) {
				y -= JUMP;
				Point temp = new Point(x, y);
				ballCord.setLocation(temp);
				System.out.println("test");	
			}
		}
		
		if (ballCounter >= ballTimer && left == true){
			ballCounter = 0;
			if (x > 0)
				x -= JUMP;
			Point temp = new Point(x, y);
			ballCord.setLocation(temp);
	}
		if (ballCounter >= ballTimer && right == true){
			ballCounter = 0;
			if (x < WIDTH-IMAGE_SIZE)
				x += JUMP;
			Point temp = new Point(x, y);
			ballCord.setLocation(temp);
		}
	}
}
	
	

