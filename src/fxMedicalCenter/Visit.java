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
  
         Database database = new Database();
         database.setQuery(Datatables.VISIT.get(),Columns.VISIT_ID.get(), visitID);
         database.query();

         // this checks if the result set has data
         if (database.next()) {
             // this gets data from the result set and set it to object fields
             this.patientID = database.getString(Columns.PATIENT_ID.get());
             this.height = database.getInt(Columns.HEIGHT.get());
             this.weight = database.getInt(Columns.WEIGHT.get());
             this.temp = database.getInt(Columns.TEMP.get());
             this.bloodPressure = database.getInt(Columns.BLOOD_PRESSURE.get());
             this.nurseNotes = database.getString(Columns.NURSE_NOTES.get());
             this.drNotes = database.getString(Columns.DR_NOTES.get());
             this.date = database.getInt(Columns.DATE.get());
             this.visitID = database.getInt(Columns.VISIT_ID.get());
         } else {
             System.out.println("Visit with ID " + visitID + " not found.");
         }
    }    
	
}
