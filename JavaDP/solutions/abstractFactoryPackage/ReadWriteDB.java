package abstractFactoryPackage;


import java.sql.*;

import personPackage.Person;

public class ReadWriteDB extends ReadWrite {

	public ReadWriteDB(String name) {
		_name = name;
		System.setProperty("jdbc.drivers", "sun.jdbc.odbc.JdbcOdbcDriver");
	}

	public void writePerson(Person p) {
		if (p == null)
			return;
		try {
			// write to DB
			Connection con = DriverManager.getConnection("jdbc:odbc:" + _name,
					"", "");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into persons values ('" + p.getName()
					+ "' , " + p.getAge() + " , " + p.getIq() + ")");
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.err.println("Cannot write person " + p.getName() + " to db "
					+ sqle.getMessage());
		}
	}

	public Person readPerson() {
		Person p = null;
		try {
			// read first person from DB
			Connection con = DriverManager.getConnection("jdbc:odbc:" + _name);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from persons");
			if (rs == null || !rs.next()) {
				System.out.println("No persons to read from");
			} else {
				p = new Person(rs.getString("name"), rs.getInt("age"), rs
						.getInt("iq"));
			}
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.err.println("Cannot read person from db "
					+ sqle.getMessage());
		}
		return p;
	}

	public Person readPerson(String name) {
		Person p = null;
		try {
			// read some person from db
			Connection con = DriverManager.getConnection("jdbc:odbc:" + _name);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from persons where name = '" + name
							+ "'");
			if (rs == null || !rs.next()) {
				System.out.println("Person " + name + " does not exist");
			} else {
				p = new Person(rs.getString("name"), rs.getInt("age"), rs
						.getInt("iq"));
			}
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.err.println("Cannot read person with name " + name
					+ " from db " + sqle.getMessage());
		}
		return p;
	}
}