/*
 * LinkedIterator.java
 * Jason Melnik
 * CSC - 121
 * 3/26/2019
 */
import java.util.Iterator;
public class LinkedIterator<T> implements Iterator<T>{
	
	private int counter;
	private LinearNode<T> current;
	
	public LinkedIterator(LinearNode<T> coll, int size) {
		current = coll;
		counter = size;
	}
	
	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		if(!hasNext())
			throw new ElementNotFoundException("Linked Iterator List");
		
		T result = current.getElement();
		current = current.getNext();
		return result;
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}
