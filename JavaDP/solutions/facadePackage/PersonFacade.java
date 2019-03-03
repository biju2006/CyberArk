package facadePackage;

import personPackage.Person;
import java.io.*;
import java.util.Vector;
import java.util.StringTokenizer;

public class PersonFacade {

	private Vector v = new Vector();

	private String _filename;

	public PersonFacade(String filename) throws IOException {
		_filename = filename;
		BufferedReader input = new BufferedReader(new FileReader(_filename));
		String readLine = "";
		while (((readLine = input.readLine()) != null)) {
			StringTokenizer s = new StringTokenizer(readLine);
			while (s.hasMoreTokens()) {
				String name = s.nextToken();
				String age = s.nextToken();
				String iq = s.nextToken();
				v.add(new Person(name, Integer.parseInt(age), Integer
						.parseInt(iq)));
			}
		}
		input.close();
	}

	public void compare(Person p1, Person p2) // talk about comparators in
	// java
	{
		if (v.contains(p1) && v.contains(p2)) {
			Person p11 = (Person) v.elementAt(v.indexOf(p1));
			Person p22 = (Person) v.elementAt(v.indexOf(p2));
			int compare = p11.getIq() - p22.getIq();
			if (compare > 0)
				System.out.println(p1.getName() + " is smarter");
			else if (compare < 0)
				System.out.println(p2.getName() + " is smarter");
			else
				System.out.println(p1.getName() + " and " + p2.getName()
						+ " are equally smart");
		} else
			System.out.println("Cannot compare - not in file");
	}

	public void moveIq(Person p1, Person p2) {
		if (v.contains(p1) && v.contains(p2)) {
			Person p11 = (Person) v.elementAt(v.indexOf(p1));
			Person p22 = (Person) v.elementAt(v.indexOf(p2));
			p22.setIq(p11.getIq());
			System.out.println("moved iq of " + p11.getName() + " to "
					+ p2.getName());
		}
	}

	public void changeIq(Person p1, int delta) {
		if (v.contains(p1)) {
			Person p = (Person) v.elementAt(v.indexOf(p1));
			p.setIq(p1.getIq() + delta);
			System.out.println("changed iq of " + p1.getName() + " from "
					+ p1.getIq() + " to " + p.getIq());
		}
	}

	public void updateFile() throws IOException {

		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(
				_filename)));
		for (int i = 0; i < v.size() - 1; i++) {
			Person p = (Person) v.elementAt(i);
			output.println(p);
		}
		output.flush();
		output.close();
	}
}