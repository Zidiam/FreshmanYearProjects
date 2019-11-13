import java.util.Iterator;

public class LinkedList<T> implements ListADT<T> {
	
	private int size;
	private LinearNode head, tail;
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeFirst() {
		LinearNode<T> temp = head;
		head = head.next;
		// TODO Auto-generated method stub
		return temp.getElement();
	}

	@Override
	public T removeLast() {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> interator() {
		// TODO Auto-generated method stub
		return null;
	}

}
