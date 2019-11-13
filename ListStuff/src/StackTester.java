
public class StackTester {
	public static void main(String[] args) {
		LinkStack<Dog> dogQ = new LinkStack<Dog>();
		
		for(int i = 0; i <= 20; i++) {
			dogQ.push((new Dog(i)));
		}
		
		System.out.println("The first dog in line is " + dogQ.peak());
		while(!dogQ.isEmpty()) {
			System.out.println("One more leaves: " + dogQ.pop());
		}
	}
}
