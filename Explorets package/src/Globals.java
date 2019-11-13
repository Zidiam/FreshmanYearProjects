import java.util.ArrayList;

public class Globals {
	public static int screenWidth = 1008, screenHeight = 504;
	public static int mapWidth = 1008 * 5, mapHeight = 504 * 5;
	public static int cx = -mapWidth/2 + screenWidth/2, cy = -mapHeight/2 + screenHeight/2;
	public static String scene = "Menu";
	public static ArrayList<SmallRock> mineable = new ArrayList<SmallRock>();
	
}
