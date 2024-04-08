package fxMedicalCenter;

import java.sql.*;


public class Database {
	// Basic global variables that are used at different instants
	private Statement s;
	private Connection c;
	private ResultSet rs;
	private String query;
	
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
		
		public boolean createPatient(String gender,String address,String city,String state,int zip,int phone,String email,int insuranceNumber,String insuranceProvider,String patientID,String history,String firstName, String lastName,String birthday) {
			boolean successful = false;
			try {
				
				s.addBatch("INSERT INTO "+Datatables.PATIENT.get()+" VALUES ('"+patientID+"','"+gender+"','"+address+"','"+city+"','"+state+"','"+zip+"','"+phone+"','"+email+"','"+insuranceProvider+"','"+insuranceNumber+"','"+history+"','"+firstName+"','"+lastName+"','"+birthday+"');");
				s.executeBatch();
				successful = true;
			}catch(SQLException e) {
				successful = false;
			}
			return successful;
		}
		
		public boolean createVisit(String patientID, int visitID, String date) {
			boolean successful = false;
			try {
				s.addBatch("INSERT INTO " + Datatables.VISIT.get()+" ("+Columns.PATIENT_ID.get()+","+Columns.VISIT_ID.get()+","+Columns.DATE.get()+ ")" + " VALUES ('"+patientID+"',"+visitID+",'"+date+"');");
				s.executeBatch();
				successful = true;
			}catch(SQLException e) {
				successful = false;
			}
			return successful;
		}
		
		public boolean createPrescription(int prescriptionID,String date, String prescribed, int refills) {
			boolean successful = false;
			try {
				s.addBatch("INSERT INTO " + Datatables.PRESCRIPTION.get()+" Values ("+prescriptionID+","+refills+",'"+prescribed+"','"+date+"');");
				s.executeBatch();
				successful = true;
			}catch(SQLException e) {
				successful = false;
			}
			return successful;
		}
		
		public boolean createUser(String username,String password,String firstName,String lastName,String account_type,String patient_id) {
			boolean successful = false;
			try {
				s.addBatch("INSERT into "+ Datatables.USERS.get()+" Values ('"+username+"','"+firstName+"','"+lastName+"','"+password+"','"+account_type+"','"+patient_id+"');");
				s.executeBatch();
				successful = true;
			}catch(SQLException e) {
				successful = false;
			}
			return successful;
		}
		
		public boolean createMessage(int messageID,String from, String to, String text, String date) {
			boolean successful = false;
			
			try {
				s.addBatch("INSERT into "+ Datatables.MESSAGE.get()+" Values ("+messageID+",'"+from+"','"+to+"','"+text+"','"+date+"');");
				s.executeBatch();
				successful = true;
			}catch(SQLException e) {
				successful = false;
			}
			return successful;
		}
}

