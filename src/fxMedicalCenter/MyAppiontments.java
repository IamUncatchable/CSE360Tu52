package fxMedicalCenter;

import javafx.scene.layout.BorderPane;

import java.time.LocalDate;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MyAppiontments {

	private BorderPane root; 
	private User currentUser;
	private Patient currentPatient; 
	private Message currentAppiontments; 
	private Visit currentVisit; 
    private TableView table = new TableView();

	
	public MyAppiontments(User user, Visit visit) {
		currentUser = user;
		currentVisit = visit; 
		currentPatient = new Patient();
        currentPatient.setPatient(currentUser.getPatientID());

        LocalDate appiontments = currentVisit.getDate();
		
        TableColumn<Appointment, String> dateCol = new TableColumn<>("Date");
//			dateCol.setCellValueFactory(new PropertyValueFactory<Visit, String>("Date"));
			
        TableColumn<Appointment, String> timeCol = new TableColumn<>("Time");
        TableColumn<Appointment, String> providerCol = new TableColumn<>("Provider");
        TableColumn<Appointment, String> reasonCol = new TableColumn<>("Reason");

        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        providerCol.setCellValueFactory(new PropertyValueFactory<>("provider"));
        reasonCol.setCellValueFactory(new PropertyValueFactory<>("reason"));

        table.getColumns().addAll(dateCol, timeCol, providerCol, reasonCol);

        // Set the columns to resize with the table
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		VBox top = new VBox();
		top.getChildren().add(table); 
		
        root = new BorderPane();
        root.getStyleClass().add("dashboard-background-off-white");
        root.setTop(top);
    }

    public void setView() {

    }

    public BorderPane getView() {
        return root;
    }

    // Define the Appointment class with properties
    public static class Appointment {
        private final String date;
        private final String time;
        private final String provider;
        private final String reason;

        public Appointment(String date, String time, String provider, String reason) {
            this.date = date;
            this.time = time;
            this.provider = provider;
            this.reason = reason;
            
            
        }
        public void setDate() {
        }

        public void setTime() {
        }

        public void setProvider() {
        }

        public void setReason() {
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        public String getProvider() {
            return provider;
        }

        public String getReason() {
            return reason;
        }
    }
}