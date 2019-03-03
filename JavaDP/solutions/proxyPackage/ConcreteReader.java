package proxyPackage;

import abstractFactoryPackage.ReadWrite;
import abstractFactoryPackage.ReadWriteFactory;
import personPackage.Person;

public class ConcreteReader extends PersonReader {

	ReadWrite _rw = null;

	public ConcreteReader(String factoryName, String name) {
		try {
			ReadWriteFactory factory = (ReadWriteFactory) Class.forName(
					factoryName).newInstance();
			_rw = factory.createReadWrite(name);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Cannot initialize source " + name);
			System.exit(1);
		}
	}

	public Person readPerson(String name) {
		return _rw.readPerson(name);
	}
}
