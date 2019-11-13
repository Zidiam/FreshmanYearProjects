
public class CountPaths {
	
	public static int countPaths(int x, int y) {
		
		if(x == 0 && y == 0) {
			return 1;
		}
		if(x < 0 || y < 0) {
			return 0;
		}
		
		return countPaths(x-1, y) + countPaths(x, y - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(countPaths(300, 1));
	}
}
