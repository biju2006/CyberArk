package proxyPackage;

import java.util.HashMap;
import personPackage.Person;

public class PersonCacheProxy extends PersonReader {
	private HashMap _cachedObjects = new HashMap();

	String _name;

	String _factoryName;

	public PersonCacheProxy(String factoryName, String name) {
		_factoryName = factoryName;
		_name = name;
	}

	public Person readPerson(String name) {
		Person p = (Person) _cachedObjects.get(name);
		if (p == null) {// object was not cached
			ConcreteReader r = new ConcreteReader(_factoryName, _name);
			p = r.readPerson(name);
			_cachedObjects.put(name, p);
		}
		return p;
	}
}
