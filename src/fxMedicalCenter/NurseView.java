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
	private int sceneX = 1200;
	private int sceneY = 800;
	public NurseView(Stage currentStage) {
		
		BorderPane root = new BorderPane();
		Label waitingPatientsLabel = new Label("Waiting Patients");
		waitingPatientsLabel.getStyleClass().add("title");
		
		
		
		ScrollPane cardBox = new ScrollPane();
		cardBox.getStyleClass().add("scroll");
		cardBox.setMaxWidth(sceneX/2);
		cardBox.setMaxHeight((sceneY*2)/3);
		cardBox.setMinHeight((sceneY*2)/3);
		
		addWaitingPatientCards(cardBox);
		
		VBox centerBox = new VBox();
		centerBox.getChildren().add(0,waitingPatientsLabel);
		centerBox.getChildren().add(1,cardBox);
		centerBox.setAlignment(Pos.CENTER);
		
		
		root.setCenter(centerBox);
		Scene scene = new Scene(root,sceneX,sceneY);
		currentStage.setTitle("FX Medical Center");
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();
	}
	
	private void addWaitingPatientCards(ScrollPane scroll){
		ArrayList<String> patientIDs = new ArrayList<String>();
		Database db = new Database();
		db.setEncodedQuery("SELECT " + Columns.PATIENT_ID.get()+ " FROM " + Datatables.VISIT + " WHERE "+Columns.CHECKED_IN.get()+"=true, "+ Columns.FINISHED.get()+"=false;");
		db.query();
		while(db.next()) {
			patientIDs.add(db.getString(Columns.PATIENT_ID.get()));
		}
	}
}
