package abstractFactoryPackage;

import personPackage.Person;

public abstract class ReadWrite {

	protected String _name;

	public abstract void writePerson(Person p);

	public abstract Person readPerson();

	public abstract Person readPerson(String name);
}