import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Map1 {
	private ImageIcon background;
	private SmallRock rock;
	
	
	public Map1() {
		background = new ImageIcon("src//Images//map1_background.png");
		rock = new SmallRock(2520, 1260);
		Globals.mineable.add(rock);
	}
	
	public void paint(Component ths, Graphics page) {
		background.paintIcon(ths, page, Globals.cx, Globals.cy);
		rock.paint(ths, page);
	}
}
