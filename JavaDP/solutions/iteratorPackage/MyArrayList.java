package iteratorPackage;

import java.util.*;

public class MyArrayList extends ArrayList {
	public static final long serialVersionUID = 1l; // for serialization of

	// same version objects
	public Iterator iterator() {
		return new LifoIterator(this);
	}

	private class LifoIterator implements java.util.Iterator {
		private ArrayList _stack;

		private boolean removeState = false;

		private LifoIterator(ArrayList al) {
			_stack = new ArrayList(al);			
		}

		public boolean hasNext() {
			return !(_stack.size() == 0);
		}

		public Object next() {
			if (_stack.size() == 0)
				throw new NoSuchElementException();
			Object o = _stack.remove(_stack.size() - 1);
			removeState = true;
			return o;
		}

		public void remove() {
			if (removeState == false)
				throw new IllegalStateException();
			Object removed = MyArrayList.this.remove(_stack.size() - 1);
			if (removed == null)
				throw new UnsupportedOperationException();
			removeState = false;
		}
	}
}