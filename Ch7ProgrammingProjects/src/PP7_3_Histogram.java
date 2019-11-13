/*
 * PP7_3_Histogram.java -- Creates a histogram from how many numbers you inputed from 1 - 100. The Histogram goes up by 10.
 * Jason Melnik
 * 1/17/2019
 * CSC 121
 */
import java.util.ArrayList;
import java.util.Scanner;
public class PP7_3_Histogram {
	public static void main(String [] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int answer = 0;
		System.out.println("Enter a number between 1 - 100");
		answer = scan.nextInt();
		while(answer >= 1 && answer <= 100) {
			numbers.add(answer);
			System.out.println("Enter a number between 1 - 100");
			answer = scan.nextInt();
		}
		int firstNumber = 1;
		int secondNumber = 10;
		for(int i = 0; i < 10; i++) {
			int ammount = 0;
			for(int x = 0; x < numbers.size(); x++) {
				if(numbers.get(x) >= firstNumber && numbers.get(x) <= secondNumber) {
					ammount ++;
				}
			}
			String starString = "";
			for(int a = 0; a < ammount; a++) {
				starString += "*";
			}
			if(firstNumber == 1)
				System.out.println(firstNumber + "  - " + secondNumber + "   | " + starString);
			else if(firstNumber == 91)
				System.out.println(firstNumber + " - " + secondNumber + "  | " + starString);
			else
				System.out.println(firstNumber + " - " + secondNumber + "   | " + starString);
			firstNumber += 10;
			secondNumber += 10;
		}
		
		System.out.println("All the numbers you typed: \n" + numbers);
	}
}
