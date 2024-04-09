package fxMedicalCenter;

import java.sql.SQLException;
import java.time.LocalDate;

public class Visit {
	
	private int height;
	private int weight;
	private int temp; 
	private int bloodPressure; 
	private String nurseNotes; 
	private String drNotes; 
	private LocalDate date;
	private String patientID; 
	private int visitID; 
	private boolean checkedIn;
	private boolean finished;
	
	//here is the constructor 
    public Visit(String patientID,LocalDate date) 
    {
        this.patientID = patientID;
        this.height = 0; 
        this.weight = 0; 
        this.temp = 0; 
        this.bloodPressure = 0; 
        this.nurseNotes = ""; 
        this.drNotes = ""; 
        this.date = date; 
        this.visitID = 0;
        setCheckedIn(false);
        setFinished(false);
    }
    
    public boolean saveNewVisit() {
    	Database db = new Database();
    	return db.createVisit(patientID, visitID, date.toString());
    }
    
	public Visit(int visitID)
	{
		this.visitID= visitID;
		queryVisit();
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

    public LocalDate getDate() {
        return date;
    }

    public String getPatientID() {
        return patientID;
    }

    public int getVisitID() {
        return visitID;
    }
    
    private void queryVisit()
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
             this.date.parse(database.getString(Columns.DATE.get()));
             this.visitID = database.getInt(Columns.VISIT_ID.get());
         } else {
             System.out.println("Visit with ID " + visitID + " not found.");
             visitID = -999999;
         }
    }

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}    
	
}
