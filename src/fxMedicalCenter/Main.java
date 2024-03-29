package fxMedicalCenter;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Database data = new Database();
		
		data.setQuery("Patient", "patientid", "1");
		data.query();
		
		data.next();
		System.out.println(data.getString("firstname"));
		System.out.println(data.getInt("phone_number"));
		
		data.updateInt("patient", "patientid", "1", "phone_number", 123412);
		data.updateString("patient","patientid", "1", "firstname", "newValue");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
