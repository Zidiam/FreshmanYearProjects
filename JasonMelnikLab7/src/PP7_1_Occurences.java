/*
 * PP7_1_Occurences.java -- Counts the inputs that are from 0 - 50 and then prints how many times one of the numbers was typed up
 * Jason Melnik
 * 1/18/2019
 * CSC 121	
 */
import java.util.Random;
public class PP7_1_Occurences {
	public static void main(String[] args) {
		Integer[] randomNums = new Integer[500];
		Integer[] answers = new Integer[51];
		Random rand = new Random();
		for(int i = 0; i < answers.length; i++) {
			answers[i] = 0;
		}
		
		for(int i = 0; i < randomNums.length; i++) {
			randomNums[i] = rand.nextInt(51);
		}
		
		for(int i = 0; i < answers.length; i++) {
			for(int x = 0; x < randomNums.length; x++) {
				if(i == randomNums[x]) {
					answers[i] += 1;
				}
			}
		}
		
		for(int i = 0; i < answers.length; i++) {
			if(answers[i] > 0) {
				System.out.println("The number " + i + " showed up " + answers[i] + " times.");
			}
		}
		
		System.out.println("The numbers that were generated randomly: ");
		System.out.print("[ ");
		for(int i = 0; i < answers.length; i++) {
			System.out.print(randomNums[i] + ", ");
		}
		System.out.print("]");
		
	}
}
