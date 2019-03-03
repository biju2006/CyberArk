package personPackage;

public class Person {

	private String _name;

	private int _iq;

	private int _age;

	public Person(String name, int age) {
		_name = name;
		_age = age;
	}

	public Person(String name, int age, int iq) {
		this(name, age);
		_iq = iq;
	}

	public int getIq() {
		return _iq;
	}

	public void setIq(int newIq) {
		_iq = newIq;
	}
	
	public void setName(String name){
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public int getAge() {
		return _age;
	}

	public void setAge(int newAge) {
		_age = newAge;
	}

	public String toString() {
		return _name + " " + _age + " " + _iq;
	}

	public boolean equals(Object obj) {
		boolean returned = false;
		if (obj instanceof Person) {
			Person p = (Person) obj;
			returned = (this._name.equals(p._name));
		}
		return returned;
	}
}
