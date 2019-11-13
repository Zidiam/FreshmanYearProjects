/*
 * PP7_3_Histogram.java -- Creates a histogram using stars from how many numbers you inputed from 1 - 100. The Histogram goes up by 10.
 * Jason Melnik
 * 1/18/2019
 * CSC 120
 */
import java.util.Random;
public class PP7_3_Histogram {
	public static void main(String[] args) {
		Integer[] randomNums = new Integer[500];
		Integer[] answers = new Integer[10];
		Random rand = new Random();
		for(int i = 0; i < answers.length; i++) {
			answers[i] = 0;
		}
		
		for(int i = 0; i < randomNums.length; i++) {
			randomNums[i] = rand.nextInt(101);
		}
		
		int firstNumber = 1;
		int secondNumber = 10;
		for(int i = 0; i < answers.length; i++) {
			for(int x = 0; x < randomNums.length; x++) {
				if(firstNumber <= randomNums[x] && randomNums[x] <= secondNumber) {
					answers[i] += 1;
				}
			}
			firstNumber += 10;
			secondNumber += 10;
		}
		
		
		firstNumber = 1;
		secondNumber = 10;
		for(int i = 0; i < answers.length; i++) {
			
			String stars = "";
			for(int x = 0; x < answers[i]; x++) {
				stars += "*";
			}
			
			if(i == 0) 
				System.out.println(firstNumber + "  - " + secondNumber + "   |" + stars);
			else if(i == 9) 
				System.out.println(firstNumber + " - " + secondNumber + "  |" + stars);
			else
				System.out.println(firstNumber + " - " + secondNumber + "   |" + stars);
			
			firstNumber += 10;
			secondNumber += 10;
		}
		
		
	}
}
