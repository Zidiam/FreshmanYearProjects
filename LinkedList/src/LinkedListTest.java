import java.util.Iterator;

/*
 * LinkedListTest.java -- Tests LinkedLists
 * Jason Melnik
 * CSC - 121
 * 3/26/2019
 */
public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.addFirst(13);
		list.addFirst(32);
		list.addFirst(54);
		list.addFirst(47);
		
		System.out.println("List after adding to the beginning: " + list);
		
		list.addLast(23);
		list.addLast(34);
		list.addLast(85);
		list.addLast(75);
		
		System.out.println("List after adding to the end: " + list);
		
		list.add(4, 47);
		list.add(3, 34);
		
		System.out.println("List after inserting a number after another: " + list.toString());
		
		list.remove(75);
		System.out.println("75 being removed: " + list);
		
		list.removeFirst();
		System.out.println("First being removed: " + list);
	
		System.out.println("First element in list: " + list.first());
		System.out.println("List last element: " + list.last());
		
		list.removeLast();
		System.out.println("Last being removed: " + list);
		
		System.out.println("Is the list empty? " + list.isEmpty());
		System.out.println("Size of list: " + list.size());
		
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
