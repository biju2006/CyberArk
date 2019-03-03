package observerPackage;

import java.util.Observable;
import java.util.Observer;

public class WordReverser implements Observer {

	private String _reversedWord;

	public void update(Observable obj, Object arg) {
		if (arg != null && arg instanceof String) {
			String word = (String) arg;
			StringBuffer s = new StringBuffer(word);
			_reversedWord = s.reverse().toString();
			System.out.println("the word reversed is " + _reversedWord);
		}
	}
}