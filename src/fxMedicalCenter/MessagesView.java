package fxMedicalCenter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

// apply scroll bar only where necessary on the central component
public class MessagesView {
	VBox centerContent = new VBox();
	private MessagesController controller;

	private static final String BUTTON_STYLE_LIGHT_GREEN = "button-light-green";
	private static final String BUTTON_STYLE_DARK_GREEN = "button-dark-green";
	private static final String LIGHT_GREEN_TABS = "button-tab-light-green";
	private static final String MAIL_HEADER_FONT = "mail-header-font";
	//containers
	private HBox row1;
	private HBox row2;
	private HBox lastRow;
	//buttons
	private Button inboxButton;
	private Button sentButton;
	private Button deletedButton;
	private Button refreshButton;
	private Button previousButton;
	private Button nextButton;
	
	ListView<Email> emailListView = new ListView<>();
	ObservableList<Email> emailItems = FXCollections.observableArrayList();

	
	public MessagesView() {
		centerContent = new VBox();
		
		createMessageView();
	}

	private void createMessageView() {
		Label senderHeaderLabel;
		Label dateTimeHeaderLabel;
		Label subjectHeaderLabel;
		// starting with border pane use Vbox to hold static elements rows 1, 2, and 4.
		// 3rd field of vbox will hold email messages and will be clickable to follow to
		// read view

		 row1 = new HBox(5);
		 row2 = new HBox(5);
		 lastRow = new HBox(5);

		// row 1, 3 button tabs
		// define buttons set actions
		inboxButton = createTabs(MessagesEnums.INBOX.get());
		inboxButton.setOnAction(e -> setActiveMessageViewButton(MessagesEnums.INBOX.get())); // FIXME

		sentButton = createTabs(MessagesEnums.SENT.get());
		sentButton.setOnAction(e -> System.out.println(MessagesEnums.SENT.get()));// FIXME

		deletedButton = createTabs(MessagesEnums.DELETED.get());
		deletedButton.setOnAction(e -> System.out.println(MessagesEnums.DELETED.get()));// FIXME

		row1.getChildren().addAll(inboxButton, sentButton, deletedButton);
		centerContent.getChildren().add(row1);

		// row 2 contains select all checkbox and header for columns of mail
		// descriptions
		CheckBox selectAll = new CheckBox();
		senderHeaderLabel = createHeaderLabel(MessagesEnums.SENDER.get());
		subjectHeaderLabel = createHeaderLabel(MessagesEnums.SUBJECT.get());
		dateTimeHeaderLabel = createHeaderLabel(MessagesEnums.TIME_STAMP.get());

		HBox.setHgrow(subjectHeaderLabel, Priority.ALWAYS);
		subjectHeaderLabel.setPrefWidth(420);
		HBox.setMargin(selectAll, new Insets(5));
		row2.getChildren().addAll(selectAll, senderHeaderLabel, subjectHeaderLabel, dateTimeHeaderLabel);

		centerContent.getChildren().add(row2);
		
		// row 3 dynamic size based on number of emails retrieved
		// it should get larger or smaller based on content this is annoying.
		VBox emailList = new VBox();
		//emailListView.setItems(datasource.getEmailItems()); or some other logic to be determined
		emailListView.setPrefWidth(750);
		emailListView.setMinWidth(750);
		emailListView.setMaxSize(750, 360);

		ScrollPane mailListScrollPane = new ScrollPane(emailListView);
		mailListScrollPane.setFitToWidth(true); 
		mailListScrollPane.setFitToHeight(true);
		mailListScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

		emailList.getChildren().add(mailListScrollPane);
		centerContent.getChildren().add(emailList);
		
		// last Row 4 add buttons for navigation
		refreshButton = new Button("Refresh");
		refreshButton.getStyleClass().add(BUTTON_STYLE_LIGHT_GREEN);
		
		previousButton = new Button("Previous");
		previousButton.getStyleClass().add(BUTTON_STYLE_LIGHT_GREEN);
		
		nextButton = new Button("Next");
		nextButton.getStyleClass().add(BUTTON_STYLE_LIGHT_GREEN);
		
		
		
		lastRow.getChildren().addAll(refreshButton, previousButton, nextButton);
		centerContent.setPrefSize(780, 360);
		centerContent.getChildren().add(lastRow);

	}

	private Label createHeaderLabel(String labelText) {
		Label label = new Label(labelText);
		label.getStyleClass().add(MAIL_HEADER_FONT);
		label.setPrefSize(200, 20);
		return label;
	}

	private Button createTabs(String buttonText) {
		Button button = new Button(buttonText);
		button.getStyleClass().add(LIGHT_GREEN_TABS);
		return button;
	}

	private void setActiveMessageViewButton(String page) {
		row1.getChildren().forEach(node -> {
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

	public VBox getCenterView() {
		return centerContent;
	}
	public Button getInboxButton() {
	    return inboxButton;
	}

	public Button getSentButton() {
	    return sentButton;
	}

	public Button getDeletedButton() {
	    return deletedButton;
	}
	public Button getRefreshButton() {
	    return refreshButton;
	}

	public Button getPreviousButton() {
	    return previousButton;
	}

	public Button getNextButton() {
	    return nextButton;
	}

	public VBox getCenterContent() {
			return centerContent;
	}
	
}
