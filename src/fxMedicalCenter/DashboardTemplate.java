package fxMedicalCenter;
//Constructor initializes screen, call getView to get the screen
// still need to add content for all of the dashboard screens.
// it's big and ugly and I am sorry
//
//still need to add button actions
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class DashboardTemplate {
	
	private BorderPane screen; // Root node of this  view
	private GridPane grid;
	private ColumnConstraints col0, col1, col2, col3, col4, col5, col6;
	private RowConstraints row0, row1, row2, row3, row4, row5;
	private VBox leftBar; //vbox for left sidebar
	private VBox imageBox;
	private Button SignOutButton;
	private Button homeButton;
	private HBox topLeftTabs;
	private Pane rightSide;
	
	//constructor
	public DashboardTemplate() {
		   screen = new BorderPane();
		   initializeScreen();
	}
	
	//text for for left sidebar
	private static final String[] MENU_ITEMS = {
			"Dashboard", "My Account", "Messages", "Medical Records",
			" Appointments"
	};
	
	//buttons for left side bar
	private Button createButton(String text) {
		Button leftBarButton = new Button(text);
		leftBarButton.setMaxWidth(Double.MAX_VALUE);
		leftBarButton.setOnAction(e -> setActivePage(text));
		leftBarButton.setStyle("-fx-background-color: #aedd94;");//light green
		return leftBarButton;
	}
	
	//function to move to other pages
	private void setActivePage(String page) {
		
	//actions to call the next page. probably a switch statement
	
		for (Button leftBarButton : leftBar.getChildren().stream().map(n -> (Button) n).toList()) {
	        if (leftBarButton.getText().equals(page)) {
	            leftBarButton.setStyle("-fx-background-color: #629c44;");//dark green
	        } else {
	            leftBarButton.setStyle("-fx-background-color: #aedd94;");//light green
	        }
		}
	}
	
	private void initializeScreen() {
		// use gridpane grid to arrange elements
		
		// set margin from border pane
		// work on only the main elements of the 
		//dash view that will stay the same on every page
		grid = new GridPane();
		leftBar = new VBox();
		topLeftTabs = new HBox();
		
		// page background color #F7F6F6
		screen.setStyle("-fx-background-color: #F7F6F6;");
		
		// add logo image
		// update path or place on web for access
		// go in grid 0,0, 1, 3 row 0 column 0 occupy 1 column and 3 rows
		// add resources folder to build path
		// /Minimalist_Hospital_and_Medical_Health_Logo.png
		//FIXME image not aligned right need to adjust
		Image image = new Image("/Minimalist_Hospital_and_Medical_Health_Logo.png");
		ImageView logoView = new ImageView(image);
		logoView.setFitHeight(160);
		logoView.setFitWidth(160);
		logoView.setPreserveRatio(true);
		//place image in container
		imageBox = new VBox(logoView);
		imageBox.setAlignment(Pos.BOTTOM_CENTER);
		
		//left sidebar vbox will go in (0,1) column 0, row 1		
		leftBar.setSpacing(5);;
		leftBar.setAlignment(Pos.CENTER_LEFT);
		
		//add children to left bar
		for (String item : MENU_ITEMS) {
			leftBar.getChildren().add(createButton(item));
		}
		
		
		
		// create tabs for home and logout
		// place buttons in grid pane position 2,0,2,1
		SignOutButton = new Button("Sign Out");
		homeButton = new Button("Home");
		
		//styling for home and signout tabs
		SignOutButton.setStyle("-fx-background-color: #aedd94; -fx-background-radius: 15 15 0 0;");//light green
		SignOutButton.setPrefWidth(215);
		homeButton.setStyle("-fx-background-color: #aedd94; -fx-background-radius: 15 15 0 0;");
		homeButton.setPrefWidth(215);
		
		//place buttons in container
		topLeftTabs.getChildren().addAll(homeButton, SignOutButton);
		
		//add side art
		// place in grid pane at 4, 0, 0, 5
		Image sideArt = new Image("/rightBar1.jpg");
		ImageView sideArtView = new ImageView(sideArt);
		sideArtView.setFitHeight(700);
		sideArtView.setFitWidth(215);
		sideArtView.setPreserveRatio(true);
		
		//place image in container
		rightSide = new Pane(sideArtView);
		
		//align top left tabs
		GridPane.setHalignment(topLeftTabs, HPos.RIGHT);
		
		// add page banner label
		Label bannerLabel = new Label("This is different on every page");
		bannerLabel.setStyle("-fx-font-size: 24px;");
		Line bannerStylingLine = new Line(0, 0, 400, 0);
		bannerStylingLine.setStyle("-fx-stroke: #aedd94;");
		VBox bannerBox = new VBox(10);
		bannerBox.setAlignment(Pos.CENTER_LEFT);
		bannerBox.getChildren().addAll(bannerLabel,bannerStylingLine );
	
		
		
		
		
		//column constraints
		col0 = new ColumnConstraints(30);
		col1 = new ColumnConstraints(160);
		col2 = new ColumnConstraints(50);
		col3 = new ColumnConstraints(240);
		col4 = new ColumnConstraints(240);
		col5 = new ColumnConstraints(240);
		col6 = new ColumnConstraints(250);
		
		//set row constraints 60,60,60,230,230
		// rows beyond 2 will need to change to accomodate specific screens
		//this arrangement is for card display 
		// text field and label displays require smaller grid panes height 40
		// would love to have dynamic resizing but...
		row0 = new RowConstraints(50);
		row1 = new RowConstraints(60);
		row2 = new RowConstraints(60);
		row3 = new RowConstraints(60);
		row4 = new RowConstraints(230);
		row5 = new RowConstraints(230);
		
		//apply padding and column constraints for gridpane
		grid.setPadding(new Insets(20,20,20,20));
		grid.getColumnConstraints().addAll(col0, col1, col2, col3, col4, col5, col6);
		grid.getRowConstraints().addAll(row0, row1, row2, row3, row4, row5);
		
		//add left side bar
		grid.add(leftBar, 1, 4);
		//add image
		grid.add(imageBox, 1, 1, 1, 3);
		//add top left tabs
		grid.add(topLeftTabs, 4, 1, 2, 1);
		//add right side art
		grid.add(sideArtView, 6, 1, 1, 5);
		// add banner
		grid.add(bannerBox, 3, 2, 2,1);
		
		screen.setCenter(grid);
		
	}
	
	public Parent getView() {
		   return screen;
		}
}
