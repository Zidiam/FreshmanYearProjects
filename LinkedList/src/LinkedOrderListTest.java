/*
 * LinkedOrderListTest.java -- Testing LinkedOrderList
 * Jason Melnik
 * CSC - 121
 * 3/26/2019
 */
import java.util.Iterator;
public class LinkedOrderListTest {
	public static void main(String[] args) {
		LinkedOrderedList<Integer> list = new LinkedOrderedList<Integer>();
		
		list.add(74);
		list.add(34);
		list.add(27);
		list.add(84);
		list.add(65);
		list.add(35);
		list.add(90);
		list.add(87);
		
		System.out.println("Is the list empty: " + list.isEmpty());
		System.out.println("Size of list: " + list.size());
		System.out.println("First element in the list: " + list.first());
		System.out.println("Last element in the list: " + list.last());
		System.out.println("Does the list have 90?: " + list.contains(90));
		System.out.println("Everything in the list:");
		Iterator<Integer> it = list.iterator();
		while(it.hasNext())
			System.out.println(it.next() + " ");
		
		System.out.println("This element: " + list.remove(74) + " has been removed from the list");
		
		System.out.println("The first element and it being removed: " + list.removeFirst());
		System.out.println("The last element and it beiing removed: " + list.removeLast());
		System.out.println("The list now: " + list.toString());
		
		System.out.println("The front element of the list: " + list.first());
		System.out.println("The last element of the list" + list.last());
		
		
	}
}
