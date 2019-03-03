//solution checked
package abstractFactoryPackage;

import personPackage.Person;

//client
public class ReadWriteSystem {
	public static void main(String args[]) {
		String className = null;
		String name = null; // name of file or database
		try {
			if (args.length == 0) {
				className = "abstractFactoryPackage.ReadWriteFileFactory";
				name = "abstractFactoryFile.txt";
				//className = "abstractFactoryPackage.ReadWriteDBFactory";
				//name = "db";
			} else {
				className = args[0];
				name = args[1];
			}
			ReadWriteFactory factory = (ReadWriteFactory) Class.forName(
					className).newInstance();
			ReadWrite rw = factory.createReadWrite(name);
			Person p1 = new Person("Moshe", 0, 100);
			Person p2 = new Person("Ronit", 30, 120);
			Person p3 = new Person("Ronen", 55, 190);

			rw.writePerson(p1);
			rw.writePerson(p2);
			rw.writePerson(p3);

			p1 = rw.readPerson();
			print(p1);
			p2 = rw.readPerson("Eytan");
			print(p2);
			p3 = rw.readPerson("Moshe");
			print(p3);

		} catch (ClassNotFoundException cnf) {
			System.err.println("Cannot find class " + className);
			System.exit(1);
		} catch (Exception iae) {
			System.err.println("Error " + iae.getMessage());
			iae.printStackTrace();
			System.exit(1);
		}
	}

	public static void print(Person p) {
		if (p != null)
			System.out.println(p);
	}
}