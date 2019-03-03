package decoratorPackage;

import java.io.*;
import personPackage.Person;
import java.util.StringTokenizer;

public class PersonOutputStream extends FilterOutputStream {

	public PersonOutputStream(OutputStream out) {
		super(out);
	}
	
	public void writePerson(Person p){
		char firstLetter = p.getName().charAt(0); // check capitalization
		String uName = p.getName();
		if (!Character.isUpperCase(firstLetter))
			uName = String.valueOf(firstLetter).toUpperCase()
					+ uName.substring(1, uName.length());		
		p.setName(uName);
		try {
			byte [] b = (p.toString() + "\n").getBytes();			
			out.write(b, 0, b.length);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}