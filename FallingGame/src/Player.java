import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class Player {
	
	private int x, y;
	private boolean left, right, up, down;
	
	
	public Player() {
		x = 250 - 72/2; 
		y = 0;
		left = false; 
		right = false;; 
		up = false;
		down = false;
	}
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveLeft() {
		left = true;
	}
	
	public void moveRight() {
		right = true;
	}
	
	public void moveDown() {
		down = true;
	}

	public void moveUp() {
		up = true;
	}
	
	public void stopLeft() {
		left = false;
	}
	
	public void stopRight() {
		right = false;
	}
	
	public void stopDown() {
		down = false;
	}

	public void stopUp() {
		up = false;
	}
	
	public void move() {
		
		if (left == true){
			if(this.x > 46) {
				this.x -= 6;
			}
		}
		if(right == true) {
			if(this.x < 386) {
				this.x += 6;
			}
		}
		if(down == true) {
			this.y += 6;
		}
		if(up == true) {
			this.y -= 6;
		}
		
		
	}
	
	public void paint(Component ths, Graphics page) {
		move();
		
		page.setColor(Color.blue);
		page.fillRect(x, y, 72, 36);
		
	}
	
	
	
	
	
	
	
}
