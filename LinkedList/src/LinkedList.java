/*
 * LinkedList.java
 * Jason Melnik
 * CSC - 121
 * 3/26/2019
 */
import java.util.Iterator;
public class LinkedList<T> implements ListADT<T>, Iterable<T>
{
	protected int counter;
	protected LinearNode<T> head, tail;
	
	public LinkedList() {
		counter = 0;
		head = tail = null;
	}
	
	public void addFirst(T element) {
		LinearNode<T> temp = new LinearNode<T>(element);
		
		if(size() == 0)
			head = tail = temp;
		else {
			temp.setNext(head);
			
			head = temp;
		}
		
		counter ++;
	}
	
	public void addLast(T element) {
		LinearNode<T> temp = new LinearNode<T>(element);
		
		if(size() == 0)
			head = tail = temp;
		else {
			tail.setNext(temp);
			tail = tail.getNext();
		}
	}
	
	public void add(int index, T element) {
		
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			addFirst(element);
		}
		else if (index == size()) {
			addLast(element);
		}
		else {
			LinearNode<T> temp = new LinearNode<T>(element);
			LinearNode<T> current = head;
			LinearNode<T> after = head.getNext();
			
			for(int x = 0; x < index - 1; x ++) {
				current = current.getNext();
				after = after.getNext();
				
			}
			
			current.setNext(temp);
			temp.setNext(after);
			
			counter ++;
		}
	}
	
	public void add(T element) {
		addLast(element);
	}

	
	@Override
	public T removeFirst() {
		if(isEmpty()) {
			throw new EmptyCollectionException("List");
		}
		T value = head.getElement();
		head = head.getNext();
		if(head == null)
			tail = null;
		counter --;
		return value;
	}

	@Override
	public T removeLast() {
		if(isEmpty())
			throw new EmptyCollectionException("List");
		
		LinearNode<T> current = head;
		LinearNode<T> before = null;
		
		while(current != tail) {
			before = current;
			current = current.getNext();
		}
		
		T value = tail.getElement();
		
		tail = before;
		
		if(tail == null)
			head = null;
		else
			tail.setNext(null);
		
		counter --;
		
		return value;
	}

	@Override
	public T remove(T element) {
		if(isEmpty())
			throw new EmptyCollectionException("List");
		
		boolean found = false;
		
		LinearNode<T> previous = null;
		LinearNode<T> current = head;
		
		while(current != null && !found) {
			if(element.equals(current.getElement()))
				found = true;
			else {
				previous = current;
				current = current.getNext();
			}
		}
		if(!found)
			throw new ElementNotFoundException("Linked List");
		if(size() == 1)
			head = tail = null;
		else if(current.equals(head))
			head = current.getNext();
		else if(current.equals(tail)) {
			tail = previous;
			tail.setNext(null);
		}
		else
			previous.setNext(current.getNext());
		counter --;
		return current.getElement();
	}

	@Override
	public T first() {
		if(isEmpty())
			throw new EmptyCollectionException("Linked List");
		return head.getElement();
	}

	@Override
	public T last() {
		if(isEmpty())
			throw new EmptyCollectionException("Linked List");
		return tail.getElement();
	}

	@Override
	public boolean contains(T element) {
		if(isEmpty())
			throw new EmptyCollectionException("Linked List");
		
		LinearNode<T> current = head;
		
		while(current != tail.getNext()) {
			if(element.equals(current.getElement()))
				return true;
			current = current.getNext();
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return counter == 0;
	}

	@Override
	public int size() {
		return counter;
	}

	@Override
	public Iterator<T> interator() {
		return new LinkedIterator<T>(head, counter);
	}
	
	public String toString() {
		String elements = "";
		LinearNode<T> current = head;
		
		while(current != null) {
			elements = elements + current.getElement() + " ";
			current = current.getNext();;
		}
		return elements;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedIterator<T>(head, counter);
	}

}
