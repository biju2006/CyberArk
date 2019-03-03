package observerPackage;

import java.util.Observable;
import java.util.Observer;

public class WordCounter implements Observer {
	private int _wordNumber;

	public void update(Observable obj, Object arg) {
		if (arg != null && arg instanceof String) {
			_wordNumber++;
		}
		System.out.println("the number of words is " + _wordNumber);
	}
}
