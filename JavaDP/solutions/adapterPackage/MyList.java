//solution checked

package adapterPackage;

import java.util.*;

public class MyList implements Stack {
	private List _list;

	public MyList(List l) {
		_list = l;
	}

	public Object pop() {
		return _list.remove(_list.size() - 1);
	}

	public void push(Object o) {
		_list.add(o);
	}

	public static void main(String[] args) {
		Vector collection = new Vector();
		collection.add("a");
		collection.add("b");
		collection.add("c");
		MyList ml = new MyList(collection);

		String popped = (String) ml.pop().toString();
		System.out.println(popped);
		ml.push(popped);
		String pushed = (String) ml.pop().toString();
		System.out.println(pushed);
	}

}