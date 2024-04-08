package fxMedicalCenter;

import java.time.LocalDate;

public class Prescription {
	int id;
	LocalDate date;
	int refills;
	String prescribed;
	
	public Prescription(int prescriptID,LocalDate newDate,int numRefills,String prescription){
		id = prescriptID;
		date = newDate;
		refills = numRefills;
		prescribed = prescription;
		createPrescription();
	}
	
	public Prescription(int prescriptID) {
		id = prescriptID;
		retrievePrescription();
	}
	
	public int getID() {
		return id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public int getRefills() {
		return refills;
	}
	
	public String getPrescription() {
		return prescribed;
	}

	private void createPrescription() {
		Database database = new Database();
		database.createPrescription(id, date.toString(), prescribed, refills);
	}
	
	private void retrievePrescription() {
		Database database = new Database();
	}
}
