package decoratorPackage;

import java.io.*;
import personPackage.Person;


public class ClientFileStream {
	public static void main(String[] args) throws IOException {
		final String FILE_NAME = "C://temp//file.txt";
		
		Person p = new Person("eytan",100,100);
		FileOutputStream f = new FileOutputStream(FILE_NAME);		
		
		PersonOutputStream out = new PersonOutputStream(f);
		out.writePerson(p);
		out.flush();
		
		PersonInputStream in = new PersonInputStream(new FileInputStream(FILE_NAME));
		Person rp = in.readPerson();
		System.out.println(rp.toString());		
	}
}