package decoratorPackage;

import java.io.*;
import personPackage.*;
import java.util.*;

public class PersonInputStream extends FilterInputStream {

	public PersonInputStream(InputStream in) {
		super(in);
	}

	public Person readPerson() {
		byte [] barray = new byte[1024];
		Person p = null;
		try {
			int b = 0;
			while(b != -1)
				b = this.read(barray);			
		} catch (Exception ioe) {
			System.err.println("Cannot read the next person");
			return null;
		}
		String nextPerson = new String(barray);
		if (nextPerson != null) {			
			StringTokenizer st = new StringTokenizer(nextPerson);
			String n = st.nextToken();
			String a = st.nextToken();
			String i = st.nextToken();
			p = new Person(n, Integer.parseInt(a), Integer.parseInt(i));
		}
		return p;
	}
}