package fxMedicalCenter;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.time.LocalDate;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		

		
		//Database project = new Database();
		
		//new NurseView(pr);
		//DashboardBase dashboardView = new DashboardBase();
        //DashBoardBaseController dashboardController = new DashBoardBaseController(dashboardView);
		//Visit newVisit = new Visit("0101_JohnDoe",LocalDate.now());
		//newVisit.saveNewVisit();
		
		DashboardBase dashboardView = new DashboardBase();
		dashboardView.setCenter(new NurseView().getView());
        DashBoardBaseController dashboardController = new DashBoardBaseController(dashboardView);
        Scene scene = new Scene(dashboardView.getView(), 1366, 780);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

		
		
		
		
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
