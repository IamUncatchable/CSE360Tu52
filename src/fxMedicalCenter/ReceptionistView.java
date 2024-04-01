package fxMedicalCenter;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReceptionistView extends Application {

    private TableView patientTable = new TableView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Receptionist Dashboard");

        // Menu bar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(actionEvent -> System.exit(0));
        fileMenu.getItems().add(exitItem);
        menuBar.getMenus().add(fileMenu);

        // Table for patient data
        TableColumn<String, Patient> nameColumn = new TableColumn<>("Name");
        TableColumn<String, Patient> appointmentColumn = new TableColumn<>("Appointment Time");
        // ... add more columns as needed

        patientTable.getColumns().addAll(nameColumn, appointmentColumn);
        // ... add data to the table

        // Status bar
        Label statusLabel = new Label("Ready");
        HBox statusBar = new HBox(statusLabel);
        statusBar.setAlignment(Pos.CENTER);
        statusBar.setPadding(new Insets(5, 10, 5, 10));

        // Layout setup
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(patientTable);
        borderPane.setBottom(statusBar);

        // Scene setup
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Dummy Patient class for table view
    public static class Patient {
        private final SimpleStringProperty name;
        private final SimpleStringProperty appointmentTime;

        private Patient(String name, String appointmentTime) {
            this.name = new SimpleStringProperty(name);
            this.appointmentTime = new SimpleStringProperty(appointmentTime);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String fName) {
            name.set(fName);
        }

        public String getAppointmentTime() {
            return appointmentTime.get();
        }

        public void setAppointmentTime(String fName) {
            appointmentTime.set(fName);
        }
    }
}
