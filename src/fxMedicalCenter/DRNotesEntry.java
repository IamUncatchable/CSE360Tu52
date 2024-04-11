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

public class DRNotesEntry {
	
	
	
	private Visit currentVisit;
	private User currentUser;
	private Stage currentStage;
	private Patient currentPatient;
	private BorderPane root;
	private TextField history,drNotes;
	
	public DRNotesEntry(User user, Visit visit, Stage stage,Patient patient) {
		currentVisit = visit;
		currentUser = user;
		currentStage = stage;
		currentPatient = patient;
		
	}
}
