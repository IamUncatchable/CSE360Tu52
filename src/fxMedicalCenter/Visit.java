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
	private Database db;
	
	//here is the constructor 
    public Visit(String patientID,LocalDate date) 
    {
    	db = new Database();
        this.patientID = patientID;
        this.height = 0; 
        this.weight = 0; 
        this.temp = 0; 
        this.bloodPressure = 0; 
        this.nurseNotes = ""; 
        this.drNotes = ""; 
        this.date = date; 
        this.visitID = 0;
        checkedIn=false;
        finished=false;
    }
    
    public boolean saveNewVisit() {
    	
    	return db.createVisit(patientID, visitID, date.toString());
    }
    
	public Visit(int visitID)
	{
		db = new Database();
		this.visitID= visitID;
		queryVisit();
	}
	
	public void setWeight(int w)
	{
		weight = w; 
		db.updateInt(Datatables.VISIT.get(), Columns.VISIT_ID.get(), visitID, Columns.WEIGHT.get(), weight);
	}
	
	public void setHeight(int h)
	{
		height = h; 
		db.updateInt(Datatables.VISIT.get(), Columns.VISIT_ID.get(), visitID, Columns.HEIGHT.get(), height);
	}
	
	public void setTemp(int t)
	{
		temp = t; 
		db.updateInt(Datatables.VISIT.get(), Columns.VISIT_ID.get(), visitID, Columns.TEMP.get(), temp);
	}
	
	public void setPressure(int pressure)
	{
		bloodPressure = pressure; 
		db.updateInt(Datatables.VISIT.get(), Columns.VISIT_ID.get(), visitID, Columns.BLOOD_PRESSURE.get(), bloodPressure);
		
	}
	
	public void setNurseNotes(String notes)
	{
		nurseNotes = notes; 
		db.updateString(Datatables.VISIT.get(), Columns.VISIT_ID.get(), visitID, Columns.NURSE_NOTES.get(), nurseNotes);
	}
	
	public void setDRNotes(String notes)
	{
		drNotes = notes;
		db.updateString(Datatables.VISIT.get(), Columns.VISIT_ID.get(), visitID, Columns.DR_NOTES.get(), drNotes);
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
             this.date=LocalDate.parse(database.getString(Columns.DATE.get()));
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
