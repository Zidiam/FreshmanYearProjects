
public class LinkedOrderedList<T> extends LinkedList<T> implements OrderedListADT<T>{
	public LinkedOrderedList() {
		super();
	}
	
	public void add(T element) {
		Comparable<T> temp = (Comparable<T>)(element);
		
		LinearNode<T> newNode = new LinearNode<T>(element);
		
		if(isEmpty()) {
			head = tail = newNode;
		}
		else if(temp.compareTo(tail.getElement()) >= 0) {
			tail.setNext(newNode);
			tail = newNode;
		}
		else if(temp.compareTo(head.getElement()) <= 0) {
			newNode.setNext(head);
			head = newNode;
		}
		else {
			LinearNode<T> current = head;
			LinearNode<T> beforeCurrent = null;
			while(current != null && (temp.compareTo(current.getElement()) > 0)) {
				beforeCurrent = current;
				current = current.getNext();
			}
			beforeCurrent.setNext(newNode);
			newNode.setNext(current);
		}
		counter ++;
	}
}
