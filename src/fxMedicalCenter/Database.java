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
	
	// basic retrieval method to get an integer from the very first row of the
		// selected
		// data table in the selected column
		public static int getInt(String dataTable, String ColumnName) {
			int result = 0;

			try {
				// sets rs to search the data table to be read
				rs = s.executeQuery("select * from " + dataTable + ";");
				// moves the query to the first line of the table
				rs.next();
				// gets the integer value of the first row of the selected column
				result = rs.getInt(ColumnName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return result;
		}
}

