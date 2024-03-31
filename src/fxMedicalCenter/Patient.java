
package fxMedicalCenter;

public class Patient {

	private String gender;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phone;
    private String email;
    private int insuranceNumber; 
    private String insuranceProvider;
    private String getPharmacyInfo; 
    private String patientID;  
    private String history;  
	private Database db;
	
	
	public enum PatientColumns {//should be moved to seperate enum class
		GENDER("gender"),
		ADDRESS("address"),
		CITY("city"),
		STATE("state"),
		ZIP("zip"),
		PHONE("phone"),
		EMAIL("email"),
		INSURANCE_NUMBER("insurance_id"),
		INSURANCE_PROVIDER("insurance_provider"),
		PATIENT_ID("patient_id"),
		HISTORY("history");
	
		private final String columnName;

		PatientColumns(String columnName) {
			this.columnName = columnName;
		}
		
		public String getColumnName() {
			return columnName;
		}
	}
	 public enum DatabaseSpecifiers{// should be moved to seperate enum class
		 PHARMACY_DB("pharmacies"),
		 PATIENT_DB("patients");
		 
		 private final String databaseName;

		 DatabaseSpecifiers(String databaseName) {
				this.databaseName = databaseName;
			}
			
			public String getDatabaseSpecifiers() {
				return databaseName;
			}
		 
	 }
	
    //default constructor
    public Patient() {
    	setPatient(patientID);//will be handled in controller class on action event.
    }
	
    public void setPatient(String id){ //should be moved to controller class and pass to Data Access interface class to create and handle errors.
    	
    	db.setQuery(DatabaseSpecifiers.PATIENT_DB.getDatabaseSpecifiers(), PatientColumns.PATIENT_ID.getColumnName(), id);
    	db.query();
    	if (db.next()) {
    		gender = db.getString(PatientColumns.GENDER.getColumnName());
    		address = db.getString(PatientColumns.ADDRESS.getColumnName());
    		city = db.getString(PatientColumns.CITY.getColumnName());
    		state = db.getString(PatientColumns.STATE.getColumnName());
    		zip = db.getInt(PatientColumns.ZIP.getColumnName());
    		phone = db.getString(PatientColumns.PHONE.getColumnName());
    		email = db.getString(PatientColumns.EMAIL.getColumnName());
    		insuranceNumber = db.getInt(PatientColumns.INSURANCE_NUMBER.getColumnName());
    		insuranceProvider = db.getString(PatientColumns.INSURANCE_PROVIDER.getColumnName());
    		history = db.getString(PatientColumns.HISTORY.getColumnName());
    		
    	}
    }
    
    //getters and setters
     

    // Setter for gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter for gender
    public String getGender() {
        return gender;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for city
    public void setCity(String city) {
        this.city = city;
    }

    // Getter for city
    public String getCity() {
        return city;
    }

    // Setter for state
    public void setState(String state) {
        this.state = state;
    }

    // Getter for state
    public String getState() {
        return state;
    }

    // Setter for zip
    public void setZip(int zip) {
        this.zip = zip;
    }

    // Getter for zip
    public int getZip() {
        return zip;
    }

    // Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for insurance number
    public void setInsuranceNumber(int insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    // Getter for insurance number
    public int getInsuranceNumber() {
        return insuranceNumber;
    }

    // Setter for insurance provider
    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    // Getter for insurance provider
    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    // Setter for pharmacy information
    public void setGetPharmacyInfo(String getPharmacyInfo) {
        this.getPharmacyInfo = getPharmacyInfo;
    }

    // Getter for pharmacy information
    public String getGetPharmacyInfo() {
        return getPharmacyInfo;
    }

    // Setter for patient ID
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    // Getter for patient ID
    public String getPatientID() {
        return patientID;
    }

    // Setter for history
    public void setHistory(String history) {
        this.history = history;
    }

    // Getter for history
    public String getHistory() {
        return history;
    }
    
}