import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player {
	public static int px = Globals.screenWidth/2, py = Globals.screenHeight/2;
	private ImageIcon playerImg, healthImg;
	private boolean left, right, up, down;
	
	
	public Player() {
		left = right = up = down = false;
		images();
	}
	
	private void images() {
		playerImg = new ImageIcon("src//Images//littletimmy.png");
		healthImg = new ImageIcon("src//Images//health_bar_1.png");
	}
	
	public void setLeft(boolean a) {
		right = false;
		up = false;
		down = false;
		left = a;
		move();
	}
	
	public void setRight(boolean a) {
		right = a;
		left = false;
		up = false;
		down = false;
		move();
	}
	
	public void setUp(boolean a) {
		up = a;
		right = false;
		left = false;
		down = false;
		move();
	}
	
	public void setDown(boolean a) {
		down = a;
		right = false;
		up = false;
		left = false;
		move();
	}
	
	public void moveUp() {
		if(Globals.cy >= 0 || Globals.screenHeight/2 != py) {
			py -= 6;
		}
		else {
			Globals.cy += 6;
		}
	}
	
	public void moveDown() {
		if(Globals.cy <= -2004 || Globals.screenHeight/2 != py) {
			py += 6;
		}
		else {
			Globals.cy -= 6;
		}
	}

	public void moveRight() {
		if(Globals.cx <= -4020 || Globals.screenWidth/2 != px) {
			px += 6;
		}
		else {
			Globals.cx -= 6;
		}
	}

	public void moveLeft() {
		if(Globals.cx >= 0 || Globals.screenWidth/2 != px) {
			px -= 6;
		}
		else {
			Globals.cx += 6;
		}
	}
	
	public void move() {
		if(right == true) {
			moveRight();
		}
		if(left == true) {
			moveLeft();
		}
		if(up == true) {
			moveUp();
		}
		if(down == true) {
			moveDown();
		}
	}
	
	public void look() {
		int lookx, looky;
		lookx = looky = 0;
		if(right = true) {
			lookx = px + 24;
			looky = py + 24;
		}
		if(left = true) {
			lookx = px - 24;
			looky = py + 24;	
		}
		if(down = true) {
			lookx = px;
			looky = py + 48 + 24;
			
		}
		if(up = true) {
			lookx = px;
			looky = py + 24 + 48;
		}
		
		for(int x = 0; x < Globals.mineable.size(); x++) {
			if(Globals.mineable.get(x).canMine(lookx, looky)) {
				System.out.println("test");
			}
		}
		
	}
	
	public void paint(Component ths, Graphics page) {
		playerImg.paintIcon(ths, page, px, py);
		healthImg.paintIcon(ths, page, 0, 490);
		look();
	}
	
}
