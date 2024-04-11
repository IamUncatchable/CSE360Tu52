package fxMedicalCenter;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		new LoginScreen(primaryStage);
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
