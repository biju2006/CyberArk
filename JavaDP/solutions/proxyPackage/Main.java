//solution checked

package proxyPackage;

import personPackage.Person;

public class Main {
	public static void main(String[] args) {
		String sourceClass = "";
		String sourceName = "";
		if (args.length != 2) {
			sourceClass = "abstractFactoryPackage.ReadWriteFileFactory";
			sourceName = "C:\\temp\\abstractFactoryFile.txt";
		} else {
			sourceClass = args[0];
			sourceName = args[1];
		}

		PersonReader pcp = new PersonCacheProxy(sourceClass, sourceName);
		Person p = pcp.readPerson("Moshe");
		System.out.println(p);
		p = pcp.readPerson("Ronit");
		System.out.println(p);
		p = pcp.readPerson("Moshe"); // reads from cache
		System.out.println(p);
	}
}
