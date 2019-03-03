package abstractFactoryPackage;

import java.io.*;

import personPackage.Person;
import java.util.StringTokenizer;

public class ReadWriteFile extends ReadWrite {

	public ReadWriteFile(String name) {
		_name = name;
	}

	public void writePerson(Person p) {
		if (p == null)
			return;
		try {
			// write to file
			PrintWriter output = new PrintWriter(new BufferedWriter(
					new FileWriter(_name, true)));
			output.println(p.toString());
			output.flush();
			output.close();
		} catch (IOException ioe) {
			System.err.println("Cannot write to file");
		}
	}

	public Person readPerson() {
		String raw = null;
		Person p = null;
		try {
			// read first person from file
			BufferedReader input = new BufferedReader(new FileReader(_name));
			raw = input.readLine();
			if(raw==null)
			{
				System.out.println("File does not contain any records");
			}else
				p = createPerson(raw);
		} catch (IOException ioe) {
			System.err.println("Cannot read from the source " + _name);
		}
		return p;
	}

	public Person readPerson(String name) {
		String raw = null;
		Person p = null;
		try {
			// read some person from file
			BufferedReader input = new BufferedReader(new FileReader(_name));
			while ((raw = input.readLine()) != null ) {
				 if(raw.indexOf(name) != -1)
				 {
				 	p = createPerson(raw);
				 	break;
				 }
			}
			if(raw==null)
			{
				System.out.println("File does not contain " + name);
			}
		} catch (IOException ioe) {
			System.err.println("Cannot read from the source " + _name);
		}
		return p;
	}
	
	private Person createPerson(String raw)
	{
		Person p = null;
		StringTokenizer st = new StringTokenizer(raw);
		while(st.hasMoreTokens())
		{
			String name = st.nextToken();
			String age = st.nextToken();
			String iq = st.nextToken();
			p = new Person(name, Integer.parseInt(age) , Integer.parseInt(iq));
		}
		return p;
	}
}
