package fxMedicalCenter;

import javafx.scene.layout.BorderPane;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MyAppiontments {

	private BorderPane root; 
	private User currentUser;
	private Patient currentPatient; 
	private Message currentAppiontments; 
	
	public MyAppiontments(User user) {
		currentUser = user; 
		currentPatient = new Patient(); 
		
		VBox top = new VBox();


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