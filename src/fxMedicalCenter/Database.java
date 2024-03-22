package fxMedicalCenter;

import java.sql.*;

public class Database {
	// Basic global variables that are used at different instants
	static Statement s;
	static Connection c;
	static ResultSet rs;
	public static double totalPrice;

	public Database() {
		databaseconnect();
	}

	// This method connects the database as connection c and statement s which will
	// be
	// used throughout the database controller
	private static void databaseconnect() {

		try {
			c = DriverManager.getConnection("jdbc:postgresql://98.177.250.239:5432/fxMedicalCenter","fxMedicalCenter" ,"thisclasssucks")
					;

			s = c.createStatement();
			System.out.println("Connected to the database");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}

