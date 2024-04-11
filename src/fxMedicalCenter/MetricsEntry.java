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
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class MetricsEntry {
	private DashboardBase dashboardBase;
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
		VBox center = new VBox();
		center.setAlignment(Pos.CENTER);
		Label title = new Label(patient.getFirstName()+"'s Metrics today");
		title.getStyleClass().add("title");
		Button signout = new Button();
		signout.setText("Sign out");
		signout.getStyleClass().add("Button");
		signout.setAlignment(Pos.TOP_RIGHT);
		signout.setOnAction (new EventHandler<>() {
            public void handle(ActionEvent event) {
            	new LoginScreen(currentStage);
            }
		});
		center.getChildren().add(0,title);
		VBox right = new VBox();
		right.getChildren().add(0,signout);
		right.setPadding(Insets.EMPTY);
		root.setRight(right);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER);
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
		
		
		grid.add(weightBox, 0, 0);
		grid.add(heightBox, 1, 0);
		grid.add(tempBox,0,1);
		grid.add(bloodBox, 1, 1);
		
		//HBox bottom = new HBox();
		//bottom.setAlignment(Pos.CENTER);
		Button save = new Button();
		save.setText("Save Metrics");
		save.setAlignment(Pos.CENTER);
		save.getStyleClass().add("Button");
		save.setTranslateX(325);
		save.setTranslateY(50);
		save.setOnAction (new EventHandler<>() {
            public void handle(ActionEvent event) {
            	saveMetrics();
            }
		});
		/*bottom.getChildren().add(0,save);
		
		
		
		root.setBottom(bottom);
		*/
		grid.add(save, 0, 2,2,1);
		center.getChildren().add(1,grid);
		root.setCenter(center);
		Scene scene = new Scene(root,currentStage.getWidth(),currentStage.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();

	}
	
	private void saveMetrics() {
		try {
    		visit.setWeight(Integer.parseInt(weight.getText()));
    		visit.setHeight(Integer.parseInt(height.getText()));
    		visit.setPressure(Integer.parseInt(blood.getText()));
    		visit.setTemp(Integer.parseInt(temp.getText()));
    		new nurseNotesEntry(visit,currentUser,currentStage);
    	} catch (NumberFormatException e) {
    		new Error("Invalid characters detected in field or a field is empty.");
    	}
	}
	
}
