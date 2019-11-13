import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class MapGenerator {
	
	private ImageIcon sideWall, sideWall2;
	private int up, wall1, wall2, difficulty;
	private ArrayList<Turret> turrets = new ArrayList<Turret>();
	private Random rand = new Random();
	
	public MapGenerator() {
		sideWall2 = sideWall = new ImageIcon("src//Falling_Images//sidewall.png");
		up = wall1 = 0;
		difficulty = 2;
		wall2 = 620;
		
		Turret turret = new Turret();
		turrets.add(turret);
		
	}

	
	public void moveWall() {
		wall1 -= 6;
		wall2 -= 6;
		if(wall1 <= -620) {
			wall1 = 0;
			wall2 = 620;
		}
	}
	
	public void update() {
		up -= 6;
		moveWall();
		makeTurret();
	}
	
	public void makeTurret() {
		for(int x = 0; x < turrets.size(); x++) {
			turrets.get(x).update();
		}
		for(int x = 0; x < turrets.size(); x++) {
			if(turrets.get(x).getY() <= -48) {
				
				if(rand.nextInt(10) > 5) {
					difficulty += 1;
					Turret turret = new Turret();
					turrets.add(turret);
				}
				turrets.remove(x);
				turrets.add(new Turret());
			}
		}
		
	}
	
	public void paint(Component ths, Graphics page) {
		System.out.println(turrets.size());
		sideWall.paintIcon(ths, page, 0, wall1);
		sideWall.paintIcon(ths, page, 460, wall1);
		sideWall2.paintIcon(ths, page, 0, wall2);
		sideWall2.paintIcon(ths, page, 460, wall2);
		
		for(int x = 0; x < turrets.size(); x++) {
			turrets.get(x).paint(ths, page);
		}
	}
	
	
}
