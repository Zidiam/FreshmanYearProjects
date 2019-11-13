/*
 * LinkedUnorderedListTest.java -- Tests Unordered Linked List
 * Jason Melnik
 * CSC - 121
 * 3/26/2019
 */
public class LinkedUnorderedListTest {
	public static void main(String [] args) {
		LinkedUnorderedList<Integer> list = new LinkedUnorderedList<Integer>();
		
		list.addToFront(86);
		list.addToFront(57);
		list.addToFront(74);
		list.addToFront(59);
		
		System.out.println("List after adding elements to the front: " + list);
		
		list.addToRear(34);
		list.addToRear(75);
		list.addToRear(45);
		list.addToRear(24);
		
		System.out.println("List after adding them to the rear: " + list);
		
		list.addAfter(43, 74);
		list.addAfter(12, 86);
		
		System.out.println("List after adding numbers after numbers already in the list " + list.toString());
		
		list.remove(45);
		System.out.println("List after removing 45: " + list);
		
		list.removeFirst();
		System.out.println("After removing the first element: " + list);
		
		list.removeLast();
		System.out.println("After removing last element: " + list);
		
		System.out.println("First element in the list: " + list.first());
		System.out.println("Last element in the list: " + list.last());
		
		System.out.println("Is the list empty? : " + list.isEmpty());
		System.out.println("Size of List: " + list.size());
		
	}
}
