import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Turret {
	
	private int x, y;
	
	private static ArrayList<Point> points = new ArrayList<Point>();
	
	public Turret() {
		Random rand = new Random();
		
		if(rand.nextInt(10) > 5) {
			x = 48;
		}
		else
			x = 412;
		
		y = 648 + rand.nextInt(10)*48;
		
		boolean found = true;
		
		if(points.size() >= 1) {
			int x = 0;
			while(getBoolPoint(new Point(x, y))) {
				y = 648 + rand.nextInt(50)*48;
				x++;
				if(x > 10) {
					System.out.println("test");
					found = false;
					break;
				}
			}
		}
		if(found) {
			points.add(new Point(x, y));
		}
		
	}
	
	public boolean getBoolPoint(Point point) {
		for(int x = 0; x < points.size(); x++) {
			if(points.get(x).getX() == point.getX() &&
					(point.getY() < points.get(x).getY() + 48 && point.getY() > points.get(x).getY()) ||
					(point.getY() + 48 > points.get(x).getY() && point.getY() < points.get(x).getY())) {
				return true;
			}
		}	
		return false;
	}

	public int getY() {
		return y;
	}
	
	public void move() {
		if(y >= -48) {
			y -= 6;
		}
	}
	
	public void update() {
		move();
	}
	
	public void paint(Component ths, Graphics page) {
		page.setColor(Color.red);
		page.fillRect(x, y, 48, 48);
		page.setColor(Color.GREEN);
		page.drawRect(x, y, 48, 48);
	}

}
