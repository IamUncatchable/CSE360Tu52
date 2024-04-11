
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
	private String birthday;
	
    //default constructor
    public Patient() {
    	db = new Database();
    }
    
    public boolean newPatient(String gender,String address,String city,String state,int zip,int phone,String email,int insuranceNumber,String insuranceProvider,String history,String firstName,String lastName,String birthday) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.birthday = birthday;
    	this.gender = gender;
    	this.insuranceProvider = insuranceProvider;
    	this.insuranceNumber = insuranceNumber;
    	this.address = address;
    	this.city = city;
    	this.state = state;
    	this.zip =  zip;
    	this.email = email;
    	this.phone = phone;
    	
    	generateID();
    	return db.createPatient(gender, address, city, state, zip, phone, email, insuranceNumber, insuranceProvider, patientID, history,firstName,lastName,birthday);
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
    		firstName = db.getString(Columns.FIRST_NAME.get());
    		lastName = db.getString(Columns.LAST_NAME.get());
    		birthday = db.getString(Columns.BIRTHDAY.get());
    	}
    }
    
    //getters and setters
    
    public void setBirthday(String birthday) {
    	this.birthday = birthday;
    	db.updateString(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.BIRTHDAY.get(), birthday);
    }
     
    public String getBirthday() {
    	return birthday;
    }
    
    //setter for first name
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    	db.updateString(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.FIRST_NAME.get(), firstName);
    }
    
    //getter for first name
    public String getFirstName() {
    	return firstName;
    }
    
    //setter for last name
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    	db.updateString(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.LAST_NAME.get(), lastName);
    }
    
    //getter for last name
    public String getLastName() {
    	return lastName;
    }
    
    // Setter for gender
    public void setGender(String gender) {
        this.gender = gender;
        db.updateString(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.GENDER.get(), gender);
    }

    // Getter for gender
    public String getGender() {
        return gender;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
        db.updateString(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.ADDRESS.get(), address);
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for city
    public void setCity(String city) {
        this.city = city;
        db.updateString(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.CITY.get(), city);
    }

    // Getter for city
    public String getCity() {
        return city;
    }

    // Setter for state
    public void setState(String state) {
        this.state = state;
        db.updateString(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.STATE.get(), state);
    }

    // Getter for state
    public String getState() {
        return state;
    }

    // Setter for zip
    public void setZip(int zip) {
        this.zip = zip;
        db.updateInt(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.ZIP.get(), zip);
    }

    // Getter for zip
    public int getZip() {
        return zip;
    }

    // Setter for phone
    public void setPhone(int phone) {
        this.phone = phone;
        db.updateInt(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.PHONE_NUMBER.get(), phone);
    }

    // Getter for phone
    public int getPhone() {
        return phone;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
        db.updateString(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.EMAIL.get(), email);
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for insurance number
    public void setInsuranceNumber(int insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
        db.updateInt(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.INSURANCE_ID.get(), insuranceNumber);
    }

    // Getter for insurance number
    public int getInsuranceNumber() {
        return insuranceNumber;
    }

    // Setter for insurance provider
    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
        db.updateString(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.INSURANCE_PROVIDER.get(), insuranceProvider);
    }

    // Getter for insurance provider
    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    // Getter for patient ID
    public String getPatientID() {
        return patientID;
    }

    // Setter for history
    public void setHistory(String history) {
        this.history = history;
        db.updateString(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), patientID, Columns.HISTORY.get(), history);
    }

    // Getter for history
    public String getHistory() {
        return history;
    }
    
    public void generateID() {
    	String baseID = birthday + "_"+firstName+"_"+lastName;
    	db.setQuery(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), baseID);
    	db.query();
    	
    	if(!db.next()) {
    		patientID = baseID;
    	} else {
    		boolean unique = false;
    		int count = 1;
    		while (!unique) {
    			String testID = baseID + "-"+count;
    			db.setQuery(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), testID);
    	    	db.query();
    	    	if(!db.next()) {
    	    		patientID = testID;
    	    		unique = true;
    	    	} else {
    	    		count++;
    	    	}
    		}
    	}
    }
    
}