package fxMedicalCenter;

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

public class DashboardBase {
	private BorderPane screen;
	private GridPane grid;
	private VBox leftBar;
	private HBox topRightTabs;
	private BorderPane centerContent;

	private static final String BUTTON_STYLE_LIGHT_GREEN = "button-light-green";
	private static final String BUTTON_STYLE_DARK_GREEN = "button-dark-green";
	private static final String LIGHT_GREEN_TABS = "button-tab-light-green";

	private Label bannerLabel;
	private ImageView sideArtView;
	private Button dashboardButton, myAccountButton, messagesButton, medicalRecordsButton, appointmentsButton,
			homeButton, signOutButton;

	// constructor
	public DashboardBase() {
		screen = new BorderPane();
		DashboardView dashboardViews = new DashboardView();

		this.centerContent = dashboardViews.getCenterView();
		
		initializeButtons();
		initializeBanner();
		initializeRightArt();
		initializeScreen();
	}

	private void initializeScreen() {
		// use gridpane grid to arrange elements
		grid = setUpGrid();
		setupLeftBar(); //
		setupTopRightTabs();
		setupLogoAndArt(grid);
		setupBannerBox();

		// page background color #F7F6F6
		screen.getStyleClass().add("dashboard-background-off-white");
		grid.add(centerContent, 3, 4, 3, 2);
		screen.setCenter(grid);
	}

	private void initializeBanner() {
		bannerLabel = new Label(DashboardEnums.DASHBOARD.get());
		bannerLabel.getStyleClass().add("dashboard-banner-font");
	}

	private void initializeRightArt() {
		sideArtView = new ImageView(new Image(RightBarImage.RIGHT_BAR_1.get()));
		sideArtView.setFitHeight(700);
		sideArtView.setFitWidth(215);
		sideArtView.setPreserveRatio(true);
		GridPane.setValignment(sideArtView, VPos.TOP);
	}

	private void initializeButtons() {
		// create buttons for left bar
		dashboardButton = createButton(DashboardEnums.DASHBOARD.get());
		myAccountButton = createButton(DashboardEnums.MY_ACCOUNT.get());
		messagesButton = createButton(DashboardEnums.MESSAGES.get());
		medicalRecordsButton = createButton(DashboardEnums.MEDICAL_RECORDS.get());
		appointmentsButton = createButton(DashboardEnums.APPOINTMENTS.get());
	}

	// buttons and actions for left side bar
	private Button createButton(String text) {
		Button button = new Button(text);
		button.setMaxWidth(Double.MAX_VALUE);
		button.setOnAction(e -> setActiveMenuButton(text));
		button.getStyleClass().add(BUTTON_STYLE_LIGHT_GREEN);
		return button;
	}

	// control color of buttons based on dashbaord view selected
	private void setActiveMenuButton(String page) {
		leftBar.getChildren().forEach(node -> {
			if (node instanceof Button) {
				Button button = (Button) node;
				// Remove current styles to prevent conflicts. grr
				button.getStyleClass().removeAll(BUTTON_STYLE_LIGHT_GREEN, BUTTON_STYLE_DARK_GREEN);
				// Apply the dark green style for the active button, or light green for others
				if (button.getText().equals(page)) {
					button.getStyleClass().add(BUTTON_STYLE_DARK_GREEN);
				} else {
					button.getStyleClass().add(BUTTON_STYLE_LIGHT_GREEN);
				}
			}
		});
	}

	// set up the grid pane constraints
	private GridPane setUpGrid() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20));
		grid.getColumnConstraints().addAll(new ColumnConstraints(60), new ColumnConstraints(160),
				new ColumnConstraints(40), new ColumnConstraints(270, 270, Double.MAX_VALUE),
				new ColumnConstraints(270, 270, Double.MAX_VALUE), new ColumnConstraints(270, 270, Double.MAX_VALUE),
				new ColumnConstraints(230));
		grid.getRowConstraints().addAll(new RowConstraints(20), new RowConstraints(60), new RowConstraints(60),
				new RowConstraints(60), new RowConstraints(230), new RowConstraints(230));
		return grid;
	}

	// construct left menu bar
	private void setupLeftBar() {
		leftBar = new VBox(5);
		leftBar.setSpacing(5);
		leftBar.setAlignment(Pos.CENTER_LEFT);


		// add children to left bar
		
		leftBar.getChildren().addAll(dashboardButton, myAccountButton, messagesButton, medicalRecordsButton,
				appointmentsButton);

		// add left side bar to grid
		grid.add(leftBar, 1, 4);
	}

	// construct page display banner
	private void setupBannerBox() {
		// add page banner label

		Line bannerStylingLine = new Line(0, 0, 400, 0);
		bannerStylingLine.getStyleClass().add(BUTTON_STYLE_LIGHT_GREEN);
		VBox bannerBox = new VBox(10);
		bannerBox.setAlignment(Pos.CENTER_LEFT);
		bannerBox.getChildren().addAll(bannerLabel, bannerStylingLine);
		// add banner
		grid.add(bannerBox, 3, 2, 2, 1);
	}

	// create and add home and signout tabs
	private void setupTopRightTabs() {
		// create tabs for home and logout
		signOutButton = new Button("Sign Out");
		signOutButton.getStyleClass().add(LIGHT_GREEN_TABS);
		signOutButton.setPrefWidth(215);
		homeButton = new Button("Home");
		homeButton.getStyleClass().add(LIGHT_GREEN_TABS);
		homeButton.setPrefWidth(215);
		topRightTabs = new HBox();
		topRightTabs.getChildren().addAll(homeButton, signOutButton);

		GridPane.setHalignment(topRightTabs, HPos.RIGHT);

		// add top left tabs
		grid.add(topRightTabs, 4, 1, 2, 1);

	}

	private void setupLogoAndArt(GridPane grid) {
		// right side art

		// add right side art
		grid.add(sideArtView, 6, 1, 1, 5);

		// add logo image
		// update path or place on web for access
		// add resources folder to build path
		// Minimalist_Hospital_and_Medical_Health_Logo.png
		ImageView logoView = new ImageView(new Image("/Minimalist_Hospital_and_Medical_Health_Logo.png"));
		logoView.setFitHeight(160);
		logoView.setFitWidth(160);
		logoView.setPreserveRatio(true);
		// place image in container
		GridPane.setValignment(logoView, VPos.BOTTOM);
		// add logo
		grid.add(logoView, 1, 1, 1, 3);
	}
	
	// returns assembled screen to MainApp

	public Parent getView() {
		return screen;
	}

	// button getters

	public Button getDashboardButton() {
		return dashboardButton;
	}

	public Button getMyAccountButton() {
		return myAccountButton;
	}

	public Button getMessagesButton() {
		return messagesButton;
	}

	public Button getMedicalRecordsButton() {
		return medicalRecordsButton;
	}

	public Button getAppointmentsButton() {
		return appointmentsButton;
	}

	public Button getHomeButton() {
		return homeButton;
	}

	public Button getSignOutButton() {
		return signOutButton;
	}

	// dynamic setters
	public void setCenter(BorderPane centerContentIn) {
		grid.add(centerContentIn, 3, 4, 3, 2);
	}

	public void setBannerText(String bannerTextIn) {
		bannerLabel.setText(bannerTextIn);

	}

	public void setRightArt(String rightSideArtIn) {
		sideArtView.setImage(new Image(rightSideArtIn));

	}

}
