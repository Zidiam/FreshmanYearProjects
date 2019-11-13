/*
 * UnorderedListADT.java
 * Jason Melnik
 * CSC - 121
 * 3/26/2019
 */
public interface UnorderedListADT<T> extends ListADT<T>{
	public void addToFront(T element);
	public void addToRear(T element);
	public void addAfter(T element, T target);
}
