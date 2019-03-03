package observerPackage;

import java.util.Observable;
import java.util.Observer;

public class LongestWordKeeper implements Observer {

	private String _longestWord;

	public void update(Observable obj, Object arg) {
		if (arg != null && arg instanceof String) {
			String word = (String) arg;
			if (_longestWord == null || word.length() > _longestWord.length())
				_longestWord = word;
			System.out.println("the longest word is " + _longestWord);
		}
	}
}
