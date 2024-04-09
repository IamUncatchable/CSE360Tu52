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

public class MetricsEntry {

	private Visit visit;
	private User currentUser;
	private Stage currentStage;

	private Patient patient;
	
	public MetricsEntry(Visit visit,User currentUser,Stage currentStage) {
		this.currentStage = currentStage;
		this.visit = visit;
		this.currentUser = currentUser;
		patient = new Patient();
		patient.setPatient(visit.getPatientID());
		BorderPane root = new BorderPane();
		HBox top = new HBox();
		top.setAlignment(Pos.CENTER);
		Label title = new Label(patient.getFirstName()+"'s Metrics today");
		title.getStyleClass().add("title");
		top.getChildren().add(title);
		root.setTop(top);
		
		GridPane center = new GridPane();
		center.setAlignment(Pos.CENTER);
		VBox weightBox = new VBox();
		weightBox.setAlignment(Pos.CENTER);
		weightBox.setSpacing(10);
		Label weightLabel = new Label("Weight");
		TextField weight = new TextField();
		
		weightBox.getChildren().add(0,weightLabel);
		weightBox.getChildren().add(1,weight);
		
		VBox heightBox = new VBox();
		heightBox.setAlignment(Pos.CENTER);
		heightBox.setSpacing(10);
		Label heightLabel = new Label("Height");
		TextField height = new TextField();
		
		heightBox.getChildren().add(0,heightLabel);
		heightBox.getChildren().add(1,height);
		
		VBox tempBox = new VBox();
		tempBox.setAlignment(Pos.CENTER);
		tempBox.setSpacing(10);
		Label tempLabel = new Label("Temperature");
		TextField temp = new TextField();
		
		tempBox.getChildren().add(0,tempLabel);
		tempBox.getChildren().add(1,temp);
		
		VBox bloodBox = new VBox();
		bloodBox.setAlignment(Pos.CENTER);
		bloodBox.setSpacing(10);
		Label bloodLabel = new Label("Blood Pressure");
		TextField blood = new TextField();
		
		bloodBox.getChildren().add(0,bloodLabel);
		bloodBox.getChildren().add(1,blood);
		
		
		center.add(weightBox, 0, 0);
		center.add(heightBox, 1, 0);
		center.add(tempBox,0,1);
		center.add(bloodBox, 1, 1);
		
		
		
		root.setCenter(center);
		Scene scene = new Scene(root,currentStage.getWidth(),currentStage.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();

	}
}
