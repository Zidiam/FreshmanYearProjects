/*
 * PP7_1_Occurences.java -- Counts the inputs that are from 0 - 50 and then prints how many times one of the numbers showed up then the whle list
 * Jason Melnik
 * 1/17/2019
 * CSC 121
 */
import java.util.ArrayList;
import java.util.Scanner;
public class PP7_1_Occurences {
	public static void main(String [] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int answer = 0;
		System.out.println("Enter a number between 0 - 50");
		answer = scan.nextInt();
		while(answer >= 0 && answer <= 50) {
			numbers.add(answer);
			System.out.println("Enter a number between 0 - 50");
			answer = scan.nextInt();
		}
		ArrayList<Integer> numberstyped = new ArrayList<Integer>();
		
		for(int i = 0; i < numbers.size(); i++) {
			int ammount = 0;
			boolean typed = false;
			for(int z = 0; z < numberstyped.size(); z++) {
				if(numberstyped.get(z) == numbers.get(i)) {
					typed = true;
				}
			}
			if(typed == false) {
				for(int x = 0; x < numbers.size(); x++) {
					if(numbers.get(i) == numbers.get(x)) {
						ammount ++;
					}
				}
				numberstyped.add(numbers.get(i));
				System.out.println("You typed " + numbers.get(i) + " exactly " + ammount + " times.");
			}
		}
		
		System.out.println("All the numbers you typed: \n" + numbers);
	}
}
