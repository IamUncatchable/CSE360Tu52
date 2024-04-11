package fxMedicalCenter;

import java.util.HashMap;
import java.util.Map;

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

public class LoginScreen {
	private Stage currentStage;
	private BorderPane root;
	private User currentUser;
	private Visit currentVisit; 
	private final int SCENEX = 1200;
	private int SCENEY = 800;
	private TextField usernameField;
	private PasswordField passwordField;
	
	public LoginScreen(Stage stage) {
		currentStage = stage;
		loginScreenDisplay();
	}
	
	private void loginScreenDisplay() {
		
		root = new BorderPane();
		root.getStyleClass().add("dashboard-background-off-white");
		VBox top = new VBox();
		VBox center = new VBox();
		
		ImageView image = new ImageView(new Image("/Minimalist_Hospital_and_Medical_Health_Logo.png"));
		image.setFitHeight(250);
		image.setFitWidth(250);
		
		Label welcome = new Label("Welcome to fxMedical Center!");
		welcome.getStyleClass().add("title");
		
		top.setAlignment(Pos.CENTER);
		//top.setSpacing(10);
		top.getChildren().add(0,image);
		top.getChildren().add(1, welcome);
		
		//center.getStyleClass().add("scroll");
		center.setAlignment(Pos.TOP_CENTER);
		center.setMaxWidth(SCENEX/2);
		center.setSpacing(20);
		
		Label loginLabel = new Label("Login");
		loginLabel.getStyleClass().add("defaultText");
		
		VBox usernameBox = new VBox();
		Label usernameLabel = new Label("Username");
		usernameLabel.getStyleClass().add("defaultText");
		usernameField = new TextField();
		usernameField.getStyleClass().add("TextBox");
		usernameBox.getChildren().add(0,usernameLabel);
		usernameBox.getChildren().add(1,usernameField);
		usernameBox.setSpacing(5);
		
		VBox passwordBox = new VBox();
		Label passwordLabel = new Label("Password");
		passwordLabel.getStyleClass().add("defaultText");
		passwordField = new PasswordField();
		passwordField.getStyleClass().add("TextBox");
		passwordBox.getChildren().add(0,passwordLabel);
		passwordBox.getChildren().add(1,passwordField);
		passwordBox.setSpacing(5);
		
		center.getChildren().add(0,loginLabel);
		center.getChildren().add(1,usernameBox);
		center.getChildren().add(2,passwordBox);
		
		Button loginButton = new Button();
		loginButton.setText("Login");
		loginButton.getStyleClass().add("Button");
		loginButton.setOnAction (new EventHandler<>() {
            public void handle(ActionEvent event) {
            	doLogin();
            }
		});
		
		Button createUserButton = new Button();
		createUserButton.setText("New Patient Login");
		createUserButton.getStyleClass().add("Button");
		createUserButton.setOnAction (new EventHandler<>() {
            public void handle(ActionEvent event) {
            	doNewPatientLogin();
            }
		});
		
		
		HBox buttons = new HBox();
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().add(0,loginButton);
		
		center.getChildren().add(3,buttons);
		
		root.setTop(top);
		root.setCenter(center);
		Scene scene = new Scene(root,SCENEX,SCENEY);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();
	}
	
	private void doLogin() {
		if(!usernameField.getText().equals("") && !passwordField.getText().equals("")) {
			Database db = new Database();
			db.setEncodedQuery("SELECT * FROM " + Datatables.USERS.get() + " WHERE " + Columns.USERNAME.get()+"='"+usernameField.getText()+"' AND " + Columns.PASSWORD.get()+"='"+passwordField.getText()+"';");
			db.query();
			if(db.next()) {
				loginSuccessful(usernameField.getText());
			} else {
				new Error("Username and Password do not match");
			}
			
		} else {
			new Error("Username or Password is empty.");
		}
	}
	
	private void doNewPatientLogin() {
		
	}
	
	private void loginSuccessful(String username) {
		currentUser = new User(username);
		String type = currentUser.getType();
		
		switch(type){
			case "doctor":
				DoctorsView drview = new DoctorsView();
				drview.start(currentStage);
				break;
			case "nurse":
				new NurseView(currentStage,currentUser);
				break;
			case "patient":
//				Map<String, PaneProvider> providers = new HashMap<>();
				

				// instantiate views
//				MessagesView messagesView = new MessagesView();
//				MessagesController messagesController = new MessagesController(messagesView);
//				providers.put(DashboardEnums.MESSAGES.get(), messagesController);
				
				DashboardBase dashboardView = new DashboardBase(currentStage,currentUser, currentVisit);
				DashBoardBaseController dashboardController = new DashBoardBaseController(dashboardView);

//				DashBoardBaseController dashboardController = new DashBoardBaseController(dashboardView, providers);

				Scene scene = new Scene(dashboardView.getView(), 1366, 780);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				currentStage.setScene(scene);
				currentStage.show();
				break;
			case "receptionist":
				new ReceptionistView(currentStage);
				break;
			default:
				break;
		}
	}
}
