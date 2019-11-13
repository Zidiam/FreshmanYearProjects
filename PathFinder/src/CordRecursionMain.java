import java.awt.Point;
import java.util.ArrayList;

public class CordRecursionMain {
	
	public static double distance(Point a, Point b) {
		
		return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
	}
	
	public static ArrayList<Point> endResult(Point start, Point end, ArrayList<Point> noCords) {
		System.out.println(start);
		if(start.x == end.x && start.y == end.y){
			return new ArrayList<Point>();
		}
		
		Point pointUp = new Point(start);
		pointUp.y = pointUp.y + 1;
		double distanceUp = distance(pointUp, end);
		
		Point pointDown = new Point(start);
		pointDown.y = pointDown.y - 1;
		double distanceDown = distance(pointDown, end);
		
		Point pointRight = new Point(start);
		pointRight.x = pointRight.x + 1;
		double distanceRight = distance(pointRight, end);
	
		Point pointLeft = new Point(start);
		pointLeft.x = pointLeft.x - 1;
		double distanceLeft = distance(pointLeft, end);
		
		//All possible ways:
		//up
		
		boolean up = true;
		boolean down = true;
		boolean left = true;
		boolean right = true;
		
		for(Point point : noCords) {
			if(pointUp.x == point.x && pointUp.y == point.y) {
				up = false;
			}
			if(pointDown.x == point.x && pointDown.y == point.y) {
				down = false;
			}
			if(pointRight.x == point.x && pointRight.y == point.y) {
				right = false;
			}
			if(pointLeft.x == point.x && pointLeft.y == point.y) {
				left = false;
			}
		}
		//best case:
		
		//right
		
		double totalUp = (distanceDown + distanceRight + distanceLeft) / 2.24;
		double totalDown = (distanceUp + distanceRight + distanceLeft) / 2.24;
		double totalRight = (distanceDown + distanceUp + distanceLeft) / 2.24;
		double totalLeft = (distanceDown + distanceRight + distanceUp) / 2.24;
		
		System.out.println(totalUp);
		System.out.println(totalDown);
		System.out.println(distanceUp);
		System.out.println(distanceDown);
		System.out.println(distanceRight);
		
		if(right == true && distanceRight < totalRight) {
			ArrayList<Point> fin = new ArrayList<Point>();
			fin.add(pointRight);
			noCords.add(start);
			fin.addAll(endResult(pointRight, end, noCords));
			return fin;
		}
		if(left == true && distanceLeft < totalLeft) {
			ArrayList<Point> fin = new ArrayList<Point>();
			fin.add(pointLeft);
			noCords.add(start);
			fin.addAll(endResult(pointLeft, end, noCords));
			return fin;
		}
		if(up == true && distanceUp < totalUp) {
			ArrayList<Point> fin = new ArrayList<Point>();
			fin.add(pointUp);
			noCords.add(start);
			fin.addAll(endResult(pointUp, end, noCords));
			return fin;
		}
		if(down == true && distanceDown < totalDown) {
			ArrayList<Point> fin = new ArrayList<Point>();
			fin.add(pointDown);
			noCords.add(start);
			fin.addAll(endResult(pointDown, end, noCords));
			return fin;
		}
		
		System.out.println("Error");
		return new ArrayList<Point>();
		
	}
	
	public static void main(String[] args) {
		System.out.println("Cords it has to go arround: ");
		ArrayList<Point> badCords = new ArrayList<Point>();
		badCords.add(new Point(1, 2));
		badCords.add(new Point(1, 1));
		badCords.add(new Point(1, 0));
		badCords.add(new Point(1, -1));
		badCords.add(new Point(1, -2));
		
	
		for(Point point : badCords) {
			System.out.print(point.toString() + " ");
		}
		
		Point startingPoint = new Point(0, 0);
		System.out.println("Starting Point: " + startingPoint);
		Point endPoint = new Point(2, 0);
		System.out.println("End Point: " + endPoint);
		
		ArrayList<Point> Results = endResult(startingPoint, endPoint, badCords);
		
		System.out.println("Fastest way to get from " + startingPoint + " to " + endPoint + ":");
		
		for(Point point : Results) {
			System.out.print(point.toString() + " ");
		}
		
	}
}