
public class GreatestCommonDiviser {
	
	
	public static int gcd(int p, int q) {
		if(q <= 0) {
			return p;
		}
		
		
		return gcd(q, p % q);
	}
	
	public static void main(String[] args) {
		
		System.out.print(gcd(24, 3));
	}
	
}
