
package fxMedicalCenter;

public class Patient {
	
	private String gender;
    private String address;
    private String city;
    private String state;
    private int zip;
    private int phone;
    private String email;
    private int insuranceNumber; 
    private String insuranceProvider; 
    private String patientID;  
    private String history;  
	private Database db;
	private String firstName;
	private String lastName;
	
    //default constructor
    public Patient() {
    	setPatient(patientID);//will be handled in controller class on action event.
    }
    
    public boolean newPatient() {
    	return db.createPatient(gender, address, city, state, zip, phone, email, insuranceNumber, insuranceProvider, patientID, history,firstName,lastName);
    }
	
    public void setPatient(String id){ //should be moved to controller class and pass to Data Access interface class to create and handle errors.
    	
    	db.setQuery(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), id);
    	db.query();
    	if (db.next()) {
    		gender = db.getString(Columns.GENDER.get());
    		address = db.getString(Columns.ADDRESS.get());
    		city = db.getString(Columns.CITY.get());
    		state = db.getString(Columns.STATE.get());
    		zip = db.getInt(Columns.ZIP.get());
    		phone = db.getInt(Columns.PHONE_NUMBER.get());
    		email = db.getString(Columns.EMAIL.get());
    		insuranceNumber = db.getInt(Columns.INSURANCE_ID.get());
    		insuranceProvider = db.getString(Columns.INSURANCE_PROVIDER.get());
    		history = db.getString(Columns.HISTORY.get());
    		
    	}
    }
    
    //getters and setters
     
    //setter for first name
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    //getter for first name
    public String getFirstName() {
    	return firstName;
    }
    
    //setter for last name
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    //getter for last name
    public String getLastName() {
    	return lastName;
    }
    
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
    public void setPhone(int phone) {
        this.phone = phone;
    }

    // Getter for phone
    public int getPhone() {
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