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
	
	public MetricsEntry(Visit visit,User currentUser) {
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
		VBox weightBox = new VBox();
		TextField weight = new TextField();

	}
}
