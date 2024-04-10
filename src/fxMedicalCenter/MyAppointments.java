package fxMedicalCenter;

import javafx.scene.layout.BorderPane;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MyAppointments {

	private BorderPane root; 
	private User currentUser;
	private Patient currentPatient; 
	private Visit currentVisit; 
    private TableView<Appointment> table = new TableView<Appointment>();
    private ObservableList<Appointment> data;
	
	public MyAppointments(User user, Visit visit) {
		currentUser = user;
		currentVisit = visit; 
		currentPatient = new Patient();
        currentPatient.setPatient(currentUser.getPatientID());
        
        data = FXCollections.observableArrayList();
        fillData();
		
        TableColumn<Appointment, String> dateCol = new TableColumn<>("Date");
//			dateCol.setCellValueFactory(new PropertyValueFactory<Visit, String>("Date"));
			
        //TableColumn timeCol = new TableColumn("Time");
        //TableColumn<Appointment, String> providerCol = new TableColumn<>("Provider");
        //TableColumn<Appointment, String> reasonCol = new TableColumn<>("Reason");

        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        //timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        //providerCol.setCellValueFactory(new PropertyValueFactory<>("provider"));
        //reasonCol.setCellValueFactory(new PropertyValueFactory<>("reason"));

        //table.getColumns().addAll(dateCol, timeCol, providerCol, reasonCol);
        table.getColumns().addAll(dateCol);

        // Set the columns to resize with the table
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setItems(data);

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
    
    public void fillData() {
    	Database db = new Database();
    	db.setQuery(Datatables.VISIT.get(), Columns.PATIENT_ID.get(), currentUser.getPatientID());
    	db.query();
    	
    	while(db.next()) {
    		data.add(new Appointment(new Visit(db.getInt(Columns.VISIT_ID.get()))));
    	}
    }

    // Define the Appointment class with properties
    public static class Appointment {
    	private final SimpleStringProperty date;
    	private Visit visit;

        public Appointment(Visit v) {
            visit = v;
            date = new SimpleStringProperty(visit.getDate().toString());         // this.time = time;
           // this.provider = provider;
           // this.reason = reason;
            
            
        }
        public void setDate(String newDate) {
        	date.set(newDate);
        }

        public void setTime() {
        }

        public void setProvider() {
        }

        public void setReason() {
        }

        public String getDate() {
            return date.get();
        }

        /*
        public String getTime() {
            return time;
        }

        public String getProvider() {
            return provider;
        }

        public String getReason() {
            return reason;
        }
        */
    }
}