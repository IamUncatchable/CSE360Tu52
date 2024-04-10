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
		
		//new LoginScreen(primaryStage);
		
		 Map<String, PaneProvider> providers = new HashMap<>();
		

		// instantiate views
		MessagesView messagesView = new MessagesView();
		MessagesController messagesController = new MessagesController(messagesView);
		providers.put(DashboardEnums.MESSAGES.get(), messagesController);
		
		DashboardBase dashboardView = new DashboardBase();
		DashBoardBaseController dashboardController = new DashBoardBaseController(dashboardView, providers);

		
		

		Scene scene = new Scene(dashboardView.getView(), 1366, 780);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		  
		  
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
