package observerPackage;

import java.io.*;
import java.util.*;
import java.util.Observable;

public class MyFileReader extends Observable {

	private StringTokenizer _st;

	public MyFileReader(String path) throws FileNotFoundException, IOException {
		// prepare to read word by word since readers read line by line
		InputStreamReader isr = new InputStreamReader(new FileInputStream(
				new File(path)));
		BufferedReader br = new BufferedReader(isr);
		StringBuffer s = new StringBuffer();
		String nextLine = "";
		while ((nextLine = br.readLine()) != null)
			s.append(nextLine);
		_st = new StringTokenizer(s.toString());
	}

	public void scan() {

		while (_st.hasMoreTokens()) {
			String nextToken = _st.nextToken();
			setChanged();
			notifyObservers(nextToken);
			System.out.println("\n");
		}
	}
}