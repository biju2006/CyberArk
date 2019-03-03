//solution checked

package facadePackage;

import java.io.*;

import personPackage.Person;

public class PersonClient {
	public static void main(String[] args) throws Exception {
		Person smartBaby = new Person("Babe", 0, 150);
		Person dumbGranny = new Person("Doreena", 85, 85);
		Person averageDude = new Person("Moshe", 40, 100);

		String filename = "C:\\temp\\MyPersonsDb.txt";
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
		} catch (IOException ioe) {
			System.err.println("Cannot write to file");
			System.exit(1);
		}

		out.println(smartBaby);
		out.println(dumbGranny);
		out.println(averageDude);
		out.flush();
		out.close();

		PersonFacade pf = new PersonFacade(filename);
		pf.compare(smartBaby, dumbGranny);
		pf.changeIq(dumbGranny, 100);
		pf.moveIq(dumbGranny, smartBaby);
		pf.compare(smartBaby, dumbGranny);
		pf.updateFile();
	}
}
