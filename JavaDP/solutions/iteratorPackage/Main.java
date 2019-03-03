//solution checked

package iteratorPackage;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		ArrayList m = new MyArrayList();
		m.add("Eytan");
		m.add("Eytan2");
		m.add("Eytan3");

		Iterator i = m.iterator();
		while (i.hasNext())
			System.out.println((String) i.next());
		
		
		//check you still have the array list
		i = m.iterator();
		
		//go to next in order to activate remove
		i.next();
		//remove from the underlying collection not the iterator!
		i.remove();
		System.out.println(m);
		
		//since we called next there are two elements left
		while (i.hasNext())
			System.out.println((String) i.next());
	}
}
