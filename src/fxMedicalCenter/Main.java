package fxMedicalCenter;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.time.LocalDate;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		new LoginScreen(primaryStage);
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
