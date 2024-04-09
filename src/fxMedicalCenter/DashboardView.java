package fxMedicalCenter;
// this is jsut the cards of the dashboard home page 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DashboardView {
	private BorderPane centerContent;
	private String rightSideArt = "/rightBar1.jpg";
	private String bannerText = DashboardEnums.DASHBOARD.get();
	private static final String DASHBOARD_CARD_FONT = "dashboard-card-font";
	private static final String BUTTON_STYLE_LIGHT_GREEN = "button-light-green";

	Button currentMedViewButton;
	Button currentMedRefillButton;
	Button requestRecordsButton;
	Button recentVisitsViewButton;
	Button messagesReadButton;
	Button messagesComposeButton;
	
	DashboardView(){
		centerContent = new BorderPane();
		setCenterView();
	}
	
	private void setCenterView() {
		GridPane cardArray = new GridPane();
		VBox currentMedsCard = new VBox();
		VBox medicalRecordsCard = new VBox();
		VBox recentVisitsCard = new VBox();
		VBox messagesCard = new VBox();

		// initialize and create buttons
		currentMedViewButton = createCardButton("View");
		currentMedRefillButton = createCardButton("Refill");
		requestRecordsButton = createCardButton("Request");
		recentVisitsViewButton = createCardButton("View All");
		messagesReadButton = createCardButton("Read");
		messagesComposeButton = createCardButton("Compose");

		// create labels for cards
		Label currentMedsLabel = new Label("Current Medications");
		currentMedsLabel.getStyleClass().add(DASHBOARD_CARD_FONT);
		Label medicalrecordsLabel = new Label("Medical Records");
		medicalrecordsLabel.getStyleClass().add(DASHBOARD_CARD_FONT);
		Label recentVisitsLabel = new Label("Recent Visits");
		recentVisitsLabel.getStyleClass().add(DASHBOARD_CARD_FONT);
		Label messagesLabel = new Label("Messages");
		messagesLabel.getStyleClass().add(DASHBOARD_CARD_FONT);

		// create empty text fields for short info to display
		TextField currentMedsTextField = createCardTextField("short messages can go here");
		TextField medicalRecordsTextField = createCardTextField("short messages can go here");
		TextField recentVisitsTextField = createCardTextField("short messages can go here");
		TextField messagesTextField = createCardTextField("short messages can go here");
		
		// place current meds and message buttons in hboxes
		HBox currentMedsButtonsBox = new HBox(currentMedViewButton, currentMedRefillButton);
		currentMedsButtonsBox.setAlignment(Pos.CENTER);
		currentMedsButtonsBox.setSpacing(20);
		HBox messagesButtonBox = new HBox(messagesReadButton, messagesComposeButton);
		messagesButtonBox.setAlignment(Pos.CENTER);
		messagesButtonBox.setSpacing(20);
		
		// place elements in cards
		currentMedsCard.getChildren().addAll(currentMedsLabel, currentMedsTextField, currentMedsButtonsBox);
		medicalRecordsCard.getChildren().addAll(medicalrecordsLabel, medicalRecordsTextField, requestRecordsButton);
		recentVisitsCard.getChildren().addAll(recentVisitsLabel, recentVisitsTextField, recentVisitsViewButton);
		messagesCard.getChildren().addAll(messagesLabel, messagesTextField, messagesButtonBox);
		
		// set size of cards and alignment
		currentMedsCard.setPrefSize(220, 220);
		currentMedsCard.setAlignment(Pos.CENTER);
		medicalRecordsCard.setPrefSize(220, 220);
		medicalRecordsCard.setAlignment(Pos.CENTER);
		
		recentVisitsCard.setPrefSize(220, 220);
		recentVisitsCard.setAlignment(Pos.CENTER);
		
		messagesCard.setPrefSize(220, 220);
		messagesCard.setAlignment(Pos.CENTER);
		
		//set padding and gaps
		cardArray.setPadding(new Insets(10, 10, 10, 10));
		cardArray.setHgap(50);
		cardArray.setHgap(50);

		// place cards in card array grid pane
		cardArray.add(currentMedsCard, 0, 0);
		cardArray.add(medicalRecordsCard, 1, 0);
		cardArray.add(recentVisitsCard, 2, 0);
		cardArray.add(messagesCard, 0, 1);

		
		centerContent.setCenter(cardArray);
		}

	// template for card view buttons
	
	private Button createCardButton(String text) {
	    Button button = new Button(text);
	    button.getStyleClass().add(BUTTON_STYLE_LIGHT_GREEN);
	    button.setPrefSize(80, 30);
	    button.setMaxSize(80, 30);
	    button.setMinSize(80, 30);
	    return button;
	}
	private TextField createCardTextField(String text) {
	    TextField textField = new TextField(text);
	    textField.setEditable(false);
	    textField.setPrefSize(220, 160);
	    return textField;
	}
	public BorderPane getCenterView() {
		return centerContent;
	}
	
}
