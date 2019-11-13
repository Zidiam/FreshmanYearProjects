
public class LinkedUnorderedList<T> extends LinkedList<T> implements UnorderedListADT<T>{
	
	
	public LinkedUnorderedList() {
		super();
	}
	
	@Override
	public void addToFront(T element) {
		LinearNode<T> temp = new LinearNode<T>(element);
		
		if(size() == 0)
			head = tail = temp;
		else {
			temp.setNext(head);
			head = temp;
		}
		
		counter ++;
		
	}
	
	@Override
	public void addAfter(T element, T target) {
		if(isEmpty())
			throw new EmptyCollectionException("List");
		
		LinearNode<T> temp = new LinearNode<T>(element);
		LinearNode<T> current = head;
		LinearNode<T> before = null;
		boolean found = false;
		
		while(!found && current != tail.getNext()) {
			if(target.equals(current.getElement()))
				found = true;
			
			before = current;
			current = current.getNext();
		}
		if(!found)
			throw new ElementNotFoundException("List");
		
		before.setNext(temp);
		temp.setNext(current);
		if(before == tail)
			tail = temp;
		counter ++;
		
		
		
	}

	@Override
	public void addToRear(T element) {
		LinearNode<T> temp = new LinearNode<T>(element);
		
		if(size() == 0)
			head = tail = temp;
		else {
			tail.setNext(temp);
			tail = tail.getNext();
		}
		counter ++;
	}
	

}
