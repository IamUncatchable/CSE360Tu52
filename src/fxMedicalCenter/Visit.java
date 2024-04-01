package fxMedicalCenter;

import java.sql.SQLException;

public class Visit {
	
	private int height;
	private int weight;
	private int temp; 
	private int bloodPressure; 
	private String nurseNotes; 
	private String drNotes; 
	private int date;
	private String patientID; 
	private int visitID; 
	
	//here is the constructor 
    public void visit() 
    {
        this.patientID = patientID;
        this.height = 0; 
        this.weight = 0; 
        this.temp = 0; 
        this.bloodPressure = 0; 
        this.nurseNotes = ""; 
        this.drNotes = ""; 
        this.date = 0; 
        this.visitID = 0;
    }
    
	public Visit(String patientID)
	{
		this.patientID = patientID; 
	}
	
	public void setWeight(int w)
	{
		weight = w; 
	}
	
	public void setHeight(int h)
	{
		height = h; 
	}
	
	public void setTemp(int t)
	{
		temp = t; 
	}
	
	public void setPressure(int pressure)
	{
		bloodPressure = pressure; 
	}
	
	public void setNurseNotes(String notes)
	{
		nurseNotes = notes; 
	}
	
	public void setDRNotes(String notes)
	{
		drNotes = notes; 
	}
	
    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getTemp() {
        return temp;
    }

    public int getPressure() {
        return bloodPressure;
    }

    public String getNurseNotes() {
        return nurseNotes;
    }

    public String getDRNotes() {
        return drNotes;
    }

    public int getDate() {
        return date;
    }

    public String getPatientID() {
        return patientID;
    }

    public int getVisitID() {
        return visitID;
    }
    
    public void queryVisit(int id) throws SQLException 
    {
    	 String query = "SELECT * FROM visits WHERE visit_id = " + visitID;
         Database.rs = Database.s.executeQuery(query);

         // this checks if the result set has data
         if (Database.rs.next()) {
             // this gets data from the result set and set it to object fields
             this.patientID = Database.rs.getString("patient_id");
             this.height = Database.rs.getInt("height");
             this.weight = Database.rs.getInt("weight");
             this.temp = Database.rs.getInt("temperature");
             this.bloodPressure = Database.rs.getInt("blood_pressure");
             this.nurseNotes = Database.rs.getString("nurse_notes");
             this.drNotes = Database.rs.getString("dr_notes");
             this.date = Database.rs.getInt("visit_date");
             this.visitID = Database.rs.getInt("visit_id");
         } else {
             System.out.println("Visit with ID " + visitID + " not found.");
         }
    }    
	
}
