import java.util.Iterator;

public class ArrayListTest{
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("TEST");
		list.add("NAW");
		list.add("OOF");
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
