
public interface UnorderedListADT<T> extends ListADT<T>{
	public void addAfter(T element, T target);
	public void addToFront(T element);
	public void addToRear(T element);
}
