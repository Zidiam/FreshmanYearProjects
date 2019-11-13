import java.util.Random;
/*
 * BlurbLanguage.java -- Creates a random word in the language of Blurb! 
 * Explanation: Whoozit: x + y * random , Whatzit: q + (z or d) + whoozit
 * Explanation: Blurb: Whoozit + Whatzit * random
 * Made by Jason Melnik
 * 9/12/2019
 */



//Whoozit: x + y * random , Whatzit: q + (z or d) + whoozit
//Blurb: Whoozit + Whatzit * random


class Blurb{
		private Random rand = new Random();
	
		public Blurb() {
			
		}
		
		public String getWhoozitY() {
			
			String str = "";
			if(rand.nextBoolean()) {
				str += "y" + getWhoozitY();
			}
			
			return str;
		}
		
		public String getWhoozit() {
			return "x" + getWhoozitY();
		}
		
		public String getWhatzit() {
			String str = "q";
			if(rand.nextBoolean()) {
				str += "z";
			}
			else
				str += "d";
			
			return str + getWhoozit();
		}
		
		public String getBlurb() {
			String str = getWhoozit() + getWhatzit();
			if(rand.nextBoolean()) {
				str += getWhatzit() + getBlurb();
			}
			
			return str;
		}
		
		
		
}


public class BlurbLanguage {
	
	public static void main(String[] args) {
		
		Blurb blurb1 = new Blurb();
		for(int x = 0; x < 5; x++) {
			System.out.println(blurb1.getBlurb());
		}
		
	}
}
