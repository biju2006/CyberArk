//solution checked

package observerPackage;

public class FileReaderClient {
	public static void main(String[] args) {
		try {
			String file = "";
			if (args.length == 0)
				file = "C:\\temp\\ObserverFile.txt";
			else
				file = args[0];
			MyFileReader fr = new MyFileReader(file);

			fr.addObserver(new WordCounter());
			fr.addObserver(new NumberCounter());
			fr.addObserver(new LongestWordKeeper());
			fr.addObserver(new WordReverser());
			fr.scan();
		} catch (Exception e) {
			System.err.println("Cannot continue the program : "
					+ e.getMessage());
		}
	}
}