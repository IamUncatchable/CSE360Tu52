package fxMedicalCenter;

import java.util.ArrayList;


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

public class NurseView {
	private User currentUser;
	private BorderPane root;
	public NurseView() {
		
		root = new BorderPane();
		Label waitingPatientsLabel = new Label("Waiting Patients");
		waitingPatientsLabel.getStyleClass().add("title");
		
		
		
		VBox cardBox = new VBox();
		cardBox.getStyleClass().add("scroll");
		cardBox.setAlignment(Pos.TOP_CENTER);
		cardBox.setSpacing(10);
		addWaitingPatientCards(cardBox);
		
		VBox centerBox = new VBox();
		centerBox.getChildren().add(0,waitingPatientsLabel);
		centerBox.getChildren().add(1,cardBox);
		centerBox.setAlignment(Pos.CENTER);
		
		
		root.setCenter(centerBox);
	}
	
	public BorderPane getView() {
		return root;
	}
	
	private void addWaitingPatientCards(VBox scroll){
		ArrayList<Visit> visitIDs = new ArrayList<Visit>();
		Database db = new Database();
		db.setEncodedQuery("SELECT * FROM " + Datatables.VISIT + " WHERE "+Columns.CHECKED_IN.get()+" AND NOT "+ Columns.FINISHED.get()+";");
		db.query();
		
		
		while(db.next()) {
			//System.out.println("waiting");
			int id = db.getInt(Columns.VISIT_ID.get());
			Visit thisVisit = new Visit(id);
			visitIDs.add(thisVisit);
		}
		int numCards = visitIDs.size();
		for(int i = 0; i < numCards; i++) {
			db.setQuery(Datatables.PATIENT.get(), Columns.PATIENT_ID.get(), visitIDs.get(i).getPatientID());
			db.query();
			if(db.next()) {
				Visit thisVisit = visitIDs.get(i);
				String fName = db.getString(Columns.FIRST_NAME.get());
				String lName = db.getString(Columns.LAST_NAME.get());
				//System.out.println(fName + lName);
				Button card = new Button();
				card.getStyleClass().add("Button");
				card.setAlignment(Pos.CENTER);
				//card.setMaxWidth((sceneX/2)-20);
				card.setText(fName + " " + lName);
				card.setOnAction (new EventHandler<>() {
		            public void handle(ActionEvent event) {
		            	new MetricsEntry(thisVisit,currentUser);
		            }
				});
				scroll.getChildren().add(card);

			}
		}
	}
}
