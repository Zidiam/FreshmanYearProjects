
import java.util.Iterator;
public interface ListADT<T> extends Iterable<T> {
	public T removeFirst();
	public T removeLast();
	public T remove(T element);
	public int size();
	public Iterator<T> interator();
	public String toString();
	public T first();
	public T last();
	public boolean contains(T element);
	public boolean isEmpty();
}