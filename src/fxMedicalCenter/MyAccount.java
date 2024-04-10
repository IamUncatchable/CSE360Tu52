package fxMedicalCenter;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MyAccount {

	private BorderPane root; 
	private User currentUser; 
	private Patient currentPatient; 
	
	public MyAccount(User user) {
		currentUser = user; 
		currentPatient = new Patient(); 
		
		currentPatient.setPatient(currentUser.getPatientID());
		
		VBox top = new VBox(20);
		Label patientName = new Label("Name: " + currentPatient.getFirstName() + " " + currentPatient.getLastName());
		Label patientBirthday = new Label("Birthday: " + currentPatient.getBirthday());
		Label patientGender = new Label("Gender: " + currentPatient.getGender());
		Label patientAddress = new Label("Address: " + currentPatient.getAddress());
		Label patientCity = new Label("City: " + currentPatient.getCity());
		Label patientState = new Label("State: " + currentPatient.getState());
		Label patientZip = new Label("ZIP: " + currentPatient.getZip());
		Label patientPhone = new Label("Phone: " + currentPatient.getPhone());
		Label patientEmail = new Label("Email: " + currentPatient.getEmail());
		Label patientInsurance = new Label("Insurance Number: " + currentPatient.getInsuranceNumber());
		Label patientProvider = new Label("Insurance Provider: " + currentPatient.getInsuranceProvider());
		Label patientHistory = new Label("History: " + currentPatient.getHistory());


		top.getChildren().add(0,patientName); 
		top.getChildren().add(1,patientBirthday); 
		top.getChildren().add(2,patientGender); 
		top.getChildren().add(3,patientAddress); 
		top.getChildren().add(4,patientCity); 
		top.getChildren().add(5,patientState); 
		top.getChildren().add(6,patientZip); 
		top.getChildren().add(7,patientPhone); 
		top.getChildren().add(8,patientEmail); 
		top.getChildren().add(9,patientInsurance); 
		top.getChildren().add(10,patientProvider);
		top.getChildren().add(11,patientHistory);
		
		
		root = new BorderPane();
		root.getStyleClass().add("dashboard-background-off-white");
		root.setTop(top);
	}
	
	public void setView() {
		
	}
	
	public BorderPane getView() {
		return root; 
	}
	
}
