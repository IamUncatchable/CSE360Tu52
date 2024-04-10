package fxMedicalCenter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class nurseNotesEntry {

	private Visit currentVisit;
	private User currentUser;
	private Stage currentStage;
	private Patient currentPatient;
	private BorderPane root;
	
	public nurseNotesEntry(Visit visit,User user,Stage stage) {
		currentVisit = visit;
		currentUser = user;
		currentStage = stage;
		currentPatient = new Patient();
		currentPatient.setPatient(visit.getPatientID());
		root = new BorderPane();
		generateNotesScreen();
	}
	
	private void generateNotesScreen() {
		
		HBox top = new HBox();
		HBox patientNameAndInfo = new HBox();
		patientNameAndInfo.getStyleClass().add("scroll");
		patientNameAndInfo.setMaxHeight(150);
		patientNameAndInfo.setMaxWidth(300);
		String patientInfo = currentPatient.getFirstName() + " " + currentPatient.getLastName() +", " + currentPatient.getBirthday() + ", " + currentPatient.getGender();
		Label pInfoLabel = new Label(patientInfo);
		pInfoLabel.getStyleClass().add("title");
		ImageView logo = new ImageView(new Image("/Minimalist_Hospital_and_Medical_Health_Logo.png"));
		logo.setFitHeight(250);
		logo.setFitWidth(250);
		top.getChildren().add(0,logo);
		top.getChildren().add(1,patientNameAndInfo);
		patientNameAndInfo.getChildren().add(0,pInfoLabel);
		
		
		root.setTop(top);
		Scene scene = new Scene(root,currentStage.getWidth(),currentStage.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();

	}
}
