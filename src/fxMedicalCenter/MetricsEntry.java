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
	private int sceneX = 1200;
	private int sceneY = 800;
	
	public MetricsEntry(Visit visit,User currentUser,Stage currentStage) {
		this.visit = visit;
		this.currentUser = currentUser;
		this.currentStage = currentStage;
		BorderPane root = new BorderPane();
		
		
		Scene scene = new Scene(root,sceneX,sceneY);
		currentStage.setTitle("FX Medical Center");
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();
	}
}
