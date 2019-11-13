/*
 * PP7_5_MeanAndStandardDeviation.java -- prints the mean and StandardDeviation of the numbers Entered
 * Jason Melnik
 * 1/17/2019
 * CSC 121
 */
import java.util.Scanner;
public class PP7_5_MeanAndStandardDeviation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer numbers[] = new Integer[50];
		
		int times = 0;
		while(times < 50) {
			System.out.println("Enter a number(You have " + (50 - times) + " numbers left to input): ");
			int answer = scan.nextInt();
			numbers[times] = answer;
			
			//adds all numbers
			int allnumbers = 0;
			for(int i = 0; i <= times; i++) {
				allnumbers += numbers[i];
			}
			times ++;
			float mean = allnumbers/times;
			System.out.println("Mean: " + mean);
			
			times--;
			
			//adds all numbers that has mean minus the number
			int num = 0;
			for(int i = 0; i <= times; i++) {
				num += Math.pow((numbers[i] - mean), 2);
			}
			
			times ++;
			if(times > 1)
				System.out.println("Standard Deviation: " + (float)Math.sqrt(num/(times-1)));
			else
				System.out.println("Standard Deviation: 0");
		}
		
	}
}
