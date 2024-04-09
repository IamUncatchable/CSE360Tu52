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
	private TextField blood;
	private TextField temp;
	private TextField height;
	private TextField weight;

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
		title.setTranslateY(250);
		title.getStyleClass().add("title");
		top.getChildren().add(title);
		root.setTop(top);
		
		GridPane center = new GridPane();
		center.setHgap(10);
		center.setVgap(10);
		center.setAlignment(Pos.CENTER);
		VBox weightBox = new VBox();
		weightBox.setAlignment(Pos.CENTER);
		weightBox.setSpacing(10);
		weightBox.maxWidth(200);
		weightBox.minWidth(200);
		Label weightLabel = new Label("Weight");
		weightLabel.getStyleClass().add("defaultText");
		weight = new TextField();
		weight.getStyleClass().add("TextBox");
		
		weightBox.getChildren().add(0,weightLabel);
		weightBox.getChildren().add(1,weight);
		
		VBox heightBox = new VBox();
		heightBox.setAlignment(Pos.CENTER);
		heightBox.setSpacing(10);
		Label heightLabel = new Label("Height");
		heightLabel.getStyleClass().add("defaultText");
		height = new TextField();
		height.getStyleClass().add("TextBox");
		
		heightBox.getChildren().add(0,heightLabel);
		heightBox.getChildren().add(1,height);
		
		VBox tempBox = new VBox();
		tempBox.setAlignment(Pos.CENTER);
		tempBox.setSpacing(10);
		Label tempLabel = new Label("Temperature");
		tempLabel.getStyleClass().add("defaultText");
		temp = new TextField();
		temp.getStyleClass().add("TextBox");
		
		tempBox.getChildren().add(0,tempLabel);
		tempBox.getChildren().add(1,temp);
		
		VBox bloodBox = new VBox();
		bloodBox.setAlignment(Pos.CENTER);
		bloodBox.setSpacing(10);
		Label bloodLabel = new Label("Blood Pressure");
		bloodLabel.getStyleClass().add("defaultText");
		blood = new TextField();
		blood.getStyleClass().add("TextBox");
		
		bloodBox.getChildren().add(0,bloodLabel);
		bloodBox.getChildren().add(1,blood);
		
		
		center.add(weightBox, 0, 0);
		center.add(heightBox, 1, 0);
		center.add(tempBox,0,1);
		center.add(bloodBox, 1, 1);
		
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.CENTER);
		Button save = new Button();
		save.setTranslateY(-150);
		save.setText("Save Metrics");
		save.getStyleClass().add("Button");
		save.setOnAction (new EventHandler<>() {
            public void handle(ActionEvent event) {
            	saveMetrics();
            }
		});
		bottom.getChildren().add(0,save);
		
		
		
		root.setBottom(bottom);
		root.setCenter(center);
		Scene scene = new Scene(root,currentStage.getWidth(),currentStage.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();

	}
	
	private void saveMetrics() {
		try {
    		int patientWeight = Integer.parseInt(weight.getText());
    		
    	} catch (NumberFormatException e) {
    		new Error("Invalid characters");
    	}
	}
	
}
