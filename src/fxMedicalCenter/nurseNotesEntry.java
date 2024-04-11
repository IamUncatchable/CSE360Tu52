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
import java.time.LocalDate;

public class nurseNotesEntry {
	private DashboardBase dashboardBase;
	private Visit currentVisit;
	private User currentUser;
	private Stage currentStage;
	private Patient currentPatient;
	private BorderPane root;
	private TextField history,nurseNotes;
	
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
		top.setAlignment(Pos.CENTER_LEFT);
		patientNameAndInfo.getStyleClass().add("scroll");
		patientNameAndInfo.setMaxHeight(100);
		patientNameAndInfo.setMinWidth(400);
		patientNameAndInfo.setAlignment(Pos.CENTER);
		
		String patientInfo = currentPatient.getFirstName() + " " + currentPatient.getLastName() +", " + currentPatient.getBirthday() + ", " + currentPatient.getGender();
		Label pInfoLabel = new Label(patientInfo);
		pInfoLabel.getStyleClass().add("title");
		ImageView logo = new ImageView(new Image("/Minimalist_Hospital_and_Medical_Health_Logo.png"));
		logo.setFitHeight(250);
		logo.setFitWidth(250);
		top.getChildren().add(0,logo);
		top.getChildren().add(1,patientNameAndInfo);
		patientNameAndInfo.getChildren().add(0,pInfoLabel);
		
		
		HBox dateLogout = new HBox();
		dateLogout.setAlignment(Pos.CENTER_RIGHT);
		dateLogout.setSpacing(20);
		dateLogout.setTranslateX(200);
		Label date = new Label(LocalDate.now().toString());
		date.getStyleClass().add("defaultText");
		Button signout = new Button();
		signout.setText("Sign out");
		signout.getStyleClass().add("Button");
		signout.setOnAction (new EventHandler<>() {
            public void handle(ActionEvent event) {
            	new LoginScreen(currentStage);
            }
		});
		
		dateLogout.getChildren().add(0,date);
		dateLogout.getChildren().add(1,signout);
		top.getChildren().add(2,dateLogout);
		
		//////////////////////////////////////////////////////////////////////////
		//Right side of BorderPane
		//////////////////////////////////////////////////////////////////////////
		
		
		Label weightLabel = new Label("Weight");
		weightLabel.getStyleClass().add("defaultTextBold");
		Label weight = new Label(""+currentVisit.getWeight());
		weight.getStyleClass().add("defaultText");
		VBox weightBox =new VBox();
		weightBox.setSpacing(-20);
		weightBox.getChildren().add(0,weightLabel);
		weightBox.getChildren().add(1,weight);
		
		Label heightLabel = new Label("Height");
		heightLabel.getStyleClass().add("defaultTextBold");
		Label height = new Label(""+currentVisit.getHeight());
		height.getStyleClass().add("defaultText");
		VBox heightBox =new VBox();
		heightBox.setSpacing(-20);
		heightBox.getChildren().add(0,heightLabel);
		heightBox.getChildren().add(1,height);
		
		Label tempLabel = new Label("Temperature");
		tempLabel.getStyleClass().add("defaultTextBold");
		Label temp = new Label(""+currentVisit.getTemp());
		temp.getStyleClass().add("defaultText");
		VBox tempBox =new VBox();
		tempBox.setSpacing(-20);
		tempBox.getChildren().add(0,tempLabel);
		tempBox.getChildren().add(1,temp);
		
		Label bloodLabel = new Label("Blood Pressure");
		bloodLabel.getStyleClass().add("defaultTextBold");
		Label blood = new Label(""+currentVisit.getPressure());
		blood.getStyleClass().add("defaultText");
		VBox bloodBox =new VBox();
		bloodBox.setSpacing(-20);
		bloodBox.getChildren().add(0,bloodLabel);
		bloodBox.getChildren().add(1,blood);
		
		GridPane metrics = new GridPane();
		metrics.add(weightBox, 0, 0);
		metrics.add(heightBox, 1, 0);
		metrics.add(tempBox, 0, 1);
		metrics.add(bloodBox, 1, 1);
		metrics.setHgap(20);
		metrics.setVgap(5);
		
		Button ready = new Button();
		ready.setText("Ready for Doctor");
		ready.getStyleClass().add("Button");
		ready.setAlignment(Pos.BOTTOM_CENTER);
		ready.setOnAction (new EventHandler<>() {
            public void handle(ActionEvent event) {
            	doReadyForDR();
            }
		});
		
		VBox right = new VBox();
		right.setAlignment(Pos.TOP_CENTER);
		right.getChildren().add(0,metrics);
		right.getChildren().add(1,ready);
		right.setTranslateX(-100);
		right.setSpacing(200);
		
		
		////////////////////////////////////////
		//Center pane
		////////////////////////////////////////
		
		Label historyLabel = new Label("History");
		historyLabel.getStyleClass().add("defaultText");
		history = new TextField(currentPatient.getHistory());
		history.getStyleClass().add("TextBox2");
		history.setMaxHeight(200);
		history.setMinHeight(200);
		history.setAlignment(Pos.TOP_LEFT);
		VBox historyBox= new VBox();
		historyBox.getChildren().add(0,historyLabel);
		historyBox.getChildren().add(1,history);
		
		Label nurseNotesLabel = new Label("Nurse's Notes");
		nurseNotesLabel.getStyleClass().add("defaultText");
		nurseNotes = new TextField();
		nurseNotes.getStyleClass().add("TextBox2");
		nurseNotes.setMaxHeight(200);
		nurseNotes.setMinHeight(200);
		nurseNotes.setAlignment(Pos.TOP_LEFT);
		VBox nurseNotesBox= new VBox();
		nurseNotesBox.getChildren().add(0,nurseNotesLabel);
		nurseNotesBox.getChildren().add(1,nurseNotes);
		
		VBox center = new VBox();
		center.setTranslateX(-50);
		center.setMaxWidth(600);
		center.getChildren().add(0,historyBox);
		center.getChildren().add(1,nurseNotesBox);
		
		root.setCenter(center);
		root.setRight(right);
		root.setTop(top);
		Scene scene = new Scene(root,currentStage.getWidth(),currentStage.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();

	}
	
	private void doReadyForDR() {
		currentVisit.setNurseNotes(nurseNotes.getText());
		currentPatient.setHistory(history.getText());
		new DRNotesEntry(currentUser,currentVisit,currentStage,currentPatient);
	}
}
