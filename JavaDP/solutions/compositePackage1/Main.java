//checked solution

package compositePackage1;

public class Main {
	public static void main(String [] args)
	{
		String fileName = "C:\\temp\\MyPersonsDb.txt";
		String dirName = "C:\\temp\\";
		FSDirectory dir = new FSDirectory(dirName);
		FSEntity file = new FSFile(fileName,100);

		System.out.println(dir.name());
		System.out.println(dir.size());
		
		System.out.println(file.name());
		System.out.println(file.size());
		
		dir.add(file);
		System.out.println(dir.name());
		System.out.println(dir.size());
		
	}
}
