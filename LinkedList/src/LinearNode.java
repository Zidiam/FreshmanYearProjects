/*
 * LinearNode.java -- This is a class of nodes that can recall what element it contains and a reference to the next node
 * Jason Melnik
 * CSC - 121
 * 3/26/2019
 */
public class LinearNode<T> {
	private LinearNode<T> next;
	private T element;
	
	public LinearNode() {
		next = null;
		element = null;
	}
	
	public LinearNode(T element) {
		next = null;
		this.element = element;
	}
	
	public LinearNode<T> getNext(){
		return next;
	}
	
	public void setNext(LinearNode<T> node) {
		next = node;
	}
	
	public T getElement() {
		return element;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
}	
