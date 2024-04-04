package fxMedicalCenter;
//Constructor initializes screen, call getView to get the screen
//screen size is 1300 x 780
//

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class DashboardTemplate {
	
	private BorderPane screen;
    private GridPane grid;
    private VBox leftBar;
    private HBox topLeftTabs;
    private static final String[] MENU_ITEMS = {"Dashboard", "My Account", "Messages", "Medical Records", "Appointments"};
    private static final String LIGHT_GREEN = "-fx-background-color: #aedd94;";
    private static final String DARK_GREEN = "-fx-background-color: #629c44;";
    private static final String OFF_WHITE = "-fx-background-color: #F7F6F6;";
    private static final String DASH_BANNER_FONT = "-fx-font-size: 24px;";
	//constructor
	public DashboardTemplate() {
		screen = new BorderPane();
		initializeScreen();
	}
			
	//buttons for left side bar
	private Button createButton(String text) {
		Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setOnAction(e -> setActivePage(text));
        button.setStyle(LIGHT_GREEN);
        return button;
  }
	
	//function to move to other pages
	private void setActivePage(String page) {
		
	//actions to call the next page. probably a switch statement
	
	for (Button leftBarButton : leftBar.getChildren().stream().map(n -> (Button) n).toList()) {
	        if (leftBarButton.getText().equals(page)) {
	            leftBarButton.setStyle(DARK_GREEN);//dark green
	        } else {
	            leftBarButton.setStyle(LIGHT_GREEN);//light green
	        }
		}
	}
	
	private void initializeScreen() {
		// use gridpane grid to arrange elements
		
		// set margin from border pane
		// work on only the main elements of the 
		//dash view that will stay the same on every page
		grid = new GridPane();
        leftBar = new VBox(5);
        topLeftTabs = new HBox();
		
		// page background color #F7F6F6
        screen.setStyle(OFF_WHITE);
		
		// add logo image
		// update path or place on web for access
		// add resources folder to build path
		// Minimalist_Hospital_and_Medical_Health_Logo.png
		ImageView logoView = new ImageView(new Image("/Minimalist_Hospital_and_Medical_Health_Logo.png"));
		logoView.setFitHeight(160);
		logoView.setFitWidth(160);
		logoView.setPreserveRatio(true);
		//place image in container
		GridPane.setValignment(logoView, VPos.BOTTOM); 
		
		//left sidebar vbox will go in (0,1) column 0, row 1		
		leftBar.setSpacing(5);;
		leftBar.setAlignment(Pos.CENTER_LEFT);
		
		//add children to left bar
		for (String item : MENU_ITEMS) {
			leftBar.getChildren().add(createButton(item));
		}
		
		// create tabs for home and logout
		Button signOutButton = new Button("Sign Out"), homeButton = new Button("Home");
		signOutButton.setStyle(LIGHT_GREEN + " -fx-background-radius: 15 15 0 0;");
		signOutButton.setPrefWidth(215);
		homeButton.setStyle(LIGHT_GREEN + " -fx-background-radius: 15 15 0 0;");
		homeButton.setPrefWidth(215);
        topLeftTabs.getChildren().addAll(homeButton, signOutButton);
				
		//add side art
        ImageView sideArtView = new ImageView(new Image("/rightBar1.jpg"));
		sideArtView.setFitHeight(700);
		sideArtView.setFitWidth(215);
		sideArtView.setPreserveRatio(true);
		
		//align top left tabs
		GridPane.setHalignment(topLeftTabs, HPos.RIGHT);
		
		// add page banner label
		Label bannerLabel = new Label("This is different on every page");
		bannerLabel.setStyle(DASH_BANNER_FONT);
		Line bannerStylingLine = new Line(0, 0, 400, 0);
		bannerStylingLine.setStyle(LIGHT_GREEN);
		VBox bannerBox = new VBox(10);
		bannerBox.setAlignment(Pos.CENTER_LEFT);
		bannerBox.getChildren().addAll(bannerLabel,bannerStylingLine );
					
		//apply padding and column constraints for gridpane
		setupGridPane();
		//add left side bar
		grid.add(leftBar, 1, 4);
		//add image
		grid.add(logoView, 1, 1, 1, 3);
		//add top left tabs
		grid.add(topLeftTabs, 4, 1, 2, 1);
		//add right side art
		grid.add(sideArtView, 6, 1, 1, 5);
		// add banner
		grid.add(bannerBox, 3, 2, 2,1);
		
		screen.setCenter(grid);
		
	}
	
    private void setupGridPane() {
    grid.setPadding(new Insets(20));
    grid.getColumnConstraints().addAll(new ColumnConstraints(60), new ColumnConstraints(160), new ColumnConstraints(50),
        new ColumnConstraints(240), new ColumnConstraints(240), new ColumnConstraints(240), new ColumnConstraints(250));
    grid.getRowConstraints().addAll(new RowConstraints(50), new RowConstraints(60), new RowConstraints(60),
        new RowConstraints(60), new RowConstraints(230), new RowConstraints(230));
}
	
	public Parent getView() {
		return screen;
	}
}
