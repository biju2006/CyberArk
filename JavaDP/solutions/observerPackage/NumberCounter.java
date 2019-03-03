package observerPackage;

import java.util.Observable;
import java.util.Observer;

public class NumberCounter implements Observer {

	private int _numberOfNumbers;

	public void update(Observable obj, Object arg) {
		if (arg != null) {
			try {
				Integer.parseInt(((String) arg));
				_numberOfNumbers++;
			} catch (Exception e) {
			}
		}
		System.out.println("the number of numbers is " + _numberOfNumbers);
	}
}