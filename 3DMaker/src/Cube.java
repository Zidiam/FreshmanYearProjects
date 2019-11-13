import java.awt.Graphics;
import java.awt.Point;

public class Cube {
        int x, y, size, z, permZ, x2, y2;
        double diagonal;
        Point[] cubeOnePoints;
        Point[] cubeTwoPoints;
        public Cube(int x, int y, int z, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            x2 = x + size/4;
            y2 = y + size/4;
            permZ = z;
            cubeOnePoints = getCubeOnePoints();
            cubeTwoPoints = getCubeTwoPoints();
        }
        
        public void shiftLeft(int speed) {
	        x -= speed;
	        for (Point p : cubeOnePoints) {
	            p.x -= speed;
	        }
	        for (Point p : cubeTwoPoints) {
	            p.x -= speed;
	        }
        
        }
        
        public void shiftRight(int speed) {
	        x += speed;
	        for (Point p : cubeOnePoints) {
	            p.x += speed;
	        }
	        for (Point p : cubeTwoPoints) {
	            p.x += speed;
	        }
        
        }
        
        public void setZ(int z) {
        	this.z = z;
        	diagonal = Math.sqrt(Math.pow((getCubeOnePoints()[1].x - getCubeOnePoints()[0].x), 2) + Math.pow((getCubeOnePoints()[1].y - getCubeOnePoints()[0].y), 2)) / 4;
        	
        }

        private Point[] getCubeOnePoints() {
        	int newX = x;
            int newY = y;
            Point[] points = new Point[4];
            points[0] = new Point(newX- z, newY - z);
            points[1] = new Point(newX + size + z, newY - z);
            points[2] = new Point(newX + size + z, newY + size + z);
            points[3] = new Point(newX - z, newY + size + z);
            return points;
        }

        private Point[] getCubeTwoPoints() {
        	int newX = x + (int) diagonal;
            int newY = y + (int) diagonal;
            Point[] points = new Point[4];
            points[0] = new Point(newX- z, newY - z);
            points[1] = new Point(newX + size + z, newY - z);
            points[2] = new Point(newX + size + z, newY + size + z);
            points[3] = new Point(newX - z, newY + size + z);
            return points;
        }

        public void drawCube(Graphics g) {
        	//if((permShift + permZ) > z && size >= 1) {
        	System.out.println("Size: " + size);
        	if(1==1) {
        		//size = (int) Math.sqrt(Math.pow((getCubeOnePoints()[1].x - getCubeOnePoints()[0].x), 2) + Math.pow((getCubeOnePoints()[1].y - getCubeOnePoints()[0].y), 2));
	            g.drawRect(x-z, y-z, (int) (diagonal * 4), (int)(diagonal*4));
	            g.drawRect(x + (int) diagonal - z, y + (int) diagonal - z, (int)(diagonal * 4), (int)(diagonal*4));
	            // draw connecting lines
	            for (int i = 0; i < 4; i++) {
	                g.drawLine(getCubeOnePoints()[i].x, getCubeOnePoints()[i].y, 
	                		getCubeTwoPoints()[i].x, getCubeTwoPoints()[i].y);
	            }
        	}
        }
}