package fxMedicalCenter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public class MessagesController implements PaneProvider {
	ObservableList<Email> emailItems = FXCollections.observableArrayList();
	//private DashboardViewRefactor dashboardView;
    private ListView<Email> emailListView; 
    private DashboardBase dashBase;
    
	private MessagesView messagesView;
	private Database db;
	private User user;
	private int id; // FIXME remove
	private String messageBodyText;
	private String messageToText;
	private String messageFromText;
	private String messageDateText;

	
	// Constructor
	public MessagesController(MessagesView messagesView) {
		this.messagesView = messagesView;
        //setupEmailListView();

	}
	
	
	/*
	//this is broken and dumb does nothing.
    private void setupEmailListView() {
        // Assuming emailListView is already initialized...
        
        emailListView.setCellFactory(param -> new ListCell<Email>() {
            @Override
            protected void updateItem(Email item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    HBox hbox = new HBox(10); // Spacing between elements
                    Label subjectLabel = new Label(item.getSubject());
                    Label senderLabel = new Label(item.getSender());
                    Label dateLabel = new Label(item.getDate());

                    hbox.getChildren().addAll(subjectLabel, senderLabel, dateLabel);

                    // Set the click event for the entire row (HBox)
                    hbox.setOnMouseClicked(event -> handleEmailClick(item));

                    setGraphic(hbox);
                }
            }
        });
    }
    private void handleEmailClick(Email email) {
        // linked to class above an email is the item from updateItem() this is where the logic 
    	// of should happen when the button is clicked 1.)switch 
    	// to email view page and 2.) display sender followed by the text of the message
        
    } 
	    
	 
	public void setEmailData() {
		// I need some coaching on this part
		db.setQuery(DatatablesRefactored.MESSAGE.get(), Columns.PATIENT_ID.get(), id);
		db.query();
		while (db.next()) {
			String subject = db.getString(Columns.TEXT.get());
			String sender = db.getString(Columns.FROM.get());
			String date = db.getString(Columns.DATE.get());
			// Construct an Email object with the fetched data
			Email email = new Email(subject, sender, date);
			// Add Email object to ObservableList
			emailItems.add(email);
		}
	}
*/
	public void setCenter(Pane centerContent) {
		
    }

	
	

	@Override
	public Pane getPane() {
		Pane result = messagesView.getCenterContent();
		return result;
		
	}

	

}
