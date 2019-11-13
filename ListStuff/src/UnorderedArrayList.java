import java.util.Iterator;
//public class UnorderedArrayList<T> extends ArrayList<T> implements UnorderedListADT{
public class UnorderedArrayList<T> extends ArrayList<T> implements UnorderedListADT<T>{
	
	public void addAfter(T element, T target) {
		if(size() == list.length)
			expandCapacity();
		
		int scan = 0;
		
		while(scan < rear && !target.equals(list[scan]))
			scan ++;
		
		if(scan == rear)
			throw new ElementNotFoundException("UnorderedList");
		
		scan ++;
		
		for(int shift = rear; shift > scan; shift--)
			list[shift] = list[shift - 1];
		
		list[scan] = element;
		rear ++;
		modCount ++;
	}

	@Override
	public Iterator<T> interator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFirst(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLast(T element) {
		// TODO Auto-generated method stub
		
	}
	
	
}
