/*
 * JavaBall.java -- ball class for ReboundRevamped.java
 * Jason Melnik
 */
import java.awt.*;
import javax.swing.*;
import java.util.Random;
public class JavaBall {
	
	//static class constants
	public static final int SIZE = 35;
	public static final ImageIcon image = new ImageIcon("src//happyFace.gif");
	public static Random rand = new Random();
	
	//local attributes (state variables) of each object
	private double x, y, dx, dy;
	private boolean isAlive;
	private GraphicsPanel env;
	
	public JavaBall(GraphicsPanel env, double x, double y, double dx, double dy) {
		this.env = env;
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		isAlive = true;
	}
	
	public JavaBall(GraphicsPanel env) {
		this.env = env;
		x = rand.nextInt(env.WIDTH - SIZE);
		y = rand.nextInt(env.HEIGHT - SIZE);
		this.dx = rand.nextInt(10);
		this.dy = rand.nextInt(10);
	}
	
	public void paint(Graphics g) {
		if(isAlive)
			image.paintIcon(env, g, (int) x, (int) y);
	}
	
	public void update() {
		if(rand.nextDouble() <= 0.01) {
			isAlive = true;
		}
		
		dy += env.ACC_G;
		
		x += dx;
		y += dy;
		
		if(x < 0) {
			dx = Math.abs(dx)*env.elasticity;
			x = 0;
		}
		if (x >= env.WIDTH-SIZE) {
			dx = -Math.abs(dx)*env.elasticity;
			x = env.WIDTH - SIZE -1;
		}

		if (y <= 0) {
			dy = Math.abs(dx)*env.elasticity;
			y = 0;
		}
		if(y >= env.HEIGHT-SIZE) {
			dy = -Math.abs(dy)*env.elasticity;
			y = env.HEIGHT - SIZE - 1;
		}
	}

	public boolean contains(double x2, double y2) {
		double d = Math.hypot(x -( x2 - SIZE/2), y - (y2-SIZE/2));
		return d < SIZE/2;
	}

	public void setAlive(boolean b) {
		isAlive = b;
	}
	
}
