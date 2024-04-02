package fxMedicalCenter;

import java.sql.*;

public class Database {
	// Basic global variables that are used at different instants
	private Statement s;
	private Connection c;
	private ResultSet rs;
	private String query;

	public enum Datatables{
		VISIT("visit"),
		MESSAGE("message"),
		USERS("users"),
		PRESCRIPTION("prescription"),
		PATIENT("patient");
		
		
		private final String dataTableName;

		 Datatables(String dataTableName) {
				this.dataTableName = dataTableName;
			}
			
			public String get() {
				return dataTableName;
			}
	}
	
	public enum Columns {
		
		MESSAGE("message"),
		FROM("from"),
		TO("to"),
		DATE("date"),
		TEXT("text"),
		PATIENT_ID("patient_id"),
		GENDER("gender"),
		ADDRESS("address"),
		CITY("city"),
		STATE("state"),
		ZIP("zip"),
		PHONE_NUMBER("phone_number"),
		EMAIL("email"),
		INSURANCE_PROVIDER("insurance_provider"),
		INSURANCE_ID("insurance_id"),
		HISTORY("history"),
		FIRST_NAME("first_name"),
		LAST_NAME("last_name"),
		PRESCRIPTION_ID("prescription_id"),
		REFILLS("refills"),
		PRESCRIBED("prescribed"),
		USERNAME("username"),
		BIRTHDAY("birthday"),
		PASSWORD("password"),
		ACCOUNT_TYPE("account_type"),
		VISIT_ID("visit_id"),
		HEIGHT("height"),
		WEIGHT("weight"),
		TEMP("temp"),
		BLOOD_PRESSURE("blood_pressure"),
		NURSE_NOTES("nurse_notes"),
		DR_NOTES("dr_notes");
		
		private final String columnName;

		 Columns(String columnName) {
				this.columnName = columnName;
			}
			
			public String get() {
				return columnName;
			}
	}
	
	public Database() {
		databaseconnect();
	}

	// This method connects the database as connection c and statement s which will
	// be
	// used throughout the database controller
	private  void databaseconnect() {

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
		public int getInt(String ColumnName) {
			int result = -99999999;

			try {
				result = rs.getInt(ColumnName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return result;
		}
		
		public String getString(String ColumnName) {
			String result = null;

			try {
				result = rs.getString(ColumnName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return result;
		}
		
		public void setQuery(String dataTable,String columnName,String value) {
			query = "Select * FROM "+dataTable+" WHERE " + columnName + "=\'" + value+"\';";
		}
		
		public void setQuery(String dataTable,String columnName,int value) {
			query = "Select * FROM "+dataTable+" WHERE " + columnName + "=" + value+";";
		}
		
		public void setEncodedQuery(String setQuery) {
			query = setQuery;
		}
		
		public void query() {
			try {
				rs = s.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public boolean next() {
			boolean successful = false;
			try {
				successful = rs.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return successful;
		}
		
		public boolean updateInt(String dataTable,String uniqueColumn,String uniqueValue,String columnToUpdate,int newValue) {
			boolean successful = false;
			
			try {
				s.execute("Update " + dataTable + " set " + columnToUpdate + " = " + newValue + " where " + uniqueColumn + " = \'"+ uniqueValue +"\';");
				successful = true;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return successful;
		}
		
		public boolean updateInt(String dataTable,String uniqueColumn,int uniqueValue,String columnToUpdate,int newValue) {
			boolean successful = false;
			
			try {
				s.execute("Update " + dataTable + " set " + columnToUpdate + " = " + newValue + " where " + uniqueColumn + " = "+ uniqueValue +";");
				successful = true;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return successful;
		}
		
		public boolean updateString(String dataTable,String uniqueColumn,String uniqueValue,String columnToUpdate,String newValue) {
			boolean successful = false;
			
			try {
				s.execute("Update " + dataTable + " set " + columnToUpdate + " = \'" + newValue + "\' where " + uniqueColumn + " = \'"+ uniqueValue +"\';");
				successful = true;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return successful;
		}
		
		public boolean updateString(String dataTable,String uniqueColumn,int uniqueValue,String columnToUpdate,String newValue) {
			boolean successful = false;
			
			try {
				s.execute("Update " + dataTable + " set " + columnToUpdate + " = \'" + newValue + "\' where " + uniqueColumn + " = "+ uniqueValue +";");
				successful = true;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return successful;
		}
}

