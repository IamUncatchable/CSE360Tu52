
package fxMedicalCenter;

public class User {

	    // Attributes
        private String firstName;
        private String lastName;
        private String username;
        private String password;
        private String accountType;
        private String patientID;
    
        // Constructor
        public User(String fName, String lName, String user, String pass, String accountType, String patientID) {
            this.firstName = fName;
            this.lastName = lName;
            this.username = user;
            this.password = pass;
            this.accountType = accountType;
            this.patientID = patientID;
        }
    
        // Getters and Setters
        public String getFirstName() {
            return firstName;
        }
    
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    
        // Similar methods for other attributes...
    
        // Methods
        public boolean requestPassReset() {
            // implementation
            return true; // This should contain logic to determine if the password reset is possible
        }
    
        public void user(String user, int pass) {
            // implementation
        }
    
        // Additional Methods
        public boolean isUsernameValid(String username) {
            // Validate if the username meets your criteria
            return true; // Placeholder
        }
    
        public boolean isPasswordComplex(String password) {
            // Validate if the password meets your criteria
            return true; // Placeholder
        }
    
        public void updatePassword(String newPassword) {
            if (isPasswordComplex(newPassword)) {
                this.password = newPassword;
                // Optionally save the user data
            }
        }
    
        public boolean hasPermission(String action) {
            // Determine if the user has permission based on accountType
            return true; // Placeholder
        }
    
        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", username='" + username + '\'' +
                    ", accountType='" + accountType + '\'' +
                    ", patientID='" + patientID + '\'' +
                    '}';
        }
    
        // Persistence Methods (placeholders)
        public void save() {
            // Implementation to save user details to a database 
        	
        	//NOTE USE UPDATE METHOD TO UPDATE ROWS. SEPARATE CREATE FUNCTION TO CREATE A NEW USER
        	
        }
    
        public static User load(String username) {
            // Implementation to load user details from a database
            return null; // Placeholder
        }
        
        public void createUser() {
        	Database db = new Database();
        	db.createUser(username, password, firstName, lastName, accountType, patientID);
        }
        // More methods as needed...
}
    
