package fxMedicalCenter;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		
		Database project = new Database();
		
		//DashboardBase dashboardView = new DashboardBase();
        //DashBoardBaseController dashboardController = new DashBoardBaseController(dashboardView);
		project.createUser("Mason", "password", "Mason", "Adams", "patient", "0101_JohnDoe");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
