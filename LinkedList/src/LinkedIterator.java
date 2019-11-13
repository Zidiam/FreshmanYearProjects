/*
 * LinkedIterator.java
 * Jason Melnik
 * CSC - 121
 * 3/26/2019
 */
import java.util.ArrayList;
import java.util.Iterator;
public class LinkedIterator<T> implements Iterator<T>{
	
	private int size, counter;
	private LinearNode<T> current;
	
	public LinkedIterator(LinearNode<T> coll, int size) {
		current = coll;
		this.size = size;
		counter = 0;
	}
	
	@Override
	public boolean hasNext() {
		return current != null && counter < size;
	}

	@Override
	public T next() {
		if(!hasNext())
			throw new ElementNotFoundException("Linked Iterator List");
		
		counter ++;

		T result = current.getElement();
		current = current.getNext();
		return result;
	}
	
	public void remove() {
		if(!hasNext())
			throw new ElementNotFoundException("Linked Iterator List");
		
		current = current.getNext();
		size --;
	}
	
}
