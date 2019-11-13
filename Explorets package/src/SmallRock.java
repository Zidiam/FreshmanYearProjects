import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class SmallRock {
	private ImageIcon face;
	private int x, y;
	
	public SmallRock(int x, int y) {
		face = new ImageIcon("src//Images//small_rock1.png");
		this.x = x;
		this.y = y;
	}
	
	public boolean canMine(int lx, int ly) {
		System.out.println("x: " + x + " y: " + y + " ly: " + (ly-Globals.cy) + " lx: " + (lx-Globals.cx));
		if(lx >= x && lx <- x + 24 &&
			ly >= y && ly <= y + 24) {
			return true;
		}
		
		
		return false;
	}
	
	public void paint(Component ths, Graphics page) {
		face.paintIcon(ths, page, x+Globals.cx, y+Globals.cy);
	}
	
	
}
